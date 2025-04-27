/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
/*
-----------------------------------------------------------------------
Date       Edit History      Name        		Description
-----------------------------------------------------------------------
?             100            ?           		created
29/07/2011    IN027169       Chowminya G        Incident No: IN027169 - <Orderformat Screen - js error, Mandatoriy fields check in 	dependency fields issue> 
25/08/2011	  IN026010	     Chowminya G        Incident No: IN026010 - <Orderformat Screen - Date time field - calendar action js error > 
27/09/2013	  IN043095		Nijitha S		CRF-OT-Bru-HIMS-CRF-004.2/02- Booking Priority field in not displayed for "System defined" order entry format item
26/12/2013    IN045903		 Nijitha S		    Alpha-OR-Script error is displayed for integer numeric type dependent field in Order format	
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       	Edit History     Name        	Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
02/07/2014	  IN049133	   Chowminya										CRF:Disallow user to enter the future date in the LMP date field
-------------------------------------------------------------------------------------------------------------------------------------------------------
*/
// Decision Support System, Order Entry Format Dependency
//Included oth_dependency_yn IN049133
//function checkDependency(obj, format_id, field_mnemonic, new_seq_num, seq_num, max_dependency_rows, dependency_yn, order_category, contr_msr_panel_id, contr_msr_mod_id, order_type_code, discr_msr_id, performing_facility_id, oper_side_appl_yn, specimen_def_yn, login_facility_id, sex,catalog_code)
 function checkDependency(obj, format_id, field_mnemonic, new_seq_num, seq_num, max_dependency_rows, dependency_yn, order_category, contr_msr_panel_id, contr_msr_mod_id, order_type_code, discr_msr_id, performing_facility_id, oper_side_appl_yn, specimen_def_yn, login_facility_id, sex,catalog_code,oth_dependency_yn)
 {
	var form = document.getElementById("OrderFormatForm");
	var field_type = form["field_type"+obj.name].value;
	//var field_type			 = eval("document.OrderFormatForm.field_type"+obj.name+".value");
  	var field_value			 = obj.value;
	//IN043095 Starts
	if(order_category=="OT" && field_type=="L" && field_mnemonic=="SURGERY_TYPE")
	{
		var field_values = field_value.split("||");	
		field_value = field_values[1];
	}	
	
	//IN043095 Ends
    var field_length	     = obj.name.length;
	
	var new_seq_num_length   = 0;
	if(new_seq_num <10)
		new_seq_num_length   = 1;
	else if(new_seq_num <100)
		new_seq_num_length   = 2;
	else 
		new_seq_num_length   = 3;
	
 	new_field_name			 = (obj.name).substring(0, (field_length-new_seq_num_length));
	
 	//IN049133 - Start
	if(oth_dependency_yn == undefined)
	{
		oth_dependency_yn = "N";
	}	
 	//if(dependency_yn=="Y")////IN049133 - end
	if(dependency_yn=="Y" || oth_dependency_yn == "Y") 
	{
		var bean_id		= document.OrderFormatForm.bean_id.value;
		var bean_name	= document.OrderFormatForm.bean_name.value;
		hideColumns(new_field_name, max_dependency_rows, new_seq_num); //Hide the columns
	 		if(field_type=="C") { 
 			if(obj.checked == true)
				field_value = "Yes";
			else if(obj.checked==false)
				field_value = "No";
		} else if(field_type=="L" || field_type=="R"){
 			if(obj.value=='') {
 				//hideColumns(new_field_name, max_dependency_rows, new_seq_num); //Hide the columns
				return;
			 } // End of obj.value!=''
		} 
		
 	 if(field_type=="E" || field_type=="T") // FOR DATE AND TIME, PASS THIS TO GET THE  VALIDATIONS
	    field_value		= "CURRENT_DATE_TIME";
	 else if (field_type=="D" )
		field_value		= "CURRENT_DATE";	
	// else if(field_type!="C" && field_type!="L" && field_type!="R")// For Quantity etc, make it null (not for List box and checkbox
	 //   field_value		= "";	// removing the value, to make it fire the validations
   		query_string	= "bean_id="+bean_id+"&bean_name="+bean_name+"&func_mode=CHECK_DEPENDENCY&field_value="+escape(field_value)+"&field_name="+escape(obj.name)+"&new_field_name="+escape(new_field_name)+"&catalog_code="+catalog_code
   		//var xmlDoc 		= new ActiveXObject( "Microsoft.XMLDom" ) ;
		//var xmlHttp 	= new ActiveXObject( "Microsoft.XMLHTTP" ) ;
		var xmlHttp = new XMLHttpRequest();
 		xmlStr			= "<root><SEARCH " ;
		xmlStr			+= "format_id=\""+ format_id +"\" " ;
		xmlStr			+= "field_mnemonic=\""+ field_mnemonic +"\" " ;
		xmlStr			+= "seq_num=\""+ seq_num +"\" " ;
		xmlStr			+= "new_seq_num=\""+ new_seq_num +"\" " ;
		xmlStr			+= "order_category=\""+ order_category +"\" " ;
		xmlStr			+= "contr_msr_panel_id=\""+ contr_msr_panel_id +"\" " ;
		xmlStr			+= "contr_msr_mod_id=\""+ contr_msr_mod_id +"\" " ;
		xmlStr			+= "order_type_code=\""+ order_type_code +"\" " ;
		xmlStr			+= "discr_msr_id=\""+ discr_msr_id +"\" " ;
		xmlStr			+= "performing_facility_id=\""+ performing_facility_id +"\" " ;
 		xmlStr			+= "login_facility_id=\""+login_facility_id+"\" " ;
		xmlStr			+= "sex=\""+sex+"\" " ;
		xmlStr			+= "catalog_code=\""+catalog_code+"\" " ;
		xmlStr			+= "oper_side_appl_yn=\""+ oper_side_appl_yn +"\" " ;
		xmlStr			+= "specimen_def_yn=\""+ specimen_def_yn +"\" " ;
		xmlStr			+= "field_type=\""+ field_type +"\" " ;
 		xmlStr			+= "max_dependency_rows=\""+ max_dependency_rows +"\" " ;
 		xmlStr			+= "oth_dependency_yn=\""+ oth_dependency_yn +"\" " ;
 		xmlStr 			+=" /></root>" ;
 		var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");

		xmlHttp.open( "POST", "OrderEntryOrderFormatDependency.jsp?"+query_string, false ) ;
		xmlHttp.send( xmlDoc ) ;
		responseText=xmlHttp.responseText ;
		eval( responseText ) ;
		
 	} // End of dependency_yn
	else
		hideColumns(new_field_name, max_dependency_rows, new_seq_num); //Hide the columns
 } // End of checkDependency

 function loadDecisionDependency(field_name, new_field_name, bean_id, bean_name, field_value, format_id, field_mnemonic, new_seq_num, seq_num, field_mnemonic_value, value_seq_num, field_mnemonic_value1, field_value_type, field_mnemonic_action, field_action_msg, oth_mnemonic_yn, order_category, contr_msr_panel_id, contr_msr_mod_id, order_type_code, discr_msr_id, performing_facility_id, oper_side_appl_yn, specimen_def_yn,  max_dependency_rows, login_facility_id, sex, notify_yn,catalog_code) {

	// var field_type		 = eval("document.OrderFormatForm.field_type"+field_name+".value");
	// var old_field_value	 = eval("document.OrderFormatForm."+field_name+".value");
	 var field_type			 = document.getElementById("field_type"+field_name).value;
	 var old_field_value	 = document.getElementById(field_name).value;
  	 var field_action_msg    = "APP-OR0300 "+field_action_msg;
 	 // if not checkbox and list box then do not display it here.
 	 if(field_mnemonic_action!=null && field_mnemonic_action!="N" && field_action_msg!=null && field_action_msg!="" && field_type!="D" && field_type!="T" && field_type!="E" && field_type!="N" && field_type!="I"){
		  alert(field_action_msg);
	 }

	 document.getElementById("field_mnemonic_action"+(field_name)).value = field_mnemonic_action;
	 document.getElementById("field_action_msg"+(field_name)).value		 = field_action_msg;
	 document.getElementById("notify_yn"+(field_name)).value			 = notify_yn;
	 document.getElementById("field_value_type"+(field_name)).value		 = field_value_type;

	 /* done by jerome
		 
	 eval("document.OrderFormatForm.field_mnemonic_action"+field_name+".value = field_mnemonic_action");
	 eval("document.OrderFormatForm.field_action_msg"+field_name+".value = field_action_msg");
	 eval("document.OrderFormatForm.notify_yn"+field_name+".value = notify_yn");
	 eval("document.OrderFormatForm.field_value_type"+field_name+".value = field_value_type");
	 */
	 
	 /*eval("document.OrderFormatForm.dependency_field_mnemonic_value"+field_name+".value = field_mnemonic_value");
	 eval("document.OrderFormatForm.dependency_value_seq_num"+field_name+".value = value_seq_num");
	 eval("document.OrderFormatForm.dependency_field_mnemonic_value1"+field_name+".value = field_mnemonic_value1");
	 eval("document.OrderFormatForm.dependency_field_value_type"+field_name+".value = field_value_type");
	 eval("document.OrderFormatForm.dependency_oth_mnemonic_yn"+field_name+".value = oth_mnemonic_yn");
	 */
	 //alert(oth_mnemonic_yn);
      if(oth_mnemonic_yn=="Y")
    	  {
		 	otherDependencyMnemonic(field_name, new_field_name, bean_id, bean_name, field_value, format_id, field_mnemonic, new_seq_num, seq_num, field_mnemonic_value, value_seq_num, order_category, contr_msr_panel_id, contr_msr_mod_id, order_type_code, discr_msr_id, performing_facility_id, oper_side_appl_yn, specimen_def_yn, login_facility_id, sex,catalog_code,field_type);
    	  }
	 else {
 		     hideColumns(new_field_name, max_dependency_rows, new_seq_num);
		  } // End of Else  oth_mnemonic
	 // Show the Validations if any required
	 if(field_type!="C" && field_type!="L" && field_type!="R" && field_mnemonic_action!="N") // checkboxes and list boxes avoid 
	 {
	  	 checkDependencyValidation(field_name, field_type, field_value_type, field_action_msg, field_mnemonic_value, field_mnemonic_value1,field_mnemonic_action);
	 }
} // End of loadDecisionDependency

