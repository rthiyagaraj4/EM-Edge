<!DOCTYPE html>
<%@ page import= "java.sql.*, webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<head>
<!--
	<script language="javascript" src="../../eCommon/js/messages.js"></script>
-->
<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
</head>

<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
	request.setCharacterEncoding("UTF-8");
	String patId = request.getParameter("patientId");
	String p_bed_class_code = request.getParameter("p_bed_class_code");
	String p_nursing_unit_code = request.getParameter("p_nursing_unit_code");
	String p_bed_no = request.getParameter("p_bed_no");
	//String facilityId = (String)session.getValue("facility_id"); 
	String setlmt_ind = request.getParameter("setlmt_ind");

	Connection con = null;
	CallableStatement cstmt = null;

	try 
	{
		con = ConnectionManager.getConnection(request);
		
			cstmt = con.prepareCall("{ call BL_CALCULATE_TOT_DEP_AMT(?,?,?,?,?,?,?,?,?,?,?,?,?) }");
			cstmt.setString(1,patId);
			cstmt.setString(2,p_bed_class_code);
			cstmt.setString(3,p_nursing_unit_code);
			cstmt.setString(4,p_bed_no);
			cstmt.setString(5,setlmt_ind);

			cstmt.registerOutParameter(6,java.sql.Types.VARCHAR);
			cstmt.registerOutParameter(7,java.sql.Types.INTEGER);
			cstmt.registerOutParameter(8,java.sql.Types.INTEGER);
			cstmt.registerOutParameter(9,java.sql.Types.INTEGER);
			cstmt.registerOutParameter(10,java.sql.Types.VARCHAR);
			cstmt.registerOutParameter(11,java.sql.Types.VARCHAR);
			cstmt.registerOutParameter(12,java.sql.Types.VARCHAR);
			cstmt.registerOutParameter(13,java.sql.Types.VARCHAR);

			cstmt.execute();
			
			String dailyCharge = "";
			if(cstmt.getString(7)==null) dailyCharge= "";
			else dailyCharge = cstmt.getString(7);

			String addlDepReq = "";
			if(cstmt.getString(6)==null) addlDepReq= "" ;
			else addlDepReq =cstmt.getString(6);

			String depAmt = "";
			if(cstmt.getString(8)==null) depAmt= "";
			else depAmt =cstmt.getString(8);

			String totDepAmt = "";
			if(cstmt.getString(9)==null) totDepAmt= "";
			else totDepAmt = cstmt.getString(9);

			String errValue = cstmt.getString(13);

		%>
				<script>

			if('<%=errValue%>' != '0')
            {
			
                var chk_code='<%=errValue%>'.indexOf("**");
				if(chk_code != -1)
                {
					alert('<%=errValue%>');
				}
				else
				{
					alert(getMessage('<%=errValue%>'));
					parent.Main_frame.document.forms[0].dly_charge.value='<%=dailyCharge%>';
					parent.Main_frame.document.forms[0].dep_amt.value='<%=depAmt%>';
					parent.Main_frame.document.forms[0].pay_amt.value='<%=totDepAmt%>';
				}
			}
			

					if('<%=addlDepReq%>'=='Y'){
						parent.Main_frame.document.forms[0].addDepReq.value='Y'
						parent.Main_frame.document.forms[0].addDepReq.checked=true;
					}
					else{
						parent.Main_frame.document.forms[0].addDepReq.value='N'
						parent.Main_frame.document.forms[0].addDepReq.checked=false;
					}
				</script>");
		<%
	}
	catch(Exception e) {
		out.println(e.toString());
	}
	finally {
		if (cstmt != null) cstmt.close();
		ConnectionManager.returnConnection(con, request);
	}

%>
</body>
</html>

