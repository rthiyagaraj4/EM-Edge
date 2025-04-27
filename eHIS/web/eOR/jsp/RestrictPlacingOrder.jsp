<!DOCTYPE html>
<%
/*
-------------------------------------------------------------------------------------------------------------------------------------
Date		  Edit History	   Name				   Rev.Date		Rev.Name		       Description
-------------------------------------------------------------------------------------------------------------------------------------
16/05/2022     29147      krishna pranay       17/05/2023     Ramesh Goli              MO-CRF-20183

-------------------------------------------------------------------------------------------------------------------------------------
*/ 
%>
<%@page  import="java.util.*, eOR.* "  contentType="text/html; charset=UTF-8"%>
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
 	<script language="JavaScript" src="../js/RestrictPlacingOrder.js"></script>
	<script language="JavaScript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
 <body onMouseDown="CodeArrest()" onKeyDown="lockKey()" > 
 
<% 	request.setCharacterEncoding("UTF-8");	
	Properties p;
	session = request.getSession(false);
	p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");
	String mode	   = request.getParameter( "mode" ) ;
	String bean_id = "Or_RestrictPlacingOrdersBean" ;
	String bean_name = "eOR.RestrictPlacingOrdersBean";
	RestrictPlacingOrdersBean bean = (RestrictPlacingOrdersBean)getBeanObject( bean_id, bean_name , request) ;  
	bean.clear() ;
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	bean.setMode( mode ) ;
	ArrayList Category_Data = new ArrayList();

%>

<form name="restrict_place_order" id="restrict_place_order" method="post" target="messageFrame">
<table cellpadding=3 cellspacing=0 width="100%" align=center class='grid' >
<tr>
	<td colspan=2 >
		<tr>
			<td class=' COLUMNHEADER' width='10%'><fmt:message key="Common.OrderCategory.label" bundle="${common_labels}"/></td>
			<td class=' COLUMNHEADER' width='10%'><input type="checkbox" id="allChecked" name="allChecked"  onClick="checkAll(this);"/>
			<fmt:message key="eOR.RestrictPlacingOrdersForSelf.label" bundle="${or_labels}"/>
			</td>
			<td class=' COLUMNHEADER' width='10%' ><input type="checkbox" id="allSelected" name="allSelected"  onClick="selectAll(this);" />
			<fmt:message key="eOR.RestrictPlacingOrdersForFamilyMembers.label" bundle="${or_labels}"/>
			</td>
		</tr>
	<%  
		String totalRecord="";
	    String totalRecordFamily="";
	    String totalRecordSelf="";
	    String checked1="";
	    String rest_order_self_yn="";
	    String rest_order_family_yn="";
	    int selectedRecSelf=0;
	    int selectedRecFamily=0;
		
		Category_Data = bean.getRestrictPlacingOrdersDetails(locale) ;
		if(Category_Data.size()>0){
			for(int i=0;i<Category_Data.size();i++){
				String[] record = (String [])Category_Data.get(i);
				if("Y".equals(record[2]))
				{
					selectedRecSelf++;
				}
				
			   	if("Y".equals(record[3]))
				{
					selectedRecFamily++;
				}
				
				   
				%>
	            <tr>
					<td  class='gridData'><%=record[1]%> 
							<input type=hidden name=order_category<%=i%> value=<%=record[0]%>>
					</td>	
			        <td  class='gridData' ><input type='checkbox' id="rest_order_self_yn<%=i%>" name="rest_order_self_yn<%=i%>"    value="<%=record[2]%>" <%=(record[2].equals("Y"))?"checked":""%> onClick="selfCheck(this);"></td>
					<td  class='gridData'><input type='checkbox' id="rest_order_family_yn<%=i%>" name="rest_order_family_yn<%=i%>"   value="<%=record[3]%>" <%=(record[3].equals("Y"))?"checked":""%> onClick="familyCheck(this);"></td>
				</tr>
					
			<%	
			}
		}
		%>
	</td>
</tr>
</table>

<input type=hidden name='totalRecord' id='totalRecord' value='<%=Category_Data.size()%>'/>	
<input type=hidden name='totalRecordFamily' id='totalRecordFamily' value='<%=selectedRecFamily%>'/>
<input type=hidden name='totalRecordSelf' id='totalRecordSelf' value='<%=selectedRecSelf%>'/>



</form>

<script>
if(document.forms[0].totalRecord.value == document.forms[0].totalRecordSelf.value)
document.forms[0].allChecked.checked=true; 

if(document.forms[0].totalRecord.value == document.forms[0].totalRecordFamily.value)
document.forms[0].allSelected.checked=true;
</script>


</body>

</html>
<%
putObjectInBean( bean_id, bean , request) ;  
%>

