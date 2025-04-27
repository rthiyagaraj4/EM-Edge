function query(){
	frames[1].location.href='../../eOA/jsp/WaitListMgmtCriteria.jsp';
	frames[2].location.href='../../eCommon/html/blank.html';
	frames[4].location.href='../../eCommon/jsp/error.jsp';
}


function enable_dis(obj){
	var selVal=obj.value;
	var locationType=document.forms[0].location.value;
	if (selVal!='' && locationType!='D')
	{ 
	 document.forms[0].practitioner_name.disabled=false;
     document.forms[0].search_pract.disabled=false;
	}else{

      document.forms[0].practitioner_name.disabled=true;
	  document.forms[0].search_pract.disabled=true;
	  
	}
document.forms[0].practitioner_name.value='';
document.forms[0].b_pract.value='';
parent.frames[1].document.getElementById("pract_type1").innerText="";		


}
function ensureSpl(obj){
var spl_code=document.forms[0].speciality.value;
if (obj.value!=""){
	
if (spl_code!=""){
populateLocation(obj);
//enable_dis1(obj);
}else{

	
 var error;
 error=getMessage("CAN_NOT_BE_BLANK","common");
 error=error.replace("$",getLabel("Common.speciality.label","Common"))
 alert(error);

//alert("APP-000001 Speciality Should Not be Blank...");
obj.options.selectedIndex=0;
}
}

}
function enable_dis1(obj){
document.forms[0].locationType.selectedIndex=0;
document.forms[0].resourceType.value='';
document.forms[0].practitioner_name.value='';
document.forms[0].b_pract.value='';
document.forms[0].practitioner_name.disabled=true;
document.forms[0].search_pract.disabled=true;
document.forms[0].resourceType.disabled=true;
document.getElementById("pract_type1").innerHTML="";
if (obj.value=='')
{
Obj=document.forms[0].locationType;
while(Obj.options.length >0 ) Obj.remove(Obj.options[0]);
opt=document.createElement('OPTION');
opt.value='';
opt.text="----"+getLabel("Common.defaultSelect.label","Common")+"----";
Obj.add(opt);
}
 parent.frames[2].location.href='../../eCommon/html/blank.html';
}
function enable_dis2(obj){
	var selVal=obj.value;
	if (selVal!='')
	{
		
	   document.forms[0].practitioner_name.disabled=false;
       document.forms[0].search_pract.disabled=false;

	}else{
		
		
		document.forms[0].practitioner_name.disabled=true;
        document.forms[0].search_pract.disabled=true;
	}

}

async function invoke_invitation()
{
	
		var retVal =    new String();
		//var dialogTop    = "77";
		var dialogLeft   = "0";
		//var dialogHeight= "31" ;
		//var dialogWidth = "50" ;
		var dialogTop    = "10px";
		var dialogHeight= "500px" ;
		var dialogWidth = "600px" ;
		var status = "no";
		var alcn_criteria=parent.frames[1].document.forms[0].ALCN_CRITERIA_YN.value;
		var prd=parent.frames[1].document.forms[0].prd.value;
		var curr_month=parent.frames[1].document.forms[0].curr_month.value;
		var old_date=parent.frames[1].document.forms[0].old_date.value;
		var argument;
		var calling_from = "";
		var features    = "dialogHeight:" + dialogHeight +";dialogWidth:" + dialogWidth +" ;dialogLeft:" +dialogLeft+ "; dialogTop:" +dialogTop+ "; scroll=no; status:" + status;
		
		retVal = await window.showModalDialog('../../eOA/jsp/InvitationStatus.jsp?alcn_criteria='+alcn_criteria+'&prd='+prd+'&curr_month='+curr_month+'&old_date='+old_date,arguments,features);	

}

function close_window()
{
//parent.window.close();
    const dialogTag = parent.parent.document.getElementById("dialog_tag");    
    dialogTag.close();
}

function clear_vals()
{
	if(document.forms[0].or_catalogue_desc.value=='')
	{
		document.forms[0].or_catalogue_code.value='';
	}else{
		callORSearch();
	}
		

}

async function callORSearch()
{

	var p_speciality_code=document.forms[0].speciality.value;	
	//var dialogHeight= "29" ;
	//var dialogTop = "125" ;
	//var dialogWidth	= "50" ;
	
	var dialogHeight= "400px" ;
	var dialogTop = "10px" ;
	var dialogWidth	= "700px" ;
	
	var status = "no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status  + "; dialogTop :" + dialogTop ;
	var or_catalogue_desc=document.forms[0].or_catalogue_desc.value;
	var url="../../eOR/jsp/RefusalOrderOrderableFrameSet.jsp?searchText="+escape(or_catalogue_desc)+"&called_from=OA&mode="+MODE_INSERT+"&p_speciality_code="+p_speciality_code+"&table_name='AM_CATALOG_FOR_SPECIALITY_VW'&order_category=&order_type=";
	var retVal = new String();
	retVal = await window.showModalDialog(url,arguments,features);

	if(retVal){
		var secArr=retVal.split("&");
		document.forms[0].or_catalogue_code.value=secArr[0];
		document.forms[0].or_catalogue_desc.value=secArr[1];
	}else{
		document.forms[0].or_catalogue_code.value='';
		document.forms[0].or_catalogue_desc.value='';
	}
}


