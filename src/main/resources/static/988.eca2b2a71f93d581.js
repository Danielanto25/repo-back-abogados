"use strict";(self.webpackChunkAbogadosFront=self.webpackChunkAbogadosFront||[]).push([[988],{7988:(D,c,n)=>{n.r(c),n.d(c,{EditarUsuariosModule:()=>P});var f=n(6895),e=n(433),l=n(3599),h=n(1353),v=n(5218),b=n(3696),g=n(2531),C=n(5156),U=n(5226),p=n.n(U),o=n(8256),Z=n(8081),w=n(5763),A=n(7597),y=n(7185),T=n(9799);function x(i,s){if(1&i&&(o.TgZ(0,"option",26),o._uU(1),o.qZA()),2&i){const t=s.$implicit;o.s9C("value",t.id),o.xp6(1),o.hij(" ",t.nombre," ")}}function E(i,s){if(1&i&&(o.TgZ(0,"option",26),o._uU(1),o.qZA()),2&i){const t=s.$implicit;o.s9C("value",t.id),o.xp6(1),o.hij(" ",t.nombre," ")}}const N=[{path:"",component:(()=>{class i{constructor(t,r,a,u,m,d,I,O){this.roleService=t,this.usuarioService=r,this.usuarioRolService=a,this.fb=u,this.toastr=m,this.tipoDocumentoService=d,this.ruta=I,this.router=O,this.mensajeSatisfactorio="Satisfactorio",this.editar=!1,this.textoBoton="Editar Registro",this.usuario=new g.b,this.id=Number(this.ruta.snapshot.paramMap.get("id"))}ngOnInit(){this.listarRoles(),this.initForm(),this.listarTiposDocumento()}listarRoles(){this.roleService.getRol().subscribe(t=>{this.lstRoles=t,this.listarPorId(this.id)})}listarPorId(t){console.log(this.id),this.usuarioRolService.listarPorId(t).subscribe(r=>{console.log(r),this.form.get("id").setValue(r.id),this.form.get("nombre").setValue(r.usuario.nombre),this.form.get("apellido").setValue(r.usuario.apellido),this.form.get("email").setValue(r.usuario.email),this.form.get("tipoDocumento").setValue(r.usuario.tipoDocumento.id),this.form.get("documento").setValue(r.usuario.documento),this.form.get("rol").setValue(r.rol.id)})}listarTiposDocumento(){this.tipoDocumentoService.getTipoDocumento().subscribe(t=>{this.lstTiposDocumento=t})}initForm(){this.form=this.fb.group({id:new e.NI(""),nombre:new e.NI("",e.kI.required),apellido:new e.NI("",e.kI.required),email:new e.NI("",e.kI.required),password:new e.NI("",e.kI.required),secondPassword:new e.NI("",e.kI.required),documento:new e.NI("",e.kI.required),rol:new e.NI(0,e.kI.required),tipoDocumento:new e.NI(0,e.kI.required)})}mensajeError(t){console.log(t),this.toastr.error("Ha Ocurrido un Problema")}clickEnviar(){let t=new C.H,r=new g.b,a=new v.L,u=new b.A,m=new h.G;m.id=1,r.estado=m,r.id=this.form.get("id").value,r.nombre=this.form.get("nombre").value,r.apellido=this.form.get("apellido").value,r.email=this.form.get("email").value,r.password=this.form.get("password").value,r.documento=this.form.get("documento").value,u.id=this.form.get("tipoDocumento").value,r.tipoDocumento=u,a.id=this.form.get("rol").value,t.usuario=r,t.rol=a,console.log(t),r.password!=this.form.get("secondPassword").value?p().fire({title:"Las contrase\xf1as son distintas",icon:"warning"}):p().fire({title:"Est\xe1s seguro?",text:"No Podras Revertir!",icon:"warning",showCancelButton:!0,confirmButtonColor:"#3085d6",cancelButtonColor:"#d33",confirmButtonText:"S\xed, Actualizar!"}).then(d=>{d.isConfirmed&&this.modificar(t)})}modificar(t){this.usuarioService.modificar(t).subscribe(r=>{this.toastr.success(this.mensajeSatisfactorio),this.form.reset(),this.router.navigateByUrl("listado-usuario")},r=>this.mensajeError(r))}}return i.\u0275fac=function(t){return new(t||i)(o.Y36(Z.m),o.Y36(w.i),o.Y36(A.U),o.Y36(e.qu),o.Y36(y._W),o.Y36(T.d),o.Y36(l.gz),o.Y36(l.F0))},i.\u0275cmp=o.Xpm({type:i,selectors:[["app-editar-usuarios"]],decls:57,vars:4,consts:[[1,"container-form"],[2,"text-align","center"],["onclick","location.href='listado-usuario';",1,"btn"],[1,"align-center"],[1,"form",3,"formGroup"],["for","name",1,"text-gray"],["type","text","name","name","required","","formControlName","nombre"],["for","apellido",1,"text-gray"],["type","text","name","apellido","required","","formControlName","apellido"],["for","email",1,"text-gray"],["type","email","name","email","required","","formControlName","email"],[1,"d-flex","justify-content-between"],[1,"inputs"],["for","psw",1,"text-gray"],["type","password","name","psw","required","","formControlName","password"],["for","c-psw",1,"text-gray"],["type","password","name","c-psw","required","","formControlName","secondPassword"],["for","documento",1,"text-gray"],["type","text","name","documento","required","","formControlName","documento"],["for","tipoDocumento",1,"text-gray"],["name","tipoDocumento","id","tipoDocumento-select","formControlName","tipoDocumento"],["value","0"],[3,"value",4,"ngFor","ngForOf"],["for","rol",1,"text-gray"],["name","Rols","id","rol-select","formControlName","rol"],["type","submit",1,"btn","btn-form",3,"disabled","click"],[3,"value"]],template:function(t,r){1&t&&(o.TgZ(0,"div",0)(1,"h1"),o._uU(2,"EDITAR USUARIO"),o.qZA(),o.TgZ(3,"div",1)(4,"button",2),o._uU(5," Listado de Usuario "),o.qZA()(),o.TgZ(6,"div",3)(7,"form",4)(8,"label",5),o._uU(9,"Nombre"),o.qZA(),o._UZ(10,"br")(11,"input",6)(12,"br"),o.TgZ(13,"label",7),o._uU(14,"Apellido"),o.qZA(),o._UZ(15,"br")(16,"input",8)(17,"br"),o.TgZ(18,"label",9),o._uU(19,"Email"),o.qZA(),o._UZ(20,"br")(21,"input",10)(22,"br"),o.TgZ(23,"div",11)(24,"div",12)(25,"label",13),o._uU(26,"Contrase\xf1a"),o.qZA(),o._UZ(27,"br")(28,"input",14)(29,"br"),o.qZA(),o.TgZ(30,"div",12)(31,"label",15),o._uU(32,"Confirmar Contrase\xf1a"),o.qZA(),o._UZ(33,"br")(34,"input",16)(35,"br"),o.qZA()(),o.TgZ(36,"label",17),o._uU(37,"Documento"),o.qZA(),o._UZ(38,"br")(39,"input",18)(40,"br"),o.TgZ(41,"label",19),o._uU(42,"Tipo de Documento"),o.qZA(),o._UZ(43,"br"),o.TgZ(44,"select",20)(45,"option",21),o._uU(46,"--Seleccione un tipo de documento--"),o.qZA(),o.YNc(47,x,2,2,"option",22),o.qZA(),o.TgZ(48,"label",23),o._uU(49,"Rol"),o.qZA(),o._UZ(50,"br"),o.TgZ(51,"select",24)(52,"option",21),o._uU(53,"--Seleccione un rol--"),o.qZA(),o.YNc(54,E,2,2,"option",22),o.qZA(),o.TgZ(55,"button",25),o.NdJ("click",function(){return r.clickEnviar()}),o._uU(56," Editar Registro "),o.qZA()()()()),2&t&&(o.xp6(7),o.Q6J("formGroup",r.form),o.xp6(40),o.Q6J("ngForOf",r.lstTiposDocumento),o.xp6(7),o.Q6J("ngForOf",r.lstRoles),o.xp6(1),o.Q6J("disabled",!r.form.valid))},dependencies:[f.sg,e._Y,e.YN,e.Kr,e.Fj,e.EJ,e.JJ,e.JL,e.Q7,e.sg,e.u],styles:["*[_ngcontent-%COMP%]{font-family:Arial Narrow,Arial,sans-serif}h1[_ngcontent-%COMP%]{text-align:center}.align-center[_ngcontent-%COMP%]{display:flex;justify-content:center}.text-gray[_ngcontent-%COMP%]{color:#868789}.container-form[_ngcontent-%COMP%]{padding:2rem 0;width:70%;margin:auto}.btn[_ngcontent-%COMP%]{background-color:#fe8910;color:#fff;padding:5px;border:none;width:65%;margin:.6rem 0 1rem;justify-content:center;border-radius:15px}.btn[_ngcontent-%COMP%]:hover{color:#f7f7f7;background-color:#868789}.btn-form[_ngcontent-%COMP%]{width:100%;padding:1rem}.form[_ngcontent-%COMP%]{width:65%;margin:0 auto}.form[_ngcontent-%COMP%]   input[_ngcontent-%COMP%], select[_ngcontent-%COMP%]{color:#1a1a1a;width:100%;background-color:#66666640;border:none;padding:.6rem;margin-bottom:1rem;border-radius:15px}.form[_ngcontent-%COMP%]   select[_ngcontent-%COMP%]{color:#868789;padding:1rem;text-align:center;border-radius:15px}.form[_ngcontent-%COMP%]   .inputs[_ngcontent-%COMP%]{width:48%}"]}),i})()}];let M=(()=>{class i{}return i.\u0275fac=function(t){return new(t||i)},i.\u0275mod=o.oAB({type:i}),i.\u0275inj=o.cJS({imports:[l.Bz.forChild(N),l.Bz]}),i})(),P=(()=>{class i{}return i.\u0275fac=function(t){return new(t||i)},i.\u0275mod=o.oAB({type:i}),i.\u0275inj=o.cJS({imports:[f.ez,M,e.u5,e.UX]}),i})()}}]);