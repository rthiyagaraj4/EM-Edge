<!DOCTYPE html>
<%--
	FileName	: addModifyFacilitySection.jsp
	Version	    : 3	
	Modified On	: 21-2-2005
--%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*, java.util.*, java.text.* ,javax.servlet.*,javax.servlet.http.*,webbeans.eCommon.* "%>

<%
	request.setCharacterEncoding("UTF-8");
	Connection con  = null ;
	Statement stmt=null ;
	PreparedStatement pstmt = null;
	ResultSet rs =null;

	String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	

	String facilityid=(String)session.getValue("facility_id");

	String facilityId = request.getParameter("facilityId");
	if(facilityId == null || facilityId.equals("")) {  facilityId=facilityid; }
	
	Properties p=(Properties)session.getValue("jdbc");
    String uid=(String)p.getProperty("login_user");
%>

<html>
<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
	<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	<script>
		var sStyle='<%=sStyle%>';
		function change() 
		{
			 if (FaciltySection_form.eff_status.checked == true)
				FaciltySection_form.eff_status.value="E";
			 else
				FaciltySection_form.eff_status.value="D";
		 }

		function Pass2MsgFrm(num)
		{
			if(num=="facility")
			 {
				var n=parent.f_query_add_mod.document.getElementById("department").options.length;
				for(var i=0;i<n;i++)
				{
					parent.f_query_add_mod.document.getElementById("department").remove("department");
				}

				var HTMLVal = new String();
				HTMLVal = "<HTML><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></HEAD><BODY CLASS='MESSAGE' onKeyDown = 'lockKey()'><form name='form1' id='form1' method='post' action='../../eAM/jsp/GetVal.jsp?Chksrc="+num +"'><input name='Common_Text' id='Common_Text' type='hidden' value='"+document.getElementById("facility").value +"'></form></BODY></HTML>";

				parent.dummy.document.write(HTMLVal);
				parent.dummy.document.form1.submit();
			 }

			else if(num=="department")
			{
				var n=parent.f_query_add_mod.document.getElementById("section").options.length;
				for(var i=0;i<n;i++)
				{
					parent.f_query_add_mod.document.getElementById("section").remove("section");
				}


				var HTMLVal = new String();
				HTMLVal = "<HTML><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></HEAD><BODY CLASS='MESSAGE' onKeyDown = 'lockKey()'><form name='form1' id='form1' method='post' action='../../eAM/jsp/GetVal.jsp?Chksrc=" + num + "'><input name='Common_Text' id='Common_Text' type='hidden' value=' "+document.getElementById("facility").value + "'><input name='Common_Text1' id='Common_Text1' type='hidden' value=' "+document.getElementById("department").value + "'></form></BODY></HTML>";
				parent.messageFrame.document.write(HTMLVal);
				parent.messageFrame.document.form1.submit();
			 }
		}

			function check1()
			{
				var a=FaciltySection_form.section.length;
				for(var i=0;i<=a;i++)
				{
					FaciltySection_form.section.remove("section");
				}
				var tp ="-----"+getLabel("Common.defaultSelect.label","Common")+"-----";
				var opt=parent.f_query_add_mod.document.createElement("OPTION");
				opt.text=tp;
				opt.value="";

				parent.f_query_add_mod.document.getElementById('section').add(opt);
			}
		</script>
</head>
<body  OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()' onLoad="FocusFirstElement();" >
<%
String facility="";
String deptcode="";
String sectcode="";
String fnval="";
StringBuffer str1=new StringBuffer("");
String strf1="";
String strf2="";
String facilitycode="";
String facilitydesc="";
StringBuffer str2=new StringBuffer("");
String strd1="";
String strd2="";
StringBuffer str3=new StringBuffer("");
String strs1="";
String strs2="";
String effstatus="";
String checkBoxAttribute="";
boolean newfacilitysection=false;
 %>

<%
		facility=request.getParameter("operating_facility_id");
		deptcode=request.getParameter("dept_code");
		sectcode=request.getParameter("section_code");
