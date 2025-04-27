/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
/*
-------------------------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        	Description
-------------------------------------------------------------------------------------------------------------------------------------
23/09/2011	 28806			 Menaka		 	Incident No: 28806 - <Radiology order-> setup schedule 
											applicable=Checked , it can?t change start date by click on ?Start date? header and can?t click on ?calendar icon? but user can change start date by typing new date and time on that field.>	
20/01/2012	IN029143		Menaka V		<JD-CRF-0111 This option is available in HIS 2.x and KAUH needs to be in
											EM version. In the current workflow the option is being used frequently. When a physician selects the patient, system will ask to enter the PIN Code. Physician needs to authenticate in the Prescription screen using the PIN code. This will prevent from unauthorised access while the physician is on rounds>.		
23/01/2012  IN030563    	Ramesh G   		The Pin No. for placing ordering is selected as Logged in Practitioner s
											Pin ? Prompt once for all categories. But the Pin No. is prompted each time we Place a Category and also when we record the category.
25/01/2012	IN030566		Ramesh G		When we place another Order of the same category the Pin No. is prompted
											again even if the Patient chart is not closed.
15/02/2012  IN031116		Menaka V		Functionality equivalent to 5.x, placing consultation order.		
25/09/2012	IN030279		Ramesh G		Bru-HIMS-CRF-160
04/12/2012	IN036535		Ramesh G		Select the Order Catalog->Order Entry Window Un check the Order and click on Place Order->A Blank Page is displayed
11/12/2013  IN045512		Nijithas	    The dependent field option is not displayed in View Order Format
02/07/2014	IN048467 		Nijitha S		HSA-CRF-0150
17/08/2015  IN056822        Ramesh          HSA-SCF-0283
18/10/2016  IN060565		Raja			ML-MMOH-SCF-0412
30/11/2016	 IN062319	   Karthi L											ML-MMOH-CRF-0508.1 [IN062319]
17/07/2018		IN064543		Kamalakannan		 17/07/2018		Ramesh G		ML-MMOH-CRF-0776
01/08/2018		IN64543			Dinesh T		01/08/2018	Ramesh G		ML-MMOH-CRF-0776
22/07/2018		IN068445		Kamalakannan	22/07/2018		Ramesh G		ML-MMOH-CRF-0776
27/05/2019	IN069027	Ramesh G								MMS-DM-CRF-0150	
01-09-2020	IN072275	Nijitha S
31/05/2023		44884		Krishna			MO-CRF-20183
-------------------------------------------------------------------------------------------------------------------------------------
*/  
// Set for the Frequency
function setFrequency(obj,i,catalog_code,facility_id,val)
{

	eval("document.placeOrderForm.end_date_time"+i+".value=''");
	eval("document.placeOrderForm.duration_code"+i+".value=''");
	eval("document.placeOrderForm.frequency_val"+i+".value=''");
	eval("document.placeOrderForm.freq_nature"+i+".value=''");
	eval("document.placeOrderForm.start_date_time"+i+".readOnly=false");
	eval("document.placeOrderForm.repeat_value"+i+".value=''");

	removeSchedule(i, catalog_code); // To remove the Schedule Frequency

 	if(obj.value!='')
	{
		if(val=="onChange")
			eval("document.placeOrderForm.duration_value"+i+".value=''");

		var bean_id 	= document.placeOrderForm.bean_id.value ;
		var bean_name 	= document.placeOrderForm.bean_name.value ;
	var xmlDoc = "";
		var xmlHttp = new XMLHttpRequest();
		xmlStr			= "<root><SEARCH " ;
		//xmlStr 			+= name+"=\""+ value +"\" " ;
		xmlStr 			+=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "OrderEntryValidate.jsp?bean_id=" + bean_id + "&bean_name="+ bean_name +"&row_value="+i+"&func_mode=DURATIONVALUES", false ) ;
		xmlHttp.send( xmlDoc ) ;
		responseText	= xmlHttp.responseText ;
		eval( responseText ) ;
		var value = obj.value.split("~~");
		if(value[0]==null) value[0] = "";
		if(value[1]==null) value[1] = "";
		if(value[2]==null) value[2] = "";if(value[3]==null) value[3] = "";if(value[5]==null) value[5] = "N";//Schedule_yn
		if(value[6]==null) value[6] = "F"; //freq_nature
		if(value[1] == "" && eval("document.placeOrderForm.group_order_category"+i).value=="PH" ){
			value[0] ="ONCE" ;
			value[1] ="D" ;
			value[2] ="1" ;
			eval("document.placeOrderForm.duration_value"+i+".value='1'");
		}
		eval("document.placeOrderForm.frequency_val"+i+".value=value[0]");
		eval("document.placeOrderForm.duration_code"+i+".value=value[1]");
		
		if(eval("document.placeOrderForm.duration_code"+i))
		{
			if(eval("document.placeOrderForm.duration_code"+i).options)
			{
				var len=eval("document.placeOrderForm.duration_code"+i).options.length;
				if(len>1)
				{
					for(var durlen=0;durlen<(len-1);durlen++)
					{
									
						if(document.getElementById('duration_code'+i).options[durlen].value!='')
						{		
							if(trimString(document.getElementById('duration_code'+i).options[durlen].value)==trimString(value[1]))
							{
								document.getElementById('duration_code'+i).options[durlen].selected=true;
								durlen=len;
							}
						}
					}
				}
			}
		}
		//eval("document.placeOrderForm.duration_code"+i+".value=value[1]");
		eval("document.placeOrderForm.duration_def_value"+i+".value=value[2]");
		eval("document.placeOrderForm.repeat_value"+i+".value=value[3]");
		eval("document.placeOrderForm.freq_nature"+i+".value= value[6]");
 		if(value[0]==null || value[0]=="" || value[1]== null || value[1]=="")
		{
			//eval("document.placeOrderForm.duration_value"+i+".value=''");
			eval("document.placeOrderForm.duration_value"+i+".readOnly=true");
		}
		else
			eval("document.placeOrderForm.duration_value"+i+".readOnly=false");

		//	eval("<a href="javascript:DisplaySchedule('Schedule<%=records[0]%>','<%=i%>','<%=bean.getLoginFacilityId()%>')" title='Schedule'>Schd</a>
		if(value[5]=="Y")
		{
			document.getElementById("schedule_yn"+i).value = value[5];
			document.getElementById("schedule"+i).innerHTML = "<a class='gridLink' href=javascript:DisplaySchedule('"+catalog_code+"','Schedule"+catalog_code+"','"+i+"','"+facility_id+"','')  title='Schedule Frequency'><font size='1'>'"+getLabel("eOR.Schd.label","OR")+"'</font></a><img src='../../eCommon/images/mandatory.gif'></img> ";
		}
		else
		{
			document.getElementById("schedule"+i).innerHTML="&nbsp";
			document.getElementById("schedule_yn"+i).value = value[5];
		}
		// If start_date_time, duration_code and duration_value is not null it should calculate the end_date_time
		start_date_time = eval("document.placeOrderForm.start_date_time"+i+".value");
		duration_code	= eval("document.placeOrderForm.duration_code"+i+".value");
		duration_value = eval("document.placeOrderForm.duration_value"+i+".value");
		calculateEndDateTime(start_date_time,duration_code,duration_value,i,'');	//start_date_time,Duration Code,Duration Value,called_from is null
	}
	else
	{
		eval("document.placeOrderForm.duration_value"+i+".value=''");
		eval("document.placeOrderForm.repeat_value"+i+".value=''");
		eval("document.placeOrderForm.duration_value"+i+".readOnly=true");
		document.getElementById("schedule"+i).innerHTML="&nbsp;";
	document.getElementById("schedule_yn"+i).value = 'N';
	}
}

function removeSchedule(i, catalog_code){ // to remove the schedule frequency set
// Call the dynamic jsp to remove the value (Schedule Frequency) from the bean.
	var bean_id 	= document.placeOrderForm.bean_id.value ;
	var bean_name 	= document.placeOrderForm.bean_name.value ;
	var xmlDoc = "";
	var xmlHttp = new XMLHttpRequest();
	xmlStr			= "<root><SEARCH " ;
	//xmlStr 			+= name+"=\""+ value +"\" " ;
	xmlStr 			+=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "OrderEntryValidate.jsp?bean_id=" + bean_id + "&bean_name="+ bean_name +"&catalog_code="+catalog_code+"&row_value="+i+"&func_mode=REMOVE_SCHEDULE", false ) ;
	xmlHttp.send( xmlDoc ) ;
	responseText	= xmlHttp.responseText ;
	eval( responseText ) ;
} // end of removeSchedule

// Set for the Frequency in the Amend/Review Order
function setAmendFrequency(obj, i, catalog_code ,facility_id, val,order_category,amend_appt_reqd_yn)//28806 modified by Menaka
{

	eval("document.placeOrderForm.amend_end_date_time"+i+".value=''");
	eval("document.placeOrderForm.amend_duration_code"+i+".value=''");
	if(val!="onload"){//added by channaveer b for second point in ICN24842 on 15/11/2010.
	eval("document.placeOrderForm.amend_frequency_val"+i+".value=''");
	}
	eval("document.placeOrderForm.amend_freq_nature"+i+".value=''");
	//28806 modification starts by Menaka
	if(order_category == "RD" && amend_appt_reqd_yn == "Y")
	{
		eval("document.placeOrderForm.amend_start_date_time"+i+".readOnly=true");
	}
	else
	{	
		eval("document.placeOrderForm.amend_start_date_time"+i+".readOnly=false");
	}//28806 modification end by Menaka
	removeSchedule(i, catalog_code); // To remove the Schedule Frequency
	if(obj.value!='')
	{
		if(val=="onChange")
			eval("document.placeOrderForm.amend_duration_value"+i+".value=''");
		var value = obj.value.split("~~");
		if(value[0]==null) value[0] = "";
		if(value[1]==null) value[1] = "";
		if(value[2]==null) value[2] = "";
		if(value[5]==null) value[5] = "N";//Schedule_yn
		if(value[6]==null) value[6] = "F"; //freq_nature
		if(val!="onload")
		{
		eval("document.placeOrderForm.amend_frequency_val"+i+".value=value[0]");
		}
		
		
		eval("document.placeOrderForm.amend_duration_code"+i+".value=value[1]");

		eval("document.placeOrderForm.amend_duration"+i+".value=value[1]");
		var bean_id 	= document.placeOrderForm.bean_id.value ;
		var bean_name 	= document.placeOrderForm.bean_name.value ;
		var xmlDoc = "";
		var xmlHttp = new XMLHttpRequest();
		xmlStr			= "<root><SEARCH " ;
		//xmlStr 			+= name+"=\""+ value +"\" " ;
		xmlStr 			+=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "OrderEntryValidate.jsp?bean_id=" + bean_id + "&bean_name="+ bean_name +"&row_value="+i+"&func_mode=AMENDDURATIONVALUES", false ) ;
		xmlHttp.send( xmlDoc ) ;
		responseText	= xmlHttp.responseText ;
		eval( responseText ) ;

		if(eval("document.placeOrderForm.amend_duration_code"+i))
		{
			if(eval("document.placeOrderForm.amend_duration_code"+i).options)
			{
				var len=eval("document.placeOrderForm.amend_duration_code"+i).options.length;
				if(len>1)
				{
					for(var durlen=0;durlen<(len-1);durlen++)
					{
									
						if(eval("document.placeOrderForm.amend_duration_code"+i).options[durlen].value!='')
						{		
							if(trimString(eval("document.placeOrderForm.amend_duration_code"+i).options[durlen].value)==trimString(value[1]))
							{
								eval("document.placeOrderForm.amend_duration_code"+i).options[durlen].selected=true;
								durlen=len;
							}
						}
					}
				}
			}
		}
		if(val!="onload")
		{
			if(val!="onDateChange")
				eval("document.placeOrderForm.amend_duration_value"+i+".value=value[2]");
		
		eval("document.placeOrderForm.amend_freq_nature"+i+".value= value[6]");
		if(value[0]==null || value[0]=="" || value[1]== null || value[1]=="")
		{
			//eval("document.placeOrderForm.amend_duration_value"+i+".value=''");
			eval("document.placeOrderForm.amend_duration_value"+i+".readOnly=true");
		}
		else
			eval("document.placeOrderForm.amend_duration_value"+i+".readOnly=false");
		if(value[5]=="Y")
		{
		document.getElementById("amend_schedule"+i).innerHTML = "<a class='gridLink' href=javascript:DisplaySchedule('"+catalog_code+"','Schedule"+catalog_code+"','"+i+"','"+facility_id+"','AMEND')  title='Schedule Frequency'><font size='1'>'"+getLabel("eOR.Schd.label","OR")+"'</font></a><img src='../../eCommon/images/mandatory.gif'></img>" ;
			document.getElementById("amend_schedule_yn"+i).value = value[5];
		}
		else
		{
			document.getElementById("amend_schedule"+i).innerHTML="&nbsp;";
			document.getElementById("amend_schedule_yn"+i).value = value[5];
		}
		// If amend_start_date_time, amend_duration_code and amend_duration_value is not null it should calculate the end_date_time
		amend_start_date_time	= eval("document.placeOrderForm.amend_start_date_time"+i+".value");
		amend_duration_code 	= eval("document.placeOrderForm.amend_duration_code"+i+".value");
		amend_duration_value	= eval("document.placeOrderForm.amend_duration_value"+i+".value");
		calculateEndDateTime(amend_start_date_time,amend_duration_code,amend_duration_value,i,'AMEND');	//start_date_time,Duration Code,Duration Value,called_from is null
		}
	}
	else
	{
		eval("document.placeOrderForm.amend_duration_value"+i+".value=''");
		eval("document.placeOrderForm.amend_duration_value"+i+".readOnly=true");
		document.getElementById("amend_schedule"+i).innerHTML="&nbsp;";
		document.getElementById("amend_schedule_yn"+i).value = 'N';
	}
	setValue("amend_frequency_code"+catalog_code,obj.value);
}

