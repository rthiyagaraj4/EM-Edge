<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"%> 
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eCommon.Common.*,eOT.*,eOT.Common.*,eCommon.XSSRequestWrapper" %>                    
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
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
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
     this.packs_code="";
	 this.packs_desc="";
	 //Mode - L=when retrieving from DB ,I=Insert,U=update,D=delete
     this.no_Of_Units="";
	 this.type="P";
     this.mode="";
	 this.recId ="";
}


// This Function checks for Duplicate Start & End Times
function alreadyExist(){
	var formObj = document.SurgicalAccessoriesConsumablePacksRecordForm;
	var packsCodeDtl =window.parent.frames[4].packs_code;
	var frmPacks_code=formObj.packs_code.value;
	var err_txt="";
	var dtl_arr = packsCodeDtl .split(",");
	
	var dtl_arr_length = dtl_arr.length;
	var err_flag = "false";
	var i = 0;
	if(packsCodeDtl!=null && packsCodeDtl!=""){

		if(dtl_arr_length>0){

			while(i<=dtl_arr_length-2 && err_flag=="false"){
				if(dtl_arr[i] == frmPacks_code){
					err_txt+=getMessage("CODE_ALREADY_EXISTS","common");
					err_flag = "true";
				}
				i++;
			}
		}
	}

	 if(err_txt.length>0){
          parent.parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+err_txt;
	     	  return false;
		}else return true;
}