function callResult()
{
	
	if(parent.frames[2].document.forms[0].Select.value==getLabel("Common.search.label","Common"))
	{
	
   parent.frames[3].location.href='../../eCommon/html/blank.html';
   specCode=parent.frames[1].document.forms[0].speciality.value;
   var order_by=parent.frames[1].document.forms[0].ORDER_BY_VAL.value;
   var order=parent.frames[1].document.forms[0].ORDER.value;
   parent.frames[1].document.forms[0].ORDER_BY_VAL.value="";
   parent.frames[1].document.forms[0].ORDER.value="";
	//var order_by='';
  //  var order='';

	

   var wait_list_status=parent.frames[1].document.forms[0].waitlst_status.value;
   var wait_list_priority=parent.frames[1].document.forms[0].priority.value;
   var install_yn=parent.frames[1].document.forms[0].install_yn.value;
   var or_catalogue_code="";
 
   if(parent.frames[1].document.forms[0].or_catalogue_code)
		{
   or_catalogue_code=parent.frames[1].document.forms[0].or_catalogue_code.value;
		}
   var walst_category_code=parent.frames[1].document.forms[0].walst_category_code.value;
   var elapsed=parent.frames[1].document.forms[0].elapswl.value;
   var ELAPSED_GRACE_PERIOD=parent.frames[1].document.forms[0].elapsed_grace_period.value;
   var alt_id1_no;
   var alt_id2_no;
   var alt_id3_no;
   var alt_id4_no;
   var alt_id1_type;
   var alt_id2_type;
   var alt_id3_type;
   var alt_id4_type;
   var other_alt_Id;
   var other_alt_type;
   var wtlt_category="";
	var m_town="";
	var r_town="";
	var m_region="";
	var r_region="";
	var m_area="";
	var r_area="";
	 var nat_id_code="";

   parent.frames[2].document.forms[0].Select.value=getLabel("Common.Collapse.label","Common");

   if (specCode!=''){
    WaitListNo = parent.frames[1].document.forms[0].WaitListNo.value ;
    patientid	= parent.frames[1].document.forms[0].patientid.value ;
	waitListfrmdate	= parent.frames[1].document.forms[0].frmDate.value ;
	waitListTodate	= parent.frames[1].document.forms[0].ToDate.value ;
	patientname	= parent.frames[1].document.forms[0].patientName.value ;
	gender		= parent.frames[1].document.forms[0].gender.value ;
	var val    = new Array() ;
			val = parent.frames[1].document.forms[0].locationType.value.split("$");
			
			
	if (val !=""){
	cliniccode = val[0].split("$");
	}else
  {
		cliniccode="";
	}
	practcode	= parent.frames[1].document.forms[0].b_pract.value ;
	wtlt_category_one= parent.frames[1].document.forms[0].walst_category_code.value ;
	if(parent.frames[1].document.forms[0].or_catalogue_code)
	   {
	wtlt_category= parent.frames[1].document.forms[0].or_catalogue_code.value ;
	   }
	priority= parent.frames[1].document.forms[0].priority.value;	


	var oper_stn_id=parent.frames[1].document.forms[0].oper_stn.value ;
	
		if( parent.frames[1].document.forms[0].national_id_no)
	   {
		var nat_id_no= parent.frames[1].document.forms[0].national_id_no.value;
	   }
	   if(parent.frames[1].document.forms[0].alt_id1_no)
	   {
		alt_id1_no= parent.frames[1].document.forms[0].alt_id1_no.value;
	   }else 
	   {
		   alt_id1_no="";
	   }
	   if(parent.frames[1].document.forms[0].alt_id1_type)
	   {
	   alt_id1_type= parent.frames[1].document.forms[0].alt_id1_type.value;
	   }else
	   {
		   alt_id1_type="";
	   }
	   if(parent.frames[1].document.forms[0].alt_id2_no)
	   {
	    alt_id2_no= parent.frames[1].document.forms[0].alt_id2_no.value;
	   }else
	   {
		   alt_id2_no="";
	   }
	   if(parent.frames[1].document.forms[0].alt_id2_type)
	   {
	   alt_id2_type= parent.frames[1].document.forms[0].alt_id2_type.value;
	   }else
	   {
		   alt_id2_type="";
	   }
	   if(parent.frames[1].document.forms[0].alt_id3_no)
	   {
	    alt_id3_no= parent.frames[1].document.forms[0].alt_id3_no.value;
	   }else
	   {
		   alt_id3_no="";
	   }
	   if(parent.frames[1].document.forms[0].alt_id3_type)
	   {
	     alt_id3_type= parent.frames[1].document.forms[0].alt_id3_type.value;
	   }else
	   {
		   alt_id3_type="";
	   }
	   if(parent.frames[1].document.forms[0].alt_id4_no)
	   {
	    alt_id4_no= parent.frames[1].document.forms[0].alt_id4_no.value;
	   }else
	   {
		   alt_id4_no="";
	   }
	   if(parent.frames[1].document.forms[0].alt_id4_type)
	   {
	    alt_id4_type= parent.frames[1].document.forms[0].alt_id4_type.value;
	   }else
	   {
		   alt_id4_type="";
	   }
	   if(parent.frames[1].document.forms[0].other_alt_Id)
	   {
	     other_alt_Id=parent.frames[1].document.forms[0].other_alt_Id.value;
	   }else
	   {
			other_alt_Id="";
	   }

	   if(parent.frames[1].document.forms[0].other_alt_type)
	   {
	 other_alt_type=parent.frames[1].document.forms[0].other_alt_type.value;
	   }else
	   {
		 other_alt_type="";
	   }
	if(parent.frames[1].document.forms[0].nat_id_code)
	   {
	      nat_id_code=parent.frames[1].document.forms[0].nat_id_code.value;
	   }
	if(parent.frames[1].document.forms[0].r_area)
	   {
		 r_area=parent.frames[1].document.forms[0].r_area.value;
	   }
	   if(parent.frames[1].document.forms[0].m_area)
	   {
		 m_area=parent.frames[1].document.forms[0].m_area.value;
	   }
	if(parent.frames[1].document.forms[0].r_region)
	   {
	 r_region=parent.frames[1].document.forms[0].r_region.value;
	   }

	if(parent.frames[1].document.forms[0].m_region)
	   {
	 m_region=parent.frames[1].document.forms[0].m_region.value;
	   }

	if(parent.frames[1].document.forms[0].r_town)
	   {
	 r_town=parent.frames[1].document.forms[0].r_town.value;
	   }

	if(parent.frames[1].document.forms[0].m_town)
	   {
	 m_town=parent.frames[1].document.forms[0].m_town.value;
	   }
		
		//parent.parent.frames[2].document.getElementById("invite_wait_list").rows="38,12.5%,4%,*,4%,9%";
		parent.parent.frames[2].document.getElementById("commontoolbarFrame").style.height="7vh";
		parent.parent.frames[2].document.getElementById("f_query_add_mod").style.height="15vh";
		parent.parent.frames[2].document.getElementById("search_collapse_frame").style.height="4vh";
		parent.parent.frames[2].document.getElementById("query_search_result").style.height="58vh";
		parent.parent.frames[2].document.getElementById("query_search_tabs").style.height="5vh";
		parent.parent.frames[2].document.getElementById("messageFrame").style.height="9vh";		
		var ALCN_CRITERIA_YN=parent.frames[1].document.forms[0].ALCN_CRITERIA_YN.value;
		var install_yn_ca=parent.frames[1].document.forms[0].install_yn_ca.value;
		var fac_id=parent.frames[1].document.forms[0].fac_id.value;
		var clinic_type=parent.frames[1].document.forms[0].location.value ;
		var res_type=parent.frames[1].document.forms[0].resourceType.value ;
		var elaspsed=parent.frames[1].document.forms[0].elapswl.value;
			var elapsed_grace_period=parent.frames[1].document.forms[0].elapsed_grace_period.value ;

		parent.frames[1].document.forms[0].fromSelect.value=getLabel("Common.from.label","Common")+""+getLabel("Common.defaultSelect.label","Common");
		var url='../../eOA/jsp/WaitListInvitationQueryResult.jsp?&flagSelect=fromSelect&patientid='+patientid+"&patientname="+patientname+"&gender="+gender+"&cliniccode="+cliniccode+"&practcode="+practcode+"&waitListfrmdate="+waitListfrmdate+"&waitListTodate="+waitListTodate+"&WaitListNo="+WaitListNo+"&oper_stn_id="+oper_stn_id+"&clinic_type="+clinic_type+"&res_type="+res_type+"&specCode="+specCode+"&elaspsed="+elaspsed+"&ALCN_CRITERIA_YN="+ALCN_CRITERIA_YN+"&elapsed_grace_period="+elapsed_grace_period+"&nat_id_no="+nat_id_no+"&alt_id1_no="+alt_id1_no+"&alt_id2_no="+alt_id2_no+"&alt_id3_no="+alt_id3_no+"&alt_id4_no="+alt_id4_no+"&other_alt_Id="+other_alt_Id+"&nat_id_code="+nat_id_code+"&r_area="+r_area+"		&m_area="+m_area+"&r_region="+r_region+"&m_region="+m_region+"&r_town="+r_town+"&m_town="+m_town+"&wtlt_category="+wtlt_category+"&wtlt_category_one="+wtlt_category_one+"&priority="+priority+"&wait_list_status="+wait_list_status+"&install_yn="+install_yn+"&install_yn_ca="+install_yn_ca+"&order="+order+"&order_by="+order_by;

		parent.frames[3].location.href = url;
		parent.frames[4].location.href='../../eOA/jsp/WaitListInvitationTabs.jsp?wait_list_status='+wait_list_status;
		parent.frames[5].location.href='../../eCommon/jsp/error.jsp';
			

   }else
	{
	    parent.frames[2].document.forms[0].Select.value=getLabel("Common.search.label","Common");
		
	
	   var error;
	   error=getMessage("CAN_NOT_BE_BLANK","common");
	   error=error.replace("$",getLabel("Common.speciality.label","Common"))
	   alert(error);
		//alert("APP-000001 Speciality Should Not Be Blank..");
	   parent.frames[4].location.href='../../eCommon/html/blank.html?wait_list_status='+wait_list_status;

	}
 
	}else
	{
			 parent.frames[2].document.forms[0].Select.value=getLabel("Common.search.label","Common");
			 //parent.parent.frames[2].document.getElementById("invite_wait_list").rows="38,50%,4%,*,4%,9%";
		parent.parent.frames[2].document.getElementById("commontoolbarFrame").style.height="7vh";
		parent.parent.frames[2].document.getElementById("f_query_add_mod").style.height="55vh";
		parent.parent.frames[2].document.getElementById("search_collapse_frame").style.height="4vh";
		parent.parent.frames[2].document.getElementById("query_search_result").style.height="21vh";
		parent.parent.frames[2].document.getElementById("query_search_tabs").style.height="4vh";
		parent.parent.frames[2].document.getElementById("messageFrame").style.height="9vh";	

	}
}

