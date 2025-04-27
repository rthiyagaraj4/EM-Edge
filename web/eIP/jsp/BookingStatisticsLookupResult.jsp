<!DOCTYPE html>
<%@ page  contentType="text/html;charset=UTF-8"  import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*,java.net.*" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
	<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<script src='../../eCommon/js/dchk.js' language='javascript'></script>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<script>
			function closeWin(val)
			{
				window.parent.returnValue=val
				window.parent.close()
			}

			async function showModal(valu)
			{
				if(param.value !='returnval')
				{
				var retVal = 	new String();
				var dialogHeight= "1000px" ;
				var dialogWidth	= "1200px" ;
				var dialogTop = "80" ;
				var center = "1" ;
				var status="no";
				var features	= "dialogHeight:" + dialogHeight + "; scroll=no; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
				var arguments	= "" ;
				retVal = await window.showModalDialog("../jsp/AmendBookingMain.jsp?bookingRefNo="+valu ,arguments,features);
				parent.frames[1].document.location.reload();
				}
				else
				{
				parent.window.returnValue=valu ;
				parent.window.close();
				}
			}
			
			async function callCanRev(valu)
			{
				var dialogHeight= "80vh" ;
				var dialogWidth	= "75vw" ;
				var dialogTop = "80" ;
				var center = "1" ;
				var status="no";
				var features	= "dialogHeight:" + dialogHeight + "; scroll=no; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
				var arguments	= "" ;
				retVal = await window.showModalDialog("../jsp/AmendBookingMain.jsp?calling=AB&bookingRefNo="+valu ,arguments,features);
			}
		</script>
		<%
			request.setCharacterEncoding("UTF-8");
			Connection con = null;
			Statement stmt = null;
			ResultSet rs =null;
			
			Statement ipstmt = null;
			ResultSet iprs =null;
			String ipsql = "";
			String facility_id = (String)session.getValue("facility_id");
			StringBuffer where_criteria = new StringBuffer();
			String soundex_function = "";
			StringBuffer sql = new StringBuffer();
			String class_val = "QRYEVEN";
			String whereClause = request.getParameter("whereclause");
			String soundex_type	=request.getParameter("soundex");
			String nursing_unit_code=request.getParameter("nursing_unit");
			String speciality_code	=request.getParameter("Splcode");
			String practitioner_id	=request.getParameter("practid");
			String from_date	=request.getParameter("from_date");
			String to_date		=request.getParameter("to_date");
			String patient_id	=request.getParameter("patient_id");
			String gender		=request.getParameter("gender");
			String name_prefix	=request.getParameter("name_prefix");
			String name_suffix	=request.getParameter("name_suffix");
			String first_name	=request.getParameter("first_name");
			String second_name	=request.getParameter("second_name");
			String third_name	=request.getParameter("third_name");
			String family_name	=request.getParameter("family_name");
			
			String param=request.getParameter("param");
			if(param == null) param="";
			String call_function = request.getParameter("call_function");
			//AB -->Active Booking
			//CB --> Cancel Booking
			if( call_function == null )
				call_function ="";

			String patient_name	="";
			String nursing_unit_short_desc="";
			String bed_no="";
			String patient_id1="";
			String bkg_grace_period ="";
			
			
	%>
	</head>							
	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
			<%
			try{
				con =ConnectionManager.getConnection(request);
				stmt = con.createStatement();
				ipstmt = con.createStatement();
				if(whereClause==null)
				{
					if(soundex_type!=null)
					{
						if(soundex_type.equals("E"))
							soundex_function = "ethnic_soundex";
						else
							soundex_function = "soundex";
					}
					
					//facility_id
					if(where_criteria.length() > 0) where_criteria.delete(0,where_criteria.length());
					where_criteria.append(" and facility_id='"+facility_id+"'");

					//nursing_unit_code
					if(nursing_unit_code!=null && !nursing_unit_code.equals(""))
					{
						where_criteria.append(" and nursing_unit_code='"+nursing_unit_code+"' ");
					}

					//speciality_code
					if(speciality_code!=null && !speciality_code.equals(""))
					{
						where_criteria.append(" and specialty_code='"+speciality_code+"' ");
					}
					
					//practitioner_id
					if(practitioner_id!=null && !practitioner_id.equals(""))
					{
						where_criteria.append(" and practitioner_id='"+practitioner_id+"' ");
					}

					//from_date
					if(from_date!=null && !from_date.equals(""))
					{
						where_criteria.append(" and trunc(preferred_date) >= to_date('"+from_date+"' , 'dd/mm/rrrr') ");
					}
					
					//to_date
					if(to_date!=null && !to_date.equals(""))
					{
						where_criteria.append(" and trunc(preferred_date) <= to_date('"+to_date+"' , 'dd/mm/rrrr') ");
					}

					//patient_id
					if(patient_id!=null && !patient_id.equals(""))
					{
						where_criteria.append(" and patient_id like'"+patient_id+"%' ");
					}

					//gender
					if(gender!=null && !gender.equals(""))
					{
						where_criteria.append(" and gender='"+gender+"' ");
					}

					//name_prefix
					if(name_prefix!=null && !name_prefix.equals(""))
					{
						where_criteria.append(" and name_prefix='"+name_prefix+"' ");
					}

					//name_suffix
					if(name_suffix!=null && !name_suffix.equals(""))
					{
						where_criteria.append(" and name_suffix='"+name_suffix+"' ");
					}
					//first_name
					if(first_name!=null && !first_name.equals(""))
					{
						where_criteria.append(" and "+soundex_function+"(first_name) like "+soundex_function+"('"+first_name+"') || '%' ");
					}

					//second_name
					if(second_name!=null && !second_name.equals(""))
					{
						where_criteria.append(" and "+soundex_function+"(second_name) like "+soundex_function+"('"+second_name+"') || '%' ");
					}

					//third_name
					if(third_name!=null && !third_name.equals(""))
					{
						where_criteria.append(" and "+soundex_function+"(third_name) like "+soundex_function+"('"+third_name+"') || '%' ");
					}

					//family_name
					if(family_name!=null && !family_name.equals(""))
					{
						where_criteria.append(" and "+soundex_function+"(family_name) like "+soundex_function+"('"+family_name+"') || '%' ");
					}
				}
				else
				{
					if(where_criteria.length() > 0) where_criteria.delete(0,where_criteria.length());
					where_criteria.append(whereClause);
				}

				ipsql = "Select bkg_grace_period from ip_param where facility_id='"+facility_id+"' ";
				iprs = ipstmt.executeQuery(ipsql);
				if(iprs!= null)
				{
					if(iprs.next())
					{
						bkg_grace_period = iprs.getString("bkg_grace_period");
							if(bkg_grace_period == null) bkg_grace_period ="";
					}					
				}
				if(iprs!=null)   iprs.close();
				if(ipstmt!=null) ipstmt.close();
/*
				if(sql.length() > 0) sql.delete(0,sql.length());				
				sql.append(" select  count(*)");
				sql.append(" from ip_booking_list_vw where");
				sql.append(" booking_status='1' and trunc(preferred_date)>= trunc(sysdate-"+maxperiodforrevbkg+") " +where_criteria.toString());
				sql.append(" order by bkg_lst_ref_no, preferred_date");
				
				
				rs = stmt.executeQuery(sql.toString());
				rs.next();
	*/
				if(sql.length() > 0) sql.delete(0,sql.length());
				sql.append(" select bkg_lst_ref_no, preferred_date, to_char(preferred_date, 'dd/mm/rrrr')  ");
				sql.append("  disp_preferred_date, patient_id,");
				sql.append(" patient_name, nursing_unit_short_desc, bed_no from ip_booking_list_vw where");				

	
				if ( call_function.equals("CB") )
					sql.append(" ( ( booking_status ='1'  and trunc(preferred_date)<= trunc(sysdate))  or booking_status='9')  " +where_criteria.toString() );		
				else
					//sql+= " booking_status='1'  " +where_criteria ;
					sql.append(" booking_status='1' and trunc(preferred_date)>= trunc(sysdate- "+bkg_grace_period+") " +where_criteria.toString() );
						
						
				sql.append(" order by bkg_lst_ref_no, preferred_date");
						
				//out.println(sql.toString());		
				rs		= stmt. executeQuery(sql.toString());
	

				out.println(" <table cellspacing=0 cellpadding=0 align='center' width='100%' border='1' cellpadding=0 cellspacing=0>");
				
					out.println("<tr>");
						out.println("<th>&nbsp;</th>");
						out.println("<th>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.BookingRefNo.label","common_labels")+"</th>");
						out.println("<th>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PreferredDate.label","common_labels")+"</th>");
						out.println("<th>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.patientId.label","common_labels")+"</th>");
						out.println("<th>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.name.label","common_labels")+"</th>");
						out.println("<th>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nursingUnit.label","common_labels")+"</th>");
						out.println("<th>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.bedno.label","common_labels")+"</th>");
					out.println("</tr>");
					
					if(rs!=null)
					{
						while(rs.next())
						{
							
							patient_id1=rs.getString("patient_id");
							if(patient_id1 == null) patient_id1="&nbsp;";

							patient_name=rs.getString("patient_name");
							if(patient_name == null) patient_name="&nbsp;";

							nursing_unit_short_desc=rs.getString("nursing_unit_short_desc");
							if(nursing_unit_short_desc== null) nursing_unit_short_desc="&nbsp;";

							bed_no = rs.getString("bed_no");
							if( bed_no == null) bed_no="&nbsp;";


							if(class_val.equals("QRYEVEN"))
								class_val = "QRYODD";
							else
								class_val = "QRYEVEN";

							out.println("<tr>");
							/*	if ( call_function.equals("AB") )
								{*/
									out.println("<td class='"+class_val+"'><a href=\"javascript:callCanRev('"+rs.getString("bkg_lst_ref_no")+"')\">+</a></td>");
								
								out.println("<td class='"+class_val+"'>");
								if(param.equals("ADMIT") )
									out.println("<a href=\"javascript:closeWin('"+rs.getString("bkg_lst_ref_no")+"')\">");			
								else if(! (call_function.equals("AB") || call_function.equals("CB")) )
									out.println("<a href=\"javascript:showModal('"+rs.getString("bkg_lst_ref_no")+"')\">");
								out.println(rs.getString("bkg_lst_ref_no")+"</a></td>");

								out.println("<td class='"+class_val+"'>"+rs.getString("disp_preferred_date")+"</td>");
								out.println("<td class='"+class_val+"'>"+patient_id1+"</td>");
								out.println("<td class='"+class_val+"'>"+patient_name+"</td>");
								out.println("<td class='"+class_val+"'>"+nursing_unit_short_desc+"</td>");
								out.println("<td class='"+class_val+"'>"+bed_no+"</td>");
							out.println("</tr>");
						}
					}
	out.println("</table>");
	if (rs != null) rs.close();
	}catch(Exception e) {out.println(e.toString());}
	finally
	{
		if (rs != null) rs.close();
		if (stmt != null) stmt.close();
		if (ipstmt != null) ipstmt.close();
		ConnectionManager.returnConnection(con,request);
	}
				
	%>
	<input type='hidden' name='param' id='param' value='<%=param%>' >
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

