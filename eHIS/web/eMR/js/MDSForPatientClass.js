function create()
{
	f_query_add_mod.location.href = "../../eMR/jsp/addModifyMDSForPatientClass.jsp?mode=insert" ;
}

function query()
{
	f_query_add_mod.location.href="../../eMR/jsp/MDSForPatClassQueryCriteria.jsp";
}
function checkIsValidForProceed()
  {
     var url = f_query_add_mod.location.href;
     url = url.toLowerCase();
     if ( (url.indexOf("blank.html")==-1) && (url.indexOf("query")==-1) )
        return true;
    else
        return false;
	
  }
function apply()
{
	//Maheshwaran K added for the CRF: JD-CRF-0145 [IN:030011] as on 05/12/2013
	//Start
	var fields	;
	var names	;
	var dataset=f_query_add_mod.document.MDSForPatientClass_form.mds_code.value;
	//End
	if (! (checkIsValidForProceed()) )
    {
		messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
        return false;
    } 
	//Maheshwaran K added for the CRF: JD-CRF-0145 [IN:030011] as on 05/12/2013
	//Start
	if(dataset=='CHRT')
		{
		fields = new Array(f_query_add_mod.document.MDSForPatientClass_form.mds_code,f_query_add_mod.document.MDSForPatientClass_form.chart_desc);
		names = new Array(getLabel("eMR.MDS.label","MR"), getLabel("Common.Chart.label","Common"));
		}
	if(dataset=='CLIN')
		{
		fields = new Array(f_query_add_mod.document.MDSForPatientClass_form.mds_code,f_query_add_mod.document.MDSForPatientClass_form.note_type_desc);
		names = new Array(getLabel("eMR.MDS.label","MR"), getLabel("Common.NoteType.label","Common"));
		}	
	if(dataset=='ORDR')
		{
		fields = new Array(f_query_add_mod.document.MDSForPatientClass_form.mds_code,f_query_add_mod.document.MDSForPatientClass_form.order_category_id);
		names = new Array(getLabel("eMR.MDS.label","MR"), getLabel("Common.OrderCategory.label","Common"));
		}	
	if(dataset=='DIAG')
		{
		fields = new Array(f_query_add_mod.document.MDSForPatientClass_form.mds_code,f_query_add_mod.document.MDSForPatientClass_form.term_id);
		names = new Array(getLabel("eMR.MDS.label","MR"), getLabel("Common.TerminologySet.label","Common"));
		}
	//End
	if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame))
	{
		
			
		if(f_query_add_mod.document.forms[0].chk_ip_app.checked==false && f_query_add_mod.document.forms[0].chk_op_app.checked==false && f_query_add_mod.document.forms[0].chk_em_app.checked==false && f_query_add_mod.document.forms[0].chk_dc_app.checked==false)
		{
			messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+getMessage('MR_ATLEAST_PAT_CLASS','MR');
			
			commontoolbarFrame.location.reload();
			
			return;
			
		}	
		//Maheshwaran K commented for the CRF: JD-CRF-0145 [IN:030011] as on 05/12/2013
		//for(i=0;i<f_query_add_mod.document.MDSForPatientClass_form.elements.length;i++)
		//{
					//f_query_add_mod.document.MDSForPatientClass_form.elements[i].disabled = false;		
		//}
		//Maheshwaran K added for the CRF: JD-CRF-0145 [IN:030011] as on 05/12/2013
		//Start
		/*if(f_query_add_mod.document.forms[0].ip_principal_diag_yn.checked==true)
		f_query_add_mod.document.forms[0].ip_principal_diag_yn_hid.value='Y';
		else f_query_add_mod.document.forms[0].ip_principal_diag_yn_hid.value='N';
		if(f_query_add_mod.document.forms[0].op_principal_diag_yn.checked==true)
		f_query_add_mod.document.forms[0].op_principal_diag_yn_hid.value='Y';
		else f_query_add_mod.document.forms[0].op_principal_diag_yn_hid.value='N';
		if(f_query_add_mod.document.forms[0].em_principal_diag_yn.checked==true)
		f_query_add_mod.document.forms[0].em_principal_diag_yn_hid.value='Y';
		else f_query_add_mod.document.forms[0].em_principal_diag_yn_hid.value='N';
		if(f_query_add_mod.document.forms[0].dc_principal_diag_yn.checked==true)
		f_query_add_mod.document.forms[0].dc_principal_diag_yn_hid.value='Y';
		else f_query_add_mod.document.forms[0].dc_principal_diag_yn_hid.value='N';*/
		//End	
		if(f_query_add_mod.document.forms[0].chk_ip_app.checked==true)
		f_query_add_mod.document.forms[0].chk_ip_app_hid.value='Y';
		else f_query_add_mod.document.forms[0].chk_ip_app_hid.value='N';
		

		if(f_query_add_mod.document.forms[0].chk_ip_man.checked==true)
			f_query_add_mod.document.forms[0].chk_ip_man_hid.value='Y';
		else
			f_query_add_mod.document.forms[0].chk_ip_man_hid.value='N';

		if(f_query_add_mod.document.forms[0].chk_op_app.checked==true)
			f_query_add_mod.document.forms[0].chk_op_app_hid.value='Y';
		else
			f_query_add_mod.document.forms[0].chk_op_app_hid.value='N';

		if(f_query_add_mod.document.forms[0].chk_op_man.checked==true)
			f_query_add_mod.document.forms[0].chk_op_man_hid.value='Y';
		else
			f_query_add_mod.document.forms[0].chk_op_man_hid.value='N';

		if(f_query_add_mod.document.forms[0].chk_em_app.checked==true)
			f_query_add_mod.document.forms[0].chk_em_app_hid.value='Y';
		else
			f_query_add_mod.document.forms[0].chk_em_app_hid.value='N';

		if(f_query_add_mod.document.forms[0].chk_em_man.checked==true)
			f_query_add_mod.document.forms[0].chk_em_man_hid.value='Y';
		else
			f_query_add_mod.document.forms[0].chk_em_man_hid.value='N';

		if(f_query_add_mod.document.forms[0].chk_dc_app.checked==true)
			f_query_add_mod.document.forms[0].chk_dc_app_hid.value='Y';
		else
			f_query_add_mod.document.forms[0].chk_dc_app_hid.value='N';

		if(f_query_add_mod.document.forms[0].chk_dc_man.checked==true)
			f_query_add_mod.document.forms[0].chk_dc_man_hid.value='Y';
		else
			f_query_add_mod.document.forms[0].chk_dc_man_hid.value='N';

		f_query_add_mod.document.MDSForPatientClass_form.submit();
		 
		
	}
}
function reset()
{
	if(f_query_add_mod.document.forms[0])
		//f_query_add_mod.document.forms[0].reset();
		frames[1].location.reload();
}

 function onSuccess()
  {		
	
	frames[1].location.reload();
  }
