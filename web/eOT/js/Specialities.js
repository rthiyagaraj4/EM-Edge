/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
function create(){
	var formObj = document.forms[0];
	var params = formObj.params.value;
		f_query_add_mod.location.href="../../eOT/jsp/SpecialitiesPrePostOperativeChecklistAddModify.jsp?"+params+"&mode=insert";
}

function checkFields_For_Pre_OP(){
	var formObj=f_query_add_mod.document.forms[0];
    if(formObj.pre_op_checklist_desc.value!=''){
		if(formObj.no_of_verifications.value==''){
			var mesg=getMessage("APP-OT0100","OT");
            messageFrame.document.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+mesg;
	    	return false;
		}

   }
   return true;
}
function checkFields_For_Post_OP(){
var formObj=f_query_add_mod.document.forms[0];
    if(formObj.post_op_checklist_desc.value!=''){
		if(formObj.no_of_verifications1.value==''){
			var mesg=getMessage("APP-OT0101","OT");
            messageFrame.document.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+mesg;
		return false;
		}
   }
   return true;
}

/*function chkPreNoVerfications(){
	var err_txt="";
	var roleMsg=getMessage("CANNOT_BE_BLANK","OT");
	var msgArry=roleMsg.split("&");
	var role_value=getLabel("Common.Role.label","Common");
	var formObj = document.forms[0];
	var verification = document.forms[0].no_of_verifications.value;
	for(var j in verification){
		if(eval("formObj.role_desc"+j+1).value=="")
		 err_txt+ = (err_txt.length>0)?msgArry[0]+ role_value +j+1+ msgArry[1]:msgArry[0]+ role_value + "1" + msgArry[1]+",";
	}
	if(err_txt.length>0){
		window.parent.frames[1].frames[2].location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+ err_txt +" : "+getLabel("eOT.PreOperativeCheckList.Label","OT");
		 return false;
	 }else       
	  return true;

}

function chkPostNoVerfications(){
	var err_txt="";
	var roleMsg=getMessage("CANNOT_BE_BLANK","OT");
	var msgArry=roleMsg.split("&");
	var role_value=getLabel("Common.Role.label","Common");
	var formObj = document.forms[0];
	var verification = document.forms[0].no_of_verifications1.value;
	for(var j in verification){
		if(eval("formObj.role_desc"+j+1).value=="")
		 err_txt+ = (err_txt.length>0)?msgArry[0]+ role_value +j+5+ msgArry[1]:msgArry[0]+ role_value + "1" + msgArry[1]+",";
	}
	if(err_txt.length>0){
		window.parent.frames[1].frames[2].location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+ err_txt +" : "+getLabel("eOT.PreOperativeCheckList.Label","OT");
		 return false;
	 }else       
	  return true;

}

function checkFields_For_No_Of_Verify1(){

}*/


function checkFields_For_No_Of_Verify1(){
	var err_txt="";
	var roleMsg=getMessage("CANNOT_BE_BLANK","OT");
	var msgArry=roleMsg.split("&");
	var role_value=getLabel("Common.Role.label","Common");
	var formObj=f_query_add_mod.document.forms[0];

	if(formObj.no_of_verifications.value=='1'){
		
		if(formObj.role_desc1.value==''){
			//err_txt="Enter Value For Role 1"+",";
			err_txt=msgArry[0]+ role_value + "1" + msgArry[1]+",";
         }
	}else if(formObj.no_of_verifications.value=='2'){
		 if(formObj.role_desc1.value==''){
			err_txt=role_value+" 1";
        }
		if(formObj.role_desc2.value==''){
           err_txt+=(err_txt.length>0)?","+role_value+" 2 ":role_value+" 2 ";
		}
		if(err_txt.length>0)
		   err_txt=msgArry[0]+ err_txt + msgArry[1];
		
	}else if (formObj.no_of_verifications.value=='3'){
        if(formObj.role_desc1.value==''){
			err_txt=role_value+" 1";
        }
		if(formObj.role_desc2.value==''){
           err_txt+=(err_txt.length>0)?","+role_value+" 2 ":role_value+" 2 ";
		}
		if(formObj.role_desc3.value==''){
          err_txt+=(err_txt.length>0)?","+role_value+" 3 ":role_value+" 3 " ;
		}
	   if(err_txt.length>0)

		err_txt=msgArry[0]+ err_txt + msgArry[1];

	}else if (formObj.no_of_verifications.value=='4'){
        if(formObj.role_desc1.value==''){
			err_txt+=role_value+" 1";
        }
		if(formObj.role_desc2.value==''){
           err_txt+=(err_txt.length>0)?","+role_value+" 2 ":role_value+" 2 ";
		}
		if(formObj.role_desc3.value==''){
          err_txt+=(err_txt.length>0)?","+role_value+" 3 ":role_value+" 3 " ;
		}
		if(formObj.role_desc4.value==''){
          err_txt+=(err_txt.length>0)?","+role_value+" 4 ":role_value+" 4 " ;
		}
		
		   if(err_txt.length>0)
		   err_txt=msgArry[0]+ err_txt + msgArry[1];
    	
	}
	if(err_txt.length>0){
		parent.content.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+ err_txt +" : "+getLabel("eOT.PreOperativeCheckList.Label","OT");
		 return false;
	 }else       
	  return true;
 }



