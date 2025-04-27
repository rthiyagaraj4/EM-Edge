/*
	Developed By       :	Shyam Prasad.P
	Created on   	   :	09/02/2006
	Function		   :	Oraganization
*/
function show() {
   //	parent.parent.window.document.title = "Setup Patient Category" ;
}

function create() {
	//f_query_add_mod.location.href = "../../eMP/html/addPatientCategory.html" ;
	f_query_add_mod.location.href = "../../eMP/jsp/OrganizationFrame2.jsp" ;
	
}

function edit() {
//	formToolbarFrame.location.href = "formToolbar.html" ;
}

function query() {
	f_query_add_mod.location.href ="../../eMP/jsp/OraganizationQueryCriteria.jsp" ;
}

/*function query() {
	f_query_add_mod.location.href ="../jsp/qPatientCategory.jsp?function=patientcategory" ;
}
*/

function apply() {
	var msg="APP-MP021 Apply is not a valid function here";
	messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num= "+msg;
}

function reset() {
	/*if(parent.parent.frames[1].frames[0])
		parent.parent.frames[1].frames[0].reset() ;*/
	f_query_add_mod.location.reload();
}

function onSuccess() {

	//parent.frames[1].frames[1].frames[1].document.forms[0].org_id.value
	//parent.frames[1].frames[1].frames[0].location.reload();
}
function record1()
{
  var org_id=document.forms[0].org_id.value;
  var mode=document.forms[0].mode.value;
 
  if(document.forms[0].eff_status.checked==true)
     document.forms[0].eff_status.value="E";
  else
	  document.forms[0].eff_status.value="D";
    var fields = new Array ( document.forms[0].org_id,document.forms[0].org_name);
	var names = new Array (getLabel('eMP.OrganizationID.label','MP'), getLabel('Common.orgName.label','common'));
      if(parent.frames[0].checkFieldsofMst( fields, names, parent.parent.frames[2])){
		  document.forms[0].org_name.disabled=false;
		  document.forms[0].org_id.disabled=false;

      document.forms[0].submit();
	  //setTimeout('bb()',1500);
	 // if(mode!="update")
	//	  parent.frames[1].location.href="../../eMP/jsp/Organisationsub.jsp?org_id="+org_id;
	  }
}
function bb()
{
	 var org_id=document.forms[0].org_id.value;
	//parent.frames[2].location.href="../../eMP/jsp/OrganisationsubResult.jsp?org_id="+org_id;
	var mode=document.forms[0].mode.value;
	if(mode=="update")
	parent.frames[0].location.href="../../eMP/jsp/AddOrganization.jsp?org_id="+org_id+"&mode=update";
	else
		parent.frames[0].location.href="../../eMP/jsp/AddOrganization.jsp?org_id="+org_id+"&mode=insert";

}
function record2()
{
   var org_id=document.forms[0].org_id.value;
   var fields = new Array ( document.forms[0].org_id,document.forms[0].subunit_id,document.forms[0].subunit_desc,document.forms[0].subunit_contactname);
	var names = new Array (getLabel('Common.Organization.label','Common'), getLabel('eMP.SubUnitID.label','MP'), getLabel('Common.name.label','common') ,getLabel('Common.ContactName.label','common'));
    if(parent.frames[1].checkFieldsofMst( fields, names, parent.parent.frames[2])){
  document.forms[0].submit();
  //setTimeout('aa()',1500);
 
  }
	 
}
function aa()
{
	 var org_id=document.forms[0].org_id.value;
	parent.frames[2].location.href="../../eMP/jsp/OrganisationsubResult.jsp?org_id="+org_id;
	parent.frames[1].location.href="../../eMP/jsp/Organisationsub.jsp?org_id="+org_id+"&mode=insert";
}

/**
@ called when record is successfully inserted , comes during insertion of Organisation..mode=insert
*/
function chkorg_success( date)
{

	var org_id=parent.frames[1].frames[0].document.forms[0].org_id.value;
	var org_name=parent.frames[1].frames[0].document.forms[0].org_name.value;
	var obj=parent.frames[1].frames[0].document.forms[0].eff_status;
	parent.frames[1].frames[0].location.href="../eMP/jsp/AddOrganization.jsp?org_id="+org_id+"&mode=insert&recdis=Y";
	if(obj.checked==true){
	
	parent.frames[1].frames[1].location.href="../eMP/jsp/Organisationsub.jsp?org_id="+org_id+"&mode=insert&org_name="+org_name;
    }
	

	
	
	
}

/**
@ called when  error is encountered   during insertion of Organisation..mode=insert
*/
function chkorg_error( date)
{
	
	
}
/**
@ called when record is successfully updated , comes during Updation of Organisation..mode=update
*/
function chkorgupdate_success( date)
{
	
	var org_id=parent.frames[1].frames[0].document.forms[0].org_id.value;
    var org_name=parent.frames[1].frames[0].document.forms[0].org_name.value;
	var obj=parent.frames[1].frames[0].document.forms[0].eff_status;
	var eff_status='';
	if(obj.checked==true){
		eff_status='E';
      parent.frames[1].frames[1].document.forms[0].record1.disabled=false;
	  parent.frames[1].frames[1].document.forms[0].subunit_id.focus();
	}
	else{
         eff_status='D';
		 parent.frames[1].frames[1].document.forms[0].record1.disabled=true;
	}

    parent.frames[1].frames[1].document.forms[0].org_id.value=org_name;
   	parent.frames[1].frames[0].location.href="../eMP/jsp/AddOrganization.jsp?org_id="+org_id+"&mode=update";
	parent.frames[1].frames[2].location.href="../eMP/jsp/OrganisationsubResult.jsp?org_id="+org_id+"&org_name="+org_name;
	
}
//suborganisation
function chkorg_sub_success( date)
{

	var org_id=parent.frames[1].frames[1].document.forms[0].org_id_hd.value;
	var org_name=parent.frames[1].frames[1].document.forms[0].org_id.value;
	
	parent.frames[1].frames[2].location.href="../eMP/jsp/OrganisationsubResult.jsp?org_id="+org_id+"&org_name="+org_name;;
	parent.frames[1].frames[1].location.href="../eMP/jsp/Organisationsub.jsp?org_id="+org_id+"&mode=insert"+"&org_name="+org_name;
	
}

function chkorgupdate_sub_success( date)
{

	var org_id=parent.frames[1].frames[1].document.forms[0].org_id_hd.value;
	var org_name=parent.frames[1].frames[1].document.forms[0].org_id.value;
	
	parent.frames[1].frames[2].location.href="../eMP/jsp/OrganisationsubResult.jsp?org_id="+org_id+"&org_name="+org_name;
	parent.frames[1].frames[1].location.href="../eMP/jsp/Organisationsub.jsp?org_id="+org_id+"&mode=insert"+"&org_name="+org_name;
	
}

function chkorgupdate_sub_error( date)
{

	
}
function MPCheckNumber(obj) {
   var sequence = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789*_";
   var obj_value = obj.value;
   var obj_length = obj_value.length;

   for (i=0; i<obj_length; i++)   {
        if(sequence.indexOf(obj_value.charAt(i))==-1){

			var msg=getMessage("SPECIAL_CHARCTERS_NOT_ALLOWED","SM")
			alert(msg);
			obj.focus();
			obj.select();
			return false;
		}
   }

   return true ;
}

