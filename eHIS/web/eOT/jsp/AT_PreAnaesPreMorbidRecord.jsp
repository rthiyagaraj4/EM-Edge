<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@page import="eCommon.Common.CommonBean,java.sql.Connection,java.sql.ResultSet,java.sql.PreparedStatement,webbeans.eCommon.ConnectionManager" %>
<html>
<head>
<%
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String imgUrl="";
	if(sStyle.equals("IeStyle.css"))
	 {
			imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
	 }

%>

	<link rel="StyleSheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css" />
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script> 
	<script language="JavaScript" src="../../eOT/js/AT_RecordAnesthesiaDetails.js"></script>
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<script>
	function checkForSpecCharsforID(event)
	{
		//function created for spl chars
		var strCheck = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ`~!@#$*()_+{}|':?><,./;\][";
		var whichCode = (window.Event) ? event.which : event.keyCode;
		key = String.fromCharCode(whichCode);  
		if(event.keyCode==37 || event.keyCode==38 || event.keyCode==94 || event.keyCode==60 || event.keyCode==43){
			return false
		}else
		if( (event.keyCode >= 97) && (event.keyCode <= 122) )
			return true ;
}

	/*Added by Suma for incident 18700*/
	function checkForSpecCharsforID1(event)
{   
    var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_*/-.,=+ ';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode); 
    if (strCheck.indexOf(key) == -1 && event.keyCode!=13) return false;  
	return true ;
}
/*added by Suma ends here*/
	function Class_premorbd_row()
	{
		 this.pre_morbid_code="";
		 this.remarks="";
		 this.pre_morbid_desc="";
		 this.db_mode="";
		 this.recId ="";
	}

	function checkForDeletedRecords()
	{
	    var rows=parent.parent.parent.pre_anesthesia_objectcollect_frame.pre_morbid_rows;
		var formObj = document.forms[0];
		var code = formObj.pre_morbid_code.value;
		for(var i=0;i<rows.length;i++){
			if(rows[i]!=null){
				if( rows[i].pre_morbid_code==code && rows[i].db_mode=="D" )
				{
					rows[i].db_mode="L";
					return true
					break;
				}
			}else
				continue;
		}
		return false;	
			
	}

	function loadDBRows(pre_morbid_code,pre_morbid_desc,remarks,recId,mode)
	{ 
		  var objrow = newRow();
		  var rows=parent.parent.parent.pre_anesthesia_objectcollect_frame.pre_morbid_rows;
		  var rowLength=parent.parent.parent.pre_anesthesia_objectcollect_frame.pre_morbid_len;
		  if(mode=='L' && rowLength==0)
		  {
			  objrow.pre_morbid_code = pre_morbid_code;
			  objrow.pre_morbid_desc= pre_morbid_desc;
			  // Added by AnithaJ for 24816
			  objrow.remarks=decodeURIComponent(remarks,"UTF-8").replace(/\+/g," ");
			  //objrow.remarks=remarks;
			  objrow.db_mode="L";
			  objrow.recId=recId;
			  rows.push(objrow);
		
		  }
	}

	function newRow()
	{
		   var objrow = new Class_premorbd_row();
		   objrow.recId = parent.parent.parent.pre_anesthesia_objectcollect_frame.pre_morbid_rows.length+1;
		   return(objrow);
	}
	function assignRecId()
	{
		var rows = parent.parent.parent.pre_anesthesia_objectcollect_frame.pre_morbid_rows;
		parent.parent.parent.pre_anesthesia_objectcollect_frame.pre_morbid_len=rows.length;
	}
	function refresh()
	{
		var params = document.forms[0].params.value;
		parent.parent.parent.pre_anesth_tab_details_frame.frames[1].pre_morbid_detail_frame.location.href='../../eOT/jsp/AT_PreAnaesPreMorbidDetails.jsp?'+params;
	}

	function addRow()
	{
		var objrow = newRow();
		var formObj = document.pre_morbid_form;
		var params = formObj.params.value;
		var mode = formObj.mode.value;
		if(mode=='I'){
			 if(chkEmpty()){	
			  if(alreadyExist()){
				  var rows = parent.parent.parent.pre_anesthesia_objectcollect_frame.pre_morbid_rows;
				  objrow.pre_morbid_code=formObj.pre_morbid_code.value;
				  objrow.pre_morbid_desc=formObj.pre_morbid_desc.value;
				  objrow.remarks=formObj.remarks.value;
				  objrow.db_mode='I';
				  objrow.recId = getRecId();
				  if(checkForDeletedRecords()==false)
				  rows.push(objrow);
				  resetFields();
				 parent.frames[2].location.href='../../eOT/jsp/AT_PreAnaesPreMorbidDetails.jsp?'+params;
				 
				  parent.parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='
		   }else { 
					var msg = 'Record already Selected...';
					parent.parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+msg;
		   }
		}//mandatory_check
    }//if part of mode Check Ends Here
}

function chkEmpty(){
	var formObj = document.pre_morbid_form;
	var fields = new Array(formObj.pre_morbid_desc);
	var pre =getLabel("eOT.PreMorbidStatus.Label","OT") ;
	var names = new Array(pre);
	var messageFrame = parent.parent.parent.messageFrame;
	if(checkFields( fields, names, messageFrame))
		return true;
}
 function alreadyExist()
 {
	var formObj = document.pre_morbid_form;
	var codeDtl = parent.frames[2].code;
	var rows = parent.parent.parent.pre_anesthesia_objectcollect_frame.pre_morbid_rows;
	var pre_morbid_code=formObj.pre_morbid_code.value;
	var codeRecord = pre_morbid_code;
	if(codeDtl.indexOf(codeRecord)>=0)
	   return false;
	else
	  return true;
 }

	function getRecId()
	{
		var rowLength=parent.parent.parent.pre_anesthesia_objectcollect_frame.pre_morbid_len;
		var recId = rowLength+1;
		parent.parent.parent.pre_anesthesia_objectcollect_frame.pre_morbid_len  =  recId;
		return recId;
	}

function resetFields()
{
	var frmObj = document.pre_morbid_form;
	frmObj.mode.value='I';
	frmObj.pre_morbid_code.value='';
	frmObj.pre_morbid_desc.value='';
	frmObj.remarks.value='';
	frmObj.pre_morbid_desc.disabled=false;
	frmObj.remarks.disabled=false;
	frmObj.generic_search.disabled=false;
	frmObj.select_button.disabled=false;
}

function splitString(strVal)
{
	var arr = strVal.split('::');
	var frmObj = document.forms[0];
	frmObj.pre_morbid_code.value=arr[0];
	frmObj.pre_morbid_desc.value=arr[1];
//	frmObj.remarks.value=arr[2];
	frmObj.remarks.value=decodeURIComponent(arr[2],"UTF-8");
	frmObj.recId.value=arr[3]
	frmObj.mode.value=arr[4];
	frmObj.pre_morbid_desc.disabled=true;
	frmObj.remarks.disabled=true;
	frmObj.generic_search.disabled=true;
	frmObj.select_button.disabled=true;		
}

function SpecialCharRestriction(event){
	var strCheck = "\"`'&<>";
	var whichCode = (window.Event) ? event.which : event.keyCode;
	key = String.fromCharCode(whichCode);  // Get key value from key code
	if (strCheck.indexOf(key) != -1) return false;  // Not a valid key
	return true ;
}