function checkFields_For_No_Of_Verify2(){
	var err_txt="";
	var roleMsg=getMessage("CANNOT_BE_BLANK","OT");
	var msgArry=roleMsg.split("&");
	var role_value=getLabel("Common.Role.label","Common");
	var formObj=f_query_add_mod.document.forms[0];
	if(formObj.no_of_verifications1.value=='1'){
		if(formObj.role_desc5.value==''){
			//err_txt+="Enter Value For Role 1"+",";
			err_txt+=msgArry[0]+ role_value + " 1 " + msgArry[1];
        }
	}else if(formObj.no_of_verifications1.value=='2'){
		
		  if(formObj.role_desc5.value==''){
				err_txt=role_value+" 1 ";
		  }
		   
		  if(formObj.role_desc6.value==''){
				err_txt+=(err_txt.length>0)?","+role_value+" 2 ":role_value+" 2 ";
		  }

		   if(err_txt.length>0)
				err_txt=msgArry[0]+ err_txt + msgArry[1];
	
	}else if (formObj.no_of_verifications1.value=='3'){
          if(formObj.role_desc5.value==''){
			err_txt=role_value+" 1 ";
         }
		  if(formObj.role_desc6.value==''){
			err_txt+=(err_txt.length>0)?","+role_value+" 2 ":role_value+" 2 ";
		  }
		   if(formObj.role_desc7.value==''){
			  //err_txt+=","+role_value+" 3 ";
			  err_txt+=(err_txt.length>0)?","+role_value+" 3 ":role_value+" 3 ";
		    }
			if(err_txt.length>0)
				err_txt=msgArry[0]+ err_txt + msgArry[1];

	}else if (formObj.no_of_verifications1.value=='4'){
        if(formObj.role_desc5.value==''){
			err_txt=role_value+" 1 ";
        }
		if(formObj.role_desc6.value==''){
          err_txt+=(err_txt.length>0)?","+role_value+" 2 ":role_value+" 2 ";
		}
		if(formObj.role_desc7.value==''){
		   err_txt+=(err_txt.length>0)?","+role_value+" 3 ":role_value+" 3 ";
	    }
        if(formObj.role_desc8.value==''){
			 err_txt+=(err_txt.length>0)?","+role_value+" 4 ":role_value+" 4 ";
		}
	if(err_txt.length>0)
	   err_txt=msgArry[0]+ err_txt + msgArry[1];
	}
	if(err_txt.length>0){
		parent.content.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+ err_txt +" : "+getLabel("eOT.PostOperativeCheckList.Label","OT");
		return false;
	 }else       
	  return true;
 
}

function checkFrameExist(){
	if (typeof (parent.content.f_query_add_mod.master_frame)=="undefined" || typeof (parent.content.f_query_add_mod.detail_frame=="undefined"))
	{
		 parent.content.messageFrame.location.reload();
		 parent.content.commontoolbarFrame.location.reload();
		 return false;
	}
}

   
function apply()
{
	var speciality_value=getLabel("Common.speciality.label","Common");
	//alert("in apply");
	var frm=f_query_add_mod.document.forms[0];
	var mode = f_query_add_mod.document.forms[0].mode.value
	//if(frm.name=='query_form' || frm.name=='QueryResult'){
    // alert("in apply at 265");
	 var fields = new Array (f_query_add_mod.document.forms[0].speciality_desc);
	var names = new Array ( speciality_value);
	
	if (checkFields_For_Pre_OP()){
	  if(checkFields_For_Post_OP()){
	   if(checkFields_For_No_Of_Verify1()){
	      if (checkFields_For_No_Of_Verify2()){
			  if(checkRoleDuplicates()){ //if(checkFor_Role_Duplications1()){
	                if(checkFieldsofMst( fields, names, messageFrame)){	
						//alert("in apply at 276");
			          f_query_add_mod.document.forms[0].submit();
					  //alert("in apply after submit");
					  //f_query_add_mod.location.reload();
					  //commontoolbarFrame.location.reload();
		            }
				 }//end checkRoleDuplicates
	     }//end of checkFields_For_No_Of_Verify2
	  }//end of checkFields_For_No_Of_Verify1
	 }//end of checkFields_For_Post_OP()
	}//end of checkFields_For_Pre_OP
  //}//end of else
}


