<!DOCTYPE html>
<%@page  import="eOT.*,eOT.Common.*, eCommon.Common.CommonBean, java.util.HashMap,java.util.ArrayList,java.sql.Connection,  java.sql.PreparedStatement, java.sql.ResultSet, webbeans.eCommon.ConnectionManager" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<% request.setCharacterEncoding("UTF-8");%>
<%@ include file="../../eCommon/jsp/Common.jsp" %>

<html>
<head>
<%
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String locale = ((String)session.getAttribute("LOCALE"));
	//CRF-268 Instrument Count - Rajesh V
	String otParam="";
	//CRF-268 Instrument Count - Rajesh V
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eOT/js/InstrumentCount.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	
</head>

<% 
String title= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.AddaSet.Label","ot_labels")+",";
%>

<title><%=title %>

</title>
<%
	String params		= request.getQueryString();
	String facility_id	= (String)session.getValue("facility_id");
	String booking_num	= request.getParameter("booking_num");
	String oper_num		= request.getParameter("oper_num");
	String patient_id	= request.getParameter("patient_id");
	booking_num=booking_num==null?"":booking_num;
	booking_num=booking_num.equalsIgnoreCase("null")?"":booking_num;
	oper_num=oper_num==null?"":oper_num;
	oper_num=oper_num.equalsIgnoreCase("null")?"":oper_num;
	String sql = "";
	//CRF-268 Instrument Count - Rajesh V
	int instr_qty = 0;
	int qty_hand = 0;
	//CRF-268 Instrument Count - Rajesh V

	Connection connection   = null ;
	PreparedStatement pstmt = null ;
	ResultSet rs = null ;
	ArrayList oper_code_list = new ArrayList();
	ArrayList set_code_list = new ArrayList();
	try{
		connection	= ConnectionManager.getConnection(request);
		sql		= "SELECT DISTINCT A.OPER_CODE OPER_CODE, B.SHORT_DESC SHORT_DESC FROM OT_POST_OPER_DTLS A,OT_OPER_MAST B WHERE A.OPERATING_FACILITY_ID = ? AND OPER_NUM=? AND A.OPER_CODE = B.OPER_CODE  AND NVL(A.OPER_LINE_STATUS,'X' ) NOT IN '99' ORDER BY 2 ";
		pstmt	= connection.prepareStatement(sql) ;
		pstmt.setString(1,facility_id);
		pstmt.setString(2,oper_num);
		rs		= pstmt.executeQuery();
		while(rs!=null && rs.next()){
			oper_code_list.add(rs.getString("OPER_CODE"));
			oper_code_list.add(rs.getString("SHORT_DESC"));
		}
		
		//CRF-268 Instrument Count - Rajesh V
		String sqlOtParam = "select NVL(cssd_interface_yn,'N') facility from ot_param_for_facility where operating_facility_id = ?";

		pstmt = connection.prepareStatement(sqlOtParam);
		pstmt.setString(1,facility_id);
		rs=pstmt.executeQuery();
		if(rs !=null && rs.next())
		{
			otParam=rs.getString("facility");		
		}
		pstmt = null;
		rs = null;
		//CRF-268 Instrument Count - Rajesh V
		
		sql= "SELECT INSTR_CODE, LONG_DESC FROM OT_INSTRUMENT_LANG_VW WHERE LANGUAGE_ID='"+locale+"' AND INSTR_CODE IN (SELECT DISTINCT INSTR_CODE FROM OT_INSTRUMENT_COMPONENTS) ORDER BY 2";
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
		pstmt	= connection.prepareStatement(sql) ;
		rs		= pstmt.executeQuery();
		while(rs!=null && rs.next()){
			set_code_list.add(rs.getString("INSTR_CODE"));
			set_code_list.add(rs.getString("LONG_DESC"));
		}
%>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form name="InstrumentCountCreateSetForm" id="InstrumentCountCreateSetForm" method="POST" target="messageFrame" action="../../servlet/eOT.InstrumentCountCreateSetServlet">
<table cellpadding=3  cellspacing="0" width="100%" align="center" border="0">
	
	<tr>
		<td width="25%" class="label" >
		<fmt:message key="Common.operation.label" bundle="${common_labels}"/>
		</td>
		<td width="25%" class='fields' >
		<select name="oper_code" id="oper_code">
		<option value="" selected>
			<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>
		</option>
		<%
		String oper_code_select = "";
		if(oper_code_list!=null){
		for (int i=0;i<oper_code_list.size();i=i+2){%>
			<option value="<%=(String)oper_code_list.get(i)%>" <%=oper_code_select%> > 	
				<%=oper_code_list.get(i+1)%>	
			</option>
		<%}}
		oper_code_list.clear(); 
		%>
		</select><img src='../../eCommon/images/mandatory.gif'></img>
		</td>
		<td align='center' class='fields' >
		</td>
		<td align='center' class='fields' >
		</td>

	</tr>
	<tr>
		<td align="right" class="label" >
			<fmt:message key="Common.Set.label" bundle="${common_labels}"/>
		</td>
		<td width="25%" class='fields'>
		<!-- CRF-268 Instrument Count - Rajesh V-->
		<%if("Y".equalsIgnoreCase(otParam)){ %>
			<select name="set_code" id="set_code" onchange="assignTary(this);">
		<%}
		else{%>
			<select name="set_code" id="set_code">
		<%} %>
		<!-- CRF-268 Instrument Count - Rajesh V-->
			<option value="" selected>
			<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>
			</option>
			<%
			if(set_code_list!=null){
			for (int i=0;i<set_code_list.size();i=i+2){
			%>
			<option value="<%=(String)set_code_list.get(i)%>" > 
			<%=set_code_list.get(i+1)%>	
			</option>
			<%}}
				set_code_list.clear(); 
			%>
			</select><img src='../../eCommon/images/mandatory.gif'></img>
		</td>
		<td align='center' class='fields' >
		</td>
		<td align='center' class='fields' >
		</td>

	</tr>
	<tr>
		<td width="25%" class="label" >
		<fmt:message key="Common.Tray.label" bundle="${common_labels}"/>
		</td>
		<td width="25%" class='fields'>
		<!-- CRF-268 Instrument Count - Rajesh V-->
		<%if("Y".equalsIgnoreCase(otParam)){ %>
		<input type="text"  name="tray_num" id="tray_num"  maxlength="30" size="30" value="" onkeypress="return checkForSpecCharsforID(event);" Onblur="return CheckChars1(this);" readonly><img src='../../eCommon/images/mandatory.gif'></img>
		<%}
		else{%>
		<input type="text"  name="tray_num" id="tray_num"  maxlength="30" size="30" value="" onkeypress="return checkForSpecCharsforID(event);" Onblur="return CheckChars1(this);"><img src='../../eCommon/images/mandatory.gif'></img>
		<%} %>
		<!-- CRF-268 Instrument Count - Rajesh V-->
		</td>
		<td align='center' class='fields' >
		</td>
		<td align='center' class='fields' >
		</td>			
	</tr>
	<!-- CRF-268 Instrument Count - Rajesh V -->
	<%if("Y".equalsIgnoreCase(otParam)){ %>
	<tr>
		<td class='label' nowrap>	
		<fmt:message key="eOT.RequiredQuantity.Label" bundle="${ot_labels}"/>
		</td>
		<td>
		<input type="text"  name="req_qty" id="req_qty"  maxlength="30" size="30" value="" onkeypress="return checkForSpecCharsforID(event);" Onblur="return CheckChars1(this);"><img src='../../eCommon/images/mandatory.gif'></img>
		</td>
		
	<td class='label' id='qtyonhands' nowrap>	
		<fmt:message key="eOT.QuantityOnHands.Label" bundle="${ot_labels}"/>
		</td>
		<td align='center' class='fields' >
		<input type=text name="units" id="units" readonly="true" class='label' style="background:transparent;border=0"/>
		</td>
	</tr>
	<%}%>
	<!-- CRF-268 Instrument Count - Rajesh V -->

	<tr>		
		
		<td align='center' class='fields' >
		</td>
		<td align='center' class='fields' >
		</td>			
		<td  width="25%"  class='button'>
		<input type="button" class="button" name= "btnOK" 
		value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>' onclick="insertNewTray()" >
		</input>
		</td>
		<td  width="25%"  class='button'>
			<input type="button" class="button" value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' onclick="window.returnValue='false';window.close()" ></input>
		</td>
	
			
	</tr>
		
</table>
<%
	}catch ( Exception e ) {
		System.err.println("Caught Exception error in InstrumentCountCreateSet: "+e);
		e.printStackTrace() ;
	}finally {
		try{
			
			set_code_list=null;
			oper_code_list=null;
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(connection!=null) ConnectionManager.returnConnection(connection,request);
		}catch(Exception es){}
	}
%>
	<input type="hidden" name="params" id="params" value="<%=params%>">
	<input type="hidden" name="surgery_date" id="surgery_date" value="<%=request.getParameter("theatre_date")%>">
	<input type="hidden" name="team_doctor_code" id="team_doctor_code" value="<%=request.getParameter("surgeon_code")%>">	
	<input type="hidden" name="booking_num" id="booking_num" value="<%=booking_num%>">
	<input type="hidden" name="oper_num" id="oper_num" value="<%=oper_num%>">	
	<input type="hidden" name="patient_id" id="patient_id"  value="<%=patient_id%>">	
	<input type='hidden' name='locale' id='locale' value="<%=locale%>">
	<!-- CRF-268 Instrument Count - Rajesh V -->
	<input type='hidden' name='ot_Param' id='ot_Param' value='<%=otParam%>'>
	<!-- CRF-268 Instrument Count - Rajesh V -->

</form>
</body>
</html>

