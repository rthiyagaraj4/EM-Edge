<!DOCTYPE html>

<html>
<%@ page language="java" contentType="text/html;charset=UTF-8" import ="webbeans.eCommon.*,java.sql.*,java.util.*,com.ehis.util.*,java.text.*"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<jsp:useBean id="obj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>
<head>
<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'> -->
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
<script src='../../eCommon/js/common.js' language='javascript'></script>



<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
<Script src="../../eAM/js/OtherStaffForFacility.js" language="JavaScript"></Script>
<script language="javascript" src="../../eCommon/js/DateUtils.js"> </script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<script>
	
	async function showPractWindow(other_staff_id)
	{
	    var url     = "../../eAM/jsp/OtherStaffDtlsView.jsp?other_staff_id="+other_staff_id+"&fcall=call";
	    var dialogHeight    = "80vh" ;
		/* below lines moidified by Venkatesh.S agasint 57984 on 07-01-2015 */
	    var dialogWidth = "80vw" ;
		/*End 57984 */
	    var dialogLeft="";

	    var arguments   = "" ;
	    var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"; status=no;dialogLeft:"+dialogLeft+";";
	    var reportURL   = await top.window.showModalDialog( url, arguments, features ) ;
	}
	        
	function submitPrevNext(from, to){
	    document.forms[0].from.value = from;
	    document.forms[0].to.value = to; 
		//document.forms[0].from.
		var from=document.forms[0].from.value;
		var to=document.forms[0].to.value;
		//document.forms[0].finalSelect.value=parent.frames[0].temp1;
		//alert("temp :"+parent.frames[0].temp);
		document.forms[0].action="OtherStaffForFacilityResult.jsp?from="+from+"&to="+to;
		document.forms[0].target="";
		//ADDED BY SUJI KEERTHI FOR MOHE-CRF-0013
		var search_txt = document.forms[0].search_txt.value;
		var search_by = document.forms[0].search_by.value;
		//ENDED FOR MOHE-CRF-0013
	    document.forms[0].submit();
	}