function onSuccess()
{
	var formObj = document.forms[0];
	var params = formObj.params.value;
	//alert(params);

	if(f_query_add_mod.document.forms[0].mode.value=="insert")
		f_query_add_mod.location.href="../../eOT/jsp/SpecialitiesPrePostOperativeChecklistAddModify.jsp?"+params+"&mode=insert";
	else
         f_query_add_mod.location.reload();

}
/*
function reset()
{
	f_query_add_mod.document.forms[0].reset();
}
*/

function reset() {
	
if(window.parent.parent.frames[2].frames[1].document.location.href.indexOf("SpecialitiesPrePostOperativeChecklistAddModify.jsp") != -1){

	 if(f_query_add_mod.document.location.href.indexOf("SpecialitiesFrame.jsp") != -1)
		  return false;
	 else
		 f_query_add_mod.document.location.reload();
}else if(window.parent.parent.frames[2].frames[1].document.location.href.indexOf("SpecialitiesPrePostOperativeChecklistQueryCriteria.jsp") != -1)
	{
	 f_query_add_mod.document.forms[0].reset();
}
}
function query()
{
	//commontoolbarFrame.document.forms[0].apply.disabled=true; //Commented Against GHL-SCF-1519
	var formObj = document.forms[0];
	var params = formObj.params.value;
	f_query_add_mod.location.href="../../eOT/jsp/SpecialitiesPrePostOperativeChecklistQueryCriteria.jsp?"+params+"&mode=insert";
}
function setCheckValue()
{
	if(document.forms[0].status.checked==true)
		document.forms[0].status.value="E";
	else
		document.forms[0].status.value="D";
}
function setAnaestheiaYN()
{
	if(document.forms[0].anaesthesia_required_yn.checked==true)
	{
      document.forms[0].anaesthesia_required_yn.value="Y";
	}
	 else
	{
      document.forms[0].anaesthesia_required_yn.value="N";
    }
}

async function callPostOPChecklist_Code(obj,target)
{
	var retVal =    new String();
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var tit=getLabel("eOT.Checklist.Label","OT");
	var sql="SELECT DESCRIPTION DESCRIPTION, CHECKLIST_CODE CODE FROM OT_CHECKLIST_HDR WHERE NVL(STATUS,'E') = 'E' AND UPPER(DESCRIPTION) LIKE UPPER(?) AND UPPER(CHECKLIST_CODE) LIKE UPPER(?) ORDER BY 1";
	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,1";
	argumentArray[5] = target.value;
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = DESC_CODE;
	
	retVal = await CommonLookup( tit, argumentArray );
	if(retVal != null && retVal != "" )
	{
		var ret1=unescape(retVal);
		arr=ret1.split(",");
		obj.value = arr[0];
		target.value=arr[1];
			document.forms[0].no_of_verifications1.disabled=false;
			document.forms[0].img2.src="../../eCommon/images/mandatory.gif";
			//document.forms[0].no_of_verifications1.focus();
		}
	else
		{
			target.value="";
			obj.value="";
			document.forms[0].no_of_verifications1.disabled=true;
			document.forms[0].img2.src="../../eCommon/images/Blank1.gif";
		    document.forms[0].no_of_verifications1.value='';
			document.forms[0].generic_searchForRole5.disabled=true;
			document.forms[0].generic_searchForRole6.disabled=true;
			document.forms[0].generic_searchForRole7.disabled=true;
			document.forms[0].generic_searchForRole8.disabled=true;
			document.forms[0].role_desc5.disabled=true;
			document.forms[0].role_desc5.value='';
			document.forms[0].role_id5.value='';
			document.forms[0].role_desc6.disabled=true;
			document.forms[0].role_desc6.value='';
			document.forms[0].role_id6.value='';
			document.forms[0].role_desc7.disabled=true;
			document.forms[0].role_desc7.value='';
			document.forms[0].role_id7.value='';
			document.forms[0].role_desc8.disabled=true;
			document.forms[0].role_desc8.value='';
			document.forms[0].role_id8.value='';
		}		
}

