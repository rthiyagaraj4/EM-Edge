<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper,eCommon.Common.CommonBean"%>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eOT/jsp/StringUtil.jsp"%>
<%
//Added Against MMS Vulnerability Issue - Starts
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
//Added Against MMS Vulnerability Issue - Ends

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
request.setCharacterEncoding("UTF-8");
String locale = (String)session.getAttribute("LOCALE");
%>

<html>
<head>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script Language="JavaScript" src="../../eCommon/js/common.js"></Script>
	<script language="JavaScript" src="../../eOT/js/RecordSurgeon.js"></script>
<script type='text/javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script language="JavaScript">
 function assignSpeciality(){
	
	var formObjHdr = parent.parent.parent.common_patient_hdr_frame.CommonOperDtlsHdrForm;
	var doc_level = formObjHdr.doc_level.value;
	if(document.forms[0].tab.value !="record_surgeon")
	{
		
	callPopulateList(doc_level);
	}else
	{
			if(doc_level=="IS")
		{
				var facility_id=document.forms[0].facility_id.value;
				var db_mode=parent.parent.parent.frames[4].RecordSurgeonTabForm.db_mode.value;
				var status_value=parent.parent.parent.frames[4].RecordSurgeonTabForm.status_value.value;
				var oper_code_all=parent.parent.parent.frames[4].RecordSurgeonTabForm.oper_code_all.value;
				var oper_code_new=parent.parent.parent.frames[4].RecordSurgeonTabForm.oper_code_new.value;
				var spec_code_final=parent.parent.parent.frames[4].RecordSurgeonTabForm.spec_code_final.value;
				var oper_num=document.forms[0].oper_num.value;
				var arr2=oper_code_all.split("*");
				var arr3=status_value.split("*");
				var arr1=db_mode.split("*");
				var oper_code="";
				var chk_status="";
				var db_mode_val="";
				
				var xmlDoc = "" ;
				var xmlHttp = new XMLHttpRequest();
				var xmlStr ="<root><SEARCH ";
				xmlStr +=" /></root>";
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
			    xmlHttp.open("POST","OTCommonValidation.jsp?func_mode=exist_operation_speciality&spec_code_final="+spec_code_final,false);
				xmlHttp.send(xmlDoc);
				var retVal = trimString(xmlHttp.responseText);
				var arr_spec=retVal.split("*");
				var spec_code_new="";
				var spec_code_old="";
				var arr2_spec="";
				var opt ="";
				var ret="";	
				for (var m=0;m<arr_spec.length-1;m++ )
				{
					spec_code_new=arr_spec[m];
					 arr2_spec=spec_code_new.split(",");
					 opt = document.forms[0].document.createElement('OPTION');
					opt.text =arr2_spec[1];
					opt.value=arr2_spec[0];
					document.forms[0].speciality.add(opt);
				}			
	//PMG20089-CRF-0858 - Added Start
	 /* if(arr2.length > 2 )
	 {
		ret=confirm(getMessage("APP-OT0132","OT")); 
	 }*/
	 
	if(arr_spec.length == 2)
		{
			document.forms[0].speciality.options[1].selected = true;
			loadNotetype(document.forms[0].speciality);
		}
			//PMG20089-CRF-0858 - End 
	}
		else
		{
	//	assignListItems(' ,*ALL',"----"+getLabel("Common.defaultSelect.label","Common")+"----,All Specialities");
	assignListItems('*ALL',"All Specialities");
	//		assignListItems('*ALL',);
			var spec=document.forms[0].speciality;
			document.forms[0].speciality.selectedIndex=1;
			loadNotetype(spec);
			
		}
	}
}

function refresh1(){
	var params = document.forms[0].params.value;
	parent.parent.parent.common_patient_hdr_frame.location.href='../../eOT/jsp/CommonOperDtlsHdr.jsp?'+params;
}


