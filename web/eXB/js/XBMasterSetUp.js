/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
 //********************************************************************************************
//FUNCTION CREATE
//********************************************************************************************
function create()  
{ 
//	    alert("create");
	    MasterSetUpframeset.rows="30,140,300,30";
		window.f_query_add_mod.location.href="../../eXB/jsp/XBMasterSetUpSelect.jsp?mode=I&rule=U";
		window.f_query_add_mod_detail.location.href="../../eCommon/html/blank.html";
		window.messageFrame.location.href="../../eCommon/html/blank.html";	   
}
//********************************************************************************************
//FUNCTION QUERY
//********************************************************************************************
function query()
{		  
		MasterSetUpframeset.rows="30,360,80,30"; 
		window.f_query_add_mod.document.location.href="../../eXB/jsp/XBMasterSetUpQueryCriteria.jsp";
		window.f_query_add_mod_detail.location.href="../../eCommon/html/blank.html";			    
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
	   frames[1].document.forms[0].episode_type.disabled = false;

//	    alert( frames[1].document.forms[0].episode_type.value);
		var mode = frames[1].document.forms[0].act_mode.value;
			if(frames[1].document.forms[0].act_mode.value=='D'){
				frames[1].document.forms[0].submit();			
			}
			else {
			var fields = new Array ( 	
		 				  frames[1].document.forms[0].facility_Id,	
						  frames[1].document.forms[0].module_Id,
						  frames[1].document.forms[0].payer_group_code,
						  frames[1].document.forms[0].payer_code,
						  frames[1].document.forms[0].policy_code,
					      frames[1].document.forms[0].episode_type	) ;				 
			var names = new Array
			("Facility","Module Type","Payer Group","Payer ","Policy ","Episode Type");																							   
			//(getLabel("Common.identification.label","common"),getLabel("Common.name.label","common"),getLabel("Common.Standard.label","common"),getLabel("Common.Application.label","common"),getLabel("eXH.CommMode.Label","XH"));

			if(!f_query_add_mod.checkFields( fields, names, messageFrame))
			{
			}else{
				frames[1].document.forms[0].submit();	
				if(mode=='I'){
					window.f_query_add_mod.document.forms[0].reset();
				}
			}
			}
  window.commontoolbarFrame.document.location.reload();
}
//********************************************************************************************
//FUNCTION RESET 
//********************************************************************************************
function reset()
{	
				 window.f_query_add_mod.document.forms[0].reset();
}

//********************************************************************************************
//function searchFacility
//*******************************************************************************************

function searchFacility(){
     
			var tdesc="";
            var tcode="";

            var retVal =new String();
            var argumentArray  = new Array() ;
            var dataNameArray  = new Array() ;
            var dataValueArray = new Array() ;
            var dataTypeArray  = new Array() ;
            //var tit= getLabel("Common.Standard.label","common");
			var tit= "Facility";

            var target=this.document.forms[0].facility_Name;
            var facility_Id=this.document.forms[0].facility_Id;
            
			 sql="SELECT FACILITY_ID code,FACILITY_NAME description FROM sm_facility_param WHERE status = 'E' AND UPPER(FACILITY_ID) LIKE UPPER(?) AND  UPPER(FACILITY_NAME) LIKE UPPER(?) ORDER BY 1 ";

 //           alert("sql : "+sql);
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
                facility_Id.value=arr[0];
            }
            else{
                target.value=tdesc;
                facility_Id.value=tcode;
            }
}// End of searchFacility


//********************************************************************************************
//function searchModuleType
//*******************************************************************************************

function searchModuleType(){
     
			var tdesc="";
            var tcode="";

            var retVal =new String();
            var argumentArray  = new Array() ;
            var dataNameArray  = new Array() ;
            var dataValueArray = new Array() ;
            var dataTypeArray  = new Array() ;
            //var tit= getLabel("Common.Standard.label","common");
			var tit= "Module Type";

            var target=this.document.forms[0].module_Name;
            var module_Id=this.document.forms[0].module_Id;
            
			 sql="SELECT EVENT_TYPE code,EVENT_NAME description FROM xh_event_type WHERE substr(event_type,1,2) = 'EB' AND EVENT_TYPE NOT IN ('EB3') AND UPPER(EVENT_TYPE) LIKE UPPER(?) AND  UPPER(EVENT_NAME) LIKE UPPER(?) ORDER BY 1 ";

 //           alert("sql : "+sql);
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
                module_Id.value=arr[0];
            }
            else{
                target.value=tdesc;
                module_Id.value=tcode;
            }
}// End of searchModuleType

//********************************************************************************************
//function searchPayerGroup
//*******************************************************************************************

function searchPayerGroup(){
     
			var tdesc="";
            var tcode="";

            var retVal =new String();
            var argumentArray  = new Array() ;
            var dataNameArray  = new Array() ;
            var dataValueArray = new Array() ;
            var dataTypeArray  = new Array() ;
            //var tit= getLabel("Common.Standard.label","common");
			var tit= "Payer Group";

            var target=this.document.forms[0].payer_group_desc;
            var payer_group_code=this.document.forms[0].payer_group_code;
            
			 sql="SELECT CUST_GROUP_CODE code,LONG_DESC description FROM AR_CUST_GROUP_LANG_VW WHERE LANGUAGE_ID = 'en' AND NVL(STATUS,'N') ='N'  AND UPPER(CUST_GROUP_CODE) LIKE UPPER(?) AND  UPPER(LONG_DESC) LIKE UPPER(?) ORDER BY 1";

 //           alert("sql : "+sql);
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
                payer_group_code.value=arr[0];
				this.document.forms[0].payer_desc.disabled = false;
				this.document.forms[0].payerSearch.disabled = false;
				this.document.forms[0].payer_code.value = "";
				this.document.forms[0].payer_desc.value = "";
            }
            else{
                target.value=tdesc;
                payer_group_code.value=tcode;
				this.document.forms[0].payer_code.value = "";
				this.document.forms[0].payer_desc.value = "";
				this.document.forms[0].payer_desc.disabled = true;
				this.document.forms[0].payerSearch.disabled = true;
            }
}// End of searchPayerGroup