function checkNull(retVal)
{
	if(retVal != null && retVal.length>0)		
		return retVal;
	else 
		return '';
}


async function callPreOPChecklist_Code(obj,target){
	var retVal =    new String();
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var tit=getLabel("eOT.Checklist.Label","OT");
	var sql="SELECT DESCRIPTION DESCRIPTION, CHECKLIST_CODE CODE FROM OT_CHECKLIST_HDR WHERE NVL(STATUS,'E') = 'E' AND UPPER(DESCRIPTION) LIKE UPPER(?) AND UPPER(CHECKLIST_CODE) LIKE UPPER(?) ORDER BY 1";
	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,1";
	argumentArray[5] = target.value;
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = DESC_CODE;
	
	retVal = await CommonLookup( tit, argumentArray );
	if(retVal != null && retVal != "" )
	{
		var ret1=unescape(retVal);
		arr=ret1.split(",");
		obj.value = arr[0];
		target.value=arr[1];
		document.forms[0].img1.src="../../eCommon/images/mandatory.gif";
		document.forms[0].no_of_verifications.disabled=false;
		//document.forms[0].no_of_verifications.focus();
	}else{
		target.value="";
		obj.value="";
		document.forms[0].img1.src="../../eCommon/images/Blank1.gif";
	    document.forms[0].no_of_verifications.disabled=true;
		document.forms[0].no_of_verifications.value='';
		document.forms[0].generic_searchForRole1.disabled=true;
		document.forms[0].generic_searchForRole2.disabled=true;
		document.forms[0].generic_searchForRole3.disabled=true;
		document.forms[0].generic_searchForRole4.disabled=true;
		document.forms[0].role_desc1.disabled=true;
		document.forms[0].role_desc1.value='';
		document.forms[0].role_id1.value='';
		document.forms[0].role_desc2.disabled=true;
		document.forms[0].role_desc2.value='';
		document.forms[0].role_id2.value='';
		document.forms[0].role_desc3.disabled=true;
		document.forms[0].role_desc3.value='';
		document.forms[0].role_id3.value='';
		document.forms[0].role_desc4.disabled=true;
		document.forms[0].role_desc4.value='';
		document.forms[0].role_id4.value='';
	}
}


async function callDialog(param)
{
	var dialogTop			= "40";
	var dialogHeight		= "10";
	var dialogWidth			= "40";
	var features			= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no";
	var arguments			= "";
	retVal=await window.showModalDialog("../../eOT/jsp/OTGeneralSearchFrames.jsp?"+param,arguments,features);
	return retVal;
}


async function callRole(obj,target){
	var retVal =    new String();
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var tit=getLabel("Common.Role.label","Common");
	var sql="SELECT ROLE_DESC DESCRIPTION,ROLE_ID CODE FROM OT_ROLES WHERE NVL(STATUS,'E') = 'E' AND UPPER(ROLE_DESC) LIKE UPPER(?) AND UPPER(ROLE_ID) LIKE UPPER(?) ORDER BY 1 ";
	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,1";
	argumentArray[5] = target.value;
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = DESC_CODE;
	
	retVal = await CommonLookup( tit, argumentArray );
	if(retVal != null && retVal != "" )
	{
		var ret1=unescape(retVal);
		arr=ret1.split(",");
		obj.value = arr[0];
		target.value=arr[1];
	}else{
		target.value="";
		obj.value="";
	}
}

 async function callSpeciality_Code(obj,target) {
	var locale = document.forms[0].locale.value;
	var retVal =    new String();
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var tit=getLabel("Common.speciality.label","Common");
    var	sql="SELECT LONG_DESC DESCRIPTION, SPECIALITY_CODE CODE FROM AM_SPECIALITY_LANG_VW WHERE LANGUAGE_ID='"+locale+"' AND EFF_STATUS = 'E' AND UPPER(LONG_DESC) LIKE UPPER(?) AND UPPER(SPECIALITY_CODE) LIKE UPPER(?) ORDER BY 1";
	
	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,1";
	argumentArray[5] = target.value;
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = DESC_CODE;
	retVal = await CommonLookup( tit, argumentArray );
	if(retVal != null && retVal != "" )
	{
		var ret1=unescape(retVal);
		arr=ret1.split(",");
		obj.value = arr[0];
		target.value=arr[1];
	}else{
		target.value="";
		obj.value="";
	}
 }

 async function callChartID(obj,target){
	var retVal =  new String();
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var tit=getLabel("Common.Chart.label","Common");
	
    var	sql="SELECT SHORT_DESC DESCRIPTION, CHART_ID CODE FROM CA_CHART WHERE EFF_STATUS = 'E' AND UPPER(LONG_DESC) LIKE UPPER(?) AND UPPER(CHART_ID) LIKE UPPER(?) ORDER BY 1";
	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,1";
	argumentArray[5] = target.value;
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = DESC_CODE;
		
	retVal = await CommonLookup( tit, argumentArray );
	
	if(retVal != null && retVal != "" )
	{
		var ret1=unescape(retVal);
		arr=ret1.split(",");
		obj.value = arr[0];
		target.value=arr[1];
	}else{
		target.value="";
		obj.value="";
	}
 }

  async function callSwabAndInstrID(obj,target)	{
	//var role_type=document.forms[0].role_type.value;
	//var tcode = obj.value;
	//var tdesc = target.value;
	//var oper_group_code=document.forms[0].speciality_desc.value;
	var retVal =    new String();
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	//var tit="Swab and Instrument Search" ;
	var tit=getLabel("eOT.SwabandInstrumentCount.Label","OT");
    var	sql="SELECT DESCRIPTION description, TEMPLATE_ID code FROM OT_SWAB_INSTR_TMPL_HDR WHERE NVL(STATUS,'E') = 'E' AND UPPER(DESCRIPTION) LIKE UPPER(?) AND UPPER(TEMPLATE_ID) LIKE UPPER(?)ORDER BY 1";
	
	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,1";
	argumentArray[5] = target.value;
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = DESC_CODE;
		
	retVal = await CommonLookup( tit, argumentArray );
	if(retVal != null && retVal != "" )
	{
		var ret1=unescape(retVal);
		arr=ret1.split(",");
		obj.value = arr[0];
		target.value=arr[1];
	}else{
		target.value="";
		obj.value="";
	}
 }



