<!DOCTYPE html>

<%-- JSP Page specific attributes start --%>              
<%@page  import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,eCommon.XSSRequestWrapper,webbeans.eCommon.ConnectionManager"%>
<%-- JSP Page specific attributes end --%>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@page  contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8");
   //Added Against MMS Vulnerability Issue - Starts
   request= new XSSRequestWrapper(request);
   response.addHeader("X-XSS-Protection", "1; mode=block");
   response.addHeader("X-Content-Type-Options", "nosniff");
   //Added Against MMS Vulnerability Issue - Ends
%>
<% String locale = (String) session.getAttribute("LOCALE");	%>
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
	<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script> 
	<script language="JavaScript" src="../../eOT/js/AT_RecordIntraAnesthesia.js"></script>
	<script language="JavaScript" src="../../eOT/js/AT_RecordAnesthesiaDetails.js"></script>
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eOT/js/Booking.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<script>
	function Class_Personnel()
	{
		
		 this.pract_type="";
		 this.desc_userdef="";
		 this.practitioner_id="";
		 this.practitioner_name="";
		 this.db_mode="";
		 this.position_desc="";
		 this.recId ="";
	}

	function checkForDeletedRecords(){
	    var rows=parent.parent.parent.Intra_anesthesia_objectcollect_frame.personnel_rows;
		var formObj = document.forms[0];
		var code = formObj.practitioner_id.value;
		for(var i=0;i<rows.length;i++){
			if(rows[i]!=null){
				if((rows[i].practitioner_id)==code && rows[i].db_mode=="D" )
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
	
	function loadDBRows(pract_type,desc_userdef,practitioner_id,practitioner_name,recId,mode,locale,order)
	{ 
		  var objrow = newRow();
		  var rows=parent.parent.parent.Intra_anesthesia_objectcollect_frame.personnel_rows;
		  var rowLength=parent.parent.parent.Intra_anesthesia_objectcollect_frame.personnel_len;

		  if(mode=='L' && rowLength==0)
		  {
			  objrow.pract_type = pract_type;
			  objrow.desc_userdef= desc_userdef;
			  objrow.practitioner_id = practitioner_id;
			  objrow.practitioner_name= practitioner_name;
			  objrow.db_mode=(order==1)?"L":"I";
			  //alert("DB_MODE"+objrow.db_mode);
			  objrow.recId=recId;
			  objrow.position_desc=getPositionDesc(practitioner_id,locale);
			  rows.push(objrow);
		
		  }
	}
	
	function newRow()
	{
		   var objrow = new Class_Personnel();
		   objrow.recId = parent.parent.parent.Intra_anesthesia_objectcollect_frame.personnel_rows.length+1;
		   return(objrow);
	}
	function assignRecId()
	{
		var rows = parent.parent.parent.Intra_anesthesia_objectcollect_frame.personnel_rows;
		parent.parent.parent.Intra_anesthesia_objectcollect_frame.personnel_len=rows.length;
	}
	function refresh()
	{
		var params = document.forms[0].params.value;
		parent.parent.parent.intra_anesth_tab_details_frame.personal_details_frame.location.href='../../eOT/jsp/AT_IntraAnaesPersonalDetails.jsp?'+params;
		
	}

	function addRow()
	{
		var objrow = newRow();
		var formObj = document.personnel_form;
		var params = formObj.params.value;
		var mode = formObj.mode.value;
		var locale = document.forms[0].locale.value;
		if(mode=='I'){
			 if(chkEmpty()){
			 if(alreadyExist()){
				  var obj = formObj.pract_type;
				  var rows = parent.parent.parent.Intra_anesthesia_objectcollect_frame.personnel_rows;
				  objrow.pract_type=formObj.pract_type.value;
				  objrow.desc_userdef=formObj.pract_type.options[obj.selectedIndex].text;
				//  objrow.desc_userdef=formObj.desc_userdef.value;
				  objrow.practitioner_id=formObj.practitioner_id.value;
				  objrow.practitioner_name=formObj.practitioner_name.value;

				  objrow.db_mode='I';
				  objrow.recId = getRecId();
				  objrow.position_desc=getPositionDesc(formObj.practitioner_id.value,locale);
				  if(checkForDeletedRecords()==false)
				  rows.push(objrow);
				  resetFields();
				 parent.parent.parent.intra_anesth_tab_details_frame.personal_details_frame.location.href='../../eOT/jsp/AT_IntraAnaesPersonalDetails.jsp?'+params;
				 
				  parent.parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='
		   }else { 
					//commented below line by Anitha
					//var msg =getLabel("CODE_ALREADY_EXISTS","Common");
					var msg =getMessage("CODE_ALREADY_EXISTS","Common");
					parent.parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+msg;
		   }
		}//mandatory_check
    }//if part of mode Check Ends Here
}


function chkEmpty(){
	var formObj = document.personnel_form;
	var fields = new Array(formObj.pract_type,formObj.practitioner_name);

	var practitionerType =getLabel("Common.practitionertype.label","Common");
	var practitionerName =getLabel("Common.practitionername.label","Common");
	var names = new Array(practitionerType ,practitionerName);
	var messageFrame = parent.parent.parent.messageFrame;
	if(checkFields( fields, names, messageFrame))
		return true;
}
 function alreadyExist()
 {
	var formObj = document.personnel_form;
	var codeDtl = parent.frames[1].code;
	var rows = parent.parent.parent.Intra_anesthesia_objectcollect_frame.personnel_rows;
	var practitioner_id=formObj.practitioner_id.value;
	var codeRecord = practitioner_id;

	if(codeDtl.indexOf(codeRecord)>=0)
	   return false;
	else
	  return true;
 }

	function getRecId()
	{
		var rowLength= parent.parent.parent.Intra_anesthesia_objectcollect_frame.personnel_len;
		var recId = rowLength+1;
		 parent.parent.parent.Intra_anesthesia_objectcollect_frame.personnel_len =  recId;
		return recId;
	}

function resetFields()
{
	var frmObj = document.personnel_form;
	frmObj.mode.value='I';
	frmObj.pract_type.value='';
	frmObj.desc_userdef.value='';
	frmObj.practitioner_id.value='';
	frmObj.practitioner_name.value='';

	frmObj.practitioner_name.disabled=false;
	frmObj.pract_type.disabled=false;
	frmObj.generic_search.disabled=false;
	frmObj.select_button.disabled=false;

}

function splitString(strVal)
{
	var arr = strVal.split('::');
	var frmObj = document.forms[0];
	frmObj.pract_type.value=arr[0];
	frmObj.desc_userdef.value=arr[1];
	frmObj.practitioner_id.value=arr[2];
	frmObj.practitioner_name.value=arr[3];
	frmObj.recId.value=arr[4]
	frmObj.mode.value=arr[5];
	frmObj.practitioner_name.disabled=true;
	frmObj.pract_type.disabled=true;
	frmObj.generic_search.disabled=true;
	frmObj.select_button.disabled=true;
}

function removeRow(){
 var formObj = document.personnel_form;
 var mode = formObj.mode.value;
 var recId = formObj.recId.value;
 var params = formObj.params.value;
 var rows = parent.parent.parent.Intra_anesthesia_objectcollect_frame.personnel_rows;
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
  
parent.parent.parent.intra_anesth_tab_details_frame.personal_details_frame.location.href='../../eOT/jsp/AT_IntraAnaesPersonalDetails.jsp?'+params;
}else
   resetFields();
}

function clearPractitioner()
{
	document.forms[0].practitioner_id.value="";
	document.forms[0].practitioner_name.value="";

}

	</script>
</head>
<%
	String params		= request.getQueryString() ;
	String facility_id	= request.getParameter("facility_id");
	String anaesthesia_srl_no	= request.getParameter("anesthesia_srl_no");
	String intraop_done_yn	= request.getParameter("intraop_done_yn");
	String accession_num	= request.getParameter("accession_num");
	String disable_flag="";
	if(intraop_done_yn.equalsIgnoreCase("Y"))
		disable_flag="disabled";
	else if(intraop_done_yn.equalsIgnoreCase("N") || 	intraop_done_yn.equalsIgnoreCase(""))
	
	disable_flag="";
	String refresh_flag="1";
String trace="0";
%>
<body onLoad="" OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form name="personnel_form" id="personnel_form" >
<input type = "hidden"  name='params' id='params'  value="<%=params%>" > 
<%

	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	ResultSet rs1=null;

	trace = "1";
	//Added ORDER BY B.ROLE_DESC in below query for IN024272 on 10/6/2010 by AnithaJ
	String sql_pra="SELECT B.ROLE_TYPE, B.ROLE_DESC,A.PRACTITIONER_ID,C.PRACTITIONER_NAME,A.ROLE_ID FROM  AT_PERSONNEL A, OT_ROLES_LANG_VW B, AM_PRACTITIONER_LANG_VW C WHERE C.LANGUAGE_ID='"+locale+"' AND B.LANGUAGE_ID='"+locale+"' AND A.OPERATING_FACILITY_ID =? AND A.ANAESTHESIA_SERIAL_NUM =? AND	 A.PRACT_TYPE = B.ROLE_TYPE AND A.PRACTITIONER_ID = C.PRACTITIONER_ID AND A.ROLE_ID=B.ROLE_ID ORDER BY B.ROLE_DESC";
	String sql_ot =	"SELECT  A.ROLE_TYPE PRACT_TYPE, A.PRACTITIONER_ID, B.PRACTITIONER_NAME, ROLE_ID, GET_DESC('"+locale+"','OT_ROLES_LANG_VW','ROLE_DESC','ROLE_ID',ROLE_ID) ROLE_DESC FROM OT_POST_OPER_PERSONNEL A, AM_PRACTITIONER_LANG_VW B WHERE  OPERATING_FACILITY_ID = ? AND B.LANGUAGE_ID=? AND OPER_NUM = ? AND A.PRACTITIONER_ID = B.PRACTITIONER_ID AND B.PRACTITIONER_ID NOT IN (SELECT PRACTITIONER_ID FROM AT_PERSONNEL WHERE OPERATING_FACILITY_ID= ? AND ANAESTHESIA_SERIAL_NUM = ? )";
	try{
	trace = "2";
		con = ConnectionManager.getConnection(request);
		pstmt = con.prepareStatement(sql_pra);
		pstmt.setString(1,facility_id);
		pstmt.setString(2,anaesthesia_srl_no);
		rs = pstmt.executeQuery();
		int index = 0;
	trace = "3";
		while(rs.next()){
			index++;
		out.println("<script>loadDBRows('"+rs.getString("ROLE_TYPE")+"##"+rs.getString("ROLE_ID")+"','"+rs.getString("ROLE_DESC")+"','"+rs.getString("PRACTITIONER_ID")+"','"+rs.getString("PRACTITIONER_NAME")+"','"+index+"','L','"+locale+"','1'); </script>");	
		}
		if(rs!=null)rs.close();
		if(pstmt!=null)pstmt.close();

		if(index==0){
			    
				trace = "4";
				pstmt = con.prepareStatement(sql_ot);
				pstmt.setString(1,facility_id);
				pstmt.setString(2,locale);		    
				pstmt.setString(3,accession_num);
				pstmt.setString(4,facility_id);				
				pstmt.setString(5,anaesthesia_srl_no);				
				rs = pstmt.executeQuery();
				while(rs.next()){
					index++;
					trace = "4.1";	out.println("<script>loadDBRows('"+rs.getString("PRACT_TYPE")+"##"+rs.getString("ROLE_ID")+"','"+rs.getString("ROLE_DESC")+"','"+rs.getString("PRACTITIONER_ID")+"','"+rs.getString("PRACTITIONER_NAME")+"','"+index+"','L','"+locale+"','2'); </script>");	
				trace = "4.2";				
			}
			trace = "5";
		}
		trace = "6";
		out.println("<script>assignRecId()</script>");
		out.println("<script>refresh()</script>");

%>
<table cellpadding=3  cellspacing="0" width="100%" align="center" border="0">

	<tr>
		<td align="right" class="label" width='25%'>
			<fmt:message key="Common.Role.label" bundle="${common_labels}"/>
		</td>
		<td  align="left" width='25%' >
		
		<select name='pract_type' id='pract_type' OnChange='clearPractitioner();' <%=disable_flag%> >
		<option value=''>
		<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>
		</option>
	<%

		if(rs!=null)rs.close();
		if(pstmt!=null)pstmt.close();

		String pract_sql="SELECT ROLE_DESC, ROLE_TYPE ,ROLE_ID FROM OT_ROLES_LANG_VW WHERE  LANGUAGE_ID=? AND APPL_TO_OT_SLATE='N' AND NVL(STATUS,'E') = 'E'";
		pstmt=con.prepareStatement(pract_sql);
		pstmt.setString(1,locale);
		rs1=pstmt.executeQuery();
		while(rs1!=null && rs1.next())
		{
		%>
		<option value='<%=rs1.getString("ROLE_TYPE")+"##"+rs1.getString("ROLE_ID")%>'><%=rs1.getString("ROLE_DESC")%></option>
		<%
		}
		if(rs1!=null)rs1.close();
		if(pstmt!=null)pstmt.close();
	}catch(Exception e){
		 System.err.println("Err Msg in Personnel Records"+e.getMessage());
	}finally{
		try{
			if(rs!=null)rs.close();
			if(rs1!=null)rs1.close();
			if(pstmt!=null)pstmt.close();
		    ConnectionManager.returnConnection(con,request);
		}catch(Exception e){}
	}
		
	%>
		</select>
		<img src='../../eCommon/images/mandatory.gif'></img>
		</td>
	
		<td align="right" class="label" width='25%'>
		<fmt:message key="Common.name.label" bundle="${common_labels}"/>
		</td>
		<td align="left" class="label" width='25%'>
			<input type="text"  name="practitioner_name" id="practitioner_name" size='15' value="" onblur="if(this.value!='')callPractitioners(this); else practitioner_id.value='';" <%=disable_flag%>>
			<input type="hidden" name="practitioner_id" id="practitioner_id" value="">
			<input type="button" class="button" name="generic_search" id="generic_search" value="?" onclick="callPractitioners(practitioner_name);" <%=disable_flag%> >
			<img src='../../eCommon/images/mandatory.gif'></img>
		</td>
		
	</tr>
	<tr>
		<td align="left" class="label"></td>
			<td align="left" class="label"></td>
				<td align="left" class="label"></td>
		<td align="right" class='label' >
			<input type='button' name='select_button' id='select_button'class='button' value='<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>' onClick='addRow();' <%=disable_flag%> >
			<input type='button' name='cancel_button' id='cancel_button' class='button' value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' onClick='removeRow();' <%=disable_flag%> >
		</td>
	</tr>
</table>
   <!-- added by Rajesh for Amazon Changes-->
				<%if(!imgUrl.equals("")){ %>
					 <img src='<%=imgUrl%>' width='100%' height='15'/> 
				<%}%>
	<!-- end -->

<input type='hidden' name='params' id='params' value='<%=params%>' >
<input type='hidden' name='facility_id' id='facility_id' value='<%=facility_id%>' >
<input type='hidden' name='anesthesia_srl_no' id='anesthesia_srl_no' value='<%=anaesthesia_srl_no%>' >
<input type='hidden' name='recId' id='recId' value=''>
<input type='hidden' name='mode' id='mode' value='I'>
<input type='hidden' name='refresh_flag' id='refresh_flag' value='<%=refresh_flag%>'>
<input type='hidden' name='desc_userdef' id='desc_userdef' >
<input type='hidden' name='locale' id='locale' value='<%=locale%>'>
 </form>
</body>
</html>




