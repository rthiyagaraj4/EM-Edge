
var message = "" ;
var result = false ;

	function query() 
	{
		f_query_add_mod.location.href="../../ePH/jsp/ADRCertainityFrames.jsp?mode="+MODE_MODIFY;
	}
	function Modify(obj)
	{
		var Certainity_code		 =	obj.cells[0].innerText;	
		var System_Description	 =	obj.cells[1].innerText;	
		var user_desc			 =	obj.cells[2].innerText;	
		var rel_score_from		 =	obj.cells[3].innerText;	
		var rel_score_to		 =	obj.cells[4].innerText;	
		
		parent.frames[1].location.href="../../ePH/jsp/ADRCertainityModify.jsp?mode="+MODE_MODIFY+"&Certainity_code="+Certainity_code+"&System_Description="+System_Description+"&user_desc="+user_desc+"&rel_score_from="+rel_score_from+"&rel_score_to="+rel_score_to;
		
	}

	function checkSign(obj)
	{
			var str=obj.value;
			var size=obj.value.length;
			var index=0;
			for(index=0;index<=size;index++)
			{
				if((obj.value.length=="1")&&((obj.value.charAt(0))=="-"))
				{
					
					 alert(getMessage("ENTER_VALID_NEGATIVE_NUMBER","PH"));
					 
				}
				if(((obj.value.charAt(index))=="-")&&(index>0))
				{
					 alert(getMessage("ENTER_VALID_NEGATIVE_NUMBER","PH"));
					 	
				}
			}			
	}

