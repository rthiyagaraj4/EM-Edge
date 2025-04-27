<!DOCTYPE html>
<!-- Created for ML-MMOH-CRF-0419 -->

<%@page import="eDS.Common.DlQuery"%>
<%@  page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager" %>
<%@  page contentType="text/html;charset=UTF-8" %>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ include file="../../eOT/jsp/StringUtil.jsp" %>
<html>
<head>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/CommonLookup.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script language='javascript' src='../../eDS/js/DietRequestLocation.js'></script>
<script language='javascript' src='../../eDS/js/DSCommon.js'></script>
<script language='javascript' src='../../eDS/js/jquery-latest.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onload="parent.commontoolbarFrame.document.forms[0].apply.disabled=false;" OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<% 
   String dietLocationCode = "";
   String shortDesc = "";
   String longDesc = "";
   String enabledYn = "";
   String locationCode = request.getParameter("dietLocationCode");
   String disabled_flag = "";
   String readOnlyFlag = "";
   String default_location = "";//ML-MMOH-CRF-0419-US8
   int default_Count=0;//Added against ML-MMOH-CRF-0419-US8
   String temp_location="";//Added against ML-MMOH-CRF-0419-US8
   Connection con = null;
   ResultSet rst = null;
   PreparedStatement pstmt = null;
//Added against ML-MMOH-CRF-0419-US8 starts Here
        try {		
		/*String sql="SELECT count(*) FROM ds_diet_request_loc_lang_vw WHERE language_id = 'en' and  eff_status = 'E' and DEFAULT_DIET_REQUEST_LOCATION='Y' ";*/
		//Added against CRF-0419 US8
		
		String sql="SELECT c.coun,a.Location_Code  from ds_diet_request_loc_lang_vw a ,(select count(*) coun FROM ds_diet_request_loc_lang_vw b WHERE b.language_id = 'en' and  b.eff_status = 'E' and b.DEFAULT_DIET_REQUEST_LOCATION='Y') c WHERE a.language_id = 'en' and  a.eff_status = 'E' and a.DEFAULT_DIET_REQUEST_LOCATION='Y'";//Added against CRF-0419 US8
			con = ConnectionManager.getConnection(request);
			pstmt=con.prepareStatement(sql);
			 rst=pstmt.executeQuery();
			 while (rst.next())
			 {			 
                        	 default_Count = rst.getInt(1);	
				 temp_location = rst.getString(2);				 
             		 }							 
   		}
   		catch(Exception e){
	   		System.err.println("Error in DietRequestLocationCode->"+e);
			e.printStackTrace();
   		}
   //Added against ML-MMOH-CRF-0419-US8 Ends Here
   String mode = request.getParameter("mode");
   if("modify".equals(mode)){
   		try{
   			disabled_flag = "disabled";
   			readOnlyFlag = "readonly";
	   		con = ConnectionManager.getConnection(request);
	   		pstmt = con.prepareStatement(DlQuery.DL_GET_DIET_REQUEST_LOCATION_CODE);
	   		pstmt.setString(1,locationCode);
	   		rst = pstmt.executeQuery();
	   		while(rst.next()){
	   			dietLocationCode = rst.getString("location_code");
	   			longDesc = rst.getString("long_desc");
	   			shortDesc = rst.getString("short_desc");
	   			enabledYn = rst.getString("eff_status");
				default_location = rst.getString("default_diet_request_location");
	   		}
   		}
   		catch(Exception e){
	   		System.err.println("Error in DietRequestLocationCode->"+e);
			e.printStackTrace();
   		}
   		finally{
   			try{
				if(pstmt!=null) pstmt.close();
				if(rst!=null) rst.close();
				ConnectionManager.returnConnection(con);
			}
			catch(Exception e){
				System.err.println("Exception in DietRequestLocationCode:"+e);
				e.printStackTrace();
			}
   		}
   }
