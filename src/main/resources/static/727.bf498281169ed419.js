"use strict";(self.webpackChunkAbogadosFront=self.webpackChunkAbogadosFront||[]).push([[727],{9404:(Z,m,l)=>{l.r(m),l.d(m,{EditarBibliotecaModule:()=>_});var g=l(6895),d=l(3599),n=l(433),u=l(642),h=l(797),p=l(5226),b=l.n(p),e=l(8256),C=l(8651),v=l(6940),M=l(7185);const B=["fileDropRef"];function O(o,s){if(1&o&&(e.TgZ(0,"option",18),e._uU(1),e.qZA()),2&o){const t=s.$implicit;e.s9C("value",t.id),e.xp6(1),e.hij(" ",t.nombre," ")}}function x(o,s){if(1&o){const t=e.EpF();e.TgZ(0,"div",19),e._UZ(1,"img",20),e.TgZ(2,"div",21)(3,"h4",22),e._uU(4),e.qZA(),e.TgZ(5,"p",23),e._uU(6),e.qZA()(),e.TgZ(7,"img",24),e.NdJ("click",function(){const a=e.CHM(t).index,c=e.oxw();return e.KtG(c.deleteFile(a))}),e.qZA()()}if(2&o){const t=s.$implicit,i=e.oxw();e.xp6(4),e.hij(" ",null==t?null:t.name," "),e.xp6(2),e.hij(" ",i.formatBytes(null==t?null:t.size)," ")}}const A=[{path:"",component:(()=>{class o{constructor(t,i,r,a,c,f){this.bibliotecaService=t,this.clientesService=i,this.ruta=r,this.router=a,this.fb=c,this.toastr=f,this.files=[],this.mensajeSatisfactorio="Satisfactorio",this.editar=!1,this.textoBoton="Editar Registro",this.page=1,this.pageSize=10,this.bibliotecaDocumentos=[],this.BIBLIOTECADOCUMENTOS=[],this.collectionSize=this.bibliotecaDocumentos.length,this.id=Number(this.ruta.snapshot.paramMap.get("id")),this.refreshDocuments()}ngOnInit(){this.listarCliente(),this.initForm()}listarCliente(){this.clientesService.getCliente().subscribe(t=>{this.lstCliente=t,this.listarPorId(this.id),console.log(t)})}listarPorId(t){this.bibliotecaService.listarClienteId(t).subscribe(i=>{this.form.get("id").setValue(i.id),this.form.get("nombreArchivo").setValue(i.nombreArchivo),this.form.get("archivo").setValue(i.archivo),this.form.get("cliente").setValue(i.cliente.id)})}initForm(){this.form=this.fb.group({id:new n.NI(""),nombreArchivo:new n.NI("",n.kI.required),archivo:new n.NI("",n.kI.required),cliente:new n.NI("",n.kI.required)})}refreshDocuments(){this.bibliotecaDocumentos=this.BIBLIOTECADOCUMENTOS.map((t,i)=>({id:i+1,...t})).slice((this.page-1)*this.pageSize,(this.page-1)*this.pageSize+this.pageSize)}clickEnviar(){let r,t=new u.G,i=new h.c;t.id=this.form.get("id").value,i.id=this.form.get("cliente").value,t.cliente=i,t.nombreArchivo=this.form.get("nombreArchivo").value,r=this.files.find(a=>a.name),console.log(r),b().fire({title:"Est\xe1s seguro?",text:"No Podras Revertir!",icon:"warning",showCancelButton:!0,confirmButtonColor:"#3085d6",cancelButtonColor:"#d33",confirmButtonText:"S\xed, Actualizar!"}).then(a=>{a.isConfirmed&&null!=r?this.modificar(r,t):this.modificarSinArchivo(t)})}modificar(t,i){this.bibliotecaService.modificar(i,t).subscribe(r=>{this.toastr.success(this.mensajeSatisfactorio),this.form.reset(),this.router.navigateByUrl("listado-biblioteca")},r=>this.mensajeError(r))}modificarSinArchivo(t){this.bibliotecaService.modificarSinArchivo(t).subscribe(i=>{this.toastr.success(this.mensajeSatisfactorio),this.form.reset(),this.router.navigateByUrl("listado-biblioteca")},i=>this.mensajeError(i))}mensajeError(t){console.log(t),this.toastr.error("Ha Ocurrido un Problema")}onFileDropped(t){this.prepareFilesList(t)}fileBrowseHandler(t){this.prepareFilesList(t)}deleteFile(t){this.files.splice(t,1)}prepareFilesList(t){for(const i of t)this.files.push(i);this.fileDropEl.nativeElement.value=""}formatBytes(t,i=2){if(0===t)return"0 Bytes";const a=i<=0?0:i,f=Math.floor(Math.log(t)/Math.log(1024));return parseFloat((t/Math.pow(1024,f)).toFixed(a))+" "+["Bytes","KB","MB","GB","TB","PB","EB","ZB","YB"][f]}}return o.\u0275fac=function(t){return new(t||o)(e.Y36(C.O),e.Y36(v.Y),e.Y36(d.gz),e.Y36(d.F0),e.Y36(n.qu),e.Y36(M._W))},o.\u0275cmp=e.Xpm({type:o,selectors:[["app-editar-biblioteca"]],viewQuery:function(t,i){if(1&t&&e.Gf(B,5),2&t){let r;e.iGM(r=e.CRH())&&(i.fileDropEl=r.first)}},decls:30,vars:3,consts:[[1,"container-form"],[2,"text-align","center"],["onclick","location.href='listado-biblioteca';",1,"btn"],[1,"form",3,"formGroup"],[1,"align-center","d-flex","flex-column"],["for","clientes",1,"text-gray"],["name","cliente","id","cliente-select","formControlName","cliente"],["value","0"],[3,"value",4,"ngFor","ngForOf"],["appDnd","",1,"dropzone","align-items-center","fileover",3,"fileDropped"],["type","file","id","fileDropRef","multiple","",3,"change"],["fileDropRef",""],["for","fileDropRef"],[1,"files-list"],["class","single-file",4,"ngFor","ngForOf"],["for","name",1,"text-gray"],["type","text","name","name","required","","formControlName","nombreArchivo"],["type","submit",1,"btn","btn-form",3,"click"],[3,"value"],[1,"single-file"],["src","assets/imgs/ic-file.svg","width","45px","alt","file"],[1,"info"],[1,"name"],[1,"size"],["src","assets/imgs/ic-delete-file.svg","width","20px","alt","file",1,"delete",3,"click"]],template:function(t,i){1&t&&(e.TgZ(0,"div",0)(1,"h1"),e._uU(2,"ACTUALIZAR ARCHIVO"),e.qZA(),e.TgZ(3,"div",1)(4,"button",2),e._uU(5," Listado de Archivos "),e.qZA()(),e.TgZ(6,"form",3)(7,"div",4)(8,"label",5),e._uU(9,"Seleccione un Cliente"),e.qZA(),e.TgZ(10,"select",6)(11,"option",7),e._uU(12,"--Seleccione un Cliente--"),e.qZA(),e.YNc(13,O,2,2,"option",8),e.qZA(),e.TgZ(14,"label",5),e._uU(15,"Subir Contrato"),e.qZA(),e.TgZ(16,"div",9),e.NdJ("fileDropped",function(a){return i.onFileDropped(a)}),e.TgZ(17,"input",10,11),e.NdJ("change",function(a){return i.fileBrowseHandler(a.target.files)}),e.qZA(),e.TgZ(19,"h3"),e._uU(20,"Drag and drop file Here to Upload"),e.qZA(),e.TgZ(21,"label",12),e._uU(22,"Or Select Files to Upload"),e.qZA()(),e.TgZ(23,"div",13),e.YNc(24,x,8,2,"div",14),e.qZA(),e.TgZ(25,"label",15),e._uU(26,"Nombre del Archivo"),e.qZA(),e._UZ(27,"input",16),e.TgZ(28,"button",17),e.NdJ("click",function(){return i.clickEnviar()}),e._uU(29," Actualizar Registro "),e.qZA()()()()),2&t&&(e.xp6(6),e.Q6J("formGroup",i.form),e.xp6(7),e.Q6J("ngForOf",i.lstCliente),e.xp6(11),e.Q6J("ngForOf",i.files))},dependencies:[g.sg,n._Y,n.YN,n.Kr,n.Fj,n.EJ,n.JJ,n.JL,n.Q7,n.sg,n.u],styles:["*[_ngcontent-%COMP%]{font-family:Arial Narrow,Arial,sans-serif}h1[_ngcontent-%COMP%]{text-align:center}.align-center[_ngcontent-%COMP%]{display:flex;justify-content:center}.text-gray[_ngcontent-%COMP%]{color:#868789}.container-form[_ngcontent-%COMP%]{padding:2rem 0;width:70%;margin:auto}.btn[_ngcontent-%COMP%]{background-color:#fe8910;color:#fff;padding:5px;border:none;width:65%;margin:.6rem 0 1rem;justify-content:center;border-radius:15px}.btn[_ngcontent-%COMP%]:hover{color:#f7f7f7;background-color:#868789}.btn-form[_ngcontent-%COMP%]{width:100%;padding:1rem}.form[_ngcontent-%COMP%]{width:65%;margin:0 auto}.form[_ngcontent-%COMP%]   input[_ngcontent-%COMP%], select[_ngcontent-%COMP%]{color:#1a1a1a;width:100%;background-color:#66666640;border:none;padding:.6rem;margin-bottom:1rem;border-radius:15px}.form[_ngcontent-%COMP%]   select[_ngcontent-%COMP%]{color:#868789;padding:1rem;text-align:center;border-radius:15px}.form[_ngcontent-%COMP%]   .inputs[_ngcontent-%COMP%]{width:48%}.dropzone[_ngcontent-%COMP%]{width:100%;height:100%;padding:4rem;text-align:center;border:dashed 5px #868789;position:relative;margin:0 auto}.dropzone[_ngcontent-%COMP%]   input[_ngcontent-%COMP%]{opacity:0;position:absolute;z-index:2;width:100%;height:100%;top:0;left:0}.dropzone[_ngcontent-%COMP%]   label[_ngcontent-%COMP%]{color:#f7f7f7;width:90%;background-color:#fe8910;padding:0 16px;border-radius:15px}.dropzone[_ngcontent-%COMP%]   h3[_ngcontent-%COMP%]{font-size:20px;font-weight:600;color:#868789}.fileover[_ngcontent-%COMP%]{animation:shake 1s;animation-iteration-count:infinite}.files-list[_ngcontent-%COMP%]{margin-top:1.5rem;display:flex;flex-grow:1}.single-file[_ngcontent-%COMP%]{display:flex;padding:.5rem;justify-content:space-between;align-items:center;border:dashed 1px #979797;margin-bottom:1rem}img.delete[_ngcontent-%COMP%]{margin-left:.5rem;cursor:pointer;align-self:flex-end}.name[_ngcontent-%COMP%]{font-size:14px;font-weight:500;color:#353f4a;margin:0}.size[_ngcontent-%COMP%]{font-size:12px;font-weight:500;color:#a4a4a4;margin:0;margin-bottom:.25rem}.info[_ngcontent-%COMP%]{width:100%}@media (max-width: 767px){.container-form[_ngcontent-%COMP%]{width:90%}.btn[_ngcontent-%COMP%], .form[_ngcontent-%COMP%]{width:100%}}"]}),o})()}];let P=(()=>{class o{}return o.\u0275fac=function(t){return new(t||o)},o.\u0275mod=e.oAB({type:o}),o.\u0275inj=e.cJS({imports:[d.Bz.forChild(A),d.Bz]}),o})(),_=(()=>{class o{}return o.\u0275fac=function(t){return new(t||o)},o.\u0275mod=e.oAB({type:o}),o.\u0275inj=e.cJS({imports:[g.ez,P,n.u5,n.UX]}),o})()}}]);