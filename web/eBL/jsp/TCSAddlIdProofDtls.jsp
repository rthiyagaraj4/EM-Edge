<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
  <%@ page import="eBL.Common.*,eBL.*,eCommon.Common.*,webbeans.eCommon.*,java.sql.*,java.util.*" %>
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%
String sStyle = (session.getAttribute("PREFERRED_STYLE") != null)|| (session.getAttribute("PREFERRED_STYLE") != "") ? (String) session.getAttribute("PREFERRED_STYLE") : "IeStyle.css"; 
		System.out.println("sStyle "+sStyle);	%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<Script src="../../eCommon/js/showModalDialog.js" language="JavaScript"></Script><script language='javascript' src='../../eBL/js/BillReceipt.js'></script>
<script language='javascript' src='../../eCommon/js/jquery.js'></script>
<script language='javascript' src='../../eCommon/js/common.js'></script>
</head>
<%
Connection con = null;
System.out.println("selType "+request.getParameter("selType"));
System.out.println("patientId "+request.getParameter("patientId"));
String patientId=request.getParameter("patientId");
String selType=request.getParameter("selType");
String isAlphNum="",altIdLenYN="",valAltIdLen="",idTyp="";
int altIdLen=0;

%>
<script>
$(document).ready(function(){
	 if($('#selType').val()=='S'){
		$('#altIDLbl').show();
		$('#altID').show();
		$('#altID').focus();
		$('#reEntLbl').show();
		$('#reEntAltID').show();
		$('#relLabel').hide();
		$('#relation').hide();
		$('#holderLbl').hide();
		$('#holdName').hide();
	}else if($('#selType').val()=='O'){
		$('#altIDLbl').show();
		$('#altID').show();
		$('#altID').focus();
		$('#reEntLbl').show();
		$('#reEntAltID').show();
		$('#relLabel').show();
		$('#relation').show();
		$('#holderLbl').show();
		$('#holdName').show();
	}else if($('#selType').val()=='F'){
		$('#altIDLbl').hide();
		$('#altID').hide();
		$('#reEntLbl').hide();
		$('#reEntAltID').hide();
		$('#relLabel').hide();
		$('#relation').hide();
		$('#holderLbl').hide();
		$('#holdName').hide();
	} 
});

