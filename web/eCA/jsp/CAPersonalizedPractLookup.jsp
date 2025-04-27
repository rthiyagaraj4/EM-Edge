
<!DOCTYPE html>

<%@page import="java.sql.*, java.io.*, webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
		
<%

request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String mode="";
mode = (request.getParameter("mode")==null?"":request.getParameter("mode"));
String pract_type = request.getParameter("pract_type");
String pract_id = request.getParameter("pract_id");

String qry_sub = "";
String desk_sub = "";
String sql="";
String sql1="";
String update="";
String practitioner_desc="All";
String practitioner_code="*ALL";
String desktop_desc="";
String desktop_code="";
String dis="";
String prac_type_desc="";
if(pract_type==null) 
{
	pract_type ="";
	mode="insert";
}
else
mode="modify";
if(mode.equals("modify"))
	update="disabled";

%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
		<script src="../../eCommon/js/common.js" language="javascript"></script>
		<script language=javascript src='../../eCommon/js/CommonLookup.js'></script>
		<script language=javascript src='../../eCA/js/CAPersonalizedHomePage.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</HEAD>
<BODY OnMouseDown="CodeArrest()"  onKeyDown="lockKey()" Onload='getValue();DesktopView()'>
<form name ="personalizedPractLookUpForm" target="messageFrame" method="post" action ="../../servlet/eCA.CAPersonalizedHomePageServlet">
<%
Connection con = null;	
PreparedStatement psn = null;
PreparedStatement ps = null;
PreparedStatement psd= null;
ResultSet rsn = null;
ResultSet rs = null;
ResultSet rsd = null;
con=ConnectionManager.getConnection(request);
if(!mode.equals("insert"))
{
	dis="readOnly";
}
		
if(mode.trim().equalsIgnoreCase("modify")) 
 {
	 //sql ="select pract_type,PRACTITIONER_ID,DESKTOP_SUMMARY_ID,am_get_desc.am_practitioner(PRACTITIONER_ID,'en',1) practitioner_desc from SM_PERSONALIZED_HOME_PAGE where pract_type='"+ pract_type + "' AND PRACTITIONER_ID='"+ pract_id + "'" ;//common-icn-0180
	 sql ="select pract_type,PRACTITIONER_ID,DESKTOP_SUMMARY_ID,am_get_desc.am_practitioner(PRACTITIONER_ID,'en',1) practitioner_desc from SM_PERSONALIZED_HOME_PAGE where pract_type=? AND PRACTITIONER_ID=?" ;//common-icn-0180
				
	 ps=con.prepareStatement(sql);
	 ps.setString(1, pract_type);//common-icn-0180
	 ps.setString(2, pract_id);//common-icn-0180
	 rs = ps.executeQuery();

	 if(rs.next())
	{
		pract_type=(rs.getString("pract_type")== null)? "":rs.getString("pract_type"); 
		qry_sub=(rs.getString("PRACTITIONER_ID")== null)? "":rs.getString("PRACTITIONER_ID");
		desk_sub=(rs.getString("DESKTOP_SUMMARY_ID")== null)? "":rs.getString("DESKTOP_SUMMARY_ID");
		practitioner_desc=(rs.getString("practitioner_desc")== null)? "":rs.getString("practitioner_desc");
		practitioner_code=qry_sub;
		if(practitioner_desc.equals(""))
		{
			practitioner_desc="All";
			practitioner_code="*ALL";
		}


	}
	
 }
