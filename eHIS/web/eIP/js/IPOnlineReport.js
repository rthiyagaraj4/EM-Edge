function create() {
	f_query_add_mod.location.href = "../../eIP/jsp/IPOnlineReportMain.jsp?operation=insert&flag=InternalReportRule";
	
}

function query() {
	
	
	f_query_add_mod.location.href ="../../eIP/jsp/IPOnlineReportQueryCriteria.jsp?function_id=IP_ONLINE_REPORT" ;
	}
function checkIsValidForProceed(){
	var url = f_query_add_mod.location.href;
    url = url.toLowerCase();
    if ( (url.indexOf("blank.html")==-1) && (url.indexOf("query")==-1) )
        return true;
    else
        return false;
}


function apply() 
{
	
	if (! (checkIsValidForProceed())){
		messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num=&err_value=0';
		return false;
	}else
	{
		if(parent.content.frames[1].frames[2].document.forms[0]==null)
		{
			if(parent.content.frames[1].frames[1].document.forms[0].function_code_desc.value == "")
			{	var msg= parent.content.frames[1].frames[1].getMessage("CAN_NOT_BE_BLANK","common");
				msg = msg.replace('$',  getLabel('Common.nursingUnit.label','common'));
				messageFrame.location.href = '../../eCommon/jsp/error.jsp?err_num='+msg+'&err_value=0';
			}else
			{
				//messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
				messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num=&err_value=0';
				return false;
			}
					
		}
		else
		{
			var function_code_r = parent.content.frames[1].frames[2].document.forms[0].Function; 
			var function_code_q = parent.content.frames[1].frames[1].document.forms[0].Function; 


			if(function_code_q.value != "")
			{

			var SelectYNStr			=	parent.content.frames[1].frames[1].document.forms[0].SelectYNStr.value;

			var SelectYNStrBkg		=	parent.content.frames[1].frames[1].document.forms[0].SelectYNStrBkg.value;

			var SelectYNStrConf		=	parent.content.frames[1].frames[1].document.forms[0].SelectYNStrConf.value;

			var SelectYNStrBed		=	parent.content.frames[1].frames[1].document.forms[0].SelectYNStrBed.value;

			var SelectYNStrWoBed	=	parent.content.frames[1].frames[1].document.forms[0].SelectYNStrWoBed.value;
			
			var SelectYNStrPrint_on_discharge	=	parent.content.frames[1].frames[1].document.forms[0].SelectYNStrPrint_on_discharge.value;
		
			var SelectYNStrTransReqest	=	parent.content.frames[1].frames[1].document.forms[0].SelectYNStrTransReqest.value;
		   
			var SelectYNStrDischarge=	parent.content.frames[1].frames[1].document.forms[0].SelectYNStrDischarge.value;
			
			var  SelectYNStrCode	=	parent.content.frames[1].frames[1].document.forms[0].SelectYNStrCode.value;
		
			var row_count				=	parent.content.frames[1].frames[2].document.forms[0].row_count.value;
		  //	var to_cnt				=	parent.content.frames[1].frames[2].document.forms[0].to_disp.value;
				
			var chk='';  var chkBkg='';  var chkBed='';   var chkWoBed1=''; var  chkConf1=''; var chkDischarge_advise1='';
		   var chk1=''; var chkBkg1=''; var chkBed1='';  var chkWoBed='';  var  chkConf='';  var chkDischarge_advise='';
		   var  chkDischarge1 = '';   var chktransferrequest1 = '';
		   var  chkDischarge = '';    var chktransferrequest = '';
		   
		for ( var i=0; i<row_count;i++){
			
			 if(eval("parent.content.frames[1].frames[2].document.forms[0].select_yn"+i).checked == true){
			  chk =	eval("parent.content.frames[1].frames[2].document.forms[0].select_yn"+i)
			  if((SelectYNStr.indexOf(chk.name)) == -1)
				  SelectYNStr += chk.name+"~";  
				  chk1 = 'Y';
				}
			 else
				 chk1 = 'N';

			 if(eval("parent.content.frames[1].frames[2].document.forms[0].select_booking_yn"+i).checked == true)
				{
				 chkBkg		=	eval("parent.content.frames[1].frames[2].document.forms[0].select_booking_yn"+i)
				  
					   if((SelectYNStrBkg.indexOf(chkBkg.name)) == -1)
						SelectYNStrBkg += chkBkg.name+"~";
					   chkBkg1 = 'Y';
					 
				}
				else 
					   
					   chkBkg1 = 'N';
					  
		
		if(eval("parent.content.frames[1].frames[2].document.forms[0].select_admissionWithBed_yn"+i).checked == true)
				{
		 chkBed		=	eval("parent.content.frames[1].frames[2].document.forms[0].select_admissionWithBed_yn"+i)
						
				
					if((SelectYNStrBed.indexOf(chkBed.name)) == -1)
					SelectYNStrBed += chkBed.name+"~";
					 chkBed1='Y';
					   
				}
				else
					   chkBed1 = 'N';
	
				

		if(	eval("parent.content.frames[1].frames[2].document.forms[0].select_admissionWithoutBed_yn"+i).checked == true)
				{
			chkWoBed	=	eval("parent.content.frames[1].frames[2].document.forms[0].select_admissionWithoutBed_yn"+i)
			   
				if((SelectYNStrWoBed.indexOf(chkWoBed.name)) == -1)
						  SelectYNStrWoBed += chkWoBed.name+"~";
						  chkWoBed1='Y';
					   
				}
				else
					   chkWoBed1 = 'N';	       
	  

				
		
	if( eval("parent.content.frames[1].frames[2].document.forms[0].select_transferConfirmation_yn"+i).checked == true)
				{ 
		 chkConf		=	eval("parent.content.frames[1].frames[2].document.forms[0].select_transferConfirmation_yn"+i)
					
						  if((SelectYNStrConf.indexOf(chkConf.name)) == -1)
						   SelectYNStrConf += chkConf.name+"~";
						  chkConf1 = 'Y';
					   
				}
				else
					   chkConf1 = 'N';
				
		if(eval("parent.content.frames[1].frames[2].document.forms[0].print_on_discharge_yn"+i).checked == true)
				{ 
				   chkDischarge_advise = eval("parent.content.frames[1].frames[2].document.forms[0].print_on_discharge_yn"+i);
					 
					if((SelectYNStrPrint_on_discharge.indexOf(chkDischarge_advise.name+"~")) == -1)
						SelectYNStrPrint_on_discharge += chkDischarge_advise.name+"~";
					chkDischarge_advise1 = 'Y';
					
				}
				else
					   chkDischarge_advise1 = 'N';

	 if(eval("parent.content.frames[1].frames[2].document.forms[0].select_transferrequest_yn"+i).checked == true)
				{
			  chktransferrequest = eval("parent.content.frames[1].frames[2].document.forms[0].select_transferrequest_yn"+i);
				   
				
					if((SelectYNStrTransReqest.indexOf(chktransferrequest.name+"~")) == -1)
						SelectYNStrTransReqest += chktransferrequest.name+"~";
					chktransferrequest1 = 'Y';
				
				}

				else
				   chktransferrequest1 = 'N';
				
				
	if(	eval("parent.content.frames[1].frames[2].document.forms[0].select_discharge_yn"+i).checked == true)
				{          
			   chkDischarge = eval("parent.content.frames[1].frames[2].document.forms[0].select_discharge_yn"+i);
					  
				
					if((SelectYNStrDischarge.indexOf(chkDischarge.name+"~")) == -1)
						SelectYNStrDischarge += chkDischarge.name+"~";
					chkDischarge1 = 'Y';
				}
				else
					   chkDischarge1 = 'N';
			

				var codeVal		=	eval("parent.content.frames[1].frames[2].document.forms[0].reportCode"+i)

				if(codeVal != null)
				{
					if((SelectYNStrCode.indexOf(codeVal.value+"~")) == -1)
						SelectYNStrCode += codeVal.value+"~";
				}
	if ( ( (chk1 == 'Y') &&  (chkBkg1 == 'N'&& chkBed1 =='N'&& chkWoBed1 =='N' && chkConf1=='N' && chkDischarge_advise1 =='N'&& chktransferrequest1 =='N' && chkDischarge1=='N')  ) 
		|| ( (chk1 == 'N') &&  (chkBkg1 == 'Y'|| chkBed1 =='Y'|| chkWoBed1 =='Y' || chkConf1=='Y' || chkDischarge_advise1 =='Y'|| chktransferrequest1 =='Y' || chkDischarge1=='Y')  ) )


			{   
				
				  var msg= parent.content.frames[1].frames[1].getMessage("NO_SELECTION","IP");
				//msg = msg.replace('$',  getLabel('Common.nursingUnit.label','common'));
				messageFrame.location.href = '../../eCommon/jsp/error.jsp?err_num='+msg+'&err_value=0';
				return false;
			}

		}

		
			parent.content.frames[1].frames[1].document.forms[0].SelectYNStr.value	=	SelectYNStr;
			parent.content.frames[1].frames[2].document.forms[0].SelectYNStr.value	=	parent.content.frames[1].frames[1].document.forms[0].SelectYNStr.value; 

			parent.content.frames[1].frames[1].document.forms[0].SelectYNStrBkg.value	=	SelectYNStrBkg;
			parent.content.frames[1].frames[2].document.forms[0].SelectYNStrBkg.value =	parent.content.frames[1].frames[1].document.forms[0].SelectYNStrBkg.value; 

			parent.content.frames[1].frames[1].document.forms[0].SelectYNStrBed.value	=	SelectYNStrBed;
			parent.content.frames[1].frames[2].document.forms[0].SelectYNStrBed.value =	parent.content.frames[1].frames[1].document.forms[0].SelectYNStrBed.value; 

			parent.content.frames[1].frames[1].document.forms[0].SelectYNStrWoBed.value	=	SelectYNStrWoBed;
			parent.content.frames[1].frames[2].document.forms[0].SelectYNStrWoBed.value	=parent.content.frames[1].frames[1].document.forms[0].SelectYNStrWoBed.value; 

			parent.content.frames[1].frames[1].document.forms[0].SelectYNStrConf.value	=	SelectYNStrConf;
			parent.content.frames[1].frames[2].document.forms[0].SelectYNStrConf.value=parent.content.frames[1].frames[1].document.forms[0].SelectYNStrConf.value; 
			
		  
			parent.content.frames[1].frames[1].document.forms[0].SelectYNStrPrint_on_discharge.value	=SelectYNStrPrint_on_discharge;
			parent.content.frames[1].frames[2].document.forms[0].SelectYNStrPrint_on_discharge.value=parent.content.frames[1].frames[1].document.forms[0].SelectYNStrPrint_on_discharge.value; 
			
			parent.content.frames[1].frames[1].document.forms[0].SelectYNStrTransReqest.value	=SelectYNStrTransReqest;
			parent.content.frames[1].frames[2].document.forms[0].SelectYNStrTransReqest.value=parent.content.frames[1].frames[1].document.forms[0].SelectYNStrTransReqest.value; 
				 


			parent.content.frames[1].frames[1].document.forms[0].SelectYNStrDischarge.value	=SelectYNStrDischarge;
			parent.content.frames[1].frames[2].document.forms[0].SelectYNStrDischarge.value=parent.content.frames[1].frames[1].document.forms[0].SelectYNStrDischarge.value; 

			parent.content.frames[1].frames[1].document.forms[0].SelectYNStrCode.value	=	SelectYNStrCode;
			parent.content.frames[1].frames[2].document.forms[0].SelectYNStrCode.value=parent.content.frames[1].frames[1].document.forms[0].SelectYNStrCode.value; 

			function_code_r.value=function_code_q.value;
			parent.content.frames[1].frames[2].document.forms[0].nursing_unit_code.value=
			parent.content.frames[1].frames[1].document.forms[0].function_code.value;

			parent.content.frames[1].frames[2].document.forms[0].submit();
			}
			else
			{
			
				var msg= parent.content.frames[1].frames[1].getMessage("CAN_NOT_BE_BLANK","common");
				msg = msg.replace('$', getLabel('Common.nursingUnit.label','common'));
				alert(msg);
			}
		
		

		}
	}
}

