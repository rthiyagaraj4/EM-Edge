<!DOCTYPE html>
<%@ page import="java.sql.*, webbeans.eCommon.*,webbeans.op.CurrencyFormat,java.io.*,java.util.*" contentType="text/html;charset=UTF-8"  %>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
	HttpSession httpSession = request.getSession(false);

	//unused variable, commented on 15/06/05
	//Properties p = (Properties)httpSession.getValue("jdbc");	
	String facility_id = "";
	//unused variable, commented on 09/06/05
	//String login_user = "";
	//boolean boolPrevious = false;
	//boolean boolNext = false;
	String from = "0";
	String to = "0";

	String locale	= (String)session.getAttribute("LOCALE");

	int intFrom = 0;
	int intTo =14;
	int intMaxCount = 14;
	int intCount = 0;
	int intVectorElement = 0;
	Connection con = null;
//	Vector  vector = new Vector();
	ArrayList arrList=new ArrayList();
	request.setCharacterEncoding("UTF-8");
	
	

	try
	{
		facility_id = (String)httpSession.getValue("facility_id");
		//login_user =  p.getProperty("login_user");
		from = request.getParameter("from");
		to = request.getParameter("to");
				
		if ( (from == null) || from.equals(""))
		{
			from = "0";
		}
		if( (to == null)|| to.equals(""))
		{
			to = intMaxCount+"";
		}
		intFrom = Integer.parseInt(from);
		intTo = Integer.parseInt(to);

		if (intTo <=0) intTo = intMaxCount;
		if (intFrom <=0)
		{
			intFrom = 0;
			//boolPrevious = false;
		}
		else
		{
			
			//boolPrevious = true;
		}

		
		//Connection 
		con = ConnectionManager.getConnection(request);
		try
		{
//			System.out.println("from " +from);
//			System.out.println("to " +to);

			String sql1 = "	select cash_counter_code,  "+
			" short_desc , " +
			"	CASH_CTR_IN_USE_BY,to_char(LOGIN_DATE_TIME ,'dd/mm/yyyy hh24:mi')"+    
			" from bl_cash_counter_lang_vw "+
			" where language_id='"+locale+"' and nvl(cash_ctr_in_use_yn, 'N') ='Y' "+
			" and operating_facility_id = ? "+
			" and rownum > ? and rownum < ? "+
			" and NVL(status,'X') <> 'S' order by cash_counter_code ";
//			System.out.println("sql1 " +sql1);


			PreparedStatement pstmt = con.prepareStatement(sql1);
			pstmt.setString(1, facility_id);
			pstmt.setInt(2,intFrom);
			pstmt.setInt(3,intTo);

			ResultSet rs = pstmt.executeQuery() ;
			String strColorClass = "QRYODD";
			boolean alternate = true;
			while(rs.next())
			{
				if (alternate)
				{
					alternate = false;
					strColorClass = "QRYODD";
				}
				else
				{
					alternate = true;
					strColorClass = "QRYEVEN";
				}
				++intCount;
				if (intCount>intMaxCount) 
				{
					//boolNext = true;
					//break;
				}

				/*vector.insertElementAt("<tr>",intVectorElement);
				++intVectorElement;
				vector.insertElementAt("<td align='left' class='"+strColorClass+"'>"+CommonBean.checkForNull(rs.getString(1))+"</td>",intVectorElement);
				++intVectorElement;
				vector.insertElementAt("<td class='"+strColorClass+"'>"+CommonBean.checkForNull(rs.getString(2))+"</td>",intVectorElement);
				++intVectorElement;
				vector.insertElementAt("<td class='"+strColorClass+"'>"+CommonBean.checkForNull(rs.getString(3))+"</td>",intVectorElement);
				++intVectorElement;
//			System.out.println("dd :"+com.ehis.util.DateUtils.convertDate(CommonBean.checkForNull(rs.getString(4)),"DMYHM","en",locale));
				vector.insertElementAt("<td class='"+strColorClass+"'>"+com.ehis.util.DateUtils.convertDate(CommonBean.checkForNull(rs.getString(4)),"DMYHM","en",locale)+"</td>",intVectorElement);
				++intVectorElement;
				vector.insertElementAt("</tr>",intVectorElement);
				++intVectorElement;*/



				arrList.add(intVectorElement,"<tr>");
				++intVectorElement;
				arrList.add(intVectorElement,"<td align='left' class='"+strColorClass+"'>"+CommonBean.checkForNull(rs.getString(1))+"</td>");
				++intVectorElement;
				arrList.add(intVectorElement,"<td class='"+strColorClass+"'>"+CommonBean.checkForNull(rs.getString(2))+"</td>");
				++intVectorElement;
				arrList.add(intVectorElement,"<td class='"+strColorClass+"'>"+CommonBean.checkForNull(rs.getString(3))+"</td>");
				++intVectorElement;
//			System.out.println("dd :"+com.ehis.util.DateUtils.convertDate(CommonBean.checkForNull(rs.getString(4)),"DMYHM","en",locale));
				arrList.add(intVectorElement,"<td class='"+strColorClass+"'>"+com.ehis.util.DateUtils.convertDate(CommonBean.checkForNull(rs.getString(4)),"DMYHM","en",locale)+"</td>");
				++intVectorElement;
				arrList.add(intVectorElement,"</tr>");
				++intVectorElement;

				
			}
			rs.close();
			pstmt.close();
			if (intCount == 0)
			{
				//boolPrevious = false;
				//boolNext = false;
			}
			// Commented in Bangalore on 13/10/2005
			//ConnectionManager.returnConnection(con,request);
		}
		catch(Exception exp)
		{
			System.out.println("Exception in sql1:"+exp);
		}


	


	%>
<HTML>
	<head>
	<!--
	<link rel='stylesheet' type ='text/css'  href='../../eCommon/html/IeStyle.css'></link>
	-->
		<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
    %>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="javascript"src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>	
<!--
	<script language='javascript' src='../../eCommon/js/messages.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



-->
</head>
<BODY  OnMouseDown='CodeArrest()' onKeyDown="lockKey()">
<!--
<p>
<table align='center' cellpadding='3' width='100%'>
<tr>
<td>
<%
/***
if (boolPrevious == true)
{
	out.println("<A HREF='../jsp/BLLoginCashCounterQuery.jsp?from="+(intFrom-intMaxCount)+"&to="+(intTo-intMaxCount )+"' text-decoration='none'>Previous</A>");
}
if (boolNext == true)
{
	out.println("<A HREF='../jsp/BLLoginCashCounterQuery.jsp?from="+(intFrom+intMaxCount)+"&to="+(intTo+intMaxCount )+"' text-decoration='none'>Previous</A>");
}
****/
%>
</td>
</tr>
</table>
</p>
-->
<center>
	<table border="1" width="100%" cellspacing='0' cellpadding='3'>
	<td class='COLUMNHEADER' colspan="15"><fmt:message key="eBL.LOGGEDIN_USER_COUNTER_DTLS.label" bundle="${bl_labels}"/></td>
	<tr>
		<td></td>
	</tr>
	<td class='COLUMNHEADER' width='5%'><fmt:message key="eBL.CASH_COUNTER.label" bundle="${bl_labels}"/></td>
	<td class='COLUMNHEADER' width='25%'><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
	<td class='COLUMNHEADER' width='30%'><fmt:message key="eBL.LOGGED_IN_USER.label" bundle="${bl_labels}"/></td>
	<td class='COLUMNHEADER' width='50%'><fmt:message key="eBL.LOGIN_DATE_TIME.label" bundle="${bl_labels}"/> </td>
	<%
		String strTempData = "";
		for (int i=0;i<intVectorElement;i++)
		{
			strTempData = (String) arrList.get(i);
			
			out.println(strTempData);
		}
	%>

	</table>

		<input type= hidden name="locale" id="locale"  value='<%=locale%>'>
	</center>

	<br><center>


</center>
</BODY>
</HTML>

<%
	}
	catch(Exception eX)
	{
			//out.println("Error= "+eX);
			eX.printStackTrace();
	}

finally {	//Added in Bangalore on 13/10/2005
		if(con!=null) {
			ConnectionManager.returnConnection(con,request);
		}
	}

%>

