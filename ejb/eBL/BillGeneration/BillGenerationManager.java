/*
Sr No        Version           TFS/Incident        SCF/CRF            		 	Developer Name
--------------------------------------------------------------------------------------------------------
1            V210129            13523         MOHE-CRF-0060       				Shikha Seth
--------------------------------------------------------------------------------------------------------
 */
package eBL.BillGeneration;

import java.rmi.RemoteException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.sql.Types;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.StringTokenizer;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import javax.servlet.http.HttpSession;

import oracle.sql.ARRAY;
import oracle.sql.ArrayDescriptor;
import oracle.sql.STRUCT;
import oracle.sql.StructDescriptor;

import webbeans.eCommon.ConnectionManager;

import eBL.Common.BlRepository;
import eBL.billreceipt.model.BLBillGenInterfaceBean;
import eBL.billreceipt.model.BillReceiptExclusionDiscount;
import eBL.billreceipt.model.BillReceiptExistOrderExclusion;
import eBL.billreceipt.model.BillReceiptPackageInfo;
import eBL.billreceipt.request.BillGenerationRequest;
import eBL.billreceipt.request.BillReceiptRequest;
import eBL.billreceipt.response.BillGenerationResponse;
import eBL.placeorder.request.PlaceNewOrderRequest;
import eBL.billreceipt.model.*;


/**
 * 
 * @ejb.bean 
 * 	name="BillGeneration" 
 * 	type="Stateless" 
 * 	transaction-type="Bean"
 *  view-type="both" 
 *  jndi-name="BillGeneration"
 *  local-jndi-name="BillGeneration"
 *  impl-class-name="eBL.BillGeneration.BillGenerationManager"
 * 
 * 
 * @ejb.interface 
 * 	extends="javax.ejb.EJBObject"
 *  local-extends="javax.ejb.EJBLocalObject"
 *  local-class="eBL.BillGeneration.BillGenerationLocal"
 *  remote-class="eBL.BillGeneration.BillGenerationRemote"
 *  generate= "local,remote"
 * 
 * @ejb.home 
 * 	extends="javax.ejb.EJBHome" 
 * 	local-extends="javax.ejb.EJBLocalHome"
 *  local-class="eBL.BillGeneration.BillGenerationLocalHome"
 *  remote-class="eBL.BillGeneration.BillGenerationHome" 
 *  generate= "local,remote"
 * 
 */
public class BillGenerationManager implements SessionBean {

	SessionContext ctx;
	
	public void ejbCreate() {
	}

	public void ejbRemove() {
	}

	public void ejbActivate() {
	}

	public void ejbPassivate() {
	}

	public void setSessionContext(SessionContext context) {
		this.ctx = context;
	}
	
	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/
	
