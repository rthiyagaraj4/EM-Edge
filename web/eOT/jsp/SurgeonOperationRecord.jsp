<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page  import ="java.sql.Connection,java.sql.ResultSet,java.sql.PreparedStatement,java.sql.CallableStatement,eCommon.XSSRequestWrapper,eCommon.Common.*,webbeans.eCommon.ConnectionManager,eCommon.Common.*,eOT.*,eOT.OTBillingBean,java.lang.String,eOT.Common.*,eOR.OrderEntryBillingQueryBean,java.util.ArrayList" contentType=" text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/Common.jsp" %>
<%@ include file="../../eOT/jsp/StringUtil.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%  
    //Added Against MMS Vulnerability Issue - Starts
    request= new XSSRequestWrapper(request);
    response.addHeader("X-XSS-Protection", "1; mode=block");
    response.addHeader("X-Content-Type-Options", "nosniff");
	//Added Against MMS Vulnerability Issue - Ends

	 String locale = (String)session.getAttribute("LOCALE"); 
	 request.setCharacterEncoding("UTF-8");
	
	String or_bean_id 				= "Or_billingQueryBean";
	String or_bean_name 			= "eOR.OrderEntryBillingQueryBean";
	OrderEntryBillingQueryBean or_bean			= (OrderEntryBillingQueryBean)getBeanObject( or_bean_id, or_bean_name, request ) ;

	String bean_id 				= "OTBillingBean";
	String bean_name 			= "eOT.OTBillingBean";
	OTBillingBean billing_bean			= (OTBillingBean)getBeanObject( bean_id, bean_name, request ) ;
%>
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
	<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script>
	<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
	<script language="JavaScript" src="../../eOT/js/OTCommon.js"></script>
<script type='text/javascript' src='../../eCommon/js/ValidateControl.js'></script>
<%	String tab = checkForNull(request.getParameter("tab")); 
	String params = request.getQueryString();
	String Link_Operation_And_Notes_in_Record_Surgeon_Notes=request.getParameter("Link_Operation_And_Notes_in_Record_Surgeon_Notes");//PMG MOD-0005

	String oper_code2 = "",fpp_category = "";//Added Against ML-MMOH-CRF-1939-US4
	if(tab.equals("record_surgeon")){ %>
		<script language="JavaScript" src="../../eOT/js/RecordSurgeon.js"></script>
		<script language="JavaScript" src="../../eOT/js/CommonOperDtlsHdr.js"></script>
		<script language="JavaScript"> 
	   //var lblRemarksDiag=getLabel("Common.remarks.label","Common");	
		var lblRemarksDiag=getLabel("eOT.PreOperativeComments.Label","ot");	
	</script>
   <%}else if(tab.equals("record_nursing")){ %>
	<script language="JavaScript" src="../../eOT/js/RecordNursing.js"></script>
	<script language="JavaScript"> 
		   // Modified by DhanasekarV against remarks 
   //var lblRemarksDiag=getLabel("Common.remarks.label","Common");	
	var lblRemarksDiag=getLabel("eOT.PreOperativeComments.Label","ot");	
		
	</script>
   <%}%>

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

<script language='javascript'>

  var rightSide_title=getLabel("eOT.RightSide.Label","ot");
  var leftSide_title=getLabel("eOT.LeftSide.Label","ot");
  var notApplicable_title=getLabel("Common.notapplicable.label","common");
  var bilateral_title=getLabel("eOT.Bilateral.Label","ot");
  var operation_title=getLabel("Common.operation.label","common");
  var sideApplicable_title=getLabel("eOT.SideApplicable.Label","ot");
  function Class_row(){
     this.oper_code ="";
     this.oper_desc ="";
     this.side_applicable ="";
	 this.side_applicable_desc="";
     this.remarks = "";
	 this.line_no="";
	 this.side_applicable_yn="";
	 this.proc_link="";
	 this.proc_result="";
	 this.term_id="";
	 this.term_code="";
	 this.term_desc="";
	 this.color="";
	 this.order_line_no="";
	 this.order_id="";
	 this.db_mode="";
	 this.bill_str="";
	 this.panel_str="";
	 this.posted_yn="";
	 this.rate="";
	}
