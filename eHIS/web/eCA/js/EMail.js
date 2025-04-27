var messageFrameReference = parent.parent.messageFrame;
function openEmail(module_id,report_id){
	var title			= getLabel("eCA.Email.label","CA");
	var action_url		=	'../../eCA/jsp/EMail.jsp';
	action_url			+=	"?title="+encodeURIComponent(title,"UTF-8")+"&module_id="+module_id+"&report_id="+report_id;	window.open(action_url,'Document','height=570,width=790,top=0,left=0,resizable=yes,scrollbars=yes');
	
}

/*Modified by Deepa 8/6/2008 10:35 AM start*/
async function getRegRecpts(obj)
{
	var patient_id = document.forms[0].patient_id.value;
	var encounter_id = document.forms[0].encounter_id.value;
	var email_to_any_id_yn = document.forms[0].email_to_any_id_yn.value;
	var email_to_regd_id_yn = document.forms[0].email_to_regd_id_yn.value;
	var email_to_pat_id_yn = document.forms[0].email_to_pat_id_yn.value;

	var title			= '';
	if(obj.id == 'toLookup') title = 'To';
	else title = 'Cc';
	var dialogHeight	= '37.5vh' ;
	var dialogWidth		= '50vw' ;
	var dialogTop		= '30';
	var dialogLeft		= '100' ;

	var features		= 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=yes; status=no';

	var retVal = await window.showModalDialog("../../eCA/jsp/EMailPatAdhRegMain.jsp?title="+title+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&email_to_pat_id_yn="+email_to_pat_id_yn+"&email_to_regd_id_yn="+email_to_regd_id_yn+"&email_to_any_id_yn="+email_to_any_id_yn,'',features);

	if(retVal != null && retVal != undefined)
	{
		var newRetVal = retVal.split("$^");
		if(obj.id == 'toLookup') document.forms[0].to_emailId.value = newRetVal[0];
		else document.forms[0].cc_emailId.value = newRetVal[0];
		if(obj.id == 'toLookup')
		{
			document.forms[0].mailToType.value = newRetVal[1];
			if(newRetVal[1] == 'R')
			{
				//alert(newRetVal[2]);
				document.forms[0].to_id.value = newRetVal[2];
			}
			else if(newRetVal[1] == 'A' || newRetVal[1] == 'P')
			{
				document.forms[0].password.value = patient_id;
			}

			openEditor(document.EMailHdrForm);			
		}
	}
}
/*Modified by Deepa 8/6/2008 10:35 AM end*/

function openEditor(formObj){
	//if((formObj.module_id.value!="") && (formObj.report_id.value!="")) {

		var email_to_pat_id_yn = formObj.email_to_pat_id_yn.value;
		var email_to_regd_id_yn = formObj.email_to_regd_id_yn.value;
		var email_to_any_id_yn = formObj.email_to_any_id_yn.value;
		var to_id = formObj.to_id.value;

		if(email_to_pat_id_yn == 'Y' && email_to_regd_id_yn == 'N' && email_to_any_id_yn == 'N')
			parent.emailFrameSetID.rows = '18%,60%,7%,14%,0%';
		else
			parent.emailFrameSetID.rows = '25%,60%,7%,14%,0%';

		var encounter_id = formObj.encounter_id.value;
		var patient_id = formObj.patient_id.value;
		var mailToType = formObj.mailToType.value;
		var disclaimerId = formObj.disclaimerId.value;

		parent.EMailEdtrFrame.location.href="../../eCA/jsp/RTEditor.jsp?call_from=Clinical_Event";
		parent.EMailEdtrBttnFrame.location.href = "EMailEdtrBtn.jsp?module_id="+formObj.module_id.value+"&report_id="+formObj.report_id.value+"&beanKey="+encodeURIComponent(formObj.beanKey.value,"UTF-8")+"&encounter_id="+encounter_id+"&patient_id="+patient_id+"&to_id="+to_id+"&mailToType="+mailToType;
		parent.EMailBtmFrame.location.href = "../../eCA/jsp/EMailBtm.jsp?module_id="+formObj.module_id.value+"&report_id="+formObj.report_id.value+"&disclaimerId="+disclaimerId;
		

		


	
	 //} 
}
function setEditorTemplate(){
	// Setting the value to the editor.
	var RTEText = document.getElementById("RTEText").value;
	if(RTEText!="") {		
		
 		alert(getMessage("DO_WANT_VIEW","OR"));
		
			parent.EMailEdtrFrame.RTEditor0.document.body.innerHTML = RTEText;
		
	}
}
function showTable(){
  	var tab_dat  = "<table id='tooltiptable1' cellpadding=3 cellspacing=0 border='0' class='BOX' width='100%' height='100%' align='center'>"
 	tab_dat     += "<tr><td class='data' nowrap>"+getLabel("eCA.NoofRows.label","CA")+"</td><td class='fields'><input type='text' name='rows' id='rows' size='2' maxLength='2' value='5' onKeyPress='return CaAllowNumber()' onBlur='return CaCheckNumber(this)' ></td><td class='data' nowrap"+getLabel("eOR.NoofColumns.label","OR")+"</td><td class='fields'><input type='text' name='cols' id='cols' size='1' maxLength='1'  value='3' onKeyPress='return CaAllowNumber()' onBlur='return CaCheckNumber(this)' ></td>"
	tab_dat     += "<td class='label'><input type='button' class='button' name='ok' id='ok' value="+getLabel("Common.ok.label","Common")+" onClick='setBuildTable()'></td><td class='label'><input type='button' class='button' name='cancel' id='cancel' value="+getLabel("Common.cancel.label","Common")+" onClick='hideToolTip()'></td></tr> "
 	tab_dat     += "</table> "
	resizeWindow(tab_dat);

}

function CaAllowNumber() {
   var key = window.event.keyCode;
   if( ! ( ( key>=48 ) && ( key<58 ) ) ) {
       return false;
   }
}

function CaCheckNumber(obj) {
	var sequence = "0123456789";
	var obj_value = obj.value;
	var obj_length = obj_value.length;

	for (i=0; i<obj_length; i++)   {
		if(sequence.indexOf(obj_value.charAt(i))==-1){
			//alert("ONLY_POSITIVE_NUM");
			alert(parent.getMessage('ONLY_POSITIVE_NUM','OR'));
			obj.focus();
			return false;
		}
   }

   return true ;
}

function setBuildTable(){

	var rows = document.getElementById("rows").value;
	var cols = document.getElementById("cols").value;
	var table =  parent.EMailEdtrFrame.RTEditor0.document.getElementsByTagName("TABLE");
	var table_length = table.length;
   	if(rows > 0 && cols > 0) {
  		var htmlTable	= 	"<TABLE id='table"+table_length+"'  border=1 CELLPADDING='3' CELLSPACING='0' BORDERCOLOR='black' align=center>";
		for(i=0;i<rows;i++) {
			htmlTable	+= "<TR>";
			for(j=0;j<cols;j++) {
				htmlTable	+= "<TD></TD>";
			}
			htmlTable	+= "</TR>";
		}
		htmlTable+="</TABLE>";
	 	parent.EMailEdtrFrame.RTEditor0.document.body.insertAdjacentHTML("BeforeEnd",htmlTable);
		hideToolTip();

		document.getElementById("add_table").style.visibility = 'visible'
		document.getElementById("add_table_gif").style.visibility = 'visible'
		document.getElementById("delete_table").style.visibility = 'visible'	
		document.getElementById("delete_table_gif").style.visibility = 'visible'
	}
}


function hideToolTip()	{
	document.getElementById("tooltiplayer").style.visibility = 'hidden'
}

function addTable(){
	var tab_dat  = "<table id='tooltiptable1' cellpadding=3 cellspacing=0 border='0' class='BOX' width='100%' height='100%' align='center'>"
 	tab_dat     += "<tr><td class='data' nowrap>"+getLabel("eOR.TableNo.label","OR")+"</td><td class='fields'><input type='text' name='table_no' id='table_no' size='2' maxLength='2' value='' onKeyPress='return CaAllowNumber()' onBlur='return CaCheckNumber(this)' ><td class='data' nowrap>"+getLabel("eOR.RowNo.label","OR")+"</td><td class='fields'><input type='text' name='add_row' id='add_row' size='2' maxLength='2' value='2' onKeyPress='return CaAllowNumber()' onBlur='return CaCheckNumber(this)' ></td>"
	tab_dat		+="<td class='data' nowrap>"+getLabel("eOR.ColumnNo.label","OR")+"</td><td class='fields'><input type='text' name='add_columns' id='add_columns' size='1' maxLength='1' value='1' onKeyPress='return CaAllowNumber()' onBlur='return CaCheckNumber(this)' ></td>";
	tab_dat     += "<td class='fields'><input type='button' class='button' name='ok' id='ok' Value="+getLabel("Common.ok.label","Common")+" onClick='addTableRow()'></td><td class='label'><input type='button' class='button' name='cancel' id='cancel' Value="+getLabel("Common.cancel.label","Common")+" onClick='hideToolTip()'></td></tr> "
 	tab_dat     += "</table> "
	resizeWindow(tab_dat);	
}

function resizeWindow(tab_dat){
	document.getElementById("t").innerHTML					= tab_dat;
	document.getElementById("tooltiplayer").style.posLeft		= 202
	document.getElementById("tooltiplayer").style.posTop		= 0
	document.getElementById("tooltiplayer").style.visibility	='visible'
}

function addTableRow(){	
	hideToolTip();
	var table_no	= document.getElementById("table_no").value;
	if(table_no!="" && table_no!=0) {
 		table_no	= parseInt(table_no-1);
 	}	
	else
		table_no	= 0;
   	if(table_no>=0){
   		var rows		= document.getElementById("add_row").value;
		var cols		= document.getElementById("add_columns").value;
 		if(rows > 1) {
			rows	 = rows-1;
			if(cols!="" && cols>0)
				cols = parseInt(cols);
   	 		if(eval(parent.EMailEdtrFrame.RTEditor0.document.getElementById("table"+table_no)) && rows>0) {
				if(eval(parent.EMailEdtrFrame.RTEditor0.document.getElementById("table"+table_no).rows.length!=0))
	  				eval(parent.EMailEdtrFrame.RTEditor0.document.getElementById("table"+table_no).insertRow(rows));
			}
			for( j=0;j<cols;j++) {
				if(eval(parent.EMailEdtrFrame.RTEditor0.document.getElementById("table"+table_no)) && eval(parent.EMailEdtrFrame.RTEditor0.document.getElementById("table"+table_no).rows[rows]))
					eval(parent.EMailEdtrFrame.RTEditor0.document.getElementById("table"+table_no).rows[rows].insertCell());
	  		}
		}
	}
}


function deleteTable(){
	var tab_dat  = "<table id='tooltiptable1' cellpadding=3 cellspacing=0 border='0' class='BOX' width='100%' height='100%' align='center'>"
 	tab_dat     += "<tr><td class='data' nowrap>"+getLabel("eOR.TableNo.label","OR")+"</td><td class='fields'><input type='text' name='table_no' id='table_no' size='2' maxLength='2' value='1' onKeyPress='return CaAllowNumber()' onBlur='return CaCheckNumber(this)' ><td class='data' nowrap>"+getLabel("eOR.RowNotobedeleted.label","OR")+"</td><td class='fields'><input type='text' name='delete_row' id='delete_row' size='2' maxLength='2' value='1' onKeyPress='return CaAllowNumber()' onBlur='return CaCheckNumber(this)' ></td>"
	tab_dat     += "<td class='label'><input type='button' class='button' name='ok' id='ok' Value="+getLabel("Common.ok.label","Common")+" onClick='CAdeleteTableRow()'></td><td class='label'><input type='button' class='button' name='cancel' id='cancel' Value="+getLabel("Common.cancel.label","Common")+" onClick='hideToolTip()'></td></tr> "
 	tab_dat     += "</table> "
	resizeWindow(tab_dat);	
}

function CAdeleteTableRow(){
	hideToolTip();
	var table_no	= document.getElementById("table_no").value;
	if(table_no!="" && table_no!=0) {
 		table_no	= parseInt(table_no-1);
	}	
	else
		table_no	= 0;
	var rows = document.getElementById("delete_row").value;
	if(rows!="")
		rows = parseInt(rows) - 1;
	if(eval(parent.EMailEdtrFrame.RTEditor0.document.getElementById("table"+table_no)) && 	eval(parent.EMailEdtrFrame.RTEditor0.document.getElementById("table"+table_no).rows[rows]))
	{
		eval(parent.EMailEdtrFrame.RTEditor0.document.getElementById("table"+table_no).deleteRow(rows));
 		if(eval(parent.EMailEdtrFrame.RTEditor0.document.getElementById("table"+table_no).rows.length==0)){
			eval(parent.EMailEdtrFrame.RTEditor0.document.getElementById("table"+table_no).clear);
 		}
	}
}


// to set the value in the editor
 function setPrevTemplate(obj){
	if(obj!=null && obj!=""){
 		var new_value = "~"+obj+"`";     
  	    parent.EMailEdtrFrame.RTEditor0.document.body.focus();
		parent.EMailEdtrFrame.RTEditor0.document.clear();
  		var object_result = parent.EMailEdtrFrame.RTEditor0.document.execCommand("paste","",new_value);
 		if(!object_result)
			alert(getMessage("TRY_AFTER","OR"))
	}
 }

async function previewEditor(){
	var formObj			= parent.EMailHdrFrame.document.EMailHdrForm;
	RTEText					= parent.EMailEdtrFrame.RTEditor0.document.body.innerHTML
	
	//var xmlDoc 				= new ActiveXObject( "Microsoft.XMLDom" ) ;
	//var xmlHttp 			= new ActiveXObject( "Microsoft.XMLHTTP" ) ;
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc = "";
	xmlStr					= "<root><SEARCH " ;
	xmlStr					+= "html_format=\""+checkSpl(RTEText)+"\" ";
	xmlStr					+= "beanKey=\""+encodeURIComponent(formObj.beanKey.value,"UTF-8")+"\" ";
	xmlStr 			+=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "EMailIntermediate.jsp", false ) ;
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	eval( responseText ) ;

	if(RTEText!="") {
		var dialogHeight	= '32vh' ;
		var dialogWidth		= '50vw' ;
		var dialogTop		= '30';
		var dialogLeft		= '100' ;
		var title			= ''
		var features		= 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=yes; status=no';
		var retVals			=  await window.showModalDialog("../../eCA/jsp/EMailPrev.jsp?attchmnt=N&beanKey="+encodeURIComponent(formObj.beanKey.value,"UTF-8"),arguments,features);
	}
 }
 async function viewAttchmnt(){
	var formObj			= parent.EMailHdrFrame.document.EMailHdrForm;
	var p_report_type = formObj.p_report_type.value;
	var dialogHeight	= '37.5vh' ;
	var dialogWidth		= '50vw' ;
	var dialogTop		= '30';
	var dialogLeft		= '100' ;
	var title			= ''
	var features		= 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=yes; status=no';
	var retVals			=  await window.showModalDialog("../../eCA/jsp/EMailPrev.jsp?p_report_type="+p_report_type+"&attchmnt=Y&beanKey="+encodeURIComponent(formObj.beanKey.value,"UTF-8"),arguments,features);
}
function cancelRecord(){
	var formObj			= parent.EMailHdrFrame.document.EMailHdrForm;
	//var xmlDoc 				= new ActiveXObject( "Microsoft.XMLDom" ) ;
	//var xmlHttp 			= new ActiveXObject( "Microsoft.XMLHTTP" ) ;
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc = "";
	xmlStr					= "<root><SEARCH " ;
	xmlStr					+= "key=\"clearBean\" ";
	xmlStr					+= "beanKey=\""+encodeURIComponent(formObj.beanKey.value,"UTF-8")+"\" ";
	xmlStr 			+=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "EMailIntermediate.jsp", false ) ;
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	eval( responseText ) ;	
	parent.parent.window.close(); // changed by Deepa on 9/29/2008 at 4:19 PM
