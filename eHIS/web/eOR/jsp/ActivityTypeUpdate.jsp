<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- JSP Page specific attributes start --%>
<%@page  import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper"  contentType="text/html; charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
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
	<script language="JavaScript" src="../js/OrCommon.js"></script>
	<script language="JavaScript" src="../js/OrCommonFunction.js"></script>
	<script language="javascript" src="../../eOR/js/ActivityType.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<script>

function setCheckStatus(thisObj)
{
			if(thisObj.checked == true){
				if(document.ActivityTypeUpdate.long_desc.disabled==true)
						document.ActivityTypeUpdate.long_desc.disabled=false;
				if(document.ActivityTypeUpdate.long_desc.readOnly==true)
						document.ActivityTypeUpdate.long_desc.readOnly=false;
				if(document.ActivityTypeUpdate.short_desc.disabled==true)
						document.ActivityTypeUpdate.short_desc.disabled=false;
				if(document.ActivityTypeUpdate.short_desc.readOnly==true)
						document.ActivityTypeUpdate.short_desc.readOnly=false;
						}
			else {
						thisObj.focus();
						if(document.ActivityTypeUpdate.long_desc.disabled==false){
						document.ActivityTypeUpdate.long_desc.disabled=true;
						}
						if(document.ActivityTypeUpdate.long_desc.readOnly==false){
						document.ActivityTypeUpdate.long_desc.readOnly=true;
						}
						if(document.ActivityTypeUpdate.short_desc.disabled==false){
						document.ActivityTypeUpdate.short_desc.disabled=true;
						}
						if(document.ActivityTypeUpdate.short_desc.readOnly==false){
						document.ActivityTypeUpdate.short_desc.readOnly=true;
						}
				}
		}
</script>
 </head>
 <body onload='FocusFirstElement()' onMouseDown="CodeArrest()">
 <%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	/* Mandatory checks start */
	String mode	   = request.getParameter("mode") ;
//	System.out.println("mode==="+mode);
	//String function_id = request.getParameter("function_id") ;
	String bean_id = "Or_activity_type" ;
	String bean_name = "eOR.ActivityType";
	//out.println("mode="+mode+"asdfAS");
	ActivityType bean = (ActivityType)getBeanObject( bean_id,  bean_name , request) ;
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	bean.clear() ;
	bean.setMode( mode ) ;   
	ArrayList orderCategory_beanVal=new ArrayList();
	/* Initialize Function specific start */

	String order_category="";
	String eff_status = "";
	//String order_category_desc ="";
	String activity_type = "";
	String long_desc = "";
	String short_desc="";
	String order_type_code="";
	String order_type_desc="";

	order_category= request.getParameter("order_category").trim();
	activity_type = request.getParameter("activity_type").trim();
	//long_desc			= request.getParameter("long_desc");
	eff_status = request.getParameter("eff_status").trim();
	//short_desc = request.getParameter("short_desc");
	//order_type_code=request.getParameter("order_type_code").trim();
	//order_type_desc=request.getParameter("order_type_desc").trim();

//	System.out.println("mode==="+mode);
	String[] loadDataVal=(String[])bean.loadData(activity_type);
		
	long_desc		= loadDataVal[0]==null?long_desc:(String)loadDataVal[0];
	short_desc		= loadDataVal[1]==null?short_desc:(String)loadDataVal[1];
	eff_status		= loadDataVal[2]==null?eff_status:(String)loadDataVal[2];
	order_type_code	= loadDataVal[5]==null?order_type_code:(String)loadDataVal[5];
	order_type_desc	= loadDataVal[6]==null?order_type_desc:(String)loadDataVal[6];

			
	loadDataVal=null;

%>
<form name="ActivityTypeUpdate" id="ActivityTypeUpdate" target='messageFrame'  method="post">
	
	   <table cellpadding=3 cellspacing=0 width="100%" align="center">
	 
      <tr>
			<td class="label" ></td>
			<td  class="label"><fmt:message key="Common.code.label" bundle="${common_labels}"/></td> 
			<td  class="fields" >
		   <input type="text" name="activity_type" id="activity_type" readOnly value='<%=activity_type%>'  size="10" maxLength="10"  disabled><img src="../../eCommon/images/mandatory.gif" align="center"></img>
      </td>
	 	<td class="label" colspan='2'></td>
		
		</tr>
		
		<tr>
			<td class="label" ></td>
			<td  class="label"><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
			<td class="fields">
				<input type="text" name="long_desc" id="long_desc"    value="<%=long_desc%>"
						<%if(!eff_status.equals("E"))out.println("disabled");%>
						<%if(!eff_status.equals("E"))out.println("readOnly");%>
				size="30" maxLength="30"  onBlur="makeValidString( this );" ><img src="../../eCommon/images/mandatory.gif"></img>
				
			</td>
	
      	<td class="label" colspan='2'></td>
		</tr>
	
		<tr>
			<td class="label" ></td>
			<td  class="label"><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
			<td class="fields">
			<input type="text" name="short_desc" id="short_desc"    value="<%=short_desc%>"
						<%if(!eff_status.equals("E"))out.println("disabled");%>
						<%if(!eff_status.equals("E"))out.println("readOnly");%>
			size="15" maxLength="15"  onBlur="makeValidString( this );" ><img src="../../eCommon/images/mandatory.gif"></img></td>
		
		 <td class="label" colspan='2'></td>
		</tr>
	
		<tr>
			<td class="label" ></td>
			<td  class="label"><fmt:message key="Common.OrderCategory.label" bundle="${common_labels}"/></td>
			<td class="fields">
			<select name="order_category" id="order_category" readOnly disabled>
			<%
				orderCategory_beanVal=bean.getActivityTypeOrderCategory();
				String[] record=null;
				for(int i=0;i<orderCategory_beanVal.size(); i++){
					record = (String [])orderCategory_beanVal.get(i);		
						if(record[0].equals(order_category))
					{%>	
						<option value="<%=record[0]%>" selected ><%=record[1]%></option>  
					<%}
						}orderCategory_beanVal=null;
					%>
			</select><img src="../../eCommon/images/mandatory.gif" align="center"></img>

			</td>
			
		<td class="label" colspan='2'></td>
		</tr>
			
		<tr>
			<td class="label" ></td>
			<td  class="label"><fmt:message key="Common.OrderType.label" bundle="${common_labels}"/></td>
			<td class="fields" >
				<select name="order_type" id="order_type" readOnly disabled>
				<option value="<%=order_type_code%>" selected><%=order_type_desc%></option>
				</select><img src="../../eCommon/images/mandatory.gif"></img>
			</td>
			<td class="label" colspan='2'></td>
		</tr>
		 
		
		<tr>
			<td class="label" ></td>
			<td  class="label"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>

			<td class="fields">

			<input type="checkbox" name='eff_status' id='eff_status'   onClick=''   <%if(eff_status.equals("E"))out.println("checked");%>>
			</td>
			<td class="label" colspan='2'></td>
		</tr>
		
	  </table>
	<input type="hidden" name="mode" id="mode" value="<%=mode%>">
	<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
	<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
	<input type="hidden" name="function_id" id="function_id" value="Activity_Type">
</form>
</body>
</html>

<%
		putObjectInBean(bean_id,bean,request);
 
%>

