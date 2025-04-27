<!DOCTYPE html>
<%@page  import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,java.net.URLEncoder,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@include file="../../eOT/jsp/StringUtil.jsp"%>
<% 
	String locale = (String)session.getAttribute("LOCALE");
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; 
%>
<html>
<head>
<link type='text/css' rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' />
<script language="javaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<script language='javascript'src='../../eCommon/js/common.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	
</head>
<body class='CONTENT'  OnMouseDown='CodeArrest()' onKeyDown="lockKey()">
<%
   String ca_module_yn=request.getParameter("ca_module_yn");
   String empty = "".intern();
   String whereClause =checkForNull(request.getParameter("whereclause"));
   String from = checkForNull(request.getParameter( "from" ) ) ;
   String to =   checkForNull(request.getParameter( "to" ) ) ;
   int start = ( from.equals("") )?1:Integer.parseInt(from);
   int end =  ( to.equals("") )?14:Integer.parseInt(to);
   String speciality_code = checkForNull(request.getParameter( "speciality_code" ));
   String diag_code_scheme = checkForNull(request.getParameter( "diag_code_scheme" ));
   String chart_id = checkForNull(request.getParameter( "chart_id" ));
   String swab_instr_tmpl_id =checkForNull(request.getParameter( "swab_instr_tmpl_id" ));
   String med_ser_grp_code =checkForNull(request.getParameter( "med_ser_grp_code" ));
   String anaesthesia_reqd_yn =checkForNull(request.getParameter( "anaesthesia_reqd_yn" ),"Y");
   String enabled = checkForNull(request.getParameter( "status"),"E");
   String pre_op_checklist = checkForNull(request.getParameter( "pre_op_checklist"));
   String post_op_checklist = checkForNull(request.getParameter( "post_op_checklist"));
   String role = checkForNull(request.getParameter( "role"));
   String img_enabled = "<img src='../../eCommon/images/enabled.gif'></img>";
   String img_disabled = "<img src='../../eCommon/images/RRnwd.gif'></img>";
   String sql = empty;
   int maxRecord = 0;
   String classValue="";
   int i=1;
