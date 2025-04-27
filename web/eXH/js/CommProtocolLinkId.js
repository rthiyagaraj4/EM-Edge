 //********************************************************************************************
//FUNCTION CREATE
//********************************************************************************************
function create()   
{
//window.commontoolbarFrame.document.forms[0].apply.style.display='block';
window.f_query_add_mod.location.href="../../eXH/jsp/CommProtocolLinkIdSelectMaster.jsp?mode=I";		
window.messageFrame.location.href="../../eCommon/html/blank.html";

}
//********************************************************************************************
//FUNCTION QUERY
//********************************************************************************************
function query()
{
		//window.commontoolbarFrame.document.forms[0].apply.style.display='none';
		window.f_query_add_mod.location.href="../../eXH/jsp/CommProtocolLinkIdQueryCriteria.jsp";		
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
//	alert("Mode : "+frames[1].document.forms[0].act_mode.value);

	
if(frames[1].document.forms[0])
	{
	var fields = new Array ( 
						  frames[1].document.forms[0].protocol_linkId,
					      frames[1].document.forms[0].protocol_linkName,
					      frames[1].document.forms[0].protocol_name,
						  frames[1].document.forms[0].datagroup_name) ;
 
	var names = new Array (getLabel("eXH.Gateway.Label","XH")+" "+getLabel("Common.identification.label","common"),getLabel("eXH.Gateway.Label","XH")+" "+getLabel("Common.name.label","common"),getLabel("eXH.Communication.Label","XH"),getLabel("eXH.DataGroup.Label","XH"));  
  
	if(!f_query_add_mod.checkFields( fields, names, messageFrame))
	{
   
	}else 
		{
		var mode = frames[1].document.forms[0].act_mode.value;
			window.f_query_add_mod.document.forms[0].submit();
			if(mode=='I'){
				window.f_query_add_mod.document.forms[0].reset();
			}
			else
			{
				if(frames[1].document.forms[0].outbndLogYN.checked==true)
				{
					frames[1].document.forms[0].outbndLogYN.value='Y';
				}
				else
				{
                       frames[1].document.forms[0].outbndLogYN.value='N';
				}
				if(frames[1].document.forms[0].inbndLogYN.checked==true)
				{
					frames[1].document.forms[0].inbndLogYN.value='Y';
				}
				else
				{
                       frames[1].document.forms[0].inbndLogYN.value='N';
				}



				  	  window.f_query_add_mod.document.forms[0].target='' 
                      window.f_query_add_mod.document.forms[0].action='../../eXH/jsp/CommProtocolLinkIdSelectMaster.jsp?mode=U&dg_desc='+frames[1].document.forms[0].datagroup_name.value+"&outbndLogYN="+frames[1].document.forms[0].outbndLogYN.value+'&inbndLogYN='+frames[1].document.forms[0].inbndLogYN.value;
					  window.f_query_add_mod.document.forms[0].submit();
			}
		}

	}
		//window.f_query_add_mod.document.location.reload();
//window.commontoolbarFrame.document.location.reload(); 
}
//********************************************************************************************
//FUNCTION RESET 
//********************************************************************************************
function reset()
{
// alert("reset");
if(window.f_query_add_mod.document.forms[0])
    {
	var mode = window.f_query_add_mod.document.forms[0].tmp_comm_mode.value;
//	var inbndLogYN = window.f_query_add_mod.document.forms[0].tmp_inbndLogYN.value;

	 if(mode=='O'){
		window.f_query_add_mod.document.getElementById("outbound").style.display='block';
		window.f_query_add_mod.document.getElementById("inbound").style.display='none';
	}
	else if(mode=='I'){
		window.f_query_add_mod.document.getElementById("inbound").style.display='block';
		window.f_query_add_mod.document.getElementById("outbound").style.display='none';
	}

//	alert("mode : "+window.f_query_add_mod.document.forms[0].tmp_comm_mode.value);
//	alert("Inb : "+window.f_query_add_mod.document.forms[0].tmp_inbndLogYN.value);
	 window.f_query_add_mod.document.forms[0].reset();
	} 

/*
 	if(window.f_query_add_mod.document.forms[0])
    {
		act_mode = window.f_query_add_mod.document.forms[0].act_mode.value;
		alert("act_mode:"+act_mode);
		protocol_linkId = window.f_query_add_mod.document.forms[0].tmp_protocol_linkId.value;
		alert("protocol_linkId : "+protocol_linkId);
		protocol_linkName = window.f_query_add_mod.document.forms[0].tmp_protocol_linkName.value;
		alert("protocol_linkName : "+protocol_linkName);
		protocol_id  = window.f_query_add_mod.document.forms[0].tmp_protocol_id.value;
		protocol_name  = window.f_query_add_mod.document.forms[0].tmp_protocol_name.value;
		datagroup_id  = window.f_query_add_mod.document.forms[0].tmp_datagroup_id.value;
		dg_desc = window.f_query_add_mod.document.forms[0].tmp_datagroup_name.value;
		standard_code = window.f_query_add_mod.document.forms[0].tmp_standard_code.value;
		standard_name = window.f_query_add_mod.document.forms[0].tmp_standard_name.value;
		application_id = window.f_query_add_mod.document.forms[0].tmp_application_id.value;
		application_name = window.f_query_add_mod.document.forms[0].tmp_application_name.value;
		profile_id = window.f_query_add_mod.document.forms[0].tmp_profile_id.value;
		profile_desc = window.f_query_add_mod.document.forms[0].tmp_profile_desc.value;
		comm_mode = window.f_query_add_mod.document.forms[0].tmp_comm_mode.value;
		inbndLogYN = window.f_query_add_mod.document.forms[0].tmp_inbndLogYN.value;
		outbndLogYN = window.f_query_add_mod.document.forms[0].tmp_outbndLogYN.value;
//        alert("outbndLogYN : "+outbndLogYN);
		params = 'act_mode='+act_mode+'protocol_linkId='+protocol_linkId+'&protocol_linkName='+protocol_linkName+'&protocol_id='+protocol_id+'&protocol_name='+protocol_name+'&datagroup_id='+datagroup_id+'&dg_desc='+dg_desc+'&standard_code='+standard_code+'&standard_name='+standard_name+'&application_id='+application_id+'&application_name='+application_name+'&profile_id='+profile_id+'&profile_desc='+profile_desc+'&comm_mode='+comm_mode+'&inbndLogYN='+inbndLogYN+'&outbndLogYN='+outbndLogYN;

	 window.f_query_add_mod.location.href='../../eXH/jsp/CommProtocolLinkIdSelectMaster.jsp?'+params;	
//	 window.f_query_add_mod.document.location.reload();
	}   */
}
//********************************************************************************************
//function searchProtocol
//*******************************************************************************************