function reset(){
var function_id=frames[1].document.forms[0].function_id.value;
var function_id=frames[1].document.forms[0].function_id.value;	
var modify_wait_list_yn=frames[1].document.forms[0].modify_wait_list_yn.value;	
var currentdate=frames[1].document.forms[0].sys_date.value;	
var cancel_wait_list_yn=frames[1].document.forms[0].cancel_wait_list_yn.value;	
var oper_stn=frames[1].document.forms[0].oper_stn.value;	
var Patient_Id_Length=frames[1].document.forms[0].Patient_Id_Length.value;	
var install_yn=frames[1].document.forms[0].install_yn.value;	
	if(frames[1].document.forms[0].function_id.value=="WAIT_LIST_INVITATION")
	{
		

frames[3].location.href='../../eCommon/html/blank.html';
frames[5].location.href='../../eCommon/jsp/error.jsp';
frames[1].location.href="../../eOA/jsp/WaitListInvitationCriteria.jsp?function_id="+function_id+"&modify_wait_list_yn="+modify_wait_list_yn+"&cancel_wait_list_yn="+cancel_wait_list_yn+"&oper_stn_id="+oper_stn+"&currentdate="+currentdate+"&Patient_Id_Length="+Patient_Id_Length+"&install_yn="+install_yn;
frames[2].location.href='../../eOA/jsp/WaitListInvitationButtons.jsp';
	}else
	{
frames[3].location.href='../../eCommon/html/blank.html';
frames[4].location.href='../../eCommon/jsp/error.jsp';
frames[1].location.href="../../eOA/jsp/WaitListInvitationCriteria.jsp?function_id="+function_id+"&modify_wait_list_yn="+modify_wait_list_yn+"&cancel_wait_list_yn="+cancel_wait_list_yn+"&oper_stn_id="+oper_stn+"&currentdate="+currentdate+"&Patient_Id_Length="+Patient_Id_Length+"&install_yn="+install_yn;
frames[2].location.href='../../eOA/jsp/WaitListMgmtCriteria.jsp';

frames[1].document.getElementById("pract_type1").innerHTML="";
	}

}

function ClearForms(){
 parent.frames[2].document.forms[0].Select.value=getLabel("Common.search.label","Common");
 //parent.parent.frames[2].document.getElementById("invite_wait_list").rows="38,50%,4%,*,4%,9%";
		parent.parent.frames[2].document.getElementById("commontoolbarFrame").style.height="7vh";
		parent.parent.frames[2].document.getElementById("f_query_add_mod").style.height="55vh";
		parent.parent.frames[2].document.getElementById("search_collapse_frame").style.height="4vh";
		parent.parent.frames[2].document.getElementById("query_search_result").style.height="21vh";
		parent.parent.frames[2].document.getElementById("query_search_tabs").style.height="4vh";
		parent.parent.frames[2].document.getElementById("messageFrame").style.height="9vh";		
 parent.frames[3].location.href='../../eCommon/html/blank.html';
parent.frames[4].location.href='../../eCommon/html/blank.html';
parent.frames[5].location.href='../../eCommon/jsp/error.jsp';


}

function cancleWiatListappt(waitListNo){
var lbValue=waitListNo;
var reason=document.forms[0].reason_for_cancellation.value;
var tosubmit=true;

	if(document.forms[0].reason_for_cancellation.value =="")
	{
		
	    var error;
	    error=getMessage("CAN_NOT_BE_BLANK","common");
		error=error.replace("$",getLabel("Common.ReasonforCancellation.label","Common"))
		alert(error);
		//alert("cannot be blank");
		tosubmit=false;
	}

if (lbValue!=null && lbValue!='' ){
	if(tosubmit)
	{
	var HTML="<html><body onKeyDown = 'lockKey()'><form name='modifyWaitList' id='modifyWaitList' method='post'  action='../../eOA/jsp/ServerSideValidation.jsp'><input type=hidden name='from' id='from' value='WaitListMgmtCancel'><input type=hidden name='LBoxValue' id='LBoxValue' value='"+lbValue+"'><input type='hidden' name='reason_code' id='reason_code' value='"+reason+"'></form></body></html>";
	parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTML);
	parent.messageFrame.document.modifyWaitList.submit();

	}
	

}
}
function elapswlClick(Obj){
	if (Obj.checked==true)
	{
	 Obj.value='Y';
	 
	}else{
	 Obj.value='N';
	 
	}

}

function checkColon(dt){
	
 var dtArr=dt.split(' ');
 time=dtArr[1];
 charAtpos3=time.charAt(2);
 
 if (charAtpos3 == ':')
   return true;
	 else
   return false;
 
}
function validatePrefDate(obj){
	if (obj.value!=''&& obj.value!=null){
		
		
		if(checkDt(obj.value)){
curDt= new Date();
var from = curDt.getDate()+"/"+(curDt.getMonth()+1)+"/"+curDt.getFullYear();
var to=obj.value;

var fromarray; var toarray;

    var fromdate = from ;
    var todate = to ;
	
	
            fromarray = fromdate.split("/");
            toarray = todate.split("/");
			
            var fromdt = new Date(fromarray[2],fromarray[1]-1,fromarray[0]);
            var todt = new Date(toarray[2],toarray[1]-1,toarray[0]);
				
            if(Date.parse(todt) < Date.parse(fromdt)) {
				
				alert(getMessage("PRF_DATE_NOT_GR_CURR_DATE","Common"));
				obj.focus();
				
                return false;
            }
            else if(Date.parse(todt) >= Date.parse(fromdt)) return true;
    
return true;
		}else
		{
alert(getMessage("INVALID_DATE_FMT","SM"));
 obj.value='';
 obj.focus();
		}
	}

}
/*
function modifyWiatListappt(){  
waitListNo=document.forms[0].waitlist_no.value;
preferredDate=document.forms[0].preferred_date.value;
status=document.forms[0].status.value;
clinicCode=document.forms[0].clinicDesc.value;
clinicCode = clinicCode.substring(1,clinicCode.length);
resourceid=document.forms[0].b_pract.value;
resource=document.forms[0].rsClass.value;
elapsed=document.forms[0].elapsed.value;
var category=document.forms[0].or_catalogue_code.value;

var lbValue=waitListNo;
var msg='';
var flag=0;
var err='';

if (preferredDate==null || preferredDate==''){
	flag=1;
	
	err+=getMessage("CAN_NOT_BE_BLANK","common")+"\n";
	msg+=err.replace("$",getLabel("Common.PreferredDate.label","Common"))

	//msg='APP-000001 Preferred Date cannot be blank...\n';
}
if(status==null || status==''){
	flag=1;
	
	err+=getMessage("CAN_NOT_BE_BLANK","common");
	msg+=err.replace("$",getLabel("Common.status.label","Common"))
	
	//msg+='APP-000001 Status cannot be blank...';
}
alert(lbValue);

if (flag==0){
alert(lbValue);
if (lbValue!=null && lbValue!=''){
//var HTML="<html><body onKeyDown = 'lockKey()'><form name='modifyWaitList' id='modifyWaitList' method='post'  action='../../eOA/jsp/ServerSideValidation.jsp'><input type=hidden name='from' id='from' value='WaitListMgmtModify'><input type=hidden name='LBoxValue' id='LBoxValue' value='"+lbValue+"'><input type=hidden name='preferredDate' id='preferredDate' value='"+preferredDate+"'><input type=hidden name='status' id='status' value='"+status+"'><input type=hidden name='clinicCode' id='clinicCode' value='"+clinicCode+"'><input type=hidden name='resourceid' id='resourceid' value='"+resourceid+"'><input type=hidden name='resource' id='resource' value='"+resource+"'><input type=hidden name='elapsed' id='elapsed' value='"+elapsed+"'><input type='hidden' name='odrer_category' id='odrer_category' value='"+category+"'></form></body></html>";
//parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTML);
//parent.messageFrame.document.modifyWaitList.submit();

}
}
else{
	alert(msg);
	if (preferredDate=='')
	{
		document.forms[0].preferred_date.focus();
	}else
		document.forms[0].status.focus();
}
}
*/
function validate_date(ref) {
                
        var error_id;    
	if(ref == "FROM_DATE_LESS_SYSDATE" )
	{
	    from = parent.frames[1].document.forms[0].frmDate;
	    to = parent.frames[1].document.forms[0].sys_date;
	    error_id = getMessage('FROM_DATE_LESS_SYSDATE','SM');
	    	    	    		
	}
	else if(ref == "TO_DT_GR_EQ_FM_DT")
	{
	  from = parent.frames[1].document.forms[0].ToDate;
	  to = parent.frames[1].document.forms[0].frmDate;
	  error_id = getMessage('TO_DT_GR_EQ_FM_DT','SM');
	 	 
	}
	else if(ref == "TO_DATE_LESS_FROM")
	{
	  from = parent.frames[1].document.forms[0].ToDate;
	  to = parent.frames[1].document.forms[0].frmDate;
	  error_id = getMessage('TO_DT_GR_EQ_FM_DT','SM');
	}
	var fromarray;
	var toarray;
	var fromdate = eval(from).value ;
	var todate = eval(to).value ;
	
	if(fromdate.length > 0 && todate.length > 0 ) {
		fromarray = fromdate.split("/");
		toarray = todate.split("/");
		var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
		var todt = new Date(toarray[2],toarray[1],toarray[0]);
		if(Date.parse(todt) > Date.parse(fromdt)) {
		   
		   parent.messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num="+ error_id;
		   from.focus();
		}
		else if(Date.parse(todt) <= Date.parse(fromdt))
		     {
		       parent.messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num= ";
		       return true;
		      } 
	}
	return true;
}