// Decision Support System, Order Entry Format Dependency
function otherDependencyMnemonic(field_name, new_field_name, bean_id, bean_name, field_value, format_id, field_mnemonic, new_seq_num, seq_num, field_mnemonic_value, value_seq_num, order_category, contr_msr_panel_id, contr_msr_mod_id, order_type_code, discr_msr_id, performing_facility_id,  oper_side_appl_yn, specimen_def_yn, login_facility_id, sex,catalog_code,field_type){
  
		var patient_id	= document.OrderFormatForm.patient_id.value;
 	 	query_string	= "bean_id="+bean_id+"&bean_name="+bean_name+"&func_mode=POPULATE_OTH_MNEMONIC&field_value="+escape(field_value)+"&field_name="+escape(field_name)+"&new_field_name="+escape(new_field_name)+"&catalog_code="+catalog_code
	 	
	 	//var xmlDoc 		= new ActiveXObject( "Microsoft.XMLDom" ) ;
		//var xmlHttp 	= new ActiveXObject( "Microsoft.XMLHTTP" ) ;
		var xmlHttp = new XMLHttpRequest();
		xmlStr			= "<root><SEARCH " ;
		xmlStr			+= "patient_id=\""+ patient_id +"\" " ;
		xmlStr			+= "format_id=\""+ format_id +"\" " ;
		xmlStr			+= "field_mnemonic=\""+ field_mnemonic +"\" " ;
		xmlStr			+= "seq_num=\""+ seq_num +"\" " ;
		xmlStr			+= "new_seq_num=\""+ new_seq_num +"\" " ;
		xmlStr			+= "order_category=\""+ order_category +"\" " ;
		xmlStr			+= "contr_msr_panel_id=\""+ contr_msr_panel_id +"\" " ;
		xmlStr			+= "contr_msr_mod_id=\""+ contr_msr_mod_id +"\" " ;
		xmlStr			+= "order_type_code=\""+ order_type_code +"\" " ;
		xmlStr			+= "discr_msr_id=\""+ discr_msr_id +"\" " ;
		xmlStr			+= "performing_facility_id=\""+ performing_facility_id +"\" " ;
		xmlStr			+= "oper_side_appl_yn=\""+ oper_side_appl_yn +"\" " ;
		xmlStr			+= "specimen_def_yn=\""+ specimen_def_yn +"\" " ;
 		xmlStr			+= "field_mnemonic_value=\""+ field_mnemonic_value +"\" " ;
		xmlStr			+= "value_seq_num=\""+ value_seq_num +"\" " ;
		xmlStr			+= "login_facility_id=\""+ login_facility_id +"\" " ;
		xmlStr			+= "sex=\""+ sex +"\" " ;
		xmlStr			+= "catalog_code=\""+ catalog_code +"\" " ;
		xmlStr			+= "field_type=\""+ field_type +"\" " ;
		
		xmlStr 			+=" /></root>" ;  
 		var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "OrderEntryOrderFormatDependency.jsp?"+query_string, false ) ;
		xmlHttp.send( xmlDoc ) ;
		responseText=xmlHttp.responseText ;
		eval( responseText ) ;
 } // End of otherDependencyMnemonic

  // Build Dynamically if other field mnemonic is there
  //function loadOtherMnemonicValues(bean_id, bean_name, field_name, new_field_name, new_seq_num, seq_num, format_id, parent_seq_num, parent_field_mnemonic, field_mnemonic_value, value_seq_num, field_mnemonic, new_seq_num, label_text, accept_option, dflt_value, field_type, min_num_value, max_num_value, help_text, discr_msr_id, age_group_code, order_category, contr_msr_panel_id, contr_msr_mod_id, order_type_code, performing_facility_id, oper_side_appl_yn, specimen_def_yn, login_facility_id, sex,catalog_code)//IN049133
  //IN049133 - included dependency_yn
  function loadOtherMnemonicValues(bean_id, bean_name, field_name, new_field_name, new_seq_num, seq_num, format_id, parent_seq_num, parent_field_mnemonic, field_mnemonic_value, value_seq_num, field_mnemonic, new_seq_num, label_text, accept_option, dflt_value, field_type, min_num_value, max_num_value, help_text, discr_msr_id, age_group_code, dependency_yn, order_category, contr_msr_panel_id, contr_msr_mod_id, order_type_code, performing_facility_id, oper_side_appl_yn, specimen_def_yn, login_facility_id, sex,catalog_code){

   	// Will not be mandatorily, so no mandtorilycheck and no gif
//j    if(eval("document.getElementById("New_")"+new_field_name+"_0")) {
		var ot_install_yn	= document.OrderFormatForm.ot_install_yn.value;//IN045903
	   if(document.getElementById("New_"+new_field_name+"_0")) {

		document.getElementById("New_"+(new_field_name)+"_0").style.display = 'inline';
		document.getElementById("New_"+(new_field_name)+"_1").style.display = 'inline';
		document.getElementById("New_"+(new_field_name)+"_0").innerHTML		= label_text;
 /* done by jerome
 
	  eval("document.getElementById("New_")"+new_field_name+"_0.style.display= 'inline'")
	  eval("document.getElementById("New_")"+new_field_name+"_1.style.display= 'inline'")
 	  eval("document.getElementById("New_")"+new_field_name+"_0.innerHTML = label_text ");
	  */
  		
		// sbTemplate.append("<input type=\"text\" name=\""+(name_key)+"\" size=\""+display_length+"\" maxLength=\""+max_allowed_length+"\" value=\""+dflt_value+"\" "+validationClause+" "+display_only_prop+" "+ readOnlyClause+" >");
		// sbTemplate.append(dateText+mandatory_gif); // Adding the calendar component if it is date / date and time filed otherwise will be null
 	 /* done by jerome	
		eval("document.OrderFormatForm.field_mnemonic"+new_field_name+".value = \""+field_mnemonic+"\" ");
		eval("document.OrderFormatForm.label_text"+new_field_name+".value = \""+label_text+"\" ");
		eval("document.OrderFormatForm.accept_option"+new_field_name+".value = \""+accept_option+"\" ");
 		eval("document.OrderFormatForm.field_type"+new_field_name+".value = \""+field_type+"\" ");
 	*/
		document.getElementById("field_mnemonic"+(new_field_name)).value = 	field_mnemonic;
		document.getElementById("label_text"+(new_field_name)).value	 = 	label_text;
		document.getElementById("accept_option"+(new_field_name)).value  = 	accept_option;
		document.getElementById("field_type"+(new_field_name)).value	 = 	field_type;
		
		var num_digit_dec = 2; var display_only_prop = "";var disabled_prop = "";
		var readOnlyClause = ""; var htmlValue = ""; var dateText = "";
 		
		if(accept_option=="D")		
		{
			display_only_prop	= "readOnly";
			disabled_prop		= "disabled";
			readOnlyClause		= "class=\"READONLY\" ";
			class_value			= "ORDISABLED";  
		}
		else
		{
			display_only_prop	= "";
			disabled_prop		= "";
			readOnlyClause		= "";
			class_value			= "LABEL";
 		}
		/********/
		var mandatory_fields="",mandatory_names="",mandatory_gif ="";
		if(accept_option=="R")
		{
			mandatory_fields = document.OrderFormatForm.mandatory_fields.value;
			mandatory_names = document.OrderFormatForm.mandatory_names.value;
		//Commented --[IN027169]-- 	
		/*	if(mandatory_fields.indexOf("§"+new_field_name) == -1){
			mandatory_fields	+= "§"+new_field_name;
			mandatory_names		+=  "§"+label_text;
			}
		*/	//Commented --[IN027169]-- 
		//--[IN027169]-- Start
			if(mandatory_fields.indexOf("#"+new_field_name) == -1){
			mandatory_fields	+= "#"+new_field_name;
			mandatory_names		+=  "#"+label_text;
			}
		//--[IN027169]--  End	
			document.OrderFormatForm.mandatory_fields.value = mandatory_fields;
			document.OrderFormatForm.mandatory_names.value = mandatory_names;
			mandatory_gif		=  "&nbsp;<img src='../../eCommon/images/mandatory.gif'></img>";
		}
		else
		{
			mandatory_gif		= "";
		}
		/********/
		// Set the class Value for the TD (COLUMN)
 	//j  eval("document.getElementById("New_")"+new_field_name+"_0.className = class_value ");
 		 document.getElementById("New_"+new_field_name+"_0").className = class_value;
		
 		/*if (field_type=="V")
		{
			display_only_prop	= "readOnly";
			disabled_prop		= "disabled";
			readOnlyClause		= "class=\"READONLY\" ";
		}
		*/
		// name_obj					= eval("document.OrderFormatForm."+new_field_name); 
		 name_obj					=  document.getElementById(new_field_name); // Pass the Object
 		   		
		 // Validations, display_length and max-allowed length are formed here
  		 if( field_type=="D")	// Date and Time 
		 {
			max_allowed_length	= 10;
			display_length		= 10;
			validationClause	= "onBlur = \"callCheckDate("+name_obj.name+",'"+field_mnemonic+"','"+(new_field_name)+"',document.OrderFormatForm.sys_date); copySameMnemonic("+name_obj.name+",'"+field_mnemonic+"',"+new_seq_num+");checkOthDependency("+name_obj.name+",'"+format_id+"','"+field_mnemonic+"',"+new_seq_num+", "+seq_num+", '"+dependency_yn+"' ,'"+order_category+"', '"+contr_msr_panel_id+"','"+contr_msr_mod_id+"' ,'"+order_type_code+"' ,'"+discr_msr_id+"' ,'"+performing_facility_id+"' ,'','"+specimen_def_yn+"','"+login_facility_id+"','"+sex+"','"+catalog_code+"');\" "; //IN049133 included function checkOthDependency 
			if(order_category=="OT" && ot_install_yn=="Y" && field_mnemonic=="PREF_SURG_DATE") // for this pref_surg_date, and if OT Module is installed and OT Category, then display the Calender with Appts.
				dateText		= " <input type=\"image\" src=\"../../eCommon/images/CommonCalendar.gif\"  onClick=\"return showOTCalendar('"+(new_field_name)+"','"+(field_mnemonic+"ORDERFORMAT"+order_type_code)+"','"+performing_facility_id+"','"+patient_id+"');\">"+mandatory_gif ;
			else
				dateText		= " <input type=\"image\" src=\"../../eCommon/images/CommonCalendar.gif\"  onClick=\"return showCalendar('"+(new_field_name)+"');\">"+mandatory_gif ;
		 } else if(field_type=="T")	// Time
	     {
			max_allowed_length	= 5;
			display_length		= 5;
			validationClause	= "onBlur = \"callCheckTime("+name_obj.name+"); copySameMnemonic("+name_obj.name+",'"+field_mnemonic+"',"+new_seq_num+");checkOthDependency("+name_obj.name+",'"+format_id+"','"+field_mnemonic+"',"+new_seq_num+", "+seq_num+", '"+dependency_yn+"' ,'"+order_category+"', '"+contr_msr_panel_id+"','"+contr_msr_mod_id+"' ,'"+order_type_code+"' ,'"+discr_msr_id+"' ,'"+performing_facility_id+"' ,'','"+specimen_def_yn+"','"+login_facility_id+"','"+sex+"','"+catalog_code+"'); \" "; //IN049133 included function checkOthDependency 
	     } else if( field_type=="E")	
	     {
			max_allowed_length	= 16;
			display_length		= 16;
			validationClause	= "onBlur = \"callCheckDateTime("+name_obj.name+"); copySameMnemonic("+name_obj.name+",'"+field_mnemonic+"',"+new_seq_num+");checkOthDependency("+name_obj.name+",'"+format_id+"','"+field_mnemonic+"',"+new_seq_num+", "+seq_num+", '"+dependency_yn+"' ,'"+order_category+"', '"+contr_msr_panel_id+"','"+contr_msr_mod_id+"' ,'"+order_type_code+"' ,'"+discr_msr_id+"' ,'"+performing_facility_id+"' ,'','"+specimen_def_yn+"','"+login_facility_id+"','"+sex+"','"+catalog_code+"');\" "; //IN049133 included function checkOthDependency 
			dateText			= "<input type=\"image\" src=\"../../eCommon/images/CommonCalendar.gif\"  onClick=\"return showCalendar('"+(new_field_name)+"',null,'hh:mm');\">"+mandatory_gif; //--[IN026010]--
		 } else if( field_type=="I")	//Integer
		 {
		 	 max_allowed_length	= 6;
			 display_length		= 6;
			 if(order_category=="OT" && ot_install_yn=="Y" && field_mnemonic=="PRE_OP_DAYS") // For this PRE_OP_DAYS,calculate (subtract ) the day entered with the pref_surg_date
				 validationClause = "onBlur = \"checkValidRange("+name_obj.name+"); calculatePreOpDays("+name_obj.name+","+(new_field_name)+",document.OrderFormatForm.sys_date); copySameMnemonic("+name_obj.name+", '"+field_mnemonic+"', "+new_seq_num+");checkOthDependency("+name_obj.name+",'"+format_id+"','"+field_mnemonic+"',"+new_seq_num+", "+seq_num+", '"+dependency_yn+"' ,'"+order_category+"', '"+contr_msr_panel_id+"','"+contr_msr_mod_id+"' ,'"+order_type_code+"' ,'"+discr_msr_id+"' ,'"+performing_facility_id+"' ,'','"+specimen_def_yn+"','"+login_facility_id+"','"+sex+"','"+catalog_code+"');\" onKeyPress=\"return allowValidNumber("+name_obj.name+",event,"+max_allowed_length+",0)\"" ; //IN049133 included function checkOthDependency 
 			 else
				 validationClause = "onBlur = \"checkValidRange("+name_obj.name+"); copySameMnemonic("+name_obj.name+", '"+field_mnemonic+"', "+new_seq_num+");checkOthDependency("+name_obj.name+",'"+format_id+"','"+field_mnemonic+"',"+new_seq_num+", "+seq_num+", '"+dependency_yn+"' ,'"+order_category+"', '"+contr_msr_panel_id+"','"+contr_msr_mod_id+"' ,'"+order_type_code+"' ,'"+discr_msr_id+"' ,'"+performing_facility_id+"' ,'','"+specimen_def_yn+"','"+login_facility_id+"','"+sex+"','"+catalog_code+"');\" onKeyPress=\"return allowValidNumber("+name_obj.name+",event,"+max_allowed_length+",0)\""; //IN049133 included function checkOthDependency 
		 } else if( field_type=="N" )	// Numeric
		 {
			max_allowed_length	= 10;
 			display_length		= 10;
			validationClause	= "onBlur = \"checkValidRange("+name_obj.name+"); copySameMnemonic("+name_obj.name+",'"+field_mnemonic+"',"+new_seq_num+");checkOthDependency("+name_obj.name+",'"+format_id+"','"+field_mnemonic+"',"+new_seq_num+", "+seq_num+", '"+dependency_yn+"' ,'"+order_category+"', '"+contr_msr_panel_id+"','"+contr_msr_mod_id+"' ,'"+order_type_code+"' ,'"+discr_msr_id+"' ,'"+performing_facility_id+"' ,'','"+specimen_def_yn+"','"+login_facility_id+"','"+sex+"','"+catalog_code+"');\" onKeyPress=\"return allowValidNumber("+name_obj.name+",event,"+(max_allowed_length - num_digit_dec)+","+num_digit_dec+")\""; //IN049133 included function checkOthDependency 
		 } else if( field_type=="V" )	
		 {
			validationClause	= " onBlur = \"makeValidString( "+name_obj.name+" ); copySameMnemonic("+name_obj.name+",'"+field_mnemonic+"',"+new_seq_num+");checkOthDependency("+name_obj.name+",'"+format_id+"','"+field_mnemonic+"',"+new_seq_num+", "+seq_num+", '"+dependency_yn+"' ,'"+order_category+"', '"+contr_msr_panel_id+"','"+contr_msr_mod_id+"' ,'"+order_type_code+"' ,'"+discr_msr_id+"' ,'"+performing_facility_id+"' ,'','"+specimen_def_yn+"','"+login_facility_id+"','"+sex+"','"+catalog_code+"');\"  "; //IN049133 included function checkOthDependency 
			display_length		= 50;
			max_allowed_length	= 100;
		 } else   //Test box or text area.
		 {
			validationClause	= " onBlur = \"makeValidString( "+name_obj.name+" ); copySameMnemonic("+name_obj.name+",'"+field_mnemonic+"',"+new_seq_num+");\"  ";
			display_length		= 40;
			max_allowed_length	= 100;
 		 }
  		 // Painting Done here
	 	 if( field_type!="C" && field_type!="L" && field_type!="V" && field_type!="R")
		 {
			htmlValue	= "<input type=\"text\" id=\""+(new_field_name)+"\" name=\""+new_field_name+"\"  maxLength=\""+max_allowed_length+"\" size=\""+display_length+"\" value=\""+dflt_value+"\" "+validationClause+" "+display_only_prop+" "+readOnlyClause+">"
			htmlValue	+= dateText;
	 	 } else if( field_type=="V")
		 {
 		    htmlValue	= "<input type=\"hidden\" id=\""+(new_field_name)+"\" name=\""+new_field_name+"\"  maxLength=\""+max_allowed_length+"\" size=\""+display_length+"\" value=\""+dflt_value+"\" "+validationClause+" "+display_only_prop+" "+readOnlyClause+"><b>"+dflt_value+"</b>";
			htmlValue	+= dateText;
		 } else if(field_type=="C")
		 {
 	  		//validationClause = "onClick=\"setCheckBoxValue("+name_obj.name+",'"+field_mnemonic+"','"+contr_msr_panel_id+"','"+contr_msr_mod_id+"','','"+order_type_code+"','"+order_category+"');checkOthDependency("+name_obj.name+",'"+format_id+"','"+field_mnemonic+"',"+new_seq_num+", "+seq_num+", '"+dependency_yn+"' ,'"+order_category+"', '"+contr_msr_panel_id+"','"+contr_msr_mod_id+"' ,'"+order_type_code+"' ,'"+discr_msr_id+"' ,'"+performing_facility_id+"' ,'','"+specimen_def_yn+"','"+login_facility_id+"','"+sex+"','"+catalog_code+"');\"";//IN049133 included function checkOthDependency 
 			//validationClause += "checkDependency("+name_obj.name+",'"+format_id+"','"+field_mnemonic+"',"+new_seq_num+", "+seq_num+",'"+dependency_yn+"');";
 	  		validationClause = "onClick=\"setCheckBoxValue("+new_field_name+",'"+field_mnemonic+"','"+contr_msr_panel_id+"','"+contr_msr_mod_id+"','','"+order_type_code+"','"+order_category+"');checkOthDependency("+new_field_name+",'"+format_id+"','"+field_mnemonic+"',"+new_seq_num+", "+seq_num+", '"+dependency_yn+"' ,'"+order_category+"', '"+contr_msr_panel_id+"','"+contr_msr_mod_id+"' ,'"+order_type_code+"' ,'"+discr_msr_id+"' ,'"+performing_facility_id+"' ,'','"+specimen_def_yn+"','"+login_facility_id+"','"+sex+"','"+catalog_code+"');\"";//IN049133 included function checkOthDependency 
			if(dflt_value=="Y")
		 		htmlValue = "<input type=\"CHECKBOX\" id=\""+(new_field_name)+"\" name=\""+new_field_name+"\"   value=\""+dflt_value+"\" CHECKED "+validationClause+" "+disabled_prop+" > ";
			else 
				htmlValue = "<input type=\"CHECKBOX\" id=\""+(new_field_name)+"\" name=\""+new_field_name+"\"   value='N'  "+validationClause+" "+disabled_prop+" > ";

	 		htmlValue += "<input type=\"hidden\" name=\""+(new_field_name)+"_chkBox\" id=\""+(new_field_name)+"_chkBox\">";
 		}	 
		else if(field_type=="R")	// Radio Group
		{
 	  		validationClause = "onClick=\"setCheckBoxValue("+name_obj.name+",'"+field_mnemonic+"','"+contr_msr_panel_id+"','"+contr_msr_mod_id+"','','"+order_type_code+"','"+order_category+"');\"";
 			//validationClause += "checkDependency("+name_obj.name+",'"+format_id+"','"+field_mnemonic+"',"+new_seq_num+", "+seq_num+",'"+dependency_yn+"');";
			 populateRadioValues(field_mnemonic, dflt_value, new_field_name, order_category, contr_msr_panel_id,contr_msr_mod_id, order_type_code, discr_msr_id, performing_facility_id, 	oper_side_appl_yn, specimen_def_yn, login_facility_id, sex,catalog_code);
		}	 
		else if(field_type=="L") // for List box painting done here
		{
			if(mandatory_gif !="")
  				document.getElementById("New_"+new_field_name+_1).innerHTML = '<select name=\""+new_field_name+"\" "+disabled_prop+" id=\""+new_field_name+"\" "+disabled_prop+"><option value=\"\">   ----- Select ------</option> </select>&nbsp;<img src=\"../../eCommon/images/mandatory.gif\"></img>';
			else
				document.getElementById("New_"+new_field_name+_1).innerHTML = '<select name=\""+new_field_name+"\" "+disabled_prop+" id=\""+new_field_name+"\" "+disabled_prop+"><option value=\"\">   ----- Select ------</option> </select>';
			populateListValues(field_mnemonic, dflt_value, new_field_name, order_category, contr_msr_panel_id,contr_msr_mod_id, order_type_code, discr_msr_id, performing_facility_id, oper_side_appl_yn, specimen_def_yn, login_facility_id, sex,catalog_code);
  		}	 // end of field_type = 'L'
		// After Painting (in an innerHtml, which is done here) and it is not a list box 
		if(field_type!="L" && field_type!="R"){
 	  		//eval("document.getElementById("New_")"+new_field_name+"_1.innerHTML= htmlValue");
			htmlValue += "<input type=\"hidden\" name=\"oth_dependency_yn"+(new_field_name)+"\" id=\"oth_dependency_yn"+(new_field_name)+"\">";
			document.getElementById("New_"+new_field_name+"_1").innerHTML = htmlValue ;
		}
	} // End of _New
} // End of loadOtherMnemonicValues

 // Show the Validations
 function  checkDependencyValidation(field_name, field_type, field_value_type, field_action_msg, field_mnemonic_value, field_mnemonic_value1,field_mnemonic_action) {
   	 if(field_type!="L" && field_type!="V" && field_type!="C" && field_type!="R"){
//		var field_obj			 = eval("document.OrderFormatForm."+field_name);
		var field_obj			 = document.getElementById(field_name);
		var sys_date_obj		 = document.OrderFormatForm.sys_date;
		var sys_date_time_obj	 = document.OrderFormatForm.sys_date_time;
 		var value				 = document.getElementById(field_name).value;
   		if(value!="")
		{ 
  	  		if(field_type!="D" && field_type!="T" && field_type!="E") 
			{  //For Numeric(integer) Fields
				if(value>0 && field_value_type=="E") 
				{	//Equal to 
  					if((parseFloat(value)==parseFloat(field_mnemonic_value))) 
					{
  						setTextFocus(field_obj, field_action_msg,field_mnemonic_action); //Set the focus to the field
 					} // End of lesser than check
				} else if(value>0 && field_value_type=="L") 
				{	//Lesser than 
  					if((parseFloat(value)<parseFloat(field_mnemonic_value))) 
					{
  						setTextFocus(field_obj, field_action_msg,field_mnemonic_action); //Set the focus to the field
					} // End of lesser than check
				} 
				else if(value>0 &&  field_value_type=="G") 
				{ //Greater than 
					if((parseFloat(value)>parseFloat(field_mnemonic_value))) 
					{
 						setTextFocus(field_obj, field_action_msg,field_mnemonic_action); //Set the focus to the field
					} // End of greater than
				} 
				else 
				{  //Between the values 
 					if(value!="" && value > 0 && field_mnemonic_value!="" && 	field_mnemonic_value1!="")
					{
  						if( ((parseFloat(value)>=parseFloat(field_mnemonic_value)) &&  (parseFloat(value)<=parseFloat(field_mnemonic_value1))) ) 
						{
 							setTextFocus(field_obj, field_action_msg,field_mnemonic_action); //Set the focus to the field
						}
					} // End of between 
				} // End of else 
			} else if(field_type=="D") 
			{   //For Date 
				if(field_value_type=="E") 
				{	//Equals than 
					if(doDateEquals(sys_date_obj, field_obj)==false)  
					{ // Date should not be lesser than sysdate.
						setTextFocus(field_obj, field_action_msg,field_mnemonic_action); //Set the focus to the field
					}
				} 
				else if(field_value_type=="L") 
				{	//Lesser than 
					if(doDateCheckAlert(sys_date_obj, field_obj)==false)  
					{ // Date should not be lesser than sysdate.
						setTextFocus(field_obj, field_action_msg,field_mnemonic_action); //Set the focus to the field
					}
				} else if(field_value_type=="G") 
					{ //Greater than
					if(doDateCheckAlert(field_obj , sys_date_obj)==false)  
					{ // Date should not be greater than sysdate.
						setTextFocus(field_obj, field_action_msg,field_mnemonic_action); //Set the focus to the field
					}
				} 
 			} else if(field_type=="T") 
			{   //For Time 
				// One function willcheck for all, Equals,Lesser and Greater
				if(doCheckTime(field_obj , sys_date_time_obj, field_value_type)==false)  
				{ // Time should not be greater than systime.
						setTextFocus(field_obj, field_action_msg,field_mnemonic_action); //Set the focus to the field
				}
			} 
			else if(field_type=="E") 
			{   //For Date and Time
 				   if(field_value_type=="E") 
				  {	//Equals than 
						if(ValidateEqualsDateTime(sys_date_time_obj, field_obj)==false) 
						{ // Date should not be lesser than sysdate.
							setTextFocus(field_obj, field_action_msg,field_mnemonic_action); //Set the focus to the field
						}
					} else	if(field_value_type=="L") {	//Lesser than
  						if(ValidateDateTime(sys_date_time_obj, field_obj)==false) // Date should not be lesser than sysdate.
						{
							setTextFocus(field_obj, field_action_msg,field_mnemonic_action); //Set the focus to the field
 						}
					} else if(field_value_type=="G") { //Greater than
						if(ValidateDateTime(field_obj, sys_date_time_obj)==false) // Date should not be GREATER than sysdate.
						{
							setTextFocus(field_obj, field_action_msg,field_mnemonic_action); //Set the focus to the field
 						}
					}  
				} // End of if field_type ="E"
			} //End of if value 		
 		} // End of field_type !="L" && !="V"
 } // End of checkDependencyValidation

 // Hide the columns
 function hideColumns(new_field_name, max_dependency_rows, new_seq_num) {
    // increase the max_dependency_rows,
	//alert("==new_field_name="+new_field_name+"=max_dependency_rows="+max_dependency_rows+"=new_seq_num="+new_seq_num+"===");

	// That means if the field_menomonic is starting from 2, then till the end of it(including the dependency)
	// it should hide 
	//alert("newfieldname"+new_field_name);
	//alert("max_dependency_rows"+max_dependency_rows);
   // alert("new_seq_num"+new_seq_num);

   	max_dependency_rows = 	max_dependency_rows + new_seq_num;

   	 /*for(i=new_seq_num+1;i<=max_dependency_rows;i++) {
  		if(eval("document.getElementById("New_")"+(new_field_name+i)+"_0")) {
			// Make it null
			eval("document.OrderFormatForm.field_type"+(new_field_name+i)+".value=''");
			eval("document.OrderFormatForm.label_text"+(new_field_name+i)+".value = ''");
			eval("document.OrderFormatForm.accept_option"+(new_field_name+i)+".value = ''");
 		 	eval("document.OrderFormatForm."+(new_field_name+i)+".value=''");
			// Make it hidden
   			eval("document.getElementById("New_")"+(new_field_name+i)+"_0.style.display= 'none'")
			eval("document.getElementById("New_")"+(new_field_name+i)+"_1.style.display= 'none'")
		}
	}*/
	//alert();/*


	for(i=new_seq_num+1;i<=max_dependency_rows;i++) {
  		if(document.getElementById("New_"+(new_field_name+i)+"_0")) {
			// Make it null
			document.getElementById("field_type"+(new_field_name+i)).value = '';
			document.getElementById("label_text"+(new_field_name+i)).value = '';
			document.getElementById("accept_option"+(new_field_name+i)).value = '';
			document.getElementById((new_field_name+i)).value = '';
			//alert("i"+i);
			
			tmp_fields = document.getElementById("mandatory_fields").value ;
			tmp_names = document.getElementById("mandatory_names").value ;
			tmp_txt = document.getElementById("New_"+(new_field_name+i)+"_0").innerText;
			//Modified --[IN027169]-- Start 	
			if(tmp_fields.indexOf("#"+new_field_name+i)!= -1){
				tmp_val ="#"+new_field_name+i;
				tmp_fields = tmp_fields.replace(tmp_val,"");
				document.getElementById("mandatory_fields").value = tmp_fields;
			}
			if(tmp_names.indexOf("#"+tmp_txt)!= -1){
				tmp_val ="#"+tmp_txt;
				tmp_names =tmp_names.replace(tmp_val,"");
				document.getElementById("mandatory_names").value = tmp_names;
			}
			//Modified --[IN027169]-- End
	
			// Make it hidden
			//alert("new_field_name"+new_field_name);
			document.getElementById("New_"+(new_field_name+i)+"_0").style.display= 'none';
			document.getElementById("New_"+(new_field_name+i)+"_1").style.display= 'none';
			
		}
	}
 } // End of hideColumns

 // Focus the particular field
