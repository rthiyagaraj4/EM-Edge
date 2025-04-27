
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<HTML>
	<head>
<%
		 request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
 %>
		<!-- <modifeid by Arvind @09-12-2008> -->
		
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<Script Language='JavaScript' src='../../eCommon/js/ValidateControl.js'></Script>
		<!-- <script language='JavaScript' src='../../eCA/js/LocationforPractitioner.js'></script> -->
		<script src='../../eCommon/js/common.js' language='JavaScript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<script>
			function loadfunctionmsg()
			{
				parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp";
			}
		</script>
	</head>
	<BODY class='CONTENT'   OnMouseDown='CodeArrest()' onKeyDown='lockKey()'>
	<%
	Properties p = (Properties)session.getValue("jdbc");
	String locale	= (String) p.getProperty("LOCALE");
	String facility_id=(String) session.getValue("facility_id");
	String whereClause = request.getParameter("whereclause");
	if(whereClause==null) whereClause="";
	String from = request.getParameter( "from" ) ;
	String to = request.getParameter( "to" ) ;
	int i=0;
	String classValue="";
	String srl_no="";
	String locn_code="";
	String locn_type="";
	String locn_type_desc="";
	String locn_short_desc="";
	String practitioner_id="";
	String speciality_id="";
	String practitioner_name="";
	String eff_from_date="";
	String eff_to_date ="";
	practitioner_id=request.getParameter("practitioner_id");
	speciality_id=request.getParameter("speciality_id");
	
	if(speciality_id==null) speciality_id="";
		practitioner_name=request.getParameter("practitioner_name");
	if(practitioner_name==null) 
	{
		practitioner_name ="";
	}
	
	eff_from_date= request.getParameter("eff_from_date");

	if(eff_from_date==null) eff_from_date="";
		eff_to_date = request.getParameter("eff_to_date");
	if(eff_to_date==null) eff_to_date="";
	
	
	int start = 0 ;
	int end = 0 ;
	
	if (from == null)
		start = 1 ;
	else
		start = Integer.parseInt(from) ;
	if (to == null)
		end = 14 ;
	else
		end = Integer.parseInt( to ) ;

	Connection conn  =  null;
	PreparedStatement stmt = null;
	int maxRecord = 0;
	ResultSet rset = null;

	try
	{
		conn  =  ConnectionManager.getConnection(request);
		
		String str1sql="select count(*) from CA_LOCN_FOR_PRACT_VW where practitioner_id=? and facility_id = ?"; 
		stmt = conn.prepareStatement(str1sql);
		stmt.setString(1,	practitioner_id);
		stmt.setString(2,	facility_id);

		rset = stmt.executeQuery();
		rset.next();
		maxRecord = rset.getInt(1);
		if(rset!=null) rset.close();
		if(stmt != null) {stmt.close();stmt = null;}
		
		String Prac_name ="";
		String Prac_name_sql = "select PRACTITIONER_NAME from AM_PRACT_FOR_FACILITY_VW	where PRACTITIONER_ID= ? And OPERATING_FACILITY_ID = ? "  ;
		stmt = conn.prepareStatement(Prac_name_sql);
		stmt.setString(1,practitioner_id);
		stmt.setString(2,facility_id);

		rset = stmt.executeQuery();
	
		while(rset.next())
		{
			Prac_name = rset.getString("PRACTITIONER_NAME");
			practitioner_name = (Prac_name==null)?"":Prac_name ;
	%>
		<%
		}
		if(rset!=null) rset.close();
		if(stmt != null) {stmt.close();stmt = null;}
		
	
		String strsql1="Select locn_short_desc,to_char(Eff_from_Date,'dd/mm/yyyy') Eff_from_Date,to_char(eff_to_date,'dd/mm/yyyy') eff_to_date, locn_code, locn_type, practitioner_id,locn_type_desc,srl_no From CA_LOCN_FOR_PRACT_VW Where practitioner_id = ? And facility_id = ? order by locn_type,locn_short_desc";


		stmt = conn.prepareStatement(strsql1);
		stmt.setString(1,practitioner_id);
		stmt.setString(2,facility_id);

		rset = stmt.executeQuery();
		%>
	
		<table cellpadding='0' cellspacing='10' border='0' width='100%' align='center' >
			<tr>
			<td class='white' width='88%'></td> 
			<td  align='right' width='12%'>
			<%
		
				if (!(start <= 1))
					out.println("<A class='gidLink' HREF='../../eCA/jsp/LocationForPractList.jsp?from="+(start-14)+"&to="+(end-14)+"&practitioner_id="+URLEncoder.encode(practitioner_id)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");
				if (!((start+14) > maxRecord))
					out.println("&nbsp;<A class='gidLink' HREF='../../eCA/jsp/LocationForPractList.jsp?from="+(start+14)+"&to="+(end+14)+"&practitioner_id="+URLEncoder.encode(practitioner_id)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
			%>
				</td>
			</tr>
			</table>
			<table class='grid' border="1" width="100%" cellspacing='0' cellpadding='3'style="text-align:left;">
			<th class='columnheadercenter' width='25%'><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/></th>
			<th class='columnheadercenter' width='25%'><fmt:message key="Common.Location.label" bundle="${common_labels}"/></th>
			<th  class='columnheadercenter' width='20%'><fmt:message key="Common.EffectiveFrom.label" bundle="${common_labels}"/></th>
			<th  class='columnheadercenter' width='20%'><fmt:message key="Common.EffectiveTo.label" bundle="${common_labels}"/></th>
			<%
			if (start != 1)
				for(int j=1; j<start; i++,j++)
			rset.next() ;
			while (rset.next() && i<end)
			{
				if (i % 2 == 0)
					classValue = "gridData" ;
				else
					classValue = "gridData" ;
				out.println("<tr><td class='" + classValue + "'>");
				srl_no=rset.getString("srl_no");
				eff_from_date=rset.getString(2);

				if(eff_from_date==null) eff_from_date="";
				eff_to_date= rset.getString(3);
				if(eff_to_date==null) eff_to_date="";
				locn_code = rset.getString("locn_code");
				if(locn_code==null) locn_code="";
				locn_short_desc=rset.getString("locn_short_desc");
				if(locn_short_desc==null) locn_short_desc="";
				locn_type = rset.getString("locn_type");
				if(locn_type==null) locn_type="";
				locn_type_desc = rset.getString("locn_type_desc");
				if(locn_type_desc==null) locn_type_desc="";
				practitioner_id = rset.getString("practitioner_id");
				if(practitioner_id==null) practitioner_id="";
				eff_from_date	= com.ehis.util.DateUtils.convertDate(eff_from_date,"DMY","en",locale);
				eff_to_date	= com.ehis.util.DateUtils.convertDate(eff_to_date,"DMY","en",locale);

				out.println("<a class='gridLink' href='../../eCA/jsp/LocationForPractDetail.jsp?mode=modify&srl_no="+srl_no+"&practitioner_id="+practitioner_id+"&locn_code="+locn_code+"&locn_type="+locn_type+"&practitioner_name="+practitioner_name+"'" + " target='AddModify'  onclick='loadfunctionmsg()'>");
				out.println(locn_type_desc+"</a></td><td class='" + classValue + "'>");
				out.println(locn_short_desc+"</a></td><td class='" + classValue + "'>");
				if(!eff_from_date.equals(""))
					out.println( eff_from_date );
				else
					out.println("&nbsp;");
				out.println("</td><td class='" + classValue + "'>");
				if(!eff_to_date.equals(""))
					out.println(eff_to_date);
				else
					out.println("&nbsp;");
				out.println("</td></tr>");
				i++;
			}
			if(rset !=null) rset.close();
		if(stmt !=null) stmt.close();	
			%>
			</td></tr>
		</table>
		<center>
	<%
				
	}//try
	catch(Exception e)
	{
		//out.println("Exception="+e.toString());//COMMON-ICN-0181
                  e.printStackTrace();//COMMON-ICN-0181
	}
	finally
	{
		
		if(conn!=null){ConnectionManager.returnConnection(conn,request);}
	}

	%>
		</center>
	</BODY>
</HTML>

