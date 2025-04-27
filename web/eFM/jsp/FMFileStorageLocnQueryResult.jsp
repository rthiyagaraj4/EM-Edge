<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*"  contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<HTML>
<head>
	<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
	<%
	request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>

	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<BODY class='CONTENT' onLoad="" onMouseDown="CodeArrest()" onKeyDown = 'lockKey();'>
<%
	String whereClause = request.getParameter("whereclause");
		
	Connection conn = ConnectionManager.getConnection(request);
	String facility_id = (String) session.getValue("facility_id");

	StringBuffer sql	= null;
	sql					= new StringBuffer();

	String endOfRes = "1" ;
	String from = request.getParameter( "from" ) ;
	String to   = request.getParameter( "to" ) ;


	if ( (whereClause == null || whereClause.equals("")) )
	{
		sql.append(" Where A.FACILITY_ID = '"+facility_id+"' ");

		String stcode = request.getParameter("FS_LOCN_CODE");
		String stdesc = request.getParameter("LONG_DESC");
		String mrseccod = request.getParameter("MR_SECTION_CODE"); 
		String mrlocn = request.getParameter("MR_LOCN_YN");
		String prarea = request.getParameter("PERMANENT_FILE_AREA_YN");
		String locnid = request.getParameter("LOCN_IDENTITY");
		String holder_name = request.getParameter("HOLDER_NAME");
		String eff_status = request.getParameter("EFF_STATUS");

		if ( !(stcode == null || stcode.equals("")) )
		{
			stcode = stcode.toUpperCase();
			sql.append(" AND upper(FS_LOCN_CODE) like '"+stcode+"%' ");
		}

		if ( !(stdesc == null || stdesc.equals("")) )
		{
			stdesc = stdesc.toUpperCase();
			sql.append(" AND upper(LONG_DESC) like '"+stdesc+"%' ");
		}
		if ( !(mrseccod == null || mrseccod.equals("")) )
		{
			mrseccod = mrseccod.toUpperCase();
			sql.append(" AND upper(MR_SECTION_CODE) like '"+mrseccod+"%' ");
		}

		if ( !(mrlocn == null || mrlocn.equals("")) )
		{
			sql.append(" AND MR_LOCN_YN in decode('"+mrlocn+"','Y','Y','N','N',MR_LOCN_YN) ");
		}

		if ( !(prarea == null || prarea.equals("")) )
		{
			sql.append(" AND PERMANENT_FILE_AREA_YN in decode('"+prarea+"','Y','Y','N','N',PERMANENT_FILE_AREA_YN) ");
		}

		if ( !(locnid == null || locnid.equals("")) )
		{
			sql.append(" AND LOCN_IDENTITY in decode('"+locnid+"','D','D','C','C','N','N','T','T','E','E','Y','Y',LOCN_IDENTITY) ");
		}

		if ( !(holder_name == null || holder_name.equals("")) )
		{
			holder_name = holder_name.toUpperCase();
			sql.append(" AND upper(HOLDER_NAME) like '"+holder_name+"%' ");
		}

		if ( !(eff_status == null || eff_status.equals("null")) )
		{
			sql.append(" AND eff_status in decode('"+eff_status+"','E','E','D','D',eff_status) ");
		}
	}

