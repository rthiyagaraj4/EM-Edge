/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eBL;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import webbeans.eCommon.ConnectionManager;
import com.ehis.persist.PersistenceHelper;
import eBL.Common.BlRepository;

/**
 * Servlet implementation class PolicyDefinitionMasterServlet
 */
public class BLFunctionPrivilegeServlet extends HttpServlet {
	//private static final long serialVersionUID = 1L; //commented checkstyle
	Connection con = null;
	CallableStatement cstmt = null;
	ResultSet rst = null;
	java.util.Properties p;
	String facilityId="";
	String client_ip_address="";
	String login_user="";
	String str_error_level = "", str_sysmesage_id="", str_error_text="";
	HttpSession session; 
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	String oldEndDate="";
	String userChangedEndDate = "";
	String locale = "";
	Locale loc = null;
	ResourceBundle rb = null;
	ResourceBundle rb1 = null;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public BLFunctionPrivilegeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	private String checkForNull(String inputString) {
 		return (inputString == null) ? "I" : inputString;
 	}
	
    private String returnVal(String inputString,String outputString) {
		return (inputString == null) ? outputString : inputString;
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// TODO Auto-generated method stub
	con = ConnectionManager.getConnection(request);
	try{
			session = request.getSession(false);
			locale = (String)session.getAttribute("LOCALE");
			loc = new Locale(locale);
			rb = ResourceBundle.getBundle("eBL.resources.Messages",loc);
			rb1 = ResourceBundle.getBundle("eSM.resources.Messages",loc);
			oldEndDate = checkForNull(request.getParameter("oldEndDate"));
			HashMap returnMap = new HashMap();
			String beanId = "FunctionPrivilegeBean";
			String beanName = "eBL.BLFunctionPrivilegeBean";
			BLFunctionPrivilegeBean functionPrivilegeBean = (BLFunctionPrivilegeBean)PersistenceHelper.getBeanObject(beanId, beanName, request) ;	
			
			returnMap=updatePolicyPrivilege(request,response,functionPrivilegeBean);
			
			if (((Boolean) returnMap.get("status")).booleanValue()) 
			{
				con.commit();
			}
			else 
			{
				con.rollback();				
			}
			
			String mapValue = "";
			String error = "";
			int err_val = 1;
			for (Iterator iterator = returnMap.keySet().iterator(); iterator.hasNext();) {
				String type = (String) iterator.next();
				if(!("status".equals(type))){
					mapValue = (String) returnMap.get(type);
					if(mapValue != null){
						//if(mapValue.contains("Error")){
							error = error+mapValue+"<br/>";
							err_val = 2;
						//}				
					}
				}				
			}
			if(error.length()==0){
				try{
					error = rb1.getString("RECORD_INSERTED");
				}
				catch(Exception rbException){
					System.err.println("Exceprion in RB ->"+rbException);
					rbException.printStackTrace();
					error = "APP-SM0070 Operation Completed Successfully ....";
				}
				//error = "Operation Completed Sucessfully";
			}
			else{
				error = "Record not saved"+"<br/>"+error;
			}
			response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8" ) +"&err_value="+err_val);
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
			ConnectionManager.returnConnection(con);
		}
	}

