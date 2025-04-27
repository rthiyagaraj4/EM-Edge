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
<script language='javascript' src='../../eOH/js/MTasks.js'></script>
<script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script Language="JavaScript" src="../../eOH/js/OHCommonMasters.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
var treatmentCode=getLabel("eOH.TaskCode.Label","OH");
var treatmentDescription=getLabel("eOH.TreatmentDescription.Label","OH");
var catalogCrossReference=getLabel("Common.CatalogCrossReference.label","common");
var enabled=getLabel("Common.Enabled.label","common");
var linkCatalog=getLabel("Common.LinkCatalog.label","Common");
</script>
</head>

<body onLoad="parent.commontoolbarFrame.document.forms[0].apply.disabled=false;AssignDBValue();" OnMouseDown='CodeArrest()' onKeyDown="lockKey()">

<%
//request parameter
Connection con=null;
PreparedStatement pstmt=null;
ResultSet rs=null;

String mode=checkForNull(request.getParameter("mode"));

String task_code = checkForNull(request.getParameter( "task_code" ));

String sql="";
String task_desc="";
String order_catalog_code="";
String order_catalog_desc="";
String disable_flag="";
String eff_status="";
String chk_value="E";
String chk_checked="checked";
String desc = "";
String task_code_disable = "";
String link_status = "";
String ext_perm_loc = "N";
String ext_loc_checked = "";
String oh_note_type = "";
String ext_loc_disabled = "";

