<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% 
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
	request.setCharacterEncoding("UTF-8");
	%>

<html>
<head>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>">
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
	<Script language='javascript' src='../../eCommon/js/common.js'></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
	<script>
		function query()
		{
			frames[1].location.href='../../eMP/jsp/blank.jsp?step_1=4&module_id=MP';
		}
	</script>
</head>
<%



	if(request.getParameter("step").equals("1") )
	{	
		out.println("<html><head>");
		String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
		String params = request.getQueryString() ;
		String source = url + params ;
		out.println("</head><iframe name='commontoolbarFrame' id='commontoolbarFrame'	src='"+source+"' frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe><iframe name='f_query_add_mod' id='f_query_add_mod' src='../../eMP/jsp/blank.jsp?step_1=4' frameborder=0 scrolling='auto' style='height:83vh;width:100vw'></iframe><iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:9vh;width:100vw'></iframe></html>");
	}
	else if(request.getParameter("step").equals("2"))
	{
		String patient_id	=  request.getParameter("patient_ID");
		String module_id	= request.getParameter("module_id");
		String facility_id	= (String)session.getValue("facility_id");

		String pat_ser_grp_code		= "";
		String inhouse_birth_yn		= "";
		String deceased_yn		= "";
		String maintain_doc_or_file = "";
		String file_no				= "";
		String sqlString			= "";
		Boolean isStillBornRepReprintAppl = false;//Added by Thamizh selvi on 3rd Jan 2019 against ML-MMOH-CRF-1245
		
		Connection con			= null;
		java.sql.Statement stmt	= null;
		ResultSet rset			= null;
	
		try
		{
			con		= ConnectionManager.getConnection(request);

			isStillBornRepReprintAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "MP","STILL_BORN_REPORTS_REPRINT");//Added by Thamizh selvi on 3rd Jan 2019 against ML-MMOH-CRF-1245

			stmt	= con.createStatement();
			rset	= stmt.executeQuery("SELECT pat_ser_grp_code, INHOUSE_BIRTH_YN, deceased_yn FROM MP_PATIENT where patient_id = '"+patient_id+"'") ;
			
			if (rset.next())
			{
				pat_ser_grp_code = rset.getString(1);
				inhouse_birth_yn = rset.getString(2);
				deceased_yn = rset.getString(3);
			}
			if(rset!=null) rset.close();
			if(stmt!=null) stmt.close();

			stmt	= con.createStatement();
			rset	= stmt.executeQuery("SELECT maintain_doc_or_file FROM mp_param where module_id='MP'") ;
			if(rset.next())
			{
				maintain_doc_or_file = rset.getString(1);
				if(maintain_doc_or_file == null || maintain_doc_or_file.equals("null")) 
					maintain_doc_or_file = "F";
			}
			if(rset!=null) rset.close();
			if(stmt!=null) stmt.close();

			if(maintain_doc_or_file.equals("D"))
			{
				file_no = "";
			}
			else
			{
				stmt = con.createStatement();
				rset = stmt.executeQuery("SELECT file_no FROM mr_pat_file_index WHERE patient_id = '"+patient_id+"' AND facility_id = '"+facility_id+"'") ;
		
				if(rset.next())
				{
				   file_no = rset.getString(1);
					if(file_no == null || file_no.equals("null")) file_no = "";
				}
			}
			
			if(inhouse_birth_yn.equals("N"))
			{  /* in below line  this report MPBNBWBL id added by venkatesh.S on 11/12/2012 against 36610 */
				sqlString = "SELECT distinct A.report_id,B.report_desc, 1 no_of_copies, b.module_id FROM mp_online_reports A, sm_report_lang_vw B, sm_print_routing c WHERE a.pat_ser_grp_code = '"+pat_ser_grp_code+"' and B.report_id=A.report_id AND a.report_id = c.report_id (+) and NVL(c.facility_id,'"+facility_id+"')='"+facility_id+"' and A.report_id in ('MPBWBLBL', 'MPBFRNST', 'MPBIDLBL','MPBSTLBL','MPBPTLBL','MPBPTLBL'";

				if(deceased_yn.equals("Y"))
					sqlString = sqlString + " ,'MPDTHCER'";
				if(!file_no.equals(""))
					sqlString = sqlString + " ,'MPBFLLBL'";

				sqlString = sqlString + " ,'MPBIDLBG') and b.language_id = '"+localeName+"' order by 2"; 


				
			}else{	 /* in below line this report MPBNBWBL id added by venkatesh.S on 11/12/2012 against 36610.1 */
				sqlString = "select distinct A.report_id,B.report_desc, 1 no_of_copies, b.module_id from mp_online_reports A, sm_report_lang_vw B, sm_print_routing c where a.pat_ser_grp_code = '"+pat_ser_grp_code+"' and B.report_id=A.report_id and a.report_id = c.report_id (+) and NVL(c.facility_id,'"+facility_id+"')='"+facility_id+"' and A.report_id in ('MPBNBFRM', 'MPBWBLBL','MPBFRNST', 'MPBIDLBL','MPBSTLBL','MPBNBWBL','MPBPTLBL'";//Birth Certifiacte is reomved from internal reports based on PMG CRF--689 & 695
				//sqlString = "select distinct A.report_id,B.report_desc, 1 no_of_copies, b.module_id from mp_online_reports A, sm_report_lang_vw B, sm_print_routing c where a.pat_ser_grp_code = '"+pat_ser_grp_code+"' and B.report_id=A.report_id and a.report_id = c.report_id (+) and NVL(c.facility_id,'"+facility_id+"')='"+facility_id+"' and A.report_id in ('MPBNBFRM', 'MPBWBLBL','MPBFRNST', 'MPBIDLBL','MPBIRCER'";
				//sqlString = "select distinct A.report_id,B.report_desc, 1 no_of_copies, b.module_id from mp_online_reports A, sm_report_lang_vw B, sm_print_routing c where a.pat_ser_grp_code = '"+pat_ser_grp_code+"' and B.report_id=A.report_id and a.report_id = c.report_id (+) and NVL(c.facility_id,'"+facility_id+"')='"+facility_id+"' and A.report_id in ('MPBFLLBL','MPBFRNST','MPBIDLBG','MPBIDLBL','MPBWBLBL') and b.language_id = '"+localeName+"' order by 2";//changed for PMG CRF-695

				String nbSQL="select outcome from mp_birth_register where patient_id='"+patient_id+"'";
				stmt	= con.createStatement();
				rset	= stmt.executeQuery(nbSQL);
				String outCome="";
				if(rset!=null && rset.next()){
					outCome=rset.getString("outcome");
				}
				if(outCome=="" || outCome==null || outCome=="null")
					outCome="";
				if(rset!=null) rset.close();
				if(stmt!=null) stmt.close();
				if(deceased_yn.equals("Y"))
					sqlString = sqlString + " ,'MPDTHCER'";
				if(!file_no.equals(""))
					sqlString = sqlString + " ,'MPBFLLBL'";
				sqlString = sqlString + " ,'MPBIDLBG') and b.language_id = '"+localeName+"' order by 2";
				String CUSTOMER_ID=(String)session.getAttribute("CUSTOMER_ID");
				if(outCome.equals("S") && !CUSTOMER_ID.equals("SRR") && !isStillBornRepReprintAppl){%><!--Modified by Thamizh selvi on 3rd Jan 2019 against ML-MMOH-CRF-1245-->
					<script>
						alert(getMessage("REPRINT_STILL_BORN_BABY","MP"));			
						parent.frames[1].location.href='../../eMP/jsp/blank.jsp?step_1=4&module_id=MP';
					</script>
				<%}
			}
			String reportParamNames		= "p_patient_id,p_file_no";
			String reportParamValues	= ""+patient_id+","+file_no+"";
			StringBuffer htmlFor = null;
			htmlFor = new StringBuffer();

			htmlFor.append(" <html><head> <link rel='stylesheet' type ='text/css' href='../../eCommon/html/"+sStyle+"'></link>");
			htmlFor.append(" </head><body class='message' onKeyDown='lockKey()'>");
			htmlFor.append(" <script language = 'JavaScript'>");
			htmlFor.append(" var dialogHeight = '450px' ;");
			htmlFor.append(" var dialogWidth = '700px' ;");
			htmlFor.append(" var dialogTop = '65' ;");
			htmlFor.append(" var arguments = ''; ");
			//modified the below line by Abirami - Bru-HIMS-CRF-313 / Passing function id in the Query String.
			htmlFor.append(" var getUrl =  '../../eCommon/jsp/InternalReportsPrint.jsp?P_function_id=ONLINE_REPORT&step=1&sqlString="+java.net.URLEncoder.encode(sqlString)+"&Patient_ID="+patient_id+"&reportParamNames="+reportParamNames+"&reportParamValues="+reportParamValues+"';");
			htmlFor.append(" var features = 'dialogTop:'+ dialogTop +'; dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; status=no;' ;");
			htmlFor.append(" retVal = window.showModalDialog(getUrl,arguments,features); ");
			htmlFor.append(" </script>");
			
			out.println(htmlFor.toString());
		
			if(htmlFor != null && htmlFor.length() > 0)
			{
				htmlFor.delete(0,htmlFor.length());
			}
			 //out.println("<script>window.location.href='../../eMP/jsp/blank.jsp?step_1=4&module_id="+module_id+"';</script></body></html>");

			if (rset != null) rset.close();
			if (stmt != null) stmt.close();
		}
		catch(Exception e) 
		{
			e.printStackTrace();
			out.println("Error here");
		}
		finally
		{
			if(con!=null) ConnectionManager.returnConnection(con,request);
		}
	}
%>
</html>
<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString == null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