function loadNotetype(obj)
{
	var formObj = parent.parent.parent.common_patient_hdr_frame.CommonOperDtlsHdrForm;
	var formObjDtl = document.forms[0];
	var title=getLabel("eOT.SurgeonNotes.Label","ot");
	var facility_id = formObj.facility_id.value;//1
	var patient_id = formObj.patient_id.value;//2
	var episode_id = formObj.episode_id.value;//3
	var patient_class = formObj.patient_class.value;//4
	var encounter_id = formObj.encounter_id.value;//5
	var called_from = "SURGEON_NOTES";//6
	var accession_num=formObj.oper_num.value;//7	
	//speciality_code=formObj.oper_speciality_code.value;
	var speciality_code=obj.value;//8
	var doc_level = formObj.doc_level.value;//FRONT END VALUE	
	var document_level = formObj.document_level.value;//BACK END VALUE	
//Added on 2/3/2011 by Anitha
	var modified_date = formObjDtl.modified_date.value;
	var ret="";	
	var locn_type = "30";
	if(document_level=='' && formObj.doc_level.disabled == false) 
	{
    if(doc_level=='IS')
	{		
	 ret=confirm(getMessage("APP-OT0132","OT"));
	}
	else if(doc_level=='AS')
	{		
     ret=confirm(getMessage("APP-OT0131","OT"));
	}
	}
	else
	{
		ret=true;
	}
	  if(ret==true)
   {
	formObj.doc_level.disabled=true;
	
	if(document_level=='')
	{
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var xmlStr ="<root></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","CommonValidation.jsp?func_mode=updatedoclevel&facility_id="+facility_id+"&oper_num="+accession_num+"&doc_level="+doc_level+"&document_level="+document_level+"&modified_date="+modified_date,false);

	xmlHttp.send(xmlDoc);
	var retVal = trimString(xmlHttp.responseText); 

	//refresh1();
	}

	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");

xmlHttp.open("POST","OTCommonValidation.jsp?func_mode=Surgeon_notes_dispaly&accession_num="+accession_num+"&facility_id="+facility_id+"&patient_id="+patient_id+"&episode_id="+episode_id+"&patient_class="+patient_class+"&encounter_id="+encounter_id+"&called_from="+called_from+"&speciality_code="+speciality_code+"&locn_type="+locn_type+"&slate_user_id="+formObjDtl.slate_user_id.value+"&doc_level="+doc_level+"&document_level="+doc_level,false);
	xmlHttp.send(xmlDoc);
	var retVal = trimString(xmlHttp.responseText);
	var arr_spec=retVal.split("~");
	var arr2_spec="";
	var note_type_value="";

	if(retVal !="")
	   {
			var obj1=document.forms[0].note_type;
	  var len =obj1.options.length;
	  while (len-- >= 0) obj1.remove(obj1.options[0]);
	  opt=document.createElement('OPTION');
	  opt.value='';
	  opt.text="----"+getLabel("Common.defaultSelect.label","Common")+"----";
	  obj1.add(opt);

	for (var m=0;m<arr_spec.length-1;m++ )
	{
		note_type_value=arr_spec[m];
		arr2_spec=note_type_value.split(",");
		opt = parent.frames[0].document.createElement('OPTION');
		opt.text =arr2_spec[1];
		opt.value=arr2_spec[0];
		document.forms[0].contr_mod_accession_num.value=arr2_spec[2];
		parent.parent.parent.common_patient_hdr_frame.CommonOperDtlsHdrForm.contr_mod_accession_num.value=arr2_spec[2];
		document.forms[0].update_mode.value=arr2_spec[3];
		document.forms[0].accession_num.value=arr2_spec[4];
		document.forms[0].note_type.add(opt);		
	}
	}else
	   {
		var obj1=document.forms[0].note_type;
	  var len =obj1.options.length;
	  while (len-- >= 0) obj1.remove(obj1.options[0]);
	  opt=document.createElement('OPTION');
	  opt.value='';
	  opt.text="----"+getLabel("Common.defaultSelect.label","Common")+"----";
	  obj1.add(opt);
	 // obj1.selectedIndex = 1; 
	   }
	  //PMG20089-CRF-0858 - Added by SelvinM
	   if(document.forms[0].note_type.options.length == 2)
		{
			document.forms[0].note_type.options[1].selected = true;
			Callnoteswin();
		}
		//PMG20089-CRF-0858 - Added by SelvinM
   }
    else		
	{
	//Modified By Muthukumar against Cancel - Undefined on 24/10/11
	var obj1=document.forms[0].speciality;
	//Modified By Muthukumar against Cancel - Undefined on 24/10/11
	obj1.selectedIndex = 0;
	}
