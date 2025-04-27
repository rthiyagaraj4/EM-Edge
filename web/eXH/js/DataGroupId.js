 //********************************************************************************************
//FUNCTION CREATE
//********************************************************************************************
function create()
{ 
	    //DataGroupIdframeset.rows="30,100,300,30";
	
	document.getElementById("commontoolbarFrame").style.height="7vh";
	document.getElementById("f_query_add_mod").style.height="59vh";
	document.getElementById("f_query_add_mod_detail").style.height="21vh";
	document.getElementById("messageFrame").style.height="8vh";
		
	window.f_query_add_mod.location.href="../../eXH/jsp/DataGroupSelectMaster.jsp?mode=I&rule=U";
	window.f_query_add_mod_detail.location.href="../../eCommon/html/blank.html";
	window.messageFrame.location.href="../../eCommon/html/blank.html";
}
//********************************************************************************************
//FUNCTION QUERY
//********************************************************************************************
function query()
{
	//DataGroupIdframeset.rows="30,360,80,30"; 
			
	document.getElementById("commontoolbarFrame").style.height="7vh";
	document.getElementById("f_query_add_mod").style.height="59vh";
	document.getElementById("f_query_add_mod_detail").style.height="21vh";
	document.getElementById("messageFrame").style.height="8vh";
	
	window.f_query_add_mod.location.href="../../eXH/jsp/DataGroupIdQueryCriteria.jsp";		
	window.f_query_add_mod_detail.location.href="../../eCommon/html/blank.html";
	window.messageFrame.location.href="../../eCommon/html/blank.html"; 
} 
//********************************************************************************************
//FUNCTION DELETE
//********************************************************************************************
function deleterecord()
{
	if(frames[2].document.Datagroupdetails_setup_form){
		window.f_query_add_mod_detail.document.forms[0].act_mode.value = 'D';
		apply();
	}			
	else if(frames[1].document.Datagroupsetup_form){
		window.f_query_add_mod.document.forms[0].act_mode.value = 'D';
		apply();
	}
}

//********************************************************************************************
//FUNCTION APPLY()
//********************************************************************************************
function apply()
{
	if(frames[2].document.Datagroupdetails_setup_form){
		var mode = frames[1].document.forms[0].act_mode.value;
			if(frames[2].document.forms[0].act_mode.value=='D'){
				frames[2].document.forms[0].submit();			
			}
			else {
			var fields = new Array (  
					      frames[2].document.forms[0].facility_name,
						  frames[2].document.forms[0].mesg_type,
					      frames[2].document.forms[0].event_type,
							  frames[2].document.forms[0].filter_rule_type);

			var names = new Array (getLabel("Common.facility.label","common"),getLabel("Common.MessageType.label","common"),getLabel("Common.EventType.label","common"),getLabel("eXH.FilterRules.Label","xh"));
  
			if(!f_query_add_mod.checkFields( fields, names, messageFrame))
			{
    
			}
			else{
				var dg_code = frames[1].document.forms[0].dg_code.value;
				var application_id = frames[1].document.forms[0].application_id.value;
				window.f_query_add_mod_detail.document.forms[0].action = "../../servlet/eXH.DataGroupDetailsAddModifyServlet?dg_code="+dg_code+"&application_id="+application_id;
				window.f_query_add_mod_detail.document.forms[0].submit();	
				if(window.f_query_add_mod_detail.document.forms[0].act_mode.value=='I'){

					window.f_query_add_mod_detail.document.forms[0].reset();
				}
				else
				{
					window.f_query_add_mod_detail.document.forms[0].event_name.value=window.f_query_add_mod_detail.document.forms[0].event_type.value;

					window.f_query_add_mod_detail.document.forms[0].target='';
					window.f_query_add_mod_detail.document.forms[0].action='../../eXH/jsp/DataGroupDetailsAddModify.jsp?mode=U&event_type='+window.f_query_add_mod_detail.document.forms[0].event_name.value;
					window.f_query_add_mod_detail.document.forms[0].submit();	

				}
			}
		}
	}

	else if(frames[1].document.Datagroupsetup_form){
		var mode = frames[1].document.forms[0].act_mode.value;
			if(frames[1].document.forms[0].act_mode.value=='D'){
				frames[1].document.forms[0].submit();			
			}
			else {
			var fields = new Array ( 
						  frames[1].document.forms[0].dg_code,
						  frames[1].document.forms[0].dg_desc,
						  frames[1].document.forms[0].standard_desc,
					      frames[1].document.forms[0].application_name,frames[1].document.forms[0].Communication_mode) ;				 
 var names = new Array (getLabel("Common.identification.label","common"),getLabel("Common.name.label","common"),getLabel("Common.Standard.label","common"),getLabel("Common.Application.label","common"),getLabel("eXH.CommMode.Label","XH"));
			/*var names = new Array (getLabel("Common.identification.label","common"),
				getLabel("Common.name.label","common"),
				getLabel("Common.Standard.label","common"),
				getLabel("Common.Application.label","common"),
				getLabel("XH.CommMode.Label","XH"));		*/  	  

			if(!f_query_add_mod.checkFields( fields, names, messageFrame))
			{
			}else{
				frames[1].document.forms[0].submit();	
				if(mode=='I'){
					window.f_query_add_mod.document.forms[0].reset();
				}
				else
				{
					frames[1].document.location.href='../../eXH/jsp/DataGroupSelectMaster.jsp?dg_code='+frames[1].document.forms[0].dg_code.value+'&dg_desc='+frames[1].document.forms[0].dg_desc.value+'&standard_code='+frames[1].document.forms[0].standard_code.value+'&standard_desc='+frames[1].document.forms[0].standard_desc.value+'&application_id='+frames[1].document.forms[0].application_id.value+'&application_name='+frames[1].document.forms[0].application_name.value+'&comm_mode='+frames[1].document.forms[0].comm_mode.value+'&mode=U&rule=R';


				}
			}
			}
	}
else
{
}
window.commontoolbarFrame.document.location.reload();

}
//********************************************************************************************
//FUNCTION RESET 
//********************************************************************************************
function reset()
{	
			if(frames[2].document.Datagroupdetails_setup_form){
				window.f_query_add_mod_detail.document.forms[0].reset();
			}			
			else if(frames[1].document.Datagroupsetup_form){
				 window.f_query_add_mod.document.forms[0].reset();
			}
}

