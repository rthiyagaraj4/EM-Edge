<!DOCTYPE html>
<%
/*
Sr No     Version        Incident			SCF/CRF					Developer Name
-----------------------------------------------------------------------------------
1          V220525							GHL-CRF-0632     		Mohanapriya
-----------------------------------------------------------------------------------
*/
%>
<%@page import="java.util.*,eBL.* , eOR.* ,eOR.Common.*,eCommon.Common.*"   contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<html>
<head>
	<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../js/indirectServCancel.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

 	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css" />
</HEAD> 
<BODY>
	<%
	String bean_id   = "@IndirectServBean" ;
	String bean_name = "eBL.IndirectServBean";
	 IndirectServBean bean			= (IndirectServBean)getBeanObject( bean_id, bean_name, request);
	bean.setLanguageId(localeName);
	Properties properties	= (Properties) session.getValue( "jdbc" );
	ArrayList Category_Data = new ArrayList();
	Category_Data = bean.getAllOrderCategory(properties);
	String[] record = null;
	for(int i=0; i<Category_Data.size(); i++)
	{
		record = (String [])Category_Data.get(i);
	}
	%>
	<FORM name='ind_serv_cancel' id='ind_serv_cancel' target='messageFrame'>
		<TABLE>
			<TR>
				<td class=label  ><fmt:message key="Common.OrderCategory.label" bundle="${common_labels}"/></td>
				<td class="fields">
					<SELECT name="order_category" id="order_category" onChange="populateValues();">
						<option value=''>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---
						<%
						try
						{

							for(int i=0; i<Category_Data.size(); i++)
							{
								record = (String [])Category_Data.get(i);
								%>
								<option value=<%=record[0]%>><%=record[1]%>
								<%
							}
						}
						catch(Exception e)
						{
							//out.println(e);
							e.printStackTrace();
						}
						%>
					</SELECT><img src="../../eCommon/images/mandatory.gif" ></img>
				</td>
			</TR>
		</TABLE>
		<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
		<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
		<input type='hidden' name='localeName' id='localeName' value='<%=localeName%>'>
	</FORM>
</BODY>
</HTML>

