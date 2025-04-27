<!DOCTYPE html>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eOT.Common.OTRepository" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eOT/jsp/StringUtil.jsp"%>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

String locale = (String)session.getAttribute("LOCALE");

request.setCharacterEncoding("UTF-8");
String imgUrl="";
	if(sStyle.equals("IeStyle.css"))
	 {
			imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
	 }
%>
<HTML>
<HEAD>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
<script language="JavaScript" src="../../eOT/js/RecordNursing.js"></script>
<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script>
<script language="JavaScript" src="../../eOT/js/OTCommon.js"></script>
<script language='javascript' src='../../eCommon/js/ValidateControl.js' ></script>
<script language='javascript'>

function Class_disposalrow(){
     this.anatomical_code="";
	 this.anatomical_desc="";
	 this.disposal_code ="";
     this.disposal_desc ="";
	 this.given_by="";
	 this.received_by="";
     this.db_mode="";
	 this.recId ="";
}

/*function disableDocLevel(){
   var formObj = parent.parent.common_patient_hdr_frame.CommonOperDtlsHdrForm;
   formObj.doc_level.disabled=true;
}*/

function loadDBRows(str){ 
  var objrow = newRow();
  var arr = str.split("::");
  var rows=parent.parent.ObjectCollect.disposal_rows;
  var rowLength=parent.parent.ObjectCollect.disposal_len;
   //alert("rowLength="+rowLength);
   if(arr[7]=='L' && rowLength==0)
	{
	   objrow.anatomical_code = arr[0];
	   objrow.anatomical_desc = unescape(arr[1].replace(/\+/g," "));
	   //objrow.anatomical_desc = decodeURIComponent(arr[1]);
	   objrow.disposal_code= arr[2];
	  // objrow.disposal_desc= decodeURIComponent(arr[3].replace("+"," "));
	  	 //objrow.given_by = decodeURIComponent(arr[4].replace("+"," "));
	   //objrow.received_by = decodeURIComponent(arr[5].replace("+"," "));
   	   //Added decodeURIComponent for 26039 on 1/21/2011 by AnithaJ

	   objrow.disposal_desc= decodeURIComponent(arr[3],"UTF-8").replace(/\+/g," ");
	   objrow.given_by= decodeURIComponent(arr[4],"UTF-8").replace(/\+/g," ");
	   objrow.received_by= decodeURIComponent(arr[5],"UTF-8").replace(/\+/g," ");
	   objrow.recId=arr[6];
	   objrow.db_mode=arr[7];
	   rows.push(objrow);
	}
}



function addRow(){
  var objrow = newRow();
  var formObj = document.DisposalRecordForm;
  var mode = formObj.mode.value;
  if(mode=='I'){
		 if(chkEmpty()){	
		 if(alreadyExist()){
				  var rows = parent.parent.ObjectCollect.disposal_rows;
				  objrow.anatomical_code =formObj.anatomical_site_code.value; 
				  objrow.anatomical_desc=formObj.anatomical_site_desc.value;
				  objrow.disposal_code=formObj.disposal_code.value;
				  objrow.disposal_desc=formObj.disposal_desc.value;
				  objrow.given_by = formObj.given_by.value;
				  objrow.received_by = formObj.received_by.value;
				  objrow.db_mode='I';
				  objrow.recId = getRecId();
				  rows.push(objrow);
				  resetFields();
				 parent.parent.RecordFrame.DetailFrame.location.href='../../eOT/jsp/NursingDisposalDtls.jsp';
				  parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='
		   }else { //else part of alreadyExist method
				
				var msg = trimString(getMessage("CODE_ALREADY_EXISTS","Common"));
				parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+msg;
		   }
		}//End of chkEmpty 
    }else {//else part of mode 
	if (chkEmpty())	{
		updateRow();
	}
	}
}


