var messageFrameReference = top.content.messageFrame;
function callLevelTwo()
{
	
	top.content.master_pages.ClinicalRepMastMainFrame.document.getElementById("setup").className ="CAHIGHERLEVELCOLOR";
	/*top.content.master_pages.ClinicalRepMastMainFrame.document.getElementById("relink").className ="CAFIFTHLEVELCOLOR";*/
	top.content.master_pages.ClinicalRepMastSubFrame.location.href='../../eCA/jsp/ClinicalRepMastSubTab.jsp';
	//top.content.master_pages.ClinicalRepMastMainFrame.location.href="../../eCA/jsp/ClinicalRepMastMainTab.jsp";
  
  top.content.master_pages.ClinicalRepMastMainEventFrame.location.href="../../eCommon/html/blank.html";
  top.content.master_pages.ClinicalRepMastAssociateFrame.location.href="../../eCommon/html/blank.html";

	
}
function callLevelTwo1()
{
	
	top.content.master_pages.ClinicalRepMastMainFrame.location.href="../../eCA/jsp/ClinicalRepMastMainTab.jsp";	
	top.content.master_pages.ClinicalRepMastSubFrame.location.href='../../eCA/jsp/ClinicalRepMastRelink.jsp';
	top.content.master_pages.ClinicalRepMastMainEventFrame.location.href="../../eCommon/html/blank.html";
  top.content.master_pages.ClinicalRepMastAssociateFrame.location.href="../../eCommon/html/blank.html";
	

	
}

function callLevelThree()
{
	

    top.content.master_pages.ClinicalRepMastSubFrame.document.getElementById("individual").className ="CAHIGHERLEVELCOLOR";
	top.content.master_pages.ClinicalRepMastSubFrame.document.getElementById("batch").className ="CAFOURTHLEVELCOLOR";
	top.content.master_pages.ClinicalRepMastMainEventFrame.location.href='../../eCA/jsp/ClinicalRepMastMainEvent.jsp';
	top.content.master_pages.ClinicalRepMastAssociateFrame.location.href="../../eCommon/html/blank.html";

	
}

function callLevelThree1()
{
	
	top.content.master_pages.ClinicalRepMastSubFrame.document.getElementById("batch").className ="CAHIGHERLEVELCOLOR";
	/*top.content.master_pages.ClinicalRepMastSubFrame.document.getElementById("individual").className ="CAFOURTHLEVELCOLOR";*/
	top.content.master_pages.ClinicalRepMastMainEventFrame.location.href='../../eCA/jsp/ClinicalRepMastBatchEventMain.jsp';
	top.content.master_pages.ClinicalRepMastAssociateFrame.location.href="../../eCommon/html/blank.html";
	
}

function callLevelFour()
{
	
	var radio="";
	if (top.content.master_pages.ClinicalRepMastMainEventFrame.ClinicalRepMastMainEvent_form.add_source[0].checked==true)
	radio=top.content.master_pages.ClinicalRepMastMainEventFrame.ClinicalRepMastMainEvent_form.add_source[0].value;
	else
	radio=top.content.master_pages.ClinicalRepMastMainEventFrame.ClinicalRepMastMainEvent_form.add_source[1].value;
	//var source = top.content.master_pages.ClinicalRepMastMainEventFrame.ClinicalRepMastMainEvent_form.add_source.value;
	
	top.content.master_pages.ClinicalRepMastAssociateFrame.location.href='../../eCA/jsp/ClinicalRepMastPopulate.jsp?source='+radio;
	
}

function callLevelFour1()
{
	
	var radio="";
	var ret_str=""
	if (parent.ClinicalRepMastMainEventFrame.ClinicalRepMastBatchEventMain_form.data_set[0].checked==true)
	radio=parent.ClinicalRepMastMainEventFrame.ClinicalRepMastBatchEventMain_form.data_set[0].value;
	else
	radio=parent.ClinicalRepMastMainEventFrame.ClinicalRepMastBatchEventMain_form.data_set[1].value;
	var hist_rec_type=parent.ClinicalRepMastMainEventFrame.ClinicalRepMastBatchEventMain_form.hist_rec_type.value;
    //var contr_system =top.content.master_pages.ClinicalRepMastMainEventFrame.ClinicalRepMastBatchEventMain_form.hist_rec_type.value
	var contr_system=document.ClinicalRepMastBatchEventMain_form.contr_system.options[document.ClinicalRepMastBatchEventMain_form.contr_system.selectedIndex].text;
	
	if(radio=="A")
	{
	parent.ClinicalRepMastAssociateFrame.location.href='../../eCommon/html/blank.html';
	}
	else
	parent.ClinicalRepMastAssociateFrame.location.href='../../eCA/jsp/ClinicalRepMastBatchFrameSet.jsp?source='+radio+'&hist_rec_type='+hist_rec_type+'&contr_system='+contr_system+'&mode=insert';


	
}
function scrollTitle()
{
	
  var y = window.scrollY || document.documentElement.scrollTop || document.body.scrollTop;

  if(y == 0){
	document.getElementById("divDataTitle").style.position = 'static';
	document.getElementById("divDataTitle").style.top  = 0;
  }else{
	document.getElementById("divDataTitle").style.position = 'relative';
	document.getElementById("divDataTitle").style.top  = y-2 +'px';
  }

}
function scrollTitle1()
{
  var y = window.scrollY || document.documentElement.scrollTop || document.body.scrollTop;;

  if(y == 0){
	  document.getElementById("divDataTitle").style.position = 'static';
	  document.getElementById("divDataTitle").style.top  = 0;
  }else{
	  document.getElementById("divDataTitle").style.position = 'relative';
	  document.getElementById("divDataTitle").style.top  = y-2 + 'px';
  }

}	

function callLevelFour2()
{
	
	
    var hist_rec_type=document.ClinicalRepMastRelink_form.hist_rec_type.value;
    var event_code=document.ClinicalRepMastRelink_form.event_code.value;
    //var contr_system =top.content.master_pages.ClinicalRepMastMainEventFrame.ClinicalRepMastBatchEventMain_form.hist_rec_type.value
	var contr_system=document.ClinicalRepMastRelink_form.contr_system.options[document.ClinicalRepMastRelink_form.contr_system.selectedIndex].text;
	top.content.master_pages.ClinicalRepMastAssociateFrame.location.href='../../eCA/jsp/ClinicalRepRelinkFrameset.jsp?hist_rec_type='+hist_rec_type+'&contr_system='+contr_system+'&event_code='+event_code;
	
}

