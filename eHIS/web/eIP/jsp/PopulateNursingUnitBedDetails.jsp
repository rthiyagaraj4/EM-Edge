<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import="webbeans.eCommon.*,java.sql.*,java.util.*"%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
<head>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eCommon/js/common.js' language='Javascript'></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<script>
function displayToolTip(obj,x_coordinate,y_coordinate)
{
	obj = obj + "^^";
	obj = unescape(obj);
	var rowval = obj.split ("<br>");
	
	var nowrapval = "";
	var tab_dat  = "<table id='tooltiptable1' cellpadding=0 cellspacing=0 border='2' width='25%' align='right'>";

	for( var i=0; i<rowval.length-1; i++ )
	{
		if(i==0)
		{
			var colval = rowval[i].split("^^");
			tab_dat += "<tr>";
			tab_dat += "<td class = 'label' nowrap > "+ colval[0] +" </td>";
			tab_dat += "<td class = 'label' nowrap > "+ colval[1] +" </td>";
			tab_dat += "<td class = 'label' nowrap > "+ colval[2] +" </td>";
			tab_dat += "<td class = 'label' nowrap > "+ colval[3] +" </td>";
			tab_dat += "<td class = 'label' nowrap > "+ colval[4] +" </td>";
			tab_dat += "</tr> ";
			
		}
		else
		{
			var colval = rowval[i].split("^^");
			tab_dat += "<tr>";
			tab_dat += "<td class = 'QUERYDATA' nowrap > "+ colval[0] +" </td>";
			tab_dat += "<td class = 'QUERYDATA' nowrap > "+ colval[1] +" </td>";
			tab_dat += "<td class = 'QUERYDATA' nowrap > "+ colval[2] +" </td>";
			tab_dat += "<td class = 'QUERYDATA' nowrap > "+ colval[3] +" </td>";
			tab_dat += "<td class = 'QUERYDATA' nowrap > "+ colval[4] +" </td>";
			tab_dat += "</tr>";
		}
	}

	tab_dat += "</table> ";

	if (parent.frames[1].document.getElementById("t") != null)
		parent.frames[1].document.getElementById("t").innerHTML = tab_dat;
	if(parent.frames[1].document.getElementById("tooltiplayer"))
		parent.frames[1].document.getElementById("tooltiplayer").style.visibility="visible";
	if(parent.frames[1].document.body) {
		var bodwidth  = (parent.frames[1].document.body.offsetWidth)/2;
		var bodheight = (parent.frames[1].document.body.offsetHeight)/2;
	}
	
//	var x = x_coordinate - 1;
	var y = y_coordinate - 5;
	if(parent.frames[1].document.body)
		y += parent.frames[1].document.body.scrollTop;
//  x += parent.frames[1].document.body.scrollLeft;
	if(parent.frames[1].document.getElementById("tooltiplayer")) {
		parent.frames[1].document.getElementById("tooltiplayer").style.left= bodwidth;//2;
		parent.frames[1].document.getElementById("tooltiplayer").style.top =bodheight; //y;
	}
}


