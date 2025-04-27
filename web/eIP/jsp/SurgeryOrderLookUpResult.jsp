<!DOCTYPE html>
<!--
   		 Developed By  :- Maheshwaran K for the CRF : RUT-CRF-0012 (23395	) as on 09/01/2013
   		 Function      :-  To Display the Surgery OT Order related to the Patient IDs
		 -->
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import= "webbeans.eCommon.*,java.util.*,java.text.*, java.sql.*" contentType="text/html;charset=UTF-8"%>
<jsp:useBean id="obj" scope="page"  class="webbeans.eCommon.XMLStringParser"/>
<%	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
function callMethod(start,end,patient_id,booking_ref_no)
	{
	var start1=parseInt(start);
	var end1=parseInt(end);
	var  HTMLVal = new String();
	HTMLVal = "<html><body onKeyDown='lockKey()'><form name='dum_form' id='dum_form' method='post' action='../../eIP/jsp/SurgeryOrderLookUpResult.jsp'><input type='hidden' name='patient_id' id='patient_id' value='"+patient_id+"'><input type='hidden' name='from' id='from' value="+start1+"><input type='hidden' name='to' id='to' value="+end1+"><input type='hidden' name='booking_ref_no' id='booking_ref_no' value="+booking_ref_no+"></form></body></html>";
	document.body.insertAdjacentHTML('afterbegin',HTMLVal);
	document.dum_form.submit();
	}
function ReturnSurgeryOrder(order_id,order_line_no,oper_code,oper_desc,oper_surg_date)
	{
	oper_desc=oper_desc.replace("#@","'");//Maheshwaran K added for the CRF : RUT-CRF-0012 (23395	)-linked [IN:038460] as on 08/03/2013
	window.returnValue = order_id+"$"+order_line_no+"$"+oper_code+"$"+oper_desc+"$"+oper_surg_date; 
	window.close();
	}