function contrsystempop()
{
	var length  =top.content.master_pages.ClinicalRepMastAssociateFrame.HeaderFrame.ClinicalRepMastAssociate_form.contr_system.length;	
			
			for(i=1;i<length;i++)
			{
			  top.content.master_pages.ClinicalRepMastAssociateFrame.HeaderFrame.ClinicalRepMastAssociate_form.contr_system.remove(1);
			}
	var obj= top.content.master_pages.ClinicalRepMastMainEventFrame.ClinicalRepMastMainEvent_form.hist_rec_type.value;
   	if (obj=='CLNT')
	{
		var Option = document.createElement("OPTION");
		Option.text="CA";
		Option.value="CA_NOTE_TYPE";
		top.content.master_pages.ClinicalRepMastAssociateFrame.HeaderFrame.ClinicalRepMastAssociate_form.contr_system.add(Option);
	}
	else if(obj == 'FDOC') {
			
			var Option = document.createElement("OPTION");
			Option.text="OR";
			Option.value="AM_DISCR_MSR";
			top.content.master_pages.ClinicalRepMastAssociateFrame.HeaderFrame.ClinicalRepMastAssociate_form.contr_system.add(Option);
	}else if(obj == 'PTCR') {
			
			var Option = document.createElement("OPTION");
			Option.text="OR";
			Option.value="AM_DISCR_MSR";
			top.content.master_pages.ClinicalRepMastAssociateFrame.HeaderFrame.ClinicalRepMastAssociate_form.contr_system.add(Option);
			var Option1 = document.createElement("OPTION");
			Option1.text="CA";
			Option1.value="CA_NOTE_TYPE";
			top.content.master_pages.ClinicalRepMastAssociateFrame.HeaderFrame.ClinicalRepMastAssociate_form.contr_system.add(Option1);
	}else if(obj == 'TRET') {
			
			var Option = document.createElement("OPTION");
			Option.text="OR";
			Option.value="AM_DISCR_MSR";
			top.content.master_pages.ClinicalRepMastAssociateFrame.HeaderFrame.ClinicalRepMastAssociate_form.contr_system.add(Option);
			var Option1 = document.createElement("OPTION");
			Option1.text="CA";
			Option1.value="CA_NOTE_TYPE";
			top.content.master_pages.ClinicalRepMastAssociateFrame.HeaderFrame.ClinicalRepMastAssociate_form.contr_system.add(Option1);
			var Option2 = document.createElement("OPTION");
			Option2.text="M9";
			Option2.value="MR_ICD_CODE";
			top.content.master_pages.ClinicalRepMastAssociateFrame.HeaderFrame.ClinicalRepMastAssociate_form.contr_system.add(Option2);
			var Option3 = document.createElement("OPTION");
			Option3.text="MC";
			Option3.value="MR_CPT_CODE";
			top.content.master_pages.ClinicalRepMastAssociateFrame.HeaderFrame.ClinicalRepMastAssociate_form.contr_system.add(Option3);
	}else if(obj == 'LBIN') {
			
			var Option = document.createElement("OPTION");
			Option.text="OR";
			Option.value="AM_DISCR_MSR";
			top.content.master_pages.ClinicalRepMastAssociateFrame.HeaderFrame.ClinicalRepMastAssociate_form.contr_system.add(Option);
			var Option1 = document.createElement("OPTION");
			Option1.text="CA";
			Option1.value="CA_NOTE_TYPE";
			top.content.master_pages.ClinicalRepMastAssociateFrame.HeaderFrame.ClinicalRepMastAssociate_form.contr_system.add(Option1);
			var Option2 = document.createElement("OPTION");
			Option2.text="LB";
			Option2.value="RL_TEST_CODE";
			top.content.master_pages.ClinicalRepMastAssociateFrame.HeaderFrame.ClinicalRepMastAssociate_form.contr_system.add(Option2);
			
	}else if(obj == 'BLTF') {
			
			var Option = document.createElement("OPTION");
			Option.text="BT";
			Option.value="BT_BLOOD_PRODUCT";
			top.content.master_pages.ClinicalRepMastAssociateFrame.HeaderFrame.ClinicalRepMastAssociate_form.contr_system.add(Option);
	}else if(obj == 'RDIN') {
			
			var Option = document.createElement("OPTION");
			Option.text="OR";
			Option.value="AM_DISCR_MSR";
			top.content.master_pages.ClinicalRepMastAssociateFrame.HeaderFrame.ClinicalRepMastAssociate_form.contr_system.add(Option);
			var Option1 = document.createElement("OPTION");
			Option1.text="CA";
			Option1.value="CA_NOTE_TYPE";
			top.content.master_pages.ClinicalRepMastAssociateFrame.HeaderFrame.ClinicalRepMastAssociate_form.contr_system.add(Option1);
			var Option2 = document.createElement("OPTION");
			Option2.text="M9";
			Option2.value="MR_ICD_CODE";
			top.content.master_pages.ClinicalRepMastAssociateFrame.HeaderFrame.ClinicalRepMastAssociate_form.contr_system.add(Option2);
			var Option3 = document.createElement("OPTION");
			Option3.text="MC";
			Option3.value="MR_CPT_CODE";
			top.content.master_pages.ClinicalRepMastAssociateFrame.HeaderFrame.ClinicalRepMastAssociate_form.contr_system.add(Option3);
			var Option4 = document.createElement("OPTION");
			Option4.text="RD";
			Option4.value="RD_EXAMINATION";
			top.content.master_pages.ClinicalRepMastAssociateFrame.HeaderFrame.ClinicalRepMastAssociate_form.contr_system.add(Option4);
	}
	else if(obj == 'SUNT') {
			
			var Option = document.createElement("OPTION");
			Option.text="OR";
			Option.value="AM_DISCR_MSR";
			top.content.master_pages.ClinicalRepMastAssociateFrame.HeaderFrame.ClinicalRepMastAssociate_form.contr_system.add(Option);
			var Option1 = document.createElement("OPTION");
			Option1.text="CA";
			Option1.value="CA_NOTE_TYPE";
			top.content.master_pages.ClinicalRepMastAssociateFrame.HeaderFrame.ClinicalRepMastAssociate_form.contr_system.add(Option1);
			var Option2 = document.createElement("OPTION");
			Option2.text="M9";
			Option2.value="MR_ICD_CODE";
			top.content.master_pages.ClinicalRepMastAssociateFrame.HeaderFrame.ClinicalRepMastAssociate_form.contr_system.add(Option2);
			var Option3 = document.createElement("OPTION");
			Option3.text="MC";
			Option3.value="MR_CPT_CODE";
			top.content.master_pages.ClinicalRepMastAssociateFrame.HeaderFrame.ClinicalRepMastAssociate_form.contr_system.add(Option3);
			var Option4 = document.createElement("OPTION");
			Option4.text="OT";
			Option4.value="OT_OPER_MAST";
			top.content.master_pages.ClinicalRepMastAssociateFrame.HeaderFrame.ClinicalRepMastAssociate_form.contr_system.add(Option4);
	}

}

function contrsystempop3()
{
	var length =top.content.master_pages.ClinicalRepMastSubFrame.ClinicalRepMastRelink_form.contr_system.length;	
			
			for(i=1;i<length;i++)
			{
			  top.content.master_pages.ClinicalRepMastSubFrame.ClinicalRepMastRelink_form.contr_system.remove(1);
			}
	
	var obj= top.content.master_pages.ClinicalRepMastSubFrame.ClinicalRepMastRelink_form.hist_rec_type.value;
	
   	if (obj=='CLNT')
	{
		var Option = document.createElement("OPTION");
		Option.text="CA";
		Option.value="CA_NOTE_TYPE";
		document.forms[0].contr_system.add(Option);
	}
	else if(obj == 'FDOC') {
			
			var Option = document.createElement("OPTION");
			Option.text="OR";
			Option.value="AM_DISCR_MSR";
			document.forms[0].contr_system.add(Option);
	}else if(obj == 'PTCR') {
			
			var Option = document.createElement("OPTION");
			Option.text="OR";
			Option.value="AM_DISCR_MSR";
			document.forms[0].contr_system.add(Option);
			var Option1 = document.createElement("OPTION");
			Option1.text="CA";
			Option1.value="CA_NOTE_TYPE";
			document.forms[0].contr_system.add(Option1);
	}else if(obj == 'TRET') {
			
			var Option = document.createElement("OPTION");
			Option.text="OR";
			Option.value="AM_DISCR_MSR";
			document.forms[0].contr_system.add(Option);
			var Option1 = document.createElement("OPTION");
			Option1.text="CA";
			Option1.value="CA_NOTE_TYPE";
			document.forms[0].contr_system.add(Option1);
			var Option2 = document.createElement("OPTION");
			Option2.text="M9";
			Option2.value="MR_ICD_CODE";
			document.forms[0].contr_system.add(Option2);
			var Option3 = document.createElement("OPTION");
			Option3.text="MC";
			Option3.value="MR_CPT_CODE";
			document.forms[0].contr_system.add(Option3);
	}else if(obj == 'LBIN') {
			
			var Option = document.createElement("OPTION");
			Option.text="OR";
			Option.value="AM_DISCR_MSR";
			document.forms[0].contr_system.add(Option);
			var Option1 = document.createElement("OPTION");
			Option1.text="CA";
			Option1.value="CA_NOTE_TYPE";
			document.forms[0].contr_system.add(Option1);
			var Option2 = document.createElement("OPTION");
			Option2.text="LB";
			Option2.value="RL_TEST_CODE";
			document.forms[0].contr_system.add(Option2);
			
	}else if(obj == 'BLTF') {
			
			var Option = document.createElement("OPTION");
			Option.text="BT";
			Option.value="BT_BLOOD_PRODUCT";
			document.forms[0].contr_system.add(Option);
	}else if(obj == 'RDIN') {
			
			var Option = document.createElement("OPTION");
			Option.text="OR";
			Option.value="AM_DISCR_MSR";
			document.forms[0].contr_system.add(Option);
			var Option1 = document.createElement("OPTION");
			Option1.text="CA";
			Option1.value="CA_NOTE_TYPE";
			document.forms[0].contr_system.add(Option1);
			var Option2 = document.createElement("OPTION");
			Option2.text="M9";
			Option2.value="MR_ICD_CODE";
			document.forms[0].contr_system.add(Option2);
			var Option3 = document.createElement("OPTION");
			Option3.text="MC";
			Option3.value="MR_CPT_CODE";
			document.forms[0].contr_system.add(Option3);
			var Option4 = document.createElement("OPTION");
			Option4.text="RD";
			Option4.value="RD_EXAMINATION";
			document.forms[0].contr_system.add(Option4);
	}
	else if(obj == 'SUNT') {
			
			var Option = document.createElement("OPTION");
			Option.text="OR";
			Option.value="AM_DISCR_MSR";
			document.forms[0].contr_system.add(Option);
			var Option1 = document.createElement("OPTION");
			Option1.text="CA";
			Option1.value="CA_NOTE_TYPE";
			document.forms[0].contr_system.add(Option1);
			var Option2 = document.createElement("OPTION");
			Option2.text="M9";
			Option2.value="MR_ICD_CODE";
			document.forms[0].contr_system.add(Option2);
			var Option3 = document.createElement("OPTION");
			Option3.text="MC";
			Option3.value="MR_CPT_CODE";
			document.forms[0].contr_system.add(Option3);
			var Option4 = document.createElement("OPTION");
			Option4.text="OT";
			Option4.value="OT_OPER_MAST";
			document.forms[0].contr_system.add(Option4);
	}

}

