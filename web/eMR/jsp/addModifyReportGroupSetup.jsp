<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
      <head>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
        <script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
      	<script src='../../eCommon/js/common.js' language='javascript'></script>
		<Script Language="JavaScript" src="..//js/MRMaster.js"></script>
<script> 
function callGroupType(obj,frm_fun){
	document.forms[0].grp_type_mand.style.visibility = "hidden";
	document.forms[0].group_type_new.options[0].selected = true;
	document.forms[0].group_type_new.disabled=true;

	var master=document.forms[0].type.value;
	var report_id=document.forms[0].Report_Id.value;
	var level=document.forms[0].Group_type.value
    
	/*if(master=='SP' && level=='S' && report_id=='MRIPCSBD')
	{
		document.forms[0].group_type_new.disabled=false;
		var obj_type = document.forms[0].group_type_new;
		
			var length  = obj_type.length;
			for(i=0;i<length;i++) 
			{
				obj_type.remove(1);
			}
			
			
				var opt_type= document.createElement('Option');
				opt_type.text='Isolation'; 
				opt_type.value='I';
				obj_type.add(opt_type)
					var opt_type= document.createElement('Option');
				opt_type.text='Unclassified'; 
				opt_type.value='U';
				obj_type.add(opt_type)
	
	}*/
	if ((master=='BD' && report_id=='MRIPCSBD') || (master=='BD' && report_id=='MRIPCSOBD'))
		{ //Above line modified for this CRF PER-PD-209A
		    var obj_type = document.forms[0].group_type_new;
			var length  = obj_type.length;
			for(i=0;i<length;i++) 
			{
				obj_type.remove(1);
			}
			document.forms[0].Group_type.value = "M";
			document.forms[0].Main_Group.value = "";
			document.forms[0].Main_Group_desc.value = "";
			document.forms[0].mand_gif1.style.visibility = "hidden";
			document.forms[0].mand_gif2.style.visibility = "hidden";
			document.forms[0].Group_type.disabled = true;
			document.forms[0].Main_Group.disabled = true;
			document.forms[0].group_type_new.disabled=true;
	}
	else if((master=='SP' && report_id=='MRIPCSBD' && frm_fun=="master") || (master=='SP' && report_id=='MRIPCSOBD' && frm_fun=="master")){ //modified for PER-PD-209A
			document.forms[0].Group_type.disabled=false;
			document.forms[0].Group_type.options[0].selected = true;
			var obj_type1 = document.forms[0].Group_type;
			var length1  = obj_type1.length;
			for(i=0;i<length1;i++) {
				obj_type1.remove(1);
			}
				var opt= document.createElement('Option');
//				opt.text='Level2 Group'; 
				opt.text=getLabel("eMR.level2group.label","eMR"); 
				opt.value='S';
				document.forms[0].Group_type.add(opt);
	}else if(master=='NS'){
		document.forms[0].grp_type_mand.style.visibility = "visible";
		document.forms[0].group_type_new.disabled=false;
		var obj_type = document.forms[0].group_type_new;
			var length  = obj_type.length;
			for(i=0;i<length;i++) {
				obj_type.remove(1);
			}
				var opt_type= document.createElement('Option');
//				opt_type.text='First Visit'; 
				opt_type.text=getLabel("Common.firstvisit.label","Common"); 
				opt_type.value='F';
				obj_type.add(opt_type)
					var opt_type= document.createElement('Option');
//				opt_type.text='Follow-up Visit'; 
				opt_type.text=getLabel("Common.followup.label","Common")+" "+getLabel("Common.Visit.label","Common"); ; 
				opt_type.value='U';
				obj_type.add(opt_type)
	
	}else if(master=='BC' && report_id=='MRBPD207' && frm_fun=="master"){
			document.forms[0].Group_type.disabled=false;
			document.forms[0].Group_type.options[0].selected = true;
			var obj_type1 = document.forms[0].Group_type;
			var length1  = obj_type1.length;
			for(i=0;i<length1;i++) {
				obj_type1.remove(1);
			}

				var opt= document.createElement('Option');
//				opt.text='Level2 Group'; 
				opt.text=getLabel("eMR.level2group.label","eMR"); 
				opt.value='S';
				document.forms[0].Group_type.add(opt);
	}else if(master=='SP' && report_id=='MRBPD207' && frm_fun=="master"){
			document.forms[0].group_type_new.options[0].selected = true;
			document.forms[0].group_type_new.disabled=true;

			document.forms[0].Group_type.disabled=true;
			document.forms[0].Group_type.options[0].selected = true;
			var obj_type1 = document.forms[0].Group_type;
			var length1  = obj_type1.length;
			for(i=0;i<length1;i++) {
				obj_type1.remove(1);
			}

				var opt= document.createElement('Option');
//				opt.text='Level2 Group'; 
				opt.text=getLabel("eMR.level2group.label","eMR"); 
				opt.value='S';
				document.forms[0].Group_type.add(opt);
	}else{
		    var obj_type = document.forms[0].group_type_new;
			var length  = obj_type.length;
			for(i=0;i<length;i++) {
				obj_type.remove(1);
			}
			 document.forms[0].group_type_new.disabled=true;
	}
	if(frm_fun=="GC"){
		chkgrptype();
	}

}

function chkgrptype(){
		if(document.forms[0].type.value == 'BC'){
			document.forms[0].grp_type_mand.style.visibility = "visible";
			document.forms[0].group_type_new.disabled=false;
			document.forms[0].group_type_new.options[0].selected = true;
			var obj_type_gt = document.forms[0].group_type_new;
			var length_gt  = obj_type_gt.length;
			for(i=0;i<length_gt;i++) {
				obj_type_gt.remove(1);
			}
				var opt_type= document.createElement('Option');
//				opt_type.text='Elective'; 
				opt_type.text=getLabel("Common.elective.label","Common");  
				opt_type.value='E';
				obj_type_gt.add(opt_type);
				var opt_type= document.createElement('Option');
//				opt_type.text='Emergency'; 
				opt_type.text=getLabel("Common.emergency.label","Common");  
				opt_type.value='M';
				obj_type_gt.add(opt_type);
	}

}

function chkforenter(){
	var key = window.event.keyCode;// allows only numbers to be entered
		if((key==13)) {
				return false;
		}

}
function chkLimit(obj){
	var str=obj.value;
	var report_id=document.forms[0].Report_Id.value;
	
	if(report_id=="MRIPCSMB" || report_id=="MROPCSMB" || report_id=="MROPCSMS" || report_id=="MRBLABRG" || report_id=="MRBRADEX" || report_id=="MRBLABWL" || report_id=="MRBSS203" || report_id=="OPBMTMOR" || report_id=="IPBMRMOT" || report_id=="IPBEXCDT" || report_id=="MRBBAT3A" || report_id=="MRBBAT3B" || report_id=="MRBBAT3C" || report_id=="MRDCPROD" || report_id=="MRDCPROS"){
	  
		if(eval(str.length) > 150){
			error=getMessage("GROUP_NAME_LENGTH",'MR');
			error=error.replace('#','150');
		alert(error);
	    obj.focus();
	    obj.select();
   	    }
	}
	else if (report_id=="MRIPCSMH")
		{
		if(eval(str.length) > 45){
			error=getMessage("GROUP_NAME_LENGTH",'MR');
			error=error.replace('#','45');
			alert(error);
	    obj.focus();
	    obj.select();

	    }
		}
	else{
		
		if(eval(str.length) > 40){
			error=getMessage("GROUP_NAME_LENGTH",'MR');
			error=error.replace('#','40');
			alert(error);
	    obj.focus();
	    obj.select();

	    }
    }
}
function chkLimit_range(obj){
	var str=obj.value;
	
	if(eval(str.length) > 200)
	{
		error=getMessage("RANGE_LENGTH",'MR');
		alert(error);
	 obj.focus();
	 obj.select();
	}

}

