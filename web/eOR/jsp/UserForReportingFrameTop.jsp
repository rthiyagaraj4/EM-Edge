<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<!--
The logic of implementing this modal window functionality is based on the array.
There are many array as the number of the columns/objects in the form.
Both in the case of adding new set, a new element is added to all the arrays and
while updating the existing set the corresponding array elements from
all the arrays are accessed and populated

-->
<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@page  import="java.util.*, eOR.*,eCommon.XSSRequestWrapper"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>

<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>

<HTML>
<HEAD>
    <TITLE></TITLE>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../js/UserForReporting.js"></script> 
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>

</HEAD>
<SCRIPT LANGUAGE="JavaScript">
	var facility_id_arr				= new Array();
	var facility_name_arr			= new Array();
	var location_id_arr				= new Array();
	var location_name_arr			= new Array();
</Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%

	String finalString = java.net.URLDecoder.decode(request.getParameter("finalString"),"UTF-8");
	String pract_id = request.getParameter("practitioner_id");
//	out.println("<script>alert('pract_id:"+pract_id+"');</script>");
	String resp_id = request.getParameter("responsibility");
//	out.println("<script>alert('resp_id:"+resp_id+"');</script>");
	String order_category = request.getParameter("order_category");
//	out.println("<script>alert('order_category:"+order_category+"');</script>");
//	String bean_id	= request.getParameter("bean_id");

	finalString = (finalString == null) ? "" : finalString;
	pract_id = (pract_id == null) ? "" : pract_id;
	resp_id = (resp_id == null) ? "" : resp_id;
//out.println("<script>alert('responsibility_id:"+responsibility_id+"');</script>");
	order_category = (order_category == null) ? "" : order_category;
//	bean_id	= (bean_id == null) ? "" : bean_id;

	String bean_id = "Or_UserForReporting" ;
	//String bean_name = "eOR.UserForReporting";
	UserForReporting bean = (UserForReporting)getBeanObject( bean_id,"eOR.UserForReporting" ,request ) ;
%>
<body onLoad='onLoadDef()' OnMouseDown="CodeArrest()"; onKeyDown="lockKey()">
<form name=list_top><%//out.println("<script>alert('hi');</script>");%>
<table cellpadding=3 cellspacing=0 border=1 width='100%' align='center'>
<tr>
	<td class=' COLUMNHEADER'><fmt:message key="Common.PerformingFacility.label" bundle="${common_labels}"/></td>
	<td class=' COLUMNHEADER'><fmt:message key="Common.PerformingLocation.label" bundle="${common_labels}"/></td>
</tr>
<%//ArrayList perform_values = new ArrayList();
//String perform_values= "";
//		perform_values = bean.getDetailData( resp_id, pract_id, order_category);
//		out.println("<script>alert('perform_values::"+finalString+"---');</script>");
//out.println(perform_values);
if(!finalString.equals("")){
	StringTokenizer st1		= new StringTokenizer(finalString,"`");

	StringBuffer	result	= new StringBuffer();
	String			mainStr = "";
	String			subStr	= "";
	int				count	= 0;
	String			classval= "";
	String			tempStr = "";
	int				j		= 0;
	StringTokenizer st2=null;
	String[] record = null ;
	String allValues = "";
	while(st1.hasMoreTokens()){
		if(j%2 == 0){
			classval = "QRYODD";
		}else{
			classval = "QRYEVEN";
		}

		mainStr  = st1.nextToken();
		st2 = new StringTokenizer(mainStr,"~");
		result.append("<tr class='"+classval+"'>");
		record = new String[4] ;
		allValues = "";
		int i=0;

		//this while loop will put the tokenised values to the respective arrays
		while(st2.hasMoreTokens()){
			record[i] = st2.nextToken();
			allValues = allValues+record[i] + "~";

			if(record[i] == null || record[i].trim().equals("null"))
				record[i] = " ";
			//Fill the arrays
			if(i==0){
				out.println("<script>facility_id_arr["+j+"]='"+record[i]+"'</script>");
			}else if(i==1){
				out.println("<script>facility_name_arr["+j+"]='"+record[i]+"';</script>");
			}else if(i==2){
				out.println("<script>location_id_arr["+j+"]='"+record[i]+"';</script>");
				record[i] = tempStr;
			}else if(i==3){
				out.println("<script>location_name_arr["+j+"]='"+record[i]+"';</script>");
			}
			i++;
		}

		//boolean flag = false ;

		subStr = record[1];

		//this for loop will build the string of "<td>" and thus the final out put of HTML Table
		for(int k=0; k<record.length; k++){
			if(k==0 ||k==2)
				continue;
			subStr = record[k];

			if (subStr == null || subStr.equals("null")) subStr = " ";

			result.append("<td  class='"+ classval +"'>");

			if(k==1)
				result.append("<a href='javascript:populateVals(\""+allValues+"\",\""+ finalString+"\", this ,\""+ j+"\")' >");
            result.append(subStr);

			if(k==3)
				result.append("</a></td>");
		}

		i=0;

		j++;
		result.append("</tr>");
		count++;
	}
	out.println(result.toString());
	result.setLength(0);
}

%>
<input type='hidden' name='order_category' id='order_category' value='<%=order_category%>'>
<input type='hidden' name='finalString' id='finalString' value='<%=finalString%>'>
<input type='hidden' name='bean_id' id='bean_id' value='<%=bean_id%>'>
<input type="hidden" name="localeName" id="localeName" value="<%=localeName%>">
</form>
</BODY>
</HTML>
<%
	putObjectInBean(bean_id,bean,request);
%>