function contrsystempop2()
{
	var length =parent.ClinicalRepMastMainEventFrame.ClinicalRepMastBatchEventMain_form.contr_system.length;	
			
			for(i=1;i<length;i++)
			{
			  parent.ClinicalRepMastMainEventFrame.ClinicalRepMastBatchEventMain_form.contr_system.remove(1);
			}
	var obj= parent.ClinicalRepMastMainEventFrame.ClinicalRepMastBatchEventMain_form.hist_rec_type.value;
	
   	if (obj=='CLNT')
	{
		var Option = document.createElement("OPTION");
		Option.text="CA";
		Option.value="CA_NOTE_TYPE";
		document.forms[0].contr_system.add(Option);
	}
	else if(obj == 'FDOC') {
			
			var Option = document.createElement("OPTION");
			Option.text="OR";
			Option.value="AM_DISCR_MSR";
			document.forms[0].contr_system.add(Option);
	}else if(obj == 'PTCR') {
			
			var Option = document.createElement("OPTION");
			Option.text="OR";
			Option.value="AM_DISCR_MSR";
			document.forms[0].contr_system.add(Option);
			var Option1 = document.createElement("OPTION");
			Option1.text="CA";
			Option1.value="CA_NOTE_TYPE";
			document.forms[0].contr_system.add(Option1);
	}else if(obj == 'TRET') {
			
			var Option = document.createElement("OPTION");
			Option.text="OR";
			Option.value="AM_DISCR_MSR";
			document.forms[0].contr_system.add(Option);
			var Option1 = document.createElement("OPTION");
			Option1.text="CA";
			Option1.value="CA_NOTE_TYPE";
			document.forms[0].contr_system.add(Option1);
			//var Option2 = document.createElement("OPTION");
			//Option2.text="M9";
			//Option2.value="MR_ICD_CODE";
			//document.forms[0].contr_system.add(Option2);
			//var Option3 = document.createElement("OPTION");
			//Option3.text="MC";
			//Option3.value="MR_CPT_CODE";
			//document.forms[0].contr_system.add(Option3);
	}else if(obj == 'LBIN') {
			
			var Option = document.createElement("OPTION");
			Option.text="OR";
			Option.value="AM_DISCR_MSR";
			document.forms[0].contr_system.add(Option);
			var Option1 = document.createElement("OPTION");
			Option1.text="CA";
			Option1.value="CA_NOTE_TYPE";
			document.forms[0].contr_system.add(Option1);
			//var Option2 = document.createElement("OPTION");
			//Option2.text="LB";
			//Option2.value="RL_TEST_CODE";
			//document.forms[0].contr_system.add(Option2);
			
	}else if(obj == 'BLTF') {
			
			//var Option = document.createElement("OPTION");
			//Option.text="BT";
			//Option.value="BT_BLOOD_PRODUCT";
			//document.forms[0].contr_system.add(Option);
	}else if(obj == 'RDIN') {
			
			var Option = document.createElement("OPTION");
			Option.text="OR";
			Option.value="AM_DISCR_MSR";
			document.forms[0].contr_system.add(Option);
			var Option1 = document.createElement("OPTION");
			Option1.text="CA";
			Option1.value="CA_NOTE_TYPE";
			document.forms[0].contr_system.add(Option1);
			//var Option2 = document.createElement("OPTION");
			//Option2.text="M9";
			//Option2.value="MR_ICD_CODE";
			//document.forms[0].contr_system.add(Option2);
			//var Option3 = document.createElement("OPTION");
			//Option3.text="MC";
			//Option3.value="MR_CPT_CODE";
			//document.forms[0].contr_system.add(Option3);
			//var Option4 = document.createElement("OPTION");
			//Option4.text="RD";
			//Option4.value="RD_EXAMINATION";
			//document.forms[0].contr_system.add(Option4);
	}
	else if(obj == 'SUNT') {
			
			var Option = document.createElement("OPTION");
			Option.text="OR";
			Option.value="AM_DISCR_MSR";
			document.forms[0].contr_system.add(Option);
			var Option1 = document.createElement("OPTION");
			Option1.text="CA";
			Option1.value="CA_NOTE_TYPE";
			document.forms[0].contr_system.add(Option1);
			//var Option2 = document.createElement("OPTION");
			//Option2.text="M9";
			//Option2.value="MR_ICD_CODE";
			//document.forms[0].contr_system.add(Option2);
			//var Option3 = document.createElement("OPTION");
			//Option3.text="MC";
			//Option3.value="MR_CPT_CODE";
			//document.forms[0].contr_system.add(Option3);
			var Option2 = document.createElement("OPTION");
			Option2.text="OT";
			Option2.value="OT_OPER_MAST";
			document.forms[0].contr_system.add(Option2);
	}

}

