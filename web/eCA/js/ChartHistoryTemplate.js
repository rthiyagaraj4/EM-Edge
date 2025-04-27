function query(){}

function clearRowVal(){
		var rows		= parent.frames[0].document.forms[0].rows.value;
		var cols		= parent.frames[0].document.forms[0].cols.value;
		var total = eval(rows * cols);
		for(i=0;i<total;i++)	{
			obj = eval("parent.frames[1].document.forms[0].check"+i);
			if(obj.checked==true){
				eval("parent.frames[1].document.forms[0].row_pos"+i+".value=''");
				eval("parent.frames[1].document.forms[0].col_pos"+i+".value=''");
				eval("parent.frames[1].document.forms[0].row_span"+i+".value=''");
				eval("parent.frames[1].document.forms[0].col_span"+i+".value=''");
				eval("parent.frames[1].document.forms[0].cont_id"+i+".value=''");
				eval("parent.frames[1].document.forms[0].check"+i+".checked=false");
			}
		}			
}

function create(){ 
		Chart_Create.location.href="../../eCA/jsp/ChartHistoryTemplateAddModify.jsp"
}

function takes(){
		var rows = parent.frames[0].document.forms[0].rows.value;
		var cols = parent.frames[0].document.forms[0].cols.value;
		var SelectYNStr = "";
		var total = eval(rows * cols);
}
function reset(){ 
		var chkJsp = Chart_Create.HeaderFrame.location.href;
		if(chkJsp.indexOf(".jsp") != -1){
				Chart_Create.HeaderFrame.document.location.href="../../eCA/jsp/DynamictabHrd.jsp";
				if (Chart_Create.DetailsFrame.document){
						Chart_Create.DetailsFrame.document.location.href="../../eCommon/html/blank.html";
				}	
		}else {
			return false;
		}
}

function checkMandatoryFields( fields, names, messageFrame, errorPage){
		var errors = ""; 
		var firstNullObject = null;
	   for( var i=0; i<fields.length; i++){		  
		    if((fields[i])!=""){

			}else {
				errors =  errors + getMessage("CAN_NOT_BE_BLANK","Common")+"<br>";
				errors = errors.replace('$', names[i]);						
	        }
		}
		if ( errors.length != 0 ) {
			messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+errors+"&err_value=0";
			firstNullObject = 1;	
		}
		return firstNullObject;
}

