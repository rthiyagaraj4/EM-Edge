<!DOCTYPE html>
<html>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*, java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper"  %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></SCRIPT>
<script src='../../eAM/js/Carelocationtype.js' language='javascript'></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<script>
function checkboxdisable() {

	if (Carelocn_form.function_name.value=="modify"){
	Carelocn_form.ud.disabled=true;

	}
	}
function change(obj)
{
if(document.forms[0].ud.checked==true)
document.forms[0].user_defined.value='U';
else
document.forms[0].user_defined.value='S';
}

</script>

<%
	request= new XSSRequestWrapper(request);
    response.addHeader("X-XSS-Protection", "1; mode=block");
    response.addHeader("X-Content-Type-Options", "nosniff");
	request.setCharacterEncoding("UTF-8");
	Connection con = null;
	PreparedStatement pstmt=null;
	Statement stmt=null;
	ResultSet rset=null ;
	String locationtype="";
	String locntype="";
	String longdesc="";
	String shortdesc="";
	String lntypedef="";
	String userdefined="";
	String fnval="insert";
	String eventFunctionForCase="";
	String val1="";
	//String check="";
	String id1="";
//	String id[]={"R","C","N"};
	String id[]={"B","C","D","E","N","T","O","R","W","S"};	
	//String id[]={"R","C","N","S","T","E","B","W","O","D"};