function chknumber1(obj)
{
	if(eval(obj.value)==0 || eval(obj.value)< 0)
	{
		var msg=getMessage("INVALID_SERIAL_NO",'MR');
		obj.focus();
		parent.frames[3].location.href="../../eCommon/jsp/error.jsp?err_num="+msg;
	}
}
/////////////////////////////
async function getMainGroupId()
{
		
		var target= document.forms[0].Main_Group_desc;
		var main_group=document.forms[0].Main_Group.value;
		var report_gr_id = document.forms[0].Report_Id.value;
		var master=document.forms[0].type.value;
		
		document.forms[0].LEVEL3_CODE_INSERT.value='';
		document.forms[0].LEVEL3_CODE1.value='';
		document.forms[0].range.value='';
		var group_type=document.forms[0].group_type_new.value;
		
		if(report_gr_id=='MRBPD207' && group_type=='')
		{
			alert('APP-MR001 Please select Group Type');
			return false;
		}
		var retVal	=  new String();
		var dialogTop			= "10";
		var dialogHeight		= "400px" ;
		var dialogWidth			= "700px" ;
		var features			="dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
		var arguments			= "" ;
		var search_desc="";
		var search_code="";
		var title=getLabel("Common.Level.label","Common")+'2 '+getLabel("Common.Group.label","Common");
		var sql="";
		if(report_gr_id=='MRIPCSBD' || report_gr_id=='MRIPCSOBD')
	    { //Above line modified for this CRF PER-PD-209A
		    title=getLabel("Common.Level.label","Common")+'1 '+getLabel("Common.Group.label","Common"); 
			sql="select group_code, group_desc from mr_report_grouping where REPORT_ID = `"+report_gr_id+"` and group_category = `M` and MAST_TABLE_NAME_REFERENCE=`"+master+"`";
		}
		else if(report_gr_id=='MRBPD207')
		{
			sql="select group_code, group_desc from mr_report_grouping where report_id = `MRBPD207` and group_category = `M` and group_type = `" +group_type + "`";
		}
		else
	    {
		 sql="select group_code, group_desc from mr_report_grouping where REPORT_ID = `"+report_gr_id+"` and group_category = `M`"
		}
	
		search_code="group_code";
		search_desc="group_desc";
	   
		  retVal= await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+title+"&dispDescFirst=dispDescFirst",arguments,features);
	   
	    var arr=new Array();
	    if (retVal != null && retVal != '' && retVal != "null")
		{
			var retVal=unescape(retVal);
			arr=retVal.split("::");
		    document.forms[0].Main_Group_desc.value=arr[0];
			document.forms[0].Main_Group.value=arr[1];
			document.forms[0].Main_Group_desc.focus();
		}
	  
	}

//////////////////////////////
async function getSubGroupId()
{
		var target= document.forms[0].LEVEL3_CODE1;
		document.forms[0].range.value='';
		var main_group=document.forms[0].Main_Group.value;
		var report_gr_id = document.forms[0].Report_Id.value;
		var retVal	=  new String();
		var dialogTop			= "10";
		var dialogHeight		= "400px" ;
		var dialogWidth			= "700px" ;
		var features			="dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
		var arguments			= "" ;
		var search_desc="";
		var search_code="";
//		var title="Level3 Group";
		var title=getLabel("Common.Level.label","Common")+'3 '+getLabel("Common.Group.label","Common");
		
        var sql="select group_code, group_desc from mr_report_grouping where report_id =`"+report_gr_id+"` and subgroup_code =`"+main_group+"` and group_category = `S` " ;
		
		search_code="group_code";
		search_desc="group_desc";
		retVal= await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+title+"&dispDescFirst=dispDescFirst",arguments,features);
	  
	    var arr=new Array();
	    if (retVal != null && retVal != '' && retVal != "null")
		{
			var retVal=unescape(retVal);
			arr=retVal.split("::");
		    document.forms[0].LEVEL3_CODE1.value=arr[0];
			document.forms[0].LEVEL3_CODE_INSERT.value=arr[1];
			document.forms[0].LEVEL3_CODE1.focus();
		}
	}