function setTextFocus(obj, field_action_msg,field_mnemonic_action){
	alert(field_action_msg);
	if(field_mnemonic_action=="S")
	{
		obj.value = "";
		//obj.select();
		//obj.focus();
	}
	return false;
}

 function populateListValues(field_mnemonic, dflt_value, new_field_name, order_category, contr_msr_panel_id,contr_msr_mod_id, order_type_code, discr_msr_id, performing_facility_id, oper_side_appl_yn, specimen_def_yn, login_facility_id, sex,catalog_code){
	 //bean_id="+bean_id+"&bean_name="+bean_name+"&
  	var lab_install_yn	= document.OrderFormatForm.lab_install_yn.value;
	var rd_install_yn	= document.OrderFormatForm.rd_install_yn.value;
	var bt_install_yn	= document.OrderFormatForm.bt_install_yn.value;
	var ot_install_yn	= document.OrderFormatForm.ot_install_yn.value;
	query_string		= "func_mode=POPULATE_LIST_VALUES&new_field_name="+escape(new_field_name)
  	 //var xmlDoc 		= new ActiveXObject( "Microsoft.XMLDom" ) ;
	 //var xmlHttp 		= new ActiveXObject( "Microsoft.XMLHTTP" ) ;
	 var xmlHttp = new XMLHttpRequest();
		xmlStr			= "<root><SEARCH " ;
		xmlStr			+= "field_mnemonic=\""+ field_mnemonic +"\" " ;
		xmlStr			+= "order_category=\""+ order_category +"\" " ;
		xmlStr			+= "contr_msr_panel_id=\""+ contr_msr_panel_id +"\" " ;
		xmlStr			+= "contr_msr_mod_id=\""+ contr_msr_mod_id +"\" " ;
		xmlStr			+= "order_type_code=\""+ order_type_code +"\" " ;
		xmlStr			+= "discr_msr_id=\""+ discr_msr_id +"\" " ;
		xmlStr			+= "performing_facility_id=\""+ performing_facility_id +"\" " ;
		xmlStr			+= "ot_install_yn=\""+ ot_install_yn +"\" " ;
		xmlStr			+= "lab_install_yn=\""+ lab_install_yn +"\" " ;
		xmlStr			+= "bt_install_yn=\""+ bt_install_yn +"\" " ;
		xmlStr			+= "rd_install_yn=\""+ rd_install_yn +"\" " ;
		xmlStr			+= "oper_side_appl_yn=\""+ oper_side_appl_yn +"\" " ;
		xmlStr			+= "specimen_def_yn=\""+ specimen_def_yn +"\" " ;
		xmlStr			+= "login_facility_id=\""+ login_facility_id +"\" " ;
		xmlStr			+= "sex=\""+ sex +"\" " ;
		xmlStr			+= "catalog_code=\""+ catalog_code +"\" " ;
 		xmlStr			+= "dflt_value=\""+dflt_value+"\" " ;
 		xmlStr 			+=" /></root>" ;
  		var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "OrderEntryOrderFormatListPopulate.jsp?"+query_string, false ) ;
		xmlHttp.send( xmlDoc ) ;
		responseText=xmlHttp.responseText ;
		eval( responseText ) ;
 }

