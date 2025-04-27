/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
/*
--------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        	Description
--------------------------------------------------------------------------------------------------------------
21/11/2012 IN036390			vijayakumark	For all the OR reports where the ?Report criteria? has ?Locations? as a filter, the system should only displays all the locations in that log in facility only
26/12/2012 IN036491			Karthi L		Order type code from and to values restricted to bottom to top.
29/08/2013 IN030303			Vijayakumark	REGRESSION - OR Reports>Order type is not displayed correctly after cleared for a Category
08/05/2015 IN055319			Nijitha			ML-BRU-SCF-1607 : Include facility id in OR->Order Statistics Report 
09/06/2015 IN055594			Nijitha S		Alpha-OR- Order Statistics Report - System does not clear the location value when location type is changed.
02/06/2019	19208			Nijitha S		02/06/2019		Ramesh G	MOHE-SCF-0108-TF
--------------------------------------------------------------------------------------------------------------------------------------
*/
var errors="";
function run()
	
		{
			var localeName=repOrderStatFrame.document.forms[0].localeName.value;
			fields = new Array( repOrderStatFrame.document.forms[0].p_fr_date,repOrderStatFrame.document.forms[0].p_to_date);
			names =  new Array( getLabel("Common.DateFrom.label","Common") ,getLabel("Common.DateTo.label","Common") );
			if(repOrderStatFrame.checkFields(fields,names,messageFrame))
			{
			repOrderStatFrame.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
			//if(!doDateCheck(repOrderStatFrame.document.forms[0].p_fr_date,repOrderStatFrame.document.forms[0].p_to_date,messageFrame)) 
		//Commented on 16/02/2007 while doing thai date validations
		if(!isBefore(repOrderStatFrame.document.forms[0].p_fr_date.value,repOrderStatFrame.document.forms[0].p_to_date.value,"DMY",localeName)) 
			{
			var errors=getMessage('FROM_DATE_GREATER_TO_DATE','FM'); 
			messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num="+errors ;
			return false;
			}
			//if(!doDateCheck(repOrderStatFrame.document.forms[0].p_to_date,repOrderStatFrame.document.forms[0].to_date,messageFrame)) 
			//Commented on 16/02/2007 while doing thai date validations
			if(!isBefore(repOrderStatFrame.document.forms[0].p_to_date.value,repOrderStatFrame.document.forms[0].to_date.value,"DMY",localeName)) 
			{	
				var errors=getMessage('DATE_NOT_GREATER_SYSDATE','common');
				messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num="+errors ;
				return false;
			}
			// added for IN036491 - Start
			//if(repOrderStatFrame.document.forms[0].ord_TypeF.value.toUpperCase()  > repOrderStatFrame.document.forms[0].ord_TypeT.value.toUpperCase())
			if(repOrderStatFrame.document.forms[0].p_fr_ord_type.value.toUpperCase()  > repOrderStatFrame.document.forms[0].p_to_ord_type.value.toUpperCase())// modifed for IN036491
			{
				
				var stMessage = getMessage("LESS_OR_EQUAL_VALIDATE", "OR");
				stMessage = stMessage.replace(/@/g, getLabel("eOR.OrderTypeCode.label", "OR"));
				messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num="+stMessage ;
				return false;
			}
			// End
			repOrderStatFrame.document.forms[0].submit() ;	
			}
			else
				{
			
				var errors;
				
				var formObj=repOrderStatFrame.document.forms[0];
				var fromDate = formObj.p_fr_date
				var toDate = formObj.p_to_date
				if(!trimCheck(fromDate.value))
					{
				errors=getMessage("FROM_DATE_CANNOT_BE_BLANK","SM");
				messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num="+errors ;
				return false;				
					}
			if(!trimCheck(toDate.value))
				{
				errors=getMessage("TO_DT_NOT_BLANK","SM");
				messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num="+errors ;
				return false;
				}


				}

		}
	

