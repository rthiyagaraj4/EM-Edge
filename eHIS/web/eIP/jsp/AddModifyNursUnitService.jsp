<!DOCTYPE html>
 <html>
 <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>  
<%@ page language="java" import ="java.sql.Connection,java.sql.Statement,java.sql.ResultSet,webbeans.eCommon.*,java.util.HashMap,java.sql.*,java.util.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<jsp:useBean id="NursUnitService" class="webbeans.eCommon.RecordSet" scope="session"/> 
<jsp:useBean id="NursUnitDeptService" class="webbeans.eCommon.RecordSet" scope="session"/> 
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<head>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'>
<script src='../../eCommon/js/common.js' language='javascript'></script>


<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script language='javascript' src='../js/NursUnitService.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>

function addRemoveVal(obj, index)
{/*
	if(obj.checked == false)
	{
		var HTMLVal = "<HTML><BODY onKeyDown='lockKey()'><form name='oneform' id='oneform' method='post' action='NursUnitServiceDynamicValues.jsp'><input type='hidden' name='oneClear' id='oneClear' value='clearOnlyOne'><input type='hidden' name='index' id='index' value='"+index+"'></form></BODY></HTML>";
		parent.frames[2].document.write(HTMLVal);
		parent.frames[2].document.oneform.submit();
	}
	*/
}
</script>
<%


	request.setCharacterEncoding("UTF-8"); 
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

	String req_start = "", req_end = "";
    String checkedOnes	= "";
    String checkedDeptOnes	= "";
    String dept_code	= "";
	String from = (request.getParameter("from"));
	String to	= (request.getParameter("to"));
	int maxRecord = 0;
	int start = 0 ;
	int end = 0 ;
	int i=1;
	int cnt = 0;
	int nextOfRes = 1;

	if (from == null)
	{ start = 0 ;


	}   else {  start = Integer.parseInt( from ) ; }
	if (to == null){ end = 12 ; }   else {  end = Integer.parseInt( to ) ; }
	String removeCode = ""; 
       
   req_start       =   (request.getParameter("start")==null)?"0" :   request.getParameter("start");
   req_end         =   (request.getParameter("end")==null)?"0" :   request.getParameter("end");

	String effStatus	= "";
	Connection con		= null;
	Statement stmt3		= null;
	ResultSet rstlRs3	= null;
	Statement stmt		= null;
	ResultSet rs		= null ;
	PreparedStatement pstmt	= null;

	effStatus=request.getParameter("effStatus");
	if(effStatus == null) effStatus="";
	con = ConnectionManager.getConnection(request);

	try
	{	
		String facility_id		= (String)session.getValue("facility_id");
		String nursing_unit_code= checkForNull(request.getParameter("nursing_unit_code"));
		dept_code		= checkForNull(request.getParameter("dept_code"));
		String flagSelect		= request.getParameter("fromSelect");

		String search_by		= checkForNull(request.getParameter("search_by"));
		String search_txt		= checkForNull(request.getParameter("search_txt"));
		String search_criteria	=  "";
		String search_criteria2	=  "";
		String search_criteria3	=  "";

		 if(from != null && to != null)
             {
                     int j=0;
                     for( i=(Integer.parseInt(req_start)); i<=(Integer.parseInt(req_end)); i++)
                     {
                         if(request.getParameter("chk"+(i)) != null)
                         {
                             checkedOnes = request.getParameter("chk"+(i));
                             checkedDeptOnes = request.getParameter("deptCode"+(i));

                             if(!(NursUnitService.containsObject(checkedOnes)))
							 {
                                 NursUnitService.putObject(checkedOnes);
								 NursUnitDeptService.putObject(checkedDeptOnes);
							 }
							j++;
                         }

						removeCode = checkForNull(request.getParameter("removeCode"+(i)));
						if(removeCode.equals("Y"))
						{
							String spclCode = request.getParameter("spclCode"+(i));
							if((NursUnitService.containsObject(spclCode)))
							{
								int removeCodeIndex = NursUnitService.indexOfObject(spclCode);
								NursUnitService.removeObject(removeCodeIndex);
								NursUnitDeptService.removeObject(removeCodeIndex);
							}
						}
                     }
                 out.println("<input type=hidden name='pages' id='pages' value='multiple'>");
                 out.println("<input type=hidden name='totChecked' id='totChecked' value='"+j+"'>");
             }
        i = 1 ;

		if(search_by.equals("ID")) search_by = "01";
		if(search_by.equals("DESC")) search_by = "02";
		if(search_by.equals("")||(search_by == null)) search_by = "00";

		if(search_by != null && !search_by.equals("00"))
		{
		  if(search_txt != null && !search_txt.equals(""))
		  {
				if(search_by.equals("01"))
			  {
				  search_criteria  = " and UPPER(service_code) like UPPER('"+search_txt+"%') ";
				  search_criteria2 = " and UPPER(a.service_code) like UPPER('"+search_txt+"%') ";
				  search_criteria3 = " and UPPER(service_code) like UPPER('"+search_txt+"%') ";
			  }
			else if(search_by.equals("02"))
			  {	
			      search_criteria  = " and UPPER(service_short_desc) like UPPER('"+search_txt+"%')  ";
			      search_criteria2 = " and UPPER(a.service_short_desc) like UPPER('"+search_txt+"%') ";
			      search_criteria3 = " and UPPER(service_short_desc) like UPPER('"+search_txt+"%') ";
			  }
		  }
		}

		if(flagSelect != null)
		{
			NursUnitService.clearAll();
			NursUnitDeptService.clearAll();
			
			StringBuffer sqlinsVals = new StringBuffer();
			if(!dept_code.equals(""))
				sqlinsVals.append(" select SERVICE_CODE, DEPT_CODE from IP_NURS_UNIT_FOR_SERVICE_VW where NURSING_UNIT_CODE='"+nursing_unit_code+"' and dept_code = '"+dept_code+"' and FACILITY_ID='"+facility_id+"' ");
			else
				sqlinsVals.append(" select SERVICE_CODE, DEPT_CODE from IP_NURS_UNIT_FOR_SERVICE_VW where NURSING_UNIT_CODE='"+nursing_unit_code+"' and FACILITY_ID='"+facility_id+"' ");

			sqlinsVals.append(search_criteria);
	//	out.println("<script>alert(\"stmt3"+sqlinsVals.toString()+"\");</script>");
			stmt3=con.createStatement(); 
			rstlRs3 = stmt3.executeQuery(sqlinsVals.toString());


			if(rstlRs3 !=null)
			{
				while(rstlRs3.next())
				{
					NursUnitService.putObject(rstlRs3.getString(1));
					NursUnitDeptService.putObject(rstlRs3.getString(2));
				}
			}
		}
		if (rstlRs3 != null) rstlRs3.close();
		if (stmt3 != null) stmt3.close();

            
     
	String classValue	="";
	String chkAttribute	="";
	StringBuffer sql = new StringBuffer();
/*	

	sql.append(" SELECT A.service_code, c.short_desc short_desc , 'Y', a.DEPT_CODE, a.DEPT_SHORT_DESC ");
	sql.append(" FROM IP_NURS_UNIT_FOR_SERVICE_VW A, AM_FACILITY_SERVICE B, AM_SERVICE C ");
	sql.append(" WHERE A.facility_id= B.OPERATING_FACILITY_ID ");
	sql.append(" AND A.dept_code = B.dept_code ");
	sql.append(" AND A.facility_id='"+facility_id+"' ");			
if(!dept_code.equals(""))
	sql.append(" AND B.dept_code = '"+dept_code+"'");
	sql.append(" AND B.service_code = C.service_code ");
	sql.append(" AND nursing_unit_code='"+nursing_unit_code+"' ");
	sql.append(" AND A.service_code=b.service_code AND B.eff_status='E'");
	sql.append(" AND A.service_code not in (select service_code from ip_nursing_unit "); 
	sql.append(" Where nursing_unit_code='"+nursing_unit_code+"') ");
	sql.append(search_criteria2);
	sql.append(" UNION ");
	sql.append(" SELECT A.service_code, b.short_desc short_desc , 'N', a.DEPT_CODE, a.DEPT_SHORT_DESC ");
	sql.append(" FROM AM_FACILITY_SERVICE_VW A, AM_SERVICE B");
	sql.append(" WHERE A.service_code = B.service_code ");
if(!dept_code.equals(""))
	sql.append(" AND A.dept_code = '"+dept_code+"'");
	sql.append(" AND A.operating_facility_id='"+facility_id+"' ");
	sql.append(" and A.service_code NOT IN ( SELECT service_code ");
	sql.append(" FROM IP_NURS_UNIT_FOR_SERVICE ");
	sql.append(" WHERE facility_id='"+facility_id+"' ");
if(!dept_code.equals(""))
	sql.append(" AND dept_code = '"+dept_code+"'");
	sql.append(" AND nursing_unit_code='"+nursing_unit_code+"') ");
	sql.append(" and A.service_code not in (select service_code from ip_nursing_unit "); 
	sql.append(" Where nursing_unit_code='"+nursing_unit_code+"') ");
	sql.append(" AND A.eff_status='E' ");
	sql.append(search_criteria3);
	sql.append(" ORDER BY 2 ");
*/
	sql.append(" SELECT 'Y', a.dept_code, a.dept_short_desc, a.service_code, ");
	sql.append(" a.service_short_desc short_desc ");
	sql.append(" FROM IP_NURS_UNIT_FOR_SERVICE_VW a, AM_FACILITY_SERVICE b ");
	sql.append(" WHERE a.facility_id = b.operating_facility_id ");
	sql.append(" AND a.dept_code = b.dept_code ");
	sql.append(" AND a.service_code = b.service_code ");
	sql.append(" AND a.facility_id = '"+facility_id+"' ");
	sql.append(" AND nursing_unit_code = '"+nursing_unit_code+"' ");
	if(!dept_code.equals(""))
		sql.append(" AND A.dept_code = '"+dept_code+"'");
	sql.append(" AND b.eff_status = 'E' ");
	sql.append(" AND a.service_code NOT IN (SELECT service_code FROM ip_nursing_unit WHERE nursing_unit_code = '"+nursing_unit_code+"') ");
	sql.append(search_criteria2);
	sql.append(" UNION ");
	sql.append(" SELECT 'N', dept_code, dept_short_desc, service_code, ");
	sql.append(" service_short_desc short_desc ");
	sql.append(" FROM AM_FACILITY_SERVICE_VW ");
	sql.append(" WHERE operating_facility_id = '"+facility_id+"' ");
	if(!dept_code.equals(""))
		sql.append(" AND dept_code = '"+dept_code+"' ");
	sql.append(" AND service_code NOT IN ( SELECT service_code FROM ip_nurs_unit_for_service WHERE facility_id = '"+facility_id+"' ");
	/*if(!dept_code.equals(""))
		sql.append(" AND dept_code = '"+dept_code+"' ");
	if(!dept_code.equals(""))
		sql.append(" AND dept_code = '"+dept_code+"' ");*/
	sql.append(" AND nursing_unit_code = '"+nursing_unit_code+"' ) ");
	sql.append(" AND service_code NOT IN (SELECT service_code FROM ip_nursing_unit WHERE facility_id = '"+facility_id+"' ");
	/*if(!dept_code.equals(""))
		sql.append(" AND dept_code = '"+dept_code+"' ");
	if(!dept_code.equals(""))
		sql.append(" AND dept_code = '"+dept_code+"' ");*/
	sql.append(" AND nursing_unit_code = '"+nursing_unit_code+"' ) ");
	sql.append(" AND eff_status = 'E' ");
	sql.append(search_criteria3);
	sql.append(" ORDER BY short_desc ");



try
{
	stmt=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
	rs=stmt.executeQuery(sql.toString());
//out.println("<script>alert(\"sql"+sql.toString()+"\");</script>");
	rs.last();
	maxRecord = rs.getRow();
	rs.beforeFirst();
	if(maxRecord == 0)
	{
		out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));</script>");
		return;
	}
}catch(Exception e){
	//out.println(e);
	e.printStackTrace();
	}