// To clear the list box
function clearFormatList( docObj, field_name) {
	var len = eval(docObj+"."+field_name+".options.length") ;
	for(var i=0;i<len;i++)
	{
		eval(docObj+"."+field_name+".remove('')") ;
	}
 	var tp 		= " --- "+getLabel("Common.defaultSelect.label","Common")+" ---" ;
	var opt  	= eval("document.createElement(\"OPTION\")") ;
	opt.text 	= tp ;
	opt.value 	= "" ;
	eval(docObj+"."+field_name+".add(opt)") ;
} // End of clearFormatList

// To add in the List box
function addFormatList(form_name, field_name, code, value ,value1, dflt_value, order_category, ot_install_yn, oper_side_appl_yn, specimen_def_yn) {
  	var selected_yn = "N";
 	if((dflt_value==code) || (order_category=="OT" && ot_install_yn=="Y" && oper_side_appl_yn=="N" && code=="Not Applicable") )
		selected_yn = "Y"; 
	else if(specimen_def_yn=="Y" && value1 =="Y") // If lab is installed and to default the value for specimen type
		selected_yn = "Y"; 
   	var element 	= document.createElement('OPTION') ;
  	element.value 	= code ;
	element.text 	= value ;
 	form_name		= eval(form_name+"."+field_name);
	form_name.add(element);

	// Now Default the Value
	if(selected_yn == "Y" || dflt_value==code)	 {
 	  element.selected = value ;
	  //element.selected = selected; Commented --[IN027169]--
 	}
} // End of addOrderList

