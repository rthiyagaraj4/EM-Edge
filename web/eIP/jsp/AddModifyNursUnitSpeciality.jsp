<!DOCTYPE html>
 <html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>  
<%@ page language="java" import ="java.sql.Connection,java.sql.Statement,java.sql.ResultSet,webbeans.eCommon.*,java.util.HashMap,java.sql.*,java.util.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<jsp:useBean id="NursUnitSpeciality" class="webbeans.eCommon.RecordSet" scope="session"/> 
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<head>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script language='javascript' src='../js/NursUnitSpeciality.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>

/*+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
Function Name :	RemSelectAll()
Purpose : To Uncheck the Select All CheckBox when atleast one of the CheckBox is Un Checked..
		  and also to assign value Y/N based on check option...
removeCode - used to remove the record from the recordSet bean..when chk box is unchecked..
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
function RemSelectAll(obj, i)
{
	
	document.forms[0].chkAll.checked = false;

	if(obj.checked == false)
		eval("document.forms[0].removeCode"+i).value = "Y";

	else
		eval("document.forms[0].removeCode"+i).value = "N";

}


</script>



<%

//MMS-ME-SCF-0096 vulnerability Issue
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff"); 
	//MMS-ME-SCF-0096 vulnerability Issue
String selctAllCHk=checkForNull(request.getParameter("selctAllCHk"));
	String _chkAll="";
	if(selctAllCHk.equals("Y"))
	_chkAll="checked";
	else
		_chkAll="";

String selectChkecked="";
		String selectChk=checkForNull(request.getParameter("selectChk"));
			if(selectChk.equals("Y"))
				selectChkecked="checked";
				else
				selectChkecked="";

				
	request.setCharacterEncoding("UTF-8");
	String req_start	="", req_end	="";
	String checkedOnes  ="";
	//String checkedOnes1  ="";
	String from	= request.getParameter("from") ;
	String to	= request.getParameter("to") ;
	int maxRecord = 0;
	int start = 0 ;
	int end = 0 ;
	int i=1;

	if (from == null){ start = 0 ;  }   else {  start = Integer.parseInt( from ) ; }
	if (to == null){ end = 12 ; }   else {  end = Integer.parseInt( to ) ; }
	
	

	String removeCode = "";
	//String removeCode1 = "";

	req_start       =   (request.getParameter("start")==null)   ?   "0" :   request.getParameter("start");
	req_end         =   (request.getParameter("end")==null)     ?   "0" :   request.getParameter("end");
	String effStatus		="";
	Connection con			= null;
	PreparedStatement pstmt	= null;
	Statement stmt3		= null;
	ResultSet rstlRs3	= null;
	Statement stmt		= null;
	ResultSet rs		= null;

	effStatus=request.getParameter("effStatus");
	if(effStatus == null) effStatus="";

	if(from != null && to != null)
	{
		int j=0;
		for( i=(Integer.parseInt(req_start)); i<=(Integer.parseInt(req_end)); i++)
		{
			if(request.getParameter("chk"+(i)) != null)
			{
				checkedOnes = request.getParameter("chk"+(i));
				//out.println("checkedOnes==="+checkedOnes);
				if(!(NursUnitSpeciality.containsObject(checkedOnes)))
					NursUnitSpeciality.putObject(checkedOnes);
				j++;
			}

			removeCode = checkForNull(request.getParameter("removeCode"+(i)));
			if(removeCode.equals("Y"))
			{
				String spclCode = request.getParameter("spclCode"+(i));
				if((NursUnitSpeciality.containsObject(spclCode)))
				{
					int removeCodeIndex = NursUnitSpeciality.indexOfObject(spclCode);
						NursUnitSpeciality.removeObject(removeCodeIndex);
				}
			}

		}
		out.println("<input type=hidden name='pages' id='pages' value='multiple'>");
		out.println("<input type=hidden name='totChecked' id='totChecked' value='"+j+"'>");
	}
	i = 1 ;

	try{
			
	con = ConnectionManager.getConnection(request);

	String facility_id			= (String)session.getValue("facility_id");
	String nursing_unit_code	= request.getParameter("nursing_unit_code");
	String flagSelect			= request.getParameter("fromSelect");

	String search_by		= checkForNull(request.getParameter("search_by"));
	String search_txt		= checkForNull(request.getParameter("search_txt"));
	String search_criteria	=  "";
	String search_criteria2	=  "";

	if(search_by.equals("ID")) search_by = "01";
	if(search_by.equals("DESC")) search_by = "02";
	if(search_by.equals("")||(search_by == null)) search_by = "00";

	if(search_by != null && !search_by.equals("00"))
	{
		if(search_txt != null && !search_txt.equals(""))
		{
			if(search_by.equals("01"))
			{
				search_criteria  = " and upper(speciality_code) like UPPER('"+search_txt+"%') ";
				search_criteria2 = " and upper(specialty_code) like UPPER('"+search_txt+"%') ";
			}
			else if(search_by.equals("02"))
			{	
				search_criteria  = " and upper(short_desc) like UPPER('"+search_txt+"%')  ";
				search_criteria2 = " and upper(specialty_short_desc) like UPPER('"+search_txt+"%') ";
			}
		}
	}

	if(flagSelect !=null)
	{
		NursUnitSpeciality.clearAll();
		StringBuffer sqlinsVals = new StringBuffer();
		sqlinsVals.append(" select SPECIALTY_CODE from IP_NURS_UNIT_FOR_SPECIALTY_VW   where NURSING_UNIT_CODE='"+nursing_unit_code+"' and FACILITY_ID='"+facility_id+"'   ");
		sqlinsVals.append(search_criteria2);

		stmt3=con.createStatement();
		rstlRs3 = stmt3.executeQuery(sqlinsVals.toString());
		if(rstlRs3 !=null)
		{
			 while(rstlRs3.next())
			 {
				NursUnitSpeciality.putObject(rstlRs3.getString(1));
			 }
		}
		if(rstlRs3 != null) rstlRs3.close();
		if(stmt3 != null) stmt3.close();
	}
	int recordCount			=	0;
    recordCount =NursUnitSpeciality.getSize();
	//out.println("recordCount=="+recordCount);

	int cnt = 0;
	int nextOfRes = 1;
	//static int ch;

	String classValue="";
	String chkAttribute="";
	StringBuffer sql = new StringBuffer();
	
	sql.append(" SELECT A.specialty_code, B.short_desc short_desc, 'Y' ");
	sql.append(" FROM IP_NURS_UNIT_FOR_SPECIALTY A, AM_SPECIALITY B ");
	sql.append(" WHERE A.facility_id='"+facility_id+"' ");
	sql.append(" AND nursing_unit_code='"+nursing_unit_code+"' ");
	sql.append(" AND A.specialty_code=b.speciality_code AND B.eff_status='E' ");
	sql.append(search_criteria);
	sql.append(" UNION ");
	sql.append("SELECT speciality_code, short_desc short_desc, 'N' ");
	sql.append(" FROM AM_SPECIALITY ");
	sql.append(" WHERE speciality_code NOT IN ( SELECT specialty_code ");
	sql.append(" FROM IP_NURS_UNIT_FOR_SPECIALTY ");
	sql.append(" WHERE facility_id='"+facility_id+"' ");
	sql.append(" AND nursing_unit_code='"+nursing_unit_code+"' ) ");
	sql.append(" AND eff_status='E' ");
	sql.append(search_criteria);
	sql.append("  ORDER BY 2 ");

	try
	{
		stmt=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
		rs=stmt.executeQuery(sql.toString());
		rs.last();
		maxRecord = rs.getRow();
		rs.beforeFirst();
		//out.println("maxRecord=="+maxRecord);
		if(maxRecord == 0)
		{
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));</script>");
			return;
		}
	}catch(Exception e)
	{
		//out.println(e);
		e.printStackTrace();
	}

	
	//if(rs != null)		rs.close();
	//if(stmt != null)	stmt.close(); 

	
	//out.println(sql.toString());
	//stmt=con.createStatement();
	//rs=stmt.executeQuery(sql.toString());

	if(start != 0)
	{
		for(int j=1; j<=start; i++,j++)
		{
			rs.next() ;
		}
	}
	while( i<=end && rs.next() )
	{ 
		if( cnt == 0 )
		{


%>

<body  onMouseDown="CodeArrest()" onKeyDown="lockKey()" onLoad='chkForSelectAll(<%=start%>,<%=end%>);chekSelectAll()' class='CONTENT' >
<form name='facility_form_result' id='facility_form_result' action='../../eIP/jsp/AddModifyNursUnitSpeciality.jsp' method='post' >
<table  width='90%' border=0 align='center'>
	<tr>
		<td align='right' class='NONURGENT'>
			<input type=hidden name='nursing_unit_code' id='nursing_unit_code' value='<%=nursing_unit_code%>'>
			<input type='hidden' name='finalSelectedValues' id='finalSelectedValues' value=''>
			<input type=hidden name='from' id='from' value='<%=start%>'>
			<input type=hidden name='to' id='to' value='<%=end%>'>
			<input type=hidden name='start' id='start' value='<%=start%>'>
			<input type=hidden name='end' id='end' value='<%=end%>'>
			<input type=hidden name='facility_id' id='facility_id' value='<%=facility_id%>' >
			<input type=hidden name='maxRecord' id='maxRecord' value='<%=maxRecord%>' >
			<input type=hidden name='function_name' id='function_name' value='insert'>
			<input type=hidden name='allValues' id='allValues' value=''>
			<input type="hidden" name="search_by" id="search_by" value=<%=search_by%>>
			<input type="hidden" name="search_txt" id="search_txt" value=<%=search_txt%>>
			<input type='hidden' name='selectChk' id='selectChk' value='<%=selectChk%>'>
			<input type='hidden' name='recordCount' id='recordCount' value='<%=recordCount%>'>
			<input type='hidden' name='chkcount1' id='chkcount1' value=''>
			<input type='hidden' name='selctAllCHk' id='selctAllCHk' value='<%=_chkAll%>'>


		<%	if(!(start <= 1)) 
			{	
				out.println("<a href='javascript:submitPrevNext("+(start-12)+","+(end-12)+")' text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</a>");
				%>
				<input type=hidden name='whichPage' id='whichPage' value='prev'>
		<%	}
			
			if( nextOfRes == 1 )
			{	
				out.println("<a id='nextval' href='javascript:submitPrevNext("+(start+12)+","+(end+12)+")' text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</a>");
				%>
				<input type=hidden name='whichPage' id='whichPage' value='next'>
		<%	}	%>

		</td>
	</tr>
</table>
		<table border='1' cellpadding='0' cellspacing='0' width='90%' align='center'>
			<th width='60%'><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></th>
			<th width='20%'><fmt:message key="Common.selectall.label" bundle="${common_labels}"/> <br><input type='checkbox' name='chkAll' id='chkAll' <%=_chkAll%> onClick='selectAll(this,<%=start%>,<%=end%>);'><input type='hidden' name='removeCodei' id='removeCodei' value=""><input type='hidden' name='spclCode1i' id='spclCode1i' value=""></th>
		<%	 
		}
			/*if(start != 0)
			{
				for(int j=1; j<=start; i++,j++)
				{
					rs.next() ;
				}
			}
			while(rs.next() && i<=end)
			{ */
				String speciality_code=rs.getString(1);
				
				String short_desc=rs.getString("short_desc");
				//recordCount =NursUnitSpeciality.getSize();
				//out.println("recordCount=="+recordCount);

				if(NursUnitSpeciality.containsObject(speciality_code))  
					chkAttribute = "CHECKED";
				else
					chkAttribute="";

				int recordIndex = NursUnitSpeciality.indexOfObject(speciality_code);
				if(recordIndex!=-1)
				if(chkAttribute.equals("CHECKED"))    									    	NursUnitSpeciality.removeObject(recordIndex);


			
			
					if( i%2 == 0)  
						classValue="QRYEVEN";
					else
						classValue="QRYODD";
					%>
				<tr>
					<td class='<%=classValue%>'><%=short_desc%></td>
					<td align='center' class='<%=classValue%>'><input type='checkbox' <%=chkAttribute%> name='chk<%=i%>' onclick="RemSelectAll(this, <%=i%>);" value='<%=speciality_code%>'><input type='hidden' name='removeCode<%=i%>' id='removeCode<%=i%>' value=""><input type='hidden' name='spclCode<%=i%>' id='spclCode<%=i%>' value="<%=speciality_code%>"></td>
				</tr>
		<%		i++;
				cnt++;
			}
			
			if( cnt == 0)
			{
				out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));</script>");
				return;
			}	

			if( !rs.next() && cnt!=0 )
			{
				nextOfRes=0;
			%>
			<script>
				document.getElementById("nextval").innerHTML = " ";
			</script>
			<%
			}

			if(rs != null)		rs.close();
			if(stmt != null)	stmt.close(); 
			if(pstmt !=null)	pstmt = null; 
		}catch(Exception e)
		{
			//out.println(e);
			e.printStackTrace();
		}
		finally
		{
			ConnectionManager.returnConnection(con,request);
			session.setAttribute("NursUnitSpeciality", NursUnitSpeciality);
		}	
%>

</table>
</form>
</body>
</html>

<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

