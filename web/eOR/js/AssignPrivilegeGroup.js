/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
/*
--------------------------------------------------------------------------------------------------------
Date				Edit History      Name        Description
--------------------------------------------------------------------------------------------------------
?					100            ?           created
06/07/2011    101            Dinesh      Incident No: 26996, AssignPrivilegeGroup final row missing 
10/01/2014    LICN_1            Karthi      MMS Internal Issue
--------------------------------------------------------------------------------------------------------
*/
var function_id = "" ;
var resultGlobal = false;
var messageGlobal = "" ;
var flagGlobal = true;
var linkContent = "";

function create() {
	f_query_add_mod.location.href = "../../eOR/jsp/AssignPrivilegeGroupMain.jsp?mode="+MODE_INSERT+"&function_id="+function_id ;
}

function apply(){

	 var message;
	  if (! checkIsValidForProceed() )
      {
			message  = getMessage("NOT_VALID","OR");
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
			return false ;
	  }
	   var group_by = '';
	   if (f_query_add_mod.AssignPrivilegeGroupHdr.document.AssignPrivilegeGroupHdr.group_by)
	   {
		   	 group_by =  f_query_add_mod.AssignPrivilegeGroupHdr.document.AssignPrivilegeGroupHdr.group_by.value;
	   }

	   var userBy = "";
	   if (group_by == 'PG')
	   {
		   userBy = f_query_add_mod.AssignPrivilegeGroupDtl.document.AssignPrivilegeGroupDtl.dtl_grp_by_code.value;
	   }
	   if (group_by == '')
	   {
			message  = getMessage("GROUP_BY_CANNOT_BE_BLANK","OR");
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
			return false ;
	   }
	   var grp_by_desc = f_query_add_mod.AssignPrivilegeGroupDtl.document.AssignPrivilegeGroupDtl.grp_by_desc.value;
	   if (grp_by_desc == '')
	   {	
		   if (group_by == 'PR')
		   {
			    message  = getMessage("PRACT_NOT_BLANK","OR"); // LICN_1
				messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
				return false ;
		   }
		   else if (group_by == 'PG')
		   {
			    message  = getMessage("PRIV_GROUP_CANNOT_BE_BLANK","OR");
				messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
				return false ;
		   }
	   }

	  if(group_by == 'PR')
	  {
		savePRGroupsForPractitioner(); 
	  }
	 // else if(group_by == 'PG' && userBy =='ALL')
	  //{
		//savePRGroupsForAllUsers(group_by);
	  //}
	 // else if(group_by == 'PG' && userBy =='RALL')
	 // {
		//removePRGroupsForAllUsers(group_by);
	 // }
	  else
	  {
			//if(f_query_add_mod.AssignPrivilegeGroupResult.document.AssignPrivilegeResultForm !=null)
			if(f_query_add_mod.AssignPrivilegeGroupDtl.document.AssignPrivilegeGroupDtl)
			  if(f_query_add_mod.AssignPrivilegeGroupDtl.document.AssignPrivilegeGroupDtl.mode.value==MODE_INSERT )
			 {
				   //var formObj = f_query_add_mod.AssignPrivilegeGroupResult.document.AssignPrivilegeResultForm;
				  var formObj = f_query_add_mod.AssignPrivilegeGroupDtl.document.AssignPrivilegeGroupDtl;
				 
				  var fields = new Array (f_query_add_mod.AssignPrivilegeGroupDtl.document.AssignPrivilegeGroupDtl.grp_by_code);
				  var names = new Array (getLabel("eOR.PrivilegeGroup.label","OR"));
					  
					   if(checkFieldsofMst( fields, names, messageFrame)){ 
						var flag = onApplyUpdate();
					
					if(flag)
					  { 					
						eval( formApply(formObj, OR_CONTROLLER) ) ;
						//alert("resultGlobal = "+resultGlobal);
						//alert("messageGlobal = "+messageGlobal);
						 messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+messageGlobal;
						if(resultGlobal){
							onSuccess();
						}
					  }
					 }
			  }
			  else  if(f_query_add_mod.AssignPrivilegeGroupDtl.document.AssignPrivilegeGroupDtl.mode.value==MODE_MODIFY )
			  {
				  var formObj = f_query_add_mod.AssignPrivilegeGroupDtl.document.AssignPrivilegeGroupDtl;
				  var group_by=f_query_add_mod.AssignPrivilegeGroupDtl.document.AssignPrivilegeGroupDtl.group_by.value;
				  if(group_by == "RS")
				 {
				   var fields = new Array (formObj.grp_by_code,formObj.grp_by_code1);
				   var names = new Array (getLabel("Common.responsibility.label","Common"),getLabel("eOR.PrivilegeGroup.label","OR"));
				 }
				  else
					{
					 var fields = new Array (formObj.grp_by_code,formObj.grp_by_code2);
					 var names = new Array (getLabel("Common.practitioner.label","Common"),getLabel("eOR.PrivilegeGroup.label","OR"));
					}
					 if(checkFieldsofMst( fields, names, messageFrame)){
					eval( formApply(formObj, OR_CONTROLLER) ) ; 
					 messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+messageGlobal;
					if(resultGlobal){
						onSuccess();
					}
				}
			}
	  }
  }

