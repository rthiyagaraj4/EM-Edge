<!DOCTYPE html>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,eCommon.Common.*,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper"  contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ include file="../../eOT/jsp/StringUtil.jsp" %>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String locale = (String)session.getAttribute("LOCALE");
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
%>

<html>
<head>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script language='javascript' src='../../eOT/js/OperationsProcedures.js'></script>
<script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
var subCategory=getLabel("eOT.SubCategory.Label","OT");
var category=getLabel("Common.category1.label","common");
var checklist=getLabel("eOT.Checklist.Label","OT");
var orderCatalog=getLabel("Common.ordercatalog.label","common");
var operationType=getLabel("eOT.OperationType.Label","OT");
var swabandInstrumentCount=getLabel("eOT.SwabandInstrumentCount.Label","OT");
function oper_type_validate(obj,oper_type_code,oper_type_desc){
	if(obj.value!='' && obj.value!=null)
		searchlkp('Operation Type Search',operationType,oper_type_code,oper_type_desc); 
	else
		oper_type_code="";
}
function butdisable(){
if (parent.commontoolbarFrame.document.forms[0].apply.disabled==true)
{
	parent.commontoolbarFrame.document.forms[0].apply.disabled=false;
} else {
	return false;
	}
}
</script>
<style>
textarea {
  resize: none;
}
</style>
</head>

<!--body onload="butdisable()" OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'-->
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'> <!--Modified Against GHL-SCF-1519-->

<%
//request parameter
String mode=checkForNull(request.getParameter("mode"));
String oper_code = checkForNull(request.getParameter( "oper_code" ));
//cannoicalization of empty String
String empty = "".intern();
String oper_code_scheme = empty;       String disable_oper_code = empty;
String chk_checked="checked";          String chk_value="E";
String disable_flag=empty;             String cat_dis_flag=empty;
String readonly_flag=empty;            String surgery_disable=empty;
String long_desc=empty;                String short_desc=empty;
String oper_type_desc=empty;           String oper_type_code=empty;
String order_catalog_desc=empty;       String order_catalog_code = empty;
String speciality_desc=empty;		   String side_checked=empty;
String side_appl ="N";				   String duration =empty;
String duration_db_value_jsp =empty;   String speciality_code=empty;
String pre_op_check_list=empty;		   String pre_op_check_list_desc=empty;
String post_op_check_list=empty;	   String post_op_check_list_desc=empty;
String swab_instr_tmpl_id =empty;	   String swab_instr_tmpl_desc =empty;
String oper_cat_code = empty;		   String oper_cat_desc = empty;
String oper_sub_cat_code=empty;		   String oper_sub_cat_desc =empty;
String db_oper_cat_code = empty;	   String db_oper_sub_cat_code=empty;
String patient_info_file_id=empty;	   String status=empty;
String link_status=empty;			   String sql=empty;
String diag_code_scheme=empty;		   String order_type_desc=empty; 	
String diag_code_scheme_desc = empty;
if(mode.equals("modify")){	
	disable_oper_code="readOnly";
}
Connection con=null;
PreparedStatement stmt=null;
//PreparedStatement pstmt=null;
ResultSet rs=null;
//ResultSet rst=null;
//String diag_code_scheme_selected = "";
if(mode.equals("insert")){
	try{
		con=ConnectionManager.getConnection(request);
		String sql_1="SELECT OPER_CODE_SCHEME  FROM   OT_PARAM";
		stmt=con.prepareStatement(sql_1);
		rs=stmt.executeQuery();
		while(rs!=null && rs.next())
		{
			oper_code_scheme=rs.getString("oper_code_scheme");
		}
	}
	catch(Exception e){
		e.printStackTrace();
	}finally{
		if(rs!=null)rs.close();
        if(stmt!=null)stmt.close();
		if(con!=null)
		ConnectionManager.returnConnection(con,request); 
	}
}

