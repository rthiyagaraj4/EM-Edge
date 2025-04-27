function create()
{
	frames[1].location.href = '../../eFM/jsp/FMNarrationAddMod.jsp?operation=insert';
	frames[2].location.href = '../../eCommon/jsp/MstCodeError.jsp';
}

function query()
{
    frames[1].location.href = '../../eFM/jsp/FMNarrationQueryCriteria.jsp?';
	frames[2].location.href = '../../eCommon/jsp/MstCodeError.jsp';

}

function checkIsValidForProceed()
{
	 var url = f_query_add_mod.location.href; 	
	 url = url.toLowerCase();  	 
	 if ( (url.indexOf("blank.html")==-1) && (url.indexOf("narrationquery")==-1) )  {			 
		return true;
	 } else {	 		 
		return false;
	 }
}
function apply()
{
	
	if (! (checkIsValidForProceed()) )
    {
        frames[2].location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
        return false;
    }

	var fields = new Array (f_query_add_mod.document.Narration_form.narrcode);
	
	var names  =  new Array ( getLabel('Common.code.label','common') );
	
	var messageFrame = frames[2]; 
	
	var error_page = "../../eCommon/jsp/MstCodeError.jsp";

	if(f_query_add_mod.SpecialCharCheck(fields,names,messageFrame,"M", error_page))
	{


		if(f_query_add_mod.document.Narration_form.effstatus.checked == true)
			f_query_add_mod.document.Narration_form.effstatus.value = "E";
		else
			f_query_add_mod.document.Narration_form.effstatus.value = "D";

		var fields1			=	new Array(f_query_add_mod.document.Narration_form.narrcode);
		var names1			=	new Array(getLabel('Common.code.label','common'));
		//var messageFrame1	=	parent.frames[1].frames[2];
		var messageFrame1	=	frames[2];
		var error_page1		=	'../../eCommon/jsp/MstCodeError.jsp';

		if(SpecialCharCheck(fields1, names1, messageFrame1,"M", error_page1))
		{
			var fields = new Array (f_query_add_mod.document.Narration_form.narrcode,
							f_query_add_mod.document.Narration_form.narrlongdesc,
							f_query_add_mod.document.Narration_form.narrshortdesc
							);
			var names = new Array ( getLabel('Common.code.label','common'),getLabel('Common.longdescription.label','common'),getLabel('Common.shortdescription.label','common') );

			if(f_query_add_mod.checkFieldsofMst( fields, names,messageFrame)) 
				frames[1].document.forms[0].submit();
		}
	}
}

function reset()
{
	 if(f_query_add_mod.document.location.href.indexOf("FMNarrationQueryResult.jsp") != -1)
		  return false;
	 else {
			if(f_query_add_mod.document.forms[0].name == "Narration_form")
			{
				if(f_query_add_mod.document.Narration_form.operation.value =="insert")
				{	
					f_query_add_mod.document.forms[0].reset();						
				}
				else
				{
				   f_query_add_mod.document.forms[0].reset();
				}
			}
			  
			if(f_query_add_mod.document.forms[0].name == "query_form")
			{
				f_query_add_mod.location.reload() ;	 			
			}  
	 }
}

function onSuccess()
{
	//if (parent.frames[1].frames[1].document.forms[0].operation.value == 'insert')
		//parent.frames[1].frames[1].document.forms[0].reset() ;
	frames[1].document.location.reload();

}
