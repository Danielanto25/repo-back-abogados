"use strict";(self.webpackChunkAbogadosFront=self.webpackChunkAbogadosFront||[]).push([[526],{4526:(A,d,i)=>{i.r(d),i.d(d,{ListadoUsuariosModule:()=>P});var l=i(6895),c=i(3599),p=i(5226),h=i.n(p),m=i(5508),t=i(8256),f=i(7597),b=i(7185),C=i(8718),u=i(3968),s=i(433);function U(o,a){if(1&o){const n=t.EpF();t.TgZ(0,"button",18),t.NdJ("click",function(){t.CHM(n);const r=t.oxw().$implicit,g=t.oxw();return t.KtG(g.eliminar(r.id))}),t._UZ(1,"img",19),t.qZA()}}const M=function(o){return["/editar-usuario",o]};function O(o,a){if(1&o&&(t.TgZ(0,"tr")(1,"td"),t._uU(2),t.qZA(),t.TgZ(3,"td"),t._uU(4),t.qZA(),t.TgZ(5,"td",12)(6,"div",13),t._uU(7),t.qZA()(),t.TgZ(8,"td",14),t.YNc(9,U,2,0,"button",15),t.TgZ(10,"button",16),t._UZ(11,"img",17),t.qZA()()()),2&o){const n=a.$implicit,e=t.oxw();t.xp6(2),t.hij(" ",n.usuario.nombre," "),t.xp6(2),t.Oqu(n.usuario.email),t.xp6(3),t.hij(" ",n.rol.nombre," "),t.xp6(2),t.Q6J("ngIf",e.superAdmin),t.xp6(1),t.Q6J("routerLink",t.VKq(5,M,n.usuario.id))}}const _=[{path:"",component:(()=>{class o{constructor(n,e,r){this.usuarioRolService=n,this.toastr=e,this.logicaGuard=r,this.superAdmin=this.logicaGuard.permisoValido([m.r.superAdmin]),this.page=1,this.pageSize=10,this.users=[],this.USER=[],this.collectionSize=this.USER.length,this.mensajeSatisfactorio="Satisfactorio",this.refreshUsers()}ngOnInit(){this.listar()}refreshUsers(){this.users=this.USER.map((n,e)=>({id:e+1,...n})).slice((this.page-1)*this.pageSize,(this.page-1)*this.pageSize+this.pageSize)}listar(){this.usuarioRolService.getUsuarioRol().subscribe(n=>{this.users=n,this.USER=n,this.collectionSize=this.users.length})}mensajeError(n){console.log(n),this.toastr.error("Ha Ocurrido un Problema")}eliminar(n){h().fire({title:"Est\xe1s seguro?",text:"No Podras Revertir!",icon:"warning",showCancelButton:!0,confirmButtonColor:"#3085d6",cancelButtonColor:"#d33",confirmButtonText:"S\xed, Eliminar!"}).then(e=>{e.isConfirmed&&this.usuarioRolService.eliminar(n).subscribe(r=>{this.toastr.success(this.mensajeSatisfactorio),this.listar()},r=>this.mensajeError(r))})}}return o.\u0275fac=function(n){return new(n||o)(t.Y36(f.U),t.Y36(b._W),t.Y36(C.b))},o.\u0275cmp=t.Xpm({type:o,selectors:[["app-listado-usuarios"]],decls:35,vars:10,consts:[[1,"container-table"],[2,"text-align","center"],["onclick","location.href='registrar-usuario';",1,"btn"],[1,"table","table-striped"],["scope","col"],["scope","col",1,"width-1"],[4,"ngFor","ngForOf"],["colspan","4"],[1,"d-flex","justify-content-end","p-2"],[1,"form-select",2,"width","auto",3,"ngModel","ngModelChange"],[3,"ngValue"],[1,"pagination",3,"collectionSize","page","pageSize","pageChange"],[1,"width-1"],[1,"rol-box"],[1,"d-flex"],["class","button-list",3,"click",4,"ngIf"],[1,"button-list",3,"routerLink"],["src","../../../../../assets/imgs/lapiz.png","alt","",1,"img-list"],[1,"button-list",3,"click"],["src","../../../../../assets/imgs/papelera.png","alt","",1,"img-list"]],template:function(n,e){1&n&&(t.TgZ(0,"div",0)(1,"h1"),t._uU(2,"LISTADO USUARIOS"),t.qZA(),t.TgZ(3,"div",1)(4,"button",2),t._uU(5," Crear Usuario "),t.qZA()(),t.TgZ(6,"table",3)(7,"thead")(8,"tr")(9,"th",4),t._uU(10,"NOMBRE"),t.qZA(),t.TgZ(11,"th",4),t._uU(12,"CORREO ELECTRONICO"),t.qZA(),t.TgZ(13,"th",4),t._uU(14,"ROL"),t.qZA(),t.TgZ(15,"th",5),t._uU(16,"ACCIONES"),t.qZA()()(),t.TgZ(17,"tbody"),t.YNc(18,O,12,7,"tr",6),t.qZA(),t.TgZ(19,"tfoot")(20,"tr")(21,"td",7)(22,"div",8)(23,"select",9),t.NdJ("ngModelChange",function(g){return e.pageSize=g})("ngModelChange",function(){return e.refreshUsers()}),t.TgZ(24,"option",10),t._uU(25,"2 items for page"),t.qZA(),t.TgZ(26,"option",10),t._uU(27,"4 items for page"),t.qZA(),t.TgZ(28,"option",10),t._uU(29,"6 items for page"),t.qZA(),t.TgZ(30,"option",10),t._uU(31,"8 items for page"),t.qZA(),t.TgZ(32,"option",10),t._uU(33,"10 items for page"),t.qZA()(),t.TgZ(34,"ngb-pagination",11),t.NdJ("pageChange",function(g){return e.page=g})("pageChange",function(){return e.refreshUsers()}),t.qZA()()()()()()()),2&n&&(t.xp6(18),t.Q6J("ngForOf",e.users),t.xp6(5),t.Q6J("ngModel",e.pageSize),t.xp6(1),t.Q6J("ngValue",2),t.xp6(2),t.Q6J("ngValue",4),t.xp6(2),t.Q6J("ngValue",6),t.xp6(2),t.Q6J("ngValue",8),t.xp6(2),t.Q6J("ngValue",10),t.xp6(2),t.Q6J("collectionSize",e.collectionSize)("page",e.page)("pageSize",e.pageSize))},dependencies:[l.sg,l.O5,c.rH,u.N9,s.YN,s.Kr,s.EJ,s.JJ,s.On],styles:["*[_ngcontent-%COMP%]{font-family:Arial Narrow,Arial,sans-serif}h1[_ngcontent-%COMP%]{text-align:center}.btn[_ngcontent-%COMP%]{background-color:#fe8910;color:#fff;padding:5px;border:none;width:50%;margin:.6rem 0 1.5rem;justify-content:center;border-radius:15px}.btn[_ngcontent-%COMP%]:hover{color:#f7f7f7;background-color:#868789}.container-table[_ngcontent-%COMP%]{padding:2rem 0;width:60%;margin:auto}th[_ngcontent-%COMP%]{background-color:#fe8910;color:#fff;font-weight:400}.table-striped[_ngcontent-%COMP%]   tbody[_ngcontent-%COMP%]   tr[_ngcontent-%COMP%]:nth-of-type(odd){background-color:transparent!important}.table-striped[_ngcontent-%COMP%] > tbody[_ngcontent-%COMP%] > tr[_ngcontent-%COMP%]:nth-of-type(odd) > *[_ngcontent-%COMP%]{--bs-table-accent-bg: transparent!important}table.table[_ngcontent-%COMP%]{background-color:#66666640;width:100%;text-align:center}.width-1[_ngcontent-%COMP%]{width:10%}.rol-box[_ngcontent-%COMP%]{color:#f7f7f7;background-color:#868789;border-radius:15px}table.table[_ngcontent-%COMP%]   td[_ngcontent-%COMP%], table.table[_ngcontent-%COMP%]   th[_ngcontent-%COMP%]{border:0px solid;padding-right:2rem}.form-select[_ngcontent-%COMP%]{background-color:#6660;border:none;color:#868789}.button-list[_ngcontent-%COMP%]{border:none;background:none}.img-list[_ngcontent-%COMP%]{filter:brightness(0) saturate(100%) invert(49%) sepia(98%) saturate(731%) hue-rotate(352deg) brightness(103%) contrast(99%)}.img-list[_ngcontent-%COMP%]{width:2rem}.pagination[_ngcontent-%COMP%]{padding-top:1rem}ngb-pagination[_ngcontent-%COMP%]     .page-item.disabled   .page-link{color:#6c757d;cursor:pointer;background-color:transparent;border-color:transparent}ngb-pagination[_ngcontent-%COMP%]     .page-item   .page-link{color:#6c757d;cursor:pointer;background-color:transparent;border-color:transparent}ngb-pagination[_ngcontent-%COMP%]     .page-item.active   .page-link{border-radius:50%;background-color:#f7f7f7;color:#6c757d;border:none}@media (max-width:1023px){.container-table[_ngcontent-%COMP%]{width:90%}.btn[_ngcontent-%COMP%]{width:70%}}@media screen and (max-width: 576px){table[_ngcontent-%COMP%]{display:block;overflow-x:auto}}"]}),o})()}];let Z=(()=>{class o{}return o.\u0275fac=function(n){return new(n||o)},o.\u0275mod=t.oAB({type:o}),o.\u0275inj=t.cJS({imports:[c.Bz.forChild(_),c.Bz]}),o})(),P=(()=>{class o{}return o.\u0275fac=function(n){return new(n||o)},o.\u0275mod=t.oAB({type:o}),o.\u0275inj=t.cJS({imports:[l.ez,Z,u.jF,u._A,s.u5]}),o})()}}]);