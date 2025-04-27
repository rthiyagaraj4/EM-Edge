/*
---------------------------------------------------------------------------------------------------------
Date			Edit History    	Name		Rev. Date		Rev. By			Description
---------------------------------------------------------------------------------------------------------
14/02/2017		IN060945		Badmavathi B						MMS-DM-CRF-0084 - FDA_CODE added
24/05/2017		IN063603		Badmavathi B						GHL-CRF-0456
05/07/2017		IN060124		SooryaPrakash M						GHL-CRF-0405
7/1/2019		IN068781		Shazana								GHL-CRF-0549.1
14/1/2019		IN069437		Shazana								GHL-CRF-0548.1
07/05/2019      IN:069013       B Haribabu                          AMS-CRF-0204.1
20/5/2020		IN73000			Shazana								PH-MMS-Dispense Medication
---------------------------------------------------------------------------------------------------------
*/ 
var	function_id	=	"" ;
var result		=	false ;
var message		=	"" ;
var flag		=	"" ;


function create() {
	f_query_add_mod.location.href="../../eMM/jsp/ItemFrameset.jsp?function_id="+function_id+"&mode="+MODE_INSERT; 
}

function query() {
	f_query_add_mod.location.href="../../eMM/jsp/ItemQueryCriteria.jsp?function_id="+function_id ;
}

