/*
Added By Niveditha for  MOHE-CRF-0026.3
*/

package eXH;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import java.util.*;

import webbeans.eCommon.*;
import java.util.UUID;

public class InsAuthStatusResultServlet extends HttpServlet
{
	public void doPost(HttpServletRequest request, HttpServletResponse response)  throws ServletException,IOException{
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out;
			java.util.Properties p;
			HttpSession session;
			String sStyle = "";

			out = response.getWriter();
			session = request.getSession();

			sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

			p = (java.util.Properties) session.getValue("jdbc");
			
			insertRecord(request,response,out,p,session);
			
	}

	private String getMessage(String locale, String messageId, String moduleId){
			java.util.Hashtable message = MessageManager.getMessage(locale,messageId,moduleId);
			String mesg = (String) message.get("message");
			message.clear();
			return(mesg) ;
	}
	
	public java.sql.Date getCurrentDatetime() {
		java.util.Date today = new java.util.Date();
		return new java.sql.Date(today.getTime());
	}
	
	public static String getCurrencyCode() throws SQLException {
		Connection connectioncc = null ;
		PreparedStatement pstmtcc = null ;
		ResultSet resultSetcc = null ;
		String currency_code_str="";
		
		try {
		connectioncc = ConnectionManager.getConnection() ;

		pstmtcc = connectioncc.prepareStatement("SELECT DEFAULT_VALUE FROM XH_STANDARD_CONTROL_SEG WHERE ELEMENT_ID='CURRENCY_CODE'") ;
		
		resultSetcc = pstmtcc.executeQuery() ;
		while (resultSetcc.next()) {
			currency_code_str = resultSetcc.getString("DEFAULT_VALUE");
		}
		}catch ( Exception e ) {
			e.printStackTrace() ;
		}finally{
			pstmtcc.close();
			resultSetcc.close();
			connectioncc.close();
		}		
		return currency_code_str;
	}
	
