"use strict";(self.webpackChunkAbogadosFront=self.webpackChunkAbogadosFront||[]).push([[462],{7462:(te,v,s)=>{s.r(v),s.d(v,{RegistrarTareaModule:()=>ee});var b=s(6895),f=s(3599),i=s(433),M=s(2094),O=s(797),A=s(4688),P=s(7524),C=s(4618),w=s(2531),F=s(9764);class N{}class _{}var U=s(2340),I=s(6494),S=s(6026),k=s(3515),e=s(8256),B=s(7191),D=s(5841),E=s(6940),J=s(5763),q=s(6656),j=s(7152),Y=s(7185),y=s(8626);const z=["fileDropRef"];function H(n,l){if(1&n&&(e.TgZ(0,"option",44),e._uU(1),e.qZA()),2&n){const t=l.$implicit;e.s9C("value",t.id),e.xp6(1),e.hij(" ",t.nombre," ")}}function L(n,l){1&n&&e._UZ(0,"a",45),2&n&&e.Q6J("innerHTML",l.$implicit.numeroProceso,e.oJD)}function Q(n,l){1&n&&e._UZ(0,"div",45),2&n&&e.Q6J("innerHTML",l.$implicit,e.oJD)}function $(n,l){if(1&n&&(e.TgZ(0,"option",44),e._uU(1),e.qZA()),2&n){const t=l.$implicit;e.s9C("value",t.id),e.xp6(1),e.hij(" ",t.nombre," ")}}function G(n,l){if(1&n&&(e.TgZ(0,"option",44),e._uU(1),e.qZA()),2&n){const t=l.$implicit;e.s9C("value",t.id),e.xp6(1),e.hij(" ",t.nombre," ")}}function K(n,l){if(1&n){const t=e.EpF();e.TgZ(0,"div",46)(1,"input",47),e.NdJ("change",function(r){const c=e.CHM(t).$implicit,d=e.oxw();return e.KtG(d.onCategoriaPressed(c,r.target.checked))}),e.qZA(),e.TgZ(2,"label",32),e._uU(3),e.qZA()()}if(2&n){const t=l.$implicit;e.xp6(1),e.s9C("value",t.id),e.xp6(2),e.Oqu(t.nombre)}}function V(n,l){if(1&n){const t=e.EpF();e.TgZ(0,"div",48),e._UZ(1,"img",49),e.TgZ(2,"div",50)(3,"h4",51),e._uU(4),e.qZA(),e.TgZ(5,"p",52),e._uU(6),e.qZA()(),e.TgZ(7,"img",53),e.NdJ("click",function(){const a=e.CHM(t).index,c=e.oxw();return e.KtG(c.deleteFile(a))}),e.qZA()()}if(2&n){const t=l.$implicit,o=e.oxw();e.xp6(4),e.hij(" ",null==t?null:t.name," "),e.xp6(2),e.hij(" ",o.formatBytes(null==t?null:t.size)," ")}}const W=[{path:"",component:(()=>{class n{constructor(t,o,r,a,c,d,h,u,g,Z){this.tareaService=t,this.tipoTareaService=o,this.clientesService=r,this.usuarioService=a,this.actuacionesProcesoService=c,this.procesoService=d,this.fb=h,this.toastr=u,this.ruta=g,this.router=Z,this.procesos=[],this.countrykeyword="numeroProceso",this.files=[],this.editar=!1,this.mensajeSatisfactorio="satisfactorio",this.categoriaSelectedArray=[],this.customFilter=function(m,T){return m.filter(x=>x.numeroProceso.toLowerCase().startsWith(T.toLowerCase()))},this.id=Number(this.ruta.snapshot.paramMap.get("id"))}ngOnInit(){this.ListarTipoTarea(),this.listarCliente(),this.listarResponsables(),this.initForm(),this.showDiv(),this.toggle()}onCategoriaPressed(t,o){o?this.categoriaSelectedArray.push(t):this.categoriaSelectedArray.splice(this.categoriaSelectedArray.indexOf(t),1)}ListarTipoTarea(){this.tipoTareaService.getTipoTarea().subscribe(t=>{this.lstTipoTarea=t})}listarCliente(){this.clientesService.getCliente().subscribe(t=>{this.lstCliente=t})}listarResponsables(){this.usuarioService.getUsuario().subscribe(t=>{this.lstResponsable=t})}initForm(){this.form=this.fb.group({id:new i.NI(""),tipoTarea:new i.NI(0,[i.kI.required,(0,C.o)(/0/i)]),numRadicado:new i.NI(""),nombreTarea:new i.NI("",i.kI.required),descripcion:new i.NI("",i.kI.required),link:new i.NI("",i.kI.required),fechaInicio:new i.NI("",i.kI.required),fechaFin:new i.NI("",i.kI.required),Responsable:new i.NI(0,[i.kI.required,(0,C.o)(/0/i)]),cliente:new i.NI(0,[i.kI.required,(0,C.o)(/0/i)])})}clickEnviar(){let m,t=new F.r,o=new A.X,r=new O.c,a=new P.w,c=new M.y,d=new w.b,h=new k.S,u=new N,g=new I.j;new S.s,g.actuacion=this.form.get("nombreTarea").value,g.anotacion=this.form.get("descripcion").value,g.fechaHoraInicio=this.form.get("fechaInicio").value,g.fechaHoraFin=this.form.get("fechaFin").value,g.proceso=this.form.get("numRadicado").value,o.nombre=this.form.get("nombreTarea").value,o.descripcion=this.form.get("descripcion").value,o.link=this.form.get("link").value,a.id=this.form.get("tipoTarea").value,o.tipoTarea=a,r.id=this.form.get("cliente").value,o.cliente=r,c.fechaHoraInicio=this.form.get("fechaInicio").value,c.fechaHoraFin=this.form.get("fechaFin").value,h.id=U.N.id_estado_tarea,c.estado=h,t.agendarTarea=c,t.tarea=o,d.id=this.form.get("Responsable").value,u.usuario=d,m=this.files.find(p=>p.name);const T=document.getElementById("chec"),R=document.getElementById("Radicado")?.querySelector("ng-autocomplete input");if(R?.value.trim()&&T?.checked){let p=new _;p.responsables=this.categoriaSelectedArray,p.tareaDto=t,this.registrarVarios(p,m,u),this.registrarActuacion(m,g)}else if(R?.value.trim())this.registrar(t,m,u),this.registrarActuacion(m,g);else if(T?.checked){let p=new _;p.responsables=this.categoriaSelectedArray,p.tareaDto=t,this.registrarVarios(p,m,u)}else this.registrar(t,m,u)}registrarVarios(t,o,r){this.tareaService.crearVarios(t,o,r).subscribe(a=>{this.toastr.success(this.mensajeSatisfactorio),this.form.reset(),this.router.navigateByUrl("tablero-tarea")},a=>this.mensajeError(a))}registrar(t,o,r){this.tareaService.crear(t,o,r).subscribe(a=>{this.toastr.success(this.mensajeSatisfactorio),this.form.reset(),this.router.navigateByUrl("tablero-tarea")},a=>this.mensajeError(a))}registrarActuacion(t,o){console.log(o),this.actuacionesProcesoService.crear(o,t).subscribe(r=>{this.toastr.success(this.mensajeSatisfactorio,"Actuacion Creada")},r=>this.mensajeError(r))}mensajeError(t){console.log(t),this.toastr.error("Ha Ocurrido un Problema")}showDiv(){document.getElementById("chec")?.checked?document.getElementById("ResCheck").style.display="flex":document.getElementById("ResCheck").style.display="none"}toggle(){const t=document.getElementById("tipoTarea-select");document.getElementById("Radicado").style.display="Radicado"===t?.options[t?.selectedIndex]?.text?"block":"none"}filtrarNumeroRadicado(t){const o=t.target.value;""==o?this.procesos=[]:this.procesoService.listarPorNumeroRadicado(o).subscribe(r=>{this.procesos=r})}selectEventCountry(t){}onLocationSubmit(){}onCountryCleared(t,o){}onFileDropped(t){this.prepareFilesList(t)}fileBrowseHandler(t){this.prepareFilesList(t)}deleteFile(t){this.files.splice(t,1)}prepareFilesList(t){for(const o of t)this.files.push(o);this.fileDropEl.nativeElement.value=""}formatBytes(t,o=2){if(0===t)return"0 Bytes";const a=o<=0?0:o,d=Math.floor(Math.log(t)/Math.log(1024));return parseFloat((t/Math.pow(1024,d)).toFixed(a))+" "+["Bytes","KB","MB","GB","TB","PB","EB","ZB","YB"][d]}}return n.\u0275fac=function(t){return new(t||n)(e.Y36(B.D),e.Y36(D.$),e.Y36(E.Y),e.Y36(J.i),e.Y36(q.Q),e.Y36(j.m),e.Y36(i.qu),e.Y36(Y._W),e.Y36(f.gz),e.Y36(f.F0))},n.\u0275cmp=e.Xpm({type:n,selectors:[["app-registrar-tarea"]],viewQuery:function(t,o){if(1&t&&e.Gf(z,5),2&t){let r;e.iGM(r=e.CRH())&&(o.fileDropEl=r.first)}},decls:74,vars:11,consts:[[1,"container-form"],[2,"text-align","center"],["onclick","location.href='tablero-tarea';",1,"btn"],[1,"form",3,"formGroup"],[1,"d-flex","flex-column","align-center"],[1,"text-gray"],["name","tipoTarea","id","tipoTarea-select","formControlName","tipoTarea",3,"change"],["value","0"],[3,"value",4,"ngFor","ngForOf"],["id","Radicado"],["for","Radicado",1,"text-gray"],["formControlName","numRadicado","min-length","1","placeholder","Digite el numero de proceso",3,"data","searchKeyword","itemTemplate","notFoundTemplate","selected","inputCleared","keyup"],["countryList",""],["countryListTemplate",""],["notFoundTemplate",""],["for","name",1,"text-gray"],["type","text","name","name","formControlName","nombreTarea"],["for","descripcion",1,"text-gray"],["type","text","name","descripcion","cols","40","rows","5","formControlName","descripcion"],["for","link",1,"text-gray"],["type","text","name","link","formControlName","link"],[1,"d-flex","justify-content-between","row"],[1,"inputs","col-6"],["for","feinicio",1,"text-gray"],["type","datetime-local","name","feinicio","formControlName","fechaInicio"],["for","fefin",1,"text-gray"],["type","datetime-local","name","fefin","formControlName","fechaFin"],["for","responsable",1,"text-gray"],["name","responsable","id","responsable-select","formControlName","Responsable"],["for","cliente",1,"text-gray"],["name","cliente","id","cliente-select","formControlName","cliente"],[1,"d-flex","m-1"],["for","cliente",1,"text-gray","m-0"],["name","chec","type","checkbox","id","chec",1,"checkbox-res",3,"change"],["id","ResCheck",1,"justify-content-between","row","mb-2"],["class","d-flex col-3 align-items-center",4,"ngFor","ngForOf"],["for","clientes",1,"text-gray"],["appDnd","",1,"dropzone","align-items-center","fileover",3,"fileDropped"],["type","file","id","fileDropRef","multiple","",3,"change"],["fileDropRef",""],["for","fileDropRef"],[1,"files-list"],["class","single-file",4,"ngFor","ngForOf"],[1,"btn","btn-form",3,"disabled","click"],[3,"value"],[3,"innerHTML"],[1,"d-flex","col-3","align-items-center"],["name","chec","type","checkbox","id","chec",1,"checkbox",3,"value","change"],[1,"single-file"],["src","assets/imgs/ic-file.svg","width","45px","alt","file"],[1,"info"],[1,"name"],[1,"size"],["src","assets/imgs/ic-delete-file.svg","width","20px","alt","file",1,"delete",3,"click"]],template:function(t,o){if(1&t&&(e.TgZ(0,"div",0)(1,"h1"),e._uU(2,"CREAR TAREA"),e.qZA(),e.TgZ(3,"div",1)(4,"button",2),e._uU(5," Tablero de Tareas "),e.qZA()(),e.TgZ(6,"form",3)(7,"div",4)(8,"label",5),e._uU(9,"Tipo de Tarea"),e.qZA(),e.TgZ(10,"select",6),e.NdJ("change",function(){return o.toggle()}),e.TgZ(11,"option",7),e._uU(12,"--Seleccione un tipo de Tarea--"),e.qZA(),e.YNc(13,H,2,2,"option",8),e.qZA(),e.TgZ(14,"div",9)(15,"label",10),e._uU(16,"Numero Proceso"),e.qZA(),e.TgZ(17,"ng-autocomplete",11,12),e.NdJ("selected",function(a){return o.selectEventCountry(a),o.onLocationSubmit()})("inputCleared",function(a){return o.onCountryCleared(a,!1)})("keyup",function(a){return o.filtrarNumeroRadicado(a)}),e.qZA(),e.YNc(19,L,1,1,"ng-template",null,13,e.W1O),e.YNc(21,Q,1,1,"ng-template",null,14,e.W1O),e.qZA(),e.TgZ(23,"label",15),e._uU(24,"Nombre de la Tarea"),e.qZA(),e._UZ(25,"input",16),e.TgZ(26,"label",17),e._uU(27,"Descripcion de la Tarea"),e.qZA(),e._UZ(28,"textarea",18),e.TgZ(29,"label",19),e._uU(30,"Link"),e.qZA(),e._UZ(31,"input",20),e.TgZ(32,"div",21)(33,"div",22)(34,"label",23),e._uU(35,"Selecciona Fecha y Hora de Inicio"),e.qZA(),e._UZ(36,"input",24),e.qZA(),e.TgZ(37,"div",22)(38,"label",25),e._uU(39,"Selecciona Fecha y Hora de Entrega"),e.qZA(),e._UZ(40,"input",26),e.qZA(),e.TgZ(41,"div",22)(42,"label",27),e._uU(43,"Responsable"),e.qZA(),e.TgZ(44,"select",28)(45,"option",7),e._uU(46,"-- Seleccione un Responsable --"),e.qZA(),e.YNc(47,$,2,2,"option",8),e.qZA()(),e.TgZ(48,"div",22)(49,"label",29),e._uU(50,"Cliente"),e.qZA(),e.TgZ(51,"select",30)(52,"option",7),e._uU(53,"-- Seleccione un Cliente --"),e.qZA(),e.YNc(54,G,2,2,"option",8),e.qZA()()(),e.TgZ(55,"div",31)(56,"label",32),e._uU(57,"Otro Responsables"),e.qZA(),e.TgZ(58,"input",33),e.NdJ("change",function(){return o.showDiv()}),e.qZA()(),e.TgZ(59,"div",34),e.YNc(60,K,4,2,"div",35),e.qZA(),e.TgZ(61,"label",36),e._uU(62,"Subir Archivo"),e.qZA(),e.TgZ(63,"div",37),e.NdJ("fileDropped",function(a){return o.onFileDropped(a)}),e.TgZ(64,"input",38,39),e.NdJ("change",function(a){return o.fileBrowseHandler(a.target.files)}),e.qZA(),e.TgZ(66,"h3"),e._uU(67,"Drag and drop file Here to Upload"),e.qZA(),e.TgZ(68,"label",40),e._uU(69,"Or Select Files to Upload"),e.qZA()(),e.TgZ(70,"div",41),e.YNc(71,V,8,2,"div",42),e.qZA(),e.TgZ(72,"button",43),e.NdJ("click",function(){return o.clickEnviar()}),e._uU(73," Crear Tarea "),e.qZA()()()()),2&t){const r=e.MAs(20),a=e.MAs(22);e.xp6(6),e.Q6J("formGroup",o.form),e.xp6(7),e.Q6J("ngForOf",o.lstTipoTarea),e.xp6(4),e.Q6J("data",o.procesos)("searchKeyword",o.countrykeyword)("itemTemplate",r)("notFoundTemplate",a),e.xp6(30),e.Q6J("ngForOf",o.lstResponsable),e.xp6(7),e.Q6J("ngForOf",o.lstCliente),e.xp6(6),e.Q6J("ngForOf",o.lstResponsable),e.xp6(11),e.Q6J("ngForOf",o.files),e.xp6(1),e.Q6J("disabled",!o.form.valid)}},dependencies:[b.sg,i._Y,i.YN,i.Kr,i.Fj,i.EJ,i.JJ,i.JL,i.sg,i.u,y.YR],styles:["*[_ngcontent-%COMP%]{font-family:Arial Narrow,Arial,sans-serif}h1[_ngcontent-%COMP%]{text-align:center}.align-center[_ngcontent-%COMP%]{display:flex;justify-content:center}.text-gray[_ngcontent-%COMP%]{color:#868789}.container-form[_ngcontent-%COMP%]{padding:2rem 0;width:70%;margin:auto}.btn[_ngcontent-%COMP%]{background-color:#fe8910;color:#fff;padding:5px;border:none;width:65%;margin:.6rem 0 1rem;justify-content:center;border-radius:15px}.btn[_ngcontent-%COMP%]:hover{color:#f7f7f7;background-color:#868789}.btn-form[_ngcontent-%COMP%]{width:100%;padding:1rem}.form[_ngcontent-%COMP%]{width:65%;margin:0 auto}.form[_ngcontent-%COMP%]   input[_ngcontent-%COMP%], select[_ngcontent-%COMP%], textarea[_ngcontent-%COMP%]{color:#1a1a1a;width:100%;background-color:#66666640;border:none;padding:.6rem;margin-bottom:1rem;border-radius:15px}#Radicado[_ngcontent-%COMP%]{margin-bottom:1rem}.ng-autocomplete[_ngcontent-%COMP%]     .autocomplete-container   .input-container   input{color:#1a1a1a;width:100%;background-color:#66666640;border:none;padding:.6rem;border-radius:15px}.ng-autocomplete[_ngcontent-%COMP%]     .autocomplete-container{box-shadow:none}.ng-autocomplete[_ngcontent-%COMP%]     .autocomplete-container   .not-found{border-radius:15px}textarea[_ngcontent-%COMP%]{resize:none}.form[_ngcontent-%COMP%]   .checkbox[_ngcontent-%COMP%]{width:10%;margin-bottom:0}.checkbox-res[_ngcontent-%COMP%]{width:5%!important;margin-bottom:0!important}.form[_ngcontent-%COMP%]   select[_ngcontent-%COMP%]{color:#868789;text-align:center;border-radius:15px}.form[_ngcontent-%COMP%]   .inputs[_ngcontent-%COMP%]{width:48%}.dropzone[_ngcontent-%COMP%]{width:100%;height:100%;padding:4rem;text-align:center;border:dashed 5px #868789;position:relative;margin:0 auto}.dropzone[_ngcontent-%COMP%]   input[_ngcontent-%COMP%]{opacity:0;position:absolute;z-index:2;width:100%;height:100%;top:0;left:0}.dropzone[_ngcontent-%COMP%]   label[_ngcontent-%COMP%]{color:#f7f7f7;width:90%;background-color:#fe8910;padding:0 16px;border-radius:15px}.dropzone[_ngcontent-%COMP%]   h3[_ngcontent-%COMP%]{font-size:20px;font-weight:600;color:#868789}.fileover[_ngcontent-%COMP%]{animation:shake 1s;animation-iteration-count:infinite}.files-list[_ngcontent-%COMP%]{margin-top:1.5rem;display:flex;flex-grow:1}.single-file[_ngcontent-%COMP%]{display:flex;padding:.5rem;justify-content:space-between;align-items:center;border:dashed 1px #979797;margin-bottom:1rem}img.delete[_ngcontent-%COMP%]{margin-left:.5rem;cursor:pointer;align-self:flex-end}.name[_ngcontent-%COMP%]{font-size:14px;font-weight:500;color:#353f4a;margin:0}.size[_ngcontent-%COMP%]{font-size:12px;font-weight:500;color:#a4a4a4;margin:0;margin-bottom:.25rem}.info[_ngcontent-%COMP%]{width:100%}@media (max-width:1023px){.container-form[_ngcontent-%COMP%]{width:100%}.form[_ngcontent-%COMP%]{width:90%}}@media (max-width:767px){.container-form[_ngcontent-%COMP%]{width:100%}.form[_ngcontent-%COMP%]{width:90%}.contrato[_ngcontent-%COMP%]{flex-direction:column}.form[_ngcontent-%COMP%]   .inputs[_ngcontent-%COMP%]{width:100%}}"]}),n})()}];let X=(()=>{class n{}return n.\u0275fac=function(t){return new(t||n)},n.\u0275mod=e.oAB({type:n}),n.\u0275inj=e.cJS({imports:[f.Bz.forChild(W),f.Bz]}),n})(),ee=(()=>{class n{}return n.\u0275fac=function(t){return new(t||n)},n.\u0275mod=e.oAB({type:n}),n.\u0275inj=e.cJS({imports:[b.ez,X,i.u5,i.UX,y.rP]}),n})()}}]);