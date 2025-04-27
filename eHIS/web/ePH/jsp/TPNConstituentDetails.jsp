<!DOCTYPE html>
<!--This file is saved on 07/11/2005-->
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, eOR.*, ePH.Common.* ,eOR.Common.* , eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>

<HTML> 
<HEAD> 
	<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/CommonLookup.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../js/PhCommon.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<TITLE> <fmt:message key="ePH.TPNNonStandardRegimenConstituentsDetails.label" bundle="${ph_labels}"/> </TITLE>

</HEAD>

<%
	try{

	String order_id		= request.getParameter("order_id");
	String patient_id		= request.getParameter("patient_id");
	String tpn_non_std_regimen_code		= request.getParameter("tpn_non_std_regimen_code");
	
	String tot_volume		= "";
	String tot_volume_uom	= "";
	String osmola_volume	= "";

	String curr_group	= "";
	String prev_group	= "";
	String curr_dispgroup	= "";
	String prev_dispgroup	= "";
	String bean_id		= "TPNWorkSheetBean";
	String bean_name	= "ePH.TPNWorkSheetBean";

	TPNWorkSheetBean bean = (TPNWorkSheetBean)getBeanObject(bean_id, bean_name,request);
	bean.clear();

	ArrayList vol_osmo_vol	= bean.getAllVolumes(order_id);

		if(vol_osmo_vol != null && vol_osmo_vol.size() > 0){
			tot_volume		= (String)vol_osmo_vol.get(0);
			tot_volume_uom	= (String)vol_osmo_vol.get(1);
			osmola_volume	= (String)vol_osmo_vol.get(2);
		}
	ArrayList ordDispDetails = bean.getOrdDispTPNDetails(order_id);

	String Qryclass="";
 %>

<body onMouseDown="" onKeyDown="lockKey()">  <!-- added on 23/1/09 -->
	<FORM name="formTPNWorkSheetDetails" id="formTPNWorkSheetDetails">
		<TABLE   CELLPADDING="0" CELLSPACING="0" WIDTH="100%" ALIGN="center" BORDER="1">
			<tr>
			<TABLE CELLPADDING="0" CELLSPACING="0" WIDTH="100%" ALIGN="center" BORDER="1">
			<TR>
				<td class="TDSTYLE" align="center" width="50%" ><B><fmt:message key="Common.Ordered.label" bundle="${common_labels}"/></B></td>
				<td class="TDSTYLE" align="center" width="50%" ><B> <fmt:message key="Common.Dispensed.label" bundle="${common_labels}"/></B></td>
				</TR>
				</TABLE>
			</tr>

			<tr>
			<TABLE CELLPADDING="0" CELLSPACING="0" WIDTH="100%" ALIGN="center" BORDER="1">
			<TR>

				<td class="TDSTYLE" align="center" width="30%" class = "LABEL"><B> <fmt:message key="Common.ConstituentName.label" bundle="${common_labels}"/></B></td>
				<td class="TDSTYLE" align="center" width="10%" class = "LABEL"><B><fmt:message key="Common.Qty.label" bundle="${common_labels}"/></B></td>
				<td class="TDSTYLE" align="center" width="10%" class = "LABEL"><B> <fmt:message key="Common.uom.label" bundle="${common_labels}"/></B></td>
				<td class="TDSTYLE" align="center" width="30%" class = "LABEL"><B> <fmt:message key="Common.item.label" bundle="${common_labels}"/></B></td>
				<td class="TDSTYLE" align="center" width="10%" class = "LABEL"><B><fmt:message key="Common.Qty.label" bundle="${common_labels}"/></B></td>
				<td class="TDSTYLE" align="center" width="30%" class = "LABEL"><B> <fmt:message key="Common.uom.label" bundle="${common_labels}"/></B></td> 
				</TR>
				</TABLE>
			</tr>
<%

	for (int i=0; i<ordDispDetails.size(); i+=10)  { 
	
		curr_group = (String)ordDispDetails.get(i+3);
		if(i%2==0)
		{
			Qryclass="QRYEVENSMALL";
		}
		else
		{
			Qryclass="QRYODDSMALL";
		}

%>
	<TR >
		<TD ALIGN="left" WIDTH="100%">
			<TABLE CELLPADDING="0" CELLSPACING="0" WIDTH="100%" ALIGN="center" BORDER="1">
				<%
						if (!curr_group.equals(prev_group)) {
				%>
					
				<TH   ALIGN="LEFT" COLSPAN="6"><%= curr_group %></TH> 
				<% 
						prev_group=	curr_group;			
					}
				%> 
		   	<TR>
				<TD   ALIGN="LEFT " class="<%=Qryclass%>"  WIDTH="30%">
					<%= ordDispDetails.get(i+2) %> </TD>							
				<TD   ALIGN="right" class="<%=Qryclass%>"  WIDTH="10%">
					<%= ordDispDetails.get(i+4) %>&nbsp; </TD>
				<TD   ALIGN="left" class="<%=Qryclass%>"  WIDTH="10%">
						&nbsp; <%= ordDispDetails.get(i+5) %> </TD>
				<TD   ALIGN="LEFT" class="<%=Qryclass%>"  WIDTH="30%">
					<%= ordDispDetails.get(i+6) %> </TD>							
				<TD   ALIGN="right" class="<%=Qryclass%>"  WIDTH="10%">
					<%= ordDispDetails.get(i+7) %>&nbsp; </TD>
				<TD   ALIGN="left" class="<%=Qryclass%>"  WIDTH="10%">
						&nbsp; <%= ordDispDetails.get(i+8) %> </TD>
			 </TR>
		</TABLE>
	</TD>
 </TR>

  <% 
		}
  %>
  </TABLE>
  <% if(ordDispDetails.size() >0){%>
  <BR><BR>
<TABLE CELLPADDING="0" CELLSPACING="0" WIDTH="100%" ALIGN="center" BORDER="0">
<TR>
	<TD   ALIGN="LEFT " class="label"  WIDTH="30%">	</TD>							
	<TD   ALIGN="right" class="label"  WIDTH="10%">	</TD>
	<TD   ALIGN="left" class="label"  WIDTH="10%">	</TD>
	<TD   ALIGN="right" class="label"  WIDTH="30%"> <fmt:message key="Common.total.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.volume.label" bundle="${common_labels}"/>: &nbsp;</TD>							
	<TD   ALIGN="right" class="label"  WIDTH="10%"><b><%=tot_volume%></b></TD>
	<TD   ALIGN="left" class="label"  WIDTH="10%">&nbsp; <%=tot_volume_uom%></TD>
  
</TR>
<TR>
	<TD   ALIGN="LEFT " class="label"  WIDTH="30%">	</TD>							
	<TD   ALIGN="right" class="label"  WIDTH="10%">	</TD>
	<TD   ALIGN="left" class="label"  WIDTH="10%">	</TD>
	<TD   ALIGN="right" class="label"  WIDTH="30%"> <fmt:message key="ePH.Osmolarity.label" bundle="${ph_labels}"/>&nbsp;<fmt:message key="Common.volume.label" bundle="${common_labels}"/>: &nbsp;</TD>							
	<TD   ALIGN="right" class="label"  WIDTH="10%"><b><%=osmola_volume%></b></TD>
	<TD   ALIGN="left" class="label"  WIDTH="10%">&nbsp; <fmt:message key="ePH.mOsmol/L.label" bundle="${ph_labels}"/></TD>
  
</TR>
</TABLE>
<%}%>
 

	<% 
	//disp_count = dispensdDetails.size();
//	if (disp_count>0) {
	%>
	
<!-- <TABLE CELLPADDING="0" CELLSPACING="0" WIDTH="100%" ALIGN="center" BORDER="1">
	
			<tr>
				<td class="TDSTYLE" align="left " width="26%"><B> CONSTITUENTS DISPENSED </B></td>
			</tr> -->
	<%
      /*  
	    int k=0;
		for (int i=0; i<dispensdDetails.size(); i+=7, k++)  { 
		curr_dispgroup = (String)dispensdDetails.get(i);
		if(i%2==0)
		{
			Qry="QRYEVENSMALL";
		}
		else
		{
			Qry="QRYODDSMALL";
		}
	*/	
	%>
	
<!-- <TR>
		<TD ALIGN="left" WIDTH="100%">
			<TABLE CELLPADDING="0" CELLSPACING="0" WIDTH="100%" ALIGN="center" BORDER="1"> -->
			<%
		//		if (!curr_dispgroup.equals(prev_dispgroup)) {
 			%>
			   &nbsp;
			<% 
		//		prev_dispgroup=	curr_dispgroup;							}
			%> 
			<!-- <TR>
					<TD ALIGN="center " class=""  WIDTH="60%">
					</TD>
					<TD  WRAP ALIGN="right" CLASS="" WIDTH="20%">
					&nbsp; </td>
					<TD  WRAP ALIGN="left " CLASS="" WIDTH="35%">
				   	&nbsp; </TD>				
			</TR>
		 </TABLE>
     </TD>
</TR> -->

	  <%
	//      }
      %>
<!-- </TABLE> -->
	
	<%
		//	}
		putObjectInBean(bean_id,bean,request);
		}catch(Exception e){
	  e.printStackTrace(); }
	  
	%>
</FORM>
</BODY>
</HTML>

