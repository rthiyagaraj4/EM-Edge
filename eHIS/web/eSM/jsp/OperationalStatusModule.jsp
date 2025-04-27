<!DOCTYPE html>
<%@ page import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*, eCommon.XSSRequestWrapper"  contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String facilityid = request.getParameter("facilityid");
	String opermodules = request.getParameter("opermodules");
	String groupid = request.getParameter("groupid");
	if(opermodules == null || opermodules.equals("null")) opermodules = "";

	
%>

<html>


<head>
	<%
          String sStyle	=
          (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
   %>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
        <script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
        <script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		
</head>

<script>
var arrModule = new Array();
var arrModVal = new Array();
var x = 0;

function setValue(Module,Obj)
{
	if(Obj.checked == true)
	{
		Obj.value = "Y";
		for(y = 0;y < x;y++)
		{
			if(arrModule[y] == Module)
			   arrModVal[y] = "Y";
		}
	}
	else
	{
		Obj.value = "N";
		for(y = 0;y < x;y++)
		{
			if(arrModule[y] == Module)
			   arrModVal[y] = "N";
		}
	}
	var modules = arrModule[0];
	var modvalues  = arrModVal[0];
	for(z = 1;z < x;z++)
	{
		modules += "|"+arrModule[z];	 	
		modvalues += "|"+arrModVal[z];	 	
	}

	document.forms[0].ModuleIDs.value = modules;
	document.forms[0].ModuleVals.value = modvalues;
}

function initialize()
{
	var modules = arrModule[0];
	var modvalues  = arrModVal[0];
	for(z = 1;z < x;z++)
	{
		modules += "|"+arrModule[z];	 	
		modvalues += "|"+arrModVal[z];	 	
	}

	document.forms[0].ModuleIDs.value = modules;
	document.forms[0].ModuleVals.value = modvalues;
}

</script>
<body onLoad="initialize();" onMouseDown="CodeArrest();"
onKeyDown = 'lockKey()'>
<form name="facility_oper_module_result" id="facility_oper_module_result">
<table border='1' cellpadding='0' cellspacing='0' width='90%' align='center'> 

<%
		Connection con = ConnectionManager.getConnection(request);
		PreparedStatement pstmt = null;
		PreparedStatement pstmt1 = null;
		ResultSet rs = null;
		ResultSet rs1 = null;
		String classValue = "QRYODD";
		String operFlag = "";
		String operYN = "";
        String disableData="";
 		int i = 1;
        int j=0;  
	try
	{

		if(opermodules.equals(""))
		{
			pstmt1 = con.prepareStatement("Select module_id, operational_yn operational_flag, srl_no from sm_modules_facility_vw where facility_id = ? and module_id != 'SM' and module_id not in(select module_id from sm_module where install_yn='N') Union Select module_id, 'N' operational_flag, srl_no from sm_module where install_yn = 'Y' and module_id != 'SM' and MODULE_GROUP_ID != 'FM' and module_id not in (Select module_id from sm_modules_facility where facility_id = ?) order by srl_no  ");
			
			pstmt1.setString	(	1,	facilityid		);		
			pstmt1.setString	(	2,	facilityid		);		
			rs1 = pstmt1.executeQuery();
			if(rs1 != null)
			{
				while(rs1.next())
				{
					%>
					<script>
					arrModule[x] = "<%=rs1.getString(1)%>";
					arrModVal[x] = "<%=rs1.getString(2)%>";
					x++;
					</script>
					<%
				}
			}
		}
		else
		{
			String chkModules = "";
			String chkValues = "";
			StringTokenizer stoken = new StringTokenizer(opermodules,"$");
			String Modules = stoken.nextToken();
			String Flags = stoken.nextToken();

			StringTokenizer smodtoken = new StringTokenizer(Modules,"|");
			StringTokenizer sflagtoken = new StringTokenizer(Flags,"|");
						
			while(smodtoken.hasMoreTokens())
			{
				chkModules = smodtoken.nextToken();
				chkValues  = sflagtoken.nextToken();
				%>
					<script>
					arrModule[x] = "<%=chkModules%>";
					arrModVal[x] = "<%=chkValues%>";
					x++;
					</script>
				<%
			}
		}

		pstmt = con.prepareStatement("Select module_id, module_name, operational_yn operational_flag, srl_no from sm_modules_facility_vw where facility_id = ? and module_id != 'SM' and module_group_id = ? and module_id not in(select module_id from sm_module where install_yn='N') Union Select module_id, module_name, 'N' operational_flag, srl_no from sm_module where module_group_id = ? and install_yn = 'Y' and module_id != 'SM' and module_id not in (Select module_id from sm_modules_facility where facility_id = ?) order by srl_no  ");
		pstmt.setString	(	1,	facilityid		);
		pstmt.setString	(	2,	groupid		);
		pstmt.setString	(	3,	groupid		);
		pstmt.setString	(	4,	facilityid		);
		rs = pstmt.executeQuery();

		
       int k=0;
	   String modId="";	
			while(rs.next())
			{ k++;
			    
				modId=rs.getString("module_id");
                 if(classValue.equals("QRYEVEN"))
                     classValue = "QRYODD";
                 else
                    classValue = "QRYEVEN";
				
				if(opermodules.equals(""))
				{
					operYN = rs.getString("operational_flag");
					if(operYN == null || operYN.equals("null")) operYN = "N";
					

					if(groupid.equals("CM"))

							{
							
							if(modId.equals("OR") || modId.equals("OT"))
								{
								
				     	if(operYN.equals("N"))
						operFlag = "Unchecked";
					   else
						operFlag = "Checked";
						disableData="";
						}
							else if(modId.equals("BL"))
							{
			  			if(operYN.equals("N"))
						operFlag = "Unchecked";
					else
						operFlag = "Checked";
					disableData="";
					}else
					{if(operYN.equals("N"))
						operFlag = "Unchecked";
					else
						operFlag = "Checked";
									//operFlag = "Unchecked";
								    disableData="";
					}
								}else if(groupid.equals("PC"))
					              {
                                    if(modId.equals("CA"))
							        {
			  							
						               if(operYN.equals("N")){
						               operFlag = "Unchecked";
									   //disableData="disabled";
									   }
					                   else
									  {
						               operFlag = "Checked";
								       disableData="";
									  }
									 }else
								      {
									      if(operYN.equals("N"))
						               operFlag = "Unchecked";
					                   else
						               operFlag = "Checked";
								           disableData="";
									   }
                                  }else
					               {
					                  if(operYN.equals("N"))
						               operFlag = "Unchecked";
					                   else
						               operFlag = "Checked";
					               }
								  
					
				
				}
				else
				{    
					String chkModules = "";
					String chkValues = "";
					StringTokenizer stoken = new StringTokenizer(opermodules,"$");
					String Modules = stoken.nextToken();
					String Flags = stoken.nextToken();

					StringTokenizer smodtoken = new StringTokenizer(Modules,"|");
					StringTokenizer sflagtoken = new StringTokenizer(Flags,"|");
					
						
					while(smodtoken.hasMoreTokens())
					{
						chkModules = smodtoken.nextToken();
						chkValues  = sflagtoken.nextToken();
						
						
						if(chkModules.equals(modId))
						{
							if(groupid.equals("CM"))
							{
							if(modId.equals("OR") || modId.equals("OT"))
								{
								
							if(chkValues.equals("N"))
								operFlag = "Unchecked";
							else
								operFlag = "Checked";
							 disableData="";
							}
							else if(modId.equals("BL"))
							{
			  				if(chkValues.equals("N"))
								operFlag = "Unchecked";
							else
								operFlag = "Checked";
							 disableData="";
							}else
							{if(chkValues.equals("N"))
							operFlag = "Unchecked";
							else
                             	operFlag = "Checked";
									 disableData="";
								}}else if(groupid.equals("PC"))
								{
							if(modId.equals("CA"))
								{
								if(operYN.equals("N")){
						               operFlag = "Unchecked";
									   //disableData="disabled";
									   }
					                   else
									  {
						               operFlag = "Checked";
								       disableData="";
									  }
							   }else
									{
									
									if(chkValues.equals("N"))
								operFlag = "Unchecked";
							else
								operFlag = "Checked";
									disableData="";
									}
								
								
								}else
							{
							
								if(chkValues.equals("N"))
								operFlag = "Unchecked";
							else
								operFlag = "Checked";
							}
								

								operYN = chkValues;
						}
					}	
				}
			  if(j==0)
				{j++;
				%>
           
					<th><fmt:message key="Common.Module.label" bundle="${common_labels}"/></th>
					 <th><fmt:message key="eSM.Operational.label" bundle="${sm_labels}"/></th>
				<%}
					String disabled="";
					String module_ids="AE,AM,DR,FM,IP,MP,MO,MR,OA,OP,SM,QA";
					if(module_ids.indexOf(rs.getString("module_id"))>=0){
						disabled="disabled";
					}
					%>
					<tr><td class='<%=classValue%>'><%=rs.getString("module_name")%></td>
					<td class='<%=classValue%>' align='center'>
					<input type='checkbox' name='chbox<%=i%>' id='chbox<%=i%>' <%=disabled%> value='<%=operYN%>' <%=operFlag%> <%= disableData%> onClick="setValue('<%=rs.getString("module_id")%>',this)"></td></tr>
				<%
				i++;
			
			
		
			
				}
		
			if(k==0)
				{%>
				<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'))
				parent.f_query_details.location.href = "../../eCommon/html/blank.html"
				</script>
				<%}


		if(rs != null) rs.close();
		if(rs1 != null) rs1.close();
		if(pstmt != null) pstmt.close();
		if(pstmt1 != null) pstmt1.close();

	}
	catch(Exception e) { out.println(e.toString()); }
	finally 
	{
		
		ConnectionManager.returnConnection(con, request);
	}
	%>
</table>
	<input type="hidden" name="TotRecs" id="TotRecs" value="<%=(i-1)%>">
	<input type="hidden" name="ModuleIDs" id="ModuleIDs" value="">
	<input type="hidden" name="ModuleVals" id="ModuleVals" value="">
</form>
</body>
</html>

