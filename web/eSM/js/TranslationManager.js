function changeObj(obj,modules){
	document.getElementById('obj5').innerHTML="";
	document.getElementById('obj4').innerHTML="";
	document.getElementById('searchTextID').innerHTML=getLabel('Common.searchtext.label','common');
	if(obj.value=='SM_FUNCTION' ||obj.value=='SM_REPORT' || obj.value=='SM_FUNCTION_LEGEND' || obj.value=='SM_LABEL_ITEM' || obj.value=='SM_LIST_ITEM' || obj.value=='SM_RECORD_TRANS'){
		if(obj.value=='SM_RECORD_TRANS'){
			var moduleArray='AE,AM,DR,FM,IP,MP,MR,OA,OP,SM,PH,ST,MM,SS,RS,CP,CA,OR';
			document.getElementById('obj1').innerHTML='<select name=mod_id onchange="changeModule(this)"></select><img src="../../eCommon/images/mandatory.gif" align="center"></img>';
			var opt=parent.document.frames[1].document.createElement("OPTION");
			opt.text="----------"+getLabel("Common.defaultSelect.label","Common")+"-----------";
			opt.value="";
			document.forms[0].mod_id.add(opt);
			modidlen=modules.length
			for(i=1;i<modidlen;i++){ 
				if(moduleArray.indexOf(modules[i].value)==-1){
					var opt=parent.document.frames[1].document.createElement("OPTION");
					opt.text=modules[i].text
					opt.value=modules[i].value
					document.forms[0].mod_id.add(opt);
				}
			}
		}else{
			document.getElementById('obj1').innerHTML='<select name=mod_id onchange="changeModule(this)"></select>';
			var opt=parent.document.frames[1].document.createElement("OPTION");
			opt.text="----------"+getLabel("Common.defaultSelect.label","Common")+"-----------";
			opt.value="";
			document.forms[0].mod_id.add(opt);
			modidlen=modules.length
			for(i=1;i<modidlen;i++){ 
				var opt=parent.document.frames[1].document.createElement("OPTION");
				opt.text=modules[i].text
				opt.value=modules[i].value
				document.forms[0].mod_id.add(opt);
			}
		}
		//document.getElementById('obj1').innerHTML='<select name=mod_id onchange="changeModule(this)"></select>';
		if(obj.value!='SM_RECORD_TRANS'){
			document.getElementById('obj2').innerHTML='<select name="start_ends_contains" id="start_ends_contains" ><option value="S">'+getLabel("Common.startsWith.label","Common")+'<option value="E">'+getLabel("Common.endsWith.label","Common")+'</option><option value="C">'+getLabel("Common.contains.label","Common")+'</option></select><INPUT TYPE="text" name="searchtext" id="searchtext" size=30>';
		}
		if (obj.value=='SM_FUNCTION_LEGEND'){
			document.getElementById('searchTextID').innerHTML=getLabel("Common.Function.label","Common")+" Legend "+getLabel("Common.Module.label","Common");
            document.getElementById('obj5').innerHTML=getLabel("Common.Function.label","Common")+" "+getLabel("Common.identification.label","Common");
			document.getElementById('obj2').innerHTML='<INPUT TYPE="text" name="function_name" id="function_name" size=30 onblur="functionlengendBlur(this)"><input type="button" value="?" onclick="functionlengendLookup(function_name)"  name="function_id_lookup" id="function_id_lookup"><input type="hidden" name="func_id" id="func_id" value="">';
			document.getElementById('obj3').innerHTML=getLabel('Common.searchtext.label','common');
			document.getElementById('obj4').innerHTML='<select name="start_ends_contains" id="start_ends_contains" ><option value="S">'+getLabel("Common.startsWith.label","Common")+'<option value="E">'+getLabel("Common.endsWith.label","Common")+'</option><option value="C">'+getLabel("Common.contains.label","Common")+'</option></select><INPUT TYPE="text" name="searchtext" id="searchtext" size=30>';
		}else if(obj.value=='SM_RECORD_TRANS'){
           document.getElementById('searchTextID').innerHTML=getLabel('Common.report.label','common')+" "+getLabel('Common.Module.label','common');
		   //document.getElementById('obj2').innerHTML='<select name="report_id" id="report_id" ><option value="">---Select-----</option></select>';
           document.getElementById('obj3').innerHTML=getLabel('Common.searchtext.label','common');
		   document.getElementById('obj5').innerHTML='Report';
		   document.getElementById('obj2').innerHTML='<INPUT TYPE="text" name="reportID_name" id="reportID_name" size=30 onblur="reportIDBlur(this)"><input type="button" value="?" onclick="reportIDLookup(reportID_name)"  name="reportID_lookup" id="reportID_lookup"><input type="hidden" name="report_id" id="report_id" value="">';
		   document.getElementById('obj4').innerHTML='<select name="start_ends_contains" id="start_ends_contains" ><option value="S">'+getLabel("Common.startsWith.label","Common")+'<option value="E">'+getLabel("Common.endsWith.label","Common")+'</option><option value="C">'+getLabel("Common.contains.label","Common")+'</option></select><INPUT TYPE="text" name="searchtext" id="searchtext" size=30>';
		}else{
           document.getElementById('obj3').innerHTML='';
		   document.getElementById('obj4').innerHTML='';
		}
	}else{
		document.getElementById('obj1').innerHTML='<select name="start_ends_contains" id="start_ends_contains" ><option value="S">'+getLabel("Common.startsWith.label","Common")+'<option value="E">'+getLabel("Common.endsWith.label","Common")+'</option><option value="C">'+getLabel("Common.contains.label","Common")+'</option></select><INPUT TYPE="text" name="searchtext" id="searchtext" size=30>';
		document.getElementById('obj2').innerHTML='';
		document.getElementById('obj3').innerHTML='';
		document.getElementById('obj4').innerHTML='';
		parent.result.location.href="../../eCommon/html/blank.html";
	}

//document.getElementById("obj1").innerHtml=s
}



