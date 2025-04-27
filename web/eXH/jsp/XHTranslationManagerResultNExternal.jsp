<!DOCTYPE html>

<%
	Connection con = null;
	String sStyle = (session.getAttribute("PREFERRED_STYLE") != null)
			|| (session.getAttribute("PREFERRED_STYLE") != "") ? (String) session
			.getAttribute("PREFERRED_STYLE")
			: "IeStyle.css";
	sStyle = "IeStyle.css";
%>
 
<%@ page contentType="text/html;charset=UTF-8"
	import="webbeans.eCommon.*,java.sql.*,java.util.*,java.text.*,eXH.*;"%>

<%
	request.setCharacterEncoding("UTF-8");
	try {
		Properties p = (Properties) session.getValue("jdbc");
		String loggedUser = p.getProperty("login_user");
		StringBuffer sql = new StringBuffer();
		con = ConnectionManager.getConnection(request);
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String lang = "";
		//String facilityId = (String) session.getValue("facility_id");	    
		String module_id = request.getParameter("module_id") == null ? ""
		: request.getParameter("module_id");
//		System.out.println("XHTranslationManagerResultN.jsp module_id : "	+ module_id);
		String masterName = request.getParameter("masterName") == null ? ""
		: request.getParameter("masterName");

//		System.out.println("XHTranslationManagerResultN.jsp masterName : "	+ masterName);
		String language = request.getParameter("language") == null ? ""
		: request.getParameter("language");
		String language_direction = request
		.getParameter("language_direction") == null ? ""
		: request.getParameter("language_direction");

		String appl = request.getParameter("application") == null ? ""
		: request.getParameter("application");

//		System.out.println("XHTranslationManagerResultN.jsp application : "+ appl);

		String display = request.getParameter("display") == null ? ""
		: request.getParameter("display");
		//System.out.println("XHTranslationManagerResultN.jsp display : "	+ display);

		String searchText = request.getParameter("searchText") == null ? ""
		: request.getParameter("searchText");
//		System.out.println("XHTranslationManagerResultN.jsp searchText : "+ searchText);
		String searchText1 = searchText;
		String Searchbymod = request.getParameter("Searchbymod") == null ? ""
		: request.getParameter("Searchbymod");
//		System.out.println("XHTranslationManagerResultN.jsp Searchbymod : "+ Searchbymod);
		String SearchbyFunct = request.getParameter("SearchbyFunct") == null ? ""
		: request.getParameter("SearchbyFunct");
//		System.out.println("XHTranslationManagerResultN.jsp SearchbyFunct : "+ SearchbyFunct);
		String start_ends_contains = request
		.getParameter("start_ends_contains") == null ? ""
		: request.getParameter("start_ends_contains");
//		System.out.println("XHTranslationManagerResultN.jsp start_ends_contains : "+ start_ends_contains);
		String outbound_yn = "X";
		//request.getParameter("outbound_yn");			   
		//		System.out.println("outbound_yn : "+outbound_yn);
		String searchpk2 = request.getParameter("searchpk2") == null ? ""
		: request.getParameter("searchpk2");
//		System.out.println("XHTranslationManagerResultN.jsp searchpk2 : "	+ searchpk2);
		String searchpk2Val = searchpk2;
		String searchpk3 = request.getParameter("searchpk3") == null ? ""
		: request.getParameter("searchpk3");
//		System.out.println("XHTranslationManagerResultN.jsp searchpk3 : "	+ searchpk3);
		String searchpk3Val = searchpk3;
		String external_yn = XHDBAdapter.checkNullForCheckBox(request
		.getParameter("external_yn"));
//		System.out.println("XHTranslationManagerResultNExternal.jsp external_yn : "+ external_yn);
		if (start_ends_contains.equals("S")) {
			searchText = searchText + "%";
			searchpk2 = searchpk2 + "%";
			searchpk3 = searchpk3 + "%";

		} else if (start_ends_contains.equals("E")) {
			searchText = "%" + searchText;
			searchpk2 = "%" + searchpk2;
			searchpk3 = "%" + searchpk3;
		} else if (start_ends_contains.equals("C")) {
			searchText = "%" + searchText + "%";
			searchpk2 = "%" + searchpk2 + "%";
			searchpk3 = "%" + searchpk3 + "%";
		}
		String table_or_form = "";

		String table_desc = "";
		int startVal = 0;
		String pk2 = "";
		int colCount = 0;
		String classValue = "";
		String trans_table_id = "";
		String master_table_id = "";
		String pk1 = "";
		String temppk2 = "";
		String from = request.getParameter("from");
		String to = request.getParameter("to");

		String trans_tbl_type = "";

		ArrayList pkval = new ArrayList();
		ArrayList pkValue = new ArrayList();

		ArrayList pkLen = new ArrayList();
		ArrayList pkPrompt = new ArrayList();
		ArrayList columnPrompt = new ArrayList();
		ArrayList columnVal = new ArrayList();

		ArrayList colValue = new ArrayList();
		ArrayList columnLen = new ArrayList();
		int start = 0;
		int end = 0;
		int maxRecord = 0;

		if (from == null)
			start = 1;
		else
			start = Integer.parseInt(from);

		if (to == null)
			end = 20;
		else
			end = Integer.parseInt(to);

		//	System.out.println("trans_table_id : "+trans_table_id);
		//	System.out.println("start : "+start+" end : "+end);
%>


<script>/* parent.messageFrame.location.href='../../eCommon/jsp/error.jsp' */</script>
<%
		sql.setLength(0);

		sql.append("select * from xh_mapping  where  MASTER_TABLE_ID='"
		+ masterName + "' order by SRL_NO ");

		

		pstmt = con.prepareStatement(sql.toString());
		rs = pstmt.executeQuery();
		int count = 0;
		while (rs.next()) {
			table_desc = rs.getString("table_desc") == null ? "" : rs
			.getString("table_desc");
			table_or_form = rs.getString("table_or_form") == null ? ""
			: rs.getString("table_or_form");
			if (rs.getString("pk_yn").equals("Y")) {

		pkval.add(rs.getString("COLUMN_ID") == null ? "" : rs
				.getString("COLUMN_ID"));
		pkLen.add(rs.getString("COLUMN_LENGTH") == null ? ""
				: rs.getString("COLUMN_LENGTH"));
		pkPrompt.add(rs.getString("COLUMN_PROMPT") == null ? ""
				: rs.getString("COLUMN_PROMPT"));
		pkValue
				.add(rs.getString("TRANS_COLUMN_ID") == null ? ""
				: rs.getString("TRANS_COLUMN_ID"));
		count++;
			}
			// else
			else if (!(rs.getString("COLUMN_ID").equals("LONG_DESC"))) {
		columnLen
				.add(rs.getString("COLUMN_LENGTH") == null ? ""
				: rs.getString("COLUMN_LENGTH"));
		columnVal.add(rs.getString("COLUMN_ID") == null ? ""
				: rs.getString("COLUMN_ID"));
		columnPrompt
				.add(rs.getString("COLUMN_PROMPT") == null ? ""
				: rs.getString("COLUMN_PROMPT"));
		colValue
				.add(rs.getString("TRANS_COLUMN_ID") == null ? ""
				: rs.getString("TRANS_COLUMN_ID"));
		count++;
			}
			trans_table_id = rs.getString("trans_table_id") == null ? ""
			: rs.getString("trans_table_id");
			master_table_id = rs.getString("master_table_id") == null ? ""
			: rs.getString("master_table_id");

			int trans_tbl_len = trans_table_id.length();
			trans_tbl_type = trans_table_id.substring(
			trans_tbl_len - 4, trans_tbl_len);
			if (count == 0) {
			}

			//	count++;
		}
		//		System.out.println("Count : "+count);

		if (rs != null)
			rs.close();
		if (pstmt != null)
			pstmt.close();
%>

<html>
	<head>

		<link rel='stylesheet' type='text/css'
			href='../../eCommon/html/<%=sStyle%>'></link>
		<link rel='stylesheet' type='text/css'
			href='../../eCommon/html/<%=sStyle%>'></link>
		<script src='../../eCommon/js/ValidateControl.js'
			language='javascript'></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
		<script language='javascript' src='../js/XHTranslationManagerN.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>





	</head>
	<body onLoad='FocusFirstElement()' OnMouseDown='CodeArrest()'
		onKeyDown='lockKey()'>
		<form name="TranslationResult" id="TranslationResult" method=post
			action='../../servlet/eXH.XHTranslationManagerServletN'
			target="messageFrame">

			<%
					sql.setLength(0);

					sql
					.append("Select count(*)  total from (Select 'en' APPLICATION_ID, 1 seq_no,");

					if (!masterName.equals("SM_MASTER_CODE")) {
						for (startVal = 0; startVal < pkValue.size(); startVal++) {
							sql.append(pkValue.get(startVal));
							if (startVal < pkValue.size() ) {
								sql.append(",");
							}
						}
					} // end of !SM_MASTER_CODE 
					else {
						sql.append("MODULE_ID,to_char(MASTER_CODE),");
					}

					if (trans_table_id.equals("XH_OTH_APPL_DATA_SKEY")
					|| trans_table_id.equals("XH_OTH_APPL_DATA_DKEY")
					|| trans_tbl_type.equals("APPL")) {
						for (startVal = 0; startVal < columnVal.size(); startVal++) {
							sql.append("desc" + (startVal + 2) + "_Value");
							if (startVal < columnVal.size() - 1) {
								sql.append(",");
							}
						}
					} // added on 12th March 2009
					else {
						for (startVal = 0; startVal < colValue.size(); startVal++) {
							sql.append(colValue.get(startVal));
							if (startVal < (colValue.size() - 1)) {
								sql.append(",");
							}
						}
					}
					//		System.out.println(" trans_table_id sql 264 : "+sql);

					// Non-Translated
					if (display.equals("N")) {

						sql.append(" from  " + trans_table_id + "  where ");
						if (trans_table_id.equals("XH_OTH_APPL_DATA_SKEY")) {
						sql
								.append("table_id='" + masterName
								+ "' and APPLICATION_ID='" + appl
								+ "'   and OUTBOUND_YN='" + outbound_yn
								+ "'  ");
								if (columnVal.size() > 0) {

                                    if(columnVal.size() > 1)
									{
										sql.append("	 and (desc2_value is null AND ext_pk_id is null ) /* ) */ AND ( (UPPER(NVL("+ pkValue.get(0)+ ",'*')) like upper('"+ searchText + "') OR UPPER(NVL("+ columnVal.get(0)+ ",'*')) like upper('"+ searchText + "')) OR (UPPER(NVL("+ pkValue.get(1)+ ",'*')) like upper('"+ searchText + "') OR UPPER(NVL("+ columnVal.get(1)+ ",'*')) like upper('"+ searchText + "')) )");
									}
									else
									{
										sql.append("	 and (desc2_value is null AND ext_pk_id is null ) /* ) */ AND (UPPER(NVL("+ pkValue.get(0)+ ",'*')) like upper('"+ searchText + "') OR UPPER(NVL("+ pkValue.get(1)+ ",'*')) like upper('"+ searchText + "'))");
									}
								} else {
                                    
									if(columnVal!=null && columnVal.size() > 0)
									{
										sql.append(" and ext_pk_id is null AND (UPPER(NVL("+ pkValue.get(0) + ",'*')) like upper('"+ searchText + "') OR UPPER(NVL("+ columnVal.get(0) + ",'*')) like upper('"+ searchText + "'))) ");
									}
									else
									{
										sql.append(" and ext_pk_id is null AND UPPER(NVL("+ pkValue.get(0) + ",'*')) like upper('"+ searchText + "')) ");
									}
								}
						}
						if (trans_table_id.equals("XH_OTH_APPL_DATA_DKEY")) 
						{
							if(columnVal!=null && columnVal.size() > 1)
							{
								sql.append("table_id='"+ masterName+ "' and APPLICATION_ID='"+ appl+ "' and OUTBOUND_YN='"+ outbound_yn+ "'  and (desc2_value is null AND ext_pk1_value IS  NULL AND ext_pk2_value IS  NULL) /* ) */ AND ( (UPPER(NVL("+ pkValue.get(0) + ",'*')) like upper('"+ searchText + "') OR UPPER(NVL("+ columnVal.get(0) + ",'*')) like upper('"+ searchText + "')) OR (UPPER(NVL("+ pkValue.get(1) + ",'*')) like upper('"+ searchText + "') OR UPPER(NVL("+ columnVal.get(1) + ",'*')) like upper('"+ searchText + "')))  AND (UPPER(NVL("+ pkValue.get(1) + ",'*')) like upper('"+ searchpk2 + "') OR UPPER(NVL("+ columnVal.get(1) + ",'*')) like upper('"+ searchpk2 + "')) ");
							}
                            else
							{
								sql.append("table_id='"+ masterName+ "' and APPLICATION_ID='"+ appl+ "' and OUTBOUND_YN='"+ outbound_yn+ "'  and (desc2_value is null AND ext_pk1_value IS  NULL AND ext_pk2_value IS  NULL) /* ) */ AND (UPPER(NVL("+ pkValue.get(0) + ",'*')) like upper('"+ searchText + "') OR UPPER(NVL("+ pkValue.get(1) + ",'*')) like upper('"+ searchText + "'))  AND UPPER(NVL("+ pkValue.get(1) + ",'*')) like upper('"+ searchpk2 + "') ");
							}
							
						}
						if (trans_table_id.equals("XH_OTH_APPL_DATA_SKEY")
						|| trans_table_id.equals("XH_OTH_APPL_DATA_DKEY")) {

							sql.append("  union	 SELECT  '" + appl
									+ "' APPLICATION_ID,2 SEQ_NO, ");

						} else if (trans_tbl_type.equals("APPL")) {
							if(columnVal!=null && columnVal.size() > 2)
							{
								sql.append(" APPLICATION_ID='"+ appl+ "'  and OUTBOUND_YN='"+ outbound_yn+ "'  and (desc2_value is null AND ext_pk1_value IS  NULL AND ext_pk2_value IS  NULL  AND ext_pk3_value IS  NULL) ) AND (UPPER(NVL("+ pkval.get(0) + ",'*')) like upper('"+ searchText + "') OR UPPER(NVL("+ columnVal.get(0) + ",'*')) like upper('"+ searchText + "'))  AND (UPPER(NVL("+ pkval.get(1) + ",'*')) like upper('"+ searchpk2 + "') OR UPPER(NVL("+ columnVal.get(1) + ",'*')) like upper('"+ searchpk2 + "'))  and  (UPPER(NVL("+ pkval.get(2) + ",'*')) like upper('"+ searchpk3 + "') OR UPPER(NVL("+ columnVal.get(2) + ",'*')) like upper('"+ searchpk3 + "'))");
							}
                            else
							{
								sql.append(" APPLICATION_ID='"+ appl+ "'  and OUTBOUND_YN='"+ outbound_yn+ "'  and (desc2_value is null AND ext_pk1_value IS  NULL AND ext_pk2_value IS  NULL  AND ext_pk3_value IS  NULL) ) AND UPPER(NVL("+ pkval.get(0) + ",'*')) like upper('"+ searchText + "')  AND UPPER(NVL("+ pkval.get(1) + ",'*')) like upper('"+ searchpk2 + "')  and  UPPER(NVL("+ pkval.get(2) + ",'*')) like upper('"+ searchpk3 + "')");
							}
							
							sql.append("  union	 SELECT  '" + appl
									+ "' APPLICATION_ID,2 SEQ_NO, ");
						} else {

					// code added on 25th Dec - Name Prefix - only for Code
					//   sql.append("APPLICATION_ID='"+appl+"'  and "+columnVal.get(0)+" is null)  AND UPPER(NVL("+columnVal.get(0)+",'*')) like upper('"+searchText+"' )"); 
					sql.append("APPLICATION_ID='" + appl + "' ");
					if(columnVal!=null && columnVal.size() > 2)
					{
						sql.append(" ) AND (UPPER(NVL(" + pkval.get(0)+ ",'*')) like upper('" + searchText+ "' ) OR UPPER(NVL(" + columnVal.get(0)+ ",'*')) like upper('" + searchText+ "' ))  and  (UPPER(NVL(" + pkval.get(1)+ ",'*')) like upper('" + searchpk2+ "') OR UPPER(NVL(" + columnVal.get(1)+ ",'*')) like upper('" + searchpk2+ "')) and  (UPPER(NVL(" + pkval.get(2)+ ",'*')) like upper('" + searchpk3 + "') OR UPPER(NVL(" + columnVal.get(2)+ ",'*')) like upper('" + searchpk3 + "'))");
					}
					else
					{
						sql.append(" ) AND UPPER(NVL(" + pkval.get(0)+ ",'*')) like upper('" + searchText+ "' )  and  UPPER(NVL(" + pkval.get(1)+ ",'*')) like upper('" + searchpk2+ "') and  UPPER(NVL(" + pkval.get(2)+ ",'*')) like upper('" + searchpk3 + "')");

					}
					
					// end of code added

					sql.append(" union	 SELECT  '" + appl
							+ "' APPLICATION_ID,2 SEQ_NO,");

						}
						if (trans_table_id.equals("XH_OTH_APPL_DATA_SKEY")) {
							// code added on 24th Dec - Name Prefix - only for Code
							// sql.append("pk_value,");
							if (columnVal.size() > 0) {
								sql.append("pk_value,");
							} else {
								sql.append("pk_value");
							}
							// end of code added 
							for (startVal = 0; startVal < columnVal.size(); startVal++) {
								//	     	Cmmnt on Oct16 sql.append("desc"+(startVal+1)+"_Value");
								sql.append("desc" + (startVal + 2) + "_Value");

								if (startVal < columnVal.size() - 1) {
									sql.append(",");
								}
							}
						} else if (trans_table_id.equals("XH_OTH_APPL_DATA_DKEY")) {
							sql.append("pk1_value,pk2_value,");
							for (startVal = 0; startVal < columnVal.size(); startVal++) {
								sql.append("desc" + (startVal + 2) + "_Value");
								if (startVal < columnVal.size() - 1) {
									sql.append(",");
								}
							}
						} else if (trans_tbl_type.equals("APPL")) {
							sql.append("pk1_value,pk2_value,pk3_value,");
							for (startVal = 0; startVal < columnVal.size(); startVal++) {
								sql.append("desc" + (startVal + 2) + "_Value");
								if (startVal < columnVal.size() - 1) {
									sql.append(",");
								}
							}
						} else {
								for (startVal = 0; startVal < pkval.size(); startVal++) {
									sql.append(pkval.get(startVal) + ",");
								}

								for (startVal = 0; startVal < columnVal.size(); startVal++) {
									sql.append(columnVal.get(startVal));
									if (startVal < columnVal.size() - 1) {
										sql.append(",");
									}

								}
						}

						if (trans_table_id.equals("XH_OTH_APPL_DATA_SKEY")) {

							sql.append("   FROM  " + trans_table_id
									+ "  WHERE APPLICATION_ID = '" + appl
									+ "' and table_id='" + masterName
									+ "'  and OUTBOUND_YN='" + outbound_yn + "' ");

							if (columnVal.size() > 0) {
								sql
								.append("   and  (desc2_value is null AND ext_pk_id is null ) ");
							} else {
								sql.append("   and  ext_pk_id is null ");
							}
							if(columnVal!=null && columnVal.size() > 0)
							{
								sql.append(" AND /* pk_value IN (SELECT "+ pkval.get(0) + "  from " + masterName+ "  where */ (UPPER(NVL(" + pkValue.get(0)+ ",'*')) LIKE upper('" + searchText+ "') OR UPPER(NVL(" + columnVal.get(0)+ ",'*')) LIKE upper('" + searchText+ "'))) /*) */ ");
							}
							else
							{
								sql.append(" AND /* pk_value IN (SELECT "+ pkval.get(0) + "  from " + masterName+ "  where */ UPPER(NVL(" + pkValue.get(0)+ ",'*')) LIKE upper('" + searchText+ "')) /*) */ ");
							}

							
						}// end of XH_OTH_APPL_DATA_SKEY 
						else if (trans_table_id.equals("XH_OTH_APPL_DATA_DKEY")) {
							sql
									.append("   FROM  "
									+ trans_table_id
									+ "  WHERE  (DESC2_VALUE IS NULL AND ext_pk1_value IS NULL AND ext_pk2_value IS NULL) and APPLICATION_ID = '"
									+ appl + "' and table_id='"
									+ masterName + "'  and OUTBOUND_YN='"
									+ outbound_yn + "' ");

							//	sql.append(pkval.get(1) + "  from " + masterName
							if(columnVal!=null && columnVal.size() > 1)
							{
								sql.append("AND (UPPER(NVL(" + pkValue.get(0)+ ",'*')) like upper('" + searchText+ "') OR UPPER(NVL(" + columnVal.get(0)+ ",'*')) like upper('" + searchText+ "'))  AND (UPPER(NVL(" + pkValue.get(1)+ ",'*')) like upper('" + searchpk2+ "') OR UPPER(NVL(" + columnVal.get(1)+ ",'*')) like upper('" + searchpk2+ "')) ) /*) */ ");
							}
							else
							{
								sql.append("AND UPPER(NVL(" + pkValue.get(0)+ ",'*')) like upper('" + searchText+ "')  AND UPPER(NVL(" + pkValue.get(1)+ ",'*')) like upper('" + searchpk2+ "') ) /*) */ ");
							}
							
						} // end of  XH_OTH_APPL_DATA_DKEY
						else if (trans_tbl_type.equals("APPL")) {
							sql
									.append("   FROM  "
									+ trans_table_id
									+ "  WHERE  (DESC2_VALUE IS NULL AND ext_pk1_value IS NULL AND ext_pk2_value IS NULL AND ext_pk3_value IS NULL) and APPLICATION_ID = '"
									+ appl + "' and OUTBOUND_YN='"
									+ outbound_yn + "' ");
							sql
									.append(" AND (pk1_value,pk2_value,pk3_value) IN (SELECT "
									+ pkval.get(0)
									+ ","
									+ pkval.get(1)
									+ "," + pkval.get(2));

							if(columnVal!=null && columnVal.size() > 2)
							{
								sql.append("  from " + masterName+ "  where  (UPPER(NVL(" + pkval.get(0)+ ",'*')) like upper('" + searchText+ "') OR UPPER(NVL(" + columnVal.get(0)+ ",'*')) like upper('" + searchText+ "'))  AND (UPPER(NVL(" + pkval.get(1)+ ",'*')) like upper('" + searchpk2+ "') OR UPPER(NVL(" + columnVal.get(1)+ ",'*')) like upper('" + searchpk2+ "'))  and  (UPPER(NVL(" + pkval.get(2)+ ",'*')) like upper('" + searchpk3 + "') OR UPPER(NVL(" + columnVal.get(2)+ ",'*')) like upper('" + searchpk3 + "')) ))");
							}
							else
							{
								sql.append("  from " + masterName+ "  where  UPPER(NVL(" + pkval.get(0)+ ",'*')) like upper('" + searchText+ "')  AND UPPER(NVL(" + pkval.get(1)+ ",'*')) like upper('" + searchpk2+ "')  and  UPPER(NVL(" + pkval.get(2)+ ",'*')) like upper('" + searchpk3 + "') ))");
							}

						} // end of APPL
						else {
							sql.append("   FROM  " + trans_table_id
								+ "  WHERE  APPLICATION_ID = '" + appl + "' ");
							sql.append(" and  (");
							for (startVal = 0; startVal < pkValue.size(); startVal++) {
								sql.append(pkValue.get(startVal));
								if (startVal < pkValue.size() - 1) {
									sql.append(",");
								}
							}
							sql.append(" ) IN (SELECT ");
							for (startVal = 0; startVal < pkValue.size(); startVal++) {
								sql.append(pkValue.get(startVal));
								if (startVal < pkValue.size() - 1) {
									sql.append(",");
								}
							}

							if(columnVal!=null && columnVal.size() > 2)
							{
								sql.append(" from " + masterName + "  where (UPPER(NVL("+ pkval.get(0) + ",'*')) LIKE upper('"+ searchText + "') OR UPPER(NVL("+ columnVal.get(0) + ",'*')) LIKE upper('"+ searchText + "'))  and  (UPPER(NVL("+ pkval.get(1) + ",'*')) like upper('"+ searchpk2 + "') OR UPPER(NVL("+ columnVal.get(1) + ",'*')) like upper('"+ searchpk2 + "')) and  (UPPER(NVL("+ pkval.get(2) + ",'*')) like upper('"+ searchpk3 + "') OR UPPER(NVL("+ columnVal.get(2) + ",'*')) like upper('"+ searchpk3 + "')) ))");
							}
							else
							{
								sql.append(" from " + masterName + "  where UPPER(NVL("+ pkval.get(0) + ",'*')) LIKE upper('"+ searchText + "')  and  UPPER(NVL("+ pkval.get(1) + ",'*')) like upper('"+ searchpk2 + "') and  UPPER(NVL("+ pkval.get(2) + ",'*')) like upper('"+ searchpk3 + "')))");
							}

						} // end of !(SKEY ,DKEY)

					} // end of Non-Translated

					// 	 Translated
					else if (display.equals("T")) {

						sql.append(" from  " + trans_table_id + "  where ");

						if (trans_table_id.equals("XH_OTH_APPL_DATA_SKEY")) {
							sql.append("table_id='" + masterName
								+ "' and APPLICATION_ID='" + appl
								+ "' 	 and OUTBOUND_YN='" + outbound_yn + "' ");
							if (columnVal.size() > 0) {
								sql
								.append("and (desc2_value is not null OR ext_pk_id is not null ) /* )*/ ");
							} else {
								sql.append(" AND ext_pk_id is not null /* )*/ ");
							}
							if(columnVal!=null && columnVal.size() > 0)
							{
								sql.append(" AND (UPPER(NVL(" + pkValue.get(0)+ ",'*')) like upper('" + searchText + "') OR UPPER(NVL(" + columnVal.get(0)+ ",'*')) like upper('" + searchText + "')) ");
							}
							else
							{
								sql.append(" AND UPPER(NVL(" + pkValue.get(0)+ ",'*')) like upper('" + searchText + "') ");
							}
							
						}
						if (trans_table_id.equals("XH_OTH_APPL_DATA_DKEY")) {

							if(columnVal!=null && columnVal.size() > 1)
							{
								sql.append("table_id='"+ masterName+ "' and APPLICATION_ID='"+ appl+ "'  and OUTBOUND_YN='"+ outbound_yn+ "' and (DESC2_VALUE IS NOT NULL OR ext_pk1_value IS NOT NULL OR ext_pk2_value IS NOT NULL) /* )*/ AND (UPPER(NVL("+ pkValue.get(0) + ",'*')) like upper('"+ searchText + "') OR UPPER(NVL("+ columnVal.get(0) + ",'*')) like upper('"+ searchText + "'))  AND (UPPER(NVL("+ pkValue.get(1) + ",'*')) like upper('"+ searchpk2 + "') OR UPPER(NVL("+ columnVal.get(1) + ",'*')) like upper('"+ searchpk2 + "')) ");
							}
							else
							{
								sql.append("table_id='"+ masterName+ "' and APPLICATION_ID='"+ appl+ "'  and OUTBOUND_YN='"+ outbound_yn+ "' and (DESC2_VALUE IS NOT NULL OR ext_pk1_value IS NOT NULL OR ext_pk2_value IS NOT NULL) /* )*/ AND UPPER(NVL("+ pkValue.get(0) + ",'*')) like upper('"+ searchText + "')  AND UPPER(NVL("+ pkValue.get(1) + ",'*')) like upper('"+ searchpk2 + "') ");
							}
						}
						if (trans_table_id.equals("XH_OTH_APPL_DATA_SKEY")
						|| trans_table_id.equals("XH_OTH_APPL_DATA_DKEY")) {
							sql.append("  union	 SELECT  '" + appl
									+ "' APPLICATION_ID,2 SEQ_NO, ");

						} else if (trans_tbl_type.equals("APPL")) {
							if(columnVal!=null && columnVal.size() > 2)
							{
								sql.append("APPLICATION_ID='"+ appl+ "'  and OUTBOUND_YN='"+ outbound_yn+ "'  and (DESC2_VALUE IS NOT NULL OR ext_pk1_value IS NOT NULL OR ext_pk2_value IS NOT NULL OR ext_pk3_value IS NOT NULL)  ) AND (UPPER(NVL("+ pkval.get(0) + ",'*')) like upper('"+ searchText + "') OR UPPER(NVL("+ columnVal.get(0) + ",'*')) like upper('"+ searchText + "'))  AND (UPPER(NVL("+ pkval.get(1) + ",'*')) like upper('"+ searchpk2 + "') OR UPPER(NVL("+ columnVal.get(1) + ",'*')) like upper('"+ searchpk2 + "'))  and  (UPPER(NVL("+ pkval.get(2) + ",'*')) like upper('"+ searchpk3 + "') OR UPPER(NVL("+ columnVal.get(2) + ",'*')) like upper('"+ searchpk3 + "'))");
							}
							else
							{
								sql.append("APPLICATION_ID='"+ appl+ "'  and OUTBOUND_YN='"+ outbound_yn+ "'  and (DESC2_VALUE IS NOT NULL OR ext_pk1_value IS NOT NULL OR ext_pk2_value IS NOT NULL OR ext_pk3_value IS NOT NULL)  ) AND UPPER(NVL("+ pkval.get(0) + ",'*')) like upper('"+ searchText + "')  AND UPPER(NVL("+ pkval.get(1) + ",'*')) like upper('"+ searchpk2 + "')  and  UPPER(NVL("+ pkval.get(2) + ",'*')) like upper('"+ searchpk3 + "') ");
							}
							
							sql.append("  union	 SELECT  '" + appl
									+ "' APPLICATION_ID,2 SEQ_NO, ");
						} else {

							sql.append("APPLICATION_ID='" + appl + "' ) ");
							
							if(columnVal!=null && columnVal.size() > 2)
							{
								sql.append(" AND (UPPER(NVL(" + pkval.get(0)+ ",'*')) like upper('" + searchText+ "' ) OR UPPER(NVL(" + columnVal.get(0)+ ",'*')) like upper('" + searchText+ "' ))  and  (UPPER(NVL(" + pkval.get(1)+ ",'*')) like upper('" + searchpk2+ "') OR UPPER(NVL(" + columnVal.get(1)+ ",'*')) like upper('" + searchpk2+ "')) and  (UPPER(NVL(" + pkval.get(2)+ ",'*')) like upper('" + searchpk3 + "') OR UPPER(NVL(" + columnVal.get(2)+ ",'*')) like upper('" + searchpk3 + "'))");
							}
							else
							{
								sql.append(" AND UPPER(NVL(" + pkval.get(0)+ ",'*')) like upper('" + searchText+ "' )  and  UPPER(NVL(" + pkval.get(1)+ ",'*')) like upper('" + searchpk2+ "') and  UPPER(NVL(" + pkval.get(2)+ ",'*')) like upper('" + searchpk3 + "')");
							}
							
							sql.append(" union	 SELECT  '" + appl
									+ "' APPLICATION_ID,2 SEQ_NO,");

						}
						if (trans_table_id.equals("XH_OTH_APPL_DATA_SKEY")) {
							// code added on 24th Dec - Name Prefix - only for Code
							// sql.append("pk_value,");
							if (columnVal.size() > 0) {
								sql.append("pk_value,");
							} else {
								sql.append("pk_value");
							}
							// end of code added 

							for (startVal = 0; startVal < columnVal.size(); startVal++) {
								// Cmmntd Oct16 	     	sql.append("desc"+(startVal+1)+"_Value");
								sql.append("desc" + (startVal + 2) + "_Value");
								if (startVal < columnVal.size() - 1) {
									sql.append(",");
								}
							}
						} else if (trans_table_id.equals("XH_OTH_APPL_DATA_DKEY")) {
							sql.append("pk1_value,pk2_value,");
							//		 sql.append("pk1_value,pk2_value, ext_pk1_value,ext_pk2_value,");

							for (startVal = 0; startVal < columnVal.size(); startVal++) {
								sql.append("desc" + (startVal + 2) + "_Value");
								if (startVal < columnVal.size() - 1) {
									sql.append(",");
								}
							}
						} else if (trans_tbl_type.equals("APPL")) {
							sql.append("pk1_value,pk2_value,pk3_value,");
							for (startVal = 0; startVal < columnVal.size(); startVal++) {
								sql.append("desc" + (startVal + 2) + "_Value");
								if (startVal < columnVal.size() - 1) {
									sql.append(",");
								}
							}
						} else {
							for (startVal = 0; startVal < pkval.size(); startVal++) {
								sql.append(pkval.get(startVal) + ",");
							}

							for (startVal = 0; startVal < columnVal.size(); startVal++) {
								sql.append(columnVal.get(startVal));
								if (startVal < columnVal.size() - 1) {
									sql.append(",");
								}

							}
						}

					if (trans_table_id.equals("XH_OTH_APPL_DATA_SKEY")) {
							sql.append("   FROM  " + trans_table_id
								+ "  WHERE APPLICATION_ID = '" + appl
								+ "' and table_id='" + masterName
								+ "'  and OUTBOUND_YN='" + outbound_yn + "' ");

							if (columnVal.size() > 0) {
								sql
								.append("   AND  (DESC2_VALUE is not null OR ext_pk_id is not null ) ");
							} else {
								sql.append("   AND  ext_pk_id is not null  ");
							}

							if(columnVal!=null && columnVal.size() > 0)
							{
								sql.append(" AND  (UPPER(NVL(" + pkValue.get(0)+ ",'*')) LIKE upper('" + searchText+ "') OR UPPER(NVL(" + columnVal.get(0)+ ",'*')) LIKE upper('" + searchText+ "')) ) /*)*/");
							}
							else
							{
								sql.append(" AND  UPPER(NVL(" + pkValue.get(0)+ ",'*')) LIKE upper('" + searchText+ "')) /*)*/");
							}

						}// end of XH_OTH_APPL_DATA_SKEY 
						else if (trans_table_id.equals("XH_OTH_APPL_DATA_DKEY")) {
						sql
							.append("   FROM  "
							+ trans_table_id
							+ "  WHERE  (DESC2_VALUE IS not NULL OR ext_pk1_value IS not NULL OR ext_pk2_value IS not NULL) and APPLICATION_ID = '"
							+ appl + "' and table_id='"
							+ masterName + "'  and OUTBOUND_YN='"
							+ outbound_yn + "' ");

							if(columnVal!=null && columnVal.size() > 1)
							{
								sql.append("AND (UPPER(NVL(" + pkValue.get(0)+ ",'*')) like upper('" + searchText+ "') OR UPPER(NVL(" + columnVal.get(0)+ ",'*')) like upper('" + searchText+ "'))  AND (UPPER(NVL(" + pkValue.get(1)+ ",'*')) like upper('" + searchpk2+ "') OR UPPER(NVL(" + columnVal.get(1)+ ",'*')) like upper('" + searchpk2+ "')) ) /*) */");
							}
							else
							{
								sql.append("AND UPPER(NVL(" + pkValue.get(0)+ ",'*')) like upper('" + searchText+ "')  AND UPPER(NVL(" + pkValue.get(1)+ ",'*')) like upper('" + searchpk2+ "') ) /*) */");
							}
							
						} // end of  XH_OTH_APPL_DATA_DKEY
						else if (trans_tbl_type.equals("APPL")) {
							sql
								.append("   FROM  "
								+ trans_table_id
								+ "  WHERE  (DESC2_VALUE IS not NULL OR ext_pk1_value IS not NULL OR ext_pk2_value IS not NULL OR ext_pk3_value IS not NULL) and APPLICATION_ID = '"
								+ appl + "'  and OUTBOUND_YN='"
								+ outbound_yn + "'  ");

							sql
								.append(" AND (pk1_value,pk2_value,pk3_value) IN (SELECT "
								+ pkval.get(0)
								+ ","
								+ pkval.get(1)
								+ "," + pkval.get(2));

							if(columnVal!=null && columnVal.size() > 2)
							{
								sql.append("  from " + masterName+ "  where (UPPER(NVL(" + pkval.get(0)+ ",'*')) like upper('" + searchText+ "') OR UPPER(NVL(" + columnVal.get(0)+ ",'*')) like upper('" + searchText+ "'))  AND (UPPER(NVL(" + pkval.get(1)+ ",'*')) like upper('" + searchpk2+ "') OR UPPER(NVL(" + columnVal.get(1)+ ",'*')) like upper('" + searchpk2+ "')) and  (UPPER(NVL(" + pkval.get(2)+ ",'*')) like upper('" + searchpk3 + "') OR UPPER(NVL(" + columnVal.get(2)+ ",'*')) like upper('" + searchpk3 + "')) ))");
							}
							else
							{
								sql.append("  from " + masterName+ "  where UPPER(NVL(" + pkval.get(0)+ ",'*')) like upper('" + searchText+ "')  AND UPPER(NVL(" + pkval.get(1)+ ",'*')) like upper('" + searchpk2+ "') and  UPPER(NVL(" + pkval.get(2)+ ",'*')) like upper('" + searchpk3 + "') ))");
							}							

						} else {

					// sql.append("   FROM  "+trans_table_id+"  WHERE  "+columnVal.get(0)+" is not null and APPLICATION_ID = '"+appl+"' " ); 
					sql.append("   FROM  " + trans_table_id
							+ "  WHERE APPLICATION_ID = '" + appl + "' ");

					sql.append(" and  (");
					for (startVal = 0; startVal < pkValue.size(); startVal++) {
						sql.append(pkValue.get(startVal));
						if (startVal < pkValue.size() - 1) {
							sql.append(",");
						}
					}

					sql.append(" ) IN (SELECT ");

					for (startVal = 0; startVal < pkValue.size(); startVal++) {
						sql.append(pkValue.get(startVal));
						if (startVal < pkValue.size() - 1) {
							sql.append(",");
						}
					}

					if(columnVal!=null && columnVal.size() > 2)
					{
						sql.append(" from " + masterName + "  where (UPPER(NVL("+ pkval.get(0) + ",'*')) LIKE upper('"+ searchText + "') OR UPPER(NVL("+ columnVal.get(0) + ",'*')) LIKE upper('"+ searchText + "'))  and  (UPPER(NVL("+ pkval.get(1) + ",'*')) like upper('"+ searchpk2 + "') OR UPPER(NVL("+ columnVal.get(1) + ",'*')) like upper('"+ searchpk2 + "')) and  (UPPER(NVL("+ pkval.get(2) + ",'*')) like upper('"+ searchpk3 + "') OR UPPER(NVL("+ columnVal.get(2) + ",'*')) like upper('"+ searchpk3 + "')) ))");
					}
					else
					{
						sql.append(" from " + masterName + "  where UPPER(NVL("+ pkval.get(0) + ",'*')) LIKE upper('"+ searchText + "')  and  UPPER(NVL("+ pkval.get(1) + ",'*')) like upper('"+ searchpk2 + "') and  UPPER(NVL("+ pkval.get(2) + ",'*')) like upper('"+ searchpk3 + "')))");
					}
					
						} // end of !(SKEY ,DKEY)

					} // end of Translated
					else {

						//	 System.out.println("663");
						sql.append(" from  " + trans_table_id + "  where ");
						if (trans_table_id.equals("XH_OTH_APPL_DATA_SKEY")
						|| trans_table_id.equals("XH_OTH_APPL_DATA_DKEY")) {
							sql.append("table_id='" + masterName
								+ "' and APPLICATION_ID='" + appl
								+ "' 	and OUTBOUND_YN='" + outbound_yn
								+ "' /*)*/ ");

					if (trans_table_id.equals("XH_OTH_APPL_DATA_SKEY")) {

						sql.append("AND UPPER(NVL(pk_value,'*')) like upper('"+ searchText + "')");

					} else if (trans_table_id.equals("XH_OTH_APPL_DATA_DKEY")) {
						sql
						.append("AND UPPER(NVL(PK1_VALUE,'*')) like upper('"
								+ searchText + "')  AND UPPER(NVL(PK2_VALUE,'*')) like upper('" + searchpk2
								+ "') ");
					}

					// end of  code added on Dec 24th for Name Prefix

					sql.append("  union	 SELECT  '" + appl
							+ "' APPLICATION_ID,2 SEQ_NO, ");

						} else if (trans_tbl_type.equals("APPL")) {
							sql.append(" APPLICATION_ID='" + appl+ "' 	and OUTBOUND_YN='" + outbound_yn+ "' ) ");
							if(columnVal!=null && columnVal.size() > 2)
							{
								sql.append("AND (UPPER(NVL(" + pkval.get(0)+ ",'*')) like upper('" + searchText+ "') OR UPPER(NVL(" + columnVal.get(0)+ ",'*')) like upper('" + searchText+ "'))  AND (UPPER(NVL(" + pkval.get(1)+ ",'*')) like upper('" + searchpk2+ "') OR UPPER(NVL(" + columnVal.get(1)+ ",'*')) like upper('" + searchpk2+ "')) AND (UPPER(NVL(" + pkval.get(2)+ ",'*')) like upper('" + searchpk3 + "') OR UPPER(NVL(" + columnVal.get(2)+ ",'*')) like upper('" + searchpk3 + "'))");
							}
							else
							{
								sql.append("AND UPPER(NVL(" + pkval.get(0)+ ",'*')) like upper('" + searchText+ "')  AND UPPER(NVL(" + pkval.get(1)+ ",'*')) like upper('" + searchpk2+ "') AND UPPER(NVL(" + pkval.get(2)+ ",'*')) like upper('" + searchpk3 + "')");
							}
							
							sql.append("  union	 SELECT  '" + appl
									+ "' APPLICATION_ID,2 SEQ_NO, ");
						}

						else {
							if(columnVal!=null && columnVal.size() > 2)
							{
								sql.append("APPLICATION_ID='" + appl+ "'  )  AND (UPPER(NVL(" + pkval.get(0)+ ",'*')) like upper('" + searchText+ "' ) OR UPPER(NVL(" + columnVal.get(0)+ ",'*')) like upper('" + searchText+ "' ))  and  (UPPER(NVL(" + pkval.get(1)+ ",'*')) like upper('" + searchpk2+ "') OR UPPER(NVL(" + columnVal.get(1)+ ",'*')) like upper('" + searchpk2+ "')) and  (UPPER(NVL(" + pkval.get(2)+ ",'*')) like upper('" + searchpk3 + "') OR UPPER(NVL(" + columnVal.get(2)+ ",'*')) like upper('" + searchpk3 + "')) ");
							}
							else
							{
								sql.append("APPLICATION_ID='" + appl+ "'  )  AND UPPER(NVL(" + pkval.get(0)+ ",'*')) like upper('" + searchText+ "' )  and  UPPER(NVL(" + pkval.get(1)+ ",'*')) like upper('" + searchpk2+ "') and  UPPER(NVL(" + pkval.get(2)+ ",'*')) like upper('" + searchpk3 + "') ");
							}
							
							sql.append(" union	 SELECT  '" + appl
									+ "' APPLICATION_ID,2 SEQ_NO,");

						}
						if (trans_table_id.equals("XH_OTH_APPL_DATA_SKEY")) {
							if (columnVal.size() > 0) {
								sql.append("pk_value,");
							} else {
								sql.append("pk_value");
							}
							// end of code added 

							for (startVal = 0; startVal < columnVal.size(); startVal++) {
								//	 		System.out.println("712");
								//	     	sql.append("desc"+(startVal+1)+"_Value"); cmmntd on Aug 8
								sql.append("desc" + (startVal + 2) + "_Value");
								if (startVal < columnVal.size() - 1) {
									sql.append(",");
								}
							}
						} else if (trans_table_id.equals("XH_OTH_APPL_DATA_DKEY")) {
							sql.append("pk1_value,pk2_value,");
							// 	 		System.out.println("724");
							for (startVal = 0; startVal < columnVal.size(); startVal++) {
								// cmmntd on jan6th	     	sql.append("desc"+(startVal+1)+"_Value");
								sql.append("desc" + (startVal + 2) + "_Value");
								if (startVal < columnVal.size() - 1) {
									sql.append(",");
								}
							}
						} else if (trans_tbl_type.equals("APPL")) {
							sql.append("pk1_value,pk2_value,pk3_value,");

							// 	 		System.out.println("724");
							for (startVal = 0; startVal < columnVal.size(); startVal++) {
								// cmmntd on jan6th	     	sql.append("desc"+(startVal+1)+"_Value");
								//	     	sql.append("desc"+(startVal+2)+"_Value");
								sql.append(columnVal.get(startVal));
								if (startVal < columnVal.size() - 1) {
									sql.append(",");
								}
							}
						} else {
							for (startVal = 0; startVal < pkval.size(); startVal++) {
								sql.append(pkval.get(startVal) + ",");
							}

							for (startVal = 0; startVal < columnVal.size(); startVal++) {
								sql.append(columnVal.get(startVal));
								if (startVal < columnVal.size() - 1) {
									sql.append(",");
								}

							}
						}

						if (trans_table_id.equals("XH_OTH_APPL_DATA_SKEY")) {
						sql.append("   FROM  " + trans_table_id
								+ "  WHERE  APPLICATION_ID = '" + appl
								+ "' and table_id='" + masterName
								+ "'  and OUTBOUND_YN='" + outbound_yn + "' ");

						sql
						.append("  AND /* pk_value IN (SELECT "
								+ pkval.get(0)
								+ "  from "
								+ masterName
								+ "  where */ UPPER(NVL(PK_VALUE,'*')) LIKE upper('"
								+ searchText + "')) /*) */");

						}// end of XH_OTH_APPL_DATA_SKEY 
						else if (trans_table_id.equals("XH_OTH_APPL_DATA_DKEY")) {
							sql.append("   FROM  " + trans_table_id
									+ "  WHERE  APPLICATION_ID = '" + appl
									+ "' and table_id='" + masterName
									+ "'  and OUTBOUND_YN='" + outbound_yn + "' ");

	//						sql.append(pkval.get(1) + "  from " + masterName
							sql.append("AND UPPER(NVL(PK1_VALUE,'*')) like upper('" + searchText
							+ "')  AND UPPER(NVL(PK2_VALUE,'*')) like upper('" + searchpk2
							+ "') ) /*) */");
						} // end of  XH_OTH_APPL_DATA_DKEY
						else if (trans_tbl_type.equals("APPL")) {
							sql
									.append("   FROM  " + trans_table_id
									+ "  WHERE  APPLICATION_ID = '" + appl
									+ "'  and OUTBOUND_YN='" + outbound_yn
									+ "'   ");

							sql
									.append(" AND (pk1_value,pk2_value,pk3_value) IN (SELECT "
									+ pkval.get(0)
									+ ","
									+ pkval.get(1)
									+ "," + pkval.get(2));
							//	sql.append(" AND ("+pkval.get(0)+","+pkval.get(1)+","+pkval.get(2)+") IN (SELECT "+pkval.get(0)+",");

							if(columnVal!=null && columnVal.size() > 2)
							{
								sql.append("  from " + masterName+ "  where (UPPER(NVL(" + pkval.get(0)+ ",'*')) like upper('" + searchText+ "') OR UPPER(NVL(" + columnVal.get(0)+ ",'*')) like upper('" + searchText+ "'))  AND (UPPER(NVL(" + pkval.get(1)+ ",'*')) like upper('" + searchpk2+ "') OR UPPER(NVL(" + columnVal.get(1)+ ",'*')) like upper('" + searchpk2+ "')) AND (UPPER(NVL(" + pkval.get(2)+ ",'*')) like upper('" + searchpk3+ "') OR UPPER(NVL(" + columnVal.get(2)+ ",'*')) like upper('" + searchpk3+ "'))   ))");
							}
							else
							{
								sql.append("  from " + masterName+ "  where UPPER(NVL(" + pkval.get(0)+ ",'*')) like upper('" + searchText+ "')  AND UPPER(NVL(" + pkval.get(1)+ ",'*')) like upper('" + searchpk2+ "') AND UPPER(NVL(" + pkval.get(2)+ ",'*')) like upper('" + searchpk3+ "')   ))");
							}

						} // end of  APPL
						else {

							sql.append("   FROM  " + trans_table_id
									+ "  WHERE  APPLICATION_ID = '" + appl + "' ");

							sql.append(" and  (");
							for (startVal = 0; startVal < pkValue.size(); startVal++) {
								sql.append(pkValue.get(startVal));
								if (startVal < pkValue.size() - 1) {
									sql.append(",");
								}
							}

							sql.append(" ) IN (SELECT ");

							for (startVal = 0; startVal < pkValue.size(); startVal++) {
								sql.append(pkValue.get(startVal));
								if (startVal < pkValue.size() - 1) {
									sql.append(",");
								}
							}

							if(columnVal!=null && columnVal.size() > 2)
							{
								sql.append(" from " + masterName + "  where (UPPER(NVL("+ pkval.get(0) + ",'*')) LIKE upper('"+ searchText + "') OR UPPER(NVL("+ columnVal.get(0) + ",'*')) LIKE upper('"+ searchText + "'))  and  (UPPER(NVL("+ pkval.get(1) + ",'*')) like upper('"+ searchpk2 + "') OR UPPER(NVL("+ columnVal.get(1) + ",'*')) like upper('"+ searchpk2 + "')) and  (UPPER(NVL("+ pkval.get(2) + ",'*')) like upper('"+ searchpk3 + "') OR UPPER(NVL("+ columnVal.get(2) + ",'*')) like upper('"+ searchpk3 + "')) ))");
							}
							else
							{
								sql.append(" from " + masterName + "  where UPPER(NVL("+ pkval.get(0) + ",'*')) LIKE upper('"+ searchText + "')  and  UPPER(NVL("+ pkval.get(1) + ",'*')) like upper('"+ searchpk2 + "') and  UPPER(NVL("+ pkval.get(2) + ",'*')) like upper('"+ searchpk3 + "') ))");
							}
						} // end of !(SKEY ,DKEY)

					} // end of ALL
					
					pstmt = con.prepareStatement(sql.toString());
					rs = pstmt.executeQuery();

					rs.next();
					maxRecord = rs.getInt("total");

					if (rs != null)
						rs.close();
					if (pstmt != null)
						pstmt.close();

					if (maxRecord == 0) {
						out
						.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));parent.Search.document.forms[0].synchronize.disabled=false;parent.dummyFrame.location.href='../../eCommon/html/blank.html';</script>");
					} else {
						String export_data_yn = "N";
						String upload_data_yn = "N";
						String authSql = "SELECT export_data_yn,upload_data_yn FROM xh_authorized_user WHERE UPPER(LOGIN_NAME)=UPPER('"
						+ loggedUser + "')";

						ResultSet authRS = null;

						try {

					authRS = con.createStatement().executeQuery(authSql);
					if (authRS.next()) {
						export_data_yn = authRS.getString(1);
						upload_data_yn = authRS.getString(2);
					}
						} catch (Exception e) {
					System.out
							.println("Exception in XHTranslationMangerResult :"
							+ e);
						}
						if (authRS != null)
					authRS.close();

						if (export_data_yn.equals("Y")) {
			%>
			<script>parent.Search.document.forms[0].exportdata.disabled=false; 				    
	   </script>
			<%
			}
			%>

			<%
			if (upload_data_yn.equals("Y")) {
			%>
			<script> parent.Search.document.forms[0].uploaddata.disabled=false;	 
	   </script>
			<%
			}
			%>

			<p>
			<table align='center' border=0 width="100%">
				<tr>
					<td align='right'>
						<%
									// System.out.println("951 start : "+start);
									//	 if(trans_table_id.equals("XH_OTH_APPL_DATA_SKEY")||trans_table_id.equals("XH_OTH_APPL_DATA_DKEY")){
									if (!(start <= 1))
								out
										.println(" <A HREF='javascript:recordPrevData()'  text-decoration='none'>"
										+ "Previous" + "</A>");

									if (!((start + 20) > maxRecord))
								out
										.println(" <A href='javascript:recordNextData()' text-decoration='none'>"
										+ "Next" + "</A>");

						%>
					</td>
				</tr>
			</table>
			</p>

			<table cellspacing=0 cellpadding=0 width="100%" border="0">
				<tr>
					<td class=data align=center
						style="BACKGROUND-COLOR:white;font:12pt">
						<B><%=table_desc%>
						</b>
					</td>
					</td>
			</table>
			<table cellspacing=0 cellpadding=0 width="100%" border="0">
				<tr>
					<%
							if (!table_or_form.equals("F")) {
							for (int startval = 0; startval < pkPrompt.size(); startval++) {
					%>
					<th align=left>
						<%=pkPrompt.get(startval)%>
					</th>
					<%
							}

							for (int startval = 0; startval < columnPrompt.size(); startval++) {
					%>
					<th align=left>
						&nbsp;&nbsp;&nbsp;
						<%=columnPrompt.get(startval)%>
					</th>
					<%
					}
					%>

					<%
					} else {
					%>
					<th align=left>
						Label
					</th>
					<th align=left>
						eHIS Value
					</th>
					<th align=left>
						Translated Value
					</th>
					<%
					}
					%>
				</tr>
				<%
							sql.setLength(0);
							/*
							 if(display.equals("N") || display.equals("T"))
							 {
							 */
							sql.append("Select 'en'  APPLICATION_ID,1 SEQ_NO,");
							/*	
							 }else
							 {
							 sql.append("Select a.APPLICATION_ID,2 SEQ_NO," ); 
							 // cmnntd on J17 sql.append("Select a.APPLICATION_ID, b.SEQ_NO," ); 

							 }
							 */
							if (!masterName.equals("SM_MASTER_CODE")) {

							for (startVal = 0; startVal < pkValue.size(); startVal++) {
								sql.append(pkValue.get(startVal)+" "+pkval.get(startVal));
								if (startVal < pkValue.size() ) {
									sql.append(",");
								}
							}
						// Oct 16
						if (trans_table_id.equals("XH_OTH_APPL_DATA_SKEY")) {
							//		   System.out.println("919 :pkval.get(0) "+pkval.get(0));
							//    sql.append("a.");
							// modified on Dec 24 for Name Prefix - only for code
							if (columnVal.size() > 0) {
								sql.append("PK_VALUE ext_pk_id,");
							} else {
								sql.append("PK_VALUE ext_pk_id");
							}
						}
						if (trans_table_id.equals("XH_OTH_APPL_DATA_DKEY")) {
							//   		   System.out.println("925 DKEY");		  

							// added on Oct15
							int pkCnt = 1;
							for (startVal = 0; startVal < pkValue.size(); startVal++) {
							//	sql.append("a.");
								sql.append(pkValue.get(startVal) + " ext_pk"
								+ pkCnt + "_value,");
								pkCnt++;
							}
						}
						if (trans_tbl_type.equals("APPL")) {
							//   		   System.out.println("925 DKEY");

							// added on Oct15
							int pkCnt = 1;
							for (startVal = 0; startVal < pkval.size(); startVal++) {
								sql.append("a.");
								sql.append(pkval.get(startVal) + " ext_pk"
								+ pkCnt + "_value,");
								pkCnt++;
							}
						}
						//            System.out.println("sql 934 : "+sql);
							} 

							if (trans_table_id.equals("XH_OTH_APPL_DATA_SKEY")
							|| trans_table_id.equals("XH_OTH_APPL_DATA_DKEY")
							|| trans_tbl_type.equals("APPL")) {

							for (startVal = 0; startVal < columnVal.size(); startVal++) {
								sql.append("desc" + (startVal + 1) + "_Value ");
								sql.append(columnVal.get(startVal));
								if (startVal < columnVal.size() - 1) {
									sql.append(",");
								}
							}
							} // added on 12th March 2009
							else {
								int pkCnt = 1;
								int startVal1 = 0;
								for (startVal = 0; startVal < colValue.size(); startVal++, startVal1++) {
									sql.append("a.");
									if (((String) columnVal.get(startVal)).substring(0,
									3).equals("EXT")) {

										sql.append(colValue.get(startVal) + " EXT_"
										+ (String) colValue.get(startVal));
									} else {
										sql.append(colValue.get(startVal));
									}
									pkCnt++;
									if (startVal < (colValue.size() - 1)) {
										sql.append(",");
									}
								}
							}
							//		} // end of 730 else

							// Non Translated
							if (display.equals("N")) {

							sql.append(" from  " + trans_table_id + "  where ");
							// Added on Oct16
							if (trans_table_id.equals("XH_OTH_APPL_DATA_DKEY")) {

								if(columnVal!=null && columnVal.size() > 1)
								{
									sql.append("table_id='"+ masterName+ "' and APPLICATION_ID='"+ appl+ "' and  OUTBOUND_YN='"+ outbound_yn+ "' and	 (DESC2_VALUE IS  NULL AND ext_pk1_value IS  NULL AND ext_pk2_value IS  NULL) /*)*/ AND (UPPER(NVL("+ pkValue.get(0)+ ",'*')) like upper('"+ searchText + "') OR UPPER(NVL("+ columnVal.get(0)+ ",'*')) like upper('"+ searchText + "'))  AND (UPPER(NVL("+ pkValue.get(1)+ ",'*')) like upper('" + searchpk2+ "') OR UPPER(NVL("+ columnVal.get(1)+ ",'*')) like upper('" + searchpk2+ "')) ");
								}
								else
								{
									sql.append("table_id='"+ masterName+ "' and APPLICATION_ID='"+ appl+ "' and  OUTBOUND_YN='"+ outbound_yn+ "' and	 (DESC2_VALUE IS  NULL AND ext_pk1_value IS  NULL AND ext_pk2_value IS  NULL) /*)*/ AND UPPER(NVL("+ pkValue.get(0)+ ",'*')) like upper('"+ searchText + "')  AND UPPER(NVL("+ pkValue.get(1)+ ",'*')) like upper('" + searchpk2+ "') ");
								}
								
							}
							if (trans_table_id.equals("XH_OTH_APPL_DATA_SKEY")) {
								sql.append("table_id='" + masterName
								+ "' and APPLICATION_ID='" + appl
								+ "'   and OUTBOUND_YN='" + outbound_yn
								+ "' ");

								if (columnVal.size() > 0) {
									sql
									.append(" and (desc2_value IS NULL AND ext_pk_id IS  NULL) /*) */ ");
								} else {
									sql.append(" and ext_pk_id IS  NULL /*)*/ ");
								}

								if(columnVal!=null && columnVal.size() > 0)
								{
									sql.append(" AND (UPPER(NVL(" + pkValue.get(0)+ ",'*')) like upper('" + searchText+ "') OR UPPER(NVL(" + columnVal.get(0)+ ",'*')) like upper('" + searchText+ "')) ");
								}
								else
								{
									sql.append(" AND UPPER(NVL(" + pkValue.get(0)+ ",'*')) like upper('" + searchText+ "') ");
								}
								// end of code added 
						}
						if (trans_table_id.equals("XH_OTH_APPL_DATA_SKEY")
								|| trans_table_id
								.equals("XH_OTH_APPL_DATA_DKEY")) {

							sql.append("  union	 SELECT  '" + appl
							+ "' APPLICATION_ID,2 SEQ_NO, ");

						} // SKEY/DKEY
						else if (trans_tbl_type.equals("APPL")) {

							if(columnVal!=null && columnVal.size() > 2)
							{
								sql.append(" APPLICATION_ID='"+ appl+ "' and OUTBOUND_YN='"+ outbound_yn+ "'  and	 (DESC2_VALUE IS  NULL AND ext_pk1_value IS  NULL AND ext_pk2_value IS  NULL AND ext_pk3_value IS  NULL) ) AND (UPPER(NVL("+ pkval.get(0)+ ",'*')) like upper('"+ searchText + "') OR UPPER(NVL("+ columnVal.get(0)+ ",'*')) like upper('"+ searchText + "'))  AND (UPPER(NVL("+ pkval.get(1)+ ",'*')) like upper('" + searchpk2+ "') OR UPPER(NVL("+ columnVal.get(1)+ ",'*')) like upper('" + searchpk2+ "'))  and  (UPPER(NVL("+ pkval.get(2)+ ",'*')) like upper('" + searchpk3+ "') OR UPPER(NVL("+ columnVal.get(2)+ ",'*')) like upper('" + searchpk3+ "'))");
							}
							else
							{
								sql.append(" APPLICATION_ID='"+ appl+ "' and OUTBOUND_YN='"+ outbound_yn+ "'  and	 (DESC2_VALUE IS  NULL AND ext_pk1_value IS  NULL AND ext_pk2_value IS  NULL AND ext_pk3_value IS  NULL) ) AND UPPER(NVL("+ pkval.get(0)+ ",'*')) like upper('"+ searchText + "')  AND UPPER(NVL("+ pkval.get(1)+ ",'*')) like upper('" + searchpk2+ "')  and  UPPER(NVL("+ pkval.get(2)+ ",'*')) like upper('" + searchpk3+ "')");
							}
							
							sql.append(" union	 SELECT  '" + appl
							+ "' APPLICATION_ID,2 SEQ_NO,");

						} else {

							if(columnVal!=null && columnVal.size() > 2)
							{
								sql.append("APPLICATION_ID='" + appl+ "'  )  AND (UPPER(NVL(" + pkval.get(0)+ ",'*')) like upper('" + searchText+ "' ) OR UPPER(NVL(" + columnVal.get(0)+ ",'*')) like upper('" + searchText+ "' ))  and  (UPPER(NVL(" + pkval.get(1)+ ",'*')) like upper('" + searchpk2+ "') OR UPPER(NVL(" + columnVal.get(1)+ ",'*')) like upper('" + searchpk2+ "')) and  (UPPER(NVL(" + pkval.get(2)+ ",'*')) like upper('" + searchpk3 + "') OR UPPER(NVL(" + columnVal.get(2)+ ",'*')) like upper('" + searchpk3 + "'))");
							}
							else
							{
								sql.append("APPLICATION_ID='" + appl+ "'  )  AND UPPER(NVL(" + pkval.get(0)+ ",'*')) like upper('" + searchText+ "' )  and  UPPER(NVL(" + pkval.get(1)+ ",'*')) like upper('" + searchpk2+ "') and  UPPER(NVL(" + pkval.get(2)+ ",'*')) like upper('" + searchpk3 + "')");
							}

							if ((masterName.equals("SM_FUNCTION")
							|| masterName.equals("SM_REPORT")
							|| masterName.equals("SM_FUNCTION_LEGEND")
							|| masterName.equals("SM_LABEL_ITEM")
							|| masterName.equals("SM_LIST_ITEM") || masterName
							.equals("SM_RECORD_TRANS"))
							&& (!Searchbymod.equals(""))) {

								sql.append(" and module_id='" + Searchbymod
								+ "'");
							}
							if (masterName.equals("SM_FUNCTION_LEGEND")) {
								if (!SearchbyFunct.equals("")) {

							sql.append(" and function_id like upper('"
									+ SearchbyFunct + "%')  ");
								}
							}

							sql.append(" union	 SELECT  '" + appl
							+ "' APPLICATION_ID,2 SEQ_NO,");

						} // OTH !(SKEY,DKEY)
						if (trans_table_id.equals("XH_OTH_APPL_DATA_SKEY")) {

							if (columnVal.size() > 0) {
								sql.append("pk_value,ext_pk_id,");
							} else {
								sql.append("pk_value,ext_pk_id");
							}

							for (startVal = 0; startVal < columnVal.size(); startVal++) {
								//     Cmmntd Oct16	sql.append("desc"+(startVal+1)+"_Value");

								sql.append("desc" + (startVal + 2) + "_Value");
								if (startVal < columnVal.size() - 1) {
							sql.append(",");
								}

							}

						}// end of SKEY 
						else if (trans_table_id.equals("XH_OTH_APPL_DATA_DKEY")) {

							sql
							.append("pk1_value,pk2_value, ext_pk1_value,ext_pk2_value,");
							for (startVal = 0; startVal < columnVal.size(); startVal++) {
								// cmmntd on jan6th	     	sql.append("desc"+(startVal+1)+"_Value");
								sql.append("desc" + (startVal + 2) + "_Value");
								if (startVal < columnVal.size() - 1) {
							sql.append(",");
								}
							}
						}// end of DKEY
						else if (trans_tbl_type.equals("APPL")) {
							sql
							.append("pk1_value,pk2_value, pk3_value,ext_pk1_value,ext_pk2_value,ext_pk3_value,");
							for (startVal = 0; startVal < columnVal.size(); startVal++) {
								// cmmntd on jan6th	     	sql.append("desc"+(startVal+1)+"_Value");
								sql.append("desc" + (startVal + 2) + "_Value");
								if (startVal < columnVal.size() - 1) {
							sql.append(",");
								}
							}
						}// end of APPL
						else {
							for (startVal = 0; startVal < pkval.size(); startVal++) {
								sql.append(pkval.get(startVal) + ",");
							}

							for (startVal = 0; startVal < columnVal.size(); startVal++) {
								sql.append(columnVal.get(startVal));
								if (startVal < columnVal.size() - 1) {
							sql.append(",");
								}

							}
						}// !(SKEY,DKEY)

						if (trans_table_id.equals("XH_OTH_APPL_DATA_SKEY")) {

							sql.append("   FROM  " + trans_table_id
							+ "  WHERE  APPLICATION_ID = '" + appl
							+ "' and table_id='" + masterName
							+ "'  and OUTBOUND_YN='" + outbound_yn
							+ "' ");
							if (columnVal.size() > 0) {
								sql
								.append("    and  	(desc2_value IS NULL AND ext_pk_id IS NULL) ");
							} else {
								sql.append("    and  ext_pk_id IS NULL ");
							}
							// end of code added 	 

								// modified on Dec 24 for Name Prefix - only for code
								// cmmntd on jan6th 	if(columnVal.size()>0){

							if(columnVal!=null && columnVal.size() > 0)
							{
								sql.append(" AND (UPPER(NVL(" + pkValue.get(0)+ ",'*')) LIKE upper('" + searchText+ "') OR UPPER(NVL(" + columnVal.get(0)+ ",'*')) LIKE upper('" + searchText+ "')) /*) */");
							}
							else
							{
								sql.append(" AND UPPER(NVL(" + pkValue.get(0)+ ",'*')) LIKE upper('" + searchText+ "') /*) */");
							}
								
								//	}
								// end of code added 
		
						}// SKEY
						else if (trans_table_id.equals("XH_OTH_APPL_DATA_DKEY")) {
							sql
							.append("   FROM  "
									+ trans_table_id
									+ "  WHERE  (DESC2_VALUE IS NULL AND ext_pk1_value IS  NULL AND ext_pk2_value IS  NULL) and APPLICATION_ID = '"
									+ appl + "' and table_id='"
									+ masterName
									+ "'  and OUTBOUND_YN='"
									+ outbound_yn + "' ");

									if(columnVal!=null && columnVal.size() > 1)
									{
										sql.append("AND  (UPPER(NVL("+ pkValue.get(0) + ",'*')) like upper('"+ searchText + "') OR UPPER(NVL("+ columnVal.get(0) + ",'*')) like upper('"+ searchText + "'))  AND (UPPER(NVL("+ pkValue.get(1) + ",'*')) like upper('"+ searchpk2 + "') OR UPPER(NVL("+ columnVal.get(1) + ",'*')) like upper('"+ searchpk2 + "')) /* )*/ ");
									}
									else
									{
										sql.append("AND  UPPER(NVL("+ pkValue.get(0) + ",'*')) like upper('"+ searchText + "')  AND UPPER(NVL("+ pkValue.get(1) + ",'*')) like upper('"+ searchpk2 + "') /* )*/ ");
									}
		
						} // DKEY
						else if (trans_tbl_type.equals("APPL")) {
							sql
							.append("   FROM  "
									+ trans_table_id
									+ "  WHERE  (DESC2_VALUE IS NULL AND ext_pk1_value IS  NULL AND ext_pk2_value IS  NULL AND ext_pk3_value IS  NULL) and APPLICATION_ID = '"
									+ appl + "'  and OUTBOUND_YN='"
									+ outbound_yn + "'  ");

							sql
							.append("  AND (pk1_value,pk2_value,pk3_value) IN (SELECT "
									+ pkval.get(0)
									+ ","
									+ pkval.get(1)
									+ "," + pkval.get(2));

									if(columnVal!=null && columnVal.size() > 2)
									{
										sql.append("  from " + masterName+ "  where  (UPPER(NVL(" + pkval.get(0)+ ",'*')) like upper('" + searchText+ "') OR UPPER(NVL(" + columnVal.get(0)+ ",'*')) like upper('" + searchText+ "'))  AND (UPPER(NVL(" + pkval.get(1)+ ",'*')) like upper('" + searchpk2+ "') OR UPPER(NVL(" + columnVal.get(1)+ ",'*')) like upper('" + searchpk2+ "'))  and  (UPPER(NVL(" + pkval.get(2)+ ",'*')) like upper('" + searchpk3+ "') OR UPPER(NVL(" + columnVal.get(2)+ ",'*')) like upper('" + searchpk3+ "')) )");
									}
									else
									{
										sql.append("  from " + masterName+ "  where  UPPER(NVL(" + pkval.get(0)+ ",'*')) like upper('" + searchText+ "')  AND UPPER(NVL(" + pkval.get(1)+ ",'*')) like upper('" + searchpk2+ "')  and  UPPER(NVL(" + pkval.get(2)+ ",'*')) like upper('" + searchpk3+ "') )");
									}

						} // APPL
						else {

							sql.append("   FROM  " + trans_table_id
							+ "  WHERE  APPLICATION_ID = '" + appl
							+ "' ");
							if ((masterName.equals("SM_FUNCTION")
							|| masterName.equals("SM_REPORT")
							|| masterName.equals("SM_FUNCTION_LEGEND")
							|| masterName.equals("SM_LABEL_ITEM")
							|| masterName.equals("SM_LIST_ITEM") || masterName
							.equals("SM_RECORD_TRANS"))) {
								if (!Searchbymod.equals("")) {

							sql.append(" and module_id='" + Searchbymod
									+ "'");
								}
								if (masterName.equals("SM_FUNCTION_LEGEND")) {
							if (!SearchbyFunct.equals("")) {
								sql
								.append(" and function_id like upper('"
										+ SearchbyFunct
										+ "%')  ");
							}
								}

								sql.append(" and  (");
								for (startVal = 0; startVal < pkValue.size(); startVal++) {
							sql.append(pkValue.get(startVal));
							if (startVal < pkValue.size() - 1) {
								sql.append(",");
							}
								}
								sql.append(" ) IN (SELECT ");

								for (startVal = 0; startVal < pkValue.size(); startVal++) {
							sql.append(pkValue.get(startVal));
							if (startVal < pkValue.size() - 1) {
								sql.append(",");
							}
								}

								if(columnVal!=null && columnVal.size() > 0)
								{
									sql.append(" from " + masterName+ "  where (UPPER(NVL(" + pkval.get(0)+ ",'*')) LIKE upper('" + searchText+ "') OR UPPER(NVL(" + pkval.get(0)+ ",'*')) LIKE upper('" + searchText+ "')) )");
								}
								else
								{
									sql.append(" from " + masterName+ "  where UPPER(NVL(" + pkval.get(0)+ ",'*')) LIKE upper('" + searchText+ "'))");
								}
								

							} else {
								if(columnVal!=null && columnVal.size() > 0)
								{
									sql.append(" AND " + pkval.get(0)+ " IN (SELECT " + pkval.get(0)+ "  from " + masterName+ "  where UPPER(NVL(" + pkval.get(0)+ ",'*')) LIKE upper('" + searchText+ "'))  and  UPPER(NVL(" + pkval.get(1)+ ",'*')) like upper('" + searchpk2+ "') and  UPPER(NVL(" + pkval.get(2)+ ",'*')) like upper('" + searchpk3+ "')");
								}
								else
								{
									sql.append(" AND " + pkval.get(0)+ " IN (SELECT " + pkval.get(0)+ "  from " + masterName+ "  where UPPER(NVL(" + pkval.get(0)+ ",'*')) LIKE upper('" + searchText+ "'))  and  UPPER(NVL(" + pkval.get(1)+ ",'*')) like upper('" + searchpk2+ "') and  UPPER(NVL(" + pkval.get(2)+ ",'*')) like upper('" + searchpk3+ "')");
								}
								
							}

						}

						} // end of Non-Translated

						//Translated

						else if (display.equals("T")) {

						sql.append(" from  " + trans_table_id + "  where ");

						// Added on Oct16
						if (trans_table_id.equals("XH_OTH_APPL_DATA_DKEY")) {

							if(columnVal!=null && columnVal.size() > 0)
							{
								sql.append(" AND " + pkval.get(0)+ " IN (SELECT " + pkval.get(0)+ "  from " + masterName+ "  where UPPER(NVL(" + pkval.get(0)+ ",'*')) LIKE upper('" + searchText+ "'))  and  UPPER(NVL(" + pkval.get(1)+ ",'*')) like upper('" + searchpk2+ "') and  UPPER(NVL(" + pkval.get(2)+ ",'*')) like upper('" + searchpk3+ "')");
							}
							else
							{
								sql.append(" AND " + pkval.get(0)+ " IN (SELECT " + pkval.get(0)+ "  from " + masterName+ "  where UPPER(NVL(" + pkval.get(0)+ ",'*')) LIKE upper('" + searchText+ "'))  and  UPPER(NVL(" + pkval.get(1)+ ",'*')) like upper('" + searchpk2+ "') and  UPPER(NVL(" + pkval.get(2)+ ",'*')) like upper('" + searchpk3+ "')");
							}



							sql.append("table_id='"+ masterName+ "' and APPLICATION_ID='"+ appl+ "'  and OUTBOUND_YN='"+ outbound_yn+ "'  and 		 (DESC2_VALUE IS NOT NULL OR ext_pk1_value IS NOT NULL OR ext_pk2_value IS NOT NULL) /* )*/ AND UPPER(NVL("+ pkValue.get(0)+ ",'*')) like upper('"+ searchText + "')  AND UPPER(NVL("+ pkValue.get(1)+ ",'*')) like upper('" + searchpk2+ "') ");
						}
						if (trans_table_id.equals("XH_OTH_APPL_DATA_SKEY")) {
							sql.append("table_id='" + masterName
							+ "' and APPLICATION_ID='" + appl
							+ "'  and OUTBOUND_YN='" + outbound_yn
							+ "'  ");

							if (columnVal.size() > 0) {
								sql
								.append(" and (desc2_value IS NOT NULL OR ext_pk_id IS NOT NULL) /*)*/ ");
							} else {
								sql.append("AND ext_pk_id IS NOT NULL /*)*/  ");
							}

							if(columnVal!=null && columnVal.size() > 0)
							{
								sql.append(" AND (UPPER(NVL(" + pkValue.get(0)+ ",'*')) like upper('" + searchText+ "') OR UPPER(NVL(" + columnVal.get(0)+ ",'*')) like upper('" + searchText+ "'))");
							}
							else
							{
								sql.append(" AND UPPER(NVL(" + pkValue.get(0)+ ",'*')) like upper('" + searchText+ "') ");
							}
							
						}

						if (trans_table_id.equals("XH_OTH_APPL_DATA_SKEY")
								|| trans_table_id
								.equals("XH_OTH_APPL_DATA_DKEY")) {

							sql.append("  union	 SELECT  '" + appl
							+ "' APPLICATION_ID,2 SEQ_NO, ");

						} // SKEY/DKEY
						else if (trans_tbl_type.equals("APPL")) {

							if(columnVal!=null && columnVal.size() > 2)
							{
								sql.append(" APPLICATION_ID='"+ appl+ "'   and OUTBOUND_YN='"+ outbound_yn+ "'  and (DESC2_VALUE IS NOT NULL OR ext_pk1_value IS NOT NULL OR ext_pk2_value IS NOT NULL OR ext_pk3_value IS NOT NULL) ) AND (UPPER(NVL("+ pkval.get(0)+ ",'*')) like upper('"+ searchText + "') OR UPPER(NVL("+ columnVal.get(0)+ ",'*')) like upper('"+ searchText + "')) AND (UPPER(NVL("+ pkval.get(1)+ ",'*')) like upper('" + searchpk2+ "') OR UPPER(NVL("+ columnVal.get(1)+ ",'*')) like upper('" + searchpk2+ "'))  and (UPPER(NVL("+ pkval.get(2)+ ",'*')) like upper('" + searchpk3+ "') OR UPPER(NVL("+ columnVal.get(2)+ ",'*')) like upper('" + searchpk3+ "')) ");
							}
							else
							{
								sql.append(" APPLICATION_ID='"+ appl+ "'   and OUTBOUND_YN='"+ outbound_yn+ "'  and (DESC2_VALUE IS NOT NULL OR ext_pk1_value IS NOT NULL OR ext_pk2_value IS NOT NULL OR ext_pk3_value IS NOT NULL) ) AND UPPER(NVL("+ pkval.get(0)+ ",'*')) like upper('"+ searchText + "')  AND UPPER(NVL("+ pkval.get(1)+ ",'*')) like upper('" + searchpk2+ "')  and  UPPER(NVL("+ pkval.get(2)+ ",'*')) like upper('" + searchpk3+ "') ");
							}

							
							sql.append(" union	 SELECT  '" + appl
							+ "' APPLICATION_ID,2 SEQ_NO,");
						} else {

							if(columnVal!=null && columnVal.size() > 2)
							{
								sql.append("APPLICATION_ID='" + appl+ "'  )  AND (UPPER(NVL(" + pkval.get(0)+ ",'*')) like upper('" + searchText+ "' ) OR UPPER(NVL(" + columnVal.get(0)+ ",'*')) like upper('" + searchText+ "' ))  and  (UPPER(NVL(" + pkval.get(1)+ ",'*')) like upper('" + searchpk2+ "') OR UPPER(NVL(" + columnVal.get(1)+ ",'*')) like upper('" + searchpk2+ "')) and  (UPPER(NVL(" + pkval.get(2)+ ",'*')) like upper('" + searchpk3 + "') OR UPPER(NVL(" + columnVal.get(2)+ ",'*')) like upper('" + searchpk3 + "'))");
							}
							else
							{
								sql.append("APPLICATION_ID='" + appl+ "'  )  AND UPPER(NVL(" + pkval.get(0)+ ",'*')) like upper('" + searchText+ "' )  and  UPPER(NVL(" + pkval.get(1)+ ",'*')) like upper('" + searchpk2+ "') and  UPPER(NVL(" + pkval.get(2)+ ",'*')) like upper('" + searchpk3 + "')");
							}

							if ((masterName.equals("SM_FUNCTION")
							|| masterName.equals("SM_REPORT")
							|| masterName.equals("SM_FUNCTION_LEGEND")
							|| masterName.equals("SM_LABEL_ITEM")
							|| masterName.equals("SM_LIST_ITEM") || masterName
							.equals("SM_RECORD_TRANS"))
							&& (!Searchbymod.equals(""))) {

								sql.append(" and module_id='" + Searchbymod
								+ "'");
							}
							if (masterName.equals("SM_FUNCTION_LEGEND")) {
								if (!SearchbyFunct.equals("")) {

							sql.append(" and function_id like upper('"
									+ SearchbyFunct + "%')  ");
								}
							}

							sql.append(" union	 SELECT  '" + appl
							+ "' APPLICATION_ID,2 SEQ_NO,");

						} // OTH !(SKEY,DKEY)
						if (trans_table_id.equals("XH_OTH_APPL_DATA_SKEY")) {

							if (columnVal.size() > 0) {
								sql.append("pk_value,ext_pk_id,");
							} else {
								sql.append("pk_value,ext_pk_id");
							}

							for (startVal = 0; startVal < columnVal.size(); startVal++) {
								//	     	sql.append("desc"+(startVal+1)+"_Value");

								sql.append("desc" + (startVal + 2) + "_Value");
								if (startVal < columnVal.size() - 1) {
							sql.append(",");
								}

							}

						}// end of SKEY 
						else if (trans_table_id.equals("XH_OTH_APPL_DATA_DKEY")) {
							sql
							.append("pk1_value,pk2_value, ext_pk1_value,ext_pk2_value,");
							for (startVal = 0; startVal < columnVal.size(); startVal++) {
								// cmmntd on jan6th	     	sql.append("desc"+(startVal+1)+"_Value");
								sql.append("desc" + (startVal + 2) + "_Value");
								if (startVal < columnVal.size() - 1) {
							sql.append(",");
								}
							}
						}// end of DKEY
						else if (trans_tbl_type.equals("APPL")) {
							sql
							.append("pk1_value,pk2_value, pk3_value,ext_pk1_value,ext_pk2_value,ext_pk3_value,");
							for (startVal = 0; startVal < columnVal.size(); startVal++) {
								// cmmntd on jan6th	     	sql.append("desc"+(startVal+1)+"_Value");
								sql.append("desc" + (startVal + 2) + "_Value");
								if (startVal < columnVal.size() - 1) {
							sql.append(",");
								}
							}
						}// end of APPL
						else {
							for (startVal = 0; startVal < pkval.size(); startVal++) {
								sql.append(pkval.get(startVal) + ",");
							}

							for (startVal = 0; startVal < columnVal.size(); startVal++) {
								sql.append(columnVal.get(startVal));
								if (startVal < columnVal.size() - 1) {
							sql.append(",");
								}

							}
						}// !(SKEY,DKEY)

						if (trans_table_id.equals("XH_OTH_APPL_DATA_SKEY")) {
							sql.append("   FROM  " + trans_table_id
							+ "  WHERE  APPLICATION_ID = '" + appl
							+ "' and table_id='" + masterName
							+ "'  and OUTBOUND_YN='" + outbound_yn
							+ "' ");

							if (columnVal.size() > 0) {
								sql
								.append("   AND (desc2_value IS NOT NULL OR ext_pk_id IS NOT NULL) ");
							} else {
								sql.append("    AND ext_pk_id IS NOT NULL ");
							}

								// modified on Dec 24 for Name Prefix - only for code
								// cmmntd on jan 6th	if(columnVal.size()>0){
							if(columnVal!=null && columnVal.size() > 0)
							{
								sql.append(" AND (UPPER(NVL(" + pkValue.get(0)+ ",'*')) LIKE upper('" + searchText+ "') OR UPPER(NVL(" + columnVal.get(0)+ ",'*')) LIKE upper('" + searchText+ "')) /*) */");
							}
							else
							{
								sql.append(" AND UPPER(NVL(" + pkValue.get(0)+ ",'*')) LIKE upper('" + searchText+ "') /*) */");
							}
								
								//		}
						}// SKEY
						else if (trans_table_id.equals("XH_OTH_APPL_DATA_DKEY")) {

							sql
							.append("   FROM  "
									+ trans_table_id
									+ "  WHERE  (DESC2_VALUE IS NOT NULL OR ext_pk1_value IS  NOT NULL OR ext_pk2_value IS  NOT NULL) and APPLICATION_ID = '"
									+ appl + "' and table_id='"
									+ masterName
									+ "'  and OUTBOUND_YN='"
									+ outbound_yn + "' ");

							if(columnVal!=null && columnVal.size() > 1)
							{
								sql.append("AND  (UPPER(NVL("+ pkValue.get(0) + ",'*')) like upper('"+ searchText + "') OR UPPER(NVL("+ columnVal.get(0) + ",'*')) like upper('"+ searchText + "')) AND (UPPER(NVL("+ pkValue.get(1) + ",'*')) like upper('"+ searchpk2 + "') OR UPPER(NVL("+ columnVal.get(1) + ",'*')) like upper('"+ searchpk2 + "')) /*)*/");
							}
							else
							{
								sql.append("AND  UPPER(NVL("+ pkValue.get(0) + ",'*')) like upper('"+ searchText + "')  AND UPPER(NVL("+ pkValue.get(1) + ",'*')) like upper('"+ searchpk2 + "') /*)*/");
							}
								
						} // DKEY
						else if (trans_tbl_type.equals("APPL")) {

							sql
							.append("   FROM  "
									+ trans_table_id
									+ "  WHERE  (DESC2_VALUE IS NOT NULL OR ext_pk1_value IS  NOT NULL OR ext_pk2_value IS  NOT NULL OR ext_pk3_value IS  NOT NULL) and APPLICATION_ID = '"
									+ appl + "'  and OUTBOUND_YN='"
									+ outbound_yn + "' ");

							sql
							.append("  AND (pk1_value,pk2_value,pk3_value) IN (SELECT "
									+ pkval.get(0)
									+ ","
									+ pkval.get(1)
									+ "," + pkval.get(2));

							if(columnVal!=null && columnVal.size() > 2)
							{
								sql.append("  from " + masterName+ "  where  (UPPER(NVL(" + pkval.get(0)+ ",'*')) like upper('" + searchText+ "') OR UPPER(NVL(" + columnVal.get(0)+ ",'*')) like upper('" + searchText+ "'))  AND (UPPER(NVL(" + pkval.get(1)+ ",'*')) like upper('" + searchpk2+ "') OR UPPER(NVL(" + columnVal.get(1)+ ",'*')) like upper('" + searchpk2+ "')) and  (UPPER(NVL(" + pkval.get(2)+ ",'*')) like upper('" + searchpk3+ "') OR UPPER(NVL(" + columnVal.get(2)+ ",'*')) like upper('" + searchpk3+ "')) )");
							}
							else
							{
								sql.append("  from " + masterName+ "  where  UPPER(NVL(" + pkval.get(0)+ ",'*')) like upper('" + searchText+ "')  AND UPPER(NVL(" + pkval.get(1)+ ",'*')) like upper('" + searchpk2+ "') and  UPPER(NVL(" + pkval.get(2)+ ",'*')) like upper('" + searchpk3+ "') )");
							}							

						} // APPL
						else {

							// sql.append("   FROM  "+trans_table_id+"  WHERE  "+columnVal.get(0)+" is not null and APPLICATION_ID = '"+appl+"' " ); 
							sql.append("   FROM  " + trans_table_id
							+ "  WHERE  APPLICATION_ID = '" + appl
							+ "' ");

								sql.append(" and  (");
								for (startVal = 0; startVal < pkValue.size(); startVal++) {
									sql.append(pkValue.get(startVal));
									if (startVal < pkValue.size() - 1) {
										sql.append(",");
									}
								}
								sql.append(" ) IN (SELECT ");

								for (startVal = 0; startVal < pkValue.size(); startVal++) {
									sql.append(pkValue.get(startVal));
									if (startVal < pkValue.size() - 1) {
										sql.append(",");
									}
								}
								sql.append(" from " + masterName+ "  where UPPER(NVL(" + pkval.get(0)+ ",'*')) LIKE upper('" + searchText+ "')) ");

						//	} else {

							if(columnVal!=null && columnVal.size() > 2)
							{
								sql.append(" AND " + pkval.get(0)+ " IN (SELECT " + pkval.get(0)+ "  from " + masterName+ "  where (UPPER(NVL(" + pkval.get(0)+ ",'*')) LIKE upper('" + searchText+ "') OR UPPER(NVL(" + columnVal.get(0)+ ",'*')) LIKE upper('" + searchText+ "')) )  and  (UPPER(NVL(" + pkval.get(1)+ ",'*')) like upper('" + searchpk2+ "') OR UPPER(NVL(" + columnVal.get(1)+ ",'*')) like upper('" + searchpk2+ "')) and  (UPPER(NVL(" + pkval.get(2)+ ",'*')) like upper('" + searchpk3+ "') OR UPPER(NVL(" + columnVal.get(2)+ ",'*')) like upper('" + searchpk3+ "'))");
							}
							else
							{
								sql.append(" AND " + pkval.get(0)+ " IN (SELECT " + pkval.get(0)+ "  from " + masterName+ "  where UPPER(NVL(" + pkval.get(0)+ ",'*')) LIKE upper('" + searchText+ "'))  and  UPPER(NVL(" + pkval.get(1)+ ",'*')) like upper('" + searchpk2+ "') and  UPPER(NVL(" + pkval.get(2)+ ",'*')) like upper('" + searchpk3+ "')");
							}
								
							}

				//		}

						} // end of Translated

						else {

						sql.append(" from  " + trans_table_id + "  where ");
						if (trans_table_id.equals("XH_OTH_APPL_DATA_SKEY")
								|| trans_table_id
								.equals("XH_OTH_APPL_DATA_DKEY")) {
							// code added on Dec 24 - Name Prefix
							sql.append("table_id='" + masterName
							+ "' and APPLICATION_ID='" + appl
							+ "'  and OUTBOUND_YN='" + outbound_yn
							+ "' /*) */ ");

							if (trans_table_id.equals("XH_OTH_APPL_DATA_SKEY")) {

								sql.append("AND UPPER(NVL(PK_VALUE,'*')) like upper('"+ searchText + "')");

							} else if (trans_table_id.equals("XH_OTH_APPL_DATA_DKEY")) {

								if(columnVal!=null && columnVal.size() > 1)
								{
									sql.append("AND (UPPER(NVL(" + pkValue.get(0)+ ",'*')) like upper('" + searchText+ "') OR UPPER(NVL(" + columnVal.get(0)+ ",'*')) like upper('" + searchText+ "'))  AND (UPPER(NVL(" + pkValue.get(1)+ ",'*')) like upper('" + searchpk2+ "') OR UPPER(NVL(" + columnVal.get(1)+ ",'*')) like upper('" + searchpk2+ "')) ");
								}
								else
								{
									sql.append("AND UPPER(NVL(" + pkValue.get(0)+ ",'*')) like upper('" + searchText+ "')  AND UPPER(NVL(" + pkValue.get(1)+ ",'*')) like upper('" + searchpk2+ "') ");
								}								

							}

							sql.append("  union	 SELECT  '" + appl
							+ "' APPLICATION_ID,2 SEQ_NO, ");

						} // SKEY/DKEY
						else {

							if(columnVal!=null && columnVal.size() > 2)
							{
								sql.append("APPLICATION_ID='" + appl+ "' )  AND (UPPER(NVL(" + pkval.get(0)+ ",'*')) like upper('" + searchText+ "' ) OR UPPER(NVL(" + columnVal.get(0)+ ",'*')) like upper('" + searchText+ "' )) and  (UPPER(NVL(" + pkval.get(1)+ ",'*')) like upper('" + searchpk2+ "') OR UPPER(NVL(" + columnVal.get(1)+ ",'*')) like upper('" + searchpk2+ "')) and  (UPPER(NVL(" + pkval.get(2)+ ",'*')) like upper('" + searchpk3 + "') OR UPPER(NVL(" + columnVal.get(2)+ ",'*')) like upper('" + searchpk3 + "'))");
							}
							else
							{
								sql.append("APPLICATION_ID='" + appl+ "' )  AND UPPER(NVL(" + pkval.get(0)+ ",'*')) like upper('" + searchText+ "' ) and  UPPER(NVL(" + pkval.get(1)+ ",'*')) like upper('" + searchpk2+ "') and  UPPER(NVL(" + pkval.get(2)+ ",'*')) like upper('" + searchpk3 + "')");
							}

							sql.append(" union	 SELECT  '" + appl
							+ "' APPLICATION_ID,2 SEQ_NO,");

						} // OTH !(SKEY,DKEY)
						if (trans_table_id.equals("XH_OTH_APPL_DATA_SKEY")) {
							/* Cmmnt Oct16
							 sql.append("pk_value,"); */
							// code added on dec 24th - Name Prefix
							if (columnVal.size() > 0) {
								sql.append("pk_value,ext_pk_id,");
							} else {
								sql.append("pk_value,ext_pk_id");
							}
							// end code added 
							for (startVal = 0; startVal < columnVal.size(); startVal++) {
								sql.append("desc" + (startVal + 2) + "_Value");
								if (startVal < columnVal.size() - 1) {
							sql.append(",");
								}

							}

						}// end of SKEY 
						else if (trans_table_id.equals("XH_OTH_APPL_DATA_DKEY")) {
							sql
							.append("pk1_value,pk2_value, ext_pk1_value,ext_pk2_value,");
							for (startVal = 0; startVal < columnVal.size(); startVal++) {
								sql.append("desc" + (startVal + 2) + "_Value");
								if (startVal < columnVal.size() - 1) {
							sql.append(",");
								}
							}
						}// end of DKEY
						else if (trans_tbl_type.equals("APPL")) {
							sql
							.append("pk1_value,pk2_value,pk3_value,ext_pk1_value,ext_pk2_value,ext_pk3_value,");
							for (startVal = 0; startVal < columnVal.size(); startVal++) {
								sql.append("desc" + (startVal + 2) + "_Value");
								if (startVal < columnVal.size() - 1) {
							sql.append(",");
								}
							}
						}// end of APPL
						else {
							for (startVal = 0; startVal < pkval.size(); startVal++) {
								sql.append(pkval.get(startVal) + ",");
							}

							for (startVal = 0; startVal < columnVal.size(); startVal++) {
								String NwCol = (String) columnVal.get(startVal);
								if (!NwCol.substring(0, 3).equals("EXT")) {
							NwCol = "EXT_" + NwCol;
							sql.append(NwCol);
								} else {
							sql.append(columnVal.get(startVal));
								}
								if (startVal < columnVal.size() - 1) {
							sql.append(",");
								}

							}
						}// !(SKEY,DKEY)

						if (trans_table_id.equals("XH_OTH_APPL_DATA_SKEY")) {
							//         System.out.println("1644");
							sql.append("   FROM  " + trans_table_id
							+ "  WHERE  APPLICATION_ID = '" + appl
							+ "' and table_id='" + masterName
							+ "'  and OUTBOUND_YN='" + outbound_yn
							+ "' ");
							if ((masterName.equals("SM_FUNCTION")
							|| masterName.equals("SM_REPORT")
							|| masterName.equals("SM_FUNCTION_LEGEND")
							|| masterName.equals("SM_LABEL_ITEM")
							|| masterName.equals("SM_LIST_ITEM") || masterName
							.equals("SM_RECORD_TRANS"))) {
								if (!Searchbymod.equals("")) {

							sql.append(" and pk_value='" + Searchbymod
									+ "'");
								}
							} else {
								sql.append(" AND /* pk_value IN (SELECT "+ pkval.get(0)+ "  from "+ masterName+ "  where */ UPPER(NVL(PK_VALUE,'*')) LIKE upper('"+ searchText + "') /*) */");
							}

						}// SKEY
						else if (trans_table_id.equals("XH_OTH_APPL_DATA_DKEY")) {

							sql.append("   FROM  " + trans_table_id
								+ "  WHERE  APPLICATION_ID = '" + appl
								+ "' and table_id='" + masterName
								+ "'  and OUTBOUND_YN='" + outbound_yn
								+ "' ");

							if(columnVal!=null && columnVal.size() > 1)
							{
								sql.append("AND (UPPER(NVL("+ pkValue.get(0) + ",'*')) like upper('"+ searchText + "') OR UPPER(NVL("+ columnVal.get(0) + ",'*')) like upper('"+ searchText + "'))  AND (UPPER(NVL("+ pkValue.get(1) + ",'*')) like upper('"+ searchpk2 + "') OR UPPER(NVL("+ columnVal.get(1) + ",'*')) like upper('"+ searchpk2 + "')) /*)*/ ");
							}
							else
							{
								sql.append("AND UPPER(NVL("+ pkValue.get(0) + ",'*')) like upper('"+ searchText + "')  AND UPPER(NVL("+ pkValue.get(1) + ",'*')) like upper('"+ searchpk2 + "') /*)*/ ");
							}
							
						} // DKEY
						else if (trans_tbl_type.equals("APPL")) {

							sql.append("   FROM  " + trans_table_id
								+ "  WHERE  APPLICATION_ID = '" + appl
								+ "'  and OUTBOUND_YN='" + outbound_yn
								+ "'  ");

							sql
							.append("  AND (pk1_value,pk2_value,pk3_value) IN (SELECT "
									+ pkval.get(0) + ",");

							if(columnVal!=null && columnVal.size() > 2)
							{
								sql.append(pkval.get(1) + "," + pkval.get(2)+ "  from " + masterName+ "  where  (UPPER(NVL(" + pkval.get(0)+ ",'*')) like upper('" + searchText+ "') OR UPPER(NVL(" + columnVal.get(0)+ ",'*')) like upper('" + searchText+ "'))  AND (UPPER(NVL(" + pkval.get(1)+ ",'*')) like upper('" + searchpk2+ "') OR UPPER(NVL(" + columnVal.get(1)+ ",'*')) like upper('" + searchpk2+ "')) AND (UPPER(NVL(" + pkval.get(2)+ ",'*')) like upper('" + searchpk3+ "') OR UPPER(NVL(" + columnVal.get(2)+ ",'*')) like upper('" + searchpk3+ "')) )");
							}
							else
							{
								sql.append(pkval.get(1) + "," + pkval.get(2)+ "  from " + masterName+ "  where  UPPER(NVL(" + pkval.get(0)+ ",'*')) like upper('" + searchText+ "')  AND UPPER(NVL(" + pkval.get(1)+ ",'*')) like upper('" + searchpk2+ "') AND UPPER(NVL(" + pkval.get(2)+ ",'*')) like upper('" + searchpk3+ "') )");
							}

							
						} // APPL
						else {

							sql.append("   FROM  " + trans_table_id
							+ "  WHERE  APPLICATION_ID = '" + appl
							+ "' ");

							sql.append(" and  (");
								for (startVal = 0; startVal < pkValue.size(); startVal++) {
									sql.append(pkValue.get(startVal));
									if (startVal < pkValue.size() - 1) {
										sql.append(",");
									}
								}
								sql.append(" ) IN (SELECT ");

								for (startVal = 0; startVal < pkValue.size(); startVal++) {
									sql.append(pkValue.get(startVal));
									if (startVal < pkValue.size() - 1) {
										sql.append(",");
									}
								}
							if(columnVal!=null && columnVal.size() > 0)
							{
								sql.append(" from " + masterName+ "  where (UPPER(NVL(" + pkval.get(0)+ ",'*')) LIKE upper('" + searchText+ "') OR UPPER(NVL(" + pkval.get(0)+ ",'*')) LIKE upper('" + searchText+ "')) )");
							}
							else
							{
								sql.append(" from " + masterName+ "  where UPPER(NVL(" + pkval.get(0)+ ",'*')) LIKE upper('" + searchText+ "'))");
							}								

				//			} else {

							if(columnVal!=null && columnVal.size() > 2)
							{
								sql.append(" AND " + pkval.get(0)+ " IN (SELECT " + pkval.get(0)+ "  from " + masterName+ "  where (UPPER(NVL(" + pkval.get(0)+ ",'*')) LIKE upper('" + searchText+ "') OR UPPER(NVL(" + columnVal.get(0)+ ",'*')) LIKE upper('" + searchText+ "')) )  and  (UPPER(NVL(" + pkval.get(1)+ ",'*')) like upper('" + searchpk2+ "') OR UPPER(NVL(" + columnVal.get(1)+ ",'*')) like upper('" + searchpk2+ "')) and  (UPPER(NVL(" + pkval.get(2)+ ",'*')) like upper('" + searchpk3+ "') OR UPPER(NVL(" + columnVal.get(2)+ ",'*')) like upper('" + searchpk3+ "'))");
							}
							else
							{
								sql.append(" AND " + pkval.get(0)+ " IN (SELECT " + pkval.get(0)+ "  from " + masterName+ "  where UPPER(NVL(" + pkval.get(0)+ ",'*')) LIKE upper('" + searchText+ "'))  and  UPPER(NVL(" + pkval.get(1)+ ",'*')) like upper('" + searchpk2+ "') and  UPPER(NVL(" + pkval.get(2)+ ",'*')) like upper('" + searchpk3+ "')");
							}
								
				//			}

						}

							} // end of ALL

							// added the condition on Mar 12th
							/*    if(trans_table_id.equals("XH_OTH_APPL_DATA_SKEY")||trans_table_id.equals("XH_OTH_APPL_DATA_DKEY")){	 */
							sql.append(" order by  ");
							for (startVal = 0; startVal < pkval.size(); startVal++) {
						sql.append(pkval.get(startVal));
						if (startVal < pkval.size() - 1)
							sql.append(",");
							}
							//	   sql.append("PK_VALUE");
							sql.append(",seq_no");
							/*	 }
							 else{
							 sql.append(" order by  ");
							 sql.append("seq_no");	
							 } */

						//	System.out.println("XHTranslationManagerResultN.jsp 1701 sql : "+ sql.toString());

							pstmt = con.prepareStatement(sql.toString(),
							ResultSet.TYPE_SCROLL_INSENSITIVE,
							ResultSet.CONCUR_UPDATABLE);
							rs = pstmt.executeQuery();

							String temppk1 = "";
							int l = 0;
							int m = 0;
							int i = 0, j = 0;
							int colDispCount = 0;
							int pkDataCnt = pkval.size();

							if (start != 1)
						for (m = 1; m < start; l++, m++) {
							rs.next();
						}
							String pkData[] = new String[pkval.size()];
							String pkData1[] = new String[pkval.size()];

							for (startVal = 0; startVal < pkval.size(); startVal++) {
						pkData1[i] = "";
							}
							boolean maxrecallow = false;

							if (!table_or_form.equals("F")) {
						maxrecallow = l < end;

							} else {
						maxrecallow = true;
							}
							//	 while(rs.next() && maxrecallow)	 
							while (rs.next() && maxrecallow) {

						lang = rs.getString(1);
						//	System.out.println("lang @ 1263 : "+lang);

						for (startVal = 0; startVal < pkval.size(); startVal++) {
							//pkData[startVal]=rs.getString((String)pkval.get(startVal));
							pkData[startVal] = rs.getString((String) pkval
							.get(startVal));
						}

						if (i % 2 == 0)
							classValue = "BACKGROUND-COLOR:#F0F0F2";
						else
							classValue = "BACKGROUND-COLOR:#E2E3F0;";
				%>




				<tr>



					<%
								if (!table_or_form.equals("F")) {
								int pkCnt = 1;
								for (startVal = 0; startVal < pkval.size(); startVal++) {
									String keyName = "";
									if (lang.equals("en")) {
					%>
					<!--					 <td class=data style='<%=classValue%>' >&nbsp;</td>  -->
					<td class=data style='<%=classValue%>'>
						<b> <%=pkData[startVal]%>
					</td>
					<%
								} else {
								if (trans_table_id
										.equals("XH_OTH_APPL_DATA_DKEY")) {
									keyName = "ext_pk" + pkCnt + "_value";
									//		 System.out.println("keyName :"+keyName);
								} else if (trans_tbl_type.equals("APPL")) {
									keyName = "ext_pk" + pkCnt + "_value";
									//		 System.out.println("keyName :"+keyName);
								} else if (trans_table_id
										.equals("XH_OTH_APPL_DATA_SKEY")) {
									keyName = "ext_pk_id";
									//		 System.out.println("keyName :"+keyName);
								}
								//		 System.out.println("pkLen.get(startVal) :"+pkLen.get(startVal));
					%>
					<td class='fields' style='<%=classValue%>'>
						<INPUT TYPE="text" name="pkVal<%=startVal%><%=colCount%>" id="pkVal<%=startVal%><%=colCount%>"
							value='<%=rs
															.getString((String) keyName) == null ? ""
													: rs
															.getString((String) keyName)%>'
							maxlength='<%=pkLen.get(startVal)%>' size=20>
					</td>
					<!--  ext_pk1_value
				 <td class='fields' style='<%=classValue%>' >
 				 <INPUT TYPE="text" name="pkVal<%=startVal%><%=colCount%>" id="pkVal<%=startVal%><%=colCount%>"   onblur='return makeValidString(this);'
				 maxlength='<%=pkLen.get(startVal)%>'  value='<%=rs
															.getString((String) pkval
																	.get(startVal)) == null ? ""
													: rs
															.getString((String) pkval
																	.get(startVal))%>' size=40 > </td> 
				 -->
					<%
									pkCnt++;
									}
								}
								for (startVal = 0; startVal < pkval.size(); startVal++) {
									pkData1[startVal] = pkData[startVal];
								}
							} // end of !Form -  Table
					%>

					<%
							int colCount1 = 0;
							int engColCount = 0;

							if (table_or_form.equals("F")) {

								/*		if(display.equals("N")){
								 if(rs.getString((String)columnVal.get(colDispCount))==null){
								 */
								for (startVal = 0; startVal < pkval.size(); startVal++) {
					%>
					<input type=hidden name="pk<%=colCount%><%=startVal%>" id="pk<%=colCount%><%=startVal%>"
						value='<%=pkData[startVal]%>'>
					<%
					}
					%>
					<td class=data>
						<b><%=columnPrompt.get(colDispCount)%>
						</b>
					</td>

					<td class=data>
						<b><%=(rs.getString((String) colValue
											.get(colDispCount)) == null) ? ""
									: (rs.getString((String) colValue
											.get(colDispCount)))%>
						</b>
					</td>
					<%%>

					

					<%
								engColCount++;
								rs.next();
					%>
					<td class='fields' style='<%=classValue%>'>
						<INPUT TYPE="text" name="desc<%=colDispCount%>0" id="desc<%=colDispCount%>0"
							onblur='return makeValidString(this);'
							maxlength='<%=columnLen.get(colDispCount)%>'
							value='<%=rs.getString((String) columnVal
											.get(colDispCount)) == null ? ""
									: rs.getString((String) columnVal
											.get(colDispCount))%>'
							size=60>
					</td>
				
				<%
							colDispCount = colDispCount + 1;
							//colCount++;
							colCount = 1;
						} // end of Form
						else {

							if (colCount == 0) {
								//		System.out.println("1907");
							}
							for (startVal = 0; startVal < columnVal.size(); startVal++) {
								//
				%>
				<%
							if (columnVal.size() > 0) {
							if (lang.equals("en")) {
				%>

				<td class=data style='<%=classValue%>'>
					<b><%=rs
																.getString((String) columnVal
																		.get(startVal)) == null ? ""
														: rs
																.getString((String) columnVal
																		.get(startVal))%>
				</td>
				<input type="hidden" name="engLang<%=engColCount%><%=colCount%>" id="engLang<%=engColCount%><%=colCount%>"
					id='<%="engLang"
												+ (engColCount) + (colCount)%>'
					value='<%=rs
																.getString((String) columnVal
																		.get(startVal)) == null ? ""
														: rs
																.getString((String) columnVal
																		.get(startVal))%>'>

				<%
							engColCount++;
							} else {
				%>
				<td class='fields' style='<%=classValue%>'>
					<INPUT TYPE="text" name="desc<%=colCount1++%><%=colCount%>" id="desc<%=colCount1++%><%=colCount%>"
						onblur='return makeValidString(this);'
						maxlength='<%=columnLen.get(startVal)%>'
						value='<%=rs
																.getString((String) columnVal
																		.get(startVal)) == null ? ""
														: rs
																.getString((String) columnVal
																		.get(startVal))%>'
						size=50>
				</td>
				<%
								}
								}// end of columnVal chk
							} // end of for
				%>

				</tr>

				<%
							temppk1 = pk1;
							temppk2 = pk2;
						} // end of else Form
						if (!lang.equals("en")) {
							//		System.out.println(" 1379 !lang.equals('en') ");

							for (startVal = 0; startVal < pkval.size(); startVal++) {
				%>
				<input type=hidden name="pk<%=colCount%><%=startVal%>" id="pk<%=colCount%><%=startVal%>"
					value='<%=pkData[startVal]%>'>
				<%
							}
							i++;
							colCount++;
						} else {
						}
						j++;
						l++;

						if (!table_or_form.equals("F")) {
							maxrecallow = l < end;

						}
						// modified on Dec 24 - Name Prefix
						if (columnPrompt.size() > 0) {
							if (colDispCount >= columnPrompt.size()) {
								//		System.out.println("1960");
								break;
							}
						}
						// end of code added 
						if (table_or_form.equals("F")) {
							rs.beforeFirst();

						}
							} // end of while 

							if (rs != null)
						rs.close();
							if (pstmt != null)
						pstmt.close();
				%>
				<INPUT TYPE="hidden" name='language_direction' id='language_direction'
					value="<%=language_direction%>">
				<INPUT TYPE="hidden" name='from' id='from' value="<%=start%>">
				<INPUT TYPE="hidden" name='to' id='to' value="<%=end%>">
				<INPUT TYPE="hidden" name='module_id' id='module_id' value="<%=module_id%>">
				<INPUT TYPE="hidden" name='masterName' id='masterName' value="<%=masterName%>">
				<INPUT TYPE="hidden" name='language' id='language' value="<%=language%>">
				<INPUT TYPE="hidden" name='application' id='application' value="<%=appl%>">

				<INPUT TYPE="hidden" name='display' id='display' value="<%=display%>">
				<INPUT TYPE="hidden" name='Searchbymod' id='Searchbymod' value="<%=Searchbymod%>">
				<INPUT TYPE="hidden" name='SearchbyFunct' id='SearchbyFunct' value="<%=SearchbyFunct%>">

				<INPUT TYPE="hidden" name='start_ends_contains' id='start_ends_contains'
					value="<%=start_ends_contains%>">
				<INPUT TYPE="hidden" name='searchText' id='searchText' value="<%=searchText1%>">
				<INPUT TYPE="hidden" name='master_table_id' id='master_table_id'
					value="<%=master_table_id%>">
				<INPUT TYPE="hidden" name='trans_tab_id' id='trans_tab_id' value="<%=trans_table_id%>">
				<INPUT TYPE="hidden" name='cnt' id='cnt' value="<%=colCount%>">
				<INPUT TYPE="hidden" name='pkDataCnt' id='pkDataCnt' value="<%=pkDataCnt%>">
				<INPUT TYPE="hidden" name='flag' id='flag' value="">
				<INPUT TYPE="hidden" name='table_or_from' id='table_or_from' value="<%=table_or_form%>">
				<INPUT TYPE="hidden" name='colsize' id='colsize' value="<%=columnVal.size()%>">
				<INPUT TYPE="hidden" name='outbound_yn' id='outbound_yn' value="<%=outbound_yn%>">
				<INPUT TYPE="hidden" name='searchpk2' id='searchpk2' value="<%=searchpk2Val%>">
				<INPUT TYPE="hidden" name='searchpk3' id='searchpk3' value="<%=searchpk3Val%>">
				<input type="hidden" name='sqlQuery' id='sqlQuery' value="<%=sql.toString()%>">
				<script>
					parent.frames[1].document.forms[0].sqlQuery.value= this.document.forms[0].sqlQuery.value;
				</script>
			</table>
		</form>
	</body>
</html>
<%
		} // end of max rec !=0
		pkval.clear();
		pkValue.clear();
		pkLen.clear();
		pkPrompt.clear();
		columnPrompt.clear();
		columnVal.clear();
		colValue.clear();
		columnLen.clear();
	} catch (Exception e) {
		System.out.println("(XHTranslationManagerResultNExternal.jsp Error)" + e);
		e.printStackTrace();
	} finally {

		ConnectionManager.returnConnection(con, request);
	}
%>

