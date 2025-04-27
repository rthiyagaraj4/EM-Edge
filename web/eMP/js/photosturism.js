		var r=0;
		var r1=0;
		
		var no=0;
		var one=0;
		var two=0;
		var three;
		var four;
		
		var u13;
		var u14;
		var hddn;
				
		
		var sex=new Array();
		
		function test() {

		u8=parent.frames[2].document.forms[0].oneu.value;
		one=parseInt(u8,10);
		
		
		 u9=parent.frames[2].document.forms[0].twou.value;
		 two=parseInt(u9,10);
		 
		u10=parent.frames[2].document.forms[0].threeu.value;
		three=parseInt(u10,10);
		
		u11=parent.frames[2].document.forms[0].fouru.value;
		four=parseInt(u11,10);

		u12=parent.frames[2].document.forms[0].zval.value;
		//u13=parent.frames[2].document.forms[0].p_det.value;	
		u14=parent.frames[2].document.forms[0].p_id.value;
		hddn=parent.frames[2].document.forms[0].hiddenid.value;
		
		
	
		var u=new Array(eval(u12));
		var n=new Array(eval(u12));
		var y=u.length;
			
			
	
		for(var s=0;s<y;s++){
			var d="h"+s;
			var d1="p"+s;
			var d2="k"+s;
		/*	u[s]=parent.frames[2].document.all[d].value;
			n[s]=parent.frames[2].document.all[d1].value;
			sex[s]=parent.frames[2].document.all[d2].value; */
			u[s]=parent.f_query_add_mod.document.getElementById(d).value;
			n[s]=parent.f_query_add_mod.document.getElementById(d1).value;
			sex[s]=parent.f_query_add_mod.document.getElementById(d2).value;
				
		}
		
		var str="True";

			
	foldersTree =gFld(u[no],"../../eMP/jsp/ViewPatDetailsMain.jsp?Patient_ID="+n[no]+"&image="+str+"&root="+u14)
	
	no++;
	
	for(var i=0;i<two;i++) {
		if(three > 0)  aux1 = insFld(foldersTree, gFld(u[no],"../../eMP/jsp/ViewPatDetailsMain.jsp?Patient_ID="+n[no]+"&image="+str+"&root="+u14))
		else  insDoc(foldersTree, gLnk(2, u[no], "../../eMP/jsp/ViewPatDetailsMain.jsp?Patient_ID="+n[no]+"&image="+str+"&root="+u14))
		no++;		
		if(four !=0) {
			for(var j=0;j<three;j++) {
				insDoc(aux1, gLnk(2, u[no], "../../eMP/jsp/ViewPatDetailsMain.jsp?Patient_ID="+n[no]+"&image="+str+"&root="+u14))			
				no++;				
			}	
		}	
	}
	if(four==0) { 
		for(var j=1;j<three;j++) {
			insDoc(foldersTree, gLnk(2, u[no], "../../eMP/jsp/ViewPatDetailsMain.jsp?Patient_ID="+n[no]+"&image="+str+"&root="+u14))			
			no++;
		}	
	}
	else {
		for(var k=0;k<four;k++) {
			insDoc(foldersTree, gLnk(2, u[no], "../../eMP/jsp/ViewPatDetailsMain.jsp?Patient_ID="+n[no]+"&image="+str+"&root="+u14))			
			no++;
		}
	}	

	
	
	/*
	var g=new Number();

	r2=parseInt(u9);
	
	if(u9>0){
	if(!(u10>0)){
	for(i=0;i<u9;i++){
	//aux1 = insFld(foldersTree, gFld(u[2], "../jsp/ViewPatDetailsMain.jsp?Patient_ID="+u[2]))
	
	insDoc(foldersTree, gLnk(2, u[2], "../jsp/ViewPatDetailsMain.jsp?Patient_ID="+n[2]+"&image="+str+"&root="+n[2]))
	u[2]=u[3];
	n[2]=n[3];
	}
	r1=r2;
	}
	else{
	var t=r2+1;
	for(i=0;i<u9;i++){
	aux1 = insFld(foldersTree, gFld(u[t], "../jsp/ViewPatDetailsMain.jsp?Patient_ID="+n[t]+"&image="+str+"&root="+n[2]))
	t++;
	}
	}
}	
	if(u10>0){
	r1=r2+2; 
	var e1=parseInt(r1);
	for(j=0;j<u10;j++){
	//var i = new Number();
	//aux2 = insFld(aux1, gFld(u[e1],  "../jsp/ViewPatDetailsMain.jsp?Patient_ID="+u[e1]))
	insDoc(aux1, gLnk(2, u[e1], "../jsp/ViewPatDetailsMain.jsp?Patient_ID="+n[e1]+"&image="+str+"&root="+n[2]))

	//u[3]=u[4];
	e1++;
	}
	}
	
	if(u11>0){
	//if(u11==1) r=r1+1;
	//else
	r=r1+1;
	
	for(h=0;h<u11;h++){
	//var m="u"+h;
	//var n=eval(m);
	//aux1 = insFld(foldersTree, gFld(u[r],  "../jsp/ViewPatDetailsMain.jsp?Patient_ID="+u[r]))  
	insDoc(foldersTree, gLnk(2, u[r], "../jsp/ViewPatDetailsMain.jsp?Patient_ID="+n[r]+"&image="+str+"&root="+n[2]))
	r++;
	}
	} */
	
	
    initializeDocument();
	}    
