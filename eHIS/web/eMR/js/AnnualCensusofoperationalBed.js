function create()
{
	/*f_query_add_mod.location.href = "../../eMR/jsp/AnnualCensusofoperationalBedForm.jsp" ;
	frames[2].location.href='../../eCommon/html/blank.html';*/
	f_query_add_mod.location.href = "../../eMR/jsp/AnnualCensusofoperationalBedFrames.jsp" ;
	//alert(f_query_add_mod.name);
	//parent.frames[1].document.getElementById("annualsize").rows='8%,32%,*%,8%';
	document.getElementById("commontoolbarFrame").style.height="9vh";
	document.getElementById("f_query_add_mod").style.height="82vh";
	/*document.getElementById("blankFrame").style.height="1vh";*/
	document.getElementById("messageFrame").style.height="8vh";
}
function query()
{ 
f_query_add_mod.location.href = "../../eMR/jsp/AnnualCensusofoperationalBedQueryCriteria.jsp"
	//parent.frames[1].document.getElementById("annualsize").rows='8%,84%,*%,8%';
	
	//frames[2].location.href='../../eCommon/html/blank.html';	
	
}

function clearMandatory()
{ 
	var report = window.document.forms[0].Report.value;
	if(window.document.forms[0].Master.value=="")
	{  
		document.forms[0].mand_gif1.style.visibility = "visible";
		document.forms[0].mand_gif2.style.visibility = "hidden";
	}
	else if(window.document.forms[0].Master.value=="SP" && report!="MRIPCSOBD")
	{
		document.forms[0].mand_gif2.style.visibility = "hidden";
	}	
	else if(window.document.forms[0].Master.value=="BD")
	{
		document.forms[0].mand_gif2.style.visibility = "hidden";
	}
	else if(window.document.forms[0].Master.value!="")
	{
		document.forms[0].mand_gif1.style.visibility = "visible";
	}
		
}

function FetchValues()
{   
	type					  = document.forms[0].Master.value
	report_id				  = document.forms[0].Report.value
    group_code				  = document.forms[0].Main_group.value
	sub_group_code			  = document.forms[0].sub_group.value
	census_date				  = document.forms[0].p_census_date.value	
	
	/*parent.parent.frames[1].increasesize.rows='260,*';	*/
	var sm='';
//	parent.frames[3].location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+sm;
//	parent.parent.frames[1].frames[1].location.href='../../eCommon/html/blank.html';
  /*  parent.parent.frames[3].location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+sm;*/
	parent.parent.frames[1].frames[1].location.href='../../eCommon/html/blank.html';
	

	 if( (report_id=='MRIPCSOBD' && type=='BD') )
	{
		  
	    var fields = new Array (document.forms[0].Report,document.forms[0].Master,document.forms[0].Main_group_desc)
		var names  = new Array ( "Report","Master","Level1 Group")
					
	}
	else if((report_id=='MRIPCSOBD' && type=='SP'))
	{ 
		 
		var fields = new Array (document.forms[0].Report,document.forms[0].p_census_date,document.forms[0].Main_group_desc,document.forms[0].sub_group1);
	    var names  = new Array ("Report","Census Year","Level1 Group","Level2 Group");
	}	
	else
	{
      var fields = new Array (document.forms[0].Report,document.forms[0].Master)
		var names  = new Array ( "Report","Master")
	}	
	//if(parent.f_query_add_mod.checkFields(fields, names, parent.messageFrame))
	if(parent.f_query_add_mod_search.checkFieldsofMst(fields, names, parent.parent.messageFrame)) 
	{	 	
		  var msg="";		
		  var sp ="TL";
		 /* parent.frames[2].location.href="../../eMR/jsp/AnnualCensusofoperationalBedResult.jsp?report_id="+report_id+"& type="+type+"&group_code="+group_code+"&sub_group_code="+sub_group_code+"&census_date="+census_date+"&alphabet="+type;
		  parent.frames[3].location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;*/		  
		  parent.frames[1].location.href="../../eMR/jsp/AnnualCensusofoperationalBedResult.jsp?report_id="+report_id+"& type="+type+"&group_code="+group_code+"&sub_group_code="+sub_group_code+"&census_date="+census_date+"&alphabet="+type;		  
         /* parent.parent.frames[3].location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;	*/	  

	}
	else
	{			
		//parent.frames[2].location.href='../../eCommon/html/blank.html';	
          parent.parent.frames[1].frames[1].location.href='../../eCommon/html/blank.html';
		  parent.parent.frames[1].increasesize.rows='260,*'		
	}
}