function allowPositiveNumber() 
{
		var key = window.event.keyCode;// allows only numbers to be entered
		if((key<48 )||(key>58)) 
			{
				return false;
			}
}
	</script>
	<script>
	function change() {
	 if (ReportGroupFrm.print_desc.checked == true)
		{
		ReportGroupFrm.print_desc.value="Y";
	    ReportGroupFrm.prn_desc.value='Y';
		}
	 else{
		ReportGroupFrm.print_desc.value="N";
	    ReportGroupFrm.prn_desc.value='N';
	    }
	}

	function populate_main_group(obj)
	{
		if(document.forms[0].Group_type.value == "S" || document.forms[0].Group_type.value == "G")       
		  {
			
			var HTMLVal = "";
			
			var calledFromFinction = "PDPLReportGroup";
			var ReportID = document.forms[0].Report_Id.value;
			var MainGroup = document.forms[0].MainGroup.value;
			var obj1=document.forms[0].Main_Group;
			var length1=obj1.length;
			
			var i;
			for(i=0;i<length1;i++) 
			obj1.remove(1);

			document.forms[0].Main_Group.disabled = false;
			document.forms[0].mand_gif2.style.visibility = "visible";
			document.forms[0].LEVEL3_CODE1.disabled = false;
			document.forms[0].mand_gif3.style.visibility = "visible";
			document.forms[0].sub_group11.disabled = false;
			document.forms[0].sub_group11_level2.disabled = false;
			document.forms[0].Main_Group_desc.disabled = false;
			document.forms[0].mand_gif4.style.visibility = "visible";
			document.forms[0].range.disabled = false;
						
			if(document.forms[0].Group_type.value == "S")
			{
				
				if(ReportID=='MRIPCSBD' || ReportID=='MRIPCSOBD'){ //Modified for PER-PD-209A
				var obj_type = document.forms[0].group_type_new;
				var length  = obj_type.length;
				for(i=0;i<length;i++) 
				{
				obj_type.remove(1);
				}
					//document.forms[0].type.options[0].selected=true;
				}
				var obj1=document.forms[0].group_type_new;
			var length1=obj1.length;
			
			var i;
			for(i=0;i<length1;i++) 
			obj1.remove(1);
				document.forms[0].LEVEL3_CODE1.disabled = true;
				document.forms[0].Main_Group_desc.disabled = false;
				document.forms[0].sub_group11_level2.disabled = false;
				document.forms[0].sub_group11.disabled = true;
		        document.forms[0].mand_gif3.style.visibility = "hidden";
				document.forms[0].mand_gif4.style.visibility = "hidden";
				document.forms[0].range.disabled = true;
				document.forms[0].group_type_new.disabled=true;
				

			}
		}
		else
		{
			var ReportID = document.forms[0].Report_Id.value;
			if(ReportID=='MRIPCSBD' || ReportID=='MRIPCSOBD'){ //Modified for this CRF PER-PD-209A
				var obj_type = document.forms[0].group_type_new;
				var length  = obj_type.length;
				for(i=0;i<length;i++) 
				{
				obj_type.remove(1);
				}

					//document.forms[0].type.options[0].selected=true;
				}
			document.forms[0].Main_Group_desc.value = "";
			document.forms[0].Main_Group.value = "";
			document.forms[0].Main_Group_desc.disabled = true;
			document.forms[0].Main_Group_desc.disabled = true;
			document.forms[0].sub_group11_level2.disabled = true;
			document.forms[0].mand_gif2.style.visibility = "hidden";
			document.forms[0].LEVEL3_CODE1.disabled = true;
			document.forms[0].sub_group11.disabled = true;
			document.forms[0].mand_gif3.style.visibility = "hidden";
			document.forms[0].mand_gif4.style.visibility = "hidden";
			document.forms[0].range.disabled = true;
			document.forms[0].group_type_new.disabled=true;
		}
	}

	function changereport(obj)
	{
			
			document.forms[0].no_of_bes.value="" ; /*Added by Rameswar for  ML-MMOH-SCF-0450*/
			document.forms[0].LEVEL3_CODE1.value='';
			document.forms[0].LEVEL3_CODE_INSERT.value='';
			document.forms[0].LEVEL3_CODE1.disabled = true;
			document.forms[0].sub_group11.disabled = true;
			document.forms[0].mand_gif3.style.visibility = "hidden";
			document.forms[0].range.disabled = true;
			document.forms[0].mand_gif4.style.visibility = "hidden";
			document.forms[0].type.value='';
			document.forms[0].range.value='';
			document.forms[0].Main_Group.value = "";
			document.forms[0].Main_Group_desc.value = "";
			document.forms[0].group_type_new.value = "";
			document.forms[0].group_type_new.disabled = true;

			
				
		   var obj_type = document.forms[0].type;
		
			var length  = obj_type.length;
			for(i=0;i<length;i++) 
			{
				obj_type.remove(1);
			}

			var length  = document.forms[0].Main_Group.length;
			for(i=0;i<length;i++) 
			{
				document.forms[0].Main_Group.remove(1);
			}

			if(obj.value=='IPBMIPCS')
			{
				/*var opt_type= document.createElement('Option');
				opt_type.text='Specialty'; 
				opt_type.value='SP';
				obj_type.add(opt_type)
				opt_type.selected = true;*/
				var opt_type= document.createElement('Option');
				opt_type.text=getLabel("Common.speciality.label","Common"); 
				opt_type.value='SP';
				obj_type.add(opt_type)
				opt_type.selected = true;	

			}else if(obj.value=='MRIPCSEG' || obj.value=='MRBRH212' ||obj.value=='MROPANPO' || obj.value=='MROPCSEG'){
				var opt_type= document.createElement('Option');
				/*opt_type.text='Race Group'; 
				opt_type.value='RC';
				obj_type.add(opt_type)
				opt_type.selected = true;*/
				opt_type.text=getLabel("eMP.RaceGroup.label","MP"); 
				opt_type.value='RC';
				obj_type.add(opt_type)
				opt_type.selected = true;	
			}else if(obj.value=='IPBMCSBU' ){
				/*var opt_type= document.createElement('Option');
				opt_type.text='Specialty'; 
				opt_type.value='SP';
				obj_type.add(opt_type)
				opt_type.selected = true;*/
				var opt_type= document.createElement('Option');
				opt_type.text=getLabel("Common.speciality.label","Common"); 
				opt_type.value='SP';
				obj_type.add(opt_type)
				opt_type.selected = true;	

				//document.getElementById('no_of_beds').style.visibility = 'visible';
				//document.getElementById('no_of_beds').innerHTML="<td align='right' class=label>No of Beds</td><td colspan='3' align='left'>&nbsp;&nbsp;&nbsp;<input type="Text" rows='2' name='no_of_bes' id='no_of_bes' value="" size="12" maxlength='3'></td>";
			}else if(obj.value == 'MRBSS203'){
				/*var opt_type= document.createElement('Option');
				opt_type.text='Order Catalog'; 
				opt_type.value='OC';
				obj_type.add(opt_type)
				//opt_type.selected = true;
				var opt_type= document.createElement('Option');
				opt_type.text='Specialty'; 
				opt_type.value='SP';
				obj_type.add(opt_type)
				//opt_type.selected = true;
				if(obj.value!='MRBSS203')
					opt_type.selected = true;	*/
				var opt_type= document.createElement('Option');
				opt_type.text=getLabel("Common.ordercatalog.label","Common"); 
				opt_type.value='OC';
				obj_type.add(opt_type)
				//opt_type.selected = true;
				var opt_type= document.createElement('Option');
				opt_type.text=getLabel("Common.speciality.label","Common"); 
				opt_type.value='SP';
				obj_type.add(opt_type)
				//opt_type.selected = true;
				if(obj.value!='MRBSS203')
					opt_type.selected = true;	
			}else if(obj.value=='MRIPCSMH'){
				/*var opt_type= document.createElement('Option');
				opt_type.text='Delivery Type'; 
				opt_type.value='DT';
				obj_type.add(opt_type)
				var opt_type= document.createElement('Option');
				opt_type.text='ICD Code'; 
				opt_type.value='IC';
				obj_type.add(opt_type)				
				var opt_type= document.createElement('Option');
				opt_type.text='Specialty'; 
				opt_type.value='SP';
				obj_type.add(opt_type)
				//opt_type.selected = true;*/
				var opt_type= document.createElement('Option');
				opt_type.text=getLabel("eMP.DeliveryType.label","MP"); 
				opt_type.value='DT';
				obj_type.add(opt_type)
				var opt_type= document.createElement('Option');
				opt_type.text=getLabel("Common.ICDCode.label","Common"); 
				opt_type.value='IC';
				obj_type.add(opt_type)
				var opt_type= document.createElement('Option');
				opt_type.text=getLabel("Common.speciality.label","Common"); 
				opt_type.value='SP';
				obj_type.add(opt_type)
				/*Added by Ashwini on 28-Jan-2021 for ML-MMOH-CRF-1341*/
				var opt_type= document.createElement('Option');
				opt_type.text=getLabel("eMP.RaceGroup.label","MP"); 
				opt_type.value='RC';
				obj_type.add(opt_type)
				var opt_type= document.createElement('Option');
				opt_type.text=getLabel("eMR.DelAttndBy.label","MR"); 
				opt_type.value='DA';
				obj_type.add(opt_type)
				/*End ML-MMOH-CRF-1341*/
				//opt_type.selected = true;
					
			}
			else if(obj.value=='MROPCSAT' ||obj.value=='MROPRFLS' || obj.value=='MRBRH203'){//MRBRH203 added by Rameswar on 09/11/2016 for HSA-CRF-0209.1
				if(obj.value=='MROPRFLS'){
				/*var opt_type= document.createElement('Option');
				opt_type.text='Healthcare Setting Type'; 
				opt_type.value='HC';
				obj_type.add(opt_type)*/
				var opt_type= document.createElement('Option');
				opt_type.text=getLabel("Common.HealthcareSettingType.label","Common"); 
				opt_type.value='HC';
				obj_type.add(opt_type)
				}
				if(obj.value=='MRIPCSBD' || obj.value=='MRIPCSOBD'){ //Modified for this CRF PER-PD-209A
					/*var opt_type= document.createElement('Option');
					opt_type.text='Bed Type'; 
					opt_type.value='BT';
					obj_type.add(opt_type)*/
					var opt_type= document.createElement('Option');
					opt_type.text=getLabel("Common.bedtype.label","Common"); 
					opt_type.value='BT';
					obj_type.add(opt_type)
				}
				/*var opt_type= document.createElement('Option');
				opt_type.text='Specialty'; 
				opt_type.value='SP';
				obj_type.add(opt_type)*/
				var opt_type= document.createElement('Option');
				opt_type.text=getLabel("Common.speciality.label","Common"); 
				opt_type.value='SP';
				obj_type.add(opt_type)
				if(obj.value!='MROPRFLS' && obj.value!='MRIPCSBD' || obj.value!='MROPRFLS' && obj.value!='MRIPCSOBD')
					opt_type.selected = true;	 //above if condtion modified for this PER-PD-209A
			}else if(obj.value=='MRIPCSBD' || obj.value=='MRIPCSOBD'){ //Modified for this PER-PD-209A
				/*var opt_type= document.createElement('Option');
				opt_type.text='Specialty'; 
				opt_type.value='SP';
				obj_type.add(opt_type)*/
				var opt_type= document.createElement('Option');
				opt_type.text=getLabel("Common.speciality.label","Common"); 
				opt_type.value='SP';
				obj_type.add(opt_type)
				opt_type.selected = true;
				/*var opt_type= document.createElement('Option');
				opt_type.text='Bed Class'; 
				opt_type.value='BD';
				obj_type.add(opt_type)				
				*/
				var opt_type= document.createElement('Option');
				opt_type.text=getLabel("Common.BedClass.label","Common"); 
				opt_type.value='BD';
				obj_type.add(opt_type)
			}else if( (obj.value == 'MRBRADEX') || (obj.value == 'MRBLABWL') || (obj.value == 'MRBLABRG')){
				/*var opt_type= document.createElement('Option');
				opt_type.text='Order Catalog'; 
				opt_type.value='OC';
				obj_type.add(opt_type)*/
				var opt_type= document.createElement('Option');
				opt_type.text=getLabel("Common.ordercatalog.label","Common"); 
				opt_type.value='OC';
				obj_type.add(opt_type)
				opt_type.selected = true;	
			}
            else if((obj.value=='MROPCSMB') || (obj.value=='MRIPCSMB') || (obj.value=='MROPCSMS') || (obj.value=='OPBMTMOR') || (obj.value=='IPBMRMOT') || (obj.value=='IPBEXCDT') || (obj.value=='MRDCCSMB') || (obj.value=='MRDCPROD') || (obj.value=='MRDCPROS')){  //Modified for this CRF PER-RH-0206
				/*var opt_type= document.createElement('Option');
				opt_type.text='Tabulation List'; 
				opt_type.value='TL';
				obj_type.add(opt_type)
				opt_type.selected = true;*/
			
				var opt_type= document.createElement('Option');
				opt_type.text=getLabel("eMR.TabulationList.label","MR"); 
				opt_type.value='TL';
				obj_type.add(opt_type)
				opt_type.selected = true;
				//Modified by Ashwini on 12-Sep-2019 for ML-MMOH-CRF-1349
				//MROPCSMS Added by Ashwini on 19-May-2020 for ML-MMOH-CRF-1532
				if(obj.value=='MROPCSMS' || obj.value=='MRDCPROS'){
					document.forms[0].range.disabled = false;
				    document.forms[0].mand_gif4.style.visibility = "visible";

				}
			}
			if(obj.value=='MRBRADEX' || obj.value=='MRBLABRG' || obj.value=='MRIPCSBD' || obj.value=='OPBMTMOR' || obj.value=='IPBMRMOT' || obj.value=='IPBEXCDT' || obj.value=='MRIPCSOBD')
			{  //Above line modified for this PER-PD-209A
				document.forms[0].Group_type.disabled = false;
				document.forms[0].mand_gif1.style.visibility = "visible";
				document.forms[0].Group_type.options[0].selected = true;
				obj_type=document.forms[0].Group_type
				var length  = obj_type.length;
				for(i=0;i<length;i++) 
				{
					obj_type.remove(1);
				}
				var opt_type= document.createElement('Option');
//				opt_type.text='Level1 Group'; 
				opt_type.text=getLabel("Common.Level.label","Common")+'1 '+getLabel("Common.Group.label","Common"); 
				opt_type.value='M';
//			    opt_type.text='Level2 Group'; 
			    opt_type.text=getLabel("Common.Level.label","Common")+'2 '+getLabel("Common.Group.label","Common"); 
				opt_type.value='S';
				obj_type.add(opt_type)
			}else if((obj.value=='MRIPCSMB') || (obj.value=='MRDCCSMB') || (obj.value=='MROPCSMB')){ //Modified for this CRF PER-RH-0206 //Modified by Ashwini on 12-Sep-2019 for ML-MMOH-CRF-1349 //MROPCSMS Removed by Ashwini on 19-May-2020 for ML-MMOH-CRF-1532
					document.forms[0].Group_type.disabled = false;
				    document.forms[0].mand_gif1.style.visibility = "visible";
				    document.forms[0].Group_type.options[0].selected = true;
					if(document.forms[0].Group_type.length <=2){
						var opt_type= document.createElement('Option');
						obj_type=document.forms[0].Group_type
//						opt_type.text='Level3 Group'; 
						opt_type.text=getLabel("Common.Level.label","Common")+'3 '+getLabel("Common.Group.label","Common"); 
						opt_type.value='G';
						obj_type.add(opt_type)
					}
				}else if(obj.value=='MRBPD207'){
				/*var opt_type= document.createElement('Option');
					opt_type.text='Specialty'; 
					opt_type.value='SP';
					obj_type.add(opt_type)*/
					var opt_type= document.createElement('Option');
					opt_type.text=getLabel("Common.speciality.label","Common"); 
					opt_type.value='SP';
					obj_type.add(opt_type)
					/*var opt_type= document.createElement('Option');
					opt_type.text='Billing Service Classification'; 
					opt_type.value='BC';*/
					var opt_type= document.createElement('Option');
					opt_type.text=getLabel("Common.Billing.label","Common")+" "+getLabel("eBL.SERVICE_CLASSIFICATION.label","BL"); 
					opt_type.value='BC';
					obj_type.add(opt_type)
			}else if(obj.value=='IPBMCREF'){
					/*var opt_type= document.createElement('Option');
					opt_type.text='Nursing Unit'; 
					opt_type.value='NU';
					obj_type.add(opt_type)*/
					var opt_type= document.createElement('Option');
					opt_type.text=getLabel("Common.nursingUnit.label","Common"); 
					opt_type.value='NU';
					obj_type.add(opt_type)
					/*var opt_type= document.createElement('Option');
					opt_type.text='Clinic/Procedure Unit'; 
					opt_type.value='CP';
					obj_type.add(opt_type)*/
					var opt_type= document.createElement('Option');
					opt_type.text=getLabel("Common.clinic.label","Common")+"/"+getLabel("Common.ProcedureUnit.label","Common"); 
					opt_type.value='CP';
					obj_type.add(opt_type)

					var opt_type= document.createElement('Option');
					opt_type.text='Healthcare Setting'; 
					opt_type.value='HC';
					obj_type.add(opt_type)
					var opt_type= document.createElement('Option');
					opt_type.text=getLabel("Common.speciality.label","Common"); 
					opt_type.value='SP';
					obj_type.add(opt_type)
					
					/*Added by Ashwini on 19-Jun-2019 for ML-MMOH-CRF-1340*/
					var opt_type = document.createElement('Option');
					opt_type.text = getLabel("Common.Staff.label","Common")+" "+getLabel("Common.clinic.label","Common"); 
					opt_type.value = 'SC';
					obj_type.add(opt_type)
					/*End ML-MMOH-CRF-1340*/

			}else if(obj.value=='MRBBAT3A'){
				/*var opt_type= document.createElement('Option');
				opt_type.text='ICD Code'; 
				opt_type.value='IC';
				obj_type.add(opt_type)*/
				var opt_type= document.createElement('Option');
				opt_type.text=getLabel("Common.ICDCode.label","Common"); 
				opt_type.value='IC';
				obj_type.add(opt_type)
				var opt_type= document.createElement('Option');
				opt_type.text='Name Suffix'; 
				opt_type.value='NS';
				obj_type.add(opt_type)				
				var opt_type= document.createElement('Option');
				opt_type.text='Disposal'; 
				opt_type.value='DP';
				obj_type.add(opt_type)
				var opt_type= document.createElement('Option');
				opt_type.text='Healthcare Setting'; 
				opt_type.value='HC';
				obj_type.add(opt_type)
				document.forms[0].Group_type.options[0].selected = true;	document.forms[0].Group_type.disabled = true;
			}else if(obj.value=='MRBBAT3B' || obj.value=='MRBBAT3C'){
				/*var opt_type= document.createElement('Option');
				opt_type.text='ICD Code'; 
				opt_type.value='IC';
				obj_type.add(opt_type)*/
				var opt_type= document.createElement('Option');
				opt_type.text=getLabel("Common.ICDCode.label","Common"); 
				opt_type.value='IC';
				obj_type.add(opt_type)				
				var opt_type= document.createElement('Option');
				opt_type.text='Healthcare Setting'; 
				opt_type.value='HC';
				obj_type.add(opt_type)	
				document.forms[0].Group_type.options[0].selected = true;	document.forms[0].Group_type.disabled = true;
			}else{
				document.forms[0].Group_type.value = "M";
				document.forms[0].Main_Group.value = "";
				document.forms[0].Main_Group_desc.value = "";
				document.forms[0].mand_gif1.style.visibility = "hidden";
				document.forms[0].mand_gif2.style.visibility = "hidden";
				document.forms[0].Group_type.disabled = true;
				document.forms[0].Main_Group.disabled = true;
			}
	}
	/*This function was removed by Calling from the Onchange of Report Drop down List(i.e 5.x code). On 12/9/2009 for Incident:17000*/
	function ClearFunction(){
		
		 
		if(document.forms[0].Report_Id.value!="IPBMCSBU"){ 
	
			document.getElementById("no_of_beds").style.display = "none";
			document.getElementById("no_of_beds_0").style.display = "none";
			document.getElementById("no_of_beds_1").style.display = "none";
		}
		if(document.forms[0].Report_Id.value=="IPBMIPCS" ){ 
		
			document.getElementById("no_of_beds").style="display";
			//document.getElementById("no_of_beds_1").style.display = "none";
		}
		if(document.forms[0].Report_Id.value=="IPBMCSBU" ){ 
		     document.getElementById("no_of_beds_0").style="display";
			document.getElementById("no_of_beds_1").style="display";
		} 
		
	}
	function calllevel3()
	{

			
			
		 if(document.forms[0].LEVEL3_CODE1!=null)
		 {
		   document.forms[0].LEVEL3_CODE1.value='';
		   document.forms[0].LEVEL3_CODE_INSERT.value='';
		   
		 }
		 if(document.forms[0].Group_type.value == "G")
		 {
			var HTMLVal = "";
			var calledFromFinction = "PDPLReportGroup_level3";
			var ReportID = document.forms[0].Report_Id.value;
			var MainGroup = document.forms[0].MainGroup.value;
			var sub_group_code_l2=document.forms[0].Main_Group.value;
			
			document.forms[0].LEVEL3_CODE1.disabled = false;
			document.forms[0].sub_group11.disabled = false;
			document.forms[0].mand_gif3.style.visibility = "visible";
			document.forms[0].mand_gif4.style.visibility = "visible";
			document.forms[0].range.disabled=false;

		}

	}
	/*This function was removed by Calling from the Onload of Body(i.e 5.x code). On 12/9/2009 for Incident:17000*/
	function loadDefaults()
	{ 
	       
			
        if(document.forms[0].Report_Id.value==""){
			document.getElementById("no_of_beds").style.display = "none";
			document.getElementById("no_of_beds_0").style.display = "none";
			document.getElementById("no_of_beds_1").style.display = "none";
			
			}
		if(document.forms[0].Report_Id.value !="" && document.forms[0].Report_Id.value !="IPBMCSBU"){
		    document.getElementById("no_of_beds_0").style.display = "none";
		    document.getElementById("no_of_beds_1").style.display = "none"
			}
			
		if(document.forms[0].Report_Id.value !=""  && document.forms[0].Report_Id.value=="IPBMCSBU"){
		     
			  document.getElementById("no_of_beds").style.display = "none";
	          document.getElementById("no_of_beds_0").style.display = "";
			  document.getElementById("no_of_beds_1").style.display = "";
		
		
			   }
		 if(document.forms[0].Report_Id.value=="MRBPD207" && document.forms[0].type.value=="BC" && document.forms[0].group_type_new.value !=""){   
		 	document.forms[0].grp_type_mand.style.visibility = "visible";
		 }/*Added by Rameswar on  17-08-2016 for ML-MMOH-SCF-0467*/
	}
	
	
	
		function chkForNumeric(event){
			var strCheck = '0123456789 ';
			var whichCode = (window.Event) ? event.which : event.keyCode;	 
			key = String.fromCharCode(whichCode);  // Get key value from key code	 
			if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
			return true ;
			 }
	</script>
    </head>

	<body OnMouseDown='CodeArrest()' onload='change();FocusFirstElement();loadDefaults();' onKeyDown = 'lockKey()'>
