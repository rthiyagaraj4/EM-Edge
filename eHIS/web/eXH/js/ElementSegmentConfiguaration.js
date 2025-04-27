//********************************************************************************************
function create()
{
//	ElmntConfigframeset.rows='16,150,110,30';
	window.f_query_add_mod.location.href="../../eXH/jsp/ElementSegmentConfiguaration.jsp?mode=I";		
	window.f_query_add_mod_detail.location.href="../../eCommon/html/blank.html";
	window.messageFrame.location.href="../../eCommon/html/blank.html";
	
}
//********************************************************************************************
function query()
{		
//	ElmntConfigframeset.rows="30,320,50,30";
 	window.f_query_add_mod.location.href="../../eXH/jsp/ApplicationElementsegmentQueryCriteria.jsp";		
	window.f_query_add_mod_detail.location.href="../../eCommon/html/blank.html";
	window.messageFrame.location.href="../../eCommon/html/blank.html";
}

//********************************************************************************************
//FUNCTION DELETE
//********************************************************************************************
function deleterecord()
{
	window.f_query_add_mod.document.forms[0].act_mode.value = 'D';
	apply();
}

//********************************************************************************************
//FUNCTION APPLY()
//********************************************************************************************
function apply()
{
	var mode = frames[1].document.forms[0].act_mode.value;
//	alert("mode : "+mode);

		var fields = new Array ( 
						  frames[1].document.forms[0].config_type,
						  frames[1].document.forms[0].config_id,
						  frames[1].document.forms[0].profile_id,
						  frames[1].document.forms[0].datasrc_type,
					      frames[1].document.forms[0].query_text) ;
  
		var names = new Array ( 
						  getLabel("eXH.ConfigType.Label","XH"),
						  getLabel("eXH.ConfigName.Label","XH"),
						  getLabel("Common.Profile.label","Common"),			
						  getLabel("eXH.DataSourceType.Label","XH"),
						  getLabel("eXH.QueryText.Label","XH"));
					

		if(!f_query_add_mod.checkFields( fields, names, messageFrame))
//		if(!f_query_add_mod.checkFieldsofMst( fields, names, messageFrame))
		{
   
		}else
		{
//			alert("f_query_add_mod");
			window.f_query_add_mod.document.forms[0].submit();	
			if(mode=='I'){
				window.f_query_add_mod.document.forms[0].reset();
				window.f_query_add_mod_detail.location.href="../../eCommon/html/blank.html";
			}
		}

		window.commontoolbarFrame.document.location.reload();

}

//********************************************************************************************
function reset()
{	  
		 window.f_query_add_mod.document.forms[0].reset();
}
//********************************************************************************************
//function resetQryInfo
//*******************************************************************************************

function resetQryInfo(){
	document.forms[0].reset();
  	document.forms[0].where_cond.disabled = true;
 	document.forms[0].whr_text.disabled	  = true;
 	document.forms[0].add.disabled		  = true;	
 	document.forms[0].resetflag.value=0;
}

//********************************************************************************************
//function showQueryInfo
//*******************************************************************************************

async function showQueryInfo()
{
		var config_type = document.forms[0].config_type.value;
		var config_id	= document.forms[0].config_id.value;
		if(config_type!="" && config_id!=""){
			var url     = "../../eXH/jsp/ElementSegmentQueryInfo.jsp?config_type="+config_type+"&config_id="+config_id;
			var dialogTop   = "65";
			var dialogHeight= "50vh" ;
			var dialogWidth = "65vw" ;
			var arguments   = "" ;
			var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop + "; status: no" ;
	        var returnval = await window.showModalDialog( url, arguments, features ) ;
			if( returnval == null || returnval == "" ){
			}
			else{
				document.forms[0].query_text.value = (returnval.split("!"))[0];
				document.forms[0].SysDefStr.value = (returnval.split("!"))[1];
				funcNavigator();
			}
		}
}
//********************************************************************************************
//function setValues
//*******************************************************************************************

