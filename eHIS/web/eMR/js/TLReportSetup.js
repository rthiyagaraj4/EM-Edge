/*
   Created By   :  Shyam Prasad.P
   Created On   :  17/08/2005
   Function Name:  Tabulation List Setup
*/
function create(){
	f_query_add_mod.location.href = "../../eMR/jsp/TLLinkQueryFrames.jsp" ;
}
function query(){
	f_query_add_mod.location.href = "../../eMR/jsp/TLLinkQueryCriteria.jsp"
	
}
 
function clearMandatory(){ 
	var report = window.document.forms[0].Report.value;
	if(window.document.forms[0].Master.value==""){  
		document.forms[0].mand_gif1.style.visibility = "visible";
		document.forms[0].mand_gif2.style.visibility = "hidden";
	}
	else if((window.document.forms[0].Master.value=="SP" && report!="MRIPCSBD") || (window.document.forms[0].Master.value=="SP" && report!="MRIPCSOBD")){ //Modified  for this CRF PER-PD-209A
		document.forms[0].mand_gif2.style.visibility = "hidden";
	}
	else if(window.document.forms[0].Master.value=="TL"){
		document.forms[0].mand_gif1.style.visibility = "visible";
		document.forms[0].mand_gif2.style.visibility = "visible";
		document.forms[0].mand_gif3.style.visibility = "visible";
	}
	else if(window.document.forms[0].Master.value=="BD"){
		document.forms[0].mand_gif2.style.visibility = "hidden";
	}
	else if(window.document.forms[0].Master.value!=""){
		document.forms[0].mand_gif1.style.visibility = "visible";
	}
	
	//Commented by Ashwini on 12-Sep-2019 for ML-MMOH-CRF-1349
	/*if(report == "MROPCSMB"){
     	document.forms[0].mand_gif1.style.visibility = "visible";
		document.forms[0].mand_gif2.style.visibility = "hidden";
		document.forms[0].mand_gif3.style.visibility = "hidden";
	}
	else*/
	
	//MROPCSMS Added by Ashwini on 19-May-2020 for ML-MMOH-CRF-1532
	if(report == "MROPCSMS"){
     	document.forms[0].mand_gif1.style.visibility = "visible";
		document.forms[0].mand_gif2.style.visibility = "hidden";
		document.forms[0].mand_gif3.style.visibility = "hidden";
	}
	
	if(report == "IPBMRMOT" || report == "IPBEXCDT" || report == "OPBMTMOR"){
		document.forms[0].mand_gif1.style.visibility = "visible";
		document.forms[0].mand_gif2.style.visibility = "visible";
		document.forms[0].mand_gif3.style.visibility = "hidden";
	}
}

