var global_count = 0;

function create()
{
	
	f_query_add_mod.location.href='../../eCA/jsp/QueryNoteTemplateAddModify.jsp';
	
}

function loadDetPage(note_type)
{
		
	var bean_key=document.forms[0].bean_key.value;
		
		parent.QueryTemplateDetail.location.href = '../../eCA/jsp/QueryNoteTemplatedetails.jsp?note_type='+note_type+"&bean_key="+bean_key;

}


function selectCompInPage(obj)
 {
	 var startIndex =  document.queryTemplateDetForm.startIndex.value;
	 var endIndex =  document.queryTemplateDetForm.endIndex.value;
	 var count =  parseInt(document.queryTemplateDetForm.count.value);
	 var bean_key = document.forms[0].bean_key.value ;
	 	
	 var chkboxObj;
	 var final_string = '';
	 var rem_string = '';
	 var global_sel_count = '';

	startIndex=1;
	endIndex =15;
	 	 	 
	 if(obj.checked == true)
	 {
				
		for(var i=parseInt(startIndex,10);i<=parseInt(endIndex,10);i++)
		{
			chkboxObj = eval("document.queryTemplateDetForm.selRow"+i);
			if(chkboxObj != null)
			{   
				if(!chkboxObj.checked)
				{
					global_sel_count = parent.QueryTemplateHeader.queryTemplateHdrForm.global_sel_count.value;
					global_sel_count++;
						if(global_sel_count>10)
						{
							alert(getMessage("COMP_MORE_10_NOT_ALLOWED","CA"));
							document.forms[0].selAll.checked=false;
							break;
						}
					parent.QueryTemplateHeader.queryTemplateHdrForm.global_sel_count.value = global_sel_count;
					
				}
				
				chkboxObj.checked = true;
				global_count++;
			}
		}
	 }
	 else if(obj.checked == false)
	 {
		global_count=0;
			
		global_sel_count = parent.QueryTemplateHeader.queryTemplateHdrForm.global_sel_count.value;
		global_sel_count = parseInt(global_sel_count) - parseInt(count);
		parent.QueryTemplateHeader.queryTemplateHdrForm.global_sel_count.value = global_sel_count;
		
		for(var i=parseInt(startIndex,10);i<=parseInt(endIndex,10);i++)
		{
			chkboxObj = eval("document.queryTemplateDetForm.selRow"+i);
			if(chkboxObj != null)
				chkboxObj.checked = false;
		}
	 }

	 for( i=1;i<=parseInt(count);++i)
	{
		field = eval("document.forms[0].selRow"+i);
		
		if(field.checked)
		{
			field_val=	field.value;				
			
			if(final_string=='')
			{
				final_string = field_val;
			}
			else
			{
				final_string = final_string+"`"+field_val;
			}
		
		}
		else
		{
			field_val=	field.value;
			if(rem_string=='')
			{
				rem_string = field_val;
			}
			else
			{
				rem_string = rem_string+"`"+field_val;
			}

		}
		
	}
		
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlStr	="<root><SEARCH " ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST","../../eCA/jsp/QueryNoteTemplateIntermediate.jsp?operation_mode=addToBean&bean_key="+bean_key+"&final_string="+final_string+"&rem_string="+rem_string, false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText;
	responseText = trimString(responseText);
	eval(responseText);
	 
 }

function submitPrevNext(start,last,query)
{
   
   var field = '';
   var patient_id = '';
   var encounter_id = '';
   var transcriber = '';
   var notes = '';
   var final_string = '';
   var bean_key = document.forms[0].bean_key.value ;
   var count = document.forms[0].count.value ;
       
   	parent.QueryTemplateDetail.location.href="../../eCA/jsp/QueryNoteTemplatedetails.jsp?res_mode=Next&lower_limit="+start+"&upper_limit="+last+"&bean_key="+bean_key+"&"+query;


}

