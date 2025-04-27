<!DOCTYPE html>
<!--/**** Master for entering the Unit of Measure ******/-->
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%request.setCharacterEncoding("UTF-8");%>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page import="java.sql.*, java.util.*, java.text.*, eCommon.XSSRequestWrapper, webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>

<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>

<script src='../js/EquivalentUOM.js' language='javascript'></script>

<script>

function chkvalid()
{
	var uomselect = EquivalentUOM_form.uom.value;
	var equomselect = EquivalentUOM_form.Equom.value;
	if(uomselect == equomselect)
	alert(getMessage("SAME_UOM_NOT_SEL","AM"));

}
function valid_dat(Obj)
{
	SPCheckPositiveNumber(Obj)
    if(parseFloat(Obj.value)==0)
	{
		alert(getMessage("INVALID_POSITIVE_NUMBER",'Common'));
		//Obj.select();
		//Obj.focus();
		Obj.value="";
		Obj.focus();
	}
}
 </script>


</head>

<body onKeyDown = 'lockKey()' onLoad = 'FocusFirstElement();' OnMouseDown='CodeArrest()'>

 <%
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	Connection conn = null;
	Statement stmt         =null;
	PreparedStatement pstmt = null;
	ResultSet rs		          = null;
	ResultSet rset=null;
	 
    String facilityId = (String)session.getValue("facility_id");
	if(facilityId == null) facilityId="";
	 	
	String conversion="";
	String Code="";     
	String shortdesc="";
	String equshortdesc="";
	boolean newSpeciality=false;
	String sql="";
	//Hashtable tab=new Hashtable();
	String EqCode="";