<% /*loadDefaults function is added by Rameswar for  ML-MMOH-SCF-0450*/
 request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
   boolean status = false;
   String sql="";
   Connection conn=null;
   Statement stmt=null;
   PreparedStatement psmt=null;
   ResultSet rset=null;
   String code="";
   String name="";
   //String id="";
   String table_reference="";
   String report_desc_temp="";
   String reference="";
   String order_serial_no="";
   String print_desc_yn="";
   String check_attribute="";
   String group_category ="";
   String subgroup_code ="";
   String subgroup_desc ="";
   String codeTextAttribute="";
   String m_select="";
   String s_select="";
   String g_select="";
   String LEVEL3_CODE="";
   String LEVEL3_CODE_DESC="";
   String mode="";
   String level3_range="";
   String group_type_desc="";
   String group_type_desc_value="";
   String Report_Id="IPBMCSBU";/*IPBMCSBU is added by Rameswar for  ML-MMOH-SCF-0450*/
   String no_of_bes = "";
   String no_of_bes_1 = "";
   String no_of_bes_0 = "";


try
{
	conn=ConnectionManager.getConnection(request);
	code=request.getParameter("GROUP_CODE")==null?"":request.getParameter("GROUP_CODE");
	 String rep_id=request.getParameter("REPORT_ID")==null?"":request.getParameter("REPORT_ID");

	 String table_ref=request.getParameter("MAST_TABLE_NAME_REFERENCE")==null?"":request.getParameter("MAST_TABLE_NAME_REFERENCE");
	 mode=request.getParameter("mode");
	 if(mode==null || mode.equals("null"))
	{
		 mode="";
	}

	if(code==null || code.equals(""))
	{
		code="";
		name="";
        //id="";
        table_reference="";
		status=true;
		codeTextAttribute="";

	}
		else if(!code.equals(""))
		{
			try{
			//stmt = conn.createStatement();
            if(table_ref.equals("Delivery Type"))
				table_ref="DT";
				if(table_ref.equals("HealthCare Setting Type"))
				table_ref="HC";
				if(table_ref.equals("Race Group"))
				table_ref="RC";
				if(table_ref.equals("Specialty"))
				table_ref="SP";
				if(table_ref.equals("Order Catalog"))
				table_ref="OC";
				if(table_ref.equals("Tabulation List"))
				table_ref="TL";
				if(table_ref.equals("Bed Type"))
				table_ref="BT";
				if(table_ref.equals("ICD Code"))
				table_ref="IC";
				if(table_ref.equals("Nursing Unit"))
				table_ref="NU";
				if(table_ref.equals("Clinic"))
				table_ref="CL";
				if(table_ref.equals("Clinic/Procedure Unit"))
				table_ref="CP";
				if(table_ref.equals("Bed Class"))
				table_ref="BD";
				if(table_ref.equals("Disposal"))
				table_ref="DP";
				if(table_ref.equals("Name Suffix"))
				table_ref="NS";
				//Added by Ashwini on 19-Jun-2019 for ML-MMOH-CRF-1340
				if(table_ref.equals("Staff Clinic"))
				table_ref="SC";
				//Added by Ashwini on 28-Jan-2021 for ML-MMOH-CRF-1341
				if(table_ref.equals("Delivery Attended By"))
				table_ref="DA";


			sql = "select a.GROUP_TYPE,a.GROUP_CODE,a.LEVEL3_RANGE,a.GROUP_DESC,a.LEVEL3_CODE, a.report_id,a.mast_table_name_reference,a.ORDER_BY_SRL_NO,a.subgroup_code, (CASE WHEN a.subgroup_code IS NOT NULL THEN (SELECT group_desc FROM mr_report_grouping WHERE group_code = a.subgroup_code AND report_id = a.report_id AND mast_table_name_reference = a.mast_table_name_reference) END) sub_group_desc,(CASE WHEN a.LEVEL3_CODE IS NOT NULL THEN (SELECT group_desc FROM mr_report_grouping WHERE group_code = a.LEVEL3_CODE AND report_id = a.report_id AND mast_table_name_reference = a.mast_table_name_reference) END) level_code_desc,a.group_category,a.PRINT_DESC_YN, b.REPORT_DESC, a.no_of_beds_for_splty, no_of_oper_beds_for_splty,no_of_ofcl_beds_for_splty  from MR_REPORT_GROUPING a,sm_report b where a.report_id=b.report_id and GROUP_CODE=? and a.REPORT_ID=? and MAST_TABLE_NAME_REFERENCE=?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1,code);
			psmt.setString(2,rep_id);
			psmt.setString(3,table_ref);
			rset = psmt.executeQuery();
			while(rset.next())
			 {
				code	=rset.getString("GROUP_CODE");
				name	=rset.getString("GROUP_DESC");
				group_category =rset.getString("GROUP_CATEGORY")==null?"":rset.getString("GROUP_CATEGORY");
				subgroup_code =rset.getString("SUBGROUP_CODE")==null?"":rset.getString("SUBGROUP_CODE");
				subgroup_desc =rset.getString("sub_group_desc")==null?"":rset.getString("sub_group_desc");
				LEVEL3_CODE =rset.getString("LEVEL3_CODE")==null?"":rset.getString("LEVEL3_CODE");
				LEVEL3_CODE_DESC =rset.getString("level_code_desc")==null?"":rset.getString("level_code_desc");
				level3_range =rset.getString("LEVEL3_RANGE")==null?"":rset.getString("LEVEL3_RANGE");
				group_type_desc =rset.getString("GROUP_TYPE")==null?"":rset.getString("GROUP_TYPE");
				no_of_bes = rset.getString("no_of_beds_for_splty")==null?"":rset.getString("no_of_beds_for_splty");
				no_of_bes_1 = rset.getString("no_of_oper_beds_for_splty")==null?"":rset.getString("no_of_oper_beds_for_splty");
				no_of_bes_0 = rset.getString("no_of_ofcl_beds_for_splty")==null?"":rset.getString("no_of_ofcl_beds_for_splty");

				table_reference	=rset.getString("MAST_TABLE_NAME_REFERENCE");
				if(table_reference.equals("DT"))
				reference="Delivery Type";
				if(table_reference.equals("NU"))
				reference="Nursing Unit";
				if(table_reference.equals("CL"))
				reference="Clinic";
				if(table_reference.equals("CP"))
				reference="Clinic/Procedure Unit";
				if(table_reference.equals("HC"))
				reference="HealthCare Setting Type";
				if(table_reference.equals("RC"))
				reference="Race Group";
				if(table_reference.equals("SP"))
				reference="Specialty";
				if(table_reference.equals("OC"))
				reference="Order Catalog";
				if(table_reference.equals("TL"))
				reference="Tabulation List";
				if(table_reference.equals("BT"))
				reference="Bed Type";
				if(table_reference.equals("IC"))
				reference="ICD Code";
				if(table_reference.equals("BC"))
				reference="Billing Service Classification";
				if(table_reference.equals("BD"))
				reference="Bed Class";
				if(table_reference.equals("DP"))
				reference="Disposal";
				if(table_reference.equals("NS"))
				reference="Name Suffix";
				//Added by Ashwini on 19-Jun-2019 for ML-MMOH-CRF-1340
				if(table_reference.equals("SC"))
				reference="Staff Clinic";
				//Added by Ashwini on 28-Jan-2021 for ML-MMOH-CRF-1341
				if(table_reference.equals("DA"))
				reference="Delivery Attended By";
					


				report_desc_temp =rset.getString("REPORT_DESC");
				order_serial_no	=rset.getString("ORDER_BY_SRL_NO");
                print_desc_yn	=rset.getString("PRINT_DESC_YN");
                 /*Below else condition modified for PER-PD-209A*/
				 if(group_type_desc.equals("I"))
					 group_type_desc_value="Isolation";
                 else if(group_type_desc.equals("U") && rep_id.equals("MRIPCSBD") || group_type_desc.equals("U") && rep_id.equals("MRIPCSOBD"))
					 group_type_desc_value="Unclassified";
				 else if(group_type_desc.equals("E"))
					 group_type_desc_value="Elective";
                 else if(group_type_desc.equals("M"))
					 group_type_desc_value="Emergency";
				 else if(group_type_desc.equals("U") && table_reference.equals("NS"))
					 group_type_desc_value="Follow-up Visit";
				  else if(group_type_desc.equals("F"))
					 group_type_desc_value="First Visit";
 
 				if (print_desc_yn.equals("Y"))
                  check_attribute="CHECKED";
				else
					check_attribute="";
			 }

		   	 if(rset!=null)    	rset.close();
			 if(stmt!=null)    	stmt.close();
			 if(psmt!=null)    	psmt.close();
		}
		 catch(Exception e){
			//out.println("Exception @ addModifyReportGroupSetup here"+e.toString());
			e.printStackTrace();
	     }
	     
		status=false;
		codeTextAttribute="READONLY";
	}
%>
      	<form name='ReportGroupFrm' id='ReportGroupFrm' action='../../servlet/eMR.ReportGroupMasterServlet' method='post' target='messageFrame'>
      	<div align='left'>      
      	<table border='0' cellpadding='3' cellspacing='0' width='100%' align='center'>			
			<tr><td colspan='4'></td></tr>
			<tr><td colspan='4'></td></tr>
			<tr><td colspan='4'></td></tr>
			<tr>
			<td colspan='1' width="18%">&nbsp;</td>
			<td colspan='1' width="46%">&nbsp;</td>
			<td colspan='1' width="12%">&nbsp;</td>
			<td colspan='1' width="24%">&nbsp;</td>
			</tr>
			<tr>
				<td  align='right' colspan='1' class=label><fmt:message key="Common.report.label" bundle="${common_labels}"/></td>
			    <td  colspan='3'>
				       &nbsp;&nbsp;&nbsp;<select name="Report_Id" id="Report_Id" onchange="changereport(this);ClearFunction();"> <!-- ClearFunction function is added by Rameswar for  ML-MMOH-SCF-0450 -->
			    <option value="">--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</option>
			    <%
		         String report_id="";
				 String report_desc ="";
				 //Below line modified for this CRF PRE-RH-0206 and PER-PD-209A
				 // Commented by Krishnan on 09/12/2009
				 sql ="Select report_id,REPORT_desc from sm_report where (module_id ='MR' or module_id ='IP' or module_id ='OP')And report_id IN('MROPRFLS','MROPCSAT','MRBRADEX','MRIPCSBD','MRIPCSMH','MRIPCSEG','MROPANPO','MROPCSEG','MRBLABWL', 'MRBLABRG','MROPCSMB','MRIPCSMB','MROPCSMS','IPBMCSBU','MRBSS203','OPBMTMOR','IPBMRMOT','IPBEXCDT','MRBPD207','IPBMCREF','IPBMIPCS','MRBBAT3A','MRBBAT3B','MRBBAT3C','MRBRH212','MRDCCSMB','MRIPCSOBD','MRDCPROD','MRDCPROS','MRBRH203') order by report_desc";//MRBRH203 added by Rameswar on 09/11/2016 for HSA-CRF-0209.1
				 //sql ="Select report_id,REPORT_desc from sm_report where (module_id ='MR' or module_id ='IP' or module_id ='OP')And report_id IN('MROPRFLS','MROPCSAT','MRBRADEX','MRIPCSBD','MRIPCSMH','MRIPCSEG','MROPANPO','MROPCSEG','MRBLABWL', 'MRBLABRG','MROPCSMB','MRIPCSMB','MROPCSMS','MRBSS203','OPBMTMOR','IPBMRMOT','IPBEXCDT','MRBPD207','IPBMCREF') order by report_desc";
             	 stmt = conn.createStatement();
				 rset = stmt.executeQuery(sql);
				 if(rset!=null )
				 {
					while(rset.next())
					{
						report_desc = rset.getString("report_desc");
						report_id=rset.getString("report_id");
						if(report_desc.equals(report_desc_temp))
							out.print("<option value='"+report_id+"' selected>"+report_desc+"</option>");
						else
							out.print("<option value='"+report_id+"'>"+report_desc+"</option>");
					}
				
				}
				if(rset!=null) rset.close();
				if(stmt!=null) stmt.close();
		  %>
			</select>
			<img src="../../eCommon/images/mandatory.gif"></td>
			  </tr>
			 <!-- <tr><td colspan='4'>&nbsp;</td></tr> -->
			  <tr>
			  <td align='right' class='label' nowrap><fmt:message key="eMR.Master.label" bundle="${mr_labels}"/></td>
    		    <td colspan='3'>&nbsp;&nbsp;&nbsp;<select name='type' id='type' onchange="callGroupType(this,'master'),chkgrptype();"><option value="" selected>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</option>
				<% if((reference!=null)&&(!reference.equals(""))&&(table_reference!=null)&&(!table_reference.equals("")))
					  out.print("<option value='"+table_reference+"' selected>"+reference+"</option>");
				%>   
                  </SELECT>
    	 		  <img src='../../eMP/images/mandatory.gif'>
    		      </td>
				</tr>
				
		 <!-- <tr><td colspan='4'>&nbsp;</td></tr> -->
			<!-- ragha -->

		 <%
			 String mand_gif2_visible="hidden";
			if( !group_category.equals("") && group_category != null )
			 {
				  if(group_category.equals("S"))
				  {
					  s_select = "selected";
					  mand_gif2_visible = "visible";
				  }
				  else if(group_category.equals("M"))
				  {
					  m_select = "selected";
				  }
				  else if(group_category.equals("G"))
				  {
					  g_select = "selected";
				  }
			 }
		 %>
				<tr>
				<td   align='right' class=label><fmt:message key="eMR.GroupCategory.label" bundle="${mr_labels}"/></td>
				<td  colspan='1'>&nbsp;&nbsp;&nbsp;<select name="Group_type" id="Group_type" onchange='populate_main_group(this);callGroupType(this,"GC");' disabled> 
				<option value="M" <%=m_select%>><fmt:message key="eMR.level1group.label" bundle="${mr_labels}"/></option>
				<option value="S" <%=s_select%>><fmt:message key="eMR.level2group.label" bundle="${mr_labels}"/></option>
				<option value="G" <%=g_select%>><fmt:message key="eMR.level3group.label" bundle="${mr_labels}"/></option>
				</select>
				<img src="../../eCommon/images/mandatory.gif" id='mand_gif1' style="visibility:hidden"></td>
					<td align='right' class=label><fmt:message key="Common.GroupType.label" bundle="${common_labels}"/></td>
			   	<td colspan='1' align='left'>&nbsp;&nbsp;&nbsp;<select name='group_type_new' id='group_type_new' disabled ><option value='' selected>--- Select ---</option>
			<% if((group_type_desc_value!=null)&&(!group_type_desc_value.equals(""))&&(group_type_desc!=null)&&(!group_type_desc.equals("")))
					  out.print("<option value='"+group_type_desc+"' selected>"+group_type_desc_value+"</option>");
				%> 	
			</select>&nbsp;<img src="../../eCommon/images/mandatory.gif" id='grp_type_mand' style="visibility:hidden">
					</td>
    	</tr>
			
			  <!-- <tr><td colspan='4'>&nbsp;</td></tr> -->
			<tr>
      		    <td align='right'  colspan='1' class='label'><fmt:message key="Common.GroupCode.label" bundle="${common_labels}"/></td>
      		    <td  colspan='3'>&nbsp;&nbsp;
      		    <input type='text' name='group_code' id='group_code' value="<%=code%>" size='25' maxlength='15' onKeyPress="return CheckForSpecChars(event)" <%=codeTextAttribute%> >
      		    <img src='../../eCommon/images/mandatory.gif'></img></td>
     		 </tr>
      	
			  <!-- <tr><td colspan='4'>&nbsp;</td></tr> -->
		 				
      	
			 <tr>
			 <td   align='right' class=label><fmt:message key="Common.GroupName.label" bundle="${common_labels}"/></td>
      		    <td  colspan='3'>&nbsp;&nbsp;
      		    <textarea rows=2  cols=50 name="group_name" onkeyPress="checkMaxLimit(this,150);return chkforenter();"   value="<%=name%>" onBlur=" makeValidString(this);<%if(!rep_id.equals("")){%>chkLimit(this);<%}%>" ><%=name%></textarea> 
      		    <img src='../../eCommon/images/mandatory.gif'></img>
				</td>
			</tr>
			
			<%	
//				out.println("Report_Id====>" +Report_Id);
      	       if((Report_Id.equals("IPBMCSBU") || Report_Id.equals("IPBMIPCS")) && (!Report_Id.equals("")))
	           {
				
	         %>	
			 
			 <!-- <tr><td colspan='4'>&nbsp;</td></tr> -->
		 	   <tr id="no_of_beds"  >
			   <td align='right' class=label><fmt:message key="eMR.noofbeds.label" bundle="${mr_labels}"/></td>
			   	<td colspan='3' align='left'>&nbsp;&nbsp;&nbsp;<input type="Text" rows='2' name='no_of_bes' id='no_of_bes' value="<%=no_of_bes%>" size="12" maxlength='3'></td>
			 </tr>
			 
			 <!-- <tr><td colspan='4'>&nbsp;</td></tr> -->
		 	   <tr id="no_of_beds_0" style="" >
			   <td align='right' class=label><fmt:message key="eMR.noofficalbeds.label" bundle="${mr_labels}"/></td>
			   	<td colspan='3' align='left'>&nbsp;&nbsp;&nbsp;<input type="Text" rows='2' name='no_of_bes_0' id='no_of_bes_0'  onKeyPress='return chkForNumeric(event);'  value="<%=no_of_bes_0%>" size="12" maxlength='3'></td>
			 </tr>
			   <!-- <tr><td colspan='4'>&nbsp;</td></tr> -->
			   
			   <!--venkat-->
			   <tr id="no_of_beds_1" style="" >
			   <td align='right' class=label><fmt:message key="eMR.noofopertnalbeds.label" bundle="${mr_labels}"/></td>
			   	<td colspan='3' align='left'>&nbsp;&nbsp;&nbsp;<input type="Text" rows='2' name='no_of_bes_1' id='no_of_bes_1' onKeyPress='return chkForNumeric(event);'   value="<%=no_of_bes_1%>" size="12" maxlength='3'></td>
			 </tr>
			   <!--venkat-->
					 				
      		<tr>
					<td   align='right' class=label><fmt:message key="eMR.level1group.label" bundle="${mr_labels}"/></td>
					<% if(mode.equals("modify")){%>
						<td  colspan='3'>&nbsp;&nbsp;&nbsp;<textarea rows=2  cols=50 name="Main_Group_desc" onkeyPress='checkMaxLimit(this,150)' disabled onBlur="return makeValidString(this);" ><%=subgroup_desc%></textarea><input type="button" disabled name="sub_group11_level2" id="sub_group11_level2" value="?" class="BUTTON" onClick="getMainGroupId();"> 
						<input type='hidden' name="Main_Group" id="Main_Group" disabled value=<%=subgroup_desc%>>
						<img src="../../eCommon/images/mandatory.gif" style="visibility:<%=mand_gif2_visible%>" id='mand_gif2'></td>
					<%}else{%>
						<td  colspan='3'>&nbsp;&nbsp;
						<textarea rows=2  cols=50 name="Main_Group_desc" disabled readonly value=""></textarea><input type="button" disabled name="sub_group11_level2" id="sub_group11_level2" value="?" class="BUTTON" onClick="getMainGroupId();">
						<img src="../../eCommon/images/mandatory.gif" style="visibility:hidden" id='mand_gif2'><input type='hidden' name="Main_Group" id="Main_Group" value=""></td>
					<%}%>
					</td>
			</tr>
                  <!-- <tr><td colspan='4'>&nbsp;</td></tr> -->
				<tr>
				<!-- Newly added on 25/08/2005 shyam-->
			
				<td   align='right' class=label><fmt:message key="eMR.level2group.label" bundle="${mr_labels}"/></td>
				<% if(mode.equals("modify")){%>
				<td  colspan='3'>&nbsp;&nbsp;&nbsp;<textarea rows=2  cols=50 name="LEVEL3_CODE12" onkeyPress='checkMaxLimit(this,150)' disabled onBlur="return makeValidString(this);" ><%=LEVEL3_CODE_DESC%></textarea><input type="button" disabled name="sub_group11" id="sub_group11" value="?" class="BUTTON" onClick="getSubGroupId();"> 
				<input type='hidden' name="LEVEL3_CODE12" id="LEVEL3_CODE12" disabled value=<%=LEVEL3_CODE_DESC%>>

				<input type='hidden' name="LEVEL3_CODE_MODIFY" id="LEVEL3_CODE_MODIFY" value=<%=LEVEL3_CODE%>>
				<img src="../../eCommon/images/mandatory.gif" style="visibility:hidden" id='mand_gif3'></td><%}else{%>
				<td  colspan='3'>&nbsp;&nbsp;
				<textarea rows=2  cols=50 name="LEVEL3_CODE1" disabled readonly value=""></textarea><input type="button" disabled name="sub_group11" id="sub_group11" value="?" class="BUTTON" onClick="getSubGroupId();">
				<img src="../../eCommon/images/mandatory.gif" style="visibility:hidden" id='mand_gif3'><input type='hidden' name="LEVEL3_CODE_INSERT" id="LEVEL3_CODE_INSERT" value=""></td><%}%>
				
		</tr>

<!-- ragha -->
        <!-- <tr><td colspan='4'>&nbsp;</td></tr> -->
		</tr>
		<tr>
				 <td align='right' class='label' nowrap><fmt:message key="Common.Range.label" bundle="${common_labels}"/></td>
				 <td colspan='3' align='left'>&nbsp;&nbsp;
			     <%if(mode.equals("modify")){
				 %>
				 <textarea rows=2  cols=50 name="range" onkeyPress='checkMaxLimit(this,200)' disabled ><%=level3_range%></textarea>
				<img src="../../eCommon/images/mandatory.gif" style="visibility:hidden" id='mand_gif4'>
				<%}else {
				 %>
				<textarea rows=2  cols=50 name="range" onkeyPress='checkMaxLimit(this,200)' onblur="chkLimit_range(this);" disabled></textarea>
				<img src="../../eCommon/images/mandatory.gif" style="visibility:hidden" id='mand_gif4'>
				<%}%>
				</td>
				
     		    
			    
      		</tr>
			 <!-- <tr><td colspan='4'>&nbsp;</td></tr> -->
			</tr>
			<tr>
           
				<td  align='right' class=label><fmt:message key="Common.OrderSrlNo.label" bundle="${common_labels}"/></td>
				<td  class=label align='left'>&nbsp;&nbsp;&nbsp;<input type='text' name='serial_no' id='serial_no' size='3' maxlength='3' value='<%=order_serial_no%>'  onBlur="chknumber1(this);" onkeypress="return allowPositiveNumber()"><img src='../../eCommon/images/mandatory.gif'></img>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="eMR.printgroupname.label" bundle="${mr_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;<input type='checkbox' name='print_desc' id='print_desc' value="" <%=check_attribute%>  onClick="change()">&nbsp;&nbsp;&nbsp;<input type='hidden' name='prn_desc' id='prn_desc' value='<%=print_desc_yn%>'></td>
				
      		</tr>
			 <!-- <tr><td colspan='4'>&nbsp;</td></tr> -->
      	</table>
      	</div>
		<%
			   }else if(Report_Id.equals("")){
				%>
      		<tr>
				<td   align='right' class=label><fmt:message key="eMR.level1group.label" bundle="${mr_labels}"/></td>
				<% if(mode.equals("modify")){%>
				<td  colspan='3'>&nbsp;&nbsp;&nbsp;<textarea rows=2  cols=50 name="Main_Group_desc" onkeyPress='checkMaxLimit(this,150)' disabled onBlur="return makeValidString(this);" ><%=subgroup_desc%></textarea><input type="button" disabled name="sub_group11_level2" id="sub_group11_level2" value="?" class="BUTTON" onClick="getMainGroupId();"> 
				<input type='hidden' name="Main_Group" id="Main_Group" disabled value=<%=subgroup_desc%>><img src="../../eCommon/images/mandatory.gif" style="visibility:<%=mand_gif2_visible%>" id='mand_gif2'></td><%}else{%>
				<td  colspan='3'>&nbsp;&nbsp;
				<textarea rows=2  cols=50 name="Main_Group_desc" disabled readonly value=""></textarea><input type="button" disabled name="sub_group11_level2" id="sub_group11_level2" value="?" class="BUTTON" onClick="getMainGroupId();"><img src="../../eCommon/images/mandatory.gif" style="visibility:hidden" id='mand_gif2'><input type='hidden' name="Main_Group" id="Main_Group" value=""></td><%}%>
				
			    </td>
				</tr>
                  <tr>
			 <!-- <tr><td colspan='4'>&nbsp;</td></tr> -->
				<tr>
				<!-- Newly added on 25/08/2005 shyam-->
			
				<td   align='right' class=label><fmt:message key="eMR.level2group.label" bundle="${mr_labels}"/></td>
				<% if(mode.equals("modify")){%>
				<td  colspan='3'>&nbsp;&nbsp;&nbsp;<textarea rows=2  cols=50 name="LEVEL3_CODE12" onkeyPress='checkMaxLimit(this,150)' disabled onBlur="return makeValidString(this);" ><%=LEVEL3_CODE_DESC%></textarea><input type="button" disabled name="sub_group11" id="sub_group11" value="?" class="BUTTON" onClick="getSubGroupId();"> 
				<input type='hidden' name="LEVEL3_CODE12" id="LEVEL3_CODE12" disabled value=<%=LEVEL3_CODE_DESC%>>

				<input type='hidden' name="LEVEL3_CODE_MODIFY" id="LEVEL3_CODE_MODIFY" value=<%=LEVEL3_CODE%>>
				<img src="../../eCommon/images/mandatory.gif" style="visibility:hidden" id='mand_gif3'></td><%}else{%>
				<td  colspan='3'>&nbsp;&nbsp;
				<textarea rows=2  cols=50 name="LEVEL3_CODE1" disabled readonly value=""></textarea><input type="button" disabled name="sub_group11" id="sub_group11" value="?" class="BUTTON" onClick="getSubGroupId();">
				<img src="../../eCommon/images/mandatory.gif" style="visibility:hidden" id='mand_gif3'><input type='hidden' name="LEVEL3_CODE_INSERT" id="LEVEL3_CODE_INSERT" value=""></td><%}%>
				
		</tr>

<!-- ragha -->
        <!-- <tr><td colspan='4'>&nbsp;</td></tr> -->
		<tr>
				 <td align='right' class='label' nowrap><fmt:message key="Common.Range.label" bundle="${common_labels}"/></td>
				 <td colspan='3' align='left'>&nbsp;&nbsp;
			     <%if(mode.equals("modify")){
				 %>
				 <textarea rows=2  cols=50 name="range" onkeyPress='checkMaxLimit(this,200)' disabled ><%=level3_range%></textarea>
				<img src="../../eCommon/images/mandatory.gif" style="visibility:hidden" id='mand_gif4'>
				<%}else {
				 %>
				<textarea rows=2  cols=50 name="range" onkeyPress='checkMaxLimit(this,200)' onblur="chkLimit_range(this);" disabled></textarea>
				<img src="../../eCommon/images/mandatory.gif" style="visibility:hidden" id='mand_gif4'>
				<%}%>
				</td>
				
     		    
			    
      		</tr>
			 <!-- <tr><td colspan='4'>&nbsp;</td></tr> -->
			<tr>
           
				<td  align='right' class=label><fmt:message key="Common.OrderSrlNo.label" bundle="${common_labels}"/></td>
				<td  colspan='2' class=label align='left'>&nbsp;&nbsp;&nbsp;
				<input type='text' name='serial_no' id='serial_no' size='3' maxlength='3' value='<%=order_serial_no%>'  onBlur="chknumber1(this);" onkeypress="return allowPositiveNumber()"><img src='../../eCommon/images/mandatory.gif'></img>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="eMR.printgroupname.label" bundle="${mr_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;<input type='checkbox' name='print_desc' id='print_desc' value="" <%=check_attribute%>  onClick="change()">&nbsp;&nbsp;&nbsp;<input type='hidden' name='prn_desc' id='prn_desc' value='<%=print_desc_yn%>'></td>

      		</tr>
			 <!-- <tr><td colspan='4'>&nbsp;</td></tr> -->
      	</table>
      	</div>

		<%}%>

        	<%if(status){%>
      	<input type='hidden' name='function' id='function' value='insert'>
      	<input type='hidden' name='function_name' id='function_name' value='insert'>
      <%}else{%>
      	<input type='hidden' name='function' id='function' value='modify'>
      	<input type='hidden' name='function_name' id='function_name' value='modify'>

      	<input type='hidden' name='Report_Id_hid' id='Report_Id_hid' value=''>
      	<input type='hidden' name='Group_type_hid' id='Group_type_hid' value='<%=group_category%>'>

      	<input type='hidden' name='Main_Group_hid' id='Main_Group_hid' value='<%=subgroup_code%>'>
      	<input type='hidden' name='type_hid' id='type_hid' value='<%=table_reference%>'>

		<script>
			document.forms[0].Report_Id.disabled = true;
			document.forms[0].Group_type.disabled = true;
			document.forms[0].Main_Group.disabled = true;
			document.forms[0].type.disabled = true;
		</script>
     <%}%>
		<input type="hidden" name="err_msg" id="err_msg" value=''>
		<script>
			var msg = getMessage('DUPLI_SRL_NO','MR');
			document.ReportGroupFrm.err_msg.value = msg;
		</script>

      	  <input type="hidden" name="order_serial_no" id="order_serial_no" value='<%=order_serial_no%>'>
		  <input type="hidden" name="newstatus" id="newstatus" value='N'>
		  <input type='hidden' name='MainGroup' id='MainGroup' value='<%=subgroup_code%>'>
     	</form>
      	</body>
      	</html>
<%
}catch(Exception e){
	e.printStackTrace();
}
finally
{
	ConnectionManager.returnConnection(conn,request);
}
%>

<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

