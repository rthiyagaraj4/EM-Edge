package eBL;

import java.io.*;
import java.io.File;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.StringTokenizer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import webbeans.eCommon.ConnectionManager;
import com.ehis.persist.PersistenceHelper;
import eBL.Common.*;
import eXH.*;
import eXH.resources.*;
import eCommon.XSSRequestWrapper; //V220324

import org.apache.commons.fileupload.DiskFileUpload;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.DefaultFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * Servlet implementation class PolicyDefinitionMasterServlet
 */
public class BLRCMTransactionsServlet extends HttpServlet {
	//private static final long serialVersionUID = 1L; // commented against V210416.
	Connection con = null;
	CallableStatement cstmt = null;
	PreparedStatement pstmt = null;
	ResultSet rst = null;
	Boolean isUpdateSuccess=false;
	BLRCMTransactionsBean outPatBean = null;
	java.util.Properties p;
	String facilityId="";
	String client_ip_address="";
	String login_user="";
	String str_error_code = "", str_sysmesage_id="", message="";
	HttpSession session; 
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	String called_from_dashboard_YN="";
	String userChangedEndDate = "";
	String locale = "";
	Locale loc = null;
	ResourceBundle rb = null;
	ResourceBundle rb1 = null;
	ResourceBundle rb2 = null;
	String refId = "", refTypeId = "", claimId = "";
	String mode = "", request_type = "", claim_id = "", claim_status = "", claim_status_desc = "", str_error_text = ""; 
	String claimStatus = "", patientId = "";	
	String strQuery = "";
	String params = "";
	int col=0;
	int err_value = 1;
	String filePath="";
	String payerRefCode  = ""; //V211027
	PrintWriter out;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BLRCMTransactionsServlet() {
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
 		return (inputString == null) ? "" : inputString;
 	}
	
