<!DOCTYPE html>
<!-- 
	Developer   : Muraleedhar
	Created On  : 01/02/2009
 -->


<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager" contentType=" text/html;charset=UTF-8" %>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
 String locale = (String)session.getAttribute("LOCALE"); 
 request.setCharacterEncoding("UTF-8"); %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eOH/jsp/StringUtil.jsp"%>
<%
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	String mode=checkForNull(request.getParameter("mode"));
	String reason_code = checkForNull(request.getParameter("reason_code"));

	String disable_flag = "";
	String chk_value="E";
	String eff_status="";
	String chk_checked="checked";
	String reason_code_disabled="";
	String trmt_category_type_code = "";
	String trmt_category_type_desc = "";
	String trmt_category_type = "";
	String reason_desc = "";
	String trmt_cat_type_checked = "";
	String applicable_yn = "";
	String readonly_flag = "";
	int row=0;

	try{
		con=ConnectionManager.getConnection(request);

		if(mode.equals("modify")){
			pstmt=con.prepareStatement("SELECT A.REASON_DESC, NVL(A.EFF_STATUS,'E') EFF_STATUS FROM OH_REASON_LANG_VW A WHERE A.REASON_CODE = ? AND A.LANGUAGE_ID = ?");
			pstmt.setString(1,reason_code);
			pstmt.setString(2,locale);
			rs=pstmt.executeQuery();
			while(rs!=null && rs.next()){
				reason_desc=checkForNull(rs.getString("REASON_DESC"));
				eff_status=rs.getString("EFF_STATUS");
			}


			if(eff_status.equals("E"))
			{
				chk_checked="checked";
				disable_flag="";
				readonly_flag = "";
			}
			else
			{
				chk_checked="";
				disable_flag="disabled";
				readonly_flag = "readonly";
				chk_value="D";
			}

			reason_code_disabled="disabled";	
		}

%>

<html>
<head>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script language='javascript' src='../../eOH/js/MFailureRemarks.js'></script>
<script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script Language="JavaScript" src="../../eOH/js/OHCommonMasters.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<body onLoad="parent.commontoolbarFrame.document.forms[0].apply.disabled=false;" OnMouseDown='CodeArrest()' onKeyDown="lockKey()">

<form name="MFailureReasonForm" id="MFailureReasonForm"  onload='FocusFirstElement()'  action="../../servlet/eOH.MFailureRemarks" method="post" target="messageFrame"> 
<br><br><br><br>
<table border=0 cellspacing=0 cellpadding=3 width='90%'  align=center>
<tr>
	<td width='35%'></td>
	<td width='65%'></td>
</tr>
<tr>
	<td class=label width="25%">
		<fmt:message key="eOH.ReasonCode.Label" bundle="${oh_labels}"/>
	</td>
	<td class="fields" width="25%" colspan="3">
		<input type="text" name="reason_code" id="reason_code" value="<%=reason_code%>" size="10" maxlength="5" <%=reason_code_disabled%> onkeypress="return CheckForSpecChars(event)"  onBlur="ChangeUpperCase(this)" >
		<img src='../../eCommon/images/mandatory.gif'>
	</td>
</tr>
<tr>
	<td class=label width="25%">
		<fmt:message key="eOH.ReasonDescription.Label" bundle="${oh_labels}"/>
	</td>
	<td class="fields" width="25%" colspan="3">
		<textarea name="reason_desc" rows="5" cols="67" <%=disable_flag%> onblur="ChkMaxchar(200);" ><%=reason_desc%></textarea><img src='../../eCommon/images/mandatory.gif'>
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

<tr></tr><tr></tr><tr></tr>
<tr>
	<td class="CAGROUPHEADING" width="25%" colspan="2"nowrap><fmt:message key="eOH.TreatmentCategoryType.Label" bundle="${oh_labels}"/></td>
</tr>
		<%
					
					if(rs!=null) rs.close();
					if(pstmt!=null) pstmt.close();
					//pstmt=con.prepareStatement("SELECT TRMT_CATEGORY_TYPE, TRMT_CATEGORY_TYPE_DESC FROM OH_TREATMENT_CATEGORY_TYPE WHERE SPLTY_MODULE_ID = ? ORDER BY TRMT_CATEGORY_TYPE_DESC");
					pstmt=con.prepareStatement("SELECT B.TRMT_CATEGORY_TYPE TRMT_CAT_TYPE, B.APPLICABLE_YN, A.TRMT_CATEGORY_TYPE, A.TRMT_CATEGORY_TYPE_DESC FROM OH_TREATMENT_CATEGORY_TYPE A,OH_REASONS_DTLS B WHERE A.SPLTY_MODULE_ID = ? AND A.TRMT_CATEGORY_TYPE = B.TRMT_CATEGORY_TYPE(+) AND B.REASON_CODE(+) = ? ORDER BY A.TRMT_CATEGORY_TYPE_DESC");
					pstmt.setString(1,"OH");					
					pstmt.setString(2,reason_code);					
					rs=pstmt.executeQuery();
					while(rs!=null && rs.next()){
						row++;
						trmt_category_type=checkForNull(rs.getString("TRMT_CAT_TYPE"));
						trmt_category_type_code=rs.getString("TRMT_CATEGORY_TYPE");
						trmt_category_type_desc=rs.getString("TRMT_CATEGORY_TYPE_DESC");
						applicable_yn=rs.getString("APPLICABLE_YN");
						
							if(!trmt_category_type.equals("") && applicable_yn.equals("Y")){
								trmt_cat_type_checked = "checked";
							}
							else{
								trmt_cat_type_checked = "";
							}
			%>
			<tr>		
				<td class="label" width = "25%"> <%=trmt_category_type_desc%> </td>
				<td class="text" width = "35%" > 
					<input type = "checkbox" name="chk_<%=row%>" id="chk_<%=row%>" value='<%=trmt_cat_type_checked%>' onClick="assignValue(this,'<%=row%>');" <%=trmt_cat_type_checked%> <%=disable_flag%>>
				</td>
				<input type = "hidden" name="trmt_category_type_code_<%=row%>" id="trmt_category_type_code_<%=row%>" value="<%=trmt_category_type_code%>">
				<input type = "hidden" name="chk1_<%=row%>" id="chk1_<%=row%>" value="<%=applicable_yn%>" >
			</tr>
		<%
			}
		%>

<tr>
	<td width='35%'></td>
	<td width='65%'></td>
</tr>
</table>
	<input type='hidden' name='mode' id='mode' value='<%=mode%>'>
	<input type='hidden' name='locale' id='locale' value="<%=locale%>">
	<input type='hidden' name='row_count' id='row_count' value="<%=row%>">
	<input type='hidden' name='splity_module_id' id='splity_module_id' value="OH">
	<input type='hidden' name='reason_code1' id='reason_code1' value="<%=reason_code%>">
	<input type='hidden' name='reason_desc1' id='reason_desc1' value="<%=reason_desc%>">
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