function FetchValues(){
	type =	document.forms[0].Master.value
	report_id				= document.forms[0].Report.value
	group_code			= document.forms[0].Main_group.value
	sub_group_code	= document.forms[0].sub_group.value
	var level_code3	= document.forms[0].level_code3.value
	/*parent.parent.frames[1].increasesize.rows='70,*';*/
	if(report_id=='MRIPCSMB' || report_id=='MROPCSMB' || report_id=='MROPCSMS' || report_id=='OPBMTMOR' || report_id=='IPBMRMOT' || report_id=='IPBEXCDT' || report_id=='MRDCCSMB' || report_id=='MRDCPROD' || report_id=='MRDCPROS'){   //Modified for this CRF PER-RH-0206 
		var fromvalue=document.forms[0].tabulation_list_desc_from.value
		var tovalue=document.forms[0].tabulation_list_desc_to.value
		var code_from='';
	    if(fromvalue!='' || tovalue!='') {
	    	code_from=document.forms[0].tabulation_list_desc_from.value+"|"+document.forms[0].tabulation_list_desc_to.value;
		}
		var code_to=document.forms[0].tabulation_list_desc_to.value
		var code_desc=document.forms[0].list_desc.value
	}	
	var sm='';
	/*parent.parent.frames[3].location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+sm;*/
	parent.parent.frames[1].frames[1].location.href='../../eCommon/html/blank.html';

	var GroupName_lbl		=	parent.parent.f_query_add_mod.f_query_add_mod_search.getLabel("Common.GroupName.label","Common");
	var report_lbl				=	parent.parent.f_query_add_mod.f_query_add_mod_search.getLabel("Common.report.label","Common");
	var level_1_grp_lbl		=	parent.parent.f_query_add_mod.f_query_add_mod_search.getLabel("eMR.level1group.label","eMR");
	var level_2_grp_lbl		=	parent.parent.f_query_add_mod.f_query_add_mod_search.getLabel("eMR.level2group.label","eMR");
	var level_3_grp_lbl		=	parent.parent.f_query_add_mod.f_query_add_mod_search.getLabel("eMR.level3group.label","eMR");
	var Master_lbl				=	parent.parent.f_query_add_mod.f_query_add_mod_search.getLabel("eMR.Master.label","eMR");
	var OrderSrlNo_lbl		=	parent.parent.f_query_add_mod.f_query_add_mod_search.getLabel("Common.OrderSrlNo.label","Common");
	var ListDesc_lbl			=	parent.parent.f_query_add_mod.f_query_add_mod_search.getLabel("eMR.ListDesc.label","eMR");


	if(report_id=='IPBMIPCS'){
		var fields = new Array (document.forms[0].Main_group_desc)
		var names  = new Array (level_1_grp_lbl)
	}else if(report_id=='MRIPCSMH' && type=='IC'){ 
		var fields = new Array (document.forms[0].Report,document.forms[0].Master,document.forms[0].Main_group_desc,document.forms[0].alpha_desc)
		var names  = new Array ( report_lbl,level_1_grp_lbl,ListDesc_lbl)
	}else if((report_id=='MRBBAT3A' || report_id=='MRBBAT3B' || report_id=='MRBBAT3C') && type=='IC'){ 
		var fields = new Array (document.forms[0].Report,document.forms[0].Master,document.forms[0].Main_group_desc,document.forms[0].alpha_desc)
		var names  = new Array ( report_lbl,Master_lbl,level_1_grp_lbl,ListDesc_lbl)
	}else if(report_id=='MROPCSMS' || report_id=='MRBLABWL' || report_id=='MRBSS203' || report_id=='MROPCSAT' || report_id=='MRBRH203' || report_id=='MRIPCSMH' || report_id=='MRIPCSEG' || report_id=='MRBRH212' || report_id=='MROPANPO' || report_id=='MROPCSEG' || report_id=='MROPRFLS' || report_id=='IPBMCSBU' || (report_id=='MRIPCSBD' && type=='BD') || (report_id=='MRIPCSOBD' && type=='BD')  || report_id=='MRDCPROD' || report_id=='MRDCPROS'){//MRBRH203 added by Rameswar on 09/11/2016 for HSA-CRF-0209.1 //Modified by Ashwini on 12-Sep-2019 for ML-MMOH-CRF-1349
	  //Below line modified for this CRF PER-PD-209A //MROPCSMS Added by Ashwini on 19-May-2020 for ML-MMOH-CRF-1532
	    var fields = new Array (document.forms[0].Report,document.forms[0].Master,document.forms[0].Main_group_desc)
		var names  = new Array ( report_lbl,Master_lbl,level_1_grp_lbl)
	}else if(report_id=='IPBMRMOT' || report_id=='IPBEXCDT' || report_id=='OPBMTMOR' || report_id=='MRBRADEX' || report_id=='MRBLABRG' || (report_id=='MRIPCSBD' && type=='SP') || (report_id=='MRIPCSOBD' && type=='SP')){ //Below line modified for this CRF PER-PD-209A
		var fields = new Array (document.forms[0].Report,document.forms[0].Master,document.forms[0].Main_group_desc,document.forms[0].sub_group1);
	    var names  = new Array (report_lbl,Master_lbl,level_1_grp_lbl,level_2_grp_lbl);
	}else if(report_id=='MRIPCSMB' || report_id=='MRDCCSMB' || report_id=='MROPCSMB'){ //Modified for this CRF PER-RH-0206 //Modified by Ashwini on 12-Sep-2019 for ML-MMOH-CRF-1349 //MROPCSMS Removed by Ashwini on 19-May-2020 for ML-MMOH-CRF-1532
		var fields = new Array (document.forms[0].Report,document.forms[0].Master,document.forms[0].Main_group_desc,document.forms[0].sub_group1,document.forms[0].level_code3_desc);
	    var names  = new Array (report_lbl,Master_lbl,level_1_grp_lbl,level_2_grp_lbl,level_3_grp_lbl);
	}else  if((report_id=='MRBPD207'&& type=='SP') || report_id=='MRBBAT3A' || report_id=='MRBBAT3B' || report_id=='MRBBAT3C' ){
	    var fields = new Array (document.forms[0].Report,document.forms[0].Master,document.forms[0].Main_group_desc)
		var names  = new Array ( report_lbl,Master_lbl,level_1_grp_lbl)
	 }else  if(report_id=='MRBPD207'&& type=='BC'){
	    var fields = new Array (document.forms[0].Report,document.forms[0].Master,document.forms[0].Main_group_desc,document.forms[0].sub_group1)
		var names  = new Array ( report_lbl,Master_lbl,level_1_grp_lbl,level_2_grp_lbl)
	 }
	 else  if(report_id=='IPBMCREF' && type!=''){	 	
	    var fields = new Array (document.forms[0].Main_group_desc)
		var names  = new Array (level_1_grp_lbl);
	 }//Added by Rameswar Mohanty on 11/11/2016 for IN062545

		
		/*else
	{
      var fields = new Array (document.forms[0].Report,document.forms[0].Master,document.forms[0].Main_group_desc)
		var names  = new Array ( "Report","Master","Level1 Group")
	}
	*/
	else{ 
      var fields = new Array (document.forms[0].Report,document.forms[0].Master)
		var names  = new Array ( report_lbl,Master_lbl)
	} 	
	if(parent.f_query_add_mod_search.checkFieldsofMst(fields, names, parent.parent.messageFrame)){
		  if(report_id=='MRBRADEX' ||report_id=='MRBLABWL' || report_id=='MRBLABRG'){
		  var msg ="";
		  var sp  ="OC";
		  parent.frames[1].location.href="../../eMR/jsp/SSOrderCatalogLinkResult.jsp?report_id="+report_id+"& master="+sp+"&group_code="+group_code+"&sub_group_code="+sub_group_code+"&reference=OC&alphabet=A";
		/*  parent.parent.frames[3].location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;*/
	      }
		  else if(report_id=='MRIPCSMH' && document.forms[0].Master.value=='IC'){
		  
				var msg ="";
				var sp  ="IC";
				var searchby=document.forms[0].searchby.value;
				var searchcrt=document.forms[0].searchcriteria.value;
				var alphadescription=document.forms[0].alpha_desc.value;
				parent.frames[1].location.href="../../eMR/jsp/SSOrderCatalogLinkResult.jsp?report_id="+report_id+"& master=IC&group_code="+group_code+"&sub_group_code="+sub_group_code+"&reference=IC&alphabet=''&searchby="+searchby+"&alphadescription="+alphadescription+"&searchcrt="+searchcrt;
				parent.parent.frames[3].location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
		  }else if((report_id=='MRBBAT3A' ||report_id=='MRBBAT3B' || report_id=='MRBBAT3C') && document.forms[0].Master.value=='IC'){
				var msg ="";
				var sp  ="IC";
				var searchby=document.forms[0].searchby.value;
				var searchcrt=document.forms[0].searchcriteria.value;
				var alphadescription=document.forms[0].alpha_desc.value;
				parent.frames[1].location.href="../../eMR/jsp/SSOrderCatalogLinkResult.jsp?report_id="+report_id+"& master=IC&group_code="+group_code+"&sub_group_code="+sub_group_code+"&reference=IC&alphabet=''&searchby="+searchby+"&alphadescription="+alphadescription+"&searchcrt="+searchcrt;
				parent.parent.frames[3].location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
		  }else if(report_id=='MRBSS203' ){
			  if(document.forms[0].Master.value=="OC"){
					var msg ="";
					var sp  ="OC";
					parent.frames[1].location.href="../../eMR/jsp/SSOrderCatalogLinkResult.jsp?report_id="+report_id+"& reference1="+sp+"&group_code="+group_code+"&sub_group_code="+sub_group_code+"&reference=OC&alphabet=A";
					parent.parent.frames[3].location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
			  }else{
			  
					var msg="";
					var sp ="TL";
					parent.frames[1].location.href="../../eMR/jsp/TlLinkResult.jsp?report_id="+report_id+"& type="+type+"&group_code="+group_code+"&sub_group_code="+sub_group_code+"&level_code3="+level_code3+"&alphabet="+type+"&code_from="+code_from+"&code_to"+code_from+"&code_desc="+code_desc;
				parent.parent.frames[3].location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
			  }
		  }else if(report_id=='MRBPD207'){
				var msg="";
				var Bc ="BC";
				parent.frames[1].location.href="../../eMR/jsp/TlLinkResult.jsp?report_id="+report_id+"& type="+type+"&group_code="+group_code+"&sub_group_code="+sub_group_code+"&level_code3="+level_code3+"&alphabet="+type+"&code_from="+code_from+"&code_to"+code_from+"&code_desc="+code_desc;
				/*parent.parent.frames[3].location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;*/
		      }
		  else{
			  var msg="";
			  var sp ="TL";
			  parent.frames[1].location.href="../../eMR/jsp/TlLinkResult.jsp?report_id="+report_id+"& type="+type+"&group_code="+group_code+"&sub_group_code="+sub_group_code+"&level_code3="+level_code3+"&alphabet="+type+"&code_from="+code_from+"&code_to"+code_from+"&code_desc="+code_desc;
			 /* parent.parent.frames[3].location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;*/
	      }
	}else{   
		  parent.parent.frames[1].frames[1].location.href='../../eCommon/html/blank.html';
		  /*parent.parent.frames[1].increasesize.rows='260,*'*/
	}
	
}