//Maheshwaran K added for the Inci No : RUT-SCF-0258 [IN:039356] as on 15/04/2013
//Start
window.onunload = function() {
if((window.returnValue==undefined)||(window.returnValue==""))
	{
	window.returnValue = ""+"$"+""+"$"+""+"$"+""+"$"+""; 
	}
}
//End
</script>
<HEAD>
<%
	request.setCharacterEncoding("UTF-8");
	String locale					= (String)session.getAttribute("LOCALE");
	String facilityID				= (String)session.getAttribute("facility_id");
	String all_surgeons=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.AllSurgeons.label","ot_labels") ;
	%>
  <body >
	<%
		String patient_id=request.getParameter("patient_id");
		String from = request.getParameter( "from"  );
		String to = request.getParameter( "to")  ;
		String booking_ref_no = checkForNull(request.getParameter( "booking_ref_no"))  ;
		int start = 0 ;
		int end = 0 ;
		int s=0;
		int i=1;
		if ( from == null )
		start = 1 ;
		else
		start = Integer.parseInt( from );
		if ( to == null )
		end = 10 ;
		else
		end = Integer.parseInt( to ) ;
		int maxRecord = 0;
		String order_id="";
		String order_line_no="";
		String oper_code="";
		String oper_desc="";
		String pref_surg_date="";
		String speciality_desc="";
		String team_surgeon_name="";
		%>	<input name='patient_id' id='patient_id' type='hidden' value =<%=patient_id%>>
		<input type=hidden name='from' id='from' value='<%=start%>'>
		<input type=hidden name='to' id='to' value='<%=end%>'>
		<input type=hidden name='booking_ref_no' id='booking_ref_no' value='<%=booking_ref_no%>'>
			<%
			Connection con = null;
			Statement stmt=null;
			ResultSet rset=null;
			try
				{
				con =ConnectionManager.getConnection(request); 
				try
					{
					String sql="SELECT a.order_id surg_order_id,c.order_line_no surg_order_line_no,b.oper_code oper_code,b.short_desc oper_desc, TO_CHAR (a.pref_surg_date, 'dd/mm/yyyy') pref_surg_date,a.speciality_desc speciality_desc,a.team_surgeon_name team_surgeon_name  FROM ot_pending_orders_vw a, ot_oper_mast_lang_vw b , ot_pending_order_line c WHERE a.language_id = '"+locale+"'  AND b.language_id = '"+locale+"' AND a.performing_facility_id = '"+facilityID+"' and b.order_catalog_code=c.order_catalog_code  and a.order_id=c.order_id  AND b.order_catalog_code IN (SELECT order_catalog_code   FROM ot_pending_order_line WHERE order_id = a.order_id AND ROWNUM = 1)  AND a.pref_surg_date BETWEEN TO_DATE (NVL (to_char(SYSDATE,'DD/MM/YYYY'), '01/01/1900') || '00:00','DD/MM/YYYY HH24:MI') AND TO_DATE (NVL ('', '01/01/3000') || '23:59','DD/MM/YYYY HH24:MI') and a.patient_id='"+patient_id+"' order by a.pref_surg_date desc";
					stmt=con.createStatement();
				rset=stmt.executeQuery(sql);
					}
				catch(SQLException e)	
					{
					System.out.println("Exception occurred while executing the query to get Surgery Order  : "+e);
					e.printStackTrace();
					}
			 
				try
					{
					if ( start != 1 )
					for( int j=1; j<start; i++,j++ )
					rset.next() ;
					if(rset!=null)
						{
						while( i<=end && rset.next()  )
							{
							if(maxRecord==0)
							{
							%>
							<table width='100%' border='0' align='center' >
								<tr>
									<td width='20%' align='right' class='NONURGENT'>
										<%
										if ( !(start <= 1) )
											{
											%>
											<a href="javaScript:callMethod('<%=start-10%>','<%=end-10%>','<%=patient_id%>','<%=booking_ref_no%>')" id='prev' text-decoration='none'><%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")%></a>
													
											<input type=hidden name='whichPage' id='whichPage' value='prev'><%
											}
										//if ( !( (start+3) > maxRecord ) )
								//		{
											%>
											<a href="javaScript:callMethod('<%=start+10%>','<%=end+10%>','<%=patient_id%>','<%=booking_ref_no%>')" id='next' style='visibility:hidden' text-decoration='none'><%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")%></a>
											
											<input type=hidden name='whichPage' id='whichPage' value='next'><%
									//		}%>
									</td>
								</tr>
							</table>
							<table border="1" width="100%" cellspacing='0' cellpadding='0'>
								<tr>
									<th><fmt:message key="eIP.SurgeryOrder.label" bundle="${ip_labels}"/></th>				
									<th><fmt:message key="eIP.SurgeryDate.label" bundle="${ip_labels}"/></th>
									<th><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></th>
									<th><fmt:message key="Common.Surgeon.label" bundle="${common_labels}"/></th>
								</tr>
							<%
							}
							order_id=rset.getString("surg_order_id");		
							order_line_no=rset.getString("surg_order_line_no");		
							oper_code=rset.getString("oper_code");		
							oper_desc=rset.getString("oper_desc");		
							pref_surg_date=com.ehis.util.DateUtils.convertDate(rset.getString("pref_surg_date"),"DMY","en",locale);		
							speciality_desc=rset.getString("speciality_desc");
							team_surgeon_name=rset.getString("team_surgeon_name");		
							boolean order_exists=CheckOTOrderExists(con ,facilityID,patient_id,order_id,booking_ref_no,order_line_no);
							%>
							<tr>
							<td>
							<%if(order_exists==true)
								{
								out.println(oper_desc);			
								}
							else
								{	
								String oper_desc1= oper_desc.replaceAll("'","#@");//Maheshwaran K added for the CRF : RUT-CRF-0012 (23395	)-linked [IN:038460] as on 08/03/2013
								%>
								<a href="javaScript:ReturnSurgeryOrder('<%=order_id%>',<%=order_line_no%>,'<%=oper_code%>','<%=oper_desc1%>','<%=pref_surg_date%>')"><%=oper_desc%></a>
								<%
								}
								%>
							</td>
							<td><%=pref_surg_date%></td>				
							<td><%=speciality_desc%></td>		
							<%if(team_surgeon_name==null)
								{
								%><td><%=all_surgeons%></td><%					
								}
							else
								{%>								
								<td><%=team_surgeon_name%></td>				
								<%
								}
								%>
							</tr>
							<%
							maxRecord++;
							i++;
							}
						}
					if(maxRecord==0)
					{
						/* out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common')); window.returnValue =''; window.close();</script>"); */
						out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common')); parent.parent.document.getElementById('dialog_tag').close();</script>");
					}
					if ((maxRecord < 3) ||(!rset.next()))
						{
						%>
						<script >
						if (document.getElementById("next"))
							document.getElementById("next").style.visibility='hidden';
						</script>
							<%
						}
						else
							{
							%>
						<script >
						if (document.getElementById("next"))
							document.getElementById("next").style.visibility='visible';
						</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>

							<%
							}
					rset.close();
					stmt.close();
					}
				catch(SQLException e)	
					{
					System.out.println("Exception occurred while getting the Surgery Order  : "+e);
					e.printStackTrace();
					}	
				}
			catch(Exception e) {out.println(e.toString());}
			finally
				{
				ConnectionManager.returnConnection(con,request); 
				}	
			%>
			
		</table>	
	</body>		
</html>
<%!
	//This Method is used to check whether OT Order already exists in IP_BOOKING_LIST for a particular Patient ID
	public boolean CheckOTOrderExists(Connection con ,String facilityID,String patient_id,String order_id,String booking_ref_no1,String order_line_no)
		{
		Statement ot_stmt=null;
		ResultSet ot_rset=null;
		boolean order_exists=false;
		String ot_sql="";
		try
			{
			if(booking_ref_no1.equals(""))
				{
				ot_sql="select count(*) as cnt from ip_booking_list where patient_id='"+patient_id+"' and facility_id='"+facilityID+"' and order_id='"+order_id+"' and order_line_no='"+order_line_no+"'";
				}
			else
				{
				ot_sql="select count(*) as cnt from ip_booking_list where patient_id='"+patient_id+"' and facility_id='"+facilityID+"' and order_id='"+order_id+"' and order_line_no='"+order_line_no+"' and BKG_LST_REF_NO!='"+booking_ref_no1+"'";
				}
			ot_stmt=con.createStatement();
			ot_rset=ot_stmt.executeQuery(ot_sql);
			ot_rset.next();
			int cnt=ot_rset.getInt("cnt");
			if(cnt>0)
				{
				order_exists=true;
				}
			ot_stmt.close();
			ot_rset.close();
			}
		catch(Exception e)	
			{
			System.out.println("Exception occurred while checking the ORDER ID exists in IP_BOOKING_LIST  : "+e);
			e.printStackTrace();
			}
		finally
			{
			try
				{if(ot_stmt!=null)
				ot_stmt.close();
				}
			catch(Exception e)	{}
			}
		return order_exists;	
		}

	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

