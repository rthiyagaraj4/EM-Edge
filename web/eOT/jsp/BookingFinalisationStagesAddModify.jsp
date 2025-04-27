<!DOCTYPE html>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper,eCommon.Common.*"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
 String locale = ((String)session.getAttribute("LOCALE"));	
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src="../../eCommon/js/CommonLookup.js" language="javascript"></script>
<script language='javascript' src='../../eOT/js/BookingFinalisationStages.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<script>
function ChkApplcationposition(obj){
	var hidden_frame=window.parent.frames[1];
	var rows=hidden_frame.rows;
	var RecordFrame=window.parent.frames[3];
	var RecordFrame_formObj=RecordFrame.document.forms[0]; 
	var message="Cancel All the users and then change to All Users";
    // alert(RecordFrame_formObj.name);
	var formObj=document.forms[0];
	var mode=formObj.mode.value;
	var count=0;
	if(mode=="insert"){
	if(rows.length==0){
		  if(obj.value=="*ALL"){
			formObj.position_desc.disabled=true;
			formObj.position_desc.value='';
			formObj.position_code.disabled=true;
			formObj.position_code.value='';
			formObj.generic_search.disabled=true;
			RecordFrame_formObj.user_id.disabled=true;
			RecordFrame_formObj.user_name.disabled=true;
			RecordFrame_formObj.generic_search.disabled=true;
			RecordFrame_formObj.select.disabled=true;
			RecordFrame_formObj.cancel.disabled=true;
		   }else if(obj.value=="SPC"){
			formObj.position_desc.disabled=false;
			formObj.position_code.disabled=false;
			formObj.generic_search.disabled=false;
			RecordFrame_formObj.user_id.disabled=false;
			RecordFrame_formObj.user_name.disabled=false;
			RecordFrame_formObj.generic_search.disabled=false;
			RecordFrame_formObj.select.disabled=false;
			RecordFrame_formObj.cancel.disabled=false;
		   }
	}else if(rows.length!=0){		
			if(obj.value=="SPC"){
			//alert("at 26");
			//alert("rows[i].mode=="+rows[i].mode);
			formObj.position_desc.disabled=false;
			formObj.position_code.disabled=false;
			formObj.generic_search.disabled=false;
			RecordFrame_formObj.user_id.disabled=false;
			RecordFrame_formObj.user_name.disabled=false;
			RecordFrame_formObj.generic_search.disabled=false;
			RecordFrame_formObj.select.disabled=false;
			RecordFrame_formObj.cancel.disabled=false;
			}else if(obj.value=="*ALL"){
				 rows.length=0;
			for (vari=0;i<rows.length ;i++ )
			{
				count++;
			}
			refresh();
			//alert("count=="+count+", rows.length=="+rows.length);
			formObj.position_desc.disabled=true;
			formObj.position_desc.value='';
			formObj.position_code.disabled=true;
			formObj.position_code.value='';
			formObj.generic_search.disabled=true;
			RecordFrame_formObj.user_id.disabled=true;
			RecordFrame_formObj.user_name.disabled=true;
			RecordFrame_formObj.generic_search.disabled=true;
			RecordFrame_formObj.select.disabled=true;
			RecordFrame_formObj.cancel.disabled=true;
	   }
	}
	
	}else if (mode=="modify"){
	if(obj.value=="*ALL"){
		if(rows.length==0){
		formObj.position_desc.disabled=true;
		formObj.position_desc.value='';
        formObj.position_code.disabled=true;
        formObj.position_code.value='';
		formObj.generic_search.disabled=true;
        RecordFrame_formObj.user_id.disabled=true;
        RecordFrame_formObj.user_name.disabled=true;
		RecordFrame_formObj.generic_search.disabled=true;
		RecordFrame_formObj.select.disabled=true;
		RecordFrame_formObj.cancel.disabled=true;
		}else{
		for (var i=0;i<rows.length;i++){
		//alert("mode=="+rows[i].mode);
        if(rows[i].mode!='L'){
		formObj.position_desc.disabled=true;
		formObj.position_desc.value='';
        formObj.position_code.disabled=true;
        formObj.position_code.value='';
		formObj.generic_search.disabled=true;
        RecordFrame_formObj.user_id.disabled=true;
        RecordFrame_formObj.user_name.disabled=true;
		RecordFrame_formObj.generic_search.disabled=true;
		RecordFrame_formObj.select.disabled=true;
		RecordFrame_formObj.cancel.disabled=true;

		}
	    else{
		formObj.position_desc.disabled=false;
        formObj.position_code.disabled=false;
		formObj.generic_search.disabled=false;
        RecordFrame_formObj.user_id.disabled=false;
        RecordFrame_formObj.user_name.disabled=false;
		RecordFrame_formObj.generic_search.disabled=false;
		RecordFrame_formObj.select.disabled=false;
		RecordFrame_formObj.cancel.disabled=false;
		obj.value="SPC";
		parent.parent.frames[2].location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+message;
	}
   }
  }
	}else if(obj.value=="SPC"){
	    formObj.position_desc.disabled=false;
        formObj.position_code.disabled=false;
		formObj.generic_search.disabled=false;
        RecordFrame_formObj.user_id.disabled=false;
        RecordFrame_formObj.user_name.disabled=false;
		RecordFrame_formObj.generic_search.disabled=false;
		RecordFrame_formObj.select.disabled=false;
		RecordFrame_formObj.cancel.disabled=false;
	}
  }
}
</script>
</head>
<!-- onload="parent.parent.commontoolbarFrame.document.forms[0].apply.disabled=false;parent.parent.commontoolbarFrame.document.forms[0].reset.disabled=false;" OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'-->
<body onload="parent.parent.commontoolbarFrame.document.forms[0].reset.disabled=false;" OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'> <!--Modified Against GHL-SCF-1519-->
<%
Connection con=null;
Connection con1=null;
PreparedStatement stmt=null;
PreparedStatement stmt1=null;
ResultSet rs=null;
ResultSet rs1=null;
String mode=request.getParameter("update_mode_yn");
String chk_checked="checked";
String chk_value="Y";
String facility_id=(String) session.getAttribute("facility_id");
String stage_code = request.getParameter("stage_code")==null?"":request.getParameter("stage_code");
if(stage_code.equals("null") || stage_code=="null")
{
	stage_code="";
}
String pre_stage_desc="";
String post_stage_desc="";
String serial_no="";
String position_code="";
String specific_ind="";
String action_if_not_done="";
String pac_stage_yn="";
String color_ind="";
String text_color="";
String disable_flag="";
String stage_code_disable="";
String position_desc="";
String sql="";
String sql1="";
String status="";
String temp="";
StringBuffer stage_code1=new StringBuffer();
StringBuffer serial_no1=new StringBuffer();
StringBuffer color_ind1=new StringBuffer();

