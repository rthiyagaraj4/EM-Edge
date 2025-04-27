//********************************************************************************************
//  function changeObj 
//********************************************************************************************
function changeObj(obj,modules)
{
		if(parent.result!=null){
			parent.result.location.href="../../eCommon/html/blank.html";	
		}
		if(obj.value=='SM_FUNCTION' ||obj.value=='SM_REPORT' || obj.value=='SM_FUNCTION_LEGEND' || obj.value=='SM_LABEL_ITEM' || obj.value=='SM_LIST_ITEM' || obj.value=='SM_RECORD_TRANS')
		{
		document.getElementById("obj1").innerHTML='<select name=mod_id></select>';
		 var opt=parent.document.frames[1].document.createElement("OPTION");
		  opt.text="----------"+getLabel("Common.defaultSelect.label","Common")+"-----------";
		 opt.value="";
																				   
		 document.forms[0].mod_id.add(opt);											 
		modidlen=modules.length 								   
		for(i=1;i<modidlen;i++) 
		{ 
			var opt=parent.document.frames[1].document.createElement("OPTION");
			opt.text=modules[i].text												 			 
			opt.value=modules[i].value
			document.forms[0].mod_id.add(opt);  													 
		}																					   
		// Cmmntd on Dec31st		
		//		document.getElementById("obj2").innerHTML='<select name="start_ends_contains" id="start_ends_contains" ><option value="S">'+getLabel("Common.startsWith.label","Common")+'<option value="E">'+getLabel("Common.endsWith.label","Common")+'</option><option value="C">'+getLabel("Common.contains.label","Common")+'</option></select><INPUT TYPE="text" name="searchtext" id="searchtext" size=30>';

		if (obj.value=='SM_FUNCTION_LEGEND') 
		{
            document.getElementById("obj3").innerHTML=getLabel("Common.Function.label","Common")+" "+getLabel("Common.identification.label","Common");
			document.getElementById("obj4").innerHTML='<INPUT TYPE="text" name="func_id" id="func_id" size=30>';

		}
		else{
           document.getElementById("obj3").innerHTML='';
		   document.getElementById("obj4").innerHTML='';
		}
	}
	
	else
	{  
		//	alert(parent.document.frames[1].document.forms[0].hidden_trans_table_id.length);
		//	alert("SKEY : "+parent.document.frames[1].document.forms[0].hidden_trans_table_id.options[0].value);
		var TransTblList	= document.forms[0].hidden_trans_table_id.options;
		var master_name = parent.document.frames[1].document.forms[0].master_name.value;
//		alert("master_name : "+master_name);
		for(i=0;i<TransTblList.length;i++){
//            alert("TransTblList[i].value : "+TransTblList[i].value);
			if(master_name == TransTblList[i].value){
				TransListTxt = 	TransTblList[i].text;
//				alert("modules : "+modules.value);
//				alert("TransListTxt : "+TransListTxt);
				if(TransListTxt == 'DKEY'){
					document.getElementById("obj1").innerHTML='<select name="start_ends_contains" id="start_ends_contains" style="width:200px"><option value="S">'+getLabel("Common.startsWith.label","Common")+'<option value="E">'+getLabel("Common.endsWith.label","Common")+'</option><option value="C">'+getLabel("Common.contains.label","Common")+'</option></select>&nbsp;<INPUT TYPE="text" name="searchtext" id="searchtext" size=10>&nbsp;<INPUT TYPE="text" name="searchpk2" id="searchpk2" size=10>';
				break;
				}
				else if(TransListTxt == 'SKEY' || modules.value=='XX'){
						document.getElementById("obj1").innerHTML='<select name="start_ends_contains" id="start_ends_contains" style="width:200"><option value="S">'+getLabel("Common.startsWith.label","Common")+'<option value="E">'+getLabel("Common.endsWith.label","Common")+'</option><option value="C">'+getLabel("Common.contains.label","Common")+'</option></select>&nbsp;<INPUT TYPE="text" name="searchtext" id="searchtext" size=10>';
				}
				else{
							document.getElementById("obj1").innerHTML='<select name="start_ends_contains" id="start_ends_contains" style="width:200" ><option value="S">'+getLabel("Common.startsWith.label","Common")+'<option value="E">'+getLabel("Common.endsWith.label","Common")+'</option><option value="C">'+getLabel("Common.contains.label","Common")+'</option></select>&nbsp;<INPUT TYPE="text" name="searchtext" id="searchtext" size=10>&nbsp;<INPUT TYPE="text" name="searchpk2" id="searchpk2" size=10>&nbsp;<INPUT TYPE="text" name="searchpk3" id="searchpk3" size=10>'; 
				}
			}
		} // end of for 

// Cmmntd on Dec31st
//	document.getElementById("obj2").innerHTML='';
	document.getElementById("obj2").innerHTML='<select name="outbound_yn" id="outbound_yn" style="width:200" disabled><option value="X">'+'-------'+getLabel("Common.all.label","Common")+'<option value="Y">'+getLabel("eXH.Outbound.Label","XH")+'</option><option value="N">'+getLabel("eXH.Inbound.Label","XH")+'</option>';
	document.getElementById("obj3").innerHTML='';
	document.getElementById("obj4").innerHTML='';

	} 

//document.getElementById("obj1").innerHtml=s
} // end of changeObj

