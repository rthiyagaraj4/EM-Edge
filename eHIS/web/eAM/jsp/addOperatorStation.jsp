<!DOCTYPE html>
<%--
	FileName	: addOperatorStation.jsp
	Version	    : 3	
	Modified On	: 23-2-2005
--%><%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*, eCommon.XSSRequestWrapper" %>

<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
String oper_stn_id_mod=request.getParameter("oper_stn_id")==null?"":request.getParameter("oper_stn_id");

String fac_name = request.getParameter("fac_name");

if(fac_name == null) fac_name="";
String facility_id1 = request.getParameter("facility_id");

if(facility_id1 == null) facility_id1="";

%>

<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script language='javascript' src='../../eAM/js/OperatorStation.js'></script>


<script>
function callfocus1()
{
	document.forms[0].facility.focus();
}
function populate_details(obj){ 
	
	var oper_stn_id=parent.parent.frames[1].frames[0].document.forms[0].oper_stn_id.value;
	var long_desc=parent.parent.frames[1].frames[0].document.forms[0].long_desc.value;
	var short_desc=parent.parent.frames[1].frames[0].document.forms[0].short_desc.value;
	var eff_status ='';
	if(document.forms[0].eff_status.checked)
			eff_status='E';
	else
			eff_status='D';

	var operstntype=obj.value;
	
	var params = "oper_stn_id=<%=oper_stn_id_mod%>&oper_stn_type="+operstntype+"&eff_status="+eff_status+"&facility_id="+document.forms[0].facility.value;
	if(operstntype == ''){ 
		parent.parent.frames[1].frames[1].document.location.href="../../eCommon/html/blank.html"
		parent.parent.frames[1].frames[2].document.location.href="../../eCommon/html/blank.html"
		}
	else
		parent.parent.frames[1].frames[1].document.location.href="../../eAM/jsp/OperatorStationtabs.jsp?"+params
	
}

function call_result(oper_stn_id,long_desc,short_desc,operstntype){
	
}
function ObjClick(Obj)
{
	if(Obj.checked)
		Obj.value='E';
	else
		Obj.value='D';
}
</script>
</head>

<body onLoad="FocusFirstElement();" OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()'> 
<form name='opstn_form' id='opstn_form' action='../../servlet/eAM.OperatorStationServlet' method='post' target='messageFrame'>
 <%
		 String oper_stn_type="";
		 String longdesc="";
		 String shortdesc="";
		 String ws_no="";
		 String eventFunctionForCase="";
		 String codeTextAttribute="";
		 String otherTextAttribute = "";

		 String eff_status = request.getParameter("eff_status");
			if(eff_status == null) eff_status="";
		
		
String mode = request.getParameter("mode");
if(mode == null) mode="";

		 String facilityid=(String)session.getValue("facility_id");
		 
		String dispfacility_id = request.getParameter("facility_id");
			if(dispfacility_id == null) dispfacility_id=facilityid;
			else
			dispfacility_id = dispfacility_id.trim();
			
	Properties p=(Properties)session.getValue("jdbc");
	String userId=p.getProperty( "login_user" ) ;

		 boolean newOperatorStation=false;
		 String rule="";
		 String oper_stn_type_code="";
		 String oper_stn_id=request.getParameter("oper_stn_id")==null?"":request.getParameter("oper_stn_id");
		 if(oper_stn_id.equals("null")) oper_stn_id = "";
		 Connection conn = null;
		
		
		 ResultSet rs= null;
		 ResultSet rset=null;
		 Statement stmt = null;
		 PreparedStatement pstmt = null;

