<!DOCTYPE html>
<%@ page import ="java.util.*,java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>

<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String patient_id	="";
	String proc_code	="";
	String service_code	="";
	String from_date	="";
	String end_date		="";
	String strMode		="";
	String classValue	="";
	String code_set		="";
	String code			="";
	String procedure	="";
	String scheme		="";
	String date			="";
	String practitioner	="";
	String service_desc ="";
	String facility_name="";
	String facility_id	="";
	String encounter_id = "";
	String rowIDFields = "";
	String srl_no = "";
	String row_id="";
	String from = "";
	String to = "";
	String called_mod = "";
	
	StringBuffer sql			= new StringBuffer();
	StringBuffer strRowIdQuery	= new StringBuffer();

	int k	  =0;
	int count1=0;
	int start = 0;
	int end = 0;
	int tot=0;
		

	from = request.getParameter("from");
	to = request.getParameter("to");

	//int j = 0;
	if(from==null)
		start = 0;
	else 
		start = Integer.parseInt(from);					

	if(to==null)
		end=5;
	else
		end = Integer.parseInt(to);
    
	tot=request.getParameter("tot")==null?0:Integer.parseInt(request.getParameter("tot"));
	
   	rowIDFields  = request.getParameter("rowIDFields");

	strMode = request.getParameter("mode");

	if(strMode == null || strMode.equals(""))
		strMode = "";
		
	if(rowIDFields == null) 
		rowIDFields="";
    
    
	Connection con		=null;
	ResultSet rs		=null;
	PreparedStatement pstmt=null;
	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");
	
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<!-- <modifeid by Arvind @03-12-2008> -->

  
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script Language="JavaScript" src='../js/ProcedureList.js'></script>

<SCRIPT>
function Next(inputString)
{   
	var temp1=''; var increment=5;var tempRowIds = "";	
	var k = parent.frames[0].rowIDArrayProcList.length;	
	var patient_id    =	document.result_form.patientid.value;
	var proc_code     = document.result_form.proccode.value;
	var service_code  = document.result_form.servicecode.value;
	var code_set      = document.result_form.codeset.value;
	var from_date     = document.result_form.fromdate.value;
	var end_date      = document.result_form.enddate.value;
	var start         = document.result_form.startno.value;
	var end           = document.result_form.endno.value;
	var totcount	  =	document.result_form.count.value;
	var mode1         = document.result_form.mode.value;
	
	if( (parseInt(k,10) - parseInt(end,10)) < 6){
		if(mode1=="first")
			increment = (parseInt(k,10) - (parseInt(end,10)-1))-2;
		else
			increment = (parseInt(k,10) - parseInt(end,10))-2;
		}
	else
		increment = 4;
			
	if(inputString=='next')
	{   
		if(mode1=="first")
			var from1=(parseInt(end,10));
		else
			var from1=(parseInt(end,10)+1);
			var to1=(parseInt(from1,10)+parseInt(increment,10));
	}
	if(inputString=='prev')
	{   
		var to1=(parseInt(start,10)-1);
		var from1=(parseInt(to1,10)-4);
	}
	
	for(var j=parseInt(from1,10);j<=parseInt(to1,10);j++)
		temp1+="'"+parent.frames[0].rowIDArrayProcList[j]+"',";
		
		
	document.location.href="../../eCA/jsp/ProcedurelistResult.jsp?from="+from1+"&to="+to1+"&patient_id="+patient_id+"&proc_code="+proc_code+"&service_code="+service_code+"&code_set="+code_set+"&rowIDFields="+encodeURIComponent(temp1,"UTF-8")+"&from_date="+from_date+"&end_date="+end_date+"&tot="+totcount+"";
}
</SCRIPT>
</head>

<body  class='CONTENT' onMouseDown="CodeArrest()" onKeyDown="lockKey()"  onScroll='scrollTitleProcResult()' >
<form name='result_form' id='result_form'>

