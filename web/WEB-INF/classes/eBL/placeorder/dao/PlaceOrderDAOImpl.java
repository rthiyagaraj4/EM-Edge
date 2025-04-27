package eBL.placeorder.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Types;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.ejb.SessionContext;
import javax.servlet.http.HttpSession;

import eBL.placeorder.model.BLChargePatientExistingOrderBean;
import eBL.placeorder.model.BLChargePatientNewOrderBean;
import eBL.placeorder.request.PlaceNewOrderRequest;
import eBL.placeorder.response.PlaceNewOrderResponse;

import webbeans.eCommon.ConnectionManager;

@SuppressWarnings("rawtypes")
public class PlaceOrderDAOImpl implements PlaceOrderDAO{

	Connection con;

	CallableStatement cstmt = null;
	ResultSet rst = null;
	SessionContext ctx;
	
	String facilityId="";
	String client_ip_address="";
	String login_user="";
	String str_error_level = "", str_sysmesage_id="", str_error_text="";
	HttpSession session; 
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	Locale loc = null;
	ResourceBundle rb = null;

	boolean insertable = false;

	String locale = "";
	List<String> errorList = null;
	PlaceNewOrderResponse response = null;

	public PlaceNewOrderResponse placeNewOrder(PlaceNewOrderRequest requestBean) {
		response = new PlaceNewOrderResponse();
		
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
			
			String recordBlServ =  "{ call blplaceservice.record_bl_serv(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }";
			String recordBlPanel = "{ call blplaceservice.record_bl_panel(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }";
			String recordBlpackage = "{ call blplaceservice.record_bl_package(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }";
			ArrayList<BLChargePatientNewOrderBean> chargeList = chargeBean.getServicesList();
			Calendar cal = Calendar.getInstance();
			java.util.Date dt = cal.getTime();
			if(chargeList != null){
				for (Iterator iterator = chargeList.iterator(); iterator.hasNext();) {
					BLChargePatientNewOrderBean bean = (BLChargePatientNewOrderBean) iterator.next();
					if("S".equals(bean.getServOrPanel())){
						cstmt = con.prepareCall(recordBlServ);
					}
					else if("L".equals(bean.getServOrPanel())){
						cstmt = con.prepareCall(recordBlPanel);
						bean.setBlngServCode(getPanelStr(bean.getBlngServCode(), con));
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
					
					cstmt.setDate(22, new Date(dt.getTime()));
					cstmt.setString(23,bean.getQuantity());
					cstmt.setString(24,null);
					cstmt.setString(25,null);
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
									System.err.println("Exceprion in RB ->"+rbException);
								}
								errorList.add(msgArr[l]);
							}
						}else{

							try{
								str_sysmesage_id = rb.getString(str_sysmesage_id);
							}
							catch(Exception rbException){
								System.err.println("Exceprion in RB ->"+rbException);
							}
							errorList.add(str_sysmesage_id);
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
		}
		catch(Exception e){
			try{
				con.rollback();
			}
			catch(Exception e1){
				
			}
		}
		finally{
			response.setErrorList(errorList);
			ConnectionManager.returnConnection(con);
			//added against checkstyle starts
			try{
				if(cstmt!=null) cstmt.close();
			}
			catch(Exception e)
			{
				System.err.println("exception in placeNewOrder :"+e);
			}
			//added against checkstyle ends
		}
		
		return response;
	}

	
	public PlaceNewOrderResponse cancelExistingOrder(PlaceNewOrderRequest requestBean) {
		response = new PlaceNewOrderResponse();
		
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

			String cancelBlServ =  "{ call blplaceservice.cancel_bl_serv(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }";
			String cancelBlPanel = "{ call blplaceservice.cancel_bl_panel(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }";
			String cancelBlpackage = "{ call blplaceservice.cancel_bl_package(?,?,?,?,?,?,?,?) }";
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
				System.err.println("10 "+bean.getOrderId());
				System.err.println("11 "+"BL");
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
				cstmt.setString(11,"BL");
				cstmt.setString(12,replaceNull(bean.getSubRegnNum()));
				cstmt.setString(13,replaceNull(bean.getSubRegnLineNum()));
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
								System.err.println("Exceprion in RB ->"+rbException);
							}
							errorList.add(msgArr[l]);
						}
					}else{

						try{
							str_sysmesage_id = rb.getString(str_sysmesage_id);
						}
						catch(Exception rbException){
							System.err.println("Exceprion in RB ->"+rbException);
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
		}
		catch(Exception e){
			try{
				errorList.add(e.getMessage());
				con.rollback();
			}
			catch(Exception e1){
				
			}
		}
		finally{
			response.setErrorList(errorList);
			ConnectionManager.returnConnection(con);
			//added against checkstyle starts
			try{
				if(cstmt!=null) cstmt.close();
			}
			catch(Exception e)
			{
				System.err.println("Exception in cancelExistingOrder:"+e);
			}
			//added against checkstyle ends
		}
		
		return response;
	}

	
	public PlaceNewOrderResponse confirmExistingOrder(PlaceNewOrderRequest requestBean) {
		response = new PlaceNewOrderResponse();
		
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
			Calendar cal = Calendar.getInstance();
			java.util.Date dt = cal.getTime();
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
			cstmt.setString(5, "BL");
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
							System.err.println("Exceprion in RB ->"+rbException);
						}
						errorList.add(msgArr[l]);
					}
				}else{

					try{
						str_sysmesage_id = rb.getString(str_sysmesage_id);
					}
					catch(Exception rbException){
						System.err.println("Exceprion in RB ->"+rbException);
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
		}
		catch(Exception e){
			try{
				con.rollback();
				errorList.add(e.getMessage());
			}
			catch(Exception e1){
				
			}
		}
		finally{
			response.setErrorList(errorList);
			ConnectionManager.returnConnection(con);
			//added against checkstyle starts
			try{
				if(cstmt!=null) cstmt.close();
			}
			catch(Exception e)
			{
				System.err.println("Exception in confirmExistingOrder"+e);
			}
			//added against checkstyle ends
		}
		
		return response;
	}

	
	public PlaceNewOrderResponse amendExistingOrder(PlaceNewOrderRequest requestBean) {
		response = new PlaceNewOrderResponse();
		
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
								System.err.println("Exceprion in RB ->"+rbException);
							}
							errorList.add(msgArr[l]);
						}
					}else{

						try{
							str_sysmesage_id = rb.getString(str_sysmesage_id);
						}
						catch(Exception rbException){
							System.err.println("Exceprion in RB ->"+rbException);
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
		}
		catch(Exception e){
			try{
				con.rollback();
				errorList.add(e.getMessage());
			}
			catch(Exception e1){
				
			}
		}
		finally{
			response.setErrorList(errorList);
			ConnectionManager.returnConnection(con);
			//added against checkstyle starts
			try{
				if(cstmt!=null) cstmt.close();
			}
			catch(Exception e)
			{
				System.err.println("Exception in amendExistingOrder"+e);
			}
			//added against checkstyle ends
		}
		
		return response;
	}

	
	public PlaceNewOrderResponse discountToExistingOrder(PlaceNewOrderRequest requestBean) {
		response = new PlaceNewOrderResponse();
		
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
			Calendar cal = Calendar.getInstance();
			java.util.Date dt = cal.getTime();
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
								System.err.println("Exceprion in RB ->"+rbException);
							}
							errorList.add(msgArr[l]);
						}
					}else{

						try{
							str_sysmesage_id = rb.getString(str_sysmesage_id);
						}
						catch(Exception rbException){
							System.err.println("Exceprion in RB ->"+rbException);
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
		}
		catch(Exception e){
			try{
				con.rollback();
				errorList.add(e.getMessage());
			}
			catch(Exception e1){
				
			}
		}
		finally{
			response.setErrorList(errorList);
			ConnectionManager.returnConnection(con);
			//added against checkstyle starts
			try{
				if(cstmt!=null) cstmt.close();
			}
			catch(Exception e)
			{
				System.err.println("Exception in discountToExistingOrder"+e);
			}
			//added against checkstyle ends
		}
		
		return response;
	}

	
	public String replaceNull(String input) {
		if(input == null || "null".equals(input)){
			input = "";
		}
		return input;
	}

	
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
		}
		finally{
			cs = null;
			//added against checkstyle starts
			try{
				if(cs!=null) cs.close();
			}
			catch(Exception e)
			{
				System.err.println("Exception in getPanelStr"+e);
			}
			//added against checkstyle ends		
		}
		return strPanel;
	}
	
	
	
	
}
