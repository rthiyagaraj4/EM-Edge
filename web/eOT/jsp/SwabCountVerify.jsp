<!DOCTYPE html>


<%@page  contentType="text/html;charset=UTF-8" import="eOT.*, eOT.Common.*, eCommon.Common.*,webbeans.eCommon.*,java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet" %>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/Common.jsp" %>
<html>
<head>
	<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eOT/js/SwabCount.js" ></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<style>
textarea {
  resize: none;
}
</style>

	

</head>
<%
	Connection connection	= null;
	PreparedStatement pstmt = null;
	ResultSet resultset		= null;
	String facility_id	= (String) session.getValue("facility_id");
	String params		= request.getQueryString() ;
	String oper_num		= request.getParameter("oper_num");
	String initial_disabled_surg="";
	String qry_mode	=CommonBean.checkForNull(request.getParameter("qry_mode"));
	if(qry_mode.equals("YES"))
	{
		initial_disabled_surg="disabled";
	}
	String swab_serial_number	= request.getParameter("swab_serial_number");
	swab_serial_number=swab_serial_number==null?"1":swab_serial_number;
	swab_serial_number=swab_serial_number.equalsIgnoreCase("null")?"1":swab_serial_number;
	String login_user	= request.getParameter("slate_user_id");
	String disc_in_first_count = "",xray_performed = "",missing_item_found = "",data_count	= "0",checkbox_checked = "",old_remarks = "",supplementary_set = "",basic_set = "";
	String sql="SELECT COUNT(*) DATA_COUNT FROM OT_OPER_SWAB_INSTR_CNT_HDR WHERE OPERATING_FACILITY_ID=? AND OPER_NUM = ? AND SWAB_SERIAL_NUMBER=?";
	try{
		connection = ConnectionManager.getConnection(request);
		pstmt = connection.prepareStatement(sql);
		pstmt.setString(1,facility_id);
		pstmt.setString(2,oper_num);
		pstmt.setString(3,swab_serial_number);		
		resultset = pstmt.executeQuery();
		while(resultset.next()){
			data_count =resultset.getString("DATA_COUNT");
		}

		if(data_count.equals("1")){
			sql = "SELECT trim(BASIC_SET) BASIC_SET, trim(SUPPLEMENTARY_SET) SUPPLEMENTARY_SET, NVL(DISC_IN_FIRST_COUNT,'N') DISC_IN_FIRST_COUNT, NVL(XRAY_PERFORMED,'N') XRAY_PERFORMED, NVL(MISSING_ITEM_FOUND,'N') MISSING_ITEM_FOUND, REMARKS FROM OT_OPER_SWAB_INSTR_CNT_HDR WHERE OPERATING_FACILITY_ID=? AND OPER_NUM = ? AND SWAB_SERIAL_NUMBER=?";

			if(resultset!=null) resultset.close();
			if(pstmt!=null) pstmt.close();		
			pstmt=connection.prepareStatement(sql);
			pstmt.setString(1,facility_id);
			pstmt.setString(2,oper_num);
			pstmt.setString(3,swab_serial_number);		
			resultset=pstmt.executeQuery();
			while(resultset.next()){
				basic_set = resultset.getString("BASIC_SET");
				supplementary_set = resultset.getString("SUPPLEMENTARY_SET");
				
				disc_in_first_count = resultset.getString("DISC_IN_FIRST_COUNT");
				xray_performed = resultset.getString("XRAY_PERFORMED");
				missing_item_found = resultset.getString("MISSING_ITEM_FOUND");
				old_remarks = resultset.getString("REMARKS");
				if(old_remarks==null)
					old_remarks="";
			}
			basic_set=basic_set==null?"":basic_set;
			basic_set=basic_set.equalsIgnoreCase("null")?"":basic_set;
			supplementary_set=supplementary_set==null?"":supplementary_set;
			supplementary_set=supplementary_set.equalsIgnoreCase("null")?"":supplementary_set;
			old_remarks=old_remarks.trim();
			supplementary_set=supplementary_set.trim();
			basic_set=basic_set.trim();
			

		}
	}catch(Exception e){
		System.err.println("Err Msg in SwabCountVerify.jsp"+e.getMessage());
	} finally{
			if(resultset!=null)resultset.close();
			if(pstmt!=null)pstmt.close();
			if(connection!=null)
			ConnectionManager.returnConnection(connection,request);
	}
