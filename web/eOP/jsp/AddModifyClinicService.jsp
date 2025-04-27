<!DOCTYPE html>

<!-- Program for to display services for the clinic -->
<%@ page language="java" import ="webbeans.eCommon.*,java.sql.*,java.util.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>

<jsp:useBean id="accessRightRecSet" class="webbeans.eCommon.RecordSet" scope="session"/> 
<jsp:useBean id="accessRightRecSet_two" class="webbeans.eCommon.RecordSet" scope="session"/> 
<head>
<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'> -->
<%
request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script language='javascript' src='../js/ClinicService.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
       
/*	
  This function is used for Next and Previous Buttons.	
*/	
	function submitPrevNext(from, to,ccode,ctype,cind){
	    document.forms[0].from.value = from;
	    document.forms[0].to.value = to; 
		document.forms[0].submit();
	}

</script>
<%

/*
   Get the Information from the JSP page using getParameters.Based on the 
   values retrieve the Resultset from the database and display 10 records
   per page. Here  used one Bean class "RecordSet".
*/
		
		String  req_start   =   "", req_end     =   "";
	    String  checkedOnes         =   "";
		 String  checkedDeptOnes         =   "";
        String from = request.getParameter("from") ;
        String to = request.getParameter("to") ;
			
        //int maxRecord = 0;
        int start = 0 ;
        int end = 0 ;
		int i=1;
		int endOfRes = 1;
		
        if (from == null){ start = 0 ;  }   else {  start = Integer.parseInt( from ) ; }
        if (to == null){ end = 10 ; }   else {  end = Integer.parseInt( to ) ; }
       
	   req_start       =   (request.getParameter("start")==null)   ?   "0" :   request.getParameter("start");
	   req_end         =   (request.getParameter("end")==null)     ?   "0" :   request.getParameter("end");

	String effStatus="";
	Statement stmt3 = null;
	ResultSet rstlRs3 = null;

	effStatus=request.getParameter("effStatus");
	if(effStatus == null) effStatus="";
		Statement stmt=null;
		ResultSet rs=null ;

	Connection con = null;
	try{
			
	con = ConnectionManager.getConnection(request);

	
	String facility_id=(String)session.getValue("facility_id");
	String clinic_code=request.getParameter("clinic_code");
	String clinic_type=request.getParameter("clinic_type");
	String care_indicator=request.getParameter("care_indicator");
	String dept_code=checkForNull(request.getParameter("dept_code"));
	String dept_desc="";
	String dept_code1="";

	String flagSelect = request.getParameter("fromSelect");
	 String sqlinsVals="";
	 String removeCode="";
	/*
		To display the service for a particular clinic, use the 
		the query -This query fetches the service Code from the table op_clinic_for_service
  	based on clinic_code and dept_code and facility_id
	 *///added condition check clinic_type,CARE_LOCN_TYPE_IND by rajesh 19/10/2004 
	if(flagSelect !=null)
		{
	  		accessRightRecSet.clearAll();
			accessRightRecSet_two.clearAll();
			if(!dept_code.equals(""))
			{
	  	     sqlinsVals= " select SERVICE_CODE,DEPT_CODE  from OP_CLINIC_FOR_SERVICE where clinic_code='"+clinic_code+"' and dept_code= '"+dept_code+"' and clinic_type = '"+clinic_type+"'and CARE_LOCN_TYPE_IND = '"+care_indicator+"'and FACILITY_ID='"+facility_id+"' order by 1";
			}else
			{
			  sqlinsVals= " select SERVICE_CODE,DEPT_CODE  from OP_CLINIC_FOR_SERVICE where clinic_code='"+clinic_code+"' and clinic_type = '"+clinic_type+"'and CARE_LOCN_TYPE_IND = '"+care_indicator+"'and FACILITY_ID='"+facility_id+"' order by 1";
			}

			stmt3=con.createStatement();
			rstlRs3 = stmt3.executeQuery(sqlinsVals);
			
			if(rstlRs3 !=null)
				{
					 while(rstlRs3.next())
					 {
						accessRightRecSet.putObject(rstlRs3.getString(1));
						accessRightRecSet_two.putObject(rstlRs3.getString(2));
						
					 }
				}



				if(rstlRs3 != null) rstlRs3.close();
				if(stmt3 != null )stmt3.close();

	        	}
	 	        int recordCount			=	0;

			if(from != null && to != null)
             {
                     int j=0;
					for( i=(Integer.parseInt(req_start)); i<=(Integer.parseInt(req_end)); i++)
                     {
                         if(request.getParameter("chk"+(i)) != null)
                         {
                             checkedOnes = request.getParameter("chk"+(i));
							 checkedDeptOnes=request.getParameter("deptCode"+(i));

                             if(!(accessRightRecSet.containsObject(checkedOnes)))
							 {
                                 accessRightRecSet.putObject(checkedOnes);
							   accessRightRecSet_two.putObject(checkedDeptOnes);
							 }
                             j++;
                         }
						 removeCode = checkForNull(request.getParameter("removeCode"+(i)));
						if(removeCode.equals("Y"))
						{
							String spclCode = request.getParameter("spclCode"+(i));

							if((accessRightRecSet.containsObject(spclCode)))
							{
								int removeCodeIndex = accessRightRecSet.indexOfObject(spclCode);
								accessRightRecSet.removeObject(removeCodeIndex);
								accessRightRecSet_two.removeObject(removeCodeIndex);
							}
						}
                      }
			     %>
              <input type=hidden name='pages' id='pages' value='multiple'>
			  <input type=hidden name='totChecked' id='totChecked' value='<%=j%>'>
			 <%
			 }
           	i = 1 ;
     		String classValue="QRYODD";
			String chkAttribute="";

			StringBuffer sql=new StringBuffer();
			sql.append("SELECT A.service_code, c.short_desc short_desc, a.DEPT_SHORT_DESC dept_desc,a.dept_code dept_code,'Y' FROM op_clinic_for_service_vw a, am_facility_service b, am_service c WHERE a.facility_id = b.operating_facility_id AND a.dept_code = b.dept_code and  A.facility_id='"+facility_id+"'AND A.CARE_LOCN_TYPE_IND='"+care_indicator+"'AND A.clinic_type='"+clinic_type+"'");
				if(!dept_code.equals(""))
				sql.append("AND B.dept_code = nvl('"+dept_code+"',b.dept_code)");
				
			sql.append(" AND B.service_code = C.service_code  AND clinic_code='"+clinic_code+"' AND A.service_code=b.service_code AND B.eff_status='E' AND A.service_code not in (select service_code from op_Clinic  Where clinic_code='"+clinic_code+"') UNION SELECT A.service_code, a.SERVICE_SHORT_DESC short_desc ,a.DEPT_SHORT_DESC dept_desc,a.dept_code dept_code, 'N' FROM am_facility_service_vw a  WHERE ");
			sql.append("  operating_facility_id = '"+facility_id+"' "); 
			if(!dept_code.equals(""))
			sql.append("AND A.dept_code =nvl('"+dept_code+"',a.dept_code)");
			
			sql.append(" and A.service_code NOT IN ( SELECT service_code  FROM OP_CLINIC_FOR_SERVICE  WHERE facility_id='"+facility_id+"'AND CARE_LOCN_TYPE_IND='"+care_indicator+"'AND clinic_type='"+clinic_type+"' ");
				if(!dept_code.equals(""))
				sql.append("AND dept_code = nvl('"+dept_code+"',dept_code)");
				sql.append("AND clinic_code='"+clinic_code+"') and A.service_code not in (select service_code from op_Clinic Where clinic_code='"+clinic_code+"') AND A.eff_status='E' ORDER BY 2 ");
	 try{
		stmt=con.createStatement();
		rs=stmt.executeQuery(sql.toString());
	 }catch(Exception e){out.println(e);}

	 if (start != 0)
		for(int j=1; j<=start; i++,j++)			
				rs.next() ;

%>

<body  OnMouseDown="CodeArrest();"  class='CONTENT' onKeyDown = 'lockKey();'>

<% int sCnt=0; while( i<=end && rs.next()) { if (sCnt == 0) {%>

<form name='facility_form_result' id='facility_form_result' action='../../eOP/jsp/AddModifyClinicService.jsp' method='post' >
<p>
<table align='right'>
<tr>
<td>
<input type=hidden name='clinic_code' id='clinic_code' value='<%=clinic_code%>'>

<input type=hidden name='clinic_type' id='clinic_type' value='<%=clinic_type%>'>

<input type=hidden name='care_indicator' id='care_indicator' value='<%=care_indicator%>'>

<input type='hidden' name='finalSelectedValues' id='finalSelectedValues' value=''>
<%
	if(!dept_code.equals(""))
	{	%>
		<input type=hidden name='dept_code' id='dept_code' value='<%=dept_code%>'>
<%	}	%>
	<input type=hidden name='from' id='from' value='<%=start%>'>
<input type=hidden name='to' id='to' value='<%=end%>'>
<input type=hidden name='start' id='start' value='<%=start%>'>
<input type=hidden name='end' id='end' value='<%=end%>'>
<input type='hidden' name='facility_id' id='facility_id' value='<%=facility_id%>' >
<input type='hidden' name='function_name' id='function_name' value='insert'>
<input type='hidden' name='care_ind' id='care_ind' value=''>
<%
    if ( !(start <= 1)) {
%>
    <a href='javascript:submitPrevNext(<%=(start-10)%>,<%=(end-10)%>)' text-decoration='none'><fmt:message key="Common.previous.label" bundle="${common_labels}"/></a>
    <input type=hidden name='whichPage' id='whichPage' value='prev'>

<%
    }
    if ( endOfRes == 1) {
%>
    <a id='nextval' href='javascript:submitPrevNext(<%=(start+10)%>,<%=(end+10)%>)' text-decoration='none'><fmt:message key="Common.next.label" bundle="${common_labels}"/></a>
    <input type=hidden name='whichPage' id='whichPage' value='next'>
<%
    }
%>
</td>
</tr>
</table>	
<br><br>
</P>

		<%	

		recordCount =	accessRightRecSet.getSize();	

			%>
				<table border='1' cellpadding='0' cellspacing='0' width='100%' align='center'>
				<th class='columnheader' align='center'><fmt:message key="Common.service.label" bundle="${common_labels}"/></th>
				<th class='columnheader' align='center'><fmt:message key="Common.department.label" bundle="${common_labels}"/></th>
				<th class='columnheader' align='center'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>
			<%}

			String short_desc=rs.getString("short_desc");
			dept_desc=rs.getString("dept_desc");
			dept_code1 =rs.getString("dept_code");
			String room_num=  rs.getString("service_code");

			if(accessRightRecSet.containsObject(room_num))
					chkAttribute = "CHECKED";
				else
					chkAttribute="";


				int recordIndex = accessRightRecSet.indexOfObject(room_num);	
				if(recordIndex!=-1)
				{
					if(chkAttribute.equals("CHECKED"))  
					{
						accessRightRecSet.removeObject(recordIndex); 
						accessRightRecSet_two.removeObject(recordIndex); 
					}
					
				}
				if( classValue.equals("QRYODD")) 
					classValue="QRYEVEN";
				else	
					classValue="QRYODD";
				%>
			<tr>
				<td class='<%=classValue%>'><%=short_desc%></td>
				<td class='<%=classValue%>' nowrap><%=dept_desc%></td>
				<td align='center' class='<%=classValue%>'><input type='checkbox' <%=chkAttribute%>  name='chk<%=i%>'  value='<%=room_num%>' > <input type='hidden' value= '' name='no_of_beds<%=i%>' id='no_of_beds<%=i%>'></td>
			</tr>
					<input type='hidden' name='recordCount' id='recordCount' value='<%=recordCount%>' >
					<input type='hidden' name='deptCode<%=i%>' id='deptCode<%=i%>' value='<%=dept_code1%>'>
					<input type='hidden' name='room_num<%=i%>' id='room_num<%=i%>' value='<%=room_num%>'>
					<input type='hidden' name='finalval' id='finalval' value=''>
					<input type='hidden' name='dept_code_next' id='dept_code_next' value=''>
					
			<%			
				i++;
				sCnt++;				
			
			}
			if(sCnt == 0)
			{%>	
				<script>
				alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','COMMON'));
				//parent.frames[0].document.forms[0].submit();
				</script>
			<%}

			if(sCnt>0) { %>
				<input type='hidden' name='sCnt' id='sCnt' value="<%=sCnt%>">
				</table>
			<%}

			if (!rs.next() && sCnt!=0 )
			{
				endOfRes = 0;	
				%>
					<script>
					document.getElementById("nextval").innerHTML=" ";
					//document.getElementById("nextval").style.visibility='hidden';
					</script>					
				<%
			 }
		
		 if(rs !=null )rs.close();
    	  if(stmt != null )stmt.close();
		  
		}
		catch(Exception e){out.print(e);}
		finally
		{
		     try{
			 if(stmt != null){ stmt.close(); }
		     if(rs != null){ rs=null;}
		     if(stmt3 != null){ stmt3 .close();}
			 if(rstlRs3 != null){ rstlRs3 = null;} 
			 }catch(Exception e){}
			if(con != null) ConnectionManager.returnConnection(con,request);
			session.setAttribute("ClinicService", accessRightRecSet);
			session.setAttribute("ClinicDeptService", accessRightRecSet_two);
		}
		%>
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

