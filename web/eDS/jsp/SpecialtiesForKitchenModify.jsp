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
<script language='javascript' src='../../eDS/js/SpecialtiesForKitchen.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onload="parent.parent.commontoolbarFrame.document.forms[0].apply.disabled=false;" OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<%   Connection con = null;
	ResultSet rst = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	PreparedStatement stmt = null;
	int maxRecord = 0;
	int start = 0 ;
    int end = 0 ;
    int i=1;
    int maxnum = 0;
	  String dietType = "";
      String facility_id = (String) session.getValue("facility_id");
	  String kitchenCode = request.getParameter("kitchen_code");
	  String from = request.getParameter( "from" ) ;
	  String to = request.getParameter( "to" ) ;
	  String mode = "";%>
		<br>
		<fmt:setLocale value="<%=locale %>"/>
		<fmt:setBundle basename="eOT.resources.Labels" var="ot_labels"/>
		<fmt:setBundle basename="eCommon.resources.Labels" var="common_labels"/>
		<form name="specialityList_form" id="specialityList_form"  onload='FocusFirstElement()'  action="../../servlet/eDS.SpecialtiesForKitchenServlet" method="post" target="messageFrame">
		<P>
			<table align='right'>
			<tr>
			<td>
			<%
			try{
// 				String strsql = "select count(*) as total from Ds_Speciality_Kitchen_Vw where operating_Facility_Id = ? and  nvl(kitchen_Code,'!!') in(?,'!!')";
				String strsql = "select count(*) as total from Ds_Speciality_Kitchen_Vw where nvl(kitchen_Code,'!!') in(?,'!!') and (operating_Facility_Id='"+facility_id+"' or operating_Facility_Id is null)";
				con = ConnectionManager.getConnection(request);
				stmt = con.prepareStatement(strsql);
				/* stmt.setString(1, facility_id);
				stmt.setString(2, kitchenCode); */
				stmt.setString(1, kitchenCode);				
				rs = stmt.executeQuery();
				System.out.println("strsql"+strsql);
				
				rs.next();
				
				maxRecord = rs.getInt("total");
				
				if(maxRecord == 0){
					out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));</script>");
				}

			    if ( from == null )
			        start = 1 ;
			    else
			        start = Integer.parseInt( from ) ;

			    if ( to == null )
			        end = 14 ;
			    else
			        end = Integer.parseInt( to ) ;

			    if(end>maxnum){
			    	maxnum=end;
			    }
			    if(maxRecord > 0){
					if ( !(start <= 1) )
						out.println("<A HREF='../../eDS/jsp/SpecialtiesForKitchenModify.jsp?from="+(start-14)+"&capture=yes&kitchen_code="+kitchenCode+"&to="+(end-14)+ "'" + " text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

					if ( !( (start+14) > maxRecord ) )
						out.println("<A HREF='../../eDS/jsp/SpecialtiesForKitchenModify.jsp?from="+(start+14)+"&capture=yes&kitchen_code="+kitchenCode+"&to="+(end+14)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
				}
			}
			catch(Exception e){
				System.err.println("Exception->"+e);
			}
			finally{
				try{
					if(stmt!=null)	stmt.close();
					if(rs!=null)	rs.close();
					ConnectionManager.returnConnection(con,request);
				}
				catch(Exception e){
					System.err.println(e);
				}
			}
			%>
			</td>
			</tr>
			</table>
			<br><br>
		</p>
		<table border='1' cellpadding='2' cellspacing='0' width='75%' align='center'>

			<tr>

							<th align="center" width="50%">
								<fmt:message key="Common.speciality.label" bundle="${common_labels}"/>
								</th>
							<th align="center">
								<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>
							</th>

			</tr>

			<% 	try{

// 					String strsql1 = "select speciality_Code,short_Desc,linked_Yn from Ds_Speciality_Kitchen_Vw where operating_Facility_Id = ? and  nvl(kitchen_Code,'!!') in(?,'!!')";
					String strsql1 = "select speciality_Code,speciality_desc,linked_Yn from Ds_Speciality_Kitchen_Vw where nvl(kitchen_Code,'!!') in(?,'!!') and (operating_Facility_Id='"+facility_id+"' or operating_Facility_Id is null) order by linked_Yn desc,2";
					System.out.println("strsql1"+strsql1);

					con = ConnectionManager.getConnection(request);

					//kitchenCode = "K001";
					pstmt=con.prepareStatement(strsql1);
					/* pstmt.setString(1, facility_id);
					pstmt.setString(2, kitchenCode); */
					pstmt.setString(1, kitchenCode);
					rst = pstmt.executeQuery();
					  if ( start != 1 )
						     for( int j=1; j<start; i++,j++ )
						    	 rst.next() ;
							String classValue= " ";
						      while ( rst.next() && i<=end  )
							{
						    	if ( i % 2 == 0 )
						            classValue = "gridData" ;
						                else
						            classValue = "gridData" ;

						    %>
					<tr>
					<%int incrVal = i;%>

					<td id="speclDesc<%=incrVal%>"><%=rst.getString("speciality_desc") %></td>
					<%if("Y".equals(rst.getString("linked_yn"))){ %>
<%-- 					<td><input id="chk<%=incrVal%>" type="checkbox" checked="checked" onclick="removeSpeciality('<%=rst.getString("speciality_Code")%>')"></td> --%>
						<td><input id="chk_<%=rst.getString("speciality_Code")%>" type="checkbox" checked="checked" onclick="addRemoveSpeciality(this,'<%=rst.getString("speciality_Code")%>')"></td>
					<%}
					else{%>
<%-- 					<td><input id="chk<%=incrVal%>" type="checkbox" onclick="selectSpeciality('<%=rst.getString("speciality_Code")%>')"></td> --%>
						<td><input id="chk_<%=rst.getString("speciality_Code")%>" type="checkbox" onclick="addRemoveSpeciality(this,'<%=rst.getString("speciality_Code")%>')"></td>
					<input type="hidden" name="Hid_chk_<%=rst.getString(" id="Hid_chk_<%=rst.getString("speciality_Code")%>" value=""/>
					<%}
						i++;%>
					</tr>
				<%}
				}catch(Exception e){
					out.println("Exception in SpecialtiesForKitchenModify.jsp "+e);
				}
				finally{
					try{
						if(pstmt!=null)	pstmt.close();
						if(rst!=null)	rst.close();
						ConnectionManager.returnConnection(con,request);
					}
					catch(Exception e){
						System.err.println(e);
					}
				}
				%>

			</table>
			<input type='hidden' name='locale' id='locale' value="<%=locale%>">
			<input type='hidden' name='mode' id='mode' value='<%=mode%>'>
			<input type='hidden' name=selectedWards id=selectedWards value='<%=dietType%>'>
			
			<script>
				var selectedSpecialties = parent.SpecialtiesForKitchenList.document.getElementById('selectedSpecialties').value;
				var selectedSpecialties_Arr=selectedSpecialties.split(',');
				
				var removedSpecialties = parent.SpecialtiesForKitchenList.document.getElementById('removedSpecialties').value;
				var removedSpecialties_Arr=removedSpecialties.split(',');				
				
				for(var i=0;i<selectedSpecialties_Arr.length;i++) {
					var specialityCode=selectedSpecialties_Arr[i];
					
					if(document.getElementById("chk_"+specialityCode)) {
						document.getElementById("chk_"+specialityCode).checked=true;
					}
				}
				
				for(var i=0;i<removedSpecialties_Arr.length;i++) {
					var specialityCode=removedSpecialties_Arr[i];
					
					if(document.getElementById("chk_"+specialityCode)) {
						document.getElementById("chk_"+specialityCode).checked=false;
					}
				}
				
			</script>
		</form>
	</body>
</html>


