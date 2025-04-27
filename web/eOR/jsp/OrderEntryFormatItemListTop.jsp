
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- JSP Page specific attributes start --%>
<%@page  import="eOR.* ,java.util.*,eOR.Common.*" contentType="text/html; charset=UTF-8" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/></link>
	
 	<script language="JavaScript" src="../js/OrderEntryFormatItem.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>

</head>
<SCRIPT LANGUAGE="JavaScript">

var seq_arr = new Array();
var desc_arr = new Array();
var key_arr = new Array();


function callDummy()
{
}


function populateVals(k)
{
	var row=0;
	row=parseInt(k)+1;
	desc=document.getElementById("tabletop").rows[row].cells[0].innerText;
	parent.list_bottom.list_dtl.dontChk.value = k;
	parent.list_bottom.list_dtl.desc.value=desc;
	parent.list_bottom.list_dtl.seq_no.value=(seq_arr[k]);
	parent.list_bottom.list_dtl.old_desc.value=desc;
	parent.list_bottom.list_dtl.old_seq_no.value=(seq_arr[k]);
	parent.list_bottom.list_dtl.mode.value='update';
}

</SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<body OnMouseDown="CodeArrest()"; onKeyDown="lockKey()">
<form name=list_top id='list_top'>
<table width='100%' class='grid' id="tabletop" name="tabletop">
<tr>
	<td class='columnheader'><fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
	<td class='columnheader'><fmt:message key="eOR.SequenceNumber.label" bundle="${or_labels}"/></td>
</tr>

<%
request.setCharacterEncoding("UTF-8");
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String bean_id = "Or_OrderEntryFormatItems" ;
	String bean_name = "eOR.OrderEntryFormatItem";

	OrderEntryFormatItem bean = (OrderEntryFormatItem)getBeanObject( bean_id,bean_name, request ) ;
	bean.setLanguageId(localeName);

	int total_rows=Integer.parseInt(bean.checkForNull(bean.getFormatListValues("total_rows"),"0"));

	if(total_rows>0)
	{
		for(int i=0;i<total_rows;i++)
		{
	
			String			classval= "";
			StringBuffer result=new StringBuffer();
			
	
			if(i%2 == 0){
				classval = "gridData";
			}else{
				classval = "gridData";
			}
		
			result.append("<tr class='"+classval+"'>");
	
			String desc=bean.getFormatListValues("desc_array"+i);	
			out.println("<script>desc_arr["+i+"]='"+java.net.URLEncoder.encode(bean.checkForNull(bean.getFormatListValues("desc_array"+i),""),"UTF-8")+"';</script>");	
			out.println("<script>seq_arr["+i+"]='"+java.net.URLEncoder.encode(bean.checkForNull(bean.getFormatListValues("seq_array"+i),""),"UTF-8")+"';</script>");
			out.println("<script>key_arr["+i+"]='"+java.net.URLEncoder.encode(bean.checkForNull(bean.getFormatListValues("key_array"+i),""),"UTF-8")+"';</script>");
			
			if(bean.getFormatListValues("desc_array0")!=null)
			{
				result.append("<td  class='"+ classval +"'><a class='gridLink' href='javascript:callDummy()' onClick='populateVals(\""+ i+"\")' >");
				
				result.append(desc);
				
				result.append("</a></td>");
				result.append("<td  class='"+ classval +"'><a class='gridLink' href='javascript:callDummy()' onClick='populateVals(\""+ i+"\")' >");
				
				result.append(bean.getFormatListValues("seq_array"+i));
				result.append("</td>");
			    result.append("</tr>");
			}
			
		
			out.println(result.toString());
	
		}
	}
%>
</table>
</form>
</body>
</html>
<%putObjectInBean(bean_id,bean,request);%>

