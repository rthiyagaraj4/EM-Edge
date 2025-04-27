
function create(){
	f_query_add_mod.location.href='../../eRS/jsp/ShiftPatternForWorkplaceFrameset.jsp?mode='+MODE_INSERT;
}
/*****************************************************************/
function query()
{
	f_query_add_mod.location.href = "../../eRS/jsp/ShiftPatternForWorkplaceQueryCriteria.jsp?mode=2";
}
/***********************************************************/
function apply(){

	if (!checkIsValidForProceed()){
		message  = "";
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		return false ;
	}
	if (!checkIsValidForProceed1()){
		message  = "";
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		return false ;
	}
	if (!checkIsValidForProceed2()){
		//message  = getMessage("NOT_VALID","Common");
		//messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		var frmobj=f_query_add_mod.frameSelect.document.forms[0];
		if(frmobj==f_query_add_mod.frameSelect.document.form_byWorkplace)
		{
			var fields = new Array (frmobj.workplace_desc);
			var names = new Array (getLabel("eRS.WorkPlace.label","RS"));
			if(f_query_add_mod.frameSelect.checkFieldsofMst( fields, names, messageFrame))
			parent.frames[1].messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
		}

		else if(frmobj==f_query_add_mod.frameSelect.document.form_byShiftPattern)
		{
		
			var fields = new Array (frmobj.shift_pattern_desc);
			var names = new Array (getLabel("eRS.ShiftPattern.label","RS"));
			if(f_query_add_mod.frameSelect.checkFieldsofMst( fields, names, messageFrame))
			parent.frames[1].messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
		}
		return false ;
	}
	var url = f_query_add_mod.frameList.location.href;

	if(!(url.indexOf("byShiftPatternFrame")==-1))
		var frmObj=frames[1].frames[2].frames[1].document.forms[0];
	else
		var frmObj=frames[1].frames[2].document.forms[0];
	var cnt=0;
	for(cnt=0;cnt<frmObj.totalRecords.value; cnt++){
		var select=eval("frmObj.select_yn"+cnt);
		if(select.checked==true){
				select.value="Y";
		}else{
			select.value="N";
		}
	}
	frmObj.submit();
}
/********************************************************************/
function reset(){
	var url=f_query_add_mod.location.href;
	if(url.indexOf("blank")==-1) {
		if(url.indexOf("Query")==-1){
			url=frames[1].frameSelect.location.href;
			if(url.indexOf("blank")==-1) {
				var frmObj=frames[1].frameSelect.document.forms[0]
				url=frames[1].frameList .location.href;
				if(url.indexOf("blank")==-1) {
					if(!(url.indexOf("byShiftPattern")==-1)) {
						url=frames[1].frameList.frameWorkplaceList .location.href;
						if(url.indexOf("blank")==-1) {
							frames[1].frameList.frameWorkplaceList.document.forms[0].reset();
							messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp";
						}
					}else{
						frames[1].frameList.document.forms[0].reset();
						messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp";
				}
				}else{
					frmObj.reset();
					var i=0;
					while(frmObj.elements(i)!=null){
						frmObj.elements(i).disabled=false;
						i++;
					}
					frmObj.elements(0).focus()
				}
			}
			else
				f_query_add_mod.location.href='../../eCommon/html/blank.html';
			}
		else
			f_query_add_mod.document.forms[0].reset();
	}
}
/*****************************************************************/
function getWorkplace(){
	parent.frameSelect.location.href='../../eRS/jsp/ShiftPatternForWorkplacebyWorkplace.jsp?mode='+MODE_INSERT;
	parent.frameList.location.href='../../eCommon/html/blank.html';
	parent.parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp";
}
/*****************************************************************/
function getShiftPattern(){

	parent.frameSelect.location.href='../../eRS/jsp/ShiftPatternForWorkplacebyShiftPattern.jsp?mode='+MODE_INSERT;
	parent.frameList.location.href='../../eCommon/html/blank.html';
	parent.parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp";
}
/*****************************************************************/
function showWrkplace(call_mode, target){

	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;

	var frmObj		=parent.frameSelect.document.form_byWorkplace;
	var workplace_desc = frmObj.workplace_desc.value;
	
	if((call_mode =='T')&&(workplace_desc =='')){
		frmObj.workplace_code.value='';
		return false;
	}

	if(!(frmObj.workplace_code.value=="")){
		frmObj.workplace_code.value='';
		frmObj.workplace_desc.value='';
	}
	var facility_id		=frmObj.facility_id.value;
	var locale	=frmObj.locale.value;
	var locn_type		=frmObj.locn_type[frmObj.locn_type.selectedIndex].value;
	var locn_desc	=frmObj.locn_type[frmObj.locn_type.selectedIndex].text;

	//var sql_workplace_lookup = "select workplace_code code,workplace_desc description from rs_workplace where facility_id='"+facility_id+"' and ('"+locn_type+"' is null or locn_type='"+locn_type+"') and upper(workplace_code) like(upper(?))  and upper(workplace_desc) like(upper(?))";
	var sql_workplace_lookup = "select workplace_code code,workplace_desc description from rs_workplace_lang_vw where facility_id='"+facility_id+"' and ('"+locn_type+"' is null or locn_type='"+locn_type+"') and upper(workplace_code) like(upper(?))  and upper(workplace_desc) like(upper(?)) and language_id = '"+locale+"'";
	//alert("sql_workplace_lookup===>");	
	argumentArray[0] = sql_workplace_lookup;

	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2";
	argumentArray[5] = target.value;
	argumentArray[6] = CODE_LINK ;//CODE_LINK
	argumentArray[7] = CODE_DESC ;//CODE_DESC
	//alert("showWrkplace--------------->");
	retVal = CommonLookup(getLabel("eRS.WorkPlace.label","RS"),argumentArray);
	//alert(retVal);
	//alert("showWrkplace11--------------->");
	//alert(retVal);
	
	if(retVal != null && retVal != "") {
		target.value = retVal[1] ;
		frmObj.workplace_code.value = retVal[0];
	}else
		target.value ="";
}
/*****************************************************************/
function showShiftPattern(call_mode, target){

	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	
	var frmObj		=parent.frameSelect.document.form_byShiftPattern;
	var shift_pattern_desc = frmObj.shift_pattern_desc.value;
	if((call_mode =='T')&&(shift_pattern_desc =='')){
		frmObj.shift_pattern_id.value='';
		return false;
	}
	//alert("show shift pattern----------------->");
	if(!(frmObj.shift_pattern_id.value=="")){
		frmObj.shift_pattern_id.value='';
		frmObj.shift_pattern_desc.value='';
	}
	var facility_id		=frmObj.facility_id.value;
	var locale	=frmObj.locale.value;
	var locn_type		=frmObj.locn_type[frmObj.locn_type.selectedIndex].value;
	var locn_desc	=frmObj.locn_type[frmObj.locn_type.selectedIndex].text;
	

	//argumentArray[0] ="select shift_pattern_id code, short_desc description from rs_shift_pattern where facility_id='"+facility_id+"' and  ('"+locn_type+"' is null or locn_type='"+locn_type+"') and upper(shift_pattern_id) like upper(?) and upper(short_desc) like upper(?) and eff_status='E' order by short_desc";
	argumentArray[0] ="select shift_pattern_id code, short_desc description from rs_shift_pattern_lang_vw where facility_id='"+facility_id+"' and  ('"+locn_type+"' is null or locn_type='"+locn_type+"') and upper(shift_pattern_id) like upper(?) and upper(short_desc) like upper(?) and eff_status='E' and language_id = '"+locale+"' order by short_desc";
	//alert("showshiftpatternquery---------->");
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2"; 
	argumentArray[5] = target.value;
	argumentArray[6] = CODE_LINK ;//CODE_LINK
	argumentArray[7] = CODE_DESC ;//CODE_DESC
	//alert("After first alert---------->");
	retVal = CommonLookup(getLabel("eRS.ShiftPattern.label","RS"),argumentArray);
	//alert(retVal);
	if(retVal != null && retVal != "") {
		target.value = retVal[1] ;
		frmObj.shift_pattern_id.value = retVal[0];
	}
	else{
		target.value ="";
		parent.frameList.location.href='../../eCommon/html/blank.html';
	}
         
	if(target.value != ""){
		var shift_pattern_id=frmObj.shift_pattern_id.value;
		var week_count=frmObj.week_count.value;
		parent.frameList.location.href="../../eRS/jsp/ShiftPatternForWorkplacebyShiftPatternFrame.jsp?shift_pattern_id="+shift_pattern_id+"&week_count="+week_count;
	}
}
/*****************************************************************/

