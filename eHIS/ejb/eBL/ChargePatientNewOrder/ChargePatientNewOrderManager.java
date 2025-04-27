/*
Sr No        Version           Incident			SCF/CRF             Developer Name
-----------------------------------------------------------------------------------
1            V210413			17021        Common-ICN-0009-TF         MuthukumarN
-----------------------------------------------------------------------------------
 */

package eBL.ChargePatientNewOrder;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.sql.Types;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import javax.servlet.http.HttpSession;

import webbeans.eCommon.ConnectionManager;

import eBL.placeorder.model.BLChargePatientExistingOrderBean;
import eBL.placeorder.model.BLChargePatientNewOrderBean;
import eBL.placeorder.request.PlaceNewOrderRequest;
import eBL.placeorder.response.PlaceNewOrderResponse;

/**
 * 
 * @ejb.bean 
 * 	name="ChargePatientNewOrder" 
 * 	type="Stateless" 
 * 	transaction-type="Bean"
 *  view-type="both" 
 *  jndi-name="ChargePatientNewOrder"
 *  local-jndi-name="ChargePatientNewOrder"
 *  impl-class-name="eBL.ChargePatientNewOrder.ChargePatientNewOrderManager"
 * 
 * 
 * @ejb.interface 
 * 	extends="javax.ejb.EJBObject"
 *  local-extends="javax.ejb.EJBLocalObject"
 *  local-class="eBL.ChargePatientNewOrder.ChargePatientNewOrderLocal"
 *  remote-class="eBL.ChargePatientNewOrder.ChargePatientNewOrderRemote"
 *  generate= "local,remote"
 * 
 * @ejb.home 
 * 	extends="javax.ejb.EJBHome" 
 * 	local-extends="javax.ejb.EJBLocalHome"
 *  local-class="eBL.ChargePatientNewOrder.ChargePatientNewOrderLocalHome"
 *  remote-class="eBL.ChargePatientNewOrder.ChargePatientNewOrderHome" 
 *  generate= "local,remote"
 * 
 */


public class ChargePatientNewOrderManager implements SessionBean {
	
	
	SessionContext ctx;
	
	String facilityId="";
	String client_ip_address="";
	String login_user="";
	String str_error_level = "", str_sysmesage_id="", str_error_text="", sys_warning_message="";
	HttpSession session; 
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

	Locale loc = null;
	ResourceBundle rb = null;

	boolean insertable = false;