</script>
<body onScroll="processScroll()" onKeyDown= "lockKey();"  >
	<form name='AddlTCSidProof' id='AddlTCSidProof'>
	<TABLE border='0' cellpadding='4' cellspacing='0' width='100%'>
		<tr>
			<td class='label' ><fmt:message key="eBL.Id.label" bundle="${bl_labels}"/><fmt:message key="Common.type.label" bundle="${common_labels}"/>
			</td>
			<%
				String lab_dept_section_code="";
				String settingHeader = null;
				Statement stmt = null; 
				ResultSet rs   = null;
				PreparedStatement pstmt		= null;
				try															    
				{  
					con	=	ConnectionManager.getConnection(request);
					try{
						String mpParamValid="select a.alt_id3_type,a.ALT_ID3_ACCEPT_ALPHANUMERIC_YN,a.ALT_ID3_ALPHANUM_VALIDATE_YN,a.ALT_ID3_LEN_VALIDATION_YN,NVL (a.alt_id3_length, 0) ALT_ID3_LENGTH,long_desc from mp_param a,mp_alternate_id_type where alt_id_type = a.alt_id3_type";
						stmt = con.createStatement();
						rs	 = stmt.executeQuery(mpParamValid);			
						if(rs != null){
							while(rs.next())
							{	
								idTyp=rs.getString("long_desc");
								if((rs.getString("ALT_ID3_ACCEPT_ALPHANUMERIC_YN").equals("Y")) && rs.getString("ALT_ID3_ALPHANUM_VALIDATE_YN").equals("Y")){
									isAlphNum="Y";
								}
							
							altIdLenYN=rs.getString("ALT_ID3_LEN_VALIDATION_YN")==null?"N":rs.getString("ALT_ID3_LEN_VALIDATION_YN");
							altIdLen=rs.getInt("ALT_ID3_LENGTH");
							
							if((altIdLen>0) && altIdLenYN.equals("Y")){
								valAltIdLen="Y";
							}
						}
					}
					System.out.println("isAlphNum "+isAlphNum);
					System.out.println("altIdLenYN "+altIdLenYN);
					System.out.println("altIdLen "+altIdLen);
					System.out.println("valAltIdLen "+valAltIdLen);
					
					stmt=null;
					rs=null;
				}catch(Exception e)
					{
						System.out.println("exception in TCSaddlIdproofdtls.jsp:altId3 data: "+e.toString());
						e.printStackTrace();
					}
					
				%>
			<td>
				<select id="IdType" name="IdType" id="IdType" >
					<option value='<%=idTyp%>'><fmt:message key="eBL.PanCard.label" bundle="${bl_labels}"/></option>
				</select>			
			</td>
			<td class='label' id='relLabel' name='relLabel'><fmt:message key="Common.relationship.label" bundle="${common_labels}"/>
			</td>
			<td> 
				<select id="relation" name="relation" id="relation" >
				<% try															    
					{  
						String relationQry = "SELECT long_desc, relationship_code FROM mp_relationship WHERE eff_status = 'E' ORDER BY long_desc";
						stmt = con.createStatement();
						rs	 = stmt.executeQuery(relationQry);			
						if(rs != null){
							while(rs.next())
							{	%>				 
								<option value='<%=rs.getString(2)%>' ><%=rs.getString(1)%></option> 
								<%
							}
						}
						%></select>&nbsp;<%
					}catch(Exception e1)
						{
							System.out.println("(TCSaddlIdproofdtls.jsp:relation Exception:) "+e1.toString());
							e1.printStackTrace();
						}
					
				%>
						
			</td>  
		</tr>
		<tr>
			<td class='label' id='altIDLbl' name='altIDLbl'><fmt:message key="eBL.altId.label" bundle="${bl_labels}"/>
			</td>
			<td >
				<input type='password'  autocomplete='off' id='altID' name='altID' id='altID' value='' size='20'  style="text-align: left;"  >
			</td> 
			<td class='label' id='reEntLbl' name='reEntLbl'><fmt:message key="eBL.reEnter.label" bundle="${bl_labels}"/><fmt:message key="eBL.altId.label" bundle="${bl_labels}"/>
			</td>
			<td>
				<input type='text' name='reEntAltID' id='reEntAltID' id='reEntAltID' value='' size='20'  style="text-align: left;"  >
			</td>
		</tr>
		<tr> 
			<td class='label' id='holderLbl' name='holderLbl'><fmt:message key="eBL.holderName.label" bundle="${bl_labels}"/>
			</td>
			<td class='fields'  style="text-align: left;" colspan='3'>
				<input type='text' id='holdName' name='holdName' id='holdName' value='' size='40'  style="text-align: right;"  >
			</td>
		</tr>
		<br>
		<tr>
			<td colspan='3' style="text-align: right;" class='label'>
				<input type='button' class='button' onclick='updTcsDtls()' name='continue' id='continue' value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Continue.label","common_labels")%>" >
			</td>
			<td  class='label'>
				<input type='button' class='button' onclick='parent.window.returnValue="N";window.close()' name='cancel' id='cancel' value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")%>" >
			</td>
		</tr>
		<%
		}catch(Exception ex)
		{
			System.out.println("exception in TCSaddlIdproofdtls.jsp:: "+ex.toString());
			ex.printStackTrace();
		}
		finally{
			if(stmt!=null)
				stmt.close();
			if(rs!=null)
				rs.close();
			ConnectionManager.returnConnection(con, request);
		} 
		%>
	</TABLE>
	<input type="hidden" name='patientId' id='patientId' id='patientId' value='<%=patientId%>'>
	<input type="hidden" name='selType' id='selType' id='selType' value='<%=selType%>'>
	<input type="hidden" name='isAlphNum' id='isAlphNum' id='isAlphNum' value='<%=isAlphNum%>'>
	<input type="hidden" name='valAltIdLen' id='valAltIdLen' id='valAltIdLen' value='<%=valAltIdLen%>'>
	<input type="hidden" name='altIdLen' id='altIdLen' id='altIdLen' value='<%=altIdLen%>'>
	<input type="hidden" name="reEnt" id="reEnt" id="reEnt" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eBL.reEnter.label","bl_labels")%>" >

</body>
</html>