if(mode.equals("modify"))
{
	try{
		con=ConnectionManager.getConnection(request);
		//sql="SELECT A.STAGE_CODE, A.PRE_STAGE_DESC, A.POST_STAGE_DESC, A.SERIAL_NO, A.POSITION_CODE,  A.SPECIFIC_IND, A.ACTION_IF_NOT_DONE, A.PAC_STAGE_YN, A.COLOR_IND, A.TEXT_COLOR , B.POSITION_DESC FROM OT_BOOKING_FIN_STAGES A, AM_POSITION B WHERE A.STAGE_CODE=? AND A.POSITION_CODE=B.POSITION_CODE(+)  ";


		sql="SELECT A.STAGE_CODE, A.PRE_STAGE_DESC, A.POST_STAGE_DESC, A.SERIAL_NO, A.POSITION_CODE,  A.SPECIFIC_IND, A.ACTION_IF_NOT_DONE, A.PAC_STAGE_YN, A.COLOR_IND, A.TEXT_COLOR , GET_DESC(?,'AM_POSITION_LANG_VW','POSITION_DESC','POSITION_CODE',A.POSITION_CODE) POSITION_DESC FROM OT_BOOKING_FIN_STAGES_LANG_VW A, AM_POSITION B WHERE A.LANGUAGE_ID = ? AND A.STAGE_CODE=? AND A.POSITION_CODE=B.POSITION_CODE(+)";

		stmt=con.prepareStatement(sql);
		stmt.setString(1,locale);
		stmt.setString(2,locale);
		stmt.setString(3,stage_code);
		rs=stmt.executeQuery();
        		
		if(rs!=null && rs.next())
		{
			
			//stage_code=rs.getString(1);
			pre_stage_desc=rs.getString(2);
			post_stage_desc=rs.getString(3);
			serial_no=rs.getString(4);
			position_code=rs.getString(5);
			specific_ind=rs.getString(6);
			action_if_not_done=rs.getString(7);
			pac_stage_yn=rs.getString(8);
            color_ind=rs.getString(9);
			text_color=rs.getString(10);
			position_desc=rs.getString(11);
						
		}
		sql1="SELECT STAGE_CODE,SERIAL_NO, COLOR_IND FROM OT_BOOKING_FIN_STAGES";
		con1=ConnectionManager.getConnection(request);
		stmt1=con1.prepareStatement(sql1);
		rs1=stmt1.executeQuery();
        while(rs1!=null && rs1.next()){
			stage_code1=stage_code1.append(",").append(rs1.getString(1));
			serial_no1=serial_no1.append(",").append(rs1.getString(2));
			color_ind1=color_ind1.append(",").append(rs1.getString(3));
		}

		if(pac_stage_yn.equals("Y"))
		{
			chk_checked="checked";
			
			
		}
		else
		{
			chk_checked="";
			
			chk_value="N";
		}
		if(position_code==null || position_code.equals("null") || position_code.equals(""))
			position_code="";
		if(position_desc==null || position_desc.equals("null") || position_desc.equals(""))
			position_desc="";
		stage_code_disable="disabled";	
		//Testing purpose

}catch(Exception e)
	{
		e.printStackTrace();
		//out.println("Exception is "+e);
		}
		finally{
			try{
			if(stmt!=null) stmt.close();
			if(stmt1!=null) stmt1.close();
			if(rs!=null)rs.close();
			if(rs1!=null)rs1.close();
			ConnectionManager.returnConnection(con);
			ConnectionManager.returnConnection(con1);
		}catch(Exception e)
			{
				e.printStackTrace();
				//out.println("Exception is "+e);
			}
		
		}
}else if(mode.equals("insert")){
	try{
		con=ConnectionManager.getConnection(request);
		sql="SELECT STAGE_CODE,SERIAL_NO, COLOR_IND FROM OT_BOOKING_FIN_STAGES";
		stmt=con.prepareStatement(sql);
		rs=stmt.executeQuery();
        while(rs!=null && rs.next()){
			stage_code1=stage_code1.append(",").append(rs.getString(1));
			serial_no1=serial_no1.append(",").append(rs.getString(2));
			color_ind1=color_ind1.append(",").append(rs.getString(3));
		}
	}catch(Exception e){
		e.printStackTrace();
		//out.println("Exception is "+e);
	}finally{
		try{
			if(stmt!=null) stmt.close();
			if(rs!=null)rs.close();
			ConnectionManager.returnConnection(con);
		}catch(Exception e){
			e.printStackTrace();
			//out.println("Exception is "+e);
		}
		
	}
 }