//Code testing for Medical servide Group by rajesh

async function callMedicalServiceGroup(obj,target)	{
	var locale = document.forms[0].locale.value;
	var retVal =    new String();
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	//var tit="Swab and Instrument Search" ;
	var tit=getLabel("eIP.MedicalServiceGroup.label","IP");
    var	sql="select MED_SER_GRP_CODE code, SHORT_DESC description from IP_MEDICAL_SERVICE_GRP_LANG_VW where language_id ='"+locale+"' and NVL(EFF_STATUS,'E')='E' AND UPPER(MED_SER_GRP_CODE) LIKE UPPER(?) AND UPPER(SHORT_DESC) LIKE UPPER(?)ORDER BY 1";
	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	//argumentArray[4] = "2,1";  Modified by Selvam for Lookup Issue
	argumentArray[4] = "1,2";
	argumentArray[5] = target.value;
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = DESC_CODE;
		
	retVal = await CommonLookup( tit, argumentArray );
	if(retVal != null && retVal != "" )
	{
		var ret1=unescape(retVal);
		arr=ret1.split(",");
		obj.value = arr[0];
		target.value=arr[1];
	}else{
		target.value="";
		obj.value="";
	}
 }

 //code ended here





 function retMsg(){

 }
// moved from jsp
//Rewrite by Bala 27/12/2006 This is for checking Pre/Post Operative Checklist Field as above function
function checkForPrePostChecklistField(obj1,flag){
	var formObj = document.forms[0];
	var img_obj = (flag=="PRE")?formObj.img1:formObj.img2;
	if(obj1.value==""){
		   img_obj.src="../../eCommon/images/Blank1.gif";
		   var k = (flag=="PRE")?1:5;
		   var len = (flag=="PRE")?4:8;
		    while(k<=len){
				eval("formObj.generic_searchForRole"+k).disabled=true;
				eval("formObj.role_desc"+k).value="";
				eval("formObj.role_desc"+k).disabled=true;
				eval("formObj.role_id"+k).value="";
				k++;
			}
	}
}


//Rewrite by Bala on 27/12/2006
//This function is invoked on blur of Pre/Post Operative Checklist Text Item.
// On Blur if the Pre/Post Operative Checklist Text Item is empty then select item is disabled.
function checkEmpty(obj,target){
	var formObj = document.forms[0];
	var code = formObj.pre_op_checklist_code;
	var code_1 = formObj.post_op_checklist_code;
	var desc = formObj.pre_op_checklist_desc;
	var desc_1 = formObj.post_op_checklist_desc;
	if(obj.value=='' || obj.value==null){
      target.value = "";
      target.disabled=true;
	  if(obj.name=='pre_op_checklist_desc'){
		    formObj.pre_op_checklist_code.value="";
			formObj.pre_op_no_of_verifications.value="";
			disableRole('PRE');
	  }else{
		    formObj.post_op_checklist_code.value="";
			formObj.post_op_no_of_verifications.value="";
			disableRole('POST');
	  }
	}else{
	  if(obj.name=="pre_op_checklist_desc"){
		callPreOPChecklist_Code(code,desc);
	  }else{
		callPostOPChecklist_Code(code_1,desc_1)
	  }
	  document.forms[0].target.disabled=true;
    }
}

