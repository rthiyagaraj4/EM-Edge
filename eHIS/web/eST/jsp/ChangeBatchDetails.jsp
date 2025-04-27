<!DOCTYPE html>
  <%@page contentType="text/html;charset=UTF-8" import=" eST.*, eST.Common.* , eCommon.Common.*, java.text.*, java.util.*"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<!-- 	<link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link>
 -->	<%
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle =
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
<link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>

	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/messages.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="javascript" src="../../eST/js/StMessages.js"></script>
	<script language="javascript" src="../../eST/js/StCommon.js"></script>
	<script language="javascript" src="../../eST/js/ChangeExpiryFlag.js"></script>
	<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<script>

	var arr_batch_id=new Array();

</script>
<!--  <body  onSelect="codeArrestThruSelect();" onload="tab3Selected();" onunload="loadBatchDetails();">	removed onunload for edge changes--> 
<body  onSelect="codeArrestThruSelect();" onload="tab3Selected();">	
<%

//	String mode;
	String bean_id;
	String bean_name;
	//String function_id;
	//String codeDisabled =	"";
	String disabled		=	"";
	String classvalue = "";
	String display_date = "";
	String expiry_date  = "";
	//String expiry_chk  = "";
	String applyOnLoad=request.getParameter("applyOnLoad")==null?"":request.getParameter("applyOnLoad");

	String expiry_yn= request.getParameter("expiry_yn");
	
		if(expiry_yn.equals("true"))
		{
		expiry_yn="Expiry Dt";
		expiry_date = "Y";
		}
	else 
		{
		expiry_yn="Receipt Dt";
		expiry_date = "N";
		}
	 
	  
	ChangeExpiryFlagBean bean = (ChangeExpiryFlagBean) getBeanObject( "ChangeExpiryFlagBean","eST.ChangeExpiryFlagBean",request );
	if(bean.getExpiry_yn().equals("Y"))
		disabled="";
	else disabled="readonly";

	String sys_date=bean.getSystemDate();
	bean_id = "ChangeExpiryFlagBean" ;
	bean_name = "eST.ChangeExpiryFlagBean";
	//mode=request.getParameter("mode");

	bean.setItem_code(request.getParameter("item_code"));
	/* Mandatory checks start */
	
	/**
			* @Name - Suri
			* @Date - 19/01/2010
			* @Inc# - IN015496
			* @Desc - Code added to accept decimal values dynamically.
			* @ getAllowDecimalsYN() return's 'Y' that accept decimal values dynamically.other wise it should not accept decimal values dynamically. 
			*/
		int no_of_decimals=0;
	 if((bean.getAllowDecimalsYN((String)request.getParameter("item_code"))).equals("Y"))
			no_of_decimals=bean.getNoOfDecimals();
		else
		no_of_decimals=0;
%>
	<form name="formChangeBatchDetails" id="formChangeBatchDetails">
			<table border="1" cellpadding="0" cellspacing="0" width='85%' align='center' >
			<th><fmt:message key="Common.Store.label" bundle="${common_labels}"/></th>
			<th><fmt:message key="Common.Batch.label" bundle="${common_labels}"/></th>
			<th><fmt:message key="Common.Trade.label" bundle="${common_labels}"/></th>
			<th><fmt:message key="Common.BinLocation.label" bundle="${common_labels}"/></th></th>
			<th><fmt:message key="eST.QuantityOnHand.label" bundle="${st_labels}"/></th>
			<th><%=expiry_yn%></th>
<%
ArrayList ALBatchData=new ArrayList();
Hashtable ALBatchChangedData=new Hashtable();
if(bean.getBatchReload().equals("Y")){		
	ALBatchChangedData=(Hashtable)bean.getALBatchChangedData();
}
ALBatchData=(ArrayList)bean.loadBatchData();