//********************************************************************************************
//function funAdd
//*******************************************************************************************
function funAdd()
{  
	//parent.DataGroupIdframeset.rows="30,120,280,30";

	var dg_code = document.forms[0].dg_code.value;

	var mode = parent.frames[1].document.forms[0].act_mode.value;
	//var dg_code = "";
	if(parent.frames[1].document.Datagroupsetup_form){

        var fields = new Array ( 
						  parent.frames[1].document.forms[0].dg_code,
						  parent.frames[1].document.forms[0].dg_desc,
						  parent.frames[1].document.forms[0].standard_desc,
					      parent.frames[1].document.forms[0].application_name,parent.frames[1].document.forms[0].Communication_mode) ;				

			var names = new Array (getLabel("Common.Standard.label","common"),getLabel("Common.name.label","common"),getLabel("Common.Standard.label","common"),getLabel("Common.Application.label","common"),getLabel("eXH.CommMode.Label","XH"));	 		

			if(!parent.f_query_add_mod.checkFields( fields, names, parent.messageFrame))
			{
			}else{
			 
// var index		= parent.frames[1].document.forms[0].Communication_mode.options.selectedIndex;
 	//	 var slctd_Col	= parent.frames[1].document.forms[0].Communication_mode.options[index].text;
	 var slctd_Col	= parent.frames[1].document.forms[0].Communication_mode.value;


if((parent.frames[1].document.forms[0].dg_desc.value==parent.frames[1].document.forms[0].dg_deschidden.value) && (parent.frames[1].document.forms[0].standard_desc.value==parent.frames[1].document.forms[0].standard_deschidden.value) && (parent.frames[1].document.forms[0].application_name.value==parent.frames[1].document.forms[0].application_namehidden.value) && (slctd_Col==parent.frames[1].document.forms[0].commode_deschidden.value)) 
{

} 
else
{
	var i=window.confirm("Do you want to save the changes?");

		if(i==true) 
		{
			parent.frames[1].document.forms[0].submit();	 
			if(mode=='I'){
			window.f_query_add_mod.document.forms[0].reset();
		     }
			 else
			{
				
				 parent.frames[1].document.location.href='../../eXH/jsp/DataGroupSelectMaster.jsp?dg_code='+parent.frames[1].document.forms[0].dg_code.value+'&dg_desc='+parent.frames[1].document.forms[0].dg_desc.value+'&standard_code='+parent.frames[1].document.forms[0].standard_code.value+'&standard_desc='+parent.frames[1].document.forms[0].standard_desc.value+'&application_id='+parent.frames[1].document.forms[0].application_id.value+'&application_name='+parent.frames[1].document.forms[0].application_name.value+'&comm_mode='+slctd_Col+'&mode=U&rule=R';
			}
			 
		}
	    else
		{
			
		parent.frames[1].document.location.href='../../eXH/jsp/DataGroupSelectMaster.jsp?dg_code='+parent.frames[1].document.forms[0].dg_code.value+'&dg_desc='+parent.frames[1].document.forms[0].dg_deschidden.value+'&standard_code='+parent.frames[1].document.forms[0].standard_code.value+'&standard_desc='+parent.frames[1].document.forms[0].standard_deschidden.value+'&application_id='+parent.frames[1].document.forms[0].application_id.value+'&application_name='+parent.frames[1].document.forms[0].application_namehidden.value+'&comm_mode='+parent.frames[1].document.forms[0].comm_mode.value+'&mode=U&rule=R';
		 
		}
	

}





	parent.f_query_add_mod_detail.location.href="../../eXH/jsp/DataGroupDetailsAddModify.jsp?mode=I&dg_code="+dg_code+"&comm_mode="+parent.frames[1].document.forms[0].Communication_mode.value;	
	parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp";
	parent.frames[1].document.forms[0].dg_code.disabled = true;
	parent.frames[1].document.forms[0].dg_desc.disabled = true;
	parent.frames[1].document.forms[0].standard_code.disabled = true;
	parent.frames[1].document.forms[0].standard_desc.disabled = true; 
	parent.frames[1].document.forms[0].standard_code_search.disabled = true; 	
	parent.frames[1].document.forms[0].application_id.disabled = true;
	parent.frames[1].document.forms[0].application_name.disabled = true;
	parent.frames[1].document.forms[0].ApplicationSearch.disabled = true; 
	parent.frames[1].document.forms[0].Communication_mode.disabled = true; 
			}
}
}
//********************************************************************************************
//function funNew
//*******************************************************************************************
function funNew()
{
	document.forms[0].detail_flag.value = 'N';
	parent.f_query_add_mod.location.href="../../eXH/jsp/DataGroupSelectMaster.jsp?mode=I";	
	parent.f_query_add_mod_detail.location.href="../../eCommon/html/blank.html";	
	
}
//********************************************************************************************
//function funSearch
//*******************************************************************************************
function funSearch()
{
	//parent.DataGroupIdframeset.rows="30,120,280,30";
	
	parent.document.getElementById("commontoolbarFrame").style.height="7vh";
	parent.document.getElementById("f_query_add_mod").style.height="30vh";
	parent.document.getElementById("f_query_add_mod_detail").style.height="55vh";
	parent.document.getElementById("messageFrame").style.height="8vh";

	var mode = parent.frames[1].document.forms[0].act_mode.value;
	var dg_code = "";
	if(parent.frames[1].document.Datagroupsetup_form){

        var fields = new Array ( 
						  parent.frames[1].document.forms[0].dg_code,
						  parent.frames[1].document.forms[0].dg_desc,
						  parent.frames[1].document.forms[0].standard_desc,
					      parent.frames[1].document.forms[0].application_name,parent.frames[1].document.forms[0].Communication_mode) ;				

			var names = new Array (getLabel("Common.Standard.label","common"),getLabel("Common.name.label","common"),getLabel("Common.Standard.label","common"),getLabel("Common.Application.label","common"),getLabel("eXH.CommMode.Label","XH"));	 		

			if(!parent.f_query_add_mod.checkFields( fields, names, parent.messageFrame))
			{
			}else{
			 
// var index		= parent.frames[1].document.forms[0].Communication_mode.options.selectedIndex;
 	//	 var slctd_Col	= parent.frames[1].document.forms[0].Communication_mode.options[index].text;
	 var slctd_Col	= parent.frames[1].document.forms[0].Communication_mode.value;


if((parent.frames[1].document.forms[0].dg_desc.value==parent.frames[1].document.forms[0].dg_deschidden.value) && (parent.frames[1].document.forms[0].standard_desc.value==parent.frames[1].document.forms[0].standard_deschidden.value) && (parent.frames[1].document.forms[0].application_name.value==parent.frames[1].document.forms[0].application_namehidden.value) && (slctd_Col==parent.frames[1].document.forms[0].commode_deschidden.value)) 
{

}
else
{
	var i=window.confirm("Do you want to save the changes?");

		if(i==true)
		{
			parent.frames[1].document.forms[0].submit();	 
			if(mode=='I'){
			window.f_query_add_mod.document.forms[0].reset();
		     }
			 else
			{
				
				 parent.frames[1].document.location.href='../../eXH/jsp/DataGroupSelectMaster.jsp?dg_code='+parent.frames[1].document.forms[0].dg_code.value+'&dg_desc='+parent.frames[1].document.forms[0].dg_desc.value+'&standard_code='+parent.frames[1].document.forms[0].standard_code.value+'&standard_desc='+parent.frames[1].document.forms[0].standard_desc.value+'&application_id='+parent.frames[1].document.forms[0].application_id.value+'&application_name='+parent.frames[1].document.forms[0].application_name.value+'&comm_mode='+slctd_Col+'&mode=U&rule=R';
			}
			 
		}
	    else
		{
			
		parent.frames[1].document.location.href='../../eXH/jsp/DataGroupSelectMaster.jsp?dg_code='+parent.frames[1].document.forms[0].dg_code.value+'&dg_desc='+parent.frames[1].document.forms[0].dg_deschidden.value+'&standard_code='+parent.frames[1].document.forms[0].standard_code.value+'&standard_desc='+parent.frames[1].document.forms[0].standard_deschidden.value+'&application_id='+parent.frames[1].document.forms[0].application_id.value+'&application_name='+parent.frames[1].document.forms[0].application_namehidden.value+'&comm_mode='+parent.frames[1].document.forms[0].comm_mode.value+'&mode=U&rule=R';
		 
		}
	

}



    dgcode = parent.frames[1].document.Datagroupsetup_form.dg_code.value;
	parent.f_query_add_mod_detail.location.href="../../eXH/jsp/DataGroupDetailsQueryResult.jsp?dgcode="+dgcode;	
	parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp";

//parent.frames[1].document.location.reload();



	parent.frames[1].document.forms[0].dg_code.disabled = true;
	parent.frames[1].document.forms[0].dg_desc.disabled = true;
	parent.frames[1].document.forms[0].standard_code.disabled = true;
	parent.frames[1].document.forms[0].standard_desc.disabled = true; 
	parent.frames[1].document.forms[0].standard_code_search.disabled = true; 	
	parent.frames[1].document.forms[0].application_id.disabled = true;
	parent.frames[1].document.forms[0].application_name.disabled = true;
	parent.frames[1].document.forms[0].ApplicationSearch.disabled = true; 
	parent.frames[1].document.forms[0].Communication_mode.disabled = true; 





			
			}
		
	}
	
    

}

