<!DOCTYPE html>
<%@ page import ="java.sql.*, java.text.*,webbeans.eCommon.*"  contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<head>
<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'> -->
<%
	request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
</head>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey();' class='message'>
<form name='fetchLocnValues_form' id='fetchLocnValues_form'>
<%
	String facility_id = (String) session.getValue("facility_id");
	
	Connection con				= ConnectionManager.getConnection(request);
	java.sql.Statement stmt		= null;
	PreparedStatement pstmt		= null;
	ResultSet rs				= null;
	

	int x = 0;

	String selFacility	= request.getParameter("Facility");
	String selUser		= request.getParameter("User");
	String issueLocn	= request.getParameter("issueLocn");
	String selUserSecurity	= request.getParameter("userSecurity");

	try
	{
		String sql						= "";
		String Code						= "";
		String Desc						= "";
		String Code1					= "";
		String Desc1					= "";
		String LocnIden					= "";
		String LocnNarr					= "";
		String LocnMRyn					= "";
		String NoOfDays					= "";
		String access_all				= "";
		String moreCriteria				= "";
		String called_from				= "";	
		String primary_splty_long_desc	= "";	
		String pract_type_desc			= "";

		int record_count = 0;

		boolean present  = false;

		stmt = con.createStatement();
			
		 // from FMIssueFileManualEntry.jsp - function populateLocations(user)
		called_from = request.getParameter("called_from");
		if(called_from == null || called_from.equals("null")) called_from = "";
	
		if(called_from.equals("1"))
		{
			//sql = "SELECT pract_type_desc,primary_splty_long_desc FROM  am_practitioner_vw WHERE practitioner_id = ?";

			//sql = "SELECT a.pract_type_desc,a.primary_splty_long_desc FROM  am_practitioner_vw a, sm_appl_user b WHERE b.appl_user_id = ? and a.practitioner_id = b.func_role_id";
			sql = "SELECT"
					  +"  AM_GET_DESC.AM_PRACT_TYPE(A.PRACT_TYPE,'"+localeName+"','1') prAct_Type_desc"
					  +"  , AM_GET_DESC.AM_SPECIALITY(a.PRIMARY_SPECIALITY_CODE,'"+localeName+"','2') primary_splty_long_desc"
					  +"  , A.primary_speciality_code "
					  +"FROM"
					  +"  am_practitioner a"
					  +"  , sm_appl_user b "
					  +"WHERE b.apPl_User_Id = ? "
					  +"  AND a.Practitioner_Id = b.Func_Role_Id";

		
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,selUser);
			rs  = pstmt.executeQuery();
			if(rs != null && rs.next())
			{
				pract_type_desc			= rs.getString("pract_type_desc"); 
				primary_splty_long_desc = rs.getString("primary_splty_long_desc");
				
				record_count++;
			}
			if(rs != null)	rs.close();
			if(pstmt != null) pstmt.close();
		
			if(pract_type_desc == null || pract_type_desc.equals("null")) pract_type_desc = "";
			if(primary_splty_long_desc == null || primary_splty_long_desc.equals("null"))
				primary_splty_long_desc = "";
		
			if(record_count != 0)
			{
				%>
				<SCRIPT>
					parent.frames[2].document.getElementById('td1').innerHTML = getLabel("Common.designation.label","common");
					parent.frames[2].document.getElementById('td2').innerHTML = "<B><%=pract_type_desc%></B>";
					parent.frames[2].document.getElementById('td3').innerHTML = getLabel("Common.primaryspeciality.label","common");
					parent.frames[2].document.getElementById('td4').innerHTML = "<B><%=primary_splty_long_desc%></B>";
				</SCRIPT>
				<%
			}
			else 
			{
				%>
				<SCRIPT>
					parent.frames[2].document.getElementById('td1').innerHTML = "";
					parent.frames[2].document.getElementById('td2').innerHTML = "";
					parent.frames[2].document.getElementById('td3').innerHTML = "";
					parent.frames[2].document.getElementById('td4').innerHTML = "";
				</SCRIPT>
				<%
			}
		}		

		if(selUserSecurity == null || selUserSecurity.equals("null")|| selUserSecurity.equals(""))
			selUserSecurity = "N";

		if(selUserSecurity.equals("Y"))
		{
			sql = "";
			sql = "select 1 rec_cnt from fm_user_access_rights where appl_user_id = ? and facility_id = ? and (fs_locn_code = '*ALL' or manual_request_yn = 'Y') ";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,selUser);
			pstmt.setString(2,selFacility);
			rs  = pstmt.executeQuery();
			while(rs != null && rs.next())
			{
				access_all = rs.getString("rec_cnt");
			}
			if(rs != null)	rs.close();
			if(pstmt != null) pstmt.close();

			if (access_all.equals("1"))
			{
				if(facility_id.equals(selFacility))
				   moreCriteria = " and FS_LOCN_CODE != '"+issueLocn+"' ";
				
				sql = "";
				//sql = "Select FS_LOCN_CODE, SHORT_DESC, LOCN_IDENTITY, NARRATION_CODE, MR_LOCN_YN ,NO_OF_DAYS_TO_RETURN from FM_STORAGE_LOCN where FACILITY_ID = ? "+moreCriteria+" and EFF_STATUS = 'E' order by 2"; 	
				
				sql = "SELECT"
					  +"  FS_LOCN_CODE"
					  +"  ,fm_get_desc.fm_storage_locn (facility_id, fs_locn_code, '"+localeName+"',2) SHORT_DESC"
					  +"  , LOCN_IDENTITY"
					  +"  , NARRATION_CODE"
					  +"  , MR_LOCN_YN"
					  +"  , NO_OF_DAYS_TO_RETURN "
					  +"FROM"
					  +"  FM_STORAGE_LOCN "
					  +" WHERE EFF_STATUS = 'E' "
					  +"  AND FACILITY_ID = ? "
					  +	moreCriteria
					 //  +"  AND LANGUAGE_ID='"+localeName+"' "
					  +"ORDER BY"
					  +" 2";


				pstmt = con.prepareStatement(sql);
				pstmt.setString(1,selFacility);
			}
			else
			{
				if(facility_id.equals(selFacility))
				   moreCriteria = " AND REQ_YN = 'Y' and B.FS_LOCN_CODE != '"+issueLocn+"' ";
				else
				   moreCriteria = " AND REQ_ACROSS_FACILITIES_YN = 'Y' ";
				
				sql = "";
				//sql = "Select FS_LOCN_CODE, FS_LOCN_SHORT_DESC SHORT_DESC, LOCN_IDENTITY, NARRATION_CODE, MR_LOCN_YN ,NO_OF_DAYS_TO_RETURN from FM_USER_ACCESS_RIGHTS_VW where FACILITY_ID = ? AND APPL_USER_ID = ? "+moreCriteria+" order by 2";
				sql = "SELECT"
				  +"  A.FS_LOCN_CODE"
				  +"  , ("
				  +"  CASE "
				  +"  WHEN A.FS_LOCN_CODE = '*ALL' "
				  +"  THEN"
				  +"    '*ALL' "
				  +"  ELSE B.SHORT_DESC "
				  +"  END) SHORT_DESC"
				  +"  , B.LOCN_IDENTITY"
				  +"  , B.NARRATION_CODE"
				  +"  , B.MR_LOCN_YN"
				  +"  , B.NO_OF_DAYS_TO_RETURN "
				  +"FROM"
				  +"  FM_USER_ACCESS_RIGHTS A"
				  +"  , FM_STORAGE_LOCN_LANG_VW B "
				  +"WHERE A.FACILITY_ID = B.FACILITY_ID(+) "
				  +"  AND A.FS_LOCN_CODE = B.FS_LOCN_CODE(+) "
				  +"  AND A.FACILITY_ID = ? "
				  +"  AND A.APPL_USER_ID = ? "
				  + moreCriteria
				  +"ORDER BY"
				  +"  2";

				
				if(pstmt != null) pstmt.close();

				pstmt = con.prepareStatement(sql);
				pstmt.setString(1,selFacility);
				pstmt.setString(2,selUser);
			}
		}
		else if(selUserSecurity.equals("N"))
		{
			if(facility_id.equals(selFacility))
			   moreCriteria = " and FS_LOCN_CODE != '"+issueLocn+"' ";
			
			sql = "";
			//sql = "Select FS_LOCN_CODE, SHORT_DESC, LOCN_IDENTITY, NARRATION_CODE, MR_LOCN_YN ,NO_OF_DAYS_TO_RETURN from FM_STORAGE_LOCN where FACILITY_ID = ? "+moreCriteria+" and EFF_STATUS = 'E' order by 2"; 
			sql = "SELECT"
				  +"  FS_LOCN_CODE"
				  +"  ,fm_get_desc.fm_storage_locn (facility_id, fs_locn_code, '"+localeName+"',2) SHORT_DESC"
				  +"  , LOCN_IDENTITY"
				  +"  , NARRATION_CODE"
				  +"  , MR_LOCN_YN"
				  +"  , NO_OF_DAYS_TO_RETURN "
				  +"FROM"
				  +"  FM_STORAGE_LOCN "
				  +" WHERE EFF_STATUS = 'E' "
				  +"  AND FACILITY_ID = ? "
				  +	moreCriteria
				  	//  +"  AND LANGUAGE_ID='"+localeName+"' "
				  +"ORDER BY"
				  +"  2";

			
			if(pstmt != null) pstmt.close();

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,selFacility);
		}
		rs = pstmt.executeQuery();
		
		%>
		<script>
			var x = parent.issue_tab.document.forms[0].locations.options.length;
			for(var i=0;i<x;i++)
			{
				parent.issue_tab.document.forms[0].locations.remove("locations");
			}

			var tp ="        --- "+getLabel('Common.defaultSelect.label','common')+" ---        ";
			
			var opt1=parent.issue_tab.document.createElement("OPTION");
			opt1.text=tp;
			opt1.value="";

			parent.issue_tab.document.forms[0].locations.add(opt1);

			var y = parent.issue_tab.document.forms[0].narration.options.length;
			for(var i=0;i<y;i++)
			{
				parent.issue_tab.document.forms[0].narration.remove("narration");
			}

			var tp2 ="        --- "+getLabel('Common.defaultSelect.label','common')+" ---        ";
			var opt2=parent.issue_tab.document.createElement("OPTION");
			opt2.text=tp2;
			opt2.value="";

			parent.issue_tab.document.forms[0].narration.add(opt2);
			<%
			if(selUserSecurity.equals("Y"))
			{
				if(access_all.equals("")){
					//out.println("parent.frames[2].document.forms[0].username1.value=''");
					out.println("alert(getMessage(\"FM_NO_USER_RIGHTS\",\"FM\"))");
				}
			}
			%>
		</script>
		<%
		while(rs != null && rs.next())
		{
			present		= true;

			Code		= rs.getString("FS_LOCN_CODE");
			Desc		= rs.getString("SHORT_DESC");
			LocnIden	= rs.getString("LOCN_IDENTITY"); 
			LocnMRyn	= rs.getString("MR_LOCN_YN"); 
			LocnNarr	= rs.getString("NARRATION_CODE"); 
			NoOfDays	= rs.getString("NO_OF_DAYS_TO_RETURN"); 

			x++;
			%>
			<script>
				var element   = parent.issue_tab.document.createElement('OPTION');
				element.value = "<%=Code%>@<%=LocnIden%>@<%=LocnMRyn%>@<%=LocnNarr%>@<%=NoOfDays%>";
				element.text  = "<%=Desc%>";
				parent.issue_tab.document.forms[0].locations.add(element);
			</script>
			<%
		} if(rs != null) rs.close(); if(pstmt != null) pstmt.close();
		if(present)
		{
			sql = "";
			//sql = "Select NARRATION_CODE, SHORT_DESC from FM_NARRATION  where EFF_STATUS = 'E' order by 2";
			sql = "SELECT   NARRATION_CODE,SHORT_DESC FROM fm_narration_lang_vw WHERE    EFF_STATUS = 'E' AND LANGUAGE_ID='"+localeName+"' ORDER BY 2";

			rs = stmt.executeQuery(sql);
			while(rs != null && rs.next())
			{
				Code1 = rs.getString("NARRATION_CODE");
				Desc1 = rs.getString("SHORT_DESC");
				%>
				<script>					
					var element1   = parent.issue_tab.document.createElement('OPTION');
					element1.value = "<%=Code1%>";
					element1.text  = "<%=Desc1%>";
					parent.issue_tab.document.forms[0].narration.add(element1);
				</script>
				<%
			}
		}
	if(rs != null)	 rs.close();
	if(stmt != null) stmt.close();
	if(pstmt != null) pstmt.close();
	}catch(Exception e){out.println("Main :"+e);}
	finally
	{		
		ConnectionManager.returnConnection(con,request);
	}
	%>
	<script>
		if("<%=x%>" == 1)
		{
			parent.issue_detail.document.forms[0].locations(1).selected = true;
			
			var ObjValue = parent.issue_detail.document.forms[0].locations(1).value;
			var reqLocnArr = ObjValue.split("@");
			
			parent.issue_detail.document.forms[0].Req_locn_code.value = reqLocnArr[0];
			parent.issue_detail.document.forms[0].Req_locn_iden.value = reqLocnArr[1];	parent.issue_detail.document.forms[0].Req_locn_mr_locn.value = reqLocnArr[2];	

			var narrcode = reqLocnArr[3];
			if(narrcode == null || narrcode == "null")	narrcode = "";
			parent.issue_detail.document.forms[0].narration.value = narrcode;

			var noofdays = reqLocnArr[4];
			if(noofdays == null || noofdays == "null")	noofdays = "0";
			parent.issue_detail.document.forms[0].No_Of_Days.value = noofdays;
			parent.issue_detail.document.forms[0].files.disabled = false;
		}
	</script>
</form>
</body>
</html>