//	parent.window.close();	//parent.parent.f_query_add_mod.location.href='../../eCA/jsp/EMailTemp2?module_id=AE&report_id=AEBSTAT';
}
/*the below functions to be deleted later -after using this function in transactions***start***/

function create()	
{
	f_query_add_mod.location.href='../../eCA/jsp/EMailTemp2.jsp?module_id=AE&report_id=AEBSTAT';
}
function reset() 
{
	f_query_add_mod.location.href='../../eCA/jsp/EMail.jsp?module_id=AE&report_id=AEBSTAT';
}
function apply(){
	var formObj			= parent.EMailHdrFrame.document.EMailHdrForm;
	if(formObj.to_emailId.value==null || formObj.to_emailId.value=="" || formObj.to_emailId.value==''){
		alert(getMessage("EMAIL_ID_CANT_BE_BLANK","CA"));
		return;
	}
	else if(formObj.to_emailId.value == formObj.cc_emailId.value)
	{
		alert(getMessage("DUP_ENT_NOT_ALLOWED","CA"));
		return;
	}
	else
	{
		var mailToType = formObj.document.EMailHdrForm.mailToType.value;
		var verificationReqd = "";
		var confirm;
		if(mailToType == 'P')
			verificationReqd = formObj.document.EMailHdrForm.veryReqdYn.value;
		else if(mailToType == 'R')
			verificationReqd = formObj.document.EMailHdrForm.veryReqdRegdYn.value;
		else if(mailToType == 'A')
			verificationReqd = formObj.document.EMailHdrForm.veryReqdAdhocYn.value;

		formObj.document.EMailHdrForm.veryReqdYn.value = verificationReqd;

		if(verificationReqd == 'V')
			confirm = window.confirm(getMessage("AUTHORIZATION_REQD","CA"));

		if(confirm || verificationReqd != 'V')
		{
			RTEText					= parent.EMailEdtrFrame.RTEditor0.document.body.innerHTML
			var txtLen = RTEText.length;			
		//	alert("txtLen  :  "+txtLen);
			if (parseInt(txtLen) > 4000)
			{
				var msg = getMessage("REMARKS_CANNOT_EXCEED",'COMMON');
				msg = msg.replace("$",'Body content');
				msg = msg.replace("#",4000);
				alert(msg);				
				return;
			}else{					
				formObj.disclaimer.value=document.EMailBtmForm.disclaimer.value;			
				var xmlDoc 				= "";
				var xmlHttp 			= new XMLHttpRequest();
				xmlStr					= "<root><SEARCH " ;
				xmlStr					+= "html_format=\""+checkSpl(RTEText)+"\" ";
				xmlStr					+= "beanKey=\""+encodeURIComponent(formObj.beanKey.value,"UTF-8")+"\" ";
				xmlStr 					+=" /></root>" ;
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open( "POST", "EMailIntermediate.jsp", false ) ;
				xmlHttp.send( xmlDoc ) ;
				responseText=xmlHttp.responseText ;
				eval( responseText ) ;			
				formObj.submit();
			}
		}
		else
		{
			parent.window.close();
		}
	}
}