function apply()
{
	
	if(Chart_Create.HeaderFrame.document.forms[0] != null && Chart_Create.DetailsFrame.document.forms[0]!= null)
	{
	
	var frameRef=Chart_Create.HeaderFrame;
	var summaryid = frameRef.document.forms[0].summaryid.value;
	var summarydesc = frameRef.document.forms[0].summarydesc.value;
	var rows = frameRef.document.forms[0].rows.value;
	var cols = frameRef.document.forms[0].cols.value;

	if(Chart_Create.DetailsFrame.document.forms[0]!=null){
		Chart_Create.DetailsFrame.document.forms[0].maxr.value=rows;
		Chart_Create.DetailsFrame.document.forms[0].maxc.value=cols;
	}

	var fields = new Array(rows,cols,summaryid,summarydesc);	
	var names = new Array (getLabel("eCA.NoofRows.label",'CA'),"No of Cols",getLabel("eCA.SummaryID.label",'CA'),getLabel("eCA.SummaryDesc.label",'CA'));
	var errors = ""; var firstNullObject =null;	
	firstNullObject=checkMandatoryFields(fields,names,messageFrame,'../../eCommon/jsp/MstError.jsp');
	if(firstNullObject == null || firstNullObject =="" )
	{
	}
	else
	{
		return false;
	 }
	
	var rows		= Chart_Create.HeaderFrame.document.forms[0].rows.value;
	var cols		= Chart_Create.HeaderFrame.document.forms[0].cols.value;
	var selected	= true;
	var SelectYNStr = "";
	var total = eval(rows * cols);
	for(i=0;i<total;i++){
/*		if (parent.frames[1].frames[1].frames[1].document.forms[0]==null){
			alert(getMessage("ROW_COL_NOT_DEF"));
				parent.frames[1].frames[2].location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0";
				return false;
		}

		if (!(eval("parent.frames[1].frames[1].frames[1].document.forms[0].row_pos"+i))){
				alert(getMessage("ROW_COL_NOT_DEF"));
				parent.frames[1].frames[2].location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0";
				return false;
		}
*/
			row_pos = eval("Chart_Create.DetailsFrame.document.forms[0].row_pos"+i+".value");
			if(row_pos =="") row_pos =0;
			col_pos = eval("Chart_Create.DetailsFrame.document.forms[0].col_pos"+i+".value");
			if(col_pos =="")	 col_pos =0;
			row_span = eval("Chart_Create.DetailsFrame.document.forms[0].row_span"+i+".value");
			if(row_span =="")	 row_span =0;
			col_span = eval("Chart_Create.DetailsFrame.document.forms[0].col_span"+i+".value");
			if(col_span =="")	col_span =0;
			cont_id = eval("Chart_Create.DetailsFrame.document.forms[0].cont_id"+i+".value");
			if ((row_pos!=0) || (col_pos!=0)){
				if ((row_span==0)){
					var msg= getMessage("ROW_SPAN_NOT_BLANK","CA");
				"Chart_Create.DetailsFrame.document.forms[0].cont_id"+i+".focus()";
				selected = false ;
				messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg+"&err_value=0";
				break;
				}
				if ((col_span==0)){
					var msg= getMessage("COL_SPAN_NOT_BLANK","CA");
					"parent.frames[1].document.frames[1].frames[1].document.forms[0].cont_id"+i+".focus()";
					selected = false ;
					messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg+"&err_value=0";
					break;
				}
			}
			if ((row_span!=0) || (col_span!=0)){
				if ((row_pos==0)){
					var msg= getMessage("ROW_CANNON_BLANK","CA");
					"parent.frames[1].document.frames[1].frames[1].document.forms[0].cont_id"+i+".focus()";
					selected = false ;
					messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg+"&err_value=0";
					break;
				}
				if ((col_pos==0)){
					var msg= getMessage("COL_POS_NOT_BLANK","CA");
					"parent.frames[1].document.frames[1].frames[1].document.forms[0].cont_id"+i+".focus()";
					selected = false ;
					messageFrame.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg+"&err_value=0";
					break;
				}
			}
			if((row_pos !=0) && (cont_id == null || cont_id == "")){
				var msg = getMessage("SUMMARY_NOT_BLANK","CA");
				"parent.frames[1].document.frames[1].frames[1].document.forms[0].cont_id"+i+".focus()";
				selected = false ;
				messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg+"&err_value=0";
				break;
			}
			if((cont_id!="") && ( row_pos=="" || col_pos=="" ||   row_span=="" ||   col_span=="")){
				var msg = getMessage("ROWCOL_POS_SPAN_NOT_BLANK","CA");
				"parent.frames[1].document.frames[1].frames[1].document.forms[0].cont_id"+i+".focus()";
				selected = false ;
				messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg+"&err_value=0";
				break;
			}
			SelectYNStr += row_pos+"||"+col_pos+"||"+row_span+"||"+col_span+"||"+cont_id+"~";
	}
	
	if(selected)
	{
		messageFrame.location.href="../../eCA/jsp/ValidateCell.jsp?summarydesc="+summarydesc+"&SelectYNStr="+SelectYNStr+"&rows="+rows+"&cols="+cols;
		
	}
	}
	else if(Chart_Create.HeaderFrame.document.forms[0] != null) 
	{
	
	var frameRef=Chart_Create.HeaderFrame;
	var summaryid = frameRef.document.forms[0].summaryid.value;
	var summarydesc = frameRef.document.forms[0].summarydesc.value;
	var rows = frameRef.document.forms[0].rows.value;
	var cols = frameRef.document.forms[0].cols.value;

	if(Chart_Create.DetailsFrame.document.forms[0]!=null){
		Chart_Create.DetailsFrame.document.forms[0].maxr.value=rows;
		Chart_Create.DetailsFrame.document.forms[0].maxc.value=cols;
	}

	var fields = new Array(rows,cols,summaryid,summarydesc);	
	var names = new Array (getLabel("eCA.NoofRows.label",'CA'),"No of Cols",getLabel("eCA.SummaryID.label",'CA'),getLabel("eCA.SummaryDesc.label",'CA'));
	var errors = ""; var firstNullObject =null;	
	firstNullObject=checkMandatoryFields(fields,names,messageFrame,'../../eCommon/jsp/MstError.jsp');
	if(firstNullObject == null || firstNullObject =="" )
	{
	}
	else
	{
		return false;
	 }
	}
	else{
		if(frames[1].frames[1].frames[1].document.forms[0]==null)
		{
			alert(getMessage("ROW_COL_NOT_DEF","CA"));
		}
		messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp?err_val=1&err_num= ';
		return false;
	}
}