    private String returnVal(String inputString,String outputString) {
		return (inputString == null) ? outputString : inputString;
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.err.println("Inside doPost method");
		boolean isMultiPart=false;
		String filePath="",fileExt="",sFileSeparator="";
		
		try
		{	
			con = ConnectionManager.getConnection(request);
			request= new XSSRequestWrapper(request);			
			response.addHeader("X-XSS-Protection", "1; mode=block");
			response.addHeader("X-Content-Type-Options", "nosniff");
			String p_action_id = request.getParameter("p_action_id"); 
			isMultiPart=ServletFileUpload.isMultipartContent(request);
			filePath=request.getParameter("filePath");
			System.err.println("Inside doPost method1");
			session = request.getSession(false);
			locale = (String)session.getAttribute("LOCALE");
			loc = new Locale(locale);
			rb = ResourceBundle.getBundle("eBL.resources.Messages",loc);
			rb1 = ResourceBundle.getBundle("eSM.resources.Messages",loc);
			rb2 = ResourceBundle.getBundle("eBL.resources.MessagesExtOne",loc);
			called_from_dashboard_YN = checkForNull(request.getParameter("called_from_dashboard_YN"));
			params = request.getQueryString() ;
			if(params==null || params.equals("")) params="";
			HashMap returnMap = new HashMap();
			HashMap returnMap1 = new HashMap();
			HashMap returnMap2 = new HashMap();  
			String beanId = "bl_BLRCMTransactionsBean";
			String beanName = "eBL.BLRCMTransactionsBean";
			System.err.println("Inside doPost method4");	
			this.p = (java.util.Properties) session.getValue( "jdbc" ) ; 
			facilityId = (String) session.getValue( "facility_id" ) ;  
			client_ip_address = this.p.getProperty("client_ip_address"); 
			login_user = this.p.getProperty( "login_user" ) ; 
			System.err.println("facilityId id: "+facilityId);
			System.err.println("client_ip_address: "+client_ip_address);
			System.err.println("login_user: "+login_user);

			BLRCMTransactionsBean policyBean = (BLRCMTransactionsBean)PersistenceHelper.getBeanObject(beanId, beanName, request);	
				
		
				
			if("E".equals(p_action_id)){
				exportData(request,response);
			}
			else
			{
				System.out.println("isMultiPart "+isMultiPart);
				//if(isMultiPart){
					System.out.println("filePath1 "+filePath);
					DefaultFileItemFactory defaultfileitemfactory = new DefaultFileItemFactory(100,new File(filePath));
					ServletFileUpload upload = new ServletFileUpload(defaultfileitemfactory);
					int i=0;
					String name="",value="",billNum="",billDocTypeCode="",apprDocRefNum="";
					try {
			            List<FileItem> items = upload.parseRequest(request);
			            for (FileItem item : items) {
						if(isMultiPart){
							if(item.isFormField()){
								name = (String) item.getFieldName();	
								value = (String) item.getString();
								if(name.equals("apprDocRefNum_"+i)) {
									apprDocRefNum= checkForNull(value);
									apprDocRefNum=apprDocRefNum.replace("/", "_");
									System.out.println("155 apprDocRefNum=>"+apprDocRefNum);
									
								}
							}
							if(item.isFormField()){
								name = (String) item.getFieldName();	
								value = (String) item.getString();
								if(name.equals("billDocTypeCode_"+i)) {
									billDocTypeCode= checkForNull(value);
									System.out.println("155 billDocTypeCode=>"+billDocTypeCode);
									
								}
							}
							if(item.isFormField()){
								name = (String) item.getFieldName();	
								value = (String) item.getString();
								if(name.equals("claimStatus_"+i)) {
									claimStatus= checkForNull(value);
									System.out.println("155 claimStatus_=>"+claimStatus);
									
								}
							}
							if(item.isFormField()){
								name = (String) item.getFieldName();	
								value = (String) item.getString();
								if(name.equals("billNum_"+i)) {
									billNum= checkForNull(value);
									System.out.println("155 billNum=>"+billNum);
									i++;
								}
							}
							if(item.isFormField()){
								name = (String) item.getFieldName();	
								value = (String) item.getString();
								if(name.equals("patientId_"+i)) {
									patientId= checkForNull(value);
									System.out.println("155 patientId=>"+patientId);
									
								}
							}						
							else if (!item.isFormField() ) {
			                  // Handle uploaded file claimID_
			                	String file="";
			                    String fileName = item.getName();
			                    if(!fileName.equals("")){
				                    StringTokenizer strTok = new StringTokenizer(fileName,".");
				                    System.out.println("fileName "+fileName);
				    				while(strTok.hasMoreTokens())
				    				{
				    					fileExt = strTok.nextToken();
				    					System.out.println("fileExt "+fileExt);
				    				}
				    				sFileSeparator=System.getProperty("file.separator");
				    				//ApprDocRefNum_BillDocTypeCodeBillDocNum.fileext
				    				file = filePath + sFileSeparator+apprDocRefNum+"_"+billDocTypeCode+"_"+billNum+"."+fileExt;
				    				String arr[]=apprDocRefNum.split("_");
				    				//file = filePath + sFileSeparator+"Claim_"+billNum+"."+fileExt;
				    				
				    				System.out.println(" arr0 "+ arr[0]+" arr1 "+arr[1]);
				    				System.out.println("file "+file);
				    				java.io.File uploadFile = new File(file);
				    				item.write(uploadFile);
									if(uploadFile.length()>0){
										pstmt=con.prepareStatement("UPDATE BL_CLAIM_BILL_DTL SET DOCUMENT_PATH=?,FILE_NAME=?,UPLOAD_STATUS=?,MODIFIED_BY_ID=?" +
														",MODIFIED_DATE=sysdate,MODIFIED_AT_WS_NO=?,MODIFIED_FACILITY_ID=? WHERE  operating_facility_id=? and patient_id=? and  APPR_DOC_REF_NUMBER=? AND BILL_DOC_NUM=? and BILL_DOC_TYPE_CODE=? and APPR_DOC_REF_TYPE_CODE=?");
										// and  APPR_DOC_REF_NUMBER=? AND BILL_DOC_NUM=? and BILL_DOC_TYPE_CODE=? and APPR_DOC_REF_TYPE_CODE=?
										System.out.println(" login_user "+ login_user+" facilityId "+facilityId);
					    				System.out.println("file "+file +" patientId "+patientId +" billNum "+billNum);
					    				String filename=apprDocRefNum+"_"+billDocTypeCode+"_"+billNum+"."+fileExt;
										pstmt.setString(1,filePath);
										pstmt.setString(2,filename);
										pstmt.setString(3,"Y");
										pstmt.setString(4,login_user);
										pstmt.setString(5,client_ip_address);
										pstmt.setString(6,facilityId);
										pstmt.setString(7,facilityId);
										pstmt.setString(8,patientId);
										//pstmt.setString(9,billNum);
										pstmt.setString(9,arr[1]);
										pstmt.setString(10,billNum);
										pstmt.setString(11,billDocTypeCode);
										pstmt.setString(12,arr[0]);
										System.out.println("before execute update");
										int insert_result = pstmt.executeUpdate();
										System.out.println("after execute update "+insert_result);
										if(insert_result==1){
											con.commit();
										}else{
											con.rollback();
										}
										
									}
			                    }
			                }
			            }	
			            }
			        } catch (Exception e) {
			            e.printStackTrace();
			            System.out.println("File upload failed: " + e.getMessage());
			        }
			
					try{
						HashMap<String, List<BLRCMTransactionsBean> > rcmTransData = policyBean.getPolicyMap();
						rcmTransData.get("BLRCMTransactionsDtl");
						if(!rcmTransData.isEmpty()){
							insertRCMTransactiosDetails(request,response,policyBean);
						}
						
					}catch(Exception ex){
						System.err.println("Exception here is : "+ex);
					}
				}
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
	
	
	private void insertRCMTransactiosDetails(HttpServletRequest request,
			HttpServletResponse response, BLRCMTransactionsBean policyBean) throws javax.servlet.ServletException,
			IOException {
				System.err.println("Inside rcm transaction function");
		HashMap returnMap = new HashMap();
		boolean insertable = false;
		
		try{
			HashMap<String,List<BLRCMTransactionsBean>> policyMap = policyBean.getPolicyMap();
			con.setAutoCommit(false);
			List<BLRCMTransactionsBean> inclList = null; 
			filePath=request.getParameter("filePath");
			System.err.println("filePath in RCM function "+filePath);
					
			if(!(policyMap == null || policyMap.isEmpty())){
				inclList = policyMap.get("BLRCMTransactionsDtl");  
				System.err.println("Policy map is called..");
				System.err.println("inclList contains:"+inclList);
				if(inclList == null){
					inclList = new ArrayList<BLRCMTransactionsBean>();
					outPatBean = new BLRCMTransactionsBean();
					inclList.add(outPatBean);
				}
			}
			else{
				policyMap = new HashMap<String,List<BLRCMTransactionsBean>>();
				inclList = new ArrayList<BLRCMTransactionsBean>();
				outPatBean = new BLRCMTransactionsBean();
				inclList.add(outPatBean);		
			}
			
			String RCMTransQueryIns = "";
			RCMTransQueryIns = "{ call   XHPAYER.SET_PAYER_PREAUTH_HEADER (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }";  
			
			int i=1;
			
			for(BLRCMTransactionsBean outPatBean : inclList)
			{
				if("Y".equals(outPatBean.getCheckedStatus()) && ("P".equals(outPatBean.getClaimStatus()) || "C".equals(outPatBean.getClaimStatus())))
				{	
					// Insert Mode where claimID is NULL
					try
					{
						
						if("".equals(outPatBean.getClaimID()) && "P".equals(outPatBean.getClaimStatus()))
						{

						System.err.println("Inside Insert mode: ");
						mode = "I";
						cstmt = con.prepareCall("{ ? = call  BL_INSU_DASHBOARD.bl_intf_get_bill_type_claim(?,?,?,?)}");
						cstmt.registerOutParameter(1, java.sql.Types.VARCHAR);
						cstmt.setString(2, outPatBean.getFacilityId());
						cstmt.setString(3, outPatBean.getBillDocTypeCode());
						cstmt.setString(4, outPatBean.getBillNum());
						cstmt.setString(5, mode);
						cstmt.execute();
						request_type = checkForNull(cstmt.getString(1));
						System.err.println("request_type "+request_type);
						claim_id = null;
						claim_status = "S";
						claim_status_desc = "Send to Insurance"; 
						
						cstmt = con.prepareCall(RCMTransQueryIns);	
						
						cstmt.setString(1, mode);
						cstmt.registerOutParameter(2, java.sql.Types.VARCHAR);
						cstmt.registerOutParameter(3, java.sql.Types.VARCHAR);
						cstmt.registerOutParameter(4, java.sql.Types.VARCHAR);
						cstmt.registerOutParameter(5, java.sql.Types.VARCHAR);
						cstmt.registerOutParameter(6, java.sql.Types.VARCHAR);
						cstmt.setString(7, outPatBean.getFacilityId());
						cstmt.setString(8, request_type);
						cstmt.setString(9, outPatBean.getPatientId());
						cstmt.setString(10, outPatBean.getEncounterId());
						cstmt.setString(11, outPatBean.getBillDocTypeCode());
						cstmt.setString(12, outPatBean.getBillNum());
						cstmt.setString(13, claim_status);
						cstmt.setString(14, claim_status_desc);
						cstmt.setString(15, claim_id);
						cstmt.setString(16, outPatBean.getPolicyTypeCode());
						cstmt.setString(17, outPatBean.getMembershipNo());
						cstmt.setString(18, outPatBean.getPayerCode());
						cstmt.setString(19, outPatBean.getPayerGroupCode());
						cstmt.setString(20, outPatBean.getFileName());
						cstmt.setString(21, filePath);
						cstmt.setString(22, login_user);
						cstmt.setString(23, client_ip_address);
						cstmt.setString(24, facilityId);
						cstmt.setString(25, login_user);
						cstmt.setString(26, client_ip_address);
						cstmt.setString(27, facilityId);
						
						cstmt.execute();
					
						str_error_code = checkForNull(cstmt.getString(2));
						System.err.println("str_error_code is: "+str_error_code);
						str_error_text = checkForNull(cstmt.getString(3));
						System.err.println("str_error_text is: "+str_error_text);
						refId = checkForNull(cstmt.getString(4));
						System.err.println("refId is: "+refId);
						refTypeId = checkForNull(cstmt.getString(5));
						System.err.println("refTypeId is: "+refTypeId);
						claimId = checkForNull(cstmt.getString(6));
						System.err.println("claimId is: "+claimId);
					
						if(!("".equals(claimId)) && "".equals(str_error_text))
						{
							System.err.println("Successful Tranaction: "+claimId);
							
							strQuery="UPDATE BL_CLAIM_BILL_DTL set claim_id = ?,claim_status=?,MODIFIED_BY_ID=?" +												",MODIFIED_DATE=sysdate,MODIFIED_AT_WS_NO=?,MODIFIED_FACILITY_ID=? where OPERATING_FACILITY_ID=? and bill_doc_type_code = ? and bill_doc_num = ?"; 
							pstmt = con.prepareStatement(strQuery);
							pstmt.setString(1,claimId);
							pstmt.setString(2,claim_status);
							pstmt.setString(3,login_user);
							pstmt.setString(4,client_ip_address);
							pstmt.setString(5,facilityId);
							pstmt.setString(6,facilityId);
							pstmt.setString(7,outPatBean.getBillDocTypeCode());  
							pstmt.setString(8,outPatBean.getBillNum());
							
							col=pstmt.executeUpdate();
							
							if(col == 1){
								isUpdateSuccess = true;			
							}
							else{
								isUpdateSuccess = false;
							}
							
							if(isUpdateSuccess){
							
								try{				
									strQuery="UPDATE bl_claim_service_dtl set claim_id = ?,claim_status=?,MODIFIED_BY_ID=?" +												",MODIFIED_DATE=sysdate,MODIFIED_AT_WS_NO=?,MODIFIED_FACILITY_ID=? where OPERATING_FACILITY_ID=? and bill_doc_type_code = ? and bill_doc_num = ?"; 
									pstmt = con.prepareStatement(strQuery);
									pstmt.setString(1,claimId);
									pstmt.setString(2,claim_status);
									pstmt.setString(3,login_user);
									pstmt.setString(4,client_ip_address);
									pstmt.setString(5,facilityId);
									pstmt.setString(6,facilityId);
									pstmt.setString(7,outPatBean.getBillDocTypeCode());  
									pstmt.setString(8,outPatBean.getBillNum());
									
									col=pstmt.executeUpdate();
								
								
								
								}catch(Exception e){
									e.printStackTrace();
								}
							
							}
							
							mode = "U";
							cstmt = con.prepareCall(RCMTransQueryIns);	
						
							cstmt.setString(1, mode);
							cstmt.registerOutParameter(2, java.sql.Types.VARCHAR);
							cstmt.registerOutParameter(3, java.sql.Types.VARCHAR);
							cstmt.registerOutParameter(4, java.sql.Types.VARCHAR);
							cstmt.registerOutParameter(5, java.sql.Types.VARCHAR);
							cstmt.registerOutParameter(6, java.sql.Types.VARCHAR);
							cstmt.setString(7, outPatBean.getFacilityId());
							cstmt.setString(8, request_type);
							cstmt.setString(9, outPatBean.getPatientId());
							cstmt.setString(10, outPatBean.getEncounterId());
							cstmt.setString(11, outPatBean.getBillDocTypeCode());
							cstmt.setString(12, outPatBean.getBillNum());
							cstmt.setString(13, claim_status);
							cstmt.setString(14, claim_status_desc);
							cstmt.setString(15, claimId);
							cstmt.setString(16, outPatBean.getPolicyTypeCode());
							cstmt.setString(17, outPatBean.getMembershipNo());
							cstmt.setString(18, outPatBean.getPayerCode());
							cstmt.setString(19, outPatBean.getPayerGroupCode());
							cstmt.setString(20, outPatBean.getFileName());
							cstmt.setString(21, filePath);
							cstmt.setString(22, login_user);
							cstmt.setString(23, client_ip_address);
							cstmt.setString(24, facilityId);
							cstmt.setString(25, login_user);
							cstmt.setString(26, client_ip_address);
							cstmt.setString(27, facilityId);
								
							cstmt.execute();
						
							str_error_code = checkForNull(cstmt.getString(2));
							System.err.println("str_error_code is: "+str_error_code);
							str_error_text = checkForNull(cstmt.getString(3));
							System.err.println("str_error_text is: "+str_error_text);
							refId = checkForNull(cstmt.getString(4));
							System.err.println("refId is: "+refId);
							refTypeId = checkForNull(cstmt.getString(5));
							System.err.println("refTypeId is: "+refTypeId);
							claimId = checkForNull(cstmt.getString(6));
							System.err.println("claimId is: "+claimId);
							
							insertable = true;			
						}else{
							
							strQuery="UPDATE BL_CLAIM_BILL_DTL set remarks = ? ,claim_status=?,claim_status=?,MODIFIED_BY_ID=?" +												",MODIFIED_DATE=sysdate,MODIFIED_AT_WS_NO=?,MODIFIED_FACILITY_ID=? where OPERATING_FACILITY_ID=? and bill_doc_type_code = ? and bill_doc_num = ?"; 
							pstmt = con.prepareStatement(strQuery);
							pstmt.setString(1,str_error_text);
							pstmt.setString(2,outPatBean.getClaimStatus());
							pstmt.setString(3,login_user);
							pstmt.setString(4,client_ip_address);
							pstmt.setString(5,facilityId);
							pstmt.setString(6,facilityId);
							pstmt.setString(7,outPatBean.getBillDocTypeCode());  
							pstmt.setString(8,outPatBean.getBillNum());
							
							col=pstmt.executeUpdate();
							
							insertable = true;	
						}
						
						// call interface procedure in Update mode with same request type - new changes for namrata
						
					}
					// Update mode where Claim ID exists
					else
					{

						System.err.println("Inside update mode: ");
						// Move this interface procedure call below the billing table update statements	 - new changes for namrata	
						
						mode = "U";
						cstmt = con.prepareCall("{ ? = call  BL_INSU_DASHBOARD.bl_intf_get_bill_type_claim(?,?,?,?)}");
						cstmt.registerOutParameter(1, java.sql.Types.VARCHAR);
						cstmt.setString(2, outPatBean.getFacilityId());
						cstmt.setString(3, outPatBean.getBillDocTypeCode());
						cstmt.setString(4, outPatBean.getBillNum());
						cstmt.setString(5, mode);
						cstmt.execute();
						request_type = checkForNull(cstmt.getString(1));
						System.err.println("request_type "+request_type);
						claim_id = outPatBean.getClaimID();
						claim_status_desc = "Send to Insurance";
						claim_status = "S";

						strQuery="UPDATE BL_CLAIM_BILL_DTL set claim_status=?,MODIFIED_BY_ID=?" +												",MODIFIED_DATE=sysdate,MODIFIED_AT_WS_NO=?,MODIFIED_FACILITY_ID=?  where OPERATING_FACILITY_ID=? and bill_doc_type_code = ? and bill_doc_num = ?"; 
						pstmt = con.prepareStatement(strQuery);
						pstmt.setString(1,claim_status);
						pstmt.setString(2,login_user);
						pstmt.setString(3,client_ip_address);
						pstmt.setString(4,facilityId);
						pstmt.setString(5,facilityId);
						pstmt.setString(6,outPatBean.getBillDocTypeCode());  
						pstmt.setString(7,outPatBean.getBillNum());
							
						col=pstmt.executeUpdate();
							
							
						if(isUpdateSuccess){
							
							try{				
								strQuery="UPDATE bl_claim_service_dtl set claim_status=? where OPERATING_FACILITY_ID=? and bill_doc_type_code = ? and bill_doc_num = ?"; 
								pstmt = con.prepareStatement(strQuery);
								pstmt.setString(1,claim_status);
								pstmt.setString(2,facilityId);
								pstmt.setString(3,outPatBean.getBillDocTypeCode());  
								pstmt.setString(4,outPatBean.getBillNum());
										
								col=pstmt.executeUpdate();
									
							}catch(Exception e){
								e.printStackTrace();
							}
								
						}
						
						

						cstmt = con.prepareCall(RCMTransQueryIns);	
					
						cstmt.setString(1, mode);
						cstmt.registerOutParameter(2, java.sql.Types.VARCHAR);
						cstmt.registerOutParameter(3, java.sql.Types.VARCHAR);
						cstmt.registerOutParameter(4, java.sql.Types.VARCHAR);
						cstmt.registerOutParameter(5, java.sql.Types.VARCHAR);
						cstmt.registerOutParameter(6, java.sql.Types.VARCHAR);
						cstmt.setString(7, outPatBean.getFacilityId());
						cstmt.setString(8, request_type);
						cstmt.setString(9, outPatBean.getPatientId());
						cstmt.setString(10, outPatBean.getEncounterId());
						cstmt.setString(11, outPatBean.getBillDocTypeCode());
						cstmt.setString(12, outPatBean.getBillNum());
						cstmt.setString(13, outPatBean.getClaimStatus());
						cstmt.setString(14, claim_status_desc);
						cstmt.setString(15, claim_id);
						cstmt.setString(16, outPatBean.getPolicyTypeCode());
						cstmt.setString(17, outPatBean.getMembershipNo());
						cstmt.setString(18, outPatBean.getPayerCode());
						cstmt.setString(19, outPatBean.getPayerGroupCode());
						cstmt.setString(20, outPatBean.getFileName());
						cstmt.setString(21, filePath);
						cstmt.setString(22, login_user);
						cstmt.setString(23, client_ip_address);
						cstmt.setString(24, facilityId);
						cstmt.setString(25, login_user);
						cstmt.setString(26, client_ip_address);
						cstmt.setString(27, facilityId);
											
						cstmt.execute();
						
						str_error_code = checkForNull(cstmt.getString(2));
						System.err.println("str_error_code is: "+str_error_code);
						str_error_text = checkForNull(cstmt.getString(3));
						System.err.println("str_error_text is: "+str_error_text);
						refId = checkForNull(cstmt.getString(4));
						System.err.println("refId is: "+refId);
						refTypeId = checkForNull(cstmt.getString(5));
						System.err.println("refTypeId is: "+refTypeId);
						claimId = checkForNull(cstmt.getString(6));
						System.err.println("claimId is: "+claimId);

						if(!"".equals(str_error_text))
						{
							strQuery="UPDATE BL_CLAIM_BILL_DTL set remarks = ? ,claim_status=? where OPERATING_FACILITY_ID=? and bill_doc_type_code = ? and bill_doc_num = ?"; 
							pstmt = con.prepareStatement(strQuery);
							pstmt.setString(1,str_error_text);
							pstmt.setString(2,outPatBean.getClaimStatus());
							pstmt.setString(3,facilityId);
							pstmt.setString(4,outPatBean.getBillDocTypeCode());  
							pstmt.setString(5,outPatBean.getBillNum());
							
							col=pstmt.executeUpdate();
																		
						}
						insertable = true;
					}
					}catch(Exception ex){
						ex.printStackTrace();
						err_value = 0;
						response.sendRedirect("../eBL/jsp/BLRCMTransactionsReload.jsp?message=" + java.net.URLEncoder.encode( ex.getMessage(),"UTF-8" ) +"&err_value="+err_value+"&called_from_dashboard_YN="+called_from_dashboard_YN+"&"+params);
					}
				}
			}			
						
			if(cstmt!=null)  
				cstmt.close();
			
			message = "Records Successfully Submitted";
			response.sendRedirect("../eBL/jsp/BLRCMTransactionsReload.jsp?message=" + java.net.URLEncoder.encode( message,"UTF-8" ) +"&err_value="+err_value+"&called_from_dashboard_YN="+called_from_dashboard_YN+"&"+params);
						
		}catch(Exception e){	
			e.printStackTrace();
			System.err.println("Exception is "+e);
		}
		finally{
			System.err.println("Value of insertable is: "+insertable);
			try{
				if(insertable)
					con.commit();	
				else{
					con.rollback();
				}
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}
	}
	
	
	@SuppressWarnings("deprecation")
	private void exportData(HttpServletRequest request,	HttpServletResponse response) throws javax.servlet.ServletException,IOException{
		java.util.Properties p = null;
		HttpSession session = null;

		Connection conn=null;
		String facilityId		= "";
		String locale			= "";
		CallableStatement callStmt = null;

		String reportId 		= "BLRRCMTRX";
		String moduleId 		= "BL";
		PreparedStatement pstmt		= null;
		ResultSet rs				= null;		
		
		session = request.getSession(false);
		p = (java.util.Properties) session.getValue("jdbc");
		facilityId = (String) session.getValue("facility_id");
		conn = ConnectionManager.getConnection(request);
		locale = p.getProperty("LOCALE");
		locale = (locale == null || locale.equals(""))?"en":locale;
		java.util.Locale loc = new java.util.Locale(locale);
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());       
		 
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/vnd.ms-excel;charset=UTF-8");
		response.addHeader("Content-Disposition", "inline");
		response.setHeader("Content-Disposition","attachment;filename="+reportId+"-"+timestamp+".csv");
			
		
		try {
				
			java.util.Date dNow = new java.util.Date();
			java.text.SimpleDateFormat ft = new java.text.SimpleDateFormat("dd/MM/yyyy HH:mm"); 
			String repGenDateTime		= ft.format(dNow);			
						
			String repHdr		= "";
			String repRes		= "";
			String repCellWidth	= "";
			String repQuery		= "";
			String repQuery1		= "";
			String argumentList	= "";
			
			pstmt = conn.prepareStatement("select REP_COL_HDR,REP_COL_RES,REP_COL_WIDTH,REP_QUERY,REP_QUERY1,REP_ARGS from SM_REP_EXL_EXPORT where REPORT_ID = '"+reportId+"' ");
			rs = pstmt.executeQuery();
			if(rs!=null && rs.next()){
				repHdr	= checkForNull(rs.getString("REP_COL_HDR"));//Header 
				repRes	= checkForNull(rs.getString("REP_COL_RES"));//Result Columns
				repCellWidth	= checkForNull(rs.getString("REP_COL_WIDTH"));//Cell Width
				repQuery	= checkForNull(rs.getString("REP_QUERY"));//Query
				repQuery1	= checkForNull(rs.getString("REP_QUERY1"));//Query
				argumentList	= checkForNull(rs.getString("REP_ARGS"));//Arguments
			}

			repQuery	= repQuery + " "+ repQuery1;

			if(pstmt != null)    pstmt.close();
			if(rs != null)    rs.close();
			
			ArrayList<String> resColumnsArr = new ArrayList<String>();
			ArrayList<String> resColumnsWidthArr = new ArrayList<String>();
			StringTokenizer resultTokens=new StringTokenizer(repRes,",");
			StringTokenizer repCellWidthTokens=new StringTokenizer(repCellWidth,",");
			
			while(resultTokens.hasMoreTokens() && repCellWidthTokens.hasMoreTokens()){
				String resCol	= resultTokens.nextToken();
				String resColWidth	= repCellWidthTokens.nextToken();
				resColumnsArr.add(resCol);
				resColumnsWidthArr.add(resColWidth);
			}		
			
			HSSFWorkbook workbook = new HSSFWorkbook();
			HSSFSheet sheet = workbook.createSheet(reportId);

			String hdrSql =  "{call get_header_dtls(?,?,?,?,?,?,?,?)}";
			callStmt = conn.prepareCall(hdrSql);
			callStmt.setString(1, moduleId);
			callStmt.setString(2, reportId);
			callStmt.setString(3, facilityId);
			callStmt.registerOutParameter(4, java.sql.Types.VARCHAR);
			callStmt.registerOutParameter(5,java.sql.Types.VARCHAR);
			callStmt.registerOutParameter(6,java.sql.Types.VARCHAR);
			callStmt.registerOutParameter(7,java.sql.Types.VARCHAR);
			callStmt.setString(8, locale);
			String reportName 		= "";
			String reportExecName 	= "";
			String facilityName 	= "";
			String siteName 		= "";

			try{
				callStmt.execute();
				reportName 		= callStmt.getString(4);
				reportExecName 	= callStmt.getString(5);
				facilityName 	= callStmt.getString(6);
				siteName 		= callStmt.getString(7);
			} catch(Exception e1) {
				e1.printStackTrace();
			} finally{
				callStmt.close();
			}
			int i=1;
			int rowCount =1;
			HSSFRow row = null;
			
			
			HSSFFont font = workbook.createFont();
			font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
			font.setFontHeightInPoints((short)12);
			HSSFCellStyle style = workbook.createCellStyle();
			style.setFont(font);

			HSSFCellStyle style1=workbook.createCellStyle();
			style1.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			style1.setBorderTop(HSSFCellStyle.BORDER_THIN);
			style1.setBorderRight(HSSFCellStyle.BORDER_THIN);
			style1.setBorderLeft(HSSFCellStyle.BORDER_THIN);


			Region cellRegion1 = new Region(1, (short)3, 1, (short)4); 
			Region cellRegion2 = new Region(2, (short)3, 2, (short)4); 
			Region cellRegion3 = new Region(3, (short)3, 3, (short)4); 
			sheet.addMergedRegion(cellRegion1);
			sheet.addMergedRegion(cellRegion2);
			sheet.addMergedRegion(cellRegion3);
			
			row				= sheet.createRow(rowCount++);
			HSSFCell hc1	= row.createCell(3);	
			hc1.setCellValue(siteName);
			hc1.setCellStyle(style);
			
			HSSFCell hc4	= row.createCell(5);	
			hc4.setCellValue(repGenDateTime);
			hc4.setCellStyle(style1);

			row				= sheet.createRow(rowCount++);
			HSSFCell hc2	= row.createCell(3);	
			hc2.setCellValue(facilityName);
			hc2.setCellStyle(style);

			row = sheet.createRow(rowCount++);
			HSSFCell hc3 = row.createCell(3);	
			hc3.setCellValue(reportName);
			hc3.setCellStyle(style);

			rowCount	= rowCount+2;

			i=0;
			row = sheet.createRow(rowCount);		
	
		HSSFCellStyle style2=workbook.createCellStyle();

		style2.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		style2.setBorderTop(HSSFCellStyle.BORDER_THIN);
		style2.setBorderRight(HSSFCellStyle.BORDER_THIN);
		style2.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			/*Generating Header*/
			StringTokenizer hdrTokens=new StringTokenizer(repHdr,"~");
			repCellWidthTokens=new StringTokenizer(repCellWidth,",");
			while(hdrTokens.hasMoreTokens() && repCellWidthTokens.hasMoreTokens()){
				String hdr 			= hdrTokens.nextToken(); 
				int width 			= Integer.valueOf(repCellWidthTokens.nextToken()); 
				HSSFCell c1 		= row.createCell(i);	
				c1.setCellValue(hdr);
				sheet.setColumnWidth(i, width);
				c1.setCellStyle(style2);
				i++;
			}
			
			/*Replacing Arguments List with Query*/
			StringTokenizer argumentListTokens=new StringTokenizer(argumentList,",");
			while(argumentListTokens.hasMoreTokens()){
				String arg	= argumentListTokens.nextToken();
				String reqArg	= arg.substring(1);
				String tempString = checkForNull(request.getParameter(reqArg));
				System.err.println("Manivel Servelt:"+tempString);
				if(tempString.indexOf("~~") != -1){
					tempString = tempString.replaceAll("~~","','");
				}
				String argVal	= "'"+tempString+"'";
				if(!arg.equals(":"))
					repQuery		= repQuery.replaceAll(arg, argVal);
			}
			
			rowCount++;
			i=0;
			
			HSSFCellStyle styleRes=workbook.createCellStyle();

			styleRes.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			styleRes.setBorderTop(HSSFCellStyle.BORDER_THIN);
			styleRes.setBorderRight(HSSFCellStyle.BORDER_THIN);
			styleRes.setBorderLeft(HSSFCellStyle.BORDER_THIN);

			
			
			if(!repQuery.equals("")){
				System.err.println("repQuery:"+repQuery);
				pstmt = conn.prepareStatement(repQuery);
				rs = pstmt.executeQuery();
				
				JSONArray arrJSON		= new JSONArray();
				while(rs!=null && rs.next()){
					JSONObject json			= new JSONObject();
					for(int c=0;c<resColumnsArr.size();c++){
						int width 			= Integer.valueOf(resColumnsWidthArr.get(c));
						System.err.println("repQuery-->c:"+c);
						System.err.println("repQuery-->resColumnsArr.get(c):"+resColumnsArr.get(c));
						json.put(resColumnsArr.get(c), checkForNull(rs.getString(resColumnsArr.get(c))));
						json.put(resColumnsArr.get(c)+"_width", width);
						
					}
					arrJSON.add(json);
				}
				
				if(pstmt != null)    pstmt.close();
				if(rs != null)    rs.close();
				for(int count=0;count<arrJSON.size();count++){
					i=0;
					row = sheet.createRow(rowCount);
					JSONObject objects = (JSONObject)arrJSON.get(count);
					for(int k=0;k<resColumnsArr.size();k++){
						String resCol  		= (String) objects.get(resColumnsArr.get(k));;
						Integer resColWidth  = (Integer) objects.get(resColumnsArr.get(k)+"_width");
						int width 			= Integer.valueOf(resColWidth);

						HSSFCell cc 		= row.createCell(i);	
						cc.setCellValue(resCol);
						sheet.setColumnWidth(i,width );
						cc.setCellStyle(styleRes);
						i++;
					}
					rowCount++;			
				}
			}
			workbook.write(response.getOutputStream());

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null)
				ConnectionManager.returnConnection(conn, request);
			
		}
	}


}




