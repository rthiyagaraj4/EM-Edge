<!DOCTYPE html>
<%@page  contentType=" text/html;charst=UTF-8"%>
<%@ include file="../../eOT/jsp/StringUtil.jsp"%>
<%-- <%@ include file="../../eCommon/jsp/CommonInclude.jsp" %> <!-- Commented for Avoiding Script tag in out value-->  --%>
<%@include file="../../eCommon/jsp/Common.jsp" %> 
<%@	include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@page  import ="java.sql.Connection,java.sql.ResultSet,java.sql.PreparedStatement,java.sql.CallableStatement,webbeans.eCommon.ConnectionManager,eOT.OTBillingBean,eOR.OrderEntryBillingQueryBean,java.sql.Types,java.util.ArrayList,java.util.HashMap" %>
<%  //Note: bean_id name shouldn't be changed. if it is done billing window will not populate charges.
	String bean_id 						= "Or_billingQueryBean";
	String bean_name 					= "eOR.OrderEntryBillingQueryBean";
	OrderEntryBillingQueryBean or_bean		= (OrderEntryBillingQueryBean)getBeanObject( bean_id, bean_name, request ) ;
	String ot_bean_id = "OTBillingBean";
	String ot_bean_name= "eOT.OTBillingBean";
	OTBillingBean billing_bean			= (OTBillingBean)mh.getBeanObject( ot_bean_id, request,ot_bean_name  ) ;
	
	//session properties
	String facility_id = (String)session.getValue( "facility_id" ) ;
	java.util.Properties prop = (java.util.Properties) session.getValue( "jdbc" ) ;
	//String ws_no = prop.getProperty( "client_ip_address" );
	//String login_user = prop.getProperty( "login_user" );
	String locale = prop.getProperty("LOCALE") ;
	String called_from = request.getParameter("called_from").intern();
	String fpp_order_yn = "";
	String fpp_category = "";
	 ArrayList bill_dtls = new ArrayList();
	ArrayList Fpplist = new ArrayList();
	

	//cannonical representation of empty string
	String emt				= "".intern();
	
	//identifiers used 
	String patient_id			= emt;
	String surgeon_code     = emt;
	String booking_date		= emt;
	String encounter_id		= emt;
	String patient_class		= emt;
    String oper_code			= emt;
	String order_id				= emt;
	String order_line_num	= emt;
	String catalog_code		= emt;
	String quantity				= "1";
	String episode_type		= emt;
	String epiosde_id			= emt;
	String visit_id				= emt;