//Maheshwaran K added for the CRF: JD-CRF-0145 [IN:030011] as on 05/12/2013 
//Start
function ResetValues(obj_name)
	{
	var arr = new Array();
	if(obj_name=='chk_ip_man')
	{arr[0] = "ip";}
	if(obj_name=='chk_op_man')
	{arr[0] = "op";}
	if(obj_name=='chk_em_man')
	{arr[0] = "em";}
	if(obj_name=='chk_dc_man')
	{arr[0] = "dc";}
	if(obj_name==undefined){
	arr[0] = "ip";
	arr[1] = "op";
	arr[2] = "em";
	arr[3] = "dc";}
	for(j=0; j< arr.length; j++) {
	//eval("document.forms[0]."+arr[j]+"_principal_diag_yn").checked=true;
	document.forms[0][arr[j] + "_principal_diag_yn"].disabled = true;
    document.forms[0][arr[j] + "_principal_diag_yn_hid"].value = 'N';
	//eval("document.forms[0].chk_"+arr[j]+"_man").checked=false;
	//eval("document.forms[0].chk_"+arr[j]+"_man").disabled=true;
	//eval("document.forms[0].chk_"+arr[j]+"_man").value='N';
	if(obj_name==undefined){
	
	document.forms[0]["chk_" + arr[j] + "_man"].checked = false;
	document.forms[0]["chk_" + arr[j] + "_man"].value = 'N';
	document.forms[0]["chk_" + arr[j] + "_app"].checked = false;
	document.forms[0]["chk_" + arr[j] + "_app"].value = 'N';
	document.forms[0][arr[j] + "_principal_diag_yn"].checked = false;
	document.forms[0][arr[j] + "_principal_diag_yn_hid"].value = 'N';
	document.forms[0]["chk_" + arr[j] + "_man"].disabled = true;
	}
	document.forms[0][arr[j] + "_stage"].selectedIndex = 0;
    document.forms[0][arr[j] + "_stage"].disabled = true;
	}
	}
function chk_app_enable(obj,man_obj)
	{
	if(obj.checked==true)
		{
		man_obj.disabled=false;
		obj.value='Y';
		}
	else if(obj.checked==false)
		{
		man_obj.disabled=true;
		man_obj.checked=false;
		obj.value='N';
		}
	chk_enable(man_obj);
	}
