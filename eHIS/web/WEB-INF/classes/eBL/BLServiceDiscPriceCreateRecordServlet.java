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
import java.io.PrintWriter;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import webbeans.eCommon.ConnectionManager;

/**
 * Servlet implementation class BLServiceDiscPriceCreateRecordServlet
 */
public class BLServiceDiscPriceCreateRecordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String facilityId = "";
	String serviceInd = "";
	String serviceCode = "";
	String priceInd = "";
	String priceCode = "";
	String policyCode = "";
	String custGrpCode = "";
	String blngClass = "";
	String rateFactorPriceInd = "";
	String checkCostAvl = "";
	String costInd = "";
	String costAmount = "";
	String ipPriceRate = "";
	String opPriceRate = "";
	String emPriceRate = "";
	String exPriceRate = "";
	String dcPriceRate = "";
	String minCharge = "";
	String maxCharge = "";
	String baseQty = "";
	String priceApplicability = "";
	String applyDiscount = "";
	String discStringForBlngClass = "";
	String priceEffFrom = "";
	String priceEffTo = "";
	String rowMode = "";
	String discountInd = "";
	String discountEffFrom = "";
	String discountEffTo = "";
	String isDiscInsMod = "I";
	String ipDiscPerc = "";
	String opDiscPerc = "";
	String emDiscPerc = "";
	String exDiscPerc = "";
	String dcDiscPerc = "";
	String discApplicability = "";
	String discStatus = "";
	String locale = "";
	java.util.Properties p;
	String facility_id="";
	String client_ip_address="";
	String login_user="";
	String str_error_level = "", str_sysmesage_id="", str_error_text="";
	String mode = "";
	String applyDisct="";
	String discountavl="";
	String discUptoHrs = "";
	String discUptoPercAmt = "";
	
	//Added V181005-Gayathri/MMS-DM-SCF-0243.1/Starts
	String public_chk = "";
	
		String publicChk = "";
		String rateBasis_ind = "";
