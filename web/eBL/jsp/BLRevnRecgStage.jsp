<!DOCTYPE html>
<%
/*
------------------------------------------------------------------------------------------------
Sr No        Version              Incident              SCF/CRF             	Developer Name
1            V200922               74105              NMC-JD-CRF-0011        	 Shikha Seth
2			 V210518			   17598			  Common-ICN-0034			 Mohana Priya K
------------------------------------------------------------------------------------------------
*/
%>
<%@page contentType="text/html;charset=UTF-8" import="java.sql.*,javax.naming.*,javax.rmi.*,java.io.*,java.util.Hashtable,java.util.ArrayList,java.util.HashMap,java.util.Enumeration,eBL.Common.*,eBL.*,eCommon.Common.*,webbeans.eCommon.*"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%>
<jsp:useBean id="xmlObj" scope="page" class="webbeans.eCommon.XMLStringParser" />
<%@page import="eBL.BLRevenueStageBean"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%!
     private String checkForNull(String inputString) {
 		return (inputString == null) ? "" : inputString;
 	}
%>

<%	
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";	
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="StyleSheet" href="../../eCommon/html/<%=sStyle%>" type="text/css"/>	
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
<script language="javascript" src="../../eCommon/js/CommonCalendar.js" ></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script language="JavaScript" src="../js/BLRevnRecgStage.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	
</head>
 <script>
function changevaluelist(e)
{
	var RowIndex=e.parentNode.parentNode.rowIndex;
	RowIndex+=-1;
	document.getElementById("p_fm_date"+RowIndex).value = "";	
	document.getElementById("p_to_date"+RowIndex).value = "";
}

