<!DOCTYPE html>
<%@ page  contentType="text/html;charset=UTF-8" import ="webbeans.eCommon.*,java.sql.*,eCommon.XSSRequestWrapper" %>
<%
	request.setCharacterEncoding("UTF-8"); 
	//MMS-ME-SCF-0096 vulnerability Issue
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff"); 
	//MMS-ME-SCF-0096 vulnerability Issue
	String strRole		= request.getParameter("role");	
	String strPractitionerId				= request.getParameter("pract_id");
	StringBuffer strSql = new StringBuffer();
	Connection con 		= null;
	PreparedStatement stmtPractType = null;
	ResultSet rsPractType	= null;
	String ID		= "";
	String dat		= "";

if(strRole.equals("med"))
{
	strSql.append(" SELECT a.short_desc short_desc ,a.team_id teamid FROM am_medical_team a,am_pract_for_team b WHERE a.facility_id ='C1' AND a.facility_id = b.facility_id AND b.practitioner_id ='"+strPractitionerId+"' AND b.team_id=a.team_id AND a.appl_for_ip_yn = 'Y' ORDER BY 1 ");
}
if(strRole.equals("2"))
{
	strSql.append("SELECT desc_userdef,pract_type from am_pract_type where eff_status='E' and pract_type in ('MD','SG','DN','PS','AN') order by 1 ");
}
if(strRole.equals("3"))
{
	strSql.append("SELECT desc_userdef,pract_type from am_pract_type where eff_status='E' and pract_type in ('MD','SG','DN','PS','AN','RD','PT','PL') order by 1 ");
}
if(strRole.equals("4"))
{
	strSql.append("SELECT desc_userdef,pract_type from am_pract_type where eff_status='E' and pract_type in ('MD','SG','DN','PS','AN','RD','PT') order by 1 ");
}
if(strRole.equals("5"))
{
	strSql.append("SELECT desc_userdef,pract_type from am_pract_type where eff_status='E' and pract_type in ('MD','SG','DN','PS','AN') order by 1 ");
}
if(strRole.equals("6"))
{
	strSql.append("SELECT desc_userdef,pract_type from am_pract_type where eff_status='E' and pract_type in ('TH','PH','DT','SW','PL') order by 1 ");
}
if(strRole.equals("7"))
{
	strSql.append("SELECT desc_userdef,pract_type from am_pract_type where eff_status='E' and pract_type in ('SG') order by 1 ");
}
if(strRole.equals("8"))
{
	strSql.append("SELECT desc_userdef,pract_type from am_pract_type where eff_status='E' and pract_type in ('MW','NS') order by 1 ");
}
if(strRole.equals("9"))
{
	strSql.append("SELECT desc_userdef,pract_type from am_pract_type where eff_status='E' and pract_type in ('TR','TN') order by 1 ");
}
String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>	
<html><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
</HEAD><body CLASS='MESSAGE' onMouseDown="CodeArrest()" onKeyDown="lockKey()"><form name='practtype' id='practtype'>
<%
	try
	{
		con = ConnectionManager.getConnection(request);
		stmtPractType =con.prepareStatement(strSql.toString());
		rsPractType = stmtPractType.executeQuery();
		if(rsPractType!=null)
			{
				while(rsPractType.next())
				{
					
					if(strRole.equals("med"))	
					{
						dat=rsPractType.getString("short_desc");
						ID  = rsPractType.getString(2);
					}
					else
					{
						dat=rsPractType.getString("desc_userdef");
						ID  = rsPractType.getString("pract_type");
					}
					
%>					<script>
						var element = parent.document.frames[1].document.frames[1].document.createElement('OPTION');
						element.text = "<%=dat%>";
						element.value= "<%=ID%>";
					</script>
		<%
					if(strRole.equals("med"))	
					{
							out.println("<script>parent.document.frames[1].document.frames[1].document.CompleteVisit_form.medical_team.add(element);</script>");	 
					}
					else
					{
						out.println("<script>parent.document.frames[1].document.frames[1].document.forms[0].pract_type.add(element);</script>");	 
					}
				}
	if(rsPractType !=null) rsPractType.close(); if(stmtPractType != null) stmtPractType.close();
			}


	}catch(Exception e){
		//out.print(e);
		e.printStackTrace();
	}
	finally{
	 ConnectionManager.returnConnection(con,request);
	}
%>
</form>
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