<%
	try
	{
		con				= ConnectionManager.getConnection(request);
		rs				=null;
		pstmt			=null;
		
		patient_id		=	request.getParameter("patient_id");
		proc_code		=	request.getParameter("proc_code");
		proc_code		=	proc_code.trim();
		service_code	=	request.getParameter("serv_code");
		code_set		=	request.getParameter("code_set")==null ? "N" : request.getParameter("code_set");
		encounter_id=request.getParameter("encounter_id")== null ? "N" : request.getParameter("encounter_id");
		called_mod=request.getParameter("encounter_id")== null ? "N" : request.getParameter("called_mod");
		
		if (service_code == null) 
			service_code="";

		from_date		=request.getParameter("from_date");
		end_date		=request.getParameter("to_date");
		
		if(patient_id==null)	
			patient_id = "";
		if(proc_code==null)
			proc_code="";
		if(service_code==null)
			service_code="";
		if(code_set==null)
			code_set="";
		if(from_date==null)
			from_date="";
		if(end_date==null)
			end_date="";
		
		from_date	= com.ehis.util.DateUtils.convertDate(from_date,"DMY",locale,"en");
		end_date	= com.ehis.util.DateUtils.convertDate(end_date,"DMY",locale,"en");

		 /* sql.append("Select a.rowid row_id,a.proc_narration procedure,a.proc_code,TERM_SET_DESC scheme, to_char(a.proc_date,'dd/mm/yyyy hh24:mi') proc_date,b.practitioner_name practitioner_name, a.PATIENT_ID, a.SRL_NO,a.proc_date dummydate, (select d.short_desc from am_service d where  d.service_code = c.service_code) service_desc, e.facility_name facility_name , a.facility_id facility_id, a.encounter_id encounter_id from pr_encounter_procedure a, am_practitioner b, pr_encounter c,  sm_facility_param e, mr_term_set f where a.PATIENT_ID = ? and b.practitioner_id=a.practitioner_id and c.facility_id = a.facility_id and c.encounter_id = a.encounter_id and e.facility_id = a.facility_id and f.term_set_id=a.PROC_CODE_SCHEME and ERROR_YN='N' ");
			
		if(!(code_set.equals("")))
			 sql.append( " and a.PROC_CODE_SCHEME=? ");
		
		if(!(proc_code.equals("")))
			 sql.append( " and a.proc_code=? ");
		
		if( (!(from_date.equals(""))) && (!(end_date.equals(""))) )
			 sql.append(" and to_date(a.proc_date) between to_date(?,'dd/mm/yyyy') and to_date(?,'dd/mm/yyyy') ");
		else if((end_date.equals("")) && !(from_date.equals("")))
			 sql.append(" and to_date(a.proc_date) >= to_date(?,'dd/mm/yyyy')");
		else if((from_date.equals("")) && !(end_date.equals("")))
			 sql.append(" and to_date(a.proc_date) <= to_date(?,'dd/mm/yyyy')");
 		else if(!(service_code.equals("")))
			 sql.append( " and c.service_code = ?");

		strRowIdQuery = strRowIdQuery.append(sql.toString());
		
		if (strMode.equals("first") )
		{
			strRowIdQuery = strRowIdQuery.append(" order by dummydate desc "); */
		
			sql.append("Select a.rowid row_id,(select SHORT_DESC from mr_term_code where TERM_CODE = rtrim(a.proc_code) and TERM_SET_ID = a.PROC_CODE_SCHEME) procedure,a.proc_code,TERM_SET_DESC scheme, to_char(a.proc_date,'dd/mm/yyyy hh24:mi') proc_date,AM_GET_DESC.AM_PRACTITIONER(a.practitioner_id,?,'2') practitioner_name, a.PATIENT_ID, a.SRL_NO,a.proc_date dummydate, AM_GET_DESC.AM_SERVICE(c.service_code,?,'2') service_desc, 			SM_GET_DESC.SM_FACILITY_PARAM(a.facility_id,?,'1') facility_name , a.facility_id facility_id, a.encounter_id encounter_id from pr_encounter_procedure a, pr_encounter c,  mr_term_set f where a.PATIENT_ID = ? and c.facility_id = a.facility_id and c.encounter_id = a.encounter_id and  f.term_set_id=a.PROC_CODE_SCHEME and ERROR_YN='N' ");
		
		if(!(encounter_id.equals("N")))			
			 sql.append( " and a.encounter_id=? ");		

		if(!(code_set.equals("")))
			 sql.append( " and a.PROC_CODE_SCHEME=? ");		
		
		if(!(proc_code.equals("")))
			 sql.append( " and a.proc_code=? ");
		
		if( (!(from_date.equals(""))) && (!(end_date.equals(""))) )
			 sql.append(" and to_date(a.proc_date) between to_date(?,'dd/mm/yyyy') and to_date(?,'dd/mm/yyyy') ");
		else if((end_date.equals("")) && !(from_date.equals("")))
			 sql.append(" and to_date(a.proc_date) >= to_date(?,'dd/mm/yyyy')");
		else if((from_date.equals("")) && !(end_date.equals("")))
			 sql.append(" and to_date(a.proc_date) <= to_date(?,'dd/mm/yyyy')");
		
		if(!(service_code.equals("")))
			 sql.append( " and c.service_code = ?");

		 
		strRowIdQuery.append("Select a.rowid row_id,a.proc_date dummydate from pr_encounter_procedure a, pr_encounter c,  mr_term_set f where a.PATIENT_ID = ? and c.facility_id = a.facility_id and c.encounter_id = a.encounter_id and  f.term_set_id=a.PROC_CODE_SCHEME and ERROR_YN='N' ");
			
		if(!(code_set.equals("")))
			 strRowIdQuery.append( " and a.PROC_CODE_SCHEME=? ");
		
		if(!(proc_code.equals("")))
			 strRowIdQuery.append( " and a.proc_code=? ");
		
		if( (!(from_date.equals(""))) && (!(end_date.equals(""))) )
			 strRowIdQuery.append(" and to_date(a.proc_date) between to_date(?,'dd/mm/yyyy') and to_date(?,'dd/mm/yyyy') ");
		else if((end_date.equals("")) && !(from_date.equals("")))
			 strRowIdQuery.append(" and to_date(a.proc_date) >= to_date(?,'dd/mm/yyyy')");
		else if((from_date.equals("")) && !(end_date.equals("")))
			 strRowIdQuery.append(" and to_date(a.proc_date) <= to_date(?,'dd/mm/yyyy')");
		
		if(!(service_code.equals("")))
			 strRowIdQuery.append( " and c.service_code = ?");		
		
		
		if (strMode.equals("first") )
		{
			strRowIdQuery.append(" order by dummydate desc ");
			pstmt=con.prepareStatement(strRowIdQuery.toString());
			
				pstmt.setString(++count1,patient_id);			
			
			if(!(code_set.equals("")))
				pstmt.setString(++count1,code_set);

			if(!(proc_code.equals("")))
				pstmt.setString(++count1,proc_code);
			
			if( (!(from_date.equals(""))) && (!(end_date.equals(""))) )
			{
				pstmt.setString(++count1,from_date);
				pstmt.setString(++count1,end_date);
			}
			else if((end_date.equals("")) && !(from_date.equals("")))
				 pstmt.setString(++count1,from_date);
			else if((from_date.equals("")) && !(end_date.equals("")))
				 pstmt.setString(++count1,end_date);

			if(!(service_code.equals("")))
				 pstmt.setString(++count1,service_code);
			
			rs=pstmt.executeQuery();
						
			while (rs.next())
			{
				row_id=rs.getString("row_id");
				%>
				<script>
					parent.frames[0].rowIDArrayProcList[<%=k%>]="<%=java.net.URLEncoder.encode(row_id)%>";
				</script>
				<%

					k++;
					tot++;
								
					if(k <= 5)
						rowIDFields = rowIDFields + "'" + java.net.URLEncoder.encode(row_id) + "'," ;
			}

			if(k==0)
			{ 
				%>
					<Script language=javascript>
						alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA",'Common'));
						parent.procedurelistresult.location.href='../../eCommon/html/blank.html'; 
					
					</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

				<%      
			}

			if(rs != null) rs.close();
			if(pstmt  != null) pstmt.close();
		}
%>
		
	<div id='divDataTitle' style='postion:relative'>
			
	<table class='grid' width='100%' id='dataTable'> 
<%		
		if(!rowIDFields.equals(""))
	   		sql.append(" and a.rowid in ("+java.net.URLDecoder.decode(rowIDFields.substring(0,rowIDFields.length()-1))+" )");
		sql.append(" order by dummydate desc ");
   		
		
		pstmt=con.prepareStatement(sql.toString());		
		
		count1=0;
		k=0;	
		
		pstmt.setString(++count1,locale);
		pstmt.setString(++count1,locale);
		pstmt.setString(++count1,locale);
		pstmt.setString(++count1,patient_id);	
		
	    if(!(encounter_id.equals("N")))
			pstmt.setString(++count1,encounter_id);

		if(!(code_set.equals("")))
			pstmt.setString(++count1,code_set);

		if(!(proc_code.equals("")))
			pstmt.setString(++count1,proc_code);
		
		if( (!(from_date.equals(""))) && (!(end_date.equals(""))) )
		{
			pstmt.setString(++count1,from_date);
			pstmt.setString(++count1,end_date);
		}
		else if((end_date.equals("")) && !(from_date.equals("")))
			 pstmt.setString(++count1,from_date);
		else if((from_date.equals("")) && !(end_date.equals("")))
			 pstmt.setString(++count1,end_date);
		if(!(service_code.equals("")))
			 pstmt.setString(++count1,service_code);
		
		rs=pstmt.executeQuery();
       
		if (rs !=null)
        {
        	while(rs.next())
			{
				if ( k%2 == 0 )
					classValue = "QRYEVEN" ;
				else
					classValue = "QRYODD" ;

				code			=rs.getString("proc_code");
				procedure		=rs.getString("procedure");
				scheme			=rs.getString("scheme");
				date			=rs.getString("proc_date");
				practitioner	=rs.getString("practitioner_name");
				service_desc	=rs.getString("service_desc");
				facility_name	=rs.getString("facility_name");
				facility_id		=rs.getString("facility_id");
				encounter_id	=rs.getString("encounter_id");				
				srl_no			=(rs.getString("srl_no")==null)?"":rs.getString("SRL_NO");
				date			=	com.ehis.util.DateUtils.convertDate(date,"DMYHM","en",locale);
				
				%>

					<tr style='background-color:;'  onclick='refer(this,7);'>
					<td class='gridData' width='' nowrap>
					<a class='gridLink'  href='ProcedurelistResultDetail.jsp?facility_id=<%=facility_id%>&proc_code=<%=code%>&encounter_id=<%=encounter_id%>&srl_no=<%=srl_no%>' target='procedurelistresultdetail'><%=code%></a></td>
					<td class='gridData' width='' nowrap><%=procedure%></td>
					<td class='gridData' width='' nowrap><%=scheme%></td>
					<td class='gridData' width='' nowrap><%=date%></td>
					<td class='gridData' width='' nowrap><%=facility_name%></td>
					<td class='gridData' width='' nowrap><%=practitioner%></td>
					<td class='gridData' width='' nowrap><%=service_desc%></td>
				</tr>
				
				<%
				k++;
		      }
		}
			
}
	catch(Exception e)
	{
		//out.print("ERROR"+e);//common-icn-0181
		e.printStackTrace();//COMMON-ICN-0181
		
	}
	finally
	{
		if(rs!=null)	rs.close();
		if(pstmt!=null) 	pstmt.close();
		ConnectionManager.returnConnection(con,request);

	}