function fetchDetailsRecords(obj)
{
	var mode;
	var val = obj.value;
	/*
		added by kishore kumar n for CRF 641 on Aug-19-09
	*/
	var frmSet = parent.document.getElementById("asgnPrevilegeFrm");
//	alert("frmSet value: "+frmSet);

	if(val =="PG")
	{
		frmSet.rows = "8%,20%,32%"; 
		//parent.document.getElementById("AssignPrivilegeGroupHdr").style.height="9vh";
		//parent.document.getElementById("AssignPrivilegeGroupDtl").style.height="32vh";
		//parent.document.getElementById("AssignPrivilegeGroupResult").style.height="76vh";
		mode="1";
	}
	else
	{
		mode="2";
		frmSet.rows = "6.5%,5%,*";
		//parent.document.getElementById("AssignPrivilegeGroupHdr").style.height="8vh";
		//parent.document.getElementById("AssignPrivilegeGroupDtl").style.height="32vh";
		//parent.document.getElementById("AssignPrivilegeGroupResult").style.height="88vh";
	}

	var function_id=parent.AssignPrivilegeGroupHdr.document.AssignPrivilegeGroupHdr.function_id.value;
	
	var msg = "";

	if(val != "")
	{
		parent.AssignPrivilegeGroupDtl.location.href="../../eOR/jsp/AssignPrivilegeGroupDtl.jsp?function_id="+function_id+"&group_by="+val+"&mode="+mode+"&called_from=Hdr";
		parent.AssignPrivilegeGroupResult.location.href="../../eCommon/html/blank.html";
		parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp";
	}
	else if(val == "")
	{
		
		parent.AssignPrivilegeGroupDtl.location.href="../../eCommon/html/blank.html";
		parent.AssignPrivilegeGroupResult.location.href="../../eCommon/html/blank.html";
		msg = getMessage("GROUPBY_NOT_BLANK",'CA');
		parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg+"&err_value=0";
		return false;
	}
}
 /*Added by kishore kumar N on AUG-22-09 for CRF 641*/
 function callGetGroup(obj)
 {
	if (obj.value != '')
	{
		getGroup(obj.value);
	}
 }

 /*ends here.*/
 
 /*Modified by kishore kumar N on AUG-22-09 for CRF 641*/
  async function getGroup(val)
{    
		
	    if (val == null || val == undefined )
	    {
			val = '';
	    }
		 /*ends here.*/
		var target = "";
		var i = 0;
		var retVal			=  new String();
		
		var search_desc	= "";
		var group_by		= AssignPrivilegeGroupDtl.group_by.value;

		if(group_by == 'PG')
			var title			= getLabel('eOR.PrivilegeGroup.label','OR');
		else if(group_by == 'RS')
				var title			= getLabel('Common.responsibility.label','COMMON');
		else if(group_by == 'PR')
				var title		= getLabel('Common.practitioner.label','COMMON');
		else
				var title			= ' ';
		var sql = AssignPrivilegeGroupDtl.sql_query.value;
		


		var argArray = new Array();
		var namesArray = new Array();
		var valuesArray = new Array();
		var datatypesArray = new Array();
		argArray[0] = sql;
		argArray[1] = namesArray;
		argArray[2] = valuesArray;
		argArray[3] = datatypesArray;
		argArray[4] = "1,2";
		argArray[5] = val;
		argArray[6] = DESC_LINK;
		argArray[7] = CODE_DESC;
		retArray = await CommonLookup( title,argArray );
	var ret1=unescape(retArray);
	//alert("ret1"+ret1);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
		if(retArray != null && retArray !="")	
		{
			document.forms[0].grp_by_desc.value = arr[1];
			document.forms[0].grp_by_code.value = arr[0];
			/*
				added by kishore kumar n for CRF  641 on Aug-19-09
			*/
			if(parent.AssignPrivilegeGroupDtl.applTbl)
			{
				parent.AssignPrivilegeGroupDtl.applTbl.style.display='inline';
			}
			if(group_by == 'PR')
			{
				parent.AssignPrivilegeGroupResult.location.href="../../eOR/jsp/AssignPrivilegeGroupToPractResult.jsp?user="+arr[0]+"&groupBy="+group_by+"&clearUser=Y&grp_by_desc="+arr[1]+"&grp_by_code="+arr[0];
				parent.AssignPrivilegeGroupDtl.location.href="../../eOR/jsp/AssignPrivilegeGroupDtl.jsp?function_id="+function_id+"&group_by="+group_by+"&mode=1&user=P&grp_by_desc="+arr[1]+"&grp_by_code="+arr[0];				
				if(parent.AssignPrivilegeGroupHdr.document.AssignPrivilegeGroupHdr)
				{
					 if(parent.AssignPrivilegeGroupHdr.document.AssignPrivilegeGroupHdr.group_by)
					{
						parent.AssignPrivilegeGroupHdr.document.AssignPrivilegeGroupHdr.group_by.disabled = true;
					}
				}
				//if(parent.AssignPrivilegeGroupDtl.document.AssignPrivilegeGroupDtl.grp_by_desc)
				if(document.AssignPrivilegeGroupDtl)
				{
					if(document.AssignPrivilegeGroupDtl.grp_by_desc)
						document.AssignPrivilegeGroupDtl.grp_by_desc.disabled = true;
					if(document.AssignPrivilegeGroupDtl.grp_by_desc_search)
						document.AssignPrivilegeGroupDtl.grp_by_desc_search.disabled = true;
				}
				
			}
			else if(group_by == 'PG')
			{
				parent.AssignPrivilegeGroupDtl.location.href="../../eOR/jsp/AssignPrivilegeGroupDtl.jsp?function_id="+function_id+"&group_by="+group_by+"&mode=1&user=P&grp_by_desc="+arr[1]+"&grp_by_code="+arr[0];
				if(parent.AssignPrivilegeGroupHdr.document.AssignPrivilegeGroupHdr)
				{
					 if(parent.AssignPrivilegeGroupHdr.document.AssignPrivilegeGroupHdr.group_by)
					{
						parent.AssignPrivilegeGroupHdr.document.AssignPrivilegeGroupHdr.group_by.disabled = true;
					}
				}
				//if(parent.AssignPrivilegeGroupDtl.document.AssignPrivilegeGroupDtl.grp_by_desc)
				if(document.AssignPrivilegeGroupDtl)
				{
					if(document.AssignPrivilegeGroupDtl.grp_by_desc)
						document.AssignPrivilegeGroupDtl.grp_by_desc.disabled = true;
					if(document.AssignPrivilegeGroupDtl.grp_by_desc_search)
						document.AssignPrivilegeGroupDtl.grp_by_desc_search.disabled = true;
				}
										
			}
			/*ends here.*/
		}
		else
		{
			//document.forms[0].grp_by_desc.value = '';
			//document.forms[0].grp_by_code.value = ''
			/*
				added by kishore kumar n for CRF  641 on Aug-19-09
			*/
			if(parent.AssignPrivilegeGroupDtl.applTbl)
			{
				parent.AssignPrivilegeGroupDtl.applTbl.style.display='none';
			}
			parent.AssignPrivilegeGroupResult.location.href="../../eCommon/html/blank.html";
			
			/*ends here.*/
		}
		parent.parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp";
}

  function getGroup1()
{
	    var target = "";
		var i = 0;
		var retVal			=  new String();
		
		var search_desc	= "";
		var group_by		= AssignPrivilegeGroupDtl.group_by.value;

		//alert("group_by==========="+group_by);

		if(group_by == 'PG')
			var title			= getLabel('eOR.PrivilegeGroup.label','OR');
		else if(group_by == 'RS')
				var title			= getLabel('eOR.PrivilegeGroup.label','OR');
		else if(group_by == 'PR')
				var title		= getLabel('eOR.PrivilegeGroup.label','OR');
		else
				var title			= ' ';
		var sql = AssignPrivilegeGroupDtl.sql_query1.value;
		var argArray = new Array();
		var namesArray = new Array();
		var valuesArray = new Array();
		var datatypesArray = new Array();
		argArray[0] = sql;
		argArray[1] = namesArray;
		argArray[2] = valuesArray;
		argArray[3] = datatypesArray;
		argArray[4] = "1,2";
		argArray[5] = "";
		argArray[6] = DESC_LINK;
		argArray[7] = CODE_DESC;
		retArray = CommonLookup( title,argArray );
		if(retArray != null && retArray !="")	
		{
			document.forms[0].grp_by_desc1.value = retArray[1];
			document.forms[0].grp_by_code1.value = retArray[0];
		}
		else
		{
			document.forms[0].grp_by_desc1.value = '';
			document.forms[0].grp_by_code1.value = ''
		}
}

	  function getGroup2()
     {
	    var target = "";
		var i = 0;
		var retVal			=  new String();
		
		var search_desc	= "";
		var group_by		= AssignPrivilegeGroupDtl.group_by.value;

		//alert("group_by==========="+group_by);

		if(group_by == 'PG')
			var title			= getLabel('eOR.PrivilegeGroup.label','OR');
		else if(group_by == 'RS')
				var title			= getLabel('eOR.PrivilegeGroup.label','OR');
		else if(group_by == 'PR')
				var title		= getLabel('eOR.PrivilegeGroup.label','OR');
		else
				var title			= ' ';
		var sql = AssignPrivilegeGroupDtl.sql_query2.value;
		var argArray = new Array();
		var namesArray = new Array();
		var valuesArray = new Array();
		var datatypesArray = new Array();
		argArray[0] = sql;
		argArray[1] = namesArray;
		argArray[2] = valuesArray;
		argArray[3] = datatypesArray;
		argArray[4] = "1,2";
		argArray[5] = "";
		argArray[6] = DESC_LINK;
		argArray[7] = CODE_DESC;
		retArray = CommonLookup( title,argArray );
		if(retArray != null && retArray !="")	
		{
			document.forms[0].grp_by_desc2.value = retArray[1];
			document.forms[0].grp_by_code2.value = retArray[0];
			
			
		}
		else
		{
			document.forms[0].grp_by_desc2.value = '';
			document.forms[0].grp_by_code2.value = ''
		}
}
	
 function validateGrpBy(obj)
{
	if(parent.AssignPrivilegeGroupResult.location.href.indexOf(".jsp") != -1)
		parent.AssignPrivilegeGroupResult.location.href = "../../eCommon/html/blank.html";
}

   function assignResult(res,msg,mod){
	resultGlobal = res ;
	messageGlobal = msg ;
	flagGlobal = mod;
	if(messageGlobal=="CLICK_ONE_ORDERABLE" && resultGlobal==false){
		messageGlobal=getMessage('CLICK_ONE_ORDERABLE',"OR");
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ messageGlobal;
		return false;
	}
}
  function changeValue(chk)
{
	if(chk.checked)
		chk.value = 'Y';
	else 
		chk.value = 'N';
}
   function onSuccess(){

	f_query_add_mod.location.href = "../../eOR/jsp/AssignPrivilegeGroupMain.jsp?mode="+MODE_INSERT+"&function_id="+function_id ;
	
}

 function populatePrevgroup(){
        var bean_id		= parent.AssignPrivilegeGroupDtl.document.AssignPrivilegeGroupDtl.bean_id.value;
        var bean_name	= parent.AssignPrivilegeGroupDtl.document.AssignPrivilegeGroupDtl.bean_name.value;
	    var grp_by_code		= parent.AssignPrivilegeGroupDtl.document.AssignPrivilegeGroupDtl.grp_by_code.value;
	    var group_by		= parent.AssignPrivilegeGroupDtl.document.AssignPrivilegeGroupDtl.group_by.value;
		var callFrom = "populatePrevgroup";
        var xmlStr ="<root><SEARCH ";
		xmlStr += " GROUP_BY=\""+ group_by + "\" ";
		xmlStr += " callFrom=\""+ callFrom + "\" ";
		xmlStr += " GROUP_BY_CODE=\""+ grp_by_code + "\" ";
		xmlStr += " BEAN_ID=\""+ bean_id + "\" ";
		xmlStr += " BEAN_NAME=\""+ bean_name + "\" ";
		xmlStr += " CLASS_NAME=\"AssignPrivilegeGroup\"";
		xmlStr +=" /></root>";
		//alert(xmlStr);
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","AssignPrivilegeGroupValidate.jsp",false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText ;
		//alert("responseText========="+ responseText ) ;
		eval(responseText);
		return true;
	}
   
