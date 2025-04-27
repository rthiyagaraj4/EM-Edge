<!DOCTYPE html>
<%@ page import ="java.sql.*, java.util.*,java.net.*, webbeans.eCommon.ConnectionManager"  contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
		<%
		request.setCharacterEncoding("UTF-8");	
		String sStyle =			(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		%>
		<!-- <modifeid by Archana  @08-12-2008> -->
        
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />

		<!-- <link rel='stylesheet' type ='text/css'  href='../../eCommon/html/IeStyle.css'></link> -->
		<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
		<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	
<body class='CONTENT'  OnMouseDown='CodeArrest()' onKeyDown="lockKey()">

<form name='CAExternalApplDtlResultForm' id='CAExternalApplDtlResultForm'>

	<%
		Connection con			=	null ;
		
		String whereClause		=	"";
		String mode		=	"";
		
		String ext_image_appl_id = "";
		String order_category = "";
		String order_type_code = "";
		String order_catalog_code = "";
		String eff_status = "";
		String ext_image_appl_name = "";
		String or_order_category_desc = "";
		String order_type_desc = "";
		String order_catalog_desc = "";
		String facility_name = "";
		String facility_id = "";
		//Modified by Archana @10-12-2008
		String  MstQryPageCnt = (((session.getAttribute("MstQryPageCnt") != null) && (session.getAttribute("MstQryPageCnt") != "")))?((String)session.getAttribute("MstQryPageCnt")) : "14";
        int pageCnt = Integer.parseInt(MstQryPageCnt);

		StringBuffer strsql = new StringBuffer();
		StringBuffer sql = new StringBuffer();
		StringBuffer strsqll = new StringBuffer();

		PreparedStatement pstmt =null;
		PreparedStatement pstmt1 =null;
		int maxRecord =	 0;
		ResultSet rset=null;
		ResultSet rs = null;

		try	{
		mode="modify";
		whereClause= request.getParameter("whereclause");
		if(whereClause==null) whereClause="";

		String from = request.getParameter( "from" ) ;
		String to = request.getParameter( "to" ) ;

		ext_image_appl_id = request.getParameter("ext_image_appl_id")==null?"":request.getParameter("ext_image_appl_id");
		order_category = request.getParameter("order_category")==null?"":request.getParameter("order_category");
		order_type_code = request.getParameter("order_type_code")==null?"":request.getParameter("order_type_code");
		order_catalog_code = request.getParameter("order_catalog_code")==null?"":request.getParameter("order_catalog_code");
		eff_status=request.getParameter("eff_status")==null?"":request.getParameter("eff_status");
		facility_id=request.getParameter("facility_id")==null?"":request.getParameter("facility_id");
		
		if ((whereClause == null || whereClause.equals("null") || whereClause.equals("")))
		{
				int cnt=0;
				if(!(ext_image_appl_id == null || ext_image_appl_id.equals("null") || ext_image_appl_id.equals("")))
				{
					sql.append(" where upper(ext_image_appl_id) like upper('"+ext_image_appl_id+"%') ");
					cnt++;
				}
				
				if(!(order_category == null  || order_category.equals("null") || order_category.equals("")))
				{
					if(cnt>0)
					{
						sql.append("and upper(order_category) like upper('"+order_category+"%')");
					}
					else
					{
						sql.append(" where upper(order_category) like  upper('"+order_category+"%')");
						cnt = 1;
					}
				}
				
				if(!(order_type_code == null  || order_type_code.equals("null") || order_type_code.equals("")))
				{
					if(cnt>0)
					{
						sql.append("and upper(order_type_code) like upper('"+order_type_code+"%')");
					}
					else
					{
						sql.append(" where upper(order_type_code) like  upper('"+order_type_code+"%')");
						cnt = 1;
					}
				}

				if(!(facility_id == null  || facility_id.equals("null") || facility_id.equals("")))
				{
					if(cnt>0)
					{
						sql.append("and upper(facility_id) like upper('"+facility_id+"%')");
					}
					else
					{
						sql.append(" where upper(facility_id) like  upper('"+facility_id+"%')");
						cnt = 1;
					}
				}

				 if(!(order_catalog_code == null  || order_catalog_code.equals("null") || order_catalog_code.equals("")))
				{
					if(cnt>0)
					{
						sql.append("and upper(order_catalog_code) like upper('"+order_catalog_code+"%')");
					}
					else
					{
						sql.append(" where upper(order_catalog_code) like  upper('"+order_catalog_code+"%')");
						cnt = 1;
					}
				}

				if (!(eff_status == null || eff_status.equals("null") || eff_status.equals("")))
				{
					if( eff_status.equals("E"))
					{
						if(cnt>0)
						{
							sql.append(" and eff_status='Y'");
						}
						else
						{
							sql.append(" where eff_status='Y'");
						}
					}
					if (eff_status.equals("D"))
					{
						if(cnt>0)
						{
							sql.append(" and eff_status='N'");
						}	
						else
						{
							sql.append(" where  eff_status='N'");
						}
					}
				}
			
			String ord[] = request.getParameterValues("orderbycolumns");
				if (!(ord == null  || ord .equals("null") || ord .equals("")))
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
			else{
				sql = new StringBuffer();
				sql.append(whereClause);
			}
			int start = 0 ;
			int end = 0 ;
			int i=1;
			if (from == null)
				start = 1 ;
			else
				start = Integer.parseInt(from) ;
			
			if (to == null)
				 end =  pageCnt;
			else
				end = Integer.parseInt(to) ;	

			try
			{
				con  = ConnectionManager.getConnection();

				strsql.append("select count(*) as total from ca_ext_appl_detail ");
				strsql.append(sql.toString());

				
				pstmt = con.prepareStatement(strsql.toString());	
				rs = pstmt.executeQuery();
				rs.next();
				maxRecord = rs.getInt("total");
				
				if(maxRecord == 0){
					out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>");
				}

				strsqll.append("SELECT (SELECT ext_image_appl_name FROM ca_ext_image_appl  WHERE eff_status = 'E'and ext_image_appl_id = a.ext_image_appl_id	) ext_image_appl_name ,(select SHORT_DESC from OR_ORDER_CATEGORY where order_category = a.order_category ) or_order_category_desc, (select SHORT_DESC from OR_ORDER_TYPE where EFF_STATUS='E' and order_type_code = a.order_type_code ) order_type_desc, (select SHORT_DESC from or_order_catalog where order_catalog_code = a.order_catalog_code )order_catalog_desc, a.eff_status,a.ext_image_appl_id,a.order_category,a.order_type_code,a.order_catalog_code,(select facility_name from sm_facility_param where  status='E' and facility_id = a.facility_id) facility_name ,a.facility_id FROM ca_ext_appl_detail a ");

				strsqll.append(sql.toString());

				pstmt1=con.prepareStatement(strsqll.toString());
				rset = pstmt1.executeQuery();
			}
			catch (Exception e)
			{
				//out.println("Exception in CAExternalApplDtlResult.jsp:"+e.getMessage());//COMMON-ICN-0181
                                 e.printStackTrace();//COMMON-ICN-0181
			}
		%>
			<table cellpadding='3' cellspacing='0' border='0' width='100%' align='center'>
					<tr>
						<td align='right'>
							<%
							if ( !(start <= 1) )
								out.println("<A class='gridLink' HREF='../../eCA/jsp/CAExternalApplDtlResult.jsp?from="+(start-pageCnt)+"&to="+(end-pageCnt)+"&whereclause=" + URLEncoder.encode(sql.toString()) + "'" + " text-decoration='none'><fmt:message key='Common.previous.label' bundle='${common_labels}'/></A>");
							if ( !( (start+pageCnt) > maxRecord ) )
								out.println("<A class='gridLink' HREF='../../eCA/jsp/CAExternalApplDtlResult.jsp?from="+(start+pageCnt)+"&to="+(end+pageCnt)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'><fmt:message key='Common.next.label' bundle='${common_labels}'/></A>");
							%>
							</td>
						</tr>
				</table>
				<table class='grid' width='100%' align='center' >
				<td class='COLUMNHEADERCENTER'><fmt:message key="Common.Application.label" bundle="${common_labels}"/></td>
				<td class='COLUMNHEADERCENTER'><fmt:message key="Common.OrderCategory.label" bundle="${common_labels}"/></td>
				<td class='COLUMNHEADERCENTER'><fmt:message key="Common.OrderType.label" bundle="${common_labels}"/></td>
				<td class='COLUMNHEADERCENTER'><fmt:message key="Common.ordercatalog.label" bundle="${common_labels}"/></td>
				<td class='COLUMNHEADERCENTER'><fmt:message key="Common.FacilityName.label" bundle="${common_labels}"/></td>
				<td class='COLUMNHEADERCENTER'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>

			<%
			
				if ( start != 1 )
				for( int j=1; j<start; i++,j++ )
						rset.next() ;
				String classValue= " ";
				while ( rset.next() && i<=end  )
				{
					/*if ( i % 2 == 0 )
						classValue = "QRYEVEN" ;
					else
						classValue = "QRYODD" ;
                     */
                classValue = "gridData";
				
				ext_image_appl_id = rset.getString("ext_image_appl_id")==null?"":rset.getString("ext_image_appl_id");
				order_category      = rset.getString("order_category")==null?"":rset.getString("order_category");
				order_type_code   =  rset.getString("order_type_code")==null?"":rset.getString("order_type_code");
				order_catalog_code =  rset.getString("order_catalog_code")==null?"":rset.getString("order_catalog_code");
				eff_status =  rset.getString("eff_status")==null?"":rset.getString("eff_status");
				ext_image_appl_name = rset.getString("ext_image_appl_name")==null?"":rset.getString("ext_image_appl_name"); 
				or_order_category_desc = rset.getString("or_order_category_desc")==null?"":rset.getString("or_order_category_desc"); 
				order_type_desc = rset.getString("order_type_desc")==null?"*ALL":rset.getString("order_type_desc"); 
				order_catalog_desc  = rset.getString("order_catalog_desc")==null?"ALL":rset.getString("order_catalog_desc"); 				
				facility_name  = rset.getString("facility_name")==null?"ALL":rset.getString("facility_name"); 				
				facility_id  = rset.getString("facility_id")==null?"":rset.getString("facility_id"); 				
				
					out.println("<tr><td class='" + classValue + "'>");
					out.println("<a  class='gridLink' href='../../eCA/jsp/CAExternalApplDtlAddModify.jsp?mode="+mode+"&ext_image_appl_id="+ext_image_appl_id+"&order_category="+order_category+"&order_type_code="+order_type_code+"&order_catalog_code="+order_catalog_code+"&eff_status="+eff_status+"&order_type_desc="+order_type_desc+"&facility_name="+facility_name+"&facility_id="+facility_id+"&order_catalog_desc="+order_catalog_desc+"' target='f_query_add_mod' >");
					out.println(ext_image_appl_name+"</a></td>");
					out.println("<td class='" + classValue + "'>"+or_order_category_desc+"</td><td class='" + classValue + "'>"+order_type_desc+"</td>");
					out.println("<td class='" + classValue + "'>"+order_catalog_desc +"</td>");
					out.println("<td class='" + classValue + "'>"+facility_name +"</td>");
					out.println("<td class='" + classValue + "'>");

						if (eff_status.equals("E"))
							out.println("<img src='../../eCommon/images/enabled.gif'></img>");
						else
							out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
							out.println("</td></tr>");
					i++;
				}
				%>
			</table>

		<%
		}//end of 1st try block
		catch (Exception e)
		{
			//out.println("Exception :"+e.toString());//COMMON-ICN-0181
			e.printStackTrace();//COMMON-ICN-0181
		}
		finally
		{
			if(rs!=null)rs.close();
			if(pstmt!=null)pstmt.close();
			if(rset!=null)rset.close();
			if(pstmt1!=null)pstmt1.close();
			if(con!=null) ConnectionManager.returnConnection(con,request);
		}
		%>
		</form>
	</body>
</html>

