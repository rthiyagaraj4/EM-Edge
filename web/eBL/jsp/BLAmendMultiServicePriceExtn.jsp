<!DOCTYPE html>
	<%
		String parvalues=request.getParameter("parvalues");
		String[] arrParValues = parvalues.split("~");
		int tableIndex = Integer.parseInt(request.getParameter("tableIndex"));
		String mode = request.getParameter("mode");
		System.err.println("parvalues:"+parvalues);
		System.err.println("arrParValues:"+arrParValues);
		System.err.println("tableIndex:"+tableIndex);
		System.err.println("mode:"+mode);
		if("modify".equals(mode))
		{
	%>

	<input type='hidden' name='priceindbot<%=tableIndex%>' id='priceindbot<%=tableIndex%>' id='priceindbot<%=tableIndex%>' value='<%=arrParValues[0]%>'>
	<input type='hidden' name='effFrmDate<%=tableIndex%>' id='effFrmDate<%=tableIndex%>' id='effFrmDate<%=tableIndex%>' value='<%=arrParValues[1]%>'>
	<input type='hidden' name='efftodate<%=tableIndex%>' id='efftodate<%=tableIndex%>' id='efftodate<%=tableIndex%>' value='<%=arrParValues[2]%>'>
	<input type='hidden' name='discPerip<%=tableIndex%>' id='discPerip<%=tableIndex%>' id='discPerip<%=tableIndex%>' value='<%=arrParValues[3]%>'>
	<input type='hidden' name='discPerop<%=tableIndex%>' id='discPerop<%=tableIndex%>' id='discPerop<%=tableIndex%>' value='<%=arrParValues[4]%>'>
	<input type='hidden' name='discPerem<%=tableIndex%>' id='discPerem<%=tableIndex%>' id='discPerem<%=tableIndex%>' value='<%=arrParValues[5]%>'>
	<input type='hidden' name='discPerex<%=tableIndex%>' id='discPerex<%=tableIndex%>' id='discPerex<%=tableIndex%>' value='<%=arrParValues[6]%>'>
	<input type='hidden' name='discPerdc<%=tableIndex%>' id='discPerdc<%=tableIndex%>' id='discPerdc<%=tableIndex%>' value='<%=arrParValues[7]%>'>
	<input type='hidden' name='Applicability<%=tableIndex%>' id='Applicability<%=tableIndex%>' id='Applicability<%=tableIndex%>' value='<%=arrParValues[8]%>'>
	<input type='hidden' name='baseqty<%=tableIndex%>' id='baseqty<%=tableIndex%>' id='baseqty<%=tableIndex%>' value='<%=arrParValues[9]%>'>
	<input type='hidden' name='publicchk<%=tableIndex%>' id='publicchk<%=tableIndex%>' id='publicchk<%=tableIndex%>' value='<%=arrParValues[10]%>'>
	<input type='hidden' name='rate_Basis_Ind<%=tableIndex%>' id='rate_Basis_Ind<%=tableIndex%>' id='rate_Basis_Ind<%=tableIndex%>' value='<%=arrParValues[11]%>'>
	<input type='hidden' name='mincharge<%=tableIndex%>' id='mincharge<%=tableIndex%>' id='mincharge<%=tableIndex%>' value='<%=arrParValues[12]%>'>
	<input type='hidden' name='maxcharge<%=tableIndex%>' id='maxcharge<%=tableIndex%>' id='maxcharge<%=tableIndex%>' value='<%=arrParValues[13]%>'>
	<input type='hidden' name='checkcostavl<%=tableIndex%>' id='checkcostavl<%=tableIndex%>' id='checkcostavl<%=tableIndex%>' value='<%=arrParValues[14]%>'>
	<input type='hidden' name='costind<%=tableIndex%>' id='costind<%=tableIndex%>' id='costind<%=tableIndex%>' value='<%=arrParValues[15]%>'>
	<input type='hidden' name='costamt<%=tableIndex%>' id='costamt<%=tableIndex%>' id='costamt<%=tableIndex%>' value='<%=arrParValues[16]%>'>
	<input type='hidden' name='applydiscount<%=tableIndex%>' id='applydiscount<%=tableIndex%>' id='applydiscount<%=tableIndex%>' value='<%=arrParValues[17]%>'>

	<input type='hidden' name='discString<%=tableIndex%>' id='discString<%=tableIndex%>' id='discString<%=tableIndex%>' value=''>
	<input type='hidden' name='discDtls<%=tableIndex%>' id='discDtls<%=tableIndex%>' id='discDtls<%=tableIndex%>' value=''>
	<input type='hidden' name='billingclass<%=tableIndex%>' id='billingclass<%=tableIndex%>' id='billingclass<%=tableIndex%>' value='<%=arrParValues[18]%>'>
	<input type='hidden' name='billingdesc<%=tableIndex%>' id='billingdesc<%=tableIndex%>' id='billingdesc<%=tableIndex%>' value=''>
<%
		} else {
%>
	<input type='hidden' name='discString<%=tableIndex%>' id='discString<%=tableIndex%>' id='discString<%=tableIndex%>' value=''>			
	<input type='hidden' name='discDtls<%=tableIndex%>' id='discDtls<%=tableIndex%>' id='discDtls<%=tableIndex%>' value=''>
	<input type='hidden' name='applydiscount<%=tableIndex%>' id='applydiscount<%=tableIndex%>' id='applydiscount<%=tableIndex%>' value='N'>
	<input type='hidden' name='billingclass<%=tableIndex%>' id='billingclass<%=tableIndex%>' id='billingclass<%=tableIndex%>' value=''>
	<input type='hidden' name='billingdesc<%=tableIndex%>' id='billingdesc<%=tableIndex%>' id='billingdesc<%=tableIndex%>' value=''>
	<input type='hidden' name='priceindbot<%=tableIndex%>' id='priceindbot<%=tableIndex%>' id='priceindbot<%=tableIndex%>' value=''>
	<input type='hidden' name='effFrmDate<%=tableIndex%>' id='effFrmDate<%=tableIndex%>' id='effFrmDate<%=tableIndex%>' value=''>
	<input type='hidden' name='efftodate<%=tableIndex%>' id='efftodate<%=tableIndex%>' id='efftodate<%=tableIndex%>' value=''>
	<input type='hidden' name='discPerip<%=tableIndex%>' id='discPerip<%=tableIndex%>' id='discPerip<%=tableIndex%>' value=''>
	<input type='hidden' name='discPerop<%=tableIndex%>' id='discPerop<%=tableIndex%>' id='discPerop<%=tableIndex%>' value=''>
	<input type='hidden' name='discPerem<%=tableIndex%>' id='discPerem<%=tableIndex%>' id='discPerem<%=tableIndex%>' value=''>
	<input type='hidden' name='discPerex<%=tableIndex%>' id='discPerex<%=tableIndex%>' id='discPerex<%=tableIndex%>' value=''>
	<input type='hidden' name='discPerdc<%=tableIndex%>' id='discPerdc<%=tableIndex%>' id='discPerdc<%=tableIndex%>' value=''>
	<input type='hidden' name='Applicability<%=tableIndex%>' id='Applicability<%=tableIndex%>' id='Applicability<%=tableIndex%>' value=''>
	<input type='hidden' name='baseqty<%=tableIndex%>' id='baseqty<%=tableIndex%>' id='baseqty<%=tableIndex%>' value=''>
	<input type='hidden' name='publicchk<%=tableIndex%>' id='publicchk<%=tableIndex%>' id='publicchk<%=tableIndex%>' value='N'>
	<input type='hidden' name='mincharge<%=tableIndex%>' id='mincharge<%=tableIndex%>' id='mincharge<%=tableIndex%>' value=''>
	<input type='hidden' name='maxcharge<%=tableIndex%>' id='maxcharge<%=tableIndex%>' id='maxcharge<%=tableIndex%>' value=''>
	<input type='hidden' name='checkcostavl<%=tableIndex%>' id='checkcostavl<%=tableIndex%>' id='checkcostavl<%=tableIndex%>' value=''>
	<input type='hidden' name='costind<%=tableIndex%>' id='costind<%=tableIndex%>' id='costind<%=tableIndex%>' value=''>
	<input type='hidden' name='costamt<%=tableIndex%>' id='costamt<%=tableIndex%>' id='costamt<%=tableIndex%>' value=''>
	<input type='hidden' name='rate_Basis_Ind<%=tableIndex%>' id='rate_Basis_Ind<%=tableIndex%>' id='rate_Basis_Ind<%=tableIndex%>' value=''>	
<%
		}
%>		
			