function acceptValidNum(numberObj, eventObj, maxInt, numberType, numDecimals){
	var strCheck1 = '123456789';
	var whichCode = (window.Event) ? event.which : event.keyCode;
	key = String.fromCharCode(whichCode);  // Get key value from key code
	if (strCheck1.indexOf(key) == -1) return false;  // Not a valid key
	if(numDecimals==null)	
		numDecimals	=	numberType;
	var count=numberObj.value.length;
	var whichCode = (window.Event) ? eventObj.which : eventObj.keyCode;
	if(count>=maxInt){
		if(count==maxInt){
			var dotOccurance = numberObj.value.indexOf('.');
		if(((dotOccurance>=maxInt)||(dotOccurance==-1)) && (count==maxInt)){
			if(whichCode!=46){
				if(numberType>1)
					numberObj.value = numberObj.value+".";
				}
			}
		}
		else if(count>maxInt){
			var objectValue = numberObj.value;
			var dotOccurance = objectValue.indexOf('.');
			if((objectValue.charAt(maxInt))!='.'){
				if(dotOccurance==-1){
					numberObj.value = objectValue.substring(0,maxInt)+".";
					return false;
				}
			}
		}
	}
	if (parseInt(numberType)==1)//For Minus,Decimal Point and 0-9
	  var strCheck = '.0123456789-';
	else if (parseInt(numberType)==2) //For Decimal Point and 0-9
	{
	   var strCheck = '.0123456789';
	}
	else if (parseInt(numberType)==0)//For Only Nos 0 - 9
	{
		var strCheck = '0123456789';
	}
	else if (parseInt(numberType)==3)//For Minus and 0-9 Only
	{
		var strCheck = '0123456789-';
	}
	if (parseInt(numberType)==1){
		var fldvalue=numberObj.value;
		if (whichCode == 45 && (fldvalue.length==0)) return true;  // minus 
		if (whichCode == 45 && (fldvalue.length>0)) return false;  // minus 
	}
	var fldvalue=numberObj.value;
	var whichCode = (window.Event) ? eventObj.which : eventObj.keyCode;
	if (whichCode == 13) return true;  // Enter
	var pointCount=0;
	for(var i=0;i<fldvalue.length;i++){
		if(fldvalue.charAt(i)=='.') pointCount++;
	}
	if (pointCount>0 && whichCode == 46) return false;
	var fldValue	=	numberObj.value;
	var dotIndex	=	fldValue.indexOf(".");
	var fldLength	=	fldValue.length;
	if(dotIndex!=-1)
		if( fldLength > (dotIndex+numDecimals) ) return false;
	key = String.fromCharCode(whichCode);  // Get key value from key code
	if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	return true;
}

function chkSelectRow(obj){
	var val = obj.value;
	var rows = parent.frames[0].document.forms[0].rows.value;
	if (val=="0"){
		var message= getMessage("CANT_LOCATE_POSISTION","CA");
		alert(message);
		obj.select();
		obj.focus();
	}
	if ( parseInt(val) > parseInt(rows)){
		var message = getMessage("MORE_ROW_VALUE_NOT_ALLOWED","CA");
		alert(message);
		obj.select();
		obj.focus();
	}
}

function chkSelectCol(obj){
	var val = obj.value;
	var cols = parent.frames[0].document.forms[0].cols.value
	if (val=="0"){
		var message= getMessage("CANT_LOCATE_POSISTION","CA");
		alert(message);
		obj.select();
		obj.focus();
	}
	if( parseInt(val) > parseInt(cols)){
		var message = getMessage("MORE_COL_VALUE_NOT_ALLOWED","CA");
		alert(message);
		obj.select();
		obj.focus();
	}
}

function chkRowSpan(obj){
	var val = obj.value;
	var rows = parent.frames[0].document.forms[0].rows.value;
	if (val=="0"){
		var message= getMessage("CANT_LOCATE_POSISTION","CA");
		alert(message);
		obj.select();
		obj.focus();
	}
	if ( parseInt(val) > parseInt(rows)){
		var message = getMessage("MORE_ROW_SPAN_NOT_ALLOWED","CA");
		alert(message);
		obj.select();
		obj.focus();
	}
}