function removeRow(){
 var formObj = document.pre_morbid_form;
 var mode = formObj.mode.value;
 var recId = formObj.recId.value;
 var params = formObj.params.value;
 var rows = parent.parent.parent.pre_anesthesia_objectcollect_frame.pre_morbid_rows;

 if(rows.length>0&& mode=='U'){        
 for(var jj=0;jj<rows.length;jj++){
 if(rows[jj]!=null  && rows[jj].recId!=null && rows[jj].recId!="") {
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
   parent.parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='
  
   parent.frames[2].location.href='../../eOT/jsp/AT_PreAnaesPreMorbidDetails.jsp?'+params;
 }else
   resetFields();
}
	</script>
</head>
<%
	String params		= request.getQueryString() ;
	String facility_id	=request.getParameter("facility_id");
	String anesthesia_srl_no	=request.getParameter("anesthesia_srl_no");
	String preop_asse_done_yn	=request.getParameter("preop_asse_done_yn");
	String disable_flag="";
	if(preop_asse_done_yn.equalsIgnoreCase("Y"))
	disable_flag="disabled";
	else if(preop_asse_done_yn.equalsIgnoreCase("N") || preop_asse_done_yn.equalsIgnoreCase(""))
	disable_flag="";
	String refresh_flag="1";
%>
<body onLoad="" OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()' >
<form name="pre_morbid_form" id="pre_morbid_form" >
<input type = "hidden"  name='params' id='params'  value="<%=params%>" > 
<%

	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String remarks="";
	try{
		String sql_premorbid_status="SELECT A.PREMORBID_CODE, B.LONG_DESC,A.REMARKS  FROM  AT_RECORD_PREOP_PREMORBID A, AT_PREMORBID_MAST B WHERE A.OPERATING_FACILITY_ID =? AND A.ANAESTHESIA_SERIAL_NUM =? AND	 A.PREMORBID_CODE = B.PREMORBID_CODE";
		con = ConnectionManager.getConnection(request);
		pstmt = con.prepareStatement(sql_premorbid_status);
		pstmt.setString(1,facility_id);
		pstmt.setString(2,anesthesia_srl_no);
		rs = pstmt.executeQuery();
		int index = 0;
		while(rs.next()){
			index++;
			remarks=rs.getString("REMARKS");
			//remarks=java.net.URLEncoder.encode(remarks,"UTF-8");
			if(remarks==null)remarks="";
			//Added by AnithaJ for 24816
			out.println("<script>loadDBRows(\""+rs.getString("PREMORBID_CODE")+"\",\""+rs.getString("LONG_DESC")+"\",\""+java.net.URLEncoder.encode(remarks,"UTF-8")+"\",\""+index+"\",\"L\"); </script>");	

		}
		out.println("<script>assignRecId()</script>");
		out.println("<script>refresh()</script>");
	}catch(Exception e){
		 System.err.println("Err Msg in Personnel Records"+e.getMessage());
	}finally{
		try{
			if(rs!=null)rs.close();
			if(pstmt!=null)pstmt.close();
			if(con!=null)
			ConnectionManager.returnConnection(con,request);
		}catch(Exception e){}
	}
%>
<table cellpadding=3  cellspacing="0" width="100%" align="center" border="0">
	<tr>
		<td align="right" class="label">
		<fmt:message key="eOT.PreMorbidStatus.Label" bundle="${ot_labels}"/>
		</td>
		<td align="left" class="fields">
			<input type="hidden" name="pre_morbid_code" id="pre_morbid_code" value="">
			<input type="text"  name="pre_morbid_desc" id="pre_morbid_desc" size='30' value="" onkeypress="return checkForSpecCharsforID(event);" onblur="if(this.value!='')callPreMorbidValues(pre_morbid_code,pre_morbid_desc);else pre_morbid_code.value=''" <%=disable_flag %>>
			<input type="button" class="button" name="generic_search" id="generic_search" value="?" onclick="callPreMorbidValues(pre_morbid_code,pre_morbid_desc);" <%=disable_flag %> >
		</td>
	
	<td class='label' align='right'>
	<fmt:message key="Common.remarks.label" bundle="${common_labels}"/>
	</td>
	<td align='left'>
		<textarea rows='3' cols='30' name='remarks'  Onblur="makeValidString(this);" onkeypress="return checkForSpecCharsforID(event);" onChange='checkLimit(this,500)' <%=disable_flag %> ></textarea>
	</td>
	</tr>
	<tr>
		<td align="right" class="label"></td>
		<td align="right" class="label"></td>
		<td align="right" class="label"></td>
		<td align="right" class='label' >
			<input type='button' name='select_button' id='select_button' class='button' value='<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>' onClick='addRow();' <%=disable_flag %>>
			<input type='button' name='cancel_button' id='cancel_button' class='button' value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' onClick='removeRow();'  <%=disable_flag %> >
		</td>
	</tr>
</table>
				<%
					if(!imgUrl.equals("")){ %>
					 <img src='<%=imgUrl%>' width='100%' height='15'/> 
				<%}%>
	<!-- end -->
<input type='hidden' name='params' id='params' value='<%=params%>' >
<input type='hidden' name='facility_id' id='facility_id' value='<%=facility_id%>' >
<input type='hidden' name='anesthesia_srl_no' id='anesthesia_srl_no' value='<%=anesthesia_srl_no%>' >
<input type='hidden' name='recId' id='recId' value=''>
<input type='hidden' name='mode' id='mode' value='I'>
<input type='hidden' name='refresh_flag' id='refresh_flag' value='<%=refresh_flag%>'>
</form>
</body>
</html>