%>
<input type="hidden" name="patientid" id="patientid" value="<%=patient_id%>">
<input type="hidden" name="fromdate" id="fromdate" value="<%=from_date%>">
<input type="hidden" name="enddate" id="enddate" value="<%=end_date%>">
<input type="hidden" name="proccode" id="proccode" value="<%=proc_code%>">
<input type="hidden" name="codeset" id="codeset" value="<%=code_set%>">
<input type="hidden" name="servicecode" id="servicecode" value="<%=service_code%>">
<input type="hidden" name="startno" id="startno" value="<%=start%>">
<input type="hidden" name="endno" id="endno" value="<%=end%>">
<input type="hidden" name="count" id="count" value="<%=tot%>">
<input type="hidden" name="mode" id="mode" value="<%=strMode%>">

<tr style='visibility:hidden'>
<td class='columnHeadercenter' width='' nowrap ><font size=1><fmt:message key="Common.code.label" bundle="${common_labels}"/></font></td>
<td class='columnHeadercenter' width='' nowrap><font size=1><fmt:message key="Common.Procedure.label" bundle="${common_labels}"/></font></td>
<td class='columnHeadercenter' width='' nowrap><font size=1><fmt:message key="Common.scheme.label" bundle="${common_labels}"/></font></td>
<td class='columnHeadercenter' width='' nowrap><font size=1><fmt:message key="Common.date.label" bundle="${common_labels}"/></font></td>
<td class='columnHeadercenter' width='' nowrap><font size=1><fmt:message key="Common.facility.label" bundle="${common_labels}"/></font></td>
<td class='columnHeadercenter' width='' nowrap ><font size=1><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></font></td>
<td class='columnHeadercenter' width='' nowrap><font size=1><fmt:message key="Common.service.label" bundle="${common_labels}"/></font></td>
</tr>