function chk_enable(obj,mode)
	{
	
	var dataset=document.forms[0].mds_code.value;
	if(mode!='modify'){
	ResetValues(obj.name);}
	if(obj.name=='chk_ip_man' && obj.checked==true)
		{					
		//document.forms[0].chk_ip_man.disabled=false;	
		document.forms[0].ip_stage.disabled=false;
		if(dataset=='DIAG')
			{
			document.forms[0].ip_principal_diag_yn.disabled=false;
			if(document.forms[0].ip_principal_diag_yn.checked==true)
			document.forms[0].ip_principal_diag_yn_hid.value='Y';
			if(document.forms[0].ip_principal_diag_yn.checked==false)
			document.forms[0].ip_principal_diag_yn_hid.value='N';
			}
		obj.value='Y';
		}
	else if(obj.name=='chk_ip_man' && obj.checked==false)
		{
		//document.forms[0].chk_ip_man.checked=false;
		obj.value='N';
	//	document.forms[0].chk_ip_man.disabled=true;		
		document.forms[0].ip_stage.disabled=true;
		if(dataset=='DIAG'){
		document.forms[0].ip_principal_diag_yn.disabled=true;
		document.forms[0].ip_principal_diag_yn.checked=false;
		if(document.forms[0].ip_principal_diag_yn.checked==true)
		document.forms[0].ip_principal_diag_yn_hid.value='Y';
		if(document.forms[0].ip_principal_diag_yn.checked==false)
		document.forms[0].ip_principal_diag_yn_hid.value='N';
		}
		}
	else if(obj.name=='chk_op_man' && obj.checked==true)
	{
	
	//	document.forms[0].chk_op_man.disabled=false;
		if(dataset=='DIAG'){
		document.forms[0].op_principal_diag_yn.disabled=false;
		if(document.forms[0].op_principal_diag_yn.checked==true)
		document.forms[0].op_principal_diag_yn_hid.value='Y';
		if(document.forms[0].op_principal_diag_yn.checked==false)
		document.forms[0].op_principal_diag_yn_hid.value='N';
		}
		obj.value='Y';					
	}
	else if(obj.name=='chk_op_man' && obj.checked==false)
	{
	//document.forms[0].chk_op_man.checked=false;
		obj.value='N';
		//document.forms[0].chk_op_man.disabled=true;		
		if(dataset=='DIAG'){
		document.forms[0].op_principal_diag_yn.checked=false;
		document.forms[0].op_principal_diag_yn.disabled=true;
		if(document.forms[0].op_principal_diag_yn.checked==true)
		document.forms[0].op_principal_diag_yn_hid.value='Y';
		if(document.forms[0].op_principal_diag_yn.checked==false)
		document.forms[0].op_principal_diag_yn_hid.value='N';
		}
			
	}
	else if(obj.name=='chk_em_man' && obj.checked==true)
	{
	
	//	document.forms[0].chk_em_man.disabled=false;
		if(dataset=='DIAG'){
		document.forms[0].em_principal_diag_yn.disabled=false;
		if(document.forms[0].em_principal_diag_yn.checked==true)
		document.forms[0].em_principal_diag_yn_hid.value='Y';
		if(document.forms[0].em_principal_diag_yn.checked==false)
		document.forms[0].em_principal_diag_yn.value='N';
		}
		obj.value='Y';
	}
	else if(obj.name=='chk_em_man' && obj.checked==false)
	{
	
		//document.forms[0].chk_em_man.checked=false;
		obj.value='N';
		//document.forms[0].chk_em_man.disabled=true;	
		if(dataset=='DIAG'){
		document.forms[0].em_principal_diag_yn.disabled=true;
		document.forms[0].em_principal_diag_yn.checked=false;
		if(document.forms[0].em_principal_diag_yn.checked==true)
		document.forms[0].em_principal_diag_yn_hid.value='Y';
		if(document.forms[0].em_principal_diag_yn.checked==false)
		document.forms[0].em_principal_diag_yn_hid.value='N';
		}
		
	}
	else if(obj.name=='chk_dc_man' && obj.checked==true)
	{
		//document.forms[0].chk_dc_man.disabled=false;
		document.forms[0].dc_stage.disabled=false;
		if(dataset=='DIAG'){
		document.forms[0].dc_principal_diag_yn.disabled=false;
		if(document.forms[0].dc_principal_diag_yn.checked==true)
		document.forms[0].dc_principal_diag_yn_hid.value='Y';
		if(document.forms[0].dc_principal_diag_yn.checked==false)
		document.forms[0].dc_principal_diag_yn_hid.value='N';
		}
											
		obj.value='Y';
	}
	else if(obj.name=='chk_dc_man' && obj.checked==false)
	{
		//document.forms[0].chk_dc_man.checked=false;
		obj.value='N';
		//document.forms[0].chk_dc_man.disabled=true;	
		document.forms[0].dc_stage.disabled=true;					
		if(dataset=='DIAG'){
		document.forms[0].dc_principal_diag_yn.disabled=true;
		document.forms[0].dc_principal_diag_yn.checked=false;
		if(document.forms[0].dc_principal_diag_yn.checked==true)
		document.forms[0].dc_principal_diag_yn_hid.value='Y';
		if(document.forms[0].dc_principal_diag_yn.checked==false)
		document.forms[0].dc_principal_diag_yn_hid.value='N';
		}
					
	}
}
//End
//Maheshwaran K added for the CRF: JD-CRF-0145 [IN:030011] as on 05/12/2013
//Start
function SearchMDSLookup(obj,obj_1)
	{
	if(obj.value == "") 
		{ 
		obj.value="";
		obj_1.value="";
		return;
		}
	GetValuesMDSLookup(obj,obj_1)
} 
async function GetValuesMDSLookup(obj,obj_1)
	{
	var retVal =    new String();
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var tit="";	
	if(document.forms[0].mds_code.value=='CHRT')
	tit=getLabel('Common.Chart.label','common_labels');
	if(document.forms[0].mds_code.value=='CLIN')
	tit=getLabel('Common.NoteType.label','common_labels');
	if(document.forms[0].mds_code.value=='DIAG')
	tit=getLabel('Common.TerminologySet.label','common_labels');
	if(document.forms[0].mds_code.value=='ORDR')
	tit=getLabel('Common.OrderCategory.label','common_labels');
	var mds_sql=document.forms[0].mds_source_sql.value;
	argumentArray[0] = mds_sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2";
	argumentArray[5] = obj.value;
	argumentArray[6] = DESC_LINK ;
	argumentArray[7] = DESC_CODE;	
	retVal = await CommonLookup( tit, argumentArray );
	if((retVal=="")||(retVal==null))
		{
		obj.value="";
		obj_1.value="";
		}
	if(retVal != null && retVal != "" )
		{
		var ret1=unescape(retVal);
		arr=ret1.split(",");
		obj.value=arr[1];					
		obj_1.value=arr[0];
		}
	}
