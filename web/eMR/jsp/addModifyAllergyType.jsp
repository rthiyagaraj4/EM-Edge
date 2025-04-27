<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*"  contentType="text/html;charset=UTF-8" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
      <head>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
        <script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
      	<script src='../../eCommon/js/common.js' language='javascript'></script>
	 
	 <script language="javascript" src="../js/AllergyType.js"></script>

      </head>

      <body OnMouseDown='CodeArrest()' onload='FocusFirstElement()' onKeyDown = 'lockKey()'>


<%
   request.setCharacterEncoding("UTF-8");
   String AllergyType="";
   String longdesc="";
   String shortdesc="";
   String effstatus="";
   String allergyclass="";
   String codeTextAttribute="";
   String otherTextAttribute="";
   String checkBoxAttribute="";
   String eventFunctionForCase="";
   boolean newAllergyType = false;
   String sql="";
   String AllergyClassCols[]={"----- Select -----","Drug","Food","General","Inhalant","Topical"};
   String AllergyClassVals[]={"","D","F","G","I","T"};
   String val_1="";
   Connection conn=null;
   Statement stmt=null;
   ResultSet rset=null;

%>
<%
     try{
	AllergyType=request.getParameter("allergy_type_code");

	if(AllergyType==null){
		AllergyType="";
		longdesc="";
		shortdesc="";
		effstatus="E";
		allergyclass="- Select -";

		codeTextAttribute="";
		otherTextAttribute="";
		checkBoxAttribute="CHECKED";
		newAllergyType=true;
		eventFunctionForCase="OnBlur='ChangeUpperCase(this)'";
	}

	else{
	       
		conn=ConnectionManager.getConnection(request);
		stmt = conn.createStatement();

		sql = "select allergy_type_code,allergy_class,long_desc,short_desc,eff_status from mr_allergy_type where allergy_type_code = '"+AllergyType+"'";
		rset = stmt.executeQuery(sql);
		rset.next();
		AllergyType=rset.getString("allergy_type_code");
		longdesc=rset.getString("long_desc");
		shortdesc=rset.getString("short_desc");
		effstatus=rset.getString("eff_status");
		allergyclass = rset.getString("allergy_class");

		if(effstatus.equals("D")){
			otherTextAttribute="READONLY";
			checkBoxAttribute="";
		}else{

			otherTextAttribute="";
			checkBoxAttribute="CHECKED";
		}

	     codeTextAttribute="READONLY";
		newAllergyType=false;
		eventFunctionForCase="";
	}

%>

      	<form name='AllergyType_form' id='AllergyType_form' action='../../servlet/eMR.AllergyTypeServlet' method='post' target='messageFrame'>
      	<div align='left'>
<BR><BR><BR><BR><BR><BR><BR><BR>
      	<table border='0' cellpadding='5' cellspacing='0' width='auto' align='center'>
      	
      		<tr>
      		    <td width='50%' class='label'><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
      		    <td width='50%' class='fields'>
      		    <input type='text' name='allergy_type_code' id='allergy_type_code' value="<%=AllergyType%>" size='2' maxlength='2' onKeyPress="return CheckForSpecChars(event)" <%=codeTextAttribute%> <%=eventFunctionForCase%>>
      		    <img src='../../eCommon/images/mandatory.gif'></img></td>
      		</tr>
      		
      		<tr>
      		    <td width='50%' class='label'><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
      		    <td width='50%' class='fields'>
      		    <input type='text' name='long_desc' id='long_desc' size='30' maxlength='30' value="<%=longdesc%>" <%=otherTextAttribute%>   onBlur="makeValidString(this);">
      		    <img src='../../eCommon/images/mandatory.gif'></img></td>
      		</tr>
      		
      		<tr>
      		    <td  width='50%' class='label'><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
		    	<td width='50%' class='fields'>
		    	<input type='text' name='short_desc' id='short_desc' size='15' maxlength='15' value="<%=shortdesc%>" <%=otherTextAttribute%> onBlur="makeValidString(this);">
			    <img src='../../eCommon/images/mandatory.gif'></img></td>
      		</tr>
			
      		<tr>
      			<td  width='50%' class='label'><fmt:message key="Common.Class.label" bundle="${common_labels}"/></td>
			    <td width='50%' class='fields'>

				<%
				if(!(otherTextAttribute.equals("READONLY")))

					{%>
					<select name="allergy_class" id="allergy_class">
					<%val_1="";
					for (int jj=0;jj<6;jj++)
					{
						if(!(newAllergyType))
						{
							if(AllergyClassVals[jj].equals(allergyclass))
								val_1="selected";
							else
								val_1="";
						}

					out.print("<option value='"+AllergyClassVals[jj]+"' " +val_1+ ">"+AllergyClassCols[jj]+"</option>");
					}
					%>
					</select>  <%}
				else
			{	
				
				 for(int jj=0;jj<6;jj++)
				 {
					if(allergyclass == null || allergyclass.equals("")|| allergyclass.length() == 0  )
					{
						val_1="  ";
						out.println("<input type='text' value=\""+val_1+"\" size='10' maxlength='10' " +otherTextAttribute+">");
						out.println("<input type=hidden name='allergy_class' id='allergy_class' value='"+AllergyClassVals[jj]+"'>");
						break;
					}
					if(AllergyClassVals[jj].equals(allergyclass))
					{
						val_1=AllergyClassCols[jj];
							out.print("<input type='text' value=\""+val_1+"\" size='10' maxlength='10' " +codeTextAttribute+">");
							out.print("<input type=hidden name='allergy_class' id='allergy_class' value=\""+AllergyClassVals[jj]+"\">");
							break;
					}
				}
			   }%>

			</td>
      		</tr>
			<tr>
      		     <td width='50%' class='label'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
      		     <td width='50%' class='fields'>
      		     <input type='checkbox' name='eff_status' id='eff_status' value="<%=effstatus%>" <%=checkBoxAttribute%> onClick="change()"></td>
      		</tr>
		</table>
      	</div>
    <%  if(newAllergyType){%>

      	<input type='hidden' name='function' id='function' value="insert">
      	<input type='hidden' name='function_name' id='function_name' value='insert'>

      <%}else{%>

      	<input type='hidden' name='function' id='function' value='modify'>
      	<input type='hidden' name='function_name' id='function_name' value='modify'>
     <%}%>



      	</form>
      	</body>
      	</html>
<%
	     	

		}catch(Exception e){
			e.toString();
	     }
	     finally{
			 try
			 {
				 if(stmt!=null)
	     	stmt.close();
	     	if(rset!=null)
	     	rset.close();
			 }
			 catch(Exception e){
			
	     }

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

