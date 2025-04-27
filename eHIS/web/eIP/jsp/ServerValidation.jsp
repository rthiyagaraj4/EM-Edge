<!DOCTYPE html>
<html>
<%@ page contentType="text/html;charset=UTF-8" import="webbeans.eCommon.*,java.sql.*"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<% request.setCharacterEncoding("UTF-8");  %>
<head>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
</head>
<body class=MESSAGE onMouseDown='CodeArrest()' onKeyDown='lockKey()'>
<%

	Connection con = null;
	Statement stmt = null;
	ResultSet rs = null;
	String facilityId = (String) session.getValue("facility_id");

	try
	{
		con = ConnectionManager.getConnection(request);
		stmt = con.createStatement();
		out.println("<script>var f = parent.frames[1];</script>");
		
		String bldngcode = request.getParameter("building_code")==null?"":request.getParameter("building_code");
		String floorcode = request.getParameter("floor_code")==null?"":request.getParameter("floor_code");
		String function_id = request.getParameter("function_id")==null?"":request.getParameter("function_id");
		String service_code = request.getParameter("serviceCode")==null?"":request.getParameter("serviceCode");
		String code = "";
		String desc = "";
		%>
			<script>
			var n="";
		if('<%=function_id%>'=='MODIFY_SERVICE_FOR_INPATIENT')
			n = parent.frames[1].document.getElementById('sub_service').options.length;
		else
			n = parent.frames[1].document.getElementById('floor').options.length;

	
	for(var i=0;i<n;i++)
	{ 
		if('<%=function_id%>'=='MODIFY_SERVICE_FOR_INPATIENT')
			parent.frames[1].document.getElementById('sub_service').remove(0);
		else
			parent.frames[1].document.getElementById('floor').remove(0);		
	}
	var tp ="--- "+getLabel("Common.defaultSelect.label","Common")+" ---";
	var opt=parent.frames[1].document.createElement("OPTION");
	opt.text=tp;
	opt.value="";
	if('<%=function_id%>'=='MODIFY_SERVICE_FOR_INPATIENT')
		parent.frames[1].document.getElementById('sub_service').add(opt);
	else
		parent.frames[1].document.getElementById('floor').add(opt);
</script>
		<%
		if(function_id!=null && function_id.equals("MODIFY_SERVICE_FOR_INPATIENT"))
		{
			String	sql = "Select SUBSERVICE_CODE,am_get_desc.AM_SUBSERVICE(SERVICE_CODE,SUBSERVICE_CODE,'"+localeName+"',2 ) SUBSERVICE_SHORT_DESC from am_facility_subsrvc where OPERATING_FACILITY_ID = '"+facilityId+"' AND EFF_STATUS = 'E' AND SERVICE_CODE = '"+service_code+"' order by 2 ";

			rs = stmt.executeQuery(sql);

			if( rs!=null )
			{
				while(rs.next())
				{
					code = rs.getString("SUBSERVICE_CODE");
					desc = rs.getString("SUBSERVICE_SHORT_DESC");
					%>
						<script>
							var oOption = f.document.createElement("OPTION");
							oOption.text="<%=desc%>";
							oOption.value="<%=code%>";
							f.document.getElementById('sub_service').add(oOption);
						</script>
					<%
				}
			}
		}
		else
		{
			String	sql = " select FLOOR_CODE,SHORT_DESC from am_bldng_floor where OPERATING_FACILITY_ID = '"+facilityId+"' and BLDNG_CODE = '"+bldngcode+"' and EFF_STATUS = 'E' order by SHORT_DESC  ";
			rs = stmt.executeQuery(sql);
			if( rs!=null )
			{
				while(rs.next())
				{
					code = rs.getString("FLOOR_CODE");
					desc = rs.getString("SHORT_DESC");
					%>
						<script>
							var oOption = f.document.createElement("OPTION");
							oOption.text="<%=desc%>";
							oOption.value="<%=code%>";
							f.document.getElementById('floor').add(oOption);
							if("<%=floorcode%>" == "<%=code%>")
									oOption.selected = true;
						</script>
					<%
				}
			}
		}	
   
	}catch (Exception e){
		out.println(e);
	}
	finally{
		if(stmt != null) stmt.close();
		if(rs!=null) rs.close();
		
		ConnectionManager.returnConnection(con,request);
	}
%>
</body>
</html>
<%!
	/// Added by Sridhar R , on 4/26/2005.. these functions will chk for null values & initialize inputString values...
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

