<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import=" ePH.*,java.util.*, eOR.*,eOR.Common.* , ePH.Common.* , eCommon.Common.*, java.text.*,java.lang.*, java.util.*,java.lang.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
 
<html>
<head>
<%
/*
--------------------------------------------------------------------------------------------------------------
Date			Edit History		Name		Rev.Date		Rev.Name				Description
--------------------------------------------------------------------------------------------------------------
1/6/2020	  	  IN072753          Prabha											   NMC-JD-CRF-0046 
*/
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
	    String locale			= (String)session.getAttribute("LOCALE");
	    
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

	<link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/dchk.js"></script>
	<script language="javascript" src="../../ePH/js/OncologyRegimen.js"></script>
	<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../ePH/js/PhCommon.js"></script>
	<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	String patient_id				= request.getParameter("patient_id")== null ? "":request.getParameter("patient_id");	
	String encounter_id				= request.getParameter("encounter_id")== null ? "":request.getParameter("encounter_id");		
//	String patient_class				= request.getParameter("patient_class")== null ? "":request.getParameter("patient_class");//Commented for Ml-mmoh-crf-0345		
	String start_date				= request.getParameter("start_date")== null ? "":request.getParameter("start_date");
	
	String comp_durn_value		    = request.getParameter("comp_durn_value")== null ? "":request.getParameter("comp_durn_value");	

	String amend_durn_type		    = request.getParameter("comp_durn_type")== null ? "":request.getParameter("comp_durn_type");		
	String disp_durn_type		    = amend_durn_type;	
	String serialNum			    = request.getParameter("serial_no") == null ? "":request.getParameter("serial_no");	
	String amend_serial_no          = request.getParameter("amend_serial_no") == null ? "":request.getParameter("amend_serial_no");
	String infuseovervalue			= request.getParameter("infuseovervalue") == null ? "":request.getParameter("infuseovervalue");
	String infuseoverdurntype		= request.getParameter("infuseoverdurntype") == null ? "":request.getParameter("infuseoverdurntype");
	String fluid_frame_display_yn	= request.getParameter("fluid_frame_display_yn") == null ? "":request.getParameter("fluid_frame_display_yn");
	String drug_unit		= request.getParameter("stock_uom_val") == null ? "":request.getParameter("stock_uom_val"); 
	String mfr_yn_value			= request.getParameter("mfr_yn_value")==null?"N":request.getParameter("mfr_yn_value");//ML-MMOH-CRF-1014
	String bean_id					= "@OncologyRegimenBean"+patient_id+encounter_id;
	String bean_name				= "ePH.OncologyRegimenBean";
	OncologyRegimenBean bean		= (OncologyRegimenBean)getBeanObject( bean_id, bean_name, request ) ;
	String or_bean_id				= "@orderentrybean"+patient_id+encounter_id;
	String or_bean_name				= "eOR.OrderEntryBean";
	OrderEntryBean ORbean			= (OrderEntryBean)getBeanObject( or_bean_id, or_bean_name , request) ;
	String locn_type				= (String)ORbean.getLocationType();
	String locn_code				= (String)ORbean.getLocationCode();
	String pract_id					= (String)ORbean.getPractitionerId();
	start_date						= bean.getOrderDate() ;
	
	//start of NMC-JD-CRF-0046
	String ext_disp_appl_yn=""; 
	String  disp_loc=(String)bean.getDispLocnCode(); 
	ext_disp_appl_yn =(String) bean.getExtDispYN(disp_loc);
    //end of NMC-JD-CRF-0046
	
	String site_spec_YN="N";//ADDED FOR ML-MMOH-CRF-1224
	boolean site_spec				= bean.isSiteSpecific("OR", "OR_ORDER_SET");//adDED FOR ml-MMOH-CRF-0345
	if(site_spec){//ADDED FOR ML-MMOH-CRF-1224
		site_spec_YN="Y";
	}
	String amend_frequency			= "";
	String amend_start_date			= "";
	String amend_end_date			= "";
	String amend_sched_medn_yn		= "N";
	String amend_infusion_period_value= "";
	String amend_infusion_period_uom= "";
    String facility_id				=(String)session.getValue("facility_id");
	String repeat_value			    ="";
	String drug_code				="";
	String srl_no					="";
	String order_catalog_code		="";
	String iv_fluid_yn				="";
	String iv_ingredient_yn			="";
	String visibility				="visibility:visible";
	String admixture_visibility		="visibility:visible";
	String drug_infuse_over_uom_text="";	
	String amend_infusion_over_value="";
	String amend_yn		        	="";
	String freq_code                ="";
	String freq_nature			    ="";
	String chk_addmixture           ="";
	String alert_practitioner_yn    ="";	
	String disable_addmixture       ="";
	//String time_flag                ="";
	String addmixture_checked       ="checked"; 
	String addmixture_value         ="Y";
	String order_type_flag		    ="";
	String durn_selected1           ="";
	String durn_selected2           ="";
	String durn_selected3           ="";
	String durn_selected4           ="";
	String durn_selected5			="";
