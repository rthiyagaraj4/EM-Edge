<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper"  contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
Connection con=null;
PreparedStatement pstmt1=null;
ResultSet rs=null;

String sStyle =

(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
String locale = (String) p.getProperty("LOCALE");
	

StringBuffer sql = new StringBuffer();
String dis="";
String mode=request.getParameter("mode");
if(mode==null) mode="insert";

String dat2="";
String id2="";
String sel2="";
String practitioner_id=request.getParameter("practitioner_id");

if(practitioner_id==null) practitioner_id="";

String speciality_id=request.getParameter("speciality_id");

if(speciality_id==null) speciality_id="";

String eff_from_date="";
String eff_to_date="";
String to_date="";
String practitioner_name=request.getParameter("practitioner_name");

if(practitioner_name==null) practitioner_name="";

String facility_id=(String) session.getValue("facility_id");
String srl_no=request.getParameter("srl_no");

if(srl_no==null) srl_no="";

String locn_code=request.getParameter("locn_code");

if(locn_code==null) locn_code="";

String locn_type=request.getParameter("locn_type");

if(locn_type==null) locn_type="";
try
{
	con=ConnectionManager.getConnection(request);
/*
	String sql_date="Select to_char( sysdate,'dd/mm/yyyy') to_date from dual";
	stmt	=	con.prepareStatement(sql_date);
	rs		=	stmt.executeQuery();
	if(rs!=null)
	{
		if(rs.next())
		{
			to_date = rs.getString("to_date");
			to_date	= com.ehis.util.DateUtils.convertDate(to_date,"DMY","en",locale);
		}
		if(rs!=null) rs.close();
		if(stmt!=null) stmt.close();
	}
*/
	to_date		= com.ehis.util.DateUtils.getCurrentDate("DMY",locale);

	if(mode.equals("modify"))
	{
		dis="disabled";
		sql.append(" Select  srl_no,facility_id, locn_type, locn_code, to_char(eff_from_date,'dd/mm/yyyy') eff_from_date, to_char(eff_to_date,'dd/mm/yyyy') eff_to_date from  CA_PRACT_BY_LOCN ");            
		sql.append(" where practitioner_id=? and locn_code=? and locn_type=?   and srl_no=? ");
		pstmt1=con.prepareStatement(sql.toString());
		pstmt1.setString(1,practitioner_id);
		pstmt1.setString(2,locn_code);
		pstmt1.setString(3,locn_type);
		pstmt1.setString(4,srl_no);

		rs=pstmt1.executeQuery();
		if(rs!=null)
		{
		    while(rs.next())
			{
				facility_id=rs.getString("facility_id");
				if(facility_id==null) facility_id="";

				locn_type=rs.getString("locn_type");
				if(locn_type==null) locn_type="";
					locn_code=rs.getString("locn_code");
				
				if(locn_code==null) locn_code="";
					eff_from_date=rs.getString("eff_from_date");
				
				if(eff_from_date==null) eff_from_date="";
					eff_to_date=rs.getString("eff_to_date");
				
				if(eff_to_date==null) eff_to_date="";
					srl_no=rs.getString("srl_no");
				eff_from_date	= com.ehis.util.DateUtils.convertDate(eff_from_date,"DMY","en",locale);
				eff_to_date	= com.ehis.util.DateUtils.convertDate(eff_to_date,"DMY","en",locale);
			}//while
			if(rs!=null) rs.close();
		if(pstmt1!=null) pstmt1.close();
		}//if rs
	}

%>
<html>
	<head>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css" />
		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
		<script src="../../eCommon/js/common.js" language="javascript"></script>
		<script src="../../eCA/js/LocationForPractitioner.js" language="javascript"></script>
		<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script src="../../eCommon/js/CommonLookup.js" language="javascript"></script>
		<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
		<Script language ="JavaScript" src ='../../eCommon/js/CommonLookup.js'></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<script>
		
		function PopulateLoc(obj)
		{		
			parent.parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp";
			var mode=document.forms[0].mode.value;
			var locn_type= obj.value;
			if( locn_type=="X" || locn_type=="Y" || locn_type=="Z"  || locn_type=="P" ) 
			{
				//alert("here");
				//delete_values1(document.forms[0].locn_code);
				if(locn_type=="X")
				{
					document.forms[0].loca.value =getLabel('eCA.AllClinics.label','CA');
					document.forms[0].locn_code.value ="*ALLC";
					document.forms[0].locaSerch.disabled=true;
					document.forms[0].loca.readOnly=true;
					
					
					
				}
				if(locn_type=="Y")
				{   document.forms[0].loca.value =getLabel('eCA.AllNursingUnits.label','CA');
					document.forms[0].locn_code.value ="*ALLW";	
					document.forms[0].locaSerch.disabled=true;
					document.forms[0].loca.readOnly=true;
				}
				if(locn_type=="Z")
				{
					document.forms[0].loca.value =getLabel('Common.AllLocations.label','COMMON');
					document.forms[0].locn_code.value ="*ALLZ";
					document.forms[0].locaSerch.disabled=true;
					document.forms[0].loca.readOnly=true;
				}
			if(locn_type=="P")
				{
					document.forms[0].loca.value =getLabel('eCA.ByPractitionerRights.label','CA');
					document.forms[0].locn_code.value ="*ALLP";
					document.forms[0].loca.readOnly=true;
					document.forms[0].locaSerch.disabled=true;
				}	

			}
			else
			{
				delete_values(document.forms[0].locn_type);
				document.forms[0].loca.readOnly=false;

				//delete_values(document.forms[0].locn_code);
			}
			//var HTMLVal = "<HTML><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%></link></HEAD><BODY CLASS='MESSAGE' onMouseDown=CodeArrest() onKeyDown=lockKey()><form name='form1' id='form1' method='post' action='LocationForPractPopLocn.jsp?locn_type="+locn_type+"'></form></BODY></HTML>";
			//parent.parent.messageFrame.document.write(HTMLVal);
			//parent.parent.messageFrame.document.forms[0].submit();
		}
		function delete_values(field)
		{
			
			document.forms[0].loca.value="";
			document.forms[0].locn_code.value="";
			document.forms[0].locaSerch.disabled=false;
			
			
		/*	var selected = field;
			while ( selected.options.length > 0 )
						selected.remove(selected.options[0]);
			var opt=parent.frames[2].document.createElement("Option");
			opt.text="        ---Select---       "
			opt.value="";
			field.add(opt); */
		}
		function delete_values1(field)
		{
		
	
		document.forms[0].loca.value=field.value;	
		document.forms[0].locn_code.value=document.forms[0].locn_type.value;
		

		/*	var selected = field;
			while ( selected.options.length > 0 )
				selected.remove(selected.options[0]);*/
		}
		</script>
	</head>
	<body  class='CONTENT' OnMouseDown="CodeArrest()" onKeyDown="lockKey()">
	<form name="Section_form" id="Section_form">
	<table border=0 cellspacing=0 cellpadding='3'width='80%' align='center' cellspacing=2 >
	<tr>
		<td class=label ><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/>&nbsp;</td>
		<td class='fields'><select name='locn_type' id='locn_type' onchange='PopulateLoc(this);' <%=dis%>>
		<option value=''>-----------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----------------</option>
		<%if(locn_type.equals("Z")) {%>
			<option value='Z' selected><fmt:message key="Common.AllLocations.label" bundle="${common_labels}"/></option>
		<%}else{%>
			<option value='Z'><fmt:message key="Common.AllLocations.label" bundle="${common_labels}"/></option>
		
		<%} if(locn_type.equals("Y")){%>
			<option value='Y' selected><fmt:message key="eCA.AllNursingUnits.label" bundle="${ca_labels}"/></option>
		<%}else{%>
			<option value='Y'><fmt:message key="eCA.AllNursingUnits.label" bundle="${ca_labels}"/></option>
		
		<%}if(locn_type.equals("X")){%>
			<option value='X' selected><fmt:message key="eCA.AllClinics.label" bundle="${ca_labels}"/></option>
		<%}else{%>
			<option value='X'><fmt:message key="eCA.AllClinics.label" bundle="${ca_labels}"/></option>
		
		<%}if(locn_type.equals("C")){%>
			<option value='C' selected><fmt:message key="eCA.Clinics.label" bundle="${ca_labels}"/></option>
		<%}else{%>
			<option value='C'><fmt:message key="eCA.Clinics.label" bundle="${ca_labels}"/></option>
		
		<%}if(locn_type.equals("W")){%>
			<option value='W' selected><fmt:message key="eCA.NursingUnits.label" bundle="${ca_labels}"/></option>
		<%}else{%>
			<option value='W'><fmt:message key="eCA.NursingUnits.label" bundle="${ca_labels}"/></option>
		
		<%}if(locn_type.equals("P")){%>
			<option value='P' selected><fmt:message key="eCA.ByPractitionerRights.label" bundle="${ca_labels}"/></option>
		<%}else{%>
			<option value='P'><fmt:message key="eCA.ByPractitionerRights.label" bundle="${ca_labels}"/></option>
		<%}%>
		</select><img src='../../eCommon/images/mandatory.gif'></td>
		</tr>
	<tr>
		<td class='label'><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
		<!--<td class='fields' ><select name=locn_code <%=dis%>>	
		<%
		if((mode.equals("insert")) || (mode.equals("modify") && (!locn_type.equals("X") || !locn_type.equals("Y") || !locn_type.equals("Z") )  ) ){%>
			<option value=''>------------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------------------</option>
		
		<%}else{%><option value=''>-----------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>------------------</option><%}%>
				<%
				if(mode.equals("modify"))
				{
					PreparedStatement stmt2=null;
					ResultSet rs2=null;
					try
					{
						String  sql2="  SELECT short_desc,locn_code FROM ca_locn_vw where locn_type = ? and facility_id = ?  order by 2";
						
						stmt2=con.prepareStatement(sql2);
						stmt2.setString(1,locn_type);
						stmt2.setString(2,facility_id);
						rs2=stmt2.executeQuery();
						if(rs2!=null)
						{
							while(rs2.next())
							{
								dat2=rs2.getString(1);
								id2=rs2.getString(2);
								if(id2.equals(locn_code))
									sel2="selected";
								out.println("<option value='"+id2+"' "+sel2+">"+dat2+"</option>");
								sel2="";
							}
						}
					
					if(rs2!=null) rs2.close();
					if(stmt2!=null) stmt2.close();
					}
					catch(Exception e)
					{
						//out.println("Exception @ LocationForPractDetail "+ e.toString());//COMMON-ICN-0181
                                                  e.printStackTrace();//COMMON-ICN-0181
					}
					
				}
		%> -->

	<td class='fields'><input type="text" name="loca" id="loca" size="25" maxlength="20" <%=dis%>  onBlur='getLocaCode(this)' OnChange='resetValues();setValue()' value='<%if(mode.equals("modify"))
	{
		PreparedStatement stmt2=null;
		ResultSet rs2=null;
		
		try{

		 String  sql2="";
		 if(locn_type.equals("C") || locn_type.equals("W"))
		  
		 sql2= " SELECT short_desc,locn_code FROM ca_locn_vw where locn_type = ? and facility_id = ? and locn_code=?  order by 2" ;
		 
		 else
		 
		 sql2=" SELECT short_desc,locn_code FROM ca_locn_vw where locn_type = ? and facility_id = ?  order by 2 ";
		 

		 stmt2=con.prepareStatement(sql2);
		 stmt2.setString(1,locn_type);
		 stmt2.setString(2,facility_id);
		if(locn_type.equals("C")||locn_type.equals("W"))
		{ 
			stmt2.setString(3,locn_code);
		}
		 rs2=stmt2.executeQuery();  
		 
		 if(rs2!=null)
			{
			   while(rs2.next())
			    {
			    dat2=rs2.getString(1);
			    id2=rs2.getString(2);
			    
                 out.println(dat2);
				 //out.println("readOnly");
				 } 
		    
		     }

		if(rs2!=null) rs2.close();
		if(stmt2!=null) stmt2.close();
		}
        catch(Exception e){
		//out.println("Exception @ LocationForPractDetail "+ e.toString());//COMMON-ICN-0181
                  e.printStackTrace();//COMMON-ICN-0181
		}

	}
	
	%>' ><input type="button" value="?" class="button"  name="locaSerch" id="locaSerch"  onClick='resetValues();getLocaCode(this)'><input type="hidden" name="locn_code" id="locn_code" size="20" maxlength="20" value='<%if(mode.equals("modify"))
	out.println(id2);%>'><img src='../../eCommon/images/mandatory.gif'></td>
	</tr>
	<tr>
		<td class=label><fmt:message key="Common.EffectiveFrom.label" bundle="${common_labels}"/></td>
		<td class='fields'><input type='text' name='eff_from_date' id='eff_from_date' value='<%=(!eff_from_date.equals(""))?eff_from_date:to_date%>' onblur='validate_date(this,eff_to_date,"DMY","<%=locale%>");'  size=10 maxlength=10><input type='image' src="../../eCommon/images/CommonCalendar.gif"  onclick="return showCalendarValidate('eff_from_date');" ><img src='../../eCommon/images/mandatory.gif'>
		</td>
	</tr>
	<tr>
		<td  class=label><fmt:message key="Common.EffectiveTo.label" bundle="${common_labels}"/></td>
		<td  class='fields'><input type='text' name='eff_to_date' id='eff_to_date' value='<%=eff_to_date%>' onblur='validate_date(eff_from_date,this,"DMY","<%=locale%>")'  size=10 maxlength=10><input type='image' src="../../eCommon/images/CommonCalendar.gif"  onclick="return showCalendarValidate('eff_to_date');">
		</td>	
	</tr>
	<tr>
		<td><input type='hidden' name='eff_from_date1' id='eff_from_date1' value='<%=eff_from_date%>'></td>
		<td><input type='hidden' name='eff_to_date1' id='eff_to_date1' value='<%=eff_to_date%>'></td>
	</tr>
	</table>
	<input type=hidden name=mode value="<%=mode%>">
	<input type=hidden name=practitioner_name1 value="<%=practitioner_name%>">
	<input type=hidden name=practitioner_id value="<%=practitioner_id%>"> 
	<input type=hidden name=practitioner_id1 value="<%=practitioner_id%>"> 
	<input type=hidden name=srl_no value="<%=srl_no%>">
	<input type=hidden name=locn_type1 value="<%=locn_type%>">
	<input type=hidden name=locn_code1 value="<%=locn_code%>">
	<input type=hidden name=to_date value="<%=to_date%>">
    <input type=hidden name=facility_id value="<%=facility_id%>">
	<input type="hidden" name="locale" id="locale" value="<%=locale%>">
	<input type='hidden' name='flag' id='flag' value='true'>
	</form>
	</body>
</html>
<%
}
catch(Exception e)
{
	//out.println("Exception @ 21434 "+e.toString());//COMMON-ICN-0181
	e.printStackTrace();//COMMON-ICN-0181
}
finally
{
	if(con!=null)ConnectionManager.returnConnection(con,request);
}
%>