function loadDBRows(line_no,oper_code,oper_desc,side_applicable,remarks,proc_link,proc_result,term_id,term_code,color,term_desc,order_line_no,order_id,bill_str,panel_str,mode,oper_line_status,cancel_remarks,Speciality_code,oper_num,facility_id,order_catalog_code,fpp_cat){
  var rowLeng = 0;
  if(parent.parent.parent.ObjectCollect != null)
      rowLeng = parent.parent.parent.ObjectCollect.rowLength; 
  var rows = parent.parent.parent.ObjectCollect.rows;
  if(mode=='L' && rowLeng==0){
	   var objrow = newRow();
	   objrow.oper_code=oper_code;
	   oper_desc = decodeURIComponent(oper_desc,"UTF-8").replace(/\+/g," "); //Added Against ML-MMOH-SCF-1806
	   objrow.oper_desc=unescape(oper_desc);
	   objrow.side_applicable=side_applicable;
	   if(side_applicable=="R"){
		  objrow.side_applicable_desc=rightSide_title;
		  objrow.side_applicable_yn="Y";
	   }else if(side_applicable=='B'){
		   objrow.side_applicable_yn="Y";
		  objrow.side_applicable_desc=bilateral_title;
	   }else if(side_applicable=='L'){
		   objrow.side_applicable_yn="Y";
		  objrow.side_applicable_desc=leftSide_title;
	   }else if( side_applicable=='N' || side_applicable=='' ){
		   objrow.side_applicable_yn="N";
	      objrow.side_applicable_desc=notApplicable_title;
	   }
	   objrow.line_no=line_no;
	   //objrow.remarks=remarks;//added decode for scf-6081 by Anitha
   	   objrow.remarks=decodeURIComponent(remarks,"UTF-8").replace(/\+/g," ");
	   objrow.proc_link=proc_link;
	   objrow.proc_result=proc_result;
	   objrow.term_id=term_id;
	   objrow.term_code=term_code;
	    //objrow.term_desc=term_desc;//Modified Against ML-MMOH-SCF-3141
	   objrow.term_desc=decodeURIComponent(term_desc,"UTF-8").replace(/\+/g," ");
	   objrow.color=color;
	   objrow.order_id = order_id
	   objrow.order_line_no=order_line_no;
	   objrow.db_mode="L";
	   objrow.chk_status=oper_line_status;
	   objrow.oper_line_status=oper_line_status;
	   objrow.cancel_remarks=cancel_remarks;
	   objrow.bill_str=bill_str;
	   objrow.posted_yn=bill_str.split("::")[4];
	   objrow.panel_str=panel_str;
	   objrow.Speciality_code=Speciality_code;
	   objrow.order_catalog_code=order_catalog_code;
	   objrow.fpp_category=fpp_cat;//modified Against ML-MMOH-CRF-1939-US4
	   objrow.rate="";
	   
	    // Added Against ML-MMOH-SCF-2510	
		
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		var param="func_mode=getFppList&oper_code="+oper_code;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","../../eOT/jsp/OTCommonValidation.jsp?"+param,false);
		xmlHttp.send(xmlDoc);
		var retVal = localTrimString(xmlHttp.responseText);
		if(retVal!=''){
		arr=retVal.split("::");
		objrow.fpp_order_yn = arr[0];
		}
		// Added Against ML-MMOH-SCF-2510 
	   var rows = parent.parent.parent.ObjectCollect.rows;
	   
	   if(rows=="" || rows==null){
		     parent.parent.parent.ObjectCollect.rows = new Array();
			 rows = parent.parent.parent.ObjectCollect.rows;
       }
	   rows.push(objrow);
	 }

/*Added by Suma on jan 12 2010 against Incident 17692 to handle existing operation related speciality changes*/
	var formObj = document.forms[0];
  var chk_val="";
	  var db_mode="";
	  var oper_code_val="";
	  var status_value="";
	  var Speciality_code_val="";
	  var old_spec_val="";
		  if(rows!=null){
		   for (var jj=0;jj<rows.length ;jj++ )
		   {
			      //Modified by DhanasekarV against issue IN026698 on 2/3/2011
			   if(rows[jj] == null || rows[jj] === '') continue; //rows[jj] === against 35908
			   var status_val=rows[jj].chk_status;
			   if(status_val =="")
			   {
				   status_val="1";
			   }
			   chk_val +=rows[jj].oper_code+"*" +status_val+"*"+rows[jj].db_mode+"$";
			   old_spec_val +=rows[jj].Speciality_code+"*" +status_val+"*"+rows[jj].db_mode+"$";
			   db_mode +=rows[jj].db_mode +"*";
			   oper_code_val +=rows[jj].oper_code +"*";	   
			   if( status_val !="99")
			   {
			   Speciality_code_val +=rows[jj].Speciality_code +"*";
			   }
			   status_value +=status_val +"*";
		   }
		  }

		var oper_num =oper_num;
			//var facility_id = formObj.facility_id.value;
if(document.forms[0].tab.value=="record_surgeon"){
				var xmlDoc = "" ;
				var xmlHttp = new XMLHttpRequest();
				var params = "status_val="+chk_val;
				var xmlStr ="<root><SEARCH ";
				xmlStr +=" /></root>";
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open("POST","OTCommonValidation.jsp?func_mode=new_operation&facility_id="+facility_id+"&oper_num="+oper_num+"&"+params,false);
				xmlHttp.send(xmlDoc);
				var retVal = trimString(xmlHttp.responseText);

			
			var params1="status_val="+old_spec_val;	xmlHttp.open("POST","OTCommonValidation.jsp?func_mode=old_operation&facility_id="+facility_id+"&oper_num="+oper_num+"&"+params1,false);
				xmlHttp.send(xmlDoc);
				var retVal1 = trimString(xmlHttp.responseText);

//if(document.forms[0].tab.value=="record_surgeon"){
//	SS-SCF-0716 Added by Valluru on 10/9/2013
			frameReference(db_mode, status_value, oper_code_val, Speciality_code_val, retVal, retVal1)
		}
}
		function frameReference(db_mode, status_value, oper_code_val, Speciality_code_val, retVal, retVal1)
		{
			if(typeof(parent.parent.frames[4].RecordSurgeonTabForm) != "undefined" && parent.parent.frames[4].RecordSurgeonTabForm != '' && parent.parent.frames[4].RecordSurgeonTabForm != null)
			{
				parent.parent.frames[4].RecordSurgeonTabForm.db_mode.value=db_mode;
				parent.parent.frames[4].RecordSurgeonTabForm.status_value.value=status_value;
				parent.parent.frames[4].RecordSurgeonTabForm.oper_code_all.value=oper_code_val;
				parent.parent.frames[4].RecordSurgeonTabForm.Speciality_code_val.value=Speciality_code_val;
				parent.parent.frames[4].RecordSurgeonTabForm.oper_code_new.value=retVal;
				parent.parent.frames[4].RecordSurgeonTabForm.spec_code_final.value=retVal1;
			}
			else
			{
				//setTimeout("frameReference('"+db_mode+"', '"+status_value+"', '"+oper_code_val+"', '"+Speciality_code_val+"', '"+retVal+"', '"+retVal1+"')",500);
				setTimeout('frameReference(\""+db_mode+"\",\""+status_value+"\",\""+oper_code_val+"\",\""+Speciality_code_val+"\",\""+retVal+"\",\""+retVal1+"\")',500);
			}
		}
//	SS-SCF-0716 Added by Valluru on 10/9/2013

function refresh(){
	var formObj = document.forms[0];
	var param = formObj.params.value
	var tab = formObj.tab.value;
	parent.ResultsFrame.location.href='../../eOT/jsp/SurgeonOperationDtls.jsp?'+param;

}


function chkEmpty(){
	var formObj = document.RecordOperationForm; 
	var side_applicable_yn = formObj.side_applicable_yn.value;
	if(side_applicable_yn=='N'){
		var fields = new Array(formObj.oper_code);
		var names = new Array(operation_title);
	}else{
		var fields = new Array(formObj.oper_code,formObj.side_applicable);
		var names = new Array(operation_title,sideApplicable_title);
	 }
	var messageFrame = parent.parent.messageFrame;
	if(checkFields( fields, names, messageFrame))
		return true;
}

function callPopulateList(flag){}

