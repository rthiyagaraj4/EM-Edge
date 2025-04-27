<!DOCTYPE html>
 
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>


<html>
	<head>
		<title>
		</title>
<%
//added By Himanshu Start.
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
//end.
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<SCRIPT LANGUAGE="javascript" SRC="../../ePH/js/FDBDrugInfo.js"></SCRIPT><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	</head>
	<body topmargin="0">
<%
		String bean_id = "ExternalProductLinkBean" ;
		String bean_name = "ePH.ExternalProductLinkBean";
		ExternalProductLinkBean bean = (ExternalProductLinkBean)getBeanObject( bean_id, bean_name, request ) ;
		//Get data for food interactions
		String prodid=request.getParameter("extprodid");
		try{
%>

			<table name="TblInteractions" id="TblInteractions"  width="100%"  border="0" height="100%" > 
				<TBODY     vALIGN ="TOP" >
					<TR>
						<Td   id="THEquiv" name="THEquiv"  style="BACKGROUND-COLOR:#FFFF99"> 

							<label id="LbDrugClaas" onClick=<%="showTab('TblEquiv','LbDrugClaas','"+prodid+"')"%>><font class="hyperlink">&nbsp;&nbsp;Drug Classification </font></label><br><br>

							<label id="LbDrugCommonOrd" onClick=<%="showTab('TblInteractions','LbDrugCommonOrd','"+prodid+"')"%>><font class="hyperlink">&nbsp;&nbsp;Common Orders </font></label><br><br>

							<label id="LbDrugInt" onClick=<%="showTab('TblIndications','LbDrugInt','"+prodid+"')"%>><font class="hyperlink">&nbsp;&nbsp;Drug Interaction</font></label><br><br>

							<label id="LbDrugCont" onClick=<%="showTab('TblContra','LbDrugCont','"+prodid+"')"%>><font class="hyperlink">&nbsp;&nbsp;Contraindications </font></label><br><br>

							<label id="LbDrugSide" onClick=<%="showTab('TblInfo','LbDrugSide','"+prodid+"')"%>><font class="hyperlink">&nbsp;&nbsp;Side Effects</font> </label><br><br>

							<label id="LbDrugPre" onClick=<%="showTab('TblPrecautions','LbDrugPre','"+prodid+"')"%>><font class="hyperlink">&nbsp;&nbsp;Precautions</font></label><br><br>

							<label id="LbDrugOverDose" onClick=<%="showTab('TblOverDose','LbDrugOverDose','"+prodid+"')"%>><font class="hyperlink">&nbsp;&nbsp;Over Dose</font></label><br><br>

						   <label id="LbDrugFood" onClick=<%="showTab('TblFood','LbDrugFood','"+prodid+"')"%>><font class="hyperlink">&nbsp;&nbsp;Drug-Food Interactions</font></label><br><br>	

							<label id="LbDrugPatEdu" onClick="<%="showTab('TblCounsel','LbDrugPatEdu','"+prodid+"')"%>"><font class="hyperlink">&nbsp;&nbsp;Patient-Education</font></label><br><br>
						</Td>
					</TR>
				</TBODY>
			</table>

 <%
		}
		catch (Exception e)
		{
			out.println("The External Database cannot be accessed!!!");
		}
%>
	</body>
</html>
<%
	putObjectInBean(bean_id,bean,request);
%>