function apply() {
	copyFromDownFrame();
	if(f_query_add_mod.item_class_detail==undefined)
	{
	messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
	return false;
	}
	var	frameReference =f_query_add_mod.item_class_detail.document.item_master_form2;
	if(frameReference.item_anal1_code.value!="" && frameReference.item_anal2_code.value !="")
	{
		if (f_query_add_mod.item_class_detail.document.item_master_form2.item_anal1_code.value==f_query_add_mod.item_class_detail.document.item_master_form2.item_anal2_code.value)
		{
			var message_item =getMessage("ITEM_ANLSIS_UNIQUE","ST");
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+message_item
			return;
		}
	}
	if(frameReference.item_anal2_code.value!="" && frameReference.item_anal3_code.value !="")
	{
		if (f_query_add_mod.item_class_detail.document.item_master_form2.item_anal2_code.value==f_query_add_mod.item_class_detail.document.item_master_form2.item_anal3_code.value)
		{
			
			var message_item =getMessage("ITEM_ANLSIS_UNIQUE","ST");
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+message_item
			return;
		}
	}
	if(frameReference.item_anal1_code.value!="" && frameReference.item_anal3_code.value !="")
	{
		if (f_query_add_mod.item_class_detail.document.item_master_form2.item_anal1_code.value==f_query_add_mod.item_class_detail.document.item_master_form2.item_anal3_code.value)
		{
			
			var message_item =getMessage("ITEM_ANLSIS_UNIQUE","ST");
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+message_item
			return;
		}
	}
	if(f_query_add_mod.item_detail.document.item_master_form1.mandatory_check.value=="mandatory")
	{
		if(f_query_add_mod.item_detail.document.item_master_form1.ps_item_yn.checked==true || f_query_add_mod.item_detail.document.item_master_form1.cssd_component_yn.checked==true)
		{
		}
		else
		{
			var message_item =getMessage("ITEM_EITHER_PH_CSSD","MM");
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+message_item
			return;
		}
	}
	//Added for MMS-DM-CRF-0209.2 starts 
	if(f_query_add_mod.item_detail.document.item_master_form1.category_code1!=null && f_query_add_mod.item_detail.document.item_master_form1.category_code1.value=="B")
	{
		if(f_query_add_mod.item_detail.document.item_master_form1.alternate!=null && (f_query_add_mod.item_detail.document.item_master_form1.alternate.value=="Y" ||f_query_add_mod.item_detail.document.item_master_form1.alternate.value=="N"))
		{
		}
		else
		{
			var message_item = getMessage("ALTERNATE_MISSING","MM");
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+message_item
			return;
		}
	}
	//Added for MMS-DM-CRF-0209.2 ends 
	var formObj = f_query_add_mod.item_detail.document.item_master_form1;
	var formObj1 = f_query_add_mod.item_class_detail.document.item_master_form2;
	//added for 69437 start
	var itemdesc=f_query_add_mod.item_detail.document.getElementById("Item_Tech_Desc").value;
	if(itemdesc == ""){
		f_query_add_mod.item_detail.document.item_master_form1.Item_Tech_Code.value="";
	}
	//added for 69437 end
	if( formObj.material_group_mandatory.value =="Y")
	{
	//Added for IN:069013 start and else part modified
		if((formObj.site.value=="true" || formObj.site.value== true)&&(formObj.site_specific.value == "true" || formObj.site_specific.value == true)){
			var fields = new Array ( formObj.item_code 
					,formObj.alpha_code
					,formObj.hsn_no
					,formObj.long_desc
					,formObj.short_desc
					,formObj.category_type_code
					,formObj.item_class_code
					,formObj.gen_uom_code
					,formObj.material_group_code
					,formObj.lowcost_item
					,formObj.highcost_item
					,formObj.innovator_item
					);
		}
		//Added for IN:069013 end
		// Added for AMS-CRF-0127 Starts
		else if(formObj.site.value=="true" || formObj.site.value== true)
		{	
		var fields = new Array ( formObj.item_code 
						,formObj.alpha_code
						,formObj.hsn_no
						,formObj.long_desc
						,formObj.short_desc
						,formObj.category_type_code
						,formObj.item_class_code
						,formObj.gen_uom_code
						,formObj.material_group_code
						);
		}
		//added for ghl-crf-0549.1 Starts
		
		else if (formObj.site_specific.value == "true" || formObj.site_specific.value == true){
			var fields = new Array ( formObj.item_code 
					,formObj.alpha_code
					,formObj.long_desc
					,formObj.short_desc
					,formObj.category_type_code
					,formObj.item_class_code
					,formObj.gen_uom_code
					,formObj.material_group_code
					,formObj.lowcost_item
					,formObj.highcost_item
					,formObj.innovator_item
					);
			
		} //added for ghl-crf-0549.1 ENDS
		else
		{	
			var fields = new Array ( formObj.item_code 
						,formObj.alpha_code
						
						,formObj.long_desc
						,formObj.short_desc
						,formObj.category_type_code
						,formObj.item_class_code
						,formObj.gen_uom_code
						,formObj.material_group_code
						);
		}
		//Added for AMS-CRF-0127 ends
	}
	else
	{
	//Added for IN:069013 start and else part modified
		if((formObj.site.value=="true" || formObj.site.value== true)&&(formObj.site_specific.value == "true" || formObj.site_specific.value == true)){
			var fields = new Array ( formObj.item_code 
					,formObj.alpha_code
					,formObj.hsn_no
					,formObj.long_desc
					,formObj.short_desc
					,formObj.category_type_code
					,formObj.item_class_code
					,formObj.gen_uom_code
					,formObj.material_group_code
					,formObj.lowcost_item
					,formObj.highcost_item
					,formObj.innovator_item
					);
		}
		//Added for IN:069013 end
		//Added for AMS-CRF-0127 Starts
		else if(formObj.site.value=="true" || formObj.site.value == true)
			{	
				var fields = new Array ( formObj.item_code 
						,formObj.alpha_code
						,formObj.hsn_no
						,formObj.long_desc
						,formObj.short_desc
						,formObj.category_type_code
						,formObj.item_class_code
						,formObj.gen_uom_code						
						);
			}// ghl-crf-0549.1  starts
			
		else if (formObj.site_specific.value == true || formObj.site_specific.value == "true"){
				var fields = new Array ( formObj.item_code 
						,formObj.alpha_code
						,formObj.hsn_no
						,formObj.long_desc
						,formObj.short_desc
						,formObj.category_type_code
						,formObj.item_class_code
						,formObj.gen_uom_code
						,formObj.lowcost_item
						,formObj.highcost_item
						,formObj.innovator_item
						);
				// ghl-crf-0549.1  ENDS
			}
			else
			{
				var fields = new Array ( formObj.item_code 
						,formObj.alpha_code
						
						,formObj.long_desc
						,formObj.short_desc
						,formObj.category_type_code
						,formObj.item_class_code
						,formObj.gen_uom_code						
						);
			}	
			//Added for AMS-CRF-0127 ends
			
	}
	if( formObj.material_group_mandatory.value =="Y")
	{
	//Added for IN:069013 start and else part modified
		if((formObj.site.value=="true" || formObj.site.value== true)&&(formObj.site_specific.value == "true" || formObj.site_specific.value == true)){
			var names = new Array ( getLabel("Common.ItemCode.label","Common"),
					getLabel("eMM.ItemAlphaCode.label","MM"),
					getLabel("eMM.HSNCode.label","MM"),
					getLabel("Common.longdescription.label","Common"),
					getLabel("Common.shortdescription.label","Common"),
					getLabel("eMM.CategoryType.label","MM"),
					getLabel("Common.ItemClass.label","Common"),
					getLabel("Common.uom.label","Common"),
					getLabel("eMM.MaterialGroup.label","MM"),
					getLabel("eMM.LowCostItem.label","MM"),
					getLabel("eMM.HighMarginItem.label","MM"),
					getLabel("eMM.InnovatorItem.label","MM")
					//added for GHL-CRF-0549.1 ENDS
				);
		}
		//Added for IN:069013 end
		//Added for AMS-CRF-0127 Starts
		else if(formObj.site.value=="true" || formObj.site.value== true)
		{	
			var names = new Array ( getLabel("Common.ItemCode.label","Common"),
							getLabel("eMM.ItemAlphaCode.label","MM"),
							getLabel("eMM.HSNCode.label","MM"),
							getLabel("Common.longdescription.label","Common"),
							getLabel("Common.shortdescription.label","Common"),
							getLabel("eMM.CategoryType.label","MM"),
							getLabel("Common.ItemClass.label","Common"),
							getLabel("Common.uom.label","Common"),
							getLabel("eMM.MaterialGroup.label","MM")									
						); //added for GHL-CRF-0549.1 STARTS
		}
		
		else if (formObj.site_specific.value == true || formObj.site_specific.value == "true"){
			
			var names = new Array ( getLabel("Common.ItemCode.label","Common"),
					getLabel("eMM.ItemAlphaCode.label","MM"),
					getLabel("Common.longdescription.label","Common"),
					getLabel("Common.shortdescription.label","Common"),
					getLabel("eMM.CategoryType.label","MM"),
					getLabel("Common.ItemClass.label","Common"),
					getLabel("Common.uom.label","Common"),
					getLabel("eMM.MaterialGroup.label","MM"),
					getLabel("eMM.LowCostItem.label","MM"),
					getLabel("eMM.HighMarginItem.label","MM"),
					getLabel("eMM.InnovatorItem.label","MM")
					//added for GHL-CRF-0549.1 ENDS
				);
		}
		else
		{	
			var names = new Array ( getLabel("Common.ItemCode.label","Common"),
							getLabel("eMM.ItemAlphaCode.label","MM"),
							
							getLabel("Common.longdescription.label","Common"),
							getLabel("Common.shortdescription.label","Common"),
							getLabel("eMM.CategoryType.label","MM"),
							getLabel("Common.ItemClass.label","Common"),
							getLabel("Common.uom.label","Common"),
							getLabel("eMM.MaterialGroup.label","MM")									
						);
		}
		//Added for AMS-CRF-0127 ends
		
	}
	else
	{
	//Added for IN:069013 start and else part modified
		if((formObj.site.value=="true" || formObj.site.value== true)&&(formObj.site_specific.value == "true" || formObj.site_specific.value == true)){
			var names = new Array ( getLabel("Common.ItemCode.label","Common"),
					getLabel("eMM.ItemAlphaCode.label","MM"),
					getLabel("eMM.HSNCode.label","MM"),
					getLabel("Common.longdescription.label","Common"),
					getLabel("Common.shortdescription.label","Common"),
					getLabel("eMM.CategoryType.label","MM"),
					getLabel("Common.ItemClass.label","Common"),
					getLabel("Common.uom.label","Common"),
					getLabel("eMM.MaterialGroup.label","MM"),
					getLabel("eMM.LowCostItem.label","MM"),
					getLabel("eMM.HighMarginItem.label","MM"),
					getLabel("eMM.InnovatorItem.label","MM")
					//added for GHL-CRF-0549.1 ENDS
				);
		}
		//Added for IN:069013 end
		//Added for AMS-CRF-0127 starts
		else if(formObj.site.value=="true" || formObj.site.value== true)
			{
				var names = new Array ( getLabel("Common.ItemCode.label","Common"),
							getLabel("eMM.ItemAlphaCode.label","MM"),
							getLabel("eMM.HSNCode.label","MM"),
							getLabel("Common.longdescription.label","Common"),
							getLabel("Common.shortdescription.label","Common"),
							getLabel("eMM.CategoryType.label","MM"),
							getLabel("Common.ItemClass.label","Common"),
							getLabel("Common.uom.label","Common")
						);
			}
			//added for GHL-CRF-0549
		else if (formObj1.site_specific.value == true || formObj1.site_specific.value == "true"){
				
				var names = new Array ( getLabel("Common.ItemCode.label","Common"),
						getLabel("eMM.ItemAlphaCode.label","MM"),
						getLabel("Common.longdescription.label","Common"),
						getLabel("Common.shortdescription.label","Common"),
						getLabel("eMM.CategoryType.label","MM"),
						getLabel("Common.ItemClass.label","Common"),
						getLabel("Common.uom.label","Common"),
						getLabel("eMM.LowCostItem.label","MM"),
						getLabel("eMM.HighMarginItem.label","MM"),
						getLabel("eMM.InnovatorItem.label","MM")
						
					);
			}		
			else
			{
				var names = new Array ( getLabel("Common.ItemCode.label","Common"),
							getLabel("eMM.ItemAlphaCode.label","MM"),
							
							getLabel("Common.longdescription.label","Common"),
							getLabel("Common.shortdescription.label","Common"),
							getLabel("eMM.CategoryType.label","MM"),
							getLabel("Common.ItemClass.label","Common"),
							getLabel("Common.uom.label","Common")
						);
			}
			//Added for AMS-CRF-0127 ends
	}
	
	var index		=	7;
	if( formObj.material_group_mandatory.value =="Y")
		index = 8;

	if(formObj.sole_source_yn.value=="Y"){
		names[index]=getLabel("Common.Manufacturer.label","Common");
		fields[index++]=formObj1.manufacturer_id;
	}
	
			var errorPage	= "../../eCommon/jsp/error.jsp" ;	
		var blankObj 	= null ;
		blankObject  = checkMMFields( fields, names, messageFrame,errorPage) ;
		if(formObj.billable_yn.checked==true)
			formObj.billable_yn.value="Y";
		else
			formObj.billable_yn.value="N";
		
		
		if(blankObject==true)
		{
			var responseText=formApply(formObj, MM_CONTROLLER)
			
			eval(responseText) ;
			messageFrame.location.href = errorPage+"?err_num="+ message ;
				if( result ) 
					onSuccess() ;
		}
		else
		{
		}
}

