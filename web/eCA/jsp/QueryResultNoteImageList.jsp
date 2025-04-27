<!DOCTYPE html>
<%@ page import ="java.sql.*,java.io.*,java.net.*,webbeans.eCommon.ConnectionManager,webbeans.eCommon.*,javax.servlet.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<script src="../../eCommon/js/common.js" language="javascript"></script>
<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>

<HTML>
	<head>
	<!-- <link rel='stylesheet' type ='text/css'  href='../../eCommon/html/IeStyle.css'></link> -->

<%
request.setCharacterEncoding("UTF-8");
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<!-- Added by Arvind @ 08-12-08 -->
	
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />

</head>
<BODY class='CONTENT'  OnMouseDown='CodeArrest()' onKeyDown="lockKey()">
<%
Connection conn=null;
try
{
    
	String whereClause = request.getParameter("whereclause");
	if(whereClause==null) whereClause="";
    String from = request.getParameter( "from" ) ;
    String to = request.getParameter( "to" ) ;
    StringBuffer sql =new StringBuffer();
    String image_ref  = request.getParameter("image_ref");
	String imgExists="No";
	
	String  MstQryPageCnt = (((session.getAttribute("MstQryPageCnt") != null) && (session.getAttribute("MstQryPageCnt") != "")))?((String)session.getAttribute("MstQryPageCnt")) : "14";
    int pageCnt = Integer.parseInt(MstQryPageCnt);

	if(image_ref == null)
	{
		image_ref  = "";
	}
	else
	{
		image_ref = image_ref.toUpperCase();
	}
    
	String image_ref_desc = request.getParameter("image_ref_desc");
	if(image_ref_desc == null)
	{
		image_ref_desc = "";
	}
	else
	{
		image_ref_desc = image_ref_desc.toUpperCase();
	}

	String image_url = request.getParameter("image_url");
	if(image_url == null)
	{
		image_url = "";
	}
	else
	{
		image_url = image_url.toUpperCase();
	}
	
	String enabled = request.getParameter("enabled");
	if(enabled == null)
	{
		enabled = "";
	}
	else
	{
		enabled = enabled.toUpperCase();
	}
	
    if ( (whereClause == null || whereClause.equals("")) )
    {
			int cnt=0;
			if ( !(image_ref == null || image_ref.equals("")) )
			{
				sql.append(" where upper(image_ref ) like upper('"+image_ref +"%')");
				cnt++;
			}
			if ( !(image_ref_desc == null || image_ref_desc.equals("")) )
			{
				if(cnt>0)
					sql.append(" and upper(image_ref_desc) like '"+image_ref_desc+"%'");
				else
				{
					sql.append(" where upper(image_ref_desc) like '"+image_ref_desc+"%'");
					cnt=1;
				}
			}	
			if ( !(image_url == null || image_url.equals("")) )
			{
				if(cnt>0)
					sql.append(" and upper(image_url) like '"+image_url+"%'");
				else
				{
					sql.append(" where upper(image_url) like '"+image_url+"%'");
					cnt=1;
				}
			}	
			if ( !(enabled == null || enabled.equals("")) )
			{
			
				if( enabled.equals("E") )
				{
					if(cnt>0)
					   sql.append(" and eff_status='E'");
					else
					{
						sql.append(" where  eff_status='E'");
						cnt=1;
					}
				 }
				 if ( enabled.equals("D") )
				 {
					if(cnt>0)
					   sql.append(" and eff_status='D'");
					else
						sql.append("where eff_status='D'");
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

 conn  =  ConnectionManager.getConnection(request);

PreparedStatement stmt = null;
PreparedStatement stmt1 = null;
int maxRecord = 0;
ResultSet rset=null;
ResultSet rs = null;

	try{
		
		StringBuffer strsql=new StringBuffer();
		strsql.append("select count(*) as total from ca_note_image_list ");
		strsql.append(sql);
		StringBuffer strsql1=new StringBuffer();
strsql1.append("select image_ref, image_ref_desc, image_url,decode(objtype,null,'No','Yes'),eff_status from  ca_note_image_list");
		strsql1.append(sql);
		
		stmt = conn.prepareStatement(strsql.toString());
		rs = stmt.executeQuery();

		rs.next();
		maxRecord = rs.getInt("total");
		
		if(maxRecord == 0){
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','COMMON'));history.go(-1);</script>");
		}
		stmt1=conn.prepareStatement(strsql1.toString());
		rset = stmt1.executeQuery();
		
	}catch(Exception e){
		//out.println("sdfsadfs "+e);//COMMON-ICN-0181
		e.printStackTrace();//COMMON-ICN-0181
	}
%>
<P>
<table align='right'>
<tr>
<td>
<%
if ( !(start <= 1) )
    out.println("<A class='gridLink'  href='../../eCA/jsp/QueryResultNoteImageList.jsp?from="+(start-pageCnt)+"&to="+(end-pageCnt)+"&whereclause=" + URLEncoder.encode(sql.toString()) + "'" + " text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

if ( !( (start+pageCnt) > maxRecord ) )
    out.println("<A class='gridLink'  href='../../eCA/jsp/QueryResultNoteImageList.jsp?from="+(start+pageCnt)+"&to="+(end+pageCnt)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
%>
</td>
</tr>
</table>
<br>
</p>

<table class='grid' border="1" width="100%" cellspacing='0' cellpadding='3' align='center'>
<td class='COLUMNHEADERCENTER'><fmt:message key="eCA.ImageReferenceID.label" bundle="${ca_labels}"/></td>
<td class='COLUMNHEADERCENTER'><fmt:message key="Common.ImageDescription.label" bundle="${common_labels}"/></td>
<td class='COLUMNHEADERCENTER'><fmt:message key="Common.ImageURL.label" bundle="${common_labels}"/></td>
<td class='COLUMNHEADERCENTER'><fmt:message key="eCA.ImageExists?.label" bundle="${ca_labels}"/></td>
<td class='COLUMNHEADERCENTER'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td> 
<%
	if ( start != 1 )
	for( int j=1; j<start; i++,j++ )
	rset.next() ;
	String classValue= " ",status="";
	while ( rset.next() && i<=end  )
	{
		if ( i % 2 == 0 )
			classValue = "gridData" ;
		else
			classValue = "gridData" ;
		out.println("<tr><td class='" + classValue + "'>");
		image_ref = rset.getString(1)==null ? "" :  rset.getString(1);
		image_ref_desc = rset.getString(2)==null ? "" :  rset.getString(2);
		image_url = rset.getString(3)==null ? "" : rset.getString(3);
		imgExists = rset.getString(4)==null ? "No" : rset.getString(4);
		if(!imgExists.equals("Yes")){
			/*if(chkImgExists(image_ref,image_url)){			
				imgExists="Yes";
			}else{
				imgExists="No";
			}*/
			
			
				StringBuffer note_image_rep_folder	= new StringBuffer();
				String path	="";
				//String docType="";
				String strFileSep="";

				java.util.Properties pFileSep	= null;
				path					= config.getServletContext().getRealPath("/"); 
				note_image_rep_folder.append(path);
				pFileSep	= System.getProperties();
				strFileSep	= (String) pFileSep.getProperty("file.separator");
				note_image_rep_folder.append("eCA");
				note_image_rep_folder.append(strFileSep);
				note_image_rep_folder.append("MediPainter");
				note_image_rep_folder.append(strFileSep);
				note_image_rep_folder.append("images");
				note_image_rep_folder.append(strFileSep);
				note_image_rep_folder.append(image_url);
				String filename			=	note_image_rep_folder.toString();
				File file = null;
				try{
					file = new File(filename);
					if(file.exists()){
						imgExists="Yes";		
					}else{
						imgExists="No";
					}
					if(file!=null) file=null;
				}catch(Exception e){
					
					e.printStackTrace();
				}
			
			
			
		}
		status = rset.getString(5)==null ? "" : rset.getString(5);
		String img =""; 
		if(status.equals("E"))
		{
			img = "<img src='../../eCommon/images/enabled.gif'></img>";
		}
		else
		{
			img = "<img src='../../eCommon/images/disabled.gif'></img>";
		}
		out.println("<a class='gridLink'  href='../../eCA/jsp/AddModifyNoteImageList.jsp?image_ref="+ image_ref+"&image_ref_desc="+image_ref_desc+"&image_url="+image_url+"&imgExists="+imgExists+"&eff_status="+rset.getString(5)+"' >");
		out.println(image_ref+"</a></td>");
		out.println("<td class='" + classValue + "'>");
		out.println( image_ref_desc );
		out.println("</td>");
		out.println("<td class='" + classValue + "'>");
		out.println( image_url );
		out.println("</td>");
		out.println("<td class='" + classValue + "'>");
		if(imgExists.equals("Yes"))
		out.println("<img src='../../eCommon/images/enabled.gif'></img>");
		else
		out.println("<img src='../../eCommon/images/disabled.gif'></img>");
		out.println("</td>");
	out.println("<td class='" + classValue + "'>");
		out.println(img);
		out.println("</td>");
		i++;
	} %>
</td></tr>
</table>
</center>
<br><center>
<%
		if(rs != null) rs.close();
		if(rset != null) rset.close();
		if(stmt != null) stmt.close();
		if(stmt1 != null) stmt1.close();

}
catch(Exception e)
{
	e.printStackTrace();
	//out.println("here "+e);//COMMON-ICN-0181
}
finally
{
	if(conn!=null) ConnectionManager.returnConnection(conn,request);

}%>
<%!
/*public boolean chkImgExists(String img_ref,String image_url) throws Exception{ //Weblogic Conversion
	boolean exists=false;
	StringBuffer note_image_rep_folder	= new StringBuffer();
	String path	="";
	//String docType="";
	String strFileSep="";

	java.util.Properties pFileSep	= null;
	path					= config.getServletContext().getRealPath("/"); //Weblogic Conversion
	note_image_rep_folder.append(path);
	pFileSep	= System.getProperties();
	strFileSep	= (String) pFileSep.getProperty("file.separator");
	note_image_rep_folder.append("eCA");
	note_image_rep_folder.append(strFileSep);
	note_image_rep_folder.append("MediPainter");
	note_image_rep_folder.append(strFileSep);
	note_image_rep_folder.append("images");
	note_image_rep_folder.append(strFileSep);
	note_image_rep_folder.append(image_url);
	String filename			=	note_image_rep_folder.toString();
	File file = null;
	try{
		file = new File(filename);
		if(file.exists()){
			exists=true;			
		}else{
			exists=false;
		}
		if(file!=null) file=null;
	}catch(Exception e){
		
		e.printStackTrace();
	}
	return exists;
}*/
%>



</center>
</BODY>
</HTML>

