<!DOCTYPE html>
<%@page  import ="eCommon.Common.CommonBean,eOT.*,eOT.Common.*,java.util.ArrayList,java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper,eCommon.Common.*" %>
<%@page  contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<% request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");%>
<%@include file="../../eCommon/jsp/Common.jsp" %>
<HTML>
<head>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script type='text/javascript' src='../../eOT/js/CancelCheckIn.js'></script>
	<script type='text/javascript' src='../../eCommon/js/common.js'></script>
	<script type='text/javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
	<script language="javascript" src='../../eOT/js/CancelCheckIn.js'></script>
	<script type='text/javascript' src='../../eOT/js/OTCommon.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	String locale = (String)session.getAttribute("LOCALE");
	String slate_user_id = CommonBean.checkForNull(request.getParameter("slate_user_id"));
	String oper_num = CommonBean.checkForNull(request.getParameter("oper_num"));
	String called_from = CommonBean.checkForNull(request.getParameter("called_from"));
	String cancelled_by = "";
	//ArrayList cur_time=new ArrayList();
	String bean_id = "CancelCheckInBean";
	String bean_name = "eOT.CancelCheckInBean";
	CancelCheckInBean bean = (CancelCheckInBean)mh.getBeanObject( bean_id, request, bean_name );
	//cancelled_by=bean.getCancellerName(slate_user_id);
	//Commented above line and added below codes for IN025649 by Anitha on 12/23/2010

	if(slate_user_id.equals(""))
	{
		slate_user_id=(String)session.getAttribute("login_user");
	}

	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs = null;
	try{
				conn = ConnectionManager.getConnection(request);
				pstmt=conn.prepareStatement("SELECT APPL_USER_NAME FROM SM_APPL_USER_LANG_VW WHERE APPL_USER_ID=UPPER('"+slate_user_id+"') AND LANGUAGE_ID = '"+locale+"'");
				rs=pstmt.executeQuery();
				if(rs.next()){
					cancelled_by=rs.getString("APPL_USER_NAME");
				}
				rs.close();
				pstmt.close();

	}
	catch(Exception e){
		e.printStackTrace();
	}
	finally{
			if(rs!=null)rs.close();
			if(pstmt!=null)pstmt.close();
			ConnectionManager.returnConnection(conn,request);

	}

//end

	//Commented and added below convertdate for 24585 on 10/22/2010 by AnithaJ  
	//cur_time=bean.getSysDateTime();
		ArrayList date_list = bean.getSysDateTime(); 
	 String cur_time = (String)date_list.get(0);
	//	cur_time = com.ehis.util.DateUtils.convertDate(cur_time,"DMYHM","en",locale);
	//Commented and added below convertdate for 24585 on 15/11/2010 by DhanasekarV  	
   String cur_time_txt = com.ehis.util.DateUtils.convertDate(cur_time,"DMYHM","en",locale);
		
%>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form name='CancelCheckInForm' id='CancelCheckInForm'>
<table border='0' cellpadding='3' cellspacing='0' width='100%'>
	<tr>
		<td class='CAGROUPHEADING' align='left' colspan='6'> 
		<B>
		<fmt:message key="Common.CancellationDetails.label" bundle="${common_labels}"/>		
		</B>
		</td>
	</tr>
	<tr>
			<td class='fields' width="25%"   >
					<fmt:message key="Common.cancelledby.label" bundle="${common_labels}"/> 
			</td>
			<td class='fields' width="25%">
					<input type ='text'  name='cancelled_by' id='cancelled_by' value='<%=cancelled_by%>' readonly>
			</td>

			<td class='fields' width="25%"  >
				<fmt:message key="Common.datetime.label" bundle="${common_labels}"/>
			</td>
			
			<td class='fields' width="25%" >
				<input type ='text'  name='cancel_date_txt' id='cancel_date_txt' value='<%=cur_time_txt%>'  size='12' readonly>
				<input type ='hidden'  name='cancel_date' id='cancel_date' value='<%=cur_time%>'>
			</td>
	</tr>

	<tr> 
		<td  class='fields' width="25%" valign='top' >
			<fmt:message key="Common.reason.label" bundle="${common_labels}"/>
		</td> 
		
		<td class='fields' width="25%" >
		   <input type='hidden' name='reason_code' id='reason_code' value=''>
		   <textarea name='reason_desc' rows='3' cols='40' readonly></textarea>
		</td>
		   
		 <td class='fields' width="25%" valign='top'>
			<input type='button' class='button' value='?' name='reasonLookUp' id='reasonLookUp' onClick='searchReason(reason_code,reason_desc);' > <img src='../../eCommon/images/mandatory.gif'></img>
		</td>
		 <td class='fields' width="25%">
			<input type='button' class='button' value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>' name='close' onClick="window.returnValue='';window.close();" >
		</td>
	</tr>
</table>
<input type ='hidden' name='slate_user_id' id='slate_user_id' value='<%=slate_user_id%>'>
<input type ='hidden' name='called_from' id='called_from' value='<%=called_from%>'>
<input type ='hidden' name='oper_num' id='oper_num' value='<%=oper_num%>'>
<input type ='hidden' name='locale' id='locale' value='<%=locale%>'>
</form>
</body>
</html>

