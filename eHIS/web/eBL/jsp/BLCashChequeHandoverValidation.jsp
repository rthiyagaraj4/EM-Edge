
<%@page  contentType="text/html;charset=UTF-8" import="java.sql.*, java.util.Hashtable,java.util.ArrayList, java.util.HashMap,java.util.Enumeration, eBL.Common.*, eCommon.Common.*, webbeans.eCommon.* ,webbeans.op.CurrencyFormat,eBL.BLCashChequeHandOverBean" %>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<%-- Mandatory declarations end --%>
<jsp:useBean id="xmlObj" scope="page" class="webbeans.eCommon.XMLStringParser"/>
<%
Connection con = null;
try {
	HttpSession httpSession = request.getSession(false);
	Properties p = (Properties)httpSession.getValue("jdbc");
	request.setCharacterEncoding("UTF-8");
	con = ConnectionManager.getConnection();	
	PreparedStatement pstmt = null;
	ResultSet rs = null;ResultSet rs1=null;//ResultSet rs_pkd=null;	
	String locale			= (String)session.getAttribute("LOCALE");
	String facilityId		= (String) session.getValue( "facility_id" ) ;
	String loginUser =  p.getProperty("login_user");		
	CurrencyFormat cf = new CurrencyFormat();
	Hashtable hash				= (Hashtable)xmlObj.parseXMLString( request ) ;
	hash						= (Hashtable)hash.get( "SEARCH" ) ;
//	HashMap		labelsTmp				=	null;
	//int rec_count=0;
	String mode="";int noofdecimal=2;
	String str_noofdecimal="2";
	String cashCounterCode ="",strLoginTime="",strsysdate="",strCount="";//strsysdateDB="";
//	String strLoginTimeDB="";
		String 	cashInHand="",chequeInHand="",strErrorLevel="",strMessageId="",strErrorText="";
	String function_id = request.getParameter("function_id") == null ? "" :request.getParameter("function_id") ;
	String func_mode = request.getParameter("func_mode") == null ? "" :request.getParameter("func_mode") ;
	
	String function_mode = "",cash_select="";


	 cashCounterCode		=	(String) hash.get( "cashCounterCode" );	 

	
	if(function_id!= null && function_id.equals("GET_DETAILS"))
	{  
		str_noofdecimal =(String) hash.get( "noofdecimal" );	
		noofdecimal = 	Integer.parseInt(str_noofdecimal);
		mode="insert";
			try
				{
					String sql1 = "	SELECT  to_char(LOGIN_DATE_TIME,'dd/mm/yyyy hh24:mi:ss'), "+
					" to_char(sysdate,'dd/mm/yyyy hh24:mi:ss') "+
					" FROM    BL_CASH_COUNTER_LANG_VW "+
					" WHERE  CASH_CTR_IN_USE_BY = ? "+
					" AND    OPERATING_FACILITY_ID   = ? "+
					" AND language_id='"+locale+"' AND CASH_COUNTER_CODE='"+cashCounterCode+"' ORDER BY 1 ";

					//System.out.println("sql1 c validatin"+sql1);
					pstmt = con.prepareStatement(sql1);
					pstmt.setString(1, loginUser);
					pstmt.setString(2, facilityId);					
					rs = pstmt.executeQuery() ;
					while(rs.next())
					{
						strLoginTime = rs.getString(1);						
						strsysdate = rs.getString(2);						
					}

					if(!(locale.equals("en"))){
						strLoginTime = com.ehis.util.DateUtils.convertDate(strLoginTime,"DMYHMS","en",locale);
						strsysdate = com.ehis.util.DateUtils.convertDate(strsysdate,"DMYHMS","en",locale);
					}

					rs.close();
					pstmt.close();
				}catch(Exception e)
				{
					out.println("Error cash ctr = "+e);
				}	
				
				try
				{	
					if(!(locale.equals("en"))){
						strLoginTime = com.ehis.util.DateUtils.convertDate(strLoginTime,"DMYHMS",locale,"en");
						//strsysdate = com.ehis.util.DateUtils.convertDate(strsysdate,"DMYHMS","en",locale);
					}
					String sql2 = "	SELECT 'X' FROM BL_HANDED_REQT  WHERE OPERATING_FACILITY_ID ='"+facilityId+"' AND CASH_COUNTER_CODE='"+cashCounterCode+"' AND LOGGEDIN_USER_ID = '"+loginUser+"' AND login_date_time = TO_DATE('"+strLoginTime+"','dd/mm/yyyy hh24:mi:ss')	AND STATUS = 'R' ";

					pstmt = con.prepareStatement(sql2);										
					
					rs1 = pstmt.executeQuery() ;
					while(rs1.next())
					{
						strCount = rs1.getString(1);						
											
					}

					rs1.close();
					pstmt.close();
				}catch(Exception e)
				{
					out.println("Error request chk cash ctr = "+e);
					System.out.println("Error request chk cash ctr :"+e);
				}		
				out.println("chkRequestYn('"+strCount+"');");
	 if(!(strCount.equals("X"))){	
		try
			{	
			if(!(locale.equals("en"))){
						//strLoginTime = com.ehis.util.DateUtils.convertDate(strLoginTime,"DMYHMS",locale,"en");
						strsysdate = com.ehis.util.DateUtils.convertDate(strsysdate,"DMYHMS",locale,"en");
					}
				CallableStatement callstmt = con.prepareCall("{ call bl_csh_chq_handover.proc_get_csh_chq_in_hand(?,?,?,to_date(?,'dd/mm/yyyy  hh24:mi:ss'),to_date(?,'dd/mm/yyyy  hh24:mi:ss'),?,?,?,?,?)}");
				callstmt.setString(1,facilityId);			
				callstmt.setString(2,cashCounterCode);			
				callstmt.setString(3,loginUser);			
				callstmt.setString(4,strLoginTime);			
				callstmt.setString(5,strsysdate);			
				callstmt.registerOutParameter(6,java.sql.Types.VARCHAR);
				callstmt.registerOutParameter(7,java.sql.Types.VARCHAR);
				callstmt.registerOutParameter(8,java.sql.Types.VARCHAR);
				callstmt.registerOutParameter(9,java.sql.Types.VARCHAR);
				callstmt.registerOutParameter(10,java.sql.Types.VARCHAR);
				callstmt.execute();			
		
				cashInHand = callstmt.getString(6);
				chequeInHand = callstmt.getString(7);
				strErrorLevel = callstmt.getString(8);
				strMessageId=callstmt.getString(9);			
				strErrorText=callstmt.getString(10);			
				
			
				if(cashInHand==null) cashInHand="0.00";
				if(chequeInHand==null) chequeInHand="0.00";
				if(strErrorLevel==null) strErrorLevel="";
				if(strMessageId==null) strMessageId="";
				if(strErrorText==null) strErrorText="";
				cashInHand = cf.formatCurrency(cashInHand, noofdecimal);
				chequeInHand = cf.formatCurrency(chequeInHand, noofdecimal);

		
		}catch(Exception e)
		{
			System.out.println("Exception @ HEADER package  :"+e);
		}
		//out.println("<script>parent.document.getElementById('loginDateTime').value='"+strLoginTime+"'</script>");
		

		strLoginTime = com.ehis.util.DateUtils.convertDate(strLoginTime,"DMYHMS","en",locale);
		strsysdate = com.ehis.util.DateUtils.convertDate(strsysdate,"DMYHMS","en",locale);
		
	out.println("calltodisplaydetails('"+strLoginTime+"','"+strsysdate+"','"+loginUser+"','"+cashInHand+"','"+chequeInHand+"','"+mode+"');");
	} 			
	}

	if(function_id!= null && function_id.equals("GET_DB_VALUES"))
	{
		String strCashCountrCode="",strInUseBy="",strLoginDate="",strReqDateTime="",strCashHandedOver="",strcheqHandedOver="";
		mode="modify";
		
			str_noofdecimal =(String) hash.get( "noofdecimal" );	
    		noofdecimal = 	Integer.parseInt(str_noofdecimal);
			strCount="";
			
try{

				String sql1 = "	SELECT CASH_COUNTER_CODE,LOGGEDIN_USER_ID, to_char(LOGIN_DATE_TIME,'DD/MM/YYYY hh24:mi:ss' ),to_char(REQUESTED_DATE_TIME,'DD/MM/YYYY hh24:mi:ss'),CASH_REQUEST_AMT,CHQ_REQUEST_AMT FROM bl_handed_reqt WHERE LOGIN_DATE_TIME=(SELECT LOGIN_DATE_TIME FROM   BL_CASH_COUNTER_SLMT_HDR WHERE  OPERATING_FACILITY_ID = '"+facilityId+"'	AND    CASH_COUNTER_USER_ID  = '"+loginUser+"' AND    LOGOUT_DATE_TIME     IS NULL) AND STATUS='R' ";
				pstmt = con.prepareStatement(sql1);
				//pstmt.setString(1, facility_id);
				//pstmt.setString(2, loginUser);
										
					rs = pstmt.executeQuery() ;
					while(rs.next())
					{
						strCashCountrCode = rs.getString(1);						
						strInUseBy = rs.getString(2);						
						strLoginDate = rs.getString(3);						
						strReqDateTime = rs.getString(4);						
						//strCashHandedOver = rs.getString(5);						
						//strcheqHandedOver = rs.getString(6);						
					}

					
					if(strCashCountrCode==null) strCashCountrCode="";
					if(strInUseBy==null) strInUseBy="";
					if(strLoginDate==null) strLoginDate="";
					if(strReqDateTime==null) strReqDateTime="";
				//	if(strCashHandedOver==null) strCashHandedOver="0.00";
				//	if(strcheqHandedOver==null) strcheqHandedOver="0.00";

				//	strCashHandedOver = cf.formatCurrency(strCashHandedOver, noofdecimal);
				//	strcheqHandedOver = cf.formatCurrency(strcheqHandedOver, noofdecimal);

					//strLoginDate = com.ehis.util.DateUtils.convertDate(strLoginDate,"DMYHMS","en",locale);
					//strReqDateTime = com.ehis.util.DateUtils.convertDate(strReqDateTime,"DMYHMS","en",locale);

					/*if(!(locale.equals("en"))){
						strLoginDate = com.ehis.util.DateUtils.convertDate(strLoginDate,"DMYHMS","en",locale);
						strReqDateTime = com.ehis.util.DateUtils.convertDate(strReqDateTime,"DMYHMS","en",locale);
					}
*/
					
					rs.close();
					pstmt.close();

					
										
						String sql2 = "	SELECT 'X' FROM BL_HANDED_REQT  WHERE OPERATING_FACILITY_ID ='"+facilityId+"' AND CASH_COUNTER_CODE='"+strCashCountrCode+"' AND LOGGEDIN_USER_ID = '"+strInUseBy+"' AND login_date_time = TO_DATE('"+strLoginDate+"','dd/mm/yyyy hh24:mi:ss')	AND STATUS = 'R' ";

						pstmt = con.prepareStatement(sql2);										
						
						rs1 = pstmt.executeQuery() ;
						while(rs1.next())
						{
							strCount = rs1.getString(1);						
												
						}

						rs1.close();
						pstmt.close();
					}catch(Exception e)
					{
						out.println("Error request chk GET ctr = "+e);
						System.out.println("Error request chk GET ctr :"+e);
					}		
				out.println("modifyRequestYn('"+strCount+"');");
 if(strCount.equals("X")){
	 	try{

			/*if(!(locale.equals("en"))){
						strLoginDate = com.ehis.util.DateUtils.convertDate(strLoginDate,"DMYHMS",locale,"en");
						strReqDateTime = com.ehis.util.DateUtils.convertDate(strReqDateTime,"DMYHMS",locale,"en");
					}*/
					cashInHand="";
					chequeInHand="";
					CallableStatement callstmt = con.prepareCall("{ call bl_csh_chq_handover.proc_get_csh_chq_in_hand(?,?,?,to_date(?,'dd/mm/yyyy  hh24:mi:ss'),to_date(?,'dd/mm/yyyy  hh24:mi:ss'),?,?,?,?,?)}");
						callstmt.setString(1,facilityId);			
						callstmt.setString(2,cashCounterCode);			
						callstmt.setString(3,loginUser);			
						callstmt.setString(4,strLoginDate);			
						callstmt.setString(5,strReqDateTime);			
						callstmt.registerOutParameter(6,java.sql.Types.VARCHAR);
						callstmt.registerOutParameter(7,java.sql.Types.VARCHAR);
						callstmt.registerOutParameter(8,java.sql.Types.VARCHAR);
						callstmt.registerOutParameter(9,java.sql.Types.VARCHAR);
						callstmt.registerOutParameter(10,java.sql.Types.VARCHAR);
						callstmt.execute();			
				
						cashInHand = callstmt.getString(6);
						chequeInHand = callstmt.getString(7);
						strErrorLevel = callstmt.getString(8);
						strMessageId=callstmt.getString(9);			
						strErrorText=callstmt.getString(10);			
						
					
						if(cashInHand==null) cashInHand="0.00";
						if(chequeInHand==null) chequeInHand="0.00";
						if(strErrorLevel==null) strErrorLevel="";
						if(strMessageId==null) strMessageId="";
						if(strErrorText==null) strErrorText="";


						strCashHandedOver = cf.formatCurrency(cashInHand, noofdecimal);
						strcheqHandedOver = cf.formatCurrency(chequeInHand, noofdecimal);

		}catch(Exception e)
		{
			//out.println("Error cash ctr = "+e);
			e.printStackTrace();
		}
				
				//String bean_id		= "BLCashChequeHandOverBean";
				//String bean_name	= "eBL.BLCashChequeHandOverBean";
				//BLCashChequeHandOverBean bean			= (BLCashChequeHandOverBean)getBeanObject( bean_id, bean_name, request ) ;
			//	bean.setDBValues(strCashCountrCode,strInUseBy,strReqDateTime,locale,facilityId);//set database values to bean.

		
		strLoginDate = com.ehis.util.DateUtils.convertDate(strLoginDate,"DMYHMS","en",locale);
		strReqDateTime = com.ehis.util.DateUtils.convertDate(strReqDateTime,"DMYHMS","en",locale);

	out.println("calltodisplaydetails('"+strLoginDate+"','"+strReqDateTime+"','"+strInUseBy+"','"+strCashHandedOver+"','"+strcheqHandedOver+"','"+mode+"');");
	}
	}

	if(function_id!= null && function_id.equals("DUPLICATE_CHECK"))
	{  	
		//double totalAmount=0;
		ArrayList currDeno     = new ArrayList();
		int totRec		    = Integer.parseInt((String) hash.get( "total_records" ));
		int	index	    	= Integer.parseInt((String) hash.get( "index" ));	
		String item	= (String) hash.get( "item" );
		for(int i=0;i<totRec; i++)
		{
			if(i!=index)
			currDeno.add((String) hash.get( "code_"+i ));
		}
		
		if(currDeno.contains(item)){
			out.println("duplicateAlert('"+index+"')");		
		}
	
    } 
try{
	if(function_id!= null && function_id.equals("STORE_VALUES"))
	{  
		if(func_mode!= null && func_mode.equals("CASH_DTLS")){
			String bean_id		= "BLCashChequeHandOverBean";
			String bean_name	= "eBL.BLCashChequeHandOverBean";
			BLCashChequeHandOverBean bean			= (BLCashChequeHandOverBean)getBeanObject( bean_id, bean_name, request ) ;
			String	total_records		=	(String) hash.get( "totalRecordsCash" );
			function_mode               =	(String) hash.get( "mode" );  
			int totalRec				=	Integer.parseInt(total_records);
			ArrayList	curr_deno	    =	new ArrayList();
			ArrayList	curr_num	    =	new ArrayList();
			ArrayList	curr_amt	    =	new ArrayList();
			ArrayList	cash_colloction_details	    =	new ArrayList();
			HashMap cashCollectionDtlsMap    =   new HashMap();
			String temp="";String tot_cash_amt="";	
				for(int i=0;i<totalRec; i++)
					{
					temp =(String) hash.get( "currDeno_"+i );

						if(function_mode.equals("modify"))
						{
							cash_select  =	(String) hash.get( "cashSelect_"+i );  
							
							if(cash_select.equals("Y"))
							{
								if(!(temp.equals("")))
								{
								   curr_deno.add((String) hash.get( "currDeno_"+i ));
								   curr_num.add((String) hash.get( "currNumber_"+i ));
								   curr_amt.add((String) hash.get( "currAmt_"+i ));
								}
							}
						}else{						
							if(!(temp.equals("")))
								{
							   curr_deno.add((String) hash.get( "currDeno_"+i ));
							   curr_num.add((String) hash.get( "currNumber_"+i ));
							   curr_amt.add((String) hash.get( "currAmt_"+i ));
								}
						}
					}
					 cash_colloction_details.add( curr_deno );
					 cash_colloction_details.add( curr_num );
					 cash_colloction_details.add( curr_amt );

				 cashCollectionDtlsMap.put("CASH_COLL_DTLS",cash_colloction_details);
				 bean.setCashCollectionDtls(cashCollectionDtlsMap);

				 tot_cash_amt = (String) hash.get( "cash_total");

				bean.setTotCashAmt(tot_cash_amt);

		
		
		}
		if(func_mode!= null && func_mode.equals("CHEQ_DTLS")){
			String bean_id		= "BLCashChequeHandOverBean";
			String bean_name	= "eBL.BLCashChequeHandOverBean";
			BLCashChequeHandOverBean bean			= (BLCashChequeHandOverBean)getBeanObject( bean_id, bean_name, request ) ;
			String	total_records_chq		=	(String) hash.get( "totalRecordsChq" );
			int totalRec				=	Integer.parseInt(total_records_chq);
			ArrayList	chq_num			=	new ArrayList();
			ArrayList	chq_date		=	new ArrayList();
			ArrayList	bank_name	    =	new ArrayList();
			ArrayList	payer_name	    =	new ArrayList();
			ArrayList	patient_id	    =	new ArrayList();
			ArrayList	chq_amount		=	new ArrayList();
			ArrayList	cheque_colloction_details	    =	new ArrayList();
			HashMap chequeCollectionDtlsMap    =   new HashMap();
			String temp="";		String tot_chk_amt="",temp_chk_num="";				
				for(int i=0;i<totalRec; i++)
					{
						temp =(String) hash.get( "chkSelect_"+i );
						//System.out.println("temp vali:"+temp);
						temp_chk_num =(String) hash.get( "chqNum_"+i );
						//System.out.println("temp_chk_num vali:"+temp_chk_num);



					if(temp.equals("Y"))
					 {
						if(!(temp_chk_num.equals("")))
								{
						   chq_num.add((String) hash.get( "chqNum_"+i ));
						   chq_date.add((String) hash.get( "chqDate_"+i ));
						   bank_name.add((String) hash.get( "bank_"+i ));
						   payer_name.add((String) hash.get( "payer_"+i ));
						   patient_id.add((String) hash.get( "patientId_"+i ));
						   chq_amount.add((String) hash.get( "chqAmount_"+i ));
								}
						
					 }
					}
					 cheque_colloction_details.add( chq_num );
					 cheque_colloction_details.add( chq_date );
					 cheque_colloction_details.add( bank_name );
					 cheque_colloction_details.add( payer_name );
					 cheque_colloction_details.add( patient_id );
					 cheque_colloction_details.add( chq_amount );					

				 chequeCollectionDtlsMap.put("CHEQUE_COLL_DTLS",cheque_colloction_details);
				 bean.setChequeCollectionDtls(chequeCollectionDtlsMap);
			

				
				tot_chk_amt = ((String) hash.get( "cheque_total"));
				bean.setTotChequeAmt(tot_chk_amt);
		
		
		}
	}
	}catch (Exception e) {

	e.printStackTrace() ;
	System.out.println("Exception from STORE_VALUES :"+e);
	}
	

}catch (Exception e) {

	e.printStackTrace() ;
	System.out.println("Exception from PkgDefValidation :"+e);
}
finally
		{
		ConnectionManager.returnConnection(con, request);
		}
//putObjectInBean(bean_id,beanObj,request);

%>