	private HashMap updatePolicyPrivilege(HttpServletRequest request,HttpServletResponse response,BLFunctionPrivilegeBean functionPrivilegeBean) {
		HashMap returnMap = new HashMap();
		boolean insertable = false;
		session = request.getSession(false);
		this.p = (java.util.Properties) session.getValue( "jdbc" ) ;
		facilityId = (String) session.getValue( "facility_id" ) ;
		client_ip_address = this.p.getProperty("client_ip_address");
		login_user = this.p.getProperty( "login_user" ) ;
		String locale = (String)session.getAttribute("LOCALE");
		String payerPrivIns = "{ call   BLPOLICYUSERACCESSDTLS.insert_bl_policy_privs (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }";
		String payerPrivUpd = "{ call   BLPOLICYUSERACCESSDTLS.update_bl_policy_privs (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }";
		String userPrivUpd 	= "{ call   BLUSERACCESSDTLS.UPDATE_BL_USER_PRIVS(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) } ";
		String errAdd = "";
		String errTextAdd = "";
		String msgAdd = "";
		String recordFormat = "";
		try{
			HashMap<String,ArrayList<BLFunctionPrivilegeBean>> payerDtlsMap = functionPrivilegeBean.getPayerDtlMap();
			con.setAutoCommit(false);
			String userType = functionPrivilegeBean.getUserType();
			String userCode = functionPrivilegeBean.getUserCode();
			String functionId = functionPrivilegeBean.getFunctionId();
			String privilegeCode = "";
			int i = 1;
			ArrayList<BLFunctionPrivilegeBean> privilegeList = payerDtlsMap.get("privilege"); 
			ArrayList<BLFunctionPrivilegeBean> payerList = null;
			if(!(privilegeList == null || privilegeList.isEmpty())){
				for(BLFunctionPrivilegeBean privBean : privilegeList){
					privilegeCode = privBean.getPrivilegeCode();
					//Updating User Privilege
					cstmt = con.prepareCall(userPrivUpd);
					cstmt.setString(1, facilityId);
					cstmt.setString(2, userType);
					cstmt.setString(3, userCode);
					cstmt.setString(4, functionId);
					cstmt.setString(5, privilegeCode);
					cstmt.setString(6, privBean.getEffStatus());
					
					if((privBean.getEffFromDate() == null) || ("".equals(privBean.getEffFromDate()))){
						cstmt.setString(7, null);
					}
					else{
						Date fromDt = new Date(sdf.parse(privBean.getEffFromDate()).getTime());
						cstmt.setDate(7, fromDt);
					}
					
					if((privBean.getEffToDate() == null) || ("".equals(privBean.getEffToDate()))){
						cstmt.setString(8, null);
					}
					else{
						Date fromDt = new Date(sdf.parse(privBean.getEffToDate()).getTime());
						cstmt.setDate(8, fromDt);
					}
					
					cstmt.setString(9, null);
					cstmt.setString(10, privBean.getAllowable());
					cstmt.setString(11, null);
					cstmt.setString(12, locale);
					cstmt.setString(13, login_user);
					cstmt.setString(14, facilityId);
					cstmt.setString(15, client_ip_address);

					cstmt.registerOutParameter(16, java.sql.Types.VARCHAR);
					cstmt.registerOutParameter(17, java.sql.Types.VARCHAR);
					cstmt.registerOutParameter(18, java.sql.Types.VARCHAR);
					cstmt.execute();
					str_error_level = cstmt.getString(16);
					str_sysmesage_id = cstmt.getString(17);
					str_error_text = cstmt.getString(18);				
				
					errAdd = "errAdd"+i;
					errTextAdd = "errTextAdd"+i;
					
					if(str_error_level!=null || str_error_text!=null){
						returnMap.put(errAdd, str_error_text);
					}
					
					if(str_sysmesage_id!=null){						
						if(str_sysmesage_id.contains("|")){
							String msgArr[] = str_sysmesage_id.split("\\|");
							for(int l=0;l<msgArr.length;l++){
								msgAdd = "msgAdd"+i+"-"+l;
								try{
									msgArr[l] = rb.getString(msgArr[l]);
								}
								catch(Exception rbException){
									System.err.println("Exceprion in RB ->"+rbException);
									rbException.printStackTrace();
								}								
								returnMap.put(msgAdd, msgArr[l]);
							}
						}else{
							msgAdd = "msgAdd"+i;
							
							try{
								str_sysmesage_id = rb.getString(str_sysmesage_id);
							}
							catch(Exception rbException){
								System.err.println("Exceprion in RB ->"+rbException);
								rbException.printStackTrace();
							}
							returnMap.put(msgAdd, str_sysmesage_id);
						}
					}
					//Updating User Privilege
					if(payerDtlsMap.containsKey(facilityId+"~"+userType+"~"+userCode+"~"+functionId+"~"+privilegeCode)){
						payerList = payerDtlsMap.get(facilityId+"~"+userType+"~"+userCode+"~"+functionId+"~"+privilegeCode);
						if(!(payerList == null || payerList.isEmpty())){
							for(BLFunctionPrivilegeBean bean : payerList){
								//Updating Policy Privilege
								if("I".equals(checkForNull(bean.getStatus()))){
									cstmt = con.prepareCall(payerPrivIns);
									recordFormat = "I";
								}
								else{
									cstmt = con.prepareCall(payerPrivUpd);
									recordFormat = "U";
								}
								cstmt.setString(1, facilityId);
								cstmt.setString(2, userType);
								cstmt.setString(3, userCode);
								cstmt.setString(4, functionId);
								cstmt.setString(5, privilegeCode);
								cstmt.setString(6, bean.getCustGrpCode());
								cstmt.setString(7, bean.getCustCode());
								cstmt.setString(8, bean.getPolicyCode());
								cstmt.setString(9, privBean.getEffStatus());
									
								if((privBean.getEffFromDate() == null) || ("".equals(privBean.getEffFromDate()))){
									cstmt.setString(10, null);
								}
								else{
									Date fromDt = new Date(sdf.parse(privBean.getEffFromDate()).getTime());
									cstmt.setDate(10, fromDt);
								}
									
								if((bean.getEffFromDate() == null) || ("".equals(bean.getEffFromDate()))){
									cstmt.setString(11, null);
								}
								else{
									Date fromDt = new Date(sdf.parse(bean.getEffFromDate()).getTime());
									cstmt.setDate(11, fromDt);
								}
									
								if((bean.getEffToDate() == null) || ("".equals(bean.getEffToDate()))){
									cstmt.setString(12, null);
								}
								else{
									Date fromDt = new Date(sdf.parse(bean.getEffToDate()).getTime());
									cstmt.setDate(12, fromDt);
								}
								cstmt.setString(13, null);
								cstmt.setString(14, bean.getAllowable());
								cstmt.setString(15, recordFormat);
								cstmt.setString(16, locale);
									
								cstmt.setString(17, login_user);
								cstmt.setString(18, facilityId);
								cstmt.setString(19, client_ip_address);

								cstmt.registerOutParameter(20, java.sql.Types.VARCHAR);
								cstmt.registerOutParameter(21, java.sql.Types.VARCHAR);
								cstmt.registerOutParameter(22, java.sql.Types.VARCHAR);
								cstmt.execute();
								str_error_level = cstmt.getString(20);
								str_sysmesage_id = cstmt.getString(21);
								str_error_text = cstmt.getString(22);							
								
								errAdd = "errAdd"+i;
								errTextAdd = "errTextAdd"+i;
									
								if(str_error_level!=null || str_error_text!=null){
									returnMap.put(errAdd, str_error_text);
								}
									
								if(str_sysmesage_id!=null){
									msgAdd = "";
									if(str_sysmesage_id.contains("|")){
										String msgArr[] = str_sysmesage_id.split("\\|");
										for(int l=0;l<msgArr.length;l++){
											msgAdd = "msgAdd"+i+"-"+l;
											try{
												msgArr[l] = rb.getString(msgArr[l]);
											}
											catch(Exception rbException){
												System.err.println("Exceprion in RB ->"+rbException);
												rbException.printStackTrace();
											}												
											returnMap.put(msgAdd, msgArr[l]);
										}
									}else{
										msgAdd = "msgAdd"+i;
											
										try{
											str_sysmesage_id = rb.getString(str_sysmesage_id);
										}
										catch(Exception rbException){
											System.err.println("Exceprion in RB ->"+rbException);
											rbException.printStackTrace();
										}
										returnMap.put(msgAdd, str_sysmesage_id);
									}
								}
								//Updating Policy Privilege
								i++;
							}
						}
					}
				}
			}
			
			cstmt.close();
			if (!returnMap.isEmpty()) {
				insertable = false;
			} else {
				insertable = true;
			}
		}
		catch(Exception e){
			System.err.println("Exception is "+e);
			returnMap.put("internalError", "Internal Error");
			insertable = false;
			e.printStackTrace();
		}
		finally{
			returnMap.put("status", new Boolean(insertable));
			return returnMap;
		}
	}
}
