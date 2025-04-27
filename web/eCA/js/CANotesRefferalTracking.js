function getSpecialty(specialtyObject)
{
	var target = "";
	if(specialtyObject.name=='spec_name' || specialtyObject.name=='spec_name_to' )
	{
		if(specialtyObject.name=='spec_name_to')
			target  = document.forms[0].spec_name_to;	
		else		
			target  = document.forms[0].spec_name;		
		if((target.value) == "null" || (target.value ==""))
		{
			if(specialtyObject.name=='spec_name_to' || specialtyObject.name=='spec_desc_search_to')
			{
				document.forms[0].to_specialty_code.value = 'ALL';
			}	
			else{
				document.forms[0].specialty_code.value = 'ALL';
			}
			return false;			
		}
		else
		{
			getSpecialtyWindow(specialtyObject);
		}
	}
	else if(specialtyObject.name=='spec_desc_search' || specialtyObject.name=='spec_desc_search_to')
	{	
		getSpecialtyWindow(specialtyObject);
	}
}
async function getSpecialtyWindow(specialtyObject)
{
		
		var target = "";
		var i = 0;
		var retVal			=  new String();
		
		var search_desc	= "";
		var title			= getLabel('Common.speciality.label','COMMON');
		if(specialtyObject.name=='spec_name_to' || specialtyObject.name=='spec_desc_search_to')
			target  = document.forms[0].spec_name_to;	
		else		
			target  = document.forms[0].spec_name;	
	
		var sql = "SELECT SPECIALITY_CODE code, LONG_DESC description  FROM AM_SPECIALITY WHERE EFF_STATUS='E' and upper( SPECIALITY_CODE) like upper(?) and  upper( LONG_DESC) like upper(?)"
		var argArray = new Array();
		var namesArray = new Array();
		var valuesArray = new Array();
		var datatypesArray = new Array();
		
		argArray[0] = sql;
		argArray[1] = namesArray;
		argArray[2] = valuesArray;
		argArray[3] = datatypesArray;
		argArray[4] = "1,2";
		argArray[5] =target.value;
		argArray[6] = DESC_LINK;
		argArray[7] = CODE_DESC;
		retArray = await CommonLookup( title, argArray );
		
		var ret1=unescape(retArray);
	 	arr=ret1.split(",");
	 	if(arr[1]==undefined) 
 		{
	 		arr[0]="";	
	 		arr[1]="";	
 		}
	 	
		if(retArray != null && retArray !="")	
		{
			if(specialtyObject.name=='spec_name_to' || specialtyObject.name=='spec_desc_search_to')
			{
				document.forms[0].spec_name_to.value = arr[1];
				document.forms[0].to_specialty_code.value = arr[0];
			}	
			else{
				document.forms[0].spec_name.value = arr[1];
				document.forms[0].specialty_code.value = arr[0];
			}
		}
		else
		{
			if(specialtyObject.name=='spec_name_to' || specialtyObject.name=='spec_desc_search_to')
			{
				document.forms[0].spec_name_to.value = '';//IN052859
				document.forms[0].to_specialty_code.value = 'ALL';
			}	
			else{
				document.forms[0].spec_name.value = '';//IN052859
				document.forms[0].specialty_code.value = 'ALL';
			}
		}
}

function populateLocation(location_type)
{
	if( location_type.value == "" ) 
	{
		clearSourceLocationList("document");
		document.refferal_note_search.SourceSearch.disabled=true;
		document.refferal_note_search.locn.disabled=true;
		document.refferal_note_search.locn.value="";
		document.refferal_note_search.locn_code.value="ALL";
	}
	else
	{
		document.refferal_note_search.SourceSearch.disabled=false;
		document.refferal_note_search.locn.disabled=false;
		document.refferal_note_search.locn.value="";
		document.refferal_note_search.locn_code.value="";
		if(location_type.value =="ALL")
		{
			document.refferal_note_search.locn_code.value="ALL";
			document.getElementById("imgmand").style.display = "none";
			document.refferal_note_search.SourceSearch.disabled=true;	
			document.refferal_note_search.locn.disabled=true;
		}	
		else
			document.getElementById("imgmand").style.display = "inline";
	}
}