HashMap hmRecord=new HashMap();
int i=0;
String strBatchId="";
	for	(i	=0;	i<ALBatchData.size();i++){
		hmRecord	=(HashMap)	ALBatchData.get(i);
		classvalue	=	((i%2)==0)?"QRYODD":"QRYEVEN";
		strBatchId = (String)hmRecord.get("BATCH_ID");
%>
<script>
	  arr_batch_id["<%=i%>"]="<%=strBatchId%>";
</script>
	<tr>
		<td  class="<%=classvalue%>" align="left"><font size=1><%=(String)hmRecord.get("STORE_DESC")%></font></td>
		<td  class="<%=classvalue%>" align="left"><font size=1><%=(String)hmRecord.get("BATCH_ID")%></font></td>
		<td  class="<%=classvalue%>" align="left"><font size=1><%=(String)hmRecord.get("TRADE_NAME")%></font></td>
		<td  class="<%=classvalue%>" align="left"><font size=1><%=(String)hmRecord.get("BIN_LOCATION_CODE")%></font></td>
					<!-- 					
						* @Name - Priya
						* @Date - 19/02/2010
						* @Inc# - IN019466
						* @Desc - To right align QuantityOnHand.				
					-->
		<td  class="<%=classvalue%>" style="TEXT-ALIGN:right"><font size=1><%=bean.setNumber((String)hmRecord.get("QTY_ON_HAND"),no_of_decimals)%>&nbsp;</font></td>
		<%
			if(applyOnLoad.equals("Yes")){
				bean.setExpiry_yn(expiry_date);
			}

			if(bean.getBatchReload().equals("Y")){
					if(expiry_date.equals("N")){
						display_date = sys_date;
					}else{
						display_date = bean.checkForNull((String)ALBatchChangedData.get("expiry_date_or_receipt_date"+i),display_date);
					}
			}else{
				if( ((bean.getItemExpDetails()).equals("Y") ) && (bean.getExpiry_yn().equals("N")) )	{
					display_date = sys_date;
				}
				else if ( ((bean.getItemExpDetails()).equals("N") ) && (bean.getExpiry_yn().equals("Y")) )	 {
					display_date = sys_date;
				}
				else{
					display_date = (String)hmRecord.get("OLD_EXP_REC_DT"); 			
				
				} 
			}
			   
			
			   if(!locale.equals("en"))
			   {
				display_date= com.ehis.util.DateUtils.convertDate(display_date,"DMY","en",locale);
			   }


			
		%>
		<td   class="<%=classvalue%>" align="center"><font size=1><input type text  class="STSMALL" name=expiry_date_or_receipt_date<%=i%> id=expiry_date_or_receipt_date<%=i%> value="<%=display_date%>"  <%=disabled%> size=10 maxlength=10 onBlur="CheckDate(this);setBatchReload('Y');checkSameBatchExpiry(this,'<%=strBatchId%>','<%=i%>');" onChange="setBatchReload('Y');"></font>
			<%if(disabled.equals("readonly")){}else{%>
			<img  src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('expiry_date_or_receipt_date<%=i%>');"  ></img>
			<%}%></td>
	</tr>
	<%}%>
	</table>
	<input type=hidden name=item_code id=item_code>
	<input type=hidden name=expiry_yn id=expiry_yn>
	<input type=hidden name=expiry_date id=expiry_date value="<%=expiry_date%>">
	<input type=hidden name=sys_date id=sys_date value="<%=sys_date%>">
	<input type=hidden name=bean_id id=bean_id value="<%=bean_id%>">
	<input type=hidden name=bean_name id=bean_name value="<%=bean_name%>">
	<input type=hidden name=mode id=mode value="2">
	<input type=hidden name=batchCount id=batchCount value="<%=i%>">
	<input type=hidden name=applyOnLoad id=applyOnLoad value="<%=applyOnLoad%>">
	<script>
			
	</script>
	
	<%
		
		if(applyOnLoad.equals("Yes")){	%>
		<script>
				parent.parent.apply();
		</script>
	<%}%>
</form>
			<%
putObjectInBean("ChangeExpiryFlagBean",bean,request);
%>
</body>
</html>

