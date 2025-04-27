/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
function apply(){

 
	var fields = new Array();
	var names = new Array ();
	var blk_time_from=self.frames[1].document.forms[0].blk_time_from.value;
	var blk_time_to=self.frames[1].document.forms[0].blk_time_to.value;
    
	if (self.frames[1].document.getElementById("imgpract").style.visibility=="hidden"){
		fields[0]= self.frames[1].document.forms[0].location;
		fields[1]= self.frames[1].document.forms[0].resourceType;
		fields[2]= self.frames[1].document.forms[0].eff_from;
		fields[3]= self.frames[1].document.forms[0].eff_to;
		fields[4]= self.frames[1].document.forms[0].action;
		fields[5]= self.frames[1].document.forms[0].reason;

		names[0] = getLabel("Common.Location.label","Common");
		names[1] = getLabel("Common.resourceclass.label","Common");
		names[2] = getLabel("Common.fromdate.label","Common");
		names[3] = getLabel("Common.todate.label","Common");
		names[4] = getLabel("Common.action.label","Common");
		names[5] = getLabel("Common.reason.label","Common");

		/*Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114*/
		if(self.frames[1].document.forms[0].remarks_img.style.visibility == 'visible')
		{
			fields[6] = self.frames[1].document.forms[0].other_remarks;
			names[6] = getLabel("Common.remarks.label","Common");
		}
		/*End ML-MMOH-CRF-1114*/

	}else{
		fields[0]= self.frames[1].document.forms[0].location;
		fields[1]= self.frames[1].document.forms[0].resourceType;
		fields[2]= self.frames[1].document.forms[0].practitioner_name;
		fields[3]= self.frames[1].document.forms[0].eff_from;
		fields[4]= self.frames[1].document.forms[0].eff_to;
		fields[5]= self.frames[1].document.forms[0].action;
		fields[6]= self.frames[1].document.forms[0].reason;

		names[0] = getLabel("Common.Location.label","Common");
		names[1] = getLabel("Common.resourceclass.label","Common");
		names[2] = getLabel("Common.resourcename.label","Common");
		names[3] = getLabel("Common.fromdate.label","Common");
		names[4] = getLabel("Common.todate.label","Common");
		names[5] = getLabel("Common.action.label","Common");
		names[6] = getLabel("Common.reason.label","Common");

		/*Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114*/
		if(self.frames[1].document.forms[0].remarks_img.style.visibility == 'visible')
		{
			fields[7] = self.frames[1].document.forms[0].other_remarks;
			names[7] = getLabel("Common.remarks.label","Common");
		}
		/*End ML-MMOH-CRF-1114*/

	}
	var action=frames[1].document.forms[0].action.value;
	
	var flag=false;
	var clinic_date="";
	if(self.frames[2].document.forms[0]){
		/*	var n = self.frames[2].document.forms[0].no_of_rec.value;
		var e=0;
		var p="";
		var p1="";
		var sel=0;
		for(var k=0;k<n;k++){
			if(self.frames[2].document.forms[0].elements(e).checked == true){
				
				
				p += self.frames[2].document.forms[0].elements(e+1).value + "-";
				p1 += self.frames[2].document.forms[0].elements(e+2).value + "-";
				sel++;
				if(action =="C")
				{
					
					if(eval("self.frames[2].document.getElementById("noofappts")"+k).value >0)
					{
					 flag=true;
					}
				}
			}
				e+=3;
		}
		self.frames[2].document.forms[0].final_vals.value = p;
		self.frames[2].document.forms[0].final_vals1.value = p1;
		self.frames[2].document.forms[0].sel_rec.value = sel;*/
		var sel=0;
		var flag=false;
		var len=self.frames[2].document.getElementById("checkBox").length;
		for(i=0;i<len;i++){
			if(self.frames[2].document.getElementById("checkBox[i]")){
				if(self.frames[2].document.getElementById("checkBox[i]").checked==true){
					flag=false;
				}
			}
		}
		var selValues="";
		var selValues1="";
		len=self.frames[2].document.BCLSchDetail_form.checkBox.length;
		obj=self.frames[2].document.BCLSchDetail_form.checkBox;
		Obj=self.frames[2].document.BCLSchDetail_form;
		
		if (Obj.selectall.checked){
			var str="111111111111111";
		}else{
			var str="000000000000000";
		}
		if (len!=null && len!=''){
			for (i=0;i<len;i++){
				if (obj[i].checked){
					if(blk_time_from!="" && blk_time_to!=""){
						//selValues1=Obj.vals[i].value+"|"+eval("self.frames[2].document.BCLSchDetail_form.time_table_type"+i).value+"|"+eval("self.frames[2].document.BCLSchDetail_form.no_slots_to_be_blocked"+i).value+"|"+eval("self.frames[2].document.BCLSchDetail_form.total_first_visits_blocked"+i).value+"|"+eval("self.frames[2].document.BCLSchDetail_form.nooffirstvisits"+i).value+"|"+eval("self.frames[2].document.BCLSchDetail_form.total_other_visits_blocked"+i).value+"|"+eval("self.frames[2].document.BCLSchDetail_form.noofothervisits"+i).value;
						if(i==0){
							selValues1=Obj.vals[i].value+"|"+eval("self.frames[2].document.BCLSchDetail_form.time_table_type"+i).value+"|"+eval("self.frames[2].document.BCLSchDetail_form.no_slots_to_be_blocked"+i).value+"|"+eval("self.frames[2].document.BCLSchDetail_form.total_first_visits_blocked"+i).value+"|"+eval("self.frames[2].document.BCLSchDetail_form.nooffirstvisits"+i).value+"|"+eval("self.frames[2].document.BCLSchDetail_form.total_other_visits_blocked"+i).value+"|"+eval("self.frames[2].document.BCLSchDetail_form.noofothervisits"+i).value;;
						}else{
							selValues1+='-'+Obj.vals[i].value+"|"+eval("self.frames[2].document.BCLSchDetail_form.time_table_type"+i).value+"|"+eval("self.frames[2].document.BCLSchDetail_form.no_slots_to_be_blocked"+i).value+"|"+eval("self.frames[2].document.BCLSchDetail_form.total_first_visits_blocked"+i).value+"|"+eval("self.frames[2].document.BCLSchDetail_form.nooffirstvisits"+i).value+"|"+eval("self.frames[2].document.BCLSchDetail_form.total_other_visits_blocked"+i).value+"|"+eval("self.frames[2].document.BCLSchDetail_form.noofothervisits"+i).value;;
						}
					}else{
						if(i==0){
							selValues1=Obj.vals[i].value;
						}else{
							selValues1=selValues1+'-'+Obj.vals[i].value;
						}
					}						
					flag=false;
					sel++;
				}
			}
			selValues+=selValues1;
		}else{
			selValues ="";
			flag=true;
		}
		if(self.frames[2].document.forms[0].no_of_rec.value=='1'){
			if(obj.checked){
				if(blk_time_from!="" && blk_time_to!=""){
					selValues1=Obj.vals.value+"|"+eval("self.frames[2].document.BCLSchDetail_form.time_table_type0").value+"|"+eval("self.frames[2].document.BCLSchDetail_form.no_slots_to_be_blocked0").value+"|"+eval("self.frames[2].document.BCLSchDetail_form.total_first_visits_blocked0").value+"|"+eval("self.frames[2].document.BCLSchDetail_form.nooffirstvisits0").value+"|"+eval("self.frames[2].document.BCLSchDetail_form.total_other_visits_blocked0").value+"|"+eval("self.frames[2].document.BCLSchDetail_form.noofothervisits0").value;
				}else{
				   selValues1=Obj.vals.value
				}
				selValues+=selValues1;
				flag=false;
				sel++;
			}
		}
		self.frames[2].document.forms[0].sel_rec.value = sel;
		self.frames[2].document.forms[0].final_vals.value=selValues;
		if(flag !=true){
			if(self.frames[2].document.forms[0].final_vals.value == '' || self.frames[2].document.forms[0].final_vals.value == null){
				var msg = self.frames[2].getMessage("INVALID_SELECT","OA");
				self.frames[3].location.href = '../../eCommon/jsp/error.jsp?err_num='+msg+'&err_value=0' ;
			}else{
				if(checkFields(fields,names,self.frames[3])){
					self.frames[2].document.forms[0].submit();
				}
			}
		}else{
			if(self.frames[2].document.forms[0].final_vals.value == '' || self.frames[2].document.forms[0].final_vals.value == null){
				var msg = self.frames[2].getMessage("INVALID_SELECT","OA");
				self.frames[3].location.href = '../../eCommon/jsp/error.jsp?err_num='+msg+'&err_value=0' ;
			}else{
				var msg = self.frames[2].getMessage("CANCEL_SCHEDULE_APPT_EXISTS","OA");
				if(confirm(msg)){
					self.frames[2].document.forms[0].submit();
				}else{
					self.frames[3].location.href="../../eCommon/jsp/error.jsp?err_num=" ;
				}
			}
		}
	}else{
		if(checkFields(fields,names,self.frames[3])){
			if(self.frames[2].document.forms[0]){
				self.frames[2].document.forms[0].submit();
			}else{
				self.frames[3].location.href="../../eCommon/jsp/error.jsp?err_num=" ;
			}
		}
	}
}

