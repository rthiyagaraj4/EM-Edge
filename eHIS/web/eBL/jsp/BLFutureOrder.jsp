<!DOCTYPE html>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@ page   import="java.sql.*,webbeans.eCommon.*,java.net.*,webbeans.op.CurrencyFormat, java.io.*,java.util.*,java.util.GregorianCalendar,java.util.Date,java.util.Calendar" contentType="text/html;charset=UTF-8" %>

<%
				try{
					request.setCharacterEncoding("UTF-8");
					 String patient_id = request.getParameter("patient_id");
					 String episode_type = request.getParameter("episode_type");

					 String episode_id = request.getParameter("episode_id");
					 String visit_id =request.getParameter("visit_id");
					 String facility_id = request.getParameter("facility_id");
					String retVal = "";
					System.out.println(patient_id);
					System.out.println(episode_type);
					System.out.println(episode_id);
					System.out.println("visit_id"+visit_id);
					System.out.println("facility_id"+facility_id);
					if(visit_id==null) visit_id= " ";
					if(episode_id ==null )episode_id =" ";

					
					System.out.println("visit_id111111111"+visit_id);
						Connection con = null;
						con	=	ConnectionManager.getConnection(request);	
						ResultSet rs=null;
						int count=0;
						
						String count_id_sql		="select count(*) from   bl_patient_charges_interface where patient_id='"+patient_id+"'"+
		    									   "and operating_facility_id='"+facility_id+"'"+
													"and (('"+episode_type+"'not in ('R','A','Q')) and episode_id=nvl("+episode_id+",episode_id) or('"+episode_type+"' in('R','A','Q')))"+											       		     
											       " and    (('"+episode_type+"' not in ('A','Q') and episode_type='"+episode_type+"') or  '"+episode_type+"' in ('A','Q')) "+
											       " and    (('"+episode_type+"' in ('O','E') and visit_id=nvl('"+visit_id+"',visit_id)) or '"+episode_type+"' not in ('O','E') )"+
											       " and    FUTURE_ORDER_YN ='Y' and    nvl(FUTURE_ORDER_CHARGE_LATER_YN,'N')='Y' and    trx_doc_ref is null" ; 
						
						
			
						Statement stmt = con.createStatement();
						 rs = stmt.executeQuery(count_id_sql);	

				if(rs.next())
				{
					
				   count  =  rs.getInt(1);
				   
				}
				
				if (count!= 0) {
					
					retVal = "Y";
				}else{
					retVal="N";
				}
				out.println(retVal);
				
			if(rs!=null)   rs.close();
			if(stmt!=null) stmt.close();
		con.close();
		}
		catch(Exception eX)
		{	
			//out.println("Error= "+eX);			
		}
	
					%>
						
			
