<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*"  contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<%  
	request.setCharacterEncoding("UTF-8"); 
	String sStyle	= 
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

	out.println("<HTML><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></head><BODY  class='CONTENT' onLoad='parent.commontoolbarFrame.document.forms[0].reset.disabled=true;' onMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>");

	String whereClause		= request.getParameter("whereclause");
	StringBuffer sql=new StringBuffer();
	String from 			= request.getParameter("from") ;
	String to 				= request.getParameter("to") ;
	String facility_id		= (String)session.getValue("facility_id");
	String locale = (String)session.getAttribute("LOCALE");
	if ( (whereClause == null || whereClause.equals("")) )
	{ 
		String pat_ser_grp_code		= request.getParameter("pat_ser_grp_code");
		String pat_ser_grp_desc		= request.getParameter("pat_ser_grp_desc");
		String blng_grp_id= request.getParameter("blng_grp_id");
		String blng_grp_desc = request.getParameter("blng_grp_desc");
		String payer_grp_code = request.getParameter("payer_grp_code");
		String payer_grp_desc = request.getParameter("payer_grp_desc");
		String payer_code = request.getParameter("payer_code");
		String payer_desc = request.getParameter("payer_desc");
		String serv_panel_ind = request.getParameter("serv_panel_ind");
		String serv_panel_code = request.getParameter("serv_panel_code");
		String serv_panel_desc = request.getParameter("serv_panel_desc");
		//Added V190405-MuthuKN/AMRI-CRF-0357.1
		String renewal_code = request.getParameter("renewal_code");
		String renewal_desc = request.getParameter("renewal_desc");
		//Added V190405-MuthuKN/AMRI-CRF-0357.1
		int andCheck 				= 0;
		// Changing to Upper case and checking
		pat_ser_grp_code							= pat_ser_grp_code.toUpperCase();

		if( !(facility_id == null || facility_id.equals("")) )
		{
			sql.append(" where operating_facility_id='"+facility_id+"'   ");
			andCheck	=	1;
		}

		if( !(locale == null || locale.equals("")) )
		{
			sql.append(" and language_id='"+locale+"'   ");
			andCheck	=	1;
		}

		if ( !(pat_ser_grp_code== null || pat_ser_grp_code.equals("")) )
		{
			if(andCheck == 1)
			{
				sql.append(" and pat_ser_grp_code like '"+pat_ser_grp_code+"%' ");
			}
			else
			{
				sql.append("where pat_ser_grp_code like '"+pat_ser_grp_code+"%' ");
				andCheck = 1;
			}
		}
		if ( !(pat_ser_grp_desc == null || pat_ser_grp_desc.equals("")) )
		{
			if ( andCheck == 1 )
			{
				sql.append(" and ");
				sql.append(" upper(pat_ser_grp_desc) like upper('"+pat_ser_grp_desc+"%')");
			}
			else
			{
				sql.append(" where upper(pat_ser_grp_desc) like upper('"+pat_ser_grp_desc+"%')");
				andCheck 	= 1;
			}
		}

		if ( !(blng_grp_id == null || blng_grp_id.equals("")) )
		{
			if ( andCheck == 1 )
			{
				sql.append(" and ");
				sql.append(" upper(BLNG_GRP_ID) like upper('"+blng_grp_id+"%')");
			}
			else
			{
				sql.append(" where upper(BLNG_GRP_ID) like upper('"+blng_grp_id+"%')");
				andCheck 	= 1;
			}
		}

		if ( !(blng_grp_desc == null || blng_grp_desc.equals("")) )
		{
			if ( andCheck == 1 )
			{
				sql.append(" and ");
				sql.append(" upper(BLNG_GRP_DESC) like upper('"+blng_grp_desc+"%')");
			}
			else
			{
				sql.append(" where upper(BLNG_GRP_DESC) like upper('"+blng_grp_desc+"%')");
				andCheck 	= 1;
			}
		}

		if ( !(payer_grp_code == null || payer_grp_code.equals("")) )
		{
			if ( andCheck == 1 )
			{
				sql.append(" and ");
				sql.append(" upper(PAYER_GRP_CODE) like upper('"+payer_grp_code+"%')");
			}
			else
			{
				sql.append(" where upper(PAYER_GRP_CODE) like upper('"+payer_grp_code+"%')");
				andCheck 	= 1;
			}
		}

		if ( !(payer_grp_desc == null || payer_grp_desc.equals("")) )
		{
			if ( andCheck == 1 )
			{
				sql.append(" and ");
				sql.append(" upper(PAYER_GRP_DESC) like upper('"+payer_grp_desc+"%')");
			}
			else
			{
				sql.append(" where upper(PAYER_GRP_DESC) like upper('"+payer_grp_desc+"%')");
				andCheck 	= 1;
			}
		}

		if ( !(payer_code == null || payer_code.equals("")) )
		{
			if ( andCheck == 1 )
			{
				sql.append(" and ");
				sql.append(" upper(PAYER_CODE) like upper('"+payer_code+"%')");
			}
			else
			{
				sql.append(" where upper(PAYER_CODE) like upper('"+payer_code+"%')");
				andCheck 	= 1;
			}
		}

		if ( !(payer_desc == null || payer_desc.equals("")) )
		{
			if ( andCheck == 1 )
			{
				sql.append(" and ");
				sql.append(" upper(PAYER_DESC) like upper('"+payer_desc+"%')");
			}
			else
			{
				sql.append(" where upper(PAYER_DESC) like upper('"+payer_desc+"%')");
				andCheck 	= 1;
			}
		}
		//Commented V190401-MuthuKumarN/IN70056 & IN:070057
		/* if ( !(serv_panel_ind == null || serv_panel_ind.equals("")) )
		{
			if ( andCheck == 1 )
			{
				sql.append(" and ");
				sql.append(" upper(SERV_PANEL_IND) like upper('"+serv_panel_ind+"%')");
			}
			else
			{
				sql.append(" where upper(SERV_PANEL_IND) like upper('"+serv_panel_ind+"%')");
				andCheck 	= 1;
			}
		} */

		if ( !(serv_panel_code == null || serv_panel_code.equals("")) )
		{
			if ( andCheck == 1 )
			{
				sql.append(" and ");
				sql.append(" upper(SERV_PANEL_CODE) like upper('"+serv_panel_code+"%')");
			}
			else
			{
				sql.append(" where upper(SERV_PANEL_CODE) like upper('"+serv_panel_code+"%')");
				andCheck 	= 1;
			}
		}

		if ( !(serv_panel_desc == null || serv_panel_desc.equals("")) )
		{
			if ( andCheck == 1 )
			{
				sql.append(" and ");
				sql.append(" upper(SERV_PANEL_DESC) like upper('"+serv_panel_desc+"%')");
			}
			else
			{
				sql.append(" where upper(SERV_PANEL_DESC) like upper('"+serv_panel_desc+"%')");
				andCheck 	= 1;
			}
		}

		//Added V190405-MuthuKN/AMRI-CRF-0357.1
		if ( !(renewal_code == null || renewal_code.equals("")) )
		{
			if ( andCheck == 1 )
			{
				sql.append(" and ");
				sql.append(" upper(REN_SERV_PANEL_CODE) like upper('"+renewal_code+"%')");
			}
			else
			{
				sql.append(" where upper(REN_SERV_PANEL_CODE) like upper('"+renewal_code+"%')");
				andCheck 	= 1;
			}
		}

		if ( !(renewal_desc == null || renewal_desc.equals("")) )
		{
			if ( andCheck == 1 )
			{
				sql.append(" and ");
				sql.append(" upper(REN_SERV_PANEL_DESC) like upper('"+renewal_desc+"%')");
			}
			else
			{
				sql.append(" where upper(REN_SERV_PANEL_DESC) like upper('"+renewal_desc+"%')");
				andCheck 	= 1;
			}
		}
		//Added V190405-MuthuKN/AMRI-CRF-0357.1
	
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
	{
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

	Connection con = null;
	PreparedStatement stmt=null;
	ResultSet rs=null;

	try
	{
		con =  ConnectionManager.getConnection(request);

		StringBuffer strsql2=new StringBuffer();
		strsql2.append("select * from BL_MP_PAT_REGN_DTLS_VW ");
		strsql2.append(sql.toString());
//		System.err.println("strsql2:"+strsql2);
		stmt = con.prepareStatement(strsql2.toString());
		rs = stmt.executeQuery();
		String classValue = "" ;
		int cnt=0;
		String endOfRes="1";
		if ( start != 1 )
		for( int j=1; j<start; i++,j++ )
		{
			rs.next() ;
		}

		while (i<=end && rs.next())
		{
			if(cnt==0)
			{
%>
<p>
	<table align='right'>
		<tr>
			<td>
<%
if ( !(start <= 1) )
	out.println("<A HREF='../../eBL/jsp/BLPatRegBlngDtlsQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

  if (endOfRes.equals("1"))
	out.println("<A id='nextvalue' HREF='../../eBL/jsp/BLPatRegBlngDtlsQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");

	%>
			</td>
		</tr>
	</table>
	</p>
	<br><br>
	<table border="1" width="100%" cellspacing='0' cellpadding='0'>
		<th width='5%'><fmt:message key="eMP.PatientSeriesCode.label" bundle="${mp_labels}"/></th>
		<th width='25%'><fmt:message key="eMP.PatientSerieDesc.label" bundle="${mp_labels}"/></th>
		<th width='5%'><fmt:message key="Common.BillingGroup.label" bundle="${common_labels}"/></th>
		<th width='25%'><fmt:message key="eBL.BLNG_GRP_DESC.label" bundle="${bl_labels}"/></th>
		<th width='5%'><fmt:message key="eBL.PAYER_GROUP_CODE.label" bundle="${bl_labels}"/></th>
		<th width='25%'><fmt:message key="eBL.PAYER_GROUP_DESC.label" bundle="${bl_labels}"/></th>
		<th width='5%'><fmt:message key="eBL.PAYER_CODE.label" bundle="${bl_labels}"/></th>
		<th width='25%'><fmt:message key="eBL.PAYER_DESC.label" bundle="${bl_labels}"/></th>
		<th width='5%'><fmt:message key="eBL.SERV_PANEL_CODE.label" bundle="${bl_labels}"/></th>
		<th width='25%'><fmt:message key="eBL.SERV_PANEL_DESC.label" bundle="${bl_labels}"/></th>
		<!-- Added V190405-MuthuKN/AMRI-CRF-0357.1 -->
		<th width='5%'><fmt:message key="eBL.REN_SERV_PANEL_CODE.label" bundle="${bl_labels}"/></th>
		<th width='25%'><fmt:message key="eBL.REN_SERV_PANEL_DESC.label" bundle="${bl_labels}"/></th>
		<!-- Added V190405-MuthuKN/AMRI-CRF-0357.1 -->
		<th width='25%'><fmt:message key="Common.Chargeable.label" bundle="${common_labels}"/></th>
		<th width='25%'><fmt:message key="eBL.CHRG_NON_CHRG_PAT_DUR_ENC.label" bundle="${bl_labels}"/></th>
		<th width='25%'><fmt:message key="eBL.CHRG_DUR_REW.label" bundle="${bl_labels}"/></th>

<%
			}
			if ( i % 2 == 0 )
		  		classValue = "QRYEVEN" ;
			else
		  		classValue = "QRYODD" ;

			String str_pat_ser_grp_code = rs.getString("pat_ser_grp_code");
			if(str_pat_ser_grp_code == null) str_pat_ser_grp_code = "&nbsp;";
			String pat_ser_grp_desc = rs.getString("pat_ser_grp_desc");
			if(pat_ser_grp_desc == null) pat_ser_grp_desc = "&nbsp;";
			String str_blng_grp_id = rs.getString("blng_grp_id");
			if(str_blng_grp_id == null) str_blng_grp_id = "&nbsp;";
			String str_blng_grp_desc = rs.getString("blng_grp_desc");
			if(str_blng_grp_desc == null) str_blng_grp_desc = "&nbsp;";
			if(str_blng_grp_id.equals("**"))
				str_blng_grp_desc = "All";
			String str_payer_grp_code = rs.getString("payer_grp_code");
			if(str_payer_grp_code == null) str_payer_grp_code = "&nbsp;";
			String str_payer_grp_desc = rs.getString("payer_grp_desc");
			if(str_payer_grp_desc == null) str_payer_grp_desc = "&nbsp;";
			if(str_payer_grp_code.equals("**"))
				str_payer_grp_desc = "All";
			String str_payer_code = rs.getString("payer_code");
			if(str_payer_code == null) str_payer_code = "&nbsp;";
			String str_payer_desc = rs.getString("payer_desc");
			if(str_payer_desc == null) str_payer_desc = "&nbsp;";
			if(str_payer_code.equals("**"))
				str_payer_desc = "All";
			String str_serv_panel_code = rs.getString("serv_panel_code");
			if(str_serv_panel_code == null) str_serv_panel_code = "&nbsp;";
			String str_serv_panel_desc = rs.getString("serv_panel_desc");
			if(str_serv_panel_desc == null) str_serv_panel_desc = "&nbsp;";
			//Added V190405-MuthuKN/AMRI-CRF-0357.1
			String str_renewal_code = rs.getString("ren_serv_panel_code");
			if(str_renewal_code == null) str_renewal_code = "&nbsp;";
			String str_renewal_desc = rs.getString("ren_serv_panel_desc");
			if(str_renewal_desc == null) str_renewal_desc = "&nbsp;";
			//Added V190405-MuthuKN/AMRI-CRF-0357.1

			out.println("<tr><td class='" + classValue + "'>");
			
			out.println("<a href='../../eBL/jsp/BLPatientRegnBillingDtlsFrame.jsp?mode=modify&pat_ser_grp_code="+str_pat_ser_grp_code+"&blng_grp_id="+str_blng_grp_id+"&payer_grp_code="+str_payer_grp_code+"&payer_code="+str_payer_code+"' target='PatRegBlngDtlsMainFrame' >");
			out.println(str_pat_ser_grp_code+"</a></td><td class='" + classValue + "'>");

			out.println(pat_ser_grp_desc+"</td><td class='" + classValue + "'>");

			out.println(str_blng_grp_id+"</a></td><td class='" + classValue + "'>");

			out.println(str_blng_grp_desc+"</td><td class='" + classValue + "'>");

			out.println(str_payer_grp_code+"</a></td><td class='" + classValue + "'>");

			out.println(str_payer_grp_desc+"</td><td class='" + classValue + "'>");

			out.println(str_payer_code+"</a></td><td class='" + classValue + "'>");

			out.println(str_payer_desc+"</td><td class='" + classValue + "'>");

			out.println(str_serv_panel_code+"</a></td><td class='" + classValue + "'>");

			out.println(str_serv_panel_desc+"</td><td class='" + classValue + "'>");
			
			//Added V190405-MuthuKN/AMRI-CRF-0357.1
			out.println(str_renewal_code+"</a></td><td class='" + classValue + "'>");

			out.println(str_renewal_desc+"</td><td class='" + classValue + "'>");
			//Added V190405-MuthuKN/AMRI-CRF-0357.1
		
			if ( rs.getString("charge_yn").equals("Y") )
				out.println("<img src='../../eCommon/images/enabled.gif'></img>");
			else
				out.println("<img src='../../eCommon/images/disabled.gif'></img>");
			out.println("</td><td align='center' class='" + classValue + "'>");
			
			if ( rs.getString("charge_at_enc_regn").equals("Y") )
				out.println("<img src='../../eCommon/images/enabled.gif'></img>");
			else
				out.println("<img src='../../eCommon/images/disabled.gif'></img>");
			out.println("</td><td align='center' class='" + classValue + "'>");
			
			if ( rs.getString("charge_pat_renew_yn").equals("Y") )
				out.println("<img src='../../eCommon/images/enabled.gif'></img>");
			else
				out.println("<img src='../../eCommon/images/disabled.gif'></img>");
			out.println("</td><td align='center' class='" + classValue + "'>");
System.err.println("str_serv_panel_desc:"+rs.getString("charge_pat_renew_yn"));
			i++;
			cnt++;
		}//endwhile
		if(cnt==0)
		out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','COMMON'));history.go(-1);</script>");
		if(!rs.next()&&cnt!=0)
		{
			endOfRes="0";
%>
	<script>
		document.getElementById("nextvalue").innerHTML=" ";
	</script>
<%
		}
 %>
		</td></tr>
</table>
<br><center>
</center>
<%
		sql.setLength(0);
		strsql2.setLength(0);
	
		if(rs!=null)	rs.close();
		if(stmt!=null)	stmt.close();
	}
	catch(Exception e)
	{
		//e.toString();
		//out.println(e.toString());
		e.printStackTrace();
	}
	finally   
	{
		if(con !=null)		 
			ConnectionManager.returnConnection(con,request);
	}
%>

</BODY>
</HTML>