//********************************************************************************************
//function searchApplication
//*******************************************************************************************
function dispmode()
{
 parent.frames[1].document.forms[0].dg_code.disabled = true;
	parent.frames[1].document.forms[0].dg_desc.disabled = true;
	parent.frames[1].document.forms[0].standard_code.disabled = true;
	parent.frames[1].document.forms[0].standard_desc.disabled = true; 
	parent.frames[1].document.forms[0].standard_code_search.disabled = true; 	
	parent.frames[1].document.forms[0].application_id.disabled = true;
	parent.frames[1].document.forms[0].application_name.disabled = true;
	parent.frames[1].document.forms[0].ApplicationSearch.disabled = true; 
	parent.frames[1].document.forms[0].Communication_mode.disabled = true;
}
async function searchApplication(){
	//	if(document.forms[0].ApplicationSearch.disabled)
	//{
			this.document.forms[0].application_name.value='';
			this.document.forms[0].application_id
	//}
	//else
	//{
            var tdesc="";
            var tcode="";

            var retVal =new String();
            var argumentArray  = new Array() ;
            var dataNameArray  = new Array() ;
            var dataValueArray = new Array() ;
            var dataTypeArray  = new Array() ;
            var tit=getLabel("Common.Application.label","common");
			
            var target=this.document.forms[0].application_name;
            var appl_id=this.document.forms[0].application_id;

			sql="SELECT application_id code,application_name description FROM XH_APPLICATION "+
                    "   WHERE UPPER(application_id) LIKE UPPER(?) AND "+ 
                    "           UPPER(application_name) LIKE UPPER(?) "+
                    "           ORDER BY 1 ";
/*
			if(appl_id.value!=""){
				dataNameArray[0]	= "APPLICATION_ID" ;
				dataValueArray[0]	= appl_id.value;
				dataTypeArray[0]	= STRING ;
			}
			*/
            argumentArray[0] = sql;
            argumentArray[1] = dataNameArray ;
            argumentArray[2] = dataValueArray ;
            argumentArray[3] = dataTypeArray ;
	//        argumentArray[4] = "2,1";
	        argumentArray[4] = "1,2";
            argumentArray[5] = target.value;
            argumentArray[6] = DESC_LINK  ;
            argumentArray[7] = DESC_CODE ;
         
            retVal = await CommonLookup( tit, argumentArray );
            if(retVal != null && retVal != "" ){
	            var ret1=unescape(retVal);
                arr=ret1.split(",");
                target.value=arr[1];
                appl_id.value=arr[0];
            }
            else{
                target.value=tdesc;
                appl_id.value=tcode;
           }
	//}
}// End of searchApplication