function generateReport()
{
	if(parent.frames[2].document.forms[0])
  {
	var n = parent.frames[2].document.forms[0].no_of_rec.value;
	var e=0;
	var p="";
	var sel=0;

	for(var k=0;k<n;k++)
	{
		if(parent.frames[2].document.forms[0].elements(e).checked == false)
		{
			p += parent.frames[2].document.forms[0].elements(e+1).value + "-";
			sel++;
		}
		e+=2;
	}
	
	//alert("p"+p);
	parent.frames[2].document.forms[0].final_vals.value = p;
	parent.frames[2].document.forms[0].sel_rec.value = sel	;	
	parent.frames[2].document.forms[0].reportbut.value = "Y"	;
	

	if(parent.frames[1].document.forms[0].action.value =='B')	
	{
	   parent.frames[2].document.forms[0].P_Report_Title.value ='List_of_Appointments_for_Blocking';	
	   parent.frames[2].document.forms[0].P_Action.value ='Block_Schedule';
	}   
	else if(parent.frames[1].document.forms[0].action.value =="L")
	{
	   parent.frames[2].document.forms[0].P_Report_Title.value ="List_of_Appointments_for_Unblocking";   
	   parent.frames[2].document.forms[0].P_Action.value ='UnBlock_Schedule';
	 }  
	else
	{
	   parent.frames[2].document.forms[0].P_Report_Title.value ="List_of_Appointments_for_Cancellation" ;  	
	   parent.frames[2].document.forms[0].P_Action.value ='Cancel_Schedule';
	}  
	parent.frames[2].document.forms[0].submit();
  }	
  else
   {
	parent.frames[1].document.forms[0].only_header.value="Y";
	var n = parent.frames[1].document.forms[0].location.value;
	var arr =  new Array();
	arr = n.split("|");
	var locncode = arr[0];	
	
	parent.frames[1].document.forms[0].P_Clinic_Code.value = locncode;
	
	parent.frames[1].document.forms[0].P_From_Date.value =parent.frames[1].document.forms[0].eff_from.value;
	parent.frames[1].document.forms[0].P_To_Date.value = parent.frames[1].document.forms[0].eff_to.value;
	parent.frames[1].document.forms[0].P_Reason.value = parent.frames[1].document.forms[0].reason.value;
	parent.frames[1].document.forms[0].P_Day_No.value = parent.frames[1].document.forms[0].day.value;
	parent.frames[1].document.forms[0].P_Practitioner_Id.value = parent.frames[1].document.forms[0].practitioner.value;
	
	if(parent.frames[1].document.forms[0].action.value =='B')
	{
	   parent.frames[1].document.forms[0].P_Report_Title.value ='List_of_Appointments_for_Blocking';	
	   parent.frames[1].document.forms[0].P_Action.value ='Block_Schedule';
	}  
	else if(parent.frames[1].document.forms[0].action.value =="L")
	{
	   parent.frames[1].document.forms[0].P_Report_Title.value ="List_of_Appointments_for_Unblocking";   
	   parent.frames[1].document.forms[0].P_Action.value ='UnBlock_Schedule';
	}  
	else
	{
	   parent.frames[1].document.forms[0].P_Report_Title.value ="List_of_Appointments_for_Cancellation" ;  
	   parent.frames[1].document.forms[0].P_Action.value ='Cancel_Schedule';
	}  
	parent.frames[1].document.forms[0].submit();
   }	
		
}

function blank_chk(Obj)
{
	parent.frames[3].location.href = '../../eCommon/jsp/error.jsp';
	var fields = new Array();
	var names = new Array ();
    if (parent.frames[1].document.getElementById("imgpract").style.visibility=="hidden")
    {
		fields[0]= parent.frames[1].document.forms[0].location;
		fields[1]= parent.frames[1].document.forms[0].resourceType;
		fields[2]= parent.frames[1].document.forms[0].eff_from;
		fields[3]= parent.frames[1].document.forms[0].eff_to;
		fields[4]= parent.frames[1].document.forms[0].action;
		fields[5]= parent.frames[1].document.forms[0].reason;

		names[0] = getLabel("Common.Location.label","Common");
		names[1] = getLabel("Common.resourceclass.label","Common");
		names[2] = getLabel("Common.fromdate.label","Common");
		names[3] = getLabel("Common.todate.label","Common");
		names[4] = getLabel("Common.action.label","Common");
		names[5] = getLabel("Common.reason.label","Common");

		/*Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114*/
		if(parent.frames[1].document.forms[0].remarks_img.style.visibility == 'visible')
		{
			fields[6] = parent.frames[1].document.forms[0].other_remarks;
			names[6] = getLabel("Common.remarks.label","Common");
		}
		/*End ML-MMOH-CRF-1114*/

	}
	else
	{
		fields[0]= parent.frames[1].document.forms[0].location;
		fields[1]= parent.frames[1].document.forms[0].resourceType;
		fields[2]= parent.frames[1].document.forms[0].practitioner_name;
		fields[3]= parent.frames[1].document.forms[0].eff_from;
		fields[4]= parent.frames[1].document.forms[0].eff_to;
		fields[5]= parent.frames[1].document.forms[0].action;
		fields[6]= parent.frames[1].document.forms[0].reason;

		names[0] = getLabel("Common.Location.label","Common");
		names[1] = getLabel("Common.resourceclass.label","Common");
		names[2] = getLabel("Common.resourcename.label","Common");
		names[3] = getLabel("Common.fromdate.label","Common");
		names[4] = getLabel("Common.todate.label","Common");
		names[5] = getLabel("Common.action.label","Common");
		names[6] = getLabel("Common.reason.label","Common");

		/*Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114*/
		if(parent.frames[1].document.forms[0].remarks_img.style.visibility == 'visible')
		{
			fields[7] = parent.frames[1].document.forms[0].other_remarks;
			names[7] = getLabel("Common.remarks.label","Common");
		}
		/*End ML-MMOH-CRF-1114*/

	}


	if(checkFields(fields,names,parent.frames[3]))
	{
		if(Obj == "reportbut")
			generateReport();
		else if(Obj == "Select")
			show_details();
	}
}

function show_details()
{
	parent.frames[1].document.forms[0].reportbut.disabled = true;
	var efffrom = parent.frames[1].document.forms[0].eff_from.value;
	var effto = parent.frames[1].document.forms[0].eff_to.value;
	var action = parent.frames[1].document.forms[0].action.value;

   
	var day_1 = parent.frames[1].document.forms[0].mon.value;
	var day_2 = parent.frames[1].document.forms[0].tue.value;
	var day_3 = parent.frames[1].document.forms[0].wed.value;
	var day_4 = parent.frames[1].document.forms[0].thu.value;
	var day_5 = parent.frames[1].document.forms[0].fri.value;
	var day_6 = parent.frames[1].document.forms[0].sat.value;
	var day_7 = parent.frames[1].document.forms[0].sun.value;

	
	var practid = parent.frames[1].document.forms[0].practitioner.value;
	var n = parent.frames[1].document.forms[0].location.value;
	var locntype =parent.frames[1].document.forms[0].location_type.value;
	var resourcetype =parent.frames[1].document.forms[0].resourceType1.value;
	var blk_time_from ="";
	var blk_time_to ="";
	if(action=="B"){
		blk_time_from =parent.frames[1].document.forms[0].blk_time_from.value;
		blk_time_to =parent.frames[1].document.forms[0].blk_time_to.value;
	}
	var arr =  new Array();
	arr = n.split("|");
	var locncode = arr[0];
	var res = parent.frames[1].document.forms[0].reason.value;
	var res_desc = parent.frames[1].document.forms[0].reason_desc.value;

	/*Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114*/
  /*Commented by KAMATCHI S for ML-MMOH-CRF-1390*/
	/*if(parent.frames[1].document.forms[0].remarks_img.style.visibility == 'visible')
	{*/
		var other_remarks = parent.frames[1].document.forms[0].other_remarks.value;
	/*}else
	{
		var other_remarks = "";
	}*/
	/*End ML-MMOH-CRF-1114*/

//Commented By Dharma against 057755 on 25th Sep 2015
/*	if(blk_time_from!="" && blk_time_to!=""){
		
		alert(getMessage("FREE_FORMAT_SCH_BLOCK","OA"));
	}*/


//var url='../../eOA/jsp/addmodifyBlockLiftCancelSchDetail.jsp?eff_from='+efffrom+'&eff_to='+effto+'&action='+action+'&pract_id='+practid+'&locn_code='+locncode+'&reason='+res+'&reason_desc='+res_desc+'&resourcetype='+resourcetype+'&locntype='+locntype;
var url='../../eOA/jsp/addmodifyBlockLiftCancelSchDetail.jsp?eff_from='+efffrom+'&eff_to='+effto+'&action='+action+'&pract_id='+practid+'&locn_code='+locncode+'&reason='+res+'&reason_desc='+res_desc+'&resourcetype='+resourcetype+'&locntype='+locntype+'&day_1='+day_1+'&day_2='+day_2+'&day_3='+day_3+'&day_4='+day_4+'&day_5='+day_5+'&day_6='+day_6+'&day_7='+day_7+'&blk_time_from='+blk_time_from+'&blk_time_to='+blk_time_to+'&other_remarks='+other_remarks;
parent.frames[2].location.href=url;
}

