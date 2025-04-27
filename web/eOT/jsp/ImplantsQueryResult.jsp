<!DOCTYPE html>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,java.net.URLEncoder,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eOT/jsp/StringUtil.jsp"%>
<HTML>
<head>
	<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
<script language='javascript' src='../../eCommon/js/CommonLookup.js'></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<BODY class='CONTENT'  OnMouseDown='CodeArrest()' onKeyDown="lockKey()">
<%
	String locale = (String)session.getAttribute("LOCALE"); 
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String ph_module_yn=request.getParameter("ph_module_yn");
	String params=request.getQueryString();
	String whereClause = checkForNull(request.getParameter("whereclause"));
	String from = checkForNull(request.getParameter( "from" )) ;
	String to = checkForNull(request.getParameter( "to" ) );
	int start = ( from.equals("") )?1:Integer.parseInt(from);
	int end =  ( to.equals("") )?14:Integer.parseInt(to);
	String sql = " ";
	try{

    String prosthesis_code = checkForNull(request.getParameter( "prosthesis_code" ));
	String long_desc =checkForNull(request.getParameter( "long_desc" ));
	String short_desc = checkForNull(request.getParameter( "short_desc" ));
	String speciality_code = checkForNull(request.getParameter( "speciality_code" ));
	String prosthesis_cat_code = checkForNull(request.getParameter( "prosthesis_cat_code"));
	String prosthesis_type = checkForNull(request.getParameter( "prosthesis_type"));
	String consignment_item_yn = checkForNull(request.getParameter( "consignment_item_yn"));
	String deposit_reqd_yn = checkForNull(request.getParameter( "deposit_reqd_yn"));
	String mm_item_code = checkForNull(request.getParameter( "mm_item_code"));
    String enabled = checkForNull(request.getParameter( "status"));
    String speciality_desc="";
	String item_desc="";
	//out.println("<script>alert('"+content_type+" "+result_linked_rec_type+" "+enabled+" "+sec_hdg_desc+" "+sec_hdr_meta_desc+" "+"')</script>");
	if ( (whereClause == null || whereClause.equals("")) ){
	int cnt=0;
		if ( !(prosthesis_code == null || prosthesis_code.equals("")) ){
	        sql = sql + " and upper(a.prosthesis_code ) like upper('"+prosthesis_code +"%')";
			cnt++;
        }

        if ( !(long_desc == null || long_desc.equals("")) ){
			if(cnt>0)
				sql = sql + " and upper(a.long_desc) like upper('"+long_desc+"%')";
			else{
				sql=sql+" and upper(a.long_desc) like upper('"+long_desc+"%')";
				cnt=1;
			}

        }
	   if ( !(short_desc == null || short_desc.equals("")) ){
			if(cnt>0)
				sql = sql + " and upper(a.short_desc) like upper('"+short_desc+"%')";
			else{
				sql=sql+" and upper(a.short_desc) like upper('"+short_desc+"%')";
				cnt=1;
			}

        }
	
	if ( !(speciality_code == null || speciality_code.equals("")) ){
			if(cnt>0)
				sql = sql + " and a.speciality_code like '"+speciality_code+"%'";
			else{
				sql=sql+" and a.speciality_code like '"+speciality_code +"%'";
				cnt =1;
			}
        }

	if ( !(prosthesis_cat_code == null || prosthesis_cat_code.equals("")) ){
			if(cnt>0)
				sql = sql + " and a.prosthesis_cat_code= '"+prosthesis_cat_code+"'";
			else{
				sql=sql+" and a.prosthesis_cat_code='"+prosthesis_cat_code +"'";
				cnt =1;
			}
        }

	if ( !(prosthesis_type == null || prosthesis_type.equals("")) ){
			if(cnt>0)
				sql = sql + " and a.prosthesis_type='"+prosthesis_type+"'";
			else{
				sql=sql+" and a.prosthesis_type='"+prosthesis_type +"'";
				cnt =1;
			}
        }
  
  if ( !(consignment_item_yn == null || consignment_item_yn.equals("")) ){
			if(consignment_item_yn.equals("N"))
			if(cnt>0)
			   sql = sql+" and a.consignment_item_yn='N' ";
			else{
				sql=sql+ " and a.consignment_item_yn='N' ";
				cnt=1;

				/* sql = sql+" and nvl(a.consignment_item_yn,'N')='N' ";
			else{
				sql=sql+ " and nvl(a.consignment_item_yn,'N')='N' ";
				cnt=1;*/
			}
         }

	if ( consignment_item_yn.equals("Y") ){

            if(cnt>0)
			   sql = sql+" and a.consignment_item_yn='Y'";
			else
				sql=sql+ "and a.consignment_item_yn='Y'";
         }

         if ( enabled.equals("B") ){
//               sql = sql; //nothing is added to get both E and D
         }

	if ( !(deposit_reqd_yn == null || deposit_reqd_yn.equals("")) ){
			if(deposit_reqd_yn.equals("Y"))
				if(cnt>0)
			   sql = sql+" and a.deposit_reqd_yn='Y' ";
			else{
				sql=sql+ " and a.deposit_reqd_yn='Y' ";
				cnt=1;
			}
         }

	if ( deposit_reqd_yn.equals("N") ){

            if(cnt>0)
			   sql = sql+" and nvl(a.deposit_reqd_yn,'N')='N'";
			else
				sql=sql+ "and nvl(a.deposit_reqd_yn,'N')='N'";
         }

         if ( deposit_reqd_yn.equals("B") ){
//               sql = sql; //nothing is added to get both E and D
         }

	if ( !(mm_item_code == null || mm_item_code.equals("")) ){
			if(cnt>0)
				sql = sql + " and a.mm_item_code like '"+mm_item_code+"%'";
			else{
				sql=sql+" and a.mm_item_code like '"+mm_item_code +"%'";
				cnt =1;
			}
        }

	
	if ( !(enabled == null || enabled.equals("")) ){
         if( enabled.equals("E") ){

			if(cnt>0)
			   sql = sql+" and nvl(a.status,'E')='E' ";
			else{
				sql=sql+ " and nvl(a.status,'E')='E' ";
				cnt=1;
			}
         }

		 if ( enabled.equals("D") ){

            if(cnt>0)
			   sql = sql+" and a.status='D'";
			else
				sql=sql+ "and a.status='D'";
         }

         if ( enabled.equals("B") ){
//               sql = sql; //nothing is added to get both E and D
         }
    }

    //appending order by clause
    String ord[] = request.getParameterValues("orderbycolumns");

    if ( !(ord == null || ord .equals("")) )
    {
        sql=sql+" order by ";
        for ( int i=0;i < ord.length;i++ )
        {
        if ( i == ord.length - 1 )
            sql=sql+ord[i];
        else
            sql=sql+ord[i]+",";
        }
    }

    } //end of where clause IF
    else
            sql = whereClause;


/*
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
*/
int i=1;

Connection conn  =  ConnectionManager.getConnection(request);
PreparedStatement stmt = null;
PreparedStatement stmt1 = null;
int maxRecord = 0;
ResultSet rset=null;
ResultSet rs = null;
try{
		
		/*String strsql="select a.prosthesis_code,a.long_desc,a.short_desc,a.speciality_code,b.short_desc,a.prosthesis_cat_code,c.prosthesis_cat_desc,a.prosthesis_type,d.prosthesis_type_desc, nvl(a.consignment_item_yn,'N') consignment, nvl(a.deposit_reqd_yn,'N') deposit_required, nvl(a.status,'E') status, a.mm_item_code,e.short_desc  from OT_PROSTHESIS a,OT_PROSTHESIS_CATEGORY c, OT_PROSTHESIS_TYPE d, am_speciality b, mm_item e where a.speciality_code=b.speciality_code(+) and a.mm_item_code = e.item_code(+) and a.prosthesis_cat_code=c.prosthesis_cat_code(+) and a.prosthesis_type=d.prosthesis_type(+)"+sql;
		// String strsql="select a.prosthesis_code,a.long_desc,a.short_desc,a.speciality_code,b.short_desc,a.prosthesis_cat_code,c.prosthesis_cat_desc,a.prosthesis_type,d.prosthesis_type_desc, nvl(a.consignment_item_yn,'N') consignment, nvl(a.deposit_reqd_yn,'N') deposit_required, nvl(a.status,'E') status, a.mm_item_code,e.short_desc  from OT_PROSTHESIS_LANG_VW a, OT_PROSTHESIS_CATEGORY c, OT_PROSTHESIS_TYPE_LANG_VW d, am_speciality b, mm_item e where d.LANGUAGE_ID='"+locale+"' AND a.speciality_code=b.speciality_code(+) and a.mm_item_code = e.item_code(+) and a.prosthesis_cat_code=c.prosthesis_cat_code(+) and a.prosthesis_type=d.prosthesis_type(+) AND a.LANGUAGE_ID='"+locale+"' "+sql;*/
		String strsql="";
		//out.println("Ph_module-->"+ph_module_yn);
		//out.println(sql);
		if(ph_module_yn.equals("Y")){
			//This query is modified by bala based on the inputs given by Vishwa on 19/01/2006
			
			/*strsql="select a.prosthesis_code,a.long_desc,a.short_desc,a.speciality_code,b.short_desc,a.prosthesis_cat_code,c.prosthesis_cat_desc,a.prosthesis_type,d.prosthesis_type_desc, nvl(a.consignment_item_yn,'N') consignment, nvl(a.deposit_reqd_yn,'N') deposit_required, nvl(a.status,'E') status, a.mm_item_code,e.short_desc  from OT_PROSTHESIS_LANG_VW a, OT_PROSTHESIS_CATEGORY_LANG_VW c, OT_PROSTHESIS_TYPE_LANG_VW d, am_speciality_lang_vw b, mm_item_lang_vw e where d.LANGUAGE_ID='"+locale+"' AND e.language_id=d.language_id AND b.language_id=d.language_id AND a.speciality_code=b.speciality_code(+) and a.mm_item_code = e.item_code(+) and a.prosthesis_cat_code=c.prosthesis_cat_code(+) and a.prosthesis_type=d.prosthesis_type(+) AND a.LANGUAGE_ID='"+locale+"' AND c.LANGUAGE_ID='"+locale+"' "+sql;*/
			strsql="select a.prosthesis_code,a.long_desc,a.short_desc,a.speciality_code,b.short_desc,		a.prosthesis_cat_code,c.prosthesis_cat_desc,a.prosthesis_type,d.prosthesis_type_desc, nvl(a.consignment_item_yn,'N') consignment, nvl(a.deposit_reqd_yn,'N') deposit_required,			nvl(a.status,'E') status,a.mm_item_code,e.short_desc from OT_PROSTHESIS_LANG_VW a, OT_PROSTHESIS_CATEGORY_LANG_VW c,OT_PROSTHESIS_TYPE_LANG_VW d, am_speciality_lang_vw b, mm_item_lang_vw e where a.LANGUAGE_ID	 ='"+locale+"' AND a.language_id  = b.language_id(+) AND a.speciality_code = b.speciality_code(+) and a.language_id  = c.language_id(+) AND a.prosthesis_cat_code = c.prosthesis_cat_code(+) and a.language_id  = d.language_id(+) AND a.prosthesis_type = d.prosthesis_type(+) AND a.language_id  = e.language_id(+) AND a.mm_item_code = e.item_code(+) "+sql; 
		}else{
			strsql="select a.prosthesis_code,a.long_desc,a.short_desc,a.speciality_code, GET_DESC('"+locale+"','AM_SPECIALITY_LANG_VW','SHORT_DESC','SPECIALITY_CODE',A.SPECIALITY_CODE) short_desc, a.prosthesis_cat_code, GET_DESC('"+locale+"','OT_PROSTHESIS_CATEGORY_LANG_VW','PROSTHESIS_CAT_DESC','PROSTHESIS_CAT_CODE',A.PROSTHESIS_CAT_CODE) prosthesis_cat_desc, a.prosthesis_type, GET_DESC('"+locale+"','OT_PROSTHESIS_TYPE_LANG_VW','PROSTHESIS_TYPE_DESC','PROSTHESIS_TYPE',A.PROSTHESIS_TYPE) prosthesis_type_desc, nvl(a.consignment_item_yn,'N') consignment, nvl(a.deposit_reqd_yn,'N') deposit_required, nvl(a.status,'E') status, a.mm_item_code,null short_desc from OT_PROSTHESIS_LANG_VW a, OT_PROSTHESIS_CATEGORY c,OT_PROSTHESIS_TYPE d, am_speciality b where  a.speciality_code=b.speciality_code(+) and a.prosthesis_cat_code=c.prosthesis_cat_code(+) and a.prosthesis_type=d.prosthesis_type(+) AND a.LANGUAGE_ID='"+locale+"' "+sql;
		}

		//String strsql1="select a.prosthesis_code,a.long_desc,a.short_desc,a.speciality_code,b.short_desc,a.prosthesis_cat_code,c.prosthesis_cat_desc,a.prosthesis_type,d.prosthesis_type_desc, nvl(a.consignment_item_yn,'N') consignment, nvl(a.deposit_reqd_yn,'N') deposit_required, nvl(a.status,'E') status, a.mm_item_code,e.short_desc  from OT_PROSTHESIS a,OT_PROSTHESIS_CATEGORY c, OT_PROSTHESIS_TYPE d, am_speciality b, mm_item e where a.speciality_code=b.speciality_code(+) and a.mm_item_code = e.item_code(+) and a.prosthesis_cat_code=c.prosthesis_cat_code(+) and a.prosthesis_type=d.prosthesis_type(+)"+sql;


        // String strsql1="select a.prosthesis_code,a.long_desc,a.short_desc,a.speciality_code,b.short_desc,a.prosthesis_cat_code,c.prosthesis_cat_desc,a.prosthesis_type,d.prosthesis_type_desc, nvl(a.consignment_item_yn,'N') consignment, nvl(a.deposit_reqd_yn,'N') deposit_required, nvl(a.status,'E') status, a.mm_item_code,e.short_desc  from OT_PROSTHESISLANG_VW a, OT_PROSTHESIS_CATEGORY c, OT_PROSTHESIS_TYPE d, am_speciality b, mm_item e where a.speciality_code=b.speciality_code(+) and a.mm_item_code = e.item_code(+) and a.prosthesis_cat_code=c.prosthesis_cat_code(+) and a.prosthesis_type=d.prosthesis_type(+) AND a.LANGUAGE_ID='"+locale+"' "+sql;

		//String strsql1="select a.prosthesis_code,a.long_desc,a.short_desc,a.speciality_code,b.short_desc,a.prosthesis_cat_code,c.prosthesis_cat_desc,a.prosthesis_type,d.prosthesis_type_desc, nvl(a.consignment_item_yn,'N') consignment, nvl(a.deposit_reqd_yn,'N') deposit_required, nvl(a.status,'E') status, a.mm_item_code,e.short_desc  from OT_PROSTHESISLANG_VW a, OT_PROSTHESIS_CATEGORY_LANG_VW c, OT_PROSTHESIS_TYPE d, am_speciality b, mm_item e where a.speciality_code=b.speciality_code(+) and a.mm_item_code = e.item_code(+) and a.prosthesis_cat_code=c.prosthesis_cat_code(+) and a.prosthesis_type=d.prosthesis_type(+) AND a.LANGUAGE_ID='"+locale+"' AND c.LANGUAGE_ID='"+locale+"' "+sql;
		String strsql1="";
		if(ph_module_yn.equals("Y")){
			strsql1="select a.prosthesis_code,a.long_desc,a.short_desc,a.speciality_code,b.short_desc,		a.prosthesis_cat_code,c.prosthesis_cat_desc,a.prosthesis_type,d.prosthesis_type_desc, nvl(a.consignment_item_yn,'N') consignment, nvl(a.deposit_reqd_yn,'N') deposit_required,			nvl(a.status,'E') status,a.mm_item_code,e.short_desc from OT_PROSTHESIS_LANG_VW a, OT_PROSTHESIS_CATEGORY_LANG_VW c,OT_PROSTHESIS_TYPE_LANG_VW d, am_speciality_lang_vw b, mm_item_lang_vw e where a.LANGUAGE_ID	 ='"+locale+"' AND a.language_id  = b.language_id(+) AND a.speciality_code = b.speciality_code(+) and a.language_id  = c.language_id(+) AND a.prosthesis_cat_code = c.prosthesis_cat_code(+) and a.language_id  = d.language_id(+) AND a.prosthesis_type = d.prosthesis_type(+) AND a.language_id  = e.language_id(+) AND a.mm_item_code = e.item_code(+) "+sql;
		}else{
			//strsql1="select a.prosthesis_code,a.long_desc,a.short_desc,a.speciality_code,b.short_desc,a.prosthesis_cat_code,c.prosthesis_cat_desc,a.prosthesis_type,d.prosthesis_type_desc, nvl(a.consignment_item_yn,'N') consignment, nvl(a.deposit_reqd_yn,'N') deposit_required, nvl(a.status,'E') status, a.mm_item_code,null short_desc  from OT_PROSTHESIS_LANG_VW a, OT_PROSTHESIS_CATEGORY_LANG_VW c, OT_PROSTHESIS_TYPE d, am_speciality_lang_vw b where a.speciality_code=b.speciality_code(+) and a.prosthesis_cat_code=c.prosthesis_cat_code(+) and a.prosthesis_type=d.prosthesis_type(+) AND a.LANGUAGE_ID='"+locale+"' AND B.LANGUAGE_ID='"+locale+"'  AND c.LANGUAGE_ID='"+locale+"' "+sql;
			strsql1="select a.prosthesis_code,a.long_desc,a.short_desc,a.speciality_code, GET_DESC('"+locale+"','AM_SPECIALITY_LANG_VW','SHORT_DESC','SPECIALITY_CODE',A.SPECIALITY_CODE) short_desc, a.prosthesis_cat_code, GET_DESC('"+locale+"','OT_PROSTHESIS_CATEGORY_LANG_VW','PROSTHESIS_CAT_DESC','PROSTHESIS_CAT_CODE',A.PROSTHESIS_CAT_CODE) prosthesis_cat_desc, a.prosthesis_type, GET_DESC('"+locale+"','OT_PROSTHESIS_TYPE_LANG_VW','PROSTHESIS_TYPE_DESC','PROSTHESIS_TYPE',A.PROSTHESIS_TYPE) prosthesis_type_desc, nvl(a.consignment_item_yn,'N') consignment, nvl(a.deposit_reqd_yn,'N') deposit_required, nvl(a.status,'E') status, a.mm_item_code,null short_desc  from OT_PROSTHESIS_LANG_VW a, OT_PROSTHESIS_CATEGORY c, OT_PROSTHESIS_TYPE d, am_speciality b where a.speciality_code=b.speciality_code(+) and a.prosthesis_cat_code=c.prosthesis_cat_code(+) and a.prosthesis_type=d.prosthesis_type(+) AND a.LANGUAGE_ID='"+locale+"' "+sql;
		}

		//out.println(strsql);
		stmt = conn.prepareStatement(strsql);
		rs = stmt.executeQuery();
		int total=0;
		while(rs.next())
		{
			total++;
		}
		maxRecord = total;
		if(maxRecord == 0){
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));history.go(-1);</script>");
		}
		stmt1=conn.prepareStatement(strsql1);
		rset = stmt1.executeQuery();
		
	}catch(Exception e1){
		e1.printStackTrace();
		//out.println("Exception caught "+e1); //e1.printStackTrace(); 
	}