//	String durn_selected6			="";
	String iv_prep_yn               ="0";
	String limit_ind			    ="";
	String allergy_yn			    ="";
	String current_rx			    ="";
	String amend_dup_drug           =""; 
	String order_id					="";
	String scheduled_yn				="";
	String perform_external_database_checks_yn = "N";
	String ext_prod_id				="";
	String ocurrance_num			="";

	String buildMAR_yn				= "";
	String MAR_app_yn				= "";
	String buildMAR_checked			= "";
	// RUT-CRF-0062 [IN029600] Added to get Build MAR Rule CRF 0062 -- begin
	String buildMAR_rule			= "";    
	String buildMAR_enable			= "";
	String cycle_freq_yn			= "Y"; //ML-MMOH-CRF-0345 
	String no_of_cycle			= "";//ML-MMOH-CRF-0345 
	// RUT-CRF-0062 [IN029600] Added to get Build MAR Rule CRF 0062 -- end
		/* Commented for SRR20056-CRF-0649.1 to (deselect)enable BuildMAR fo rIP
	String buildMAR_enable			= "";
		 SRR20056-CRF-0649.1 */
	Hashtable DurnDescDetails		=   new Hashtable();	
	String	duration_option			= "";
	String	freq_chng_durn_desc		= "";
	String	repeat_durn_type		= "";
	//ML-MMOH-CRF-1014 - start
	String  def_freq_code			= "";
	String  def_durn_type			= "";
	String  def_durn_value			= "";
	//ML-MMOH-CRF-1014 - end
	MAR_app_yn = request.getParameter("MAR_app_yn")==null?"":request.getParameter("MAR_app_yn");
	buildMAR_yn = bean.getBuildMAR_yn();
	/* RUT-CRF-0062 [IN029600] Commented to assign value to Build MAR with Build MAR Rule  -- begin	 
	if(buildMAR_yn == null || buildMAR_yn.equals("")){
		bean.setBuildMAR_yn(MAR_app_yn);
		buildMAR_yn = MAR_app_yn;
	}
	//if(MAR_app_yn.equals("Y")){
		/* Commented for SRR20056-CRF-0649.1 to (deselect)enable BuildMAR fo rIP
		if(patient_class.equals("IP"))
			buildMAR_enable ="disabled";
		 SRR20056-CRF-0649.1 */
	/* 
			if(buildMAR_yn.equals("Y"))
			buildMAR_checked ="Checked";
		else
			buildMAR_checked ="";
	// RUT-CRF-0062 [IN029600] Added to get Build MAR Rule  --  end  */
	//}

	DurnDescDetails	= (Hashtable)bean.loadDurnDesc();	
	Enumeration keys_des		= DurnDescDetails.keys();
	String	durn_code			= "";
	while(keys_des.hasMoreElements())	{
		durn_code		= (String)keys_des.nextElement();		
		duration_option	= duration_option + "<option value='"+durn_code+"'>"+((String)DurnDescDetails.get(durn_code))+"</option>";		
	}

	if(!serialNum.equals("")){
			int srlNo						= 0;
			srlNo							= Integer.parseInt(serialNum);
			ArrayList drugList				= bean.getDrugDetails();
//			String form_code				= "";//Unused variable
			
		if(drugList!=null){
			HashMap drugDetails				= (HashMap)drugList.get(srlNo-1);
			drug_code			            = (String)drugDetails.get("DRUG_CODE");			
			ocurrance_num			        = (String)drugDetails.get("OCURRANCE_NUM")==null?"":(String)drugDetails.get("OCURRANCE_NUM");;			
			ArrayList doseValues		    = (ArrayList)bean.getDoseValues(drug_code,patient_id);
			order_catalog_code				= (String)drugDetails.get("ORDER_CATALOG_CODE"); 
			iv_fluid_yn						= (String)drugDetails.get("IV_FLUID_YN");
			iv_ingredient_yn				= (String)drugDetails.get("IV_INGREDIENT_YN");
			limit_ind						= (String)drugDetails.get("LIMIT_IND");
		    allergy_yn						= (String)drugDetails.get("ALLERGY_YN");
		    current_rx						= (String)drugDetails.get("CURRENT_RX");
			scheduled_yn					= (String) drugDetails.get("SCHEDULED_YN");
			repeat_value					= (String) drugDetails.get("REPEAT_VALUE")==null?"1":(String) drugDetails.get("REPEAT_VALUE"); //ML-MMOH-CRF-0345 
		/*	RUT-CRF-0062 [IN029600] Commented to get Build MAR Rule -- begin
		
			if(drugDetails.get("buildMAR_yn")==null){
				drugDetails.put("buildMAR_yn",MAR_app_yn);
			}
			buildMAR_yn = (String) drugDetails.get("buildMAR_yn");
			
			if(MAR_app_yn.equals("Y")){
		// Commented for SRR20056-CRF-0649.1 to (deselect)enable BuildMAR fo rIP
				if(patient_class.equals("IP"))
					buildMAR_enable ="disabled";
		 SRR20056-CRF-0649.1 
				if(buildMAR_yn.equals("Y"))
					buildMAR_checked ="Checked";
				else
					buildMAR_checked ="";
			}
		*/
				buildMAR_yn = (String) drugDetails.get("buildMAR_yn");
				buildMAR_rule=(String) drugDetails.get("BUILD_MAR_RULE")==null?"":(String) drugDetails.get("BUILD_MAR_RULE");
				
				if(buildMAR_yn==null || buildMAR_yn.equals(""))	{
					if(buildMAR_rule.equals("CE") || buildMAR_rule.equals("CD")){
						buildMAR_checked="checked";
						buildMAR_yn="Y";
					}
					else if(buildMAR_rule.equals("UE") || buildMAR_rule.equals("UD")){
						buildMAR_checked="";
						buildMAR_yn="N";
					}
				}
				else
				{
					if(buildMAR_yn.equals("Y"))
						buildMAR_checked ="checked";		
					else
						buildMAR_checked ="";		
				}
				if(buildMAR_rule.equals("CE") || buildMAR_rule.equals("UE")){
						buildMAR_enable="";
				}
				else if(buildMAR_rule.equals("CD") || buildMAR_rule.equals("UD")){
						buildMAR_enable="disabled";
				}
						if(ext_disp_appl_yn.equals("Y")) //Added for NMC-JD-CRF-0046
						{
							buildMAR_checked ="";	
							buildMAR_enable="disabled";
							buildMAR_yn="N";
						}
						
						bean.setBuildMAR_yn(buildMAR_yn);
				
			  // RUT-CRF-0062 [IN029600] Added to get Build MAR Rule -- end  

			freq_chng_durn_desc = (String)drugDetails.get("REPEAT_DURN_TYPE");
			repeat_durn_type    = (String)drugDetails.get("REPEAT_DURN_TYPE");
//ML-MMOH-CRF-1014 - start
			def_freq_code					= (String)drugDetails.get("def_freq_code")==null?"":(String) drugDetails.get("def_freq_code");
			def_durn_type					= (String)drugDetails.get("def_durn_type")==null?"":(String) drugDetails.get("def_durn_type");
			def_durn_value					= (String)drugDetails.get("def_durn_value")==null?"":(String) drugDetails.get("def_durn_value");
//ML-MMOH-CRF-1014 - end
			if ( drugDetails.containsKey("amend_durn_value" )){
				
				amend_frequency				= (String)drugDetails.get("amend_frequency")== null ? "":(String)drugDetails.get("amend_frequency");
				amend_sched_medn_yn			= (String)drugDetails.get("amend_sched_medn_yn")== null ? "":(String)drugDetails.get("amend_sched_medn_yn");
				comp_durn_value				= (String)drugDetails.get("amend_durn_value")== null ? "":(String)drugDetails.get("amend_durn_value");


				amend_durn_type				= (String)drugDetails.get("amend_durn_unit")== null ? "":(String)drugDetails.get("amend_durn_unit");
				disp_durn_type = amend_durn_type.equals("")?disp_durn_type:amend_durn_type;
				amend_end_date				= (String)drugDetails.get("amend_end_date")== null ? "":(String)drugDetails.get("amend_end_date");
				
				amend_start_date			= (String)drugDetails.get("amend_start_date")== null ? "":com.ehis.util.DateUtils.convertDate((String)drugDetails.get("amend_start_date"),"DMYHM","en",locale); //Date conversion done for amend_start_date regarding incident num:24401 on 13/Oct/2010==By Sandhya

				if(amend_sched_medn_yn==null || amend_sched_medn_yn.equals(""))
					amend_sched_medn_yn 	= "N";
				else
					amend_sched_medn_yn 	= "Y" ;           

			if(amend_start_date==null || amend_start_date.equals("null") || amend_start_date.equals(""))
				start_date = start_date;
			else
				start_date = amend_start_date;
			
			}

            if( (iv_fluid_yn.equals("N"))&&(iv_ingredient_yn.equals("N"))){
				 visibility					="visibility:hidden";
				 admixture_visibility		="visibility:hidden";
				 fluid_frame_display_yn		="N";
				 iv_prep_yn ="9"; //added for IN26040 reopen --31/01/2011-- priya
            
		     }
			 else if( (iv_fluid_yn.equals("Y"))&&(iv_ingredient_yn.equals("Y"))||((iv_fluid_yn.equals("Y"))&&(iv_ingredient_yn.equals("N")))){             
				 admixture_visibility		="visibility:hidden";
				 amend_infusion_over_value	=(String)drugDetails.get("DRUG_INFUSE_OVER_VALUE");
				 amend_infusion_period_uom	=(String)drugDetails.get("DRUG_INFUSE_OVER_DURN_TYPE");		
				 drug_unit					= (String)doseValues.get(6);
				  iv_prep_yn ="9"; //added for IN26040 reopen(2) --01/02/2011-- priya
		    }

			perform_external_database_checks_yn = (String)drugDetails.get("PERFORM_EXTERNAL_DATABASE_CHECKS");
			ext_prod_id							= (String)drugDetails.get("EXTERNAL_PRODUCT_ID");
			 
	/*==============================Amend=======================================*/
			
		     HashMap Existingrecord;
		     order_type_flag		= request.getParameter("order_type_flag") == null ? "":request.getParameter("order_type_flag");
	/*=========================================================================*/             
	/***************************************************************************
	  New Enhancement for malasiya :Code for validating IVADMIXTURE APPLICAPABLE 
	  and FROM_TIME and TO_TIME in PHPARAMETER FOR FACILITY UNDER IVADMIXTURE TAB
	  starts   
	***************************************************************************/
			HashMap record1;
			record1=new HashMap(); 
				record1=bean.ChkAdMixture();
				chk_addmixture=(String)record1.get("CDR_ADMIXTURE_APPL_YN");
				if(chk_addmixture.equals("N")){
					disable_addmixture	="Disabled";
				}else{
					disable_addmixture	="";
				}
			if(!order_type_flag.equals("Existing")){   
			
				alert_practitioner_yn=(String)record1.get("ALERT_PRACTITIONER_YN");
				if(chk_addmixture.equals("N")){
				   addmixture_checked	="";
				   addmixture_value		="N";
				   iv_prep_yn = "9"; //added while fixing IN26040 reopen(2) --01/02/2011-- priya
				}
				else{
				   addmixture_checked	="checked";
				   addmixture_value		="Y";
				 //  time_flag			=(String)record1.get("time_flag");
				}
			}
	/****************Endshere**************************************************/
			
			amend_yn	    = (String)drugDetails.get("AMEND_YN");
			if(amend_yn.equals("Y")){
				 amend_infusion_period_value=(String)drugDetails.get("amend_infusion_rate");      amend_infusion_over_value=(String)drugDetails.get("amend_infusion_period_value");	  amend_infusion_period_uom=(String)drugDetails.get("amend_infusion_period_uom");
				 freq_code=(String)drugDetails.get("amend_frequency");
			}
			else{
				freq_code=(String)drugDetails.get("COMP_FREQ_CODE"); 
				if(freq_code==null || freq_code.equals(""))
					freq_code=(String)drugDetails.get("FREQ_CODE"); 
				comp_durn_value = (String)drugDetails.get("COMP_DURN_VALUE")==null?comp_durn_value:(String)drugDetails.get("COMP_DURN_VALUE");
				amend_infusion_period_uom=(String)drugDetails.get("DRUG_INFUSE_OVER_DURN_TYPE");	//added for ml-mmoh-crf-1223
			}
			scheduled_yn = bean.getScheduledFreqYN(freq_code)+"";
			if(scheduled_yn.equals("true")) 
				scheduled_yn = "Y";
			freq_nature = bean.getFrequencyNature();
          /*------------------------------Amend--------------------------------------*/
			if(order_type_flag.equals("Existing")){
				ArrayList getExistingCYTORecords = bean.getExistingCYTORecords();	
				if(!amend_serial_no.equals("")){
					//srlNo					      = Integer.parseInt(serialNum);
					srlNo					      = Integer.parseInt(amend_serial_no);
					if(fluid_frame_display_yn.equals("Y")){
					    srlNo					      = Integer.parseInt(amend_serial_no)+1;
					}
					Existingrecord	          = (HashMap) getExistingCYTORecords.get(srlNo);
					if(amend_yn.equals("N")){

						amend_infusion_period_value = (String)Existingrecord.get("INFUSION_RATE")==null?"":(String)Existingrecord.get("INFUSION_RATE");
						amend_infusion_over_value	  = (String)Existingrecord.get("INFUSE_OVER")==null?"":(String)Existingrecord.get("INFUSE_OVER");
						amend_infusion_period_uom   = (String)Existingrecord.get("INFUSION_PER_UNIT")==null?"":(String)Existingrecord.get("INFUSION_PER_UNIT");
						comp_durn_value             = (String)Existingrecord.get("DURN_VALUE")==null?"":(String)Existingrecord.get("DURN_VALUE");
						amend_end_date				= (String)Existingrecord.get("END_DATE_TIME");
						amend_start_date            = (String)Existingrecord.get("START_DATE_TIME");
						amend_durn_type             = (String)Existingrecord.get("DURN_TYPE");
						buildMAR_yn		= (String)Existingrecord.get("buildMAR_yn")==null?"":(String) Existingrecord.get("buildMAR_yn"); // RUT-CRF-0062 [IN029600]
						disp_durn_type =amend_durn_type;
						repeat_durn_type = disp_durn_type;//added for ML-MOH-CRF-0345
					}
					/*amend_end_date				= (String)Existingrecord.get("END_DATE_TIME");
					amend_start_date            = (String)Existingrecord.get("START_DATE_TIME");
					amend_durn_type             = (String)Existingrecord.get("DURN_TYPE");
					disp_durn_type				=  amend_durn_type;*/

					if(amend_yn.equals("N")){
						amend_frequency             = (String)Existingrecord.get("FREQ_CODE");			 
						scheduled_yn = bean.getScheduledFreqYN(amend_frequency)+"";
						if(scheduled_yn.equals("true"))
							scheduled_yn = "Y";
						freq_nature  = bean.getFrequencyNature();
						freq_code  = amend_frequency;			  
					}

					iv_prep_yn 				  = (String)Existingrecord.get("IV_PREP_YN");
					drug_unit                   = (String)Existingrecord.get("INFUSION_VOL_STR_UNIT"); 
					order_id                    =  (String)Existingrecord.get("ORDER_ID"); 
					amend_dup_drug			  = java.net.URLDecoder.decode( (String)Existingrecord.get("DUPLICATE_DRUG_OVERRIDE_REASON"));	
					if(!amend_dup_drug.equals("")){
						//current_rx="Y";
					}
					else{
						//current_rx="N";
					}
					start_date=amend_start_date;

					if(MAR_app_yn.equals("Y")){
		/* Commented for SRR20056-CRF-0649.1 to (deselect)enable BuildMAR fo rIP
						buildMAR_enable ="disabled";
		 SRR20056-CRF-0649.1 
						if(buildMAR_yn.equals("Y"))
							buildMAR_checked ="Checked";
						else
							buildMAR_checked ="";
							*/
			 				
			 // RUT-CRF-0062 [IN029600]   Added to get Build MAR Rule -- begin
			 
							if(buildMAR_yn.equals("Y"))
								buildMAR_checked ="Checked";
							else
								buildMAR_checked ="";
			 
							buildMAR_rule=Existingrecord.get("BUILD_MAR_RULE").toString();  // Based on Build MAR Rule Enable / Disable Property assigned.
				
							if(buildMAR_rule.equals("CE")){
								buildMAR_enable="";
							}
							else if(buildMAR_rule.equals("UE")){
								buildMAR_enable="";
							}
							else if(buildMAR_rule.equals("CD")){
								buildMAR_enable="disabled";
							}
							else if(buildMAR_rule.equals("UD")){
								buildMAR_enable="disabled";
								//buildMAR_checked ="";
							}
							
							if(ext_disp_appl_yn.equals("Y"))   //ADDED FOR NMC-JD-CRF-0046--AMEND ORDER
							{
								buildMAR_enable="disabled";
								buildMAR_checked="";
								buildMAR_yn ="N";
							}
							
							bean.setBuildMAR_yn(buildMAR_yn);
							
			  // RUT-CRF-0062 [IN029600] Added to get Build MAR Rule -- end  
							
					}
				
				}
			} 

			if(drugDetails.containsKey("IV_PREP_YN")){
				 iv_prep_yn		=(String)drugDetails.get("IV_PREP_YN");
			}
            if( iv_prep_yn.equals("0")&&chk_addmixture.equals("Y")){
				addmixture_checked="checked";
				addmixture_value  ="Y";

			 }
			 else if( iv_prep_yn.equals("9")){
				addmixture_checked	="";
				addmixture_value	="N";
		     }
		  /*-------------------------------------------------------------------------*/
			if(amend_infusion_period_uom.equals("D")){
				drug_infuse_over_uom_text=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.days.label","common_labels");
			}
			else if(amend_infusion_period_uom.equals("M")){
				drug_infuse_over_uom_text=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Minutes.label","common_labels");
			}
			else if(amend_infusion_period_uom.equals("H")){
				drug_infuse_over_uom_text=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.hours.label","common_labels");
			}
			else{
				drug_infuse_over_uom_text=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Minutes.label","common_labels");     
			}
			if(amend_durn_type.equals("D")){
				durn_selected3	="selected" ;
			}
			else if(amend_durn_type.equals("M")){
				durn_selected1	="selected" ;
			}
			else if(amend_durn_type.equals("H")){
				durn_selected2	="selected" ;                 
			}
			else if(amend_durn_type.equals("L")){
				durn_selected4	="selected" ;                 
			}else if(amend_durn_type.equals("W")){
				durn_selected5	="selected" ;                 
			} 
			//else if(amend_durn_type.equals("Y")){
				//durn_selected6	="selected" ;                 
			//} 
		}
	}	
