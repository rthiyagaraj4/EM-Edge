<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import ="webbeans.eCommon.*,java.sql.*" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %> 
<title><fmt:message key="eIP.PseudoBed.label" bundle="${ip_labels}"/></title>
<head><link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
</head>
<body onMouseDown='CodeArrest()' onKeyDown='lockKey()'>
<script language="JavaScript">
function returnBedNo(bedno)
{
	window.returnValue = bedno;
	window.close();
}

</script>
<form name='pseudoBed' id='pseudoBed' target=self>
<table cellpadding=0 cellspacing=0 align=center width="100%" border=1>
<tr>
<th><fmt:message key="Common.bedno.label" bundle="${common_labels}"/></th>
<th><fmt:message key="Common.roomno.label" bundle="${common_labels}"/></th>
<th><fmt:message key="Common.BedClass.label" bundle="${common_labels}"/></th>
<th><fmt:message key="Common.bedtype.label" bundle="${common_labels}"/></th>
</tr>
<%
	request.setCharacterEncoding("UTF-8");
   Connection con = null;
   Statement stmt =  null;
   ResultSet rs=null;
   String facilityid  = (String) session.getValue("facility_id");
   String nursingunitcode = request.getParameter("nursing_unit_code")==null?"":request.getParameter("nursing_unit_code");

   String className = "";String className1="";
   int i = 0;
	 //Pseudo Beds Available for Nursing Unit
	try{
   	   con  = ConnectionManager.getConnection(request);
	   stmt = con.createStatement();	 

	   String sql = " Select Bed_no,ROOM_NO,BED_CLASS_SHORT_DESC,BED_TYPE_SHORT_DESC from IP_Nursing_Unit_Bed_VW where Facility_Id='"+facilityid+"' and Nursing_Unit_Code='"+nursingunitcode+"' and Pseudo_Bed_YN='Y' and Current_Status='A' and eff_status='E' ";
	   rs = stmt.executeQuery(sql);
	   if(rs.next())
	   {
		   do{
				   if(i % 2 == 0)
						{ 
						className = "QRYODD";
						className1="QRYODDDISP";
						}
				   else
					   { className =  "QRYEVEN";className1="QRYEVENDISP"; }

				   out.println("<tr><td onClick=\"javascript:returnBedNo('"+rs.getString("Bed_no")+"')\" class='"+className1+"'><font color='blue'>"+rs.getString("Bed_no")+"</font></td>");
				   out.println("<td class='"+className+"'>"+rs.getString("ROOM_NO")+"</td>");
				   out.println("<td class='"+className+"'>"+rs.getString("BED_CLASS_SHORT_DESC")+"</td>");
				   out.println("<td class='"+className+"'>"+rs.getString("BED_TYPE_SHORT_DESC")+"</td></tr>");
				   i++;
		   }while(rs.next());
	   }
	   else
		   out.println("<script>alert(getMessage('CREATE_PSEUDO_BEDS','IP'));parent.window.returnValue='F';parent.window.close();</script>");

	}catch(Exception e){
	   out.println("error " + e);
	}
	finally
	{
		if (stmt!=null) stmt.close();
		if (rs!=null) rs.close();
		ConnectionManager.returnConnection(con,request);
	}
%>
</table>
<table align=right cellpadding=0 cellspacing=0 width="100%">
<tr><td colspan='4' align='right' class='BUTTON'><input type='button' name='closing' id='closing'  value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>' class="BUTTON" onClick='window.parent.close();'></td></tr>
</table>
</form>
</body>
</html>

<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

