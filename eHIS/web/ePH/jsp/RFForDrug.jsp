<!DOCTYPE html>
 <%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- Mandatory declarations end --%>


<HTML>
<HEAD>
	<!-- <LINK REL="stylesheet" TYPE="text/css" HREF="../../eCommon/html/IeStyle.css"></LINK> -->
	<%
	request.setCharacterEncoding("UTF-8");
	//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
	request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
	response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
	response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
	//ends
	String locale			= (String)session.getAttribute("LOCALE");
	String facility_id					= (String) session.getValue("facility_id"); //Added on 9/april/2010 regd inc num:20584  
	

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/CommonLookup.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
	<!--<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/messages.js"></SCRIPT>-->
	<SCRIPT LANGUAGE="javascript" SRC="../js/PHReports.js"></SCRIPT>
	<!--<SCRIPT LANGUAGE="javascript" SRC="../js/PHmessages.js"></SCRIPT>-->
	<SCRIPT LANGUAGE="javascript" SRC="../js/RFD.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</HEAD>

<!-- <body  onMouseDown="CodeArrest()" onKeyDown="lockKey()"  > -->
<body onMouseDown="" onKeyDown="lockKey()">
<%
	String mode	= request.getParameter( "mode" ) ;
	String bean_id = "RFDBean" ;
	String bean_name = "ePH.RFDBean";
	String drug_code	= request.getParameter( "drug_code" ) ;
	String info="";
	String code	=	request.getParameter("drug_code");
	boolean isInfo=false;
	boolean isDefault=false;

	if ( mode == null || mode.equals("") )
		return ;
	if ( !(mode.equals( CommonRepository.getCommonKeyValue("MODE_MODIFY")) || mode.equals( CommonRepository.getCommonKeyValue("MODE_INSERT") )) )
		return ;


	/* Initialize Function specific start */
	RFDBean bean = (RFDBean)getBeanObject( bean_id,bean_name,request) ;
	bean.setLanguageId(locale);
	bean.clear() ;
	bean.setMode( mode ) ; 
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));



	String logged_fcy = bean.getLoggedInFacility();
	HashMap RFCollection=new HashMap();
	RFCollection=bean.getRF(drug_code);
	ArrayList RFId=new ArrayList();
	ArrayList RFName=new ArrayList();
	ArrayList RFQty=new ArrayList();
	ArrayList RFUOM=new ArrayList();
	ArrayList RFInfo=new ArrayList();
	ArrayList RFAssociated=new ArrayList();
	ArrayList RFDefault=new ArrayList();

	if (RFCollection.containsKey("ERROR")	 )
	{
	out.println(RFCollection.get("ERROR"));
	return;
	}
	else
	{
	RFId=(ArrayList)RFCollection.get("RF_ID");
	RFName=(ArrayList)RFCollection.get("RF_NAME");
	RFQty=(ArrayList)RFCollection.get("RF_QTY");
	RFUOM=(ArrayList)RFCollection.get("RF_UOM");
	RFInfo=(ArrayList)RFCollection.get("RF_INFO");
	RFAssociated=(ArrayList)RFCollection.get("RF_ASSOCIATED");
	RFDefault=(ArrayList)RFCollection.get("RF_DEFAULT");

	}

%>
<%
if (RFId.size()==0)
{
out.println("<script>noFluidsAvailable();</script>");
//return;
}
%>
<br>
<table cellpadding="0" cellspacing="0" width="90%" align="center" border="0">
	<tr>
		<td class="TDCLICKED" onClick="javascript:callSelect()" id="select_col"  width="20%" height="20" 
		style="cursor:pointer">
		<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></td>
		<td class="TDNORMAL" onClick="javascript:callAssociation()" id="association_col"  width="20%" height="20" style="cursor:pointer" ><fmt:message key="Common.Association.label" bundle="${common_labels}"/></td>
		<td style="background-color:white" width=60%>&nbsp;</td>
		</td>
	</tr>
</table>



<FORM name="formReconstituentFluid" id="formReconstituentFluid"  TARGET="messageFrame" >

<!-- hidden values start here -->