//********************************************************************************************
//function searchStandardCode
//*******************************************************************************************

async function searchStandardCode(){
     
			var tdesc="";
            var tcode="";

            var retVal =new String();
            var argumentArray  = new Array() ;
            var dataNameArray  = new Array() ;
            var dataValueArray = new Array() ;
            var dataTypeArray  = new Array() ;
            var tit= getLabel("Common.Standard.label","common");
            var target=this.document.forms[0].standard_desc;
            var standard_code=this.document.forms[0].standard_code;
 
			sql="SELECT STANDARD_CODE code,STANDARD_DESC description FROM XH_STANDARD WHERE UPPER(STANDARD_CODE) LIKE UPPER(?) AND  UPPER(STANDARD_DESC) LIKE UPPER(?)  ORDER BY 1 ";
	/*		
			if(standard_code.value!=""){
				dataNameArray[0]	= "STANDARD_CODE" ;
				dataValueArray[0]	= standard_code.value;
				dataTypeArray[0]	= STRING ;
			}
			*/

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
                standard_code.value=arr[0];
            }
            else{
                target.value=tdesc;
                standard_code.value=tcode;
            }
}// End of searchStandardCode

//********************************************************************************************
//function searchFacility
//*******************************************************************************************

async function searchFacility(){
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
		//	sql="SELECT a.facility_id code,b.facility_name description FROM XH_PARAM_FOR_FACILITY a,  SM_FACILITY_PARAM_LANG_VW b WHERE a.facility_id=b.facility_id and UPPER(b.facility_id) LIKE UPPER(?) AND    UPPER(b.facility_name) LIKE UPPER(?) and b.language_id='en'  ORDER BY 1 ";
		//sql="SELECT a.facility_id code,b.facility_name description FROM XH_PARAM_FOR_FACILITY a,  SM_FACILITY_PARAM_LANG_VW b WHERE a.facility_id=b.facility_id and UPPER(b.facility_id) LIKE UPPER(?) AND    UPPER(b.facility_name) LIKE UPPER(?) and b.language_id='en'  ORDER BY 1 ";

			sql="SELECT X.FACILITY_ID code,X.FACILITY_NAME description FROM SM_FACILITY_PARAM_LANG_VW X,XH_PARAM_FOR_FACILITY Y,SM_MODULES_FACILITY Z WHERE  X.LANGUAGE_ID='"+locale+"' AND Z.MODULE_ID='XH' AND Z.OPERATIONAL_YN='Y' AND X.FACILITY_ID=Y.FACILITY_ID AND X.FACILITY_ID=Z.FACILITY_ID and UPPER(X.FACILITY_ID) LIKE UPPER(?) AND    UPPER(X.FACILITY_NAME) LIKE UPPER(?)   ORDER BY 1";
/*
			if(faclty_id.value!=""){
				dataNameArray[0]	= "FACILITY_ID" ;
				dataValueArray[0]	= faclty_id.value;
				dataTypeArray[0]	= STRING ;
			} */
 
			argumentArray[0] = sql;
            argumentArray[1] = dataNameArray ;
            argumentArray[2] = dataValueArray ;
            argumentArray[3] = dataTypeArray ;
	        argumentArray[4] = "1,2";
//			argumentArray[4] = "2,1";
            argumentArray[5] = target.value;
            argumentArray[6] = DESC_LINK  ;
            argumentArray[7] = DESC_CODE ;
         
            retVal = await CommonLookup( tit, argumentArray );
            if(retVal != null && retVal != "" ){
	            var ret1=unescape(retVal);
                arr=ret1.split(",");
                target.value=arr[1];
//				alert();
                faclty_id.value=arr[0];
            }
            else{
                target.value=tdesc;
                faclty_id.value=tcode;
            }
}// End of searchFacility

