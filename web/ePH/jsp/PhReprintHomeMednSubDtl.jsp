<!DOCTYPE html>
<!--  Author 	:	Arun M (157457)
Module name 	:	ePH
Function 	:	RePrint for Home Medication Summary-->
 <%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- Mandatory declarations end --%>

<html>
<head>
	<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
	String locale			= (String)session.getAttribute("LOCALE");
	

String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../ePH/js/PhCommon.js"></script>
	<script language="JavaScript" src="../../ePH/js/PhReprintHomeMdn.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<body onMouseDown="CodeArrest()"  onKeyDown="lockKey()">
<%
	/* Mandatory checks start */
	 String pres_id			=	request.getParameter( "pres_id" )==null?"": request.getParameter( "pres_id" ).toString();
	 String unCheck_data	=	request.getParameter( "uncheck_data" )==null?"": request.getParameter( "uncheck_data" ).toString();
	 String patient_id		=	request.getParameter( "patient_id" )==null?"": request.getParameter( "patient_id" ).toString();//Added for RUT-SCF-0384[IN46988]
	 String from 			=	CommonBean.checkForNull(request.getParameter("from"));
	 String to 				=	CommonBean.checkForNull(request.getParameter("to"));
	 String bean_id 		=	"PhReprintHomeMednBean";
	 String bean_name 		=	"ePH.PhReprintHomeMednBean";
	 String classvalue		=	"";
PhReprintHomeMednBean bean = (PhReprintHomeMednBean)getBeanObject( bean_id, bean_name , request) ;
	bean.setLanguageId(locale);
	bean.setPatientId(patient_id);//Added for RUT-SCF-0384[IN46988]
	if(!pres_id.equals(""))
		bean.setPresidList(pres_id,unCheck_data);
	else // Modified for RUT-SCF-0384[IN46988]
		bean.setPresidListremove(pres_id,unCheck_data);
	
	ArrayList pres_list=bean.getPresidList();
	ArrayList Subdtl_list=bean.getHomeMednSubDtlData(pres_list);
	ArrayList SelectedChecks=bean.getselected_checks();//Added for RUT-SCF-0383[Inc:46980]-Alpha ReOpen
	String select="";//Added for RUT-SCF-0383[Inc:46980]-Alpha ReOpen
	List tempList=new ArrayList();//Added for RUT-SCF-0383[Inc:46980]-Alpha ReOpen
	int start = 0 ;
	int end = 0 ;
	int i = 0;
	int m=0;
	int maxRecord	= 0;
	 int query_result_size		= 5;
		
         if ( from == null || from.equals(""))
			start = 1 ;
		else
			start = Integer.parseInt(from) ;

		if ( to == null || to.equals(""))
			end =query_result_size;
		else
			end = Integer.parseInt(to) ;
			
			
			maxRecord = Subdtl_list.size();	

%>

