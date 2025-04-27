function apply()
{
	
parent.frames[1].frames[1].frames[1].document.forms[0].action="../../servlet/eOP.ProcUnitCatalogServlet";
parent.frames[1].frames[1].frames[1].document.forms[0].target="messageFrame";
parent.frames[1].frames[1].frames[1].document.forms[0].submit();
}

var nur_unit_desc="";

function create() {

	f_query_add_mod.location.href = "../../eOP/jsp/ProcUnitCatalogMain.jsp?param=create&called_from=1" ;
}

function query() {
	f_query_add_mod.location.href ="../../eOP/jsp/ProcUnitCatalogCriteria.jsp" ;
}

function reset()
{
	var loc=frames[1].document.forms[0]

	if (loc!=null )
	{
			f_query_add_mod.document.forms[0].reset();
	}
	else if(frames[1].frames[0])
	{
		create();
	}
}

function onSuccess() {
		parent.frames[1].frames[1].frames[1].location.href='../../eCommon/html/blank.html';
		parent.frames[1].frames[1].frames[0].location.reload();
}

//////////////////
var effStatus= new Array();

var temp='';
function finalSelect(Obj1,Obj2)
{
	var temp2='';
	if(Obj1.checked)
	{
	temp2=Obj1.name+"$"+Obj2.name+"$"+Obj1.value+"$"+Obj2.value
	temp+=temp2+"`"
	
	parent.frames[1].document.forms[0].finalSelectedValues.value=temp;
	}
}