function copyFromDownFrame()
{
if(f_query_add_mod.item_detail==undefined)
	{
	messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
	return false;
	}
	if(f_query_add_mod.item_detail.document.item_master_form1.ps_item_yn.type=="checkbox")
	{
		if(f_query_add_mod.item_detail.document.item_master_form1.ps_item_yn.checked)
		{
			f_query_add_mod.item_detail.document.item_master_form1.ps_item_yn.value="Y"
		}
		else
		{
			f_query_add_mod.item_detail.document.item_master_form1.ps_item_yn.value="N";
		}
	}
	if(f_query_add_mod.item_detail.document.item_master_form1.cssd_component_yn.type=="checkbox")
	{
		if(f_query_add_mod.item_detail.document.item_master_form1.cssd_component_yn.checked)
			f_query_add_mod.item_detail.document.item_master_form1.cssd_component_yn.value="Y"
		else
			f_query_add_mod.item_detail.document.item_master_form1.cssd_component_yn.value="N";
	}
	
if(f_query_add_mod.item_class_detail.document.item_master_form2.sole_source_yn.type=="checkbox")
{
	if(f_query_add_mod.item_class_detail.document.item_master_form2.sole_source_yn.checked)
		f_query_add_mod.item_detail.document.item_master_form1.sole_source_yn.value=f_query_add_mod.item_class_detail.document.item_master_form2.sole_source_yn.value
	else
		f_query_add_mod.item_detail.document.item_master_form1.sole_source_yn.value="N";
}

if(f_query_add_mod.item_class_detail.document.item_master_form2.special_item_yn.type=="checkbox")
{
	if(f_query_add_mod.item_class_detail.document.item_master_form2.special_item_yn.checked)
		f_query_add_mod.item_detail.document.item_master_form1.special_item_yn.value     =f_query_add_mod.item_class_detail.document.item_master_form2.special_item_yn.value
	else
		f_query_add_mod.item_detail.document.item_master_form1.special_item_yn.value     ="N";
}

if(f_query_add_mod.item_class_detail.document.item_master_form2.imported_item.type=="checkbox")
{
	if(f_query_add_mod.item_class_detail.document.item_master_form2.imported_item.checked)
		f_query_add_mod.item_detail.document.item_master_form1.imported_item.value     =f_query_add_mod.item_class_detail.document.item_master_form2.imported_item.value
	else
		f_query_add_mod.item_detail.document.item_master_form1.imported_item.value     ="N";
}
if(f_query_add_mod.item_class_detail.document.item_master_form2.reimbursable_item_yn.type=="checkbox")
{
	if(f_query_add_mod.item_class_detail.document.item_master_form2.reimbursable_item_yn.checked)
		f_query_add_mod.item_detail.document.item_master_form1.reimbursable_item_yn.value     =f_query_add_mod.item_class_detail.document.item_master_form2.reimbursable_item_yn.value
	else
		f_query_add_mod.item_detail.document.item_master_form1.reimbursable_item_yn.value     = "N";
}
if(f_query_add_mod.item_class_detail.document.item_master_form2.essential_item.type=="checkbox")
{
	if(f_query_add_mod.item_class_detail.document.item_master_form2.essential_item.checked)
		f_query_add_mod.item_detail.document.item_master_form1.essential_item.value     =f_query_add_mod.item_class_detail.document.item_master_form2.essential_item.value
	else
		f_query_add_mod.item_detail.document.item_master_form1.essential_item.value     ="N";
}

f_query_add_mod.item_detail.document.item_master_form1.curr_supp_code.value      =f_query_add_mod.item_class_detail.document.item_master_form2.curr_supp_code.value
f_query_add_mod.item_detail.document.item_master_form1.item_anal1_code.value     =f_query_add_mod.item_class_detail.document.item_master_form2.item_anal1_code.value
f_query_add_mod.item_detail.document.item_master_form1.item_anal2_code.value     =f_query_add_mod.item_class_detail.document.item_master_form2.item_anal2_code.value
f_query_add_mod.item_detail.document.item_master_form1.item_anal3_code.value     =f_query_add_mod.item_class_detail.document.item_master_form2.item_anal3_code.value
f_query_add_mod.item_detail.document.item_master_form1.manufacturer_id.value     =f_query_add_mod.item_class_detail.document.item_master_form2.manufacturer_id.value
f_query_add_mod.item_detail.document.item_master_form1.reimburse_type.value     =f_query_add_mod.item_class_detail.document.item_master_form2.reimburse_type.value

	//Added against CRF No-12 Inc#29966 by Sakti Sankar on 03/09/2012
f_query_add_mod.item_detail.document.item_master_form1.place_of_origin.value     =f_query_add_mod.item_class_detail.document.item_master_form2.place_of_origin.value
f_query_add_mod.item_detail.document.item_master_form1.fda_code.value    		 =f_query_add_mod.item_class_detail.document.item_master_form2.fda_code.value;//Added for MMS-DM-CRF-0084

		if(f_query_add_mod.item_detail.document.item_master_form1.package_item_yn.checked)
		{
			f_query_add_mod.item_detail.document.item_master_form1.package_item_yn.value="Y"
		}
		else
		{
			f_query_add_mod.item_detail.document.item_master_form1.package_item_yn.value="N";
		}
		
		//Added for MMS-DM-CRF-0209.2 starts 
		if(f_query_add_mod.item_class_detail.document.item_master_form2.category_code1!=null)
			{
			f_query_add_mod.item_detail.document.item_master_form1.category_code1.value    	 =f_query_add_mod.item_class_detail.document.item_master_form2.category_code1.value;
			}
		else
			{
			f_query_add_mod.item_detail.document.item_master_form1.category_code1.value    	 ="";
			}
        if(f_query_add_mod.item_class_detail.document.item_master_form2.alternate!=null)
        	{
        	f_query_add_mod.item_detail.document.item_master_form1.alternate.value    		 =f_query_add_mod.item_class_detail.document.item_master_form2.alternate.value;//Added for MMS-DM-CRF-0209.2
        	}
        else
        	{
        	f_query_add_mod.item_detail.document.item_master_form1.alternate.value ="";
        	}
        if(f_query_add_mod.item_class_detail.document.item_master_form2.site_cat_alt!=null)
        {
        	f_query_add_mod.item_detail.document.item_master_form1.site_cat_alt.value    		 =f_query_add_mod.item_class_detail.document.item_master_form2.site_cat_alt.value;//Added for MMS-DM-CRF-0209.2
        }
        else
        {
        	f_query_add_mod.item_detail.document.item_master_form1.site_cat_alt.value="";
        }

      //Added for MMS-DM-CRF-0209.2 ends 
}