function disableRole(flag){
	//Pre-operative checklist field starts from 1 - 4
	//Post-operative checklist field starts from 5 - 8
	//alert(flag);
	var formObj = document.forms[0];
	var img_obj = (flag=="PRE")?formObj.img1:formObj.img2;
	img_obj.src="../../eCommon/images/Blank1.gif";
	var len =(flag=="PRE")?4:8;
	var k = (flag=="PRE")?1:5;
	while(k<=len){
		eval("formObj.generic_searchForRole"+k).disabled=true;
		eval("formObj.role_desc"+k).disabled=true;
		eval("formObj.role_desc"+k).value="";
		eval("formObj.role_id"+k).value="";
		k++;
	}
}


//This function is invoked on change of select item.
//Based on the No. Of Verfictions from the select item the role fields & Lov's are enabled or disabled.

//Modified by Bala on 27/12/2006

function displayAppRole(obj,flag){
	//alert(flag);
	//Pre-operative checklist field starts from 1 - 4
	//Post-operative checklist field starts from 5 - 8
	var formObj = document.forms[0];
	var count = (obj.value=="")?0:parseInt(obj.value);
	var start = (flag=="PRE")?1:5;
	count = (flag=="PRE")?count:count+4;
	for(var j=start;j<=count;j++){
		//alert(eval("formObj.generic_searchForRole"+j).name);
		eval("formObj.generic_searchForRole"+j).disabled=false;
		eval("formObj.role_desc"+j).disabled=false;
	}
	disableOtherAppRole(count,flag);
	if(flag=="PRE")
		formObj.pre_op_no_of_verifications.value=obj.value;
	else
		formObj.post_op_no_of_verifications.value=obj.value;
	checkForPrePostChecklistField(obj,flag);
}

function disableOtherAppRole(val,flag){
	//Pre-operative checklist field starts from 1 - 4
	//Post-operative checklist field starts from 5 - 8
	var formObj = document.forms[0];
	var len =(flag=="PRE")?4:8;
	var k = parseInt(val)+1;
	while(k<=len){
		eval("formObj.generic_searchForRole"+k).disabled=true;
		eval("formObj.role_desc"+k).disabled=true;
		eval("formObj.role_desc"+k).value="";
		eval("formObj.role_id"+k).value="";
		k++;
	}
}

function checkRoleDuplicates(){
	var role_value=getLabel("Common.Role.label","Common");
	var formObj=f_query_add_mod.document.forms[0];
	var k=0;
	var err_txt="";
	var pre_post_flag="PRE";
	var dup_flag=false;
	if(pre_post_flag=="PRE"){
		var no_of_verifications = formObj.no_of_verifications.value;
		var i=1;
		var j=0;
		while(i<no_of_verifications && dup_flag==false){
			j=i+1;
			while(j<=no_of_verifications && dup_flag==false){
				if(eval("formObj.role_id"+i).value == eval("formObj.role_id"+j).value){
					err_txt=getMessage("DUPLICATE_CODE_EXISTS","Common")+":("+getLabel("eOT.PreOperativeCheckList.Label","OT")+" "+role_value+")";
					dup_flag=true;
				}
				j++;
			}
			i++;
		}
	}
	pre_post_flag="POST";	
	dup_flag=false;
	if(pre_post_flag=="POST"){
		var no_of_verifications = formObj.no_of_verifications1.value;
		var m=0;
		var n=0;
		var i=1;
		var j=0;
		while(i<no_of_verifications && dup_flag==false){
			m=i+4;
			j=i+1;
			while(j<=no_of_verifications && dup_flag==false){
				n=j+4;
				if(eval("formObj.role_id"+m).value == eval("formObj.role_id"+n).value){
					if(err_txt=="")
						err_txt=getMessage("DUPLICATE_CODE_EXISTS","Common")+":("+getLabel("eOT.PostOperativeCheckList.Label","OT")+" "+role_value+")";
					else							err_txt=err_txt+"<BR>"+getMessage("DUPLICATE_CODE_EXISTS","Common")+":("+getLabel("eOT.PostOperativeCheckList.Label","OT")+" "+role_value+")";
					dup_flag=true;
				}		
				j++;
			}
			i++;
		}
	}
	if(err_txt.length>0){
		window.parent.frames[2].frames[2].location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+err_txt;
		return false;
	 }else       
	  return true;
}
	