function dispPrimaryResource(){
//document.forms[0].practitioner_name.value='';
document.getElementById("pract_type1").innerHTML="";
clinicCode=document.forms[0].locationType.value;
clinicCode = clinicCode.substring(1,clinicCode.length);
locn_type=document.forms[0].location.value;

//resource=document.forms[0].rsClass.value;
var lbValue="";
if (clinicCode!=''){
if ( locn_type!='N'){

var HTML="<html><body onKeyDown = 'lockKey()'><form name='modifyWaitList' id='modifyWaitList' method='post'  action='../../eOA/jsp/ServerSideValidation.jsp'><input type=hidden name='from' id='from' value='WaitListMgmtModifyWindow'><input type=hidden name='LBoxValue' id='LBoxValue' value='"+lbValue+"'><input type=hidden name='clinicCode' id='clinicCode' value='"+clinicCode+"'><input type=hidden name='locn_type' id='locn_type' value='"+locn_type+"'></form></body></html>";
parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTML);
parent.messageFrame.document.modifyWaitList.submit();
}
/*else if (locn_type=='D') {
	parent.frames[1].document.forms[0].resource.value="B";
	parent.frames[1].document.getElementById("pract_type1").innerHTML="Bed"
}
*/else if (locn_type=='N') {
parent.frames[1].document.forms[0].resourceType.value="P";
parent.frames[1].document.getElementById("pract_type1").innerHTML=getLabel("Common.practitioner.label","Common");
}
}

}






function getFocus()
{
	document.forms[0].speciality.focus();
		document.forms[0].frmDate.disabled=true;
		document.getElementById("img1").disabled=true;
		document.forms[0].ToDate.disabled=true;
		document.getElementById("img2").disabled=true;
}



function selectAll_S(obj,start,end){
	len=document.getElementById("check_box").length;

		if (obj.checked){
			//parent.frames[1].document.forms[0].fromSelect.value="fromSelect1";
			for(var i=start;i<=end;i++)
		{
			if(eval("document.forms[0].checkBox"+i))
			eval("document.forms[0].checkBox"+i).checked=true;
		}
		}else{
			//parent.frames[1].document.forms[0].fromSelect.value="fromSelect";
			for(var i=start;i<=end;i++)
		{
			if(eval("document.forms[0].checkBox"+i))
			eval("document.forms[0].checkBox"+i).checked=false;
		}

		var xmlDoc = ""
		var xmlHttp = new XMLHttpRequest()
		xmlStr ="<root><SEARCH steps='clearAll' /></root>"
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
		xmlHttp.open("POST","ServerSide.jsp",false)
		xmlHttp.send(xmlDoc)
		responseText=xmlHttp.responseText
		responseText = trimString(responseText)
		eval(responseText)
		}
	
}

/*function chkForSelectAll(start,end){
	len=document.getElementById('check_box').length;

			for(var i=start;i<=end;i++)
		{
				
			if(eval("document.forms[0].checkBox"+i))
			{
			if(eval("document.forms[0].dummyCheckedValue"+i).value !="Y")
			{
			eval("document.forms[0].checkBox"+i).checked=false;
			}else
			{
				eval("document.forms[0].checkBox"+i).checked=true;
			}
			}
		}
		
}*/
function chkForSelectAll(start, end) {
    const form = document.forms[0];

    for (let i = start; i <= end; i++) {
        const checkBox = form.querySelector(`[name="checkBox${i}"]`);
        const dummyCheckedValue = form.querySelector(`[name="dummyCheckedValue${i}"]`);

        if (checkBox && dummyCheckedValue) {
            checkBox.checked = (dummyCheckedValue.value === "Y");
        }
    }
}


function checkBoxOnClick(obj,waitListNo,preferedDate,i){
	var submit=true;
	if(obj.checked==false){
		//eval("document.forms[0].status_val"+i).disabled=true;
		document.getElementById('status_val'+i).value="";
		document.getElementById('checkBox'+i).value="N";
		document.getElementById('remove_Code'+i).value = "Y";
		document.getElementById('invitation_date'+i).value = "";
		
		
	}else{
		document.getElementById('status_val'+i).disabled=false;
		//eval("document.forms[0].status_val"+i).focus();
		document.getElementById('remove_Code'+i).value = "N";
		
	}
	/*if(obj.checked == false)
		eval("document.forms[0].remove_Code"+i).value = "Y";
	else
		eval("document.forms[0].remove_Code"+i).value = "N";*/

		

}


function clear_val_tabs()
{
	
	parent.frames[2].location.href='../../eOA/jsp/WaitListInvitationButtons.jsp';
	parent.frames[3].location.href='../../eCommon/html/blank.html';
}

function apply()
{
	invite_values();
}
function invite_values(){
	var sel="N";
	var wait_list_ret_str="";
	var wait_list_rec_status="";
	var date_list_ret_str="";
	var next_str="";
	var tosubmit=true;
	var tosubmit1=true;
	var status_flag="";
	var chkCond=false;
	if(parent.parent.frames[2].frames[3].document.forms[0])
		var maxRecord=parent.parent.frames[2].frames[3].document.forms[0].maxrecord.value;
	var bool=true;
	
	for(var i=1;i<=maxRecord;i++){
		
		if(eval("parent.parent.frames[2].frames[3].document.forms[0].checkBox"+i)){
			
			if(eval("parent.parent.frames[2].frames[3].document.forms[0].checkBox"+i).checked==true){
				if(eval("parent.parent.frames[2].frames[3].document.forms[0].status_val"+i).value!=""){
				//	eval("parent.parent.frames[2].frames[3].document.forms[0].remove_Code"+i).value='Y';
					bool=true;
				}
				else{
					bool=false;
					break;
				}
			}
		}
	}
	if(bool==true){
		if(parent.parent.frames[2].frames[3].document.forms[0]){
			var from=parent.parent.frames[2].frames[3].document.forms[0].from.value
				var to=parent.parent.frames[2].frames[3].document.forms[0].to.value
			
			parent.parent.frames[2].frames[3].document.forms[0].action="../../servlet/eOA.AppointmentWtListServlet";
			parent.parent.frames[2].frames[3].document.forms[0].target="messageFrame";
			parent.parent.frames[2].frames[3].document.forms[0].submit();
	
	
		}else{
			parent.parent.frames[2].frames[5].document.location.href="../../eCommon/jsp/error.jsp?err_num=";
		}
	}else{
		alert(getMessage("WAITLIST_CANNOT_BLANK","OA"));
		parent.parent.frames[2].frames[5].document.location.href="../../eCommon/jsp/error.jsp?err_num=";
	}
}



function clear_value(obj,chkbox)
{
	/*if(obj.value=='')
	{
		chkbox.checked=false;
	}else
	{
			tosubmit =true;
			chkbox.checked=true;
	}*/
	
}


