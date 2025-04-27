<!DOCTYPE html>

<%@page import="java.sql.*, java.io.*, webbeans.eCommon.ConnectionManager" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
	<head>
<%
  request.setCharacterEncoding("UTF-8");
  String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		<script language="JavaScript" src ="../../eCA/js/SpecialtyParam.js"></script>
		<Script language ="JavaScript" src ='../../eCommon/js/common.js'></Script>
		<Script language ="JavaScript" src ='../../eCommon/js/ValidateControl.js'></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		</head>
	<body OnMouseDown="CodeArrest()"  onKeyDown="lockKey()">
	<form name="specialityParamaddmodifyForm" id="specialityParamaddmodifyForm"  method ='post' target='messageFrame' action='../../servlet/eCA.SpecialtyParamServlet'>
	<BR><BR>
<%
	  
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
//	String mode = "insert";
	String sql = "";
	String selCaSpltyParam = "";
	String disabled		=	"disabled";
	String contl_type	=	"";
	String noofdays		=	"";
	String contl_days		=	"";
//	String selected		=	"";
	String display		=	"display:none";

	try
	{ 

		con = ConnectionManager.getConnection(request);
		
		selCaSpltyParam="select contl_type,noofdays,contl_days from CA_SPLTY_PARAM" ;
		ps = con.prepareStatement(selCaSpltyParam);
		rs = ps.executeQuery();
		while(rs.next())
		{
			contl_type = rs.getString("contl_type")==null?"":rs.getString("contl_type");	
			noofdays = rs.getString("noofdays")==null?"":rs.getString("noofdays");	
			contl_days = rs.getString("contl_days")==null?"":rs.getString("contl_days");	
		}
		if(rs != null) rs.close();
		if(ps != null) ps.close();

		if(contl_type.equals("B"))
		{	
			display="display";
			
		}
		else
		{
			display="display:none";
		}
	
		sql = "select MODULE_ID,MODULE_NAME from SM_module where MODULE_GROUP_ID='SS' and MODULE_ID='MC' order by 2";
		ps = con.prepareStatement(sql);
		rs = ps.executeQuery();
		%>
<table border='0' cellspacing='0' cellpadding='3' width='100%' align='center'>
		
		<tr>
			<td class ='label' width='45%'><fmt:message key="Common.Module.label" bundle="${common_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<!-- <td class ='fields' width='50%' > -->
			<select name ="module"  maxlength='2' <%=disabled%>>
			<!--<option  value="">----------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----------</option>-->
				
<%
		while(rs.next())
		{

			/*if (moduleId.trim().equals(rs.getString(1).trim()))
				{
					out.println("<option value='"+rs.getString(1)+"' selected>"+rs.getString(2)+"</option>");		
				}
				else
				{*/
					out.println("<option value='"+rs.getString(1)+"'>"+rs.getString(2)+"</option>");	
					out.println("<input type=hidden name='module_id' id='module_id' value='"+rs.getString(1)+"'>");	
				//}
		}
		if(rs != null) rs.close();
		if(ps != null) ps.close();
%>			</select><img src="../../eCommon/images/mandatory.gif" align="center" >
			 </td> 
			 <td class ='fields' width='55%' >&nbsp; </td>

		</tr>
		<tr >
			<td class ='label' colspan="2" >
				<fmt:message key="eCA.RestrictModifyLMP.label" bundle="${ca_labels}"/>
					&nbsp;&nbsp;<input type="text" name="contl_days" id="contl_days" size="2" maxlength="1" value="<%=contl_days%>" onblur="defaultOne(this);" onKeyPress="return allowValidNumberLocal(this, event,1,0)">					<select name ="cntlType" >				
						<option  value="M"<% if(contl_type.equals("M")){%>selected<%}%>>
							<fmt:message key="Common.month.label" bundle="${common_labels}"/>(s)
						</option>			
						<option  value="E"<% if(contl_type.equals("E")){%>selected<%}%>>
							<fmt:message key="eCA.Encounters.label" bundle="${ca_labels}"/>
						</option>			
						<!-- <option  value="B"<% if(contl_type.equals("B")){%>selected<%}%>>
							<fmt:message key="eCA.Encounters.label" bundle="${ca_labels}"/>&nbsp;/&nbsp;<fmt:message key="Common.month.label" bundle="${common_labels}"/>
						</option> -->
					</select>&nbsp;&nbsp;				
					<!-- <label id="disptext" style="<%=display%>" ><fmt:message key="eCA.WhichEverIsLess.label" bundle="${ca_labels}"/> -->
				</td>
		</tr>
		<tr >
			<td class ='label' colspan='2' >
				<fmt:message key="eCA.CorrctdEDDNotExtendBeyond.label" bundle="${ca_labels}"/>&nbsp;&nbsp;<input type='text'  name='noofDays' id='noofDays' size='1' maxlength='3' onblur="defaultOne(this);" onKeyPress="return allowValidNumberLocal(this, event,1,0)" value='<%=noofdays%>' >&nbsp;&nbsp;<fmt:message key="eCA.DaysFromthecalculatedEDD.label" bundle="${ca_labels}"/>
			</td>
		</tr>
		</table>
<%
	}
	catch(Exception ee)
	{
		//out.println("Exception in SpecialtyEventAddModifyIntermediate Module "+ee.toString());//common-icn-0181
           ee.printStackTrace();//COMMON-ICN-0181
	}
	finally
	{
		try{
				if(con != null) 
			  {	
				ConnectionManager.returnConnection(con);
				con.close();
			  }
			}
		catch(Exception e){
		//	out.println(e);//COMMON-ICN-0181
			e.printStackTrace();//COMMON-ICN-0181
		}
	}

%>
	</form>
	</body>
</html>

