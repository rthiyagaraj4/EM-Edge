<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<%
		request.setCharacterEncoding("UTF-8");
		String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script src='../../eCA/js/DisDataCharting.js' language='javascript'></SCRIPT>
<script src='../../eCommon/js/messages.js' language='javascript'></SCRIPT>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<BODY  class='CONTENT' OnMouseDown='CodeArrest()'  onKeyDown = 'lockKey()'>
		<%!
			ResultSet rs=null;
			PreparedStatement  stmt=null;
		%>
	
	<%
			Connection con =null;
			try{
				con = ConnectionManager.getConnection(request);
				String date = request.getParameter("date");
				String flag=request.getParameter("flag");
				String patient_id = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
				String newDate="";
				String sql="";
				
				if(!flag.equals("go")){
					if(flag.equals("right")){
						//sql="SELECT to_char(to_date('"+date+"','dd/mm/yyyy')+1,'dd/mm/yyyy') from dual";//common-icn-0180
						sql="SELECT to_char(to_date(?,'dd/mm/yyyy')+1,'dd/mm/yyyy') from dual"; //common-icn-0180
					}
					else if(flag.equals("left")){
						//sql="SELECT to_char(to_date('"+date+"','dd/mm/yyyy')-1,'dd/mm/yyyy') from dual";//common-icn-0180
						sql="SELECT to_char(to_date(?,'dd/mm/yyyy')-1,'dd/mm/yyyy') from dual";//common-icn-0180
					}
					stmt = con.prepareStatement(sql);
					//common-icn-0180 starts
					if(flag.equals("right")){
					stmt.setString(1,date);
					}
					else if(flag.equals("left")){
					stmt.setString(2,date);
					}
					//common-icn-0180 ends
					rs = stmt.executeQuery();
					while(rs.next()){
						newDate = rs.getString(1);
					}
					String a1con="<script>top.content.workAreaFrame.titleFrame.document.forms[0].date.value='"+newDate+"';</script>";
					out.println(a1con);
				
				}else{
					
					sql="select distinct to_char(TEST_OBSERV_DT_TM,'hh24:mi:ss') from ca_encntr_discr_msr where patient_id=? and TEST_OBSERV_DT_TM  between to_date(?,'dd/mm/yyyy') and to_date(?,'dd/mm/yyyy') +.9999";

					stmt = con.prepareStatement(sql);
					stmt.setString(1,patient_id);
					stmt.setString(2,date);
					stmt.setString(3,date);
					rs = stmt.executeQuery();
					
					String fill="<script> var str='Time Stamp <select name=time onchange=loadMainPage(\"Error\")>';";
		
					if(rs.next()){
						do{
							fill=fill + "str+='<option value="+rs.getString(1)+">"+rs.getString(1)+"</option>';";
						}while(rs.next());
							if(rs !=null) rs.close();
							if(stmt !=null) stmt.close();
							fill=fill + "str+='</select>'; top.content.workAreaFrame.titleFrame.document.getElementById('idtime').innerHTML=str; top.content.workAreaFrame.titleFrame.loadMainPage(\"Error\");</script>";
						}else{
						         fill="<script>top.content.workAreaFrame.titleFrame.document.getElementById('idtime').innerHTML='';alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','COMMON'));</script>";
					}
					out.println(fill);
				}
		
			if(rs !=null) rs.close();
			if(stmt !=null) stmt.close();
		}catch(Exception e){}
		finally{
					if(con!=null)ConnectionManager.returnConnection(con,request);
				}
	%>
	</body>
</html>