function OnSuccess(obj)
{
	var error_id="";
	if(obj=="true")
	{
	 error_id=encodeURIComponent(getMessage("RECORD_INSERTED","SM"));
		//parent.parent.frames[2].document.getElementById("invite_wait_list").rows="38,50%,*,4%,9%,9%";
		parent.parent.frames[2].document.getElementById("commontoolbarFrame").style.height="7vh";
		parent.parent.frames[2].document.getElementById("f_query_add_mod").style.height="55vh";
		parent.parent.frames[2].document.getElementById("search_collapse_frame").style.height="4vh";
		parent.parent.frames[2].document.getElementById("query_search_result").style.height="21vh";
		parent.parent.frames[2].document.getElementById("query_search_tabs").style.height="4vh";
		parent.parent.frames[2].document.getElementById("messageFrame").style.height="9vh";	
	parent.frames[2].location.href='../eOA/jsp/WaitListInvitationButtons.jsp';
	parent.frames[3].location.href='../eCommon/html/blank.html';
	parent.frames[4].location.href='../eCommon/html/blank.html';
	parent.messageFrame.document.location.href="../eCommon/jsp/error.jsp?err_num="+ error_id;
	}else if(obj=="false")
	{
	error_id=encodeURIComponent(getMessage("NO_RECORD_INSERTION","OA"));
		//parent.parent.frames[2].document.getElementById("invite_wait_list").rows="38,50%,*,4%,9%,9%";
		parent.parent.frames[2].document.getElementById("commontoolbarFrame").style.height="7vh";
		parent.parent.frames[2].document.getElementById("f_query_add_mod").style.height="55vh";
		parent.parent.frames[2].document.getElementById("search_collapse_frame").style.height="4vh";
		parent.parent.frames[2].document.getElementById("query_search_result").style.height="21vh";
		parent.parent.frames[2].document.getElementById("query_search_tabs").style.height="4vh";
		parent.parent.frames[2].document.getElementById("messageFrame").style.height="9vh";	
	parent.frames[2].location.href='../eOA/jsp/WaitListInvitationButtons.jsp';
	parent.frames[3].location.href='../eCommon/html/blank.html';
	parent.frames[4].location.href='../eCommon/html/blank.html';
	parent.messageFrame.document.location.href="../eCommon/jsp/error.jsp?err_num="+ error_id;
	}else if (obj=="status_chk")
	{
	error_id=encodeURIComponent(getMessage("WAITLIST_CANNOT_BLANK","OA"));
	parent.messageFrame.document.location.href="../eCommon/jsp/error.jsp?err_num="+ error_id;
	}

}

async function show_CancelWin(waitListNo) 
{
	/*var flag=window.confirm("APP-OA0173 Do you want to Cancel the Wait List");
	if (flag){		
		cancleWiatListappt(waitListNo);
	}*/


	
	var oper_stn_id=document.forms[0].oper_stn_id.value;
	var ALCN_CRITERIA_YN=document.forms[0].ALCN_CRITERIA_YN.value;
	var elapsed=parent.frames[1].document.forms[0].elapswl.value;
	var dialogHeight= "20" ;

	var dialogTop = "75" ;
	var dialogWidth	= "50" ;
	var status = "no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status  + "; dialogTop :" + dialogTop ;
	
	var callurl="../../eOA/jsp/WaitListCancelFrame.jsp?waitlist_no="+waitListNo+"&oper_stn_id="+oper_stn_id+"&ALCN_CRITERIA_YN="+ALCN_CRITERIA_YN+"&elapsed="+elapsed;
	var retVal = new String();
	retVal = await window.showModalDialog(callurl,arguments,features);
	callResult();
}

function callMouseOver(obj)
{
	currClass = obj.className ;
	obj.className = 'OASUSPENDED';
}

function callOnMouseOut(obj)
{
	obj.className = currClass; 
}

function hideToolTip()
{
	document.getElementById("tooltiplayer").style.visibility = 'hidden'
}

async function show_TransferWin(waitListNo,patientId,preferedDate,speciality,careLocnTypeInd,clinicCode,resClass,resourceId)
{ 
		if(waitListNo=='*') waitListNo='';
		if(patientId=='*') patientId='';
		if(preferedDate=='*') preferedDate='';
		if(speciality=='*') speciality='';
		if(careLocnTypeInd=='*') careLocnTypeInd='';
		if(clinicCode=='*') clinicCode='';
		if(resClass=='*') resClass='';
		if(resourceId=='*') resourceId='';
	
		if(careLocnTypeInd!='N')
		{

				var retVal = 	new String();
				var dialogHeight = "32" ;
				var dialogWidth  = "50" ;
				var dialogTop    = "108";
				var dialogLeft   = "0";
			
				var features     = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" +dialogLeft+ "; dialogTop:" +dialogTop+ "; status=no" ;
				var arguments    = "" ;		

				var url="../../eOA/jsp/CAOAAppointment.jsp?i_practitioner_id="+resourceId+"&patient_id=&i_clinic_code="+clinicCode+"&recall_date="+preferedDate+"&locn_type="+careLocnTypeInd+"&specialty_code="+speciality+"&callingMode=OP&	waitListNo="+waitListNo+"&resource_class="+resClass+"&from_wait_list=Y&clinic_code="+clinicCode+"&from_AE=N&care_locn_ind="+careLocnTypeInd;

			
				retVal 	 	 = await window.showModalDialog(url,arguments,features);
				if (retVal != null)
				{
						var returnVal = retVal.split("^");
						var mode = returnVal[0];
						h = returnVal[1];
						
					if (mode=="1")
					{
						h=h+ "&title="+encodeURIComponent(getLabel("Common.bookappointment.label","Common"));
						features     = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" +dialogLeft+ "; dialogTop:" +dialogTop+ "; status=no" ;
						arguments    = "" ;	
						retVal = await window.showModalDialog("../../eOA/jsp/SinglePractVwNew.jsp?"+h,arguments,features);
					}else if (mode=="2")
					{
							h=h+ "&title="+encodeURIComponent(getLabel("Common.bookappointment.label","Common"));
							features     = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" +dialogLeft+ "; dialogTop:" +dialogTop+ "; status=no" ;
							arguments    = "" ;	
							retVal = await window.showModalDialog("../../eOA/jsp/MultiPract2VwMain.jsp?"+h,arguments,features);
						
					}else if (mode=="3")
					{
							h=h+ "&title="+encodeURIComponent(getLabel("Common.bookappointment.label","Common"));
							features     = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" +dialogLeft+ "; dialogTop:" +dialogTop+ "; status=no" ;
							arguments    = "" ;	
							retVal = await window.showModalDialog("../../eOA/jsp/MultiPract3VwMain.jsp?"+h,arguments,features);
								
						}
							if(retVal=='OP'){
							show_TransferWin(waitListNo,patientId,preferedDate,speciality,careLocnTypeInd,clinicCode,resClass,resourceId)

						}else{
							
							callResult();
							clear_session();
							}
					}else{
						clear_session();
					 }
			}else{ // call IP 
				var retVal="";
				var dialogHeight= "36" ;
				var dialogTop	 = "125";
				var dialogWidth	= "50" ;
				var status		= "no";
				var features     = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" +dialogLeft+ "; dialogTop:" +dialogTop+ "; status=no" ;
				var arguments    = "" ;	

				var url="../../eIP/jsp/Booking.jsp?is_oa_yn=Y&wait_lst_ref_no="+waitListNo+"&oa_pref_date_time="+escape(preferedDate)+"&oa_patient_id="+patientId;

				retVal 	 	 = await window.showModalDialog(url,arguments,features);
			}
	}

function clear_session()
{
	var xmlDoc = ""
	var xmlHttp = new XMLHttpRequest()
	xmlStr ="<root><SEARCH steps='CLR_SESSION' /></root>"
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
	xmlHttp.open("POST","ServerSide.jsp",false)
	xmlHttp.send(xmlDoc)
	responseText=xmlHttp.responseText
	responseText = trimString(responseText)
	eval(responseText)
}
	
function callDummy()
{
}

function chk_open_elap(obj)
{
	var open_elap=obj.value;
	if(obj.value =='O')
	{
		document.forms[0].frmDate.disabled=false;
		document.getElementById("img1").disabled=false;
		document.forms[0].ToDate.disabled=false;
		document.getElementById("img2").disabled=false;

	}else if(obj.value =='E')
	{
		document.forms[0].open_elap_val.value=obj.value;

	}
parent.frames[3].location.href='../../eCommon/html/blank.html';
}


