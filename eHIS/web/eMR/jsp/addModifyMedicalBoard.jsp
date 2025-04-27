<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*"  contentType="text/html;charset=UTF-8" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
     <head>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	
	<script language='javascript' src='../js/MRMaster.js'></script>
	<script>
	
	function medBoard_change() 
	{
	
	 if (MedicalBoardFrm.eff_status.checked == true)
		MedicalBoardFrm.eff_status.value="E";
	 else
		MedicalBoardFrm.eff_status.value="D";
	}

	</script>
	</head>
	<body OnMouseDown='CodeArrest()' onload='FocusFirstElement()' onKeyDown = 'lockKey()'>
<%
   request.setCharacterEncoding("UTF-8"); 
   String med_board_code="";
   String med_board_type_code="";
   String longdesc="";
   String shortdesc="";
   String effstatus="";
   String codeTextAttribute="";
   String otherTextAttribute="";
   String checkBoxAttribute="";
   String dis_chk = "";
   String eventFunctionForCase="";
   boolean status = false;
   StringBuffer sql = new StringBuffer();
//   String def_med_board_code	="";
   Connection conn=null;
   PreparedStatement stmt=null;
   ResultSet rset=null;

try
{
	conn=ConnectionManager.getConnection(request);

	med_board_code=request.getParameter("MED_BOARD_CODE")==null?"":request.getParameter("MED_BOARD_CODE");
		
	if(med_board_code==null || med_board_code.equals("")){
		med_board_code="";
		longdesc="";
		shortdesc="";
		effstatus="E";
		codeTextAttribute="";
		otherTextAttribute="";
		checkBoxAttribute="CHECKED";
		status=true;
		eventFunctionForCase="OnBlur='ChangeUpperCase(this)'";
	}
	else 	if(!med_board_code.equals(""))
	{
	
	 try{

			sql.append("select medical_board_code,med_board_type_code,long_desc,short_desc,eff_status from mr_medical_board where medical_board_code=?");
			stmt = conn.prepareStatement(sql.toString());
			stmt.setString(1,med_board_code);
			rset = stmt.executeQuery();
			while(rset.next())
			 {
				med_board_code	=rset.getString("medical_board_code");
				med_board_type_code	=rset.getString("med_board_type_code");
				longdesc	=rset.getString("long_desc");
				shortdesc	=rset.getString("short_desc");
				effstatus	=rset.getString("eff_status");
			 }

		   	 if(rset!=null)   rset.close();
			 if(stmt!=null)  stmt.close();

			if(effstatus.equals("D")){
				otherTextAttribute="READONLY";
				checkBoxAttribute="";
				dis_chk = "disabled";
			}else{
				otherTextAttribute="";
				checkBoxAttribute="CHECKED";
				dis_chk = "";
			}

	     }
		 catch(Exception e){
			out.println("Exception @ addModifyMedicalBoard "+e.toString());
	     }
	     
			codeTextAttribute="READONLY";
			status=false;
			eventFunctionForCase="";
	}

%>

      	<form name='MedicalBoardFrm' id='MedicalBoardFrm' action='../../servlet/eMR.MedicalBoardServlet' method='post' target='messageFrame'>
      	<div align='left'>
      	<BR><BR><BR><BR><BR><BR><BR><BR><BR><br>
      	<table border='0' cellpadding='5' cellspacing='0' width='auto' align='center'>
      	
      		<tr>
      		    <td  width='50%' class='label'><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
      		    <td width='50%' class='fields'>
      		    <input type='text' name='medical_board_code' id='medical_board_code' value="<%=med_board_code%>" size='7' maxlength='4' onKeyPress="return CheckForSpecChars(event)"  <%=codeTextAttribute%> <%=eventFunctionForCase%>>
      		    <img src='../../eCommon/images/mandatory.gif'></img></td>
      		</tr>
      		
      		<tr>
      		    <td  class=label><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
      		    <td class='fields'>
      		    <input type='text' name='long_desc' id='long_desc' size='30' maxlength='30' value="<%=longdesc%>" <%=otherTextAttribute%>  onBlur="makeValidString(this);">
      		    <img src='../../eCommon/images/mandatory.gif'></img></td>
      		</tr>
      		
      		<tr>
     		    <td  class=label><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
		    <td class='fields'>
		    <input type='text' name='short_desc' id='short_desc' size='15' maxlength='15' value="<%=shortdesc%>" <%=otherTextAttribute%>  onBlur="makeValidString(this);">
		    <img src='../../eCommon/images/mandatory.gif'></img></td>
      		</tr>
				
			<tr>
				<td class=label><fmt:message key="eMR.MedicalBoardType.label" bundle="${mr_labels}"/></td>
			<td class='fields'><select name="medical_board_type_code" id="medical_board_type_code" <%=dis_chk%>>
			<option value="">--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</option>
			<%
				String sel="";
				String med_board_typecode=""; String med_board_typedesc ="";
				StringBuffer sql_med_board =new StringBuffer();
				sql_med_board.append(" select MED_BOARD_TYPE_CODE,SHORT_DESC from MR_MEDICAL_BOARD_TYPE where EFF_STATUS='E' ");
				stmt = conn.prepareStatement(sql_med_board.toString());
				rset = stmt.executeQuery();
				if(rset!=null )
				{
					while(rset.next())
					{
						med_board_typecode  = rset.getString("MED_BOARD_TYPE_CODE");
						med_board_typedesc = rset.getString("SHORT_DESC");
						
						if (med_board_typecode.equals(med_board_type_code))
							sel = "selected";
						else
							sel = "";
						out.print("<option value='"+med_board_typecode+"' "+sel+">"+med_board_typedesc+"");
					}
				if(rset!=null) rset.close();
				if(stmt!=null) stmt.close();
				}
		  %>
			</select>
			<img src="../../eCommon/images/mandatory.gif"></td>
			</tr>
			
      		<tr>
      		     <td class='label'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
      		     <td class='fields'>
      		     <input type='checkbox' name='eff_status' id='eff_status' value="<%=effstatus%>" <%=checkBoxAttribute%> onClick="medBoard_change()"></td>
      		</tr>
			
      	</table>
      	</div>
    <%  if(status){%>

      	<input type='hidden' name='function' id='function' value='insert'>
      	<input type='hidden' name='function_name' id='function_name' value='insert'>

      <%}else{%>

      	<input type='hidden' name='function' id='function' value='modify'>
      	<input type='hidden' name='function_name' id='function_name' value='modify'>
      	<input type='hidden' name='med_board_type_code1' id='med_board_type_code1' value=<%=med_board_type_code%>>

     <%}%>
     	</form>
      	</body>
      	</html>

<%
}catch(Exception e){
	out.println("Exception "+e.toString());

}
finally
{
	ConnectionManager.returnConnection(conn,request);
}
%>
<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

