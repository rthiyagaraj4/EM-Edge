<!DOCTYPE html>
<%@ page import="java.net.URLDecoder,eCommon.XSSRequestWrapper" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ include file="../../eOT/jsp/StringUtil.jsp" %>
<% request.setCharacterEncoding("UTF-8");%>
<html>
<title><fmt:message key="Common.others.label" bundle="${common_labels}" /></title>
<script type="text/javascript" src="../../eDS/js/PlaceDietOrder.js"></script>
<script type="text/javascript" src="../../eDS/js/DSCommon.js"></script>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script language="JavaScript" src="../../eDS/js/DocumentOPMealServed.js"></script>
<script language="JavaScript" src="../../eDS/js/MealPreparedServedComplaints.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<head>
<%  
    //Added Against MMS Vulnerability Issue - Starts
    request= new XSSRequestWrapper(request);
    response.addHeader("X-XSS-Protection", "1; mode=block");
    response.addHeader("X-Content-Type-Options", "nosniff");
	//Added Against MMS Vulnerability Issue - Ends
	
	//String othersCmpHdr = java.net.URLDecoder.decode(request.getParameter("othersCmpHdr"),"UTF-8");
	String othersCmpHdr = request.getParameter("othersCmpHdr"); //Modified Against ML-MMOH-CRF-1816
	//Against ML-MMOH-CRF-1816 Starts 
	if(othersCmpHdr.contains("& #39;"))
	othersCmpHdr = othersCmpHdr.replace("& #39;", "'");	
	//Against ML-MMOH-CRF-1816 Ends
	String index = request.getParameter("index");
	System.err.println("14 othersCmpHdr===>"+othersCmpHdr+"==index=="+index);
	int count = Integer.parseInt(index);
	System.err.println("19,count===>"+count);
	if(othersCmpHdr.equals("") || othersCmpHdr.equals("undefined") || othersCmpHdr.equals("null"))
	{
		othersCmpHdr ="";
	}	
%>
<body>
<form> 
	<table>
 		<tr>
			<td>
			<!--<textarea id="OTHERS" name="OTHERS" rows=10 cols=50 onkeyup="textAreaLimit1(this,30);" onkeypress="restrictSpecialChars(event)"><%=othersCmpHdr%></textarea>-->
			<textarea id="OTHERS" name="OTHERS" rows=10 cols=50 onkeyup="textAreaLimit1(this,50);"><%=othersCmpHdr%></textarea><!--Modified Against ML-MMOH-CRF-1816-->
				<input type='hidden' id="count" name="count" id="count" value="<%=count%>"/>
			</td>
			
  		</tr>
  		<tr>
  			<td align="right">
				<input type="button" name="" id="" value='<fmt:message key="eOT.Ok.label" bundle="${ot_labels}" />' onClick='getOthersCompliants(document.getElementById("OTHERS").value)' class="button" >
				<input name="cancel" id="cancel" type="button" value="<fmt:message key="eOT.Cancel.label" bundle="${ot_labels}" />" class="button" onClick="window.close();" />
			</td>
  		</tr>
	</table>

</form>
</body>
</head>
</html>

