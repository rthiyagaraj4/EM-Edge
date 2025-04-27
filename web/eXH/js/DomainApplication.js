 //********************************************************************************************
//FUNCTION CREATE
//********************************************************************************************
function create()
{ 
   /* var tabOptionVal = frames[1].document.forms[0].option.value;
    if(tabOptionVal=='domains'){
		frames[2].location.href="../../eXH/jsp/InterfaceModuleSelectMaster.jsp?mode=I";		
	}
    else if(tabOptionVal=='applications'){
		*/
		frames[2].location.href="../../eXH/jsp/ApplicationAddModifyMaster.jsp?mode=I";		
//	}
	window.messageFrame.location.href="../../eCommon/html/blank.html";
}
//********************************************************************************************
//FUNCTION QUERY
//********************************************************************************************
function query()
{

	/*if(frames[2].document.InterfaceMod_setup_form || frames[2].document.InterfaceModuleRslt ){
		//window.f_query_add_mod.location.href="../../eXH/jsp/InterfaceModuleQueryCriteria.jsp";		
	}
	else if (frames[2].document.Master_application_form || frames[2].document.ApplicationRslt){
		//window.f_query_add_mod.location.href="../../eXH/jsp/ApplicationAddModifyQueryCriteria.jsp";		
	}*/
	window.f_query_add_mod.location.href="../../eXH/jsp/ApplicationAddModifyQueryCriteria.jsp";	
	//window.f_query_add_mod.location.href="../../eXH/jsp/InterfaceAPIQueryCriteria.jsp";
		window.messageFrame.location.href="../../eCommon/html/blank.html";
}
//********************************************************************************************
//FUNCTION DELETE
//********************************************************************************************
function deleterecord()
{
		window.f_query_add_mod.document.forms[0].act_mode.value = 'D';
		apply();
}
//********************************************************************************************
//FUNCTION APPLY()
//********************************************************************************************
function apply()
{
	
  //  alert("mode : "+mode);
	//	Domains
		if(frames[2].document.InterfaceMod_setup_form){
			
			var mode = frames[2].document.forms[0].act_mode.value;
			if(mode=='D'){
				window.f_query_add_mod.document.forms[0].submit();
			}
			else{
		
			var fields = new Array (  
						  frames[2].document.forms[0].module_Name,
						  frames[2].document.forms[0].sub_module_id,
					      frames[2].document.forms[0].sub_module_desc);

			var names = new Array ("Interface Domain","Sub Domain","Description");
  
			if(!f_query_add_mod.checkFields( fields, names, messageFrame))			
			{
   
			}else
			{  
			
   			  window.f_query_add_mod.document.forms[0].submit();
				if(mode=='I'){
					window.f_query_add_mod.document.location.reload();
				}
			}
			}
		}
	
	//		Applications
	else if(frames[2].document.Master_application_form){

		var mode = frames[2].document.forms[0].act_mode.value;
	
		if(mode=='D'){
			frames[2].document.Master_application_form.submit();
         
//			window.f_query_add_mod.document.forms[0].submit();
		}
		else if(mode=='U'){
		var fields = new Array ( frames[2].document.forms[0].appl_id,
					      frames[2].document.forms[0].appl_name) ;
 /*  				      frames[2].document.forms[0].facility,
					      frames[2].document.forms[0].field_sep */

		var names = new Array (getLabel("Common.identification.label","common"),getLabel("Common.name.label","common"));
  /*					getLabel("Common.facility.label","Common"),
						getLabel("eXH.FieldSeparator.Label","XH")  */
		if(!f_query_add_mod.checkFields( fields, names, messageFrame))
//		if(!f_query_add_mod.checkFields( fields, names,parent.messageFrame))
		
		{
   
		}else
		{
			window.f_query_add_mod.document.forms[0].submit();
			//frames[2].document.forms[0].reset();
		
		

			frames[2].document.location.href='../../eXH/jsp/ApplicationAddModifyMaster.jsp?appl_id='+frames[2].document.forms[0].appl_id.value+'&appl_name='+frames[2].document.forms[0].appl_name.value+'&enabled='+frames[2].document.forms[0].in_use.value+'&lang_id='+frames[2].document.forms[0].lang_id.value+'&mode=U';
//			parent.f_query_add_mod.document.forms[0].submit();
		}
		
		
		}
		else
		{
            var fields = new Array ( frames[2].document.forms[0].appl_id,
					      frames[2].document.forms[0].appl_name) ;
 /*  				      frames[2].document.forms[0].facility,
					      frames[2].document.forms[0].field_sep */

		var names = new Array (getLabel("Common.identification.label","common"),getLabel("Common.name.label","common"));
  /*					getLabel("Common.facility.label","Common"),
						getLabel("eXH.FieldSeparator.Label","XH")  */
		if(!f_query_add_mod.checkFields( fields, names, messageFrame))
//		if(!f_query_add_mod.checkFields( fields, names,parent.messageFrame))
		
		{
   
		}else
		{
			window.f_query_add_mod.document.forms[0].submit();
//			parent.f_query_add_mod.document.forms[0].submit();
        window.frames[2].document.location.reload();
		}
		}



	}
	else
	{
	}
	window.commontoolbarFrame.document.location.reload();
//	parent.commontoolbarFrame.document.location.reload();
}
//********************************************************************************************
//FUNCTION RESET 
//********************************************************************************************
function reset()
{
	if(window.f_query_add_mod.document.forms[0])
    {
	 window.f_query_add_mod.document.forms[0].reset();
	}
}

