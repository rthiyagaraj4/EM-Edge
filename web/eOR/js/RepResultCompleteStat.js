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

12/08/2013 IN037296			Vijayakumark	Alpha-OR-OR Reports->System is displaying Fatal error for leap date in Thai
29/08/2013 IN030303			Vijayakumark	REGRESSION - OR Reports>Order type is not displayed correctly after cleared for a Category
--------------------------------------------------------------------------------------------------------------
*/
var totemp;
function run()
	
		{
			var localeName=repResultCompleteStatFrame.document.forms[0].localeName.value;
			/*if(localeName.value!='en')
				{
			 repResultCompleteStatFrame.document.forms[0].p_fr_date.value=convertDate( repResultCompleteStatFrame.document.forms[0].fr_date.value,'DMY',localeName,"en");
			repResultCompleteStatFrame.document.forms[0].p_to_date.value=convertDate(repResultCompleteStatFrame.document.forms[0].to_date1.value,'DMY',localeName,"en");
				}else
			{
			repResultCompleteStatFrame.document.forms[0].p_fr_date.value=repResultCompleteStatFrame.document.forms[0].fr_date.value;
			repResultCompleteStatFrame.document.forms[0].p_to_date.value=repResultCompleteStatFrame.document.forms[0].to_date1.value;
			}*/
			//alert("here1"+repResultCompleteStatFrame.document.forms[0].p_fr_date.value);
			//alert("here2"+repResultCompleteStatFrame.document.forms[0].p_to_date.value);
			fields = new Array( repResultCompleteStatFrame.document.forms[0].p_fr_date,repResultCompleteStatFrame.document.forms[0].p_to_date);
			names =  new Array( getLabel("Common.DateFrom.label","Common") ,getLabel("Common.DateTo.label","Common") );
			if(repResultCompleteStatFrame.checkFields(fields,names,messageFrame))
			{
				
			repResultCompleteStatFrame.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
			//if(!doDateCheck(repResultCompleteStatFrame.document.forms[0].p_fr_date,repResultCompleteStatFrame.document.forms[0].p_to_date,messageFrame)) 
			if(!isBefore(repResultCompleteStatFrame.document.forms[0].p_fr_date.value,repResultCompleteStatFrame.document.forms[0].p_to_date.value,"DMY",localeName)) 
			//Commented on 16/02/2007 while doing thai date validations
			{
			var errors=getMessage('FROM_DATE_GREATER_TO_DATE','FM'); 
			messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num="+errors ;
			return false;
			}
			 //if(!doDateCheck(repResultCompleteStatFrame.document.forms[0].p_to_date,repResultCompleteStatFrame.document.forms[0].to_date,messageFrame)) 
			//Commented on 16/02/2007 while doing thai date validations
		/*	if(localeName.value!='en')
				{
						totemp=convertDate(repResultCompleteStatFrame.document.forms[0].to_date.value,'DMY',localeName,"en")
				}
					else
				{*/
						totemp=repResultCompleteStatFrame.document.forms[0].to_date.value;
				//}

			if(!isBefore(repResultCompleteStatFrame.document.forms[0].p_to_date.value,totemp,"DMY",localeName)) 
			{	
				var errors=getMessage('DATE_NOT_GREATER_SYSDATE','common');
				messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num="+errors ;
				return false;
			}

			repResultCompleteStatFrame.document.forms[0].submit() ;	
			}
			else
				{
				var errors;
				
				var formObj=repResultCompleteStatFrame.document.forms[0];
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
		repResultCompleteStatFrame.document.RepResultCompleteStatForm.reset() ;
	}

function showCalendarValidate(str)
	
	{
		var flg = showCalendar(str);
		//eval("document.all."+str+".focus();");
		document.getElementById(str).focus();
		return flg;
	}

/*

function populateValues(){
	
	
	var fromDate = document.RepResultCompleteStatForm.frm_date;
	var toDate = document.RepResultCompleteStatForm.to_date;
	
	
	if(doDateCheckOR(fromDate,toDate) == 1) {
		alert(getMessage("TO_DT_GR_EQ_FM_DT"));
		return false ;
	}
}
*/

//**The function is not used any where , thats why commented by prasad 15th Feb**
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
						alert(getMessage( "TO_DT_GR_EQ_FM_DT","SM" ));
					}
			}
	}*/
//**The function is not used any where , thats why commented by prasad 15th Feb**
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
						alert(getMessage( "TO_DT_GR_EQ_FM_DT","SM" ));
					}
				}
			
		}*/

//***This function is commented by prasad 15th Feb because this used in validate_from_date & validate_to_date which are also commented***
/*function DateValidation(obj)
		
		{
			curdate = document.forms[0].today_date;
			var msg=getMessage("DATE_MORE_THAN_SYS_DATE","OR");
			if(doDateCheckAlert(curdate,obj) == false) 
				{
					obj.focus();
					obj.select();
					alert(msg);
				}
		}*/

// ***This function is commented by prasad 15th feb because used in the DateValidation which is also commented***
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
// This is also used in the commented function thats why this is also commented (by prasad 15th feb)
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
			var orderCategory = parent.repResultCompleteStatFrame.document.RepResultCompleteStatForm.p_ord_cat.value;
			
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

		function chkDate(Obj) //Add by prasad due to thai date validations on 15th feb
		{
			var localeName=parent.repResultCompleteStatFrame.document.forms[0].localeName.value;
			if (!validDateObj(Obj,"DMY",localeName))
			{
				Obj.value="";
				
			}
		}
		
		//IN030303 starts
		function ordertypefrom(ord_Type,p_fr_ord_type){
				
		if(ord_Type.value != "") {
		orderType_lookup(ord_Type,p_fr_ord_type);
		}else{
		ord_Type.value = "";
		p_fr_ord_type.value = "";
		}
		
		}
		
		function ordertypeto(to_ord_Type,p_to_ord_type){
			
		if(to_ord_Type.value != ""){
		 orderType_lookup(to_ord_Type,p_to_ord_type);
		}else {
		to_ord_Type.value = "";
		p_to_ord_type.value = "";
		}
		
		}
		function clearOrderType()
		{
			var order_typefrom = parent.repResultCompleteStatFrame.document.RepResultCompleteStatForm.ord_Type;
			var p_from_order_type = parent.repResultCompleteStatFrame.document.RepResultCompleteStatForm.p_fr_ord_type;
			var order_TypeTo = parent.repResultCompleteStatFrame.document.RepResultCompleteStatForm.to_ord_Type;
			var p_to_order_type = parent.repResultCompleteStatFrame.document.RepResultCompleteStatForm.p_to_ord_type;
		
			order_typefrom.value = "";
			p_from_order_type.value = "";
			order_TypeTo.value = "";
			p_to_order_type.value = "";
		}
		
		//IN030303 ends


/*function activityType_lookup(target,target_id)
		
		{
			var orderCategory = parent.repResultCompleteStatFrame.document.RepResultCompleteStatForm.p_ord_cat.value;
			var ordertypecode = parent.repResultCompleteStatFrame.document.RepResultCompleteStatForm.ord_Type.value;

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



