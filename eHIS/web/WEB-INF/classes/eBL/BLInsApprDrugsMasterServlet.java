/* 
Sr No        Version        Incident/TFS         SCF/CRF                         Developer Name
1			 V221113           38319       MMS-DM-CRF-0209.3-US005 / 01          Namrata Charate
--------------------------------------------------------------------------------------
*/
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
import eCommon.XSSRequestWrapper; //V220324

/**
 * Servlet implementation class PolicyDefinitionMasterServlet
 */
public class BLInsApprDrugsMasterServlet extends HttpServlet {
	//private static final long serialVersionUID = 1L; // commented against V210416.
	Connection con = null;
	CallableStatement cstmt = null;
	ResultSet rst = null;
	MultiFactorDeductRuleBean outPatBean = null;
	java.util.Properties p;
	String facilityId="";
	String client_ip_address="";
	String login_user="";
	String str_error_level = "", str_sysmesage_id="", str_error_text="";
	HttpSession session; 
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	String oldEndDate="";
	String userChangedEndDate = "";
	String locale = "";
	Locale loc = null;
	ResourceBundle rb = null;
	ResourceBundle rb1 = null;
	ResourceBundle rb2 = null;

	String payerRefCode  = ""; //V211027
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BLInsApprDrugsMasterServlet() {
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
		System.err.println("Inside doPost method");
		con = ConnectionManager.getConnection(request);
		request= new XSSRequestWrapper(request);
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Content-Type-Options", "nosniff");
		try{
			System.err.println("Inside doPost method1");
			session = request.getSession(false);
			locale = (String)session.getAttribute("LOCALE");
			loc = new Locale(locale);
			System.err.println("Inside doPost method2");
			rb = ResourceBundle.getBundle("eBL.resources.Messages",loc);
			rb1 = ResourceBundle.getBundle("eSM.resources.Messages",loc);
			rb2 = ResourceBundle.getBundle("eBL.resources.MessagesExtOne",loc);

			HashMap returnMap = new HashMap();

			returnMap=insUpdApprDrugsData(request,response);
		    System.err.println("Inside doPost method6");
						
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
							error = error+mapValue+"<br/>";
							err_val = 2;
					}
				}				
			}
			if(error.length()==0){
				try{
					error = rb1.getString("RECORD_INSERTED");
				}
				catch(Exception rbException){
					rbException.printStackTrace();
					System.err.println("Exceprion in RB ->"+rbException);
					error = "APP-SM0070 Operation Completed Successfully ....";					
				}
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
	
	private HashMap insUpdApprDrugsData(HttpServletRequest request,
			HttpServletResponse response) {
		System.err.println("Inside insUpdApprDrugsData");
		
		HashMap returnMap = new HashMap();
		boolean insertable = false;
		try{
			this.p = (java.util.Properties) session.getValue( "jdbc" ) ;
			facilityId = (String) session.getValue( "facility_id" ) ;  
			client_ip_address = this.p.getProperty("client_ip_address");
			login_user = this.p.getProperty( "login_user" ) ; 
			System.err.println("facilityId id: "+facilityId);
			System.err.println("client_ip_address: "+client_ip_address);
			System.err.println("login_user: "+login_user);
			
			String fac_Id = (String)request.getParameter("facility");		
			String billingGrpID = (String) request.getParameter("billingGrpCode");
			String payerGrpCode = (String) request.getParameter("payerGrpCode");
			String payerCode = (String) request.getParameter("payerCode");
			String policyTypeCode = (String) request.getParameter("policyTypeCode");			

			System.err.println("Inside BLInsuranceApprDrugsMasterServlet");
			String bean_id   = "@BLInsuranceApprDrugsBean" ;
			String bean_name = "eBL.BLInsuranceApprDrugsBean";
			BLInsuranceApprDrugsBean bean			= (BLInsuranceApprDrugsBean)PersistenceHelper.getBeanObject( bean_id, bean_name, request);
			ArrayList indir_order_status = new ArrayList(bean.getOrderSatList());
			System.err.println("indir_order_status in servlet:"+indir_order_status);
			
			HashMap sel_drug_list = new HashMap(bean.getSelectedInsApprdDrugs());
			
			System.err.println("session.setAttribute:"+sel_drug_list);
			
			System.err.println("servlet general values:"+facilityId+"/"+login_user+"/"+client_ip_address);
		
			System.err.println("servlet values:"+fac_Id+"/"+billingGrpID+"/"+payerGrpCode+"/"+payerCode+"/"+policyTypeCode);				
			
			String procSql = "{ call   blinsdrug.ins_upd_ph_drug_agreement (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }";
	
			int i=1;
			
			if(sel_drug_list != null) 
			{
				Iterator itr = sel_drug_list.keySet().iterator();
			
				while (itr.hasNext())
				{
					System.err.println("Inside loop begins");
					
					String key = (String) itr.next();
					String value = (String) sel_drug_list.get(key);
					System.err.println("value:"+value);
					String[] val1 = value.split("~");
					String isDrugApprYN = val1[2];
					String IPYN = val1[3];
					String DCYN = val1[4];
					String OPYN = val1[5];
					String EMYN = val1[6];

					cstmt = con.prepareCall(procSql);							
					cstmt.setString(1, fac_Id);
					cstmt.setString(2, billingGrpID);
					cstmt.setString(3, payerGrpCode);
					cstmt.setString(4, payerCode);
					cstmt.setString(5, policyTypeCode);
					cstmt.setString(6, key);
					cstmt.setString(7, isDrugApprYN);
					cstmt.setString(8, IPYN);
					cstmt.setString(9, DCYN);
					cstmt.setString(10, OPYN);
					cstmt.setString(11, EMYN);
					cstmt.setString(12, "N");
					cstmt.setString(13, login_user);
					cstmt.setString(14, client_ip_address);
					cstmt.setString(15, facilityId);					
					cstmt.setString(16, login_user);
					cstmt.setString(17, client_ip_address);
					cstmt.setString(18, facilityId);										
					cstmt.registerOutParameter(19, java.sql.Types.VARCHAR);
					cstmt.registerOutParameter(20, java.sql.Types.VARCHAR);
					cstmt.registerOutParameter(21, java.sql.Types.VARCHAR);
					
					cstmt.execute();
					
					str_error_level = cstmt.getString(19);
					System.err.println("str_error_level is: "+str_error_level);
					
					str_sysmesage_id = cstmt.getString(20);
					System.err.println("str_sysmesage_id is: "+str_sysmesage_id);
					
					str_error_text = cstmt.getString(21);
					System.err.println("str_error_text is: "+str_error_text);
					
					if(str_error_level==null && str_error_text==null){
						System.err.println("Record Savedd");
					}
					
					String errAdd = "errAdd"+i;
					//String errTextAdd = "errTextAdd"+i;
					
					if(str_error_level!=null || str_error_text!=null){
						returnMap.put(errAdd, str_error_text);
					}

					if(str_sysmesage_id!=null){
						String msgAdd = "";
						if(str_sysmesage_id.contains("|")){
							String msgArr[] = str_sysmesage_id.split("\\|");
							for(int l=0;l<msgArr.length;l++){
								msgAdd = "msgAdd"+i+"-"+l;
								
								try{
									msgArr[l] = rb.getString(msgArr[l]);
								}
								catch(Exception rbException){
									try{
										System.err.println("msgArr[l] inside PD try:"+msgArr[l]);
										msgArr[l] = rb2.getString(msgArr[l]);
									}
									catch(Exception rbException1){
										rbException.printStackTrace();
										rbException1.printStackTrace();
										System.err.println("Exceprion in RB PD->"+rbException);
										System.err.println("Exceprion in RB PD ->"+rbException1);
									}	
								}
								returnMap.put(msgAdd, msgArr[l]);
							}
						}else{
							msgAdd = "msgAdd"+i;
							
							try{
								str_sysmesage_id = rb.getString(str_sysmesage_id);
							}
							catch(Exception rbException){
								try{
									str_sysmesage_id = rb2.getString(str_sysmesage_id);
								}
								catch(Exception rbException1){
									rbException.printStackTrace();
									rbException1.printStackTrace();
									System.err.println("Exceprion in RB ->"+rbException);
									System.err.println("Exceprion in RB ->"+rbException1);
								}
							}
							returnMap.put(msgAdd, str_sysmesage_id);
						}
					}
					i++;
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
			e.printStackTrace();
			System.err.println("Exception is "+e);
			insertable = false;
			returnMap.put("internalError", "Internal Error");
		}
		finally{
			returnMap.put("status", new Boolean(insertable));
			return returnMap;
		}
	}
}