function addRow(oper_code,oper_desc,side_applicable,remarks,mode,chk_status,cancel_remarks,spec_code,order_catalog_code,fpp_category){
	var formObj = document.forms[0];
	var frmRef = parent.parent.ObjectCollect;
	var tab = formObj.tab.value;
	var params2 = formObj.params.value;
	var bill_flag = formObj.bill_flag.value;
	var proc_chrg_cmp_yn = formObj.proc_chrg_cmp_yn.value;
	var facility_id = formObj.facility_id.value;
	var objrow = newRow();
	var rows=parent.parent.ObjectCollect.rows;

	var msg=getMessage("CODE_ALREADY_EXISTS","Common");
	
	if(chk_status !="99")
	{
		chk_status="";
	}
  if(chkEmpty()){
    if(mode=='I'){
	  if(alreadyExist(oper_code,mode)){
		if(bill_flag=="true")
		{
			var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest();
		var params= "order_catalog_code="+order_catalog_code;
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","CommonValidation.jsp?func_mode=from_direct_booking&"+params,false);
		xmlHttp.send(xmlDoc);
		var retVal1 = trimString(xmlHttp.responseText);

		if(retVal1 =="Y")
			{
		var retVal = callOrderLineCreation();
		retVal=trimString(retVal);
		var arr = retVal.split("@@");
		if((arr[0]=="BL0639" && bill_flag=="true") || (~(arr[0]).indexOf("BL0639")!=0)){
			alert(getMessage("BL0639","BL"));
			return false;
		}
		if(arr[2]!=undefined)
			{
		if(localTrimString(arr[2])!='')
			{
			var err_pat=localTrimString(arr[2]);
			alert(err_pat);
			return false;
			}
		}
		}
		}
		   objrow.oper_code=oper_code;
		   objrow.oper_desc=oper_desc;
		   objrow.side_applicable=side_applicable;
		   objrow.Speciality_code=spec_code;
		   objrow.order_catalog_code=order_catalog_code;

// Added Against ML-MMOH-SCF-2510	
		var fpp_order_yn = 'N';
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		var param="func_mode=getFppList&oper_code="+oper_code;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","../../eOT/jsp/OTCommonValidation.jsp?"+param,false);
		xmlHttp.send(xmlDoc);
		var retVal2 = localTrimString(xmlHttp.responseText);
		if(retVal2!=''){
		arr2=retVal2.split("::");
		fpp_order_yn = arr2[0];
		}
		// Added Against ML-MMOH-SCF-2510
		   if(fpp_category!='')
		   objrow.fpp_category=fpp_category;
		   objrow.fpp_order_yn= fpp_order_yn;
		   objrow.side_applicable_yn=formObj.side_applicable_yn.value;
			if(side_applicable=="R"){
				objrow.side_applicable_desc=rightSide_title;
			}else if(side_applicable=='B'){
				objrow.side_applicable_desc=bilateral_title;
			}else if(side_applicable=='L'){
				objrow.side_applicable_desc=leftSide_title;
			}else if( side_applicable=='N' || side_applicable=='' ){
				objrow.side_applicable_desc=notApplicable_title;
			}   
			var line_no1=getOperLineNumber();
            objrow.line_no=line_no1;
		    objrow.db_mode="I";
		    objrow.chk_status=chk_status;

		    objrow.cancel_remarks=(cancel_remarks);
		 	objrow.remarks=remarks;
				with(formObj){
				   objrow.proc_link=proc_link.value;
				   objrow.proc_result=proc_result.value;
				   objrow.term_id=term_id.value;
				   objrow.term_code=term_code.value;
				   objrow.term_desc=term_desc.value;
				   objrow.color=color.value;
				  objrow.order_id = order_id.value;
				  objrow.order_line_no="";
				   /* Below Change done by sathish against CRF-303.1*/
				    var str1=line_no1+"::"+oper_code.value+"::"+oper_desc.value+"::"+term_id.value+"::"+term_code.value+"::"+color.value+"::"+term_desc.value;
                                  if(color.value=="AUTO")
                                  autoPopulate(str1);
                                  else if(color.value=="MANDATORY")
                                  frmRef.mandatory_proc[oper_code.value]="N";

                                  if(color.value=="MANDATORY")
                                        {
                                        parent.parent.parent.doc_status_frame.SurgeonDocStatusForm.doc_complete.checked = false;
                             }
				  /*  Change done by sathish against CRF-303.1 Ends Here*/	
		         }
				  if(bill_flag=="true")
		          {
					  if(retVal1 =="Y")
			{
				   var arr = retVal.split("@@");
				   objrow.panel_str=arr[0];
				   objrow.bill_str=arr[1];
			}
				  }
           /* Below Change done by sathish against CRF-303.1*/
                        if(parent.parent.frames[4].document.getElementById("ICDPCS").style.display=='none')
                  {
                        var xmlDoc = "" ;
                        var xmlHttp = new XMLHttpRequest();
                        var params= "oper_code="+oper_code+"&facility_id="+facility_id;
                        var xmlStr ="<root><SEARCH ";
                        xmlStr +=" /></root>";
                        xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
                        xmlHttp.open("POST","OTCommonValidation.jsp?func_mode=procedure_coding_scheme_tab_yn&"+params,false);
                        xmlHttp.send(xmlDoc);
                        var flag_proc_yn = trimString(xmlHttp.responseText);
                   if(flag_proc_yn!="")
                   {
				parent.parent.frames[4].document.getElementById("ICDPCS").style.display='Inline';
               parent.parent.frames[4].document.getElementById("ICDPCSspan").style.display='Inline';
                   }
                  }
		    /*  Change done by sathish against CRF-303.1 Ends Here*/
			//Modified against [IN:046190] 
			//window.parent.parent.ObjectCollect.rows.push(objrow);
			if(rows == null || rows.length == 0)
				rows[0] = objrow;
			else
			   rows[rows.length] = objrow;
		   resetFields();
		   alert(getMessage("APP-OT0175" ,"OT"));

		var mode="I";

		   // Modified by DhanasekarV against remarks 
   //document.getElementById('remarks_one').innerText=getLabel("Common.remarks.label","Common");
   document.getElementById('remarks_one').innerText=getLabel("eOT.PreOperativeComments.Label","Common");

//		document.getElementById('remarks_one').innerText=getLabel("Common.remarks.label","Common");
		var url_val='../../eOT/jsp/SurgeonOperationDtls.jsp?'+params2+'&mode_one='+mode;
		parent.ResultsFrame.location.href=url_val;
		   parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='
	
	  }else
			parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+msg;
 } else
	  {	
	  updateRow(oper_code,oper_desc,side_applicable,remarks,mode,chk_status,cancel_remarks,spec_code,fpp_category);
	  }
  }


  	 /*Added by Suma for incident 16685 Starts here */

	  var chk_val="";
	  var db_mode="";
	  var oper_code_val="";
	  var status_value="";
	  var Speciality_code_val="";
	  var old_spec_val="";
	//  rows = parent.parent.ObjectCollect.rows;

	  

		  if(rows!=null){
		   for (var jj=0;jj<rows.length ;jj++ )
		   {
			   //Modified by DhanasekarV against issue IN026698 on 2/3/2011
			   if(rows[jj] == null || rows[jj] === '') continue;//rows[jj] === against 35908 
			   var status_val=rows[jj].chk_status;
			   if(status_val =="")
			   {
				   status_val="1";
			   }
			   chk_val +=rows[jj].oper_code+"*" +status_val+"*"+rows[jj].db_mode+"$";
			   old_spec_val +=rows[jj].Speciality_code+"*" +status_val+"*"+rows[jj].db_mode+"$";
			   db_mode +=rows[jj].db_mode +"*";
			   oper_code_val +=rows[jj].oper_code +"*";
			     if( status_val !="99")
			   {
			   Speciality_code_val +=rows[jj].Speciality_code +"*";
			   }
			   status_value +=status_val +"*";
		   }
		  }


				var oper_num = formObj.oper_num.value;
				var xmlDoc = "" ;
				var xmlHttp = new XMLHttpRequest();
				var params = "status_val="+chk_val;
				var xmlStr ="<root><SEARCH ";
				xmlStr +=" /></root>";
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open("POST","OTCommonValidation.jsp?func_mode=new_operation&facility_id="+facility_id+"&oper_num="+oper_num+"&"+params,false);
				xmlHttp.send(xmlDoc);
				var retVal = trimString(xmlHttp.responseText);

			
			var params1="status_val="+old_spec_val;	xmlHttp.open("POST","OTCommonValidation.jsp?func_mode=old_operation&facility_id="+facility_id+"&oper_num="+oper_num+"&"+params1,false);
			xmlHttp.send(xmlDoc);
			var retVal1 = trimString(xmlHttp.responseText);

	if(document.forms[0].tab.value=="record_surgeon"){
				parent.parent.frames[4].RecordSurgeonTabForm.db_mode.value=db_mode;
				parent.parent.frames[4].RecordSurgeonTabForm.status_value.value=status_value;
				parent.parent.frames[4].RecordSurgeonTabForm.oper_code_all.value=oper_code_val;
				parent.parent.frames[4].RecordSurgeonTabForm.Speciality_code_val.value=Speciality_code_val;
				parent.parent.frames[4].RecordSurgeonTabForm.oper_code_new.value=retVal;
				parent.parent.frames[4].RecordSurgeonTabForm.spec_code_final.value=retVal1;
	}
				/*16685 changes ends here*/
}

function assignRowLength(cou){
	parent.parent.parent.ObjectCollect.rowLength=cou;
}


function newRow(){
  var objrow = new Class_row();
   return(objrow);
}

function alreadyExist(oper_code,mode){
	var rows=parent.parent.ObjectCollect.rows;
	if(rows.length>0 && mode=='I'){
		for(var jj=0;jj<rows.length;jj++){
			if(rows[jj]!=null ){
				if(rows[jj].oper_code==oper_code){
					return false;
					break;
				}
			continue;
		 }
	  }
	}
	return true;
}