	String locale = "";
	List<String> errorList = null;
	List<String> warningList = null;
	PlaceNewOrderResponse response = null;
	
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
	
	
	public PlaceNewOrderResponse recordBLCharges(PlaceNewOrderRequest requestBean) 
	{		
		response = new PlaceNewOrderResponse();
		Connection con = null;

		CallableStatement cstmt = null;

		try{
			con = ConnectionManager.getConnection();
			locale = requestBean.getLocale() ;
			login_user = requestBean.getLoginUser();
			facilityId = requestBean.getFacilityId();
			client_ip_address = requestBean.getClientIpAddress();
			loc = new Locale(locale);
			rb = ResourceBundle.getBundle("eBL.resources.Messages",loc);
			BLChargePatientNewOrderBean chargeBean = new BLChargePatientNewOrderBean();
			chargeBean = requestBean.getNewOrderBean();
			
			String recordBlServ =  "{ call blplaceservice.record_bl_serv(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }";
			String recordBlPanel = "{ call blplaceservice.record_bl_panel(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }";
			//String recordBlpackage = "{ call blplaceservice.record_bl_package(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }"; //unused  variable V210413
			boolean gotoNext = true;
			ArrayList<BLChargePatientNewOrderBean> chargeList = chargeBean.getServicesList();
			//Calendar cal = Calendar.getInstance(); //unused variable V210413
			//java.util.Date dt = cal.getTime(); //unused varible 	V210413
			errorList = new ArrayList<String>();
			if(chargeList != null){
				for (Iterator iterator = chargeList.iterator(); iterator.hasNext();) {
					if(gotoNext){
					BLChargePatientNewOrderBean bean = (BLChargePatientNewOrderBean) iterator.next();
					if("S".equals(bean.getServOrPanel())){
						cstmt = con.prepareCall(recordBlServ);
					}
					else if("L".equals(bean.getServOrPanel())){
						cstmt = con.prepareCall(recordBlPanel);
						bean.setBlngServCode(bean.getPanelString());
					}
					cstmt.setString(1,"DCF");
					cstmt.setString(2,facilityId);
					cstmt.setString(3,chargeBean.getEpisodeType());
					cstmt.setString(4,chargeBean.getPatientId());
					cstmt.setString(5,chargeBean.getEpisodeId());
					cstmt.setString(6,chargeBean.getVisitId());
					cstmt.setString(7,chargeBean.getEncounterId());
					cstmt.setString(8,chargeBean.getAcctSeqNo());
					cstmt.setString(9,null);
					
					cstmt.setString(10,null);
					cstmt.setString(11,"BL");
					cstmt.setString(12,null);
					cstmt.setString(13,null);
					cstmt.setString(14,bean.getServOrPanel());
					cstmt.setString(15,bean.getBlngServCode());
					
					cstmt.setString(16,"DCF");
					cstmt.setString(17,null);
					cstmt.setString(18,null);
					cstmt.setString(19,bean.getQuantity());
					cstmt.setString(20,bean.getBaseChargeAmt());
					cstmt.setString(21,bean.getDrName());
					
					cstmt.setTimestamp(22, new Timestamp(sdf.parse(bean.getDateTime()).getTime()));
					cstmt.setString(23,bean.getQuantity());
					cstmt.setString(24,bean.getUomCode());
					cstmt.setString(25,bean.getPractStaffInd());
					cstmt.setString(26,bean.getPolicyIncl());
					cstmt.setString(27,bean.getAdhocReason());
					cstmt.setString(28,login_user);					
					cstmt.setString(29,client_ip_address);
					//cstmt.setString(28,bean.getLoginById());					
					//cstmt.setString(29,bean.getLoginAtWsNo());
					
					cstmt.setString(30,null);
					
					cstmt.setString(31,null);
					cstmt.setString(32,bean.getRemarks());
					cstmt.setString(33,null);					
					cstmt.setString(34,null);
					cstmt.setString(35,null);					
					cstmt.setString(36,null);
					cstmt.setString(37,null);					
					cstmt.setString(38,null);
					cstmt.setString(39, bean.getCustGroup());
					cstmt.setString(40, bean.getCust());
					cstmt.setString(41, bean.getPolicyCode());
					cstmt.setString(42, bean.getPolicyNum());
					cstmt.setString(43, replaceNull(bean.getPriority()));
					cstmt.setString(44, bean.getDiscExists());
					cstmt.setString(45, bean.getAdhocAmount());
					cstmt.setString(46, bean.getAdhocReason());
					cstmt.setString(47, login_user);
					cstmt.registerOutParameter(48, Types.VARCHAR);
					cstmt.registerOutParameter(49, Types.VARCHAR);
					cstmt.registerOutParameter(50, Types.VARCHAR);
					
					cstmt.execute();
					str_error_level = cstmt.getString(48);
					str_sysmesage_id = cstmt.getString(49);
					str_error_text = cstmt.getString(50);

					
					
					if(str_error_level!=null || str_error_text!=null){
						errorList.add(str_error_text);
						gotoNext = false;
					}

					if(str_sysmesage_id!=null){
						gotoNext = false;
						if(str_sysmesage_id.contains("|")){
							String msgArr[] = str_sysmesage_id.split("\\|");
							for(int l=0;l<msgArr.length;l++){


								try{
									msgArr[l] = rb.getString(msgArr[l]);
								}
								catch(Exception rbException){
									msgArr[l] = getMessageString(msgArr[l],con);
									System.err.println("Exceprion in RB 228 ->"+rbException);
									rbException.printStackTrace();
								}
								errorList.add(msgArr[l]);
							}
						}else{

							try{
								str_sysmesage_id = rb.getString(str_sysmesage_id);
							}
							catch(Exception rbException){
								str_sysmesage_id = getMessageString(str_sysmesage_id,con);
								System.err.println("Exceprion in RB 240->"+rbException);
								rbException.printStackTrace();
							}
							errorList.add(str_sysmesage_id);
						}
					}
				}
				}
			}
			
			if (errorList.isEmpty()) {
				con.commit();
			}
			else 
			{
				con.rollback();
				
			}
			if(cstmt != null)
				cstmt.close(); // added close statement  100321
		}
		catch(Exception e){
			try{
				con.rollback();
			}
			catch(Exception e1){
				e1.printStackTrace();				
			}
		}
		finally{
				
				response.setErrorList(errorList);
			
				ConnectionManager.returnConnection(con);
		}
		
		return response;
	}

/**
	* @ejb.interface-method
	*	 view-type="both"
	*/	
	public PlaceNewOrderResponse cancelBLServ(PlaceNewOrderRequest requestBean) 
	{		
		response = new PlaceNewOrderResponse();
		Connection con = null;

		CallableStatement cstmt = null;

		try{
			con = ConnectionManager.getConnection();
			locale = requestBean.getLocale() ;
			login_user = requestBean.getLoginUser();
			facilityId = requestBean.getFacilityId();
			client_ip_address = requestBean.getClientIpAddress();
			loc = new Locale(locale);
			rb = ResourceBundle.getBundle("eBL.resources.Messages",loc);
			BLChargePatientExistingOrderBean bean = new BLChargePatientExistingOrderBean();
			bean = requestBean.getExistingOrderBean();
			String cancelBlServ =  "{ call blplaceservice.cancel_bl_serv(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }";
			String cancelBlPanel = "{ call blplaceservice.cancel_bl_panel(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }";
			//String cancelBlpackage = "{ call blplaceservice.cancel_bl_package(?,?,?,?,?,?,?,?) }"; //unused variable V210413
			Calendar cal = Calendar.getInstance();
			java.util.Date dt = cal.getTime();
			if(bean != null){

				if("S".equals(bean.getServOrPanel())){
					cstmt = con.prepareCall(cancelBlServ);
				}
				else if("L".equals(bean.getServOrPanel())){
					cstmt = con.prepareCall(cancelBlPanel);
					bean.setServCode(getPanelStr(bean.getServCode(), con));
				}
				
				System.err.println("1 "+"CAN");
				System.err.println("2 "+facilityId);
				System.err.println("3 "+bean.getEpisodeType());
				System.err.println("4 "+bean.getPatientId());
				System.err.println("5 "+bean.getEpisodeId());
				System.err.println("6 "+bean.getVisitId());
				System.err.println("7 "+bean.getEncounterId());
				System.err.println("8 "+bean.getAcctSeqNo());
				System.err.println("9 "+bean.getOrderId());
				System.err.println("10 "+bean.getOrderLineNum());
				System.err.println("11 "+bean.getSubModuleId());
				System.err.println("12 "+bean.getSubRegnNum());
				
				System.err.println("13 "+bean.getSubRegnLineNum());
				System.err.println("14 "+bean.getServOrPanel());
				System.err.println("15 "+bean.getServCode());
				
				System.err.println("16 "+"CAN");
				System.err.println("17 "+bean.getItemCode());
				System.err.println("18 "+bean.getItemDesc());
				System.err.println("19 "+bean.getServQty());
				System.err.println("20 "+bean.getNetCharge());
				System.err.println("21 "+bean.getPhysicianId());
				System.err.println("22 "+new Date(dt.getTime()));
				System.err.println("23 "+bean.getServedpanelQty());
				System.err.println("24 "+bean.getUomCode());
				
				System.err.println("25 "+bean.getPractStaffInd());
				System.err.println("26 "+bean.getInclExclInd());
				System.err.println("27 "+bean.getReason());
				System.err.println("28 "+login_user);
				System.err.println("29 "+client_ip_address);
				System.err.println("30 "+bean.getFutureOrder());
				System.err.println("31 "+bean.getFutureOrderChargeLater());
				System.err.println("32 "+bean.getRemarks());
				System.err.println("33 "+bean.getPackInd());
				System.err.println("34 "+bean.getDailyProcessInd());
				System.err.println("35 "+bean.getBedTypeCode());
				System.err.println("36 "+bean.getTokenSerial());
				System.err.println("37 "+bean.getTokenSerialNo());
				System.err.println("38 "+bean.getDispLocn());
				
				cstmt.setString(1,"CAN");
				cstmt.setString(2,facilityId);
				cstmt.setString(3,bean.getEpisodeType());
				cstmt.setString(4,bean.getPatientId());
				cstmt.setString(5,bean.getEpisodeId());
				cstmt.setString(6,bean.getVisitId());
				cstmt.setString(7,bean.getEncounterId());
				cstmt.setString(8,replaceNull(bean.getAcctSeqNo()));
				cstmt.setString(9,replaceNull(bean.getOrderId()));
					
				cstmt.setString(10,replaceNull(bean.getOrderLineNum()));
				cstmt.setString(11,bean.getSubModuleId());
				if("".equals(replaceNull(bean.getSubRegnNum()))){
					cstmt.setString(12,replaceNull(bean.getOrderId()));
				}
				else{
					cstmt.setString(12,replaceNull(bean.getSubRegnNum()));
				}
				if("".equals(replaceNull(bean.getSubRegnLineNum()))){
					cstmt.setString(13,replaceNull(bean.getOrderLineNum()));
				}
				else{
					cstmt.setString(13,replaceNull(bean.getSubRegnLineNum()));
				}

				cstmt.setString(14,replaceNull(bean.getServOrPanel()));
				cstmt.setString(15,replaceNull(bean.getServCode()));
					
				cstmt.setString(16,"CAN");
				cstmt.setString(17,replaceNull(bean.getItemCode()));
				cstmt.setString(18,replaceNull(bean.getItemDesc()));
				cstmt.setString(19,replaceNull(bean.getServQty()));
				cstmt.setString(20,replaceNull(bean.getNetCharge()));
				cstmt.setString(21,replaceNull(bean.getPhysicianId()));
					
				cstmt.setDate(22, new Date(dt.getTime()));
				cstmt.setString(23,replaceNull(bean.getServedpanelQty()));
				cstmt.setString(24,replaceNull(bean.getUomCode()));
				cstmt.setString(25,replaceNull(bean.getPractStaffInd()));
				cstmt.setString(26,replaceNull(bean.getInclExclInd()));
				cstmt.setString(27,replaceNull(bean.getReason()));
				cstmt.setString(28,login_user);					
				cstmt.setString(29,client_ip_address);
				cstmt.setString(30,replaceNull(bean.getFutureOrder()));
					
				cstmt.setString(31,replaceNull(bean.getFutureOrderChargeLater()));
				cstmt.setString(32,replaceNull(bean.getRemarks()));
				cstmt.setString(33,replaceNull(bean.getPackInd()));					
				cstmt.setString(34,replaceNull(bean.getDailyProcessInd()));
				cstmt.setString(35,replaceNull(bean.getBedTypeCode()));					
				cstmt.setString(36,replaceNull(bean.getTokenSerial()));
				cstmt.setString(37,replaceNull(bean.getTokenSerialNo()));					
				cstmt.setString(38,replaceNull(bean.getDispLocn()));
				cstmt.setString(39,replaceNull(bean.getConfirmedYn()));
				cstmt.registerOutParameter(40, Types.VARCHAR);
				cstmt.registerOutParameter(41, Types.VARCHAR);
				cstmt.registerOutParameter(42, Types.VARCHAR);
				cstmt.registerOutParameter(43, Types.VARCHAR);
					
				cstmt.execute();
				sys_warning_message = cstmt.getString(40);
				str_error_level = cstmt.getString(41);
				str_sysmesage_id = cstmt.getString(42);
				str_error_text = cstmt.getString(43);

				errorList = new ArrayList<String>();
				warningList = new ArrayList<String>();
				
				if(sys_warning_message != null){
					try{
						sys_warning_message = rb.getString(sys_warning_message);
					}
					catch(Exception rbException){
						sys_warning_message = getMessageString(sys_warning_message,con);
						System.err.println("Exceprion in RB 431->"+rbException);
						rbException.printStackTrace();
					}
					warningList.add(sys_warning_message);
				}
				
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
								System.err.println("Exceprion in RB 452->"+rbException);
								rbException.printStackTrace();
							}
							errorList.add(msgArr[l]);
						}
					}else{

						try{
							str_sysmesage_id = rb.getString(str_sysmesage_id);
						}
						catch(Exception rbException){
							str_sysmesage_id = getMessageString(str_sysmesage_id,con);
							System.err.println("Exceprion in RB 464->"+rbException);
							rbException.printStackTrace();
						}
						errorList.add(str_sysmesage_id);
					}
				}
			}
			
			if (errorList.isEmpty()) {
				con.commit();
			}
			else 
			{
				con.rollback();				
			}
			if(cstmt != null)
				cstmt.close();
		}
		catch(Exception e){
			try{
				errorList.add(e.getMessage());
				con.rollback();
			}
			catch(Exception e1){
				e1.printStackTrace();
			}
		}
		finally{
			response.setErrorList(errorList);
			response.setWarningList(warningList);
			ConnectionManager.returnConnection(con);
		}
		
		return response;
	}
	
	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/	
	public PlaceNewOrderResponse cancelAll(PlaceNewOrderRequest requestBean) 
	{		
		response = new PlaceNewOrderResponse();
		Connection con = null;

		CallableStatement cstmt = null;

		try{
			con = ConnectionManager.getConnection();
			locale = requestBean.getLocale() ;
			login_user = requestBean.getLoginUser();
			facilityId = requestBean.getFacilityId();
			client_ip_address = requestBean.getClientIpAddress();

			loc = new Locale(locale);
			rb = ResourceBundle.getBundle("eBL.resources.Messages",loc);
			BLChargePatientExistingOrderBean bean = new BLChargePatientExistingOrderBean();
			bean = requestBean.getExistingOrderBean();
			errorList = new ArrayList<String>();
			warningList = new ArrayList<String>();
			List<BLChargePatientExistingOrderBean> serviceList = null;
			String cancelBlServ =  "{ call blplaceservice.cancel_bl_serv(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }";
			String cancelBlPanel = "{ call blplaceservice.cancel_bl_panel(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }";			
			Calendar cal = Calendar.getInstance();
			java.util.Date dt = cal.getTime();
			boolean gotoNext = true;
			if(bean != null){
				serviceList = bean.getServicesList();
				if(serviceList != null && !serviceList.isEmpty()){
					for(BLChargePatientExistingOrderBean loopBean : serviceList){
						if(gotoNext){
						if("S".equals(loopBean.getServOrPanel())){
							cstmt = con.prepareCall(cancelBlServ);
						}
						else if("L".equals(loopBean.getServOrPanel())){
							cstmt = con.prepareCall(cancelBlPanel);
							bean.setServCode(getPanelStr(loopBean.getServCode(), con));
						}
						
						System.err.println("1 "+"CAN");
						System.err.println("2 "+facilityId);
						System.err.println("3 "+bean.getEpisodeType());
						System.err.println("4 "+bean.getPatientId());
						System.err.println("5 "+bean.getEpisodeId());
						System.err.println("6 "+bean.getVisitId());
						System.err.println("7 "+bean.getEncounterId());
						System.err.println("8 "+bean.getAcctSeqNo());
						System.err.println("9 "+loopBean.getPrimKeyMain());
						System.err.println("10 "+loopBean.getPrimKeyLineNum());
						System.err.println("11 "+loopBean.getPrimKeyModId());
						System.err.println("12 "+loopBean.getSubRegnNum());
						
						System.err.println("13 "+loopBean.getSubRegnLineNum());
						System.err.println("14 "+loopBean.getServOrPanel());
						System.err.println("15 "+loopBean.getServCode());
						
						System.err.println("16 "+"CAN");
						System.err.println("17 "+loopBean.getItemCode());
						System.err.println("18 "+loopBean.getItemDesc());
						System.err.println("19 "+loopBean.getServQty());
						System.err.println("20 "+loopBean.getNetCharge());
						System.err.println("21 "+loopBean.getPhysicianId());
						System.err.println("22 "+new Date(dt.getTime()));
						System.err.println("23 "+loopBean.getServedpanelQty());
						System.err.println("24 "+loopBean.getUomCode());
						
						System.err.println("25 "+loopBean.getPractStaffInd());
						System.err.println("26 "+loopBean.getInclExclInd());
						System.err.println("27 "+loopBean.getReason());
						System.err.println("28 "+login_user);
						System.err.println("29 "+client_ip_address);
						System.err.println("30 "+loopBean.getFutureOrder());
						System.err.println("31 "+loopBean.getFutureOrderChargeLater());
						System.err.println("32 "+loopBean.getRemarks());
						System.err.println("33 "+loopBean.getPackInd());
						System.err.println("34 "+loopBean.getDailyProcessInd());
						System.err.println("35 "+loopBean.getBedTypeCode());
						System.err.println("36 "+loopBean.getTokenSerial());
						System.err.println("37 "+loopBean.getTokenSerialNo());
						System.err.println("38 "+loopBean.getDispLocn());
						
						cstmt.setString(1,"CAN");
						cstmt.setString(2,facilityId);
						cstmt.setString(3,bean.getEpisodeType());
						cstmt.setString(4,bean.getPatientId());
						cstmt.setString(5,bean.getEpisodeId());
						cstmt.setString(6,bean.getVisitId());
						cstmt.setString(7,bean.getEncounterId());
						cstmt.setString(8,replaceNull(bean.getAcctSeqNo()));
						cstmt.setString(9,replaceNull(loopBean.getPrimKeyMain()));
							
						cstmt.setString(10,replaceNull(loopBean.getPrimKeyLineNum()));
						cstmt.setString(11,loopBean.getPrimKeyModId());
						if("".equals(replaceNull(loopBean.getSubRegnNum()))){
							cstmt.setString(12,replaceNull(loopBean.getPrimKeyMain()));
							System.err.println("12th If ->"+replaceNull(loopBean.getPrimKeyMain()));
						}
						else{
							cstmt.setString(12,replaceNull(loopBean.getSubRegnNum()));
							System.err.println("12th Else ->"+replaceNull(loopBean.getSubRegnNum()));
						}
						if("".equals(replaceNull(loopBean.getSubRegnLineNum()))){
							cstmt.setString(13,replaceNull(loopBean.getPrimKeyLineNum()));
							System.err.println("13th If ->"+replaceNull(loopBean.getPrimKeyLineNum()));
						}
						else{
							cstmt.setString(13,replaceNull(loopBean.getSubRegnLineNum()));
							System.err.println("13th Else ->"+replaceNull(loopBean.getSubRegnLineNum()));
						}
						cstmt.setString(14,replaceNull(loopBean.getServOrPanel()));
						cstmt.setString(15,replaceNull(loopBean.getServCode()));
							
						cstmt.setString(16,"CAN");
						cstmt.setString(17,replaceNull(loopBean.getItemCode()));
						cstmt.setString(18,replaceNull(loopBean.getItemDesc()));
						cstmt.setString(19,replaceNull(loopBean.getServQty()));
						cstmt.setString(20,replaceNull(loopBean.getNetCharge()));//
						cstmt.setString(21,replaceNull(loopBean.getPhysicianId()));
							
						cstmt.setDate(22, new Date(dt.getTime()));
						cstmt.setString(23,replaceNull(loopBean.getServedpanelQty()));
						cstmt.setString(24,replaceNull(loopBean.getUomCode()));
						cstmt.setString(25,replaceNull(loopBean.getPractStaffInd()));
						cstmt.setString(26,replaceNull(loopBean.getInclExclInd()));
						cstmt.setString(27,replaceNull(loopBean.getReason()));
						cstmt.setString(28,login_user);					
						cstmt.setString(29,client_ip_address);
						cstmt.setString(30,replaceNull(loopBean.getFutureOrder()));
							
						cstmt.setString(31,replaceNull(loopBean.getFutureOrderChargeLater()));
						cstmt.setString(32,replaceNull(loopBean.getRemarks()));
						cstmt.setString(33,replaceNull(loopBean.getPackInd()));	//				
						cstmt.setString(34,replaceNull(loopBean.getDailyProcessInd()));
						cstmt.setString(35,replaceNull(loopBean.getBedTypeCode()));					
						cstmt.setString(36,replaceNull(loopBean.getTokenSerial()));
						cstmt.setString(37,replaceNull(loopBean.getTokenSerialNo()));					
						cstmt.setString(38,replaceNull(loopBean.getDispLocn()));
						cstmt.setString(39,replaceNull(loopBean.getConfirmedYn()));
						cstmt.registerOutParameter(40, Types.VARCHAR);
						cstmt.registerOutParameter(41, Types.VARCHAR);
						cstmt.registerOutParameter(42, Types.VARCHAR);
						cstmt.registerOutParameter(43, Types.VARCHAR);
							
						cstmt.execute();
						sys_warning_message = cstmt.getString(40);
						str_error_level = cstmt.getString(41);
						str_sysmesage_id = cstmt.getString(42);
						str_error_text = cstmt.getString(43);
						
						if(sys_warning_message != null){
							try{
								sys_warning_message = rb.getString(sys_warning_message);
							}
							catch(Exception rbException){
								sys_warning_message = getMessageString(sys_warning_message,con);
								System.err.println("Exceprion in RB 659->"+rbException);
								rbException.printStackTrace();
							}
							warningList.add(loopBean.getPrimKeyMain()+" / "+loopBean.getServCode()+"  -&nbsp;"+sys_warning_message);
						}
						
						if(str_error_level!=null || str_error_text!=null){
							errorList.add(str_error_text);
							//gotoNext = false;
						}

						if(str_sysmesage_id!=null){
							//gotoNext = false;
							if(str_sysmesage_id.contains("|")){
								String msgArr[] = str_sysmesage_id.split("\\|");
								for(int l=0;l<msgArr.length;l++){


									try{
										msgArr[l] = rb.getString(msgArr[l]);
									}
									catch(Exception rbException){
										msgArr[l] = getMessageString(msgArr[l],con);
										System.err.println("Exceprion in RB 682->"+rbException);
										rbException.printStackTrace();
									}
									errorList.add(loopBean.getPrimKeyMain()+" / "+loopBean.getServCode()+"  -&nbsp;"+msgArr[l]);
								}
							}else{

								try{
									str_sysmesage_id = rb.getString(str_sysmesage_id);
								}
								catch(Exception rbException){
									str_sysmesage_id = getMessageString(str_sysmesage_id,con);
									System.err.println("Exceprion in RB 694->"+rbException);
									rbException.printStackTrace();
								}
								errorList.add(loopBean.getPrimKeyMain()+" / "+loopBean.getServCode()+"  -&nbsp;"+str_sysmesage_id);
							}
						}
					}
					}
									
				}
				
			}
			if (errorList.isEmpty()) {
				System.err.println("Committed");
				con.commit();
			}
			else 
			{
				System.err.println("Rollbacked");
				con.rollback();
				
			}
			if(cstmt != null)
				cstmt.close(); // added for checklist V210413
				
		}
		catch(Exception e){
			try{
				errorList.add(e.getMessage());
				con.rollback();
			}
			catch(Exception e1){
				e1.printStackTrace();				
			}
		}
		finally{
			response.setErrorList(errorList);
			response.setWarningList(warningList);
			ConnectionManager.returnConnection(con);
		}
		
		return response;
	}
	
