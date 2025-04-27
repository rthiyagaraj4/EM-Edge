<!DOCTYPE html>
<%@ page import ="java.sql.*,java.net.*,java.text.*, webbeans.eCommon.ConnectionManager" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
<%
request.setCharacterEncoding("UTF-8");
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<!-- Added by Arvind @ 07-12-08 -->

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
	<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
	<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body class='CONTENT'  OnMouseDown='CodeArrest()' onKeyDown="lockKey()">
<form name ='chiefComplaintMasterResultForm'>

<%
	Connection con			=	null ;
	String whereClause		=	"";

	String complaint_id ="";
	String complaint_desc ="";
	//String complaint_text ="";
	String speciality_code ="";
	String eff_status ="";

	String mode ="";	
	StringBuffer sql = new  StringBuffer();
	PreparedStatement pstmt=null,pstmt1=null;
	int maxRecord =	 0;
	ResultSet rset=null;
	ResultSet rs = null;

	String  MstQryPageCnt = (((session.getAttribute("MstQryPageCnt") != null) && (session.getAttribute("MstQryPageCnt") != "")))?((String)session.getAttribute("MstQryPageCnt")) : "14";
    int pageCnt = Integer.parseInt(MstQryPageCnt);
	

	try	{
			mode="modify";
			whereClause= request.getParameter("whereclause");
			if(whereClause==null) whereClause="";

			String from = request.getParameter( "from" ) ;
		    String to = request.getParameter( "to" ) ;

			complaint_id=request.getParameter("complaint_id");
			if( complaint_id == null)
				complaint_id = "";
			
			complaint_desc=request.getParameter("complaint_desc");
			if( complaint_desc == null)
				complaint_desc = "";
			
		

			speciality_code=request.getParameter("speciality_code");
			if( speciality_code == null)
				speciality_code = "";

			eff_status=request.getParameter("eff_status");
			if( eff_status == null)
				eff_status = "";


if ( (whereClause == null || whereClause.equals("null") || whereClause.equals("") ) )
{
		int cnt=0;
		if( !(complaint_id == null || complaint_id.equals("null") || complaint_id.equals("") ) )
		{
		    sql.append(" where upper(complaint_id) like upper('"+complaint_id+"%') ");
			cnt++;
		}

		if( !(complaint_desc == null  || complaint_desc.equals("null") || complaint_desc.equals("")) )
		{
			if(cnt>0)
			{
				sql.append( "and upper(complaint_desc) like upper('"+complaint_desc+"%')");
			}
			else
			{ sql=new StringBuffer();
				sql.append(" where upper(complaint_desc) like  upper('"+complaint_desc+"%')");
				cnt = 1;
			}
		}


		if( !(speciality_code == null  || speciality_code.equals("null") || speciality_code.equals("")) )
		{
			if(cnt>0)
			{
				sql.append( "and upper(speciality_code) like upper('"+speciality_code+"%')");
			}
			else
			{	sql=new StringBuffer();
				sql.append(" where upper(speciality_code) like  upper('"+speciality_code+"%')");
				cnt = 1;
			}
		}

		if ( !(eff_status == null || eff_status.equals("null") || eff_status.equals("") ) )
		{
			if( eff_status.equals("Y") )
			{
  				if(cnt>0)
				{
					sql.append(" and eff_status='E'");
				}
				else
				{	sql=new StringBuffer();
					sql .append(" where eff_status='E'");
				}
			}
			if ( eff_status.equals("N") )
			{
				if(cnt>0)
				{
					sql.append(" and eff_status='D'");
				}
				else
				{	sql=new StringBuffer();
					sql.append(" where  eff_status='D'");
				}
			}
            if ( eff_status.equals("B") )
			{
				//  sql = sql; //nothing is added to get both E and D
			}
		}

		String ord[] = request.getParameterValues("orderbycolumns");
		if ( !(ord == null  || ord .equals("null") || ord .equals("")) )
		{
				sql.append(" order by ");
				for ( int i=0;i < ord.length;i++ )
				{
					if ( i == ord.length - 1 )
					{
						sql.append(ord[i]);
					}
					else
					{
						sql.append(ord[i]+",");
					}
				}			
		}//if ord

}// if of where clause

else
		{	
			sql=new StringBuffer();
			sql.append(whereClause);
		}

int start = 0 ;
    int end = 0 ;
    int i=1;

		if ( from == null)
			start = 1 ;
		else
			start = Integer.parseInt( from ) ;

	    if ( to == null)
		    end = pageCnt ;
		else
			end = Integer.parseInt( to ) ;	

	con  = ConnectionManager.getConnection(request);
	
	try
	{	// stmt = con.createStatement();	

	   
		String strsql= "select count(*) as total from ca_chief_complaint"+sql.toString();
		pstmt=con.prepareStatement(strsql);
		
		String strsqll="select a.complaint_id,a.complaint_desc,(select long_desc from   am_speciality WHERE speciality_code = a.speciality_code ) speciality_desc,a.eff_status  from ca_chief_complaint a ";
		//out.println("sql "+strsqll+sql);		
	
		rs = pstmt.executeQuery();
		rs.next();
		maxRecord = rs.getInt("total");
		
		if(maxRecord == 0)
		{
			//out.println("<script>alert('NO RECORD FOUND FOR CRITERIA');history.go(-2);</script>");

			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));history.go(-1);</script>");
		}
		pstmt1=con.prepareStatement(strsqll+sql.toString());
		rset =pstmt1.executeQuery();
    }
	

	catch (Exception e)
	{
	//	out.println("Exception :"+e.getMessage());//COMMON-ICN-0181
                e.printStackTrace();//COMMON-ICN-0181
	}

