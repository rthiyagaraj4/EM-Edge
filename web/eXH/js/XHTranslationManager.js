
function changeObj(obj,modules)
{
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
		
		document.getElementById("obj2").innerHTML='<select name="start_ends_contains" id="start_ends_contains" ><option value="S">'+getLabel("Common.startsWith.label","Common")+'<option value="E">'+getLabel("Common.endsWith.label","Common")+'</option><option value="C">'+getLabel("Common.contains.label","Common")+'</option></select><INPUT TYPE="text" name="searchtext" id="searchtext" size=30>';

		if (obj.value=='SM_FUNCTION_LEGEND') 
		{
            document.getElementById("obj3").innerHTML=getLabel("Common.Function.label","Common")+" "+getLabel("Common.identification.label","Common");
			document.getElementById("obj4").innerHTML='<INPUT TYPE="text" name="func_id" id="func_id" size=30>';

		}
		else{
           document.getElementById("obj3").innerHTML='';
		   document.getElementById("obj4").innerHTML='';
		}
	}else
	{
	document.getElementById("obj1").innerHTML='<select name="start_ends_contains" id="start_ends_contains" ><option value="S">'+getLabel("Common.startsWith.label","Common")+'<option value="E">'+getLabel("Common.endsWith.label","Common")+'</option><option value="C">'+getLabel("Common.contains.label","Common")+'</option></select><INPUT TYPE="text" name="searchtext" id="searchtext" size=30>';
	document.getElementById("obj2").innerHTML='';
	document.getElementById("obj3").innerHTML='';
	document.getElementById("obj4").innerHTML='';

	}

//document.getElementById("obj1").innerHtml=s
}
													  

function clearData()
{
//parent.Search.location.reload();
parent.result.location.href="../../eCommon/html/blank.html"
}
function reset()
{
Search.location.reload();
result.location.href="../../eCommon/html/blank.html"

}
function getMaster1(obj)
{
//		alert("getMaster1");
//	var language	= obj.value;
	var ModuleFlag	= 'Y';
	parent.dummyFrame.location.href= "../../eXH/jsp/XHPopulateTransMaster.jsp?ModuleFlag="+ModuleFlag;
}
function getMaster2()
{
//	alert("getMaster2");			  
/*	if(document.forms[0].language){
		var language	= document.forms[0].language.value;
		var ModuleFlag	= 'Y';
		parent.dummyFrame.location.href= "../../eSM/jsp/SMPopulateTransMaster.jsp?language="+language+"&ModuleFlag="+ModuleFlag;
	}*/
	if(document.forms[0].application){
		var application	= document.forms[0].application.value;
		var ModuleFlag	= 'Y';
		parent.dummyFrame.location.href= "../../eXH/jsp/XHPopulateTransMaster.jsp?ModuleFlag="+ModuleFlag;
	}
}																			    
function getMaster(obj)
{
	document.forms[0].exportdata.disabled=true;
		document.forms[0].uploaddata.disabled=true;
		var master_code = obj.value;
//		var language = document.forms[0].language.value;
		parent.dummyFrame.location.href= "../../eXH/jsp/XHPopulateTransMaster.jsp?master_code="+master_code;
}
function checkFields( fields, names, messageFrame) {
	var errors = "" ;
    for( var i=0; i<fields.length; i++ ) {			  
        
		if(trimCheck(fields[i].value)) {
            fields[i].value = trimString(fields[i].value);
        }
        else {
//			       alert("errors 92"+errors);
//				   alert("checkFields 92"+messageFrame.name);
					errors = errors + getMessage("CAN_NOT_BE_BLANK","Common"); 
					errors = errors.replace('$',names[i]);
					errors = errors +"<br>";
//			       alert("errors 97"+errors);

		}
    }
    
	if ( errors.length != 0 ) {
//		alert("101"+errors);
//		errors = "Cannot be Blank";
        messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num="+errors ;
        return false ;
    }
    return true ;
}

function recordPrevData()
{
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
	  if(eval("parent.result.document.forms[0].engLang"+k+l).value!="")
				{
				colsize1=m++;
				}
	  if(eval("parent.result.document.forms[0].desc"+k+l).value!=""&&eval("parent.result.document.forms[0].engLang"+k+l).value!="")
				{
		cnt1++;
		}else
		{
		if(eval("parent.result.document.forms[0].engLang"+k+l).value!="")
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
	alert(getMessage('XH0049','XH'))
//	alert("All the descriptions must be translated")
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
		parent.result.location.href= "../../eXH/jsp/XHTranslationManagerResult.jsp?module_id="+module_id+"&masterName="+masterName+"&language="+language+"&language_direction="+language_direction+"&application="+application+"&display="+display+"&searchText="+searchText+"&from="+from+"&to="+to+"&Searchbymod="+Searchbymod+"&SearchbyFunct="+SearchbyFunct+"&start_ends_contains="+start_ends_contains;

	}


}
function recordNextData()
{
from                  =parent.result.document.forms[0].from.value;
from= eval(from)+20

to                       =parent.result.document.forms[0].to.value;
to= eval(to)+20
module_id         =parent.result.document.forms[0].module_id.value
masterName     = parent.result.document.forms[0].masterName.value
language            =parent.result.document.forms[0].language.value
application          = parent.result.document.forms[0].application.value
display              =parent.result.document.forms[0].display.value
language_direction              =parent.result.document.forms[0].language_direction.value
Searchbymod          =parent.result.document.forms[0].Searchbymod.value
SearchbyFunct     =parent.result.document.forms[0].SearchbyFunct.value

parent.result.document.forms[0].flag.value='N'
searchText      =parent.result.document.forms[0].searchText.value
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
	if(eval("parent.result.document.forms[0].engLang"+k+l).value!="")
				{
				colsize1=m++;
				}
	  if(eval("parent.result.document.forms[0].desc"+k+l).value!=""&&eval("parent.result.document.forms[0].engLang"+k+l).value!="")
	
		{
		cnt1++;
		}else
		{
		if(eval("parent.result.document.forms[0].engLang"+k+l).value!="")
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
//	alert("255");
	alert(getMessage('XH0049','XH'))
//	alert("All the descriptions must be translated")
	dontproceed=true;
	break
	}

 }

