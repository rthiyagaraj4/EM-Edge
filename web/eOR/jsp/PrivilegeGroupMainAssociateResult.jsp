<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%-- JSP Page specific attributes start --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@page  import="java.util.*, eOR.*, eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>

<html>
<head>

<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>

<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="JavaScript" src="../../eOR/js/PrivilegeGroup.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
  // Function to handle color change based on selection
  function changeSelectColor(selectElement) {
    if (selectElement.value === 'A') {
      selectElement.style.backgroundColor = '#FFFF00'; // Yellow for 'Applicable'
    } else {
      selectElement.style.backgroundColor = '#FFFFFF'; // White for default
    }
  }
 
  // Ensure the initial background color is set correctly on page load
  document.addEventListener('DOMContentLoaded', function () {
    // Find all select elements with IDs matching the pattern 'accessspecifier<index>'
    const selectElements = document.querySelectorAll("[id^='accessspecifier']");
    selectElements.forEach(function (selectElement) {
      if (selectElement.value === 'A') {
        selectElement.style.backgroundColor = '#FFFF00'; // Yellow for default 'Applicable'
      }
    });
  });
</script>





<STYLE TYPE="text/css">

	A:active { 
		COLOR: blue; 
	}

	A:visited { 
		COLOR: blue; 
	}
	A:link { 
		COLOR: blue; 
	}
	table
	{
	    border-spacing: 0px;
	}
 
	</STYLE>

</head>

<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String bean_id = "privilegegroupbean" ;
	String bean_name = "eOR.PrivilegeGroupBean";
	String mode	= request.getParameter("mode");
	String tabValue	= request.getParameter("viewtype");
	boolean flag=false;
	if(tabValue == null ) tabValue="AL";
	String currentview	= request.getParameter("currentview");
	if(currentview == null ) currentview="AL";
	//out.println("<script>alert('tabValue :"+tabValue+"');</script>");
	//out.println("<script>alert('currentview :"+currentview+"');</script>");
	//out.println("<script>alert('mode :"+mode+"');</script>");
	if(mode == null) mode="1";
	PrivilegeGroupBean bean = (PrivilegeGroupBean)getBeanObject( bean_id,  bean_name, request ) ;  
	//bean.clear() ;
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	bean.setLanguageId(localeName);
	//bean.clearDBValues();	 
	Set s,s1,s2,s3;
	Iterator it,it1,it2,it3;

	String hidden="hidden";
	String accessValue="";
	String staticvalue="ALL";
	String catflag="&nbsp;";
	String typeflag="&nbsp;";
	String value="&nbsp;";