/*   else
	{
	   alert('before');
	   var obj1=document.forms[0].speciality;
	    var len =obj1.options.length;
		if (len == 1) 
		{
	  opt=document.createElement('OPTION');
	  opt.value='';
	  opt.text="----"+getLabel("Common.defaultSelect.label","Common")+"----";
	  obj1.add(opt);
	     obj1.selectedIndex = 1;
	  }
		else
			obj1.selectedIndex = 0;
	}*/
}

async function Callnoteswin()
{
	var url="";
	var surgeonNotes    = getLabel("eOT.SurgeonNotes.Label","OT");
	title = surgeonNotes  ;
	var formObj1=document.forms[0];
	var formObj = parent.parent.parent.common_patient_hdr_frame.CommonOperDtlsHdrForm;
	var facility_id = formObj.facility_id.value;
		var note_type= formObj1.note_type.value;
		var patient_id = formObj.patient_id.value;
		var episode_id = formObj.episode_id.value;
		var patient_class = formObj.patient_class.value;
		var encounter_id = formObj.encounter_id.value;
		var function_id="SPCL_NOTE";
		var event_class="$PHY$";
		var accession_num=formObj1.accession_num.value;
		var window_close="Y";
		var ot_speciality_code=formObj.speciality_code.value;
		var hide_header="N";
		var contr_mod_accession_num = formObj1.contr_mod_accession_num.value;
		var tab_yn="N";
		var secondwindow;
		var locn_type = "30";
		var episode_type="";
		var performed_by_ql=formObj.strUser.value;

	if(patient_class == "IP" || patient_class=="DC")
			episode_type ="I";
		if(patient_class=="OP" ||patient_class=="EM")
			episode_type ="O";

if(note_type !="")
	{
	//Added performed_by_ql on 1/19/2011 by Anitha for 25928
	
	 var action_url	=	"../../eCA/jsp/RecClinicalNotesModal.jsp?appl_task_id=OT_NOTES&title="+encodeURIComponent(title)+"&note_type="+note_type+"&patient_id="+patient_id+"&episode_id="+episode_id+"&patient_class="+patient_class+"&function_id="+function_id+"&event_class="+event_class+"&accession_num="+accession_num+"&window_close="+window_close+"&ot_speciality_code="+ot_speciality_code+"&hide_header="+hide_header+"&tab_yn="+tab_yn+"&encounter_id="+encounter_id+"&facility_id="+facility_id+"&contr_mod_accession_num="+contr_mod_accession_num+"&performed_by_ql="+performed_by_ql;
	 
	 //Sanjay	 
	//alert("action_url-> "+ action_url);
	var title1="";

	var dialogHeight= "100";
	var dialogWidth	= "100";
	var status = "no";
	var arguments	= "";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
	//Sanjay
//	alert("action_url before Modal-> "+ action_url);
	secondwindow  = await window.showModalDialog(action_url, title1, features);
	}

//	Commented by DhanasekarV against incident - IN026701
	var obj1=document.forms[0].note_type;
	  var len =obj1.options.length;
	  while (len-- >= 0) obj1.remove(obj1.options[0]);
	  opt=document.createElement('OPTION');
	  opt.value='';
	  opt.text="----"+getLabel("Common.defaultSelect.label","Common")+"----";
	  obj1.add(opt);
	document.forms[0].speciality.selectedIndex=0;
	
}
/*
//Function added by Sanjay
function deleteDuplicate()
{
	var formObj = parent.parent.parent.common_patient_hdr_frame.CommonOperDtlsHdrForm;
	var facility_id = formObj.facility_id.value;
	var oper_num = formObj.oper_num.value;
	var spec_code = formObj.oper_speciality_code.value;
	var contr_mod_accession_num= facility_id+oper_num+spec_code+"30";
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","CommonValidation.jsp?func_mode=delete_duplicate&facility_id="+facility_id+"&accession_num="+contr_mod_accession_num,false);
	xmlHttp.send(xmlDoc);
	var retVal = trimString(xmlHttp.responseText);
}
//Changes done by Sanjay Ends here
*/
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>
<body onLoad="assignSpeciality();" OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form name = "SurgeonNotesChildForm">
<input type='hidden' name=params value="<%=request.getQueryString()%>" >
<input type='hidden' name='slate_user_id' id='slate_user_id' value='<%=request.getParameter("slate_user_id")%>'>
<input type='hidden' name='tab_id' id='tab_id' value='<%=request.getParameter("tab_id")%>'>
<% 
 	Connection con=null;
	PreparedStatement stmt=null;
	ResultSet rs=null;
	String strUser="";
	String disable_flag="";
	String oper_num = checkForNull(request.getParameter("oper_num"));
	String facility_id = checkForNull(request.getParameter("facility_id"));
	String tab = checkForNull(request.getParameter("tab")); 
	String surgeon_doc_comp_yn = checkForNull(request.getParameter("surgeon_doc_comp_yn")); 
	if(surgeon_doc_comp_yn.equals("Y"))
		disable_flag="disabled";
	else 
		disable_flag="";