</script>
<%

	String space="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+
				"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+
				"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
	
	int noOfRecords = 0;
	Connection con = null;
	PreparedStatement pstmt=null;
	ResultSet rs=null ;
	request.setCharacterEncoding("UTF-8");

	String finalSelect=request.getParameter("finalSelect");
	if(finalSelect == null) finalSelect="";

	String facility_id=request.getParameter("facility_id") ;
	if(facility_id == null) facility_id="";
	
	//ADDED BY SUJI KEERTHI FOR MOHE-CRF-0013
	String search_by=request.getParameter("search_by") ;
	if(search_by == null) search_by="";
	
	String search_txt=request.getParameter("search_txt") ;
	if(search_txt == null) search_txt="";
	//ENDED
	
	String from = request.getParameter("from") ;

	

    String to = request.getParameter("to") ;
	
	String eff_date_from  = "";
	String eff_date_to = "";
	String current_date="";

	int maxRecord = 0;
	int start = 0 ;
	int end = 0 ;
        if (from == null){ start = 0 ;  }   else {  start = Integer.parseInt( from ) ; }
        if (to == null){ end = 10 ; }   else {  end = Integer.parseInt( to ) ; }
        
        //ADDED BY SUJI KEERTHI FOR MOHE-CRF-0013
        if(search_by.equals("01"))
     	   search_by="OTHER_STAFF_ID";
         else if(search_by.equals("02"))
     	   search_by="OTHER_STAFF_NAME";
        //ENDED
	
	try{
		
		con = ConnectionManager.getConnection(request);

		
		String practSql = "select to_char(sysdate,'dd/mm/yyyy') d ,a.other_staff_id other_staff_id, b.other_staff_name other_staff_name, to_char(a.eff_date_from,'dd/mm/yyyy') eff_date_from, to_char(a.eff_date_to,'dd/mm/yyyy') eff_date_to, 'U' db_action from  am_other_staff_for_facility a, am_other_staff b where facility_id = ? and a.other_staff_id = b.other_staff_id "; 
				
				if(!search_by.equals("") && !search_txt.equals(""))
		          practSql=practSql+"and upper (b."+search_by+")  like upper('"+search_txt+"%')"; 


				practSql=practSql+" union all select to_char(sysdate,'dd/mm/yyyy') d,other_staff_id, other_staff_name,to_char(eff_date_from,'dd/mm/yyyy') eff_date_from ,to_char(eff_date_to,'dd/mm/yyyy') eff_date_to, 'I' db_action  from  am_other_staff  where eff_status = 'E' ";  

				if(!search_by.equals("") && !search_txt.equals(""))
		          practSql=practSql+"and upper("+search_by+")  like upper('"+search_txt+"%')"; 
					
					
				practSql=practSql+" and other_staff_id  not in ( select other_staff_id from am_other_Staff_for_facility where facility_id = ? ";

				if(!search_by.equals("") && !search_txt.equals(""))
		          practSql=practSql+"and upper("+search_by+")  like upper('"+search_txt+"%')"; 
					
				
				practSql=practSql+" )order by other_staff_name";
				
	pstmt=con.prepareStatement(practSql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
	pstmt.setString(1,facility_id);
	pstmt.setString(2,facility_id);

	rs=pstmt.executeQuery();
	rs.last();
	maxRecord = rs.getRow();

if(maxRecord == 0)
	{
		out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));</script>");
	}else
		{


if(maxRecord < end)
	noOfRecords = maxRecord-start;
	else if(maxRecord > 10)
		noOfRecords = 10;
	else
		noOfRecords = maxRecord;
//out.println("noOfRecords"+noOfRecords);
	rs.beforeFirst();
 
%>
<body  OnMouseDown="CodeArrest();"  class='CONTENT' onKeyDown = 'lockKey()'>
<form name='facility_form_result' id='facility_form_result' action=' ../../servlet/eAM.OtherStaffForFacilityServlet' method='post' >
<table border='0' cellpadding='0' cellspacing='0' width='80%' align='center'>
	<tr>
		<td class="white">
			<table border='0' align='right'>
			<tr>
				<td align='right' class='NONURGENT'><%=space%>
				

				<input type=hidden name='from'  id='from' value='<%=start%>'>
				<input type=hidden name='to' id='to value='<%=end%>'>
				<input type=hidden name='start' id='start' value='<%=start%>'>
				<input type=hidden name='end' id='end' value='<%=end%>'>
				<input type='hidden' name='search_by' id='search_by' value='<%=search_by%>'>
				<input type='hidden' name='search_txt' id='search_txt' value='<%=search_txt%>'>

				<%
				    if ( !(start <= 1)) {
				%>
				     <a href='javascript:submitPrevNext(<%=(start-10)%>,<%=(end-10)%>)' text-decoration='none'><fmt:message key="Common.previous.label" bundle="${common_labels}"/></a>
				     <input type=hidden name='whichPage' id='whichPage' value='prev'>
 
				<%
				}
			     if ( !((start+11) > maxRecord )){
				%>
			    &nbsp;&nbsp;&nbsp;&nbsp;<a href='javascript:submitPrevNext(<%=(start+10)%>,<%=(end+10)%>)' text-decoration='none'><fmt:message key="Common.next.label" bundle="${common_labels}"/></a>
			     <input type=hidden name='whichPage' id='whichPage' value='next'>
				<%
				}
				%>	
				</td>
			</tr>
		  </table>
        </td>
	</tr>	
		<tr>
			<td>	
				<table border='1' cellpadding='0' cellspacing='0' width='100%' align='center'>
					<tr>
					<td class='columnheader' width='1%' rowspan='2'>&nbsp;</td>
					<td class='columnheader' width='25%' rowspan='2'><fmt:message key="Common.OtherStaffName.label" bundle="${common_labels}"/></td>
					<td class='columnheader' align='center' colspan='2'> <fmt:message key="Common.EffectiveDate.label" bundle="${common_labels}"/> </td>
					<td class='columnheader' width='5%' nowrap rowspan='2'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></td>
					</tr>
					<tr>
					<td class='columnheader' align='center' width='12%'><fmt:message key="Common.from.label" bundle="${common_labels}"/>
					</td>
					<td class='columnheader' align='center' width='12%'><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
					</tr>
					<%
					String classValue="";
					String chkAttribute="";
					String other_staff_id="",other_staff_name="",dbaction="";
					int i=0;
			
						
					if (start != 0)
					{
					    for(int j=1; j<=start; i++,j++)
						{
							rs.next() ;
					    }
				    }
				
					while(rs.next() && i<end)
					{ 
						current_date=rs.getString("d");
						other_staff_id=rs.getString("other_staff_id");
						other_staff_name=rs.getString("other_staff_name");
						eff_date_from = rs.getString("eff_date_from")==null ? "":rs.getString("eff_date_from");
						eff_date_to = rs.getString("eff_date_to")==null ? "":rs.getString("eff_date_to");
						dbaction=rs.getString("db_action");

						if( i%2 == 0)  
							classValue="QRYEVEN";
						else
							classValue="QRYODD";

						
						String eff_date_from_disply=DateUtils.convertDate(eff_date_from,"DMY","en",localeName);
						String eff_date_to_disply=DateUtils.convertDate(eff_date_to,"DMY","en",localeName);
						%>
						<tr>
						<td width='1%' class='<%=classValue%>'><a href=javaScript:showPractWindow('<%=other_staff_id%>')>+</a>
						<input type='hidden' name='other_staff_id<%=i%>' id='other_staff_id<%=i%>' value='<%=other_staff_id %>'>
						</td>
						<td class='<%=classValue%>'><%=other_staff_name%></td>
						<td class='<%=classValue%>'>
							<input type=text name='eff_date_from<%=i%>' id='eff_date_from<%=i%>' value='<%=eff_date_from_disply%>' size=10 maxlength=10 onblur='parent.validate_date_from(this,eff_date_to<%=i%>);' >
							<input type="image" src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('eff_date_from<%=i%>');">
						</td>
						<td class='<%=classValue%>'>
							<input type=text name='eff_date_to<%=i%>' id='eff_date_to<%=i%>' value='<%=eff_date_to_disply%>' size=10 maxlength=10 onblur='parent.validate_date_to(this,eff_date_from<%=i%>);'>
							<input type="image" src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('eff_date_to<%=i%>');">
						</td>
					<%
					if(dbaction.equals("U"))
						{
							chkAttribute="CHECKED";
					%>
					<td align='center' class='<%=classValue%>'> <input type='checkbox'  name= 'select<%=i%>' <%=chkAttribute%> onclick="parent.checkActive(this)"> </td>
					<input type=hidden name='curr_db_action<%=i%>' id='curr_db_action<%=i%>' value='U'>
					<input type=hidden name='def_db_action<%=i%>' id='def_db_action<%=i%>' value='U'>
					<%		
						}						
						else
						{
							chkAttribute="";
					%>	
					<td align='center' class='<%=classValue%>'> <input type='checkbox'  name= 'select<%=i%>' <%=chkAttribute%> onclick="parent.checkActive(this)"> </td>
					<input type=hidden name='curr_db_action<%=i%>' id='curr_db_action<%=i%>' value='I'>
					<input type=hidden name='def_db_action<%=i%>' id='def_db_action<%=i%>' value='I'>	
					<%
						}
					%>
						
						</tr>
						<%
						i++;
					}		
			%>
				
		<%	 }


		//out.println("finalSelect :"+finalSelect);
		StringTokenizer steff=new StringTokenizer(finalSelect,"~");
		int temp1=steff.countTokens();
		for(int u3=0;u3<temp1;u3++)
		{
			//out.println("<script>alert(into);</script>");
			String st4=steff.nextToken();
			StringTokenizer st5=new StringTokenizer(st4,"$");
			
			String name=st5.nextToken();
			String status=st5.nextToken();
			String index=st5.nextToken();
			st5.nextToken();
			st5.nextToken();
			String date_from=st5.nextToken();
			String date_to=st5.nextToken();

					if(date_from.equals("null") || date_from.equals(" ") )
					{
					date_from="";
					}
					if(date_to.equals("null") || date_to.equals(" ")) 
					{
					date_to="";
					}

			
			if(status.equals("E"))
			{
				%><script>if(document.forms[0].<%=name%>) document.forms[0].<%=name%>.checked=true; if(document.forms[0].curr_db_action<%=index%>)
				{
					document.forms[0].curr_db_action<%=index%>.value='U'; //document.forms[0].def_db_action<%=index%>.value='U';
					document.forms[0].eff_date_from<%=index%>.value='<%=date_from%>';
					document.forms[0].eff_date_to<%=index%>.value='<%=date_to%>';

				}
				</script> <% }
			else
			{
				%>
				<script>if(document.forms[0].<%=name%>) document.forms[0].<%=name%>.checked=false; if(document.forms[0].curr_db_action<%=index%>)
				{
					document.forms[0].curr_db_action<%=index%>.value='I'; //document.forms[0].def_db_action<%=index%>.value='I'; 
					document.forms[0].eff_date_from<%=index%>.value="";
					document.forms[0].eff_date_to<%=index%>.value="";
				}</script>
			<% }

		}
		
		}
			  catch(Exception e){out.print(e);}
			  finally
			  {
			  if(rs!=null)		rs.close();
			  if(pstmt!=null)	pstmt.close();
			  ConnectionManager.returnConnection(con,request);
			  }%>

			</table>
		</td>
	</tr>
  </table>
  <input type=hidden name='function_name' id='function_name' value='insert'>
  <input type=hidden name='noOfRecords' id='noOfRecords' value='<%=maxRecord %>'>
  <input type='hidden' name='facility_id' id='facility_id' value='<%=facility_id%>' >
  <input type='hidden' name='finalSelect' id='finalSelect' value='<%=finalSelect%>'>
  <input type='hidden' name='sysdate' id='sysdate' value='<%=current_date%>'>
</form>
</body>
</html>


