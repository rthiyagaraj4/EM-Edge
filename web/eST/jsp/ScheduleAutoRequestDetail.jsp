<%@ page contentType="text/html;charset=UTF-8"  import="java.util.*,eST.ScheduleAutoRequestBean" %>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<html>
<head>
<% 
    request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");

	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
		("PREFERRED_STYLE"):"IeStyle.css";

%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'type='text/css'></link>
 
<script language="Javascript" src="../../eCommon/js/common.js"></script>
<SCRIPT LANGUAGE="Javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
<SCRIPT LANGUAGE="Javascript" SRC="../../eST/js/ScheduleAutoRequest.js"></SCRIPT>
<SCRIPT LANGUAGE="Javascript" SRC="../../eST/js/StCommon.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<%
	String bean_id					= "scheduleAutoRequestBean" ;
	String bean_name				= "eST.ScheduleAutoRequestBean";
	ScheduleAutoRequestBean bean	= (ScheduleAutoRequestBean)getBeanObject(bean_id,bean_name ,request) ;
	bean.setLanguageId(locale);
	String link						=	bean.checkForNull(request.getParameter("link"),"");
	String mode						=	bean.checkForNull(request.getParameter("mode"),"1");
	String search					=	bean.checkForNull(request.getParameter("search"),"");
	String requisition_by_store		=	request.getParameter("requisition_by_store");
	String requisition_on_store		=	request.getParameter("requisition_on_store");
	String item_class_code			=	request.getParameter("item_class_code");
	String consignment				=	request.getParameter("consignment");
	String item_analysis_1			=	request.getParameter("item_analysis_1");
	String item_analysis_2			=	request.getParameter("item_analysis_2");
	String item_analysis_3			=	request.getParameter("item_analysis_3");
	String item_desc				=	request.getParameter("item_desc");
	String searchby_type			=	request.getParameter("searchby_type");
	String alpha_code				=	request.getParameter("alpha_code");
	String item_code				=	request.getParameter("item_code");
	int from						=	Integer.parseInt(request.getParameter("from")==null?"0":request.getParameter("from"));
	int to							= Integer.parseInt(request.getParameter("to")==null?"12":request.getParameter("to"));
	String assochk					=	"";
	String classValue				=	"";
	ArrayList	associatedValues			=	null;
	boolean forAssociate			=	false;
	boolean isAssociate				=	false;
	if(link!=null && link.equals("associate"))	
	isAssociate						=	true;

	if(mode==null || mode.equals(""))
	bean.setMode(CommonRepository.getCommonKeyValue("MODE_INSERT"));

	if(search.equals("new")){
	associatedValues = (ArrayList)bean.loadItemDetails(requisition_by_store,requisition_on_store,item_class_code,consignment,item_analysis_1,item_analysis_2,item_analysis_3,item_desc,searchby_type,alpha_code,item_code);
//	System.out.println("associatedValues====ScheduleAutoRequestDetail.jsp==============>"+associatedValues);
	if(associatedValues.size()==0){%>
		<script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));</script> 
		
	<%return;}
	}else{
	associatedValues					=	bean.getApplicableSchduleItems();
	}

	if(link!=null && link.equals("associate"))	
	forAssociate				=	true;
	if(forAssociate){
	associatedValues					=	bean.getStoredAssociated();
	isAssociate						=	true;
	if(associatedValues.size()==0){%>
<script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));</script> 

<%	return;}
	}
		int maxRecord				= (associatedValues.size() / 4);

	if(maxRecord <= to)
		to = maxRecord-1;
	int index=from*4;
	int count=from;	
	
	boolean selectall=true;
	ArrayList sel=bean.getAssociated_sel();
if(associatedValues.size()==0){
return;
}
	
%>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" topmargin="0">

<form name="schduleAutoRequestDetailform" id="schduleAutoRequestDetailform">


<table  width='100%' border=0 >
				<tr>
					<td class='NONURGENT' align="right">
						<input type=hidden name='from' id='from' value='<%=from%>'>
						<input type=hidden name='to' id='to' value='<%=to%>'>
<%
						if(from > 0) {
%>
							<a href='javascript:submitPrevNext(<%=(from-13)%>,<%=(from-1)%>)' text-decoration='none'><fmt:message key="Common.previous.label" bundle="${common_labels}"/></a>
							<input type=hidden name='prevPage' id='prevPage' value='prev'>
<%
						}
						if(!((from+13) >= maxRecord )){
%>
							<a href='javascript:submitPrevNext(<%=(from+13)%>,<%=(from+25)%>)' text-decoration='none'><fmt:message key="Common.next.label" bundle="${common_labels}"/></a>
							<input type=hidden name='nextPage' id='nextPage' value='next'>
<%
						}
%>
					</td>
				</tr>
			</table>
<table border="1" width="100%" cellspacing="0" cellpadding="0" align="center">
	<tr>
	
	<th width='20%'> <fmt:message key="Common.ItemCode.label" bundle="${common_labels}"/>	</th>
	<th width='70%'>  <fmt:message key="Common.ItemDescription.label" bundle="${common_labels}"/> 	</th>
	<th width='10%'> <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>
	<%if(!forAssociate){%>
	<input type='checkbox' name='selectall' id='selectall' value="" onclick='selectAll(this, "<%=from%>", "<%=to%>");' >
	<%}%>
		</th>
	</tr>

<%
String item_code_temp	=	"";
String item_desc_temp	=	"";
String select_temp		=	"";
while(count <= to){
					item_code_temp = (String)associatedValues.get(index+0);
					item_desc_temp = (String)associatedValues.get(index+1);
					select_temp	   = (String)associatedValues.get(index+2);
					for(int k=0;k<sel.size();k=k+4){
					if(item_code_temp.equals((String)sel.get(k+0)))
						if(((String)sel.get(k+2)).equals("Y"))
						{
							assochk="checked";
						}else{
						assochk="";
							selectall = false;
						}
					}
					if( (count+1)%2 == 0)  
						classValue="QRYODD";
					else
						classValue="QRYEVEN";
					%>
	<tr>
	<input type='hidden' name='item_code_temp<%=count%>' id='item_code_temp<%=count%>' value='<%=item_code_temp%>'>
	<td class='<%=classValue%>' width='20%'>&nbsp;<%=item_code_temp%></td>
	<td class='<%=classValue%>' width='70%'>&nbsp;<%=item_desc_temp%></td>
	<td class='<%=classValue%>' width='10%'><input type='checkbox' name='select_<%=count%>' id='select_<%=count%>'  value=''  onclick="dispTypeCheck(this, '<%=item_code_temp%>');" <%=assochk%> ></td>
	</tr>
					<%
					index+=4;
					count++;
}
%>
<script>
<%
		if(selectall){
%>		if(document.schduleAutoRequestDetailform.selectall!=undefined){
			document.schduleAutoRequestDetailform.selectall.checked=true;
			document.schduleAutoRequestDetailform.selectall.value="Y";
			}

<%
		}else{
%>
		if(document.schduleAutoRequestDetailform.selectall!=undefined){
			document.schduleAutoRequestDetailform.selectall.checked=false;
			document.schduleAutoRequestDetailform.selectall.value="N";
			}
<%
		}
%>
	</script>
<%

putObjectInBean(bean_id,bean,request);
%>
<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
<input type="hidden" name="link" id="link" value="<%=link%>">
<input type="hidden" name="isAssociate" id="isAssociate" value="<%=isAssociate%>">
<input type="hidden" name="mode" id="mode" value="<%=mode%>">

</table>
</form>
</body>
</html>