//	appending order by clause
	String ord[] = request.getParameterValues("orderbycolumns");
	
	if ( !(ord == null || ord .equals("")) )
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
			sql.append(ord[i]);
			sql.append(" , ");
			}
		}
		//}
	} //end of where clause IF
	else {
		sql.append(whereClause);
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

java.sql.Statement stmt=null;
ResultSet rs=null;
//int maxRecord = 0;

try{

if (sql==null){
	sql.append(" order by 1 ");
}

stmt = conn.createStatement();

StringBuffer strsql1	= null;
strsql1					= new StringBuffer();
/*
strsql1.append(" select count(*) as total from FM_STORAGE_LOCN a ");
strsql1.append(sql);

rs = stmt.executeQuery(strsql1.toString());
if(rs.next()){
	maxRecord = rs.getInt(1);
}
if(rs   != null)	rs.close();*/
	  
/**/
StringBuffer strsql2	= null;
strsql2					= new StringBuffer();

strsql2.append(" SELECT a.FS_LOCN_CODE, a.LONG_DESC, a.SHORT_DESC,a.MR_SECTION_CODE, a.MR_LOCN_YN, a.PERMANENT_FILE_AREA_YN, DECODE(a.LOCN_IDENTITY,'D','Department','C','Clinic','N','Nursing Unit','T','Practitioner','E','Procedure Unit','Y','Daycare Unit')  LOCN_IDENTITY,a.HOLDER_NAME,a.HOLDER_PHONE_NO,a.EFF_STATUS, b.appl_user_name FROM FM_STORAGE_LOCN a, SM_FACILITY_FOR_USER_VW b WHERE a.HOLDER_NAME = b.appl_user_id(+) AND a.facility_id = b.facility_id(+) AND ");

strsql2.append(sql.toString().substring(6,sql.toString().length()));
rs = stmt.executeQuery(strsql2.toString());


%>

<p>
<table align='right'>
<tr>
<td>
<%
if ( !(start <= 1)  )
	out.println("<A HREF='../../eFM/jsp/FMFileStorageLocnQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql.toString())+"' text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

if ( endOfRes.equals("1") ) 
	out.println("<A id='nextval' style='visibility:hidden' HREF='../../eFM/jsp/FMFileStorageLocnQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql.toString())+"' text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");

%>
</td>
</tr>
</table>
<br><br>
</p>

<table border="1"  cellspacing='0' cellpadding='0' >
<td class='COLUMNHEADER'><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
<td class='COLUMNHEADER' nowrap><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
<td class='COLUMNHEADER' nowrap><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
 <td class='COLUMNHEADER' nowrap><fmt:message key="Common.MRSection.label" bundle="${common_labels}"/></td> 
<td class='COLUMNHEADER' nowrap><fmt:message key="eFM.MedicalRecordDept.label" bundle="${fm_labels}"/></td>
<td class='COLUMNHEADER' nowrap><fmt:message key="eFM.PermanentFSLocation.label" bundle="${fm_labels}"/></td>
<td class='COLUMNHEADER' nowrap><fmt:message key="eFM.FSLocationIdentity.label" bundle="${fm_labels}"/></td>
<td class='COLUMNHEADER' nowrap><fmt:message key="eFM.HolderName.label" bundle="${fm_labels}"/></td>
<td class='COLUMNHEADER' nowrap><fmt:message key="eFM.HolderPhoneNo..label" bundle="${fm_labels}"/></td>
<td class='COLUMNHEADER' nowrap><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>

<%
 	if ( start != 1 )
	 for( int j=1; j<start; i++,j++ ){
	  rs.next() ;
  }
	  String classValue = "" ;
//out.println("<script>alert(' start '+"+start+")</script>");
//out.println("<script>alert(' end '+"+end+")</script>");
		int loccount=0;
while ( i<=end && rs.next())
{
	if ( i % 2 == 0 )
		  	classValue = "QRYEVEN" ;
		  else
		  	classValue = "QRYODD" ;

	String code = rs.getString("FS_LOCN_CODE");
	String locn = rs.getString("MR_LOCN_YN");
	String area = rs.getString("PERMANENT_FILE_AREA_YN");
	String eff  = rs.getString("EFF_STATUS");
	String holder_name = rs.getString("appl_user_name");
	String holder_phone_no = rs.getString("HOLDER_PHONE_NO");
	String mr_sce_cod = rs.getString("MR_SECTION_CODE");//m
	if (holder_name==null || holder_name.equals("null")) holder_name="&nbsp;";
	if (holder_phone_no==null || holder_phone_no.equals("null")) holder_phone_no="&nbsp;";
	if(mr_sce_cod == null || mr_sce_cod.equals("null")) mr_sce_cod = "&nbsp;";//m

	out.println("<tr><td nowrap class='" + classValue + "'>");
	out.println("<a href='../../eFM/jsp/FMFileStorageLocnAddMod.jsp?StorageLocnCode="+ code + "& target=f_query_add_mod&operation=modify' >");
	out.println(code+"</a></td><td nowrap  class='" + classValue + "'>");
	out.println( rs.getString("LONG_DESC") );
	out.println("</td><td nowrap  class='" + classValue + "'>");
	out.println( rs.getString("SHORT_DESC") );
	out.println("</td><td nowrap  class='" + classValue + "'>");//m
	out.println(mr_sce_cod);//m
	out.println("</td><td nowrap align='center' class='" + classValue + "'>");	
	
	if (locn.equals("Y"))
	{
%>
		<IMG SRC="../../eCommon/images/enabled.gif" BORDER=0 ALT=""></IMG>
<%
	}
else 
	{
%>
		<IMG SRC="../../eCommon/images/RRnwd.gif" BORDER=0 ALT=""></IMG>
<%	}
	out.println("</td><td nowrap align='center' class='" + classValue + "'>");	
	
	if (area.equals("Y"))
	{
%>
		<IMG SRC="../../eCommon/images/enabled.gif" BORDER=0 ALT=""></IMG>
<%
	}
else 
	{
%>
		<IMG SRC="../../eCommon/images/RRnwd.gif" BORDER=0 ALT=""></IMG>
<%	}

	out.println("</td><td nowrap  class='" + classValue + "'>");
	out.println( rs.getString("LOCN_IDENTITY") );

	out.println("</td><td nowrap  class='" + classValue + "'>");
	out.println( holder_name);
	out.println("</td><td nowrap  class='" + classValue + "'>");
	out.println( holder_phone_no);
	out.println("</td><td nowrap align='center' class='" + classValue + "'>");	
	
	if (eff.equals("E"))
	{
%>
		<IMG SRC="../../eCommon/images/enabled.gif" BORDER=0 ALT=""></IMG>
<%
	}
else 
	{
%>
		<IMG SRC="../../eCommon/images/RRnwd.gif" BORDER=0 ALT=""></IMG>
<%	}
	out.println("</td></tr>");

	i++;
	loccount++;

  } //endwhile

	 if (loccount == 0)
	  {
	  %>
	  	<script>
		alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));
		parent.frames[1]. location.href ="../../eFM/jsp/FMFileStorageLocnQueryCriteria.jsp" ;
		</script>
	 <%
	  }

  if (!rs.next())
  {
    endOfRes = "0";
	%>
		<script>
		//document.getElementById("nextval").innerHTML=" ";
		document.getElementById("nextval").style.visibility='hidden';
		</script>
<!-- 		<tr>
			<td class='labelcenter' colspan='10'><fmt:message key="Common.EndofResults.label" bundle="${common_labels}"/></td>
		</tr> -->
	</table>
	<%
  }
else
  { %>
	<script>
	document.getElementById("nextval").style.visibility='visible';
	</script>
 <% }

	if((sql != null) && (sql.length() >0))
	{
		sql.delete(0,sql.length());
	}
	if((strsql1 != null) && (strsql1.length() >0))
	{
		strsql1.delete(0,strsql1.length());
	}
	if((strsql2 != null) && (strsql2.length() >0))
	{
		strsql2.delete(0,strsql2.length());
	}

	if(rs   != null)	rs.close();
	if(stmt != null)	stmt.close();

}catch(Exception e){
		out.print(e.toString());
}
	finally   
	{
		ConnectionManager.returnConnection(conn,request);
	}
%>
</table>
</BODY>
</HTML>