if(mode.equals("modify")){
	cat_dis_flag="disabled";
	try{
		con=ConnectionManager.getConnection(request);
		//sql="Select  a.long_desc, a.short_desc, a.oper_type_code , b.short_desc oper_type_desc, a.order_catalog_code, c.short_desc order_catalog_desc, to_char(c.appt_time, 'hh24:mi') duration, a.speciality_code, d.short_desc speciality_desc, nvl(appl_right_left_flag,'N') appl_right_left_flag, a.pre_op_check_list , e.description pre_op_check_list_desc, a.post_op_check_list , f.description post_op_check_list_desc , g.oper_cat_code oper_cat_code, g.oper_sub_cat_code oper_sub_cat_code,  a.swab_instr_tmpl_id swab_instr_tmpl_id, j.description swab_instr_tmpl_desc, nvl(a.status,'E') status from OT_OPER_MAST_LANG_VW a, OT_OPER_TYPE_LANG_VW b, OR_ORDER_CATALOG_LANG_VW c , AM_SPECIALITY_LANG_VW d , OT_CHECKLIST_HDR_LANG_VW e, OT_CHECKLIST_HDR_LANG_VW f , OT_OPER_FOR_GROUP_CAT g, OT_SWAB_INSTR_TMPL_HDR_LANG_VW j where a.language_id = '"+locale+"' AND a.language_id = b.language_id AND a.oper_type_code = b.oper_type and a.language_id = c.language_id AND a.order_catalog_code = c.order_catalog_code and a.language_id = d.language_id AND a.speciality_code = d.speciality_code and a.language_id = e.language_id(+) AND a.pre_op_check_list = e.checklist_code(+) and a.language_id= f.language_id(+) AND a.post_op_check_list = f.checklist_code(+) and a.oper_code = g.oper_code(+) and a.speciality_code = g.oper_group_code(+) and a.language_id = j.language_id(+) AND a.swab_instr_tmpl_id = j.template_id(+) and a.oper_code =?";
		sql=" SELECT  A.LONG_DESC, A.SHORT_DESC, A.OPER_TYPE_CODE , GET_DESC(?,'OT_OPER_TYPE_LANG_VW','SHORT_DESC','OPER_TYPE',B.OPER_TYPE) OPER_TYPE_DESC, A.ORDER_CATALOG_CODE, GET_DESC(?,'OR_ORDER_CATALOG_LANG_VW','SHORT_DESC','ORDER_CATALOG_CODE',A.ORDER_CATALOG_CODE) ORDER_CATALOG_DESC, TO_CHAR(C.APPT_TIME, 'HH24:MI') DURATION, A.SPECIALITY_CODE, GET_DESC(?,'AM_SPECIALITY_LANG_VW','SHORT_DESC','SPECIALITY_CODE',A.SPECIALITY_CODE) SPECIALITY_DESC, NVL(APPL_RIGHT_LEFT_FLAG,'N') APPL_RIGHT_LEFT_FLAG, A.PRE_OP_CHECK_LIST , GET_DESC(?,'OT_CHECKLIST_HDR_LANG_VW','DESCRIPTION','CHECKLIST_CODE',A.PRE_OP_CHECK_LIST) PRE_OP_CHECK_LIST_DESC, A.POST_OP_CHECK_LIST , GET_DESC(?,'OT_CHECKLIST_HDR_LANG_VW','DESCRIPTION','CHECKLIST_CODE',A.POST_OP_CHECK_LIST) POST_OP_CHECK_LIST_DESC ,G.OPER_CAT_CODE OPER_CAT_CODE, (SELECT LONG_DESC FROM OT_OPER_CATEGORY_LANG_VW Y WHERE Y.OPER_GROUP_CODE=I.OPER_GROUP_CODE AND Y.OPER_CAT_CODE = I.OPER_CAT_CODE AND Y.LANGUAGE_ID=?) OPER_CAT_DESC, G.OPER_SUB_CAT_CODE OPER_SUB_CAT_CODE,  (SELECT LONG_DESC FROM OT_OPER_SUB_CATEGORY_LANG_VW X WHERE X.OPER_GROUP_CODE=I.OPER_GROUP_CODE AND X.OPER_CAT_CODE = I.OPER_CAT_CODE AND X.OPER_SUB_CAT_CODE=I.OPER_SUB_CAT_CODE AND X.LANGUAGE_ID=?) OPER_SUB_CAT_DESC, A.SWAB_INSTR_TMPL_ID SWAB_INSTR_TMPL_ID, GET_DESC(?,'OT_SWAB_INSTR_TMPL_HDR_LANG_VW','DESCRIPTION','TEMPLATE_ID',J.TEMPLATE_ID) SWAB_INSTR_TMPL_DESC, NVL(A.STATUS,'E') STATUS, NVL(A.LINK_CATALOG_YN,'N') LINK_CATALOG_YN,A.DIAG_CODE_SCHEME,(SELECT ORDER_TYPE_CODE||'-'||SHORT_DESC FROM OR_ORDER_TYPE AA WHERE AA.ORDER_TYPE_CODE = C.ORDER_TYPE_CODE) ORDER_TYPE_DESC FROM OT_OPER_MAST_LANG_VW A, OT_OPER_TYPE B, OR_ORDER_CATALOG C , AM_SPECIALITY D , OT_CHECKLIST_HDR E, OT_CHECKLIST_HDR F , OT_OPER_FOR_GROUP_CAT G, OT_OPER_CATEGORY H, OT_OPER_SUB_CATEGORY I, OT_SWAB_INSTR_TMPL_HDR J WHERE A.LANGUAGE_ID=? AND A.OPER_TYPE_CODE = B.OPER_TYPE AND A.ORDER_CATALOG_CODE = C.ORDER_CATALOG_CODE(+) AND A.SPECIALITY_CODE = D.SPECIALITY_CODE AND A.PRE_OP_CHECK_LIST = E.CHECKLIST_CODE(+) AND A.POST_OP_CHECK_LIST = F.CHECKLIST_CODE(+) AND A.OPER_CODE = G.OPER_CODE(+) AND A.SPECIALITY_CODE = G.OPER_GROUP_CODE(+) AND G.OPER_CAT_CODE = H.OPER_CAT_CODE(+) AND G.OPER_CAT_CODE = I.OPER_CAT_CODE(+) AND G.OPER_SUB_CAT_CODE =   I.OPER_SUB_CAT_CODE(+) AND A.SWAB_INSTR_TMPL_ID = J.TEMPLATE_ID(+) AND A.OPER_CODE= ?";

		stmt=con.prepareStatement(sql);
		stmt.setString(1,locale);
		stmt.setString(2,locale);
		stmt.setString(3,locale);
		stmt.setString(4,locale);
		stmt.setString(5,locale);
		stmt.setString(6,locale);
		stmt.setString(7,locale);
		stmt.setString(8,locale);
		stmt.setString(9,locale);
		stmt.setString(10,oper_code);
		rs=stmt.executeQuery();

		while(rs.next()){
			long_desc			=		checkForNull(rs.getString("long_desc") );
			short_desc			=		checkForNull(rs.getString("short_desc") );
			short_desc = short_desc.replace("\"","");//ML-BRU-SCF-1401
			oper_type_code			=		checkForNull(rs.getString("oper_type_code") );
			oper_type_desc			=		checkForNull(rs.getString("oper_type_desc") );
			order_catalog_code		=		checkForNull(rs.getString("order_catalog_code") );
			order_catalog_desc		=		checkForNull(rs.getString("order_catalog_desc"));
			duration			=		checkForNull(rs.getString("duration"));
			duration_db_value_jsp		=		checkForNull(rs.getString("duration"));
			side_appl			=		checkForNull(rs.getString("appl_right_left_flag") );
			speciality_code			=		checkForNull(rs.getString("speciality_code") );
			speciality_desc			=		checkForNull(rs.getString("speciality_desc") );
			pre_op_check_list		=		checkForNull(rs.getString("pre_op_check_list"));
			pre_op_check_list_desc 	 	=		checkForNull(rs.getString("pre_op_check_list_desc"));
			post_op_check_list		=		checkForNull(rs.getString("post_op_check_list"));
			post_op_check_list_desc 	=		checkForNull(rs.getString("post_op_check_list_desc"));
			oper_cat_code			=		checkForNull(rs.getString("oper_cat_code"));
			oper_cat_desc			=		checkForNull(rs.getString("oper_cat_desc"));	
			oper_sub_cat_code		=		checkForNull(rs.getString("oper_sub_cat_code"));
			oper_sub_cat_desc		=		checkForNull(rs.getString("oper_sub_cat_desc"));
			swab_instr_tmpl_id		=		checkForNull(rs.getString("swab_instr_tmpl_id"));
			swab_instr_tmpl_desc		=		checkForNull(rs.getString("swab_instr_tmpl_desc"));
			status				=		checkForNull(rs.getString("status"));
			link_status			=		checkForNull(rs.getString("link_catalog_yn"));
			diag_code_scheme		=		checkForNull(rs.getString("diag_code_scheme"));
			order_type_desc			=		checkForNull(rs.getString("ORDER_TYPE_DESC"));
		}
		db_oper_cat_code = oper_cat_code;
		db_oper_sub_cat_code = oper_sub_cat_code;
		if(status.equals("E")){
			chk_checked="checked";
			disable_flag="";
			readonly_flag="";
		}else{
			chk_checked="";
			disable_flag="disabled";
			chk_value="D";
		}
if(mode.equals("modify")) {
	String sql_ot_param="";
	
	String sql_ot_splty="SELECT DIAG_CODE_SCHEME,GET_DESC(?,'MR_TERM_SET_LANG_VW','TERM_SET_DESC','TERM_SET_ID',DIAG_CODE_SCHEME) DIAG_CODE_DESC FROM OT_SPECIALITIES WHERE SPECIALITY_CODE= ? ";
		if(rs!=null)rs.close();
        if(stmt!=null)stmt.close();
		stmt=con.prepareStatement(sql_ot_splty);
		stmt.setString(1,locale);
		stmt.setString(2,speciality_code);
		rs=stmt.executeQuery();
		while(rs.next()){
			diag_code_scheme=checkForNull(rs.getString("DIAG_CODE_SCHEME"));
			diag_code_scheme_desc=checkForNull(rs.getString("DIAG_CODE_DESC"));	
		}
	if(diag_code_scheme.equals("")){
		sql_ot_param="SELECT OPER_CODE_SCHEME,GET_DESC(?,'MR_TERM_SET_LANG_VW','TERM_SET_DESC','TERM_SET_ID',OPER_CODE_SCHEME) DIAG_CODE_DESC FROM OT_PARAM";
		if(rs!=null)rs.close();
        if(stmt!=null)stmt.close();
		stmt=con.prepareStatement(sql_ot_param);
		stmt.setString(1,locale);
		rs=stmt.executeQuery();
		while(rs.next()){
			diag_code_scheme=checkForNull(rs.getString("OPER_CODE_SCHEME"));
			diag_code_scheme_desc=checkForNull(rs.getString("DIAG_CODE_DESC"));  
		}
	}
}
		side_checked = ("Y".equals(side_appl))?"checked":"";
		surgery_disable="disabled";	
	}
	catch(Exception e){
		e.printStackTrace();
}finally{
		if(rs!=null)rs.close();
	        if(stmt!=null)stmt.close();
		if(con!=null)
		ConnectionManager.returnConnection(con,request); 
	}
  
}
speciality_desc=speciality_desc==null?"":speciality_desc;
speciality_desc=speciality_desc.equals("null")?"":speciality_desc;

