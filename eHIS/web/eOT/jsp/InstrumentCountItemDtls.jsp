<!DOCTYPE html>

<!--
Developed by    : Bhavani Shankar.
Module/Function : Frame having Items of the selected tray/set
Start Date		: 21/02/2006
-->
<%@page   import="eOT.*,eOT.Common.*, eCommon.Common.CommonBean, ,java.util.HashMap,java.sql.Connection,  java.sql.PreparedStatement, java.sql.ResultSet, webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper,eCommon.Common.*" %>
<%@page  contentType="text/html;charset=UTF-8" %>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");%>
<%@include file="../../eCommon/jsp/Common.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>

<html>
<head>
	<script language="javascript" src="../../eCommon/js/common.js"></script>

<%
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eOT/js/InstrumentCount.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	
	
	<script>
		var general_title=getLabel("Common.general.label","common");
		var final_title=getLabel("Common.final.label","common");
		var initial_title=getLabel("eOT.Initial.Label","OT");
	</script>

</head>
<title>
<fmt:message key="eOT.InstrumentCount.Label" bundle="${ot_labels}"/></title>
<%
	String params = request.getQueryString();
	String booking_num	= request.getParameter("booking_num");
	String oper_num		= request.getParameter("oper_num");
	String patient_id	= request.getParameter("patient_id");
	String set_code	= request.getParameter("set_code");
	String oper_code	= request.getParameter("set_oper_code");
	String tray_num	= request.getParameter("tray_num");
	booking_num	=booking_num==null?"":booking_num;
	booking_num	=booking_num.equalsIgnoreCase("null")?"":booking_num;
	oper_num	=oper_num==null?"":oper_num;
	oper_num	=oper_num.equalsIgnoreCase("null")?"":oper_num;
	String item_code 	= "",consumable_yn= "",item_name	= "",std_qty		= "",cssd_qty		= "",open_qty		= "",initial_status	= "",return_qty	= "",final_status	= "",general_remarks = "",initial_status_remarks = "",final_remarks = "";
	Connection connection   = null ;
	PreparedStatement pstmt = null ;
	ResultSet rs = null ;
	String bean_id	 = "InstrumentCountBean";
	String bean_name = "eOT.InstrumentCountBean";
	InstrumentCountBean bean = (InstrumentCountBean)mh.getBeanObject( bean_id, request, bean_name );
	HashMap oper_set_tray_map = (HashMap)bean.getSetDetails(oper_code+set_code+tray_num);
	HashMap item_map = null;
	int row_num = 0;
	try{
%>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form name="InstrumentCountItemDtlsForm" id="InstrumentCountItemDtlsForm">
<table cellpadding=3  cellspacing="0" width="100%" align="center" border="1">
	<tr id="instr_count_item_dtls_hdr_table">
		<td class="columnHeader" nowrap >
		<fmt:message key="Common.item.label" bundle="${common_labels}"/>
		</td>
		<td class="columnHeader" nowrap  >
		<fmt:message key="eOT.StdQty.Label" bundle="${ot_labels}"/>
		</td>
		<td class="columnHeader" nowrap  >
		<fmt:message key="eOT.CSSDQty.Label" bundle="${ot_labels}"/>
		</td>
		<td class="columnHeader" nowrap  >
		<fmt:message key="eOT.OpenQty.Label" bundle="${ot_labels}"/>
		</td>
		<td class="columnHeader" nowrap >
		<fmt:message key="eOT.InitialStatus.Label" bundle="${ot_labels}"/>
		</td>
		<td class="columnHeader"  nowrap >
		<fmt:message key="Common.remarks.label" bundle="${common_labels}"/> 
		</td>
		<td class="columnHeader" nowrap >
		<fmt:message key="Common.ReturnQty.label" bundle="${common_labels}"/>
		</td>
		<td class="columnHeader"  nowrap >
		<fmt:message key="eOT.FinalStatus.Label" bundle="${ot_labels}"/>
		</td>
		<td class="columnHeader"  nowrap >
		<fmt:message key="Common.final.label" bundle="${common_labels}"/>
		</td>
		<td class="columnHeader"  nowrap  >
		<fmt:message key="Common.general.label" bundle="${common_labels}"/>
		</td>
	</tr>		

<%
	String classvalue = "",initial_count_cmpl_yn = "",final_count_cmpl_yn = "",initial_disabled="",final_disabled="",return_disabled = "",return_title = "";
	for(int i=1;i<=oper_set_tray_map.size();i++){
		item_map=(HashMap)oper_set_tray_map.get(i+"");
		row_num++;
		if ( row_num % 2 == 0 )
			classvalue = "QRYODD" ;
		else
			classvalue = "QRYEVEN" ;
		initial_count_cmpl_yn	= (String)item_map.get("INITIAL_COUNT_CMPL_YN");
		final_count_cmpl_yn		= (String)item_map.get("FINAL_COUNT_CMPL_YN");
		item_code = (String)item_map.get("ITEM_CODE");
		consumable_yn = (String)item_map.get("CONSUMABLE_YN");
		consumable_yn=consumable_yn==null?"N":consumable_yn;
		consumable_yn=consumable_yn.equals("null")?"N":consumable_yn;
		return_disabled="";
		return_title="";
		if(initial_count_cmpl_yn.equals("Y"))
			initial_disabled = "disabled";
		if(final_count_cmpl_yn.equals("Y")){
			final_disabled = "disabled";
			return_disabled= "disabled";
		}
		if(consumable_yn.equals("Y")){
			return_disabled= "disabled";
		}
		item_name = (String)item_map.get("ITEM_NAME");
		item_name=item_name==null?"":item_name;
		item_name=item_name.equals("null")?"":item_name;
		std_qty = (String)item_map.get("STD_QTY");
		std_qty=std_qty==null?"":std_qty;
		std_qty=std_qty.equalsIgnoreCase("null")?"":std_qty;
		cssd_qty = (String)item_map.get("CSSD_QTY");
		cssd_qty=cssd_qty==null?"":cssd_qty;
		cssd_qty=cssd_qty.equalsIgnoreCase("null")?"":cssd_qty;
		open_qty = (String)item_map.get("OPEN_QTY");
		open_qty=open_qty==null?"":open_qty;
		open_qty=open_qty.equalsIgnoreCase("null")?"":open_qty;
		if(cssd_qty.equals(""))
		{
			cssd_qty=std_qty;
		}
		if(open_qty.equals(""))
		{
			open_qty=std_qty;
		}
		initial_status = (String)item_map.get("INITIAL_STATUS");
		initial_status=initial_status==null?"":initial_status;
		initial_status=initial_status.equalsIgnoreCase("null")?"":initial_status;
		return_qty = (String)item_map.get("RETURN_QTY");
		return_qty=return_qty==null?"":return_qty;
		return_qty=return_qty.equalsIgnoreCase("null")?"":return_qty;
		final_status = (String)item_map.get("FINAL_STATUS");
		final_status=final_status==null?"":final_status;
		final_status=final_status.equalsIgnoreCase("null")?"":final_status;
		general_remarks = (String)item_map.get("GENERAL_REMARKS");
		general_remarks=general_remarks==null?"":general_remarks;
		general_remarks=general_remarks.equalsIgnoreCase("null")?"":general_remarks;
		initial_status_remarks = (String)item_map.get("INITIAL_STATUS_REMARKS");
		initial_status_remarks=initial_status_remarks==null?"":initial_status_remarks;
		initial_status_remarks=initial_status_remarks.equalsIgnoreCase("null")?"":initial_status_remarks;
		final_remarks = (String)item_map.get("FINAL_REMARKS");
		final_remarks=final_remarks==null?"":final_remarks;
		final_remarks=final_remarks.equalsIgnoreCase("null")?"":final_remarks;	
%>
<tr>
	<input type="hidden" name="item_code_<%=row_num%>" id="item_code_<%=row_num%>" value="<%=item_code%>">
	<input type="hidden" name="item_name_<%=row_num%>" id="item_name_<%=row_num%>" value="<%=item_name%>">
	<input type="hidden" name="initial_status_remarks_<%=row_num%>" id="initial_status_remarks_<%=row_num%>" value="<%=initial_status_remarks%>">
	<input type="hidden" name="final_remarks_<%=row_num%>" id="final_remarks_<%=row_num%>" value="<%=final_remarks%>">
	<input type="hidden" name="general_remarks_<%=row_num%>" id="general_remarks_<%=row_num%>" value="<%=general_remarks%>">

	<td class="<%=classvalue%>" style="font-size:7pt;font-weight:normal;" nowrap wrap><%=item_name%>
	</td>
	<td class="<%=classvalue%>" style="font-size:7pt;font-weight:normal;" nowrap><%=std_qty%>
	</td>
	<td class="<%=classvalue%>" style="font-size:7pt;font-weight:normal;" nowrap><input type="text"  name="cssd_qty_<%=row_num%>" id="cssd_qty_<%=row_num%>"  maxlength="3" size="3" value="<%=cssd_qty%>" onBlur="CheckNum(this);" OnChange='changeFlag();' <%=initial_disabled%>>
	</td>
	<td align="center" class="<%=classvalue%>"  nowrap>
	<input type="text"  name="open_qty_<%=row_num%>" id="open_qty_<%=row_num%>"  maxlength="3" size="3" value="<%=open_qty%>" onBlur="CheckNum(this);" OnChange='changeFlag();' <%=initial_disabled%>>
	</td>
	<td class="<%=classvalue%>"  class="fields" nowrap>
		<select name="initial_status_<%=row_num%>" id="initial_status_<%=row_num%>" <%=initial_disabled%> OnChange='changeFlag();'>
		<%
			if(initial_status.equals("I")){
		%>
				<option value="">
				<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>
				</option>
				<option value="I" selected>
				<fmt:message key="Common.incomplete.label" bundle="${common_labels}"/>
				</option>
				<option value="C">
				<fmt:message key="Common.complete.label" bundle="${common_labels}"/>
				</option>
		<%
			}else if(initial_status.equals("C")){
		%>
				<option value="">
			------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----
				</option>
				<option value="I">
				<fmt:message key="Common.incomplete.label" bundle="${common_labels}"/>
				</option>
				<option value="C" selected>
				<fmt:message key="Common.complete.label" bundle="${common_labels}"/>
				</option>
		<%
			}else {
		%>
				<option value="" selected>------
				<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----
				</option>
				<option value="I">
				<fmt:message key="Common.incomplete.label" bundle="${common_labels}"/>
				</option>
				<option value="C" >
				<fmt:message key="Common.complete.label" bundle="${common_labels}"/>
				</option>
		<%
			}
		%>
		</select>
	</td>

	<td class="<%=classvalue%>" nowrap>
		<label style="font-size:7pt;color:blue;cursor:pointer" onClick="openRemarks(this,initial_title,'<%=row_num%>','<%=initial_disabled%>');"> <fmt:message key="Common.remarks.label" bundle="${common_labels}"/>	
		</label>
	</td>
	<td align="center" class="<%=classvalue%>"  nowrap>

<!-- Modified by DhanasekarV against issue IN026084 on 25/01/2011 -->
 <% if(consumable_yn.equals("Y")){ %>
		<input type="text"  title='<fmt:message key="eOT.ConsumableItemTooltip.Label" bundle="${ot_labels}"/>' name="return_qty_<%=row_num%>"  maxlength="3" size="3" value="<%=return_qty%>" onBlur="CheckNum(this);" OnChange='changeFlag();' <%=return_disabled%>>
  <%} else {%>
					<input type="text"  name="return_qty_<%=row_num%>" id="return_qty_<%=row_num%>"  maxlength="3" size="3" value="<%=return_qty%>" onBlur="CheckNum(this);" OnChange='changeFlag();' <%=return_disabled%>>			
		<% } %>

		<!-- end -->
	</td>
	<td align="centre" class="fields" nowrap><select name="final_status_<%=row_num%>" id="final_status_<%=row_num%>" <%=final_disabled%> OnChange='changeFlag();'>
		<%
			if(final_status.equals("I")){
		%>
				<option value="">----
				<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>
				</option>
				<option value="I" selected>
				<fmt:message key="Common.incomplete.label" bundle="${common_labels}"/>
				</option>
				<option value="C">
				<fmt:message key="Common.complete.label" bundle="${common_labels}"/>
				</option>
		<%
			}else if(final_status.equals("C")){
		%>
				<option value="">----
				<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---
				</option>
				<option value="I">
				<fmt:message key="Common.incomplete.label" bundle="${common_labels}"/>
				</option>
				<option value="C" selected>
				<fmt:message key="Common.complete.label" bundle="${common_labels}"/>
				</option>
		<%
			}else {
		%>
				<option value="" selected>----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>
				</option>
				<option value="I">
				<fmt:message key="Common.incomplete.label" bundle="${common_labels}"/>
				</option>
				<option value="C" >
				<fmt:message key="Common.complete.label" bundle="${common_labels}"/>
				</option>
		<%
			}
		%>
		</select>
	</td>
	<td class="<%=classvalue%>" nowrap>
		<label style="font-size:7pt;color:blue;cursor:pointer" onClick="openRemarks(this,final_title,'<%=row_num%>','<%=final_disabled%>');"> 
		<fmt:message key="Common.remarks.label" bundle="${common_labels}"/>
		</label>
	</td>
	<td class="<%=classvalue%>" nowrap>
		<label style="font-size:7pt;color:blue;cursor:pointer" onClick="openRemarks(this,general_title,'<%=row_num%>','');"> 
		<fmt:message key="Common.remarks.label" bundle="${common_labels}"/>	
		
		</label>
	</td>
</tr>
<%
	}
%>
</table>
<%
	}catch( Exception e ) {
		System.err.println("Caught Exception error in InstrumentCountItemDtls: "+e);
		e.printStackTrace();
	}finally {
		try{
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(connection!=null) ConnectionManager.returnConnection(connection,request);
		}catch(Exception es){es.printStackTrace();}
	}
%>
	<input type="hidden" name="params" id="params" value="<%=params%>">	
	<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
	<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
	<input type="hidden" name="booking_num" id="booking_num" value="<%=booking_num%>">
	<input type="hidden" name="oper_num" id="oper_num" value="<%=oper_num%>">	
	<input type="hidden" name="oper_code" id="oper_code" value="<%=oper_code%>">
	<input type="hidden" name="set_code" id="set_code"  value="<%=set_code%>">
	<input type="hidden" name="tray_num" id="tray_num"  value="<%=tray_num%>">
	<input type="hidden" name="patient_id" id="patient_id"  value="<%=patient_id%>">
	<input type="hidden" name="tot_count" id="tot_count"  value="<%=row_num%>">	
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
</form>
</body>
</html>