//********************************************************************************************
//  function clearData 
//********************************************************************************************

function clearData()
{
	//parent.Search.location.reload();
	parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=";
	parent.result.location.href="../../eCommon/html/blank.html"
}  // end of  clearData

//********************************************************************************************
//  function reset 
//********************************************************************************************
function reset()
{
	Search.location.reload();
	result.location.href="../../eCommon/html/blank.html"
}  // end of  reset

//********************************************************************************************
//  function getMaster1 
//********************************************************************************************
function getMaster1(obj)
{				
	if(document.getElementById("External").style.display=='block'){
			if(document.forms[0].external_yn.checked==true)	    
			{
			}												   
			else
			{
				var ModuleFlag	= 'Y';																 
				parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=";
				parent.dummyFrame.location.href= "../../eXH/jsp/XHPopulateTransMasterN.jsp?ModuleFlag="+ModuleFlag+"&module="+document.forms[0].module.value+"&fun_id="+document.forms[0].fun_id.value+"&master_table_id="+document.forms[0].master_table_id.value;
				document.getElementById("obj1").innerHTML='<select name="start_ends_contains" id="start_ends_contains" style="width:200" ><option value="S">'+getLabel("Common.startsWith.label","Common")+'<option value="E">'+getLabel("Common.endsWith.label","Common")+'</option><option value="C">'+getLabel("Common.contains.label","Common")+'</option></select>&nbsp;<INPUT TYPE="text" name="searchtext" id="searchtext" size=10>';
				document.getElementById("obj2").innerHTML='<select name="outbound_yn" id="outbound_yn" style="width:200" disabled><option value="X">'+'-------'+getLabel("Common.all.label","Common")+'-------'+'<option value="Y">'+getLabel("eXH.Outbound.Label","XH")+'</option><option value="N">'+getLabel("eXH.Inbound.Label","XH")+'</option>';
			}
	}
	else{
	//			alert(document.forms[0].application.value);
				var ModuleFlag	= 'Y';																 
				parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=";
				parent.dummyFrame.location.href= "../../eXH/jsp/XHPopulateTransMasterN.jsp?ModuleFlag="+ModuleFlag+"&module="+document.forms[0].module.value+"&fun_id="+document.forms[0].fun_id.value+"&master_table_id="+document.forms[0].master_table_id.value+"&application="+document.forms[0].application.value;
				document.getElementById("obj1").innerHTML='<select name="start_ends_contains" id="start_ends_contains" style="width:200" ><option value="S">'+getLabel("Common.startsWith.label","Common")+'<option value="E">'+getLabel("Common.endsWith.label","Common")+'</option><option value="C">'+getLabel("Common.contains.label","Common")+'</option></select>&nbsp;<INPUT TYPE="text" name="searchtext" id="searchtext" size=10>';
				document.getElementById("obj2").innerHTML='<select name="outbound_yn" id="outbound_yn" style="width:200" disabled><option value="X">'+'-------'+getLabel("Common.all.label","Common")+'-------'+'<option value="Y">'+getLabel("eXH.Outbound.Label","XH")+'</option><option value="N">'+getLabel("eXH.Inbound.Label","XH")+'</option>';
	}
}  // end of  getMaster1
//********************************************************************************************						     
//  function getMaster2 																			 	  
//********************************************************************************************							 
function getMaster2()
{														 
//	alert("getMaster2");
	parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=";
	if(document.forms[0].application){											 
		var application	= document.forms[0].application.value;														   
		var ModuleFlag	= 'Y';
		parent.dummyFrame.location.href= "../../eXH/jsp/XHPopulateTransMasterN.jsp?ModuleFlag="+ModuleFlag+"&application="+application;
	}
}  // end of  getMaster2
//********************************************************************************************
//  function getMaster 
//********************************************************************************************
function getMaster(obj)																					  
{
//	alert("getMaster");
	var application	= document.forms[0].application.value;		
//	alert("getMaster application : "+application);

	if(document.forms[0].fun_id.value=='SWITCHENTITY')
	{
		var master_code = obj.value;
		parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=";
		parent.dummyFrame.location.href= "../../eXH/jsp/XHPopulateTransMasterN.jsp?master_code="+master_code+"&application="+application;
		if(parent.result!=null){
			parent.result.location.href="../../eCommon/html/blank.html";	
		}																					  
	}
	else													  
	{
		var master_code = obj.value;
		parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=";
		parent.dummyFrame.location.href= "../../eXH/jsp/XHPopulateTransMasterN.jsp?master_code="+master_code+"&application="+application;
		if(parent.result!=null){
			parent.result.location.href="../../eCommon/html/blank.html";	
		}
	}
	document.getElementById("obj1").innerHTML='<select name="start_ends_contains" id="start_ends_contains" style="width:200"><option value="S">'+'Starts With'+'<option value="E">'+'Ends With'+'</option><option value="C">'+'Contains'+'</option></select>&nbsp;<INPUT TYPE="text" name="searchtext" id="searchtext" size=10>';
	document.getElementById("obj2").innerHTML='<select name="outbound_yn" id="outbound_yn" style="width:200" disabled><option value="X">'+'-------'+getLabel("Common.all.label","Common")+'-------'+'<option value="Y">'+getLabel("eXH.Outbound.Label","XH")+'</option><option value="N">'+getLabel("eXH.Inbound.Label","XH")+'</option>';
} // end of  getMaster
//********************************************************************************************
//  function checkFields 
//********************************************************************************************
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
//		alert("parent.result : "+parent.parent.frames[2].name);
//		parent.parent.result.location.href="../../eCommon/html/blank.html"
		parent.parent.window[2].window[3].messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+errors ;

        return false ;
    }
    return true ;
} // end of  checkFields