function reset() {
		
		parent.frames[2].frames[1].location.href = '../../eOA/jsp/addmodifyBlockLiftCancelSch.jsp' ;
		parent.frames[2].frames[2].location.href = '../../eCommon/html/blank.html' ;



}


	



function validate_date_from(obj,obj1)
{
	if(obj.value!="")
	{
	if(!validDateObj(obj,"DMY",localeName))
		{
			obj.value="";
			return ;
		}
		var sysdt = parent.frames[1].document.forms[0].sys_date.value;
		var obj2=convertDate(obj.value,"DMY",localeName,"en");
		if(isBefore(sysdt,obj2,'DMY',"en")==false)
				{
				alert(getMessage("FROM_DATE_LESS_SYSDATE","SM"));
				obj.value="";
				obj.select();	
				return false;
			}
			
	}
	
		


	if(obj.value!="" && obj1.value!="" )
		{
	
			if(isBefore(obj.value,obj1.value,'DMY',localeName)==false)
				{
				var msg = getMessage('TO_DT_GR_EQ_FM_DT','SM');
				alert(msg);
				obj.value="";
				obj.select();					
				return false;
			}
			else
				return true;
		}


}

function validate_date_to(obj,obj1)
{
	if(obj.value!="")
	{
	if(!validDateObj(obj,"DMY",localeName))
		{
			obj.value="";
			return ;
		}
			var sysdt = parent.frames[1].document.forms[0].sys_date.value;
		var obj2=convertDate(obj.value,"DMY",localeName,"en");
		if(isBefore(sysdt,obj2,'DMY',"en")==false)
				{
				alert(getMessage("TO_DATE_LESS_SYSDATE","SM"));
				obj.value="";
				obj.select();	
				return false;
			}
	}

	if(obj.value!="" && obj1.value!="" )
		{
	
			if(isBefore(obj1.value,obj.value,'DMY',localeName)==false)
				{
				var msg = getMessage('TO_DT_GR_EQ_FM_DT','SM');
				alert(msg);
				obj.value="";
				obj.select();					
				return false;
			}
			else
				return true;
		}


}


function onSuccess() 
{
		
	var efffrom = frames[1].document.forms[0].eff_from.value;
	var effto = frames[1].document.forms[0].eff_to.value;
	var action = frames[1].document.forms[0].action.value;
	//var day = frames[1].document.forms[0].day.value;
	var day_1 = frames[1].document.forms[0].mon.value;
	var day_2 = frames[1].document.forms[0].tue.value;
	var day_3 = frames[1].document.forms[0].wed.value;
	var day_4 = frames[1].document.forms[0].thu.value;
	var day_5 = frames[1].document.forms[0].fri.value;
	var day_6 = frames[1].document.forms[0].sat.value;
	var day_7 = frames[1].document.forms[0].sun.value;
	var practid = frames[1].document.forms[0].practitioner.value;
	var n = frames[1].document.forms[0].location.value;
	var locntype =frames[1].document.forms[0].location_type.value;
	var resourcetype =frames[1].document.forms[0].resourceType1.value;
	var blk_time_from=frames[1].document.forms[0].blk_time_from.value;
	var blk_time_to=frames[1].document.forms[0].blk_time_to.value;
	var arr =  new Array();
	arr = n.split("|");
	var locncode = arr[0];
	var res = frames[1].document.forms[0].reason.value;
	var res_desc = frames[1].document.forms[0].reason_desc.value;
	var url='../../eOA/jsp/addmodifyBlockLiftCancelSchDetail.jsp?eff_from='+efffrom+'&eff_to='+effto+'&action='+action+'&day_1='+day_1+'&day_2='+day_2+'&day_3='+day_3+'&day_4='+day_4+'&day_5='+day_5+'&day_6='+day_6+'&day_7='+day_7+'&pract_id='+practid+'&locn_code='+locncode+'&reason='+res+'&reason_desc='+res_desc+'&resourcetype='+resourcetype+'&locntype='+locntype+"&blk_time_from="+blk_time_from+"&blk_time_to="+blk_time_to;
	
	
		parent.frames[2].frames[2].location.href = url ;
}
function clearDetail(X){
	document.BlockLiftCancelSch_form.location_type.value="";
	document.BlockLiftCancelSch_form.b_loc_val.value="";
	document.BlockLiftCancelSch_form.location.value="";
	document.BlockLiftCancelSch_form.resourceType.value="";
	document.BlockLiftCancelSch_form.practitioner.value="";
	document.BlockLiftCancelSch_form.practitioner_name.value="";
	document.BlockLiftCancelSch_form.eff_from.value="";
	document.BlockLiftCancelSch_form.eff_to.value="";
	document.BlockLiftCancelSch_form.blk_time_from.value="";
	document.BlockLiftCancelSch_form.blk_time_to.value="";

	if(X.value==""){
		var res=document.forms[0].resourceType;
		while(res.options.length>0) res.remove(res.options[0]);
		opt=document.createElement('OPTION');
		opt.value='';
		opt.text='----'+getLabel("Common.defaultSelect.label","Common")+'----';
		res.add(opt);
		opt=document.createElement('OPTION');
		opt.value='P';
		opt.text=getLabel("Common.practitioner.label","Common");
		res.add(opt);
		opt=document.createElement('OPTION');
		opt.value='E';
		opt.text=getLabel("Common.equipment.label","Common");
		res.add(opt);
		opt=document.createElement('OPTION');
		opt.value='R';
		opt.text=getLabel("Common.room.label","Common");
		res.add(opt);
		opt=document.createElement('OPTION');
		opt.value='O';
		opt.text=getLabel("Common.other.label","Common");
		res.add(opt);
		document.getElementById("blockTimeID").style.visibility="hidden";
		document.getElementById("blockTimeNameID").style.visibility="hidden";
	}else{
		var action=document.forms[0].action.value;
		if(action=="C"){
			document.getElementById("blockTimeID").style.visibility="hidden";
			document.getElementById("blockTimeNameID").style.visibility="hidden";
			var res=document.forms[0].resourceType;
			while(res.options.length>0) res.remove(res.options[0]);
			opt=document.createElement('OPTION');
			opt.value='';
			opt.text='----'+getLabel("Common.defaultSelect.label","Common")+'----';
		    res.add(opt);
			opt=document.createElement('OPTION');
			opt.value='P';
			opt.text=getLabel("Common.practitioner.label","Common");
			res.add(opt);
			opt=document.createElement('OPTION');
			opt.value='E';
			opt.text=getLabel("Common.equipment.label","Common");
			res.add(opt);
			opt=document.createElement('OPTION');
			opt.value='R';
			opt.text=getLabel("Common.room.label","Common");
			res.add(opt);
			opt=document.createElement('OPTION');
			opt.value='O';
			opt.text=getLabel("Common.other.label","Common");
			res.add(opt);
		}else{
		
		//  below coding added by venkatesh.S (4008) on 27/Feb/2012 aganist  SS-SCF-0621 [IN028239]
		   document.getElementById("blockTimeID").style.visibility="hidden";
			document.getElementById("blockTimeNameID").style.visibility="hidden";
			var res=document.forms[0].resourceType;
			while(res.options.length>0) res.remove(res.options[0]);
			opt=document.createElement('OPTION');
			opt.value='';
			opt.text='----'+getLabel("Common.defaultSelect.label","Common")+'----';
		    res.add(opt);
			opt=document.createElement('OPTION');
			opt.value='P';
			opt.text=getLabel("Common.practitioner.label","Common");
			res.add(opt);
			opt=document.createElement('OPTION');
			opt.value='E';
			opt.text=getLabel("Common.equipment.label","Common");
			res.add(opt);
			opt=document.createElement('OPTION');
			opt.value='R';
			opt.text=getLabel("Common.room.label","Common");
			res.add(opt);
			opt=document.createElement('OPTION');
			opt.value='O';
			opt.text=getLabel("Common.other.label","Common");
			res.add(opt);
			// //   SS-SCF-0621 [IN028239] incident code fix end.
			
			
			//below 10 lines i have commented for  SS-SCF-0621 [IN028239]
			/*var res=document.forms[0].resourceType;
			while(res.options.length>0) res.remove(res.options[0]);
			opt=document.createElement('OPTION');
			opt.value='';
			opt.text='----'+getLabel("Common.defaultSelect.label","Common")+'----';
		    res.add(opt);
			opt=document.createElement('OPTION');
			opt.value='P';
			opt.text=getLabel("Common.practitioner.label","Common");
			res.add(opt); */
			if(action=="B"){
				document.getElementById("blockTimeID").style.visibility='visible';
				document.getElementById("blockTimeNameID").style.visibility='visible'; 
			}else{  
				document.getElementById("blockTimeID").style.visibility="hidden";
				document.getElementById("blockTimeNameID").style.visibility="hidden";
			}
		}
		/*if(document.getElementById("location").value==''){
			document.getElementById("resourceType").value='';
			document.getElementById("resourceType").disabled=true;
			document.getElementById("practitioner_name").disabled=true;
		document.getElementById("search_pract").disabled=true;
		}else{
			document.getElementById("resourceType").disabled=false;
			document.getElementById("practitioner_name").disabled=false;
		document.getElementById("search_pract").disabled=false;
		}

		document.getElementById("resourceType").value="";
		document.getElementById("practitioner_name").value='';
		document.getElementById("practitioner_name").disabled=true;
		document.getElementById("search_pract").disabled=true;
		document.getElementById("practitioner").value='';*/
	}
	parent.frames[2].location.href = '../../eCommon/html/blank.html' ;
    document.getElementById('reportbut').disabled=true;
		document.forms[0].reason_desc.value="";
		document.forms[0].reason.value="";


}


