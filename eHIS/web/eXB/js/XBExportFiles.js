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
}
//********************************************************************************************
//FUNCTION QUERY
//********************************************************************************************
function query()
{		  
//		alert("query");
		ExportFilesframeset.rows="30,360,80,30"; 
		window.f_query_add_mod.document.location.href="../../eXB/jsp/XBExportFilesQueryCriteria.jsp";
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
  frames[1].document.forms[0].submit();	
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
//function searchEventType
//*******************************************************************************************

function searchEventType(){
     
			var tdesc="";
            var tcode="";

            var retVal =new String();
            var argumentArray  = new Array() ;
            var dataNameArray  = new Array() ;
            var dataValueArray = new Array() ;
            var dataTypeArray  = new Array() ;
            //var tit= getLabel("Common.Standard.label","common");
			var tit= "Event Type";

            var target=this.document.forms[0].event_name;
            var event_type=this.document.forms[0].event_type;
            
			 sql="SELECT EVENT_TYPE code,EVENT_NAME description FROM xh_event_type WHERE substr(event_type,1,2) = 'EB' AND EVENT_TYPE NOT IN ('EB3') AND UPPER(EVENT_TYPE) LIKE UPPER(?) AND  UPPER(EVENT_NAME) LIKE UPPER(?) ORDER BY 1 ";

 //         alert("sql : "+sql);
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
                event_type.value=arr[0];
            }
            else{
                target.value=tdesc;
                event_type.value=tcode;
            }
}// End of searchEventType

//********************************************************************************************
//function funSubmit
//*******************************************************************************************
function funSubmit()
{
//	alert("funSubmit");
	var act = '../../eXB/jsp/XBExportFilesQueryResult.jsp';

	this.document.forms[0].action = act;
	this.document.forms[0].submit();
}
 
//*******************************************************************************************
//function funModify
//*******************************************************************************************
function funModify(obj)
{
//	alert("funModify");
	//parent.commontoolbarFrame.document.forms[0].apply.style.display='block';
	if(this.document.forms[0].name=='EXPORTFILES_RESULTS'){		
//		alert("form name  : "+this.document.forms[0].name);
		this.document.forms[0].event_type.value = obj.getAttribute('event_type');
		this.document.forms[0].event_name.value = obj.getAttribute('event_name');
		this.document.forms[0].sent_file_id.value = obj.getAttribute('sent_file_id');			
		this.document.forms[0].sent_date.value = obj.getAttribute('sent_date');
		this.document.forms[0].facilityID.value = obj.getAttribute('facilityID');
		this.document.forms[0].referrenceNo.value = obj.getAttribute('referrenceNo');
		this.document.forms[0].replyFileID.value = obj.getAttribute('replyFileID');
		this.document.forms[0].replyDate.value = obj.getAttribute('replyDate');
//		alert("sent_file_cnt : "+this.document.forms[0].sent_file_cnt.value);
//		this.document.forms[0].csmbs.value = obj.getAttribute('csmbs');
//		this.document.forms[0].reply_file_id.value = obj.getAttribute('reply_file_id');
//		this.document.forms[0].reply_date.value = obj.getAttribute('reply_date');

		var act = '../../eXB/jsp/XBExportFilesSelect.jsp'; 
	}

		this.document.forms[0].action = act;
		this.document.forms[0].submit(); 
}

//*******************************************************************************************
//function funAction
//*******************************************************************************************

function funAction(typ)
{
//	alert("typ : "+typ);
	document.forms[0].action_type.value = typ;
	funSubmit();
}
//*******************************************************************************************

