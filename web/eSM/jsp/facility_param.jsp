
<%@ page import="java.sql.*, java.net.*,webbeans.eCommon.*,org.json.simple.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%	
Connection con=null;
Statement st = null;
Statement stmt = null;
Boolean isGSTCodeApplicable = false; //Added by Ashwini on 28-Jun-2017 for AMS-CRF-0132
Boolean vatNoApplicable =false; //Added by Mano against MMS--DM-CRF-0118.3
Boolean isUserFacilityAppilcable = false;//added by kamatchi for MOHE-CRF-0012 ON 7-MAY-2020	
String create_facility_yn="";//added by kamatchi for MOHE-CRF-0012 ON 7-MAY-2020	

//added by kamatchi for MOHE-CRF-0012 ON 7-MAY-2020	
Properties p=(Properties)session.getValue("jdbc");
String globaluser = (String)p.getProperty("login_user"); 
try{	
	request.setCharacterEncoding("UTF-8");
	con = ConnectionManager.getConnection(request);
	st = con.createStatement() ;	
	ResultSet rs = null;	
	String from = request.getParameter( "from" ) ;
	String to = request.getParameter( "to" ) ;
	StringBuffer Where1=new StringBuffer();
	String whereClause = request.getParameter("whereclause");
	Where1=Where1.append(whereClause);
	int start = 0 ;
	int end = 0 ;
	int i=1;
	//Added by Ashwini on 28-Jun-2017 for AMS-CRF-0132
	isGSTCodeApplicable = eCommon.Common.CommonBean.isSiteSpecific(con, "MP", "GST_CODE");
	//Added by Mano against MMS--DM-CRF-0118.3
	vatNoApplicable = eCommon.Common.CommonBean.isSiteSpecific(con, "SM", "VAT_NO");
	//added by kamatchi for MOHE-CRF-0012 ON 7-MAY-2020	
	isUserFacilityAppilcable = eCommon.Common.CommonBean.isSiteSpecific(con, "SM", "USER_FACILITY_AUTHORIZATION");

%>
<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
<%
      String sStyle	=
      (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>

<script src="../js/facility_param.js"></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>



<center>
	
<%	String classValue = "" ;
	StringBuffer sql =new StringBuffer();
	
	String operation = request.getParameter( "operation" ) ;
	if ( operation == null ) operation = "" ;
	
	if ( operation.equalsIgnoreCase( "query" ) ) {	
	if ( (whereClause == null || whereClause.equals("")) )
		{
		 sql.append( "select c.ACCOUNTING_NAME_SHORT,a.facility_id, facility_name, gstin_facility, vat_no from sm_facility_param a,sm_acc_entity_param_facl b,sm_acc_entity_param c where a.facility_id = b.facility_id(+) and b.acc_entity_id = c.acc_entity_id(+) order by facility_id") ;		}		
		else	
		
		sql.append(Where1);
	
		
		if ( from == null )
					start = 1 ;
				else
					start = Integer.parseInt( from ) ;
			
				if ( to == null )
				  	end = 14 ;
				else
			end = Integer.parseInt( to ) ;
			int cnt = 0;
			String endOfRes="1";
			
		rs = st.executeQuery( sql.toString()) ;
						if ( start != 1 )
 		for( int j=1; j<start; i++,j++ )
			 rs.next() ;
	  
	  while ( i<=end  && rs.next()){
		  if(cnt==0){
		%>
		<p>
		<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()' >
		<table align='right'>
		<tr>
		<td>
	<%	
		if ( !(start <= 1) )
		{%>
		<A HREF='facility_param.jsp?from=<%=(start-14)%>&to=<%=(end-14)%>&operation=query&whereclause=<%=URLEncoder.encode(sql.toString())%>' text-decoration='none'><fmt:message key="Common.previous.label" bundle="${common_labels}"/></A>
		<%}		
		if (endOfRes.equals("1"))
		{%>
			
		<A id='nextval' HREF='facility_param.jsp?from=<%=(start+14)%>&to=<%=(end+14)%>&operation=query&whereclause=<%=URLEncoder.encode(sql.toString())%>' text-decoration='none'><fmt:message key="Common.next.label" bundle="${common_labels}"/></A>
	<%}sql.setLength(0);%>
		</td>
		</tr>
	</table>	
		<br><br>
	</p>

	
	<table border="1" width="100%" cellspacing='0' cellpadding='0'>

	<table border='1' width='100%' cellspacing='0' cellpadding='0'>
	<tr bgcolor=black>
	<th width = '15%'><fmt:message key="Common.FacilityID.label" bundle="${common_labels}"/></th>
	<!--Added by Ashwini on 28-Jun-2017 for AMS-CRF-0132-->
	<%if(isGSTCodeApplicable)
	{%>
	<th width = '15%'><fmt:message key="Common.GoodsandServicesTaxID.label" bundle="${common_labels}"/></th>
	<%}%>
	<%if(vatNoApplicable)
	{%>
    <th width = '15%'><fmt:message key="eSM.VatNo.label" bundle="${sm_labels}"/></th>  <!--added by Mano against MMS--DM-CRF-0118.3-->
	<%}%>
	<th width = '50%'><fmt:message key="Common.FacilityName.label" bundle="${common_labels}"/></th>
	<th width = '40%'><fmt:message key="Common.AccountingEntity.label" bundle="${common_labels}"/></th>
<%}
					
			if ( i % 2 == 0 )
				classValue = "QRYEVEN" ;
			else
				classValue = "QRYODD" ;
		%><tr><%		
			String acc_entity= rs.getString(1) ;			
			if (acc_entity==null) acc_entity="&nbsp;&nbsp;";
			String facility_id = "" + rs.getObject("FACILITY_ID") ;	

			//Added by Ashwini on 28-Jun-2017 for AMS-CRF-0132
			String gstin_facility= checkForNull(rs.getString(4),"&nbsp;") ;	
            
			//Added by Mano against MMS--DM-CRF-0118.3
            String vat_no= checkForNull(rs.getString(5),"&nbsp;") ;			
				

			String facility_name = "" + rs.getObject("FACILITY_NAME") ;	
			%>
			<td width = '15%' class='<%= classValue%>'>
			<a href='facility_param_form.jsp?facility_id=<%=URLEncoder.encode( facility_id )%>&operation=modify'><%=facility_id%></a> </td>	
			<!--Added by Ashwini on 28-Jun-2017 for AMS-CRF-0132-->
			<%if(isGSTCodeApplicable)
			{%>
			<td width='15%' class='<%=classValue%>'><%=gstin_facility%></td>
			<%}%>
			<%if(vatNoApplicable)
			{%>
            <td width='15%' class='<%=classValue%>'><%=vat_no%></td>
            <%}%>			
			<td width='50%' class='<%=classValue%>'><%=facility_name%></td>
			<td width='40%' class='<%=classValue%>'><%=acc_entity%></td>		
			</tr>
		<%
			i++;
								cnt++;
	} 
	if( cnt == 0 )
	out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','COMMON'));history.go(-1);</script>");
	if(!rs.next()&&cnt!=0){
		endOfRes="0";
		%>
		<script>
			document.getElementById("nextval").innerHTML=" ";
		</script>
	<%}	
		
		if ( rs != null )	rs.close() ;		
		if ( st != null )	st.close() ;
	%>	
		</tr>	
		</table>
	<%
	} 
	else 
	{
		String url = "../../eCommon/jsp/MstCodeToolbar.jsp?" ;	
		String params = request.getQueryString() ;	
		String source = url + params ;

		int count=0;
		stmt=con.createStatement();

		String sql_site=" select count(*) from  sm_site_param ";
		
		rs = stmt.executeQuery( sql_site ) ;
		if(rs!=null)
		{
			while(rs.next())
			{
				count=rs.getInt(1);
			}
		if ( rs != null )	rs.close() ;		
		if ( stmt != null )	stmt.close() ;		
		}
		if(count<=0)
		{
		%>
			<script>alert(getMessage('SITE_NOT_DEFINED','SM'));	
			self.location.href='../../eCommon/html/blank.html';</script>
		<%
		}
else
		{
	
	String Role_id ="";
	stmt=con.createStatement();	
	String responsibility_id= (String) session.getValue("responsibility_id");
	String sqlRole ="select ora_role_id  from sm_resp  where resp_id='"+responsibility_id+"' ";
	rs=stmt.executeQuery(sqlRole);
	if (rs !=null){
		while (rs.next()){
					Role_id=rs.getString(1);
			}
		if ( rs != null )	rs.close() ;		
		if ( stmt != null )	stmt.close() ;		
	}
	

	
			
//Commeted By Dharma on 26th Oct 2017 against 65529
/*if (!Role_id.equals("MEDADMIN"))
{
%>
<script>
var error=getMessage('INVALID_USER','SM');
alert(error);
self.location.href='../../eCommon/html/blank.html';
</script>
			  <%
	}*/
}

if(isUserFacilityAppilcable)//added by kamatchi for MOHE-CRF-0012 ON 7-MAY-2020	
		{
	JSONObject Json	= eSM.SMCommonBean.getUserFacilityAccessYN(con,globaluser);//added by kamatchi for MOHE-CRF-0012 ON 7-MAY-2020	
				create_facility_yn = (String) Json.get("create_facility_yn");//added by kamatchi for MOHE-CRF-0012 ON 7-MAY-2020	
if(create_facility_yn.equals("Y") )//added by kamatchi for MOHE-CRF-0012 ON 7-MAY-2020	
	   {
	%>
	<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src=<%= source %> frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>	
		<iframe name='f_query_add_mod' id='f_query_add_mod' 	src='../../eCommon/html/blank.html' frameborder=0 scrolling='auto' style='height:84vh;width:100vw'></iframe>
		<iframe name='messageFrame' id='messageFrame'		src='../../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='auto' style='height:8vh;width:100vw'></iframe>
	<%	
	}
	else
	   {
%>
		<SCRIPT>alert(getMessage('ACCESS_USER_FACILITY_DENIED','SM'));//added by kamatchi for MOHE-CRF-0012 ON 7-MAY-2020	
		document.location.href='../../eCommon/jsp/dmenu.jsp';//added by kamatchi for MOHE-CRF-0012 ON 7-MAY-2020	
		</SCRIPT>
		
<%	
			
			
	  }   
		}
		else{
%>
	<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src=<%= source %> frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>	
		<iframe name='f_query_add_mod' id='f_query_add_mod' 	src='../../eCommon/html/blank.html' frameborder=0 scrolling='auto' style='height:84vh;width:100vw'></iframe>
		<iframe name='messageFrame' id='messageFrame'		src='../../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='auto' style='height:8vh;width:100vw'></iframe>
	<%	
		}
	}
	}catch(Exception e){//out.println(e);
		e.printStackTrace();
	}
			finally {				
						ConnectionManager.returnConnection(con,request);
					}

%>
</center>
<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