function funchk(obj){
	var formObj=parent.parent.f_query_add_mod.f_query_add_mod_search;
   var ptr=obj.name;
   var str=eval(ptr.substring(3,ptr.length))
   var obj1=document.forms[0];
   var obj2=eval("obj1.text"+str);
   var concat1=obj2.value
   if(obj.checked==true){
		obj.value="Y";
		if(concat1==""){
//			alert("APP-MR0042 Order Serial No Cannot Be Blank");
			var err_msg=formObj.getMessage('ORDER_SRLNO_CANNOT_BE_BLANK','MR');
			alert(err_msg)
			obj2.focus();
			obj2.select();
		}
   }else
    obj.value="N";
}
function apply(){  
		if (! (checkIsValidForProceed()) ){
			parent.content.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
			return false;
    } 
	var msg='';
//	var report_id=parent.frames[1].frames[1].frames[0].document.forms[0].Report.value;
//    var master=parent.frames[1].frames[1].frames[0].document.forms[0].Master.value;
	var criteria_FormObj =	parent.content.f_query_add_mod.f_query_add_mod_search.document.ssordercatalog_form;
	var result_FormObj	 =	parent.content.f_query_add_mod.f_query_add_mod_result.document.ssorderresult;

	var report_id = criteria_FormObj.Report.value;
    var master	 = criteria_FormObj.Master.value;
	if(result_FormObj!=null){  //Modified for this CRF PER-RH-0206 and PER-PD-209A
		//Modified by Ashwini on 28-Jan-2021 for ML-MMOH-CRF-1341
		if(report_id == "IPBMIPCS" || report_id=="MROPCSMB" || report_id=="MRIPCSMB" || report_id=="MRDCCSMB" || report_id=="MROPCSMS" || report_id=="MROPRFLS" || report_id=="MRIPCSBD" || (report_id=="MRIPCSMH" && master=="DT") || (report_id=="MRIPCSMH" && master=="SP") || (report_id=="MRIPCSMH" && master=="RC") || (report_id=="MRIPCSMH" && master=="DA") || report_id=="MRIPCSEG" || report_id=="MRBRH212" || report_id=="MROPANPO" || report_id=="MROPCSAT"|| report_id=="MRBRH203" || report_id=="IPBMCSBU" || report_id=="MROPCSEG" || (report_id=="MRBSS203" && master=="SP") || report_id=='OPBMTMOR' || report_id=='IPBMRMOT' || report_id=='IPBEXCDT' || report_id=='MRBPD207' || report_id=='IPBMCREF' || (report_id=="MRBBAT3A" && master!="IC") || (report_id=="MRBBAT3B" && master=="HC") || (report_id=="MRBBAT3C" && master=="HC") || report_id=="MRDCPROD"  || report_id=="MRDCPROS"  || report_id=="MRIPCSOBD"){ //MRBRH203 added by Rameswar on 09/11/2016 for HSA-CRF-0209.1
	 	result_FormObj.function_name1.value="tabulation";
		result_FormObj.submit();
		}
		else
			result_FormObj.submit();
	}
	else
		parent.content.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
}

function onSuccess(){
	create();
	
}
function clearValues(){
//	var FormObj=parent.parent.content.f_query_add_mod.f_query_add_mod_search.document.ssordercatalog_form;
//	parent.parent.content.f_query_add_mod.f_query_add_mod_search.location.href='../../eCommon/html/blank.html';
//	parent.parent.f_query_add_mod_search.location.href='../../eCommon/html/blank.html';
	parent.parent.f_query_add_mod.f_query_add_mod_result.location.href='../../eCommon/html/blank.html';
	/*parent.parent.f_query_add_mod.increasesize.rows='260,*'*/
}
function reset(){
	var FormObj=parent.content.f_query_add_mod.f_query_add_mod_search;
	var result_FormObj	 =	parent.content.f_query_add_mod.f_query_add_mod_result;

	if(parent.content.f_query_add_mod.document.forms[0]){
//	 	  parent.frames[1].frames[1].location.reload();
			parent.content.f_query_add_mod.location.reload();
	}else if(FormObj){
		/*parent.parent.content.f_query_add_mod.increasesize.rows='260,*'*/
//		parent.frames[1].frames[1].frames[0].location.reload();
		FormObj.location.reload();
		result_FormObj.location.href='../../eCommon/html/blank.html';

	}
//			parent.parent.content.f_query_add_mod.f_query_add_mod_result.location.href='../../eCommon/html/blank.html';
//
//			parent.parent.content.f_query_add_mod.f_query_add_mod_search.location.reload();
	}
	/*else{
		  parent.frames[1].frames[1].increasesize.rows='260,*'
		  parent.frames[1].frames[1].frames[0].location.reload();
	      parent.frames[1].frames[1].frames[1].location.href='../../eCommon/html/blank.html';
	}*/
//}
function callMember(alpha){ 
		document.forms[0].alphabet.value=alpha;
		document.forms[0].target="f_query_add_mod_result";
		document.forms[0].action="../../eMR/jsp/SSOrderCatalogLinkResult.jsp";
		document.forms[0].submit();
}
function subGroup1(){
   parent.parent.frames[1].frames[1].document.location.href="../../eCommon/html/blank.html";  
   /*parent.parent.frames[1].increasesize.rows='260,*'*/
}

function chkvalidnum(obj){
	var formObj=parent.parent.f_query_add_mod.f_query_add_mod_search;
	var num=obj.value;
	if(eval(num)=="0" || eval(num)=="00" || eval(num)=="000"){
		var err_msg=parent.parent.f_query_add_mod.f_query_add_mod_search.getLabel("Common.OrderSrlNo.label","Common");
		//	  var msg=geteMRMessage("INVALID_SERIAL_NO");--V3Code
		//var msg="APP-MR001 Order Srl No Value should be greater than 0";
		var err_msg=formObj.getMessage('INVALID_SERIAL_NO','MR');
		alert(err_msg);
		obj.focus();
		obj.select();
  }
}