function chkColSpan(obj){
	var val = obj.value;
	var cols = parent.frames[0].document.forms[0].cols.value
	if (val=="0"){
	   var message= getMessage("CANT_LOCATE_POSISTION","CA");
		alert(message);
		obj.select();
		obj.focus();
	}
	if( parseInt(val) > parseInt(cols)){
		var message = getMessage("MORE_COL_SPAN_NOT_ALLOWED","CA");
		alert(message);
		obj.select();
		obj.focus();
	}
}

function chkSelectRowSpan(obj){
	var val = obj.value;
	var rows = parent.frames[0].document.forms[0].rows.value;
	var cols = parent.frames[0].document.forms[0].cols.value;
	var row_pos = parent.frames[1].document.forms[0].row_pos;
}

function SelectCBValue(obj1, obj2){
	var count;
	var count1;
	var del_obj=obj1.name;
	var del_chk=obj1.checked;
	var temp_cb_str="";
	var temp_locn_str="";
	var chk_seq_num=eval('document.forms[0].seq_num'+obj2);
	var SelectYNStr	= parent.frames[0].document.forms[0].SelectYNStr.value;
	if(!(del_chk)){
		eval('document.forms[0].seq_num'+obj2+'.value=""');
		var split=SelectYNStr.split('~');
		var split1 = "";
		for (i=0; i<(split.length-1); i++){
			split1=split[i].split('||');
			if(split1[0] != del_obj){
				temp_cb_str += split1[0]+"||"+split1[1]+"~";
			}else{
				temp_cb_str=temp_cb_str;
				}
		}
		SelectYNStr=temp_cb_str;
		parent.frames[0].document.forms[0].SelectYNStr.value=SelectYNStr;
	}else{
		if(chk_seq_num.value ==""){
			chk_seq_num.focus();
			obj1.checked=false;
		}else{
			var split=SelectYNStr.split('~');
			var split1 = "";
			for (i=0; i<(split.length-1); i++){
				split1=split[i].split('||');
				if(split1[0] != del_obj){
					temp_cb_str += split1[0]+"||"+split1[1]+"~";
				}else{
					temp_cb_str=temp_cb_str;
				}
			}
			SelectYNStr=temp_cb_str;
			parent.frames[0].document.forms[0].SelectYNStr.value=SelectYNStr;
		}
	}
}

function checkVal(){
	var SelectYNStr	=	parent.frames[0].document.forms[0].SelectYNStr.value;
	var fm_cnt=document.forms[0].fm_disp.value;
	var to_cnt=document.forms[0].to_disp.value;
	for (i=fm_cnt; i<=to_cnt;i++){
		var chk				=	eval("document.forms[0].select_yn"+i)
		var chk_seq_num		=	eval("document.forms[0].seq_num"+i)
		if(chk.checked){
			if((SelectYNStr.indexOf(chk.name+"||")) == -1)
				SelectYNStr += chk.name+"||"+chk_seq_num.value+"~";
		}
	}
	parent.frames[0].document.forms[0].SelectYNStr.value	=	SelectYNStr;
}

function onSuccess(){
	Chart_Create.HeaderFrame.location.href='../../eCA/jsp/DynamictabHrd.jsp';
	Chart_Create.DetailsFrame.location.href='../../eCommon/html/blank.html';
} 

function checkVal(obj){
	document.forms[0].dispMode.value = obj;
	document.forms[0].submit();
}

function callSummaryLookup(){
	var summ_id			= document.CASummaryLookUpCriteriaForm.summ_id.value;
	var summ_desc		= document.CASummaryLookUpCriteriaForm.summ_desc.value;
	var	action_url			=	"../../eCA/jsp/CASummaryLookUp.jsp";
	var HTMLVal				=	"<html><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><body onKeyDown='lockKey()'><form name='SummaryLookUpForm' id='SummaryLookUpForm' method='POST' action='"+action_url+"'>"+
	"<input type='hidden' name='summ_id' id='summ_id' value='"+summ_id+"'>"+
	"<input type='hidden' name='summ_desc' id='summ_desc' value='"+summ_desc+"'>"+
	"</form></body></html>";
	parent.CASummaryFrame.document.body.insertAdjacentHTML('afterbegin', HTMLVal);
	parent.CASummaryFrame.document.SummaryLookUpForm.submit();
}

