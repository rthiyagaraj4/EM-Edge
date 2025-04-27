function create()
{
	f_query_add_mod.location.href = '../../eFM/jsp/FMFileTransportModeAddModify.jsp?operation=insert' ;
	var msg="";
	parent.frames[1].frames[2].location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=" + msg;	
}

function reset()
{

			if(f_query_add_mod.document.forms[0].name == "FMFileTransportModeForm")
			{
				if(f_query_add_mod.document.FMFileTransportModeForm.operation.value =="insert")
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
	parent.frames[1].frames[2].location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=" + msg;	
	f_query_add_mod.location.href ="../../eFM/jsp/FMFileTransportModeQueryCriteria.jsp?operation=modify" ;
}

function apply() 
{
	var x=f_query_add_mod.location.href;
	if (parseInt(x.indexOf("blank.html"))!=-1)
	{
		parent.frames[1].frames[2].location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=" + "";	
		return false;
	}

	var fields1			=	new Array(f_query_add_mod.document.FMFileTransportModeForm.file_transport_mode);
	var names1			=	new Array(getLabel("Common.FileTransportMode.label","common"));
	var messageFrame1	=	parent.frames[1].frames[2];
	var error_page1		=	'../../eCommon/jsp/MstCodeError.jsp';
	

	if(SpecialCharCheck(fields1,names1,messageFrame1,"M", error_page1))
	{
		var fields = new Array ( f_query_add_mod.document.FMFileTransportModeForm.file_transport_mode,
				 f_query_add_mod.document.FMFileTransportModeForm.long_desc,
				 f_query_add_mod.document.FMFileTransportModeForm.short_desc);

		var names = new Array ( getLabel('Common.mode.label','common'),
				getLabel('Common.longdescription.label','common'),
				getLabel('Common.shortdescription.label','common'));

		if (!f_query_add_mod.checkFields( fields, names, parent.frames[1].frames[2])) 
			return false;
		else
			f_query_add_mod.document.FMFileTransportModeForm.submit();
	}
} 

function onSuccess()
{
	parent.frames[1].frames[1].document.location.reload();

}


