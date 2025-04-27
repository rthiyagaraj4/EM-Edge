<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>  
<%@ page import="java.sql.*, java.util.*, java.text.*,ecis.utils.*,webbeans.eCommon.ConnectionManager;" contentType="text/html;charset=UTF-8"%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
    <head>
        <link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
        <script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
        <script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

          <script>
            function submitPage()
			{
				document.forms[0].submit();
			}
			function closewin()
            {
                parent.window.returnValue='agn'
                parent.window.close()
            }
			function checkCopy(obj,rowNum)
			{
				if(!obj.checked)
				{
					var num="document.Report_Form.numofcopies"+rowNum;
					eval(num).value='';
					eval(num).readOnly=true;
				}
				else
				{
					var num="document.Report_Form.numofcopies"+rowNum;
					eval(num).readOnly=false;
				}
			}
        </script>
        <%
			request.setCharacterEncoding("UTF-8");
            Connection con = null;
            PreparedStatement pstmt=null;
            ResultSet rset=null ;
            String facility_id=(String)session.getValue("facility_id");
            String mode=request.getParameter("mode");

            String encounter_id=request.getParameter("encounter_id");
			String print_yn = request.getParameter("print_yn");
			if (print_yn==null || print_yn== "" || print_yn.equals("")) 
			print_yn="N";	
            StringBuffer sql=new StringBuffer();
            String p_clinic_code = "" ;
            String p_clinic_type = "" ; 
            String p_patient_id = "" ;

			//Added by kumar for calling MP Reports if file is created at the time of visit Registration
			String pat_ser_grp_code = "";
			String inhouse_birth_yn = "";
			String gen_file_no = request.getParameter("gen_file_no");
			if (gen_file_no==null || gen_file_no.equals("undefined")) gen_file_no = "";
			
			String file_created_at_regn_yn = request.getParameter("file_created_at_regn_yn");
			if (file_created_at_regn_yn==null) file_created_at_regn_yn = "N";

			String column_name = request.getParameter("column_name");
			if (column_name==null || column_name.equals("undefined")) column_name = "";
			String nursing_unit_code = request.getParameter("nursing_unit_code");
			if (nursing_unit_code==null || nursing_unit_code.equals("undefined")) nursing_unit_code = "";
            int i=1;
        try{  
			con = ConnectionManager.getConnection(request);
			if(mode.equals("view"))
            {
				if(sql.length() > 0) sql.delete(0,sql.length());
				sql.append(" select ASSIGN_CARE_LOCN_TYPE,ASSIGN_CARE_LOCN_CODE,patient_id from PR_ENCOUNTER where facility_id = '"+facility_id+"' and encounter_id="+encounter_id+" ");
				pstmt = con.prepareStatement(sql.toString());
				rset      = pstmt.executeQuery();
				if(rset.next())
				{
					p_clinic_code = rset.getString("ASSIGN_CARE_LOCN_CODE") ;
					p_clinic_type = rset.getString("ASSIGN_CARE_LOCN_TYPE") ;
					p_patient_id = rset.getString("patient_id") ;
				}
				if(rset!=null) rset.close();
				if(pstmt!=null) pstmt.close();
				
		if(print_yn.equals("N"))		 
		  {
				//  Only for Print Admission Patient
				 if (file_created_at_regn_yn.equals("Y"))
				 {
					 if(sql.length() > 0) sql.delete(0,sql.length());
					sql.append("select pat_ser_grp_code, inhouse_birth_yn from mp_patient where patient_id=? ");
					 pstmt = con.prepareStatement(sql.toString());
					 pstmt.setString(1, p_patient_id);
					 rset = pstmt.executeQuery();
					 if (rset != null && rset.next())
					 {
						pat_ser_grp_code = rset.getString(1);
						inhouse_birth_yn = rset.getString(2);
						if(rset!=null) rset.close();
						if(pstmt!=null) pstmt.close();
					 }					 					 
					 if (inhouse_birth_yn.equals("Y"))
					 {
						if(sql.length() > 0) sql.delete(0,sql.length());
						sql.append(" select report_id, report_desc, no_of_copies, orderby, module_id from (select distinct A.report_id,B.report_desc, 1 no_of_copies, 1 orderby, b.module_id from mp_online_reports A, sm_report B, sm_print_routing c where A.pat_ser_grp_code = '"+pat_ser_grp_code+"' and A.print_reqd_yn='Y' and B.report_id=A.report_id and a.report_id = c.report_id (+) and NVL(c.facility_id,'"+facility_id+"') = '"+facility_id+"' and A.report_id in ('MPBNBFRM', 'MPBWBLBL') union select a.report_id report_id, b.report_desc report_desc, 1 no_of_copies, 2 orderby, a.module_id  module_id from IP_ONLINE_REPORT a, SM_REPORT b  where  a.module_id = 'IP' and b.internal_request_yn='Y' and a.facility_id='"+facility_id+"' and a.PRINT_ON_ADMISSION_YN='Y' and a.NURSING_UNIT_CODE ='"+nursing_unit_code+"' and a.report_id = b.report_id) ORDER BY 4,2 ");
					 }
					 else
					 {
					   	if(sql.length() > 0) sql.delete(0,sql.length());
						sql.append("select report_id, report_desc, no_of_copies, orderby, module_id from (select distinct A.report_id,B.report_desc, 1 no_of_copies, 1 orderby, b.module_id from mp_online_reports A, sm_report B, sm_print_routing c where A.pat_ser_grp_code = '"+pat_ser_grp_code+"' and A.print_reqd_yn='Y' and B.report_id=A.report_id and a.report_id = c.report_id (+) and NVL(c.facility_id,'"+facility_id+"') = '"+facility_id+"' and A.report_id not in ('MPBNBFRM', 'MPBWBLBL') union select a.report_id report_id, b.report_desc report_desc, 1 no_of_copies, 2 orderby, a.module_id  module_id from IP_ONLINE_REPORT a, SM_REPORT b  where  a.module_id = 'IP' and b.internal_request_yn='Y' and a.facility_id='"+facility_id+"' and a.PRINT_ON_ADMISSION_YN='Y' and a.NURSING_UNIT_CODE ='"+nursing_unit_code+"' and a.report_id = b.report_id) ORDER BY 4,2 ");
					 }

				 }
                 else
				 {
					if(sql.length() > 0) sql.delete(0,sql.length());
					sql.append(" select report_id, report_desc, 1 no_of_copies, module_id from ");
		            sql.append("sm_report where internal_request_yn='Y' and ");
			        sql.append("module_id = 'IP' ");
				    sql.append("order by 2");
		
				 }
			}
			else  
			{
				if(sql.length() > 0) sql.delete(0,sql.length());
				sql.append(" select a.REPORT_ID REPORT_ID, b.REPORT_DESC REPORT_DESC, a.MODULE_ID MODULE_ID from IP_ONLINE_REPORT a, SM_REPORT b ");
				sql.append(" where a.module_id='IP' and a.facility_id='"+facility_id+"' and  ");
				sql.append(" a."+column_name+"='Y' and a.NURSING_UNIT_CODE ='"+nursing_unit_code+"' ");
				sql.append(" and a.report_id = b.report_id");
			}
				out.println(sql.toString());
			 try
			 {
				pstmt = con.prepareStatement(sql.toString());
				rset      = pstmt.executeQuery();
			 }
			 catch(Exception e) { out.println(e.toString());}

            %>
        </head>

        <body onMouseDown='CodeArrest()' onMouseDown='CodeArrest()' onKeyDown='lockKey()'>
        <br>
        <br>
            <form name='Report_Form' id='Report_Form' action='IpinternlReportReprintComp.jsp'>
                <table border="1" width="102%" cellspacing='0' cellpadding='0'>
                
                <tr>
                    <th width='50%'><fmt:message key="Common.reportname.label" bundle="${common_labels}"/></th>
                    <th><fmt:message key="Common.required.label" bundle="${common_labels}"/></th>
                    <th><fmt:message key="Common.copies.label" bundle="${common_labels}"/></th>
                </tr>
                <%
                    String cellclass="QRYEVEN";
          if(print_yn.equals("N"))		 
		  {
                    try
                    {
                        if(rset!=null)
                        {
                            while(rset.next())
                            {
                                if(cellclass.equals("QRYEVEN"))
                                    cellclass="QRYODD";
                                else
                                        cellclass="QRYEVEN";
                 %>
                                <tr>
                                    <td class='<%=cellclass%>' >
                                        <input type='hidden' name='report_id<%=i%>' id='report_id<%=i%>' value='<%=rset.getString("report_id")%>'>
										<input type='hidden' name='module_id<%=i%>' id='module_id<%=i%>' value='<%=rset.getString("module_id")%>'>
                                        <%=rset.getString("report_desc")%>
                                    </td>
                                    <td class='<%=cellclass%>' align='center'>
                                        <input type='checkbox' name='reportchk<%=i%>' id='reportchk<%=i%>' value='Y' CHECKED onclick='checkCopy(this,<%=i%>)'>
                                    </td>   
                                    <td class='<%=cellclass%>' align='center'>
                                        <input type='text' name='numofcopies<%=i%>' id='numofcopies<%=i%>' value='<%=rset.getString("no_of_copies")%>' size=4 maxlength=4 onKeyPress='return allowValidNumber(this,event,4,0);' onblur='CheckNum(this)'>
                                    </td>                                   
                                </tr>
                 <%
                                i++;
                            }
						if(rset!=null) rset.close();
						if(pstmt!=null) pstmt.close();
                        }
                    }
                    catch(Exception e){out.print(e);}
		  }
		else  // for print_yn='Y'
			{
                    try
                    {
                        if(rset!=null)
                        {
                            while(rset.next())
                            {
								if(cellclass.equals("QRYEVEN"))
                                    cellclass="QRYODD";
                                else
                                        cellclass="QRYEVEN";
                 %>
                                <tr>
                                    <td class='<%=cellclass%>' >
                                        <input type='hidden' name='report_id<%=i%>' id='report_id<%=i%>' value='<%=rset.getString("report_id")%>'>
										<input type='hidden' name='module_id<%=i%>' id='module_id<%=i%>' value='<%=rset.getString("module_id")%>'>
                                        <%=rset.getString("REPORT_DESC")%>
                                    </td>
                                    <td class='<%=cellclass%>' align='center'>
                                        <input type='checkbox' name='reportchk<%=i%>' id='reportchk<%=i%>' value='Y' CHECKED onclick='checkCopy(this,<%=i%>)'>
                                    </td>   
                                    <td class='<%=cellclass%>' align='center'>
                                        <input type='text' name='numofcopies<%=i%>' id='numofcopies<%=i%>' value='1' size=4 maxlength=4 onblur='CheckNum(this)' OnKeyPress='				return allowValidNumber(this,event,4,0);'>
                                    </td>                                   
                                </tr>
                 <%
                                i++;
                            }
						if(rset!=null) rset.close();
						if(pstmt!=null) pstmt.close();
                        }
                    }
                    catch(Exception e){out.print(e);}
			}
                %>
                </table>
                <table border="0" width="102%" cellspacing='0' cellpadding='0'>
                <tr>
                    <td class='white' colspan=2>&nbsp</td>
                </tr>
                <tr>
                    <td align='right' width='50%' class='white'>
                        <input type='button' name='ok' id='ok' onClick='submitPage();alert(getMessage("REPORT_SUBMIT_SERVER","common"));parent.window.close();' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ok.label","common_labels")%>' class='button'>
                    </td>
                    <td align='left' width='50%' class='white'>&nbsp&nbsp
                        <input type='button' name='cancel' id='cancel' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")%>' class='button' onclick='closewin()'>
                    </td>
                </tr>
                </table>
                <input type='hidden' name='mode' id='mode' value='print'>
                <input type='hidden' name='total' id='total' value='<%=i-1%>'>
                <input type='hidden' name='encounter_id' id='encounter_id' value='<%=encounter_id%>'>
                <input type='hidden' name='p_clinic_code' id='p_clinic_code' value='<%=p_clinic_code%>'>
                <input type='hidden' name='p_clinic_type' id='p_clinic_type' value='<%=p_clinic_type%>'>
                <input type='hidden' name='p_patient_id' id='p_patient_id' value='<%=p_patient_id%>'>
				<input type='hidden' name='gen_file_no' id='gen_file_no' value='<%=gen_file_no%>'>
				<input type='hidden' name='print_yn' id='print_yn' value='Y'>
                
                </form>
            <%
                }       
                else
                {
     
                p_clinic_code = request.getParameter("p_clinic_code") ;
                p_clinic_type =request.getParameter("p_clinic_type");
                p_patient_id = request.getParameter("p_patient_id");
                    if(mode.equals("print"))
                    {
                        out.print("<script>parent.frames[0].location.href='../../eCommon/html/blank.html'</script>");
                        int total=Integer.parseInt(request.getParameter("total"));
                        ecis.utils.OnlineReports onlineReports  = new ecis.utils.OnlineReports() ;
                            
                         String ReportOutput  = "" ;
                        while(i<=total)
                        {
                            String rs_report_id=request.getParameter("report_id"+String.valueOf(i));
							String rs_module_id=request.getParameter("module_id"+String.valueOf(i));
                            String numofcopies=request.getParameter("numofcopies"+String.valueOf(i));
                            String chkval=  request.getParameter("reportchk"+String.valueOf(i));
                            if (rs_report_id==null) rs_report_id = "";
                            if (numofcopies==null) numofcopies = "";
							if (rs_module_id==null) rs_module_id = "";

                            if(chkval!=null)
                            {
                                if(chkval.equals("Y"))
                                {
                                    ecis.utils.OnlineReport report1 = new ecis.utils.OnlineReport( facility_id, rs_module_id, rs_report_id, p_clinic_type, p_clinic_code ) ;
                                   
                                    report1.addParameter( "p_facility_id",  facility_id ) ;
                                    report1.addParameter( "p_encounter_id",encounter_id) ;
                                    report1.addParameter( "p_copies",   numofcopies ) ; 
                                    
                                    report1.addParameter( "p_clinic_code",p_clinic_code);
                                    report1.addParameter( "p_clinic_type",p_clinic_type);
                                    report1.addParameter( "p_patient_id",p_patient_id);
                                    report1.addParameter( "p_report_id",rs_report_id);
									report1.addParameter( "p_module_id",rs_module_id);
									report1.addParameter( "p_file_no",	gen_file_no ) ;
									onlineReports.add( report1) ;
                                }
                            }
                            i++;
                        }
                        session.putValue( "online_reports", onlineReports ) ;

                        
                           ReportOutput = onlineReports.execute( request, response );
                        if ( ReportOutput.length() > 0 )
                                out.println("<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></head><body onMouseDown='CodeArrest()' onKeyDown='lockKey()' ><br>"+ReportOutput+"<center><input type='button' type='Button' name ='ok' value='   Ok   ' class='Button' onclick='parent.parent.window.close()'></center></body></html>");
                        else if ( ReportOutput.length() == 0 )
                        {
                                out.println("<html> <head> <link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link> </head> <body onKeyDown='lockKey()'> <center><br><script>getMessage('REPORT_GENERATED','SM')</script><br> <form> <input type='Button' name='ok' id='ok' value='   Ok   ' class='Button' onclick='closewin()'> </center></form>   </body> </html>");
                        }
                       
                    }
                }
              if (rset      != null)    rset.close();
			  if (pstmt != null)    pstmt.close();
			}catch(Exception e) { out.println(e.toString());}
            finally 
			{
              if(con!=null) ConnectionManager.returnConnection(con,request);  
            }

            %>
    </body>
</html>
<%!
	/// Added by Sridhar R , on 4/26/2005.. these functions will chk for null values & initialize inputString values...
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

