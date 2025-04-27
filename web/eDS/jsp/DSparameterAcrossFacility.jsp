<!DOCTYPE html>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager"
%>
<%@page contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/Common.jsp"%>
<html>
<head>
<%
            //Checkstyle Violation commented by Munisekhar
			//String functionId=(String)session.getAttribute("functionId");
			//String moduleId=(String)session.getAttribute("moduleId");
			String facility_id	= (String)session.getAttribute("facility_id");
			String sStyle = ((session.getAttribute("PREFERRED_STYLE") != null) || (session
			.getAttribute("PREFERRED_STYLE") != "")) ? (String) session.getAttribute("PREFERRED_STYLE")
			:"IeStyle.css" ;
			if(sStyle==null)sStyle="IeStyle.css";
%>

<link rel="StyleSheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css" />
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="JavaScript" src="../../eCommon/js/dchk.js"></script>
<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<script language="javascript" src="../../eDS/js/DSparameterAcrossTheFacility.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


 </head>
	<body OnMouseDown="CodeArrest()" onKeyDown="lockKey()">
	<%
		Connection con=null;
		PreparedStatement stmt=null,stmtParam=null;
		ResultSet rs=null,rsParam=null;
		String dept_code="";
		String dept_description="";
		String uom_description="";
		String uom_code="";
		String param_dept_code="";
		String param_energyUOM="";
		String sql = "",sqlParam="";
	%>
	<script>
	function apply() {
		if(checkNull())
		content.DSparameterAcrossTheFacilityForm.submit();
	}
	function checkNull(){
		deptCode=document.getElementById("deptCode").value;
		uomCode=document.getElementById("uomCode").value;

		if(deptCode == ""){
			var error = " Department Code cannot be blank";
			messageFrame.location.href = "../../core/jsp/MessageFrame.jsp?error=" + error;
			flag_check = 'false';
			return false;
		}
		if(uomCode == ""){
			var error = "Energy UOM cannot be blank";
			messageFrame.location.href = "../../core/jsp/MessageFrame.jsp?error=" + error;
			flag_check = 'false';
			return false;
		}
		return true;
	}
	</script>
	<form action="" target="messageFrame" name="DSparameterAcrossTheFacilityForm" id="DSparameterAcrossTheFacilityForm">
			<input type="hidden" name="mode" id="mode" value="insert"/>
			<br>
			<table border='0' cellpadding='2' cellspacing='0' width='75%' align='center'>
				<tr>
					<td align="left" class='label'>
						<fmt:message key="eOT.dsparameteracrossfacility.deptcode" bundle="${ot_labels}" />
					</td>
					<td>
						<select name="deptCode" id="deptCode">
						<option value="">
							<fmt:message key="eOT.select.Label" bundle="${ot_labels}" />
						</option>

						<% try
						      {
						        con=ConnectionManager.getConnection(request);

								sql= " select DEPT_CODE, SHORT_DESC from AM_DEPT where (EFF_STATUS='E' ) order by  2 , 1";
								sqlParam= "select DEPT_CODE , ENERGY_UOM from DS_PARAM where SL_NO=1";

								stmt=con.prepareStatement(sql);
								stmtParam=con.prepareStatement(sqlParam);

								rs=stmt.executeQuery();
								rsParam=stmtParam.executeQuery();

								if(rsParam !=null)
								{
								   while(rsParam.next())
								        { %>
								        <script>
								        	document.getElementById("mode").value="modify";
								        </script>

									    <%  param_dept_code=rsParam.getString(1);
									        param_energyUOM=rsParam.getString(2);
										}
							  	}

								if(rs!=null)
								{
								   while(rs.next())
								        {
									        dept_code=rs.getString(1);
									        dept_description=rs.getString(2);
									        if(param_dept_code.equals(dept_code)) {
						                    %>
							               <option value="<%=dept_code%>" selected><%=dept_description%>
							          	<% }else {
							          	%>
							          	<option value="<%=dept_code%>"><%=dept_description%>

						            <% } }
							  }%>
									</select><img src='../../eCommon/images/mandatory.gif' align='center'>

							 <% }catch(Exception e){out.println("exp"+e);}

							  finally{
							try{
							//Checkstyle Correction added by Munisekhar
                                if(rsParam!=null) rsParam.close();
								if(stmtParam!=null) stmtParam.close();
							    if(rs!=null) rs.close();
								if(stmt!=null) stmt.close();
								//Checkstyle Violation commented by Munisekhar
								//ConnectionManager.returnConnection(con);
							}catch(Exception e)
								{
								out.println("exp"+e);
								}
						}
						%>
					</td>
				<tr>
					<td align="left" class='label'>
						<fmt:message key="eOT.dsparameteracrossfacility.energy" bundle="${ot_labels}" />
					</td>
					<td>
						<select name="uomCode" id="uomCode" >
						<option value="">
							<fmt:message key="eOT.select.Label" bundle="${ot_labels}" />
							</option>

						<% try
						      {//Checkstyle Violation commented by Munisekhar
						        //con=ConnectionManager.getConnection(request);

								sql= "select UOM_CODE , SHORT_DESC from AM_UOM where (EFF_STATUS='E' ) order by  2 , 1";
								stmt=con.prepareStatement(sql);
								rs=stmt.executeQuery();
								if(rs!=null)
								{
								   while(rs.next())
								        {
									        uom_code=rs.getString(1);
									        uom_description=rs.getString(2);
									        if(param_energyUOM.equals(uom_code)) {
						                    %>
							               <option value="<%=uom_code%>" selected><%=uom_description%>
							          	<% }
									       else {
							          	%>
							          	<option value="<%=uom_code%>"><%=uom_description%>
						            <%	  }
						            	}
							  }%>
									</select><img src='../../eCommon/images/mandatory.gif' align='center'>

							 <% }catch(Exception e){out.println("exp"+e);}

							  finally{
							try{

							 if(rs!=null) rs.close();
								if(stmt!=null) stmt.close();
								ConnectionManager.returnConnection(con);
							}catch(Exception e)
								{
								out.println("exp"+e);
								}
						}
						%>
						</select>
					</td>
				</tr>

			</table>
			<input type="hidden" name="function_id" id="function_id" value="DS_PARAM"/>
			<input type="hidden" name="moduleId" id="moduleId" value="DS"/>
			<input type="hidden" name="slNo" id="slNo" />
			<input type="hidden" name="facilityId" id="facilityId" value="<%=facility_id%>"/>
		</form>
	</body>
</html>