try
{
	con = ConnectionManager.getConnection(request);
	if(facility == null)
	{
		 fnval="insert";
		try
		{
		stmt = con.createStatement();

		String sql4="select facility_name,facility_id from sm_facility_for_user_vw where appl_user_id='"+uid+"' and (nvl(access_eff_date_to,to_date('30/12/9999','dd/mm/rrrr'))>=trunc(sysdate)) order by facility_name";

		rs = stmt.executeQuery(sql4);
		String sel="";
		if( rs != null )
		{
		str1.append("<option value=''>-----"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"-----");

			 while( rs.next() )
			{
			facilitycode = rs.getString( "facility_id" ) ;
			if(facilitycode.equals(facilityId)) sel="selected"; else sel="";
	 		facilitydesc=rs.getString("facility_name");

			str1.append(" <option "+sel+" value=\""+facilitycode+"\">"+facilitydesc+"</OPTION>");
			}
		}
		str1.append("</select>");

		str2.append("<option value=''>-----"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"-----</OPTION>");
		str2.append("</select>");

		str3.append("<select name='section' id='section' ><OPTION VALUE=''>-----"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"-----</OPTION>");
		str3.append("</select>");

		effstatus="E";
		}
		catch(Exception e) 
		{
		}
		finally 
		{
			try
			{
				if(stmt != null) stmt.close();
				if(rs != null) rs.close();
			}
			catch(Exception e)
			{}
		}
		checkBoxAttribute="CHECKED";
		newfacilitysection=true;

		}
	else
		{
		fnval="modify";
		try 
			{
			String sql4="select operating_facility_id,facility_name,dept_code,dept_short_desc,section_code,section_short_desc,eff_status from am_facility_section_vw where operating_facility_id=? and dept_code=? and section_code=? ";
						
			pstmt   = con.prepareStatement(sql4);
			pstmt.setString	(	1,	facility		);
			pstmt.setString	(	2,	deptcode		);
			pstmt.setString	(	3,	sectcode		);

			rs		 = pstmt.executeQuery();
			
			rs.next();

			effstatus=rs.getString("eff_status");

			if(effstatus.equals("D"))
			{
				  checkBoxAttribute="";
			}
			else
			{			
				 checkBoxAttribute="CHECKED";
 			}

		String f1=rs.getString("operating_facility_id");
		String f2=rs.getString("facility_name");

		strf1="<input type='text' name='facility1' id='facility1' size='70' maxlength='35' value=\""+f2+"\" readonly>";
		strf2="<input type='hidden' name='facility2' id='facility2' value='"+f1+"'>";

		String d1=rs.getString("dept_code");
		String d2=rs.getString("dept_short_desc");

		strd1="<input type='text' name='department1' id='department1' size='15' maxlength='15' value=\""+d2+"\" readonly>";
		strd2="<input type='hidden' name='department2' id='department2' size='15' maxlength='15' value='"+d1+"'>";

		str3.setLength(0);
		str3.append("<select name='section' id='section' >");
		String s1=rs.getString("section_code");
		String s2=rs.getString("section_short_desc");

		strs1="<input type='text' name='section1' id='section1' size='15' maxlength='15' value=\""+s2+"\" readonly>";
		strs2="<input type='hidden' name='section2' id='section2' size='15' maxlength='15' value='"+s1+"'>";

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally 
		{
			try
			{
			if(stmt != null) stmt.close();
			if(pstmt != null) pstmt.close();
			if(rs != null) rs.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
			newfacilitysection=false;
	}
  }
  catch(Exception e)
  {
	  e.printStackTrace();
  }
  finally
  {
   	ConnectionManager.returnConnection(con,request);
  }
%>

<form name="FaciltySection_form" id="FaciltySection_form" action="../../servlet/eAM.FacilitySectionServlet" method="post" target="messageFrame">
<input type="hidden" name="sStyle" id="sStyle" value='<%=sStyle%>' >
<br><br><br><br><br><br><br><br><br><br>
<table border='0' cellpadding='0' cellspacing='0' width='auto' align='center'>
<tr>
	<td width='10%'>&nbsp;</td>
	<td>&nbsp;</td>
	<td>&nbsp;</td>
	<td width='10%'>&nbsp;</td>
</tr>
<tr>
	<td>&nbsp;</td>
	<td   class='label' valign="center"><fmt:message key="Common.facility.label" bundle="${common_labels}"/></td>
	<td class='fields'  valign="center">&nbsp;&nbsp;
	<%if(fnval.equals("insert")) {%>
	<select name='facility' id='facility' onChange="Pass2MsgFrm('facility');check1()"><%=str1%><%=strf2%>
	<%}
	else if(fnval.equals("modify")) {%>
	<%=strf1%><%=strf2%>
	<%}%>
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
	<td   class='label'valign="center"><fmt:message key="Common.acctdept.label" bundle="${common_labels}"/></td>
	<td class='fields' valign='center'>&nbsp;&nbsp;
	<%if(fnval.equals("insert")) {%>
	<select name='department' id='department' onChange="Pass2MsgFrm('department')" ><%=str2%><%=strd2%>
	<%}
	else if(fnval.equals("modify")) {%>
	<%=strd1%><%=strd2%>
	<%
	}%>
	<img src='../../eCommon/images/mandatory.gif' align='center'></img>
	</td>
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
	<td   class='label' valign="center"><fmt:message key="Common.Section.label" bundle="${common_labels}"/></td>
	<td class='fields'>&nbsp;&nbsp;
	<%if(fnval.equals("insert")) {%>
	<%=str3%><%=strs2%>
	<%}
	else if(fnval.equals("modify")) {%>
	<%=strs1%><%=strs2%>
	<%}%>
	<img src='../../eCommon/images/mandatory.gif' align='center'></img>
	</td>
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
	<td   class="label"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
	<td  class='fields'>&nbsp;&nbsp;<input type="checkbox" name="eff_status" id="eff_status"  value="E" <%=checkBoxAttribute%> onClick="change()"></td>
	<td>&nbsp;</td>
</tr>
<tr>
	<td>&nbsp;</td>
	<td>&nbsp;</td>
	<td>&nbsp;</td>
	<td>&nbsp;</td>
</tr>
</table>
	
<%
if(newfacilitysection)
{
	%>
      	<input type='hidden' name='function' id='function' value='insert'>
      	<input type='hidden' name='function_name' id='function_name' value='insert'>
	<script>Pass2MsgFrm('facility');check1()</script>
	  <%
		}
	else
		{
			%>
      	<input type='hidden' name='function' id='function' value='modify'>
      	<input type='hidden' name='function_name' id='function_name' value='modify'>
     <%
	 }
	 %>
</form>
</body>
</html>

