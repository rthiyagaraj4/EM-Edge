//*************************************************************************************************
// Function apply()
//**************************************************************************************************
function apply()
{
	window.f_query_add_mod.document.forms[0].submit();
	window.commontoolbarFrame.document.location.href='../../eCommon/jsp/MstCodeToolbar.jsp';
	window.commontoolbarFrame.document.location.reload();
}
//******************************************************************************************************
// Function reset()
//*******************************************************************************************************
function reset() 
{
	if(window.f_query_add_mod.document.forms[0])
    {
		window.f_query_add_mod.document.forms[0].reset();
	}
}
//**********************************************************************************************************
 // Function CashBill Lookup
//*******************************************************************************************************

function searchCashbill()
{
	this.document.forms[0].Cash_bill_ctrl_main_ac2_desc.value='';
	this.document.forms[0].Cash_bill_ctrl_main_ac2.value='';  	 
	var tdesc="";
	var tcode="";
	var retVal =new String();
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var tit=getLabel("eXH.Cash_bill_ctrl_main_ac1.Label","XH");     
	var target=this.document.forms[0].Cash_bill_ctrl_main_ac1_desc;
	var Profile_id=this.document.forms[0].Cash_bill_ctrl_main_ac1;	   
	var sql="SELECT MAIN_ACC1_CODE code,SHORT_DESC description FROM gl_acc_chart "+
	"   WHERE UPPER(MAIN_ACC1_CODE) LIKE UPPER(?) AND "+ 
	"           UPPER(SHORT_DESC) LIKE UPPER(?) "+
	"           ORDER BY 1 ";
	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2";
	argumentArray[5] = target.value;
	argumentArray[6] = DESC_LINK  ;
	argumentArray[7] = DESC_CODE ;
	retVal = CommonLookup( tit, argumentArray );
	if(retVal != null && retVal != "" ){	
		var ret1=unescape(retVal);
		arr=ret1.split(",");
//		alert("arr[0] : "+arr[0]);
		target.value=arr[1];
		Profile_id.value=arr[0];
		this.document.forms[0].Cash_bill_ctrl_main_ac2_desc.disabled=false;			 
		this.document.forms[0].CashBillSearch2.disabled=false;		 
	}																		 
	else{
		target.value=tdesc;
		Profile_id.value=tcode;										  
	}													 
	}
//**********************************************************************************************************
// Function CashBill Lookup
//*******************************************************************************************************

