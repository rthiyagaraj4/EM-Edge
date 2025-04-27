<!DOCTYPE html>
 <%-- saved on 03/11/2005 --%>
<%@page  import="java.sql.*, java.util.*,java.text.DecimalFormat, java.io.*, ePH.Common.*, ePH.*,eST.*,eST.Common.*,eOR.*,java.text.DecimalFormat" contentType="text/html;charset=UTF-8" %>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<jsp:useBean id="xmlObj" scope="page" class="webbeans.eCommon.XMLStringParser"/>

<%

	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
    String login_user       = (String)session.getValue("login_user");
	String facility    = (String)session.getValue("facility_id");
	java.util.Properties p = (java.util.Properties) session.getValue("jdbc") ;
	String	 client_ip_address = p.getProperty("client_ip_address");
		
	
	try {

		Hashtable hash				= (Hashtable)xmlObj.parseXMLString( request ) ;
		hash						= (Hashtable)hash.get( "SEARCH" ) ;
		String validate             = request.getParameter("validate") ; 

        if(validate.equals("DRUG_MEDICAL")){ 

			String bean_id				= (String) hash.get( "bean_id" );
			String bean_name			= (String) hash.get( "bean_name" );
			//	int    record_cnt			=  hash.get( "record_cnt" )==null ? 0:Integer.parseInt((String) hash.get( "record_cnt" ));
			String checked_yn			=  hash.get( "checked_yn" ) == null?"":(String) hash.get( "checked_yn" ) ;
			String prescription_id			=  hash.get( "prescription_id" ) == null?"":(String) hash.get( "prescription_id" ) ;
			String mode			=  hash.get( "mode" ) == null?"":(String) hash.get( "mode" ) ;

			SRROnlineReportSet1Bean beanObj		= (SRROnlineReportSet1Bean)getBeanObject(bean_id,bean_name,request);
			beanObj.setLanguageId(locale);

			if (mode.equals("ADD_ELEMENT")){
				beanObj.setSelectedValue_drug(prescription_id);	
			}
			else if(mode.equals("REMOVE_ELEMENT")){
				beanObj.removeValue_drug(prescription_id);			
			}
			else if(mode.equals("ADD_ELEMENT_ALL")){

			/*if(!prescription_id.equals(""))
			{
				if(prescription_id.indexOf("~") > 0){
				String[] strArr = prescription_id.split("~");
				for(int i=0;i<strArr.length;i++){

					beanObj.setSelectedValue_drug(strArr[i]);	
				  }
				}else{
					 beanObj.setSelectedValue_drug(prescription_id);	

					}
			}*/
				ArrayList active_orders= (ArrayList) beanObj.getActiveOrders();
				for(int i=0;i<active_orders.size();i++){
					HashMap record	=	(HashMap)active_orders.get(i);		  	
					record.put("flag","Y");
				}
			}
			else if(mode.equals("REMOVE_ELEMENT_ALL")){

				if(prescription_id.indexOf("~") > 0){
				String[] strArr = prescription_id.split("~");
				for(int i=0;i<strArr.length;i++){
				beanObj.removeValue_drug(strArr[i]);
				}
			}
			else{
				beanObj.removeValue_drug(prescription_id);	
		   }
		}
		else if(mode.equals("ADD_ALL_RESULTQUERY_ELEMENT")){ 

			  if(checked_yn.equals("Y")){
				ArrayList active_DispLabelRecds =	new ArrayList();
				active_DispLabelRecds	 =	beanObj.getDispLabelRecds();
			  }
			}
			putObjectInBean(bean_id,beanObj,request);
	   }
	   else if(validate.equals("PRINT_FOR_DRUG_MEDICAL")){

			String bean_id				= (String) hash.get( "bean_id" );
			String bean_name			= (String) hash.get( "bean_name" );
			String disp_no	="";		 
			String srl_no	 ="";		 
			String iv_prep_yn	="";		
			String p_order_date	="";		
			String p_langue	="";			
			String p_token_dly_seq_no="";
			String patient_class=""; // Added for SKR-SCF-0589[Inc:34387]
			String patient_id ="";
			String disp_stage ="";  // Added for SKR-SCF-0589[Inc:34387]

			SRROnlineReportSet1Bean beanObj		= (SRROnlineReportSet1Bean)getBeanObject(bean_id,bean_name,request);
			beanObj.setLanguageId(locale);
			ArrayList active_orders		=	new ArrayList();		
			active_orders	=	beanObj.getActiveOrders();
			for (int i=0; i<active_orders.size(); i++) {
				HashMap record	=	(HashMap)	active_orders.get(i);
				String  flag=(String) record.get("flag");
				if(flag.equals("Y")){
					disp_no			    =  record.get( "disp_no" )==null?"":(String) record.get( "disp_no" );
					srl_no			    =  record.get( "srl_no" )==null?"":(String) record.get( "srl_no" );
					iv_prep_yn			=  record.get( "iv_prep_yn" )==null?"":(String) record.get( "iv_prep_yn" );
					p_order_date			=  record.get( "p_order_date" )==null?"":(String) record.get( "p_order_date" );
					p_langue				=  record.get( "p_langue" )==null?"":((String) record.get( "p_langue" )).trim();
					p_token_dly_seq_no	=  record.get( "p_token_dly_seq_no" )==null?"":((String) record.get( "p_token_dly_seq_no" )).trim();
					patient_id	=  record.get( "patient_id" )==null?"":((String) record.get( "patient_id" )).trim();
					disp_stage  =  record.get( "order_line_status" )==null?"":((String) record.get( "order_line_status" )).trim(); // Added for SKR-SCF-0589[Inc:34387]
					patient_class  =  record.get( "patient_class" )==null?"":((String) record.get( "patient_class" )).trim(); // Added for SKR-SCF-0589[Inc:34387]
					String rep_id="";	// Added for SKR-SCF-0589[Inc:34387]
					String p_trn_group = "";
					ecis.utils.OnlineReports onlineReports 		= new ecis.utils.OnlineReports() ;
					//Added below condition for SKR-SCF-0589[Inc:34387]-Start
					ecis.utils.OnlineReport report1 =null;	// Added for SKR-SCF-0589[Inc:34387]
					if(iv_prep_yn.equals("1") || iv_prep_yn.equals("3") || iv_prep_yn.equals("5")){
					 if(disp_stage.equals("IP") || disp_stage.equals("AL")){	// Added for SKR-SCF-0589[Inc:34387] - start
						if(iv_prep_yn.equals("1")){      //IV - With Additives
							rep_id="PHRIVCONTFILL";
						}
						else if (iv_prep_yn.equals("3")){	//IV - Intermittent
							rep_id="PHRIVINTTFILL";
						}
						else if (iv_prep_yn.equals("5")){ 	//IV - Fluid (Without Additives)
							rep_id="PHRFILLCONWOADD";
						}
					}	
					else if(disp_stage.equals("DF") || disp_stage.equals("DP")){
					
						if(iv_prep_yn.equals("1")){
							rep_id="PHRIVCONT";
						}
						else if (iv_prep_yn.equals("3")){
							rep_id="PHRIVINTT";
						}
						else if (iv_prep_yn.equals("5")){
							rep_id="PHRIVCONTWOADD";
						}
					}	// Added for SKR-SCF-0589[Inc:34387] - end
						report1			= new ecis.utils.OnlineReport( facility, "PH",rep_id) ;  // Added rep_id to handle multiple scenarios - SKR-SCF-0589[Inc:34387]
						report1.addParameter("p_patient_id",patient_id) ;
						report1.addParameter("p_report_id",rep_id) ; 
					}
					else{
						 report1			= new ecis.utils.OnlineReport( facility, "PH","PHPRDISLBFILL") ; 
						 report1.addParameter("p_patient_id",patient_id) ;
						report1.addParameter("p_report_id","PHPRDISLBFILL") ; 
					}//Added for SKR-SCF-0589[Inc:34387]-End
					report1.addParameter("p_user_name",login_user) ;
					report1.addParameter("p_language_id",p_langue);
					report1.addParameter("p_disp_date",p_order_date) ;
					report1.addParameter("p_disp_no",disp_no) ;
					report1.addParameter("p_srl_no",srl_no) ;
					report1.addParameter("p_online","N");
					report1.addParameter("p_label_cnt","1");
					report1.addParameter("p_trn_group",p_trn_group);
					report1.addParameter("p_token_dly_seq_no",p_token_dly_seq_no.trim());
					report1.addParameter("p_facility_id",facility) ;
					report1.addParameter("p_patient_class",patient_class) ;  // Added for SKR-SCF-0589[Inc:34387]
					report1.addParameter("p_module_id","PH") ;
					report1.addParameter("p_mode","PRINT") ;
					onlineReports.add( report1) ;
					String ReportOutput = onlineReports.execute( request, response );  
      			}
			}
	  		putObjectInBean(bean_id,beanObj,request);
		}
		else if(validate.equals("PRINT_ALL_RESULTQUERY_ELEMENT")){
			String bean_id				= (String) hash.get( "bean_id" );
			String bean_name			= (String) hash.get( "bean_name" );
			//Added for SKR-SCF-0589[Inc:34387]-Start
			String disp_srl_no			=  hash.get( "disp_srl_no" ).toString();
			String dispdtl_no			=  hash.get( "dispdtl_no" ).toString();
			String order_line_status	=  hash.get( "order_line_status" ).toString();
			String rep_id ="",disp_stage ="";
			HashMap hm = new HashMap();
			ArrayList disp_no=new ArrayList();
			ArrayList dispdtl_srl_no=new ArrayList();
			ArrayList orderline_status=new ArrayList();
			int n=0;
			if(disp_srl_no!=null || !disp_srl_no.equals("")){
				disp_srl_no=disp_srl_no.substring(1,disp_srl_no.length()-1);
				StringTokenizer st=new StringTokenizer(disp_srl_no,",");
				while(st.hasMoreTokens()){
					dispdtl_srl_no.add(n,st.nextToken());
					n++;
				}
				Collections.reverse(dispdtl_srl_no);
				n=0;
			}
			if(dispdtl_no!=null || !dispdtl_no.equals("")){
				dispdtl_no=dispdtl_no.substring(1,dispdtl_no.length()-1);
				StringTokenizer st=new StringTokenizer(dispdtl_no,",");
				String  currStat="";
				while(st.hasMoreTokens()){
					currStat=st.nextToken().trim();
					disp_no.add(n,currStat.toString());
					if(hm.containsKey(currStat.toString()))
						hm.put(currStat,Integer.parseInt(hm.get(currStat).toString())+1);
					else
						hm.put(currStat,"1");
				}
				n=0;
			}
			if(order_line_status!=null || !order_line_status.equals("")){
				order_line_status=order_line_status.substring(1,order_line_status.length()-1);
				StringTokenizer st=new StringTokenizer(order_line_status,",");
				while(st.hasMoreTokens()){
					orderline_status.add(n,st.nextToken());
					n++;
				}
				n=0;
				Collections.reverse(orderline_status);
			}
			
			//Added for SKR-SCF-0589[Inc:34387]-End
			SRROnlineReportSet1Bean beanObj		= (SRROnlineReportSet1Bean)getBeanObject(bean_id,bean_name,request);
			beanObj.setLanguageId(locale);
			ArrayList active_DispLabelRecds =	new ArrayList();
			active_DispLabelRecds	 =	beanObj.getDispLabelRecds();
			ecis.utils.OnlineReports onlineReports 		= new ecis.utils.OnlineReports() ;
			ecis.utils.OnlineReport report1	= null;
			String []record=new String[12];
			int counter=0;
			for (int i=1;i<active_DispLabelRecds.size();i++){
				record= (String[])active_DispLabelRecds.get(i);
			 // if(record[1].equals("&nbsp")) record[1]="";
				if(record[1]==null || record[1].equals("&nbsp")) 
					record[1]	= "";
				//report1				= new ecis.utils.OnlineReport( facility,"PH","PHPRDISLBFILL") ;//PHPRDISLBFILL changed to PHRIVCONTFILL for SKR-SCF-0589[Inc:34387] 
				if(record[10]==null || record[10].equals("&nbsp")) 
					record[10]	= "";
				
				//Added for SKR-SCF-0589[Inc:34387]-Start
				if(record[10].equals("1") || record[10].equals("3") || record[10].equals("5")){
					int sl_count=Integer.parseInt(hm.get(disp_no.get(counter)).toString());
					for(int j=1;j<=sl_count;j++){      // For each disp no the below loop will be executed 
					
						disp_stage =orderline_status.get(counter).toString().trim();
							
							if(disp_stage.equals("IP") || disp_stage.equals("AL")){
								if(record[10].equals("1") ){
									rep_id="PHRIVCONTFILL";
								}
								else if (record[10].equals("3")){
									rep_id="PHRIVINTTFILL";
								}
								else if (record[10].equals("5")){
									rep_id="PHRFILLCONWOADD";
								}
							}	
							if(disp_stage.equals("DF") || disp_stage.equals("DP")){
								if(record[10].equals("1") ){
									rep_id="PHRIVCONT";
								}
								else if (record[10].equals("3")){
									rep_id="PHRIVINTT";
								}
							   else if (record[10].equals("5")){
									rep_id="PHRIVCONTWOADD";
							    }
							}
				report1				= new ecis.utils.OnlineReport( facility,"PH",rep_id) ;
				report1.addParameter("p_user_name",login_user) ;
				report1.addParameter("p_language_id",record[9].trim());
				report1.addParameter("p_disp_date",record[0]) ;
				report1.addParameter("p_patient_id",record[3].trim()) ;
				report1.addParameter("p_disp_no",disp_no.get(counter).toString().trim()) ;
				report1.addParameter("p_srl_no",dispdtl_srl_no.get(counter).toString().trim()) ;
				n++;
				report1.addParameter("p_online","N");
				report1.addParameter("p_label_cnt","1");
				report1.addParameter("p_trn_group",record[5].trim());
				report1.addParameter("p_token_dly_seq_no",record[1].trim());
				//report1.addParameter("p_report_id","PHRIVCONTFILL") ;
				report1.addParameter("p_report_id",rep_id.trim()) ; // Added rep_id to handle multiple scenarios - SKR-SCF-0589[Inc:34387]
				report1.addParameter("p_facility_id",facility.trim()) ;
				report1.addParameter("p_patient_class",record[11].trim()) ;
				report1.addParameter("p_module_id","PH") ;
				report1.addParameter("p_mode","PRINT") ;
				counter++;
				onlineReports.add( report1);
			  }
			}
			else{
				report1				= new ecis.utils.OnlineReport( facility,"PH","PHPRDISLBFILL") ;
				report1.addParameter("p_user_name",login_user) ;
				report1.addParameter("p_language_id",record[9].trim());
				report1.addParameter("p_disp_date",record[0]) ;
				report1.addParameter("p_patient_id",record[3]) ;
				//report1.addParameter("p_disp_no",(String)disp_no.get(n)) ;
				//report1.addParameter("p_srl_no",(String)dispdtl_srl_no.get(n)) ;
				//n++;
				report1.addParameter("p_online","N");
				report1.addParameter("p_label_cnt","1");
				report1.addParameter("p_trn_group",record[5].trim());
				report1.addParameter("p_token_dly_seq_no",record[1].trim());
				report1.addParameter("p_report_id","PHPRDISLBFILL") ;
				report1.addParameter("p_facility_id",facility) ;
				report1.addParameter("p_patient_class",record[11].trim()) ;
				report1.addParameter("p_module_id","PH") ;
				report1.addParameter("p_mode","PRINT") ;
				onlineReports.add( report1) ;
				int sl_count=Integer.parseInt(hm.get(disp_no.get(counter)).toString());
				counter+=sl_count;
				//Added for SKR-SCF-0589[Inc:34387]-End
			 }
			}
			
			String ReportOutput = onlineReports.execute( request, response );  
			putObjectInBean(bean_id,beanObj,request);  
		}
		else if(validate.equals("POPULATE_TOKEN_SERIES")){
			String bean_id				= (String) hash.get( "bean_id" );
			String bean_name			= (String) hash.get( "bean_name" );
			String facility_id			= (String) hash.get( "facility_id" );
			SRROnlineReportSet1Bean beanObj		= (SRROnlineReportSet1Bean)getBeanObject(bean_id,bean_name,request);
			beanObj.setLanguageId(locale);
			String disp_locn_code		= (String) hash.get( "disp_locn_code" );
			ArrayList	TokenSerieslist		=	new ArrayList();
			TokenSerieslist		=	beanObj.getTokenSeriesList(facility_id,disp_locn_code);
			out.println("clearList()");
			for(int i=0; i<TokenSerieslist.size(); i+=2) {
			out.println("addList('"+(String)TokenSerieslist.get(i)+"','"+(String)TokenSerieslist.get(i+1)+"');");
			}
			putObjectInBean(bean_id,beanObj,request);
		}
		else if(validate.equals("RECORDS_FOR_PRESCRIPTION")){
	    try{
		String bean_id				= (String) hash.get( "bean_id" );
		String bean_name			= (String) hash.get( "bean_name" );
		SRROnlineReportSet1Bean beanObj		= (SRROnlineReportSet1Bean)getBeanObject(bean_id,bean_name,request);
		beanObj.setLanguageId(locale);
		String prescription_id			= hash.get( "prescription_id" )==null?"":(String) hash.get( "prescription_id" );
		String mode			=	 hash.get( "mode" )==null?"": (String) hash.get( "mode" );
		String order_id="";
		String order_line_no="";

      if (mode.equals("ADD_ELEMENT")){
	    String facility_id			=  hash.get( "facility_id" )==null?"":(String) hash.get( "facility_id" );
		int record_cnt			    = hash.get( "record_cnt" )==null ? 0:Integer.parseInt((String) hash.get( "record_cnt" ));
		String checked_yn			= hash.get( "checked_yn" ) == null?"":(String) hash.get( "checked_yn" ) ;
	if(checked_yn.equals("Y")){

          if(!prescription_id.equals(""))
			{
			   if(prescription_id.indexOf("~") > 0){
				String[] strArr = prescription_id.split("~");
                   order_id =strArr[0];
                   order_line_no =strArr[1];
				   beanObj.setAllSelectedValue(order_id,order_line_no,client_ip_address,login_user,facility);	
			  }
			}

       }

	}else if (mode.equals("ADD_ELEMENT_ALL"))
		{
				
		  if(!prescription_id.equals(""))
			{
			   if(prescription_id.indexOf("@") > 0){
					String[] strArr = prescription_id.split("@");
					for(int i=0;i<strArr.length;i++){
						 if(strArr[i].indexOf("~") > 0){
							String[] strArr1 = strArr[i].split("~");
							order_id =strArr1[0];
							if(strArr1.length >1)
							    order_line_no=strArr1[1];
								beanObj.setAllSelectedValue(order_id,order_line_no,client_ip_address,login_user,facility);	
						 }
					}			   
			   }else{			   
					String[] strArr1 = prescription_id.split("~");
					order_id =strArr1[0];
					if(strArr1.length >1)
					order_line_no=strArr1[1];				
					beanObj.setAllSelectedValue(order_id,order_line_no,client_ip_address,login_user,facility);
			   }
									
			}

             /* Arraylist active_orders=new ArrayList();
			 active_orders= (ArrayList) beanObj.getActiveOrders();
			  for(int i=0;i<active_orders.size();i++){
				  HashMap record	=	(HashMap)	active_orders.get(i);		  	
			      record.put("flag","Y");
			  }*/



		}
		else if(mode.equals("REMOVE_ELEMENT_ALL"))
		{
			

			beanObj.removeValue_pre("ALL");
			
								
		 } else if(mode.equals("REMOVE_ELEMENT"))
		{

			beanObj.removeValue_pre(prescription_id);
						
		} 
	   
				putObjectInBean(bean_id,beanObj,request);
		}catch (Exception e) {
   	out.println("alert(\"" + e + "\");") ;
			}
	
	}else if(validate.equals("RECORDS_FOR_CERTIFREIMBURSEMENT")){

		try{
		String bean_id				= (String) hash.get( "bean_id" );
		String bean_name			= (String) hash.get( "bean_name" );
		String facility_id			=  hash.get( "facility_id" )==null?"":(String) hash.get( "facility_id" );
		int record_cnt			    = hash.get( "record_cnt" )==null ? 0:Integer.parseInt((String) hash.get( "record_cnt" ));
	//	String checked_yn			= hash.get( "checked_yn" ) == null?"":(String) hash.get( "checked_yn" ) ;
		String prescription_id			= hash.get( "prescription_id" )==null?"":(String) hash.get( "prescription_id" );
		String mode			=	 hash.get( "mode" )==null?"": (String) hash.get( "mode" );


		SRROnlineReportSet1Bean beanObj		= (SRROnlineReportSet1Bean)getBeanObject(bean_id,bean_name,request);
		beanObj.setLanguageId(locale);
	

		if (mode.equals("ADD_ELEMENT")){
			beanObj.setSelectedValue(prescription_id);			
			ArrayList active_CertiforReimbursements	=	beanObj.getCertiforReimbursementRecds();
			String []record=new String[9];
			record= (String[])active_CertiforReimbursements.get(record_cnt);
			//record[0]=com.ehis.util.DateUtils.convertDate(record[0],"DMY","en",locale); //commented on 12/8/2010 by sandhya
		}
		else if(mode.equals("REMOVE_ELEMENT")){
			beanObj.removeValue(prescription_id);			
		}
		else if(mode.equals("ADD_ELEMENT_ALL")){
			if(!prescription_id.equals("")){
				if(prescription_id.indexOf("~") > 0){
				String[] strArr = prescription_id.split("~");
				for(int i=0;i<strArr.length;i++){
					beanObj.setSelectedValue(strArr[i]);	
				  }
				}else{
					 beanObj.setSelectedValue(prescription_id);	

				    }
			}
		}else if(mode.equals("REMOVE_ELEMENT_ALL"))
		{
			if(!prescription_id.equals(""))
			{
				if(prescription_id.indexOf("~") > 0){

				String[] strArr = prescription_id.split("~");
				for(int i=0;i<strArr.length;i++){
					beanObj.removeValue(strArr[i]);		
				}									
			  }else{
				  beanObj.removeValue(prescription_id);
			  }
			}

					
		}
     
        putObjectInBean(bean_id,beanObj,request);
		}catch (Exception e) {
	out.println("alert(\"" + e + "\");") ;
	}
	}else if(validate.equals("CLEAR")){

			String bean_id				= (String) hash.get( "bean_id" );
			String bean_name			= (String) hash.get( "bean_name" );			
		    
			if (bean_id.equals("SRRPHDrugUsageByPractBean")){
				SRRPHDrugUsageByPractBean beanObj	= (SRRPHDrugUsageByPractBean)getBeanObject(bean_id,bean_name,request);
				beanObj.setLanguageId(locale);
				beanObj.clear();
				putObjectInBean(bean_id,beanObj,request);
			}
            else{
				SRROnlineReportSet1Bean beanObj		= (SRROnlineReportSet1Bean)getBeanObject(bean_id,bean_name,request);
				beanObj.setLanguageId(locale);
				  beanObj.clear();
				putObjectInBean(bean_id,beanObj,request);
			}
			

	
	}else if(validate.equals("PRINT_FOR_PRESCRIPTION")){
        String bean_id				= (String) hash.get( "bean_id" );
		String bean_name			= (String) hash.get( "bean_name" );
		String facility_id			= (String) hash.get( "facility_id" );
		String order_id			= (String) hash.get( "order_id" );
		String order_type			= (String) hash.get( "order_type" );

        SRROnlineReportSet1Bean beanObj		= (SRROnlineReportSet1Bean)getBeanObject(bean_id,bean_name,request);
		beanObj.setLanguageId(locale);
		ArrayList active_CertiforReimbursements= beanObj.getDrugActiveOrders();
        HashMap selMap = beanObj.getAllSelectedValue();
      	HashMap map = beanObj.insert(selMap);
        beanObj.clear();
	   String report_id="";

	if(order_type==""){
		//if(patient_class == 'IP'||patient_class == 'DC')
	       report_id="PHBOPPRS_IP";
		//else if(patient_class == 'OP'||patient_class == 'EM')
		//	report_id = "PHBOPPRS";
	}
    else if(order_type.equals("1"))
	{
		report_id="PHPRDPRESIVCONT";
	}
    else if(order_type.equals("2"))
	{
		report_id="PHPRDPRESIVCONT";
	}
	else if(order_type.equals("3"))
	{
		report_id="PHPRDPRESIVCONT";
	}
	else if(order_type.equals("4"))
	{
		report_id="PHPRDPRESIVCONT";
	}
	else if(order_type.equals("5"))
	{
		report_id="PHPRDPRESIVCONT";
	}
	else if(order_type.equals("6"))
	{
		report_id="PHPRDPRESCOMP";
	}
	else if(order_type.equals("7"))
	{
		report_id="PHBOPPTPN";
	}
	else if(order_type.equals("8"))
	{
		report_id="PHBOPPTPN";
	}
	else if(order_type.equals("9")){
		report_id="PHBOPPCYTO";
	}
	else if(order_type.equals("0")){
		report_id="PHBOPPCYTO";
	}
	    ecis.utils.OnlineReports onlineReports 		= new ecis.utils.OnlineReports() ;
		ecis.utils.OnlineReport report1				= new ecis.utils.OnlineReport(facility,"PH",report_id) ;
		    
		report1.addParameter("p_Report_id",report_id) ;
		report1.addParameter("P_USER_NAME",login_user) ;
		report1.addParameter("P_FACILITY_ID",facility) ;
		report1.addParameter("p_module_id","PH") ;
		report1.addParameter("p_language_id",locale);
		report1.addParameter("P_TRN_GROUP_REF",order_id) ;
		report1.addParameter("P_ADDED_AT_WS_NO",client_ip_address) ;
		report1.addParameter("p_reprint","Y");
		onlineReports.add(report1) ;
		String ReportOutput = onlineReports.execute(request, response );
		putObjectInBean(bean_id,beanObj,request);

	}
	else if(validate.equals("PRINT")){
		String bean_id				= (String) hash.get( "bean_id" );
		String bean_name			= (String) hash.get( "bean_name" );
		String facility_id			= (String) hash.get( "facility_id" );
        SRROnlineReportSet1Bean beanObj		= (SRROnlineReportSet1Bean)getBeanObject(bean_id,bean_name,request);
		beanObj.setLanguageId(locale);
		ArrayList active_CertiforReimbursements		=	new ArrayList();
		String []record=new String[11];
		active_CertiforReimbursements	=	beanObj.getCertiforReimbursementRecds();
		for(int i=0;i<active_CertiforReimbursements.size();i++){
		record= (String[])active_CertiforReimbursements.get(i);
		String	prescription_id="";
		String	pre_id="";
		String	index="";
		if(record[7].equals("Y")){
		prescription_id=record[5];
		String[] strArr1 = prescription_id.split("#");
		pre_id =strArr1[0];
		index=strArr1[1];
		
        //record[0]=com.ehis.util.DateUtils.convertDate(record[0],"DMY","en",locale); //commented by sandhya on 12/aug/2010 regarding incident num in.spira
       // record[0]=com.ehis.util.DateUtils.convertDate(record[0],"DMY",locale,"en"); 
        if(record[2]==null || record[2].equals("&nbsp")) record[2]	= "";
		ecis.utils.OnlineReports onlineReports 		= new ecis.utils.OnlineReports() ;
		ecis.utils.OnlineReport report1				= new ecis.utils.OnlineReport( facility, "PH","PHCERTREIM") ;
       
		report1.addParameter("p_report_id","PHCERTREIM") ;
		report1.addParameter("p_user_name",login_user) ;
		report1.addParameter("P_FACILITY_ID",facility) ;
		report1.addParameter("p_module_id", "PH") ;
		report1.addParameter("P_LANGUAGE_ID",locale);
		report1.addParameter("P_SEQ_TOKEN_NO",record[2]) ;
		report1.addParameter("P_PATIENT_ID",record[3]) ;
		report1.addParameter("p_reprint","Y");
		report1.addParameter("P_DISP_LOCN_CODE",record[8]);
		report1.addParameter("P_DISP_DATE",com.ehis.util.DateUtils.convertDate(record[0],"DMY",locale,"en")); 
		report1.addParameter("P_TRN_GROUP_REF",pre_id);

		onlineReports.add( report1) ;
		String ReportOutput = onlineReports.execute( request, response );
		  }
		 }
      }
	  else if(validate.equals("FILL_LIST_BY_NURS_UNIT")){

		   
		String nursing_unit_code	= ((String) hash.get( "nursing_unit_code" )).trim();
		String fill_proc_id	        = ((String) hash.get( "fill_proc_id" )).trim();
		//String fill_proc_date	    = ((String) hash.get( "fill_proc_date" )).trim(); Commented by Sandhya for date conversion.regardng incident num:25069 
		String fill_proc_date	    = com.ehis.util.DateUtils.convertDate((String) hash.get( "fill_proc_date" ),"DMYHM","en",locale); ;
		String fill_proc_type		= ((String) hash.get( "fill_proc_type" )).trim();
		
		 String ReportOutput="";
		 ecis.utils.OnlineReports onlineReports		=	null;
		 ecis.utils.OnlineReport report1			=	null;

		onlineReports 		= new ecis.utils.OnlineReports() ;
		report1				= new ecis.utils.OnlineReport( facility, "PH","PHFILLBYNUPAT") ;
		report1.addParameter("p_report_id","PHFILLBYNUPAT") ;
		report1.addParameter("p_user_name",login_user.trim()) ;
		report1.addParameter("p_facility_id",facility.trim()) ;
		//report1.addParameter("P_FILL_PROC_DT",fill_proc_date.trim());
		report1.addParameter("P_FILL_PROC_ID",fill_proc_id.trim()) ;
		report1.addParameter("P_FILL_PROC_TY",fill_proc_type.trim());
		report1.addParameter("p_nurs_unit",nursing_unit_code.trim());
		report1.addParameter("P_LANGUAGE_ID",locale.trim());
		report1.addParameter("p_module_id", "PH") ;
		onlineReports.add( report1) ;

		//String ReportOutput = onlineReports.execute( request, response );
		//report1 = null;
		
		ecis.utils.OnlineReport report2	= new ecis.utils.OnlineReport( facility, "PH","PHFILLBYNUDRUG") ;
		report2.addParameter("p_report_id","PHFILLBYNUDRUG") ;
		report2.addParameter("p_user_name",login_user.trim()) ;
		report2.addParameter("p_facility_id",facility.trim()) ;
		//report2.addParameter("P_FILL_PROC_DT",fill_proc_date.trim());
		report2.addParameter("P_FILL_PROC_ID",fill_proc_id.trim()) ;
		report2.addParameter("P_FILL_PROC_TY",fill_proc_type.trim());
		report2.addParameter("p_nurs_unit",nursing_unit_code.trim());
		report2.addParameter("P_LANGUAGE_ID",locale.trim());
		report2.addParameter("p_module_id", "PH") ;
		onlineReports.add( report2) ;
		ReportOutput = onlineReports.execute( request, response );
					
	}else if(validate.equals("RECORDS_FOR_MEDICATION")){

		try{
		String bean_id				= (String) hash.get( "bean_id" );
		String bean_name			= (String) hash.get( "bean_name" );
		String index			= hash.get( "record_cnt" ) == null?"":(String) hash.get( "record_cnt" ) ;
		String prescription_id			= hash.get( "prescription_id" )==null?"":(String) hash.get( "prescription_id" );
		String mode			=	 hash.get( "mode" )==null?"": (String) hash.get( "mode" );
		SRROnlineReportSet1Bean beanObj		= (SRROnlineReportSet1Bean)getBeanObject(bean_id,bean_name,request);
		beanObj.setLanguageId(locale);
		if (mode.equals("ADD_ELEMENT"))
		{
			beanObj.setSelectedValue_med(prescription_id);			
			//ArrayList active_MedicationListRecds	=	beanObj.getMedicationListRecds();
			//String []record=new String[10];
			//record= (String[])active_MedicationListRecds.get(Integer.parseInt(index));
			//record[0]=com.ehis.util.DateUtils.convertDate(record[0],"DMY","en",locale);
		}else if(mode.equals("REMOVE_ELEMENT"))
		{
			beanObj.removeValue_med(prescription_id);			
		}else if(mode.equals("ADD_ELEMENT_ALL"))
		{
				if(prescription_id.indexOf("~") > 0){
				String[] strArr = prescription_id.split("~");
				for(int i=0;i<strArr.length;i++){
				beanObj.setSelectedValue_med(strArr[i]);
				}
			  }else{
			      beanObj.setSelectedValue_med(prescription_id);			
     			  }
	
		}else if(mode.equals("REMOVE_ELEMENT_ALL"))
		{

				if(prescription_id.indexOf("~") > 0){
				String[] strArr = prescription_id.split("~");
				for(int i=0;i<strArr.length;i++){
				beanObj.removeValue_med(strArr[i]);
				}
		  }else{
		    	beanObj.removeValue_med(prescription_id);			
			   }
			
		}
     
        putObjectInBean(bean_id,beanObj,request);
		}catch (Exception ex) {
	out.println("alert(\"" + ex + "\");") ;
	ex.printStackTrace();

	}
}else if(validate.equals("PRINT_FOR_MEDICATION")){
			    String bean_id				= (String) hash.get( "bean_id" );
		String bean_name			= (String) hash.get( "bean_name" );
		String facility_id			= (String) hash.get( "facility_id" );
        SRROnlineReportSet1Bean beanObj		= (SRROnlineReportSet1Bean)getBeanObject(bean_id,bean_name,request);
		beanObj.setLanguageId(locale);
		ArrayList active_MedicationListRecds		=	new ArrayList();
		String []record=new String[10];
		active_MedicationListRecds	=	beanObj.getMedicationListRecds();
		for(int i=0;i<active_MedicationListRecds.size();i++){
		record= (String[])active_MedicationListRecds.get(i);
		String	prescription_id="";
		String	pre_id="";
		String	index="";
		if(record[9].equals("Y")){
		prescription_id=record[5];
		String[] strArr1 = prescription_id.split("#");
		pre_id =strArr1[0];
		index=strArr1[1];
      //record[0]=com.ehis.util.DateUtils.convertDate(record[0],"DMY",locale,"en"); Commented By sandhya for incident num:25075
		if(record[1]==null || record[1].equals("&nbsp")) record[1]	= "";
		ecis.utils.OnlineReports onlineReports 		= new ecis.utils.OnlineReports() ;
		ecis.utils.OnlineReport report1				= new ecis.utils.OnlineReport( facility, "PH","PHMEDLIST") ;
		report1.addParameter("p_report_id","PHMEDLIST") ;
		report1.addParameter("p_user_name",login_user) ;
		report1.addParameter("P_FACILITY_ID",facility) ;
		report1.addParameter("p_module_id", "PH") ;
		report1.addParameter("P_LANGUAGE_ID",locale);
		report1.addParameter("P_SEQ_TOKEN_NO",record[1]) ;
		report1.addParameter("P_PATIENT_ID",record[3]) ;
		report1.addParameter("P_REPRINT","Y"); 
		//report1.addParameter("P_DISP_LOCN_CODE",record[8]);
		report1.addParameter("P_DISP_DATE",record[0]);
		//report1.addParameter("P_DISP_DATE",record[0]);
		report1.addParameter("P_TRN_GROUP_REF",pre_id);
		
	
		onlineReports.add( report1) ;
		String ReportOutput = onlineReports.execute( request, response );
		out.println("alert('Report Submitted Successfully');");
		}

	   }
	
}else if(validate.equals("RECORDS_FOR_DISPENSESHEET")){

		try{
		String bean_id				= (String) hash.get( "bean_id" );
		String bean_name			= (String) hash.get( "bean_name" );
		String index			= hash.get( "record_cnt" ) == null?"":(String) hash.get( "record_cnt" ) ;
		String prescription_id			= hash.get( "prescription_id" )==null?"":(String) hash.get( "prescription_id" );
		String mode			=	 hash.get( "mode" )==null?"": (String) hash.get( "mode" );
		SRROnlineReportSet1Bean beanObj		= (SRROnlineReportSet1Bean)getBeanObject(bean_id,bean_name,request);
		beanObj.setLanguageId(locale);
		if (mode.equals("ADD_ELEMENT"))
		{
			beanObj.setSelectedValue_disp(prescription_id);		
			
			//ArrayList active_MedicationListRecds	=	beanObj.getMedicationListRecds();
			//String []record=new String[10];
			//record= (String[])active_MedicationListRecds.get(Integer.parseInt(index));
			//record[0]=com.ehis.util.DateUtils.convertDate(record[0],"DMY","en",locale);
		}
		else if(mode.equals("REMOVE_ELEMENT")){
			beanObj.removeValue_disp(prescription_id);			
		}
		else if(mode.equals("ADD_ELEMENT_ALL")){
			if(prescription_id.indexOf("~") > 0){
				String[] strArr = prescription_id.split("~");
				for(int i=0;i<strArr.length;i++){
					beanObj.setSelectedValue_disp(strArr[i]);
				}
			}
			else{
			      beanObj.setSelectedValue_med(prescription_id);			
     		}
		}
		else if(mode.equals("REMOVE_ELEMENT_ALL")){

			if(prescription_id.indexOf("~") > 0){
				String[] strArr = prescription_id.split("~");
				for(int i=0;i<strArr.length;i++){
					beanObj.removeValue_disp(strArr[i]);
				}
		  }
		  else{
		    	beanObj.removeValue_disp(prescription_id);			
		}
	}
    putObjectInBean(bean_id,beanObj,request);
}
catch (Exception ex) {
	out.println("alert(\"" + ex + "\");") ;
	ex.printStackTrace();

	}
}else if(validate.equals("PRINT_FOR_DISPENSESHEET")){
	String bean_id				= (String) hash.get( "bean_id" );
		String bean_name			= (String) hash.get( "bean_name" );
		String facility_id			= (String) hash.get( "facility_id" );
		String p_langue			= (String) hash.get( "p_langue" );
		SRROnlineReportSet1Bean beanObj		= (SRROnlineReportSet1Bean)getBeanObject(bean_id,bean_name,request);
		beanObj.setLanguageId(locale);
		ArrayList active_DispenseSheetListRecds		=	new ArrayList();
		String []record=new String[10];
		active_DispenseSheetListRecds	=	beanObj.getDispenseSheetListRecds();
		
		for(int i=0;i<active_DispenseSheetListRecds.size();i++){
		record= (String[])active_DispenseSheetListRecds.get(i);
		
		
		 String	prescription_id="";
		 String	pre_id="";
		String	index="";
		if(record[9].equals("Y")){
		prescription_id=record[5];
		String[] strArr1 = prescription_id.split("#");
		pre_id =strArr1[0];
		index=strArr1[1];
        //record[0]=com.ehis.util.DateUtils.convertDate(record[0],"DMY",locale,"en");
		if(record[1]==null || record[1].equals("&nbsp")) record[1]	= "";
		ecis.utils.OnlineReports onlineReports 		= new ecis.utils.OnlineReports() ;
		ecis.utils.OnlineReport report1				= new ecis.utils.OnlineReport( facility, "PH","PHPRDISSH") ;
  
		report1.addParameter("p_report_id","PHPRDISSH") ;
		report1.addParameter("p_user_name",login_user) ;
		report1.addParameter("P_FACILITY_ID",facility) ;
		report1.addParameter("p_module_id", "PH") ;
		report1.addParameter("P_LANGUAGE_ID",p_langue);
		report1.addParameter("P_SEQ_TOKEN_NO",record[1]) ;
		report1.addParameter("P_PATIENT_ID",record[3]) ;
		report1.addParameter("P_REPRINT","Y"); 
		report1.addParameter("P_DISP_DATE",com.ehis.util.DateUtils.convertDate(record[0],"DMY",locale,"en"));
		report1.addParameter("P_TRN_GROUP_REF",pre_id);
			
		onlineReports.add( report1) ;
		String ReportOutput = onlineReports.execute( request, response );
		out.println("alert('Report Submitted Successfully');"); //Added Msg for the incident num:25081 on 1/DEc/2010==By Sandhya
		
 		}
	   }
	  }
	 else if (validate.equals("updateList"))
		{
		String bean_id				= (String) hash.get( "bean_id" );
		String bean_name			= (String) hash.get( "bean_name" );
		String index				= request.getParameter("index");
		String checkedValue			= request.getParameter("checkedValue");
		SRRPHDrugUsageByPractBean beanObj	= (SRRPHDrugUsageByPractBean)getBeanObject(bean_id,bean_name,request);
		beanObj.setLanguageId(locale);
		ArrayList searchList = beanObj.getReimbursementList();
		HashMap map= (HashMap)searchList.get(Integer.parseInt(index));
		map.put("check",checkedValue);
		searchList.set(Integer.parseInt(index),map);
		beanObj.setReimbursementList(searchList);

		putObjectInBean(bean_id,beanObj,request);	
		}
		else if(validate.equals("printList")){
			String bean_id				= (String) hash.get( "bean_id" );
			String bean_name			= (String) hash.get( "bean_name" );
			String p_facility_id		= request.getParameter("p_facility_id");
			String p_report_type		= request.getParameter("p_report_type");
			String p_search_by		= request.getParameter("p_search_by");
			String p_report_option		= request.getParameter("p_report_option");
			SRRPHDrugUsageByPractBean beanObj		= (SRRPHDrugUsageByPractBean)getBeanObject(bean_id,bean_name,request);
			beanObj.setLanguageId(locale);
			ArrayList pList=beanObj.getReimbursementList();
			HashMap pMap =null;			
			for(int i=0;i<pList.size();i++){
				pMap =(HashMap)pList.get(i);

				if (pMap.get("check").toString().equals("Y")){
					ecis.utils.OnlineReports onlineReports 		= null;
					ecis.utils.OnlineReport report1			=	null;
					String report_id ="";
					if (p_search_by.equals("B")){
					 report_id				= "PHCERTBILL";
					}
					else{
					 report_id				= "PHCERTREC";
					}	
					onlineReports 		= new ecis.utils.OnlineReports() ;
					report1				= new ecis.utils.OnlineReport( facility, "PH",report_id) ;				
					report1.addParameter("p_report_id",report_id) ;
					report1.addParameter("p_user_name",login_user) ;
					report1.addParameter("p_facility_id",facility) ;
					report1.addParameter("p_module_id", "PH") ;
					report1.addParameter("p_language_id",locale);
					report1.addParameter("p_report_type",p_report_type == "I" ? "IP" : "OP") ; 
					report1.addParameter("p_patient_id",pMap.get("patient_id").toString()) ;
					report1.addParameter("p_bill_doc_type",pMap.get("doctype_code").toString()) ;
					report1.addParameter("p_bill_doc_num",pMap.get("doc_num").toString()) ;					
					report1.addParameter("p_report_option",p_report_option);
					report1.addParameter("p_token_no",pMap.get("token") == null ? "" : pMap.get("token").toString());
					report1.addParameter("p_bill_rec_date",pMap.get("doc_date").toString());
					onlineReports.add( report1) ;
					String ReportOutput = onlineReports.execute( request, response );
					out.println("reload()");

				}
			 }
      }
	}
	catch (Exception e) {
		out.println("alert(\"" + e + "\");") ;
		e.printStackTrace();
	}
%>