function updateRow(){
 var formObj = document.DisposalRecordForm;
 var rows=parent.parent.ObjectCollect.disposal_rows;
 var mode = formObj.mode.value;

 var recId = formObj.recId.value;

 if(rows.length>0 && mode=='U'){        
 for(var jj=0;jj<rows.length;jj++){
 if(rows[jj]!=null ) {
      if(rows[jj].recId==recId){
		 
		  rows[jj].anatomical_code=formObj.anatomical_site_code.value;	
		  rows[jj].anatomical_desc=formObj.anatomical_site_desc.value;
		  rows[jj].disposal_code=formObj.disposal_code.value;
		  rows[jj].disposal_desc=formObj.disposal_desc.value;
		  rows[jj].given_by = formObj.given_by.value;
		  rows[jj].received_by = formObj.received_by.value;
		  if(rows[jj].db_mode=='L')
			rows[jj].db_mode='U'
		    break;
	  }
  }else  
	  continue;
 }
   
   resetFields();
   parent.parent.RecordFrame.DetailFrame.location.href='../../eOT/jsp/NursingDisposalDtls.jsp';
 }
}


function assignRecId(){
	var rows = parent.parent.ObjectCollect.disposal_rows;
	parent.parent.ObjectCollect.disposal_len=rows.length;
	
	
}


function getRecId(){
    var rowLength=parent.parent.ObjectCollect.disposal_len;
	var recId = rowLength+1;
	parent.parent.ObjectCollect.disposal_len  =  recId;
	return recId;
}


function removeRow(){
 var formObj = document.DisposalRecordForm;
 var mode = formObj.mode.value;
 var recId = formObj.recId.value;
 var rows = parent.parent.ObjectCollect.disposal_rows;
 if(rows.length>0&& mode=='U'){        
 for(var jj=0;jj<rows.length;jj++){
 if(rows[jj]!=null ) {
	 if(rows[jj].recId==recId ){
      if(rows[jj].db_mode=='L')
	    rows[jj].db_mode='D';
	  else
		delete rows[jj];
	   break;
	 }
  }else
	continue;
 }//end for-Loop
   resetFields();
   parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='
   parent.parent.RecordFrame.DetailFrame.location.href='../../eOT/jsp/NursingDisposalDtls.jsp';
 }else
   resetFields();
}

function newRow()
{
   var objrow = new Class_disposalrow();
    return(objrow);
}

function chkEmpty(){
	var formObj = document.DisposalRecordForm;
	var fields = new Array(formObj.anatomical_site_desc,formObj.disposal_desc,formObj.given_by,formObj.received_by);
	var disposedItem= getLabel("eOT.DisposedItem.Label","OT");
	var	disposal     = getLabel("eOT.Disposal.Label","OT");
	var	givenBy		 =getLabel("Common.givenby.label","Common");
	var	receivedBy	= getLabel("Common.ReceivedBy.label","Common");
	
	var names = new Array(disposedItem,disposal,givenBy,receivedBy);
	var messageFrame = parent.parent.messageFrame;
	if(checkFields( fields, names, messageFrame))
		return true;
}

function alreadyExist(){
	var formObj = document.DisposalRecordForm;
	var codeDtl = parent.parent.RecordFrame.DetailFrame.code; 
	var rows = parent.parent.ObjectCollect.disposal_rows;
	var anatomical_code=formObj.anatomical_site_code.value;
	var disposal_code = formObj.disposal_code.value;
	var codeRecord = anatomical_code+disposal_code;
	if(codeDtl.indexOf(codeRecord)>=0)
	   return false;
	else
	  return true;
 }



function resetFields()
{
	var frmObj = document.forms[0];
	frmObj.anatomical_site_code.value='';
	frmObj.anatomical_site_desc.value='';
	frmObj.disposal_code.value='';
	frmObj.disposal_desc.value=''
	frmObj.given_by.value='';
	frmObj.received_by.value='';
	frmObj.mode.value='I';
	frmObj.recId.value=''
	frmObj.anatomicalLookUp.disabled=false;
	frmObj.disposalLookUp.disabled=false;
	frmObj.anatomicalLookUp.focus();
}