// On press of the Preview Button in the Place Order
async function preview()
{
	var dialogHeight; var dialogWidth; var dialogTop; var dialogLeft;
	var htmlText 		= new Array();
	var arrInd 	 		= 0;
	var headerObj		= criteriaPlaceOrderFrame.criteriaMainFrame.document.placeOrderHeaderForm;
	var formObj			= criteriaPlaceOrderFrame.placeOrderDetailFrame.document.placeOrderForm;
	var form			= criteriaPlaceOrderFrame.placeOrderDetailFrame.document.getElementById("placeOrderForm");
	var total_rows		= formObj.total_rows.value;
	var amend_total_rows		= formObj.amend_total_rows.value;
	var count 			= 0;
	if((total_rows > 0) ||(amend_total_rows>0))
	{
		htmlText[arrInd++]	     = "<html><head></head><body><form name=\"dummyForm\" id=\"dummyForm\" >";
		htmlText[arrInd++]	     = "<input type=\"hidden\" name=\"bean_id\" id=\"bean_id\" value=\""+formObj.bean_id.value+"\">";
		htmlText[arrInd++]	     = "<input type=\"hidden\" name=\"bean_name\" id=\"bean_name\" value=\""+formObj.bean_name.value+"\">";
		htmlText[arrInd++]	     = "<input type=\"hidden\" name=\"facility_name\" id=\"facility_name\" value=\""+headerObj.facility_name.value+"\">";
		htmlText[arrInd++]	     = "<input type=\"hidden\" name=\"patient_id\" id=\"patient_id\" value=\""+headerObj.patient_id.value+"\">";
		htmlText[arrInd++]	     = "<input type=\"hidden\" name=\"encounter_id\" id=\"encounter_id\" value=\""+headerObj.encounter_id.value+"\">";
		htmlText[arrInd++]	     = "<input type=\"hidden\" name=\"physician_name\" id=\"physician_name\" value=\""+headerObj.physician_name.value+"\">";
		htmlText[arrInd++]	     = "<input type=\"hidden\" name=\"order_date_time\" id=\"order_date_time\" value=\""+headerObj.order_date_time.value+"\">";
		htmlText[arrInd++]	     = "<input type=\"hidden\" name=\"sex\" id=\"sex\" value=\""+headerObj.sex.value+"\">";
		htmlText[arrInd++]	     = "<input type=\"hidden\" name=\"age\" id=\"age\" value=\""+headerObj.age.value+"\">";
		htmlText[arrInd++]	     = "<input type=\"hidden\" name=\"dob\" id=\"dob\" value=\""+headerObj.dob.value+"\">";
		htmlText[arrInd++]	     = "<input type=\"hidden\" name=\"location_type\" id=\"location_type\" value=\""+headerObj.location_type.value+"\">";
		htmlText[arrInd++]	     = "<input type=\"hidden\" name=\"location_code\" id=\"location_code\" value=\""+headerObj.location_code.value+"\">";
		htmlText[arrInd++]	     = "<input type=\"hidden\" name=\"location_name\" id=\"location_name\" value=\""+headerObj.location_name.value+"\">";
		htmlText[arrInd++]	     = "<input type=\"hidden\" name=\"nationality\" id=\"nationality\" value=\""+headerObj.nationality.value+"\">";
		htmlText[arrInd++]	     = "<input type=\"hidden\" name=\"patient_name\" id=\"patient_name\" value=\""+headerObj.patient_name.value+"\">";
		htmlText[arrInd++]	     = "<input type=\"hidden\" name=\"order_category\" id=\"order_category\" value=\""+headerObj.order_category.value+"\">";

		var ammend_called_from   = headerObj.ammend_called_from.value;
		if(ammend_called_from!="existing_order")
		{
			priority_code 		= headerObj.priority.item(headerObj.priority.selectedIndex);
			priority 		  	= priority_code.text;
		}
		else
		{
			priority	 		= headerObj.priority.value;
			//if(priority=="R")		priority = "Routine";
			//else if(priority=="U")	priority = "Urgent";
			//else if(priority=="S")	priority = "Stat";
		}
		htmlText[arrInd++]	     = "<input type=\"hidden\" name=\"priority\" id=\"priority\" value=\""+priority+"\">";
		htmlText[arrInd++]	     = "<input type=\"hidden\" name=\"sys_date\" id=\"sys_date\" value=\""+formObj.sys_date.value+"\">";
		htmlText[arrInd++]	     = "<input type=\"hidden\" name=\"ammend_called_from\" id=\"ammend_called_from\" value=\""+ammend_called_from+"\">";

		for (v=0;v<total_rows;v++)
		{
		  	if(eval("formObj.catalog_code"+v))
		  	{
				var catalog_code_val = eval("formObj.catalog_code"+v+".value");
			//	var checked_yn		 = eval("formObj.ck"+catalog_code_val+".value")
				var checked_yn		 = form["ck"+catalog_code_val].value
				if(checked_yn=="Y") // Only if it is checked
				{
					htmlText[arrInd++]	= "<input type=\"hidden\" name=\"performing_facility_id"+count+"\" id=\"performing_facility_id"+count+"\" value=\""+eval("formObj.performing_facility_id"+v+".value")+"\">";
					htmlText[arrInd++]	= "<input type=\"hidden\" name=\"cat_desc"+count+"\" id=\"cat_desc"+count+"\" value=\""+eval("formObj.cat_desc"+v+".value")+"\">";
					htmlText[arrInd++]	= "<input type=\"hidden\" name=\"priority"+count+"\" id=\"priority"+count+"\" value=\""+eval("formObj.priority"+v+".value")+"\">";
					htmlText[arrInd++]	= "<input type=\"hidden\" name=\"catalog_code"+count+"\" id=\"catalog_code"+count+"\" value=\""+eval("formObj.catalog_code"+v+".value")+"\">";
					htmlText[arrInd++]	= "<input type=\"hidden\" name=\"instrn_content_type"+count+"\" id=\"instrn_content_type"+count+"\" value=\""+eval("formObj.instrn_content_type"+v+".value")+"\">";//IN064543
					pr_value 			= eval("formObj.priority"+v+".value;");
		 			if(pr_value!=null && pr_value!="")
					{
						var prSelIndex 	= eval("formObj.priority"+v+".selectedIndex;");
						var prOption 	= eval("formObj.priority"+v+".item("+prSelIndex+");");
						htmlText[arrInd++]	= "<input type=\"hidden\" name=\"priority_desc"+count+"\" id=\"priority_desc"+count+"\" value=\""+prOption.text+"\">";
					}
					else htmlText[arrInd++]	= "<input type=\"hidden\" name=\"priority_desc"+count+"\" id=\"priority_desc"+count+"\" value=''>";
					htmlText[arrInd++]	= "<input type=\"hidden\" name=\"frequency"+count+"\" id=\"frequency"+count+"\" value=\""+eval("formObj.frequency_val"+v+".value")+"\">";
					freq_value			= eval("formObj.frequency_val"+v+".value;");
					if(freq_value!=null && freq_value!="")
		 			{
						var freqSelIndex= eval("formObj.frequency_code"+v+".selectedIndex;");
						var freqOption 	= eval("formObj.frequency_code"+v+".item("+freqSelIndex+");");
						htmlText[arrInd++]	= "<input type=\"hidden\" name=\"frequency_code_arr"+count+"\" id=\"frequency_code_arr"+count+"\" value=\""+freqOption.text+"\">";
					}
					else htmlText[arrInd++]	= "<input type=\"hidden\" name=\"frequency_code_arr"+count+"\" id=\"frequency_code_arr"+count+"\" value=''>";

					htmlText[arrInd++]	= "<input type=\"hidden\" name=\"start_date_time"+count+"\" id=\"start_date_time"+count+"\" value=\""+eval("formObj.start_date_time"+v+".value")+"\">";
					htmlText[arrInd++]	= "<input type=\"hidden\" name=\"end_date_time"+count+"\" id=\"end_date_time"+count+"\" value=\""+eval("formObj.end_date_time"+v+".value")+"\">";
					htmlText[arrInd++]	= "<input type=\"hidden\" name=\"performing_dept_loc_code"+count+"\" id=\"performing_dept_loc_code"+count+"\" value=\""+eval("formObj.performing_dept_loc_code"+v+".value")+"\">";
					htmlText[arrInd++]	= "<input type=\"hidden\" name=\"ord_spl_appr_reqd_yn"+count+"\" id=\"ord_spl_appr_reqd_yn"+count+"\" value=\""+eval("formObj.ord_spl_appr_reqd_yn"+v+".value")+"\">";
					htmlText[arrInd++]	= "<input type=\"hidden\" name=\"order_type_code"+count+"\" id=\"order_type_code"+count+"\" value=\""+eval("formObj.order_type_code"+v+".value")+"\">";
					orderType			= eval("formObj.order_type_code"+v+".value ")
					if(orderType!=null && orderType!="")
					{
						var orSelIndex	= eval("formObj.order_type_code"+v+".selectedIndex;");
						var OrderOption	= eval("formObj.order_type_code"+v+".item("+orSelIndex+");");
						htmlText[arrInd++]	= "<input type=\"hidden\" name=\"order_type_desc"+count+"\" id=\"order_type_desc"+count+"\" value=\""+OrderOption.text+"\">";
					}
					else
					{
						htmlText[arrInd++]	= "<input type=\"hidden\" name=\"order_type_desc"+count+"\" id=\"order_type_desc"+count+"\" value=''>";
					}

					htmlText[arrInd++]	= "<input type=\"hidden\" name=\"duration_value"+count+"\" id=\"duration_value"+count+"\" value=\""+eval("formObj.duration_value"+v+".value")+"\">";
					htmlText[arrInd++]	= "<input type=\"hidden\" name=\"duration_code"+count+"\" id=\"duration_code"+count+"\" value=\""+eval("formObj.duration_code"+v+".value")+"\">";
					duration_code		= eval("formObj.duration_code"+v+".value;");
					/*if(duration_code=="M")		duration_value = "Minute(S)";
					else if(duration_code=="H")	duration_value = "Hour(S)";
					else if(duration_code=="D")	duration_value = "Day(S)";
					else if(duration_code=="W")	duration_value = "Week(S)";
					else if(duration_code=="L")	duration_value = "Month(S)";
					else duration_value = "";*/
					htmlText[arrInd++]	= "<input type=\"hidden\" name=\"duration_desc"+count+"\" id=\"duration_desc"+count+"\" value=\""+duration_code+"\">";
					if(eval("formObj.appt_reqd_yn"+v+".value")=="Y") 
					{
						if(pr_value=="R")  // If priority is R (Routine)
						{
							appt_reqd_yn = eval("formObj.routine_appt_reqd_yn"+v+".value");
						}
						else if(pr_value=="D")  // If priority is S (Stat)
						{
							appt_reqd_yn = eval("formObj.stat_appt_reqd_yn"+v+".value");
						}
						else if(pr_value=="U")  // If priority is U (Urgent)
						{
							appt_reqd_yn = eval("formObj.urgent_appt_reqd_yn"+v+".value");
						}
					}
					else 
					{
						appt_reqd_yn = "N"; 
					}
  					htmlText[arrInd++]	= "<input type=\"hidden\" name=\"appt_reqd_yn"+count+"\" id=\"appt_reqd_yn"+count+"\" value=\""+appt_reqd_yn+"\">";
					htmlText[arrInd++]	= "<input type=\"hidden\" name=\"chart_result_type"+count+"\" id=\"chart_result_type"+count+"\" value=\""+eval("formObj.chart_result_type"+v+".value")+"\">";
					count++;
				}
			} // End of if catalog_code
		} // End of for
		/*Added by Uma on 5/5/2010 for IN021062*/
		for (v=0;v<amend_total_rows;v++)
		{
		  	if(eval("formObj.amend_catalog_code"+v))
		  	{
				var catalog_code_val = eval("formObj.amend_catalog_code"+v+".value");
				var checked_yn		 = form["ck"+catalog_code_val].value
				if(checked_yn=="Y") // Only if it is checked
				{
					htmlText[arrInd++]	= "<input type=\"hidden\" name=\"performing_facility_id"+count+"\" id=\"performing_facility_id"+count+"\" value=\""+eval("formObj.amend_performing_facility_id"+v+".value")+"\">";
					htmlText[arrInd++]	= "<input type=\"hidden\" name=\"cat_desc"+count+"\" id=\"cat_desc"+count+"\" value=\""+eval("formObj.amend_cat_desc"+v+".value")+"\">";
					htmlText[arrInd++]	= "<input type=\"hidden\" name=\"priority"+count+"\" id=\"priority"+count+"\" value=\""+eval("formObj.amend_priority"+v+".value")+"\">";
					htmlText[arrInd++]	= "<input type=\"hidden\" name=\"catalog_code"+count+"\" id=\"catalog_code"+count+"\" value=\""+eval("formObj.amend_catalog_code"+v+".value")+"\">";
					htmlText[arrInd++]	= "<input type=\"hidden\" name=\"instrn_content_type"+count+"\" id=\"instrn_content_type"+count+"\" value=\""+eval("formObj.amend_instrn_content_type"+v+".value")+"\">";//IN064543
					pr_value 			= eval("formObj.amend_priority"+v+".value");
					if(pr_value!=null && pr_value!="")
					{
						htmlText[arrInd++]	= "<input type=\"hidden\" name=\"priority_desc"+count+"\" id=\"priority_desc"+count+"\" value=\""+pr_value+"\">";
					}
					else 
					{
						htmlText[arrInd++]	= "<input type=\"hidden\" name=\"priority_desc"+count+"\" id=\"priority_desc"+count+"\" value=''>";
					}
					htmlText[arrInd++]	= "<input type=\"hidden\" name=\"frequency"+count+"\" id=\"frequency"+count+"\" value=\""+eval("formObj.amend_frequency_val"+v+".value")+"\">";
					freq_value			= eval("formObj.amend_frequency_val"+v+".value;");
					if(freq_value!=null && freq_value!="")
		 			{
						var freqSelIndex= eval("formObj.amend_frequency_code"+v+".selectedIndex;");
						var freqOption 	= eval("formObj.amend_frequency_code"+v+".item("+freqSelIndex+");");
						htmlText[arrInd++]	= "<input type=\"hidden\" name=\"frequency_code_arr"+count+"\" id=\"frequency_code_arr"+count+"\" value=\""+freqOption.text+"\">";
					}
					else htmlText[arrInd++]	= "<input type=\"hidden\" name=\"frequency_code_arr"+count+"\" id=\"frequency_code_arr"+count+"\" value=''>";

					htmlText[arrInd++]	= "<input type=\"hidden\" name=\"start_date_time"+count+"\" id=\"start_date_time"+count+"\" value=\""+eval("formObj.amend_start_date_time"+v+".value")+"\">";
					htmlText[arrInd++]	= "<input type=\"hidden\" name=\"end_date_time"+count+"\" id=\"end_date_time"+count+"\" value=\""+eval("formObj.amend_end_date_time"+v+".value")+"\">";
					htmlText[arrInd++]	= "<input type=\"hidden\" name=\"performing_dept_loc_code"+count+"\" id=\"performing_dept_loc_code"+count+"\" value=\""+eval("formObj.amend_performing_dept_loc_code"+v+".value")+"\">";
					htmlText[arrInd++]	= "<input type=\"hidden\" name=\"ord_spl_appr_reqd_yn"+count+"\" id=\"ord_spl_appr_reqd_yn"+count+"\" value=\""+eval("formObj.amend_ord_spl_appr_reqd_yn"+v+".value")+"\">";
					htmlText[arrInd++]	= "<input type=\"hidden\" name=\"order_type_code"+count+"\" id=\"order_type_code"+count+"\" value=\""+eval("formObj.amend_order_type"+v+".value")+"\">";
					orderType			= eval("formObj.amend_order_type"+v+".value ")
					if(orderType!=null && orderType!="")
					{
						htmlText[arrInd++]	= "<input type=\"hidden\" name=\"order_type_desc"+count+"\" id=\"order_type_desc"+count+"\" value=\""+eval("formObj.amend_order_type_desc"+v+".value")+"\">";
					}
					else
					{
						htmlText[arrInd++]	= "<input type=\"hidden\" name=\"order_type_desc"+count+"\" id=\"order_type_desc"+count+"\" value=''>";
					}

					htmlText[arrInd++]	= "<input type=\"hidden\" name=\"duration_value"+count+"\" id=\"duration_value"+count+"\" value=\""+eval("formObj.amend_duration_value"+v+".value")+"\">";
					htmlText[arrInd++]	= "<input type=\"hidden\" name=\"duration_code"+count+"\" id=\"duration_code"+count+"\" value=\""+eval("formObj.amend_duration_code"+v+".value")+"\">";
					duration_code		= eval("formObj.amend_duration_code"+v+".value;");
					htmlText[arrInd++]	= "<input type=\"hidden\" name=\"duration_desc"+count+"\" id=\"duration_desc"+count+"\" value=\""+duration_code+"\">";
					if(eval("formObj.amend_appt_reqd_yn"+v+".value")=="Y") 
					{
						if(pr_value=="R")  // If priority is R (Routine)
						{
							appt_reqd_yn = eval("formObj.amend_routine_appt_reqd_yn"+v+".value");
						}
						else if(pr_value=="D")  // If priority is S (Stat)
						{
							appt_reqd_yn = eval("formObj.amend_stat_appt_reqd_yn"+v+".value");
						}
						else if(pr_value=="U")  // If priority is U (Urgent)
						{
							appt_reqd_yn = eval("formObj.amend_urgent_appt_reqd_yn"+v+".value");
						}
					}
					else 
					{
						appt_reqd_yn = "N"; 
					}
  					htmlText[arrInd++]	= "<input type=\"hidden\" name=\"appt_reqd_yn"+count+"\" id=\"appt_reqd_yn"+count+"\" value=\""+appt_reqd_yn+"\">";
					htmlText[arrInd++]	= "<input type=\"hidden\" name=\"chart_result_type"+count+"\" id=\"chart_result_type"+count+"\" value=\""+eval("formObj.amend_chart_result_type"+v+".value")+"\">";
					htmlText[arrInd++]	= "<input type=\"hidden\" name=\"order_id\" id=\"order_id\" value=\""+eval("formObj.amend_order_id"+v+".value")+"\">";
					count++;
				}
			} // End of if catalog_code
		} // End of for
		/*Ends Here by Uma on 5/5/2010 for IN021062*/
		htmlText[arrInd++]		     = "<input type=\"hidden\" name=\"total_rows\" id=\"total_rows\" value=\""+count+"\">";
		htmlText[arrInd++]			 = "</form>";
		dialogHeight 	= "93vh" ;
		//dialogWidth 	= "50" ;
		dialogWidth 	= "80vw" ;
		dialogTop 		= "0px" ;
		//dialogLeft	 	= "124" ;
		dialogRight	 	= "100px" ;
		var arguments = htmlText;
		var retVal 		= "";
		var features 	= 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; dialogTop:'+dialogTop+'; dialogRight:'+dialogRight+'; scroll=no; status=no';
		// Atleast one item is checked, then display the details other wise no need
			result_val 		= checkToSubmit("criteriaPlaceOrderFrame.placeOrderDetailFrame",formObj); //Pass the formObj and the frame ref, Fn is in OrderEntry.js
			if((total_rows >0 && result_val)||amend_total_rows>0)//Modified by Uma on 5/5/2010 for IN021062
			{
				retVal 		= await window.showModalDialog("../../eOR/jsp/OrderEntryPreviewFrames.jsp?windowTitle=Order Preview",arguments,features);
			}
			else
			     alert(getMessage("CLICK_ONE_ORDERABLE","OR"))
	} // End of if total_rows
	else
	     alert(getMessage("CLICK_ONE_NEW_ORDERABLE","OR")) // Amend Orders
}
// When the Authorization is required, User has to confirm
function CheckAuthorization(auth_reqd)
{
	if (auth_reqd)
	{
	
		var yes = window.confirm(getMessage("AUTH_REQD_CONFIRM","OR"));
		if (yes)
		{
			 HideLink();   // change the html text
			var imgArr = "";
			if(parent.criteriaMainFrame)
				imgArr = parent.placeOrderDetailFrame.document.getElementsByTagName("img");
			for(var p=0;p<imgArr.length;p++)
			{
				if(imgArr[p].src.indexOf("mandatory")==-1 && imgArr[p].src.indexOf("Flex_blue")==-1 && imgArr[p].src.indexOf("Flex_red")==-1  && imgArr[p].src.indexOf("Cosign")==-1 && imgArr[p].src.indexOf("Cosign_click")==-1  && imgArr[p].src.indexOf("SpecialApproval")==-1 &&  imgArr[p].src.indexOf("SpecialApproval_click")==-1 && imgArr[p].src.indexOf("SecondaryOrder")==-1 && imgArr[p].src.indexOf("CommonCalendar")==-1)
				{
					//var rowindex = imgArr[p].id.substring(13,(imgArr[p].id.length-1));//IN048467
					var rowindex = imgArr[p].id.substring(14,(imgArr[p].id.length-1));//IN048467
					if(parent.placeOrderDetailFrame.document.getElementById("ord_auth_reqd_yn"+rowindex).value=="Y" && parent.placeOrderDetailFrame.document.getElementById("auth_yn"+rowindex).value=="Y")
					{
						imgArr[p].src = "../../eOR/images/Authorized.gif";
						parent.placeOrderDetailFrame.document.getElementById("authorised_yn"+rowindex).value="Y";
					}
					//imgArr[p].src = "../../eOR/images/Authorized.gif";
				}
			}
			document.getElementById("authorized").value = "true";
		}
	}
	else
	{
		//alert("APP-CA0208 - Required to be authorized");
		document.getElementById("authorized").value = "false";
		//ShowLink();
	}
}
function HideLink()
{
	document.getElementById("authorizedId").innerHTML=getLabel("Common.Authorized.label","Common")
	if(document.getElementById("textimg"))
		document.getElementById("textimg").src='../../eOR/images/Authorized.gif'
}
function hideAuthorization()
{
	if(parent.criteriaMainFrame.document.getElementById("hdg"))
		parent.criteriaMainFrame.document.getElementById("hdg").innerHTML				= "&nbsp";
	if(parent.criteriaMainFrame.document.getElementById("authorizedId"))
		parent.criteriaMainFrame.document.getElementById("authorizedId").innerHTML 	= "&nbsp";
	if(parent.criteriaMainFrame.document.getElementById("imageId"))
		parent.criteriaMainFrame.document.getElementById("imageId").innerHTML 		= "&nbsp";
}

