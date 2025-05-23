/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
(function() {
    var flag=false;
    var tbl=new Array();
    this.ge$=function(d) {return document.getElementById(d);}
    this.scrollHeader = function(evt) {
        if(flag) {
            return;
        }
        var e=evt?evt:window.event;
        var t=e.target?e.target:e.srcElement;
	if (t.nodeType == 3) {
            t = t.parentNode;
        }
        var tid=t.id.replace(':scroller','');
        var fh=ge$(tid+':scroller:fx');
        var sd=ge$(tid+':scroller');
        fh.style.left=(0-sd.scrollLeft)+'px';
        var cf=ge$(tid+'_CFB');
        if(cf) {
            var dmt=parseInt(cf.getAttribute('dmt'));
            cf.style.marginTop=(0-(sd.scrollTop+dmt))+'px';
        }
    };
    function gbw() {
        return document.body.offsetWidth?document.body.offsetWidth:window.innerWidth;
    }
	/*Added By Dharma for clone id/name. This Id/Name should be used in js*/
	 function changeIds(d) {
		
        if(d.id) {
			d.id=d.id + "-clone";
        }
		if(d.name){
			d.name=d.name + "-clone";
		}
        var c=d.childNodes;
        if(c) {
            for(var i=0;i<c.length;i++) {
                changeIds(c[i]);
            }
        }
    }

    function addScrollerDivs(tid,noOfCols) {
	    if(ge$(tid+':scroller')) {
            return;
        }
        var tb=ge$(tid);
        var tb2=tb.parentNode;
        var ns=tb.nextSibling;
        var sd=document.createElement("div");
        sd.id=tid+':scroller';
        sd.style.cssText = 'height:auto;overflow-x:auto;overflow-y:auto;width:auto;';
        sd.onscroll=scrollHeader;
        sd.appendChild(tb);
        var sd2=document.createElement("div");
        sd2.id=tid+':scroller:fx:OuterDiv';
        sd2.style.cssText='position:relative;width:auto;overflow:hidden;overflow-x:hidden;padding:0px;margin:0px;';
        sd2.innerHTML='<div id="' + tid + ':scroller:fx" style="text-align:left;position:relative;width:auto;padding:0px;margin-left:0px;"></div>';
        var fc=null;
        if(noOfCols > 0) {
            fc=document.createElement("div");
            fc.id=tid+':scroller:fxcol';
            fc.style.cssText='width:0px;height:auto;display:block;float:left;overflow:hidden;';
            fc.innerHTML = "<div id='" + tid +":scroller:fxCH' style='width:100%;overflow:hidden;'>&nbsp;</div><div id='" + tid +":scroller:fxCB' style='width:100%;overflow:hidden;'>&nbsp;</div>";
        }
        if(ns) {
            if(fc) tb2.insertBefore(fc, ns);
            tb2.insertBefore(sd2, ns);
            tb2.insertBefore(sd, ns);
        }else {
            if(fc) tb2.appendChild(fc);
            tb2.appendChild(sd2);
            tb2.appendChild(sd);
        }
    }

    this.fxheader = function() {
        if(flag) {return;}
        flag=true;
        var perUsed=false;
        for(var i=0;i<tbl.length;i++) {
            var tbDiv=ge$(tbl[i].tid);
            var w=tbl[i].swidth+'';

		/*Added By Dharma for freezing header style Start*/
		ge$(tbl[i].tid+':scroller:fx:OuterDiv').scrollLeft	= 0;
		ge$(tbl[i].tid+':scroller').scrollLeft	= 0;
		/*Added By Dharma for freezing header style End*/
            if(w.indexOf('%')>=0) {
                perUsed=true;
                var ttt=ge$(tbl[i].tid+':scroller:fx');
                ttt.style.width='0px';
                var twi=parseInt(w);
                w=(gbw()*twi/100);
                ttt.style.width='9999px';
            }
            //if ie6/7 then allow for 18px scrollbar area
            tbDiv.style.width=(parseInt(w-18))+'px';
            var fh=ge$(tbl[i].tid + ':scroller:fx');
            fh.style.marginLeft='0px';
            fh.style.display='';
            var cn=fh.childNodes;
            var j;
            for(j=0;j<cn.length;j++) {
                fh.removeChild(cn[j]);
            }
            var t=tbDiv.cloneNode(false);
            t.id=tbl[i].tid+'__cN';
            if(document.all) {
            	t.style.width=tbDiv.offsetWidth+'px';
            }else {
            	t.style.width='auto';
            }
            t.style.marginTop='0px';
            t.style.marginLeft='0px';
            var th=document.createElement("thead");
            th.style.padding='0px';
            th.style.margin='0px';
            for(j=0;j<tbl[i].noOfRows;j++) {
                var r=tbDiv.rows[j].cloneNode(true);
                th.appendChild(r);
            }
            t.appendChild(th);
            fh.appendChild(t);
            var t2;
            if(tbl[i].noOfCols > 0) {
                t2=t.cloneNode(true);
                t2.id=tbl[i].tid + '_CFH';
            }
            //adjusting widths
            var tHeight=0;
            for(j=0;j<tbl[i].noOfRows;j++) {
                //var c=ge$(tbl[i].tid+'__cN').rows[j].cells;
                var c=t.rows[j].cells;
                var c2;
                var oc=tbDiv.rows[j].cells;
                var q;
                if(t2) {
                    c2=t2.rows[j].cells;
                    for(q=0;q<c.length;q++) {
                        c[q].style.width=c2[q].style.width=(oc[q].offsetWidth-3) + 'px';
                    }
                }else {
                    for(q=0;q<c.length;q++) {
                        c[q].style.width=(oc[q].offsetWidth-3) + 'px';
                    }
                }
                tHeight+=tbDiv.rows[j].offsetHeight;
            }
            tbDiv.style.marginTop = "-" + tHeight + "px";
            var h=tbl[i].sheight;
            if(tbDiv.offsetHeight < h) {
                h=tbDiv.offsetHeight+18;
            }
            var cw=0;
            //Column freezing
            if(tbl[i].noOfCols > 0) {
                for(j=0;j<tbl[i].noOfCols;j++) {
                    cw+=tbDiv.rows[0].cells[j].offsetWidth;
                }

                tbDiv.style.marginLeft = "-" + cw + "px";
                tbDiv.style.display='block';
                fh.style.marginLeft = "-" + cw + "px";
                var fxcol=ge$(tbl[i].tid+':scroller:fxcol').style;
                fxcol.width=(cw)+'px';
                var fxCH=ge$(tbl[i].tid+':scroller:fxCH');
                var fxCB=ge$(tbl[i].tid+':scroller:fxCB');
                fxCH.innerHTML='';
                fxCB.innerHTML='';
                fxCH.appendChild(t2);
                fxCH.style.height=tHeight+'px';
                fxCB.style.height=(h-tHeight)+'px';
				
                var t3=tbDiv.cloneNode(true); 
				changeIds(t3); //Added by Dharma
			
                t3.id=tbl[i].tid + '_CFB';
                t3.style.marginLeft = "0px";
                t3.setAttribute('dmt', tHeight);
                fxCB.appendChild(t3);
            }
            w=(parseInt(w)-cw)+'px';
            ge$(tbl[i].tid+':scroller').style.height=(h-tHeight) + 'px';
            ge$(tbl[i].tid+':scroller').style.width=w;
            ge$(tbl[i].tid+':scroller:fx:OuterDiv').style.height=tHeight + 'px';
            ge$(tbl[i].tid+':scroller:fx:OuterDiv').style.width=w;
        }
        //if(perUsed) {
            window.onresize=fxheader;
        //}
        flag=false;
    }
    this.fxheaderInit = function(_tid,_sheight,_noOfRows,_noOfCols) {
        var tb = new Object();
        var td=ge$(_tid);
        tb.tid=_tid;
        tb.sheight=_sheight;
        tb.swidth=td.width;
        if(!tb.swidth || tb.swidth.length==0) {
        	tb.swidth=td.style.width;
        	if(!tb.swidth) tb.swidth = '100%';
        	if(tb.swidth.indexOf('%')==-1) {
        		tb.swidth = parseInt(tb.swidth);	
        	}
        }
        tb.noOfRows=_noOfRows;
        tb.noOfCols=_noOfCols;
        addScrollerDivs(_tid,_noOfCols);
        tbl[tbl.length]=tb;
    };
})();