%>
		<br>
		<form name="dietlocationcode_form" id="dietlocationcode_form"  onload='FocusFirstElement()'  action="../../servlet/eDS.DietRequestLocationServlet" method="post" target="messageFrame">
			<table border='0' cellpadding='2' cellspacing='0' width='75%' align='center'>
			<!-- Location Code for Staff -->
				<tr>
					<td class='label' align="right">
						<fmt:message key="eDS.LocationCode.Label" bundle="${ds_labels}"/>
						</td>
					<td>
						<input type="text" name="dietLocationCode" id="dietLocationCode" value="<%=dietLocationCode %>" onkeypress="restrictSpecialChars(event)" size="4" maxlength="4" onkeyup="setFieldToUpperCase(this)"  onkeypress="return checkAlpha(event)" <%=disabled_flag %>/>
						<img src='../../eCommon/images/mandatory.gif'></img>
					</td>
				</tr>
				<!-- Long Description for Staff -->
				<tr>
					<td class='label' align="right">
						<fmt:message key="eOT.LongDescription.Label" bundle="${ot_labels}"/>
					</td>
					<td>
						<input type="text" name="longDesc" id="longDesc" value="<%=longDesc %>"  onkeypress="restrictSpecialChars(event)" size="30" maxlength="30" />
						<img src='../../eCommon/images/mandatory.gif'></img>
					</td>
				</tr>
				<tr>
					<td align="right" class='label'>
						<fmt:message key="eOT.ShortDescription.Label" bundle="${ot_labels}"/>
					</td>
					<td>
						<input type="text" name="shortDesc" id="shortDesc" value="<%=shortDesc %>" onkeypress="restrictSpecialChars(event)" size="15" maxlength="15" />
						<img src='../../eCommon/images/mandatory.gif'></img>
					</td>
				</tr>
				
				<!-- Default Diet Request Location for Staff -->
				<tr>
					<td align="right" class='label'>
						<fmt:message key="eDS.DefaultDietRequestLocation.Label" bundle="${ds_labels}"/>
					</td>
					<td>
						<%if("modify".equals(mode)){
							if("Y".equals(default_location)){ %>
								<input type="checkbox" name="defaultlocation" id="defaultlocation"   id="defaultlocation" checked="checked" onClick="defaultCheck()"/>
							<%}
							else{%>
								<input type="checkbox" name="defaultlocation" id="defaultlocation"  id="defaultlocation" onClick="defaultCheck()"/>
							<%}
						}
						else{ %>
							<input type="checkbox" name="defaultlocation" id="defaultlocation"  id="defaultlocation" onClick="defaultCheck()"/>
						<%} %>
					</td>
				</tr>

               <!-- Nature for Staff -->
				<tr>
					<td align="right" class='label'>
						<fmt:message key="eOT.Enabled.Label" bundle="${ot_labels}"/>
					</td>
					<td>
						<%if("modify".equals(mode)){
							if("E".equals(enabledYn)){ %>
								<input type="checkbox" name="enabledYn" id="enabledYn" id="enabledYn" checked="checked" onClick="enableCheck()"/>
							<%}
							else{%>
								<input type="checkbox" name="enabledYn" id="enabledYn" id="enabledYn" onClick="enableCheck()"/>
							<%}
						}
						else{ %>
							<input type="checkbox" name="enabledYn" id="enabledYn"  id="enabledYn" checked="checked" onClick="enableCheck()"/>
						<%} %>
					</td>
				</tr>
				<tr>
			</tr>
			</table>
			<input type='hidden' name='locale' id='locale' value="<%=locale%>">
			<input type='hidden' name='mode' id='mode' value='<%=mode%>'>
			<input type='hidden' name='updDietLocationCode' id='updDietLocationCode' value='<%=dietLocationCode%>'>
			<input type='hidden' name='default_Count' id='default_Count' value='<%=default_Count%>'><!--Added against ML-MMOH-CRF-0419-US8 starts Here-->
			<input type='hidden' name='temp_location' id='temp_location' value='<%=temp_location%>'><!--Added against ML-MMOH-CRF-0419-US8 starts Here-->
			
		</form>
	</body>
</html>
 