/**
	* @ejb.interface-method
	*	 view-type="both"
	*/	
	public PlaceNewOrderResponse confirmBLServ(PlaceNewOrderRequest requestBean) 
	{
		response = new PlaceNewOrderResponse();
		Connection con = null;

		CallableStatement cstmt = null;

		try{
			con = ConnectionManager.getConnection();
			locale = requestBean.getLocale() ;
			login_user = requestBean.getLoginUser();
			facilityId = requestBean.getFacilityId();
			client_ip_address = requestBean.getClientIpAddress();

			loc = new Locale(locale);
			rb = ResourceBundle.getBundle("eBL.resources.Messages",loc);
			BLChargePatientExistingOrderBean bean = new BLChargePatientExistingOrderBean();
			bean = requestBean.getExistingOrderBean();
			
			String confirmBlServ =  "{ call blplaceservice.confirm_bl_serv(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }";
			String confirmBlPanel = "{ call blplaceservice.confirm_bl_panel(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }";
		//	Calendar cal = Calendar.getInstance(); //unused variables V210413
		//	java.util.Date dt = cal.getTime(); //unused variables V210413
			System.err.println(bean.getTrxDocRef());
			System.err.println(bean.getTrxDocRefLineNum());
			System.err.println(bean.getTrxDocRefSeqNum());
			System.err.println(bean.getSubModuleId());
			System.err.println(bean.getOrderId());
			System.err.println(bean.getOrderLineNum());
			System.err.println(bean.getItemCode());
			System.err.println(bean.getServCode());
			System.err.println(bean.getConfirmedYn());
			
			String servOrPanel = bean.getServOrPanel();
			if("S".equals(servOrPanel)){
				cstmt = con.prepareCall(confirmBlServ);
			}
			else if("L".equals(servOrPanel)){
				cstmt = con.prepareCall(confirmBlPanel);
				bean.setServCode(getPanelStr(bean.getServCode(), con));
			}
			cstmt.setString(1, facilityId);
			cstmt.setString(2, replaceNull(bean.getTrxDocRef()));
			cstmt.setString(3, replaceNull(bean.getTrxDocRefLineNum()));
			cstmt.setString(4, replaceNull(bean.getTrxDocRefSeqNum()));
			cstmt.setString(5, replaceNull(bean.getSubModuleId()));
			cstmt.setString(6, replaceNull(bean.getOrderId()));
			
			cstmt.setString(7, replaceNull(bean.getOrderLineNum()));
			cstmt.setString(8, replaceNull(bean.getItemCode()));
			cstmt.setString(9, replaceNull(bean.getServCode()));
			cstmt.setString(10, replaceNull(bean.getConfirmedYn()));
			cstmt.setString(11, login_user);
			cstmt.setString(12, client_ip_address);
			cstmt.registerOutParameter(13, Types.VARCHAR);
			cstmt.registerOutParameter(14, Types.VARCHAR);
			cstmt.registerOutParameter(15, Types.VARCHAR);
			
			cstmt.execute();
			str_error_level = cstmt.getString(13);
			str_sysmesage_id = cstmt.getString(14);
			str_error_text = cstmt.getString(15);

			errorList = new ArrayList<String>();
			
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
							System.err.println("Exceprion in RB 822->"+rbException);
							rbException.printStackTrace();
						}
						errorList.add(msgArr[l]);
					}
				}else{

					try{
						str_sysmesage_id = rb.getString(str_sysmesage_id);
					}
					catch(Exception rbException){
						str_sysmesage_id = getMessageString(str_sysmesage_id,con);
						System.err.println("Exceprion in RB 834->"+rbException);
						rbException.printStackTrace();
					}
					errorList.add(str_sysmesage_id);
				}
			}
			
			if (errorList.isEmpty()) {
				con.commit();
			}
			else 
			{
				con.rollback();
				
			}
			if(cstmt != null)
				cstmt.close();
			
		}
		catch(Exception e){
			try{
				con.rollback();
				errorList.add(e.getMessage());
			}
			catch(Exception e1){
				e1.printStackTrace();
			}
		}
		finally{
			response.setErrorList(errorList);
			ConnectionManager.returnConnection(con);
		}
		
		return response;
	}
	