</table>

</form>
	<script>
		
		if(parent.procedurelisttitle.formProcedurelistTitle== null)
		{
			setTimeout('',500); // waiting for Title page to load
			
			if(parent.procedurelisttitle.formProcedurelistTitle!= null)
			{
				
				if ((parseInt(<%=start%>,10) <=1))
					parent.procedurelisttitle.document.getElementById("prevRecs").style.visibility = 'hidden';
				else
					parent.procedurelisttitle.document.getElementById("prevRecs").style.visibility = 'visible';			
				var len=parent.frames[0].rowIDArrayProcList.length;
				
				if(((parseInt(<%=start%>,10)+5) >= <%=tot%>))
					parent.procedurelisttitle.document.getElementById("nextRecs").style.visibility = 'hidden';
				else
					parent.procedurelisttitle.document.getElementById("nextRecs").style.visibility = 'visible';
			}
		
		}
		else
		{
			
			if ((parseInt(<%=start%>,10) <=1))
				parent.procedurelisttitle.document.getElementById("prevRecs").style.visibility = 'hidden';
			else
				parent.procedurelisttitle.document.getElementById("prevRecs").style.visibility = 'visible';			
			var len=parent.frames[0].rowIDArrayProcList.length;
			
			if(((parseInt(<%=start%>,10)+5) >= <%=tot%>))
				parent.procedurelisttitle.document.getElementById("nextRecs").style.visibility = 'hidden';
			else
				parent.procedurelisttitle.document.getElementById("nextRecs").style.visibility = 'visible';
		}
	</script> 
	<script>
			if(parent.procedurelisttitle.document.getElementById("dataTitleTable")==null)
			{
				setTimeout("alignHeading();",300);
			}
			else 
				alignHeading();
			</script>
</body>
</html>


<!--<script>alignWidthProcResult();</script> -->

