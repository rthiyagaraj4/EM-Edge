<!DOCTYPE html>
<!--
	Developed by 	:	Parimala
	Created on 	:	22/12/2000
	Module		:	Out Patient Management
	Function	:	This file is used for displaying of frame 1 & 2 as- below.
-->
    <%@ page import="java.sql.*, java.util.*, java.text.*,javax.servlet.jsp.JspWriter,webbeans.eCommon.*" contentType="text/html; charset=UTF-8" %>
	 <%	request.setCharacterEncoding("UTF-8");	%>
	 <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
	 <html>
		 <head>
		 <title><fmt:message key="eOP.Departed.label" bundle="${op_labels}"/></title>
	
			<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
			<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
			<script language="javascript" src="../../eCommon/js/common.js"></script>
			<script language="javascript" src="../../eOP/js/ArrivedDeparted.js"></script>
			<script src='../../eCommon/js/CommonLookup.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		
		 <script>
			var Larray=new Array();
			var selindex=0;
			var i=1;
		</script>
		 
		 </head>
		 <body onKeyDown = 'lockKey();'>
		 <%

			PreparedStatement pstmt =null;
			ResultSet rs=null;
			Connection con = null;
			String fac_id=(String)session.getAttribute("facility_id");
			String locale=(String)session.getAttribute("LOCALE"); 
		 try{
		 con=ConnectionManager.getConnection(request);
		 String Patientid=request.getParameter("Patientid");
		 if(Patientid == null) Patientid="";
		 String Patientname="";
		 Patientname=java.net.URLDecoder.decode(Patientname);
		 String userlocn=request.getParameter("user_locn");		
		 String userlocntype1=request.getParameter("userlocntype");
		 String userlocntypedesc="";
		 String userlocntype="";
		 String locn_ind="";		 
		 String encounterid=request.getParameter("encounter_id");
		 if(encounterid == null) encounterid="";
		 String encounterdttime=request.getParameter("enc_dt_time");
		 if(encounterdttime == null) encounterdttime="";
		 String pat_trn_time=request.getParameter("pat_trn_time");
		 if(pat_trn_time == null) pat_trn_time="";
		 String encountertype=request.getParameter("enc_type");
		 if(encountertype == null) encountertype="";
		  String locationtypedesc=request.getParameter("locationtypedesc");
		 if(locationtypedesc == null) locationtypedesc="";

		 String locationtype=request.getParameter("location_type");
		 if(locationtype == null) locationtype= "";
		 String locationcode=request.getParameter("location_code");
		 if(locationcode == null) locationcode="";
		 String locationcodedesc=request.getParameter("location_desc");
		 if(locationcodedesc == null) locationcodedesc="";

		 String enc_locn_type=request.getParameter("enc_loc_type");
		 if(enc_locn_type == null) enc_locn_type="";
		 String enc_locn_code=request.getParameter("enc_loc_code");
		 if(enc_locn_code == null) enc_locn_code="";

		/* try{

		 String sql="select patient_name from mp_patient where patient_id='"+Patientid+"'";
		 pstmt=con.prepareStatement(sql);
		 rs=pstmt.executeQuery();
		 if(rs != null && rs.next())
			 {
			 Patientname=rs.getString("patient_name");

			 }

			 if(rs != null) rs.close();
			 if(pstmt != null) pstmt.close();
		 }catch(Exception e)
			 {}*/

		/*String locsql="";
				
		if(userlocntype1.equals("N") || userlocntype1.equals("C") || userlocntype1.equals("E") || userlocntype1.equals("Y"))
		 {
			locsql="select locn_type,short_desc,care_locn_type_ind from am_care_locn_type where SYS_USER_DEF_IND='S' AND locn_type NOT IN ('C', 'E','Y','N','B','H','D') order by 2";
		 }
		else
		 {
			locsql="SELECT locn_type, short_desc, care_locn_type_ind FROM am_care_locn_type WHERE sys_user_def_ind = 'S' AND locn_type in ('"+enc_locn_type+"', 'O', 'W', 'R','T','S') order by short_desc ";
		 }*/

		 %>
		 <form name="Arrivedmain_form" id="Arrivedmain_form" action="../../servlet/eOP.ArrivedDepartedServlet" method="post" target="dummyframe">
		 <table cellpadding=0 cellspacing=0 border=0 width='100%' align='center'>		 
			<tr>
	<td>
	 <table cellpadding='3' cellspacing=0 border=0 width='100%' align='center'>
	 	<tr>
		<td class='label' colspan='2'><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/></td>
		<td class='fields' colspan='2'><select name="location_type1" id="location_type1" onChange="clearlist1(this);">
				<option value=''>&nbsp;&nbsp;-------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> --------&nbsp;&nbsp;	
		<%
			 //pstmt = con.prepareStatement("select locn_type,short_desc,care_locn_type_ind from am_care_locn_type where SYS_USER_DEF_IND='S' and locn_type NOT IN ('B', 'H', 'D') order by 2");

			 pstmt = con.prepareStatement("select locn_type,short_desc,care_locn_type_ind from am_care_locn_type_lang_vw where language_id='"+locale+"' and SYS_USER_DEF_IND='S' and locn_type NOT IN ('B', 'H', 'D') order by 2");
				rs=pstmt.executeQuery();
				if(rs != null) 
				 {
					while(rs.next())
					 {
						userlocntype=rs.getString(1);
						userlocntypedesc=rs.getString(2);
						locn_ind=rs.getString(3);
						%>
							<option value='<%=userlocntype%>' ><%=userlocntypedesc%>
							<%
					%>
					<script>
					   Larray[i]='<%=locn_ind%>';
						i++;
					</script>
					<%
				  }
				 }
				 if(pstmt != null) pstmt.close();
				 if(rs != null) rs.close();

		%>
			</select><img src='../../eCommon/images/mandatory.gif' align='center'></img>
		</td>		
		</tr>			
			<tr>
			<td class='label' colspan='2'><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
			<td class='fields' colspan='2'>
			<INPUT TYPE="text" name="loc_code1" id="loc_code1"  onBlur="onBlurgetLoc('<%=fac_id%>','<%=locale%>','Departed',document.forms[0].loc_code1);"><input type="button" name="qloc_butt" id="qloc_butt" value="?" class="button" onClick="getLocn('<%=fac_id%>','<%=locale%>','Departed',document.forms[0].loc_code1);" ><img align='center' src='../../eCommon/images/mandatory.gif'></img>
			<input type="hidden" name="location_code1" id="location_code1">

			<!--<select name="location_code1" id="location_code1" >
			<option value=''>&nbsp;&nbsp;-------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> --------&nbsp;&nbsp;</select><img src='../../eCommon/images/mandatory.gif' align='center'></img></td>	-->
		</tr>	
		<tr>
						<td class='label' colspan='2' nowrap><fmt:message key="eOP.ReasonForMovement.label" bundle="${op_labels}"/></td>
						<td class='fields' colspan='2'><select name='move_reason' id='move_reason'>
							<option value=''>&nbsp;&nbsp;--------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------&nbsp;&nbsp;</option>
						<%
							String reasonCode="";
							String reasonDesc="";
							//pstmt=con.prepareStatement("select contact_reason_code,contact_reason from am_contact_reason where  PATIENT_DEPART_YN='Y' order by 2");

							pstmt=con.prepareStatement("select contact_reason_code,contact_reason from am_contact_reason_lang_vw where language_id='"+locale+"' and PATIENT_DEPART_YN='Y' order by 2");
							rs=pstmt.executeQuery();
							if(rs != null)
							{
								while(rs.next())
								{
									reasonCode=rs.getString(1);
									reasonDesc=rs.getString(2);
								%>
							    <option value="<%=reasonCode%>"><%=reasonDesc%></option>
								<%
								}
							}
							if(rs != null) rs.close();
							if(pstmt != null) pstmt.close();
						%>
						</select><img src='../../eCommon/images/mandatory.gif' align='center'></img>
						</td>						
						</tr>
					 <tr>
					   	<td colspan='2' align='right'><input type='button' class='button' name='ok' id='ok' value='<fmt:message key="Common.apply.label" bundle="${common_labels}"/> ' onClick="Depsubmit_ok()"><input type='button' class='button' name='close' id='close' value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>' onClick='exitDeparted()'>
						</td>
						
					 </tr>
					 </table>
				</td>
			</tr>
		</table>

		<input type='hidden' name="pat_id" id="pat_id" value="<%=Patientid%>">
			<!-- 	<input type='hidden' name="pat_name" id="pat_name" value="<%=Patientname%>"> -->
				<input type='hidden' name="enc_id" id="enc_id" value="<%=encounterid%>">
				<input type='hidden' name="enc_type" id="enc_type" value="<%=encountertype%>">
				<input type='hidden' name="enc_dt_time" id="enc_dt_time" value="<%=encounterdttime%>">
				<input type='hidden' name="pat_trn_time" id="pat_trn_time" value="<%=pat_trn_time%>">
				<input type='hidden' name="locn_type_desc" id="locn_type_desc" value="<%=locationtypedesc%>">
				<input type='hidden' name="locn_type" id="locn_type" value="<%=locationtype%>">
				<input type='hidden' name="locn_code" id="locn_code" value="<%=locationcode%>">
				<input type='hidden' name="locn_desc" id="locn_desc" value="<%=locationcodedesc%>">
				<input type='hidden' name="user_locn_type" id="user_locn_type" value="<%=userlocntype1%>">
				<input type='hidden' name="user_locn_code" id="user_locn_code" value="<%=userlocn%>">
				<input type='hidden' name='func_val' id='func_val' value="Depart" >
				<input type='hidden' name="enc_loc_type" id="enc_loc_type" value="<%=enc_locn_type%>">
				<input type='hidden' name="enc_loc_code" id="enc_loc_code" value="<%=enc_locn_code%>">
	</form>
			<%
			}catch(Exception e)
			{
					e.printStackTrace();
			}
			finally
			{
				if(con != null)
					 ConnectionManager.returnConnection(con,request);

			}
			%>
		 </body>
	 </html>