function displayToolTip(waitListNo,patientId,preferedDate,resourceClass,resource,careLocnTypeInd,clinicCode,resourceId,specialityCode,resClass) 
{    
		if (waitListNo=='') waitListNo='*';
		if (patientId=='') patientId='*';
		if (preferedDate=='') preferedDate='*';
		if (resourceClass=='') resourceClass='*';
		if (resource=='') resource='*';
		if (careLocnTypeInd=='') careLocnTypeInd ='*';
		if (clinicCode=='') clinicCode='*';
		if (resourceId=='') resourceId='*';
		if (specialityCode=='') specialityCode='*';
		if (resClass=='') resClass='*';


		buildTable(waitListNo,patientId,preferedDate,resourceClass,resource,careLocnTypeInd,clinicCode,resourceId,specialityCode,resClass) 
		bodwidth  = parent.parent.frames[1].document.body.offsetWidth
		bodheight = parent.parent.frames[1].document.body.offsetHeight
		//Modified against INC:49319
		var x 	  = event.clientX
		var y 	  = event.clientY;
		
		x 	  = x + (document.getElementById("tooltiplayer").offsetWidth)
		y 	  = y + (document.getElementById("tooltiplayer").offsetHeight)

		if(x<bodwidth)
			x = event.clientX 
		else
			x = x - (document.getElementById("tooltiplayer").offsetWidth*2)
		if(y<bodheight)
			y = event.clientY
		else
			y = y - (document.getElementById("tooltiplayer").offsetHeight*2)
				
		y+=document.body.scrollTop
		x+=document.body.scrollLeft
			
		document.getElementById("tooltiplayer").style.posLeft= x
		document.getElementById("tooltiplayer").style.posTop = y
		document.getElementById("tooltiplayer").style.visibility='visible' 
}

function buildTable(waitListNo,patientId,preferedDate,resourceClass,resource,careLocnTypeInd,clinicCode,resourceId,specialityCode,resCalss)
{ 
	var tab_dat  = "<table id='tooltiptable1' cellpadding=0 cellspacing=0 border='0'   class='BOX' width='100%' height='100%' align='center'>"
	tab_dat     += "<tr>";
	tab_dat     += "<td class = 'PATTOOLTIPS' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'><a href=javascript:show_CancelWin('"+waitListNo+"')>"+getLabel("Common.CancelWaitList.label","Common")+"</a></td>";		
	tab_dat     += "</tr>";
	tab_dat     += "<tr>";
	tab_dat     += "<td class = 'PATTOOLTIPS' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'><a href=javascript:show_ModifyWin('"+waitListNo+"','N')>"+getLabel("Common.ModifyWaitList.label","Common")+"</a></td>";		
	tab_dat     += "</tr>";
	tab_dat += "<tr><td class = 'PATTOOLTIPS' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'><a href=javascript:show_TransferWin('"+waitListNo+"','"+patientId+"','"+preferedDate+"','"+specialityCode+"','"+careLocnTypeInd+"','"+clinicCode+"','"+resCalss+"','"+resourceId+"')>"+getLabel("Common.create.label","Common")+" "+getLabel("Common.booking.label","Common")+"</a></td>";		
	tab_dat     += "</tr>";
	tab_dat     += "</table>";
	document.getElementById("t").innerHTML = tab_dat;
	
}

function scrollTitle()
{

  var x = document.body.scrollTop;
  var x1=document.getElementById("divTitleTable").style.posTop;

  if(x == 0){
	 
   document.getElementById("divTitleTable").style.position='static';
   document.getElementById("divTitleTable").style.posTop  = 0;
  

  }else{
	  if(document.forms[0].maxrecord.value <=12)
	  {
	document.getElementById("divTitleTable").style.position = 'relative';
	document.getElementById("divTitleTable").style.posTop  = x-2;
	  }else
	  {
		document.getElementById("divTitleTable").style.position = 'relative';
		document.getElementById("divTitleTable").style.posTop  = x-20;
	  }
	/*document.getElementById("head2").style.position = 'relative';
	document.getElementById("head2").style.posTop  = x-18;
	document.getElementById("head3").style.position = 'relative';
	document.getElementById("head3").style.posTop  = x-18;
	document.getElementById("head4").style.position = 'relative';
	document.getElementById("head4").style.posTop  = x-18;
	document.getElementById("head5").style.position = 'relative';
	document.getElementById("head5").style.posTop  = x-18;
	document.getElementById("head6").style.position = 'relative';
	document.getElementById("head6").style.posTop  = x-18;
	document.getElementById("head7").style.position = 'relative';
	document.getElementById("head7").style.posTop  = x-18;
	document.getElementById("head8").style.position = 'relative';
	document.getElementById("head8").style.posTop  = x-18;
	document.getElementById("head9").style.position = 'relative';
	document.getElementById("head9").style.posTop  = x-18;
	document.getElementById("head10").style.position = 'relative';
	document.getElementById("head10").style.posTop  = x-18;
	document.getElementById("head11").style.position = 'relative';
	document.getElementById("head11").style.posTop  = x-18;
    document.getElementById("head12").style.position = 'relative';
	document.getElementById("head12").style.posTop  = x-18;*/
  }

}


function scrollTitle2()
{

  var x = document.body.scrollTop;

  if(x == 0){
	 
   document.getElementById("head1").style.position='static';
   document.getElementById("head1").style.posTop  = 0;
   document.getElementById("head2").style.position='static';
   document.getElementById("head2").style.posTop  = 0;
   document.getElementById("head3").style.position='static';
   document.getElementById("head3").style.posTop  = 0;
   document.getElementById("head4").style.position='static';
   document.getElementById("head4").style.posTop  = 0;
   document.getElementById("head5").style.position='static';
   document.getElementById("head5").style.posTop  = 0;
   document.getElementById("head6").style.position='static';
   document.getElementById("head6").style.posTop  = 0;
   document.getElementById("head7").style.position='static';
   document.getElementById("head7").style.posTop  = 0;
   document.getElementById("head8").style.position='static';
   document.getElementById("head8").style.posTop  = 0;
   document.getElementById("head9").style.position='static';
   document.getElementById("head9").style.posTop  = 0;
  
  }else{
	document.getElementById("head1").style.position = 'relative';
	document.getElementById("head1").style.posTop  = x-2;
	document.getElementById("head2").style.position = 'relative';
	document.getElementById("head2").style.posTop  = x-2;
	document.getElementById("head3").style.position = 'relative';
	document.getElementById("head3").style.posTop  = x-2;
	document.getElementById("head4").style.position = 'relative';
	document.getElementById("head4").style.posTop  = x-2;
	document.getElementById("head5").style.position = 'relative';
	document.getElementById("head5").style.posTop  = x-2;
	document.getElementById("head6").style.position = 'relative';
	document.getElementById("head6").style.posTop  = x-2;
	document.getElementById("head7").style.position = 'relative';
	document.getElementById("head7").style.posTop  = x-2;
	document.getElementById("head8").style.position = 'relative';
	document.getElementById("head8").style.posTop  = x-2;
	document.getElementById("head9").style.position = 'relative';
	document.getElementById("head9").style.posTop  = x-2;
  }

}

function callPatientSearch(){
 var patientId=PatientSearch();
 if (patientId!=null && patientId!='')
  document.forms[0].patientid.value=patientId;
}


async function Modal_Contact_Details(obj)
{

		var retVal =    new String();
		var dialogHeight= "23" ;
		var dialogWidth = "39" ;
		var status = "no";
		
		concat_address_hidden=document.forms[0].concat_address_hidden.value;
		var arguments	=concat_address_hidden;
		var calling_from = "";
		var features    = "dialogHeight:" + dialogHeight +";dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
		
		retVal = await window.showModalDialog("../../eMP/jsp/ContactDetailsFrame.jsp?readonly_yn=Y&",arguments,features);	
}


function clearFields()
{
	document.forms[0].practitioner_name.value='';

}

function displayPrimaryResource()
{
	document.getElementById("pract_type1").innerHTML="";
	clinicCode=document.forms[0].clinicDesc.value;
	clinicCode = clinicCode.substring(1,clinicCode.length);
	locn_type=document.forms[0].locn_type.value;

	var lbValue="";
	if (locn_type!='D' && locn_type!='N'){

	var HTML="<html><body onKeyDown = 'lockKey()'><form name='modifyWaitList' id='modifyWaitList' method='post'  action='../../eOA/jsp/ServerSideValidation.jsp'><input type=hidden name='from' id='from' value='WaitListMgmtModifyWindow'><input type=hidden name='LBoxValue' id='LBoxValue' value='"+lbValue+"'><input type=hidden name='clinicCode' id='clinicCode' value='"+clinicCode+"'><input type=hidden name='locn_type' id='locn_type' value='"+locn_type+"'></form></body></html>";
	parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTML);
	parent.messageFrame.document.modifyWaitList.submit();
	}
	else if (locn_type=='D') {
		parent.frames[0].document.getElementById("rsClass").value="B";
		parent.frames[0].document.getElementById("pract_type1").innerHTML=getLabel("Common.Bed.label","Common");
	}else if (locn_type=='N') {
		parent.frames[0].document.getElementById("rsClass").value="P";
		parent.frames[0].document.getElementById("pract_type1").innerHTML=getLabel("Common.practitioner.label","Common");
	}
}

