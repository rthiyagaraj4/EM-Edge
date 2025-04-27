/*
	FileName	: DiscretePanel.js
	Version	    : 3	
	Created On	: 5-5-2005
	Created By	: Jupitora 
*/
function create() {
	discrete.rows="14%,34%,*,8%";
	f_query_add_mod.location.href = "../../eAM/jsp/DiscretePanelAddModify.jsp?mode=insert" ;
	paneladd.location.href = "../../eCommon/html/blank.html" ;
	paneldetails.location.href = "../../eCommon/html/blank.html" ;
}
function query() {
	discrete.rows="14%,*%,0%,8%";
	f_query_add_mod.location.href = "../../eAM/jsp/DiscretePanelQueryCriteria.jsp";
	
	
}

function onSuccess(obj) {
	if(f_query_add_mod.document.forms[0].mode.value=="insert" )
		create();
	else
	{
		
         f_query_add_mod.location.reload();
		 paneladd.location.reload();
		paneldetails.location.reload();
	}
}

/*//
function searchCitizenship(obj,target)
{
	var retVal =    new String();
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var tit="Citizenship";

	sql = "select country_code code, long_desc description from mp_country where eff_status = 'E' and upper(country_code) like upper(?) and upper(long_desc) like upper(?) and long_desc is not null order by 2";
		
	argumentArray[0] =sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2";
	argumentArray[5] = target.value;
	argumentArray[6] = DESC_LINK  ;
	argumentArray[7] = DESC_CODE ;
	retVal = await CommonLookup( tit, argumentArray );
	if(retVal != null && retVal != "" )
	{
		var ret1=unescape(retVal);
		arr=ret1.split(",");
		target.value=arr[1];
		document.forms[1].citizen.value= arr[0];
		
	}
	else{
		target.value='';
		document.forms[1].citizen.value= '';
		
	}
	if(document.forms[1].practid.value != '')
	{
		check6();
	}
	
}
*///

 async function getPanelId(target)
{
	

		var target				= document.forms[0].panel_id.value;	
		var result_type=parent.frames[1].document.forms[0].result_type.value;	
		var service             =parent.frames[1].document.forms[0].service.value;
		
		//var retVal =    new String();
	    var argumentArray  = new Array() ;
	    var dataNameArray  = new Array() ;
	    var dataValueArray = new Array() ;
	    var dataTypeArray  = new Array() ;
	    var tit=getLabel("Common.PanelID.label","Common");
        

		/*if(service=="")
		{
		alert("APP-000001-Please select Service");
		return false;
		}
		else
		{*/	
		var retVal				=  new String();
		var dialogTop			= "40px";
		var dialogHeight		= "400px" ;
		var dialogWidth			= "700px" ;
		var features			="dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
		var arguments			= "" ;
		//var search_desc="";
	//	var title=encodeURIComponent(getLabel("Common.PanelID.label","Common"));

		//var sql="SELECT practitioner_id, practitioner_name FROM am_practitioner where eff_status=`E`";
		// order by upper(practitioner_name) 
		//var sql="Select discr_msr_id, short_desc, service_code,result_type from am_discr_msr where eff_status = `E`";//and service_code= `"+service+"` ";
		//sql = "select discr_msr_id code, short_desc description from am_discr_msr where eff_status = 'E'"

		sql = "select discr_msr_id code, short_desc description from am_discr_msr where eff_status = 'E' and result_type NOT IN ('G', 'V', 'Z')";
		 if (result_type=='V')
        {
			//sql+=" and result_type in (`C`,`D`,`E`,`N`,`I`,`L`	,`H`,`T`) ";
			sql+=" and vs_appl_yn='Y'";
			
        }
		else if (result_type=='Z')
        {
			sql+=" and rs_appl_yn='Y'";
		}
		else if (result_type=='G')
        {
			sql+=" and ch_appl_yn='Y'";
		}
		sql=sql+"and upper(discr_msr_id) like upper(?) and upper(short_desc) like upper(?) ";
       
	argumentArray[0] =sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2";
	argumentArray[5] = target;
	//argumentArray[5] = document.forms[0].panel_id.value
	argumentArray[6] = CODE_LINK  ;
	argumentArray[7] = CODE_DESC ;
	
	retVal = await CommonLookup( tit, argumentArray );
	
	/*if(retVal != null && retVal != "" )
	{
		var ret1=unescape(retVal);
		arr=ret1.split(",");
		target.value=arr[1];
		document.forms[1].citizen.value= arr[0];
		
	}*/
		//search_code="discr_msr_id";
		//search_desc="short_desc";
		//retVal=window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+title+"&dispDescFirst=dispDescFirst",arguments,features);
		 
		var arr=new Array();

		if(retVal != null && retVal != "" )
		{

			var retVal=unescape(retVal);		
		   	 arr=retVal.split(",");
		
		    document.forms[0].desc.value=arr[1];
			document.forms[0].panel_id.value=arr[0];
			//document.forms[0].panel_id.focus();
		}
		else
		{
			document.forms[0].panel_id.value="";
			document.forms[0].desc.value="";
			//target.focus();
		}
		//}
	}
		