function reset() 
	{ 
		f_query_add_mod.location.reload();
	}

function onSuccess() 
{

	if(f_query_add_mod.frames[1].document.forms[0].operation.value=='insert')
	{
		f_query_add_mod.location.href = "../../eIP/jsp/IPOnlineReportMain.jsp?operation=insert";
		
	}
	else if(f_query_add_mod.frames[1].document.forms[0].operation.value=='modify')
	{
		f_query_add_mod.frames[1].location.href = "../../eCommon/html/blank.html";
	}
}

function checkVal()
{
	
	var SelectYNStr		=	parent.content.document.forms[0].SelectYNStr.value;
	var SelectYNStrBkg	=	parent.content.document.forms[0].SelectYNStrBkg.value;

	var SelectYNStrConf	=	parent.content.document.forms[0].SelectYNStrConf.value;
	var SelectYNStrBed	=	parent.content.document.forms[0].SelectYNStrBed.value;
	var SelectYNStrWoBed=	parent.content.document.forms[0].SelectYNStrWoBed.value;
	var SelectYNStrDischarge= parent.content.document.forms[0].SelectYNStrDischarge.value;
	var  SelectYNStrCode	=	parent.content.document.forms[0].SelectYNStrCode.value;
	var fm_cnt=document.forms[0].fm_disp.value;
	var to_cnt=document.forms[0].to_disp.value;

	for (i=fm_cnt; i<=to_cnt;i++)
	{
		var chk		=	eval("document.forms[0].select_yn"+i)
		var code	=	eval("document.forms[0].reportCode"+i)
		if(chk.checked)
		{
			if((SelectYNStr.indexOf(chk.name)) == -1)
			{
				SelectYNStr += chk.name+"~";
				SelectYNStrCode += code.value+"~";
			}

				
		}
		var chkBkg		=	eval("document.forms[0].select_booking_yn"+i)
		if(chkBkg.checked)
		{
			if((SelectYNStrBkg.indexOf(chkBkg.name)) == -1)
				SelectYNStrBkg += chkBkg.name+"~";
		}
		var chkBed		=	eval("document.forms[0].select_admissionWithBed_yn"+i)
		if(chkBed.checked)
		{
			if((SelectYNStrBed.indexOf(chkBed.name)) == -1)
				SelectYNStrBed += chkBed.name+"~";
		}
		var chkWoBed		=	eval("document.forms[0].select_admissionWithoutBed_yn"+i)
		if(chkWoBed.checked)
		{
			if((SelectYNStrWoBed.indexOf(chkWoBed.name)) == -1)
				SelectYNStrWoBed += chkWoBed.name+"~";
		}

		var chkConf		=	eval("document.forms[0].select_transferConfirmation_yn"+i)
		if(chkConf.checked)
		{
			if((SelectYNStrConf.indexOf(chkConf.name)) == -1)
				SelectYNStrConf += chkConf.name+"~";
		}
		var chkDischarge		=	eval("document.forms[0].select_discharge_yn"+i)
		if(chkDischarge.checked)
		{
			if((SelectYNStrDischarge.indexOf(chkDischarge.name+"~")) == -1)
				SelectYNStrDischarge += chkDischarge.name+"~";
		}
		var codeVal		=	eval("document.forms[0].reportCode"+i)
		if(codeVal != null)
		{
			if((SelectYNStrCode.indexOf(codeVal.value+"~")) == -1)
				SelectYNStrCode += codeVal.value+"~";
		}
		
	}
	parent.content.document.forms[0].SelectYNStr.value		=	SelectYNStr;
	parent.content.document.forms[0].SelectYNStrBkg.value		=	SelectYNStrBkg;
	parent.content.document.forms[0].SelectYNStrBed.value		=	SelectYNStrBed;
	parent.content.document.forms[0].SelectYNStrWoBed.value	=	SelectYNStrWoBed;
	parent.content.document.forms[0].SelectYNStrConf.value	=	SelectYNStrConf;
	parent.content.document.forms[0].SelectYNStrDischarge.value	=	SelectYNStrDischarge;
	parent.content.document.forms[0].SelectYNStrCode.value	=	SelectYNStrCode;

}