function enble_disable(obj)
{
	if (obj.value=='')
	{
		document.forms[0].practitioner_name.disabled=true;
		document.forms[0].b_pract_butt.disabled=true;
		parent.frames[0].document.getElementById("pract_type1").innerHTML='';
	}
	else
	{
		document.forms[0].practitioner_name.disabled=false;
		document.forms[0].b_pract_butt.disabled=false;
	}
		document.forms[0].practitioner_name.value='';
	if (document.forms[0].locn_type.value=='D')
	{
		document.forms[0].practitioner_name.disabled=true;
		document.forms[0].b_pract_butt.disabled=true;
   	}
		document.forms[0].b_pract.value="";
}




function expandColapseframe(obj)
{
	//parent.parent.frames[2].document.getElementById("invite_wait_list").rows="38,50%,*,4%,9%";
		parent.parent.frames[2].document.getElementById("commontoolbarFrame").style.height="7vh";
		parent.parent.frames[2].document.getElementById("f_query_add_mod").style.height="55vh";
		parent.parent.frames[2].document.getElementById("search_collapse_frame").style.height="4vh";
		parent.parent.frames[2].document.getElementById("query_search_result").style.height="21vh";
		parent.parent.frames[2].document.getElementById("query_search_tabs").style.height="4vh";
		parent.parent.frames[2].document.getElementById("messageFrame").style.height="9vh";	
}

function enable_category(obj)
{

	if(obj.value !=null || obj.value !="")
	{
		document.forms[0].walst_category.disabled=false;
		document.forms[0].walst_cate_search.disabled=false;
	}else {
		document.forms[0].walst_category.disabled=true;
		document.forms[0].walst_cate_search.disabled=true;
	}
	
}

/*Lookup to open waitlist category search based on speciality selected*/
async function open_lookup()
{
		var p_speciality_code=document.forms[0].speciality.value;	

		var argumentArray  = new Array() ;
		var dataNameArray  = new Array() ;
		var dataValueArray = new Array() ;
		var dataTypeArray  = new Array() ;
		var target="";
		var sql="select a.WAITLIST_CATEGORY_CODE code, a.LONG_DESC description from OA_WAITLIST_CATEGORY a,OA_WL_CATEGORY_FOR_SPLTY b where a.WAITLIST_CATEGORY_CODE=b.WAITLIST_CATEGORY_CODE and a.eff_status = 'E' and b.SPECIALTY_CODE='"+p_speciality_code+"' and upper(a.WAITLIST_CATEGORY_CODE) like upper(?) and upper(a.LONG_DESC) like upper(?)  ";

		argumentArray[0] = sql ;
		argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4] = "1,2";
		argumentArray[5] = document.forms[0].walst_category.value;
		argumentArray[6] = CODE_LINK ;
		argumentArray[7] = CODE_DESC ; 

		retVal = await CommonLookup(encodeURIComponent(getLabel("Common.WaitList.label","Common")), argumentArray );
		var arr=new Array();
		if (retVal != null && retVal != '' && retVal != "null")
		{
			var retVal=unescape(retVal);
			arr=retVal.split(",");
			var desc=arr[1];
			var code=arr[0];
			document.forms[0].walst_category.value=desc;
			document.forms[0].walst_category_code.value=code;
		}else
		{
			document.forms[0].walst_category.value="";
			document.forms[0].walst_category_code.value="";
		}
}

function enable_category(obj)
{
	if(obj.value !=null || obj.value !="")
	{
		document.forms[0].walst_category.disabled=false;
		document.forms[0].walst_cate_search.disabled=false;
	}else {
		document.forms[0].walst_category.disabled=true;
		document.forms[0].walst_cate_search.disabled=true;

	}
}

function enable_category_gif()
{
	if(parent.frames[1].document.forms[0].waitlist_category_reqd_yn.value=="Y")
	{
		parent.frames[1].document.forms[0].wait_lst_cat.style.visibility="visible";
	}else
	{
		parent.frames[1].document.forms[0].wait_lst_cat.style.visibility="hidden";

	}
}


async function past_visits_view(patientId){
	var patient_id=patientId;
	var retVal = 	new String();
	var dialogHeight= "90vh" ;
	var dialogTop = "10" ;
	var dialogWidth	= "53vw" ;
	var status = "no";
	var scroll = "no";
	if(patient_id!=''){
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status  + "; dialogTop :" + dialogTop ;

	var callurl="../../eMP/jsp/vwEncounterDetailFrames.jsp?patientid="+patient_id;

	retVal = await window.showModalDialog(callurl,arguments,features);
	}
}


function sort(sortVal,order)
{

		if(order=='asc')
		{

			parent.frames[1].document.forms[0].ORDER.value='desc';
		}else{
			parent.frames[1].document.forms[0].ORDER.value='asc';
		}
	if(sortVal=="arrival_date")
		{
			var order_by='FIRST_ENCOUNTER_DATE';
			parent.frames[1].document.forms[0].ORDER_BY_VAL.value=order_by;
			parent.frames[2].document.forms[0].Select.value=getLabel("Common.search.label","Common");
			callResult();
		}else if(sortVal=="wait_lst_num")
		{
			var order_by='WAIT_LIST_NO';
			parent.frames[1].document.forms[0].ORDER_BY_VAL.value=order_by;
			parent.frames[2].document.forms[0].Select.value=getLabel("Common.search.label","Common");
			callResult();

		}
}

function toggleGifs(sortVal,order)
{
    
	if(sortVal=="FIRST_ENCOUNTER_DATE" || sortVal=="" || sortVal=="null" )
		{
			//document.forms[0].all.arrv_date.style.visibility='visible';
			document.getElementById("arrv_date").style.visibility='visible';
			if(order=='asc')
					document.forms[0].arrv_date.src = '../../eAE/images/Ascending.gif';
			else
					document.forms[0].arrv_date.src = '../../eAE/images/Descending.gif';
		}
		if(sortVal=="WAIT_LIST_NO")
		{
			//document.forms[0].all.wait_lst_num.style.visibility='visible';
			document.getElementById("wait_lst_num").style.visibility='visible';
			if(order=='asc')
					document.forms[0].wait_lst_num.src = '../../eAE/images/Ascending.gif';
			else
					document.forms[0].wait_lst_num.src = '../../eAE/images/Descending.gif';
		}
}

