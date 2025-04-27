function apply()
{
if(frames[1].frames[1].document.forms[0])
{


frames[1].frames[1].document.forms[0].action="../../servlet/eFM.FMFileTypeforFSLocnServlet";
frames[1].frames[1].document.forms[0].target="messageFrame";
frames[1].frames[1].document.forms[0].submit();
}
else
{
if(frames[1].frames[0].document.forms[0].fs_locn_code.value == '')
{
var err=frames[1].frames[0].getMessage("CAN_NOT_BE_BLANK","common");
err= err.replace('$',getLabel('Common.FileStorageLocation.label','common'));
frames[2].location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+err;
}
else
	{frames[2].location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";
	}
}
}

//var nur_unit_desc="";

function create() {
		f_query_add_mod.location.href = "../../eFM/jsp/FMFileTypeforFSLocnMain.jsp?param=create&called_from=1" ;
}

function query() {
	f_query_add_mod.location.href ="../../eFM/jsp/FMFileTypeforFSLocnCriteria.jsp" ;
}

function reset()
{
	var loc=frames[1].document.forms[0]

	if (loc!=null )
	{
			f_query_add_mod.document.forms[0].reset();
	}
	else if(frames[1].frames[0])
	{
		create();
	}
}

function onSuccess() {
		frames[1].frames[1].location.href='../../eCommon/html/blank.html';
		frames[1].frames[0].location.reload();
}

//////////////////
var effStatus= new Array();

var temp='';
function finalSelect(Obj1,Obj2)
{
	var temp2='';
	if(Obj1.checked)
	{
	temp2=Obj1.name+"$"+Obj2.name+"$"+Obj1.value+"$"+Obj2.value
	temp+=temp2+"`"
	//alert(temp);
	parent.frames[1].document.forms[0].finalSelectedValues.value=temp;
	}
}
/*
	This function is used for search button.By default it was disabled.
   whenever we select a particular clinic it will enable.This should be called
    when the form is loaded.
 */
function ChkFileLocn()
{
	if(document.forms[0].fs_locn_code.value == "")
	{
		document.Search_form.Search.disabled=true;
	}

}

/*
   This function is used for to populate the  type of the clinic, department,
  service and speciality.Based on the clinic these details are displayed.
*/
function PopulateValues(obj)
{
	if(obj.value!="")
	{
		var fs_locn_code=obj.value;
		document.forms[0].Search.disabled=false;		
	}
}

/*
	This function is used to populate the results based on the clinic.Whenever 
    we click search button this function should be called. Population is based
	on variable called_from.If this value is "1" it will populate the Rooms and
	their description.otherwise it will populate services for Clinic.
*/
function PopulateResult()
{
	temp='';
	parent.parent.frames[2].location.href='../../eCommon/jsp/MstCodeError.jsp';
	var fs_locn_code=document.forms[0].fs_locn_code.value;	
	var called_from=document.forms[0].called_from.value;
	if(fs_locn_code!="")
	{
		if (called_from=="1")
		{
		parent.frames[1].location.href='../../eFM/jsp/AddModifyFMFileTypeforFSLocn.jsp?fs_locn_code='+fs_locn_code+'&fromSelect=fromSelect';
		}
			
	}

	else
	{
		var err=getMessage("CAN_NOT_BE_BLANK","common");
		err= err.replace('$', getLabel('Common.FileStorageLocation.label','common'));
		parent.parent.frames[2].location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+err		
	}
}

function submitPrevNext(from, to)
	{
		document.forms[0].from.value = from;
		document.forms[0].to.value	 = to; 
		document.forms[0].submit();
	} 

function selectAll(obj,start,end)
	{
		if(obj.checked)
		{
			for(var i=start;i<=end;i++)
			{
				if(eval("document.forms[0].chk"+i))
				eval("document.forms[0].chk"+i).checked=true;
			}
			obj.value = "select";
		}
		else
		{
		 for(var i=start;i<=end;i++)
		 {
			if(eval("document.forms[0].chk"+i))
			eval("document.forms[0].chk"+i).checked=false;
		 }
		 obj.value = "unselect";
		}
	}
