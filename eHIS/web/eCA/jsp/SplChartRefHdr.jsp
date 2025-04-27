<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.*,java.util.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"  %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
	<head>
		<title>SplChartRefHdr</title>
		<script src='../../eCA/js/SplChartRef.js' language='javascript'></script>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
		<script language='javascript'>
		
		function checkChartType()
		{
			
			var errors = " " ;
			parent.parent.messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+errors ;
			document.SplChartRefHdrForm.submit();
		}

		function setDetailsPage(page,type1,type2,type3,type4,type5)
		{
			
			if(type2 != undefined && type2 != '' && type4 != undefined && type4 != '' && type4 != '*A')
			{
				 if(page=='display')
				 {
					 parent.frameSplChartRefDtl.location.href='../../eCA/jsp/SplChartRefDtl.jsp?display=yes&spl_chart_type='+type1+'&element_type='+type2+'&gender='+type3+'&spl_chart_group='+type4+'&xAxis_element='+type5;
				 }
				
				 else if(page=='list')
				 {
					 parent.frameSplChartRefDtl.location.href='../../eCA/jsp/SplChartRefDtl.jsp?display=no&spl_chart_type='+type1+'&element_type='+type2+'&gender='+type3+'&spl_chart_group='+type4+'&xAxis_element='+type5;
				 }
				 else
				 {
					parent.frameSplChartRefDtl.location.href='../../eCommon/html/blank.html';
				 }
			}
			else
			 {
				parent.frameSplChartRefDtl.location.href='../../eCommon/html/blank.html';
			 }
		}
		
  <%
  request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
  	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rset = null;
	String sql = "";
	
	String xAxixElementValue="*K";
	String yAxisElementValue = "*";
	String spl_chart_type = "";
	String spl_chart_group = "";
	String element_type = "";
	String xAxis_element="";//058006	
	String gender = "";
	boolean flag = false;
	String group_type = "",group_desc = "",group_type1="";

	spl_chart_type = request.getParameter("spl_chart_type")==null?"":request.getParameter("spl_chart_type");
	spl_chart_group = request.getParameter("spl_chart_group")==null?"":request.getParameter("spl_chart_group");
	element_type   = request.getParameter("element_type")==null?"*":request.getParameter("element_type");
	gender		   = request.getParameter("gender")==null?"":request.getParameter("gender");
	group_type1 = request.getParameter("spl_chart_group")==null?"":request.getParameter("spl_chart_group");
	xAxis_element= request.getParameter("xAxis_element")==null?"*K":request.getParameter("xAxis_element");//058006
	
	
	try{
		con = ConnectionManager.getConnection(request);
	} 
	catch(Exception e){
		out.println("Exception in try of SplChartRefHdr.jsp"+e.toString());
	}

	if(spl_chart_type!=null && !(spl_chart_type.equals("")))
	{
	try
	{
		sql = "SELECT SPL_CHART_TYPE_GRP_APPL_YN FROM CA_SPL_CHART_TYPE WHERE SPL_CHART_TYPE=?";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1,spl_chart_type);
		rset  = pstmt.executeQuery();
		String appl = "N";
		if(rset.next())
			appl = rset.getString(1);
		if(rset!=null)  rset.close(); 
		if(pstmt!=null)  pstmt.close();
		if(appl.equals("Y"))
			flag = true;
		else
			flag = false;	

		if(flag==false)
			spl_chart_group = "*A";

		sql = "SELECT SPL_CHART_TYPE FROM CA_SPL_CHART_REF_VALUE WHERE SPL_CHART_TYPE=? AND ELEMENT_TYPE=? AND GENDER=? AND SPL_CHART_TYPE_GRP_ID=? AND X_ELEMENT_TYPE = ?";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1,spl_chart_type);
		pstmt.setString(2,element_type);
		pstmt.setString(3,gender);
		pstmt.setString(4,spl_chart_group);
		pstmt.setString(5,xAxis_element);
		rset  = pstmt.executeQuery();
	
		if(rset.next())
		{
		%>
			setDetailsPage('display','<%=spl_chart_type%>','<%=element_type%>','<%=gender%>','<%=spl_chart_group%>','<%=xAxis_element%>');
		<%
		}
		else
		{
		%>
		    setDetailsPage('list','<%=spl_chart_type%>','<%=element_type%>','<%=gender%>','<%=spl_chart_group%>','<%=xAxis_element%>');
		<%
		}	
		if(rset!=null) rset.close();
		if(pstmt!=null) pstmt.close();
	} 
	catch(Exception e){
		//out.println("Exception in try of SplChartRefHdr.jsp"+e.toString());//COMMON-ICN-0181
		e.printStackTrace();//COMMON-ICN-0181
	}
	}
	else
	{%>
			setDetailsPage('empty','');
	<%
		}	
	%>
	</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>

