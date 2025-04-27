function create()
{
	f_query_add_mod.location.href = '../../eFM/jsp/FMRequestModeAddModify.jsp?operation=insert' ;
	var msg="";
	parent.frames[2].frames[2].location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=" + msg;	

}

function reset()
{

			if(f_query_add_mod.document.forms[0].name == "FMRequestModeForm")
			{
				if(f_query_add_mod.document.FMRequestModeForm.operation.value =="insert")
				{
					f_query_add_mod.document.forms[0].reset();
				}
				else
				f_query_add_mod.document.forms[0].reset();
			}
			  
			if(f_query_add_mod.document.forms[0].name == "query_form")
			{
				f_query_add_mod.document.query_form.reset() ;
			}

}

function query() 
{
	var msg="";
	parent.frames[2].frames[2].location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=" + msg;	
	f_query_add_mod.location.href ="../../eFM/jsp/FMRequestModeQueryCriteria.jsp?operation=modify" ;
}

function apply() 
{
	var x=f_query_add_mod.location.href;
	if (parseInt(x.indexOf("blank.html"))!=-1 || parseInt(x.indexOf("QueryCriteria"))!=-1 || parseInt(x.indexOf("QueryResult"))!=-1)
	{
		parent.frames[2].frames[2].location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=" + "";	
		return false;
	}

	var fields1			=	new Array(f_query_add_mod.document.FMRequestModeForm.req_mode);
	var names1			=	new Array(getLabel('Common.RequestMode.label','Common'));
	var messageFrame1	=	parent.frames[2].frames[2];
	var error_page1		=	'../../eCommon/jsp/MstCodeError.jsp';
	

	if(SpecialCharCheck(fields1,names1,messageFrame1,"M", error_page1))
	{
		var fields = new Array ( f_query_add_mod.document.FMRequestModeForm.req_mode,
				 f_query_add_mod.document.FMRequestModeForm.long_desc,
				 f_query_add_mod.document.FMRequestModeForm.short_desc);

		var names = new Array ( getLabel('Common.mode.label','common'),
				getLabel('Common.longdescription.label','common'),
				getLabel('Common.shortdescription.label','common'));

	if (!f_query_add_mod.checkFieldsofMst( fields, names, parent.frames[2].frames[2])) 
			return false;
		else
			f_query_add_mod.document.FMRequestModeForm.submit();
	}
}

function onSuccess()
{
	parent.frames[2].frames[1].document.location.reload();

}