<INPUT TYPE="hidden" name="mode" id="mode" VALUE="<%= mode %>">
<INPUT TYPE="hidden" name="bean_id" id="bean_id" VALUE="<%= bean_id %>">
<INPUT TYPE="hidden" name="bean_name" id="bean_name" VALUE="<%= bean_name %>">
<INPUT TYPE="hidden" name="function_id" id="function_id" VALUE="<%= bean.getFunctionId() %>">
<INPUT TYPE="hidden" name="facility_id" id="facility_id" VALUE="<%= logged_fcy %>">
<INPUT TYPE="hidden" name="drug_code" id="drug_code" VALUE="<%= code %>">
<INPUT TYPE="hidden" name="totalrows" id="totalrows" >




<table cellpadding='0' cellspacing='0' width='90%' align='center'>
	<tr>
	<td width="80%" class="white">&nbsp;</td>
	<td width="20%" class="white">&nbsp;
		<td id="prev_col" >
			<a href="javascript:goPrev();" id="prev"  style="display:none;" ><fmt:message key="Common.previous.label" bundle="${common_labels}"/></a></td>

		<td id="next_col" ><a href="javascript:goNext();" id="next" style="display:none" ><fmt:message key="Common.next.label" bundle="${common_labels}"/></a></td>
		</td>
	</td>
	</tr>
</table>

<table cellpadding="0" cellspacing="0" width="90%" align="center" border="1">
<tr>
	<th width="40%"><fmt:message key="Common.name.label" bundle="${common_labels}"/></th>
	<th width="10%"><fmt:message key="Common.Quantity.label" bundle="${common_labels}"/></th>
	<th width="20%"><fmt:message key="Common.uom.label" bundle="${common_labels}"/></th>
	<th width="10%"><fmt:message key="ePH.StabilityInformation.label" bundle="${ph_labels}"/>
	</th>
	<th width="10%"><fmt:message key="Common.Default.label" bundle="${common_labels}"/></th>
	<th width="10%"><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></th>
</tr>


<%
int i=0;
for (i=0;i<RFId.size();i++)
{
	info=(String)RFInfo.get(i);
	isInfo=false;
	isDefault=false;

	if (info!=null)
	{
		isInfo=true;
	}

	if ( (!(isDefault)) && (RFDefault.get(i)!=null) && (((String)RFDefault.get(i)).equals("Y")) )
	{
		isDefault=true;
	}
	
out.println("<tr id=ROW name=ROW >" );
%>

	<td  ><%=(String)RFName.get(i)%></td>
	<td>
	<% if ((String)RFQty.get(i)==null)
	{
			out.println("<input type=text size=4 name=RFQTY maxlength=5 onBlur=CheckPositiveNumber(this)");
	}
	else
	{
				out.println("<input type=text size=4 name=RFQTY maxlength=5 onBlur=CheckPositiveNumber(this) value='"+RFQty.get(i)+"'");
	}
	%>

</td>

	<td >
	
	
	<%=bean.getUomDisplay(facility_id,(String)RFUOM.get(i))%></td>  <!--Modified on 9/april/2010 regd inc num:20584  for UOM code/Description --> 
	
		<td  style="cursor:pointer;color:blue"><label onClick="showInfo(this.id)" id=<%=i%>><fmt:message key="ePH.Info.label" bundle="${ph_labels}"/></label></td>
	
	<td><input type=checkbox value=<%=i%> name="DEFAULT" onClick="defaultCheck(this.value,this);" 
	<%if (isDefault){out.println("CHECKED");}%>></td>
	<td><input type=checkbox value=<%=i%> onClick="selectCheck(this.value,this);"  name="SELECT" id="SELECT"
	
<%

	if   ( ((String)RFAssociated.get(i)).equals("Y") ) 
			out.println("CHECKED");

%>

>
<input type=hidden name="RFID" id="RFID" value="<%=RFId.get(i)%>" 	>
<input type=hidden name="Associated" id="Associated" value="<%=(String)RFAssociated.get(i)%>"><input type=hidden name="RFINFO" id="RFINFO" value="<%if (isInfo){out.println(info);}%>"></td></tr><!-- 15181 -->
<%
}//End of For loop for displaying table
%>
<input type="hidden" name="tot_rows" id="tot_rows" value="<%=i%>">
</form>
<% putObjectInBean(bean_id,bean,request); %>
</BODY>
<script>displayPage(1)</script>
</HTML>