// Order Format For the Header
async function orderFormatForHeader(format_id,order_category,order_id,chk_mand, function_from) // adtnl param function_from added for ML-MMOH-CRF-0508.1
{	
	//alert("562");
	if(parent.DetailFrame) 	// On Press of record, if mandatorily and not entered
	{
		formObj				= parent.DetailFrame.criteriaPlaceOrderFrame.criteriaMainFrame.document.placeOrderHeaderForm;
		detailformObj		= parent.DetailFrame.criteriaPlaceOrderFrame.placeOrderDetailFrame.document.placeOrderForm;
	//alert("formObj"+formObj	);	
	
	}
	else   // on press of the header level format hyperlink
	{
		//alert("hello");
	  	formObj				= document.placeOrderHeaderForm;
		detailformObj		= parent.placeOrderDetailFrame.document.placeOrderForm;
	}
	//alert(parent.DetailFrame.criteriaPlaceOrderFrame.criteriaMainFrame.document.forms[0].name)
	var bean_id				= formObj.bean_id.value;
	var bean_name	 		= formObj.bean_name.value;
    var priority 			= formObj.priority.value;
	var sys_date			= formObj.sys_date.value;
	var sex					= formObj.sex.value;
	var dob					= formObj.dob.value;
	var order_date_time					= formObj.order_date_time.value;
	//var order_format_onload = formObj.order_format_onload.value//IN045512
	//alert(detailformObj.innerHTML);
	// Get the performing facility_id, get the first one patiented
	var perf_facility_id	= "";
	if(eval("detailformObj.performing_facility_id0"))
		perf_facility_id	= eval("detailformObj.performing_facility_id0.value");
	else  if(eval("detailformObj.amend_performing_facility_id0")) // Amend orders
		perf_facility_id	= eval("detailformObj.amend_performing_facility_id0.value");
	 //IN072275 Starts	
	 if(eval("detailformObj.order_id0")) // Amend orders
		 order_id	= eval("detailformObj.order_id0.value");
	 else if(eval("detailformObj.amend_order_id0")) // Amend orders
		 order_id	= eval("detailformObj.amend_order_id0.value");
	 //IN072275 Ends
	 
    var row_value			= "0"; 					// since it is a header ,it is passed as a 0
    var catalog_code		= order_category;   	// since it is entry in the header,the order_category is passed as same
    
    //var finalString 		= "from_header=Y&called_from=HEADER&order_category="+order_category+"&format_id="+escape(format_id)+"&row_value="+row_value+"&catalog_code="+escape(catalog_code)+"&bean_id="+bean_id+"&bean_name="+bean_name+"&order_id="+order_id+"&priority="+priority+"&performing_facility_id="+perf_facility_id+"&sys_date="+escape(sys_date)+"&sex="+sex+"&dob="+escape(dob)+"&chk_mand="+chk_mand+"&order_date_time="+order_date_time;//Commented for IN045512 ,  ML-MMOH-CRF-0508.1
    var finalString 		= "from_header=Y&called_from=HEADER&order_category="+order_category+"&format_id="+escape(format_id)+"&row_value="+row_value+"&catalog_code="+escape(catalog_code)+"&bean_id="+bean_id+"&bean_name="+bean_name+"&order_id="+order_id+"&priority="+priority+"&performing_facility_id="+perf_facility_id+"&sys_date="+escape(sys_date)+"&sex="+sex+"&dob="+escape(dob)+"&chk_mand="+chk_mand+"&order_date_time="+order_date_time+"&function_from="+function_from;//modified for ML-MMOH-CRF-0508.1
    //var finalString 		= "from_header=Y&called_from=HEADER&order_category="+order_category+"&format_id="+escape(format_id)+"&row_value="+row_value+"&catalog_code="+escape(catalog_code)+"&bean_id="+bean_id+"&bean_name="+bean_name+"&order_id="+order_id+"&priority="+priority+"&performing_facility_id="+perf_facility_id+"&sys_date="+escape(sys_date)+"&sex="+sex+"&dob="+escape(dob)+"&chk_mand="+chk_mand+"&order_date_time="+order_date_time+"&order_format_onload="+order_format_onload;//IN045512
	var retVal;
  	var dialogHeight 		= "80vh" ;
	//var dialogWidth  		= "50" ;
	var dialogWidth  		= "65vw" ;
	var dialogTop   		= "10";
	var dialogLeft   		= "10";
	var features    		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" +dialogLeft+ "; dialogTop:" +dialogTop+ "; status=no" ;
  	var arguments;
  	var url 				= "";
  	url 					= "../../eOR/jsp/OrderEntryOrderFormatFrameSet.jsp?"+finalString;
  	retVal = await top.window.showModalDialog(url,arguments,features);	
  	
	
	if(retVal!=null)
	{	
		formObj.format_id_yn.value =  retVal;//IN045512
		//formObj.format_id_yn.value =  retVal[0];//IN045512
	}

}

//Order Format For the Lines
async function orderFormatForLines(format_name,row,catalog_code,mandatory_yn,order_category,contr_msr_panel_id, contr_msr_mod_id)
{
    var bean_id 	= document.placeOrderForm.bean_id.value;
    var bean_name 	= document.placeOrderForm.bean_name.value;

    var format_id;
  	var inputArr 	= document.getElementsByTagName("input");
  	for (u=0;u<inputArr.length;u++){
		if (inputArr[u].name == format_name){
		  	format_id = inputArr[u].value;
		}
  	}
  	var priority     = eval("document.placeOrderForm.priority"+row+".value");
	var sys_date     = eval("document.placeOrderForm.sys_date.value");
  	var finalString  = "from_header=N&order_category="+order_category+"&format_id="+escape(format_id)+"&contr_msr_mod_id="+escape(contr_msr_mod_id)+"&contr_msr_panel_id="+escape(contr_msr_panel_id)+"&row_value="+row+"&catalog_code="+escape(catalog_code)+"&bean_id="+bean_id+"&bean_name="+bean_name+"&priority="+priority+"&sys_date="+escape(sys_date);
  	var retVal;
  	var dialogHeight = "80vh" ;
	//var dialogWidth  = "50" ;
	var dialogWidth  = "65vw" ;
	var dialogTop    = "100";
	var dialogLeft   = "100";

	var features     = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" +dialogLeft+ "; dialogTop:" +dialogTop+ "; status=no" ;
  	var arguments;
  	var url 		 = "../../eOR/jsp/OrderEntryOrderFormatFrameSet.jsp?"+finalString
  	retVal 			 = await window.showModalDialog(url,arguments,features);
  	if(retVal!=null)
  	{
  		//if(retVal=="Y")
  		//{
  			if(mandatory_yn=="Y")
  			{
  				document.getElementById("order"+row).innerHTML = "<font size=1><a class='gridLink' href=javascript:orderFormatForLines('"+format_name+"','"+row+"','"+catalog_code+"','"+mandatory_yn+"','"+order_category+"','"+contr_msr_panel_id+"','"+contr_msr_mod_id+"')  title='Order Line Format'><img src='../../eOR/images/Flex_red.gif' align='center'></img></a></font>";
  			}
  			else
  			{
  			document.getElementById("order"+row).innerHTML= "<font size=1><a class='gridLink' href=javascript:orderFormatForLines('"+format_name+"','"+row+"','"+catalog_code+"','"+mandatory_yn+"','"+order_category+"','"+contr_msr_panel_id+"','"+contr_msr_mod_id+"') title='Order Line Format'><img src='../../eOR/images/Flex_blue.gif' align='center'></img></a></font>";
			}
			eval("document.placeOrderForm.format_id_yn"+row+".value =  'Y'");
			if(retVal=="N" && mandatory_yn=="Y")
				eval("document.placeOrderForm.format_id_yn"+row+".value =  'N'");
  		//}
  	}	// end of retVal
  	else
  	{
  	    if(mandatory_yn=="Y")
  			eval("document.placeOrderForm.format_id_yn"+row+".value =  'N'");
  	}
}