function checkVal(obj){
	document.forms[0].dispMode.value = obj;
	document.forms[0].submit();
}

   function InvalidPrevcode(groupby)
   {
	   if(groupby=="PR")
	   {
	   parent.AssignPrivilegeGroupDtl.document.AssignPrivilegeGroupDtl.insertrec.value="Y";
	   parent.AssignPrivilegeGroupDtl.document.AssignPrivilegeGroupDtl.applevel.value="P";
	   }
	   else
	   {
		     parent.AssignPrivilegeGroupDtl.document.AssignPrivilegeGroupDtl.insertrec.value="Y";
			 parent.AssignPrivilegeGroupDtl.document.AssignPrivilegeGroupDtl.applevel.value="R";
	   }
   }
   function addPrevcode(code,desc)	   
   {
	 if(parent.AssignPrivilegeGroupDtl.document.AssignPrivilegeGroupDtl.grp_by_desc1)
	   {
	  parent.AssignPrivilegeGroupDtl.document.AssignPrivilegeGroupDtl.grp_by_code1.value=code;
	  parent.AssignPrivilegeGroupDtl.document.AssignPrivilegeGroupDtl.grp_by_desc1.value=desc;
	   }
	   else
	   {  
		   if (parent.AssignPrivilegeGroupDtl.document.AssignPrivilegeGroupDtl.grp_by_code2)
		   parent.AssignPrivilegeGroupDtl.document.AssignPrivilegeGroupDtl.grp_by_code2.value=code;
		   if(parent.AssignPrivilegeGroupDtl.document.AssignPrivilegeGroupDtl.grp_by_desc2)
		   parent.AssignPrivilegeGroupDtl.document.AssignPrivilegeGroupDtl.grp_by_desc2.value=desc;
	   }
   }

   function reset()
  {   		
		f_query_add_mod.location.href = "../../eOR/jsp/AssignPrivilegeGroupMain.jsp?mode="+MODE_INSERT+"&function_id="+function_id ;
	

	/*var url = f_query_add_mod.location.href;
	url = url.toLowerCase();
	if ( (url.indexOf("queryresult.jsp")!= -1) || (url.indexOf("blank")!= -1) ){
		return true;
	}*/

	/*if(url.indexOf(".jsp") != -1){
		f_query_add_mod.AssignPrivilegeGroupHdr.document.forms[0].reset();

		//f_query_add_mod.AssignPrivilegeGroupDtl.location.href="../../eCommon/html/blank.html";
		//f_query_add_mod.AssignPrivilegeGroupResult.location.href="../../eCommon/html/blank.html";
		return true;
		//f_query_add_mod.AssignPrivilegeGroupHdr.location.reload();
	} */
/*	if(f_query_add_mod.AssignPrivilegeGroupDtl.document.AssignPrivilegeGroupDtl)
	if(f_query_add_mod.AssignPrivilegeGroupDtl.document.AssignPrivilegeGroupDtl.mode.value=="1" ){
			    if (f_query_add_mod.AssignPrivilegeGroupResult.document.forms[0]) 
	         {
		          f_query_add_mod.AssignPrivilegeGroupResult.document.AssignPrivilegeResultForm.reset();
	          }
	     }
      else
	   {
		     if(document.frames[1].location.href.indexOf(".jsp") != -1)
	         {
		         document.frames[1].frames[1].document.forms[0].reset();
		      }
	  }*/

}

