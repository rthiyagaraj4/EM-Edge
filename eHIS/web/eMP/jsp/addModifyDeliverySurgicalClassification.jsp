<!DOCTYPE html>
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%
	request.setCharacterEncoding("UTF-8");
%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
  <head>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>	
	<script src='../js/DeliverySurgicalClassification.js' language='javascript'></script>
</head>

 <body OnMouseDown='CodeArrest()' onKeyDown='lockKey();' onLoad='FocusFirstElement()'>
<%
	Connection con = null;
    PreparedStatement pstmt		=null;
	ResultSet rset			=null;

   String deliversurgical			="";
   String longdesc			="";
   String shortdesc		="";
   String effstatus			="";
   String fnval					="insert";
   String chk					="checked";
   String rd						="";
   String rdall					="";

   //Added by Ashwini on 24-Jan-2019 for ML-MMOH-CRF-1109
	Boolean isModifyLongShortDescAppl = false;
%>
<%
	deliversurgical=request.getParameter("Dely_Surg_Class_Code")==null?"":request.getParameter("Dely_Surg_Class_Code");
     
		  try{
				con = ConnectionManager.getConnection(request);

				isModifyLongShortDescAppl =  eCommon.Common.CommonBean.isSiteSpecific(con,"MP","MODIFY_LONG_SHORT_DESC");//Added by Ashwini on 24-Jan-2019 for ML-MMOH-CRF-1109
				
				if(!deliversurgical.equals(""))
				{
					pstmt = con.prepareStatement("select long_desc,short_desc,eff_status from 	MP_Dely_Surg_Classification where Dely_Surg_Class_Code='"+deliversurgical+"'");
					rset = pstmt.executeQuery();
					 if(rset.next())
					 {
						rd = "readonly";
						fnval = "modify";
						longdesc=rset.getString("long_desc");
						shortdesc=rset.getString("short_desc");
						effstatus = rset.getString("eff_status");
					 }
					 if(effstatus.equals("E")) chk = "checked";
					 else { rdall = "readonly";chk = "";}
				}
			  }catch(Exception e){out.println(e.toString());}
			  finally{
				if(rset!=null) 	     	rset.close();
				if(pstmt!=null) 	    pstmt.close();
				if(con!=null) ConnectionManager.returnConnection(con,request);
				}
%>

      	<form name='DeliveryClassification_form' id='DeliveryClassification_form' action='../../servlet/eMP.DeliverySurgicalClassificationServlet' method='post' target='messageFrame'>
      	<div>
      	<br>
      	<br>
      	<br>
      	<br>
      	<br>
      	<br>
      	<br>
      	<br>
      	<br>
      	<table border='0' cellpadding='3' cellspacing='0' width='auto' align='center'>
		<tr class='label'><td class='label' colspan='2'>&nbsp;</td></tr>

      		<tr>
      		   
      		    <td class='label' width='50%'><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
      		    <td class="fields" width='50%'><input type='text' name='Dely_Surg_Class_Code' id='Dely_Surg_Class_Code' value="<%=deliversurgical%>" <%=rd%> size='10' maxlength='10' onKeyPress="return CheckSpecChars(event)"><img src='../images/mandatory.gif' align='center'></img></td>
      		    
      		</tr>
      		<tr>
      		    <td class='label'><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
				<!--Modified by Ashwini on 24-Jan-2019 for ML-MMOH-CRF-1109-->
      		    <td class="fields"><input type='text' name='long_desc' id='long_desc' <%if(isModifyLongShortDescAppl){%>size='75' maxlength='75'<%}else{%>size='30' maxlength='30'<%}%> onBlur='makeValidString(this)' value="<%=longdesc%>" <%=rdall%> ><img src='../images/mandatory.gif' align='center'></img></td>
      		</tr>
      		<tr>
      		  
   		    <td class='label'><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
			<!--Modified by Ashwini on 24-Jan-2019 for ML-MMOH-CRF-1109-->
		    <td class="fields"><input type='text' name='short_desc' id='short_desc' <%if(isModifyLongShortDescAppl){%>size='35' maxlength='30'<%}else{%>size='15' maxlength='15'<%}%> onBlur='makeValidString(this)' value="<%=shortdesc%>" <%=rdall%>><img src='../images/mandatory.gif' align='center'></img></td>
      		</tr>
      		<tr>
      		     <td class='label'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
      		     <td class="fields"><input type='checkbox' name='eff_status' id='eff_status' value="E"  <%=chk%>></td>
      		</tr>
      		<tr class='label'><td class='label' colspan='2'>&nbsp;</td></tr>

      	</table>
      	</div>
    
     	<input type='hidden' name='function_name' id='function_name' value='<%=fnval%>'>

      	</form>
      	</body>
      	</html>

<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

