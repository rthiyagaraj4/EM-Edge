
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<!--
--------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------------
?             100            ?           created
17/08/2011    27727          Menaka      Incident No: IN:027727 - <Place OT Order from Thai screen
                                                                  then	goes to Existing Order. Open View Order > Order Format system displays Preferred Surgery Date as 07/06/2554.  After	that click on Amend. Click on Order Format then the system displays Preferred Surgery Date as 07/06/3097.> 
08/09/2011    IN000767      Chowminya G      Incident No: IN000767 - <Orderformat header Screen - radio button validation error> 
3/11/2011    IN029522      Chowminya G      Incident No: IN029522 - <exception on dateutil> 
28/10/2011    IN029395      Chowminya G      Incident No: IN029395 - <system default preferred surgery date issue> 
16/05/2012	 IN031257		Ramesh G		System throws APP SM 0035 Error while trying to place from CA
01/10/2012    IN035189      Dinesh T		Thai Date conversions problem in normal and amend mode
30/11/2012	IN035812		vijayakumar k	After the Preferred Surgery Date is changed, Its not updated in OT Appointment Schedule or Existing Orders
19/09/2013	IN034497		Chowminya		Multi presentation Multi selection alignment issue
23/09/2013  IN043099		Nijitha			CRF-OT-Bru-Hims-CRF-004.2/03-Booking Priority field is not displayed when Surgery type is amended
27/09/2013	  IN043095		Nijitha S		CRF-OT-Bru-HIMS-CRF-004.2/02- Booking Priority field in not displayed for "System defined" order entry format item
04/12/2013	  IN045352		Nijitha S		CRF-OR-Bru-HIMS-CRF-004.3/03-Dependency is not working when option is defaulted 
11/12/2013  IN045512		Nijithas	    The dependent field option is not displayed in View Order Format
12/12/2013  IN045522		Nijithas		Regression-Alpha-OT-Script error when placing multiple OT orders			
15/01/2014	IN045798		Chowminya		The Original alignment of the Order format Items are getting changed in the Order format screen
--------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name			Description
--------------------------------------------------------------------------------------------------------------
21/02/2014    IN000000     Chowminya      Akbar			21/02/2014			Clinical event item link with order format not working for LB n RD(results)	 
18/03/2014	  IN047739     Chowminya							            SS-CRF-20038 - incorrect data while amending an RD Order 
15/04/2014	  IN048553	   Chowminya										Script Error is displaying in order format window 
05/06/2014    IN049124 	   Chowminya										PH-Orderformat - Drug remarks
01/08/2014	  IN049133	   Chowminya										CRF:Disallow user to enter the future date in the LMP date field
19/08/2014    IN050610     Chowminya										CRF Link 2:dependency date validation differed in Order format 
10/10/2016    IN060565     Karthi L                                         ML-MMOH-SCF-0412
30/11/2016	  IN062319	   Karthi L											ML-MMOH-CRF-0508.1 [IN062319]
06/12/2016	  IN062829	   Karthi L									        ML-MMOH-CRF-0508.1 [IN062319]
27/05/2019    IN068553     Ramya Maddena  06/06/2019    Ramesh G    	    GHL-CRF-0554
01/09/2020    IN072275	   Nijitha S	
----------------------------------------------------------------------------------------------------------------------------------------
-->
<%-- JSP Page specific attributes start --%>
<%@page import="eOR.*, java.sql.*, java.util.*,org.json.simple.*, java.text.*,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>


<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<jsp:useBean id="beanQueryObj" scope="page" class="eOR.OrderEntryQueryBean"/>
<%-- Mandatory declarations end --%>
<% 
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");
	String bean_id 		= request.getParameter("bean_id");
	String bean_name 	= request.getParameter("bean_name");
	beanQueryObj.setLanguageId(localeName);
	OrderEntryBean bean	 = (OrderEntryBean)getBeanObject( bean_id, bean_name, request ) ;
	bean.setLanguageId(localeName);
	eOR.Common.OrderEntryRecordBean orderEntryRecordBean 	= (eOR.Common.OrderEntryRecordBean) bean.getOrderEntryRecordBean();
	String chk_mand		= bean.checkForNull(request.getParameter("chk_mand"),"");
 %>