function setValues(obj) {

		document.forms[0].selectedCols.value	=	"";
		document.forms[0].QueryResult.value		=	"";
	 	document.forms[0].resetflag.value		=	0;
		document.forms[0].column_name.value		=	"";
		document.forms[0].whrcolumn_name.value	=	"";
		document.forms[0].where_cond.value		=	"";
		document.forms[0].whr_text.value		=	"";
		document.forms[0].whrClauseTxt.value	=	"";		
	 	document.forms[0].add.disabled			=	true;
	 	document.forms[0].addWhrCls.disabled	=	true;		
		whrFlag=0;
		
		var bean_name	=	document.forms[0].strBeanName.value;
		var mod_name	=	obj.value;
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		var xmlStr ="<root><SEARCH ";
		xmlStr += " bean_name=\""+bean_name+"\"";
		xmlStr += " base_unit=\""+mod_name+"\"";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		if(obj.name=='module_name'){
			xmlHttp.open("POST","ElementSegmentValidateQry.jsp?func_mode=setTables",false);
		}
		else if(obj.name=='table_name'){
			xmlHttp.open("POST","ElementSegmentValidateQry.jsp?func_mode=setCols",false);
		}
		xmlHttp.send(xmlDoc);
		eval(xmlHttp.responseText);	
}

//********************************************************************************************
//function slctWhrClsVal
//*******************************************************************************************

function slctWhrClsVal()
{
	 if(whrFlag!=1){
		 var index		= document.forms[0].whrcolumn_name.options.selectedIndex;
 		 var slctd_Col	= document.forms[0].whrcolumn_name.options[index].text;
		 var slctd_ColValObj = document.forms[0].whr_text;	     
		 var slctd_ColVal  = document.forms[0].whr_text.value;
 		 var slctd_ColType  = document.forms[0].whrcolumn_name.value;
	  	 var slctdwhrcond  = document.getElementById("where_cond").value;
		 var slctd_Cols = document.forms[0].whrClauseTxt.value;

		 if(slctd_ColType=='VARCHAR2'){
			document.forms[0].whrClauseTxt.value = slctd_Col+slctdwhrcond+"'"+slctd_ColVal+"'";
			whrFlag = 1;
		 }
		 else if(slctd_ColType=='DATE'){
			if(CheckDateCol(slctd_ColValObj)){
			document.forms[0].whrClauseTxt.value = slctd_Col+slctdwhrcond+"'"+slctd_ColVal+"'";
			whrFlag = 1;
			}
		 }
		 else if(slctd_ColType=='NUMBER'){
			if(CheckForNumberCol(slctd_ColValObj)){
			document.forms[0].whrClauseTxt.value = slctd_Col+slctdwhrcond+slctd_ColVal;
			whrFlag = 1;
			}
		 }
	 }
}

//********************************************************************************************
//function CheckDateCol
//*******************************************************************************************

function CheckDateCol(obj){
//	alert("chkDate");
	Object2 = obj.value;
	datefield = obj;
    if (ChkDate(Object2)) {
	    return true;
	}
	else{
//		alert("Date Format should be DD/MM/YYYY ");
        alert(getMessage("XH1045", "XH"));
        if (datefield.value != undefined)
        {
            datefield.select();
            datefield.focus();
        }
    }
 }

//********************************************************************************************
//function CheckForNumberCol
//*******************************************************************************************

function CheckForNumberCol(obj){
	var colfield = obj;
	var col_val  = obj.value;
	if ( trimCheck(col_val) && isNaN(col_val) == false && col_val >=0){
		return true;
	}
	else{
//		alert("INVALID_NUMBER_FORMAT-Not a Valid Number "); 
	    alert(getMessage("XH1028", "XH")); 
		colfield.select();
		colfield.focus();
	}
}

//********************************************************************************************
//function addWhrClause
//*******************************************************************************************