%>
<%
	Code=request.getParameter("Code");
	EqCode = request.getParameter("EqCode");
	if (Code==null) Code="";
	if(EqCode==null)EqCode="";
	try{
	
	 conn = ConnectionManager.getConnection(request);
	 stmt = conn.createStatement();
				
	
%>

<form name='EquivalentUOM_form' id='EquivalentUOM_form' action='../../servlet/eAM.UOMEquivServlet' method='post' target='messageFrame'>
<div>

<br><br><br><br><br><br><br><br><br>

<table border='0' cellpadding='0' cellspacing='0' width='75%' align='center'>
<tr>
		<td width='10%'>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td width='10%'>&nbsp;</td>
</tr>
<tr>
		
	
<%	
	if(Code.equals(""))
	 {	
		Code="";    
		shortdesc="";
	
%>
		<td>&nbsp;</td>
		<td class='label'><fmt:message key="Common.uom.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
		<td class='fields'>&nbsp;&nbsp;<select name="uom" id="uom">
		<option value="" selected>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
		<%
		try{
			sql="SELECT UOM_CODE,SHORT_DESC from AM_UOM where eff_status='E' Order By SHORT_DESC";
			rset = stmt.executeQuery(sql);
			if(rset!=null)
			{
				while(rset.next())
				{
					Code=rset.getString("UOM_CODE");
					shortdesc=rset.getString("SHORT_DESC");
					
					%>
					<option value="<%=Code%>"><%=shortdesc%>
				<%
				}
			}
			
	     }catch(Exception e){e.printStackTrace();}
          finally
		 {
		  if(rset!=null)rset.close();
		  
		 }
	 
	
%>
	</select>
		<img src='../../eCommon/images/mandatory.gif' align='center'></img></td>
		<td>&nbsp;</td>
</tr>
<tr>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
</tr>
<tr>
		 <td>&nbsp;</td>
		<td   class=label><fmt:message key="Common.EquivalentUOM.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
		<td  class='fields'>&nbsp;&nbsp;<select name="Equom" id="Equom" onChange='chkvalid()'>
		<option value="">--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---
			<%
	
		try{
		String sql2="SELECT UOM_CODE,SHORT_DESC from AM_UOM where eff_status='E' Order By SHORT_DESC";

			rset = stmt.executeQuery(sql2);
			if(rset!=null)
			{
				while(rset.next())
				{
					Code=rset.getString("UOM_CODE");
					shortdesc=rset.getString("SHORT_DESC");
				
				%>
					<option value="<%=Code%>"><%=shortdesc%>
				<%
				}
			}
		
	     }catch(Exception e){e.printStackTrace();}
          finally
		 {
		 if(rset!=null)rset.close();
		 }

	
%></select>
		<img src='../../eCommon/images/mandatory.gif'align='center'></img></td>

		<td>&nbsp;</td>
</tr>
<tr>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
</tr>
<tr>
			<td>&nbsp;</td>
			
	<%
	// Modified by Himanshu Saxena for ML-MMOH-CRF-1669 on 14-06-2023(Size from 6 to 12 and size='15' maxlength='15') allowValidNumber(this,event,6,5)fillDecimal(this,6,5) Insert Case Started-->
	%>
			
			<td  class=label><fmt:message key="Common.ConversionFactor.label" bundle="${common_labels}"/></td>
			<td  class='fields'>&nbsp;&nbsp;<input type='text' name='conversion' id='conversion' size='18' maxlength='18' value="<%=conversion%>" style='text-align:right' onblur="allowValidNumber(this,event,12,5);return valid_dat(this),fillDecimal(this,12,5);" onKeyPress='return allowValidNumber(this,event,12,5);'>&nbsp;<img src='../../eCommon/images/mandatory.gif'align='center'></img>
			</td>

			<td>&nbsp;</td>
			</tr>
			<tr>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
</tr><%
				newSpeciality=true;
		}
	else
	{
		 try
		 {
				sql =  "SELECT A.UOM_CODE,A.EQVL_UOM_CODE, B.SHORT_DESC UOM_DESC, C.SHORT_DESC EQVL_UOM_DESC, A.EQVL_VALUE from AM_UOM_EQVL A, AM_UOM B, AM_UOM C where A.UOM_CODE = B.UOM_CODE AND A.EQVL_UOM_CODE = C.UOM_CODE AND A.UOM_CODE=? and A.EQVL_UOM_CODE=? Order By UOM_DESC" ;
			
				pstmt   = conn.prepareStatement(sql);
				pstmt.setString	(	1,	Code		);
				pstmt.setString	(	2,	EqCode		);

				rset		 = pstmt.executeQuery();

				if (rset.next()) {
				 Code=rset.getString("UOM_CODE");
				 shortdesc=rset.getString("UOM_DESC");
				 EqCode=rset.getString("EQVL_UOM_CODE");
				 equshortdesc=rset.getString("EQVL_UOM_DESC");
				 conversion= rset.getString("EQVL_VALUE");	  
				 newSpeciality=false;
			    }		
			}catch(Exception e){e.printStackTrace();}
	         				
	  
		%>
		<td>&nbsp;</td>
		<td class='label'><fmt:message key="Common.uom.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
		<td class='fields'>&nbsp;&nbsp;<input type="text" name="uom_desc" id="uom_desc" value="<%=shortdesc%>" size="15" maxlength="15" readonly>
		<input type = 'hidden' name='uom' id='uom' value="<%=Code%>">
		<img src='../../eCommon/images/mandatory.gif' align='center'></img></td>
		<td>&nbsp;</td>
</tr>
<tr>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
</tr>
<tr>
		 <td>&nbsp;</td>
		<td class=label><fmt:message key="Common.EquivalentUOM.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
		<td  class='fields'>&nbsp;&nbsp;<input type="text" name="Equom_desc" id="Equom_desc" value="<%=equshortdesc%>" size="15" maxlength="15" readonly><input type='hidden' name='Equom' id='Equom' value="<%=EqCode%>">
		<img src='../../eCommon/images/mandatory.gif'align='center'></img></td>

		<td>&nbsp;</td>
</tr>
<tr>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
</tr>
<tr>
			<td>&nbsp;</td>

	<%
	// Modified by Himanshu Saxena for ML-MMOH-CRF-1669 on 14-06-2023(Size from 6 to 12 and size='15' maxlength='15') allowValidNumber(this,event,6,5)fillDecimal(this,6,5) Insert Case Started-->
	%>
			<td  class=label><fmt:message key="Common.ConversionFactor.label" bundle="${common_labels}"/></td>
			<td  class='fields'>&nbsp;&nbsp;<input type='text' name='conversion' id='conversion' size='18' maxlength='18' value="<%=conversion%>" style='text-align:right' onblur="allowValidNumber(this,event,12,5);return valid_dat(this),fillDecimal(this,12,5);" onKeyPress='return allowValidNumber(this,event,12,5)'>&nbsp;<img src='../../eCommon/images/mandatory.gif'align='center'></img>
			</td>

			<td>&nbsp;</td>
			</tr>
			<tr>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
</tr><%}%>
			
	</table>




</div>
<%
	if(newSpeciality)
	{
%>
		<input type='hidden' name='function1' id='function1' value='insert'>
		<input type='hidden' name='function_name' id='function_name' value='insert'>

<%  }
  	else
	{
%>
		<input type='hidden' name='function1' id='function1' value='modify'>
		<input type='hidden' name='function_name' id='function_name' value='modify'>
<%
	}


		if(rset!=null)    	rset.close();
		if(rs!=null)    	rs.close();
	   	if(stmt!=null)  	stmt.close();
	   	if(pstmt!=null)  	pstmt.close();
}
catch(Exception e) {e.printStackTrace();}
finally{
	
	ConnectionManager.returnConnection(conn,request);
}
%>


</form>
</body>
</html>

