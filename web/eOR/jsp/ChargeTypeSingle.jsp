<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- JSP Page specific attributes start --%>
<%@page  import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8"%>
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
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../js/OrCommon.js"></script>
	<script language="JavaScript" src="../js/OrCommonFunction.js"></script>

	<script language="javascript" src="../../eOR/js/ChargeType.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

			<style>
textarea {
  resize: none;
}
</style>
 </head>
 <body onload='FocusFirstElement()' onMouseDown="CodeArrest()">
 <%
	request.setCharacterEncoding("UTF-8");
 request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
 response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
 response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	/* Mandatory checks start */
	String mode	   = request.getParameter("mode") ;
	
	//String function_id = request.getParameter("function_id") ;
	String bean_id = "Or_charge_type" ;
	String bean_name = "eOR.ChargeType";
	//out.println("mode="+mode+"asdfAS");
	ChargeType bean = (ChargeType)getBeanObject( bean_id,  bean_name, request ) ;
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	bean.clear() ;
	bean.setMode( mode ) ;   
	ArrayList orderCategory_beanVal=new ArrayList();
	/* Initialize Function specific start */

	String order_category="";
	String order_category_desc ="";
	String charge_type_code = "";
	String description = "";
	String explanatory_note="";
	//out.println("description="+description);

	order_category= request.getParameter("order_category").trim();
	order_category_desc= request.getParameter("order_category_desc").trim();
	charge_type_code = request.getParameter("charge_type_code").trim();
	String[] loadDataVal=(String[])bean.loadData(charge_type_code);
		

	description=(loadDataVal[0]==null || loadDataVal[0]=="" )?description:(String)loadDataVal[0];

	//out.println("<script>alert('###description="+description+"')</script>");

	explanatory_note=(loadDataVal[1]==null || loadDataVal[1]=="")?explanatory_note:(String)loadDataVal[1];
//out.println("<script>alert('###explanatory_note="+loadDataVal[1]+"')</script>");
		//out.println("###explanatory_note="+explanatory_note+"####");
		
		loadDataVal=null;
	//description			= request.getParameter("description");
	//explanatory_note			= request.getParameter("explanatory_note");
	//out.println("<script>alert('explanatory_note="+explanatory_note+"')</script>");
	//out.println("<script>alert('order_category_desc="+order_category_desc+"')</script>");

%>
<form name="ChargeTypeSingle" id="ChargeTypeSingle" target='messageFrame'  method="post">
	
	   <table cellpadding=3 cellspacing=0 width="100%" align="center" >
		<tr>
			<td class="label" ></td>
			<td  class="label"><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
			<td align="left" >
		   <input type="text" name="charge_type_code" id="charge_type_code" readOnly value='<%=charge_type_code%>'  size="10" maxLength="10"  disabled><img src="../../eCommon/images/mandatory.gif" align="center"></img>

		</td>
			<td class="label" colspan='2'></td>
		</tr>

		

		<tr>
			<td class="label" ></td>
			<td  class="label"><fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
			<td class="fields"  >
				<input type="text" name="description" id="description"    value="<%=description%>"						
				size="30" maxLength="30"  onBlur="makeValidString(this);" ><img src="../../eCommon/images/mandatory.gif"></img></td>
			</td>
			<td class="label" colspan='2'></td>
		</tr>


		


		<tr>
			<td class="label" ></td>
			<td  class="label"><fmt:message key="Common.OrderCategory.label" bundle="${common_labels}"/></td>

			<td class="fields" >
			<select name="order_category" id="order_category" readOnly disabled>
			
			<%
				orderCategory_beanVal=bean.getChargeTypeOrderCategory();
				String[] record=null;
				for(int i=0;i<orderCategory_beanVal.size(); i++){
					record = (String [])orderCategory_beanVal.get(i);		
						if(record[0].equals(order_category))
					{%>	
						<option value="<%=record[0]%>" selected ><%=record[1]%></option>  
					<%}
						else{%>
							<option value="<%=order_category%>" selected ><%=order_category_desc%></option> 
						
						<%}
						}orderCategory_beanVal=null;
					%>
			</select><img src="../../eCommon/images/mandatory.gif"></img>

			</td>
			<td class="label" colspan='2'></td>
		</tr>

		
		<tr>
			<td class="label" ></td>
			<td  class="label"><fmt:message key="eOR.ExplanatoryText.label" bundle="${or_labels}"/></td>
			<td class="fields">
			<TEXTAREA ROWS='*' COLS='30' name="explanatory_note"  onBlur="makeValidString(this);SPCheckMaxLen('Explanatory Text',this,255);"   size='255' maxlength='255' 
			><%=explanatory_note%></TEXTAREA><img src="../../eCommon/images/mandatory.gif"></img></td>
			</td>
			<td class="label" colspan='2'></td>
		</tr>		
				
		
		

	  </table>
	<input type="hidden" name="mode" id="mode" value="<%=mode%>">
	<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
	<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
	<input type="hidden" name="function_id" id="function_id" value="Charge_Type">
</form>
</body>
</html>
<%
		putObjectInBean(bean_id,bean,request);
 
%>

