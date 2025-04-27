<!DOCTYPE html>
 <%-- saved on 27/10/2005 --%>
<html>
	<%@ page contentType="text/html;charset=UTF-8"  import=" ePH.*, ePH.Common.* , eCommon.Common.*, java.text.*,java.lang.*, java.util.*,java.lang.*, eCommon.XSSRequestWrapper" %>

     <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
	<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
	<head>
		<% 
		request.setCharacterEncoding("UTF-8");
		
		//Added by Himanshu for MMS-ME-SCF-0097 Starts 
		request= new XSSRequestWrapper(request); 
		response.addHeader("X-XSS-Protection", "1; mode=block"); 
		response.addHeader("X-Content-Type-Options", "nosniff"); 
		//Added by Himanshu for MMS-ME-SCF-0097 ends
		
	    String locale			= (String)session.getAttribute("LOCALE");
	  
	    String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
	   ("PREFERRED_STYLE"):"IeStyle.css";
		%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'type='text/css'></link>

		<script language="JavaScript" src="../js/DrugDrugType.js"></script>
		<script language="JavaScript" src="../js/PhCommon.js"></script>
		<script language="Javascript" src="../../eCommon/js/common.js"></script>
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
<%
	String drug_code	=	request.getParameter("drug_code");
	String search = request.getParameter("search")==null?"":request.getParameter("search");
	String mode = request.getParameter("mode")==null?"":request.getParameter("mode");

	int from = Integer.parseInt(request.getParameter("from")==null?"0":request.getParameter("from"));
	int to = Integer.parseInt(request.getParameter("to")==null?"0":request.getParameter("to"));
	boolean selectall=true;
	String bean_id="@DrugDrugTypeBean";
	String bean_name="ePH.DrugDrugTypeBean";
	String selected="";
	String drug_type_code="";
	String selValue="", classValue="";
	ArrayList drugTypeDetails = null;
	DrugDrugTypeBean bean			= (DrugDrugTypeBean)getBeanObject( bean_id, bean_name, request);
	bean.setLanguageId(locale);

	if(search.equals("new")){
		bean.clear();
		drugTypeDetails = (ArrayList)bean.getDrugTypeList(drug_code);
	}
	else
		drugTypeDetails = bean.getdrugTypeDetails();
	int maxRecord = (drugTypeDetails.size() / 5);
	if(maxRecord <= to)
		to = maxRecord-1;
	int index=(from*5);
	int count=from;
%>
	<body  onMouseDown="CodeArrest()" onKeyDown="lockKey()">
		<form name='drugbydrugtypedetailform' id='drugbydrugtypedetailform'>
			<table  width='90%' border=0 >
				<tr>
					<td class='NONURGENT' align="right">
						<input type=hidden name='from' id='from' value='<%=from%>'>
						<input type=hidden name='to' id='to' value='<%=to%>'>
<%
						if(from > 0) {
%>
							<a href='javascript:submitPrevNext(<%=(from-20)%>,<%=(from-1)%>)' text-decoration='none'><fmt:message key="Common.previous.label" bundle="${common_labels}"/></a>
							<input type=hidden name='prevPage' id='prevPage' value='prev'>
<%
						}
						if(!((from+20) >= maxRecord )){
%>
							<a href='javascript:submitPrevNext(<%=(from+20)%>,<%=(from+39)%>)' text-decoration='none'><fmt:message key="Common.next.label" bundle="${common_labels}"/></a>
							<input type=hidden name='nextPage' id='nextPage' value='next'>
<%
						}
%>
					</td>
				</tr>
			</table>
			<table border="1" align="left" width="100%" cellpadding="0" cellspacing="0">
				<tr>
					<th width='70%'><fmt:message key="ePH.DrugType.label" bundle="${ph_labels}"/></th>
					<th width='20%'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/><input type='checkbox' name='selectall' id='selectall' value="" onclick='selectAll(this, "<%=from%>", "<%=to%>");' ></th>
				</tr>
<%
				while(count <= to){
					drug_type_code = (String)drugTypeDetails.get(index++);
					if( (count+1)%2 == 0)  
						classValue="QRYODD";
					else
						classValue="QRYEVEN";
%>
					<tr>
						<input type='hidden' name='drug_type_code<%=count%>' id='drug_type_code<%=count%>' value='<%=drug_type_code%>'>
						<td class='<%=classValue%>' width='70%'>&nbsp;<%=drugTypeDetails.get(index++)%></td>
<%
						if(((String)drugTypeDetails.get(++index)).equals("E")){
							selected="checked";
							selValue = "Y";
						}
						else{
							selected="";
							selValue = "N";
							selectall = false;
						}
%>                       <%//out.println("count------->"+count);%>
                         <%//out.println("selValue------->"+selValue);%>
                         <%//out.println("drug_type_code------->"+drug_type_code);%>
                         <%//out.println("selected------->"+selected);%>

						<td class='<%=classValue%>' width='20%'><input type='checkbox' name='check<%=count%>' id='check<%=count%>'  value='<%=selValue%>'  onclick='drugTypeCheck(this, <%=drug_type_code%>);' <%=selected%>></td>
					</tr>
<%
					index+=2;
					count++;
				}
%>
			</table>
			<input type='hidden' name='mode' id='mode' value='<%=mode%>'>
			<input type='hidden' name='bean_id' id='bean_id' value='<%=bean_id%>'>
			<input type='hidden' name='bean_name' id='bean_name' value='<%=bean_name%>'>
			<input type='hidden' name='drug_code' id='drug_code' value='<%=drug_code%>'>
		</form>
	</body>
	<script>
<%
		if(selectall){
%>
			document.drugbydrugtypedetailform.selectall.checked=true;
			document.drugbydrugtypedetailform.selectall.value="Y";
<%
		}else{
%>
			document.drugbydrugtypedetailform.selectall.checked=false;
			document.drugbydrugtypedetailform.selectall.value="N";
<%
		}
%>
	</script>
<% putObjectInBean(bean_id,bean,request);%>
</html>