function addWhrClause()
{
	 var slctd_ColType  = document.forms[0].whrcolumn_name.value;
 	 var index		= document.forms[0].whrcolumn_name.options.selectedIndex;
	 var slctd_Col	= document.forms[0].whrcolumn_name.options[index].text;
 	 var slctd_WhrClsVals = document.forms[0].whrClauseTxt.value;
 	 var slctdwhrcond  = document.getElementById("where_cond").value;
	 var slctd_ColValObj = document.forms[0].whr_text;
	 var slctd_ColVal  = slctd_ColValObj.value;
	 colTxt = colTxt+"#"+slctd_Col;
	 colcount++;
	 	 if(slctd_ColType=='VARCHAR2'){
			col_val = slctd_Col+slctdwhrcond+"'"+slctd_ColVal+"'";
			document.forms[0].whrClauseTxt.value = slctd_WhrClsVals+" AND "+col_val;
		 }
		 else if(slctd_ColType=='DATE'){
			if(CheckDateCol(slctd_ColValObj)){
			col_val = slctd_Col+slctdwhrcond+"'"+slctd_ColVal+"'";
			document.forms[0].whrClauseTxt.value = slctd_WhrClsVals+" AND "+col_val;
			}
		 }	
		 else if(slctd_ColType=='NUMBER'){
			if(CheckForNumberCol(slctd_ColValObj)){
			col_val = slctd_Col+slctdwhrcond+slctd_ColVal;
			document.forms[0].whrClauseTxt.value = slctd_WhrClsVals+" AND "+col_val;
			}
		 }	
}
//********************************************************************************************
//function clearTables
//*******************************************************************************************

function clearTables()	{ 
	var list_obj	=document.forms[0].table_name;
	var len =list_obj.options.length;
	for(var i=0;i<len;i++) {
		list_obj.remove("table_name") ;
	}

	var tp = "---------Select--------" ;
	var opt = document.createElement("OPTION") ;
	opt.text = tp ;
	opt.value = "" ;
	list_obj.add(opt);
}

//********************************************************************************************
//function addTable
//*******************************************************************************************

function addTable(code,desc)	{ 
	var element = document.createElement('OPTION') ;
	element.value		=  code ;
	element.text		= desc ;
	document.forms[0].table_name.add(element);
}

//********************************************************************************************
//function clearCols
//*******************************************************************************************

function clearCols()	{ 
	var list_obj1	=document.forms[0].column_name;
	var list_obj2	=document.forms[0].whrcolumn_name;
	var len1 =list_obj1.options.length;
	var len2 =list_obj2.options.length;
	for(var i=0;i<len1;i++) {
		list_obj1.remove("column_name");
	}
	for(var j=0;j<len2;j++) {
		list_obj2.remove("whrcolumn_name") ;
	}

	var tp = "---------Select--------" ;
	var opt1 = document.createElement("OPTION") ;
	var opt2 = document.createElement("OPTION") ;
	opt1.text = tp ;
	opt1.value = "" ;
	opt2.text = tp ;
	opt2.value = "" ;
	list_obj1.add(opt1);
	list_obj2.add(opt2);
}

//********************************************************************************************
//function addColumn
//*******************************************************************************************

function addColumn(code,desc)	{ 
	var element1 = document.createElement('OPTION') ;
	var element2 = document.createElement('OPTION') ;
	element1.value		=  code ;
	element1.text		= desc ;
	element2.value		=  code ;
	element2.text		= desc ;
	document.forms[0].column_name.add(element1);
	document.forms[0].whrcolumn_name.add(element2);
}
var qryText = "";
//********************************************************************************************
//function getQuery
//*******************************************************************************************

function getQuery()
{
	var slctdColumns  = document.getElementById("selectedCols").value;
	var slctdtbl_name = document.getElementById("table_name").value;
	var slctdwhrcol   = document.getElementById("whrcolumn_name").value;
	var slctdwhrcond  = document.getElementById("where_cond").value;
	
	var slctdwhrtxt = document.forms[0].whrClauseTxt.value;
	var whrclause	  = " \nWHERE "+slctdwhrtxt;

    var conf_type = document.getElementById("config_type").value;
    var sgmnt_type = document.getElementById("config_id").value;
	sgmnt1 = "SELECT '"+sgmnt_type+"'#";

	if(slctdwhrcol==""||slctdwhrcol==''){
		qryResult = "SELECT "+slctdColumns+" \nFROM "+slctdtbl_name;
		qryText = sgmnt1+colTxt+"\nFROM "+slctdtbl_name;	
	}
	else{
		qryResult = "SELECT "+slctdColumns+" \nFROM "+slctdtbl_name+whrclause;
		qryText = sgmnt1+colTxt+"\nFROM "+slctdtbl_name+whrclause;	
	}
	document.getElementById("QueryResult").value = qryResult;
}

//********************************************************************************************
//function validateQry
//*******************************************************************************************