//Added below slate_user_id_disp on 1/18/2011 by Anitha
 String slate_user_id_disp = checkForNull(request.getParameter("slate_user_id")).toUpperCase();
 if(slate_user_id_disp.equals("")){
	slate_user_id_disp=	(String)session.getValue("login_user");
 }
String modified_date = checkForNull(request.getParameter("modified_date"));
//System.out.println("modified_date   -----------------"+modified_date);
try
	{
		con=ConnectionManager.getConnection(request);

//Added below qry to fetch func_role_id associated to slate user id on 1/18/2011 by Anitha
		stmt=con.prepareStatement("select func_role_id from sm_appl_user_lang_vw where appl_user_id = ? and language_id = ? ");		
		stmt.setString(1,slate_user_id_disp);
		stmt.setString(2,locale);
		rs=stmt.executeQuery();
		if(rs.next()){
			strUser=checkForNull(rs.getString("func_role_id"));
		}
		if(rs!=null) rs.close();
		if(stmt!=null) stmt.close();
				
	}catch(Exception e){
		System.err.println("Error In SurgeonNotesRecord.jsp   "+e);
		e.printStackTrace();
	}finally{
		try{
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
			if(con!=null)
			ConnectionManager.returnConnection(con,request);
			
		}catch(Exception e){}
	}
%>
<table border='0' cellpadding='3' cellspacing='0' width='100%'>
 <tr> 
	  <td class='label' align='right' nowrap><fmt:message key="Common.speciality.label" bundle="${common_labels}"/> </td>
	  <td align='left'>
		 <select name="speciality" id="speciality" onchange='loadNotetype(this)'>
		   <option value='' selected> ------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----- </option>
		 </select>
	</td>
	<td class='label'  nowrap><fmt:message key="Common.NoteType.label" bundle="${common_labels}"/> </td>
		<td class="fields">			
			
			<select name="note_type" id="note_type" onchange="Callnoteswin()" > 
			<!-- Changes made by Sanjay -->
			<!--
			<select name="note_type" id="note_type" onchange="Callnoteswin()" onblur="deleteDuplicate()">
			-->
			<option value="" selected><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></option>
			</select>

		</td>

  </tr>
</table>
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
<input type='hidden' name='facility_id' id='facility_id' value="<%=facility_id%>">
<input type='hidden' name='oper_num' id='oper_num' value="<%=oper_num%>">
<input type='hidden' name='tab' id='tab' value="<%=tab%>">
<input type='hidden' name='contr_mod_accession_num' id='contr_mod_accession_num' value="">
<input type='hidden' name='update_mode' id='update_mode' value="">
<input type='hidden' name='accession_num' id='accession_num' value="">
<input type='hidden' name='strUser' id='strUser' value='<%=strUser%>'>
<!-- Added modified_date by Anitha as a hidden field on 2/3/2011 -->
<input type='hidden' name='modified_date' id='modified_date' value='<%=modified_date%>'>
</form>
</body>
</html>

