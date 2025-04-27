<%@ page import ="java.sql.*,webbeans.eCommon.*,eCA.SectionConfigDispFldBean, " contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<%
request.setCharacterEncoding("UTF-8");
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	/** added by kishore kumar n on 08/12/2009  */
	String imgUrl="";

	if(sStyle.equals("IeStyle.css"))
	{
	imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
	}
	/** ends here*/
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />

<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script language='javascript' src='../js/ConfigDispCrit.js'></script>

</head>
<body OnMouseDown="CodeArrest()" onKeyDown="lockKey()">
<br>
<form name="formConfigDispFlds" id="formConfigDispFlds"  action="../../servlet/eCA.ConfigDispCritServlet" method="post" target="messageFrame">
<div style="display: flex; justify-content: center;">
<table class="grid"  width='85%' align='center' id='tbl' style='visibility:visible'>
	<tr>
		<th class='columnheader' width='85%' align='left'><fmt:message key="eCA.ConfigureDisplayFields.label" bundle="${ca_labels}"/>&nbsp;&nbsp;&nbsp;
		<input type='radio' id='radioApplicable' name='readioAppl' id='readioAppl' value='A' checked onclick='checkApplicable(this);'/><fmt:message key="Common.Applicable.label" bundle="${common_labels}"/>&nbsp;&nbsp;&nbsp;
		<input type='radio' id='radioApplicable' name='readioAppl' id='readioAppl' value='NA' onclick='checkApplicable(this);'/><fmt:message key="Common.notapplicable.label" bundle="${common_labels}"/>
		</th> 		
	</tr>	
	<tr height='35%'>
		<td class='gridData'><fmt:message key="eCA.ResultCategory.label" bundle="${ca_labels}"/>&nbsp;
		 <select name='resultLnkType' id='resultLnkType' id ='resultLnkType' onchange='displayCongifDispFlds(this);' onmousewheel='return false;'> 
			<option selected>&nbsp;&nbsp;&nbsp;----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -----&nbsp;&nbsp;&nbsp;</option>
	<%
		String cat_query="select hist_rec_type, short_desc from cr_hist_rec_type order by 2";
		Connection con=null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try
		{
			try
			{
				con = ConnectionManager.getConnection(request);
				pst = con.prepareStatement(cat_query);
				rs = pst.executeQuery();

				while(rs.next())
				{
					out.println("<option value ="+rs.getString(1)+">"+rs.getString(2)+"</option>");
				}	
				
			}
			catch(Exception e)
			{
				//out.println("Exception in SectionConfigDispFlds.jsp"+e.toString());//COMMON-ICN-0181
				e.printStackTrace();
			}
			finally
			{
				if(rs != null)
				{
					rs.close();
				}
				if(pst != null)
				{
					pst.close();
				}
			}


	%>
			</select>
			 <img src="../../eCommon/images/mandatory.gif" /> 
		<span id='tdResultLinkedSub' style='display:none'>&nbsp;&nbsp;<fmt:message key="eCA.FutureEventType.label" bundle="${ca_labels}" />&nbsp;
		<select id='listResultLinkedSub' onchange='getSelected(this);'  onmousewheel='return false'>
		<option selected>&nbsp;&nbsp;&nbsp;----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -----&nbsp;&nbsp;&nbsp;</option>
		 <%
			try 
			{
				String query = "SELECT DISTINCT RESULT_SUB_CATEGORY ,DECODE(RESULT_SUB_CATEGORY,'RFRL','Referral','APPT','Appointments','FORD','Future Orders') res_sub_cat_desc FROM CA_LINK_CATEG_FIELD_LIST WHERE RESULT_CATEGORY='FEVT'";
				pst = con.prepareStatement(query);
				rs = pst.executeQuery();
				while(rs.next())
				{
					out.println("<option value ="+rs.getString(1)+">"+rs.getString(2)+"</option>");
				}
			}
			catch(Exception e)
			{
				//out.println("Exception in SectionConfigDispFlds.jsp"+e.toString());//COMMON-ICN-0181
				e.printStackTrace();
			}
			finally
			{
				if(rs != null)
				{
					rs.close();
				}
				if(pst != null)
				{
					pst.close();
				}
			
			}
			
		%>
		</select>
			<!-- </select><img src="../../eCommon/images/mandatory.gif" /> --></span>
			
			
				<span id='mhdTdResultLinkedSub' style='display:none'>&nbsp;&nbsp;<fmt:message key="Common.EventType.label" bundle="${common_labels}" />&nbsp;
		<select id='mhdListResultLinkedSub' onchange='getSelected(this);'  onmousewheel='return false'>
		<option selected>&nbsp;&nbsp;&nbsp;----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -----&nbsp;&nbsp;&nbsp;</option>
		 <%
			try 
			{
				String query = "SELECT DISTINCT RESULT_SUB_CATEGORY ,DECODE(RESULT_SUB_CATEGORY,'LMP','Last Menstrual Period (LMP)','USOD','Unsure of Date (USOD)') res_sub_cat_desc FROM CA_LINK_CATEG_FIELD_LIST WHERE RESULT_CATEGORY='MHD' ORDER BY 1";
				pst = con.prepareStatement(query);
				rs = pst.executeQuery();
				while(rs.next())
				{
					out.println("<option value ="+rs.getString(1)+">"+rs.getString(2)+"</option>");
				}
			}
			catch(Exception e)
			{
				//out.println("Exception in SectionConfigDispFlds.jsp"+e.toString());//COMMON-ICN-0181
				e.printStackTrace();
			}
			finally
			{
				if(rs != null)
				{
					rs.close();
				}
				if(pst != null)
				{
					pst.close();
				}
				if(con != null)
				{
					ConnectionManager.returnConnection(con,request);
				}
			}
			
		%>
		</select>
			</span>
			
		</td>
	</tr>
</table>
<br/>
<!-- added by kishore kumar n on 08/12/2009  -->
<%if(!imgUrl.equals("")){ %>
	 <img src='<%=imgUrl%>' width='100%' height='15'/> 
<%}%>
	<!--ends here -->	
	<input type='hidden' name='applicable' id='applicable' value='A'>
	<input type='hidden' name='resSubCategory' id='resSubCategory' value=''>	
</form>
</body>
<%
	}
	catch(Exception e)
	{
		//out.println("Exception in SectionConfigDispFlds.jsp"+e.toString());//COMMON-ICN-0181
		e.printStackTrace();
	}
	finally
	{
		if(con != null)
		{
			ConnectionManager.returnConnection(con,request);
		}
	}
						
%>