//Order Format For the Lines  Level...
async function orderFormatForLineLevel(chk_mand)
{
	if(chk_mand==null) chk_mand = "";
	var	formObj	 	 	 	= criteriaPlaceOrderFrame.placeOrderDetailFrame.document.placeOrderForm;
	var form				= criteriaPlaceOrderFrame.placeOrderDetailFrame.document.getElementById("placeOrderForm");
	var mandatory_yn		= criteriaPlaceOrderFrame.criteriaDetailFrame.document.buttonForm.line_level_mandatory_yn.value;
	if(formObj.bean_id)
	 var bean_id 	        = formObj.bean_id.value;
	if(formObj.bean_name)
		var bean_name 	        = formObj.bean_name.value;
	if(formObj.function_name)
		var function_name		= formObj.function_name.value;   //For new order or orderset
    var format_id_yn		= criteriaPlaceOrderFrame.criteriaDetailFrame.document.buttonForm.format_id_yn.value
    //var order_format_line_onload		= criteriaPlaceOrderFrame.criteriaDetailFrame.document.buttonForm.order_format_line_onload.value;//IN045512
	if(formObj.sys_date)
		var sys_date			= formObj.sys_date.value
	if(formObj.sex)
		var sex					= formObj.sex.value
	if(formObj.dob)
		var dob					= formObj.dob.value
	if(form.function_from) // ML-MMOH-CRF-0508.1
			var function_from	= form.function_from.value // ML-MMOH-CRF-0508.1	
    var count				= 0;
	var HTMLText			=  new Array();
   	var arrInd 	 			= 0;
   	HTMLText[arrInd++]	     = "<html><head><script>function submitFn(){ }</script></head><body><form name=\"dummyForm\" id=\"dummyForm\" >";
   	HTMLText[arrInd++]	     = "<input type=\"hidden\" name=\"from_header\" id=\"from_header\" value=\"N\">";
	HTMLText[arrInd++]	     = "<input type=\"hidden\" name=\"bean_id\" id=\"bean_id\" value=\""+bean_id+"\">";
	HTMLText[arrInd++]	     = "<input type=\"hidden\" name=\"bean_name\" id=\"bean_name\" value=\""+bean_name+"\">";
	HTMLText[arrInd++]	     = "<input type=\"hidden\" name=\"function_name\" id=\"function_name\" value=\""+function_name+"\">";
	HTMLText[arrInd++]	     = "<input type=\"hidden\" name=\"format_id_yn\" id=\"format_id_yn\" value=\""+format_id_yn+"\">";
	HTMLText[arrInd++]	     = "<input type=\"hidden\" name=\"sys_date\" id=\"sys_date\" value=\""+sys_date+"\">";
	HTMLText[arrInd++]	     = "<input type=\"hidden\" name=\"sex\" id=\"sex\" value=\""+sex+"\">";
	HTMLText[arrInd++]	     = "<input type=\"hidden\" name=\"dob\" id=\"dob\" value=\""+dob+"\">";
	HTMLText[arrInd++]	     = "<input type=\"hidden\" name=\"function_from\" id=\"function_from\" value=\""+function_from+"\">"; // ML-MMOH-CRF-0508.1 
	for(var i=0;i<formObj.length;i++)
	{
		checked_yn					=  "N";
		if(eval("formObj.amend_catalog_code"+i))
		{
			catalog_code_val = eval("formObj.amend_catalog_code"+i+".value");
			//checked_yn		 = eval("formObj.ck"+catalog_code_val+".value");
			checked_yn		 = form["ck"+catalog_code_val].value
			if(checked_yn == "Y")
			{
				HTMLText[arrInd++]	     = "<input type=\"hidden\" name=\"order_type_code"+count+"\" id=\"order_type_code"+count+"\" value=\""+eval("formObj.amend_order_type"+i+".value")+"\">";
				HTMLText[arrInd++]	     = "<input type=\"hidden\" name=\"order_category"+count+"\" id=\"order_category"+count+"\" value=\""+eval("formObj.amend_order_category"+i+".value")+"\">";
				HTMLText[arrInd++]	     = "<input type=\"hidden\" name=\"priority"+count+"\" id=\"priority"+count+"\" value=\""+eval("formObj.amend_priority"+i+".value")+"\">";
				HTMLText[arrInd++]	     = "<input type=\"hidden\" name=\"contr_msr_panel_id"+count+"\" id=\"contr_msr_panel_id"+count+"\" value=\""+eval("formObj.amend_contr_msr_panel_id"+i+".value")+"\">";
				HTMLText[arrInd++]	     = "<input type=\"hidden\" name=\"contr_msr_mod_id"+count+"\" id=\"contr_msr_mod_id"+count+"\" value=\""+eval("formObj.amend_contr_msr_mod_id"+i+".value")+"\">";
				HTMLText[arrInd++]	     = "<input type=\"hidden\" name=\"format_id"+count+"\" id=\"format_id"+count+"\" value=\""+eval("formObj.amend_format_id_val"+i+".value")+"\">";
				HTMLText[arrInd++]	     = "<input type=\"hidden\" name=\"catalog_code"+count+"\" id=\"catalog_code"+count+"\" value=\""+eval("formObj.amend_catalog_code"+i+".value")+"\">";
				HTMLText[arrInd++]	     = "<input type=\"hidden\" name=\"pat_instrn_age_sex_yn"+count+"\" id=\"pat_instrn_age_sex_yn"+count+"\" value=\""+eval("formObj.amend_pat_instrn_age_sex_yn"+i+".value")+"\">";
				HTMLText[arrInd++]	     = "<input type=\"hidden\" name=\"catalog_desc"+count+"\" id=\"catalog_desc"+count+"\" value=\""+eval("formObj.amend_cat_desc"+i+".value")+"\">";
				HTMLText[arrInd++]	     = "<input type=\"hidden\" name=\"order_id"+count+"\" id=\"order_id"+count+"\" value=\""+eval("formObj.amend_order_id"+i+".value")+"\">";
				HTMLText[arrInd++]	     = "<input type=\"hidden\" name=\"order_line_num"+count+"\" id=\"order_line_num"+count+"\" value=\""+eval("formObj.amend_order_line_num"+i+".value")+"\">";
				HTMLText[arrInd++]	     = "<input type=\"hidden\" name=\"performing_facility_id"+count+"\" id=\"performing_facility_id"+count+"\" value=\""+eval("formObj.amend_performing_facility_id"+i+".value")+"\">";
				//IN64543, starts
        /*HTMLText[arrInd++]	     = "<input type=\"hidden\" name=\"amend_line_comments"+count+"\" value=\""+eval("formObj.amend_line_comments"+i+".value")+"\">";
				HTMLText[arrInd++]	     = "<input type=\"hidden\" name=\"amend_line_preps"+count+"\" value=\""+eval("formObj.amend_line_preps"+i+".value")+"\">";
				HTMLText[arrInd++]	     = "<input type=\"hidden\" name=\"amend_line_pat_instrn"+count+"\" value=\""+eval("formObj.amend_line_pat_instrn"+i+".value")+"\">";
				HTMLText[arrInd++]	     = "<input type=\"hidden\" name=\"amend_line_dept_instrn"+count+"\" value=\""+eval("formObj.amend_line_dept_instrn"+i+".value")+"\">";*/
        //IN64543, ends
				HTMLText[arrInd++]	     = "<input type=\"hidden\" name=\"appt_time"+count+"\" id=\"appt_time"+count+"\" value=''>";
				HTMLText[arrInd++]	     = "<input type=\"hidden\" name=\"start_date_time"+count+"\" id=\"start_date_time"+count+"\" value=\""+eval("formObj.amend_start_date_time"+i+".value")+"\">";
				HTMLText[arrInd++]	     = "<input type=\"hidden\" name=\"instrn_content_type"+count+"\" id=\"instrn_content_type"+count+"\" value=\""+eval("formObj.amend_instrn_content_type"+i+".value")+"\">";//IN64543
				count++;
			} // end of checked_yn
		} // for Amend_orders
	} // End of for
	
	for(var i=0;i<formObj.length;i++)
	{
		if(eval("formObj.catalog_code"+i))
		{
			catalog_code_val = eval("formObj.catalog_code"+i+".value");
			//checked_yn	 = eval("formObj.ck"+catalog_code_val+".value")
			checked_yn		 = form["ck"+catalog_code_val].value
			if(checked_yn=="Y")
			{
				HTMLText[arrInd++]	     = "<input type=\"hidden\" name=\"order_type_code"+count+"\" id=\"order_type_code"+count+"\" value=\""+eval("formObj.order_type_code"+i+".value")+"\">";
				HTMLText[arrInd++]	     = "<input type=\"hidden\" name=\"order_category"+count+"\" id=\"order_category"+count+"\" value=\""+eval("formObj.group_order_category"+i+".value")+"\">";
				HTMLText[arrInd++]	     = "<input type=\"hidden\" name=\"priority"+count+"\" id=\"priority"+count+"\" value=\""+eval("formObj.priority"+i+".value")+"\">";
				HTMLText[arrInd++]	     = "<input type=\"hidden\" name=\"contr_msr_panel_id"+count+"\" id=\"contr_msr_panel_id"+count+"\" value=\""+eval("formObj.contr_msr_panel_id"+i+".value")+"\">";
				HTMLText[arrInd++]	     = "<input type=\"hidden\" name=\"contr_msr_mod_id"+count+"\" id=\"contr_msr_mod_id"+count+"\" value=\""+eval("formObj.contr_msr_mod_id"+i+".value")+"\">";
				HTMLText[arrInd++]	     = "<input type=\"hidden\" name=\"format_id"+count+"\" id=\"format_id"+count+"\" value=\""+eval("formObj.format_id_val"+i+".value")+"\">";
				HTMLText[arrInd++]	     = "<input type=\"hidden\" name=\"catalog_code"+count+"\" id=\"catalog_code"+count+"\" value=\""+eval("formObj.catalog_code"+i+".value")+"\">";
				HTMLText[arrInd++]	     = "<input type=\"hidden\" name=\"pat_instrn_age_sex_yn"+count+"\" id=\"pat_instrn_age_sex_yn"+count+"\" value=\""+eval("formObj.pat_instrn_age_sex_yn"+i+".value")+"\">";
				HTMLText[arrInd++]	     = "<input type=\"hidden\" name=\"catalog_desc"+count+"\" id=\"catalog_desc"+count+"\" value=\""+eval("formObj.cat_desc"+i+".value")+"\">";
				HTMLText[arrInd++]	     = "<input type=\"hidden\" name=\"performing_facility_id"+count+"\" id=\"performing_facility_id"+count+"\" value=\""+eval("formObj.performing_facility_id"+i+".value")+"\">";
				HTMLText[arrInd++]	     = "<input type=\"hidden\" name=\"order_id"+count+"\" id=\"order_id"+count+"\" value=\""+eval("formObj.order_id"+i+".value")+"\">";
				HTMLText[arrInd++]	     = "<input type=\"hidden\" name=\"order_line_num"+count+"\" id=\"order_line_num"+count+"\" value=\""+eval("formObj.order_line_num"+i+".value")+"\">";
				//IN64543, starts
        /*HTMLText[arrInd++]	     = "<input type=\"hidden\" name=\"amend_line_comments"+count+"\" value=\""+eval("formObj.line_comments"+i+".value")+"\">"; 	// Send as null for new orders
				HTMLText[arrInd++]	     = "<input type=\"hidden\" name=\"amend_line_preps"+count+"\" value=\""+eval("formObj.line_preps"+i+".value")+"\">";   	// Send as null for new orders
				HTMLText[arrInd++]	     = "<input type=\"hidden\" name=\"amend_line_pat_instrn"+count+"\" value=\""+eval("formObj.line_pat_instrn"+i+".value")+"\">";   // Send as null for new orders
				HTMLText[arrInd++]	     = "<input type=\"hidden\" name=\"amend_line_dept_instrn"+count+"\" value=\""+eval("formObj.line_dept_instrn"+i+".value")+"\">";	// Send as null for new orders
        */
        //IN64543, ends
				HTMLText[arrInd++]	     = "<input type=\"hidden\" name=\"appt_time"+count+"\" id=\"appt_time"+count+"\" value=\""+eval("formObj.appt_time"+i+".value")+"\">";
				HTMLText[arrInd++]	     = "<input type=\"hidden\" name=\"start_date_time"+count+"\" id=\"start_date_time"+count+"\" value=\""+eval("formObj.start_date_time"+i+".value")+"\">";
				HTMLText[arrInd++]	     = "<input type=\"hidden\" name=\"instrn_content_type"+count+"\" id=\"instrn_content_type"+count+"\" value=\""+eval("formObj.instrn_content_type"+i+".value")+"\">";//IN64543
				count++;
			}  // End of checked_yn='Y'
		} // end of if
	} // End of for
	HTMLText[arrInd++]		     = "<input type=\"hidden\" name=\"total_rows\" id=\"total_rows\" value=\""+count+"\">";
	HTMLText[arrInd++]		     = "<input type=\"hidden\" name=\"chk_mand\" id=\"chk_mand\" value=\""+chk_mand+"\">";
	//HTMLText[arrInd++]		     = "<input type=\"hidden\" name=\"order_format_line_onload\" value=\""+order_format_line_onload+"\">";//IN045512

	HTMLText[arrInd++]			 = "</form>";
	if(count>0)
	{
	/*	if(chk_mand=="RECORD")		// When called on press of record, make it small...
		{
			var dialogHeight   = "0" ;
			var dialogWidth    = "0" ;
			var dialogTop      = "0" ;
			var dialogLeft     = "0" ;
		}
		else
		{
	*/
			var dialogHeight   = "90vh" ;
			//var dialogWidth    = "50" ;
			var dialogWidth    = "80vw" ;
			var dialogTop      = "0vh";
			//var dialogLeft     = "100";
			var dialogRight     = "0vw";
	//	}
			var retVal;
			var retArray=new Array();
			var features       = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogRight:" +dialogRight+ "; dialogTop:" +dialogTop+ "; status=no" ;
			var arguments	   = HTMLText;
 			var url 		   = "../../eOR/jsp/OrderEntryOrderFormatLineFrameSet.jsp";
			
  			retVal 			   = await top.window.showModalDialog(url,arguments,features);
		
			if(retVal!=undefined)
			{
				if(retVal.indexOf("$$")!=-1)
				{
					retArray=retVal.split("$$")
						
					if(retArray[1]>0)
					{	
						//commented for email changes needed to be reverted by Uma on 2/6/2009	
						var patient_email_yn=formObj.patient_email_id.value;
						
						if(patient_email_yn!=undefined && patient_email_yn!="undefined"&&patient_email_yn!="")
						{
							patient_email_yn="Y";
						}
						if(patient_email_yn=="Y")
						{
						
							criteriaPlaceOrderFrame.criteriaDetailFrame.document.getElementById("EmailPreview").style.display="inline";
						//criteriaPlaceOrderFrame.criteriaDetailFrame.document.getElementById("EmailPreview").style.display="none";
							formObj.email_yn.value="Y";
						}
						else
						{
							criteriaPlaceOrderFrame.criteriaDetailFrame.document.getElementById("EmailPreview").style.display="none";
							formObj.email_yn.value="N";
						}
					}
					else
					{
						criteriaPlaceOrderFrame.criteriaDetailFrame.document.getElementById("EmailPreview").style.display="none";
						formObj.email_yn.value="N";
					}
				}
				else
				{
					criteriaPlaceOrderFrame.criteriaDetailFrame.document.getElementById("EmailPreview").style.display="none";
					formObj.email_yn.value="N";
				}
				//IN045512 Starts
				if(retVal.indexOf("~")!=-1)
				{
					retArray=retVal.split("~")
					if(null!=retArray[1])
						criteriaPlaceOrderFrame.criteriaDetailFrame.document.buttonForm.order_format_line_onload.value  = retArray[1] ;
				}
				//IN045512 Ends
			}
  	}
	else
	{
		alert(getMessage("CLICK_ONE_ORDERABLE","OR"))
	}
  	if(retVal!=null)
  	{
  	  	if(mandatory_yn=="Y")
 		{
			criteriaPlaceOrderFrame.criteriaDetailFrame.document.getElementById("order_mandatory").innerHTML ="<font size=1><a class='gridLink' href='javascript:parent.parent.orderFormatForLineLevel()' title='Order Line Format'><img src='../../eOR/images/Flex_red.gif' align='center'></img></a></font>&nbsp;Addl. Info. (Mandatory)&nbsp;&nbsp;";
		}
  		else
  		criteriaPlaceOrderFrame.criteriaDetailFrame.document.getElementById("order_mandatory").innerHTML ="<font size=1><a class='gridLink' href='javascript:parent.parent.orderFormatForLineLevel()' title='Order Line Format'><img src='../../eOR/images/Flex_blue.gif' align='center'></img></a></font>&nbsp;Addl. Info.(Optional)&nbsp;&nbsp;" ;
  			//eval("document.getElementById("order")"+row+".innerHTML= \"<font size=1><a href=javascript:orderFormatForLines('"+format_name+"','"+row+"','"+catalog_code+"','"+mandatory_yn+"','"+order_category+"','"+contr_msr_panel_id+"','"+contr_msr_mod_id+"') title='Order Line Format'><img src='../../eOR/images/Flex_blue.gif' align='center'></img></a></font>\"");
		criteriaPlaceOrderFrame.criteriaDetailFrame.document.buttonForm.format_id_yn.value  =  'Y';
		if(retVal=="N" && mandatory_yn=="Y")
			criteriaPlaceOrderFrame.criteriaDetailFrame.document.buttonForm.format_id_yn.value  =  'N';

 	}
  	else
  	{
  	    if(mandatory_yn=="Y")
  			criteriaPlaceOrderFrame.criteriaDetailFrame.document.buttonForm.format_id_yn.value =  'N';
  	}
} // End of orderFormatForLineLevel