/*the below functions to be deleted later -after using this function in transactions***end***/


/* coded by Deepa on 8/6/2008 10:13 AM Start --- */
function insertAdh()
{
	var fields = new Array (document.patEMailAdhForm.mailer_id,document.patEMailAdhForm.mailer_name,document.patEMailAdhForm.email_id);
	var names = new Array (getLabel("eCA.RegisteredRecipientID.label",'CA'),getLabel("eCA.RegisteredRecipientName.label",'CA'),getLabel("eCA.EmailId.label",'CA'));
	if(checkFieldsofMst(fields,names,parent.emailRegBlankFrame)) 
	{
		document.patEMailAdhForm.method='post';
		document.patEMailAdhForm.action='../../servlet/eCA.RegEmailRecipientServlet?eff_status=E&mode=insert';
		document.patEMailAdhForm.target='emailRegBlankFrame';
		document.patEMailAdhForm.submit();
	}
}

function loadRegNames()
{
	var search_criteria = document.forms[0].search_criteria.value;
	var search_text = document.forms[0].search_text.value;
	var condition;
	if(document.getElementById("radSearch")[0].checked == true)
		condition = document.getElementById("radSearch")[0].value;
	else
		condition = document.getElementById("radSearch")[1].value;
	parent.emailRegDetailFrame.location.href = '../../eCA/jsp/EMailRegDetails.jsp?searchBase='+search_criteria+'&searchText='+search_text+'&condition='+condition;
}

function returnEMailId(objVal,mailerId)
{
	objVal = unescape(objVal);
	mailerId = unescape(mailerId);
	window.returnValue = objVal+"$^R$^"+mailerId;
	window.close();
}

function onSuccess()
{
	window.returnValue = parent.emailPatAdhFrame.document.patEMailAdhForm.email_id.value+"$^A";
	window.close();
}

function addPatMailId(emailID)
{
	emailID = unescape(emailID);
	window.returnValue = emailID+"$^P";
	window.close();
}

function clearDetails(obj)
{
	obj.value = "";
}
/* coded by Deepa on 8/6/2008 10:13 AM end --- */