function updateRow(oper_code,oper_desc,side_applicable,remarks,mode,chk_status,cancel_remarks,spec_code,fpp_category){
 var formObj = document.forms[0];
 var params = formObj.params.value;
 var tab = formObj.tab.value;
 var rows1=parent.parent.ObjectCollect.rows;
 var icd_pcs_rows = parent.parent.ObjectCollect.ICD_PCS_ROWS;
 var retVal ;	
 var flag_cancel=true;
 var flag_exist=false;
 var bill_flag = formObj.bill_flag.value;
    //Modified by DhanasekarV against issue IN026698 on 2/3/2011
 var removeVal = -1;

 if(rows1.length>0 && mode=='U'){  
 /*Added by sathish against CRF-303.1 */
 for(j in icd_pcs_rows){
                if (oper_code == icd_pcs_rows[j].oper_code && icd_pcs_rows[j].db_mode!='D'){  
					flag_exist=true;
                }
        }
 if(chk_status=='99' && flag_exist==true)
 flag_cancel=confirm(getMessage("APP-OT0181","OT"));
  


 if(flag_cancel==true)
 deleteRow(oper_code,chk_status);
 /* Change done by sathish against CRf-303.1 Ends Here*/
 for(var jj=0;jj<rows1.length;jj++){
 if(rows1[jj]!=null && rows1[jj].oper_code!=null && rows1[jj].oper_code!="" && flag_cancel==true) {
      if(rows1[jj].oper_code==oper_code){
		  if(rows1[jj].db_mode !="I" )
		  {
			  if(bill_flag=="true") //ML-MMOH-CRF-1939-US003
		          {
			retVal  = callOrderLineCreation();
			var arr = retVal.split("@@");
			rows1[jj].panel_str=arr[0];
			rows1[jj].bill_str=arr[1];
				  }
		  rows1[jj].oper_code=oper_code;	
		  rows1[jj].oper_desc=oper_desc;
		  rows1[jj].side_applicable=side_applicable;
		  rows1[jj].Speciality_code=spec_code;
		  rows1[jj].fpp_category=fpp_category;
		  rows1[jj].side_applicable_yn=formObj.side_applicable_yn.value;
		  if(side_applicable=="R"){
			rows1[jj].side_applicable_desc=rightSide_title;
		  }else if(side_applicable=='B'){
			rows1[jj].side_applicable_desc=bilateral_title;
	      }else if(side_applicable=='L'){
		    rows1[jj].side_applicable_desc=leftSide_title;
	      }else if( side_applicable=='N' || side_applicable=='' ){
	          rows1[jj].side_applicable_desc=notApplicable_title;
	     }
		
		 //rows1[jj].remarks=encodeURIComponent(remarks,"UTF-8"); //commented by Anitha for remarks issue scf-6081
		 rows1[jj].remarks=remarks;
		 rows1[jj].cancel_remarks=(cancel_remarks);
		  if(rows1[jj].db_mode=='L')
		  {
			rows1[jj].db_mode='U'
		  }
		 rows1[jj].chk_status=chk_status;
			var spec_oper_comb="";
			   break;
	  }else if(rows1[jj].db_mode =="I" && chk_status =="99")
	  {
		  removeVal = jj;
		  break;
			  
	  }else if(rows1[jj].db_mode =="I"){//Added else block for scf6081 by Anitha
//start
		if(bill_flag=="true") //ML-MMOH-CRF-1939-US003
		          {
			retVal  = callOrderLineCreation();
			var arr = retVal.split("@@");
			rows1[jj].panel_str=arr[0];
			rows1[jj].bill_str=arr[1];
				  }
				  rows1[jj].oper_code=oper_code;	
		  rows1[jj].oper_desc=oper_desc;
		  rows1[jj].side_applicable=side_applicable;
		  rows1[jj].Speciality_code=spec_code;
		  rows1[jj].fpp_category=fpp_category;
		  rows1[jj].side_applicable_yn=formObj.side_applicable_yn.value;
		  if(side_applicable=="R"){
			rows1[jj].side_applicable_desc=rightSide_title;
		  }else if(side_applicable=='B'){
			rows1[jj].side_applicable_desc=bilateral_title;
	      }else if(side_applicable=='L'){
		    rows1[jj].side_applicable_desc=leftSide_title;
	      }else if( side_applicable=='N' || side_applicable=='' ){
	          rows1[jj].side_applicable_desc=notApplicable_title;
	     }
		
		 //rows1[jj].remarks=encodeURIComponent(remarks,"UTF-8");//commented by Anitha for remarks issue scf-6081
		 rows1[jj].remarks=remarks;
		 rows1[jj].cancel_remarks=(cancel_remarks);
		 rows1[jj].chk_status=chk_status;


//end
	  }
 }
  }else  
	  continue;
 }

    //Modified by DhanasekarV against issue IN026698 on 2/3/2011

  if(removeVal > -1)  
	 {
		delete rows1[removeVal];
//		parent.parent.ObjectCollect.rows =rows1
	 }
	    
   resetFields();
   var mode="M";
   // Modified by DhanasekarV against remarks 
   //document.getElementById('remarks_one').innerText=getLabel("Common.remarks.label","Common");
   document.getElementById('remarks_one').innerText=getLabel("eOT.PreOperativeComments.Label","Common");
   parent.ResultsFrame.location.href='../../eOT/jsp/SurgeonOperationDtls.jsp?'+params+'&mode_one='+mode;
 }
}

function localTrimString(sInString) {
  return sInString.replace(/^\s+|\s+$/g,"");
}


function splitString(strVal){
    var arr = strVal.split('::');
	var frmObj = document.forms[0];
	frmObj.oper_code.value=arr[0];
	frmObj.oper_desc.value=arr[1];
	frmObj.spec_code.value=arr[10];
     frmObj.side_applicable.value = (arr[2]=='N')?"":arr[2];
if(arr[8] !="99")
{
	frmObj.remarks.style.visibility="visible";
	frmObj.remarks.style.display="inline";
	frmObj.cancel_remarks.style.visibility="hidden";
	frmObj.cancel_remarks.style.display="none";
}else
{
	frmObj.cancel_remarks.style.visibility="visible";
	frmObj.cancel_remarks.style.display="inline";
	frmObj.remarks.style.visibility="hidden";
	frmObj.remarks.style.display="none";
}
//11/29/2010
	 frmObj.remarks.value=unescape(arr[3]);
	 frmObj.cancel_remarks.value=unescape(arr[7]);
	frmObj.mode.value=arr[4];
	frmObj.side_applicable_yn.value=arr[5];
	frmObj.count_val.value=arr[9];
	frmObj.fpp_category.value=arr[11];
	frmObj.OperationLookUp.disabled=true;
	if(arr[5]!="Y")
		frmObj.side_applicable.disabled=true;
	else
		frmObj.side_applicable.disabled=false;
  }

function resetFields(){
	var frmObj = document.forms[0];
	frmObj.oper_code.value='';
	frmObj.oper_desc.value='';
	frmObj.side_applicable.value='';
	frmObj.remarks.value='';
	frmObj.cancel_remarks.value='';
	frmObj.mode.value='I';
	frmObj.side_applicable_yn.value='';
	frmObj.OperationLookUp.disabled=false;
	frmObj.OperationLookUp.focus();
	frmObj.chk_status.disabled=true;
	frmObj.chk_status.checked=false;
}

function checkLimit(field, limit){
	 if (field.value.length > limit){
		   var msg = getMessage("MAX_LENGTH_DATA","OT");
		   var msgArray = msg.split("#");
		   alert(msgArray[0]+""+msgArray[1]+limit+msgArray[2]);
		   var revertField = field.value.slice(0, limit);
		   field.value = revertField;
		   field.focus();
	  }
}