function assignResult( _result, _message, _flag ) 
{
	result		=	_result ;
	message		=	_message ;
	flag		=	_flag ;
}

function reset() 
{
	formReset() ;
	if(f_query_add_mod.item_class_detail!=null)
	f_query_add_mod.item_class_detail.document.item_master_form2.reset();
}

function onSuccess() 
{
	var mode	=	f_query_add_mod.item_detail.document.item_master_form1.mode.value;
	if( mode == MODE_INSERT ) 
	{
		formReset();
	}
	else
	{
		f_query_add_mod.item_detail.document.location.reload();
	}

}

function formReset () 
{
	if(f_query_add_mod.item_detail!=null)
	{
	f_query_add_mod.location.reload();

	
	}
		
	if(f_query_add_mod.document.query_form!=null)
		f_query_add_mod.document.query_form.reset();

	
		
}

function Modify(obj){
	var code1=obj.cells[0].innerText;
	document.location.href="../../eMM/jsp/ItemFrameset.jsp?item_code="+code1+"&function_id="+parent.function_id+"&mode="+MODE_MODIFY;

}


async function searchSupplier(objCode,objDesc) {
	//alert("sup");
 	objDesc.value = "";
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
    var language_id  = document.forms[0].language_id.value;
    

	argumentArray[0] = document.item_master_form2.SQL_MM_ITEM_MASTER_SUPPLIER.value+"'"+language_id+"'";
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "1,2";
	argumentArray[5] = objDesc.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;

	returnedValues = await CommonLookup( getLabel("Common.Supplier.label","Common"), argumentArray );
		var ret1=unescape(returnedValues);
	//alert("ret1"+ret1);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
	if((returnedValues != null) && (returnedValues != "") )  {
		objCode.value = arr[0];
		objDesc.value = arr[1];
		
	} 
}
/*Sharanraj GHL-CRF-0548.1 Starts*/