/**
	* @ejb.interface-method
	*	 view-type="both"
	*/	
	public PlaceNewOrderResponse confirmAll(PlaceNewOrderRequest requestBean) 
	{
		response = new PlaceNewOrderResponse();
		List<BLChargePatientExistingOrderBean> serviceList = null;
		Connection con = null;

		CallableStatement cstmt = null;

		try{
			con = ConnectionManager.getConnection();
			locale = requestBean.getLocale() ;
			login_user = requestBean.getLoginUser();
			facilityId = requestBean.getFacilityId();
			client_ip_address = requestBean.getClientIpAddress();

			loc = new Locale(locale);
			rb = ResourceBundle.getBundle("eBL.resources.Messages",loc);
			BLChargePatientExistingOrderBean bean = new BLChargePatientExistingOrderBean();
			bean = requestBean.getExistingOrderBean();
			errorList = new ArrayList<String>();
			String confirmBlServ =  "{ call blplaceservice.confirm_bl_serv(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }";
			String confirmBlPanel = "{ call blplaceservice.confirm_bl_panel(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }";
			//Calendar cal = Calendar.getInstance(); //unused variable V210413
			//java.util.Date dt = cal.getTime();//unused variable V210413
			boolean gotoNext = true;
			if(bean != null){
				serviceList = bean.getServicesList();
				if(serviceList != null && !serviceList.isEmpty()){
					for(BLChargePatientExistingOrderBean loopBean: serviceList){
						if(gotoNext){
						System.err.println(loopBean.getTrxDocRef());
						System.err.println(loopBean.getTrxDocRefLineNum());
						System.err.println(loopBean.getTrxDocRefSeqNum());
						System.err.println(loopBean.getPrimKeyModId());
						System.err.println(loopBean.getPrimKeyMain());
						System.err.println(loopBean.getPrimKeyLineNum());
						System.err.println(loopBean.getItemCode());
						System.err.println(loopBean.getServCode());
						System.err.println(loopBean.getConfirmedYn());
						
						String servOrPanel = loopBean.getServOrPanel();
						if("S".equals(servOrPanel)){
							cstmt = con.prepareCall(confirmBlServ);
						}
						else if("L".equals(servOrPanel)){
							cstmt = con.prepareCall(confirmBlPanel);
							loopBean.setServCode(getPanelStr(loopBean.getServCode(), con));
						}
						cstmt.setString(1, facilityId);
						cstmt.setString(2, replaceNull(loopBean.getTrxDocRef()));
						cstmt.setString(3, replaceNull(loopBean.getTrxDocRefLineNum()));
						cstmt.setString(4, replaceNull(loopBean.getTrxDocRefSeqNum()));
						cstmt.setString(5, replaceNull(loopBean.getPrimKeyModId()));
						cstmt.setString(6, replaceNull(loopBean.getPrimKeyMain()));
						
						cstmt.setString(7, replaceNull(loopBean.getPrimKeyLineNum()));
						cstmt.setString(8, replaceNull(loopBean.getItemCode()));
						cstmt.setString(9, replaceNull(loopBean.getServCode()));
						cstmt.setString(10, replaceNull(loopBean.getConfirmedYn()));
						cstmt.setString(11, login_user);
						cstmt.setString(12, client_ip_address);
						cstmt.registerOutParameter(13, Types.VARCHAR);
						cstmt.registerOutParameter(14, Types.VARCHAR);
						cstmt.registerOutParameter(15, Types.VARCHAR);
						
						cstmt.execute();
						str_error_level = cstmt.getString(13);
						str_sysmesage_id = cstmt.getString(14);
						str_error_text = cstmt.getString(15);

						
						
						if(str_error_level!=null || str_error_text!=null){
							errorList.add(str_error_text);
							gotoNext = false;
						}

						if(str_sysmesage_id!=null){
							gotoNext = false;
							if(str_sysmesage_id.contains("|")){
								String msgArr[] = str_sysmesage_id.split("\\|");
								for(int l=0;l<msgArr.length;l++){


									try{
										msgArr[l] = rb.getString(msgArr[l]);
									}
									catch(Exception rbException){
										msgArr[l] = getMessageString(msgArr[l],con);
										System.err.println("Exceprion in RB 963->"+rbException);
										rbException.printStackTrace();
									}
									errorList.add(msgArr[l]);
								}
							}else{

								try{
									str_sysmesage_id = rb.getString(str_sysmesage_id);
								}
								catch(Exception rbException){
									str_sysmesage_id = getMessageString(str_sysmesage_id,con);
									System.err.println("Exceprion in RB 975->"+rbException);
									rbException.printStackTrace();
								}
								errorList.add(str_sysmesage_id);
							}
						}
					}
					}
				}
			}
			
			
			if (errorList.isEmpty()) {
				con.commit();
			}
			else 
			{
				con.rollback();
				
			}
			
			if(cstmt != null)
				cstmt.close();
		}
		catch(Exception e){
			try{
				con.rollback();
				errorList.add(e.getMessage());
			}
			catch(Exception e1){
				e1.printStackTrace();
			}
		}
		finally{
			response.setErrorList(errorList);
			ConnectionManager.returnConnection(con);
		}
		
		return response;
	}
	
