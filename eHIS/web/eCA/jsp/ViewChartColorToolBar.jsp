<!DOCTYPE html>
<%@page import="java.util.*,java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%

%>
<html>
<head>
	<%
	String sStyle =			(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
</head>
<body>
<form>
	<%
		Connection con = null;
		PreparedStatement pstmt =null;
		ResultSet rs= null;
		String hsDesc= "";
		String hcCode= "";
		String lsDesc= "";
		String lcCode= "";
		String asDesc= "";
		String acCode= "";
		String csDesc= "";
		String ccCode= "";
		String chDesc= "";
		String chcCode= "";
		String clDesc= "";
		String clcCode= "";
		try{
			con = ConnectionManager.getConnection(request);											
			pstmt = con.prepareStatement("SELECT HIGH_STR_DESC,HIGH_COLOR_CODE,LOW_STR_DESC,LOW_COLOR_CODE,ABN_STR_DESC,ABN_COLOR_CODE,CRIT_STR_DESC,CRIT_COLOR_CODE,CRIT_HIGH_STR_DESC,CRIT_HIGH_COLOR_CODE,CRIT_LOW_STR_DESC,CRIT_LOW_COLOR_CODE FROM CR_CLIN_EVENT_PARAM");
			rs = pstmt.executeQuery();
			if(rs.next()){
			hsDesc = rs.getString(1);
			hcCode = rs.getString(2);
			lsDesc = rs.getString(3);
			lcCode = rs.getString(4);
			asDesc = rs.getString(5);
			acCode = rs.getString(6);
			csDesc = rs.getString(7);
			ccCode = rs.getString(8);
			chDesc = rs.getString(9);
			chcCode = rs.getString(10);
			clDesc = rs.getString(11);
			clcCode = rs.getString(12);
			}
		}catch(Exception e){
			//out.println(e.toString());//COMMON-ICN-0181
			e.printStackTrace();//COMMON-ICN-0181
		}finally{
			if(con!=null)
				ConnectionManager.returnConnection(con,request);
		}
	%>	
	<TABLE border="0" cellpadding=3 cellspacing="0"  width="100%" >
		<TR>
			<TD align="center">
				<TABLE border="0" cellpadding=3 cellspacing="0"  width="97%" >
					<TR>
						<TD width="20%" ><font style='background-color:<%=lcCode %>;size:1;width:16px;height:16px' >&nbsp;&nbsp;</font>&nbsp;<font size=1><%=lsDesc%></font></TD>
						<TD width="20%" ><font style='background-color:<%=hcCode%>;size:1;width:16px;height:16px' >&nbsp;&nbsp;</font>&nbsp;<font size=1><%=hsDesc %></font></TD>						
						<TD width="20%" ><font style='background-color:#32CD32;size:1;width:16px;height:16px' >&nbsp;&nbsp;</font>&nbsp;<font size=1><fmt:message key="Common.Normal.label" bundle="${common_labels}"/></font></TD>
						<TD width="20%" ><font style='background-color:<%=clcCode %>;size:1;width:16px;height:16px' >&nbsp;&nbsp;</font>&nbsp;<font size=1><%=clDesc %></font></TD>
						<TD width="20%" ><font style='background-color:<%=chcCode %>;size:1;width:16px;height:16px' >&nbsp;&nbsp;</font>&nbsp;<font size=1><%=chDesc %></font></TD>
						<!--<TD width="14%" class='label'><%=asDesc %></TD>
						<TD width="2%" bgcolor='<%=ccCode %>'>&nbsp;</TD>
						<TD width="14%" class='label'><%=csDesc %></TD>
						<TD width="2%" bgcolor='<%=chcCode %>'>&nbsp;</TD>
						<TD width="14%" class='label'><%=chDesc %></TD>
						<TD width="2%" bgcolor='<%=clcCode %>'>&nbsp;</TD>
						<TD width="14%" class='label'><%=clDesc %></TD> -->
					</TR>
				</TABLE>
			</TD>
		</TR>	
	</TABLE>	
</form>
</body>
</html>