try
{
	psn = con.prepareStatement("SELECT PRACT_TYPE, NVL (DESC_USERDEF, DESC_SYSDEF) PRACT_TYPE_DESC  FROM AM_PRACT_TYPE  WHERE EFF_STATUS = ? ORDER BY PRACT_TYPE_DESC");				
	 psn.setString(1,"E");
	 rsn = psn.executeQuery();
%>
<br><br><br><br>
	<table cellpadding='3' cellspacing='0' border='0' width='100%' align='center'>
				<tr>
				<td  class='label'><fmt:message key="Common.practitionertype.label" bundle="${common_labels}"/></td>
				<td   class='fields'><%if(!mode.equalsIgnoreCase("modify")){%>
				<SELECT name="pract_type" id="pract_type"  <%=dis%> OnChange = "default_value()">
					<option value ="">-------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------------</option><%}%>
<%
	while(rsn.next())
	 {
		if(mode.equalsIgnoreCase("modify"))
		 {
			if(pract_type.equals(rsn.getString("PRACT_TYPE")))
			 {
				prac_type_desc=rsn.getString("PRACT_TYPE_DESC");

				//out.println("\n<option value ="+rsn.getString("PRACT_TYPE")+" selected>"+rsn.getString("PRACT_TYPE_DESC")+"</option>");
			 }
		 }
		 else
		 {
			 out.println("\n<option value ="+rsn.getString("PRACT_TYPE")+" >"+rsn.getString("PRACT_TYPE_DESC")+"</option>");
		 }
	}
%>
<%if(!mode.equalsIgnoreCase("modify")){%>
			</SELECT>
			<%}else{%>
			<input type ="text" name ="pract1"  value='<%=prac_type_desc%>' readonly>
            <input type ="hidden" name ="pract_type"  value="<%=pract_type%>">
			<%}%><img src='../../eCommon/images/mandatory.gif'></img>
				</td>
	<td colspan=1></td>
		</tr>
		
		<tr>	
			<td  class='label'><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></td>
			<td  class='fields'>
				<input type ="text" name ="qry_sub"  <%=dis%> value='<%=practitioner_desc%>' OnBlur ="pass_value(this)" OnChange='setValue()'><%if(!mode.equalsIgnoreCase("modify"))
				{%><input type ="button" value="?" class ='button'  name = "look_up" OnClick ="getPractitionerName()"><%}%><input type ="hidden" name ="hid_sub"  value="<%=practitioner_code%>">
			</td>
		</tr>

			<tr>	
		
<%	if(mode.trim().equalsIgnoreCase("modify"))
	{
	  sql1 ="SELECT  DESKTOP_SUMMARY_NAME FROM SM_DESKTOP_SUM_HDR WHERE DESKTOP_SUMMARY_TYPE	='C' AND EFF_STATUS='E' and DESKTOP_SUMMARY_ID=?";

			
	  psd=con.prepareStatement(sql1);
	  psd.setString(1,desk_sub);
	  rsd = psd.executeQuery();

	 if(rsd.next())
	 {
		desktop_desc=(rsd.getString("DESKTOP_SUMMARY_NAME")== null)? "":rsd.getString("DESKTOP_SUMMARY_NAME");
		desktop_code=desk_sub;
		if(desktop_desc.equals(""))
		{
			desktop_desc="";
			desktop_code="";
		}


	 }
  }
 %>

  	<td  class='label'><fmt:message key="eCA.Desktop.label" bundle="${ca_labels}"/></td>
			<td  class='fields'>
				<input type ="text" name ="desk_sub" value='<%=desktop_desc%>' OnBlur ="callfunction1()" OnChange='setValue1();DesktopView()'><input type ="button" value="?" class ='button'  name = "look_up1" OnClick ="callfunction1()">
				<input type ="hidden" name ="hid_sub1"  value='<%=desktop_code%>'><img src='../../eCommon/images/mandatory.gif'></img>
			</td>
			<td>
               <a class="gridLink" href='javascript:showText1()' ID='desk' style='visibility:hidden' ><fmt:message key="Common.ViewDetails.label" bundle="${common_labels}"/></a>
           </td>
		</tr>
		
	</table>

	<input type ="hidden" name ='flag' value='false'>
	<input type='hidden' name='mode' id='mode' value='<%=mode%>'>
	
<%
}
catch(Exception e){
		//out.println(e);//COMMON-ICN-0181
               e.printStackTrace();//COMMON-ICN-0181
		try
		{
			con.rollback();
		}
		catch(Exception ee)
		{
		//	out.println(ee);//COMMON-ICN-0181
                         ee.printStackTrace();//COMMON-ICN-0181
		}
}
finally
{
	try
	{
		if(rs != null) rs.close();
		if(ps != null) ps.close();
		if(rsn != null)		rsn.close();
		if(psn != null)		psn.close();
		if(rsd != null) rsd.close();
		if(psd != null) psd.close();		

	}
	catch(Exception exception)
	{
		//out.println(exception);//COMMON-ICN-0181
                exception.printStackTrace();//COMMON-ICN-0181
	}
	if(con!=null) ConnectionManager.returnConnection(con);
}
%>

</form>
</BODY>
</HTML>

