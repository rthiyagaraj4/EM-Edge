<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<jsp:useBean id="ClinicEventMaster" class="webbeans.eCommon.RecordSet" scope="session"/> 
<jsp:useBean id="getLincKey" scope="page" class="eCA._ca_license_rights"/>
<%!int row_count=0;%>
<html>
<head>
<title><fmt:message key="eCA.ClinicalEventParameter.label" bundle="${ca_labels}"/> <fmt:message key="Common.Update.label" bundle="${common_labels}"/></title>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		
		
		
		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
		<script src="../../eCommon/js/common.js" language="javascript"></script>
		<script language='javascript' src='../js/ClinicEventMaster.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<script>

	function checkVal(obj)
	{
		document.forms[0].dispMode.value = obj;
		document.forms[0].submit();
	}

	function chkunchk(Obj)
	{
		if(Obj.checked)
		{
			Obj.value="Y"
			document.forms[0].confirmyn.value='Y'
		}
		else
		{
			Obj.value="N"
			document.forms[0].confirmyn.value='Y'
		}
	}

	function prevRecs(start,end,search_by,search_text,search_criteria,hist_type,row_count)
	{
		//var row_count = document.forms[0].row_count.value;

		if(document.forms[0].confirmyn.value=="N")
		{
			parent.f_query_add_mod.location.href="../../eCA/jsp/ClinicEventMasterUpdate.jsp?from="+(start)+"&to="+(end)+"&search_by="+search_by+"&search_criteria="+search_criteria+"&hist_type="+hist_type+"&row_count="+row_count+"&search_text="+escape(search_text)
		}
		else
		{	
			upyesno=confirm("Update record");
	
			if(upyesno)
			{
				parent.f_query_add_mod.document.clinic_event_param_form.nextpervin.value='prv'
				parent.f_query_add_mod.document.clinic_event_param_form.submit() ;
			}
	/*		else
			{
				parent.f_query_add_mod.location.href="../../eCA/jsp/ClinicEventMasterUpdate.jsp?from="+(start)+"&to="+(end)+"&search_by="+search_by+"&search_criteria="+search_criteria+"&hist_type="+hist_type+"&row_count="+row_count+"&search_text="+search_text;
			}*/
		}
	}

	function nextRecs(start,end,search_by,search_text,search_criteria,hist_type,row_count)
	{
		//var row_count = document.forms[0].row_count.value;

		if(document.forms[0].confirmyn.value=="N")
		{
			parent.f_query_add_mod.location.href="../../eCA/jsp/ClinicEventMasterUpdate.jsp?from="+(start)+"&to="+(end)+"&search_by="+search_by+"&search_criteria="+search_criteria+"&hist_type="+hist_type+"&row_count="+row_count+"&search_text="+escape(search_text);
		}
		else
		{
			upyesno=confirm("Update record");
		
			if(upyesno)
			{
				parent.f_query_add_mod.document.clinic_event_param_form.nextpervin.value='nxt'
				parent.f_query_add_mod.document.clinic_event_param_form.submit() ;
			}
		/*	else
			{
				parent.f_query_add_mod.location.href="../../eCA/jsp/ClinicEventMasterUpdate.jsp?from="+(start)+"&to="+(end)+"&search_by="+search_by+"&search_criteria="+search_criteria+"&hist_type="+hist_type+"&search_text="+search_text+"&row_count="+row_count;
			}*/
		}
	}
	</script>
</head>

<%
Connection con			= null;
PreparedStatement pstmt = null;
ResultSet rs			= null;

//Modified by Archana @10-12-2008
String  MstQryPageCnt = (((session.getAttribute("MstQryPageCnt") != null) && (session.getAttribute("MstQryPageCnt") != "")))?((String)session.getAttribute("MstQryPageCnt")) : "14";
int pageCnt = Integer.parseInt(MstQryPageCnt);

int row_disp=pageCnt;
int start = 0 ;
int nTotalRecs = 0;
int end = 0 ;
int fm_disp=0, to_disp=0;
int ilCount=0;
int rowCount=0;
int j=0,i=0;
int numOfOrdChkdBoxes = 0;
int numOfAttChkdBoxes = 0;

String group_by="", grp_by_code="";
//String classValue="";
String classValue="gridData";
String from= "", to ="", dispMode="" ;
String row_count=request.getParameter("row_count")==null?"":request.getParameter("row_count");




dispMode		=	request.getParameter("dispMode") ;
from			=	request.getParameter( "from" ) ;

to				=	request.getParameter( "to" ) ;

if ( from == null || from=="null" || from.equals("null") )
	start = 1 ;
else
	start = Integer.parseInt( from ) ;

if ( to == null || to =="null" || to.equals("null") )
	end = row_disp;//7 ;