function onApplyUpdate(){
	 //alert("onApplyUpdate");
//alert(frames[1].frames[2].document.forms[0]);
		var refForm = frames[1].frames[2].document.forms[0];
		if(frames[1].frames[2].location.href.indexOf(".jsp") != -1){
		var bean_id		= refForm.bean_id.value;
		//alert( "bean_id======="+refForm.name);
		var bean_name	= refForm.bean_name.value;
		var fm_disp		= refForm.fm_disp.value;
		var to_disp		= refForm.to_disp.value;
		var tabVal		= refForm.tabVal.value;
		var value_str	= "";
		 var value_str1	= "";

		fm_disp = parseInt(fm_disp);
		to_disp = parseInt(to_disp);

		for(i=fm_disp; i<=to_disp; i++){
			
			var value = frames[1].frames[2].document.getElementById('select_yn'+i);
			if(!value.disabled){
				if(value.checked){
					val = "Y";
					
				}else
					val = "N";
				}
				else
					val ="N";
					value_str += val+"~";
		}
		var xmlStr ="<root><SEARCH ";
		xmlStr += " INDEX_VALUES=\""+ value_str + "\" ";
		xmlStr += " FROM_VALUE=\""+ fm_disp + "\" ";
		xmlStr += " TO_VALUE=\""+ to_disp + "\" ";
		xmlStr += " BEAN_ID=\""+ bean_id + "\" ";
		xmlStr += " BEAN_NAME=\""+ bean_name + "\" ";
		xmlStr += " TAB_VALUE=\""+ tabVal + "\" ";
		xmlStr += " CLASS_NAME=\"SpecimenForOrderable\"";
		xmlStr +=" /></root>";
		//alert(xmlStr);
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","AssignPrivilegeGroupValidate1.jsp",false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText ;
		eval(responseText);
		//alert( responseText ) ;
		return true;
	}
	else
	{
		return true;
	}
}

  function fetchResults()
 {
	
	var group_by			= parent.AssignPrivilegeGroupHdr.AssignPrivilegeGroupHdr.group_by.value;
	var queryString       =	parent.AssignPrivilegeGroupHdr.AssignPrivilegeGroupHdr.queryString.value;

	//alert( "queryString==================="+queryString);
	var	grp_by_code			= parent.AssignPrivilegeGroupDtl.AssignPrivilegeGroupDtl.grp_by_code.value;
	var search_text               =	parent.AssignPrivilegeGroupDtl.AssignPrivilegeGroupDtl.search_text.value;
	var search_text               =	parent.AssignPrivilegeGroupDtl.AssignPrivilegeGroupDtl.search_text.value;
	//alert( "search_text==============="+search_text);
	var dtl_grp_by_code		="";
	var fldName = "";
	var msg = "";

	if(group_by == "PG")

		fldName = getLabel("eOR.PrivilegeGroup.label","OR");

	else if(group_by == "RS")
		fldName = getLabel("Common.responsibility.label","Common");

	else if(group_by == "PR")
		fldName = getLabel("Common.practitioner.label","Common");
		

	if(group_by != "" && grp_by_code != ""){
		/*if(parent.AssignPrivilegeGroupDtl.AssignPrivilegeGroupDtl.dtl_grp_by_code){
			if(parent.AssignPrivilegeGroupDtl.AssignPrivilegeGroupDtl.dtl_grp_by_code(0).checked){
				dtl_grp_by_code		= parent.AssignPrivilegeGroupDtl.AssignPrivilegeGroupDtl.dtl_grp_by_code(0).value;

				//alert("if======="+	 dtl_grp_by_code);
			}else if(parent.AssignPrivilegeGroupDtl.AssignPrivilegeGroupDtl.dtl_grp_by_code(1).checked){
				dtl_grp_by_code		= parent.AssignPrivilegeGroupDtl.AssignPrivilegeGroupDtl.dtl_grp_by_code(1).value;
				//alert("else if======="+	 dtl_grp_by_code);
			}
		}*/

		parent.AssignPrivilegeGroupResult.location.href="AssignPrivilegeGroupResult.jsp?"+queryString+"&group_by="+group_by+"&grp_by_code="+grp_by_code+"&dtl_grp_by_code="+dtl_grp_by_code+"&search_text="+search_text;
		parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp";

	}
	else if(grp_by_code =="")
	{
		parent.AssignPrivilegeGroupResult.location.href=="../../eCommon/html/blank.html";
		//msg = "APP-000001 "+fldName+" cannot be blank...";
		msg = getMessage("CAN_NOT_BE_BLANK","Common");
		msg = msg.replace('$', fldName);
		parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg+"&err_value=0";
		return false;
	}
}
/*Modified by Uma on 9/27/2009 for PMG-CRF-641*/
  function dispLink(obj)
	{
		if(document.forms[0])
		{
			var formObjAddMod = document.forms[0];
			formObjAddMod.grp_by_desc.disabled=true;
			formObjAddMod.grp_by_desc_search.disabled=true;
		}
		var group_by			    = parent.AssignPrivilegeGroupHdr.AssignPrivilegeGroupHdr.group_by.value;
	    var queryString            =	parent.AssignPrivilegeGroupHdr.AssignPrivilegeGroupHdr.queryString.value;
		var grp_by_code			= parent.AssignPrivilegeGroupDtl.AssignPrivilegeGroupDtl.grp_by_code.value;
	   	 var dtl_grp_by_code   =	   parent.AssignPrivilegeGroupDtl.AssignPrivilegeGroupDtl.dtl_grp_by_code.value;
	   	 var search_criteria   =	   "";//parent.AssignPrivilegeGroupDtl.AssignPrivilegeGroupDtl.search_criteria.value;
		 var speciality = "";
		 if(parent.AssignPrivilegeGroupDtl.AssignPrivilegeGroupDtl.speciality)
	   		speciality   =	   parent.AssignPrivilegeGroupDtl.AssignPrivilegeGroupDtl.speciality.value;
		 // alert("group_by===="+group_by+"grp_by_code"+grp_by_code+"dtl_grp_by_code"+dtl_grp_by_code);
		 if(group_by != "" && grp_by_code != ""){
		/*if(parent.AssignPrivilegeGroupDtl.AssignPrivilegeGroupDtl.dtl_grp_by_code){
			if(parent.AssignPrivilegeGroupDtl.AssignPrivilegeGroupDtl.dtl_grp_by_code(0).checked){
				dtl_grp_by_code		= parent.AssignPrivilegeGroupDtl.AssignPrivilegeGroupDtl.dtl_grp_by_code(0).value;
				}else if(parent.AssignPrivilegeGroupDtl.AssignPrivilegeGroupDtl.dtl_grp_by_code(1).checked){
				dtl_grp_by_code		= parent.AssignPrivilegeGroupDtl.AssignPrivilegeGroupDtl.dtl_grp_by_code(1).value;
			}
		      }*/
		         }
        
	    if(grp_by_code != ""){
		var buttonVal = obj;
		if(buttonVal == "S")
		{
			document.getElementById('SelectTab').className="clicked";
			document.getElementById('AssociateTab').className="normal";
		}
		else if(buttonVal == "A")
		{
			document.getElementById('SelectTab').className="normal";
			document.getElementById('AssociateTab').className="clicked";
		}
		var formObjAddMod = document.forms[0];
		formObjAddMod.grp_by_desc.disabled=true;
		formObjAddMod.grp_by_desc_search.disabled=true;
	 var tabValElement = document.getElementById('tabVal');
            if (tabValElement) {
                tabValElement.value = buttonVal;
            } 
       if(parent.frames[2].location.href.indexOf(".jsp") != -1){
		   var flag = latestUpdate();
		}
       if(linkContent=="")
			linkContent	=	document.getElementById("linkId").innerHTML;
	  
		if(buttonVal=="A")
		{
			document.getElementById('linkId').className ="";
			document.getElementById('SpecialityTab').className ="";
			document.getElementById('linkId').innerHTML = "&nbsp;";
			if(document.getElementById('SpecialityTab'))
				document.getElementById('SpecialityTab').style.display = "none";
			parent.frames[2].location.href="../../eOR/jsp/AssignPrivilegeGroupResult.jsp?tabVal="+buttonVal+"&grp_by_code="+grp_by_code+"&group_by="+group_by+"&dtl_grp_by_code="+dtl_grp_by_code+"&search_criteria="+search_criteria+"&speciality="+speciality;
			parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";
		}
		else
		{
			parent.frames[2].location.href="../../eCommon/html/blank.html";
			document.getElementById('linkId').innerHTML = linkContent;
			if(document.getElementById('SpecialityTab')){
				document.getElementById('SpecialityTab').style.display = "";
			}
			parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";
		}
	}
	else{
        var msg = getMessage("SHOULD_NOT_BE_BLANK","Common",new Array(encodeURIComponent(getLabel("eOR.PrivilegeGroup.label","OR"))));
		parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
	}

}
/*Ends Here*/