function clearFields()
{
	document.forms[0].panel_id.value="";
	document.forms[0].desc.value="";
	document.forms[0].mandatory.checked=false;
	document.forms[0].panel_id.disabled=false;
	document.forms[0].id.disabled=false;
	parent.frames[3].location.href="../../eAM/jsp/DiscretePanelAddtoPanelElement.jsp?flag=";

}
 
function addPanel()
{
	
	var id=parent.frames[3].document.forms[0].panel_id.value;
	var desc= parent.frames[3].document.forms[0].desc.value;
	var mandatory= parent.frames[3].document.forms[0].mandatory.value;
	
	var mode=parent.frames[3].document.forms[0].mode.value;
	var disp_flag=parent.frames[3].document.forms[0].disp_flag.value;
	var clearvalue=parent.frames[3].document.forms[0].clearvalue.value;
	var code=parent.frames[3].document.forms[0].code.value;
	for(var i=0;i<desc.length;i++)
	{
		//alert('coming'+desc.indexOf("+"))
		if(desc.indexOf("+")!=-1)
		desc=desc.replace("+","|");
	}
	//alert(desc);
	
	//alert(" mandatory  "+ mandatory);
    if(id==null || id=="")
	{
		var error=getMessage("CAN_NOT_BE_BLANK",'Common');
		error=error.replace("$",getLabel("Common.identification.label","Common"));
		alert(error);
        parent.frames[3].document.forms[0].desc.value="";
		return false;
	}	
	else if(desc==null || desc=="")
	{
		var error=getMessage("CAN_NOT_BE_BLANK",'Common');
		error=error.replace("$",getLabel("Common.description.label","Common"));
		alert(error);
		return false;
	}	
	else
	{
		
		parent.frames[2].location.href="../../eAM/jsp/DiscretePanelQueryCriteriaResult.jsp?id="+id+"&description="+escape(desc)+"&mode="+mode+"&mandatory="+mandatory+"&disp_flag="+disp_flag+"&code="+code+"&clearvalue="+clearvalue+"&removebean=Y";
	}
parent.frames[3].location.href="../../eAM/jsp/DiscretePanelAddtoPanelElement.jsp?mode="+mode+" ";
}

 function displayPanel()
 {
	 if(document.forms[0].result_type.value=='')
	 {
		parent.frames[3].location.href="../../eCommon/html/blank.html";
		parent.frames[2].location.href="../../eCommon/html/blank.html";
		parent.frames[4].location.href="../../eCommon/jsp/MstCodeError.jsp";
	 } 
	 else
	 {
	parent.frames[1].document.forms[0].discr_panel_id.value="";
	parent.frames[1].document.forms[0].long_desc.value="";
	parent.frames[1].document.forms[0].short_desc.value="";
	parent.frames[1].document.forms[0].service.selectedIndex=0;
	var mode=parent.frames[1].document.forms[0].mode.value;
	
	//parent.frames[3].location.reload();
	parent.frames[3].location.href="../../eAM/jsp/DiscretePanelAddtoPanelElement.jsp?mode="+mode+"";
	parent.frames[2].location.href="../../eCommon/html/blank.html";
	parent.frames[4].location.href="../../eCommon/jsp/MstCodeError.jsp";
	 }

 }
function apply()
{
	var mode= f_query_add_mod.document.forms[0].mode.value;
		
	var fields = new Array (f_query_add_mod.document.forms[0].result_type,
							f_query_add_mod.document.forms[0].discr_panel_id,
							f_query_add_mod.document.forms[0].long_desc,
							f_query_add_mod.document.forms[0].short_desc,
							f_query_add_mod.document.forms[0].service
							
							);
	
	var names = new Array (	 getLabel("Common.ResultType.label","Common"),
							 getLabel("Common.identification.label","Common"),
							 getLabel("Common.longdescription.label","Common"),
							 getLabel("Common.shortdescription.label","Common"),
							 getLabel("Common.service.label","Common")
							 
								);
	
						
	if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame))
	{
		if(mode != null)
		{
			if(mode =='update')
			{
				f_query_add_mod.document.forms[0].result_type1.value= f_query_add_mod.document.forms[0].result_type.value;
				f_query_add_mod.document.forms[0].discr_panel_id1.value= f_query_add_mod.document.forms[0].discr_panel_id.value;
				f_query_add_mod.document.forms[0].long_desc1.value= f_query_add_mod.document.forms[0].long_desc.value;
				f_query_add_mod.document.forms[0].short_desc1.value= f_query_add_mod.document.forms[0].short_desc.value;
				f_query_add_mod.document.forms[0].service1.value= f_query_add_mod.document.forms[0].service.value;
			}
		}
	f_query_add_mod.document.DiscrPanel_form.submit();
	
	}
	
	
}