function populateMoveLoaction1(target,code)
{
	if(target.value!="")
	{
		populateMoveLocation(target,code);
	}
	else
		document.refferal_note_search.locn_code.value="";//IN052859
}

async function populateMoveLocation(target,code)
{

	
	location_type=parent.refferalTrackingNotesSearch.document.refferal_note_search.location_type.value;

	if(location_type!='')
	{
		localeName=parent.refferalTrackingNotesSearch.document.refferal_note_search.localeName.value;
		var sql="";

		if(location_type=="C")
		{
			sql=parent.refferalTrackingNotesSearch.document.refferal_note_search.clinic_sql.value;
		}
		else if(location_type=="N")
		{
			sql=parent.refferalTrackingNotesSearch.document.refferal_note_search.nursing_sql.value;
		}
		else if(location_type=="R")
		{
			sql=parent.refferalTrackingNotesSearch.document.refferal_note_search.referral_sql.value;
		}

		sql=sql.replace('?',"'"+localeName+"'");
		var argumentArray  = new Array() ;
		var dataNameArray  = new Array() ;
		var dataValueArray = new Array() ;
		var dataTypeArray  = new Array() ;
		
		argumentArray[0]   =sql;
		
		argumentArray[1]   = dataNameArray ;
		argumentArray[2]   = dataValueArray ;
		argumentArray[3]   = dataTypeArray ;
		argumentArray[4]   = "1,2";
		argumentArray[5]   = target.value;
		argumentArray[6]   = CODE_LINK ;
		argumentArray[7]   = CODE_DESC ;

		retVal = await CommonLookup(getLabel("Common.SourceType.label","COMMON") , argumentArray );

		var ret1=unescape(retVal);
	 	arr=ret1.split(",");
	 	if(arr[1]==undefined) 
 		{
	 		arr[0]="";	
	 		arr[1]="";	
 		}
		if(retVal !=null && retVal != "")
		{
			code.value=arr[1];
			target.value=arr[0];	
		}
		else
		{
   			target.value = "";
   			code.value = "" ;
	
 		}
	}	
}


function clearSourceLocationList( docObj ) 
{	
	document.refferal_note_search.locn_code.value="";
	document.refferal_note_search.locn.value="";
}

async function callPatientSearch()
{
	var pat_id =  await PatientSearch();
	if(pat_id != null)
		document.getElementById("patientId").value = pat_id;
}

async function callpractSearchSpecimenSearch1(target,code)
{
	
	var argumentArray= new Array();
	var dataNameArray= new Array();
	var dataValueArray= new Array();
	var dataTypeArray= new Array();
	var localeName=refferal_note_search.localeName.value;
	var sql=refferal_note_search.specimen_Orderby_pract.value;
	sql=sql.replace('?',"'"+localeName+"'");
	
	argumentArray[0]   =sql;
	
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "1,2";
	argumentArray[5]   = target.value;
	argumentArray[6]   = CODE_LINK ;
	argumentArray[7]   = CODE_DESC ;

	retval= await CommonLookup(getLabel("Common.OrderingPractitioner.label","COMMON"),argumentArray);

	var ret1=unescape(retval);
 	arr=ret1.split(",");
 	if(arr[1]==undefined) 
		{
 		arr[0]="";	
 		arr[1]="";	
		}
 	
	if(retval !=null && retval != ""){
		code.value=arr[0];
		target.value=arr[1];
		
		}else{
   		target.value = "";
   		code.value = "ALL" ;
 	}
}