//	String oper_date			= emt;
	String oper_num			= emt;
	String key					= emt;
	String acc_type					= emt;
	String acc_code					= emt;
	String fpp_cat					= emt;

	//This hashMap stores all the possible stages where billing is called.
	HashMap dictMap = new HashMap(7);
	dictMap.put("OT_MENU","1");//Direct-Check-In
	dictMap.put("DIRECT_BOOKING","2");//Direct-Booking
	dictMap.put("RECORD_SURGEON","3");
	dictMap.put("ACC_TAB","4");

	int  choice	= Integer.parseInt((String) dictMap.get(called_from));
	
	switch(choice){
		case 1: 
					
					//Direct Check-In
					oper_code				=	checkForNull(request.getParameter("oper_code"));
					patient_id				=	checkForNull(request.getParameter("patient_id"));
					booking_date			=	checkForNull(request.getParameter("oper_date"));
					encounter_id			=	checkForNull(request.getParameter("encounter_id"));
					surgeon_code			=	checkForNull(request.getParameter("surgeon_code"));
				    patient_class			=	checkForNull(request.getParameter("patient_class"));
					break;
		case 2: 	
					//Direct Booking
					oper_code				=	checkForNull(request.getParameter("oper_code"));
					patient_id				=	checkForNull(request.getParameter("patient_id"));
					booking_date			=	checkForNull(request.getParameter("oper_date"));
					encounter_id			=	checkForNull(request.getParameter("encounter_id"));
					surgeon_code			=	checkForNull(request.getParameter("surgeon_code"));
				    patient_class			=	checkForNull(request.getParameter("patient_class"));
				    fpp_cat			=	checkForNull(request.getParameter("fpp_category"));
					break;
		case 3:
					//Record Surgeon
					oper_code					=	checkForNull(request.getParameter("oper_code"));
					oper_num					=	checkForNull(request.getParameter("oper_num"));
					fpp_cat			=	checkForNull(request.getParameter("fpp_category"));
					break;

					//For Surgical Accessories Billing..........
		case 4:
					acc_type					=	checkForNull(request.getParameter("acc_type"));
					acc_type	= acc_type==null?"":acc_type;
					acc_type	= acc_type.equals("null")?"":acc_type;
				//	if(acc_type.equals("I") || acc_type.equals("C")){
						quantity = checkForNull(request.getParameter("quantity"));
						quantity	= quantity==null?"1":quantity;
						quantity	= quantity.equals("null")?"1":quantity;
						quantity	= quantity.equals("")?"1":quantity;
				//	}
					acc_code					=	checkForNull(request.getParameter("acc_code"));
					oper_num					=	checkForNull(request.getParameter("oper_num"));
					oper_code					=	checkForNull(request.getParameter("oper_code"));
					break;

	}
	
	//SQL Strings
	String SQL_CATALOG_CODE	=  "SELECT ORDER_CATALOG_CODE FROM OT_OPER_MAST WHERE OPER_CODE =?";
	String PAT_DTLS	=  "SELECT PATIENT_ID,(SELECT TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI') FROM DUAL),ENCOUNTER_ID,SURGEON_CODE,PATIENT_CLASS,EPISODE_TYPE,EPISODE_ID,VISIT_ID FROM OT_POST_OPER_HDR WHERE OPERATING_FACILITY_ID=? AND OPER_NUM=?";
  	HashMap	bill_map = new HashMap(); 
	
	//intialization of DB Resources
	Connection con = null;
	CallableStatement cstmt= null;
	PreparedStatement pstmt = null;
	ResultSet rst = null;
	//getting connection from connectionManager
	con = ConnectionManager.getConnection();
	try{
		  switch(choice){
			  case 3: 
			  case 4: 
			 	pstmt = con.prepareStatement(PAT_DTLS);	
				pstmt.setString(1,facility_id);
				pstmt.setString(2,oper_num);
				rst = pstmt.executeQuery();
				//getting patient details
				HashMap pat_map = new HashMap();
				while(rst.next()){
					patient_id		= rst.getString(1);	
					booking_date	= rst.getString(2);	
					encounter_id	= rst.getString(3);	
					surgeon_code	= rst.getString(4);	
					patient_class	= rst.getString(5);
					episode_type	= rst.getString(6);
					epiosde_id		= rst.getString(7);
					visit_id		= checkForNull(rst.getString(8));
				}	
				rst.close();
				pstmt.close();			
				pat_map.put("patient_id",patient_id);
				pat_map.put("service_date",booking_date);
				pat_map.put("encounter_id",encounter_id);
				pat_map.put("surgeon_code",surgeon_code);
				pat_map.put("patient_class",patient_class);
				pat_map.put("locale",locale);
				break;
		  }
		
		//getting catalog_code
		pstmt = con.prepareStatement(SQL_CATALOG_CODE);	
		pstmt.setString(1,oper_code);
		rst = pstmt.executeQuery();
		while(rst.next()){
			catalog_code = rst.getString(1);			
		}	
		rst.close();
		pstmt.close();	
	}catch(Exception e){
		e.printStackTrace();
		System.err.println("Err Msg from OTOrderLineCreation.jsp "+e);
	}finally{
		if(rst!=null)rst.close();
		if(cstmt!=null)cstmt.close();
		if(con!=null)con.close();
	}

	if("ACC_TAB".equals(called_from)) {
		catalog_code = acc_type+"#"+acc_code;
		key = oper_num+"@"+oper_code+"@"+acc_type+"@"+acc_code;
	}else{
		key = patient_id+oper_code;
	}
