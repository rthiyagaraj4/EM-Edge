<!DOCTYPE html>
 <%-- saved 0n 24/10/2005 --%>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.TPNStandardRegimenBean, eOR.*, ePH.Common.* ,eOR.Common.* , eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<HTML>
<HEAD>
	<!-- <LINK REL="stylesheet" TYPE="text/css" HREF="../../eCommon/html/IeStyle.css"></LINK> -->
	<%
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

	<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
<!-- 	<script language="JavaScript" src="../../eCommon/js/messages.js"></script>
 -->	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<!-- 	<script language="Javascript" src="../../ePH/js/PhCommon.js"></script>
 -->	<script language="Javascript" src="../../eCommon/js/CommonResult.js"></script>
	<SCRIPT LANGUAGE="javascript" SRC="../js/TPNStdRegimen.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</HEAD>
<BODY >
<%
	//String patient_id	= request.getParameter("patient_id");
	//out.println(patient_id);
//	String encounter_id	= request.getParameter("encounter_id");
	String bean_id	= "TPNStandardRegimenBean";
	String bean_name	 = "ePH.TPNStandardRegimenBean";
	TPNStandardRegimenBean bean = (TPNStandardRegimenBean)getBeanObject( bean_id,bean_name,request) ;
	bean.setLanguageId(locale);
	ArrayList generics=bean.getTPNGenerics("EL");
	int count=0;
//	out.println(generics);

%>
<div style="position:absolute;top:0;left:0">
<FORM name="StdRegLookupAddlCriteria" id="StdRegLookupAddlCriteria" >
		<TABLE CELLPADDING="0" CELLSPACING="0" ALIGN="center" BORDER="0" width="100%" >
		<tr><th colspan=6><fmt:message key="Common.AdditionalCriteria.label" bundle="${common_labels}"/></th></tr>
		<tr><td><table border=0 cellpadding=0 cellspacing=0>
			<%
			
			for (int i=0;i<generics.size();i+=3)
			{
				if (count%2==0)
				{
					out.println("<TR>");
				}
			if (i%4!=0)
			{
				%>
						<TD class="label" width="25%" ><%=generics.get(i+1)%></TD>
					<%

			}
			else
			{
				%>
						<TD class="label" width="20%"><%=generics.get(i+1)%></TD>
					<%

			}
			
				if ( (count%2==0)&&(i==(generics.size()-1)))
				{
	
					out.println("<TD class=\"label\"  colspan=4>" );
	
				}
				else
				{
						out.println("<TD class=\"label\" >");
				}
			%>&nbsp;<input type=text name='<%=generics.get(i)%>' id='<%=generics.get(i)%>'  
			id='<%=generics.get(i)%>' maxlength=5 class="number" size=5 onBlur="CheckPositiveNumber(this)">
			</td><td width="10%"  class="label">&nbsp;<B><%=generics.get(i+2)%></B></TD>
			<%
				if (count%2!=0)
				{
					out.println("</TR>");
				}

				count++;

			}
			%>
			</table></td></table>
		<!--	<tr>
			<td colspan=4 align="right"><input type=button value="Close"  class="button" onClick="cancelAddSearch(document.StdRegLookupAddlCriteria)"></td>
			</tr>-->
		</TABLE>
		
	</FORM>
	</div>
	</body>
	</html>
	<% putObjectInBean(bean_id,bean,request); %>