function setOperLineNumber(line_no){
 var  frmObj = parent.parent.parent.ObjectCollect;
   if(frmObj.line_no==0){
		frmObj.line_no = parseInt(line_no,10);
   }
}

function getOperLineNumber(){
	frmObj = parent.parent.parent.ObjectCollect;
  var line_no= (isNaN(frmObj.line_no)==true)?1:frmObj.line_no+1;
   parent.parent.ObjectCollect.line_no = line_no;
   return line_no;
}


function LoadMandatoryFlag(code,flag){
	if(document.forms[0].tab.value=="record_surgeon"){
			rows = parent.parent.parent.ObjectCollect.mandatory_proc;
			if(typeof rows[code]=='undefined')
			rows[code]=flag;	
	}
}

function callOrderLineCreation(){
	var formObj = document.forms[0];
	var order_id = formObj.order_id.value;
	var oper_num = formObj.oper_num.value;
	var oper_code = formObj.oper_code.value;
	var oper_code = formObj.oper_code.value;
	var fpp_category      =    formObj.fpp_category.value;
	var param = "order_id="+order_id+"&oper_num="+oper_num+"&oper_code="+oper_code+"&called_from=RECORD_SURGEON"+"&fpp_category="+fpp_category;
	var xmlStr ="<root></root>";
	var temp_jsp="OTOrderLineCreation.jsp?"+param;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	var responseText=trimString(xmlHttp.responseText) ;
	return responseText;
}

function trimString(sInString) {
  sInString = sInString.replace( /^\s+/g, "" );// strip leading
  return sInString.replace( /\s+$/g, "" );// strip trailing
}

function SpecialCharRestriction(event){//This function will not allow special characters and will allow all other language characters apart from english
	var strCheck = "\"`'";
	var whichCode = (window.Event) ? event.which : event.keyCode;
	key = String.fromCharCode(whichCode);  // Get key value from key code
	if (strCheck.indexOf(key) != -1) return false;  // Not a valid key
	return true ;
}

