<!DOCTYPE html>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,java.net.URLEncoder,eCommon.XSSRequestWrapper" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%! 
	String encode(String data){	  
			String outDat = "";
			byte byteData[] = data.getBytes();
			for (int i=0; i<byteData.length; i++){
				outDat = outDat +"%"+Integer.toHexString((int)byteData[i]);
			}
			return(outDat);
   }
   
%>
<html>
<head>
<%
	String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String imgUrl="";
	if(sStyle.equals("IeStyle.css"))
	 {
			imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
	 }
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
<script language="javascript" src="../../eOT/js/SurgicalAccessories.js"></script>
<script Language="JavaScript">
function Class_row(){
     this.equipment_code="";
	 this.equipment_desc="";
	 //Mode - L=when retrieving from DB ,I=Insert,U=update,D=delete
     this.no_Of_Units="";
	 this.type="E";
     this.mode="";
	 this.recId ="";
}


// This Function checks for Duplicate Start & End Times
function alreadyExist(){
	var formObj = document.SurgicalAccessoriesEquipmentsRecordForm;
	var equipmentCodeDtl =window.parent.frames[4].equipment_code; //detail frame
	var frmequipment_code=formObj.equipment_code.value;
	var err_txt="";
	var dtl_arr = equipmentCodeDtl.split(",");
	var dtl_arr_length = dtl_arr.length;
	var err_flag = "false";
	var i = 0;
	if(equipmentCodeDtl!=null && equipmentCodeDtl!=""){
		if(dtl_arr_length>0){
			while(i<=dtl_arr_length-2 && err_flag=="false"){
				if(dtl_arr[i] == frmequipment_code){
					err_txt+=getMessage("CODE_ALREADY_EXISTS","common");
					err_flag = "true";
				}
				i++;
			}
		}
	}
       /* if(equipmentCodeDtl.indexOf(frmequipment_code)>=0){
			//err_txt+="APP-OT40 Code Cannot Be Duplicated...";
			err_txt+=getMessage("CODE_ALREADY_EXISTS","common");
		}*/
		 if(err_txt.length>0){
              parent.parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+err_txt;
	     	  return false;
		}else return true;
}

 function chkEmpty(){
	var desc=getLabel("Common.description.label","common");
	var formObj = document.forms[0];
	var fields = new Array(formObj.equipment_desc);
	var names = new Array(desc);
	var messageFrame = parent.parent.messageFrame;
	if(checkFieldsofMst( fields, names, messageFrame))
		return true;
}

