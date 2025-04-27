<!DOCTYPE html>

<%@ page import="java.sql.*,java.util.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"  %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
	HttpSession httpSession = request.getSession(false);
	//unused variable, commented on 15/06/05
	//Properties p = (Properties)httpSession.getValue("jdbc");	
	String facility_id = "";
	//unused variable, commented on 09/06/05
	//String login_user = "";
	String login_time = "";	String cashcounter = "";
	//boolean boolPrevious = false;
	//boolean boolNext = false;
	String from = "0";	String to = "0";
	int intFrom = 0;	int intTo =14;
	int intMaxCount = 14;	int intCount = 0;
	int intVectorElement = 0;
	Connection con = null;
	//Vector  vector = new Vector();
	ArrayList arrList=new ArrayList();
	request.setCharacterEncoding("UTF-8");
	try
	{
		facility_id = (String)httpSession.getValue("facility_id");
		//login_user =  p.getProperty("login_user");
		from = request.getParameter("from");
		to = request.getParameter("to");
		login_time = request.getParameter("login_time");
		cashcounter =  request.getParameter("cashcounter");
		
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

		
	}
	catch(Exception eX)
	{
			//out.println("Error= "+eX);
			eX.printStackTrace();
	}


	try
	{		
		//Connection 
		con = ConnectionManager.getConnection(request);
		try
		{
			String sql1 = "	select to_char(TRX_DATE_TIME,'dd/mm/yyyy hh24:mi:ss'),CASH_COUNTER_CODE,SHIFT_ID,DOC_TYPE_CODE,DOC_NUMBER,to_char(nvl(DOC_AMT,0),'99999999999999.00'), "+
				" nvl(RECPT_TYPE_CODE,' '),nvl(RECPT_NATURE_CODE,' '),SLMT_TYPE_CODE,nvl(CANCELLED_IND,' ') from bl_receipt_refund_hdrdtl_vw "+
				" where operating_facility_id = ? AND "+
				" DOC_DATE BETWEEN to_date(?,'dd/mm/yyyy hh24:mi:ss')	 "+
				" AND  sysdate	 "+
				" AND  CASH_COUNTER_CODE = ?  AND ROWNUM BETWEEN ? AND ? ORDER BY TRX_DATE_TIME";

			PreparedStatement pstmt = con.prepareStatement(sql1);
			pstmt.setString(1, facility_id);
			pstmt.setString(3, cashcounter);
			pstmt.setString(2,login_time);
			pstmt.setInt(4,intFrom);
			pstmt.setInt(5,intTo);
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
/*				vector.insertElementAt("<tr>",intVectorElement);
				++intVectorElement;
				vector.insertElementAt("<td align='left' class='"+strColorClass+"'>"+rs.getString(1)+"</td>",intVectorElement);
				++intVectorElement;
				vector.insertElementAt("<td class='"+strColorClass+"'>"+rs.getString(2)+"</td>",intVectorElement);
				++intVectorElement;
				vector.insertElementAt("<td class='"+strColorClass+"'>"+rs.getString(3)+"</td>",intVectorElement);
				++intVectorElement;
				vector.insertElementAt("<td class='"+strColorClass+"' >"+rs.getString(4)+"</td>",intVectorElement);
				++intVectorElement;
				vector.insertElementAt("<td class='"+strColorClass+"'  style='text-align:right' >"+rs.getInt(5)+"</td>",intVectorElement);
				++intVectorElement;
				vector.insertElementAt("<td class='"+strColorClass+"'  style='text-align:right' >"+rs.getString(6)+"</td>",intVectorElement);
				++intVectorElement;
				vector.insertElementAt("<td class='"+strColorClass+"'>"+rs.getString(7)+"</td>",intVectorElement);
				++intVectorElement;
				vector.insertElementAt("<td class='"+strColorClass+"'>"+rs.getString(8)+"</td>",intVectorElement);
				++intVectorElement;

				vector.insertElementAt("<td class='"+strColorClass+"'>"+rs.getString(9)+"</td>",intVectorElement);
				++intVectorElement;

				vector.insertElementAt("<td class='"+strColorClass+"'>"+rs.getString(10)+"</td>",intVectorElement);
				++intVectorElement;


				vector.insertElementAt("</tr>",intVectorElement);
				++intVectorElement;*/


				arrList.add(intVectorElement,"<tr>");
				++intVectorElement;
				arrList.add(intVectorElement,"<td align='left' class='"+strColorClass+"'>"+rs.getString(1)+"</td>");
				++intVectorElement;
				arrList.add(intVectorElement,"<td class='"+strColorClass+"'>"+rs.getString(2)+"</td>");
				++intVectorElement;
				arrList.add(intVectorElement,"<td class='"+strColorClass+"'>"+rs.getString(3)+"</td>");
				++intVectorElement;
				arrList.add(intVectorElement,"<td class='"+strColorClass+"' >"+rs.getString(4)+"</td>");
				++intVectorElement;
				arrList.add(intVectorElement,"<td class='"+strColorClass+"'  style='text-align:right' >"+rs.getInt(5)+"</td>");
				++intVectorElement;
				arrList.add(intVectorElement,"<td class='"+strColorClass+"'  style='text-align:right' >"+rs.getString(6)+"</td>");
				++intVectorElement;
				arrList.add(intVectorElement,"<td class='"+strColorClass+"'>"+rs.getString(7)+"</td>");
				++intVectorElement;
				arrList.add(intVectorElement,"<td class='"+strColorClass+"'>"+rs.getString(8)+"</td>");
				++intVectorElement;

				arrList.add(intVectorElement,"<td class='"+strColorClass+"'>"+rs.getString(9)+"</td>");
				++intVectorElement;

				arrList.add(intVectorElement,"<td class='"+strColorClass+"'>"+rs.getString(10)+"</td>");
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
			// commented in Bangalore on 13/10/2005
			//ConnectionManager.returnConnection(con,request);
		}
		catch(Exception exp)
		{
			//out.println("Err="+exp);
			exp.printStackTrace();
		}

	}
	catch(Exception sql)
	{
	}

	finally{ // Added in Bangalore on 13/10/2005
				if(con!=null) {
					ConnectionManager.returnConnection(con, request);
				}
	}

	%>