async function searchItemTech(objCode,objDesc) {
	
	var oldobjDesc = decodeURIComponent(objDesc.value,"UTF-8"); // added for IN069437
 	//objDesc.value = ""; //commented for IN069437
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
    var language_id  = document.forms[0].language_id.value;
    
	argumentArray[0] = document.item_master_form1.SQL_MM_ITEM_TECH_NAME.value+"'"+language_id+"'";
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "1,2";
	argumentArray[5] = objDesc.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;

	returnedValues = await CommonLookup( getLabel("eMM.ItemTechName.label","eMM"), argumentArray );
	 //retArray = await CommonLookup( title, argArray );		
	var ret1=unescape(returnedValues);
	//alert("ret1"+ret1);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
	if((returnedValues != null) && (returnedValues != "") )  {
		objCode.value = arr[0];
		objDesc.value = arr[1];
	}
//added for IN069437	
	if( (oldobjDesc!= null) && ((returnedValues == null) || (returnedValues == "")) ){ 
		objDesc.value = oldobjDesc;
	}
		
}
/*Sharanraj GHL-CRF-0548.1 ends*/

function changeManu()

{
	if(!(parent.item_detail.document.item_master_form1.eff_status==null))
	{
		if(!(parent.item_detail.document.item_master_form1.eff_status.checked) && parent.item_detail.document.item_master_form1.mode.value==MODE_MODIFY)
		{

		}
		else
		{
			if(parent.item_class_detail.document.item_master_form2.sole_source_yn.checked==false)
			{
				parent.item_class_detail.document.item_master_form2.manufacturer_id.options[0].selected=true;
				parent.item_class_detail.document.item_master_form2.manufacturer_id.disabled=true;
				document.getElementById('span2').style.visibility="hidden";
			}
			else
			{	
				document.getElementById('span2').style.visibility="visible";
				parent.item_class_detail.document.item_master_form2.manufacturer_id.disabled=false;
			}
		}

	}	
} 

