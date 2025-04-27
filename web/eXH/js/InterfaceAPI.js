//********************************************************************************************
//FUNCTION CREATE
//********************************************************************************************
function create()
{
		//window.commontoolbarFrame.document.forms[0].apply.style.display='block';
		InterfaceAPIframeset.rows="30,110,310,30";
		window.f_query_add_mod.location.href="../../eXH/jsp/InterfaceAPISelectMaster.jsp?mode=I";		
		window.f_query_add_mod_detail.location.href="../../eCommon/html/blank.html";
		window.messageFrame.location.href="../../eCommon/html/blank.html";

}
//********************************************************************************************
//FUNCTION QUERY
//********************************************************************************************
function query()
{
		InterfaceAPIframeset.rows="30,320,80,30";
		window.f_query_add_mod.location.href="../../eXH/jsp/InterfaceAPIQueryCriteria.jsp";		
		window.f_query_add_mod_detail.location.href="../../eCommon/html/blank.html";
		window.messageFrame.location.href="../../eCommon/html/blank.html";

}
//********************************************************************************************
//FUNCTION DELETE
//********************************************************************************************
function deleterecord()
{
		if(frames[2].document.InterfaceAPIdetails_setup_form){
				window.f_query_add_mod_detail.document.forms[0].act_mode.value='D';
				apply();
		}			
		else if(frames[1].document.InterfaceAPI_setup_form){
				window.f_query_add_mod.document.forms[0].act_mode.value='D';
				apply();
		}

}
//********************************************************************************************
//FUNCTION APPLY()
//********************************************************************************************
function apply()
{
	if(frames[2].document.InterfaceAPIdetails_setup_form){
		if(frames[2].document.forms[0].act_mode.value=='D'){
				window.f_query_add_mod_detail.document.forms[0].action = '../../servlet/eXH.InterfaceAPIDetailsAddModifyServlet';
				window.f_query_add_mod_detail.document.forms[0].submit();			
		}

		else {

			var fields = new Array (  
				 frames[2].document.forms[0].arg_id, 
				 frames[2].document.forms[0].arg_name,
				 frames[2].document.forms[0].standard_desc);

			var names = new Array ( 

				getLabel("eXH.ArgID.Label","XH"),					
				getLabel("eXH.ArgName.Label","XH"),
				getLabel("Common.Standard.label","Common"));
 
//			if(!f_query_add_mod_detail.checkFieldsofMst( fields, names, messageFrame))
			if(!f_query_add_mod.checkFields( fields, names, messageFrame))
			{
   
			}else
			{  
				var api_code = frames[1].document.forms[0].api_code.value;
				window.f_query_add_mod_detail.document.forms[0].action = '../../servlet/eXH.InterfaceAPIDetailsAddModifyServlet?api_code='+api_code;
				window.f_query_add_mod_detail.document.forms[0].submit();	
				if(window.f_query_add_mod_detail.document.forms[0].act_mode.value=='I'){
					window.f_query_add_mod_detail.document.forms[0].reset();
				}
			}
		}
	} // end of if

	else if(frames[1].document.InterfaceAPI_setup_form){
			if(frames[1].document.forms[0].act_mode.value=='D'){
				frames[1].document.forms[0].submit();			
			}
			else {
			var fields = new Array ( 					    
						  frames[1].document.forms[0].api_code,
					      frames[1].document.forms[0].api_desc,
					      frames[1].document.forms[0].api_type,
					      frames[1].document.forms[0].exec_nature);

			var names = new Array ( 
						getLabel("Common.code.label","Common"),
						getLabel("Common.description.label","Common"),
						getLabel("eXH.APIType.Label","XH"),
						getLabel("eXH.ExecNature.Label","XH"));

			if(!f_query_add_mod.checkFields( fields, names, messageFrame))
			{

			}else
			{
					window.f_query_add_mod.document.forms[0].submit();	
					if(	window.f_query_add_mod.document.forms[0].act_mode.value=='I'){
						window.f_query_add_mod.document.forms[0].reset();
					}
			}
		}
		} // end of if


window.commontoolbarFrame.document.location.reload();
}

//********************************************************************************************
//function funSearch
//*******************************************************************************************
function funSearch()
{
	parent.InterfaceAPIframeset.rows="30,110,310,30";
	if(parent.frames[1].document.InterfaceAPI_setup_form){
		apicode = parent.frames[1].document.InterfaceAPI_setup_form.api_code.value;
	}
	parent.f_query_add_mod_detail.location.href="../../eXH/jsp/InterfaceAPIDetailsQueryResult.jsp?apicode="+apicode;	
    parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp";
}

