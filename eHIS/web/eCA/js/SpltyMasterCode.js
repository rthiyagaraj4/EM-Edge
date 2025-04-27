function create()
{
	f_query_add_mod.location.href='../../eCA/jsp/SpltyMasterCodeMain.jsp';
}
function reset()
{
	f_query_add_mod.frames[0].document.forms[0].reset();
	f_query_add_mod.detailFrame.location.href="../../eCommon/html/blank.html";
	f_query_add_mod.addModifyFrame.location.href="../../eCommon/html/blank.html";
}
function getDetails(code)
{
	if(code.value != '' && code.value != undefined)
	{
		parent.detailFrame.location.href="../../eCA/jsp/SpltyMasterCodeDtl.jsp?mast_type_ref="+code.value+"&callFrom=header";
		parent.addModifyFrame.location.href="../../eCA/jsp/SpltyMasterCodeAddModify.jsp?mast_type_ref="+code.value;
	}
	else
	{
		parent.detailFrame.location.href="../../eCommon/html/blank.html";
		parent.addModifyFrame.location.href="../../eCommon/html/blank.html";
	}
}
function apply()
{
	if(f_query_add_mod.headerFrame !=null)
	{
		if(f_query_add_mod.headerFrame.document.SpltyMasterCodeHdrForm !=null && f_query_add_mod.detailFrame.document.SpltyMasterCodeDtlForm !=null)
		{
			if(f_query_add_mod.detailFrame.document.SpltyMasterCodeDtlForm.total.value != 0)
			{
				f_query_add_mod.detailFrame.document.SpltyMasterCodeDtlForm.submit();
			}
			else
			{
				messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
				return false;
			}
		}
		else
		{
			messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
			return false;
		}
	}
	else
	{
		messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
		return false;
	}
}
function onSuccess()
{
	f_query_add_mod.addModifyFrame.location.reload();
}
function loadPage(i,j)
{
	var code = eval("document.SpltyMasterCodeDtlForm.code"+i+".value");
	var shortDesc = eval("document.SpltyMasterCodeDtlForm.shortDesc"+i+".value");
	var longDesc = eval("document.SpltyMasterCodeDtlForm.longDesc"+i+".value");
	var effStatus = eval("document.SpltyMasterCodeDtlForm.effStatus"+i+".value");
	var mast_type_ref = document.SpltyMasterCodeDtlForm.mast_type_ref.value
	parent.addModifyFrame.location.href="../../eCA/jsp/SpltyMasterCodeAddModify.jsp?splty_mst_code="+code+"&shortDesc="+shortDesc+"&longDesc="+longDesc+"&effStatus="+effStatus+"&mast_type_ref="+mast_type_ref+"&mode=upadte&clearvalue="+j;
}
function addPanel()
{
	var code = document.SpltyMasterCodeAddForm.code;
	var longDesc = document.SpltyMasterCodeAddForm.longDesc;
	var shortDesc = document.SpltyMasterCodeAddForm.shortDesc;
	if(document.SpltyMasterCodeAddForm.enabled.checked == true)
		document.SpltyMasterCodeAddForm.enabled.value = 'E';
	else
		document.SpltyMasterCodeAddForm.enabled.value = 'D';

	var fields	=	new Array ( code, longDesc, shortDesc );
	var names	=	new Array ( getLabel("Common.code.label",'COMMON'), getLabel("Common.longdescription.label",'COMMON'), getLabel("Common.shortdescription.label",'COMMON') );
	

	if(checkFieldsofMst(fields,names,parent.parent.messageFrame))
	{
		parent.detailFrame.location.href = "../../eCA/jsp/SpltyMasterCodeDtl.jsp?code="+code.value+"&longDesc="+longDesc.value+"&shortDesc="+shortDesc.value+"&eff_status="+document.SpltyMasterCodeAddForm.enabled.value+"&mast_type_ref="+document.SpltyMasterCodeAddForm.mast_type_ref.value+"&callFrom=addModify&mode="+document.SpltyMasterCodeAddForm.mode.value+"&clearvalue="+document.SpltyMasterCodeAddForm.clearvalue.value;
		parent.addModifyFrame.location.href = "../../eCA/jsp/SpltyMasterCodeAddModify.jsp?mode=insert&mast_type_ref="+document.SpltyMasterCodeAddForm.mast_type_ref.value;
	}
}
function onClear()
{
	parent.addModifyFrame.location.href = "../../eCA/jsp/SpltyMasterCodeAddModify.jsp?mode=insert&mast_type_ref="+document.SpltyMasterCodeAddForm.mast_type_ref.value;
}

function changeCase(obj)
{
	document.SpltyMasterCodeAddForm.code.value=obj.value.toUpperCase();
}
