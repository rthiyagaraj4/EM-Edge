<!DOCTYPE html>

<html>
	<%@ page contentType="text/html;charset=UTF-8"  import=" ePH.*, ePH.Common.* , eCommon.Common.*, java.text.*,java.lang.*, java.util.*,java.lang.*,eCommon.XSSRequestWrapper" %>

     <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
	<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
	<head>
		<% 
		request.setCharacterEncoding("UTF-8");
		//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
		request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
		response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
		response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
		//ends
	    String locale			= (String)session.getAttribute("LOCALE");
	  //
	    String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
	   ("PREFERRED_STYLE"):"IeStyle.css";

		%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'type='text/css'></link>

		<script language="JavaScript" src="../js/LocationStoreItems.js"></script>
		<script language="JavaScript" src="../js/PhCommon.js"></script>
		<script language="Javascript" src="../../eCommon/js/common.js"></script>
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
			<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
<%
	String disp_loc_code	=	request.getParameter("disp_loc_code");
	String search = request.getParameter("search")==null?"":request.getParameter("search");
	String mode = request.getParameter("mode")==null?"":request.getParameter("mode");

	int from = Integer.parseInt(request.getParameter("from")==null?"0":request.getParameter("from"));
	int to = Integer.parseInt(request.getParameter("to")==null?"0":request.getParameter("to"));
	String item_type=request.getParameter("item_type");
	String item_search_code=request.getParameter("item_search_code");
	if(item_search_code == null) item_search_code = "";
	String item_search=request.getParameter("item_search");
	if(item_search == null) item_search = "";
	boolean selectall=true;
	String bean_id="@LocationStoreItemsBean";
	String bean_name="ePH.LocationStoreItemsBean";
	String selected="";
	String disp_type_code="";
	String selValue="", classValue="";
	ArrayList locForDetails = null;
	LocationStoreItemsBean bean			= (LocationStoreItemsBean)getBeanObject( bean_id, bean_name, request);
	bean.setLanguageId(locale);

	if(search.equals("new")){
		bean.clear();
		locForDetails = (ArrayList)bean.getLocationForList(disp_loc_code,item_type,item_search_code,item_search);
		
		}
	else
		locForDetails = bean.getlocForDetails();
	int maxRecord = (locForDetails.size() / 5);
	
	if(maxRecord <= to)
		to = maxRecord-1;
	int index=(from*5);
	int count=from;
	
%>
	<body  onMouseDown="CodeArrest()" onKeyDown="lockKey()">
		<form name='locationfordetailform' id='locationfordetailform'>
			<table  width='100%' border=0 >
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
					<th width='70%'> <fmt:message key="Common.item.label" bundle="${common_labels}"/></th>
					<th width='20%'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/><input type='checkbox' name='selectall' id='selectall' value="" onclick='selectAll(this, "<%=from%>", "<%=to%>");' ></th>
				</tr>
<%
				while(count <= to){
					disp_type_code = (String)locForDetails.get(index++);
					if( (count+1)%2 == 0)  
						classValue="QRYODD";
					else
						classValue="QRYEVEN";
%>
					<tr>
						<input type='hidden' name='disp_type_code<%=count%>' id='disp_type_code<%=count%>' value='<%=disp_type_code%>'>
						<td class='<%=classValue%>' width='70%'>&nbsp;<%=locForDetails.get(index++)%></td>
<%
						if(((String)locForDetails.get(++index)).equals("E")){
							selected="checked";
							selValue = "Y";
						}
						else{
							selected="";
							selValue = "N";
							selectall = false;
						}
%>                     	<td class='<%=classValue%>' width='20%'><input type='checkbox' name='check<%=count%>' id='check<%=count%>'  value='<%=selValue%>'  onclick="dispTypeCheck(this, '<%=disp_type_code%>');" <%=selected%>></td>
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
			<input type='hidden' name='store_code' id='store_code' value='<%=disp_loc_code%>'>
			</form>
	</body>
	<script>
<%
		if(selectall){
%>
			document.locationfordetailform.selectall.checked=true;
			document.locationfordetailform.selectall.value="Y";
<%
		}else{
%>
			document.locationfordetailform.selectall.checked=false;
			document.locationfordetailform.selectall.value="N";
<%
		}
%>
	</script>
<% putObjectInBean(bean_id,bean,request);%>
</html>

