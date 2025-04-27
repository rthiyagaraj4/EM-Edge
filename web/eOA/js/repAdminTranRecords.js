function reset() {
	parent.frames[2].f_query_add_mod.repAdminTranRecords.p_transaction_type.disabled=false;
	f_query_add_mod.document.repAdminTranRecords.reset() ;	
}

function run() 
{
	var trans_code=f_query_add_mod.document.repAdminTranRecords.p_fm_trn_type.value;
var fields = new Array( f_query_add_mod.document.repAdminTranRecords.p_fm_trn_type,f_query_add_mod.document.repAdminTranRecords.p_transaction_type,f_query_add_mod.document.repAdminTranRecords.p_fm_trn_date,
					f_query_add_mod.document.repAdminTranRecords.p_to_trn_date );

var names = new Array(getLabel("Common.transactiontype.label","Common"),getLabel("Common.Generate.label","Common")+" "+getLabel("Common.by.label","Common"),getLabel("eOA.ApptDateFrom.label","OA"), getLabel("eOA.ApptDateTo.label","OA"));
if(f_query_add_mod.checkFields( fields, names, messageFrame))
{
	if( f_query_add_mod.DateCompare_apply( f_query_add_mod.document.repAdminTranRecords.p_fm_trn_date, f_query_add_mod.document.repAdminTranRecords.p_to_trn_date)){
	 // if( f_query_add_mod.CheckString( getLabel("Common.transactiontype.label","Common"),f_query_add_mod.document.repAdminTranRecords.p_fm_trn_type, f_query_add_mod.document.repAdminTranRecords.p_to_trn_type, messageFrame )){
		if( f_query_add_mod.CheckString( getLabel("Common.locationcode.label","Common"),f_query_add_mod.document.repAdminTranRecords.p_fm_locn_code, f_query_add_mod.document.repAdminTranRecords.p_to_locn_code, messageFrame ) ) 
		{
			if( f_query_add_mod.CheckString( getLabel("Common.resourceid.label","Common"),f_query_add_mod.document.repAdminTranRecords.p_fm_pract_id, f_query_add_mod.document.repAdminTranRecords.p_to_pract_id, messageFrame ) ) 
			{
				if(trans_code=='TD'){
					f_query_add_mod.document.repAdminTranRecords.p_transaction_type.disabled=false;
				}
				f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
				f_query_add_mod.document.forms[0].target="messageFrame";
				f_query_add_mod.document.repAdminTranRecords.submit() ;
			 if(trans_code=='TD'){
				 f_query_add_mod.document.repAdminTranRecords.p_transaction_type.disabled=true;
			 }
			}
		}
	 // }
	}
	}	
}

function practValidate(Obj)
		{
	document.forms[0].P_RESOURCE_CLASS.value=Obj.value;
	document.forms[0].p_fm_pract_id.value='';
		document.forms[0].p_to_pract_id.value='';
		if(Obj.value=='')
		{

			document.forms[0].p_fm_pract_id.value='';
			document.forms[0].p_to_pract_id.value='';
			document.forms[0].p_fm_pract_id.disabled=true;
			document.forms[0].pract_id.disabled=true;
			document.forms[0].pract_id1.disabled=true;
			document.forms[0].p_to_pract_id.disabled=true;
		}
		else
			{
		document.forms[0].p_fm_pract_id.disabled=false;
			document.forms[0].p_to_pract_id.disabled=false;
		document.forms[0].pract_id.disabled=false;
		document.forms[0].pract_id1.disabled=false;
			}
					//alert(Obj.value);

		}
function getResource(Obj)
{
	var carelocn="";
	var resource1 = document.forms[0].p_resource_class1.value;
		var n=document.forms[0].fm_pract_type.options.length;
	for(var i=0;i<n;i++){
		document.forms[0].fm_pract_type.remove("clinic");
		document.forms[0].to_pract_type.remove("clinic");
		
	}
	
	var opt=document.createElement("OPTION");
	opt.text="----"+getLabel("Common.defaultSelect.label","Common")+"----";
	opt.value="";
	document.forms[0].fm_pract_type.add(opt);	
	var opt1=document.createElement("OPTION");
	opt1.text="----"+getLabel("Common.defaultSelect.label","Common")+"----";
	opt1.value="";
	document.forms[0].to_pract_type.add(opt1);	
	
if(!(resource1 == null || resource1 == ""))
{
	//alert("asd");
	var xmlDoc = ""
	var xmlHttp = new XMLHttpRequest()
	xmlStr ="<root><SEARCH resource1=\""+resource1+"\" steps='1' /></root>"
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
	xmlHttp.open("POST","../../eOA/jsp/ReportsServerSide.jsp",false)
	xmlHttp.send(xmlDoc)
	responseText=xmlHttp.responseText
	responseText = trimString(responseText)
	eval(responseText)
			//alert(responseText);

}
}


