<!DOCTYPE html>
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%
	request.setCharacterEncoding("UTF-8");
%>
<% 
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
%>

  <head>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src="../../eCommon/js/common.js" language="javascript"></script>
	<script src='../js/NatureOfDelivery.js' language='javascript'></script>
</head>
 <body OnMouseDown='CodeArrest()' onKeyDown='lockKey();' onLoad='FocusFirstElement(); if(!document.forms[0].nod_type.value)document.forms[0].DELIVERY_INDICATOR.value="O";'>
     
<%
	Connection con = null;
    PreparedStatement pstmt		=null;
	ResultSet rset			=null;

   String nodtype			="";
   String longdesc			="";
   String shortdesc		="";
   String effstatus			="";
   String delivery_indicator			="";
   String fnval					="insert";
   //String sql					="";
   String chk					="checked";
   String dis					="";
   String rd						="";
   String rdall					="";
   String sel_n					="";
   String sel_s					="";
   String sel_o					="";
	
	//Added by Ashwini on 24-Jan-2019 for ML-MMOH-CRF-1109
	Boolean isModifyLongShortDescAppl = false;
%>
<%
	nodtype=request.getParameter("nod_type")==null?"":request.getParameter("nod_type");
     
				try{
					con = ConnectionManager.getConnection(request);

					isModifyLongShortDescAppl =  eCommon.Common.CommonBean.isSiteSpecific(con,"MP","MODIFY_LONG_SHORT_DESC");//Added by Ashwini on 24-Jan-2019 for ML-MMOH-CRF-1109

					if(!nodtype.equals(""))
					{

					pstmt = con.prepareStatement("select long_desc,short_desc,eff_status,DELIVERY_INDICATOR from mp_nod_type where nod_type='"+nodtype+"'");
					rset = pstmt.executeQuery();
					 if(rset.next())
					 {
						rd = "readonly";
						fnval = "modify";
						longdesc=rset.getString("long_desc");
						shortdesc=rset.getString("short_desc");
						effstatus = rset.getString("eff_status");
						delivery_indicator = rset.getString("DELIVERY_INDICATOR");
					 }
					 if(effstatus.equals("E")) chk = "checked";
					 else { rdall = "readonly";chk = "";dis="disabled";}
					 
					 if(delivery_indicator==null )delivery_indicator="";                     
					 
					 if(delivery_indicator.equals("N")) sel_n="selected";
					 else sel_n="";
					 if(delivery_indicator.equals("C")) sel_s="selected";
					 else sel_s="";
					 if(delivery_indicator.equals("O")) sel_o="selected";
					 else sel_o="";
					}

			  }catch(Exception e){out.println(e.toString());}
			  finally{
				if(rset!=null) 	     	rset.close();
				if(pstmt!=null) 	    pstmt.close();
				if(con!=null) ConnectionManager.returnConnection(con,request);
				}
			
%>

      	<form name='NatureOfDelivery_form' id='NatureOfDelivery_form' action='../../servlet/eMP.NODTypeServlet' method='post' target='messageFrame'>
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
		<tr class='label'><td colspan='2' class='label'>&nbsp;</td></tr>

      		<tr>
      		    <td class='label' width='50%'><fmt:message key="eMP.DeliveryType.label" bundle="${mp_labels}"/></td>
      		    <td class="fields" width='50%'><input type='text' name='nod_type' id='nod_type' value="<%=nodtype%>" <%=rd%> size='2' maxlength='2' OnBlur='ChangeUpperCase(this);' onKeyPress="return CheckSpecChars(event)"><img src='../images/mandatory.gif' align='center'></img></td>
      		</tr>

     		<tr>
      		    <td  class='label'><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
				<!--Modified by Ashwini on 24-Jan-2019 for ML-MMOH-CRF-1109-->
      		    <td class="fields"><input type='text' name='long_desc' id='long_desc' <%if(isModifyLongShortDescAppl){%>size='75' maxlength='75'<%}else{%>size='30' maxlength='30'<%}%> onBlur='makeValidString(this)' value="<%=longdesc%>" <%=rdall%> ><img src='../images/mandatory.gif' align='center'></img></td>
      		</tr>
     		<tr>
      		   <td class='label'><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
			   <!--Modified by Ashwini on 24-Jan-2019 for ML-MMOH-CRF-1109-->
				<td class="fields"><input type='text' name='short_desc' id='short_desc' <%if(isModifyLongShortDescAppl){%>size='35' maxlength='30'<%}else{%>size='15' maxlength='15'<%}%> onBlur='makeValidString(this)' value="<%=shortdesc%>" <%=rdall%>><img src='../images/mandatory.gif' align='center'></img></td>
		    </tr>
             <tr>
      		    <td class='label'><fmt:message key="eMP.DeliveryIndicator.label" bundle="${mp_labels}"/></td>
				<td class="fields"><select name="DELIVERY_INDICATOR" id="DELIVERY_INDICATOR" <%=dis%>>
				<option value=''>----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------</option> 
				<option value='N' <%=sel_n%>><fmt:message key="Common.Normal.label" bundle="${common_labels}"/></option> 
				<option value='C' <%=sel_s%>><fmt:message key="eMP.CSection.label" bundle="${mp_labels}"/></option> 
				<option value='O' <%=sel_o%>><fmt:message key="Common.others.label" bundle="${common_labels}"/></option> 
				</td>
		    </tr>

      		<tr>
      		    
      		     <td class='label'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
      		     <td class="fields"><input type='checkbox' name='eff_status' id='eff_status' value="E"  <%=chk%>></td>
      		</tr>

      		<tr class='label'><td colspan='2' class='label'>&nbsp;</td></tr>

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