function reset()
		{
			repOrderStatFrame.document.repOrderStatForm.reset() ;

		}

function showCalendarValidate(str)
		
		{
			var flg = showCalendar(str);
			//eval("document.all."+str+".focus();");
			document.getElementById(str).focus();
			return flg;
		}

/*function populateValues()
		{
			var fromDate = document.repOrderStatForm.frm_date;
			var toDate = document.repOrderStatForm.p_to_date;

			if(doDateCheckOR(fromDate,toDate) == 1) 
				{
					alert(getMessage("TO_DT_GR_EQ_FM_DT"));
					return false ;
				}
		}
		*/
	
//**The function is not used any where , thats why commented by prasad 16th Feb**
/*function validate_to_date(obj)
	
	{
		if(obj.value.length>0)
			{
				if(obj.value!=document.forms[0].p_fr_date.value)
					{
						CheckDate(obj);
						//DateValidation(obj);
					}
				if(!doDateChecknew(document.forms[0].p_fr_date,document.forms[0].p_to_date))
					{
						alert( getMessage("TO_DT_GR_EQ_FM_DT","SM" ));
						//obj.select();
						//obj.focus();
					}
			}
	}*/
//**The function is not used any where , thats why commented by prasad 16th Feb**
/*function validate_from_date(obj)
		
		{
			
			if(obj.value.length>0)
			
			{
				if(obj.value!=document.forms[0].p_fr_date.value)
				{
					DateValidation(obj);
				}
			
			if(!doDateChecknew(document.forms[0].p_fr_date,document.forms[0].p_to_date))
					{
						alert( getMessage("TO_DT_GR_EQ_FM_DT","SM" ));
						//obj.select();
						//obj.focus();
					}
				}
			
		}*/

//***This function is commented by prasad 16th Feb because this used in validate_from_date & validate_to_date which are also commented***
/*function DateValidation(obj)
		
		{
			curdate = document.forms[0].to_date;
			var msg=getMessage("DATE_MORE_THAN_SYS_DATE","OR");
			if(doDateCheckAlert(curdate,obj) == false) 
				{
					obj.focus();
					obj.select();
					alert(msg);
				}
		}*/
	
// ***This function is commented by prasad 16th feb because used in the DateValidation which is also commented***
/*function doDateCheckAlert(from,to) 
		
		{
			var fromarray; var toarray;
			var fromdate = from.value ;
			var todate = to.value ;
			if(fromdate.length > 0 && todate.length > 0 ) {
				fromarray = fromdate.split("/");
				toarray = todate.split("/");
				var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
				var todt = new Date(toarray[2],toarray[1],toarray[0]);	
				if(Date.parse(todt) < Date.parse(fromdt)) {
					return false;
				}
				else if(Date.parse(todt) >= Date.parse(fromdt)) return true;
			}	
			return true;
		}*/

// This is also used in the commented function thats why this is also commented (by prasad 16th feb)
/*function doDateChecknew(from,to)
		{
		var fromarray; var toarray;
		var fromdate = from.value ;
		var todate = to.value ;

		if(fromdate.length > 0 && todate.length > 0 ) 
		{
			fromarray = fromdate.split("/");
			toarray = todate.split("/");
			var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
			var todt = new Date(toarray[2],toarray[1],toarray[0]);	
			if(Date.parse(todt) < Date.parse(fromdt)) 
			{
				//messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=APP-SM0012 - To Date should be greater than or equal to From Date";		
				return false;
			}
			else if(Date.parse(todt) >= Date.parse(fromdt)) return true;
		}	
		return true;
		}*/