Fpplist = billing_bean.getFPPDetails(oper_code);
	for (int j = 0; j < Fpplist.size(); j++){
			  if(j==0) fpp_order_yn=checkForNull((String)Fpplist.get(j));
              if(j==1) fpp_category=checkForNull((String)Fpplist.get(j));
			}
			
	//ML-MMOH-CRF-1939-US003
	if("S".equals(fpp_cat) || "M".equals(fpp_cat) || "C".equals(fpp_cat))
	{
		//fpp_order_yn = "Y";
		fpp_category = fpp_cat;
	}
	else
	{
	Fpplist = billing_bean.getFPPDetails(oper_code);
			
			System.err.println("fpp_order_yn :"+fpp_order_yn);
			System.err.println("fpp_category :"+fpp_category);
	}
		//ML-MMOH-CRF-1939-US003
			//getting billing details
			if(fpp_order_yn.equals("Y"))
			{
				System.err.println("IFFFFFFFFFFFFFFFFFFFFFFFFF");
				 bill_dtls = or_bean.getBillChargeDetailsfpp(quantity,catalog_code,booking_date,locale,order_id,order_line_num,patient_id,encounter_id,patient_class,surgeon_code,fpp_order_yn,fpp_category);
			}
			else{
//	ArrayList bill_dtls = or_bean.getBillChargeDetails(quantity,oper_code,booking_date,locale,order_id,order_line_num,patient_id,encounter_id,patient_class,surgeon_code);
	 bill_dtls = or_bean.getBillChargeDetails(quantity,catalog_code,booking_date,locale,order_id,order_line_num,patient_id,encounter_id,patient_class,surgeon_code);
			}
	
	if(bill_dtls!=null && bill_dtls.size()>0)
	{
		String[] bill_info = (String[]) bill_dtls.get(0);
		bill_map.put("bl_panel_str",bill_info[0]);                //P_STR                
		bill_map.put("charge_based_yn",bill_info[1]);        //P_CHARGE_BASED_YN   
		bill_map.put("total_payable",bill_info[2]);            //P_TOT_AMT           
		bill_map.put("patient_payable",bill_info[3]);        //P_PAT_PAYABLE_AMT   
		bill_map.put("excl_incl_ind",bill_info[4]);            //P_EXCL_INCL_IND     
		bill_map.put("preapp_yn",bill_info[5]);              //P_PREAPP_YN         
		bill_map.put("patient_paid_amt",bill_info[6]);    //P_PAT_PAID_AMT      
		bill_map.put("charged_yn",bill_info[7]);           //P_CHARGED_YN        
		bill_map.put("pat_billed_yn",bill_info[8]);         //P_PAT_BILLED_YN     
		bill_map.put("error_text",bill_info[9]);            //ERROR_TEXT           
		bill_map.put("serv_panel_ind",bill_info[10]);    //P_SERV_PANEL_IND    
		bill_map.put("serv_panel_code",bill_info[11]); //P_SERV_PANEL_CODE   
		bill_map.put("service_panel_name",bill_info[12]);//P_SERVICE_PANEL_NAME
		bill_map.put("episode_type",bill_info[13]);      //P_EPISODE_TYPE      
		bill_map.put("episode_id",bill_info[14]);        //P_EPISODE_ID        
		bill_map.put("visit_id",bill_info[15]);          //P_VISIT_ID        
		//other billing details
		bill_map.put("patient_id",patient_id);         
		bill_map.put("service_date",booking_date);         
		bill_map.put("encounter_id",encounter_id);         
		bill_map.put("pract_staff_id",surgeon_code);         
		bill_map.put("pract_staff_ind","P");         
		bill_map.put("patient_class",patient_class);         
		bill_map.put("quantity",quantity);         
		bill_map.put("oper_code",oper_code);         
		bill_map.put("key",key);         
		bill_map.put("key_line_no",emt);         
		bill_map.put("order_id",emt);         
		bill_map.put("order_line_num",emt);         
		
		if(bill_info[11].equals("") || bill_info[11]==null || bill_info[11].equals("null")){
			out.println("BL0639"+"@@");
		}else{
			//key for  persistence bean  oper_code
			or_bean.setOrderBillDtls(key,bill_map);
            //bill_info[9]="error--->";
			putObjectInBean(bean_id,or_bean,request);
			
   out.println(bill_info[0]+"@@"+bill_info[2]+"::"+bill_info[3]+"::"+bill_info[6]+"::"+bill_info[1]+"::"+"null"+"::"+bill_info[5]+"::"+bill_info[10]+"::"+"null"+"::"+bill_info[4]+"@@"+bill_info[9]);/* Note: here "null" is overriddenreason code value;*/
		}
	}
	
 %>

	