async function callTextBox ()
{
	
	var item_specification= parent.item_detail.document.item_master_form1.item_specification.value;
	
	//retVal=window.showModalDialog("../jsp/ItemGetRemarkPopup.jsp?item_specification="+item_specification,'','dialogHeight:10; dialogWidth: 19; center: 1; status: no; dialogTop :200;');
	//Added by Sakti against inc#39416
	retVal=await window.showModalDialog('../jsp/ItemGetRemarkPopup.jsp','','dialogHeight:36vh; dialogWidth: 39vw; center: 1; status: no; dialogTop :200;');
	if (!(retVal==null))
	{
		
		if(trimCheck(retVal))
			{
			
				parent.item_detail.document.item_master_form1.item_specification.value=retVal;
			}
	}

}



function makeManufMandatory()
{
	if(parent.item_class_detail.document.item_master_form2.sole_source_yn.checked==true){
		document.getElementById('span2').style.visibility="visible";
	}
	else{
		document.getElementById('span2').style.visibility="hidden";
	}

}

function searchItem(objCode,objDesc) {
	//alert("1");
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	argumentArray[0] = document.item_master_form1.SQL_MM_ITEM_LOOKUP.value;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "1,2";

	if(objDesc.readOnly) {
		argumentArray[5] = "";
	}
	else {
		argumentArray[5] = objDesc.value;
	}
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = DESC_CODE;
	returnedValues = CommonLookup(  getLabel("Common.item.label","Common"), argumentArray );

	if((returnedValues != null) && (returnedValues != "") ) {
		objCode.value = returnedValues[0];
		objDesc.value = returnedValues[1];
		objDesc.readOnly=true;		
		
	} 
}

function setBill_yn(obj){
	if(item_master_form1.billable_yn.checked==true)
			item_master_form1.billable_yn.value="Y";
	else
			item_master_form1.billable_yn.value="N";

	if(document.item_master_form1.billable_yn.checked==true)
	{
		if(document.item_master_form1.price_type_yn.value && document.getElementById('price_type'))
		{
			document.getElementById('price_type').disabled = false;
			document.getElementById('price_type').remove(2);
			document.getElementById('price_type').remove(1);
			document.getElementById('price_type').remove(0);

			var option = document.createElement("OPTION");
			option.text = getLabel("eMM.BatchPrice.label", "MM");
			option.value = "B";
			document.getElementById('price_type').add(option, 0);	

			var element1 = document.createElement("OPTION");
			element1.text = getLabel("eMM.GlobalPrice.label", "MM");
			element1.value = "G";
			document.getElementById('price_type').add(element1, 1);


		} // else nothing 
	} else
	{
		if(document.item_master_form1.price_type_yn.value  && document.getElementById('price_type'))
		{
			document.getElementById('price_type').disabled = true;
			document.getElementById('price_type').remove(2);
			document.getElementById('price_type').remove(1);
			document.getElementById('price_type').remove(0);

			var option = document.createElement("OPTION");
			option.text =  "-----"+getLabel("Common.defaultSelect.label", "Common")+"-----";//"---Select---";
			option.value = "";
			document.getElementById('price_type').add(option, 0);	
	
		} // else nothing 
	}
}