function searchCashbill2()
{
	var tdesc="";
	var tcode="";
	var retVal =new String();
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var tit=getLabel("eXH.Cash_bill_ctrl_main_ac2.Label","XH");     
	var target=this.document.forms[0].Cash_bill_ctrl_main_ac2_desc;
	var Profile_id=this.document.forms[0].Cash_bill_ctrl_main_ac2;	   
	var sql="SELECT MAIN_ACC2_CODE code,SHORT_DESC description FROM gl_acc_chart "+
	"   WHERE UPPER(MAIN_ACC1_CODE) LIKE UPPER(?) AND "+ 
	"           UPPER(SHORT_DESC) LIKE UPPER(?) and MAIN_ACC1_CODE='"+this.document.forms[0].Cash_bill_ctrl_main_ac1.value+"' "+
	"           ORDER BY 1 ";
	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2";
	argumentArray[5] = target.value;
	argumentArray[6] = DESC_LINK  ;
	argumentArray[7] = DESC_CODE ;
	retVal = CommonLookup( tit, argumentArray );
	if(retVal != null && retVal != "" ){
		var ret1=unescape(retVal);
		arr=ret1.split(",");
//		alert("arr[0] : "+arr[0]);
		target.value=arr[1];
		Profile_id.value=arr[0];
	}																		 
	else{
		target.value=tdesc;
		Profile_id.value=tcode;
	}													 
}
//**********************************************************************************************************
// Function Application Lookup
//*******************************************************************************************************
function searchApplicationID(){
	var tdesc="";
	var tcode="";
	var retVal =new String();
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var tit=getLabel("eXH.ExtGLApplication.Label","XH");
	var target=this.document.forms[0].Application_type;
	var Profile_id=this.document.forms[0].Application_type_id;
	var sql="SELECT APPLICATION_ID code,APPLICATION_NAME description FROM XH_Application "+
	"   WHERE UPPER(APPLICATION_ID) LIKE UPPER(?) AND "+ 
	"           UPPER(APPLICATION_NAME) LIKE UPPER(?) "+
	"           ORDER BY 1 ";
	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2";
	argumentArray[5] = target.value;
	argumentArray[6] = DESC_LINK  ;
	argumentArray[7] = DESC_CODE ;
	retVal = CommonLookup( tit, argumentArray );
	if(retVal != null && retVal != "" ){
		var ret1=unescape(retVal);
		arr=ret1.split(",");
		target.value=arr[1];
		Profile_id.value=arr[0];
	}
	else{
		target.value=tdesc;
		Profile_id.value=tcode;
	}
}
//**********************************************************************************************************
// Function searchFacility
//*******************************************************************************************************
function searchFacility(){
	var tdesc="";
	var tcode="";
	var retVal =new String();
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var tit= getLabel("Common.facility.label","common");
	var target=this.document.forms[0].facility_name;
	var faclty_id=this.document.forms[0].facility_id; 
	var locale=document.forms[0].locale.value;
	sql="SELECT X.FACILITY_ID code,X.FACILITY_NAME description FROM SM_FACILITY_PARAM_LANG_VW X,XH_PARAM_FOR_FACILITY Y,SM_MODULES_FACILITY Z WHERE  X.LANGUAGE_ID='en' AND Z.MODULE_ID='XH' AND Z.OPERATIONAL_YN='Y' AND X.FACILITY_ID=Y.FACILITY_ID AND X.FACILITY_ID=Z.FACILITY_ID AND UPPER(X.FACILITY_ID) LIKE UPPER(?) AND    UPPER(X.FACILITY_NAME) LIKE UPPER(?)   ORDER BY 1 ";
	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2";
	argumentArray[5] = target.value;
	argumentArray[6] = DESC_LINK  ;
	argumentArray[7] = DESC_CODE ;
	retVal = CommonLookup( tit, argumentArray );
	if(retVal != null && retVal != "" ){
		var ret1=unescape(retVal);
		arr=ret1.split(",");
		target.value=arr[1];
		faclty_id.value=arr[0];
	}
	else{
		target.value=tdesc;
		faclty_id.value=tcode;
	}
}// End of searchFacility
//**********************************************************************************************************
// Function funcheck    checked and unchecked conditon for check box
//*******************************************************************************************************
function funcheck(obj)																  
{																					  				   
	if(obj.checked==true)
	{
		obj.value="Y";
	}																				 
	else
	{
		obj.value="N";
	}

}			

//**********************************************************************************************************
// Function CheckForSpecCharsforID    textbox validation
//*******************************************************************************************************
function CheckForSpecCharsforID(event){
	var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ';
	var whichCode = (window.Event) ? event.which : event.keyCode;
	key = String.fromCharCode(whichCode);  // Get key value from key code
	if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
	return (event.keyCode -= 32);
	return true ;
}
//**********************************************************************************************************
// Function CheckForSpecCharsforID    Textbox Number validation
//*******************************************************************************************************
function CheckForSpecCharsforNumber(event){
	var strCheck = '0123456789';
	var whichCode = (window.Event) ? event.which : event.keyCode;
	key = String.fromCharCode(whichCode);  // Get key value from key code
	if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
	return (event.keyCode -= 32);
	return true ;													  
}
//**********************************************************************************************************
// Function checkMonth    Month  Validation
//*******************************************************************************************************
function checkMonth(obj)
{
	if(parseInt(obj.value)>12)
	{
		var msg=getMessage("INVALID_VALUE","common");
		alert(msg.replace("#","Month"));
	}

}
//**********************************************************************************************************
// Function    Cash_bill_ctrl_main_ac2_desc lOOKUP enable and disable condition
//*******************************************************************************************************
function checkEnable(obj)
{
	if(obj.value=='')
	{
		this.document.forms[0].Cash_bill_ctrl_main_ac2_desc.disabled=true;			 
		this.document.forms[0].CashBillSearch2.disabled=true;		 
	}
	else
	{
		this.document.forms[0].Cash_bill_ctrl_main_ac2_desc.disabled=false;			 
		this.document.forms[0].CashBillSearch2.disabled=false;		 
	}
}
//**********************************************************************************************************
// Function funYearCheck    Year  Validation
//*******************************************************************************************************
function funYearCheck(obj)
{
	if(obj.value==''||obj.value==0)
	{
	}
	else
	{
		if(obj.value.length<=3)
		{
			var ms=getMessage("INVALID_VALUE","common");
			alert(ms.replace('#','Year'));
			obj.focus();
		}
		else
		{
			var d =  new Date(); 											  
			var year=d.getYear(); 
			if(parseInt(obj.value)>year)										    
			{
				var ms=getMessage("XH0084","XH");
				alert(ms.replace('#','Year'));
				obj.focus();
			}
		} 
	}

}