%>
<form name="associate_results" id="associate_results">
<table class='grid' width='100%' border='1' align="center">
<%
bean.setDBValues();
s=bean.get_view_code().entrySet();
it = s.iterator();
int i=0;
while (it.hasNext()){ //for tab value
	catflag="&nbsp;";
	typeflag="&nbsp;";
	String temp_value=it.next().toString();
	String[] hashValues=temp_value.split("=");
	//out.println("hashValues[0]"+hashValues[0]);
	//System.out.println("=1=="+hashValues[0]);
	//System.out.println("==2="+bean.get_tab_code().containsKey(hashValues[0]));
	if(bean.get_tab_code().containsKey(hashValues[0]))
	if(tabValue.equals("ALL") || currentview.equals("ALL") || tabValue.equals(hashValues[0]) || currentview.equals(hashValues[0]))
	{
	String Columnvalue=com.ehis.util.BundleMessage.getBundleMessage(pageContext,hashValues[1],"or_labels");
	s1=bean.get_category_code().entrySet();
	it1 = s1.iterator();
	while (it1.hasNext()){ //for category
		String temp_value1=it1.next().toString();
		String[] hashValues1=temp_value1.split("=");
		if(bean.getAllValues().containsKey(hashValues[0]+"!!"+hashValues1[0]))
		{flag=true;%>
		<%if(!staticvalue.equals(hashValues[0])){%>
		<tr><th class='columnheader' colspan=7 style="text-align:left;"> <font size=1><%=Columnvalue%></font></th></tr>
		<%staticvalue=hashValues[0];
			}%>
				<%catflag=hashValues1[1];%>
		<tr>
			<td width='20%' id='category' class="gridData" style='word-wrap:break-word'><%=bean.getCategoryDesc(hashValues1[1])%></td>
			<td width='20%' id='type' class="gridData" style='word-wrap:break-word'>&nbsp;</td>
			<td width='20%' id='catalog'class="gridData"  style='word-wrap:break-word'>&nbsp;</td>
			<%accessValue=bean.getCategoryValue(hashValues[0]+"!!"+hashValues1[0]);
			value=accessValue;
			if(mode.equals("2") && bean.getUpdateAllValues().containsKey(hashValues[0]+"!!"+"C"+"!!"+hashValues1[0]))
			{
				value=bean.getValueForUpdate(hashValues[0]+"!!"+"C"+"!!"+hashValues1[0]);
				if(!value.equals(accessValue))
				hidden="visible";
			}
			%>
			<td width='40%' colspan='4' id='categorycode' class="gridData">
			
			<select name='accessspecifier<%=i%>' id='accessspecifier<%=i%>' onchange='saveAssociateCategory("<%=hashValues[0]%>","<%=hashValues1[1]%>",this,"<%=i%>"); changeSelectColor(this);'>
			<option value='defaultSelect' <%=accessValue.equals("defaultSelect")?"selected":""%>><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></option>
			<option value='A' <%=accessValue.equals("A")?"selected":""%> style='background-color:#FFFF00'><fmt:message key="Common.Applicable.label" bundle="${common_labels}"/></option>
			<!-- <option value='S' <%=accessValue.equals("S")?"selected":""%> style='background-color:#9370DB'>S</option> -->
			<!--<option value='M' <%=accessValue.equals("M")?"selected":""%> style='background-color:#90EE90'>M</option>-->
			<!-- <option value='N' <%=accessValue.equals("N")?"selected":""%> style='background-color:#808080'><fmt:message key="Common.notapplicable.label" bundle="${common_labels}"/> --></option>
			</select><span style='Visibility:<%=hidden%>' id='a_cate<%=i%>'><a class='gridLink' href='#' onClick='undoChanges("<%=hashValues[0]%>","<%=hashValues1[0]%>","C","A","<%=value%>","<%=i%>");'>U</a></span>
			</td>
			<%hidden="hidden";%>
			<!-- <td width='13%' id='typecode' class="gridData">&nbsp;</td>
			<td width='13%' id='catalogcode' class="gridData">&nbsp;</td> -->
		</tr>
		<%}
		s2=bean.get_ordertype_code().entrySet();
		it2 = s2.iterator();
		while (it2.hasNext()){ //for order type
			String temp_value2=it2.next().toString();
			String[] hashValues2=temp_value2.split("=");
			if(bean.getAllValues().containsKey(hashValues[0]+"!!"+hashValues1[0]+"!!"+hashValues2[0]))
			{flag=true;%>
			<%if(!staticvalue.equals(hashValues[0])){%>
			<tr><td class=columnheader colspan=7> <font size=1><%=Columnvalue%></font></td></tr>
			<%staticvalue=hashValues[0];
			}%>
			<tr>
			<%if(catflag.equals(hashValues1[1])){%>
			<td width='20%' id='category' class="gridData" style='word-wrap:break-word'>&nbsp;</td>
				<%}else{%>
			<td width='20%' id='category' class="gridData" style='word-wrap:break-word'><%=bean.getCategoryDesc(hashValues1[1])%></td>
				<%catflag=hashValues1[1];%>
			<%}%>
			<td width='20%' id='type' class="gridData" style='word-wrap:break-word'><%=bean.getOrderTypeDesc(hashValues1[1],hashValues2[1])%></td>
			<%typeflag=hashValues2[1];	%>
			<td width='20%' id='catalog' class="gridData" style='word-wrap:break-word'>&nbsp;</td>
			<td width='13%' id='categorycode' class="gridData">&nbsp;</td>
			<%accessValue=bean.getTypeValue(hashValues[0]+"!!"+hashValues1[0]+"!!"+hashValues2[0]);
			value=accessValue;
			if(mode.equals("2") && bean.getUpdateAllValues().containsKey(hashValues[0]+"!!"+"T"+"!!"+hashValues2[0]))
			{
				value=bean.getValueForUpdate(hashValues[0]+"!!"+"T"+"!!"+hashValues2[0]);
				if(!value.equals(accessValue))
				hidden="visible";
			}
			%>
			<td width='20%'  colspan='2' id='typecode' class="gridData">
			<select name='accessspecifier<%=i%>' id='accessspecifier<%=i%>' onchange='saveAssociateType("<%=hashValues[0]%>","<%=hashValues1[1]%>","<%=hashValues2[1]%>",this,"<%=i%>"); changeSelectColor(this); '>
			<option value='defaultSelect' <%=accessValue.equals("defaultSelect")?"selected":""%>><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></option>
			<option value='A' <%=accessValue.equals("A")?"selected":""%> style='background-color:#FFFF00'><fmt:message key="Common.Applicable.label" bundle="${common_labels}"/></option>
			<!-- <option value='S' <%=accessValue.equals("S")?"selected":""%> style='background-color:#9370DB'>S</option> -->
			<!--<option value='M' <%=accessValue.equals("M")?"selected":""%> style='background-color:#90EE90'>M</option>-->
			<!-- <option value='N' <%=accessValue.equals("N")?"selected":""%> style='background-color:#808080'><fmt:message key="Common.notapplicable.label" bundle="${common_labels}"/> --></option>
			</select><span style='Visibility:<%=hidden%>' id='a_type<%=i%>'><a class='gridLink' href='#' onClick='undoChanges("<%=hashValues[0]%>","<%=hashValues2[0]%>","T","A","<%=value%>","<%=i%>");'>U</a></span>
			</td>
			<%hidden="hidden";%>
			<!-- <td width='13%' id='catalogcode' class="gridData">&nbsp;</td> -->
			</tr>
			<%}
			s3=bean.get_catalog_code().entrySet();
			it3 = s3.iterator();
			while (it3.hasNext()){ //for catalog
				String temp_value3=it3.next().toString();
				String[] hashValues3=temp_value3.split("=");
				String auth_reqd_yn = "";
				if(bean.getAllValues().containsKey(hashValues[0]+"!!"+hashValues1[0]+"!!"+hashValues2[0]+"!!"+hashValues3[0]))
				{flag=true;%>
				<%if(!staticvalue.equals(hashValues[0])){%>
				<tr><th class='columnheader' colspan=7 style="text-align:left;"> <font size=1><%=Columnvalue%></font></th></tr>
				<%staticvalue=hashValues[0];
				}%>
				<tr>
				<%if(catflag.equals(hashValues1[1])){%>
				<td width='20%' id='category' class="gridData" style='word-wrap:break-word'>&nbsp;</td>
				<%}else{%>
				<td width='20%' id='category' class="gridData" style='word-wrap:break-word'><%=bean.getCategoryDesc(hashValues1[1])%></td>
				<%}%>
				<%if(typeflag.equals(hashValues2[1])){ %>
				<td width='20%' id='type' class="gridData" style='word-wrap:break-word'>&nbsp;</td>
				<%}else{%>
				<td width='20%' id='type' class="gridData" style='word-wrap:break-word'><%=bean.getOrderTypeDesc(hashValues1[1],hashValues2[1])%></td>
				<%typeflag=hashValues2[1];	%>
				<%}%>
				<td width='20%'  id='catalog' class="gridData" style='word-wrap:break-word'><%=bean.getCatalogDesc(hashValues1[1],hashValues2[1],hashValues3[1])%><%if(hashValues[0].equalsIgnoreCase("AU")){auth_reqd_yn=bean.getAuthReqdYN((String)hashValues3[1])==null?"N":bean.getAuthReqdYN((String)hashValues3[1]);if(auth_reqd_yn.equalsIgnoreCase("Y")){out.println("*");}}%></td>
				<!-- <td width='13%' id='categorycode' class="gridData">&nbsp;</td>
				<td width='13%' id='typecode' class="gridData">&nbsp;</td> -->
				<%accessValue=bean.getCatalogValue(hashValues[0]+"!!"+hashValues1[0]+"!!"+hashValues2[0]+"!!"+hashValues3[0]);
				value=accessValue;
				if(mode.equals("2") && bean.getUpdateAllValues().containsKey(hashValues[0]+"!!"+"I"+"!!"+hashValues3[0]))
				{
				value=bean.getValueForUpdate(hashValues[0]+"!!"+"I"+"!!"+hashValues3[0]);
				if(!value.equals(accessValue))
				hidden="visible";
				}
				%>
				<td width='40%' colspan='4' id='catalogcode'  class="gridNumericData">
				<select name='accessspecifier<%=i%>' id='accessspecifier<%=i%>' onchange='saveAssociateCatalog("<%=hashValues[0]%>","<%=hashValues1[1]%>","<%=hashValues2[1]%>","<%=hashValues3[1]%>",this,"<%=i%>"); changeSelectColor(this);'>
				<option value='defaultSelect' <%=accessValue.equals("defaultSelect")?"selected":""%>><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></option>
				<option value='A' <%=accessValue.equals("A")?"selected":""%> style='background-color:#FFFF00'><fmt:message key="Common.Applicable.label" bundle="${common_labels}"/></option>
				<!-- <option value='S' <%=accessValue.equals("S")?"selected":""%> style='background-color:#9370DB'>S</option> -->
				<!--<option value='M' <%=accessValue.equals("M")?"selected":""%> style='background-color:#90EE90'>M</option>-->
				<!-- <option value='N' <%=accessValue.equals("N")?"selected":""%> style='background-color:#808080'><fmt:message key="Common.notapplicable.label" bundle="${common_labels}"/> --></option>
				</select><span style='Visibility:<%=hidden%>' id='a_cata<%=i%>'><a class='gridLink' href='#' onClick='undoChanges("<%=hashValues[0]%>","<%=hashValues3[0]%>","I","A","<%=value%>","<%=i%>");'>U</a></span><%hidden="hidden";%>	
				</td>
				
				</tr>
				<%}
			i++;}
		i++;}
	i++;}
}
}
%>
					
</table>
<input type="hidden" name="tabValue" id="tabValue" value="<%=tabValue%>">
<input type="hidden" name="mode" id="mode" value="<%=mode%>">
<INPUT TYPE="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<INPUT TYPE="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
<%if(!flag){%>
<script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","common"));
</script>
	<%}%>
</form>
</body>
</html>

<%
		putObjectInBean(bean_id,bean,request);
 
%>