//********************************************************************************************
//function searchPayer
//*******************************************************************************************

function searchPayer(){
     
			var tdesc="";
            var tcode="";

            var retVal =new String();
            var argumentArray  = new Array() ;
            var dataNameArray  = new Array() ;
            var dataValueArray = new Array() ;
            var dataTypeArray  = new Array() ;
            //var tit= getLabel("Common.Standard.label","common");
			var tit= "Payer";
			var payer_group_code = this.document.forms[0].payer_group_code.value;

            var target=this.document.forms[0].payer_desc;
            var payer_code=this.document.forms[0].payer_code;
            
//			if(payer_group_code=='*A'){
				sql="SELECT '*A' code,'ALL' description from dual UNION SELECT CUST_CODE code,SHORT_NAME description FROM AR_CUSTOMER_LANG_VW WHERE LANGUAGE_ID = 'en' AND NVL(STATUS,'N') ='N' AND  CUST_GROUP_CODE = '"+payer_group_code+"'AND UPPER(CUST_CODE) LIKE UPPER(?) AND  UPPER(SHORT_NAME) LIKE UPPER(?) ORDER BY 1 ";
/*			}
			else{ 
				sql="SELECT CUST_CODE code,SHORT_NAME description FROM AR_CUSTOMER_LANG_VW WHERE LANGUAGE_ID = 'en' AND NVL(STATUS,'N') ='N' AND  CUST_GROUP_CODE = '"+payer_group_code+"' AND UPPER(CUST_CODE) LIKE UPPER(?) AND  UPPER(SHORT_NAME) LIKE UPPER(?) ORDER BY 1 ";
//			} */

 //           alert("sql : "+sql);
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
                payer_code.value=arr[0];
            }
            else{
                target.value=tdesc;
                payer_code.value=tcode;
            }
}// End of searchPayer

//********************************************************************************************
//function searchPolicy
//*******************************************************************************************

function searchPolicy(){
     
			var tdesc="";
            var tcode="";

            var retVal =new String();
            var argumentArray  = new Array() ;
            var dataNameArray  = new Array() ;
            var dataValueArray = new Array() ;
            var dataTypeArray  = new Array() ;
            //var tit= getLabel("Common.Standard.label","common");
			var tit= "Policy Type";

            var target=this.document.forms[0].policy_desc;
            var policy_code=this.document.forms[0].policy_code;

			sql="SELECT '*A' code,'ALL' description from dual UNION SELECT POLICY_TYPE_CODE code,SHORT_DESC description FROM BL_INS_POLICY_TYPES_LANG_VW WHERE LANGUAGE_ID= 'en'  AND NVL(STATUS,'N') ='N'  AND UPPER(POLICY_TYPE_CODE) LIKE UPPER(?) AND  UPPER(SHORT_DESC) LIKE UPPER(?) ORDER BY 1 ";

 //           alert("sql : "+sql);
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
                policy_code.value=arr[0];
            }
            else{
                target.value=tdesc;
                policy_code.value=tcode;
            }
}// End of searchPolicy

//********************************************************************************************
//function funSubmit
//*******************************************************************************************
function funSubmit()
{
//	alert("funSubmit");
	var act = '../../eXB/jsp/XBMasterSetUpQueryResult.jsp';

	this.document.forms[0].action = act;
	this.document.forms[0].submit();
}

//*******************************************************************************************
//function funModify
//*******************************************************************************************
function funModify(obj)
{
	parent.commontoolbarFrame.document.forms[0].apply.style.display='block';
	if(this.document.forms[0].name=='XBMASTERSETUP_RESULTS'){
//		alert("XBMASTERSETUP_RESULTS");
		this.document.forms[0].module_Id.value = obj.getAttribute('module_Id');
		this.document.forms[0].module_Name.value = obj.getAttribute('module_Name');
		this.document.forms[0].payer_group_code.value = obj.getAttribute('payer_group_code');
		this.document.forms[0].payer_group_desc.value = obj.getAttribute('payer_group_desc');
		this.document.forms[0].payer_code.value = obj.getAttribute('payer_code');
		if(obj.getAttribute('payer_code')=='*A') {
			this.document.forms[0].payer_desc.value = 'ALL';
		}else{
			this.document.forms[0].payer_desc.value = obj.getAttribute('payer_desc');
		}
		this.document.forms[0].policy_code.value = obj.getAttribute('policy_code');
		if(obj.getAttribute('policy_code')=='*A') {
			this.document.forms[0].policy_desc.value = 'ALL';
		} else {
			this.document.forms[0].policy_desc.value = obj.getAttribute('policy_desc');
		}
//		alert("facilityID : "+obj.getAttribute('facility_Id'));
//		alert("facility_Name : "+obj.getAttribute('facility_Name'));
		this.document.forms[0].episode_type.value = obj.getAttribute('episode_type');
		this.document.forms[0].enabled_yn.value = obj.getAttribute('enabled_yn');
		this.document.forms[0].facility_Id.value = obj.getAttribute('facility_Id');
		this.document.forms[0].facility_Name.value = obj.getAttribute('facility_Name');
//	    alert("Enabled_YN : "+this.document.forms[0].enabled_yn.value);
		var act = '../../eXB/jsp/XBMasterSetUpSelect.jsp'; 
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