function validateQry(){  
		var SystDefStructure = buildSystDefStr();
		var qResult =  document.getElementById("QueryResult").value;
	
		var bean_name	=	document.forms[0].strBeanName.value;
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		var xmlStr ="<root><SEARCH ";
		xmlStr += " bean_name=\""+bean_name+"\"";
		xmlStr += " qryText=\""+qryText+"\"";
		xmlStr += " SystDefStructure=\""+SystDefStructure+"\"";
		xmlStr += " qResult=\""+qResult+"\"";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","ElementSegmentValidateQry.jsp?func_mode=validateQry",false);
		xmlHttp.send(xmlDoc);
		eval(xmlHttp.responseText);	
}


//********************************************************************************************
//function buildSystDefStr
//*******************************************************************************************

function buildSystDefStr(cnt){  

	if(cnt>0){
		colcount = cnt;
	}

	var config_id = document.forms[0].config_id.value;
//	alert("SystDefStr config : "+config_id);
	var config_type=this.document.forms[0].config_type.value;
	var begnStr	= "";
	var endStr1	= "]";
	var endStr2	= "|:";
	var endStr3	= "^";
	var SystDefStructure = "";
	var sgmnt  = "";
	var begnSgmnt = "#"+config_id+"|:";
	var begFld = "#"+config_id+"^";

	if(config_type=='S'){
		begnStr = config_id+"[";
	}	
	else if(config_type=='F'){
		configid =  config_id.split("]");
		configid =  configid[0];
		begnStr  =  configid+".";
	}

	for(var i=2;i<=colcount;i++){
		if(i==2){
			if(config_type=='S'){
				sgmnt = begnStr+i+endStr1;
			}
			else if(config_type=='F'){
				sgmnt = begnStr+i+endStr1;
			}	
		}
		else{
			if(config_type=='S'){
				sgmnt = endStr2+begnStr+i+endStr1;
			}
			else if(config_type=='F'){
				sgmnt = endStr3+begnStr+i+endStr1;
			}	
		}
		sysdefs = begnSgmnt+sgmnt;
		SystDefStructure = SystDefStructure+sgmnt;
	}

	if(config_type=='S'){
		return begnSgmnt+SystDefStructure;
	}
	else if(config_type=='F'){
//		alert("begFld : "+begFld);
		return begFld+SystDefStructure;
	}
}

//********************************************************************************************
//function buildSystDefStr1
//*******************************************************************************************
function buildSystDefStr1(){  
	var confTyp_val=this.document.forms[0].config_type.value;
	if(confTyp_val!="" && document.forms[0].query_text.value!=""){

	var fldQryTxt = "";
	var sgmntQryTxt = "";
	var sgmntargList = "";
	var fldargList = "";
 	var fldindx ="";
	var sgmntindx ="";
	var SystDefStructure = "";

	var cnt = 0;
	var config_id = document.forms[0].config_id.value;
//	alert("SystDefStr1 config : "+config_id);
	var endStr1	= "]";
	var endStr2	= "|:";
    var argList = "";
	var begnSgmnt = "#"+config_id;
    var index = 2;

	var query_text = document.forms[0].query_text.value;

	if(query_text!=""){
		query_text2 = query_text;

		while(query_text2.length>0){

			sgmntargList = "";
			fldargList = "";

			if((query_text2.indexOf('#')<0)&&(query_text2.indexOf('^')<0)){
	//			alert("443 ");
				break;
			}

		fldindx = query_text2.indexOf('^');
		if(fldindx<0){
			sgmntQryTxt = query_text2;
		}
		else{
		sgmntQryTxt = query_text2.substr(0,fldindx);
		}
	//		alert("sgmntQryTxt : "+sgmntQryTxt);

		while(sgmntQryTxt.length>0){
					indx = sgmntQryTxt.indexOf('#');
	//				alert("#indx : "+indx);
			if(indx<0){
				break;
			}
			sgmntargList = sgmntargList+endStr2+config_id+"["+index+"]";
//			alert("sgmntargList : "+sgmntargList);
			index++;
			sgmntQryTxt = sgmntQryTxt.substr(indx+1,sgmntQryTxt.length-1);
		}
	//	alert("sgmnt argList : "+sgmntargList);
	//	alert("sgmnt index : "+index);

		if(fldindx>0){

		query_text2= query_text2.substr(fldindx,query_text2.length-1);

		sgmntindx = query_text2.indexOf('#');
		fldQryTxt = query_text2.substr(0,sgmntindx);
	//		alert("fldQryTxt : "+fldQryTxt);

		fldindx1 = 1;
		index3 = index-1;
		while(fldQryTxt.length>0){
		  fldindx = fldQryTxt.indexOf('^');
		  	if(fldindx<0){
				break;
			}
			else{
				fldargList = fldargList+"^:"+config_id+"["+index3+"."+fldindx1+"]";
		//		alert("fld argList : "+fldargList);
				fldindx1++;
			}			
			fldQryTxt = fldQryTxt.substr(fldindx+1,fldQryTxt.length-1);
	//		alert("nxt fldQryTxt : "+fldQryTxt);
		} // end of Arg  for

		query_text2= query_text2.substr(sgmntindx,query_text2.length-1);

//		alert("fld argList : "+fldargList);
		}
		else{
			query_text2 = sgmntQryTxt;
		}

		finalArgList = sgmntargList+fldargList;
//		alert("finalArgList : "+finalArgList);
		SystDefStructure = SystDefStructure+finalArgList;

	//	alert("rmng query_text2 : "+query_text2);

       }
	}

		SystDefStructure = begnSgmnt+SystDefStructure;
//		alert("SystDefStructure : "+SystDefStructure);
		document.forms[0].SysDefStr.value = SystDefStructure;
	} // end of config_type chk
}

