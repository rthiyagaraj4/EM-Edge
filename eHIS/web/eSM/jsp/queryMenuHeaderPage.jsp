<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 


<%String sStyle	=
     (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

      <html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link></head><html>

<%
    request.setCharacterEncoding("UTF-8");
	ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
	StringBuffer strbuff;
	Connection con=null ;
	java.sql.Statement stmt=null;
	ResultSet rset=null ;
	ArrayList finAr = new ArrayList();
	ArrayList firstItem = new ArrayList();
	ArrayList secondItem = new ArrayList();
	ArrayList thirdItem = new ArrayList();
	ArrayList fourthItem = new ArrayList();
	ArrayList fifthItem = new ArrayList();
	try {
		
		
		con = ConnectionManager.getConnection(request);
		String Log_user= (String) session.getValue("login_user");
		int Medadmin=0;
		stmt=con.createStatement();
		String sql="select count(*)  from sm_menu_admin where menu_admin_id='"+Log_user+"' 	and to_char(sysdate,'dd/mm/yyyy')>= nvl(to_char(eff_date_from,'dd/mm/yyyy'),sysdate-1) and to_char(sysdate,'dd/mm/yyyy')<=nvl(to_char(eff_date_to,'dd/mm/yyyy'),sysdate+1) ";	
		rset=stmt.executeQuery(sql);
		
		if (rset !=null){
			while (rset.next()){
				Medadmin=Integer.parseInt(rset.getString(1));
			}
		}
		
		
       String menu_id=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.MenuID.label","common_labels");
		
		firstItem.add("Text");  		 //Type of item
		firstItem.add(menu_id);	  // label
		firstItem.add("menu_id");	//name of field
		firstItem.add("30");	// SIZE
		firstItem.add("30");	//LENGTH
		finAr.add(firstItem);//add to ArrayList obj finAr

         String menu_name=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eSM.MenuName.label","sm_labels");
		
		secondItem.add("Text");  		 //Type of item
		secondItem.add(menu_name);	  // label
		secondItem.add("menuname");	//name of field
		secondItem.add("30");	// SIZE
		secondItem.add("60");	//LENGTH

		finAr.add(secondItem);//add to ArrayList obj finAr

		
		thirdItem.add("List");  		 //Type of item
		thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eSM.ResponsibilityGroup.label","sm_labels"));	  // label
		thirdItem.add("resp_group_id");	//name of field
		
		if (Medadmin >0 )
			thirdItem.add("select resp_group_id,resp_group_name from sm_resp_grp  where eff_status='E' and  RESP_GROUP_ID  in  ( select  RESP_GROUP_ID from sm_menu_Admin where menu_admin_id='"+Log_user+"') order by resp_group_name ");
		else
			thirdItem.add("select resp_group_id,resp_group_name from sm_resp_grp  where eff_status='E' order by resp_group_name  ");


		finAr.add(thirdItem);
		
		
		fourthItem.add("List");  		 //Type of item
		fourthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.RootMenu.label","common_labels"));	  // label
		fourthItem.add("root_menu_yn");	//name of field
		fourthItem.add("B," +com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",Y," +com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.yes.label","common_labels")+",N," +com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label","common_labels")+"");	// SIZE
		fourthItem.add("5");	//LENGTH

		finAr.add(fourthItem);//add to ArrayList obj finAr

		String tool_used=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eSM.ToolUsed.label","sm_labels");
		fifthItem.add("List");  		 //Type of item
		fifthItem.add(tool_used);	  // label
		fifthItem.add("dev_tool");	//name of field
		fifthItem.add("''," +com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+",F," +com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eSM.Forms.label","sm_labels")+",J,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eSM.Java.label","sm_labels")+"");	// SIZE
		fifthItem.add("5");	//LENGTH

		finAr.add(fifthItem);//add to ArrayList obj finAr
		String orderByCols[] = new String[3];
		String orderByColVals[] = new String[3];
		orderByCols[0] = menu_id;
		orderByCols[1] = menu_name;
		orderByCols[2] = tool_used;

		orderByColVals[0] = "menu_id";
		orderByColVals[1] = "menu_name";
		orderByColVals[2] = "dev_tool";

		strbuff = qrypg.getQueryPage(con,finAr,"Find Facility ","../../eSM/jsp/queryMenuHeader.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels") ,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,"Execute Query");

		out.println(strbuff.toString());
		strbuff.setLength(0);

		finAr.clear();
        firstItem.clear();
		secondItem.clear();
		thirdItem.clear();
		fourthItem.clear();
		fifthItem.clear();
		
		//closing resultsets and statements
		
		if(stmt != null) stmt.close();
		if(rset!=null) rset.close();
		
		
		} catch (Exception e) {}
		
		finally {
			ConnectionManager.returnConnection(con,request);
		}
%>