async function getSubGroupId(){
		/*parent.parent.frames[3].location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";*/
		parent.parent.frames[1].frames[1].document.location.href="../../eCommon/html/blank.html"; 
	/*	parent.parent.frames[1].increasesize.rows='260,*'*/
        document.forms[0].level_code3_desc.value='';
		document.getElementById("fetchdata").innerText='';

		var target				= document.forms[0].sub_group;
		var report_gr_id	= document.forms[0].Report.value;
		var main_group		= document.forms[0].Main_group.value;
		var master			= document.forms[0].Master.value;
		var retVal				=  new String();
		var dialogTop		= "";
		var dialogHeight	= "400px" ;
		var dialogWidth	    = "700px" ;
		var features			= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
		var arguments		= "" ;
		var search_desc	="";
		var search_code	="";
//		var title					=Level2 Group;--V3Code;
		var title					=parent.parent.f_query_add_mod.f_query_add_mod_search.getLabel("eMR.level2group.label","eMR");
		var sql					= ""
		if (report_gr_id == 'MRBPD207'){
			sql="select group_code, group_desc from mr_report_grouping where report_id =`"+report_gr_id+"` and subgroup_code =`"+main_group+"` and group_category = `S` and mast_table_name_reference = `"+master+"`" ;
		}else{
			sql="select group_code, group_desc from mr_report_grouping where report_id =`"+report_gr_id+"` and subgroup_code =`"+main_group+"` and group_category = `S` and group_type is null" ;
		}
	/*	var sql="select group_code, group_desc from mr_report_grouping where report_id =`"+report_gr_id+"` and subgroup_code =`"+main_group+"` and group_category = `S` " ; */
		
		search_code="group_code";
		search_desc="group_desc";
		retVal= await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+title+"&dispDescFirst=dispDescFirst",arguments,features);
	    var arr=new Array();
	    if (retVal != null && retVal != '' && retVal != "null"){
			var retVal=unescape(retVal);
		    arr=retVal.split("::");
		    document.forms[0].sub_group1.value=arr[0];
			document.forms[0].sub_group.value=arr[1];
			document.forms[0].sub_group1.focus();
		   
		if(report_gr_id=="MRBLABRG" || report_gr_id=="MRBRADEX" || report_gr_id=="MRIPCSBD" || report_gr_id=="MRIPCSOBD") { //Modified for this CRF PER-PD-209A
			 var HTMLVal="<html><body><form name='tempform1' id='tempform1' method='post' action='../../eMR/jsp/TLPopulateValues.jsp'><input type='hidden' name=report_gr_id value="+report_gr_id+"><input type='hidden' name=master value="+master+"><input type='hidden' name=main_group value="+main_group+"><input type='hidden' name=levelcode value="+arr[1]+"></form></body></html>";
			 parent.parent.frames[2].document.write(HTMLVal);
			 parent.parent.frames[2].document.tempform1.submit(); 
			}
		}
	}

	async function getLevel3GroupId(){
		/*parent.parent.frames[3].location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";*/
		parent.parent.frames[1].frames[1].document.location.href="../../eCommon/html/blank.html"; 
		/*parent.parent.frames[1].increasesize.rows='260,*'*/

		var target				= document.forms[0].sub_group;
		var report_gr_id	= document.forms[0].Report.value;
		var main_group		 = document.forms[0].Main_group.value;
		var sub_group		= document.forms[0].sub_group.value;
		var retVal	     = new String();
		var dialogTop			= "";
		var dialogHeight		= "400px" ;
		var dialogWidth			= "700px" ;
		var features			= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
		var arguments			= "" ;
		var search_desc="";
		var search_code=""; 
//		var title="Level3 Group";--v3 cODE
		var title=parent.parent.f_query_add_mod.f_query_add_mod_search.getLabel("eMR.level3group.label","eMR");
		var sql="select group_code, group_desc from mr_report_grouping where report_id =`"+report_gr_id+"` and subgroup_code =`"+main_group+"` and level3_code  =`"+sub_group+"` and group_category = `G` " ;
      	search_code="group_code";
		search_desc="group_desc";
		retVal=await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+title+"&dispDescFirst=dispDescFirst",arguments,features);
	    var arr=new Array();

	    if (retVal != null && retVal != '' && retVal != "null"){
			var retVal=unescape(retVal);
			arr=retVal.split("::");
		    document.forms[0].level_code3_desc.value=arr[0];
			document.forms[0].level_code3.value=arr[1]; 
			document.forms[0].level_code3_desc.focus();
		
		var HTMLVal="<html><body><form name='tempform1' id='tempform1' method='post' action='../../eMR/jsp/TLPopulateValues.jsp'><input type='hidden' name=report_gr_id id=report_gr_id value="+report_gr_id+"><input type='hidden' name=sub_group_code id=sub_group_code value="+sub_group+"><input type='hidden' name=main_group id=main_group value="+main_group+"><input type='hidden' name=levelcode id=levelcode value="+arr[1]+"></form></body></html>";
		parent.parent.frames[2].document.write(HTMLVal);
	    parent.parent.frames[2].document.tempform1.submit(); 
	  }
	}
	function callClear(){
		parent.parent.frames[3].location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";
		document.forms[0].sub_group1.value=''; 
	    document.forms[0].level_code3_desc.value=''; 
		parent.parent.frames[1].frames[1].document.location.href="../../eCommon/html/blank.html"; 
		parent.parent.frames[1].increasesize.rows='260,*'
	}
	function allowPositiveNumber() {
		var key = window.event.keyCode;
		var rep = parent.frames[0].document.forms[0].Report.value
		if(rep=="MRIPCSMB" || rep=="MRDCCSMB" || rep=="MROPCSMB")
		{  //Modified for this CRF PER-RH-0206 //Modified by Ashwini on 12-Sep-2019 for ML-MMOH-CRF-1349 //MROPCSMS Removed by Ashwini on 19-May-2020 for ML-MMOH-CRF-1532
			if(((key >=48 ) && (key<58)) ||(key==46)) 
			{
				return true;
			}
			else
				return false;
		}
		else
		{
			if(((key >=48 ) && (key<58))) 
			{
				return true;
			}
			else
				return false;
		}
	}
	/////////////////////////////Changing to LookUp//////////////////////////////

	async function getLevelGroupId(){
	
		/*parent.parent.frames[3].location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";*/
		parent.parent.frames[1].frames[1].document.location.href="../../eCommon/html/blank.html"; 
	/*	parent.parent.frames[1].increasesize.rows='260,*'*/
		document.forms[0].level_code3_desc.value='';
		var master_table_reference			=document.forms[0].Master.value;
		
		document.forms[0].sub_group1.value	='';
		document.getElementById("fetchdata").innerText	='';

		var target= document.forms[0].Main_group_desc;
		var report_gr_id=document.forms[0].Report.value;
		
		var retVal	=  new String();
		var dialogTop			= "";
		var dialogHeight		= "400px" ;
		var dialogWidth			= "700px" ;
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
	    if (retVal != null && retVal != '' && retVal != "null"){
			var retVal=unescape(retVal);
			arr=retVal.split("::");
		    document.forms[0].Main_group_desc.value=arr[0];
			document.forms[0].Main_group.value=arr[1]; 
			document.forms[0].Main_group_desc.focus();

		//Modified by Ashwini on 12-Sep-2019 for ML-MMOH-CRF-1349 //MROPCSMS Added by Ashwini on 19-May-2020 for ML-MMOH-CRF-1532
		if(report_gr_id=="MROPCSMS" || report_gr_id=="MRBLABWL" || report_gr_id=="MROPRFLS" || report_gr_id=="MRIPCSMH" || report_gr_id=="MRBRH212" || report_gr_id=="MRIPCSEG"  || report_gr_id=="MROPANPO" || report_gr_id=="MROPCSAT" || report_gr_id=="MRBRH203" || report_gr_id=="IPBMCSBU" || report_gr_id=="MRBSS203" || report_gr_id=="MROPCSEG" || report_gr_id=='OPBMTMOR' || report_gr_id=='IPBMRMOT' || report_gr_id=='IPBEXCDT' || report_gr_id=='MRBPD207' || report_gr_id=='MRDCPROD'|| report_gr_id=='MRDCPROS' ){//MRBRH203 added by Rameswar on 09/11/2016 for HSA-CRF-0209.1
			 var HTMLVal="<html><body><form name='tempform1' id='tempform1' method='post' action='../../eMR/jsp/TLPopulateValues.jsp'><input type='hidden' name=report_gr_id value="+report_gr_id+"><input type='hidden' name=main_group value="+arr[1]+"><input type='hidden' name=master_table_reference1 value="+master_table_reference+"></form></body></html>";
			 parent.parent.frames[2].document.write(HTMLVal);
			 parent.parent.frames[2].document.tempform1.submit();
		}
	}
	}

	function callOtherReport(obj){
	 
		var master = document.forms[0].Master.value;
		var sm='';
		/*parent.parent.frames[3].location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+sm;*/
	/*	parent.parent.frames[1].increasesize.rows='260,*'*/
		parent.parent.frames[1].frames[1].location.href='../../eCommon/html/blank.html';
		document.forms[0].level_code3.value='';
		document.forms[0].serialvalue.value='';
		document.forms[0].sub_group.value='';
		document.forms[0].Main_group.value='';
		//document.forms[0].tabulation_list_desc_to.value='';
		//document.forms[0].tabulation_list_desc_from.value='';
		//document.forms[0].list_desc.value='';
		
		//Modified by Ashwini on 12-Sep-2019 for ML-MMOH-CRF-1349 //MROPCSMS Added by Ashwini on 19-May-2020 for ML-MMOH-CRF-1532
		if(obj.value=='MRBSS203' || obj.value=='MRBLABWL'  || obj.value== 'MRDCPROD' || obj.value== 'MRDCPROS' || obj.value=='MROPCSMS'){     
			document.forms[0].Main_group_desc.disabled = false;
			document.forms[0].Main_group_desc.value    = '';
			document.forms[0].sub_group11.disabled     = false;
			document.forms[0].sub_group1.disabled      = true;
			document.forms[0].sub_group1.value         = '';
			document.forms[0].sub_group12.disabled     = true;
			document.forms[0].level_code3_desc.disabled= true;
			document.forms[0].level_code3_desc.value   = '';
			document.forms[0].sub_group13.disabled     = true;
			document.forms[0].mand_gif3.style.visibility = "hidden";
			document.forms[0].mand_gif2.style.visibility = "hidden";
			document.forms[0].mand_gif1.style.visibility = "visible";
			document.getElementById('fetchdata').innerText='';
		}
		//Newly added
	
		else if(obj.value=='MROPRFLS' || obj.value=='MROPCSAT' || obj.value=='MRBRH203' ||  obj.value=='MRIPCSMH' || obj.value=='MRIPCSEG' || obj.value=='MRBRH212' || obj.value=='MROPANPO' || obj.value=='MROPCSEG' || obj.value=='IPBMCSBU' || obj.value=='MRBPD207' || obj.value=='IPBMIPCS'){     
			document.forms[0].Main_group_desc.disabled = false;
			document.forms[0].Main_group_desc.value    = '';
			document.forms[0].sub_group11.disabled     = false;
			document.forms[0].sub_group1.disabled      = '';
			document.forms[0].sub_group1.value         = '';
			document.forms[0].sub_group12.disabled     = false;
			document.forms[0].level_code3_desc.disabled= true;
			document.forms[0].level_code3_desc.value   = '';
			document.forms[0].sub_group13.disabled     = true;
			document.forms[0].mand_gif3.style.visibility = "hidden";
			document.forms[0].mand_gif2.style.visibility = "hidden";
			document.forms[0].mand_gif1.style.visibility = "hidden";
			document.getElementById("fetchdata").innerText='';
		
		if(obj.value=='IPBMIPCS' || obj.value=='MROPCSAT' || obj.value=='MRBRH203' )//MRBRH203 added by Rameswar on 09/11/2016 for HSA-CRF-0209.1
			document.forms[0].mand_gif1.style.visibility = "visible";

		}

		else if(obj.value=='MRBRADEX' || obj.value=='MRBLABRG' || (obj.value=='MRIPCSBD' && master=='SP') || obj.value=='OPBMTMOR' || obj.value=='IPBMRMOT' || obj.value=='IPBEXCDT' || (obj.value=='MRIPCSOBD' && master=='SP')){  //modified for this CRF PER-PD-209A  
			document.forms[0].mand_gif3.style.visibility = "hidden";
			document.forms[0].mand_gif2.style.visibility = "visible";
			document.forms[0].mand_gif1.style.visibility = "visible";
			document.forms[0].Main_group_desc.disabled=false;
			document.forms[0].Main_group_desc.value='';
			document.forms[0].sub_group11.disabled=false;
			document.forms[0].sub_group1.disabled=false;
			document.forms[0].sub_group1.value='';
			document.forms[0].sub_group.value='';
			document.forms[0].sub_group12.disabled=false;
			document.forms[0].level_code3_desc.disabled=true;
			document.forms[0].level_code3_desc.value='';
			document.forms[0].sub_group13.disabled=true;
			document.getElementById("fetchdata").innerText='';
		
		}else if(obj.value=='MRIPCSMB' || obj.value=='MRDCCSMB' || obj.value=='MROPCSMB'){     //Modified for this CRF PER-RH-0206 //Modified by Ashwini on 12-Sep-2019 for ML-MMOH-CRF-1349 //MROPCSMS Removed by Ashwini on 19-May-2020 for ML-MMOH-CRF-1532

			document.forms[0].mand_gif3.style.visibility = "visible";
			document.forms[0].mand_gif2.style.visibility = "visible";
			document.forms[0].mand_gif1.style.visibility = "visible";
			document.forms[0].Main_group_desc.disabled=false;
			document.forms[0].Main_group_desc.value='';
			document.forms[0].sub_group11.disabled=false;
			document.forms[0].sub_group1.disabled=false;
			document.forms[0].sub_group1.value='';
			document.forms[0].sub_group.value='';
			document.forms[0].sub_group12.disabled=false;
			document.forms[0].level_code3_desc.disabled=false;
			document.forms[0].level_code3_desc.value='';
			document.forms[0].sub_group13.disabled=false;
			document.getElementById("fetchdata").innerText='';
		}else{
			
			document.forms[0].mand_gif3.style.visibility = "hidden";
			document.forms[0].mand_gif2.style.visibility = "hidden";
			document.forms[0].mand_gif1.style.visibility = "hidden";
			document.forms[0].Main_group_desc.disabled=false;
			document.forms[0].Main_group_desc.value='';
			document.forms[0].sub_group11.disabled=false;
			document.forms[0].sub_group1.disabled=false;
			document.forms[0].sub_group1.value='';
			document.forms[0].sub_group12.disabled=false;
			document.forms[0].level_code3_desc.disabled=false;
			document.forms[0].level_code3_desc.value='';
			document.forms[0].sub_group13.disabled=false;
			document.getElementById("fetchdata").innerText='';
		}
		if(obj.value=='MRIPCSMB' || obj.value=='MRDCCSMB' || obj.value=='MROPCSMB' || obj.value=='MROPCSMS' || obj.value=='OPBMTMOR' || obj.value=='IPBMRMOT' || obj.value=='IPBEXCDT'  || obj.value== 'MRDCPROD' || obj.value== 'MRDCPROS'){ //Modified for this CRF PER-RH-0206
			var ListDesc_lbl	= getLabel("eMR.ListDesc.label","eMR");
			var tab_code_lbl	= getLabel("eMR.tabcode.label","eMR");
		/*   parent.parent.frames[1].increasesize.rows='350,*'*/
		   tabdata="<table cellpadding=0 cellspacing=0 border='0'  width='100%' height='100%'><tr><td class=label width='6%' align=left>"+tab_code_lbl+"</td><td align='left' width='10%'><input type='text' size='5' name='tabulation_list_desc_from' id='tabulation_list_desc_from' onblur='getTablistData(tabulation_list_desc_from)' ><input type='hidden' name='tabulation_list_from' id='tabulation_list_from' value=''><input type='button' class='button' value='?' name='search_button_from' id='search_button_from'  onClick='searchCode(tabulation_list_desc_from)' >&nbsp;&nbsp;-&nbsp;&nbsp;<input type='text' size='5' name='tabulation_list_desc_to' id='tabulation_list_desc_to' onblur='getTablistData(tabulation_list_desc_to)'><input type='hidden' name='tabulation_list_to' id='tabulation_list_to' value=''><input type='button' class='button' value='?' name='search_button_to' id='search_button_to' onClick='searchCode(tabulation_list_desc_to)' ></td><td width='1%'></td><td class=label align=right width='5%'>&nbsp;&nbsp;"+ListDesc_lbl+"&nbsp;</td><td width='10%' align=left><input type='text'  name='list_desc' id='list_desc'></td></td></table>";
		  document.getElementById("t").innerHTML=tabdata;
		   document.getElementById("t").style.visibility='visible' 
           /*parent.parent.frames[1].increasesize.rows='350,*'*/
		   document.getElementById("t1").style.visibility='hidden' 
		   document.getElementById("t1").innerHTML='';
		   //document.forms[0].tabulation_list_desc_to.disabled=false;
		   ///document.forms[0].tabulation_list_desc_from.disabled=false;
		   //document.forms[0].search_button_from.disabled=false;
		   //document.forms[0].search_button_to.disabled=false;
		   //document.forms[0].list_desc.disabled=false;

		}else{
          /* parent.parent.frames[1].increasesize.rows='280,*'*/
		   //document.forms[0].tabulation_list_desc_to.disabled=true;
		   //document.forms[0].tabulation_list_desc_from.disabled=true;
		   //document.forms[0].search_button_from.disabled=true;
		   //document.forms[0].search_button_to.disabled=true;
		   //document.forms[0].list_desc.disabled=true;
		   document.getElementById("t").innerHTML='';
		   document.getElementById("t1").innerHTML='';
		  // document.forms[0].tabulation_list_desc_to.value='';
		  // document.forms[0].tabulation_list_desc_from.value='';
		 // document.forms[0].list_desc.value='';
		    document.getElementById("t").style.visibility='hidden' 
			document.getElementById("t1").style.visibility='hidden' 
		}
	}

	/////////////Newly added by Shyam on 13/09/2005/////
	/*function searchCode(obj){
		var sm='';
		parent.parent.frames[3].location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+sm;
		parent.parent.frames[1].frames[1].location.href='../../eCommon/html/blank.html';
		parent.parent.frames[1].increasesize.rows='255,*'
		var target= document.forms[0].tabulation_list_desc;
		var retVal	=  new String();
		var dialogTop			= "40";
		var dialogHeight		= "10" ;
		var dialogWidth			= "40" ;
		var features			="dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
		var arguments			= "" ;
		var search_desc="";
		var search_code=""; 
		var title="Tabulation Code";
		var sql = "select tab_list_no,long_desc description from mr_tab_list where  eff_status=`E` ";		
		search_code="tab_list_no";
		search_desc="long_desc";
		retVal=window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+title+"&dispCodeFirst=dispCodeFirst",arguments,features);
	    var arr=new Array();
		if(retVal != null && retVal != "" && obj.name=="search_button_from"){					
		   	var retVal=unescape(retVal);
			arr=retVal.split("::");
			document.forms[0].tabulation_list_desc_from.value=retVal;				
			document.forms[0].tabulation_list_desc_from.focus();
	    }
		else if(retVal != null && retVal != "" && obj.name=="search_button_to"){
			 var retVal=unescape(retVal);
			arr=retVal.split("::");
			document.forms[0].tabulation_list_desc_to.value=retVal;					
			document.forms[0].tabulation_list_desc_to.focus();
						
		}
}*/