try{
	con=ConnectionManager.getConnection(request);
	if(mode.equals("modify")){
		sql="SELECT A.TASK_DESC, A.ORDER_CATALOG_CODE, NVL(A.EFF_STATUS,'E') EFF_STATUS, A.EXT_PERM_LOC, A.OH_NOTE_TYPE, B.SHORT_DESC FROM OH_TASKS_LANG_VW A, OR_ORDER_CATALOG_LANG_VW B WHERE A.LANGUAGE_ID = B.LANGUAGE_ID (+) AND A.ORDER_CATALOG_CODE = B.ORDER_CATALOG_CODE (+) AND A.LANGUAGE_ID = ? AND TASK_CODE=?";
		
		pstmt=con.prepareStatement(sql);
		pstmt.setString(1,locale);
		pstmt.setString(2,task_code);
		rs=pstmt.executeQuery();
		
		while(rs!=null && rs.next()){
			task_desc=checkForNull(rs.getString("TASK_DESC"));
			order_catalog_code=checkForNull(rs.getString("ORDER_CATALOG_CODE"));
			eff_status=rs.getString("EFF_STATUS");
			desc=checkForNull(rs.getString("SHORT_DESC"));
			ext_perm_loc=checkForNull(rs.getString("EXT_PERM_LOC"));
			oh_note_type=checkForNull(rs.getString("OH_NOTE_TYPE"));
		}

		if(ext_perm_loc.equals("Y")){
			ext_loc_checked = "checked";
			ext_loc_disabled = "disabled";
		}
		else{
			ext_loc_checked = "";
			ext_loc_disabled = "";
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

	    task_code_disable="disabled";	
	}

	if(mode.equals("insert")){
	
		link_status="checkbox";
		chk_checked="checked";
	}else{
		link_status="hidden";
	}		

		%>

<form name="MTasksForm" id="MTasksForm"  onload='FocusFirstElement()'  action="../../servlet/eOH.MTasksServlet" method="post" target="messageFrame"> 
<br><br><br><br>
<table border=0 cellspacing=0 cellpadding=3 width='90%'  align=center>
<tr>
	<td width='35%'></td>
	<td width='65%'></td>
</tr>
<tr>
	<td class=label width="25%">
		<fmt:message key="eOH.TaskCode.Label" bundle="${oh_labels}"/>
	</td>
	<td class="fields" width="25%" colspan="3">
		<input type="text" name="task_code" id="task_code" value="<%=task_code%>" size="20" maxlength="20" <%=task_code_disable%> onkeypress="return CheckForSpecChars(event)"  onBlur="ChangeUpperCase(this)" >
		<img src='../../eCommon/images/mandatory.gif'>
	</td>
</tr>
<tr>
	<td class=label width="25%">
		<fmt:message key="eOH.TaskDescription.Label" bundle="${oh_labels}"/>
	</td>
	<td class="fields" width="25%" colspan="3">
		 <input type="text" name="task_desc" id="task_desc" value="<%=task_desc%>" size="30" maxlength="60" onkeypress="CharCheck();" <%=disable_flag%>>
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
	
	<td class="fields" width="25%" colspan="3">
	<input type="checkbox" name="link_status" id="link_status" value='<%=chk_value%>' <%=chk_checked%> onclick="setLinkValue();" >			
	</td>
</tr>
<%
}else{
%>
	<input type="hidden" name="link_status" id="link_status" value='<%=chk_value%>' <%=chk_checked%> onclick="setLinkValue();" >
<%
}
%>

<tr>
	<td class='label' width='25%' >
			<fmt:message key="Common.CatalogCrossReference.label" bundle="${common_labels}"/>
		</td>
		<td  class="fields"  width='25%' >
		<input type="text"  name="order_catalog_desc" id="order_catalog_desc" size='30' maxlength='40' value="<%=desc%>" <%=task_code_disable%> onBlur="if(this.value!='')getTreatmentLookUp(order_catalog_code,order_catalog_desc);">
		<input type="hidden" name="order_catalog_code" id="order_catalog_code" value="<%=order_catalog_code%>">
		<input type="button" class="button" name="treatment_lookup" id="treatment_lookup" value="?" onclick="getTreatmentLookUp(order_catalog_code,order_catalog_desc);" <%=task_code_disable%>><% if(order_catalog_desc.equals("")){%>
		    <img id="img2" src='../../eCommon/images/mandatory.gif'></td>
		<%}else{%>
			<img id="img2" src='../../eCommon/images/Blank1.gif' ></td>
		<%}%>
				
</tr>
<tr>
	<td class=label width="25%"><fmt:message key="eOH.PerformingLocAppl.Label" bundle="${oh_labels}"/></td>
	<td class="fields" width="25%" colspan="3">
			<input type="checkbox" name="ext_perm_loc" id="ext_perm_loc" value='<%=ext_perm_loc%>' <%=ext_loc_checked%> <%=ext_loc_disabled%> onclick="setCheckValue('ext_perm_loc');" <%=disable_flag%>>
			
	</td>
</tr>
<tr>
	<td id="note_type_label_id" class=label width="25%">
	<%
		if(mode.equals("modify") && ext_perm_loc.equals("Y")){
	%>
			<fmt:message key="Common.NoteType.label" bundle="${common_labels}"/>
	<%
		}
	%>
	</td>
	<td id="note_type_id" class="fields" width="25%">
	<%
		if(mode.equals("modify") && ext_perm_loc.equals("Y")){
	%>
			<select name="oh_note_type" id="oh_note_type" <% if(mode.equals("modify")){ %> DB_VALUE="<%=oh_note_type%>" <% } %> <%=disable_flag%>>
				<option value=""><fmt:message key="eOH.DefaultSelect.Label" bundle="${oh_labels}"/></option>
				<%
					if(rs != null) rs.close();
					if(pstmt != null) pstmt.close();
					pstmt=con.prepareStatement("SELECT NOTE_TYPE, NOTE_TYPE_DESC FROM CA_NOTE_TYPE A, CA_NOTE_GROUP B WHERE A.NOTE_GROUP_ID = B.NOTE_GROUP AND B.APPL_TASK_ID = 'OH'");
					rs=pstmt.executeQuery();
					
					while(rs.next()){
				%>
						<option value='<%=rs.getString("NOTE_TYPE")%>'><%=rs.getString("NOTE_TYPE_DESC")%></option>
				<%
					}
				%>
			</select>
	<%
		}
	%>
	</td>
</tr>
<tr>
	<td class=label width="25%">
			<fmt:message key="Common.enabled.label" bundle="${common_labels}"/>
	</td>
	<td class="fields" width="25%" colspan="3" onclick="setCheckValue('eff_status');">
			<input type="checkbox" name="eff_status" id="eff_status" value='<%=chk_value%>' <%=chk_checked%> >
			
	</td>
</tr>
<tr>
	<td width='35%'></td>
	<td width='65%'></td>
</tr>
</table>
<input type='hidden' name='mode' id='mode' value='<%=mode%>'>
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
<input type='hidden' name='task_code1' id='task_code1' value="<%=task_code%>">
<input type='hidden' name='task_desc1' id='task_desc1' value="<%=task_desc%>">
<input type='hidden' name='order_catalog_code1' id='order_catalog_code1' value="<%=order_catalog_code%>">
<input type='hidden' name='order_catalog_desc1' id='order_catalog_desc1' value="<%=order_catalog_desc%>">
<input type='hidden' name='ext_perm_loc1' id='ext_perm_loc1' value="<%=ext_perm_loc%>">
<input type='hidden' name='oh_note_type1' id='oh_note_type1' value="<%=oh_note_type%>">

<input type='hidden' name='splity_module_id' id='splity_module_id' value="OH">
</form>

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

