<!DOCTYPE html>

<!--
	
	Created on 		:	19/02/2005
	Module				:	eAM - Deficiency
	FileName		    :	TransportModeQueryResult.jsp	
	Function		:	This function is used to load query criteria screen for the function
-->
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script language="javascript" src="../js/FMFileTransportMode.js"></script>

<%
	out.println("<HTML><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></head><BODY  class='CONTENT' onLoad='' onMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>");
request.setCharacterEncoding("UTF-8");	
	String strsql2="";
	//String sql=" ";
		StringBuffer sbQuery = new StringBuffer();	
	//String strsql1=" ";

	String whereClause = request.getParameter("whereclause");

	Connection conn = null;
	conn = webbeans.eCommon.ConnectionManager.getConnection(request);

	Boolean isCnrmReqPatOutChngAppl	= eCommon.Common.CommonBean.isSiteSpecific(conn,"IP","AUTO_CNRM_TFR_REQ_PAT_OUT_CHNG");//Added by Thamizh selvi on 5th May 2017 for ML-MMOH-CRF-0617

	Boolean isMedRepModeAppl	= eCommon.Common.CommonBean.isSiteSpecific(conn,"MR","CHCKLST_TRANS_MODE_MED_REPORT");//Added By Ashwini on 21-Aug-2017 for ML-MMOH-CRF-0708

	String from = request.getParameter( "from" ) ;
	String to = request.getParameter( "to" ) ;
	int andCheck = 0;

	if ( (whereClause == null || whereClause.equals("")) )
	{
	//	sql=" ";
		String transport_mode		= request.getParameter("transport_mode");
		String long_desc			= request.getParameter("long_desc");
		String patient_related_yn   =
		request.getParameter("patient_related_yn");
		String file_related_yn   =
		request.getParameter("file_related_yn");		
		String specimen_related_yn   =
		request.getParameter("specimen_related_yn");
		String by_person_yn			= request.getParameter("by_person_yn");
		String enabled				= request.getParameter("eff_status");
		
		String tfr_pat_out_yn			= request.getParameter("tfr_pat_out_yn");//Added by Thamizh selvi on 5th May 2017 for ML-MMOH-CRF-0617
		
		//Added By Ashwini on 21-Aug-2017 for ML-MMOH-CRF-0708
		String application_mode			= request.getParameter("application_mode");
		String collection_mode			= request.getParameter("collection_mode");
		String notification_mode		= request.getParameter("notification_mode");
		

		if (!(transport_mode == null || transport_mode.equals("")) )
		{
			transport_mode=transport_mode.toUpperCase();
			sbQuery.append(" where transport_mode like '"+transport_mode+"%'");
			andCheck = 1;
		} 
	
		if(!(long_desc == null || long_desc.equals("")) )
		{
			if ( andCheck == 1 )
			{	
				sbQuery.append(" and ");
				sbQuery.append("upper(long_desc) like  upper('"+long_desc+"%')");
			}
			else
			{
				sbQuery.setLength(0);
				sbQuery.append("where upper(long_desc) like  upper('"+long_desc+"%')");
				andCheck = 1;
			}
		}
		if ( !(patient_related_yn == null || patient_related_yn.equals("")) )
		{
			if ( patient_related_yn.equals("Y") )
		    {
				if ( andCheck == 0 )
				{	
					sbQuery.setLength(0);
					sbQuery.append("where patient_related_yn='Y'");
					andCheck = 1;}
		
				else
					sbQuery.append(" and patient_related_yn='Y'  ");
			}
			if ( patient_related_yn.equals("N") )
			{
				if ( andCheck == 0 )
				{
					sbQuery.setLength(0);
					sbQuery.append(" where  patient_related_yn='N'");
					andCheck = 1;
					}
				else
					sbQuery.append(" and patient_related_yn='N'");
			}
		}

		 if ( !(file_related_yn == null || file_related_yn.equals("")) )
		{
			if ( file_related_yn.equals("Y") )
		    {
				if ( andCheck == 0 )
				{
					sbQuery.setLength(0);
					sbQuery.append(	"where file_related_yn='Y'");
					andCheck = 1;}
		
				else
					sbQuery.append(	" and file_related_yn='Y'  ");
			}
			if ( file_related_yn.equals("N") )
			{
				if ( andCheck == 0 )
				{
					sbQuery.setLength(0);
					sbQuery.append(" where  file_related_yn='N'");
					andCheck = 1;}
				else
					sbQuery.append(" and file_related_yn='N'");
			}
		}
		if ( !(specimen_related_yn == null || specimen_related_yn.equals("")) )
		{
			if ( specimen_related_yn.equals("Y") )
		    {
				if ( andCheck == 0 )
				{
					sbQuery.setLength(0);
					sbQuery.append(	"where specimen_related_yn='Y'");
					andCheck = 1;}
		
				else
					sbQuery.append(" and specimen_related_yn='Y'  ");
			}
			if ( specimen_related_yn.equals("N") )
			{
				if ( andCheck == 0 )
				{
					sbQuery.setLength(0);
					sbQuery.append(" where  specimen_related_yn='N'");
					andCheck = 1;}
				else
					sbQuery.append(" and specimen_related_yn='N'");
			}
		}

		if ( !(by_person_yn == null || by_person_yn.equals("")) )
		{
			if ( by_person_yn.equals("Y") )
		    {
				if ( andCheck == 0 )
				{
					sbQuery.setLength(0);
					sbQuery.append("where by_person_yn='Y'");
					andCheck = 1;}
		
				else
						sbQuery.append(" and by_person_yn='Y'  ");
			}
			if ( by_person_yn.equals("N") )
			{
				if ( andCheck == 0 )
				{
					sbQuery.setLength(0);
					sbQuery.append("where  by_person_yn='N'");
					andCheck = 1;}
				else
					sbQuery.append("and by_person_yn='N'");
			}
		}
		
		/*Added by Thamizh selvi on 5th May 2017 for ML-MMOH-CRF-0617 Start*/
		if(isCnrmReqPatOutChngAppl)
		{
			if ( !(tfr_pat_out_yn == null || tfr_pat_out_yn.equals("")) )
			{
				if ( tfr_pat_out_yn.equals("Y") )
				{
					if ( andCheck == 0 )
					{
						sbQuery.setLength(0);
						sbQuery.append("where ip_tfr_pat_out_yn='Y'");
						andCheck = 1;}
			
					else
							sbQuery.append(" and ip_tfr_pat_out_yn='Y'  ");
				}
				if ( tfr_pat_out_yn.equals("N") )
				{
					if ( andCheck == 0 )
					{
						sbQuery.setLength(0);
						sbQuery.append("where  ip_tfr_pat_out_yn='N'");
						andCheck = 1;}
					else
						sbQuery.append("and ip_tfr_pat_out_yn='N'");
				}
			}
		}/*End*/

		/*Added By Ashwini on 21-Aug-2017 for ML-MMOH-CRF-0708*/
		if(isMedRepModeAppl)
		{
			if ( !(application_mode == null || application_mode.equals("")) )
			{
				if ( application_mode.equals("Y") )
				{
					if ( andCheck == 0 )
					{
						sbQuery.setLength(0);
						sbQuery.append("where application_mode='Y'");
						andCheck = 1;}
			
					else
							sbQuery.append(" and application_mode='Y'  ");
				}
				if ( application_mode.equals("N") )
				{
					if ( andCheck == 0 )
					{
						sbQuery.setLength(0);
						sbQuery.append("where  application_mode='N'");
						andCheck = 1;}
					else
						sbQuery.append("and application_mode='N'");
				}
			}

			if ( !(collection_mode == null || collection_mode.equals("")) )
			{
				if ( collection_mode.equals("Y") )
				{
					if ( andCheck == 0 )
					{
						sbQuery.setLength(0);
						sbQuery.append("where collection_mode='Y'");
						andCheck = 1;}
			
					else
							sbQuery.append(" and collection_mode='Y'  ");
				}
				if ( collection_mode.equals("N") )
				{
					if ( andCheck == 0 )
					{
						sbQuery.setLength(0);
						sbQuery.append("where  collection_mode='N'");
						andCheck = 1;}
					else
						sbQuery.append("and collection_mode='N'");
				}
			}

			if ( !(notification_mode == null || notification_mode.equals("")) )
			{
				if ( notification_mode.equals("Y") )
				{
					if ( andCheck == 0 )
					{
						sbQuery.setLength(0);
						sbQuery.append("where notification_mode='Y'");
						andCheck = 1;}
			
					else
							sbQuery.append(" and notification_mode='Y'  ");
				}
				if ( notification_mode.equals("N") )
				{
					if ( andCheck == 0 )
					{
						sbQuery.setLength(0);
						sbQuery.append("where  notification_mode='N'");
						andCheck = 1;}
					else
						sbQuery.append("and notification_mode='N'");
				}
			}
		}/*ML-MMOH-CRF-0708 End*/

		if ( !(enabled == null || enabled.equals("")) )
		{
			if ( enabled.equals("E") )
		    {
				if ( andCheck == 0 )
				{
					sbQuery.setLength(0);
					sbQuery.append("where eff_status='E'");
					andCheck = 1;}
		
				else
					sbQuery.append(" and eff_status='E'  ");
			}
			if ( enabled.equals("D") )
			{
				if ( andCheck == 0 )
				{
					sbQuery.setLength(0);
					sbQuery.append(" where  eff_status='D'");

					andCheck = 1;}
				else
					sbQuery.append(" and eff_status='D'");
			}
		}
		String ord[] = request.getParameterValues("orderbycolumns");
		if ( !(ord == null || ord .equals("")) )
		{
			sbQuery.append(" order by ");

			for ( int i=0;i < ord.length;i++ )
			{
			if ( i == ord.length - 1 )
				sbQuery.append(ord[i]);
			else
				sbQuery.append(ord[i]+",");
			}

		}


	}// end if whereClause
	else 
	{
		sbQuery.setLength(0);
		sbQuery.append(whereClause);
		//sql = whereClause;

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

	
	Statement stmt=null;
	ResultSet rs=null;
	int maxRecord = 0;

	try
	{


		
		stmt = conn.createStatement();
	

		strsql2="select transport_mode, long_desc, short_desc,patient_related_yn,file_related_yn,specimen_related_yn,by_person_yn, ip_tfr_pat_out_yn, application_mode, collection_mode, notification_mode, eff_status from am_transport_mode "+  sbQuery.toString();
		if(rs!=null)rs.close();
		
		rs = stmt.executeQuery(strsql2);

		if ( start != 1 )

		for( int j=1; j<start; i++,j++ )
		{
		  rs.next() ;
		}

		while ( i<=end && rs.next() )
		{
			if(maxRecord==0)
			{

%>

	<P>
	<table align='right'>
	<tr>
	<%
	if ( !(start <= 1) )
	out.println("<td align ='right' id='prev'><A HREF='../jsp/TransportModeQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sbQuery.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");

	//if ( !( (start+14) > maxRecord ) )
	out.println("<td align ='right' id='next' style='visibility:hidden'><A HREF='../jsp/TransportModeQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sbQuery.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A></td>");
	%>
	</tr>
	</table>
	<br><br>
	</P>

	<table border="1" width="100%" cellspacing='0' cellpadding='0'>
	<th class='columnheader'><fmt:message key="Common.FileTransportMode.label" bundle="${common_labels}"/></th>
	<th class='columnheader'><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></th>
	<th class='columnheader'><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></th>
	<th class='columnheader'><fmt:message key="eAM.PatientRelated.label" bundle="${am_labels}"/></th>
	<th class='columnheader'><fmt:message key="eAM.FileRelated.label" bundle="${am_labels}"/></th>
	<th class='columnheader'><fmt:message key="eAM.SpecimenRelated.label" bundle="${am_labels}"/></th>
	<th class='columnheader'><fmt:message key="eAM.ByPerson.label" bundle="${am_labels}"/></th>
	
	<% if(isCnrmReqPatOutChngAppl){ %>
	<th class='columnheader'><fmt:message key="eAM.TfrPatientOut.label" bundle="${am_labels}"/></th><!--Added by Thamizh selvi on 5th May 2017 for ML-MMOH-CRF-0617-->
	<% } %>
	
	<!--Added By Ashwini on 21-Aug-2017 for	ML-MMOH-CRF-0708-->
	<% if(isMedRepModeAppl){ %>
	<th class='columnheader'><fmt:message key="Common.ApplicationMode.label" bundle="${common_labels}"/></th>
	<th class='columnheader'><fmt:message key="Common.CollectionMode.label" bundle="${common_labels}"/></th>
	<th class='columnheader'><fmt:message key="Common.NotificationMode.label" bundle="${common_labels}"/></th>
	<% } %>

	<th class='columnheader'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>

	<% }
		

		String classValue = "" ;
			if ( i % 2 == 0 )
				classValue = "QRYEVEN" ;
			else
				classValue = "QRYODD" ;

			String transport_mode	=	rs.getString("transport_mode");
			String long_desc		=	rs.getString("long_desc");
			String short_desc		=	rs.getString("short_desc");
			String patient_related_yn = rs.getString("patient_related_yn");
			String file_related_yn = rs.getString("file_related_yn");
			String specimen_related_yn = rs.getString("specimen_related_yn");
			String by_person_yn		=	rs.getString("by_person_yn");
			String tfr_pat_out_yn		=	rs.getString("ip_tfr_pat_out_yn");//Added by Thamizh selvi on 5th May 2017 for ML-MMOH-CRF-0617
			String eff_status		=	rs.getString("eff_status");

			//Added By Ashwini on 21-Aug-2017 for ML-MMOH-CRF-0708
			String application_mode		=	rs.getString("application_mode");
			String collection_mode		=	rs.getString("collection_mode");
			String notification_mode	=	rs.getString("notification_mode");

			if(transport_mode==null || transport_mode.equals("null")) transport_mode="&nbsp;";
			if(long_desc==null || long_desc.equals("null")) long_desc="&nbsp;";
			if(short_desc==null || short_desc.equals("null")) short_desc="&nbsp;";
			
			
			out.println("<tr><td align='left' class='" + classValue + "'>");
			out.println("<a href='../jsp/TransportModeAddModify.jsp?transport_mode="+transport_mode+ "&target=f_query_add_mod&operation=modify'>");
			out.println(transport_mode+"</a></td><td class='" + classValue + "' >");
			out.println(long_desc);
			out.println("<td class='" + classValue + "' >");
			out.println(short_desc);
			out.println("</td><td class='" + classValue + "' align='center'>");
			if (patient_related_yn.equals("Y") )
				out.println("<img src='../../eCommon/images/enabled.gif'></img>");
			else
				out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
			
			out.println("</td><td class='" + classValue + "' align='center'>");
			if (file_related_yn.equals("Y") )
				out.println("<img src='../../eCommon/images/enabled.gif'></img>");
			else
				out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
		   out.println("</td><td class='" + classValue + "' align='center'>");
			if (specimen_related_yn.equals("Y") )
				out.println("<img src='../../eCommon/images/enabled.gif'></img>");
			else
				out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
		
			out.println("</td><td class='" + classValue + "' align='center'>");
			if (by_person_yn.equals("Y") )
				out.println("<img src='../../eCommon/images/enabled.gif'></img>");
			else
				out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");

			/*Added by Thamizh selvi on 5th May 2017 for ML-MMOH-CRF-0617 Start*/
			if(isCnrmReqPatOutChngAppl)
			{
				out.println("</td><td class='" + classValue + "' align='center'>");
				if (tfr_pat_out_yn.equals("Y") )
					out.println("<img src='../../eCommon/images/enabled.gif'></img>");
				else
					out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
			}/*End*/

			/*Added By Ashwini on 21-Aug-2017 for ML-MMOH-CRF-0708*/
			if(isMedRepModeAppl)
			{
				out.println("</td><td class='" + classValue + "' align='center'>");
				if (application_mode.equals("Y") )
					out.println("<img src='../../eCommon/images/enabled.gif'></img>");
				else
					out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");

				out.println("</td><td class='" + classValue + "' align='center'>");
				if (collection_mode.equals("Y") )
					out.println("<img src='../../eCommon/images/enabled.gif'></img>");
				else
					out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");

				out.println("</td><td class='" + classValue + "' align='center'>");
				if (notification_mode.equals("Y") )
					out.println("<img src='../../eCommon/images/enabled.gif'></img>");
				else
					out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
			}/*ML-MMOH-CRF-0708 End*/
			
			out.println("</td><td class='" + classValue + "' align='center'>");
			if (eff_status.equals("E") )
				out.println("<img src='../../eCommon/images/enabled.gif'></img>");
			else
				out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");

			out.println("</td></tr>");	
			i++;
			maxRecord++;
		}//endwhile

		if(maxRecord == 0)
{%>
	<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>
<%}

if ( maxRecord < 14 || (!rs.next()) ) {
%>
	<script >
	if (document.getElementById('next'))
		document.getElementById('next').style.visibility='hidden';
	</script>
<% 
		} else {%>
	<script >
	if (document.getElementById('next'))
		document.getElementById('next').style.visibility='visible';
	</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



<%}

		if(rs!=null) rs.close();
		if(stmt!=null)
		stmt.close();

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
<br>
</BODY>
</HTML>

