//********************************************************************************************
//FUNCTION CREATE
//********************************************************************************************
function create()
{
	alert("Create");
//window.commontoolbarFrame.document.forms[0].apply.style.display='block';
window.f_query_add_mod.location.href="../../eXH/jsp/QueryBuilderSelectMaster.jsp?mode=I";		
window.messageFrame.location.href="../../eCommon/html/blank.html";

}
//********************************************************************************************
//FUNCTION QUERY
//********************************************************************************************
function query()
{
		//window.commontoolbarFrame.document.forms[0].apply.style.display='none';
		window.f_query_add_mod.location.href="../../eXH/jsp/.jsp";		
		window.messageFrame.location.href="../../eCommon/html/blank.html";

}
//********************************************************************************************
//FUNCTION DELETE
//********************************************************************************************
function deleterecord()
{
//		alert("Delete");
		window.f_query_add_mod.document.forms[0].act_mode.value = 'D';
//		if (confirm(getMessage("DELETE_RECORD"))){
//			alert("Conf Del ");
			apply();
//		}
}
//********************************************************************************************
//FUNCTION APPLY()
//********************************************************************************************
function apply()
{

		//	window.f_query_add_mod.document.forms[0].submit();
	
//window.commontoolbarFrame.document.location.reload();
}
//********************************************************************************************
//FUNCTION RESET 
//********************************************************************************************
function reset()
{

	
	if(window.f_query_add_mod.document.forms[0])
    {
	 window.f_query_add_mod.document.forms[0].reset();
	}
}
/*
//********************************************************************************************
//function getQuery
//*******************************************************************************************
function getQuery(){
 

 alert("Table Selctd : "+this.document.forms[0].table_nam.value);
//	var colObj = this.document.forms[0].col_name;
//	alert("Selected Items Cnt : "+colObj.Items.Count); 
 
	var tab_name=this.document.forms[0].table_nam.value;

//	var whereClause = this.document.forms[0].whereClause.value;
	var qry = "Select ";
	var colVals = "";
	for(int i=0;i<=colObj.Items.Count-1;i++)
	{
		if(colObj.Items(i).Selected){
			alert("Col Selctd : "+colObj.Items(i).Text);
			colVals	= colObj.Items(i).Text+",";
		}
	}
	alert("colVals : "+colVals);
	qry	=	qry+colVals+"from "+tab_name;
	alert("final qry : "+qry);

	this.document.forms[0].queryText.value = qry;


}
*/

//********************************************************************************************
//function funSubmit
//*******************************************************************************************
function funSubmit()
{
	/*
	// #MOD#01
	var act = '../../eXH/jsp/DataGroupDetailsQueryResult.jsp';
	this.document.forms[0].action = act;
	this.document.forms[0].submit();
	*/
}
//*******************************************************************************************
//function funModify
//*******************************************************************************************

function funModify(obj)
{
	/*
	// #MOD#02
	parent.commontoolbarFrame.document.forms[0].apply.style.display='block';

//	alert("fn mdfy dg_code : "+obj.getAttribute('dg_code'));
//	alert("fn mdfy application_id : "+obj.getAttribute('application_id'));
//	alert("fn mdfy application_name : "+obj.getAttribute('application_name'));
//	alert("fn mdfy facility_id : "+obj.getAttribute('facility_id'));
//	alert("fn mdfy facility_name : "+obj.getAttribute('facility_name'));
//	alert("fn mdfy protocol_link_id : "+obj.getAttribute('protocol_link_id'));
//	alert("fn mdfy protocol_linkName : "+obj.getAttribute('protocol_linkName'));


//	this.document.forms[0].lang_id.value = obj.getAttribute('lang_id');
	var act = '../../eXH/jsp/DataGroupDetailsSelectMaster.jsp';
	this.document.forms[0].action = act;
	this.document.forms[0].submit();
	*/
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
