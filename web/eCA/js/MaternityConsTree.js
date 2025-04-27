function callfunction(){
	top.content.CommonToolbar.ShowMenu.style.display='none';
	top.content.CommonToolbar.HideMenu.style.display='inline';
}

function loadtreesplty(obj){
	parent.matFrame.maternityMenu.req_event_code.value=parent.matFrame.maternityMenu.obgstatus.value;
	self.location.href='../../eCA/jsp/MaternityConsTree.jsp?req_event_code='+obj.value+'&module_id='+document.maternityMenu.module_id.value+'&patient_id='+document.maternityMenu.patient_id.value;
}

function loadRecScreen()
{
	var queryString = document.tempmaternityMenu.queryString.value;
	parent.parent.workAreaFrame.location.href = '../../eCA/jsp/RecMaternityCons.jsp?'+queryString+'&sec_hdg_code=MCMN&sectionType=TG&splty_event_code=MCE001&splty_task_code=MCT001&cycle_no=0';
}

function loadViewScreen()
{
	var queryString = document.tempmaternityMenu.queryString.value;
	parent.parent.workAreaFrame.location.href = '../../eCA/jsp/RecMaternityCons.jsp?'+queryString+'&sec_hdg_code=MCMN&sectionType=TG&splty_event_code=MCE001&splty_task_code=MCT001&cycle_no=0&modeValue=V';

}

function loadeventscycle(NewEvent){
	var queryString = document.tempmaternityMenu.queryString.value;
	//alert("queryString"+queryString);
	parent.parent.workAreaFrame.location.href = '../../eCA/jsp/MaternityConsMain.jsp?NewEvent='+NewEvent+'&'+queryString+'&new_cycle=N';
}


function loadecycle(obj){
	var module_id	= document.tempmaternityMenu.module_id.value;
	var patient_id	= document.tempmaternityMenu.patient_id.value;
	var splty_title_event_desc	= document.tempmaternityMenu.splty_title_event_desc.value;
	parent.maternitytreeframe.location.href = '../../eCA/jsp/MaternityConsMenu.jsp?'+'sel_cycle_no='+obj+'&'+document.tempmaternityMenu.queryString.value;
}

function loadeventselect(selObj){
	var module_id = document.tempmaternityMenu.module_id.value;
	var patient_id = document.tempmaternityMenu.patient_id.value;
	var cycle_no = document.tempmaternityMenu.cycle_select.value;

	if(selObj.value != '')
	{
		var obj=document.tempmaternityMenu.cycle_select.value
		if(obj!=0)
		{
			parent.maternitytreeframe.location.href = '../../eCA/jsp/MaternityConsMenu.jsp?'+'sel_cycle_no='+document.tempmaternityMenu.cycle_select.value+'&'+document.tempmaternityMenu.queryString.value;
			parent.parent.workAreaFrame.location.href = '../../eCA/jsp/CycleFrame.jsp?module_id='+module_id+'&patient_id='+patient_id+'&cycle_no='+cycle_no;
		}
	}
	else
	{
		loadeventscycle('');
	}
}

function chk_event_status()
{

		
		var patient_id = document.matconsscycle.patient_id.value;
		var event_sel=parent.matcycleframe.matconsscycle.event_select.value;

		if(event_sel=='MCE008'||event_sel=='MCE009'||event_sel=='MCE004'||event_sel=='MCE012')
		{

		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();
		xmlStr	="<root><SEARCH " ;
		xmlStr +=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST","../../eCA/jsp/RecMaternityConsIntermediate.jsp?patient_id="+patient_id+"&splty_event_code="+event_sel, false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText;
		responseText = eval(responseText);
		}
		else
		{
			recordevent();
		}

}

function event_allow_yn(allow_yn)
{
	
	if(allow_yn==''||allow_yn==null||allow_yn=='MOTHER_CUTOFF_AGE')
	{
		
		if(allow_yn=='MOTHER_CUTOFF_AGE')
			{
				alert(getMessage(allow_yn,"MP"));
			}
		recordevent();
	}
	else
	{		
		alert(getMessage(allow_yn,"MP"));
	}

}


function recordevent(){
	parent.matcycleframe.matconsscycle.mode.value='NEW'
	parent.matcycleframe.matconsscycle.splty_event_code.value=parent.matcycleframe.matconsscycle.event_select.value
	parent.matcycleframe.document.matconsscycle.action='../../servlet/eCA.MaternityConsServlet';
	parent.matcycleframe.document.matconsscycle.target='messageFrame';
	parent.matcycleframe.document.matconsscycle.method='post';
	parent.matcycleframe.document.matconsscycle.submit();
}

function onSuccess(){
	//parent.frames[1].frames[1].location.reload();

}

function loadSpecialtyEventHistScreen(module_id,patient_id,cycle_no)
{
	var queryString = document.tempmaternityMenu.queryString.value;
	var finalString="&module_id="+module_id+"&patient_id="+patient_id+"&cycle_no="+cycle_no;
	parent.parent.workAreaFrame.location.href = '../../eCA/jsp/ViewSpecialtyEventHist.jsp?'+finalString+queryString+'&sec_hdg_code=MCMN&sectionType=TG&splty_event_code=MCE001&splty_task_code=MCT001';
}

function callHomePage()
{
	var cycle_select = document.tempmaternityMenu.cycle_select.value;
	var queryString = document.tempmaternityMenu.queryString.value;
	parent.parent.workAreaFrame.location.href = '../../eCA/jsp/SpltyHomePageTabHome.jsp?cycle_no='+cycle_select+'&'+queryString;
}

function enableGoButton(obj)
{
	if(obj.value != '')
		document.matconsscycle.Record.disabled = false;
	else
		document.matconsscycle.Record.disabled = true;
}