order_catalog_desc=order_catalog_desc==null?"":order_catalog_desc;
order_catalog_desc=order_catalog_desc.equals("null")?"":order_catalog_desc;



%>
<form name="OperProcForm" id="OperProcForm"  onload='FocusFirstElement(); '  action="../../servlet/eOT.OperationsProceduresServlet" method="post" target="messageFrame"> 

<table border=0 align='center' cellspacing=0 cellpadding=3 width='100%'  >

<tr>
	<td class=label width='25%' >
		<fmt:message key="Common.speciality.label" bundle="${common_labels}"/>
	</td>
	<td width='25%' class="fields" colspan="3">
		<input style="text-transform:uppercase" type="text" name="speciality_desc" id="speciality_desc" <%=disable_oper_code%> value="<%=speciality_desc%>"  size='25' maxlength="60" onBlur="if(this.value!='')searchSpeciality(speciality_desc,speciality_code);else clearValues();"><input type="button" class="button" <%=cat_dis_flag%> value="?" name="splty" onClick="searchSpeciality(speciality_desc,speciality_code);searchOrderType(speciality_desc);" ><img src='../../eCommon/images/mandatory.gif'>
		<input type='hidden' name='speciality_code' id='speciality_code'  value="<%=speciality_code%>">
	</td>