function LoadDataSet(mode,patient_class)
	{
	if(patient_class=='IP')
		{
		document.getElementById('op_tr_id').style.display='none';	
		document.getElementById('em_tr_id').style.display='none';	
		document.getElementById('dc_tr_id').style.display='none';	
		}
	if(patient_class=='OP')
		{
		document.getElementById('ip_tr_id').style.display='none';	
		document.getElementById('em_tr_id').style.display='none';	
		document.getElementById('dc_tr_id').style.display='none';	
		}
	if(patient_class=='EM')
		{
		document.getElementById('ip_tr_id').style.display='none';	
		document.getElementById('op_tr_id').style.display='none';	
		document.getElementById('dc_tr_id').style.display='none';	
		}
	if(patient_class=='DC')
		{
		document.getElementById('ip_tr_id').style.display='none';	
		document.getElementById('op_tr_id').style.display='none';	
		document.getElementById('em_tr_id').style.display='none';	
		}
	if(mode=='modify'){
		document.forms[0].chart_desc.disabled=true;
		document.forms[0].note_type_desc.disabled=true;
		document.forms[0].order_category_id.disabled=true;
		document.forms[0].term_id.disabled=true;
		}
	var dataset=document.forms[0].mds_code.value;
	var dataset1=document.forms[0].mds_code;
	document.forms[0].mds_code.value=dataset;
	document.forms[0].mds_code.selected=true;
	if(mode!='modify'){
	document.forms[0].ip_stage.disabled=true;
	document.forms[0].dc_stage.disabled=true;
	document.forms[0].op_principal_diag_yn.disabled=true;
	document.forms[0].ip_principal_diag_yn.disabled=true;
	document.forms[0].em_principal_diag_yn.disabled=true;
	document.forms[0].dc_principal_diag_yn.disabled=true;
	}
	if(mode=='modify')
		{
		chk_enable(document.forms[0].chk_ip_man,mode);
		chk_enable(document.forms[0].chk_op_man,mode);
		chk_enable(document.forms[0].chk_dc_man,mode);
		chk_enable(document.forms[0].chk_em_man,mode);
		}
	LoadMinDataSubValues(dataset1,mode);
	}
