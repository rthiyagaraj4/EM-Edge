<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,webbeans.eCommon.*,java.net.*,java.text.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
 <script language='javascript' src='../../eCommon/js/common.js'></script>
<HTML><head>
<% String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>

</link></head><BODY  OnMouseDown='CodeArrest()'  onKeyDown = 'lockKey()'  class='CONTENT' >

<%
    request.setCharacterEncoding("UTF-8");
    String whereClause = request.getParameter("whereclause");
    StringBuffer sql=new StringBuffer();
    String from = request.getParameter( "from" ) ;

    String to = request.getParameter( "to" ) ;

	String scode = request.getParameter("inj_category_code")==null ? "" : request.getParameter("inj_category_code");
	String sdesc = request.getParameter("inj_category_long_desc")==null ? "" : request.getParameter("inj_category_long_desc");
	String sscode = request.getParameter("inj_subcategory_code")==null ? "" : request.getParameter("inj_subcategory_code");
	String ssdesc = request.getParameter("inj_subcategory_long_desc")==null ? "" : request.getParameter("inj_subcategory_long_desc");
	String sssdesc = request.getParameter("inj_subcategory_short_desc")==null ? "" : request.getParameter("inj_subcategory_short_desc");
	String estatus = request.getParameter("eff_status")==null ? "" : request.getParameter("eff_status");
	
	int andCheck = 0;

	scode=scode.toUpperCase();
		if ( !(scode == null || scode.equals("")) )
			{
				sql.append(" and upper(IC.inj_category_code) like upper('"+scode+"%')");
				andCheck = 1;
			}

		if ( !(sdesc == null || sdesc.equals("")) )
			{
				if ( andCheck == 1 )
					{	
						sql.append(" and upper(IC.short_desc) like  upper('"+sdesc+"%')");
					}
				else
					{
						sql.append(" and upper(IC.short_desc) like upper('"+sdesc+"%')");
						andCheck = 1;
					}
			}

	sscode=sscode.toUpperCase();
		if ( !(sscode == null || sscode.equals("")) )
			{
				if ( andCheck == 1 )
					{	
						sql.append(" and upper(inj_subcategory_code) like  upper('"+sscode+"%')");
					}
				else
					{
						sql.append(" and upper(inj_subcategory_code) like upper('"+sscode+"%')");
						andCheck = 1;
					}

			}
	ssdesc=ssdesc.toUpperCase();
		if ( !(ssdesc == null || ssdesc.equals("")) )
			{
				if ( andCheck == 1 )
					{	
						sql.append(" and upper(ISC.long_desc)  like  upper('"+ssdesc+"%')");
					}
				else
					{
						sql.append(" and upper(ISC.long_desc)  like upper('"+ssdesc+"%')");
						andCheck = 1;
					}
			}
	sssdesc=sssdesc.toUpperCase();
		if ( !(sssdesc == null || sssdesc.equals("")) )
			{

				if ( andCheck == 1 )
					{	
						sql.append(" and upper(inj_subcategory_long_desc)  like  upper('"+sssdesc+"%')");
					}
				else
					{
						sql.append(" and upper(inj_subcategory_long_desc)  like upper('"+sssdesc+"%')");
						andCheck = 1;
					}
			}

	estatus=estatus.toUpperCase();