function callOnAlphaLink(obj, obj2)
{
	changeAlphaColor(obj2);
	var fldObj = document.forms[0].grp_by_code;
	var search_criteria = "";//parent.AssignPrivilegeGroupDtl.AssignPrivilegeGroupDtl.search_criteria.value;
	var speciality = parent.AssignPrivilegeGroupDtl.AssignPrivilegeGroupDtl.speciality_code.value;
	if(parent.frames[2].location.href.indexOf(".jsp") != -1)
	{
		var flag = latestUpdate();
	}
	var grp_by_code = fldObj.value;
	var group_by			    = document.forms[0].group_by.value;
	var queryString            =	parent.AssignPrivilegeGroupHdr.AssignPrivilegeGroupHdr.queryString.value;
		//var grp_by_code			= parent.AssignPrivilegeGroupDtl.AssignPrivilegeGroupDtl.grp_by_code.value;
	   	 //var dtl_grp_by_code   =	 document.forms[0].dtl_grp_by_code.value;
		  if(group_by != "" && grp_by_code != "")
		 {
				if(parent.AssignPrivilegeGroupDtl.AssignPrivilegeGroupDtl.dtl_grp_by_code)
				{
			// Modified by kishore kumar N on 18-Aug-09 for CRF 641  
			/*if(parent.AssignPrivilegeGroupDtl.AssignPrivilegeGroupDtl.dtl_grp_by_code(0).checked){*/
					dtl_grp_by_code		= parent.AssignPrivilegeGroupDtl.AssignPrivilegeGroupDtl.dtl_grp_by_code.value;
               /*}else if(parent.AssignPrivilegeGroupDtl.AssignPrivilegeGroupDtl.dtl_grp_by_code(1).checked){
				dtl_grp_by_code		= parent.AssignPrivilegeGroupDtl.AssignPrivilegeGroupDtl.dtl_grp_by_code(1).value;
			       }*/
				   // Ends here.
				 }
		     }
			 // alert(dtl_grp_by_code);
	  if(grp_by_code !="")
	  {
			parent.AssignPrivilegeGroupResult.location.href="../../eOR/jsp/AssignPrivilegeGroupResult.jsp?dtl_grp_by_code="+dtl_grp_by_code+"&group_by="+group_by+"&grp_by_code="+grp_by_code+"&index="+obj+"&search_criteria="+search_criteria+"&speciality="+speciality+"&tabVal=S";
			parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";
			//fldObj.disabled=true;
			document.forms[0].grp_by_desc.disabled=true;
			document.forms[0].grp_by_desc_search.disabled=true;
	  }
	  else
	  {
		//parent.AssignPrivilegeGroupDtl.location.href="../../eCommon/html/blank.html";
		var msg = getMessage("SHOULD_NOT_BE_BLANK","Common",new Array(encodeURIComponent(getLabel("eOR.PrivilegeGroup.label","OR"))));

		parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
	}
}