//********************************************************************************************
//function buildSystDefStr
//*******************************************************************************************


function buildSystDefStr2(cnt){  

	if(cnt>0){
		colcount = cnt;
	}

	var config_id = document.forms[0].config_id.value;
//	alert("SystDefStr config : "+config_id);
	var config_type=this.document.forms[0].config_type.value;
	var begnStr	= "";
	var endStr1	= "]";
	var endStr2	= "|:";
	var endStr3	= "^";
	var SystDefStructure = "";
	var sgmnt  = "";
	var begnSgmnt = "#"+config_id+"|:";
	var begFld = "#"+config_id+"^";

	if(config_type=='S'){
		begnStr = config_id+"[";
	}	
	else if(config_type=='F'){
		configid =  config_id.split("]");
		configid =  configid[0];
		begnStr  =  configid+".";
	}

	for(var i=2;i<=colcount;i++){
		if(i==2){
			if(config_type=='S'){
				sgmnt = begnStr+i+endStr1;
			}
			else if(config_type=='F'){
				sgmnt = begnStr+i+endStr1;
			}	
		}
		else{
			if(config_type=='S'){
				sgmnt = endStr2+begnStr+i+endStr1;
			}
			else if(config_type=='F'){
				sgmnt = endStr3+begnStr+i+endStr1;
			}	
		}
		sysdefs = begnSgmnt+sgmnt;
		SystDefStructure = SystDefStructure+sgmnt;
	}

	if(config_type=='S'){
		return begnSgmnt+SystDefStructure;
	}
	else if(config_type=='F'){
//		alert("begFld : "+begFld);
		return begFld+SystDefStructure;
	}
}

//********************************************************************************************
//function setErrorTxt
//*******************************************************************************************

function setErrorTxt(excptn,errFlag,qryTxt,sysdefStr){
		if(errFlag==1){
		var excptn =  unescape(excptn);
			for(var i=0;i<excptn.length;i++){
				excptn	=	excptn.replace('+'," ");
			}
		document.forms[0].qryError.value = unescape(excptn);
		}
		else{
			var qryTxt =  unescape(qryTxt);
			for(var i=0;i<qryTxt.length;i++){
				qryTxt	=	qryTxt.replace('+'," ");
			}
			var sysdefStr =  unescape(sysdefStr);
			for(var i=0;i<sysdefStr.length;i++){
				sysdefStr	=	sysdefStr.replace('+'," ");
			}
	   	    window.returnValue = qryTxt+"!"+sysdefStr;
			window.close();
		}
	
}

//********************************************************************************************
//function searchSegmentField
//*******************************************************************************************

