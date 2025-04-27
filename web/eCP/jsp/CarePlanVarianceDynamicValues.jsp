<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%--
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eCP
*	Purpose 		:	
*	Created By		:	P.Anuradha
*	Created On		:	19 July 2005
--%>
<%@ page import ="java.sql.*,java.text.*,java.util.*,webbeans.eCommon.*"  contentType="text/html;charset=UTF-8"%>
<%
//This file is saved on 18/10/2005.
request.setCharacterEncoding("UTF-8");
String locale=(String)session.getAttribute("LOCALE");
String mode=request.getParameter("mode")==null?"":request.getParameter("mode");
String variance_cause=request.getParameter("variance_cause")==null?"":request.getParameter("variance_cause");
String sql_variance_reason="";
//String variance_reason_code="";
//String variance_reason_desc="";
String[] record	= null;

ArrayList Variance_Reason=new ArrayList();

Connection conn = null;
PreparedStatement pstmt_sql_variance_reason=null;
ResultSet rset_sql_variance_reason = null;

if(mode.equals("1"))
{
try
{
	conn=ConnectionManager.getConnection(request);
//	sql_variance_reason="select var_reason_code,var_reason_desc from cp_variance_reason where var_cause_code = ? order by var_reason_desc";
	sql_variance_reason="SELECT var_reason_code,var_reason_desc FROM cp_variance_reason_LANG_VW WHERE var_cause_code = ? AND LANGUAGE_ID = ? ORDER BY var_reason_desc";
	pstmt_sql_variance_reason=conn.prepareStatement(sql_variance_reason);
	pstmt_sql_variance_reason.setString(1,variance_cause);
	pstmt_sql_variance_reason.setString(2,locale);
	rset_sql_variance_reason=pstmt_sql_variance_reason.executeQuery();

	if(rset_sql_variance_reason!=null)
	{
		while(rset_sql_variance_reason.next())
		{
			record=new String[2];
            record[0]=rset_sql_variance_reason.getString("var_reason_code");
            record[1]=rset_sql_variance_reason.getString("var_reason_desc");
			Variance_Reason.add(record);
		}
	}

	for( int i=0 ; i< Variance_Reason.size() ; i++ ) 
	{
		record = (String[])Variance_Reason.get(i);
		out.println("addVarianceReason(\"" + record[0] + "\",\"" + record[1] + "\") ; " );
	}
}
catch(Exception exp)
{
//	out.println("Exception"+exp.toString());//COMMON-ICN-0181
          exp.printStackTrace();//COMMON-ICN-0181
}
finally
{
  try
  {
  if(rset_sql_variance_reason!=null) rset_sql_variance_reason.close();
  if(pstmt_sql_variance_reason!=null) pstmt_sql_variance_reason.close();
  if(conn!=null) conn.close();
  }
  catch(Exception exp)
  {
	//  out.println(exp.toString());//COMMON-ICN-0181
	     exp.printStackTrace();//COMMON-ICN-0181
  }
}
}
else
{
try
{
RecordSet	CarePlanVariance	=	null;
CarePlanVariance	=	(webbeans.eCommon.RecordSet)session.getAttribute("CarePlanVariance");
String select_mode=request.getParameter("select_mode")==null?"":request.getParameter("select_mode");
String index1="";
String select_yn=request.getParameter("select_yn1")==null?"":request.getParameter("select_yn1");
ArrayList one=new ArrayList();
index1=request.getParameter("index")==null?"":request.getParameter("index");
int index=Integer.parseInt(index1);
if(select_mode.equals("3"))
{
one=(ArrayList)CarePlanVariance.getObject(index);
one.set(5,select_yn);
}
else 
{
	select_yn="Y";
}
}
catch(Exception exp)
{
 // out.println(exp.toString());//COMMON-ICN-0181
    exp.printStackTrace();//COMMON-ICN-0181
}
}
%>
