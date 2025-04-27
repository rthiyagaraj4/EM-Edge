<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.*,eCommon.XSSRequestWrapper,java.util.*"%>
<%
	Connection connection		= null;
	PreparedStatement pstmt = null;
	ResultSet resultSet		= null;
%>

<html>

<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
 		<script language="JavaScript" src="../js/DurationType.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<script>
		function chkfunctinval(obj)
		{
			if(eval(obj.value)==0 || eval(obj.value)<0)
			{
				
				//alert("APP-002429 Desc should be greater than ZERO");
				alert(getMessage("AM0152","AM"));
				obj.focus();
				obj.select();
			}
		}    
		

		
		
		</script>

</head>
<body onKeyDown = 'lockKey()' OnMouseDown="CodeArrest();" >

<%
	
	
	ArrayList durationType = new ArrayList();

		String sql = "SELECT durn_desc,durn_type, durn_desc_loc_lang ,for_text_loc_lang FROM am_duration_type ORDER BY 1";
		try {
			request.setCharacterEncoding("UTF-8");
			request= new XSSRequestWrapper(request);
            response.addHeader("X-XSS-Protection", "1; mode=block");
            response.addHeader("X-Content-Type-Options", "nosniff");
			connection = ConnectionManager.getConnection(request);
			pstmt = connection.prepareStatement(sql) ;
			resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() ) {
				String record[] = new String[4];
				record[0] = resultSet.getString("durn_desc");
				record[1] = resultSet.getString("durn_type");
				record[2] = resultSet.getString("durn_desc_loc_lang");
				record[3] = resultSet.getString("for_text_loc_lang");
				durationType.add(record);
			}
			
				if(resultSet!=null) resultSet.close();
			if(pstmt!=null)	pstmt.close();
		} catch ( Exception e )	{
			e.printStackTrace();
			throw e ;
		} 
		finally   {
		
		ConnectionManager.returnConnection(connection,request);
		}
%>
<BR><BR>
<form name="duration_type" id="duration_type" method="post" target="messageFrame">
<br>
<table border='0' cellpadding=0 cellspacing=0 width="98%" align="center">
<tr>
	<td colspan=2 align=center>
		<table cellpadding=0 cellspacing=0 border=1 width='100%'>
		<tr><th colspan=3 align='center'><fmt:message key="eAM.InLocalLanguage.label" bundle="${am_labels}"/></th></tr>
		<tr>
		<th align='left'><fmt:message key="Common.type.label" bundle="${common_labels}"/></th>
		<th align='left' width='33%'><fmt:message key="Common.description.label" bundle="${common_labels}"/></th>
		<th align='left'><fmt:message key="eAM.ForText.label" bundle="${am_labels}"/></th>
		</tr>
		<%
			int ilRow=0;
			String slClassValue = "";

			
			for(int i=0; i<durationType.size(); i++){
				String[] record = (String [])durationType.get(i);
			
				if(ilRow % 2 == 0){
					slClassValue = "QRYEVEN";
				}else{
					slClassValue = "QRYODD";
				}
				if(record[2] == null) record[2] = "";
				if(record[3] == null) record[3] = "";

		%>
				<tr>
					<td  class="<%= slClassValue %>"><%=record[0]%> <input type=hidden name='typeCode<%=i%>' id='typeCode<%=i%>' value="<%=record[1]%>"></td>	
					<td  class='<%= slClassValue %>'><input type=text name='desc<%=i%>' id='desc<%=i%>' onKeyPress='return allowValidNumber(this,event,3,0);return allowValidNumber1(this)' onblur="chkfunctinval(this)" value="<%=record[2]%>" size='10' maxlength='10' onBlur = "return makeValidString(this)" > </td>	
					<td  class='<%= slClassValue %>'><input type=text name='forText<%=i%>' id='forText<%=i%>' onKeyPress='return CheckForSpecChars1(event);' value="<%=record[3]%>" size='3' maxlength='3' onBlur = "return makeValidString(this)">  </td>	
				</tr>
		<%	ilRow++;
			}
			

		%>
		</table> 
	</td>
</tr>
</table>
	<input type="hidden" name="totalSize" id="totalSize" value="<%=durationType.size()%>">
	<input type="hidden" name="allTypeCode" id="allTypeCode" value="">
	<input type="hidden" name="allDesc" id="allDesc" value="">
	<input type="hidden" name="allForText" id="allForText" value="">
</form>
<%durationType.clear();%>
</body>

</html>