function CheckForSpecCharAlphaCode(Obj){
		
        var str = Obj.value;
        var specCharsExist = true;
        for (u=0;u<str.length;u++){
            if (((str.charCodeAt(u)>=48) && (str.charCodeAt(u)<=57))||((str.charCodeAt(u)>=65) && (str.charCodeAt(u)<=90))||((str.charCodeAt(u)>=97) && (str.charCodeAt(u)<=122))||(str.charCodeAt(u)==95)||(str.charCodeAt(u)==45)||(str.charCodeAt(u)==46));
            else{
                specCharsExist = false;
                break;
            }
        }

        if(!specCharsExist){
			Obj.focus();
		}
    }
	
function escapeRegExp(str) {
    return str.replace(/[*+?^${}()|[\]\\]/g, "\\$&");
}	
	
function CheckForSpecCharAlphaCodeForDesc(Obj){
		
        var str = Obj.value;
        var specCharsExist = true;
        for (u=0;u<str.length;u++){
            if (((str.charCodeAt(u)>=48) && (str.charCodeAt(u)<=57))||((str.charCodeAt(u)>=65) && (str.charCodeAt(u)<=90))||((str.charCodeAt(u)>=97) && (str.charCodeAt(u)<=122))||(str.charCodeAt(u)==95)||(str.charCodeAt(u)==45)||(str.charCodeAt(u)==46)||(str.charCodeAt(u)==32) ||(str.charCodeAt(u)==9)||(str.charCodeAt(u)==11));
            else{
                //specCharsExist = false;
				str = str.replace(new RegExp(escapeRegExp(str.charAt(u)), 'g'), '');
				Obj.value=str;
            }
        }

        if(!specCharsExist){
			Obj.focus();
		}
    }	
// Modified by lakshmanan for ML-MMOH-SCF-2521 on 01-11-2023 start
// 73000 start 
/* function KeyPressSpecCharsItemDescCode(event){
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if(key=='`' || key=='~'){
    	return false;
    }
    else{
    	return true;
    }
} */ //73000 end 
function KeyPressSpecCharsItemDescCode(event){
	var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-._ ';
    var whichCode = (window.Event) ? event.which : event.keyCode;

	key = String.fromCharCode(whichCode);  // Get key value from key code
	
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	/*if( (event.keyCode >= 97) && (event.keyCode <= 122) )
		return (event.keyCode -= 32);*/
	return true ;
  
}
// Modified by lakshmanan for ML-MMOH-SCF-2521 on 01-11-2023 end
function KeyPressSpecCharsAlphaCode(event){
	var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-._';
    var whichCode = (window.Event) ? event.which : event.keyCode;

	key = String.fromCharCode(whichCode);  // Get key value from key code
	
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
		return (event.keyCode -= 32);
	return true ;
  
}

function KeyPressSpecCharsItemCode(event){
	var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-.*_';
    var whichCode = (window.Event) ? event.which : event.keyCode;

	key = String.fromCharCode(whichCode);  // Get key value from key code
	
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
		return (event.keyCode -= 32);
	return true ;
  
}
//Added for AMS-CRF-0127 Starting	
function KeyPressSpecCharsHSNCode(event){
	var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ';
    var whichCode = (window.Event) ? event.which : event.keyCode;

	key = String.fromCharCode(whichCode);  // Get key value from key code
	
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
    if( (event.keyCode >= 97) && (event.keyCode <= 122) )
		return (event.keyCode -= 32);
    return true ;
  
}

//Added for AMS-CRF-0127 Ending