function addRadioGroup(new_field_name, radio_group_values){
 	document.getElementById("New_"+new_field_name+_1).innerHTML = radio_group_values;
} // End of addRadioGroup

function populateRadioValues(field_mnemonic, dflt_value, new_field_name, order_category, contr_msr_panel_id,contr_msr_mod_id, order_type_code, discr_msr_id, performing_facility_id, oper_side_appl_yn, specimen_def_yn, login_facility_id, sex,catalog_code){
	 //bean_id="+bean_id+"&bean_name="+bean_name+"&
  	var lab_install_yn	= document.OrderFormatForm.lab_install_yn.value;
	var rd_install_yn	= document.OrderFormatForm.rd_install_yn.value;
	var bt_install_yn	= document.OrderFormatForm.bt_install_yn.value;
	var ot_install_yn	= document.OrderFormatForm.ot_install_yn.value;
	query_string		= "func_mode=POPULATE_RADIO_VALUES&new_field_name="+escape(new_field_name)
  	 //var xmlDoc 		= new ActiveXObject( "Microsoft.XMLDom" ) ;
	 //var xmlHttp 		= new ActiveXObject( "Microsoft.XMLHTTP" ) ;
	 var xmlHttp = new XMLHttpRequest();
		xmlStr			= "<root><SEARCH " ;
		xmlStr			+= "field_mnemonic=\""+ field_mnemonic +"\" " ;
		xmlStr			+= "order_category=\""+ order_category +"\" " ;
		xmlStr			+= "contr_msr_panel_id=\""+ contr_msr_panel_id +"\" " ;
		xmlStr			+= "contr_msr_mod_id=\""+ contr_msr_mod_id +"\" " ;
		xmlStr			+= "order_type_code=\""+ order_type_code +"\" " ;
		xmlStr			+= "discr_msr_id=\""+ discr_msr_id +"\" " ;
		xmlStr			+= "performing_facility_id=\""+ performing_facility_id +"\" " ;
		xmlStr			+= "ot_install_yn=\""+ ot_install_yn +"\" " ;
		xmlStr			+= "lab_install_yn=\""+ lab_install_yn +"\" " ;
		xmlStr			+= "bt_install_yn=\""+ bt_install_yn +"\" " ;
		xmlStr			+= "rd_install_yn=\""+ rd_install_yn +"\" " ;
		xmlStr			+= "oper_side_appl_yn=\""+ oper_side_appl_yn +"\" " ;
		xmlStr			+= "specimen_def_yn=\""+ specimen_def_yn +"\" " ;
		xmlStr			+= "login_facility_id=\""+ login_facility_id +"\" " ;
		xmlStr			+= "sex=\""+ sex +"\" " ;
		xmlStr			+= "catalog_code=\""+ catalog_code +"\" " ;
 		xmlStr			+= "dflt_value=\""+dflt_value+"\" " ;
 		xmlStr 			+=" /></root>" ;
  		var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "OrderEntryOrderFormatListPopulate.jsp?"+query_string, false ) ;
		xmlHttp.send( xmlDoc ) ;
		responseText=xmlHttp.responseText ;
		eval( responseText ) ;
 }  // End of populateRadioValues