/**
	* @ejb.interface-method
	*	 view-type="both"
	*/	
	public PlaceNewOrderResponse processBLServ(PlaceNewOrderRequest requestBean) 
	{
		response = new PlaceNewOrderResponse();
		Connection con = null;

		CallableStatement cstmt = null;

		try{
			con = ConnectionManager.getConnection();
			locale = requestBean.getLocale() ;
			login_user = requestBean.getLoginUser();
			facilityId = requestBean.getFacilityId();
			client_ip_address = requestBean.getClientIpAddress();

			loc = new Locale(locale);
			rb = ResourceBundle.getBundle("eBL.resources.Messages",loc);
			BLChargePatientExistingOrderBean bean = new BLChargePatientExistingOrderBean();
			bean = requestBean.getExistingOrderBean();
			
			String processBlServ =  "{ call blplaceservice.process_future_order(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }";			
			//Calendar cal = Calendar.getInstance(); //unused variable V210413
			//java.util.Date dt = cal.getTime(); //unused variable V210413
			System.err.println(bean.getSubModuleId());
			System.err.println(bean.getOrderId());
			System.err.println(bean.getSubModuleId());
			System.err.println(bean.getSubRegnNum());
			System.err.println(bean.getSubRegnLineNum());
			System.err.println(bean.getEpisodeType());
			System.err.println(bean.getPatientId());
			System.err.println(bean.getEpisodeId());
			System.err.println(bean.getVisitId());
			
			cstmt = con.prepareCall(processBlServ);
			
			cstmt.setString(1, facilityId);
			cstmt.setString(2, replaceNull(bean.getSubModuleId()));
			cstmt.setString(3, replaceNull(bean.getOrderId()));
			cstmt.setString(4, replaceNull(bean.getSubModuleId()));
			cstmt.setString(5, replaceNull(bean.getSubRegnNum()));
			
			cstmt.setString(6, replaceNull(bean.getSubRegnLineNum()));
			cstmt.setString(7, replaceNull(bean.getEpisodeType()));
			cstmt.setString(8, replaceNull(bean.getPatientId()));
			cstmt.setString(9, replaceNull(bean.getEpisodeId()));
			cstmt.setString(10, replaceNull(bean.getVisitId()));
			cstmt.setString(11, locale);
			cstmt.setString(12, login_user);
			cstmt.setString(13, client_ip_address);
			cstmt.registerOutParameter(14, Types.VARCHAR);
			cstmt.registerOutParameter(15, Types.VARCHAR);
			cstmt.registerOutParameter(16, Types.VARCHAR);
			
			cstmt.execute();
			str_error_level = cstmt.getString(14);
			str_sysmesage_id = cstmt.getString(15);
			str_error_text = cstmt.getString(16);

			errorList = new ArrayList<String>();
			
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
							System.err.println("Exceprion in RB 1094->"+rbException);
							rbException.printStackTrace();
						}
						errorList.add(msgArr[l]);
					}
				}else{

					try{
						str_sysmesage_id = rb.getString(str_sysmesage_id);
					}
					catch(Exception rbException){
						str_sysmesage_id = getMessageString(str_sysmesage_id,con);
						System.err.println("Exceprion in RB 1106->"+rbException);
						rbException.printStackTrace();
					}
					errorList.add(str_sysmesage_id);
				}
			}
			
			if (errorList.isEmpty()) {
				con.commit();
			}
			else 
			{
				con.rollback();
				
			}
			if(cstmt != null) // added for checklist V210413
				cstmt.close();
			
		}
		catch(Exception e){
			try{
				con.rollback();
				errorList.add(e.getMessage());
			}
			catch(Exception e1){
				e1.printStackTrace();
			}
		}
		finally{
			response.setErrorList(errorList);
			ConnectionManager.returnConnection(con);
		}
		
		return response;
	}
	
	/**
	 * The Below Method is used for Bulk Processing the Unprocessed Order for a Patient
	 * @param requestBean
	 * @return
	 */
	 /**
	* @ejb.interface-method
	*	 view-type="both"
	*/	
	public PlaceNewOrderResponse processAll(PlaceNewOrderRequest requestBean) 
	{
		response = new PlaceNewOrderResponse();
		List<BLChargePatientExistingOrderBean> serviceList = null;
		Connection con = null;

		CallableStatement cstmt = null;

		try{
			con = ConnectionManager.getConnection();
			locale = requestBean.getLocale() ;
			login_user = requestBean.getLoginUser();
			facilityId = requestBean.getFacilityId();
			client_ip_address = requestBean.getClientIpAddress();

			loc = new Locale(locale);
			rb = ResourceBundle.getBundle("eBL.resources.Messages",loc);
			BLChargePatientExistingOrderBean bean = new BLChargePatientExistingOrderBean();
			bean = requestBean.getExistingOrderBean();
			errorList = new ArrayList<String>();
			String processBlServ =  "{ call blplaceservice.process_future_order(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }";
			//Calendar cal = Calendar.getInstance(); //unused variable V210413
			//java.util.Date dt = cal.getTime(); //unused variable V210413
			boolean gotoNext = true;
			if(bean != null){
				serviceList = bean.getServicesList();
				if(serviceList != null && !serviceList.isEmpty()){
					for(BLChargePatientExistingOrderBean loopBean: serviceList){
						if(gotoNext){
						System.err.println(loopBean.getTrxDocRef());
						System.err.println(loopBean.getTrxDocRefLineNum());
						System.err.println(loopBean.getTrxDocRefSeqNum());
						System.err.println(loopBean.getOrderId());
						System.err.println(loopBean.getOrderLineNum());
						System.err.println(loopBean.getItemCode());
						System.err.println(loopBean.getServCode());
						System.err.println(loopBean.getConfirmedYn());
						
						cstmt = con.prepareCall(processBlServ);
						
						cstmt.setString(1, facilityId);
						cstmt.setString(2, replaceNull(loopBean.getSubModuleId()));
						cstmt.setString(3, replaceNull(loopBean.getOrderId()));
						cstmt.setString(4, replaceNull(loopBean.getSubModuleId()));
						cstmt.setString(5, replaceNull(loopBean.getSubRegnNum()));
						cstmt.setString(6, replaceNull(loopBean.getSubRegnLineNum()));
						
						cstmt.setString(7, replaceNull(bean.getEpisodeType()));
						cstmt.setString(8, replaceNull(bean.getPatientId()));
						cstmt.setString(9, replaceNull(bean.getEpisodeId()));
						cstmt.setString(10, replaceNull(bean.getVisitId()));
						cstmt.setString(11, locale);
						cstmt.setString(12, login_user);
						cstmt.setString(13, client_ip_address);
						cstmt.registerOutParameter(14, Types.VARCHAR);
						cstmt.registerOutParameter(15, Types.VARCHAR);
						cstmt.registerOutParameter(16, Types.VARCHAR);
						
						cstmt.execute();
						str_error_level = cstmt.getString(14);
						str_sysmesage_id = cstmt.getString(15);
						str_error_text = cstmt.getString(16);

						
						
						if(str_error_level!=null || str_error_text!=null){
							errorList.add(str_error_text);
							gotoNext = false;
						}

						if(str_sysmesage_id!=null){
							gotoNext = false;
							if(str_sysmesage_id.contains("|")){
								String msgArr[] = str_sysmesage_id.split("\\|");
								for(int l=0;l<msgArr.length;l++){


									try{
										msgArr[l] = rb.getString(msgArr[l]);
									}
									catch(Exception rbException){
										msgArr[l] = getMessageString(msgArr[l],con);
										System.err.println("Exceprion in RB 1233->"+rbException);
										rbException.printStackTrace();
									}
									errorList.add(msgArr[l]);
								}
							}else{

								try{
									str_sysmesage_id = rb.getString(str_sysmesage_id);
								}
								catch(Exception rbException){
									str_sysmesage_id = getMessageString(str_sysmesage_id,con);
									System.err.println("Exceprion in RB 1245->"+rbException);
									rbException.printStackTrace();
								}
								errorList.add(str_sysmesage_id);
							}
						}
					}
					}
				}
			}
			
			
			if (errorList.isEmpty()) {
				con.commit();
			}
			else 
			{
				con.rollback();
				
			}
				if(cstmt != null) // added for checklist V210413
				cstmt.close();
		}
		catch(Exception e){
			try{
				con.rollback();
				errorList.add(e.getMessage());
			}
			catch(Exception e1){
				e1.printStackTrace();
			}
		}
		finally{
			response.setErrorList(errorList);
			ConnectionManager.returnConnection(con);
		}
		
		return response;
	}
	
