<!DOCTYPE html>
<%@ page import="java.sql.*, java.net.*, webbeans.eCommon.*, webbeans.op.CurrencyFormat,java.io.*, java.util.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<HTML>
<HEAD>
	<TITLE> <fmt:message key="Common.BillingDetails.label" bundle="${common_labels}"/></TITLE>
	<!--
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link>
	-->
	<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
    %>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
<!--	<script language="javascript" src="../../eCommon/js/messages.js"></script>
-->
	<script language="javascript"src="../../eCommon/js/ValidateControl.js">
	</script>
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

	//unused variable, commented on 09/06/05
	//String strpatnetchargeamt = request.getParameter("patnetchargeamt");	
	
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
	String strnetchargeamt = request.getParameter("netchargeamt");
	
	String strotherserviceamt = request.getParameter("otherserviceamt");
	String strbilledamt = request.getParameter("billedamt");
	String strunbilledamt = request.getParameter("unbilledamt");
	String strpaidamt = request.getParameter("paidamt");
	String stroutstamt = request.getParameter("outstamt");

	String strpatotherserviceamt = request.getParameter("patotherserviceamt");
	String strpatbilledamt = request.getParameter("patbilledamt");
	String strpatunbilledamt = request.getParameter("patunbilledamt");
	String strpatpaidamt = request.getParameter("patpaidamt");
	String strpatoutstamt = request.getParameter("patoutstamt");

	String strcustotherserviceamt = request.getParameter("custotherserviceamt");
	String strcustbilledamt = request.getParameter("custbilledamt");
	String strcustunbilledamt = request.getParameter("custunbilledamt");
	String strcustpaidamt = request.getParameter("custpaidamt");
	String strcustoutstamt = request.getParameter("custoutstamt");

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
	if ( strnetchargeamt == null ) strnetchargeamt = "";

	if ( strotherserviceamt == null ) strotherserviceamt = "";
	if ( strbilledamt == null ) strbilledamt = "";
	if ( strunbilledamt == null ) strunbilledamt = "";
	if ( strpaidamt == null ) strpaidamt = "";
	if ( stroutstamt == null ) stroutstamt = "";

	if ( strpatotherserviceamt == null ) strpatotherserviceamt = "";
	if ( strpatbilledamt == null ) strpatbilledamt = "";
	if ( strpatunbilledamt == null ) strpatunbilledamt = "";
	if ( strpatpaidamt == null ) strpatpaidamt = "";
	if ( strpatoutstamt == null ) strpatoutstamt = "";

	if ( strcustotherserviceamt == null ) strcustotherserviceamt = "";
	if ( strcustbilledamt == null ) strcustbilledamt = "";
	if ( strcustunbilledamt == null ) strcustunbilledamt = "";
	if ( strcustpaidamt == null ) strcustpaidamt = "";
	if ( strcustoutstamt == null ) strcustoutstamt = "";


	%>

	
	<script>
			
			function billdetpage()
			{
				
				var dialogHeight	= "16" ;
				var dialogWidth		= "37" ;
				var dialogTop		= "225";
				var center			= "1";														   
				var status			= "no";
				var features		= "dialogHeight:"  + dialogHeight + 
									  "; dialogWidth:" + dialogWidth + 	
									  "; center: "	   + center + 
									  "; status: "	   + status	+ 
									  "; dialogTop :"  + dialogTop;
				var arguments	= "" ;								
						
			var retVal = 			window.showModalDialog("../../eBL/jsp/BLInsDetails.jsp?insind=<%=strinsind%>&baseqty=<%=strbaseqty%>&basechargeamt=<%=strbasechargeamt%>&baserate=<%=strbaserate%>&grosschargeamt=<%=strgrosschargeamt%>&discountper=<%=strdiscountper%>&discountamt=<%=strdiscountamt%>&daytypecode=<%=strdaytypecode%>&daytypedesc=<%=strdaytypedesc%>&timetypecode=<%=strtimetypecode%>&timetypedesc=<%=strtimetypedesc%>&addlfactor=<%=straddlfactor%>&patgrosschargeamt=<%=strpatgrosschargeamt%>&patdiscamt=<%=strpatdiscamt%>&patnetamt=<%=strpatnetamt%>&custgrosschargeamt=<%=strcustgrosschargeamt%>&custdiscamt=<%=strcustdiscamt%>&custnetamt=<%=strcustnetamt%>&ordercatalogcode=<%=strordercatalogcode%>&ordercatalogdesc=<%=java.net.URLEncoder.encode(strordercatalogdesc)%>&blngservcode=<%=strblngservcode%>&blngservdesc=<%=java.net.URLEncoder.encode(strblngservdesc)%>&blngrule=<%=strblngrule%>&otherserviceamt=<%=strotherserviceamt%>&billedamt=<%=strbilledamt%>&unbilledamt=<%=strunbilledamt%>&paidamt=<%=strpaidamt%>&outstamt=<%=stroutstamt%>&patotherserviceamt=<%=strpatotherserviceamt%>&patbilledamt=<%=strpatbilledamt%>&patunbilledamt=<%=strpatunbilledamt%>&patpaidamt=<%=strpatpaidamt%>&patoutstamt=<%=strpatoutstamt%>&custotherserviceamt=<%=strcustotherserviceamt%>&custbilledamt=<%=strcustbilledamt%>&custunbilledamt=<%=strcustunbilledamt%>&custpaidamt=<%=strcustpaidamt%>&custoutstamt=<%=strcustoutstamt%>",arguments,features); 				
			return;	
			}

			function billdetclose()
			{		
				var returnArray = new Array (1);
				window.returnValue = returnArray;
				window.close();
				return;				 
			}	
	</script>	 
   
