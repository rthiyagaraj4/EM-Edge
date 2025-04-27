<!DOCTYPE html>
<%/*
Sr No        Version           Incident        SCF/CRF                     		Developer Name
----------------------------------------------------------------------------------
 1			 V221017						MMS-DM-CRF-0209 			         Namrata Charate
 2			 V221113           38319       MMS-DM-CRF-0209.3-US005 / 01          Namrata Charate
 3			 V230210						MMS-DM-CRF-0209.5					 Namrata Charate
*/ %>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,java.net.URLEncoder,webbeans.eCommon.ConnectionManager" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script>

<HTML>
<head>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

String facility_id = (String)session.getAttribute("facility_id");
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
</head>
<BODY class='CONTENT'  OnMouseDown='CodeArrest()' onKeyDown="lockKey()">
<%
	try{
		String whereClause = request.getParameter("whereclause");
		String orderbyclause = request.getParameter("orderbyclause");
		if(whereClause==null) whereClause="";
		if(orderbyclause==null) orderbyclause="";
		String from = request.getParameter( "from" ) ;
		String to = request.getParameter( "to" ) ;
		String sql = " ";
		String payerGroup = request.getParameter("payerCode2")==null?"":request.getParameter( "payerCode2" ).trim().toUpperCase();
		String payer =request.getParameter("payerCode")==null?"":request.getParameter( "payerCode" ).trim().toUpperCase();
		String policyType =request.getParameter("policyTypeCode")==null?"":request.getParameter( "policyTypeCode" ).trim().toUpperCase();
		String deductCat = request.getParameter("category")==null?"":request.getParameter("category").trim().toUpperCase();		
		String drug_Cat = request.getParameter("drug_category")==null?"":request.getParameter("drug_category").trim().toUpperCase();
		String diag_Cat = request.getParameter("diag_category")==null?"":request.getParameter("diag_category").trim().toUpperCase();
		String clinic_Cat  = request.getParameter("clinic_category")==null?"":request.getParameter("clinic_category").trim().toUpperCase(); //V230210
		String ord[] = request.getParameterValues("orderbycolumns");
		System.err.println("Deduct Cat: "+deductCat);
		System.err.println("drug_category: "+drug_Cat);
		System.err.println("diag_category: "+diag_Cat);
		System.err.println("clinic_Cat: "+clinic_Cat); //V230210
		String cat_type = "";
		String cat_type_desc = "";
		String payerGroupCode = "";
		String payerCode = "";
		String policyCode = "";
		String cat_code = "";
		String startDate = "";
		String endDate = "";
		String strsql = "";
		String strsql1 = "";
		String sql1 = "";
		String[] sql_orderBy = {"CUST_GROUP_CODE","CUST_CODE","POLICY_TYPE_CODE"};
		if ( (whereClause == null || whereClause.equals("")) )
		{	
			int cnt=0;

			if ( !(payerGroup == null || payerGroup.equals("")) ){
				sql = sql + " and upper(hdr.CUST_GROUP_CODE) like upper('"+payerGroup +"%')";
				cnt++;
			}

			if ( !(payer == null || payer.equals("")) ){
				sql=sql+" and upper(hdr.CUST_CODE) like '"+payer+"%'";
				cnt=1;
			}
        
			if ( !(policyType == null || policyType.equals("")) ){
				sql=sql+" and upper(hdr.POLICY_TYPE_CODE) like '"+policyType+"%'";
				cnt=2;
			}
			if ( !(drug_Cat == null || drug_Cat.equals("")) ){
				sql=sql+" and upper(hdr.ITEM_CATEGORY) like '"+drug_Cat+"%'";
				cnt=3; 
			} 
			if ( !(diag_Cat == null || diag_Cat.equals("")) ){
				sql=sql+" and upper(hdr.ITEM_CATEGORY) like '"+diag_Cat+"%'";
				cnt=3; 
			} /* V230210 starts */
			if ( !(clinic_Cat == null || clinic_Cat.equals("")) ){     
				sql=sql+" and upper(hdr.SERVICE_ITEM_CATEGORY) like '"+clinic_Cat+"%'";
				cnt=4; 
			} 
			/* V230210 ends */
			//appending order by clause
			if ( !(ord == null || ord .equals("")) )
			{
				sql1= " order by cat_type, ";
				for ( int i=0;i < ord.length;i++ )
					{
						if ( i == ord.length - 1 )
							sql1=sql1+ord[i];
						else
							sql1=sql1+ord[i]+",";
					}
			
			} 
		}else{
            sql = whereClause;
			sql1 = orderbyclause;
		}
		
		int start = 0 ;
		int end = 0 ;
		int i=1;

		if ( from == null )
			start = 1 ;
		else
			start = Integer.parseInt( from ) ;

		if ( to == null )
			end = 14 ;
		else
			end = Integer.parseInt( to ) ;
		
		
		Connection conn  =  ConnectionManager.getConnection(request);
		PreparedStatement stmt = null;
		PreparedStatement stmt1 = null;
		int maxRecord = 0;
		ResultSet rset=null;
		ResultSet rs = null;
		
		
		try{
			
			System.err.println("where clause is: "+sql);
			System.err.println("order by clause is: "+sql1);
			
			
			if(deductCat.equals("DRUGCAT")){
				
				strsql = "select count(*) as total "+
					"from bl_insu_drug_deduct_dtl hdr "+
					"where hdr.operating_facility_id = '"+facility_id+"' "+sql ;
			
			}else if(deductCat.equals("DIAGCAT")){
			
				strsql = "select count(*) as total "+
					"from bl_insu_diag_deduct_dtl hdr "+
					"where hdr.operating_facility_id = '"+facility_id+"' "+sql ;
					
			}  /* V230210 starts */
			else if(deductCat.equals("SERVICESANDITEMCAT")){
			
				strsql = "select count(*) as total "+
					"from bl_insu_serv_item_deduct_dtl hdr "+
					"where hdr.operating_facility_id = '"+facility_id+"' "+sql ;
					
			} /* V230210 ends */
			else{
			
				strsql ="select sum(total) as total from "+
					"(select count(*) total from bl_insu_drug_deduct_dtl hdr "+
					"where hdr.operating_facility_id = '"+facility_id+"' "+sql +
					" union "+
					"select count(*) total from bl_insu_diag_deduct_dtl hdr "+
					"where hdr.operating_facility_id = '"+facility_id+"' "+sql +    //V230210
					" union "+
					"select count(*) total from bl_insu_serv_item_deduct_dtl hdr "+
					"where hdr.operating_facility_id = '"+facility_id+"' "+sql +
					" ) " ;
			}
			System.err.println(strsql);
			stmt = conn.prepareStatement(strsql);
			rs = stmt.executeQuery();

			rs.next();
			maxRecord = rs.getInt("total");
			System.err.println("Total is :"+maxRecord);
			if(maxRecord == 0){
				out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));history.go(-1);</script>");
			}
			
			System.err.println("Count is: "+maxRecord);
			if(deductCat.equals("DRUGCAT")){	
			
			strsql1=	"select hdr.CUST_GROUP_CODE, "+
				"decode(hdr.CUST_GROUP_CODE,'**','All Payer Group',(select grp.long_desc from ar_cust_group grp where grp.cust_group_code =  hdr.cust_group_code  )) payer_group, "+
				"hdr.CUST_CODE, "+
				"decode(hdr.CUST_CODE,'**','All Payer',(select cust.long_name from ar_customer cust where  cust.cust_code  = hdr.cust_code )) payer, "+
				"hdr.POLICY_TYPE_CODE, "+
				"decode(hdr.POLICY_TYPE_CODE,'**','All Policy',(select pol.long_desc policy_type from bl_ins_policy_types pol where pol.policy_type_code = hdr.policy_type_code AND pol.operating_facility_id  = hdr.operating_facility_id ))  policy_type,  to_char(hdr.effective_from,'dd/mm/yyyy') effective_from,to_char(hdr.effective_to,'dd/mm/yyyy') effective_to,  "+
				"hdr.ITEM_CATEGORY, '2' cat_type, 'Drug Category' cat_type_desc, DECODE( ITEM_CATEGORY,'AG','Agreement Items','GN','Generic Items','BA','Brand Items(With alternate)','BN','Brand Items(Without alternate)','') CAT_DESC "+  //V221017
				"from bl_insu_drug_deduct_dtl hdr "+
				"where hdr.operating_facility_id = '"+facility_id+"'  "+sql + sql1;
			}
			else if(deductCat.equals("DIAGCAT")){
			
			strsql1=	"select hdr.CUST_GROUP_CODE, "+
				"decode(hdr.CUST_GROUP_CODE,'**','All Payer Group',(select grp.long_desc from ar_cust_group grp where grp.cust_group_code =  hdr.cust_group_code  )) payer_group, "+
				"hdr.CUST_CODE, "+
				"decode(hdr.CUST_CODE,'**','All Payer',(select cust.long_name from ar_customer cust where  cust.cust_code  = hdr.cust_code )) payer, "+
				"hdr.POLICY_TYPE_CODE, "+
				"decode(hdr.POLICY_TYPE_CODE,'**','All Policy',(select pol.long_desc policy_type from bl_ins_policy_types pol where pol.policy_type_code = hdr.policy_type_code AND pol.operating_facility_id  = hdr.operating_facility_id ))  policy_type,  to_char(hdr.effective_from,'dd/mm/yyyy') effective_from,to_char(hdr.effective_to,'dd/mm/yyyy') effective_to,  "+
				"hdr.ITEM_CATEGORY, '1' cat_type, 'Diagnosis Category' cat_type_desc, long_desc cat_desc "+  //V221017
				"from bl_insu_diag_deduct_dtl hdr,MR_DIAG_CATEGORY "+
				"where hdr.operating_facility_id = '"+facility_id+"' and hdr.ITEM_CATEGORY = diag_catg_code "+sql + sql1 ;
			
			} /* V230210 starts */
			else if(deductCat.equals("SERVICESANDITEMCAT")){   
			
			strsql1=	"select hdr.CUST_GROUP_CODE, "+
				"decode(hdr.CUST_GROUP_CODE,'**','All Payer Group',(select grp.long_desc from ar_cust_group grp where grp.cust_group_code =  hdr.cust_group_code  )) payer_group, "+
				"hdr.CUST_CODE, "+
				"decode(hdr.CUST_CODE,'**','All Payer',(select cust.long_name from ar_customer cust where  cust.cust_code  = hdr.cust_code )) payer, "+
				"hdr.POLICY_TYPE_CODE, "+
				"decode(hdr.POLICY_TYPE_CODE,'**','All Policy',(select pol.long_desc policy_type from bl_ins_policy_types pol where pol.policy_type_code = hdr.policy_type_code AND pol.operating_facility_id  = hdr.operating_facility_id ))  policy_type,  to_char(hdr.effective_from,'dd/mm/yyyy') effective_from,to_char(hdr.effective_to,'dd/mm/yyyy') effective_to,  "+
				"hdr.SERVICE_ITEM_CATEGORY ITEM_CATEGORY, '3' cat_type, 'Services and Items- Clinic Category' cat_type_desc, long_desc cat_desc "+  
				"from bl_insu_serv_item_deduct_dtl hdr,op_clinic_proc_category "+
				"where hdr.operating_facility_id = '"+facility_id+"' and hdr.SERVICE_ITEM_CATEGORY = CLINIC_PROC_CATG_CODE "+sql + sql1 ;
			
			} /* V230210 ends */
			else{
			
			strsql1= "select * from "+ 
					" (select hdr.CUST_GROUP_CODE, "+
					"decode(hdr.CUST_GROUP_CODE,'**','All Payer Group',(select grp.long_desc from ar_cust_group grp where grp.cust_group_code =  hdr.cust_group_code )) payer_group, "+ 
					"hdr.CUST_CODE, "+
					"decode(hdr.CUST_CODE,'**','All Payer',(select cust.long_name from ar_customer cust where  cust.cust_code  = hdr.cust_code )) payer, "+
					"hdr.POLICY_TYPE_CODE, "+
					"decode(hdr.POLICY_TYPE_CODE,'**','All Policy',(select pol.long_desc policy_type from bl_ins_policy_types pol where pol.policy_type_code = hdr.policy_type_code AND pol.operating_facility_id  = hdr.operating_facility_id )) policy_type, "+
					"to_char(hdr.effective_from,'dd/mm/yyyy') effective_from,to_char(hdr.effective_to,'dd/mm/yyyy') effective_to,  hdr.ITEM_CATEGORY,'2' cat_type, 'Drug Category' cat_type_desc , DECODE( ITEM_CATEGORY,'AG','Agreement Items','GN','Generic Items','BA','Brand Items(With alternate)','BN','Brand Items(Without alternate)','') cat_desc     from bl_insu_drug_deduct_dtl hdr "+
					"where hdr.operating_facility_id = '"+facility_id+"'  "+sql+ 
					" union all"+ 
					" select hdr.CUST_GROUP_CODE, "+
					"decode(hdr.CUST_GROUP_CODE,'**','All Payer Group',(select grp.long_desc from ar_cust_group grp where grp.cust_group_code =  hdr.cust_group_code  )) payer_group, "+
					"hdr.CUST_CODE, decode(hdr.CUST_CODE,'**','All Payer',(select cust.long_name from ar_customer cust where  cust.cust_code  = hdr.cust_code )) payer, "+
					"hdr.POLICY_TYPE_CODE, decode(hdr.POLICY_TYPE_CODE,'**','All Policy',(select pol.long_desc policy_type from bl_ins_policy_types pol where pol.policy_type_code = hdr.policy_type_code AND pol.operating_facility_id  = hdr.operating_facility_id ))  policy_type,  "+
					"to_char(hdr.effective_from,'dd/mm/yyyy') effective_from,to_char(hdr.effective_to,'dd/mm/yyyy') effective_to,  hdr.ITEM_CATEGORY, '1' cat_type, 'Diagnosis Category' cat_type_desc, long_desc cat_desc from bl_insu_diag_deduct_dtl hdr,MR_DIAG_CATEGORY  "+ 
					"where hdr.operating_facility_id = '"+facility_id+"' and hdr.ITEM_CATEGORY = diag_catg_code  "+sql +
					" union all"+                                                                                      
					" select hdr.CUST_GROUP_CODE, "+
					"decode(hdr.CUST_GROUP_CODE,'**','All Payer Group',(select grp.long_desc from ar_cust_group grp where grp.cust_group_code =  hdr.cust_group_code  )) payer_group, "+
					"hdr.CUST_CODE, decode(hdr.CUST_CODE,'**','All Payer',(select cust.long_name from ar_customer cust where  cust.cust_code  = hdr.cust_code )) payer, "+
					"hdr.POLICY_TYPE_CODE, decode(hdr.POLICY_TYPE_CODE,'**','All Policy',(select pol.long_desc policy_type from bl_ins_policy_types pol where pol.policy_type_code = hdr.policy_type_code AND pol.operating_facility_id  = hdr.operating_facility_id ))  policy_type,  "+
					"to_char(hdr.effective_from,'dd/mm/yyyy') effective_from,to_char(hdr.effective_to,'dd/mm/yyyy') effective_to,  hdr.SERVICE_ITEM_CATEGORY ITEM_CATEGORY, '3' cat_type, 'Services and Items- Clinic Category' cat_type_desc, long_desc cat_desc from bl_insu_serv_item_deduct_dtl hdr,op_clinic_proc_category  "+ 
					"where hdr.operating_facility_id = '"+facility_id+"' and hdr.SERVICE_ITEM_CATEGORY = CLINIC_PROC_CATG_CODE  "+sql+" ) hdr"+sql1;   //V230210
			
			}
			System.err.println("Final data query is: "+strsql1);
			
			stmt1=conn.prepareStatement(strsql1);
			rset = stmt1.executeQuery(); 
			
			}catch(Exception e){
				out.println("Exception here is: "+e);
		}	
	
