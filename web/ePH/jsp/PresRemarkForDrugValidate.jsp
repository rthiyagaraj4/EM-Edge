<%@page contentType="text/html;charset=UTF-8"
	import="java.sql.*,java.util.*,java.io.*,ePH.Common.*,ePH.*"%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%>
<%-- Mandatory declarations end --%>
<jsp:useBean id="xmlObj" scope="page"
	class="webbeans.eCommon.XMLStringParser" />
<%
	try{
		request.setCharacterEncoding("UTF-8");
		String locale = (String) session.getAttribute("LOCALE");
		Hashtable hash = (Hashtable) xmlObj.parseXMLString(request);
		hash = (Hashtable) hash.get("SEARCH");
		String bean_id = (String) hash.get("bean_id");
		String bean_name = (String) hash.get("bean_name");
		String func_mode = request.getParameter("func_mode");
		PresRemarkForDrugBean bean = (PresRemarkForDrugBean) getBeanObject(bean_id, bean_name, request);
		String selected_yn = (String) request.getParameter("selected");
		String remarks_code = request.getParameter("remarks_code");
		String defaultselected = (String) request.getParameter("defaultselected");
		String db_action = request.getParameter("dbAction");
		String remarks_Count = (String) request.getParameter("remarkscnt");
		int cnt1 = 0;
		int dfltRmIndex = 0;
		String route_color="", fntColor="", backgrndColor="";// added for CRF RUT-CRF-0034.1[IN:037389]
		ArrayList remarksSearchResult = null;
		ArrayList remarksInsertList = null;
		int count = 0;
		int indesx = 0;
		String drug_type_code = (String) request.getParameter("drug_type_code");
		if (func_mode != null && func_mode.equals("remarksCodeSearch")) {
			String drug_code = request.getParameter("drug_code") == null ? "": request.getParameter("drug_code");
			String formArray[] = null;
			formArray = bean.getFormDesc(drug_code, locale);
			out.println("formValues('" + formArray[0] + "','"+ formArray[1] + "');");
			ArrayList routeList = bean.getRouteDesc(formArray[1], locale);
			String defaultRouteCode = bean.getDefaultRouteCode();
			out.println("loadIntoLocationAll() ; ");
			for (int i = 0; i < routeList.size(); i+=3) {
				route_color=(String) routeList.get(i+2);// added for CRF RUT-CRF-0034.1[IN:037389]-start
				if(route_color!= null && !route_color.equals("")){
					if(route_color.length()==12){
						fntColor= route_color.substring(0, 6);
						backgrndColor= route_color.substring(6, 12);
					}
				}// added for CRF RUT-CRF-0034.1[IN:037389]-end
				out.println("loadIntoLocation(\""+ (String) routeList.get(i) + "\",\""+ (String) routeList.get(i+1) + "\",\""+ fntColor + "\",\""+ backgrndColor + "\",\""+ defaultRouteCode + "\") ; ");
			}
		}
		else if (func_mode != null&& func_mode.equals("PrescriptionRemarksCheck")) {
			remarksSearchResult = bean.getRemarksSearchList();
			remarksInsertList = bean.getremarksInsertList();
			String temp_pres_type = "";
			int cntStart = Integer.parseInt(remarks_Count)*9;
			int cntEnd = cntStart+9;
			count = 0;
			if (!remarks_code.equals("")) {
				while ((remarksSearchResult != null)&& (count < remarksSearchResult.size())) {
					temp_pres_type = (String) remarksSearchResult.get(count + 1);
					if (remarks_code.equals(temp_pres_type)) {
						if (selected_yn.equals("Y")) {
							remarksSearchResult.set(count + 5, "E");
							remarksSearchResult.set(count + 6, db_action);
						} 
						else {
							remarksSearchResult.set(count + 5, "D");
							remarksSearchResult.set(count + 6, db_action);
						}
					}
					count += 9;
					bean.setRemarksSearchList(remarksSearchResult);
				}
				int rmrksCode = cntStart + 1;
				int rmIndex = 0;
				String rmCode = (String) remarksSearchResult.get(rmrksCode);
				if (remarksInsertList.contains(rmCode)) {
					rmIndex = remarksInsertList.indexOf(rmCode);
					remarksInsertList.set(rmIndex + 4, remarksSearchResult.get(cntStart +5).toString());
					remarksInsertList.set(rmIndex + 5, remarksSearchResult.get(cntStart +6).toString());
				} 
				else {
					while (cntStart < cntEnd - 2) {
						remarksInsertList.add(remarksSearchResult.get(cntStart++));
					}
				}
				count = 0;
				while (count < remarksSearchResult.size()) {
					if (remarksSearchResult.get(count + 6).toString().equalsIgnoreCase("U")) {
						if (remarksInsertList.contains(remarksSearchResult.get(count + 1))) {
							dfltRmIndex = remarksInsertList.indexOf(remarksSearchResult.get(count + 1));
							remarksInsertList.set(dfltRmIndex + 4,remarksSearchResult.get(count + 5).toString());
							count += 9;
						}
						else {
							remarksInsertList.add(remarksSearchResult.get(count++));
							remarksInsertList.add(remarksSearchResult.get(count++));
							remarksInsertList.add(remarksSearchResult.get(count++));
							remarksInsertList.add(remarksSearchResult.get(count++));
							remarksInsertList.add(remarksSearchResult.get(count++));
							remarksInsertList.add(remarksSearchResult.get(count++));
							remarksInsertList.add(remarksSearchResult.get(count++));
							count+=2;
						}
					}
					else {
						count += 9;
					}
				}
				bean.setRemarksSearchList(remarksSearchResult);
				bean.setRemarksInsertList(remarksInsertList);
			}
		}
		else if (func_mode != null && func_mode.equals("DefaultRemarkCheck")) {
			remarksSearchResult = bean.getRemarksSearchList();
			remarksInsertList = bean.getremarksInsertList();
			int remarksCnt_start = Integer.parseInt(remarks_Count) *9;
			int remarksCnt_end = remarksCnt_start+9;
			String temp_remark_type = "";
			count = 0;
			cnt1 = 0;
			if (!remarks_code.equals("")) {
				while ((remarksSearchResult != null)&& (count < remarksSearchResult.size())) {
					if (defaultselected.equalsIgnoreCase("Y")&& !(remarksSearchResult.get(count + 1).toString().equalsIgnoreCase(remarks_code))) {
						remarksSearchResult.set(count + 4, "N");
					} 
					else {
						remarksSearchResult.set(count + 4, "Y");
					}
					if (defaultselected.equalsIgnoreCase("N")) {
						remarksSearchResult.set(count + 4, "N");
					}
					count += 9;
					bean.setRemarksSearchList(remarksSearchResult);
				}
				String remCode = (String) remarksSearchResult.get(remarksCnt_start + 1);
				if (remarksInsertList.contains(remCode)) {
					dfltRmIndex = remarksInsertList.indexOf(remCode);
					remarksInsertList.set(dfltRmIndex + 3,remarksSearchResult.get(remarksCnt_start + 4));
				} 
				else {
					while ((remarksCnt_start < remarksCnt_end - 2)) {
						remarksInsertList.add(remarksSearchResult.get(remarksCnt_start++));
					}
				}
				count = 0;
				while (count < remarksSearchResult.size()) {
					if (remarksSearchResult.get(count + 6).toString().equalsIgnoreCase("U")) {
						if (remarksInsertList.contains(remarksSearchResult.get(count + 1))) {
							dfltRmIndex = remarksInsertList.indexOf(remarksSearchResult.get(count + 1));
							remarksInsertList.set(dfltRmIndex + 3,remarksSearchResult.get(count + 4).toString());
							count += 9;
						} 
						else {
							remarksInsertList.add(remarksSearchResult.get(count++));
							remarksInsertList.add(remarksSearchResult.get(count++));
							remarksInsertList.add(remarksSearchResult.get(count++));
							remarksInsertList.add(remarksSearchResult.get(count++));
							remarksInsertList.add(remarksSearchResult.get(count++));
							remarksInsertList.add(remarksSearchResult.get(count++));
							remarksInsertList.add(remarksSearchResult.get(count++));
							count+=2;
						}
					}
					else {
						count += 9;
					}
				}
				count = 0;
				while (count < remarksInsertList.size()) {
					if (!(remarksInsertList.get(count + 1).toString().equalsIgnoreCase(remCode)))
						remarksInsertList.set(count + 4, "N");
					count += 7;
				}
			}
			bean.setRemarksSearchList(remarksSearchResult);
			bean.setRemarksInsertList(remarksInsertList);
		}
		else{
			count = 0;
			int delCnt = 0;
			remarksInsertList = bean.getremarksInsertList();
			while (count < remarksInsertList.size()) {
				delCnt = count;
				if ((remarksInsertList.get(count + 4).toString().equalsIgnoreCase("N"))&& (remarksInsertList.get(count + 5).toString()).equalsIgnoreCase("D")&& (remarksInsertList.get(count + 6).toString().equalsIgnoreCase("I"))) {
					remarksInsertList.remove(delCnt);
					count++;
					remarksInsertList.remove(delCnt);
					count++;
					remarksInsertList.remove(delCnt);
					count++;
					remarksInsertList.remove(delCnt);
					count++;
					remarksInsertList.remove(delCnt);
					count++;
					remarksInsertList.remove(delCnt);
					count++;
					remarksInsertList.remove(delCnt);
					count++;
				}
				else {
					count += 7;
				}
			}
			bean.setRemarksInsertList(remarksInsertList);
		}
		putObjectInBean(bean_id, bean, request);
	}
	catch(Exception e){
		e.printStackTrace();
	}
%>
