<!DOCTYPE html>
<html>
<%@ page import ="java.sql.*, java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 


<head>
<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'> -->
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>

<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></SCRIPT>
<script src='../../eSM/js/FacilityforResponsibility.js' language='javascript'></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
	function CheckMaxLen1(lab,obj,max,messageFrame) {
		if(obj.value.length > max) {
		
			messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=APP-SM0045 - " + lab + " cannot exceed " + max  + " characters" ;
			return false;
		} else return true;
}

function mandatoryChk()
{
	
	 var fields = new Array ( document.forms[0].responsibility);
	if(document.forms[0].faci.value=="fac")
	{
	 var names  = new Array ( getLabel("Common.facility.label","Common"));
	 
 	}
	else
	{
		var names  = new Array ( getLabel("Common.responsibility.label","Common"));
		//alert(names)
		 //return false;
	}
	
	if(checkFieldsofMst( fields, names, parent.parent.frames[2])) {
	parent.parent.frames[2].location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='
	
	 return true;
		
	 }
	 else
		return false;

	 //parent.parent.frames[2].location.href='../../eCommon/html/blank.html'


}

function displayDetails()
{

if(mandatoryChk()){	
 var param=escape(document.forms[0].param.value);
 var order=document.forms[0].orderby.value;
 var faci=document.forms[0].faci.value;
 var respons=document.forms[0].responsibility.value;
 
	  
parent.frames[2].location.href="../../eSM/jsp/FacilityforResponsibilityDetail.jsp?respID="+document.forms[0].responsibility.value+"&param="+param+"&responsiblity="+respons+"&faci="+faci+"&order="+order+"&flagSelect=fromSelect";
	}
	
}