function getTablistData(obj){
	if(obj.value!=""&&obj.value!=null){
			searchCode(obj);
	}
}




	async function searchCode(obj){
		var sm='';
		/*parent.parent.frames[3].location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+sm;*/
		parent.parent.frames[1].frames[1].location.href='../../eCommon/html/blank.html';
		/*parent.parent.frames[1].increasesize.rows='255,*'*/
		var target;
//		alert(obj.name)
		if(obj.name=="tabulation_list_desc_from"){
		 target= document.forms[0].tabulation_list_desc_from;
		}else if(obj.name=="tabulation_list_desc_to"){
		 target= document.forms[0].tabulation_list_desc_to;
		}
		var argumentArray  = new Array() ;
		var dataNameArray  = new Array() ;
		var dataValueArray = new Array() ;
		var dataTypeArray  = new Array() ;

		argumentArray[0] = "SELECT TAB_LIST_NO CODE,LONG_DESC DESCRIPTION FROM MR_TAB_LIST WHERE UPPER(TAB_LIST_NO) LIKE UPPER(?) AND UPPER(LONG_DESC) LIKE UPPER(?) AND EFF_STATUS = 'E' ";
		argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4] = "1,2";
		argumentArray[5] = target.value;
		argumentArray[6] = CODE_LINK ;//CODE_LINK
		argumentArray[7] = CODE_DESC ;//CODE_DESC
		retVal = await CommonLookup(getLabel("eMR.TabulationListCode.label","eMR"), argumentArray );
		var ret1=unescape(retVal);
		 var arr=ret1.split(",");
		if(retVal != null && retVal != "" && obj.name=="tabulation_list_desc_from"){
			
				if(arr[1]==undefined) 
				{
					arr[0]="";	
					arr[1]="";	
				}
			
			
			
			
			
			document.forms[0].tabulation_list_desc_from.value=arr[0];			
//			document.forms[0].tabulation_list_desc_from.focus();
	    }else if(retVal != null && retVal != "" && obj.name=="tabulation_list_desc_to"){
//			alert(retVal)
			/*arr=retVal.split("::");*/
			document.forms[0].tabulation_list_desc_to.value=arr[0];				
//			document.forms[0].tabulation_list_desc_to.focus();
						
		}		/*if(retVal != null && retVal != "" ){
			frmObj.proc_code.value = retVal[0];
			target.value = retVal[1];
			}else{
			target.value = "";
			frmObj.proc_code.value = "";
		}*/
}


