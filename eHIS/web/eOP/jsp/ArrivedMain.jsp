<!DOCTYPE html>
<!--
	Developed by 	:	Smita Unnikrishnan
	Created on 	:	13/05/2004
	Module		:	Out Patient Management
	Function	:	This file is used for marking the particular patient as arrived.
-->
    
	 <%@ page import="java.sql.*, java.util.*, java.text.*,javax.servlet.jsp.JspWriter,webbeans.eCommon.*" contentType="text/html; charset=UTF-8" %>
	 <%	request.setCharacterEncoding("UTF-8");	%>
	 <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
	 <html>
		 <head>
		 <title><fmt:message key="eOP.arrived.label" bundle="${op_labels}"/></title>
			<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
			<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
			<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
			<script language="javascript" src="../../eCommon/js/common.js"></script>
			<script language="javascript" src="../../eOP/js/ArrivedDeparted.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		 </head>
		 <body onKeyDown ='lockKey()'>
		 <%
		 //PreparedStatement pstmt =null;
		 //ResultSet rs=null;
		 //Connection con = null;

		 try{
		 //con=ConnectionManager.getConnection(request);
		 String Patientid=request.getParameter("Patientid");
		 if(Patientid == null) Patientid="";
		 String Patientname="";

		 String locationtypedesc=request.getParameter("locationtypedesc");
		 if(locationtypedesc == null) locationtypedesc="";

		 String locationtype=request.getParameter("location_type");
		 if(locationtype == null) locationtype= "";
		 String locationcode=request.getParameter("location_code");
		 if(locationcode == null) locationcode="";
		 String locationcodedesc=request.getParameter("location_desc");
		locationcodedesc=java.net.URLDecoder.decode(locationcodedesc,"UTF-8");
		 
		 if(locationcodedesc == null) locationcodedesc="";
		
		 String userlocn=request.getParameter("user_locn");
		 if(userlocn == null) userlocn="";
		 String userlocntype=request.getParameter("userlocntype");
		 if(userlocntype == null) userlocntype="";
		 String encounterid=request.getParameter("encounter_id");
		 if(encounterid == null) encounterid="";
		 String encounterdttime=request.getParameter("enc_dt_time");
		 if(encounterdttime == null) encounterdttime="";
		 String pat_trn_time=request.getParameter("pat_trn_time");
		 if(pat_trn_time == null) pat_trn_time="";
		 String encountertype=request.getParameter("enc_type");
		 if(encountertype == null) encountertype="";
		 //String facilityid=(String)session.getValue("facility_id");

		 

		/* String sql="select patient_name from mp_patient where patient_id='"+Patientid+"'";
		 
		 pstmt=con.prepareStatement(sql);
		 rs=pstmt.executeQuery();
		 if(rs != null && rs.next())
			 {
			 Patientname=rs.getString("patient_name");
			 }
			 if(rs != null) rs.close();
			 if(pstmt != null) pstmt.close();
		 }catch(Exception e)
			 {
		 out.println("Error"+e);
		 
		 }*/
		 %>
		 <form name="Arrivedmain_form" id="Arrivedmain_form" action="../../servlet/eOP.ArrivedDepartedServlet" method="post" target="dummyframe">
		 <table width='97%' align='center'>		
			<tr>
				<td>
					 <table cellpadding=3 cellspacing=0 border=0 width='97%' align='center'>					
					 <tr>
							<td class='label' colspan='2'><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/></td>
							<%
							if(locationtype.equals(""))
							{
							%>
							<td class='QUERYDATA' colspan='2'>&nbsp;</td>
							<%
							}
							else
							{
								%>
									<td class='QUERYDATA' colspan='2'><%=locationtypedesc%></td>
									<%
							}
								%>							
							</TR>
							<TR>
							<td class='label' colspan='2'><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
							<%
							if(locationcode.equals(""))
							{
							%>
								<td class='QUERYDATA' colspan='2'>&nbsp;</td>
								<%}
							else
							{%> <!--Below condition was added by Venkatesh.S on 16-Nov-2012 against SS-CRF-010 -->
							   <%if(locationtypedesc.equals("Room")){%>
							   <td class='QUERYDATA' colspan='2'><%=userlocn%> <%=locationcodedesc%></td>
							   <%}else{%>
								<td class='QUERYDATA' colspan='2'><%=locationcodedesc%></td>
							   <%}%>
								<%}%>						
						</tr>
						<tr>							
						<td align='right' colspan='4'><input type='button' class='button' name='ok' id='ok' value='<fmt:message key="Common.apply.label" bundle="${common_labels}"/>' onClick="submit_ok()"><input type='button'class='button' name='close' id='close' value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>' onClick='exitArrived()'>
						</td>						
						</tr>
					 </table>
				</td>
			</tr>
		</table>

		<input type='hidden' name="pat_id" id="pat_id" value="<%=Patientid%>">
				<!-- <input type='hidden' name="pat_name" id="pat_name" value="<%=Patientname%>"> -->
				<input type='hidden' name="enc_id" id="enc_id" value="<%=encounterid%>">
				<input type='hidden' name="enc_type" id="enc_type" value="<%=encountertype%>">
				<input type='hidden' name="enc_dt_time" id="enc_dt_time" value="<%=encounterdttime%>">
				<input type='hidden' name="pat_trn_time" id="pat_trn_time" value="<%=pat_trn_time%>">
				<input type='hidden' name="locn_type_desc" id="locn_type_desc" value="<%=locationtypedesc%>">
				<input type='hidden' name="locn_type" id="locn_type" value="<%=locationtype%>">
				<input type='hidden' name="locn_code" id="locn_code" value="<%=locationcode%>">
				<input type='hidden' name="locn_desc" id="locn_desc" value="<%=locationcodedesc%>">
				<input type='hidden' name="user_locn_type" id="user_locn_type" value="<%=userlocntype%>">
				<input type='hidden' name="user_locn_code" id="user_locn_code" value="<%=userlocn%>">
				<input type='hidden' name='func_val' id='func_val' value="Arrived" >
		</form>
			<%
			}catch(Exception e)
			{
			e.printStackTrace();
			}
			finally
			{
				//if(con != null)
				//	 ConnectionManager.returnConnection(con,request);

			}
			%>
		 </body>
	 </html>