async function getNoteType()
{
		var target			= document.forms[0].note_type_desc;
		var retVal			=  new String();
		var dialogTop		= "40";
		var dialogHeight	= "10" ;
		var dialogWidth		= "40" ;
		var features		= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
		var arguments		= "" ;
		var search_desc		= "";
		var title			= "";
				
		title			= getLabel("Common.NoteType.label","COMMON");
		
		var sql="";
       

		
		sql="select NOTE_TYPE code,NOTE_TYPE_DESC description from ca_note_type where EFF_STATUS='E' and upper(NOTE_TYPE_DESC) like upper(?) and upper(NOTE_TYPE) like upper(?) order by 2  ";

		
		 
		var argArray		= new Array();
		var namesArray		= new Array();
		var valuesArray		= new Array();
		var datatypesArray	= new Array();
		
		argArray[0] = sql;
		argArray[1] = namesArray;
		argArray[2] = valuesArray;
		argArray[3] = datatypesArray;
		argArray[4] = "2,1";
		argArray[5] = target.value;
		argArray[6] = DESC_LINK;
		argArray[7] = CODE_DESC;
		retArray = await CommonLookup( title, argArray );	
		var ret1=unescape(retArray);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		} 
		if(retArray != null && retArray !="")
		{

			document.forms[0].note_type_desc.value = arr[1];
		   	document.forms[0].note_type.value = arr[0];
			var bean_key = document.forms[0].bean_key.value
			parent.QueryTemplateHeader.queryTemplateHdrForm.global_sel_count.value='';
			clearBean(bean_key);
			loadDetPage(arr[0]);
				
		}
		else
		{
			document.forms[0].note_type_desc.value = "";
			document.forms[0].note_type.value ="";
		}

}


async function getNoteType1(obj)
{

	if(obj.value!='')
	{
		await getNoteType();
	}
	else
	{
		document.forms[0].note_type_desc.value = "";
		document.forms[0].note_type.value = "";
		parent.QueryTemplateDetail.location.href='../../eCommon/html/blank.html';

	}

}

function apply()
{
	
	if(f_query_add_mod.QueryTemplateDetail.document.queryTemplateDetForm != null)
		{
			
			var global_sel_count = f_query_add_mod.QueryTemplateHeader.queryTemplateHdrForm.global_sel_count.value;
			
			if(global_sel_count==0)
			{
				
				message  = getMessage("ENSURE_SELECTION","CA");
				messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
				return false ;
			}

			var mode = f_query_add_mod.QueryTemplateHeader.document.queryTemplateHdrForm.mode.value;
			
			if(mode=='insert'){
			var fields = new Array ( f_query_add_mod.QueryTemplateHeader.document.queryTemplateHdrForm.query_id,
			f_query_add_mod.QueryTemplateHeader.document.queryTemplateHdrForm.query_desc,
			f_query_add_mod.QueryTemplateHeader.document.queryTemplateHdrForm.note_type
				    );
			var names= new Array (getLabel("eCA.QueryID.label",'CA'),getLabel("eCA.QueryDesc.label",'CA'),getLabel("Common.NoteType.label",'COMMON'));
			
			}

			else
			{
				var fields = new Array ( 
					f_query_add_mod.QueryTemplateHeader.document.queryTemplateHdrForm.query_desc
			
				    );
							
				var names= new Array (getLabel("eCA.QueryDesc.label","CA"));
			
			}
				if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame)) 
				{
					f_query_add_mod.QueryTemplateDetail.document.queryTemplateDetForm.query_id.value = f_query_add_mod.QueryTemplateHeader.document.queryTemplateHdrForm.query_id.value ;
					f_query_add_mod.QueryTemplateDetail.document.queryTemplateDetForm.query_desc.value = f_query_add_mod.QueryTemplateHeader.document.queryTemplateHdrForm.query_desc.value ;
					f_query_add_mod.QueryTemplateDetail.document.queryTemplateDetForm.note_type.value = f_query_add_mod.QueryTemplateHeader.document.queryTemplateHdrForm.note_type.value ;
					f_query_add_mod.QueryTemplateDetail.document.queryTemplateDetForm.eff_status.value = f_query_add_mod.QueryTemplateHeader.document.queryTemplateHdrForm.eff_status.value ;
					f_query_add_mod.QueryTemplateDetail.document.queryTemplateDetForm.mode.value = f_query_add_mod.QueryTemplateHeader.document.queryTemplateHdrForm.mode.value ;
					
					
					f_query_add_mod.QueryTemplateDetail.document.queryTemplateDetForm.submit();	

				}




		}
		else
		{
		
		
			message  = getMessage("NOT_VALID","CA");
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
			return false ;
		}
	
	

}
function query()
{
	
	f_query_add_mod.location.href='../../eCA/jsp/QueryCriteriaQueryTemplate.jsp';
	
}