// checking whether the date and time (from and to) entered are equals 
function ValidateEqualsDateTime (from,to)
{
    from		= from.value
    to			= to.value
    var		a	=  from.split(" ")
    splitdate		= a[0];
    splittime		= a[1]
     var splitdate1 = splitdate.split("/")
    var splittime1	= splittime.split(":")

     var from_date  = new Date(eval(splitdate1[2]), eval(splitdate1[1])-1, eval(splitdate1[0]), eval(splittime1[0]), eval(splittime1[1]))

			a		=  to.split(" ")
		splitdate	= a[0];
		 splittime	= a[1]
	
     splitdate1		= splitdate.split("/")
     splittime1		= splittime.split(":")

     var to_date  =new Date(eval(splitdate1[2]), eval(splitdate1[1])-1, eval(splitdate1[0]), eval(splittime1[0]), eval(splittime1[1]))

     if(Date.parse(to_date) == Date.parse(from_date))
     {
        return true
     }
     else
        return false;
}

/*function openMultiSelectList(obj, new_seq_num, seq_num, order_category, field_mnemonic , contr_msr_panel_id,contr_msr_mod_id,order_type_code,discr_msr_id,performing_facility_id, login_facility_id,sex, lab_install_yn,bt_install_yn,rd_install_yn,ot_install_yn) {
	var retVal;
  	var dialogHeight 		= "29" ;
	var dialogWidth  		= "52" ;
	var dialogTop   		= "100";
	var dialogLeft   		= "280";
	var features    		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" +dialogLeft+ "; dialogTop:" +dialogTop+ "; status=no" ;
  	var arguments;
	var finalString			= "order_category="+escape(order_category)+"&field_mnemonic="+escape(field_mnemonic)+"&contr_msr_panel_id="+escape(contr_msr_panel_id)+"&contr_msr_mod_id="+escape(contr_msr_mod_id)+"&order_type_code="+escape(order_type_code)+"&discr_msr_id="+escape(discr_msr_id)+"&performing_facility_id="+escape(performing_facility_id)+"&login_facility_id="+escape(login_facility_id)+"&sex="+escape(sex)+"&lab_install_yn="+escape(lab_install_yn)+"&bt_install_yn="+escape(bt_install_yn)+"&rd_install_yn="+escape(rd_install_yn)+"&ot_install_yn="+escape(ot_install_yn);
  	var url 				= "";
  	url 					= "../../eOR/jsp/OrderEntryOrderFormatMultiSelect.jsp?"+finalString;
  	retVal					= window.showModalDialog(url,arguments,features);
  	//if(retVal!=null)
  	//	formObj.format_id_yn.value =  retVal;


} // End of openMultiSelectList
*/

async function displayMultiSelectList(obj_name, new_seq_num, seq_num, order_category, field_mnemonic , contr_msr_panel_id, contr_msr_mod_id, order_type_code, discr_msr_id, performing_facility_id, login_facility_id, sex, lab_install_yn, bt_install_yn, rd_install_yn, ot_install_yn, old_obj_desc) {
	
		var formObj				= "document.OrderFormatForm";
 		var retVal;
		var obj_value			= eval(formObj+"."+obj_name+".value");

		var list_box_desc		= "";
  	  	var dialogHeight 		= 30; 
		var dialogWidth  		= 40;
		var dialogTop   		= ""; 
		var dialogLeft   		= ""; 
		var features    		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" +dialogLeft+ "; dialogTop:" +dialogTop+ "; status=no" ;
	  	var arguments;
 		var finalString			= "order_category="+escape(order_category)+"&field_mnemonic="+escape(field_mnemonic)+"&contr_msr_panel_id="+escape(contr_msr_panel_id)+"&contr_msr_mod_id="+escape(contr_msr_mod_id)+"&order_type_code="+escape(order_type_code)+"&discr_msr_id="+escape(discr_msr_id)+"&performing_facility_id="+escape(performing_facility_id)+"&login_facility_id="+escape(login_facility_id)+"&sex="+escape(sex)+"&lab_install_yn="+escape(lab_install_yn)+"&bt_install_yn="+escape(bt_install_yn)+"&rd_install_yn="+escape(rd_install_yn)+"&ot_install_yn="+escape(ot_install_yn)+"&multi_list_code="+escape(obj_value)+"&field_mnemonic="+ escape(field_mnemonic);
		var url 				= "";
  		url 					= "../../eOR/jsp/OrderEntryOrderFormatMultiSelectFrameSet.jsp?"+finalString;
  		retVal					= await window.showModalDialog(url,arguments,features);
   		if(retVal!=null && retVal!="") {
   			//obj.value =  retVal;
 		/*	var len = eval(formObj+"."+obj_name+".options.length") ;
 			for(var i=0;i<len;i++)
			{
				eval(formObj+"."+obj_name+".remove(\"select\")") ;
			}
 			var element 	= document.createElement('OPTION') ;
			element.value 	=  retVal;
 			if(retVal.indexOf("||")!=-1)
				element.text 	=  retVal.substring(0,1)+"...More";
			else 
				element.text 	=  retVal;
 			eval(formObj+"."+obj_name).add(element);
		*/
		if(retVal.indexOf("||")!=-1) {
				eval(formObj+".name_"+obj_name).value 	=  retVal.substring(0,1)+"...More";
		} 	else  {
				eval(formObj+".name_"+obj_name).value=retVal;
		}
		eval(formObj+"."+obj_name).value 	=  retVal;


  	}
} // End of openMultiSelectList