%>
<body  onKeyDown = 'lockKey()' >
<form name="SwabCountVerifyForm" id="SwabCountVerifyForm" method="POST">
<table cellpadding="3" cellspacing="0" width="100%" border="0" align='center'>
<tr>
	<td class="COLUMNHEADER" colspan="6" width="25%" ><fmt:message key="eOT.BasicSet.Label" bundle="${ot_labels}"/></td>
</tr>
	<tr>

	<!-- DhanasekarV modified against issue IN024199 on 06/10/2010  TextArea Cursor position change setCaretPosition -->
		<td colspan="6" align="center">
			<textarea align="left" rows="4" cols="60" name="basic_set" Onfocus ="setCaretPosition(this);" <%=initial_disabled_surg%>> <%=basic_set%>
				</textarea>
		</td>
	</tr>
	<!--end IN024199 -->
<tr>
	<td class="COLUMNHEADER" colspan="6" width="25%" ><fmt:message key="eOT.SupplementaryItem.Label" bundle="${ot_labels}"/></td>
</tr>

<!-- DhanasekarV modified against issue IN024199 on 06/10/2010  TextArea Cursor position change -->
	<tr>
		<td colspan="6" align="center">
			<textarea  align="left" rows="4" cols="60" name="supplementary_set" Onfocus ="setCaretPosition(this);" <%=initial_disabled_surg%>><%=supplementary_set%>
			</textarea>
		</td>
	</tr>
<!--end IN024199 -->
<tr>
	<td class="COLUMNHEADER" colspan="6" width="25%" ><fmt:message key="eOT.VerifySwabCount.Label" bundle="${ot_labels}"/></td>
</tr>

<tr>
	<%
		checkbox_checked=disc_in_first_count.equals("Y")?"checked":"";
	%>
	<td width="25%" class="label" >
	<fmt:message key="eOT.AnyDiscrepanciesinFirstCount.Label" bundle="${ot_labels}"/> 
		<input type="checkbox" name="disc_in_first_count" id="disc_in_first_count" value="<%=disc_in_first_count%>" <%=checkbox_checked%> onClick="assignSwabVerifyCheckboxValues(this)" <%=initial_disabled_surg%>>
	</td>
	<%
		checkbox_checked=xray_performed.equals("Y")?"checked":"";
	%>
	<td width="25%" class="label" ><fmt:message key="eOT.X-rayPerformed.Label" bundle="${ot_labels}"/> 
		<input type="checkbox" name="xray_performed" id="xray_performed" value="<%=xray_performed%>" <%=checkbox_checked%> onClick="assignSwabVerifyCheckboxValues(this)" <%=initial_disabled_surg%>>
	</td>
	<%
		checkbox_checked=missing_item_found.equals("Y")?"checked":"";
	%>
	<td width="25%" class="label" nowrap><fmt:message key="eOT.MissingItemFound.Label" bundle="${ot_labels}"/> 
		<input type="checkbox" name="missing_item_found" id="missing_item_found" value="<%=missing_item_found%>" <%=checkbox_checked%> onClick="assignSwabVerifyCheckboxValues(this)" <%=initial_disabled_surg%>>
	</td>
</tr>
<tr>
	<td class="COLUMNHEADER" colspan="6" width="25%" >
		<fmt:message key="Common.remarks.label" bundle="${common_labels}"/>
	</td>
</tr>

<!-- DhanasekarV modified against issue IN024199 on 06/10/2010  TextArea Cursor position change setCaretPosition -->
	<tr>
		<td colspan="6" align="center">
			<textarea width="25%" rows="4" cols="60" name="new_remarks" Onfocus ="setCaretPosition(this);" <%=initial_disabled_surg%>><%=old_remarks%>
		</textarea>
		</td>
	</tr>

<!--end IN024199 -->
</table>
	<input type="hidden" name="params" id="params" value="<%=params%>">
	<input type="hidden" name="facility_id" id="facility_id" value="<%=facility_id%>">
	<input type="hidden" name="oper_num" id="oper_num" value="<%=oper_num%>">
	<input type="hidden" name="swab_serial_number" id="swab_serial_number" value="<%=swab_serial_number%>">
	<input type="hidden" name="login_user" id="login_user" value="<%=login_user%>">
	<input type="hidden" name="old_remarks" id="old_remarks" value="<%=old_remarks%>">	
	<input type="hidden" name="data_count" id="data_count" value="<%=data_count%>">	
	<input type='hidden' name='locale' id='locale' value="<%=locale%>">

</form>
</body>


</html>