function enable_dsiable_res(Obj){
	var arr1=document.getElementById("location").value;
	var arr2=arr1.split("|");
	var pri_res_class=arr2[4];
	
	//document.getElementById("action").disabled=false;
	//document.getElementById("action").value='';
	//clearDetail('X');
	//popReason(document.getElementById("action"))

	document.getElementById("practitioner").value='';
	document.getElementById("practitioner_name").value='';
	if(Obj.value==''){
		document.getElementById("practitioner_name").disabled=true;
		document.getElementById("search_pract").disabled=true;
	}else{
		document.getElementById("practitioner_name").disabled=false;
		document.getElementById("search_pract").disabled=false;
		if(Obj.value!=pri_res_class){
			//document.getElementById("action").value='C';
			//clearDetail('X');
			//popReason(document.getElementById("action"))
			//document.getElementById("action").disabled=true;
			 
		}
			 

	}

	document.getElementById("resourceType1").value=Obj.value;
	parent.frames[2].location.href = '../../eCommon/html/blank.html' ;
	document.getElementById("reportbut").disabled=true;

}

function populateLocations(Obj){
	/*var xmlDoc = ""
	var xmlHttp = new XMLHttpRequest()
	xmlStr ="<root><SEARCH clinic_type=\""+Obj.value+"\" steps='6' /></root>"
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
	xmlHttp.open("POST","ServerSide.jsp",false)
	xmlHttp.send(xmlDoc)
	responseText=xmlHttp.responseText
	responseText = trimString(responseText)
	eval(responseText)*/ 

	if(Obj.value==null||Obj.value==""){
	document.forms[0].b_loc_val.value="";
	document.getElementById("location").value="";
	document.forms[0].b_loc_val.disabled=true;
	document.forms[0].b_loc_search.disabled=true;	
	}else{
	document.forms[0].b_loc_val.value="";
	document.getElementById("location").value="";
	document.forms[0].b_loc_val.disabled=false;
	document.forms[0].b_loc_search.disabled=false;	
	}

	PopPract(document.getElementById("location"))
	parent.frames[2].location.href = '../../eCommon/html/blank.html' ;
	document.getElementById("reportbut").disabled=true;
	document.getElementById("practitioner_name").value='';
	document.getElementById("practitioner_name").disabled=true;
	document.getElementById("search_pract").disabled=true;
	document.forms[0].resourceType.disabled=true;
	document.forms[0].resourceType.value="";
	document.getElementById("practitioner").value='';

}

/* Added by Manish Anand on 16-08-2002 to populate the reason for blocking or lifting the block */
function popReason(obj){
	
		var reasonType = obj.value;
		
document.forms[0].sch_value.value=obj.value;
//document.forms[0].reason_desc.value="";
//document.forms[0].reason.value="";

}