function SelectCBValue(obj1, obj2)
{	
	var count;
	var count1;
	var del_obj=obj1.name;
	var del_chk=obj1.checked;
	var del_locn_obj="delete_yn"+obj2;

	var temp_cb_str="";
	var temp_locn_str="";

	if(!(del_chk))
	{
		var SelectYNStr	= parent.frames[1].document.forms[0].SelectYNStr.value;
		if(SelectYNStr =="")SelectYNStr.value="";
		var split	= SelectYNStr.split('~');
		for (i=0; i<(split.length-1); i++)
		{
			if(split[i] != del_obj)
			{
				temp_cb_str += split[i]+"~";

			}
			else
			{
				temp_cb_str=temp_cb_str;

			}
		}
		SelectYNStr=temp_cb_str;
		parent.frames[1].document.forms[0].SelectYNStr.value = SelectYNStr;

	}
}



function dispRecord()
{
	
    var SelectYNStr	=	parent.frames[1].document.forms[0].SelectYNStr.value;
	var SelectYNStrBkg=parent.frames[1].document.forms[0].SelectYNStrBkg.value;
	var SelectYNStrBed= parent.frames[1].document.forms[0].SelectYNStrBed.value;	
	var SelectYNStrWoBed= parent.frames[1].document.forms[0].SelectYNStrWoBed.value;
	var SelectYNStrTransReqest= parent.frames[1].document.forms[0].SelectYNStrTransReqest.value;
	var SelectYNStrConf = parent.frames[1].document.forms[0].SelectYNStrConf.value;
	var SelectYNStrPrint_on_discharge = parent.frames[1].document.forms[0].SelectYNStrPrint_on_discharge.value;
	var SelectYNStrDischarge= parent.frames[1].document.forms[0].SelectYNStrDischarge.value;
	var SelectYNStrCode= parent.frames[1].document.forms[0].SelectYNStrCode.value;

	
	if(SelectYNStr != "")
	{
		var val	=	SelectYNStr.split('~')

		var code=	SelectYNStrCode.split('~')
		for(i=0; i<val.length; i++)
		{
			var assign	=	val[i];
			
			if(assign!="")
			{
				var chk=eval('document.forms[0].'+assign);
			
				if(chk)
				{
					chk.checked = true;
					var len=assign.length;
					checkIndex  = assign.substring(9,len);
					var codeVal =	code[checkIndex];

		
					SelectEnableDisable(chk,codeVal,checkIndex);
					
				}
			}
		}
	}
	if(SelectYNStrBkg != "")
	{
	
		var val	=	SelectYNStrBkg.split('~')
		for(i=0; i<val.length; i++)
		{
			var assign	=	val[i];
	
			if(assign!="")
			{
	
				if(eval('document.forms[0].'+assign))
				{
					eval('document.forms[0].'+assign+'.checked=true');
				}
			}
		}
	}
	if(SelectYNStrBed != "")
	{
		var val	=	SelectYNStrBed.split('~')
		for(i=0; i<val.length; i++)
		{
			var assign	=	val[i];
			if(assign!="")
			{
				if(eval('document.forms[0].'+assign))
				{
					eval('document.forms[0].'+assign+'.checked=true');
				}
			}
		}
	}
	if(SelectYNStrWoBed != "")
	{
		var val	=	SelectYNStrWoBed.split('~')
		for(i=0; i<val.length; i++)
		{
			var assign	=	val[i];
			if(assign!="")
			{
				if(eval('document.forms[0].'+assign))
				{
					eval('document.forms[0].'+assign+'.checked=true');
				}
			}
		}
	}
	if(SelectYNStrConf != "")
	{
		var val	=	SelectYNStrConf.split('~')
		for(i=0; i<val.length; i++)
		{
			var assign	=	val[i];
			if(assign!="")
			{
				if(eval('document.forms[0].'+assign))
				{
					eval('document.forms[0].'+assign+'.checked=true');
				}
			}
		}
	}
	if(SelectYNStrTransReqest != "")
	{
		var val	=	SelectYNStrTransReqest.split('~')
		for(i=0; i<val.length; i++)
		{
			var assign	=	val[i];
			if(assign!="")
			{
				if(eval('document.forms[0].'+assign))
				{
					eval('document.forms[0].'+assign+'.checked=true');
				}
			}
		}
	}
	if(SelectYNStrPrint_on_discharge != "")
	{
	
		var val	=	SelectYNStrPrint_on_discharge.split('~')
		for(i=0; i<val.length; i++)
		{
			var assign	=	val[i];
			if(assign!="")
			{
				if(eval('document.forms[0].'+assign))
				{
					eval('document.forms[0].'+assign+'.checked=true');
				}
			}
		}
	}
	if(SelectYNStrDischarge != "")
	{
	
		var val	=	SelectYNStrDischarge.split('~')
		for(i=0; i<val.length; i++)
		{
			var assign	=	val[i];
			if(assign!="")
			{
				if(eval('document.forms[0].'+assign))
				{
					eval('document.forms[0].'+assign+'.checked=true');
				}
			}
		}
	}
}