</script>
</HEAD>
<BODY OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form name = 'RecordOperationForm'>
<input type='hidden' name='rowLength' id='rowLength' value='0'>
<input type='hidden' name='tab' id='tab' value='<%=tab%>'>
<input type='hidden' name='params' id='params' value='<%=params%>'>
<%
	
	String called_from = request.getParameter("called_from");
	String facility_id = checkForNull(request.getParameter("facility_id"));
	String oper_num = checkForNull(request.getParameter("oper_num"));
	String surgeon_doc_comp_yn = checkForNull(request.getParameter("surgeon_doc_comp_yn"));
	String proc_chrg_cmp_yn = checkForNull(request.getParameter("proc_chrg_cmp_yn"));
	String bill_flag = request.getParameter("bill_flag");
	String disable_flag="",line_no="",oper_code="",oper_desc="",side_applicable="",remarks="",max_oper_num="",proc_link="",proc_result="",term_set_id="",term_code= "",term_desc= "",color= "",proc_code_entered_yn="",auto_populate_yn = "",auto_param = "",order_line_no = "",order_id = "",panel_str="",posted_yn="",module_id="",Speciality_code="",oper_line_status="",cancel_remarks="",bill_str  = "",order_catalog_code="",short_desc="",fpp_cat="";
	HashMap bill_info = new HashMap();
	StringBuilder bl_bfr = new StringBuilder();
	//047397 start
	String checkInTime = checkForNull(request.getParameter("check_in_time"));	//047397
	PreparedStatement customerIdPstmt = null;
	ResultSet customerIdRs = null;
	String customerId = "";
	//047397 end
	//String SQL ="SELECT A.OPER_CODE, A.OPER_LINE_NUM, B.SHORT_DESC, A.RIGHT_LEFT_FLAG, replace(replace(A.oper_remarks, chr(13),' '),chr(10),'.') OPER_REMARKS ,C.PROC_LINK_APPLICABLE,C.PROC_LINK_RESULTING_OPTION,C.TERM_SET_ID,TRIM(C.TERM_CODE) TERM_CODE,DECODE(PROC_LINK_RESULTING_OPTION,'M','MANDATORY','O','OPTIONAL',DECODE(C.PROC_LINK_APPLICABLE,'P','AUTO','NA')) COLOR,A.ORDER_LINE_NUM ORDER_LINE_NUM,A.ORDER_ID ORDER_ID,A.OPER_LINE_STATUS OPER_LINE_STATUS,A.CANCEL_REMARKS CANCEL_REMARKS,B.SPECIALITY_CODE SPECIALITY_CODE,B.ORDER_CATALOG_CODE FROM OT_POST_OPER_DTLS A, OT_OPER_MAST_LANG_VW B, OR_ORDER_CATALOG_LANG_VW C WHERE C.LANGUAGE_ID='"+locale+"' AND B.LANGUAGE_ID=? AND A.OPERATING_FACILITY_ID  = ? AND A.OPER_NUM  =?  AND A.OPER_CODE = B.OPER_CODE AND B.ORDER_CATALOG_CODE = C.ORDER_CATALOG_CODE";
	String SQL ="SELECT A.OPER_CODE, A.OPER_LINE_NUM, B.LONG_DESC OPER_DESC, A.RIGHT_LEFT_FLAG, A.oper_remarks OPER_REMARKS ,C.PROC_LINK_APPLICABLE,C.PROC_LINK_RESULTING_OPTION,C.TERM_SET_ID,TRIM(C.TERM_CODE) TERM_CODE,DECODE(PROC_LINK_RESULTING_OPTION,'M','MANDATORY','O','OPTIONAL',DECODE(C.PROC_LINK_APPLICABLE,'P','AUTO','NA')) COLOR,A.ORDER_LINE_NUM ORDER_LINE_NUM,A.ORDER_ID ORDER_ID,A.OPER_LINE_STATUS OPER_LINE_STATUS,A.CANCEL_REMARKS CANCEL_REMARKS,B.SPECIALITY_CODE SPECIALITY_CODE,B.ORDER_CATALOG_CODE,A.FPP_CATEGORY FROM OT_POST_OPER_DTLS A, OT_OPER_MAST_LANG_VW B, OR_ORDER_CATALOG_LANG_VW C WHERE C.LANGUAGE_ID='"+locale+"' AND B.LANGUAGE_ID=? AND A.OPERATING_FACILITY_ID  = ? AND A.OPER_NUM  =?  AND A.OPER_CODE = B.OPER_CODE AND B.ORDER_CATALOG_CODE = C.ORDER_CATALOG_CODE";//MMS-QH-CRF-0199 

	//Added against ML-MMOH-CRF-1939...starts
	String Include_Fpp_yn = "N";
	boolean isIncludeFpp = false; 
	Integer Fpp_count = 0;
	String encounter_id = "";
	String patient_id = "";
	String patient_class = request.getParameter("patient_class");
	String tab_name = checkForNull(request.getParameter("tab_name"));
	String ot_bean_id = "OTCommonBean";
	String ot_bean_name = "eOT.OTCommonBean";
	OTCommonBean bean = (OTCommonBean)mh.getBeanObject( ot_bean_id, request, ot_bean_name );
	//Added against ML-MMOH-CRF-1939...ends
	
	Connection con = null;
	PreparedStatement pstmt = null,pstmt1 = null,pstmt3 = null;
	ResultSet rst = null,rset = null,rset3 = null,rs = null;
	int count=0;
    String episode_id = "";
	ArrayList Fpplist = new ArrayList();
    String fpp_order_yn = "N";
	String fpp_def_category = ""; 
	try{
		con = ConnectionManager.getConnection(request);
		
		//Added Against ML-MMOH-CRF-1939...starts
				
	Include_Fpp_yn = bean.getIncludeFpp(facility_id);
	System.err.println("Include_Fpp_yn === "+Include_Fpp_yn);
	
	isIncludeFpp = CommonBean.isSiteSpecific(con,"OT","OT_FPP");
	System.err.println("isIncludeFpp --->"+isIncludeFpp);
       // isIncludeFpp = true;
	
	Fpp_count = bean.getFppIcon();
	encounter_id = request.getParameter("encounter_id");
	patient_id = request.getParameter("patient_id");
	
	if(patient_class.equals("OP") || patient_class.equals("EM")){
        episode_id =encounter_id.substring(0,(encounter_id.length()-4));           
    }
    if(patient_class.equals("IP") || patient_class.equals("DC")){
        episode_id =encounter_id; 
    }
	//Added Against ML-MMOH-CRF-1939...ends
		//047397 start 
		customerIdPstmt = con.prepareStatement("SELECT customer_id FROM sm_site_param WHERE ROWNUM = 1");
		customerIdRs = customerIdPstmt.executeQuery();
		if(customerIdRs !=null && customerIdRs.next())
			customerId = checkForNull(customerIdRs.getString("customer_id"));
		if(customerIdRs!=null)
			customerIdRs.close();
		if(customerIdPstmt!=null)
			customerIdPstmt.close();
		//047397 end 
	if(proc_chrg_cmp_yn.equals("Y") || surgeon_doc_comp_yn.equals("Y"))
		disable_flag="disabled";
	else 
		disable_flag="";
		pstmt = con.prepareStatement(SQL);
		pstmt.setString(1,locale);
		pstmt.setString(2,facility_id);
		pstmt.setString(3,oper_num);
		rst = pstmt.executeQuery();
		while(rst.next()){
			count++;
			line_no = checkForNull(rst.getString("OPER_LINE_NUM"));
			oper_code=checkForNull(rst.getString("OPER_CODE"));
			Fpplist = billing_bean.getFPPDetails(oper_code);
			for (int j = 0; j < Fpplist.size(); j++){
			if(j==0) fpp_order_yn=checkForNull((String)Fpplist.get(j));
			if(j==1) fpp_def_category=checkForNull((String)Fpplist.get(j));
			}
			oper_desc= checkForNull(rst.getString("OPER_DESC"));//MMS-QH-CRF-0199
			side_applicable= checkForNull(rst.getString("RIGHT_LEFT_FLAG"));
			remarks=(checkForNull(rst.getString("OPER_REMARKS")));
			//remarks=java.net.URLEncoder.encode(remarks,"UTF-8");
			//System.err.println("remarks @@@@@@@@"+remarks);


			proc_link= checkForNull(rst.getString("PROC_LINK_APPLICABLE"));
			proc_result=checkForNull(rst.getString("PROC_LINK_RESULTING_OPTION"));
			term_set_id = checkForNull(rst.getString("TERM_SET_ID"));
			term_code  = checkForNull(rst.getString("TERM_CODE"));
			color  = checkForNull(rst.getString("COLOR"));
			Speciality_code=checkForNull(rst.getString("SPECIALITY_CODE"));
			order_id = checkForNull(rst.getString("ORDER_ID"));
			oper_line_status = checkForNull(rst.getString("OPER_LINE_STATUS"));
			cancel_remarks= checkForNull(rst.getString("CANCEL_REMARKS"));
			order_line_no = checkForNull(rst.getString("ORDER_LINE_NUM"));
			order_catalog_code = checkForNull(rst.getString("ORDER_CATALOG_CODE"));
			fpp_cat = checkForNull(rst.getString("FPP_CATEGORY"));//modified Against ML-MMOH-CRF-1939-US4
			posted_yn = billing_bean.billingPostedYN(oper_num,line_no);
			if(("true").equals(bill_flag)){
			bill_info = or_bean.getOrderBillDtls(order_id+order_line_no);	
			if(bill_info==null || (bill_info!=null && bill_info.size()==0)){
				bill_info = new HashMap();
				if("X".equals(posted_yn) && fpp_order_yn.equals("N")){
					module_id = "OT";
					bill_info.put("key",oper_num); 
					//Modified below line by DhanasekarV on 17/01/2011 against issue - IN025937
					bill_info.put("key_line_no",line_no);	
				}else if("X".equals(posted_yn) && fpp_order_yn.equals("Y")){
					System.err.println("891 else if");
					module_id = "OT";
					bill_info.put("key",order_id); //changed by Gaurav open_num to order_id
					//Modified below line by DhanasekarV on 17/01/2011 against issue - IN025937
					bill_info.put("key_line_no",line_no);	
					}else{
					module_id = "OR";
					bill_info.put("key",order_id);
					bill_info.put("key_line_no",order_line_no);
					}
				//Modified by DhanasekarV on 17/01/2011 against issue - IN025937
				//System.err.println("SUrgeon Operatin Record "+ module_id +" order_line_no "+ order_line_no+" key "+bill_info.get("key")+" key line no "+bill_info.get("key_line_no"));
		
				bill_info.put("oper_code",oper_code);
				bill_info.put("oper_num",oper_num);
				bill_info.put("locale",locale);
				bill_info.put("module_id",module_id);
				bill_info.put("quantity","1");
				bill_info.put("oper_line_status",oper_line_status);
				bill_info.put("cancel_remarks",cancel_remarks);
					bill_info.put("order_line_no",order_line_no);//050795
					System.err.println("fpp_def_category =========="+fpp_def_category);
					System.err.println("fpp_cat 906 =========="+fpp_cat);
					//if(fpp_order_yn.equals("Y")){
					if(fpp_cat.equals("S") || fpp_cat.equals("M") || fpp_cat.equals("C"))
						bill_info.put("fpp_category",fpp_cat);
					else
						bill_info.put("fpp_category",fpp_def_category);
					//ML-MMOH-CRF-1939-US4
					//}
				//populate billing details from OTBillingBean........	
				bill_info = billing_bean.getBillingParams(bill_info,"S");
				or_bean.setOrderBillDtls(order_id+order_line_no,bill_info);
				putObjectInBean(or_bean_id,or_bean,request);
			}
			panel_str = (String) bill_info.get("bl_panel_str");
			}//end ofm if bill_flag
			if(!term_code.equals("")){
				pstmt1	 = con.prepareStatement("SELECT SHORT_DESC PROC_DESC FROM MR_TERM_CODE WHERE TERM_CODE=?");
				pstmt1.setString(1,term_code);
				rset = pstmt1.executeQuery();
				if(rset !=null && rset.next()){
					term_desc = rset.getString("PROC_DESC");			
				}
			}
              /*Below Query is added by sathish against CRF-303.1*/
			if(pstmt3!=null) pstmt3.close();
			if(rset3!=null)  rset3.close();
			String val="";
	

			String SQL_DB = "SELECT A.OPER_LINE_NUM, A.OPER_CODE, B.LONG_DESC OPER_DESC, A.PROC_CODING_SCHEME, A.PROC_CODE, C.SHORT_DESC PROC_DESC, DECODE(D.PROC_LINK_RESULTING_OPTION,'M','MANDATORY','O','OPTIONAL','AUTO') COLOR FROM OT_POST_OPER_PROC_DTLS A, OT_OPER_MAST B, MR_TERM_CODE C, OR_ORDER_CATALOG_LANG_VW D WHERE D.LANGUAGE_ID='"+locale+"' AND A.OPERATING_FACILITY_ID     = ? AND     A.OPER_NUM = ? AND  A.OPER_CODE = B.OPER_CODE AND A.PROC_CODING_SCHEME  = C.TERM_SET_ID AND A.PROC_CODE = C.TERM_CODE AND  D.ORDER_CATEGORY = 'OT' AND  B.ORDER_CATALOG_CODE    =  D.ORDER_CATALOG_CODE";//MMS-QH-CRF-0199

			pstmt3 = con.prepareStatement(SQL_DB);
			pstmt3.setString(1,facility_id);
			pstmt3.setString(2,oper_num);
			rset3 = pstmt3.executeQuery();   

			while(rset3.next()){
			val = rset3.getString(1)+"::"+rset3.getString(2)+"::"+rset3.getString(3)+"::"+rset3.getString(4)+"::"+rset3.getString(5)+"::"+rset3.getString(6)+"::"+rset3.getString(7);
			if(tab.equals("record_surgeon")){ 
			out.println("<script>loadDBRows_pro_coding('"+val+"');</script>");
			 }
			}
			if(pstmt3!=null) pstmt3.close();
			if(rset3!=null)  rset3.close();
            /* Change done  by sathish against CRF-303.1 Ends here */


			if("M".equals(proc_result) && tab.equals("record_surgeon") ){
				pstmt1	 = con.prepareStatement("SELECT DECODE(COUNT(PROC_CODE),'0','N','Y') FROM OT_POST_OPER_PROC_DTLS  WHERE  OPERATING_FACILITY_ID = ? AND OPER_NUM =?   AND  OPER_CODE=?");
				pstmt1.setString(1,facility_id);
				pstmt1.setString(2,oper_num);
				pstmt1.setString(3,oper_code);
				rset = pstmt1.executeQuery();
				while(rset.next()){
					proc_code_entered_yn = rset.getString(1);			
				}
				if(!"99".equals(oper_line_status) && tab.equals("record_surgeon"))
				out.println("<script> LoadMandatoryFlag('"+oper_code+"','"+proc_code_entered_yn+"')</script>");
			}

			if( "P".equals(proc_link) && tab.equals("record_surgeon")){
				pstmt1	 = con.prepareStatement("SELECT DECODE(COUNT(PROC_CODE),'0','I','L') FROM OT_POST_OPER_PROC_DTLS  WHERE  OPERATING_FACILITY_ID = ? AND OPER_NUM =?   AND  OPER_CODE=?");
				pstmt1.setString(1,facility_id);
				pstmt1.setString(2,oper_num);
				pstmt1.setString(3,oper_code);
				rset = pstmt1.executeQuery();
				while(rset.next()){
					auto_populate_yn = rset.getString(1);			
				}
				if("I".equals(auto_populate_yn)){
					auto_param = line_no+"::"+oper_code+"::"+oper_desc+"::"+term_set_id+"::"+term_code+"::"+color+"::"+term_desc;
					out.println("<script>autoPopulate('"+auto_param+"','"+oper_line_status+"')</script>");
				}
					
			}
		  
            if(("true").equals(bill_flag)){
			String reason_code=null;
			String overridden_incl_excl_ind=null;
			bl_bfr.append(checkForNull(""+bill_info.get("total_payable"),"0.0")).append("::");
			bl_bfr.append(checkForNull(""+bill_info.get("patient_payable"),"0.0")).append("::");
			bl_bfr.append(checkForNull(""+bill_info.get("patient_paid_amt"),"0.0")).append("::");
			bl_bfr.append(checkForNull(""+bill_info.get("charged_yn"),"N")).append("::");
			bl_bfr.append(overridden_incl_excl_ind).append("::");
			bl_bfr.append(checkForNull(""+bill_info.get("preapp_yn"),"N")).append("::");
			bl_bfr.append(checkForNull(""+bill_info.get("serv_panel_ind"),"S")).append("::");
			bl_bfr.append(reason_code).append("::");
			bl_bfr.append(checkForNull(""+bill_info.get("incl_excl_ind"),"E")).append("::");
			bl_bfr.append(checkForNull(""+bill_info.get("err_id"),""));
			bill_str = bl_bfr.toString();
			
			bl_bfr.setLength(0);
			}
			//Added encode for scf-6081 by Anitha
			//out.println("<script>loadDBRows('"+line_no+"','"+oper_code+"','"+oper_desc +"','"+side_applicable +"',\""+java.net.URLEncoder.encode(remarks,"UTF-8")+"\",'"+proc_link+"','"+proc_result+"','"+term_set_id+"','"+term_code+"','"+color+"','"+term_desc+"','"+order_line_no+"','"+order_id+"','"+bill_str+"','"+panel_str+"','L','"+oper_line_status+"','"+cancel_remarks+"','"+Speciality_code+"','"+oper_num+"','"+facility_id+"','"+order_catalog_code+"');</script>");
			
			//if(("true").equals(bill_flag) && Include_Fpp_yn.equals("Y") && isIncludeFpp && Fpp_count==1){
			out.println("<script>loadDBRows('"+line_no+"','"+oper_code+"',\""+java.net.URLEncoder.encode(oper_desc,"UTF-8")+"\",'"+side_applicable +"',\""+java.net.URLEncoder.encode(remarks,"UTF-8")+"\",'"+proc_link+"','"+proc_result+"','"+term_set_id+"','"+term_code+"','"+color+"',\""+java.net.URLEncoder.encode(term_desc,"UTF-8")+"\",'"+order_line_no+"','"+order_id+"','"+bill_str+"','"+panel_str+"','L','"+oper_line_status+"','"+cancel_remarks+"','"+Speciality_code+"','"+oper_num+"','"+facility_id+"','"+order_catalog_code+"','"+fpp_cat+"');</script>"); //Modified against ML-MMOH-CRF-1939-US4
			/* }else{
			out.println("<script>loadDBRows('"+line_no+"','"+oper_code+"',\""+java.net.URLEncoder.encode(oper_desc,"UTF-8")+"\",'"+side_applicable +"',\""+java.net.URLEncoder.encode(remarks,"UTF-8")+"\",'"+proc_link+"','"+proc_result+"','"+term_set_id+"','"+term_code+"','"+color+"','"+term_desc+"','"+order_line_no+"','"+order_id+"','"+bill_str+"','"+panel_str+"','L','"+oper_line_status+"','"+cancel_remarks+"','"+Speciality_code+"','"+oper_num+"','"+facility_id+"','"+order_catalog_code+"');</script>"); //Modified oper_desc Against ML-MMOH-SCF-1806 	
			}*/
		}
		if(rset!=null) rset.close();
		if(pstmt!=null) pstmt.close();
		if(rst!=null) rst.close();
		pstmt = con.prepareStatement(OTRepository.getOTKeyValue("SQL_OT_OPERATIONS_SELECT2"));
		pstmt.setString(1,facility_id);
		pstmt.setString(2,oper_num);
		rst = pstmt.executeQuery();
		while(rst.next()){
			max_oper_num = rst.getString(1);			
		}
			if(rst!=null) rst.close();
		if(pstmt!=null) pstmt.close();

    	out.println("<script> assignRowLength('"+count+"');</script>");
		out.println("<script> setOperLineNumber('"+max_oper_num+"');</script>");
		out.println("<script>refresh();</script>");
		if(tab.equals("record_surgeon"))
		out.println("<script>assignAutoLength();</script>");

	}catch(Exception e){
		e.printStackTrace();
		System.err.println("SurgeonOper Record:  Err Msg in SurgeonOperationRecord.jsp "+e.getMessage());
	}
	finally{
		if(rst!=null) rst.close();
		if(pstmt!=null) pstmt.close();
		if(con!=null) ConnectionManager.returnConnection(con,request);
	}
		