async function reasonlookup(obj){
	var sql;
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var target="";
	var reasonType=document.forms[0].sch_value.value;
	var locale=document.forms[0].locale.value;
	if(reasonType=="B"){
		sql="select contact_reason_code code, contact_reason description from am_contact_reason_lang_vw where eff_status='E' and block_schedule_yn ='Y' and  language_id='"+locale+"' and upper(contact_reason_code) like upper(?) and upper(contact_reason) like upper(?) order by contact_reason";
	}else if(reasonType=="L"){
		sql="select contact_reason_code code, contact_reason  description from am_contact_reason_lang_vw where eff_status='E' and lift_schedule_yn ='Y' and  language_id='"+locale+"' and upper(contact_reason_code) like upper(?) and upper(contact_reason) like upper(?) order by contact_reason";
	}else if(reasonType=='C'){
		sql="select contact_reason_code code, contact_reason description from am_contact_reason_lang_vw where eff_status='E' and cancel_schedule_yn ='Y' and  language_id='"+locale+"'  and upper(contact_reason_code) like upper(?) and upper(contact_reason) like upper(?) order by contact_reason";
	}else{
		document.forms[0].reason_desc.value="";
		document.forms[0].reason.value="";
	}
	if(reasonType =='B' || reasonType=='L' || reasonType=='C'){
		argumentArray[0] = sql ;
		argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4] = "1,2";
		argumentArray[5] = document.forms[0].reason_desc.value;
		argumentArray[6] = CODE_LINK ;
		argumentArray[7] = CODE_DESC ; 
		retVal = await CommonLookup( getLabel("Common.reason.label","Common"), argumentArray );
		var arr=new Array();
		if (retVal != null && retVal != '' && retVal != "null"){
			var retVal=unescape(retVal);
			arr=retVal.split(",");
			var desc=arr[1];
			var code=arr[0];
			document.forms[0].reason.value=code;
			document.forms[0].reason_desc.value=desc;
		}else{
			document.forms[0].reason_desc.value="";
			document.forms[0].reason.value="";
		}
	}else{
		document.forms[0].reason_desc.value="";
		document.forms[0].reason.value="";
	}	
}
/* Based on the location selected pract_butt is enabled and selected */
function PopPract(obj){
	
		document.forms[0].practitioner_name.value ="";
		document.forms[0].practitioner.value="";
		var  HTMLVal = new String();
		//clear_list(parent.frames[1].document.forms[0].day);
		locn = obj.value;
		//alert("locn value"+locn);
		/*if (locn == null || locn == '')
		{
			if(document.forms[0].all.locn_type)
			document.forms[0].all.locn_type.innerText = '';
			
			//var opt = parent.document.frames[1].document.createElement("OPTION");
			//opt.value='';
			//opt.text='----'+getLabel("Common.defaultSelect.label","Common")+'----';

		//parent.frames[1].document.forms[0].day.add(opt);

		}
			

		var p_clinic_code		= document.forms[0].location.value;
		
       document.getElementById("location_code1").value= p_clinic_code;
		if (locn!=null||locn!=''){
			var temp = new Array();
			temp = locn.split("|");
			if(temp[3]=="P")
			document.getElementById("imgpract").style.visibility='visible'
			else
			document.getElementById("imgpract").style.visibility='hidden'
			}
		else
			document.getElementById("imgpract").style.visibility='hidden'
		if (locn != null || locn != '')
		{
			HTMLVal = "<html><body onKeyDown = 'lockKey()'><form name='dum_form' id='dum_form' method='post' action='../../eOA/jsp/GetValBLCSch.jsp'><input type='hidden' name='locn' id='locn' value='"+locn+"'><input type='hidden' name='pract' id='pract' value=''></form></body></html>";
			parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
			parent.messageFrame.document.dum_form.submit();
		}
		var obj1=document.forms[0].location_type.value;
		if(obj1=='D')
	{
			var res=document.forms[0].resourceType;
		document.forms[0].resourceType.disabled=false;
	 while (res.options.length>0) res.remove(res.options[0]);
	 opt=document.createElement('OPTION');
	 opt.value='';
		opt.text='----'+getLabel("Common.defaultSelect.label","Common")+'----';

	 res.add(opt);
	 opt=document.createElement('OPTION');
	 opt=document.createElement('OPTION');
	   opt.value='P';
	   opt.text=getLabel("Common.practitioner.label","Common");
	   res.add(opt);
	   opt=document.createElement('OPTION');
	   opt.value='E';
	   opt.text=getLabel("Common.equipment.label","Common");
	   res.add(opt);
	   opt=document.createElement('OPTION');
	   opt.value='R';
	   opt.text=getLabel("Common.room.label","Common");
	   res.add(opt);
	 opt=document.createElement('OPTION');
	   opt.value='O';
	   opt.text=getLabel("Common.other.label","Common");
	   res.add(opt);
	
	} else{  
	   var res=document.forms[0].resourceType;
	   while(res.options.length>0) res.remove(res.options[0]);
	   opt=document.createElement('OPTION');
	   	opt.value='';
		opt.text='----'+getLabel("Common.defaultSelect.label","Common")+'----';
	   res.add(opt);
	   opt=document.createElement('OPTION');
	   opt.value='P';
	   opt.text=getLabel("Common.practitioner.label","Common");
	   res.add(opt);
	   opt=document.createElement('OPTION');
	   opt.value='E';
	   opt.text=getLabel("Common.equipment.label","Common");
	   res.add(opt);
	   opt=document.createElement('OPTION');
	   opt.value='R';
	   opt.text=getLabel("Common.room.label","Common");
	   res.add(opt);
	   opt=document.createElement('OPTION');
	   opt.value='O';
	   opt.text=getLabel("Common.other.label","Common");
	   res.add(opt);
   
	}
   return obj1;*/

     var arr =  new Array();


		if(obj.value !=''){
			arr = (obj.value).split("|");
			var lcode = arr[0];
			var ltype = arr[1];
			var ltxt = obj.value;
			var locnCode=document.forms[0].location_type.value;

			var locnObj=document.forms[0].location_type;
			var selIndex=locnObj.options.selectedIndex;
			var sys_date=document.forms[0].sys_date.value;
		//	alert("locnCode"+locnCode);
			//alert("selIndex"+selIndex);
			var day_1 = document.forms[0].wday_1.value;		
			//alert("day1 values in side popPract"+day_1);
			var day_2 = document.forms[0].wday_2.value;
			var day_3 = document.forms[0].wday_3.value;
			var day_4 = document.forms[0].wday_4.value;
			var day_5 = document.forms[0].wday_5.value;
			var day_6 = document.forms[0].wday_6.value;
			var day_7 = document.forms[0].wday_7.value;

			if (locn != null || locn != '')
		{
			//alert("locnCode inside"+locnCode);
			HTMLvalue="<html><body onKeyDown = 'lockKey()'><form name='dum_form' id='dum_form' method='post' action='../../eOA/jsp/GetValBLCSch.jsp'><input type='hidden' name='locn' id='locn' value='"+locn+"'><input type='hidden' name='pract' id='pract' value=''><input type=hidden name='clinic_code' id='clinic_code' value='"+lcode+"'><input type=hidden name='clinic_type' id='clinic_type' value='"+ltype+"'><input type=hidden name='text' id='text' value='"+ltxt+"'><input type=hidden name='selIndex' id='selIndex' value='"+selIndex+"'><input type=hidden name='resourceCode' id='resourceCode' value='"+locnCode+"'><input type=hidden name='day_1' id='day_1' value='"+day_1+"'><input type=hidden name='day_2' id='day_2' value='"+day_2+"'><input type=hidden name='day_3' id='day_3' value='"+day_3+"'><input type=hidden name='day_4' id='day_4' value='"+day_4+"'><input type=hidden name='day_5' id='day_5' value='"+day_5+"'><input type=hidden name='day_6' id='day_6' value='"+day_6+"'><input type=hidden name='day_7' id='day_7' value='"+day_7+"'></form></body></html>";
			//alert(HTMLvalue);
            parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLvalue);
			parent.messageFrame.document.dum_form.submit();
			
		}
		}
	
}

function clear_list(obj)
{
			while ( obj.options.length > 0 )
			obj.remove(obj.options[0]);
}


function gen_report()
{
	var fields = new Array ( document.forms[0].location,
				 document.forms[0].eff_from,
				 document.forms[0].eff_to,
				 document.forms[0].action,
				 document.forms[0].reason);
	var names = new Array (getLabel("Common.Location.label","Common"),
							getLabel("Common.fromdate.label","Common"),
							getLabel("Common.todate.label","Common"),
							getLabel("Common.action.label","Common"),
							getLabel("Common.reason.label","Common")

  			      );

	if(checkFields(fields,names,parent.frames[3])){
			//var pract_from_desc		= document.forms[0].practitioner_name.value;
			var p_clinic_code		= document.forms[0].location.value;
			
			var arr =new Array();
			arr=p_clinic_code.split('|');
			p_clinic_code = arr[0];
			var p_day_no ="";
			var day_1="";
			var day_2="";
			var day_3="";
			var day_4="";
			var day_5="";
			var day_6="";
			var day_7="";
			if(document.BlockLiftCancelSch_form.mon.value=="Y"){
				day_1="1";
			}else{
				day_1="0";
			}
			if(document.BlockLiftCancelSch_form.tue.value=="Y"){
				day_2="2";
			}else{
				day_2="0";
			}
			if(document.BlockLiftCancelSch_form.wed.value=="Y"){
				day_3="3";
			}else{
				day_3="0";
			}
			if(document.BlockLiftCancelSch_form.thu.value=="Y"){
				day_4="4";
			}else{
				day_4="0";
			}
			if(document.BlockLiftCancelSch_form.fri.value=="Y"){
				day_5="5";
			}else{
				day_5="0";
			}
			if(document.BlockLiftCancelSch_form.sat.value=="Y"){
				day_6="6";
			}else{
				day_6="0";
			}
			if(document.BlockLiftCancelSch_form.sun.value=="Y"){
				day_7="7";
			}else{
				day_7="0";
			}
			p_day_no=day_1+day_2+day_3+day_4+day_5+day_6+day_7;
			if(document.BlockLiftCancelSch_form.mon.value=="N" & document.BlockLiftCancelSch_form.tue.value=="N" &&document.BlockLiftCancelSch_form.wed.value=="N" && document.BlockLiftCancelSch_form.thu.value=="N" && document.BlockLiftCancelSch_form.fri.value=="N" && document.BlockLiftCancelSch_form.sat.value=="N" && document.BlockLiftCancelSch_form.sun.value=="N"){
				p_day_no="1234567";
			}
			var p_facility_id		= document.forms[0].P_Facility_id.value;		 
			//var p_from_date			= document.forms[0].eff_from.value;
			//var p_to_date			= document.forms[0].eff_to.value;
//Commented the above line and converted the date below for IN031167 by Suresh M on 06.03.2012
			var p_from_date			= convertDate(document.forms[0].eff_from.value,"DMY",localeName,"en");			
			var p_to_date			= convertDate(document.forms[0].eff_to.value,"DMY",localeName,"en");
		    var p_practitioner_id	= document.forms[0].practitioner.value;
			var p_action            = document.forms[0].action.value; 
			var reason1				= document.forms[0].reason.value;
			var p_care_locn_type_ind =document.forms[0].location_type.value;
			var p_resource_class=document.forms[0].resourceType.value;

		

			var HtmlVal = "<html><head></head><body onKeyDown = 'lockKey()'><form name='dummy1_form' id='dummy1_form' action='../../eCommon/jsp/report_options.jsp'><input type='hidden' name='p_day_no' id='p_day_no' value='"+p_day_no+"'><input type='hidden' name='p_facility_id' id='p_facility_id' value='"+p_facility_id+"'><input type='hidden' name='p_from_date' id='p_from_date' value='"+p_from_date+"'><input type='hidden' name='p_action' id='p_action' value='"+p_action+"'><input type='hidden' name='p_clinic_code' id='p_clinic_code' value='"+p_clinic_code+"'><input type='hidden' name='p_to_date' id='p_to_date' value='"+p_to_date+"'><input type='hidden' name='p_practitioner_id' id='p_practitioner_id' value='"+p_practitioner_id+"'><input type='hidden' name='p_reason' id='p_reason' value='"+reason1+"'><input type='hidden' name='p_report_id' id='p_report_id' value='OAAFAPLST'><input type='hidden' name='p_module_id' id='p_module_id' value='OA'><input type='hidden' name='care_locn_type_ind' id='care_locn_type_ind' value='"+p_care_locn_type_ind+"'><input type='hidden' name='reason1' id='reason1' value='"+reason1+"'><input type='hidden' name='resource_class' id='resource_class' value='"+p_resource_class+"'><input type='hidden' name='p_language_id' id='p_language_id' value='"+localeName+"'> </form></body></html>"
			 
			   parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HtmlVal);
			   parent.messageFrame.document.dummy1_form.submit();
	 }
}

	function no_sch() 
	{
		alert(getMessage("SCH_NOT_DEFINED","OA"));
	}

	async function show_modwin(Clcode,pid,Cldate,clinic_day1,clinic_type,res_type){
		
		var retVal;
		var dialogHeight = "38" ;
		var dialogWidth  = "65" ;
		var dialogTop    = "85";
		var dialogLeft   = "40";
		var locncode 	 = Clcode;
		var practid  	 = pid;
		var currdate 	 = Cldate;
		
		var features     = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" +dialogLeft+ "; dialogTop:" +dialogTop+ "; status=no" ;
		var arguments    = "" ;		
		
		retVal 	 	 = await window.showModalDialog("../../eOA/jsp/DispListAppointments.jsp?clinic_code="+locncode+"&practitioner_id="+practid+"&res_type="+res_type+"&clinic_type="+clinic_type+"&Date="+currdate+"&clinic_day1="+clinic_day1+"&currdate="+currdate+"&mod=tfr",arguments,features);
					
	}