/* code for backup moved to a common function checkRoleDuplicates	
 function checkFor_Role_Duplications1(){
	var role_value=getLabel("Common.Role.label","Common");
	var and_value=" "+getLabel("Common.and.label","Common")+" ";
	var role_1 = role_value+" 1 ";
	var role_2 = role_value+" 2 ";
	var role_3 = role_value+" 3 ";
	var role_4 = role_value+" 4 ";
	var formObj=f_query_add_mod.document.forms[0];
	var role_id1 = formObj.role_id1.value;
	var role_id2 = formObj.role_id2.value;
	var role_id3 = formObj.role_id3.value;
	var role_id4 = formObj.role_id4.value;
	
    var err_txt="";
	if(formObj.pre_op_checklist_desc.value!=''){
	 if(formObj.no_of_verifications.value=='2'){
		if(formObj.role_id1.value==formObj.role_id2.value){
			//err_txt="Role 1 and 2 ";
		 err_txt=role_1+and_value+role_2;
		}
	 }else if (formObj.no_of_verifications.value=='3'){
		 //alert(role_id1+"@@"+role_id2+"@@"+role_id3+"@@"+role_id4)
		 if(role_id1.value==formObj.role_id2.value && role_id1.value==role_id3.value){
             //err_txt="Role 1, 2 and 3 ";
		    err_txt=err_txt=role_1+and_value+role_2+and_value+role_3;
		 }else{
			if(formObj.role_id1.value==formObj.role_id2.value){
				 //err_txt="Role 1 and 2 ";
			  err_txt+=role_1+and_value+role_2;
			}
			if(formObj.role_id1.value==formObj.role_id3.value){
			   //err_txt="Role 1 and 3 ";
			   err_txt+=role_1+and_value+role_3;

			}
			if(formObj.role_id2.value==formObj.role_id3.value){
			   //err_txt="Role 2 and 3 ";
			   err_txt+=role_2+and_value+role_3;
			}
		}
		
	 }else if (formObj.no_of_verifications.value=='4'){
		 if(formObj.role_id1.value==formObj.role_id2.value && formObj.role_id1.value==formObj.role_id3.value && formObj.role_id1.value==formObj.role_id4.value){
           //err_txt="Role 1, 2 , 3 and 4 ";
           err_txt=role_1+","+role_2+","+role_3+","+role_4;
		}else{

         if(formObj.role_id1.value==formObj.role_id2.value){
          // err_txt="Role 1 and 2 ";
		  err_txt=role_1+and_value+role_2;
		}
		if(formObj.role_id1.value==formObj.role_id3.value){
           //err_txt="Role 1 and 3 ";
		   err_txt+=role_1+and_value+role_3;
		}
		if(formObj.role_id1.value==formObj.role_id4.value){
           //err_txt="Role 1 and 4 ";
		   err_txt+=role_1+and_value+role_4;
		}
		if(formObj.role_id2.value==formObj.role_id3.value){
          // err_txt="Role 2 and 3 ";
		  err_txt+=role_2+and_value+role_3;
		}
		if(formObj.role_id2.value==formObj.role_id4.value){
			//err_txt="Role 2 and 4 ";
             err_txt+=role_2+and_value+role_4;
		}
		if(formObj.role_id3.value==formObj.role_id4.value){
           //err_txt="Role 3 and 4 ";
			err_txt+=role_3+and_value+role_4;
		}
		}
		
	 }
	}
	if(err_txt.length>0){
		
		window.parent.frames[1].frames[2].location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+getMessage("DUPLICATE_CODE_EXISTS","Common")+":"+err_txt+"("+getLabel("eOT.PreOperativeCheckList.Label","OT")+")";
		return false;
	 }else       
	  return true;
}



function checkFor_Role_Duplications2(){
	var and=" "+getLabel("Common.and.label","Common")+" ";
	var role = " "+getLabel("Common.Role.label","Common");
	var role_1 = role+" 1 ";
	var role_2 = role+" 2 ";
	var role_3 = role+" 3 ";
	var role_4 = role+" 4 ";
	var err_txt="";
	var formObj=f_query_add_mod.document.forms[0];
    if(formObj.post_op_checklist_desc.value!=''){
	 if(formObj.no_of_verifications1.value=='2'){
		if(formObj.role_id5.value==formObj.role_id6.value){
		 //err_txt="Role 1 and 2 ";
		 err_txt=role_1+and+role_2;
		}
	 }else if(formObj.no_of_verifications1.value=='3'){
		  if(formObj.role_id5.value==formObj.role_id6.value){
			//alert("R1&R2");
           //err_txt="Role 1 and 2 ";
		   err_txt=role_1+and+role_2;
		 }
		
		if(formObj.role_id5.value==formObj.role_id7.value){
           //err_txt="Role 1 and 3 ";
		   //alert("R1&R3");
		  err_txt+=role_1+and+role_3;
		}
		
		if(formObj.role_id6.value==formObj.role_id7.value){
           //err_txt="Role 2 and 3 ";
		    //alert("R2&R3");
		   err_txt+=role_2+and+role_3;
		}

		if(formObj.role_id5.value==formObj.role_id6.value && formObj.role_id5.value==formObj.role_id7.value){
           //err_txt="Role 1, 2 and 3 ";
		   err_txt=role_1+","+role_2+","+role_3;
		 }

	 }else if (formObj.no_of_verifications1.value=='4'){
		 //alert(formObj.role_id5.value+"@"+formObj.role_id6.value+"@"+formObj.role_id7.value+"@"+formObj.role_id8.value);   
		if(formObj.role_id5.value==formObj.role_id6.value){
          // err_txt="Role 1 and 2 ";
		  //alert("R1&R2")
		  err_txt+=role_1+and+role_2;
		 }
		if(formObj.role_id5.value==formObj.role_id7.value){
			//alert("R1&R3")
           //err_txt="Role 1 and 3 ";
		   err_txt+=role_1+and+role_3;
		}
		if(formObj.role_id5.value==formObj.role_id8.value){
          // err_txt="Role 1 and 4 ";
		  //alert("R1&R4")
		   err_txt+=role_1+and+role_4;
		}
		if(formObj.role_id6.value==formObj.role_id7.value){
           //err_txt="Role 2 and 3 ";
		   //alert("R2&R3")
		   err_txt+=err_txt=role_2+and+role_3
		}
		if(formObj.role_id6.value==formObj.role_id8.value){
          //err_txt="Role 2 and 4 ";
		  //alert("R2&R4")
           err_txt+=role_2+and+role_4
		}
		if(formObj.role_id7.value==formObj.role_id8.value){
			//err_txt="Role 3 and 4 ";
			//alert(formObj.role_id7.value+"@@"+formObj.role_id8.value);
		   //alert("R3&R4")
		  err_txt+=role_3+and+role_4
		}

		//err_txt="Role 1, 2 , 3";
		 if(formObj.role_id5.value==formObj.role_id6.value && formObj.role_id5.value==formObj.role_id7.value){
			 //alert("R1&R2&R3");
			  err_txt=role_1+","+role_2+","+role_3;
		}

		//err_txt="Role 1, 3 , 4";
		if(formObj.role_id7.value==formObj.role_id8.value && formObj.role_id8.value==formObj.role_id5.value){
			 //alert("R1&R3&R4");
			  err_txt=role_1+","+role_3+","+role_4;
		}
		
		//1,2,4
		if(formObj.role_id5.value==formObj.role_id6.value && formObj.role_id5.value==formObj.role_id8.value){
			 //alert("R1&R2&R4");
			  err_txt=role_1+","+role_2+","+role_4;
		}

		//2,3,4
		 if(formObj.role_id6.value==formObj.role_id7.value && formObj.role_id7.value==formObj.role_id8.value){
			 //alert("R2&R3&R4");
			  err_txt=role_2+","+role_3+","+role_4;
		}

		//1,2,3,4

		if(formObj.role_id5.value==formObj.role_id6.value && formObj.role_id5.value==formObj.role_id7.value && formObj.role_id5.value==formObj.role_id8.value){
           //err_txt="Role 1, 2 , 3 and 4 ";
		  // alert("R1R2R3R4");
           err_txt=role_1+","+role_2+","+role_3+","+role_4
		}
		   
	}
	if(err_txt.length>0){
		//window.parent.frames[1].frames[2].location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+err_txt+"For Post Operative Checklist Cannot Be Same";
		
		
		window.parent.frames[1].frames[2].location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+getMessage("DUPLICATE_CODE_EXISTS","Common")+":"+err_txt+"("+getLabel("eOT.PostOperativeCheckList.Label","OT")+")";
		return false;
	 }else       
	  return true;
	}	
}
*/
	
	
	
	
	
	
	
