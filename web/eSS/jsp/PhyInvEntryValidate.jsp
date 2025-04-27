<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page import="java.util.*, eSS.Common.*, eSS.* "%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>
<%
	String bean_id			= request.getParameter("bean_id");
	String bean_name		= request.getParameter("bean_name");
	int functionType		= Integer.parseInt(request.getParameter("function_type"));
	if ((bean_id == null) || (bean_id.equals("")))
		return;

	PhyInvEntryBean bean	= (PhyInvEntryBean)getBeanObject(bean_id, bean_name,request );
	Hashtable hash			= (Hashtable) XMLobj.parseXMLString(request);
    hash = (Hashtable) hash.get ("SEARCH");
	switch (functionType) {
	case 1: // case - 1 will be executed on focus lost of Store Code
		{
				
				String store_code = bean.getStore_code();
				
				if (store_code.trim().equals("")) {
					out.println("errorDisplay();");
					return;
				}
				bean.setStore_code(store_code);
				out.println("clearListItems('parent.PhyInvEntryDetailFrame.document.formPhyInvEntryDetail.bin_location_code'); ");
				ArrayList binLocation = bean.getBinLocationData(store_code);
				
				for(int i=0; i< binLocation.size(); i++) {
					String[] record = (String[])binLocation.get(i);
					out.println("addListItem(\"parent.PhyInvEntryDetailFrame.document.formPhyInvEntryDetail.bin_location_code\", \"" + record[0] + "\",\"" + record[1] + "\"); ");
				}
			}
		break;
	case 2 :
		{
			String phy_inv_id = (String) hash.get("phy_inv_id");
			if (phy_inv_id == null) {
				return;
			}
			bean.setPhy_inv_id(phy_inv_id);
			boolean isValidPhyInvID = bean.isValidPhyInvID();
			if (isValidPhyInvID) {
				out.println("setCountSheetDate('"+bean.getCount_sheet_date()+"');");
			}
			out.println("assignResult("+isValidPhyInvID+",\"\", \"0\");");
		}
		break;
	case 3 :
		{
			String store_code = (String) hash.get("owner_store_code");
			String phy_inv_id = (String) hash.get("phy_inv_id");
			String curr_store_code = (String) hash.get("current_store_code");
			bean.setStore_code(store_code);
			bean.setPhy_inv_id(phy_inv_id);
			bean.setCurr_store_code(curr_store_code);
			boolean isValidPhyInvRecord = bean.isValidPhyInvRecord();
			out.println("assignResult("+isValidPhyInvRecord+",\"\", \"0\");");
		}
		break;
	case 4:
		//Update the bean values
		{
			java.util.HashMap hmResult= bean.updateTrayDetails(hash);
			boolean result = ((Boolean)hmResult.get("result")).booleanValue();
			String message = (String)hmResult.get("msgid");
			String flag = (String)hmResult.get("flag");
			out.println("assignResult(" + result + ", \"" + message + "\", \""+flag+"\" ) ; ") ;
		}
		break;
	case 5: // Validate Tray No
		{
				String store_code = (String) hash.get("owner_store_code");
				String group_code = (String) hash.get("group_code");
				String tray_no = (String) hash.get("tray_no");
				String current_store_code = (String) hash.get("current_store_code");
				String phy_inv_id = (String) hash.get("phy_inv_id");
				boolean isValidTrayNo = bean.trayNoExists(store_code,group_code,tray_no,current_store_code,phy_inv_id);
				if (isValidTrayNo && (!store_code.equals(current_store_code))) {
					out.println("setBinLocation('"+bean.getTemp_bin_location()+"');");
				}
				out.println("assignResult("+isValidTrayNo+",\"\", \"0\");");
				if (!isValidTrayNo) {
					return;
				}

		}
		break;
	case 6:
		//Update the selected tray values
		{
			bean.updateSelectedTrays(hash);
		}
		break;		
	default :
		out.println("alert(\'Invalid Function\');");
		return;
	}

putObjectInBean(bean_id,bean,request);
%>
