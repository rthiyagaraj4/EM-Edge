<!DOCTYPE html>
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*,com.ehis.util.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>

function closewin()  {
	parent.window.returnValue='agn' 
    parent.window.close()
}
</script>
<%
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	
	Connection con = null;
    PreparedStatement pstmt=null;
    ResultSet rset=null ;
    String facility_id=(String)session.getValue("facility_id");
    String mode=request.getParameter("mode");
    String encounter_id=request.getParameter("encounter_id");
    String sql="";
    String p_clinic_code = "" ;
    String p_clinic_type = "" ; 
    String p_patient_id = "" ;
	ecis.utils.OnlineReports onlineReports  = new ecis.utils.OnlineReports() ;
	ecis.utils.OnlineReport report1 = null;

	String pat_ser_grp_code = "";
	String inhouse_birth_yn = "";
	String gen_file_no = request.getParameter("gen_file_no");
	if (gen_file_no==null || gen_file_no.equals("undefined")) gen_file_no = "";

	String file_created_at_regn_yn = request.getParameter("file_created_at_regn_yn");
	if (file_created_at_regn_yn==null) file_created_at_regn_yn = "N";

    int i=1;

    try{    
		con = ConnectionManager.getConnection(request);
		if(mode.equals("view")) {
			sql = "select ASSIGN_CARE_LOCN_TYPE,ASSIGN_CARE_LOCN_CODE,patient_id from pr_encounter where facility_id = ? and encounter_id= ? ";
            pstmt = con.prepareStatement(sql);
			pstmt.setString(1, facility_id);
			pstmt.setString(2, encounter_id);
            rset      = pstmt.executeQuery();
            if(rset.next()) {
				p_clinic_code = rset.getString("ASSIGN_CARE_LOCN_CODE") ;
                p_clinic_type = rset.getString("ASSIGN_CARE_LOCN_TYPE") ;
                p_patient_id = rset.getString("patient_id") ;
            } 
			pstmt.close();rset.close();
            	
				
			if (file_created_at_regn_yn.equals("Y")) {
				sql = "select pat_ser_grp_code, inhouse_birth_yn from mp_patient where patient_id=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, p_patient_id);
				rset = pstmt.executeQuery();
				if (rset.next())  {
					pat_ser_grp_code = rset.getString(1);
					inhouse_birth_yn = rset.getString(2);
				}
				if(pstmt!=null) pstmt.close();
				if(rset!=null) rset.close();

				if (inhouse_birth_yn.equals("Y")) {
					sql = "select report_id, report_desc, no_of_copies, orderby, module_id from (select distinct A.report_id,B.report_desc, 1 no_of_copies, 1 orderby, b.module_id from mp_online_reports A, sm_report B, sm_print_routing c where A.pat_ser_grp_code = '"+pat_ser_grp_code+"' and A.print_reqd_yn='Y' and B.report_id=A.report_id and a.report_id = c.report_id (+) and NVL(c.facility_id,'"+facility_id+"') = '"+facility_id+"' and A.report_id in ('MPBNBFRM', 'MPBWBLBL') and b.report_id <> 'OPRECNTR' union select report_id, report_desc, 1 no_of_copies, 2 orderby, module_id  from sm_report where internal_request_yn='Y' and module_id in ('OP','AE')) ORDER BY 4,2 ";
			    }  else  {
					sql = "select report_id, report_desc, no_of_copies, orderby, module_id from (select distinct A.report_id,B.report_desc, 1 no_of_copies, 1 orderby, b.module_id from mp_online_reports A, sm_report B, sm_print_routing c where A.pat_ser_grp_code = '"+pat_ser_grp_code+"' and A.print_reqd_yn='Y' and B.report_id=A.report_id and a.report_id = c.report_id (+) and NVL(c.facility_id,'"+facility_id+"') = '"+facility_id+"' and A.report_id not in ('MPBNBFRM', 'MPBWBLBL') and b.report_id <> 'OPRECNTR' union select report_id, report_desc, 1 no_of_copies, 2 orderby, module_id  from sm_report where internal_request_yn='Y' and module_id in ('OP','AE')) ORDER BY 4,2 ";
				}
			} else {
				sql="select report_id, report_desc, 1 no_of_copies, module_id from "+
		                 "sm_report where internal_request_yn='Y' and "+
			             "module_id in ('OP','AE') and report_id <> 'OPRECNTR'"+
				          "order by 2";
			}
            try {
				pstmt = con.prepareStatement(sql);
				rset      = pstmt.executeQuery();
           } catch(Exception e) { }
		   finally {
				if(pstmt!=null) pstmt.close();
				if(rset!=null) rset.close();
			}

%>
</head>

<body onKeyDown = 'lockKey()'>
<br><br>
<form name='Report_Form' id='Report_Form' action='AEInternlReportReprintComp.jsp'>
<table border="1" width="102%" cellspacing='0' cellpadding='0'>
	<tr>
		<th width=50%>Report Name </th>
        <th>Reqd</th>
        <th><fmt:message key="Common.copies.label" bundle="${common_labels}"/></th>
    </tr>
<%
	String cellclass="QRYEVEN";
    try {
		if(rset!=null) {
			while(rset.next()) {
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
			<input type='checkbox' name='reportchk<%=i%>' id='reportchk<%=i%>' value='Y' CHECKED>
         </td>   
         <td class='<%=cellclass%>' align='center'>
			<input type='text' name='numofcopies<%=i%>' id='numofcopies<%=i%>' value='<%=rset.getString("no_of_copies")%>' size=4 maxlength=4 onblur='CheckNum(this)'>
        </td>                                   
    </tr>
<%
				i++;
            }
        }
    } catch(Exception e){/* out.print(e); */ e.printStackTrace();}
%>
</table>

<table border="0" width="102%" cellspacing='0' cellpadding='0'>
	<tr>  <td class='white' colspan=2>&nbsp</td> </tr>
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
<input type='hidden' name='encounter_id' id='encounter_id' value='<%=encounter_id%>'>
<input type='hidden' name='p_clinic_code' id='p_clinic_code' value='<%=p_clinic_code%>'>
<input type='hidden' name='p_clinic_type' id='p_clinic_type' value='<%=p_clinic_type%>'>
<input type='hidden' name='p_patient_id' id='p_patient_id' value='<%=p_patient_id%>'>
<input type='hidden' name='gen_file_no' id='gen_file_no' value='<%=gen_file_no%>'>
                
</form>
<%
        }  else {
			p_clinic_code = request.getParameter("p_clinic_code") ;
            p_clinic_type =request.getParameter("p_clinic_type");
            p_patient_id = request.getParameter("p_patient_id");
            if(mode.equals("print")) {
				out.print("<script>parent.frames[0].location.href='../../eCommon/html/blank.html'</script>");
                int total=Integer.parseInt(request.getParameter("total"));
                String ReportOutput  = "" ;
                while(i<=total) {
					String rs_report_id=request.getParameter("report_id"+String.valueOf(i));
					String rs_module_id=request.getParameter("module_id"+String.valueOf(i));
                    String numofcopies=request.getParameter("numofcopies"+String.valueOf(i));
                    String chkval=  request.getParameter("reportchk"+String.valueOf(i));
                    if (rs_report_id==null) rs_report_id = "";
                    if (numofcopies==null) numofcopies = "";
					if (rs_module_id==null) rs_module_id = "";

                    if(chkval!=null &&chkval.equals("Y"))  {
						report1 = new ecis.utils.OnlineReport( facility_id, rs_module_id, rs_report_id, p_clinic_type, p_clinic_code ) ;
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
                    i++;
                }
                session.putValue( "online_reports", onlineReports ) ;
                       
                ReportOutput = onlineReports.execute( request, response );
						
                if ( ReportOutput.length() > 0 )
				{
					out.println("<HTML><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/'"+sStyle+"'></link></head><body onKeyDown = 'lockKey()'><br>"+ReportOutput+"<center><input type='button' type='Button' name ='ok' value='   OK   ' class='Button' onclick='parent.parent.window.close()'></center></body></html>");
				}
                else if ( ReportOutput.length() == 0 ) {
					out.println("<HTML><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/'"+sStyle+"'></link><script src='../../eCommon/js/common.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head> <body onKeyDown = 'lockKey()'> <center><br>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"REPORT_GENERATED","sm_messages")+"<br><form><input type='Button' name='ok' id='ok' value='   OK   ' class='Button' onclick='closewin()'> </center></form>   </body> </html>");
                }
			}
        }
    } catch(Exception e) { }
    finally {
	    if (pstmt != null)    pstmt.close();
        if (rset      != null)    rset.close();
        if(con!=null) ConnectionManager.returnConnection(con,request);  
    }
%>
</body>
</html>