function clearData()
{
   parent.result.location.href="../../eCommon/html/blank.html"
}
function reset()
{
Search.location.reload();
result.location.href="../../eCommon/html/blank.html"

}
function getMaster1(obj){
	var language	= obj.value;
	var ModuleFlag	= 'Y';
	if(language!==''){
		parent.dummyFrame.location.href= "../../eSM/jsp/SMPopulateTransMaster.jsp?language="+language+"&ModuleFlag="+ModuleFlag;
		parent.result.location.href="../../eCommon/html/blank.html"
	}else{
		parent.result.location.href="../../eCommon/html/blank.html"
	}
}
function getMaster2()
{
	if(document.forms[0].language){
		var language	= document.forms[0].language.value;
		var ModuleFlag	= 'Y';
		parent.dummyFrame.location.href= "../../eSM/jsp/SMPopulateTransMaster.jsp?language="+language+"&ModuleFlag="+ModuleFlag;
	}
}
function getMaster(obj){
	parent.result.location.href="../../eCommon/html/blank.html"
	var master_code = obj.value;
	var language = document.forms[0].language.value;
	document.getElementById('searchTextID').innerHTML=getLabel('Common.searchtext.label','common');
	document.getElementById('obj1').innerHTML='<select name="start_ends_contains" id="start_ends_contains" ><option value="S">'+getLabel("Common.startsWith.label","Common")+'<option value="E">'+getLabel("Common.endsWith.label","Common")+'</option><option value="C">'+getLabel("Common.contains.label","Common")+'</option></select><INPUT TYPE="text" name="searchtext" id="searchtext" size=30>';
	document.getElementById('obj2').innerHTML='';
	document.getElementById('obj3').innerHTML='';
	document.getElementById('obj4').innerHTML='';
	document.getElementById('obj5').innerHTML='';
	if(master_code!==''){
		parent.dummyFrame.location.href= "../../eSM/jsp/SMPopulateTransMaster.jsp?master_code="+master_code+"&language="+language;
	}else{
		parent.dummyFrame.location.href= "../../eSM/jsp/SMPopulateTransMaster.jsp?master_code="+master_code+"&language="+language;
	}
	parent.result.location.href="../../eCommon/html/blank.html";

}

function checkFields( fields, names, messageFrame) {
	var errors = "" ;
    for( var i=0; i<fields.length; i++ ) {
        
		if(trimCheck(fields[i].value)) {
            fields[i].value = trimString(fields[i].value);
        }
        else {
				
					errors = errors + getMessage("CAN_NOT_BE_BLANK","Common"); 
					errors = errors.replace('$',names[i]);
					errors = errors +"<br>";

		}
    }
    
	if ( errors.length != 0 ) {
        messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num="+errors ;

        return false ;
    }
    return true ;
}