function splitString(strVal){
    var arr = strVal.split('::');
	var frmObj = document.forms[0];
	frmObj.anatomical_site_code.value=arr[0];
	frmObj.anatomical_site_desc.value=arr[1];
	frmObj.disposal_code.value=arr[2];
	frmObj.disposal_desc.value=arr[3];
	//frmObj.given_by.value=arr[4];
	frmObj.given_by.value=decodeURIComponent(arr[4],"UTF-8").replace(/\+/g," ");
	frmObj.received_by.value=decodeURIComponent(arr[5],"UTF-8").replace(/\+/g," ");
	//frmObj.received_by.value=arr[5];
	frmObj.recId.value=arr[6];
	frmObj.mode.value=arr[7];
	frmObj.anatomicalLookUp.disabled=true;
	frmObj.disposalLookUp.disabled=false;
	
}

function refresh(){
	var formObj = document.forms[0];
	var params = formObj.params.value;
	//parent.parent.RecordFrame.DetailFrame.location.href='../../eOT/jsp/NursingDisposalDtls.jsp?'+params;
	parent.DetailFrame.location.href='../../eOT/jsp/NursingDisposalDtls.jsp?'+params;
}

function checkForSpecCharsSymbol(event){
	var strCheck = "+%";
	var whichCode = (window.Event) ? event.which : event.keyCode;
	key = String.fromCharCode(whichCode);  // Get key value from key code
	if (strCheck.indexOf(key) != -1) return false;  // Not a valid key
	return true ;
}

</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<% String params = request.getQueryString(); %>
<form name='DisposalRecordForm' id='DisposalRecordForm' >
<input type='hidden' name='params' id='params' value='<%=params%>'>
<%
	
	String oper_num = checkForNull(request.getParameter("oper_num"));
	String facility_id = checkForNull(request.getParameter("facility_id"));
	String  nursing_doc_comp_yn = checkForNull(request.getParameter("nursing_doc_comp_yn"));
	String disable_flag="";
	if( nursing_doc_comp_yn.equals("Y") )
	  disable_flag="disabled";
	 else 
	   disable_flag="";

	/*String anatomical_code="";
	String anatomical_desc="";
	String disposal_code="";
	String disposal_desc="";
	String received_by="";
	String given_by="";*/
	    
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rst = null;
	try{
		con = ConnectionManager.getConnection(request);
		pstmt = con.prepareStatement(OTRepository.getOTKeyValue("SQL_OT_DISPOSAL_DTLS_SELECT")) ;
		pstmt.setString(1,locale);
		pstmt.setString(2,facility_id);
		pstmt.setString(3,oper_num);
		pstmt.setString(4,locale);
		rst = pstmt.executeQuery();
		int index = 0;
		while(rst.next()){
			index++;
			/*anatomical_code=rst.getString("SITE_CODE");
			//anatomical_desc=replace(rst.getString("SITE_DESC"));
			anatomical_desc=java.net.URLEncoder.encode(rst.getString("SITE_DESC"),"UTF-8");
			disposal_code=rst.getString("DISP_CODE");
			//disposal_desc=replace(rst.getString("DISP_DESC"));
			disposal_desc=java.net.URLEncoder.encode(rst.getString("DISP_DESC"),"UTF-8");
			given_by = java.net.URLEncoder.encode(checkForNull(rst.getString("GIVEN")),"UTF-8");
			received_by = java.net.URLEncoder.encode(checkForNull(rst.getString("RECEIVED")),"UTF-8");*/
			String args = rst.getString("SITE_CODE")+"::"+java.net.URLEncoder.encode(rst.getString("SITE_DESC"),"UTF-8")+"::"+rst.getString("DISP_CODE")+"::"+java.net.URLEncoder.encode(rst.getString("DISP_DESC"),"UTF-8")+"::"+java.net.URLEncoder.encode(checkForNull(rst.getString("GIVEN")),"UTF-8")+"::"+java.net.URLEncoder.encode(checkForNull(rst.getString("RECEIVED")),"UTF-8")+"::"+index+"::"+"L";
				
				out.println("<script>loadDBRows('"+args+"'); </script>");	

		}
		out.println("<script>refresh()</script>");
		out.println("<script>assignRecId()</script>");
	}catch(Exception e){
		 System.err.println("Err Msg in Nursing Disposal Records"+e.getMessage());
	}finally{
		if(rst!=null)rst.close();
		if(rst!=null)pstmt.close();
		if(con!=null)
		ConnectionManager.returnConnection(con,request);
	}
	