try{
	conn = ConnectionManager.getConnection(request);
	stmt=conn.createStatement();

	if(oper_stn_id == null || oper_stn_id.equals("")){
		newOperatorStation=true;
		eventFunctionForCase="OnBlur='ChangeUpperCase(this)'";

		rs=stmt.executeQuery("Select  OPER_STN_ACCESS_RULE from op_param where operating_facility_id = '"+facilityid+"'");
		if(rs.next())
			rule=rs.getString(1);
		}
		else{
			if(rs!=null)rs.close();
			String sql ="select oper_stn_id,decode(oper_stn_type,'I','Inpatient','O','Outpatient','B','Inpatient/Outpatient') oper_stn_type_desc, oper_stn_type, long_desc,short_desc,ws_no,EFF_STATUS from am_oper_stn where oper_stn_id=? and  facility_id = ? " ;	
		//out.println(sql);
		//rset = stmt.executeQuery(sql);
	
		pstmt   = conn.prepareStatement(sql);
		pstmt.setString	(	1,	oper_stn_id		);
		pstmt.setString	(	2,	dispfacility_id		);
		rset		 = pstmt.executeQuery();
		
		if(rset !=null){
		while(rset.next()){
		oper_stn_id	 = rset.getString("oper_stn_id");
		oper_stn_type	 = rset.getString("oper_stn_type_desc");
		longdesc	 = rset.getString("long_desc");
		shortdesc	 = rset.getString("short_desc");
		oper_stn_type_code=rset.getString("oper_stn_type");
		ws_no=rset.getString("ws_no");
		eff_status =rset.getString("eff_status");
		codeTextAttribute="READONLY";
		newOperatorStation=false;
		eventFunctionForCase="";
		}
		}
	}


%>
<div>
<table border='0' cellpadding='0' cellspacing='0' width='100%' height='auto' align='center'>
		<tr>
		<td  class='label' nowrap><fmt:message key="Common.facility.label" bundle="${common_labels}"/></td>
		<td  class='fields' nowrap>
		<% if(oper_stn_id.equals("") ) { %>
		<select name='facility' id='facility' >
		<option >--------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------------</option>
	       <%
			String ID="",dat="",en="";
			if(rset!=null)rset.close();
            if(stmt!=null)stmt.close();
            if(pstmt!=null)pstmt.close();
			stmt=conn.createStatement();
			rset=stmt.executeQuery("Select Facility_id,Facility_name Operating_facility_id from SM_FACILITY_FOR_USER_VW where appl_user_id = '"+userId+"' and  NVL(access_eff_date_to,TO_DATE('31/12/9999','dd/mm/rrrr')) >= TRUNC(SYSDATE) order by facility_name ");
			if(rset!=null)
			{
			   while(rset.next())
			   {
				dat=rset.getString("Operating_facility_id");
				ID=rset.getString("facility_id");
				if(ID.equals(dispfacility_id))
					  en="selected";
					else
					    en="";
				out.println("<option value=\""+ID+ "\" "+en+">"+dat+"</option>");
			   }
			   }
			   %>		
		
		</select>
		<% } else { %>
		<input type='hidden' name='facility' id='facility' value="<%=dispfacility_id%>"><input type='text' name='facility_desc' id='facility_desc' size='70' maxlength='35' readOnly value="<%=fac_name%>">
		<% } %>
		<img src='../../eCommon/images/mandatory.gif' align='center'></img>
		</td>
	
      		<td nowrap  class='label' nowrap><fmt:message key="Common.code.label" bundle="${common_labels}"/>
      		</td>
      		<td  class='fields' nowrap>
      			<input type='text' name='oper_stn_id' id='oper_stn_id' onKeyPress="return CheckForSpecChars(event)"  value="<%=oper_stn_id%>" size='30' maxlength='30' <%=codeTextAttribute%> <%=eventFunctionForCase%> >
      		    	<img src='../../eCommon/images/mandatory.gif' align='center'></img>
      		</td>
      	
      	</tr>
      	
      	<tr>
      		<td  nowrap class=label nowrap><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/>
      		</td>
      		<td  class='fields' nowrap>
      		    	<input type='text' onBlur='makeValidString(this)' name='long_desc' id='long_desc' size='30' maxlength='30' value="<%=longdesc%>" <%=otherTextAttribute%> >
      		    	<img src='../../eCommon/images/mandatory.gif'></img>
      		</td>
      		<td nowrap  class=label width='15%'><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/>
      		</td>
		<td class='fields' nowrap>
		<input type='text' onBlur='makeValidString(this)' name='short_desc' id='short_desc' size='15' maxlength='15' value="<%=shortdesc%>" <%=otherTextAttribute%> >
		<img src='../../eCommon/images/mandatory.gif'></img>
		</td>
      	</tr>
      	<tr>
		<td nowrap class=label nowrap><fmt:message key="eAM.OperatorStationType.label" bundle="${am_labels}"/></td>
		<%
		if(oper_stn_type==null || oper_stn_type.equals("")){
		%>

		<td nowrap  class='fields' nowrap>
			<select name="operstntype" id="operstntype" value='' onchange='populate_details(this)';>
			<option>---- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----</option>
			<option value="I"><fmt:message key="Common.inpatient.label" bundle="${common_labels}"/></option>	
			<option value="O"><fmt:message key="Common.Outpatient.label" bundle="${common_labels}"/></option>	
			<option value="B"><fmt:message key="Common.IPOP.label" bundle="${common_labels}"/></option>	
			</select>&nbsp;<img src='../../eCommon/images/mandatory.gif'></img>
		</td>
		<%
		}
		else{
		%>
		<td nowrap  class='fields' nowrap>
			<input type='text' name='operstntype_desc' id='operstntype_desc' size='20' maxlength='20' value="<%=oper_stn_type%>" readonly >
			<input type='hidden' name='operstntype' id='operstntype' value="<%=oper_stn_type_code%>">	
			&nbsp;<img src='../../eCommon/images/mandatory.gif'></img>
		</td>
		
		<%
		}
		%>
		<% if(!oper_stn_id.equals("") && eff_status.equals("E") ) { %>
		<td  nowrap width='10%' class='label' nowrap><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td> 
			
		<td class='fields' nowrap><input type='checkbox' name='eff_status' id='eff_status' value="E" checked onClick='ObjClick(this)' ></td>
		<% } else if(!oper_stn_id.equals("") && eff_status.equals("D")){ %>
		<td nowrap width='40%' class='label'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
			<td class='fields' nowrap><input type='checkbox' name='eff_status' id='eff_status' value="D"  onClick='ObjClick(this)'></td>
		<% } else {  %>
		<td nowrap  width='40%' class='label' ><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
			<td class='fields'><input type='checkbox' name='eff_status' id='eff_status' value="E" checked onClick='ObjClick(this)' onblur="callfocus1();"></td>
		<% } %> 
			

	</tr>
		
 	</table>
<%

if(newOperatorStation){%>

<input type='hidden' name='function' id='function' value='insert'>
<input type='hidden' name='function_name' id='function_name' value='insert'>

<%}else{%>

<input type='hidden' name='function' id='function' value='modify'>
<input type='hidden' name='function_name' id='function_name' value='modify'>
 <%}%>

<input type='hidden' name='eff_date_from' id='eff_date_from' >

<input type='hidden' name='eff_date_to' id='eff_date_to' >
<input type='hidden' name='rule' id='rule' value=<%=rule%>>
<input type='hidden' name='mode' id='mode' value=<%=mode%>>


<%
if(eff_status.equals("D")){ %>
<script>
	for(k=0;k<document.forms[0].elements.length;k++)
		document.forms[0].elements[k].readOnly=true;
</script>
<% } 

	 }
       catch(Exception e){
		e.printStackTrace();
	}
	finally
	{
		try
		{
		if (rset!= null) rset.close();
		if (stmt != null) stmt.close();
		if (rs != null) rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		ConnectionManager.returnConnection(conn,request);

	}
%>	

</form>
</body>
</html>