// Only when the user presses the Record Button In the Order Entry and the order format are mandatory and not entered, only then
// the below function will fire.
function ClickClose()
{
	
	parent.flex_fields_button.document.OrderEntryFormatButtons.ok.click();
}


// Called for the Amend Order in the Lines(Dtls),
async function orderFormatAmendForLines(format_name,row,catalog_code,order_category,order_id,order_line_num,contr_msr_panel_id,contr_msr_mod_id)
{
	var bean_id 	= document.placeOrderForm.bean_id.value;
    var bean_name 	= document.placeOrderForm.bean_name.value;
	var sys_date	= document.placeOrderForm.sys_date.value;
    var format_id;
  	var inputArr 	= document.getElementsByTagName("input");
  	for (u=0;u<inputArr.length;u++){
  			if (inputArr[u].name == format_name){
  			  	format_id = inputArr[u].value;
  			}
  	}
  	var retVal;
  	var dialogHeight = "80vh" ;
	//var dialogWidth  = "50" ;
	var dialogWidth  = "65vw" ;
	var dialogTop    = "100";
	var dialogLeft   = "100";
	var features     = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" +dialogLeft+ "; dialogTop:" +dialogTop+ "; status=no" ;
  	var arguments;
	var url 		 = "../../eOR/jsp/OrderEntryOrderFormatFrameSet.jsp?called_from=Amend_Dtl&order_category="+order_category+"&format_id="+escape(format_id)+"&row_value="+row+"&contr_msr_mod_id="+escape(contr_msr_mod_id)+"&contr_msr_panel_id="+escape(contr_msr_panel_id)+"&catalog_code="+escape(catalog_code)+"&order_id="+order_id+"&order_line_num="+order_line_num+"&bean_id="+bean_id+"&bean_name="+bean_name+"&sys_date="+escape(sys_date)
	retVal =await  window.showModalDialog(url,arguments,features);
} // End of orderFormatAmendDtl

// Order Format For the Header in the Care Sets
async function orderFormatForCareSetsHeader(format_id,order_category,care_set_catalog_code,count,order_id,chk_mand)
{
	
	var order_date_time = "";
	if(parent.DetailFrame)	// On Press of record, if mandatorily and not entered
	{
	 	formObj			= parent.DetailFrame.criteriaPlaceOrderFrame.placeOrderDetailFrame.document.placeOrderForm;
	}
	else if(parent.criteriaPlaceOrderFrame)
	{
		formObj			= parent.criteriaPlaceOrderFrame.placeOrderDetailFrame.document.placeOrderForm;
	}
	else   // on press of the header level format hyperlink
	{
	  	formObj			= document.placeOrderForm;
	}
   	var bean_id 		= formObj.bean_id.value;
	var bean_name 		= formObj.bean_name.value;
	var sys_date		= formObj.sys_date.value;
	var sex				= formObj.sex.value;
	var dob				= formObj.dob.value;
	if(parent.criteriaMainFrame)
	{
		order_date_time				= parent.criteriaMainFrame.document.getElementById("order_date_time").value;
	}
	else if (parent.criteriaPlaceOrderFrame)
	{
		order_date_time				= parent.criteriaPlaceOrderFrame.criteriaMainFrame.document.getElementById("order_date_time").value;
	}
	else if(parent.DetailFrame)
	{
		order_date_time				= parent.DetailFrame.criteriaPlaceOrderFrame.criteriaMainFrame.document.getElementById("order_date_time").value;
	}
	var perf_facility_id= eval("formObj.performing_facility_id0.value"); // Get the first performing facility id
    var row_value		= "0"; 					// since it is a header ,it is passed as a 0
    var catalog_code	= order_category;   	// since it is entry in the header,the order_category is passed as same
    var retVal;
  	var dialogHeight 	= "80vh" ;
	//var dialogWidth  	= "50" ;
	var dialogWidth  	= "66vw" ;
	var dialogTop   	= "100";
	var dialogLeft   	= "100";
	var features    	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" +dialogLeft+ "; dialogTop:" +dialogTop+ "; status=no" ;
  	var arguments;
  	var url 			= "";
  	url 				= "../../eOR/jsp/OrderEntryOrderFormatFrameSet.jsp?from_header=Y&called_from=ORDER_SET_HEADER&order_category="+order_category+"&format_id="+escape(format_id)+"&row_value="+row_value+"&catalog_code="+escape(catalog_code)+"&care_set_catalog_code="+escape(care_set_catalog_code)+"&bean_id="+bean_id+"&bean_name="+bean_name+"&order_id="+order_id+"&performing_facility_id="+perf_facility_id+"&sys_date="+escape(sys_date)+"&sex="+escape(sex)+"&dob="+escape(dob)+"&chk_mand="+chk_mand+"&order_date_time="+order_date_time;
  	retVal = await window.showModalDialog(url,arguments,features);
  	if(retVal!=null)
  		eval("formObj.format_id_yn"+count+".value =  retVal");
}
// Till here For Care Sets

/*function setOrderFormatLine(count,val)
{
	eval("document.placeOrderForm.format_id_yn"+count+".value=val;");
}
*/

function setOrderFormat(val)
{
	document.placeOrderHeaderForm.format_id_yn.value=val;
}

//IN060565 Start
/*function setCheckBoxValue(obj,field_mnemonic,contr_msr_panel_id,contr_msr_mod_id,performing_facility_id,code,order_category) // To set the value for the check boxes
{
   if(obj.checked == true)
      obj.value = "Y";
   else
   	  obj.value = "N";
*/

function setCheckBoxValue(obj,field_mnemonic,contr_msr_panel_id,contr_msr_mod_id,performing_facility_id,code,order_category,mandtory_chk) 
{	
   if(obj.checked == true)
      obj.value = "Y";
   else if (mandtory_chk.indexOf(obj.name)!= -1)
   {
	   obj.value = "";
   }
   else
   	  obj.value = "N";
//IN060565 End
 	if(order_category=="RD" && field_mnemonic=="MOBILE_REQUIRED_YN") //Call a dynamic jsp to populate the Study Location List Box in the Line Level
	{
	  populateStudyLocation(obj.value,obj.name,contr_msr_panel_id, contr_msr_mod_id, performing_facility_id,code,order_category);
	}
	if(order_category=="LB" && field_mnemonic=="TRANSPLANT_PAT_YN") 
	{
		form_obj					= parent.OrderFormat.document.OrderFormatForm;
		var transplant_fields 		= form_obj.transplant_fields.value;
		if (obj.checked)
		{
			if(transplant_fields.length>0)
			{
				var arr_transplant_fields	=	transplant_fields.split("#");			
				for(var i=0; i<arr_transplant_fields.length; i++)
				{
					eval(document.getElementById(arr_transplant_fields[i])).value="";
					if(eval(document.getElementById(arr_transplant_fields[i]+"_desc")))
						eval(document.getElementById(arr_transplant_fields[i]+"_desc")).value="";
					if(eval(document.getElementById("New_"+arr_transplant_fields[i]+"_0")).style)
						eval(document.getElementById("New_"+arr_transplant_fields[i]+"_0")).style.display="inline";
					if(eval(document.getElementById("New_"+arr_transplant_fields[i]+"_1")).style)
						eval(document.getElementById("New_"+arr_transplant_fields[i]+"_1")).style.display="inline";
					
				}
			}
		}
 		else
		{
			if(transplant_fields.length>0)
			{
				var arr_transplant_fields	=	transplant_fields.split("#");			
				for(var i=0; i<arr_transplant_fields.length; i++)
				{
					document.getElementById(arr_transplant_fields[i]).value = "";
						if (document.getElementById(arr_transplant_fields[i] + "_desc")) 
								document.getElementById(arr_transplant_fields[i] + "_desc").value = "";
					if(document.getElementById("New_")+arr_transplant_fields[i]+_0.style)
						document.getElementById("New_"+arr_transplant_fields[i]+_0).style.display= "none";
					if(document.getElementById("New_"+arr_transplant_fields[i]+_1).style)
						document.getElementById("New_"+arr_transplant_fields[i]+_1).style.display="none";					
				}
			}
		}
	}
}// End of setCheckBoxValue

function setMultiCheckBoxValue(obj){
	if(obj.checked == true)
      obj.value = eval("document.OrderFormatForm.check_"+obj.name+".value");
	else 
	  obj.value = "";
} // End of setMultiCheckBoxValue
//ML-MOH-CRF-0508.1 [IN062319] - Start
function setMultiCheckBoxValMandate(obj, order_catalog_code, field_mnemonic, bean_id, bean_name){
	if(obj.checked == true){
	    obj.value = eval("document.OrderFormatForm.check_"+obj.name+".value");
	    addRemoveListCompMandatory(obj.name, order_catalog_code, field_mnemonic, bean_id, bean_name, 'Y')
	}else { 
		obj.value = "";
		addRemoveListCompMandatory(obj.name, order_catalog_code, field_mnemonic, bean_id, bean_name, 'N')
	}	  
}
function setMultiCheckBoxMandHeader(obj, order_type_code, field_mnemonic, bean_id, bean_name){
	if(obj.checked == true){
	    addRemoveListCompMandatory(obj.name, order_type_code, field_mnemonic, bean_id, bean_name, 'Y')
	}else { 
		//obj.value = "";
		addRemoveListCompMandatory(obj.name, order_type_code, field_mnemonic, bean_id, bean_name, 'N')
	}	
}
function addRemoveListCompMandatory(field_mnemonic_comp, order_catalog_code, field_mnemonic, bean_id, bean_name, obj) {
	if(obj == 'Y'){
		func_mode = 'ADD_LISTFLD_MNEMONIC';
	} else {
		func_mode = 'REMOVE_LISTFLD_MNEMONIC';
	}
var xmlDoc = "";
	var xmlHttp = new XMLHttpRequest();
	xmlStr			= "<root><SEARCH " ;
	xmlStr 			+= "field_mnemonic_comp=\""+field_mnemonic_comp+"\" " ;
	xmlStr 			+= "order_catalog_code=\""+order_catalog_code+"\" " ;
	xmlStr 			+= "field_mnemonic=\""+field_mnemonic+"\" " ;
	xmlStr 			+=" /></root>" ;
	
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "OrderEntryValidate.jsp?bean_id=" + bean_id + "&bean_name="+ bean_name +"&func_mode="+ func_mode, false ) ;
	xmlHttp.send( xmlDoc ) ;
	responseText	= xmlHttp.responseText ;
	eval( responseText ) ;
}
//ML-MOH-CRF-0508.1 [IN062319] - End
function setRadioValue(obj, name){
  	if(obj.checked == true)
	{
		eval("document.OrderFormatForm."+name+".value = obj.value");  
	} 	
} // End of setRadioValue