function enablepr(obj)
{
	document.forms[0].p_fm_pract_id.value='';
		
	
}
function enablepr1(obj)
{
	document.forms[0].p_to_pract_id.value='';
	
		
}
function changeVal(obj)
{
	document.forms[0].P_LOCATION_TYPE.value=obj.value;
	document.forms[0].p_fm_locn_code.value='';
	document.forms[0].p_to_locn_code.value='';
		}



			async function searchCode1(obj,target_code,target_desc)
				{


				var retVal =    new String();
				var argumentArray  = new Array() ;
				var dataNameArray  = new Array() ;
				var dataValueArray = new Array() ;
				var dataTypeArray  = new Array() ;
				var locale=document.forms[0].locale.value;
				var tit="";
				var sql="";

			var facilityid = document.forms[0].p_facility_id.value;
			var p_location_type1=document.forms[0].p_location_type1.value;
			var locale=document.forms[0].locale.value;

			if(obj.name=="locn" || obj.name=="p_fm_locn_code")
			{
				tit=getLabel("Common.Location.label","Common");
				sql="select clinic_code code, long_desc description from op_clinic_lang_vw where facility_id='"+facilityid+"' and level_of_care_ind = 'A' and language_id='"+locale+"' and CARE_LOCN_TYPE_IND=nvl('"+p_location_type1+"',CARE_LOCN_TYPE_IND) and upper(clinic_code) like upper(?) and upper(long_desc) like upper(?) order by 2";
				
			}
			
			if(obj.name=="locn1" || obj.name=="p_to_locn_code")
			{
				tit=getLabel("Common.Location.label","Common");
				sql="select clinic_code code, long_desc description from op_clinic_lang_vw where facility_id='"+facilityid+"' and level_of_care_ind = 'A'  and language_id='"+locale+"'  and CARE_LOCN_TYPE_IND=nvl('"+p_location_type1+"',CARE_LOCN_TYPE_IND) and upper(clinic_code) like upper(?) and upper(long_desc) like upper(?) order by 2";
				
			}

					
				argumentArray[0] = sql;
				argumentArray[1] = dataNameArray ;
				argumentArray[2] = dataValueArray ;
				argumentArray[3] = dataTypeArray ;
				argumentArray[4] = "1,2";
				argumentArray[5] = target_code.value;
				argumentArray[6] = CODE_LINK ;
				argumentArray[7] = CODE_DESC ;
				
				retVal = await CommonLookup( tit, argumentArray );
				if (retVal !=null && retVal !="")
				{
					var ret1=unescape(retVal);
					arr=ret1.split(",");
					target_desc.value=arr[1];
					target_code.value=arr[0];
				}else
				{
				target_desc.value="";
				target_code.value="";
				}
			
			}



function ValidateDate(obj)
{
	if(obj.value!="")
	{
	if(!validDateObj(obj,"DMY",localeName))
		{
			obj.value="";
			return ;
		}
	}
}


function DateCompare_apply(from,to)
{
	if(from.value!="" && to.value!="" )
		{
	
			if(isBefore(from.value,to.value,'DMY',localeName)==false)
				{
				var msg = getMessage('TO_DT_GR_EQ_FM_DT','SM');
				parent.frames[2].document.location.href='../../eCommon/jsp/error.jsp?err_num='+msg;
				to.value="";
				to.select();					
				return false;
			}
			else
				return true;
		}

}

function changeTransType(obj){
	if(obj.value=='TD'){
		parent.f_query_add_mod.repAdminTranRecords.p_transaction_type.value='ADTRDATE';
		parent.f_query_add_mod.repAdminTranRecords.p_transaction_type.disabled=true;
	}else{
		parent.f_query_add_mod.repAdminTranRecords.p_transaction_type.disabled=false;
		parent.f_query_add_mod.repAdminTranRecords.p_transaction_type.value='';
	}
}
