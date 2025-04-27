<!DOCTYPE html>
<!-- /*  Developed By Prabhu.M
		 Date -- 06/07/2004
		 Functionality -- OP/Catalog for Clinic
*/ -->

<%@ page import ="java.sql.*, java.util.*,java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
	<head>
<%
request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
	<script src='../../eOP/js/CatalogForClinic.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
	
<% 
	String visit_type_id="";
	String order_cat_id="";
	String checkedOnes="";
	String ord_cat="";
	String first_time=request.getParameter("first_time")==null ? "": request.getParameter("first_time");
	String param=request.getParameter("alphabet")==null ? "" : request.getParameter("alphabet");
	String from= request.getParameter("from")==null ? "" : request.getParameter("from");
	String to= request.getParameter("to")==null ? "" : request.getParameter("to");
	String frmSrch = request.getParameter("frmSrch")==null ? "" : request.getParameter("frmSrch");
	String from_hd="";
	String to_hd="";
	

	
	int start = 0 ;
	int end = 0 ;
	int j=1;
	int count1=0;

	if ( from == null || from.equals("") )
		start = 1 ;
	else
		start = Integer.parseInt( from ) ;

	if ( to == null || from.equals(""))
	  	end = 14 ;
	else
		end = Integer.parseInt( to ) ;	

	if(first_time==null)first_time="";

	HashMap statNationalRecSet= null;
	HashMap al= null;
	HashMap ArrLis= null;
	ArrayList hr=null;
	
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
	String facilityid=(String)session.getValue("facility_id");
		
	Connection con = null;
	ResultSet rset=null ;
	Statement stmt=null;
	ResultSet rset1=null ;
	PreparedStatement pstmt = null;
	try
	{
	con = ConnectionManager.getConnection(request);
	if( dtl_flag.equals("insert"))
	{
	try{
	stmt = con.createStatement();
	
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
			
			if(!old_param.equals("")){
			boolean sb1 = ext.startsWith(old_param);
			if(sb1)
				{
					statNationalRecSet.remove(ext);
				}
	  		  }
			}
		}
	}catch(Exception e1){
		e1.printStackTrace();
		}

	visit_type_id=request.getParameter("visit_type_id");
	order_cat_id=request.getParameter("order_cat_id");
	String frmqry=request.getParameter("frmqry");

	
	if( visit_type_id == null) visit_type_id="";
	if( frmqry == null) frmqry="";
	if(!(frmqry.equals("")))
	{
	
	rset = stmt.executeQuery("select ORDER_CATEGORY from OR_ORDER_CATALOG where ORDER_CATALOG_CODE ='"+frmqry+"'");
	if(rset != null)
	while(rset.next()){
		orcat = rset.getString("ORDER_CATEGORY");
		out.println("asigne order_cat_id" + orcat );
	}

	order_cat_id = orcat;

	if(rset != null )rset.close();
	
	}

	if( order_cat_id == null) order_cat_id="";
	
	// Added the order by in the query for IN023645 on 06.09.2010 by Suresh M
	if(frmSrch.equals("S")) {			
		String sql_one="";
		//if(order_cat_id.equals("OH")){ // changed for CRF 485. Opening for order set
			sql_one="select distinct upper(substr(long_desc,1,1))selalpha  from or_order_catalog where ORDER_CATALOG_NATURE in ('A','P','S') and long_desc between 'A' AND 'ZZ' and ORDER_CATEGORY ='"+order_cat_id+"'  and eff_status = 'E' order by selalpha";
		//}else{
			//sql_one="select distinct upper(substr(long_desc,1,1))selalpha  from or_order_catalog where ORDER_CATALOG_NATURE in ('A','P') and long_desc between 'A' AND 'ZZ' and ORDER_CATEGORY ='"+order_cat_id+"' order by selalpha ";
		//}		
		pstmt = con.prepareStatement(sql_one);
		rset1= pstmt.executeQuery();
		if(rset1.next())
		{
			param = rset1.getString("selalpha");			
		}
        if(rset1 != null )rset1.close();
		if(pstmt != null ) pstmt.close();


		
		

		if(param.equals("")){
			String sql_others="";		 
			sql_others="select distinct upper(substr(long_desc,1,1))Others  from or_order_catalog where ORDER_CATALOG_NATURE in ('A','P','S') and long_desc is not null and ORDER_CATEGORY ='"+order_cat_id+"'  and eff_status = 'E' order by Others";		
			pstmt = con.prepareStatement(sql_others);
			rset1= pstmt.executeQuery();
			if(rset1.next()){
				param = rset1.getString("Others");			
			}
			
			if(param== null)param = "";
			if(rset1 != null )rset1.close();
			if(pstmt != null ) pstmt.close();
		}

		
		
		
	}

	

	String sql="";
	if( ! param.equals(""))
	{
		
		if( param.equals("Others")){
			
			//if(order_cat_id.equals("OH")){ // changed for CRF 485. Opening for order set
				sql=" SELECT a.order_catalog_code, b.long_desc  FROM  op_catalog_for_clinic a, or_order_catalog b WHERE b.ORDER_CATALOG_NATURE in ('A','P','S') and a.facility_id = '"+facilityid+"'   AND a.CLINIC_CODE = '"+visit_type_id+"'   AND b.order_category = '"+order_cat_id+"'   AND a.order_catalog_code = b.order_catalog_code    and upper(substr(b.long_desc,1,1)) not between 'A' and 'ZZ' UNION SELECT order_catalog_code, long_desc   FROM or_order_catalog  WHERE ORDER_CATALOG_NATURE in ('A','P','S') AND order_category = '"+order_cat_id+"'   AND eff_status = 'E'  and upper(substr(long_desc,1,1)) not between 'A' and 'ZZ' AND order_catalog_code NOT IN (SELECT e.order_catalog_code  FROM op_catalog_for_clinic e, or_order_catalog f WHERE e.facility_id ='"+facilityid+"' AND e.CLINIC_CODE = '"+visit_type_id+"' AND e.order_catalog_code = f.order_catalog_code AND f.order_category = '"+order_cat_id+"'   and upper(substr(f.long_desc,1,1)) not between 'A' and 'ZZ') order by long_desc  ";	
			//}else{
				//sql=" SELECT a.order_catalog_code, b.long_desc  FROM  op_catalog_for_clinic a, or_order_catalog b WHERE b.ORDER_CATALOG_NATURE in ('A','P') and a.facility_id = '"+facilityid+"'   AND a.CLINIC_CODE = '"+visit_type_id+"'   AND b.order_category = '"+order_cat_id+"'   AND a.order_catalog_code = b.order_catalog_code    and upper(substr(b.long_desc,1,1)) not between 'A' and 'ZZ' UNION SELECT order_catalog_code, long_desc   FROM or_order_catalog  WHERE ORDER_CATALOG_NATURE in ('A','P') AND order_category = '"+order_cat_id+"'   AND eff_status = 'E'  and upper(substr(long_desc,1,1)) not between 'A' and 'ZZ' AND order_catalog_code NOT IN (SELECT e.order_catalog_code  FROM op_catalog_for_clinic e, or_order_catalog f WHERE e.facility_id ='"+facilityid+"' AND e.CLINIC_CODE = '"+visit_type_id+"' AND e.order_catalog_code = f.order_catalog_code AND f.order_category = '"+order_cat_id+"'   and upper(substr(f.long_desc,1,1)) not between 'A' and 'ZZ') order by long_desc  ";	
			//}
		
		}else{
			//if(order_cat_id.equals("OH")){ // changed for CRF 485. Opening for order set
				sql = "SELECT a.order_catalog_code, b.long_desc   FROM op_catalog_for_clinic a, or_order_catalog b  WHERE b.ORDER_CATALOG_NATURE in ('A','P','S') and a.facility_id = '"+facilityid+"'  AND a.CLINIC_CODE = '"+visit_type_id+"'   AND b.order_category = '"+order_cat_id+"'  AND a.order_catalog_code = b.order_catalog_code   AND UPPER (b.long_desc) LIKE '"+param+"%' UNION SELECT order_catalog_code, long_desc FROM or_order_catalog WHERE ORDER_CATALOG_NATURE in ('A','P','S') AND order_category = '"+order_cat_id+"' AND eff_status = 'E' and UPPER(LONG_DESC) LIKE '"+param+"%' AND order_catalog_code NOT IN (SELECT e.order_catalog_code FROM op_catalog_for_clinic e, or_order_catalog f WHERE e.facility_id = '"+facilityid+"'  AND e.CLINIC_CODE =  '"+visit_type_id+"' AND e.order_catalog_code = f.order_catalog_code AND f.order_category = '"+order_cat_id+"' AND UPPER (f.long_desc) LIKE '"+param+"%') order by long_desc";
			//}else{

				//sql = "SELECT a.order_catalog_code, b.long_desc   FROM op_catalog_for_clinic a, or_order_catalog b  WHERE b.ORDER_CATALOG_NATURE in ('A','P') and a.facility_id = '"+facilityid+"'  AND a.CLINIC_CODE = '"+visit_type_id+"'   AND b.order_category = '"+order_cat_id+"'  AND a.order_catalog_code = b.order_catalog_code   AND UPPER (b.long_desc) LIKE '"+param+"%' UNION SELECT order_catalog_code, long_desc FROM or_order_catalog WHERE ORDER_CATALOG_NATURE in ('A','P') AND order_category = '"+order_cat_id+"' AND eff_status = 'E' and UPPER(LONG_DESC) LIKE '"+param+"%' AND order_catalog_code NOT IN (SELECT e.order_catalog_code FROM op_catalog_for_clinic e, or_order_catalog f WHERE e.facility_id = '"+facilityid+"'  AND e.CLINIC_CODE =  '"+visit_type_id+"' AND e.order_catalog_code = f.order_catalog_code AND f.order_category = '"+order_cat_id+"' AND UPPER (f.long_desc) LIKE '"+param+"%') order by long_desc";
			//}
		}

	}
	else 
	{
		//if(order_cat_id.equals("OH")){ // changed for CRF 485. Opening for order set
			sql = "SELECT   a.order_catalog_code, b.long_desc  FROM op_catalog_for_clinic a, or_order_catalog b WHERE b.ORDER_CATALOG_NATURE in ('A','P','S') and a.facility_id = '"+facilityid+"'  AND a.CLINIC_CODE = '"+visit_type_id+"' AND b.order_category = '"+order_cat_id+"' AND a.order_catalog_code = b.order_catalog_code  AND a.CLINIC_CODE = '"+visit_type_id+"'";
		//}else{
			//sql = "SELECT   a.order_catalog_code, b.long_desc  FROM op_catalog_for_clinic a, or_order_catalog b WHERE b.ORDER_CATALOG_NATURE in ('A','P') and a.facility_id = '"+facilityid+"'  AND a.CLINIC_CODE = '"+visit_type_id+"' AND b.order_category = '"+order_cat_id+"' AND a.order_catalog_code = b.order_catalog_code  AND a.CLINIC_CODE = '"+visit_type_id+"'";
		//}
	}
	
	
	
	
	rset=stmt.executeQuery(sql);
	
	String count="";
	
	
	if( ! param.equals(""))
	{
	
		if( param.equals("Others")){
			//if(order_cat_id.equals("OH")){ // changed for CRF 485. Opening for order set
				count="select count(*) as total from op_catalog_for_clinic a, or_order_catalog b WHERE b.ORDER_CATALOG_NATURE in ('A','P','S') and a.facility_id = '"+facilityid+"'   AND a.CLINIC_CODE = '"+visit_type_id+"'   AND b.order_category = '"+order_cat_id+"'   AND a.order_catalog_code = b.order_catalog_code    and upper(substr(b.long_desc,1,1)) not between 'A' and 'ZZ' UNION SELECT  count(*)  from  or_order_catalog  WHERE ORDER_CATALOG_NATURE in ('A','P','S') AND order_category = '"+order_cat_id+"' AND eff_status = 'E'  and upper(substr(long_desc,1,1)) not between 'A' and 'ZZ' AND order_catalog_code NOT IN (SELECT e.order_catalog_code FROM op_catalog_for_clinic e, or_order_catalog f WHERE e.facility_id ='"+facilityid+"' AND e.CLINIC_CODE = '"+visit_type_id+"' AND e.order_catalog_code = f.order_catalog_code AND f.order_category = '"+order_cat_id+"'   and upper(substr(f.long_desc,1,1)) not between 'A' and 'ZZ')";
			//}else{
				//count="select count(*) as total from op_catalog_for_clinic a, or_order_catalog b WHERE b.ORDER_CATALOG_NATURE in ('A','P') and a.facility_id = '"+facilityid+"'   AND a.CLINIC_CODE = '"+visit_type_id+"'   AND b.order_category = '"+order_cat_id+"'   AND a.order_catalog_code = b.order_catalog_code    and upper(substr(b.long_desc,1,1)) not between 'A' and 'ZZ' UNION SELECT  count(*)  from  or_order_catalog  WHERE ORDER_CATALOG_NATURE in ('A','P') AND order_category = '"+order_cat_id+"' AND eff_status = 'E'  and upper(substr(long_desc,1,1)) not between 'A' and 'ZZ' AND order_catalog_code NOT IN (SELECT e.order_catalog_code FROM op_catalog_for_clinic e, or_order_catalog f WHERE e.facility_id ='"+facilityid+"' AND e.CLINIC_CODE = '"+visit_type_id+"' AND e.order_catalog_code = f.order_catalog_code AND f.order_category = '"+order_cat_id+"'   and upper(substr(f.long_desc,1,1)) not between 'A' and 'ZZ')";
			//}
		}else{
		//	if(order_cat_id.equals("OH")){ // changed for CRF 485. Opening for order set
				count = "select count(*) as total from op_catalog_for_clinic a, or_order_catalog b  WHERE  b.ORDER_CATALOG_NATURE in ('A','P','S') and a.facility_id = '"+facilityid+"'  and a.CLINIC_CODE = '"+visit_type_id+"'   AND b.order_category = '"+order_cat_id+"'  AND a.order_catalog_code = b.order_catalog_code   AND UPPER (b.long_desc) LIKE '"+param+"%' UNION SELECT count(*) FROM or_order_catalog  WHERE ORDER_CATALOG_NATURE in ('A','P','S') AND order_category = '"+order_cat_id+"'  AND eff_status = 'E' AND UPPER(LONG_DESC) LIKE '"+param+"%' and order_catalog_code NOT IN (SELECT e.order_catalog_code FROM op_catalog_for_clinic e, or_order_catalog f WHERE e.facility_id = '"+facilityid+"'      AND e.CLINIC_CODE = '"+visit_type_id+"' AND e.order_catalog_code = f.order_catalog_code    AND f.order_category = '"+order_cat_id+"' AND UPPER (f.long_desc) LIKE '"+param+"%')";
			//}else{
				//count = "select count(*) as total from op_catalog_for_clinic a, or_order_catalog b  WHERE  b.ORDER_CATALOG_NATURE in ('A','P') and a.facility_id = '"+facilityid+"'  and a.CLINIC_CODE = '"+visit_type_id+"'   AND b.order_category = '"+order_cat_id+"'  AND a.order_catalog_code = b.order_catalog_code   AND UPPER (b.long_desc) LIKE '"+param+"%' UNION SELECT count(*) FROM or_order_catalog  WHERE ORDER_CATALOG_NATURE in ('A','P') AND order_category = '"+order_cat_id+"'  AND eff_status = 'E' AND UPPER(LONG_DESC) LIKE '"+param+"%' and order_catalog_code NOT IN (SELECT e.order_catalog_code FROM op_catalog_for_clinic e, or_order_catalog f WHERE e.facility_id = '"+facilityid+"'      AND e.CLINIC_CODE = '"+visit_type_id+"' AND e.order_catalog_code = f.order_catalog_code    AND f.order_category = '"+order_cat_id+"' AND UPPER (f.long_desc) LIKE '"+param+"%')";
			//}
		}

	}
	else
	{
		//if(order_cat_id.equals("OH")){ // changed for CRF 485. Opening for order set
			count="SELECT count(*) as total from  op_catalog_for_clinic a, or_order_catalog b WHERE b.ORDER_CATALOG_NATURE in ('A','P''S') and a.facility_id = '"+facilityid+"'  AND a.CLINIC_CODE = '"+visit_type_id+"' AND b.order_category = '"+order_cat_id+"' AND a.order_catalog_code = b.order_catalog_code  AND a.CLINIC_CODE = '"+visit_type_id+"' ";
		//}else{
			//count="SELECT count(*) as total from  op_catalog_for_clinic a, or_order_catalog b WHERE b.ORDER_CATALOG_NATURE in ('A','P') and a.facility_id = '"+facilityid+"'  AND a.CLINIC_CODE = '"+visit_type_id+"' AND b.order_category = '"+order_cat_id+"' AND a.order_catalog_code = b.order_catalog_code  AND a.CLINIC_CODE = '"+visit_type_id+"' ";
		//}
	}
	
	pstmt=con.prepareStatement(count);
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
	if(!first_time.equals("1")) {
	out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','COMMON'));</script>");
	return;
	}
	}
