function create()
{
	f_query_add_mod.location.href = "../../eMR/jsp/SSOrderCatalogLinkQueryFrames.jsp" ;
}
function query()
{
	f_query_add_mod.location.href = "../../eMR/jsp/SSOrderCatalogLinkQueryCriteria.jsp"
	
}

function FetchValues()
{
	 //document.forms[0].Master.value;
	
	mast_table_name_reference=document.forms[0].Master.value
	report_id=document.forms[0].Report.value
    group_code=document.forms[0].Main_group.value
	sub_group_code=document.forms[0].sub_group.value

 if(report_id=="MRBRADEX" || report_id=="MRBLABRG" )
 {
	
	var fields = new Array (document.forms[0].Report,
					document.forms[0].Master,
					document.forms[0].Main_group,
				    document.forms[0].sub_group);

	var names = new Array ( getLabel("Common.report.label","Common"),
					getLabel("eMR.Master.label","MR"),
					getLabel("eMR.MainGroup.label","MR"),getLabel("eMR.SubGroup.label","MR"));
	if(parent.f_query_add_mod_search.checkFields(fields, names, parent.parent.messageFrame))
	{
	  var msg="";
	  var sp="OC";
 parent.frames[1].location.href="../../eMR/jsp/SSOrderCatalogLinkResult.jsp?report_id="+report_id+"& mast_table_name_reference="+sp+"&group_code="+group_code+"&sub_group_code="+sub_group_code+"&alphabet=A";
	  parent.parent.frames[3].location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
	}
	else
	{
		 parent.parent.frames[1].frames[1].location.href='../../eCommon/html/blank.html';
	}
 }
 else
 {
   var fields = new Array (document.forms[0].Report,
					document.forms[0].Master,
					document.forms[0].Main_group);

	var names = new Array ( getLabel("Common.report.label","Common"),
					getLabel("eMR.Master.label","MR"),
					getLabel("eMR.MainGroup.label","MR"));
	if(parent.f_query_add_mod_search.checkFields(fields, names, parent.parent.messageFrame))
	{
	  var msg="";
	  var sp="OC";
       parent.frames[1].location.href="../../eMR/jsp/SSOrderCatalogLinkResult.jsp?report_id="+report_id+"& mast_table_name_reference="+sp+"&group_code="+group_code+"&sub_group_code="+sub_group_code+"&alphabet=A";
	  parent.parent.frames[3].location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
	}
	else
	{
		 parent.parent.frames[1].frames[1].location.href='../../eCommon/html/blank.html';
	}
 }
}

function subGroup(obj)
{
	parent.parent.frames[1].frames[1].document.location.href="../../eCommon/html/blank.html";
	//parent.frames[2].document.location.href="../../eCommon/html/blank.html";  
	var maingrpid=obj.value;
	var obj1=document.forms[0].sub_group;
	var length1=obj1.length;
	var i;
	for(i=0;i<length1;i++) 
	obj1.remove(1);
	if(obj.value!= "" && obj.value != null)
	{
	var report_gr_id=document.forms[0].Report.value

	//var report_gr_id=(document.forms[0].report_gr_id.value);
	var HTMLVal="<html><body onKeyDown='lockKey()'><form name='tempform1' id='tempform1' method='post' action='../../eMR/jsp/SSPopulateValues.jsp'><input type=hidden name=main_group value="+maingrpid+"><input type='hidden' name=report_gr_id value="+report_gr_id+"></form></body></html>";
    parent.parent.frames[2].document.write(HTMLVal);
	parent.parent.frames[2].document.tempform1.submit();
	}
	
		
	
}