//Function created for changing the mode whn the units are modified before recrod inserts.
/*function modeCheck(){
	var formObj = document.SurgicalAccessoriesConsumablePacksRecordForm;
	var packsCodeDtl =window.parent.frames[4].packs_code;
	var frmPacks_code=formObj.packs_code.value;
	var err_txt="";
	var dtl_arr = packsCodeDtl .split(",");
	var dtl_arr_length = dtl_arr.length;
	var err_flag = "false";
	var i = 0;
	if(packsCodeDtl!=null && packsCodeDtl!=""){
		if(dtl_arr_length>0){
			while(i<=dtl_arr_length-2 && err_flag=="false"){
				if(dtl_arr[i] == frmPacks_code){
					err_txt+=getMessage("CODE_ALREADY_EXISTS","common");
					err_flag = "true";
				}
				i++;
			}
		}
	}
	alert(err_txt)
	 if(err_txt.length>0){
          //parent.parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+err_txt;
	     	  return false;
		}else return true;
}*/

 function chkEmpty(){
	var desc=getLabel("Common.description.label","common");
	var formObj = document.forms[0];
	var fields = new Array(formObj.packs_desc);
	var names = new Array(desc);
	//alert(parent.parent.messageFrame.name);
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
	var packs_code=DtlformObj.packs_code.value;
	var function_id=document.forms[0].function_id.value;
	var surgeon_desc="";
if(function_id == "OT_MST_CODE_SURGPREF")
{
	surgeon_desc=HdrformObj.surgeon_code.value;
}

	var dtlString=DtlformObj.dtlString.value;
	var arr=dtlString.split("#");
	var err_txt="";
	//alert(arr[0]);
	for (var i=0;i<arr.length;i++ )
	{
		var chkString=arr[i];
		if(appl_desc=="AOPR"){
			/*Added by Suma for 18874 on feb 04 2010 (if(function_id == "OT_MST_CODE_SURGPREF"))*/
			if(function_id == "OT_MST_CODE_SURGPREF")
{
	      	if(chkString.indexOf(packs_code)>=0 && chkString.indexOf(appl_desc)>=0 && chkString.indexOf(surgeon_desc)>=0){
					err_txt=getMessage("CODE_ALREADY_EXISTS","common");
		    }
}else
{
			if(chkString.indexOf(packs_code)>=0 && chkString.indexOf(appl_desc)>=0){
					err_txt=getMessage("CODE_ALREADY_EXISTS","common");
		    }
}
	   }else if(appl_desc=="SSPL"){
		   if(speciality_code==''){
			  // err_txt="APP-OT40 Speciality Cannot Be Blank.....";
			   err_txt=getMessage("CANNOT_BE_BLANK","OT");
				var msgArray = err_txt.split("&");
				var speciality=getLabel("Common.speciality.label","common");
				alert(msgArray[0]+speciality+msgArray[1]);
				return;
		   } else{
			   			/*Added by Suma for 18874 on feb 04 2010 (if(function_id == "OT_MST_CODE_SURGPREF"))*/

			if(function_id == "OT_MST_CODE_SURGPREF")
{
	      	if(chkString.indexOf(packs_code)>=0 && chkString.indexOf(appl_desc)>=0 && chkString.indexOf(speciality_code)>=0 && chkString.indexOf(surgeon_desc)>=0){
					err_txt=getMessage("CODE_ALREADY_EXISTS","common");
		    }
}else
{
	      	if(chkString.indexOf(packs_code)>=0 && chkString.indexOf(appl_desc)>=0 && chkString.indexOf(speciality_code)>=0){
				//alert("inside SSPL if");
				//err_txt="APP-OT40 This Record is Duplicated...";
				err_txt=getMessage("CODE_ALREADY_EXISTS","common");
		    }
}
		   }
	   }else if(appl_desc=="SCAT"){
		   if(speciality_code==''){
			   //err_txt="APP-OT40 Speciality Cannot Be Blank.....";
			   err_txt=getMessage("CANNOT_BE_BLANK","OT");
				var msgArray = err_txt.split("&");
				var speciality=getLabel("Common.speciality.label","common");
				alert(msgArray[0]+speciality+msgArray[1]);
				return;
		   } else if(category_code==''){
               //err_txt="APP-OT40 Category Cannot Be Blank.....";
			   err_txt=getMessage("CANNOT_BE_BLANK","OT");
				var msgArray = err_txt.split("&");
				var category1=getLabel("Common.category1.label","common");
				alert(msgArray[0]+category1+msgArray[1]);
				return;
		   }else{			
			   			/*Added by Suma for 18874 on feb 04 2010 (if(function_id == "OT_MST_CODE_SURGPREF"))*/

			   	if(function_id == "OT_MST_CODE_SURGPREF")
{
	      	if(chkString.indexOf(packs_code)>=0 && chkString.indexOf(appl_desc)>=0 && chkString.indexOf(speciality_code)>=0 && chkString.indexOf(category_code)>=0 && chkString.indexOf(surgeon_desc)>=0){
					err_txt=getMessage("CODE_ALREADY_EXISTS","common");
		    }
}else
{
			if(chkString.indexOf(packs_code)>=0 && chkString.indexOf(appl_desc)>=0 && chkString.indexOf(speciality_code)>=0 && chkString.indexOf(category_code)>=0){
				//alert("inside SCAT if");
			//err_txt="APP-OT40 This Record is Duplicated...";
			err_txt=getMessage("CODE_ALREADY_EXISTS","common");
		    }
}
		   }
	   }else if(appl_desc=="SSUB"){
		     if(speciality_code==''){
			 //  err_txt="APP-OT40 Speciality Cannot Be Blank.....";
			   err_txt=getMessage("CANNOT_BE_BLANK","OT");
				var msgArray = err_txt.split("&");
				var speciality=getLabel("Common.speciality.label","common");
				alert(msgArray[0]+speciality+msgArray[1]);
				return;
		   } else if(category_code==''){
               //err_txt="APP-OT40 Category Cannot Be Blank.....";
			   err_txt=getMessage("CANNOT_BE_BLANK","OT");
				var msgArray = err_txt.split("&");
				var category1=getLabel("Common.category1.label","common");
				alert(msgArray[0]+category1+msgArray[1]);
				return;
		   }else if(subCategory_code==''){
               //err_txt="APP-OT40 Sub Category Cannot Be Blank.....";
				err_txt=getMessage("CANNOT_BE_BLANK","OT");
				var msgArray = err_txt.split("&");
				var subCategory=getLabel("eOT.SubCategory.Label","OT");
				alert(msgArray[0]+subCategory+msgArray[1]);
				return;
		   }else{
			   			/*Added by Suma for 18874 on feb 04 2010 (if(function_id == "OT_MST_CODE_SURGPREF"))*/

			   	if(function_id == "OT_MST_CODE_SURGPREF")
{
	      	if(chkString.indexOf(packs_code)>=0 && chkString.indexOf(appl_desc)>=0 && chkString.indexOf(speciality_code)>=0 && chkString.indexOf(category_code)>=0 && chkString.indexOf(subCategory_code)>=0 && chkString.indexOf(surgeon_desc)>=0){
					err_txt=getMessage("CODE_ALREADY_EXISTS","common");
		    }
}else
{
	      	if(chkString.indexOf(packs_code)>=0 && chkString.indexOf(appl_desc)>=0 && chkString.indexOf(speciality_code)>=0 && chkString.indexOf(category_code)>=0 && chkString.indexOf(subCategory_code)>=0){
				//alert("inside SSUB if");
			//err_txt="APP-OT40 This Record is Duplicated...";
			err_txt=getMessage("CODE_ALREADY_EXISTS","common");
		    }
}
		   }
	   }else if(appl_desc=="SOPR"){
		   if(operation_code==''){
              //err_txt="APP-OT40 Operation Cannot Be Blank.....";
				err_txt=getMessage("CANNOT_BE_BLANK","OT");
				var msgArray = err_txt.split("&");
				var operation=getLabel("Common.operation.label","common");				
				alert(msgArray[0]+operation+msgArray[1]);
				return;
		   }else{
	      			/*Added by Suma for 18874 on feb 04 2010 (if(function_id == "OT_MST_CODE_SURGPREF"))*/

				if(function_id=="OT_MST_CODE_SURGPREF")
				{
			if(chkString.indexOf(packs_code)>=0 && chkString.indexOf(appl_desc)>=0 && chkString.indexOf(operation_code)>=0 && chkString.indexOf(surgeon_desc)>=0){ 	
		
			err_txt=getMessage("CODE_ALREADY_EXISTS","common");
					}
				}else
				{
						if(chkString.indexOf(packs_code)>=0 && chkString.indexOf(appl_desc)>=0 && chkString.indexOf(operation_code)>=0){
					err_txt=getMessage("CODE_ALREADY_EXISTS","common");
						}
				}
		   }
	   }

	}//for loop end
		if(err_txt.length>0){
		 //alert(parent.parent.frames[2].name);
			parent.parent.frames[2].location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+err_txt;
		 return false;
	 }
	else       
	  return true;
}
	