async function searchProtocol(){
     
			var tdesc="";
            var tcode="";

            var retVal =new String();
            var argumentArray  = new Array() ;
            var dataNameArray  = new Array() ;
            var dataValueArray = new Array() ;
            var dataTypeArray  = new Array() ;
            var tit= getLabel("eXH.Communication.Label","XH");			
            var target=this.document.forms[0].protocol_name;
            var prot_id=this.document.forms[0].protocol_id;
		
            sql="SELECT PROTOCOL_ID code,PROTOCOL_NAME description FROM XH_PROTOCOL WHERE  UPPER(PROTOCOL_ID) LIKE UPPER(?) AND UPPER(PROTOCOL_NAME) LIKE UPPER(?)  ORDER BY 1 ";

		/*	if(prot_id.value!=""){
				dataNameArray[0]	= "PROTOCOL_ID" ;
				dataValueArray[0]	= prot_id.value;
				dataTypeArray[0]	= STRING ;
			}
			*/
            argumentArray[0] = sql;
            argumentArray[1] = dataNameArray ;
            argumentArray[2] = dataValueArray ;
            argumentArray[3] = dataTypeArray ;
//            argumentArray[4] = "2,1";
		    argumentArray[4] = "1,2";
            argumentArray[5] = target.value;
            argumentArray[6] = DESC_LINK  ;
            argumentArray[7] = DESC_CODE ;
         
//		    argumentArray[6] = DESC_CODE  ;
//          argumentArray[7] = DESC_LINK ;

            retVal = await CommonLookup( tit, argumentArray );


            if(retVal != null && retVal != "" ){
	            var ret1=unescape(retVal);
                arr=ret1.split(",");
                target.value=arr[1];
                 prot_id.value=arr[0];
				getDefltCheckVals(arr[0]);
				 document.forms[0].datagroup_name.value='';
				  this.document.forms[0].application_id.value = '';
				this.document.forms[0].application_name.value = '';
				this.document.forms[0].standard_code.value = '';
				this.document.forms[0].standard_name.value='';
				this.document.forms[0].profile_id.value='';
				this.document.forms[0].profile_desc.value='';
                     document.forms[0].DataGroupSearch.disabled=false;
                     document.forms[0].datagroup_name.disabled=false;
					 document.forms[0].outbndLogYN.value='';
	                    document.forms[0].inbndLogYN.value='';
            }
            else{
                target.value=tdesc;
                prot_id.value=tcode;
				 document.forms[0].datagroup_name.value='';
				 this.document.forms[0].application_id.value = '';
				this.document.forms[0].application_name.value = '';
				this.document.forms[0].standard_code.value = '';
				this.document.forms[0].standard_name.value='';
				this.document.forms[0].profile_id.value='';
				this.document.forms[0].profile_desc.value='';
				document.forms[0].DataGroupSearch.disabled=true;
                     document.forms[0].datagroup_name.disabled=true;
						document.forms[0].outbndLogYN.value='';
	                    document.forms[0].inbndLogYN.value='';
            }
			
}// End of searchProtocol

