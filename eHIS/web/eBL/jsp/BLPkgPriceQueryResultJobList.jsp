<!DOCTYPE html>
<%@ page import= "webbeans.eCommon.*,eBL.Common.*,java.util.*,java.sql.*,java.text.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<HTML>
<HEAD>
</HEAD>
<%!
public String checkNull(String str){
	if(str==null || str.equals("")){
		str="";
	}
	return str;
}
		
%>
<%
	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script src="../../eCommon/js/CommonLookup.js" language="javascript"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	
<script>

$(document).ready(function () {	
	//load TabA by default	
	 $("#tabADiv").click(function(){
		var radios = jQuery("input[type='radio']");
		var strJobId =  radios.filter(":checked");

		$("#ProcessedDataDiv").load("../../eBL/jsp/BLPkgPriceQueryResultError.jsp",{jobId:strJobId.val(),type:"withouterror"});
		 $("#tabADiv").html("<a class='tabClicked' id='ProcessedWithoutError'><span class='tabSpanclicked' id='ProcessedWithoutErrorspan'>Processed Without Error</span></a>");
		 $("#tabBDiv").html("<a class='tabA' id='ProcessedWithError' ><span class='tabAspan' id='ProcessedWithErrorspan'>Processed With Error</span></a>"); 
	  });
	 
	 $("#tabBDiv").click(function(){		
		 var radios = jQuery("input[type='radio']");
		 var strJobId =  radios.filter(":checked");
			
		 $("#ProcessedDataDiv").load("../../eBL/jsp/BLPkgPriceQueryResultError.jsp",{jobId:strJobId.val(),type:"witherror"});
		 $("#tabADiv").html("<a class='tabA' id='ProcessedWithoutError'><span class='tabAspan' id='ProcessedWithoutErrorspan'>Processed Without Error</span></a>");
		 $("#tabBDiv").html("<a class='tabClicked' id='ProcessedWithError' ><span class='tabSpanclicked' id='ProcessedWithErrorspan'>Processed With Error</span></a>"); 
	  });	 
	 
	 $("#resizeBtn").click(function(){
		 var defValue = $(this).attr('defValue');
		 if(defValue =='expand'){
			$('#tableHeaderDiv').hide();
			$('#BLPkgPriceQueryResultDiv').hide();
			$(parent.BLPkgPriceQueryFrame.document).find('#BLPkgPriceQueryDiv').hide();
			$(this).attr('src','../../eOT/images/ShowLess.gif');
			$(this).attr('defValue','shrink');
		 }
		 else if(defValue =='shrink'){
			 $(this).attr('defValue','expand');
			 $('#tableHeaderDiv').show();
			 $('#BLPkgPriceQueryResultDiv').show();
			 $(parent.BLPkgPriceQueryFrame.document).find('#BLPkgPriceQueryDiv').show();
			 $(this).attr('src','../../eOT/images/ShowMore.gif');
		 }		
	 });	
	 
	  $(".radio").click(function(){		  
			 var strJobId=$(this).val();	
		     $("#ProcessedDataDiv").load("../../eBL/jsp/BLPkgPriceQueryResultError.jsp",{jobId:strJobId,type:"withouterror"});
			 $("#tabADiv").html("<a class='tabClicked' id='ProcessedWithoutError'><span class='tabSpanclicked' id='ProcessedWithoutErrorspan'>Processed Without Error</span></a>");
			 $("#tabBDiv").html("<a class='tabA' id='ProcessedWithError' ><span class='tabAspan' id='ProcessedWithErrorspan'>Processed With Error</span></a>"); 
		  });
});

function resultOnLoad(){	// This method is loaded by default
	$("#ProcessedDataDiv").load("../../eBL/jsp/BLPkgPriceQueryResultError.jsp",{jobId:$("#jobId0").val(),type:"withouterror"});
	$("#tabADiv").html("<a class='tabClicked' id='ProcessedWithoutError'><span class='tabSpanclicked' id='ProcessedWithoutErrorspan'>Processed Without Error</span></a>");
	$("#tabBDiv").html("<a class='tabA' id='ProcessedWithError' ><span class='tabAspan' id='ProcessedWithErrorspan'>Processed With Error</span></a>");	
}

function resultOnNoRecords(){
	alert("No Records Found");
	$("#tableHeaderDiv").hide();
}
</script>
<body onKeyDown= "lockKey();" onMouseDown="CodeArrest();" onSelect="codeArrestThruSelect();">
<form name='BLExtAccRcptTypeHeaderForm' id='BLExtAccRcptTypeHeaderForm' >
<div id="tableHeaderDiv">
<table id="JobListTable" width='100%'>			
<th><fmt:message key="eBL.JobList.label" bundle="${bl_labels}" /></th> <!--23-09-2020-->
</table>	
		
	<table width="100%">
		<tr>
		<td class='COLUMNHEADER' width='10%'><fmt:message key="Common.Select.label" bundle="${common_labels}"/> <!--23-09-2020-->
		<td class='COLUMNHEADER' width='10%'><fmt:message key="Common.SerialNo.label" bundle="${common_labels}" /></td>
		<td class='COLUMNHEADER' width='20%'><fmt:message key="eBL.JobId.label" bundle="${bl_labels}" /></td> <!--23-09-2020-->
		<td class='COLUMNHEADER' width='*'><fmt:message key="eBL.JobStatus.label" bundle="${bl_labels}" /></td>	<!--23-09-2020-->
		</tr>
	</table>