//********************************************************************************************
//function searchMessageType
//*******************************************************************************************

async function searchMessageType(){

	var obj=parent.frames[1].document.forms[0].comm_mode.value;

	var tdesc="";
    var tcode="";

    var retVal =new String();
    var argumentArray  = new Array() ;
    var dataNameArray  = new Array() ;
    var dataValueArray = new Array() ;
    var dataTypeArray  = new Array() ;
    var tit=getLabel("Common.MessageType.label","common");
    var target=this.document.forms[0].mesg_type;
    var mesg_id=this.document.forms[0].mesg_type_id;
		
	if(obj=='O')
	{
		 sql="SELECT DISTINCT a.message_type code,a.description description FROM xh_message_type a,XH_EVENT_TYPE b WHERE a.message_type=b.message_type and (b.communication_type='O' OR b.communication_type='*')  and UPPER(a.message_type) LIKE UPPER(?) AND  UPPER(a.description) LIKE UPPER(?)  ORDER BY 1 ";
	}
	else
	{
		 sql="SELECT DISTINCT a.message_type code,a.description description FROM xh_message_type a,XH_EVENT_TYPE b WHERE a.message_type=b.message_type and(b.communication_type='I' OR b.communication_type='*')  and UPPER(a.message_type) LIKE UPPER(?) AND  UPPER(a.description) LIKE UPPER(?)  ORDER BY 1 ";
	}
			
/*
			if(mesg_id.value!=""){
				dataNameArray[0]	= "MESSAGE_TYPE" ;
				dataValueArray[0]	= mesg_id.value;
				dataTypeArray[0]	= STRING ;
			} */

    argumentArray[0] = sql;
    argumentArray[1] = dataNameArray ;
    argumentArray[2] = dataValueArray ;
    argumentArray[3] = dataTypeArray ;
    argumentArray[4] = "1,2";
    //argumentArray[4] = "2,1";
    argumentArray[5] = target.value;
    argumentArray[6] = DESC_LINK  ;
    argumentArray[7] = DESC_CODE ;
         
    retVal = await CommonLookup( tit, argumentArray );
    if(retVal != null && retVal != "" ){
        var ret1=unescape(retVal);
        arr=ret1.split(",");
        target.value=arr[1];
        mesg_id.value=arr[0];
		this.document.forms[0].event_type.value='';
      		this.document.forms[0].event_type.disabled=false;
		this.document.forms[0].EventTypeSearch.disabled=false;
		
    }
    else{
        target.value=tdesc;
        mesg_id.value=tcode;
		this.document.forms[0].event_type.value='';
			this.document.forms[0].event_type.disabled=true;
		this.document.forms[0].EventTypeSearch.disabled=true;
    }
}// End of searchMessageType