/**
	* @ejb.interface-method
	*	 view-type="both"
	*/	
	public PlaceNewOrderResponse amendBLServ(PlaceNewOrderRequest requestBean) 
	{
		response = new PlaceNewOrderResponse();
		Connection con = null;

		CallableStatement cstmt = null;

		try{
			con = ConnectionManager.getConnection();
			locale = requestBean.getLocale() ;
			login_user = requestBean.getLoginUser();
			facilityId = requestBean.getFacilityId();
			client_ip_address = requestBean.getClientIpAddress();
			loc = new Locale(locale);
			rb = ResourceBundle.getBundle("eBL.resources.Messages",loc);
			BLChargePatientExistingOrderBean bean = new BLChargePatientExistingOrderBean();
			bean =  requestBean.getExistingOrderBean();
			String amendBlServ =  "{ call blplaceservice.amend_bl_serv(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }";
			String amendBlPanel = "{ call blplaceservice.amend_bl_panel(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }";
			Calendar cal = Calendar.getInstance();
			java.util.Date dt = cal.getTime();
			if(bean != null){
				if("S".equals(bean.getServOrPanel())){
					cstmt = con.prepareCall(amendBlServ);
				}
				else{
					cstmt = con.prepareCall(amendBlPanel);
					bean.setServCode(getPanelStr(bean.getServCode(), con));
				}
				cstmt.setString(1,"AMD");
				cstmt.setString(2,facilityId);
				cstmt.setString(3,bean.getEpisodeType());
				cstmt.setString(4,bean.getPatientId());
				cstmt.setString(5,bean.getEpisodeId());
				cstmt.setString(6,bean.getVisitId());
				cstmt.setString(7,bean.getEncounterId());
				cstmt.setString(8,replaceNull(bean.getAcctSeqNo()));
				cstmt.setString(9,replaceNull(bean.getOrderId()));
					
				cstmt.setString(10,replaceNull(bean.getOrderLineNum()));
				cstmt.setString(11,"BL");
				cstmt.setString(12,replaceNull(bean.getSubRegnNum()));
				cstmt.setString(13,replaceNull(bean.getSubRegnLineNum()));
				cstmt.setString(14,replaceNull(bean.getServOrPanel()));
				cstmt.setString(15,replaceNull(bean.getServCode()));
					
				cstmt.setString(16,"AMD");
				cstmt.setString(17,replaceNull(bean.getItemCode()));
				cstmt.setString(18,replaceNull(bean.getItemDesc()));
				cstmt.setString(19,replaceNull(bean.getServQty()));
				cstmt.setString(20,replaceNull(bean.getNetCharge()));
				cstmt.setString(21,replaceNull(bean.getPhysicianId()));
					
				cstmt.setDate(22, new Date(dt.getTime()));
				cstmt.setString(23,replaceNull(bean.getServedpanelQty()));
				cstmt.setString(24,replaceNull(bean.getUomCode()));
				cstmt.setString(25,replaceNull(bean.getPractStaffInd()));
				cstmt.setString(26,replaceNull(bean.getInclExclInd()));
				cstmt.setString(27,replaceNull(bean.getReason()));
				cstmt.setString(28,login_user);					
				cstmt.setString(29,client_ip_address);
				cstmt.setString(30,replaceNull(bean.getFutureOrder()));
					
				cstmt.setString(31,replaceNull(bean.getFutureOrderChargeLater()));
				cstmt.setString(32,replaceNull(bean.getRemarks()));
				cstmt.setString(33,replaceNull(bean.getPackInd()));					
				cstmt.setString(34,replaceNull(bean.getDailyProcessInd()));
				cstmt.setString(35,replaceNull(bean.getBedTypeCode()));					
				cstmt.setString(36,replaceNull(bean.getTokenSerial()));
				cstmt.setString(37,replaceNull(bean.getTokenSerialNo()));					
				cstmt.setString(38,replaceNull(bean.getDispLocn()));
				cstmt.registerOutParameter(39, Types.VARCHAR);
				cstmt.registerOutParameter(40, Types.VARCHAR);
				cstmt.registerOutParameter(41, Types.VARCHAR);
					
				cstmt.execute();
				str_error_level = cstmt.getString(39);
				str_sysmesage_id = cstmt.getString(40);
				str_error_text = cstmt.getString(41);

				errorList = new ArrayList<String>();
				
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
								System.err.println("Exceprion in RB 1386->"+rbException);
								rbException.printStackTrace();
							}
							errorList.add(msgArr[l]);
						}
					}else{

						try{
							str_sysmesage_id = rb.getString(str_sysmesage_id);
						}
						catch(Exception rbException){
							str_sysmesage_id = getMessageString(str_sysmesage_id,con);
							System.err.println("Exceprion in RB 1398->"+rbException);
							rbException.printStackTrace();
						}
						errorList.add(str_sysmesage_id);
					}
				}
		}

			
			if (errorList.isEmpty()) {
				con.commit();
			}
			else 
			{
				con.rollback();
				
			}
				if(cstmt != null) // added for checklist V210413
				cstmt.close();
		}
		catch(Exception e){
			try{
				con.rollback();
				errorList.add(e.getMessage());
			}
			catch(Exception e1){
				e1.printStackTrace();
			}
		}
		finally{
			response.setErrorList(errorList);
			ConnectionManager.returnConnection(con);
		}
		
		return response;
	}
	