function recordPrevData(){
	from				=parent.result.document.forms[0].from.value;
	from				= eval(from)-20;
	to					=parent.result.document.forms[0].to.value;
	to					= eval(to)-20
	module_id			=parent.result.document.forms[0].module_id.value;
	masterName			= parent.result.document.forms[0].masterName.value;
	language			=parent.result.document.forms[0].language.value;
	language_direction	=parent.result.document.forms[0].language_direction.value;
	display				=parent.result.document.forms[0].display.value;
	Searchbymod			=parent.result.document.forms[0].Searchbymod.value;
	SearchbyFunct		=parent.result.document.forms[0].SearchbyFunct.value;
	var submitformYN	=parent.result.document.forms[0].submitformYN.value;
	var mod_id			=parent.result.document.forms[0].mod_id.value;
	var report_id		=parent.result.document.forms[0].report_id.value;
	parent.result.document.forms[0].flag.value='P'
	var colsize1		="";
	searchText			=parent.result.document.forms[0].searchText.value;
	if(submitformYN=="Y"){
		var conf=confirm("Do you want to record the Translated Data?");
		if(conf){
			var dontproceed=false;
			 /* Commented the validation by Suresh M on 14.09.2010 for SRR20056-SCF-5152 [IN:023674]
			cnt=parent.result.document.forms[0].cnt.value;
			colsize=parent.result.document.forms[0].colsize.value;
			cnt1=0;
			cnt2=0;			
			 k=0;
			 l=0;
			 m=0;			
			for(i=1;i<=cnt;i++){
				m=1;
				for(j=1;j<=colsize;j++){ 
					if(eval("parent.result.document.forms[0].engLang"+k+l).value!=""){
						colsize1=m++;
					}
					if(eval("parent.result.document.forms[0].desc"+k+l).value!=""&&eval("parent.result.document.forms[0].engLang"+k+l).value!=""){
						cnt1++;
					}else{
						if(eval("parent.result.document.forms[0].engLang"+k+l).value!="")
							cnt2++;
					}
					k++;
				}
				l++;
				k=0;
				if(eval(cnt2)==eval(colsize1)||eval(cnt1)==eval(colsize1)){
					cnt1=0;
					cnt2=0;
					continue;
				}else if(eval(cnt1)!=eval(colsize1)){
					alert(getMessage('TRANS_ALL_DESC','SM'))
					dontproceed=true;
					break;
				}
			} */
			if(!dontproceed){
				parent.result.document.TranslationResult.submit();
			}
		}else{
			start_ends_contains=parent.result.document.forms[0].start_ends_contains.value
			parent.result.location.href= "../../eSM/jsp/SMTranslationManagerResult.jsp?module_id="+module_id+"&masterName="+masterName+"&language="+language+"&language_direction="+language_direction+"&display="+display+"&searchText="+searchText+"&from="+from+"&to="+to+"&Searchbymod="+Searchbymod+"&SearchbyFunct="+SearchbyFunct+"&start_ends_contains="+start_ends_contains+"&mod_id="+mod_id+"&report_id="+report_id;
		}
	}else{
		start_ends_contains=parent.result.document.forms[0].start_ends_contains.value;
		parent.result.location.href= "../../eSM/jsp/SMTranslationManagerResult.jsp?module_id="+module_id+"&masterName="+masterName+"&language="+language+"&language_direction="+language_direction+"&display="+display+"&searchText="+searchText+"&from="+from+"&to="+to+"&Searchbymod="+Searchbymod+"&SearchbyFunct="+SearchbyFunct+"&start_ends_contains="+start_ends_contains+"&mod_id="+mod_id+"&report_id="+report_id;
	}
}