%>
<form name="BookingFinalisationStagesHdr" id="BookingFinalisationStagesHdr"  onload='FocusFirstElement()'  action="" method="" target="messageFrame"> 
<table border=0 cellspacing=0 cellpadding=3 width='100%'  align=center>
<tr>
	<td width='35%'></td>
	<td width='65%'></td>
</tr>
<!--Commented by lakshmi against IN-33128
<% if (mode.equals("insert")){%>
<tr>
	<td class=label width='25%'><fmt:message key="Common.StageCode.label" bundle="${common_labels}"/></td>
	<td width='25%' class="fields"><input type="text" name="stage_code" id="stage_code" value="<%=stage_code%>"   size=2  maxlength=2   onkeypress="return CheckForSpecChars(event)"  onBlur="ChangeUpperCase(this)">
	<img src='../../eCommon/images/mandatory.gif'></td>
</tr>
<%}else if(mode.equals("modify")){%>
<tr>
	<td class=label width='25%'><fmt:message key="Common.StageCode.label" bundle="${common_labels}"/></td>
	<td width='25%' class="fields"><input type="text" name="stage_code" id="stage_code" value="<%=stage_code%>"   size=2  maxlength=2   onkeypress="return CheckForSpecChars(event)" disabled>
	<img src='../../eCommon/images/mandatory.gif'></td>
</tr>
<%}%>-->

<!--Modified by lakshmi against IN-33128-->
<% if (mode.equals("insert")){%>
<tr>
	<td class=label width='25%'><fmt:message key="Common.StageCode.label" bundle="${common_labels}"/></td>
	<td width='25%' class="fields"><input type="text" name="stage_code" id="stage_code" value="<%=stage_code%>"   size=2  maxlength=2   onkeypress="return CheckForSpecChars(event)" >
	<img src='../../eCommon/images/mandatory.gif'></td>
</tr>
<%}else if(mode.equals("modify")){%>
<tr>
	<td class=label width='25%'><fmt:message key="Common.StageCode.label" bundle="${common_labels}"/></td>
	<td width='25%' class="fields"><input type="text" name="stage_code" id="stage_code" value="<%=stage_code%>"   size=2  maxlength=2   onkeypress="return CheckForSpecChars(event)" onBlur="CheckNum(this)" disabled>
	<img src='../../eCommon/images/mandatory.gif'></td>
</tr>
<%}%>
<tr>
	<td class=label width='25%'><fmt:message key="eOT.PreStageDescription.Label" bundle="${ot_labels}"/></td>
	<td width='25%' class="fields"><input type="text" name="pre_stage_description" id="pre_stage_description" value="<%=pre_stage_desc%>"  size=30 maxlength=30 >
	<img src='../../eCommon/images/mandatory.gif'></td>