//********************************************************************************************
//function searchDataGroup
//*******************************************************************************************

async function searchDataGroup(){
           var comm_mode=document.forms[0].comm_mode.value;
//		   alert("searchDataGroup comm_mode : "+comm_mode);
           	var tdesc="";
            var tcode="";
            var retVal =new String();
            var argumentArray  = new Array() ;
            var dataNameArray  = new Array() ;
            var dataValueArray = new Array() ;
            var dataTypeArray  = new Array() ;
            var tit=getLabel("eXH.DataGroup.Label","XH");			
            var target=this.document.forms[0].datagroup_name;
            var dg_id=this.document.forms[0].datagroup_id;

		//	sql="SELECT DATA_GROUP_ID code,DESCRIPTION description FROM XH_DATA_GROUP WHERE PROTOCOL_MODE=nvl('"+comm_mode+"',PROTOCOL_MODE) AND data_group_id NOT IN (   SELECT data_group_id FROM xh_protocol_link ) and  UPPER(DATA_GROUP_ID) LIKE UPPER(?) AND  UPPER(DESCRIPTION) LIKE UPPER(?)  ORDER BY 1 "; 
		sql="SELECT DATA_GROUP_ID code,DESCRIPTION description FROM XH_DATA_GROUP WHERE PROTOCOL_MODE=nvl('"+comm_mode+"',PROTOCOL_MODE) AND data_group_id NOT IN (   SELECT data_group_id FROM xh_protocol_link WHERE data_group_id is not null  ) and  UPPER(DATA_GROUP_ID) LIKE UPPER(?) AND  UPPER(DESCRIPTION) LIKE UPPER(?)  ORDER BY 1 ";
/*
			if(dg_id.value!=""){
				dataNameArray[0]	= "DATAGROUP_ID" ;
				dataValueArray[0]	= dg_id.value;
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
                dg_id.value=arr[0];
//            getDefltVals(arr[0]);
			getDefltVals(arr[0],comm_mode);			
			
          }
            else{
				this.document.forms[0].application_id.value = '';
				this.document.forms[0].application_name.value = '';
				this.document.forms[0].standard_code.value = '';
				this.document.forms[0].standard_name.value='';
                target.value=tdesc;
                dg_id.value=tcode;
            }
}// End of searchDataGroup

//*********************************************************************************
//function	 
//*********************************************************************************

function getDefltCheckVals(protocolId) {
//	    alert("getDefltCheckVals protocolId : "+protocolId);
		var protocolId	=	protocolId;
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		var xmlStr ="<root><SEARCH ";
		xmlStr += " base_unit=\""+protocolId+"\"";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");		xmlHttp.open("POST","CommProtocolIdDfltValList.jsp?func_mode=DefltValCheckList",false);
		xmlHttp.send(xmlDoc);	
	//alert(xmlHttp.responseText);
		eval(xmlHttp.responseText);	
}

//*********************************************************************************
//function getDefltVals
//*********************************************************************************
function getDefltVals(dataGrpId,comm_mode) {
//        alert("getDefltVals comm_mode : "+comm_mode);
		var data_group_id	=	dataGrpId;
		var xmlDoc = "" ; 
		var xmlHttp = new XMLHttpRequest() ;
		var xmlStr ="<root><SEARCH ";
		xmlStr += " base_unit=\""+data_group_id+"\"";
		xmlStr += " comm_mode=\""+comm_mode+"\"";		
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");		xmlHttp.open("POST","CommProtocolIdDfltValList.jsp?func_mode=DefltValList",false);		
		xmlHttp.send(xmlDoc);	

		eval(xmlHttp.responseText);	
}
//*********************************************************************************
//function setDefltVals
//*********************************************************************************

//function setDefltVals(app_id,app_name,stnd_code,stnd_desc,prfl_id,prfl_dsc){
function setDefltVals(app_id,app_name,stnd_code,stnd_desc,mode){
//    alert("setDefltVals mode : "+mode);
	this.document.forms[0].application_id.value = app_id;
	this.document.forms[0].application_name.value = app_name;
	this.document.forms[0].standard_code.value = stnd_code;
	this.document.forms[0].standard_name.value = stnd_desc;
	this.document.forms[0].profile_desc.value='';
        this.document.forms[0].profile_id.value='';

    if(mode=='I')
	{
		document.getElementById("outbound").style.display='none';
		document.getElementById("inbound").style.display='block';
	}
	else if(mode=='O')
	{
		document.getElementById("inbound").style.display='none';
		document.getElementById("outbound").style.display='block';
	}

//	this.document.forms[0].profile_id.value = prfl_id;
//	this.document.forms[0].profile_desc.value = prfl_dsc;	
}

//*********************************************************************************
//function setDefltVals
//*********************************************************************************
function setDefltCheckVals(mode)
{
//	alert("setDefltCheckVals mode : "+mode);
	document.forms[0].comm_mode.value=mode;

    document.getElementById("outbound").style.display='block';
	document.getElementById("inbound").style.display='block';
    if(mode=='I')
	{
		document.getElementById("outbound").style.display='none';

	}
	else if(mode=='O')
	{
		document.getElementById("inbound").style.display='none';

	}
	else
	{
		document.getElementById("outbound").style.display='block';
		document.getElementById("inbound").style.display='block';
	} 
}
//********************************************************************************************
//function funSubmit
//*******************************************************************************************
function funSubmit()
{
	// #MOD#01
	var act = '../../eXH/jsp/CommProtocolLinkIdQueryResult.jsp';
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

	this.document.forms[0].protocol_linkId.value = obj.getAttribute('protocol_linkId');
	this.document.forms[0].protocol_linkName.value = obj.getAttribute('protocol_linkName');
	this.document.forms[0].protocol_id.value = obj.getAttribute('protocol_id');
	this.document.forms[0].protocol_name.value = obj.getAttribute('protocol_name');
	this.document.forms[0].datagroup_id.value = obj.getAttribute('datagroup_id');
	this.document.forms[0].dg_desc.value = obj.getAttribute('dg_desc');
	this.document.forms[0].standard_code.value = obj.getAttribute('standard_code');
	this.document.forms[0].standard_name.value = obj.getAttribute('standard_name');

	this.document.forms[0].profile_id.value = obj.getAttribute('profile_id');
	this.document.forms[0].profile_desc.value = obj.getAttribute('profile_desc');
	this.document.forms[0].application_id.value = obj.getAttribute('application_id');
	this.document.forms[0].application_name.value = obj.getAttribute('application_name');
	this.document.forms[0].auditYN.value = obj.getAttribute('auditYN');
	this.document.forms[0].debugYN.value = obj.getAttribute('debugYN');
//	alert("modify outb : "+obj.getAttribute('outbndLogYN'));
	this.document.forms[0].outbndLogYN.value = obj.getAttribute('outbndLogYN');
//	alert("modify inb : "+obj.getAttribute('inbndLogYN'));
	this.document.forms[0].inbndLogYN.value = obj.getAttribute('inbndLogYN');
    this.document.forms[0].comm_mode.value = obj.getAttribute('protocolmode'); 
//	this.document.forms[0].lang_id.value = obj.getAttribute('lang_id');
	var act = '../../eXH/jsp/CommProtocolLinkIdSelectMaster.jsp';
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

async function searchStandardCode(){
     
			var tdesc="";
            var tcode="";

            var retVal =new String();
            var argumentArray  = new Array() ;
            var dataNameArray  = new Array() ;
            var dataValueArray = new Array() ;
            var dataTypeArray  = new Array() ;
            var tit= getLabel("Common.Standard.label","common"); 
            var target=this.document.forms[0].standard_name;
            var standard_code=this.document.forms[0].standard_code;

			sql="SELECT STANDARD_CODE code,STANDARD_DESC description FROM XH_STANDARD  WHERE UPPER(STANDARD_CODE) LIKE UPPER(?) AND  UPPER(STANDARD_DESC) LIKE UPPER(?)  ORDER BY 1 ";
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
                dg_id.value=arr[0];
            }
            else{
                target.value=tdesc;
                dg_id.value=tcode;
            }
}// End of searchStandardCode

//********************************************************************************************
//function searchProfile
//*******************************************************************************************

async function searchProfile(){
			var tdesc="";
            var tcode="";

            var retVal =new String();
            var argumentArray  = new Array() ;
            var dataNameArray  = new Array() ;
            var dataValueArray = new Array() ;
            var dataTypeArray  = new Array() ;
            var tit= getLabel("Common.Profile.label","common");
            var target=this.document.forms[0].profile_desc;
            var profile_id=this.document.forms[0].profile_id;
			var stnd_code=this.document.forms[0].standard_code.value;

            sql="SELECT profile_id code,short_desc description FROM XH_STANDARD_PROFILE WHERE UPPER(profile_id) LIKE UPPER(?) AND UPPER(short_desc) LIKE UPPER(?) AND standard_code=nvl('"+stnd_code+"',standard_code) ORDER BY 1  ";
			

			// cmmntd on jan 12
			//sql="SELECT profile_id code,short_desc description FROM XH_STANDARD_PROFILE WHERE UPPER(profile_id) LIKE UPPER(?) AND UPPER(short_desc) LIKE UPPER(?) ORDER BY 1  ";

	/*		if(profile_id.value!=""){
				dataNameArray[0]	= "profile_id" ;
				dataValueArray[0]	= profile_id.value;
				dataTypeArray[0]	= STRING ;
			}
   */
            argumentArray[0] = sql;
            argumentArray[1] = dataNameArray ;
            argumentArray[2] = dataValueArray ;
            argumentArray[3] = dataTypeArray ;
	        argumentArray[4] = "1,2";
            argumentArray[5] = target.value;
            argumentArray[6] = DESC_LINK  ;
            argumentArray[7] = DESC_CODE ;
         
            retVal = await CommonLookup( tit, argumentArray );
            if(retVal != null && retVal != "" ){
	            var ret1=unescape(retVal);
                arr=ret1.split(",");
                target.value=arr[1];
                profile_id.value=arr[0];
            }
            else{
                target.value=tdesc;
                profile_id.value=tcode;
            }
}// End of searchProfile

function setYN(ynval)
{
	if(ynval=='N')
	{
	  alert(getMessage('XH0079','XH'));
      parent.f_query_add_mod.document.forms[0].datagroup_name.value='';
	  parent.f_query_add_mod.document.forms[0].datagroup_id.value='';
	 // parent.f_query_add_mod.document.forms[0].datagroup_name.focus();
	}
	
}