function newRow(){
   var objrow = new Class_row(); // 
   return(objrow);
}
function chkForDuplicates()
{
    var DtlformObj=document.forms[0];
	var masterframe = window.parent.frames[0];
	var HdrformObj=masterframe.document.forms[0];
    var appl_desc=HdrformObj.appl_desc.value;
	var speciality_code=HdrformObj.speciality_code.value;
	var category_code=HdrformObj.category_code.value;
    var subCategory_code=HdrformObj.subCategory_code.value;
	var operation_code=HdrformObj.operation_code.value;
	var equipment_code=DtlformObj.equipment_code.value;
	var dtlString=DtlformObj.dtlString.value;
	var function_id=document.forms[0].function_id.value;
	var surgeon_desc="";

	if(function_id=="OT_MST_CODE_SURGPREF")
	{
		surgeon_desc=HdrformObj.surgeon_code.value;
	}	

	var arr=dtlString.split("#");
	var err_txt="";
	for (var i=0;i<arr.length;i++ )
	{
		var chkString=arr[i];
		if(appl_desc=="AOPR"){
		if(function_id=="OT_MST_CODE_SURGPREF")
		{
			if(chkString.indexOf(equipment_code)>=0 && chkString.indexOf(appl_desc)>=0 && chkString.indexOf(surgeon_desc)>=0) {
				err_txt=getMessage("CODE_ALREADY_EXISTS","common");
		}
		}else
			{
				if(chkString.indexOf(equipment_code)>=0 && chkString.indexOf(appl_desc)>=0){
				err_txt=getMessage("CODE_ALREADY_EXISTS","common");
		    }
			}
	   }else if(appl_desc=="SSPL"){
		   if(speciality_code==''){
			   err_txt=getMessage("CANNOT_BE_BLANK","OT");
				var msgArray = err_txt.split("&");
				var speciality=getLabel("Common.speciality.label","common");
				alert(msgArray[0]+speciality+msgArray[1]);
				return;
		   } else{
			   	if(function_id=="OT_MST_CODE_SURGPREF")
		{
			if(chkString.indexOf(equipment_code)>=0 && chkString.indexOf(appl_desc)>=0 && chkString.indexOf(speciality_code)>=0 && chkString.indexOf(surgeon_desc)>=0){
			err_txt=getMessage("CODE_ALREADY_EXISTS","common");
		}
		}else
		  {
	      	if(chkString.indexOf(equipment_code)>=0 && chkString.indexOf(appl_desc)>=0 && chkString.indexOf(speciality_code)>=0){
			err_txt=getMessage("CODE_ALREADY_EXISTS","common");
		    }
		   }
		 }
	   }else if(appl_desc=="SCAT"){
		   if(speciality_code==''){
			   err_txt=getMessage("CANNOT_BE_BLANK","OT");
				var msgArray = err_txt.split("&");
				var speciality=getLabel("Common.speciality.label","common");
				alert(msgArray[0]+speciality+msgArray[1]);
				return;
		   } else if(category_code==''){
    			err_txt=getMessage("CANNOT_BE_BLANK","OT");
				var msgArray = err_txt.split("&");
				var category1=getLabel("Common.category1.label","common");
				alert(msgArray[0]+category1+msgArray[1]);
				return;
		   }else{			
			   if(function_id=="OT_MST_CODE_SURGPREF")
		{
				   if(chkString.indexOf(equipment_code)>=0 && chkString.indexOf(appl_desc)>=0 && chkString.indexOf(speciality_code)>=0 && chkString.indexOf(category_code)>=0 && chkString.indexOf(surgeon_desc)>=0){
					err_txt=getMessage("CODE_ALREADY_EXISTS","common");
				   }
		}else
			   {
			if(chkString.indexOf(equipment_code)>=0 && chkString.indexOf(appl_desc)>=0 && chkString.indexOf(speciality_code)>=0 && chkString.indexOf(category_code)>=0){
			err_txt=getMessage("CODE_ALREADY_EXISTS","common");
		    }
		   }
		   }
	   }else if(appl_desc=="SSUB"){
		     if(speciality_code==''){
			   err_txt=getMessage("CANNOT_BE_BLANK","OT");
				var msgArray = err_txt.split("&");
				var speciality=getLabel("Common.speciality.label","common");
				alert(msgArray[0]+speciality+msgArray[1]);
				return;
		   } else if(category_code==''){
				err_txt=getMessage("CANNOT_BE_BLANK","OT");
				var msgArray = err_txt.split("&");
				var category1=getLabel("Common.category1.label","common");
				alert(msgArray[0]+category1+msgArray[1]);
				return;
		   }else if(subCategory_code==''){
				err_txt=getMessage("CANNOT_BE_BLANK","OT");
				var msgArray = err_txt.split("&");
				var subCategory=getLabel("eOT.SubCategory.Label","OT");
				alert(msgArray[0]+subCategory+msgArray[1]);
				return;
		   }else{
			    if(function_id=="OT_MST_CODE_SURGPREF")
		{
					if(chkString.indexOf(equipment_code)>=0 && chkString.indexOf(appl_desc)>=0 && chkString.indexOf(speciality_code)>=0 && chkString.indexOf(category_code)>=0 && chkString.indexOf(subCategory_code)>=0 && chkString.indexOf(surgeon_desc)>=0){
					err_txt=getMessage("CODE_ALREADY_EXISTS","common");
					}
		}else
			   {
	      	if(chkString.indexOf(equipment_code)>=0 && chkString.indexOf(appl_desc)>=0 && chkString.indexOf(speciality_code)>=0 && chkString.indexOf(category_code)>=0 && chkString.indexOf(subCategory_code)>=0){
			err_txt=getMessage("CODE_ALREADY_EXISTS","common");
		    }
		   }
		   }
	   }else if(appl_desc=="SOPR"){
		   if(operation_code==''){
				err_txt=getMessage("CANNOT_BE_BLANK","OT");
				var msgArray = err_txt.split("&");
				var operation=getLabel("Common.operation.label","common");
				alert(msgArray[0]+operation+msgArray[1]);
				return;
		   }else{
			     if(function_id=="OT_MST_CODE_SURGPREF")
			{
				 	if(chkString.indexOf(equipment_code)>=0 && chkString.indexOf(appl_desc)>=0 && chkString.indexOf(operation_code)>=0 && chkString.indexOf(surgeon_desc)>=0){
						err_txt=getMessage("CODE_ALREADY_EXISTS","common");
			}
		}else
			   {
						if(chkString.indexOf(equipment_code)>=0 && chkString.indexOf(appl_desc)>=0 && chkString.indexOf(operation_code)>=0){
						err_txt=getMessage("CODE_ALREADY_EXISTS","common");
		    }
		   }
		   }
	   }

	}//for loop end
		if(err_txt.length>0){
			parent.parent.frames[2].location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+err_txt;
		 return false;
	 }
	else       
	  return true;
}
function ChkNumber(obj){
	var quantity=obj.value;
	if(isNaN(quantity)==true)
	{
		alert(getMessage("INVALID_NEXT_NUMBER","common"));
	    obj.select();
	    obj.focus();
	   
	}
	if(obj.value!="" && quantity<=0){
		var msg=getMessage("APP-OT0068","OT");
		var msgarry=msg.split("#");
		var noofUnits=getLabel("eOT.NoofUnits.Label","OT");
		alert(msgarry[0]+noofUnits+msgarry[1]);
		obj.select();
		obj.focus();
	}
}