</script>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name="bed_class_form1" id="bed_class_form1">
<%
	request.setCharacterEncoding("UTF-8");
	Connection con			= null;
	PreparedStatement pstmt	= null;
	ResultSet rs			= null;

	//String locale					= (String)session.getAttribute("LOCALE");
	String facilityId				=	(String)session.getValue("facility_id");
	String nursingunitcode			= checkForNull(request.getParameter("nursingunit"));
	String x_coordinate				= checkForNull(request.getParameter("x_coordinate"));
	String y_coordinate				= checkForNull(request.getParameter("y_coordinate"));

	try
	{
		StringBuffer sql	=	new StringBuffer();
		StringBuffer tooltipStr	=  new StringBuffer();
		String bed_class	= "";				
		String total_beds	= "";				
		String occupied		= "";				
		String vacant		= "";				
		String block		= "";	
		int maxCount		= 0;
		//and a.eff_status = 'E' Added by Dharma on 26th Nov 2018 against AMS-SCF-0707 [IN:068007]
		sql.append("SELECT IP_GET_DESC.IP_BED_CLASS(b.bed_class_code,?,2) bed_class ,COUNT(*) total_beds, COUNT(a.occupying_patient_id) occupied, COUNT(*) - (COUNT(a.occupying_patient_id) + (SELECT COUNT(*) FROM IP_BED_BOOKING WHERE facility_id = ?  AND req_nursing_unit_code = ? AND req_bed_class_code = b.bed_class_code and booking_status in ('0','1') and ((sysdate BETWEEN blocked_from_date_time AND blocked_until_date_time) or ( booking_type = 'N' and blocked_until_date_time is null ))))vacant, (SELECT COUNT(*) FROM IP_BED_BOOKING WHERE facility_id = ? AND req_nursing_unit_code = ? AND req_bed_class_code = b.bed_class_code and booking_status in ('0','1') and ((sysdate BETWEEN blocked_from_date_time AND blocked_until_date_time) or (booking_type = 'N' and blocked_until_date_time is null ))) block FROM IP_NURSING_UNIT_BED a, IP_BED_CLASS b WHERE a.facility_id = ? AND a.nursing_unit_code = ? AND a.bed_class_code = b.bed_class_code AND pseudo_bed_yn = 'N' and a.eff_status = 'E' GROUP BY b.bed_class_code ");

//out.println("<script>alert(\""+sql.toString()+"\")</script>");
		con		=	ConnectionManager.getConnection(request);
		pstmt	=	con.prepareStatement(sql.toString());
		pstmt.setString(1,localeName);
		pstmt.setString(2,facilityId);
		pstmt.setString(3,nursingunitcode);
		pstmt.setString(4,facilityId);
		pstmt.setString(5,nursingunitcode);
		pstmt.setString(6,facilityId);
		pstmt.setString(7,nursingunitcode);
		rs		=	pstmt.executeQuery();

		while(rs.next())
		{

			if(maxCount==0)
			{
				tooltipStr.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.BedClass.label","common_labels"));
				tooltipStr.append("^^");
				tooltipStr.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.TotalBeds.label","ip_labels"));
				tooltipStr.append("^^");
				tooltipStr.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Occupied.label","common_labels"));
				tooltipStr.append("^^");
				tooltipStr.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Vacant.label","common_labels"));
				tooltipStr.append("^^");
				tooltipStr.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.block.label","common_labels"));
				tooltipStr.append("^^");
				tooltipStr.append("<br>");
			}

			bed_class				= checkForNull(rs.getString("bed_class"));
			total_beds				= checkForNull(rs.getString("total_beds"));
			occupied				= checkForNull(rs.getString("occupied"));
			vacant					= checkForNull(rs.getString("vacant"));
			vacant					= Integer.parseInt(vacant) < 0 ? "0" : vacant +"";
			block					= checkForNull(rs.getString("BLOCK"));

			tooltipStr.append(bed_class);
			tooltipStr.append("^^");
			tooltipStr.append(total_beds);
			tooltipStr.append("^^");
			tooltipStr.append(occupied);
			tooltipStr.append("^^");
			tooltipStr.append(vacant);
			tooltipStr.append("^^");
			tooltipStr.append(block);
			tooltipStr.append("^^");
			tooltipStr.append("<br>");
			maxCount++;
		}
		
		if (rs != null) rs.close();
		if (pstmt != null) pstmt.close();

		if(maxCount>0)
		{
			out.println("<script>displayToolTip(\""+tooltipStr.toString()+"\",\""+x_coordinate+"\",\""+y_coordinate+"\");</script>");
		}
	}catch(Exception e) 
	{	
		
		e.printStackTrace();
	}
	finally
	{
		ConnectionManager.returnConnection(con,request);
	}
%>

</form>
</body>
</html>

<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	private String checkForNull(String inputString, String defaultValue)
	{
		return (inputString==null)	?	defaultValue	:	inputString;
	}
%>


