<!DOCTYPE html>
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
<script language='javascript' src='../../eDS/js/TextureOfDiet.js'></script>
<script language='javascript' src='../../eDS/js/DSCommon.js'></script>
<script language='javascript' src='../../eDS/js/jquery-latest.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<!-- 059916 -->


</head>
<body onload="parent.commontoolbarFrame.document.forms[0].apply.disabled=false;" OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<% String textureofdiet = "";
   //String mealType = "";
   String shortDesc = "";
   String longDesc = "";
   String enabledYn = "";
   String textureDietCode = request.getParameter("textureofdiet");
   String disabled_flag = "";
   String readOnlyFlag = "";

   Connection con = null;
   ResultSet rst = null;
   PreparedStatement pstmt = null;

   String mode = request.getParameter("mode");
   if("modify".equals(mode)){
   		try{
   			disabled_flag = "disabled";
   			readOnlyFlag = "readonly";
	   		con = ConnectionManager.getConnection(request);
	   		pstmt = con.prepareStatement(DlQuery.DL_GET_TEXTURE_OF_DIET);
	   		pstmt.setString(1,textureDietCode);
	   		rst = pstmt.executeQuery();
	   		while(rst.next()){
	   			textureofdiet = rst.getString("TEXTURE_OF_DIET");
	   			longDesc = rst.getString("long_desc");
	   			shortDesc = rst.getString("short_desc");
	   			enabledYn = rst.getString("eff_status");
	   		}
   		}
   		catch(Exception e){
	   		System.err.println("Error in Texture of Diet->"+e);
   		}
   		finally{
   			try{
				if(pstmt!=null) pstmt.close();
				if(rst!=null) rst.close();
				ConnectionManager.returnConnection(con);
			}
			catch(Exception e){
				System.err.println("Exception in Texture of Diet:"+e);
			}
   		}
   }
%>
		<br>
		<fmt:setLocale value="<%=locale %>"/>
		<fmt:setBundle basename="eDS.resources.Labels" var="ds_labels"/>
		<fmt:setBundle basename="eOT.resources.Labels" var="ot_labels"/>
		<form name="TextureOfDiet_form" id="TextureOfDiet_form"  onload='FocusFirstElement()'  action="../../servlet/eDS.TextureOfDietServlet" method="post" target="messageFrame">
			<table border='0' cellpadding='2' cellspacing='0' width='75%' align='center'>
				<tr>
					<td class='label' align="right">
						<fmt:message key="eDS.TextureOfDiet.Label" bundle="${ds_labels}"/>
					</td>
					<td>
						<input type="text" name="textureofdiet" id="textureofdiet" id="textureofdiet" value="<%=textureofdiet%>" onkeypress="restrictSpecialChars(event)" size="4" maxlength="4" onBlur="setFieldToUpperCase(this)"  onkeypress="return checkAlpha(event)" <%=disabled_flag %>/>
						<img src='../../eCommon/images/mandatory.gif'></img>
					</td>
				</tr>
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

				<tr>
					<td align="right" class='label'>
						<fmt:message key="eOT.Enabled.Label" bundle="${ot_labels}"/>
					</td>
					<td>
						<%if("modify".equals(mode)){
							if("E".equals(enabledYn)){ %>
								<input type="checkbox" name="enabledYn" id="enabledYn"  checked="checked"/>
							<%}
							else{%>
								<input type="checkbox" name="enabledYn" id="enabledYn"/>
							<%}
						}
						else{ %>
							<input type="checkbox" name="enabledYn" id="enabledYn"  checked="checked"/>
						<%} %>
					</td>
				</tr>
				<tr>
			</tr>
			</table>
			<input type='hidden' name='locale' id='locale' value="<%=locale%>">
			<input type='hidden' name='mode' id='mode' value="<%=mode%>">
			<input type='hidden' name='updtextureofdiet' id='updtextureofdiet' value="<%=textureofdiet%>">
		</form>
	</body>
</html>

<!-- 59956 -->
<script>
$('body').bind('paste',function(e) {
    e.preventDefault(); return false; 
});
</script>
<!-- 59956 -->

