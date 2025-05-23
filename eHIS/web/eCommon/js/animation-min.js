
(function () {
	var B = YAHOO.util;
	var A = function (D, C, E, F) {
		if (!D) {
		}
		this.init(D, C, E, F);
	};
	A.NAME = "Anim";
	A.prototype = {toString:function () {
		var C = this.getEl() || {};
		var D = C.id || C.tagName;
		return (this.constructor.NAME + ": " + D);
	}, patterns:{noNegatives:/width|height|opacity|padding/i, offsetAttribute:/^((width|height)|(top|left))$/, defaultUnit:/width|height|top$|bottom$|left$|right$/i, offsetUnit:/\d+(em|%|en|ex|pt|in|cm|mm|pc)$/i}, doMethod:function (C, E, D) {
		return this.method(this.currentFrame, E, D - E, this.totalFrames);
	}, setAttribute:function (C, E, D) {
		if (this.patterns.noNegatives.test(C)) {
			E = (E > 0) ? E : 0;
		}
		B.Dom.setStyle(this.getEl(), C, E + D);
	}, getAttribute:function (C) {
		var E = this.getEl();
		var G = B.Dom.getStyle(E, C);
		if (G !== "auto" && !this.patterns.offsetUnit.test(G)) {
			return parseFloat(G);
		}
		var D = this.patterns.offsetAttribute.exec(C) || [];
		var H = !!(D[3]);
		var F = !!(D[2]);
		if (F || (B.Dom.getStyle(E, "position") == "absolute" && H)) {
			G = E["offset" + D[0].charAt(0).toUpperCase() + D[0].substr(1)];
		} else {
			G = 0;
		}
		return G;
	}, getDefaultUnit:function (C) {
		if (this.patterns.defaultUnit.test(C)) {
			return "px";
		}
		return "";
	}, setRuntimeAttribute:function (D) {
		var I;
		var E;
		var F = this.attributes;
		this.runtimeAttributes[D] = {};
		var H = function (J) {
			return (typeof J !== "undefined");
		};
		if (!H(F[D]["to"]) && !H(F[D]["by"])) {
			return false;
		}
		I = (H(F[D]["from"])) ? F[D]["from"] : this.getAttribute(D);
		if (H(F[D]["to"])) {
			E = F[D]["to"];
		} else {
			if (H(F[D]["by"])) {
				if (I.constructor == Array) {
					E = [];
					for (var G = 0, C = I.length; G < C; ++G) {
						E[G] = I[G] + F[D]["by"][G] * 1;
					}
				} else {
					E = I + F[D]["by"] * 1;
				}
			}
		}
		this.runtimeAttributes[D].start = I;
		this.runtimeAttributes[D].end = E;
		this.runtimeAttributes[D].unit = (H(F[D].unit)) ? F[D]["unit"] : this.getDefaultUnit(D);
		return true;
	}, init:function (E, J, I, C) {
		var D = false;
		var F = null;
		var H = 0;
		E = B.Dom.get(E);
		this.attributes = J || {};
		this.duration = !YAHOO.lang.isUndefined(I) ? I : 1;
		this.method = C || B.Easing.easeNone;
		this.useSeconds = true;
		this.currentFrame = 0;
		this.totalFrames = B.AnimMgr.fps;
		this.setEl = function (M) {
			E = B.Dom.get(M);
		};
		this.getEl = function () {
			return E;
		};
		this.isAnimated = function () {
			return D;
		};
		this.getStartTime = function () {
			return F;
		};
		this.runtimeAttributes = {};
		this.animate = function () {
			if (this.isAnimated()) {
				return false;
			}
			this.currentFrame = 0;
			this.totalFrames = (this.useSeconds) ? Math.ceil(B.AnimMgr.fps * this.duration) : this.duration;
			if (this.duration === 0 && this.useSeconds) {
				this.totalFrames = 1;
			}
			B.AnimMgr.registerElement(this);
			return true;
		};
		this.stop = function (M) {
			if (!this.isAnimated()) {
				return false;
			}
			if (M) {
				this.currentFrame = this.totalFrames;
				this._onTween.fire();
			}
			B.AnimMgr.stop(this);
		};
		var L = function () {
			this.onStart.fire();
			this.runtimeAttributes = {};
			for (var M in this.attributes) {
				this.setRuntimeAttribute(M);
			}
			D = true;
			H = 0;
			F = new Date();
		};
		var K = function () {
			var O = {duration:new Date() - this.getStartTime(), currentFrame:this.currentFrame};
			O.toString = function () {
				return ("duration: " + O.duration + ", currentFrame: " + O.currentFrame);
			};
			this.onTween.fire(O);
			var N = this.runtimeAttributes;
			for (var M in N) {
				this.setAttribute(M, this.doMethod(M, N[M].start, N[M].end), N[M].unit);
			}
			H += 1;
		};
		var G = function () {
			var M = (new Date() - F) / 1000;
			var N = {duration:M, frames:H, fps:H / M};
			N.toString = function () {
				return ("duration: " + N.duration + ", frames: " + N.frames + ", fps: " + N.fps);
			};
			D = false;
			H = 0;
			this.onComplete.fire(N);
		};
		this._onStart = new B.CustomEvent("_start", this, true);
		this.onStart = new B.CustomEvent("start", this);
		this.onTween = new B.CustomEvent("tween", this);
		this._onTween = new B.CustomEvent("_tween", this, true);
		this.onComplete = new B.CustomEvent("complete", this);
		this._onComplete = new B.CustomEvent("_complete", this, true);
		this._onStart.subscribe(L);
		this._onTween.subscribe(K);
		this._onComplete.subscribe(G);
	}};
	B.Anim = A;
})();
YAHOO.util.AnimMgr = new function () {
	var C = null;
	var B = [];
	var A = 0;
	this.fps = 1000;
	this.delay = 1;
	this.registerElement = function (F) {
		B[B.length] = F;
		A += 1;
		F._onStart.fire();
		this.start();
	};
	this.unRegister = function (G, F) {
		F = F || E(G);
		if (!G.isAnimated() || F == -1) {
			return false;
		}
		G._onComplete.fire();
		B.splice(F, 1);
		A -= 1;
		if (A <= 0) {
			this.stop();
		}
		return true;
	};
	this.start = function () {
		if (C === null) {
			C = setInterval(this.run, this.delay);
		}
	};
	this.stop = function (H) {
		if (!H) {
			clearInterval(C);
			for (var G = 0, F = B.length; G < F; ++G) {
				this.unRegister(B[0], 0);
			}
			B = [];
			C = null;
			A = 0;
		} else {
			this.unRegister(H);
		}
	};
	this.run = function () {
		for (var H = 0, F = B.length; H < F; ++H) {
			var G = B[H];
			if (!G || !G.isAnimated()) {
				continue;
			}
			if (G.currentFrame < G.totalFrames || G.totalFrames === null) {
				G.currentFrame += 1;
				if (G.useSeconds) {
					D(G);
				}
				G._onTween.fire();
			} else {
				YAHOO.util.AnimMgr.stop(G, H);
			}
		}
	};
	var E = function (H) {
		for (var G = 0, F = B.length; G < F; ++G) {
			if (B[G] == H) {
				return G;
			}
		}
		return -1;
	};
	var D = function (G) {
		var J = G.totalFrames;
		var I = G.currentFrame;
		var H = (G.currentFrame * G.duration * 1000 / G.totalFrames);
		var F = (new Date() - G.getStartTime());
		var K = 0;
		if (F < G.duration * 1000) {
			K = Math.round((F / H - 1) * G.currentFrame);
		} else {
			K = J - (I + 1);
		}
		if (K > 0 && isFinite(K)) {
			if (G.currentFrame + K >= J) {
				K = J - (I + 1);
			}
			G.currentFrame += K;
		}
	};
};
YAHOO.util.Bezier = new function () {
	this.getPosition = function (E, D) {
		var F = E.length;
		var C = [];
		for (var B = 0; B < F; ++B) {
			C[B] = [E[B][0], E[B][1]];
		}
		for (var A = 1; A < F; ++A) {
			for (B = 0; B < F - A; ++B) {
				C[B][0] = (1 - D) * C[B][0] + D * C[parseInt(B + 1, 10)][0];
				C[B][1] = (1 - D) * C[B][1] + D * C[parseInt(B + 1, 10)][1];
			}
		}
		return [C[0][0], C[0][1]];
	};
};
(function () {
	var A = function (F, E, G, H) {
		A.superclass.constructor.call(this, F, E, G, H);
	};
	A.NAME = "ColorAnim";
	var C = YAHOO.util;
	YAHOO.extend(A, C.Anim);
	var D = A.superclass;
	var B = A.prototype;
	B.patterns.color = /color$/i;
	B.patterns.rgb = /^rgb\(([0-9]+)\s*,\s*([0-9]+)\s*,\s*([0-9]+)\)$/i;
	B.patterns.hex = /^#?([0-9A-F]{2})([0-9A-F]{2})([0-9A-F]{2})$/i;
	B.patterns.hex3 = /^#?([0-9A-F]{1})([0-9A-F]{1})([0-9A-F]{1})$/i;
	B.patterns.transparent = /^transparent|rgba\(0, 0, 0, 0\)$/;
	B.parseColor = function (E) {
		if (E.length == 3) {
			return E;
		}
		var F = this.patterns.hex.exec(E);
		if (F && F.length == 4) {
			return [parseInt(F[1], 16), parseInt(F[2], 16), parseInt(F[3], 16)];
		}
		F = this.patterns.rgb.exec(E);
		if (F && F.length == 4) {
			return [parseInt(F[1], 10), parseInt(F[2], 10), parseInt(F[3], 10)];
		}
		F = this.patterns.hex3.exec(E);
		if (F && F.length == 4) {
			return [parseInt(F[1] + F[1], 16), parseInt(F[2] + F[2], 16), parseInt(F[3] + F[3], 16)];
		}
		return null;
	};
	B.getAttribute = function (E) {
		var G = this.getEl();
		if (this.patterns.color.test(E)) {
			var H = YAHOO.util.Dom.getStyle(G, E);
			if (this.patterns.transparent.test(H)) {
				var F = G.parentNode;
				H = C.Dom.getStyle(F, E);
				while (F && this.patterns.transparent.test(H)) {
					F = F.parentNode;
					H = C.Dom.getStyle(F, E);
					if (F.tagName.toUpperCase() == "HTML") {
						H = "#fff";
					}
				}
			}
		} else {
			H = D.getAttribute.call(this, E);
		}
		return H;
	};
	B.doMethod = function (F, J, G) {
		var I;
		if (this.patterns.color.test(F)) {
			I = [];
			for (var H = 0, E = J.length; H < E; ++H) {
				I[H] = D.doMethod.call(this, F, J[H], G[H]);
			}
			I = "rgb(" + Math.floor(I[0]) + "," + Math.floor(I[1]) + "," + Math.floor(I[2]) + ")";
		} else {
			I = D.doMethod.call(this, F, J, G);
		}
		return I;
	};
	B.setRuntimeAttribute = function (F) {
		D.setRuntimeAttribute.call(this, F);
		if (this.patterns.color.test(F)) {
			var H = this.attributes;
			var J = this.parseColor(this.runtimeAttributes[F].start);
			var G = this.parseColor(this.runtimeAttributes[F].end);
			if (typeof H[F]["to"] === "undefined" && typeof H[F]["by"] !== "undefined") {
				G = this.parseColor(H[F].by);
				for (var I = 0, E = J.length; I < E; ++I) {
					G[I] = J[I] + G[I];
				}
			}
			this.runtimeAttributes[F].start = J;
			this.runtimeAttributes[F].end = G;
		}
	};
	C.ColorAnim = A;
})();
/*
TERMS OF USE - EASING EQUATIONS
Open source under the BSD License.
Copyright 2001 Robert Penner All rights reserved.

Redistribution and use in source and binary forms, with or without modification, are permitted provided that the following conditions are met:

 * Redistributions of source code must retain the above copyright notice, this list of conditions and the following disclaimer.
 * Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the following disclaimer in the documentation and/or other materials provided with the distribution.
 * Neither the name of the author nor the names of contributors may be used to endorse or promote products derived from this software without specific prior written permission.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/
YAHOO.util.Easing = {easeNone:function (B, A, D, C) {
	return D * B / C + A;
}, easeIn:function (B, A, D, C) {
	return D * (B /= C) * B + A;
}, easeOut:function (B, A, D, C) {
	return -D * (B /= C) * (B - 2) + A;
}, easeBoth:function (B, A, D, C) {
	if ((B /= C / 2) < 1) {
		return D / 2 * B * B + A;
	}
	return -D / 2 * ((--B) * (B - 2) - 1) + A;
}, easeInStrong:function (B, A, D, C) {
	return D * (B /= C) * B * B * B + A;
}, easeOutStrong:function (B, A, D, C) {
	return -D * ((B = B / C - 1) * B * B * B - 1) + A;
}, easeBothStrong:function (B, A, D, C) {
	if ((B /= C / 2) < 1) {
		return D / 2 * B * B * B * B + A;
	}
	return -D / 2 * ((B -= 2) * B * B * B - 2) + A;
}, elasticIn:function (C, A, G, F, B, E) {
	if (C == 0) {
		return A;
	}
	if ((C /= F) == 1) {
		return A + G;
	}
	if (!E) {
		E = F * 0.3;
	}
	if (!B || B < Math.abs(G)) {
		B = G;
		var D = E / 4;
	} else {
		var D = E / (2 * Math.PI) * Math.asin(G / B);
	}
	return -(B * Math.pow(2, 10 * (C -= 1)) * Math.sin((C * F - D) * (2 * Math.PI) / E)) + A;
}, elasticOut:function (C, A, G, F, B, E) {
	if (C == 0) {
		return A;
	}
	if ((C /= F) == 1) {
		return A + G;
	}
	if (!E) {
		E = F * 0.3;
	}
	if (!B || B < Math.abs(G)) {
		B = G;
		var D = E / 4;
	} else {
		var D = E / (2 * Math.PI) * Math.asin(G / B);
	}
	return B * Math.pow(2, -10 * C) * Math.sin((C * F - D) * (2 * Math.PI) / E) + G + A;
}, elasticBoth:function (C, A, G, F, B, E) {
	if (C == 0) {
		return A;
	}
	if ((C /= F / 2) == 2) {
		return A + G;
	}
	if (!E) {
		E = F * (0.3 * 1.5);
	}
	if (!B || B < Math.abs(G)) {
		B = G;
		var D = E / 4;
	} else {
		var D = E / (2 * Math.PI) * Math.asin(G / B);
	}
	if (C < 1) {
		return -0.5 * (B * Math.pow(2, 10 * (C -= 1)) * Math.sin((C * F - D) * (2 * Math.PI) / E)) + A;
	}
	return B * Math.pow(2, -10 * (C -= 1)) * Math.sin((C * F - D) * (2 * Math.PI) / E) * 0.5 + G + A;
}, backIn:function (B, A, E, D, C) {
	if (typeof C == "undefined") {
		C = 1.70158;
	}
	return E * (B /= D) * B * ((C + 1) * B - C) + A;
}, backOut:function (B, A, E, D, C) {
	if (typeof C == "undefined") {
		C = 1.70158;
	}
	return E * ((B = B / D - 1) * B * ((C + 1) * B + C) + 1) + A;
}, backBoth:function (B, A, E, D, C) {
	if (typeof C == "undefined") {
		C = 1.70158;
	}
	if ((B /= D / 2) < 1) {
		return E / 2 * (B * B * (((C *= (1.525)) + 1) * B - C)) + A;
	}
	return E / 2 * ((B -= 2) * B * (((C *= (1.525)) + 1) * B + C) + 2) + A;
}, bounceIn:function (B, A, D, C) {
	return D - YAHOO.util.Easing.bounceOut(C - B, 0, D, C) + A;
}, bounceOut:function (B, A, D, C) {
	if ((B /= C) < (1 / 2.75)) {
		return D * (7.5625 * B * B) + A;
	} else {
		if (B < (2 / 2.75)) {
			return D * (7.5625 * (B -= (1.5 / 2.75)) * B + 0.75) + A;
		} else {
			if (B < (2.5 / 2.75)) {
				return D * (7.5625 * (B -= (2.25 / 2.75)) * B + 0.9375) + A;
			}
		}
	}
	return D * (7.5625 * (B -= (2.625 / 2.75)) * B + 0.984375) + A;
}, bounceBoth:function (B, A, D, C) {
	if (B < C / 2) {
		return YAHOO.util.Easing.bounceIn(B * 2, 0, D, C) * 0.5 + A;
	}
	return YAHOO.util.Easing.bounceOut(B * 2 - C, 0, D, C) * 0.5 + D * 0.5 + A;
}};
(function () {
	var A = function (H, G, I, J) {
		if (H) {
			A.superclass.constructor.call(this, H, G, I, J);
		}
	};
	A.NAME = "Motion";
	var E = YAHOO.util;
	YAHOO.extend(A, E.ColorAnim);
	var F = A.superclass;
	var C = A.prototype;
	C.patterns.points = /^points$/i;
	C.setAttribute = function (G, I, H) {
		if (this.patterns.points.test(G)) {
			H = H || "px";
			F.setAttribute.call(this, "left", I[0], H);
			F.setAttribute.call(this, "top", I[1], H);
		} else {
			F.setAttribute.call(this, G, I, H);
		}
	};
	C.getAttribute = function (G) {
		if (this.patterns.points.test(G)) {
			var H = [F.getAttribute.call(this, "left"), F.getAttribute.call(this, "top")];
		} else {
			H = F.getAttribute.call(this, G);
		}
		return H;
	};
	C.doMethod = function (G, K, H) {
		var J = null;
		if (this.patterns.points.test(G)) {
			var I = this.method(this.currentFrame, 0, 100, this.totalFrames) / 100;
			J = E.Bezier.getPosition(this.runtimeAttributes[G], I);
		} else {
			J = F.doMethod.call(this, G, K, H);
		}
		return J;
	};
	C.setRuntimeAttribute = function (P) {
		if (this.patterns.points.test(P)) {
			var H = this.getEl();
			var J = this.attributes;
			var G;
			var L = J["points"]["control"] || [];
			var I;
			var M, O;
			if (L.length > 0 && !(L[0] instanceof Array)) {
				L = [L];
			} else {
				var K = [];
				for (M = 0, O = L.length; M < O; ++M) {
					K[M] = L[M];
				}
				L = K;
			}
			if (E.Dom.getStyle(H, "position") == "static") {
				E.Dom.setStyle(H, "position", "relative");
			}
			if (D(J["points"]["from"])) {
				E.Dom.setXY(H, J["points"]["from"]);
			} else {
				E.Dom.setXY(H, E.Dom.getXY(H));
			}
			G = this.getAttribute("points");
			if (D(J["points"]["to"])) {
				I = B.call(this, J["points"]["to"], G);
				var N = E.Dom.getXY(this.getEl());
				for (M = 0, O = L.length; M < O; ++M) {
					L[M] = B.call(this, L[M], G);
				}
			} else {
				if (D(J["points"]["by"])) {
					I = [G[0] + J["points"]["by"][0], G[1] + J["points"]["by"][1]];
					for (M = 0, O = L.length; M < O; ++M) {
						L[M] = [G[0] + L[M][0], G[1] + L[M][1]];
					}
				}
			}
			this.runtimeAttributes[P] = [G];
			if (L.length > 0) {
				this.runtimeAttributes[P] = this.runtimeAttributes[P].concat(L);
			}
			this.runtimeAttributes[P][this.runtimeAttributes[P].length] = I;
		} else {
			F.setRuntimeAttribute.call(this, P);
		}
	};
	var B = function (G, I) {
		var H = E.Dom.getXY(this.getEl());
		G = [G[0] - H[0] + I[0], G[1] - H[1] + I[1]];
		return G;
	};
	var D = function (G) {
		return (typeof G !== "undefined");
	};
	E.Motion = A;
})();
(function () {
	var D = function (F, E, G, H) {
		if (F) {
			D.superclass.constructor.call(this, F, E, G, H);
		}
	};
	D.NAME = "Scroll";
	var B = YAHOO.util;
	YAHOO.extend(D, B.ColorAnim);
	var C = D.superclass;
	var A = D.prototype;
	A.doMethod = function (E, H, F) {
		var G = null;
		if (E == "scroll") {
			G = [this.method(this.currentFrame, H[0], F[0] - H[0], this.totalFrames), this.method(this.currentFrame, H[1], F[1] - H[1], this.totalFrames)];
		} else {
			G = C.doMethod.call(this, E, H, F);
		}
		return G;
	};
	A.getAttribute = function (E) {
		var G = null;
		var F = this.getEl();
		if (E == "scroll") {
			G = [F.scrollLeft, F.scrollTop];
		} else {
			G = C.getAttribute.call(this, E);
		}
		return G;
	};
	A.setAttribute = function (E, H, G) {
		var F = this.getEl();
		if (E == "scroll") {
			F.scrollLeft = H[0];
			F.scrollTop = H[1];
		} else {
			C.setAttribute.call(this, E, H, G);
		}
	};
	B.Scroll = D;
})();
YAHOO.register("animation", YAHOO.util.Anim, {version:"2.5.2", build:"1076"});