%>

<!-- 	<body> -->
<body onMouseDown="" onKeyDown="lockKey()">
		<form name="oncologyRegimenAdminDetail" id="oncologyRegimenAdminDetail">
			<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0">
				<th colspan="6"><font style="font-size:9"><fmt:message key="ePH.AdminDetails.label" bundle="${ph_labels}"/></font></th>
<%
					if(!visibility.equals("visibility:hidden")){
						
%>
						<tr NOWRAP>
		
							<td  class="label" nowrap style='<%=visibility%>' COLSPAN=2 id="InfusionRate"><fmt:message key="ePH.InfusionRate.label" bundle="${ph_labels}"/>&nbsp;
								<input type="text" name="infusion_rate" id="infusion_rate"  value="<%=amend_infusion_period_value%>" size="2" maxlength="9" class="number"  onBlur="checkValue(this);calInfuseOver()" onKeyPress="return allowValidNumber(this,event,6,2);"><label width='5%'class='label' id="infuse_rate_uom"><b><%=drug_unit%></b></label>
								<label class='label'><b>/</b></label>
								<select name="infusion_period_uom" id="infusion_period_uom" onChange="ChangeInfuseOverTime(this)">
<%			
									if(amend_infusion_period_uom!=null && amend_infusion_period_uom.equals("M")){
%>
										<option value="M" SELECTED><fmt:message key="Common.Minute.label" bundle="${common_labels}"/></option>
										<option value="H"><fmt:message key="Common.hours.label" bundle="${common_labels}"/></option>
									<!--	<option value="D"><fmt:message key="Common.day.label" bundle="${common_labels}"/></option>-->
<%
									}
									else if(amend_infusion_period_uom!=null && amend_infusion_period_uom.equals("H")){
%>
										<option value="M" ><fmt:message key="Common.Minute.label" bundle="${common_labels}"/></option>
										<option value="H" SELECTED><fmt:message key="Common.hours.label" bundle="${common_labels}"/></option>
									<!--<option value="D"><fmt:message key="Common.day.label" bundle="${common_labels}"/></option>-->
<%
									} 
									else if(amend_infusion_period_uom!=null && amend_infusion_period_uom.equals("D")){
%>
										<option value="M" ><fmt:message key="Common.Minute.label" bundle="${common_labels}"/></option>
										<option value="H"><fmt:message key="Common.hours.label" bundle="${common_labels}"/></option>
										<!-- <option value="D" SELECTED><fmt:message key="Common.day.label" bundle="${common_labels}"/></option> -->
<%			
									}
									else {
%>
										<option value="M"><fmt:message key="Common.Minute.label" bundle="${common_labels}"/></option>
										<option value="H"><fmt:message key="Common.hours.label" bundle="${common_labels}"/></option>
										<!-- <option value="D"><fmt:message key="Common.day.label" bundle="${common_labels}"/></option> -->
<%			
									}
%>
								</select><img src="../../eCommon/images/mandatory.gif" BORDER="0" id = "inf_rate_mand"></img>
							</td>
		
							<td class='label' nowrap ><font class=label style="<%=admixture_visibility%>"><fmt:message key="ePH.Admixture.label" bundle="${ph_labels}"/></font>&nbsp;<input type='checkbox' name='adMixture' id='adMixture'  <%=addmixture_checked%> value='<%=addmixture_value%>'  <%=disable_addmixture%> onclick="setvalue(this),checkadmixture(oncologyRegimenAdminDetail,'<%=site_spec%>','<%=fluid_frame_display_yn%>')" style="<%=admixture_visibility%>">&nbsp;
<%                  

								if(MAR_app_yn.equals("Y")){
									if(!ext_disp_appl_yn.equals("Y") || ext_disp_appl_yn.equals("")){ //Added For NMC-JD-CRF_0046
%>
	<!--  RUT-CRF-0062 [IN029600] Added buildMAR_enable  to get enable/ disable based on Build MAR Rule -->
									<fmt:message key="ePH.BuildMAR.label" bundle="${ph_labels}"/>&nbsp;
									<input type='checkbox' name='buildMAR_yn' id='buildMAR_yn' value='<%=buildMAR_yn%>' <%=buildMAR_checked%>  <%=buildMAR_enable%>  onclick='assignValue(this);'>
<%
								}
									else{ //Added For NMC-JD-CRF_0046
										%>
																
											<fmt:message key="ePH.BuildMAR.label" bundle="${ph_labels}"/>&nbsp;
											<input type='checkbox' name='buildMAR_yn' id='buildMAR_yn' value="N" disabled >
										<%	
										}
									}

								else{
%>
									
									<fmt:message key="ePH.BuildMAR.label" bundle="${ph_labels}"/>&nbsp;
									<input type='checkbox' name='buildMAR_yn' id='buildMAR_yn' value='N' disabled>
<%
								}
%>		
							
							<%if(site_spec){ //ML-MMOH-CRF-0345 

							if(order_type_flag.equals("Existing") && mfr_yn_value.equals("Y")){
								comp_durn_value = "";
							}
							%>
							<label nowrap style='color:red;font-size:10' id="dosage_label_cycle" onMouseOver="displayCycleToolTip('<%=drug_code%>','<%=serialNum%>')" onmouseout='disasbleToolTipDataChange1();'> Scheduled Dose</label>
							<%}%>
							</td>
							<td class='label' nowrap style='<%=visibility%>' id="InfusionOver"><fmt:message key="ePH.InfuseOver.label" bundle="${ph_labels}"/>&nbsp;
							<input type=text size=2 maxlength =9 name='infusion_period_value' id='infusion_period_value'  class="number" colspan="2"  value="<%=amend_infusion_over_value%>" onblur='calInfusionRate();' onKeyPress="return allowValidNumber(this,event,6,2);">&nbsp;
							<label width='5%'class='label' id="infuse_over_time"><b><%=drug_infuse_over_uom_text%></b></label>
							<br><label width='5%'class='label' id="infuse_over_str"></label>
							&nbsp;</td>
							 <input type=hidden  name="infuse_over_time_value" id="infuse_over_time_value" value="<%=amend_infusion_period_uom%>">
						</tr>
<%
					}
					else if(visibility.equals("visibility:hidden")){
						
%>
					   <tr height='30'>
						 <td class="label" colspan='2' >&nbsp;&nbsp;&nbsp;</td>
		<!--  RUT-CRF-0062 [IN029600] Added buildMAR_enable flag to get enable/ disable based on Build MAR Rule -->
						 <td class='label'><fmt:message key="ePH.BuildMAR.label" bundle="${ph_labels}"/> <input type='checkbox' name='buildMAR_yn' id='buildMAR_yn' value='<%=buildMAR_yn%>' <%=buildMAR_checked%>  <%=buildMAR_enable%>  onclick='assignValue(this);'  >
						<% if(cycle_freq_yn.equals("Y") && site_spec){ //ML-MMOH-CRF-0345 %>
						 <label nowrap style='color:red;font-size:10' id="dosage_label_cycle" onMouseOver="displayCycleToolTip('<%=drug_code%>','<%=serialNum%>')" onmouseout='disasbleToolTipDataChange1();'> Scheduled Dose</label>
						 <%}%>
						 </td>
						 <td class="label" >&nbsp;&nbsp;&nbsp;</td>
					  </tr>
<% 
				}
				 if(freq_nature.equals("Y")){ //ML-MMOH-CRF-0345 
				  no_of_cycle = bean.getMaxCycle(freq_code)+"";
				  comp_durn_value  = "1";
				 if(order_type_flag.equals("Existing"))
					 no_of_cycle = "1";
				 }
