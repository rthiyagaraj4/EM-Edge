<!DOCTYPE html>
<%@ page import ="java.sql.*,java.net.*,webbeans.eCommon.ConnectionManager" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script>

<HTML>
<head>
	
	<%
		request.setCharacterEncoding("UTF-8");
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		
	
	

</head>
<BODY class='CONTENT'  OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<%

	Connection conn=null;
	PreparedStatement stmt = null;
	PreparedStatement stmt1 = null;
	ResultSet rset = null;

    String whereClause = request.getParameter("whereclause");
	if(whereClause==null) whereClause="";
    String from = request.getParameter( "from" ) ;
    String to = request.getParameter( "to" ) ;
    StringBuffer sql = new StringBuffer();
    String relation_id  = request.getParameter("pract_reln_id");
    String relation_name = request.getParameter("pract_reln_name");
    String ip_attend = request.getParameter("ip_attend_phys_yn");
	String ip_admit = request.getParameter("ip_admit_phys_yn");
	String op_attend = request.getParameter("op_attend_phys_yn");
	String ae_attend = request.getParameter("ae_attend_phys_yn");
	String dc_attend = request.getParameter("dc_attend_phys_yn");
	String referal_reln = request.getParameter("referal_reln_yn");
	String attend_nurse = request.getParameter("attend_nurse_reln_yn");
	String ip_default = request.getParameter("dflt_ip_attend_phys_yn");
	String ip_admit_default = request.getParameter("dflt_ip_admit_phys_yn");
	String op_default = request.getParameter("dflt_op_attend_phys_yn");
	String ae_default = request.getParameter("dflt_ae_attend_phys_yn");
	String dc_default = request.getParameter("dflt_dc_attend_phys_yn");
	String referral_deflt = request.getParameter("dflt_referal_reln_yn");
	String nm_default = request.getParameter("dflt_attend_nurse_reln_yn");
	//Modified by Archana @10-12-2008
	String  MstQryPageCnt = (((session.getAttribute("MstQryPageCnt") != null) && (session.getAttribute("MstQryPageCnt") != "")))?((String)session.getAttribute("MstQryPageCnt")) : "14";
    int pageCnt = Integer.parseInt(MstQryPageCnt);

    if ( (whereClause == null || whereClause.equals("")) )
    {
	int cnt=0;
	//if(sql.length() > 0) sql.delete(0,sql.length());
	if ( !(relation_id == null || relation_id.equals("")) )
        {
		if(sql.length() > 0) sql.delete(0,sql.length());
	        sql.append(" where upper(PRACT_RELN_ID ) like upper('"+relation_id +"%')");
			cnt++;
        }

        if ( !(relation_name == null || relation_name.equals("")) )
        {
			if(cnt>0)
			{
				sql.append(" and upper(PRACT_RELN_NAME) like upper('"+relation_name+"%')");
			}
			else
			{
				sql.append(" where upper(PRACT_RELN_NAME) like upper('"+relation_name+"%')");
				cnt=1;
			}

        }

	 if ( !(ip_attend == null || ip_attend.equals("")) )
    {
         if( ip_attend.equals("Y") )
         {
			if(cnt>0)
			 {
				//out.println("cnt in if"+cnt);
			   sql.append(" and ip_attend_phys_yn='Y'");
			 }
			else
			 {
				//out.println("cnt in else"+cnt);
				sql.append(" where  ip_attend_phys_yn='Y'");
				cnt = 1;
			 }

         }
         if ( ip_attend.equals("N") )
         {
			if(cnt>0)
			   sql.append(" and ip_attend_phys_yn='N'");
			else
			 {
				sql.append(" where  ip_attend_phys_yn='N'");
				cnt = 1;
			 }

         }

         if ( ip_attend.equals("B") )
         {
//               sql = sql; //nothing is added to get both E and D
         }
    }

	if ( !(ip_admit == null || ip_admit.equals("")) )
    {
         if( ip_admit.equals("Y") )
         {
			if(cnt>0)
			   sql.append(" and ip_admit_phys_yn='Y'");
			else
			 {
				sql.append(" where  ip_admit_phys_yn='Y'");
				cnt = 1;
			 }

         }
         if ( ip_admit.equals("N") )
         {
			if(cnt>0)
			  sql.append(" and ip_admit_phys_yn='N'");
			else
			 {
				sql.append(" where  ip_admit_phys_yn='N'");
				cnt = 1;
			 }
         }

         if ( ip_admit.equals("B") )
         {
//               sql = sql; //nothing is added to get both E and D
         }
    }
    
	if ( !(op_attend == null || op_attend.equals("")) )
    {
         if( op_attend.equals("Y") )
         {
			if(cnt>0)
			  sql.append(" and op_attend_phys_yn='Y'");
			else
			 {
				sql.append(" where  op_attend_phys_yn='Y'");
				cnt = 1;
			 }

         }
         if ( op_attend.equals("N") )
         {
			if(cnt>0)
			  sql.append(" and op_attend_phys_yn='N'");
			else
			 {
				sql.append(" where  op_attend_phys_yn='N'");
				cnt = 1;
			 }


         }

         if ( op_attend.equals("B") )
         {
//               sql = sql; //nothing is added to get both E and D
         }
    }

		if ( !(ae_attend == null || ae_attend.equals("")) )
    {
         if( ae_attend.equals("Y") )
         {
			if(cnt>0)
			  sql.append(" and ae_attend_phys_yn='Y'");
			else
			 {
				sql.append(" where  ae_attend_phys_yn='Y'");
				cnt = 1;
			 }

         }
         if ( ae_attend.equals("N") )
         {
			if(cnt>0)
			   sql.append(" and ae_attend_phys_yn='N'");
			else
			 {
				sql.append(" where  ae_attend_phys_yn='N'");
				cnt = 1;
			 }


         }

         if ( ae_attend.equals("B") )
         {
//               sql = sql; //nothing is added to get both E and D
         }
    }

	if ( !(dc_attend == null || dc_attend.equals("")) )
    {
         if( dc_attend.equals("Y") )
         {
			if(cnt>0)
			   sql.append(" and dc_attend_phys_yn='Y'");
			else
			 {
				sql.append(" where  dc_attend_phys_yn='Y'");
				cnt = 1;
			 }

         }
         if ( dc_attend.equals("N") )
         {
			if(cnt>0)
			  sql.append(" and dc_attend_phys_yn='N'");
			else
			 {
				sql.append(" where  dc_attend_phys_yn='N'");
				cnt = 1;
			 }


         }

         if ( dc_attend.equals("B") )
         {
//               sql = sql; //nothing is added to get both E and D
         }
    }
	
	if ( !(referal_reln == null || referal_reln.equals("")) )
    {
         if( referal_reln.equals("Y") )
         {
			if(cnt>0)
			  sql.append(" and referal_reln_yn='Y'");
			else
			 {
				sql.append(" where  referal_reln_yn='Y'");
				cnt = 1;
			 }

         }
         if ( referal_reln.equals("N") )
         {
			if(cnt>0)
			   sql.append(" and referal_reln_yn='N'");
			else
			 {
				sql.append(" where  referal_reln_yn='N'");
				cnt = 1;
			 }


         }

         if ( referal_reln.equals("B") )
         {
//               sql = sql; //nothing is added to get both E and D
         }
    }
	
	if ( !(attend_nurse == null || attend_nurse.equals("")) )
    {
         if( attend_nurse.equals("Y") )
         {
			if(cnt>0)
			   sql.append(" and attend_nurse_reln_yn='Y'");
			else
			 {
				sql.append(" where  attend_nurse_reln_yn='Y'");
				cnt = 1;
			 }

         }
         if ( attend_nurse.equals("N") )
         {
			if(cnt>0)
			  sql.append(" and attend_nurse_reln_yn='N'");
			else
			 {
				sql.append(" where  attend_nurse_reln_yn='N'");
				cnt = 1;
			 }


         }

         if ( attend_nurse.equals("B") )
         {
//               sql = sql; //nothing is added to get both E and D
         }
    }

	if ( !(ip_default == null || ip_default.equals("")) )
    {
         if( ip_default.equals("Y") )
         {
			if(cnt>0)
			   sql.append(" and dflt_ip_attend_phys_yn='Y'");
			else
			 {
				sql.append(" where  dflt_ip_attend_phys_yn='Y'");
				cnt = 1;
			 }

         }
         if ( ip_default.equals("N") )
         {
			if(cnt>0)
			  sql.append(" and dflt_ip_attend_phys_yn='N'");
			else
			 {
				sql.append(" where  dflt_ip_attend_phys_yn='N'");
				cnt = 1;
			 }


         }

         if ( ip_default.equals("B") )
         {
//               sql = sql; //nothing is added to get both E and D
         }
    }

    if ( !(ip_admit_default == null || ip_admit_default.equals("")) )
    {
         if( ip_admit_default.equals("Y") )
         {
			if(cnt>0)
			   sql.append(" and dflt_ip_admit_phys_yn='Y'");
			else
			 {
				sql.append(" where  dflt_ip_admit_phys_yn='Y'");
				cnt = 1;
			 }

         }
         if ( ip_admit_default.equals("N") )
         {
			if(cnt>0)
			  sql.append(" and dflt_ip_admit_phys_yn='N'");
			else
			 {
				sql.append(" where  dflt_ip_admit_phys_yn='N'");
				cnt = 1;
			 }


         }

         if ( ip_admit_default.equals("B") )
         {
//               sql = sql; //nothing is added to get both E and D
         }
    }

    if ( !(op_default == null || op_default.equals("")) )
    {
         if( op_default.equals("Y") )
         {
			if(cnt>0)
			   sql.append(" and dflt_op_attend_phys_yn='Y'");
			else
			 {
				sql.append(" where  dflt_op_attend_phys_yn='Y'");
				cnt = 1;
			 }

         }
         if ( op_default.equals("N") )
         {
			if(cnt>0)
			  sql.append(" and dflt_op_attend_phys_yn='N'");
			else
			 {
				sql.append(" where  dflt_op_attend_phys_yn='N'");
				cnt = 1;
			 }


         }

         if ( op_default.equals("B") )
         {
//               sql = sql; //nothing is added to get both E and D
         }
    }

	if ( !(ae_default == null || ae_default.equals("")) )
    {
         if( ae_default.equals("Y") )
         {
			if(cnt>0)
			   sql.append(" and dflt_ae_attend_phys_yn='Y'");
			else
			 {
				sql.append(" where  dflt_ae_attend_phys_yn='Y'");
				cnt = 1;
			 }

         }
         if ( ae_default.equals("N") )
         {
			if(cnt>0)
			  sql.append(" and dflt_ae_attend_phys_yn='N'");
			else
			 {
				sql.append(" where  dflt_ae_attend_phys_yn='N'");
				cnt = 1;
			 }


         }

         if ( ae_default.equals("B") )
         {
//               sql = sql; //nothing is added to get both E and D
         }
    }

	if ( !(dc_default == null || dc_default.equals("")) )
    {
         if( dc_default.equals("Y") )
         {
			if(cnt>0)
			   sql.append(" and dflt_dc_attend_phys_yn='Y'");
			else
			 {
				sql.append(" where  dflt_dc_attend_phys_yn='Y'");
				cnt = 1;
			 }

         }
         if ( dc_default.equals("N") )
         {
			if(cnt>0)
			  sql.append(" and dflt_dc_attend_phys_yn='N'");
			else
			 {
				sql.append(" where  dflt_dc_attend_phys_yn='N'");
				cnt = 1;
			 }


         }

         if ( dc_default.equals("B") )
         {
//               sql = sql; //nothing is added to get both E and D
         }
    }

	if ( !(referral_deflt == null || referral_deflt.equals("")) )
    {
         if( referral_deflt.equals("Y") )
         {
			if(cnt>0)
			   sql.append(" and dflt_referal_reln_yn='Y'");
			else
			 {
				sql.append(" where  dflt_referal_reln_yn='Y'");
				cnt = 1;
			 }

         }
         if ( referral_deflt.equals("N") )
         {
			if(cnt>0)
			  sql.append(" and dflt_referal_reln_yn='N'");
			else
			 {
				sql.append(" where  dflt_referal_reln_yn='N'");
				cnt = 1;
			 }


         }

         if ( referral_deflt.equals("B") )
         {
//               sql = sql; //nothing is added to get both E and D
         }
    }

	if ( !(nm_default == null || nm_default.equals("")) )
    {
         if( nm_default.equals("Y") )
         {
			if(cnt>0)
			   sql.append(" and dflt_attend_nurse_reln_yn='Y'");
			else
			 {
				sql.append(" where  dflt_attend_nurse_reln_yn='Y'");
				cnt = 1;
			 }

         }
         if ( nm_default.equals("N") )
         {
			if(cnt>0)
			  sql.append(" and dflt_attend_nurse_reln_yn='N'");
			else
			 {
				sql.append(" where  dflt_attend_nurse_reln_yn='N'");
				cnt = 1;
			 }


         }

         if ( nm_default.equals("B") )
         {
//               sql = sql; //nothing is added to get both E and D
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
			{
            sql.append(ord[i]);
			sql.append(",");
			}
        }
    }

    } //end of where clause IF
    else
            sql.append(whereClause);




    int start = 0 ;
    int end = 0 ;
    int i=1;

    if ( from == null )
        start = 1 ;
    else
        start = Integer.parseInt( from ) ;

    if ( to == null )
        end = pageCnt ;
    else
        end = Integer.parseInt( to ) ;
