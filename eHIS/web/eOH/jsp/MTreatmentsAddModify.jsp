<!DOCTYPE html>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager"  contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ include file="../../eOH/jsp/StringUtil.jsp" %>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String locale = (String)session.getAttribute("LOCALE");
request.setCharacterEncoding("UTF-8");
%>

<html>
<head>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script language='javascript' src='../../eOH/js/MTreatments.js'></script>
<script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script language='javascript' src='../../eOH/js/OHCommonMasters.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
var treatmentCode=getLabel("eOH.TreatmentCode.Label","OH");
var treatmentDescription=getLabel("eOH.TreatmentDescription.Label","OH");
var treatmentCategory=getLabel("Common.TreatmentCategory.label","Common");
var catalogCrossReference=getLabel("Common.CatalogCrossReference.label","common");
var treatmenthasMultipleTasks=getLabel("eOH.TreatmenthasMultipleTasks.Label","OH");
var enabled=getLabel("Common.Enabled.label","common");
function enableApply()
{
var delay = function() { enableApply1(); };

setTimeout(delay,500);
}
function enableApply1(){
	parent.commontoolbarFrame.document.forms[0].apply.disabled=false;
}
</script>
</head>

<!-- <body onLoad="AssignDBValue();parent.commontoolbarFrame.document.forms[0].apply.disabled=false;" OnMouseDown='CodeArrest()' onKeyDown="lockKey()" > -->
<body onLoad="AssignDBValue();" OnMouseDown='CodeArrest()' onKeyDown="lockKey()" >

<%
//request parameter
Connection con=null;
PreparedStatement pstmt=null;
ResultSet rs=null;

String mode=checkForNull(request.getParameter("mode"));

String trmt_code = checkForNull(request.getParameter( "trmt_code" ));

String sql="";
String trmt_desc="";
String trmt_category_code="";
String order_catalog_code="";
String order_catalog_desc="";
String progress_note_group_desc="";
String progress_note_group_code="";
String disable_flag="";
String eff_status="";
String multiple_task_yn="";
String chk_value="E";
String chk_value1="Y";
String chk_checked="";
String chk_checked1="";
String disable_flag1="";
String desc = "";
String trmt_code_disable = "";
//added by parul for multiplae surface on 06/01/2010
String chk_checked_surface="";
String disable_surface="";
String multiple_surface_yn="Y";

//Added by Sharon Crasta on 1/19/2010 for SRR20056-CRF-0442(IN010838)
String chk_value2="Y";
String crown_applicable_yn="";