function disableFields(){
document.forms[0].action.focus();
document.forms[0].b_loc_val.disabled=true;
document.forms[0].b_loc_search.disabled=true;
}

async function open_loc_lookup(){
	var location_val=document.forms[0].b_loc_val.value;
	var locn_type=document.forms[0].location_type.value;
	var care_locn_ind=document.forms[0].location_type.value;
	//var dialogTop = "60" ;
	//var dialogHeight= "37" ;
	//var dialogWidth	= "60" ;
	var dialogTop = "10px" ;
	var dialogHeight= "400px" ;
	var dialogWidth	= "700px" ;
	var status = "no";
	var arguments	= "" ;
	var tit="locn_Srch";
	var retVal="";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
	retVal = await window.showModalDialog("../../eOA/jsp/OALocationlookupframe.jsp?locn_type="+locn_type+"&location_val="+encodeURIComponent(location_val)+"&care_locn_ind="+care_locn_ind+"&function_id=BLK_LIFT_CANC_SCH",arguments,features);
	if(retVal!=null){
		var rvalues=retVal.split("~");
		var code=rvalues[0];
		var desc=rvalues[1];
		var open_to_all_pract_yn=rvalues[2];
		var cType=rvalues[3];
		var identitiy_check_in=rvalues[4];
		var primary_resource_class=rvalues[5];
		document.forms[0].b_loc_val.value=desc;
		document.forms[0].location.value=code+"|"+cType+"|"+open_to_all_pract_yn+"|"+identitiy_check_in+"|"+primary_resource_class;
		//clearDetail();
		PopPract(document.forms[0].location);
		document.forms[0].resourceType.disabled=false;

	}else{
		document.forms[0].b_loc_val.value="";
		document.forms[0].location.value="";
		//clearDetail();
		document.forms[0].resourceType.disabled=true;
		PopPract(document.forms[0].location);
	}

}


function ena_loc_lookup(obj){
		document.getElementById("mon").value="N";
		document.getElementById("mon").checked=false;
		document.getElementById("mon").disabled=true;
		document.getElementById("tue").value="N";
		document.getElementById("tue").checked=false;
		document.getElementById("tue").disabled=true;
		document.getElementById("wed").value="N";
		document.getElementById("wed").checked=false;
		document.getElementById("wed").disabled=true;
		document.getElementById("thu").value="N";
		document.getElementById("thu").checked=false;
		document.getElementById("thu").disabled=true;
		document.getElementById("fri").value="N";
		document.getElementById("fri").checked=false;
		document.getElementById("fri").disabled=true;
		document.getElementById("sat").value="N";
		document.getElementById("sat").checked=false;
		document.getElementById("sat").disabled=true;
		document.getElementById("sun").value="N";
		document.getElementById("sun").checked=false;
		document.getElementById("sun").disabled=true;
		//clearDetail(document.forms[0].action);
		document.forms[0].resourceType.disabled=true;
		if(obj.value==null || obj.value==''){
		document.forms[0].location.value="";
		//clearDetail();
		PopPract(document.forms[0].location);

	}else{
	open_loc_lookup()
	}
}

function selectAll(obj){
	len=document.getElementById("checkBox").length;
	var alertFlag=true;
	var intVal=0;
    if (len!=null){
		if (obj.checked){
			for (i=0;i<len;i++){
				if(document.getElementById("checkBox")[i].disabled==false){
					if(document.forms[0].action.value=="C"){
						if(document.forms[0].no_of_appt[i].value <=0){
							document.getElementById("checkBox")[i].checked=true;
						}
					}else if(document.forms[0].action.value=="B"){
						if(document.forms[0].bulk_blocking_yn.value=="Y"){
							document.getElementById("checkBox")[i].checked=true;
							if(eval("document.forms[0].check_Box"+i).checked){
								var no_slots_to_be_blocked=eval("document.forms[0].no_slots_to_be_blocked"+i).value;
								var total_first_visits_available=eval("document.forms[0].total_first_visits_available"+i).value;
								var total_other_visits_available=eval("document.forms[0].total_other_visits_available"+i).value;
								var nooffirstvisits=eval("document.forms[0].nooffirstvisits"+i).value;
								var noofothervisits=eval("document.forms[0].noofothervisits"+i).value;
								if(no_slots_to_be_blocked==(eval(nooffirstvisits)+eval(noofothervisits))){
									document.getElementById("checkBox")[i].checked=true;
									intVal++;
								}else{
									document.getElementById("checkBox")[i].checked=false;
								}
							}
						}else{
							var checkedValues=document.BCLSchDetail_form.vals[i].value;
							var valArr=checkedValues.split('|');
							if(valArr[5]=="Y"){
								document.getElementById("checkBox")[i].checked=false;
							}else{
								document.getElementById("checkBox")[i].checked=true;
							}
						}
					}else{
						document.getElementById("checkBox")[i].checked=true;
					}
				}
			}
			if(document.forms[0].bulk_blocking_yn.value=="Y" && (intVal!=len)){
				alert(getMessage("TOTAL_BLOCK_SLOTS_MISMATCH","OA"));
				obj.checked=false;
			}
		}else{
			for (i=0;i<len;i++){
				document.getElementById("checkBox")[i].checked=false;
			}
		}
	}else{
		if (obj.checked){
			if(document.getElementById("checkBox").disabled){
				obj.checked=false;
			}else{
				document.getElementById("checkBox").checked=true;
				if(document.forms[0].bulk_blocking_yn.value=="Y"){
					var no_slots_to_be_blocked=eval("document.forms[0].no_slots_to_be_blocked0").value;
					var total_first_visits_available=eval("document.forms[0].total_first_visits_available0").value;
					var total_other_visits_available=eval("document.forms[0].total_other_visits_available0").value;
					var nooffirstvisits=eval("document.forms[0].nooffirstvisits0").value;
					var noofothervisits=eval("document.forms[0].noofothervisits0").value;
					if(no_slots_to_be_blocked==(eval(nooffirstvisits)+eval(noofothervisits))){
						document.getElementById("checkBox").checked=true;
					}else{
						alert(getMessage("TOTAL_BLOCK_SLOTS_MISMATCH","OA"));
						document.getElementById("checkBox").checked=false;
						obj.checked=false;
					}
				}else if(document.forms[0].action.value=="C"){
					if(document.forms[0].no_of_appt.value <=0){
					}else{
						document.getElementById("checkBox").checked=false;
					}
				}else if(document.forms[0].action.value=="B" && document.forms[0].bulk_blocking_yn.value!="Y"){
					var checkedValues=document.BCLSchDetail_form.vals.value;
					var valArr=checkedValues.split('|');
					if(valArr[5]=="Y"){
						document.getElementById("checkBox").checked=false;
					}else{
						document.getElementById("checkBox").checked=true;
					}
				}
			}
			//document.getElementById("checkBox").checked=true;
			/*for (i=0;i<len;i++){
				if(document.getElementById("checkBox")[i].disabled==false){
					if(document.forms[0].action.value=="C"){
						if(document.forms[0].no_of_appt[i].value <=0){
							document.getElementById("checkBox")[i].checked=true;
						}
					}else{
						//alert(document.forms[0].bulk_blocking_yn.value)
						document.getElementById("checkBox")[i].checked=true;
					}
				}
			}*/
		}else{
			//document.getElementById("checkBox").checked=false;
			document.getElementById("checkBox").checked=false;
			/*for (i=0;i<len;i++){
				document.getElementById("checkBox")[i].checked=false;
			}*/
		}
	}
}


