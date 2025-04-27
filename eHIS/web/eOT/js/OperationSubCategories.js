/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
function create()
{
	var formObj = document.forms[0];
	var params = formObj.params.value;
	f_query_add_mod.location.href="../../eOT/jsp/OperationSubCategoriesAddModify.jsp?"+params+"&mode=insert";
}

function apply()
{
	var frm=f_query_add_mod.document.forms[0];
	//alert(f_query_add_mod.document.forms[0].mode.value)
	if(f_query_add_mod.document.forms[0].mode.value=="modify"){
	//alert('This Operation is not allowed Here==='+f_query_add_mod.document.forms[0].mode.value);
	//return;
	var fields = new Array (f_query_add_mod.document.forms[0].speciality_desc,f_query_add_mod.document.forms[0].oper_cat_desc,f_query_add_mod.document.forms[0].oper_sub_cat_code,f_query_add_mod.document.forms[0].long_desc);
	var speciality= getLabel("Common.speciality.label","Common");
	var category_value = getLabel("Common.category1.label","Common");
	var subCategory = getLabel("eOT.SubCategory.Label","OT");
	var longDescription = getLabel("Common.description.label","Common");
	var names = new Array (speciality,category_value,subCategory,longDescription);
	if(checkFieldsofMst( fields, names, messageFrame)) 
		{	
			frm.speciality_desc.disabled=false;
			frm.oper_cat_desc.disabled=false;
			frm.oper_sub_cat_code.disabled=false;
			f_query_add_mod.document.forms[0].submit();
		}
	//f_query_add_mod.document.forms[0].submit();
	//f_query_add_mod.location.reload();
}else{
	var fields = new Array (f_query_add_mod.document.forms[0].speciality_desc,f_query_add_mod.document.forms[0].oper_cat_desc,f_query_add_mod.document.forms[0].oper_sub_cat_code,f_query_add_mod.document.forms[0].long_desc);
	var speciality= getLabel("Common.speciality.label","Common");
	var category_value = getLabel("Common.category1.label","Common");
	var subCategory = getLabel("eOT.SubCategory.Label","OT");
	var longDescription = getLabel("Common.description.label","Common");
	var names = new Array (speciality,category_value,subCategory,longDescription);
	if(checkFieldsofMst( fields, names, messageFrame)) 
		{	
			f_query_add_mod.document.forms[0].submit();
		}
	}
}

function onSuccess()
{
	var formObj = document.forms[0];
	var params = formObj.params.value;
	if(f_query_add_mod.document.forms[0].mode.value=="insert") {
		f_query_add_mod.location.href="../../eOT/jsp/OperationSubCategoriesAddModify.jsp?"+params+"&mode=insert";
	}else {
       f_query_add_mod.location.reload();
	 }
}

/*function reset()
{
	f_query_add_mod.document.forms[0].reset();
}*/

function reset() {
	if(window.parent.parent.frames[2].frames[1].document.location.href.indexOf("OperationSubCategoriesAddModify.jsp") != -1){

			 if(f_query_add_mod.document.location.href.indexOf("OperationSubCategories.jsp") != -1)
				  return false;
			 else
				 f_query_add_mod.document.location.reload();

	}
	else if(window.parent.parent.frames[2].frames[1].document.location.href.indexOf("OperationSubCategoriesQueryCriteria.jsp") != -1)
	{
			 f_query_add_mod.document.forms[0].reset();
	}
}
function query()
{
	var formObj = document.forms[0];
	var params = formObj.params.value;
	//commontoolbarFrame.document.forms[0].apply.disabled=true; //Commented Against GHL-SCF-1519
	f_query_add_mod.location.href="../../eOT/jsp/OperationSubCategoriesQueryCriteria.jsp?"+params;
}
function setCheckValue()
{
	if(document.forms[0].status.checked==true)
		document.forms[0].status.value="E";
	else
		document.forms[0].status.value="D";
}


/*function callOper_sub_cat()
{
	var column_sizes = escape("60%,40%");               
	var column_descriptions = escape("Description,Code");
	var oper_group_code=document.forms[0].speciality_desc.value;
	
	var sql=escape("SELECT LONG_DESC OPER_CAT_DESC, OPER_CAT_CODE OPER_CAT_CODE FROM OT_OPER_CATEGORY WHERE OPER_GROUP_CODE ='"+oper_group_code+"' ");
	var title='Category Search';
	var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"sql="+sql;
	retVal=callDialog(param);
	var obj=document.forms[0];
	retVal=checkNull(retVal);
	var arr=new Array();
	if(retVal!='')
		{
			arr=retVal.split("::");
			document.forms[0].oper_cat_desc.value = arr[0];
			document.forms[0].oper_cat_code.value = arr[1];	
		}
	else
		{
			document.forms[0].oper_cat_desc.value = '';
			document.forms[0].oper_cat_code.value = '';
		}
}*/

function checkNull(retVal)
{
	if(retVal != null && retVal.length>0)		
		return retVal;
	else 
		return '';

}

async function callOper_sub_cat(obj,target){
	//var role_type=document.forms[0].role_type.value;
	//var tcode = obj.value;
	//var tdesc = target.value;
	var locale = document.forms[0].locale.value;
	var oper_group_code=document.forms[0].speciality_desc.value;
	var retVal =    new String();
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	//var tit="Category Search" ;
	var tit=getLabel("Common.category1.label","Common");
	var sql="SELECT GET_DESC('"+locale+"','OT_OPER_CATEGORY_LANG_VW','LONG_DESC','OPER_CAT_CODE',OPER_CAT_CODE) DESCRIPTION, OPER_CAT_CODE CODE FROM OT_OPER_CATEGORY WHERE OPER_GROUP_CODE ='"+oper_group_code+"' AND UPPER(LONG_DESC) LIKE UPPER(?) AND UPPER(OPER_CAT_CODE) LIKE UPPER(?) ORDER BY 1 ";
	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,1";
	argumentArray[5] = (target.value.toUpperCase());
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = DESC_CODE;
		
	retVal = await CommonLookup( tit, argumentArray );
	if(retVal != null && retVal != "" )
	{
		var ret1=unescape(retVal);
		arr=ret1.split(",");
		obj.value = arr[0];
		target.value=arr[1];
	}else{
		target.value="";
		obj.value="";
	}
 }
async function callDialog(param)
{
	var dialogTop			= "40";
	var dialogHeight		= "10";
	var dialogWidth			= "40";
	var features			= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no";
	var arguments			= "";
	retVal=await window.showModalDialog("../../eOT/jsp/OTGeneralSearchFrames.jsp?"+param,arguments,features);
	return retVal;
}