function selectAll3(obj)
	{
		var s = document.forms[0].recstart.value;
		var e = document.forms[0].reccount.value;
		
		if(document.forms[0].chkAll.checked)
		{
			for(var i=s;i<=e;i++)
			{
				if(eval("document.forms[0].chk"+i))
				eval("document.forms[0].chk"+i).checked=true;
			 if(eval("document.forms[0].chk_deflt"+i))
			 eval("document.forms[0].chk_deflt"+i).disabled=false;
			}
			document.forms[0].chkunchk.value = 'Y';
		}
		if(obj == '1' && !document.forms[0].chkAll.checked) 
		{
			for(var i=s;i<=e;i++)
			{
				if(eval("document.forms[0].chk"+i))
				eval("document.forms[0].chk"+i).checked=false;
			    if(eval("document.forms[0].chk_deflt"+i))
			 	{
				eval("document.forms[0].chk_deflt"+i).checked=false;
				eval("document.forms[0].chk_deflt"+i).disabled=true;
				}
			}
			document.forms[0].chkunchk.value = 'N';
			document.forms[0].unchkcond.value = 'Y';
		}
		if(obj == '2' && !document.forms[0].chkAll.checked) 
		{
			var chkcond = document.forms[0].unchkcond.value;
			if(chkcond == 'Y')
			{
				for(var i=s;i<=e;i++)
				{
					if(eval("document.forms[0].chk"+i))
						eval("document.forms[0].chk"+i).checked=false;
					
				}
				document.forms[0].unchkcond.value = 'N';
			}
			document.forms[0].chkunchk.value = 'N';
		}
	deftvalcount();
	}
function chkforpag(start,end)
	{
		for(var i=start;i<=end;i++)
		{
		   if(eval("document.forms[0].chk"+i))
		   {
				eval("document.forms[0].pagechkAll").checked=true;
			}
			else
			{
				eval("document.forms[0].pagechkAll").checked=false;
			}
		}
	}

function chkunchkftypes(obj,val)
	{
		var m = obj.value;
		var index=parseInt(val);
		if(obj.checked == false)
		{							
			document.forms[0].chkunchk.value = '';
			document.forms[0].chkAll.checked = false;
			 if(eval("document.forms[0].chk_deflt"+index))
			{
			  eval("document.forms[0].chk_deflt"+index).checked=false;
			  eval("document.forms[0].chk_deflt"+index).disabled=true;
			}
			if(document.forms[0].remftypes.value == "R")
			{
				document.forms[0].remftypes.value = m;
			}
			else
			{
				document.getElementById("remftypes").value = document.getElementById("remftypes").value+"|"+m;
			}
		}
		else
		{
			m = "";
		   if(eval("document.forms[0].chk_deflt"+index))
		   eval("document.forms[0].chk_deflt"+index).disabled=false;
		doallchk();
		}
	deftvalcount();
	}
function dochk()
	{
	
	/*	if(document.forms[0].chkunchk.value == 'Y')
		{
			document.forms[0].chkAll.checked = true;
		}
		else if(document.forms[0].chkunchk.value = 'N')
		{
			document.forms[0].chkAll.checked = false;
		} */
		 
		
		  selectAll3("2");
	     
	}

function doallchk()
{
     var count=document.forms[0].count.value ;
       var cnt =parseInt(count);
 	    var i=1;
		var flag="true";
  	 while(i<=cnt)
		{
       if(eval("document.forms[0].chk"+i))
			{
	   if(eval("document.forms[0].chk"+i).checked==false)  
			{
                flag="false";
			}
	  }  
		i++;
		}
	
	if(flag=="true")
		{
         document.forms[0].chkAll.checked = true;
		}else{
         document.forms[0].chkAll.checked =false;
		}
   }

function	chkdeflttype(obj,val)
{
var count=document.forms[0].count.value ;
var cnt =parseInt(count);
var index=parseInt(val);
var i=1;
var msg=getMessage('DFLT_FLTF_ALRDY_SLTED','FM');
if(obj.checked ==true)
		{
	while(i<=cnt)
		{
		if(index!=i)
				{
	if(eval("document.forms[0].chk_deflt"+i))
		{
		if (eval("document.forms[0].chk_deflt"+i).checked==true)
			{
		  if(confirm(msg))	
			
		{
              	eval("document.forms[0].chk_deflt"+i).checked=false;
			}else{
                  eval("document.forms[0].chk_deflt"+index).checked=false;
 			     
			}
			}
		}
		}
		i++;
		}
		}
 deftvalcount();

}

function deftvalcount()
{
var count=document.forms[0].count.value ;
var cnt =parseInt(count);
 var i=1;
  var j=0;
var flag="false";
while(i<=cnt)
		{
     if(eval("document.forms[0].chk"+i))
	if(eval("document.forms[0].chk"+i).checked==true)
			{
              if(eval("document.forms[0].chk_deflt"+i).checked==true)
				{
                document.forms[0].dflt_index.value=j;
				flag="true"
				}
			j++;
			}
       i++
		}
if(flag=="false")
	{
document.forms[0].dflt_index.value="-1";
	}

}