function populateValues(){
	
	var facility = document.getElementById("facility").value;
	var specialty_code = document.getElementById("specialty_code").value;
	var to_specialty_code = document.getElementById("to_specialty_code").value;
	var practitioner = document.getElementById("ordering_pract").value;
	var locn_code = document.getElementById("locn_code").value;
	var patientId = document.getElementById("patientId").value;
	var status = document.getElementById("status").value;
	var fromDate = document.getElementById("date_from").value;
	var toDate = document.getElementById("date_to").value;
	var forward_to_facility = document.getElementById("forward_to_facility").value;
	var logged_in_pract =  document.getElementById("logged_in_pract").value;
	var patientclass = document.getElementById("patientclass").value;
	var referral_status = document.getElementById("referral_status").value;
	var quertString  = "facility="+facility+"&specialty_code="+specialty_code+"&practitioner="+practitioner+"&locn_code="+locn_code+"&patientId="+patientId+"&status="+status+"&fromDate="+fromDate+"&toDate="+toDate+"&forward_to_facility="+forward_to_facility+"&patientclass="+patientclass+"&referral_status="+referral_status+"&to_specialty_code="+to_specialty_code;
	
	if(practitioner == logged_in_pract)
	{
		parent.refferalTrackingNotesPrint.document.getElementById("reviewNotes").style.display='inline';
	}
	else
	{
		parent.refferalTrackingNotesPrint.document.getElementById("reviewNotes").style.display='none';
	}
	if(fromDate == '' || toDate == '' || locn_code == '' )
	{
		alert(getMessage("ALL_MANDATORY_FIELDS",'eCommon'));
		return;
	}

	if(document.getElementById("referredFromData").value =="Y" && document.getElementById("referredToData").value=="Y")
	{	
		parent.document.getElementById("NotesRefferralTracking").cols="50%,50%";
		parent.refferalTrackingNotesRefferedFrom.document.location.href = "../../eCA/jsp/CANotesReferralTracking.jsp?"+quertString+"&called_from=REFERREDFROM";
		parent.refferalTrackingNotesRefferedTo.document.location.href = "../../eCA/jsp/CANotesReferralTracking.jsp?"+quertString+"&called_from=REFERREDTO";
	}
	else if (document.getElementById("referredFromData").value =="N" && document.getElementById("referredToData").value=="Y"){
		parent.document.getElementById("NotesRefferralTracking").cols="0%,100%";
		parent.refferalTrackingNotesRefferedFrom.document.location.href = "../../eCA/jsp/blank.jsp";
		parent.refferalTrackingNotesRefferedTo.document.location.href = "../../eCA/jsp/CANotesReferralTracking.jsp?"+quertString+"&called_from=REFERREDTO";
		parent.refferalTrackingNotesPrint.document.getElementById("reviewNotes").style.display='none';
	}
	else if ( document.getElementById("referredFromData").value =="Y" && document.getElementById("referredToData").value=="N")
	{
		parent.document.getElementById("NotesRefferralTracking").cols="100%,0%";
		parent.refferalTrackingNotesRefferedFrom.document.location.href = "../../eCA/jsp/CANotesReferralTracking.jsp?"+quertString+"&called_from=REFERREDFROM";
		parent.refferalTrackingNotesRefferedTo.document.location.href = "../../eCA/jsp/blank.jsp";
		
	}else
	{
		alert(getMessage("NEWBORN_DISPLAY_CRITERIA",'CA'));
	}
}

function checkRefferedFromToWinReqYN(obj){
	if(obj.name=="referredFromData"){
		if(obj.checked==true)
		{
			document.getElementById("referredFromData").value = "Y";
		}else{
			document.getElementById("referredFromData").value = "N";
			document.getElementById("referredFromData").checked = false;
		}
	}
	if(obj.name=="referredToData"){
		if(obj.checked==true)
		{
			document.getElementById("referredToData").value = "Y";
		}else{
			document.getElementById("referredToData").value = "N";
			document.getElementById("referredToData").checked = false;
		}
	}
}		