<html>
    <head>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/></link>
 
		<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
        <script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
        <script language="javascript" src="../../eCommon/js/ValidateControl.js" ></script>
		<script language="Javascript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script language="javascript" src="../../eCommon/js/dchk.js"></script>
		<script language="javascript" src="../../eOR/js/OrderEntry1.js" ></script>
		<script language="javascript" src="../../eOR/js/OrderEntryPreview.js" ></script>
		<script language="JavaScript" src="../../eOR/js/OrderEntrySearch.js"></script>
		<script language="JavaScript" src="../../eOR/js/OrderEntryCalendar.js"></script>
		<script language="JavaScript" src="../../eOR/js/OrCommon.js"></script>
		<script language="JavaScript" src="../../eOR/js/OrderEntryDecisionSupport.js"></script>
		<script language="JavaScript" src="../../eOR/js/OrderEntryToolTip.js"></script>
		<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<title><fmt:message key="eOR.OrderFormat.label" bundle="${or_labels}"/></title>
		
    </head>
    <body  onUnload="removeAll()" onMouseDown="CodeArrest()" onKeyDown="lockKey()" <%if(chk_mand.equals("RECORD"))  { %> onLoad="ClickClose()"<% }%>>
    <form name="OrderFormatForm" id="OrderFormatForm" method="post">
	<input type="hidden" name="localName" id="localName" value="<%=locale %>"/>  <!-- IN031257 -->
    <table border='0' cellpadding='3' cellspacing='0' width='100%' align='center'>
    <tr><td>
	<%
        String close_yn				= "N";
        ArrayList arrSeqNo			= new ArrayList(); 
		ArrayList	OrderFormatTypes= new ArrayList();
		StringBuffer  sbTemplate	= new StringBuffer("");
        Hashtable template			= null;
        try
        {
			Properties properties	= (Properties) session.getValue( "jdbc" ); 
        	String format_id 		     = bean.checkForNull(request.getParameter("format_id"),"");
	    	String catalog_code 	     = bean.checkForNull(request.getParameter("catalog_code"),"");
	    	String order_category	     = bean.checkForNull(request.getParameter("order_category"),"");
            String row_value		     = bean.checkForNull(request.getParameter("row_value"),"");
            String order_id			     = bean.checkForNull(request.getParameter("order_id"),"");
            String called_from		     = bean.checkForNull(request.getParameter("called_from"),"");
            String order_line_num	     = bean.checkForNull(request.getParameter("order_line_num"),"");
            String priority			     = bean.checkForNull(request.getParameter("priority"),"R");
            String contr_msr_panel_id    = bean.checkForNull(request.getParameter("contr_msr_panel_id"),"");
			String contr_msr_mod_id      = bean.checkForNull(request.getParameter("contr_msr_mod_id"),"");
			String care_set_catalog_code = bean.checkForNull(request.getParameter("care_set_catalog_code"),"");
			String sex				     = bean.checkForNull(request.getParameter("sex"),"");
			String dob				     = bean.checkForNull(request.getParameter("dob"),"");
			if(sex.equals(""))
				sex					     = bean.checkForNull(bean.getSex(),"");
			if(dob.equals(""))
				dob					     = bean.checkForNull(bean.getDob(),"");
            String current_record	     = row_value;
			String multi_last_record     = "";
			String p_catalog_code	     = bean.checkForNull(request.getParameter("p_catalog_code"),"");
			String p_form_code		     = bean.checkForNull(request.getParameter("p_form_code"),"");
			String p_route_code		     = bean.checkForNull(request.getParameter("p_route_code"),"");
			//String order_format_onload		     = bean.checkForNull(request.getParameter("order_format_onload"),"");//IN045512

			if(catalog_code==null)catalog_code=p_catalog_code;
			String patient_id		= bean.getPatientId();
          	boolean exists			= false;
			if(!called_from.equals("PH"))
			{
				//if(!format_id.equals("")) order_id = "";  //Commented for IN072275
			}
 
            String field_mnemonic	= "";
            int seq_num				= 0, max_dependency_row = 0 , new_seq_num = 0;
			int old_seq_num			= 0;
			String old_field_mnemonic="";
             //String label_text		= "";   String accept_option	= "";
     	    //String dflt_value		= "";	String field_type		= "";
			//String min_num_value	= "";	String max_num_value	= "";
			String mode				= "";
			//String field_values	= "";String sql 				= "";
			String order_type_code	= ""; //order_type_short_desc = "";
			String ind_catalog_code	= "", ind_row_value			= "";
			String specimen_def_yn	= "N";// clinical_events = "";
			int 	count			= 0;

			Hashtable new_template			= null;
			String performing_facility_id	= "";
			String login_facility_id		= bean.getLoginFacilityId();
			String lab_install_yn				="N"; //bean.checkForNull(bean.getFacilityModuleInstallYn("RL"),"N");
			String labmodule="";
			String bt_install_yn="";
			String ot_install_yn="";
			String rd_install_yn="";
			if(order_category.equalsIgnoreCase("LB"))
			{
				if(bt_install_yn.equals(""))
				{
					bt_install_yn				= bean.checkForNull(bean.getFacilityModuleInstallYn("BT"),"N");
				}
			}
			else if(order_category.equalsIgnoreCase("OT"))
			{
				 if(ot_install_yn.equals(""))
				{
					ot_install_yn				= bean.checkForNull(bean.getFacilityModuleInstallYn("OT"),"N");
				}
			}
			else if(order_category.equalsIgnoreCase("RD"))
			{
				if(rd_install_yn.equals(""))
				{
					rd_install_yn				= bean.checkForNull(bean.getFacilityModuleInstallYn("RD"),"N");
				}
			}
			ArrayList OrderFormatList			=	null;	
			
			String[] order_type_records = null;String[] records = null;
			String called_from_fn		= bean.getCalledFromFunction();//IN045798
			String max_list_seq[] = null;//IN047739   
			String max_seq ="";//IN047739
			// Get the bean values stored(OrderTypes and OrderCatalogs)
			String key				= (bean.getPatientId()+bean.getEncounterId());  // Unique key to keep the Value in the Bean
   			HashMap previousValues = (HashMap)orderEntryRecordBean.getCheckedEntries(key);
   			String order_types_comb = "";
  			if(called_from.equals("ORDER_SET_HEADER"))
   				order_types_comb 	= bean.checkForNull(bean.getCareSetOrderTypes(care_set_catalog_code),"");  // Order Types Combination for the order_category
   			else
   				order_types_comb 	= bean.checkForNull(bean.getOrderTypes(previousValues),"");  // Order Types Combination for the order_category
       		 /* Order_id will come as "" when comes from Line or Hdr Level, except in Amend Fn.(Hdr)
   			   called_from will be "HEADER" when comes from Header, Amend_Dtl when comes from line in amend function,
   			   or when it comes from OrderSet (Header) it will be ORDER_SET_HEADER, or when called from the Preview Header, it will be PREVIEW_HEADER
   			 */
   			if( (!called_from.equals("")) && (called_from.equals("PREVIEW_HEADER") || called_from.equals("HEADER") ||  called_from.equals("ORDER_SET_HEADER")) )   // Only for the Order Entry Header Level
			{
				// If it is an Amend Order
				if(bean.getAmendOrder().equalsIgnoreCase("existing_order"))
					order_types_comb	= "'"+bean.checkForNull(bean.getAmendOrderType(),"")+"'";
				OrderFormatTypes		= bean.getOrderTypeFormatID(order_category,order_types_comb);
  				if(OrderFormatTypes!=null && OrderFormatTypes.size() != 0 && !called_from.equals("ORDER_SET_HEADER"))
				{
					orderEntryRecordBean.setOrderFormats("ORDER_TYPE"+order_category, "0",OrderFormatTypes);
				}
				else
				{
					orderEntryRecordBean.setOrderFormats("ORDER_TYPE_CARE_SET"+order_category, "0",OrderFormatTypes);
				}
			}
			else OrderFormatTypes.add("0"); // To execute the loop only once for the Line Level
 
			// To store the values in the Bean, If it is an Header, the order_type_code will be used to retrieve the value
			// row_value is always "0"
			// code will be always "ORDER_TYPE"+order_category
			// Set the value in the bean
           	for(count=0;count<OrderFormatTypes.size();count++)
			{
				ind_catalog_code			= "";
				if((!called_from.equals("")) && ( called_from.equals("PREVIEW_HEADER") || called_from.equals("HEADER") || called_from.equals("ORDER_SET_HEADER")) )  // Only for the Order Entry Header Level //changed to solve  #IN014399 by Uma  on  9/15/2009- inclued  called_from.equals("PREVIEW_HEADER") ||
				{
					order_type_records		= (String[])OrderFormatTypes.get(count);
					format_id				= order_type_records[0];
					order_type_code			= order_type_records[1];
					
 					if(order_type_code!=null && order_type_code.equals("ALL"))
						order_type_code		= "";
					//order_type_short_desc	= order_type_records[2];
					if(!called_from.equals("ORDER_SET_HEADER"))
					{
						ind_catalog_code	= order_type_code+catalog_code; // For other Header Orders
					}
					else
					{
						ind_catalog_code	= "ORDER_SET"+order_type_code+catalog_code; // For Care Set Orders
					}
				}
				else
				{
					order_type_code			= "";
					//order_type_short_desc	= "";
					ind_row_value			= "";
					ind_catalog_code		= catalog_code;
				}
				ind_row_value				= (ind_catalog_code+"_"+row_value);
				
		    	arrSeqNo					= (ArrayList)	orderEntryRecordBean.getOrderFormats(ind_catalog_code, ind_row_value);
				

				ArrayList OrderFormat=new ArrayList();	
 	        	if(arrSeqNo==null || arrSeqNo.size()==0) // If it is already there in the bean
            	{
            		arrSeqNo				=	new ArrayList();
					
					if(called_from.equals("PH"))
					{
						if(order_category.equals(""))
							order_category			= called_from;
						
						OrderFormat 	= bean.getOrderFormat("",order_category,order_id,called_from,order_line_num,priority,sex,dob,login_facility_id,p_catalog_code,"",patient_id);
						
						if(OrderFormat.size()==0)
						{	
							OrderFormat 	= bean.getOrderFormat(format_id,order_category,"",called_from,order_line_num,priority,sex,dob,login_facility_id,p_catalog_code,"",patient_id);
						}
					}
					else
					{
						OrderFormat 	= bean.getOrderFormat(format_id,order_category,order_id,called_from,order_line_num,priority,sex,dob,login_facility_id,catalog_code,order_type_code,patient_id);
					}
                	for(int k=0; k<OrderFormat.size(); k++)
					{
							records			= (String[])OrderFormat.get(k);
   			    	  		seq_num 		= (Integer.parseInt(bean.checkForNull(records[1],"0"))); // seq_num will start with 0
 							if(old_seq_num!=0 && seq_num==old_seq_num ) {	//used for Amend Orders
  								new_seq_num--;		// reduce the new_seq_num
								arrSeqNo.remove( String.valueOf(new_seq_num));		//remove the arraylist
								//field_mnemonic	 = old_field_mnemonic;//IN043099
							}
							else 
								field_mnemonic	 = bean.checkForNull(records[0],"0");

    						template		= beanQueryObj.buildHashTable(properties, new_seq_num, bean.getPatientId(), order_id, format_id, order_type_code, "" , field_mnemonic,  records); //amend_order_id will be the order_id and order_type_short_desc will be null
    						//IN050610 - Start			
 							if(old_seq_num!=0 && seq_num==old_seq_num ) 
 							{
 								template.put("oth_dependency_yn", bean.checkForNull(records[11],"N"));
 								template.put("dependency_yn","N");
 							}
 							//IN050610 - End
							/*orderEntryRecordBean.setOrderFormats(ind_catalog_code, (ind_catalog_code+new_seq_num),template);
						  
 							arrSeqNo.add( String.valueOf(new_seq_num));// new Integer(new_seq_num));
 							new_seq_num++;*/ //increment the seq_num
        	    	  		/*template		= new Hashtable();
							template.put("field_mnemonic",bean.checkForNull(records[0],""));
							template.put("seq_num", String.valueOf(seq_num)); //new Integer(seq_num)
							template.put("label_text",bean.checkForNull(records[2],""));
							template.put("accept_option",bean.checkForNull(records[3],""));
							//template.put("dflt_value",bean.checkForNull(records[4],""));
							template.put("field_type",bean.checkForNull(records[5],""));
							template.put("min_num_value",bean.checkForNull(records[6],""));
							template.put("max_num_value",bean.checkForNull(records[7],""));
							//template.put("order_type_code",order_type_code);
							//template.put("order_type_short_desc",order_type_short_desc);
							template.put("help_text",bean.checkForNull(records[9],""));
							template.put("discr_msr_id",bean.checkForNull(records[10],""));

                           clinical_events = "";
                            if ((bean.checkForNull(records[5],"")).equals("V")) {
                                clinical_events = bean.getClinicalEvents(properties,bean.checkForNull(records[10],""));
                                if (clinical_events.length() > 50)
                                    clinical_events = clinical_events.substring(0,50);
                                template.put("dflt_value",bean.checkForNull(clinical_events,""));
                            } else {
                                template.put("dflt_value",bean.checkForNull(records[4],""));
                            }

							orderEntryRecordBean.setOrderFormats(ind_catalog_code, (ind_catalog_code+seq_num),template);
							arrSeqNo.add(String.valueOf(seq_num)); //new Integer(seq_num)
							*/
							//Changed Code for IN047739 - Start
							if(!order_id.equals("") && bean.checkForNull((String)template.get("single_or_multi"),"").equals("M") &&  bean.checkForNull((String)template.get("field_type"),"").equals("C")) { // From Amend Order, call a method which will set and return if any
								 checkReplaceAmend(bean, orderEntryRecordBean, ind_catalog_code ,ind_row_value,  field_mnemonic, template);

							} else {    // For Orders and even for Amend without multi values
									orderEntryRecordBean.setOrderFormats(ind_catalog_code, (ind_catalog_code+new_seq_num),template);
	 								arrSeqNo.add( String.valueOf(new_seq_num));// new Integer(new_seq_num));
									new_seq_num++; //increment the seq_num
	 								exists = true;
									mode   = "INSERT";
									specimen_def_yn = "Y" ; // To default the specimen if the Lab is installed and first time...
	 							}
							//IN047739 - End	
							/*if(!order_id.equals(""))
							{
								template.put("field_values"	,bean.checkForNull(records[8],""));	  
							}
							*/
							//IN045798 - start included if else condition to handle amend order screen for multi select comp
							 ArrayList seq_data					= new ArrayList();
							 //IN047739 - Start - modified
							 String flgg = "Y";
							 if(new_seq_num > (Integer.parseInt(bean.checkForNull(max_seq,"0")))){
									//seq_data = beanQueryObj.getMaxlistseq(order_id,field_mnemonic);//IN049124
									seq_data = beanQueryObj.getMaxlistseqH(order_id,field_mnemonic);//IN049124
									max_list_seq = (String[])seq_data.get(0);
									if(max_list_seq[0].equals("1")){ 
										max_seq = max_list_seq[1];
										flgg = "N";}}	
							//null handled when called from OP	IN048553				
							if(called_from_fn== null || !called_from_fn.equals("AMEND_ORDER") || flgg.equals("Y")){
							if(bean.checkForNull(records[12],"S").equals("M") && bean.checkForNull(records[5],"").equals("L")) 
							{
							// Query population used in the list item.
							
								labmodule=bean.checkForNull((String)bean.getmoduleRL(catalog_code,order_category,order_type_code,login_facility_id),"");
								if(labmodule.equalsIgnoreCase("IBARL"))
								{
									lab_install_yn="Y";
								}
								else
								{
									lab_install_yn="N";
								}
								
 								OrderFormatList = beanQueryObj.getOrderFormatList(properties, order_category,field_mnemonic,contr_msr_panel_id,contr_msr_mod_id,order_type_code,bean.checkForNull((String)template.get("discr_msr_id"),""),performing_facility_id,login_facility_id,sex, lab_install_yn, bt_install_yn, rd_install_yn, ot_install_yn,catalog_code);
   								for(int l=0;l<OrderFormatList.size();l++)
								{
									String[] records1			= (String[])OrderFormatList.get(l);
 									if(l==OrderFormatList.size()-1) // that means it is a last record
									{
										multi_last_record = "Y";
										// Last record (for grouping multi select)
									}
									else
									{ 
										multi_last_record = "N";
										// Not a last record (for grouping multi select)
									}
									new_template    = beanQueryObj.buildMultiHashTable( new_seq_num,records[0], records1[1], multi_last_record, template);
				
									
									
										orderEntryRecordBean.setOrderFormats(ind_catalog_code, 	(ind_catalog_code+new_seq_num),new_template);
									
									arrSeqNo.add( String.valueOf(new_seq_num));// new Integer(new_seq_num));
									new_seq_num++;  
								}
   								
 							} // End of Multi Select
							}else{
								if(bean.checkForNull(records[12],"S").equals("M") && (bean.checkForNull(records[5],"").equals("L")||bean.checkForNull(records[5],"").equals("C")) && flgg.equals("N")) 
								{	
									/*if(new_seq_num > (Integer.parseInt(bean.checkForNull(max_list_seq,"0")))){
										max_list_seq = beanQueryObj.getMaxlistseq(field_mnemonic);}*/
									if(String.valueOf(new_seq_num).equals(max_list_seq))
									{
										multi_last_record = "Y";
										template.put("dflt_value"	, bean.checkForNull(multi_last_record+"@@"+records[5],"")+"@@"+records[0]);
									}
									
								}
							}
							//IN047739 - modified end
							//IN045798 - end
  							// TO PAINT THE ROWS, depending upon the 
 							if(bean.checkForNull(records[11],"N").equals("Y")) 
							{
								//max_dependency_row = beanQueryObj.getSeqNo(properties, format_id ,seq_num, bean.checkForNull(records[0],"N")); //format_id ,seq_num,field_mnemonic
								if(template!=null)
								{
 									max_dependency_row	= Integer.parseInt(bean.checkForNull((String) template.get("max_dependency_row"),"0"));
   									field_mnemonic		= bean.checkForNull((String) template.get("field_mnemonic"),"");
 								}
							} // End of records[11] //dependency_yn
							else 
								max_dependency_row	= 0;
 							for(int t=0;t<max_dependency_row;t++)
							{
		
								template		 = beanQueryObj.buildDummyHashTable(seq_num,order_type_code, "", field_mnemonic );
							
								
								orderEntryRecordBean.setOrderFormats(ind_catalog_code, (ind_catalog_code+new_seq_num),template);
								
								arrSeqNo.add(String.valueOf(new_seq_num));//new Integer(new_seq_num));
								old_seq_num		   = seq_num;//IN043099
 								new_seq_num++;
 							} // End of for seq_num

							//old_seq_num		   = seq_num;		// Used in Amend Order, to put the parent_field_mnemonic//IN043099
							old_field_mnemonic = field_mnemonic;
							 
							if(exists)
		    				{
				    		
								
								orderEntryRecordBean.setOrderFormats(ind_catalog_code,ind_row_value,arrSeqNo);
								
				    		}
 		      		} // End of k
					OrderFormat = null; // nullifying the object after use
			}  // End of if arrSeqNo
		} //End of  for count



 		   //	}
	    	//else
	    	//{
			//	exists		= true;
			//	close_yn 	= "Y";
	    	//	mode		= "EXISTS";
	    	//}
	    //} // End of count
	    	//if(exists)
	    	//{
	    	   try
				{
					//sbTemplate	=	buildTemplate(bean,orderEntryRecordBean,beanQueryObj, out, request,  session,OrderFormatTypes,specimen_def_yn,pageContext,localeName); // ML-MMOH-CRF-0508.1 [IN062319] 
					sbTemplate	=	buildTemplate(bean,orderEntryRecordBean,beanQueryObj, out, request,  session,OrderFormatTypes,specimen_def_yn,pageContext,localeName, bean_id, bean_name); //  ML-MMOH-CRF-0508.1 [IN062319] 
					//Call the Bean Method passing the Necessary parametes to build the template
					//sbTemplate  =  buildTemplate(format_id,catalog_code,row_value,order_category);
					if(sbTemplate!=null){
						out.println(sbTemplate.toString());
						
					}
				}
				catch(Exception e)
				{
					//out.println("Exception From the Buffer: "+e);//COMMON-ICN-0181
					e.printStackTrace();//COMMON-ICN-0181

				}
	    	//}
			previousValues = null; //nullifying the object 
	  %>
  	    </td></tr></table>
  	    <input type="hidden" name="format_id" id="format_id" value="<%=format_id%>">
  	    <input type="hidden" name="catalog_code" id="catalog_code" value="<%=catalog_code%>">
  	    <input type="hidden" name="order_category" id="order_category" value="<%=order_category%>">
  	    <input type="hidden" name="row_value" id="row_value" value="<%=current_record%>">
  	    <input type="hidden" name="patient_id" id="patient_id" value="<%=bean.getPatientId()%>">
  	    
  	    <input type="hidden" name="p_catalog_code" id="p_catalog_code" value="<%=p_catalog_code%>">
  	    <input type="hidden" name="p_form_code" id="p_form_code" value="<%=p_form_code%>">
  	    <input type="hidden" name="p_route_code" id="p_route_code" value="<%=p_route_code%>">
  	    <input type="hidden" name="called_from" id="called_from" value="<%=called_from%>">
  	    <input type="hidden" name="order_id" id="order_id" value="<%=order_id%>">

  	    <input type="hidden" name="contr_msr_panel_id" id="contr_msr_panel_id" value="<%=contr_msr_panel_id%>">
		<input type="hidden" name="contr_msr_mod_id" id="contr_msr_mod_id" value="<%=contr_msr_mod_id%>">
  	    <input type="hidden" name="mode" id="mode" value="<%=mode%>">
  	    <input type="hidden" name="mandatory_check" id="mandatory_check" value="N">
  	    <input type="hidden" name="close_yn" id="close_yn" value="<%=close_yn%>">
  	    <input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
  	    <input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
		<input type="hidden" name="localeName" id="localeName" value="<%=localeName%>">
		<!--<input type="hidden" name="order_format_onload" id="order_format_onload" value=""> IN045512 -->
		<input type="hidden" name="frm_unld_multichk_yn" id="frm_unld_multichk_yn" value="Y"> <!-- ML-MMOH-CRF-0208.1 -->


  	</form>
    </body>
</html>
					<!-- IN045352 Starts 
					<script>
		
						var count = document.OrderFormatForm.count.value;//IN045522				
						var formObj= document.OrderFormatForm;//IN045522
						if(document.OrderFormatForm.order_format_onload.value=="Y")
						{//IN045512
						
							for(var n =0;n<count;n++)//IN045522
							{//IN045522
								if(null!=eval("formObj.validationClause_new"+n))
								{
									//IN045522 Starts
									var validationClause_new =  eval("formObj.validationClause_new"+n+".value");
									var name_key_new =  eval("formObj.name_key_new"+n+".value");	
									eval("checkDependency(document.OrderFormatForm."+name_key_new+","+validationClause_new+")");
									//IN045522 Ends
								}
								
								
							}//IN045522
							document.OrderFormatForm.order_format_onload.value="N";
						}
						
					</script>
					 IN045352 Ends -->
<%
     } catch(Exception e){
     		out.println("Exception :- Order"+e.toString());
			e.printStackTrace();
     } finally{
		 //Nullifying the objects
		 arrSeqNo			= null;  template			= null;	 OrderFormatTypes	= null;
		 sbTemplate.setLength(0);
	 }