	public BillGenerationResponse generateBills(BillGenerationRequest billGenRequest, BillReceiptExistOrderExclusion exclusionBean){
		BillGenerationResponse billGenResponse = new BillGenerationResponse();
		Connection con = null;
		CallableStatement cstmt = null;
		List<String> errorList = new ArrayList<String>();
		
		try{
			con = ConnectionManager.getConnection();
			int totalRows = 0;
			try{
				totalRows = Integer.parseInt(billGenRequest.getTotalCount());
			}
			catch(Exception tR){
				totalRows = 0;
			}
			if(totalRows > 0){
				String pkgSeqNo=billGenRequest.getPkgSeqNo();
				String packageCode=billGenRequest.getPackageCode();
			  	StringTokenizer pkgSeqNum = new StringTokenizer(pkgSeqNo,",");
			  	StringTokenizer pkgCode = new StringTokenizer(packageCode,",");
			  	String packageSeqNum ="";
			  	String pkg_code ="";
				BillReceiptRequest billRequest = new BillReceiptRequest();
				List<BillReceiptPackageInfo> pkgList = new ArrayList<BillReceiptPackageInfo>();
				BillReceiptPackageInfo pkgBean = null;
				billRequest.setFacilityId(billGenRequest.getFacilityId());
				billRequest.setPatientId(billGenRequest.getPatientId());
				billRequest.setEpisodeType(billGenRequest.getEpisodeType());
				billRequest.setEpisodeId(billGenRequest.getEpisodeId());
				billRequest.setVisitId(billGenRequest.getVisitId());
				billRequest.setClientIpAddress(billGenRequest.getClientIpAddress());
				billRequest.setLoginUser(billGenRequest.getLoginUser());
				while (pkgSeqNum.hasMoreTokens()){
	                packageSeqNum =pkgSeqNum.nextToken();
	                pkg_code =pkgCode.nextToken();
              //  for(int i=1;i<=totalRows;i++){
	    				pkgBean = new BillReceiptPackageInfo();
	    				
	    				pkgBean.setPkgSeqNo(packageSeqNum);
	    				pkgBean.setPackageCode(pkg_code);
	    			
	    				pkgList.add(pkgBean);
	    				
	    				
    		//	}
			
			}
			billRequest.setPkgList(pkgList);
			errorList = closePackage(billRequest,pkgBean,con);	
			}
			
			if(errorList.isEmpty()){
			errorList = insertExcludedServices(billGenRequest,exclusionBean,con);
			if(errorList.isEmpty()){
				cstmt = con.prepareCall(BlRepository.getBlKeyValue("BILL_GENERATE_MAIN"));
				//cstmt.setString(1, billGenRequest.getFacilityId()); //V210129 Commented
				cstmt.setString(1, billGenRequest.getEncounterFacilityId()); //V210129 Added
				cstmt.setString(2, billGenRequest.getPatientId());
				cstmt.setString(3, billGenRequest.getEpisodeType());
				cstmt.setString(4, billGenRequest.getEpisodeId());
				cstmt.setString(5, billGenRequest.getVisitId());
				cstmt.setString(6, billGenRequest.getCashCntrCode());
				cstmt.setString(7, billGenRequest.getShiftId());
				cstmt.setString(8, billGenRequest.getPrevUnBilled());
				//cstmt.setString(9, null);
				cstmt.setString(9, billGenRequest.getFacilityId());
				cstmt.setString(10, billGenRequest.getEncounterId());
				cstmt.setString(11, billGenRequest.getLoginUser());
				cstmt.setString(12, billGenRequest.getClientIpAddress());
				cstmt.setString(13, null);
				cstmt.setString(14, billGenRequest.getServLocn());
				cstmt.setString(15, billGenRequest.getDepAdjYn());
				cstmt.setString(16, billGenRequest.getPrePayAdjYn());
				
				cstmt.setString(17, billGenRequest.getMinDepAdjYn());
				cstmt.setString(18, billGenRequest.getPkgSeqNo());
				cstmt.setString(19, billGenRequest.getDocAmt());
				cstmt.setString(20, billGenRequest.getVstTypeCode());
				cstmt.setString(21, billGenRequest.getPkgClosedYn());
				cstmt.setString(22, null);
				cstmt.setString(23, billGenRequest.getLocale());
				cstmt.setString(24, billGenRequest.getSlmtAmt());
				cstmt.setString(25, billGenRequest.getBillGenOpt());
				cstmt.setString(26, billGenRequest.getBillGenType());
				cstmt.registerOutParameter(27, Types.VARCHAR);
				cstmt.registerOutParameter(28, Types.VARCHAR);
				cstmt.registerOutParameter(29, Types.VARCHAR);
				cstmt.registerOutParameter(30, Types.VARCHAR);
				cstmt.registerOutParameter(31, Types.VARCHAR);
				cstmt.registerOutParameter(32, Types.VARCHAR);
				cstmt.registerOutParameter(33, Types.VARCHAR);
				cstmt.registerOutParameter(34, Types.VARCHAR);
				cstmt.registerOutParameter(35, Types.VARCHAR);
				cstmt.registerOutParameter(36, Types.VARCHAR);
				cstmt.registerOutParameter(37, Types.VARCHAR);
				cstmt.registerOutParameter(46, Types.VARCHAR);
				cstmt.registerOutParameter(47, Types.VARCHAR);
				cstmt.registerOutParameter(48, Types.VARCHAR);
				cstmt.registerOutParameter(49, Types.VARCHAR);
				cstmt.registerOutParameter(50, Types.VARCHAR);
				cstmt.registerOutParameter(51, Types.VARCHAR);
				cstmt.registerOutParameter(52, Types.VARCHAR);
				cstmt.setString(38, billGenRequest.getAltIdType());
				cstmt.setString(39, billGenRequest.getAltIdNo());
				cstmt.setString(40, billGenRequest.getPatientName());
				cstmt.setString(41, billGenRequest.getRemarks());
				cstmt.setString(42, billGenRequest.getExemptType());
				cstmt.setString(43, billGenRequest.getExemptAmt());
				cstmt.setString(44, billGenRequest.getAssignTo());
				cstmt.setString(45, billGenRequest.getIpBillType());
				
				cstmt.execute();
				billGenResponse.setUnProcessedExists(cstmt.getString(27));
				billGenResponse.setBillDocTypeCode(cstmt.getString(28));
				billGenResponse.setReceiptDocTypeCode(cstmt.getString(29));
				billGenResponse.setRefundDocTypeCode(cstmt.getString(30));
				billGenResponse.setPatDocType(cstmt.getString(31));
				billGenResponse.setPatDocNum(cstmt.getString(32));
				billGenResponse.setGeneratedBillS(cstmt.getString(33));
				billGenResponse.setBillPrintYn(cstmt.getString(48));
				billGenResponse.setSession_id(cstmt.getString(49));
				billGenResponse.setPgm_id(cstmt.getString(50));
				billGenResponse.setPgm_date(cstmt.getString(51));
				String str_error_level = cstmt.getString(34);
				String str_sysmesage_id = cstmt.getString(35);
				String str_error_text = cstmt.getString(36);
				String invokeSlmtScreen = cstmt.getString(37);
				
				billGenResponse.setSlmtValidationMsg(cstmt.getString(52));
				billGenResponse.setExemptWarning(cstmt.getString(46));
				billGenResponse.setExemptConsWarning(cstmt.getString(47));

				System.err.println("str_error_level->"+str_error_level);
				System.err.println("str_sysmesage_id->"+str_sysmesage_id);
				System.err.println("str_error_text->"+str_error_text);
				System.err.println("setGeneratedBillS->"+cstmt.getString(30));
				Locale loc = new Locale(billGenRequest.getLocale());
				ResourceBundle rb = ResourceBundle.getBundle("eBL.resources.Messages",loc);
				if(str_error_level!=null || str_error_text!=null){
					errorList.add(str_error_text);
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
				billGenResponse.setErrorList(errorList);
				billGenResponse.setInvokeSlmt(invokeSlmtScreen);
				
				if(errorList.isEmpty()){
					con.commit();
				}
				else{
					con.rollback();
				}
			}
			else{
				billGenResponse.setErrorList(errorList);
			}
		}
			else{
				billGenResponse.setErrorList(errorList);
			}
			
		}
		catch(Exception e){
			System.err.println("Exception in generate Bills EJB ->"+e);
		}
		finally{
			cstmt = null;
			ConnectionManager.returnConnection(con);
		}
		return billGenResponse;
	}
	
	
	
	public List<String> closePackage(BillReceiptRequest billRequest,BillReceiptPackageInfo pkgBean,Connection conn){
		List<String> errorList = new ArrayList<String>();
		Locale loc = new Locale(billRequest.getLocale());
		ResourceBundle rb = ResourceBundle.getBundle("eBL.resources.Messages",loc);
		//Connection con = null;
		CallableStatement cstmt = null;
		ResultSet rst = null;

		try{
			//con = ConnectionManager.getConnection();
			List<BillReceiptPackageInfo> pkgList = billRequest.getPkgList();
			StructDescriptor pkgStructDesc = StructDescriptor.createDescriptor("IBAEHIS.T_PKG_DTLS_REC", conn);
			ArrayDescriptor pkgArrDesc = ArrayDescriptor.createDescriptor("IBAEHIS.T_PKG_DTLS_TAB", conn);					
			
			int totalRec = pkgList.size();
			System.out.println("size:::::::::+++++111= "+ pkgList.size());
			Object[] pkgArray = new Object[totalRec];  // to store n number of object data
		    Object[] pkgObj   = new Object[9];  // to store object data
			int recNo = 0;
			for (Iterator iterator = pkgList.iterator(); iterator.hasNext();) {
				 pkgBean = (BillReceiptPackageInfo) iterator.next();
				pkgObj[0] = billRequest.getFacilityId();
				pkgObj[1] = billRequest.getPatientId();
				System.out.println(" billRequest.getFacilityId()= "+billRequest.getFacilityId());
				System.out.println("billRequest.getPatientId()= "+billRequest.getPatientId());
				System.out.println("billRequest.getEpisodeId()= "+billRequest.getEpisodeId());
				System.out.println("billRequest.getVisitId()= "+billRequest.getVisitId());
				System.out.println("billRequest.getLoginUser()= "+billRequest.getLoginUser());
				System.out.println("billRequest.getClientIpAddress()= "+billRequest.getClientIpAddress());
				System.out.println("billRequest.getPatientId()= "+billRequest.getEpisodeType());
				//System.out.println("billRequest.getPatientId()= "+billRequest.getLoginUser());
				
				System.out.println("getPkgSeqNo:::::::::+++++111"+pkgBean.getPkgSeqNo());
				System.out.println("getPackageCode:::::::::+++++222"+pkgBean.getPackageCode());
				
				if("".equals(pkgBean.getPkgSeqNo()) || pkgBean.getPkgSeqNo()== null){
					pkgObj[2] = null;
				}
				else{
					pkgObj[2] = pkgBean.getPkgSeqNo();
					System.out.println("pkgParamArray:::::::::+++++"+pkgBean.getPkgSeqNo());
				}
				
				if("".equals(pkgBean.getPackageCode()) || pkgBean.getPackageCode()== null){
					pkgObj[3] = null;
				}
				else{
					pkgObj[3] = pkgBean.getPackageCode();
					System.out.println("pkgParamArray:::::::::+++++"+pkgBean.getPackageCode());
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
				
				
				STRUCT pkgObjStruct = new STRUCT(pkgStructDesc,conn, pkgObj);
				pkgArray[recNo]=pkgObjStruct;
				recNo++;
			} 
			
			ARRAY pkgParamArray = new ARRAY(pkgArrDesc,conn,pkgArray); 
			cstmt = conn.prepareCall("{ call bl_get_bill_gen_dtls.bl_package_closure(?,?,?,?,?,?,?,?,?,?,?,?,?) }");
			cstmt.setArray(1, pkgParamArray);
			System.out.println("pkgParamArray:::::::::+++++"+pkgParamArray);
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
							msgArr[l] = getMessageString(msgArr[l],conn);
							System.err.println("Exceprion in RB ->"+rbException);
						}
						errorList.add(msgArr[l]);
					}
				}else{

					try{
						str_sysmesage_id = rb.getString(str_sysmesage_id);
					}
					catch(Exception rbException){
						str_sysmesage_id = getMessageString(str_sysmesage_id,conn);
						System.err.println("Exceprion in RB ->"+rbException);
					}
					errorList.add(str_sysmesage_id);
				}
			}
			