function displayDetails(index,called_from){
	var dispYN = "";
	var j = 0;
	if(null!=document.getElementById("rowIndex"+index))
	j = document.getElementById("rowIndex"+index).value;
	for(var i=0;i<j;i++)
	{
		if( document.getElementById("reviewNotes"+called_from+index+"_"+i).style.display=='none')
		{
			dispYN  = "";
		}
		else if ( document.getElementById("reviewNotes"+called_from+index+"_"+i).style.display=='')
		{
			dispYN  = "none";
		}
		document.getElementById("reviewNotes"+called_from+index+"_"+i).style.display=dispYN;
		if(null != document.getElementById("chk_"+index+"_"+i))
		{
			document.getElementById("chk_"+index+"_"+i).style.display=dispYN;
			document.getElementById("check"+index+"_"+i).style.display=dispYN;
		}
	}
	
}
function expandCollapseYN(called_from){
	var key =  document.getElementById("expandYN").value;
	var formobj;
	if(key=='EXPANDALL' || key == 'COLLAPSEALL')
	{
		if(called_from == 'REFERREDFROM')
			formobj = parent.refferalTrackingNotesRefferedFrom.document.notesRefferedFromForm;
		if(called_from == 'REFERREDTO')
			formobj = parent.refferalTrackingNotesRefferedTo.document.notesRefferedFromForm;
		var totalRec = eval("formobj.noofrec"+called_from).value;	
		for(var k=1;k<=totalRec;k++)
		{
			if(null!=eval("formobj.rowIndex"+k))
			{
				var val = eval("formobj.rowIndex"+k).value;
				for(var p=0;p<val;p++)
				{	
					if(key=='EXPANDALL')
					{
						dispYN  = "";
						document.getElementById("expandYN").value = "COLLAPSEALL";
					}
					else if(key=='COLLAPSEALL')
					{
						dispYN  = "none";
						document.getElementById("expandYN").value = "EXPANDALL";
					}
					
					document.getElementById("reviewNotes"+called_from+k+"_"+p).style.display=dispYN;
					
					if(null != document.getElementById("chk_"+k+"_"+p))
					{
						document.getElementById("chk_"+k+"_"+p).style.display=dispYN;
						document.getElementById("check"+k+"_"+p).style.display=dispYN;
					}
					
						
				}
			}
		}
	}
}

function record()
{
	var totalRec = eval("parent.refferalTrackingNotesRefferedFrom.document.notesRefferedFromForm.noofrecREFERREDFROM").value;//IN052855
	var data = "";	var j = 0;
	var data1 = "";
	for(var i=1;i<=totalRec;i++)
	{
		if(null!=eval("parent.refferalTrackingNotesRefferedFrom.document.notesRefferedFromForm.rowIndex"+i))
		{
			j = eval("parent.refferalTrackingNotesRefferedFrom.document.notesRefferedFromForm.rowIndex"+i).value;
		}
		for(var k=0;k<j;k++)
		{	
			var temp_ = ""+i+"_"+k;
			if(null!=eval("parent.refferalTrackingNotesRefferedFrom.document.notesRefferedFromForm.chk_"+temp_))
			{
				var object = eval("parent.refferalTrackingNotesRefferedFrom.document.notesRefferedFromForm.chk_"+temp_);
				var action_type = eval("parent.refferalTrackingNotesRefferedFrom.document.notesRefferedFromForm.actionType"+temp_);
				if(action_type.value == 'SN')
				{
					if(object.checked ==true){
						var temp = object.value;
						data1+=temp+"#";
					}
				}
				else
				{
					if(object.checked ==true){
						var temp = object.value;
						data+=temp+"#";
					}
				}
			}
		}
	}
	if(data == '' && data1 =='')
			alert(getMessage("MIN_ONE_ITEM_SEL_REQ",'CA'));
	 if(data1!='')
	{	
		parent.refferalTrackingNotesRefferedFrom.document.notesRefferedFromForm.final_values.value = data1;
		parent.refferalTrackingNotesRefferedFrom.document.notesRefferedFromForm.action = "../../servlet/eCA.SignNotesServlet";
		parent.refferalTrackingNotesRefferedFrom.document.notesRefferedFromForm.submit();
		
		
	}
	 if(data!='')
	{
		parent.refferalTrackingNotesRefferedFrom.document.notesRefferedFromForm.final_values.value = data;
		parent.refferalTrackingNotesRefferedFrom.document.notesRefferedFromForm.action = "../../servlet/eCA.ReviewNotesServlet";
		parent.refferalTrackingNotesRefferedFrom.document.notesRefferedFromForm.submit();
	
	}
}

