package ar.edu.unq.inscripcionunq.spring.controller;

import java.time.LocalDateTime;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.unq.inscripcionunq.spring.exception.ConexionWebServiceException;
import ar.edu.unq.inscripcionunq.spring.exception.EncriptarDesencriptarAESException;
import ar.edu.unq.inscripcionunq.spring.exception.EncuestaNoExisteException;
import ar.edu.unq.inscripcionunq.spring.exception.ObjectoNoEncontradoEnBDException;
import ar.edu.unq.inscripcionunq.spring.model.Carrera;
import ar.edu.unq.inscripcionunq.spring.model.Comision;
import ar.edu.unq.inscripcionunq.spring.model.Encuesta;
import ar.edu.unq.inscripcionunq.spring.model.Equivalencia;
import ar.edu.unq.inscripcionunq.spring.model.Materia;
import ar.edu.unq.inscripcionunq.spring.model.OfertaAcademica;
import ar.edu.unq.inscripcionunq.spring.model.Periodo;
import ar.edu.unq.inscripcionunq.spring.model.TipoDia;
import ar.edu.unq.inscripcionunq.spring.model.TipoIncidencia;
import ar.edu.unq.inscripcionunq.spring.model.TipoPerfil;
import ar.edu.unq.inscripcionunq.spring.model.TipoPeriodo;
import ar.edu.unq.inscripcionunq.spring.model.Usuario;
import ar.edu.unq.inscripcionunq.spring.service.GenericService;
import ar.edu.unq.inscripcionunq.spring.service.WebService;

@RestController
public class CargaInicialDeDatosController {

	@Autowired
	private GenericService<Carrera> carreraServiceImp;

	@Autowired
	private GenericService<Materia> materiaServiceImp;

	@Autowired
	private GenericService<Comision> comisionServiceImp;

	@Autowired
	private GenericService<OfertaAcademica> ofertaAcademicaServiceImp;

	@Autowired
	private GenericService<Encuesta> encuestaServiceImp;

	@Autowired
	private GenericService<Usuario> usuarioServiceImp;

	@Autowired
	private GenericService<TipoIncidencia> tipoIncidenciaServiceImp;

	@Autowired
	private GenericService<Periodo> periodoServiceImp;

	@Autowired
	private WebService webService;

	@Autowired
	private GenericService<Equivalencia> equivalenciaServiceImp;

