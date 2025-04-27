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
			StringBuffer sql= new StringBuffer();
            String nursing_unit_code = request.getParameter("nursing_unit_code");
			if (nursing_unit_code==null || nursing_unit_code.equals("undefined") ||  nursing_unit_code.equals("")) nursing_unit_code = "";
            String booking_list_ref_no = request.getParameter("booking_list_ref_no");
			if (booking_list_ref_no==null || booking_list_ref_no.equals("undefined") ||  booking_list_ref_no.equals("")) booking_list_ref_no = "";
            int i=1;
        try{                
			con = ConnectionManager.getConnection(request);
            if(mode.equals("view"))
            {
				sql.append(" select a.REPORT_ID REPORT_ID, b.REPORT_DESC REPORT_DESC, a.MODULE_ID MODULE_ID from IP_ONLINE_REPORT a, SM_REPORT b ");
				sql.append(" where a.module_id='IP' and a.facility_id='"+facility_id+"' and  ");
				sql.append(" ( nursing_unit_code='"+nursing_unit_code+"' ) and PRINT_ON_BOOKING_YN='Y' ");
				sql.append(" and a.report_id = b.report_id");

				pstmt = con.prepareStatement(sql.toString());
				rset      = pstmt.executeQuery();
            %>
        </head>

        <body onMouseDown='CodeArrest()' onKeyDown='lockKey()'>
        <br>
        <br>
            <form name='Report_Form' id='Report_Form' action='IpinternlReportReprintCompBook.jsp'>
                <table border="1" width="102%" cellspacing='0' cellpadding='0'>
                
                <tr>
                    <th width='50%'><fmt:message key="Common.reportname.label" bundle="${common_labels}"/> </th>
                    <th><fmt:message key="Common.required.label" bundle="${common_labels}"/></th>
                    <th><fmt:message key="Common.copies.label" bundle="${common_labels}"/></th>
                </tr>
                <%
                    String cellclass="QRYEVEN";
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
                                        <input type='checkbox' name='reportchk<%=i%>' id='reportchk<%=i%>' value='Y' onclick='checkCopy(this,<%=i%>)' CHECKED>
                                    </td>   
                                    <td class='<%=cellclass%>' align='center'>
                                        <input type='text' name='numofcopies<%=i%>' id='numofcopies<%=i%>' value='1' size=4 maxlength=4 onKeyPress="return allowValidNumber(this,event,4,0)" onblur='CheckNum(this)'>
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
                %>
                </table>
                <table border="0" width="102%" cellspacing='0' cellpadding='0'>
                <tr>
                    <td class='white' colspan=2>&nbsp</td>
                </tr>
                <tr>
                    <td align='right' width='50%' class='white'>
                        <input type='submit' name='ok' id='ok' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ok.label","common_labels")%>' class='button'>
                    </td>
                    <td align='left' width='50%' class='white'>&nbsp&nbsp
                        <input type='button' name='cancel' id='cancel' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")%>' class='button' onclick='closewin()'>
                    </td>
                </tr>
                </table>
                <input type='hidden' name='mode' id='mode' value='print'>
                <input type='hidden' name='total' id='total' value='<%=i-1%>'>
                <input type='hidden' name='booking_list_ref_no' id='booking_list_ref_no' value='<%=booking_list_ref_no%>'>
                <input type='hidden' name='nursing_unit_code' id='nursing_unit_code' value='<%=nursing_unit_code%>'>
							
                </form>
            <%
                }       
                else
                {
					nursing_unit_code = request.getParameter("nursing_unit_code");
					if (nursing_unit_code==null || nursing_unit_code.equals("undefined") ||  nursing_unit_code.equals("")) nursing_unit_code = "";
					booking_list_ref_no = request.getParameter("booking_list_ref_no");
					if (booking_list_ref_no==null || booking_list_ref_no.equals("undefined") ||  booking_list_ref_no.equals("")) booking_list_ref_no = "";
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
                                  	ecis.utils.OnlineReport report1= new ecis.utils.OnlineReport( facility_id, "IP", rs_report_id ,"N", nursing_unit_code);
                                   
                                    report1.addParameter( "p_facility_id",  facility_id ) ;
                                    report1.addParameter( "P_BKG_LST_REF_NO",booking_list_ref_no) ;
                                    report1.addParameter( "p_copies",   numofcopies ) ; 
                                    
                                    report1.addParameter( "p_report_id",rs_report_id);
									report1.addParameter( "p_module_id",rs_module_id);
								    onlineReports.add( report1) ;
                                }
                            }
                            i++;
                        }
                        session.putValue( "online_reports", onlineReports ) ;
                        
                           ReportOutput = onlineReports.execute( request, response );
                        if ( ReportOutput.length() > 0 )
                                out.println("<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></head><body onKeyDown='lockKey()'><br>"+ReportOutput+"<center><input type='button' type='Button' name ='ok' value='"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ok.label","common_labels")+"' class='Button' onclick='parent.parent.window.close()'></center></body></html>");
                        else if ( ReportOutput.length() == 0 )
                        {
                                out.println("<html> <head> <link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link> </head> <body onKeyDown='lockKey()'> <center><br><script>getMessage('REPORT_GENERATED','SM')</script><br> <form> <input type='Button' name='ok' id='ok' value='"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ok.label","common_labels")+"' class='Button' onclick='closewin()'> </center></form>   </body> </html>");
                        }
                       
                    }
    
				}

	          if (pstmt != null)    pstmt.close();
              if (rset      != null)    rset.close();

        } catch(Exception e) { out.println("s"+e.toString());}
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