//********************************************************************************************
//function searchEventType
//*******************************************************************************************

async function searchEventType(obj1){

     var obj=parent.frames[1].document.forms[0].comm_mode.value;
			var tdesc="";
            var tcode="";
          
            var retVal =new String();
            var argumentArray  = new Array() ;
            var dataNameArray  = new Array() ;
            var dataValueArray = new Array() ;
            var dataTypeArray  = new Array() ;
            var tit=getLabel("Common.EventType.label","common");
			
            var target=this.document.forms[0].event_type;
            var event_id=this.document.forms[0].event_type_id;
            var mesg_id=this.document.forms[0].mesg_type_id.value;


var application=parent.frames[1].document.forms[0].application_id.value;
//SELECT DISTINCT  b.EVENT_TYPE code,b.EVENT_NAME description FROM xh_message_type a,XH_EVENT_TYPE b WHERE a.message_type=b.message_type and (b.communication_type='O' OR b.communication_type='*') and a.message_type='"+obj1.value+"' and EVENT_TYPE  IN (SELECT EVENT_TYPE FROM    XH_APPLICATION_EVENT_TYPE WHERE APPLICATION_ID=  '"+application+"' ) and UPPER( b.EVENT_TYPE) LIKE UPPER(?) AND  UPPER(b.EVENT_NAME) LIKE UPPER(?)  ORDER BY 1;

			 if(obj=='O')
			{
				 sql="SELECT DISTINCT  b.EVENT_TYPE code,b.EVENT_NAME description FROM xh_message_type a,XH_EVENT_TYPE b WHERE a.message_type=b.message_type and (b.communication_type='O' OR b.communication_type='*') and a.message_type='"+obj1.value+"' and EVENT_TYPE  IN (SELECT EVENT_TYPE FROM    XH_APPLICATION_EVENT_TYPE WHERE APPLICATION_ID=  '"+application+"' and IN_USE_YN='Y' ) and UPPER( b.EVENT_TYPE) LIKE UPPER(?) AND  UPPER(b.EVENT_NAME) LIKE UPPER(?)  ORDER BY 1 ";
			}
			else
			{
				 sql="SELECT DISTINCT  b.EVENT_TYPE code,b.EVENT_NAME description FROM xh_message_type a,XH_EVENT_TYPE b WHERE a.message_type=b.message_type and (b.communication_type='I' OR b.communication_type='*') and a.message_type='"+obj1.value+"' and EVENT_TYPE  IN (SELECT EVENT_TYPE FROM    XH_APPLICATION_EVENT_TYPE WHERE APPLICATION_ID=  '"+application+"' and IN_USE_YN='Y' ) and UPPER( b.EVENT_TYPE) LIKE UPPER(?) AND  UPPER(b.EVENT_NAME) LIKE UPPER(?)  ORDER BY 1";
			}
		 
/*
			if(event_id.value!=""){
				dataNameArray[0]	= "EVENT_TYPE" ;
				dataValueArray[0]	= event_id.value;
				dataTypeArray[0]	= STRING ; 
			}
*/
            argumentArray[0] = sql;
            argumentArray[1] = dataNameArray ;
            argumentArray[2] = dataValueArray ;
            argumentArray[3] = dataTypeArray ;
	        argumentArray[4] = "1,2";
//	        argumentArray[4] = "2,1";
            argumentArray[5] = target.value;
            argumentArray[6] = DESC_LINK  ;
            argumentArray[7] = DESC_CODE ;
         
            retVal = await CommonLookup( tit, argumentArray );
            if(retVal != null && retVal != "" ){
	            var ret1=unescape(retVal);
                arr=ret1.split(",");
                target.value=arr[1];
                event_id.value=arr[0];
            }
            else{
                target.value=tdesc;
                event_id.value=tcode;
            }
}// End of searchEventType

