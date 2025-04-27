<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 


<%String sStyle	=
     (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

      <html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link></head></html>
<%
    request.setCharacterEncoding("UTF-8");
	ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
	StringBuffer strbuff;
	Connection con=null;
	Statement stmt=null;
try {
	con = ConnectionManager.getConnection(request);
	String Log_user= (String) session.getValue("login_user");
	ResultSet rset=null ;
	int Medadmin=0;
	stmt=con.createStatement();
	String sql="select count(*)  from sm_menu_admin where menu_admin_id='"+Log_user+"' 	and to_char(sysdate,'dd/mm/yyyy')>= nvl(to_char(eff_date_from,'dd/mm/yyyy'),sysdate-1) and to_char(sysdate,'dd/mm/yyyy')<=nvl(to_char(eff_date_to,'dd/mm/yyyy'),sysdate+1) ";	

	rset=stmt.executeQuery(sql);
	if (rset !=null){
		while (rset.next()){
					Medadmin=Integer.parseInt(rset.getString(1));
		}
	}
	if(rset!=null)rset.close();
	if(stmt!=null)stmt.close();
	if (Medadmin >0 )  {}
	
	else			 {}

	ArrayList finAr = new ArrayList();

	ArrayList firstItem = new ArrayList();
	String resp_id=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ResponsibilityID.label","common_labels");
	firstItem.add("Text");  		 //Type of item
	firstItem.add(resp_id);	  // label
	firstItem.add("resp_id");	//name of field
	firstItem.add("20");	// SIZE
	firstItem.add("20");	//LENGTH

	finAr.add(firstItem);//add to ArrayList obj finAr

	ArrayList secondItem = new ArrayList();
    String resp_name=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ResponsibilityName.label","common_labels");
	secondItem.add("Text");  		 //Type of item
	secondItem.add(resp_name);	  // label
	secondItem.add("resp_name");	//name of field
	secondItem.add("30");	// SIZE
	secondItem.add("60");	//LENGTH
	
	finAr.add(secondItem);//add to ArrayList obj finAr

	ArrayList fifthItem = new ArrayList();
	String menu_id=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.MenuID.label","common_labels");
	fifthItem.add("Text");  		 //Type of item
	fifthItem.add(menu_id);	  // label
	fifthItem.add("menu_id");	//name of field
	fifthItem.add("30");	// SIZE
	fifthItem.add("30");	//LENGTH
	finAr.add(fifthItem);//add to ArrayList obj finAr


	ArrayList sixthItem = new ArrayList();
    String menu_name=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eSM.MenuName.label","sm_labels");
	sixthItem.add("Text");  		 //Type of item
	sixthItem.add(menu_name);	  // label
	sixthItem.add("menu_name");	//name of field
	sixthItem.add("60");	// SIZE
	sixthItem.add("60");	//LENGTH

	finAr.add(sixthItem);//add to ArrayList obj finAr

	ArrayList thirdItem = new ArrayList();

    String resp_grp_id=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eSM.ResponsibilityGroupID.label","sm_labels");
	thirdItem.add("Text");
	thirdItem.add(resp_grp_id);	  // label
	thirdItem.add("resp_group_id");	//name of field
	thirdItem.add("4");	// SIZE
	thirdItem.add("4");	//LENGTH


	finAr.add(thirdItem);

	ArrayList fourthItem = new ArrayList();
    String resp_grp_name=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eSM.ResponsibilityGroupName.label","sm_labels");
	fourthItem.add("Text");  		 //Type of item
	fourthItem.add(resp_grp_name);	  // label
	fourthItem.add("resp_grp_name");	//name of field
	fourthItem.add("30");	// SIZE
	fourthItem.add("30");	//LENGTH

	finAr.add(fourthItem);//add to ArrayList obj finAr


 ArrayList ninenthItem = new ArrayList();
 String desktop_code=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.user.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eSM.Desktop.label","sm_labels");
	ninenthItem.add("Text");  		 //Type of item
  ninenthItem.add(desktop_code);	  // label
	ninenthItem.add("desktop_code");	//name of field

	ninenthItem.add("30 ");	// SIZE
	ninenthItem.add("30 ");	// LENGTH
	finAr.add(ninenthItem);//add to ArrayList obj finAr



	ArrayList seventhItem = new ArrayList();

	seventhItem.add("List");  		 //Type of item
	seventhItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Role.label","common_labels"));	  // label
	seventhItem.add("role_id");	//name of field
	seventhItem.add("select  ORA_ROLE_ID,  ORA_ROLE_ID ora_role from sm_ora_role where ora_role_id not in ('MEDSTARTUP','MEDADMIN')");	// SIZE
//fifthItem.add("30");	//LENGTH

	finAr.add(seventhItem);//add to ArrayList obj finAr


	ArrayList eigthItem = new ArrayList();
	eigthItem.add("List");   //Type of item
	eigthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels"));  // label
	eigthItem.add("eff_status");//name
	eigthItem.add("B,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",E,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels")+",D,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels"));//static values that need to be displayed as option.Send it along with the value that is inserted.
	finAr.add(eigthItem); //add to ArrayList obj finAr


	String orderByCols[] = new String[7];
	String orderByColVals[] = new String[7];


	orderByCols[0] = resp_id;
	orderByCols[1] = resp_name;
	orderByCols[2] = menu_id;
	orderByCols[3] = menu_name;
	orderByCols[4] = resp_grp_id;
	orderByCols[5] = resp_grp_name;
	orderByCols[6] = desktop_code;

	orderByColVals[0] = "a.resp_id";
	orderByColVals[1] = "a.resp_name";
	orderByColVals[2] = "b.menu_id";
	orderByColVals[3]="b.menu_name";
	orderByColVals[4]="a.resp_group_id";
	orderByColVals[5]="c.RESP_GROUP_NAME";
	orderByColVals[6]="a.desktop_code";

	strbuff = qrypg.getQueryPage(con,finAr,"Find Responsibility ","../jsp/ResponsibilityQuery.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels") ,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,"Execute Query");
	out.println(strbuff.toString());
	finAr.clear();
	firstItem.clear();
	secondItem.clear();
	thirdItem.clear();
	fourthItem.clear();
	fifthItem.clear();
	sixthItem.clear();
	seventhItem.clear();
	eigthItem.clear();
	ninenthItem.clear();

	if(stmt!=null) stmt.close();
	} catch (Exception e) {}
	finally
	{
		
		ConnectionManager.returnConnection(con,request);
	}
%>