%>
				<tr nowrap>
					<td width="5%" class="label" id ="Frequency_lbl"><fmt:message key="Common.Frequency.label" bundle="${common_labels}"/></td>
					<td COLSPAN=3 id ="frequency_selection">
						<select name="frequency" id="frequency" onChange="checkScheduledYN(this.value);setSchedule();ExternalDosageCheck('','admndtl','<%=perform_external_database_checks_yn%>');changeDate();setCycleFreqDetails(this,'<%=site_spec%>')" style="width:500;" >
							<option value="">&nbsp;--- <fmt:message key="ePH.Select.label" bundle="${ph_labels}"/> ---&nbsp;</option>
<% 
							if(!serialNum.equals("")){
								ArrayList frequencies = bean.populateFrequencyValues(order_catalog_code);
								for (int i=0; i<frequencies.size(); i+=2) {
									if(freq_code.equalsIgnoreCase((String)frequencies.get(i)) ) {
%>
										<option value="<%= frequencies.get(i) %>" selected><%= frequencies.get(i+1) %></option>
<%
									}
									else { 
%>
										<option value="<%= frequencies.get(i) %>"><%= frequencies.get(i+1) %></option>
<%	
									}
								}
							}
%>
						</select><img src="../../eCommon/images/mandatory.gif" border="0" id = "freq_mand"></img>&nbsp;
					<%
					if(!freq_nature.equals("Y") && site_spec!=true){//ML-MMOH-CRF-0345 
					%>
					<input type="button" name="btn_schedule" id="btn_schedule" value='<fmt:message key="Common.Schedule.label" bundle="${common_labels}"/>' class="button" onClick="DisplaySchedule()">
					<%}else{%>
						<input type="button" name="btn_schedule_cycle" id="btn_schedule_cycle" value='Cycle' class="button" onClick="DisplayCycle('<%=drug_code%>','<%=serialNum%>','<%=no_of_cycle%>')">
					<%}%>
						<input type="hidden" name="sched_medn_yn" id="sched_medn_yn" value="N">
					</td>
				</tr>
				 <tr>
					<td class="label" id ="duration_lbl"><fmt:message key="Common.duration.label" bundle="${common_labels}"/></TD>
					<td  COLSPAN=2><input type="text" name="durn_value" id="durn_value" value="<%=comp_durn_value%>" size="5" maxlength="6" class="number"  onBlur="chkDuration(this,true);ExternalDosageCheck('','admndtl','<%=perform_external_database_checks_yn%>')" onKeyPress="return allowValidNumber(this,event,5,0);">
						<select name="durn_unit" id="durn_unit"  onChange="chkDuration(document.oncologyRegimenAdminDetail.durn_value,true);checkScheduledYN(document.oncologyRegimenAdminDetail.frequency.value);	" >
						<%=duration_option%>							
						</select><img src="../../eCommon/images/mandatory.gif" border="0" id = "durn_mand"></img>&nbsp;
					
		<%
				if(!order_type_flag.equals("Existing")){	
		%>
					<A HREF onMouseOver="changeCursor(this);" onClick=" showOverRideRemarks('<%=serialNum%>');" style="font-size:10;font-weight:bold;color:blue;visibility:hidden"  id="dosage_label"><fmt:message key="ePH.OverrideReason.label" bundle="${ph_labels}"/></A>&nbsp;<img src="../../eCommon/images/mandatory.gif" BORDER="0" id="mand2"  style="visibility:hidden"></img></td>
		<%
				}
				else{
		%>
					 <A HREF onMouseOver="changeCursor(this);" onClick=" showOverRideRemarks('<%=amend_serial_no%>');" style="font-size:10;font-weight:bold;color:blue;visibility:hidden"  id="dosage_label"><fmt:message key="ePH.OverrideReason.label" bundle="${ph_labels}"/></A>&nbsp;<img src="../../eCommon/images/mandatory.gif" BORDER="0" id="mand2"  style="visibility:hidden"></img></td>
		<%
				}

		


		%>
				
		</tr>
		 <tr>
		
		<td  class="label" nowrap id ="StartDateLbl"><fmt:message key="Common.StartDate.label" bundle="${common_labels}"/></td>			
		<td ><!-- setCycleFreqDetails added for ml-mmoh-scf-1050  -->
			<input type="text" name="start_date" id="start_date" value="<%=start_date%>" SIZE="13" MAXLENGTH="16" onBlur="if(CheckDateLeap(this,'DMYHM','<%=locale%>')){changeDate();}setCycleFreqDetails(oncologyRegimenAdminDetail.frequency,'<%=site_spec%>')"> 
			<!-- validateDate(this) changed to CheckDateLeap for RollForward from SRR - SRR20056-SCF-9366[IN 57051] -->
			<IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="showCalendar('start_date',null,'hh:mm');
			document.oncologyRegimenAdminDetail.start_date.focus();return false;" > 
			<img src="../../eCommon/images/mandatory.gif" BORDER="0" id="start_date_mand"></img>
		</td>		
		<td  class="label" nowrap id="end_date_lbl"><fmt:message key="Common.enddate.label" bundle="${common_labels}"/>&nbsp;
		<input type="text" name="end_date" id="end_date" value="<%=amend_end_date%>" size="13" maxlength="16" readonly>
		<input type="hidden" name="ocurrance_num" id="ocurrance_num" value="<%=ocurrance_num%>" ><!--//ML-MMOH-CRF-1014 -->
		</td>
		</tr>
		<tr>
		<tr height='30'><td class="label" colspan='6' >&nbsp;&nbsp;&nbsp;</td></tr>  
		</tr>
		<tr>
		<tr height='30'><td class="label" colspan='6' >&nbsp;&nbsp;&nbsp;</td></tr>  
		</tr>
		</table>
	
		<input type="hidden" name="iv_prep_yn" id="iv_prep_yn" value="<%= iv_prep_yn %>">
		<input type="hidden" name="perform_external_database_checks_yn" id="perform_external_database_checks_yn" value="<%= perform_external_database_checks_yn%>">
		<input type="hidden" name="bean_id" id="bean_id" value="<%= bean_id %>">
		<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
		<input type="hidden" name="locn_type" id="locn_type" value="<%= locn_type %>">
		<input type="hidden" name="locn_code" id="locn_code" value="<%= locn_code %>">
		<input type="hidden" name="pract_id" id="pract_id" value="<%= pract_id %>">
		<input type="hidden" name="repeat_value" id="repeat_value" value="">
		<input type="hidden" name="freq_nature" id="freq_nature" value="<%=freq_nature%>">
		<input type="hidden" name="schedulereqdyn" id="schedulereqdyn" value="N">
		<input type="hidden" name="facility_id" id="facility_id" value="<%=facility_id%>">
		<input type="hidden" name="overridereason_mand" id="overridereason_mand"	value="N">
		<input type="hidden" name="overridereason_flag" id="overridereason_flag"	value="N">
		<input type="hidden" name="srlNo" id="srlNo"	value="<%=serialNum%>">
		<input type="hidden" name="freq_chng_durn_desc" id="freq_chng_durn_desc" value="<%=freq_chng_durn_desc%>">
		<input type="hidden" name="amend_durn_type" id="amend_durn_type" value="<%=amend_durn_type%>">
		<input type="hidden" name="amend_durn_value" id="amend_durn_value" value="<%=comp_durn_value%>">
		<input type="hidden" name="disp_durn_type" id="disp_durn_type" value="<%=disp_durn_type%>">
		<input type="hidden" name="repeat_durn_type" id="repeat_durn_type" value="<%=repeat_durn_type%>">
		<input type="hidden" name="no_of_cycle" id="no_of_cycle" value="<%=no_of_cycle%>"><!-- added for ML-MMOH-CRF-0345 -->
		<input type="hidden" name="drug_code" id="drug_code" value="<%=drug_code%>"><!-- added for ML-MMOH-CRF-0345 -->
		<input type="hidden" name="order_type_flag" id="order_type_flag" value="<%=order_type_flag%>"><!-- added for ML-MMOH-CRF-0345 -->
		<input type="hidden" name="Def_freq_code" id="Def_freq_code" value="<%=def_freq_code%>"><!-- ML-MMOH-CRF-1014 -->
		<input type="hidden" name="def_durn_type" id="def_durn_type" value="<%=def_durn_type%>"><!-- ML-MMOH-CRF-1014 -->
		<input type="hidden" name="def_durn_value" id="def_durn_value" value="<%=def_durn_value%>"><!-- ML-MMOH-CRF-1014 -->
		<input type="hidden" name="amend_yn" id="amend_yn" value="<%=amend_yn%>"><!-- ML-MMOH-CRF-1014 -->
		
		<input type="hidden" name="site_spec_YN" id="site_spec_YN" value="<%=site_spec_YN%>"><!-- ML-MMOH-CRF-1224 -->
		<input type="hidden" name="infusion_over_insert_value" id="infusion_over_insert_value" value="<%=amend_infusion_over_value%>"><!-- ML-MMOH-CRF-1014 -->
		<input type="hidden" name="mfr_yn_value" id="mfr_yn_value" value="<%=mfr_yn_value%>"><!-- ML-MMOH-CRF-1014 -->
		<!-- added for ML-MMOH-CRF-0345 -->
		<div name="tooltiplayer" id="tooltiplayer" style="position:absolute; width:40%; visibility:hidden;" bgcolor="blue">
			<table id="tooltiptable" cellpadding=0 cellspacing=0 border="0" width="auto" height="100%" align="center">
				<tr><td width="100%" id="t"></td></tr>
			</table>
		</div>
		
   