async function callSendBackWindow(obj,index,dateIndex,check)		
{
	if((obj.checked && check=="Request")||(obj.checked && check=="Forwarded to Specialty"))
	{	
		var conf = confirm(getMessage("RVT_BAK_WITH_CMTS",'CA'));
		if(conf)
		{
			var dialogHeight= "11" ;
			var dialogWidth	= "22" ;
			var dialogTop	= "180" ;
			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; dialogTop:"+dialogTop+"; scroll=no; status:no";
		    retVal = await window.showModalDialog("../../eCA/jsp/ReviewNotesResponseRemarkWindow.jsp",arguments,features);
			if(retVal != null && retVal != '' && retVal != undefined)
			{
				var chkIndex = ""+index+"_"+dateIndex;
				var object = eval("parent.refferalTrackingNotesRefferedFrom.document.notesRefferedFromForm.chk_"+chkIndex);
				var temp = object.value;
				parent.refferalTrackingNotesRefferedFrom.document.notesRefferedFromForm.final_values.value = temp+"#";
				parent.refferalTrackingNotesRefferedFrom.document.notesRefferedFromForm.remarks.value = retVal;
				parent.refferalTrackingNotesRefferedFrom.document.notesRefferedFromForm.action = "../../servlet/eCA.ReviewNotesResponseServlet";
				parent.refferalTrackingNotesRefferedFrom.document.notesRefferedFromForm.submit();
				
			}		
		}
	}
}