function recordNextData(){
	from				= parent.result.document.forms[0].from.value;
	from				= eval(from)+20

	to					= parent.result.document.forms[0].to.value;
	to					= eval(to)+20
	module_id			= parent.result.document.forms[0].module_id.value;
	masterName			= parent.result.document.forms[0].masterName.value;
	language			= parent.result.document.forms[0].language.value;
	display				= parent.result.document.forms[0].display.value;
	language_direction	= parent.result.document.forms[0].language_direction.value;
	Searchbymod			= parent.result.document.forms[0].Searchbymod.value;
	SearchbyFunct		= parent.result.document.forms[0].SearchbyFunct.value;
	parent.result.document.forms[0].flag.value='N';
	searchText			= parent.result.document.forms[0].searchText.value
	var colsize1="";
	var submitformYN	= parent.result.document.forms[0].submitformYN.value;
	var mod_id			= parent.result.document.forms[0].mod_id.value;
	var report_id		=parent.result.document.forms[0].report_id.value;
	if(submitformYN=="Y"){
		var conf=confirm(getMessage('RECOR_TRANSLATED_DATA','SM'));
		if(conf){
			var dontproceed=false;
			/* Commented the validation by Suresh M on 14.09.2010 for SRR20056-SCF-5152 [IN:023674]
			cnt=parent.result.document.forms[0].cnt.value;
			colsize=parent.result.document.forms[0].colsize.value;
			cnt1=0;
			cnt2=0;			
			k=0;
			l=0;
			for(i=1;i<=cnt;i++){
				m=1;
				for(j=1;j<=colsize;j++){ 				
					if(eval("parent.result.document.forms[0].engLang"+k+l).value!=""){
						colsize1=m++;
					}
					if(eval("parent.result.document.forms[0].desc"+k+l).value!=""&&eval("parent.result.document.forms[0].engLang"+k+l).value!=""){
						cnt1++;
					}else{
						if(eval("parent.result.document.forms[0].engLang"+k+l).value!="")
						cnt2++;
					}
					k++;
				}
				l++;
				k=0;		
				if(eval(cnt2)==eval(colsize1)||eval(cnt1)==eval(colsize1)){
					cnt1=0;
					cnt2=0;
					continue;
				}else if(eval(cnt1)!=eval(colsize1)){			
					alert(getMessage('TRANS_ALL_DESC','SM'))
					//	alert("All the descriptions must be translated")
					dontproceed=true;
					break;
				}
			} */
			if(!dontproceed){
				parent.result.document.TranslationResult.submit();
			}
		}else{
			start_ends_contains=parent.result.document.forms[0].start_ends_contains.value
			parent.result.location.href= "../../eSM/jsp/SMTranslationManagerResult.jsp?module_id="+module_id+"&masterName="+masterName+"&language="+language+"&language_direction="+language_direction+"&display="+display+"&searchText="+searchText+"&from="+from+"&to="+to+"&Searchbymod="+Searchbymod+"&SearchbyFunct="+SearchbyFunct+"&start_ends_contains="+start_ends_contains+"&mod_id="+mod_id+"&report_id="+report_id;
		}
	}else{
		start_ends_contains=parent.result.document.forms[0].start_ends_contains.value;
		parent.result.location.href= "../../eSM/jsp/SMTranslationManagerResult.jsp?module_id="+module_id+"&masterName="+masterName+"&language="+language+"&language_direction="+language_direction+"&display="+display+"&searchText="+searchText+"&from="+from+"&to="+to+"&Searchbymod="+Searchbymod+"&SearchbyFunct="+SearchbyFunct+"&start_ends_contains="+start_ends_contains+"&mod_id="+mod_id+"&report_id="+report_id;
	}
}




function showResultPage()
{
module_id         = document.forms[0].module_id.value
masterName        = document.forms[0].master_name.value
language          = document.forms[0].language.value
display           = document.forms[0].display.value
language_direction= document.forms[0].language_direction.value
//var mod_id        = document.forms[0].mod_id.value;
var report_id="";

var mod_id        = "";
var func_id       = "";
if(document.forms[0].mod_id!=null)
mod_id=document.forms[0].mod_id.value;
if(masterName=='SM_RECORD_TRANS'){
	report_id=document.forms[0].report_id.value;
	if(mod_id==""){
		err=getMessage("CAN_NOT_BE_BLANK","Common");
		var str1=getLabel("Common.report.label","Common")+" "+getLabel("Common.Module.label","Common");
		alert(err.replace("$",str1));
		return
	}
}
if(document.forms[0].func_id!=null)
func_id=document.forms[0].func_id.value
	
searchText      =document.forms[0].searchtext.value
	var fields = new Array (document.forms[0].module_id,document.forms[0].master_name,document.forms[0].language,document.forms[0].display );
	
		var name = new Array ( getLabel("Common.Module.label","Common"),
					 getLabel("eSM.MasterName.label","SM"),getLabel("Common.Language.label","Common"),getLabel("Common.display.label","SM"));
	
		if(checkFields(fields,name,parent.messageFrame))
		{
	start_ends_contains=document.forms[0].start_ends_contains.value;
	url="../../eSM/jsp/SMTranslationManagerResult.jsp?module_id="+module_id+"&masterName="+masterName+"&language="+language+"&display="+display+"&language_direction="+language_direction+"&searchText="+searchText+"&Searchbymod="+mod_id+"&SearchbyFunct="+func_id+"&start_ends_contains="+start_ends_contains+"&mod_id="+mod_id+"&report_id="+report_id;
	parent.result.location.href=url;
		}
}