function LoadMinDataSubValues(dataset,mode)
	{
	var dataset=dataset.value;
	if(mode!='modify'){
	document.forms[0].min_data.value=dataset;
	ResetValues();
	}
	
	if(dataset=='CHRT')
		{
		if(mode!='modify'){
		document.forms[0].chart_desc.value="";
		document.forms[0].chart_desc_1.value="";
		}
		if(document.getElementById('noteid').style.display=='') 
		document.getElementById('noteid').style.display='none';
		if(document.getElementById('diagnosisid').style.display=='') 
		document.getElementById('diagnosisid').style.display='none';
		if(document.getElementById('orderid').style.display=='') 
		document.getElementById('orderid').style.display='none';
		document.getElementById('chartid').style.display='';	
		document.getElementById('principal_diag_id').style.display='none';
		document.getElementById('ip_prin_diag_id').style.display='none';
		document.getElementById('op_prin_diag_id').style.display='none';
		document.getElementById('em_prin_diag_id').style.display='none';
		document.getElementById('dc_prin_diag_id').style.display='none';
		}
	else if(dataset=='CLIN')
		{
		if(mode!='modify'){
		document.forms[0].note_type_desc.value="";
		document.forms[0].note_type_desc_1.value="";
		}
		if(document.getElementById('chartid').style.display=='') 
		document.getElementById('chartid').style.display='none';
		if(document.getElementById('diagnosisid').style.display=='') 
		document.getElementById('diagnosisid').style.display='none';
		if(document.getElementById('orderid').style.display=='') 
		document.getElementById('orderid').style.display='none';
		document.getElementById('noteid').style.display='';
		document.getElementById('principal_diag_id').style.display='none';
		document.getElementById('ip_prin_diag_id').style.display='none';
		document.getElementById('op_prin_diag_id').style.display='none';
		document.getElementById('em_prin_diag_id').style.display='none';
		document.getElementById('dc_prin_diag_id').style.display='none';
		}	
	else  if(dataset=='ORDR')
		{
		if(mode!='modify'){
		document.forms[0].order_category_id.value="";
		document.forms[0].order_category_code.value="";
		}
		if(document.getElementById('diagnosisid').style.display=='') 
		document.getElementById('diagnosisid').style.display='none';
		if(document.getElementById('noteid').style.display=='') 
		document.getElementById('noteid').style.display='none';
		if(document.getElementById('chartid').style.display=='') 
		document.getElementById('chartid').style.display='none';
		document.getElementById('orderid').style.display='';
		document.getElementById('principal_diag_id').style.display='none';
		document.getElementById('ip_prin_diag_id').style.display='none';
		document.getElementById('op_prin_diag_id').style.display='none';
		document.getElementById('em_prin_diag_id').style.display='none';
		document.getElementById('dc_prin_diag_id').style.display='none';
		}
	else if(dataset=='DIAG')
		{
		if(mode!='modify'){
		document.forms[0].term_id.value="";
		document.forms[0].termset_code.value="";
		}
		if(document.getElementById('noteid').style.display=='') 
		document.getElementById('noteid').style.display='none';
		if(document.getElementById('chartid').style.display=='') 
		document.getElementById('chartid').style.display='none';
		if(document.getElementById('orderid').style.display=='') 
		document.getElementById('orderid').style.display='none';
		document.getElementById('diagnosisid').style.display='';
		document.getElementById('principal_diag_id').style.display='';
		document.getElementById('ip_prin_diag_id').style.display='';
		document.getElementById('op_prin_diag_id').style.display='';
		document.getElementById('em_prin_diag_id').style.display='';
		document.getElementById('dc_prin_diag_id').style.display='';
		}	
	
	var xmlDoc = ""
	var xmlHttp = new XMLHttpRequest()
	xmlStr ="<root><SEARCH MIN_DATA_SET=\""+dataset+"\"/></root>"
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
	xmlHttp.open("POST","MDSValidationForPatientClass.jsp",false)
	xmlHttp.send(xmlDoc)
	responseText=xmlHttp.responseText
	responseText = trimString(responseText)
	document.forms[0].mds_source_sql.value=responseText;
	}
function FocusFirstElementSub()
	{
    if(document.forms[0].elements[i].type!="hidden" && document.forms[0].elements[i].type!="password" && document.forms[0].elements[i].type!="button"  )
        {
         if( document.forms[0].elements[i].readOnly != true && document.forms[0].elements[i].disabled!=true)
            {	
			document.forms[0].mds_code.focus();
           }
          }
}		
function chkprindiag(chk_obj,chk_value)
	{
	if(chk_obj.checked==true)
	chk_value.value='Y';
	if(chk_obj.checked==false)
	chk_value.value='N';
	}
//End
