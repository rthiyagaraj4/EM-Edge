<!DOCTYPE html>
<%@ page import ="webbeans.eCommon.*,java.sql.*,java.util.*,java.net.*,java.text.*"  contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
<%
	request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";


	out.println("<HTML><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></head><BODY  class='CONTENT' OnMouseDown='CodeArrest()' onKeyDown = 'lockKey();'>");
	
	String whereClause	= request.getParameter("whereclause");
	String facilityId	= (String) session.getValue( "facility_id" ) ;
	
	String from = request.getParameter( "from" ) ;
	String to   = request.getParameter( "to" ) ;

	StringBuffer sql	 = null;
	StringBuffer strsql1 = null;
	StringBuffer strsql2 = null;
	sql					 = new StringBuffer();
	strsql1				 = new StringBuffer();
	strsql2				 = new StringBuffer();
	
	int andCheck = 0;

	if(facilityId==null) facilityId = "";

	if ((whereClause == null || whereClause.equals("")))
	{
		String fs_locn_code			= request.getParameter("fs_locn_code");
		String fs_locn_short_desc   = request.getParameter("fs_locn_short_desc");
		String file_type_code		= request.getParameter("file_type_code");
		String file_type_short_desc = request.getParameter("file_type_short_desc");
		String enabled				= request.getParameter("eff_status");
	
		fs_locn_code	= fs_locn_code.toUpperCase(); 
		file_type_code	= file_type_code.toUpperCase();

		sql.append(" where facility_id = '"+facilityId+"' ");

     	andCheck		= 1;

		if(!(fs_locn_code == null || fs_locn_code.equals("")))
		{
			if (andCheck == 1)
			{
				sql.append(" and ");
				sql.append(" upper(fs_locn_code) like upper('"+fs_locn_code+"%') ");
				andCheck = 1;							
			}
			else
			{
				sql.append(" where upper(fs_locn_code) like upper('"+fs_locn_code+"%') ");
				andCheck = 1;
			}
		}
		if(!(fs_locn_short_desc == null || fs_locn_short_desc.equals(""))) 
		{
			if(andCheck == 1)
			{
				sql.append(" and ");
				sql.append("upper(fs_locn_short_desc) like  upper('"+fs_locn_short_desc+"%') ") ;
			}
			else
			{
				sql.append(" where upper(fs_locn_short_desc) like upper('"+fs_locn_short_desc+"%') ") ;
				andCheck = 1;
			}
		 }
		 if(!(file_type_code == null || file_type_code.equals(""))) 
		 {
			 if(andCheck == 1)
			 {
				 sql.append(" and ");
				 sql.append(" upper(file_type_code) like  upper('"+file_type_code+"%') ");
			 }
			 else
			 {
				 sql.append(" where upper(file_type_code) like upper('"+file_type_code+"%') ");
				 andCheck = 1;
			 }
		 }
		 if(!(file_type_short_desc == null || file_type_short_desc.equals("")))
		 {
			 if ( andCheck == 1 )
			 {
				 sql.append(" and ");
				 sql.append(" upper(file_type_short_desc) like  upper('"+file_type_short_desc+"%') ");
			 }
			 else
			 {
				 sql.append(" where upper(file_type_short_desc) like upper('"+file_type_short_desc+"%') ");
				 andCheck = 1;
			 }
		 }
		 if(!(enabled == null || enabled.equals("")))
		 {
			 if(enabled.equals("E"))
			  {
				  if(andCheck == 0)
				  {
					  sql.append(" where eff_status='E' ");
					  andCheck = 1; 
				  }
				  else
				  sql.append(" and eff_status='E' ");
			   }
			   if (enabled.equals("D"))
			   {
				   if(andCheck == 0 )
				   {
					   sql.append(" where eff_status='D' ");
					   andCheck = 1; 
			        }
			        else
				      sql.append(" and eff_status='D' ");
		        }
		   }
		   String ord[] = request.getParameterValues("orderbycolumns");
		   if(!(ord == null || ord .equals("")))
		   {
					sql.append(" order by ");

					for(int i=0;i < ord.length;i++)
			 		{
						if(i == ord.length - 1)
						{
							sql.append(ord[i]);
						}
						else
						{
							sql.append(ord[i]);
							sql.append(" , ");
						}
					}
				}			
		   }
		   else
		   {
			   sql.append(whereClause);
		   }
		   int start = 0;
		   int end	 = 0;
		   int i	 = 1;
		   if(from == null)
				start = 1;
			else
				start = Integer.parseInt(from);
			if (to == null)
	  			end = 14;
			else
				end = Integer.parseInt(to);

			Connection conn			= null;
			java.sql.Statement stmt	= null;
			ResultSet rset			= null;
			ResultSet rs			= null;

