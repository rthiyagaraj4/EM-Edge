<!DOCTYPE html>
<!--Gomathi added against MMS-KH-CRF-0029.1 Starts Here-->
<%@page  contentType="text/html;charset=UTF-8" import="eDS.*, eDS.Common.*, eCommon.Common.*,webbeans.eCommon.*,java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet" %>

<%@ page import="java.net.URLDecoder" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ include file="../../eOT/jsp/StringUtil.jsp" %>
<% request.setCharacterEncoding("UTF-8"); %>
<html>
<title><fmt:message key="eDS.Drug-Food.Label" bundle="${ds_labels}" /></title>
<script type="text/javascript" src="../../eDS/js/PlaceDietOrder.js"></script>
<script type="text/javascript" src="../../eDS/js/PlaceDietOrderPHIS.js"></script>
<script type="text/javascript" src="../../eDS/js/DSCommon.js"></script>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<head>
<body>
<form>
	<table>
 		<tr>
			<td colspan="2"> <img id="alertval" src='../../eDS/css/alertVal.png' width="100" height="100" style='visibility:visible' ></img></td><td style="color:red;">
<%
String func_mode = request.getParameter("func_mode")== null?"":request.getParameter("func_mode");
try{
if(func_mode.equals("getretVal")){
			String ret_val = checkForNull(request.getParameter("ret_val"));
			String fromDate=checkForNull(request.getParameter("fromDate"));
			String dateTo=checkForNull(request.getParameter("dateTo"));
			System.err.println("ret_val===>"+ret_val);
			String Severity="";
			String warn="";
			String restrict="";
			String Documentation="";
			if(ret_val!="" || ret_val!="null")
			{
			String[] retVal = ret_val.split(",");
			int retValLen = retVal.length/9;
			int count =0;
			int countInc =8;
			ArrayList<String> ret = new ArrayList<String>();
			for(int i=1;i<=retValLen;i++){
				for(int j=count;j<=countInc;j++){
						 ret.add(retVal[j]);
					}
					String[] nameArray = ret.toArray(new String[ret.size()]);
					Severity = nameArray[4].trim();
					Documentation = nameArray[6].trim();
					if(Severity.equals("H"))
					{
						Severity="Major";
					}
					else if(Severity.equals("M"))
					{
						Severity="Moderate";
					}
					else
					{
						Severity="Minor";
					}
					if(Documentation.equals("E"))
					{
						Documentation="Established";
					}
					else if(Severity.equals("P"))
					{
						Documentation="Probabled";
					}else if(Severity.equals("S"))
					{
						Documentation="Suspected";
					}else if(Severity.equals("O"))
					{
						Documentation="Possible";
					}
					else
					{
						Documentation="Unlikely";
					}
					if(fromDate.equals(dateTo)){
					 warn = nameArray[1]+" interact with"+nameArray[2]+"("+nameArray[3].trim()+"). Drug with Food Interaction may occur with this order. (Severity Level - "+Severity+"), (Significant Level -" +nameArray[5]+")and (Documentation - "+Documentation+").";
					 restrict=nameArray[1]+" interact with"+nameArray[2]+"("+nameArray[3].trim()+"). Drug with Food Interaction may occur with this order. (Severity Level - "+Severity+"), (Significant Level - " +nameArray[5]+") and (Documentation - "+Documentation+"). Hence, the drug can not be prescribed.";
					}
					else
					{
					 warn = "On "+nameArray[0]+","+nameArray[1]+" interact with"+nameArray[2]+"("+nameArray[3].trim()+"). Drug with Food Interaction may occur with this order. (Severity Level - "+Severity+"), (Significant Level -" +nameArray[5]+") and (Documentation - "+Documentation+").";
					 restrict= "On "+nameArray[0]+","+nameArray[1]+" interact with"+nameArray[2]+"("+nameArray[3].trim()+"). Drug with Food Interaction may occur with this order. (Severity Level - "+Severity+"), (Significant Level - " +nameArray[5]+") and (Documentation - "+Documentation+"). Hence, the drug can not be prescribed.";
					}
					if(nameArray[7].equals(" Y"))
					{
					
%>	
					<br><%=restrict%>
<%
					}
					else
					{
%>	
					<br><%=warn%>				
<%						}
					ret.clear();
					count=count+9;
					countInc = countInc+9;	
				}
			}
		}
		if(func_mode.equals("groupOrder")){
			String ret_val = checkForNull(request.getParameter("ret_val"));
			String fromDate=checkForNull(request.getParameter("fromDate"));
			System.err.println("fromDate=jsp==>"+fromDate);
			String dateTo=checkForNull(request.getParameter("dateTo"));
			System.err.println("dateTo=jsp==>"+dateTo);
			System.err.println("ret_val===>"+ret_val);
			String Severity="";
			String warn="";
			String restrict="";
			String Documentation="";
			if(ret_val!="" || ret_val!="null")
			{
			String[] retVal = ret_val.split(",");
			int retValLen = retVal.length/10;
			int count =0;
			int countInc =9;
			ArrayList<String> ret = new ArrayList<String>();
			for(int i=1;i<=retValLen;i++){
				for(int j=count;j<=countInc;j++){
						 ret.add(retVal[j]);
					}
					String[] nameArray = ret.toArray(new String[ret.size()]);
					Severity = nameArray[4].trim();
					Documentation = nameArray[6].trim();
					if(Severity.equals("H"))
					{
						Severity="Major";
					}
					else if(Severity.equals("M"))
					{
						Severity="Moderate";
					}
					else
					{
						Severity="Minor";
					}
					if(Documentation.equals("E"))
					{
						Documentation="Established";
					}
					else if(Severity.equals("P"))
					{
						Documentation="Probabled";
					}else if(Severity.equals("S"))
					{
						Documentation="Suspected";
					}else if(Severity.equals("O"))
					{
						Documentation="Possible";
					}
					else
					{
						Documentation="Unlikely";
					}
					if(fromDate.equals(dateTo)){
					 warn = "<b>"+nameArray[9]+"</b>"+nameArray[1]+" interact with"+nameArray[2]+"("+nameArray[3].trim()+"). Drug with Food Interaction may occur with this order. (Severity Level - "+Severity+"), (Significant Level -" +nameArray[5]+")and (Documentation - "+Documentation+").";
					 restrict= "<b>"+nameArray[9]+"</b>"+nameArray[1]+" interact with"+nameArray[2]+"("+nameArray[3].trim()+"). Drug with Food Interaction may occur with this order. (Severity Level - "+Severity+"), (Significant Level - " +nameArray[5]+") and (Documentation - "+Documentation+"). Hence, the drug can not be prescribed.";
					}
					else
					{
					 warn = "On "+nameArray[0]+","+"<b>"+nameArray[9]+"</b>"+nameArray[1]+" interact with"+nameArray[2]+"("+nameArray[3].trim()+"). Drug with Food Interaction may occur with this order. (Severity Level - "+Severity+"), (Significant Level -" +nameArray[5]+") and (Documentation - "+Documentation+").";
					 restrict= "On "+nameArray[0]+","+"<b>"+nameArray[9]+"</b>"+nameArray[1]+" interact with"+nameArray[2]+"("+nameArray[3].trim()+"). Drug with Food Interaction may occur with this order. (Severity Level - "+Severity+"), (Significant Level - " +nameArray[5]+") and (Documentation - "+Documentation+"). Hence, the drug can not be prescribed.";
					}
					if(nameArray[7].equals(" Y"))
					{
					
%>	
					<br><%=restrict%>
<%
					}
					else
					{
%>	
					<br><%=warn%>				
<%						}
					ret.clear();
					count=count+10;
					countInc = countInc+10;	
				}
			}
		}
		
	}
	catch(Exception e)
		{
			System.err.println("AlertValidation.jsp====>>>"+e.toString());
			e.printStackTrace();
		}
	%>
</td>
</tr>
  		<tr></tr><tr><td colspan="2">
		<td align="right">
				<input type="button" name="" id="" value='<fmt:message key="eOT.Ok.label" bundle="${ot_labels}" />'
				class="button" onClick="window.close();" />
			</td>
  		</tr>
	</table>	
</form>
</body>
</head>
</html>
<!--Gomathi added for the MMS-KH-CRF-0029.1 Ends Here-->

