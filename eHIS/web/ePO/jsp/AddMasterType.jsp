<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page import="java.util.*, ePO.*, ePO.Common.* , eCommon.Common.*,java.text.*, java.util.*,java.lang.*" contentType="text/html;charset=UTF-8"%>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%-- Mandatory declarations end --%>
<html>
<head> 
<%
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle =
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../js/PoCommon.js"></script>	
	<script language="javascript" src="../../ePO/js/PoTransaction.js"></script>
	<script language="JavaScript" src="../js/MasterType.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
</head>
<body onMouseDown='CodeArrest();' onLoad="changetype();">
<%
		String	mode			=	request.getParameter( "mode" ) ;
		String	bean_id			=	"multipleInsertMasterTypeBean" ;
		String	bean_name		=	"ePO.MultipleInsertMasterTypeBean";
		String  master_code		= "";
		String  long_desc		= "";
		String  short_desc		= "";
		String  eff_status		= "";
		String  enableChecked   = "";
		String  enableText		= "";
		String  readonly		= "";


		MultipleInsertMasterTypeBean bean = (MultipleInsertMasterTypeBean) getBeanObject( bean_id,bean_name,request ) ;
		bean.setLanguageId(locale);
		
		if(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY")) ){		
				master_code		=	request.getParameter( "master_code" ) ;
				bean.setMaster_code(0,master_code);
				bean.loadData();
				readonly = "readonly";
				bean.setMode( mode ) ;
	}
%>
<form name="formMasterType" id="formMasterType" action="../../ePO/jsp/MasterTypeFrame.jsp" method="post"  target="master_type_list" >
<%if(mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT")) )
{%>
	<table border="0" cellpadding="0" cellspacing="0" width='100%'  height='100%' align=center>
	<%}else{%>
	<table border="0" cellpadding="0" cellspacing="0" width='100%'  height='50%' align=center>
	<%}%>
	<tr>
	<td width='100%' height='100%'  class="WHITE">	
		<table cellpadding="0" cellspacing="0"  border=1 align=center  >
		<tr>
		<th ><fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
		<th ><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></th>
		<th ><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></th>
		<th ><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>
		</tr>
		<%
		
		ArrayList alDetailData		=		bean.getDtlRecords();

		int size = 10;
		
		if(alDetailData.size()== 0 ){
			size = 10;
		}else {			
			size = alDetailData.size();			
		}
			String classValue = null;
			
			for ( int cnt=0; cnt<size; cnt++ ) {
				HashMap ht	=	new HashMap();
				if(cnt%2 ==0)
					classValue="QRYEVEN";
				else
					classValue="QRYODD";
				if(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY")) )
				{
					if (cnt<alDetailData.size())
					ht						=		(HashMap)alDetailData.get(cnt);
					 master_code = bean.checkForNull((String)ht.get("master_code"));
					 long_desc = bean.checkForNull((String)ht.get("long_desc"));
					 short_desc = bean.checkForNull((String)ht.get("short_desc"));
					 eff_status = bean.checkForNull((String)ht.get("eff_status"));
					 
					 
				System.out.println("eff_status = "+eff_status);
				if(eff_status.equals("E")){
				    enableChecked = "checked";
					enableText = "";
				}else	{
					enableChecked = "";	
					enableText = "disabled";
				}	
					
				}
				
		%>
			 <TR>
				<td  class="<%=classValue %>" >
					<input type="text" name='master_code_<%=cnt%>' id='master_code_<%=cnt%>'  value= "<%=master_code%>" <%=readonly%> size="10" maxlength="10" class="UPPER" onKeyPress="return CheckForSpecChars(event)" onBlur="resetColorCode(this);convertToUpperCase(this);checkSpecialChars(this);">
				</td>
				<td  class="<%=classValue %>" >
					<input type="text" name="long_desc_<%=cnt%>" id="long_desc_<%=cnt%>"  value = "<%=long_desc%>" <%=enableText%> size="42" maxlength="40" onBlur="resetColorCode(this);makeValidString(this);">
				</td>
				<td  class="<%=classValue %>" >
					<input type="text" name="short_desc_<%=cnt%>" id="short_desc_<%=cnt%>" value = "<%=short_desc%>" <%=enableText%> size="20" maxlength="15" onBlur="resetColorCode(this);makeValidString(this);">
				</td>
				<td  class="<%=classValue %>">
				<% if(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY")) )
				{ %>
					<input type="checkBox" name="eff_status_<%=cnt%>" id="eff_status_<%=cnt%>" value="E" <%=enableChecked%> onClick="changeText(this,'<%=cnt%>');">
				<%}else{ %>
					<input type="checkBox" name="eff_status_<%=cnt%>" id="eff_status_<%=cnt%>" value="E" checked >
				<% } %>				
				</td>

				<td  class="<%=classValue %>" Style = " COLOR : #F40000  " nowrap align='right' title ="Additional Details"   >
				
					<input type='button' name='additional_dtls_<%=cnt%>' id='additional_dtls_<%=cnt%>' class='button' onclick="CommitCodeDetails('<%=bean_id%>','<%=bean_name%>','<%=mode%>',master_code_<%=cnt%>,long_desc_<%=cnt%>,short_desc_<%=cnt %>,eff_status_<%=cnt%>,<%=cnt%>);" value='>>' disabled>
				
				</td>
			</TR>
	<%
		} 
	%>	
	
		</table>
	</td>
	</tr>
</table>
<input type="hidden" name="mode" id="mode" value="<%=mode%>">
<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
<input type="hidden" name="totalRecords" id="totalRecords" value="<%=size%>">
<input type="hidden" name="master_type" id="master_type" value="">
<input type="hidden" name="function_id" id="function_id" value="<%=bean.getFunctionId()%>">
<input type="hidden" name="dept_no" id="dept_no" value="">
<input type="hidden" name="acc_no" id="acc_no" value="">
<input type="hidden" name="acc_no_desc" id="acc_no_desc" value="">
<input type="hidden" name="all_budget" id="all_budget" value="">
<input type="hidden" name="addnl_budget" id="addnl_budget" value="">
<input type="hidden" name="total_budget" id="total_budget" value="">
<input type="hidden" name="from_date" id="from_date" value="">
<input type="hidden" name="to_date" id="to_date" value="">
</form>
</center>
<%
putObjectInBean(bean_id,bean,request);
%>
</body>
</html>