</tr>
<tr>
	<td class=label width='25%'><fmt:message key="eOT.PostStageDescription.Label" bundle="${ot_labels}"/></td>
	<td width='25%' class="fields"><input type="text" name="post_stage_description" id="post_stage_description" value="<%=post_stage_desc%>"  size=30 maxlength=30 >
	<img src='../../eCommon/images/mandatory.gif'></td>
</tr>
<% if (mode.equals("insert")){%>
<tr>
	<td class=label width='25%'>
		<fmt:message key="Common.SerialNo.label" bundle="${common_labels}"/>
	</td>
	<td class='fields' width='25%'><input type="text" name="srl_no" id="srl_no"  value=""  size=3 maxlength=3 onblur="ChkNumber(this);">
	<img src='../../eCommon/images/mandatory.gif'>
	</td>
</tr>
<tr>
	<td class="label" width='25%'>
		<fmt:message key="Common.Color.label" bundle="${common_labels}"/>
	</td>	
	<td class="fields" width='25%'>
		<select name="color_ind" id="color_ind">
			<option value='BROWN'><fmt:message key="eOT.Brown.Label" bundle="${ot_labels}"/></option>
			<option value='YELLOW'><fmt:message key="Common.Yellow.label" bundle="${common_labels}"/></option>
			<option value='GREEN'><fmt:message key="Common.Green.label" bundle="${common_labels}"/></option>
			<option value='BLUE'><fmt:message key="eOT.Blue.Label" bundle="${ot_labels}"/></option>
			<option value='RED'><fmt:message key="Common.Red.label" bundle="${common_labels}"/></option>
			<option value='DARK BLUE'><fmt:message key="eOT.DarkBlue.Label" bundle="${ot_labels}"/></option>
			<option value='MAGENTA'><fmt:message key="eOT.Magenta.Label" bundle="${ot_labels}"/></option>
			<option value='PINK'><fmt:message key="eOT.Pink.Label" bundle="${ot_labels}"/></option>
			<option value='CYAN'><fmt:message key="eOT.Cyan.Label" bundle="${ot_labels}"/></option>
			<option value='GRAY' selected><fmt:message key="eOT.Gray.Label" bundle="${ot_labels}"/></option>
		</select><img src='../../eCommon/images/mandatory.gif'>
	</td>
</tr>
<tr>
	<td class="label" width='25%'>
		<fmt:message key="eOT.TextColor.Label" bundle="${ot_labels}"/>
	</td>	
	<td class="fields" width='25%'>
		<select name="text_color" id="text_color">
		 <option value='BLACK'><fmt:message key="eOT.Black.Label" bundle="${ot_labels}"/></option>
		<option value='WHITE'><fmt:message key="eOT.White.Label" bundle="${ot_labels}"/></option>
		<select>
	</td>
</tr>
<!--onblur="chkDuplicate_SrlNo(this);"-->
<tr>
    <td class=label width='25%'><fmt:message key="eOT.SpecificIndicator.Label" bundle="${ot_labels}"/></td>
	<td width='25%' class="fields"><select name="specific_indicator" id="specific_indicator" onChange="ChkApplcationposition(this);">
	<option value="*ALL"><fmt:message key="eOT.AllUsers.Label" bundle="${ot_labels}"/></option>
	<option value="SPC" selected><fmt:message key="eOT.SpecificUsers.Label" bundle="${ot_labels}"/></option>
	</select>
	</td>
</tr>
<tr>
	<td class=label width='25%'>
	<fmt:message key="eOT.ApplicablePosition.Label" bundle="${ot_labels}"/>
	</td>
	<td width='25%' class="fields">
	<input type="hidden" name="position_code" id="position_code" value="">
	<input type="text" name="position_desc" id="position_desc" value="" size="30" maxlength="30"
	onBlur="if(this.value!='')callApplicablePositionCode(position_code,position_desc);else position_code.value=''">
	<input type="button" class="button" name="generic_search" id="generic_search" value="?" onClick="callApplicablePositionCode(position_code,position_desc);"></td>
</tr>

<tr>
    <td class=label width='25%'><fmt:message key="eOT.ActionIfNotDone.Label" bundle="${ot_labels}"/></td>
	<td width='25%' class="fields">
		<select name="action_if_not_done" id="action_if_not_done">
			<option value="A"><fmt:message key="Common.Alert.label" bundle="${common_labels}"/></option>
			<option value="S"><fmt:message key="Common.Stop.label" bundle="${common_labels}"/></option>
		</select>
	</td>
</tr>
<tr>
	<td class="label" width='25%'>
		<fmt:message key="eOT.PreAnaesthesiaEvalStage.Label" bundle="${ot_labels}"/>
	</td>
	<td class="fields" width='25%'>
		<input type="checkbox" name="pac_stage_yn" id="pac_stage_yn" onClick="setCheckValue();" value="<%=chk_value%>" <%=chk_checked%>>
	</td>
</tr>
<% }else if(mode.equals("modify")){%>
<tr>
	<td class="label" width='25%'>
		<fmt:message key="Common.SerialNo.label" bundle="${common_labels}"/>
	</td>
	<td width='25%' class="fields">
		<input type="text" name="srl_no" id="srl_no"  value="<%=serial_no%>"  size=3 maxlength=3 onblur="chkDupSerialNo(this);">
		<img src='../../eCommon/images/mandatory.gif'>
	</td>
</tr>
<tr>
	<td class="label" width='25%'>
		<fmt:message key="Common.Color.label" bundle="${common_labels}"/>
	</td>
	<td width='25%' class="fields">
		<select name="color_ind" id="color_ind" onchange="chkDupColorCode(this);">
		<% if(color_ind.equals("BROWN")){%>
			<option value='BROWN' selected><fmt:message key="eOT.Brown.Label" bundle="${ot_labels}"/></option>
			<option value='YELLOW'><fmt:message key="Common.Yellow.label" bundle="${common_labels}"/></option>
			<option value='GREEN'><fmt:message key="Common.Green.label" bundle="${common_labels}"/></option>
			<option value='BLUE'><fmt:message key="eOT.Blue.Label" bundle="${ot_labels}"/></option>
			<option value='RED'><fmt:message key="Common.Red.label" bundle="${common_labels}"/></option>
			<option value='DARK BLUE'><fmt:message key="eOT.DarkBlue.Label" bundle="${ot_labels}"/></option>
			<option value='MAGENTA'><fmt:message key="eOT.Magenta.Label" bundle="${ot_labels}"/></option>
			<option value='PINK'><fmt:message key="eOT.Pink.Label" bundle="${ot_labels}"/></option>
			<option value='CYAN'><fmt:message key="eOT.Cyan.Label" bundle="${ot_labels}"/></option>
			<option value='GRAY'><fmt:message key="eOT.Gray.Label" bundle="${ot_labels}"/></option>
		<% }else if(color_ind.equals("YELLOW")){%>
			<option value='BROWN'><fmt:message key="eOT.Brown.Label" bundle="${ot_labels}"/></option>
			<option value='YELLOW' selected><fmt:message key="Common.Yellow.label" bundle="${common_labels}"/></option>
			<option value='GREEN'><fmt:message key="Common.Green.label" bundle="${common_labels}"/></option>
			<option value='BLUE'><fmt:message key="eOT.Blue.Label" bundle="${ot_labels}"/></option>
			<option value='RED'><fmt:message key="Common.Red.label" bundle="${common_labels}"/></option>
			<option value='DARK BLUE'><fmt:message key="eOT.DarkBlue.Label" bundle="${ot_labels}"/></option>
			<option value='MAGENTA'><fmt:message key="eOT.Magenta.Label" bundle="${ot_labels}"/></option>
			<option value='PINK'><fmt:message key="eOT.Pink.Label" bundle="${ot_labels}"/></option>
			<option value='CYAN'><fmt:message key="eOT.Cyan.Label" bundle="${ot_labels}"/></option>
			<option value='GRAY'><fmt:message key="eOT.Gray.Label" bundle="${ot_labels}"/></option>
		<% }else if(color_ind.equals("GREEN")){%>
			<option value='BROWN'><fmt:message key="eOT.Brown.Label" bundle="${ot_labels}"/></option>
			<option value='YELLOW'><fmt:message key="Common.Yellow.label" bundle="${common_labels}"/></option>
			<option value='GREEN' selected><fmt:message key="Common.Green.label" bundle="${common_labels}"/></option>
			<option value='BLUE'><fmt:message key="eOT.Blue.Label" bundle="${ot_labels}"/></option>
			<option value='RED'><fmt:message key="Common.Red.label" bundle="${common_labels}"/></option>
			<option value='DARK BLUE'><fmt:message key="eOT.DarkBlue.Label" bundle="${ot_labels}"/></option>
			<option value='MAGENTA'><fmt:message key="eOT.Magenta.Label" bundle="${ot_labels}"/></option>
			<option value='PINK'><fmt:message key="eOT.Pink.Label" bundle="${ot_labels}"/></option>
			<option value='CYAN'><fmt:message key="eOT.Cyan.Label" bundle="${ot_labels}"/></option>
			<option value='GRAY'><fmt:message key="eOT.Gray.Label" bundle="${ot_labels}"/></option>
		<% }else if(color_ind.equals("BLUE")){%>
			<option value='BROWN'><fmt:message key="eOT.Brown.Label" bundle="${ot_labels}"/></option>
			<option value='YELLOW'><fmt:message key="Common.Yellow.label" bundle="${common_labels}"/></option>
			<option value='GREEN'><fmt:message key="Common.Green.label" bundle="${common_labels}"/></option>
			<option value='BLUE' selected><fmt:message key="eOT.Blue.Label" bundle="${ot_labels}"/></option>
			<option value='RED'><fmt:message key="Common.Red.label" bundle="${common_labels}"/></option>
			<option value='DARK BLUE'><fmt:message key="eOT.DarkBlue.Label" bundle="${ot_labels}"/></option>
			<option value='MAGENTA'><fmt:message key="eOT.Magenta.Label" bundle="${ot_labels}"/></option>
			<option value='PINK'><fmt:message key="eOT.Pink.Label" bundle="${ot_labels}"/></option>
			<option value='CYAN'><fmt:message key="eOT.Cyan.Label" bundle="${ot_labels}"/></option>
			<option value='GRAY'><fmt:message key="eOT.Gray.Label" bundle="${ot_labels}"/></option>
		<% }else if(color_ind.equals("RED")){%>
			<option value='BROWN'><fmt:message key="eOT.Brown.Label" bundle="${ot_labels}"/></option>
			<option value='YELLOW'><fmt:message key="Common.Yellow.label" bundle="${common_labels}"/></option>
			<option value='GREEN'><fmt:message key="Common.Green.label" bundle="${common_labels}"/></option>
			<option value='BLUE'><fmt:message key="eOT.Blue.Label" bundle="${ot_labels}"/></option>
			<option value='RED' selected><fmt:message key="Common.Red.label" bundle="${common_labels}"/></option>
			<option value='DARK BLUE'><fmt:message key="eOT.DarkBlue.Label" bundle="${ot_labels}"/></option>
			<option value='MAGENTA'><fmt:message key="eOT.Magenta.Label" bundle="${ot_labels}"/></option>
			<option value='PINK'><fmt:message key="eOT.Pink.Label" bundle="${ot_labels}"/></option>
			<option value='CYAN'><fmt:message key="eOT.Cyan.Label" bundle="${ot_labels}"/></option>
			<option value='GRAY'><fmt:message key="eOT.Gray.Label" bundle="${ot_labels}"/></option>
		<% }else if(color_ind.equals("DARK BLUE")){%>
			<option value='BROWN'><fmt:message key="eOT.Brown.Label" bundle="${ot_labels}"/></option>
			<option value='YELLOW'><fmt:message key="Common.Yellow.label" bundle="${common_labels}"/></option>
			<option value='GREEN'><fmt:message key="Common.Green.label" bundle="${common_labels}"/></option>
			<option value='BLUE'><fmt:message key="eOT.Blue.Label" bundle="${ot_labels}"/></option>
			<option value='RED'><fmt:message key="Common.Red.label" bundle="${common_labels}"/></option>
			<option value='DARK BLUE' selected><fmt:message key="eOT.DarkBlue.Label" bundle="${ot_labels}"/></option>
			<option value='MAGENTA'><fmt:message key="eOT.Magenta.Label" bundle="${ot_labels}"/></option>
			<option value='PINK'><fmt:message key="eOT.Pink.Label" bundle="${ot_labels}"/></option>
			<option value='CYAN'><fmt:message key="eOT.Cyan.Label" bundle="${ot_labels}"/></option>
			<option value='GRAY'><fmt:message key="eOT.Gray.Label" bundle="${ot_labels}"/></option>
		<% }else if(color_ind.equals("MAGENTA")){%>
			<option value='BROWN'><fmt:message key="eOT.Brown.Label" bundle="${ot_labels}"/></option>
			<option value='YELLOW'><fmt:message key="Common.Yellow.label" bundle="${common_labels}"/></option>
			<option value='GREEN'><fmt:message key="Common.Green.label" bundle="${common_labels}"/></option>
			<option value='BLUE'><fmt:message key="eOT.Blue.Label" bundle="${ot_labels}"/></option>
			<option value='RED'><fmt:message key="Common.Red.label" bundle="${common_labels}"/></option>
			<option value='DARK BLUE'><fmt:message key="eOT.DarkBlue.Label" bundle="${ot_labels}"/></option>
			<option value='MAGENTA' selected><fmt:message key="eOT.Magenta.Label" bundle="${ot_labels}"/></option>
			<option value='PINK'><fmt:message key="eOT.Pink.Label" bundle="${ot_labels}"/></option>
			<option value='CYAN'><fmt:message key="eOT.Cyan.Label" bundle="${ot_labels}"/></option>
			<option value='GRAY'><fmt:message key="eOT.Gray.Label" bundle="${ot_labels}"/></option>
		<% }else if(color_ind.equals("PINK")){%>
			<option value='BROWN'><fmt:message key="eOT.Brown.Label" bundle="${ot_labels}"/></option>
			<option value='YELLOW'><fmt:message key="Common.Yellow.label" bundle="${common_labels}"/></option>
			<option value='GREEN'><fmt:message key="Common.Green.label" bundle="${common_labels}"/></option>
			<option value='BLUE'><fmt:message key="eOT.Blue.Label" bundle="${ot_labels}"/></option>
			<option value='RED'><fmt:message key="Common.Red.label" bundle="${common_labels}"/></option>
			<option value='DARK BLUE'><fmt:message key="eOT.DarkBlue.Label" bundle="${ot_labels}"/></option>
			<option value='MAGENTA'><fmt:message key="eOT.Magenta.Label" bundle="${ot_labels}"/></option>
			<option value='PINK' selected><fmt:message key="eOT.Pink.Label" bundle="${ot_labels}"/></option>
			<option value='CYAN'><fmt:message key="eOT.Cyan.Label" bundle="${ot_labels}"/></option>
			<option value='GRAY'><fmt:message key="eOT.Gray.Label" bundle="${ot_labels}"/></option>
		<% }else if(color_ind.equals("CYAN")){%>
			<option value='BROWN'><fmt:message key="eOT.Brown.Label" bundle="${ot_labels}"/></option>
			<option value='YELLOW'><fmt:message key="Common.Yellow.label" bundle="${common_labels}"/></option>
			<option value='GREEN'><fmt:message key="Common.Green.label" bundle="${common_labels}"/></option>
			<option value='BLUE'><fmt:message key="eOT.Blue.Label" bundle="${ot_labels}"/></option>
			<option value='RED'><fmt:message key="Common.Red.label" bundle="${common_labels}"/></option>
			<option value='DARK BLUE'><fmt:message key="eOT.DarkBlue.Label" bundle="${ot_labels}"/></option>
			<option value='MAGENTA'><fmt:message key="eOT.Magenta.Label" bundle="${ot_labels}"/></option>
			<option value='PINK'><fmt:message key="eOT.Pink.Label" bundle="${ot_labels}"/></option>
			<option value='CYAN' selected><fmt:message key="eOT.Cyan.Label" bundle="${ot_labels}"/></option>
			<option value='GRAY'><fmt:message key="eOT.Gray.Label" bundle="${ot_labels}"/></option>
		<% }else if(color_ind.equals("GRAY")){%>
			<option value='BROWN'><fmt:message key="eOT.Brown.Label" bundle="${ot_labels}"/></option>
			<option value='YELLOW'><fmt:message key="Common.Yellow.label" bundle="${common_labels}"/></option>
			<option value='GREEN'><fmt:message key="Common.Green.label" bundle="${common_labels}"/></option>
			<option value='BLUE'><fmt:message key="eOT.Blue.Label" bundle="${ot_labels}"/></option>
			<option value='RED'><fmt:message key="Common.Red.label" bundle="${common_labels}"/></option>
			<option value='DARK BLUE'><fmt:message key="eOT.DarkBlue.Label" bundle="${ot_labels}"/></option>
			<option value='MAGENTA'><fmt:message key="eOT.Magenta.Label" bundle="${ot_labels}"/></option>
			<option value='PINK'><fmt:message key="eOT.Pink.Label" bundle="${ot_labels}"/></option>
			<option value='CYAN'><fmt:message key="eOT.Cyan.Label" bundle="${ot_labels}"/></option>
			<option value='GRAY' selected><fmt:message key="eOT.Gray.Label" bundle="${ot_labels}"/></option>
		<%}%>
		</select><img src='../../eCommon/images/mandatory.gif'>
	</td>
</tr>
<tr>
	<td class=label width='25%'>
		<fmt:message key="eOT.TextColor.Label" bundle="${ot_labels}"/>
	</td>
	<td class="fields" width='25%'>
		<select name="text_color" id="text_color">	
		<%if(text_color.equals("BLACK")){%>
				<option value='BLACK' selected><fmt:message key="eOT.Black.Label" bundle="${ot_labels}"/></option>
			<option value='WHITE'><fmt:message key="eOT.White.Label" bundle="${ot_labels}"/></option>
		<% }else if(text_color.equals("WHITE")){%>
			<option value='BLACK'><fmt:message key="eOT.Black.Label" bundle="${ot_labels}"/></option>
			<option value='WHITE' selected><fmt:message key="eOT.White.Label" bundle="${ot_labels}"/></option>
		<%}%>
		</select>
	</td>
</tr>
<tr>
    <td class=label width='25%'><fmt:message key="eOT.SpecificIndicator.Label" bundle="${ot_labels}"/></td>
	<td width='25%' class="fields"><select name="specific_indicator" id="specific_indicator" onChange="ChkApplcationposition(this);">
	<% if(specific_ind.equals("*ALL")){%>
		<option value="<%=specific_ind%>" selected><fmt:message key="eOT.AllUsers.Label" bundle="${ot_labels}"/></option>
		<option value="SPC"><fmt:message key="eOT.SpecificUsers.Label" bundle="${ot_labels}"/></option>
		</select>
	<%} else if(specific_ind.equals("SPC")){%>
 		<option value="*ALL"><fmt:message key="eOT.AllUsers.Label" bundle="${ot_labels}"/></option>
		<option value="SPC" selected><fmt:message key="eOT.SpecificUsers.Label" bundle="${ot_labels}"/></option>
		</select>
	<%}%>
	
	</td>
</tr>
<% if(specific_ind.equals("*ALL")){%>
<tr>
	<td class=label width='25%'><fmt:message key="eOT.ApplicablePosition.Label" bundle="${ot_labels}"/></td>
	<td width='25%' class="fields">
	<input type="text" name="position_desc" id="position_desc" value="<%=position_desc%>" size="30" maxlength="30" onBlur="if(this.value!='')callApplicablePositionCode(position_code,position_desc);else position_code.value='' " disabled>
	<input type="hidden" name="position_code" id="position_code" value="<%=position_code%>">
	<input type="button" class="button" name="generic_search" id="generic_search" value="?" disabled onClick='callApplicablePositionCode(position_code,position_desc);'></td>
</tr>
<%}else if(specific_ind.equals("SPC")){%>
<tr>
	<td class=label width='25%'><fmt:message key="eOT.ApplicablePosition.Label" bundle="${ot_labels}"/></td>
	<td width='25%' class="fields">
	<input type="text" name="position_desc" id="position_desc" value="<%=position_desc%>" size="30" maxlength="30" onBlur="if(this.value!='')callApplicablePositionCode(position_code,position_desc);else position_code.value='' ">
	<input type="hidden" name="position_code" id="position_code" value="<%=position_code%>">
	<input type="button" class="button" name="generic_search" id="generic_search" value="?"  onClick="callApplicablePositionCode(position_code,position_desc)"></td>
</tr>
<%}%>

<tr>
    <td class=label width='25%'><fmt:message key="eOT.ActionIfNotDone.Label" bundle="${ot_labels}"/></td>
	<td width='25%' class="fields"><select name="action_if_not_done" id="action_if_not_done">
	<% if("A".equals(action_if_not_done)) { %>
	<option value="A" Selected ><fmt:message key="Common.Alert.label" bundle="${common_labels}"/></option>
	<option value="S"><fmt:message key="Common.Stop.label" bundle="${common_labels}"/></option>
	<%}else{%>
	<option value="A"  ><fmt:message key="Common.Alert.label" bundle="${common_labels}"/></option>
	<option value="S" Selected><fmt:message key="Common.Stop.label" bundle="${common_labels}"/></option>
	<%}%>
	</select>
</td>
</tr>
<tr>
	<td class="label" width='25%'>
		<fmt:message key="eOT.PreAnaesthesiaEvalStage.Label" bundle="${ot_labels}"/>
	</td>
	<td class="fields" width='25%'>
		<input type="checkbox" name="pac_stage_yn" id="pac_stage_yn" onClick="setCheckValue();" value="<%=chk_value%>" <%=chk_checked%>>
	</td>
</tr>
<%} %>

<tr>
	<td width='35%'></td>
	<td width='65%'></td>
</tr>
</table>
<input type="hidden" name='mode' id='mode' value='<%=mode%>'>
<input type="hidden" name='facility_id' id='facility_id' value='<%=facility_id%>'>
<input type="hidden" name='stage_code1' id='stage_code1' value="<%=stage_code1%>">
<input type="hidden" name='serial_no1' id='serial_no1' value="<%=serial_no1%>">
<input type="hidden" name='color_ind1' id='color_ind1' value="<%=color_ind1%>">
<input type="hidden" name='stage_code_hiden' id='stage_code_hiden' value="<%=stage_code%>">
<input type="hidden" name='serial_no_hiden' id='serial_no_hiden' value="<%=serial_no%>">
<input type="hidden" name='color_ind_hiden' id='color_ind_hiden' value="<%=color_ind%>">
<input type='hidden' name='locale' id='locale' value="<%=locale%>">

</form>
</body>
</html>