%>
<form name='QueryResult' id='QueryResult'>
<P>
<table align='right'>
<tr>
<td>
<%
if ( !(start <= 1) )
    out.println("<A HREF='../../eOT/jsp/ImplantsQueryResult.jsp?from="+(start-14)+"&ph_module_yn="+ph_module_yn+"&to="+(end-14)+"&whereclause=" + URLEncoder.encode(sql) + "'" + " text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");
if ( !( (start+14) > maxRecord ) )
    out.println("<A HREF='../../eOT/jsp/ImplantsQueryResult.jsp?from="+(start+14)+"&ph_module_yn="+ph_module_yn+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
%>
</td>
</tr>
</table>
<br><br>
</p>

<table class='grid'  border="1" width="100%" cellspacing='0' cellpadding='3' align='center'>
<th class="columnheadercenter" nowrap> <!-- changed by yadav -->
	<fmt:message key="eOT.ProsthesisCode.Label" bundle="${ot_labels}"/>
</th>
<th class="columnheadercenter" nowrap> <!-- changed by yadav -->
	<fmt:message key="Common.longdescription.label" bundle="${common_labels}"/>
</th>
<th class="columnheadercenter" nowrap> <!-- changed by yadav -->
	<fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/>
</th>
<!-- <td class="columnheadercenter" nowrap> <!-- changed by yadav 
	<fmt:message key="Common.speciality.label" bundle="${common_labels}"/>
</td> -->
<th class="columnheadercenter" nowrap> <!-- changed by yadav -->
	<fmt:message key="Common.category1.label" bundle="${common_labels}"/>
</th>
<th class="columnheadercenter" nowrap> <!-- changed by yadav -->
	<fmt:message key="Common.type.label" bundle="${common_labels}"/>
</th>
<!-- <td class="columnheadercenter" nowrap> <!-- changed by yadav 
	<fmt:message key="eOT.ConsignmentItem.Label" bundle="${ot_labels}"/>
</td>
<td class="columnheadercenter" nowrap> <!-- changed by yadav 
	<fmt:message key="eOT.DepositRequired.Label" bundle="${ot_labels}"/>
</td> -->
<%
	if(ph_module_yn.equals("Y")){
%>
		<!-- <td class="columnheadercenter" nowrap <!-- changed by yadav 
			<fmt:message key="eOT.CrossRefMMItem.Label" bundle="${ot_labels}"/>
		</td> -->
<%
	}
%>
<!-- <td class="columnheadercenter"> <!-- changed by yadav 
	<fmt:message key="Common.enabled.label" bundle="${common_labels}"/>
</td>  -->

<%
   if ( start != 1 )
     for( int j=1; j<start; i++,j++ )
      rset.next() ;
String classValue= " ";
      while ( rset.next() && i<=end  )
{
    if ( i % 2 == 0 )
                    classValue = "gridData" ; // changed by yadav
                else
            classValue = "gridData" ; // changed by yadav
    out.println("<tr><td class='" + classValue + "'>");
    prosthesis_code = rset.getString(1);
    long_desc=rset.getString(2);
    short_desc= rset.getString(3);
	speciality_code=rset.getString(4);
	speciality_desc=rset.getString(5);
	prosthesis_cat_code=rset.getString(7);
	prosthesis_type=rset.getString(9);
	consignment_item_yn=rset.getString(10);
	deposit_reqd_yn=rset.getString(11);
    enabled=rset.getString(12);
	mm_item_code=rset.getString(13);
	item_desc=rset.getString(14);
	
	String mode="modify";
	out.println("<a href='../../eOT/jsp/ImplantsAddModify.jsp?mode="+mode+"&ph_module_yn="+ph_module_yn+"&prosthesis_code="+ prosthesis_code+"'&mm_item_code='"+mm_item_code+" target='f_query_add_mod' >");
    out.println(prosthesis_code+"</a></td>");
  if(speciality_desc==null)
  speciality_desc="&nbsp;";
    if(prosthesis_cat_code==null)
  prosthesis_cat_code="&nbsp;";
	  if(prosthesis_type==null)
  prosthesis_type="&nbsp;";
	 if(item_desc==null)
  item_desc="&nbsp;";

   out.println("<td class='" + classValue+"' nowrap>"+long_desc+"</td>");
   out.println("<td class='" + classValue+"'nowrap>"+short_desc+"</td>");
//   out.println("<td class='" + classValue+"'nowrap>"+speciality_desc+"</td>");
   out.println("<td class='" + classValue+"'nowrap>"+prosthesis_cat_code+"</td>");
   out.println("<td class='" + classValue+"'nowrap>"+prosthesis_type+"</td>");
/*    out.println("<td class='" + classValue + "' align='center' nowrap>");
   if ( rset.getString("consignment").equals("N") || rset.getString("consignment").equals("") )
        out.println("<img src='../../eCommon/images/RRnwd.gif'></img>"); 
   else
	   out.println("<img src='../../eCommon/images/enabled.gif'></img>");
	   out.println("</td>");
   
	out.println("<td class='" + classValue + "' align='center' nowrap>");
   if ( rset.getString("deposit_required").equals("N") || rset.getString("deposit_required").equals(""))
	   out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
       
   else
	
      out.println("<img src='../../eCommon/images/enabled.gif'></img>");
      out.println("</td>");
	if(ph_module_yn.equals("Y")){
      out.println("<td class='" + classValue+"' nowrap>"+item_desc+"</td>");
	}
      out.println("<td class='" + classValue + "' align='center' nowrap>");
      if ( rset.getString("status").equals("E") )
        out.println("<img src='../../eCommon/images/enabled.gif'></img>");
      else
     	out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
	    out.println("</td>");*/
	i++;
} %>

</td></tr>
</table>
</center>

<br><center>
<%
if(stmt!=null)	stmt.close();
		if(stmt1!=null)	stmt1.close();
		if(rs!=null)	rs.close();
		if(rset!=null) rset.close();
ConnectionManager.returnConnection(conn,request);
}
	
catch(Exception e)
{
	e.printStackTrace();//out.println("here "+e);
}
%>
</center>
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
</form>
</BODY>
</HTML>

