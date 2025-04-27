<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<html>
<%@ page contentType="text/html;charset=UTF-8"  import ="webbeans.eCommon.*,java.sql.*" %>
<script src='../../eCommon/js/dchk.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script language="JavaScript">
<!--
		function showPseudoBed(nursingunit)
		{
			var features	= "dialogHeight:18.5; dialogWidth:40; dialogTop:185;scroll=auto; status:no;"
			var arguments = "";
			var retVal = parent.window.showModalDialog("../../eIP/jsp/PseudoBedAvailabilityChart.jsp?nursing_unit_code="+nursingunit,arguments,features);
			if(retVal != null && retVal != 'F')
			{
				parent.frames[1].document.getElementById('pseudo_bed').value = retVal;
			}
			else 
			{
				//parent.window.close();
				parent.frames[1].document.getElementById('pseudo_bed').value="";
				parent.frames[1].document.getElementById('release_bed').value="N";
				parent.frames[1].document.getElementById('release_bed').checked=false;
			}
		}

		function showCreatePseudobed(nursingunit,nursingunitdesc)
		{
			/*
			var features	= "dialogHeight:32.5; dialogWidth:50; dialogTop:78;scroll=no; status:no;"
			var arguments = "";
			var retVal = parent.window.showModalDialog("../../eIP/jsp/PseudoBedCreation.jsp?module_id=IP&function_id=PSEUDO_BED&function_name=Create%20Pseudo%20Bed&function_type=F&access=NYNNN&from_modal=Y&nursing_unit="+nursingunit+"&nursing_unit_desc="+nursingunitdesc,arguments,features);
			if(retVal != null)
			{
				parent.frames[1].document.getElementById('pseudo_bed').value = retVal;
			}
			*/
			parent.frames[1].document.getElementById('pseudo_bed').readOnly = true;
			parent.frames[1].document.getElementById('generate_pseudo_bed').value = 'Y';
	   
			
		}
