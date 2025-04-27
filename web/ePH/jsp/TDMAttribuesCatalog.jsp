<!DOCTYPE html>
 <!--This file is saved on 07/11/2005-->
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8  " import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- Mandatory declarations end --%>
<HTML>
<HEAD>	
	<!-- <LINK rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></LINK> -->
	<%
	 request.setCharacterEncoding("UTF-8");	
	//Added  for COMMON-ICN-0182 on 17-10-2023
	request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
	response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
	response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
	//ends
	String locale			= (String)session.getAttribute("LOCALE");
	
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<!-- import the calendar script -->
	<SCRIPT language="JavaScript" src="../../eCommon/js/FieldFormatMethods.js"></SCRIPT>
	<SCRIPT language="JavaScript" src="../../eCommon/js/ValidateControl.js"></SCRIPT>
	<SCRIPT language="Javascript" src="../../eCommon/js/CommonLookup.js"></SCRIPT>
	<SCRIPT language="javascript" src="../../eCommon/js/common.js"></SCRIPT>
<!-- 	<SCRIPT language="javascript" src="../../eCommon/js/messages.js"></SCRIPT> -->
	<SCRIPT language="Javascript" src="../../ePH/js/TDMAttributes.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>
<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()" topmargin="0">
<FORM name="formTDMAtrributesCatalog" id="formTDMAtrributesCatalog">
<%
		String	bean_id			=	"TDMAttributes" ;
		String	bean_name	=	"ePH.TDMAttributesBean";
		String code				="";
		String desc					="";
		String flag					="";
		String classValue		="";
		String from					="";
		String to						="";
		String select_status	=	"";
		String sample			="";
		String flagyn			="";
		String sqlData			="";
		String called_from					=		request.getParameter("called_from")==null?"":request.getParameter("called_from");
		ArrayList orderCatalogList				  =	new ArrayList();
		ArrayList selectedOrderCatalogList =	new ArrayList();
		int start		=	0;
		int end			=	0;
		int maxLen	=	0; 
		int i				=	1;
		sample	=	request.getParameter("sample");
		from			=	request.getParameter("from");
		to				=	request.getParameter("to");
		 flagyn=CommonBean.checkForNull(request.getParameter("flagyn"));
		sqlData=request.getParameter("sqlData");
		TDMAttributesBean bean = (TDMAttributesBean)getBeanObject( bean_id,bean_name,request);
		bean.setLanguageId(locale);

		if (!flagyn.equals("yes"))
		{
			orderCatalogList				 =	 bean.getLabOrders();
				}
		else
		{
			orderCatalogList				 =	 bean.searchLabOrders(sqlData);

				}
		selectedOrderCatalogList=	 bean.getSelectedOrderList(sample,called_from);
			if(selectedOrderCatalogList==null) 
			{
				selectedOrderCatalogList	=	new ArrayList();
			}
		maxLen=orderCatalogList.size();
		if(from==null)
		{
			start	 =	 0;
		}
		else
		{
			start	 =	Integer.parseInt(from);
							}

		if(to==null)
		{
			end	=	14;
				}

		else
		{
			end	=	Integer.parseInt(to);
		}

%>

<TABLE border="0" cellpadding="0" cellspacing="0" width="90%" align="center">
		<TR>
		<TD width="80%" class="white">&nbsp;</TD>
		<TD width="20%" class="white">&nbsp;</TD>
		<TD align="right">
<%
		if ( !(start <= 1) )
		out.println("<label onClick='navigation(document.formTDMAtrributesCatalog,\"previous\")'  style='cursor:pointer;color:blue'>Previous</label>&nbsp;&nbsp;");
		
		if ( !( (start+14) > maxLen ) )
		out.println("<td align='right'><label onClick='navigation(document.formTDMAtrributesCatalog,\"next\")'  style='cursor:pointer;color:blue'>Next</label>");
	%>
	</TD></TR></TABLE>
	<TABLE border="1" cellpadding="0" cellspacing="0" width="100%" align="center">
			<TH align="center" style="width:30%"><fmt:message key="Common.code.label" bundle="${common_labels}"/> </TH>
	<TH align="center" style="width:50%"><fmt:message key="Common.description.label" bundle="${common_labels}"/></TH>
			<TH align="center" style="width:40%"><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></TH>
	<%
			HashMap record	=	new HashMap();
			HashMap rec			=	null;
			String code1			=	"";
			if ( start != 1)
				for( int j=1; j<start; i++,j++ ){ }
			i=start;
			while(i<end && i<maxLen)
			{
				if(i%2==0)
					  classValue	=	"QRYODD";
				else
					  classValue	=	"QRYEVEN";

				select_status		=	"";
				record					=	(HashMap)orderCatalogList.get((i));
				code					=	(String)	record.get("code");
				desc					=	(String)	record.get("desc");
				//flag						=	(String)	record.get("flag");
				flag="";
				for(int k=0;k<selectedOrderCatalogList.size();k++)
				{
					rec			 = (HashMap)selectedOrderCatalogList.get(k);
					code1		 = (String)rec.get("code");
						if(code.equals(code1)){
							flag		=	(String)rec.get("flag");
							break;
					}
				}
			
				if(flag.equals("Y"))
				{
					select_status="checked";
			 	}


	%>
		<TR>
		<TD class=<%=classValue%>><%=code%><input type=hidden name="code_<%=i%>" id="code_<%=i%>" value="<%=code%>"></TD>
		<TD class=<%=classValue%>><%=desc%><input type=hidden name="desc_<%=i%>" id="desc_<%=i%>" value="<%=desc%>"></TD>
		<TD align="center" class=<%=classValue%>><input type ="checkbox"  name="select_<%=i%>" id="select_<%=i%>" <%=select_status%> onclick="selectLabOrder(this,<%=i%>,'1','<%=sample%>');"></TD>
		</TR>
	<%
			i++;
		}
	%>

</TABLE>
<BR><BR>
<DIV align='right'>
<TABLE  cellpadding='0' cellspacing='0' >
	<TR>
		<TD >
			<INPUT type='button' name='close' id='close' value='<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>' onClick='storevalues("<%=sample%>");closeW();' class='button'>
		</TD>
	</TR>
</TABLE>
</DIV>

<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
<input type="hidden" name="start" id="start" value="<%=start%>">
<input type="hidden" name="end" id="end" value="<%=end%>">
<input type="hidden" name="sample" id="sample" value="<%=sample%>">
<input type="hidden" name="count_1" id="count_1" value="<%=i%>">
<input type="hidden" name="result_value" id="result_value" value="">


<% putObjectInBean(bean_id,bean,request); %>
</FORM>
</BODY>
</HTML>