function latestUpdate()
{
	var bean_id		= parent.AssignPrivilegeGroupResult.document.AssignPrivilegeResultForm.bean_id.value;
	var bean_name	= parent.AssignPrivilegeGroupResult.document.AssignPrivilegeResultForm.bean_name.value;
	var fm_disp		= parent.AssignPrivilegeGroupResult.document.AssignPrivilegeResultForm.fm_disp.value;
    var to_disp		= parent.AssignPrivilegeGroupResult.document.AssignPrivilegeResultForm.to_disp.value;
	var tabVal		= parent.AssignPrivilegeGroupResult.document.AssignPrivilegeResultForm.tabVal.value;
	var value_str	= "";
	fm_disp = parseInt(fm_disp);
	to_disp = parseInt(to_disp);

	for(i=fm_disp; i<=to_disp; i++){
		var value = eval('parent.AssignPrivilegeGroupResult.document.AssignPrivilegeResultForm.select_yn'+i);
			if (value)
			if(!value.disabled){

				if(value.checked)
					val = "Y";
				else
					val = "N";
				}
				else
					val ="N";
				value_str += val+"~";
  }
		var xmlStr ="<root><SEARCH ";
		xmlStr += " INDEX_VALUES=\""+ value_str + "\" ";
		xmlStr += " FROM_VALUE=\""+ fm_disp + "\" ";
		xmlStr += " TO_VALUE=\""+ to_disp + "\" ";
		xmlStr += " BEAN_ID=\""+ bean_id + "\" ";
		xmlStr += " BEAN_NAME=\""+ bean_name + "\" ";
		xmlStr += " TAB_VALUE=\""+ tabVal + "\" ";
		xmlStr += " CLASS_NAME=\"AssignPrevilegeGroup\"";
		xmlStr +=" /></root>";
		//alert(xmlStr);
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","AssignPrivilegeGroupValidate1.jsp",false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText ;
		//alert("responseText========="+ responseText ) ;
		return true;
	}

	function checkIsValidForProceed()
   {
		 var url = f_query_add_mod.location.href;
		url = url.toLowerCase();
		if ( (url.indexOf("queryresult.jsp")==-1) && (url.indexOf("query")==-1)&&(url.indexOf("blank")==-1) )
				return true;
		else
				return false;
   }
	/*
		added by kishore kumar N on 20-Aug-09 for  CRF 641.
	*/
   function navigate(obj)
   {
		document.getElementById("dispMode").value = obj;
		var user = document.getElementById("user").value;
		var from = document.getElementById("from").value;
		var to = document.getElementById("to").value;
		var dispMode = document.getElementById("dispMode").value;
		var pageCnt = parseInt(document.getElementById("pageCnt").value); //[101], pageCnt increment is reduced
		var row_count = parseInt(document.getElementById("row_count").value);
		var groupBy = document.getElementById("groupBy").value;
		
		var start = parseInt(from);
		var end = parseInt(to);
		if(obj == "Next")
		{
			start = start + 12;
			end = end + 12;

			if (start <= row_count)
			{
				if(end > row_count )
					end = row_count;
			}
		}else if(obj == "Previous")
		{
			start = start - 12;
			if(end == row_count)
			{
				end = end - pageCnt;
			}
			else
			{
				end = end - 12;
			}
		}
		//alert('pageCnt '+pageCnt);
		
		parent.AssignPrivilegeGroupResult.location.href="../../eOR/jsp/AssignPrivilegeGroupToPractResult.jsp?user="+user+"&from="+start+"&to="+end+"&dispMode="+dispMode+"&groupBy="+groupBy;
	}

	function addPrevilege(obj)
	{
		var privilegeId = obj.value;
		var mode = 'ADD';
		if(obj.checked)
		{
			mode = 'ADD';
		}
		else
		{
			mode = 'REMOVE';
		}
		//alert(mode);
		var bean_name = document.getElementById("bean_name").value;
		var bean_id = document.getElementById("bean_id").value;
		var xmlHttp = new XMLHttpRequest() ;
		var xmlDoc="" ;
		var xmlStr = "";
		var callFrom = "addPrevilege";
		xmlStr ="<root><SEARCH ";
		xmlStr += "callFrom=\""+ callFrom +"\" " ;
		xmlStr += "privilegeId=\""+ privilegeId +"\" " ;
		xmlStr += "mode=\""+ mode +"\" " ;
		xmlStr += " BEAN_ID=\""+ bean_id + "\" ";
		xmlStr += " BEAN_NAME=\""+ bean_name + "\" ";
		xmlStr +=" /></root>" ;	
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "AssignPrivilegeGroupValidate.jsp", false ) ;
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText;
		eval(responseText);	
	}

	function savePRGroupsForPractitioner()
	{
		
		var bean_name = f_query_add_mod.AssignPrivilegeGroupResult.document.AssignPrivilegeToPracResultFrm.bean_name.value;
		var bean_id = f_query_add_mod.AssignPrivilegeGroupResult.document.AssignPrivilegeToPracResultFrm.bean_id.value;
		var user = f_query_add_mod.AssignPrivilegeGroupResult.document.AssignPrivilegeToPracResultFrm.user.value;
		var groupBy = f_query_add_mod.AssignPrivilegeGroupResult.document.AssignPrivilegeToPracResultFrm.groupBy.value;		
		var appLevel ='P';
		var xmlHttp = new XMLHttpRequest() ;
		var xmlDoc="" ;
		var xmlStr = "";
		var callFrom = "savePRGroupsForPractitioner";
		xmlStr ="<root><SEARCH ";
		xmlStr += "callFrom=\""+ callFrom +"\" " ;
		xmlStr += " BEAN_ID=\""+ bean_id + "\" ";
		xmlStr += " BEAN_NAME=\""+ bean_name + "\" ";
		xmlStr += " user=\""+ user + "\" ";
		xmlStr += " appLevel=\""+ appLevel + "\" ";
		xmlStr += " groupBy=\""+ groupBy + "\" ";
		xmlStr +=" /></root>" ;	
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "AssignPrivilegeGroupValidate.jsp", false ) ;
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText;
		eval(responseText);	
	}

	function setUser(obj)
	{
		//alert(obj.value);
		var group_by =document.getElementById("group_by").value ;
		var function_id = '';
		if(parent.AssignPrivilegeGroupHdr.document.AssignPrivilegeGroupHdr.function_id)
			function_id = parent.AssignPrivilegeGroupHdr.document.AssignPrivilegeGroupHdr.function_id.value;
		var grp_by_desc = parent.AssignPrivilegeGroupDtl.document.AssignPrivilegeGroupDtl.grp_by_desc.value;
		var grp_by_code = parent.AssignPrivilegeGroupDtl.document.AssignPrivilegeGroupDtl.grp_by_code.value;
		var bean_name = parent.AssignPrivilegeGroupDtl.document.AssignPrivilegeGroupDtl.bean_name.value;
		var bean_id = parent.AssignPrivilegeGroupDtl.document.AssignPrivilegeGroupDtl.bean_id.value;

		var allUser = 'N';
		if (obj.value == 'ALL')
		{
			allUser = 'Y';
		}

		//alert(allUser);

		var xmlHttp = new XMLHttpRequest() ;
		var xmlDoc="" ;
		var xmlStr = "";
		var callFrom = "setUser";
		xmlStr ="<root><SEARCH ";
		xmlStr += "callFrom=\""+ callFrom +"\" " ;
		xmlStr += " BEAN_ID=\""+ bean_id + "\" ";
		xmlStr += " BEAN_NAME=\""+ bean_name + "\" ";
		xmlStr += " user=\""+ obj.value + "\" ";
		xmlStr +=" /></root>" ;	
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "AssignPrivilegeGroupValidate.jsp", false ) ;
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText;
		eval(responseText);	

		parent.AssignPrivilegeGroupDtl.location.href="../../eOR/jsp/AssignPrivilegeGroupDtl.jsp?function_id="+function_id+"&group_by="+group_by+"&mode=1&user="+obj.value+"&grp_by_desc="+grp_by_desc+"&grp_by_code="+grp_by_code+"&allUser="+allUser;
		parent.AssignPrivilegeGroupResult.location.href="../../eCommon/html/blank.html";
		parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp";
	}


	function savePRGroupsForAllUsers(group_by)
	{	
		var bean_name = f_query_add_mod.AssignPrivilegeGroupDtl.document.AssignPrivilegeGroupDtl.bean_name.value;
		var bean_id = f_query_add_mod.AssignPrivilegeGroupDtl.document.AssignPrivilegeGroupDtl.bean_id.value;
		var grp_by_code = f_query_add_mod.AssignPrivilegeGroupDtl.document.AssignPrivilegeGroupDtl.grp_by_code.value;
		var appLevel ='P';
		var user ='*ALL';
		var localeName='en';
		var xmlHttp = new XMLHttpRequest() ;
		var xmlDoc="" ;
		var xmlStr = "";
		var callFrom = "savePRGroupsForPractitioner";
		xmlStr ="<root><SEARCH ";
		xmlStr += "callFrom=\""+ callFrom +"\" " ;
		xmlStr += " BEAN_ID=\""+ bean_id + "\" ";
		xmlStr += " BEAN_NAME=\""+ bean_name + "\" ";
		xmlStr += " user=\""+ user + "\" ";
		xmlStr += " appLevel=\""+ appLevel + "\" ";
		xmlStr += " groupBy=\""+ group_by + "\" ";
		xmlStr += " grp_by_code=\""+ grp_by_code + "\" ";
		xmlStr += " function_id=\""+ function_id + "\" ";
		xmlStr += " localeName=\""+ localeName + "\" ";
		xmlStr +=" /></root>" ;	
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "AssignPrivilegeGroupValidate.jsp", false ) ;
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText;
		eval(responseText);	
		
	}

	function removePRGroupsForAllUsers(group_by)
	{		
		var bean_name = f_query_add_mod.AssignPrivilegeGroupDtl.document.AssignPrivilegeGroupDtl.bean_name.value;
		var bean_id = f_query_add_mod.AssignPrivilegeGroupDtl.document.AssignPrivilegeGroupDtl.bean_id.value;
		var grp_by_code = f_query_add_mod.AssignPrivilegeGroupDtl.document.AssignPrivilegeGroupDtl.grp_by_code.value;
		
		var appLevel ='P';
		var localeName='en';
		var xmlHttp = new XMLHttpRequest() ;
		var xmlDoc="" ;
		var xmlStr = "";
		var callFrom = "removePRGroupsForAllUsers";
		xmlStr ="<root><SEARCH ";
		xmlStr += "callFrom=\""+ callFrom +"\" " ;
		xmlStr += " BEAN_ID=\""+ bean_id + "\" ";
		xmlStr += " BEAN_NAME=\""+ bean_name + "\" ";
		xmlStr += " appLevel=\""+ appLevel + "\" ";
		xmlStr += " groupBy=\""+ group_by + "\" ";
		xmlStr += " grp_by_code=\""+ grp_by_code + "\" ";
		xmlStr += " function_id=\""+ function_id + "\" ";
		xmlStr += " localeName=\""+ localeName + "\" ";
		xmlStr +=" /></root>" ;	
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "AssignPrivilegeGroupValidate.jsp", false ) ;
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText;
		eval(responseText);	
	}
	/*
		ends here.
	*/
	/* Added by Uma on 9/27/2009 for PMG-CRF-641*/
	function callSpecialityDesc(obj)
{
	if(obj.value!="")
	{
		callSpeciality(obj);
	}
	else
	{
		document.AssignPrivilegeGroupDtl.speciality_code.value="";
	}
}

