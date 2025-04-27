<%
/* 
------------------------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History      	Name        		Rev.Date				Rev.Name			Description
--------------------------------------------------------------------------------------------------------------------------------
26/10/2020		IN067210			SIVABAGYAM M		26/10/2020				RAMESH G			ML-MMOH-CRF-1144
------------------------------------------------------------------------------------------------------------------------------------------------------
*/
%>

<%-- JSP Page specific attributes start --%>
<%@page import="java.sql.*,java.util.*,eCA.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>
<Html>
<Head>
	<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="Javascript" src="../../eCA/js/CARoleBasedAccessRightsforTaskList.js"></script>	
	<script language="javascript" src="../../eCommon/js/jquery-3.6.3.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</Head>

<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String mode			= request.getParameter( "mode" ) ;
	String function_id  = request.getParameter("function_id") ;
	String bean_id		= "CARoleBasedTaskList" ;
	String bean_name	= "eCA.CARoleBasedTaskList";
	java.util.Properties property = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) property.getProperty("LOCALE");

	String user_id=(String) session.getValue("login_user");	
	String facilityId=(String) session.getValue("facility_id");
	String facility_name="",facility_id="",categ_id="",categ_name="",selectd="";
	String selectd_facility=request.getParameter("facility")==null?"":request.getParameter("facility");
	String category=request.getParameter("category")==null?"":request.getParameter("category");
	String function=request.getParameter("function")==null?"":request.getParameter("function");
	
	CARoleBasedTaskList bean = (CARoleBasedTaskList)getObjectFromBean( bean_id, bean_name , session); 
	session.setAttribute("CARoleBasedTaskList", bean);
	 if(function.equals(""))
		 bean.getMap().clear();
	 
	 boolean isVitalSignDtls = false;
	Connection con=null;
	ArrayList<ArrayList<String>> allowedlist=new ArrayList<ArrayList<String>>();
	ArrayList<String> tasks=new ArrayList<String>();
