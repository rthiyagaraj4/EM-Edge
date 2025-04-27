<!DOCTYPE html>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>

<HTML>
<HEAD>	
<% 
    request.setCharacterEncoding("UTF-8");
//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//ends
    String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; %>
 
 <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

 <link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'type='text/css'></link> 	
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../js/PhCommon.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>

<%

	String disp_locn_desc			 = request.getParameter("disp_locn_desc");
	String Nursing_Unit_From_desc	 = request.getParameter("Nursing_Unit_From_desc");
	String OrderingFacility_desc	 = request.getParameter("OrderingFacility_desc");
	String nursing_unit_or_locn	     = request.getParameter("nursing_unit_or_locn");
	String Nursing_Unit_To_desc      =(request.getParameter("Nursing_Unit_To_desc")==null)?"":request.getParameter("Nursing_Unit_To_desc");
	String Proc_Type				 = request.getParameter("Proc_Type");
		   if(Proc_Type.equals("R")){Proc_Type = "Routine";}else if(Proc_Type.equals("I")){Proc_Type="Incremental";}
	String schedule_start			 = request.getParameter("schedule_start");
	String Ip_Fill_Prd_Ahead		 = request.getParameter("Ip_Fill_Prd_Ahead");
		   Ip_Fill_Prd_Ahead         = (Integer.parseInt(Ip_Fill_Prd_Ahead)/24)+"";
	String fill_int_start_date_time  = request.getParameter("fill_int_start_date_time");
	String fill_int_end_date_time	 = request.getParameter("fill_int_end_date_time");									  
%>
<body onKeyDown="lockKey()">
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
	    <%if(nursing_unit_or_locn.equals("L")){%>
		<TD class="BODYCOLORFILLED" ALIGN="right" width="15%" nowrap><font size="1"><b><fmt:message key="ePH.BuildingName.label" bundle="${ph_labels}"/></b> &nbsp;</TD>
		<%}else{%>
		<TD class="BODYCOLORFILLED" ALIGN="right" width="15%" nowrap><font size="1"><b><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></b> &nbsp;</TD>
		<%}%>
		<TD class="BODYCOLORFILLED" ALIGN="left"  width="20%" nowrap><font size="1"><%=Nursing_Unit_From_desc%> <B>TO</B> <%=Nursing_Unit_To_desc%></TD>
		<TD class="BODYCOLORFILLED" ALIGN="right" width="25%" nowrap><font size="1"><b><fmt:message key="Common.ProcessType.label" bundle="${common_labels}"/></b> &nbsp;</TD>
		<TD class="BODYCOLORFILLED" ALIGN="left"  width="15%" nowrap><font size="1"><%=Proc_Type%></TD>
		<TD class="BODYCOLORFILLED" ALIGN="right" width="10%" nowrap><font size="1"><b>
		<fmt:message key="ePH.FillPeriod.label" bundle="${ph_labels}"/></b>  &nbsp;</TD>
		<TD class="BODYCOLORFILLED" ALIGN="left"  width="15%" nowrap><font size="1"><%=Ip_Fill_Prd_Ahead%> Days</TD>
	</TR>													 
	<TR>															  
		<TD class="BODYCOLORFILLED" ALIGN="right"  ><font size="1"><b><fmt:message key="ePH.DispenseLocation.label" bundle="${ph_labels}"/></b> &nbsp;</TD>
		<TD class="BODYCOLORFILLED" ALIGN="left"   ><font size="1"><%=disp_locn_desc%></TD>
		<TD class="BODYCOLORFILLED" ALIGN="right"  ><font size="1"><b><fmt:message key="ePH.EffectiveStartTime.label" bundle="${ph_labels}"/></b> &nbsp;</TD>
		<TD class="BODYCOLORFILLED" ALIGN="left"   ><font size="1"><%=fill_int_start_date_time%></TD>
		<TD class="BODYCOLORFILLED" ALIGN="right"  ><font size="1"><b><fmt:message key="Common.EndTime.label" bundle="${common_labels}"/></b> &nbsp;</TD>
		<TD class="BODYCOLORFILLED" ALIGN="left"   ><font size="1"><%=fill_int_end_date_time%></TD>
	</TR>
<!--	<TR>
		<TD class="BODYCOLORFILLED" ALIGN="right"  ><font size="1"><b>Schedule Start</b> &nbsp;</TD>
		<TD class="BODYCOLORFILLED" ALIGN="left"   ><font size="1"><%=schedule_start%></TD>
		<TD class="BODYCOLORFILLED" ALIGN="right"  ><font size="1"><b></b> &nbsp;</TD>
		<TD class="BODYCOLORFILLED" ALIGN="left"   ><font size="1"></TD>
		<TD class="BODYCOLORFILLED" ALIGN="right"  ><font size="1"></TD>
		<TD class="BODYCOLORFILLED" ALIGN="left"   ><font size="1"></TD>
	</TR>
 	<TR>
		<TD class="BODYCOLORFILLED" ALIGN="right"  nowrap><font size="1"><b>Group By</b> &nbsp;</TD>
		<TD class="BODYCOLORFILLED" ALIGN="left"  ><font size="1"><input type="radio" name="nursing_unit" id="nursing_unit" value="N" checked>Nursing Unit <input type="radio" name="drug" id="drug" value="D" >Drug</TD>
		<TD class="BODYCOLORFILLED" ALIGN="center"  >&nbsp;</TD>
		<TD class="BODYCOLORFILLED" ALIGN="center"  ></TD>
		<TD class="BODYCOLORFILLED" ALIGN="center"  >&nbsp;</TD>
		<TD class="BODYCOLORFILLED" ALIGN="center"  ></TD>
	</TR> -->
	<th height="2" colspan="6"></th>   
</TABLE>
	<table border='0' cellpadding='0' cellspacing='0' width=100% align=center>
		<tr>
			<th width="25%"><fmt:message key="Common.PatientDetails.label" bundle="${common_labels}"/></th>
			<th colspan=2 width="40%"><fmt:message key="Common.Ordered.label" bundle="${common_labels}"/></th>
			<th colspan=2 width="27%"><fmt:message key="ePH.Dispense.label" bundle="${common_labels}"/></th>
			<th width="14%"><fmt:message key="Common.current.label" bundle="${common_labels}"/> 
			    <fmt:message key="Common.Qty.label" bundle="${common_labels}"/></th>
			<th><fmt:message key="ePH.Select.label" bundle="${ph_labels}"/></th>
		</tr>
		<tr>
			<th width="25%">&nbsp;</th>
			<th align="center"><fmt:message key="Common.Drug.label" bundle="${common_labels}"/></th>
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
</form>
</HTML>