</tr>
<tr>
	<td width="25%" class="label" nowrap>
		<fmt:message key="eOT.ProcedureCodingScheme.Label" bundle="${ot_labels}"/> 
	</td>
	<td width='25%' class="fields" colspan="3">
	<!--
				<select name="diag_code_scheme" id="diag_code_scheme" value="" > 
				<option value="1" >
					<fmt:message key="Common.UserDefined.label" bundle="${common_labels}"/> 
				</option>
				<option value="2" >
					<fmt:message key="Common.icd10pcs.label" bundle="${common_labels}"/> 
				</option>
				<option value="3" >
					<fmt:message key="Common.CPT4.label" bundle="${common_labels}"/> 
				</option>
				<option value="4" >
					<fmt:message key="Common.ICD9CM.label" bundle="${common_labels}"/> 
				</option>		
			  </select>
	-->

		<input type="hidden" name="diag_code_scheme" id="diag_code_scheme" value="<%=diag_code_scheme%>"   >
		<input type="text" name="diag_code_scheme_desc" id="diag_code_scheme_desc" value="<%=diag_code_scheme_desc%>"   size='25'  maxlength='15'  disabled>

	  </td>
</tr>
<tr>
	<td class=label width='25%' nowrap>
			<fmt:message key="eOT.OperationCode.Label" bundle="${ot_labels}"/>
	</td>
		<td width='32%' class="fields" >
			<input style="text-transform:uppercase" type="text" name="oper_code" id="oper_code" value="<%=oper_code%>" size='25'  maxlength=10 onkeypress="return CheckForSpecChars(event)" <%=disable_oper_code%> onBlur='ChangeUpperCase(this);' >
			<input type='button' class='button' value='?' name='opercode' id='opercode' onClick="searchOperlkp(oper_code,long_desc);" disabled><img src='../../eCommon/images/mandatory.gif'>
		</td>
	<td class=label width='25%' >
		<fmt:message key="Common.enabled.label" bundle="${common_labels}"/>
		<input type="checkbox" name="status" id="status" onClick='setCheckValue();' value='<%=chk_value%>' <%=chk_checked%> >
	</td>
	<td width='25%' class="fields" >
	
	</td>