<%
	if(fluid_frame_display_yn.equals("Y")){
		if(amend_yn.equals("N")  ){
%>
			<script>

				defaultIVFluid(<%=order_type_flag.equals("Existing")%>);
			</script>
<%
		}
	}

	if(!order_type_flag.equals("Existing")){  	
		if(!amend_yn.equals("Y")){
			if(fluid_frame_display_yn.equals("Y")){
%> 
				 <script>	   
					setInfuseOverValue('<%=infuseovervalue%>','<%=infuseoverdurntype%>');
					
				 </script>
<%
			}
			if( ((iv_fluid_yn.equals("Y"))&&(iv_ingredient_yn.equals("Y")))||((iv_fluid_yn.equals("Y"))&&(iv_ingredient_yn.equals("N")))){%>
				<script>	
					calInfusionRate();
				</script>
<%
			}
			if(!serialNum.equals("")){
%>
				<script>

					setSchedule();
 				</script>
<%	
			}
		}
	}
	if(site_spec){//added for ICN66351
%>
	<script>
	if(document.oncologyRegimenAdminDetail.frequency.value==""){
		document.oncologyRegimenAdminDetail.btn_schedule_cycle.disabled = true;
	}else{
		document.oncologyRegimenAdminDetail.btn_schedule_cycle.disabled = false;
	}
	</script>
	
<%	}
if(!mfr_yn_value.equals("Y")){
%> 
	<script> 
	
		checkScheduledYN(document.oncologyRegimenAdminDetail.frequency.value);		
		chkDuration(document.oncologyRegimenAdminDetail.durn_value,true); 
		displayDispLocation('<%=iv_prep_yn%>');	</script>
<%  }
		//if(perform_external_database_checks_yn.equals("N")){

			if( (allergy_yn.equals("Y") || current_rx.equals("Y") ) || (perform_external_database_checks_yn.equals("N") && limit_ind.equals("N"))){
%>			<script>
				document.oncologyRegimenAdminDetail.dosage_label.style.visibility="visible";
				document.oncologyRegimenAdminDetail.overridereason_mand.value="Y";	
				document.oncologyRegimenAdminDetail.mand2.style.visibility="visible";	</script>		
			
<%	
			}
		//}