async function show_practitioner_window(index){

	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;

	//alert(document.getElementById("prac_sql").value)
	argumentArray[0]   = document.getElementById(index + "_prac_sql").value;
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "1,2";
	//argumentArray[5]   = target.value ;
	argumentArray[5]   = "" ;
	argumentArray[6]   = CODE_LINK ;
	argumentArray[7]   = CODE_DESC ;

	retVal = await ORCommonLookup( getLabel("Common.practitioner.label","Common"), argumentArray );
	var str =unescape(retVal);
	var arr = str.split(",");
 
	if(retVal != null && retVal != ""){
		document.getElementById(index + "_desc").value = arr[1];
       document.getElementById(index + "_desc").focus();
       document.getElementById(index).value = arr[0];
	}
}

async function show_team_window(index){

	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;

	//alert(document.getElementById("prac_sql").value)

	argumentArray[0]   = document.getElementById(index + "_prac_sql").value;
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "1,2";
	//argumentArray[5]   = target.value ;
	argumentArray[5]   = "" ;
	argumentArray[6]   = CODE_LINK ;
	argumentArray[7]   = CODE_DESC ;

	retVal =await ORCommonLookup( "Team", argumentArray );
	
	var str =unescape(retVal);
	var arr = str.split(",");
 

	if(retVal != null && retVal != ""){
		document.getElementById(index + "_desc").value = arr[1];
       document.getElementById(index + "_desc").focus();
       document.getElementById(index).value = arr[0];
	}
}

/*function callPractitionerList(){
			var dialogHeight= "29" ;//"29"
			var dialogWidth	= "42" ;//"42"
			var dialogTop	= "70";
			var dialogLeft	= "40";//"85"
			var arguments	= "" ;
			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; dialogTop:"+dialogTop+" ;dialogLeft="+dialogLeft+";scroll=no; status:no ";


	window.showModalDialog("../../eCA/jsp/AMPractitionerList.jsp?<%=request.getQueryString()%>",arguments,features);
		  }*/

// If no record or tab found in Copy Order, then put it into the existing orders
// For External Order Function, it has to be put in External Order
// For Multi Patient Order Function, it has to be put in Multi Patient Orders
// If no record or tab found, then put it into the existing orders
function refreshTab(function_from, query_string) 
{
	
	var dialogFrame = "";
	if(top.window.document.getElementById('dialog-body'))
		dialogFrame = top.window.document.getElementById('dialog-body').contentWindow;
	else
		dialogFrame = top.content;
	
	if(dialogFrame && dialogFrame.workAreaFrame)
	{
		if(dialogFrame.workAreaFrame)
		{
			if(function_from=="COPY_ORDER")
				dialogFrame.workAreaFrame.location.href="../../eOR/jsp/EnterOrder.jsp?"+query_string;
			else if(function_from=="EXTERNAL_ORDER")
				dialogFrame.workAreaFrame.location.href="../../eOR/jsp/ExternalOrdersFrameset.jsp?"+query_string;
			else if(function_from=="MULTI_PATIENT_ORDERS")
			{
				dialogFrame.workAreaFrame.location.href="../../eOR/jsp/MultiPatientOrders.jsp?"+query_string;
			}
			else // If no record or tab found, then put it into the existing orders
				dialogFrame.workAreaFrame.location.reload();
		}
	}else{
		
window.close();

    
  
} //IN036535
}
// On load, the frames to be reloaded
async function loadButtons()
{
	if(criteriaCategoryButtonFrame.document.getElementById("tab"))
	{
		var order_category 	= "";
		var frmObj			= criteriaCategoryButtonFrame.document.categoryForm;		
		//var temp_pass		=frmObj.tempPass.value;		//[IN030563] //[IN030566]
		//if(temp_pass==null) temp_pass="";				//[IN030563] //[IN030566]
		bean_id 	 		= frmObj.bean_id.value;
		bean_name 	 		= frmObj.bean_name.value;
		patient_id 	 		= frmObj.patient_id.value;
		encounter_id		= frmObj.encounter_id.value;
		ammend_called_from 	= frmObj.ammend_called_from.value;
		function_from 		= frmObj.function_from.value;
		//IN030279 Start.
		deceased_yn			= frmObj.deceased_yn.value;
		medico_legal_yn		= frmObj.medico_legal_yn.value;
		postmortem_status	= frmObj.postmortem_status.value;
		body_part_yn		= frmObj.body_part_yn.value;
		registration_no		= frmObj.registration_no.value;		
		//IN030279 End.
		
		lb_instal_yn		= frmObj.lb_instal_yn.value;
		session_id 			= frmObj.session_id.value;
		cellref 			= criteriaCategoryButtonFrame.document.getElementById("tab").rows[0].cells
		location_type		= frmObj.location_type.value;
		location_code		= frmObj.location_code.value;
		patient_class		= frmObj.patient_class.value;
		iv_prep_yn 	 		= frmObj.iv_prep_yn.value;
		order_id 	 		= frmObj.order_id.value;
		p_order_catalog_code= frmObj.p_order_catalog_code.value;
		p_start_date_time	= frmObj.p_start_date_time.value;
		p_task_code 	 	= frmObj.p_task_code.value;
		p_task_srl_no 		= frmObj.p_task_srl_no.value;
		function_id 		= frmObj.function_id.value;
		episode_id 		= frmObj.episode_id.value;
		pract_reln_id 		= frmObj.pract_reln_id.value;
		p_called_from_ca 		= frmObj.p_called_from_ca.value;
		Sex 		= frmObj.Sex.value;
		Age 		= frmObj.Age.value;
		Dob 		= frmObj.Dob.value;
		visit_adm_date 		= frmObj.visit_adm_date.value;
		licence_key 		= frmObj.licence_key.value;
		called_from 		= frmObj.called_from.value;
		pract_id 		= frmObj.pract_id.value;
		pract_name 		= frmObj.pract_name.value;
		order_mode 		= frmObj.order_mode.value;
		bt_module_install 		= frmObj.bt_module_install.value;
		time_frame 		= frmObj.time_frame.value;
 
		//alert(cellref.length);
		for(i=0; i<cellref.length; i++)
		{
			//alert(cellref[i].id);
			if(cellref[i].id=="Laboratory")
			{
			  	order_category = "LB";
			  	cellref[i].className="CASECONDSELECTHORZ";
			  	break;
			}
			else if(cellref[i].id=="Radiology")
			{
			  	order_category = "RD";
			  	cellref[i].className="CASECONDSELECTHORZ";
			  	break;
			}
			else if(cellref[i].id=="RadiologyDept")
			{
			  	order_category = "RX";
			  	cellref[i].className="CASECONDSELECTHORZ";
			  	break;
			}
			else if(cellref[i].id=="Treatment")
			{
			  	order_category = "TR";
			  	cellref[i].className="CASECONDSELECTHORZ";
			  	break;
			}
			else if(cellref[i].id=="Nursing")
			{
			  	order_category = "NC";
			  	cellref[i].className="CASECONDSELECTHORZ";
			  	break;
			}
			else if(cellref[i].id=="PatientCare")
			{
			  	order_category = "PC";
			  	cellref[i].className="CASECONDSELECTHORZ";
			  	break;
			}
			else if(cellref[i].id=="Pharmacy")
			{
			  	order_category = "PH";
			  	cellref[i].className="CASECONDSELECTHORZ";
			  	break;
			}
			else if(cellref[i].id=="Miscellaneous")
			{
			  	order_category = "MI";
			  	cellref[i].className="CASECONDSELECTHORZ";
			  	break;
			}
			else if(cellref[i].id=="OrderSets")
			{
			  	order_category = "CS";
			  	cellref[i].className="CASECONDSELECTHORZ";
			  	break;
			}
			else if(cellref[i].id=="Surgical")
			{
			  	order_category = "OT";
			  	cellref[i].className="CASECONDSELECTHORZ";
			  	break;
			}
			else if(cellref[i].id=="DietaryService")
			{
			  	order_category		= "DS";
			  	cellref[i].className="CASECONDSELECTHORZ";
			  	break;
			}
			else if(cellref[i].id=="Consults")
			{
			  	order_category		= "CN";
			  	cellref[i].className="CASECONDSELECTHORZ";
			  	break;
			}
			else if(cellref[i].id=="OralHealth")
			{
			  	order_category		= "OH";
			  	cellref[i].className="CASECONDSELECTHORZ";
			  	break;
			}
			
		} // End of the for Loop
		// Set the Module Id in the first frame --Useful when clicking the Active Problems
		//parent.parent.parent.orderMainFrame.OrCommonForm.module_id.value  = order_category;
		parent.parent.parent.orderMainTab.OrCommonForm.module_id.value  = order_category;
		bed_num  =	parent.parent.parent.orderMainTab.OrCommonForm.bed_num.value;
		room_num  =	parent.parent.parent.orderMainTab.OrCommonForm.room_num.value;
		var query_string 	= "";
 		if(order_category=="PH")
			query_string	= "order_category=PH&patient_id="+patient_id+"&encounter_id="+encounter_id+"&location_type="+location_type+"&location_code="+location_code+"&patient_class="+patient_class+"&bean_id="+bean_id+"&bean_name="+bean_name+"&order_id="+order_id+"&iv_prep_yn="+iv_prep_yn+"&func_mode=LOAD_PH_TAB"+"&ammend_called_from="+ammend_called_from+"&p_order_catalog_code="+p_order_catalog_code+"&p_start_date_time="+p_start_date_time+"&p_task_code="+p_task_code+"&p_task_srl_no="+p_task_srl_no+"&function_from="+function_from+"&bed_num="+bed_num+"&room_num="+room_num+"&function_id="+function_id+"&episode_id="+episode_id+"&pract_reln_id="+pract_reln_id+"&p_called_from_ca="+p_called_from_ca+"&Sex="+Sex+"&Age="+Age+"&Dob="+Dob+"&visit_adm_date="+visit_adm_date+"&licence_key="+licence_key+"&called_from="+called_from+"&pract_id="+pract_id+"&pract_name="+pract_name+"&order_mode="+order_mode+"&bt_module_install="+bt_module_install;
		//else if(order_category=="CN")//IN031116
			//query_string	= "order_category=CN&patient_id="+patient_id+"&encounter_id="+encounter_id+"&location_type="+location_type+"&location_code="+location_code+"&patient_class="+patient_class+"&bean_id="+bean_id+"&bean_name="+bean_name+"&order_id="+order_id+"&iv_prep_yn="+iv_prep_yn+"&func_mode=LOAD_PH_TAB"+"&ammend_called_from="+ammend_called_from+"&p_order_catalog_code="+p_order_catalog_code+"&p_start_date_time="+p_start_date_time+"&p_task_code="+p_task_code+"&p_task_srl_no="+p_task_srl_no+"&function_from="+function_from+"&bed_num="+bed_num+"&room_num="+room_num+"&function_id="+function_id+"&episode_id="+episode_id+"&pract_reln_id="+pract_reln_id+"&p_called_from_ca="+p_called_from_ca+"&Sex="+Sex+"&Age="+Age+"&Dob="+Dob+"&visit_adm_date="+visit_adm_date+"&licence_key="+licence_key+"&called_from="+called_from+"&pract_id="+pract_id+"&pract_name="+pract_name+"&order_mode="+order_mode+"&bt_module_install="+bt_module_install;//IN031116
		else{
			query_string	= "order_category="+order_category+"&bean_id="+bean_id+"&bean_name="+bean_name+"&ammend_called_from="+ammend_called_from+"&lb_instal_yn="+lb_instal_yn+"&session_id="+session_id+"&func_mode=LOAD_TABS&location_type="+location_type+"&location_code="+location_code+"&patient_class="+patient_class+"&p_order_catalog_code="+p_order_catalog_code+"&p_start_date_time="+p_start_date_time+"&p_task_code="+p_task_code+"&p_task_srl_no="+p_task_srl_no+"&function_from="+function_from+"&time_frame="+time_frame+"&called_from="+called_from+"&practitioner_id="+pract_id+"&practitioner_name="+pract_name;
			//IN030279 Start.
			query_string	= query_string	+ "&deceased_yn="+deceased_yn+"&medico_legal_yn="+medico_legal_yn+"&postmortem_status="+postmortem_status+"&body_part_yn="+body_part_yn+"&registration_no="+registration_no;
			//IN030279 End.
		}
			//IN029143 starts
			
		if(function_from != "AMEND_ORDER")
		{
				
			var xmlDoc = "";
			var xmlHttp = new XMLHttpRequest();
			xmlStr			= "<root><SEARCH " ;
			xmlStr 			+=" /></root>" ;
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			//xmlHttp.open( "POST", "ORSecurePINValidate.jsp?order_category="+order_category+"&bean_id="+bean_id+"&bean_name="+bean_name+"&func_mode=SecurePIN", false ) ;
			xmlHttp.open( "POST", "ORPlaceOrderSecurePINValidation.jsp?order_category="+order_category+"&bean_id="+bean_id+"&bean_name="+bean_name+"&func_mode=SecurePIN", false ) ;
			xmlHttp.send( xmlDoc ) ;
			if(trimString(xmlHttp.responseText)=="AL")
			{
				var retVal=new Array();
				var dialogHeight= "10" ;
				var dialogWidth	= "22" ;
				var dialogTop = "225" ;
				var center = "1" ;														   
				var status="no";
				var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
				var arguments	= "" ;	
				var called_frm="NewOrders";
				//[IN030566] Start
					var xmlDoc = "";
					var xmlHttp = new XMLHttpRequest();
					xmlStr			= "<root><SEARCH " ;
					xmlStr 			+=" /></root>" ;
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open( "POST", "ORPlaceOrderSecurePINTEMPPASSValidation.jsp?mode=Get&keyObj="+patient_id+"_AL_"+order_category+"&patient_id="+patient_id, false ) ;
					xmlHttp.send( xmlDoc ) ;
					if(trimString(xmlHttp.responseText)!="false")
					{
						retVal="true";
					}else{						
						retVal = await window.showModalDialog("../../eOR/jsp/ORPlaceOrderSecurePIN.jsp?mode=s&called_frm="+called_frm+"&order_category="+order_category+"&bean_id="+bean_id+"&bean_name="+bean_name+"&keyObj="+patient_id+"_AL_"+order_category+"&patient_id="+patient_id+"",arguments,features);
					}
					//retVal = window.showModalDialog("../../eOR/jsp/ORPlaceOrderSecurePIN.jsp?mode=s&called_frm="+called_frm+"&order_category="+order_category+"&bean_id="+bean_id+"&bean_name="+bean_name+"",arguments,features);
				
				//[IN030566] Ends				
				if(retVal == "true")
				{
					// To Synchronize and to avoid Script Error.
				var xmlDoc = "";
					var xmlHttp = new XMLHttpRequest();
					xmlStr			= "<root><SEARCH " ;
					xmlStr 			+=" /></root>" ;
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open( "POST", "OrderEntryValidate.jsp?"+query_string, false ) ;
					xmlHttp.send( xmlDoc ) ;
					responseText=xmlHttp.responseText ;
					eval( responseText ) ;
				}
			}
			else if(trimString(xmlHttp.responseText)=="ML")
			{
				var retVal=new Array();
				var dialogHeight= "10" ;
				var dialogWidth	= "22" ;
				var dialogTop = "225" ;
				var center = "1" ;														   
				var status="no";
				var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
				var arguments	= "" ;	
				var called_frm="NewOrders";
			/*[IN030566] starts
				//[IN030563] Start
				//retVal = window.showModalDialog("../../eOR/jsp/ORPlaceOrderSecurePIN.jsp?mode=s&called_frm="+called_frm+"&order_category="+order_category+"&bean_id="+bean_id+"&bean_name="+bean_name+"",arguments,features);
				if(temp_pass==""){
					retVal = window.showModalDialog("../../eOR/jsp/ORPlaceOrderSecurePIN.jsp?mode=s&called_frm="+called_frm+"&order_category="+order_category+"&bean_id="+bean_id+"&bean_name="+bean_name+"",arguments,features);
				}else
				retVal="true";
				//retVal = window.showModalDialog("../../eOR/jsp/ORPlaceOrderSecurePIN.jsp?mode=s&called_frm="+called_frm+"&order_category="+order_category+"&bean_id="+bean_id+"&bean_name="+bean_name+"",arguments,features);
				
				//[IN030563] end
			*/
			var xmlDoc = "";
			var xmlHttp = new XMLHttpRequest();
				xmlStr			= "<root><SEARCH " ;
				xmlStr 			+=" /></root>" ;
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open( "POST", "ORPlaceOrderSecurePINTEMPPASSValidation.jsp?mode=Get&keyObj="+patient_id+"_ML"+"&patient_id="+patient_id, false ) ;
				xmlHttp.send( xmlDoc ) ;
				if(trimString(xmlHttp.responseText)!="false")
				{
					retVal="true";
				}else{
					retVal = await window.showModalDialog("../../eOR/jsp/ORPlaceOrderSecurePIN.jsp?mode=s&called_frm="+called_frm+"&order_category="+order_category+"&bean_id="+bean_id+"&bean_name="+bean_name+"&keyObj="+patient_id+"_ML"+"&patient_id="+patient_id+"",arguments,features);
				}
		//[IN030566] End
				if(retVal == "true")
				{
					// To Synchronize and to avoid Script Error.
				var xmlDoc = "";
					var xmlHttp = new XMLHttpRequest();
					xmlStr			= "<root><SEARCH " ;
					xmlStr 			+=" /></root>" ;
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open( "POST", "OrderEntryValidate.jsp?"+query_string, false ) ;
					xmlHttp.send( xmlDoc ) ;
					responseText=xmlHttp.responseText ;
					eval( responseText ) ;
				}
			}
			else if(trimString(xmlHttp.responseText)=="AO")
			{
				var retVal=new Array();
				var dialogHeight= "10" ;
				var dialogWidth	= "22" ;
				var dialogTop = "225" ;
				var center = "1" ;														   
				var status="no";
				var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
				var arguments	= "" ;	
				var called_frm="NewOrders";
			//[IN030566] Start
				if(pract_id=="" && pract_name==""){
					var xmlDoc = "";
					var xmlHttp = new XMLHttpRequest();
					xmlStr			= "<root><SEARCH " ;
					xmlStr 			+=" /></root>" ;
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open( "POST", "ORPlaceOrderSecurePINTEMPPASSValidation.jsp?mode=getLoginPraName&bean_id="+bean_id+"&bean_name="+bean_name, false ) ;
					xmlHttp.send( xmlDoc ) ;
					if(trimString(xmlHttp.responseText)!="false")
					{
					 var resp = trimString(xmlHttp.responseText);							 
						var str=resp.split("^") ;
						pract_id=str[0];
						pract_name=str[1];
					}
				}
			var xmlDoc = "";
				var xmlHttp = new XMLHttpRequest();
				xmlStr			= "<root><SEARCH " ;
				xmlStr 			+=" /></root>" ;
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open( "POST", "ORPlaceOrderSecurePINTEMPPASSValidation.jsp?mode=Get&keyObj="+patient_id+"_"+pract_id+"_AO_"+order_category+"&patient_id="+patient_id, false ) ;
				xmlHttp.send( xmlDoc ) ;
				if(trimString(xmlHttp.responseText)!="false")
				{
					retVal="true";
				}else{
					
					retVal = await window.showModalDialog("../../eOR/jsp/ORPlaceOrderSecureUserPIN.jsp?mode=s&called_frm="+called_frm+"&order_category="+order_category+"&bean_id="+bean_id+"&bean_name="+bean_name+"&keyObj="+patient_id+"_"+pract_id+"_AO_"+order_category+"&patient_id="+patient_id+"&pract_name="+pract_name+"&pract_id="+pract_id+""+"",arguments,features);
				}
				//retVal = window.showModalDialog("../../eOR/jsp/ORPlaceOrderSecureUserPIN.jsp?mode=s&called_frm="+called_frm+"&order_category="+order_category+"&bean_id="+bean_id+"&bean_name="+bean_name+"&pract_name="+pract_name+"&pract_id="+pract_id+"",arguments,features);
			//[IN030566] End
				if(retVal == "true")
				{
					// To Synchronize and to avoid Script Error.
					var xmlDoc = "";
					var xmlHttp = new XMLHttpRequest();
					xmlStr			= "<root><SEARCH " ;
					xmlStr 			+=" /></root>" ;
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open( "POST", "OrderEntryValidate.jsp?"+query_string, false ) ;
					xmlHttp.send( xmlDoc ) ;
					responseText=xmlHttp.responseText ;
					eval( responseText ) ;
				}
			}
			else if(trimString(xmlHttp.responseText)=="MO")
			{
				var retVal=new Array();
				var dialogHeight= "10" ;
				var dialogWidth	= "22" ;
				var dialogTop = "225" ;
				var center = "1" ;														   
				var status="no";
				var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
				var arguments	= "" ;	
				var called_frm="NewOrders";
				
				//retVal = window.showModalDialog("../../eOR/jsp/ORPlaceOrderSecurePIN.jsp?mode=s&called_frm="+called_frm+"&order_category="+order_category+"&bean_id="+bean_id+"&bean_name="+bean_name+"",arguments,features);
			/*[IN030566] Start	
				//[IN030563] Start				
				//retVal = window.showModalDialog("../../eOR/jsp/ORPlaceOrderSecureUserPIN.jsp?mode=s&called_frm="+called_frm+"&order_category="+order_category+"&bean_id="+bean_id+"&bean_name="+bean_name+"&pract_name="+pract_name+"&pract_id="+pract_id+"",arguments,features);
				if(temp_pass==""){
					retVal = window.showModalDialog("../../eOR/jsp/ORPlaceOrderSecureUserPIN.jsp?mode=s&called_frm="+called_frm+"&order_category="+order_category+"&bean_id="+bean_id+"&bean_name="+bean_name+"&pract_name="+pract_name+"&pract_id="+pract_id+"",arguments,features);
				}else
				retVal="true";
				//[IN030563] end
			*/	
				if(pract_id=="" && pract_name==""){
					var xmlDoc = "";
			var xmlHttp = new XMLHttpRequest();
					xmlStr			= "<root><SEARCH " ;
					xmlStr 			+=" /></root>" ;
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open( "POST", "ORPlaceOrderSecurePINTEMPPASSValidation.jsp?mode=getLoginPraName&bean_id="+bean_id+"&bean_name="+bean_name, false ) ;
					xmlHttp.send( xmlDoc ) ;
					if(trimString(xmlHttp.responseText)!="false")
					{
						var str=(trimString(xmlHttp.responseText)).split("^") ;
						pract_id=str[0];
						pract_name=str[1];
					}
				}
				var xmlDoc = "";
			var xmlHttp = new XMLHttpRequest();
				xmlStr			= "<root><SEARCH " ;
				xmlStr 			+=" /></root>" ;
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open( "POST", "ORPlaceOrderSecurePINTEMPPASSValidation.jsp?mode=Get&keyObj="+patient_id+"_"+pract_id+"_MO"+"&patient_id="+patient_id, false ) ;
				xmlHttp.send( xmlDoc ) ;
				if(trimString(xmlHttp.responseText)!="false")
				{
					retVal="true";
				}else{
					
					retVal = await window.showModalDialog("../../eOR/jsp/ORPlaceOrderSecureUserPIN.jsp?mode=s&called_frm="+called_frm+"&order_category="+order_category+"&bean_id="+bean_id+"&bean_name="+bean_name+"&keyObj="+patient_id+"_"+pract_id+"_MO"+"&patient_id="+patient_id+"&pract_name="+pract_name+"&pract_id="+pract_id+""+"",arguments,features);
				}
			//[IN030566] Ends	
				if(retVal == "true")
				{
					// To Synchronize and to avoid Script Error.
					var xmlDoc = "";
				var xmlHttp = new XMLHttpRequest();
					xmlStr			= "<root><SEARCH " ;
					xmlStr 			+=" /></root>" ;
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open( "POST", "OrderEntryValidate.jsp?"+query_string, false ) ;
					xmlHttp.send( xmlDoc ) ;
					responseText=xmlHttp.responseText ;
					eval( responseText ) ;
				}
			}
			// else 												//[IN030563]
			else  if(trimString(xmlHttp.responseText)=="NA")		//[IN030563]
			{
			// IN029143 Ends
			// To Synchronize and to avoid Script Error.
					var xmlDoc = "";
					var xmlHttp = new XMLHttpRequest();
					xmlStr			= "<root><SEARCH " ;
					xmlStr 			+=" /></root>" ;
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open( "POST", "OrderEntryValidate.jsp?"+query_string, false ) ;
					xmlHttp.send( xmlDoc ) ;
					responseText=xmlHttp.responseText ;
					eval( responseText ) ;
			}
		}
		else
		{
					// To Synchronize and to avoid Script Error.
				var xmlDoc = "";
					var xmlHttp = new XMLHttpRequest();
					xmlStr			= "<root><SEARCH " ;
					xmlStr 			+=" /></root>" ;
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open( "POST", "OrderEntryValidate.jsp?"+query_string, false ) ;
					xmlHttp.send( xmlDoc ) ;
					responseText=xmlHttp.responseText ;
					eval( responseText ) ;
		}//IN029143 	
	} // End of cells
}  // End of the loadButtons