function  nextRecs(start,end)
	{
	var flag=false;
	var sel=0;
	
//below line was added by Venkatesh.S(4008) on 13-Mar-2012  against the issue SKR-SCF-0435 [IN:031675] 

	var day_1 = parent.frames[1].document.forms[0].mon.value;
	var day_2 = parent.frames[1].document.forms[0].tue.value;
	var day_3 = parent.frames[1].document.forms[0].wed.value;
	var day_4 = parent.frames[1].document.forms[0].thu.value;
	var day_5 = parent.frames[1].document.forms[0].fri.value;
	var day_6 = parent.frames[1].document.forms[0].sat.value;
	var day_7 = parent.frames[1].document.forms[0].sun.value;
	//end SKR-SCF-0435 [IN:031675] 

	

		parent.frames[1].document.forms[0].reportbut.disabled = true;
	var efffrom = parent.frames[1].document.forms[0].eff_from.value;
	var effto = parent.frames[1].document.forms[0].eff_to.value;
	var action = parent.frames[1].document.forms[0].action.value;
	//var day = parent.frames[1].document.forms[0].day.value;
	var practid = parent.frames[1].document.forms[0].practitioner.value;
	var n = parent.frames[1].document.forms[0].location.value;
	var locntype =parent.frames[1].document.forms[0].location_type.value;
	var resourcetype =parent.frames[1].document.forms[0].resourceType1.value;
	var blk_time_from=parent.frames[1].document.forms[0].blk_time_from.value;
	var blk_time_to=parent.frames[1].document.forms[0].blk_time_to.value;
	var arr =  new Array();
	arr = n.split("|");
	var locncode = arr[0];
	var res = parent.frames[1].document.forms[0].reason.value;
	var res_desc = parent.frames[1].document.forms[0].reason_desc.value;
	//below onle line was commented by Venkatesh.S(4008) on 13-Mar-2012  against the issue SKR-SCF-0435 [IN:031675] 
	//var url='../../eOA/jsp/addmodifyBlockLiftCancelSchDetail.jsp?from='+(start)+'&to='+(end)+'&eff_from='+efffrom+'&eff_to='+effto+'&action='+action+'&pract_id='+practid+'&locn_code='+locncode+'&reason='+res+'&reason_desc='+res_desc+'&resourcetype='+resourcetype+'&locntype='+locntype+"&blk_time_from="+blk_time_from+"&blk_time_to="+blk_time_to;

	//below line was added by Venkatesh.S(4008) on 13-Mar-2012  against the issue SKR-SCF-0435 [IN:031675] 
	var url='../../eOA/jsp/addmodifyBlockLiftCancelSchDetail.jsp?from='+(start)+'&to='+(end)+'&eff_from='+efffrom+'&eff_to='+effto+'&action='+action+'&pract_id='+practid+'&locn_code='+locncode+'&reason='+res+'&reason_desc='+res_desc+'&resourcetype='+resourcetype+'&locntype='+locntype+'&day_1='+day_1+'&day_2='+day_2+'&day_3='+day_3+'&day_4='+day_4+'&day_5='+day_5+'&day_6='+day_6+'&day_7='+day_7+'&blk_time_from='+blk_time_from+'&blk_time_to='+blk_time_to;

	//end SKR-SCF-0435 [IN:031675] 
	
	var len=document.getElementById("checkBox").length
		for(i=0;i<len;i++)	
		{
			if(document.getElementById("checkBox")[i])
			{
			if(document.getElementById("checkBox")[i].checked==true)
			{
				flag=true;
				
			}
			}
		}
		if(flag==false)
		{
				
			parent.frames[2].location.href=url;
				
		}else
		{
			var conf = confirm(getMessage("SUBMIT_SELECTED_REC","OA"));
			if(conf)
			{
				var selValues="";
	var selValues1="";

	len=parent.frames[2].document.BCLSchDetail_form.checkBox.length;
	obj=parent.frames[2].document.BCLSchDetail_form.checkBox;
	Obj=parent.frames[2].document.BCLSchDetail_form;
	if (Obj.selectall.checked){
		var str="111111111111111";
	}else{
		var str="000000000000000";
	}

	   if (len!=null && len!=''){
	for (i=0;i<len;i++){
     if (obj[i].checked){ 
		 if(document.forms[0].bulk_blocking_yn.value=="Y"){
			 selValues1=Obj.vals[i].value+"|"+eval("parent.frames[2].document.BCLSchDetail_form.time_table_type"+i).value+"|"+eval("parent.frames[2].document.BCLSchDetail_form.no_slots_to_be_blocked"+i).value+"|"+eval("parent.frames[2].document.BCLSchDetail_form.total_first_visits_blocked"+i).value+"|"+eval("parent.frames[2].document.BCLSchDetail_form.nooffirstvisits"+i).value+"|"+eval("parent.frames[2].document.BCLSchDetail_form.total_other_visits_blocked"+i).value+"|"+eval("parent.frames[2].document.BCLSchDetail_form.noofothervisits"+i).value+'-';
		 }else{
			 selValues1=Obj.vals[i].value+'-';
		 }
		selValues+=selValues1;
		flag=false;
	sel++;
	 }
	}
   }else
	{
	selValues ="";
	flag=true;


   }
   

parent.frames[2].document.forms[0].sel_rec.value = sel;
parent.frames[2].document.forms[0].final_vals.value=selValues;
//alert(parent.frames[2].document.forms[0].final_vals.value)


				if(parent.frames[2].document.forms[0].final_vals.value !="")
				{
				parent.frames[2].document.forms[0].submit();
				}else
				{
				parent.frames[3].location.href="../../eCommon/jsp/error.jsp?err_num=" ;
				}

}else
{

	parent.frames[2].location.href=url;

}
		}
		}


