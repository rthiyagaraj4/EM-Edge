<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<!--
--------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------------
?             100            ?           created
06/09/2011    IN31901        NijithaS    Incident No: IN31901 - Bru-HIMS-CRF-263		 
-------------------------------------------------------------------------------------------------------------------------------------
-->
<%-- JSP Page specific attributes start --%>
<%@page import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*" contentType="text/html; charset=UTF-8" %>
 <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>


<script>
  function callOnAlphaLink(obj1,obj2){
	//alert('in callOnAlphaLink');
	if(obj1 == "OTH")
		obj1 = "Others" ;

	changeAlphaColor(obj2);

	parent.parent.callOrderCatalog(obj1);
	//callOrderCatalog(obj1);

  }
</script>

<html>
<head>
	
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String imgUrl="";
	if(sStyle.equals("IeStyle.css"))
	 {
			imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
	 }
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

    <STYLE TYPE="text/css">

	A:active {
		COLOR: black;
	}

	A:visited {
		COLOR: black;
	}
	A:link {
		COLOR: black;
	}

	 

	</STYLE>


</head>
<body  STYLE="overflow-y:hidden" onMouseDown="CodeArrest()"  onKeyDown="lockKey()" >

<%
	/* Mandatory checks start */
	 request.setCharacterEncoding("UTF-8");	
	String mode	   = request.getParameter("mode") ;
	//String function_id = request.getParameter( "function_id" ) ;
	String bean_id = "orderablePerformingLocationBean";
    String bean_name = "eOR.OrderablePerformingLocationBean";
	//String Alphabets ="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	String AlphabetsHtml =  "";
	//String readOnly = "" ;
	//String disabled = "" ;
	/* Mandatory checks end */

	/*	Initialize Function specific start */

	OrderablePerformingLocationBean OrderableBean = (OrderablePerformingLocationBean)getBeanObject(bean_id,bean_name,request);
    OrderableBean.setFunctionId(OrderableBean.checkForNull(request.getParameter("function_id")));
    OrderableBean.clearAll();
    OrderableBean.setMode(mode);

	//ArrayList locationType=new ArrayList();
	/* Initialize Function specific end */
	

%>
<Form name="OrderablePerformingLocationHeader" id="OrderablePerformingLocationHeader" Action='' method="post">
<Table border="0" id="headerTab" cellpadding=3 cellspacing=0 width="100%" align="center">
<%try {%>

<TR>
	<TD class="label"><fmt:message key="Common.PerformingLocation.label" bundle="${common_labels}"/></td>
	<TD class="fields"  id='location_type_option' >
		<Select name="location_type" id="location_type" onChange="return parent.parent.fillComboOptions(this)">
			<Option value=''>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</Option>
			<Option value='I'><fmt:message key="eOR.DepartmentalDiagnostics.label" bundle="${or_labels}"/></Option>
			<%//if (!OrderableBean.getLbInstall("RL").equalsIgnoreCase("Y")) {%>
			<Option value='L'><fmt:message key="eOR.LaboratorySite.label" bundle="${or_labels}"/></Option>
			<%//}%>
			<Option value='M'><fmt:message key="eOR.MiscellaneousService Location.label" bundle="${or_labels}"/></Option>	
			<Option value='P'><fmt:message key="Common.PatientCare.label" bundle="${common_labels}"/></Option>
			<%if (!OrderableBean.getLbInstall("RD").equalsIgnoreCase("Y")) {%>
			<Option value='R'><fmt:message key="Common.RadiologyWing.label" bundle="${common_labels}"/></Option><%}%>
			<Option value='T'><fmt:message key="eOR.TreatmentLocation.label" bundle="${or_labels}"/></Option>
			<option value="O"><fmt:message key="eOR.NonOTRooms.label" bundle="${or_labels}"/></option><!-- IN31901 -->
			
		</Select>
	</TD>
	<TD  >&nbsp;/</TD>
	<TD class="fields"  id='location_code_option' >
		<Select name="location_code" id="location_code" >   <!--onChange="return parent.parent.fillComboOptions(this);"-->
			<Option value="">--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</Option>
		</Select><img src="../../eCommon/images/mandatory.gif"/>
	</TD>
</TR>
<TR><TD colspan="4"></TD></TR>
<TR>
	<TD class="label"  ><fmt:message key="Common.OrderType.label" bundle="${common_labels}"/></td>
	<TD class="fields" id='order_type_option' >
		<Select name='order_type' id='order_type' onChange="return parent.parent.select(this)">
			<Option value="">--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</Option>
		</Select><img src="../../eCommon/images/mandatory.gif"/>
	</TD>
	<TD ></TD>
	<TD ></TD>
</TR>
<tr>
	<td colspan='4'>
	<%if(!imgUrl.equals("")){ %>
					 <img src='<%=imgUrl%>' width='100%' height='15'/> 
				<%}%>
	</tr>
<TR>
	<TD colspan='4' >
		<Table   cellspacing='0' id='innerCellTab' cellpadding='3' width='30%' border='1' style='display:none'>
			<TR>
				<TD  id='SelectTab' class='clicked' width='15%' height='20' onClick='parent.parent.selectInsert()'><A href='#'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></A></TD>
				<TD  id='AssociateTab' class='normal' width='15%' height='20' onClick='parent.parent.associated()'><A href='#'><fmt:message key="Common.Associate.label" bundle="${common_labels}"/></A></TD>
			</TR>
		</Table>
	</TD>
</TR>
<TR>
	<TD colspan='4' >
		<Table  cellspacing='0' id='alphabet' cellpadding='0' width='100%' border='0' style='display:none'>
			<TR>
				<TD><jsp:include page='OrCommonAlphaLink.jsp' flush='true'></jsp:include></TD>
			</TR>
		</Table>
	</TD>
</TR>

</Table>
<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
<input type="hidden" name="alphabetsHtml" id="alphabetsHtml" value='<%=AlphabetsHtml%>'>
<input type="hidden" name="seq_Nos" id="seq_Nos" value=''>
<input type='hidden' value='1' name='mode' id='mode'>
<input type='hidden' value='N' name='detailPageMode' id='detailPageMode'>
<input type='hidden' name="function_id" id="function_id" value="<%=OrderableBean.getFunctionId()%>">
<%
		putObjectInBean(bean_id,OrderableBean,request);
 

}catch(Exception e){
	System.out.println(e.getMessage());

}%>
</Form>
</body>
</html>

