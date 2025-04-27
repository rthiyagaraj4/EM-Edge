//********************************************************************************************
//FUNCTION CREATE
//********************************************************************************************
function create()
{
		//window.commontoolbarFrame.document.forms[0].apply.style.display='block';
		window.f_query_add_mod.location.href="../../eXH/jsp/InterfaceModuleSelectMaster.jsp?mode=I";		
		window.messageFrame.location.href="../../eCommon/html/blank.html";

}
//********************************************************************************************
//FUNCTION QUERY
//********************************************************************************************
function query()
{
		//window.commontoolbarFrame.document.forms[0].apply.style.display='none';
		window.f_query_add_mod.location.href="../../eXH/jsp/InterfaceModuleQueryCriteria.jsp";		
		window.messageFrame.location.href="../../eCommon/html/blank.html";

}
//********************************************************************************************
//FUNCTION DELETE
//********************************************************************************************
function deleterecord()
{
//		alert("Delete");
		window.f_query_add_mod.document.forms[0].act_mode.value = 'D';
//		if (confirm(getMessage("DELETE_RECORD"))){
//			alert("Conf Del ");
			apply();
//		}
}
//********************************************************************************************
//FUNCTION APPLY()
//********************************************************************************************
function apply()
{
	alert("apply");
	var mode = frames[1].document.forms[0].act_mode.value;

	var fields = new Array (  
						  frames[1].document.forms[0].module_Name,
						  frames[1].document.forms[0].sub_module_id,
					      frames[1].document.forms[0].sub_module_desc);

	var names = new Array ( 
						getLabel("eXH.InterfaceDomain.Label","XH"),
						getLabel("eXH.SubDomain.Label","XH"),
						getLabel("eXH.Description.Label","XH"));
  
	if(!f_query_add_mod.checkFieldsofMst( fields, names, messageFrame))
	{
   
	}else
		{  
   		    window.f_query_add_mod.document.forms[0].submit();
			if(mode=='I'){
				window.f_query_add_mod.document.forms[0].reset();
			}
		}


window.commontoolbarFrame.document.location.reload();
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
//function searchModuleName
//*******************************************************************************************

function searchModuleName(){
            alert("InterfaceModules srchMdls");
			var tdesc="";
            var tcode="";

            var retVal =new String();
            var argumentArray  = new Array() ;
            var dataNameArray  = new Array() ;
            var dataValueArray = new Array() ;
            var dataTypeArray  = new Array() ;
            var tit="Module " ;
            var target=this.document.forms[0].module_Name;
            var module_id=this.document.forms[0].module_Id;
        
//			sql="SELECT MODULE_ID code,MODULE_NAME description FROM SM_MODULE WHERE UPPER(MODULE_ID) LIKE UPPER(?) AND UPPER(MODULE_NAME) LIKE UPPER(?)  ORDER BY 1 ";

			sql="SELECT distinct a.MODULE_ID code,b.MODULE_NAME description FROM SM_MODULES_FACILITY a,SM_MODULE b WHERE UPPER(a.MODULE_ID) LIKE UPPER(?) AND UPPER(b.MODULE_NAME) LIKE UPPER(?) AND a.OPERATIONAL_YN='Y' AND a.MODULE_ID=b.MODULE_ID ORDER BY 1 ";
			
			dataNameArray[0]	= "MODULE_ID" ;
			dataValueArray[0]	= this.document.forms[0].module_Id.value;
			dataTypeArray[0]	= STRING ;

            argumentArray[0] = sql;
            argumentArray[1] = dataNameArray ;
            argumentArray[2] = dataValueArray ;
            argumentArray[3] = dataTypeArray ;
		    argumentArray[4] = "2,1";
            argumentArray[5] = target.value;
            argumentArray[6] = DESC_LINK  ;
            argumentArray[7] = DESC_CODE ;
         
            retVal = await CommonLookup( tit, argumentArray );
            if(retVal != null && retVal != "" ){
	            var ret1=unescape(retVal);
                arr=ret1.split(",");
                target.value=arr[1];
                module_id.value=arr[0];
            }
            else{
                target.value=tdesc;
                module_id.value=tcode;
            }
}// End of searchModuleName


//********************************************************************************************
//function funSubmit
//*******************************************************************************************
function funSubmit()
{
	// #MOD#01
	var act = '../../eXH/jsp/InterfaceModuleQueryResult.jsp';
	this.document.forms[0].action = act;
	this.document.forms[0].submit();
}
//*******************************************************************************************
//function funModify
//*******************************************************************************************

function funModify(obj)
{
	// #MOD#02
		alert("InterfaceModules funModify");
		alert("formNam : "+this.document.forms[0].name);
	parent.commontoolbarFrame.document.forms[0].apply.style.display='block';

	this.document.forms[0].module_Id.value = obj.getAttribute('module_Id');
	this.document.forms[0].module_Name.value = obj.getAttribute('module_Name');
	this.document.forms[0].sub_module_id.value = obj.getAttribute('sub_module_id');
	this.document.forms[0].sub_module_desc.value = obj.getAttribute('sub_module_desc');

	var act = '../../eXH/jsp/InterfaceModuleSelectMaster.jsp';
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