function enableDisable(obj)
{
	self.document.IPOnlineReport_form.booking_yn.disabled = true ;
	self.document.IPOnlineReport_form.conform_transfer_yn.disabled = true ;
	self.document.IPOnlineReport_form.bed_assigned_yn.disabled = true ;
	self.document.IPOnlineReport_form.admission_yn.disabled = true ;
	self.document.IPOnlineReport_form.discharge_yn.disabled = true ;

	if (obj == 'IPBENFRM')
	{
		self.document.IPOnlineReport_form.print_on_booking_yn.disabled = true ;
		self.document.IPOnlineReport_form.print_on_booking_yn.checked = false ;
		self.document.IPOnlineReport_form.print_on_conform_transfer_yn.disabled = false ;
		self.document.IPOnlineReport_form.print_on_bed_assigned_yn.disabled = false ;
		self.document.IPOnlineReport_form.print_on_admission_yn.disabled = false ;
		self.document.IPOnlineReport_form.print_on_discharge_yn.checked = false; 
	}
	else if(obj == 'IPBBKSLP')
	{
		self.document.IPOnlineReport_form.print_on_booking_yn.disabled = false ;
		self.document.IPOnlineReport_form.print_on_conform_transfer_yn.checked = false ;
		self.document.IPOnlineReport_form.print_on_bed_assigned_yn.checked = false ;
		self.document.IPOnlineReport_form.print_on_admission_yn.checked = false ;
		self.document.IPOnlineReport_form.print_on_discharge_yn.checked = false ;
	}
	else if(obj == 'IPHKPLTR')
	{
		
		self.document.IPOnlineReport_form.print_on_booking_yn.disabled = true ;
		self.document.IPOnlineReport_form.print_on_conform_transfer_yn.checked = false ;
		self.document.IPOnlineReport_form.print_on_discharge_yn.checked = false ;
		self.document.IPOnlineReport_form.print_on_conform_transfer_yn.disabled = true ;
		self.document.IPOnlineReport_form.print_on_bed_assigned_yn.disabled = true ;
		self.document.IPOnlineReport_form.print_on_admission_yn.disabled = true ;
	}
	else
	{
		self.document.IPOnlineReport_form.print_on_conform_transfer_yn.disabled = false ;
		self.document.IPOnlineReport_form.print_on_bed_assigned_yn.disabled = false ;
		self.document.IPOnlineReport_form.print_on_admission_yn.disabled = false ;
		self.document.IPOnlineReport_form.print_on_discharge_yn.disabled = false ;
	}
}