%>

<table border='0' cellpadding='3' cellspacing='0' width='100%' align='center'>
<tr> 
	  <td class="label" width='0%'><fmt:message key="Common.operation.label" bundle="${common_labels}"/> </td>
	  <td class="fields" width='0%'>
		  <input type='text' name='oper_code' id='oper_code' maxlength='10'  onBlur="if(this.value!='')searchOperations(document.forms[0].mode.value,oper_code);else{}"> 
		  <input type='button' class='button' value='?' name='OperationLookUp' id='OperationLookUp' onClick='searchOperations(document.forms[0].mode.value,oper_code);'  <%=disable_flag%> > <img name='imageflag1' src='../../eCommon/images/mandatory.gif'></img>
	  </td>

 	  <td class="label" width='0%'><fmt:message key="Common.description.label" bundle="${common_labels}"/> </td>
     <td class="fields" width='0%'>
		<input type='text' name='oper_desc' id='oper_desc' size='30' readonly> 
			<input type='hidden' name='spec_code' id='spec_code' value=''>
			<input type='hidden' name='order_catalog_code' id='order_catalog_code' value=''>

	</td>
</tr>

<tr>
  <td class="label" width='0%' nowrap><fmt:message key="eOT.SideApplicable.Label" bundle="${ot_labels}"/> </td>
	<td class="fields" width='0%'>
		<select name='side_applicable' id='side_applicable' DB_VALUE='' <%=disable_flag%> >
		<option value='' ><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></option>
		<option value='R' ><fmt:message key="eOT.RightSide.Label" bundle="${ot_labels}"/> </option>
		<option value='L' ><fmt:message key="eOT.LeftSide.Label" bundle="${ot_labels}"/> </option>
		<option value='B' ><fmt:message key="eOT.Bilateral.Label" bundle="${ot_labels}"/> </option>
		</select>
		<img src='../../eCommon/images/mandatory.gif' name='imageflag'></img>
	</td>
    <td class="label" valign='top'  width='0%'  id='remarks_one'>
	<!-- modified by DhanasekarV against remarks issue 
	<fmt:message key="Common.remarks.label" bundle="${common_labels}"/>
	-->
	<fmt:message key="eOT.PreOperativeComments.Label" bundle="${ot_labels}"/> 
	</td>
	<td class="fields" width='0%'>
		<textarea rows='5' cols='40' name='remarks' <%=disable_flag%> Onblur="makeValidString(this);" onKeyPress="return SpecialCharRestriction(event);"></textarea>
		<textarea rows='5' cols='40'  style='visibility:hidden;display:none' name='cancel_remarks' <%=disable_flag%> Onblur="makeValidString(this);"></textarea>

	</td> 
	</tr>
	<tr>
		<input type='hidden' name='count_val' id='count_val' value="">

	<td  class="label" valign='top'  COLSPAN='2'  ><fmt:message key="Common.cancel.label" bundle="${common_labels}"/><!--PMG MOD-0005 START-->
	<input type="checkbox"  name="chk_status" id="chk_status"  onclick="assignChkBoxVal(this,document.forms[0].mode.value,document.forms[0].oper_code.value,document.forms[0].count_val.value,document.forms[0].spec_code.value)" disabled ><!--PMG MOD-0005-->
	</td>
	<input type='hidden' name='fpp_category' id='fpp_category' value=''>
	<td width="25%"></td>
	<td class="button" width='0%' align='right'>
		<input type='button' class='button' value='<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>' name="btn_select" onClick='addRow(document.forms[0].oper_code.value,document.forms[0].oper_desc.value,document.forms[0].side_applicable.value,document.forms[0].remarks.value,document.forms[0].mode.value,document.forms[0].chk_status.value,document.forms[0].cancel_remarks.value,document.forms[0].spec_code.value,document.forms[0].order_catalog_code.value,document.forms[0].fpp_category.value);' <%=disable_flag%> >
		
	</td>