			if(errorList.isEmpty()){
				//con.commit();
			}
			else{
				conn.rollback();
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
		//	ConnectionManager.returnConnection(conn);
		}
		return errorList;
	}
	
	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/

	public List<String> processInterfaceRecords(BLBillGenInterfaceBean bean)
	{
		List<String> errorList=new ArrayList<String>();
		List<BLBillGenInterfaceBean> processList=bean.getRequestList();
		Connection con = null;
		CallableStatement cstmt = null;
		ResultSet rst = null;
		String facilityId="";
		String locale="";
		String userId="";
		String wsNo="";
		String episodeType="";

		
		String errorId="";
		String errorLevel="";
		String errorText="";
		try
		{
			con=ConnectionManager.getConnection();
			
			System.out.println("before iterator");
			for(Iterator iterator=processList.iterator();iterator.hasNext();)
			{
				BLBillGenInterfaceBean intrfaceBean=(BLBillGenInterfaceBean) iterator.next();
				System.out.println("interface bean"+intrfaceBean);
				System.out.println("pkey mod id in impl "+intrfaceBean.getPrimaryKeyModuleId());
				System.out.println("pkey main"+intrfaceBean.getPrimaryKeyMain());
				System.out.println("sec module id"+intrfaceBean.getSecondaryKeyModuleId());
				System.out.println("sec key main "+intrfaceBean.getSecondaryKeyMain());
				System.out.println("sec line "+intrfaceBean.getSecondaryKeyLine());
				System.out.println("epi type "+episodeType);
				System.out.println("patid"+intrfaceBean.getPatientId());
				System.out.println("episode id "+intrfaceBean.getEpisodeId());
				System.out.println("visit id "+intrfaceBean.getVisitId());
				System.out.println("locale "+locale);
				System.out.println("use5r id "+userId);
				System.out.println("ws no "+wsNo);
				System.out.println("facilityId "+facilityId);
				facilityId=intrfaceBean.getFacilityId();
				locale=intrfaceBean.getLocale();
				userId=intrfaceBean.getUserId();
				wsNo=intrfaceBean.getWorkStationNo();
				episodeType=intrfaceBean.getEpisodeType();
				
				
				
			cstmt=con.prepareCall("{call blplaceservice.process_future_order(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			cstmt.setString(1,facilityId);
			cstmt.setString(2,intrfaceBean.getPrimaryKeyModuleId());
			cstmt.setString(3,intrfaceBean.getPrimaryKeyMain());
			cstmt.setString(4,intrfaceBean.getSecondaryKeyModuleId());
			cstmt.setString(5,intrfaceBean.getSecondaryKeyMain());
			cstmt.setString(6,intrfaceBean.getSecondaryKeyLine());
			cstmt.setString(7,intrfaceBean.getEpisodeType());
			cstmt.setString(8,intrfaceBean.getPatientId());
			if(intrfaceBean.getEpisodeId() == null || "".equals(intrfaceBean.getEpisodeId())){
				cstmt.setString(9,null);
			}else{
				cstmt.setInt(9,Integer.parseInt(intrfaceBean.getEpisodeId()));
			}
			if(intrfaceBean.getVisitId() == null || "".equals(intrfaceBean.getVisitId())){
				cstmt.setString(10,null);
			}else{
				cstmt.setInt(10,Integer.parseInt(intrfaceBean.getVisitId()));
			}
			
			
			cstmt.setString(11,locale);
			cstmt.setString(12,userId);
			cstmt.setString(13,wsNo);
			cstmt.registerOutParameter(14, Types.VARCHAR);
			cstmt.registerOutParameter(15, Types.VARCHAR);
			cstmt.registerOutParameter(16, Types.VARCHAR);
			cstmt.execute();
			errorLevel=cstmt.getString(14);
			 errorId=cstmt.getString(15);
			 errorText=cstmt.getString(16);
			System.out.println("errorId / errorLevel  / errorText"+ errorId +"/" + errorLevel +"/" + errorText);	
		
			
			
			
			}

			Locale loc = new Locale(locale);
			ResourceBundle rb = ResourceBundle.getBundle("eBL.resources.Messages",loc);
			
			if(errorLevel!=null || errorText!=null){
				errorList.add(errorText);
			}

			if(errorId!=null){
				if(errorId.contains("|")){
					String msgArr[] = errorId.split("\\|");
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
						errorId = rb.getString(errorId);
					}
					catch(Exception rbException){
						errorId = getMessageString(errorId,con);
						System.err.println("Exceprion in RB ->"+rbException);
					}
					errorList.add(errorId);
				}
			}
		//	billGenResponse.setErrorList(errorList);
			
			if(errorList.isEmpty()){
				con.commit();
			}
			else{
				con.rollback();
			}

		
		
		}catch(Exception e)
		{
			System.err.println("Exception in processInterfaceRecords"+e);
			e.printStackTrace();
		}
		finally{
			
			cstmt=null;
			ConnectionManager.returnConnection(con);
		}
		
		return errorList;
	}
	
	
	
	public List<String> insertExcludedServices(BillGenerationRequest bean,BillReceiptExistOrderExclusion exclusionData,Connection conn) {		
		CallableStatement cstmt = null;
		List<String> errorList = new ArrayList<String>();
		Locale loc = new Locale(bean.getLocale());
		ResourceBundle rb = ResourceBundle.getBundle("eBL.resources.Messages",loc);
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
			cstmt.setString(6, bean.getServLocn());
			cstmt.setString(7, null);
			cstmt.registerOutParameter(8, Types.VARCHAR);
			cstmt.registerOutParameter(9, Types.VARCHAR);
			cstmt.registerOutParameter(10, Types.VARCHAR);
			cstmt.execute();
			System.err.println(cstmt.getString(8));
			System.err.println(cstmt.getString(9));
			System.err.println(cstmt.getString(10));
			
			String str_error_level = cstmt.getString(8);
			String str_sysmesage_id = cstmt.getString(9);
			String str_error_text = cstmt.getString(10);

			
			
			if(str_error_level!=null || str_error_text!=null){
				errorList.add(str_error_text);
			}

			if(str_sysmesage_id!=null){
				if(str_sysmesage_id.contains("|")){
					String msgArr[] = str_sysmesage_id.split("\\|");
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
						str_sysmesage_id = rb.getString(str_sysmesage_id);
					}
					catch(Exception rbException){
						str_sysmesage_id = getMessageString(str_sysmesage_id,conn);
						System.err.println("Exceprion in RB ->"+rbException);
					}
					errorList.add(str_sysmesage_id);
				}
			}
		}
		
		catch(Exception e){
			System.err.println("Exception in insertExcludedServices ->"+e);
		}
		finally{
			cstmt = null;
			rb = null;
			loc = null;
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

}