function selectFunction(obj)
{
	var val=obj.name;
	parent.frames[1].location.href="../../eIP/jsp/IPOnlineReportQuery.jsp?Function="+val+"&operation=insert";
	parent.frames[2].location.href="../../eCommon/html/blank.html";
}

function SelectEnableDisable(obj,objCode,rownum)
{
 


    var selBooking=eval("document.forms[0].select_booking_yn"+rownum);
	var selConfirm=eval("document.forms[0].select_transferConfirmation_yn"+rownum);
	var selBedWith=eval("document.forms[0].select_admissionWithBed_yn"+rownum);
	var selTransRequest=eval("document.forms[0].select_transferrequest_yn"+rownum);
	var selBedWithout=eval("document.forms[0].select_admissionWithoutBed_yn"+rownum);
	var selDischargeadvise=eval("document.forms[0].print_on_discharge_yn"+rownum);
	var selDischarge=eval("document.forms[0].select_discharge_yn"+rownum);





	if(obj.checked)
	{
	}
	else
	{
		selBooking.checked=false;
		selConfirm.checked=false;
		selBedWith.checked=false;
		selTransRequest.checked=false;
		selBedWithout.checked=false;
		selDischargeadvise.checked=false;
		selDischarge.checked=false;
	}

/*
	if(obj.checked)
	{
		if(objCode=="IPBBKSLP")
		{
			if(selConfirm)
			selConfirm.checked=false;

			if(selBedWith)
			selBedWith.checked=false;
			if(selBedWithout)
			selBedWithout.checked=false;
			if(selDischarge)
			selDischarge.checked=false;

			if(selBooking)
			selBooking.disabled=false;

			if(selConfirm)
			selConfirm.disabled=true;
			if(selBedWith)
			selBedWith.disabled=true;
			if(selBedWithout)
			selBedWithout.disabled=true;
			if(selDischarge)
			selDischarge.disabled=true;
		}
		else
		{

			if(objCode=="IPHKPLTR"){
					if(selBooking)
					selBooking.disabled=true;
					if(selConfirm)
					selConfirm.disabled=true;
					if(selBedWith)
					selBedWith.disabled=true;
					if(selBedWithout)
					selBedWithout.disabled=true;
					if(objCode=="IPBENFRM")
					{
						if(selDischarge)
							selDischarge.disabled=true;
					}
					else
					{
						if(selDischarge)
						selDischarge.disabled=false;
					}
			}
			else
			{
				if(selBooking)
				selBooking.disabled=true;
				if(selConfirm)
				selConfirm.disabled=false;
				if(selBedWith)
				selBedWith.disabled=false;
				if(selBedWithout)
				selBedWithout.disabled=false;
				if(objCode=="IPBENFRM")
				{
					if(selDischarge)
						selDischarge.disabled=true;
				}
				else
				{
					if(selDischarge)
					selDischarge.disabled=false;
				}
			}
			
			
		}
	}
	else
	{
		selBooking.checked=false;
		selConfirm.checked=false;
		selBedWith.checked=false;
		selBedWithout.checked=false;
		selDischarge.checked=false;
	}
*/

}
