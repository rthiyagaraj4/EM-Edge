<!DOCTYPE html>
 <!--This file is saved on 07/11/2005-->
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<html>
	<head>
		<title></title>
		<%
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	</head>


<!-- <body topmargin="0"> -->
	<body onMouseDown="" onKeyDown="lockKey()" topmargin="0">
		<form id="FormDrugInteractions" name="FormDrugInteractions" id="FormDrugInteractions">
			<table name="TblInteractions" id="TblInteractions" width="100%" >

<%
				String patientid=request.getParameter("patientid");
				String encounterid=request.getParameter("encounterid");
				String bean_id ;
				//out.println(encounterid.equals("null"));
				if (!(encounterid==null)&&(!(encounterid.equals("") ) )){
					bean_id = "@ExternalProductLinkBean"+patientid+encounterid ;
				}
				else{
					bean_id = "ExternalProductLinkBean";
				}
			//	out.println(bean_id);
				String bean_name = "ePH.ExternalProductLinkBean";
				ExternalProductLinkBean bean = (ExternalProductLinkBean)getBeanObject( bean_id, bean_name, request ) ;

				/*String patientid=request.getParameter("patientid");
				String orderid=request.getParameter("orderid");

				ArrayList x=bean.storeDrugIds(patientid,orderid);
				out.println(x.size());
				for (int i=0;i<x.size();i++)
				{
					out.println((String)x.get(i));
				}
				if (5==5)
				{
					return;
				}*/

				HashMap result=bean.getInteractions() ;
				Set keyset=result.keySet();
				Iterator itr=keyset.iterator();
%>
				<TR><TH align="left" ><fmt:message key="ePH.Drug-DrugInteractions.label" bundle="${ph_labels}"/></TH></TR>
<%
				while (itr.hasNext())
				{
					Object header=itr.next();
					String str=header.toString();
%>
					<TR><TH align="left" style="font-size:8pt" id="header1"><%=str%></TH></TR>
<%
					ArrayList details=(ArrayList)result.get(header);
					for (int i=0;i<details.size();i++)
					{
%>
						<TR><TD style="font-size:8pt" ><%=details.get(i).toString()%></TD></TR>
<%
					}
				}
%>
			</table>
		</form>
	</body>
</html>
<%
		putObjectInBean(bean_id,bean,request);
%>

