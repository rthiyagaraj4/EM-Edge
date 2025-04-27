<%@ page import ="eST.*, eST.Common.* , eCommon.Common.*,java.util.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<jsp:useBean id="AssemblyDtlList" scope="session" class="java.util.ArrayList"/>
<%-- Mandatory declarations end --%>
<html>
<head>
	
 <%
		request.setCharacterEncoding("UTF-8");
		String locale			=		(String)session.getAttribute("LOCALE");
		String sStyle			=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language='javascript' src='../../eST/js/AssemblyDetail.js'></script>
	<script language='javascript' src='../../eST/js/StCommon.js'></script>
	<script language="JavaScript" src="../../eMM/js/MmCommon.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
	<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	String bean_id				=		"AssemblyDetailBean";
	String bean_name			=		"eST.AssemblyDetailBean";
	String classvalue			=		"";

	AssemblyDetailBean bean		=		(AssemblyDetailBean) getBeanObject( bean_id,bean_name,request);  
	bean.setLanguageId(locale);
	bean.setSession(session);
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));

	String mode					=		request.getParameter( "mode" )==null?"":  request.getParameter( "mode" );
	ArrayList recordSet			=		new ArrayList();
	recordSet					=		AssemblyDtlList;

	if ( mode == null || mode.equals("") ) 
		return ;
	if ( !(mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") ) || mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT") )) )
		return ;
	if ( mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") ) ){
		recordSet				=		bean.getDataModifyList();
        
	}
	HashMap hmRecord=new HashMap();

	%>
	<body >
	<form name='AssemblyDetailResultForm' id='AssemblyDetailResultForm' method='post' >
		<table border='1' cellpadding=0 cellspacing=0 width='100%' id='tb1' align=center>
			<th><fmt:message key="Common.delete.label" bundle="${common_labels}"/></th>
			<th><fmt:message key="Common.ItemCode.label" bundle="${common_labels}"/></th>
			<th style="WORD-BREAK:BREAK-ALL;"><fmt:message key="Common.description.label" bundle="${common_labels}"/></th>
			<th><fmt:message key="Common.Quantity.label" bundle="${common_labels}"/></th>
			<th><fmt:message key="eST.MFGUOM.label" bundle="${st_labels}"/></th>
			<th><fmt:message key="Common.Component.label" bundle="${common_labels}"/></th>
			<th><fmt:message key="Common.Mandatory.label" bundle="${common_labels}"/><fmt:message key="Common.Component.label" bundle="${common_labels}"/></th>
			<th><fmt:message key="Common.SequenceNo.label" bundle="${common_labels}"/></th>
	<%
	int i=0;
	for	(i	=0;	i<recordSet.size();i++){
		hmRecord	=(HashMap)	recordSet.get(i);
		
//		String PRINT_ON_LABEL_YN=(String)hmRecord.get("PRINT_ON_LABEL_YN");
		
		String INSTRN_CODE=(String)hmRecord.get("INSTRN_CODE");
		

			classvalue	=	((i%2)==0)?"QRYODD":"QRYEVEN";
			String allow_deci_yn            =   bean.checkForNull(bean.getAllowDecimalsYN((String)hmRecord.get("CHILD_ITEM_CODE")),"N");
	    String no_deci            =   bean.checkForNull(""+bean.getNoOfDecimals(),"0");
		if(allow_deci_yn.equals("N"))
           no_deci ="0";

%>
			<tr>
			<!--
					
						* @Name - Priya
						* @Date - 19/02/2010
						* @Inc# - IN019466
						* @Desc - To right align Quantity, Sequence No .
										
					-->
			<td  class='fields'><input type="checkbox" name="del_<%=i%>" id="del_<%=i%>" value="" ></td>
			<td class="<%=classvalue%>"    nowrap><a href="javascript:modifyData(<%=i%>);"><font size=1><%=(String)hmRecord.get("CHILD_ITEM_CODE")%></a></font></td>
			<td class="<%=classvalue%>"   onclick="disableClick(event);" style="WORD-BREAK:BREAK-ALL;"><font size=1><%=(String)hmRecord.get("SHORT_DESC")%></font></td>
			<td class="<%=classvalue%>"   onclick="disableClick(event);" nowrap style="TEXT-ALIGN:right"><font size=1><%=bean.setNumber((String)hmRecord.get("COMPONENT_QTY"),Integer.parseInt(no_deci))%></font>&nbsp;</td>
			<td class="<%=classvalue%>"   onclick="disableClick(event);" nowrap><font size=1><%=bean.checkForNull((String)hmRecord.get("MFG_DESC"),"&nbsp;")%></font></td>
			<td  class="<%=classvalue%>"   onclick="disableClick(event);" nowrap><font size=1><%if(((String)hmRecord.get("COMPONENT")).equals("Y")){%><img align='center' src='../../eCommon/images/enabled.gif'></img><%}else{%><img align='center' src='../../eCommon/images/disabled.gif'></img><%}%></td>
			
			<td  class="<%=classvalue%>"   onclick="disableClick(event);" nowrap><%if(((String)hmRecord.get("MANDATORY")).equals("Y")){%><img align='center' src='../../eCommon/images/enabled.gif'></img><%}else{%><img align='center' src='../../eCommon/images/disabled.gif'></img><%}%></td>

			<td class="<%=classvalue%>"   onclick="disableClick(event);" nowrap style="TEXT-ALIGN:right"><font size=1><%=(String)hmRecord.get("SEQ_NO")%></font>&nbsp;</td>
           	<input type=hidden name="INSTRN_CODE" id="INSTRN_CODE"  value="<%=INSTRN_CODE%>">

			</tr>
	<%
	}
	%>
	</table>
	<input type=hidden name="totalRecords" id="totalRecords"  value="<%=recordSet.size()%>">
	</form>
	</center>
<%
		putObjectInBean(bean_id,bean,request);
%>
	</body>
</html>