//out.println("<script>alert(\""+maxRecord+"\");</script>");
//out.println(maxRecord+" | "+sql.toString());
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
	if(cnt ==0)
	{

%>
<body  onMouseDown="CodeArrest()" onKeyDown="lockKey()" onLoad='chkForSelectAll(<%=start%>,<%=end%>)' class='CONTENT' >
<form name='facility_form_result' id='facility_form_result' action='../../eIP/jsp/AddModifyNursUnitService.jsp' method='post' >

<table  width='90%' border=0 align='center'>
<tr>
<td align='right' class='NONURGENT'>
<input type=hidden name='nursing_unit_code' id='nursing_unit_code' value='<%=nursing_unit_code%>'>
<%
	if(!dept_code.equals(""))
	{	%>
		<input type=hidden name='dept_code' id='dept_code' value='<%=dept_code%>'>
<%	}	%>
<input type=hidden name='finalSelectedValues' id='finalSelectedValues' value=''>
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
<input type='hidden' name='selctAllCHk' id='selctAllCHk' value='<%=_chkAll%>'>

<%
    if ( !(start <= 1)) {
 
	out.println("<a href='javascript:submitPrevNext("+(start-12)+","+(end-12)+")' text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</a>");
	%>
    <input type=hidden name='whichPage' id='whichPage' value='prev'>

<%
    }
    if ( nextOfRes == 1 ){

    out.println("<a href='javascript:submitPrevNext("+(start+12)+","+(end+12)+")' text-decoration='none' id='nextval'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</a>");
	%>
    <input type=hidden name='whichPage' id='whichPage' value='next'>
<%
    }
%>
</td>
</tr>
</table>
		<table border='1' cellpadding='0' cellspacing='0' width='90%' align='center'>
			<th width='40%'><fmt:message key="eIP.AdditionalServices.label" bundle="${ip_labels}"/></th>
			<th width='30%'><fmt:message key="Common.department.label" bundle="${common_labels}"/></th>
			<th width='20%'><fmt:message key="Common.selectall.label" bundle="${common_labels}"/> <br><input type='checkbox' name='chkAll' id='chkAll' <%=_chkAll%> onClick='selectAll(this,<%=start%>,<%=end%>)'></th>
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

				String dept_code_vw		= rs.getString("DEPT_CODE");
				String dept_short_desc_vw	= rs.getString("DEPT_SHORT_DESC");
				String service_code=rs.getString("service_code");
				String short_desc=rs.getString("short_desc");
	
				if(NursUnitService.containsObject(service_code))  
					chkAttribute = "CHECKED";
				else
					chkAttribute = "";


				int recordIndex = NursUnitService.indexOfObject(service_code);
				if(recordIndex!=-1)
				{
					if(chkAttribute.equals("CHECKED"))    
					{
						NursUnitService.removeObject(recordIndex);
						NursUnitDeptService.removeObject(recordIndex);
					}
				}

					if( i%2 == 0)  
						classValue="QRYEVEN";
					else
						classValue="QRYODD";
					%>
				<tr>
					<td class='<%=classValue%>'><%=short_desc%></td>
					<td class='<%=classValue%>'><%=dept_short_desc_vw%></td>
					<td align='center' class='<%=classValue%>'><input type='checkbox' <%=chkAttribute%> name='chk<%=i%>'  value='<%=service_code%>' onclick = 'uncheckselectall(this,<%=i%>);'><input type='hidden' name='removeCode<%=i%>' id='removeCode<%=i%>' value=""><input type='hidden' name='spclCode<%=i%>' id='spclCode<%=i%>' value="<%=service_code%>"><input type='hidden' name='deptCode<%=i%>' id='deptCode<%=i%>' value="<%=dept_code_vw%>"></td>
				</tr>
				<%
				i++;
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

		if (rs != null) rs.close();
		if(rstlRs3 != null) rstlRs3 = null; 
		if (stmt != null) stmt.close();
		if(stmt3 != null)	stmt3 = null; 
		if(pstmt != null)	pstmt = null;

	 }catch(Exception e){
		 //out.println(e);
		 e.printStackTrace();
		 }
	  finally
	  {
		ConnectionManager.returnConnection(con,request);
		session.setAttribute("NursUnitService", NursUnitService);
		session.setAttribute("NursUnitDeptService", NursUnitDeptService);

	  }%>

</table>
</form>
</body>
</html>
<%!
	/// Added by Sridhar R , on 4/26/2005.. these functions will chk for null values & initialize inputString values...
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