/**
	* @ejb.interface-method
	*	 view-type="both"
	*/	
	public PlaceNewOrderResponse discountBLServ(PlaceNewOrderRequest requestBean) 
	{
		response = new PlaceNewOrderResponse();
		Connection con = null;

		CallableStatement cstmt = null;

		try{
			con = ConnectionManager.getConnection();
			locale = requestBean.getLocale() ;
			login_user = requestBean.getLoginUser();
			facilityId = requestBean.getFacilityId();
			client_ip_address = requestBean.getClientIpAddress();
			loc = new Locale(locale);
			rb = ResourceBundle.getBundle("eBL.resources.Messages",loc);
			BLChargePatientExistingOrderBean bean = new BLChargePatientExistingOrderBean();
			bean =  requestBean.getExistingOrderBean();
			
			String finalizeDiscount =  "{ call blplaceservice.finalize_adhoc_disc_amt(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }";
			//Calendar cal = Calendar.getInstance(); //Unused Variables V210413
			//java.util.Date dt = cal.getTime();//Unused Variables V210413
			if(bean != null){
				cstmt = con.prepareCall(finalizeDiscount);
				cstmt.setString(1,facilityId);
				cstmt.setString(2,replaceNull(bean.getTrxDocRef()));
				cstmt.setString(3,replaceNull(bean.getTrxDocRefLineNum()));
				cstmt.setString(4,replaceNull(bean.getTrxDocRefSeqNum()));
				cstmt.setString(5,replaceNull(bean.getSubModuleId()));
				cstmt.setString(6,replaceNull(bean.getOrderId()));
				cstmt.setString(7,replaceNull(bean.getOrderLineNum()));
				cstmt.setString(8,replaceNull(bean.getServCode()));
				cstmt.setString(9,replaceNull(bean.getItemCode()));
				
				cstmt.setString(10,replaceNull(bean.getPatientId()));
				cstmt.setString(11,replaceNull(bean.getEpisodeType()));
				cstmt.setString(12,replaceNull(bean.getEpisodeId()));
				cstmt.setString(13,replaceNull(bean.getVisitId()));
				
				cstmt.setString(14,replaceNull(bean.getCustGroup()));
				cstmt.setString(15,replaceNull(bean.getCust()));
				cstmt.setString(16,replaceNull(bean.getPolicyCode()));
				cstmt.setString(17,replaceNull(bean.getPolicyNum()));
				cstmt.setString(18,replaceNull(bean.getPriority()));
				cstmt.setString(19,replaceNull(bean.getAdhocDiscount()));
				cstmt.setString(20,replaceNull(bean.getDiscReason()));
				cstmt.setString(21,login_user);
				cstmt.setString(22,login_user);
				
				cstmt.setString(23, client_ip_address);
				
				cstmt.registerOutParameter(24, Types.VARCHAR);
				cstmt.registerOutParameter(25, Types.VARCHAR);
				cstmt.registerOutParameter(26, Types.VARCHAR);
					
				cstmt.execute();
				str_error_level = cstmt.getString(24);
				str_sysmesage_id = cstmt.getString(25);
				str_error_text = cstmt.getString(26);

				errorList = new ArrayList<String>();
				
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
								System.err.println("Exceprion in RB 1515->"+rbException);
								rbException.printStackTrace();
							}
							errorList.add(msgArr[l]);
						}
					}else{

						try{
							str_sysmesage_id = rb.getString(str_sysmesage_id);
						}
						catch(Exception rbException){
							str_sysmesage_id = getMessageString(str_sysmesage_id,con);
							System.err.println("Exceprion in RB 1528->"+rbException);
							rbException.printStackTrace();
						}
						errorList.add(str_sysmesage_id);
					}
				}
			}

			
			if (errorList.isEmpty()) {
				con.commit();
			}
			else 
			{
				con.rollback();
				
			}
				if(cstmt != null) // added for checklist V210413
				cstmt.close();
		}
		catch(Exception e){
			try{
				con.rollback();
				errorList.add(e.getMessage());
			}
			catch(Exception e1){
				e1.printStackTrace();
			}
		}
		finally{
			response.setErrorList(errorList);
			ConnectionManager.returnConnection(con);
		}
		
		return response;
	}
	
	public String replaceNull(String input) {
		if(input == null || "null".equals(input)){
			input = "";
		}
		return input;
	}