//   int total=0;

   Connection conn  =  null;
   PreparedStatement pstmt = null;
   ResultSet rst=null;

   StringBuffer sbr = new StringBuffer();
	        
	if ( (whereClause == null || whereClause.equals("")) ){
	int cnt=0;

		if ( !(speciality_code == null || speciality_code.equals("")) ){
	        sql = sql + " and A.speciality_code='"+speciality_code +"'";
			cnt++;
        }
//added by rajesh for DiagnosisCodeScheme

if ( !(diag_code_scheme == null || diag_code_scheme.equals("")) ){
	        sql = sql + " and A.diag_code_scheme='"+diag_code_scheme +"'";
			cnt++;
        }

        if ( !(chart_id == null || chart_id.equals("")) ){
			if(cnt>0)
				sql = sql + " and A.discr_msr_id='"+chart_id+"'";
			else{
				sql=sql+" and A.discr_msr_id='"+chart_id+"'";
				cnt=1;
			}

        }
	   if ( !(swab_instr_tmpl_id == null || swab_instr_tmpl_id.equals("")) ){
			if(cnt>0)
				sql = sql + " and A.swab_instr_tmpl_id = '"+swab_instr_tmpl_id+"'";
			else{
				sql = sql +" and A.swab_instr_tmpl_id = '"+swab_instr_tmpl_id+"'";
				cnt=1;
			}

        }

		if ( !(med_ser_grp_code == null || med_ser_grp_code.equals("")) ){
			if(cnt>0)
				sql = sql + " and A.med_ser_grp_code = '"+med_ser_grp_code+"'";
			else{
				sql = sql +" and A.med_ser_grp_code = '"+med_ser_grp_code+"'";
				cnt=1;
			}

        }

		if ( !(anaesthesia_reqd_yn.equals("all")) ){
         if( anaesthesia_reqd_yn.equals("Y") ){

			if(cnt>0)
			   sql = sql+" and nvl(A.anaesthesia_review_reqd_yn,'Y')='Y' ";
			else{
				sql=sql+ " and nvl(A.anaesthesia_review_reqd_yn,'Y')='Y' ";
				cnt=1;
			}
         }

		 if ( anaesthesia_reqd_yn.equals("N") ){

            if(cnt>0)
			   sql = sql+" and nvl(A.anaesthesia_review_reqd_yn,'Y')='N'";
			else
				sql=sql+ " and nvl(A.anaesthesia_review_reqd_yn,'Y')='N'";
         }

         
    }
	if ( !(enabled == null || enabled.equals("")) ){
         if( enabled.equals("E") ){

			if(cnt>0)
			   sql = sql+" and nvl(A.status,'E')='E' ";
			else{
				sql=sql+ " and nvl(A.status,'E')='E' ";
				cnt=1;
			}
         }

		 if ( enabled.equals("D") ){

            if(cnt>0)
			   sql = sql+" and nvl(A.status,'E')='D'";
			else
				sql=sql+ "  and nvl(A.status,'E')='D'";
         }

         if ( enabled.equals("B") ){
//               sql = sql; //nothing is added to get both E and D
         }
    }

	if ( !(pre_op_checklist == null || pre_op_checklist.equals("")) ){
			if(cnt>0)
				sql = sql + " and A.pre_op_check_list = '"+pre_op_checklist+"'";
			else{
				sql=sql+" and A.pre_op_check_list = '"+pre_op_checklist+"'";
				cnt=1;
			}

        }

		if ( !(post_op_checklist == null || post_op_checklist.equals("")) ){
			if(cnt>0)
				sql = sql + " and A.post_op_check_list = '"+post_op_checklist+"'";
			else{
				sql=sql+" and A.post_op_check_list = '"+post_op_checklist+"'";
				cnt=1;
			}

        }

		if ( !(role == null || role.equals("")) ){
			if(cnt>0)
				sql = sql + " and (A.PRE_OP_VERIFY1_USER_ROLE ='"+role+"' or A.PRE_OP_VERIFY2_USER_ROLE='"+role+"' or A.PRE_OP_VERIFY3_USER_ROLE ='"+role+"' or A.PRE_OP_VERIFY4_USER_ROLE ='"+role+"' or A.Post_OP_VERIFY1_USER_ROLE ='"+role+"' or A.Post_OP_VERIFY2_USER_ROLE='"+role+"' or A.Post_OP_VERIFY3_USER_ROLE ='"+role+"' or A.Post_OP_VERIFY4_USER_ROLE='"+role+"')";
			else{
				sql=sql+" and (A.PRE_OP_VERIFY1_USER_ROLE ='"+role+"' or A.PRE_OP_VERIFY2_USER_ROLE='"+role+"' or A.PRE_OP_VERIFY3_USER_ROLE ='"+role+"' or A.PRE_OP_VERIFY4_USER_ROLE ='"+role+"' or A.Post_OP_VERIFY1_USER_ROLE ='"+role+"' or A.Post_OP_VERIFY2_USER_ROLE='"+role+"' or A.Post_OP_VERIFY3_USER_ROLE ='"+role+"' or A.Post_OP_VERIFY4_USER_ROLE='"+role+"')";
				cnt=1;
			}

        }	
		//out.println(cnt);
		/*
	if(cnt>0)
		sql = " and D.LANGUAGE_ID = '"+locale+"' " +sql;
	else
		sql = sql+" and D.LANGUAGE_ID = '"+locale+"' ";
	*/
       
    //appending order by clause
    String ord[] = request.getParameterValues("orderbycolumns");

    if ( !(ord == null || ord .equals("")) )
    {
        sql=sql+" order by ";
        for ( int j=0;j < ord.length;j++ )
        {
        if ( j == ord.length - 1 )
            sql=sql+ord[j];
        else
            sql=sql+ord[j]+",";
        }
    }

    } //end of where clause IF
    else
		sql = whereClause;
	
   

	
	