</tr>

<tr>
	<td class=label width='25%' >
			<fmt:message key="Common.longdescription.label" bundle="${common_labels}"/>
	</td>
	<td width='25%' class="fields" colspan='3'>
			<input type="text" name="long_desc" id="long_desc" value="<%=long_desc%>"  size='60' maxlength='60'> <!-- Modified Against ML-MMOH-CRF-0432 -->
			<img src='../../eCommon/images/mandatory.gif'>
	</td>
	
</tr>
	
<tr>
	<td class=label width='25%' >
			<fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/>
	</td>
	<td width='25%' class="fields" colspan='3'>
		<input type="text" name="short_desc" id="short_desc" value="<%=short_desc%>" onkeypress="return restrictSpecialChars_op(event);" size='40' maxlength='40' > <!-- Modified Against ML-MMOH-CRF-0432 -->
			<img src='../../eCommon/images/mandatory.gif'>
	</td>
	<!-- Added against ML-BRU-SCF-1401 (restrictSpecialChars_op) -->
</tr> 

<tr>
	<td class=label width='25%' >
		<fmt:message key="eOT.OperationType.Label" bundle="${ot_labels}"/>
	</td>
	<td width='25%' class="fields" colspan='3'>
			<input type='text' name='oper_type_desc' id='oper_type_desc' size='25'  value="<%=oper_type_desc%>"  onBlur="oper_type_validate(this,oper_type_code,oper_type_desc);" ><input type='hidden' name='oper_type_code' id='oper_type_code'  value="<%=oper_type_code%>" ><input type='button' class='button' value='?' name='opertype' id='opertype' onClick="searchlkp('Operation Type Search',operationType,oper_type_code,oper_type_desc);"><img src='../../eCommon/images/mandatory.gif'>
	</td>
	