/**
	* @ejb.interface-method
	*	 view-type="both"
	*/	
	public String getPanelStr(String panelCode, Connection con) {
		CallableStatement cs = null;
		String strPanel = "";
		try{
			cs = con.prepareCall("{ call blplaceservice.get_panel_string(?,?,?,?,?,?) }");
			//cs.registerOutParameter(1, Types.VARCHAR);
			cs.setString(1, panelCode);
			cs.setString(2, null);
			cs.setString(3, null);
			cs.setString(4, null);
			cs.setString(5, null);
			cs.registerOutParameter(6, Types.VARCHAR);
			cs.execute();
			
			strPanel = cs.getString(6);
		
			
		}
		catch(Exception e){
			System.err.println("Exception in getting Panel String ->"+e);
			e.printStackTrace();
		}
		finally{			
			cs = null;			
		}
		return strPanel;
	}
	
	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/	
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
			e.printStackTrace();
		}
		finally{ //Added for checklist V210413
			
			try{
				if(pstmt!=null)
				{
					pstmt.close();
				}
				if(rst!=null)
				{
					rst.close();
				}
			}
			catch(Exception e)
			{
				System.err.println("Exception in getting Message String ->"+e);
				e.printStackTrace();
			}
			//pstmt = null;
			//	rst = null;
			//Added for checklist V210413
		}
		return output;
	}	
}