function LoadTabs(query_string)
{
 	criteriaPlaceOrderFrame.location.href = "../../eOR/jsp/OrderEntryPlaceOrderFrameSet.jsp?"+query_string;
}


function LoadPhTabs(query_string,ph_default_tab)
{
//IN069027 starts
	var orderCategory="PH";
	////44884 Start.
	var practitionerRel="N";
	var restOrdersSelf="N";
	var restOrdersFamily="N";
	
	practitionerRel = parent.tabFrame.document.formTab.practitionerRel.value;	
	restOrdersSelf=eval("parent.tabFrame.document.formTab.restBfrPlaceOrderS"+orderCategory).value;
	restOrdersFamily=eval("parent.tabFrame.document.formTab.restBfrPlaceOrderF"+orderCategory).value;
	
	if("N"!=practitionerRel){
		if("S"==practitionerRel && "Y"==restOrdersSelf ){
			if("PH"==orderCategory)
				alert(getMessage("RESTRICTED_PHORDER_SELF_FAMILY","OR"));
			else
				alert(getMessage("RESTRICTED_ORDER_SELF_FAMILY","OR"));
			
		return false;
		}
		if("F"==practitionerRel && "Y"==restOrdersFamily ){
			if("PH"==orderCategory)
				alert(getMessage("RESTRICTED_PHORDER_SELF_FAMILY","OR"));
			else
				alert(getMessage("RESTRICTED_ORDER_SELF_FAMILY","OR"));
			
			return false;
		}
	}
	//44884 Ends.
	var dxChkBfrPlaceOrderYN = eval("parent.parent.parent.orderMainTab.document.OrCommonForm.dxChkBfrPlaceOrder"+orderCategory).value;
	if("N"==dxChkBfrPlaceOrderYN){
			alert(getMessage("DIAG_NOT_RECORDED","OR"));
			//alert('Diagnosis not recorded, please complete to proceed further.');	
			return false;
	}else{	//IN069027 ends		
   	criteriaPlaceOrderFrame.location.href = "../../ePH/jsp/Prescription.jsp?"+query_string+"&ph_default_tab="+ph_default_tab;
	}

}


 function checkMaxValue(obj,max_durn_value,chk_for_max_durn_action,prompt_msg,soft_stop_yn,row_value,catcode)
 { 

	
 	if(obj.value!="")
 	{
 		if(obj.value==0)
 		{	
 			alert(getMessage("VALUE_SHOULD_BE_GR_ZERO","COMMON"));
 			obj.focus();
 		}
 		else
 		{
 			if(max_durn_value !='' && max_durn_value !='0')
 			{
 				if(parseInt(obj.value) > parseInt(max_durn_value))
 				{
 					if(chk_for_max_durn_action=="R")
 					{
 						alert(unescape(prompt_msg)); 
 						obj.focus();
 					}
 					else
 					{
						
 						alert(unescape(prompt_msg));
 					}
 				}
 			}
 			// Calculation for the End Date and Time
		 	var start_date_time 	= eval("document.placeOrderForm.start_date_time"+row_value+".value");
		 	var duration_code 		= eval("document.placeOrderForm.duration_code"+row_value+".value");
		 	var duration_value 		= eval("document.placeOrderForm.duration_value"+row_value+".value");
			calculateEndDateTime(start_date_time,duration_code,duration_value,row_value,'');	//start_date_time,Duration Code,Duration Value,called_from is null
 		}
 	} // End of obj.value!=""
 	else
 	{
		eval("document.placeOrderForm.end_date_time"+row_value+".value=''");
 		//var frequency_val = eval("document.placeOrderForm.frequency_val"+row_value+".value")
 		//if(soft_stop_yn!="Y" && frequency_val!="")
 		//{alert(getOrMessage("DURATION_CANNOT_BE_BLANK"));}
 	}
	
 }