function showNext(){ 
	var rows = document.forms[0].rows.value;
	var cols = document.forms[0].cols.value;
	if(rows == 0 || cols == 0){
		parent.frames[1].location.href ="../../eCA/jsp/DynamictabDet.jsp";
		return false;
	}
	var summaryid = document.forms[0].summaryid.value;
	var summarydesc = document.forms[0].summarydesc.value;
	var  enadis=document.forms[0].enadis.value;
	var fields = new Array(rows,cols,summaryid,summarydesc);
	var names = new Array ("No of Rows","No of Cols","Summary ID","Summary Description");	
	var errors = ""; var firstNullObject =null;
	firstNullObject = checkMandatoryFields(fields,names,parent.parent.frames[2],'../../eCommon/jsp/MstError.jsp');
	if(firstNullObject == null || firstNullObject =="" ){
		parent.frames[1].location.href ="../../eCA/jsp/DynamictabDet.jsp?rows="+rows+"&cols="+cols+"&summaryid="+summaryid+"&summarydesc="+summarydesc+"&enadis="+enadis+"&dis=T";
		parent.parent.frames[2].location.href="../../eCommon/jsp/MstCodeError.jsp";
	}else{
		parent.frames[0].location.href="../../eCA/jsp/DynamictabHrd.jsp?rows="+rows+"&cols="+cols+"&summaryid="+summaryid+"&summarydesc="+summarydesc+"&enadis="+enadis;
	 }
}

function CheckSpecChar(event){
	var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_* ';
	var whichCode = (window.Event) ? event.which : event.keyCode;
	key = String.fromCharCode(whichCode);  // Get key value from key code
	if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
		return (event.keyCode);
	return true ;
}

function CheckForSpecCharsWithSpaceBlur(ObjText)
{
    var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_*& ';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	return true ;
}


//functions for DynamictabHrdSearch.jsp-starts

async function callfunction()
{
		var target			=parent.frames[1].frames[0].document.forms[0].summaryid;
		var serviceVal   = parent.frames[1].frames[0].document.forms[0].summaryid.value;
		var retArray			=  new String();
		var title			= getLabel("eCA.CHARTSUMMARY.label","CA");
		var sql=" SELECT SUMMARY_ID code, SUMMARY_DESC description FROM CA_CHART_SUMM_HEADER where upper(SUMMARY_ID) like upper(?) and upper(SUMMARY_DESC) like upper(?) ";

		var argArray = new Array();
		var namesArray = new Array();
		var valuesArray = new Array();
		var datatypesArray = new Array();

		argArray[0] = sql;
		argArray[1] = namesArray;
		argArray[2] = valuesArray;
		argArray[3] = datatypesArray;
		argArray[4] = "1,2";
		argArray[5] = target.value;
		argArray[6] = DESC_LINK;
		argArray[7] = CODE_DESC;

		retArray = await CommonLookup( title, argArray );
		var str =unescape(retArray);
		var arr = str.split(",");
		if(retArray != null && retArray !="")	
		{
			//parent.frames[1].frames[0].document.forms[0].summaryid.value = retArray[1];
			//parent.frames[1].frames[0].document.forms[0].summarydupid.value = retArray[0];
			parent.frames[1].frames[0].document.forms[0].summaryid.value = arr[0];
			parent.frames[1].frames[0].document.forms[0].summarydupid.value = arr[1];
			parent.frames[1].frames[0].checkRecord(parent.frames[1].frames[0].document.forms[0].summaryid);
		}
		else
		{
			//parent.frames[1].frames[0].document.forms[0].summaryid.value = "";
		}
			parent.frames[1].frames[0].document.forms[0].search.disabled=false;
			parent.frames[2].location.href='../../eCommon/jsp/error.jsp';
	}



//functions for DynamictabHrdSearch.jsp-ends

//functions for DynamictabHrd.jsp-starts


function checkRecord1(obj)
{
	var summarydupid=document.forms[0].summarydupid.value;
				
	if(obj.value!="")
	{
				//		if(summarydupid!=obj.value){
		HTMLVal="<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></head><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><body onKeyDown='lockKey()' class=MESSAGE><form name='tempForm' id='tempForm' method='post' action='DynamictabHrdSearch.jsp'><input type=hidden name='summaryid' id='summaryid' value='"+obj.value+"'><input type=hidden name='summarydupid' id='summarydupid' value='"+summarydupid+"'>  </form></body></html>"
		//top.frames[1].frames[1].frames[2].document.write(HTMLVal);
		//top.frames[1].frames[1].frames[2].document.tempForm.submit();

		parent.parent.messageFrame.document.write(HTMLVal);
		parent.parent.messageFrame.document.tempForm.submit();
				//		}
	}
}