</tr>
<tr>
<%
if(!mode.equals("modify")){
%>
	<td class="label" width="25%" >
		<fmt:message key="Common.LinkCatalog.label" bundle="${common_labels}"/>
	</td>
	<td class="label" width="25%" >
		<input type="checkbox" name="link_status" id="link_status" onClick='setLinkValue();' value='<%=chk_value%>' onBlur="" >
	</td>
<%
	}
%>
	<td class='label' width='25%'>
		<fmt:message key="Common.OrderType.label" bundle="${common_labels}"/>

	<%
		if(order_type_desc.equals("")){
	%>

		<select name="order_type" id="order_type">
			<option value=""><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></option>
		</select>
		<% if(link_status.equals("")){%>
			<img id="img1" src='../../eCommon/images/mandatory.gif' >
		<%}else{%>
			<img id="img1" src='../../eCommon/images/Blank1.gif' >
		<%}
		}else{
	%>
		<td class='fields' width='25%' colspan="3">
		<input type="text" name="order_type_desc" id="order_type_desc" value='<%=order_type_desc%>' readOnly>
	<%
		}
	%>
	</td>
	<td class='fields' width='25%'>
	</td>
</tr>
<tr>
	<td class=label width='25%' >
			<fmt:message key="Common.CatalogCrossReference.label" bundle="${common_labels}"/>
	</td>
	<td width='25%' class="fields" colspan='3'>
			<input type='text' name='order_catalog_desc' id='order_catalog_desc' size='25' maxlength='30' value="<%=order_catalog_desc%>" <%=cat_dis_flag%> 
			onBlur="if(this.value!='')searchOrderCatlkp('Order Catalog Search',orderCatalog ,order_catalog_code, order_catalog_desc);" readOnly><input type='hidden' name='order_catalog_code' id='order_catalog_code'  value="<%=order_catalog_code%>" ><input type='button' class='button' value='?' name='ordercat' id='ordercat' onClick="searchOrderCatlkp('Order Catalog Search',orderCatalog ,order_catalog_code, order_catalog_desc);"  <%=cat_dis_flag%> disabled>
			
<% if(order_catalog_desc.equals("")){%>
			<img id="img2" src='../../eCommon/images/Blank1.gif' ></td>
		<%}else{%>
			<img id="img2" src='../../eCommon/images/mandatory.gif' ></td>
		<%}%>
	</td>
</tr>

<tr>
	<td class=label width='25%' >
			<fmt:message key="Common.duration.label" bundle="${common_labels}"/>
	</td>
	<td width='25%' class="fields" colspan='3'>
			<input type='text' name='duration' id='duration' size='6' maxlength='5' value="<%=duration%>" onkeypress="return checkForSpecCharsforID(event);" onBlur="validateDuration(this)"><img src='../../eCommon/images/mandatory.gif'> (hh24:mi)
	</td>	
</tr>	

<tr>
	<td class=label width='25%'>
			<fmt:message key="eOT.SideApplicable.Label" bundle="${ot_labels}"/>
	</td>
	<td class="fields" width="25%" colspan="3">
			<input type="checkbox" name="side_appl" id="side_appl" onClick='checkVal();' value='<%=side_appl%>' <%=side_checked%> >
	</td>	
</tr>
</table>
<table border=0 align='centre' cellspacing=0 cellpadding=3 width='100%'  >
<tr>

	<td class=label width='25%' >
			<fmt:message key="eOT.PreOperativeCheckList.Label" bundle="${ot_labels}"/>
	</td>
	<td width='25%' class="fields" >
			<input type='hidden' name='pre_op_check_list' id='pre_op_check_list'  value="<%=pre_op_check_list%>">
			<input type='text' name='pre_op_check_list_desc' id='pre_op_check_list_desc' size='25' maxlength='60' value="<%=pre_op_check_list_desc%>" onBlur="if(this.value!='')searchlkp('Checklist Search',checklist, pre_op_check_list,pre_op_check_list_desc); else pre_op_check_list.value='' "><input type='button' class='button' value='?' name='prechk' id='prechk' onClick="searchlkp('Checklist Search',checklist, pre_op_check_list,pre_op_check_list_desc);" >
		</td>
	<td></td><td></td>

