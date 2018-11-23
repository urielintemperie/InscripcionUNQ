import { Component, OnInit } from '@angular/core';
import { Validators, FormBuilder, FormGroup } from '@angular/forms';
import { RestService } from '../rest.service';
import { HttpErrorResponse } from '@angular/common/http';
import { UtilesService } from '../utiles.service';
import { AuthService } from '../auth/auth.service';
import { Usuario } from './usuario.model';
import { AppMensajes } from '../app-mensajes.model';
import { AppRutas } from '../app-rutas.model';
import { UsuarioLogueadoService } from '../usuario-logueado.service';
import { ConsoleReporter } from 'jasmine';
import { CdkAccordion } from '@angular/cdk/accordion';

@Component({
	selector: 'app-login',
	templateUrl: './login.component.html',
	styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
	perfiles: String[];
	seleccionaPerfil;
	loginVerificationForm: FormGroup;

	constructor(
		private formBuilder: FormBuilder,
		private restService: RestService,
		private utilesService: UtilesService,
		public auth: AuthService,
		private usuarioLogueado: UsuarioLogueadoService
	) { }

	ngOnInit() {
		this.crearLoginFormGroup();
	}

	crearLoginFormGroup() {
		this.loginVerificationForm = this.formBuilder.group({
			password: ['', [Validators.required]],
			email: ['', [Validators.required, Validators.email]]
		});
	}

	onSubmit() {
		if (this.loginVerificationForm.valid) {
			const { email, password } = this.loginVerificationForm.value;
			const usuario = new Usuario(email);
			usuario.password = password;
			this.restService.ingresarUsuario(usuario)
				.subscribe(infoUsuario => {
					this.mostrarPantallaSegunPerfil(infoUsuario);
				},
					(err: HttpErrorResponse) => {
						this.utilesService.mostrarMensajeDeError(err);
					});
		}
	}
	recuperarPassword() {
			const { email, password } = this.loginVerificationForm.value;
			const usuario = new Usuario(email);
			this.restService.recuperarPassword(usuario)
				.subscribe(infoUsuario => {
					this.utilesService.mostrarMensajeYSalir("Se envio la nueva password al mail indicado");
				},
					(err: HttpErrorResponse) => {
						this.utilesService.mostrarMensajeDeError(err);
					});
	}
	mostrarPantallaSegunPerfil(usuario: Usuario) {
		this.usuarioLogueado.notificarUsuarioLoguedado();
		localStorage.setItem('usuario', JSON.stringify(usuario));
		if (usuario.perfiles.length > 1) {
			this.seleccionaPerfil = true;
			this.perfiles = usuario.perfiles;
		} else {
			const perfil = usuario.perfiles[0];
			this.irASegunPerfil(perfil);
		}
	}

	irASegunPerfil(perfil: String) {
		if (AppMensajes.ESTUDIANTE == perfil) {
			this.utilesService.irA(AppRutas.ENCUESTAS_VIGENTES);
		} else if (AppMensajes.ADMINSTRADOR == perfil) {
			this.utilesService.irA(AppRutas.TAREAS_USUARIO);
		}
	}

	perfilSeleccionado(perfil) {
		this.irASegunPerfil(perfil);
	}
}