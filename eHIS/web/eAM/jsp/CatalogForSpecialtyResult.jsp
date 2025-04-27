<!DOCTYPE html>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*, java.util.*,java.text.*,webbeans.eCommon.*, eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<html>
	<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script src='../../eAM/js/CatalogForSpeciality.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
	
<% 
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String checkedOnes="";
	String ord_cat="";
	String first_time=request.getParameter("first_time");
	if(first_time==null)first_time="";

	HashMap statNationalRecSet= null;
	HashMap al= null;
	HashMap ArrLis= null;
	
	statNationalRecSet=(HashMap)session.getValue("StatNationalId");
	ArrLis=(HashMap)session.getValue("arrlis");
	al=(HashMap)session.getValue("al");
	if(first_time.equals("1")||statNationalRecSet==null)
	{

	statNationalRecSet=new HashMap();
	al=new HashMap();
	ArrLis = new HashMap();
	}

	String dtl_flag=request.getParameter("dtl_flag");
	
	Connection con = null;
	ResultSet rset=null ;
	Statement stmt=null;
	ResultSet rset1=null ;
	PreparedStatement pstmt = null;
	PreparedStatement pstmt1 = null;
	try{
		con = ConnectionManager.getConnection(request);


	if( dtl_flag.equals("insert"))
	{
try{
	stmt = con.createStatement();
	String param=request.getParameter("alphabet");
	String old_param=request.getParameter("old_param");
	if( param == null) param="";
	if( old_param == null) old_param="";
	 
	int maxrecord=0;
	int maxrecord1=0;
	
	int totprvrec=0;
	String classValue="";
	
	String totprvrec1=request.getParameter("totprvrec");
	String orcat ="";
		
	if(totprvrec1 == null)	totprvrec=0;
	else totprvrec = Integer.parseInt(totprvrec1) ;
	
	Collection ec= null;
	Iterator ie= null;
	
	


	try{
		for(int kk=0 ; kk<totprvrec ; kk++)
		{
			 ec = statNationalRecSet.values();
			 ie = ec.iterator();
			while(ie.hasNext())
			{
			String ext = (String)ie.next();
			boolean sb1 = ext.startsWith(old_param);
			
			if(sb1)
				{
					statNationalRecSet.remove(ext);
				}

			}
		}
	}catch(Exception e1){
		e1.printStackTrace();
		}
	
	String visit_type_id=request.getParameter("visit_type_id");
	String order_cat_id=request.getParameter("order_cat_id");
	String frmqry=request.getParameter("frmqry");
	
	if( visit_type_id == null) visit_type_id="";
	if( frmqry == null) frmqry="";
	if(!(frmqry.equals("")))
	{
	
	//rset = stmt.executeQuery("select ORDER_CATEGORY from OR_ORDER_CATALOG where ORDER_CATALOG_CODE ='"+frmqry+"'");
	
	String strStmt ="select ORDER_CATEGORY from OR_ORDER_CATALOG where ORDER_CATALOG_CODE =?";
	pstmt   = con.prepareStatement(strStmt);
	pstmt.setString	(	1,	frmqry		);
	rset		 = pstmt.executeQuery();
	
	if(rset != null)
	while(rset.next())
	{
		orcat = rset.getString("ORDER_CATEGORY");
	}

	order_cat_id = orcat;

	if(rset != null )rset.close();
	
	}

	if( order_cat_id == null) order_cat_id="";

	
	String sql="";
	if( ! param.equals(""))
	{
		
		if( param.equals("Others")){
			
		sql=" SELECT a.order_catalog_code, b.long_desc  FROM  am_catalog_for_speciality a, or_order_catalog b WHERE a.SPECIALITY_CODE = ?   AND b.order_category = ?   AND a.order_catalog_code = b.order_catalog_code    and upper(substr(b.long_desc,1,1)) not between 'A' and 'Z' UNION SELECT order_catalog_code, long_desc   FROM or_order_catalog  WHERE order_category = ?   AND eff_status = 'E'  and upper(substr(long_desc,1,1)) not between 'A' and 'Z' AND order_catalog_code NOT IN (SELECT e.order_catalog_code  FROM am_catalog_for_speciality e, or_order_catalog f WHERE  e.SPECIALITY_CODE = ? AND e.order_catalog_code = f.order_catalog_code AND f.order_category = ?   and upper(substr(f.long_desc,1,1)) not between 'A' and 'Z') order by long_desc  ";	
		
		pstmt   = con.prepareStatement(sql);
		pstmt.setString	(	1,	visit_type_id		);
		pstmt.setString	(	2,	order_cat_id		);
		pstmt.setString	(	3,	order_cat_id		);
		pstmt.setString	(	4,	visit_type_id		);
		pstmt.setString	(	5,	order_cat_id		);

		
		}else{

		sql = "SELECT a.order_catalog_code, b.long_desc   FROM am_catalog_for_speciality a, or_order_catalog b  WHERE a.SPECIALITY_CODE = ?   AND b.order_category = ?  AND a.order_catalog_code = b.order_catalog_code   AND UPPER (b.long_desc) LIKE '?%' UNION SELECT order_catalog_code, long_desc FROM or_order_catalog WHERE order_category = ? AND eff_status = 'E' and UPPER(LONG_DESC) LIKE '?%' AND order_catalog_code NOT IN (SELECT e.order_catalog_code FROM am_catalog_for_speciality e, or_order_catalog f WHERE e.SPECIALITY_CODE =  ? AND e.order_catalog_code = f.order_catalog_code AND f.order_category = ? AND UPPER (f.long_desc) LIKE '?%') order by long_desc";
		
			pstmt   = con.prepareStatement(sql);
			pstmt.setString	(	1,	visit_type_id		);
			pstmt.setString	(	2,	order_cat_id		);
			pstmt.setString	(	3,	param		);
			pstmt.setString	(	4,	order_cat_id		);
			pstmt.setString	(	5,	param		);
			pstmt.setString	(	6,	visit_type_id		);
			pstmt.setString	(	7,	order_cat_id		);
			pstmt.setString	(	8,	param		);
		}

	}
	else 
	{

		sql ="SELECT   a.order_catalog_code, b.long_desc  FROM am_catalog_for_speciality a, or_order_catalog b WHERE a.SPECIALITY_CODE = ? AND b.order_category = ? AND a.order_catalog_code = b.order_catalog_code ";
		pstmt   = con.prepareStatement(sql);
		pstmt.setString	(	1,	visit_type_id		);
		pstmt.setString	(	2,	order_cat_id		);
	}

	//rset=stmt.executeQuery(sql);
	rset		 = pstmt.executeQuery();
	
	String count="";
	
	if( ! param.equals(""))
	{
	
		if( param.equals("Others")){
		count="select count(*) as total from am_catalog_for_speciality a, or_order_catalog b WHERE  a.SPECIALITY_CODE = ?   AND b.order_category = ?   AND a.order_catalog_code = b.order_catalog_code    and upper(substr(b.long_desc,1,1)) not between 'A' and 'Z' UNION SELECT  count(*)  from  or_order_catalog  WHERE order_category = ? AND eff_status = 'E'  and upper(substr(long_desc,1,1)) not between 'A' and 'Z' AND order_catalog_code NOT IN (SELECT e.order_catalog_code FROM am_catalog_for_speciality e, or_order_catalog f WHERE  e.SPECIALITY_CODE = ? AND e.order_catalog_code = f.order_catalog_code AND f.order_category = ?   and upper(substr(f.long_desc,1,1)) not between 'A' and 'Z')";
		
		pstmt   = con.prepareStatement(count);
		pstmt.setString	(	1,	visit_type_id		);
		pstmt.setString	(	2,	order_cat_id		);
		pstmt.setString	(	3,	order_cat_id		);
		pstmt.setString	(	4,	visit_type_id		);
		pstmt.setString	(	5,	order_cat_id		);
		
		} else {
			count = "select count(*) as total from am_catalog_for_speciality a, or_order_catalog b  WHERE a.SPECIALITY_CODE = ?   AND b.order_category = ?  AND a.order_catalog_code = b.order_catalog_code   AND UPPER (b.long_desc) LIKE '?%' UNION SELECT count(*) FROM or_order_catalog  WHERE order_category = ?  AND eff_status = 'E' AND UPPER(LONG_DESC) LIKE '?%' and order_catalog_code NOT IN (SELECT e.order_catalog_code FROM am_catalog_for_speciality e, or_order_catalog f WHERE  e.SPECIALITY_CODE = ? AND e.order_catalog_code = f.order_catalog_code    AND f.order_category = ? AND UPPER (f.long_desc) LIKE '?%')";
			
			pstmt   = con.prepareStatement(count);
			pstmt.setString	(	1,	visit_type_id		);
			pstmt.setString	(	2,	order_cat_id		);
			pstmt.setString	(	3,	param		);
			pstmt.setString	(	4,	order_cat_id		);
			pstmt.setString	(	5,	param		);
			pstmt.setString	(	6,	visit_type_id		);
			pstmt.setString	(	7,	order_cat_id		);
			pstmt.setString	(	8,	param		);
		
		}

	}
	else
	{
		
		count="SELECT count(*) as total FROM am_catalog_for_speciality a, or_order_catalog b WHERE a.SPECIALITY_CODE = ? AND b.order_category = ? AND a.order_catalog_code = b.order_catalog_code";
		
		pstmt   = con.prepareStatement(count);
		pstmt.setString	(	1,	visit_type_id		);
		pstmt.setString	(	2,	order_cat_id		);

	}

	//pstmt=con.prepareStatement(count);
	rset1=pstmt.executeQuery();
	if(rset1 !=null)
	{
		while(rset1.next())
		{
		maxrecord1 = rset1.getInt("total");
		maxrecord = maxrecord+maxrecord1;
		
		}
	}

	if(rset1 != null )rset1.close();
	if(pstmt !=null ) pstmt.close();

	int i=0;
	
	if(maxrecord==0){

	if(!first_time.equals("1"))
	out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));</script>");
	}
 if(param.equals("")){
	
	try{
	
	String sqlVal="select b.long_desc from am_catalog_for_speciality a, OR_ORDER_CATALOG b where b.ORDER_CATALOG_CODE = a.ORDER_CATALOG_CODE and a.SPECIALITY_CODE='"+visit_type_id+"' "; 
	pstmt=con.prepareStatement(sqlVal);
	rset1 = pstmt.executeQuery();           
		
            if(rset1 !=null)
            {
                 while(rset1.next())
                 {
				    statNationalRecSet.put(""+rset1.getString(1)+"",rset1.getString(1));    
				 }
                
            }

		if(rset1 != null )rset1.close();
		if(pstmt != null )pstmt.close();

     }catch(SQLException e){
		 e.toString();
		 e.printStackTrace();
	
	}
 }
	 al = new HashMap();
		
	if( maxrecord > 0 )
	{
		pstmt = con.prepareStatement("select distinct upper(substr(short_desc,1,1))selaplha  from or_order_catalog where short_desc between 'A%' AND 'Z%' ");
		String selalpha = "";
		ArrayList hr = new ArrayList();
		rset1= pstmt.executeQuery();
		while (rset1.next())
		{
			selalpha = rset1.getString("selaplha");
			hr.add(selalpha);
		}

        if(rset1 != null )rset1.close();
		if(pstmt != null ) pstmt.close();

%>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
	<form name='stat_grp_nation_detail_result_form' id='stat_grp_nation_detail_result_form' action="../../eAM/jsp/CatalogForSpecialtyResult.jsp" method='post' >
	    <table cellspacing=0 cellpadding=0 width='100%' border=1>

	<TR id='alpha'>
		<%
		Iterator e7 = hr.iterator();

	hr.clear();
	         
	while(e7.hasNext())
		{
		 String jj = (String)e7.next();
		%>
<TD colspan='2' >
	<a href="javascript:callMember('<%=jj%>')"><%=jj%></a>&nbsp;&nbsp;
		<%}
		%>
		&nbsp;&nbsp;</td><td>
			<a href="javascript:callMember('Others')"><fmt:message key="Common.others.label" bundle="${common_labels}"/></a>&nbsp;&nbsp;
			</TD>
			</TR>
	</table><%
		String remmem=request.getParameter("remmem");
		if( remmem == null) remmem="";	
		
		try{
		if(!remmem.equals("R"))
		 {
			 StringTokenizer strtoken=new StringTokenizer(remmem,"|");
			while(strtoken.hasMoreTokens())
			{
				String rno=strtoken.nextToken();					
				statNationalRecSet.remove(rno);	
				ArrLis.put(""+rno+"",rno);
			}
		 }
			for(int kk=0 ; kk<totprvrec ; kk++)
				for(int in=0;in<totprvrec;in++){
				checkedOnes = request.getParameter("inc"+(in));
				if(checkedOnes==null) checkedOnes = "";
			
				if(!checkedOnes.equals(""))
                  {
				    al.put(""+checkedOnes+"",checkedOnes);
				    if(!(statNationalRecSet.containsKey(checkedOnes)))
					 {
						 statNationalRecSet.put(""+checkedOnes+"",checkedOnes);
                     }
				 }
		 	}

		}catch(Exception e){
			e.printStackTrace();
			}
			%>
		  <table cellspacing=0 cellpadding=0 width='100%' border=1>
	   		<tr>
				<td class='columnheader'  width='70%'><fmt:message key="Common.ordercatalog.label" bundle="${common_labels}"/></td>
				<td class='columnheader'  width='30%'><fmt:message key="Common.Include.label" bundle="${common_labels}"/></td>
			</tr>
			<% 
			
			String chkAttribute="";
		    if(rset!=null)
				{
					while(rset.next())
					{
						ord_cat=rset.getString("long_desc");
						if(statNationalRecSet.containsValue(ord_cat))
						{
							chkAttribute = "CHECKED";						
								
						}
						else
								chkAttribute="UNCHECKED";
             
				if ( (i+1) % 2 == 0 )
						classValue = "QRYEVEN" ;
				else
						classValue = "QRYODD" ;
						
			%>
				<tr>
					<td class='<%=classValue%>'><input type='hidden' name=code<%=i%> value='<%=rset.getString(1)%>' ><%=rset.getString("long_desc")%> </td>
					<% if( first_time.equals("1") ) { 
					
					%>
					<td class='<%=classValue%>' align='center'><input type='checkbox'  name='inc<%=i%>' id='inc<%=i%>'<%=chkAttribute%> value='<%=ord_cat%>' onclick = "remchk(this);">
					<% } else {
					%>
					<td class='<%=classValue%>' align='center'><input type='checkbox'<%=chkAttribute%> name='inc<%=i%>'value='<%=ord_cat%>'onclick = "remchk(this);">
				<% } %>
				</tr>
			<%		
					i++;

					}
				}

		if(rset != null )rset.close();
		if(stmt != null )stmt.close();
			
			%>
		 <input type ='hidden' name ='visit_type_id'  id ='visit_type_id' value ='<%=visit_type_id%>'> 
		 <input type ='hidden' name ='order_cat_id' id ='order_cat_id' value ='<%=order_cat_id%>'> 
		 <input type ='hidden' name ='old_param' value ='<%=param%>'> 
		 <input type ='hidden' name ='alphabet' id ='alphabet' value =' '>
		<input type ='hidden' name ='dtl_flag' id ='dtl_flag' value =' '>
		<input type ='hidden' name ='totprvrec' id ='totprvrec' value ='<%=maxrecord%>'>
		<input type ='hidden' name ='maxrecord' id ='maxrecord' value ='<%=maxrecord%>'>
		<input type='hidden' name='remmem' id='remmem' value='R' >
		<input type='hidden' name='recval' id='recval' value='1'>
		</table>

		</form>
		<form name='stat_grp_nation_detail_result_form1' id='stat_grp_nation_detail_result_form1'  method='post' target='parent.parent.frames[2]'>
		<input type='hidden' name='maxrecord' id='maxrecord' value=<%=maxrecord%> >
		<input type='hidden' name='insert_to_db' id='insert_to_db' value='' >
		<input type='hidden' name='function_name' id='function_name' value='insert' >
		</form>
	</body>
</html>
<%
}
else
{ 
%>	
	<body onKeyDown = 'lockKey()'>
   <form name='stat_grp_nation_detail_result_form2' id='stat_grp_nation_detail_result_form2'> 
   <input type ='hidden' name ='visit_type_id' value ='<%=visit_type_id%>'>
	<input type ='hidden' name ='order_cat_id' value ='<%=order_cat_id%>'>
		    <input type ='hidden' name ='alphabet' value =' '>
	    <input type ='hidden' name ='dtl_flag' value =' '>
	<input type='hidden' name='recval' id='recval' value='0'>
	
<%	if(first_time.equals("1"))
	{
	%>
	<script>callMember("A");</script>
	<% 
		first_time="2";
	}
	%>
	</form>
     <table cellspacing=0 cellpadding=0 width='100%' border=1>
	<TR id='alpha'>
			<TD colspan='2' >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href='javascript:callMember("A")'>A</a>&nbsp;&nbsp;<a href="javascript:callMember('B')">B</a>&nbsp;&nbsp;<a href="javascript:callMember('C')">C</a>&nbsp;&nbsp;<a href="javascript:callMember('D')">D</a>&nbsp;&nbsp;<a href="javascript:callMember('E')">E</a>&nbsp;&nbsp;<a href="javascript:callMember('F')">F</a>&nbsp;&nbsp;<a href="javascript:callMember('G')">G</a>&nbsp;&nbsp;<a href="javascript:callMember('H')">H</a>&nbsp;&nbsp;
			<a href="javascript:callMember('I')">I</a>&nbsp;&nbsp;<a href="javascript:callMember('J')">J</a>&nbsp;&nbsp;<a href="javascript:callMember('K')">K</a>&nbsp;&nbsp;<a href="javascript:callMember('L')">L</a>&nbsp;&nbsp;
			<a href="javascript:callMember('M')">M</a>&nbsp;&nbsp;<a href="javascript:callMember('N')">N</a>&nbsp;&nbsp;
			<a href="javascript:callMember('O')">O</a>&nbsp;&nbsp;<a href="javascript:callMember('P')">P</a>&nbsp;&nbsp;
			<a href="javascript:callMember('Q')">Q</a>&nbsp;&nbsp;<a href="javascript:callMember('R')">R</a>&nbsp;&nbsp;
			<a href="javascript:callMember('S')">S</a>&nbsp;&nbsp;<a href="javascript:callMember('T')">T</a>&nbsp;&nbsp;
			<a href="javascript:callMember('U')">U</a>&nbsp;&nbsp;<a href="javascript:callMember('V')">V</a>&nbsp;&nbsp;
			<a href="javascript:callMember('W')">W</a>&nbsp;&nbsp;<a href="javascript:callMember('X')">X</a>&nbsp;&nbsp;<a href="javascript:callMember('Y')">Y</a>&nbsp;&nbsp;<a href="javascript:callMember('Z')">Z</a>&nbsp;&nbsp;<a href="javascript:callMember('Others')"><fmt:message key="Common.others.label" bundle="${common_labels}"/></a>&nbsp;&nbsp;
			</TD>
		</TR>
<tr id='alpha1'><td colspan='2'>&nbsp;</td></tr></table>
<%	
}

} catch(Exception e){
	//out.println("here: ");
	//out.println(e);
	e.printStackTrace();
} 
finally{
	session.setAttribute("StatNationalId", statNationalRecSet);
	session.setAttribute("arrlis", ArrLis);
	session.setAttribute("al", al);

	statNationalRecSet.clear();
    al.clear();
	ArrLis.clear();
	}
} else
{
	try{
	stmt=con.createStatement();
	int maxrecord=0;
	String classValue="";	
	String visit_type_id=request.getParameter("visit_type_id");
	String order_cat_id=request.getParameter("order_cat_id");
	if( visit_type_id == null) visit_type_id="";
	if( order_cat_id == null) order_cat_id="";
	
	//String sql="select b.long_desc from op_catalog_for_clinic a, OR_ORDER_CATALOG b where b.ORDER_CATALOG_CODE = a.ORDER_CATALOG_CODE and a.CLINIC_CODE='"+visit_type_id+"' ";
		
	//rset=stmt.executeQuery(sql);
	
	String sql="select b.long_desc from op_catalog_for_clinic a, OR_ORDER_CATALOG b where b.ORDER_CATALOG_CODE = a.ORDER_CATALOG_CODE and a.CLINIC_CODE=?";
	
	pstmt1   = con.prepareStatement(sql);
	pstmt1.setString	(	1,	visit_type_id		);
	rset		 = pstmt1.executeQuery();

	
	//String count="select count(*) as total  from op_catalog_for_clinic a, OR_ORDER_CATALOG b where b.ORDER_CATALOG_CODE = a.ORDER_CATALOG_CODE and a.CLINIC_CODE='"+visit_type_id+"' ";

	String count="select count(*) as total  from op_catalog_for_clinic a, OR_ORDER_CATALOG b where b.ORDER_CATALOG_CODE = a.ORDER_CATALOG_CODE and a.CLINIC_CODE=?";
	
	pstmt=con.prepareStatement(count);
	pstmt.setString	(	1,	visit_type_id		);
	rset1=pstmt.executeQuery();
	if(rset1!=null)
	{
		while(rset1.next())
		{
		maxrecord = rset1.getInt("total");
		}
	}

	if(rset1 != null )rset1.close();
    if(pstmt != null) pstmt.close();	
 
	int i=0;
%>

	<body onKeyDown = 'lockKey()'>
	<form name='stat_grp_nation_detail_result_form' id='stat_grp_nation_detail_result_form'>
		<table cellspacing=0 cellpadding=0 width='100%' border=1>
			<tr>
				<th ><fmt:message key="Common.service.label" bundle="${common_labels}"/> </th>
			</tr>
			<% 
			 	if(rset!=null)
				{
					while(rset.next() && i<=maxrecord)
					{
						if ( i % 2 == 0 )
							classValue = "QRYEVEN" ;
						else
							classValue = "QRYODD" ;
							
				%>
				
				<tr>
					<td class='<%=classValue%>'><%=rset.getString("long_desc")%> </td>
				</tr>
			<%		
					i++;
					}
				}
   if(rset !=null )rset.close();
   if(stmt != null )stmt.close();
   if(pstmt1 != null )pstmt1.close();

}
catch(Exception e) { 
	//out.println(e);
	e.printStackTrace();
	}
}

	}catch(Exception e){
		e.printStackTrace();
		}
finally
{
	try{
        if(rset != null) rset.close();
		if(rset1 != null) rset1.close();
		if(pstmt != null) pstmt.close();
		if(stmt != null) stmt.close();

	}catch(Exception e){}
	if(con != null) ConnectionManager.returnConnection(con,request);
}
%>

</form>
</body>
</html>

