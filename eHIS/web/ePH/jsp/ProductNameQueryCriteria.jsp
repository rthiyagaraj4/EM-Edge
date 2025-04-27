<!DOCTYPE html>
<!-- Created on 05 Aug 2009 =====Shyampriya==== -->

<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="webbeans.eCommon.*,java.sql.*,ePH.*, ePH.Common.*,eCommon.Common.*,java.util.*,java.text.SimpleDateFormat" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- Mandatory declarations end --%>

<%
	request.setCharacterEncoding("UTF-8");

	String sStyle	=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<HTML>
		<HEAD>
			<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		</HEAD>
	</HTML>
<%
	try{
			ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
			StringBuffer strbuff;
			ArrayList finAr = new ArrayList(); //Final Array
			ArrayList firstItem = new ArrayList();
			ArrayList secondItem = new ArrayList();
			ArrayList thirdItem = new ArrayList();
			ArrayList fourthItem = new ArrayList();
			ArrayList fifthItem = new ArrayList();

			// First item

			String product_code = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.ProductNameCode.label","ph_labels");
			firstItem.add("Text");  	//Type of item
			firstItem.add(product_code);		// label
			firstItem.add("product_code"); //name of field
			firstItem.add("6");		// SIZE
			firstItem.add("6");		// LENGTH
			finAr.add(firstItem);

			// Second Item

			String long_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.longdescription.label","common_labels");
			secondItem.add("Text");  	//Type of item
			secondItem.add(long_desc);		// label
			secondItem.add("long_desc"); //name of field
			secondItem.add("60");		// SIZE
			secondItem.add("60");		// LENGTH
			finAr.add(secondItem);

			// Third Item

			String short_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.shortdescription.label","common_labels");
			thirdItem.add("Text");  	//Type of item
			thirdItem.add(short_desc);		// label
			thirdItem.add("short_desc"); //name of field
			thirdItem.add("30");		// SIZE
			thirdItem.add("30");		// LENGTH
			finAr.add(thirdItem);

			// Fourth Item

			String admixture_type = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.AdmixtureType.label","ph_labels");
			String adm_type=" ,--"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+ "--,A,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.all.label","common_labels")+",CR,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.CompoundRx.label","ph_labels")+",IV,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.IVRx.label","ph_labels")+",OA,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.OncologyAdmixture.label","ph_labels");
			fourthItem.add("List");  //Type of item
			fourthItem.add(admixture_type);  // label
			fourthItem.add("admixture_type");   //name of field
			fourthItem.add(adm_type);//static values that need to be displayed as option.Send it along with the value that is inserted.
			fourthItem.add("7");	//LENGTH
			finAr.add(fourthItem);

			// Fifth Item

			ArrayList items=new ArrayList();
			String Nature = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels");
			String Both_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels");
			String Enabled_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels");
			String Disabled_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels");
			String Nature_List="%,"+Both_legend+",E,"+Enabled_legend+",D,"+Disabled_legend;
			fifthItem.add("List");  //Type of item
			fifthItem.add(Nature);  // label
			fifthItem.add("eff_status");  //name of field
			fifthItem.add(Nature_List);  // SIZE
			fifthItem.add("1");	      // LENGTH
			finAr.add(fifthItem);

			String orderByCols[] = new String[4];
			String orderByColVals[] = new String[4];

			orderByCols[0] = product_code;
			orderByCols[1] = long_desc;
			orderByCols[2] = short_desc;
			orderByCols[3]	 = admixture_type;

			orderByColVals[0] ="product_code";
			orderByColVals[1] = "long_desc";
			orderByColVals[2] = "short_desc";
			orderByColVals[3] = "admixture_type";

			String Sort_order = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels");
			String defaultSelect = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
			String orderBy=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels");
			String QueryCriteria=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels");
			String ExecuteQuery=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels");

			strbuff = qrypg.getQueryPage(null,finAr,product_code,"ProductNameQueryResult.jsp",Sort_order,QueryCriteria,defaultSelect,orderBy,orderByCols,orderByColVals,ExecuteQuery,true);
	
			out.println(strbuff.toString());
		}
			catch (java.lang.Exception exception)
			{
				out.println(exception.toString());
			}
%>