function ChkNumber(obj){
	var quantity=obj.value;
	if(isNaN(quantity)==true){
		//alert("Enter a valid no");
		alert(getMessage("INVALID_NEXT_NUMBER","common"));
		obj.select();
		obj.focus();
	}
	if(obj.value!="" && quantity<=0){
		//alert("No. Of Units cannot be less than or equal to zero");
		var msg=getMessage("APP-OT0068","OT");
		var msgarry=msg.split("#");
		var noofUnits=getLabel("eOT.NoofUnits.Label","OT");
		alert(msgarry[0]+noofUnits+msgarry[1]);
		obj.select();
		obj.focus();
	}
}

/*function clearDesc(){
	var formObj = document.SurgicalAccessoriesConsumablePacksRecordForm;
	var desc=formObj.packs_desc.value;
	if(desc=="" ||desc=="null" ||desc==null)
		formObj.packs_code.value="";

}*/

function addRow() {
	 var rows=window.parent.frames[1].rows_for_consumables;
	 var formObj = document.SurgicalAccessoriesConsumablePacksRecordForm;
	 formObj.generic_search_for_packs.disabled=false;
	 formObj.packs_desc.disabled=false;
	 var mode =formObj.mode.value;
       if(chkEmpty()){
    	if(mode=='I'){
	 	  if(alreadyExist()){ //if the row which is bieng inserted already does not exist
	   	   if(chkForDuplicates()){
		   var objrow = newRow();
		   objrow.packs_code=formObj.packs_code.value;
		   objrow.packs_desc=formObj.packs_desc.value;
		   objrow.no_Of_Units=formObj.no_Of_Units.value;
		   objrow.mode="I";
		   objrow.recId = rows.length+1;
		   rows.push(objrow);
		   resetFields();
		   refresh();
		  } 
	   } //alreadyExist()
	 
}else{
	  updateRow();
  }
 }//chkEmpty()
}