function addRow(){	
  var rows=window.parent.frames[1].rows_for_equipments;
  var formObj = document.SurgicalAccessoriesEquipmentsRecordForm;
  formObj.generic_search_for_equipment.disabled=false;
  formObj.equipment_desc.disabled=false;
   var mode =formObj.mode.value;
      if(chkEmpty()){
    	if(mode=='I'){
	 	  if(alreadyExist()){ //if the row which is bieng inserted already does not exist
	   	   if(chkForDuplicates()){
		   var objrow = newRow();
		   objrow.equipment_code=formObj.equipment_code.value;
		   objrow.equipment_desc=formObj.equipment_desc.value;
		   objrow.no_Of_Units=formObj.no_Of_Units.value;
		   objrow.mode="I";
		   objrow.recId = rows.length+1;
		   rows.push(objrow);
		   resetFields();
		   refresh();
		   }
	   } //alreadyExist()	 
}else
	  updateRow();
  }//chkEmpty()
}

function modeCheck(){
	var formObj = document.SurgicalAccessoriesEquipmentsRecordForm;
	var master_frame = window.parent.frames[0];
	var hdr_frm = master_frame.document.forms[0];
	var equipmentCodeDtl =window.parent.frames[4].equipment_code; //detail frame
	var frmequipment_code=formObj.equipment_code.value;
	var appl_desc=hdr_frm.appl_desc.value;
	var splty_code=hdr_frm.speciality_code.value;
	var cat_code=hdr_frm.category_code.value;
	var sub_cat_code=hdr_frm.subCategory_code.value;
	var tab="equipment"
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var params = "appl_desc="+appl_desc+"&splty_code="+splty_code+"&cat_code="+cat_code+"&sub_cat_code="+sub_cat_code+"&tab="+tab;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","ValidationOT.jsp?func_mode=fromSurgicalAcmaster&"+params,false);
	xmlHttp.send(xmlDoc);
	var retVal1 = trimString(xmlHttp.responseText);
	var err_txt="";
	var dtl_arr = retVal1.split(",");
	var dtl_arr_length = dtl_arr.length;
	var i = 0;
		if(dtl_arr_length>0){
			while(i<=dtl_arr_length-2 ){
				if(dtl_arr[i] == frmequipment_code){
					err_txt="Update";
				}
				i++;
			}
		}
	 if(err_txt.length>0){
	     	  return false;
		}else return true;
}