//Added V181005-Gayathri/MMS-DM-SCF-0243.1/Ends
	Connection con = null;
	CallableStatement cstmt = null;
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	ResourceBundle rb = null;
	Locale loc = null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BLServiceDiscPriceCreateRecordServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings({ "rawtypes", "deprecation" })
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.err.println("Inside BLServiceDiscPriceCreateRecordServlet:"+ request.getQueryString());
		mode = checkForNull(request.getParameter("mode"));
		System.err.println("108,mode===>"+mode);
		HashMap returnMap = new HashMap();
		locale = checkForNull(request.getParameter("locale"));
		HttpSession session  = request.getSession(false);
		p = (java.util.Properties) session.getValue( "jdbc" ) ;
		facility_id = (String) session.getValue( "facility_id" ) ;
		client_ip_address = this.p.getProperty("client_ip_address");
		login_user = this.p.getProperty( "login_user" ) ;
		loc = new Locale(locale);
		rb = ResourceBundle.getBundle("eBL.resources.Messages",loc);
		
		try{
			con = ConnectionManager.getConnection(request);
			System.err.println("124,mode===>");
			String facility=checkForNull(request.getParameter("facility"));
			String policy_desc=checkForNull(request.getParameter("policy_desc"));
			System.err.println("124,facility===>"+facility);
			System.err.println("124,policy_desc===>"+policy_desc);
			String inclRowCount=checkForNull(request.getParameter("inclRowCnt"));
			System.err.println("128,inclRowCount===>"+inclRowCount);
			if(inclRowCount == null) inclRowCount="1";
			System.err.println("129,rowcnt===>"+inclRowCount);
			int inclRowCnt = Integer.parseInt(inclRowCount);
			System.err.println("108,inclRowCnt===>"+inclRowCnt);
			//Integer.parseInt(str_total_records);
			/* for(int i=1;i<=inclRowCnt;i++){
				System.err.println("129,i===>"+i);
				applyDiscount = checkForNull(request.getParameter("applydiscount"+i));
				System.err.println("131,applyDiscount===>"+applyDiscount);
				if(null == applyDiscount) {
				// applyDiscount = request.getParameter("apply_discount_hdn");
				}
		
		
			publicChk = checkForNull(request.getParameter("publick"+i));
			System.err.println("131,publicChk===>"+publicChk);
			
			returnMap = insertUpdatePriceClass(request,response);
			
			if(((Boolean) returnMap.get("status")).booleanValue()){
				if("Y".equalsIgnoreCase(applyDiscount)){
					returnMap = insertUpdateDiscountClass(request,response,i);
				}
			}
							
			if(((Boolean) returnMap.get("status")).booleanValue()) {
				con.commit();
			} else {
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
			PrintWriter out = response.getWriter();
			if(error.length()==0){
					error = "APP-SM0070 Operation Completed Successfully ....";
					
					out.println("<script>");
					out.println("alert('"+error+"')");
					out.println("window.close();");
					out.println("</script>");
			}
			else{
				error = "Record not saved"+"<br/>"+error;
				out.println("<script>");
				out.println("alert('Record not saved')");
				out.println("</script>");
				response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8" ) +"&err_value="+err_val);
			}
		} */
			returnMap = insertUpdatePriceClass(request,response);
			System.err.println("Final Return value:"+returnMap);
			
			if(((Boolean) returnMap.get("status")).booleanValue()) {
				con.commit();
			} else {
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
			PrintWriter out = response.getWriter();
			if(error.length()==0){
					error = "APP-SM0070 Operation Completed Successfully ....";
					
					out.println("<script>");
					out.println("alert('"+error+"');");
					out.println(" parent.parent.document.getElementById('dialog_tag').close(); parent.parent.document.getElementById('additionalServiceDiscountDetails').contentWindow.location.reload();");
					out.println("</script>");
			}
			else{
				error = "Record not saved"+"<br/>"+error;
				out.println("<script>");
				out.println("alert('Record not saved')");
				out.println("</script>");
				response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8" ) +"&err_value="+err_val);
			}		
		}
		catch(Exception e){
			try{
				System.err.println("Exception in BLServiceDiscPrice Servlet ->"+e);
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


	@SuppressWarnings({ "rawtypes", "unchecked", "finally" })
	private HashMap insertUpdatePriceClass(HttpServletRequest request,
			HttpServletResponse response) {
		HashMap returnMap = new HashMap();
		boolean insertable = false;
		boolean inserted = false;
		try{
			
			System.err.println("205,inside insertUpdatePriceClass");
			facilityId = request.getParameter("facility");
			serviceInd = checkForNull(request.getParameter("service_ind"));
			serviceCode = checkForNull(request.getParameter("service_code"));
			System.err.println("215,inside insertUpdatePriceClass serviceCode-"+serviceCode);
			priceInd = checkForNull(request.getParameter("price_ind"));
			
			if(priceInd.equals("C")){
				System.err.println("225,inside insertUpdatePriceClass priceCode-"+request.getParameter("cust_code"));
				priceCode = checkForNull(request.getParameter("cust_code"));
			}else{
				priceCode = checkForNull(request.getParameter("price_code"));
			}
			System.err.println("215,inside insertUpdatePriceClass priceInd-"+priceInd);
			System.err.println("215,inside insertUpdatePriceClass priceCode-"+priceCode);
			policyCode = checkForNull(request.getParameter("policy_code"));
			custGrpCode = checkForNull(request.getParameter("cust_grp_code"));
			String rwcnt=checkForNull(request.getParameter("inclRowCnt"));
			System.err.println("215,inside insertUpdatePriceClass rwcnt-"+rwcnt);
			int rowCount = Integer.parseInt(rwcnt);
			System.err.println("215,inside insertUpdatePriceClass rowCount-"+rowCount);
			for(int i=1;i<=rowCount;i++){
					System.err.println("215,inside insertUpdatePriceClass forrrr");
					blngClass = checkForNull(request.getParameter("billingclass"+i));
					System.err.println("215,inside insertUpdatePriceClass blngClass-"+blngClass);
					if(blngClass == null || "A".equals(blngClass)){
							blngClass = "";
					}
					rateFactorPriceInd = checkForNull(request.getParameter("priceindbot"+i));
					System.err.println("215,inside insertUpdatePriceClass rateFactorPriceInd-"+rateFactorPriceInd);
					checkCostAvl = checkForNull(request.getParameter("checkcost"+i));
					System.err.println("215,inside insertUpdatePriceClass checkCostAvl-"+checkCostAvl);
					if("on".equals(checkCostAvl) || "Y".equals(checkCostAvl)){
						checkCostAvl = "Y";
					}
					else{
						checkCostAvl = "N";
					}
					System.err.println("222228888888888"+i);
					costInd = checkForNull(request.getParameter("costindic"+i));
					System.err.println("costInd==>"+costInd);
					
					costAmount = checkForNull(request.getParameter("costamnt"+i));
					System.err.println("costAmount==>"+costAmount);
					
					ipPriceRate = checkForNull(request.getParameter("discip"+i));
					System.err.println("ipPriceRate==>"+ipPriceRate);
					
					opPriceRate = checkForNull(request.getParameter("discop"+i));
					System.err.println("opPriceRate==>"+opPriceRate);
					
					emPriceRate = checkForNull(request.getParameter("discem"+i));
					System.err.println("emPriceRate==>"+emPriceRate);  
					
					exPriceRate = checkForNull(request.getParameter("discex"+i));
					System.err.println("exPriceRate==>"+exPriceRate);
					
					dcPriceRate = checkForNull(request.getParameter("discdc"+i));
					System.err.println("dcPriceRate==>"+dcPriceRate);
					
					minCharge = checkForNull(request.getParameter("minchar"+i));
					System.err.println("minCharge==>"+minCharge);
					
					maxCharge = checkForNull(request.getParameter("maxchar"+i));
					System.err.println("maxCharge==>"+maxCharge);
					
					baseQty = checkForNull(request.getParameter("baseqnty"+i));
					System.err.println("baseQty==>"+baseQty);
					
					priceApplicability = checkForNull(request.getParameter("Applicab"+i));
					System.err.println("priceApplicability==>"+priceApplicability);
					
					applyDiscount = checkForNull(request.getParameter("applydiscount"+i));
					System.err.println("applyDiscount==>"+applyDiscount);
					
					rowMode = checkForNull(request.getParameter("rowMode_"+i));
					System.err.println("rowMode==>"+rowMode);
					
					if(null == applyDiscount) {
						//applyDiscount = checkForNull(request.getParameter("apply_discount_hdn"));
					}
					
					//Added V181005-Gayathri/MMS-DM-SCF-0243.1/Ends	
					if("on".equals(applyDiscount) || "Y".equals(applyDiscount)){
						applyDiscount = "Y";
					}
					else{
						applyDiscount = "N";
					}
					
					//Added V181005-Gayathri/MMS-DM-SCF-0243.1/Starts
					public_chk = checkForNull(request.getParameter("publicchk"+i));
					if("on".equals(public_chk) || "Y".equals(public_chk)){
						System.err.println("24444999999");
						public_chk = "Y";
					}
					else{
						public_chk = "N";
					}
					
					rateBasis_ind = checkForNull(request.getParameter("ratebase"+i));
					priceEffFrom = checkForNull(request.getParameter("effFrmDte"+i));
					priceEffTo = checkForNull(request.getParameter("efftodte"+i));					
					
					System.err.println("Before calling the procedure");
					System.err.println("login_user:"+login_user);
					String priceQuery = "";
					if("insert".equals(rowMode)|| "add".equals(rowMode) ){
						priceQuery = "{ call blmultipricedtls.insert_bl_price_serv_cust(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }";
					}
					else if("modify".equals(rowMode)){
						priceQuery = "{ call blmultipricedtls.update_bl_price_serv_cust(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }";
					}
					cstmt = con.prepareCall(priceQuery);
					cstmt.setString(1, facility_id);
					cstmt.setString(2, priceInd);
					cstmt.setString(3, priceCode);
					cstmt.setString(4, serviceInd);
					cstmt.setString(5, serviceCode);
					cstmt.setString(6, blngClass);
					cstmt.setString(7, custGrpCode);
					cstmt.setString(8, policyCode);
					cstmt.setString(9, public_chk);	//Added V181005-Gayathri/MMS-DM-SCF-0243.1	
					cstmt.setString(10, rateBasis_ind); //Added V181005-Gayathri/MMS-DM-SCF-0243.1
					cstmt.setString(11, rateFactorPriceInd);
					if(priceEffFrom == null || "".equals(priceEffFrom)){
						cstmt.setString(12, null);
					}
					else{
						cstmt.setDate(12, new Date(sdf.parse(priceEffFrom).getTime()));
					}
					if(priceEffTo == null || "".equals(priceEffTo)){
						cstmt.setString(13, null);
					}
					else{
						cstmt.setDate(13, new Date(sdf.parse(priceEffTo).getTime()));
					}
					cstmt.setString(14, ipPriceRate);
					cstmt.setString(15, opPriceRate);
					cstmt.setString(16, exPriceRate);
					cstmt.setString(17, emPriceRate);
					cstmt.setString(18, dcPriceRate);
					cstmt.setString(19, minCharge);
					cstmt.setString(20, baseQty);
					cstmt.setString(21, applyDiscount);
					cstmt.setString(22, null);
					cstmt.setString(23, null);
					cstmt.setString(24, null);
					cstmt.setString(25, costAmount);
					cstmt.setString(26, maxCharge);
					cstmt.setString(27, priceApplicability);
					cstmt.setString(28, checkCostAvl);
					cstmt.setString(29, null);//
					cstmt.setString(30, costInd);
					cstmt.setString(31, "N");//
					cstmt.setString(32, "N");//
					cstmt.setString(33, "N");//
					cstmt.setString(34, null);//
					cstmt.setString(35, null);//
					
					cstmt.setString(36, locale);
					cstmt.setString(37, login_user);
					cstmt.setString(38, facility_id);
					
					cstmt.setString(39, client_ip_address);
					cstmt.registerOutParameter(40, java.sql.Types.VARCHAR);
					cstmt.registerOutParameter(41, java.sql.Types.VARCHAR);
					cstmt.registerOutParameter(42, java.sql.Types.VARCHAR);
					System.err.println("Before execute");
					cstmt.execute();
					System.err.println("after execute");
					
					str_error_level = checkForNull(cstmt.getString(40));
					str_sysmesage_id = checkForNull(cstmt.getString(41));
					str_error_text = checkForNull(cstmt.getString(42));
					
					System.err.println("=====str_error_level======="+str_error_level);
					System.err.println("=====str_sysmesage_id======="+str_sysmesage_id);
					System.err.println("=====str_error_text======="+str_error_text);
					
					if((!str_error_level.equals("") && !str_error_text.equals("")) || !str_sysmesage_id.equals(""))
					{
						if(!str_error_level.equals("") && !str_error_text.equals(""))
						{
							System.err.println("****Inside Error Text insert/update bl_price_serv_cust:" + str_error_text);
							inserted = false;
						}
						else if(!str_sysmesage_id.equals(""))
						{
							System.err.println("****Inside Sys Message insert/update bl_price_serv_cust::"+str_sysmesage_id);
							inserted = false;
						}
					}
					else
					{
						System.err.println("****Inside Rec Success insert/update bl_price_serv_cust:");
						inserted = true;
					}
					
					if(inserted && "Y".equals(applyDiscount)) {
						returnMap = insertUpdateDiscountClass(request,response,i);
						System.err.println("Return value from discount:"+returnMap);
						if(((Boolean) returnMap.get("status")).booleanValue()){
							returnMap = new HashMap();
						}
					}
			}
			if(!str_error_level.equals("") && !str_error_text.equals("")){
				returnMap.put("priceErr", str_error_level+"-"+str_error_text);
			}
			System.err.println("str_sysmesage_id in insertUpdatePriceClass:"+str_sysmesage_id);
			if(str_sysmesage_id != null && !"".equals(str_sysmesage_id)){
				String msgAdd = "";
				if(str_sysmesage_id.contains("|")){
					String msgArr[] = str_sysmesage_id.split("\\|");
					for(int l=0;l<msgArr.length;l++){
						msgAdd = "priceErrMsg"+l;
						
						try{
							msgArr[l] = rb.getString(msgArr[l]);
						}
						catch(Exception rbException){
							System.err.println("Exceprion in RB ->"+rbException);
						}
						returnMap.put(msgAdd, msgArr[l]);
					}
				}else{
					msgAdd = "priceErrMsg";
					
					try{
						str_sysmesage_id = rb.getString(str_sysmesage_id);
					}
					catch(Exception rbException){
						System.err.println("Exceprion in RB ->"+rbException);
					}
					returnMap.put(msgAdd, str_sysmesage_id);
				}
			}
			cstmt.close();
			System.err.println("returnMap:"+returnMap);
			if (!returnMap.isEmpty()) {
				System.out.println("========inside returnMap.isEmpty if==========");
				insertable = false;
			} else {
				System.out.println("========inside returnMap.isEmpty else==========");
				insertable = true;
			}
			
		}
		catch(Exception e){
			System.err.println("===Exception is=== "+e);
			returnMap.put("internalError", "Internal Error");
			insertable = false;
		}
		finally{
			returnMap.put("status", new Boolean(insertable));
			System.out.println("========status finally=========="+insertable);
			return returnMap;
		}
		
	}

	@SuppressWarnings({ "rawtypes", "unchecked", "finally" })
	private HashMap insertUpdateDiscountClass(HttpServletRequest request,
			HttpServletResponse response,int idx) {

		HashMap returnMap = new HashMap();
		boolean insertable = false;
		//CallableStatement cstmt1 = null;
		try
		{
			System.err.println("401,inside insertUpdateDiscountClass");
			facilityId = request.getParameter("facility");
			serviceInd = checkForNull(request.getParameter("service_ind"));
			serviceCode = checkForNull(request.getParameter("service_code"));
			priceInd = checkForNull(request.getParameter("price_ind"));
			//priceCode = checkForNull(request.getParameter("price_code"));
			policyCode = checkForNull(request.getParameter("policy_code"));
			custGrpCode = checkForNull(request.getParameter("cust_grp_code"));

			if(priceInd.equals("C")){
				priceCode = checkForNull(request.getParameter("cust_code"));
			}
			else{
				priceCode = checkForNull(request.getParameter("price_code"));
			}

			System.err.println("priceCode insertUpdateDiscountClass====>"+priceCode);
			/*facilityId = request.getParameter("hdnFacility");
			serviceInd = request.getParameter("hdnServiceInd");
			serviceCode = request.getParameter("service_code");
			priceInd = request.getParameter("hdnPriceInd");
			priceCode = request.getParameter("price_code");
			policyCode = request.getParameter("policy_code");
			custGrpCode = request.getParameter("cust_grp_code"); */

			discStringForBlngClass = checkForNull(request.getParameter("discStringForBlngClass_"+idx));
			System.err.println("401,inside insertUpdateDiscountClass discStringForBlngClass:"+discStringForBlngClass);
			if(!discStringForBlngClass.equals(""))
			{
				System.err.println("401,inside insertUpdateDiscountClass iffffff");
				String[] discountRow = discStringForBlngClass.split(",");
				for(int k=0;k<discountRow.length;k++){
					System.err.println("401,inside insertUpdateDiscountClass ffoorrrrr");
					String discRowData=discountRow[k];
					System.err.println("86====>"+discRowData);
					String[] discRowValues=discRowData.split("::");
					// discountInd = discRowValues[0];
					if(discRowValues[0]==null || discRowValues[0].equals("") || discRowValues[0].equals(" ")) discountInd="";
					if(discRowValues[1]==null || discRowValues[1].equals("") || discRowValues[1].equals(" ")) ipDiscPerc="";
					if(discRowValues[2]==null || discRowValues[2].equals("") || discRowValues[2].equals(" ")) opDiscPerc="";
					if(discRowValues[3]==null || discRowValues[3].equals("") || discRowValues[3].equals(" ")) dcDiscPerc="";
					if(discRowValues[4]==null || discRowValues[4].equals("") || discRowValues[4].equals(" ")) emDiscPerc="";
					if(discRowValues[5]==null || discRowValues[5].equals("") || discRowValues[5].equals(" ")) exDiscPerc="";
					if(discRowValues[6]==null || discRowValues[6].equals("") || discRowValues[6].equals(" ")) discApplicability="";
					if(discRowValues[7]==null || discRowValues[7].equals("") || discRowValues[7].equals(" ")) discountEffFrom="";
					if(discRowValues[8]==null || discRowValues[8].equals("") || discRowValues[8].equals(" ")) discountEffTo="";
					if(discRowValues[10] == null || discRowValues[10].equals("") || discRowValues[10].equals(" ")) discUptoHrs="";
					if(discRowValues[10] == null || discRowValues[10].equals("") || discRowValues[10].equals(" ")) discUptoPercAmt="";

					System.err.println("436,inside insertUpdateDiscountClass after checkfornull:"+discRowValues);
					discStatus="Y"; // enable value not included
					
					discountInd 		= discRowValues[0];
					if(discountInd == null || "null".equals(discountInd) || " ".equals(discountInd)) discountInd = "";
					
					ipDiscPerc 			= discRowValues[1];
					if(ipDiscPerc == null || "null".equals(ipDiscPerc) || " ".equals(ipDiscPerc)) ipDiscPerc = "";
					
					opDiscPerc 			= discRowValues[2];
					if(opDiscPerc == null || "null".equals(opDiscPerc) || " ".equals(opDiscPerc))opDiscPerc = "";
					
					emDiscPerc			= discRowValues[3];
					if(emDiscPerc == null || "null".equals(emDiscPerc) || " ".equals(emDiscPerc)) emDiscPerc= "";
					
					exDiscPerc			= discRowValues[4];
					if(exDiscPerc == null || "null".equals(exDiscPerc) || " ".equals(exDiscPerc)) exDiscPerc = "";
					
					dcDiscPerc			= discRowValues[5];
					if(dcDiscPerc == null || "null".equals(dcDiscPerc) || " ".equals(dcDiscPerc)) dcDiscPerc = "";					
					
					discApplicability	= discRowValues[6];
					if(discApplicability == null || "null".equals(discApplicability) || " ".equals(discApplicability)) discApplicability = "";
					
					discountEffFrom		= discRowValues[7];
					if(discountEffFrom == null || "null".equals(discountEffFrom) || " ".equals(discountEffFrom)) discountEffFrom = "";
					
					discountEffTo   	= discRowValues[8];
					if(discountEffTo == null || "null".equals(discountEffTo) || " ".equals(discountEffTo)) discountEffTo = "";
					
					isDiscInsMod   	= discRowValues[9];
					if(isDiscInsMod == null || "null".equals(isDiscInsMod) || " ".equals(isDiscInsMod)) isDiscInsMod = "I";					
					
					discUptoHrs = discRowValues[10];
					if(discUptoHrs == null || "null".equals(discUptoHrs) || " ".equals(discUptoHrs)) discUptoHrs = "";					

					discUptoPercAmt = discRowValues[11];
					if(discUptoPercAmt == null || "null".equals(discUptoPercAmt) || " ".equals(discUptoPercAmt)) discUptoPercAmt = "";										
					
					System.err.println("discRowValues[0]====>"+discRowValues[0]);
					System.err.println("discRowValues[1]====>"+discRowValues[1]);
					System.err.println("discRowValues[2]====>"+discRowValues[2]);
					System.err.println("discRowValues[3]====>"+discRowValues[3]);
					System.err.println("discRowValues[4]====>"+discRowValues[4]);
					System.err.println("discRowValues[5]====>"+discRowValues[5]);
					System.err.println("discRowValues[6]====>"+discRowValues[6]);
					System.err.println("discRowValues[7]====>"+discRowValues[7]);
					System.err.println("discRowValues[8]====>"+discRowValues[8]);
					System.err.println("discRowValues[9]====>"+discRowValues[9]);					
					/*	discStatus 			= 

					if("on".equals(discStatus) || "Y".equals(discStatus)){
					discStatus = "Y";
					} else {
					discStatus = "N";
					}
					*/
					int disCount = 0;
					try
					{
						System.err.println("401,inside insertUpdateDiscountClass tryyyy");
						disCount = Integer.parseInt(request.getParameter("disCount"));
					}
					catch(Exception dis){
						disCount = 0;
					}
					String discountQuery = "";
					if("I".equals(isDiscInsMod)){
						discountQuery = "{ call blmultipricedtls.insert_bl_price_disc(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }";
					}
					else if("M".equals(isDiscInsMod)){
						discountQuery = "{ call blmultipricedtls.update_bl_price_disc(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }";
					}

					CallableStatement cstmt1 = con.prepareCall(discountQuery);
					cstmt1.setString(1, facility_id);
					cstmt1.setString(2, "S");
					cstmt1.setString(3, priceInd);
					cstmt1.setString(4, priceCode);
					cstmt1.setString(5, serviceInd);

					cstmt1.setString(6, serviceCode);
					cstmt1.setString(7, blngClass);
					cstmt1.setString(8, custGrpCode);
					cstmt1.setString(9, policyCode);

					System.err.println("4888877777777777");

					if(discountEffFrom == null || "".equals(discountEffFrom)){
						cstmt1.setString(10, null);
					}
					else{
						cstmt1.setDate(10, new Date(sdf.parse(discountEffFrom).getTime()));
					}

					if(discountEffTo == null || "".equals(discountEffTo)){
						cstmt1.setString(11, null);
					}
					else{
						cstmt1.setDate(11, new Date(sdf.parse(discountEffTo).getTime()));
					}

					cstmt1.setString(12, ipDiscPerc);
					cstmt1.setString(13, opDiscPerc);
					cstmt1.setString(14, exDiscPerc);
					cstmt1.setString(15, emDiscPerc);

					cstmt1.setString(16, dcDiscPerc);
					cstmt1.setString(17, discStatus);
					cstmt1.setString(18, discountInd);
					cstmt1.setString(19, discApplicability);
					cstmt1.setString(20, locale);

					cstmt1.setString(21, login_user);
					cstmt1.setString(22, facility_id);
					cstmt1.setString(23, client_ip_address);
					cstmt1.setString(24, discUptoHrs);
					cstmt1.setString(25, discUptoPercAmt);					
					cstmt1.registerOutParameter(26, java.sql.Types.VARCHAR);
					cstmt1.registerOutParameter(27, java.sql.Types.VARCHAR);
					cstmt1.registerOutParameter(28, java.sql.Types.VARCHAR);

					cstmt1.execute();

					str_error_level = checkForNull(cstmt1.getString(26));
					str_sysmesage_id = checkForNull(cstmt1.getString(27));
					str_error_text = checkForNull(cstmt1.getString(28));
					System.err.println("str_error_level in discount:"+str_error_level);
					System.err.println("str_sysmesage_id in discount:"+str_sysmesage_id);
					System.err.println("str_error_text in discount:"+str_error_text);
					cstmt1.close();
					
					if(!str_error_level.equals("") && !str_error_text.equals("")){
						returnMap.put("discErr", str_error_level+"-"+str_error_text);
					}	
					
					if(str_sysmesage_id != null && !"".equals(str_sysmesage_id) ){
						String msgAdd = "";
						if(str_sysmesage_id.contains("|")){
							String msgArr[] = str_sysmesage_id.split("\\|");
							for(int l=0;l<msgArr.length;l++){
								msgAdd = "discErrMsg"+l;

								try
								{
									msgArr[l] = rb.getString(msgArr[l]);
								}
								catch(Exception rbException){
									System.err.println("Exceprion in RB ->"+rbException);
								}
								returnMap.put(msgAdd, msgArr[l]);
							}
						}
						else {
							msgAdd = "discErrMsg";

							try{
								str_sysmesage_id = rb.getString(str_sysmesage_id);
							}
							catch(Exception rbException){
								System.err.println("Exceprion in RB ->"+rbException);
							}
							returnMap.put(msgAdd, str_sysmesage_id);
						}
					}
				}
			}			
			System.err.println("returnMap in discount:"+returnMap);
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
		}
		finally{
			returnMap.put("status", new Boolean(insertable));
			return returnMap;
		}
	}
	private String checkForNull(String str){
		return (str!=null && str.intern()!="null")?str:"";
	}

	private String checkForNull(String str,String defaultVal){
		return (!checkForNull(str).equals(""))?str:defaultVal;
	}
}
