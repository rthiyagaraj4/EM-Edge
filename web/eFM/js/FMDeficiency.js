function create()
{
	f_query_add_mod.location.href = '../../eFM/jsp/FMDeficiencyAddModify.jsp?operation=insert' ;
	var msg="";
	//frames[2].location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=" + msg;
	messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=" + msg;	
}

function reset()
{
    if(f_query_add_mod.document.location.href.indexOf("FMDeficiencyQueryResult.jsp") != -1)
		return false;
	else 
		f_query_add_mod.location.reload() ;
}

function checkIsValidForProceed()
{
	 var url = f_query_add_mod.location.href; 	
	 url = url.toLowerCase();
	 if ( (url.indexOf("blank.html")==-1) && (url.indexOf("deficiencyquery")==-1) )  {			 
		return true;
	 } else {	 		 
		return false;
	 }
}

function query() 
{
	var msg="";
	frames[2].location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=" + msg;	
	f_query_add_mod.location.href ="../../eFM/jsp/FMDeficiencyQueryCriteria.jsp?operation=modify" ;
}

function apply() 
{
	if (! (checkIsValidForProceed()) )
    {
        frames[2].location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
        return false;
    }

	var x=f_query_add_mod.location.href;
	if (parseInt(x.indexOf("blank.html"))!=-1)
	{
		frames[2].location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=" + "";	
		return false;
	}

	var fields1			=	new Array(f_query_add_mod.document.FMDeficiencyForm.deficiency_code);
	var names1			=	new Array(getLabel('Common.code.label','common'));
	//var messageFrame1	=	parent.frames[1].frames[2];
	var messageFrame1	=	frames[2];
	var error_page1		=	'../../eCommon/jsp/MstCodeError.jsp';
	

	if(SpecialCharCheck(fields1,names1,messageFrame1,"M", error_page1))
	{
		var fields = new Array ( f_query_add_mod.document.FMDeficiencyForm.deficiency_code,
				 f_query_add_mod.document.FMDeficiencyForm.long_desc,
				 f_query_add_mod.document.FMDeficiencyForm.short_desc);

		var names = new Array ( getLabel('Common.code.label','common'),
				getLabel('Common.longdescription.label','common'),
				getLabel('Common.shortdescription.label','common')); 

		if (!f_query_add_mod.checkFieldsofMst( fields, names, frames[2])) 
			return false;
		else
			f_query_add_mod.document.FMDeficiencyForm.submit();
	}
}

function onSuccess()
{
	//parent.frames[1].frames[1].document.location.reload();
	frames[1].document.location.reload();
}