<HTML>
	<head>
	<title> <fmt:message key="eBL.CASHIER_JOURNAL.label" bundle="${bl_labels}"/> </title>
<!--
	<link rel='stylesheet' type ='text/css'  href='../../eCommon/html/IeStyle.css'></link>
	-->
		<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
    %>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<!--
	<script language='javascript' src='../../eCommon/js/messages.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



-->
<script>
function funSubmit()
{
	//alert("4");
	document.forms[0].submit();
}
</script>
</head>
<BODY class='CONTENT' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name='Query' id='Query'>
<p>
<table align='center'>
<tr>
<td>
<%
/***
if (boolPrevious == true)
{
	out.println("<A text-decoration='none' onClick='funSubmit();'>Previous</A>");
}
if (boolNext == true)
{
	out.println("<A text-decoration='none' onClick='funSubmit();'>Next</A>");
}
*****/
%>
</td>
</tr>
</table>
</p>

<center>
	<table border="1" width="100%" cellspacing='0' cellpadding='3'>
	<td class="COLUMNHEADER" width='20%'><fmt:message key="eBL.RECEIPT_TIME.label" bundle="${bl_labels}"/></td>
	<td class="COLUMNHEADER" width='5%'><fmt:message key="eBL.CASH_COUNTER.label" bundle="${bl_labels}"/></td>
	<td class="COLUMNHEADER" width='5%'><fmt:message key="Common.SHIFT.label" bundle="${common_labels}"/></td>
	<td class="COLUMNHEADER" width='10%'><fmt:message key="Common.documenttype.label" bundle="${common_labels}"/> </td>
	<td class="COLUMNHEADER" width='10%'><fmt:message key="Common.DocumentNumber.label" bundle="${common_labels}"/></td>
	<td class="COLUMNHEADER" width='10%'><fmt:message key="eBL.DOC_AMT.label" bundle="${bl_labels}"/></td>
	<td class="COLUMNHEADER" width='5%'><fmt:message key="Common.type.label" bundle="${common_labels}"/></td>
	<td class="COLUMNHEADER" width='5%'><fmt:message key="Common.Nature.label" bundle="${common_labels}"/></td>
	<td class="COLUMNHEADER" width='5%'><fmt:message key="eBL.SLMT.label" bundle="${bl_labels}"/></td>
	<td class="COLUMNHEADER" width='5%'><fmt:message key="Common.status.label" bundle="${common_labels}"/></td>
	<%
		String strTempData = "";
		for (int i=0;i<intVectorElement;i++)
		{
			strTempData = (String) arrList.get(i);
			out.println(strTempData);
		}
	%>

	</table>
	</center>

	<br><center>


</center>
<input type='hidden' name='from' id='from' value='<%=(intFrom-intMaxCount)%>'>
<input type='hidden' name='to' id='to' value='<%=(intTo+intMaxCount )%>'>
<input type='hidden' name='cashcounter' id='cashcounter' value='<%=cashcounter%>'>
<input type='hidden' name='login_time' id='login_time' value='<%=login_time%>'>

</form>
</BODY>

</HTML> 