///Newly added by shyam on 16/09/2005
function callMaster(obj){ 
	var obj_type = document.forms[0].Master;
	var length  = obj_type.length;
	for(i=0;i<length;i++) 
	{
		obj_type.remove(0);
	}
	if(obj.value!="IPBMRMOT" && obj.value!="IPBEXCDT" && obj.value!="OPBMTMOR" && obj.value!="MRIPCSMB" && obj.value!="IPBMIPCS" && obj.value!="MRDCCSMB" && obj.value!="MROPCSMB")
	{  //Modified for this CRF PER-RH-0206 //Modified by Ashwini on 12-Sep-2019 for ML-MMOH-CRF-1349 //MROPCSMS Removed by Ashwini on 19-May-2020 for ML-MMOH-CRF-1532
		var opt=document.createElement("Option");
		opt.text="------- Select --------"
		opt.value="";
		obj_type.add(opt);
	}
if(obj.value=='MROPCSMB' ||obj.value=='MRIPCSMB' || obj.value=='MROPCSMS' ||obj.value=='OPBMTMOR' || obj.value=='IPBMRMOT' || obj.value=='IPBEXCDT' || obj.value=='MRDCCSMB' || obj.value=='MRDCPROD' || obj.value=='MRDCPROS')
	{   //Modified for this CRF PER-RH-0206 
		var opt_type= document.createElement('Option');
		opt_type.text='Tabulation List'; 
		opt_type.value='TL';
		obj_type.add(opt_type)
	}
	if( obj.value=='MRBRADEX' ||obj.value=='MRBLABWL' || obj.value=='MRBLABRG')
	{
		var opt_type= document.createElement('Option');
		opt_type.text='Order Catalog'; 
		opt_type.value='OC';
		obj_type.add(opt_type)
	}
	//Newly added
	if(obj.value=='MRIPCSEG' || obj.value=='MRBRH212' ||obj.value=='MROPANPO' || obj.value=='MROPCSEG')
	{
		var opt_type= document.createElement('Option');
		opt_type.text='Race Group'; 
		opt_type.value='RC';
		obj_type.add(opt_type)
	}
	else if(obj.value=='MRBPD207' )
	{
		var opt_type= document.createElement('Option');
		opt_type.text='Specialty'; 
		opt_type.value='SP';
		obj_type.add(opt_type)
		var opt_type= document.createElement('Option');
		opt_type.text='Bed Service Classification'; 
		opt_type.value='BC';
		obj_type.add(opt_type)
	}
	else if(obj.value=='IPBMCREF')
	{ 
		var opt_type= document.createElement('Option');
		opt_type.text='Nursing Unit'; 
		opt_type.value='NU';
		obj_type.add(opt_type)
		var opt_type= document.createElement('Option');
		opt_type.text='Clinic/Procedure Unit'; 
		opt_type.value='CP';
		obj_type.add(opt_type)
		var opt_type= document.createElement('Option');
		opt_type.text='Healthcare Setting'; 
		opt_type.value='HC';
		obj_type.add(opt_type)
		var opt_type= document.createElement('Option');
		opt_type.text='Specialty'; 
		opt_type.value='SP';
		obj_type.add(opt_type)
		/*Added by Ashwini on 19-Jun-2019 for ML-MMOH-CRF-1340*/
		var opt_type = document.createElement('Option');
		opt_type.text = getLabel("Common.Staff.label","Common")+" "+getLabel("Common.clinic.label","Common"); 
		opt_type.value = 'SC';
		obj_type.add(opt_type)
		/*End ML-MMOH-CRF-1340*/
	}
	else if(obj.value=='MRBSS203')
	{
		var opt_type= document.createElement('Option');
		opt_type.text='Order Catalog'; 
		opt_type.value='OC';
		obj_type.add(opt_type)
		var opt_type= document.createElement('Option');
		opt_type.text='Specialty'; 
		opt_type.value='SP';
		obj_type.add(opt_type);
	}
	else if(obj.value=='MRIPCSMH')
	{
		var opt_type= document.createElement('Option');
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
		/*Added by Ashwini on 28-Jan-2021 for ML-MMOH-CRF-1341*/
		var opt_type= document.createElement('Option');
		opt_type.text='Race Group'; 
		opt_type.value='RC';
		obj_type.add(opt_type)
		var opt_type= document.createElement('Option');
		opt_type.text=getLabel("eMR.DelAttndBy.label","MR"); 
		opt_type.value='DA';
		obj_type.add(opt_type)
		/*End ML-MMOH-CRF-1341*/
	}
	else if(obj.value=='MROPCSAT' || obj.value=='MROPRFLS' || obj.value=='MRBRH203' )
	{//MRBRH203 added by Rameswar on 09/11/2016 for HSA-CRF-0209.1
	/*	if(obj.value=='MRIPCSBD')
		{
			var opt_type= document.createElement('Option');
			opt_type.text='Bed Type'; 
			opt_type.value='BT';
			obj_type.add(opt_type)
		}*/
		var opt_type= document.createElement('Option');
		opt_type.text='Specialty'; 
		opt_type.value='SP';
		obj_type.add(opt_type)
		if((obj.value!='MROPRFLS' && obj.value!='MRIPCSBD') || (obj.value!='MROPRFLS' && obj.value!='MRIPCSOBD'))
			opt_type.selected = true;	//Above line modified for this CRF PER-PD-209A
		if(obj.value=='MROPRFLS')
		{
			var opt_type= document.createElement('Option');
			opt_type.text='HCare Setting Type'; 
			opt_type.value='HC';
			obj_type.add(opt_type)
		}
	}
	else if(obj.value=='MRIPCSBD' || obj.value=='MRIPCSOBD')
	{  //Above line modified for this CRF PER-PD-209A
		var opt_type= document.createElement('Option');
		opt_type.text='Specialty'; 
		opt_type.value='SP';
		obj_type.add(opt_type)		
		var opt_type= document.createElement('Option');
		opt_type.text='Bed Class'; 
		opt_type.value='BD';
		obj_type.add(opt_type)		
	}
	else if(obj.value=='IPBMCSBU' || obj.value=="IPBMIPCS")
	{
		var opt_type= document.createElement('Option');
		opt_type.text='Specialty'; 
		opt_type.value='SP';
		obj_type.add(opt_type);
		obj_type.selected = true;
	}
	else if(obj.value=='MRBBAT3A')
	{
		var opt_type= document.createElement('Option');
		opt_type.text='ICD Code'; 
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
	}
	else if(obj.value=='MRBBAT3B' || obj.value=='MRBBAT3C')
	{
		var opt_type= document.createElement('Option');
		opt_type.text='ICD Code'; 
		opt_type.value='IC';
		obj_type.add(opt_type)				
		var opt_type= document.createElement('Option');
		opt_type.text='Healthcare Setting'; 
		opt_type.value='HC';
		obj_type.add(opt_type)	
	}
}