%>
<%!
//private java.lang.StringBuffer buildTemplate(eOR.OrderEntryBean bean,eOR.Common.OrderEntryRecordBean orderEntryRecordBean, eOR.OrderEntryQueryBean beanQueryObj, javax.servlet.jsp.JspWriter out, HttpServletRequest request,HttpSession session, ArrayList OrderFormatTypes, String specimen_def_yn,PageContext pageContext,String localeName) throws Exception	  
private java.lang.StringBuffer buildTemplate(eOR.OrderEntryBean bean,eOR.Common.OrderEntryRecordBean orderEntryRecordBean, eOR.OrderEntryQueryBean beanQueryObj, javax.servlet.jsp.JspWriter out, HttpServletRequest request,HttpSession session, ArrayList OrderFormatTypes, String specimen_def_yn,PageContext pageContext,String localeName, String bean_id, String bean_name) throws Exception
	{
		Properties properties			= (Properties) session.getValue( "jdbc" ); //Properties to be passed to the bean to get the connection if using the query bean and not the functional bean
	
		StringBuffer	sbTemplate		= new StringBuffer();
		Hashtable		template		= new Hashtable();
		ArrayList		arrSeqNo		= new ArrayList();
		
 		String 			format_id 		= bean.checkForNull(request.getParameter("format_id"),"");
		String 			catalog_code 	= bean.checkForNull(request.getParameter("catalog_code"),"");
		String 			row_value		= bean.checkForNull(request.getParameter("row_value"),"");
		String		order_category		= bean.checkForNull(request.getParameter("order_category"),"");
		String 		contr_msr_panel_id	= bean.checkForNull(request.getParameter("contr_msr_panel_id"),"");
		String      contr_msr_mod_id	= bean.checkForNull(request.getParameter("contr_msr_mod_id"),"");
		//String 		ph_list_vals		= bean.checkForNull(request.getParameter("ph_list_vals"),"");
		String p_catalog_code			= bean.checkForNull(request.getParameter("p_catalog_code"),"");
		String p_form_code				= bean.checkForNull(request.getParameter("p_form_code"),"");
		String p_route_code				= bean.checkForNull(request.getParameter("p_route_code"),"");
		//ArrayList orderFormatList;
		String 		called_from			= bean.checkForNull(request.getParameter("called_from"),"");
		//String 		order_id			= bean.checkForNull(request.getParameter("order_id"),"");
		String		sys_date			= bean.checkForNull(request.getParameter("sys_date"),"");
		String performing_facility_id	= bean.checkForNull(request.getParameter("performing_facility_id"),"");
		//String order_date_time	= bean.checkForNull(request.getParameter("order_date_time"),"");
		String patient_id				= bean.getPatientId();
		String login_facility_id		= bean.getLoginFacilityId();
		String sex						= bean.getSex();
		String dob						= bean.getDob();
		String sys_date_time			= sys_date;
		String p_function_from		 	= bean.checkForNull(request.getParameter("function_from"),""); // ML-MMOH-CRF-0508.1
	
		//String validationClause_new="";//IN045352
		//IN068553 Starts 
			String encounter_id = bean.getEncounterId();
			String mobile_num = "";
		//IN068553 Ends
		if(!sys_date.equals("")) // remove the time
					sys_date			= sys_date.substring(0,10);

		String ot_sys_date				= "";
		String temp_field_mnemonic = ""; //IN034497
		if(order_category.equals("OT")){
						//ot_sys_date		= beanQueryObj.getNextSysDate(properties); //Commented --[IN029395]
						ot_sys_date		= beanQueryObj.getSurgDate(properties); //Added --[IN029395]
						//IN035189, starts
						if(!localeName.equals("en"))
							ot_sys_date=com.ehis.util.DateUtils.convertDate(ot_sys_date,"DMY","en",localeName);
						//IN035189, ends
						}
						
							
		int 		seq_num				= 0, new_seq_num	    = 0;
		int			max_dependency_row	= 0;
		String 		field_mnemonic		= "",  old_field_mnemonic	= "";
		String 		accept_option		= "",  dflt_value 			= "",dflt_value_oth_desc="";
		String 		field_type			= "",  min_num_value 		= "";
		String 		max_num_value		= "",  label_text 			= "";
		String      check_box_multi_val = "", multi_last_record = "N";
		String      help_text           = "",  discr_msr_id			= "";
		int			max_allowed_length	= 0,   row_count			= 0;
		int 		display_length		= 0;
		int		tr=0;
		String 		display_only_prop	= "";
		String 		disabled_prop		= "",disabled_prop_oth_desc="",checked_oth="",style_oth="";
		String 		readOnlyClause		= "";
		String 		mandatory_gif		= "";
		String 		mandatory_fields	= "";
		String 		transplant_fields  	= "";
		//StringBuffer mandatory_fields= new StringBuffer();
		String 		mandatory_names 	= "";
		//StringBuffer mandatory_names= new StringBuffer();
		//String 		list_item_fields	= "";
		StringBuffer list_item_fields= new StringBuffer();
		String 		validationClause	= "";
		//int 		num_digit_dec		= 2;
		String 		field_validation	= "";//checked				= "",
		//String		field_mnemonic_fields= "";
		StringBuffer  field_mnemonic_fields=new StringBuffer();
		StringBuffer	lb_install_fields=new StringBuffer();

		String      label_text_value	= "";
		//StringBuffer label_text_value = new StringBuffer();
		String 		field_values		= "", 	ind_catalog_code	= "",field_values_oth_desc="";
		String		order_type_code		= "", 	old_order_type_code	= "";
		String 		order_type_short_desc = "", ind_row_value		= "";
		String 		lab_install_yn		= "N", bt_install_yn		= "N";
		String		ot_install_yn		= "N", rd_install_yn		= "N";

		String		dateText			= "" , class_value			= "LABEL";
		String		dependency_yn       = "",  parent_field_mnemonic= "";
		String      field_action_msg	= "",  field_mnemonic_action="" ,field_value_type="";
		String      name_key			= "",  display_dependency   = "",single_or_multi="";
		int group_field_mnemonic_count	= 0;
 		String default_value  = "";//IN045798
		// For Pharmacy Related
		StringTokenizer stPhListVals	= null;
		//String 		ph_list_val			= "";
		//String 		ph_list_desc 		= "";
		String[] order_type_records = null;String[] records = null;
		String labmodule="",dynamic_diag_button="",discr_msr_uom="";
		String display_transplant = "";
		int transplant_pat_yn_exists =0;
		String transplant_checked = "";
		String oth_dependency_yn = "N";//IN049133
		String ord_formt_multi_chk_nonmandate_yn = bean.getMultiSelectListItemMandatYN();// ML-MMOH-CRF-0508.1 [IN062319] 
		ArrayList multiListCompList = null; // ML-MMOH-CRF-0508.1 [IN062319] 
		ArrayList completeMultiCheckCompList = null; // ML-MMOH-CRF-0508.1 [IN062319] 
		Map multiListCompMap = null; // ML-MMOH-CRF-0508.1 [IN062319] 
		Map selMultiSelectedMap = new HashMap(); // ML-MMOH-CRF-0508.1 [IN062319] 
		List selecteCompList = new ArrayList();	// ML-MMOH-CRF-0508.1 [IN062319] 	
		String amd_ord_dflt_value = "";	 // ML-MMOH-CRF-0508.1 [IN062319] 				
                String onKeyPressNumberValidate = "";//IN068553
		String onBlurNumberValidate = "";//IN068553
		String onpaste = "";//IN068553
		
		// Till Here
		try
		{
 			// Check If Lab is installed or not.
			//  If Order Category LB, check for Lab Install
			if(order_category.equals("LB"))
			{
				bt_install_yn   = bean.checkForNull(bean.getFacilityModuleInstallYn("BT"),"N");
			}
			else if(order_category.equals("OT"))
			{// If Order Category OT, Check for OT Install
				
					ot_install_yn	= bean.checkForNull(bean.getFacilityModuleInstallYn("OT"),"N");
			}
			else if(order_category.equals("RD"))
			{// If Order Category OT, Check for OT Install
				rd_install_yn	= bean.checkForNull(bean.getFacilityModuleInstallYn("RD"),"N");
			}
			int count = 0;
			if("Y".equals(ord_formt_multi_chk_nonmandate_yn)){ // ML-MMOH-CRF-0508.1 [IN062319]  - Start
					multiListCompMap = new HashMap(); 
					completeMultiCheckCompList = new ArrayList(); 
			}	// ML-MMOH-CRF-0508.1 [IN062319]  End
			for(count=0; count<OrderFormatTypes.size(); count++) // only used to get the order_type
			{
				ind_catalog_code			= "";
				sbTemplate.append("<table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\" align=\"CENTER\">");
				sbTemplate.append("<tr><td class=\"LABEL\"   width=\"20%\" colspan=\"6\">&nbsp;</td></tr><tr>");
				if( (!called_from.equals("")) && (called_from.equals("PREVIEW_HEADER") || called_from.equals("HEADER") ||  called_from.equals("ORDER_SET_HEADER")) )  // Only for the Order Entry Header Level //changed to solve  #IN014399 by Uma  on  9/15/2009- inclued  called_from.equals("PREVIEW_HEADER") ||
				{
					order_type_records = (String[])OrderFormatTypes.get(count);
					format_id				= order_type_records[0];
					order_type_code			= order_type_records[1];
					if(order_type_code!=null && order_type_code.equals("ALL"))
						order_type_code		= "";
					order_type_short_desc	= order_type_records[2];
					if(!called_from.equals("ORDER_SET_HEADER"))
						ind_catalog_code		= order_type_code+catalog_code; // For other Header Orders
					else
						ind_catalog_code		= "ORDER_SET"+order_type_code+catalog_code; // For Care Set Orders
				}
				else
				{
					order_type_code			= "";
					order_type_short_desc	= "";
					ind_row_value			= "";
					ind_catalog_code		= catalog_code;
				}
				
				labmodule=bean.checkForNull((String)bean.getmoduleRL(catalog_code,order_category,order_type_code,login_facility_id),"");
				if(labmodule.equalsIgnoreCase("IBARL"))
				{
					lab_install_yn="Y";
				}
				else
				{
					lab_install_yn="N";
				}
					
				try
				{
					ind_row_value			=	(ind_catalog_code+"_"+row_value);
					
					arrSeqNo				=	(ArrayList) orderEntryRecordBean.getOrderFormats(ind_catalog_code, ind_row_value);
					

				}
				catch(Exception e)
				{
					//out.println("Exception Prop : "+e);//COMMON-ICN-0181
					e.printStackTrace();//COMMON-ICN-0181
				}
				if(arrSeqNo!=null && arrSeqNo.size() > 0)
				{
					 for(int i=0;i<arrSeqNo.size();i++)	// Main Loop
					 {
						new_seq_num				=  Integer.parseInt((String)arrSeqNo.get(i));
						dateText				= "";
					    try
					    {							
							template			=	(Hashtable) orderEntryRecordBean.getOrderFormats (ind_catalog_code, (ind_catalog_code+new_seq_num) );		 								
					    }
					    catch(Exception e)
					    {
					  		//out.println("Exception when getting seq_no : "+e);//COMMON-ICN-0181
					  		e.printStackTrace();//COMMON-ICN-0181
					    }
					    try
					    {
							field_mnemonic		=  bean.checkForNull((String) template.get("field_mnemonic"),"");
							discr_msr_uom		= bean.checkForNull((String)template.get("discr_msr_uom"),"");
							old_field_mnemonic	= bean.checkForNull(field_mnemonic,"");
							seq_num				= Integer.parseInt(bean.checkForNull((String) template.get("seq_num"),"0"));
 							label_text			= bean.checkForNull((String) template.get("label_text"),"");
							accept_option		= bean.checkForNull((String) template.get("accept_option"),"");
							dflt_value			= bean.checkForNull((String) template.get("dflt_value"),"").trim();
							field_type			= bean.checkForNull((String) template.get("field_type"),"");
							min_num_value		= bean.checkForNull((String) template.get("min_num_value"),"");
							max_num_value		= bean.checkForNull((String) template.get("max_num_value"),"");
							//order_type_code	= bean.checkForNull((String) template.get("order_type_code")); // Header_level
							//order_type_short_desc= bean.checkForNull((String) template.get("order_type_short_desc")); // Header_level
							help_text           = bean.checkForNull((String) template.get("help_text"));
							discr_msr_id        = bean.checkForNull((String) template.get("discr_msr_id"));
				
							dependency_yn       = bean.checkForNull((String) template.get("dependency_yn"));
 							max_dependency_row	= Integer.parseInt(bean.checkForNull((String) template.get("max_dependency_row"),"0"));
							parent_field_mnemonic=bean.checkForNull((String) template.get("parent_field_mnemonic"));
							field_action_msg	 = bean.checkForNull((String) template.get("field_action_msg"));
							field_mnemonic_action= bean.checkForNull((String) template.get("field_mnemonic_action"));
  							
							field_value_type			 = bean.checkForNull((String) template.get("field_value_type"));
							single_or_multi			 = bean.checkForNull((String) template.get("single_or_multi"));
							default_value 		= bean.checkForNull((String) template.get("default_value"));//IN045798
							oth_dependency_yn = bean.checkForNull((String) template.get("oth_dependency_yn"),"N");//IN049133

							if(field_mnemonic.equals("")) {
									display_dependency = "display:none";
							} else
									display_dependency = "display:";
							
							// To make mandatory or not if lab is installed and for specimen type
							//if(order_category.equals("LB") && field_mnemonic.equals("SPECIMEN_TYPE") && //lab_install_yn.equalsIgnoreCase("Y") && !called_from.equalsIgnoreCase("Amend_Dtl"))
							//{
													//accept_option   = bean.getSpecimenMandYn(catalog_code);
							//}
							if(order_category.equals("LB") && field_mnemonic.equals("BLOOD_PRODUCT_PROCESS") && lab_install_yn.equalsIgnoreCase("Y"))
							{
								String BloodProductProcessYn = (String)beanQueryObj.getBloodProductProcessYn(properties, catalog_code);
								if(BloodProductProcessYn.equalsIgnoreCase("N"))
								{
									accept_option   =  "D";
								}
							}
							dynamic_diag_button	= "";
					    }
					    catch(Exception e)
					    {
						     //out.println("Exception when getting other values : "+e);//COMMON-ICN-0181
							 e.printStackTrace();
					    }
						
						// If it is already there put the respective values
						field_values			= "";
						field_values							= bean.checkForNull((String) template.get("field_values"));
						field_values_oth_desc			= bean.checkForNull((String) template.get("field_values_oth_desc"));
						if(field_mnemonic.equalsIgnoreCase("REQUEST_COMMENT_DESC")&&order_category.equalsIgnoreCase("LB")&&labmodule.equalsIgnoreCase("IBARL") &&field_type.equals("L"))
    					{
								//field_mnemonic="REQUEST_COMMENT";
							if(field_values_oth_desc.equals("null")||field_values_oth_desc.equals(" "))
								field_values_oth_desc="";
							if(field_values_oth_desc.equals(""))
							{
								field_values_oth_desc=field_values;
								field_values="";
							}
						}
						//IN045798 included default_value condition
						if(single_or_multi.equals("M") && ((dflt_value.indexOf("@@")!=-1) || (!default_value.equals("")))) 
						{  // When nothing is there in the bean
							//IN045798 - Start
							if((default_value.indexOf("@@")!=-1))
								dflt_value 			= default_value; 
							else if ((dflt_value.indexOf("@@")!=-1))
								default_value = dflt_value;
							//IN045798 - End	
							multi_last_record		= bean.checkForNull(dflt_value.substring(0, 	dflt_value.indexOf("@@")),"");
							check_box_multi_val		= bean.checkForNull(dflt_value.substring(dflt_value.lastIndexOf("@@")+2, dflt_value.length()),""); //remove the @@ and take the value
							dflt_value				= bean.checkForNull(dflt_value.substring(dflt_value.indexOf("@@")+2, dflt_value.lastIndexOf("@@")),"");   
   						}	
						else  
						{
							check_box_multi_val		= "";
							multi_last_record		= "N";
						}
						
						//27727 Modified Starts
						if(field_type.equalsIgnoreCase("D"))
						{
							//IN035189, starts
							if(field_values!=null)
							{
								if(!(field_values.equals("")))
								{
									field_values = com.ehis.util.DateUtils.convertDate(field_values,"DMY","en",localeName);	
								}
							}
							//IN035189, ends
							if(!(dflt_value.trim().equals("")))//--[IN029395]
							{
								if(!localeName.equals("en")) 
								{//IN035189
									dflt_value = com.ehis.util.DateUtils.convertDate(dflt_value,"DMY","en",localeName);	
								}
							}						
						}
						if(field_type.equalsIgnoreCase("E"))
						{
							//IN035189, starts
							if(field_values!=null)
							{
								if(!(field_values.equals("")))
								{
									field_values = com.ehis.util.DateUtils.convertDate(field_values,"DMYHM","en",localeName);	
								}
							}
							//IN035189, ends
							if(!(dflt_value.trim().equals("")))//--[IN029395]
							{
								if(!localeName.equals("en"))
								{//Dinesh T on 10/1/2012
									dflt_value = com.ehis.util.DateUtils.convertDate(dflt_value,"DMYHM","en",localeName);	
								}
							}
						}
						//27727 Modified End
						
						if(field_values==null || field_values.equals(""))
						   field_values			= "";
						else
						   dflt_value 			= field_values;
						
						if( "Y".equals(ord_formt_multi_chk_nonmandate_yn) && field_type.equals("C") && single_or_multi.equals("M") && "R".equals(accept_option)) {
						
							if(("AMEND_ORDER".equalsIgnoreCase(p_function_from) || "COPY_ORDER".equalsIgnoreCase(p_function_from)) && !"".equals(dflt_value)) {
								amd_ord_dflt_value = dflt_value;
							}			
							dflt_value = "";		
						}
						if(field_values_oth_desc==null || field_values_oth_desc.equals("null")||field_values_oth_desc.equals(" "))
						   field_values_oth_desc			= "";
						else
						   dflt_value_oth_desc 			= field_values_oth_desc;
						
						name_key				= (parent_field_mnemonic+"ORDERFORMAT"+order_type_code+new_seq_num);
   						//sbTemplate.append("field_values"+field_values+"dflt_value"+dflt_value);		 // Paint the Page here
						if(accept_option.equals("D"))
						{
							display_only_prop	= "readOnly";
							disabled_prop		= "disabled";
							readOnlyClause		= "class=\"READONLY\" ";
							class_value			= "ORDISABLED";  // Color for the disabled items
						}
						else
						{
							display_only_prop	= "";
							disabled_prop		= "";
							readOnlyClause		= "";
							class_value			= "LABEL";
						}
						if(!dflt_value_oth_desc.equals(""))
						{
							disabled_prop_oth_desc="disabled";
							checked_oth					="checked";
							style_oth							="visibility:visible:width:250px";
						}
						else
						{
							checked_oth="";
							style_oth							="visibility:hidden;width:0px";
							if(disabled_prop.equals("disabled"))
							{
								disabled_prop_oth_desc="disabled";
							}
							else
							{
								disabled_prop_oth_desc="";
							}
						 }
						/*if(order_category.equals("LB"))
						{
						Commented by Uma on 9/24/2009 for MF-CRF-0115*/
							
							if(field_mnemonic.equals("PATIENT_DIAGNOSIS"))
							{
							
								dynamic_diag_button = "<input type=\"button\" class=\"button\" name =\"PATIENT_DIAG_BTN"+name_key+"\" "+disabled_prop+" value=\"?\" onClick=\"return showDiagnosis('"+(name_key)+"' ,this, 'PATIENT_DIAGNOSIS');\">";

							}
						/*}Commented by Uma on 9/24/2009 for MF-CRF-0115*/
						if(accept_option.equals("R"))
						{
							//mandatory_fields	+= field_mnemonic+"ORDERFORMAT"+order_type_code+seq_num+"§";
							mandatory_fields=mandatory_fields+name_key+"#";
								//mandatory_fields.append(name_key+"#");
							mandatory_names	= mandatory_names+label_text+"#";
							//mandatory_names.append(label_text+"#");
							mandatory_gif		=  "<img src='../../eCommon/images/mandatory.gif'></img>";
						}
						else
						{
							mandatory_gif		= "";
						}

                        /*if (field_type.equalsIgnoreCase("V")) {
                            display_only_prop	= "readOnly";
							disabled_prop		= "disabled";
							readOnlyClause		= "class=\"READONLY\" ";
                        }
						*/

						// This variable is used to keep tab of the field_mnemonic and to copy the same value..
 						field_mnemonic		= field_mnemonic.replace('\'',  '|'); //Replace '' with |


  						if( field_type.equalsIgnoreCase("D") )
						{
							max_allowed_length	= 10;
							display_length		= 10;
							if(order_category.equals("OT") && ot_install_yn.equals("Y") &&  (old_field_mnemonic.equals("PREF_SURG_DATE") || old_field_mnemonic.equals("ADMISSION_DATE")))
							{
								// For this PRE_OP_DAYS,calculate (subtract ) the day entered with the pref_surg_date
								validationClause	= "onBlur = \"callCheckDate(this,'"+field_mnemonic+"','"+(name_key)+"',document.OrderFormatForm.sys_date); copySameMnemonic(this,'"+field_mnemonic+"',"+new_seq_num+");calculatePreOpDays(this,'"+(field_mnemonic+"ORDERFORMAT"+order_type_code)+"','"+old_field_mnemonic+"'); checkDependency(this,'"+format_id+"','"+field_mnemonic+"',"+new_seq_num+", "+seq_num+", "+max_dependency_row+", '"+dependency_yn+"' ,'"+order_category+"', '"+contr_msr_panel_id+"','"+contr_msr_mod_id+"' ,'"+order_type_code+"' ,'"+discr_msr_id+"' ,'"+performing_facility_id+"' ,'','"+specimen_def_yn+"','"+login_facility_id+"','"+sex+"','"+catalog_code+"','"+oth_dependency_yn+"');  \" "; //included oth_dependency_yn IN049133
							}
							else 
							{
								validationClause	= "onBlur = \"callCheckDate(this,'"+field_mnemonic+"','"+(name_key)+"',document.OrderFormatForm.sys_date); copySameMnemonic(this,'"+field_mnemonic+"',"+new_seq_num+"); checkDependency(this,'"+format_id+"','"+field_mnemonic+"',"+new_seq_num+", "+seq_num+", "+max_dependency_row+", '"+dependency_yn+"' ,'"+order_category+"', '"+contr_msr_panel_id+"','"+contr_msr_mod_id+"' ,'"+order_type_code+"' ,'"+discr_msr_id+"' ,'"+performing_facility_id+"' ,'','"+specimen_def_yn+"','"+login_facility_id+"','"+sex+"','"+catalog_code+"','"+oth_dependency_yn+"');  \" ";//included oth_dependency_yn IN049133
							}
							//if(order_category.equals("OT") && ot_install_yn.equals("Y") && old_field_mnemonic.equals("PREF_SURG_DATE")) // for this pref_surg_date, and if OT Module is installed and OT Category, then display the Calender with Appts.
							//	dateText			= " <input type=\"image\" src=\"../../eCommon/images/CommonCalendar.gif\"  onClick=\"return showOTCalendar('"+(name_key)+"','"+(field_mnemonic+"ORDERFORMAT"+order_type_code)+"','"+performing_facility_id+"','"+patient_id+"');\">";
							//else
							//IN035812 starts
							//if(order_category.equals("OT"))  
							//{ // then default the date with one day additionally.

								//if(dflt_value.trim().equals(""))//IN035189
								//	dflt_value	= ot_sys_date;	
							//}
							
							if(order_category.equals("OT") && (field_values==null || field_values.equals("")) && (ot_sys_date!=null || !ot_sys_date.equals("")))  
							{ // then default the date with one day additionally.

								//if(dflt_value.trim().equals(""))//IN035189
									dflt_value	= ot_sys_date;	
							}
							else if(order_category.equals("OT") && (field_values !=null || !(field_values.equals(""))))
							{
							dflt_value = field_values;
							}
							//IN035812 ends
							//dateText			= " <input type=\"image\" src=\"../../eCommon/images/CommonCalendar.gif\"  onClick=\"return showCalendar('"+(name_key)+"');\">";
							dateText			= " <img  src=\"../../eCommon/images/CommonCalendar.gif\"  onClick=\""+(name_key)+".focus();return showCalendar('"+(name_key)+"',null,null,true);\">";
							//validationClause	= "onBlur = \"return CheckDate(this)\" ";
						}
						else if( field_type.equalsIgnoreCase("T") )
						{
							max_allowed_length	= 5;
							display_length		= 5;
							validationClause	= "onBlur = \"callCheckTime(this); copySameMnemonic(this,'"+field_mnemonic+"',"+new_seq_num+"); checkDependency(this,'"+format_id+"','"+field_mnemonic+"',"+new_seq_num+", "+seq_num+", "+max_dependency_row+", '"+dependency_yn+"' ,'"+order_category+"', '"+contr_msr_panel_id+"','"+contr_msr_mod_id+"' ,'"+order_type_code+"' ,'"+discr_msr_id+"' ,'"+performing_facility_id+"' ,'','"+specimen_def_yn+"','"+login_facility_id+"','"+sex+"','"+catalog_code+"','"+oth_dependency_yn+"'); \" ";//included oth_dependency_yn IN049133
							//validationClause	= "onBlur = \"return callCheckTime(this)\" ";
						}
						else if( field_type.equalsIgnoreCase("E") )
						{
							max_allowed_length	= 16;
							display_length		= 16;
							if((order_category.equals("LB"))&&(field_mnemonic.equals("BLOOD_TRANS_EXP_DATE"))&&(labmodule.equalsIgnoreCase("IBARL")))
							{
								validationClause	= "onBlur = \"callCheckDateTime(this); copySameMnemonic(this,'"+field_mnemonic+"',"+new_seq_num+"); checkDependency(this,'"+format_id+"','"+field_mnemonic+"',"+new_seq_num+", "+seq_num+", "+max_dependency_row+", '"+dependency_yn+"' ,'"+order_category+"', '"+contr_msr_panel_id+"','"+contr_msr_mod_id+"' ,'"+order_type_code+"' ,'"+discr_msr_id+"' ,'"+performing_facility_id+"' ,'','"+specimen_def_yn+"','"+login_facility_id+"','"+sex+"','"+catalog_code+"','"+oth_dependency_yn+"');checkingbtspec(this,'"+field_mnemonic+"',document.OrderFormatForm.order_date_time,'"+localeName+"') \" ";//included oth_dependency_yn IN049133
							}
							else if((order_category.equals("LB"))&&(field_mnemonic.equals("TRANSPLANT_DATE"))&&(labmodule.equalsIgnoreCase("IBARL")))
							{
								validationClause	= "onBlur = \"callCheckDateTime(this); copySameMnemonic(this,'"+field_mnemonic+"',"+new_seq_num+"); checkDependency(this,'"+format_id+"','"+field_mnemonic+"',"+new_seq_num+", "+seq_num+", "+max_dependency_row+", '"+dependency_yn+"' ,'"+order_category+"', '"+contr_msr_panel_id+"','"+contr_msr_mod_id+"' ,'"+order_type_code+"' ,'"+discr_msr_id+"' ,'"+performing_facility_id+"' ,'','"+specimen_def_yn+"','"+login_facility_id+"','"+sex+"','"+catalog_code+"','"+oth_dependency_yn+"');validateTransplantDate(this,'"+localeName+"'); \" ";//included oth_dependency_yn IN049133
							}
							else
							{
								validationClause	= "onBlur = \"callCheckDateTime(this); copySameMnemonic(this,'"+field_mnemonic+"',"+new_seq_num+"); checkDependency(this,'"+format_id+"','"+field_mnemonic+"',"+new_seq_num+", "+seq_num+", "+max_dependency_row+", '"+dependency_yn+"' ,'"+order_category+"', '"+contr_msr_panel_id+"','"+contr_msr_mod_id+"' ,'"+order_type_code+"' ,'"+discr_msr_id+"' ,'"+performing_facility_id+"' ,'','"+specimen_def_yn+"','"+login_facility_id+"','"+sex+"','"+catalog_code+"','"+oth_dependency_yn+"'); \" ";//included oth_dependency_yn IN049133
							}
								dateText			= " <img src=\"../../eCommon/images/CommonCalendar.gif\"  onClick=\"return showCalendar('"+(name_key)+"',null,'hh:mm');\">";
							//validationClause	= "onBlur = \"return callCheckDateTime(this)\" ";
						}
						else if( field_type.equalsIgnoreCase("I") )
						{
							//max_allowed_length	= 6;
							int maxDigit = 20;
							int  minDigit = -1;
							int noDec = -1;
							String minVal = "";
							String maxVal = "";
							

							Map<String, String>  discreetMesaure = bean.getDiscreetMeasure(field_mnemonic, patient_id,sex,dob);					
							if(discreetMesaure != null)
							{
								maxDigit = discreetMesaure.get("NUM_DIGITS_MAX")==null?20:Integer.parseInt(discreetMesaure.get("NUM_DIGITS_MAX"));
								minDigit = discreetMesaure.get("NUM_DIGITS_MIN")==null?-1:Integer.parseInt(discreetMesaure.get("NUM_DIGITS_MIN"));
								noDec = discreetMesaure.get("NUM_DIGITS_DEC")==null?-1:Integer.parseInt(discreetMesaure.get("NUM_DIGITS_DEC"));
								minVal = (discreetMesaure.get("MIN_VALUE")== null?"-1":discreetMesaure.get("MIN_VALUE")) ;
								maxVal = discreetMesaure.get("MAX_VALUE")==null?"-1":discreetMesaure.get("MAX_VALUE");
								//dflt_value1 = discreetMesaure.get("DLFT_VALUE")==null?"":discreetMesaure.get("DLFT_VALUE");

							}
							
							
							max_allowed_length	= maxDigit;
							int dlftLen = dflt_value.length();
							if(dlftLen > maxDigit)
							{
								dflt_value = "";
							}
							
							max_allowed_length	= maxDigit;
							//IN068553 Starts
							if(field_mnemonic.equals("ATTPRAMOBILENO")){	
							display_length		= 10;
							
							}else{
								display_length		= 6;
							}
							//IN068553 Ends
						
						if(order_category.equals("OT") && ot_install_yn.equals("Y") && old_field_mnemonic.equals("PRE_OP_DAYS"))  // For this PRE_OP_DAYS,calculate (subtract ) the day entered with the pref_surg_date
								//validationClause= "onBlur = \"checkValidRange(this); calculateAdmissionDate(this,'"+(field_mnemonic+"ORDERFORMAT"+order_type_code)+"',document.OrderFormatForm.sys_date);copySameMnemonic(this,'"+field_mnemonic+"',"+new_seq_num+",'"+field_mnemonic+"'); checkDependency(this,'"+format_id+"','"+field_mnemonic+"',"+new_seq_num+", "+seq_num+", "+max_dependency_row+", '"+dependency_yn+"' ,'"+order_category+"', '"+contr_msr_panel_id+"','"+contr_msr_mod_id+"' ,'"+order_type_code+"' ,'"+discr_msr_id+"' ,'"+performing_facility_id+"' ,'','"+specimen_def_yn+"','"+login_facility_id+"','"+sex+"','"+catalog_code+"'); \" onKeyPress=\"return allowValidNumber(this,event,"+max_allowed_length+",0)\"";
								
								
								validationClause= " onBlur = \"checkValidRange(this); calculateAdmissionDate(this,'"+(field_mnemonic+"ORDERFORMAT"+order_type_code)+"',document.OrderFormatForm.sys_date);copySameMnemonic(this,'"+field_mnemonic+"',"+new_seq_num+",'"+field_mnemonic+"'); checkDependency(this,'"+format_id+"','"+field_mnemonic+"',"+new_seq_num+", "+seq_num+", "+max_dependency_row+", '"+dependency_yn+"' ,'"+order_category+"', '"+contr_msr_panel_id+"','"+contr_msr_mod_id+"' ,'"+order_type_code+"' ,'"+discr_msr_id+"' ,'"+performing_facility_id+"' ,'','"+specimen_def_yn+"','"+login_facility_id+"','"+sex+"','"+catalog_code+"','"+oth_dependency_yn+"'); validateDiscreetMeasure(this,'"+maxVal+"','"+minVal+"','"+noDec+"','"+max_allowed_length+"','"+minDigit+"','"+label_text+"'); \" onKeyPress=\"return allowNumbers(this,event,'"+max_allowed_length+"','"+noDec+"')\"";//included oth_dependency_yn IN049133
						 else
							//	validationClause= "onBlur = \"checkValidRange(this); copySameMnemonic(this,'"+field_mnemonic+"',"+new_seq_num+"); checkDependency(this,'"+format_id+"','"+field_mnemonic+"',"+new_seq_num+", "+seq_num+", "+max_dependency_row+", '"+dependency_yn+"' ,'"+order_category+"', '"+contr_msr_panel_id+"','"+contr_msr_mod_id+"' ,'"+order_type_code+"' ,'"+discr_msr_id+"' ,'"+performing_facility_id+"' ,'','"+specimen_def_yn+"','"+login_facility_id+"','"+sex+"','"+catalog_code+"'); \" onKeyPress=\"return allowValidNumber(this,event,"+max_allowed_length+",0)\"";
								validationClause= " onBlur = \"checkValidRange(this); copySameMnemonic(this,'"+field_mnemonic+"',"+new_seq_num+"); checkDependency(this,'"+format_id+"','"+field_mnemonic+"',"+new_seq_num+", "+seq_num+", "+max_dependency_row+", '"+dependency_yn+"' ,'"+order_category+"', '"+contr_msr_panel_id+"','"+contr_msr_mod_id+"' ,'"+order_type_code+"' ,'"+discr_msr_id+"' ,'"+performing_facility_id+"' ,'','"+specimen_def_yn+"','"+login_facility_id+"','"+sex+"','"+catalog_code+"','"+oth_dependency_yn+"');validateDiscreetMeasure(this,'"+maxVal+"','"+minVal+"','"+noDec+"','"+max_allowed_length+"','"+minDigit+"','"+label_text+"'); \" onKeyPress=\"return allowNumbers(this,event,'"+max_allowed_length+"','"+noDec+"')\"";//included oth_dependency_yn IN049133
						}
						else if( field_type.equalsIgnoreCase("N") )
						{
							//max_allowed_length	= 10;
								int maxDigit = 20;
								int  minDigit = -1;
								int noDec = -1;
								String minVal = "";
								String maxVal = "";
								

								Map<String, String>  discreetMesaure = bean.getDiscreetMeasure(field_mnemonic, patient_id,sex,dob);					
								if(discreetMesaure != null)
								{
									maxDigit = discreetMesaure.get("NUM_DIGITS_MAX")==null?20:Integer.parseInt(discreetMesaure.get("NUM_DIGITS_MAX"));
									minDigit = discreetMesaure.get("NUM_DIGITS_MIN")==null?-1:Integer.parseInt(discreetMesaure.get("NUM_DIGITS_MIN"));
									noDec = discreetMesaure.get("NUM_DIGITS_DEC")==null?-1:Integer.parseInt(discreetMesaure.get("NUM_DIGITS_DEC"));
									minVal = (discreetMesaure.get("MIN_VALUE")== null?"-1":discreetMesaure.get("MIN_VALUE")) ;
									maxVal = discreetMesaure.get("MAX_VALUE")==null?"-1":discreetMesaure.get("MAX_VALUE");
									//dflt_value1 = discreetMesaure.get("DLFT_VALUE")==null?"":discreetMesaure.get("DLFT_VALUE");
								}								
								
							max_allowed_length	= maxDigit;	
							int dlftLen = dflt_value.length();
							/*if((dflt_value==null)|(dflt_value.equals("null"))) dflt_value =""; else dflt_value=dflt_value.trim();
							if(dflt_value.equals(""))
							{
								dflt_value = dflt_value1;
							}*/
							if(dlftLen > maxDigit)
							{
								dflt_value = "";
							}
							
							max_allowed_length	= maxDigit;
							display_length		= 10;
							//validationClause	= "onBlur = \"checkValidRange(this); copySameMnemonic(this,'"+field_mnemonic+"',"+new_seq_num+"); checkDependency(this,'"+format_id+"','"+field_mnemonic+"',"+new_seq_num+", "+seq_num+", "+max_dependency_row+", '"+dependency_yn+"' ,'"+order_category+"', '"+contr_msr_panel_id+"','"+contr_msr_mod_id+"' ,'"+order_type_code+"' ,'"+discr_msr_id+"' ,'"+performing_facility_id+"' ,'','"+specimen_def_yn+"','"+login_facility_id+"','"+sex+"','"+catalog_code+"'); \" onKeyPress=\"return allowValidNumber(this,event,"+(max_allowed_length - num_digit_dec)+","+num_digit_dec+")\"";
							validationClause	= "onBlur = \"checkValidRange(this); copySameMnemonic(this,'"+field_mnemonic+"',"+new_seq_num+"); checkDependency(this,'"+format_id+"','"+field_mnemonic+"',"+new_seq_num+", "+seq_num+", "+max_dependency_row+", '"+dependency_yn+"' ,'"+order_category+"', '"+contr_msr_panel_id+"','"+contr_msr_mod_id+"' ,'"+order_type_code+"' ,'"+discr_msr_id+"' ,'"+performing_facility_id+"' ,'','"+specimen_def_yn+"','"+login_facility_id+"','"+sex+"','"+catalog_code+"','"+oth_dependency_yn+"'); validateDiscreetMeasure(this,'"+maxVal+"','"+minVal+"','"+noDec+"','"+max_allowed_length+"','"+minDigit+"','"+label_text+"'); \" onKeyPress=\"return allowNumbers(this,event,'"+max_allowed_length+"','"+noDec+"')\"";//included oth_dependency_yn IN049133
							//validationClause	= " onBlur = \"return checkValidRange(this)\" onKeyPress=\"return allowValidNumber(this,event,"+(max_allowed_length - num_digit_dec)+","+num_digit_dec+")\" ";
							//max_allowed_length++;
						}
						else  if( field_type.equalsIgnoreCase("V") )
						{
							validationClause	= " onBlur = \"makeValidString( this ); copySameMnemonic(this,'"+field_mnemonic+"',"+new_seq_num+"); checkDependency(this,'"+format_id+"','"+field_mnemonic+"',"+new_seq_num+", "+seq_num+", "+max_dependency_row+", '"+dependency_yn+"' ,'"+order_category+"', '"+contr_msr_panel_id+"','"+contr_msr_mod_id+"' ,'"+order_type_code+"' ,'"+discr_msr_id+"' ,'"+performing_facility_id+"' ,'','"+specimen_def_yn+"','"+login_facility_id+"','"+sex+"','"+catalog_code+"','"+oth_dependency_yn+"'); \"  ";//included oth_dependency_yn IN049133
							display_length		= 50;
							max_allowed_length	= 100;
						}
						else if(field_type.equalsIgnoreCase("R")){ // For Radio Button
 								validationClause	= "onClick = \"setRadioValue(this, '"+name_key+"');  checkDependency(document.OrderFormatForm."+name_key+",'"+format_id+"','"+field_mnemonic+"',"+new_seq_num+", "+seq_num+", "+max_dependency_row+", '"+dependency_yn+"' ,'"+order_category+"', '"+contr_msr_panel_id+"','"+contr_msr_mod_id+"' ,'"+order_type_code+"' ,'"+discr_msr_id+"' ,'"+performing_facility_id+"' ,'','"+specimen_def_yn+"','"+login_facility_id+"','"+sex+"','"+catalog_code+"','"+oth_dependency_yn+"');\"";//included oth_dependency_yn IN049133
						}
						else
						{
							validationClause	= " onBlur = \"makeValidString( this ); copySameMnemonic(this,'"+field_mnemonic+"',"+new_seq_num+"); checkDependency(this,'"+format_id+"','"+field_mnemonic+"',"+new_seq_num+", "+seq_num+", "+max_dependency_row+", '"+dependency_yn+"' ,'"+order_category+"', '"+contr_msr_panel_id+"','"+contr_msr_mod_id+"' ,'"+order_type_code+"' ,'"+discr_msr_id+"' ,'"+performing_facility_id+"' ,'','"+specimen_def_yn+"','"+login_facility_id+"','"+sex+"','"+catalog_code+"','"+oth_dependency_yn+"'); \"  ";//included oth_dependency_yn IN049133
							display_length		= 40;
							max_allowed_length	= 100;
						}

 					   // Painting starts here
					   // If order_type is there, print the order_type as heading
						if(!order_type_code.equals("") && !order_type_code.equals(old_order_type_code))
						{
							sbTemplate.append("<th  width=\"20%\" colspan=\"6\">"+order_type_short_desc+"</th></tr>");
							sbTemplate.append("<tr><td class=\"LABEL\"   width=\"20%\" colspan=\"6\">&nbsp;</td></tr><tr>");
						
						} // End of order_type
						old_order_type_code		= order_type_code;

						if(group_field_mnemonic_count==0 && single_or_multi.equals("M") && field_type.equals("L")){  // Presentation Multi and CheckBox
									//group_field_mnemonic_count++; //Commentted IN034497
									//More than 1, then paint heading
								if(!(temp_field_mnemonic).equals(field_mnemonic)) {
									if("Y".equals(ord_formt_multi_chk_nonmandate_yn) && "R".equals(accept_option)){ // ML-MMOH-CRF-0508.1 [IN062319] - Start
										multiListCompList = new ArrayList();
										mandatory_gif		=  "<img src='../../eCommon/images/mandatory.gif'></img>"; // added by LK
										sbTemplate.append("<tr><td class=\"EMERGENT\"   width=\"15%\" colspan=\"6\">"+label_text+" &nbsp;"+ mandatory_gif +" </td></tr><tr><td class=\"LABEL\"  width=\"15%\" colspan=\"6\">&nbsp;</td></tr><tr>");
									} else { // ML-MMOH-CRF-0508.1 [IN062319] - End
										sbTemplate.append("<tr><td class=\"EMERGENT\"   width=\"15%\" colspan=\"6\">"+label_text+"</td></tr><tr><td class=\"LABEL\"  width=\"15%\" colspan=\"6\">&nbsp;</td></tr><tr>");
									}	 // ML-MMOH-CRF-0508.1 [IN062319] 
								}	
								temp_field_mnemonic = field_mnemonic;//IN034497
  						tr=1;
						}  
						if((field_mnemonic.equalsIgnoreCase("REQUEST_COMMENT")||field_mnemonic.equalsIgnoreCase("REQUEST_COMMENT_DESC"))&&order_category.equalsIgnoreCase("LB")&&labmodule.equalsIgnoreCase("IBARL")&&field_type.equals("L"))
						{
								sbTemplate.append("</tr><tr><td class=\"LABEL\"  width=\"15%\" colspan=\"6\">&nbsp;</td></tr>");
			    				sbTemplate.append("<tr>");
								//num_request_comment++;
						}
						if (field_mnemonic.equals("PERFORM_PRACT_ID")) {
						  String sql = OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_FORMAT_PRACT_LOOKUP");
						  int index = sql.indexOf("?");
						  sql = (sql.substring(0,index)) + "'"+performing_facility_id+"'"+(sql.substring(index+1, sql.length()));
						  display_length		= 40;
						  sbTemplate.append("<td id=\"New_"+name_key+"_0\" style=\""+display_dependency+"\" class=\""+class_value+"\"  nowrap width=\"15%\" title=\""+help_text+"\" valign='top'>&nbsp;"+label_text+"&nbsp;</td>"); //IN000000
    					  sbTemplate.append("<td id=\"New_"+name_key+"_1\" style=\""+display_dependency+"\" class=\"LABEL\"   width=\"20%\" title=\""+help_text+"\" nowrap>");
						  // Added by Siva
						  sbTemplate.append("<input type=\"text\" name=\""+(name_key)+"_desc\"   "+disabled_prop+" id=\""+(name_key)+"_desc\"   "+disabled_prop+" value='' size='"+display_length+"'>"+mandatory_gif+"<input type=\"hidden\" id=\""+(name_key)+"\" name=\""+(name_key)+"\"   "+disabled_prop+" value=''><input type='button' name=\""+(name_key)+"_btn\" id=\""+(name_key)+"_btn\"  class=\"button\" "+disabled_prop+"   value=\"?\" onClick=\"show_practitioner_window('"+(name_key)+"')\"><input type='hidden' name='"+(name_key)+"_prac_sql' id='"+(name_key)+"_prac_sql' value=\""+sql+"\">");      
						} else if (field_mnemonic.equals("CONULT_MED_ID")) {
						  String sql = OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_FORMAT_CONULT_MED_ID");
						  display_length		= 40;
						  sbTemplate.append("<td id=\"New_"+name_key+"_0\" style=\""+display_dependency+"\" class=\""+class_value+"\"  nowrap width=\"15%\" title=\""+help_text+"\" valign='top'>&nbsp;"+label_text+"&nbsp;</td>"); //IN000000
    					  sbTemplate.append("<td id=\"New_"+name_key+"_1\" style=\""+display_dependency+"\" class=\"LABEL\"   width=\"20%\" title=\""+help_text+"\" nowrap>"); 
						  sbTemplate.append("<input type=\"text\" name=\""+(name_key)+"_desc\"   "+disabled_prop+" id=\""+(name_key)+"_desc\"   "+disabled_prop+" value='' size='"+display_length+"'>"+mandatory_gif+"<input type=\"hidden\" id=\""+(name_key)+"\" name=\""+(name_key)+"\"   "+disabled_prop+" value=''><input type='button' name=\""+(name_key)+"_btn\" id=\""+(name_key)+"_btn\"  class=\"button\" "+disabled_prop+"  value=\"?\" onClick=\"show_team_window('"+(name_key)+"')\"><input type='hidden' name='"+(name_key)+"_prac_sql' id='"+(name_key)+"_prac_sql' value=\""+sql+"\">"); 
						} else {
    				    //	help_text = java.net.URLEncoder.encode(help_text);

						if(!field_type.equals("L") || (field_type.equals("L") && single_or_multi.equals("S")))
						{
							if(transplant_pat_yn_exists>0&&transplant_checked.equalsIgnoreCase("")&&order_category.equalsIgnoreCase("LB")&&labmodule.equalsIgnoreCase("IBARL"))
							{
								if(field_mnemonic.equals("DONOR_BLOOD_GROUP")||field_mnemonic.equals("DONOR_RHESUS")||field_mnemonic.equals("TRANSPLANT_DATE"))
								{
									display_transplant="display:none";
									sbTemplate.append("<td id=\"New_"+name_key+"_0\" style=\""+display_transplant+"\" class=\""+class_value+"\" nowrap width=\"250px\" title=\""+help_text+"\" valign='top'>&nbsp;"+label_text+"&nbsp;</td>");
									sbTemplate.append("<td id=\"New_"+name_key+"_1\" style=\""+display_transplant+"\" class=\"fields\"   width=\"15%\" title=\""+help_text+"\" nowrap>"); //IN000000
								}
								else
								{
									display_transplant="display:";
									sbTemplate.append("<td id=\"New_"+name_key+"_0\" style=\""+display_dependency+"\" class=\""+class_value+"\"  nowrap width=\"250px\" title=\""+help_text+"\" valign='top'>&nbsp;"+label_text+"&nbsp;</td>");
									sbTemplate.append("<td id=\"New_"+name_key+"_1\" style=\""+display_dependency+"\" class=\"fields\"   width=\"20%\" title=\""+help_text+"\" nowrap>"); //IN000000
								}
							}
							else
							{
								display_transplant="display:";
								sbTemplate.append("<td id=\"New_"+name_key+"_0\" style=\""+display_dependency+"\" class=\""+class_value+"\"  nowrap width=\"250px\" title=\""+help_text+"\" valign='top'>&nbsp;"+label_text+"&nbsp;</td>");
								sbTemplate.append("<td id=\"New_"+name_key+"_1\" style=\""+display_dependency+"\" class=\"fields\"   width=\"20%\" title=\""+help_text+"\" nowrap valign='top'>");//IN000000
							}
						}
						
						if(field_mnemonic.equals("TRANSPLANT_PAT_YN"))
						{
							transplant_pat_yn_exists++;
						}
						if(transplant_pat_yn_exists>0)
						{
							if(field_mnemonic.equals("DONOR_BLOOD_GROUP")||field_mnemonic.equals("DONOR_RHESUS")||field_mnemonic.equals("TRANSPLANT_DATE"))
							{
								transplant_fields=transplant_fields+name_key+"#";
							}
						}					
    						
    						if( !field_type.equals("C") && !field_type.equals("L") && !field_type.equals("V") && !field_type.equals("R"))
    						{ 
				//IN068553 Starts
								if (field_mnemonic.equals("ATTDPRACT")&&field_type.equals("A")){
								
								display_only_prop = "readOnly";
							}
							else if (field_mnemonic.equals("ATTPRAMOBILENO")&& field_type.equals("I")){
							    
							    onKeyPressNumberValidate ="return CheckForNums(event)";
							     onpaste ="onpaste = 'return false'";	
							
							}
                                                        if (field_mnemonic.equals("ATTPRAMOBILENO")&& field_type.equals("I"))
					        	{
						        	sbTemplate.append("<input type=\"text\" onKeyPress=\""+(onKeyPressNumberValidate)+"\"id=\""+(name_key)+"\" name=\""+(name_key)+"\" size=\""+display_length+"\" maxLength=\""+max_allowed_length+"\" value=\""+dflt_value+"\" "+display_only_prop+" "+ readOnlyClause+" "+ onpaste+" >");
						        }else{
								sbTemplate.append("<input type=\"text\" id=\""+(name_key)+"\" name=\""+(name_key)+"\" size=\""+display_length+"\" maxLength=\""+max_allowed_length+"\" value=\""+dflt_value+"\" "+validationClause+" "+display_only_prop+" "+ readOnlyClause+" >");
								}
							
								 
							//sbTemplate.append("<input type=\"text\" id=\""+(name_key)+"\" onBlur=\""+(onBlurNumberValidate)+"\" onKeyPress=\""+(onKeyPressNumberValidate)+"\"name=\""+(name_key)+"\" size=\""+display_length+"\" maxLength=\""+max_allowed_length+"\" value=\""+dflt_value+"\" "+validationClause+" "+display_only_prop+" "+ readOnlyClause+" > ");
								 sbTemplate.append(discr_msr_uom);
								  sbTemplate.append(dynamic_diag_button);
    							 sbTemplate.append(dateText+mandatory_gif);
							//IN068553 Ends
								 
								 // Adding the calendar component if it is date / date and time filed otherwise will be null
    						} else if( field_type.equals("V"))
    						{
     							sbTemplate.append("<input type=\"hidden\" id=\""+(name_key)+"\" name=\""+(name_key)+"\" size=\""+display_length+"\" maxLength=\""+max_allowed_length+"\" value=\""+dflt_value+"\" "+validationClause+" "+display_only_prop+" "+ readOnlyClause+" ><div style='border:1px;width:50px;height:50px;word-wrap:break-word;'><b>"+dflt_value+"</b></div>"); //IN000000 included div tag
    							 sbTemplate.append(dateText+mandatory_gif); // Adding the calendar component if it is date / date and time filed otherwise will be null
    						}
    						else if(field_type.equals("C"))
    						{
								if(single_or_multi.equals("") || single_or_multi.equals("S")) { // Normal checkbox, where the value Y or N have to be set
								String checked ="";
									if(dflt_value.equals("Y")) {
										dflt_value  = "Y";
										checked		= "CHECKED";
										transplant_checked ="CHECKED";
								    } else {
										//dflt_value  = "N"; -- commented for ML-MMOH-SCF-0412
										dflt_value  = ""; // modified for ML-MMOH-SCF-0412 - IN060565
										checked	    = "";	
										transplant_checked ="";
									}
									//IN060565 Start 
									/*
    								sbTemplate.append("<input type=\"CHECKBOX\" name=\""+(name_key)+"\" value=\""+dflt_value+"\" "+checked+" onClick=\"setCheckBoxValue(this,'"+field_mnemonic+"','"+contr_msr_panel_id+"','"+contr_msr_mod_id+"','','"+order_type_code+"','"+order_category+"'); checkDependency(this,'"+format_id+"','"+field_mnemonic+"',"+new_seq_num+", "+seq_num+", "+max_dependency_row+", '"+dependency_yn+"' ,'"+order_category+"', '"+contr_msr_panel_id+"','"+contr_msr_mod_id+"' ,'"+order_type_code+"' ,'"+discr_msr_id+"' ,'"+performing_facility_id+"' ,'','"+specimen_def_yn+"','"+login_facility_id+"','"+sex+"','"+catalog_code+"','"+oth_dependency_yn+"'); \"  "+ disabled_prop+">"+mandatory_gif+"<input type=\"hidden\" name=\""+(name_key)+"_chkBox\" "+disabled_prop+">");
									*/
								 
									sbTemplate.append("<input type=\"CHECKBOX\" name=\""+(name_key)+"\" id=\""+(name_key)+"\" value=\""+dflt_value+"\" "+checked+" onClick=\"setCheckBoxValue(this,'"+field_mnemonic+"','"+contr_msr_panel_id+"','"+contr_msr_mod_id+"','','"+order_type_code+"','"+order_category+"','"+mandatory_fields+"'); checkDependency(this,'"+format_id+"','"+field_mnemonic+"',"+new_seq_num+", "+seq_num+", "+max_dependency_row+", '"+dependency_yn+"' ,'"+order_category+"', '"+contr_msr_panel_id+"','"+contr_msr_mod_id+"' ,'"+order_type_code+"' ,'"+discr_msr_id+"' ,'"+performing_facility_id+"' ,'','"+specimen_def_yn+"','"+login_facility_id+"','"+sex+"','"+catalog_code+"','"+oth_dependency_yn+"'); \"  "+ disabled_prop+">"+mandatory_gif+"<input type=\"hidden\" name=\""+(name_key)+"_chkBox\" "+disabled_prop+" id=\""+(name_key)+"_chkBox\" "+disabled_prop+">");
									//IN060565 end 
    							} else {  //List Box converted to checkbox, where the code has to be stored
									if(dflt_value.equals("Y")) {
	    								sbTemplate.append("<input type=\"CHECKBOX\" name=\""+(name_key)+"\" id=\""+(name_key)+"\" value=\""+dflt_value+"\"  CHECKED onClick=\"setCheckBoxValue(this,'"+field_mnemonic+"','"+contr_msr_panel_id+"','"+contr_msr_mod_id+"','','"+order_type_code+"','"+order_category+"','"+mandatory_fields+"'); checkDependency(this,'"+format_id+"','"+field_mnemonic+"',"+new_seq_num+", "+seq_num+", "+max_dependency_row+", '"+dependency_yn+"' ,'"+order_category+"', '"+contr_msr_panel_id+"','"+contr_msr_mod_id+"' ,'"+order_type_code+"' ,'"+discr_msr_id+"' ,'"+performing_facility_id+"' ,'','"+specimen_def_yn+"','"+login_facility_id+"','"+sex+"','"+catalog_code+"','"+oth_dependency_yn+"'); \"  "+ disabled_prop+">"+mandatory_gif+"<input type=\"hidden\" name=\""+(name_key)+"_chkBox\" "+disabled_prop+" id=\""+(name_key)+"_chkBox\" "+disabled_prop+">");
									} else {
										if( "Y".equals(ord_formt_multi_chk_nonmandate_yn) && single_or_multi.equals("M") && "R".equals(accept_option)) {
											String l_check_box_multi_val = "";
											String checked ="";
											if(!multiListCompList.contains(parent_field_mnemonic+"ORDERFORMAT"+order_type_code+new_seq_num)){
												multiListCompList.add(parent_field_mnemonic+"ORDERFORMAT"+order_type_code+new_seq_num);
												completeMultiCheckCompList.add(parent_field_mnemonic+"ORDERFORMAT"+order_type_code+new_seq_num);
											
												if(("AMEND_ORDER".equalsIgnoreCase(p_function_from) || "COPY_ORDER".equalsIgnoreCase(p_function_from)) && "Y".equals(amd_ord_dflt_value)) {
													checked		= "CHECKED";
 													l_check_box_multi_val = "Y";
												}
											}
											selMultiSelectedMap = bean.getMultiListCompMnemonicMapClone();
											//String l_check_box_multi_val = "";
											//String checked ="";
 											if(selMultiSelectedMap != null && selMultiSelectedMap.containsKey(order_type_code+field_mnemonic)){
 												//selecteCompList =  selMultiSelectedMap.containsKey(catalog_code+field_mnemonic);
 												selecteCompList = (ArrayList)selMultiSelectedMap.get(order_type_code+field_mnemonic);
 												if(selecteCompList.contains(parent_field_mnemonic+"ORDERFORMAT"+order_type_code+new_seq_num)){
 													checked		= "CHECKED";
 													l_check_box_multi_val = "Y";
 												} else {
 													checked		= "";
 													//l_check_box_multi_val = "N";  // commented for IN062829
													l_check_box_multi_val = ""; //IN062829
 												}
 											}
											sbTemplate.append("<input type=\"CHECKBOX\" name=\""+(name_key)+"\" id=\""+(name_key)+"\" value=\""+l_check_box_multi_val+"\" "+checked+" onClick=\"setMultiCheckBoxMandHeader(this,'"+order_type_code+"','"+field_mnemonic+"','"+bean_id+"','"+bean_name+"'); setCheckBoxValue(this,'"+field_mnemonic+"','"+contr_msr_panel_id+"','"+contr_msr_mod_id+"','','"+order_type_code+"','"+order_category+"','"+mandatory_fields+"'); checkDependency(this,'"+format_id+"','"+field_mnemonic+"',"+new_seq_num+", "+seq_num+", "+max_dependency_row+", '"+dependency_yn+"' ,'"+order_category+"', '"+contr_msr_panel_id+"','"+contr_msr_mod_id+"' ,'"+order_type_code+"' ,'"+discr_msr_id+"' ,'"+performing_facility_id+"' ,'','"+specimen_def_yn+"','"+login_facility_id+"','"+sex+"','"+catalog_code+"','"+oth_dependency_yn+"');  \"  "+ disabled_prop+"><input type=\"hidden\" name=\""+(name_key)+"_chkBox\" "+disabled_prop+" id=\""+(name_key)+"_chkBox\" "+disabled_prop+">");
											if(selMultiSelectedMap != null && !multiListCompList.contains(parent_field_mnemonic+"ORDERFORMAT"+order_type_code+new_seq_num)){
												multiListCompList.add(parent_field_mnemonic+"ORDERFORMAT"+order_type_code+new_seq_num);
												completeMultiCheckCompList.add(parent_field_mnemonic+"ORDERFORMAT"+order_type_code+new_seq_num);
											}
										} else {
											sbTemplate.append("<input type=\"CHECKBOX\" name=\""+(name_key)+"\" id=\""+(name_key)+"\" value='N'  onClick=\"setCheckBoxValue(this,'"+field_mnemonic+"','"+contr_msr_panel_id+"','"+contr_msr_mod_id+"','','"+order_type_code+"','"+order_category+"','"+mandatory_fields+"'); checkDependency(this,'"+format_id+"','"+field_mnemonic+"',"+new_seq_num+", "+seq_num+", "+max_dependency_row+", '"+dependency_yn+"' ,'"+order_category+"', '"+contr_msr_panel_id+"','"+contr_msr_mod_id+"' ,'"+order_type_code+"' ,'"+discr_msr_id+"' ,'"+performing_facility_id+"' ,'','"+specimen_def_yn+"','"+login_facility_id+"','"+sex+"','"+catalog_code+"','"+oth_dependency_yn+"');  \"  "+ disabled_prop+">"+mandatory_gif+"<input type=\"hidden\" name=\""+(name_key)+"_chkBox\" "+disabled_prop+" id=\""+(name_key)+"_chkBox\" "+disabled_prop+">");
										}	
									}
    							}
    						}
							else if(field_type.equals("R")) // Radio Group
							{
								//out.println("label_text="+label_text);
 								//sbTemplate.append("<input type=\"RADIO\" name=\""+(name_key)+"\" ");
								sbTemplate.append("<table border='0'><tr><td valign='top'>");
								ArrayList OrderFormatRadio = beanQueryObj.getOrderFormatRadio(properties, order_category,field_mnemonic,catalog_code,lab_install_yn,contr_msr_panel_id,contr_msr_mod_id);
								int radio_count = OrderFormatRadio.size();
								int ind=1;
								for(int l=0; l<radio_count; l++)
								{
									/*
									    String text_color="";
										String change_color = "";
										if(ind%2==0)
									    {
										change_color="background-color:#808080;";
										text_color ="#808080 ";	
									    }
									    else if(ind%2==1)
									    {
										change_color="background-color:#CC6600;";
										text_color ="#CC6600";	
									    }*/
									//out.println("change_color="+change_color);
									records = (String[])OrderFormatRadio.get(l);
									if(dflt_value.equals(records[0])) // first Item
								   		sbTemplate.append("<input type=\"RADIO\"  name=\"radio_"+(name_key)+"\" id=\"radio_"+(name_key)+"\" value=\""+records[0]+"\" checked  "+validationClause+">"+records[1]+"</input><BR>");
									else 
										sbTemplate.append("<input type=\"RADIO\"  name=\"radio_"+(name_key)+"\" id=\"radio_"+(name_key)+"\" value=\""+records[0]+"\"  "+validationClause+">"+records[1]+"</input><BR>");
									ind++;
 										records = null;
 								} // End of for
								OrderFormatRadio	 = null;//modified append --[IN000767]
 								//sbTemplate.append(mandatory_gif+"<input type=\"hidden\" name=\""+(name_key)+"\" size=\""+display_length+"\" maxLength=\""+max_allowed_length+"\" value=\""+dflt_value+"\" >&nbsp;<input type=\"button\" name=\"radio_clear\" class=\"BUTTON\"  value=\"Reset\" onClick=\"resetRadioButtons('"+name_key+"',"+radio_count+",'"+dependency_yn+"',"+new_seq_num+","+max_dependency_row+")\" ></td></tr></table>");
 								sbTemplate.append(mandatory_gif+"<input type=\"hidden\" name=\""+(name_key)+"\" id=\""+(name_key)+"\" size=\""+display_length+"\" maxLength=\""+max_allowed_length+"\" value=\""+dflt_value+"\"  >&nbsp;<input type=\"button\" name=\"radio_clear\" id=\"radio_clear\" class=\"BUTTON\"  value=\"Reset\" onClick=\"resetRadioButtons('"+name_key+"',"+radio_count+",'"+dependency_yn+"',"+new_seq_num+","+max_dependency_row+")\" ></td></tr><tr><td class=\"LABEL\"  width=\"15%\" colspan=\"6\">&nbsp;</td></tr></table>");
							}
    						else if(field_type.equals("L"))
    						{
								if((field_mnemonic.equalsIgnoreCase("REQUEST_COMMENT")||field_mnemonic.equalsIgnoreCase("REQUEST_COMMENT_DESC"))&&order_category.equalsIgnoreCase("LB")&&labmodule.equalsIgnoreCase("IBARL"))
								{

									String sql = eOR.Common.OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_LAB_INSTAL_REQUEST_COMMENT");
									display_length		= 30;
									String request_comment_desc="";
									if(!dflt_value.equals(""))
									{		
										request_comment_desc=beanQueryObj.getRequestCommentDesc(properties,dflt_value);	
										if(request_comment_desc.equals("null")||(request_comment_desc==null))
										{
												request_comment_desc="";
												dflt_value="";
										}
										else if(request_comment_desc.trim().equals(""))
										{
												request_comment_desc="";
												dflt_value="";
										}
									}		
									validationClause	= "onBlur = \"before_show_request_comment_window(this,'"+(name_key)+"','"+(order_type_code)+"','"+format_id+"','"+field_mnemonic+"','"+new_seq_num+"','"+seq_num+"','"+max_dependency_row+"','"+dependency_yn+"','"+order_category+"','"+contr_msr_panel_id+"','"+contr_msr_mod_id+"','"+discr_msr_id+"','"+performing_facility_id+"','','"+specimen_def_yn+"','"+login_facility_id+"','"+sex+"','"+catalog_code+"'); \" ";
									sbTemplate.append("<input type=\"text\" name=\""+(name_key)+"_desc\"   "+disabled_prop_oth_desc+" "+validationClause+" id=\""+(name_key)+"_desc\"   "+disabled_prop_oth_desc+" "+validationClause+" value=\""+request_comment_desc+"\" size='"+display_length+"'><input type=\"hidden\" id=\""+(name_key)+"\" name=\""+(name_key)+"\"   "+disabled_prop_oth_desc+"  value=\""+dflt_value+"\"><input type='button' name=\""+(name_key)+"_btn\" id=\""+(name_key)+"_btn\"  class=\"button\"   value=\"?\"  "+disabled_prop_oth_desc+" onClick=\"show_request_comment_window('','"+(name_key)+"','"+order_type_code+"','"+format_id+"','"+field_mnemonic+"','"+new_seq_num+"','"+seq_num+"','"+max_dependency_row+"','"+dependency_yn+"','"+order_category+"','"+contr_msr_panel_id+"','"+contr_msr_mod_id+"','"+discr_msr_id+"','"+performing_facility_id+"','','"+specimen_def_yn+"','"+login_facility_id+"','"+sex+"','"+catalog_code+"')\"><input type='hidden' name='"+(name_key)+"_request_comment_sql' id='"+(name_key)+"_request_comment_sql' value=\""+sql+"\"><input type='checkbox' name='"+(name_key)+"_request_comment_chkbox' id='"+(name_key)+"_request_comment_chkbox' "+checked_oth+"   "+disabled_prop+"  onClick=\"show_request_comment_oth_desc(this,'"+(name_key)+"','"+(accept_option)+"')\"  value=\"\">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.others.label","common_labels")+"");
									if(accept_option.equals("R")&&dflt_value_oth_desc.equals(""))
									{
										String mandatory_oth_gif="<img src='../../eCommon/images/mandatory.gif' style=\"visibility:hidden\"  name='"+(name_key)+"_REQ_CMT_TXT'>";
										sbTemplate.append("<img src='../../eCommon/images/mandatory.gif' name ='"+(name_key)+"_REQ_CMT_LOV'></img></td><td><input type='text'  style=\""+style_oth+"\"   name='"+(name_key)+"_request_comment_oth_desc' id='"+(name_key)+"_request_comment_oth_desc' size='40' maxLength='40' value=\""+dflt_value_oth_desc+"\">"+mandatory_oth_gif); 
									}
									else
									{
										String mandatory_oth_gif_style="";
										if(accept_option.equals("R")&&!dflt_value_oth_desc.equals(""))
										{
											mandatory_oth_gif_style							="visibility:visible";
										}
										else
										{
											mandatory_oth_gif_style							="visibility:hidden";
										}
										String mandatory_oth_gif="<img src='../../eCommon/images/mandatory.gif' style=\""+mandatory_oth_gif_style+"\"  name='"+(name_key)+"_REQ_CMT_TXT'>";
										sbTemplate.append("<img src='../../eCommon/images/mandatory.gif' name ='"+(name_key)+"_REQ_CMT_LOV' style=\"visibility:hidden\"></img></td><td><input type='text'  style=\""+style_oth+"\"   name='"+(name_key)+"_request_comment_oth_desc' id='"+(name_key)+"_request_comment_oth_desc' size='40' maxLength='40' value=\""+dflt_value_oth_desc+"\">"+mandatory_oth_gif); 
									}
								}
								else 														if(((field_mnemonic.equalsIgnoreCase("DONOR_BLOOD_GROUP"))||(field_mnemonic.equalsIgnoreCase("DONOR_RHESUS")))&&order_category.equalsIgnoreCase("LB")&&(labmodule.equalsIgnoreCase("IBARL")))
								{ 
									String sql="";
									if(field_mnemonic.equalsIgnoreCase("DONOR_BLOOD_GROUP"))
									{
										sql = eOR.Common.OrRepositoryExt.getOrKeyValue("SQL_OR_TRANSPLANT_DONOR_BLOOD_GROUP");
									}
									else if(field_mnemonic.equalsIgnoreCase("DONOR_RHESUS"))
									{
										sql = eOR.Common.OrRepositoryExt.getOrKeyValue("SQL_OR_TRANSPLANT_DONOR_RHESUS");
									}
									display_length		= 30;
									String donor_blood_desc="";
									if(!dflt_value.equals(""))
									{			
										donor_blood_desc=beanQueryObj.getDonorBloodDesc(properties,dflt_value,field_mnemonic);										
									}
									if(donor_blood_desc==null)donor_blood_desc="";
									if(donor_blood_desc.equals(""))dflt_value="";

									validationClause	= "onBlur = \"before_show_donor_blood_group_window(this,'"+(name_key)+"','"+(order_type_code)+"','"+format_id+"','"+field_mnemonic+"','"+new_seq_num+"','"+seq_num+"','"+max_dependency_row+"','"+dependency_yn+"','"+order_category+"','"+contr_msr_panel_id+"','"+contr_msr_mod_id+"','"+discr_msr_id+"','"+performing_facility_id+"','','"+specimen_def_yn+"','"+login_facility_id+"','"+sex+"','"+catalog_code+"'); \" ";

									sbTemplate.append("<input type=\"text\" name=\""+(name_key)+"_desc\"   "+disabled_prop+" "+validationClause+" id=\""+(name_key)+"_desc\"   "+disabled_prop+" "+validationClause+" value=\""+donor_blood_desc+"\" size='"+display_length+"'><input type=\"hidden\" id=\""+(name_key)+"\" name=\""+(name_key)+"\"   "+disabled_prop+"  value=\""+dflt_value+"\"><input type='button' name=\""+(name_key)+"_btn\" id=\""+(name_key)+"_btn\"  class=\"button\"   value=\"?\"  onClick=\"show_donor_blood_group_window('','"+(name_key)+"','"+order_type_code+"','"+format_id+"','"+field_mnemonic+"','"+new_seq_num+"','"+seq_num+"','"+max_dependency_row+"','"+dependency_yn+"','"+order_category+"','"+contr_msr_panel_id+"','"+contr_msr_mod_id+"','"+discr_msr_id+"','"+performing_facility_id+"','','"+specimen_def_yn+"','"+login_facility_id+"','"+sex+"','"+catalog_code+"')\"><input type='hidden' name='"+(name_key)+"_donor_sql' id='"+(name_key)+"_donor_sql' value=\""+sql+"\">"+mandatory_gif+""); 

								}
								else
								{

									if(!single_or_multi.equals("M")) {
								//field_mnemonic_fields	+= field_mnemonic+"ORDERFORMAT"+order_type_code+"ï¿½"; // To check for the Duplicate and to put the same value for the multiple field mnemonics
										field_mnemonic_fields.append(field_mnemonic+"ORDERFORMAT"+order_type_code+"ï¿½");

    									//list_item_fields  		+= name_key+"ï¿½";
										lb_install_fields.append(lab_install_yn+"ï¿½");
										list_item_fields.append(name_key+"ï¿½");
										//label_text_value		+= label_text+"ï¿½";
										label_text_value		=label_text_value+ label_text+"ï¿½";
										 //label_text_valu.append(label_text+"ï¿½");

										//list_item_fields  += field_mnemonic+order_type_code+seq_num+"ï¿½";
										// For the clearing of the PREF_SURG_DATE , if the values are reseted in PERF_SURGEON
										if(order_category.equals("OT") && ot_install_yn.equals("Y") && old_field_mnemonic.equals("PERFORM_TEAM_SURGEON")) // for this
											validationClause	= "onChange = \"callClearPrefSurgDate('"+(field_mnemonic+"ORDERFORMAT"+order_type_code)+"'); checkDependency(this,'"+format_id+"','"+field_mnemonic+"',"+new_seq_num+", "+seq_num+", "+max_dependency_row+", '"+dependency_yn+"' ,'"+order_category+"', '"+contr_msr_panel_id+"', '"+contr_msr_mod_id+"' ,'"+order_type_code+"' ,'"+discr_msr_id+"' ,'"+performing_facility_id+"' ,'','"+specimen_def_yn+"','"+login_facility_id+"','"+sex+"','"+catalog_code+"','"+oth_dependency_yn+"');\"";
										else
											validationClause	= "onChange =\"checkDependency(this,'"+format_id+"','"+field_mnemonic+"',"+new_seq_num+", "+seq_num+", "+max_dependency_row+", '"+dependency_yn+"' ,'"+order_category+"', '"+contr_msr_panel_id+"', '"+contr_msr_mod_id+"' ,'"+order_type_code+"' ,'"+discr_msr_id+"' ,'"+performing_facility_id+"' ,'','"+specimen_def_yn+"','"+login_facility_id+"','"+sex+"','"+catalog_code+"','"+oth_dependency_yn+"');\"";
											//IN045352 Starts
											/*if(order_category.equals("OT") && ot_install_yn.equals("Y") && field_mnemonic.equals("SURGERY_TYPE")) 
											{	
												
												validationClause_new = "'"+format_id+"','"+field_mnemonic+"',"+new_seq_num+", "+seq_num+", "+max_dependency_row+", '"+dependency_yn+"' ,'"+order_category+"', '"+contr_msr_panel_id+"', '"+contr_msr_mod_id+"' ,'"+order_type_code+"' ,'"+discr_msr_id+"' ,'"+performing_facility_id+"' ,'','"+specimen_def_yn+"','"+login_facility_id+"','"+sex+"','"+catalog_code+"'";
												sbTemplate.append("<input type=\"hidden\" name=\"validationClause_new"+count+"\" value=\""+validationClause_new+"\">");//IN045522 
				    							sbTemplate.append("<input type=\"hidden\" name=\"name_key_new"+count+"\" value=\""+name_key+"\">");//IN045522
											}*/
											//IN045352 Ends
										sbTemplate.append("<select name=\""+(name_key)+"\" "+ disabled_prop+" "+validationClause+" id=\""+(name_key)+"\" "+ disabled_prop+" "+validationClause+">");
							
								if(field_mnemonic.equalsIgnoreCase("PRES_REMARKS")) // For PH Functions and field_mnemonic = "PRES_REMARKS"
    							{
								
									//p_catalog_code="N02BE01000T1001E";
									//p_form_code="INJ";
									//p_route_code="IVB";
								ArrayList OrderFormatList = beanQueryObj.getprescriptionremarks(p_catalog_code,p_form_code,p_route_code,properties);
							
								String[] phrecords=null;
								sbTemplate.append("<option value=\"  \">-----  "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+" -----</option>");
								if(OrderFormatList.size()>0)
								{
								for(int l=0; l<OrderFormatList.size(); l++)
								{
									phrecords = (String[])OrderFormatList.get(l);
    								
    								/*stPhListVals 		= new StringTokenizer(ph_list_vals,"::");
    								while(stPhListVals.hasMoreTokens())
    								{
    									ph_list_val	= stPhListVals.nextToken();
    									ph_list_desc= stPhListVals.nextToken();
    									if(dflt_value.equals(ph_list_val))
    										sbTemplate.append("<option value=\""+ph_list_val+"\" selected>"+ph_list_desc+"</option>");
    									else
    										sbTemplate.append("<option value=\""+ph_list_val+"\" >"+ph_list_desc+"</option>");
    								}*/
									
									if(!dflt_value.equals(""))
									{
										
									if(dflt_value.equals(phrecords[0]))
										{
									
										sbTemplate.append("<option value=\""+phrecords[0]+"\" selected>"+phrecords[1]+"</option>");
										}else
										{		
										
											sbTemplate.append("<option value=\""+phrecords[0]+"\" >"+phrecords[1]+"</option>");
										}
									}else
									{
										
										if((bean.checkForNull(phrecords[2],"")).equalsIgnoreCase("Y"))
										{		
											
											sbTemplate.append("<option value=\""+phrecords[0]+"\" selected>"+phrecords[1]+"</option>");
										}
										else
										{
											
											sbTemplate.append("<option value=\""+phrecords[0]+"\">"+phrecords[1]+"</option>");
										}
									}
								}
    							}
								} else if (field_mnemonic.equalsIgnoreCase("ANAESTHESIA")) // other than PRES_REMARKS
    							{

                                    sbTemplate.append("<option value=\"\">-----  "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+" -----</option>");
    								ArrayList OrderFormatList = bean.getOrderFormatAnaesthesiaList();
    								//sbTemplate.append("<script>alert('"+field_mnemonic+","+OrderFormatList.size()+"')</script>");
    								for(int k=0; k<OrderFormatList.size(); k++)
    								{
    									records = (String[])OrderFormatList.get(k);
    									if(dflt_value.equals(records[0]))
    									   sbTemplate.append("<option value=\""+records[0]+"\" selected>"+records[1]+"</option>");
    									else
    									{
    										sbTemplate.append("<option value=\""+records[0]+"\" >"+records[1]+"</option>");
    									}
										records = null;
    								} // End of for
									if(OrderFormatList!=null) {
											OrderFormatList.clear();
											OrderFormatList	= null;
									}  // Nullifying the objects
    							} // End of OR//IN043095 Starts
								else if (field_mnemonic.equalsIgnoreCase("SURGERY_TYPE"))
    							{
									sbTemplate.append("<option value=\"\">-----  "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+" -----</option>");
    								ArrayList OrderFormatList1 = beanQueryObj.getOrderFormatList(properties, order_category,field_mnemonic,contr_msr_panel_id,contr_msr_mod_id,order_type_code,discr_msr_id,performing_facility_id,login_facility_id, sex, lab_install_yn, bt_install_yn, rd_install_yn, ot_install_yn,catalog_code);
     								String appendCodeDesc = "";
									for(int k=0; k<OrderFormatList1.size(); k++)
    								{
    									records = (String[])OrderFormatList1.get(k);
										appendCodeDesc = records[0]+"||"+records[1];
    									if(dflt_value.equals(records[0]))//IN045352
    									//if(dflt_value.equals(records[0]) || dflt_value.equals(records[1]))//IN045352
    									{
    									   sbTemplate.append("<option value=\""+appendCodeDesc+"\" selected>"+records[1]+"</option>");
    									}
    									else
    									{
											sbTemplate.append("<option value=\""+appendCodeDesc+"\" >"+records[1]+"</option>");
    									}
										records = null;//Nullifying the objects
    								} // End of for
									if(OrderFormatList1!=null) {
											OrderFormatList1.clear();
											OrderFormatList1	= null;
									}  // Nullifying the objects
                                  
    							} //IN043095 Ends	
    							else // other than PRES_REMARKS
    							{

    								sbTemplate.append("<option value=\"\">-----  "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+" -----</option>");
    								ArrayList OrderFormatList = beanQueryObj.getOrderFormatList(properties, order_category,field_mnemonic,contr_msr_panel_id,contr_msr_mod_id,order_type_code,discr_msr_id,performing_facility_id,login_facility_id, sex, lab_install_yn, bt_install_yn, rd_install_yn, ot_install_yn,catalog_code);
     								
									for(int k=0; k<OrderFormatList.size(); k++)
    								{
    									records = (String[])OrderFormatList.get(k);
    									if(dflt_value.equals(records[0]))
    									   sbTemplate.append("<option value=\""+records[0]+"\" selected>"+records[1]+"</option>");
    									else
    									{
    										if(specimen_def_yn.equals("Y") && records[2].equalsIgnoreCase("Y")) // If lab is installed and to default the value for specimen type
    											sbTemplate.append("<option value=\""+records[0]+"\" selected>"+records[1]+"</option>");
    										else
    											sbTemplate.append("<option value=\""+records[0]+"\" >"+records[1]+"</option>");
    									}
										records = null;//Nullifying the objects
    								} // End of for
									if(OrderFormatList!=null) {
											OrderFormatList.clear();
											OrderFormatList	= null;
									}  // Nullifying the objects
    							} // End of OR
									sbTemplate.append("</select>"+mandatory_gif+"<input type=\"hidden\" name=\""+(name_key)+"_desc\" id=\""+(name_key)+"_desc\" value=\"\" >");
    							}
							}
						}
							
                        }	 // end of field_type = 'L'
						sbTemplate.append("</td>");
						field_validation	= (name_key);
						
						if(single_or_multi.equals("M") && multi_last_record.equals("Y"))
						{
 							sbTemplate.append("</tr><tr><td class=\"LABEL\"  width=\"15%\" colspan=\"6\">&nbsp;</td></tr><tr>");  //BLANK_ROW
								group_field_mnemonic_count = 0; //Assingn to zero to identify the grouping is over
	 					}


						sbTemplate.append("<input type=\"hidden\" name=\"field_validation"+row_count+"\" id=\"field_validation"+row_count+"\" value=\""+field_validation+"\">");
						// If any dependency or any message for field_mnemonic is there
						sbTemplate.append("<input type=\"hidden\" name=\"field_mnemonic_action"+name_key+"\" id=\"field_mnemonic_action"+name_key+"\" value=\""+field_mnemonic_action+"\">");
						sbTemplate.append("<input type=\"hidden\" name=\"field_action_msg"+name_key+"\" id=\"field_action_msg"+name_key+"\" value=\""+field_action_msg+"\">");
						sbTemplate.append("<input type=\"hidden\" name=\"notify_yn"+name_key+"\" id=\"notify_yn"+name_key+"\" value=''>");
						sbTemplate.append("<input type=\"hidden\" name=\"field_value_type"+name_key+"\" id=\"field_value_type"+name_key+"\" value=\""+field_value_type+"\">");
						// Only for dependency type, we will set in the hidden fields
						sbTemplate.append("<input type=\"hidden\" name=\"field_mnemonic"+name_key+"\" id=\"field_mnemonic"+name_key+"\" value=\""+field_mnemonic+"\">");
						sbTemplate.append("<input type=\"hidden\" name=\"label_text"+name_key+"\" id=\"label_text"+name_key+"\" value=\""+label_text+"\">");
						sbTemplate.append("<input type=\"hidden\" name=\"accept_option"+name_key+"\" id=\"accept_option"+name_key+"\" value=\""+accept_option+"\">");
						sbTemplate.append("<input type=\"hidden\" name=\"field_type"+name_key+"\" id=\"field_type"+name_key+"\" value=\""+field_type+"\">");
						sbTemplate.append("<input type=\"hidden\" name=\"default_value"+name_key+"\" id=\"default_value"+name_key+"\" value=\""+default_value+"\">"); //IN045798
						sbTemplate.append("<input type=\"hidden\" name=\"oth_dependency_yn"+name_key+"\" id=\"oth_dependency_yn"+name_key+"\" value=\""+oth_dependency_yn+"\">");// IN049133
						// Hidden fields to check the max &  min , if there
                        //if( field_type.equals("I") || field_type.equals("N") )
    					//{
     					sbTemplate.append("<input type=\"hidden\" name=\"min_max"+(name_key)+"\" id=\"min_max"+(name_key)+"\" value=\""+min_num_value+"#"+max_num_value+"\">");
    					//	}
						
						if((field_mnemonic.equalsIgnoreCase("REQUEST_COMMENT")||field_mnemonic.equalsIgnoreCase("REQUEST_COMMENT_DESC"))&&order_category.equalsIgnoreCase("LB")&&labmodule.equalsIgnoreCase("IBARL")&&field_type.equals("L"))
						{
								sbTemplate.append("</tr><tr><td class=\"LABEL\"  width=\"15%\" colspan=\"6\">&nbsp;</td></tr>");
			    				sbTemplate.append("<tr>");
								tr=0;
						}
						else
						 {
							if(tr!= 0 && tr%2==1)
			    			{
																
								sbTemplate.append("</tr>");
			    				 sbTemplate.append("<tr><td class=\"LABEL\"  align=\"left\" width=\"20%\" colspan=\"6\">&nbsp;</td></tr>");
			    				sbTemplate.append("<tr>");
							}
							tr++;
							
						 }
   			    		row_count++;
   			    		if(multiListCompMap != null && !multiListCompMap.containsKey(order_type_code+field_mnemonic) && "Y".equals(ord_formt_multi_chk_nonmandate_yn) && "R".equals(accept_option) && single_or_multi.equals("M")) { // ML-MMOH-CRF-0508.1 [IN062319] - Start
							multiListCompMap.put(order_type_code+field_mnemonic, multiListCompList);
						}
   			    		if("AMEND_ORDER".equalsIgnoreCase(p_function_from) || "COPY_ORDER".equalsIgnoreCase(p_function_from)) {
   			    			amd_ord_dflt_value = "";
   			    		}	
			     } // end of arrSeqNo for

			  } // End of arrSeqNo.size()

	        } // end of count
        	// To check for the mandatory fields
				if("Y".equals(ord_formt_multi_chk_nonmandate_yn)) { // ML-MMOH-CRF-0508.1 [IN062319] - Start
 			     		bean.setMultiListCompMnemonicMap(multiListCompMap);	
						bean.setCompleteMultiCheckCompList(completeMultiCheckCompList);
				} // ML-MMOH-CRF-0508.1 [IN062319] - End
			     if(mandatory_fields.length()>0)
			     {    					   
					 	mandatory_fields	= mandatory_fields.substring(0,mandatory_fields.length()-1);
						//mandatory_fields.append(mandatory_fields.toString().substring(0,mandatory_fields.length()-1));
					 	mandatory_names		=	mandatory_names.substring(0,mandatory_names.length()-1);

						//mandatory_names.append(mandatory_names.toString().substring(0,mandatory_names.length()-1));
			     }
				 if(transplant_fields.length()>0)
			    {
				 	transplant_fields	=	transplant_fields.substring(0,transplant_fields.length()-1);
 			    }
			     if(field_mnemonic_fields.length()>0)
			     	//field_mnemonic_fields	=	field_mnemonic_fields.substring(0,field_mnemonic_fields.length()-1);
					field_mnemonic_fields.append(field_mnemonic_fields.toString().substring(0,field_mnemonic_fields.length()-1));

			     if(list_item_fields.length()>0)
			     {
				 	//list_item_fields		=	list_item_fields.substring(0,list_item_fields.length()-1);
						list_item_fields.append(list_item_fields.toString().substring(0,list_item_fields.length()-1));

			     }
				 if(lb_install_fields.length()>0)
			    {
					//list_item_fields	=	list_item_fields.substring(0,list_item_fields.length()-1);

						lb_install_fields.append(lb_install_fields.substring(0,lb_install_fields.length()-1));
			    }
			     if(label_text_value.length()>0)
			   	 	label_text_value	=	label_text_value.substring(0,label_text_value.length()-1);
					//label_text_value.append(label_text_value.toString().substring(0,label_text_value.length()-1));
				 sbTemplate.append("<input type=\"hidden\" name=\"ord_formt_multi_chk_nonmand_yn\" id=\"ord_formt_multi_chk_nonmand_yn\" value=\""+ord_formt_multi_chk_nonmandate_yn+"\">"); // ML-MMOH-CRF-0508.1 [IN062319]
			   	 sbTemplate.append("<input type=\"hidden\" name=\"row_count\" id=\"row_count\" value=\""+row_count+"\">");
			     sbTemplate.append("<input type=\"hidden\" name=\"lab_install_yn\" id=\"lab_install_yn\" value=\""+lb_install_fields.toString()+"\">");
				 sbTemplate.append("<input type=\"hidden\" name=\"bt_install_yn\" id=\"bt_install_yn\" value=\""+bt_install_yn+"\">");
				 sbTemplate.append("<input type=\"hidden\" name=\"rd_install_yn\" id=\"rd_install_yn\" value=\""+rd_install_yn+"\">");
				 sbTemplate.append("<input type=\"hidden\" name=\"ot_install_yn\" id=\"ot_install_yn\" value=\""+ot_install_yn+"\">");
			     sbTemplate.append("<input type=\"hidden\" name=\"mandatory_fields\" id=\"mandatory_fields\" value=\""+mandatory_fields.toString()+"\">");
				  sbTemplate.append("<input type=\"hidden\" name=\"transplant_fields\" id=\"transplant_fields\" value=\""+transplant_fields+"\">");
			     sbTemplate.append("<input type=\"hidden\" name=\"mandatory_names\" id=\"mandatory_names\" value=\""+mandatory_names.toString()+"\">");
			     sbTemplate.append("<input type=\"hidden\" name=\"list_item_fields\" id=\"list_item_fields\" value=\""+list_item_fields.toString()+"\">");
			     sbTemplate.append("<input type=\"hidden\" name=\"field_mnemonic_fields\" id=\"field_mnemonic_fields\" value=\""+field_mnemonic_fields.toString()+"\">");
 			     sbTemplate.append("<input type=\"hidden\" name=\"label_text_value\" id=\"label_text_value\" value=\""+label_text_value+"\">");
				 sbTemplate.append("<input type=\"hidden\" name=\"sys_date\" id=\"sys_date\" value=\""+sys_date+"\">");
				 sbTemplate.append("<input type=\"hidden\" name=\"sys_date_time\" id=\"sys_date_time\" value=\""+sys_date_time+"\">");
				 sbTemplate.append("<input type=\"hidden\" name=\"count\" id=\"count\" value=\""+count+"\">");//IN045522
				 sbTemplate.append("</tr><tr><td class=\"LABEL\"   width=\"20%\" colspan=\"6\">&nbsp;</td></tr></table>");
		}
		catch(Exception e)
		{
			//out.println("Exception Template Building: "+e);//COMMON-ICN-0181
			e.printStackTrace();
		}
		//Nullifying the objects
		template		= null;
		arrSeqNo		= null;order_type_records = null; records = null;
		stPhListVals	= null;
		return sbTemplate;
		
	}