function calculateEndDateTime(start_date_time,duration_code,duration_value,row,called_from)
{
	//called_from='applyAMEND';
//	alert("called_from====="+called_from);
	// Called from will be on click of record or on click of Schd hyperlink
	if(called_from=="apply")
		frame_name = "criteriaPlaceOrderFrame.placeOrderDetailFrame.document.placeOrderForm.end_date_time";
	else if(called_from=="applyAMEND")
		frame_name = "criteriaPlaceOrderFrame.placeOrderDetailFrame.document.placeOrderForm.amend_end_date_time";
	else if(called_from=="AMEND")
		frame_name = "document.placeOrderForm.amend_end_date_time";
	else 
		frame_name = "document.placeOrderForm.end_date_time";

	if(start_date_time!='' && duration_code!='' && duration_value!='')
	{
		var dt 	 		= start_date_time
		var date 		= dt.split(" ");
		
		datearray 		= date[0].split("/");
		minarray 		= date[1].split(":");
	
		// datearray[1] , month starts from 0
		dt = new Date(datearray[2],datearray[1]-1,datearray[0],minarray[0],minarray[1])
		if(duration_code=="H") //For Hours
		{
			var hrs 	 = dt.getHours();
			hrs 		 = parseInt(hrs) + parseInt(duration_value);
			date 		 = dt.setHours(hrs);
			date		 = new Date(date);
			dtString	 = buildDate(date,row);
			eval(frame_name+row).value=dtString;
		}
		else if(duration_code=="M") // For Minutes
		{
			var mins	 = dt.getMinutes();
			mins 		 = parseInt(mins) + parseInt(duration_value);
			date 		 = dt.setMinutes(mins);
			date		 = new Date(date);
			dtString	 = buildDate(date,row);
			eval(frame_name+row).value=dtString;
		}
		else if(duration_code=="D")  // For Days
		{
			var day 	 = dt.getDate();
			day 		 = parseInt(day) + parseInt(eval(duration_value));
			date		 = dt.setDate(day);
			date		 = new Date(date);
			dtString	 = buildDate(date,row);
			eval(frame_name+row).value=dtString;
		}
		else if(duration_code=="W")  // For Weeks
		{
			var day 	 = dt.getDate();
			week 		 = (parseInt(day) + (parseInt(duration_value) * 7));
			date		 = dt.setDate(week);
			date		 = new Date(date);
			dtString	 = buildDate(date,row);
			eval(frame_name+row).value=dtString;
		}
	}
}

function buildDate(date,row)
{
	var date_str	= buildDateWithoutHrsMin(date); // Will get dd/mm/yyyy
	var minutes 	= (date.getMinutes());
	if (parseInt(minutes)<10){
		minutes='0'+minutes;
	}
	var hours 		= (date.getHours());
	if (parseInt(hours)<10){
		hours='0'+hours;
	}
	var dtString 	= date_str +" "+hours+":"+minutes
	return dtString;
}

function buildDateWithoutHrsMin(date)
{
	var days 	= (date.getDate());
	if (parseInt(days)<10){
		days='0'+days;
	}
	var month 	= (date.getMonth())+1;
	if (parseInt(month)<10){
		month='0'+month;
	}
	var dtString 		= days+'/'+month+'/'+date.getYear();
	return dtString;
}

// For the Care set Authorization
function hideCareSetAuthorization(count)
{
	if(document.getElementById("hdg"+count))
		document.getElementById("hdg"+count).innerHTML='';
	if(document.getElementById("imageId"+count))
		document.getElementById("imageId"+count).innerHTML='';
	if(document.getElementById("authorizedId"+count))
	   document.getElementById("authorizedId"+count).innerHTML='';
}

function getApptReqdYN(order_catalog_code,perf_dept_loc_code,row_value)
{	
	//alert(order_catalog_code);
	//alert(perf_dept_loc_code);
	//alert(row_value);
	var bean_id 	= document.placeOrderForm.bean_id.value ;
	var bean_name 	= document.placeOrderForm.bean_name.value ;
	var xmlDoc = "";
	var xmlHttp = new XMLHttpRequest();
	xmlStr			= "<root><SEARCH " ;
	xmlStr 			+= "order_catalog_code=\""+order_catalog_code+"\" " ;
	xmlStr 			+= "perf_dept_loc_code=\""+perf_dept_loc_code.value+"\" " ;
	xmlStr 			+= "row_value=\""+row_value+"\" " ;
	xmlStr 			+=" /></root>" ;
	//alert("xmlStr 1278"+xmlStr);
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "OrderEntryValidate.jsp?bean_id=" + bean_id + "&bean_name="+ bean_name +"&row_value="+i+"&func_mode=APPT_REQN_YN", false ) ;
	xmlHttp.send( xmlDoc ) ;
	responseText	= xmlHttp.responseText ;
	eval( responseText ) ;
	//alert(responseText)
}

function apptReqYN(ApptReqdYN,index)
{
	//alert("1289====apptReqYN====ApptReqdYN"+ApptReqdYN);
	//alert("1290====apptReqYN====index"+index);
	if(eval("document.placeOrderForm.locn_appt_reqd_yn"+index))
	{
		//alert("here");
		if(ApptReqdYN=="Y")
		{
			eval("document.placeOrderForm.locn_appt_reqd_yn"+index+".value='Y'");
		}
		else if(ApptReqdYN=="N")
		{
			eval("document.placeOrderForm.locn_appt_reqd_yn"+index+".value='N'");
		}
		else
		{
			eval("document.placeOrderForm.locn_appt_reqd_yn"+index+".value=''");
		}

	//alert("wat is stored"+eval("document.placeOrderForm.locn_appt_reqd_yn"+index).value);
	}
}

async function show_request_comment_window(request_desc,index,order_type_code,format_id, field_mnemonic, new_seq_num, seq_num, max_dependency_rows, dependency_yn, order_category, contr_msr_panel_id, contr_msr_mod_id,discr_msr_id, performing_facility_id, oper_side_appl_yn, specimen_def_yn, login_facility_id, sex,catalog_code){

	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;

	dataNameArray[0] = "order_type_code";
	dataValueArray[0] = order_type_code;
	dataTypeArray[0] = STRING;

	argumentArray[0]   = document.getElementById(index + "_request_comment_sql").value;
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "2,3";
	argumentArray[5]   = request_desc ;
	argumentArray[6]   = CODE_LINK ;
	argumentArray[7]   = CODE_DESC ;

	retVal = await CommonLookup(getLabel("eOR.RequestComment.label","OR"), argumentArray );
var ret1=unescape(retVal);
	//alert("ret1"+ret1);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
	if(retVal != null && retVal != "")
	{
		document.getElementById(index + "_desc").value = arr[1];
		document.getElementById(index).value=arr[0];

		checkDependency(document.getElementById(index),format_id, field_mnemonic, new_seq_num, seq_num, max_dependency_rows, dependency_yn, order_category, contr_msr_panel_id, contr_msr_mod_id, order_type_code, discr_msr_id, performing_facility_id, oper_side_appl_yn, specimen_def_yn, login_facility_id, sex,catalog_code);

	}
	else
	{
		document.getElementById(index + "_desc").value ="";
		document.getElementById(index).value="";
	}
}

function before_show_request_comment_window(obj,index,order_type_code,format_id, field_mnemonic, new_seq_num, seq_num, max_dependency_rows, dependency_yn, order_category, contr_msr_panel_id, contr_msr_mod_id,discr_msr_id, performing_facility_id, oper_side_appl_yn, specimen_def_yn, login_facility_id, sex,catalog_code)
{
	show_request_comment_window(obj.value,index,order_type_code,format_id, field_mnemonic, new_seq_num, seq_num, max_dependency_rows, dependency_yn, order_category, contr_msr_panel_id, contr_msr_mod_id,discr_msr_id, performing_facility_id, oper_side_appl_yn, specimen_def_yn, login_facility_id, sex,catalog_code);
}


function show_request_comment_oth_desc(obj,index,accept_option)
{
	if(obj.checked==true)
	{
		document.getElementById(index + "_desc").value = "";
		document.getElementById(index).value = "";
		document.getElementById(index + "_desc").disabled = true;
		document.getElementById(index + "_btn").disabled = true;
		
		if (document.getElementById(index + "_request_comment_oth_desc").style) {
			document.getElementById(index + "_request_comment_oth_desc").style.visibility = "visible";
		}

		if (accept_option == "R") {
			if (document.getElementById(index + "_REQ_CMT_TXT").style) {
				document.getElementById(index + "_REQ_CMT_TXT").style.visibility = "visible";
			}
			if (document.getElementById(index + "_REQ_CMT_LOV").style) {
				document.getElementById(index + "_REQ_CMT_LOV").style.visibility = "hidden";
			}
		}

		if (document.getElementById(index + "_request_comment_oth_desc").style) {
			document.getElementById(index + "_request_comment_oth_desc").style.width = "250px"; 
		}
		
		/*if(eval("document.all."+index+"_request_comment_oth_desc").style)
			eval("document.all."+index+"_request_comment_oth_desc").style.visibility="visible";
		if(accept_option=="R")
		{
			if(eval("document.all."+index+"_REQ_CMT_TXT").style)
				eval("document.all."+index+"_REQ_CMT_TXT").style.visibility="visible";
			if(eval("document.all."+index+"_REQ_CMT_LOV").style)
				eval("document.all."+index+"_REQ_CMT_LOV").style.visibility="hidden";
		}
		if(eval("document.all."+index+"_request_comment_oth_desc").style)
			eval("document.all."+index+"_request_comment_oth_desc").style.width=250;*/
	}
	else
	{
		document.getElementById(index + "_request_comment_oth_desc").value = "";

		if (document.getElementById(index + "_request_comment_oth_desc").style) {
			document.getElementById(index + "_request_comment_oth_desc").style.visibility = "hidden";
			document.getElementById(index + "_request_comment_oth_desc").style.width = 0;
		}
		if(accept_option=="R")
		{
			if (document.getElementById(index + "_REQ_CMT_TXT").style) {
				document.getElementById(index + "_REQ_CMT_TXT").style.visibility = "hidden";
			}
			if (document.getElementById(index + "_REQ_CMT_LOV").style) {
				document.getElementById(index + "_REQ_CMT_LOV").style.visibility = "visible";
			}
		}
		
		document.getElementById(index + "_desc").value = "";
		document.getElementById(index).value = "";
		document.getElementById(index + "_desc").disabled = false;
		document.getElementById(index + "_btn").disabled = false;
	}
}
function before_show_donor_blood_group_window(obj,index,order_type_code,format_id, field_mnemonic, new_seq_num, seq_num, max_dependency_rows, dependency_yn, order_category, contr_msr_panel_id, contr_msr_mod_id,discr_msr_id, performing_facility_id, oper_side_appl_yn, specimen_def_yn, login_facility_id, sex,catalog_code)
{
	if(obj.value!="")
	{
		show_donor_blood_group_window(obj.value,index,order_type_code,format_id, field_mnemonic, new_seq_num, seq_num, max_dependency_rows, dependency_yn, order_category, contr_msr_panel_id, contr_msr_mod_id,discr_msr_id, performing_facility_id, oper_side_appl_yn, specimen_def_yn, login_facility_id, sex,catalog_code);
	}
	else
	{
		document.getElementById(index).value = "";
	}
}
async function show_donor_blood_group_window(request_desc,index,order_type_code,format_id, field_mnemonic, new_seq_num, seq_num, max_dependency_rows, dependency_yn, order_category, contr_msr_panel_id, contr_msr_mod_id,discr_msr_id, performing_facility_id, oper_side_appl_yn, specimen_def_yn, login_facility_id, sex,catalog_code)
{

	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;

	argumentArray[0]   = document.getElementById(index + "_donor_sql").value;
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "1,2";
	argumentArray[5]   = request_desc ;
	argumentArray[6]   = CODE_LINK ;
	argumentArray[7]   = CODE_DESC ;
	var title="";
	if(field_mnemonic=="DONOR_BLOOD_GROUP")
	{
		title = "Donor Blood Group";
	}
	else if(field_mnemonic=="DONOR_RHESUS")
	{
		title = "Donor Rhesus";
	}
	retVal = await CommonLookup(title, argumentArray );
	
	var str =unescape(retVal);
    var arr = str.split(",");

	if(retVal != null && retVal != "")
	{
		document.getElementById(index + "_desc").value= arr[1];
		document.getElementById(index).value=arr[0];

		checkDependency(document.getElementById(index),format_id, field_mnemonic, new_seq_num, seq_num, max_dependency_rows, dependency_yn, order_category, contr_msr_panel_id, contr_msr_mod_id, order_type_code, discr_msr_id, performing_facility_id, oper_side_appl_yn, specimen_def_yn, login_facility_id, sex,catalog_code);

	}
	else
	{
		document.getElementById(index + "_desc").value = "";
        document.getElementById(index).value = "";
	}
}

function validateTransplantDate(obj,localeName)
{
 if((!isBeforeNow(obj.value,'DMYHM',localeName)))
	{
		for(var i=0;i<document.OrderFormatForm.length;i++)	
		{
			if(document.OrderFormatForm[i].type=="text")
			{
				if(document.OrderFormatForm[i].name.indexOf('TRANSPLANT_DATE')!=-1 )
				{ 
					if(document.OrderFormatForm[i].value!="")
					{
						document.OrderFormatForm[i].focus();
						document.OrderFormatForm[i].select();
						alert(getMessage("DATE_SHOULD_BE_LESS_THAN_SYSDATE_TIME",'OR'));
					}
				}
			}
		}
		return false;
	}
}
//IN064543 start
async function showPreviewEditorInstrn(beanId,beanName,catalogCode,catalog_desc){
	var finalString 	= "beanId="+beanId+"&beanName="+beanName+"&catalogCode="+catalogCode+"&catalog_desc="+catalog_desc;
 	var retVal 			= new String();
	var dialogHeight 	= "30" ;
	var dialogWidth  	= "50" ;
	var dialogTop    	= "300";
    var status 			= "no";
	var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; dialogTop:"+dialogTop+"; scroll=auto; status:no";
	retVal = await window.showModalDialog("../../eOR/jsp/OrderEntryPreviewInstruction.jsp?"+finalString,arguments,features);
}

//IN064543 end