function view_discharge(last_encounter_id,patientid,highlightcnt)
{    

	var fid=parent.frames[3].document.forms[0].fac_id.value;
	var end=parent.frames[3].document.forms[0].endcnt.value;
	var oddeven="";
	for(i=0;i<end;i++)
	{
	if(i%2==0)
	{oddeven='QRYODDSMALL'
	
	}else{
	oddeven='QRYEVENSMALL'
	}
	

	if(("clrchse"+i)==highlightcnt)
	{ 
	
		eval('document.getElementById("clrchse")'+i).style.backgroundColor='#FF99FF';
	  eval('document.getElementById("firstencounterdate")'+i).style.backgroundColor='#FF99FF';
	  eval('document.getElementById("region")'+i).style.backgroundColor='#FF99FF';
	  eval('document.getElementById("age")'+i).style.backgroundColor='#FF99FF';
	  eval('document.getElementById("gender")'+i).style.backgroundColor='#FF99FF';
	  eval('document.getElementById("patname")'+i).style.backgroundColor='#FF99FF';
	  eval('document.getElementById("preenc")'+i).style.backgroundColor='#FF99FF';
	  eval('document.getElementById("waitLst")'+i).style.backgroundColor='#FF99FF';
	  eval('document.getElementById("priority")'+i).style.backgroundColor='#FF99FF';
	

	}else
		{
	
	eval('document.getElementById("clrchse")'+i).style.backgroundColor=''
	eval('document.getElementById("clrchse")'+i).className=oddeven
	eval('document.getElementById("firstencounterdate")'+i).style.backgroundColor=''
	eval('document.getElementById("firstencounterdate")'+i).className=oddeven
	eval('document.getElementById("region")'+i).style.backgroundColor=''
	eval('document.getElementById("region")'+i).className=oddeven
	eval('document.getElementById("age")'+i).style.backgroundColor=''

	eval('document.getElementById("age")'+i).className=oddeven

	eval('document.getElementById("gender")'+i).style.backgroundColor=''
	eval('document.getElementById("gender")'+i).className=oddeven
	eval('document.getElementById("patname")'+i).style.backgroundColor=''
	eval('document.getElementById("patname")'+i).className=oddeven
	eval('document.getElementById("preenc")'+i).style.backgroundColor=''
	eval('document.getElementById("preenc")'+i).className=oddeven
	eval('document.getElementById("waitLst")'+i).style.backgroundColor=''
	eval('document.getElementById("waitLst")'+i).className=oddeven
	eval('document.getElementById("priority")'+i).style.backgroundColor=''
	eval('document.getElementById("priority")'+i).className=oddeven

		//eval('document.getElementById("clrchse")'+i).style.backgroundColor='#D8D8D8';
		//eval('document.getElementById("clrchse")'+i).class='label';
		
		}
	}
		var eid=last_encounter_id;
		var patid=patientid;
		//parent.parent.frames[2].document.getElementById("invite_wait_list").rows="38,13%,4%,*,26%,9%";
		parent.parent.frames[2].document.getElementById("commontoolbarFrame").style.height="7vh";
		parent.parent.frames[2].document.getElementById("f_query_add_mod").style.height="55vh";
		parent.parent.frames[2].document.getElementById("search_collapse_frame").style.height="4vh";
		parent.parent.frames[2].document.getElementById("query_search_result").style.height="21vh";
		parent.parent.frames[2].document.getElementById("query_search_tabs").style.height="4vh";
		parent.parent.frames[2].document.getElementById("messageFrame").style.height="9vh";	
		
		
		var url='../../eCA/jsp/RelatedPatientHistNote.jsp?facilityid='+fid+"&called_function_id=INVIDE_WAITLIST&no_modal=N&appl_task_id=DISCHARGE_SUMMARY&calling_mode=NORMAL&group=1&cur_epi=Y&encounter_id="+eid+"&patient_id="+patid;
		
		parent.frames[4].document.location.href=url; 
		
}

function changeCase(Obj)
      	{
      		Obj.value=Obj.value.toUpperCase();
      	
      	}

		function open_lookup_one()
{
	
		var p_speciality_code=document.forms[0].speciality.value;	

		var argumentArray  = new Array() ;
		var dataNameArray  = new Array() ;
		var dataValueArray = new Array() ;
		var dataTypeArray  = new Array() ;
		var target="";
		if(document.forms[0].walst_category.value !="")
		{
			
		var sql="select a.WAITLIST_CATEGORY_CODE code, a.LONG_DESC description from OA_WAITLIST_CATEGORY a,OA_WL_CATEGORY_FOR_SPLTY b where a.WAITLIST_CATEGORY_CODE=b.WAITLIST_CATEGORY_CODE and a.eff_status = 'E' and b.SPECIALTY_CODE='"+p_speciality_code+"' and upper(a.LONG_DESC) like upper(?) and upper(a.WAITLIST_CATEGORY_CODE) like upper(?)  ";
		


		argumentArray[0] = sql ;
		argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4] = "1,2";
		argumentArray[5] = document.forms[0].walst_category.value;
		argumentArray[6] = CODE_LINK ;
		argumentArray[7] = CODE_DESC ; 

		retVal = CommonLookup(encodeURIComponent(getLabel("Common.WaitList.label","Common")), argumentArray );
		var arr=new Array();
		if (retVal != null && retVal != '' && retVal != "null")
		{
			var retVal=unescape(retVal);
			arr=retVal.split(",");
			var desc=arr[1];
			var code=arr[0];
			document.forms[0].walst_category.value=desc;
			document.forms[0].walst_category_code.value=code;
		}else
		{
			document.forms[0].walst_category.value="";
			document.forms[0].walst_category_code.value="";
		}
	}
}


function validate_date_one(obj,k_val)
{
	var i=k_val;


var flag=true;
if (obj.value !="")
{
	

	if(!validDateObj(obj,"DMY",localeName))
		{
			obj.value="";
			obj.select();
			return ;
		}

		sys=parent.frames[1].document.forms[0].sys_date.value;

		var obj1=convertDate(obj.value,"DMY",localeName,"en");

		if(isBefore(sys,obj1,'DMY',localeName)==false)
			{
				alert(getMessage("SCH_DATE_NOT_GREAT_TODAY","OA"));
				obj.value="";
				eval("document.forms[0].status_val"+i).value="";
				obj.select();	
				return false;
			}
			
	if(eval("document.forms[0].status_val"+i).value=="S")
	{
		alert(getMessage("STATUS_NOT_SELECTED","OA"));
		eval("document.forms[0].status_val"+i).value="";
	}else if(eval("document.forms[0].status_val"+i).value=="O")
	{
		alert(getMessage("STATUS_NOT_OPENED","OA"));
		eval("document.forms[0].status_val"+i).value="";
	}
		if(flag!=false)
	{
		var wait_list_num=eval("document.forms[0].wait_num"+i).value;

		var xmlDoc = ""
		var xmlHttp = new XMLHttpRequest()
		xmlStr	="<root><SEARCH date_val=\""+obj1+"\" wait_list_num=\""+wait_list_num+"\" steps='validatepref_date_sunday_invitation'/></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
		xmlHttp.open("POST","ServerSide.jsp",false)
		xmlHttp.send(xmlDoc)
		responseText=xmlHttp.responseText
		eval(responseText)

		if(sunday_flag==1)
		{
			var error=getMessage("WAITLIST_NOT_ALL_SUNDAY","OA");
			alert(error);
			submitflag=false;
			obj.value="";
		}
		
	
	}

}else if(obj.value =="")
{
	if(eval("document.forms[0].status_val"+i).value=="I")
	{
		alert(getMessage("STATUS_NOT_INVITED","OA"));
		eval("document.forms[0].status_val"+i).value="";
	}else if(eval("document.forms[0].status_val"+i).value=="")
	{
	}
}



}
function call_statuc_chk(obj,k_val,invitation_date)
{
	if(obj.value=='S' && invitation_date.value !="")
	{
			alert(getMessage("STATUS_NOT_SELECTED","OA"));
		obj.value="";
	} else if(obj.value=='I' && invitation_date.value =="")
	{
		
			alert(getMessage("STATUS_NOT_INVITED","OA"));
			eval("document.forms[0].checkBox"+k_val).checked=false;
		obj.value="";
	}else if(obj.value=='O' && invitation_date.value !="")
	{
			alert(getMessage("STATUS_NOT_OPENED","OA"));
		obj.value="";
	}
}

function submitPrevNext(from, to)
{


	
	var maxRecord=parent.parent.frames[2].frames[3].document.forms[0].maxrecord.value;
	var bool=true;

	for(var i=1;i<=maxRecord;i++)
	{
		if(eval("parent.parent.frames[2].frames[3].document.forms[0].checkBox"+i))
		{
				if(eval("parent.parent.frames[2].frames[3].document.forms[0].checkBox"+i).checked==true)
				{   
					if(eval("parent.parent.frames[2].frames[3].document.forms[0].status_val"+i).value!=""){
						bool=true;
						
					}else {
							bool=false;
							break;
							}
					}
		}
	}
	if(bool==true)
	{
	/*	parent.parent.frames[2].frames[3].document.forms[0].action="../../servlet/eOA.AppointmentWtListServlet";
	parent.parent.frames[2].frames[3].document.forms[0].target="messageFrame";
		 parent.parent.frames[2].frames[3].document.forms[0].submit();*/

	document.forms[0].from.value = from;
	document.forms[0].to.value = to; 
	document.forms[0].submit();
	}
	else
	{
		alert(getMessage("WAITLIST_CANNOT_BLANK","OA"));
		parent.parent.frames[2].frames[5].document.location.href="../../eCommon/jsp/error.jsp?err_num=";
	}
}




function chk_val(obj,s)
{
	if(obj.value=="" && eval("document.forms[0].checkBox"+s).checked==true)
	{
		alert(getMessage("WAITLIST_CANNOT_BLANK","OA"));
	
		//eval("document.forms[0].checkBox"+s).checked=false;
		obj.focus();
	}
}

