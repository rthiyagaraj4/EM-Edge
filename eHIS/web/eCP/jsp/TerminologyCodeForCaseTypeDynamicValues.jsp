
<%@ page language="java" import ="webbeans.eCommon.*,java.sql.*,java.util.*" contentType="text/html;charset=UTF-8"%>
<jsp:useBean id="TermCodeForCaseType" class="webbeans.eCommon.RecordSet" scope="session"/> 
<%
 request.setCharacterEncoding("UTF-8");
//This file is saved on 18/10/2005.
Connection con	= null;
PreparedStatement pstmt	= null;
ResultSet rs = null;
String select =	request.getParameter("select");
ArrayList TabList =	null;
ResultSet resultSet=null;
String[] record=null;
ArrayList nature_Data	= new ArrayList();	
String case_type_code=request.getParameter("case_type_code");
con = ConnectionManager.getConnection(request);
String term_set_id		=	"";
String type	=	"";
String flag	=	"";
String sql_associated="";
String alphalink="";	
String sql_nature="";
String code	=	"";
String mandatory_yn="";
String actual_yn="";
String potential_yn="";
String wellness_yn="";
String select_val="";
String temp_code="";
try
	{
		if(select.equals("lookup"))
		{
	 sql_nature="Select case_type_nature from cp_case_type where case_type_code = ?";
		pstmt = con.prepareStatement( sql_nature);
		pstmt.setString(1,case_type_code);
				resultSet = pstmt.executeQuery() ;
		while (resultSet != null && resultSet.next()) {
			record = new String[1];				
			record[0] = resultSet.getString("case_type_nature")==null ? "": resultSet.getString("case_type_nature");
			if(record[0].equals("I"))
				record[0]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCP.lllness.label","cp_labels");
			else
				record[0]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Wellness.label","common_labels");;
			nature_Data.add(record) ;
		}
	  if(resultSet!=null) resultSet.close();
	  if(pstmt!=null) pstmt.close();
		for( int i=0 ; i< nature_Data.size() ; i++ ) {
			record = (String[])nature_Data.get(i);
			out.println( "assignNature(\"" + record[0] + "\");") ;	
			
		}
		}
	else if(select.equals("SELECTALL"))
		{

		 term_set_id		=	request.getParameter("term_set_id");
		 type	=	request.getParameter("type");
		 flag	=	request.getParameter("flag");
		 sql_associated="";
		 alphalink								=		request.getParameter("alphalink")==null ? "":request.getParameter("alphalink");
		alphalink	= alphalink.trim();
	if(alphalink.equals("Associated"))
		{			
			if(type.equals("PR"))
			{
			 sql_associated="SELECT a.term_set_id, a.term_code term_code, b.short_desc short_desc,a.actual_yn actual_yn,a.potential_yn potential_yn,a.wellness_yn wellness_yn,a.mandatory_yn mandatory_yn,'U' db_action FROM cp_term_code_for_case_type a, mr_p_"+term_set_id+"_vw b,mr_term_code c WHERE a.case_type_code = '"+case_type_code+"' and  b.term_set_id = a.term_set_id AND b.term_code = a.term_code and c.term_set_id = b.term_set_id and c.term_code = b.term_code and (( '"+type+"' = 'PR' and c.procedure_yn = 'Y' ) or ( '"+type+"' = 'DX' and c.diagnosis_yn = 'Y' )) ORDER BY 3";
			}
			else
			{			
			sql_associated="SELECT a.term_set_id, a.term_code term_code, b.short_desc short_desc,a.actual_yn actual_yn,a.potential_yn potential_yn,a.wellness_yn wellness_yn,a.mandatory_yn mandatory_yn,'U' db_action FROM cp_term_code_for_case_type a, mr_d_"+term_set_id+"_vw b, mr_term_code c WHERE a.case_type_code = '"+case_type_code+"' and  b.term_set_id = a.term_set_id AND b.term_code = a.term_code and c.term_set_id = b.term_set_id and c.term_code = b.term_code and (( '"+type+"' = 'PR' and c.procedure_yn = 'Y' ) or ( '"+type+"' = 'DX' and c.diagnosis_yn = 'Y' )) ORDER BY 3";
			}
		}
		else
		{			
			if(type.equals("PR"))
			{			
			 sql_associated="select term_set_id, term_code, short_desc, actual_yn, potential_yn, wellness_yn, 'N' mandatory_yn,'I' db_action from mr_p_"+term_set_id+"_vw where term_set_id = '"+term_set_id+"' and code_level = (select defn_levels from mr_term_set where term_set_id = '"+term_set_id+"') and (('"+alphalink+"' is not null and upper(short_desc) like '"+alphalink+"%') or ('"+alphalink+"' is null and substr(short_desc,1,1) not between 'A' and 'Z' )) and (term_set_id, term_code) not in (select term_set_id,term_code from cp_term_code_for_case_type where case_type_code = '"+case_type_code+"') union all select a.term_set_id, a.term_code, b.short_desc , b.actual_yn, b.potential_yn, b.wellness_yn,a.mandatory_yn,'U' db_action from cp_term_code_for_case_type a, mr_p_"+term_set_id+"_vw b,mr_term_code c where a.case_type_code = '"+case_type_code+"' and b.term_set_id = a.term_set_id and b.term_code = a.term_code and c.term_set_id = b.term_set_id and c.term_code = b.term_code and  (( '"+type+"' = 'PR' and c.procedure_yn = 'Y' )or ( '"+type+"' = 'DX' and c.diagnosis_yn = 'Y' )) and (('"+alphalink+"' is not null and upper(b.short_desc) like '"+alphalink+"%') or ('"+alphalink+"' is null and substr(b.short_desc,1,1) not between 'A' and 'Z'))  order by 3 ";  
			}
			else
			{			
				sql_associated="select term_set_id, term_code, short_desc, actual_yn, potential_yn, wellness_yn, 'N' mandatory_yn,'I' db_action from mr_d_"+term_set_id+"_vw where term_set_id = '"+term_set_id+"' and (('"+alphalink+"' is not null and upper(short_desc) like '"+alphalink+"%') or ('"+alphalink+"' is null and substr(short_desc,1,1) not between 'A' and 'Z' )) and (term_set_id, term_code) not in (select term_set_id,term_code from cp_term_code_for_case_type where case_type_code = '"+case_type_code+"') union all select a.term_set_id, a.term_code, b.short_desc , b.actual_yn, b.potential_yn, b.wellness_yn,a.mandatory_yn,'U' db_action from cp_term_code_for_case_type a, mr_d_"+term_set_id+"_vw b,mr_term_code c where a.case_type_code = '"+case_type_code+"' and b.term_set_id = a.term_set_id and b.term_code = a.term_code and c.term_set_id = b.term_set_id and c.term_code = b.term_code and (( '"+type+"' = 'PR' and c.procedure_yn = 'Y' )or ( '"+type+"' = 'DX' and c.diagnosis_yn = 'Y' )) and (('"+alphalink+"' is not null and upper(b.short_desc) like '"+alphalink+"%') or ('"+alphalink+"' is null and substr(b.short_desc,1,1) not between 'A' and 'Z'))  order by 3 "; 
			}
	
		}
	pstmt	=		con.prepareStatement(sql_associated);
	rs	= pstmt.executeQuery();
	if(rs!=null)
	{
		while(rs.next()){
			 code	=	rs.getString("term_code");
			 mandatory_yn=rs.getString("mandatory_yn");
			 actual_yn=rs.getString("actual_yn");
			 potential_yn=rs.getString("potential_yn");
			 wellness_yn=rs.getString("wellness_yn");
			 select_val="N";
			if(actual_yn.equals("Y")){
				if(potential_yn.equals("Y"))
					select_val="B";
				else
					select_val="A";
			}
			else
				if(potential_yn.equals("Y"))
					select_val="P";
			if(wellness_yn.equals("Y"))
				select_val="W";
		int index=-1;

		if(TermCodeForCaseType != null){
			for(int i=0;i<TermCodeForCaseType.getSize();i++){
				TabList=new ArrayList();
				TabList=(ArrayList)TermCodeForCaseType.getObject(i);
				 temp_code=(String)TabList.get(0);
				if(temp_code.equals(code)){
					index=i;
					break;
				}
			}
			if(index != -1){
				if(!flag.equals("1"))
					TermCodeForCaseType.removeObject(index);
			}
			else
				if(flag.equals("1")){
					TabList = new ArrayList();
					TabList.add(code);
					TabList.add(mandatory_yn);
					TabList.add(actual_yn);
					TabList.add(potential_yn);
					TabList.add(wellness_yn);
					TabList.add(select_val);
					TermCodeForCaseType.putObject(TabList);
			}
		}	
	  }
    }
	  if(rs!=null) rs.close();
	  if(pstmt!=null) pstmt.close();
  }
	
}
catch(Exception e){
	//out.print(e);//COMMON-ICN-0181
      e.printStackTrace();//COMMON-ICN-0181
}
  finally
  {
	  if(rs!=null) rs.close();
	  if(pstmt!=null) pstmt.close();
	ConnectionManager.returnConnection(con,request);

  }
%>