async function callSpeciality(obj)  //Called on click of the speciality
{
	var dataNameArray  		= new Array() ;
	var dataValueArray 		= new Array() ;
	var dataTypeArray 		= new Array() ;
	var sql_query			= document.AssignPrivilegeGroupDtl.sql_or_order_entry_speciality.value;
	var argumentArray  		= new Array() ;
		argumentArray[0]	= sql_query;
		argumentArray[1]	= dataNameArray ;
		argumentArray[2]	= dataValueArray ;
		argumentArray[3]	= dataTypeArray ;
		argumentArray[4]	= "1,2";
		argumentArray[5]	= document.AssignPrivilegeGroupDtl.speciality.value ;//Target
	retVal = await callCommonLookUpSearch(argumentArray,obj.name);
	
	var ret1=unescape(retVal);
	//alert("ret1"+ret1);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
	if(retVal!=null && retVal!='')
	{
		document.AssignPrivilegeGroupDtl.speciality.value 		= arr[1] ;
		document.AssignPrivilegeGroupDtl.speciality_code.value = arr[0];
	}
	else
	{
		document.AssignPrivilegeGroupDtl.speciality.value 		= "";
	}
}

async function callCommonLookUpSearch(argumentArray,name) // calling the Common Look Up(For Population of Practitioner and Location)
{
  		argumentArray[6]   	= CODE_LINK; // DESC_LINK ;
  		argumentArray[7]   	= CODE_DESC ; // DESC_CODE display part
  		var title			= "";
  		title = getLabel("Common.speciality.label","Common")
  		return retVal = await CommonLookup( title, argumentArray );
} // End of Common Look Up