%>
<form name='QueryResult' id='QueryResult'>

<P>
<table align='right'>
<tr>
<td>
<%
//V221113
System.err.println("Whereclause is"+sql);
if ( !(start <= 1) ){
  
	out.println("<A HREF='../../eBL/jsp/BLMultiFactorDeductRuleQueryResult.jsp?category="+deductCat+"&drug_category="+drug_Cat+"&diag_category="+diag_Cat+"&clinic_category="+clinic_Cat+"&from="+(start-14)+"&to="+(end-14)+"&whereclause=" + URLEncoder.encode(sql) + "&orderbyclause=" + URLEncoder.encode(sql1) + "'" + " text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");  //V230210
}
//V221113
if ( !( (start+14) > maxRecord ) )
	
	out.println("<A HREF='../../eBL/jsp/BLMultiFactorDeductRuleQueryResult.jsp?category="+deductCat+"&drug_category="+drug_Cat+"&diag_category="+diag_Cat+"&clinic_category="+clinic_Cat+"&from="+(start+14)+"&to="+(end+14)+"&whereclause=" + URLEncoder.encode(sql) + "&orderbyclause=" + URLEncoder.encode(sql1) + "'" + " text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");     //V230210

   

%>
</td>
</tr>
</table>
<br><br>
</p>
<fmt:setLocale value="<%=locale %>"/>
<fmt:setBundle basename="eDSN.resources.Labels" var="dl_labels"/>
<table class='grid' border="1" width="100%" cellspacing='0' cellpadding='0' align='center'>
<td class="columnheadercenter" nowrap><fmt:message key="eBL.POLICY_TYPE_CODE.label" bundle="${bl_labels}"/></td>
<td class="columnheadercenter" nowrap><fmt:message key="eBL.PolicyTypeDescription.label" bundle="${bl_labels}"/></td>
<td class="columnheadercenter" nowrap><fmt:message key="eBL.PAYER_GROUP_CODE.label" bundle="${bl_labels}"/></td>
<td class="columnheadercenter" nowrap><fmt:message key="eBL.PAYER_GROUP_DESC.label" bundle="${bl_labels}"/></td> 
<td class="columnheadercenter" nowrap><fmt:message key="eBL.PayerCode.label" bundle="${bl_labels}"/></td> 
<td class="columnheadercenter" nowrap><fmt:message key="eBL.PAYER_DESC.label" bundle="${bl_labels}"/></td>
<td class="columnheadercenter" nowrap><fmt:message key="eBL.DeductibleCategory.label" bundle="${bl_labels}"/></td>
<td class="columnheadercenter" nowrap><fmt:message key="Common.category1.label" bundle="${common_labels}"/></td> 
	
