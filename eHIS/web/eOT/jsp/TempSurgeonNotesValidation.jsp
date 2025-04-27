<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.ConnectionManager,java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eOT/jsp/StringUtil.jsp" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<% 
		String facility_id      = (String) session.getAttribute("facility_id");
		String oper_num =	checkForNull(request.getParameter("oper_num")) ;
		String doc_level =	checkForNull(request.getParameter("doc_level")) ;
		String Speciality_code_val =	checkForNull(request.getParameter("Speciality_code_val")) ;
		request.setCharacterEncoding("UTF-8");
		String accession_num = checkForNull(request.getParameter("contr_mod_accession_num"));
		//String SQL ="SELECT AUTHORIZED_BY_ID FROM CA_ENCNTR_NOTE WHERE CONTR_MOD_ACCESSION_NUM = ? ";
		String SQL ="SELECT AUTHORIZED_BY_ID FROM CA_ENCNTR_NOTE WHERE CONTR_MOD_ACCESSION_NUM = ? and Event_Status <> '9'";//added by Sanjay for Surgeon Notes against IN34391
		Connection con = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt1 = null;
		ResultSet rst = null;
		ResultSet rst1 = null;
		String authorize_by_id="";
		String result = "OK";
		String speciality_code = "";
		String contr_mod_accession_num="";
		
		try{
			con = ConnectionManager.getConnection(request);
			//pstmt = con.prepareStatement(OTRepository.getOTKeyValue("SQL_OT_PERSONNEL_SELECT2")) ;
		/*	if(func_mode.equalsIgnoreCase("getPractRoleType")){
			String sql			= "";		
			String role_type_id	= "";
			String pract_id	= "";
			String compareString= "";
			sql="SELECT B.ROLE_TYPE, A.PRACTITIONER_ID FROM OT_POST_OPER_PERSONNEL A, OT_ROLES_LANG_VW B, AM_SPECIALITY C,AM_PRACTITIONER D, AM_POSITION E WHERE B.LANGUAGE_ID = ? AND OPERATING_FACILITY_ID =? AND OPER_NUM	= ? AND A.SPECIALITY_CODE = C.SPECIALITY_CODE (+) AND A.ROLE_ID = B.ROLE_ID AND A.PRACTITIONER_ID = D.PRACTITIONER_ID AND  D.POSITION_CODE    = E.POSITION_CODE(+)";
			
			pstmt1 = con.prepareStatement(sql);
			pstmt1.setString(1,locale);
			pstmt1.setString(2,facility_id);
			pstmt1.setString(3,oper_num);
			rst1 = pstmt1.executeQuery();
			while(rst1.next()){
				role_type_id=rst1.getString(1);
				pract_id=rst1.getString(2);
				compareString=compareString+"@@"+role_type_id+"||"+pract_id;
			
			}
			out.println(compareString);
		}else{*/
if(("IS").equals(doc_level))
{
String	spec_code_chk_last=  Speciality_code_val.substring(Speciality_code_val.length()-1);
if(spec_code_chk_last.equals("*"))
{
		StringTokenizer token=new StringTokenizer(Speciality_code_val,"*");
			while(token.hasMoreTokens())
			{
			 speciality_code=token.nextToken();
			 contr_mod_accession_num = facility_id+oper_num+speciality_code+"30";
						pstmt = con.prepareStatement(SQL);
			pstmt.setString(1,contr_mod_accession_num);
			rst = pstmt.executeQuery();
			if(rst.next()){
				authorize_by_id = rst.getString(1);
				if(rst.wasNull())
				{
					result = "Surgeon Notes is not Authorized!, Please Authorize the Notes.";
				}
			}else	
				{
				result = "Surgeon Notes is not entered!, Please enter the Notes.";
				}
			}
}else
	{
	        spec_code_chk_last=  Speciality_code_val;
			contr_mod_accession_num = facility_id+oper_num+spec_code_chk_last+"30";
			

			pstmt = con.prepareStatement(SQL);
			pstmt.setString(1,contr_mod_accession_num);
			rst = pstmt.executeQuery();
			if(rst.next()){
				authorize_by_id = rst.getString(1);
				if(rst.wasNull())
				{
					result = "Surgeon Notes is not Authorized!, Please Authorize the Notes.";
				}
			}else	
				{
				result = "Surgeon Notes is not entered!, Please enter the Notes.";
				}
}

/*
		StringTokenizer token=new StringTokenizer(Speciality_code_val,",");
			while(token.hasMoreTokens())
			{
			 speciality_code=token.nextToken();
			 contr_mod_accession_num = facility_id+oper_num+speciality_code+"30";
						pstmt = con.prepareStatement(SQL);
			pstmt.setString(1,contr_mod_accession_num);
			rst = pstmt.executeQuery();
			if(rst.next()){
				authorize_by_id = rst.getString(1);
				if(rst.wasNull())
				{
					result = "Surgeon Notes is not Authorized!, Please Authorize the Notes.";
				}
			}else	
				{
				result = "Surgeon Notes is not entered!, Please enter the Notes.";
				}
			}*/
			}
          /* if(("IS").equals(doc_level))
			{
		    pstmt1 = con.prepareStatement(sql_speciality);
			pstmt1.setString(1,facility_id);
			pstmt1.setString(2,oper_num);
			rst1 = pstmt1.executeQuery();
			while(rst1.next()){	
			speciality_code	= checkForNull(rst1.getString(1));//speciality_code
			contr_mod_accession_num = facility_id+oper_num+speciality_code+"30";

			pstmt = con.prepareStatement(SQL);
			pstmt.setString(1,contr_mod_accession_num);
			rst = pstmt.executeQuery();
			if(rst.next()){
				authorize_by_id = rst.getString(1);
				if(rst.wasNull())
				{
					result = "Surgeon Notes is not Authorized!, Please Authorize the Notes.";
				}
			}else	
				{
				result = "Surgeon Notes is not entered!, Please enter the Notes.";
				}
			}
			}*/
			else if(("AS").equals(doc_level))
			{
			pstmt = con.prepareStatement(SQL);
			pstmt.setString(1,accession_num);
			rst = pstmt.executeQuery();
			if(rst.next()){
				authorize_by_id = rst.getString(1);
				if(rst.wasNull())
				{
					result = "Surgeon Notes is not Authorized!, Please Authorize the Notes.";
				}
			}else	
				{
				result = "Surgeon Notes is not entered!, Please enter the Notes.";
				}
			
			}
			out.println(result);
		}catch(Exception e){
			System.err.println("Err Msg in TempSugeonNotesValidation.jsp"+e.getMessage());
		} finally{
			try{
				if(rst!=null)rst.close();
				if(pstmt!=null)pstmt.close();
				if(rst1!=null)rst1.close();
				if(pstmt1!=null)pstmt1.close();
				if(con!=null)
				ConnectionManager.returnConnection(con,request);
			}catch(Exception e){}
		}

%>