</HEAD>

<BODY	onLoad="" onKeyDown= "lockKey();" onMouseDown="CodeArrest();" 					onSelect="codeArrestThruSelect();">
	<FORM name='billdetails' id='billdetails' method='Login'  action=''  scrolling='NO' >
	
	<table border='0' cellpadding='3' cellspacing='0' align='center' width='100%'>

	<%
	if (strinsind.equals("Y"))
	{
	%>

	<tr>
	<td width="25%" class="label"></td>
    <td width="25%" class="label"></td>
    <td width="25%" class="label"></td>
	<td width="25%" class="button"><INPUT TYPE="button"  class="BUTTON" VALUE="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eBL.INS_DTL.label","bl_labels")%>" onClick='billdetpage()'> </td>	
	</tr>	

	<%
	}
	%>

	<!--

	<tr>
		<td width="" class="label">&nbsp;</td>
		<td width="" class="label">&nbsp;</td>
		<td width="" class="label">&nbsp;</td>
		<td width="" class="label">&nbsp;</td>
	</tr>
	-->


	<%
	if (strblngrule.equals("T"))
	{
	%>


	<tr>
		<td width="25%" class="label"><fmt:message key="eBL.BASE_QTY.label" bundle="${bl_labels}"/></td>		
		<td width="25%" class="fields"><INPUT TYPE="TEXT" READONLY name="baseqty" id="baseqty" SIZE="15" MAXLENGTH="30" 	VALUE="<%=strbaseqty%>" style='text-align:right'></td>

		<td width="25%" class="label"><fmt:message key="eBL.BASE_CHARGE_AMT.label" bundle="${bl_labels}"/></td>
		<td width="25%" class="fields"><INPUT TYPE="TEXT" READONLY name="basechargeamt" id="basechargeamt" SIZE="15" MAXLENGTH="30" VALUE="<%=strbasechargeamt%>" style='text-align:right'></td> 				
    </tr>

	<tr>
		<td width="25%" class="label"><fmt:message key="eBL.BASE_RATE.label" bundle="${bl_labels}"/></td>
		<td width="25%" class="fields"><INPUT TYPE="TEXT" READONLY name="baserate" id="baserate" SIZE="15" MAXLENGTH="30" VALUE="<%=strbaserate%>" style='text-align:right'> </td>

		<td width="25%" class="label"><fmt:message key="eBL.GROSS_CHARGE_AMT.label" bundle="${bl_labels}"/></td>
		<td width="25%" class="fields"><INPUT TYPE="TEXT" READONLY name="grosschargeamt" id="grosschargeamt" SIZE="15" MAXLENGTH="30" VALUE="<%=strgrosschargeamt%>" style='text-align:right'> </td>
	</tr>

	<tr>
		<td width="25%" class="label"><fmt:message key="eBL.DISCOUNT_PERC.label" bundle="${bl_labels}"/></td>
		<td width="25%" class="fields"><INPUT TYPE="TEXT" READONLY name="discount" id="discount" SIZE="15" MAXLENGTH="30" VALUE="<%=strdiscountper%>" style='text-align:right'> </td>

		<td width="25%" class="label"><fmt:message key="eBL.DISCOUNT_AMT.label" bundle="${bl_labels}"/></td>
		<td width="25%" class="fields"><INPUT TYPE="TEXT" READONLY name="discountamt" id="discountamt" SIZE="15" MAXLENGTH="30" VALUE="<%=strdiscountamt%>" style='text-align:right'></td>
	 </tr>
	 <tr>
		<td width="25%" class="label"><fmt:message key="eBL.DAY_TYPE_CODE.label" bundle="${bl_labels}"/></td>
		<td width="25%" class="fields"><INPUT TYPE="TEXT" READONLY name="daytypecode" id="daytypecode" SIZE="2" MAXLENGTH="2" VALUE="<%=strdaytypecode%>" ><INPUT TYPE="TEXT" READONLY name="daytypedesc" id="daytypedesc" SIZE="15" MAXLENGTH="30" VALUE="<%=strdaytypedesc%>" ></td>
		<td width="25%"></td>
		<td width="25%"></td>
     </tr>

     <tr>
		<td width="25%" class="label"><fmt:message key="eBL.TIME_TYPE_CODE.label" bundle="${bl_labels}"/></td>
		<td width="25%" class="fields"><INPUT TYPE="TEXT" READONLY name="timetypecode" id="timetypecode" SIZE="2" MAXLENGTH="2" VALUE="<%=strtimetypecode%>"><INPUT TYPE="TEXT" READONLY name="timetypedesc" id="timetypedesc" SIZE="15" MAXLENGTH="30" VALUE="<%=strtimetypedesc%>"> </td>
		<td width="25%"></td>
		<td width="25%"></td>
	 </tr>

	 <tr>
		<td width="25%" class="label"><fmt:message key="eBL.ADDITIONAL_FACTOR.label" bundle="${bl_labels}"/></td>
		<td width="25%" class="fields"><INPUT TYPE="TEXT" READONLY name="addlfactor" id="addlfactor" SIZE="10" MAXLENGTH="30" VALUE="<%=straddlfactor%>" style='text-align:right'> </td>
		
		<td width="25%" class="label"></td>	
		<td width="25%" class="button"><INPUT TYPE="button"  class="button" VALUE="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>" onClick='billdetclose()'> </td> 	
	 </tr>

	<%
	}
	else 
	{
	%>

	 <tr>
		<td width="25%" class="label"><fmt:message key="Common.ordercatalog.label" bundle="${common_labels}"/></td>
		<td width="25%" class="fields"><INPUT TYPE="TEXT" READONLY name="ordercatalogcode" id="ordercatalogcode" SIZE="10" MAXLENGTH="20" VALUE="<%=strordercatalogcode%>" ><INPUT TYPE="TEXT" READONLY name="ordercatalogdesc" id="ordercatalogdesc" SIZE="30" MAXLENGTH="50" VALUE="<%=strordercatalogdesc%>"></td>		
		<td width="25%" class="label" ></td>
		<td width="25%" class="label" ></td>
     </tr>

<!--
	 <tr>
			<td width="" class="label">&nbsp;</td>
			<td width="" class="label">&nbsp;</td>
			<td width="" class="label">&nbsp;</td>
			<td width="" class="label">&nbsp;</td>
	</tr>
	-->

     <tr>
		<td width=25%" class="label"><fmt:message key="eBL.BILLING_SERVICE_PANEL.label" bundle="${bl_labels}"/></td>
		<td width=25%" class="fields"><INPUT TYPE="TEXT" READONLY name="blngservcode" id="blngservcode" SIZE="10" MAXLENGTH="20" VALUE="<%=strblngservcode%>"><INPUT TYPE="TEXT" READONLY name="blngservdesc" id="blngservdesc" SIZE="30" MAXLENGTH="50" VALUE="<%=strblngservdesc%>"></td>		
		<td width="25%" class="label" ></td>
		<td width="25%" class="label" ></td>
     </tr>
<!--
	 <tr>
		<td width="" class="label">&nbsp;</td>
		<td width="" class="label">&nbsp;</td>
		<td width="" class="label">&nbsp;</td>
		<td width="" class="label">&nbsp;</td>
	</tr>		-->

	<!--
	<tr>

		<td align="right" class="label">Charge Amount</td>
		<td class="label">&nbsp;<INPUT TYPE="TEXT" READONLY name="grosschargeamt" id="grosschargeamt" SIZE="15" MAXLENGTH="30" VALUE='<%=strgrosschargeamt%>' style='text-align:right'> </td>
	

		<td align="right" class="label">Payable Amount</td>
		<td class="label">&nbsp;<INPUT TYPE="TEXT" READONLY name="netchargeamt" id="netchargeamt" SIZE="15" MAXLENGTH="30" VALUE='<%=strnetchargeamt%>' style='text-align:right'> </td>

    </tr>-->

	<tr>
		<td width="25%" class="label"><fmt:message key="Common.ChargeAmount.label" bundle="${common_labels}"/></td>
		<td width="25%" class="fields"><INPUT TYPE="TEXT" READONLY name="grosschargeamt" id="grosschargeamt" SIZE="10" MAXLENGTH="30" VALUE="<%=strgrosschargeamt%>" style='text-align:right'> Payable Amount <INPUT TYPE="TEXT" READONLY name="netchargeamt" id="netchargeamt" SIZE="10" MAXLENGTH="30" VALUE="<%=strnetchargeamt%>" style='text-align:right'> </td>      
		<td width="25%" class="label" ></td> 
		<td width="25%" class="label" ></td> 
    </tr>

    <tr>
		<td width="25%" class="label"><fmt:message key="eBL.OTHER_SERVICE_AMT.label" bundle="${bl_labels}"/></td>
		<td width="25%" class="fields"><INPUT TYPE="TEXT" READONLY name="otherserviceamt" id="otherserviceamt" SIZE="10" MAXLENGTH="30" VALUE="<%=strotherserviceamt%>" style='text-align:right'> Billed Amount <INPUT TYPE="TEXT" READONLY name="billedamt" id="billedamt" SIZE="10" MAXLENGTH="30" VALUE="<%=strbilledamt%>" style='text-align:right'> </td> 
        <td width="25%" class="label" ></td> 
        <td width="25%" class="label" ></td> 
    </tr>
	
	<tr>
		<td width="25%" class="label"><fmt:message key="eBL.UNBILLED_AMT.label" bundle="${bl_labels}"/></td>
		<td width="25%" class="fields"><INPUT TYPE="TEXT" READONLY name="unbilledamt" id="unbilledamt" SIZE="10" MAXLENGTH="30" VALUE="<%=strunbilledamt%>" style='text-align:right'> Paid Amount <INPUT TYPE="TEXT" READONLY name="paidamt" id="paidamt" SIZE="10" MAXLENGTH="30" VALUE="<%=strpaidamt%>" style='text-align:right'> </td>
		<td width="25%" class="label" ></td>         
		<td width="25%" class="label" ></td>         
    </tr>

	<tr>
		<td width="25%" class="label"><fmt:message key="Common.outstandingamount.label" bundle="${common_labels}"/></td>
		<td width="25%" class="fields"><INPUT TYPE="TEXT" READONLY name="outstamt" id="outstamt" SIZE="10" MAXLENGTH="30" VALUE="<%=stroutstamt%>" style='text-align:right'></td>
		<td width="25%" class="label" ></td>	
		<td width="25%" class="label" ></td> 			
    </tr>
	
	<tr>
		<td width="25%" class="label" ></td> 
		<td width="25%" class="label" ></td> 
		<td width="25%" class="label" ></td> 
		<td width="25%" class="button"><INPUT TYPE="button"  class="button" VALUE="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>" onClick='billdetclose()'> </td> 	
	 </tr>

	<%
	}
	%>

	<!-- <tr>
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