</tr>

<tr>		
	<td class=label width='25%'>
		<fmt:message key="eOT.PostOperativeCheckList.Label" bundle="${ot_labels}"/>
	</td>
	<td width='25%' class="fields" >
			<input type='hidden' name='post_op_check_list' id='post_op_check_list'  value="<%=post_op_check_list%>">
			<input type='text' name='post_op_check_list_desc' id='post_op_check_list_desc' size='25' maxlength='30' value="<%=post_op_check_list_desc%>" onBlur="if(this.value!='')searchlkp('Checklist Search',checklist, post_op_check_list,post_op_check_list_desc); else post_op_check_list.value=''" ><input type='button' class='button' value='?' name='postchk' id='postchk' onClick="searchlkp('Checklist Search',checklist, post_op_check_list,post_op_check_list_desc);" >
	</td>
		<td></td><td></td>
</tr>


<tr>		
	<td class=label width='25%'> 
		<fmt:message key="eOT.SwabandInstrumentCount.Label" bundle="${ot_labels}"/>
	</td>
	<td width='25%' class="fields" >
			<input type='hidden' name='swab_instr_tmpl_id' id='swab_instr_tmpl_id'  value="<%=swab_instr_tmpl_id%>">
			<input type='text' name='swab_instr_tmpl_desc' id='swab_instr_tmpl_desc' size='25' maxlength='30' value="<%=swab_instr_tmpl_desc%>" onBlur="if(this.value!='')searchlkp('Swab / Instrument Template Search', swabandInstrumentCount,swab_instr_tmpl_id,swab_instr_tmpl_desc); else swab_instr_tmpl_id.value=''" ><input type='button' class='button' value='?' name='swab' id='swab' onClick="searchlkp('Swab / Instrument Template Search', swabandInstrumentCount,swab_instr_tmpl_id,swab_instr_tmpl_desc);" >
	</td>
		<td></td><td></td>
</tr>
	<input type='hidden' name='instr_in_english_' id='instr_in_english_'  value="">
	<input type='hidden' name='instr_in_local_' id='instr_in_local_'  value="">
<tr>		
	<td class=label width='25%' >
			<fmt:message key="Common.category1.label" bundle="${common_labels}"/>
	</td>
	<%
	if(mode.equals("modify")){
	%>
		<td width='25%' class="fields" >
			<input type='hidden' name='oper_cat_code' id='oper_cat_code'  value="<%=oper_cat_code%>">
			<input type='text' name='oper_cat_desc' id='oper_cat_desc' size='25' maxlength='30' value="<%=oper_cat_desc%>" 
			onBlur="if(this.value!='')searchlkp('Category Search',category, oper_cat_code,oper_cat_desc); else oper_cat_code.value=''" readonly disabled><!-- <input type='button' class='button' value='?' name='catg' id='catg' disabled
			onClick="searchlkp('Category Search',category, oper_cat_code,oper_cat_desc);" > -->
	</td>
		<td></td><td></td>
	<%} else {%>
	<td width='25%' class="fields" >
			<input type='hidden' name='oper_cat_code' id='oper_cat_code'  value="<%=oper_cat_code%>">
			<input type='text' name='oper_cat_desc' id='oper_cat_desc' size='25' maxlength='30' value="<%=oper_cat_desc%>" 
			onBlur="if(this.value!='')searchlkp('Category Search',category, oper_cat_code,oper_cat_desc); else oper_cat_code.value=''"><input type='button' class='button' value='?' name='catg' id='catg'
			onClick="searchlkp('Category Search',category, oper_cat_code,oper_cat_desc);" >
	</td>	<td></td><td></td>
	<%}%>
</tr>