function ordertypesel(e,rec){
	var RowIndex=e.parentNode.parentNode.rowIndex;
	RowIndex+=-1;
	var val = document.getElementById("order_type"+RowIndex).value;
	//	var strUser = val.options[val.selectedIndex].value;		
	if(rec.value==null){
		document.getElementById("Revenue_Stage"+RowIndex).value="BLD";
		var today = new Date();
		var date = (today.getDate()+1)+'/'+('0'+(today.getMonth()+1)).slice(-2)+'/'+today.getFullYear();
		document.getElementById("p_fm_date"+RowIndex).value=date;
	}		
	//String sql="select ORDER_TYPE_CODE,REV_SATGE,EFF_FROM,EFF_TO from BL_ORDER_REVENUE_STAGE";
} 
 </script>
 
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
<%
	request.setCharacterEncoding("UTF-8");

	String bean_id   = "Revenue_Stage" ;
	String isDisabled="disabled";

	String bean_name = "eBL.BLRevenueStageBean";	
	String locale		=	"";			
	String facilityId	=	"";		
	String FunctionId	=	"";
	
	BLRevenueStageBean bean = (BLRevenueStageBean)getBeanObject( bean_id,  bean_name, request ) ;
	bean.clear() ;
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));

	ArrayList Category_Data = new ArrayList();
	Connection connection	= null;
	//Connection conn	= null; //V210518
	PreparedStatement pstmt = null;
	//PreparedStatement pstmt1 = null; //V210518
	PreparedStatement stmt2 = null;
	//PreparedStatement ps = null; //V210518
	//ResultSet resultSet 	= null; //V210518
	//ResultSet resultSet1 	= null; //V210518
	ResultSet rs 	= null;
	ResultSet rs2 	= null;
	HttpSession httpSession = request.getSession(false);
	Properties p = (Properties)httpSession.getValue("jdbc");
	String strLoggedUser = p.getProperty("login_user");
	if(strLoggedUser == null) strLoggedUser="";
	
	try{	
		locale  = 	(String)session.getAttribute("LOCALE");
		facilityId =   (String) session.getValue( "facility_id" );
		String slClassValue = "";
		Category_Data = bean.getOrderCategory(facilityId);
		String[] record=null;
		connection = ConnectionManager.getConnection(request);
		String eff_from = null;
		String eff_to = null;
		String rev_stage= null;
		String ordertypcode= null;
		//String val=null;		
%>

<form name='Revenue_Stage' id='Revenue_Stage' method='post' target='messageFrame'>
<input type="hidden" name="mode" id="mode" value="insert"/>
<%
	//boolean flag=false;
		int rowdiff = 0;
		try{
			/*String sqlqry="select ((SELECT count(DISTINCT(ORDER_CATEGORY)) from BL_ORDER_REVENUE_STAGE where eff_to > trunc(sysdate) or eff_to is null) minus (SELECT count(*) from OR_ORDER_CATEGORY) ) as count from dual";
			String sqlqry="SELECT ((SELECT count(*) from OR_ORDER_CATEGORY) minus (SELECT count(*) from BL_ORDER_REVENUE_STAGE where eff_to > trunc(sysdate) or eff_to is null)) as RowCountResult from dual";*/
			String sqlqry="select ((SELECT count(DISTINCT(ORDER_CATEGORY)) from BL_ORDER_REVENUE_STAGE) minus (SELECT count(*) from OR_ORDER_CATEGORY) ) as count from dual";
			pstmt = connection.prepareStatement(sqlqry) ;
			rs = pstmt.executeQuery() ;
			while(rs != null && rs.next()){
				rowdiff = rs.getInt(1);
			} 
			/*if(rowdiff != 0){
				flag=false; //insert mode should happen
			}else{
			flag=true; } //modify mode should happen */
		if(rowdiff == 0){	
			%>
		<script>
			document.getElementById("mode").value="modify";
		</script>
		<%
			}
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				try{
				if(pstmt!=null) pstmt.close();	
				if(rs!=null) rs.close();	
				//con.close();		
				}catch(Exception e){
					e.printStackTrace();
					System.err.println("jsp exception===="+e.toString());
				}
			}
%>

<table  class="grid" width="100%">  <!-- IN:073854-->
<% if (Category_Data.size() > 0) { %>
	<tr>
		<td class="COLUMNHEADER" width="10%" style="text-align:center;">
			<fmt:message key="Common.OrderCategory.label" bundle="${common_labels}"/>
		</td>
		<td class="COLUMNHEADER" width="15%" style="text-align:center;">
			<fmt:message key="Common.longdescription.label" bundle="${common_labels}"/>
		</td>
		<td class="COLUMNHEADER" width="15%" style="text-align:center;">
			<fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/>
		</td>
		<td class="COLUMNHEADER" width="15%" style="text-align:center;">
			<fmt:message key="eBL.ORDER_TYPE.label" bundle="${bl_labels}"/>
		</td>
		<td class="COLUMNHEADER" width="15%" style="text-align:center;">
			<fmt:message key="eBL.Revenue_Stage.label" bundle="${bl_labels}"/>
		</td>
		<td class="COLUMNHEADER" width="15%" style="text-align:center;">
			<fmt:message key="eBL.VALID_FROM.label" bundle="${bl_labels}"/>
		</td>
		<td class="COLUMNHEADER" width="15%" style="text-align:center;">
			<fmt:message key="eBL.VALID_TO.label" bundle="${bl_labels}"/>
		</td>		
	</tr>
	<% } %>
	<%
		int ilRow=0;		
	%>
<!-- IN:073854-->
</table>
<div style="overflow-y: auto; height: 550px;">
<table id='Revenue_Stage_' class="grid" width="100%" >
<!-- IN:073854-->
<input name ='category_size' id ='category_size' type='hidden' value='<%=Category_Data.size()%>'>
<%		
	for(int i=0; i<Category_Data.size(); i++)
	{	
		record = (String [])Category_Data.get(i);			
		if(record[0].equals("null")||record[0].equals(" ")||record[0]==null)record[0]="";
		if(record[1].equals("null")||record[1].equals(" ")||record[1]==null)record[1]="";
		if(record[2].equals("null")||record[2].equals(" ")||record[2]==null)record[2]="N";
		ordertypcode= checkForNull(record[3]);					
		rev_stage=checkForNull(record[4]);
		eff_from = checkForNull(record[5]);			
		eff_to= checkForNull(record[6]);			
		if(ilRow % 2 == 0)
		{	
			slClassValue = "gridData";
		}
		else   
		{	
			slClassValue = "gridData";
		}

		String order_type_code_desc = "";
		try {
				String strsql2="SELECT long_desc FROM or_order_type where order_type_code='"+ordertypcode+"'" ;
				stmt2=connection.prepareStatement(strsql2);
				rs2 = stmt2.executeQuery();
				while (rs2.next())
				{
					order_type_code_desc = checkForNull(rs2.getString(1));
				}
			}catch(Exception e) {
				e.printStackTrace();
				order_type_code_desc = ordertypcode;
			}
		//V200922 Start
		if (order_type_code_desc == null || order_type_code_desc.equals("")) {
			order_type_code_desc = "**";
		}
		//V200922 End
		
		String rev_stage_desc = "";
		if (rev_stage.equals("BLD")) rev_stage_desc = "Billed";
		if (rev_stage.equals("REG")) rev_stage_desc = "Registered";
		if (rev_stage.equals("CMP")) rev_stage_desc = "Completed";			
	%>
<tr>
	<td  class="<%= slClassValue %>" style="text-align:center;"  width="10%" ><%=record[0]%> 	 <!-- IN:073854-->		
		<input type="hidden"  name="order_cat<%=i%>" id="order_cat<%=i%>" id="order_cat<%=i%>" value=<%=record[0]%> readOnly='true'>				
	</td>
	
	<td class="<%= slClassValue %>" style="text-align:center;"  width="15%"> <!-- IN:073854-->
		<input type="text" name="long_desc<%=i%>" id="long_desc<%=i%>" id="long_desc<%=i%>" value="<%=record[1]%>" maxlength=30 size=20 onBlur="makeValidString(this);" readOnly='true'>
	</td>

	<td class="<%= slClassValue %>" style="text-align:center;"  width="15%"> <!-- IN:073854-->
		<input type="text" name="short_desc_<%=i%>" id="short_desc_<%=i%>" id ="short_desc_<%=i%>" value="<%=record[2]%>" maxlength=15 onBlur="makeValidString(this);" readOnly='true' >
	</td>
	
	<td class="<%= slClassValue %>" style="text-align:center;"  width="15%"> <!-- IN:073854-->
		<input name="order_type<%=i%>" id="order_type<%=i%>" id="order_type<%=i%>"  maxlength='30' style="width:150px;" value='<%=order_type_code_desc%>' onBlur="makeValidString(this);" readOnly='true' >	
	</td> 
		
	<td class="fields"  style="text-align:center;" width="15%"> <!-- IN:073854-->
		<input name="Revenue_Stage<%=i%>" id="Revenue_Stage<%=i%>"  id="Revenue_Stage<%=i%>" value='<%=rev_stage_desc%>' onBlur="makeValidString(this);" readOnly='true' >			
	</td>
		
	<td class="fields" style="text-align:center;"  width="15%">	 <!-- IN:073854-->
		<input type="text"  name="p_fm_date<%=i%>" id="p_fm_date<%=i%>" id="p_fm_date<%=i%>" size="14" maxlength='10' value="<%=eff_from%>" readOnly='true' onBlur="return checkDateBL(this,'<%=i%>')" >		
	</td>
		
	<td class='fields' style="text-align:center;"  width="15%"> <!-- IN:073854-->
		<input type="text"  name="p_to_date<%=i%>" id="p_to_date<%=i%>"  id="p_to_date<%=i%>"   size="15" maxlength='10'  value="<%=eff_to%>" onBlur="return toFromDateChk(this,'<%=i%>')" readOnly='true'>					
	</td>
</tr>
	<%
		ilRow++;
			
	}
	%>
</table>
</div>
<input type="hidden" name="totalRecords" id="totalRecords" id="totalRecords" value="<%=Category_Data.size()%>">
<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>"> 
<input type="hidden" name="function_id" id="function_id" value="Revenue_Stage">
<input type='hidden' name='locale' id='locale' 	id='locale' value="<%=locale%>">
<input type='hidden' name='facilityId' id='facilityId'	id='facilityId' value="<%=facilityId%>" >
<%
	Category_Data=null;
%>
</form>
<%
	}
	catch(Exception e)
	{
		e.printStackTrace();
		System.err.println("Exception in BlRevnRecgStage.jsp::"+e);
	}
	finally{   //V210518 Starts
		try{
			if(rs2!=null) rs2.close();
			if(stmt2 != null) stmt2.close();
			if(connection!=null){
				ConnectionManager.returnConnection(connection);
			}
		}catch(Exception ex) {
			ex.printStackTrace();	
		}
	}//V210518 Ends
%>
</body>

</html>
<%
	putObjectInBean(bean_id,bean,request);
%>