function loadDetPageOnModify(query_id)
{
	var bean_key = document.forms[0].bean_key.value ;
	var note_type = document.forms[0].note_type.value ;

	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlStr	="<root><SEARCH " ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST","../../eCA/jsp/QueryNoteTemplateIntermediate.jsp?operation_mode=loadToBean&bean_key="+bean_key+"&query_id="+query_id, false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText;
	responseText = trimString(responseText);
	eval(responseText);
	
	parent.QueryTemplateDetail.location.href = '../../eCA/jsp/QueryNoteTemplatedetails.jsp?note_type='+note_type+"&bean_key="+bean_key;


}

function remFromList(obj)
{
	
	var mode="";
	var bean_key = document.forms[0].bean_key.value;
	var count =  parseInt(document.forms[0].count.value);
	var arrVal = obj.value;
	var global_sel_count = "" ;
	
	if(obj.checked)
	{
		global_count++;
				
		global_sel_count = parent.QueryTemplateHeader.queryTemplateHdrForm.global_sel_count.value;
		global_sel_count++;
		if(global_sel_count>10)
		{
				alert(getMessage("COMP_MORE_10_NOT_ALLOWED","CA"));
				obj.checked=false;
				return false;
		}
		parent.QueryTemplateHeader.queryTemplateHdrForm.global_sel_count.value = global_sel_count;

		mode="Add";
	}
	else
	{
		global_count--;
		
		global_sel_count = parent.QueryTemplateHeader.queryTemplateHdrForm.global_sel_count.value;
		global_sel_count--;
		parent.QueryTemplateHeader.queryTemplateHdrForm.global_sel_count.value = global_sel_count;
		
		mode="Rem";
		document.forms[0].selAll.checked=false;
	
	}
		
	if(count==parseInt(global_count))
	{
		document.forms[0].selAll.checked=true;
	}
	
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlStr	="<root><SEARCH " ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST","../../eCA/jsp/QueryNoteTemplateIntermediate.jsp?operation_mode=remove&bean_key="+bean_key+"&mode="+mode+"&arrVal="+arrVal, false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText;
	responseText = trimString(responseText);
	
}

function onSuccess()
{
	f_query_add_mod.QueryTemplateHeader.location.reload();
	f_query_add_mod.QueryTemplateDetail.location.href='../../eCommon/html/blank.html';
			
}

function check(obj)
{
	if(obj.checked)
	{
		document.forms[0].eff_status.value='E';
	}
	else
	{
		document.forms[0].eff_status.value='D';
	}


}

function reset()
{

	if(f_query_add_mod.QueryTemplateAddModify!= null)
		{
			var bean_key =   f_query_add_mod.QueryTemplateHeader.document.queryTemplateHdrForm.bean_key.value ;
			f_query_add_mod.QueryTemplateHeader.queryTemplateHdrForm.global_sel_count.value='';
			clearBean(bean_key);	
			if(f_query_add_mod.QueryTemplateHeader.document.queryTemplateHdrForm.mode.value=="insert")
			{
				
				f_query_add_mod.QueryTemplateHeader.location.reload();
				f_query_add_mod.QueryTemplateDetail.location.href='../../eCommon/html/blank.html';
			}
			else
			{ 
				
				f_query_add_mod.QueryTemplateHeader.location.reload();
				f_query_add_mod.QueryTemplateDetail.location.reload()
			}
		}
		else
		{

			f_query_add_mod.location.reload();	
		}

}

function clearBean(bean_key)
{

	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlStr	="<root><SEARCH " ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST","../../eCA/jsp/QueryNoteTemplateIntermediate.jsp?operation_mode=clearBean&bean_key="+bean_key, false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText;
	responseText = trimString(responseText);
	eval(responseText);
	



}

function checkMaxLimit1(obj,maxLength)

{
	
	if(!checkMaxLimit(obj,maxLength))
	{
		var msg =getMessage("REMARKS_CANNOT_EXCEED","Common");
		msg = msg.replace('$',getLabel("eCA.QueryDesc.label",'CA'));
		msg = msg.replace('#',maxLength);
		return false;
	}

}
