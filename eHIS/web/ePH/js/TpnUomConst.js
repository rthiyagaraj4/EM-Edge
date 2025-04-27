//saved on 07/11/2005
var function_id = "PH_TPN_CONST_UOM";
var result		= false;
var message		= "";
var flag		= "";

function create() {
	f_query_add_mod.location.href="../../ePH/jsp/TpnUomConstFrames.jsp?function_id="+function_id+"&mode="+MODE_INSERT;
}

function apply() {
   //alert(parent.document.formTpnUomConstUOMParameters.itmfld_req_yn.value);
	var formObj1=f_query_add_mod.f_tpn_cons_uom_hdr.document.formTpnUomConstUOMParameters;
	var formObj2=f_query_add_mod.f_tpn_cons_uom_dtl.document.formTpnUomConstUOMQuantity;

	var fields = new Array ( formObj1.energy_unit ,formObj1.regimen_presc_base_unit);
	var names = new Array (getLabel("ePH.Energy.label","PH"),getLabel("ePH.PrescribingBaseUnitforRegimen.label","PH"));
	var flag=true;
	var errors="";
var fluidArray=new Array();
fluidArray[1]="Fluids";fluidArray[2]="Macro Nutrients";fluidArray[3]="Electrolytes";fluidArray[4]="Phospate";
fluidArray[5]="Trace Elements";fluidArray[6]="Zinc";fluidArray[7]="Copper";fluidArray[8]="Manganese";fluidArray[9]="Chromium";
fluidArray[10]="Iodide";fluidArray[11]="Vitamins";fluidArray[12]="Other Components";fluidArray[13]="Selenium";
fluidArray[14]="Molybdenum";fluidArray[15]="Heper Sodium";

	if(f_query_add_mod.f_tpn_cons_uom_hdr.checkFieldsofMst( fields, names, messageFrame)) {
	
		for (var i=1;i<=formObj2.total_count.value ;i++ )
	{				
			
			flag = true;
			var fields  = new Array() ;
			var names   = new Array() ;
			var temp="";
			//alert(i);
			//alert(eval("formObj2.regimen_setup_unit"+i).value);
			//alert(eval("formObj2.order_qty_limit_unit"+i).value);
	if(fluidArray[i]=="Fluids" || fluidArray[i]=="Macro Nutrients")
		{
           if(eval("formObj2.regimen_setup_unit"+i).value =="X" || eval("formObj2.order_qty_limit_unit"+i).value =="X" || eval("formObj2.prep_unit"+i).value =="X")
			{
	          errors="APP-PH0230 Regimen Setup , Constituents Limit and Preparation at Pharmacy are mandatory for  " + fluidArray[i] + "<br>" ;
			  messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ errors;
			}
		}
if((eval("formObj2.regimen_setup_unit"+i).value !="X") && (eval("formObj2.order_qty_limit_unit"+i).value) =="X")
		{ 
	//alert("48");
	            var j=0;
				var k=0;
	      if((eval("formObj2.regimen_setup_unit"+i).value !="X")) 
		    {
			  //alert("53");
				
				fields[j]   = eval("formObj2.regimen_setup_unit"+i).value ;
				//names[k]   = getLabel("ePH.RegimenSetup.Label","PH") ;
				names[k]   = " Regimen Setup" ;
				j++;
				k++;
				}
		
		  else if((eval("formObj2.regimen_setup_unit"+i).value =="X"))
			{
			  //alert("64");
				fields[j]   = "X" ;
				//names[k]   = getLabel("ePH.RegimenSetup.Label","PH") ;
				names[k]   = " Regimen Setup" ;
				j++;
				k++;

		}
				//alert(names[k]);
	}
	else if((eval("formObj2.regimen_setup_unit"+i).value !="") && (eval("formObj2.order_qty_limit_unit"+i).value !="X")){
		
             var j=0;
			var k=0;
			if(eval("formObj2.order_qty_limit_unit"+i).value !="X"){
					//alert("79");
					fields[j]   = eval("formObj2.order_qty_limit_unit"+i).value ;
					//names[k]   = getLabel("ePH.ConstituentsLimit.Label","PH")  ;
					names[k]   = " Constituents Limit " ;
					j++;
					k++;
				}
			if(eval("formObj2.ordering_unit"+i).value !=""){
					//alert("87");	
					fields[j]   = eval("formObj2.ordering_unit"+i).value ;
					//names[k]   =getLabel("ePH.OrderSetup.Label","PH") ;
					names[k]   = " Order Setup " ;
					j++;
					k++;
				}
			if(eval("formObj2.prep_unit"+i).value !="X"){
					//alert("95");	
					fields[j]   = eval("formObj2.prep_unit"+i).value ;
					//names[k]   = getLabel("ePH.PreparationatPharmacy.Label","PH") ;
					names[k]   = " Preparation at Pharmacy " ;
					j++;
					k++;	
				}
				else if(eval("formObj2.prep_unit"+i).value =="X")
		        {
					eval("formObj2.prep_unit"+i).focus();
					errors="APP-PH0229 Preparation at Pharmacy should not be blank for  " + fluidArray[i] + "<br>" ;
					messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ errors;
				}
						//alert(names[k]);
		}
		else if((eval("formObj2.regimen_setup_unit"+i).value =="X") && (eval("formObj2.order_qty_limit_unit"+i).value =="X"))
			{
					//alert("112");
			         var j=0;
			         var k=0;
			       fields[j]   = eval("formObj2.regimen_setup_unit"+i).value ;
					//names[k]   = getLabel("ePH.RegimenSetup.Label","PH") ;
					names[k]   = " Regimen Setup" ;
					j++;
					k++;
				
						
					fields[j]   = eval("formObj2.order_qty_limit_unit"+i).value ;
					//names[k]   = getLabel("ePH.ConstituentsLimit.Label","PH")  ;
					names[k]   = " Constituents Limit " ;
					j++;
					k++;
			
			
					fields[j]   = eval("formObj2.ordering_unit"+i).value ;
					//names[k]   = getLabel("ePH.OrderSetup.Label","PH") ;
					names[k]   = " Order Setup " ;
					j++;
					k++;
			
			        if((eval("formObj2.prep_unit"+i).value !="X") && (eval("formObj2.order_qty_limit_unit"+i).value !=""))
				   {
					   //alert("137");
					eval("formObj2.order_qty_limit_unit"+i).focus();
					errors="APP-PH0229 Constituents Limit should not be blank for  " + fluidArray[i] + "<br>" ;
					messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ errors;
					}
					else{
						//alert("143");
					fields[j]   = eval("formObj2.prep_unit"+i).value ;
					//names[k]   = getLabel("ePH.PreparationatPharmacy.Label","PH") ;					
					names[k]   = " Preparation at Pharmacy " ;
					j++;
					k++;
			      }
		//alert(names[k]);
			}
			else if((eval("formObj2.regimen_setup_unit"+i).value !="X") && (eval("formObj2.order_qty_limit_unit"+i).value !="X"))
		   {
				var j=0;
				var k=0;
			//alert("156");	

			if(eval("formObj2.regimen_setup_unit"+i).value !=""){
				//alert("159");
					fields[j]   = eval("formObj2.regimen_setup_unit"+i).value ;
					//names[k]   = getLabel("ePH.RegimenSetup.Label","PH") ;
					names[k]   = " Regimen Setup" ;
					j++;
					k++;
				}
			if(eval("formObj2.order_qty_limit_unit"+i).value !=""){
					//alert("167");	
					fields[j]   = eval("formObj2.order_qty_limit_unit"+i).value ;
					//names[k]   = getLabel("ePH.ConstituentsLimit.Label","PH")  ;
					names[k]   = " Constituents Limit " ;
					j++;
					k++;
				}
			if(eval("formObj2.ordering_unit"+i).value !=""){
					//alert("175");	
					fields[j]   = eval("formObj2.ordering_unit"+i).value ;
					//names[k]   =getLabel("ePH.OrderSetup.Label","PH") ;					
					names[k]   = " Order Setup " ;
					j++;
					k++;
				}
			if(eval("formObj2.prep_unit"+i).value !=""){
					//alert("183");	
					fields[j]   = eval("formObj2.prep_unit"+i).value ;
					//names[k]   = getLabel("ePH.PreparationatPharmacy.Label","PH") ;
					names[k]   = " Preparation at Pharmacy " ;
					j++;
					k++;	
				}
						//alert(names[k]);
			}
		//alert(fields.length);
		if (fields.length > 0)
		{
			for (l=0;l<fields.length ;l++ )
			{
				
				if(trimCheck(fields[l])) {
				fields[l] = trimString(fields[l]);
				}
				else
				{
					errors =errors+ getMessage("VALUE_NOT_VALID_IN_RECORD_NUMBER","PH") + i + "<br>" ;
					//errors =errors+ "APP-000001 Value not valid in record number " + i + "<br>" ;				
				}
		
			}//for

		
			if (errors == "")
			{
				
				flag=true;
			}
			else
			{
				
				//errors = "Provide data for any one of the group";
				flag=false;
				
			}
		}
		else
		{
			
			flag=false;
			errors =errors+ "APP-000001   Record  all applicable UOM for " + fluidArray[i] + "<br>" ;		

		}
		if (flag==false)
		{
		
			break;
		}
		}//end of for loop

		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ errors;	
		if(errors=="")
		{

			var formArray = new Array(formObj1,formObj2);
			//alert(formApply( formArray,PH_CONTROLLER ));
		eval(formApply( formArray,PH_CONTROLLER ));
        result=true;
		if(result)
		{

		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;	
		onSuccess();		
		}

		}
			
	}//end of if frame 
}