//********************************************************************************************
//function onLoadMethod
//********************************************************************************************

function onLoadMethod()
{
	if (this.document.forms[0].act_mode.value=='I')
	{
	  this.document.forms[0].in_use.checked=true;
	}
}
//********************************************************************************************
//function validatecheckbox
//********************************************************************************************

function validatecheckbox(obj)
{
	if(obj.checked==true)
		obj.value="Y";
	else
		obj.value="N";
}
//********************************************************************************************
//function searchModuleName
//*******************************************************************************************

async function searchModuleName(){
			var tdesc="";
            var tcode="";

            var retVal =new String();
            var argumentArray  = new Array() ;
            var dataNameArray  = new Array() ;
            var dataValueArray = new Array() ;
            var dataTypeArray  = new Array() ;
   			var tit	= "Interface Domain";
            var target=this.document.forms[0].module_Name;
            var module_id=this.document.forms[0].module_Id;
        
			sql="SELECT distinct a.MODULE_ID code,b.MODULE_NAME description FROM SM_MODULES_FACILITY a,SM_MODULE b WHERE UPPER(a.MODULE_ID) LIKE UPPER(?) AND UPPER(b.MODULE_NAME) LIKE UPPER(?) AND a.OPERATIONAL_YN='Y' AND a.MODULE_ID=b.MODULE_ID AND MODULE_GROUP_ID ='XS'  ORDER BY 1 ";
			
	/*		if(module_id.value!=""){
				dataNameArray[0]	= "MODULE_ID" ;
				dataValueArray[0]	= module_id.value;
				dataTypeArray[0]	= STRING ;
			}
    */
            argumentArray[0] = sql;
            argumentArray[1] = dataNameArray ;
            argumentArray[2] = dataValueArray ;
            argumentArray[3] = dataTypeArray ;
		    argumentArray[4] = "1,2";
//		    argumentArray[4] = "2,1";
            argumentArray[5] = target.value;
            argumentArray[6] = DESC_LINK  ;
            argumentArray[7] = DESC_CODE ;
         
            retVal = await CommonLookup( tit, argumentArray );
            if(retVal != null && retVal != "" ){
	            var ret1=unescape(retVal);
                arr=ret1.split(",");
                target.value=arr[1];
                module_id.value=arr[0];
				this.document.forms[0].sub_module_id.value = arr[0];;
            }
            else{
                target.value=tdesc;
                module_id.value=tcode;
            }
}// End of searchModuleName

//********************************************************************************************
//function chkTables
//*******************************************************************************************
function chkTables(obj)
{
		var sub_domain	=	obj.value;
//		alert(sub_domain);
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		var xmlStr ="<root><SEARCH ";
		xmlStr += " base_unit=\""+sub_domain+"\"";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","InterfaceModuleValidateSubDmn.jsp?func_mode=chkTables",false);
		xmlHttp.send(xmlDoc);
//		alert(xmlHttp.responseText);
		eval(xmlHttp.responseText);			
}

//********************************************************************************************
//function chkTables
//*******************************************************************************************
function dispchkTables(cnt)
{
	alert("cnt : "+cnt);
    if(cnt==0){
		alert(getMessage("XH0058"));
		parent.frames[2].document.forms[0].sub_module_id.focus();
	}
/*	else{
		alert("dispchkTables");
	}*/
}
//********************************************************************************************
//function funSubmit
//*******************************************************************************************
function funSubmit()
{
	// #MOD#01
	if(this.document.forms[0].name=='ApplicationRslt'){
			var act = '../../eXH/jsp/ApplicationQueryResult.jsp';
	}
	else if(this.document.forms[0].name=='InterfaceModuleRslt'){
			var act = '../../eXH/jsp/InterfaceModuleQueryResult.jsp';
	}
	this.document.forms[0].action = act;
	this.document.forms[0].submit();
}
//*******************************************************************************************
//function funModify
//*******************************************************************************************

function funModify(obj)
{
	// #MOD#02
	parent.commontoolbarFrame.document.forms[0].apply.style.display='block';

	if(this.document.forms[0].name=='ApplicationRslt'){
		this.document.forms[0].appl_id.value = obj.getAttribute('appl_id');
		this.document.forms[0].appl_name.value = obj.getAttribute('appl_name');
//		this.document.forms[0].facility.value = obj.getAttribute('facility');
		this.document.forms[0].enabled.value = obj.getAttribute('enabled');
		this.document.forms[0].lang_id.value = obj.getAttribute('lang_id');
		var act = '../../eXH/jsp/ApplicationAddModifyMaster.jsp';
	}

	else if (this.document.forms[0].name=='InterfaceModuleRslt'){
		this.document.forms[0].module_Id.value = obj.getAttribute('module_Id');
		this.document.forms[0].module_Name.value = obj.getAttribute('module_Name');
		this.document.forms[0].sub_module_id.value = obj.getAttribute('sub_module_id');
		this.document.forms[0].sub_module_desc.value = obj.getAttribute('sub_module_desc');
	//	this.document.forms[0].lang_id.value = obj.getAttribute('lang_id');
		var act = '../../eXH/jsp/InterfaceModuleSelectMaster.jsp';
	}
	this.document.forms[0].action = act;
	this.document.forms[0].submit();
}
//*******************************************************************************************
//function funAction
//*******************************************************************************************

function funAction(typ)
{
	document.forms[0].action_type.value = typ;
	funSubmit();
}
//*******************************************************************************************