function searchSegmentField(){
			var confTyp_val=this.document.forms[0].config_type.value;
			if(confTyp_val!=""){
            var tdesc="";
            var tcode="";

            var retVal =new String();
            var argumentArray  = new Array() ;
            var dataNameArray  = new Array() ;
            var dataValueArray = new Array() ;
            var dataTypeArray  = new Array() ;
//            var tit="Segment/Field" ;
			var tit = "";
            var target=this.document.forms[0].config_name;
            var sgmfld_id=this.document.forms[0].config_id;

			if(confTyp_val=='S'){
				tit = getLabel("eXH.Segment.Label","XH");

				sql="SELECT Segment_type code,segment_name description FROM XH_SEGMENT "+
                    "   WHERE UPPER(Segment_type) LIKE UPPER(?) AND "+ 
                    "           UPPER(segment_name) LIKE UPPER(?) "+
                    "           ORDER BY 1 ";
			}
			else if(confTyp_val=='F'){
				tit = getLabel("Common.Field.label","Common");
		        sql="SELECT element_id code,element_name description FROM XH_ELEMENT_CROSSREF "+
                    "   WHERE UPPER(element_id) LIKE UPPER(?) AND "+ 
                    "           UPPER(element_name) LIKE UPPER(?) "+
                    "           ORDER BY 1 ";
			}

			if(sgmfld_id.value!=""){
				dataNameArray[0]	= "sgmfld_id" ;
				dataValueArray[0]	= sgmfld_id.value;
				dataTypeArray[0]	= STRING ;
			}

            argumentArray[0] = sql;
            argumentArray[1] = dataNameArray ;
            argumentArray[2] = dataValueArray ;
            argumentArray[3] = dataTypeArray ;
	        argumentArray[4] = "1,2";
            argumentArray[5] = target.value;
            argumentArray[6] = DESC_LINK  ;
            argumentArray[7] = DESC_CODE ;
         
            retVal = await CommonLookup( tit, argumentArray );
            if(retVal != null && retVal != "" ){
	            var ret1=unescape(retVal);
                arr=ret1.split(",");
                target.value=arr[1];
                sgmfld_id.value=arr[0];
			//  Get Standard Code based on Config_id
				getStndCode(confTyp_val,sgmfld_id.value);
				this.document.forms[0].profile_id.readOnly = false;
				this.document.forms[0].profile_desc.readOnly = false;
				this.document.forms[0].query_text.readOnly = false;
				this.document.forms[0].SysDefStr.readOnly = false;
				this.document.forms[0].datasrc_type.disabled = false;
			}
            else{
                target.value=tdesc;
                sgmfld_id.value=tcode;
			}
		}
}// End of searchSegmentField

//********************************************************************************************
//function searchProfile
//*******************************************************************************************

function searchProfile(){
			var tdesc="";
            var tcode="";

			var confTyp_val=this.document.forms[0].config_type.value;
			if(confTyp_val!=""){

            var retVal =new String();
            var argumentArray  = new Array() ;
            var dataNameArray  = new Array() ;
            var dataValueArray = new Array() ;
            var dataTypeArray  = new Array() ;
//            var tit="Profile" ;
			var tit = getLabel("Common.Profile.label","Common");
            var target=this.document.forms[0].profile_desc;
            var profile_id=this.document.forms[0].profile_id;
			var stnd_code=this.document.forms[0].stnd_code.value;

			sql="SELECT profile_id code,short_desc description FROM XH_STANDARD_PROFILE WHERE UPPER(profile_id) LIKE UPPER(?) AND UPPER(short_desc) LIKE UPPER(?) ORDER BY 1  ";

			if(profile_id.value!=""){
				dataNameArray[0]	= "profile_id" ;
				dataValueArray[0]	= profile_id.value;
				dataTypeArray[0]	= STRING ;
			}
            argumentArray[0] = sql;
            argumentArray[1] = dataNameArray ;
            argumentArray[2] = dataValueArray ;
            argumentArray[3] = dataTypeArray ;
	        argumentArray[4] = "1,2";
            argumentArray[5] = target.value;
            argumentArray[6] = DESC_LINK  ;
            argumentArray[7] = DESC_CODE ;
         
            retVal = await CommonLookup( tit, argumentArray );
            if(retVal != null && retVal != "" ){
	            var ret1=unescape(retVal);
                arr=ret1.split(",");
                target.value=arr[1];
                profile_id.value=arr[0];
            }
            else{
                target.value=tdesc;
                profile_id.value=tcode;
            }
		} //end of confgType chk
}// End of searchProfile