try
{
	conn  =  ConnectionManager.getConnection(request);
	int maxRecord = 0;


StringBuffer strsql= new StringBuffer();
if(strsql.length() > 0) strsql.delete(0,strsql.length());
strsql.append("select count(*) as total from ca_pract_reln");
strsql.append(sql);
//out.println(sql);
StringBuffer strsql1= new StringBuffer();
if(strsql1.length() > 0) strsql1.delete(0,strsql1.length());
strsql1.append("select PRACT_RELN_ID,PRACT_RELN_NAME, LIFETIME_OR_ENCNTR, EFF_STATUS FROM  ca_pract_reln ");
strsql1.append(sql);
//out.println(strsql1);
stmt = conn.prepareStatement(strsql.toString());
ResultSet rs = stmt.executeQuery();
rs.next();
maxRecord = rs.getInt("total");


if(maxRecord == 0){
	out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));history.go(-1);</script>");
}

stmt1=conn.prepareStatement(strsql1.toString());
rset = stmt1.executeQuery();
%>
<table cellpadding='3' cellspacing='0' border='0' width='100%' align='center'>
<tr>
	<td class='white' width='88%'></td>
<td align='right'>
<%
if ( !(start <= 1) )
    out.println("<A  class='gridLink' HREF='../../eCA/jsp/QueryResultPractRelation.jsp?from="+(start-pageCnt)+"&to="+(end-pageCnt)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+" </A>");