// if(param.equals("")){
if(!param.equals("") && maxrecord > 0){
	
	try{
	
	//String sqlVal="select b.long_desc from op_catalog_for_clinic a, OR_ORDER_CATALOG b where b.ORDER_CATALOG_CODE = a.ORDER_CATALOG_CODE and a.CLINIC_CODE='"+visit_type_id+"' and facility_id='"+facilityid+"' ";
	String sqlVal="";
	//if(order_cat_id.equals("OH")){ // changed for CRF 485. Opening for order set
		sqlVal="select b.ORDER_CATALOG_CODE , b.long_desc from op_catalog_for_clinic a, OR_ORDER_CATALOG b where b.ORDER_CATALOG_NATURE in ('A','P','S') and b.ORDER_CATALOG_CODE = a.ORDER_CATALOG_CODE and a.CLINIC_CODE='"+visit_type_id+"' and facility_id='"+facilityid+"' ";
	//}else{
		//sqlVal="select b.ORDER_CATALOG_CODE , b.long_desc from op_catalog_for_clinic a, OR_ORDER_CATALOG b where b.ORDER_CATALOG_NATURE in ('A','P') and b.ORDER_CATALOG_CODE = a.ORDER_CATALOG_CODE and a.CLINIC_CODE='"+visit_type_id+"' and facility_id='"+facilityid+"' ";
	//}
	
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
	// Added the order by in the query for IN023645 on 06.09.2010 by Suresh M
	if( maxrecord > 0 )
	{
		
		String sql_two="";
		//if(order_cat_id.equals("OH")){ // changed for CRF 485. Opening for order set
			sql_two="select distinct upper(substr(long_desc,1,1))selalpha  from or_order_catalog where ORDER_CATALOG_NATURE in ('A','P','S') and long_desc between 'A' AND 'ZZ' and ORDER_CATEGORY ='"+order_cat_id+"' and eff_status = 'E' order by selalpha";
		//}else{
			//sql_two="select distinct upper(substr(long_desc,1,1))selalpha  from or_order_catalog where ORDER_CATALOG_NATURE in ('A','P') and long_desc between 'A' AND 'ZZ' and ORDER_CATEGORY ='"+order_cat_id+"' order by selalpha";
		//}
		
		pstmt = con.prepareStatement(sql_two);
		String selalpha = "";
		hr = new ArrayList();
		rset1= pstmt.executeQuery();
		while (rset1.next())
		{
			selalpha = rset1.getString("selalpha");
			hr.add(selalpha);
			
		}
	
        if(rset1 != null )rset1.close();
		if(pstmt != null ) pstmt.close();

%>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
	<form name='stat_grp_nation_detail_result_form' id='stat_grp_nation_detail_result_form' action="../../eOP/jsp/CatalogForClinicResult.jsp" method='post' >
	    <table cellspacing=0 cellpadding=0 width='100%' border=1>

	<TR id='alpha'>
		<%
		Iterator e7 = hr.iterator();
	         
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
		
		/*try{
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
			
			}*/
			%>
	
		<br>
			<TABLE cellspacing=0 cellpadding=0 border=0 align='right'>
				<TR>					
					<%if ( !(start <= 1)  ) {%>
					<TD class='class' id='prevval'>
					<A  href='#' onclick="nextprev('prev')" ><fmt:message key="Common.previous.label" bundle="${common_labels}"/></A>&nbsp;&nbsp;
					</TD>
						<%}%>
						<td id='nextval' class='class'>
						<A  href='#' onclick="nextprev('next')" ><fmt:message key="Common.next.label" bundle="${common_labels}"/></A>
					</TD>
				</TR>
			</TABLE>
	<br><br>

		  <table cellspacing=0 cellpadding=0 width='100%' border=1>
	   		<tr>
				<td class='COLUMNHEADER' align='left' width='70%'><fmt:message key="Common.ordercatalog.label" bundle="${common_labels}"/></td>
				<td class='COLUMNHEADER' align='center' width='30%'><fmt:message key="Common.Include.label" bundle="${common_labels}"/></td>
			</tr>
			<% 
			
			String chkAttribute="";
			if ( start != 1 )
			{
				 for( int k=1; k<start; j++,k++ )
				 {
					 rset.next() ;
				 }
			}

		    count1=0;
		    if(rset!=null)
				{
					while(rset.next() && j<=end)
					{
						//ord_cat=rset.getString("long_desc");						
						ord_cat=rset.getString("order_catalog_code");
						
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
					j++;
					count1++;
					}
					maxrecord=count1;
					//maxrecord=j;
				}

		if(rset != null )rset.close();
		if(stmt != null )stmt.close();
			
			%>
		 <input type ='hidden' name ='visit_type_id' value ='<%=visit_type_id%>'> 
		 <input type ='hidden' name ='order_cat_id' value ='<%=order_cat_id%>'> 
		 <input type ='hidden' name ='old_param' value ='<%=param%>'> 
		 <input type ='hidden' name ='alphabet' value =' '>
		<input type ='hidden' name ='dtl_flag' value =' '>
		<input type ='hidden' name ='totprvrec' value ='<%=maxrecord%>'>
		<input type ='hidden' name ='maxrecord' value ='<%=maxrecord%>'>
		<input type='hidden' name='remmem' id='remmem' value='R' >
		<input type='hidden' name='recval' id='recval' value='1'>
		<input type ='hidden' name ='from' value ='<%=from_hd%>'>
		<input type ='hidden' name ='to' value ='<%=to_hd%>'>
		</table>

		</form>
		<form name='stat_grp_nation_detail_result_form1' id='stat_grp_nation_detail_result_form1'  method='post' target='parent.parent.frames[2]'>
		<input type='hidden' name='maxrecord' id='maxrecord' value=<%=maxrecord%> >
		<input type='hidden' name='insert_to_db' id='insert_to_db' value='' >
		<input type='hidden' name='function_name' id='function_name' value='insert' >
		<input type ='hidden' name ='from' value ='<%=from_hd%>'>
		<input type ='hidden' name ='to' value ='<%=to_hd%>'>
		</form>
	</body>
</html>
<%
}
else
{ 
	String from1= request.getParameter("from")==null? "" : request.getParameter("from");
	String to1= request.getParameter("to") == null ? "" : request.getParameter("to");
%>	
	
   <form name='stat_grp_nation_detail_result_form2' id='stat_grp_nation_detail_result_form2'> 
   <input type ='hidden' name ='visit_type_id' value ='<%=visit_type_id%>'>
	<input type ='hidden' name ='order_cat_id' value ='<%=order_cat_id%>'>
		    <input type ='hidden' name ='alphabet' value =' '>
	    <input type ='hidden' name ='dtl_flag' value =' '>
	<input type='hidden' name='recval' id='recval' value='0'>

    <input type ='hidden' name ='old_param' value ='<%=param%>'>
	<input type ='hidden' name ='from' value ='<%=from1%>'>
    <input type ='hidden' name ='to' value ='<%=to1%>'>
		
<%	
	if(first_time.equals("1"))
	{
	%>
	<script>callMember("A");</script>
	<% 
		first_time="2";
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
	out.println("here: ");
	out.println(e); 
	e.printStackTrace();
	} 
finally{
	session.setAttribute("StatNationalId", statNationalRecSet);
	session.setAttribute("arrlis", ArrLis);
	session.setAttribute("al", al);
	}
} else{

	try{
	stmt=con.createStatement();
	int maxrecord=0;
	String classValue="";	
	visit_type_id=request.getParameter("visit_type_id");
	order_cat_id=request.getParameter("order_cat_id");
	if( visit_type_id == null) visit_type_id="";
	if( order_cat_id == null) order_cat_id="";
	
	String sql="select b.long_desc from op_catalog_for_clinic a, OR_ORDER_CATALOG b where b.ORDER_CATALOG_CODE = a.ORDER_CATALOG_CODE and a.CLINIC_CODE='"+visit_type_id+"' ";
		
	rset=stmt.executeQuery(sql);
	
	String count="select count(*) as total  from op_catalog_for_clinic a, OR_ORDER_CATALOG b where b.ORDER_CATALOG_CODE = a.ORDER_CATALOG_CODE and a.CLINIC_CODE='"+visit_type_id+"' ";
		
	pstmt=con.prepareStatement(count);
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

	<body onKeyDown = 'lockKey();'>
	<form name='stat_grp_nation_detail_result_form' id='stat_grp_nation_detail_result_form'>
		<table cellspacing=0 cellpadding=0 width='100%' border=1>
			<tr>
				<td class='columnheader' ><fmt:message key="Common.service.label" bundle="${common_labels}"/> </td>
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

}
catch(Exception e) { 
	out.println(e);
	e.printStackTrace();
	}
}
	//statNationalRecSet.clear();
	//al.clear();
	//ArrLis.clear();
	//hr.clear();
}catch(Exception e){
	e.printStackTrace();
	}
finally
{
	statNationalRecSet.clear();
	try{
        if(rset != null) rset.close();
		if(rset1 != null) rset1.close();
		if(pstmt != null) pstmt.close();
		if(stmt != null) stmt.close();
	}catch(Exception e){
		e.printStackTrace();
	}
	if(con != null) ConnectionManager.returnConnection(con,request);
}
%>
</form>

<SCRIPT>
	function nextprev(choice)
	{
		var start1;
		var end1;
		var alphabet1='<%=param%>'
		var stat1 = '<%=visit_type_id%>';
		var stat2 = '<%=order_cat_id%>';
		if(choice=='next')
		{
		start1='<%=start+14%>';
		end1='<%=end+14%>';
		}
		else
		{
		start1='<%=start-14%>';
		end1='<%=end-14%>';
		}
		// Code added for 22370
	if(confirm(getMessage('WANT_TO_SAVE','common')))
	{
	apply('Y');
	document.location.href='../../eOP/jsp/CatalogForClinicResult.jsp?dtl_flag=insert&visit_type_id='+stat1+'&order_cat_id='+stat2+'&first_time=1&from='+start1+'&to='+end1+'&alphabet='+alphabet1;
	}
	else
	{
		document.location.href='../../eOP/jsp/CatalogForClinicResult.jsp?dtl_flag=insert&visit_type_id='+stat1+'&order_cat_id='+stat2+'&first_time=1&from='+start1+'&to='+end1+'&alphabet='+alphabet1;
	}
	}
	<%if(count1<14){%>
		if(document.getElementById("nextval"))
		document.getElementById("nextval").style.visibility='hidden'
		<%}%>
	</SCRIPT>

</body>
</html>