function funchk(obj)
{  
   var ptr=obj.name;  
   var str=eval(ptr.substring(3,ptr.length))	    
   var obj1=document.forms[0];
   var obj2=eval("obj1.textr1"+str);   
   var concat1=obj2.value
   if(obj.checked==true)
   {
       obj.value="Y";
	   if(concat1=="")
	   {
		   alert("APP-MR0042 Comm Serial No Cannot Be Blank");
		   obj2.focus();
		   obj2.select();
	   }
   }
    else
    obj.value="N";
	
}
function apply()
{  
	var msg='';	
	var criteria_FormObj =	parent.content.f_query_add_mod.f_query_add_mod_search.document.annualCenBedforoperation_form;
	var result_FormObj	 =	parent.content.f_query_add_mod.f_query_add_mod_result.document.annualCenoperationalBedresult; 
	var report_id=criteria_FormObj.Report.value;
    var master=criteria_FormObj.Master.value;	
	if(result_FormObj!=null)
	{	    
		if( report_id=="MRIPCSOBD"){ //Modified for this CRF PER-PD-209A
	 	result_FormObj.function_name1.value="tabulation";		
		result_FormObj.submit();
		}else{
    		parent.content.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;		
		}
		
	}
	else{		
		   parent.content.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
    }		 
}

function onSuccess()
{
	create();
//	frames[2].location.href='../../eCommon/html/blank.html';
	
}
function clearValues()
{  
    parent.parent.f_query_add_mod.f_query_add_mod_result.location.href='../../eCommon/html/blank.html';
	parent.parent.f_query_add_mod.increasesize.rows='260,*'	
		
}
function reset()
{
   var FormObj=parent.content.f_query_add_mod.f_query_add_mod_search;
	var result_FormObj	 =	parent.content.f_query_add_mod.f_query_add_mod_result;
	if(parent.content.f_query_add_mod.document.forms[0]){
			parent.content.f_query_add_mod.location.reload();
	}else if(FormObj){
		/*parent.parent.content.f_query_add_mod.increasesize.rows='260,*'*/
		FormObj.location.reload();
		result_FormObj.location.href='../../eCommon/html/blank.html';

	}	
}

function subGroup1()
{
   parent.parent.frames[1].frames[1].document.location.href="../../eCommon/html/blank.html";  
   parent.parent.frames[1].increasesize.rows='260,*'
}

function chkvalidnum(obj)
{
  var num=obj.value;
  if(eval(num)=="0" || eval(num)=="00" || eval(num)=="000")
  {
	  var msg=geteMRMessage("INVALID_SERIAL_NO");
	  //var msg="APP-MR001 Order Srl No Value should be greater than 0";
      alert(msg);
	  obj.focus();
	  obj.select();
  }
}