	@RequestMapping(value = "loadData", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public void loadData() throws ObjectoNoEncontradoEnBDException, EncriptarDesencriptarAESException {
		Carrera tpi = new Carrera("P", "Tecnicatura Universitaria en Programacion Informatica");
		Carrera lds = new Carrera("W", "Licenciatura en Informatica");
		long aa = carreraServiceImp.save(tpi);
		tpi = carreraServiceImp.get(aa);
		lds = carreraServiceImp.get(carreraServiceImp.save(lds));

		Materia matt = new Materia("00487", "Introducción a la Programación", 8, 16);
		matt.agregarCarrera(tpi);
		matt.agregarCarrera(lds);
		long intro = materiaServiceImp.save(matt);

		matt = new Materia("01032", "Organización de Computadoras", 6, 12);
		matt.agregarCarrera(tpi);
		matt.agregarCarrera(lds);
		long orga = materiaServiceImp.save(matt);

		matt = new Materia("01033", "Matemática I", 8, 12);
		matt.agregarCarrera(tpi);
		matt.agregarCarrera(lds);
		long mate1 = materiaServiceImp.save(matt);

		matt = new Materia("01034", "Programación con Objetos I", 6, 16);
		matt.agregarCarrera(tpi);
		matt.agregarCarrera(lds);
		long obj1 = materiaServiceImp.save(matt);

		matt = new Materia("01315", "Parseo y Generación de Código", 6, 8);
		matt.agregarCarrera(lds);
		long pyGC = materiaServiceImp.save(matt);

		matt = new Materia("01307", "Algoritmos", 6, 12);
		matt.agregarCarrera(lds);
		long alg = materiaServiceImp.save(matt);

		matt = new Materia("01318", "Análisis Estático de Programas y Herramientas Asociadas", 6, 8);
		matt.agregarCarrera(lds);
		long aEPHA = materiaServiceImp.save(matt);

		matt = new Materia("00054", "Análisis Matemático I", 6, 12);
		matt.agregarCarrera(lds);
		long aM1 = materiaServiceImp.save(matt);

		matt = new Materia("01314", "Arquitectura de computadoras", 6, 8);
		matt.agregarCarrera(lds);
		long arqC = materiaServiceImp.save(matt);

		matt = new Materia("01310", "Arquitectura de Software I", 6, 12);
		matt.agregarCarrera(lds);
		long arqS1 = materiaServiceImp.save(matt);

		matt = new Materia("01313", "Arquitectura de Software II", 6, 12);
		matt.agregarCarrera(lds);
		long arqS2 = materiaServiceImp.save(matt);

		matt = new Materia("01316", "Aspectos Legales y Sociales", 6, 8);
		matt.agregarCarrera(lds);
		long aLyS = materiaServiceImp.save(matt);

		matt = new Materia("01312", "Caracteristicas de Lenguajes de Programación", 6, 8);
		matt.agregarCarrera(lds);
		long cLP = materiaServiceImp.save(matt);

		matt = new Materia("01050", "Introducción a las Arquitecturas de Software", 8, 8);
		matt.agregarCarrera(tpi);
		long iAS = materiaServiceImp.save(matt);

		matt = new Materia("01056", "Introducción al Desarrollo de Videojuegos", 8, 8);
		matt.agregarCarrera(tpi);
		matt.agregarCarrera(lds);
		long iDV = materiaServiceImp.save(matt);

		matt = new Materia("01035", "Bases de Datos", 8, 16);
		matt.agregarCarrera(tpi);
		matt.agregarCarrera(lds);
		long bd = materiaServiceImp.save(matt);

		matt = new Materia("01308", "Ingeniería de Requerimientos", 4, 8);
		matt.agregarCarrera(lds);
		long ingR = materiaServiceImp.save(matt);

		matt = new Materia("01048", "Bases de Datos II", 4, 8);
		matt.agregarCarrera(tpi);
		matt.agregarCarrera(lds);
		long bd2 = materiaServiceImp.save(matt);

		matt = new Materia("01036", "Estructuras de Datos", 4, 8);
		matt.agregarCarrera(tpi);
		matt.agregarCarrera(lds);
		long ed = materiaServiceImp.save(matt);

		matt = new Materia("01055", "Herramientas declarativas en Programación", 4, 8);
		matt.agregarCarrera(tpi);
		matt.agregarCarrera(lds);
		long hDP = materiaServiceImp.save(matt);

		matt = new Materia("01304", "Gestión de Proyectos de desarrollo de Software", 4, 8);
		matt.agregarCarrera(lds);
		long gPDS = materiaServiceImp.save(matt);

		matt = new Materia("01037", "Programación con Objetos II", 6, 12);
		matt.agregarCarrera(tpi);
		matt.agregarCarrera(lds);
		long obj2 = materiaServiceImp.save(matt);

		matt = new Materia("01038", "Redes de Computadoras", 6, 12);
		matt.agregarCarrera(tpi);
		matt.agregarCarrera(lds);
		long redes = materiaServiceImp.save(matt);

		matt = new Materia("01039", "Sistemas Operativos", 6, 12);
		matt.agregarCarrera(tpi);
		matt.agregarCarrera(lds);
		long so = materiaServiceImp.save(matt);

		matt = new Materia("00751", "Taller de Trabajo Intelectual", 2, 4);
		matt.agregarCarrera(tpi);
		matt.agregarCarrera(lds);
		long tti = materiaServiceImp.save(matt);

		matt = new Materia("00752", "Taller de Trabajo Universitario", 2, 4);
		matt.agregarCarrera(tpi);
		matt.agregarCarrera(lds);
		long ttu = materiaServiceImp.save(matt);

		matt = new Materia("01309", "Teoría de la Computación", 4, 8);
		matt.agregarCarrera(lds);
		long tC = materiaServiceImp.save(matt);

		matt = new Materia("01060", "Trabajo de Inserción Profesional", 4, 0);
		matt.agregarCarrera(tpi);
		long tip = materiaServiceImp.save(matt);

		matt = new Materia("01040", "Programacion Concurrente", 4, 8);
		matt.agregarCarrera(tpi);
		matt.agregarCarrera(lds);
		long pc = materiaServiceImp.save(matt);

		matt = new Materia("01041", "Matemática II", 4, 8);
		matt.agregarCarrera(tpi);
		matt.agregarCarrera(lds);
		long mate2 = materiaServiceImp.save(matt);

		matt = new Materia("00842", "Matemática III", 4, 8);
		matt.agregarCarrera(lds);
		long mate3 = materiaServiceImp.save(matt);

		matt = new Materia("01042", "Elementos de Ingeniería de Software", 6, 12);
		matt.agregarCarrera(tpi);
		matt.agregarCarrera(lds);
		long ingS = materiaServiceImp.save(matt);

		matt = new Materia("01043", "Construcción de Interfaces de Usuario", 6, 12);
		matt.agregarCarrera(tpi);
		matt.agregarCarrera(lds);
		long cIU = materiaServiceImp.save(matt);

		matt = new Materia("01044", "Estrategias de Persistencia", 6, 12);
		matt.agregarCarrera(tpi);
		matt.agregarCarrera(lds);
		long ePers = materiaServiceImp.save(matt);

		matt = new Materia("01057", "Derecho de Autor  y Derecho de Copia en la Era Digital", 6, 8);
		matt.agregarCarrera(tpi);
		matt.agregarCarrera(lds);
		long dADCED = materiaServiceImp.save(matt);

		matt = new Materia("01045", "Programación Funcional", 4, 8);
		matt.agregarCarrera(tpi);
		matt.agregarCarrera(lds);
		long pF = materiaServiceImp.save(matt);

		matt = new Materia("01046", "Desarrollo de Aplicaciones", 6, 12);
		matt.agregarCarrera(tpi);
		long desa = materiaServiceImp.save(matt);

		matt = new Materia("01047", "Laboratorio de Sistemas Operativos y Redes", 4, 8);
		matt.agregarCarrera(tpi);
		matt.agregarCarrera(lds);
		long labo = materiaServiceImp.save(matt);

		matt = new Materia("90000", "Inglés I", 4, 4);
		matt.agregarCarrera(tpi);
		matt.agregarCarrera(lds);
		long ingles1 = materiaServiceImp.save(matt);

		matt = new Materia("01306", "Lenguajes Formales y Autómatas", 4, 8);
		matt.agregarCarrera(lds);
		long lfa = materiaServiceImp.save(matt);

		matt = new Materia("01302", "Lógica y Programación", 6, 12);
		matt.agregarCarrera(lds);
		long lyp = materiaServiceImp.save(matt);

		matt = new Materia("90028", "Inglés II ( P-W )", 4, 4);
		matt.agregarCarrera(tpi);
		matt.agregarCarrera(lds);
		long ingles2 = materiaServiceImp.save(matt);

		matt = new Materia("01052", "Introducción a la Bioinformática", 4, 8);
		matt.agregarCarrera(tpi);
		matt.agregarCarrera(lds);
		long introBio = materiaServiceImp.save(matt);

		matt = new Materia("01053", "Politicas Públicas en la Sociedad de la Información y la Era Digital", 4, 8);
		matt.agregarCarrera(tpi);
		matt.agregarCarrera(lds);
		long ppsied = materiaServiceImp.save(matt);

		matt = new Materia("01305", "Práctica del Desarrollo de Software", 8, 12);
		matt.agregarCarrera(lds);
		long pds = materiaServiceImp.save(matt);

		matt = new Materia("00604", "Probabilidad Y Estadística", 6, 12);
		matt.agregarCarrera(lds);
		long probE = materiaServiceImp.save(matt);

		matt = new Materia("01049", "Participación y Gestión en Proyectos de Software Libre", 4, 8);
		matt.agregarCarrera(tpi);
		matt.agregarCarrera(lds);
		long pygsl = materiaServiceImp.save(matt);

		matt = new Materia("01051", "Programación con Objetos III", 4, 8);
		matt.agregarCarrera(tpi);
		matt.agregarCarrera(lds);
		long obj3 = materiaServiceImp.save(matt);

		matt = new Materia("00646", "Seguridad Informática", 4, 8);
		matt.agregarCarrera(tpi);
		long sI = materiaServiceImp.save(matt);

		matt = new Materia("01328", "Seminario : Televisión Digital", 4, 8);
		matt.agregarCarrera(tpi);
		long sTD = materiaServiceImp.save(matt);

		matt = new Materia("01054", "Sistemas de Información Geográfica", 4, 8);
		matt.agregarCarrera(tpi);
		matt.agregarCarrera(lds);
		long sIG = materiaServiceImp.save(matt);

		matt = new Materia("01311", "Sistemas Distribuidos", 4, 8);
		matt.agregarCarrera(lds);
		long sD = materiaServiceImp.save(matt);

		matt = new Materia("01059", "Seminarios sobre  Herramientas ó Tecnicas Puntuales: Tecnología y Sociedad", 4, 8);
		matt.agregarCarrera(tpi);
		matt.agregarCarrera(lds);
		long tecSoc = materiaServiceImp.save(matt);

		matt = new Materia("01303", "Seguridad de la Información", 4, 8);
		matt.agregarCarrera(lds);
		long segInfo = materiaServiceImp.save(matt);

		matt = new Materia("01319", "Semántica de Lenguajes de Programación", 4, 8);
		matt.agregarCarrera(lds);
		long sLP = materiaServiceImp.save(matt);

		matt = new Materia("01317", "Seminario final", 4, 0);
		matt.agregarCarrera(lds);
		long semF = materiaServiceImp.save(matt);

		matt = new Materia("01058",
				"Seminarios: Introducción a la Electrónica y Programación de Controladores con Arduino", 4, 8);
		matt.agregarCarrera(tpi);
		matt.agregarCarrera(lds);
		long arduino = materiaServiceImp.save(matt);

		Periodo periodo1 = new Periodo(2018, 2, TipoPeriodo.CUATRIMESTRAL);
		periodoServiceImp.save(periodo1);
		Periodo periodo2 = new Periodo(2018, 1, TipoPeriodo.CUATRIMESTRAL);
		periodoServiceImp.save(periodo2);

		OfertaAcademica acc1 = new OfertaAcademica("Oferta Academica TPI 2 semestre 2018", tpi, periodo1);
		OfertaAcademica acc2 = new OfertaAcademica("Oferta Academica LIDS 2 semestre 2018", lds, periodo1);

		Comision commMate1 = new Comision("Mate1 C1", materiaServiceImp.get(mate1), 30, periodo1);
		commMate1.agregarHorarios(TipoDia.MARTES, LocalTime.of(9, 00), 4.0f);
		commMate1.agregarHorarios(TipoDia.JUEVES, LocalTime.of(9, 00), 4.0f);
		long idcommMate1 = comisionServiceImp.save(commMate1);

		acc1.agregarComision(comisionServiceImp.get(idcommMate1));
		acc2.agregarComision(comisionServiceImp.get(idcommMate1));

		Comision commMate2 = new Comision("Mate1 C2", materiaServiceImp.get(mate1), 30, periodo1);
		commMate2.agregarHorarios(TipoDia.LUNES, LocalTime.of(18, 00), (float) 4.0f);
		commMate2.agregarHorarios(TipoDia.MIERCOLES, LocalTime.of(18, 00), 4.0f);
		long idcommMate2 = comisionServiceImp.save(commMate2);

		acc1.agregarComision(comisionServiceImp.get(idcommMate2));
		acc2.agregarComision(comisionServiceImp.get(idcommMate2));

		Comision commMate3 = new Comision("Mate1 C3", materiaServiceImp.get(mate1), 30, periodo1);
		commMate3.agregarHorarios(TipoDia.LUNES, LocalTime.of(9, 00), 4.0f);
		commMate3.agregarHorarios(TipoDia.MIERCOLES, LocalTime.of(9, 00), 4.0f);
		long idcommMate3 = comisionServiceImp.save(commMate3);

		acc1.agregarComision(comisionServiceImp.get(idcommMate3));
		acc2.agregarComision(comisionServiceImp.get(idcommMate3));

		Comision commInPr1 = new Comision("InPr C1", materiaServiceImp.get(intro), 30, periodo1);
		commInPr1.agregarHorarios(TipoDia.LUNES, LocalTime.of(9, 00), 2.5f);
		commInPr1.agregarHorarios(TipoDia.JUEVES, LocalTime.of(9, 00), 2.5f);
		commInPr1.agregarHorarios(TipoDia.MIERCOLES, LocalTime.of(8, 00), 3.0f);
		long idcommInPr1 = comisionServiceImp.save(commInPr1);

		acc1.agregarComision(comisionServiceImp.get(idcommInPr1));
		acc2.agregarComision(comisionServiceImp.get(idcommInPr1));

		Comision commInPr2 = new Comision("InPr C2", materiaServiceImp.get(intro), 30, periodo1);
		commInPr2.agregarHorarios(TipoDia.LUNES, LocalTime.of(12, 00), 2.5f);
		commInPr2.agregarHorarios(TipoDia.JUEVES, LocalTime.of(12, 00), 2.5f);
		commInPr2.agregarHorarios(TipoDia.MIERCOLES, LocalTime.of(8, 00), 3.0f);
		long idcommInPr2 = comisionServiceImp.save(commInPr2);

		acc1.agregarComision(comisionServiceImp.get(idcommInPr2));
		acc2.agregarComision(comisionServiceImp.get(idcommInPr2));

		Comision commInPr3 = new Comision("InPr C3", materiaServiceImp.get(intro), 30, periodo1);
		commInPr3.agregarHorarios(TipoDia.LUNES, LocalTime.of(15, 00), 2.5f);
		commInPr3.agregarHorarios(TipoDia.JUEVES, LocalTime.of(15, 00), 2.5f);
		commInPr3.agregarHorarios(TipoDia.MIERCOLES, LocalTime.of(18, 00), 3.0f);
		long idcommInPr3 = comisionServiceImp.save(commInPr3);
		acc1.agregarComision(comisionServiceImp.get(idcommInPr3));
		acc2.agregarComision(comisionServiceImp.get(idcommInPr3));

		Comision commInPr4 = new Comision("InPr C4", materiaServiceImp.get(intro), 30, periodo1);
		commInPr4.agregarHorarios(TipoDia.LUNES, LocalTime.of(19, 00), 2.5f);
		commInPr4.agregarHorarios(TipoDia.JUEVES, LocalTime.of(19, 00), 2.5f);
		commInPr4.agregarHorarios(TipoDia.MIERCOLES, LocalTime.of(18, 00), 3.0f);
		long idcommInPr4 = comisionServiceImp.save(commInPr4);
		acc1.agregarComision(comisionServiceImp.get(idcommInPr4));
		acc2.agregarComision(comisionServiceImp.get(idcommInPr4));

		Comision commOrga1 = new Comision("Orga C1", materiaServiceImp.get(orga), 30, periodo1);
		commOrga1.agregarHorarios(TipoDia.MARTES, LocalTime.of(8, 00), 3.0f);
		commOrga1.agregarHorarios(TipoDia.VIERNES, LocalTime.of(8, 00), 3f);
		long idcommOrga1 = comisionServiceImp.save(commOrga1);
		acc1.agregarComision(comisionServiceImp.get(idcommOrga1));
		acc2.agregarComision(comisionServiceImp.get(idcommOrga1));

		Comision commOrga2 = new Comision("Orga C2", materiaServiceImp.get(orga), 30, periodo1);
		commOrga2.agregarHorarios(TipoDia.MARTES, LocalTime.of(11, 00), 3.0f);
		commOrga2.agregarHorarios(TipoDia.VIERNES, LocalTime.of(11, 00), 3f);
		long idcommOrga2 = comisionServiceImp.save(commOrga2);
		acc1.agregarComision(comisionServiceImp.get(idcommOrga2));
		acc2.agregarComision(comisionServiceImp.get(idcommOrga2));

		Comision commOrga3 = new Comision("Orga C3", materiaServiceImp.get(orga), 30, periodo1);
		commOrga3.agregarHorarios(TipoDia.MARTES, LocalTime.of(16, 00), 3.0f);
		commOrga3.agregarHorarios(TipoDia.VIERNES, LocalTime.of(16, 00), 3f);
		long idcommOrga3 = comisionServiceImp.save(commOrga3);
		acc1.agregarComision(comisionServiceImp.get(idcommOrga3));
		acc2.agregarComision(comisionServiceImp.get(idcommOrga3));

		Comision commOrga4 = new Comision("Orga C4", materiaServiceImp.get(orga), 30, periodo1);
		commOrga4.agregarHorarios(TipoDia.MARTES, LocalTime.of(19, 00), 3.0f);
		commOrga4.agregarHorarios(TipoDia.VIERNES, LocalTime.of(19, 00), 3f);
		long idcommOrga4 = comisionServiceImp.save(commOrga4);
		acc1.agregarComision(comisionServiceImp.get(idcommOrga4));
		acc2.agregarComision(comisionServiceImp.get(idcommOrga4));

		Comision commed1 = new Comision("EstrD C1", materiaServiceImp.get(ed), 30, periodo1);
		commed1.agregarHorarios(TipoDia.MARTES, LocalTime.of(18, 00), 3.0f);
		commed1.agregarHorarios(TipoDia.MIERCOLES, LocalTime.of(18, 00), 3f);
		commed1.agregarHorarios(TipoDia.SABADO, LocalTime.of(8, 00), 3f);
		long idcommed1 = comisionServiceImp.save(commed1);
		acc1.agregarComision(comisionServiceImp.get(idcommed1));
		acc2.agregarComision(comisionServiceImp.get(idcommed1));

		Comision commobj11 = new Comision("Obj1 C1", materiaServiceImp.get(obj1), 30, periodo1);
		commobj11.agregarHorarios(TipoDia.MIERCOLES, LocalTime.of(14, 00), 4f);
		commobj11.agregarHorarios(TipoDia.SABADO, LocalTime.of(8, 00), 4f);
		long idcommobj11 = comisionServiceImp.save(commobj11);
		acc1.agregarComision(comisionServiceImp.get(idcommobj11));
		acc2.agregarComision(comisionServiceImp.get(idcommobj11));

		Comision commobj12 = new Comision("Obj1 C2", materiaServiceImp.get(obj1), 30, periodo1);
		commobj12.agregarHorarios(TipoDia.LUNES, LocalTime.of(18, 00), 4f);
		commobj12.agregarHorarios(TipoDia.MARTES, LocalTime.of(18, 00), 4f);
		long idcommobj12 = comisionServiceImp.save(commobj12);
		acc1.agregarComision(comisionServiceImp.get(idcommobj12));

		Comision commbd1 = new Comision("BD C1", materiaServiceImp.get(bd), 1, periodo1);
		commbd1.agregarHorarios(TipoDia.LUNES, LocalTime.of(18, 00), 3f);
		commbd1.agregarHorarios(TipoDia.JUEVES, LocalTime.of(18, 00), 3f);
		long idcommbd1 = comisionServiceImp.save(commbd1);
		acc1.agregarComision(comisionServiceImp.get(idcommbd1));

		Comision commso1 = new Comision("SO C1", materiaServiceImp.get(so), 30, periodo1);
		commso1.agregarHorarios(TipoDia.JUEVES, LocalTime.of(16, 00), 6f);
		long idcommso1 = comisionServiceImp.save(commso1);
		acc1.agregarComision(comisionServiceImp.get(idcommso1));

		Comision commso2 = new Comision("SO C2", materiaServiceImp.get(so), 30, periodo1);
		commso2.agregarHorarios(TipoDia.MIERCOLES, LocalTime.of(18, 00), 4f);
		commso2.agregarHorarios(TipoDia.JUEVES, LocalTime.of(16, 00), 2f);
		long idcommso2 = comisionServiceImp.save(commso2);
		acc1.agregarComision(comisionServiceImp.get(idcommso2));

		Comision commredes1 = new Comision("Redes C1", materiaServiceImp.get(redes), 30, periodo1);
		commredes1.agregarHorarios(TipoDia.MARTES, LocalTime.of(9, 00), 2f);
		commredes1.agregarHorarios(TipoDia.JUEVES, LocalTime.of(8, 00), 4f);
		long idcommredes1 = comisionServiceImp.save(commredes1);
		acc1.agregarComision(comisionServiceImp.get(idcommredes1));

		Comision commredes2 = new Comision("Redes C1", materiaServiceImp.get(redes), 30, periodo1);
		commredes2.agregarHorarios(TipoDia.MARTES, LocalTime.of(18, 00), 4f);
		commredes2.agregarHorarios(TipoDia.JUEVES, LocalTime.of(18, 00), 2f);
		long idcommredes2 = comisionServiceImp.save(commredes2);
		acc1.agregarComision(comisionServiceImp.get(idcommredes2));

		Comision commobj21 = new Comision("Obj2 C1", materiaServiceImp.get(obj2), 30, periodo1);
		commobj21.agregarHorarios(TipoDia.LUNES, LocalTime.of(18, 00), 3f);
		commobj21.agregarHorarios(TipoDia.VIERNES, LocalTime.of(15, 00), 3f);
		long idcommobj21 = comisionServiceImp.save(commobj21);
		acc1.agregarComision(comisionServiceImp.get(idcommobj21));

		Comision commobj22 = new Comision("Obj2 C3", materiaServiceImp.get(obj2), 30, periodo1);
		commobj22.agregarHorarios(TipoDia.LUNES, LocalTime.of(18, 00), 3f);
		commobj22.agregarHorarios(TipoDia.VIERNES, LocalTime.of(18, 00), 3f);
		long idcommobj22 = comisionServiceImp.save(commobj22);
		acc1.agregarComision(comisionServiceImp.get(idcommobj22));

		Comision commMate21 = new Comision("Mate2 C1", materiaServiceImp.get(mate2), 30, periodo1);
		commMate21.agregarHorarios(TipoDia.JUEVES, LocalTime.of(18, 00), 4f);
		long idcommMate21 = comisionServiceImp.save(commMate21);
		acc1.agregarComision(comisionServiceImp.get(idcommMate21));

		Comision commMate22 = new Comision("Mate2 C2", materiaServiceImp.get(mate2), 30, periodo1);
		commMate22.agregarHorarios(TipoDia.MARTES, LocalTime.of(16, 00), 2f);
		commMate22.agregarHorarios(TipoDia.MIERCOLES, LocalTime.of(16, 00), 2f);
		long idcommMate22 = comisionServiceImp.save(commMate22);
		acc1.agregarComision(comisionServiceImp.get(idcommMate22));

		Comision commcIU1 = new Comision("UIs C1", materiaServiceImp.get(cIU), 30, periodo1);
		commcIU1.agregarHorarios(TipoDia.JUEVES, LocalTime.of(16, 00), 6f);
		long idcommcIU1 = comisionServiceImp.save(commcIU1);
		acc1.agregarComision(comisionServiceImp.get(idcommcIU1));

		Comision commingS1 = new Comision("IngSoft C1", materiaServiceImp.get(ingS), 30, periodo1);
		commingS1.agregarHorarios(TipoDia.LUNES, LocalTime.of(19, 00), 3f);
		commingS1.agregarHorarios(TipoDia.MIERCOLES, LocalTime.of(19, 00), 3f);
		long idcommingS1 = comisionServiceImp.save(commingS1);
		acc1.agregarComision(comisionServiceImp.get(idcommingS1));

		Comision commePers1 = new Comision("EPers C1", materiaServiceImp.get(ePers), 30, periodo1);
		commePers1.agregarHorarios(TipoDia.VIERNES, LocalTime.of(16, 00), 6f);
		long idcommePers1 = comisionServiceImp.save(commePers1);
		acc1.agregarComision(comisionServiceImp.get(idcommePers1));

		Comision commlabo1 = new Comision("Labo C1", materiaServiceImp.get(labo), 30, periodo1);
		commlabo1.agregarHorarios(TipoDia.JUEVES, LocalTime.of(18, 00), 4f);
		long idcommlabo1 = comisionServiceImp.save(commlabo1);
		acc1.agregarComision(comisionServiceImp.get(idcommlabo1));

		Comision commpF1 = new Comision("PF C1", materiaServiceImp.get(pF), 30, periodo1);
		commpF1.agregarHorarios(TipoDia.MIERCOLES, LocalTime.of(15, 00), 2f);
		commpF1.agregarHorarios(TipoDia.SABADO, LocalTime.of(11, 00), 2f);
		long idcommpF1 = comisionServiceImp.save(commpF1);
		acc1.agregarComision(comisionServiceImp.get(idcommpF1));

		Comision commdesa1 = new Comision("DesApp C1", materiaServiceImp.get(desa), 30, periodo1);
		commdesa1.agregarHorarios(TipoDia.MARTES, LocalTime.of(16, 00), 6f);
		long idcommdesa1 = comisionServiceImp.save(commdesa1);
		acc1.agregarComision(comisionServiceImp.get(idcommdesa1));

		Comision commtip1 = new Comision("TIP C1", materiaServiceImp.get(tip), 30, periodo1);
		commtip1.agregarHorarios(TipoDia.SABADO, LocalTime.of(8, 00), 5f);
		long idcommtip1 = comisionServiceImp.save(commtip1);
		acc1.agregarComision(comisionServiceImp.get(idcommtip1));

		Comision commsI1 = new Comision("TIP C1", materiaServiceImp.get(sI), 30, periodo1);
		commsI1.agregarHorarios(TipoDia.SABADO, LocalTime.of(9, 00), 4f);
		long idcommsI1 = comisionServiceImp.save(commsI1);
		acc1.agregarComision(comisionServiceImp.get(idcommsI1));

		Comision commpc1 = new Comision("PConc C1", materiaServiceImp.get(pc), 30, periodo1);
		commpc1.agregarHorarios(TipoDia.MIERCOLES, LocalTime.of(17, 00), 4f);
		long idcommpc1 = comisionServiceImp.save(commpc1);
		acc1.agregarComision(comisionServiceImp.get(idcommpc1));

		Comision commobj3 = new Comision("Obj3 C1", materiaServiceImp.get(obj3), 30, periodo1);
		commobj3.agregarHorarios(TipoDia.MARTES, LocalTime.of(18, 00), 4f);
		long idcommobj3 = comisionServiceImp.save(commobj3);
		acc1.agregarComision(comisionServiceImp.get(idcommobj3));

		Comision commcLP = new Comision("CLP C1", materiaServiceImp.get(cLP), 30, periodo1);
		commcLP.agregarHorarios(TipoDia.MARTES, LocalTime.of(18, 00), 2f);
		commcLP.agregarHorarios(TipoDia.MIERCOLES, LocalTime.of(18, 00), 2f);
		long idcommcLP = comisionServiceImp.save(commcLP);
		acc1.agregarComision(comisionServiceImp.get(idcommcLP));

		Comision commlyp = new Comision("LyP C1", materiaServiceImp.get(lyp), 30, periodo1);
		commlyp.agregarHorarios(TipoDia.LUNES, LocalTime.of(9, 00), 2f);
		commlyp.agregarHorarios(TipoDia.MARTES, LocalTime.of(9, 00), 2f);
		long idcommlyp = comisionServiceImp.save(commlyp);
		acc2.agregarComision(comisionServiceImp.get(idcommlyp));

		Comision commiDV = new Comision("Videojuegos C1", materiaServiceImp.get(iDV), 30, periodo1);
		commiDV.agregarHorarios(TipoDia.MIERCOLES, LocalTime.of(8, 00), 4f);
		long idcommiDV = comisionServiceImp.save(commiDV);
		acc1.agregarComision(comisionServiceImp.get(idcommiDV));

		Comision commingles2 = new Comision("Ingles2 C1", materiaServiceImp.get(ingles2), 30, periodo1);
		commingles2.agregarHorarios(TipoDia.MIERCOLES, LocalTime.of(14, 00), 3f);
		long idcommingles2 = comisionServiceImp.save(commingles2);
		acc1.agregarComision(comisionServiceImp.get(idcommingles2));

		Long idAcamicOffer1 = ofertaAcademicaServiceImp.save(acc1);
		Long idAcamicOffer2 = ofertaAcademicaServiceImp.save(acc2);

		Encuesta poll = new Encuesta("Encuesta segundo semestre 2018", LocalDateTime.of(2018, 8, 25, 00, 00),
				LocalDateTime.of(2019, 12, 15, 00, 00), periodo1);
		poll.agregarOfertaAcademica((OfertaAcademica) ofertaAcademicaServiceImp.get(idAcamicOffer1));

		Long idEncuesta = encuestaServiceImp.save(poll);

		Equivalencia equivalenciaSeg = new Equivalencia(materiaServiceImp.get(sI), materiaServiceImp.get(segInfo));
		equivalenciaServiceImp.save(equivalenciaSeg);

		try {
			webService.importarEstudiantes(idEncuesta);
		} catch (ConexionWebServiceException | EncuestaNoExisteException e) {
			e.printStackTrace();
		}

		Usuario usuario = new Usuario("root", "root", "cpi_epi@unq.edu.ar", "00000000");
		usuario.setPassword("root");
		usuario.agregarPerfil(TipoPerfil.ADMINISTRADOR);
		usuarioServiceImp.save(usuario);

		TipoIncidencia tipoIncidencia = new TipoIncidencia("DNI incorrecto");
		tipoIncidenciaServiceImp.save(tipoIncidencia);

		tipoIncidencia = new TipoIncidencia("Cambio de e-mail");
		tipoIncidenciaServiceImp.save(tipoIncidencia);

		tipoIncidencia = new TipoIncidencia("Corrección de nombre y apellido");
		tipoIncidenciaServiceImp.save(tipoIncidencia);

		tipoIncidencia = new TipoIncidencia("Otro");
		tipoIncidenciaServiceImp.save(tipoIncidencia);

	}
}