function setMultiList(){
	var formObj			= parent.OrderEntryOrderFormatMultiSelect.document.OrderFormatMultiSelectForm;
	var total_rows		= formObj.total_rows.value;
	var count			= 0;
	var combined_code	= "";
	if(total_rows > 0) {
		for (i=0;i<total_rows;i++)
		{
			if(eval("formObj.chk_"+i+".checked")) {   
				var code		  = eval("formObj.chk_"+i+".value");
				if(code!= null && code!="") {
					combined_code += code +"||";
					count++;
				}
			} // End of if 
			if(count > 10)
			{
				break;
			}
		} // End of for 
		if(count>10)
		{
			alert(getMessage("MORE_CODES_NOT_SELECT","OR"));
			return;
		}
	} // End of if total-rows > 0
	if(combined_code!=null)
		combined_code = combined_code.substring(0,combined_code.length-2); //remove the last || character
//	window.returnValue = combined_code;
//	window.close();
let dialogBody = parent.parent.document.getElementById('dialog-body');
    dialogBody.contentWindow.returnValue = combined_code;
    
    const dialogTag = parent.parent.document.getElementById("dialog_tag");    
    dialogTag.close(); 
} // End of setMultiList


function previousValuesSelect(multi_list_code){
	if(multi_list_code!=null && multi_list_code!="") {
		var formObj			= parent.OrderEntryOrderFormatMultiSelect.document.OrderFormatMultiSelectForm;
		var total_rows		= formObj.total_rows.value;	
		if(total_rows>0 ) {
			for(i=0;i<total_rows;i++)
			{
				var combined_code = multi_list_code.split("||");
				for(k=0;k<combined_code.length; k++) {
					if(eval("formObj.chk_"+i)) {   
						var code		  = eval("formObj.chk_"+i+".value");
						if(combined_code[k]==code) {
							eval("formObj.chk_"+i+".checked=true");	
							break;
						}
					} // End of if 
				} // End of for k
			} // End of for i
		} // End of if
	} // End of if 
} // End of previousValuesSelect


// checking whether the date (from and to) entered are equals
function doDateEquals(from,to) {
    var fromarray; var toarray;
    var fromdate = from.value ;
    var todate = to.value ;
    if(fromdate.length > 0 && todate.length > 0 ) {
            fromarray = fromdate.split("/");
            toarray = todate.split("/");
            var fromdt = new Date(fromarray[2],fromarray[1]-1,fromarray[0]);
            var todt = new Date(toarray[2],toarray[1]-1,toarray[0]);
            if(Date.parse(todt) == Date.parse(fromdt)) {
                return false;
            }
     }
	return true;
}

// To check whether the time entered is equals 
function doCheckTime(from,to, check_condition) {
 
	var fromarray; var toarray;
    var fromdate	= from.value ;
    var todate		= to.value ;
 
	if(todate.length>0){  // leave out the date , take only the time, it will start from 12 to 16
		todate = todate.substring(11); // Take from the 11th place to the end
	}
     if(fromdate.length > 0 && todate.length > 0 ) {
		fromarray	= fromdate.split(":");
        toarray		= todate.split(":");

		if(check_condition=="E") {  //Equals
 			if(fromarray[0] == toarray[0])
			{
 				if(fromarray[1] == toarray[1]) {
 					return false;
				}	
				else 
					return true;
			}
		} else if(check_condition=="L") { //Lesser Than
			if(fromarray[0] <= toarray[0])
			{
				if(fromarray[1] < toarray[1])
					return false;
				else 
					return true;
			}
		}else if(check_condition=="G") { //Greater Than
 			if(fromarray[0] >= toarray[0])
			{
				if(fromarray[1] > toarray[1])
					return false;
				else 
					return true;
			}
		}
	} //End of from_date.length
	return true ;
}  // End of doCheckTime

//LookUp for the Patient Details(For Line Level Order Entry Format)
function showPatientLookUp(obj_name, obj, field_mnemonic)  //Called on click of the patient_id or Patient_name (field_mnemonic NM_PATIENT_ID, NM_PATIENT_NAME)
{ 
	obj_ref					= eval("document.OrderFormatForm."+obj_name);
 	obj_ref.value			= "";
	var mother_patient_id =  PatientSearch();
	
	if(mother_patient_id != null)
	{
		var form_obj 	= document.OrderFormatForm;
		//var xmlDoc 		= new ActiveXObject( "Microsoft.XMLDom" ) ;
		//var xmlHttp 	= new ActiveXObject( "Microsoft.XMLHTTP" ) ;
		var xmlHttp = new XMLHttpRequest();
		xmlStr			= "<root><SEARCH " ;
 		xmlStr 			+= "mother_patient_id=\""+mother_patient_id+"\" " ; 		
 		xmlStr 			+= "obj_name=\""+obj_name+"\" " ;
 		xmlStr 			+= "obj=\""+obj+"\" " ;
		xmlStr 			+= "field_mnemonic=\""+field_mnemonic+"\" " ;
		xmlStr 			+=" /></root>" ;
		var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "OrderEntryValidate.jsp?bean_id=" + form_obj.bean_id.value + "&bean_name="+ form_obj.bean_name.value +"&func_mode=VALIDATE_MOTHER_PATIENT_ID", false ) ;
		xmlHttp.send( xmlDoc ) ;
		responseText	= xmlHttp.responseText ;
		eval( responseText ) ; 
			
	/*var dataNameArray  		= new Array() ;
	var dataValueArray 		= new Array() ;
	var dataTypeArray 		= new Array() ;
	var sql_query			= document.OrderFormatForm.sql_or_order_entry_nm_mother_pat_details_select.value;
	var argumentArray  		= new Array() ;
  		argumentArray[0]	= sql_query;
		argumentArray[1]	= dataNameArray ;
		argumentArray[2]	= dataValueArray ;
  		argumentArray[3]	= dataTypeArray ;
  		argumentArray[4]	= "1,2";
  		argumentArray[5]	= obj_ref.value ;//Target
 		argumentArray[6]    = CODE_LINK ;
 		argumentArray[7]    = CODE_DESC ;
 		
  		retVal				= CommonLookup(getLabel("eOR.PatientSearch.label","OR"), argumentArray );
 		if(retVal!=null && retVal!='')
	  	{
    		if(field_mnemonic=="NN_MOTHER_PAT_ID") // Field Mnemonic in OT
			{
				var form_obj 	= document.OrderFormatForm
 				for(var i=0;i<form_obj.length;i++)	//To get the concerned field_mnemonic and disabled
				{
					 if(form_obj[i].type=="text") // For Text box
					 {
  						if(form_obj[i].name.indexOf(field_mnemonic)!=-1 )
						{   
 							form_obj[i].value	 = retVal[0];		// set the patient_id
							form_obj[i].readOnly = true;
						}
						else if(form_obj[i].name.indexOf("NN_MOTHER_PAT_NAME")!=-1 ) // for the patient_name to be made readonly
						{  
 				 			form_obj[i].value	 = retVal[1];		// set the patient_name
							form_obj[i].readOnly = true;
						}
					 } // End of if form_obj[i].type
					 else if(form_obj[i].type=="button") // For Button
					 {
						if(form_obj[i].name.indexOf("PATIENT_NM_LOOKUP")!=-1 ) // for the button to be disabled
						{ 
 				 			form_obj[i].disabled = true;
						}
					 }
				} // End of for i
			} // End of Field Mnemonic 
  	    } // End of retVal*/
	} 
}// End of the showPatientLookUp
//function resetRadioButtons(field_mnemonic, radio_count){
function resetRadioButtons(field_mnemonic, radio_count,dependency_yn,new_seq_num,max_dependency_rows){
  	if(eval("document.OrderFormatForm."+field_mnemonic))
	 	eval("document.OrderFormatForm."+field_mnemonic+".value=''");
	//formObjFirst.radio_but[0].checked
	if(radio_count==1) {
	  	if(eval("document.OrderFormatForm.radio_"+field_mnemonic))
			eval("document.OrderFormatForm.radio_"+field_mnemonic+".checked=false;");
	} else {  //more than one radio button for the radio group
	var new_seq_num_length   = 0;
	if(new_seq_num <10)
		new_seq_num_length   = 1;
	else if(new_seq_num <100)
		new_seq_num_length   = 2;
	else 
		new_seq_num_length   = 3;
		new_field_name			 = field_mnemonic.substring(0, ((field_mnemonic.length)-new_seq_num_length));
		for(i=0;i<radio_count;i++){
			if(eval("document.OrderFormatForm.radio_"+field_mnemonic+"["+i+"]"))
			eval("document.OrderFormatForm.radio_"+field_mnemonic+"["+i+"].checked=false;")
		}
	}
	if(dependency_yn=="Y")
	{
		hideColumns(new_field_name, max_dependency_rows, new_seq_num);
	}
	
}
/*Added by Uma on 3/25/2010 for IN020184*/
function InvalidPatient()
{	
	alert(getMessage('INVALID_PATIENT','OR'));
}