//		if ( !(estatus == null || estatus.equals("")) )
			{
     
			   if ( estatus.equals("E") )
					{

						if ( andCheck == 0 )
							sql.append(" and ISC.EFF_STATUS='E'");
						else
							sql.append(" and  ISC.EFF_STATUS='E'"); //ISC is the alias name of subcategory table 
					}
			   if ( estatus.equals("D") )
					{
					
						if ( andCheck == 0 )
							sql.append(" and  ISC.EFF_STATUS='D'");
						else
							sql.append(" and	ISC.EFF_STATUS='D'");
					}
			   if ( estatus.equals("B") )
					{
							}
				}

		//appending order by clause
		String ord[] = request.getParameterValues("orderbycolumns");

		if ( !(ord == null || ord .equals("")) )
			{
				sql.append(" order by ");

				for ( int i=0;i < ord.length;i++ )
	 				{
				 	    if ( i == ord.length - 1 )
							sql.append(ord[i]);
					    else
							sql.append(ord[i]+",");
					}
			}
			else 
		{
			sql.append(whereClause);
		}
		 //end of where clause IF


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
		
		Connection conn = null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		ResultSet rs1 = null;

    try
    {
		
   	conn = ConnectionManager.getConnection(request);

	StringBuffer strsql2=new StringBuffer();
	strsql2.append("SELECT IC.INJ_CATEGORY_CODE, IC.LONG_DESC 	INJ_CATEGORY_LONG_DESC, IC.SHORT_DESC	INJ_CATEGORY_SHORT_DESC, ISC.INJ_SUBCATEGORY_CODE, ISC.LONG_DESC	INJ_SUBCATEGORY_LONG_DESC, ISC.SHORT_DESC	INJ_SUBCATEGORY_SHORT_DESC, ISC.EFF_STATUS EFF_STATUS FROM  AE_INJURY_CATEGORY 	IC, AE_INJURY_SUBCATEGORY  ISC WHERE  ISC.INJ_CATEGORY_CODE = IC.INJ_CATEGORY_CODE ");
	strsql2.append(sql.toString());
	
    stmt = conn.prepareStatement(strsql2.toString());
	rs1 = stmt.executeQuery();
	  String classValue = "" ;
	  int cnt=0;
	  String endOfRes="1";
	  if ( start != 1 )
		 for( int j=1; j<start; i++,j++ )
		  {
			rs1.next() ;
		  }
  
	 while (i<=end && rs1.next()){
		if(cnt==0){
%>

<p>
<table align='right'>
<tr>
<td>
<%
	if ( !(start <= 1) )
	    out.println("<A HREF='../../eAE/jsp/InjurySubCategoryQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

	if (endOfRes.equals("1"))
	    out.println("<A id='nextvalue' HREF='../../eAE/jsp/InjurySubCategoryQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
%>
</td>
</tr>
</table>
</p>
<br>
<br>


	<table border="1" width="100%" cellspacing='0' cellpadding='0'>
	<th><fmt:message key="Common.CategoryCode.label" bundle="${common_labels}"/></th>
	<th><fmt:message key="Common.CategoryDescription.label" bundle="${common_labels}"/></th>
	<th><fmt:message key="eAE.SubCategoryCode.label" bundle="${ae_labels}"/></th>
	<th><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></th>
	<th><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></th>
	<th><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>

<%}
	        if ( i % 2 == 0 )
				classValue = "QRYEVEN" ;
			else
				classValue = "QRYODD" ;
			

		out.println("<tr><td class='" + classValue + "'>");
		String code = rs1.getString("inj_category_code");
		String sbcode= rs1.getString("inj_subcategory_code");
		out.println("<a href='../../eAE/jsp/addModifyInjurySubCategory.jsp?inj_category_code="+code+"&inj_subcategory_code="+sbcode+"&source=Modify"+"'target='f_query_add_mod'>");	
		out.println(code+"</a></td><td class='" + classValue + "'>");
		 
		out.println( rs1.getString("inj_category_short_desc") );
		out.println("</td><td class='" + classValue + "'>");
		
	
		out.println(sbcode+"</td><td class='" + classValue + "'>");				
		

		out.println(rs1.getString("inj_subcategory_long_desc") );


		out.println("</td><td class='" + classValue + "'>");
		out.println(rs1.getString("inj_subcategory_short_desc") );
		
		out.println("</td><td align='center' class='" + classValue + "'>");
		if ( rs1.getString("EFF_STATUS").equals("E") )
			out.println("<img src='../../eCommon/images/enabled.gif'></img>");
		else
			out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
		
		i++;

 	cnt++;
 }//endwhile
 if(cnt==0)
	 out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','COMMON'));history.go(-1);</script>");
 if(!rs1.next()&&cnt!=0){
	endOfRes="0";%>
	<script>
		document.getElementById("nextvalue").innerHTML=" ";
	</script>
	<%} 

	     sql.setLength(0);
         //strsql1.setLength(0);
         strsql2.setLength(0);

         if(rs!=null) rs.close();
		 if(rs1!=null) rs1.close();
         if(stmt!=null)	stmt.close(); 
    }// end oftry 

    catch(Exception e)
    {
		e.printStackTrace();
    }

	finally   
	{
	    if(conn!=null)    
	    ConnectionManager.returnConnection(conn,request);
	}
%>

	</td></tr>
	</table>
	<br><center>

</center>
</BODY>
</HTML>