function checkRecord(obj)
{
	var summaryid=obj.value;
	parent.frames[1].location.href='DynamictabDet.jsp?summaryid='+summaryid+'&blurMode=T&mode=M';
	document.forms[0].summarydesc.focus();
}

function checkRec(obj)
{
	var summaryid=obj.value;
	parent.frames[1].document.location.href='DynamictabDet.jsp?summaryid='+summaryid+'&blurMode=T&mode=M';
	document.HeaderForm.summarydesc.focus();
}
function changeCase(obj)
{
	var val=obj.value;
	val=val.toUpperCase();
	document.forms[0].summaryid.value=val;
}


function checkValue(obj)
{
	var a =obj.value;
	if (a>10) 
	{
		var err=getMessage("VALUE_NOT_GREATER_THAN_9","CA");
			alert(err);
			obj.select();
			obj.focus();
	}
}

async function getServiceCode()
{
	var target			= document.forms[0].summaryid;
	var retVal			=  new String();
	var dialogTop			= "40";
	var dialogHeight		= "10" ;
	var dialogWidth		= "40" ;
	var features			= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments			= "" ;
	var search_desc			= "";
	var title			= getLabel("eCA.CHARTSUMMARY.label","CA");
	var sql="SELECT SUMMARY_ID, SUMMARY_DESC, NO_OF_ROWS, NO_OF_COLS, EFF_STATUS  FROM CA_CHART_SUMM_HEADER";

	search_code="SUMMARY_ID";
	search_desc="SUMMARY_DESC";
							
	retVal= await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+encodeURIComponent(title,"UTF-8")+"&dispDescFirst=dispDescFirst",arguments,features);
	var arr=new Array();
	if (retVal != null && retVal !='' && retVal != "null")
	{
		var retVal=unescape(retVal);
		arr=retVal.split("::");
		if(document.forms[0].summaryid.disabled) document.forms[0].summaryid.disabled=false;
		document.forms[0].summarydupid.value=arr[1];
		document.forms[0].summaryid.value=arr[1];
		document.forms[0].summaryid.focus();
		document.forms[0].summaryid.blur();
	}
	else
	{
		parent.frames[0].location.href="../../eCA/jsp/DynamictabHrd.jsp";
		parent.frames[1].location.href="../../eCommon/html/blank.html";
										target.focus();
	}
}

					
		function Assignsumdesc(obj){
					//		parent.frames[1].document.forms[0].summarydesc.value = obj.value;	
		}


function getSummaryDetail(obj)
{
	if(obj.name=='summaryid')
	{
		checkRecord1(obj);
	}
	else if(obj.name=='search')
	{
		callSummary();
	}
}

//callSummary
async function callSummary()
{
		var target			=document.forms[0].summaryid;
		var serviceVal   = document.forms[0].summaryid.value;
		var retArray			=  new String();
		var title			= getLabel("eCA.CHARTSUMMARY.label","CA");
		var sql=" SELECT SUMMARY_ID code, SUMMARY_DESC description FROM CA_CHART_SUMM_HEADER where upper(SUMMARY_ID) like upper(?) and upper(SUMMARY_DESC) like upper(?) ";

		var argArray = new Array();
		var namesArray = new Array();
		var valuesArray = new Array();
		var datatypesArray = new Array();

		argArray[0] = sql;
		argArray[1] = namesArray;
		argArray[2] = valuesArray;
		argArray[3] = datatypesArray;
		argArray[4] = "1,2";
		argArray[5] = target.value;
		argArray[6] = DESC_LINK;
		argArray[7] = CODE_DESC;

		retArray = await CommonLookup( title, argArray );
		var str =unescape(retArray);
		var arr = str.split(",");
		if(retArray != null && retArray !="")	
		{
			document.forms[0].summaryid.value = arr[0];
			document.forms[0].summarydupid.value = arr[1];
			//checkRecord(document.forms[0].summaryid);
			checkRec(document.forms[0].summaryid);
		}
		else
		{
			//document.forms[0].summaryid.value = "";
			//document.forms[0].summarydupid.value = "";
		}
			//document.forms[0].search.disabled=false;
			//document.location.href='../../eCommon/jsp/error.jsp';
	}
//functions for DynamictabHrd.jsp-ends


//functions for DynamictabDet.jsp-starts


function setValue()
{
	if (parent.frames[0].document.forms[0].enadis.checked==true)
	{
		document.forms[0].enadis.value='E';
	}
	else
	{
		document.forms[0].enadis.value='D';
	}
}
//functions for DynamictabHrd.jsp-ends