<%
		int mOrder = 0;
		if ( start != 1 )
		for( int j=1; j<start; i++,j++ )
			rset.next() ; 
		String classValue= " ";
		String cat_Desp = "";
		while ( rset.next() && i<=end  )
		{
			if ( i % 2 == 0 )
                classValue = "gridData" ;  
            else
				classValue = "gridData" ;  
		out.println("<tr><td align=='left' class='" + classValue + "' nowrap>");
    
		payerGroup = rset.getString("payer_group");
		payerGroupCode=rset.getString("CUST_GROUP_CODE");
		payer = rset.getString("payer");
		payerCode=rset.getString("CUST_CODE");
		policyType = rset.getString("policy_type");
		policyCode=rset.getString("POLICY_TYPE_CODE");
		cat_code=rset.getString("ITEM_CATEGORY"); 
		cat_type = rset.getString("cat_type");
		cat_type_desc=rset.getString("cat_type_desc");
		cat_Desp = rset.getString("cat_desc");
		startDate = rset.getString("effective_from");
		endDate = rset.getString("effective_to");
		
		String mode="modify";
		
		out.println("<a href='../../eBL/jsp/BLMultiFactorDeductRuleMainFrame.jsp?mode=modify&payergroupCode="+ payerGroupCode+"&payerCode="+payerCode+"&policyCode="+policyCode+"&cat_code="+cat_code+"&cat_type="+cat_type+"&startDate="+startDate+"&endDate="+endDate+"' target='MultiFactorDeductRuleMainFrame' >");
		
		
		out.println(policyCode+"</a></td>");
		out.println("<td class='" + classValue+"' nowrap>"+policyType+"</td>");
		out.println("<td class='" + classValue+"' nowrap>"+payerGroupCode+"</td>");
		out.println("<td class='" + classValue+"' nowrap>"+payerGroup+"</td>");
		out.println("<td class='" + classValue+"' nowrap>"+payerCode+"</td>");
		out.println("<td class='" + classValue+"' nowrap>"+payer+"</td>");
		
		out.println("<td class='" + classValue+"' nowrap>"+cat_type_desc+"</td>");
		out.println("<td class='" + classValue+"' nowrap>"+cat_Desp+"</td>");
		
		
		
				
	i++;
	}
%>
</td></tr>
</table>


				
		
<%		if(stmt!=null)	stmt.close();
		if(stmt1!=null)	stmt1.close();
		if(rs!=null)	rs.close();
		if(rset!=null) rset.close();
		ConnectionManager.returnConnection(conn,request);
	}catch(Exception e){
		out.println("Exception is: "+e);
	}
%>
</form>
</BODY>
</HTML>