</div>
<div id="BLPkgPriceQueryResultDiv" STYLE="width:100%; height:80; overflow: auto;"> 
<table id="BLPkgPriceQueryResultTable" name="BLPkgPriceQueryResultTable" id="BLPkgPriceQueryResultTable" cellpadding=3 cellspacing=0  width="100%" align='left' border='0'>
<%	
	String userId = checkNull(request.getParameter("userId"));
	String jobNo=checkNull(request.getParameter("jobId"));
	String date=checkNull(request.getParameter("date"));

	String finalQuery= "select distinct a.job_no,jobs.job,DECODE (NVL (jobs.failures, 0), 0, '', 'Failed') job_status,a.pgm_date pgm_date "+
 	" from bl_package_price_updtn_req a, dba_jobs jobs where jobs.job (+)= a.oracle_job_no and TO_CHAR(a.added_date, 'dd/mm/yyyy')='"+date+"' ";

	if(!userId.equals("")){
		finalQuery+= " AND a.ADDED_BY_ID='"+userId+"'";
	}
	if(!jobNo.equals("")){
		finalQuery+= "  AND  a.job_no='"+jobNo+"' ";
	}	
	finalQuery+=" and a.job_no is not null ";
		 	
	
	finalQuery+=" ORDER BY pgm_date desc,job_no desc  ";
	Connection con=null ;
	PreparedStatement pstmt=null ;
	ResultSet rs=null ;
	int index=0;
	String acc_entity_code="";
	try {
			con = ConnectionManager.getConnection(request);
			System.err.println("Final Query ->"+finalQuery);
			pstmt = con.prepareStatement(finalQuery);
			System.err.println("159,pstmt-->"+pstmt);
			rs = pstmt.executeQuery() ;
			System.err.println("161,rs-->"+rs);
			int count = 0;
			if( rs != null ) 
			{	System.err.println("164,rs-->"+rs);
				while( rs.next())
				{ 	
				System.err.println("167,rs-->"+rs);
				count++;
				String  jobId = checkNull(rs.getString("job_no"));
				System.err.println("170,jobId-->"+jobId);
				String job=checkNull(rs.getString("JOB"));
				System.err.println("173,job-->"+job);
				String  jobStatus = checkNull(rs.getString("Job_status"));
				System.err.println("174,jobStatus-->"+jobStatus);
				
				if(("".equals(job))){
					System.err.println("175,inside if condition");
					jobStatus="Completed";
				}
				else if(!("".equals(job)) && "".equals(jobStatus)){
					System.err.println("175,inside elsecondition");
					jobStatus="In Progress";
				}		
	%>
	<tr>
	<td class='fields' width='10%'><input class='radio' type='radio' name='select' id='select'  value='<%=jobId%>' <%if(index==0){%>checked<%}%> ></td>
	<td class='fields' width='10%'><input type='hidden' size='5' name='serialNo<%=index%>' id='serialNo<%=index%>'  value='<%=count%>' ><%=count%></td>
	<td class='fields' width='20%'><input type='hidden' size='25' name='jobId<%=index%>' id='jobId<%=index%>' value='<%=jobId%>' ><%=jobId%></td>
	<td class='fields' width='*'><input type='hidden' size='50' name='jobStatus<%=index%>' id='jobStatus<%=index%>' value='<%=jobStatus%>' ><%=jobStatus%></td>
	</tr>
	<%
	index++;
	System.err.println("176,printing the index value : "+index);
		
		}
	}
	if( rs != null ) rs.close();
	if(pstmt!=null) pstmt.close();
	System.err.println("177,after index----->>");	
	}catch (Exception e) {
		System.err.println("178,inside catch");
		e.printStackTrace();
		System.err.println("Exception from Auto Fill Search Criteria :"+e);
		con.rollback();
	}
	finally
		{	
			System.err.println("178,inside finally");
			ConnectionManager.returnConnection(con, request);
		}
	%>
</table>
</div>

<%if(index>0){
	System.err.println("179,after index greater than zero");
	out.println("<script>resultOnLoad();</script>");	
%> 
<br><table cellpadding=3 cellspacing=0 border=0 width='100%' align="center">
<tr width='100%'>
	<td width="100%" class="white">
		<ul id='tablist' class='tablist'>
			<li class="tablistitem">
			<div id='tabADiv'></div>
			</li>
			<li class="tablistitem" >
			<div id='tabBDiv'></div>
			</li>	
			<li>
			<div>
				<img id="resizeBtn" alt="" defValue="expand" src="../../eOT/images/ShowMore.gif" style="visibility: visible;" ></a>
			</div>
			</li>
		</ul>
	</td>	
	</tr>
	<tr><td><div id='ProcessedDataDiv'></div></td></tr>
</table>
<%}else{
	System.err.println("180,inside else-->");
	out.println("<script>resultOnNoRecords();</script>");
}	
%>	
</form>
</body>
</HTML>