function modeCheck(){
	var formObj = document.SurgicalAccessoriesConsumablePacksRecordForm;
	var master_frame = window.parent.frames[0];
	var hdr_frm = master_frame.document.forms[0];
	var packsCodeDtl =window.parent.frames[4].packs_code;
	var frmPacks_code=formObj.packs_code.value;
	var function_id=formObj.function_id.value;
	var appl_desc=hdr_frm.appl_desc.value;
	var splty_code=hdr_frm.speciality_code.value;
	var cat_code=hdr_frm.category_code.value;
	var sub_cat_code=hdr_frm.subCategory_code.value;
	var tab="package"
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var params = "appl_desc="+appl_desc+"&splty_code="+splty_code+"&cat_code="+cat_code+"&sub_cat_code="+sub_cat_code+"&tab="+tab+"&function_id="+function_id;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","ValidationOT.jsp?func_mode=fromSurgicalAcmaster&"+params,false);
	xmlHttp.send(xmlDoc);
	var retVal1 = trimString(xmlHttp.responseText);
	var err_txt="";
	var dtl_arr = retVal1.split(",");
	
	var dtl_arr_length = dtl_arr.length;
	var err_flag = "false";
	var i = 0;

		if(dtl_arr_length>0){
			while(i<=dtl_arr_length-2 && err_flag=="false"){
			
				if(dtl_arr[i] == frmPacks_code){
					err_flag = "true";
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
	var formObj = document.SurgicalAccessoriesConsumablePacksRecordForm;
	var rows=window.parent.parent.frames[1].frames[1].rows_for_consumables;
	var mode =formObj.mode.value;
	var recId = formObj.recId.value;
	var mode_chk=modeCheck();
	if(rows.length>0 && mode=='U'){
	   for(var jj=0;jj<rows.length;jj++){
				 if(rows[jj]!=null) {
					if(rows[jj].recId==recId){
                        //if(alreadyExist()){
							
						rows[jj].packs_code=formObj.packs_code.value;
						rows[jj].packs_desc=formObj.packs_desc.value;
						rows[jj].no_Of_Units=formObj.no_Of_Units.value;
						if(rows[jj].mode=='I')
							
							if(modeCheck()){
								mode="I";
							}else{
								mode="U"
							}
							rows[jj].mode=mode;
							
									 
						//}      				
					}
		         }else  
			continue;
		 }
      resetFields();
	  refresh();
 }
}

function removeRow(){
var formObj = document.SurgicalAccessoriesConsumablePacksRecordForm;
formObj.generic_search_for_packs.disabled=false;
formObj.packs_desc.disabled=false;
var rows=window.parent.parent.frames[1].frames[1].rows_for_consumables;
//alert(rows);
//alert(rows.length);
var recId = document.forms[0].recId.value;
var mode = document.forms[0].mode.value;
//alert(mode);
if(rows.length>0 && mode=='U' || rows.length>0 &&  mode=='I'){    
	//alert(mode+" in remove rows "+recId)
//	if(rows.length>0 && mode=='U'){
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
	var frmObj = document.SurgicalAccessoriesConsumablePacksRecordForm;
	
	frmObj.packs_code.value=arr[0];
   // alert("arr[0]=="+arr[0]+" "+"arr[1]=="+arr[1]+" "+"arr[2]=="+arr[2]+" "+"arr[3]=="+arr[3]+" "+"arr[4]=="+arr[4]);
	/*if(arr[4]=="U"){
	frmObj.packs_desc.disabled=true;
	}else{
	frmObj.packs_desc.disabled=false;
	}*/
	frmObj.packs_desc.value=arr[1];
	frmObj.no_Of_Units.value=arr[2];
	frmObj.recId.value=arr[3];
	frmObj.mode.value=arr[4];
	frmObj.generic_search_for_packs.disabled=true;
	frmObj.packs_desc.disabled=true;
	
	
}


function resetFields(){
	var frmObj = document.SurgicalAccessoriesConsumablePacksRecordForm;
	frmObj.packs_desc.value='';
	frmObj.packs_code.value='';
	frmObj.no_Of_Units.value='';
	frmObj.mode.value='I';
	}

function refresh(){
window.parent.frames[4].location.href='../../eOT/jsp/SurgicalAccessoriesConsumablePacksDetailForm.jsp?';              //+params;
}

function loadDBRows(packs_code,packs_desc,no_Of_Units,recId,mode){ 
  var formObj=document.SurgicalAccessoriesConsumablePacksRecordForm;
  //var index=formObj.index.value;
  var objrow = newRow();
  var rows=window.parent.parent.frames[1].frames[1].rows_for_consumables;
    if(mode=='L' && rows.length<recId)
	{
	  
	  objrow.packs_code = packs_code;
	  objrow.packs_desc = unescape(packs_desc);
	  objrow.no_Of_Units =no_Of_Units;
	  objrow.recId=recId;
	  objrow.mode=mode;
	  rows.push(objrow);
	 // alert(rows.length);
	    
	}
}
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<%
//String source=request.getParameter("source");
String mode=request.getParameter("update_mode_yn");
if (mode.equals("modify")){
mode="U";
}else{
mode="I";
}
String applicability=request.getParameter("applicability")==null?"":request.getParameter("applicability");
String speciality_code=request.getParameter("speciality_code")==null?"":request.getParameter("speciality_code");
String surgeon_code=request.getParameter("surgeon_code")==null?"":request.getParameter("surgeon_code");
//String speciality_desc="";
String oper_cat_code=request.getParameter("oper_cat_code")==null?"":request.getParameter("oper_cat_code");
//String oper_cat_desc="";
String oper_sub_cat_code=request.getParameter("oper_sub_cat_code")==null?"":request.getParameter("oper_sub_cat_code");
//String oper_sub_cat_desc="";
String oper_code=request.getParameter("oper_code")==null?"":request.getParameter("oper_code");
//String oper_desc="";
String strsql="";
String sql="";
String function_id=request.getParameter("function_id").equals(null)?"":request.getParameter("function_id");
//String function_id = request.getParameter("function_id") ;

String sql1="";
//if(function_id.equals("SurgeonPreferences")){
if(function_id.equals("OT_MST_CODE_SURGPREF")){

sql1="SELECT PREF_ID,APPLICABILITY,SPECIALITY_CODE,OPER_CAT_CODE,OPER_SUB_CAT_CODE,OPER_CODE,TEAM_DOCTOR_CODE  from OT_OPER_DR_PREFERENCE";
} else {
sql1="SELECT PACKAGE_CODE,APPLICABILITY,SPECIALITY_CODE,OPER_CAT_CODE,OPER_SUB_CAT_CODE,OPER_CODE from OT_OPER_PACKAGE";
}
StringBuffer dtlString=new StringBuffer();

if(applicability.equals("SSPL"))
     sql=" AND A.SPECIALITY_CODE='"+speciality_code+"'";
else if(applicability.equals("SCAT"))
     sql=" AND A.SPECIALITY_CODE='"+speciality_code+"' AND A.OPER_CAT_CODE='"+oper_cat_code+"'";
else if(applicability.equals("SSUB"))
     sql=" AND A.SPECIALITY_CODE='"+speciality_code+"' AND A.OPER_CAT_CODE='"+oper_cat_code+"' AND A.OPER_SUB_CAT_CODE='"+oper_sub_cat_code+"'";
else if(applicability.equals("SOPR"))
     sql=" AND A.OPER_CODE='"+oper_code+"'";

String package_qty="";
//strsql="SELECT A.PACKAGE_CODE, B.SHORT_DESC, A.PACKAGE_QTY FROM OT_OPER_PACKAGE A, OT_PACKAGE_HDR B WHERE A.PACKAGE_CODE= B.PACKAGE_CODE AND A.APPLICABILITY='"+applicability+"'"+sql;
//if(function_id.equals("SurgeonPreferences")){


if(function_id.equals("OT_MST_CODE_SURGPREF")){
//strsql="SELECT A.PREF_ID, B.SHORT_DESC, A.NO_OF_UNITS FROM OT_OPER_DR_PREFERENCE A, OT_PACKAGE_HDR_LANG_VW B WHERE A.PREF_ID= B.PACKAGE_CODE AND A.APPLICABILITY='"+applicability+"' AND B.LANGUAGE_ID='"+locale+"' "+sql;
//Code altered by Selvam for PHASE 3 Delivery
//strsql="SELECT A.PREF_ID, B.SHORT_DESC, A.NO_OF_UNITS FROM OT_OPER_DR_PREFERENCE A, OT_PACKAGE_HDR_LANG_VW B WHERE A.PREF_ID= B.PACKAGE_CODE AND A.APPLICABILITY='"+applicability+"' AND NVL(A.TEAM_DOCTOR_CODE,'!')=NVL('"+surgeon_code+"',NVL(A.TEAM_DOCTOR_CODE,'!')) AND B.LANGUAGE_ID='"+locale+"' "+sql;
strsql="SELECT A.PREF_ID, B.LONG_DESC, A.NO_OF_UNITS FROM OT_OPER_DR_PREFERENCE A, OT_PACKAGE_HDR_LANG_VW B WHERE A.PREF_ID= B.PACKAGE_CODE AND A.APPLICABILITY='"+applicability+"' AND NVL(A.TEAM_DOCTOR_CODE,'!')=NVL('"+surgeon_code+"',NVL(A.TEAM_DOCTOR_CODE,'!')) AND B.LANGUAGE_ID='"+locale+"' "+sql;
} else {
strsql="SELECT A.PACKAGE_CODE, B.LONG_DESC, A.PACKAGE_QTY FROM OT_OPER_PACKAGE A, OT_PACKAGE_HDR_LANG_VW B WHERE A.PACKAGE_CODE= B.PACKAGE_CODE AND A.APPLICABILITY='"+applicability+"' AND B.LANGUAGE_ID='"+locale+"' "+sql;

}
	System.err.println("sql strsql :" +strsql);
Connection con=null;
PreparedStatement stmt=null;
ResultSet rs=null;
//PreparedStatement stmt1=null;
//ResultSet rs1=null;
String consumable_desc = "";
int index=0;
if(mode.equals("U")){
try
{
	con=ConnectionManager.getConnection(request);
	stmt=con.prepareStatement(strsql);
	//stmt.setString(1,template_id);
	rs=stmt.executeQuery();
	
	while(rs.next())
	{
		index++;
		package_qty=rs.getString(3);
	    if(package_qty==null || package_qty.equals("") || package_qty.equals("null"))
		   package_qty="";	
		  consumable_desc= rs.getString(2);
		  //consumable_desc= java.net.URLEncoder.encode(rs.getString(2),"UTF-8");
		out.println("<script>loadDBRows('"+rs.getString(1)+"','"+consumable_desc+"','"+package_qty+"','"+index+"','L');</script>");
	}
	out.println("<script>refresh()</script>");
	//out.println("<script>assignRecID()</script>");
	

}catch(Exception e)
{
	e.printStackTrace();
	//System.err.println("Error in SurgicalAccessoriesConsumablePacksRecordForm records.jsp"+e.getMessage());
}finally{
	try{
		if(rs!=null) rs.close();
		if(stmt!=null) stmt.close();
		if(con!=null) 
		ConnectionManager.returnConnection(con,request);
	}catch(Exception e){e.printStackTrace();}
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
	//System.err.println("Error in SurgicalAccessoriesConsumable Packs Record Form records.jsp"+e1.getMessage());
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
<form name="SurgicalAccessoriesConsumablePacksRecordForm" id="SurgicalAccessoriesConsumablePacksRecordForm"  onload='FocusFirstElement()'  action="" method="" target=""> 
<table border=0 cellspacing=0 cellpadding=3 width='100%'  >
<tr>
	<td  class=label width='25%'>
		<fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
	<td class='fields' width='25%'>
			<input type="text" name="packs_desc" id="packs_desc" value="" size=15 maxlength=15 onBlur="if(this.value!='')callSearchcode('C',packs_code,packs_desc);else packs_code.value='';" >
			<input type="hidden" name="packs_code" id="packs_code" value="">
			<input type="button" class="button" name="generic_search_for_packs" id="generic_search_for_packs" value="?"  onclick="callSearchcode('C',packs_code,packs_desc);" >
			<img src='../../eCommon/images/mandatory.gif'>
	</td>
	
   <td class='label' width='25%'>
		<fmt:message key="eOT.NoofUnits.Label" bundle="${ot_labels}"/></td>
	<td class='fields' width='25%'>
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
	<input type='button' class='button' value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' onClick='removeRow();'  ></td>

		
</tr>
<input type="hidden" name='mode' id='mode' value='I'>
<input type="hidden" name='recId' id='recId' value=''>
<input type="hidden" name='dtlString' id='dtlString' value='<%=dtlString%>'>
<input type="hidden" name='ind' id='ind' value='<%=index%>'>

   
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