else
	end = Integer.parseInt( to ) ;

	String sql ="";
	String strOpMode						= "";

	String search_by=request.getParameter("search_by")==null?"":request.getParameter("search_by");

	
	String search_text=request.getParameter("search_text")==null?"":request.getParameter("search_text");
	
	String search_criteria=request.getParameter("search_criteria")==null?"":request.getParameter("search_criteria");
	String strTotRec		= request.getParameter("NoRecs")==null?"":request.getParameter("NoRecs");

	if ( !strTotRec.equals("")  && !strTotRec.equals("null") )
		nTotalRecs = Integer.parseInt( strTotRec ) ;
		

	String hist_type   = request.getParameter("hist_type");      

	strOpMode = request.getParameter("opmode")==null?"":request.getParameter("opmode");

	
	String hist_rec_type					= "";
	String event_code						= "";
	String event_desc						= "";
	String hist_rec_desc					= "";
	String create_review_ord_phys_yn        = "";
	String create_review_atn_phys_yn		= "";

	try
	{
		con = ConnectionManager.getConnection();

	if(strOpMode.equals("First"))
	{
		if(search_by.equals("C"))
			sql = "select  count(*) count from  cr_clin_event_mast a, cr_hist_rec_type b where a.hist_rec_type(+) = b.hist_rec_type and event_code is not null and b.hist_rec_type = ? and a.event_code like upper(?) " ;
		else
			sql = "select count(*) count from  cr_clin_event_mast a, cr_hist_rec_type b where a.hist_rec_type(+) = b.hist_rec_type and event_code is not null and b.hist_rec_type = ? and upper(a.long_desc) like upper(?) " ;

		if (search_criteria.equals("S"))
			search_text =  search_text+"%";
		
		if (search_criteria.equals("C"))
			search_text =  "%"+search_text+"%";
		if (search_criteria.equals("E"))
			search_text =  "%"+search_text;
	}
		if (strOpMode.equals("First") )
		{
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,hist_type);
			pstmt.setString(2,search_text);
	
			rs = pstmt.executeQuery();
   
			if(rs.next())
   			{	
			rowCount=rs.getInt("count");
		
		}
		}else
		{
		rowCount=Integer.parseInt(row_count);
		}

		if(rowCount<=0)
		{
			%>
				<script>
					var msg = getMessage("NO_RECORD_FOUND_FOR_CRITERIA","COMMON");	
					parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
				</script>
			<%
		}
		else
		{	
			if(search_by.equals("C"))
			{
				sql = "select b.hist_rec_type, b.long_desc hist_rec_desc, a.event_code,	a.long_desc event_desc,nvl(a.create_review_ord_phys_yn,'N')create_review_ord_phys_yn,nvl(a.create_review_atn_phys_yn,'N')create_review_atn_phys_yn  from  cr_clin_event_mast a, cr_hist_rec_type b where a.hist_rec_type(+) = b.hist_rec_type and event_code is not null and b.hist_rec_type = ? and a.event_code like upper(?) order by 1,2,3" ;
			}
			else
			{
				sql = "select b.hist_rec_type, b.long_desc hist_rec_desc, a.event_code,	a.long_desc event_desc,nvl(a.create_review_ord_phys_yn,'N')create_review_ord_phys_yn,nvl(a.create_review_atn_phys_yn,'N')create_review_atn_phys_yn  from  cr_clin_event_mast a, cr_hist_rec_type b where a.hist_rec_type(+) = b.hist_rec_type and event_code is not null and b.hist_rec_type = ? and upper(a.long_desc) like upper(?) order by 4" ;
			}
	 
			if (search_criteria.equals("S"))
				search_text =  search_text+"%";
			if (search_criteria.equals("C"))
				search_text =  "%"+search_text+"%";
			if (search_criteria.equals("E"))
				search_text =  "%"+search_text;
		

			%>
		
		<table cellpadding='3' cellspacing='0' border='0' width='90%' align='center'>
		<tr>
		
			<td colspan = 2 width = '40%'></td>
			<td  align='right' colspan =2 width='50%' >
		 <% 
			if ( !(start <= 1) )
			{
				%>	
				<a class='gridLink'  href='javascript:prevRecs("<%=(start-pageCnt)%>","<%=(end-pageCnt)%>","<%=search_by%>","<%=search_text%>","<%=search_criteria%>","<%=hist_type%>","<%=rowCount%>" )' > <fmt:message key="Common.previous.label" bundle="${common_labels}"/></a> 
				<%
			}
			if ( !( (start+pageCnt) > rowCount ) )
			{
				%>
				<a class='gridLink'  href='javascript:nextRecs("<%=(start+pageCnt)%>","<%=(end+pageCnt)%>","<%=search_by%>","<%=search_text%>","<%=search_criteria%>","<%=hist_type%>","<%=rowCount%>" )' ><fmt:message key="Common.next.label" bundle="${common_labels}"/></a>
				<%
			}
	  %>
		  </td>
		  </tr>
		  </table>
		
		  	<body class='CONTENT' onLoad="" onMouseDown="CodeArrest()" onKeyDown="lockKey()">
			<form name='clinic_event_param_form' id='clinic_event_param_form' action='../../servlet/eCA.ClinicEventMasterServlet' target='messageFrame'>
		<!-- 	<table cellpadding='3' cellspacing='0' border='1' width='90%'  align=center> -->
		 	<div style="display: flex; justify-content: center;">
		 	<table class='grid' width='90%'  align=center> 

		    <tr>
			<td class='COLUMNHEADERCENTER'><fmt:message key="Common.HistoryType.label" bundle="${common_labels}"/></td>
			<td class='COLUMNHEADERCENTER'><fmt:message key="Common.OrderingPract.label" bundle="${common_labels}"/>&nbsp;<input type='checkbox' name='orderingPractSelAll' id='orderingPractSelAll' onclick='selectAllPract(this)'></td>
			<td class='COLUMNHEADERCENTER'><fmt:message key="Common.AttendingPractitioner.label" bundle="${common_labels}"/>&nbsp;<input type='checkbox' name='attendingPractSelAll' id='attendingPractSelAll' onclick='selectAllPract(this)'></td>
		</tr>
		<%
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,hist_type);
			pstmt.setString(2,search_text);
		
			rs = pstmt.executeQuery();
		
			if ( start != 1 )
				for( int k=1; k<=start; i++,k++ )
				{
					rs.next() ;
				}

			while(rs.next()&& i<=end)
			{
				 /*if ( i % 2 == 0 )
					 classValue = "QRYEVEN" ;
				 else
					 classValue = "QRYODD" ;*/

				hist_rec_type			 = (rs.getString("hist_rec_type")==null)?"":rs.getString("hist_rec_type");
				hist_rec_desc			 = (rs.getString("hist_rec_desc")==null)?"":rs.getString("hist_rec_desc");
				event_code				 = (rs.getString("event_code")==null)?"":rs.getString("event_code");
				event_desc				 = (rs.getString("event_desc")==null)?"":rs.getString("event_desc");
				create_review_ord_phys_yn= (rs.getString("create_review_ord_phys_yn")==null)?"N":rs.getString("create_review_ord_phys_yn");
				create_review_atn_phys_yn=( rs.getString("create_review_atn_phys_yn")==null)?"N":rs.getString("create_review_atn_phys_yn");
				%>
				<input type='hidden' name='hist_rec_type<%=j%>' id='hist_rec_type<%=j%>' value="<%= hist_rec_type%>">
				<input type='hidden' name='event_code<%=j%>' id='event_code<%=j%>' value="<%= event_code%>">
				<tr>
					<td  align=left class='<%=classValue %>'  width="50%"><%=event_desc%></td>
					<td align=center  class='<%=classValue %>'><input type='checkbox'   name= 'Ord_phys_yn<%=j%>' <% if(create_review_ord_phys_yn.equalsIgnoreCase("Y")){ out.println("checked  value='Y' "); numOfOrdChkdBoxes++; }%>  width="25%" onclick='chkunchk(this)'></td>
					<td align=center class='<%=classValue %>'><input type='checkbox'  name='Atn_phys_yn<%=j%>' id='Atn_phys_yn<%=j%>' <% if(create_review_atn_phys_yn.equalsIgnoreCase("Y"))
					{ out.println("checked  value='Y' "); numOfAttChkdBoxes++; }%>  width="25%"onclick='chkunchk(this)'></td>
				</tr>
				<%
					i++;
					j++;
					ilCount++;
			}
		}
	}
	catch(Exception e)
	{
		//out.println("Exception in try :"+e.toString());//COMMON-ICN-0181
		e.printStackTrace();
	}
	finally
	{
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
		if(con!=null)ConnectionManager.returnConnection(con,request);
	}	