function clearValues()
{
	parent.frames[2].location.href="../../eCommon/html/blank.html";


}
function blockevent(event){
	
       
	 var whichCode = (window.Event) ? event.which : event.keyCode;
    if (whichCode=='13')
	return false ;
}
</script>
<%
	Connection con=null;
	try{
    request.setCharacterEncoding("UTF-8");
	con = ConnectionManager.getConnection(request);
	
	Statement stmt=null;
	ResultSet rset=null ;
	String dat="";
	
	String fnval="insert";
	String id="";
	
	String faci=request.getParameter("faci");
   if(faci == null || faci.equals("null")) 
			faci="";
	try
	{
%>		
	</head>

	<body  onLoad="FocusFirstElement()" OnMouseDown="CodeArrest()"; onKeyDown = 'lockKey()';>
		<form name='resp_form' id='resp_form' action='../../servlet/eSM.FacilityForResponsibilityServlet' method='post' target='messageFrame'>
		  <table border='0' cellpadding='3' cellspacing='0' align='center'  width='90%' > 
		
		 
		   <tr>
			    <td width='25%' colspan=4>&nbsp;</td>
			    <td width='25%'></td>
			    <td width='25%'></td>
			    <td width='25%'></td>
			</tr>
		 
	<%
	if(faci.equals("fac"))
		{
		%>
		        <tr>
				    
 				     <td class='label' width='25%'><fmt:message key="Common.facility.label" bundle="${common_labels}"/></td>
    				     <td class='fields' width='25%'>
    				   	<select name='responsibility' id='responsibility' onChange='clearValues()'><option value='' selected> --------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------
    				    	<%
    				    		stmt=con.createStatement();
    				    		rset=stmt.executeQuery("select facility_name,facility_id from sm_facility_param order by facility_name");
    				    		
    				    		if(rset!=null)
    				    		{
    				    		   while(rset.next())
    				    		   {
    				    		   dat=rset.getString("facility_name");
    				    		   id=rset.getString("facility_id");
    				    		   out.println("<option value='"+id+ "' >"+dat);
    						   
    				    		   }
    				    		}
								%> </select><img src='../../eCommon/images/mandatory.gif' align='center'>
    				    	  <%
		}
       else
		{%>
		    <tr>
				     
 				     <td class='label' width='25%'><fmt:message key="Common.responsibility.label" bundle="${common_labels}"/></td>
    				     <td class='fields' width='25%'>
    				   	<select name='responsibility' id='responsibility' onChange='clearValues()'><option value='' selected>  ---------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----------
    				    	<%
								if(stmt!=null) stmt.close();
    				    		stmt=con.createStatement();
    				    		if(rset!=null)	rset.close();
    				    		rset=stmt.executeQuery("select resp_name, resp_id from sm_resp where eff_status='E' and ( (trunc(eff_date_from) <= trunc(sysdate) and trunc(eff_date_to) >=  trunc(sysdate) )  or (trunc(eff_date_from) <= trunc(sysdate) and eff_date_to is null )  or (trunc(eff_date_to) >= trunc(sysdate) and  eff_date_from is null)  or (eff_date_from is null and eff_date_to is null)) order by upper(resp_name) ");
    				    		
    				    		if(rset!=null)
    				    		{
    				    		   while(rset.next())
    				    		   {
    				    		   dat=rset.getString("resp_name");
    				    		   id=rset.getString("resp_id");
    				    		   out.println("<option value='"+id+ "' >"+dat);
    						   
    				    		   }
    				    		}
								%> </select><img src='../../eCommon/images/mandatory.gif' align='center'>
    				    	  
								<%

		}
						if(rset!=null)	rset.close();
				 		if(stmt!=null)	stmt.close();
						
    				     
					}
				     catch(Exception e){out.print(e);}
				     %>
    				    	
    				     </td>
    				     <td width='25%'></td>
    				     <td width='25%'></td>
					</tr>
    				
				
				<tr>
				   <%if(faci.equals("fac"))
		             {%>
						<td  class=label width='25%'><fmt:message key="eSM.SearchResponsibility.label" bundle="${sm_labels}"/></td>
					  <td class='fields' width='25%'><input type='text'  name='param' id='param' size=35 onKeyPress="return blockevent(event)"> <!--onBlur='makeValidQueryCriteria(this)' onKeyPress="return blockevent(event)"--></td> 
					   <td class='label' ><fmt:message key="Common.criteria.label" bundle="${common_labels}"/></td>
    			     <td class='fields'>
    				   	<select name='orderby' id='orderby' >
						<option value='S'><fmt:message key="Common.startsWith.label" bundle="${common_labels}"/>
						<option value='E'><fmt:message key="Common.endsWith.label" bundle="${common_labels}"/>
						<option value='C'><fmt:message key="Common.contains.label" bundle="${common_labels}"/>
    				   </td> 
                      </select>
				<%}else{%>
					<td class=label width='25%' >&nbsp;&nbsp;<fmt:message key="eSM.SearchFacility.label" bundle="${sm_labels}"/></td>
					  <td  class='fields' width='25%'><input type='text' maxlength="35" size="35" name='param' id='param' onKeyPress="return blockevent(event)"></td> 
					   <td class='label' nowrap><fmt:message key="Common.criteria.label" bundle="${common_labels}"/>&nbsp;</td>
    			     <td class='fields' width='25%'>
    				   	<select name='orderby' id='orderby' >
						<option value='S' ><fmt:message key="Common.startsWith.label" bundle="${common_labels}"/>
						<option value='E' ><fmt:message key="Common.endsWith.label" bundle="${common_labels}"/>
						<option value='C' ><fmt:message key="Common.contains.label" bundle="${common_labels}"/>
    				   </td>
				       </select>
						<%}%>

		
				</tr>
						
				 <tr>
				 <td width='25%'></td><td width='25%'></td><td width='25%'></td>
    					<td ><input type='button' name='search' id='search' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>' class='button' onclick='displayDetails()'><input type='button' name='clear' id='clear' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>' class='button' onclick='clearValues()'></td>
				</tr>

			</table>
		<input type='hidden' name='faci' id='faci' value='<%=faci%>'>
		<input type='hidden' name='function1' id='function1' value='<%=fnval%>'>
		<input type='hidden' name='function_name' id='function_name' value='<%=fnval%>'>
	</form>

</body>
<%
}catch(Exception e){out.println(e);}
			finally { 
	ConnectionManager.returnConnection(con,request);
}	
%>
</html> 