function contrsystempop1()
{
	var obj= top.content.master_pages.ClinicalRepMastMainEventFrame.ClinicalRepMastMainEvent_form.hist_rec_type.value;
   	if (obj=='CLNT')
	{
		var Option = document.createElement("OPTION");
		Option.text="CA";
		Option.value="CA_NOTE_TYPE";
		top.content.master_pages.ClinicalRepMastAssociateFrame.paneladd.ClinicalRepMastAssocLink_form.contr_system.add(Option);
	}
	else if(obj == 'FDOC') {
			
			var Option = document.createElement("OPTION");
			Option.text="OR";
			Option.value="AM_DISCR_MSR";
			top.content.master_pages.ClinicalRepMastAssociateFrame.paneladd.ClinicalRepMastAssocLink_form.contr_system.add(Option);
	}else if(obj == 'PTCR') {
			
			var Option = document.createElement("OPTION");
			Option.text="OR";
			Option.value="AM_DISCR_MSR";
			top.content.master_pages.ClinicalRepMastAssociateFrame.paneladd.ClinicalRepMastAssocLink_form.contr_system.add(Option);
			var Option1 = document.createElement("OPTION");
			Option1.text="CA";
			Option1.value="CA_NOTE_TYPE";
			top.content.master_pages.ClinicalRepMastAssociateFrame.paneladd.ClinicalRepMastAssocLink_form.contr_system.add(Option1);
	}else if(obj == 'TRET') {
			
			var Option = document.createElement("OPTION");
			Option.text="OR";
			Option.value="AM_DISCR_MSR";
			top.content.master_pages.ClinicalRepMastAssociateFrame.paneladd.ClinicalRepMastAssocLink_form.contr_system.add(Option);
			var Option1 = document.createElement("OPTION");
			Option1.text="CA";
			Option1.value="CA_NOTE_TYPE";
			top.content.master_pages.ClinicalRepMastAssociateFrame.paneladd.ClinicalRepMastAssocLink_form.contr_system.add(Option1);
			var Option2 = document.createElement("OPTION");
			Option2.text="M9";
			Option2.value="MR_ICD_CODE";
			top.content.master_pages.ClinicalRepMastAssociateFrame.paneladd.ClinicalRepMastAssocLink_form.contr_system.add(Option2);
			var Option3 = document.createElement("OPTION");
			Option3.text="MC";
			Option3.value="MR_CPT_CODE";
			top.content.master_pages.ClinicalRepMastAssociateFrame.paneladd.ClinicalRepMastAssocLink_form.contr_system.add(Option3);
	}else if(obj == 'LBIN') {
			
			var Option = document.createElement("OPTION");
			Option.text="OR";
			Option.value="AM_DISCR_MSR";
			top.content.master_pages.ClinicalRepMastAssociateFrame.paneladd.ClinicalRepMastAssocLink_form.contr_system.add(Option);
			var Option1 = document.createElement("OPTION");
			Option1.text="CA";
			Option1.value="CA_NOTE_TYPE";
			top.content.master_pages.ClinicalRepMastAssociateFrame.paneladd.ClinicalRepMastAssocLink_form.contr_system.add(Option1);
			var Option2 = document.createElement("OPTION");
			Option2.text="LB";
			Option2.value="RL_TEST_CODE";
			top.content.master_pages.ClinicalRepMastAssociateFrame.paneladd.ClinicalRepMastAssocLink_form.contr_system.add(Option2);
			
	}else if(obj == 'BLTF') {
			
			var Option = document.createElement("OPTION");
			Option.text="BT";
			Option.value="BT_BLOOD_PRODUCT";
			top.content.master_pages.ClinicalRepMastAssociateFrame.paneladd.ClinicalRepMastAssocLink_form.contr_system.add(Option);
	}else if(obj == 'RDIN') {
			
			var Option = document.createElement("OPTION");
			Option.text="OR";
			Option.value="AM_DISCR_MSR";
			top.content.master_pages.ClinicalRepMastAssociateFrame.paneladd.ClinicalRepMastAssocLink_form.contr_system.add(Option);
			var Option1 = document.createElement("OPTION");
			Option1.text="CA";
			Option1.value="CA_NOTE_TYPE";
			top.content.master_pages.ClinicalRepMastAssociateFrame.paneladd.ClinicalRepMastAssocLink_form.contr_system.add(Option1);
			var Option2 = document.createElement("OPTION");
			Option2.text="M9";
			Option2.value="MR_ICD_CODE";
			top.content.master_pages.ClinicalRepMastAssociateFrame.paneladd.ClinicalRepMastAssocLink_form.contr_system.add(Option2);
			var Option3 = document.createElement("OPTION");
			Option3.text="MC";
			Option3.value="MR_CPT_CODE";
			top.content.master_pages.ClinicalRepMastAssociateFrame.paneladd.ClinicalRepMastAssocLink_form.contr_system.add(Option3);
			var Option4 = document.createElement("OPTION");
			Option4.text="RD";
			Option4.value="RD_EXAMINATION";
			top.content.master_pages.ClinicalRepMastAssociateFrame.paneladd.ClinicalRepMastAssocLink_form.contr_system.add(Option4);
	}
	else if(obj == 'SUNT') {
			
			var Option = document.createElement("OPTION");
			Option.text="OR";
			Option.value="AM_DISCR_MSR";
			top.content.master_pages.ClinicalRepMastAssociateFrame.paneladd.ClinicalRepMastAssocLink_form.contr_system.add(Option);
			var Option1 = document.createElement("OPTION");
			Option1.text="CA";
			Option1.value="CA_NOTE_TYPE";
			top.content.master_pages.ClinicalRepMastAssociateFrame.paneladd.ClinicalRepMastAssocLink_form.contr_system.add(Option1);
			var Option2 = document.createElement("OPTION");
			Option2.text="M9";
			Option2.value="MR_ICD_CODE";
			top.content.master_pages.ClinicalRepMastAssociateFrame.paneladd.ClinicalRepMastAssocLink_form.contr_system.add(Option2);
			var Option3 = document.createElement("OPTION");
			Option3.text="MC";
			Option3.value="MR_CPT_CODE";
			top.content.master_pages.ClinicalRepMastAssociateFrame.paneladd.ClinicalRepMastAssocLink_form.contr_system.add(Option3);
			var Option4 = document.createElement("OPTION");
			Option4.text="OT";
			Option4.value="OT_OPER_MAST";
			top.content.master_pages.ClinicalRepMastAssociateFrame.paneladd.ClinicalRepMastAssocLink_form.contr_system.add(Option4);
	}

}

async function callEvent()
{
	//var target			= document.forms[0].age_group_code_desc;
	var table_name		= document.ClinicalRepMastAssociate_form.contr_system.value;
	if(table_name == '')
        alert(getMessage("CONTRID","CA"));
	else
	{
	
	var retVal			=  new String();
	var dialogTop		= "40";
	var dialogHeight	= "10" ;
	var dialogWidth		= "40" ;
	var features		= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments		= "" ;
	var search_desc		= "";
	var title			= getLabel("eCA.EventCode.label","CA");
	var tablename       = top.content.master_pages.ClinicalRepMastAssociateFrame.HeaderFrame.document.ClinicalRepMastAssociate_form.contr_system.value;
	var histype			= top.content.master_pages.ClinicalRepMastMainEventFrame.ClinicalRepMastMainEvent_form.hist_rec_type.value;
	var contr			= top.content.master_pages.ClinicalRepMastAssociateFrame.HeaderFrame.ClinicalRepMastAssociate_form.contr_system.options[top.content.master_pages.ClinicalRepMastAssociateFrame.HeaderFrame.ClinicalRepMastAssociate_form.contr_system.selectedIndex].text;
	
	if((histype=="CLNT" && contr == "CA")||(histype=="LBIN" && contr == "CA")||(histype=="TRET" && contr == "CA")||(histype=="TRET" && contr == "CA")||(histype=="RDIN" && contr == "CA")||(histype=="SUNT" && contr == "CA"))
		{
			var sql="Select note_group code, note_group_desc short_desc from ca_note_group ";
			var sql2 =""; 
			search_code="note_group code";
			search_desc="note_group_desc";
		}
		else if((histype=="PTCR" && contr == "OR") || (histype=="TRET" && contr == "OR") || (histype=="LBIN" && contr == "OR") || (histype=="RDIN" && contr == "OR") || (histype=="SUNT" && contr == "OR"))
		{
		 var sql="Select discr_msr_id code, short_desc from am_discr_msr ";
		 var sql2 ="select long_desc long_desc from am_discr_msr where discr_msr_id="; 
				
			search_code="discr_msr_id";
			search_desc="short_desc";
		}
		else if(histype=="RDIN" && contr == "RD")
		{
			var sql="Select exam_code code, short_desc from rd_examination";
			var sql2 ="select long_desc long_desc from rd_examination where exam_code="; 

			search_code = "exam_code";
			search_desc="short_desc"; 
		}
		else if(histype=="LBIN" && contr == "LB")
		{
		var sql="Select test_code code, short_desc from rl_test_code  ";
		var sql2 ="select long_desc long_desc from rl_test_code where test_code="; 

			search_code = "test_code";
			search_desc="short_desc"; 
		}
		else if(histype=="SUNT" && contr == "OT")
		{
		var sql="Select OPER_CODE code, short_desc from OT_OPER_MAST  ";
		var sql2 ="select long_desc long_desc from OT_OPER_MAST where OPER_CODE="; 

			search_code = "test_code";
			search_desc="short_desc"; 
		}
		else if((histype=="TRET" && contr == "M9") || (histype=="RDIN" && contr == "M9") || (histype=="SUNT" && contr == "M9"))
		{
		 var sql="Select DIAG_CODE code, SHORT_DESC from MR_ICD_CODE";
		 var sql2 ="select long_desc long_desc from MR_ICD_CODE where DIAG_CODE="; 
				
			search_code="DIAG_CODE";
			search_desc="short_desc";
		}
		else if((histype=="TRET" && contr == "MC") || (histype=="RDIN" && contr == "MC") || (histype=="SUNT" && contr == "MC"))
		{
		 var sql="Select CPT_CODE code, SHORT_DESC from MR_CPT_CODE";
		 var sql2 =""; 
				
			search_code="CPT_CODE";
			search_desc="short_desc";
		}
			retVal=await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+encodeURIComponent(title,"UTF-8")+"&dispDescFirst=dispDescFirst",arguments,features);
			 
			var arr=new Array();

			if (retVal != null && retVal != '' && retVal != "null")
			{
				var retVal=unescape(retVal);
				arr=retVal.split("::");
			   
				document.forms[0].short_desc.value=arr[0];
				document.forms[0].event_code.value=arr[1];
				
			}
			else
			{
		
				document.forms[0].event_code.value="";
				document.forms[0].long_desc.value="";
				document.forms[0].short_desc.value="";
				
			}
			
	  if(sql2 != "" && arr[1] != "")
		{ 
		  sql2+= "'"+arr[1]+"'";
		  getLongDesc(document.forms[0].event_code.value,sql2);
		}
		else
		{
			document.forms[0].long_desc.value= arr[0];
		}
		}
	}
function getLongDesc(val,sqlquery)
{
	
if(val != '')
	{
top.content.master_pages.messageFrame.location.href="../../eCommon/html/blank.html";
var action_url = "../../eCA/jsp/ClinicalRepMastGetDesc.jsp";
var HTMLVal			=	"<html><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><body onKeyDown='lockKey()'><form name='dummy8' id='dummy8' method='POST' action='"+action_url+"' >"+
							"<input type='hidden' name='groupid' id='groupid' value='"+val+"'>"+
							"<input type='hidden' name='sqlquery' id='sqlquery' value="+escape(sqlquery)+">"+
							"</form></body></html >";
	
	top.content.master_pages.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
	
	top.content.master_pages.messageFrame.document.dummy8.submit();
	}
}
function setLongDesc(longdesc)
{

 top.content.master_pages.ClinicalRepMastAssociateFrame.HeaderFrame.ClinicalRepMastAssociate_form.long_desc.value=longdesc;
top.content.master_pages.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp';
}