try{
	con=ConnectionManager.getConnection(request);

	if(mode.equals("modify")){
		sql="SELECT A.TRMT_DESC, A.TRMT_CATEGORY_CODE, A.ORDER_CATALOG_CODE, NVL(A.EFF_STATUS,'E') EFF_STATUS, NVL(A.MULTIPLE_TASK_YN,'Y') MULTIPLE_TASK_YN, NVL(A.CROWN_APPLICABLE,'Y') CROWN_APPLICABLE, B.SHORT_DESC,C.NOTE_GROUP_DESC,A.PROGRESS_NOTE_GROUP FROM OH_TREATMENT_LANG_VW A, OR_ORDER_CATALOG_LANG_VW B,CA_NOTE_GROUP_LANG_VW C WHERE A.ORDER_CATALOG_CODE = B.ORDER_CATALOG_CODE (+) AND A.PROGRESS_NOTE_GROUP = C.NOTE_GROUP(+) AND A.LANGUAGE_ID = C.LANGUAGE_ID (+) AND A.LANGUAGE_ID = B.LANGUAGE_ID (+) AND A.TRMT_CODE = ? AND A.LANGUAGE_ID = ?";	
	
		pstmt=con.prepareStatement(sql);
		pstmt.setString(1,trmt_code);
		pstmt.setString(2,locale);
		rs=pstmt.executeQuery();
		
		while(rs!=null && rs.next()){
			trmt_desc=checkForNull(rs.getString("TRMT_DESC"));
			trmt_category_code=checkForNull(rs.getString("TRMT_CATEGORY_CODE"));
			order_catalog_code=checkForNull(rs.getString("ORDER_CATALOG_CODE"));
			eff_status=rs.getString("EFF_STATUS");
			desc=rs.getString("SHORT_DESC");
			multiple_task_yn=rs.getString("MULTIPLE_TASK_YN");
			crown_applicable_yn = rs.getString("CROWN_APPLICABLE");//Added by Sharon Crasta on 1/19/2010 for SRR20056-CRF-0442(IN010838)
			progress_note_group_desc = checkForNull(rs.getString("NOTE_GROUP_DESC"));
			progress_note_group_code = checkForNull(rs.getString("PROGRESS_NOTE_GROUP"));
			
		}

		if(desc == null){
			desc = "";
		}

		if(eff_status.equals("E")){
			chk_checked="checked";
			disable_flag="";
		}
		else{
			chk_checked="";
			disable_flag="disabled";
			chk_value="D";
		}
		
		if(multiple_task_yn.equals("Y")){
			chk_checked1="checked";
			disable_flag1="";
		}
		else{
			chk_checked1="";
			disable_flag1="disabled";
			chk_value1="N";
		}

		//Added by Sharon Crasta on 1/19/2010 for SRR20056-CRF-0442(IN010838)
		if(crown_applicable_yn.equals("Y")){
			chk_checked_surface="checked";
			disable_surface="";
		}
		else{
			chk_checked_surface="";
			disable_surface="disabled";
			chk_value2="N";
		}

		trmt_code_disable="disabled";	
	}

		
	if(mode.equals("insert")){
		chk_checked="checked";
		chk_checked1="checked";
		chk_checked_surface="checked";
	}

%>

<form name="MTreatmentsForm" id="MTreatmentsForm"  onload='FocusFirstElement()'  action="../../servlet/eOH.MTreatmentsServlet" method="post" target="messageFrame"> 
<br><br><br><br>
 <table border=0 cellspacing=0 cellpadding=3 width='90%'  align=center> 
<tr>
	<td width='25%'></td>
	<td width='30%'></td>
	<td width='25%'></td>
	<td width='10%'></td>
</tr>
<tr>
	<td class=label width="25%">
		<fmt:message key="eOH.TreatmentCode.Label" bundle="${oh_labels}"/>
	</td>
	<td class="fields" width="25%">
		<input type="text" name="trmt_code" id="trmt_code" value="<%=trmt_code%>" size="20" maxlength="20" <%=trmt_code_disable%> onkeypress="return CheckForSpecChars(event)"  onBlur="ChangeUpperCase(this)">
		<img src='../../eCommon/images/mandatory.gif'>
	</td>
</tr>
 <tr>
	<td class=label width="25%">
		<fmt:message key="eOH.TreatmentDescription.Label" bundle="${oh_labels}"/>
	</td>
	<td class="fields" width="25%">
		<input type="text" name="trmt_desc" id="trmt_desc" value="<%=trmt_desc%>" size="30" maxlength="60" onkeypress="CharCheck();" <%=disable_flag%>>
		<img src='../../eCommon/images/mandatory.gif'>
	</td>
</tr>
<tr>
	<td class=label width='25%' nowrap>
		<fmt:message key="Common.TreatmentCategory.label" bundle="${common_labels}"/>
	</td>
	<td class="fields" width="25%" align="left">
			 <select name='trmt_category_code' id='trmt_category_code' <% if(mode.equals("modify")){ %> DB_VALUE="<%=trmt_category_code%>" <% } %><%=disable_flag%> onChange="trmtTypeChange(this);"> 
			<option value=""><fmt:message key="eOH.DefaultSelect.Label" bundle="${oh_labels}"/></option>
			 <%
				sql="SELECT TRMT_CATEGORY_CODE, TRMT_CATEGORY_DESC FROM OH_TREATMENT_CATEGORY_LANG_VW WHERE EFF_STATUS = 'E' AND LANGUAGE_ID = ? ORDER BY 1";
					if(rs!=null) rs.close();
					if(pstmt!=null) pstmt.close();
					pstmt=con.prepareStatement(sql);
					pstmt.setString(1,locale);
					rs=pstmt.executeQuery();
					while(rs!=null && rs.next()){
					%>
					<option value="<%=rs.getString("TRMT_CATEGORY_CODE")%>"><%=rs.getString("TRMT_CATEGORY_DESC")%></option>
			<%		}   %>	
		</select>
		<img src='../../eCommon/images/mandatory.gif'>
	</td>
</tr>
<%
	if(mode.equals("insert")){
%>
<tr>
      <td class=label width="25%">
			<fmt:message key="Common.LinkCatalog.label" bundle="${common_labels}"/>
     </td>
	 <td class="fields" width="25%">
			<input type="checkbox" name="link_status" id="link_status" value='<%=chk_value1%>' <%=chk_checked1%> onclick="setLinkValue();" <%=trmt_code_disable%> >
	 </td>
</tr>
<%
	}else{
%>
		<input type="hidden" name="link_status" id="link_status" value="<%=chk_value1%>">
<%
	}
%>
<tr>
	<td class='label' width="25%" >
			<fmt:message key="Common.CatalogCrossReference.label" bundle="${common_labels}"/>
		</td>
		<td  class="fields"  width="25%" >
		<input type="text"  name="order_catalog_desc" id="order_catalog_desc" size='30' maxlength='40' value="<%=desc%>" <%=trmt_code_disable%> onBlur="if(this.value!='')getTreatmentLookUp(order_catalog_code,order_catalog_desc);">
		<input type="hidden" name="order_catalog_code" id="order_catalog_code" value="<%=order_catalog_code%>">
		<input type="button" class="button" name="treatment_lookup" id="treatment_lookup" value="?" onclick="getTreatmentLookUp(order_catalog_code,order_catalog_desc);" <%=trmt_code_disable%>><% if(order_catalog_desc.equals("") && mode.equals("insert")){%>
		    <img id="img2" src='../../eCommon/images/mandatory.gif'></td>
		<%}else{%>
			<img id="img2" src='../../eCommon/images/Blank1.gif'></td>
		<%}%>
				
</tr>
<tr>
	<td class=label width="25%">
			<fmt:message key="eOH.TreatmentHasMultipleTasks?.Label" bundle="${oh_labels}"/>
	</td>
	<td class="fields" width="25%" >
			<input type="checkbox" name="multiple_task_yn" id="multiple_task_yn" value='<%=chk_value1%>' <%=chk_checked1%> onclick="setCheckValueforMultiTasks();">
	</td>
	<!--Added by Sharon Crasta on 1/19/2010 for SRR20056-CRF-0442(IN010838) -->
	<td id="crown_appl" class=label width="25%">
		<fmt:message key="eOH.CrownApplicable.Label" bundle="${oh_labels}"/>
	</td>
	<td class="fields" width="25%">
			<input type="checkbox" name="crown_applicable_yn" id="crown_applicable_yn" value='<%=chk_value2%>' <%=chk_checked_surface%> onclick="setCheckValueforCrownAppl();">

	</td> 
	<!-- End-->

</tr>
<tr>
	    <td class='label' width="25%" >
			<fmt:message key="eOH.ProgressNoteGroup.Label" bundle="${oh_labels}"/>
		</td>
		<td  class="fields"  width="25%" >
		<input type="hidden" name="progress_note_group_code" id="progress_note_group_code" value="<%=progress_note_group_code%>">
		<input type="text"  name="progress_note_group_desc" id="progress_note_group_desc" size='30' maxlength='40' value="<%=progress_note_group_desc%>"  onBlur="if(this.value!='')getNotesLookUp(progress_note_group_code,progress_note_group_desc);else progress_note_group_code.value=''" <%=disable_flag%>>
		
		<input type="button" class="button" name="progress_notes_lookup" id="progress_notes_lookup" value="?" onclick="getNotesLookUp(progress_note_group_code,progress_note_group_desc);" <%=disable_flag%>><!-- <% if(progress_note_group_desc.equals("") && mode.equals("insert")){%>
		    <img id="img2" src='../../eCommon/images/mandatory.gif'></td>
		<%}else{%>
			<img id="img2" src='../../eCommon/images/Blank1.gif'></td> -->
		<%}%>
				
</tr>
<tr>
	<td class=label width="25%">
			<fmt:message key="Common.enabled.label" bundle="${common_labels}"/>
	</td>
	<td class="fields" width="25%" onclick="setCheckValue();">
			<input type="checkbox" name="eff_status" id="eff_status" value='<%=chk_value%>' <%=chk_checked%> >
			
	</td>
	
</tr> 
 <tr>
	<td width='25%'></td>
	<td width='30%'></td>
	<td width='25%'></td>
	<td width='10%'></td>
</tr> 
</table>
<input type='hidden' name='mode' id='mode' value='<%=mode%>'>
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
<input type='hidden' name='trmt_code1' id='trmt_code1' value="<%=trmt_code%>">
<input type='hidden' name='trmt_desc1' id='trmt_desc1' value="<%=trmt_desc%>">
<input type='hidden' name='trmt_category_code1' id='trmt_category_code1' value="<%=trmt_category_code%>">
<input type='hidden' name='order_catalog_code1' id='order_catalog_code1' value="<%=order_catalog_code%>">
<input type='hidden' name='multiple_task_yn1' id='multiple_task_yn1' value="<%=multiple_task_yn%>">
<input type='hidden' name='multiple_task_yn1' id='multiple_task_yn1' value="<%=multiple_surface_yn%>"> 

<input type='hidden' name='splity_module_id' id='splity_module_id' value="OH">
</form>

<%
	if(mode.equals("insert") || mode.equals("modify")){
%>
	<script>
	    
		//parent.commontoolbarFrame.document.forms[0].apply.disabled=false;
		enableApply();
        
	</script>
<%
	}
%>
</body>
</html>
<%
}catch ( Exception e ) {
	e.printStackTrace() ;
}finally {
	try{
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
		if(con!=null) 
			ConnectionManager.returnConnection(con,request);
	   }catch(Exception es){es.printStackTrace();}
}
%>