if ( !( (start+pageCnt) > maxRecord ) )
    out.println("<A  class='gridLink' HREF='../../eCA/jsp/QueryResultPractRelation.jsp?from="+(start+pageCnt)+"&to="+(end+pageCnt)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+" </A>");
%>
</td>
</tr>
</table>
<table width="100%" class='grid' >
<td class='COLUMNHEADERCENTER' ><fmt:message key="eCA.RelationshipID.label" bundle="${ca_labels}"/></td>
<td class='COLUMNHEADERCENTER' ><fmt:message key="eCA.RelationshipName.label" bundle="${ca_labels}"/></td>
<!-- <th width='10%'>Enabled</th> -->

<%
    if ( start != 1 )
     for( int j=1; j<start; i++,j++ )
      rset.next() ;
String classValue= "gridData";
      while ( rset.next() && i<=end  )
{
/*    if ( i % 2 == 0 )
                    classValue = "QRYEVEN" ;
                else
            classValue = "QRYODD" ;*/
    out.println("<tr class='grid' ><td  class='" + classValue + "'>");

    relation_id = rset.getString(1);
    relation_name=rset.getString(2);
    String nature= rset.getString(3);
	if(nature.equals("E")) nature="Encounter Specific";
	else if(nature.equals("L")) nature="LifeTime";

	out.println("<a class='gridLink' href='../../eCA/jsp/AddModifyPractRelation.jsp?relation_id="+ relation_id + "&relation_name="+relation_name+"&nature="+nature+"' target='f_query_add_mod' >");
        out.println(relation_id+"</a></td><td class='" + classValue + "'>");
 //   out.println("<a href='../../eCA/jsp/AddModifyPractRelation.jsp?relation_id="+ relation_id + "&relation_name="+relation_name+"&nature="+nature+" target='f_query_add_mod' >");
    out.println( rset.getString(2) );
    out.println("</td>");
//    out.println("</td><td class='" + classValue + "'>");
   // out.println("<a href='../../eCA/jsp/AddModifyPractRelation.jsp?relation_id="+ relation_id + "&relation_name="+relation_name+"&nature="+nature+" target='f_query_add_mod' >");
    /*out.println(nature );
    out.println("</td><td class='" + classValue + "' align='center'>");
    if ( rset.getString("eff_status").equals("E") )
        out.println("<img src='../../eCommon/images/enabled.gif'></img>");
    else
        out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
*/
	i++;
} %>

</tr>
</table>
</center>

<br><center>
<%		if(rs!=null)	rs.close();
		if(stmt!=null)	stmt.close();
		if(rset!=null) rset.close();
		if(stmt1!=null)	stmt1.close();
}
catch(Exception e)
{
	//out.println(e);//COMMON-ICN-0181
     e.printStackTrace();//COMMON-ICN-0181
}
finally
{
if(conn!=null)ConnectionManager.returnConnection(conn,request);
}
%>

</center>
</BODY>
</HTML>

