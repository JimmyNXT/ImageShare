(this.webpackJsonpjs=this.webpackJsonpjs||[]).push([[0],{15:function(e,t,n){},17:function(e,t,n){},19:function(e,t,n){"use strict";n.r(t);var a=n(0),s=n.n(a),r=n(10),c=n.n(r),i=(n(15),n(5)),o=n.n(i),l=n(7),j=n(3),u=n(6),b=n(2);n(17);function m(e){for(var t=e+"=",n=decodeURIComponent(document.cookie).split(";"),a=0;a<n.length;a++){for(var s=n[a];" "===s.charAt(0);)s=s.substring(1);if(0===s.indexOf(t))return s.substring(t.length,s.length)}return""}function d(e,t){var n=new Date;n.setTime(n.getTime()+36e6);var a="expires="+n.toUTCString();document.cookie=e+"="+t+";"+a+";path=/"}var p=n(1),h=function(e){var t;return t=e.username?Object(p.jsxs)("ul",{className:"navbar-nav me-auto mb-2 mb-md-0",children:[Object(p.jsx)("li",{className:"nav-item active",children:Object(p.jsxs)(u.b,{className:"nav-link",to:"/user",children:[Object(p.jsxs)("svg",{xmlns:"http://www.w3.org/2000/svg",width:"26",height:"16",fill:"currentColor",className:"bi bi-person-circle",viewBox:"0 0 16 16",children:[Object(p.jsx)("path",{d:"M11 6a3 3 0 1 1-6 0 3 3 0 0 1 6 0z"}),Object(p.jsx)("path",{"fill-rule":"evenodd",d:"M0 8a8 8 0 1 1 16 0A8 8 0 0 1 0 8zm8-7a7 7 0 0 0-5.468 11.37C3.242 11.226 4.805 10 8 10s4.757 1.225 5.468 2.37A7 7 0 0 0 8 1z"})]}),e.username]})}),Object(p.jsx)("li",{className:"nav-item active",children:Object(p.jsx)(u.b,{className:"nav-link",to:"/login",onClick:function(){var t;e.setHasJWT(!1),t="jwt",document.cookie=t+"=;expires=Thu, 01 Jan 1970 00:00:00 UTC;path=/;"},children:"Logout"})})]}):Object(p.jsxs)("ul",{className:"navbar-nav me-auto mb-2 mb-md-0",children:[Object(p.jsx)("li",{className:"nav-item active",children:Object(p.jsx)(u.b,{className:"nav-link",to:"/login",children:"Login"})}),Object(p.jsx)("li",{className:"nav-item active",children:Object(p.jsx)(u.b,{className:"nav-link",to:"/register",children:"Register"})})]}),Object(p.jsx)("nav",{className:"navbar navbar-expand-md navbar-dark bg-dark mb-4",children:Object(p.jsxs)("div",{className:"container-fluid",children:[Object(p.jsx)(u.b,{className:"navbar-brand",to:"/",children:"Image Share"}),Object(p.jsx)("div",{children:t})]})})},O=function(e){return Object(p.jsx)("div",{children:e.username?"Hey "+e.username:"You are not loged in"})},f=function(e){var t=Object(a.useState)(""),n=Object(j.a)(t,2),s=n[0],r=n[1],c=Object(a.useState)(""),i=Object(j.a)(c,2),u=i[0],m=i[1],h=Object(a.useState)(!1),O=Object(j.a)(h,2),f=O[0],x=O[1],v=function(){var t=Object(l.a)(o.a.mark((function t(n){var a,r;return o.a.wrap((function(t){for(;;)switch(t.prev=t.next){case 0:return n.preventDefault(),t.next=3,fetch("/auth/authenticate",{method:"POST",headers:{"Content-Type":"application/json",Accept:"application/json"},body:JSON.stringify({username:s,password:u})});case 3:return a=t.sent,t.next=6,a.json();case 6:r=t.sent,console.log(r),r.jwt&&d("jwt","Bearer "+r.jwt),"BAD_REQUEST"===r.httpStatus?console.log("Title: "+r.title+", Message: "+r.message):(e.setHasJWT(!0),x(!0));case 10:case"end":return t.stop()}}),t)})));return function(e){return t.apply(this,arguments)}}();if(f)return Object(p.jsx)(b.a,{to:"/"});var g=Object(p.jsxs)("form",{onSubmit:v,children:[Object(p.jsx)("h1",{className:"h3 mb-3 fw-normal",children:"Please sign in"}),Object(p.jsx)("input",{type:"username",className:"form-control",placeholder:"Username",required:!0,onChange:function(e){return r(e.target.value)}}),Object(p.jsx)("input",{type:"password",className:"form-control",placeholder:"Password",required:!0,onChange:function(e){return m(e.target.value)}}),Object(p.jsx)("button",{className:"w-100 btn btn-lg btn-primary",type:"submit",children:"Sign in"})]});return e.propUsername&&(g=Object(p.jsxs)("h1",{className:"h3 mb-3 fw-normal",children:["You are currently logen in as ",e.propUsername]})),Object(p.jsx)("div",{children:g})},x=function(){var e=Object(a.useState)(""),t=Object(j.a)(e,2),n=t[0],s=t[1],r=Object(a.useState)(""),c=Object(j.a)(r,2),i=c[0],u=c[1],m=Object(a.useState)(""),d=Object(j.a)(m,2),h=d[0],O=d[1],f=Object(a.useState)(!1),x=Object(j.a)(f,2),v=x[0],g=x[1],w=function(){var e=Object(l.a)(o.a.mark((function e(t){return o.a.wrap((function(e){for(;;)switch(e.prev=e.next){case 0:return t.preventDefault(),"",e.next=4,fetch("/auth/register",{method:"POST",headers:{"Content-Type":"application/json",Accept:"application/json"},body:JSON.stringify({username:n,email:i,password:h})});case 4:g(!0);case 5:case"end":return e.stop()}}),e)})));return function(t){return e.apply(this,arguments)}}();return v?Object(p.jsx)(b.a,{to:"/login"}):Object(p.jsxs)("form",{onSubmit:w,children:[Object(p.jsx)("h1",{className:"h3 mb-3 fw-normal",children:"Please Register Here"}),Object(p.jsx)("input",{type:"username",className:"form-control",placeholder:"Username",required:!0,onChange:function(e){return s(e.target.value)}}),Object(p.jsx)("input",{type:"email",className:"form-control",placeholder:"name@example.com",required:!0,onChange:function(e){return u(e.target.value)}}),Object(p.jsx)("input",{type:"password",className:"form-control",placeholder:"Password",required:!0,onChange:function(e){return O(e.target.value)}}),Object(p.jsx)("button",{className:"w-100 btn btn-lg btn-primary",type:"submit",children:"Register"})]})};var v=function(){var e=Object(a.useState)(""),t=Object(j.a)(e,2),n=t[0],s=t[1],r=Object(a.useState)(!1),c=Object(j.a)(r,2),i=(c[0],c[1]);return Object(a.useEffect)((function(){console.log("Test"),m("jwt")&&Object(l.a)(o.a.mark((function e(){var t,n;return o.a.wrap((function(e){for(;;)switch(e.prev=e.next){case 0:return e.next=2,fetch("/api/user",{headers:{"Content-Type":"application/json",Accept:"application/json",Authorisation:m("jwt")}});case 2:return t=e.sent,e.next=5,t.json();case 5:n=e.sent,console.log(n),s(n.username);case 8:case"end":return e.stop()}}),e)})))()})),Object(p.jsx)(u.a,{children:Object(p.jsxs)("div",{className:"App",children:[Object(p.jsx)(h,{username:n,setHasJWT:i}),Object(p.jsx)("main",{className:"form-signin",children:Object(p.jsxs)(b.d,{children:[Object(p.jsx)(b.b,{path:"/",element:Object(p.jsx)(O,{username:n})}),Object(p.jsx)(b.b,{path:"/login",element:Object(p.jsx)(f,{propUsername:n,setHasJWT:i})}),Object(p.jsx)(b.b,{path:"/register",element:Object(p.jsx)(x,{})})]})})]})})},g=function(e){e&&e instanceof Function&&n.e(3).then(n.bind(null,20)).then((function(t){var n=t.getCLS,a=t.getFID,s=t.getFCP,r=t.getLCP,c=t.getTTFB;n(e),a(e),s(e),r(e),c(e)}))};c.a.render(Object(p.jsx)(s.a.StrictMode,{children:Object(p.jsx)(v,{})}),document.getElementById("root")),g()}},[[19,1,2]]]);
//# sourceMappingURL=main.d0c11ae5.chunk.js.map