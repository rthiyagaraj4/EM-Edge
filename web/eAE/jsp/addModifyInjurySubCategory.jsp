<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>

<head>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eAE/js/InjurySubCategory.js'  language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



<%
	String categorycode="";
	String categoryshortdesc="";
	String subcategorycode="";
	String subcategorylongdesc="";
	String subcategoryshortdesc="";
	String eff_status="";
	String sourceid="";

	String s="";
	String rdonly="";
	String fnval="insert";
	String def="checked";

	Connection conn = null;
	PreparedStatement stmt=null;
	PreparedStatement stmt1=null;
	ResultSet rset=null;
	ResultSet rset1=null;

	
	

	try
	{	
	    request.setCharacterEncoding("UTF-8");
		request= new XSSRequestWrapper(request);
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Content-Type-Options", "nosniff");
		
	    conn = ConnectionManager.getConnection(request);
	    
	    categorycode=request.getParameter("inj_category_code");
		subcategorycode=request.getParameter("inj_subcategory_code");

        sourceid = request.getParameter("source");
		if(sourceid==null)
		sourceid="";
	    if(subcategorycode!=null && categorycode!=null)
	    {
	       	stmt = conn.prepareStatement("SELECT IC.INJ_CATEGORY_CODE, IC.LONG_DESC 	INJ_CATEGORY_LONG_DESC, IC.SHORT_DESC	INJ_CATEGORY_SHORT_DESC, ISC.INJ_SUBCATEGORY_CODE, ISC.LONG_DESC	INJ_SUBCATEGORY_LONG_DESC, ISC.SHORT_DESC	INJ_SUBCATEGORY_SHORT_DESC, ISC.EFF_STATUS EFF_STATUS FROM  AE_INJURY_CATEGORY 	IC, AE_INJURY_SUBCATEGORY     ISC WHERE  ISC.INJ_CATEGORY_CODE = IC.INJ_CATEGORY_CODE and ISC.inj_subcategory_code=? and ISC.inj_category_code=? ");

			stmt.setString(1,subcategorycode);
			stmt.setString(2,categorycode);

	    	rset=stmt.executeQuery();
	    	if(rset != null)
	    	{
	    		   rdonly="readonly";
	    		   fnval="modify";
			   rset.next();
			   categoryshortdesc=rset.getString("inj_category_short_desc");
			   subcategorycode = rset.getString("inj_subcategory_code");
			   subcategorylongdesc = rset.getString("inj_subcategory_long_desc");
			   subcategoryshortdesc = rset.getString("inj_subcategory_short_desc");
			   eff_status=rset.getString("eff_status");
			   if(eff_status.equals("D"))
			   	s="readonly";
    		}
       }
	
	if(subcategorycode==null)
		subcategorycode="";
%>
</head>

	<body   onLoad="FocusFirstElement();" OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>
	<form name='subcategory_form' id='subcategory_form' action='../../servlet/eAE.InjurySubCategoryServlet' method='post' target='messageFrame'>

	<div>
	<br><br><br><br>
	<table border='0' cellpadding='3' cellspacing='0' width='90%' align='center'>
	<tr>
		<td colspan='2' height='5'><td>
	</tr>

	<tr>
<%
	      if(sourceid.equals("Insert"))
	      {

%>
		      <td  class="label" width='50%'><fmt:message key="Common.CategoryCode.label" bundle="${common_labels}"/></td>
			  <td class='field'  width='50%'><select name="inj_category_code" id="inj_category_code" >
		  	  <OPTION VALUE=''>&nbsp;&nbsp;&nbsp;----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -----&nbsp;&nbsp;&nbsp;


<%
       	      stmt1 = conn.prepareStatement("Select inj_category_code,short_Desc from ae_injury_category where eff_status='E' order by upper(Short_desc)");
           
		      rset1 = stmt1.executeQuery();
		try
			{
			    if( rset1 != null )
					{
				         while( rset1.next() )
							{
							     String categorycode1 = rset1.getString( "inj_category_code" ) ;
							     String categorydesc1 = rset1.getString( "short_desc" ) ;


								if ( categorycode1.equals( categorycode ) )
									out.println( "<option value=\"" + categorycode1 + "\" SELECTED > "+ categorydesc1);
								else
					 		        out.println( "<option value=\"" + categorycode1 + "\" >" + categorydesc1 ) ;
							}
					}
			}
		catch(Exception e)
			{
			e.printStackTrace();
			}
	     }
	     else
	     {
%>
			<td   class="label" width='50%'><fmt:message key="Common.CategoryCode.label" bundle="${common_labels}"/></td>
			<td class='field'  width='50%'>
<%
			out.println("<input type='hidden' name='inj_category_code' id='inj_category_code' value=\"" + categorycode + "\" >") ;
			out.println("<input type='text' name='inj_category_short_desc' id='inj_category_short_desc' value=\"" + categoryshortdesc + "\" size='15'maxlength='15' readonly>") ;
	 	 }

%>
   			</select>
   				<img src='../../eCommon/images/mandatory.gif' ></img>
   			</td>
			</tr>

			<tr>
   	   			<td  class='label' width='50%'><fmt:message key="eAE.SubCategoryCode.label" bundle="${ae_labels}"/></td>
    			<td class='field' width='50%'>
    	   		<input type='text' onKeyPress="return CheckForSpecChars(event)"  name='inj_subcategory_code' id='inj_subcategory_code' value="<%=subcategorycode%>" size='10'maxlength='10' onBlur=ChangeUpperCase(this); <%=rdonly%> >
				<img src='../../eCommon/images/mandatory.gif' ></img> </td>
			</tr>
			<tr>
	    		<td  class='label' width='50%'><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
      	     	<td class='field' width='50%'>
             	<input type='text' name='inj_subcategory_long_desc' id='inj_subcategory_long_desc' value="<%=subcategorylongdesc%>" size='30' onBlur="makeValidString(this)" maxlength='30' style='{ font-size: ;}'  <%out.print(s);%>>&nbsp;<img src='../../eCommon/images/mandatory.gif' ></td>
		    </tr>
			

			<tr>
				<td   class='label' width='50%'><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
				<td  class='field'  width='50%'>
      			<input type='text' name='inj_subcategory_short_desc' id='inj_subcategory_short_desc' value="<%=subcategoryshortdesc%>"  onBlur="makeValidString(this)"  size='15' maxlength='15' <%out.print(s);%>><img src='../../eCommon/images/mandatory.gif' ></td>
			</tr>

			<tr>
				<td   class='label' width='50%'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
	    <%
	    	if(eff_status.equals("D"))
				   def="";
	    %>
	   		<input type='hidden' name='checked1' id='checked1'  value='<%=def%>'>
	     	<td    class='field'  width='50%'><input type='checkbox' name='eff_status' id='eff_status' value='E'  <%=def%>>&nbsp;</td>
  	    <%
  	    	s="";
  	    %>
		  	</tr>
        <tr><td colspan='2' height='5'></td></tr>
		</table>
		</div>
			<input type='hidden' name='function' id='function' value='<%=fnval%>'>
			<input type='hidden' name='function_name' id='function_name' value="<%=fnval%>">
<%

	if(rset!=null) rset.close();
	if(stmt!=null) stmt.close();

	if(rset1!=null) rset1.close();
	if(stmt1!=null) stmt1.close();

			}catch(Exception e)
		{
			e.printStackTrace();
		}

	finally
	{
		if(conn!=null)		
		ConnectionManager.returnConnection(conn,request);

	}

%>		

</form>
</body>
</html> 

