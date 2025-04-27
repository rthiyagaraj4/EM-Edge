<!DOCTYPE html>
 <%@page contentType="text/html;charset=UTF-8"  import=" eST.*, eST.Common.* , eCommon.Common.*, java.text.*, java.util.*"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<!-- 	<link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link>
 --><%
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		
		String sStyle =
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<!-- 	<script language="javascript" src="../../eCommon/js/messages.js"></script> -->
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
	<!-- <script language="javascript" src="../../eST/js/StMessages.js"></script> -->
	<script language="javascript" src="../../eST/js/StCommon.js"></script>
	<script language="javascript" src="../../eST/js/ChangeExpiryFlag.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onSelect="codeArrestThruSelect();">	 
<%
	//String mode;
	//String bean_id;
	//String bean_name;
	//String function_id;
	//String codeDisabled =	"";
	//String disabled		=	"";
	//String item_code ="";
	String classvalue = "";

	ChangeExpiryFlagBean bean = (ChangeExpiryFlagBean) getBeanObject( "ChangeExpiryFlagBean","eST.ChangeExpiryFlagBean",request );
	bean.setLanguageId(locale);
   
      /**
			* @Name - Suri
			* @Date - 19/01/2010
			* @Inc# - IN015496
			* @Desc - Code added to accept decimal values dynamically.
			* @ getAllowDecimalsYN() return's 'Y' that accept decimal values dynamically.other wise it should not accept decimal values dynamically. 
			*/
	   int no_of_decimals=0;
		if((bean.getAllowDecimalsYN(bean.getItem_code())).equals("Y")){
			no_of_decimals=bean.getNoOfDecimals();
		}
		else{
			no_of_decimals=0;
		}
	  	//out.println("no_of_decimals----->"+no_of_decimals);

	/* Mandatory checks start */
%>
	<form name="formChangeExpiryFlagStore" id="formChangeExpiryFlagStore">
			<table border="1" cellpadding="0" cellspacing="0" width='85%'  align=center>
			<tr>
			</tr>
			<th colspan=13 ><fmt:message key="eST.NoofUnfinalised/GLUninterfacedTransactions.label" bundle="${st_labels}"/></th>
			<!--	
	* @Name - Priya
	* @Date - 19/02/2010
	* @Inc# - IN019466
	* @Desc - To align the headers in center . 					
	-->
			<tr>
				<td class=CAGROUP_HEADING  width='5%' style="TEXT-ALIGN:center"><b><fmt:message key="Common.Store.label" bundle="${common_labels}"/></b></td>
				<td class=CAGROUP_HEADING  width='5%' style="TEXT-ALIGN:center"><b><fmt:message key="eST.GRN.label" bundle="${st_labels}"/></b></td>
				<td class=CAGROUP_HEADING  width='5%' style="TEXT-ALIGN:center"><b><fmt:message key="eST.RTV.label" bundle="${st_labels}"/></td>
				<td class=CAGROUP_HEADING  width='5%' style="TEXT-ALIGN:center"><b><fmt:message key="eST.ISS.label" bundle="${st_labels}"/></b></td>
				<td class=CAGROUP_HEADING  width='5%' style="TEXT-ALIGN:center"><b><fmt:message key="eST.URG.label" bundle="${st_labels}"/></b></td>
				<td class=CAGROUP_HEADING  width='5%' style="TEXT-ALIGN:center"><b><fmt:message key="eST.RET.label" bundle="${st_labels}"/></b></td>
				<td class=CAGROUP_HEADING  width='5%' style="TEXT-ALIGN:center"><b><fmt:message key="eST.ADJ.label" bundle="${st_labels}"/></b></td>
				<td class=CAGROUP_HEADING  width='5%' style="TEXT-ALIGN:center"><b><fmt:message key="eST.SAL.label" bundle="${st_labels}"/></b></td>
				<td class=CAGROUP_HEADING  width='5%' style="TEXT-ALIGN:center"><b><fmt:message key="eST.SRT.label" bundle="${st_labels}"/></b></td>
				<td class=CAGROUP_HEADING  width='5%' style="TEXT-ALIGN:center"><b><fmt:message key="eST.TFR.label" bundle="${st_labels}"/></b></td>
				<td class=CAGROUP_HEADING  width='5%' style="TEXT-ALIGN:center"><b><fmt:message key="eST.PRT.label" bundle="${st_labels}"/></b></td>
				<td class=CAGROUP_HEADING  width='5%' style="TEXT-ALIGN:center"><b><fmt:message key="eST.MFG.label" bundle="${st_labels}"/></b></td>
				<td class=CAGROUP_HEADING  width='5%' style="TEXT-ALIGN:center"><b><fmt:message key="Common.Qty.label" bundle="${common_labels}"/></b></td> 
			</tr>
<%
ArrayList ALData=bean.getStoreLevelCount(bean.getItem_code());
HashMap hmRecord=new HashMap();
	int i=0;
	for	(i	=0;	i<ALData.size();i++){
		hmRecord	=(HashMap)	ALData.get(i);
		classvalue	=	((i%2)==0)?"QRYODD":"QRYEVEN";
%>
	<tr>   
		<td  class="<%=classvalue%>"  width="10%"><%=(String)hmRecord.get("SHORT_DESC")%></td>
		<td  class="<%=classvalue%>" ><%=(String)hmRecord.get("GRN_COUNT")%></td>
		<td  class="<%=classvalue%>" ><%=(String)hmRecord.get("RTV_COUNT")%></td>
		<td  class="<%=classvalue%>" ><%=(String)hmRecord.get("ISS_COUNT")%></td>
		<td  class="<%=classvalue%>" ><%=(String)hmRecord.get("URG_COUNT")%></td>
		<td  class="<%=classvalue%>" ><%=(String)hmRecord.get("RET_COUNT")%></td>
		<td  class="<%=classvalue%>" ><%=(String)hmRecord.get("ADJ_COUNT")%></td>
		<td  class="<%=classvalue%>" ><%=(String)hmRecord.get("SAL_COUNT")%></td>
		<td  class="<%=classvalue%>" ><%=(String)hmRecord.get("SRT_COUNT")%></td>
		<td  class="<%=classvalue%>" ><%=(String)hmRecord.get("TFR_COUNT")%></td>
		<td  class="<%=classvalue%>" ><%=(String)hmRecord.get("PRT_COUNT")%></td>
		<td  class="<%=classvalue%>" ><%=(String)hmRecord.get("MFG_COUNT")%></td>
					<!-- 					
						* @Name - Priya
						* @Date - 19/02/2010
						* @Inc# - IN019466
						* @Desc - To right align QuantityOnHand.				
					-->
		<td  class="<%=classvalue%>" style="TEXT-ALIGN:right" ><%=bean.setNumber((bean.checkForNull((String)hmRecord.get("QTY_ON_HAND"),"0")),no_of_decimals)%>&nbsp;</td>
	</tr>
	<%}%>
</table>
<table>
<input type=hidden name=item_code>
<input type=hidden name=expiry_yn>
 </table>
</form>
			<%
putObjectInBean("ChangeExpiryFlagBean",bean,request);
%>
</body>
</html>