function updateRow(){
	var formObj = document.SurgicalAccessoriesEquipmentsRecordForm;
	var rows=window.parent.parent.frames[1].frames[1].rows_for_equipments;
	var mode =formObj.mode.value
	var recId = formObj.recId.value;
		if(rows.length>0 && mode=='U'){
			   for(var jj=0;jj<rows.length;jj++){
				 if(rows[jj]!=null) {
					if(rows[jj].recId==recId){
						rows[jj].equipment_code=formObj.equipment_code.value;
						rows[jj].equipment_desc=formObj.equipment_desc.value;
						rows[jj].no_Of_Units=formObj.no_Of_Units.value;
						if(rows[jj].mode=='I')
							if(modeCheck()){
								mode="I";
							}else{
								mode="U"
							}
							rows[jj].mode=mode;
					}
		         }else  
			continue;
		 }
      resetFields();
	  refresh();
 }
}

function removeRow(){
var formObj = document.SurgicalAccessoriesEquipmentsRecordForm;
formObj.generic_search_for_equipment.disabled=false;
formObj.equipment_desc.disabled=false;
var rows=window.parent.parent.frames[1].frames[1].rows_for_equipments;
var recId = document.forms[0].recId.value;
var mode = document.forms[0].mode.value;
if(rows.length>0 && mode=='U'){        
  for(var jj=0;jj<rows.length;jj++){
	 if(rows[jj]!=null){
		if(rows[jj].recId==recId){
			 if(rows[jj].mode=='L')
				rows[jj].mode='D';
			 else
			  delete rows[jj];
			   break;
		}
	 }else
	continue;
 }//end for-Loop
 resetFields();
 refresh();
}else
   resetFields();
}

function splitString(strVal){
    var arr = strVal.split('::');
	var frmObj = document.SurgicalAccessoriesEquipmentsRecordForm;	
	frmObj.equipment_code.value=arr[0];
	frmObj.equipment_desc.value=arr[1];
	frmObj.no_Of_Units.value=arr[2];
	frmObj.recId.value=arr[3];
	frmObj.mode.value=arr[4];
	frmObj.generic_search_for_equipment.disabled=true;
	frmObj.equipment_desc.disabled=true;	
}

function resetFields(){
	var frmObj = document.SurgicalAccessoriesEquipmentsRecordForm;
	frmObj.equipment_desc.value='';
	frmObj.equipment_code.value='';
	frmObj.no_Of_Units.value='';
	frmObj.mode.value='I';	
}

function refresh()
{
	window.parent.frames[4].location.href='../../eOT/jsp/SurgicalAccessoriesEquipmentsDetailForm.jsp?';              //+params;
}

function loadDBRows(equipment_code,equipment_desc,no_Of_Units,recId,mode){ 
  var objrow = newRow();
  var rows=window.parent.parent.frames[1].frames[1].rows_for_equipments;
  var i=0;
   if(mode=='L' && rows.length<recId)
	{	  
	  objrow.equipment_code = equipment_code;
	  objrow.equipment_desc = unescape(equipment_desc);
	  objrow.no_Of_Units =no_Of_Units;
	  objrow.mode=mode;
	  objrow.recId=recId;
	  rows.push(objrow);	    
	}
}