async function callEvent1()
{
	//var target			= document.forms[0].age_group_code_desc;
	var table_name		= document.ClinicalRepMastRelink_form.contr_system.value;
	var retVal			=  new String();
	var dialogTop		= "40";
	var dialogHeight	= "10" ;
	var dialogWidth		= "40" ;
	var features		= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments		= "" ;
	var search_desc		= "";
	var title			= getLabel("eCA.EventCode.label","CA");
	var tablename       = top.content.master_pages.ClinicalRepMastSubFrame.ClinicalRepMastRelink_form.contr_system.value;
	if(table_name== 'CA_NOTE_TYPE')
	{
	var sql="SELECT NOTE_TYPE,NOTE_TYPE_DESC FROM CA_NOTE_TYPE";
	search_code="NOTE_TYPE";
	search_desc="NOTE_TYPE_DESC";
	}else if(table_name == 'AM_DISCR_MSR')
	{
		var sql="SELECT DISCR_MSR_ID,LONG_DESC,SHORT_DESC FROM AM_DISCR_MSR";
		search_code="DISCR_MSR_ID";
		search_desc="LONG_DESC";
	}else if(table_name == 'RL_TEST_CODE')
	{
		var sql="SELECT TEST_CODE,LONG_DESC,SHORT_DESC FROM RL_TEST_CODE";
		search_code="DISCR_MSR_ID";
		search_desc="LONG_DESC";
	}else if(table_name == 'MR_ICD_CODE')
	{
		var sql="SELECT DIAG_CODE,LONG_DESC,SHORT_DESC FROM MR_ICD_CODE";
		search_code="DIAG_CODE";
		search_desc="LONG_DESC";
	}else if(table_name == 'RD_EXAMINATION')
	{
		var sql="SELECT EXAM_CODE,LONG_DESC,SHORT_DESC FROM RD_EXAMINATION";
		search_code="EXAM_CODE";
		search_desc="LONG_DESC";
	}else if(table_name == 'OT_OPER_MAST')
	{
		var sql="SELECT OPER_CODE,LONG_DESC,SHORT_DESC FROM OT_OPER_MAST";
		search_code="OPER_CODE";
		search_desc="LONG_DESC";
	}else if(table_name == 'PH_DRUG')
	{
		var sql="SELECT DRUG_CODE,DRUG_DESC FROM OT_OPER_MAST";
		search_code="DRUG_CODE";
		search_desc="DRUG_DESC";
	}else if(table_name == 'MR_CPT_CODE')
	{
		var sql="SELECT CPT_CODE,SHORT_DESC FROM MR_CPT_CODE";
		search_code="CPT_CODE";
		search_desc="SHORT_DESC";
	}

	//retVal=window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+title+"&dispDescFirst=dispDescFirst",arguments,features);
	retVal=await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+encodeURIComponent(title,"UTF-8")+"&dispDescFirst=dispDescFirst",arguments,features);
	var arr=new Array();
	if (retVal != null && retVal != '' && retVal != "null")
	{
		var retVal=unescape(retVal);
		arr=retVal.split("::");
		//document.ClinicalRepMastAssociate_form.long_desc.value=arr[0];
		document.ClinicalRepMastRelink_form.event_code.value=arr[1];
		//document.ClinicalRepMastAssociate_form.short_desc.value=arr[0];
		//document.forms[0].age_group_code_desc.focus();
	}
	var event_code=document.ClinicalRepMastRelink_form.event_code.value;
	if(event_code != null && event_code != '' && event_code != "null")
	{
      callLevelFour2();
	}

    
}

function displayContributingEvents()
 {
	var contr_system=document.ClinicalRepMastAssociate_form.contr_system.options[document.ClinicalRepMastAssociate_form.contr_system.selectedIndex].text;
	var radio="";
	if (top.content.master_pages.ClinicalRepMastMainEventFrame.ClinicalRepMastMainEvent_form.add_source(0).checked==true)
	radio=top.content.master_pages.ClinicalRepMastMainEventFrame.ClinicalRepMastMainEvent_form.add_source(0).value;
	else
	radio=top.content.master_pages.ClinicalRepMastMainEventFrame.ClinicalRepMastMainEvent_form.add_source(1).value;

	if(radio == "U")
	document.forms[0].event_code.value = '';
	else
    document.forms[0].event_code.value = '';

	document.forms[0].long_desc.value = '';
	document.forms[0].short_desc.value = '';
	
	top.content.master_pages.ClinicalRepMastAssociateFrame.paneladd.location.href="../../eCA/jsp/ClinicalRepMastAssociateLinked.jsp?contr_system="+contr_system+"";
	top.content.master_pages.ClinicalRepMastAssociateFrame.paneldetails.location.href="../../eCommon/html/blank.html";
	
 }
function setdataset()
 {
	var radio="";
	parent.ClinicalRepMastMainEventFrame.ClinicalRepMastBatchEventMain_form.data_set[0].checked = true;
	callLevelFour1();
	
 }
 function clearFields()
{
	document.forms[0].contr_system.value="";
	document.forms[0].event_code.value="";
	document.forms[0].short_desc.value="";
}

function Reassaign(obj)
{
		
		if(!obj.checked==true)
		{
			if(window.confirm(getMessage("DELETE_RECORD",'CA')) == true)
			{
			
			var chkval = obj.value;
			var flag="false";
			
			parent.paneldetails.location.href="../../eCA/jsp/ClinicalRepMastAssociateNew.jsp?code="+chkval+"&flag="+flag+"";
		}
	}
}

 function addEvents()
{
	
	var contr_system=document.forms[0].contr_system.options[document.forms[0].contr_system.selectedIndex].text;
	var event_code= document.ClinicalRepMastAssocLink_form.event_code.value;
	var short_desc= document.ClinicalRepMastAssocLink_form.short_desc.value;
    //var mandatory= parent.frames[3].document.forms[0].mandatory.value;
	//var mode=parent.frames[3].document.forms[0].mode.value;
	//var disp_flag=parent.frames[3].document.forms[0].disp_flag.value;
	//var clearvalue=parent.frames[3].document.forms[0].clearvalue.value;
	var code=document.ClinicalRepMastAssocLink_form.code.value;
	
	
	if(event_code==null || event_code=="")
	{
		alert(getMassage("EVENT_CODE_NOT_BLANK","CA"));
		return false;
	}	
	else
	{
		parent.paneldetails.location.href="../../eCA/jsp/ClinicalRepMastAssociateNew.jsp?contr_system="+contr_system+"&code="+code+"&event_code="+event_code+"&short_desc="+short_desc+"&removebean=Y";
	}
parent.paneladd.location.href="../../eCA/jsp/ClinicalRepMastAssociateLinked.jsp";
}

async function getEventId()
{
	//var target			= document.forms[0].age_group_code_desc;
	var retVal			=  new String();
	var dialogTop		= "40";
	var dialogHeight	= "10" ;
	var dialogWidth		= "40" ;
	var features		= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments		= "" ;
	var search_desc		= "";
	var title			= getLabel("eCA.EventCode.label","CA");
	var tablename       = top.content.master_pages.ClinicalRepMastAssociateFrame.HeaderFrame.document.ClinicalRepMastAssociate_form.contr_system.value;
	var hist_rec_type   = top.content.master_pages.ClinicalRepMastMainEventFrame.ClinicalRepMastMainEvent_form.hist_rec_type.value;
	var event_code_type = document.forms[0].contr_system.options[document.forms[0].contr_system.selectedIndex].text;
	var sql=" select EVENT_CODE,SHORT_DESC from cr_clin_event_mast A where HIST_REC_TYPE = `"+hist_rec_type+"` AND EVENT_CODE_TYPE = `"+event_code_type+"` AND NOT EXISTS (SELECT 1 FROM  cr_clin_event_mast_LINK WHERE  HIST_REC_TYPE =A. HIST_REC_TYPE AND CONTR_SYS_EVENT_CODE = A. EVENT_CODE AND EVENT_CODE_TYPE=A. EVENT_CODE_TYPE AND EVENT_CODE != A.EVENT_CODE ) ";
	search_code="EVENT_CODE";
	search_desc="SHORT_DESC";
	retVal=await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+encodeURIComponent(title,"UTF-8")+"&dispDescFirst=dispDescFirst",arguments,features);
	var arr=new Array();
	if (retVal != null && retVal != '' && retVal != "null")
	{
		var retVal=unescape(retVal);
		arr=retVal.split("::");
		
		document.ClinicalRepMastAssocLink_form.event_code.value=arr[1];
		document.ClinicalRepMastAssocLink_form.short_desc.value=arr[0];
		
		//document.forms[0].age_group_code_desc.focus();
	}	
}