//Funtion for Checking Duplicate Serail Nos:
function chkSerialno(obj){
	var formObj=parent.parent.f_query_add_mod.f_query_add_mod_search;
    var number=obj.value;
	var original=parent.frames[0].document.forms[0].serialvalue.value;
	var report_id=parent.frames[0].document.forms[0].Report.value;
    if(number!=''){
		   var occ=number.indexOf('.')
		   var number1=number.substring(0,occ);
		   var number2=number.substring((occ+1),(number.length));
		   if(number=='0' || number=='00' || number=='000'){
//			    var msg=geteMRMessage("INVALID_SERIAL_NO");
				var err_msg=formObj.getMessage("INVALID_SRL_NO","MR");
				alert(err_msg);
				obj.focus();
				obj.select();
		   }else{
		   if(report_id=="MRIPCSMB" || report_id=="MRDCCSMB" || report_id=="MROPCSMB"){ //Modified for this CRF PER-RH-0206 //Modified by Ashwini on 12-Sep-2019 for ML-MMOH-CRF-1349 //MROPCSMS Removed by Ashwini on 19-May-2020 for ML-MMOH-CRF-1532
			 if(eval(original)==eval(number1)){
				if(occ==-1){
//					var msg=geteMRMessage("INVALID_SRL_NO");
					var err_msg=formObj.getMessage("INVALID_SRL_NO","MR");
					alert(err_msg);
					obj.focus();
					obj.select();
				}else{
				  if(number2.length <2){
//					var msg=geteMRMessage("INVALID_SRL_NO");
					var err_msg=formObj.getMessage("INVALID_SRL_NO","MR");
					alert(err_msg);
					obj.focus();
					obj.select();
				   }else if(number2.indexOf('.')!=-1){
//					var msg=geteMRMessage("INVALID_SRL_NO");
					var err_msg=formObj.getMessage("INVALID_SRL_NO","MR");
					alert(err_msg);
					obj.focus();
					obj.select();
				  }else if(number2==00 || number2==0){
					//							var msg=geteMRMessage("INVALID_SRL_NO");
					var err_msg=formObj.getMessage("INVALID_SRL_NO","MR");
					alert(err_msg);
					obj.focus();
					obj.select();
				  }else{
                     chkdup(obj,number2);
				  }
			  }
		   }//end of if block
		   else{
//			var msg=geteMRMessage("INVALID_SRL_NO");
			var err_msg=formObj.getMessage("INVALID_SRL_NO","MR");
			alert(err_msg);
			obj.focus();
			obj.select();
		   }

	    }else{
			chkdup(obj,number2);
		 }
	    }
	   }
	}
	function chkdup(obj,number)
	{
	var formObj=parent.parent.f_query_add_mod.f_query_add_mod_search;
	var maxrecord=document.forms[0].maxrecord.value;
	var report_id=parent.frames[0].document.forms[0].Report.value;
	
	var concat= document.forms[0].concat.value;

	var ptr=obj.name;
	var str=eval(ptr.substring(4,ptr.length))
		
	chkdupsplit=concat.split("#");
	var length=chkdupsplit.length;
	var real=obj.name;
	var num=number;
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
		
	if(report_id=="MROPCSMB" || report_id=="MROPCSMS" || report_id=="MRIPCSMB" || report_id=="OPBMTMOR" || obj.value=='IPBMRMOT' || obj.value=='IPBEXCDT' || report_id=="MRDCCSMB"){  //Modified for this CRF PER-RH-0206
		var chkboxval=eval("document.forms[0].inc"+str+".value");
		for(i=0;i<(length-2);i++){
			if(eval(num)==eval(chkdupsplit[i]) && chkboxval=="N")
			status=true;
		}
	}else{
		status=false;
	}
	if(status==true){	
		//		var msg=geteMRMessage("DUPLI_SRL_NO")==V3Code
		var err_msg=formObj.getMessage('DUPLI_SRL_NO','MR');
		alert(err_msg);
		obj.focus();
		obj.value="";
	}else{
		var num=number;
		var maxrecord=document.forms[0].maxrecord.value;
		var real=obj.name;
		for(i=1;i<=maxrecord;i++){
			var valchk=eval("document.forms[0].text"+i+".value");
			var occ=valchk.indexOf('.')
			var number2=valchk.substring((occ+1),(valchk.length));
			var valname=eval("document.forms[0].text"+i+".name");
			var chkboxval=eval("document.forms[0].inc"+i+".value");
			if(num!=""){
				if(number2.length >0){    
					var occ=number2.indexOf('0')
					if(occ==0)
					number2=number2.substring(1,number2.length);
					occ=number2.indexOf('0')
					if(occ==0)
					number2=number2.substring(1,number2.length);
				}
				if(real!=valname){
					if(eval(number2)==num){
					//						    var msg=geteMRMessage("DUPLI_SRL_NO")
					var err_msg=formObj.getMessage('DUPLI_SRL_NO','MR');
					alert(err_msg);
					obj.focus();
					obj.value="";
					break;
					}
				}
			}
		}
	}
}