%>

<table border='0' cellpadding=3  cellspacing='0' width='100%' align='center'>
<tr> 
	<td  class="label" width='25%'><fmt:message key="eOT.DisposedItem.Label" bundle="${ot_labels}"/> </td> 
	<td class="fields" width='25%'>
	   <input type='hidden' name='anatomical_site_code' id='anatomical_site_code'>
		<input type='text' name='anatomical_site_desc' id='anatomical_site_desc' size='15'  value=''    <%=disable_flag%> onBlur="if(this.value!='')searchAnatomicalSite(anatomical_site_code,anatomical_site_desc);">
		<input type='button' class='button' value='?' name='anatomicalLookUp' id='anatomicalLookUp' onClick='searchAnatomicalSite(anatomical_site_code,anatomical_site_desc);'  <%=disable_flag%> > <img src='../../eCommon/images/mandatory.gif'></img>
	</td>
<!--  </tr>

<tr> -->
	<td class="label" width='25%'><fmt:message key="eOT.Disposal.Label" bundle="${ot_labels}"/> </td> 
	<td class="fields" width='25%'>
			<input type='hidden' name='disposal_code' id='disposal_code'>
			<input type='text' name='disposal_desc' id='disposal_desc' size='15'  value=''  <%=disable_flag%> onBlur="if(this.value!='')searchDisposal(disposal_code,disposal_desc);">
			<input type='button' class='button' value='?' name='disposalLookUp' id='disposalLookUp' onClick='searchDisposal(disposal_code,disposal_desc);'  <%=disable_flag%> > <img src='../../eCommon/images/mandatory.gif'></img>
	</td>
</tr>
<tr>
	<td class="label" width='25%'><fmt:message key="Common.givenby.label" bundle="${common_labels}"/> </td> 
	<td class="fields" width='25%'>
			<input type='text' name='given_by' id='given_by' size='15'  maxlength='100' onkeypress="return checkForSpecCharsSymbol(event);" <%=disable_flag%> >
			<img src='../../eCommon/images/mandatory.gif'></img>
	</td>
<!-- </tr>
<tr> -->
	<td class="label" width='25%'><fmt:message key="Common.ReceivedBy.label" bundle="${common_labels}"/> </td> 
	<td class="fields" width='25%'>
			<input type='text' name='received_by' id='received_by' size='15' maxlength='100' onkeypress="return checkForSpecCharsSymbol(event);" <%=disable_flag%> >
			<img src='../../eCommon/images/mandatory.gif'></img>
			
	</td>
</tr>

<tr>  <td></td>
      <td></td>
	<td class="button" width='25%' colspan='2'>
		<input type='button' class='button' value='<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>' onClick='addRow();'  <%=disable_flag%>>
		<input type='button' class='button' value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' onClick='removeRow();' <%=disable_flag%> >
		
	</td>
</tr>
</table>
<!-- added by Sathish for Amazon Changes-->
				<%if(!imgUrl.equals("")){ %>
					 <img src='<%=imgUrl%>' width='100%' height='15'/> 
				<%}%>
	<!-- end -->
<input type='hidden' name='recId' id='recId' value=''>
<input type='hidden' name='mode' id='mode' value='I'>
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
</form>
</body>
</html>
	