function showvis(val)
{

if(val == 'true')
document.getElementById("last").style.display='none';
else
document.getElementById("last").style.display='block';
//parent.frames[2].document.getElementById("last").style.visibility = 'visible';
}

function panelposition(position,last)
{

if(last != 'X')
last ='';

var mode=parent.frames[2].document.forms[0].mode.value
var temp=parent.frames[2].document.forms[0].first.value
if(temp=='')	
parent.frames[2].document.forms[0].first.value=	position;
else
	{
	var pos1=parent.frames[2].document.forms[0].first.value;
	parent.frames[2].document.forms[0].first.value='';
	parent.frames[2].location.href="../../eCA/jsp/ClinicalRepMastAssociateNew.jsp?change=Y&pos1="+pos1+"&pos2="+position+"&mode="+mode+"&lastlink="+last+"";
	}

}

function apply()
{
  //if(top.content.master_pages.ClinicalRepMastSubFrame.document.forms[0].name=="ClinicalRepMastSubTabform")
//{

  if(document.ClinicalRepMastMainEventFrame.document.forms[0].name=="ClinicalRepMastMainEvent_form")
  {
	  
	var mode= document.frames[3].ClinicalRepMastMainEvent_form.mode.value;

	var fields = new Array (
							document.frames[4].HeaderFrame.ClinicalRepMastAssociate_form.contr_system,
							document.frames[4].HeaderFrame.ClinicalRepMastAssociate_form.event_code
		                    );

	var names = new Array ( 
							getLabel("eCA.ContrSystem.label",'CA'),
							getLabel("eCA.EventCode.label",'CA')
	                       );
						  

	if(document.frames[4].checkFieldsofMst( fields, names, top.content.master_pages.messageFrame))
	{
	
	var hist_rec_type1 = document.frames[3].ClinicalRepMastMainEvent_form.hist_rec_type.value;
	var add_source1 = document.frames[3].ClinicalRepMastMainEvent_form.add_source.value;
	var contr_system1 = document.frames[4].HeaderFrame.ClinicalRepMastAssociate_form.contr_system.options[document.frames[4].HeaderFrame.ClinicalRepMastAssociate_form.contr_system.selectedIndex].text;
	var event_code1 = document.frames[4].HeaderFrame.ClinicalRepMastAssociate_form.event_code.value;
	var long_desc1 = document.frames[4].HeaderFrame.ClinicalRepMastAssociate_form.long_desc.value;
	var short_desc1 = document.frames[4].HeaderFrame.ClinicalRepMastAssociate_form.short_desc.value;
	
	document.frames[3].ClinicalRepMastMainEvent_form.action="../../servlet/eCA.ClinicalRepMastServlet?add_source1="+add_source1+"&contr_system1="+contr_system1+"&event_code1="+event_code1+"&long_desc1="+long_desc1+"&short_desc1="+short_desc1;
    document.frames[3].ClinicalRepMastMainEvent_form.target="messageFrame";
	document.frames[3].ClinicalRepMastMainEvent_form.method="post";
	document.frames[3].ClinicalRepMastMainEvent_form.submit();
		
	}
  }else if(document.ClinicalRepMastMainEventFrame.document.forms[0].name=="ClinicalRepMastBatchEventMain_form")
	{

	  var fields = new Array (
							document.ClinicalRepMastMainEventFrame.ClinicalRepMastBatchEventMain_form.hist_rec_type,
							document.ClinicalRepMastMainEventFrame.ClinicalRepMastBatchEventMain_form.contr_system
		                    );

	var names = new Array ( 
							getLabel("eCA.HistoryRecordType.label",'CA'),
	                         getLabel("eCA.ContrSystem.label",'CA')	 
						   );
	if(document.ClinicalRepMastMainEventFrame.checkFieldsofMst( fields, names,messageFrame))
	{	
	  var hist_rec_type1 = document.ClinicalRepMastMainEventFrame.ClinicalRepMastBatchEventMain_form.hist_rec_type.value;
	  var contr_system1 = document.ClinicalRepMastMainEventFrame.ClinicalRepMastBatchEventMain_form.contr_system.options[document.ClinicalRepMastMainEventFrame.ClinicalRepMastBatchEventMain_form.contr_system.selectedIndex].text;
 	  var radio="";
		if (document.ClinicalRepMastMainEventFrame.ClinicalRepMastBatchEventMain_form.data_set[0].checked==
			true)
		radio=document.ClinicalRepMastMainEventFrame.ClinicalRepMastBatchEventMain_form.data_set[0].value;
		else
		radio=document.ClinicalRepMastMainEventFrame.ClinicalRepMastBatchEventMain_form.data_set[1].value;
		
			if(radio=='A')
			{
				
			  document.ClinicalRepMastMainEventFrame.ClinicalRepMastBatchEventMain_form.action="../../servlet/eCA.ClinicalRepMastServlet?mode=batch&hist_rec_type1="+hist_rec_type1+"&contr_system1="+contr_system1+"&data_set="+radio;
			  document.ClinicalRepMastMainEventFrame.ClinicalRepMastBatchEventMain_form.submit();
			}
			else if(radio=='S')
			{
				
			  
			  var modeval="batch";
				  document.ClinicalRepMastAssociateFrame.sectionsFrame.ClinicalEventGroupBatchBeanForm.action="../../servlet/eCA.ClinicalRepMastServlet?mode="+modeval+"&hist_rec_type1="+hist_rec_type1+"&contr_system1="+contr_system1+"&data_set="+radio;

				  document.ClinicalRepMastAssociateFrame.sectionsFrame.ClinicalEventGroupBatchBeanForm.method="post";
				  document.ClinicalRepMastAssociateFrame.sectionsFrame.ClinicalEventGroupBatchBeanForm.target="messageFrame";

				document.ClinicalRepMastAssociateFrame.sectionsFrame.ClinicalEventGroupBatchBeanForm.submit();
			}

	}
   }
 //}
 else if(document.ClinicalRepMastMainEventFrame.document.forms[0].name =="ClinicalRepMastRelink_form")
	{

	 
	  var fields = new Array (
							document.frames[2].ClinicalRepMastRelink_form.hist_rec_type,
							document.frames[2].ClinicalRepMastRelink_form.event_code,
		                    document.frames[2].ClinicalRepMastRelink_form.contr_system
		                    );

	var names = new Array ( 
							getLabel("eCA.HistoryRecordType.label",'CA'),
		                    getLabel("eCA.EventCode.label",'CA'),
	                        getLabel("eCA.ContrSystem.label",'CA')		                    
						   );
	if(document.frames[2].checkFieldsofMst( fields, names, top.content.master_pages.messageFrame))
	{
		
		var hist_rec_type=document.frames[2].ClinicalRepMastRelink_form.hist_rec_type.value;
		var event_code=document.frames[2].ClinicalRepMastRelink_form.event_code.value;
		var contr_system=document.frames[2].ClinicalRepMastRelink_form.contr_system.options[document.frames[2].ClinicalRepMastRelink_form.contr_system.selectedIndex].text;

		document.ClinicalRepMastAssociateFrame.sectionsFrame.ClinicalEventGroupRelinkBeanForm.action="../../servlet/eCA.ClinicalRepMastServlet?hist_rec_type1="+hist_rec_type+"&contr_system="+contr_system+"&event_code="+event_code+"&mode=relink";

		document.ClinicalRepMastAssociateFrame.sectionsFrame.ClinicalEventGroupRelinkBeanForm.method="post";
				  document.ClinicalRepMastAssociateFrame.sectionsFrame.ClinicalEventGroupRelinkBeanForm.target="messageFrame";
		document.ClinicalRepMastAssociateFrame.sectionsFrame.ClinicalEventGroupRelinkBeanForm.submit();

	}
  }
}

function reset(){
  ClinicalRepMastMainEventFrame.document.ClinicalRepMastBatchEventMain_form.reset();
  ClinicalRepMastAssociateFrame.location.href = '../../eCommon/html/blank.html';	
}

function onSuccess()
{
  document.ClinicalRepMastMainFrame.location.href="../../eCA/jsp/ClinicalRepMastMainTab.jsp";
  document.ClinicalRepMastSubFrame.location.href="../../eCA/jsp/ClinicalRepMastSubTab.jsp";
  document.ClinicalRepMastMainEventFrame.location.href="../../eCA/jsp/ClinicalRepMastBatchEventMain.jsp";
  document.ClinicalRepMastAssociateFrame.location.href="../../eCommon/html/blank.html";
  
	
}

