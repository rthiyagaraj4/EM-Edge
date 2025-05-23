(function () {
    YAHOO.util.Config = function (D) {
        if (D) {
            this.init(D);
        }
    };
    var B = YAHOO.lang,
        C = YAHOO.util.CustomEvent,
        A = YAHOO.util.Config;
    A.CONFIG_CHANGED_EVENT = "configChanged";
    A.BOOLEAN_TYPE = "boolean";
    A.prototype = {
        owner: null,
        queueInProgress: false,
        config: null,
        initialConfig: null,
        eventQueue: null,
        configChangedEvent: null,
        init: function (D) {
            this.owner = D;
            this.configChangedEvent = this.createEvent(A.CONFIG_CHANGED_EVENT);
            this.configChangedEvent.signature = C.LIST;
            this.queueInProgress = false;
            this.config = {};
            this.initialConfig = {};
            this.eventQueue = [];
        },
        checkBoolean: function (D) {
            return (typeof D == A.BOOLEAN_TYPE);
        },
        checkNumber: function (D) {
            return (!isNaN(D));
        },
        fireEvent: function (D, F) {
            var E = this.config[D];
            if (E && E.event) {
                E.event.fire(F);
            }
        },
        addProperty: function (E, D) {
            E = E.toLowerCase();
            this.config[E] = D;
            D.event = this.createEvent(E, {
                scope: this.owner
            });
            D.event.signature = C.LIST;
            D.key = E;
            if (D.handler) {
                D.event.subscribe(D.handler, this.owner);
            }
            this.setProperty(E, D.value, true);
            if (!D.suppressEvent) {
                this.queueProperty(E, D.value);
            }
        },
        getConfig: function () {
            var D = {},
                F = this.config,
                G, E;
            for (G in F) {
                if (B.hasOwnProperty(F, G)) {
                    E = F[G];
                    if (E && E.event) {
                        D[G] = E.value;
                    }
                }
            }
            return D;
        },
        getProperty: function (D) {
            var E = this.config[D.toLowerCase()];
            if (E && E.event) {
                return E.value;
            } else {
                return undefined;
            }
        },
        resetProperty: function (D) {
            D = D.toLowerCase();
            var E = this.config[D];
            if (E && E.event) {
                if (this.initialConfig[D] && !B.isUndefined(this.initialConfig[D])) {
                    this.setProperty(D, this.initialConfig[D]);
                    return true;
                }
            } else {
                return false;
            }
        },
        setProperty: function (E, G, D) {
            var F;
            E = E.toLowerCase();
            if (this.queueInProgress && !D) {
                this.queueProperty(E, G);
                return true;
            } else {
                F = this.config[E];
                if (F && F.event) {
                    if (F.validator && !F.validator(G)) {
                        return false;
                    } else {
                        F.value = G;
                        if (!D) {
                            this.fireEvent(E, G);
                            this.configChangedEvent.fire([E, G]);
                        }
                        return true;
                    }
                } else {
                    return false;
                }
            }
        },
        queueProperty: function (S, P) {
            S = S.toLowerCase();
            var R = this.config[S],
                K = false,
                J, G, H, I, O, Q, F, M, N, D, L, T, E;
            if (R && R.event) {
                if (!B.isUndefined(P) && R.validator && !R.validator(P)) {
                    return false;
                } else {
                    if (!B.isUndefined(P)) {
                        R.value = P;
                    } else {
                        P = R.value;
                    }
                    K = false;
                    J = this.eventQueue.length;
                    for (L = 0; L < J; L++) {
                        G = this.eventQueue[L];
                        if (G) {
                            H = G[0];
                            I = G[1];
                            if (H == S) {
                                this.eventQueue[L] = null;
                                this.eventQueue.push([S, (!B.isUndefined(P) ? P : I)]);
                                K = true;
                                break;
                            }
                        }
                    }
                    if (!K && !B.isUndefined(P)) {
                        this.eventQueue.push([S, P]);
                    }
                } if (R.supercedes) {
                    O = R.supercedes.length;
                    for (T = 0; T < O; T++) {
                        Q = R.supercedes[T];
                        F = this.eventQueue.length;
                        for (E = 0; E < F; E++) {
                            M = this.eventQueue[E];
                            if (M) {
                                N = M[0];
                                D = M[1];
                                if (N == Q.toLowerCase()) {
                                    this.eventQueue.push([N, D]);
                                    this.eventQueue[E] = null;
                                    break;
                                }
                            }
                        }
                    }
                }
                return true;
            } else {
                return false;
            }
        },
        refireEvent: function (D) {
            D = D.toLowerCase();
            var E = this.config[D];
            if (E && E.event && !B.isUndefined(E.value)) {
                if (this.queueInProgress) {
                    this.queueProperty(D);
                } else {
                    this.fireEvent(D, E.value);
                }
            }
        },
        applyConfig: function (D, G) {
            var F, E;
            if (G) {
                E = {};
                for (F in D) {
                    if (B.hasOwnProperty(D, F)) {
                        E[F.toLowerCase()] = D[F];
                    }
                }
                this.initialConfig = E;
            }
            for (F in D) {
                if (B.hasOwnProperty(D, F)) {
                    this.queueProperty(F, D[F]);
                }
            }
        },
        refresh: function () {
            var D;
            for (D in this.config) {
                if (B.hasOwnProperty(this.config, D)) {
                    this.refireEvent(D);
                }
            }
        },
        fireQueue: function () {
            var E, H, D, G, F;
            this.queueInProgress = true;
            for (E = 0; E < this.eventQueue.length; E++) {
                H = this.eventQueue[E];
                if (H) {
                    D = H[0];
                    G = H[1];
                    F = this.config[D];
                    F.value = G;
                    this.eventQueue[E] = null;
                    this.fireEvent(D, G);
                }
            }
            this.queueInProgress = false;
            this.eventQueue = [];
        },
        subscribeToConfigEvent: function (E, F, H, D) {
            var G = this.config[E.toLowerCase()];
            if (G && G.event) {
                if (!A.alreadySubscribed(G.event, F, H)) {
                    G.event.subscribe(F, H, D);
                }
                return true;
            } else {
                return false;
            }
        },
        unsubscribeFromConfigEvent: function (D, E, G) {
            var F = this.config[D.toLowerCase()];
            if (F && F.event) {
                return F.event.unsubscribe(E, G);
            } else {
                return false;
            }
        },
        toString: function () {
            var D = "Config";
            if (this.owner) {
                D += " [" + this.owner.toString() + "]";
            }
            return D;
        },
        outputEventQueue: function () {
            var D = "",
                G, E, F = this.eventQueue.length;
            for (E = 0; E < F; E++) {
                G = this.eventQueue[E];
                if (G) {
                    D += G[0] + "=" + G[1] + ", ";
                }
            }
            return D;
        },
        destroy: function () {
            var E = this.config,
                D, F;
            for (D in E) {
                if (B.hasOwnProperty(E, D)) {
                    F = E[D];
                    F.event.unsubscribeAll();
                    F.event = null;
                }
            }
            this.configChangedEvent.unsubscribeAll();
            this.configChangedEvent = null;
            this.owner = null;
            this.config = null;
            this.initialConfig = null;
            this.eventQueue = null;
        }
    };
    A.alreadySubscribed = function (E, H, I) {
        var F = E.subscribers.length,
            D, G;
        if (F > 0) {
            G = F - 1;
            do {
                D = E.subscribers[G];
                if (D && D.obj == I && D.fn == H) {
                    return true;
                }
            } while (G--);
        }
        return false;
    };
    YAHOO.lang.augmentProto(A, YAHOO.util.EventProvider);
}());
(function () {
    YAHOO.widget.Module = function (R, Q) {
        if (R) {
            this.init(R, Q);
        } else {}
    };
    var F = YAHOO.util.Dom,
        D = YAHOO.util.Config,
        N = YAHOO.util.Event,
        M = YAHOO.util.CustomEvent,
        G = YAHOO.widget.Module,
        I = YAHOO.env.ua,
        H, P, O, E, A = {
            "BEFORE_INIT": "beforeInit",
            "INIT": "init",
            "APPEND": "append",
            "BEFORE_RENDER": "beforeRender",
            "RENDER": "render",
            "CHANGE_HEADER": "changeHeader",
            "CHANGE_BODY": "changeBody",
            "CHANGE_FOOTER": "changeFooter",
            "CHANGE_CONTENT": "changeContent",
            "DESTORY": "destroy",
            "BEFORE_SHOW": "beforeShow",
            "SHOW": "show",
            "BEFORE_HIDE": "beforeHide",
            "HIDE": "hide"
        },
        J = {
            "VISIBLE": {
                key: "visible",
                value: true,
                validator: YAHOO.lang.isBoolean
            },
            "EFFECT": {
                key: "effect",
                suppressEvent: true,
                supercedes: ["visible"]
            },
            "MONITOR_RESIZE": {
                key: "monitorresize",
                value: true
            },
            "APPEND_TO_DOCUMENT_BODY": {
                key: "appendtodocumentbody",
                value: false
            }
        };
    G.IMG_ROOT = null;
    G.IMG_ROOT_SSL = null;
    G.CSS_MODULE = "yui-module";
    G.CSS_HEADER = "hd";
    G.CSS_BODY = "bd";
    G.CSS_FOOTER = "ft";
    G.RESIZE_MONITOR_SECURE_URL = "javascript:false;";
    G.RESIZE_MONITOR_BUFFER = 1;
    G.textResizeEvent = new M("textResize");
    G.forceDocumentRedraw = function () {
        var Q = document.documentElement;
        if (Q) {
            Q.className += " ";
            Q.className = YAHOO.lang.trim(Q.className);
        }
    };

    function L() {
        if (!H) {
            H = document.createElement("div");
            H.innerHTML = ('<div class="' + G.CSS_HEADER + '"></div>' + '<div class="' + G.CSS_BODY + '"></div><div class="' + G.CSS_FOOTER + '"></div>');
            P = H.firstElementChild;
            O = P.nextSibling;
            E = O.nextSibling;
        }
        return H;
    }

    function K() {
        if (!P) {
            L();
        }
        return (P.cloneNode(false));
    }

    function B() {
        if (!O) {
            L();
        }
        return (O.cloneNode(false));
    }

    function C() {
        if (!E) {
            L();
        }
        return (E.cloneNode(false));
    }
    G.prototype = {
        constructor: G,
        element: null,
        header: null,
        body: null,
        footer: null,
        id: null,
        imageRoot: G.IMG_ROOT,
        initEvents: function () {
            var Q = M.LIST;
            this.beforeInitEvent = this.createEvent(A.BEFORE_INIT);
            this.beforeInitEvent.signature = Q;
            this.initEvent = this.createEvent(A.INIT);
            this.initEvent.signature = Q;
            this.appendEvent = this.createEvent(A.APPEND);
            this.appendEvent.signature = Q;
            this.beforeRenderEvent = this.createEvent(A.BEFORE_RENDER);
            this.beforeRenderEvent.signature = Q;
            this.renderEvent = this.createEvent(A.RENDER);
            this.renderEvent.signature = Q;
            this.changeHeaderEvent = this.createEvent(A.CHANGE_HEADER);
            this.changeHeaderEvent.signature = Q;
            this.changeBodyEvent = this.createEvent(A.CHANGE_BODY);
            this.changeBodyEvent.signature = Q;
            this.changeFooterEvent = this.createEvent(A.CHANGE_FOOTER);
            this.changeFooterEvent.signature = Q;
            this.changeContentEvent = this.createEvent(A.CHANGE_CONTENT);
            this.changeContentEvent.signature = Q;
            this.destroyEvent = this.createEvent(A.DESTORY);
            this.destroyEvent.signature = Q;
            this.beforeShowEvent = this.createEvent(A.BEFORE_SHOW);
            this.beforeShowEvent.signature = Q;
            this.showEvent = this.createEvent(A.SHOW);
            this.showEvent.signature = Q;
            this.beforeHideEvent = this.createEvent(A.BEFORE_HIDE);
            this.beforeHideEvent.signature = Q;
            this.hideEvent = this.createEvent(A.HIDE);
            this.hideEvent.signature = Q;
        },
        platform: function () {
            var Q = navigator.userAgent.toLowerCase();
            if (Q.indexOf("windows") != -1 || Q.indexOf("win32") != -1) {
                return "windows";
            } else {
                if (Q.indexOf("macintosh") != -1) {
                    return "mac";
                } else {
                    return false;
                }
            }
        }(),
        browser: function () {
            var Q = navigator.userAgent.toLowerCase();
            if (Q.indexOf("opera") != -1) {
                return "opera";
            } else {
                if (Q.indexOf("msie 7") != -1) {
                    return "ie7";
                } else {
                    if (Q.indexOf("msie") != -1) {
                        return "ie";
                    } else {
                        if (Q.indexOf("safari") != -1) {
                            return "safari";
                        } else {
                            if (Q.indexOf("gecko") != -1) {
                                return "gecko";
                            } else {
                                return false;
                            }
                        }
                    }
                }
            }
        }(),
        isSecure: function () {
            if (window.location.href.toLowerCase().indexOf("https") === 0) {
                return true;
            } else {
                return false;
            }
        }(),
        initDefaultConfig: function () {
            this.cfg.addProperty(J.VISIBLE.key, {
                handler: this.configVisible,
                value: J.VISIBLE.value,
                validator: J.VISIBLE.validator
            });
            this.cfg.addProperty(J.EFFECT.key, {
                suppressEvent: J.EFFECT.suppressEvent,
                supercedes: J.EFFECT.supercedes
            });
            this.cfg.addProperty(J.MONITOR_RESIZE.key, {
                handler: this.configMonitorResize,
                value: J.MONITOR_RESIZE.value
            });
            this.cfg.addProperty(J.APPEND_TO_DOCUMENT_BODY.key, {
                value: J.APPEND_TO_DOCUMENT_BODY.value
            });
        },
        init: function (V, U) {
            var S, W;
            this.initEvents();
            this.beforeInitEvent.fire(G);
            this.cfg = new D(this);
            if (this.isSecure) {
                this.imageRoot = G.IMG_ROOT_SSL;
            }
            if (typeof V == "string") {
                S = V;
                V = document.getElementById(V);
                if (!V) {
                    V = (L()).cloneNode(false);
                    V.id = S;
                }
            }
            this.id = F.generateId(V);
            this.element = V;
            W = this.element.firstElementChild;
            if (W) {
                var R = false,
                    Q = false,
                    T = false;
                do {
                    if (1 == W.nodeType) {
                        if (!R && F.hasClass(W, G.CSS_HEADER)) {
                            this.header = W;
                            R = true;
                        } else {
                            if (!Q && F.hasClass(W, G.CSS_BODY)) {
                                this.body = W;
                                Q = true;
                            } else {
                                if (!T && F.hasClass(W, G.CSS_FOOTER)) {
                                    this.footer = W;
                                    T = true;
                                }
                            }
                        }
                    }
                } while ((W = W.nextSibling));
            }
            this.initDefaultConfig();
            F.addClass(this.element, G.CSS_MODULE);
            if (U) {
                this.cfg.applyConfig(U, true);
            }
            if (!D.alreadySubscribed(this.renderEvent, this.cfg.fireQueue, this.cfg)) {
                this.renderEvent.subscribe(this.cfg.fireQueue, this.cfg, true);
            }
            this.initEvent.fire(G);
        },
        initResizeMonitor: function () {
            var R = (I.gecko && this.platform == "windows");
            if (R) {
                var Q = this;
                setTimeout(function () {
                    Q._initResizeMonitor();
                }, 0);
            } else {
                this._initResizeMonitor();
            }
        },
        _initResizeMonitor: function () {
            var Q, S, U;

            function W() {
                G.textResizeEvent.fire();
            }
            if (!I.opera) {
                S = F.get("_yuiResizeMonitor");
                var V = this._supportsCWResize();
                if (!S) {
                    S = document.createElement("iframe");
                    if (this.isSecure && G.RESIZE_MONITOR_SECURE_URL && I.ie) {
                        S.src = G.RESIZE_MONITOR_SECURE_URL;
                    }
                    if (!V) {
                        U = [""].join("");
                        S.src = "data:text/html;charset=utf-8," + encodeURIComponent(U);
                    }
                    S.id = "_yuiResizeMonitor";
                    S.title = "Text Resize Monitor";
                    S.style.position = "absolute";
                    S.style.visibility = "hidden";
                    var R = document.body,
                        T = R.firstElementChild;
                    if (T) {
                        R.insertBefore(S, T);
                    } else {
                        R.appendChild(S);
                    }
                    S.style.width = "2em";
                    S.style.height = "2em";
                    S.style.top = (-1 * (S.offsetHeight + G.RESIZE_MONITOR_BUFFER)) + "px";
                    S.style.left = "0";
                    S.style.borderWidth = "0";
                    S.style.visibility = "visible";
                    if (I.webkit) {
                        Q = S.contentWindow.document;
                        Q.open();
                        Q.close();
                    }
                }
                if (S && S.contentWindow) {
                    G.textResizeEvent.subscribe(this.onDomResize, this, true);
                    if (!G.textResizeInitialized) {
                        if (V) {
                            if (!N.on(S.contentWindow, "resize", W)) {
                                N.on(S, "resize", W);
                            }
                        }
                        G.textResizeInitialized = true;
                    }
                    this.resizeMonitor = S;
                }
            }
        },
        _supportsCWResize: function () {
            var Q = true;
            if (I.gecko && I.gecko <= 1.8) {
                Q = false;
            }
            return Q;
        },
        onDomResize: function (S, R) {
            var Q = -1 * (this.resizeMonitor.offsetHeight + G.RESIZE_MONITOR_BUFFER);
            this.resizeMonitor.style.top = Q + "px";
            this.resizeMonitor.style.left = "0";
        },
        setHeader: function (R) {
            var Q = this.header || (this.header = K());
            if (R.nodeName) {
                Q.innerHTML = "";
                Q.appendChild(R);
            } else {
                Q.innerHTML = R;
            }
            this.changeHeaderEvent.fire(R);
            this.changeContentEvent.fire();
        },
        appendToHeader: function (R) {
            var Q = this.header || (this.header = K());
            Q.appendChild(R);
            this.changeHeaderEvent.fire(R);
            this.changeContentEvent.fire();
        },
        setBody: function (R) {
            var Q = this.body || (this.body = B());
            if (R.nodeName) {
                Q.innerHTML = "";
                Q.appendChild(R);
            } else {
                Q.innerHTML = R;
            }
            this.changeBodyEvent.fire(R);
            this.changeContentEvent.fire();
        },
        appendToBody: function (R) {
            var Q = this.body || (this.body = B());
            Q.appendChild(R);
            this.changeBodyEvent.fire(R);
            this.changeContentEvent.fire();
        },
        setFooter: function (R) {
            var Q = this.footer || (this.footer = C());
            if (R.nodeName) {
                Q.innerHTML = "";
                Q.appendChild(R);
            } else {
                Q.innerHTML = R;
            }
            this.changeFooterEvent.fire(R);
            this.changeContentEvent.fire();
        },
        appendToFooter: function (R) {
            var Q = this.footer || (this.footer = C());
            Q.appendChild(R);
            this.changeFooterEvent.fire(R);
            this.changeContentEvent.fire();
        },
        render: function (S, Q) {
            var T = this,
                U;

            function R(V) {
                if (typeof V == "string") {
                    V = document.getElementById(V);
                }
                if (V) {
                    T._addToParent(V, T.element);
                    T.appendEvent.fire();
                }
            }
            this.beforeRenderEvent.fire();
            if (!Q) {
                Q = this.element;
            }
            if (S) {
                R(S);
            } else {
                if (!F.inDocument(this.element)) {
                    return false;
                }
            } if (this.header && !F.inDocument(this.header)) {
                U = Q.firstElementChild;
                if (U) {
                    Q.insertBefore(this.header, U);
                } else {
                    Q.appendChild(this.header);
                }
            }
            if (this.body && !F.inDocument(this.body)) {
                if (this.footer && F.isAncestor(this.moduleElement, this.footer)) {
                    Q.insertBefore(this.body, this.footer);
                } else {
                    Q.appendChild(this.body);
                }
            }
            if (this.footer && !F.inDocument(this.footer)) {
                Q.appendChild(this.footer);
            }
            this.renderEvent.fire();
            return true;
        },
        destroy: function () {
            var Q;
            if (this.element) {
                N.purgeElement(this.element, true);
                Q = this.element.parentNode;
            }
            if (Q) {
                Q.removeChild(this.element);
            }
            this.element = null;
            this.header = null;
            this.body = null;
            this.footer = null;
            G.textResizeEvent.unsubscribe(this.onDomResize, this);
            this.cfg.destroy();
            this.cfg = null;
            this.destroyEvent.fire();
        },
        show: function () {
            this.cfg.setProperty("visible", true);
        },
        hide: function () {
            this.cfg.setProperty("visible", false);
        },
        configVisible: function (R, Q, S) {
            var T = Q[0];
            if (T) {
                this.beforeShowEvent.fire();
                F.setStyle(this.element, "display", "block");
                this.showEvent.fire();
            } else {
                this.beforeHideEvent.fire();
                F.setStyle(this.element, "display", "none");
                this.hideEvent.fire();
            }
        },
        configMonitorResize: function (S, R, T) {
            var Q = R[0];
            if (Q) {
                this.initResizeMonitor();
            } else {
                G.textResizeEvent.unsubscribe(this.onDomResize, this, true);
                this.resizeMonitor = null;
            }
        },
        _addToParent: function (Q, R) {
            if (!this.cfg.getProperty("appendtodocumentbody") && Q === document.body && Q.firstElementChild) {
                Q.insertBefore(R, Q.firstElementChild);
            } else {
                Q.appendChild(R);
            }
        },
        toString: function () {
            return "Module " + this.id;
        }
    };
    YAHOO.lang.augmentProto(G, YAHOO.util.EventProvider);
}());
(function () {
    YAHOO.widget.Overlay = function (P, O) {
        YAHOO.widget.Overlay.superclass.constructor.call(this, P, O);
    };
    var I = YAHOO.lang,
        M = YAHOO.util.CustomEvent,
        G = YAHOO.widget.Module,
        N = YAHOO.util.Event,
        F = YAHOO.util.Dom,
        D = YAHOO.util.Config,
        K = YAHOO.env.ua,
        B = YAHOO.widget.Overlay,
        H = "subscribe",
        E = "unsubscribe",
        C = "contained",
        J, A = {
            "BEFORE_MOVE": "beforeMove",
            "MOVE": "move"
        },
        L = {
            "X": {
                key: "x",
                validator: I.isNumber,
                suppressEvent: true,
                supercedes: ["iframe"]
            },
            "Y": {
                key: "y",
                validator: I.isNumber,
                suppressEvent: true,
                supercedes: ["iframe"]
            },
            "XY": {
                key: "xy",
                suppressEvent: true,
                supercedes: ["iframe"]
            },
            "CONTEXT": {
                key: "context",
                suppressEvent: true,
                supercedes: ["iframe"]
            },
            "FIXED_CENTER": {
                key: "fixedcenter",
                value: false,
                supercedes: ["iframe", "visible"]
            },
            "WIDTH": {
                key: "width",
                suppressEvent: true,
                supercedes: ["context", "fixedcenter", "iframe"]
            },
            "HEIGHT": {
                key: "height",
                suppressEvent: true,
                supercedes: ["context", "fixedcenter", "iframe"]
            },
            "AUTO_FILL_HEIGHT": {
                key: "autofillheight",
                supercedes: ["height"],
                value: "body"
            },
            "ZINDEX": {
                key: "zindex",
                value: null
            },
            "CONSTRAIN_TO_VIEWPORT": {
                key: "constraintoviewport",
                value: false,
                validator: I.isBoolean,
                supercedes: ["iframe", "x", "y", "xy"]
            },
            "IFRAME": {
                key: "iframe",
                value: (K.ie == 6 ? true : false),
                validator: I.isBoolean,
                supercedes: ["zindex"]
            },
            "PREVENT_CONTEXT_OVERLAP": {
                key: "preventcontextoverlap",
                value: false,
                validator: I.isBoolean,
                supercedes: ["constraintoviewport"]
            }
        };
    B.IFRAME_SRC = "javascript:false;";
    B.IFRAME_OFFSET = 3;
    B.VIEWPORT_OFFSET = 10;
    B.TOP_LEFT = "tl";
    B.TOP_RIGHT = "tr";
    B.BOTTOM_LEFT = "bl";
    B.BOTTOM_RIGHT = "br";
    B.CSS_OVERLAY = "yui-overlay";
    B.STD_MOD_RE = /^\s*?(body|footer|header)\s*?$/i;
    B.windowScrollEvent = new M("windowScroll");
    B.windowResizeEvent = new M("windowResize");
    B.windowScrollHandler = function (P) {
        var O = N.getTarget(P);
        if (!O || O === window || O === window.document) {
            if (K.ie) {
                if (!window.scrollEnd) {
                    window.scrollEnd = -1;
                }
                clearTimeout(window.scrollEnd);
                window.scrollEnd = setTimeout(function () {
                    B.windowScrollEvent.fire();
                }, 1);
            } else {
                B.windowScrollEvent.fire();
            }
        }
    };
    B.windowResizeHandler = function (O) {
        if (K.ie) {
            if (!window.resizeEnd) {
                window.resizeEnd = -1;
            }
            clearTimeout(window.resizeEnd);
            window.resizeEnd = setTimeout(function () {
                B.windowResizeEvent.fire();
            }, 100);
        } else {
            B.windowResizeEvent.fire();
        }
    };
    B._initialized = null;
    if (B._initialized === null) {
        N.on(window, "scroll", B.windowScrollHandler);
        N.on(window, "resize", B.windowResizeHandler);
        B._initialized = true;
    }
    B._TRIGGER_MAP = {
        "windowScroll": B.windowScrollEvent,
        "windowResize": B.windowResizeEvent,
        "textResize": G.textResizeEvent
    };
    YAHOO.extend(B, G, {
        CONTEXT_TRIGGERS: [],
        init: function (P, O) {
            B.superclass.init.call(this, P);
            this.beforeInitEvent.fire(B);
            F.addClass(this.element, B.CSS_OVERLAY);
            if (O) {
                this.cfg.applyConfig(O, true);
            }
            if (this.platform == "mac" && K.gecko) {
                if (!D.alreadySubscribed(this.showEvent, this.showMacGeckoScrollbars, this)) {
                    this.showEvent.subscribe(this.showMacGeckoScrollbars, this, true);
                }
                if (!D.alreadySubscribed(this.hideEvent, this.hideMacGeckoScrollbars, this)) {
                    this.hideEvent.subscribe(this.hideMacGeckoScrollbars, this, true);
                }
            }
            this.initEvent.fire(B);
        },
        initEvents: function () {
            B.superclass.initEvents.call(this);
            var O = M.LIST;
            this.beforeMoveEvent = this.createEvent(A.BEFORE_MOVE);
            this.beforeMoveEvent.signature = O;
            this.moveEvent = this.createEvent(A.MOVE);
            this.moveEvent.signature = O;
        },
        initDefaultConfig: function () {
            B.superclass.initDefaultConfig.call(this);
            var O = this.cfg;
            O.addProperty(L.X.key, {
                handler: this.configX,
                validator: L.X.validator,
                suppressEvent: L.X.suppressEvent,
                supercedes: L.X.supercedes
            });
            O.addProperty(L.Y.key, {
                handler: this.configY,
                validator: L.Y.validator,
                suppressEvent: L.Y.suppressEvent,
                supercedes: L.Y.supercedes
            });
            O.addProperty(L.XY.key, {
                handler: this.configXY,
                suppressEvent: L.XY.suppressEvent,
                supercedes: L.XY.supercedes
            });
            O.addProperty(L.CONTEXT.key, {
                handler: this.configContext,
                suppressEvent: L.CONTEXT.suppressEvent,
                supercedes: L.CONTEXT.supercedes
            });
            O.addProperty(L.FIXED_CENTER.key, {
                handler: this.configFixedCenter,
                value: L.FIXED_CENTER.value,
                validator: L.FIXED_CENTER.validator,
                supercedes: L.FIXED_CENTER.supercedes
            });
            O.addProperty(L.WIDTH.key, {
                handler: this.configWidth,
                suppressEvent: L.WIDTH.suppressEvent,
                supercedes: L.WIDTH.supercedes
            });
            O.addProperty(L.HEIGHT.key, {
                handler: this.configHeight,
                suppressEvent: L.HEIGHT.suppressEvent,
                supercedes: L.HEIGHT.supercedes
            });
            O.addProperty(L.AUTO_FILL_HEIGHT.key, {
                handler: this.configAutoFillHeight,
                value: L.AUTO_FILL_HEIGHT.value,
                validator: this._validateAutoFill,
                supercedes: L.AUTO_FILL_HEIGHT.supercedes
            });
            O.addProperty(L.ZINDEX.key, {
                handler: this.configzIndex,
                value: L.ZINDEX.value
            });
            O.addProperty(L.CONSTRAIN_TO_VIEWPORT.key, {
                handler: this.configConstrainToViewport,
                value: L.CONSTRAIN_TO_VIEWPORT.value,
                validator: L.CONSTRAIN_TO_VIEWPORT.validator,
                supercedes: L.CONSTRAIN_TO_VIEWPORT.supercedes
            });
            O.addProperty(L.IFRAME.key, {
                handler: this.configIframe,
                value: L.IFRAME.value,
                validator: L.IFRAME.validator,
                supercedes: L.IFRAME.supercedes
            });
            O.addProperty(L.PREVENT_CONTEXT_OVERLAP.key, {
                value: L.PREVENT_CONTEXT_OVERLAP.value,
                validator: L.PREVENT_CONTEXT_OVERLAP.validator,
                supercedes: L.PREVENT_CONTEXT_OVERLAP.supercedes
            });
        },
        moveTo: function (O, P) {
            this.cfg.setProperty("xy", [O, P]);
        },
        hideMacGeckoScrollbars: function () {
            F.replaceClass(this.element, "show-scrollbars", "hide-scrollbars");
        },
        showMacGeckoScrollbars: function () {
            F.replaceClass(this.element, "hide-scrollbars", "show-scrollbars");
        },
        _setDomVisibility: function (O) {
            F.setStyle(this.element, "visibility", (O) ? "visible" : "hidden");
            if (O) {
                F.removeClass(this.element, "yui-overlay-hidden");
            } else {
                F.addClass(this.element, "yui-overlay-hidden");
            }
        },
        configVisible: function (R, O, X) {
            var Q = O[0],
                S = F.getStyle(this.element, "visibility"),
                Y = this.cfg.getProperty("effect"),
                V = [],
                U = (this.platform == "mac" && K.gecko),
                g = D.alreadySubscribed,
                W, P, f, c, b, a, d, Z, T;
            if (S == "inherit") {
                f = this.element.parentNode;
                while (f.nodeType != 9 && f.nodeType != 11) {
                    S = F.getStyle(f, "visibility");
                    if (S != "inherit") {
                        break;
                    }
                    f = f.parentNode;
                }
                if (S == "inherit") {
                    S = "visible";
                }
            }
            if (Y) {
                if (Y instanceof Array) {
                    Z = Y.length;
                    for (c = 0; c < Z; c++) {
                        W = Y[c];
                        V[V.length] = W.effect(this, W.duration);
                    }
                } else {
                    V[V.length] = Y.effect(this, Y.duration);
                }
            }
            if (Q) {
                if (U) {
                    this.showMacGeckoScrollbars();
                }
                if (Y) {
                    if (Q) {
                        if (S != "visible" || S === "") {
                            this.beforeShowEvent.fire();
                            T = V.length;
                            for (b = 0; b < T; b++) {
                                P = V[b];
                                if (b === 0 && !g(P.animateInCompleteEvent, this.showEvent.fire, this.showEvent)) {
                                    P.animateInCompleteEvent.subscribe(this.showEvent.fire, this.showEvent, true);
                                }
                                P.animateIn();
                            }
                        }
                    }
                } else {
                    if (S != "visible" || S === "") {
                        this.beforeShowEvent.fire();
                        this._setDomVisibility(true);
                        this.cfg.refireEvent("iframe");
                        this.showEvent.fire();
                    } else {
                        this._setDomVisibility(true);
                    }
                }
            } else {
                if (U) {
                    this.hideMacGeckoScrollbars();
                }
                if (Y) {
                    if (S == "visible") {
                        this.beforeHideEvent.fire();
                        T = V.length;
                        for (a = 0; a < T; a++) {
                            d = V[a];
                            if (a === 0 && !g(d.animateOutCompleteEvent, this.hideEvent.fire, this.hideEvent)) {
                                d.animateOutCompleteEvent.subscribe(this.hideEvent.fire, this.hideEvent, true);
                            }
                            d.animateOut();
                        }
                    } else {
                        if (S === "") {
                            this._setDomVisibility(false);
                        }
                    }
                } else {
                    if (S == "visible" || S === "") {
                        this.beforeHideEvent.fire();
                        this._setDomVisibility(false);
                        this.hideEvent.fire();
                    } else {
                        this._setDomVisibility(false);
                    }
                }
            }
        },
        doCenterOnDOMEvent: function () {
            var O = this.cfg,
                P = O.getProperty("fixedcenter");
            if (O.getProperty("visible")) {
                if (P && (P !== C || this.fitsInViewport())) {
                    this.center();
                }
            }
        },
        fitsInViewport: function () {
            var S = B.VIEWPORT_OFFSET,
                Q = this.element,
                T = Q.offsetWidth,
                R = Q.offsetHeight,
                O = F.getViewportWidth(),
                P = F.getViewportHeight();
            return ((T + S < O) && (R + S < P));
        },
        configFixedCenter: function (S, Q, T) {
            var U = Q[0],
                P = D.alreadySubscribed,
                R = B.windowResizeEvent,
                O = B.windowScrollEvent;
            if (U) {
                this.center();
                if (!P(this.beforeShowEvent, this.center)) {
                    this.beforeShowEvent.subscribe(this.center);
                }
                if (!P(R, this.doCenterOnDOMEvent, this)) {
                    R.subscribe(this.doCenterOnDOMEvent, this, true);
                }
                if (!P(O, this.doCenterOnDOMEvent, this)) {
                    O.subscribe(this.doCenterOnDOMEvent, this, true);
                }
            } else {
                this.beforeShowEvent.unsubscribe(this.center);
                R.unsubscribe(this.doCenterOnDOMEvent, this);
                O.unsubscribe(this.doCenterOnDOMEvent, this);
            }
        },
        configHeight: function (R, P, S) {
            var O = P[0],
                Q = this.element;
            F.setStyle(Q, "height", O);
            this.cfg.refireEvent("iframe");
        },
        configAutoFillHeight: function (T, S, P) {
            var V = S[0],
                Q = this.cfg,
                U = "autofillheight",
                W = "height",
                R = Q.getProperty(U),
                O = this._autoFillOnHeightChange;
            Q.unsubscribeFromConfigEvent(W, O);
            G.textResizeEvent.unsubscribe(O);
            this.changeContentEvent.unsubscribe(O);
            if (R && V !== R && this[R]) {
                F.setStyle(this[R], W, "");
            }
            if (V) {
                V = I.trim(V.toLowerCase());
                Q.subscribeToConfigEvent(W, O, this[V], this);
                G.textResizeEvent.subscribe(O, this[V], this);
                this.changeContentEvent.subscribe(O, this[V], this);
                Q.setProperty(U, V, true);
            }
        },
        configWidth: function (R, O, S) {
            var Q = O[0],
                P = this.element;
            F.setStyle(P, "width", Q);
            this.cfg.refireEvent("iframe");
        },
        configzIndex: function (Q, O, R) {
            var S = O[0],
                P = this.element;
            if (!S) {
                S = F.getStyle(P, "zIndex");
                if (!S || isNaN(S)) {
                    S = 0;
                }
            }
            if (this.iframe || this.cfg.getProperty("iframe") === true) {
                if (S <= 0) {
                    S = 1;
                }
            }
            F.setStyle(P, "zIndex", S);
            this.cfg.setProperty("zIndex", S, true);
            if (this.iframe) {
                this.stackIframe();
            }
        },
        configXY: function (Q, P, R) {
            var T = P[0],
                O = T[0],
                S = T[1];
            this.cfg.setProperty("x", O);
            this.cfg.setProperty("y", S);
            this.beforeMoveEvent.fire([O, S]);
            O = this.cfg.getProperty("x");
            S = this.cfg.getProperty("y");
            this.cfg.refireEvent("iframe");
            this.moveEvent.fire([O, S]);
        },
        configX: function (Q, P, R) {
            var O = P[0],
                S = this.cfg.getProperty("y");
            this.cfg.setProperty("x", O, true);
            this.cfg.setProperty("y", S, true);
            this.beforeMoveEvent.fire([O, S]);
            O = this.cfg.getProperty("x");
            S = this.cfg.getProperty("y");
            F.setX(this.element, O, true);
            this.cfg.setProperty("xy", [O, S], true);
            this.cfg.refireEvent("iframe");
            this.moveEvent.fire([O, S]);
        },
        configY: function (Q, P, R) {
            var O = this.cfg.getProperty("x"),
                S = P[0];
            this.cfg.setProperty("x", O, true);
            this.cfg.setProperty("y", S, true);
            this.beforeMoveEvent.fire([O, S]);
            O = this.cfg.getProperty("x");
            S = this.cfg.getProperty("y");
            F.setY(this.element, S, true);
            this.cfg.setProperty("xy", [O, S], true);
            this.cfg.refireEvent("iframe");
            this.moveEvent.fire([O, S]);
        },
        showIframe: function () {
            var P = this.iframe,
                O;
            if (P) {
                O = this.element.parentNode;
                if (O != P.parentNode) {
                    this._addToParent(O, P);
                }
                P.style.display = "block";
            }
        },
        hideIframe: function () {
            if (this.iframe) {
                this.iframe.style.display = "none";
            }
        },
        syncIframe: function () {
            var O = this.iframe,
                Q = this.element,
                S = B.IFRAME_OFFSET,
                P = (S * 2),
                R;
            if (O) {
                O.style.width = (Q.offsetWidth + P + "px");
                O.style.height = (Q.offsetHeight + P + "px");
                R = this.cfg.getProperty("xy");
                if (!I.isArray(R) || (isNaN(R[0]) || isNaN(R[1]))) {
                    this.syncPosition();
                    R = this.cfg.getProperty("xy");
                }
                F.setXY(O, [(R[0] - S), (R[1] - S)]);
            }
        },
        stackIframe: function () {
            if (this.iframe) {
                var O = F.getStyle(this.element, "zIndex");
                if (!YAHOO.lang.isUndefined(O) && !isNaN(O)) {
                    F.setStyle(this.iframe, "zIndex", (O - 1));
                }
            }
        },
        configIframe: function (R, Q, S) {
            var O = Q[0];

            function T() {
                var V = this.iframe,
                    W = this.element,
                    X;
                if (!V) {
                    if (!J) {
                        J = document.createElement("iframe");
                        if (this.isSecure) {
                            J.src = B.IFRAME_SRC;
                        }
                        if (K.ie) {
                            J.style.filter = "alpha(opacity=0)";
                            J.frameBorder = 0;
                        } else {
                            J.style.opacity = "0";
                        }
                        J.style.position = "absolute";
                        J.style.border = "none";
                        J.style.margin = "0";
                        J.style.padding = "0";
                        J.style.display = "none";
                        J.tabIndex = -1;
                    }
                    V = J.cloneNode(false);
                    X = W.parentNode;
                    var U = X || document.body;
                    this._addToParent(U, V);
                    this.iframe = V;
                }
                this.showIframe();
                this.syncIframe();
                this.stackIframe();
                if (!this._hasIframeEventListeners) {
                    this.showEvent.subscribe(this.showIframe);
                    this.hideEvent.subscribe(this.hideIframe);
                    this.changeContentEvent.subscribe(this.syncIframe);
                    this._hasIframeEventListeners = true;
                }
            }

            function P() {
                T.call(this);
                this.beforeShowEvent.unsubscribe(P);
                this._iframeDeferred = false;
            }
            if (O) {
                if (this.cfg.getProperty("visible")) {
                    T.call(this);
                } else {
                    if (!this._iframeDeferred) {
                        this.beforeShowEvent.subscribe(P);
                        this._iframeDeferred = true;
                    }
                }
            } else {
                this.hideIframe();
                if (this._hasIframeEventListeners) {
                    this.showEvent.unsubscribe(this.showIframe);
                    this.hideEvent.unsubscribe(this.hideIframe);
                    this.changeContentEvent.unsubscribe(this.syncIframe);
                    this._hasIframeEventListeners = false;
                }
            }
        },
        _primeXYFromDOM: function () {
            if (YAHOO.lang.isUndefined(this.cfg.getProperty("xy"))) {
                this.syncPosition();
                this.cfg.refireEvent("xy");
                this.beforeShowEvent.unsubscribe(this._primeXYFromDOM);
            }
        },
        configConstrainToViewport: function (P, O, Q) {
            var R = O[0];
            if (R) {
                if (!D.alreadySubscribed(this.beforeMoveEvent, this.enforceConstraints, this)) {
                    this.beforeMoveEvent.subscribe(this.enforceConstraints, this, true);
                }
                if (!D.alreadySubscribed(this.beforeShowEvent, this._primeXYFromDOM)) {
                    this.beforeShowEvent.subscribe(this._primeXYFromDOM);
                }
            } else {
                this.beforeShowEvent.unsubscribe(this._primeXYFromDOM);
                this.beforeMoveEvent.unsubscribe(this.enforceConstraints, this);
            }
        },
        configContext: function (T, S, P) {
            var W = S[0],
                Q, O, U, R, V = this.CONTEXT_TRIGGERS;
            if (W) {
                Q = W[0];
                O = W[1];
                U = W[2];
                R = W[3];
                if (V && V.length > 0) {
                    R = (R || []).concat(V);
                }
                if (Q) {
                    if (typeof Q == "string") {
                        this.cfg.setProperty("context", [document.getElementById(Q), O, U, R], true);
                    }
                    if (O && U) {
                        this.align(O, U);
                    }
                    if (this._contextTriggers) {
                        this._processTriggers(this._contextTriggers, E, this._alignOnTrigger);
                    }
                    if (R) {
                        this._processTriggers(R, H, this._alignOnTrigger);
                        this._contextTriggers = R;
                    }
                }
            }
        },
        _alignOnTrigger: function (P, O) {
            this.align();
        },
        _findTriggerCE: function (O) {
            var P = null;
            if (O instanceof M) {
                P = O;
            } else {
                if (B._TRIGGER_MAP[O]) {
                    P = B._TRIGGER_MAP[O];
                }
            }
            return P;
        },
        _processTriggers: function (S, U, R) {
            var Q, T;
            for (var P = 0, O = S.length; P < O; ++P) {
                Q = S[P];
                T = this._findTriggerCE(Q);
                if (T) {
                    T[U](R, this, true);
                } else {
                    this[U](Q, R);
                }
            }
        },
        align: function (P, O) {
            var U = this.cfg.getProperty("context"),
                T = this,
                S, R, V;

            function Q(W, X) {
                switch (P) {
                case B.TOP_LEFT:
                    T.moveTo(X, W);
                    break;
                case B.TOP_RIGHT:
                    T.moveTo((X - R.offsetWidth), W);
                    break;
                case B.BOTTOM_LEFT:
                    T.moveTo(X, (W - R.offsetHeight));
                    break;
                case B.BOTTOM_RIGHT:
                    T.moveTo((X - R.offsetWidth), (W - R.offsetHeight));
                    break;
                }
            }
            if (U) {
                S = U[0];
                R = this.element;
                T = this;
                if (!P) {
                    P = U[1];
                }
                if (!O) {
                    O = U[2];
                }
                if (R && S) {
                    V = F.getRegion(S);
                    switch (O) {
                    case B.TOP_LEFT:
                        Q(V.top, V.left);
                        break;
                    case B.TOP_RIGHT:
                        Q(V.top, V.right);
                        break;
                    case B.BOTTOM_LEFT:
                        Q(V.bottom, V.left);
                        break;
                    case B.BOTTOM_RIGHT:
                        Q(V.bottom, V.right);
                        break;
                    }
                }
            }
        },
        enforceConstraints: function (P, O, Q) {
            var S = O[0];
            var R = this.getConstrainedXY(S[0], S[1]);
            this.cfg.setProperty("x", R[0], true);
            this.cfg.setProperty("y", R[1], true);
            this.cfg.setProperty("xy", R, true);
        },
        getConstrainedX: function (V) {
            var S = this,
                O = S.element,
                e = O.offsetWidth,
                c = B.VIEWPORT_OFFSET,
                h = F.getViewportWidth(),
                d = F.getDocumentScrollLeft(),
                Y = (e + c < h),
                b = this.cfg.getProperty("context"),
                Q, X, j, T = false,
                f, W, g = d + c,
                P = d + h - e - c,
                i = V,
                U = {
                    "tltr": true,
                    "blbr": true,
                    "brbl": true,
                    "trtl": true
                };
            var Z = function () {
                var k;
                if ((S.cfg.getProperty("x") - d) > X) {
                    k = (X - e);
                } else {
                    k = (X + j);
                }
                S.cfg.setProperty("x", (k + d), true);
                return k;
            };
            var R = function () {
                if ((S.cfg.getProperty("x") - d) > X) {
                    return (W - c);
                } else {
                    return (f - c);
                }
            };
            var a = function () {
                var k = R(),
                    l;
                if (e > k) {
                    if (T) {
                        Z();
                    } else {
                        Z();
                        T = true;
                        l = a();
                    }
                }
                return l;
            };
            if (V < g || V > P) {
                if (Y) {
                    if (this.cfg.getProperty("preventcontextoverlap") && b && U[(b[1] + b[2])]) {
                        Q = b[0];
                        X = F.getX(Q) - d;
                        j = Q.offsetWidth;
                        f = X;
                        W = (h - (X + j));
                        a();
                        i = this.cfg.getProperty("x");
                    } else {
                        if (V < g) {
                            i = g;
                        } else {
                            if (V > P) {
                                i = P;
                            }
                        }
                    }
                } else {
                    i = c + d;
                }
            }
            return i;
        },
        getConstrainedY: function (Z) {
            var W = this,
                P = W.element,
                i = P.offsetHeight,
                h = B.VIEWPORT_OFFSET,
                d = F.getViewportHeight(),
                g = F.getDocumentScrollTop(),
                e = (i + h < d),
                f = this.cfg.getProperty("context"),
                U, a, b, X = false,
                V, Q, c = g + h,
                S = g + d - i - h,
                O = Z,
                Y = {
                    "trbr": true,
                    "tlbl": true,
                    "bltl": true,
                    "brtr": true
                };
            var T = function () {
                var k;
                if ((W.cfg.getProperty("y") - g) > a) {
                    k = (a - i);
                } else {
                    k = (a + b);
                }
                W.cfg.setProperty("y", (k + g), true);
                return k;
            };
            var R = function () {
                if ((W.cfg.getProperty("y") - g) > a) {
                    return (Q - h);
                } else {
                    return (V - h);
                }
            };
            var j = function () {
                var l = R(),
                    k;
                if (i > l) {
                    if (X) {
                        T();
                    } else {
                        T();
                        X = true;
                        k = j();
                    }
                }
                return k;
            };
            if (Z < c || Z > S) {
                if (e) {
                    if (this.cfg.getProperty("preventcontextoverlap") && f && Y[(f[1] + f[2])]) {
                        U = f[0];
                        b = U.offsetHeight;
                        a = (F.getY(U) - g);
                        V = a;
                        Q = (d - (a + b));
                        j();
                        O = W.cfg.getProperty("y");
                    } else {
                        if (Z < c) {
                            O = c;
                        } else {
                            if (Z > S) {
                                O = S;
                            }
                        }
                    }
                } else {
                    O = h + g;
                }
            }
            return O;
        },
        getConstrainedXY: function (O, P) {
            return [this.getConstrainedX(O), this.getConstrainedY(P)];
        },
        center: function () {
            var R = B.VIEWPORT_OFFSET,
                S = this.element.offsetWidth,
                Q = this.element.offsetHeight,
                P = F.getViewportWidth(),
                T = F.getViewportHeight(),
                O, U;
            if (S < P) {
                O = (P / 2) - (S / 2) + F.getDocumentScrollLeft();
            } else {
                O = R + F.getDocumentScrollLeft();
            } if (Q < T) {
                U = (T / 2) - (Q / 2) + F.getDocumentScrollTop();
            } else {
                U = R + F.getDocumentScrollTop();
            }
            this.cfg.setProperty("xy", [parseInt(O, 10), parseInt(U, 10)]);
            this.cfg.refireEvent("iframe");
            if (K.webkit) {
                this.forceContainerRedraw();
            }
        },
        syncPosition: function () {
            var O = F.getXY(this.element);
            this.cfg.setProperty("x", O[0], true);
            this.cfg.setProperty("y", O[1], true);
            this.cfg.setProperty("xy", O, true);
        },
        onDomResize: function (Q, P) {
            var O = this;
            B.superclass.onDomResize.call(this, Q, P);
            setTimeout(function () {
                O.syncPosition();
                O.cfg.refireEvent("iframe");
                O.cfg.refireEvent("context");
            }, 0);
        },
        _getComputedHeight: (function () {
            if (document.defaultView && document.defaultView.getComputedStyle) {
                return function (P) {
                    var O = null;
                    if (P.ownerDocument && P.ownerDocument.defaultView) {
                        var Q = P.ownerDocument.defaultView.getComputedStyle(P, "");
                        if (Q) {
                            O = parseInt(Q.height, 10);
                        }
                    }
                    return (I.isNumber(O)) ? O : null;
                };
            } else {
                return function (P) {
                    var O = null;
                    if (P.style.pixelHeight) {
                        O = P.style.pixelHeight;
                    }
                    return (I.isNumber(O)) ? O : null;
                };
            }
        })(),
        _validateAutoFillHeight: function (O) {
            return (!O) || (I.isString(O) && B.STD_MOD_RE.test(O));
        },
        _autoFillOnHeightChange: function (R, P, Q) {
            var O = this.cfg.getProperty("height");
            if ((O && O !== "auto") || (O === 0)) {
                this.fillHeight(Q);
            }
        },
        _getPreciseHeight: function (P) {
            var O = P.offsetHeight;
            if (P.getBoundingClientRect) {
                var Q = P.getBoundingClientRect();
                O = Q.bottom - Q.top;
            }
            return O;
        },
        fillHeight: function (R) {
            if (R) {
                var P = this.innerElement || this.element,
                    O = [this.header, this.body, this.footer],
                    V, W = 0,
                    X = 0,
                    T = 0,
                    Q = false;
                for (var U = 0, S = O.length; U < S; U++) {
                    V = O[U];
                    if (V) {
                        if (R !== V) {
                            X += this._getPreciseHeight(V);
                        } else {
                            Q = true;
                        }
                    }
                }
                if (Q) {
                    if (K.ie || K.opera) {
                        F.setStyle(R, "height", 0 + "px");
                    }
                    W = this._getComputedHeight(P);
                    if (W === null) {
                        F.addClass(P, "yui-override-padding");
                        W = P.clientHeight;
                        F.removeClass(P, "yui-override-padding");
                    }
                    T = Math.max(W - X, 0);
                    F.setStyle(R, "height", T + "px");
                    if (R.offsetHeight != T) {
                        T = Math.max(T - (R.offsetHeight - T), 0);
                    }
                    F.setStyle(R, "height", T + "px");
                }
            }
        },
        bringToTop: function () {
            var S = [],
                R = this.element;

            function V(Z, Y) {
                var b = F.getStyle(Z, "zIndex"),
                    a = F.getStyle(Y, "zIndex"),
                    X = (!b || isNaN(b)) ? 0 : parseInt(b, 10),
                    W = (!a || isNaN(a)) ? 0 : parseInt(a, 10);
                if (X > W) {
                    return -1;
                } else {
                    if (X < W) {
                        return 1;
                    } else {
                        return 0;
                    }
                }
            }

            function Q(Y) {
                var X = F.hasClass(Y, B.CSS_OVERLAY),
                    W = YAHOO.widget.Panel;
                if (X && !F.isAncestor(R, Y)) {
                    if (W && F.hasClass(Y, W.CSS_PANEL)) {
                        S[S.length] = Y.parentNode;
                    } else {
                        S[S.length] = Y;
                    }
                }
            }
            F.getElementsBy(Q, "DIV", document.body);
            S.sort(V);
            var O = S[0],
                U;
            if (O) {
                U = F.getStyle(O, "zIndex");
                if (!isNaN(U)) {
                    var T = false;
                    if (O != R) {
                        T = true;
                    } else {
                        if (S.length > 1) {
                            var P = F.getStyle(S[1], "zIndex");
                            if (!isNaN(P) && (U == P)) {
                                T = true;
                            }
                        }
                    } if (T) {
                        this.cfg.setProperty("zindex", (parseInt(U, 10) + 2));
                    }
                }
            }
        },
        destroy: function () {
            if (this.iframe) {
                this.iframe.parentNode.removeChild(this.iframe);
            }
            this.iframe = null;
            B.windowResizeEvent.unsubscribe(this.doCenterOnDOMEvent, this);
            B.windowScrollEvent.unsubscribe(this.doCenterOnDOMEvent, this);
            G.textResizeEvent.unsubscribe(this._autoFillOnHeightChange);
            B.superclass.destroy.call(this);
        },
        forceContainerRedraw: function () {
            var O = this;
            F.addClass(O.element, "yui-force-redraw");
            setTimeout(function () {
                F.removeClass(O.element, "yui-force-redraw");
            }, 0);
        },
        toString: function () {
            return "Overlay " + this.id;
        }
    });
}());
(function () {
    YAHOO.widget.OverlayManager = function (G) {
        this.init(G);
    };
    var D = YAHOO.widget.Overlay,
        C = YAHOO.util.Event,
        E = YAHOO.util.Dom,
        B = YAHOO.util.Config,
        F = YAHOO.util.CustomEvent,
        A = YAHOO.widget.OverlayManager;
    A.CSS_FOCUSED = "focused";
    A.prototype = {
        constructor: A,
        overlays: null,
        initDefaultConfig: function () {
            this.cfg.addProperty("overlays", {
                suppressEvent: true
            });
            this.cfg.addProperty("focusevent", {
                value: "mousedown"
            });
        },
        init: function (I) {
            this.cfg = new B(this);
            this.initDefaultConfig();
            if (I) {
                this.cfg.applyConfig(I, true);
            }
            this.cfg.fireQueue();
            var H = null;
            this.getActive = function () {
                return H;
            };
            this.focus = function (J) {
                var K = this.find(J);
                if (K) {
                    K.focus();
                }
            };
            this.remove = function (K) {
                var M = this.find(K),
                    J;
                if (M) {
                    if (H == M) {
                        H = null;
                    }
                    var L = (M.element === null && M.cfg === null) ? true : false;
                    if (!L) {
                        J = E.getStyle(M.element, "zIndex");
                        M.cfg.setProperty("zIndex", -1000, true);
                    }
                    this.overlays.sort(this.compareZIndexDesc);
                    this.overlays = this.overlays.slice(0, (this.overlays.length - 1));
                    M.hideEvent.unsubscribe(M.blur);
                    M.destroyEvent.unsubscribe(this._onOverlayDestroy, M);
                    M.focusEvent.unsubscribe(this._onOverlayFocusHandler, M);
                    M.blurEvent.unsubscribe(this._onOverlayBlurHandler, M);
                    if (!L) {
                        C.removeListener(M.element, this.cfg.getProperty("focusevent"), this._onOverlayElementFocus);
                        M.cfg.setProperty("zIndex", J, true);
                        M.cfg.setProperty("manager", null);
                    }
                    if (M.focusEvent._managed) {
                        M.focusEvent = null;
                    }
                    if (M.blurEvent._managed) {
                        M.blurEvent = null;
                    }
                    if (M.focus._managed) {
                        M.focus = null;
                    }
                    if (M.blur._managed) {
                        M.blur = null;
                    }
                }
            };
            this.blurAll = function () {
                var K = this.overlays.length,
                    J;
                if (K > 0) {
                    J = K - 1;
                    do {
                        this.overlays[J].blur();
                    } while (J--);
                }
            };
            this._manageBlur = function (J) {
                var K = false;
                if (H == J) {
                    E.removeClass(H.element, A.CSS_FOCUSED);
                    H = null;
                    K = true;
                }
                return K;
            };
            this._manageFocus = function (J) {
                var K = false;
                if (H != J) {
                    if (H) {
                        H.blur();
                    }
                    H = J;
                    this.bringToTop(H);
                    E.addClass(H.element, A.CSS_FOCUSED);
                    K = true;
                }
                return K;
            };
            var G = this.cfg.getProperty("overlays");
            if (!this.overlays) {
                this.overlays = [];
            }
            if (G) {
                this.register(G);
                this.overlays.sort(this.compareZIndexDesc);
            }
        },
        _onOverlayElementFocus: function (I) {
            var G = C.getTarget(I),
                H = this.close;
            if (H && (G == H || E.isAncestor(H, G))) {
                this.blur();
            } else {
                this.focus();
            }
        },
        _onOverlayDestroy: function (H, G, I) {
            this.remove(I);
        },
        _onOverlayFocusHandler: function (H, G, I) {
            this._manageFocus(I);
        },
        _onOverlayBlurHandler: function (H, G, I) {
            this._manageBlur(I);
        },
        _bindFocus: function (G) {
            var H = this;
            if (!G.focusEvent) {
                G.focusEvent = G.createEvent("focus");
                G.focusEvent.signature = F.LIST;
                G.focusEvent._managed = true;
            } else {
                G.focusEvent.subscribe(H._onOverlayFocusHandler, G, H);
            } if (!G.focus) {
                C.on(G.element, H.cfg.getProperty("focusevent"), H._onOverlayElementFocus, null, G);
                G.focus = function () {
                    if (H._manageFocus(this)) {
                        if (this.cfg.getProperty("visible") && this.focusFirst) {
                            this.focusFirst();
                        }
                        this.focusEvent.fire();
                    }
                };
                G.focus._managed = true;
            }
        },
        _bindBlur: function (G) {
            var H = this;
            if (!G.blurEvent) {
                G.blurEvent = G.createEvent("blur");
                G.blurEvent.signature = F.LIST;
                G.focusEvent._managed = true;
            } else {
                G.blurEvent.subscribe(H._onOverlayBlurHandler, G, H);
            } if (!G.blur) {
                G.blur = function () {
                    if (H._manageBlur(this)) {
                        this.blurEvent.fire();
                    }
                };
                G.blur._managed = true;
            }
            G.hideEvent.subscribe(G.blur);
        },
        _bindDestroy: function (G) {
            var H = this;
            G.destroyEvent.subscribe(H._onOverlayDestroy, G, H);
        },
        _syncZIndex: function (G) {
            var H = E.getStyle(G.element, "zIndex");
            if (!isNaN(H)) {
                G.cfg.setProperty("zIndex", parseInt(H, 10));
            } else {
                G.cfg.setProperty("zIndex", 0);
            }
        },
        register: function (G) {
            var J = false,
                H, I;
            if (G instanceof D) {
                G.cfg.addProperty("manager", {
                    value: this
                });
                this._bindFocus(G);
                this._bindBlur(G);
                this._bindDestroy(G);
                this._syncZIndex(G);
                this.overlays.push(G);
                this.bringToTop(G);
                J = true;
            } else {
                if (G instanceof Array) {
                    for (H = 0, I = G.length; H < I; H++) {
                        J = this.register(G[H]) || J;
                    }
                }
            }
            return J;
        },
        bringToTop: function (M) {
            var I = this.find(M),
                L, G, J;
            if (I) {
                J = this.overlays;
                J.sort(this.compareZIndexDesc);
                G = J[0];
                if (G) {
                    L = E.getStyle(G.element, "zIndex");
                    if (!isNaN(L)) {
                        var K = false;
                        if (G !== I) {
                            K = true;
                        } else {
                            if (J.length > 1) {
                                var H = E.getStyle(J[1].element, "zIndex");
                                if (!isNaN(H) && (L == H)) {
                                    K = true;
                                }
                            }
                        } if (K) {
                            I.cfg.setProperty("zindex", (parseInt(L, 10) + 2));
                        }
                    }
                    J.sort(this.compareZIndexDesc);
                }
            }
        },
        find: function (G) {
            var K = G instanceof D,
                I = this.overlays,
                M = I.length,
                J = null,
                L, H;
            if (K || typeof G == "string") {
                for (H = M - 1; H >= 0; H--) {
                    L = I[H];
                    if ((K && (L === G)) || (L.id == G)) {
                        J = L;
                        break;
                    }
                }
            }
            return J;
        },
        compareZIndexDesc: function (J, I) {
            var H = (J.cfg) ? J.cfg.getProperty("zIndex") : null,
                G = (I.cfg) ? I.cfg.getProperty("zIndex") : null;
            if (H === null && G === null) {
                return 0;
            } else {
                if (H === null) {
                    return 1;
                } else {
                    if (G === null) {
                        return -1;
                    } else {
                        if (H > G) {
                            return -1;
                        } else {
                            if (H < G) {
                                return 1;
                            } else {
                                return 0;
                            }
                        }
                    }
                }
            }
        },
        showAll: function () {
            var H = this.overlays,
                I = H.length,
                G;
            for (G = I - 1; G >= 0; G--) {
                H[G].show();
            }
        },
        hideAll: function () {
            var H = this.overlays,
                I = H.length,
                G;
            for (G = I - 1; G >= 0; G--) {
                H[G].hide();
            }
        },
        toString: function () {
            return "OverlayManager";
        }
    };
}());
(function () {
    YAHOO.widget.Tooltip = function (P, O) {
        YAHOO.widget.Tooltip.superclass.constructor.call(this, P, O);
    };
    var E = YAHOO.lang,
        N = YAHOO.util.Event,
        M = YAHOO.util.CustomEvent,
        C = YAHOO.util.Dom,
        J = YAHOO.widget.Tooltip,
        H = YAHOO.env.ua,
        G = (H.ie && (H.ie <= 6 || document.compatMode == "BackCompat")),
        F, I = {
            "PREVENT_OVERLAP": {
                key: "preventoverlap",
                value: true,
                validator: E.isBoolean,
                supercedes: ["x", "y", "xy"]
            },
            "SHOW_DELAY": {
                key: "showdelay",
                value: 200,
                validator: E.isNumber
            },
            "AUTO_DISMISS_DELAY": {
                key: "autodismissdelay",
                value: 5000,
                validator: E.isNumber
            },
            "HIDE_DELAY": {
                key: "hidedelay",
                value: 250,
                validator: E.isNumber
            },
            "TEXT": {
                key: "text",
                suppressEvent: true
            },
            "CONTAINER": {
                key: "container"
            },
            "DISABLED": {
                key: "disabled",
                value: false,
                suppressEvent: true
            }
        },
        A = {
            "CONTEXT_MOUSE_OVER": "contextMouseOver",
            "CONTEXT_MOUSE_OUT": "contextMouseOut",
            "CONTEXT_TRIGGER": "contextTrigger"
        };
    J.CSS_TOOLTIP = "yui-tt";

    function K(Q, O) {
        var P = this.cfg,
            R = P.getProperty("width");
        if (R == O) {
            P.setProperty("width", Q);
        }
    }

    function D(P, O) {
        if ("_originalWidth" in this) {
            K.call(this, this._originalWidth, this._forcedWidth);
        }
        var Q = document.body,
            U = this.cfg,
            T = U.getProperty("width"),
            R, S;
        if ((!T || T == "auto") && (U.getProperty("container") != Q || U.getProperty("x") >= C.getViewportWidth() || U.getProperty("y") >= C.getViewportHeight())) {
            S = this.element.cloneNode(true);
            S.style.visibility = "hidden";
            S.style.top = "0px";
            S.style.left = "0px";
            Q.appendChild(S);
            R = (S.offsetWidth + "px");
            Q.removeChild(S);
            S = null;
            U.setProperty("width", R);
            U.refireEvent("xy");
            this._originalWidth = T || "";
            this._forcedWidth = R;
        }
    }

    function B(P, O, Q) {
        this.render(Q);
    }

    function L() {
        N.onDOMReady(B, this.cfg.getProperty("container"), this);
    }
    YAHOO.extend(J, YAHOO.widget.Overlay, {
        init: function (P, O) {
            J.superclass.init.call(this, P);
            this.beforeInitEvent.fire(J);
            C.addClass(this.element, J.CSS_TOOLTIP);
            if (O) {
                this.cfg.applyConfig(O, true);
            }
            this.cfg.queueProperty("visible", false);
            this.cfg.queueProperty("constraintoviewport", true);
            this.setBody("");
            this.subscribe("changeContent", D);
            this.subscribe("init", L);
            this.subscribe("render", this.onRender);
            this.initEvent.fire(J);
        },
        initEvents: function () {
            J.superclass.initEvents.call(this);
            var O = M.LIST;
            this.contextMouseOverEvent = this.createEvent(A.CONTEXT_MOUSE_OVER);
            this.contextMouseOverEvent.signature = O;
            this.contextMouseOutEvent = this.createEvent(A.CONTEXT_MOUSE_OUT);
            this.contextMouseOutEvent.signature = O;
            this.contextTriggerEvent = this.createEvent(A.CONTEXT_TRIGGER);
            this.contextTriggerEvent.signature = O;
        },
        initDefaultConfig: function () {
            J.superclass.initDefaultConfig.call(this);
            this.cfg.addProperty(I.PREVENT_OVERLAP.key, {
                value: I.PREVENT_OVERLAP.value,
                validator: I.PREVENT_OVERLAP.validator,
                supercedes: I.PREVENT_OVERLAP.supercedes
            });
            this.cfg.addProperty(I.SHOW_DELAY.key, {
                handler: this.configShowDelay,
                value: 200,
                validator: I.SHOW_DELAY.validator
            });
            this.cfg.addProperty(I.AUTO_DISMISS_DELAY.key, {
                handler: this.configAutoDismissDelay,
                value: I.AUTO_DISMISS_DELAY.value,
                validator: I.AUTO_DISMISS_DELAY.validator
            });
            this.cfg.addProperty(I.HIDE_DELAY.key, {
                handler: this.configHideDelay,
                value: I.HIDE_DELAY.value,
                validator: I.HIDE_DELAY.validator
            });
            this.cfg.addProperty(I.TEXT.key, {
                handler: this.configText,
                suppressEvent: I.TEXT.suppressEvent
            });
            this.cfg.addProperty(I.CONTAINER.key, {
                handler: this.configContainer,
                value: document.body
            });
            this.cfg.addProperty(I.DISABLED.key, {
                handler: this.configContainer,
                value: I.DISABLED.value,
                supressEvent: I.DISABLED.suppressEvent
            });
        },
        configText: function (P, O, Q) {
            var R = O[0];
            if (R) {
                this.setBody(R);
            }
        },
        configContainer: function (Q, P, R) {
            var O = P[0];
            if (typeof O == "string") {
                this.cfg.setProperty("container", document.getElementById(O), true);
            }
        },
        _removeEventListeners: function () {
            var R = this._context,
                O, Q, P;
            if (R) {
                O = R.length;
                if (O > 0) {
                    P = O - 1;
                    do {
                        Q = R[P];
                        N.removeListener(Q, "mouseover", this.onContextMouseOver);
                        N.removeListener(Q, "mousemove", this.onContextMouseMove);
                        N.removeListener(Q, "mouseout", this.onContextMouseOut);
                    } while (P--);
                }
            }
        },
        configContext: function (T, P, U) {
            var S = P[0],
                V, O, R, Q;
            if (S) {
                if (!(S instanceof Array)) {
                    if (typeof S == "string") {
                        this.cfg.setProperty("context", [document.getElementById(S)], true);
                    } else {
                        this.cfg.setProperty("context", [S], true);
                    }
                    S = this.cfg.getProperty("context");
                }
                this._removeEventListeners();
                this._context = S;
                V = this._context;
                if (V) {
                    O = V.length;
                    if (O > 0) {
                        Q = O - 1;
                        do {
                            R = V[Q];
                            N.on(R, "mouseover", this.onContextMouseOver, this);
                            N.on(R, "mousemove", this.onContextMouseMove, this);
                            N.on(R, "mouseout", this.onContextMouseOut, this);
                        } while (Q--);
                    }
                }
            }
        },
        onContextMouseMove: function (P, O) {
            O.pageX = N.getPageX(P);
            O.pageY = N.getPageY(P);
        },
        onContextMouseOver: function (Q, P) {
            var O = this;
            if (O.title) {
                P._tempTitle = O.title;
                O.title = "";
            }
            if (P.fireEvent("contextMouseOver", O, Q) !== false && !P.cfg.getProperty("disabled")) {
                if (P.hideProcId) {
                    clearTimeout(P.hideProcId);
                    P.hideProcId = null;
                }
                N.on(O, "mousemove", P.onContextMouseMove, P);
                P.showProcId = P.doShow(Q, O);
            }
        },
        onContextMouseOut: function (Q, P) {
            var O = this;
            if (P._tempTitle) {
                O.title = P._tempTitle;
                P._tempTitle = null;
            }
            if (P.showProcId) {
                clearTimeout(P.showProcId);
                P.showProcId = null;
            }
            if (P.hideProcId) {
                clearTimeout(P.hideProcId);
                P.hideProcId = null;
            }
            P.fireEvent("contextMouseOut", O, Q);
            P.hideProcId = setTimeout(function () {
                P.hide();
            }, P.cfg.getProperty("hidedelay"));
        },
        doShow: function (Q, O) {
            var R = 25,
                P = this;
            if (H.opera && O.tagName && O.tagName.toUpperCase() == "A") {
                R += 12;
            }
            return setTimeout(function () {
                var S = P.cfg.getProperty("text");
                if (P._tempTitle && (S === "" || YAHOO.lang.isUndefined(S) || YAHOO.lang.isNull(S))) {
                    P.setBody(P._tempTitle);
                } else {
                    P.cfg.refireEvent("text");
                }
                P.moveTo(P.pageX, P.pageY + R);
                if (P.cfg.getProperty("preventoverlap")) {
                    P.preventOverlap(P.pageX, P.pageY);
                }
                N.removeListener(O, "mousemove", P.onContextMouseMove);
                P.contextTriggerEvent.fire(O);
                P.show();
                P.hideProcId = P.doHide();
            }, this.cfg.getProperty("showdelay"));
        },
        doHide: function () {
            var O = this;
            return setTimeout(function () {
                O.hide();
            }, this.cfg.getProperty("autodismissdelay"));
        },
        preventOverlap: function (S, R) {
            var O = this.element.offsetHeight,
                Q = new YAHOO.util.Point(S, R),
                P = C.getRegion(this.element);
            P.top -= 5;
            P.left -= 5;
            P.right += 5;
            P.bottom += 5;
            if (P.contains(Q)) {
                this.cfg.setProperty("y", (R - O - 5));
            }
        },
        onRender: function (S, R) {
            function T() {
                var W = this.element,
                    V = this.underlay;
                if (V) {
                    V.style.width = (W.offsetWidth + 6) + "px";
                    V.style.height = (W.offsetHeight + 1) + "px";
                }
            }

            function P() {
                C.addClass(this.underlay, "yui-tt-shadow-visible");
                if (H.ie) {
                    this.forceUnderlayRedraw();
                }
            }

            function O() {
                C.removeClass(this.underlay, "yui-tt-shadow-visible");
            }

            function U() {
                var X = this.underlay,
                    W, V, Z, Y;
                if (!X) {
                    W = this.element;
                    V = YAHOO.widget.Module;
                    Z = H.ie;
                    Y = this;
                    if (!F) {
                        F = document.createElement("div");
                        F.className = "yui-tt-shadow";
                    }
                    X = F.cloneNode(false);
                    W.appendChild(X);
                    this.underlay = X;
                    this._shadow = this.underlay;
                    P.call(this);
                    this.subscribe("beforeShow", P);
                    this.subscribe("hide", O);
                    if (G) {
                        window.setTimeout(function () {
                            T.call(Y);
                        }, 0);
                        this.cfg.subscribeToConfigEvent("width", T);
                        this.cfg.subscribeToConfigEvent("height", T);
                        this.subscribe("changeContent", T);
                        V.textResizeEvent.subscribe(T, this, true);
                        this.subscribe("destroy", function () {
                            V.textResizeEvent.unsubscribe(T, this);
                        });
                    }
                }
            }

            function Q() {
                U.call(this);
                this.unsubscribe("beforeShow", Q);
            }
            if (this.cfg.getProperty("visible")) {
                U.call(this);
            } else {
                this.subscribe("beforeShow", Q);
            }
        },
        forceUnderlayRedraw: function () {
            var O = this;
            C.addClass(O.underlay, "yui-force-redraw");
            setTimeout(function () {
                C.removeClass(O.underlay, "yui-force-redraw");
            }, 0);
        },
        destroy: function () {
            this._removeEventListeners();
            J.superclass.destroy.call(this);
        },
        toString: function () {
            return "Tooltip " + this.id;
        }
    });
}());
(function () {
    YAHOO.widget.Panel = function (V, U) {
        YAHOO.widget.Panel.superclass.constructor.call(this, V, U);
    };
    var S = null;
    var E = YAHOO.lang,
        F = YAHOO.util,
        A = F.Dom,
        T = F.Event,
        M = F.CustomEvent,
        K = YAHOO.util.KeyListener,
        I = F.Config,
        H = YAHOO.widget.Overlay,
        O = YAHOO.widget.Panel,
        L = YAHOO.env.ua,
        P = (L.ie && (L.ie <= 6 || document.compatMode == "BackCompat")),
        G, Q, C, D = {
            "SHOW_MASK": "showMask",
            "HIDE_MASK": "hideMask",
            "DRAG": "drag"
        },
        N = {
            "CLOSE": {
                key: "close",
                value: true,
                validator: E.isBoolean,
                supercedes: ["visible"]

            },
            "DRAGGABLE": {
                key: "draggable",
                value: (F.DD ? true : false),
                validator: E.isBoolean,
                supercedes: ["visible"]
            },
            "DRAG_ONLY": {
                key: "dragonly",
                value: false,
                validator: E.isBoolean,
                supercedes: ["draggable"]
            },
            "UNDERLAY": {
                key: "underlay",
                value: "shadow",
                supercedes: ["visible"]
            },
            "MODAL": {
                key: "modal",
                value: false,
                validator: E.isBoolean,
                supercedes: ["visible", "zindex"]
            },
            "KEY_LISTENERS": {
                key: "keylisteners",
                suppressEvent: true,
                supercedes: ["visible"]
            },
            "STRINGS": {
                key: "strings",
                supercedes: ["close"],
                validator: E.isObject,
                value: {
                    close: "Close"
                }
            }
        };
    O.CSS_PANEL = "yui-panel";
    O.CSS_PANEL_CONTAINER = "yui-panel-container";
    O.FOCUSABLE = ["a", "button", "select", "textarea", "input", "iframe"];

    function J(V, U) {
        if (!this.header && this.cfg.getProperty("draggable")) {
            this.setHeader("&#160;");
        }
    }

    function R(V, U, W) {
        var Z = W[0],
            X = W[1],
            Y = this.cfg,
            a = Y.getProperty("width");
        if (a == X) {
            Y.setProperty("width", Z);
        }
        this.unsubscribe("hide", R, W);
    }

    function B(V, U) {
        var Y, X, W;
        if (P) {
            Y = this.cfg;
            X = Y.getProperty("width");
            if (!X || X == "auto") {
                W = (this.element.offsetWidth + "px");
                Y.setProperty("width", W);
                this.subscribe("hide", R, [(X || ""), W]);
            }
        }
    }
    YAHOO.extend(O, H, {
        init: function (V, U) {
            O.superclass.init.call(this, V);
            this.beforeInitEvent.fire(O);
            A.addClass(this.element, O.CSS_PANEL);
            this.buildWrapper();
            if (U) {
                this.cfg.applyConfig(U, true);
            }
            this.subscribe("showMask", this._addFocusHandlers);
            this.subscribe("hideMask", this._removeFocusHandlers);
            this.subscribe("beforeRender", J);
            this.subscribe("render", function () {
                this.setFirstLastFocusable();
                this.subscribe("changeContent", this.setFirstLastFocusable);
            });
            this.subscribe("show", this.focusFirst);
            this.initEvent.fire(O);
        },
        _onElementFocus: function (Z) {
            if (S === this) {
                var Y = T.getTarget(Z),
                    X = document.documentElement,
                    V = (Y !== X && Y !== window);
                if (V && Y !== this.element && Y !== this.mask && !A.isAncestor(this.element, Y)) {
                    try {
                        if (this.firstElement) {
                            this.firstElement.focus();
                        } else {
                            if (this._modalFocus) {
                                this._modalFocus.focus();
                            } else {
                                this.innerElement.focus();
                            }
                        }
                    } catch (W) {
                        try {
                            if (V && Y !== document.body) {
                                Y.blur();
                            }
                        } catch (U) {}
                    }
                }
            }
        },
        _addFocusHandlers: function (V, U) {
            if (!this.firstElement) {
                if (L.webkit || L.opera) {
                    if (!this._modalFocus) {
                        this._createHiddenFocusElement();
                    }
                } else {
                    this.innerElement.tabIndex = 0;
                }
            }
            this.setTabLoop(this.firstElement, this.lastElement);
            T.onFocus(document.documentElement, this._onElementFocus, this, true);
            S = this;
        },
        _createHiddenFocusElement: function () {
            var U = document.createElement("button");
            U.style.height = "1px";
            U.style.width = "1px";
            U.style.position = "absolute";
            U.style.left = "-10000em";
            U.style.opacity = 0;
            U.tabIndex = -1;
            this.innerElement.appendChild(U);
            this._modalFocus = U;
        },
        _removeFocusHandlers: function (V, U) {
            T.removeFocusListener(document.documentElement, this._onElementFocus, this);
            if (S == this) {
                S = null;
            }
        },
        focusFirst: function (W, U, Y) {
            var V = this.firstElement;
            if (U && U[1]) {
                T.stopEvent(U[1]);
            }
            if (V) {
                try {
                    V.focus();
                } catch (X) {}
            }
        },
        focusLast: function (W, U, Y) {
            var V = this.lastElement;
            if (U && U[1]) {
                T.stopEvent(U[1]);
            }
            if (V) {
                try {
                    V.focus();
                } catch (X) {}
            }
        },
        setTabLoop: function (X, Z) {
            var V = this.preventBackTab,
                W = this.preventTabOut,
                U = this.showEvent,
                Y = this.hideEvent;
            if (V) {
                V.disable();
                U.unsubscribe(V.enable, V);
                Y.unsubscribe(V.disable, V);
                V = this.preventBackTab = null;
            }
            if (W) {
                W.disable();
                U.unsubscribe(W.enable, W);
                Y.unsubscribe(W.disable, W);
                W = this.preventTabOut = null;
            }
            if (X) {
                this.preventBackTab = new K(X, {
                    shift: true,
                    keys: 9
                }, {
                    fn: this.focusLast,
                    scope: this,
                    correctScope: true
                });
                V = this.preventBackTab;
                U.subscribe(V.enable, V, true);
                Y.subscribe(V.disable, V, true);
            }
            if (Z) {
                this.preventTabOut = new K(Z, {
                    shift: false,
                    keys: 9
                }, {
                    fn: this.focusFirst,
                    scope: this,
                    correctScope: true
                });
                W = this.preventTabOut;
                U.subscribe(W.enable, W, true);
                Y.subscribe(W.disable, W, true);
            }
        },
        getFocusableElements: function (U) {
            U = U || this.innerElement;
            var X = {};
            for (var W = 0; W < O.FOCUSABLE.length; W++) {
                X[O.FOCUSABLE[W]] = true;
            }

            function V(Y) {
                if (Y.focus && Y.type !== "hidden" && !Y.disabled && X[Y.tagName.toLowerCase()]) {
                    return true;
                }
                return false;
            }
            return A.getElementsBy(V, null, U);
        },
        setFirstLastFocusable: function () {
            this.firstElement = null;
            this.lastElement = null;
            var U = this.getFocusableElements();
            this.focusableElements = U;
            if (U.length > 0) {
                this.firstElement = U[0];
                this.lastElement = U[U.length - 1];
            }
            if (this.cfg.getProperty("modal")) {
                this.setTabLoop(this.firstElement, this.lastElement);
            }
        },
        initEvents: function () {
            O.superclass.initEvents.call(this);
            var U = M.LIST;
            this.showMaskEvent = this.createEvent(D.SHOW_MASK);
            this.showMaskEvent.signature = U;
            this.hideMaskEvent = this.createEvent(D.HIDE_MASK);
            this.hideMaskEvent.signature = U;
            this.dragEvent = this.createEvent(D.DRAG);
            this.dragEvent.signature = U;
        },
        initDefaultConfig: function () {
            O.superclass.initDefaultConfig.call(this);
            this.cfg.addProperty(N.CLOSE.key, {
                handler: this.configClose,
                value: N.CLOSE.value,
                validator: N.CLOSE.validator,
                supercedes: N.CLOSE.supercedes
            });
            this.cfg.addProperty(N.DRAGGABLE.key, {
                handler: this.configDraggable,
                value: (F.DD) ? true : false,
                validator: N.DRAGGABLE.validator,
                supercedes: N.DRAGGABLE.supercedes
            });
            this.cfg.addProperty(N.DRAG_ONLY.key, {
                value: N.DRAG_ONLY.value,
                validator: N.DRAG_ONLY.validator,
                supercedes: N.DRAG_ONLY.supercedes
            });
            this.cfg.addProperty(N.UNDERLAY.key, {
                handler: this.configUnderlay,
                value: N.UNDERLAY.value,
                supercedes: N.UNDERLAY.supercedes
            });
            this.cfg.addProperty(N.MODAL.key, {
                handler: this.configModal,
                value: N.MODAL.value,
                validator: N.MODAL.validator,
                supercedes: N.MODAL.supercedes
            });
            this.cfg.addProperty(N.KEY_LISTENERS.key, {
                handler: this.configKeyListeners,
                suppressEvent: N.KEY_LISTENERS.suppressEvent,
                supercedes: N.KEY_LISTENERS.supercedes
            });
            this.cfg.addProperty(N.STRINGS.key, {
                value: N.STRINGS.value,
                handler: this.configStrings,
                validator: N.STRINGS.validator,
                supercedes: N.STRINGS.supercedes
            });
        },
        configClose: function (X, V, Y) {
            var Z = V[0],
                W = this.close,
                U = this.cfg.getProperty("strings");
            if (Z) {
                if (!W) {
                    if (!C) {
                        C = document.createElement("a");
                        C.className = "container-close";
                        C.href = "#";
                    }
                    W = C.cloneNode(true);
                    this.innerElement.appendChild(W);
                    W.innerHTML = (U && U.close) ? U.close : "&#160;";
					
                    T.on(W, "click", this._doClose, this, true);
                    this.close = W;
                } else {
                    W.style.display = "block";
                }
            } else {
                if (W) {
                    W.style.display = "none";
                }
            }
        },
        _doClose: function (U) {
			T.preventDefault(U);
            this.hide();
        },
        configDraggable: function (V, U, W) {
            var X = U[0];
            if (X) {
                if (!F.DD) {
                    this.cfg.setProperty("draggable", false);
                    return;
                }
                if (this.header) {
                    A.setStyle(this.header, "cursor", "move");
                    this.registerDragDrop();
                }
                this.subscribe("beforeShow", B);
            } else {
                if (this.dd) {
                    this.dd.unreg();
                }
                if (this.header) {
                    A.setStyle(this.header, "cursor", "auto");
                }
                this.unsubscribe("beforeShow", B);
            }
        },
        configUnderlay: function (d, c, Z) {
            var b = (this.platform == "mac" && L.gecko),
                e = c[0].toLowerCase(),
                V = this.underlay,
                W = this.element;

            function X() {
                var f = false;
                if (!V) {
                    if (!Q) {
                        Q = document.createElement("div");
                        Q.className = "underlay";
                    }
                    V = Q.cloneNode(false);
                    this.element.appendChild(V);
                    this.underlay = V;
                    if (P) {
                        this.sizeUnderlay();
                        this.cfg.subscribeToConfigEvent("width", this.sizeUnderlay);
                        this.cfg.subscribeToConfigEvent("height", this.sizeUnderlay);
                        this.changeContentEvent.subscribe(this.sizeUnderlay);
                        YAHOO.widget.Module.textResizeEvent.subscribe(this.sizeUnderlay, this, true);
                    }
                    if (L.webkit && L.webkit < 420) {
                        this.changeContentEvent.subscribe(this.forceUnderlayRedraw);
                    }
                    f = true;
                }
            }

            function a() {
                var f = X.call(this);
                if (!f && P) {
                    this.sizeUnderlay();
                }
                this._underlayDeferred = false;
                this.beforeShowEvent.unsubscribe(a);
            }

            function Y() {
                if (this._underlayDeferred) {
                    this.beforeShowEvent.unsubscribe(a);
                    this._underlayDeferred = false;
                }
                if (V) {
                    this.cfg.unsubscribeFromConfigEvent("width", this.sizeUnderlay);
                    this.cfg.unsubscribeFromConfigEvent("height", this.sizeUnderlay);
                    this.changeContentEvent.unsubscribe(this.sizeUnderlay);
                    this.changeContentEvent.unsubscribe(this.forceUnderlayRedraw);
                    YAHOO.widget.Module.textResizeEvent.unsubscribe(this.sizeUnderlay, this, true);
                    this.element.removeChild(V);
                    this.underlay = null;
                }
            }
            switch (e) {
            case "shadow":
                A.removeClass(W, "matte");
                A.addClass(W, "shadow");
                break;
            case "matte":
                if (!b) {
                    Y.call(this);
                }
                A.removeClass(W, "shadow");
                A.addClass(W, "matte");
                break;
            default:
                if (!b) {
                    Y.call(this);
                }
                A.removeClass(W, "shadow");
                A.removeClass(W, "matte");
                break;
            }
            if ((e == "shadow") || (b && !V)) {
                if (this.cfg.getProperty("visible")) {
                    var U = X.call(this);
                    if (!U && P) {
                        this.sizeUnderlay();
                    }
                } else {
                    if (!this._underlayDeferred) {
                        this.beforeShowEvent.subscribe(a);
                        this._underlayDeferred = true;
                    }
                }
            }
        },
        configModal: function (V, U, X) {
            var W = U[0];
            if (W) {
                if (!this._hasModalityEventListeners) {
                    this.subscribe("beforeShow", this.buildMask);
                    this.subscribe("beforeShow", this.bringToTop);
                    this.subscribe("beforeShow", this.showMask);
                    this.subscribe("hide", this.hideMask);
                    H.windowResizeEvent.subscribe(this.sizeMask, this, true);
                    this._hasModalityEventListeners = true;
                }
            } else {
                if (this._hasModalityEventListeners) {
                    if (this.cfg.getProperty("visible")) {
                        this.hideMask();
                        this.removeMask();
                    }
                    this.unsubscribe("beforeShow", this.buildMask);
                    this.unsubscribe("beforeShow", this.bringToTop);
                    this.unsubscribe("beforeShow", this.showMask);
                    this.unsubscribe("hide", this.hideMask);
                    H.windowResizeEvent.unsubscribe(this.sizeMask, this);
                    this._hasModalityEventListeners = false;
                }
            }
        },
        removeMask: function () {
            var V = this.mask,
                U;
            if (V) {
                this.hideMask();
                U = V.parentNode;
                if (U) {
                    U.removeChild(V);
                }
                this.mask = null;
            }
        },
        configKeyListeners: function (X, U, a) {
            var W = U[0],
                Z, Y, V;
            if (W) {
                if (W instanceof Array) {
                    Y = W.length;
                    for (V = 0; V < Y; V++) {
                        Z = W[V];
                        if (!I.alreadySubscribed(this.showEvent, Z.enable, Z)) {
                            this.showEvent.subscribe(Z.enable, Z, true);
                        }
                        if (!I.alreadySubscribed(this.hideEvent, Z.disable, Z)) {
                            this.hideEvent.subscribe(Z.disable, Z, true);
                            this.destroyEvent.subscribe(Z.disable, Z, true);
                        }
                    }
                } else {
                    if (!I.alreadySubscribed(this.showEvent, W.enable, W)) {
                        this.showEvent.subscribe(W.enable, W, true);
                    }
                    if (!I.alreadySubscribed(this.hideEvent, W.disable, W)) {
                        this.hideEvent.subscribe(W.disable, W, true);
                        this.destroyEvent.subscribe(W.disable, W, true);
                    }
                }
            }
        },
        configStrings: function (V, U, W) {
            var X = E.merge(N.STRINGS.value, U[0]);
            this.cfg.setProperty(N.STRINGS.key, X, true);
        },
        configHeight: function (X, V, Y) {
            var U = V[0],
                W = this.innerElement;
            A.setStyle(W, "height", U);
            this.cfg.refireEvent("iframe");
        },
        _autoFillOnHeightChange: function (X, V, W) {
            O.superclass._autoFillOnHeightChange.apply(this, arguments);
            if (P) {
                var U = this;
                setTimeout(function () {
                    U.sizeUnderlay();
                }, 0);
            }
        },
        configWidth: function (X, U, Y) {
            var W = U[0],
                V = this.innerElement;
            A.setStyle(V, "width", W);
            this.cfg.refireEvent("iframe");
        },
        configzIndex: function (V, U, X) {
            O.superclass.configzIndex.call(this, V, U, X);
            if (this.mask || this.cfg.getProperty("modal") === true) {
                var W = A.getStyle(this.element, "zIndex");
                if (!W || isNaN(W)) {
                    W = 0;
                }
                if (W === 0) {
                    this.cfg.setProperty("zIndex", 1);
                } else {
                    this.stackMask();
                }
            }
        },
        buildWrapper: function () {
            var W = this.element.parentNode,
                U = this.element,
                V = document.createElement("div");
            V.className = O.CSS_PANEL_CONTAINER;
            V.id = U.id + "_c";
            if (W) {
                W.insertBefore(V, U);
            }
            V.appendChild(U);
            this.element = V;
            this.innerElement = U;
            A.setStyle(this.innerElement, "visibility", "inherit");
        },
        sizeUnderlay: function () {
            var V = this.underlay,
                U;
            if (V) {
                U = this.element;
                V.style.width = U.offsetWidth + "px";
                V.style.height = U.offsetHeight + "px";
            }
        },
        registerDragDrop: function () {
            var V = this;
            if (this.header) {
                if (!F.DD) {
                    return;
                }
                var U = (this.cfg.getProperty("dragonly") === true);
                this.dd = new F.DD(this.element.id, this.id, {
                    dragOnly: U
                });
                if (!this.header.id) {
                    this.header.id = this.id + "_h";
                }
                this.dd.startDrag = function () {
                    var X, Z, W, c, b, a;
                    if (YAHOO.env.ua.ie == 6) {
                        A.addClass(V.element, "drag");
                    }
                    if (V.cfg.getProperty("constraintoviewport")) {
                        var Y = H.VIEWPORT_OFFSET;
                        X = V.element.offsetHeight;
                        Z = V.element.offsetWidth;
                        W = A.getViewportWidth();
                        c = A.getViewportHeight();
                        b = A.getDocumentScrollLeft();
                        a = A.getDocumentScrollTop();
                        if (X + Y < c) {
                            this.minY = a + Y;
                            this.maxY = a + c - X - Y;
                        } else {
                            this.minY = a + Y;
                            this.maxY = a + Y;
                        } if (Z + Y < W) {
                            this.minX = b + Y;
                            this.maxX = b + W - Z - Y;
                        } else {
                            this.minX = b + Y;
                            this.maxX = b + Y;
                        }
                        this.constrainX = true;
                        this.constrainY = true;
                    } else {
                        this.constrainX = false;
                        this.constrainY = false;
                    }
                    V.dragEvent.fire("startDrag", arguments);
                };
                this.dd.onDrag = function () {
                    V.syncPosition();
                    V.cfg.refireEvent("iframe");
                    if (this.platform == "mac" && YAHOO.env.ua.gecko) {
                        this.showMacGeckoScrollbars();
                    }
                    V.dragEvent.fire("onDrag", arguments);
                };
                this.dd.endDrag = function () {
                    if (YAHOO.env.ua.ie == 6) {
                        A.removeClass(V.element, "drag");
                    }
                    V.dragEvent.fire("endDrag", arguments);
                    V.moveEvent.fire(V.cfg.getProperty("xy"));
                };
                this.dd.setHandleElId(this.header.id);
                this.dd.addInvalidHandleType("INPUT");
                this.dd.addInvalidHandleType("SELECT");
                this.dd.addInvalidHandleType("TEXTAREA");
            }
        },
        buildMask: function () {
            var U = this.mask;
            if (!U) {
                if (!G) {
                    G = document.createElement("div");
                    G.className = "mask";
                    G.innerHTML = "&#160;";
                }
                U = G.cloneNode(true);
                U.id = this.id + "_mask";
                document.body.insertBefore(U, document.body.firstElementChild);
                this.mask = U;
                if (YAHOO.env.ua.gecko && this.platform == "mac") {
                    A.addClass(this.mask, "block-scrollbars");
                }
                this.stackMask();
            }
        },
        hideMask: function () {
	        if (this.cfg.getProperty("modal") && this.mask) {
                this.mask.style.display = "none";
                A.removeClass(document.body, "masked");
                this.hideMaskEvent.fire();
            }
        },
        showMask: function () {
            if (this.cfg.getProperty("modal") && this.mask) {
                A.addClass(document.body, "masked");
                this.sizeMask();
                this.mask.style.display = "block";
                this.showMaskEvent.fire();
            }
        },
        sizeMask: function () {
            if (this.mask) {
                var V = this.mask,
                    W = A.getViewportWidth(),
                    U = A.getViewportHeight();
                if (V.offsetHeight > U) {
                    V.style.height = U + "px";
                }
                if (V.offsetWidth > W) {
                    V.style.width = W + "px";
                }
                V.style.height = A.getDocumentHeight() + "px";
                V.style.width = A.getDocumentWidth() + "px";
            }
        },
        stackMask: function () {
            if (this.mask) {
                var U = A.getStyle(this.element, "zIndex");
                if (!YAHOO.lang.isUndefined(U) && !isNaN(U)) {
                    A.setStyle(this.mask, "zIndex", U - 1);
                }
            }
        },
        render: function (U) {
            return O.superclass.render.call(this, U, this.innerElement);
        },
        destroy: function () {
            H.windowResizeEvent.unsubscribe(this.sizeMask, this);
            this.removeMask();
            if (this.close) {
                T.purgeElement(this.close);
            }
            O.superclass.destroy.call(this);
        },
        forceUnderlayRedraw: function () {
            var U = this.underlay;
            A.addClass(U, "yui-force-redraw");
            setTimeout(function () {
                A.removeClass(U, "yui-force-redraw");
            }, 0);
        },
        toString: function () {
            return "Panel " + this.id;
        }
    });
}());
(function () {
    YAHOO.widget.Dialog = function (J, I) {
        YAHOO.widget.Dialog.superclass.constructor.call(this, J, I);
    };
    var B = YAHOO.util.Event,
        G = YAHOO.util.CustomEvent,
        E = YAHOO.util.Dom,
        A = YAHOO.widget.Dialog,
        F = YAHOO.lang,
        H = {
            "BEFORE_SUBMIT": "beforeSubmit",
            "SUBMIT": "submit",
            "MANUAL_SUBMIT": "manualSubmit",
            "ASYNC_SUBMIT": "asyncSubmit",
            "FORM_SUBMIT": "formSubmit",
            "CANCEL": "cancel"
        },
        C = {
            "POST_METHOD": {
                key: "postmethod",
                value: "async"
            },
            "POST_DATA": {
                key: "postdata",
                value: null
            },
            "BUTTONS": {
                key: "buttons",
                value: "none",
                supercedes: ["visible"]
            },
            "HIDEAFTERSUBMIT": {
                key: "hideaftersubmit",
                value: true
            }
        };
    A.CSS_DIALOG = "yui-dialog";

    function D() {
        var L = this._aButtons,
            J, K, I;
        if (F.isArray(L)) {
            J = L.length;
            if (J > 0) {
                I = J - 1;
                do {
                    K = L[I];
                    if (YAHOO.widget.Button && K instanceof YAHOO.widget.Button) {
                        K.destroy();
                    } else {
                        if (K.tagName.toUpperCase() == "BUTTON") {
                            B.purgeElement(K);
                            B.purgeElement(K, false);
                        }
                    }
                } while (I--);
            }
        }
    }
    YAHOO.extend(A, YAHOO.widget.Panel, {
        form: null,
        initDefaultConfig: function () {
            A.superclass.initDefaultConfig.call(this);
            this.callback = {
                success: null,
                failure: null,
                argument: null
            };
            this.cfg.addProperty(C.POST_METHOD.key, {
                handler: this.configPostMethod,
                value: C.POST_METHOD.value,
                validator: function (I) {
                    if (I != "form" && I != "async" && I != "none" && I != "manual") {
                        return false;
                    } else {
                        return true;
                    }
                }
            });
            this.cfg.addProperty(C.POST_DATA.key, {
                value: C.POST_DATA.value
            });
            this.cfg.addProperty(C.HIDEAFTERSUBMIT.key, {
                value: C.HIDEAFTERSUBMIT.value
            });
            this.cfg.addProperty(C.BUTTONS.key, {
                handler: this.configButtons,
                value: C.BUTTONS.value,
                supercedes: C.BUTTONS.supercedes
            });
        },
        initEvents: function () {
            A.superclass.initEvents.call(this);
            var I = G.LIST;
            this.beforeSubmitEvent = this.createEvent(H.BEFORE_SUBMIT);
            this.beforeSubmitEvent.signature = I;
            this.submitEvent = this.createEvent(H.SUBMIT);
            this.submitEvent.signature = I;
            this.manualSubmitEvent = this.createEvent(H.MANUAL_SUBMIT);
            this.manualSubmitEvent.signature = I;
            this.asyncSubmitEvent = this.createEvent(H.ASYNC_SUBMIT);
            this.asyncSubmitEvent.signature = I;
            this.formSubmitEvent = this.createEvent(H.FORM_SUBMIT);
            this.formSubmitEvent.signature = I;
            this.cancelEvent = this.createEvent(H.CANCEL);
            this.cancelEvent.signature = I;
        },
        init: function (J, I) {
            A.superclass.init.call(this, J);
            this.beforeInitEvent.fire(A);
            E.addClass(this.element, A.CSS_DIALOG);
            this.cfg.setProperty("visible", false);
            if (I) {
                this.cfg.applyConfig(I, true);
            }
            this.showEvent.subscribe(this.focusFirst, this, true);
            this.beforeHideEvent.subscribe(this.blurButtons, this, true);
            this.subscribe("changeBody", this.registerForm);
            this.initEvent.fire(A);
        },
        doSubmit: function () {
            var P = YAHOO.util.Connect,
                Q = this.form,
                K = false,
                N = false,
                R, M, L, I;
            switch (this.cfg.getProperty("postmethod")) {
            case "async":
                R = Q.elements;
                M = R.length;
                if (M > 0) {
                    L = M - 1;
                    do {
                        if (R[L].type == "file") {
                            K = true;
                            break;
                        }
                    } while (L--);
                }
                if (K && YAHOO.env.ua.ie && this.isSecure) {
                    N = true;
                }
                I = this._getFormAttributes(Q);
                P.setForm(Q, K, N);
                var J = this.cfg.getProperty("postdata");
                var O = P.asyncRequest(I.method, I.action, this.callback, J);
                this.asyncSubmitEvent.fire(O);
                break;
            case "form":
                Q.submit();
                this.formSubmitEvent.fire();
                break;
            case "none":
            case "manual":
                this.manualSubmitEvent.fire();
                break;
            }
        },
        _getFormAttributes: function (K) {
            var I = {
                method: null,
                action: null
            };
            if (K) {
                if (K.getAttributeNode) {
                    var J = K.getAttributeNode("action");
                    var L = K.getAttributeNode("method");
                    if (J) {
                        I.action = J.value;
                    }
                    if (L) {
                        I.method = L.value;
                    }
                } else {
                    I.action = K.getAttribute("action");
                    I.method = K.getAttribute("method");
                }
            }
            I.method = (F.isString(I.method) ? I.method : "POST").toUpperCase();
            I.action = F.isString(I.action) ? I.action : "";
            return I;
        },
        registerForm: function () {
            var I = this.element.getElementsByTagName("form")[0];
            if (this.form) {
                if (this.form == I && E.isAncestor(this.element, this.form)) {
                    return;
                } else {
                    B.purgeElement(this.form);
                    this.form = null;
                }
            }
            if (!I) {
                I = document.createElement("form");
                I.name = "frm_" + this.id;
                this.body.appendChild(I);
            }
            if (I) {
                this.form = I;
                B.on(I, "submit", this._submitHandler, this, true);
            }
        },
        _submitHandler: function (I) {
            B.stopEvent(I);
            this.submit();
            this.form.blur();
        },
        setTabLoop: function (I, J) {
            I = I || this.firstButton;
            J = this.lastButton || J;
            A.superclass.setTabLoop.call(this, I, J);
        },
        setFirstLastFocusable: function () {
            A.superclass.setFirstLastFocusable.call(this);
            var J, I, K, L = this.focusableElements;
            this.firstFormElement = null;
            this.lastFormElement = null;
            if (this.form && L && L.length > 0) {
                I = L.length;
                for (J = 0; J < I; ++J) {
                    K = L[J];
                    if (this.form === K.form) {
                        this.firstFormElement = K;
                        break;
                    }
                }
                for (J = I - 1; J >= 0; --J) {
                    K = L[J];
                    if (this.form === K.form) {
                        this.lastFormElement = K;
                        break;
                    }
                }
            }
        },
        configClose: function (J, I, K) {
            A.superclass.configClose.apply(this, arguments);
        },
        _doClose: function (I) {
            B.preventDefault(I);
            this.cancel();
        },
        configButtons: function (S, R, M) {
            var N = YAHOO.widget.Button,
                U = R[0],
                K = this.innerElement,
                T, P, J, Q, O, I, L;
            D.call(this);
            this._aButtons = null;
            if (F.isArray(U)) {
                O = document.createElement("span");
                O.className = "button-group";
                Q = U.length;
                this._aButtons = [];
                this.defaultHtmlButton = null;
                for (L = 0; L < Q; L++) {
                    T = U[L];
                    if (N) {
                        J = new N({
                            label: T.text
                        });
                        J.appendTo(O);
                        P = J.get("element");
                        if (T.isDefault) {
                            J.addClass("default");
                            this.defaultHtmlButton = P;
                        }
                        if (F.isFunction(T.handler)) {
                            J.set("onclick", {
                                fn: T.handler,
                                obj: this,
                                scope: this
                            });
                        } else {
                            if (F.isObject(T.handler) && F.isFunction(T.handler.fn)) {
                                J.set("onclick", {
                                    fn: T.handler.fn,
                                    obj: ((!F.isUndefined(T.handler.obj)) ? T.handler.obj : this),
                                    scope: (T.handler.scope || this)
                                });
                            }
                        }
                        this._aButtons[this._aButtons.length] = J;
                    } else {
                        P = document.createElement("button");
                        P.setAttribute("type", "button");
                        if (T.isDefault) {
                            P.className = "default";
                            this.defaultHtmlButton = P;
                        }
                        P.innerHTML = T.text;
                        if (F.isFunction(T.handler)) {
                            B.on(P, "click", T.handler, this, true);
                        } else {
                            if (F.isObject(T.handler) && F.isFunction(T.handler.fn)) {
                                B.on(P, "click", T.handler.fn, ((!F.isUndefined(T.handler.obj)) ? T.handler.obj : this), (T.handler.scope || this));
                            }
                        }
                        O.appendChild(P);
                        this._aButtons[this._aButtons.length] = P;
                    }
                    T.htmlButton = P;
                    if (L === 0) {
                        this.firstButton = P;
                    }
                    if (L == (Q - 1)) {
                        this.lastButton = P;
                    }
                }
                this.setFooter(O);
                I = this.footer;
                if (E.inDocument(this.element) && !E.isAncestor(K, I)) {
                    K.appendChild(I);
                }
                this.buttonSpan = O;
            } else {
                O = this.buttonSpan;
                I = this.footer;
                if (O && I) {
                    I.removeChild(O);
                    this.buttonSpan = null;
                    this.firstButton = null;
                    this.lastButton = null;
                    this.defaultHtmlButton = null;
                }
            }
            this.changeContentEvent.fire();
        },
        getButtons: function () {
            return this._aButtons || null;
        },
        focusFirst: function (K, I, M) {
            var J = this.firstFormElement;
            if (I && I[1]) {
                B.stopEvent(I[1]);
            }
            if (J) {
                try {
                    J.focus();
                } catch (L) {}
            } else {
                if (this.defaultHtmlButton) {
                    this.focusDefaultButton();
                } else {
                    this.focusFirstButton();
                }
            }
        },
        focusLast: function (K, I, M) {
            var N = this.cfg.getProperty("buttons"),
                J = this.lastFormElement;
            if (I && I[1]) {
                B.stopEvent(I[1]);
            }
            if (N && F.isArray(N)) {
                this.focusLastButton();
            } else {
                if (J) {
                    try {
                        J.focus();
                    } catch (L) {}
                }
            }
        },
        _getButton: function (J) {
            var I = YAHOO.widget.Button;
            if (I && J && J.nodeName && J.id) {
                J = I.getButton(J.id) || J;
            }
            return J;
        },
        focusDefaultButton: function () {
            var I = this._getButton(this.defaultHtmlButton);
            if (I) {
                try {
                    I.focus();
                } catch (J) {}
            }
        },
        blurButtons: function () {
            var N = this.cfg.getProperty("buttons"),
                K, M, J, I;
            if (N && F.isArray(N)) {
                K = N.length;
                if (K > 0) {
                    I = (K - 1);
                    do {
                        M = N[I];
                        if (M) {
                            J = this._getButton(M.htmlButton);
                            if (J) {
                                try {
                                    J.blur();
                                } catch (L) {}
                            }
                        }
                    } while (I--);
                }
            }
        },
        focusFirstButton: function () {
            var L = this.cfg.getProperty("buttons"),
                K, I;
            if (L && F.isArray(L)) {
                K = L[0];
                if (K) {
                    I = this._getButton(K.htmlButton);
                    if (I) {
                        try {
                            I.focus();
                        } catch (J) {}
                    }
                }
            }
        },
        focusLastButton: function () {
            var M = this.cfg.getProperty("buttons"),
                J, L, I;
            if (M && F.isArray(M)) {
                J = M.length;
                if (J > 0) {
                    L = M[(J - 1)];
                    if (L) {
                        I = this._getButton(L.htmlButton);
                        if (I) {
                            try {
                                I.focus();
                            } catch (K) {}
                        }
                    }
                }
            }
        },
        configPostMethod: function (J, I, K) {
            this.registerForm();
        },
        validate: function () {
            return true;
        },
        submit: function () {
            if (this.validate()) {
                this.beforeSubmitEvent.fire();
                this.doSubmit();
                this.submitEvent.fire();
                if (this.cfg.getProperty("hideaftersubmit")) {
                    this.hide();
                }
                return true;
            } else {
                return false;
            }
        },
        cancel: function () {
            this.cancelEvent.fire();
            this.hide();
        },
        getData: function () {
            var Y = this.form,
                K, R, U, M, S, P, O, J, V, L, W, Z, I, N, a, X, T;

            function Q(c) {
                var b = c.tagName.toUpperCase();
                return ((b == "INPUT" || b == "TEXTAREA" || b == "SELECT") && c.name == M);
            }
            if (Y) {
                K = Y.elements;
                R = K.length;
                U = {};
                for (X = 0; X < R; X++) {
                    M = K[X].name;
                    S = E.getElementsBy(Q, "*", Y);
                    P = S.length;
                    if (P > 0) {
                        if (P == 1) {
                            S = S[0];
                            O = S.type;
                            J = S.tagName.toUpperCase();
                            switch (J) {
                            case "INPUT":
                                if (O == "checkbox") {
                                    U[M] = S.checked;
                                } else {
                                    if (O != "radio") {
                                        U[M] = S.value;
                                    }
                                }
                                break;
                            case "TEXTAREA":
                                U[M] = S.value;
                                break;
                            case "SELECT":
                                V = S.options;
                                L = V.length;
                                W = [];
                                for (T = 0; T < L; T++) {
                                    Z = V[T];
                                    if (Z.selected) {
                                        I = Z.value;
                                        if (!I || I === "") {
                                            I = Z.text;
                                        }
                                        W[W.length] = I;
                                    }
                                }
                                U[M] = W;
                                break;
                            }
                        } else {
                            O = S[0].type;
                            switch (O) {
                            case "radio":
                                for (T = 0; T < P; T++) {
                                    N = S[T];
                                    if (N.checked) {
                                        U[M] = N.value;
                                        break;
                                    }
                                }
                                break;
                            case "checkbox":
                                W = [];
                                for (T = 0; T < P; T++) {
                                    a = S[T];
                                    if (a.checked) {
                                        W[W.length] = a.value;
                                    }
                                }
                                U[M] = W;
                                break;
                            }
                        }
                    }
                }
            }
            return U;
        },
        destroy: function () {
	        D.call(this);
            this._aButtons = null;
            var I = this.element.getElementsByTagName("form"),
                J;
            if (I.length > 0) {
                J = I[0];
                if (J) {
                    B.purgeElement(J);
                    if (J.parentNode) {
                        J.parentNode.removeChild(J);
                    }
                    this.form = null;
                }
            }
            A.superclass.destroy.call(this);
        },
        toString: function () {
            return "Dialog " + this.id;
        }
    });
}());
(function () {
    YAHOO.widget.SimpleDialog = function (E, D) {
        YAHOO.widget.SimpleDialog.superclass.constructor.call(this, E, D);
    };
    var C = YAHOO.util.Dom,
        B = YAHOO.widget.SimpleDialog,
        A = {
            "ICON": {
                key: "icon",
                value: "none",
                suppressEvent: true
            },
            "TEXT": {
                key: "text",
                value: "",
                suppressEvent: true,
                supercedes: ["icon"]
            }
        };
    B.ICON_BLOCK = "blckicon";
    B.ICON_ALARM = "alrticon";
    B.ICON_HELP = "hlpicon";
    B.ICON_INFO = "infoicon";
    B.ICON_WARN = "warnicon";
    B.ICON_TIP = "tipicon";
    B.ICON_CSS_CLASSNAME = "yui-icon";
    B.CSS_SIMPLEDIALOG = "yui-simple-dialog";
    YAHOO.extend(B, YAHOO.widget.Dialog, {
        initDefaultConfig: function () {
            B.superclass.initDefaultConfig.call(this);
            this.cfg.addProperty(A.ICON.key, {
                handler: this.configIcon,
                value: A.ICON.value,
                suppressEvent: A.ICON.suppressEvent
            });
            this.cfg.addProperty(A.TEXT.key, {
                handler: this.configText,
                value: A.TEXT.value,
                suppressEvent: A.TEXT.suppressEvent,
                supercedes: A.TEXT.supercedes
            });
        },
        init: function (E, D) {
            B.superclass.init.call(this, E);
            this.beforeInitEvent.fire(B);
            C.addClass(this.element, B.CSS_SIMPLEDIALOG);
            this.cfg.queueProperty("postmethod", "manual");
            if (D) {
                this.cfg.applyConfig(D, true);
            }
            this.beforeRenderEvent.subscribe(function () {
                if (!this.body) {
                    this.setBody("");
                }
            }, this, true);
            this.initEvent.fire(B);
        },
        registerForm: function () {
            B.superclass.registerForm.call(this);
            this.form.innerHTML += '<input type="hidden" name="' + this.id + '" id="' + this.id + '" value=""/>';
        },
        configIcon: function (F, E, J) {
            var K = E[0],
                D = this.body,
                I = B.ICON_CSS_CLASSNAME,
                H, G;
            if (K && K != "none") {
                H = C.getElementsByClassName(I, "*", D);
                if (H) {
                    G = H.parentNode;
                    if (G) {
                        G.removeChild(H);
                        H = null;
                    }
                }
                if (K.indexOf(".") == -1) {
                    H = document.createElement("span");
                    H.className = (I + " " + K);
                    H.innerHTML = "&#160;";
                } else {
                    H = document.createElement("img");
                    H.src = (this.imageRoot + K);
                    H.className = I;
                } if (H) {
                    D.insertBefore(H, D.firstElementChild);
                }
            }
        },
        configText: function (E, D, F) {
            var G = D[0];
            if (G) {
                this.setBody(G);
                this.cfg.refireEvent("icon");
            }
        },
        toString: function () {
            return "SimpleDialog " + this.id;
        }
    });
}());
(function () {
    YAHOO.widget.ContainerEffect = function (E, H, G, D, F) {
        if (!F) {
            F = YAHOO.util.Anim;
        }
        this.overlay = E;
        this.attrIn = H;
        this.attrOut = G;
        this.targetElement = D || E.element;
        this.animClass = F;
    };
    var B = YAHOO.util.Dom,
        C = YAHOO.util.CustomEvent,
        A = YAHOO.widget.ContainerEffect;
    A.FADE = function (D, F) {
        var G = YAHOO.util.Easing,
            I = {
                attributes: {
                    opacity: {
                        from: 0,
                        to: 1
                    }
                },
                duration: F,
                method: G.easeIn
            },
            E = {
                attributes: {
                    opacity: {
                        to: 0
                    }
                },
                duration: F,
                method: G.easeOut
            },
            H = new A(D, I, E, D.element);
        H.handleUnderlayStart = function () {
            var K = this.overlay.underlay;
            if (K && YAHOO.env.ua.ie) {
                var J = (K.filters && K.filters.length > 0);
                if (J) {
                    B.addClass(D.element, "yui-effect-fade");
                }
            }
        };
        H.handleUnderlayComplete = function () {
            var J = this.overlay.underlay;
            if (J && YAHOO.env.ua.ie) {
                B.removeClass(D.element, "yui-effect-fade");
            }
        };
        H.handleStartAnimateIn = function (K, J, L) {
            B.addClass(L.overlay.element, "hide-select");
            if (!L.overlay.underlay) {
                L.overlay.cfg.refireEvent("underlay");
            }
            L.handleUnderlayStart();
            L.overlay._setDomVisibility(true);
            B.setStyle(L.overlay.element, "opacity", 0);
        };
        H.handleCompleteAnimateIn = function (K, J, L) {
            B.removeClass(L.overlay.element, "hide-select");
            if (L.overlay.element.style.filter) {
                L.overlay.element.style.filter = null;
            }
            L.handleUnderlayComplete();
            L.overlay.cfg.refireEvent("iframe");
            L.animateInCompleteEvent.fire();
        };
        H.handleStartAnimateOut = function (K, J, L) {
            B.addClass(L.overlay.element, "hide-select");
            L.handleUnderlayStart();
        };
        H.handleCompleteAnimateOut = function (K, J, L) {
            B.removeClass(L.overlay.element, "hide-select");
            if (L.overlay.element.style.filter) {
                L.overlay.element.style.filter = null;
            }
            L.overlay._setDomVisibility(false);
            B.setStyle(L.overlay.element, "opacity", 1);
            L.handleUnderlayComplete();
            L.overlay.cfg.refireEvent("iframe");
            L.animateOutCompleteEvent.fire();
        };
        H.init();
        return H;
    };
    A.SLIDE = function (F, D) {
        var I = YAHOO.util.Easing,
            L = F.cfg.getProperty("x") || B.getX(F.element),
            K = F.cfg.getProperty("y") || B.getY(F.element),
            M = B.getClientWidth(),
            H = F.element.offsetWidth,
            J = {
                attributes: {
                    points: {
                        to: [L, K]
                    }
                },
                duration: D,
                method: I.easeIn
            },
            E = {
                attributes: {
                    points: {
                        to: [(M + 25), K]
                    }
                },
                duration: D,
                method: I.easeOut
            },
            G = new A(F, J, E, F.element, YAHOO.util.Motion);
        G.handleStartAnimateIn = function (O, N, P) {
            P.overlay.element.style.left = ((-25) - H) + "px";
            P.overlay.element.style.top = K + "px";
        };
        G.handleTweenAnimateIn = function (Q, P, R) {
            var S = B.getXY(R.overlay.element),
                O = S[0],
                N = S[1];
            if (B.getStyle(R.overlay.element, "visibility") == "hidden" && O < L) {
                R.overlay._setDomVisibility(true);
            }
            R.overlay.cfg.setProperty("xy", [O, N], true);
            R.overlay.cfg.refireEvent("iframe");
        };
        G.handleCompleteAnimateIn = function (O, N, P) {
            P.overlay.cfg.setProperty("xy", [L, K], true);
            P.startX = L;
            P.startY = K;
            P.overlay.cfg.refireEvent("iframe");
            P.animateInCompleteEvent.fire();
        };
        G.handleStartAnimateOut = function (O, N, R) {
            var P = B.getViewportWidth(),
                S = B.getXY(R.overlay.element),
                Q = S[1];
            R.animOut.attributes.points.to = [(P + 25), Q];
        };
        G.handleTweenAnimateOut = function (P, O, Q) {
            var S = B.getXY(Q.overlay.element),
                N = S[0],
                R = S[1];
            Q.overlay.cfg.setProperty("xy", [N, R], true);
            Q.overlay.cfg.refireEvent("iframe");
        };
        G.handleCompleteAnimateOut = function (O, N, P) {
            P.overlay._setDomVisibility(false);
            P.overlay.cfg.setProperty("xy", [L, K]);
            P.animateOutCompleteEvent.fire();
        };
        G.init();
        return G;
    };
    A.prototype = {
        init: function () {
            this.beforeAnimateInEvent = this.createEvent("beforeAnimateIn");
            this.beforeAnimateInEvent.signature = C.LIST;
            this.beforeAnimateOutEvent = this.createEvent("beforeAnimateOut");
            this.beforeAnimateOutEvent.signature = C.LIST;
            this.animateInCompleteEvent = this.createEvent("animateInComplete");
            this.animateInCompleteEvent.signature = C.LIST;
            this.animateOutCompleteEvent = this.createEvent("animateOutComplete");
            this.animateOutCompleteEvent.signature = C.LIST;
            this.animIn = new this.animClass(this.targetElement, this.attrIn.attributes, this.attrIn.duration, this.attrIn.method);
            this.animIn.onStart.subscribe(this.handleStartAnimateIn, this);
            this.animIn.onTween.subscribe(this.handleTweenAnimateIn, this);
            this.animIn.onComplete.subscribe(this.handleCompleteAnimateIn, this);
            this.animOut = new this.animClass(this.targetElement, this.attrOut.attributes, this.attrOut.duration, this.attrOut.method);
            this.animOut.onStart.subscribe(this.handleStartAnimateOut, this);
            this.animOut.onTween.subscribe(this.handleTweenAnimateOut, this);
            this.animOut.onComplete.subscribe(this.handleCompleteAnimateOut, this);
        },
        animateIn: function () {
            this.beforeAnimateInEvent.fire();
            this.animIn.animate();
        },
        animateOut: function () {
            this.beforeAnimateOutEvent.fire();
            this.animOut.animate();
        },
        handleStartAnimateIn: function (E, D, F) {},
        handleTweenAnimateIn: function (E, D, F) {},
        handleCompleteAnimateIn: function (E, D, F) {},
        handleStartAnimateOut: function (E, D, F) {},
        handleTweenAnimateOut: function (E, D, F) {},
        handleCompleteAnimateOut: function (E, D, F) {},
        toString: function () {
            var D = "ContainerEffect";
            if (this.overlay) {
                D += " [" + this.overlay.toString() + "]";
            }
            return D;
        }
    };
    YAHOO.lang.augmentProto(A, YAHOO.util.EventProvider);
})();
YAHOO.register("container", YAHOO.widget.Module, {
    version: "2.7.0",
    build: "1799"
});