function callPractitionerValues(practitioner,speciality,search_criteria)
{
	var fldObj = document.forms[0].grp_by_code;
	if(parent.frames[2].location.href.indexOf(".jsp") != -1)
	{
		var flag = latestUpdate();
	}
	var grp_by_code = fldObj.value;
	var group_by			    = document.forms[0].group_by.value;
	var queryString            =	parent.AssignPrivilegeGroupHdr.AssignPrivilegeGroupHdr.queryString.value;
    if(group_by != "" && grp_by_code != "")
	{
		if(parent.AssignPrivilegeGroupDtl.AssignPrivilegeGroupDtl.dtl_grp_by_code)
		{
			dtl_grp_by_code		= parent.AssignPrivilegeGroupDtl.AssignPrivilegeGroupDtl.dtl_grp_by_code.value;
               
		}
	}
	  if(grp_by_code !="")
	  {
			parent.AssignPrivilegeGroupResult.location.href="../../eOR/jsp/AssignPrivilegeGroupResult.jsp?dtl_grp_by_code="+dtl_grp_by_code+"&group_by="+group_by+"&grp_by_code="+grp_by_code+"&index="+practitioner.value+"&speciality="+speciality.value+"&search_criteria="+search_criteria.value+"&tabVal=S";
			parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";
			document.forms[0].grp_by_desc.disabled=true;
			document.forms[0].grp_by_desc_search.disabled=true;
	  }
	  else
	  {
			var msg = getMessage("SHOULD_NOT_BE_BLANK","Common",new Array(encodeURIComponent(getLabel("eOR.PrivilegeGroup.label","OR"))));
			parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
	 }
}
/*Ends Here*/