function apply()
{
	  if(parent.frames[2].frames[2].document.forms[0]!=null){
		cnt=parent.frames[2].frames[2].document.forms[0].cnt.value;
		var colsize=parent.frames[2].frames[2].document.forms[0].colsize.value;
		var colsize1="";
		var cnt1=0;
		var cnt2=0;
		var dontproceed=false;
		 k=0;
		 l=0;
		/* Commented the validation by Suresh M on 14.09.2010 for SRR20056-SCF-5152 [IN:023674]
		if(parent.frames[2].frames[2].document.forms[0].table_or_from.value!="F")
		  {
		for(i=1;i<=cnt;i++)
		{m=1
			for(j=1;j<=colsize;j++)
			{ 
			  if(eval("parent.frames[2].frames[2].document.forms[0].engLang"+k+l).value!="")
				{
				colsize1=m++;
				}
			  if(eval("parent.frames[2].frames[2].document.forms[0].desc"+k+l).value!=""&&eval("parent.frames[2].frames[2].document.forms[0].engLang"+k+l).value!="")
				{
				cnt1++;
				}else
				{
				if(eval("parent.frames[2].frames[2].document.forms[0].engLang"+k+l).value!="")
				cnt2++;
				}
			k++;
			
			}
			
			
			l++;
			k=0;
			
			if(eval(cnt2)==eval(colsize1)||eval(cnt1)==eval(colsize1))
			{
			cnt1=0;
			cnt2=0;
			continue;
			}else if(eval(cnt1)!=eval(colsize1))
			{
			
		//	alert("All the descriptions must be translated")
			alert(getMessage('TRANS_ALL_DESC','SM'))
			dontproceed=true;
			break
			}

		 }

		  }else
		  {
			  dontproceed=false;
		  }
			*/
		if(!dontproceed)
			{
		        parent.frames[2].result.document.TranslationResult.submit();
			}else
			{
			    messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="
			}
	}else
	{
		frames[0].location.reload();
		return false;
	}

}

function onSuccess(){
	alert(getMessage('TRANS_SUCCESSFUL','SM'));
	//var conf=confirm("Recorded")
	//if(conf)
	//{
	flag =result.document.forms[0].flag.value;
	if(flag=="N"){
		from	=eval(result.document.forms[0].from.value)+20;
		to      =eval(result.document.forms[0].to.value)+20;
	}else if(flag=="P"){
		from	=eval(result.document.forms[0].from.value)-20;
		to		=eval(result.document.forms[0].to.value)-20;
	}
	var mod_id         =result.document.forms[0].mod_id.value;
	module_id         =result.document.forms[0].module_id.value;
	masterName     = result.document.forms[0].masterName.value;
	language            =result.document.forms[0].language.value;
	language_direction  =result.document.forms[0].language_direction.value;
	display              =result.document.forms[0].display.value;
	Searchbymod       =result.document.forms[0].Searchbymod.value;
	SearchbyFunct=result.document.forms[0].SearchbyFunct.value;
	searchText      =result.document.forms[0].searchText.value;
	start_ends_contains=result.document.forms[0].start_ends_contains.value;	
	var report_id="";
	if(masterName=='SM_RECORD_TRANS'){
		report_id=parent.frames[2].frames[2].document.forms[0].report_id.value;
	}
	if(flag=="N"||flag=="P"){
		result.location.href= "../../eSM/jsp/SMTranslationManagerResult.jsp?module_id="+module_id+"&masterName="+masterName+"&language="+language+"&language_direction="+language_direction+"&display="+display+"&searchText="+searchText+"&from="+from+"&to="+to+"&Searchbymod="+Searchbymod+"&SearchbyFunct="+SearchbyFunct+"&start_ends_contains="+start_ends_contains+"&mod_id="+mod_id+"&report_id="+report_id;
	}else{
		result.document.location.reload();
	}
	//	parent.result.document.TranslationResult.submit();
	//}
}

