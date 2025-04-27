<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.io.*,java.util.Hashtable, java.util.HashMap,ePH.*,ePH.SetupAuditLogBean, ePH.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>

<HTML>
	<HEAD>
<%
		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
		<!-- <SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/MstCodeCommon.js"></SCRIPT> -->
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/FieldFormatMethods.js"></SCRIPT>
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/CommonLookup.js"></SCRIPT>
		<SCRIPT LANGUAGE="javascript" SRC="../js/PRNRemarksForDrug.js"></SCRIPT>
		
		
		<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>

    </head>
<%/**
 * @Name - Sandhya A 
 * @Date - 18/12/2009
 * @Inc# - IN016185
 * @Desc - added lockKey() in <body> onKeyDown() event.
 */%>
<BODY onKeyDown = "lockKey();" >

<%
	
	
	String bean_id				= request.getParameter( "bean_id" ) == null ? "" :  request.getParameter( "bean_id" );
	String bean_name			= request.getParameter( "bean_name" ) == null ? "" :request.getParameter( "bean_name" ) ;
	String mode					= request.getParameter( "mode" )  == null ? "" : request.getParameter( "mode" ) ;
	String drug_code			= request.getParameter( "drug_code" ) == null ? "" : request.getParameter( "drug_code" ) ;	
	String PRNSearchText		= request.getParameter( "PRNSearchText" ) == null ? "" : request.getParameter( "PRNSearchText" ) ;
	String PRNSearchBy			= request.getParameter( "PRNSearchBy" ) == null ? "" : request.getParameter( "PRNSearchBy" );
	String defaultCheck			= "" ;
	String selectCheck			= "" ;
	String classValue			= "";
	ArrayList remarksList		= null;
	int listRows				= 0;
	int list_size				= 0;

	PRNRemarksForDrugBean bean	=(PRNRemarksForDrugBean)getBeanObject( bean_id, bean_name, request ) ;
    bean.setLanguageId(locale);
	bean.setMode( mode ); 

	if (PRNSearchBy.equals("S"))
	   PRNSearchText = PRNSearchText+"%";
	else if (PRNSearchBy.equals("C"))
		PRNSearchText = "%"+PRNSearchText+"%";
	else
		PRNSearchText = "%"+PRNSearchText;
	//out.println("PRNSearchText==>"+PRNSearchText);
	//out.println("drug_code==>"+drug_code);
	//ArrayList remarksList = bean.loadPRNRemarksResult(PRNSearchText,drug_code,locale);
	//bean.setList(remarksList);
	//listRows = remarksList.size()/4;
	
	int from = Integer.parseInt(request.getParameter("from")==null?"0":request.getParameter("from"));
	int to = Integer.parseInt(request.getParameter("to")==null?"0":request.getParameter("to"));
	String search = request.getParameter("search")==null?"":request.getParameter("search");

	if(search.equals("new")){
		bean.clear();
		remarksList = bean.loadPRNRemarksResult(PRNSearchText,drug_code,locale);
		bean.setList(remarksList);
		listRows = remarksList.size()/4;
		bean.setListRows(listRows);		
	}
	else{
		remarksList = bean.getList();
		listRows = bean.getListRows();		
	}
	list_size = remarksList.size();
	
	if(listRows <= to)
		to = listRows-1;
	int index=(from*4);
	int  count=from;


	
%>
 <FORM name="PRNRemarksForDrugResultForm" id="PRNRemarksForDrugResultForm">

<%	if (remarksList.size() > 0){
%>
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
						if(!((from+20) >= listRows )){
%>
							<a href='javascript:submitPrevNext(<%=(from+20)%>,<%=(from+39)%>)' text-decoration='none'><fmt:message key="Common.next.label" bundle="${common_labels}"/></a>
							<input type=hidden name='nextPage' id='nextPage' value='next'>
<%
						}
%>
					</td>
				</tr>
			</table>

	<table cellpadding="0" cellspacing="0" width="100%" align="center"	border="1">
	
		<th><fmt:message key="Common.code.label" bundle="${common_labels}"/></th>		
		<th><fmt:message key="ePH.PRNRemarksforDrug.label" bundle="${ph_labels}"/></th>
		<th><fmt:message key="ePH.DefaultRemark.label" bundle="${ph_labels}"/></th>
		<th><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></th>
<%
		while(count <= to){
			if( (count+1)%2 == 0)  
				classValue="QRYODD";
			else
				classValue="QRYEVEN";

%>		
		<tr>
			<td class='<%=classValue%>'><%=remarksList.get(index).toString()%></td>
			<input type ='hidden' name='h_reason_code_<%=count%>' id='h_reason_code_<%=count%>' value ='<%=remarksList.get(index).toString()%>'/>
			<td class='<%=classValue%>'><%=remarksList.get(index+1).toString()%></td>
			<%if (remarksList.get(index+2).toString().equals("Y")){
				defaultCheck = "checked";
				}
              else{
				  defaultCheck = "";
			  }
			  if (remarksList.get(index+3).toString().equals("Y")){
				selectCheck = "checked";
				}
              else{
				  selectCheck = "";
			  } 
			%>
			<td class='<%=classValue%>' align ='center'><input type='checkbox' name= 'default_prn_select_<%=count%>' value='<%=remarksList.get(index+2).toString()%>' onClick ='callDefaultSelect(this,"<%=count%>","<%=index+2%>","<%=remarksList.get(index).toString()%>");' <%=defaultCheck%> ></td>
			<td  class='<%=classValue%>' align ='center'><input type='checkbox' name= 'prn_select_<%=count%>' value='<%=remarksList.get(index+3).toString()%>'onClick ='callSelect(this,"<%=index+3%>");' <%=selectCheck%> ></td></tr>
<%		
			count++;
			index+=4;
%>

<%			}//while
%>	
	</table>
	
<%	} //if 
	else{	
	
%>
	<script language="javascript">		
		alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
		parent.f_prn_remarks_drug_result.location.href= '../../eCommon/html/blank.html';
		parent.f_prn_remarks_drug_criteria.location.reload();
	</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



		

<%	} //else
  
%>
  <input type ='hidden' name ='h_list_rows' value ='<%=listRows%>'/>
  <input type ='hidden' name ='h_drug_code' value ='<%=drug_code%>'/>
  <input type ='hidden' name ='h_prn_search_text' value ='<%=PRNSearchText%>'/>
  <input type ='hidden' name ='bean_id' value ='<%=bean_id%>'/>
  <input type ='hidden' name ='bean_name' value ='<%=bean_name%>'/>  
  <input type ='hidden' name ='list_size' value ="<%=list_size%>"/>  
  <input type ='hidden' name ='mode' value ="<%=mode%>"/>  
</form>
</form>
</body>
</html>
<%
	
	putObjectInBean(bean_id, bean, request);
%>





















