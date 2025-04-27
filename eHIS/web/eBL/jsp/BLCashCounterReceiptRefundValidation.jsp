
<%@ page import="java.sql.*,webbeans.eCommon.*,java.net.*,webbeans.op.CurrencyFormat, java.io.*, java.util.*" contentType="text/html;charset=UTF-8" %>
<%@page import="org.json.simple.JSONObject"%>
<%	
		/* Page Added by Karthik for MMS-MD-SCF-0006 [IN:060039] 4/28/2016 */
		String strfacilityid	=  (String) session.getValue("facility_id");
		if(strfacilityid == null) strfacilityid="";
		String strloggeduser	=  (String) session.getValue("login_user");			
		if(strloggeduser == null) strloggeduser="";
		HttpSession httpSession = request.getSession(false);
		Properties p = (Properties)httpSession.getValue("jdbc");	
		String strwsno = p.getProperty("client_ip_address");
		String strepisodetype	=	request.getParameter("episodeType"); //"I","O","E" .
		String receiptRefundIndicator = request.getParameter("receiptRefundIndicator"); // "REFUND" , "RECEIPT"
		if(receiptRefundIndicator==null) receiptRefundIndicator="";
		String strcashcountercode="";
		String strsysmessageid="";
		String strshiftid="";

		Connection con = ConnectionManager.getConnection(request);;
		CallableStatement call =null;
						try 
						{
							System.out.println("{ call Ajax BL_USER_CHECK_FOR_CASH_COUNTER (?,?,?,?,?,?,?)}");
							call = con.prepareCall("{ call BL_USER_CHECK_FOR_CASH_COUNTER (?,?,?,?,?,?,?)}");			
							call.setString(1,strfacilityid);
							call.setString(2,strepisodetype);//"O");//Karthikkkkkk
							call.setString(3,strloggeduser);
							call.setString(4,strwsno);
							call.registerOutParameter(5,java.sql.Types.VARCHAR); // Cash Counter
							call.registerOutParameter(6,java.sql.Types.VARCHAR); // shift
							call.registerOutParameter(7,java.sql.Types.VARCHAR); // Error code
							call.execute();				

							strcashcountercode	 = call.getString(5);
							strshiftid		 = call.getString(6);
							strsysmessageid	 = call.getString(7);		
							call.close();	
							if ( strsysmessageid == null ) strsysmessageid = "";
							if ( strcashcountercode == null ) strcashcountercode = "";
							if ( strshiftid == null ) strshiftid = "";
						}
						catch(Exception e) 
						{   e.printStackTrace();
							out.println(e.toString()); 
						}
						
						if(strsysmessageid.equals("")){
							if(receiptRefundIndicator.equals("RECEIPT") || receiptRefundIndicator.equals("REFUND") ){
								try 
								{
									System.out.println("{ call Ajax blcommon.get_receipt_refund_check (?,?,?,?,?,?,?,?,?,?)}");
									call = con.prepareCall("{ call blcommon.get_receipt_refund_check (?,?,?,?,?,?,?,?,?,?)}");			
									call.setString(1,strfacilityid);
									call.setString(2,strcashcountercode);
									call.registerOutParameter(3,java.sql.Types.VARCHAR);
									call.registerOutParameter(4,java.sql.Types.VARCHAR);
									call.registerOutParameter(5,java.sql.Types.VARCHAR);
									call.registerOutParameter(6,java.sql.Types.VARCHAR);
									call.registerOutParameter(7,java.sql.Types.VARCHAR);
									call.registerOutParameter(8,java.sql.Types.VARCHAR);
									call.registerOutParameter(9,java.sql.Types.VARCHAR);
									call.registerOutParameter(10,java.sql.Types.VARCHAR);
									call.execute();				
		
		                            String g_rcpt_ip_allowed_yn= call.getString(3);
		                            String g_rcpt_op_allowed_yn= call.getString(4);
		                            String g_rcpt_ref_allowed_yn= call.getString(5);
		                            String g_rfnd_ip_allowed_yn= call.getString(6);
		                            String g_rfnd_op_allowed_yn= call.getString(7);
		                            String g_rfnd_ref_allowed_yn= call.getString(8);
		                            String p_error_id= call.getString(9);
		                            String p_error_text= call.getString(10);	
		                            
								
		                            if(receiptRefundIndicator.equals("RECEIPT")){
			                            if(g_rcpt_op_allowed_yn.equals("N") && (strepisodetype.equals("O") || strepisodetype.equals("E"))){
			                            	strsysmessageid="BL9652";
			                            }
			                            if(g_rcpt_ip_allowed_yn.equals("N") && (strepisodetype.equals("I") || strepisodetype.equals("D"))){
			                            	strsysmessageid="BL9653";
			                            }
			                            if(g_rcpt_ref_allowed_yn.equals("N") && strepisodetype.equals("R")){
			                            	strsysmessageid="BL9654";
			                            }
		                            }else if(receiptRefundIndicator.equals("REFUND")){
			                            if(g_rfnd_op_allowed_yn.equals("N") && (strepisodetype.equals("O") || strepisodetype.equals("E"))){
			                            	strsysmessageid="BL9655";
			                            }
			                            if(g_rfnd_ip_allowed_yn.equals("N") && (strepisodetype.equals("I") || strepisodetype.equals("D"))) {                 			
			                            	strsysmessageid="BL9656";
			                            }
			                            if(g_rfnd_ref_allowed_yn.equals("N") && strepisodetype.equals("R")){	             			
			                            	strsysmessageid="BL9657";
			                            }
		                            }
			
		
								}
								catch(Exception e) 
								{   e.printStackTrace();
									out.println(e.toString()); 
								}finally{
									call.close();
								}
							}
						}
						
						if(strsysmessageid.equals("")){
                            if(receiptRefundIndicator.equals("RECEIPT")){
									try 
									{
										System.out.println("{ call Ajax blcommon.check_for_receipt (?,?,?,?,?,?)}");
										call = con.prepareCall("{ call blcommon.check_for_receipt (?,?,?,?,?,?)}");								
										call.setString(1,strloggeduser);
										call.setString(2,strfacilityid);
										call.setString(3,strcashcountercode);
										call.registerOutParameter(4,java.sql.Types.VARCHAR);
										call.registerOutParameter(5,java.sql.Types.VARCHAR);
										call.registerOutParameter(6,java.sql.Types.VARCHAR);
										call.execute();				
			
			                            String cash_counter_receipt_allowed_yn = call.getString(4);
			                            String p_error_id= call.getString(5);
			                            String p_error_text= call.getString(6);                            
										
			                                if(cash_counter_receipt_allowed_yn.equals("N")){
				                            	strsysmessageid="BL1260";
				                            }
			
									}
									catch(Exception e) 
									{   e.printStackTrace();
										out.println(e.toString()); 
									}finally{
										call.close();
									}
							}
						}	
						
						if(strsysmessageid.equals("")){
							if(receiptRefundIndicator.equals("REFUND")){
									try 
									{
										System.out.println("{ call Ajax blcommon.check_for_refund (?,?,?,?,?,?)}");
										call = con.prepareCall("{ call blcommon.check_for_refund (?,?,?,?,?,?)}");								
										call.setString(1,strloggeduser);
										call.setString(2,strfacilityid);
										call.setString(3,strcashcountercode);
										call.registerOutParameter(4,java.sql.Types.VARCHAR);
										call.registerOutParameter(5,java.sql.Types.VARCHAR);
										call.registerOutParameter(6,java.sql.Types.VARCHAR);
										call.execute();				
			
			                            String cash_counter_refund_allowed_yn = call.getString(4);
			                            String p_error_id= call.getString(5);
			                            String p_error_text= call.getString(6);                            
										
			                                if(cash_counter_refund_allowed_yn.equals("N")){
				                            	strsysmessageid="BL1261";
				                            }
			
									}
									catch(Exception e) 
									{   e.printStackTrace();
										out.println(e.toString()); 
									}finally{
										call.close();
									}
							}
						}
			
					JSONObject obj=new JSONObject();
					if(strsysmessageid.equals(""))
					{	
					    obj.put("flag","Y");  
					    obj.put("messageid",strsysmessageid); 
					}else{
					    obj.put("flag","N"); 
					    obj.put("messageid",strsysmessageid); 
					    
					}
 
				    out.print(obj);
				    out.flush();
					%>

