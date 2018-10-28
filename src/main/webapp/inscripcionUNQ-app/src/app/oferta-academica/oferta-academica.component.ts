import { Component, OnInit } from '@angular/core';
import { RestService } from '../rest.service';
import { UtilesService } from '../utiles.service';
import { HttpErrorResponse } from '@angular/common/http';
import { MatDialog, MatDialogConfig } from '@angular/material';
import { OfertaAcademica } from './oferta-academica.model';
import { OfertaAcademicaDialogoComponent } from '../oferta-academica-dialogo/oferta-academica.dialogo.component';

@Component({
	selector: 'app-oferta-academica',
	templateUrl: './oferta-academica.component.html',
	styleUrls: ['../estilo-abm.component.css']
})
export class ofertaAcademicaComponent implements OnInit {

	ofertas: OfertaAcademica[];

	constructor(
		private restService: RestService,
		private utilesService: UtilesService,
		private dialog: MatDialog
	) { }

	ngOnInit() {
		this.ofertas = JSON.parse(localStorage.getItem('ofertas'));
	}

	getOfertas() {
		this.restService.getOfertas().subscribe(ofertas => {
			this.ofertas = ofertas;
		},
			(err: HttpErrorResponse) => {
				this.utilesService.mostrarMensajeDeError(err);
			});
	}

	abrirDialogoParaCreacionDeOferta() {
		const dialogRef = this.crearConfiguracionDialogoParaOferta();
		dialogRef.afterClosed().subscribe(val => {
			if (val != undefined) {
				this.crearNuevaOferta(val);
			}
		});
	}

	crearNuevaOferta(oferta: OfertaAcademica) {
		this.restService.crearNuevaOferta(oferta)
			.subscribe(res => {
				const mensaje = 'Se creó la nueva oferta académica con exito';
				this.utilesService.mostrarMensaje(mensaje);
				this.getOfertas();
			},
				(err: HttpErrorResponse) => {
					this.utilesService.mostrarMensajeDeError(err);
				});
	}

	crearConfiguracionDialogoParaOferta(oferta?) {
		const dialogConfig = new MatDialogConfig();

		dialogConfig.disableClose = true;
		dialogConfig.autoFocus = false;
		dialogConfig.width = '600px';
		dialogConfig.height = '600px';
		dialogConfig.data = {
			oferta: oferta
		};

		const dialogRef = this.dialog.open(OfertaAcademicaDialogoComponent, dialogConfig);

		return dialogRef;
	}

	abrirDialogoParaEdicionDeOferta(ofertaSeleccionada) {
		const dialogRef = this.crearConfiguracionDialogoParaOferta(ofertaSeleccionada);
		dialogRef.afterClosed().subscribe(val => {
			if (val != undefined) {
				this.actualizarOfertaSeleccionada(val, ofertaSeleccionada);
			}
		});
	}

	actualizarOfertaSeleccionada(oferta: OfertaAcademica, ofertaSeleccionada) {
		oferta.id = ofertaSeleccionada.id;
		oferta.nroComisionesCreadas = ofertaSeleccionada.nroComisionesCreadas;
		this.actualizarOferta(oferta);
	}

	actualizarOferta(oferta) {
		this.restService.actualizarInformacionDeOferta(oferta)
			.subscribe(res => {
				const mensaje = 'Los datos de la oferta académica fueron actualizados con exito';
				this.utilesService.mostrarMensaje(mensaje);
				this.getOfertas();
			},
				(err: HttpErrorResponse) => {
					this.utilesService.mostrarMensajeDeError(err);
				});
	}

	cambiarEstado(oferta, evento) {
		oferta.habilitada = evento.checked;
		this.actualizarOferta(oferta);
	}

	irAComisiones(oferta: OfertaAcademica) {
		this.restService.getComisionesDeOferta(oferta.id).subscribe(comisiones => {
			localStorage.setItem('comisiones-de-oferta', JSON.stringify(comisiones));
			localStorage.setItem('oferta-seleccionada', JSON.stringify(oferta));
			this.utilesService.irA('comisiones-de-oferta');
		},
			(err) => {
				this.utilesService.mostrarMensajeDeError(err);
			});
	}
}