//********************************************************************************************
//function searchSegmentType
//*******************************************************************************************

async function searchSegmentType(){
     
	var tdesc="";
    var tcode="";

    var retVal =new String();
    var argumentArray  = new Array() ;
    var dataNameArray  = new Array() ;
    var dataValueArray = new Array() ;
    var dataTypeArray  = new Array() ;
    var tit= getLabel("eXH.SegmentType.Label","XH");;
	
    var target=this.document.forms[0].segment_type;
    var segment_id=this.document.forms[0].segment_type_id;
    var event_id=this.document.forms[0].event_type_id.value;

//			sql="SELECT SEGMENT_TYPE code,SEGMENT_NAME description FROM XH_SEGMENT  WHERE UPPER(SEGMENT_TYPE) LIKE UPPER(?) AND  UPPER(SEGMENT_NAME) LIKE UPPER(?)  AND ORDER BY 1 ";

	sql="SELECT distinct A.SEGMENT_TYPE code,B.SEGMENT_NAME description FROM XH_EVENT_TYPE_SEGMENT A,XH_SEGMENT B WHERE  UPPER(A.SEGMENT_TYPE) LIKE UPPER(?) AND  UPPER(B.SEGMENT_NAME) LIKE UPPER(?) AND  A.EVENT_TYPE = nvl('"+event_id+"',A.EVENT_TYPE) AND A.SEGMENT_TYPE = B.SEGMENT_TYPE  ORDER BY 1 ";
/*
			if(segment_id.value!=""){
				dataNameArray[0]	= "SEGMENT_TYPE" ;
				dataValueArray[0]	= segment_id.value;
				dataTypeArray[0]	= STRING ;
			} */

    argumentArray[0] = sql;
    argumentArray[1] = dataNameArray ;
    argumentArray[2] = dataValueArray ;
    argumentArray[3] = dataTypeArray ;
    argumentArray[4] = "1,2";
    //argumentArray[4] = "2,1";
    argumentArray[5] = target.value;
    argumentArray[6] = DESC_LINK  ;
    argumentArray[7] = DESC_CODE ;
         
    retVal = await CommonLookup( tit, argumentArray );
    if(retVal != null && retVal != "" ){
        var ret1=unescape(retVal);
        arr=ret1.split(",");
        target.value=arr[1];
        segment_id.value=arr[0];
    }
    else{
        target.value=tdesc;
        segment_id.value=tcode;
    }
}// End of searchSegmentType

