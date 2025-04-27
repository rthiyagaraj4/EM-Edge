<!DOCTYPE html>
 <%@page import="ePH.Speciality"%>
<%@page  import=" ePH.DrugQuotaLimitBean,ePH.Common.*,java.util.HashMap,java.util.ArrayList" contentType="text/html;charset=UTF-8"%>  
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>  
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
	<head> 
		<title> </title>
<%
			String locale			=	(String)session.getAttribute("LOCALE");
			String sStyle			=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="JavaScript" src="../js/PhCommon.js"></script>
		<script language="JavaScript" src="../../ePH/js/DrugQuotaLimit.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		</head>
<%
System.out.println("Inside DrugQuotaLimitDetail.jsp");
String bean_id;
String bean_name;
String function_id;
String drug_code				=		(String)request.getParameter("drug_code");
String drug_desc				=		(String)request.getParameter("drug_desc");
String mode= CommonRepository.getCommonKeyValue("MODE_INSERT");
function_id						=		request.getParameter( "function_id" ) ;
bean_id							=		"DrugQuotaLimitBean" ;
bean_name						=		"ePH.DrugQuotaLimitBean";	
int query= 0;
									

DrugQuotaLimitBean bean =		(DrugQuotaLimitBean)getBeanObject( bean_id, bean_name,request );
System.out.println("bean"+bean);
bean.setLanguageId(locale);
bean.setMode( mode ) ;
bean.setFunctionId(function_id);	
	%>	
	
<body>
<form  name='formSpecialityDetail' id='formSpecialityDetail' >

	<table border='1' cellpadding='0' cellspacing='0' width='100%' >
	<tr><th align="left" colspan="6"><fmt:message key="ePH.AssociateSpeciality.label" bundle="${ph_labels}"/></th></tr></table>
	<div class="form-frame">
	<table name="specialityTable"  id="specialityTable">
	<thead>
            <tr>
                <th><fmt:message key="ePH.Speciality.label" bundle="${ph_labels}"/></th>
                <th><fmt:message key="ePH.SetLimitBy.label" bundle="${ph_labels}"/></th>
                <th><fmt:message key="ePH.QuotaLimit.label" bundle="${ph_labels}"/></th>
                <th><fmt:message key="ePH.AdditionalQuotaLimit.label" bundle="${ph_labels}"/></th>
                <th><fmt:message key="ePH.Reset.label" bundle="${ph_labels}"/></th>
                <th><fmt:message key="ePH.Select.label" bundle="${ph_labels}"/></th>
            </tr>
        </thead>
    <tbody>
        <%
			boolean unprocessed=false;
			System.out.println("In DrugQuotaLimitDetail");
			    String classvalue="";
				ArrayList result = bean.getDrugCodeRelatedInfo(drug_code);
				System.out.println("result ="+result);
				if(result!=null){
					query =result.size();
					Speciality data;
			    int i=0;
				for ( i = 0; i < result.size(); i++) {
					data =(Speciality)result.get(i);
					if ( i==0|| i% 2 == 0 ){
						classvalue = "QRYEVEN" ;
					}
					else{
						classvalue = "QRYODD" ;
					}		
					
			%>
            <tr align='left'>
				<td  class="<%=classvalue%>" style="TEXT-ALIGN: right">&nbsp;
				<input type="text" disabled name="splName<%=i+1%>" id="splName<%=i+1%>" size="25" maxlength="20" value ="<%=data.getSpeciality_desc()%>" >
				<input type="hidden" name="splCode<%=i+1%>" id="splCode<%=i+1%>" value ="<%=data.getSpeciality_code()%>" >
				</td class="<%=classvalue%>" style="TEXT-ALIGN: right">
				<%if(data.getSet_limit_by().equals("P")){%>
				 <td class="<%=classvalue%>" style="TEXT-ALIGN: right">
                    <input type="radio" name="set_limit_by_<%=i+1%>" id="set_limit_by_<%=i+1%>" value="patient" checked onclick="toggleLinkVisibility(<%=i+1%>)">Patient
                    <input type="radio" name="set_limit_by_<%=i+1%>" id="set_limit_by_<%=i+1%>" value="quantity" onclick="toggleLinkVisibility(<%=i+1%>)">Quantity
                </td>
				
				<%}else if(data.getSet_limit_by().equals("Q")) {%>
				<td class="<%=classvalue%>" style="TEXT-ALIGN: right">
                    <input type="radio" name="set_limit_by_<%=i+1%>" id="set_limit_by_<%=i+1%>" value="patient" onclick="toggleLinkVisibility(<%=i+1%>)">Patient
                    <input type="radio" name="set_limit_by_<%=i+1%>" id="set_limit_by_<%=i+1%>" value="quantity" checked onclick="toggleLinkVisibility(<%=i+1%>)">Quantity
                </td>
				<%} %>
				
				<td  class="<%=classvalue%>" style="TEXT-ALIGN: right">&nbsp;
				<input type="text" name="quota_limit<%=i+1%>" id="quota_limit<%=i+1%>" value="<%=data.getQuota_limit()%>" size='5' maxlength="3" onkeypress="return isNumber(event)" onchange="isNotZero(this);">
				 </td>
				<td  class="<%=classvalue%>" style="TEXT-ALIGN: right">&nbsp;
				<input type='text' name="additional_quota_limit<%=i+1%>" id="additional_quota_limit<%=i+1%>" value="<%=data.getAdditional_quota_limit()%>" size='5' maxlength='3' onkeypress="return isNumber(event)" onchange="isNotZero(this);">
				</td>
				<td class="<%=classvalue%>" style="TEXT-ALIGN: right">&nbsp;
				     <%if(data.getSet_limit_by().equals("P")){%>
                     <a href="#"  class="reset-link" style="display:block;" name="resetLink<%=i+1%>" onclick="confirmReset(<%=i+1%>)" >Reset</a>
                     <%}else if(data.getSet_limit_by().equals("Q")) {%>
                     <a href="#"  class="reset-link" style="display:none;" name="resetLink<%=i+1%>" onclick="confirmReset(<%=i+1%>)" >Reset</a>
                     <%} %>
                     <input type="hidden" name="resetClicked<%=i+1%>" id="resetClicked<%=i+1%>" value ="No" >
                </td>
                <td class="<%=classvalue%>" style="TEXT-ALIGN: right">&nbsp;
                    <input type="checkbox" name="select<%=i+1%>" id="select<%=i+1%>" >
                </td>
			</tr>
			<%} %>
            
            <input type="hidden" name="row_no" id="row_no" value= <%=i+1%> >
			<input type="hidden" name="query" id="query" id="querymode" value=<%=query%>  >
            <%} %>
</tbody>
</table>
	<table>
	<tr>
    <td >
        <br><br>
        <input type="button" id="deleteButton" value="Delete"  onclick="deleteSelectedSpecialties();" style="float: right;">
    </td> 
	</tr>

	<input type="hidden" name="mode" id="mode" value="<%= mode %>">
	<input type="hidden" name="bean_id" id="bean_id" value="<%= bean_id %>">
	<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
	<INPUT TYPE="hidden" name="function_id" id="function_id" VALUE="<%=bean.getFunctionId()%>"> 
	<input type="hidden" name="drug_code" id="drug_code" value="<%=drug_code%>">
	<input type="hidden" name="drug_desc" id="drug_desc" value="<%=drug_desc%>">    
	</table>      
    
    </div>	
    </form>
		<%
				putObjectInBean(bean_id, bean, request);
		%>		
</body>
</html>

