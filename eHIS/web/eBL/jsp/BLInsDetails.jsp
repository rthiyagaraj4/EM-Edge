<!DOCTYPE html>
<%@ page import="java.sql.*, webbeans.eCommon.*,webbeans.op.CurrencyFormat,java.io.*,java.util.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<HTML>
<HEAD>
	<TITLE><fmt:message key="eBL.INS_DTL.label" bundle="${bl_labels}"/></TITLE>
	<!--
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link>
	-->
		<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
    %>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
<!--
	<script language="javascript" src="../../eCommon/js/messages.js"></script>
-->
	<script language="javascript"src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	<%
	request.setCharacterEncoding("UTF-8");	

	String strinsind		   = request.getParameter("insind");		
	String strbaseqty	       = request.getParameter("baseqty");
	String strbasechargeamt    = request.getParameter("basechargeamt");
	String strbaserate		   = request.getParameter("baserate");
	String strgrosschargeamt   = request.getParameter("grosschargeamt");
	String strdiscountper	   = request.getParameter("discountper");
	String strdiscountamt      = request.getParameter("discountamt");
	String strdaytypecode      = request.getParameter("daytypecode");
	String strdaytypedesc      = request.getParameter("daytypedesc");
	String strtimetypecode     = request.getParameter("timetypecode");
	String strtimetypedesc     = request.getParameter("timetypedesc");
	String straddlfactor       = request.getParameter("addlfactor");	

	String strpatgrosschargeamt = request.getParameter("patgrosschargeamt");	
	String strpatdiscamt = request.getParameter("patdiscamt");	
	String strpatnetamt = request.getParameter("patnetamt");	
	String strcustgrosschargeamt = request.getParameter("custgrosschargeamt");	
	String strcustdiscamt = request.getParameter("custdiscamt");	
	String strcustnetamt = request.getParameter("custnetamt");	


	String strordercatalogcode = request.getParameter("ordercatalogcode");	
	String strordercatalogdesc = request.getParameter("ordercatalogdesc");	
	String strblngservcode = request.getParameter("blngservcode");	
	String strblngservdesc = request.getParameter("blngservdesc");	
	String strblngrule = request.getParameter("blngrule");		


	if (strinsind == null)  strinsind = "";
	if (strbaseqty == null) 	strbaseqty = "";
	if (strbasechargeamt == null)  strbasechargeamt = "";
	if (strbaserate == null ) strbaserate = "";
	if (strgrosschargeamt == null ) strgrosschargeamt = "";
	if (strdiscountper == null ) strdiscountper = "";
	if (strdiscountper == null) strdiscountper = "";
	if (strdiscountamt == null ) strdiscountamt = "";
	if (strdaytypecode==null) strdaytypecode = "";
	if (strdaytypedesc==null) strdaytypedesc="";
	if (strtimetypecode == null ) strtimetypecode = "";
	if ( strtimetypedesc == null ) strtimetypedesc ="";
	if ( straddlfactor == null ) straddlfactor ="";
	if ( strpatgrosschargeamt == null ) strpatgrosschargeamt ="";	
	if ( strpatdiscamt == null ) strpatdiscamt = "";
	if ( strpatdiscamt == null ) strpatdiscamt ="";
	if ( strpatnetamt == null ) strpatnetamt ="";
	if (strcustgrosschargeamt == null ) strcustgrosschargeamt = "";
	if ( strcustgrosschargeamt == null ) strcustgrosschargeamt ="";
	if ( strcustdiscamt  == null ) strcustdiscamt = "";
	if ( strcustnetamt == null ) strcustnetamt = "";


	if ( strordercatalogcode == null ) strordercatalogcode = "";
	if ( strordercatalogdesc == null) strordercatalogdesc ="";
	if ( strblngservcode == null ) strblngservcode = "";
	if ( strblngservdesc == null ) strblngservdesc = "";	


	%>
	
	<script>	

		function insdetclose()
				{		
						var returnArray = new Array (1);
						window.returnValue = returnArray;
						window.close();						
				}
	</script>
	
	
	</HEAD>

		<BODY	onLoad="" onKeyDown= "lockKey();" onMouseDown="CodeArrest();" 					onSelect="codeArrestThruSelect();">
		<FORM name='insdetails' id='insdetails' method='Login'  action=''  scrolling=no >
		<table border='0' cellpadding='3' cellspacing='0' align='center' width='100%'>		
		
		
	<%
	if (strinsind.equals("Y"))
	{
	%>

	<tr>
	<td class="label" width="25%"></td>
    <td class="label" width="25%"></td>
    <td class="label" width="25%"></td>
	<td class="button" width="25%"><INPUT TYPE="button"  class="BUTTON" VALUE="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.BillingDetails.label","common_labels")%>" onClick='insdetclose()'> </td>	
	</tr>
<!--
	<tr>
			<td width="" class="label"></td>
			<td width="" class="label"></td>
			<td width="" class="label"></td>
			<td width="" class="label"></td>
	</tr>