//********************************************************************************************
//function funSubmit
//*******************************************************************************************
function funSubmit()
{
	// #MOD#01
	var act = "";
	if(document.forms[0].name=='DATAGRPID_RESULTS'){
			act = '../../eXH/jsp/DataGroupIdQueryResult.jsp';
	}
	else if(document.forms[0].name=='DATAGRPDTL_RESULTS'){
			act = '../../eXH/jsp/DataGroupDetailsQueryResult.jsp';
	}
	this.document.forms[0].action = act;
	this.document.forms[0].submit();
}

//*******************************************************************************************
//function funModify
//*******************************************************************************************
function funModify(obj)
{
	//parent.commontoolbarFrame.document.forms[0].apply.style.display='block';

	if(this.document.forms[0].name=='DATAGRPID_RESULTS'){
		this.document.forms[0].dg_code.value = obj.getAttribute('dg_code');
		this.document.forms[0].dg_desc.value = obj.getAttribute('dg_desc');

		this.document.forms[0].standard_code.value = obj.getAttribute('standard_code');
		this.document.forms[0].standard_desc.value = obj.getAttribute('standard_desc');
		this.document.forms[0].application_id.value = obj.getAttribute('application_id');
		this.document.forms[0].application_name.value = obj.getAttribute('application_name');
        this.document.forms[0].comm_mode.value = obj.getAttribute('protocol_mode');
	
		var act = '../../eXH/jsp/DataGroupSelectMaster.jsp'; 
	}

	else if(this.document.forms[0].name=='DATAGRPDTL_RESULTS'){
 //   alert("DataGroupId.js");
	parent.frames[1].document.forms[0].dg_code.value = obj.getAttribute('dg_code');
	parent.frames[1].document.forms[0].dg_desc.value = obj.getAttribute('dg_desc');
	parent.frames[1].document.forms[0].dg_code.disabled = true;
	parent.frames[1].document.forms[0].dg_desc.disabled = true;
	parent.frames[1].document.forms[0].standard_code.disabled = true;
	parent.frames[1].document.forms[0].standard_desc.disabled = true; 
	parent.frames[1].document.forms[0].standard_code_search.disabled = true; 	
	parent.frames[1].document.forms[0].application_id.disabled = true;
	parent.frames[1].document.forms[0].application_name.disabled = true;
	parent.frames[1].document.forms[0].ApplicationSearch.disabled = true; 
	parent.frames[1].document.forms[0].Communication_mode.disabled = true; 

	this.document.forms[0].srl_no.value = obj.getAttribute('srl_no');
//		alert("srl_no : "+obj.getAttribute('srl_no'));
	this.document.forms[0].dg_code.value = obj.getAttribute('dg_code');
	this.document.forms[0].application_id.value = obj.getAttribute('application_id');
	this.document.forms[0].facility_id.value = obj.getAttribute('facility_id');
	this.document.forms[0].mesg_type_id.value = obj.getAttribute('mesg_type_id');
	this.document.forms[0].event_type_id.value = obj.getAttribute('event_type_id');
	this.document.forms[0].segment_type_id.value = obj.getAttribute('segment_type_id');
	this.document.forms[0].dg_desc.value = obj.getAttribute('dg_desc');
	this.document.forms[0].application_name.value = obj.getAttribute('application_name');
	this.document.forms[0].facility_name.value = obj.getAttribute('facility_name');
	this.document.forms[0].mesg_type.value = obj.getAttribute('mesg_type');
	this.document.forms[0].event_type.value = obj.getAttribute('event_type');
	this.document.forms[0].segment_type.value = obj.getAttribute('segment_type');
//		alert("filter_rule_type : "+obj.getAttribute('filter_rule_type'));
	this.document.forms[0].filter_rule_type.value = obj.getAttribute('filter_rule_type');
//		alert("prtcl_link_id : "+obj.getAttribute('protocol_link_id'));
	this.document.forms[0].protocol_link_id.value = obj.getAttribute('protocol_link_id');	

	var act = '../../eXH/jsp/DataGroupDetailsAddModify.jsp';

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