function searchBatchEventGroup()
{




	var fields = new Array(parent.parent.parent.ClinicalRepMastMainEventFrame.ClinicalRepMastBatchEventMain_form.hist_rec_type,
          parent.parent.parent.ClinicalRepMastMainEventFrame.ClinicalRepMastBatchEventMain_form.contr_system);
	
	var names = new Array ( getLabel("eCA.HistoryRecordType.label",'CA'),
							getLabel("eCA.ContrSystem.label",'CA'));	

	if(parent.parent.parent.ClinicalRepMastMainEventFrame.checkFieldsofMst( fields, names, parent.parent.parent.ClinicalRepMastMainEventFrame.messageFrame))
	{

var histype=parent.parent.parent.ClinicalRepMastMainEventFrame.ClinicalRepMastBatchEventMain_form.hist_rec_type.value;
var contr = parent.parent.parent.ClinicalRepMastMainEventFrame.ClinicalRepMastBatchEventMain_form.contr_system.options[parent.parent.parent.ClinicalRepMastMainEventFrame.ClinicalRepMastBatchEventMain_form.contr_system.selectedIndex].text;
var searchby = "";
if(parent.parent.parent.ClinicalRepMastAssociateFrame.addSectionsFrame.batsearchcri.document.forms[0].search_by[0].checked
	==true)
searchby=parent.parent.parent.ClinicalRepMastAssociateFrame.addSectionsFrame.batsearchcri.document.forms[0].search_by[0].value;
else
searchby=parent.parent.parent.ClinicalRepMastAssociateFrame.addSectionsFrame.batsearchcri.document.forms[0].search_by[1].value;


var criteria = parent.parent.parent.ClinicalRepMastAssociateFrame.addSectionsFrame.batsearchcri.document.forms[0].search_criteria.value;
var text= parent.parent.parent.ClinicalRepMastAssociateFrame.addSectionsFrame.batsearchcri.document.forms[0].search_text.value;


parent.parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp";
parent.batsearchres.location.href = "../../eCA/jsp/ClinicalRepMastBatchEventSearchResult.jsp?histype="+histype+"&contr="+contr+"&searchby="+searchby+"&criteria="+criteria+"&text="+text;
	}
}

function loadSectionsPage(obj,sec_heading_code,sec_heading_desc,chief_comp,tempSeq)
{
	
	var numberOfRecs = "";
	if(parent.sectionsFrame.document.clinicalRepMastBatchEventSelectedForm != null)
	{
		numberOfRecs = top.content.master_pages.ClinicalRepMastAssociateFrame.sectionsFrame.clinicalRepMastBatchEventSelectedForm.countOfRows.value;
		
	}
	if(obj.checked == true)
	{
		parent.removeRecFrame.document.write("<html><form name='remRecForm' id='remRecForm' action='../../eCA/jsp/ClinicalRepMastBatchRemoveEvent.jsp'><input type='hidden' name='sec_heading_code' id='sec_heading_code' value='"+sec_heading_code+"'><input type='hidden' name='sec_heading_desc' id='sec_heading_desc' value='"+sec_heading_desc+"'><input type='hidden' name='called_from' id='called_from' value='addSearch'><input type='hidden' name='chief_comp' id='chief_comp' value='"+chief_comp+"'><input type='hidden' name='noOfRows' id='noOfRows' value='"+numberOfRecs+"'></form></html>");
		parent.removeRecFrame.document.remRecForm.submit();
	}
	else
	{
		
	}
}

function loadSectionsPage1(obj,sec_heading_code,sec_heading_desc,chief_comp,tempSeq)
{
	
	var numberOfRecs = "";
	if(parent.sectionsFrame.document.clinicalRepMastRelinkEventSelectedForm != null)
	{
		numberOfRecs = top.content.master_pages.ClinicalRepMastAssociateFrame.sectionsFrame.clinicalRepMastRelinkEventSelectedForm.countOfRows.value;
	}

	//var seachText = parent.addSectionsFrame.document.secForNoteTypeSearchSectionsForm.searchText.value;
	if(obj.checked == true)
	{
		
		parent.removeRecFrame.document.write("<html><form name='remEventForm' id='remEventForm' action='../../eCA/jsp/ClinicalRepRelinkRemoveRecord.jsp'><input type='hidden' name='sec_heading_code' id='sec_heading_code' value='"+sec_heading_code+"'><input type='hidden' name='sec_heading_desc' id='sec_heading_desc' value='"+sec_heading_desc+"'><input type='hidden' name='called_from' id='called_from' value='addSearch'><input type='hidden' name='chief_comp' id='chief_comp' value='"+chief_comp+"'><input type='hidden' name='noOfRows' id='noOfRows' value='"+numberOfRecs+"'></form></html>");
		parent.removeRecFrame.document.forms[0].submit();
		
		
	}
	else
	{
		
		//removeRecord(obj,sec_heading_code)
	}
}

function loadSections()
{
	var searchText = document.clinicalRepMastBatchEventSearchForm.searchText.value;
	var search_criteria = document.clinicalRepMastBatchEventSearchForm.search_criteria.value;
	
	var radio="";
	if (document.clinicalRepMastBatchEventSearchForm.search_by[0].checked==true)
	radio=document.clinicalRepMastBatchEventSearchForm.search_by[0].value;
	else
	radio=document.clinicalRepMastBatchEventSearchForm.search_by[1].value;
	parent.addSectionsFrame.location.href = '../../eCA/jsp/ClinicalRepMastBatchEventSearch.jsp?searchText='+searchText+'&search_by='+radio+'&search_criteria='+search_criteria+'&flag=1';
}

function loadSections1()
{
	var searchText = document.clinicalRepMastBatchRelinkSearchForm.searchText.value;
	var search_criteria = document.clinicalRepMastBatchRelinkSearchForm.search_criteria.value;
	var hist_rec_type=top.content.master_pages.ClinicalRepMastSubFrame.ClinicalRepMastRelink_form.hist_rec_type.value;
    var event_code=top.content.master_pages.ClinicalRepMastSubFrame.ClinicalRepMastRelink_form.event_code.value;
    var contr_system=top.content.master_pages.ClinicalRepMastSubFrame.ClinicalRepMastRelink_form.contr_system.options[top.content.master_pages.ClinicalRepMastSubFrame.ClinicalRepMastRelink_form.contr_system.selectedIndex].text;
	
	var radio="";
	if (document.clinicalRepMastBatchRelinkSearchForm.search_by[0].checked==true)
	radio=document.clinicalRepMastBatchRelinkSearchForm.search_by[0].value;
	else
	radio=document.clinicalRepMastBatchRelinkSearchForm.search_by[1].value;
	parent.addSectionsFrame.location.href = '../../eCA/jsp/ClinicalRepConEventsSearch.jsp?searchText='+searchText+'&search_by='+radio+'&search_criteria='+search_criteria+'&flag=1'+'&hist_rec_type='+hist_rec_type+'&contr_system='+contr_system;
}



function removeRecord(obj,sec_heading_code,index)
{
	
	if(obj.checked != true)
	{
		parent.removeRecFrame.document.write("<html><form name='remRecForm' id='remRecForm' action='../../eCA/jsp/ClinicalRepMastBatchRemoveEvent.jsp'><input type='hidden' name='sec_heading_code' id='sec_heading_code' value='"+sec_heading_code+"'><input type='hidden' name='called_from' id='called_from' value='sectionsPage'><input type='hidden' name='index' id='index' value='"+index+"'></form></html>");
		parent.removeRecFrame.document.remRecForm.submit();
	}
}

function removeEvent(obj,sec_heading_code,index)
{
	
	if(obj.checked != true)
	{
		parent.removeRecFrame.document.write("<html><form name='remEventForm' id='remEventForm' action='../../eCA/jsp/ClinicalRepRelinkRemoveRecord.jsp'><input type='hidden' name='sec_heading_code' id='sec_heading_code' value='"+sec_heading_code+"'><input type='hidden' name='called_from' id='called_from' value='sectionsPage'><input type='hidden' name='index' id='index' value='"+index+"'></form></html>");
		parent.removeRecFrame.document.remEventForm.submit();
	}
}