async function getSubGroupId()
{
	//	parent.parent.frames[3].location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";
	//	parent.parent.frames[1].frames[1].document.location.href="../../eCommon/html/blank.html"; 
	//	document.getElementById("fetchdata").innerText='';

		var target			= document.forms[0].sub_group;
		var report_gr_id	= document.forms[0].Report.value;
		var main_group		= document.forms[0].Main_group.value;
		var master		= document.forms[0].Master.value;
		var retVal	=  new String();
		var dialogTop			= "40";
		var dialogHeight		= "80vh" ;
		var dialogWidth			= "65vw" ;
		var features			= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
		var arguments			= "" ;
		var search_desc="";
		var search_code="";
		var title="Level2 Group";
		var sql = ""
					
		sql="select group_code, group_desc from mr_report_grouping where report_id =`"+report_gr_id+"` and subgroup_code =`"+main_group+"` and group_category = `S` and group_type is null" ;

	/*	var sql="select group_code, group_desc from mr_report_grouping where report_id =`"+report_gr_id+"` and subgroup_code =`"+main_group+"` and group_category = `S` " ; */


        search_code="group_code";
		search_desc="group_desc";
		retVal= await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+title+"&dispDescFirst=dispDescFirst",arguments,features);
	    var arr=new Array();
	    if (retVal != null && retVal != '' && retVal != "null")
		{
			var retVal=unescape(retVal);
		    arr=retVal.split("::");
		    document.forms[0].sub_group1.value=arr[0];
			document.forms[0].sub_group.value=arr[1];
			document.forms[0].sub_group1.focus();
		   
/*		if(report_gr_id=="MRBLABRG" || report_gr_id=="MRBRADEX" || report_gr_id=="MRIPCSBD") 
	    {
		 var HTMLVal="<html><body><form name='tempform1' id='tempform1' method='post' action='../../eMR/jsp/TLPopulateValues.jsp'><input type='hidden' name=report_gr_id value="+report_gr_id+"><input type='hidden' name=master value="+master+"><input type='hidden' name=main_group value="+main_group+"><input type='hidden' name=levelcode value="+arr[1]+"></form></body></html>";
		 parent.parent.frames[2].document.write(HTMLVal);
	     parent.parent.frames[2].document.tempform1.submit(); 
		}*/
		}
	}
    
	
	function allowPositiveNumber() 
	{
		var key = window.event.keyCode;
		//var rep = parent.frames[1].document.forms[0].Report.value
		//var rep = parent.content.f_query_add_mod.f_query_add_mod_result.annualCenoperationalBedresult.Report.value;
				
			if(((key >=48 ) && (key<58))) 
			{
				return true;
			}
			else
				return false;
		
	}
	/////////////////////////////Changing to LookUp//////////////////////////////

	async function getLevelGroupId()
    {
	//	parent.parent.frames[3].location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";
	//	parent.parent.frames[1].frames[1].document.location.href="../../eCommon/html/blank.html"; 
		var master_table_reference			=document.forms[0].Master.value;
		document.forms[0].sub_group1.value	='';
	//	document.getElementById("fetchdata").innerText	='';

		var target= document.forms[0].Main_group_desc;
		var report_gr_id=document.forms[0].Report.value;
		var retVal	=  new String();
		var dialogTop			= "";
		var dialogHeight		= "80vh" ;
		var dialogWidth			= "65vw" ;
		var features			="dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
		var arguments			= "" ;
		var search_desc="";
		var search_code=""; 
		var title="Level1 Group";
		var sql="select group_code, group_desc from mr_report_grouping where report_id =`"+report_gr_id+"` and mast_table_name_reference=`"+master_table_reference+"` and group_category = `M`"; 

		search_code="group_code";
		search_desc="group_desc";
		retVal= await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+title+"&dispDescFirst=dispDescFirst",arguments,features);
	   
	    var arr=new Array();
	    if (retVal != null && retVal != '' && retVal != "null")
		{
			var retVal=unescape(retVal);
			arr=retVal.split("::");
		    document.forms[0].Main_group_desc.value=arr[0];
			document.forms[0].Main_group.value=arr[1]; 
			document.forms[0].Main_group_desc.focus();		
		
	}
	}	

function level1(obj)
{
	//alert(obj.value);
}
	
function callClear_l1(obj)
{
	var Report=document.forms[0].Report.value;
	var sm='';	
//	parent.parent.frames[3].location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+sm;
//	parent.parent.frames[1].frames[1].location.href='../../eCommon/html/blank.html';
	
	document.forms[0].Main_group_desc.value='';
	document.forms[0].Main_group_desc.disabled=false;
	document.forms[0].Main_group.value='';
	document.forms[0].sub_group1.value='';
	document.forms[0].sub_group1.disabled=false;
	document.forms[0].sub_group11.disabled=false;
	document.forms[0].sub_group.value='';	
	document.forms[0].sub_group.disabled=false;
	
//	document.getElementById("fetchdata").innerText='';
	var report_id=document.forms[0].Report.value
	
	if(obj=='SP')
	{
		document.forms[0].mand_gif1.style.visibility = "visible";
		if (Report=='MRIPCSOBD')
		{
			document.forms[0].mand_gif2.style.visibility = "visible";
		}
	}	
	else if(obj=='BD')
	{
		document.forms[0].mand_gif1.style.visibility = "visible";
		
	}
	
}

function chkyear_fut(obj)
	  {
		  var sysdate=document.forms[0].sysdate.value;
		  var splitdatesys = sysdate.split("/");
		  var sys_date=splitdatesys[2];
		  if(eval(obj.value)>sys_date)
		  {
			var msg=geteMRMessage("MRDATE1_GT_DATE2");
			msg=msg.replace('$','Census Year');
			msg=msg.replace('#','Current Year');
			alert(msg);
			document.forms[0].census_date.focus();
			document.forms[0].census_date.select();
		  }
	  }

function ValidStringrepIPAnnual(event)
{
	if((event.keyCode>=48) && (event.keyCode<=57))
		
	{
		return true
	}
	else
	{	
		return false
	}
}
	
	
	