%>
<!--IN047739 added new-->
<%!
	private void checkReplaceAmend(eOR.OrderEntryBean bean,eOR.Common.OrderEntryRecordBean orderEntryRecordBean, String ind_catalog_code , String ind_row_value, String field_mnemonic, Hashtable template) throws Exception
	{
		Hashtable dummy_template		= null;
		int		old_stored_seq_num		= 0;

		// If already there, then no need to add it again so replace the value with the current value, so take the values from the bean and then try to set it again
		ArrayList arrSeqNo				= (ArrayList) orderEntryRecordBean.getOrderFormats(ind_catalog_code, ind_row_value); 
		for(int t=0;t<arrSeqNo.size();t++)	// Main Loop
		{
			 old_stored_seq_num			=  Integer.parseInt((String)arrSeqNo.get(t));  
			 dummy_template				=  (Hashtable) orderEntryRecordBean.getOrderFormats ( ind_catalog_code, (ind_catalog_code+old_stored_seq_num) );
				// To replace the default_value
			//if(bean.checkForNull((String)dummy_template.get("single_or_multi"),"").equals("M") &&  bean.checkForNull((String)dummy_template.get("field_type"),"").equals("C") && bean.checkForNull((String)dummy_template.get("field_mnemonic"),"").equals(field_mnemonic) && (bean.checkForNull((String)dummy_template.get("dflt_value"),"").indexOf(bean.checkForNull((String)template.get("field_values"),""))!=-1) ) //IN049124 
			if(bean.checkForNull((String)dummy_template.get("single_or_multi"),"").equals("M") &&  bean.checkForNull((String)dummy_template.get("field_type"),"").equals("C") && bean.checkForNull((String)dummy_template.get("field_mnemonic"),"").equals(field_mnemonic) && bean.checkForNull((String)dummy_template.get("label_text"),"").equals(bean.checkForNull((String)template.get("label_text"),"")) )//IN049124 	
			{
				dummy_template.put("field_values",bean.checkForNull((String)template.get("field_values"),"")) ;
				
					orderEntryRecordBean.setOrderFormats(ind_catalog_code, (ind_catalog_code+old_stored_seq_num),dummy_template);
 				}
 		} // End of for

		// Do not clear the Hashtable and ArrayList, since it will clear the actual value
 	}	// End of checkReplaceAmend
%>
<%
	// set it back persistence
	putObjectInBean(bean_id,bean,request);

%>
<!-- Newly added script by Name :selvin  Date :10 june 2011 INCIDENT NO: 27383 Changes:newly added javascript,Starts -->
<script language="javascript" type="text/javascript">
	//IN049133	
	if(parent.flex_fields_button.document.OrderEntryFormatButtons)
	{
		if(parent.flex_fields_button.document.OrderEntryFormatButtons.ok.disabled)
		parent.flex_fields_button.document.OrderEntryFormatButtons.ok.disabled = false;   
		if(parent.flex_fields_button.document.OrderEntryFormatButtons.CANCEL.disabled)
		parent.flex_fields_button.document.OrderEntryFormatButtons.CANCEL.disabled = false;   
	}
</script> 
<!--Ends-->