function  prevRecs(start,end)
	{
	var flag=false;
	var sel=0;

	//below line was added by Venkatesh.S(4008) on 13-Mar-2012  against the issue SKR-SCF-0435 [IN:031675] 
	var day_1 = parent.frames[1].document.forms[0].mon.value;
	var day_2 = parent.frames[1].document.forms[0].tue.value;
	var day_3 = parent.frames[1].document.forms[0].wed.value;
	var day_4 = parent.frames[1].document.forms[0].thu.value;
	var day_5 = parent.frames[1].document.forms[0].fri.value;
	var day_6 = parent.frames[1].document.forms[0].sat.value;
	var day_7 = parent.frames[1].document.forms[0].sun.value;
	//end SKR-SCF-0435 [IN:031675] 

	
	
		parent.frames[1].document.forms[0].reportbut.disabled = true;
	var efffrom = parent.frames[1].document.forms[0].eff_from.value;
	var effto = parent.frames[1].document.forms[0].eff_to.value;
	var action = parent.frames[1].document.forms[0].action.value;
	//var day = parent.frames[1].document.forms[0].day.value;
	var practid = parent.frames[1].document.forms[0].practitioner.value;
	var n = parent.frames[1].document.forms[0].location.value;
	var locntype =parent.frames[1].document.forms[0].location_type.value;
	var resourcetype =parent.frames[1].document.forms[0].resourceType1.value;
	var arr =  new Array();
	arr = n.split("|");
	var locncode = arr[0];
	var res = parent.frames[1].document.forms[0].reason.value;
	var res_desc = parent.frames[1].document.forms[0].reason_desc.value;
	var blk_time_from=parent.frames[1].document.forms[0].blk_time_from.value;
	var blk_time_to=parent.frames[1].document.forms[0].blk_time_to.value;
	
	//below line was commented by venkatesh.s against SKR-SCF-0435 [IN:031675]  on 13-Mar-2012
	//var url='../../eOA/jsp/addmodifyBlockLiftCancelSchDetail.jsp?from='+(start)+'&to='+(end)+'&eff_from='+efffrom+'&eff_to='+effto+'&action='+action+'&pract_id='+practid+'&locn_code='+locncode+'&reason='+res+'&reason_desc='+res_desc+'&resourcetype='+resourcetype+'&locntype='+locntype+"&blk_time_from="+blk_time_from+"&blk_time_to="+blk_time_to;
	
	//below line was added by Venkatesh.S(4008) on 13-Mar-2012  against the issue SKR-SCF-0435 [IN:031675] 
	var url='../../eOA/jsp/addmodifyBlockLiftCancelSchDetail.jsp?from='+(start)+'&to='+(end)+'&eff_from='+efffrom+'&eff_to='+effto+'&action='+action+'&pract_id='+practid+'&locn_code='+locncode+'&reason='+res+'&reason_desc='+res_desc+'&resourcetype='+resourcetype+'&locntype='+locntype+'&day_1='+day_1+'&day_2='+day_2+'&day_3='+day_3+'&day_4='+day_4+'&day_5='+day_5+'&day_6='+day_6+'&day_7='+day_7+'&blk_time_from='+blk_time_from+'&blk_time_to='+blk_time_to;

	//end SKR-SCF-0435 [IN:031675] 

	var len=document.getElementById("checkBox").length
		for(i=0;i<len;i++)	
		{
			if(document.getElementById("checkBox")[i])
			{
			if(document.getElementById("checkBox")[i].checked==true)
			{
				flag=true;
				
			}
			}
		}
		if(flag==false)
		{
				
			parent.frames[2].location.href=url;
				
		}else
		{
			var conf = confirm(getMessage("SUBMIT_SELECTED_REC","OA"));
			if(conf)
			{
				var selValues="";
	var selValues1="";

	len=parent.frames[2].document.BCLSchDetail_form.checkBox.length;
	obj=parent.frames[2].document.BCLSchDetail_form.checkBox;
	Obj=parent.frames[2].document.BCLSchDetail_form;
	if (Obj.selectall.checked){
		var str="111111111111111";
	}else{
		var str="000000000000000";
	}

	   if (len!=null && len!=''){
	for (i=0;i<len;i++){
     if (obj[i].checked){ 
		if(document.forms[0].bulk_blocking_yn.value=="Y"){
			selValues1=Obj.vals[i].value+"|"+eval("parent.frames[2].document.BCLSchDetail_form.time_table_type"+i).value+"|"+eval("parent.frames[2].document.BCLSchDetail_form.no_slots_to_be_blocked"+i).value+"|"+eval("parent.frames[2].document.BCLSchDetail_form.total_first_visits_blocked"+i).value+"|"+eval("parent.frames[2].document.BCLSchDetail_form.nooffirstvisits"+i).value+"|"+eval("parent.frames[2].document.BCLSchDetail_form.total_other_visits_blocked"+i).value+"|"+eval("parent.frames[2].document.BCLSchDetail_form.noofothervisits"+i).value+'-';
			}else{
				selValues1=Obj.vals[i].value+'-';
			}
	selValues+=selValues1;
		flag=false;
	sel++;
	 }
	}
   }else
	{
	selValues ="";
	flag=true;


   }
   

parent.frames[2].document.forms[0].sel_rec.value = sel;
parent.frames[2].document.forms[0].final_vals.value=selValues;


				if(parent.frames[2].document.forms[0].final_vals.value !="")
				{
				parent.frames[2].document.forms[0].submit();
				}else
				{
				parent.frames[3].location.href="../../eCommon/jsp/error.jsp?err_num=" ;
				}

}else
{

	parent.frames[2].location.href=url;

}
		}
		}

function ClearAll()
{
	var len=document.getElementById("checkBox").length
		for(i=0;i<len;i++)	
		{
			if(document.getElementById("checkBox")[i])
			{
			if(document.getElementById("checkBox")[i].checked==true)
			{
				document.getElementById("checkBox")[i].checked=false;
				
			}
			}
		}
if(document.forms[0].selectall.checked==true)
	{
document.forms[0].selectall.checked=false;
}


}

function check_cancel(obj,obj1){
	if(document.forms[0].action.value=="C"){
		var len=document.getElementById("checkBox").length
		if(document.getElementById("no_of_rec").value==1){		
			if(obj1>0){
				var msg = getMessage("CANCEL_SCHEDULE_APPT_EXISTS","OA");
				if(confirm(msg)){
					document.getElementById("checkBox").checked=true;
				}else{
					document.getElementById("checkBox").checked=false;
				}
			}
		}else{
			if(obj1>0){	
				var msg = getMessage("CANCEL_SCHEDULE_APPT_EXISTS","OA");
				if(confirm(msg)){
					document.getElementById("checkBox")[obj].checked=true;
				}else{
					document.getElementById("checkBox")[obj].checked=false;
				}
			}
		}
	}else if(document.forms[0].action.value=="B"){
		if(document.forms[0].bulk_blocking_yn.value=="Y"){
			var blk_time_from=document.forms[0].blk_time_from.value;
			var blk_time_to=document.forms[0].blk_time_to.value;
			if(eval(document.getElementById('check_Box')+obj).checked){
				var no_slots_to_be_blocked=eval("document.forms[0].no_slots_to_be_blocked"+obj).value;
				var total_first_visits_available=eval("document.forms[0].total_first_visits_available"+obj).value;
				var total_other_visits_available=eval("document.forms[0].total_other_visits_available"+obj).value;
				var nooffirstvisits=eval("document.forms[0].nooffirstvisits"+obj).value;
				var noofothervisits=eval("document.forms[0].noofothervisits"+obj).value;
				if(no_slots_to_be_blocked ==(eval(nooffirstvisits)+eval(noofothervisits))){
				}else{
					alert(getMessage("TOTAL_BLOCK_SLOTS_MISMATCH","OA"))
					eval(document.getElementById('check_Box')+obj).checked=false;
				}
			}
		}else{
			if(document.getElementById("no_of_rec").value==1){
				var checkedValues=document.BCLSchDetail_form.vals.value;
				var valArr=checkedValues.split('|');
				if(eval(document.getElementById('check_Box')+obj).checked){	
					if(valArr[5]=="Y"){
						if(window.confirm(getMessage("SOME_SLOTS_BLOCKED","OA"))){
						}else{
							eval(document.getElementById('check_Box')+obj).checked=false;
						}
					}
				}
			}else{
				var checkedValues=document.BCLSchDetail_form.vals[obj].value;
				var valArr=checkedValues.split('|');
				if(eval(document.getElementById('check_Box')+obj).checked) {	
					if(valArr[5]=="Y"){
						if(window.confirm(getMessage("SOME_SLOTS_BLOCKED","OA"))){
						}else{
							eval(document.getElementById('check_Box')+obj).checked=false;
						}
					}
				}
			}			
		}
	}
}
function checkVisits(obj,obj1){
		var no_slots_to_be_blocked=eval("document.forms[0].no_slots_to_be_blocked"+obj).value;
		var total_first_visits_available=eval("document.forms[0].total_first_visits_available"+obj).value;
		var total_other_visits_available=eval("document.forms[0].total_other_visits_available"+obj).value;
		var nooffirstvisits=eval("document.forms[0].nooffirstvisits"+obj).value;
		var noofothervisits=eval("document.forms[0].noofothervisits"+obj).value;
		if(obj1=="1"){
			if(eval(nooffirstvisits) > eval(total_first_visits_available)){
				alert(getMessage("BLOCK_VISITS_ARE_MORE","OA"))
					eval("document.forms[0].nooffirstvisits"+obj).focus();
			}
		}else if(obj1=="2"){
			if(eval(noofothervisits) > eval(total_other_visits_available)){
						alert(getMessage("BLOCK_VISITS_ARE_MORE","OA"))
							eval("document.forms[0].noofothervisits"+obj).focus();
			}
		}
}

function checkDay(obj){
	if(obj.checked==true){
		obj.value='Y';	
	}else{
		obj.value='N';
	}
}				


function formatTimeForBlock(obj)
{  
	if (obj.value.length == 2)
	{
		if (obj.value.substring(1,2) == ':')
		{
			obj.value = '0' + obj.value ;
		}

	}

	if (obj.value.length == 3)
	{
		if (obj.value.substring(0,1) == ':')
		{
			obj.value = '00' + obj.value ;
		}

	}
}

function timeValidation(Obj){ // 1

 if (Obj.value!=''){ //2
	if (chkTime(Obj.value)==false || checkColon(Obj.value)==false){ //3
		var errors= getMessage("INVALID_TIME_FMT","SM");
		alert(errors);
		Obj.value='';
		Obj.focus();
	}
 }
}

function checkColon(dt){
 
 charAtpos3=dt.charAt(2);
 
 if (charAtpos3 == ':')
   return true;
	 else
   return false;
 
}

function CheckNum(val) {
	alert(isNaN(val))
    if ( isNaN(val)){
		//alert('0');
	}else{
		//alert('2')
	}

}

