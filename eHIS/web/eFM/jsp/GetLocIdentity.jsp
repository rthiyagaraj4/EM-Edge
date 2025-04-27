<!DOCTYPE html>

<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*"  contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
request.setCharacterEncoding("UTF-8");
Connection con=null;
try
{
	con = ConnectionManager.getConnection(request);
	String fac_id  		= (String) session.getValue( "facility_id" ) ;
	String storage_location	= request.getParameter("storage_location");
	
	
	String sql="";
	String str1 = "";
	String str2 = "";
	String str3 = "";

	Statement stmt=null;
	ResultSet rs=null;
	
	stmt = con.createStatement() ;


	String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";


	out.println("<HTML><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link>	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></HEAD><body CLASS='MESSAGE' onKeyDown = 'lockKey()'><form name='testform' id='testform'>");
	
	if(!(storage_location.equals("")))
	{
	sql  = "SELECT LOCN_IDENTITY,MR_LOCN_YN, PERMANENT_FILE_AREA_YN FROM FM_STORAGE_LOCN WHERE  FACILITY_ID='"+fac_id +"' AND FS_LOCN_CODE='"+storage_location+"' AND EFF_STATUS='E' ";	
	rs  = stmt.executeQuery(sql) ;
	
			
	if( rs != null )
	{
		%>
		<script>
		

		</script>
		<%			
				while( rs.next() )
				{
					str1 = rs.getString( "LOCN_IDENTITY" ) ;
					str2 = rs.getString("MR_LOCN_YN");
					str3 = rs.getString("PERMANENT_FILE_AREA_YN");
					
					if(str1.equals("A"))
						str1="All";
					if(str1.equals("D"))
						str1="Department";
					if(str1.equals("C"))
						str1="Clinic";
					if(str1.equals("N"))
						str1="Nursing Unit";
					if(str1.equals("T"))
						str1="Doctor";
					if(str1.equals("E"))
						str1="External";

		%>
		<script>						

/* Added by Nanda on 06/07/2002 */

					var p_mr_locn_yn = '<%=str2%>';
					var p_per_area_yn = '<%=str3%>';

					if (p_mr_locn_yn=='N')
					{
										
						parent.frames[1].document.forms[0].assign_fs_locn.checked=false;
						parent.frames[1].document.forms[0].assign_fs_locn.disabled=true;

						parent.frames[1].document.forms[0].change_fs_locn.checked=false;
						parent.frames[1].document.forms[0].change_fs_locn.disabled=true;

						parent.frames[1].document.forms[0].change_return_date_yn.checked=false;
						parent.frames[1].document.forms[0].change_return_date_yn.disabled=true;

						parent.frames[1].document.forms[0].deficiency_check_yn.checked=false;
						parent.frames[1].document.forms[0].deficiency_check_yn.disabled=true;

						parent.frames[1].document.forms[0].file_lost_found_yn.checked=false;
						parent.frames[1].document.forms[0].file_lost_found_yn.disabled=true;

						parent.frames[1].document.forms[0].track_out_to_opd_yn.checked=false;
						parent.frames[1].document.forms[0].track_out_to_opd_yn.disabled=true;

						parent.frames[1].document.forms[0].track_out_to_ipw_yn.checked=false;
						parent.frames[1].document.forms[0].track_out_to_ipw_yn.disabled=true;

						parent.frames[1].document.forms[0].receive_file_yn.checked=false;
						parent.frames[1].document.forms[0].receive_file_yn.disabled=true;

						parent.frames[1].document.forms[0].return_file_yn.checked=false;
						parent.frames[1].document.forms[0].return_file_yn.disabled=false;

						parent.frames[1].document.forms[0].confirm_receipt_yn.checked=false;
						parent.frames[1].document.forms[0].confirm_receipt_yn.disabled=false;

						parent.frames[1].document.forms[0].transfer_file_yn.checked=false;
					//	parent.frames[1].document.forms[0].transfer_file_yn.disabled=true;
                        parent.frames[1].document.forms[0].transfer_file_yn.disabled=false;
					
						parent.frames[1].document.forms[0].req_yn.checked=false;
						parent.frames[1].document.forms[0].req_yn.disabled=false;
					
						parent.frames[1].document.forms[0].manual_request_yn.checked=false;
						parent.frames[1].document.forms[0].manual_request_yn.disabled=false;

						parent.frames[1].document.forms[0].cancel_request_yn.checked=false;
						parent.frames[1].document.forms[0].cancel_request_yn.disabled=false;

						parent.frames[1].document.forms[0].req_across_facilities_yn.checked=false;
						parent.frames[1].document.forms[0].req_across_facilities_yn.disabled=true;

						parent.frames[1].document.forms[0].iss_yn.checked=false;
						parent.frames[1].document.forms[0].iss_yn.disabled=true;

						parent.frames[1].document.forms[0].iss_across_facilities_yn.checked=false;
						parent.frames[1].document.forms[0].iss_across_facilities_yn.disabled=true;


						parent.frames[1].document.forms[0].CREATE_FILE_VOLUME_YN.checked=false;
						parent.frames[1].document.forms[0].CREATE_FILE_VOLUME_YN.disabled=true;

					}
					else
					{
						if(p_per_area_yn == 'Y')
						{
											
							parent.frames[1].document.forms[0].assign_fs_locn.checked=false;
							parent.frames[1].document.forms[0].assign_fs_locn.disabled=false;

							parent.frames[1].document.forms[0].change_fs_locn.checked=false;
							parent.frames[1].document.forms[0].change_fs_locn.disabled=false;

							parent.frames[1].document.forms[0].change_return_date_yn.checked=false;
							parent.frames[1].document.forms[0].change_return_date_yn.disabled=false;

							parent.frames[1].document.forms[0].deficiency_check_yn.checked=false;
							parent.frames[1].document.forms[0].deficiency_check_yn.disabled=false;

							parent.frames[1].document.forms[0].file_lost_found_yn.checked=false;
							parent.frames[1].document.forms[0].file_lost_found_yn.disabled=false;

							parent.frames[1].document.forms[0].track_out_to_opd_yn.checked=false;
							parent.frames[1].document.forms[0].track_out_to_opd_yn.disabled=false;

							parent.frames[1].document.forms[0].track_out_to_ipw_yn.checked=false;
							parent.frames[1].document.forms[0].track_out_to_ipw_yn.disabled=false;

							parent.frames[1].document.forms[0].receive_file_yn.checked=false;
							parent.frames[1].document.forms[0].receive_file_yn.disabled=false;

							parent.frames[1].document.forms[0].return_file_yn.checked=false;
							parent.frames[1].document.forms[0].return_file_yn.disabled=false;

							parent.frames[1].document.forms[0].confirm_receipt_yn.checked=false;
							parent.frames[1].document.forms[0].confirm_receipt_yn.disabled=false;

						//	parent.frames[1].document.forms[0].transfer_file_yn.checked=false;
							//parent.frames[1].document.forms[0].transfer_file_yn.disabled=false;

							parent.frames[1].document.forms[0].req_yn.checked=false;
							parent.frames[1].document.forms[0].req_yn.disabled=false;

							parent.frames[1].document.forms[0].manual_request_yn.checked=false;
							parent.frames[1].document.forms[0].manual_request_yn.disabled=false;  

							parent.frames[1].document.forms[0].cancel_request_yn.checked=false;
							parent.frames[1].document.forms[0].cancel_request_yn.disabled=false;

							parent.frames[1].document.forms[0].req_across_facilities_yn.checked=false;
							parent.frames[1].document.forms[0].req_across_facilities_yn.disabled=false;

							parent.frames[1].document.forms[0].iss_yn.checked=false;
							parent.frames[1].document.forms[0].iss_yn.disabled=false;

							parent.frames[1].document.forms[0].iss_across_facilities_yn.checked=false;
							parent.frames[1].document.forms[0].iss_across_facilities_yn.disabled=false;


							parent.frames[1].document.forms[0].CREATE_FILE_VOLUME_YN.checked=false;
							parent.frames[1].document.forms[0].CREATE_FILE_VOLUME_YN.disabled=false;
						}
						else if(p_per_area_yn == 'N')
						{
										
							parent.frames[1].document.forms[0].assign_fs_locn.checked=false;
							parent.frames[1].document.forms[0].assign_fs_locn.disabled=true;

							parent.frames[1].document.forms[0].change_fs_locn.checked=false;
							parent.frames[1].document.forms[0].change_fs_locn.disabled=true;

							parent.frames[1].document.forms[0].change_return_date_yn.checked=false;
							parent.frames[1].document.forms[0].change_return_date_yn.disabled=true;

							parent.frames[1].document.forms[0].deficiency_check_yn.checked=false;
							parent.frames[1].document.forms[0].deficiency_check_yn.disabled=true;

							parent.frames[1].document.forms[0].file_lost_found_yn.checked=false;
							parent.frames[1].document.forms[0].file_lost_found_yn.disabled=true;

							parent.frames[1].document.forms[0].track_out_to_opd_yn.checked=false;
							parent.frames[1].document.forms[0].track_out_to_opd_yn.disabled=true;

							parent.frames[1].document.forms[0].track_out_to_ipw_yn.checked=false;
							parent.frames[1].document.forms[0].track_out_to_ipw_yn.disabled=true;

							parent.frames[1].document.forms[0].receive_file_yn.checked=false;
							parent.frames[1].document.forms[0].receive_file_yn.disabled=true;

							parent.frames[1].document.forms[0].return_file_yn.checked=false;
							parent.frames[1].document.forms[0].return_file_yn.disabled=false;

							parent.frames[1].document.forms[0].confirm_receipt_yn.checked=false;
							parent.frames[1].document.forms[0].confirm_receipt_yn.disabled=false;

							parent.frames[1].document.forms[0].transfer_file_yn.checked=false;
						  //parent.frames[1].document.forms[0].transfer_file_yn.disabled=true;
                          parent.frames[1].document.forms[0].transfer_file_yn.disabled=false;
							parent.frames[1].document.forms[0].req_yn.checked=false;
							parent.frames[1].document.forms[0].req_yn.disabled=false;

							parent.frames[1].document.forms[0].manual_request_yn.checked=false;
							parent.frames[1].document.forms[0].manual_request_yn.disabled=false; 

							parent.frames[1].document.forms[0].cancel_request_yn.checked=false;
							parent.frames[1].document.forms[0].cancel_request_yn.disabled=false;

							parent.frames[1].document.forms[0].req_across_facilities_yn.checked=false;
							parent.frames[1].document.forms[0].req_across_facilities_yn.disabled=true;

							parent.frames[1].document.forms[0].iss_yn.checked=false;
							parent.frames[1].document.forms[0].iss_yn.disabled=true;  
                         
						
							parent.frames[1].document.forms[0].iss_across_facilities_yn.checked=false;
							parent.frames[1].document.forms[0].iss_across_facilities_yn.disabled=true; 

							parent.frames[1].document.forms[0].CREATE_FILE_VOLUME_YN.checked=false;
							parent.frames[1].document.forms[0].CREATE_FILE_VOLUME_YN.disabled=true;

						}
					}				
		            </script>

		<%
				}
	 }
		
	}
	else
	{
	%>
					<script>
					parent.frames[1].document.getElementById("storage_location").value="";
						
		            </script>

	<%
	}
	
	rs.close() ;
	if(stmt != null)	stmt.close();
	}
	
catch( Exception e ){}
finally
{			
		ConnectionManager.returnConnection(con,request);

}
		%>

</form>
</body>
</html>