function apply()
 {	 
	//alert(f_query_add_mod.frames[1].location.href);
	if ( !checkIsValidForProceed( "adrcertainitymodify" )) 
	{
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
		return false;
	}
	
	var formObj			 =		 f_query_add_mod.frames[1].document.formADRCertainityModify;
	var mode			 =		 f_query_add_mod.frames[1].document.formADRCertainityModify.mode;
	//var messageFrame	 =		 parent.frames[1].frames[2];
	messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
	var error_page		 =		 "../../eCommon/jsp/MstCodeError.jsp";	

	var rel_score_from	=		f_query_add_mod.frames[1].document.formADRCertainityModify.rel_score_from.value;
	var rel_score_to	=		f_query_add_mod.frames[1].document.formADRCertainityModify.rel_score_to.value;
	var Certainity_code =		f_query_add_mod.frames[1].document.formADRCertainityModify.Certainity_code.value;
	var user_desc		=		f_query_add_mod.frames[1].document.formADRCertainityModify.user_desc.value;

	if(Certainity_code == "E")
		 {
			
				var fields	 =		new Array	(formObj.user_desc);
				var names	 =		new Array	(getLabel("User Description","PH"));
				if(f_query_add_mod.frames[1].checkFieldsofMst(fields,names,messageFrame))
				{
					var responseText	=	formApply( f_query_add_mod.frames[1].document.formADRCertainityModify, PH_CONTROLLER ) ;
					//alert("apply ="+PH_CONTROLLER);
					eval(responseText);
					messageFrame.location.href	=	"../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
					if( result ) 
					{ 	
						onSuccess();
					}
	
				}
				else
				 {
				
					onSuccess(rel_score_from,rel_score_to);
				 }
		 }
	if(relCheck(rel_score_from,rel_score_to)==true)
	 {
		if(Certainity_code != "E")
		 {
			if(checkOverlap(rel_score_from,rel_score_to,Certainity_code)){
					
			var fields	=	new Array	(formObj.user_desc,formObj.rel_score_from,formObj.rel_score_to);
			var names =		new Array	(getLabel("Common.UserDescription.label","Common"),getLabel("ePH.RelativeScoreFrom.label","PH"),getLabel("ePH.RelativeScoreTo.label","PH"));	
			if(f_query_add_mod.frames[1].checkFieldsofMst(fields,names,messageFrame))
				{
					var responseText	=	formApply( f_query_add_mod.frames[1].document.formADRCertainityModify, PH_CONTROLLER ) ;
					
					eval(responseText);
					messageFrame.location.href	=	"../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
					if( result ) 
					{
						
						onSuccess();
					}
				}
			}	 
			else{
				f_query_add_mod.frames[1].document.formADRCertainityModify.rel_score_from.focus();
				message	=	getMessage("ENTER_NEW_RANGE_VALUES","PH");
				messageFrame.location.href	=	"../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
				 }
		 }
	 
	 }
	 
	
	 else
		 if(relCheck(rel_score_from,rel_score_to)==false)
		 {
					message=getMessage("ENTER_NEW_RANGE_VALUES","PH");
			    	messageFrame.location.href	=	"../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
				 }
	 
	}
 
	
	function onSuccess() 
	{ 
	
	  f_query_add_mod.location.href="../../ePH/jsp/ADRCertainityFrames.jsp?mode="+MODE_MODIFY;
	 
	}
	function reset()
	{
		if ( !checkIsValidForProceed( "adrcertainitymodify" )) 
		{
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
		return false;
		}

		f_query_add_mod.frames[1].document.formADRCertainityModify.user_desc.value=f_query_add_mod.frames[1].document.formADRCertainityModify.user_desc_hidden.value;
		f_query_add_mod.frames[1].document.formADRCertainityModify.rel_score_from.value=f_query_add_mod.frames[1].document.formADRCertainityModify.rel_score_from_hidden.value;
		f_query_add_mod.frames[1].document.formADRCertainityModify.rel_score_to.value=f_query_add_mod.frames[1].document.formADRCertainityModify.rel_score_to_hidden.value;
	
	}
	function assignResult( _result, _message, _flag )
	{
		result		=	 _result ;
		message		=	_message ;
		flag		=	_flag ;
	}

	function checkOverlap(rel_score_from,rel_score_to,Certainity_code)
	{
	
		var bean_id		=	f_query_add_mod.frames[1].document.formADRCertainityModify.bean_id.value ;
		var bean_name	=	f_query_add_mod.frames[1].document.formADRCertainityModify.bean_name.value ;
		//var xmlDoc		=	new ActiveXObject( "Microsoft.XMLDom" ) ;
		//var xmlHttp		=	 new ActiveXObject( "Microsoft.XMLHTTP" ) ;
		var xmlHttp = new XMLHttpRequest();
		var xmlDoc = "";
		var xmlStr		=	"<root><SEARCH  /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","../../ePH/jsp/ADRCertainityValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name +"&rel_score_from="+rel_score_from+"&rel_score_to="+rel_score_to +"&Certainity_code="+Certainity_code+ "&validate=OVERLAPPING", false);
		xmlHttp.send(xmlDoc);
		var responseText=xmlHttp.responseText;
		//alert("responseText---"+responseText);
		return eval(responseText);
	}
	function checkedValue(str)
	{
		if(str=='Y')
			return false;
		else
			return true;

	}

	
	function CheckForAlphabets(event)
	{
	    var strCheck	 =	'0123456789-';
	    var whichCode	 =	 (window.Event) ? event.which : event.keyCode;
	    key				 =	 String.fromCharCode(whichCode);  // Get key value from key code
	    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	
	    return true ;
	}

	function relCheck(rel_score_from,rel_score_to)
	{
		if(parseInt(rel_score_from)>=	parseInt(rel_score_to))
		 {
			 alert(getMessage("RELATIVE_SCORE_TO_GREATER_THAN_FROM","PH"));
			 f_query_add_mod.frames[1].document.formADRCertainityModify.rel_score_from.value="";
			f_query_add_mod.frames[1].document.formADRCertainityModify.rel_score_from.focus();
			return false;
		 }
		 else
			 return true;
	}
	function checkIsValidForProceed( urlName ) 
	{
		var url1=f_query_add_mod.location.href;		
		if(url1.indexOf("ADRCertainityFrames")!= -1)
		{
			var url = f_query_add_mod.frames[1].location.href;			
			url = url.toLowerCase();
			if ( (url.indexOf( urlName ) != -1) )
				return true;
			else
				return false;
		}
		else 
			return false;
	}