function printData()
{	
	var facility = parent.refferalTrackingNotesSearch.document.getElementById("facility").value;
	var facility_From_Name = parent.refferalTrackingNotesSearch.document.getElementById("facility").options[parent.refferalTrackingNotesSearch.document.getElementById("facility").selectedIndex].text;	
	var facility_To_Name = parent.refferalTrackingNotesSearch.document.getElementById("forward_to_facility").options[parent.refferalTrackingNotesSearch.document.getElementById("forward_to_facility").selectedIndex].text;
	
	var specialty_code = parent.refferalTrackingNotesSearch.document.getElementById("specialty_code").value;
	var specialty_name = parent.refferalTrackingNotesSearch.document.getElementById("spec_name").value;
	var toSpecialty_name = parent.refferalTrackingNotesSearch.document.getElementById("spec_name_to").value;  //IN052857
	var practitioner = parent.refferalTrackingNotesSearch.document.getElementById("ordering_pract").value;
	var practitioner_name = parent.refferalTrackingNotesSearch.document.getElementById("ordering_pract_desc").value;
	var locn_code = parent.refferalTrackingNotesSearch.document.getElementById("locn_code").value;

	var patientId = parent.refferalTrackingNotesSearch.document.getElementById("patientId").value;
	var status = parent.refferalTrackingNotesSearch.document.getElementById("status").value;
	var fromDate = parent.refferalTrackingNotesSearch.document.getElementById("date_from").value;
	var toDate = parent.refferalTrackingNotesSearch.document.getElementById("date_to").value;
	var dispCriteriaFrom = parent.refferalTrackingNotesSearch.document.getElementById("referredFromData").value;
	var dispCriteriaTo = parent.refferalTrackingNotesSearch.document.getElementById("referredToData").value;
	var forward_to_facility = parent.refferalTrackingNotesSearch.document.getElementById("forward_to_facility").value;
	var patientclass = parent.refferalTrackingNotesSearch.document.getElementById("patientclass").value;
	var patientclassName = parent.refferalTrackingNotesSearch.document.getElementById("patientclass").options[parent.refferalTrackingNotesSearch.document.getElementById("patientclass").selectedIndex].text; // IN052857
	var noteStatusName = parent.refferalTrackingNotesSearch.document.getElementById("status").options[parent.refferalTrackingNotesSearch.document.getElementById("status").selectedIndex].text; // IN052857
	var refferalStatusName = parent.refferalTrackingNotesSearch.document.getElementById("referral_status").options[parent.refferalTrackingNotesSearch.document.getElementById("referral_status").selectedIndex].text; // IN052857
	var referral_status = parent.refferalTrackingNotesSearch.document.getElementById("referral_status").value;
	var to_specialty_code = parent.refferalTrackingNotesSearch.document.getElementById("to_specialty_code").value;
	var location_type = parent.refferalTrackingNotesSearch.document.getElementById("location_type").value;
	var locationName ="";
	if(location_type=="ALL"){
		locationName = "ALL";
	}else{
		locationName = parent.refferalTrackingNotesSearch.document.getElementById("location_type").options[parent.refferalTrackingNotesSearch.document.getElementById("location_type").selectedIndex].text;
		if((parent.refferalTrackingNotesSearch.document.getElementById("locn_code").value)!="ALL"){
		locationName = locationName+" - "+parent.refferalTrackingNotesSearch.document.getElementById("locn").value;
		}
	}
	var dateIndexDisplay ="";
	var totalRec = "";
	
	var form = document.createElement("form");
		form.setAttribute("method", "post");
		form.setAttribute("action", "../../eCA/jsp/CANotesReferralTrackingPrint.jsp");
		form.setAttribute("target", "view");
	
	if(dispCriteriaFrom == 'Y')
	{
		formobj = parent.refferalTrackingNotesRefferedFrom.document.notesRefferedFromForm;
		totalRec = eval("formobj.noofrecREFERREDFROM").value;
		for(var k=1;k<=totalRec;k++)
		{
			if(null!=eval("formobj.rowIndex"+k))
			{
				var val = eval("formobj.rowIndex"+k).value;
				for(var p=0;p<val;p++)
				{	
					//dateIndexDisplay = dateIndexDisplay+"&reviewNotesREFERREDFROM"+k+p+"="+formobj.document.getElementById("reviewNotesREFERREDFROM"+k+p).style.display;
					var hiddenField = document.createElement("input"); 
						hiddenField.setAttribute("type", "hidden");
						hiddenField.setAttribute("name", "reviewNotesREFERREDFROM"+k+"_"+p);
						hiddenField.setAttribute("value", parent.refferalTrackingNotesRefferedFrom.document.getElementById("reviewNotesREFERREDFROM"+k+"_"+p).style.display);
						form.appendChild(hiddenField);
				}
			}
		}
	}
	if(dispCriteriaTo == 'Y')
	{
		formobj = parent.refferalTrackingNotesRefferedTo.document.notesRefferedFromForm;
		totalRec = eval("formobj.noofrecREFERREDTO").value;
		for(var k=1;k<=totalRec;k++)
		{
			if(null!=eval("formobj.rowIndex"+k))
			{
				var val = eval("formobj.rowIndex"+k).value;
				for(var p=0;p<val;p++)
				{	
					//dateIndexDisplay = dateIndexDisplay+"&reviewNotesREFERREDTO"+k+p+"="+formobj.document.getElementById("reviewNotesREFERREDTO"+k+p).style.display;
					var hiddenField = document.createElement("input"); 
						hiddenField.setAttribute("type", "hidden");
						hiddenField.setAttribute("name", "reviewNotesREFERREDTO"+k+"_"+p);
						hiddenField.setAttribute("value", parent.refferalTrackingNotesRefferedFrom.document.getElementById("reviewNotesREFERREDTO"+k+'_'+p).style.display);
						form.appendChild(hiddenField);
				}
			}
		}
	}
	var hF = 	document.createElement("input"); 
				hF.setAttribute("type", "hidden");
				hF.setAttribute("name", "facility");
				hF.setAttribute("value", facility);
				form.appendChild(hF);
	var hF1 = 	document.createElement("input"); 
				hF1.setAttribute("type", "hidden");
				hF1.setAttribute("name", "");
				hF1.setAttribute("value", "");
				form.appendChild(hF1);
	var hF2 = 	document.createElement("input"); 
				hF2.setAttribute("type", "hidden");
				hF2.setAttribute("name", "specialty_code");
				hF2.setAttribute("value", specialty_code);
				form.appendChild(hF2);
	var hF3 = 	document.createElement("input"); 
				hF3.setAttribute("type", "hidden");
				hF3.setAttribute("name", "practitioner");
				hF3.setAttribute("value", practitioner);
				form.appendChild(hF3);
	var hF4 = 	document.createElement("input"); 
				hF4.setAttribute("type", "hidden");
				hF4.setAttribute("name", "locn_code");
				hF4.setAttribute("value", locn_code);
				form.appendChild(hF4);
	var hF5 = 	document.createElement("input"); 
				hF5.setAttribute("type", "hidden");
				hF5.setAttribute("name", "patientId");
				hF5.setAttribute("value", patientId);
				form.appendChild(hF5);
	var hF6 = 	document.createElement("input"); 
				hF6.setAttribute("type", "hidden");
				hF6.setAttribute("name", "status");
				hF6.setAttribute("value", status);
				form.appendChild(hF6);
	var hF7 = 	document.createElement("input"); 
				hF7.setAttribute("type", "hidden");
				hF7.setAttribute("name", "fromDate");
				hF7.setAttribute("value", fromDate);
				form.appendChild(hF7);
	var hF8 = 	document.createElement("input"); 
				hF8.setAttribute("type", "hidden");
				hF8.setAttribute("name", "toDate");
				hF8.setAttribute("value", toDate);
				form.appendChild(hF8);
	var hF9 = 	document.createElement("input"); 
				hF9.setAttribute("type", "hidden");
				hF9.setAttribute("name", "specialty_name");
				hF9.setAttribute("value", encodeURIComponent(specialty_name));
				form.appendChild(hF9);
	var hF10 = 	document.createElement("input"); 
				hF10.setAttribute("type", "hidden");
				hF10.setAttribute("name", "toSpecialty_name");
				hF10.setAttribute("value", encodeURIComponent(toSpecialty_name));
				form.appendChild(hF10);
	var hF11 = 	document.createElement("input"); 
				hF11.setAttribute("type", "hidden");
				hF11.setAttribute("name", "practitioner_name");
				hF11.setAttribute("value", encodeURIComponent(practitioner_name));
				form.appendChild(hF11);
	var hF12 = 	document.createElement("input"); 
				hF12.setAttribute("type", "hidden");
				hF12.setAttribute("name", "dispCriteriaFrom");
				hF12.setAttribute("value", dispCriteriaFrom);
				form.appendChild(hF12);
	var hF13 = 	document.createElement("input"); 
				hF13.setAttribute("type", "hidden");
				hF13.setAttribute("name", "dispCriteriaTo");
				hF13.setAttribute("value", dispCriteriaTo);
				form.appendChild(hF13);
	var hF14 = 	document.createElement("input"); 
				hF14.setAttribute("type", "hidden");
				hF14.setAttribute("name", "facility_From_Name");
				hF14.setAttribute("value", encodeURIComponent(facility_From_Name));
				form.appendChild(hF14);
	var hF15 = 	document.createElement("input"); 
				hF15.setAttribute("type", "hidden");
				hF15.setAttribute("name", "facility_To_Name");
				hF15.setAttribute("value", encodeURIComponent(facility_To_Name));
				form.appendChild(hF15);
	var hF16 = 	document.createElement("input"); 
				hF16.setAttribute("type", "hidden");
				hF16.setAttribute("name", "forward_to_facility");
				hF16.setAttribute("value", forward_to_facility);
				form.appendChild(hF16);
	var hF17 = 	document.createElement("input"); 
				hF17.setAttribute("type", "hidden");
				hF17.setAttribute("name", "patientclass");
				hF17.setAttribute("value", patientclass);
				form.appendChild(hF17);
	var hF18 = 	document.createElement("input"); 
				hF18.setAttribute("type", "hidden");
				hF18.setAttribute("name", "patientclassName");
				hF18.setAttribute("value", patientclassName);
				form.appendChild(hF18);
	var hF19 = 	document.createElement("input"); 
				hF19.setAttribute("type", "hidden");
				hF19.setAttribute("name", "referral_status");
				hF19.setAttribute("value", referral_status);
				form.appendChild(hF19);
	var hF20 = 	document.createElement("input"); 
				hF20.setAttribute("type", "hidden");
				hF20.setAttribute("name", "noteStatusName");
				hF20.setAttribute("value", noteStatusName);
				form.appendChild(hF20);
	var hF21 = 	document.createElement("input"); 
				hF21.setAttribute("type", "hidden");
				hF21.setAttribute("name", "locationName");
				hF21.setAttribute("value", encodeURIComponent(locationName));
				form.appendChild(hF21);
	var hF22 = 	document.createElement("input"); 
				hF22.setAttribute("type", "hidden");
				hF22.setAttribute("name", "refferalStatusName");
				hF22.setAttribute("value", refferalStatusName);
				form.appendChild(hF22);
	var hF23 = 	document.createElement("input"); 
				hF23.setAttribute("type", "hidden");
				hF23.setAttribute("name", "to_specialty_code");
				hF23.setAttribute("value", to_specialty_code);
				form.appendChild(hF23);
	
	document.body.appendChild(form);
	window.open('../../eCA/jsp/CANotesReferralTrackingPrint.jsp', 'view',"toolbar=no, directories=no, location=no, status=yes, menubar=no, resizable=yes, scrollbars=no, width=800, height=600");
	form.submit();
}

