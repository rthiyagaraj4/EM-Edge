<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import ="webbeans.eCommon.*,java.sql.*" %>
<% request.setCharacterEncoding("UTF-8");  %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<%
	String facility_id	= (String)session.getValue("facility_id");
	String nursing_unit = request.getParameter("nursing_unit");
	String called_from	= checkForNull(request.getParameter("called_from"));

	Statement stmt=null;
	ResultSet rs=null;
	Connection con = null;

	String nursing_unit_type="";
	String age_group="";
	String department="";
	String dept_code = "";
	String service="";
	String nursing_unit_short_desc="";

	try{
		   con = ConnectionManager.getConnection(request);
			out.println("<html><head><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></head><body CLASS='MESSAGE' onMouseDown='CodeArrest()' onKeyDown='lockKey()'></body>");
			stmt= con.createStatement();	
			
			String sql_check="Select count(*) from ip_nursing_unit "+
			"where upper(nursing_unit_code)=upper('"+nursing_unit+"') and "+
			"facility_id='"+facility_id+"' and eff_status = 'E' ";
			ResultSet rs_check=stmt.executeQuery(sql_check);
			rs_check.next();
			int count=rs_check.getInt(1);
			if(count==0) 
			{%>
				<script>
				alert(getMessage("INVALID_NURSING_UNIT","IP"));
				parent.frames[1].frames[1].location.href="../../eCommon/html/blank.html";
				parent.frames[1].frames[2].location.href="../../eCommon/html/blank.html";
				parent.frames[1].frames[0].document.getElementById('tab').style.visibility="hidden";
				parent.frames[1].frames[0].document.getElementById('td5').innerHTML = "<input type=text name=nursing_unit id=nursing_unit size=4 maxlength=4 onblur='ChangeUpperCase(this);PopulateValues(this)'><input type=button class=button name='search_nur_unit' id='search_nur_unit' value='?' onclick='showmodal()'>";
				parent.frames[1].frames[0].document.forms[0].Search.disabled=true;
				parent.frames[1].frames[0].document.forms[0].nursing_unit.select();
				parent.frames[1].frames[0].document.forms[0].nursing_unit.focus();
				</script>
			<%}
			else
			{
				String sql="Select NURSING_UNIT_TYPE_SHORT_DESC, AGE_GROUP_SHORT_DESC, "+
				"DEPT_SHORT_DESC, SERVICE_SHORT_DESC,NURSING_UNIT_SHORT_DESC, DEPT_CODE  "+
				"from IP_NURSING_UNIT_VW where nursing_unit_code='"+nursing_unit+"' and "+
				"facility_id='"+facility_id+"' and eff_status = 'E' ";
			stmt= con.createStatement();	
			rs = stmt.executeQuery(sql) ;
			if(rs!=null)
			{
				while (rs.next())
				{			
				 nursing_unit_type = rs.getString(1);	
				 if(nursing_unit_type==null) nursing_unit_type="";
				 
				 age_group = rs.getString(2);
				 if(age_group==null) age_group="";
				 
				 department = rs.getString(3);	
				 if(department==null) department="";

				 service = rs.getString(4);	
	
				 nursing_unit_short_desc=rs.getString(5);
				 if(nursing_unit_short_desc==null) nursing_unit_short_desc="";
				 dept_code = rs.getString(6);
				 if (dept_code==null) dept_code = "";
%>
				<script>
				parent.frames[1].frames[0].document.forms[0].Search.disabled=false;
				parent.frames[1].frames[0].document.getElementById('tab').style.visibility='visible';	

				parent.frames[1].frames[1].location.href="../../eCommon/html/blank.html";
				parent.frames[1].frames[2].location.href="../../eCommon/html/blank.html";
				parent.frames[1].frames[0].document.getElementById('td1').innerHTML="<b><%=nursing_unit_type%></b>";
				//modified on 5-06-08
				if (parent.frames[1].frames[0].document.forms[0].nursing_unit_type)
					parent.frames[1].frames[0].document.forms[0].nursing_unit_type.value="<%=nursing_unit_type%>";
				parent.frames[1].frames[0].document.getElementById('td2').innerHTML="<b><%=age_group%></b>";
				if (parent.frames[1].frames[0].document.forms[0].age_group)
					parent.frames[1].frames[0].document.forms[0].age_group.value="<%=age_group%>";
				//
				if("<%=called_from%>" == "5")
				{
					if (parent.frames[1].frames[0].document.forms[0].dept_code)
						parent.frames[1].frames[0].document.forms[0].dept_code.value="<%=dept_code%>";
				}
				else
				{
					parent.frames[1].frames[0].document.getElementById('td3').innerHTML="<b><%=department%></b>";
					if (parent.frames[1].frames[0].document.forms[0].dept_code)
						parent.frames[1].frames[0].document.forms[0].dept_code.value="<%=dept_code%>";
				}
		
				parent.frames[1].frames[0].document.getElementById('td4').innerHTML="<b><%=service%></b>";
				//modified on 5-06-08
				if (parent.frames[1].frames[0].document.forms[0].service)
					parent.frames[1].frames[0].document.forms[0].service.value="<%=service%>";
				//
				if(parent.frames[1].frames[0].document.getElementById('td5').innerHTML.lastIndexOf("<B>") != -1)
				{
					parent.frames[1].frames[0].document.getElementById('td5').innerHTML = parent.frames[1].frames[0].document.getElementById('td5').innerHTML.substring(0,parent.frames[1].frames[0].document.getElementById('td5').innerHTML.lastIndexOf("<B>"));
				}

				parent.frames[1].frames[0].document.forms[0].Search.focus();
				</script>
<%
				}
			}
			if(rs!=null)rs.close();
			if(stmt!=null)stmt.close();
		}
		}catch(Exception e) { out.println("Main : "+e.toString());}
	finally
	{
		if (rs != null) rs.close();
		if (stmt != null) stmt.close();
		ConnectionManager.returnConnection(con,request); 
	}
	out.println("</script></html>");		
	
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