function listShiftPattern(week_count){
	var frmObj		=parent.frameSelect.document.form_byWorkplace;
	var mode		= frmObj.mode.value;
	var locn_type		= frmObj.locn_type[frmObj.locn_type.selectedIndex].value;
	var locn_desc		= frmObj.locn_type[frmObj.locn_type.selectedIndex].text;
	var workplace_desc		= frmObj.workplace_desc.value;
	var workplace_code		= frmObj.workplace_code.value;

	var fields = new Array (frmObj.workplace_code);			    
	var names = new Array (getLabel("eRS.WorkPlace.label","RS"));		
	//alert("show list pattern----------->");
	if(parent.parent.f_query_add_mod.checkFieldsofMst( fields, names, parent.parent.messageFrame)){	
		parent.frameList.location.href="../../eRS/jsp/ShiftPatternForWorkplaceShowShiftPattern.jsp?locn_type="+locn_type+"&workplace_code="+workplace_code+"&week_count="+week_count+"&form_name="+frmObj.name+"&mode="+mode;
		parent.parent.messageFrame.location.href =  "../../eCommon/jsp/MstCodeError.jsp";
		var i=0;
	//alert("show list pattern----------->");
		while(frmObj.elements(i)!=null){
				frmObj.elements(i).disabled=true;
				i++;
		}
	}
}
/*****************************************************************/
function listWorkplace(){
	var frmObj		=parent.parent.frameSelect.document.form_byShiftPattern;
	var mode		= frmObj.mode.value;
	var locn_type		= frmObj.locn_type[frmObj.locn_type.selectedIndex].value;
	var locn_desc		= frmObj.locn_type[frmObj.locn_type.selectedIndex].text;
	var shift_pattern_desc		= frmObj.shift_pattern_desc.value;
	var shift_pattern_id		= frmObj.shift_pattern_id.value;
	var i=0;
	//alert("Showlist work place---------->");
	while(frmObj.elements(i)!=null){
			frmObj.elements(i).disabled=true;
			i++;
	}
	//alert("Showlist work place123---------->");
	parent.parent.frameList.frameWorkplaceList.location.href="../../eRS/jsp/ShiftPatternForWorkplaceShowWorkplace.jsp?locn_type="+locn_type+"&shift_pattern_id="+shift_pattern_id+"&form_name="+frmObj.name+"&mode="+mode;
	//alert("Showlist work place1234---------->");
	parent.parent.parent.messageFrame.location.href =  "../../eCommon/jsp/MstCodeError.jsp";
	parent.frameshiftpatterndtl.document.formShiftPatternDetails.listworkplace.disabled=true;
}
/*****************************************************************/
function locn_change(form_name){
	var frmname=form_name.value;
	if(frmname=="form_byWorkplace"){
		var frmObj		=parent.frameSelect.document.form_byWorkplace;
		frmObj.workplace_desc.value='';
		frmObj.workplace_code.value='';
	}
	else
	if(frmname=="form_byShiftPattern"){
		var frmObj		=parent.frameSelect.document.form_byShiftPattern;
		frmObj.shift_pattern_desc.value='';
		frmObj.shift_pattern_id.value='';
	}
}
/*****************************************************************/
function click_selectall(form_name){
	var frmname=form_name.value;

	if(frmname=="form_listWorkplace")
		var frmObj		=parent.parent.frameList.frameWorkplaceList.document.form_listWorkplace;
	else
		var frmObj		=parent.frameList.document.form_listShiftPattern;

	var select=frmObj.selectall;
	var i=0;
	if(select.checked == true){
		while(eval("frmObj.select_yn"+i)!=null){
			val = eval("frmObj.select_yn"+i);
			val.checked = true;
			i++;
		}
	}else{
		while(eval("frmObj.select_yn"+i)!=null){
			val = eval("frmObj.select_yn"+i);
			val.checked = false;
			i++;
		}
	}
}
/*****************************************************************/
function assignResult(_result, _message, _flag){
	result = _result ;
	message  = _message ;
	flag = _flag ;
}
/*****************************************************************/
function onSuccess() {
		//parent.frames[1].frames[1].frames[2].location.href='../../eCommon/html/blank.html'; -----commented on 19/11/08----
		parent.frames[2].frames[1].frames[2].location.href='../../eCommon/html/blank.html';
		parent.frames[2].frames[1].frames[1].document.forms[0].reset();
		//parent.frames[1].frames[1].frames[1].document.forms[0].reset(); -----commented on 19/11/08------------
		var frmObj=frames[1].frameSelect.document.forms[0]
		frmObj.reset();
		var i=0;
		while(frmObj.elements(i)!=null)
		{
			frmObj.elements(i).disabled=false;
			i++;
		}
		frmObj.elements(0).focus()
}
/*****************************************************************/
function checkIsValidForProceed(){
	
	var url = f_query_add_mod.location.href;
	url = url.toLowerCase();
	if ( (url.indexOf("queryresult.jsp")==-1) && (url.indexOf("query")==-1)&&(url.indexOf("blank")==-1) )
		return true;
	else
		return false;
}
/*****************************************************************/
function checkIsValidForProceed1(){
	
	var url = f_query_add_mod.frameSelect.location.href;
	url = url.toLowerCase();
	if ( (url.indexOf("queryresult.jsp")==-1) && (url.indexOf("query")==-1)&&(url.indexOf("blank")==-1) )
		return true;
	else
		return false;
}
/*****************************************************************/
function checkIsValidForProceed2(){
	
	var url = f_query_add_mod.frameList.location.href;
	url = url.toLowerCase();
	if ((url.indexOf("queryresult.jsp")==-1) && (url.indexOf("query")==-1)&&(url.indexOf("blank")==-1) )
	{
		if(url.indexOf("byshiftpatternframe")==-1)
			return true;
		else{
			url=f_query_add_mod.frameList.frameWorkplaceList.location.href;
			if(url.indexOf("blank")==-1)
				return true;
			else
				return false;
		}
	}
	else
		return false;
}
/*****************************************************************/