//********************************************************************************************
//function funAdd
//*******************************************************************************************
function funAdd()
{
	parent.InterfaceAPIframeset.rows="30,110,310,30";
	var api_code = document.forms[0].api_code.value;
	parent.f_query_add_mod_detail.location.href='../../eXH/jsp/InterfaceAPIDetailsAddModify.jsp?mode=I&api_code='+api_code;	
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
//function funSubmit
//*******************************************************************************************
function funSubmit()
{
	// #MOD#01
	var act = "";
	if(document.forms[0].name=='INTERFACEAPI_RESULTS'){
//		   alert("INTERFACEAPI_RESULTS");
			act = '../../eXH/jsp/InterfaceAPIQueryResult.jsp';
	}
	else if(document.forms[0].name=='INTERFACEAPIDTL_RESULTS'){
//		    alert("INTERFACEAPIDTL_RESULTS");
			act = '../../eXH/jsp/InterfaceAPIDetailsQueryResult.jsp';
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

	if(this.document.forms[0].name=='INTERFACEAPI_RESULTS'){
		this.document.forms[0].api_code.value = obj.getAttribute('api_code');
		this.document.forms[0].api_desc.value = obj.getAttribute('api_desc');
		this.document.forms[0].api_type.value = obj.getAttribute('api_type');
		this.document.forms[0].exec_nature.value = obj.getAttribute('exec_nature');
		var act = '../../eXH/jsp/InterfaceAPISelectMaster.jsp';
	}
	
	else if(this.document.forms[0].name=='INTERFACEAPIDTL_RESULTS'){

		parent.frames[1].document.forms[0].api_code.value = obj.getAttribute('api_code');
		parent.frames[1].document.forms[0].api_desc.value = obj.getAttribute('api_desc');
		parent.frames[1].document.forms[0].api_type.value = obj.getAttribute('api_type');
//		parent.frames[1].document.forms[0].exec_nature.value = obj.getAttribute('exec_nature');

		parent.frames[1].document.forms[0].api_code.readOnly=true;
		parent.frames[1].document.forms[0].api_desc.readOnly=true;
		parent.frames[1].document.forms[0].api_type.disabled=true;
		parent.frames[1].document.forms[0].exec_nature.disabled=true;

		this.document.forms[0].api_code.value = obj.getAttribute('api_code');
		this.document.forms[0].srl_no.value = obj.getAttribute('srl_no');
		this.document.forms[0].arg_id.value = obj.getAttribute('arg_id');
		this.document.forms[0].arg_name.value = obj.getAttribute('arg_name');

		this.document.forms[0].stnd_code.value = obj.getAttribute('stnd_code');
		this.document.forms[0].stnd_desc.value = obj.getAttribute('stnd_desc');
		this.document.forms[0].sub_api.value = obj.getAttribute('sub_api');

		var act = '../../eXH/jsp/InterfaceAPIDetailsAddModify.jsp';
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
//function searchStandardCode
//*******************************************************************************************

function searchStandardCode(){
//     alert("searchStandardCode");
			var tdesc="";
            var tcode="";

            var retVal =new String();
            var argumentArray  = new Array() ;
            var dataNameArray  = new Array() ;
            var dataValueArray = new Array() ;
            var dataTypeArray  = new Array() ;
            var tit=	getLabel("Common.Standard.label","XH");
            var target=this.document.forms[0].stnd_desc;
            var dg_id=this.document.forms[0].stnd_code;

			sql="SELECT STANDARD_CODE code,STANDARD_DESC description FROM XH_STANDARD "+
                    "   WHERE UPPER(STANDARD_CODE) LIKE UPPER(?) AND "+ 
                    "           UPPER(STANDARD_DESC) LIKE UPPER(?) "+
                    "           ORDER BY 1 ";

			dataNameArray[0]	= "STANDARD_CODE" ;
			dataValueArray[0]	= this.document.forms[0].stnd_code.value;
			dataTypeArray[0]	= STRING ;

            argumentArray[0] = sql;
            argumentArray[1] = dataNameArray ;
            argumentArray[2] = dataValueArray ;
            argumentArray[3] = dataTypeArray ;
//	        argumentArray[4] = "2,1";
			argumentArray[4] = "1,2";
            argumentArray[5] = target.value;
            argumentArray[6] = DESC_LINK  ;
            argumentArray[7] = DESC_CODE ;
         
            retVal = await CommonLookup( tit, argumentArray );
            if(retVal != null && retVal != "" ){
	            var ret1=unescape(retVal);
                arr=ret1.split(",");
                target.value=arr[1];
                dg_id.value=arr[0];
            }
            else{
                target.value=tdesc;
                dg_id.value=tcode;
            }
}// End of searchStandardCode