</tr>
</table>
				<%if(!imgUrl.equals("")){ %>
					 <img src='<%=imgUrl%>' width='100%' height='15'/> 
				<%}%>
	<input type='hidden' name='recId' id='recId' value=''>
	<input type='hidden' name='mode' id='mode' value='I'>
	<input type='hidden' name='called_from' id='called_from' value='<%=called_from%>'>
	<input type='hidden' name='facility_id' id='facility_id' value='<%=facility_id%>'>
	<input type='hidden' name='oper_num' id='oper_num' value='<%=oper_num%>'>
	<input type='hidden' name='collect_speciality_code' id='collect_speciality_code' value=''>
	<input type='hidden' name='side_applicable_yn' id='side_applicable_yn' value=''>
	<input type='hidden' name='proc_link' id='proc_link' value="">
	<input type='hidden' name='proc_result' id='proc_result' value="">
	<input type='hidden' name='term_id' id='term_id' value="">
	<input type='hidden' name='term_code' id='term_code' value="">
	<input type='hidden' name='term_desc' id='term_desc' value="">
	<input type='hidden' name='color' id='color' value="">
	<input type='hidden' name='order_id' id='order_id' value="<%=order_id%>">
	<input type='hidden' name='locale' id='locale' value="<%=locale%>">
	<input type="hidden" name="bill_flag" id="bill_flag" value="<%=bill_flag%>">
	<input type="hidden" name="remarks_hidden" id="remarks_hidden" value="">
	<input type="hidden" name="count" id="count" value="<%=count%>">
	<input type="hidden" name="oper_line_status" id="oper_line_status" value="">
	<input type="hidden" name="proc_chrg_cmp_yn" id="proc_chrg_cmp_yn" value="<%=proc_chrg_cmp_yn%>">
	<input type="hidden" name="checkInTime" id="checkInTime" value="<%=checkInTime%>"> <!-- 047397 -->
	<input type="hidden" name="customerId" id="customerId" value="<%=customerId%>"> <!-- 047397 -->
	<input type="hidden" name="Link_Operation_And_Notes_in_Record_Surgeon_Notes" id="Link_Operation_And_Notes_in_Record_Surgeon_Notes" id="Link_Operation_And_Notes_in_Record_Surgeon_Notes" value="<%=Link_Operation_And_Notes_in_Record_Surgeon_Notes%>">
	<!--Added Against ML-MMOH-CRF-1939...starts-->
	<input type="hidden" name="Include_Fpp_yn" id="Include_Fpp_yn" value="<%=Include_Fpp_yn%>"> 
	<input type="hidden" name="isIncludeFpp" id="isIncludeFpp" value="<%=isIncludeFpp%>"> 
	<input type="hidden" name="Fpp_count" id="Fpp_count" value="<%=Fpp_count%>">
	<input type="hidden" name="episode_id" id="episode_id" value="<%=episode_id%>"> 
	<input type="hidden" name="fpp_Cat" id="fpp_Cat" value="<%=fpp_category%>">
	<input type="hidden" name="tab_name" id="tab_name" value="<%=tab_name%>">
	<!--Added Against ML-MMOH-CRF-1939...ends-->
</form>
</BODY>
</HTML>