async function orderType_lookup(target,target_id)
		
		{
			var orderCategory = parent.repOrderStatFrame.document.repOrderStatForm.p_ord_cat.value;

			if (orderCategory == "")
			{
				var msg=getMessage("ORDER_CATEGORY","OR");				
				alert(msg);
				return false;
			}
			
			var retVal		   = new String();
			var argumentArray  = new Array(7); 
			var argumentArray  = new Array() ;
			var dataNameArray  = new Array() ;
			var dataValueArray = new Array() ;
			var dataTypeArray  = new Array() ;
			var sql = "";
					

			sql="SELECT  order_type_code code, short_desc description FROM or_order_type WHERE ORDER_CATEGORY = '"+orderCategory+"' and eff_status ='E' and upper(order_type_code) like upper(?) and upper(short_desc) like upper(?) ";

			argumentArray[0] = sql;
			argumentArray[1] = dataNameArray ;
			argumentArray[2] = dataValueArray ;
			argumentArray[3] = dataTypeArray ;
			argumentArray[4] = "1,2";
			argumentArray[5] = target.value;
			argumentArray[6] = DESC_LINK;
			argumentArray[7] = DESC_CODE;

			var retVal = await CommonLookup( getLabel("Common.OrderType.label","Common"), argumentArray );
			var ret1 = unescape(retVal);
			arr=ret1.split(",");
			// Commented By Abdulhamid Mohamed
//			if(retVal !=null && retVal != ""){
//				code.value=retVal[0];
//				target.value=retVal[1];
//				
//				}else{
//		   		target.value = "";
//		   		code.value = "" ;
//		 	}
			// Added By Abdulhamid Mohamed
			if(arr[1] == undefined){
				arr[0] = "";
				arr[1] = "";	
			}else{
		   		target.value = arr[1];
		   		target_id.value = arr[0];
		 	}
		}


	async function location_lookup1(target,target_id)
		
		{
			var locn_type = parent.repOrderStatFrame.document.repOrderStatForm.p_locn_type.value;
			var facility_id =parent.repOrderStatFrame.document.repOrderStatForm.p_facility_id.value;//IN036390
			var retVal		   = new String();
			var argumentArray  = new Array(7); 
			var argumentArray  = new Array() ;
			var dataNameArray  = new Array() ;
			var dataValueArray = new Array() ;
			var dataTypeArray  = new Array() ;
			var sql = "";
						
			/*IN036390 starts here */
			//sql ="select locn_code code, location_desc description from or_ORDERING_LOCATION_VW where locn_type = nvl(('"+locn_type+"'),locn_type)and upper(locn_code) like upper(?) and upper(location_desc) like upper(?) ";
			
			sql ="select locn_code code, location_desc description from or_ORDERING_LOCATION_VW where locn_type = nvl(('"+locn_type+"'),locn_type)and upper(locn_code) like upper(?) and upper(location_desc) like upper(?) and facility_id = '"+facility_id+"' ";//19208
			/*IN036390 ends here */

			
			argumentArray[0] = sql
			argumentArray[1] = dataNameArray ;
			argumentArray[2] = dataValueArray ;
			argumentArray[3] = dataTypeArray ;
			argumentArray[4] = "1,2";
			argumentArray[5] = target.value;
			argumentArray[6] = DESC_LINK;
			argumentArray[7] = DESC_CODE;
			
			var retVal = await CommonLookup( getLabel("Common.Location.label","Common"), argumentArray );
			var ret1 = unescape(retVal);
			arr=ret1.split(",");
			// Commented By Abdulhamid Mohamed
//			if(retVal !=null && retVal != ""){
//				code.value=retVal[0];
//				target.value=retVal[1];
//				
//				}else{
//		   		target.value = "";
//		   		code.value = "" ;
//		 	}
			// Added By Abdulhamid Mohamed
			if(arr[1] == undefined){
				arr[0] = "";
				arr[1] = "";	
			}else{
		   		target.value = arr[1];
		   		target_id.value = arr[0];
		 	}

		}

function chkDate(Obj) //Add by prasad due to thai date validations on 16th feb
		{
			var localeName=parent.repOrderStatFrame.document.forms[0].localeName.value;
			if (!validDateObj(Obj,"DMY",localeName))
			{
				Obj.value="";
				
			}
		}