if(!dontproceed)
	{
//		alert("recordNextData 258 proceed");

	parent.result.document.TranslationResult.submit();
	}
	}else
	{
//		alert("recordNextData 264  do not proceed");
        start_ends_contains=parent.result.document.forms[0].start_ends_contains.value
		parent.result.location.href= "../../eXH/jsp/XHTranslationManagerResult.jsp?module_id="+module_id+"&masterName="+masterName+"&language="+language+"&language_direction="+language_direction+"&application="+application+"&display="+display+"&searchText="+searchText+"&from="+from+"&to="+to+"&Searchbymod="+Searchbymod+"&SearchbyFunct="+SearchbyFunct+"&start_ends_contains="+start_ends_contains;

	}


}




function showResultPage()
{
//	alert("showResultPage");
module_id         = document.forms[0].module_id.value
masterName        = document.forms[0].master_name.value
//language          = document.forms[0].language.value
application          = document.forms[0].application.value
display           = document.forms[0].display.value
//language_direction= document.forms[0].language_direction.value
var mod_id        = "";
var func_id       = "";
if(document.forms[0].mod_id!=null)
mod_id=document.forms[0].mod_id.value

if(document.forms[0].func_id!=null)
func_id=document.forms[0].func_id.value
	
searchText      =document.forms[0].searchtext.value
		var fields = new Array (document.forms[0].application,document.forms[0].display,document.forms[0].module_id,document.forms[0].master_name);
	
		var name = new Array ( getLabel("Common.Application.label","Common"),getLabel("Common.display.label","Common"),getLabel("Common.Module.label","Common"),getLabel("eXH.MasterName.Label","XH"));
	
		if(checkFields(fields,name,parent.messageFrame))
		{
			start_ends_contains=document.forms[0].start_ends_contains.value;
			parent.result.location.href= "../../eXH/jsp/XHTranslationManagerResult.jsp?module_id="+module_id+"&masterName="+masterName+"&application="+application+"&display="+display+"&searchText="+searchText+"&Searchbymod="+mod_id+"&SearchbyFunct="+func_id+"&start_ends_contains="+start_ends_contains;
		}
}

									 


function apply()
{
//	alert("frm Name : "+parent.frames[2].frames[2].document.forms[0].name);
	  if(parent.frames[2].frames[2].document.forms[0]!=null){
		cnt=parent.frames[2].frames[2].document.forms[0].cnt.value;
		var colsize=parent.frames[2].frames[2].document.forms[0].colsize.value;
		var colsize1="";
		var cnt1=0;
		var cnt2=0;
		var dontproceed=false;
		 k=0;
		 l=0;
		
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
//			alert(getMessage('TRANS_ALL_DESC','SM'))
//			alert("365")
			alert(getMessage('XH0049','XH'))
			dontproceed=true;
			break
			}

		 }

		  }// end of tbl_frm - Table 
		  else
		  {
			  dontproceed=false;
		  }
		if(!dontproceed)
			{
//			   alert("Proceed");
		        parent.frames[2].result.document.TranslationResult.submit();
			}else
			{
//			   alert("Do not Proceed");
			    messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="
			}
	}else
	{
//		alert("frames[0] : "+frames[0].name);
		frames[0].location.reload();
		return false;
	}

}

function onSuccess()
{
flag =result.document.forms[0].flag.value
	if(flag=="N")
	{
		from                  =eval(result.document.forms[0].from.value)+20;
		 to                       =eval(result.document.forms[0].to.value)+20;
	}else if(flag=="P")
	{
		 from                  =eval(result.document.forms[0].from.value)-20;
		 to                       =eval(result.document.forms[0].to.value)-20;
	}
	module_id         =result.document.forms[0].module_id.value
	masterName     = result.document.forms[0].masterName.value
	language            =result.document.forms[0].language.value
	display              =result.document.forms[0].display.value
	Searchbymod       =result.document.forms[0].Searchbymod.value
	SearchbyFunct=result.document.forms[0].SearchbyFunct.value
	searchText      =result.document.forms[0].searchText.value
	start_ends_contains=result.document.forms[0].start_ends_contains.value	
	if(flag=="N"||flag=="P")
	{
		result.location.href= "../../eXH/jsp/XHTranslationManagerResult.jsp?module_id="+module_id+"&masterName="+masterName+"&language="+language+"&display="+display+"&searchText="+searchText+"&from="+from+"&to="+to+"&Searchbymod="+Searchbymod+"&SearchbyFunct="+SearchbyFunct+"&start_ends_contains="+start_ends_contains;
	}else
	{
		result.document.location.reload();
	}


}// end of onSuccess