//		if(order_type_flag.equals("Existing")){
%> <script>
//			document.oncologyRegimenAdminDetail.all.mand2.style.visibility="hidden";	
<%
//		}
%>
    </script>

<% 

	if((order_type_flag.equals("Existing"))&&(amend_yn.equals("N"))){
		ArrayList schedule		= new ArrayList();
			//new ArrayList();
			//(ArrayList)bean.getScheduleFrequencyStr(drug_code+ocurrance_num,"0");	
		String sch_bean_id		= "OrScheduleFreq" ;
		String sch_bean_name	= "eOR.ScheduleFrequencyCompBean";
		Hashtable sch_output	=	null;
		Hashtable schedule_val	=	null;
		if(schedule.size()==0 && scheduled_yn.equals("Y") ) { 
			schedule_val	=	new Hashtable();
			ScheduleFrequencyCompBean schedule_bean =(ScheduleFrequencyCompBean)getBeanObject( sch_bean_id,sch_bean_name,request );
			schedule_bean.setLanguageId(locale);
			schedule_val.put("facility_id", (String)session.getValue("facility_id"));
			schedule_val.put("start_time_day_param", amend_start_date);
			schedule_val.put("module_id", "PH"); 
			schedule_val.put("split_dose_yn","N"); 
			schedule_val.put("split_qty","100");//qty_value
			schedule_val.put("freq_code",  amend_frequency );
			schedule_val.put("code",drug_code+ocurrance_num);
			sch_output	=	schedule_bean.setScheduleFrequencyDefault(schedule_val);
			sch_output.put("code",drug_code+ocurrance_num);
			sch_output.put("row_value",srl_no);
			sch_output.put("start_date_time",amend_start_date);

//			bean.setScheduleFrequencyStr(sch_output);
			putObjectInBean(sch_bean_id,schedule_bean,request);
		} 
		if(sch_output!=null && freq_nature.equals("F")){
		    repeat_value=bean.getrepeat_value(amend_frequency);
			sch_output.put("code",drug_code+ocurrance_num);
			sch_output.put("row_value",srl_no);
			sch_output.put("start_time_assign","");
			sch_output.put("repeat",repeat_value);

			ArrayList values	=	bean.getFreqDet(order_id,"1");

				ArrayList freqCharctValues = new ArrayList();
				ArrayList day_list = new ArrayList();
				ArrayList day_names = new ArrayList();
				ArrayList time_list = new ArrayList();
				ArrayList dose_list = new ArrayList();
				ArrayList<String> week_days	= new ArrayList<String>();
				week_days = bean.getDayOfWeek(amend_start_date); 
						  freqCharctValues = (ArrayList)sch_output.get(drug_code+ocurrance_num);	

					//	  day_list  = (ArrayList)freqCharctValues.get(1);
					//	  day_names = (ArrayList)freqCharctValues.get(2);
					//	  time_list = (ArrayList)freqCharctValues.get(3);
					//	  dose_list = (ArrayList)freqCharctValues.get(4);
							
				ArrayList tmp_freq_values = new ArrayList();
				
				for(int p=0; p<values.size(); p+=4) {
					time_list.add(values.get(p));
					dose_list.add(values.get(p+1));
//					time_list.add(values.get(p+2));
					day_list.add(values.get(p+3));
				}

				
				if(day_list.size()>0){
					for(int j=0;j<day_list.size();j++){
					if(!day_list.get(j).equals(""))
					{
						String temp = (String)day_list.get(j);
						if (temp == null || temp.equals(""))
						{
							temp = "0";
						}
						if (!temp.equals("0"))
						{
							day_names.add(week_days.get((Integer.parseInt(temp))-1));
						}
						
					}
					}
				}
				if(freqCharctValues != null && freqCharctValues.size()>0){
					tmp_freq_values.add(freqCharctValues.get(0));
					tmp_freq_values.add(day_list);
					tmp_freq_values.add(day_names);
					tmp_freq_values.add(time_list);
					tmp_freq_values.add(dose_list);
				}
sch_output.put(drug_code+ocurrance_num,tmp_freq_values);


		/*	int incr=0;
			for(int p=0; p<values.size(); p+=4) {
				incr++;

				sch_output.put("time"+(incr),values.get(p));
				sch_output.put("qty"+(incr),values.get(p+1));				
//				sch_output.put("admin_day"+(incr),values.get(p+3));
			}
			if(incr<=6) {
				for(int q=(incr+1); q<=6; q++) {
					sch_output.put("time"+(q),"");
					sch_output.put("qty"+(q),"");
//					sch_output.put("admin_day"+(q),"");
				}
			}*/
			bean.setScheduleFrequencyStr(sch_output);
			schedule		= bean.getScheduleFrequencyStr(drug_code+ocurrance_num,"0");
		}

	}

	if(amend_infusion_period_uom != null && amend_infusion_over_value != null && amend_infusion_period_uom != "" && amend_infusion_over_value != ""){
%>
	
	<script>
		st = getHrsMinStr('<%=amend_infusion_over_value%>','<%=amend_infusion_period_uom%>');
		document.getElementById("infuse_over_str").innerHTML = st;
	</script>
	<%}%>
	<script>

		assignDurnTypeList('<%=DurnDescDetails%>');

		reloadDurnTypeList('<%=disp_durn_type%>','<%=repeat_durn_type%>');
	</script>