function funchk(obj)
{
   var report_newid=document.forms[0].report_id.value;
  
  if(report_newid!='MRIPCSMH'){
   var ptr=obj.name;
   var str=eval(ptr.substring(3,ptr.length))
   var obj1=document.forms[0];
   var obj2=eval("obj1.text"+str);
   var concat1=obj2.value
	  //chkdup(obj2);
	  
	
   if(obj.checked==true)
   {
       obj.value="Y";
	   if(concat1=="")
	   {
			var error=getMessage("CAN_NOT_BE_BLANK","Common");
			error= error.replace('$',getLabel("Common.OrderSrlNo.label","Common"));
			alert(error);
			obj2.focus();
			obj2.select();
		}
	}
	else
		obj.value="N";
	}
	else
	{
		if(obj.checked==true)
		{
			obj.value="Y";
	  }
	  else{
	   obj.value="N";
	  }
  }
	
}
function chkdup(obj)
{
    var num=obj.value;
	var ptr=obj.name;
	var str=eval(ptr.substring(4,ptr.length))
if(num!="")
{
	if(num=='0' || num=='00' || num=='000')
	{
		var msg=getMessage('INVALID_SERIAL_NO','MR');
				alert(msg);
				obj.focus();
				obj.select();
	}
	else
	{
	var maxrecord=document.forms[0].maxrecord.value;
	var concat= document.forms[0].concat.value;
	chkdupsplit=concat.split("#");
	var length=chkdupsplit.length;
	var real=obj.name;
	var num=obj.value;
	var status=false;
	if(num.length >0)
	{    
		 var occ=num.indexOf('0')
		 if(occ==0)
		 num=num.substring(1,num.length);
		  occ=num.indexOf('0')
		 if(occ==0)
		 num=num.substring(1,num.length);
	}
		
	var chkboxval=eval("document.forms[0].inc"+str+".value");
	for(i=0;i<(length-2);i++)
	{
		
		if(eval(num)==eval(chkdupsplit[i]) && chkboxval=="N")
		 status=true;
	}

	if(status==true)
	{	
		alert(getMessage('DUPLI_SRL_NO','MR'));
	    obj.focus();
		obj.select();
	   
	}
	
	 else
	 {
		for(i=1;i<=maxrecord;i++)
		 {
			   
			var valchk = document.forms[0]["text" + i].value;
		var valname = document.forms[0]["text" + i].name;
		var chkboxval = document.forms[0]["inc" + i].value;
			  if(num!="")
			   {
					if(num.length >0)
					{    
						var occ=num.indexOf('0')
						if(occ==0)
						num=num.substring(1,num.length);
						occ=num.indexOf('0')
						if(occ==0)
     					num=num.substring(1,num.length);
					}
					 if(real!=valname)
					 {
					  
					   if(eval(valchk)==num )
						 {
						    alert(getMessage('DUPLI_SRL_NO','MR'));
						    obj.focus();
		                    obj.select();
						 }
					 }
			  }
		 }
	}
  }
 }
}

function apply()
{
	var msg='';
	if(parent.frames[1].frames[1].frames[1].document.forms[0]!=null)	
	    parent.frames[1].frames[1].frames[1].document.forms[0].submit();
	else
		parent.frames[1].frames[3].location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
}

function onSuccess()
{
	create();
	
	//parent.frames[1].frames[1].frames[1].location.href='../../eCommon/html/blank.html';
}
function clearValues()
{
	parent.parent.frames[1].frames[1].location.href='../../eCommon/html/blank.html';
}
function reset()
{
	if(parent.frames[1].frames[1].document.forms[0])
	{
		
	 parent.frames[1].frames[1].document.forms[0].reset();
	}
	else{
		  //parent.frames[1].frames[1].frames[0].document.forms[0].reset();
		  parent.frames[1].frames[1].frames[0].location.reload();
	      parent.frames[1].frames[1].frames[1].location.href='../../eCommon/html/blank.html';
	}
}
function callMember(alpha)
{ 
		    document.forms[0].alphabet.value=alpha;
			var master=document.forms[0].mast_table_name_reference.value
   			document.forms[0].target="f_query_add_mod_result";
			document.forms[0].action="../../eMR/jsp/SSOrderCatalogLinkResult.jsp?reference="+master;
			document.forms[0].submit();
			document.forms[0].mast_table_name_reference.value=master;
}

function callReport(obj)
{
	parent.parent.frames[1].frames[1].document.location.href="../../eCommon/html/blank.html";  
	var report_gr_id=obj.value;
	var obj1=document.forms[0].Main_group;
	var obj_type=document.forms[0].sub_group;
	if(report_gr_id=="MRBRADEX" || report_gr_id=="MRBLABRG")
	{   
		document.forms[0].sub_group.disabled=false
		
		madatory_image.innerHTML = "<img src='../../eCommon/images/mandatory.gif'align='center'></img>";
	}
	else
	{
	    document.forms[0].sub_group.disabled=true
		var opt_type= document.createElement('Option');
		opt_type.text='--------- '+getLabel("Common.defaultSelect.label","Common")+' -----------'; 
		opt_type.value='';
		obj_type.add(opt_type)
		opt_type.selected = true;	
		madatory_image.innerHTML='';
	}
	
	var length1=obj1.length;
	var i;
	for(i=0;i<length1;i++) 
	obj1.remove(1);
    var obj2=document.forms[0].sub_group;
	var length2=obj2.length;
	var i1;
	for(i1=0;i1<length1;i1++) 
	obj2.remove(1);
	//var report_gr_id=(document.forms[0].report_gr_id.value);
	var HTMLVal="<html><body onKeyDown='lockKey()'><form name='tempform1' id='tempform1' method='post' action='../../eMR/jsp/SSPopulateValues.jsp'><input type='hidden' name=report_gr_id value="+report_gr_id+"></form></body></html>";
	
    parent.parent.frames[2].document.write(HTMLVal);
	
	
	parent.parent.frames[2].document.tempform1.submit(); 
	
}
function allowPositiveNumber() 
	{
		var key = window.event.keyCode;// allows only numbers to be entered
		if((key<48 )||(key>58)) 
			{
				return false;
			}
	}
	function subGroup1()
	{
       parent.parent.frames[1].frames[1].document.location.href="../../eCommon/html/blank.html";  
	}