-->
	<%
	}
	%>	

	<%
	if (strblngrule.equals("T"))
	{
	%>

	<tr>
		<td  class="label" width="25%"></td>
		<td  class="label" width="25%"><fmt:message key="eBL.GROSS_AMT.label" bundle="${bl_labels}"/></td>
		<td  class="label" width="25%"><fmt:message key="eBL.DISCOUNT_AMT.label" bundle="${bl_labels}"/></td>
		<td	 class="label" width="25%"><fmt:message key="Common.NetAmount.label" bundle="${common_labels}"/></td>		
	</tr>	

	<tr>	
		<td  class="label" width="25%"><fmt:message key="Common.patient.label" bundle="${common_labels}"/></td>
		<td width="25%" class="fields"><INPUT TYPE="TEXT" READONLY name="patgrossamt" id="patgrossamt" SIZE="15" MAXLENGTH="30" VALUE='<%=strpatgrosschargeamt%>'  style='text-align:right'></td>
		<td width="25%" class="fields"><INPUT TYPE="TEXT" READONLY name="patdiscamt" id="patdiscamt" SIZE="15" MAXLENGTH="30" VALUE='<%=strpatdiscamt%>'  style='text-align:right'></td>
		<td width="25%" class="fields"><INPUT TYPE="TEXT" READONLY name="patnetamt" id="patnetamt" SIZE="15" MAXLENGTH="30" VALUE='<%=strpatnetamt%>'  style='text-align:right'></td>
	</tr>
    <tr>	
		<td  class="label" width="25%"><fmt:message key="Common.Insurance.label" bundle="${common_labels}"/></td>
		<td class="fields" width="25%"><INPUT TYPE="TEXT" READONLY name="custgrossamt" id="custgrossamt" SIZE="15" MAXLENGTH="30" VALUE='<%=strcustgrosschargeamt%>' style='text-align:right'></td>

		<td class="fields"><INPUT TYPE="TEXT" READONLY name="custdiscamt" id="custdiscamt" SIZE="15" MAXLENGTH="30" VALUE='<%=strcustdiscamt%>'  style='text-align:right'></td>

		<td class="fields" width="25%"><INPUT TYPE="TEXT" READONLY name="custnetamt" id="custnetamt" SIZE="15" MAXLENGTH="30" VALUE='<%=strcustnetamt%>' style='text-align:right'></td>
	</tr>

	<% 
	}
		else
		{
	  %>

		  <tr>
		<td  class="label" width="25%"></td>
		<td  class="label" width="25%" ><fmt:message key="Common.ChargeAmount.label" bundle="${common_labels}"/></td>	
	    <td	 class="label" width="25%" ><fmt:message key="eBL.PAYABLE_AMT.label" bundle="${bl_labels}"/></td>
		<td  class="label" width="25%" ></td>		

		</tr>	

		<tr>	
		<td  class="label" width="25%"><fmt:message key="Common.patient.label" bundle="${common_labels}"/></td>
		<td width="25%" class="fields"><INPUT TYPE="TEXT" READONLY NAME = "patgrossamt" SIZE="15" MAXLENGTH="30" VALUE='<%=strpatgrosschargeamt%>'  style='text-align:right'></td>
		
		<td width="25%" class="fields"><INPUT TYPE="TEXT" READONLY name="patnetamt" id="patnetamt" SIZE="15" MAXLENGTH="30" VALUE='<%=strpatnetamt%>' style='text-align:right'></td>

		<td  class="label" width="25%" ></td>
	</tr>
    <tr>	
		<td  class="label" width="25%"><fmt:message key="Common.Insurance.label" bundle="${common_labels}"/></td>
		<td width="25%" class="fields"<INPUT TYPE="TEXT" READONLY name="custgrossamt" id="custgrossamt" SIZE="15" MAXLENGTH="30" VALUE='<%=strcustgrosschargeamt%>' style='text-align:right'></td>
		
		<td class="fields" width="25%"><INPUT TYPE="TEXT" READONLY name="custnetamt" id="custnetamt" SIZE="15" MAXLENGTH="30" VALUE='<%=strcustnetamt%>' style='text-align:right'></td>

		<td  class="label" width="25%" ></td>

	</tr>

		<%
			}
		%>
<!--
	<tr>
			<td width="" class="label"></td>
			<td width="" class="label"></td>
			<td width="" class="label"></td>
			<td width="" class="label"></td>
	</tr>

	<tr>
			<td width="" class="label"></td>
			<td width="" class="label"></td>
			<td width="" class="label"></td>
			<td width="" class="label"></td>
	</tr>

	<tr>
			<td width="" class="label"></td>
			<td width="" class="label"></td>
			<td width="" class="label"></td>
			<td width="" class="label"></td>
	</tr>
	<tr>
			<td width="" class="label"></td>
			<td width="" class="label"></td>
			<td width="" class="label"></td>
			<td width="" class="label"></td>
	</tr>

	<tr>
			<td width="" class="label"></td>
			<td width="" class="label"></td>
			<td width="" class="label"></td>
			<td width="" class="label"></td>
	</tr>
	<tr>
			<td width="" class="label"></td>
			<td width="" class="label"></td>
			<td width="" class="label"></td>
			<td width="" class="label"></td>
	</tr>		
-->
	</table> 	   				
	
  </FORM>
</BODY>
</HTML>