//			int maxRecord	= 0;

			try
			{
				conn = ConnectionManager.getConnection(request) ;
				stmt = conn.createStatement();
		
				/*strsql1.append(" select count(*) as total from FM_FILE_TYPE_FOR_FSL_VW  ");
				strsql1.append(sql);
				rs			   = stmt.executeQuery(strsql1.toString());
				rs.next();
				maxRecord = rs.getInt("total");
				if(rs	!= null) rs.close();
				if(maxRecord == 0)
				{
					out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));parent.frames[1].location.href ='../../eFM/jsp/FMFileTypeforFSLocnCriteria.jsp';</script>");
				}
				else
				{*/
					strsql2.append(" select  FS_LOCN_CODE, FS_LOCN_SHORT_DESC,EFF_STATUS,FILE_TYPE_CODE,FILE_TYPE_SHORT_DESC from FM_FILE_TYPE_FOR_FSL_VW  ");
					strsql2.append(sql);
							
					rs = stmt.executeQuery(strsql2.toString());
%>
					
<%
						if ( start != 1 )
						 for( int j=1; j<start; i++,j++ )
						 {
							rs.next() ;
						 }
						 String classValue = "" ;
						 int cnt=0;
						 while ( i<=end && rs.next())
						 {
							 if(cnt==0)
							 {%>
								<P><table align='right'>
								<tr>
		<%
										if ( !(start <= 1) )
											out.println("<td align ='right' id='prev'><A HREF=\"../jsp/FMFileTypeforFSLocnQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql.toString())+"\""+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");
											%>
												<td align ='right' id='next' style='visibility:hidden'>
											<%
										//if ( !( (start+14) > maxRecord ) )
											out.println("<A HREF=\"../jsp/FMFileTypeforFSLocnQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql.toString())+"\""+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
		%>
								</td></tr>
							</table></P>
							<br><br>
							<table border="1" width="100%" cellspacing='0' cellpadding='0'>
								<td class='COLUMNHEADER'><fmt:message key="Common.FileStorageLocation.label" bundle="${common_labels}"/></td>
								<td class='COLUMNHEADER'><fmt:message key="eFM.FileStorageLocationDesc.label" bundle="${fm_labels}"/></td>
								<td class='COLUMNHEADER'><fmt:message key="Common.filetype.label" bundle="${common_labels}"/></td>
								<td class='COLUMNHEADER'><fmt:message key="Common.FileTypeDescription.label" bundle="${common_labels}"/></td>
								<td class='COLUMNHEADER'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
<%							 }
							 if ( i % 2 == 0 )
								 classValue = "QRYEVEN" ;
							else
								classValue = "QRYODD" ;
							
							String fs_locn_code1		= rs.getString("FS_LOCN_CODE");
							String fs_locn_short_desc1  = rs.getString("FS_LOCN_SHORT_DESC");
							String effstatus			= rs.getString("EFF_STATUS");
							String file_type_code1		= rs.getString("FILE_TYPE_CODE");
							String file_type_short_desc = rs.getString("FILE_TYPE_SHORT_DESC");
							
						
							out.println("<tr><td class='" + classValue + "'>");
							out.println(fs_locn_code1+"</td><td class='" + classValue + "'>");
							out.println(fs_locn_short_desc1+"</td><td class='" + classValue + "'>");
							out.println(file_type_code1+"</td><td  class='" + classValue + "'>");
							out.println(file_type_short_desc+"</td><td align='center' class='" + classValue + "'>");
							if(effstatus.equals("E")) 
									out.println("<img src='../../eCommon/images/enabled.gif'></img>");
							else
								out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
							i++;
							cnt++;
						 }
						 if (cnt==0)
						{
							out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>");
						}
						boolean flag = false;
						if ( cnt < 14 || (!rs.next()) ) {
						%>
							<Script src="../../eCommon/js/showModalDialog.js" language="JavaScript"></Script><script >
							if (document.getElementById('next'))
								document.getElementById('next').style.visibility='hidden';
							</script>
						<% flag = true;
								} else {%>
							<script >
							if (document.getElementById('next'))
								document.getElementById('next').style.visibility='visible';
							</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



						<%}
				//	}//endwhile

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

					if(rs	!= null) rs.close();
					if(rset	!= null) rset.close();
					if(stmt	!= null) stmt.close();
				}
				catch(Exception e)
				{
					out.println(e.toString());
				}
				finally
				{
					ConnectionManager.returnConnection(conn,request); 
				}
%>
			</td></tr>
		</table>
	</BODY>
</HTML>