	private void insertRecord(HttpServletRequest request,HttpServletResponse response, PrintWriter out, java.util.Properties p, HttpSession session){
			
			String error_value = null, request_status="N";
			
			String payer_response="", payer_errorCode = "", payer_errmsg = "", currency_code="";
			
			Connection dbConn = null;
			ResultSet rs=null;
			CallableStatement ostmt = null;
			
			CallableStatement ostmt1 = null;
			
			CallableStatement ostmt2 = null;
			
			p = (java.util.Properties) session.getValue("jdbc") ;
			String locale = (String) p.getProperty("LOCALE");
			String facilityId = (String)session.getValue("facility_id")==null ? "" :(String)session.getValue("facility_id") ;
			String addedById = p.getProperty( "login_user" )==null ? "" :p.getProperty( "login_user" ) ;
			String addedAtWSNo = p.getProperty("client_ip_address") ==null ? "" : p.getProperty("client_ip_address");
			
			String modifiedById = addedById;
			String modifiedAtWSNo = addedAtWSNo;

			String countrows = request.getParameter("countrows") == null ? "0" : request.getParameter("countrows") ;	
			int counterrows = Integer.parseInt(countrows);

			Connection connection 	= null;
			PreparedStatement pstmt = null;
			ResultSet resultSet = null;
			String sqlQuery = null;
			String paramString = "";
			ArrayList insauthstatuslist	= new ArrayList();
			
			String l_errcd = "", l_errmsg = "";
			
		   try
			{
			    dbConn = ConnectionManager.getConnection(request);
			
				UUID request_id_uuid = UUID.randomUUID();
				UUID request_type_id_uuid = UUID.randomUUID();
					
				/*SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
				Date date = new Date(System.currentTimeMillis());
				System.out.println("SimpleDateFormat--"+date);
				
				long yourmilliseconds = System.currentTimeMillis();
				SimpleDateFormat sdf = new SimpleDateFormat("MMM dd,yyyy HH:mm");    
				Date resultdate = new Date(yourmilliseconds);
				System.out.println(sdf.format(resultdate));

				Calendar calendar = Calendar.getInstance();
				java.util.Date currentTime = calendar.getTime();
				long time = currentTime.getTime();

				System.out.println("time--"+time);
				
				java.util.Date utilDate = new java.util.Date();
				
				System.out.print("utilDate--"+utilDate);
				
				Date sqlDate = new Date(utilDate.getTime());
				System.out.print("sqlDate--"+sqlDate);*/
							
				System.out.println("counterrows--"+counterrows);
					
				currency_code = getCurrencyCode();
					System.out.println("currency_code--"+currency_code);
				 for(int i=1;i<=counterrows;i++){	
					String check_status=request.getParameter("secChk"+i)==null ? "" :request.getParameter("secChk"+i);
	
					String request_id = request_id_uuid.toString();
					String request_type_id = request_type_id_uuid.toString();
					String message_header_id = "urn:"+"uuid:"+request_type_id_uuid.toString(); 

					String patientId=request.getParameter("patient_id_value"+i)==null ? "" :request.getParameter("patient_id_value"+i);//patient_id
					
					String encounterId=request.getParameter("encounter_id_value"+i)==null ? "" :request.getParameter("encounter_id_value"+i);//encounter_id
					
					String dispNo=request.getParameter("disp_no_value"+i)==null ? "" :request.getParameter("disp_no_value"+i);//disp_id or disp_no
					
					String orderId=request.getParameter("order_id_value"+i)==null ? "" :request.getParameter("order_id_value"+i);//order_id
					
					String drugCode=request.getParameter("drug_code_value"+i)==null ? "" :request.getParameter("drug_code_value"+i);//drug_code_value
					
					String orderLineNo=request.getParameter("order_line_no_value"+i)==null ? "" :request.getParameter("order_line_no_value"+i);//order_line_no_value
					
					String orderLineNum=request.getParameter("order_line_num_value"+i)==null ? "" :request.getParameter("order_line_num_value"+i);//order_line_num_value

					String countOrderLineNum=request.getParameter("count_order_line_num_value"+i)==null ? "0" :request.getParameter("count_order_line_num_value"+i);//count_order_line_num_value
					int counterrowsorderline = Integer.parseInt(countOrderLineNum);
					
					String dispQtyStr=request.getParameter("disp_qty_value"+i)==null ? "0" :request.getParameter("disp_qty_value"+i);//disp_qty_value
					int dispQty = Integer.parseInt(dispQtyStr);
					
					String dispUomCode=request.getParameter("disp_uom_code_value"+i)==null ? "0" :request.getParameter("disp_uom_code_value"+i);//disp_uom_code_value
					
					String patClass=request.getParameter("patient_class_value"+i)==null ? "0" :request.getParameter("patient_class_value"+i);//patient_class_value
					
					String basePriceStr=request.getParameter("base_price_value"+i)==null ? "0" :request.getParameter("base_price_value"+i);//base_price_value
					int basePrice = Integer.parseInt(basePriceStr);
					
					int net_value = dispQty * basePrice;
					
					/*String priceIp=request.getParameter("base_price_ip_value"+i)==null ? "0" :request.getParameter("base_price_ip_value"+i);//base_price_ip_value
					
					String priceRf=request.getParameter("base_price_rf_value"+i)==null ? "0" :request.getParameter("base_price_rf_value"+i);//base_price_rf_value
					
					String priceEm=request.getParameter("base_price_em_value"+i)==null ? "0" :request.getParameter("base_price_em_value"+i);//base_price_em_value
					
					String priceDc=request.getParameter("base_price_dc_value"+i)==null ? "0" :request.getParameter("base_price_dc_value"+i);//base_price_dc_value*/
					
					if(check_status.equals("Y")){
						ostmt = dbConn.prepareCall("{ CALL XHPAYER.INTERFACE_PAYER_HEADER_AUDIT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }" );
	
						ostmt.setString(1,"I");
						ostmt.registerOutParameter(2,java.sql.Types.VARCHAR);
						ostmt.registerOutParameter(3,java.sql.Types.VARCHAR);
						ostmt.setString(4,request_id);
						ostmt.setString(5,"PHPREAUTH");
						ostmt.setString(6,facilityId);		
						ostmt.setString(7,request_type_id);	
						ostmt.setDate(8, new java.sql.Date(System.currentTimeMillis()));
						ostmt.setString(9,patientId);	
						ostmt.setString(10,encounterId);
						ostmt.setString(11,dispNo);	
						ostmt.setString(12,message_header_id);	
						ostmt.setString(13,request_status);	
						ostmt.setString(14,"Pre-authorization Requested");	
						ostmt.setNull(15, java.sql.Types.INTEGER);	
						ostmt.setString(16," ");	
						ostmt.setString(17," ");	
						ostmt.setString(18," ");	
						ostmt.setString(19," ");	
						ostmt.setString(20,addedById);	
						ostmt.setDate(21, new java.sql.Date(System.currentTimeMillis()));
						ostmt.setString(22,addedAtWSNo);	
						ostmt.setString(23,facilityId);	
						ostmt.setString(24,modifiedById);	
						ostmt.setDate(25, new java.sql.Date(System.currentTimeMillis()));
						ostmt.setString(26,modifiedAtWSNo);	
						ostmt.setString(27,facilityId);	

						ostmt.execute();
						
						
						l_errcd = ostmt.getString(2);
						l_errmsg = ostmt.getString(3);
						System.out.println("After Saving the Payer Audit Header... "+l_errcd+ " Error Message... "+l_errmsg);	

					ostmt1 = dbConn.prepareCall("{ CALL XHPAYER.INTERFACE_PAYER_AUTH_DETAIL(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }" );

						ostmt1.setString(1,"I");
						ostmt1.registerOutParameter(2,java.sql.Types.VARCHAR);
						ostmt1.registerOutParameter(3,java.sql.Types.VARCHAR);
						ostmt1.setString(4,request_id);
						ostmt1.setString(5,"PHPREAUTH");
						ostmt1.setString(6,facilityId);		
						ostmt1.setString(7,request_type_id);	
						ostmt1.setString(8,dispNo);	
						ostmt1.setString(9,orderLineNo);	 
						ostmt1.setString(10,drugCode);
						ostmt1.setString(11," ");	//ITEM_CODEABLE_CONCEPT
						ostmt1.setString(12,request_status);
						ostmt1.setInt(13,dispQty);	
						ostmt1.setString(14,dispUomCode);	
						ostmt1.setInt(15, basePrice);	
						ostmt1.setString(16,currency_code);	
						ostmt1.setInt(17, net_value);
						ostmt1.setString(18,currency_code);	
						ostmt1.setString(19," ");	//ADJUDICATION_STATUS						
						ostmt1.setNull(20, java.sql.Types.INTEGER);	//ELIGIBLE_VALUE
						ostmt1.setString(21,currency_code);	
						ostmt1.setString(22," ");	//ELIGIBLE_UNIT_TYPE
						ostmt1.setNull(23, java.sql.Types.INTEGER);	//DEDUCTIBLE_VALUE
						ostmt1.setString(24,currency_code); 				
						ostmt1.setNull(25, java.sql.Types.INTEGER); //COPAY_VALUE
						ostmt1.setString(26,currency_code);
						ostmt1.setNull(27, java.sql.Types.INTEGER);//BENEFIT_VALUE
						ostmt1.setString(28,currency_code);
						ostmt1.setString(29," ");//REQUEST_STATUS_DESC
						ostmt1.setString(30,addedById);	
						ostmt1.setString(31,addedAtWSNo);	
						ostmt1.setString(32,facilityId);	
						ostmt1.setString(33,modifiedById);	
						ostmt1.setString(34,modifiedAtWSNo);	
						ostmt1.setString(35,facilityId);	

						ostmt1.execute();	

					}//check_status for INTERFACE_PAYER_HEADER
			}//for		
		
		System.out.println("fooooorrrrrrr--");
		
			sqlQuery ="select PATIENT_ID, ENCOUNTER_ID, REQUEST_ID, REQUEST_TYPE, REQUEST_FACILITY_ID, REQUEST_TYPE_ID  from XH_PAYER_HEADER where REQUEST_DATE_TIME = (select max(REQUEST_DATE_TIME) from XH_PAYER_HEADER)";
	
			try {
				connection				= ConnectionManager.getConnection() ;
				pstmt					= connection.prepareStatement( sqlQuery ) ;

				resultSet = pstmt.executeQuery() ;

				while(resultSet.next()){
					insauthstatuslist.add(resultSet.getString("PATIENT_ID")); 
					insauthstatuslist.add(resultSet.getString("ENCOUNTER_ID")); 
					insauthstatuslist.add(resultSet.getString("REQUEST_ID")); 
					insauthstatuslist.add(resultSet.getString("REQUEST_TYPE")); 
					insauthstatuslist.add(resultSet.getString("REQUEST_FACILITY_ID")); 
					insauthstatuslist.add(resultSet.getString("REQUEST_TYPE_ID")); 	
				}
			}catch (Exception e) {
			  e.printStackTrace();
			}finally {	
				pstmt.close();
				resultSet.close();
				connection.close();
			}
	/*'<PATIENT_ID>C100000025$!^<ENCOUNTER_ID>100000270001$!^<REQUEST_ID>026022dd-1d08-405e-b5a2-575bd37a7b6d$!^<REQUEST_TYPE>PHPREAUTH$!^<REQUEST_FACILITY_ID>C1$!^<REQUEST_TYPE_ID>3f0fcf29-9360-4c80-a487-cf21ebadb31e$!^';*/
			
			paramString = "<PATIENT_ID>"+insauthstatuslist.get(0)+"$!^<ENCOUNTER_ID>"+insauthstatuslist.get(1)+"$!^<REQUEST_ID>"+insauthstatuslist.get(2)+"$!^<REQUEST_TYPE>"+insauthstatuslist.get(3)+"$!^<REQUEST_FACILITY_ID>"+insauthstatuslist.get(4)+"$!^<REQUEST_TYPE_ID>"+insauthstatuslist.get(5)+"$!^";
			
			
			System.out.println("paramString--"+paramString);

			try{	
			
			ostmt2 = dbConn.prepareCall("{ CALL XHPAYER.CHECK_PAYER_REQUEST(?,?,?,?) }" );
			
			ostmt2.setString(1,paramString);
			ostmt2.registerOutParameter(2,java.sql.Types.VARCHAR);
			ostmt2.registerOutParameter(3,java.sql.Types.VARCHAR);			
			ostmt2.registerOutParameter(4,java.sql.Types.VARCHAR);			
			ostmt2.execute();
			
			payer_response = ostmt2.getString(2);
			payer_errorCode = ostmt2.getString(3);
			payer_errmsg = ostmt2.getString(4);


			System.out.println("***Inside - payer_response ::: "+ payer_response + " payer_errorCode ::: "+ payer_errorCode + " payer_errmsg ::: "+ payer_errmsg);

			error_value = "1" ;
			
			}catch (Exception e) {
			  e.printStackTrace();
			}	
			
			
			System.out.println("payer_errorCode--"+payer_errorCode);
			

			if(payer_errorCode.equals("S")){		
				String errorMsg= getMessage("en", "RECORD_INS_AUTH_Y_CHECK", "PH");
				response.sendRedirect("../ePH/jsp/NewProcedureMessage.jsp?err_num=" + java.net.URLEncoder.encode( errorMsg,"UTF-8" ) +"&err_value="+error_value);	
			}else{
				String errorMsg= getMessage("en", "RECORD_INS_AUTH_N_CHECK", "PH");				
				response.sendRedirect("../ePH/jsp/NewProcedureMessage.jsp?err_num=" + java.net.URLEncoder.encode( errorMsg,"UTF-8" ) +"&err_value="+error_value);	
			}
					
		} //try
			catch(Exception e)
			{
				System.out.println("***Inside - Exception at executing procedure "+e);
				e.printStackTrace(System.err);
			}
			finally
			{
				try {
					ostmt.close();
					ostmt1.close();
					ostmt2.close();
				}
				catch(Exception e){
					
				}				
				XHUtil.closeDBResources(rs, null, dbConn);
			}				
	}

}
