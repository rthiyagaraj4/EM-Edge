<%@ page language="java" import ="webbeans.eCommon.*,java.sql.*" contentType="text/html;charset=UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
Connection con = null;
String flag=request.getParameter("flag")==null ?"":request.getParameter("flag");
boolean min_flag=true;
boolean max_flag=true;
PreparedStatement pstmt_list_score=null;
PreparedStatement pstmt_num_score=null;
ResultSet rs_list_score=null;
ResultSet rs_num_score=null;
int min_list=0, max_list=0, min_num=0, max_num=0, min_score=0, max_score=0;
		  //This file is saved on 18/10/2005.
try
{
	con = ConnectionManager.getConnection(request);

	if(flag.equals("disp")){
		String assess_note_id	 =	 request.getParameter("assess_note_id")==null?"":request.getParameter("assess_note_id");

//		String sql_list_score="select sum(min(score)) min_l_score,sum(max(score)) max_l_score from cp_assess_list_crit_score where assess_note_id = ? and score is not null group by comp_id";
		String sql_list_score="SELECT NVL(SUM(MIN(score)),0) min_l_score,NVL(SUM(MAX(score)),0) max_l_score FROM cp_assess_list_crit_score WHERE assess_note_id = ? AND score IS NOT NULL GROUP BY comp_id";

//		String sql_num_score="select sum(normal_score) min_n_score,sum(critical_score) max_n_score from cp_assess_num_crit_score where assess_note_id = ? and normal_score is not null";
		String sql_num_score="SELECT NVL(SUM(normal_score),0) min_n_score, NVL(SUM(critical_score),0) max_n_score FROM cp_assess_num_crit_score WHERE assess_note_id = ? AND normal_score IS NOT NULL";

		pstmt_list_score = con.prepareStatement( sql_list_score);
		pstmt_list_score.setString(1, assess_note_id);


		rs_list_score = pstmt_list_score.executeQuery() ;


		while (rs_list_score != null && rs_list_score.next())
		{

				if(rs_list_score.getString("min_l_score") != null)
				{
					min_list= Integer.parseInt(rs_list_score.getString("min_l_score"));
					min_flag=true;
				}
				else
				{
					min_flag=false;
				}
				if(rs_list_score.getString("max_l_score") != null)
				{
					max_list = Integer.parseInt(rs_list_score.getString("max_l_score"));
					//min_flag=true;
					max_flag=true;
				}
				else
				{
					min_flag=false;
				}
		}
		if(rs_list_score !=null)
			rs_list_score.close();

		pstmt_num_score = con.prepareStatement( sql_num_score);
		pstmt_num_score.setString(1, assess_note_id);
		rs_num_score = pstmt_num_score.executeQuery() ;

		while (rs_num_score != null && rs_num_score.next()) {

				if(rs_num_score.getString("min_n_score") != null)
				{
					min_num= Integer.parseInt(rs_num_score.getString("min_n_score"));
					min_flag	=	true;
				}
				else
				{
					min_flag=false;
				}

				if(rs_num_score.getString("max_n_score") != null){
					max_num = Integer.parseInt(rs_num_score.getString("max_n_score") );
					max_flag	=	true;
				}
				else
				{
					max_flag=false;
				}
		}
		if(rs_num_score !=null)
			rs_num_score.close();
		min_score	=	min_list+min_num;
		max_score	=	max_list+max_num;
		if(min_flag && max_flag){
			out.println( "assignMinMax(\"" + min_score+ "\",\"" +max_score + "\");") ;	
		}
		else if(min_flag){
			out.println( "assignMinMax(\"" + min_score+ "\",\"\");") ;	
		}
		else if(max_flag){
			out.println( "assignMinMax(\"\",\"" +max_score + "\");") ;	
		}
		else{
			out.println( "assignMinMax(\"\",\"\");") ;	
		}

	}
%>


<%}
catch(Exception e){
	//out.print(e);//common-icn-0181
	e.printStackTrace();//COMMON-ICN-0181
}
  finally
  {
	  if(rs_num_score !=null)
			rs_num_score.close();
		if(rs_list_score !=null)
			rs_num_score.close();
		if(pstmt_num_score !=null)
			pstmt_num_score.close();
		if(pstmt_list_score !=null)
			pstmt_list_score.close();

		if(con != null)	ConnectionManager.returnConnection(con,request);

  }
	
%>
