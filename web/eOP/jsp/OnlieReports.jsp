
<%@ page import ="webbeans.eCommon.ConnectionManager,java.sql.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<Script src="../../eCommon/js/ValidateControl.js" language="JavaScript"></Script>
<Script src="../../eCommon/js/common.js" language="JavaScript"></Script>
<%



			request.setCharacterEncoding("UTF-8");
            Connection con = null;
            PreparedStatement pstmt=null;
            ResultSet rset=null;
            String visitcode="";
            String visitdesc="";
            String report_desc="";
            String report_id="";
            String common=request.getParameter("Common_Text");
            String scode = request.getParameter("Service_code");
            String facilityId=(String)session.getValue("facility_id");
            String chksrc=request.getParameter("Chksrc");
	        String sStyle	=			(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

			

            if(scode!=null)
				scode=scode.trim();
	
			if(chksrc.trim().equals("visit_type"))
			{
				

			/* The following sql query is used to fetch the visit types from the database table op_visit_type_for_clinic_vw for the corresponding facility and clinic --- Srijagadeesh.*/	
			if(common.equals(""))
				{
				%>
					<script>
						var tp ="-----"+getLabel("Common.defaultSelect.label","Common")+"-----";
						var opt=document.createElement("OPTION");
                            opt.text=tp;
                            opt.value="";

 							parent.window[1].document.getElementById("visit_type").add(opt);
                    </script>
<%
				}
			else {

				String sql = "select '*A' visit_type_code,'*All' visit_type_short_desc from dual union select visit_type_code, visit_type_short_desc  from op_visit_type_for_clinic_vw where facility_id='"+facilityId+"' and clinic_code =nvl('"+common.trim()+"',clinic_code) " ;

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
						var tp ="-----"+getLabel("Common.defaultSelect.label","Common")+"-----";
						var opt=document.createElement("OPTION");
                            opt.text=tp;
                            opt.value="";

                            parent.window[1].document.getElementById("visit_type").add(opt);
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
                        var opt=document.createElement("OPTION");
                        opt.text=temp1;
                        opt.value=temp;
                        if (scode==temp)
                            opt.selected=true;
                        parent.window[1].document.getElementById("visit_type").add(opt);
                    </script>

<%
	                }
                }

            }catch(Exception e) { out.println(e.toString());}
			}
				
			 try
			{

				 	if(common.equals(""))
				{
				%>
					<script>
						var tp ="--------------"+getLabel("Common.defaultSelect.label","Common")+"--------------";
						var opt=document.createElement("OPTION");
                            opt.text=tp;
                            opt.value="";
                         parent.window[1].document.getElementById("report_desc").add(opt);
                         
                           // document.getElementById("report_desc").add(opt);
                           
                           parent.window[2].location.href="../../eCommon/jsp/error.jsp";
                    </script>
<%
				}
			else if(common.equals("*All")){

				StringBuffer sqlReport   = new StringBuffer();					
				int count2  = 0;
				
				String sql1 = "SELECT SUM (DECODE (online_mr_notfn_yn, 'N', 0, 'Y', 1)) b   FROM op_clinic  WHERE facility_id ='"+facilityId+"' AND eff_status = 'E' AND level_of_care_ind = 'E' ";

				

				pstmt = con.prepareStatement(sql1);
				rset     = pstmt.executeQuery();

					if(rset!= null &&  rset.next() ){					    
			            count2 =rset.getInt("b");
					}
					if (rset != null)   rset.close();
					if (pstmt != null) pstmt.close();

				

					sqlReport.append("select report_desc,report_id,module_id from sm_report where module_id in ('MP','OP') and internal_request_yn='Y' and report_id not in ('MPBNBFRM','MPBIRCER','MPDTHCER','OPBMEDCR','MPBWBLBL','OPRFLETR','MPSTBCER')");

					if (count2>=1)
                    {
					  sqlReport.append(" UNION SELECT   report_desc, report_id, module_id FROM sm_report  WHERE module_id = 'FM' AND internal_request_yn = 'Y'  AND report_id ='FMFLRQSL' ");
					}
					sqlReport.append("order by report_desc ");
					

					pstmt = con.prepareStatement(sqlReport.toString());
					rset     = pstmt.executeQuery();

					if(rset!=null)
						{
			%>
							<script>
						//parent.document.frames[1].document.forms[0].report_desc.remove("report_desc");
						parent.window[1].document.getElementById("report_desc").remove("report_desc");
						var tp ="--------------"+getLabel("Common.defaultSelect.label","Common")+"--------------";
						var opt=document.createElement("OPTION");
                            opt.text=tp;
                            opt.value="";
								
                            parent.window[1].document.getElementById("report_desc").add(opt);
						
                    </script>
			<%
							while(rset.next())
							{
								report_id  =	rset.getString("report_id");
								report_desc=	rset.getString("report_desc");
	%>
								<script>
									var temp ="<%=report_id%>";
									var temp1="<%=report_desc%>";
									
									var opt1=document.createElement("OPTION");
									opt1.text=temp1;
									opt1.value=temp;
									parent.window[1].document.getElementById("report_desc").add(opt1);
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
				else {
				String autofilereq ="";

				String sql2 = "SELECT online_mr_notfn_yn FROM op_clinic WHERE FACILITY_ID ='"+facilityId+"' and clinic_code ='"+common+"'";
				 
				String sql3 = "";
				pstmt = con.prepareStatement(sql2);
                rset     = pstmt.executeQuery();
				while(rset.next())
					{
						autofilereq=rset.getString("online_mr_notfn_yn");
					} 
					
				if (rset != null) rset.close();

                if(autofilereq.equals("Y"))
                {
					sql3 = "select report_desc,report_id,module_id from  sm_report where module_id in ('MP','OP') and internal_request_yn='Y' and report_id not in ('MPBNBFRM','MPBIRCER','MPDTHCER','OPBMEDCR','MPBWBLBL','OPRFLETR','MPSTBCER') UNION  SELECT report_desc, report_id, module_id  FROM sm_report WHERE module_id ='FM' AND internal_request_yn = 'Y' AND report_id = 'FMFLRQSL' order by report_desc" ;
				}
				else
					sql3 = "select report_desc,report_id,module_id from sm_report where module_id in ('MP','OP') and internal_request_yn='Y' and report_id not in ('MPBNBFRM','MPBIRCER','MPDTHCER','OPBMEDCR','MPBWBLBL','OPRFLETR','MPSTBCER') order by report_desc ";

				
				pstmt = con.prepareStatement(sql3);
                rset     = pstmt.executeQuery();

				if(rset != null)
                {
%>
					<script>
					parent.window[1].document.getElementById("report_desc").remove("report_desc");
						var tp ="--------------"+getLabel("Common.defaultSelect.label","Common")+"--------------";
						var opt=document.createElement("OPTION");
                            opt.text=tp;
                            opt.value="";
								
                            parent.window[1].document.getElementById("report_desc").add(opt);
						
                    </script>
<%
                    while( rset.next() )
                    {
                        report_id=rset.getString("report_id");
                        report_desc=rset.getString("report_desc");
%>
                    <script>
                        var scode="<%=scode%>";
                        var temp = "<%=report_id%>";
                        var temp1="<%=report_desc%>";
						
                        var opt=document.createElement("OPTION");
                        opt.text=temp1;
                        opt.value=temp;
                      //  if (scode==temp)
                      //      opt.selected=true;					
                       parent.window[1].document.getElementById("report_desc").add(opt);
                    </script>

<%
	                }
                }
		      }	
            }catch(Exception e) { out.println(e.toString());}
            finally 
			{
              if (pstmt != null) pstmt.close();
              if (rset != null)   rset.close();
				ConnectionManager.returnConnection(con,request); 
            }

            out.println("</form></body></html>");
}
%>