//	String val[]={"Room","Clinic","Nursing Unit"};
	String val[]={com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Bed.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clinic.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DaycareUnit.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.ExamProcedureUnit.label","am_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nursingUnit.label","common_labels"),"Operation Theatre (All)","Operation Theatre (Spec)",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.room.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.RadiologyWing.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.StudyLocation.label","am_labels")};
	//String val[]={"Room","Clinic","Nursing Unit","Study Location","Operation Theatre(All)","Exam/Procedure Unit","Bed","Radiology Wing","Operation Theatre(Spec)","Daycare Unit"};
	String rdonly="";
	String rdonly1="";
	eventFunctionForCase="OnBlur='ChangeUpperCase(this)'";

	//SimpleDateFormat formatter=null;
	//	java.util.Properties p=(java.util.Properties) session.getValue( "jdbc" );


	locationtype=request.getParameter("locn_type");
	userdefined=request.getParameter("sys_user_def_ind");
	
	try
	{
		con = ConnectionManager.getConnection(request);
		if(locationtype!=null )
		{
			fnval="modify";
			pstmt=con.prepareStatement("select locn_type, long_desc, short_desc,care_locn_type_ind from am_care_locn_type where locn_type=? ");
			pstmt.setString(1,locationtype);

			rset=pstmt.executeQuery();
			rset.next();
			locntype=rset.getString("locn_type");
			longdesc=rset.getString("long_desc");
			shortdesc=rset.getString("short_desc");
			lntypedef=rset.getString("care_locn_type_ind");
		

		}


%>
  </head>

<body  onLoad="checkboxdisable();FocusFirstElement(); " OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
  	<form name='Carelocn_form' id='Carelocn_form' action='../../servlet/eAM.CarelocationtypeServlet' method='post' target='messageFrame'>
		 <div>
		 <center>
		 <br><br><br><br><br><br><br><br><br>
		      	<table border='0' cellpadding='0' cellspacing='0' width='auto'>
		      	<%
		      		if (fnval == "modify")
		      		{
		      		   if (userdefined.equals("S")){
		      		  	rdonly = "readonly" ;
		      			rdonly1="readonly";
		      			}
		      		  else
		      		  	rdonly = "readonly" ;
		      		}

		      	%>
				<tr>
				        <td width='10%'>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td width='10%'>&nbsp;</td>

				</tr>
		      		<tr>
		      		    <td>&nbsp;</td>
		      		    <td  class='label'><!--width='40%'--><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
		      		    <td class='fields'><!-- width='60%' colspan='2'-->&nbsp;&nbsp;
		      		    <input type='text' onKeyPress="return CheckForSpecChars(event)"  name='locn_type' id='locn_type' value="<%=locntype%>" size='1' maxlength='1'<%=rdonly%> <%=eventFunctionForCase%>>
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
		      		    <td class=label><!--width='40%'--><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
		      		    <td class='fields'><!--width='60%' colspan='2'-->&nbsp;&nbsp;
		      		    <input type='text' onBlur="makeValidString(this)" name='long_desc' id='long_desc' size='30' maxlength='30' <%=rdonly1%> value="<%=longdesc%>"  >
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
		      		    <td class=label><!-- width='40%'--><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
				    <td class='fields'> <!--width='60%' colspan='2'-->&nbsp;&nbsp;
				    <input type='text' name='short_desc' id='short_desc' size='15' maxlength='15' <%=rdonly1%> onBlur="makeValidString(this)" value="<%=shortdesc%>"  >
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
		      		<td class=label><!-- width='40%'--><fmt:message key="Common.INDICATOR.label" bundle="${common_labels}"/></td>
				<td class='fields'><!-- width='60%' colspan='2'-->&nbsp;&nbsp;

				<%
				if (fnval == "modify")
				{
					for(int i=0; i<10; i++)
					{
					  if(id[i].equals(lntypedef))
					  {
						val1=val[i];
						id1=id[i];
					  }
						
					}
				
					out.print("<input type='text' name='t' id='t' value=\""+val1+"\" readonly>");
    				    	out.print("<input type='hidden' name='locn_type_ind' id='locn_type_ind' value=\""+id1+"\">");


				}
				else
				{
				%>
					<select name='locntype_ind' id='locntype_ind' >
					<option value="">------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----</option>
						<option value="B"><fmt:message key="Common.Bed.label" bundle="${common_labels}"/>
						<option value="C"><fmt:message key="Common.clinic.label" bundle="${common_labels}"/>
					<option value="D"><fmt:message key="Common.DaycareUnit.label" bundle="${common_labels}"/>
					<option value="E"><fmt:message key="eAM.ExamProcedureUnit.label" bundle="${am_labels}"/>
					<option value="N"><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/>
					<option value="T"><fmt:message key="eAM.OperationTheatreAll.label" bundle="${am_labels}"/>
					<option value="O"><fmt:message key="eAM.OperationTheatrespec.label" bundle="${am_labels}"/>
		      		 	
		      		 	<option value="R"><fmt:message key="Common.room.label" bundle="${common_labels}"/>
							<option value="W"><fmt:message key="Common.RadiologyWing.label" bundle="${common_labels}"/>
		      		 	
		      		 	
						<option value="S"><fmt:message key="eAM.StudyLocation.label" bundle="${am_labels}"/>
						
						
		      		 	
						
						
		      		 	</select>
					<!--select name='locntype_ind' >
					<option value="">---Select---</option>
		      		 	<option value="R">Room
		      		 	<option value="C">Clinic
		      		 	<option value="N">Nursing Unit
						<option value="S">Study Location
						<option value="T"> Operation Theatre (All)
						<option value="E">Exam / Procedure Unit
		      		 	<option value="B">Bed
		      		 	<option value="W">Radiology Wing
						<option value="O">Operation Theatre (Spec)
						<option value="D">Daycare Unit
		      		 	</select-->
		      		<%
		      		}
		      		%>

		      		 	<img src='../../eCommon/images/mandatory.gif'align='center'></img>
		      		  </td>
		      		  <td>&nbsp;</td>
		      		</tr>
				<tr>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>

				<%
				if (fnval == "modify")
				{
					String chk="";
					if(userdefined.equals("U"))
					chk="checked";
				%>

		      		<tr>
		      		<td>&nbsp;</td>
		      		     <td  class='label'><fmt:message key="Common.UserDefined.label" bundle="${common_labels}"/></td>
		      		     <td  class='fields'>&nbsp;&nbsp;
		      		     <input type='checkbox' name='ud' id='ud' value='<%=userdefined%>'   <%=chk%>  onClick="change()">
		      		     <input type='hidden' name='user_defined' id='user_defined' value='<%=userdefined%>' ></td>
		      		     <td>&nbsp;</td>
      				</tr>
      				<tr>
      					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
<%
				} //end if
%>

<%
       	} //end try

	catch(Exception e)
	{
		e.printStackTrace();
	}
	finally
	{
			if(rset!=null)	rset.close();
			if(stmt!=null)	stmt.close();
			if(pstmt!=null)	pstmt.close();
			ConnectionManager.returnConnection(con,request);
	    	
	}
%>

		      	</table>
		</center>
	 	</div>
		       	<input type='hidden' name='function' id='function' value='<%=fnval%>'>
		      	<input type='hidden' name='function_name' id='function_name' value='<%=fnval%>'>

    	</form>
</body>
</html>