%>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
	<form name="roleBasedTaskList" id="roleBasedTaskList" action="../../servlet/eCA.CARoleBasedTaskListServlet" method="post" >
		<Table  class ='grid'  width='90%' align="right" style="margin-right: 80px;">
		<%
		try{
			con= ConnectionManager.getConnection(request);
			isVitalSignDtls= eCommon.Common.CommonBean.isSiteSpecific(con, "CA","THIRDPARTY_VITALS_ACK");
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			PreparedStatement pstmt1=null;
			ResultSet rs1=null;
			String sql1="";
			if(!selectd_facility.equals("") ){
				LinkedHashMap<String, ArrayList<ArrayList<String>>> wholeMap=bean.getMap();
				if(!wholeMap.isEmpty() && wholeMap.containsKey(selectd_facility)){
					allowedlist=wholeMap.get(selectd_facility);
				}else{
					bean.getSelectionList(con, selectd_facility,isVitalSignDtls);
					wholeMap=bean.getMap();
					allowedlist=wholeMap.get(selectd_facility);
				}
			}
			 %>
		<thead>
		<tr>
			<td colspan="9" class='label' valign="center"><fmt:message key="Common.facility.label" bundle="${common_labels}"/> 
				<select id="facility_id" name="facility_id" id="facility_id" onchange='selectfacility(this)'>
		<option value="">&nbsp;&nbsp;&nbsp;&nbsp;-----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----------&nbsp;</option>
					<%
					String sql="select facility_id,SM_GET_DESC.SM_FACILITY_PARAM(FACILITY_ID,'"+locale+"', 1) facility_name,DECODE(FACILITY_ID,?,'Y','N') facility_YN  from sm_facility_for_user where appl_user_id=?";
					String select="";
					pstmt=con.prepareStatement(sql);
					pstmt.setString(1, facilityId);
					pstmt.setString(2, user_id);
					rs=pstmt.executeQuery();
	
					while(rs.next()){
						facility_id=rs.getString("facility_id");
						facility_name = rs.getString("facility_name");
						if(facility_id.equals(selectd_facility)){
							select="selected";
					%>
						<option <%=select%> value="<%=facility_id%>"  > <%=facility_name%></option>
					<%	}else{%>
						<option value="<%=facility_id%>"  > <%=facility_name%></option>
					<%	}%>
					<%} %>
				</select>
				<input type="hidden" name="facility_id" id="facility_id"  id="facility_id" value='<%=selectd_facility%>'/>
			</td>
		</tr>
		</thead>
		<tr>
			<td colspan="9" >&nbsp;</td>
		</tr>
		<%if(!selectd_facility.equals("")){%>
		<tbody id='caRoleSelect'>
			<tr>		
				<td class='COLUMNHEADER' width='25%'>Practitioner Type</td>
				<td class='COLUMNHEADER' width='6%'><fmt:message key="eOR.SpecimenOrder.label" bundle="${or_labels}"/></td>
				<td class='COLUMNHEADER' width='6%'><fmt:message key="Common.RegisterOrder.label" bundle="${common_labels}"/></td>
				<td class='COLUMNHEADER' width='6%'><fmt:message key="Common.ResultReporting.label" bundle="${common_labels}"/></td>
				<td class='COLUMNHEADER' width='6%'><fmt:message key="eCA.MedAdmin.label" bundle="${ca_labels}"/></td>
				<td class='COLUMNHEADER' width='6%'><fmt:message key="Common.Intervention.label" bundle="${common_labels}"/></td>
				<td class='COLUMNHEADER' width='6%'><fmt:message key="eCA.BloodUnitCons.label" bundle="${ca_labels}"/></td>				
				<td class='COLUMNHEADER' width='6%'><fmt:message key="eCA.PendingConsent.label" bundle="${ca_labels}"/></td>
				<%if(isVitalSignDtls){ %>
				<td class='COLUMNHEADER' width='6%'><fmt:message key="eCA.InterVitalSignData.label" bundle="${ca_labels}"/></td>
				<%}%>
				<td class='COLUMNHEADER' width='20%'>Order Catagory</td>
				
			</tr>
			<%
			for(int i=0;i<allowedlist.size();i++) {
				tasks=allowedlist.get(i);
				%>				
				<tr>
					<td class='gridData'><%=tasks.get(9)%></td>
					<td class='gridData'><input type="checkbox" name="checkSepci<%=i%>" id="checkSepci<%=i%>"  <%if(tasks.get(1).equals("Y")){%> checked <%}%> value="<%=tasks.get(1)%>" onclick="selectedList('1',this,'<%=i%>','<%=tasks.get(0)%>')"/></td>	
					<td class='gridData'><input type="checkbox" name="checkRegister<%=i%>" id="checkRegister<%=i%>" <%if(tasks.get(2).equals("Y")){%> checked <%}%>  value="<%=tasks.get(2)%>"  onclick="selectedList('2',this,'<%=i%>','<%=tasks.get(0)%>')"/></td>
					<td class='gridData'><input type="checkbox" name="checkresult<%=i%>" id="checkresult<%=i%>"  <%if(tasks.get(3).equals("Y")){%> checked <%}%> value="<%=tasks.get(3)%>" onclick="selectedList('3',this,'<%=i%>','<%=tasks.get(0)%>')"/></td>
					<td class='gridData'><input type="checkbox" name="checkmed<%=i%>" id="checkmed<%=i%>"  <%if(tasks.get(4).equals("Y")){%> checked <%}%> value="<%=tasks.get(4)%>"  onclick="selectedList('4',this,'<%=i%>','<%=tasks.get(0)%>')"/></td>
					<td class='gridData'><input type="checkbox" name="checkinterv<%=i%>" id="checkinterv<%=i%>"  <%if(tasks.get(5).equals("Y")){%> checked <%}%> value="<%=tasks.get(5)%>" onclick="selectedList('5',this,'<%=i%>','<%=tasks.get(0)%>')"/></td>
					<td class='gridData'><input type="checkbox" name="checkblood<%=i%>" id="checkblood<%=i%>"  <%if(tasks.get(6).equals("Y")){%> checked <%}%> value="<%=tasks.get(6)%>" onclick="selectedList('6',this,'<%=i%>','<%=tasks.get(0)%>')"/></td>
					<td class='gridData'><input type="checkbox" name="checkpendcon<%=i%>" id="checkpendcon<%=i%>" <%if(tasks.get(7).equals("Y")){%> checked <%}%>  value="<%=tasks.get(7)%>" onclick="selectedList('7',this,'<%=i%>','<%=tasks.get(0)%>')"/></td>
					<%if(isVitalSignDtls) {%>
					<td class='gridData'><input type="checkbox" name="checkvitals<%=i%>" id="checkvitals<%=i%>" <%if(tasks.get(8).equals("Y")){%> checked <%}%>  value="<%=tasks.get(8)%>" onclick="selectedList('8',this,'<%=i%>','<%=tasks.get(0)%>')"/></td>
					<%}%>
					<td class='gridData'> 
						<select name="category<%=i%>" id="category<%=i%>" onchange="selectCategory(this,'<%=i%>')">
							<option value="">&nbsp;----------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------------------&nbsp;</option>
							<%
							 sql1="select order_category,short_desc description from or_order_category";
							pstmt1=con.prepareStatement(sql1);
							rs1=pstmt1.executeQuery();
							while(rs1.next())
							{
								categ_id=rs1.getString("order_category");
								categ_name=rs1.getString("description");
								if(tasks.get(10).equals(categ_id)){
									selectd="selected";
									%>
								<option <%=selectd%> value="<%=categ_id%>" > <%=categ_name%></option>
								<%
								}else{ %>
									<option value="<%=categ_id%>" > <%=categ_name%></option>
									<%} 
									}%>
							</select>
							</td>
					</tr>
								<input type="hidden" name="category<%=i%>" id="category<%=i%>" value=''/>
						<%}%>
			<%
			if(pstmt1!=null)
				pstmt1.close();
			if(rs1!=null)
				rs1.close();
			if(pstmt!=null)
				pstmt.close();
			if(rs!=null)
				rs.close();
			}
			%>			
			</tbody>
			<input type="hidden" name="TaskMap" id="TaskMap" value='<%=bean.getMap().toString()%>' />
 		</Table>	
	</form>	
	<%}catch(Exception e){
		e.printStackTrace();
	}
	finally
	{
		if(con!=null)ConnectionManager.returnConnection(con,request);
		
	}
		putObjectInBean(bean_id,bean,session);
	%>
</body>
</html>