function level1(obj)
{
	//alert(obj.value);
}
	//Newly added on 27/09/2005 by shyam
function callClear_l1(obj){

         
	var Report=document.forms[0].Report.value;
	var sm='';
	/*parent.parent.frames[3].location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+sm;*/
	parent.parent.frames[1].frames[1].location.href='../../eCommon/html/blank.html';
	/*parent.parent.frames[1].increasesize.rows='255,*'*/
	document.forms[0].Main_group_desc.value='';
	document.forms[0].Main_group.value='';
	document.forms[0].sub_group1.value='';
	document.forms[0].sub_group.value='';
	document.forms[0].level_code3_desc.value='';
	document.forms[0].level_code3.value='';
	document.getElementById("fetchdata").innerText='';
	var report_id=document.forms[0].Report.value
	if(obj.value=='IC'){
		tabdata="<table  cellpadding=0 cellspacing=0 border='0'  width='100%' height='100%' align='center'><tr><td class=label width='13%' align='right'>&nbsp;Search By&nbsp;</td><td class='label' align='left' width='87%'>&nbsp;&nbsp;&nbsp;&nbsp;<select name='searchby' id='searchby' onchange='callhidden();'><option value='C'>Code</option><option value='D'>Description</option></select>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Criteria&nbsp;&nbsp;&nbsp;&nbsp;<select onchange='callhidden();' name='searchcriteria' id='searchcriteria'><option value='S'>Starts With</option><option value='E'>Ends With</option><option value='C'>Contains</option></select></td></tr></table>";
		//tabdata="<table  cellpadding=0 cellspacing=0 border='0'  width='100%' height='100%'   align='center'><tr><td class=label width='20%' align=right>&nbsp;Search By&nbsp;&nbsp;</td><td align='left' width='33%'><select name='searchby' id='searchby' onchange='callhidden();'><option value='C'>Code</option><option value='D'>Description</option></select>&nbsp;Criteria&nbsp;<select onchange='callhidden();' name='searchcriteria' id='searchcriteria'><option value='C'>Contains</option><option value='S'>Starts With</option><option value='E'>Ends With</option></td>	<td class=label align=right width='14%'>&nbsp;&nbsp;List Desc&nbsp;</td><td width='33%' align=left><input type='text'  name='list_desc' id='list_desc'></td></td></table>";
		tabdata2="<table cellpadding=0 cellspacing=0 border='0'  width='100%' height='100%'><tr><td class=label width='14%' align=right>&nbsp;Search Desc&nbsp;&nbsp;<td align='left' width='86%'>&nbsp;&nbsp;<input type='text' size='57' maxlength='70' name='alpha_desc' id='alpha_desc'><img src='../../eMP/images/mandatory.gif'></td><td>&nbsp;</td><td>&nbsp;</td></tr></table>";
		/*parent.parent.frames[1].increasesize.rows='350,*'*/
		document.getElementById("t").innerHTML=tabdata;
		document.getElementById("t").style.visibility='visible' ;
		document.getElementById("t1").innerHTML=tabdata2;
		document.getElementById("t1").style.visibility='visible' ;

		//document.forms[0].tabulation_list_desc_to.disabled=false;
		///document.forms[0].tabulation_list_desc_from.disabled=false;
		//document.forms[0].search_button_from.disabled=false;
		//document.forms[0].search_button_to.disabled=false;
		//document.forms[0].list_desc.disabled=false;
	}else if(obj.value!='TL'){
		//document.forms[0].alpha_desc.value="";
		//document.forms[0].searchby.value="";
		document.getElementById("t").style.visibility='hidden' ;
		document.getElementById("t1").innerHTML='';
		document.getElementById("t").innerHTML='';
		document.getElementById("t1").style.visibility='hidden' ;
	}
	if(obj.value=='SP'){
		document.forms[0].mand_gif1.style.visibility = "visible";
		if (Report=='MRIPCSBD' || Report=='MRIPCSOBD'){ //Modified for this CRF PER-PD-209A
			document.forms[0].mand_gif2.style.visibility = "visible";
		}
	}else if(obj.value=='BC'){
		document.forms[0].mand_gif1.style.visibility = "visible";
		document.forms[0].mand_gif2.style.visibility = "visible";
	}else if(obj.value=='BD'){
		document.forms[0].mand_gif1.style.visibility = "visible";
	}
}

function callhidden(){
	parent.parent.frames[1].frames[1].location.href='../../eCommon/html/blank.html';
	/*parent.parent.frames[1].increasesize.rows='260,*'*/
}
 function checkIsValidForProceed(){
	var url = parent.content.f_query_add_mod.location.href;
//	url = url.toLowerCase();
	if ((url.indexOf("TLLinkQueryFrames.jsp"))!=-1)
		return true;
	else
		return false;
}