function displayPatientName(mother_patient_id,mother_patient_name,field_mnemonic)
{
	var form_obj 	= document.OrderFormatForm;
	if(field_mnemonic=="NN_MOTHER_PAT_ID") // Field Mnemonic in OT
	{
		for(var i=0;i<form_obj.length;i++)	//To get the concerned field_mnemonic and disabled
		{
			 if(form_obj[i].type=="text") // For Text box
			 {
				if(form_obj[i].name.indexOf(field_mnemonic)!=-1 )
				{   
					form_obj[i].value	 = mother_patient_id;		// set the patient_id
					form_obj[i].readOnly = true;
				}
				else if(form_obj[i].name.indexOf("NN_MOTHER_PAT_NAME")!=-1 ) // for the patient_name to be made readonly
				{  
					form_obj[i].value	 = mother_patient_name;		// set the patient_name
					form_obj[i].readOnly = true;
				}
			 } // End of if form_obj[i].type
			 else if(form_obj[i].type=="button") // For Button
			 {
				if(form_obj[i].name.indexOf("PATIENT_NM_LOOKUP")!=-1 ) // for the button to be disabled
				{ 
					form_obj[i].disabled = true;
				}
			 }
		} // End of for i
	} // End of Field Mnemonic 
}
/*Ends Here by Uma on 3/25/2010 for IN020184*/

//IN049133 - Start
function checkOthDependency(obj, format_id, field_mnemonic, new_seq_num, seq_num, dependency_yn, order_category, contr_msr_panel_id, contr_msr_mod_id, order_type_code, discr_msr_id, performing_facility_id, oper_side_appl_yn, specimen_def_yn, login_facility_id, sex,catalog_code)
{
	var form = document.getElementById("OrderFormatForm");
	var field_type = form["field_type"+obj.name].value;
  	var field_value			 = obj.value;
	if(order_category=="OT" && field_type=="L" && field_mnemonic=="SURGERY_TYPE")
	{
		var field_values = field_value.split("||");	
		field_value = field_values[1];
	}	
    var field_length	     = obj.name.length;
	var new_seq_num_length   = 0;
	if(new_seq_num <10)
		new_seq_num_length   = 1;
	else if(new_seq_num <100)
		new_seq_num_length   = 2;
	else 
		new_seq_num_length   = 3;
	
 	new_field_name			 = (obj.name).substring(0, (field_length-new_seq_num_length));

	if(dependency_yn=="Y") 
	{
		var bean_id		= document.OrderFormatForm.bean_id.value;
		var bean_name	= document.OrderFormatForm.bean_name.value;
		
	 	if(field_type=="C") 
		{ 
 			if(obj.checked == true)
				field_value = "Yes";
			else if(obj.checked==false)
				field_value = "No";		
		} else if(field_type=="L" || field_type=="R")
		{
 			if(obj.value=='') 
			{
				return;
			} 
		} 
		
		if(field_type=="E" || field_type=="T") // FOR DATE AND TIME, PASS THIS TO GET THE  VALIDATIONS
			field_value		= "CURRENT_DATE_TIME";
		else if (field_type=="D" )
			field_value		= "CURRENT_DATE";	
	
   		query_string	= "bean_id="+bean_id+"&bean_name="+bean_name+"&func_mode=CHECK_OTH_DEPENDENCY&field_value="+escape(field_value)+"&field_name="+escape(obj.name)+"&new_field_name="+escape(new_field_name)+"&catalog_code="+catalog_code
	
   		//var xmlDoc 		= new ActiveXObject( "Microsoft.XMLDom" ) ;
		//var xmlHttp 	= new ActiveXObject( "Microsoft.XMLHTTP" ) ;
		var xmlHttp = new XMLHttpRequest();
 		xmlStr			= "<root><SEARCH " ;
		xmlStr			+= "format_id=\""+ format_id +"\" " ;
		xmlStr			+= "field_mnemonic=\""+ field_mnemonic +"\" " ;
		xmlStr			+= "seq_num=\""+ seq_num +"\" " ;
		xmlStr			+= "new_seq_num=\""+ new_seq_num +"\" " ;
		xmlStr			+= "order_category=\""+ order_category +"\" " ;
		xmlStr			+= "contr_msr_panel_id=\""+ contr_msr_panel_id +"\" " ;
		xmlStr			+= "contr_msr_mod_id=\""+ contr_msr_mod_id +"\" " ;
		xmlStr			+= "order_type_code=\""+ order_type_code +"\" " ;
		xmlStr			+= "discr_msr_id=\""+ discr_msr_id +"\" " ;
		xmlStr			+= "performing_facility_id=\""+ performing_facility_id +"\" " ;
 		xmlStr			+= "login_facility_id=\""+login_facility_id+"\" " ;
		xmlStr			+= "sex=\""+sex+"\" " ;
		xmlStr			+= "catalog_code=\""+catalog_code+"\" " ;
		xmlStr			+= "oper_side_appl_yn=\""+ oper_side_appl_yn +"\" " ;
		xmlStr			+= "specimen_def_yn=\""+ specimen_def_yn +"\" " ;
		xmlStr			+= "field_type=\""+ field_type +"\" " ;
 		xmlStr 			+=" /></root>" ;
 		var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "OrderEntryOrderFormatDependency.jsp?"+query_string, false ) ;
		xmlHttp.send( xmlDoc ) ;
		responseText=xmlHttp.responseText ;
		eval( responseText ) ;
 	} // End of dependency_yn
} 

function loadDecisionOthDependency(field_name, new_field_name, bean_id, bean_name, field_value, format_id, field_mnemonic, new_seq_num, seq_num, field_mnemonic_value, value_seq_num, field_value_type, field_mnemonic_action, field_action_msg, order_category, contr_msr_panel_id, contr_msr_mod_id, order_type_code, discr_msr_id, performing_facility_id, oper_side_appl_yn, specimen_def_yn,  login_facility_id, sex, catalog_code,field_mnemonic_value1) 
{

	 var field_type			 = document.getElementById("field_type"+field_name).value;
	 var old_field_value	 = document.getElementById(field_name).value;
  	 var field_action_msg    = "APP-OR0300 "+field_action_msg;
 	 // if not checkbox and list box then do not display it here.
 	 if(field_mnemonic_action!=null && field_mnemonic_action!="N" && field_action_msg!=null && field_action_msg!="" && field_type!="D" && field_type!="T" && field_type!="E" && field_type!="N" && field_type!="I")
	 {
		  alert(field_action_msg);
	 }
	 document.getElementById("field_mnemonic_action"+(field_name)).value = field_mnemonic_action;
	 document.getElementById("field_action_msg"+(field_name)).value		 = field_action_msg;
	 document.getElementById("field_value_type"+(field_name)).value		 = field_value_type;
	 document.getElementById("oth_dependency_yn"+(field_name)).value	 = "Y";
		
	 if(field_type!="C" && field_type!="L" && field_type!="R" && field_mnemonic_action!="N") // checkboxes and list boxes avoid 
	 {
	  	 checkDependencyValidation(field_name, field_type, field_value_type, field_action_msg, field_mnemonic_value, field_mnemonic_value1 ,field_mnemonic_action);
	 }
}
//IN049133 - End