async function showNoteData(accession_num,from,no_modalval,encounter_id,contr_mod_accession_num,notestatus,note_group_desc)
{
	var dialogHeight	= "80vh" ;
	var dialogWidth		= "70vw" ;
	var status			= "no";
	var scroll			= "yes";
	var dialogTop		= "0";
	var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:"+ dialogTop + "; status:"+ status + "; scroll:"+ scroll;
	var no_modal=no_modalval;
	var function_id = "";
	var called_function_id="";
	if(from != 'DISCHARGE_SUMMARY')
	{
	var note_group=note_group_desc;
	accession_num=accession_num;	
	}
	var retval = await top.window.showModalDialog('../../eCA/jsp/ViewClinicalNoteNoteContentDeatail.jsp?accession_num='+accession_num+'&no_modal='+no_modal+'&note_group='+note_group+'&statustxt='+notestatus+'&fun=VCN&called_function_id='+called_function_id+'&encounter_id='+encounter_id+'&function_id='+function_id+'&contr_mod_accession_num='+contr_mod_accession_num,arguments,features);
}


function chkMandate(obj)
{
	var fromDate = document.getElementById("date_from").value;
	var toDate = document.getElementById("date_to").value;
	if(obj.value == '')
	{
		alert(getMessage("ALL_MANDATORY_FIELDS",'eCommon'));
		return;
	}
	if(!isAfter(toDate,fromDate,"DMY",
			parent.refferalTrackingNotesSearch.document.refferal_note_search.localeName.value))
	{			
		alert(getMessage("TO_DT_GR_EQ_FM_DT","SM"));
		return;
	}
}

function NoteRefTracExpHeaderFrames(operation_mode)
{
	parent.NotesReferralTrackingMainFrame.rows='42%,65%,5%'; 	
	if(document.refferal_note_search!=null)
	{
		document.getElementById("detailsTable").style.display="";
		document.getElementById("headerLineTable").style.display="none";
	}
}
function NoteRefTracCompHeaderFrames()
{	
	parent.NotesReferralTrackingMainFrame.rows='5%,90%,5%';	
	if(document.refferal_note_search!=null)
	{		
		document.getElementById("detailsTable").style.display="none";	
		document.getElementById("headerLineTable").style.display="";
	}
}

function showCalendarValidate(str)
{
	var flg = showCalendar(str);
	//document.getElementById(str).focus();
	document.getElementById(str)focus();
	return flg;
}
function resetClick(){	
	document.location.reload();	
}
function onSuccess(){
	var action_url = getRelativeURL("/eCA/jsp/CANotesReferralTracking.jsp");
	parent.refferalTrackingNotesRefferedFrom.location.href = action_url;
	parent.refferalTrackingNotesRefferedFrom.location.reload();
}
