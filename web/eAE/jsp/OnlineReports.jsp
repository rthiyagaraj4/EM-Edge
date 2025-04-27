<%@ page import ="webbeans.eCommon.ConnectionManager,java.sql.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<Script src="../../eCommon/js/ValidateControl.js" language="JavaScript"></Script>


<%



            request.setCharacterEncoding("UTF-8");
			request= new XSSRequestWrapper(request);
			response.addHeader("X-XSS-Protection", "1; mode=block");
			response.addHeader("X-Content-Type-Options", "nosniff");
			
			Connection con					=	null;
            PreparedStatement pstmt			=	null;
            ResultSet rset					=	null;
			StringBuffer sqlReport			=	null;
            String visitcode="";
            String visitdesc="";
            String common=request.getParameter("Common_Text");
            String scode = request.getParameter("Service_code");
            String facilityId=(String)session.getValue("facility_id");
            String chksrc=request.getParameter("Chksrc");
			String online_mr_notfn_yn = "";
			String moduleId   =	"";
			String reportId   =	"";
            String reportDesc =	"";
			
			int count2 =0;


	        String sStyle	=
			(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            if(scode!=null)
				scode=scode.trim();

			if(chksrc.trim().equals("visit_type"))
			{

			/* The following sql query is used to fetch the visit types from the database table op_visit_type_for_clinic_vw for the corresponding facility and clinic --- Srijagadeesh.*/	

				String sql = "select '*A' visit_type_code,'*All' visit_type_short_desc from dual union select visit_type_code, visit_type_short_desc  from op_visit_type_for_clinic_vw where facility_id='"+facilityId+"' and clinic_code =nvl('"+common.trim()+"',clinic_code)" ;
            try
			{
				con = ConnectionManager.getConnection(request);
				pstmt = con.prepareStatement(sql);
                rset     = pstmt.executeQuery();

                out.println("<html><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></HEAD><body CLASS='MESSAGE' onKeyDown = 'lockKey();'><form name='nam1' id='nam1'>");
                
				if(rset != null)
                {
%>
					<script>
						var tp ="-----Select-----";
						var opt=parent.f_query_add_mod.document.createElement("OPTION");
                            opt.text=tp;
                            opt.value="";

                        parent.f_query_add_mod.document.forms[0].visit_type.add(opt);
                    </script>
<%
                    while( rset.next() )
                    {
                        visitcode=rset.getString("visit_type_code");
                        visitdesc=rset.getString("visit_type_short_desc");
%>
                    <script>
                        var scode="<%=scode%>";
                        var temp = "<%=visitcode%>";
                        var temp1="<%=visitdesc%>";
                        var opt=parent.f_query_add_mod.document.createElement("OPTION");
                        opt.text=temp1;
                        opt.value=temp;
                        if (scode==temp)
                            opt.selected=true;
                        parent.f_query_add_mod.document.forms[0].visit_type.add(opt);
                    </script>

<%
	                }
                }

                if(common.equals("*All")){

				sqlReport   = new StringBuffer();				
				String sql1 = "SELECT SUM (DECODE (online_mr_notfn_yn, 'N', 0, 'Y', 1)) b   FROM op_clinic  WHERE facility_id ='"+facilityId+"' AND eff_status = 'E' AND level_of_care_ind = 'E' ";

				pstmt = con.prepareStatement(sql1);
				rset     = pstmt.executeQuery();

					if(rset!= null &&  rset.next() ){					   
			            count2 =rset.getInt("b");
					}
					if (rset != null)   rset.close();
					if (pstmt != null) pstmt.close();

					sqlReport.append("select report_desc,report_id,module_id from  sm_report where module_id in ('AE' ,'MP','OP') and internal_request_yn='Y' and report_id not in ('MPBNBFRM', 'OPBQTKNO','MPBIRCER','MPDTHCER','OPRNTFMR','OPBMEDCR','OPRFLETR','OPRVSLBL','MPSTBCER','MPBSTLBL','MPBPTLBL') ");

					if (count2 >= 1)
                    {
					  sqlReport.append(" UNION SELECT   report_desc, report_id, module_id FROM sm_report  WHERE module_id = 'FM' AND internal_request_yn = 'Y'  AND report_id ='FMFLRQSL' ");
					}
					sqlReport.append("order by report_desc ");

					pstmt = con.prepareStatement(sqlReport.toString());
					rset     = pstmt.executeQuery();

					if(rset!=null)
						{
							while(rset.next())
							{
								moduleId  = rset.getString("module_id");
								reportId  =	rset.getString("report_id");
								reportDesc=	rset.getString("report_desc");
	%>
								<script>
									var temp ="<%=reportId%>";
									var temp1="<%=reportDesc%>";
									var opt1=parent.f_query_add_mod.document.createElement("OPTION");
									opt1.text=temp1;
									//opt1.value=temp;
									// Below line added for incident IN017226 by Muthu on 15/12/2009
									opt1.value="<%=reportId%>::<%=moduleId%>";
									parent.f_query_add_mod.document.forms[0].report_desc.add(opt1);
									parent.f_query_add_mod.document.forms[0].report.value =  "<%=reportId%>::<%=moduleId%>";
								</script>

	<%					   }
						}
					if (rset != null)   rset.close();
					if (pstmt != null) pstmt.close();
					if((sqlReport != null) && (sqlReport.length() > 0))
					  {
						sqlReport.delete(0,sqlReport.length());
					  } 
				}
				else 
				{
					String sql1 = "SELECT ONLINE_MR_NOTFN_YN FROM op_clinic where facility_id='"+facilityId+"'  and clinic_code ='"+common.trim()+"' " ;
					sqlReport   = new StringBuffer();

					pstmt = con.prepareStatement(sql1);
					rset     = pstmt.executeQuery();
					if(rset!= null &&  rset.next() ){
					   online_mr_notfn_yn = rset.getString("ONLINE_MR_NOTFN_YN");
					}
					if (rset != null)   rset.close();
					if (pstmt != null) pstmt.close();

					sqlReport.append("select report_desc,report_id,module_id from  sm_report where module_id in ('AE' ,'MP','OP') and internal_request_yn='Y' and report_id not in ('MPBNBFRM', 'OPBQTKNO','MPBIRCER','MPDTHCER','OPRNTFMR','OPBMEDCR','OPRFLETR','OPRVSLBL','MPSTBCER','MPBSTLBL','MPBPTLBL') ");


					if(online_mr_notfn_yn.equals("Y"))
					{
					  sqlReport.append(" UNION SELECT   report_desc, report_id, module_id FROM sm_report  WHERE module_id = 'FM' AND internal_request_yn = 'Y'  AND report_id ='FMFLRQSL' ");
					}
					sqlReport.append("order by report_desc ");


					pstmt = con.prepareStatement(sqlReport.toString());
					rset     = pstmt.executeQuery();

					if(rset!=null)
						{
							while(rset.next())
							{
								moduleId  = rset.getString("module_id");
								reportId =rset.getString("report_id");
								reportDesc=rset.getString("report_desc");
	%>
								<script>
									var temp ="<%=reportId%>";
									var temp1="<%=reportDesc%>";
									var opt1=parent.f_query_add_mod.document.createElement("OPTION");
									opt1.text=temp1;
									opt1.value="<%=reportId%>::<%=moduleId%>";
									parent.f_query_add_mod.document.forms[0].report_desc.add(opt1);
								</script>

	<%					   }
						}
					if((sqlReport != null) && (sqlReport.length() > 0))
					  {
						sqlReport.delete(0,sqlReport.length());
					  } 
				}
				if (rset != null)   rset.close();
                if (pstmt != null) pstmt.close();
            }catch(Exception e) {e.printStackTrace();}
            finally 
			{
              if (pstmt != null) pstmt.close();
              if (rset != null)   rset.close();
				ConnectionManager.returnConnection(con,request); 
            }

            out.println("</form></body></html>");
}
%>

