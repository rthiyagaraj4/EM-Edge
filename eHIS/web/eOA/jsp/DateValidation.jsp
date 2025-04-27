<!DOCTYPE html>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,webbeans.eCommon.*" %>
<%
request.setCharacterEncoding("UTF-8");	

				String date = request.getParameter("date");
				String flag=request.getParameter("flag");
				String changed_date=request.getParameter("changed_date");
				String callingMode=request.getParameter("callingMode");
				String FrmNo=request.getParameter("FrmNo");

				Connection con = null;
				Statement stmt = null;
				PreparedStatement pstmt=null;
				ResultSet rs = null;
				ResultSet rs1=null;
				String wd1="";
				String wd2="";
				String wd3="";
				String sql="";
try
{

	con = ConnectionManager.getConnection(request);
				 stmt = con.createStatement();
		if(flag.equals("right")){

		//sql="SELECT replace(to_char(TO_DATE('"+date+"','Day,Month,dd,yyyy'),'Day,Month,dd,yyyy'),' ','') date_val ,to_char(to_date('"+changed_date+"','dd/mm/yyyy'),'dd/mm/yyyy')day1 from dual";
		sql="SELECT replace(to_char(TO_DATE(?,'Day,Month,dd,yyyy'),'Day,Month,dd,yyyy'),' ','') date_val ,to_char(to_date(?,'dd/mm/yyyy'),'dd/mm/yyyy')day1 from dual";
}
		else

		if(flag.equals("left")){

		sql="SELECT replace(to_char(TO_DATE(?,'Day,Month,dd,yyyy'),'Day,Month,dd,yyyy'),' ','') date_val,to_char(to_date(?,'dd/mm/yyyy'),'dd/mm/yyyy')day1 from dual";
}
		//rs = stmt.executeQuery(sql);
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1,date);
		pstmt.setString(2,changed_date);
		rs = pstmt.executeQuery();
		while(rs.next())
		{
			wd1 = rs.getString("date_val");
			wd2=rs.getString("day1");
		}
		String sql2="select to_date('"+wd2+"', 'dd/mm/yyyy') - to_date(to_char(sysdate, 'dd/mm/yyyy'),'dd/mm/yyyy') dat_val2 from dual";
		rs1=stmt.executeQuery(sql2);
		rs1.next();
		wd3=rs1.getString("dat_val2");
		int check=Integer.parseInt(wd3);

		if(check >= 0 )
		{
			String a1="<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>";
			
			if(callingMode.equals("OP") || callingMode.equals("OR") || callingMode.equals("CA"))
			{	
				if(FrmNo.equals("1"))
				{
			
					a1=a1+"parent.document.frames[0].document.forms[0].gggg.value='"+wd1+"';	parent.frames[0].document.forms[0].changed_date.value='"+wd2+"';</script></head><body CLASS='MESSAGE' onKeyDown = 'lockKey()'></body></html>";
			
				}else if(FrmNo.equals("2"))
				{
				   a1=a1+"parent.document.frames[1].document.frames[0].document.forms[0].gggg.value='"+wd1+"';	parent.document.frames[1].document.frames[0].document.forms[0].changed_date.value='"+wd2+"';</script></head><body CLASS='MESSAGE' onKeyDown = 'lockKey()'></body></html>";	
				}else if(FrmNo.equals("3"))
				{
					a1=a1+"parent.document.frames[1].document.frames[0].document.forms[0].gggg.value='"+wd1+"';	parent.document.frames[1].document.frames[0].document.forms[0].changed_date.value='"+wd2+"';</script></head><body CLASS='MESSAGE' onKeyDown = 'lockKey()'></body></html>";		
				}
			}else
			{			
			  a1=a1+"parent.frames[1].document.frames[1].document.frames[0].document.forms[0].gggg.value='"+wd1+"';		parent.frames[1].document.frames[1].document.frames[0].document.forms[0].changed_date.value='"+wd2+"';</script></head><body CLASS='MESSAGE' onKeyDown = 'lockKey()'></body></html>";	
			}
				String a2="<html><head>	<link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link><script></script></head><body CLASS='MESSAGE' onKeyDown = 'lockKey()'></body></html>";
				 out.println(a2);
		}else{

			String a1="<html><head>	<link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link><script></script></head><body CLASS='MESSAGE' onKeyDown = 'lockKey()'></body></html>";
			out.println(a1);
			
		}
		
		
	if (rs != null) rs.close();
	if (rs1 != null) rs1.close();
	if (stmt != null) stmt.close();
}catch(Exception e) {
 //out.println(e.toString());
e.printStackTrace();//Added by Kamatchi S for security issue against COMMON-ICN-0165
}
finally
{
	
	ConnectionManager.returnConnection(con,request);
}
%>



