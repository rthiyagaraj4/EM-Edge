function create() 
{ 
	//f_query_add_mod.location.href = "../../eIP/jsp/addModifyNursingUnit.jsp" ;
}
 
function query() 
{
	//f_query_add_mod.location.href ="../../eIP/jsp/NursingUnitQueryCriteria.jsp" ;
}

function apply(){
	if(blank.bedMgmtSetupForm.setupFor.value=='R'){
		if(f_query_add_mod.document.roomLayOutMgmt){
			f_query_add_mod.submitRoomLayout();
			messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num=&err_value=0';
			return false;
		}
	}else if(blank.bedMgmtSetupForm.setupFor.value=='B'){
		if(f_query_add_mod.document.bedLayOutMgmt){
			f_query_add_mod.submitBedLayout();
			messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num=&err_value=0';
			return false;
		}else{
			messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num=&err_value=0';
					return false;
		}
	}else if(blank.bedMgmtSetupForm.setupFor.value=='F'){
		if(f_query_add_mod.document.floorLayOutMgmt){
			f_query_add_mod.submitFloorLayout();
			messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num=&err_value=0';
			return false;
		}else{
			messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num=&err_value=0';
			return false;
		}
	}else if(blank.bedMgmtSetupForm.setupFor.value=='CC'){
		f_query_add_mod.submitColorCoding();
	}else{
		messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num=&err_value=0';
		return false;
	}
}

function reset(){
	if(f_query_add_mod.document.floorLayOutMgmt){
		f_query_add_mod.location.href='../../eIP/jsp/IPAdvBedMgmtNursingUnitFloorLayout.jsp?nursingUnit='+blank.document.bedMgmtSetupForm.nursing_unit.value;
	}else if(f_query_add_mod.document.roomLayOutMgmt){
		f_query_add_mod.location.href='../../eIP/jsp/IPAdvBedMgmtNursingUnitFloorRoomLayout.jsp?nursingUnit='+blank.document.bedMgmtSetupForm.nursing_unit.value;
	}else if(f_query_add_mod.document.bedLayOutMgmt){
		var url="../../eIP/jsp/IPAdvBedMgmtNursingUnitRoomBedLayout.jsp?room="+blank.document.bedMgmtSetupForm.room.value+"&nursingUnit="+blank.document.bedMgmtSetupForm.nursing_unit.value;
		f_query_add_mod.location.href=url;
	}else if(f_query_add_mod.document.getElementById('bed_cloror_config')){
		f_query_add_mod.location.href="../../eIP/jsp/IPAdvBedMgmtColorCoding.jsp";
	}
}

function popDynamicValues(obj){
	parent.f_query_add_mod.location.href = "../../eCommon/html/blank.html";
	if(parent.blank.bedMgmtSetupForm.setupFor.value=='R'){
		//parent.f_query_add_mod.location.href='../../eIP/jsp/IPNursingUnitFloorRoomLayout.jsp?nursingUnit='+obj.value;
		parent.f_query_add_mod.location.href='../../eIP/jsp/IPAdvBedMgmtNursingUnitFloorRoomLayout.jsp?nursingUnit='+obj.value;
	}else if(parent.blank.bedMgmtSetupForm.setupFor.value=='B'){
		
		removeitems(parent.blank.document.bedMgmtSetupForm.room);
		
		var objname= obj.name ;
		
		var dynamicHTML = "";
		dynamicHTML+=  "<html>"
		dynamicHTML+=  "<body CLASS='MESSAGE' onKeyDown='lockKey()'><form name='hidForm' id='hidForm' action='../../eIP/jsp/IPAdvBedMgmtFetchRoomsNursingUnits.jsp'>"
		dynamicHTML+="<input type='hidden' name='object_name' id='object_name' value='"+objname+"'>"
		dynamicHTML+="<input type='hidden' name='object_val' id='object_val' value='"+obj.value+"'>"
		/*if(other_code!="" && other_code!=null)
			dynamicHTML+="<input type='hidden' name='other_code' id='other_code' value='"+other_code+"'>"
		if(room_no!="" && room_no!=null)
			dynamicHTML+="<input type='hidden' name='room_no' id='room_no' value='"+room_no+"'>"*/

		dynamicHTML+="</form></body></html>"
		parent.messageFrame.document.write(dynamicHTML);
		parent.messageFrame.document.hidForm.submit();
		if(parent.blank.document.bedMgmtSetupForm.nursing_unit.value=="")
		{
		  removeitems(parent.blank.document.bedMgmtSetupForm.room);
		}
	}else{
		//parent.f_query_add_mod.location.href='../../eIP/jsp/IPNursingUnitFloorLayout.jsp?nursingUnit='+obj.value;
		parent.f_query_add_mod.location.href='../../eIP/jsp/IPAdvBedMgmtNursingUnitFloorLayout.jsp?nursingUnit='+obj.value;
	}
}