//********************************************************************************************
//function get StndCode 
//*******************************************************************************************

function getStndCode(config_type,conf_name) {
		if(config_type=='F'){
			conf_name = document.forms[0].config_name.value;
			indx	= conf_name.indexOf('[');
			conf_name = conf_name.substr(indx-3,indx-1);
		}
//		var bean_name	=	parent.document.forms[0].strBeanName.value;
		var bean_name	=	"XH_ELEMENT_SEGMENT_CONF";
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		var xmlStr ="<root><SEARCH ";
		xmlStr += " bean_name=\""+bean_name+"\"";
		xmlStr += " conf_name=\""+conf_name+"\"";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","ElementSegmentValidateQry.jsp?func_mode=getStndCode",false);
		xmlHttp.send(xmlDoc);
//		alert(xmlHttp.responseText);
		eval(xmlHttp.responseText);	
}

function addStndCode(code,desc){
		document.forms[0].stnd_code.value = code;
		document.forms[0].stnd_desc.value = desc;
}

//********************************************************************************************
//function dsblQuery
//*******************************************************************************************

function dsblQuery(qry){
	if(qry.value=='P'){
		document.forms[0].query.disabled = true;
		document.forms[0].query_text.value= "";
		document.forms[0].SysDefStr.value= "";
		parent.f_query_add_mod_detail.location.href="../../eCommon/html/blank.html";
//		funcNavigator();
	}
	else{
		document.forms[0].query.disabled = false;
	}
}

//********************************************************************************************
//function funSubmit
//*******************************************************************************************
function funSubmit()
{
	// #MOD#01
	var act = '../../eXH/jsp/ApplicationElementQueryResult.jsp';
	this.document.forms[0].action = act;
	this.document.forms[0].submit();
}
//*******************************************************************************************
//function funModify
//*******************************************************************************************

function funModify(obj)
{
	// #MOD#02
	parent.commontoolbarFrame.document.forms[0].apply.style.display='block';
 
//	alert("frm : "+parent.parent.frameset.name);
//	parent.parent.ElmntConfigframeset.rows='16,150,110,30';


	var unscpQryTxt = unescape(obj.getAttribute('query_text'));
	for(var i=0;i<unscpQryTxt.length;i++){
		unscpQryTxt	= unscpQryTxt.replace('+'," ");
	}

	var unscpSystDS = unescape(obj.getAttribute('sysdef_str'));

	for(var i=0;i<unscpSystDS.length;i++){
		unscpSystDS	= unscpSystDS.replace('+'," ");
	}

//	alert("funmdfy Cnfg_id : "+obj.getAttribute('config_id'));
	this.document.forms[0].config_id.value = obj.getAttribute('config_id');
	this.document.forms[0].config_name.value = obj.getAttribute('config_name');
	this.document.forms[0].config_type.value = obj.getAttribute('config_type');
	this.document.forms[0].datasrc_type.value = obj.getAttribute('datasrc_type');
	this.document.forms[0].query_text.value = unscpQryTxt;
//	this.document.forms[0].field_seperator.value = obj.getAttribute('field_seperator');
	this.document.forms[0].sysdef_str.value = unscpSystDS;
	this.document.forms[0].stnd_code.value = obj.getAttribute('stnd_code');
	this.document.forms[0].stnd_desc.value = obj.getAttribute('stnd_desc');
	this.document.forms[0].profile_id.value = obj.getAttribute('profile_id');
	this.document.forms[0].profile_desc.value = obj.getAttribute('profile_desc');

	var act = '../../eXH/jsp/ElementSegmentConfiguaration.jsp';
	this.document.forms[0].action = act;
	this.document.forms[0].submit();	
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
//function funcNavigator
//*******************************************************************************************
function funcNavigator()
{
		var confTyp_val=parent.f_query_add_mod.document.forms[0].config_type.value;
		if(confTyp_val!="" && document.forms[0].SysDefStr.value!=""){
				parent.f_query_add_mod_detail.location.href="../../eXH/jsp/ElementSegmentConfNavigator.jsp";
		}
}