<%
////added for IN26467 --11/02/2011-- priya
		if(!ext_prod_id.equals("") && perform_external_database_checks_yn.equals("Y"))
				{
 %>
		<script>ExternalDosageCheck('','admndtl','<%=perform_external_database_checks_yn%>');</script>
 <%
				}

 if(freq_nature.equals("Y")){ %>
 <script>
 document.oncologyRegimenAdminDetail.durn_value.disabled = true;
 document.oncologyRegimenAdminDetail.durn_unit.disabled = true; 
 </script>
 <%}
 %>
	
<script>
if(document.oncologyRegimenAdminDetail.frequency.value!="" ){ //added for ML-MMOH-CRF-0345  - start
<%
if(amend_yn.equals("N") && freq_nature.equals("Y")){
if(!order_type_flag.equals("Existing")){
bean.loadCycleFreqDetails(freq_code,facility_id,repeat_durn_type,repeat_value,start_date,drug_code,serialNum);
String endDate = bean.getOrderEndDate();//Added for ML-MMOH-CRF-0345
%>	
	document.oncologyRegimenAdminDetail.end_date.value = '<%=endDate%>';
<%}else{
	bean.loadAmendCycleFreqDetails(freq_code,facility_id,repeat_durn_type,repeat_value,start_date,drug_code,serialNum,order_id);
%>
	
document.oncologyRegimenAdminDetail.frequency.disabled = true;
<%
	String start_date_amend = bean.getAmendOrderStartDate().split("~")[0];
	String end_date_amend   = bean.getAmendOrderStartDate().split("~")[1];
%>	
	document.oncologyRegimenAdminDetail.end_date.value = '<%=start_date_amend%>';
	document.oncologyRegimenAdminDetail.end_date.value = '<%=end_date_amend%>';
<%}
}

%>
}//added for ML-MMOH-CRF-0345  - end