<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
/** added by kishore kumar n on 27/01/2009  */
	String imgUrl="";
	if(sStyle.equals("IeStyle.css"))
	 {
			imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
	 }

	 /** ends here*/

	


%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
</head>


<body OnMouseDown="CodeArrest()"  onKeyDown="lockKey()">
<form name='SplChartRefHdrForm' id='SplChartRefHdrForm' method="post">
<table width='98%' border='0' cellspacing='0' cellpadding='4' align='center' >
		<tr>
				<td class='label' ><fmt:message key="Common.Chart.label" bundle="${common_labels}"/> <fmt:message key="Common.type.label" bundle="${common_labels}"/></td>
				<td class='fields' >
				 <SELECT name="spl_chart_type" id="spl_chart_type" style="width: 150px" onchange='checkChartType()'> 
				
		<%
			try{
				sql = "Select SPL_CHART_TYPE , SPL_CHART_TYPE_DESC From CA_SPL_CHART_TYPE where eff_status='E' Order by SPL_CHART_TYPE_DESC";
				pstmt = con.prepareStatement(sql);
				rset  = pstmt.executeQuery();
				String chart_type = null;
				String chart_desc = null;
				if(rset!=null){
					chart_type = "";
					chart_desc = ""; %>
				<option value = '' selected >-----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----</option>
				<%
				while(rset.next()){
					chart_type = rset.getString("SPL_CHART_TYPE")==null?"":rset.getString("SPL_CHART_TYPE");
					chart_desc = rset.getString("SPL_CHART_TYPE_DESC")==null?"":rset.getString("SPL_CHART_TYPE_DESC");
				%>
					<option value = <%=chart_type%>  <%if(chart_type.equals(spl_chart_type))out.print("selected");%>><%=chart_desc%></option> 
				<%
					}
				}
				if(rset!=null) rset.close();
				if(pstmt!=null) pstmt.close();
		%>
		</SELECT><img src='../../eCommon/images/mandatory.gif'></td>
<%
if(flag)
{
%>
	</tr>
	<td class='label' ><fmt:message key="Common.Chart.label" bundle="${common_labels}"/> <fmt:message key="Common.Group.label" bundle="${common_labels}"/></td>
		<td class='fields' >
		<SELECT name="spl_chart_group" id="spl_chart_group" style="width: 150px" onchange='checkChartType()'>
		<%
			sql = "SELECT SPL_CHART_TYPE_GRP_ID, SPL_CHART_TYPE_GRP_DESC FROM  CA_SPL_CHTY_GRP_LANG_VW WHERE SPL_CHART_TYPE=? and LANGUAGE_ID=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,spl_chart_type);
			pstmt.setString(2,locale);
			rset  = pstmt.executeQuery();
			if(rset!=null){
				group_type = "";
				group_desc = ""; %>
			<option value = '' selected >-----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----</option>
			<%
			while(rset.next()){
				group_type = rset.getString("SPL_CHART_TYPE_GRP_ID")==null?"":rset.getString("SPL_CHART_TYPE_GRP_ID");
				group_desc = rset.getString("SPL_CHART_TYPE_GRP_DESC")==null?"":rset.getString("SPL_CHART_TYPE_GRP_DESC");
			%>
				<option value = <%=group_type%>  <%if(group_type.equals(group_type1))out.print("selected");%>><%=group_desc%></option> 
			<%
			}
		}
		if(rset!=null) rset.close();
		if(pstmt!=null) pstmt.close(); %>
		</SELECT><img src='../../eCommon/images/mandatory.gif'></td>

<% }	else
		{
		%>

	<INPUT type='hidden' name='spl_chart_group' id='spl_chart_group' value='*A'/>	
		
<% } %>
		<!--058006 start-->
<tr>				
				<td width='15%' class='label' ><fmt:message key="eCA.Xaxiselement.label" bundle="${ca_labels}"/> </td>
				<td width='35%'   class='fields'> 
					<select name="xAxis_element" id="xAxis_element" style="width: 110px" onchange='validateElementType(this,document.forms[0].xAxis_element1);'>
							<%
							sql = "SELECT ELEMENT_TYPE, ELEMENT_TYPE_DESC FROM CA_SPL_CHART_ELEMENT_TYPE WHERE EFF_STATUS='E' ORDER BY ELEMENT_TYPE_DESC";
							pstmt = con.prepareStatement(sql);							
							rset  = pstmt.executeQuery();
							if(rset!=null){
								String xElement_Type = "";
								String xElement_Desc=""; %>
								<option value = '*K' selected ><fmt:message key="Common.age.label" bundle="${common_labels}"/></option>
								<%
								while(rset.next()){
									xElement_Type = rset.getString("ELEMENT_TYPE")==null?"":rset.getString("ELEMENT_TYPE");
									xElement_Desc = rset.getString("ELEMENT_TYPE_DESC")==null?"":rset.getString("ELEMENT_TYPE_DESC");
								%>
								<option value = <%=xElement_Type%>  <%if(xElement_Type.equals(xAxis_element)){out.print("selected");xAxixElementValue=xElement_Type;}%>><%=xElement_Desc%></option> 
								<%
								}
							}
							if(rset!=null) rset.close();
							if(pstmt!=null) pstmt.close();						

					%>
							</select><img src='../../eCommon/images/mandatory.gif'></td>
			                <input type='hidden' name='xAxis_element1' id='xAxis_element1' value='<%=xAxixElementValue%>' />
				<td>
			</tr><!--058006 end-->
		<tr>
				<td class='label' ><fmt:message key="eCA.Yaxiselement.label" bundle="${ca_labels}"/>  </td>
				<td class='fields' >
				<SELECT name="element_type" id="element_type" style="width: 110px" onchange='validateElementType(this,document.forms[0].yAxis_element);'>
		<%
				sql = "SELECT ELEMENT_TYPE, ELEMENT_TYPE_DESC FROM CA_SPL_CHART_ELEMENT_TYPE WHERE EFF_STATUS='E' ORDER BY ELEMENT_TYPE_DESC";
				pstmt = con.prepareStatement(sql);
				rset  = pstmt.executeQuery();
				if(rset!=null){
					String element_type1 = "";
					String element_desc1 = ""; %>
				<option value = '*' selected >-----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----</option>
				<%
				while(rset.next()){
					element_type1 = rset.getString("ELEMENT_TYPE")==null?"":rset.getString("ELEMENT_TYPE");
					element_desc1 = rset.getString("ELEMENT_TYPE_DESC")==null?"":rset.getString("ELEMENT_TYPE_DESC");
				%>
					<option value = <%=element_type1%>  <%if(element_type1.equals(element_type)){out.print("selected");yAxisElementValue=element_type1;}%>><%=element_desc1%></option> 
				<%
					}
				}
				if(rset!=null) rset.close();
				if(pstmt!=null) pstmt.close();
		%>
		</SELECT><img src='../../eCommon/images/mandatory.gif'></td>
		<input type='hidden' name='yAxis_element' id='yAxis_element' value='<%=yAxisElementValue%>' />
		</tr>
		<%
		String msel = "",fsel = "",asel = "";
		if(gender.equals("M"))
			msel = "selected";
		else if(gender.equals("F"))
			fsel = "selected";
		else if(gender.equals("*"))
			asel = "selected";
		
		%>		
		<tr>
			<td class='label' ><fmt:message key="Common.gender.label" bundle="${common_labels}"/></td>
			<td class='fields' >
				<SELECT name="gender" id="gender" style="width: 110px"onchange='checkChartType()'>
					<option value = 'M' <%=msel%> selected><fmt:message key="Common.male.label" bundle="${common_labels}"/></option>
					<option value = 'F' <%=fsel%> ><fmt:message key="Common.female.label" bundle="${common_labels}"/></option>
					<!--<option value = '*' <%=asel%> ><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>-->
			</SELECT><img src='../../eCommon/images/mandatory.gif'></td>
		</tr>

	</table>
	<%	
		} 
		catch(Exception e){
			//out.println("Exception in try of SplChartRefHdr.jsp"+e.toString());//COMMON-ICN-0181
			e.printStackTrace();//COMMON-ICN-0181
		}
		finally{
			if(con!=null) ConnectionManager.returnConnection(con,request);
		}
	%>
	<!-- added by kishore kumar n on 27/01/2009  -->
<%if(!imgUrl.equals("")){ %>
<img src='<%=imgUrl%>' width='100%' height='15'/> 
<%}%>
<!--ends here -->
	</form>
 </body>
</html>

