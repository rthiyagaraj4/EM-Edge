<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*,eCommon.Common.*,org.json.simple.*,eCommon.XSSRequestWrapper" %>
<html>

<head>
  <%String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

  <link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
  <script language='javascript' src='../../eOR/js/RulestoDfltOrdercatPract.js'></script>
  <script language='javascript' src='../../eCommon/js/common.js'></script>
  <script language='javascript' src='../../eCommon/js/ValidateControl.js'></script> 
  <script language='javascript' src='../../eCommon/js/CommonLookup.js' > </script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
 </head>
  <body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
	 <form name="DfltorderCategoryPract" id="DfltorderCategoryPract" action="../../servlet/eOR.RulestoDfltOrdercatPractServlet" method="post" target="messageFrame">
		<BR>
 <%
	 Connection con	=	null;
	 PreparedStatement pstmt =	null;
	 ResultSet rs1 =	null ;
	 String class_value	= "QRYEVEN";
	 String select_value = "";
	 int n	= 0;
	 String facility_id ="";
	 String practitioner_type ="";
	 String practitioner_desc ="";
	 String short_desc ="";
	 String order_catalg ="";
	 String order_cat ="";
	 String facid = (String) session.getValue( "facility_id" ) ;
	 String fac	 =	checkForNull(request.getParameter("fac_id"));
	 	 
	 
try
{
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sql                 =  "";
	con					       =	ConnectionManager.getConnection(request);
	JSONArray order_categ=   null;

	order_categ=CommonBean.getOrderCategory(con); 

	//sql="SELECT a.practi_type, a.order_category, b.desc_sysdef,CASE WHEN a.order_category = 'ALL' THEN 'N' ELSE 'Y' END selected_yn FROM or_one_day_cont_order a, am_pract_type b WHERE a.facility_id = '"+fac+"' AND a.practi_type = b.pract_type and b.eff_status = 'E' UNION SELECT pract_type, 'ALL' order_category, desc_sysdef, 'N' selected_yn FROM am_pract_type WHERE eff_status = 'E' AND pract_type NOT IN (SELECT a.practi_type FROM or_one_day_cont_order a, am_pract_type b WHERE a.facility_id = '"+fac+"' AND a.practi_type = b.pract_type and b.eff_status = 'E')";//common-icn-0180
	sql="SELECT a.practi_type, a.order_category, b.desc_sysdef,CASE WHEN a.order_category = 'ALL' THEN 'N' ELSE 'Y' END selected_yn FROM or_one_day_cont_order a, am_pract_type b WHERE a.facility_id = '"+fac+"' AND a.practi_type = b.pract_type and b.eff_status = 'E' UNION SELECT pract_type, 'ALL' order_category, desc_sysdef, 'N' selected_yn FROM am_pract_type WHERE eff_status = 'E' AND pract_type NOT IN (SELECT a.practi_type FROM or_one_day_cont_order a, am_pract_type b WHERE a.facility_id = ? AND a.practi_type = b.pract_type and b.eff_status = 'E')";//common-icn-0180

	pstmt = con.prepareStatement(sql);
	pstmt.setString(1, fac);//common-icn-0180
	rs1  = pstmt.executeQuery();
%>
	     <table  border="0" class='grid' width="50%" align="center">
		 
			<tr>

			<td class='columnheader' colspan=2><fmt:message key="Common.practitionertype.label" bundle="${common_labels}"/></td>
			<td class='columnheader' colspan=2><fmt:message key="Common.OrderCategory.label" bundle="${common_labels}"/></td>

			</table>
			<table border="1" class='grid'  align='center' width='50%'>

	<%
	  	while(rs1.next())
		{
			practitioner_type   = checkForNull(rs1.getString("PRACTI_TYPE"));
			practitioner_desc   = checkForNull(rs1.getString("DESC_SYSDEF"));
			order_cat   = checkForNull(rs1.getString("ORDER_CATEGORY"));

	      	if(class_value.equals("QRYEVEN"))
			class_value = "QRYODD";
			else
			class_value = "QRYEVEN";
		  %>

			<tr>
	     	<td class="<%=class_value%>"  width='53%' nowrap>&nbsp;<%=practitioner_desc%>&nbsp;</td>
			<td class='<%= class_value %>' nowrap><select name='strKey<%=n%>' id='strKey<%=n%>'>
			<option value='ALL'>--------------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------------------</option>
            <%   
			  
              for(int j=0; j<order_categ.size(); j++){
                   JSONObject jsonObj = (JSONObject) order_categ.get(j);
               
				   order_catalg = (String) jsonObj.get("order_category");
				   short_desc = (String) jsonObj.get("short_desc");
                     
				   if(order_cat.equals(order_catalg))	
			       { 
						select_value				=	"selected";
				   }else{ 

						select_value				=	"";							 
				   }

                   %>
					
				<option value='<%= order_catalg%>' <%=select_value%>><%= short_desc%></option>
					
						
	           <% } %>
			
			
			
			<input type='hidden' name='practitionertype<%=n%>' id='practitionertype<%=n%>' value='<%=practitioner_type%>'>
			
            </select></td></tr>
		
		  <%
		  n++;
		}
		
%>
</table>

<input type='hidden' name='n' id='n' value=<%=n%>>
<input type='hidden' name='ordercat' id='ordercat' value=''>
<input type='hidden' name='practtype' id='practtype' value=''>
<input type='hidden' name='fac' id='fac' value=<%=fac%>>


</form>
</body>
</html>
<%
	if(pstmt!=null) pstmt.close();
	if(rs1!=null)  rs1.close();
	}catch(Exception e )
		{
		//out.println("Error"+e);//common-icn-0181
		e.printStackTrace();//COMMON-ICN-0181
		}finally{
	 ConnectionManager.returnConnection(con,request);
}
%>
<%!
	
	public static String checkForNull(String inputString)
	{
		return( ((inputString==null) || (inputString.equals("null"))) ? "" : inputString );
	}

	public static String checkForNull(String inputString, String defaultValue)
	{
		return( ((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString );
	}

%>

