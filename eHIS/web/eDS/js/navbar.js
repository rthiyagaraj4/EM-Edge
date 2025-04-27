
/**
 *  The DHTML Navigation Bar, NavBar-2.4
 *       Copyright dynarch.com, 2003
 *  http://dynarch.com/mishoo/menubar.epl
 *
 *  THIS NOTICE MUST REMAIN INTACT!
 *
 *           LICENSEE: Dynarch.com
 *        License key: dynarch
 *      Purchase date: Sun Mar 28 10:09:02 2004 GMT
 *       License type: dynarch
 *
 *  For details on this license please visit
 *  the NavBar homepage at the URL above.
 */
(function () {

    var UA = navigator.userAgent;
    is_ie = /msie/i.test(UA) && !(/opera/i.test(UA)) && !(/mac_powerpc/i.test(UA));
    is_khtml = /Konqueror|Safari|KHTML/i.test(UA);
    is_gecko = /gecko/i.test(UA) && !is_khtml;
})();
function NavBar(parent, before, after) {
    if (typeof parent == "string") {
        parent = document.getElementById(parent);
    }
    if (typeof before == "string") {
        before = document.getElementById(before);
    }
    if (typeof after == "string") {
        after = document.getElementById(after);
    }
    if (!NavBar.initialized) {
        NavBar.images = new Object();
        var names = ["arrow-up", "arrow-down", "arrow-left", "sticky", "sticky-off", "plus", "minus", "sync"];
        //var iconpath = "icons/";
        if (typeof _NavBar_icons_url == "string") {
            iconpath = _NavBar_icons_url.replace(/\x2f*$/, "/");
        } else {
            if (typeof _NavBar_url == "string") {
                iconpath = _NavBar_url.replace(/\x2f*$/, "/icons/");
            }
        }
        for (var i = 0; i < names.length; ++i) {
            var name = names[i];
            NavBar.images[name] = new Image();
            NavBar.images[name].src = iconpath + name + ".png";
        }
        NavBar.images["blank"] = new Image();
        NavBar.images["blank"].src = iconpath + "blank.gif";
        NavBar.initialized = true;
    }
    this.sections = [];
    this.parent = parent;
    this.page = null;
    this.hidden = false;
    this.hideButtons = [];
    this.toggleTabs = [];
    this.ahButtons = [];
    this.treeButtons = [];
    this.hilitedSection = null;
    this.hilitedItem = null;
    this.closed = false;
    this.prefs = {"animation":2, "mono-section":false, "generate-anim":false, "auto-hide":false, "tooltips":true, _save_load:["animation", "mono-section", "generate-anim", "auto-hide", "tooltips"], "link-target":null, "cookie-path":null, "link-prefix":"", "nb-frames":10, "nb-fps":25, "ns-frames":"auto", "ns-fps":30, "no-disable":false, "fewer-hover":false, "no-item-hover":false, "icon-width":20, "icon-height":14, "home-href":"http://www.dynarch.com/products/navbar/", "home-title":"NavBar product page", "home-text":"NavBar", "no-controls":false, save:function () {
        var str = "";
        for (var i = 0; i < this._save_load.length; ++i) {
            var name = this._save_load[i];
            var val = this[name];
            if (val === true) {
                val = "T";
            }
            if (val === false) {
                val = "F";
            }
            str += val;
        }
        return str;
    }, load:function (str) {
        for (var i = 0; i < str.length; ++i) {
            var name = this._save_load[i];
            var val = str.substr(i, 1);
            switch (val) {
              case "T":
                val = true;
                break;
              case "F":
                val = false;
                break;
            }
            this[name] = val;
        }
    }};
    this.lastSection = null;
    this.currentSection = null;
    this.before = (typeof before != "undefined") ? before : null;
    this.after = (typeof after != "undefined") ? after : null;
    var menuholder = NavBar.CE("div");
    this.holder = menuholder;
    menuholder.className = "menuholder";
    var menubar = NavBar.CE("div", menuholder);
    this.element = menubar;
    menubar.className = "menubar";
}
NavBar.initialized = false;
NavBar.prototype.setPref = function (name, value) {
    var oldval = this.prefs[name], i;
    this.prefs[name] = value;
    if (name == "auto-hide") {
        if (oldval != value) {
            if (value) {
                this.hide();
            } else {
                if (!this.hidden) {
                    this.hide(true);
                    this.show(true);
                } else {
                    this.show();
                }
            }
            for (i = this.ahButtons.length; --i >= 0; ) {
                NavBar.changeIMG(this.ahButtons[i], NavBar.images[value ? "sticky-off" : "sticky"].src);
            }
        }
    } else {
        if (name == "mono-section") {
            if (!oldval && value) {
                this.sync();
            } else {
                this.showAll();
            }
        }
    }
    return oldval;
};
NavBar.prototype._createControl = function (use_sticky, no_hide_arrow) {
    if (this.prefs["no-controls"]) {
        return false;
    }
    var self = this;
    var control = NavBar.CE("table", this.element);
    control.style.width = "100%";
    var tbody = NavBar.CE("tbody", control);
    var tr = NavBar.CE("tr", tbody);
    control.className = "control";
    var tooltips = this.prefs["tooltips"];
    function createButton(image, tooltip, align, action) {
        var td = NavBar.CE("td", tr);
        td.className = "btnholder";
        td.style.textAlign = align;
        td.style.width = "12px";
        var img = NavBar.IMG(12, 12, NavBar.images[image].src, td);
        img.className += " button";
        if (tooltips) {
            img.title = tooltip;
        }
        if (!self.prefs["fewer-hover"]) {
            img.onmouseover = function (ev) {
                if (NavBar.NR(this, ev)) {
                    this.parentNode.className = "hilite";
                }
            };
        }
        img.onmouseout = function (ev) {
            if (NavBar.NR(this, ev)) {
                this.parentNode.className = this.parentNode.className.replace(/\s*hilite\s*/g, " ");
            }
        };
        img.onclick = action;
        return td;
    }
    var mono = this.prefs["mono-section"];
    mono || this.treeButtons.push(createButton("plus", "Expand all", "left", function () {
        self.showAll();
    }));
    createButton("sync", "Synchronize", "left", function () {
        self.sync();
    });
    mono || this.treeButtons.push(createButton("minus", "Collapse all", "left", function () {
        self.hideAll();
    }));
    var td = NavBar.CE("td", tr);
    if (this.prefs["home-href"]) {
        td.style.textAlign = "center";
        var link = NavBar.CE("a", td);
        link.href = this.prefs["home-href"];
        if (tooltips && this.prefs["home-title"]) {
            link.title = this.prefs["home-title"];
        }
        link.innerHTML = this.prefs["home-text"];
    }
    if (use_sticky) {
        this.ahButtons.push(createButton(this.prefs["auto-hide"] ? "sticky-off" : "sticky", "Auto-hide", "right", function (e) {
            e || (e = window.event);
            self.setPref("auto-hide", !self.prefs["auto-hide"]);
        }).firstElementChild);
    }
    if (!no_hide_arrow) {
        this.hideButtons.push(createButton("arrow-left", "Hide menu", "right", function (e) {
            e || (e = window.event);
            if (e.shiftKey) {
                var img = this;
                if (typeof img.eggCount == "undefined") {
                    img.eggCount = 0;
                }
                ++img.eggCount;
                if (img.eggTimer) {
                    clearTimeout(img.eggTimer);
                }
                if (img.eggCount == 7) {
                    var text = "";
                    for (var i in NavBar._nfo) {
                        text += i + "  :  " + NavBar._nfo[i] + "\n";
                    }
                    alert(text);
                    img.eggCount = 0;
                } else {
                    img.eggTimer = setTimeout(function () {
                        img.eggCount = 0;
                        img.eggTimer = null;
                    }, 250);
                }
            } else {
                self.toggle();
            }
        }).firstElementChild);
    }
};
NavBar.prototype.openMenu = function (use_sticky, no_hide_arrow) {
    this.restoreState(true);
    this._createControl(use_sticky, no_hide_arrow);
    if (this.before) {
        this.element.appendChild(this.before);
    }
    var space = NavBar.CE("div", this.element);
    space.className = "space";
};
NavBar.prototype.closeMenu = function (use_sticky, no_hide_arrow) {
    if (!this.closed) {
        this.closed = true;
        var space = NavBar.CE("div", this.element);
        space.className = "space";
        if (this.after) {
            this.element.appendChild(this.after);
        }
        this._createControl(use_sticky, no_hide_arrow);
    }
};
NavBar.prototype.addSection = function (section) {
    this.sections[this.sections.length] = section;
    this.element.appendChild(section.title);
    this.element.appendChild(section.element);
    var space = NavBar.CE("div", this.element);
    space.className = "space";
};
NavBar.prototype.generate = function (use_sticky, no_hide_arrow) {
    this.closeMenu(use_sticky, no_hide_arrow);
    var div = null;
    div = NavBar.CE("div", null, true);
    this.page = div;
    while (this.parent.firstElementChild) {
        div.appendChild(this.parent.firstElementChild);
    }
    this.parent.appendChild(div);
    var bw = 0;
    if (this.holder.computedStyle) {
        bw = this.holder.computedStyle.borderRightWidth;
    } else {
        if (document.defaultView && !is_khtml) {
            bw = document.defaultView.getComputedStyle(this.holder, "").borderRightWidth;
        }
    }
    bw = parseInt(bw);
    this.bw = bw;
    this.parent.insertBefore(this.holder, div);
    this.width = this.holder.offsetWidth - bw;
    this.handle_width = 14;
    this.element.style.width = this.width + "px";
    this._repositionPage();
    for (var i = 0; i < this.sections.length; ++i) {
        var sec = this.sections[i];
        sec.height = sec.element.offsetHeight;
        sec.body.style.top = "0px";
        if (this.prefs["mono-section"]) {
            sec.hide(true);
        }
    }
    this.restoreState();
    if (!this.hidden && this.prefs["generate-anim"]) {
        this.hide(true);
        this.show(false);
    }
    if (this.prefs["auto-hide"]) {
        this.hide();
    }
    if (this.before) {
        this.before.style.display = "block";
    }
    if (this.after) {
        this.after.style.display = "block";
    }
    var menubar = this;
    window.onunload = function () {
        menubar.saveState();
    };
    this.element.onmouseover = function (ev) {
        if (menubar.prefs["auto-hide"] && NavBar.NR(this, ev)) {
            menubar.show(false);
        }
    };
    this.element.onmouseout = function (ev) {
        if (menubar.prefs["auto-hide"] && NavBar.NR(this, ev)) {
            menubar.hide(false);
        }
    };
};
NavBar.prototype.saveState = function () {
    var ck = "DYR_MENUBAR=" + (this.hidden ? "0" : "1") + "[";
    for (var i = 0; i < this.sections.length; ++i) {
        var sec = this.sections[i];
        ck += sec.hidden ? "0" : "1";
    }
    ck += "]/[" + this.prefs.save() + "]";
    var tmp = this.prefs["cookie-path"];
    if (tmp) {
        ck += ";path=" + tmp;
    }
    tmp = this.prefs["cookie-exp"];
    if (tmp) {
        var expiration = new Date();
        expiration.setTime(tmp * 86400000 + expiration.getTime());
        ck += ";expires=" + expiration.toGMTString();
    }
    document.cookie = ck;
};
NavBar.prototype.restoreState = function (prefs_only) {
    var re = /DYR_MENUBAR=([01])\[([01]*)\]\/\[(.*)\]/;
    if (document.cookie.match(re)) {
        var bar_hidden = RegExp.$1;
        var sec_hidden = RegExp.$2;
        var prefs_str = RegExp.$3;
        this.prefs.load(prefs_str);
        if (!prefs_only) {
            if (bar_hidden == "0") {
                this.hide(true);
            }
            if (this.sections.length == sec_hidden.length) {
                for (var i = 0; i < sec_hidden.length; ++i) {
                    this.sections[i][(sec_hidden.substr(i, 1) == "0") ? "hide" : "show"](true);
                }
            }
        }
    }
};
NavBar.prototype.hide = function (fast) {
    if (this.hidden) {
        return true;
    }
    var self = this;
    var width_element = this.element.offsetWidth;
    var diff = this.width - width_element;
    var hw = this.handle_width;
    var f_width = hw + diff;
    var f_left = hw - width_element;
    this.hidden = true;
    for (var i = 0; i < this.hideButtons.length; ++i) {
        var btn = this.hideButtons[i];
        NavBar.changeIMG(btn, NavBar.images["arrow-right"].src);
        if (this.prefs["tooltips"]) {
            btn.title = "Show menu";
        }
    }
    for (i = 0; i < this.toggleTabs.length; ++i) {
        var btn = this.toggleTabs[i];
        btn.src = btn.__hid;
    }
    function finish() {
        self.element.style.left = f_left + "px";
        self.holder.style.width = f_width + "px";
        self._repositionPage();
        self.anim = null;
    }
    if (fast || (this.prefs["animation"] < 2)) {
        finish();
        return true;
    }
    var bloat = (self.prefs["animation"] >= 3) && !self.prefs["auto-hide"];
    var i_width = this.holder.offsetWidth - this.bw;
    if (this.anim) {
        this.anim.stop(false);
    }
    this.anim = new Animation(self.prefs["nb-frames"], self.prefs["nb-fps"], this.element.offsetLeft, f_left);
    this.anim.onUpdate = function (a) {
        var w = (i_width + a.delta) + "px";
        self.element.style.left = a.pos + "px";
        self.holder.style.width = w;
        if (bloat) {
            self.page.style.marginLeft = w;
        }
    };
    this.anim.onStop = finish;
    this.anim.restart();
};
NavBar.prototype.show = function (fast) {
    if (!this.hidden) {
        return true;
    }
    var self = this;
    this.hidden = false;
    for (var i = 0; i < this.hideButtons.length; ++i) {
        var btn = this.hideButtons[i];
        NavBar.changeIMG(btn, NavBar.images["arrow-left"].src);
        if (this.prefs["tooltips"]) {
            btn.title = "Hide menu";
        }
    }
    for (i = 0; i < this.toggleTabs.length; ++i) {
        var btn = this.toggleTabs[i];
        btn.src = btn.__vis;
    }
    var f_left = 0;
    var f_width = this.width;
    function finish() {
        self.element.style.left = f_left + "px";
        self.holder.style.width = f_width + "px";
        self.prefs["auto-hide"] || self._repositionPage();
        self.anim = null;
    }
    if (fast || (this.prefs["animation"] < 2)) {
        finish();
        return true;
    }
    var bloat = (self.prefs["animation"] >= 3) && !self.prefs["auto-hide"];
    var i_width = this.holder.offsetWidth - this.bw;
    if (this.anim) {
        this.anim.stop(false);
    }
    this.anim = new Animation(self.prefs["nb-frames"], self.prefs["nb-fps"], this.element.offsetLeft, f_left);
    this.anim.onUpdate = function (a) {
        var w = (i_width + a.delta) + "px";
        if (bloat) {
            self.page.style.marginLeft = w;
        }
        self.element.style.left = a.pos + "px";
        self.holder.style.width = w;
    };
    this.anim.onStop = finish;
    this.anim.restart();
};
NavBar.prototype.toggle = function () {
    this[this.hidden ? "show" : "hide"](false);
};
NavBar.prototype._repositionPage = function () {
    this.page.style.marginLeft = this.holder.offsetWidth + "px";
};
NavBar.prototype.hideAll = function (fast) {
    for (var i = 0; i < this.sections.length; ++i) {
        this.sections[i].hide(fast);
    }
};
NavBar.prototype.showAll = function (fast) {
    for (var i = 0; i < this.sections.length; ++i) {
        this.sections[i].show(fast);
    }
};
NavBar.prototype.sync = function (fast) {
    this.hideAll(fast);
    if (this.currentSection) {
        this.currentSection.show(fast);
    }
};
function NavSection(parent, name, items,tableName) {
    var html_el = null;
    if (typeof items == "string") {
        html_el = document.getElementById(items);
        if (!html_el) {
            return;
        } else {
            if (html_el.title) {
                name = html_el.title;
            }
        }
    }
    var self = this;
    this.parent = parent;
    var tooltips = parent.prefs["tooltips"];
    var title = NavBar.CE("table");
    title.className = "title";
    title.id=tableName;
    this.title = title;
    var tbody = NavBar.CE("tbody", title);
    var tr = NavBar.CE("tr", tbody);
    var td = NavBar.CE("td", tr);
    td.innerHTML = name;
    td.className = "COLUMNHEADER";
    td = NavBar.CE("td", tr);
    td.width="10%"
   
    td.style.textAlign = "right";
    td.className = "COLUMNHEADER";
    if (items) {
        this.button = NavBar.IMG(0, 0, NavBar.images["arrow-up"].src, td);
    }
    var section = NavBar.CE("div");
    if (!items) {
        section.style.display = "none";
    }
    this.element = section;
    section.className = "section";
    var body = NavBar.CE("div", section);
    this.body = body;
    body.className = "body";
    (is_ie) || (body.style.position = "relative");
    if (!self.parent.prefs["fewer-hover"]) {
        body.onmouseover = function (ev) {
            if (self.anim) {
                return;
            }
            var tmp = self.parent.hilitedSection;
            if (tmp) {
                tmp.body.className = tmp.body.className.replace(/\s*body-hilite\s*/g, " ");
                tmp.title.className = tmp.title.className.replace(/\s*title-hilite\s*/g, " ");
            }
            self.parent.hilitedSection = self;
            this.className += " body-hilite";
            self.title.className += " title-hilite";
        };
    }
    body.onmouseout = function (ev) {
        if (self.anim) {
            return;
        }
        if (NavBar.NR(this, ev)) {
            this.className = this.className.replace(/\s*body-hilite\s*/g, " ");
            self.title.className = self.title.className.replace(/\s*title-hilite\s*/g, " ");
        }
    };
    if (html_el) {
        body.appendChild(html_el);
        html_el.style.display = "block";
        html_el.className = "html-element";
        this.table = html_el;
    } else {
        if (items) {
            var table = NavBar.CE("table", body);
            this.table = table;
            tbody = NavBar.CE("tbody", table);
            this.length = items.length;
            var W = this.parent.prefs["icon-width"];
            var H = this.parent.prefs["icon-height"];
            for (var i = 0; i < items.length; ++i) {
                var a = items[i];
                if (!a) {
                    (tr = NavBar.CE("tr", tbody)).className = "separator";
                    (td = NavBar.CE("td", tr)).colSpan = 2;
                    td.innerHTML = "<div>&nbsp;</div>";
                    continue;
                }
                var item = NavBar.CE("tr", tbody);
                item.className = "item";
                item.__name = a[0];
                item.__href = a[1];
                item.__tooltip = a[2];
                item.__image = a[3];
                item.__target = a[4];
                if (item.__name.substr(0, 1) == "!") {
                    item.__name = item.__name.substr(1);
                    var nod = this.parent.prefs["no-disable"];
                    if (!nod || typeof nod != "string") {
                        item.__disabled = true;
                        item.className += " item-disabled";
                    } else {
                        item.className += " " + nod;
                    }
                    parent.currentSection = this;
                } else {
                    item.__disabled = false;
                }
                if (tooltips) {
                    item.title = item.__tooltip;
                }
                td = NavBar.CE("td", item);
                td.className = "image";
                if (item.__image) {
                    NavBar.IMG(W, H, item.__image, td);
                } else {
                    td.innerHTML = "&#x00bb;";
                }
                td = NavBar.CE("td", item);
                link = NavBar.CE("div", td);
                link.className = "link";
                link.innerHTML = item.__name;
                if (item.__disabled) {
                    continue;
                }
                if (!self.parent.prefs["no-item-hover"]) {
                    item.onmouseover = function (ev) {
                        if (self.anim) {
                            return;
                        }
                        if (NavBar.NR(this, ev)) {
                            window.status = this.__tooltip;
                            var tmp = self.parent.hilitedItem;
                            if (tmp) {
                                tmp.className = tmp.className.replace(/\s*item-hilite\s*/g, " ");
                            }
                            self.parent.hilitedItem = this;
                            this.className += " item-hilite";
                        }
                    };
                }
                item.onmouseout = function (ev) {
                    if (self.anim) {
                        return;
                    }
                    if (NavBar.NR(this, ev)) {
                        window.status = "";
                        this.className = this.className.replace(/\s*item-hilite\s*/g, " ");
                    }
                };
                item.onclick = function () {
                    if (self.anim) {
                        return false;
                    }
                    if (typeof this.__href == "function") {
                        this.__href(this.__target, this, self);
                    } else {
                        var target = self.parent.prefs["link-target"] || this.__target;
                        if (target) {
                            window.open(self.parent.prefs["link-prefix"] + this.__href, target);
                        } else {
                            window.location.href = self.parent.prefs["link-prefix"] + this.__href;
                        }
                    }
                };
                item.onmousedown = function () {
                    if (self.anim) {
                        return false;
                    }
                };
            }
        }
    }
    if (!self.parent.prefs["fewer-hover"]) {
        title.onmouseover = function (ev) {
            if (NavBar.NR(this, ev)) {
                this.className += " title-hilite";
            }
        };
    }
    title.onmouseout = function (ev) {
        if (NavBar.NR(this, ev)) {
            this.className = this.className.replace(/\s*title-hilite\s*/g, " ");
        }
    };
    if (tooltips) {
        title.title = "Collapse";
    }
    title.onclick = function () {
        self.toggle();
        if (!self.hidden) {
            self.parent.show();
        }
    };
    this.hidden = false;
    this.height = null;
    this.width = null;
    parent.addSection(this);
}
NavSection.prototype.setClass = function (cn) {
    this.element.className += " " + cn;
    this.title.className += " " + cn + "-title";
    return this;
};
NavSection.prototype.addToggleTab = function (imgsrc, imgclosedsrc) {
    var table = NavBar.CE("table", this.body);
    table.cellSpacing = 0;
    table.cellPadding = 0;
    var tbody = NavBar.CE("tbody", table);
    var tr = NavBar.CE("tr", tbody);
    var td1 = NavBar.CE("td", tr);
    td1.className = "toggle-tab-body";
    var td = NavBar.CE("td", tr);
    td.className = "toggle-tab";
    var img = NavBar.CE("img", td);
    img.src = imgsrc;
    var self = this;
    img.__vis = imgsrc;
    if (imgclosedsrc) {
        img.__hid = imgclosedsrc;
        this.parent.toggleTabs.push(img);
    }
    img.onclick = function () {
        self.parent.toggle();
    };
    td1.appendChild(this.table);
    this.table = table;
    return this;
};
NavSection.prototype.show = function (fast) {
    if (!this.button || !this.hidden) {
        return true;
    }
    var menubar = this.parent;
    if (menubar.prefs["mono-section"] && menubar.lastSection) {
        menubar.lastSection.hide();
    }
    menubar.lastSection = this;
    var self = this;
    function finish() {
        if (is_ie) {
            self.body.style.position = "";
        }
        self.element.style.height = "";
        self.anim = null;
        self.element.style.filter = "";
        self.element.style.opacity = "";
    }
    if (menubar.prefs["tooltips"]) {
        self.title.title = "Collapse";
    }
    NavBar.changeIMG(self.button, NavBar.images["arrow-up"].src);
    self.hidden = false;
    self.element.style.display = "block";
    if (is_ie) {
        self.body.style.width = self.body.runtimeStyle.width;
        self.body.style.position = "absolute";
    }
    if (fast || (menubar.prefs["animation"] < 1)) {
        finish();
        return true;
    }
    if (this.anim) {
        this.anim.stop(false);
    }
    this.anim = new Animation(typeof menubar.prefs["ns-frames"] == "number" ? menubar.prefs["ns-frames"] : self.height / 25, menubar.prefs["ns-fps"], self.element.offsetHeight, self.height);
    this.anim.onUpdate = function (a) {
        self.element.style.height = a.pos + "px";
        self.body.style.top = (a.pos - a.pos2) + "px";
        var op = a.percent;
        if (is_ie) {
            self.element.style.filter = "alpha(opacity=" + op + ")";
        } else {
            self.element.style.opacity = op / 100;
        }
    };
    this.anim.onStop = finish;
    this.anim.restart();
};
NavSection.prototype.hide = function (fast) {
    if (!this.button || this.hidden) {
        return true;
    }
    var self = this;
    var menubar = this.parent;
    function finish() {
        if (is_ie) {
            self.body.style.position = "";
        }
        self.element.style.height = "0px";
        self.element.style.display = "none";
        self.anim = null;
    }
    if (menubar.prefs["tooltips"]) {
        self.title.title = "Expand";
    }
    NavBar.changeIMG(self.button, NavBar.images["arrow-down"].src);
    self.hidden = true;
    if (this.anim) {
        this.anim.stop(false);
    }
    var height = self.body.offsetHeight;
    if (!self.height) {
        self.height = height;
    }
    if (fast || (menubar.prefs["animation"] < 1)) {
        finish();
        return true;
    }
    this.anim = new Animation(typeof menubar.prefs["ns-frames"] == "number" ? menubar.prefs["ns-frames"] : self.height / 14, menubar.prefs["ns-fps"], height, 0);
    var i_top = parseInt(self.body.style.top);
    if (is_ie) {
        self.element.style.height = height + "px";
        self.body.style.position = "absolute";
    }
    this.anim.onUpdate = function (a) {
        self.element.style.height = a.pos + "px";
        self.body.style.top = (i_top + a.delta) + "px";
        var op = 100 - a.percent;
        if (is_ie) {
            self.element.style.filter = "alpha(opacity=" + op + ")";
        } else {
            self.element.style.opacity = op / 100;
        }
    };
    this.anim.onStop = finish;
    this.anim.restart();
};
NavSection.prototype.toggle = function () {
    this[this.hidden ? "show" : "hide"](false);
};
NavBar.IMG = function (w, h, src, parent) {
    var img;
    var fucked_up = /\.png$/.test(src) && is_ie;
    img = NavBar.CE("img", parent);
    if (!fucked_up) {
        img.src = src;
    } else {
        img.src = NavBar.images["blank"].src;
    }
    if (w) {
        img.style.width = w + "px";
    }
    if (h) {
        img.style.height = h + "px";
    }
    if (fucked_up) {
        img.runtimeStyle.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(src='" + src + "',sizingMethod='scale')";
    }
    img.className = "img";
    return img;
};
NavBar.changeIMG = function (img, src) {
    if (!is_ie) {
        img.src = src;
    } else {
        img.runtimeStyle.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(src='" + src + "',sizingMethod='scale')";
    }
};
NavBar.NR = function (element, ev) {
    var related;
    if (window.event) {
        ev = window.event;
        var type = ev.type;
        if (type == "mouseover") {
            related = ev.fromElement;
        } else {
            if (type == "mouseout") {
                related = ev.toElement;
            }
        }
    } else {
        related = ev.relatedTarget;
    }
    if (!related) {
        return false;
    }
    while (related) {
        if (related == element) {
            return false;
        }
        related = related.parentNode;
    }
    return true;
};
NavBar.CE = function (type, parent, nouns) {
    var el = null;
    if (document.createElementNS) {
        el = document.createElementNS("http://www.w3.org/1999/xhtml", type);
    } else {
        el = document.createElement(type);
    }
    if (!nouns) {
        if (is_ie) {
            el.unselectable = "on";
        } else {
            if (is_gecko) {
                el.style.setProperty("-moz-user-select", "none", "");
            }
        }
    }
    if (parent) {
        parent.appendChild(el);
    }
    return el;
};
NavBar._nfo = {product:"NavBar-2.7", licensee:"A/S WebGlobe", license_key:"3f7ad8d19a3ddedcdbbb7267372c6f3d", purchase_date:"Wed Jan 11 12:33:04 2006 GMT", license_type:"single-site"};
if (typeof Array.prototype.push != "function") {
    Array.prototype.push = function (el) {
        this[this.length] = el;
    };
}
Interval = {_currentId:0, _cached:{}, _timers:{}, set:function (action, speed) {
    var o, id = ++Interval._currentId;
    if (Interval._cached[speed]) {
        o = Interval._cached[speed];
        o.actions[id] = action;
        ++o.length;
        Interval._timers[id] = o;
        return id;
    } else {
        o = {speed:speed, actions:{}, length:1, timerID:setInterval(function () {
            var a = o.actions;
            for (var i in a) {
                a[i]();
            }
        }, speed)};
        o.actions[id] = action;
        Interval._cached[speed] = o;
        Interval._timers[id] = o;
    }
    return id;
}, clear:function (id) {
    var o = Interval._timers[id];
    --o.length;
    if (o.length == 0) {
        delete Interval._cached[o.speed];
        clearInterval(o.timerID);
    } else {
        delete o.actions[id];
    }
    delete Interval._timers[id];
}};
function Animation(length, speed, pos1, pos2) {
    this.length = length;
    this.speed = Math.round(1000 / speed);
    this.pos1 = pos1;
    this.pos2 = pos2;
    this.diff = pos2 - pos1;
    this.percent = 0;
    this.timerID = null;
    this.accel = false;
}
Animation.prototype = {clearTimer:function () {
    (this.timerID) && Interval.clear(this.timerID);
    this.timerID = null;
}, start:function () {
    if (typeof this.step == "undefined" || this.step < 0 || this.step >= this.length) {
        this.restart();
    } else {
        var self = this;
        this.clearTimer();
        this.timerID = Interval.set(function () {
            self.update();
        }, this.speed);
    }
}, restart:function () {
    this.onStart(this);
    this.pos = this.pos1;
    this.step = 0;
    this.diff = this.pos2 - this.pos1;
    this.rad_step = Math.PI / (2 * this.length);
    this.rad_pos = 0;
    this.start();
}, update:function () {
    if (this.step < this.length && this.step >= 0) {
        var f = this.accel ? (1 - Math.cos(this.rad_pos)) : Math.sin(this.rad_pos);
        this.delta = Math.round(f * this.diff);
        this.pos = this.pos1 + this.delta;
        this.percent = Math.round(100 * (this.pos - this.pos1) / this.diff);
        this.onUpdate(this);
        ++this.step;
        this.rad_pos += this.rad_step;
    } else {
        this.delta = this.pos2 - this.pos;
        this.pos = this.pos2;
        this.percent = 100;
        this.onUpdate(this);
        this.stop(true);
    }
}, stop:function (call) {
    this.clearTimer();
    call && this.onStop(this);
}, onStart:function () {
}, onStop:function () {
}, onUpdate:function () {
}};