function functionlengendBlur(obj){
	if(obj.value==""){
		document.forms[0].func_id.value="";
		document.forms[0].function_name.value="";
	}else{
		functionlengendLookup(document.forms[0].function_name);
	}
}
async function functionlengendLookup(target){
	var mod_id=document.forms[0].mod_id.value;
	var sql="select function_id code,function_name description from sm_function where function_id in(select distinct function_id from sm_function_legend_lang where module_id ='"+mod_id+"' and language_id='"+localeName+"' ) and function_id like upper(?) and upper(async function_name) like upper(?) order by FUNCTION_ID";	
	//var sql="select appl_user_id code,appl_user_name description from sm_appl_user where eff_status='E'  and ( (trunc(eff_date_from) <= trunc(sysdate)  and eff_date_to is null )  or (trunc(eff_date_to) >= trunc(sysdate) and eff_date_from is null)  or (eff_date_from is null and eff_date_to is null ) or (trunc(sysdate) between trunc(eff_date_from) and trunc(eff_date_to) and eff_date_from is not null and eff_date_to is not null)) and upper(appl_user_id) like upper(?) and upper(appl_user_name) like upper(?) order by upper(appl_user_name)";			
	var retVal			= new String();
	var argumentArray	= new Array() ;
	var dataNameArray	= new Array() ;
	var dataValueArray	= new Array() ;
	var dataTypeArray	= new Array() ;			
	var tit				= "Function Name";
	argumentArray[0]	= sql;
	argumentArray[1]	= dataNameArray ;
	argumentArray[2]	= dataValueArray ;
	argumentArray[3]	= dataTypeArray ;
	argumentArray[4]	= "1,2";
	argumentArray[5]	= target.value;
	argumentArray[6]	= DESC_LINK;
	argumentArray[7]	= DESC_CODE;
	retVal = await CommonLookup( tit, argumentArray );
	if(retVal != null && retVal != ""){
		var retValArr=unescape(retVal);;
		retValArr=retValArr.split(",");
		document.forms[0].func_id.value=retValArr[0];
		document.forms[0].function_name.value=retValArr[1];
	}else{
		document.forms[0].func_id.value='';
		document.forms[0].function_name.value='';
	}
}
function reportIDBlur(obj){
	if(obj.value==""){
		document.forms[0].report_id.value="";
		document.forms[0].reportID_name.value="";
	}else{
		reportIDLookup(document.forms[0].reportID_name);
	}
}
async function reportIDLookup(target){
	var mod_id=document.forms[0].mod_id.value;
	//var sql="select function_id code,function_name description from sm_function where function_id in(select distinct function_id from sm_function_legend_lang where module_id ='"+mod_id+"' and language_id='en' ) and function_id like upper(?) and upper(async function_name) like upper(?) order by FUNCTION_ID";	
	var sql="Select report_id code,report_desc  description from sm_report where module_id='"+mod_id+"' and upper(report_id) like upper(?) and upper(report_desc) like upper(?) and legend_key is not null";	
	var retVal			= new String();
	var argumentArray	= new Array() ;
	var dataNameArray	= new Array() ;
	var dataValueArray	= new Array() ;
	var dataTypeArray	= new Array() ;			
	var tit				= "Report Name";
	argumentArray[0]	= sql;
	argumentArray[1]	= dataNameArray ;
	argumentArray[2]	= dataValueArray ;
	argumentArray[3]	= dataTypeArray ;
	argumentArray[4]	= "1,2";
	argumentArray[5]	= target.value;
	argumentArray[6]	= DESC_LINK;
	argumentArray[7]	= DESC_CODE;
	retVal = await CommonLookup( tit, argumentArray );
	if(retVal != null && retVal != ""){
		var retValArr=unescape(retVal);;
		retValArr=retValArr.split(",");
		document.forms[0].report_id.value=retValArr[0];
		document.forms[0].reportID_name.value=retValArr[1];
	}else{
		document.forms[0].report_id.value="";
		document.forms[0].reportID_name.value="";
	}
}
function changeModule(obj){
	if(document.forms[0].master_name.value=='SM_RECORD_TRANS'){
		document.forms[0].reportID_name.value='';
		document.forms[0].report_id.value='';
	}else if(document.forms[0].master_name.value=='SM_FUNCTION_LEGEND'){
		document.forms[0].function_name.value='';
		document.forms[0].func_id.value='';
	}
}
function cheeckText(event){
	document.forms[0].submitformYN.value="Y";
}

