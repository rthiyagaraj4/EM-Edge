<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" import ="java.sql.Connection,java.sql.Statement,java.sql.ResultSet,webbeans.eCommon.*,java.util.HashMap,java.sql.*,java.util.*"%>
<jsp:useBean id="AgeGroupForTermCode" class="webbeans.eCommon.RecordSet" scope="session"/> 

<%
request.setCharacterEncoding("UTF-8");
Connection con	= null;
PreparedStatement pstmt	= null;
ResultSet rs = null;
String sqlData="";

//* 1/10/2009 implemeting the remove session value

String _clearSession =	request.getParameter("_clearSession")==null?"":request.getParameter("_clearSession");

String ageGroupCode=request.getParameter("ageGroupCode")==null?"":request.getParameter("ageGroupCode");

try
{

	con = ConnectionManager.getConnection(request);

if(ageGroupCode.equals("1")){
	
	String ageCodes="";
	String term_set_id = request.getParameter("term_set_id")==null?"":request.getParameter("term_set_id");
	String age_group_code = request.getParameter("age_group_code")==null?"":request.getParameter("age_group_code");

	String sql="select term_code from  mr_age_grp_for_term_code a, am_age_group b where a.age_group_code=b.age_group_code and a.term_set_id=? and a.age_group_code != ?  ";
	pstmt = con.prepareStatement(sql);
	pstmt.setString(1,term_set_id);
	pstmt.setString(2,age_group_code);
	
	rs = pstmt.executeQuery();
	ArrayList list=new ArrayList();
	
	
	if(rs!=null)
	{
		while (rs.next())
		{
				ageCodes = rs.getString("TERM_CODE");
				list.add(ageCodes);
		}
	}
	if(rs!=null) rs.close();
	if(pstmt!=null) pstmt.close();
			
		session.setAttribute("compareTermCode",list);
		

}

if(_clearSession.equals("clear")){
	session.removeAttribute("AgeGroupForTermCode");
	
}
// end here 
else{
	

String select =	request.getParameter("select")==null?"":request.getParameter("select");
String term_set_id = request.getParameter("term_set_id")==null?"":request.getParameter("term_set_id");
String type	= request.getParameter("type");
ArrayList TabList =	null;
ArrayList sessionList =	(ArrayList)AgeGroupForTermCode.getRecordSetHandle();
if(sessionList.size()>0)
{
	TabList=(ArrayList)AgeGroupForTermCode.getObject(0);
}else
{
	TabList=new ArrayList();
	AgeGroupForTermCode.putObject(TabList);
}
String age_group_code=request.getParameter("age_group_code");
//con = ConnectionManager.getConnection(request);

	String levelData = "";
	String TerminologySet_sql="Select diag_spec_yn,proc_spec_yn from mr_term_set where eff_status = 'E' and term_set_id = ? order by term_set_desc ";
	pstmt = con.prepareStatement(TerminologySet_sql);
	pstmt.setString(1,term_set_id);
	rs = pstmt.executeQuery();
	if(rs!=null)
	{
		if (rs.next())
		{
				levelData = rs.getString("diag_spec_yn")+"||"+rs.getString("proc_spec_yn");
		}
	}
	out.println( "assignLevels(\"" + levelData.toString() + "\");") ;	
	if(rs!=null) rs.close();
	if(pstmt!=null) pstmt.close();
	if(select.equals("Update"))
	{
		String code	= request.getParameter("code");
		
		String flag	= request.getParameter("flag");
		String alphalink = request.getParameter("alphalink");
		alphalink = alphalink.trim();
		if(flag.equals("1"))
		TabList.add(code);
		else
		{
			if(TabList.contains(code))
			{
				TabList.remove(code);
			}
		}
	}
	else 
	{
		String flag	= request.getParameter("flag");
		String alphalink = request.getParameter("alphalink")==null ? "":request.getParameter("alphalink");
		alphalink	= alphalink.trim();
		if(alphalink.equals("Associated"))
		{
			sqlData="SELECT a.term_set_id, a.term_code term_code, b.short_desc short_desc,'U' db_action FROM mr_age_grp_for_term_code a, mr_term_code b WHERE a.age_group_code = '"+age_group_code+"' and  b.term_set_id = a.term_set_id AND b.term_code = a.term_code and (( '"+type+"' = 'PR' and b.procedure_yn = 'Y' ) or ( '"+type+"' = 'DX' and b.diagnosis_yn = 'Y' )) ORDER BY 3";
		}
		else
		{
			 sqlData		=	"select term_set_id, term_code, short_desc, 'I' db_action from mr_term_code where term_set_id = '"+term_set_id+"' and code_level = (select defn_levels from mr_term_set where term_set_id = '"+term_set_id+"') and (( '"+type+"' = 'PR' and procedure_yn = 'Y' ) or ( '"+type+"' = 'DX' and diagnosis_yn = 'Y')) and (('"+alphalink+"' is not null and upper(short_desc) like '"+alphalink+"%') or ('"+alphalink+"' is null and substr(short_desc,1,1) not between 'A' and 'Z' )) and (term_set_id, term_code) not in (select term_set_id,term_code from mr_age_grp_for_term_code where age_group_code = '"+age_group_code+"') union all select a.term_set_id, a.term_code, b.short_desc ,'U' db_action from mr_age_grp_for_term_code a, mr_term_code b where a.age_group_code = '"+age_group_code+"' and b.term_set_id = a.term_set_id and b.term_code = a.term_code and (( '"+type+"' = 'PR' and b.procedure_yn = 'Y' )or ( '"+type+"' = 'DX' and b.diagnosis_yn = 'Y' )) and (('"+alphalink+"' is not null and upper(b.short_desc) like '"+alphalink+"%') or ('"+alphalink+"' is null and substr(b.short_desc,1,1) not between 'A' and 'Z')) and b.code_level = (select defn_levels from mr_term_set where term_set_id = '"+term_set_id+"') order by 3  ";
		}
			pstmt	=		con.prepareStatement(sqlData);
			rs	= pstmt.executeQuery();

			
			if(rs!=null)
			{
				while(rs.next())
				{
					String code	=	rs.getString("term_code");
					if(flag.equals("1"))
					{
						if(!(TabList.contains(code)))
						{
							TabList.add(code);
						}
					}
					else
					{
						if(TabList.contains(code))
						{
							int index	=	TabList.indexOf(code);
							TabList.remove(index);
						}
					}
				}
			}

	}
	if(rs!=null) rs.close();
	if(pstmt!=null) pstmt.close();
	


}
}
catch(Exception e){/* out.print(e); */ e.printStackTrace();
}
  finally
  {
	  ConnectionManager.returnConnection(con,request);
  }
	
%>