function removeitems(obj){
	var len=obj.length;
	var i=1;
	while(i<len)	{
		len=obj.length
		obj.remove(i)
	}
}
function dipslayRoom(obj){
	parent.f_query_add_mod.location.href = "../../eCommon/html/blank.html";
	parent.blank.document.bedMgmtSetupForm.nursing_unit.value='';
	parent.blank.document.bedMgmtSetupForm.room.value='';
	removeitems(parent.blank.document.bedMgmtSetupForm.nursing_unit);
	removeitems(parent.blank.document.bedMgmtSetupForm.room);
	/*parent.blank.document.bedMgmtSetupForm.all.nursingUnitlabeltd.style.visibility="hidden";
	parent.blank.document.bedMgmtSetupForm.all.roomlabeltd.style.visibility="hidden";
	parent.blank.document.bedMgmtSetupForm.all.roomtd.style.visibility="hidden";*/
	
	document.querySelector("#nursingUnitlabeltd").style.visibility="hidden";
	document.querySelector("#roomlabeltd").style.visibility="hidden";
	document.querySelector("#roomtd").style.visibility="hidden";
	if(obj.value=='F'){
//		parent.blank.document.bedMgmtSetupForm.all.nursingUnitlabeltd.style.visibility="visible";
		document.querySelector("#nursingUnitlabeltd").style.visibility="visible";
		var objname= obj.name 
		var dynamicHTML = "";
		dynamicHTML+=  "<html>"
		dynamicHTML+=  "<body CLASS='MESSAGE' onKeyDown='lockKey()'><form name='hidForm' id='hidForm' action='../../eIP/jsp/IPAdvBedMgmtFetchRoomsNursingUnits.jsp'>"
		dynamicHTML+="<input type='hidden' name='operation' id='operation' value='fetchNursingUnit_floor'>"
		dynamicHTML+="</form></body></html>"
		parent.messageFrame.document.write(dynamicHTML);
		parent.messageFrame.document.hidForm.submit();
	}else if(obj.value=='R'){
//		parent.blank.document.bedMgmtSetupForm.all.nursingUnitlabeltd.style.visibility="visible";
		document.querySelector("#nursingUnitlabeltd").style.visibility="visible";
		
		var objname= obj.name 
		var dynamicHTML = "";
		dynamicHTML+=  "<html>"
		dynamicHTML+=  "<body CLASS='MESSAGE' onKeyDown='lockKey()'><form name='hidForm' id='hidForm' action='../../eIP/jsp/IPAdvBedMgmtFetchRoomsNursingUnits.jsp'>"
		dynamicHTML+="<input type='hidden' name='operation' id='operation' value='fetchNursingUnit'>"
		dynamicHTML+="</form></body></html>"
		parent.messageFrame.document.write(dynamicHTML);
		parent.messageFrame.document.hidForm.submit();	
	}else if(obj.value=='B'){ 
//		parent.blank.document.bedMgmtSetupForm.all.nursingUnitlabeltd.style.visibility="visible";
		document.querySelector("#nursingUnitlabeltd").style.visibility="visible";
		var objname= obj.name 
		var dynamicHTML = "";
		dynamicHTML+=  "<html>"
		dynamicHTML+=  "<body CLASS='MESSAGE' onKeyDown='lockKey()'><form name='hidForm' id='hidForm' action='../../eIP/jsp/IPAdvBedMgmtFetchRoomsNursingUnits.jsp'>"
		dynamicHTML+="<input type='hidden' name='operation' id='operation' value='fetchNursingUnit'>"
		dynamicHTML+="</form></body></html>"
		parent.messageFrame.document.write(dynamicHTML);
		parent.messageFrame.document.hidForm.submit();
		
		/*parent.blank.document.bedMgmtSetupForm.all.roomlabeltd.style.visibility='visible';
		parent.blank.document.bedMgmtSetupForm.all.roomtd.style.visibility='visible';*/
		document.querySelector("#roomlabeltd").style.visibility="visible";
		document.querySelector("#roomtd").style.visibility="visible";
		
		
	}else if(obj.value=='CC'){
		//parent.f_query_add_mod.location.href="../../eIP/jsp/IPBedMgmtColorCoding.jsp";		
		parent.f_query_add_mod.location.href="../../eIP/jsp/IPAdvBedMgmtColorCoding.jsp";
	}
}
function roomBedLayout(obj){
	if(obj.value==''){
		parent.f_query_add_mod.location.href = "../../eCommon/html/blank.html";
	}else{
		//parent.f_query_add_mod.location.href="../../eIP/jsp/IPNursingUnitRoomBedLayout.jsp?room="+obj.value+"&nursingUnit="+parent.blank.document.bedMgmtSetupForm.nursing_unit.value;
		parent.f_query_add_mod.location.href="../../eIP/jsp/IPAdvBedMgmtNursingUnitRoomBedLayout.jsp?room="+obj.value+"&nursingUnit="+parent.blank.document.bedMgmtSetupForm.nursing_unit.value;
	}
}
function submitLayout(){
	if(parent.blank.bedMgmtSetupForm.setupFor.value=='R'){
		if(parent.f_query_add_mod.document.roomLayOutMgmt)
			parent.f_query_add_mod.submitRoomLayout();
	}else if(parent.blank.bedMgmtSetupForm.setupFor.value=='B'){
		if(f_query_add_mod.document.bedLayOutMgmt){
			f_query_add_mod.submitBedLayout();
			parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num=&err_value=0';
			return false;
		}else{
			parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num=&err_value=0';
					return false;
		}
	}else if(parent.blank.bedMgmtSetupForm.setupFor.value=='F'){alert('1')
		if(f_query_add_mod.document.floorLayOutMgmt){alert('2')
			f_query_add_mod.submitFloorLayout();
			parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num=&err_value=0';
			return false;
		}else{
			parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num=&err_value=0';
			return false;
		}
	}
}

function updateTextColor(obj){
	
	if(obj=='W'){
		$('#'+$("input[id=selectedElem]").val()+'_Text').css('color','FFFFFF');
	}else{
		$('#'+$("input[id=selectedElem]").val()+'_Text').css('color','000000');
	}
}