function reset() {
	
}

function assignResult( _result, _message, _flag ) {
	result	= _result;
	message	= _message;
	flag	= _flag;
}

function beforePost(xmlStr) {
//	alert(xmlStr);
}

function onSuccess(){
	f_query_add_mod.location.href="../../ePH/jsp/TpnUomConstFrames.jsp?function_id="+function_id+"&mode="+MODE_INSERT;
}

function checkFlds( fields, names) {
/*	//alert("hai from check fld1111");
	var errors = new Array() ;
	alert("length:"+fields.length);
	
	for( var i=1; i<=fields.length; i++ ) {
//alert("from trim:"+fields.lenght+"   "+trimCheck(fields[i].value));
//alert("from trim check:"+trimCheck(fields[i].value));
		if(trimCheck(fields[i].value)) {
		
			fields[i].value = trimString(fields[i].value);

		}
		else{
			alert("from else error block");
			errors[i] + = "APP-000001 " + names[i] + " cannot be blank..." + "<br>" ;						
		}
	}


	alert("error:"+errors.length);
	if ( errors.length != 0 ) {
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ errors;		
		return false ;
	}
	return true ;*/
var errors="";
//alert("from check filed 1");
	if(fields.length >0)
		{
		for( var i=1; i<=fields.length; i++ ) {
		if(trimCheck(fields[i].value)) {
			fields[i].value = trimString(fields[i].value);
		}
			else
			{
			errors =errors+ "APP-000001 " + names[i] + " cannot be blank..." + "<br>" ;				
			}
		}
		//alert("from check filed 3");
	if(errors=="")
			{
				//alert("from check filed 4");
			return true;
			}
	else
			{
		//alert("from check filed 5");
			return false;
			}
	}//main if loop
	else
	{
			return false;
	}
		
}


function checkforZero(obj){
if (obj.name=="max_weight")
    var legend="Maximum weight for pediatric patient";
else
    legend="Minimum weight for adult patient";

if(obj.value=='0'){
	alert(legend +" should be greater than zero");
    obj.focus();
	obj.value='';
	return false;
 }
}

function checkRange(maxweight,minweight){
	var obj1=parseInt(minweight.value);
    var obj2=parseInt(maxweight.value);

if(obj1 < obj2)
 {
	alert(getMessage("PH_MIN_WT_GREATER_MAX_WT"));
    minweight.focus();
	minweight.value='';
	return false;
 }
}


function assignVal(obj)
{
	if(obj.checked==true)
		document.formTpnUomConstUOMParameters.itmfld_req_yn.value='Y';
	else
        document.formTpnUomConstUOMParameters.itmfld_req_yn.value='N';
}