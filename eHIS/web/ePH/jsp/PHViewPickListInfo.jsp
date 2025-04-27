<!DOCTYPE html>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*" %>
<HTML>
<HEAD>
	
<% 
request.setCharacterEncoding("UTF-8");

//ends

String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?
(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; %>
 
 <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

 <link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'type='text/css'></link> 


	
	<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><script LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../../ePH/js/PhCommon.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
</HEAD>

<%
	String disp_locn_desc			 = request.getParameter("disp_locn_desc");
	String Nursing_Unit_From_desc	 = request.getParameter("Nursing_Unit");
	String OrderingFacility_desc	 = request.getParameter("OrderingFacility_desc");
	String Nursing_Unit_From_Code	 = request.getParameter("Nursing_Unit_From_Code");
	//String Nursing_Unit_To_desc =(request.getParameter("Nursing_Unit_To_desc")==null)?"":request.getParameter("Nursing_Unit_To_desc");
	String Proc_Type				 = "";
		   if(Proc_Type.equals("R"))
		   {Proc_Type = "Routine";}
		   else if(Proc_Type.equals("I"))
		   {Proc_Type="Incremental";}
	String schedule_start			 = request.getParameter("schedule_start");
	String Ip_Fill_Prd_Ahead		 = request.getParameter("Ip_Fill_Prd_Ahead");
	//Ip_Fill_Prd_Ahead = (Integer.parseInt(Ip_Fill_Prd_Ahead)/24)+"";
	String fill_int_start_date_time  = request.getParameter("fill_int_start_date_time");
	String fill_int_end_date_time	 = request.getParameter("fill_int_end_date_time");
%>
<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
<FORM name="formPHGenerateFillList" id="formPHGenerateFillList"  TARGET="messageFrame" >
<br>
<TABLE  CLASS="BOX" ALIGN="center" CELLPADDING="0" CELLSPACING="0" BORDER="0" width="100%">
	<TR>
		 <TD class="BODYCOLORFILLED" ALIGN="right" width="15%" nowrap>
			<font size="1"><b><fmt:message key="Common.OrderingFacility.label" bundle="${common_labels}"/></b> &nbsp;
		 </TD>
		 <TD class="BODYCOLORFILLED" ALIGN="left" width="20%" nowrap >
			<font size="1"><%=OrderingFacility_desc%>
		 </TD>
	</TR>	
	<TR>										  
		<TD class="BODYCOLORFILLED" ALIGN="right" width="15%" nowrap><font size="1"><b><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></b> &nbsp;</TD>
		<TD class="BODYCOLORFILLED" ALIGN="left"  width="20%" nowrap><font size="1"><%=Nursing_Unit_From_desc%> </TD>
		
	</TR>													 
	<TR>															  
		<TD class="BODYCOLORFILLED" ALIGN="right"  ><font size="1"><b><fmt:message key="ePH.DispenseLocation.label" bundle="${ph_labels}"/></b> &nbsp;</TD>
		<TD class="BODYCOLORFILLED" ALIGN="left"   ><font size="1"><%=disp_locn_desc%></TD>
		<TD class="BODYCOLORFILLED" ALIGN="right"  ><font size="1"><b><fmt:message key="ePH.EffectiveStartTime.label" bundle="${ph_labels}"/></b> &nbsp;</TD>
		<TD class="BODYCOLORFILLED" ALIGN="left"   ><font size="1"><%=fill_int_start_date_time%></TD>
		<TD class="BODYCOLORFILLED" ALIGN="right"  ><font size="1"><b><fmt:message key="Common.EndTime.label" bundle="${common_labels}"/></b> &nbsp;</TD>
		<TD class="BODYCOLORFILLED" ALIGN="left"   ><font size="1"><%=fill_int_end_date_time%></TD>
	</TR>
	<th height="2" colspan="6"></th>   
</TABLE>
	<table border='0' cellpadding='0' cellspacing='0' width=100% align=center>
		<tr>
			<th width="27%"><fmt:message key="Common.PatientDetails.label" bundle="${common_labels}"/></th>
			<th colspan=2 width="28%"><fmt:message key="Common.Ordered.label" bundle="${common_labels}"/></th>
			<th colspan=2 width="27%"><fmt:message key="ePH.Dispense.label" bundle="${ph_labels}"/></th>
			<th width="14%"><fmt:message key="Common.current.label" bundle="${common_labels}"/> 
			    <fmt:message key="Common.Qty.label" bundle="${common_labels}"/></th>
			<th><fmt:message key="ePH.Select.label" bundle="${ph_labels}"/></th>
		</tr>
		<tr>
			<th width="25%">&nbsp;</th>
			<th><fmt:message key="Common.Drug.label" bundle="${common_labels}"/></th>
			<th align="right"><fmt:message key="Common.Qty.label" bundle="${common_labels}"/>&nbsp;&nbsp;&nbsp;</th>
			<th><fmt:message key="Common.Drug.label" bundle="${common_labels}"/></th>
			<th align="right"><fmt:message key="Common.Qty.label" bundle="${common_labels}"/>&nbsp;&nbsp;&nbsp;</th>
			<th>&nbsp;</th>
			<th>&nbsp;</th>
		</tr>
</table>
<!-- 	<TR>
		<Th ALIGN="left" width="25%" nowrap>&nbsp;</Th>
		<Th ALIGN="left"  width="20%" nowrap><b>Drug&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Qty</b></Th>
		<Th ALIGN="right" width="20%" nowrap><b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Drug &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Total Qty</b></Th>
		<Th ALIGN="right"  width="6%" nowrap><b>Current Qty</b></Th>
		<Th ALIGN="center" width="5%" nowrap>All</Th>
	</TR> -->
	<input type="hidden" name="Nursing_Unit_From_Code" id="Nursing_Unit_From_Code" value="<%=Nursing_Unit_From_Code %>">
	<input type="hidden" name="fill_int_start_date_time" id="fill_int_start_date_time" value="<%=fill_int_start_date_time %>">
	<input type="hidden" name="fill_int_end_date_time" id="fill_int_end_date_time" value="<%=fill_int_end_date_time %>">
</form>
</BODY>
</HTML>