//String debug_sql="";
	String strsql="";

	
		//String strsql="select A.SPECIALITY_CODE ,B.LONG_DESC,A.DISCR_MSR_ID,C.SHORT_DESC,A.PRE_OP_CHECK_LIST,D.DESCRIPTION, A.PRE_OP_NO_OF_VERIFICATIONS,A.PRE_OP_VERIFY1_USER_ROLE,E.ROLE_DESC,A.PRE_OP_VERIFY2_USER_ROLE,F.ROLE_DESC,A.PRE_OP_VERIFY3_USER_ROLE,G.ROLE_DESC,A.PRE_OP_VERIFY4_USER_ROLE,H.ROLE_DESC,A.POST_OP_CHECK_LIST,N.DESCRIPTION,A.POST_OP_NO_OF_VERIFICATIONS,A.POST_OP_VERIFY1_USER_ROLE,I.ROLE_DESC,A.POST_OP_VERIFY2_USER_ROLE,J.ROLE_DESC,A.POST_OP_VERIFY3_USER_ROLE,K.ROLE_DESC,A.POST_OP_VERIFY4_USER_ROLE,L.ROLE_DESC,A.SWAB_INSTR_TMPL_ID,M.DESCRIPTION, nvl(A.ANAESTHESIA_REVIEW_REQD_YN,'N') ANAESTHESIA_REVIEW_REQD_YN,nvl(A.STATUS,'E') STATUS from ot_specialities A,AM_SPECIALITY B,CA_CHART C,OT_CHECKLIST_HDR D,OT_CHECKLIST_HDR N,OT_ROLES E,OT_ROLES F,OT_ROLES G,OT_ROLES H,OT_ROLES I,OT_ROLES J,OT_ROLES K,OT_ROLES L,OT_SWAB_INSTR_TMPL_HDR M where A.SPECIALITY_CODE=B.SPECIALITY_CODE AND A.DISCR_MSR_ID=C.CHART_ID(+) AND A.PRE_OP_CHECK_LIST=D.CHECKLIST_CODE(+) AND A.PRE_OP_VERIFY1_USER_ROLE=E.ROLE_ID(+) AND A.PRE_OP_VERIFY2_USER_ROLE=F.ROLE_ID(+)  AND A.PRE_OP_VERIFY3_USER_ROLE=G.ROLE_ID(+)  AND A.PRE_OP_VERIFY4_USER_ROLE=H.ROLE_ID(+)  AND A.POST_OP_CHECK_LIST=N.CHECKLIST_CODE(+) AND A.POST_OP_VERIFY1_USER_ROLE=I.ROLE_ID(+)  AND A.POST_OP_VERIFY2_USER_ROLE=J.ROLE_ID(+)  AND A.POST_OP_VERIFY3_USER_ROLE=K.ROLE_ID(+)  AND A.POST_OP_VERIFY4_USER_ROLE=L.ROLE_ID(+)  AND A.SWAB_INSTR_TMPL_ID=M.TEMPLATE_ID(+) "+sql;
		
        // NOT USED.... String strsql="select A.SPECIALITY_CODE ,B.LONG_DESC,A.DISCR_MSR_ID,C.SHORT_DESC,A.PRE_OP_CHECK_LIST,D.DESCRIPTION, A.PRE_OP_NO_OF_VERIFICATIONS,A.PRE_OP_VERIFY1_USER_ROLE,E.ROLE_DESC,A.PRE_OP_VERIFY2_USER_ROLE,F.ROLE_DESC,A.PRE_OP_VERIFY3_USER_ROLE,G.ROLE_DESC,A.PRE_OP_VERIFY4_USER_ROLE,H.ROLE_DESC,A.POST_OP_CHECK_LIST,N.DESCRIPTION,A.POST_OP_NO_OF_VERIFICATIONS,A.POST_OP_VERIFY1_USER_ROLE,I.ROLE_DESC,A.POST_OP_VERIFY2_USER_ROLE,J.ROLE_DESC,A.POST_OP_VERIFY3_USER_ROLE,K.ROLE_DESC,A.POST_OP_VERIFY4_USER_ROLE,L.ROLE_DESC,A.SWAB_INSTR_TMPL_ID,M.DESCRIPTION, nvl(A.ANAESTHESIA_REVIEW_REQD_YN,'N') ANAESTHESIA_REVIEW_REQD_YN,nvl(A.STATUS,'E') STATUS from ot_specialities A,AM_SPECIALITY B,CA_CHART C,OT_CHECKLIST_HDR_LANG_VW D,OT_CHECKLIST_HDR_LANG_VW N,OT_ROLES_LANG_VW E,OT_ROLES_LANG_VW F,OT_ROLES_LANG_VW G,OT_ROLES_LANG_VW H,OT_ROLES_LANG_VW I,OT_ROLES_LANG_VW J,OT_ROLES_LANG_VW K,OT_ROLES_LANG_VW L,OT_SWAB_INSTR_TMPL_HDR_LANG_VW M where E.LANGUAGE_ID=? AND F.LANGUAGE_ID=? AND G.LANGUAGE_ID=? AND H.LANGUAGE_ID=? AND I.LANGUAGE_ID=? AND J.LANGUAGE_ID=? AND K.LANGUAGE_ID=? AND L.LANGUAGE_ID=? AND M.LANGUAGE_ID=? AND A.SPECIALITY_CODE=B.SPECIALITY_CODE AND A.DISCR_MSR_ID=C.CHART_ID(+) AND A.PRE_OP_CHECK_LIST=D.CHECKLIST_CODE(+) AND A.PRE_OP_VERIFY1_USER_ROLE=E.ROLE_ID(+) AND A.PRE_OP_VERIFY2_USER_ROLE=F.ROLE_ID(+)  AND A.PRE_OP_VERIFY3_USER_ROLE=G.ROLE_ID(+)  AND A.PRE_OP_VERIFY4_USER_ROLE=H.ROLE_ID(+)  AND A.POST_OP_CHECK_LIST=N.CHECKLIST_CODE(+) AND A.POST_OP_VERIFY1_USER_ROLE=I.ROLE_ID(+)  AND A.POST_OP_VERIFY2_USER_ROLE=J.ROLE_ID(+)  AND A.POST_OP_VERIFY3_USER_ROLE=K.ROLE_ID(+)  AND A.POST_OP_VERIFY4_USER_ROLE=L.ROLE_ID(+)  AND A.SWAB_INSTR_TMPL_ID=M.TEMPLATE_ID(+) "+sql;

		/* ARGUMENTS FOR THE GET_DESC FUNCTION ARE:
			P_LANG_ID  VARCHAR2,
			P_TABLE_NAME VARCHAR2,
			P_COLUMN_NAME VARCHAR2,
			P_KEY_NAME_1 VARCHAR2,
			P_KEY_CODE_1  VARCHAR2,
			P_KEY_NAME_2 VARCHAR2 DEFAULT NULL,
			P_KEY_CODE_2  VARCHAR2 DEFAULT NULL
		*/
		if(ca_module_yn.equals("Y")){
			//strsql="select NULL, A.SPECIALITY_CODE,   GET_DESC('"+locale+"','AM_SPECIALITY_LANG_VW','LONG_DESC','SPECIALITY_CODE',B.SPECIALITY_CODE) LONG_DESC, A.DISCR_MSR_ID, GET_DESC('"+locale+"','CA_CHART_LANG_VW','SHORT_DESC','CHART_ID',C.CHART_ID) SHORT_DESC, A.PRE_OP_CHECK_LIST, GET_DESC('"+locale+"','OT_CHECKLIST_HDR_LANG_VW','DESCRIPTION','CHECKLIST_CODE',D.CHECKLIST_CODE) DESCRIPTION, A.PRE_OP_NO_OF_VERIFICATIONS,A.PRE_OP_VERIFY1_USER_ROLE, GET_DESC('"+locale+"','OT_ROLES_LANG_VW','ROLE_DESC','ROLE_ID',E.ROLE_ID) ROLE_DESC, A.PRE_OP_VERIFY2_USER_ROLE, GET_DESC('"+locale+"','OT_ROLES_LANG_VW','ROLE_DESC','ROLE_ID',F.ROLE_ID) ROLE_DESC, A.PRE_OP_VERIFY3_USER_ROLE, GET_DESC('"+locale+"','OT_ROLES_LANG_VW','ROLE_DESC','ROLE_ID',G.ROLE_ID) ROLE_DESC, A.PRE_OP_VERIFY4_USER_ROLE, GET_DESC('"+locale+"','OT_ROLES_LANG_VW','ROLE_DESC','ROLE_ID',H.ROLE_ID) ROLE_DESC, A.POST_OP_CHECK_LIST, GET_DESC('"+locale+"','OT_CHECKLIST_HDR_LANG_VW','DESCRIPTION','CHECKLIST_CODE',N.CHECKLIST_CODE) DESCRIPTION, A.POST_OP_NO_OF_VERIFICATIONS, A.POST_OP_VERIFY1_USER_ROLE, GET_DESC('"+locale+"','OT_ROLES_LANG_VW','ROLE_DESC','ROLE_ID',I.ROLE_ID) ROLE_DESC, A.POST_OP_VERIFY2_USER_ROLE, GET_DESC('"+locale+"','OT_ROLES_LANG_VW','ROLE_DESC','ROLE_ID',J.ROLE_ID) ROLE_DESC, A.POST_OP_VERIFY3_USER_ROLE, GET_DESC('"+locale+"','OT_ROLES_LANG_VW','ROLE_DESC','ROLE_ID',K.ROLE_ID) ROLE_DESC, A.POST_OP_VERIFY4_USER_ROLE, GET_DESC('"+locale+"','OT_ROLES_LANG_VW','ROLE_DESC','ROLE_ID',L.ROLE_ID) ROLE_DESC, A.SWAB_INSTR_TMPL_ID,GET_DESC('"+locale+"','OT_SWAB_INSTR_TMPL_HDR_LANG_VW','DESCRIPTION','TEMPLATE_ID',M.TEMPLATE_ID) DESCRIPTION, nvl(A.ANAESTHESIA_REVIEW_REQD_YN,'N') ANAESTHESIA_REVIEW_REQD_YN, nvl(A.STATUS,'E') STATUS from OT_SPECIALITIES A,AM_SPECIALITY B,CA_CHART C,OT_CHECKLIST_HDR D,OT_CHECKLIST_HDR N,OT_ROLES E,OT_ROLES F,OT_ROLES G,OT_ROLES H,OT_ROLES I,OT_ROLES J,OT_ROLES K,OT_ROLES L,OT_SWAB_INSTR_TMPL_HDR M where A.SPECIALITY_CODE=B.SPECIALITY_CODE AND A.DISCR_MSR_ID=C.CHART_ID(+) AND A.PRE_OP_CHECK_LIST=D.CHECKLIST_CODE(+) AND A.PRE_OP_VERIFY1_USER_ROLE=E.ROLE_ID(+) AND A.PRE_OP_VERIFY2_USER_ROLE=F.ROLE_ID(+)  AND A.PRE_OP_VERIFY3_USER_ROLE=G.ROLE_ID(+)  AND A.PRE_OP_VERIFY4_USER_ROLE=H.ROLE_ID(+)  AND A.POST_OP_CHECK_LIST=N.CHECKLIST_CODE(+) AND A.POST_OP_VERIFY1_USER_ROLE=I.ROLE_ID(+)  AND A.POST_OP_VERIFY2_USER_ROLE=J.ROLE_ID(+)  AND A.POST_OP_VERIFY3_USER_ROLE=K.ROLE_ID(+)  AND A.POST_OP_VERIFY4_USER_ROLE=L.ROLE_ID(+)  AND A.SWAB_INSTR_TMPL_ID=M.TEMPLATE_ID(+) "+sql;

			strsql="select NULL, A.SPECIALITY_CODE, GET_DESC('"+locale+"','AM_SPECIALITY_LANG_VW','LONG_DESC','SPECIALITY_CODE',B.SPECIALITY_CODE) LONG_DESC, A.DISCR_MSR_ID,  GET_DESC('"+locale+"','CA_CHART_LANG_VW','SHORT_DESC','CHART_ID',C.CHART_ID) SHORT_DESC, A.PRE_OP_CHECK_LIST, GET_DESC('"+locale+"','OT_CHECKLIST_HDR_LANG_VW','DESCRIPTION','CHECKLIST_CODE',D.CHECKLIST_CODE) DESCRIPTION, A.PRE_OP_NO_OF_VERIFICATIONS,A.PRE_OP_VERIFY1_USER_ROLE, GET_DESC('"+locale+"','OT_ROLES_LANG_VW','ROLE_DESC','ROLE_ID',E.ROLE_ID) ROLE_DESC, A.PRE_OP_VERIFY2_USER_ROLE, GET_DESC('"+locale+"','OT_ROLES_LANG_VW','ROLE_DESC','ROLE_ID',F.ROLE_ID) ROLE_DESC, A.PRE_OP_VERIFY3_USER_ROLE, GET_DESC('"+locale+"','OT_ROLES_LANG_VW','ROLE_DESC','ROLE_ID',G.ROLE_ID) ROLE_DESC, A.PRE_OP_VERIFY4_USER_ROLE, GET_DESC('"+locale+"','OT_ROLES_LANG_VW','ROLE_DESC','ROLE_ID',H.ROLE_ID) ROLE_DESC, A.POST_OP_CHECK_LIST, GET_DESC('"+locale+"','OT_CHECKLIST_HDR_LANG_VW','DESCRIPTION','CHECKLIST_CODE',N.CHECKLIST_CODE) DESCRIPTION, A.POST_OP_NO_OF_VERIFICATIONS, A.POST_OP_VERIFY1_USER_ROLE, GET_DESC('"+locale+"','OT_ROLES_LANG_VW','ROLE_DESC','ROLE_ID',I.ROLE_ID) ROLE_DESC, A.POST_OP_VERIFY2_USER_ROLE, GET_DESC('"+locale+"','OT_ROLES_LANG_VW','ROLE_DESC','ROLE_ID',J.ROLE_ID) ROLE_DESC, A.POST_OP_VERIFY3_USER_ROLE, GET_DESC('"+locale+"','OT_ROLES_LANG_VW','ROLE_DESC','ROLE_ID',K.ROLE_ID) ROLE_DESC, A.POST_OP_VERIFY4_USER_ROLE, GET_DESC('"+locale+"','OT_ROLES_LANG_VW','ROLE_DESC','ROLE_ID',L.ROLE_ID) ROLE_DESC, A.SWAB_INSTR_TMPL_ID, GET_DESC('"+locale+"','OT_SWAB_INSTR_TMPL_HDR_LANG_VW','DESCRIPTION','TEMPLATE_ID',M.TEMPLATE_ID) DESCRIPTION, nvl(A.ANAESTHESIA_REVIEW_REQD_YN,'N') ANAESTHESIA_REVIEW_REQD_YN, nvl(A.STATUS,'E') STATUS,GET_DESC('"+locale+"','IP_MEDICAL_SERVICE_GRP_LANG_VW','SHORT_DESC','MED_SER_GRP_CODE',MED_SER_GRP_CODE) MED_SERVICE, A.DIAG_CODE_SCHEME ,GET_DESC('"+locale+"','MR_TERM_SET_LANG_VW','TERM_SET_DESC','TERM_SET_ID',A.DIAG_CODE_SCHEME) DIAG_CODE_DESC from OT_SPECIALITIES A,AM_SPECIALITY B,CA_CHART C,OT_CHECKLIST_HDR D,OT_CHECKLIST_HDR N,OT_ROLES E,OT_ROLES F,OT_ROLES G,OT_ROLES H,OT_ROLES I,OT_ROLES J,OT_ROLES K,OT_ROLES L,OT_SWAB_INSTR_TMPL_HDR M where A.SPECIALITY_CODE=B.SPECIALITY_CODE AND A.DISCR_MSR_ID=C.CHART_ID(+) AND A.PRE_OP_CHECK_LIST=D.CHECKLIST_CODE(+) AND A.PRE_OP_VERIFY1_USER_ROLE=E.ROLE_ID(+) AND A.PRE_OP_VERIFY2_USER_ROLE=F.ROLE_ID(+)  AND A.PRE_OP_VERIFY3_USER_ROLE=G.ROLE_ID(+)  AND A.PRE_OP_VERIFY4_USER_ROLE=H.ROLE_ID(+)  AND A.POST_OP_CHECK_LIST=N.CHECKLIST_CODE(+) AND A.POST_OP_VERIFY1_USER_ROLE=I.ROLE_ID(+)  AND A.POST_OP_VERIFY2_USER_ROLE=J.ROLE_ID(+)  AND A.POST_OP_VERIFY3_USER_ROLE=K.ROLE_ID(+)  AND A.POST_OP_VERIFY4_USER_ROLE=L.ROLE_ID(+)  AND A.SWAB_INSTR_TMPL_ID=M.TEMPLATE_ID(+) "+sql;	
		}else{
			strsql="select NULL, A.SPECIALITY_CODE,   GET_DESC('"+locale+"','AM_SPECIALITY_LANG_VW','LONG_DESC','SPECIALITY_CODE',B.SPECIALITY_CODE) LONG_DESC, A.DISCR_MSR_ID, NULL SHORT_DESC, A.PRE_OP_CHECK_LIST, GET_DESC('"+locale+"','OT_CHECKLIST_HDR_LANG_VW','DESCRIPTION','CHECKLIST_CODE',D.CHECKLIST_CODE) DESCRIPTION, A.PRE_OP_NO_OF_VERIFICATIONS,A.PRE_OP_VERIFY1_USER_ROLE, GET_DESC('"+locale+"','OT_ROLES_LANG_VW','ROLE_DESC','ROLE_ID',E.ROLE_ID) ROLE_DESC, A.PRE_OP_VERIFY2_USER_ROLE, GET_DESC('"+locale+"','OT_ROLES_LANG_VW','ROLE_DESC','ROLE_ID',F.ROLE_ID) ROLE_DESC, A.PRE_OP_VERIFY3_USER_ROLE, GET_DESC('"+locale+"','OT_ROLES_LANG_VW','ROLE_DESC','ROLE_ID',G.ROLE_ID) ROLE_DESC, A.PRE_OP_VERIFY4_USER_ROLE, GET_DESC('"+locale+"','OT_ROLES_LANG_VW','ROLE_DESC','ROLE_ID',H.ROLE_ID) ROLE_DESC, A.POST_OP_CHECK_LIST, GET_DESC('"+locale+"','OT_CHECKLIST_HDR_LANG_VW','DESCRIPTION','CHECKLIST_CODE',N.CHECKLIST_CODE) DESCRIPTION, A.POST_OP_NO_OF_VERIFICATIONS, A.POST_OP_VERIFY1_USER_ROLE, GET_DESC('"+locale+"','OT_ROLES_LANG_VW','ROLE_DESC','ROLE_ID',I.ROLE_ID) ROLE_DESC, A.POST_OP_VERIFY2_USER_ROLE, GET_DESC('"+locale+"','OT_ROLES_LANG_VW','ROLE_DESC','ROLE_ID',J.ROLE_ID) ROLE_DESC, A.POST_OP_VERIFY3_USER_ROLE, GET_DESC('"+locale+"','OT_ROLES_LANG_VW','ROLE_DESC','ROLE_ID',K.ROLE_ID) ROLE_DESC, A.POST_OP_VERIFY4_USER_ROLE, GET_DESC('"+locale+"','OT_ROLES_LANG_VW','ROLE_DESC','ROLE_ID',L.ROLE_ID) ROLE_DESC, A.SWAB_INSTR_TMPL_ID,GET_DESC('"+locale+"','OT_SWAB_INSTR_TMPL_HDR_LANG_VW','DESCRIPTION','TEMPLATE_ID',M.TEMPLATE_ID) DESCRIPTION, nvl(A.ANAESTHESIA_REVIEW_REQD_YN,'N') ANAESTHESIA_REVIEW_REQD_YN, nvl(A.STATUS,'E') STATUS,GET_DESC('"+locale+"','IP_MEDICAL_SERVICE_GRP_LANG_VW','SHORT_DESC','MED_SER_GRP_CODE',MED_SER_GRP_CODE) MED_SERVICE, A.DIAG_CODE_SCHEME,GET_DESC('"+locale+"','MR_TERM_SET_LANG_VW','TERM_SET_DESC','TERM_SET_ID',A.DIAG_CODE_SCHEME) DIAG_CODE_DESC from OT_SPECIALITIES A, AM_SPECIALITY B,OT_CHECKLIST_HDR D,OT_CHECKLIST_HDR N,OT_ROLES E,OT_ROLES F,OT_ROLES G,OT_ROLES H,OT_ROLES I,OT_ROLES J,OT_ROLES K,OT_ROLES L,OT_SWAB_INSTR_TMPL_HDR M where A.SPECIALITY_CODE=B.SPECIALITY_CODE AND A.PRE_OP_CHECK_LIST=D.CHECKLIST_CODE(+) AND A.PRE_OP_VERIFY1_USER_ROLE=E.ROLE_ID(+) AND A.PRE_OP_VERIFY2_USER_ROLE=F.ROLE_ID(+)  AND A.PRE_OP_VERIFY3_USER_ROLE=G.ROLE_ID(+)  AND A.PRE_OP_VERIFY4_USER_ROLE=H.ROLE_ID(+)  AND A.POST_OP_CHECK_LIST=N.CHECKLIST_CODE(+) AND A.POST_OP_VERIFY1_USER_ROLE=I.ROLE_ID(+)  AND A.POST_OP_VERIFY2_USER_ROLE=J.ROLE_ID(+)  AND A.POST_OP_VERIFY3_USER_ROLE=K.ROLE_ID(+)  AND A.POST_OP_VERIFY4_USER_ROLE=L.ROLE_ID(+)  AND A.SWAB_INSTR_TMPL_ID=M.TEMPLATE_ID(+) "+sql;
		}
		//debug_sql = strsql ;
		//out.println(strsql);
     try{
 		conn  =  ConnectionManager.getConnection(request);
		pstmt = conn.prepareStatement(strsql,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		rst = pstmt.executeQuery();
		//getting maximum record
		rst.last();	maxRecord = rst.getRow();
		if(maxRecord == 0){
		out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));history.go(-1);</script>");
			
		}
		//again move the resultset pointer to initial position
		rst.beforeFirst();
