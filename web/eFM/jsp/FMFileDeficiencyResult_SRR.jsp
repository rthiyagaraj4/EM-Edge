<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*"  contentType="text/html; charset=UTF-8" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
 
<%
	//String p_module_id		= "FM" ;
	//String p_report_id		= "FMBDFTYP" ;
	//String p_facility_id	= (String) session.getValue( "facility_id" ) ;
	//String p_user_name		= (String) session.getValue( "login_user" ) ;
%>
<jsp:useBean id="cancelReserveBedDetail" class="webbeans.eCommon.RecordSet" scope="session"/> 
<html>
<HEAD>
<TITLE></TITLE>
<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
<%
	request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
<script src="../../eCommon/js/ValidateControl.js"></script>
<script src="../../eFM/js/FMFileDeficiencyReport_SRR.js" language="javascript"></script>
<script src="../../eFM/js/checkSystemDate.js" language="javascript"></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src="../../eCommon/js/CommonCalendar.js"></script>
<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>

</HEAD>

<BODY onMouseDown="CodeArrest();"  onKeyDown = 'lockKey();'>
<br>
<br>
<form name="Type" id="Type" action="../../eFM/jsp/FMFileDeficiencyResult_SRR.jsp"  method='post'>
<%
		Connection con			= null ;
	Statement stmt			= null ;
	ResultSet rs				= null ;
		String	req_start			= ""; 
		String  req_end			= "";
		String  checkedOnes		= "";
		String	from					= request.getParameter("from") ;
		String	to						= request.getParameter("to") ;
	   String selectvalue="";
	   String deficiency_code="";	
	String   long_desc="";	
	  String p_from_code=request.getParameter("from_code")==null?"":request.getParameter("from_code");
		String p_search_by=request.getParameter("serch_type")==null?"":request.getParameter("serch_type");
		//out.println("p_from_code---->"+p_from_code);
	//	out.println("p_search_by---->"+p_search_by);
		int		start					= 0;
		int		end					= 0;
		int		i						= 1;
		int		initCount				= 1;
		int		records_to_show	=9;
    
        if (from == null)
			{ start = 1 ; }  
		else
			{  start = Integer.parseInt( from ) ; }
     
		if (to == null)
			{ end =9 ; }
		else 
			{  end = Integer.parseInt( to ) ; }

        req_start       =   checkForNull(request.getParameter("start"),"0");
        req_end         =   checkForNull(request.getParameter("end"),"0");
		
		String classValue	= "" ;
		String next			= "";
		String prev			= "";

		try
		{
			con		= ConnectionManager.getConnection(request);
			String flagSelect = checkForNull(request.getParameter("fromSelect"));
			        
			if(!flagSelect.equals(""))
				cancelReserveBedDetail.clearAll();
		
			if(from != null && to != null)
			{
				int j=0;
				for( i=(Integer.parseInt(req_start)); i<= (Integer.parseInt(req_end)); i++)
				{
					if(request.getParameter("select_"+(i)) != null)
					{
						checkedOnes = request.getParameter("select_"+(i));
						
						if(!(cancelReserveBedDetail.containsObject(checkedOnes)))
							cancelReserveBedDetail.putObject(checkedOnes);

						j++;
					}
				}
		          
        }
        		i = 1 ;

				StringBuffer sql_count = new StringBuffer();

		stmt = con.createStatement();
	  	sql_count.append("select DEFICIENCY_CODE, LONG_DESC from fm_deficiency_lang_vw where EFF_STATUS='E' and language_id='"+localeName+"'");
		if(!p_from_code.equals("")){ 
			 if(p_search_by.equals("DC"))
				 {
					  sql_count.append(" and UPPER(DEFICIENCY_CODE) like UPPER('"+p_from_code+"%')");
		   	     }
			else if(p_search_by.equals("DD"))
						{
						 sql_count.append(" and  LOWER(LONG_DESC) like LOWER('"+p_from_code+"%')");
						}
			else 
					{
					  sql_count.append(" and (UPPER(DEFICIENCY_CODE) like UPPER('"+p_from_code+"%') OR LOWER(LONG_DESC) like LOWER('"+p_from_code+"%')) ");	
					}
		}
		
		

		rs = stmt.executeQuery(sql_count.toString());

		//out.println(sql_count.toString());
		if ( start != 0 )
		{
			for( int j=1; j<start; i++,j++ )
			{
				rs.next() ;
			}
			initCount+=start;
			--initCount;
		}

		int z=0;
		int maxRecord = 0;

		while((z < records_to_show) && rs.next())
		{
		
		if(maxRecord==0){
	%>
		<table >
		<tr>
		
	<table border='0' width='60%' align='center'>
		<tr>
		   
	<%
		if ( !(start <= 1))
		{
		
		%>
			
		<td align='right' width='92%' id='prev'><a href='javascript:call_previous(<%=(start-9)%>,<%=(end-9)%> )' text-decoration='none'><fmt:message key="Common.previous.label" bundle="${common_labels}"/></a></td>
		<%
		}
		
		%>
		
		<td  id='next' align='right' style='visibility:hidden'><a href='javascript:call_next(<%=(start+9)%>,<%=(end+9)%>)' text-decoration='none'><fmt:message key="Common.next.label" bundle="${common_labels}"/></a></td>
		<%
		//}
		%>
		</tr>
		</table>
		</tr>
		</table>
		<br>
		<br>

		
		
	<table border='1' width='60%' cellspacing='0' align='center'>
    		
		<tr>
		<th  nowrap><fmt:message key="eFM.DeficiencyCode.label" bundle="${fm_labels}"/></th>
		<th  nowrap><fmt:message key="eFM.DeficiencyType.label" bundle="${fm_labels}"/></th>
		
		<th  width='20%'><fmt:message key="Common.selectall.label" bundle="${common_labels}"/> <input type='checkbox' name='sel_all' id='sel_all' onClick='sel_all_chk()'></th>
		</tr>

		<%
		}

			String chkAttribute="";
					
					z++;
					if ( i % 2 == 0 )
						classValue = "QRYEVENSMALL" ;
					else
						classValue = "QRYODDSMALL" ;

					 long_desc=rs.getString("LONG_DESC");
					if(long_desc == null) long_desc="&nbsp;";
					
					deficiency_code = rs.getString("DEFICIENCY_CODE");
					if(deficiency_code== null) deficiency_code="&nbsp;";
								  
             selectvalue	= deficiency_code;
			if(cancelReserveBedDetail.containsObject(selectvalue)) 
				chkAttribute = "CHECKED";
			else
				chkAttribute="";

			int recordIndex = cancelReserveBedDetail.indexOfObject(selectvalue);

			if(recordIndex!=-1)
				if(chkAttribute.equals("CHECKED"))   
					cancelReserveBedDetail.removeObject(recordIndex); 
				
			
			 if(!next.equals(prev)) 
			{
				 %>
			<tr><td class='CAGROUPHEADING' colspan=12><%=next%></td></tr>
			<% }%>
			
			<!--<td class='<%=classValue %>' nowrap>+</td> -->
				<td class='<%=classValue %>' nowrap><%=deficiency_code%></td>
				<td class='<%=classValue %>' nowrap><%=long_desc%></td>
				<td  class='<%=classValue %>' nowrap><input type='checkbox'  <%=chkAttribute%> name='select_<%=i%>' value='<%=selectvalue%>' onClick='select_chk(this)'></td>
				<input type=hidden name='deficiency_code<%=i%>' id='deficiency_code<%=i%>' value='<%=deficiency_code%>'>
				<input type=hidden name='chkAttribute<%=i%>' id='chkAttribute<%=i%>' value='<%=chkAttribute%>'>
				</tr>
			
				<%
				prev = next;
				i++;
				maxRecord++;
			}//endwhile
		  //}

			
			if(maxRecord<8 || (!rs.next()))
			{%>
				<script >
					if (document.getElementById("next"))
						document.getElementById("next").style.visibility='hidden';
				</script>
			<%}
			else
			{%>
				<script >
					if (document.getElementById("next"))
						document.getElementById("next").style.visibility='visible';
				</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



			<%}

			if(maxRecord==0)
				out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));</script>");
			if(maxRecord!=0){%>
	</table>
		
<%}

		}catch(Exception e){

			out.println(e);
		}	
		finally 
		{
			    try
				{
					if(stmt!=null) 	stmt.close();
					if(rs!=null) 	rs.close();
				}
				catch(Exception e)
				{
				}
				ConnectionManager.returnConnection(con,request);
				session.setAttribute("cancelReserveBedDetail", cancelReserveBedDetail);
				
		}
	%>
	
		<input type="hidden" name='from' id='from' value='<%=start%>'>
		<input type="hidden" name='to' id='to' value='<%=end%>'>
		<input type="hidden" name='start' id='start' value='<%=start%>'>
		<input type="hidden" name='end' id='end' value='<%=end%>'>
		<input type="hidden" name="no_of_rec" id="no_of_rec" value="<%=i%>">
		<input type="hidden" name="final_vals" id="final_vals" value="">
		<input type="hidden" name="sel_rec" id="sel_rec" value="">		
		<input type="hidden" name="p_search_by" id="p_search_by" value="">	
		<input type="hidden" name="sel_from" id="sel_from" value="">
		<input type="hidden" name="sel_end" id="sel_end" value="">				
						
</form>
</BODY>
</HTML>
<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	private String checkForNull(String inputString,String defaultVal)
	{
		return (inputString==null)	?	defaultVal	:	inputString;
	}
%>