async function view_similar_items(obj){
	retVal=await window.showModalDialog("../jsp/ItemQueryResultFrame.jsp?from_query_or_create="+document.forms[0].from_query_or_create.value+"&short_desc="+obj.value,'','dialogHeight:900vh; dialogWidth: 800vw; center: 1; status: no; dialogTop :170;dialogLeft :120; scroll : auto;');	 

}
function closeMe()
	{
		if(SPCheckMaxLen( getLabel("eMM.ItemSpecification.label","MM"),document.formRemark.remark,4000))
		{
			var frmObject=document.formRemark;
			bean_id = frmObject.bean_id.value;
			bean_name = frmObject.bean_name.value;
			xmlDom = "";
			xmlHttp = new XMLHttpRequest();
			var xmlStr ="<root><SEARCH "+frmObject.remark.name+"=\""+checkSpl(frmObject.remark.value)+"\"/></root>";
			xmlDom = new DOMParser().parseFromString(xmlStr, "text/xml");

			xmlHttp.open("POST", "../../eMM/jsp/ItemValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name, false);
			xmlHttp.send(xmlDom);//anbarasi
			//alert(document.formRemark.remark.value.length);
		var	responseText=xmlHttp.responseText;
			var responseText = trimString(responseText);
			eval(responseText);
			
			window.close();
		}
	}
function enableReimburse(obj){
	if(obj.checked==true){
		document.getElementById('reimburse_type').disabled = false;
		document.getElementById('reimburse_type').remove(2);
		document.getElementById('reimburse_type').remove(1);
		document.getElementById('reimburse_type').remove(0);
		var element1 = document.createElement("OPTION");
		element1.text = getLabel("eMM.PartialReimbursable.label", "MM");
		element1.value = "P";
		document.getElementById('reimburse_type').add(element1, 0);
		var element2 = document.createElement("OPTION");
		element2.text = getLabel("eMM.FullyReimbursable.label", "MM");
		element2.value = "F";
		document.getElementById('reimburse_type').add(element2, 1);
		document.getElementById('reimburse_type').options[0].selected = true;
	}
	else{
		document.getElementById('reimburse_type').disabled = true;
		document.getElementById('reimburse_type').remove(2);
		document.getElementById('reimburse_type').remove(1);
		document.getElementById('reimburse_type').remove(0);
		var element1 = document.createElement("OPTION");
		element1.text = getLabel("Common.notapplicable.label", "common");
		element1.value = "N";
		document.getElementById('reimburse_type').add(element1, 0);
	}
}
// Added The Function To Restrict the User To paste Only Prescribed No Of  Characters 12/14/2009 -- Rams SCF NO -- 17111
function checkMaxLengthPaste(obj,maxlength)
{


                var len; 
                var txt = clipboardData.getData("Text"); 
                txt = obj.value + txt 
                len = parseInt(txt.length); 
                if ( len >  maxlength ) 
                { 
                        event.returnValue=false; 
                        txt = txt.substring(0, maxlength);                
                        obj.value = txt;                           
                        
                } 
          
    
}
//Added for GHL-CRF-0456 starts
function checkDirectSalesAllowed(obj){
	if(obj.checked == false && document.getElementById('direct_sale_allow_yn').value== "true"){
		alert(getMessage("DIRECT_SALES_NOT_ALLOWED","MM"));
		obj.checked = true;
		obj.value = "Y";
	}
}
//Added for GHL-CRF-0456 ends
//Added for GHL-CRF-0405 starts
function checkItemIsEmpty(obj){
	if(obj.checked == false && document.getElementById('stock_is_available').value== "true"){
		alert(getMessage("STOCK_IN_HAND","MM"));
		obj.checked = false;
		obj.value = "Y";
	}
}
//Added for GHL-CRF-0405 ends


//Added for GHL-CRF-0549.1 starts
function checkItemTypeLowCost(obj){ 
	
	if(obj.checked == true){
		obj.value = "Y";
		document.item_master_form1.lowcost_item.value= 'Y';
	}
	else{
		obj.value= "N";
		document.item_master_form1.lowcost_item.value= 'N';
	}
	
}
function checkItemTypeHighCost(obj){
	
	if(obj.checked == true){
		obj.value = "Y";
		document.item_master_form1.highcost_item.value = 'Y';
	}
	else{
		obj.value= "N";
		document.item_master_form1.highcost_item.value = 'N';
	}
	
}
function checkItemTypeInnovator(obj){

	if(obj.checked == true){
		obj.value = "Y";
		document.item_master_form1.innovator_item.value = 'Y';
	}
	else{
		obj.value= "N";
		document.item_master_form1.innovator_item.value = 'N';
	}
	
}
//Added for GHL-CRF-0459.1 ends
//Added for MMS-DM-CRF-0209 starts
//Added the Function To enable Alternate drop-down when Brand is selected in category --MMS-DM-CRF-0209.2 
function enableAlternate(obj) {
	if (obj != null) {
		var temp = obj.value;
		// alert(temp);
		if (obj.value == 'B') {
			document.getElementById('alternate_id').disabled = false;
			document.getElementById('span3').style.visibility = "visible";
		} else {
			document.getElementById('alternate_id').value = '';
			document.getElementById('alternate_id').disabled = true;
			document.getElementById('span3').style.visibility = "hidden";
		}
		if (temp != null) {
			document.item_master_form1.category_code1.value = temp;
		}
	}
}
//Added for MMS-DM-CRF-0209 ends