%>
<form name='QueryResult' id='QueryResult'>
<P>
<table align='right'>
<tr>
<td>

<%
if ( !(start <= 1) )
    out.println("<A HREF='../../eOT/jsp/SpecialitiesPrePostOperativeChecklistQueryResult.jsp?from="+(start-14)+"&ca_module_yn="+ca_module_yn+"&to="+(end-14)+"&whereclause=" + URLEncoder.encode(sql) + "'" + " text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

if ( !( (start+14) > maxRecord ) )
    out.println("<A HREF='../../eOT/jsp/SpecialitiesPrePostOperativeChecklistQueryResult.jsp?from="+(start+14)+"&ca_module_yn="+ca_module_yn+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
%>
</td>
</tr>
</table>

<br><br>
</p>

<table  class='grid'  border="1" width="100%" cellspacing='0' cellpadding='3' align='center'>
<!-- Width=20%-->
<!-- appending Headers to StringBuffer -->
<%
	 final String TD ="<th class='columnheader' nowrap >"; // changed by yadav
	//Speciality
	sbr.append(TD);
   	String lbl_speciality=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.speciality.label","common_labels"); 
	sbr.append(lbl_speciality);
	sbr.append("</th>");
	//Diagnosis Code Scheme
	sbr.append(TD);
	String lbl_diag_code_scheme=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.ProcedureCodingScheme.Label","ot_labels"); 
	sbr.append(lbl_diag_code_scheme);
	sbr.append("</td>");
	//Chart Id
	if(ca_module_yn.equals("Y")){
		sbr.append(TD);
		String lbl_chartId=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ChartID.label","common_labels");
		sbr.append(lbl_chartId);
		sbr.append("</td>");
	}
	//SwabAndInstrument
	sbr.append(TD);
	String lbl_swabInst=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.SwabandInstrumentCount.Label","ot_labels"); 
	sbr.append(lbl_swabInst);
	sbr.append("</td>");
	//AnaesthesiaRequriedYN
	//sbr.append(TD);
	//String lbl_medSerGrp=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.MedicalServiceGroup.label","ip_labels"); 
	//sbr.append(lbl_medSerGrp);
	//sbr.append("</td>");
	//AnaesthesiaRequriedYN
	sbr.append(TD);
	String lbl_anaesthesia_review=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.AnaesthesiaReviewRequired.Label","ot_labels"); 
	sbr.append(lbl_anaesthesia_review);
	sbr.append("</td>");
	//enabled

  if ( start!= 1 ) rst.absolute(start-1);
		i=start;
      while ( rst.next() && i<=end  ){
	     //classValue = ( i % 2 == 0 )?"QRYEVEN":"QRYODD";
	     classValue = "gridData"; // changed by yadav
         //speciality_code = rst.getString(1);
		 speciality_code = rst.getString(2);
		 //chart_id=rst.getString(4);
		
	sbr.append("<tr>");
	//speciality_desc
	 sbr.append("<td class='"+classValue+"' nowrap>");
	 sbr.append("<a href='../../eOT/jsp/SpecialitiesPrePostOperativeChecklistAddModify.jsp?&ca_module_yn="+ca_module_yn+"&mode=modify&speciality_code="+ speciality_code+"' target='f_query_add_mod' >");
	 sbr.append(rst.getString(3)+"</a></td>");
	
	 
	 //Diagnosis Code Scheme
    

	String icd_value=checkForNull(rst.getString(34));

//Commented by rajesh for crf 303.1 remved static values and changed the query for diag_code_desc
/*	if(icd_value.equals("1")){
		icd_value=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.UserDefined.label","common_labels");
	}else if(icd_value.equals("2")){
		icd_value=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.icd10pcs.label","common_labels");
	} else if(icd_value.equals("4")){
		icd_value=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ICD9CM.label","common_labels");
	} else if(icd_value.equals("3")){
		icd_value=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.CPT4.label","common_labels");
	}else{
		icd_value="&nbsp;";
	}
*/	
	
	sbr.append("<td class='"+ classValue+"'>");
	 sbr.append(icd_value);
	//sbr.append(checkForNull(rst.getString(33),"&nbsp;"));
	sbr.append("</td>");	


	//chart_id
	if("Y".equals(ca_module_yn)){
	
	sbr.append("<td class='"+ classValue+"'>");
	 sbr.append(checkForNull(rst.getString(4),"&nbsp;"));
	 sbr.append("</td>");	
		
	}
	//SwabAndInstrument 
     sbr.append("<td class='"+ classValue+"'>");
	 sbr.append(checkForNull(rst.getString(28),"&nbsp;"));
	 sbr.append("</td>");	

	 //Medical Service Group
  /*   sbr.append("<td class='"+ classValue+"'>");
	 sbr.append(checkForNull(rst.getString(32),"&nbsp;"));
	 sbr.append("</td>");	
 */
   // for Anaesthesia Review RequiredYN
	sbr.append("<td class='"+ classValue+"'>");
	sbr.append("Y".equals(rst.getString(30))?img_enabled:img_disabled);
	sbr.append("</td>");	
   
/*   //Status
	sbr.append("<td class='"+ classValue+"'>");
	sbr.append("E".equals(rst.getString("status"))?img_enabled:img_disabled);
	sbr.append("</td>");	
	
	//Pre-Op CheckList	
	 sbr.append("<td class='"+ classValue+"'>");
	 sbr.append(checkForNull(rst.getString(6),"&nbsp;"));
	 sbr.append("</td>");	
   //No of Verification - Pre-Op	
	 sbr.append("<td class='gridData'>");  // changed by yadav
	 sbr.append(checkForNull(rst.getString(8),"&nbsp;"));
	 sbr.append("</td>");	
	
   //Role 1
	 sbr.append("<td class='"+ classValue+"'>");
	 sbr.append(checkForNull(rst.getString(9),"&nbsp;"));
	 sbr.append("</td>");	
	
   //Role 2
	 sbr.append("<td class='"+ classValue+"'>");
	 sbr.append(checkForNull(rst.getString(11),"&nbsp;"));
	 sbr.append("</td>");	

	 //Role 3
	 sbr.append("<td class='"+ classValue+"'>");
	 sbr.append(checkForNull(rst.getString(13),"&nbsp;"));
	 sbr.append("</td>");	

	 //Role 4
	 sbr.append("<td class='"+ classValue+"'>");
	 sbr.append(checkForNull(rst.getString(15),"&nbsp;"));
	 sbr.append("</td>");	


	 //Post-Op CheckList	
	 sbr.append("<td class='"+ classValue+"'>");
	 sbr.append(checkForNull(rst.getString(17),"&nbsp;"));
	 sbr.append("</td>");	

   //No of Verification - Post-Op	
	 sbr.append("<td class='"+ classValue+"'>");
	 sbr.append(checkForNull(rst.getString(19),"&nbsp;"));
	 sbr.append("</td>");	
	
   //Role 1
	 sbr.append("<td class='"+ classValue+"'>");
	 sbr.append(checkForNull(rst.getString(20),"&nbsp;"));
	 sbr.append("</td>");	
	
   //Role 2
	 sbr.append("<td class='"+ classValue+"'>");
	 sbr.append(checkForNull(rst.getString(22),"&nbsp;"));
	 sbr.append("</td>");	

	 //Role 3
	 sbr.append("<td class='"+ classValue+"'>");
	 sbr.append(checkForNull(rst.getString(24),"&nbsp;"));
	 sbr.append("</td>");	

	 //Role 4
	 sbr.append("<td class='"+ classValue+"'>");
	 sbr.append(checkForNull(rst.getString(26),"&nbsp;"));
	 sbr.append("</td>");	*/
   	i++;
 }
   out.println(sbr.toString());
   }catch(Exception e){
	   e.printStackTrace();
	   //System.err.println("SpecialitiesPrePostOperativeChecklistQueryResult.jsp"+e.getMessage());
   }finally{
	   try{
			if(pstmt!=null)	pstmt.close();
			if(rst!=null) rst.close();
			sbr.setLength(0);
			ConnectionManager.returnConnection(conn,request);
	   }catch(Exception e){e.printStackTrace();}
   }
%>
</table>
</center>
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
</form>
</BODY>
</HTML>