function Reassaignbatch(obj)
{
	var return_format="";
		
	if(obj.checked == true)
	{
		
		var chkval = obj.value;
		//ret_str=parent.batsearchres.document.ClinicalEventGroupBatchEventSearchResultForm.ret_value[parseInt(chkval)].value+"@";
		ret_str=eval("parent.batsearchres.document.ClinicalEventGroupBatchEventSearchResultForm.ret_value"+chkval+".value")+"@";
					
		parent.parent.sectionsFrame.location.href="../../eCA/jsp/ClinicalRepMastBatchEventSelected.jsp?return_format="+escape(return_format)+"&ret_str="+escape(ret_str)+"";

		
		//parent.RecClinicalNotesLinkDiagSelectButtonsFrame.document.RecClinicalNotesLinkDiagSelectButtonsForm.select.disabled=false;
	}
			
	else
		{
			
			var chkval=obj.value;
			var remval=eval("parent.batsearchres.document.ClinicalEventGroupBatchEventSearchResultForm.chk_value"+chkval+".value")
			

			var remval2=eval("parent.batsearchres.document.ClinicalEventGroupBatchEventSearchResultForm.code_res"+chkval+".value")
			//parent.ret_str=parent.ret_str+parent.batsearchres.document.ClinicalEventGroupBatchEventSearchResultForm.ret_value[parseInt(remval)].value+"@";
			
		    
			parent.parent.sectionsFrame.location.href="../../eCA/jsp/ClinicalRepMastBatchEventSelected.jsp?return_format="+escape(return_format)+"&remval="+escape(remval2)+"&removebean=Y";
			
		}	
}
function chkunchk(objCheck)
{
	var index = 0;
	
	if(objCheck.checked==false)
	{
		//parent.batsearchres.document.ClinicalEventGroupBatchEventSearchResultForm.ctrlChkBox.checked=false
	}
	else
	{
		for(cnt=0; cnt<parent.batsearchres.document.ClinicalEventGroupBatchEventSearchResultForm.count.value; cnt++)
		{
			val = eval("parent.batsearchres.document.ClinicalEventGroupBatchEventSearchResultForm.chkbox"+cnt);
			if(val.checked == true) index++;
		}
		if(index == cnt)
		{
			//parent.batsearchres.document.ClinicalEventGroupBatchEventSearchResultForm.ctrlChkBox.checked=true
		}
	}	
}
function selText(obj1)
{
	var ret_str="";
	var return_format="";
	var clearchkval='';
	var clearremval='';
	var clearremval2='';
	if(!(obj1.checked==true))
	{
		clearchkval=obj1.value;
		clearremval=eval("parent.sectionsFrame.document.ClinicalEventGroupBatchBeanForm.clear"+clearchkval+".value");

		clearremval2=eval("parent.sectionsFrame.document.ClinicalEventGroupBatchBeanForm.selcode"+clearchkval+".value");

		makeresultcheck(clearremval2)
		
		parent.sectionsFrame.location.href="../../eCA/jsp/ClinicalRepMastBatchEventSelected.jsp?return_format="	+return_format+"&ret_str="+ret_str+"&remval="+escape(clearremval2)+"&removebean=Y";
		
		//makeresultcheck(clearremval2)

	}
}



function makeresultcheck(remval)
{
	if(parent.addSectionsFrame.batsearchres.document.ClinicalEventGroupBatchEventSearchResultForm!=null)
	{
	for(cnt=0; cnt<parent.addSectionsFrame.batsearchres.document.ClinicalEventGroupBatchEventSearchResultForm.count.value; cnt++)
	{
			val = eval("parent.addSectionsFrame.batsearchres.document.ClinicalEventGroupBatchEventSearchResultForm.chkbox"+cnt);

			//strval=eval("parent.addSectionsFrame.batsearchres.document.ClinicalEventGroupBatchEventSearchResultForm.chk_value"+cnt+".value");

			strval=eval("parent.addSectionsFrame.batsearchres.document.ClinicalEventGroupBatchEventSearchResultForm.code_res"+cnt+".value");

						
			if(strval==remval)
		{
				
				val.checked = false
   
			//parent.addSectionsFrame.batsearchres.document.ClinicalEventGroupBatchEventSearchResultForm.ctrlChkBox.checked = false 
		}

	}
	}
}
function searchGroup()
{

var histype=top.content.master_pages.ClinicalRepMastSubFrame.ClinicalRepMastRelink_form.hist_rec_type.value;
var event_code=top.content.master_pages.ClinicalRepMastSubFrame.ClinicalRepMastRelink_form.event_code.value;
    
var contr=top.content.master_pages.ClinicalRepMastSubFrame.ClinicalRepMastRelink_form.contr_system.options[top.content.master_pages.ClinicalRepMastSubFrame.ClinicalRepMastRelink_form.contr_system.selectedIndex].text;

var searchby = "";
if(top.content.master_pages.ClinicalRepMastAssociateFrame.addSectionsFrame.linksearchcri.document.forms[0].search_by[0].checked==
	true)
searchby=top.content.master_pages.ClinicalRepMastAssociateFrame.addSectionsFrame.linksearchcri.document.forms[0].search_by[0].value;
else
searchby=top.content.master_pages.ClinicalRepMastAssociateFrame.addSectionsFrame.linksearchcri.document.forms[0].search_by[1].value;

var criteria = top.content.master_pages.ClinicalRepMastAssociateFrame.addSectionsFrame.linksearchcri.document.forms[0].search_criteria.value;
var text= top.content.master_pages.ClinicalRepMastAssociateFrame.addSectionsFrame.linksearchcri.document.forms[0].search_text.value;

 top.content.master_pages.ClinicalRepMastAssociateFrame.addSectionsFrame.linksearchres.location.href="../../eCA/jsp/ClinicalRepEventRelinkSearchResult.jsp?histype="+histype+"&contr="+contr+"&searchby="+searchby+"&criteria="+criteria+"&text="+text+"";
	
}
function Reassaignrelink(obj)
{
	var return_format="";
	
		
	if(obj.checked==true)
	{
		var chkval = obj.value;
		//ret_str=parent.batsearchres.document.ClinicalEventGroupBatchEventSearchResultForm.ret_value[parseInt(chkval)].value+"@";
		ret_str=eval("parent.linksearchres.document.ClinicalEventGroupRelinkEventSearchResultForm.ret_value"+chkval+".value")+"@";
		parent.parent.sectionsFrame.location.href="../../eCA/jsp/ClinicalRepConEventsSelected.jsp?return_format="+return_format+"&ret_str="+escape(ret_str)+"";
		//parent.RecClinicalNotesLinkDiagSelectButtonsFrame.document.RecClinicalNotesLinkDiagSelectButtonsForm.select.disabled=false;
	}
			
	else
		{
			var chkval=obj.value;
			var remval=eval("parent.linksearchres.document.ClinicalEventGroupRelinkEventSearchResultForm.chk_value"+chkval+".value")
			
			//parent.ret_str=parent.ret_str+parent.batsearchres.document.ClinicalEventGroupBatchEventSearchResultForm.ret_value[parseInt(remval)].value+"@";
			parent.parent.sectionsFrame.location.href="../../eCA/jsp/ClinicalRepConEventsSelected.jsp?return_format="+return_format+"&remval="+escape(remval)+"&ret_str="+escape(ret_str)+"&removebean=Y";
			
		}	
}
function chkunchkrelink(objCheck)
{
	var index = 0;
	if(objCheck.checked==false)
	{
		//parent.linksearchres.document.ClinicalEventGroupRelinkEventSearchResultForm.ctrlChkBox.checked=false
	}
	else
	{
		for(cnt=0; cnt<parent.linksearchres.document.ClinicalEventGroupRelinkEventSearchResultForm.count.value; cnt++)
		{
			val = eval("parent.linksearchres.document.ClinicalEventGroupRelinkEventSearchResultForm.chkbox"+cnt);
			if(val.checked == true) index++;
		}
		if(index == cnt)
		{
			//parent.linksearchres.document.ClinicalEventGroupRelinkEventSearchResultForm.ctrlChkBox.checked=true
		}
	}	
}
function scrollTitleRelink()
{
	
  var y = parent.linksearchres.ClinicalEventGroupRelinkEventSearchResultForm.document.body.scrollTop;

  if(y == 0){
	parent.linksearchres.ClinicalEventGroupRelinkEventSearchResultForm.document.getElementById("divDataTitle").style.position = 'static';
	parent.linksearchres.ClinicalEventGroupRelinkEventSearchResultForm.document.getElementById("divDataTitle").style.posTop  = 0;
  }else{
	parent.linksearchres.ClinicalEventGroupRelinkEventSearchResultForm.document.getElementById("divDataTitle").style.position = 'relative';
	parent.linksearchres.ClinicalEventGroupRelinkEventSearchResultForm.document.getElementById("divDataTitle").style.posTop  = y-2;
  }

}