<form name="PhReprintHomeMednSubDtlForm" id="PhReprintHomeMednSubDtlForm" >
	<table cellpadding=0 cellspacing=0 width="100%" align="center" border="0" id="presidsubdtltable">
	<tr><td></td><td></td><td></td><td></td><td></td>
					<td align='right'  id='prevNext'  class='BODYCOLORFILLED'>
	<%
	    				if ( !(start <= 1)) {
	%>
			 				<a href='javascript:SubmitLink("<%=(start-query_result_size)%>","<%=(end-query_result_size)%>","<%=(pres_list)%>")' text-decoration='none'><fmt:message key="Common.previous.label" bundle="${common_labels}"/></a>	
	<%
	    				}
	    				if ( !((start+5) > Subdtl_list.size() )){
	%>
	    					<a href='javascript:SubmitLink("<%=(start+query_result_size)%>","<%=(end+query_result_size)%>","<%=(pres_list)%>")' text-decoration='none'><fmt:message key="Common.next.label" bundle="${common_labels}"/></a>
	<%
	    				}
	%>
					</td>
					</tr>
		<tr> 
			<th class="border" width="6%" ><fmt:message key="Common.no.label" bundle="${common_labels}"/></th>
			<th class="border" width="25%"><fmt:message key="Common.ItemDescription.label" bundle="${common_labels}"/> </th>
			<th class="border" width="15%"><fmt:message key="Common.Instructions.label" bundle="${common_labels}"/></th>
			<th width="10%" class="border"><fmt:message key="ePH.PrescribedQty.label" bundle="${ph_labels}"/></th>
			<th width="10%" class="border"><fmt:message key="ePH.DispensedQty.label" bundle="${ph_labels}"/></th>
			<th class="border" width="10%"><fmt:message key="Common.Select.label" bundle="${common_labels}"/></th>
		</tr>
		<%
		if ( start != 1)
				for( int j=1; j<start; i++,j++ ) {   }
			
			
				if ( i % 2 == 0 )
				classvalue = "QRYODD" ;
				else
				classvalue = "QRYEVEN" ;
				
				while(i<end && i<Subdtl_list.size())	{
					String subdtl_delimit=Subdtl_list.get(i).toString();
					subdtl_delimit=subdtl_delimit.replace("[", "");
					subdtl_delimit=subdtl_delimit.replace("/]","");
					String[] subdtl_arr=subdtl_delimit.split("/,"); 
			%>
		<tr>
			<%for(int j=0;j<subdtl_arr.length;j++){ 
			if(j==0){%>
			<td class="label" align="center"><%=subdtl_arr[j] %></td>
			<%}else if(j==1){ %>
			<td class="label" align="center"><%=subdtl_arr[j] %></td>
			<input type="hidden" name="item_desc_<%=i%>" id="item_desc_<%=i%>" value='<%=subdtl_arr[j] %>'><!--Added for RUT-SCF-0383[IN46980]-->
			<%}else if(j==2){ %>
			<td class="label" align="center"><%=subdtl_arr[j] %></td>
			<%}else if(j==3){ %>
			<td class="label" align="center"><%=subdtl_arr[j] %></td>
			<%}else if(j==4){ %>
			<td class="label" align="center"><%=subdtl_arr[j] %></td>
			<input type="hidden" name="disp_qty_<%=i%>" id="disp_qty_<%=i%>" value='<%=subdtl_arr[j] %>'><!--Added for RUT-SCF-0383[IN46980]-->
			<%}else if(j==5){ %>
			<input type="hidden" name="doc_no_<%=i%>" id="doc_no_<%=i%>" value='<%=subdtl_arr[j] %>'>
			<%}else if(j==6){ %>
			<input type="hidden" name="doc_srl_no_<%=i%>" id="doc_srl_no_<%=i%>" value='<%=subdtl_arr[j] %>'>
			<%}else if(j==7){ %>
			<input type="hidden" name="order_id_<%=i%>" id="order_id_<%=i%>" value='<%=subdtl_arr[j] %>'>
			<%}else if(j==8){ %>
			<input type="hidden" name="order_line_num_<%=i%>" id="order_line_num_<%=i%>" value='<%=subdtl_arr[j] %>'>
			<%}else if(j==9){ //Added 'DISP_NO' for [IN:45916]%>
			<input type="hidden" name="disp_no_<%=i%>" id="disp_no_<%=i%>" value='<%=subdtl_arr[j] %>'>
			<%} } %>
			<%
			//Added if condition for RUT-SCF-0383[Inc:46980]-AlphaReOpen
			tempList.add(subdtl_arr[5]+"/"+subdtl_arr[9]+"/"+subdtl_arr[6]+"/"+subdtl_arr[7]+"/"+subdtl_arr[8]+"/"+subdtl_arr[1]+"/"+subdtl_arr[4]);//Added for RUT-SCF-0383[IN46980]
			if(SelectedChecks.contains(tempList)) //Added for RUT-SCF-0383[IN46980]
				{
					select="checked";
			    }
			tempList.clear();//Added for RUT-SCF-0383[IN46980]
			%>
			<!--<td align="center"><input type="checkbox" name="selected" id="selected" value="E" ></td>--><!--Commented for RUT-SCF-0383[Inc:46980]-AlphaReOpen -->
			<td align="center"><input type="checkbox" name="selected_<%=i%>" id="selected_<%=i%>" value="E" onclick="storecheckbox('<%=i%>')"  <%=select%> ></td><!--Added for RUT-SCF-0383[Inc:46980]-AlphaReOpen-->
		</tr>
		<% i++;
		   m++;//Added for RUT-SCF-0383[Inc:46980]-AlphaReOpen
		  select="";//Added for RUT-SCF-0383[Inc:46980]-AlphaReOpen
		 }%>
	</table>
	<input type="hidden" name="number_of_rows" id="number_of_rows" value="">
	<input type="hidden" name="totalRecords" id="totalRecords" value="<%=maxRecord%>">
	<input type="hidden" name="from" id="from" value="<%=start%>">
	<input type="hidden" name="to" id="to" value="<%=end%>">
	<input type="hidden" name="pres_list" id="pres_list" value="<%=pres_list%>">
	<input type="hidden" name="count" id="count" value="<%=i%>"><!--Added for RUT-SCF-0383[Inc:46980]-Alpha ReOpen-->
</form>
</body>
</html>

<%
putObjectInBean(bean_id,bean,request);
%>