<tr>		
	<td class=label width='25%' >
		<fmt:message key="eOT.SubCategory.Label" bundle="${ot_labels}"/>
	</td>
	<%
	if(mode.equals("modify")){
	%>

	<td width='25%' class="fields" >
			<input type='hidden' name='oper_sub_cat_code' id='oper_sub_cat_code'  value="<%=oper_sub_cat_code%>">
			<input type='text' name='oper_sub_cat_desc' id='oper_sub_cat_desc' size='25' maxlength='30' value="<%=oper_sub_cat_desc%>"
			onBlur="if(this.value!='')searchlkp('Sub Category Search',subCategory, oper_sub_cat_code,oper_sub_cat_desc); else oper_sub_cat_code.value='' " readonly disabled><!-- <input type='button' class='button' value='?' name='subcatg' id='subcatg' onClick="searchlkp('Sub Category Search',subCategory, oper_sub_cat_code,oper_sub_cat_desc);" disabled > -->
	</td>	<td></td><td></td>
	<%}else {%>
		<td width='25%' class="fields" >
			<input type='hidden' name='oper_sub_cat_code' id='oper_sub_cat_code'  value="<%=oper_sub_cat_code%>">
			<input type='text' name='oper_sub_cat_desc' id='oper_sub_cat_desc' size='25' maxlength='30' value="<%=oper_sub_cat_desc%>"
			onBlur="if(this.value!='')searchlkp('Sub Category Search',subCategory, oper_sub_cat_code,oper_sub_cat_desc); else oper_sub_cat_code.value='' "><input type='button' class='button' value='?' name='subcatg' id='subcatg' onClick="searchlkp('Sub Category Search',subCategory, oper_sub_cat_code,oper_sub_cat_desc);" >
	</td>	<td></td><td></td>

	<%}%>
	
</tr>
<!-- 
 <tr>
	<td class=label width='25%' >Patient Information Document</td>
	<td width='25%' class="fields"><input type="text" name="patient_info_file_id" id="patient_info_file_id" value="<%=patient_info_file_id%>"  size=60 maxlength=100   > <input type='button' class='button' value='?' name='open_dialog' id='open_dialog' title="Open Dialog Window"> <input type='button' class='button' value='?' name='open_doc' id='open_doc' title="Open Specified File"> </td>
	<td  colspan="6"></td>
</tr> -->
  </table> 

<table border=0 cellspacing=0 cellpadding=3 width='100%'  align='center'> 

<tr>
		<td class="label">
				<fmt:message key="eOT.StandardInstructions.Label" bundle="${ot_labels}"/>
		</td>
		<td class="label" colspan=3>
				<fmt:message key="eOT.StandInstrnsinLocalLang.Label" bundle="${ot_labels}"/>
		</td>
</tr>
<tr>
	  
	  <td class="label" width="58%">
			<textarea  rows="5" cols="40" name="instr_in_english" value="" disabled > 
			</textarea>
		</td>
		
		<td class="label" colspan=3>
			<textarea rows="5" cols="40" name="instr_in_local" value="" disabled > 
			</textarea>
		</td>
</tr> 


</table>

<input type='hidden' name='mode' id='mode' value='<%=mode%>'>
<input type='hidden' name='oper_code_scheme' id='oper_code_scheme' value="<%=oper_code_scheme%>">
<input type='hidden' name='oper_code_scheme_desc' id='oper_code_scheme_desc' value="<%=diag_code_scheme_desc%>">
<input type='hidden' name='type' id='type'  value="appt_time">
<input type='hidden' name='order_type_code' id='order_type_code'  value="">
<input type='hidden' name='diag_code_scheme_ot_param' id='diag_code_scheme_ot_param'  value="">
<input type='hidden' name='duration_db_value' id='duration_db_value' value='<%=duration_db_value_jsp%>'>
<input type='hidden' name='order_catalog_code1' id='order_catalog_code1' value='<%=order_catalog_code%>'>
<input type='hidden' name='side_appl1' id='side_appl1' value='<%=side_appl%>'>
<input type='hidden' name='db_oper_cat_code' id='db_oper_cat_code'     value='<%=db_oper_cat_code%>'>
<input type='hidden' name='db_oper_sub_cat_code' id='db_oper_sub_cat_code' value='<%=db_oper_sub_cat_code%>'>
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
<input type='hidden' name='params' id='params' value="<%=request.getQueryString()%>">
</form>

</body>
</html>

<SCRIPT LANGUAGE="JavaScript">
	check_ena_dis(); 
	if(document.OperProcForm.mode.value=="modify"){
		getDtlsForQuery();
	}
</SCRIPT> 