%>

<!-- <modified by Arvind  90 to 100 @10-12-08> -->
<table cellpadding='3' cellspacing='0' border='0' width='100%' align='center'>

<tr>
<td class='white' width='65%' ></td> 
<td  align='right' width='15%' nowrap>

<%
if ( !(start <= 1) )
    out.println("<A class='gridLink' HREF='../../eCA/jsp/ChiefComplaintMasterResult.jsp?from="+(start-pageCnt)+"&to="+(end-pageCnt)+"&whereclause=" + URLEncoder.encode(sql.toString()) + "'" + " text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

if ( !( (start+pageCnt) > maxRecord ) )
    out.println("&nbsp;<A class='gridLink' HREF='../../eCA/jsp/ChiefComplaintMasterResult.jsp?from="+(start+pageCnt)+"&to="+(end+pageCnt)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
	
%>
</td></tr>
</table>

<table class='grid' border='1' width='100%' cellpadding='3' cellspacing='0' align='center' >
	
	<td class='COLUMNHEADERCENTER'><fmt:message key="eCA.ComplaintID.label" bundle="${ca_labels}"/></td>
	<td class='COLUMNHEADERCENTER'><fmt:message key="eCA.ComplaintDescription.label" bundle="${ca_labels}"/></td>
	<td class='COLUMNHEADERCENTER'><fmt:message key="eCA.SpecialityDesc.label" bundle="${ca_labels}"/></td>
	<td class='COLUMNHEADERCENTER'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>

	<%
	if ( start != 1 )
     for( int j=1; j<start; i++,j++ )
      rset.next() ;
String classValue= " ";
      while ( rset.next() && i<=end  )
      {
          if ( i % 2 == 0 )
            classValue = "gridData" ;
            else
            classValue = "gridData" ;
		
	complaint_id	=(rset.getString(1)==null)?"":rset.getString(1);
	complaint_desc=(rset.getString(2)==null)?"":rset.getString(2); 
  	speciality_code=(rset.getString(3)==null)?"":rset.getString(3); 
	eff_status=(rset.getString(4)==null)?"":rset.getString(4);

	//out.println("eff_status...."+eff_status);

	out.println("<tr><td class='" + classValue + "'>");
	out.println("<a class='gridLink' href='../../eCA/jsp/ChiefComplaintMaster.jsp?mode="+mode+"&complaint_id="+complaint_id+"' target='ChiefComplaintMaster' >");
    out.println(complaint_id+"</a></td>");
	out.println("<td class='" + classValue + "'>"+complaint_desc+"</td><td class='" + classValue + "' >"+speciality_code+"</td>");

	out.println("<td class='" + classValue + "' >");
	
	
	if (eff_status.equals("E") )
        out.println("<img src='../../eCommon/images/enabled.gif'></img>");
    else
        out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
	out.println("</td></tr>");

	i++;
	  }
%>


</table>

<%

	if( rs!=null) rs.close();
	if( rset!=null) rset.close();
	if (pstmt!=null)pstmt.close();
	if (pstmt1!=null) pstmt1.close();
}//end of 1st try block

	catch (Exception e)
	{
		//out.println("Exception :"+e.toString());//COMMON-ICN-0181
                 e.printStackTrace();//COMMON-ICN-0181
	}
	finally
	{	
		if(con!=null) ConnectionManager.returnConnection(con,request);
	}
%>

</form>
</body>
</html>