//********************************************************************************************
//  function recordPrevData 
//********************************************************************************************
function recordPrevData()
{
	parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=";
	from                  =parent.result.document.forms[0].from.value;
	from= eval(from)-20

	to                       =parent.result.document.forms[0].to.value;
	to= eval(to)-20

	module_id            =parent.result.document.forms[0].module_id.value
	masterName           = parent.result.document.forms[0].masterName.value
	language             =parent.result.document.forms[0].language.value				   
	language_direction   =parent.result.document.forms[0].language_direction.value
	application          = parent.result.document.forms[0].application.value
	display              =parent.result.document.forms[0].display.value
	Searchbymod          =parent.result.document.forms[0].Searchbymod.value
	SearchbyFunct        =parent.result.document.forms[0].SearchbyFunct.value
	parent.result.document.forms[0].flag.value='P'
	var colsize1="";
	searchText      =parent.result.document.forms[0].searchText.value
	if(parent.result.document.forms[0].searchpk2 != null){
			searchpk2      = parent.result.document.forms[0].searchpk2.value;
		//	alert("searchpk2 : "+searchpk2);
	}
	if(parent.result.document.forms[0].searchpk3!=null){
			  searchpk3      = parent.result.document.forms[0].searchpk3.value;
	}
	var conf=confirm("Do you want to record the Translated Data?")
		if(conf)
		{
		
		cnt=parent.result.document.forms[0].cnt.value;
	colsize=parent.result.document.forms[0].colsize.value;
	cnt1=0;
	cnt2=0;
	var dontproceed=false;
	 k=0;
	 l=0;

	m=0;

	for(i=1;i<=cnt;i++)
	{m=1
		for(j=1;j<=colsize;j++)
		{ 

		
		  if(parent.result.document.getElementById("engLang"+k+l).value!="")
					{
					colsize1=m++;
					}
		  if(eval("parent.result.document.forms[0].desc"+k+l).value!=""&& parent.result.document.getElementById("engLang"+k+l).value!="")
					{
			cnt1++;
			}else
			{
			if(parent.result.document.getElementById("engLang"+k+l).value!="")
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
		alert(getMessage('XH0049','XH'))
		var err_msg = getMessage('XH0057','XH');
		err_msg = err_msg.replace('$',masterName);
		alert(err_msg);
		dontproceed=true;
		break
		}

	 }									 

	if(!dontproceed)
		{
			
		parent.result.document.TranslationResult.submit();
		}
		}else
		{start_ends_contains=parent.result.document.forms[0].start_ends_contains.value
		  outbound_yn = parent.result.document.forms[0].outbound_yn.value
			parent.result.location.href= "../../eXH/jsp/XHTranslationManagerResultN.jsp?module_id="+module_id+"&masterName="+masterName+"&language="+language+"&language_direction="+language_direction+"&application="+application+"&display="+display+"&searchText="+searchText+"&searchpk2="+searchpk2+"&searchpk3="+searchpk3+"&from="+from+"&to="+to+"&Searchbymod="+Searchbymod+"&SearchbyFunct="+SearchbyFunct+"&start_ends_contains="+start_ends_contains+"&outbound_yn="+outbound_yn;

		}
} // end of recordPrevData
//********************************************************************************************
//  function recordNextData 
//********************************************************************************************
function recordNextData()
{
	parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=";
	from                  =parent.result.document.forms[0].from.value;
	from= eval(from)+20
	//alert("engLang"+k+l);
		//alert(eval(parent.result.getElementById("engLang"+k+l).value));
	to                       =parent.result.document.forms[0].to.value;
	to= eval(to)+20
	module_id         =parent.result.document.forms[0].module_id.value
		var mn_index		= parent.frames[1].document.forms[0].master_name.options.selectedIndex;
	var master_name	= parent.frames[1].document.forms[0].master_name.options[mn_index].text;	
	masterName     = parent.result.document.forms[0].masterName.value
	language            =parent.result.document.forms[0].language.value
	application          = parent.result.document.forms[0].application.value
	//alert("application : "+application);
	display              =parent.result.document.forms[0].display.value
	language_direction              =parent.result.document.forms[0].language_direction.value
	Searchbymod          =parent.result.document.forms[0].Searchbymod.value
	SearchbyFunct     =parent.result.document.forms[0].SearchbyFunct.value

	parent.result.document.forms[0].flag.value='N'
	searchText      =parent.result.document.forms[0].searchText.value
	if(parent.result.document.forms[0].searchpk2 != null){
			searchpk2      = parent.result.document.forms[0].searchpk2.value;
		//	alert("searchpk2 : "+searchpk2);
	}
	if(parent.result.document.forms[0].searchpk3!=null){
			  searchpk3      = parent.result.document.forms[0].searchpk3.value;
	}
		var colsize1="";
	var conf=confirm("Do you want to record the Translated Data?")
		if(conf)
		{
		cnt=parent.result.document.forms[0].cnt.value;
	   colsize=parent.result.document.forms[0].colsize.value;
	   
	   cnt1=0;
	   cnt2=0;
	var dontproceed=false;
	 k=0;
	 l=0;
	for(i=1;i<=cnt;i++)
	{m=1;
		for(j=1;j<=colsize;j++)
		{ 				



		if(parent.result.document.getElementById("engLang"+k+l).value!="")
					{
					colsize1=m++;
					}
		  if(eval("parent.result.document.forms[0].desc"+k+l).value!=""&& parent.result.document.getElementById("engLang"+k+l).value!="")
			{
			cnt1++;
			}else
			{
			if(parent.result.document.getElementById("engLang"+k+l).value!="")
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
		
	//	alert(getMessage('TRANS_ALL_DESC','SM'))
	//	alert(getMessage('XH0049','XH'))
	//	alert("All the descriptions must be translated")
	//  alert("All Short Descriptions are not set for '"+master_name+"'");
		var err_msg = getMessage('XH0057','XH');
		err_msg = err_msg.replace('$',master_name);
		alert(err_msg);
		dontproceed=true;
		break
		}

	 }

	if(!dontproceed)
		{
		parent.result.document.TranslationResult.submit();
		}																  
		}else
		{
	//		alert("recordNextData 264  do not proceed");
	//        alert("application else 278 : "+application);
			start_ends_contains=parent.result.document.forms[0].start_ends_contains.value
			outbound_yn = parent.result.document.forms[0].outbound_yn.value
			parent.result.location.href= "../../eXH/jsp/XHTranslationManagerResultN.jsp?module_id="+module_id+"&masterName="+masterName+"&language="+language+"&language_direction="+language_direction+"&application="+application+"&display="+display+"&searchText="+searchText+"&searchpk2="+searchpk2+"&searchpk3="+searchpk3+"&from="+from+"&to="+to+"&Searchbymod="+Searchbymod+"&SearchbyFunct="+SearchbyFunct+"&start_ends_contains="+start_ends_contains+"&outbound_yn="+outbound_yn;

		}
}// end of recordNextData

//********************************************************************************************
//  function showResultPage 
//********************************************************************************************
function showResultPage()
{
	//alert(document.forms[0].external_yn.value);
 	parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="
	module_id         = document.forms[0].module_id.value
	masterName      = document.forms[0].master_name.value
	var index1		  = document.forms[0].master_name.options.selectedIndex;
 	var slctd_Master_Val  = document.forms[0].master_name.options[index1].text;
//		alert("slctd_Master_Val : "+slctd_Master_Val);
	application         = document.forms[0].application.value
//		alert("application : "+application);
	display				 = document.forms[0].display.value
	outbound_yn		 = document.forms[0].outbound_yn.value
	external_yn		 = document.forms[0].external_yn.value
	var mod_id        = "";
	var func_id        = "";
	if(document.forms[0].mod_id!=null)
	mod_id=document.forms[0].mod_id.value
   	if(document.forms[0].func_id!=null)
	func_id=document.forms[0].func_id.value
	searchText     = document.forms[0].searchtext.value;		   
	searchpk2 = "";
    searchpk3="";
	if(document.forms[0].searchpk2 != null){
		searchpk2      = document.forms[0].searchpk2.value;
	}
	if(document.forms[0].searchpk3!=null){
          searchpk3      = document.forms[0].searchpk3.value;
	}

/*   if(module_id== 'XX'){
	   		parent.result.location.href= "../../eXH/jsp/XHTranslationNonTabValueMain.jsp?searchText="+searchText+"&applicationid="+application+"&nontabelementid="+masterName;
	//		DataElementCrossRefNonTableValuesSetupMain?application="+application DataElementCrossRefNonTableValuesSetup.jsp
   }
   else{ */
//	   alert("else");
	if(document.forms[0].external_yn.checked==true)
	{		     
	var fields = new Array (document.forms[0].application,document.forms[0].display,document.forms[0].master_name );
	var name = 	new Array ( getLabel("Common.Application.label","Common"),getLabel("Common.display.label","Common"),getLabel("eXH.MasterName.Label","XH"));
	}
	else
	{
	 var fields = new Array (document.forms[0].application,document.forms[0].display,document.forms[0].module_id,document.forms[0].master_name );
	var name = 	new Array ( getLabel("Common.Application.label","Common"),getLabel("Common.display.label","Common"),getLabel("Common.Module.label","Common"),getLabel("eXH.MasterName.Label","XH"));
	}
	if(checkFields(fields,name,parent.messageFrame))	{
		start_ends_contains=document.forms[0].start_ends_contains.value;
		 if(document.forms[0].external_yn.checked==true)
		{
			parent.result.location.href= "../../eXH/jsp/XHTranslationManagerResultNExternal.jsp?module_id="+module_id+"&masterName="+masterName+"&application="+application+"&display="+display+"&searchText="+searchText+"&Searchbymod="+mod_id+"&SearchbyFunct="+func_id+"&start_ends_contains="+start_ends_contains+"&outbound_yn="+outbound_yn+"&searchpk2="+searchpk2+"&searchpk3="+searchpk3+"&external_yn="+external_yn; 
		}
		else if(module_id== 'XX')
		{
	   		parent.result.location.href= "../../eXH/jsp/XHTranslationNonTabValueMain.jsp?searchText="+searchText+"&applicationid="+application+"&nontabelementid="+masterName+"&slctd_Master_Val="+slctd_Master_Val+"&start_ends_contains="+start_ends_contains;
		}
		else
		{
//			start_ends_contains=document.forms[0].start_ends_contains.value;
			parent.result.location.href= "../../eXH/jsp/XHTranslationManagerResultN.jsp?module_id="+module_id+"&masterName="+masterName+"&application="+application+"&display="+display+"&searchText="+searchText+"&Searchbymod="+mod_id+"&SearchbyFunct="+func_id+"&start_ends_contains="+start_ends_contains+"&outbound_yn="+outbound_yn+"&searchpk2="+searchpk2+"&searchpk3="+searchpk3+"&external_yn="+external_yn; 
		}
	} 
//	} // end of else

}// end of showResultPage
//********************************************************************************************
//  function apply 
//********************************************************************************************
function apply()
{															 									 
    var module_id = parent.frames[2].frames[1].document.forms[0].module_id.value;
//	alert("module_id : "+module_id);
	if(module_id == 'XX'){
		frames[0].location.reload();				
	}
	else {
    if(parent.frames[2].frames[1].document.forms[0]!=null){
    messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=";
	var mn_index		= parent.frames[2].frames[1].document.forms[0].master_name.options.selectedIndex;
	var master_name	= parent.frames[2].frames[1].document.forms[0].master_name.options[mn_index].text;
 	    if(parent.frames[2].frames[2].document.forms[0]!=null){
		cnt=parent.frames[2].frames[2].document.forms[0].cnt.value;
		//alert("cnt : "+cnt);																	 
		var colsize=parent.frames[2].frames[2].document.forms[0].colsize.value;
		//alert("colsize : "+colsize);
		var colsize1="";
		var cnt1=0;
		var cnt2=0;
		var dontproceed=false;
		 k=0;
		 l=0;
		// added outer if cond on Dec 24 - only for code
		if(colsize>0){
		//alert("colsize>0");
		if(parent.frames[2].frames[2].document.forms[0].table_or_from.value!="F")
		  {
		for(i=1;i<=cnt;i++)
		{m=1
			for(j=1;j<=colsize;j++)
			{ 
			  if(eval("parent.frames[2].frames[2].document.forms[0].engLang"+k+l).value!="")
				{
				//  alert("m++");
				colsize1=m++;
				}
			  if(eval("parent.frames[2].frames[2].document.forms[0].desc"+k+l).value!=""&&eval("parent.frames[2].frames[2].document.forms[0].engLang"+k+l).value!="")
				{
				//  alert("cnt1++");
				cnt1++;
				}else
				{
				if(eval("parent.frames[2].frames[2].document.forms[0].engLang"+k+l).value!=""){
				//	alert("cnt2++");
				cnt1++;
				}
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

//			alert("All the descriptions must be translated")
//			alert(getMessage('TRANS_ALL_DESC','SM'))
			//alert(getMessage('XH0049','XH'))
//            alert("All Short Descriptions are not set for '"+master_name+"'");
			var err_msg = getMessage('XH0057','XH');
			err_msg = err_msg.replace('$',master_name);
			alert(err_msg);
			dontproceed=true;
			break
			}
		 }

		  }// end of tbl_frm - Table 
		} // end of if
		  else
		  {
			  dontproceed=false;
		  }
		if(!dontproceed)
			{
			 //  alert("Proceed 519");
		        parent.frames[2].result.document.TranslationResult.submit();
			}else
			{
			 //  alert("Do not Proceed");
			    messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="
			}
	}else
	{
//		alert("apply frames[0] : "+frames[0].name);
		frames[0].location.reload();
		return false;
	}
	}
	else{
			frames[0].location.reload();				  
	}
	} 
} // end of apply
//********************************************************************************************
//  function onSuccess 
//********************************************************************************************
function onSuccess()
{
	var flag =result.document.forms[0].flag.value;
	if(flag=="N")
	{
	from                  =eval(result.document.forms[0].from.value)+20;
     to                       =eval(result.document.forms[0].to.value)+20;
	}else if(flag=="P")
	{from                  =eval(result.document.forms[0].from.value)-20;
     to                       =eval(result.document.forms[0].to.value)-20;
	}
	module_id         =result.document.forms[0].module_id.value
	masterName     = result.document.forms[0].masterName.value
	language            =result.document.forms[0].language.value
	application         =result.document.forms[0].application.value
	display              =result.document.forms[0].display.value
	Searchbymod       =result.document.forms[0].Searchbymod.value
	SearchbyFunct=result.document.forms[0].SearchbyFunct.value
	searchText      =result.document.forms[0].searchText.value
	start_ends_contains=result.document.forms[0].start_ends_contains.value	
	outbound_yn = result.document.forms[0].outbound_yn.value
	if(result.document.forms[0].searchpk2 != null){
			searchpk2      = result.document.forms[0].searchpk2.value;
		//	alert("searchpk2 : "+searchpk2);
	}
	if(result.document.forms[0].searchpk3!=null){
			 searchpk3      = result.document.forms[0].searchpk3.value;
	}

	if(flag=="N"||flag=="P")
	{
	result.location.href= "../../eXH/jsp/XHTranslationManagerResultN.jsp?module_id="+module_id+"&masterName="+masterName+"&language="+language+"&application="+application+"&display="+display+"&searchText="+searchText+"&searchpk2="+searchpk2+"&searchpk3="+searchpk3+"&from="+from+"&to="+to+"&Searchbymod="+Searchbymod+"&SearchbyFunct="+SearchbyFunct+"&start_ends_contains="+start_ends_contains+"&outbound_yn="+outbound_yn;
	}else
	{
	result.document.location.reload();
	}
	//	parent.result.document.TranslationResult.submit();
	//}
}// end of onSuccess

//********************************************************************************************
//  function searcheHISCode 
//********************************************************************************************

async function searcheHISCode(look_qry){
//     		alert("look_qry : "+look_qry);  
			var tdesc="";
            var tcode="";

            var retVal =new String();
            var argumentArray  = new Array() ;
            var dataNameArray  = new Array() ;
            var dataValueArray = new Array() ;
            var dataTypeArray  = new Array() ;
   			var tit	=  getLabel("eXH.ibaehisCode.Label","XH");
            var target=this.document.forms[0].ehis_desc;
            var ehis_code=this.document.forms[0].ehis_code;
			
//			SELECT BANK_CODE, substr(BANK_NAME,1,30) FROM BL_BANK_NAME

//			sql="SELECT BANK_CODE code, SUBSTR(BANK_NAME,1,30) description FROM BL_BANK_NAME WHERE UPPER(BANK_CODE) LIKE UPPER(?) AND UPPER(BANK_NAME) LIKE UPPER(?) ORDER BY 1";

			sql = look_qry;
//			alert("sql : "+sql);
            argumentArray[0] = sql;
            argumentArray[1] = dataNameArray ;
            argumentArray[2] = dataValueArray ;
            argumentArray[3] = dataTypeArray ;
		    argumentArray[4] = "1,2";
//		    argumentArray[4] = "2,1";
            argumentArray[5] = target.value;
            argumentArray[6] = DESC_LINK  ;
            argumentArray[7] = DESC_CODE ;
         
            retVal = await CommonLookup( tit, argumentArray );
            if(retVal != null && retVal != "" ){
	            var ret1=unescape(retVal);
                arr=ret1.split(",");
                target.value=arr[1];
                ehis_code.value=arr[0];
            }
            else{
                target.value=tdesc;
                ehis_code.value=tcode;
            }
}// End of searcheHISCode

//********************************************************************************************
//  function showExportData 
//********************************************************************************************

function showExportData()
{			 
	if(document.forms[0].external_yn.checked==true)
	{		     
		var fields = new Array (document.forms[0].application,document.forms[0].display,document.forms[0].master_name );
		var name = 	new Array ( getLabel("Common.Application.label","Common"),getLabel("Common.display.label","Common"),getLabel("eXH.MasterName.Label","XH"));
	}
	else
	{
		var fields = new Array (document.forms[0].application,document.forms[0].display,document.forms[0].module_id,document.forms[0].master_name );
		var name = 	new Array ( getLabel("Common.Application.label","Common"),getLabel("Common.display.label","Common"),getLabel("Common.Module.label","Common"),getLabel("eXH.MasterName.Label","XH"));
	}
	if(checkFields(fields,name,parent.messageFrame))	{

			  if (document.forms[0].external_yn.checked==true)
			  {
				  var conf=confirm("Do you want to Synchronize Data for Translation?"); 
				  if(conf)
		         {
					start_ends_contains=document.forms[0].start_ends_contains.value;
					document.forms[0].target='messageFrame';  								  				  
					document.forms[0].action='../../eXH/jsp/XHTranslationExportDataTranslation.jsp';
					document.forms[0].submit();									     					 
					setTimeout("alert(getMessage('XH0085','XH'))","500");
				}  	
			  }
			  else
		{
		var conf=confirm("Do you want to Synchronize Data for Translation?"); 
		if(conf)
		{																				    
			start_ends_contains=document.forms[0].start_ends_contains.value;
			document.forms[0].target='messageFrame';    								  				  
			document.forms[0].action='../../eXH/jsp/XHTranslationExportData.jsp';	   
			document.forms[0].submit();									     
			setTimeout("alert(getMessage('XH0085','XH'))","500");
		}  																    
	 
	} 
}	
}

//********************************************************************************************
//  function addRecord 
//********************************************************************************************
 function addRecord(lookupFlag)
{
	var fields="";
	var names="";
	//alert("lookupFlag : "+lookupFlag);
	var names = new Array();
	var fields=new Array() ;

		fields[0]= document.forms[0].nontabmedicomcode1;
	//	names[0]=getLabel("eXH.ibaehisCode.Label","XH");
		names[0]= "External Code";

		if(lookupFlag=="false"){
			fields[1] = document.forms[0].nontabcrosscode;
			names[1] = "eHIS Code";
		}
		else if(lookupFlag=="true"){
			fields[1] = document.forms[0].ehis_code;
			names[1] = "Cross Reference";
		}
		
//       alert(parent.parent.frames[3].name);
	if(!checkFields( fields, names, parent.parent.frames[3].name))
	{
	
	}
	else
	{
	document.forms[0].nontabmedicomcode.value=document.forms[0].nontabmedicomcode1.value;
	// this.document.forms[0].action="../../servlet/eXH.DataElementCrossRefNonTableValuesServlet";	
	document.forms[0].action="../../servlet/eXH.XHTranslationNonTableValuesServlet";	
	document.forms[0].submit();
//	alert(parent.frames[0].document.forms[0].name); 	
	}
//	parent.frames[0].document.location.reload();		
 }		
//********************************************************************************************
//  function deleteRecord 
//********************************************************************************************
 function deleteRecord(lookupFlag)
{
	//alert("lookupFlag : "+lookupFlag);
	document.forms[0].mode.value = 'D';
	document.forms[0].action="../../servlet/eXH.XHTranslationNonTableValuesServlet";	
	document.forms[0].submit();
}
//********************************************************************************************
//  function validatecheckbox 
//********************************************************************************************

function validatecheckbox(obj)
{
	if(obj.checked==true)
	{
		document.forms[0].module_id.options[0].selected=true;	 
		document.forms[0].module_id.disabled=true; 
	   getMasterPopulate();
       obj.value = 'Y';
	}
	else
	{
		document.forms[0].module_id.disabled=false; 
		obj.value = 'N';
	}
}

//********************************************************************************************
//  function getMasterPopulate 
//********************************************************************************************

function getMasterPopulate()
{
	parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=";
	parent.dummyFrame.location.href= "../../eXH/jsp/XHPopulateTransMasterNExternal.jsp";
	if(parent.result!=null){
		parent.result.location.href="../../eCommon/html/blank.html";	
	}
}																	 		 