</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<%
	Connection con=null;
	PreparedStatement stmt=null;
	ResultSet rs=null;
	String source=request.getParameter("source");
	String mode=request.getParameter("update_mode_yn");
	if (mode.equals("modify")){
		mode="U";
	}else{
		mode="I";
	}
	String applicability=request.getParameter("applicability")==null?"":request.getParameter("applicability");
	String speciality_code=request.getParameter("speciality_code")==null?"":request.getParameter("speciality_code");
	String surgeon_code=request.getParameter("surgeon_code")==null?"":request.getParameter("surgeon_code");
	String speciality_desc="";
	String oper_cat_code=request.getParameter("oper_cat_code")==null?"":request.getParameter("oper_cat_code");
	String oper_cat_desc="";
	String oper_sub_cat_code=request.getParameter("oper_sub_cat_code")==null?"":request.getParameter("oper_sub_cat_code");
	String oper_sub_cat_desc="";
	String oper_code=request.getParameter("oper_code")==null?"":request.getParameter("oper_code");
	String oper_desc="";
	String strsql="";
	String sql="";
	String sql1="";
	String function_id=request.getParameter("function_id").equals(null)?"":request.getParameter("function_id");
	//if(function_id.equals("SurgeonPreferences")){
	if(function_id.equals("OT_MST_CODE_SURGPREF")){
		sql1="SELECT PREF_ID,APPLICABILITY,SPECIALITY_CODE,OPER_CAT_CODE,OPER_SUB_CAT_CODE,OPER_CODE,TEAM_DOCTOR_CODE  from OT_OPER_DR_PREFERENCE";
	} else {
		sql1="SELECT EQUIPMENT_CODE,APPLICABILITY,SPECIALITY_CODE,OPER_CAT_CODE,OPER_SUB_CAT_CODE,OPER_CODE from OT_OPER_EQUIPMENT";
	}
	StringBuffer dtlString=new StringBuffer();
	String no_of_units="";


     if(applicability.equals("SSPL"))
     sql=" AND A.SPECIALITY_CODE='"+speciality_code+"'";
     else if(applicability.equals("SCAT"))
     sql=" AND A.SPECIALITY_CODE='"+speciality_code+"' AND A.OPER_CAT_CODE='"+oper_cat_code+"'";
     else if(applicability.equals("SSUB"))
     sql=" AND A.SPECIALITY_CODE='"+speciality_code+"' AND A.OPER_CAT_CODE='"+oper_cat_code+"' AND A.OPER_SUB_CAT_CODE='"+oper_sub_cat_code+"'";
     else if(applicability.equals("SOPR"))
     sql=" AND A.OPER_CODE='"+oper_code+"'";
	
    //if(function_id.equals("SurgeonPreferences")){
    if(function_id.equals("OT_MST_CODE_SURGPREF")){
		strsql="SELECT A.PREF_ID, B.LONG_DESC, A.NO_OF_UNITS FROM OT_OPER_DR_PREFERENCE A, OT_EQUIPMENT_LANG_VW B WHERE B.LANGUAGE_ID ='"+locale+"' AND NVL(A.TEAM_DOCTOR_CODE,'!')=NVL('"+surgeon_code+"',NVL(A.TEAM_DOCTOR_CODE,'!')) AND A.PREF_ID= B.EQUIPMENT_CODE  AND a.PREF_TYPE='E' AND A.APPLICABILITY='"+applicability+"'"+sql;//IN:048356
	} else {
		strsql="SELECT A.EQUIPMENT_CODE, B.LONG_DESC, A.NO_OF_UNITS FROM OT_OPER_EQUIPMENT A, OT_EQUIPMENT_LANG_VW B WHERE B.LANGUAGE_ID ='"+locale+"'  AND A.EQUIPMENT_CODE= B.EQUIPMENT_CODE AND A.APPLICABILITY='"+applicability+"'"+sql; //049252
	}
