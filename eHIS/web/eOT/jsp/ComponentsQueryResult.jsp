<!DOCTYPE html>
<%@page  import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,java.net.URLEncoder,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper" %>
<%@page  contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eOT/jsp/StringUtil.jsp"%>
<% String locale = (String)session.getAttribute("LOCALE"); %>


<HTML>           
	<head>
	<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
    

</head>
<BODY class='CONTENT'  OnMouseDown='CodeArrest()' onKeyDown="lockKey()">
<%
	try
	{
    
	String whereClause = request.getParameter("whereclause");
	if(whereClause==null) whereClause="";
    String from = request.getParameter( "from" ) ;
    String to = request.getParameter( "to" ) ;
    String sql = " ";

    String item_code = request.getParameter("item_code")==null?"":request.getParameter( "item_code" );
	String item_desc =request.getParameter("item_desc")==null?"":request.getParameter( "item_desc" );
	String cross_ref_st__item_code =request.getParameter("cross_ref_st__item_code")==null?"":request.getParameter( "cross_ref_st__item_code" );
    String consumable_yn = request.getParameter("consumable_yn")==null?"":request.getParameter( "consumable_yn");
   String select_checked="";
   String select_value="";
   String ph_module_yn=request.getParameter("ph_module_yn");	
	
    if ( (whereClause == null || whereClause.equals("")) )
    {
	int cnt=0;

		if ( !(item_code == null || item_code.equals("")) ){
			
	        sql = sql + " and upper(a.item_code ) like upper('"+item_code +"%')";
			cnt++;
        }

        if ( !(item_desc == null || item_desc.equals("")) ){
                
			if(cnt>0){
				
				sql = sql + " and upper(a.item_desc) like upper('"+item_desc+"%')";
			}
			else{
				
				sql=sql+" and upper(a.item_desc) like upper('"+item_desc+"%')";
				cnt=1;
			}

        }
		
	   	
	if ( !(consumable_yn == null || consumable_yn.equals("")) ){
		
         if( consumable_yn.equals("Y") || consumable_yn.equals("E")){

			if(cnt>0){
				
			   sql = sql+" and nvl(a.consumable_yn,'N')='Y' ";
	}
			else{
				
				sql=sql+ " and nvl(a.consumable_yn,'N')='Y' ";
				cnt=1;
			}
         }

		 if ( consumable_yn.equals("N") || consumable_yn.equals("D")){

            if(cnt>0){
				
			   sql = sql+" and nvl(a.consumable_yn,'N')='N'";
			}
			else{
				
				sql=sql+ " and  nvl(a.consumable_yn,'N')='N'";
				cnt=1;
				
			}
         }

         if ( consumable_yn.equals("A") ){
//               sql = sql; //nothing is added to get both E and D
         }
    }
 /*
 	if(cnt>0){
		if(ph_module_yn.equals("Y"))
			sql = sql+" AND A.LANGUAGE_ID='"+locale+"' AND B.LANGUAGE_ID = A.LANGUAGE_ID";
		else
			sql = sql+" AND LANGUAGE_ID='"+locale+"' ";

	}else{
		if(ph_module_yn.equals("Y"))
			sql=sql+ " where  A.LANGUAGE_ID='"+locale+"' AND B.LANGUAGE_ID = A.LANGUAGE_ID";
		else
			sql=sql+ " where  LANGUAGE_ID='"+locale+"' ";
	}
	*/
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
String strsql = "";
String strsql1 = "";

	try{
		if(ph_module_yn.equals("Y")){
			strsql="select a.item_code,a.item_desc,nvl(a.consumable_yn,'N') consumable_yn, a.cross_ref_st_item_code, GET_DESC('"+locale+"','MM_ITEM_LANG_VW','SHORT_DESC','ITEM_CODE',a.cross_ref_st_item_code) short_desc from ot_ss_components_lang_vw a, mm_item b where a.cross_ref_st_item_code=b.item_code(+) and a.language_id='"+locale+"' "+sql;
		
			strsql1="select a.item_code,a.item_desc,nvl(a.consumable_yn,'N') consumable_yn, a.cross_ref_st_item_code, GET_DESC('"+locale+"','MM_ITEM_LANG_VW','SHORT_DESC','ITEM_CODE',a.cross_ref_st_item_code) short_desc from ot_ss_components_lang_vw a, mm_item b where a.cross_ref_st_item_code=b.item_code(+) and a.language_id='"+locale+"' "+sql;
		}else{
			strsql="select a.item_code,a.item_desc,nvl(a.consumable_yn,'N') consumable_yn, null cross_ref_st_item_code, null short_desc from ot_ss_components_lang_vw a where a.language_id = '"+locale+"' "+sql;
		
			strsql1="select a.item_code,a.item_desc,nvl(a.consumable_yn,'N') consumable_yn, a.cross_ref_st_item_code,NULL short_desc from ot_ss_components_lang_vw a where a.language_id = '"+locale+"' "+sql;
		}
        //out.println(strsql);
        //out.println(strsql1);
		stmt = conn.prepareStatement(strsql);
		rs = stmt.executeQuery();
		int total=0;
		while(rs.next())
		{
			total++;
		}
		maxRecord = total;
		if(maxRecord == 0){
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>");
		}
		
		stmt1=conn.prepareStatement(strsql1);
		rset = stmt1.executeQuery();
		
	}catch(Exception e){
		e.printStackTrace();
		//out.println("sdfsadfs "+e);
	}
%>
<form name='QueryResult' id='QueryResult'>
<P>
<table align='right'>
<tr>
<td>
<% 
if ( !(start <= 1) )
    out.println("<A HREF='../../eOT/jsp/ComponentsQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&ph_module_yn="+ph_module_yn+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

if ( !( (start+14) > maxRecord ) )
    out.println("<A HREF='../../eOT/jsp/ComponentsQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&ph_module_yn="+ph_module_yn+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
%>
</td>
</tr>
</table>
<br><br>
</p>

<table  class='grid' border="1" width="100%" cellspacing='0' cellpadding='0' align='center'>
<th class="columnheadercenter" nowrap> <!-- changed by yadav -->
     <fmt:message key="Common.code.label" bundle="${common_labels}"/>
</th><!--20%-->
<th class="columnheadercenter" nowrap> <!-- changed by yadav -->
     <fmt:message key="Common.description.label" bundle="${common_labels}"/>
</th><!--30%-->
<%
	if(ph_module_yn.equals("Y")){
%>
	<th class="columnheadercenter" nowrap> <!-- changed by yadav -->
		 <fmt:message key="eOT.CrossReferenceItem.Label" bundle="${ot_labels}"/>
	</th> <!--20%-->
<%
	}
%>
<th class="columnheadercenter" nowrap> <!-- changed by yadav -->
     <fmt:message key="Common.Consumable.label" bundle="${common_labels}"/>
</th> <!--20%-->
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
    out.println("<tr><td align=='left' class='" + classValue + "'>");

    item_code = checkForNull(rset.getString(1));
	item_desc=checkForNull(rset.getString(2));
	consumable_yn=checkForNull(rset.getString(3));
	cross_ref_st__item_code=checkForNull(rset.getString(5));//description from mm_item table for cross_ref_st_item_code
	if(cross_ref_st__item_code==null || cross_ref_st__item_code.equals("null") || cross_ref_st__item_code.equals(""))
		cross_ref_st__item_code="&nbsp;";
    String mode="modify";
	out.println("<a href='../../eOT/jsp/ComponentsAddModify.jsp?mode="+mode+"&ph_module_yn="+ph_module_yn+"&item_code="+ item_code+"' target='f_query_add_mod' >");
    out.println(item_code+"</a></td>");
  
   out.println("<td class='" + classValue+"'>"+item_desc+"</td>");
	if(ph_module_yn.equals("Y")){
		out.println("<td class='" + classValue+"'>"+cross_ref_st__item_code+"</td>");
	}   
    if (consumable_yn.equals("Y") || consumable_yn.equals("E")){
		select_checked="checked";
		select_value="Y";					
	}else{
		select_checked="";
		select_value="N";
	}
	out.println("<td class='" + classValue + "' align='center'> <input type=checkbox name=chk_select"+i+" value="+select_value+" "+select_checked+" disabled>");	
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
}catch(Exception e){
		e.printStackTrace();
		//out.println("Exception in Componenet Query Result page --> "+e);
}
%>

</center>
</form>
</BODY>
</HTML>