%>
	<td>
	</td>
	</table>
	</div>
	<input type="hidden" name="dispMode" id="dispMode" value=<%=dispMode%> > 
	<input type="hidden" name="from" id="from" value="<%=start%>">
	<input type="hidden" name="to" id="to" value="<%=end%>">
	
	<input type='hidden' name='fm_disp' id='fm_disp' value="<%=fm_disp%>">
	<input type='hidden' name='to_disp' id='to_disp' value="<%=to_disp%>">
	<input type="hidden" name="group_by" id="group_by" value="<%=group_by%>">
	<input type="hidden" name="grp_by_code" id="grp_by_code" value="<%=grp_by_code%>">
	<input type='hidden' name='count' id='count' value="<%=ilCount%>">
	<input type='hidden' name='row_count' id='row_count' value="<%=rowCount%>">
	
	<input type="hidden" name="search_criteria" id="search_criteria" value="<%=search_criteria%>">
	<input type='hidden' name='search_text' id='search_text' value="<%= search_text%>">
	<input type='hidden' name='hist_rec_type' id='hist_rec_type' value="<%=hist_type%>">
	<input type='hidden' name='search_by' id='search_by' value="<%=search_by%>">
	<input type='hidden' name='numOfOrdChkdBoxes' id='numOfOrdChkdBoxes' value="<%=numOfOrdChkdBoxes%>">
	<input type='hidden' name='numOfAttChkdBoxes' id='numOfAttChkdBoxes' value="<%=numOfAttChkdBoxes%>">

	
	<input type='hidden' name='nextpervin' id='nextpervin' value="">
	<input type='hidden' name='confirmyn' id='confirmyn' value="N">
</form>
<script>
	if('<%=ilCount%>' > 0)
		chkUnchkSelAll();
</script>
</body>
</html>