if(mode.equals("U")){
    try
     {
		con=ConnectionManager.getConnection(request);
		stmt=con.prepareStatement(strsql);
		//stmt.setString(1,template_id);
		rs=stmt.executeQuery();
    
		int index=0;
		while(rs.next())
		{
			index++;
			no_of_units=rs.getString(3);
			if(no_of_units==null || no_of_units.equals("") || no_of_units.equals("null"))
			   no_of_units="";	
			out.println("<script>loadDBRows('"+rs.getString(1)+"','"+rs.getString(2)+"','"+no_of_units+"','"+index+"','L');</script>");
		}
	
	out.println("<script>refresh()</script>");
	//out.println("<script>assignRecID()</script>");
}catch(Exception e)
	{
		e.printStackTrace();
		//System.err.println("Error in SurgicalAccessoriesEquipmentsRecordForm records.jsp"+e.getMessage());
	}finally{
		try{
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
			if(con!=null) 
			ConnectionManager.returnConnection(con,request);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	}else if(mode.equals("I")){
	try{
		con=ConnectionManager.getConnection(request);
		stmt=con.prepareStatement(sql1);
		rs=stmt.executeQuery();
		while(rs.next())
			{
			if(function_id.equals("OT_MST_CODE_SURGPREF")){
				dtlString=dtlString.append(",").append(rs.getString(1)).append(",").append(rs.getString(2)).append(",").append(rs.getString(3)).append(",").append(rs.getString(4)).append(",").append(rs.getString(5)).append(",").append(rs.getString(6)).append(",").append(rs.getString(7)).append("#");
			}else
			{
				dtlString=dtlString.append(",").append(rs.getString(1)).append(",").append(rs.getString(2)).append(",").append(rs.getString(3)).append(",").append(rs.getString(4)).append(",").append(rs.getString(5)).append(",").append(rs.getString(6)).append("#");
			}
				
			}
			out.println("<script>refresh()</script>");
	}catch(Exception e1)
	{
		e1.printStackTrace();
		//System.err.println("Error in SurgicalAccessoriesEquipmentsRecordForm records.jsp"+e1.getMessage());
	}finally{
		try{
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
			if(con!=null) 
			ConnectionManager.returnConnection(con,request);
		}catch(Exception e){e.printStackTrace();}
	}
	}
%>
<form name="SurgicalAccessoriesEquipmentsRecordForm" id="SurgicalAccessoriesEquipmentsRecordForm"  onload='FocusFirstElement()'  action="" method="" target=""> 
<table border=0 cellspacing=0 cellpadding=3 width='100%'  >
<tr>
	<td class=label width='25%'>
		<fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
	<td width='25%' class="fields">
		<input type="text" name="equipment_desc" id="equipment_desc" value="" size=15 maxlength=15
		onBlur="if(this.value!='')callSearchcode('E',equipment_code,equipment_desc);else equipment_code.value='';">
		<input type="hidden" name="equipment_code" id="equipment_code" value="">
		<input type="button" class="button" name="generic_search_for_equipment" id="generic_search_for_equipment" value="?"  onclick="callSearchcode('E',equipment_code,equipment_desc);" >
		<img src='../../eCommon/images/mandatory.gif'>
	</td>
	
   <td class=label width='25%'>
		<fmt:message key="eOT.NoofUnits.Label" bundle="${ot_labels}"/></td>
	<td width='25%' class="fields">
		<input type="text" name="no_Of_Units" id="no_Of_Units" value="" size=3 maxlength=3 onblur='ChkNumber(this);'>
	</td>
</tr>
<tr>
	<td></td>
    <td></td>
    <td></td>
    <td></td>
</tr>
<tr>
<td></td>
    <td></td>
    <td></td>
    <td class='fields' width='25%'>
		
		<input type='button' class='button' value='<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>' onClick='addRow();'  >
		<input type='button' class='button' value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' onClick='removeRow();'  >
	</td>		
</tr>
<input type="hidden" name='mode' id='mode' value='I'>
<input type="hidden" name='recId' id='recId' value=''>
<input type="hidden" name='dtlString' id='dtlString' value='<%=dtlString%>'>

</table>
<!-- added by Yadav for Amazon Changes-->
				<%if(!imgUrl.equals("")){ %>
					 <img src='<%=imgUrl%>' width='100%' height='15'/> 
				<%}%>
<!-- end -->
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
<input type='hidden' name='function_id' id='function_id' value="<%=function_id%>">
</form>
</body>
</html>