/*	function activityType_lookup(target,target_id)
			
			{

				var orderCategory = parent.repOrderStatFrame.document.repOrderStatForm.p_ord_cat.value;
				var ordertypecode = parent.repOrderStatFrame.document.repOrderStatForm.order_type_code.value;
				var retVal		   = new String();
				var argumentArray  = new Array(7); 
				var argumentArray  = new Array() ;
				var dataNameArray  = new Array() ;
				var dataValueArray = new Array() ;
				var dataTypeArray  = new Array() ;
				var sql = "";
						

				sql="SELECT activity_type code, short_desc description FROM or_activity_type WHERE order_category = '"+orderCategory+"' AND order_type_code = '"+ordertypecode+"' and eff_status ='E' union SELECT  activity_type code, short_desc description FROM or_activity_type WHERE order_category = '"+orderCategory+"' AND order_type_code = '*ALL' and eff_status ='E'and upper(activity_type) like upper(?) and upper(short_desc) like upper(?) ";

				argumentArray[0] = sql;
				argumentArray[1] = dataNameArray ;
				argumentArray[2] = dataValueArray ;
				argumentArray[3] = dataTypeArray ;
				argumentArray[4] = "2,1";
				argumentArray[5] = target.value;
				argumentArray[6] = DESC_LINK;
				argumentArray[7] = DESC_CODE;

				var retVal = await CommonLookup( "Activity Type", argumentArray );

				if(retVal != null && retVal != "" ) 
					{
						target_id.value = retVal[0] ; 
						target.value = retVal[1] ; 
					}
				else
					{
						target.value="";
						target_id.value="";
					}
					
				
			}
*/

function checkFieldsLocal( fields, names, messageFrame) 
{
    var errors = "" ;
    for( var i=0; i<fields.length; i++ ) {
        if(trimCheck(fields[i].value)) {
            fields[i].value = trimString(fields[i].value);
        }
		else
		{
			var err = getMessage('CAN_NOT_BE_BLANK','Common');
				err = err.replace('$', names[i]);
			errors = errors + err + "<br>" ;
		}
    }
    //return errors ;
alert(errors);	messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num="+errors ;

}
//IN030303 starts
function ordertypefrom(ord_TypeF,p_fr_ord_type){
	if(ord_TypeF.value != "") {
	orderType_lookup(ord_TypeF,p_fr_ord_type);
	}else{
	ord_TypeF.value = "";
	p_fr_ord_type.value = "";
	}
}
		
function ordertypeto(ord_TypeT,p_to_ord_type){
	if(ord_TypeT.value != ""){
	orderType_lookup(ord_TypeT,p_to_ord_type);
	}else {
	ord_TypeT.value = "";
	p_to_ord_type.value = "";
	}
}
function clearOrderType()
		{
			var order_typefrom = parent.repOrderStatFrame.document.repOrderStatForm.ord_TypeF;
			var p_from_order_type = parent.repOrderStatFrame.document.repOrderStatForm.p_fr_ord_type;
			var order_TypeTo = parent.repOrderStatFrame.document.repOrderStatForm.ord_TypeT;
			var p_to_order_type = parent.repOrderStatFrame.document.repOrderStatForm.p_to_ord_type;
		
			order_typefrom.value = "";
			p_from_order_type.value = "";
			order_TypeTo.value = "";
			p_to_order_type.value = "";
		}
//IN030303 ends
//IN055319 Starts
function setOrderFaci(obj)
{
	parent.repOrderStatFrame.document.repOrderStatForm.facility_id.value = obj.value;
}
//IN055319 Ends
//IN055594 Starts
function populateSourceLocation(p_source_type){
	parent.repOrderStatFrame.document.repOrderStatForm.location.value="";
	parent.repOrderStatFrame.document.repOrderStatForm.p_locn_code.value="";
}
//IN055594 Ends