//-->
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
   Connection con = null;
   Statement stmt =  null;
   Statement stmt2 = null;
   ResultSet rs=null;
    ResultSet rset=null;
   String facilityid  = "";
   String currdate    = "";
   int 	  leaveperiod = 0;
   String leaveind    = "";
   int    maxleave    = 0;
   
   try{
   request.setCharacterEncoding("UTF-8");	
   con  = ConnectionManager.getConnection(request);
   stmt = con.createStatement();	 
   
   
   String to_date   = "";	
   
   currdate    = request.getParameter("currdate");
   leaveperiod = Integer.parseInt((request.getParameter("leaveperiod")==null?"0":request.getParameter("leaveperiod")));
   leaveind    = request.getParameter("leaveind");   
   
   maxleave = Integer.parseInt((request.getParameter("maxleave")==null?"0":request.getParameter("maxleave")));
   facilityid  = (String)session.getValue("facility_id");
   
   String operation = request.getParameter("operation") ;
   
   if(operation == null)
   {
	   
	   //out.println("<script>alert('"+leaveind+"');</script>");
	   //out.println("<script>alert('"+maxleave+"');</script>");
	   //out.println("<script>alert('"+leaveperiod+"');</script>");
	   
	   try{
		
		String LeaveSql = "SELECT  to_char((to_date('"+currdate+"','dd/mm/yyyy hh24:mi')+'"+leaveperiod+"'/decode('"+leaveind+"','D',1,24)),'dd/mm/yyyy hh24:mi') to_date, to_date('"+currdate+"','dd/mm/yyyy hh24:mi')+'"+leaveperiod+"'/decode('"+leaveind+"','D',1,24) act_dt  from dual";
		
		//out.println(LeaveSql);
		boolean chk = true ;
		rs = stmt.executeQuery(LeaveSql);    
		rs.next();
		
			to_date = rs.getString("to_date");	
			Timestamp ts = rs.getTimestamp("act_dt") ;
			
			Timestamp currdate1 = new Timestamp(System.currentTimeMillis());
			out.println(ts+"\n"+currdate1+"\n"+ts.before(currdate1) +"\n");
			if(to_date == null ) to_date = "";		
			else if(ts.before(currdate1))
					chk=false;
		
	%>
		<script>
			parent.frames[1].document.getElementById('to_date1').innerText = '<%=to_date%>' ;	  		  		
			parent.frames[1].document.forms[0].to_date.value = '<%=to_date%>' ;
			
			if (!<%=chk%> && !parent.frames[1].document.forms[0].leaveperiod.readOnly)
			{
				alert(getMessage("INVALID_LEAVE_REVISE","Common"));
				//parent.frames[1].document.forms[0].leaveperiod.focus();
			}
		</script>
	<%
			/*Valid Leave Check*/	
			
			   //out.println("<script>alert('"+leaveind+"');</script>");
			
			if(leaveind.equals("D"))
			{     
				if ((maxleave / 24) < leaveperiod) 
				{
					out.println("<script>alert(getMessage('LEAVE_LT_DAYS_XCEED','Common'));</script>");
					out.println("<script>parent.frames[1].document.forms[0].leaveperiod.focus();</script>");
					//out.println("<script>parent.frames[1].document.forms[0].leaveperiod.select();</script>");
				} 
			}	
			else
			{
				  if (maxleave < leaveperiod) 
				  {
					out.println("<script>alert(getMessage('LEAVE_LT_HRS_XCEED','Common'));</script>");	    	
					//out.println("<script>parent.frames[1].document.forms[0].leaveperiod.focus();</script>");
					out.println("<script>parent.frames[1].document.forms[0].leaveperiod.select();</script>");
				  } 
					
			} 	  	  
		}catch(Exception e){
			out.println("error " + e);
			e.printStackTrace();
		}
		finally
		{
		   if (rs!=null) rs.close();
		   if (stmt!=null) stmt.close();
		   
		}
   }
   else if(operation.equals("pseudo_bed"))
   {
		String nursing_unit	 = request.getParameter("nursing_unit_code");
		String sql = " Select Allow_Pseudo_Bed_YN, Generate_Pseudo_Bed_Srl_YN,NURSING_UNIT_SHORT_DESC from Ip_Nursing_Unit_VW where Nursing_Unit_Code= '"+nursing_unit+"' and facility_id='"+facilityid+"'";
		String genpseudobedno="";
		//out.println(sql);
		try
	    	{
			stmt = con.createStatement();
			stmt2 = con.createStatement();
			
			rs	= stmt.executeQuery(sql);
			if(rs.next())
			{
				String allow_pseudo_bed_yn = rs.getString("Allow_Pseudo_Bed_YN")==null?"N":rs.getString("Allow_Pseudo_Bed_YN");
				String nursingunitdesc = rs.getString("NURSING_UNIT_SHORT_DESC");
				if(allow_pseudo_bed_yn.equals("N"))
				{
					out.println("<script>parent.frames[1].document.getElementById('release_bed').disabled=true; alert(getMessage('NU_PSEUDO_BED_NOT_ALLOWED','Common'));parent.frames[1].document.getElementById('release_bed').checked=false;parent.frames[1].document.getElementById('release_bed').value='N'</script>");
				}
				else
				{
					if(rs.getString("Generate_Pseudo_Bed_Srl_YN").equals("Y"))
					{
			String selectnosql = " SELECT PREFIX_FOR_PSEUDO_BED_SRL_NO,NVL(NEXT_PSEUDO_BED_SRL,0) NEXT_PSEUDO_BED_SRL ,NVL(MAX_PSEUDO_BED_SRL,0) MAX_PSEUDO_BED_SRL "+
							" FROM IP_NURSING_UNIT "+
							" WHERE NURSING_UNIT_CODE = '"+nursing_unit+"'  and facility_id='"+facilityid+"' " ;
						
					if(stmt!=null)	stmt.close();
					if(rs!=null)	rs.close();
					
					


				 rset = stmt2.executeQuery(selectnosql);
					if(rset.next())
					{
						if(rset.getInt("NEXT_PSEUDO_BED_SRL") > rset.getInt("MAX_PSEUDO_BED_SRL"))
						{
						out.println("<script>alert('Max Bed Number reached');</script>");						
						}
						else
						{
						String PREFIX_FOR_PSEUDO_BED_SRL_NO = rset.getString("PREFIX_FOR_PSEUDO_BED_SRL_NO");
						String NEXT_PSEUDO_BED_SRL = rset.getString("NEXT_PSEUDO_BED_SRL");

						if(PREFIX_FOR_PSEUDO_BED_SRL_NO == null || PREFIX_FOR_PSEUDO_BED_SRL_NO.equals("null"))PREFIX_FOR_PSEUDO_BED_SRL_NO="";
						if(NEXT_PSEUDO_BED_SRL == null || NEXT_PSEUDO_BED_SRL.equals("null"))NEXT_PSEUDO_BED_SRL="";

						if(!PREFIX_FOR_PSEUDO_BED_SRL_NO.equals(""))
						{
							genpseudobedno = PREFIX_FOR_PSEUDO_BED_SRL_NO+NEXT_PSEUDO_BED_SRL;
							out.println("<script>parent.frames[1].document.getElementById('pseudo_bed').value='"+genpseudobedno+"'</script>");
						}
						else
						{
							genpseudobedno = NEXT_PSEUDO_BED_SRL;
							out.println("<script>parent.frames[1].document.getElementById('pseudo_bed').value='"+genpseudobedno+"'</script>");
						}
						
						
						}
					
					}
						
						
						out.println("<script>showCreatePseudobed('"+nursing_unit+"','"+nursingunitdesc+"')</script>");
					}
					else
					{
						out.println("<script>showPseudoBed('"+nursing_unit+"')</script>");
					}
				}
			}
	   }
	   catch(Exception e)
	   {
		   out.println(e.toString());
	   }
	   finally
	   {
			if(rs!=null)	rs.close();			
			if(stmt!=null)	stmt.close();
			
	   }
   }
   else
   {
   		String nursing_unit	 = request.getParameter("nursing_unit_code");
		String bed_no			 = request.getParameter("bed_no");
		String sql = "select room_no, bed_class_long_desc, bed_class_code,bed_type_code,room_no from ip_nursing_unit_bed_vw where nursing_unit_code='"+nursing_unit+"' and bed_no='"+bed_no+"' and facility_id='"+facilityid+"'";
		try
	    {
			stmt = con.createStatement();
			rs	= stmt.executeQuery(sql);
			if(rs!=null)
			{
				if(rs.next())
				{
					 String room_no= rs.getString(1);
					 String bed_class = rs.getString(2);
					 String bed_class_code=rs.getString(3);
					 String bed_type_code=rs.getString(4);
					 if(room_no==null) room_no="";
					 if(bed_class==null) bed_class="";
					 if(bed_class_code==null) bed_class_code="";
					 
					 
					 //sql = select 
					%>
						<script>
							var obj= parent.frames[1].document.forms[0]
							 obj.room_no.value = '<%=room_no%>'
							 obj.disp_room_no.value = '<%=room_no%>'
							 obj.Bedcode.value = '<%=bed_class_code%>'
							 obj.bed_type_code.value = '<%=bed_type_code%>'
						</script>
					<%
				}
				else
				{
					%>
						<script>
							//document.write("invalid bed no");
							alert(getMessage('INVALID_BED','Common'));
							var obj= parent.frames[1].document.forms[0]	
							 obj.bed_class_code.value = ''
							 obj.bed_type_code.value = ''
							 obj.room_no.value = ''	
							 obj.disp_room_no.value = ''
							 obj.bed_no.focus();
							 obj.bed_no.select();
						</script>
					<%
				}
						if(rs!=null)	rs.close();
			}
			sql = " SELECT 1 FROM IP_BED_BOOKING WHERE BOOKING_TYPE = 'B' AND OVERRIDE_YN = 'N' and REQ_NURSING_UNIT_CODE='"+nursing_unit+"' and REQ_BED_NO='"+bed_no+"' and facility_id='"+facilityid+"'";
//out.println(sql);
			rs	= stmt.executeQuery(sql);
			if(rs!=null && rs.next())
			{
					%>
						<script>
							alert(getMessage('INVALID_BED','Common'));
						</script>
					<%
			}

	   }
	   catch(Exception e)
	   {
		   out.println(e.toString());
	   }
	   finally
	   {
			if(rs!=null)	rs.close();
			if(rset !=null) rset.close();
			if(stmt!=null)	stmt.close();
			if(stmt2 !=null) stmt2.close();
	   }
   }
   }catch(Exception e){}
   finally
   {
   	ConnectionManager.returnConnection(con,request);
   }	
%>
</html>