function Reassaign(obj)
{
	//alert("inside reassign");
	
		if(!obj.checked)
		{
			if(window.confirm(getMessage("DELETE_RECORD",'Common')) == true)
			{
			
			var chkval = obj.value;
			var flag="false";
			//1/3/2006alert("chkval"+chkval);
			
			parent.frames[2].location.href="../../eAM/jsp/DiscretePanelQueryCriteriaResult.jsp?code="+chkval+"&flag="+flag+"";
		}
	}
}
function deleteRecord()
{
			
			
			var chkval = parent.frames[3].document.forms[0].delval.value;
			//alert(chkval);
			var flag="false";
			
			parent.frames[2].location.href="../../eAM/jsp/DiscretePanelQueryCriteriaResult.jsp?code="+chkval+"&flag="+flag+"";
			parent.frames[3].document.forms[0].panel_id.value="";
			parent.frames[3].document.forms[0].desc.value="";
			parent.frames[3].document.forms[0].del.disabled=true;
            parent.frames[3].document.forms[0].panel_id.disabled=false;
            parent.frames[3].document.forms[0].id.disabled=false;
            parent.frames[3].document.forms[0].mandatory.checked=false;
		
	parent.frames[3].location.href="../../eAM/jsp/DiscretePanelAddtoPanelElement.jsp?flag=";
}

function checkForMode(objCheck)
{
	
	
	var mode = document.forms[0].mode.value;
	//alert("mode"+mode);
	if(mode == 'insert' || mode == 'update' )
	{
		
		if(objCheck.checked== true)
		{
			document.forms[0].mandatory.value='Y'
		}
		else
		{
			document.forms[0].mandatory.value='N'
		}
	}
}

function checkRec(obj)
{
	if (obj.value!="")
	{
		
		HTMLVal="<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'><head><script language='javascript' src='../../eCommon/js/ValidateControl.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><body class=MESSAGE onKeyDown = 'lockKey()'><form name='discreteForm' id='discreteForm' method='post' action='DiscretePanelSearch.jsp'><input type=hidden name='discrete' id='discrete' value='"+obj.value+"' </form></body></html>"
		
		parent.frames[4].document.write(HTMLVal);
		parent.frames[4].document.discreteForm.submit();
		//parent.frames[3].document.forms[0].mandatory.focus();
	}

}
function checkstatus(objCheck)
{
 if(objCheck == 'D')
 parent.frames[3].document.forms[0].id.disabled=true;	
 else
	{
 var mode = document.forms[0].mode.value;
	
	if( mode == 'update' )
	{
		
		if(objCheck.checked== true)
		{
			document.forms[0].eff_status.value='E'
		}
		else
		{
			
			document.forms[0].eff_status.value='D'
			
		}
	}
	}
}

/*function panelposition(position,last)
{
//alert(last)
if(last != 'X')
last ='';

var mode=parent.frames[2].document.forms[0].mode.value
var temp=parent.frames[2].document.forms[0].first.value
	
alert("temp"+temp)
if(temp=='')
{	
parent.frames[2].document.forms[0].first.value=	position;
showvis();
//callfun(k+");'
}
else
	{
	var pos1=parent.frames[2].document.forms[0].first.value;
	parent.frames[2].document.forms[0].first.value='';
	alert('pos1'+pos1);
	alert('position'+position);
    if(pos1!=position){
  	parent.frames[2].location.href="../../eAM/jsp/DiscretePanelQueryCriteriaResult.jsp?change=Y&pos1="+pos1+"&pos2="+position+"&mode="+mode+"&lastlink="+last+"";
	showvis();
	}
	else {parent.frames[2].document.forms[0].first.value=position;}
		//document.getElementById('last').style.display='none';
	    //document.getElementById('rowId').className='';
	}

}*/
///
function panelposition(position,last)
{

if(parent.frames[2].document.forms[0].first.value != position)
	{
if(last != 'X')
last ='';

var mode=parent.frames[2].document.forms[0].mode.value
var temp=parent.frames[2].document.forms[0].first.value
if(temp==''){showvis();	
parent.frames[2].document.forms[0].first.value=	position;
}
else
	{
	var pos1=parent.frames[2].document.forms[0].first.value;
	parent.frames[2].document.forms[0].first.value='';
	//alert('pos1'+pos1);
	//alert('position'+position);

 	parent.frames[2].location.href="../../eAM/jsp/DiscretePanelQueryCriteriaResult.jsp?change=Y&pos1="+pos1+"&pos2="+position+"&mode="+mode+"&lastlink="+last+"";
	showvis();
	}
	}
}
///
function showvis(val)
{

if(val == 'true')
document.getElementById("last").style.display='none';
else
document.getElementById("last").style.display='block';
//parent.frames[2].document.getElementById("last").style.visibility = 'visible';
}
function reset()
{
	if(f_query_add_mod.document.forms[0].mode)
	{
		
		if(f_query_add_mod.document.forms[0].mode.value !="update")
		{
		discrete.rows="14%,34%,*,8%";
		f_query_add_mod.location.href = "../../eAM/jsp/DiscretePanelAddModify.jsp?mode=insert" ;
		paneladd.location.href = "../../eCommon/html/blank.html" ;
		paneldetails.location.href = "../../eCommon/html/blank.html" ;
		}else
		{
		//	f_query_add_mod.document.forms[0].reset();
			f_query_add_mod.document.location.reload();
		}
	}else
	{
		//f_query_add_mod.document.query_form.reset() ;
		f_query_add_mod.document.location.reload();
	}
}