</script>

<%	
//System.err.println("OncologyRegimenAdminDetail.jsp==fluid_frame_display_yn==921==>"+fluid_frame_display_yn+"==-===site_spec==>"+site_spec);
	if(site_spec ){
	if(order_type_flag.equals("Existing")){//CRF-1014
		if(mfr_yn_value.equals("Y")){
%>
<script>
	parent.oncology_fluid.oncologyRegimenFluidDetail.MFR_YN_chk.disabled=true;
</script>
<%		}

	}
%>
<script>
		if(parent.oncology_fluid.oncologyRegimenFluidDetail.ongomfrLink){
			parent.oncology_fluid.oncologyRegimenFluidDetail.ongomfrLink.disabled=false;
		}

	if(document.oncologyRegimenAdminDetail.adMixture){
	if(document.oncologyRegimenAdminDetail.adMixture.checked==true){
		if(parent.oncology_fluid.oncologyRegimenFluidDetail!=undefined)
		parent.oncology_fluid.oncologyRegimenFluidDetail.MFR_YN.style.visibility = "hidden";
	}
	}

</script>
<%if(mfr_yn_value.equals("Y")){ // ML-MMOH-CRF-1014 
%>     
 <Script>
	parent.oncology_fluid.oncologyRegimenFluidDetail.MFR_YN_chk.onclick();
//    document.getElementById("Frequency_lbl").style.visibility	= "hidden";
//	document.getElementById("frequency_selection").style.visibility	= "hidden";
	document.oncologyRegimenAdminDetail.durn_value.value = "";
	displayDispLocation('<%=iv_prep_yn%>');
	if(document.oncologyRegimenAdminDetail.end_date.value=="")
		document.oncologyRegimenAdminDetail.end_date.value = '<%=amend_end_date%>';
<%
} 
}
%> </Script>
</form>
	</body>
</html>
<%
	putObjectInBean(bean_id,bean,request);
	putObjectInBean(or_bean_id,ORbean,request);
%>

