package util;

import java.text.SimpleDateFormat;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import model.*;

public class DBLoader {

	private static SessionFactory sessions;

	public DBLoader() {
	}

	public static void main(String[] args) {
		try {
			System.out
					.println("----------------------- Setting up Hibernate -----------------------");
			Configuration cfg = new Configuration();
			cfg.configure("hibernate/hibernate.cfg.xml");

			System.out.println("Droping schema.........");
			new SchemaExport(cfg).drop(true, true);
			System.out.println("DONE.");

			System.out.println("Generating schema.........");
			new SchemaExport(cfg).create(true, true);
			System.out.println("DONE.");

			System.out.println("Building sessions.........");
			sessions = cfg.buildSessionFactory();
			Sitio sitio = cargarBase();

			Session session = sessions.openSession();
			Transaction tx = null;
			try {
				tx = session.beginTransaction();
				session.save(sitio);
				session.flush();
				tx.commit();
			} catch (Exception e) {
				e.printStackTrace();
				if (tx != null) {
					tx.rollback();
				}
				session.close();
			}
			session.disconnect();

			System.out.println("DONE.");
		} catch (Exception e) {
			System.out
					.println("------------------------DALE QUE LLEGAS!!------------------------");
			e.printStackTrace();
		}
	}

	private static Sitio cargarBase() throws Exception {
		Sitio sitio = new Sitio();
		Catalogo catalogo = sitio.getCatalogo();
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

		Pelicula dragna = new Pelicula("Dragna", 14, 732600);
		catalogo.agregar(dragna);
		Pelicula billythekidmcdonnen = new Pelicula("Billy The Kid McDonnen",
				17, 838200);
		catalogo.agregar(billythekidmcdonnen);
		Pelicula threewiseguys = new Pelicula("Three Wise Guys", 7, 703800);
		catalogo.agregar(threewiseguys);
		Pelicula americanhustle = new Pelicula("American Hustle ", 15, 809400);
		catalogo.agregar(americanhustle);
		Pelicula lastvegas = new Pelicula("Last Vegas ", 16, 675000);
		catalogo.agregar(lastvegas);
		Pelicula killingseason = new Pelicula("Killing Season ", 6, 780600);
		catalogo.agregar(killingseason);
		Pelicula thefamily = new Pelicula("The Family ", 14, 646200);
		catalogo.agregar(thefamily);
		Pelicula thebigwedding = new Pelicula("The Big Wedding ", 4, 751800);
		catalogo.agregar(thebigwedding);
		Pelicula silverliningsplaybook = new Pelicula(
				"Silver Linings Playbook ", 12, 617400);
		catalogo.agregar(silverliningsplaybook);
		Pelicula freelancers = new Pelicula("Freelancers ", 2, 711000);
		catalogo.agregar(freelancers);
		Pelicula beingflynn = new Pelicula("Being Flynn ", 16, 816600);
		catalogo.agregar(beingflynn);
		Pelicula redlights = new Pelicula("Red Lights ", 17, 682200);
		catalogo.agregar(redlights);
		Pelicula newyearseve = new Pelicula("New Years Eve ", 7, 700200);
		catalogo.agregar(newyearseve);
		Pelicula killerelite = new Pelicula("Killer Elite", 8, 805800);
		catalogo.agregar(killerelite);
		Pelicula ilimitless = new Pelicula("I Limitless", 16, 823800);
		catalogo.agregar(ilimitless);
		Pelicula lasedadesdelamor = new Pelicula("Las edades del amor", 6,
				689400);
		catalogo.agregar(lasedadesdelamor);
		Pelicula stone = new Pelicula("Stone", 7, 795000);
		catalogo.agregar(stone);
		Pelicula machete = new Pelicula("Machete", 15, 813000);
		catalogo.agregar(machete);
		Pelicula everybodysfine = new Pelicula("Everybodys Fine", 5, 678600);
		catalogo.agregar(everybodysfine);
		Pelicula righteouskill = new Pelicula("Righteous Kill", 7, 784200);
		catalogo.agregar(righteouskill);
		Pelicula whatjusthappened = new Pelicula("What Just Happened", 14,
				801600);
		catalogo.agregar(whatjusthappened);
		Pelicula stardust = new Pelicula("Stardust", 4, 667200);
		catalogo.agregar(stardust);
		Pelicula thegoodshepherd = new Pelicula("The Good Shepherd", 12, 772800);
		catalogo.agregar(thegoodshepherd);
		Pelicula arthurandtheinvisibles = new Pelicula(
				"Arthur and the Invisibles", 2, 638400);
		catalogo.agregar(arthurandtheinvisibles);
		Pelicula extrastvseries = new Pelicula("Extras (TV Series)", 10, 744000);
		catalogo.agregar(extrastvseries);
		Pelicula greatexpectations = new Pelicula("Great Expectations", 11,
				609600);
		catalogo.agregar(greatexpectations);
		Pelicula jackiebrown = new Pelicula("Jackie Brown", 1, 715200);
		catalogo.agregar(jackiebrown);
		Pelicula wagthedog = new Pelicula("Wag the Dog", 9, 733200);
		catalogo.agregar(wagthedog);
		Pelicula copland = new Pelicula("Cop Land", 17, 838800);
		catalogo.agregar(copland);
		Pelicula marvinsroom = new Pelicula("Marvins Room", 7, 704400);
		catalogo.agregar(marvinsroom);
		Pelicula sleepers = new Pelicula("Sleepers", 8, 810000);
		catalogo.agregar(sleepers);
		Pelicula thefan = new Pelicula("The Fan", 16, 828000);
		catalogo.agregar(thefan);
		Pelicula heat = new Pelicula("Heat", 18, 693600);
		catalogo.agregar(heat);
		Pelicula casino = new Pelicula("Casino", 8, 780600);
		catalogo.agregar(casino);
		Pelicula onehundredandonenights = new Pelicula(
				"One Hundred and One Nights", 14, 802800);
		catalogo.agregar(onehundredandonenights);
		Pelicula frankenstein = new Pelicula("Frankenstein", 4, 820800);
		catalogo.agregar(frankenstein);
		Pelicula abronxtale = new Pelicula("A Bronx Tale", 17, 838800);
		catalogo.agregar(abronxtale);
		Pelicula thisboyslife = new Pelicula("This Boys Life", 6, 692400);
		catalogo.agregar(thisboyslife);
		Pelicula maddogandglory = new Pelicula("Mad Dog and Glory", 1, 622800);
		catalogo.agregar(maddogandglory);
		Pelicula nightandthecity = new Pelicula("Night and the City", 2, 793200);
		catalogo.agregar(nightandthecity);
		Pelicula mistress = new Pelicula("Mistress", 15, 811200);
		catalogo.agregar(mistress);
		Pelicula capefear = new Pelicula("Cape Fear", 10, 741000);
		catalogo.agregar(capefear);
		Pelicula backdraft = new Pelicula("Backdraft", 11, 671400);
		catalogo.agregar(backdraft);
		Pelicula guiltybysuspicion = new Pelicula("Guilty by Suspicion", 6,
				689400);
		catalogo.agregar(guiltybysuspicion);
		Pelicula awakenings = new Pelicula("Awakenings", 7, 619200);
		catalogo.agregar(awakenings);
		Pelicula goodfellas = new Pelicula("Goodfellas", 2, 637200);
		catalogo.agregar(goodfellas);
		Pelicula stanleyiris = new Pelicula("Stanley & Iris", 15, 807600);
		catalogo.agregar(stanleyiris);
		Pelicula werenoangels = new Pelicula("Were No Angels", 16, 738000);
		catalogo.agregar(werenoangels);
		Pelicula jacknife = new Pelicula("Jacknife", 11, 755400);
		catalogo.agregar(jacknife);
		Pelicula midnightrun = new Pelicula("Midnight Run", 12, 685800);
		catalogo.agregar(midnightrun);
		Pelicula dearamericalettershomefromvietnamtvmoviedocumentary = new Pelicula(
				"Dear America: Letters Home from Vietnam (TV Movie documentary)",
				7, 772800);
		catalogo.agregar(dearamericalettershomefromvietnamtvmoviedocumentary);
		Pelicula theuntouchables = new Pelicula("The Untouchables", 14, 638400);
		catalogo.agregar(theuntouchables);
		Pelicula angelheart = new Pelicula("Angel Heart", 2, 637800);
		catalogo.agregar(angelheart);
		Pelicula themission = new Pelicula("The Mission", 15, 808200);
		catalogo.agregar(themission);
		Pelicula brazil = new Pelicula("Brazil", 16, 826200);
		catalogo.agregar(brazil);
		Pelicula fallinginlove = new Pelicula("Falling in Love", 18, 756000);
		catalogo.agregar(fallinginlove);
		Pelicula thekingofcomedy = new Pelicula("The King of Comedy", 12,
				686400);
		catalogo.agregar(thekingofcomedy);
		Pelicula trueconfessions = new Pelicula("True Confessions", 7, 616800);
		catalogo.agregar(trueconfessions);
		Pelicula ragingbull = new Pelicula("Raging Bull", 2, 634200);
		catalogo.agregar(ragingbull);
		Pelicula thedeerhunter = new Pelicula("The Deer Hunter", 3, 652200);
		catalogo.agregar(thedeerhunter);
		Pelicula newyorknewyork = new Pelicula("New York, New York", 16, 822600);
		catalogo.agregar(newyorknewyork);
		Pelicula thelasttycoon = new Pelicula("The Last Tycoon", 11, 753000);
		catalogo.agregar(thelasttycoon);
		Pelicula taxidriver = new Pelicula("Taxi Driver", 12, 771000);
		catalogo.agregar(taxidriver);
		Pelicula thegodfatherpartii = new Pelicula("The Godfather: Part II", 7,
				700800);
		catalogo.agregar(thegodfatherpartii);
		Pelicula meanstreets = new Pelicula("Mean Streets", 8, 631200);
		catalogo.agregar(meanstreets);
		Pelicula bangthedrumslowly = new Pelicula("Bang the Drum Slowly", 2,
				637200);
		catalogo.agregar(bangthedrumslowly);
		Pelicula thegangthatcouldntshootstraight = new Pelicula(
				"The Gang That Couldnt Shoot Straight", 3, 807600);
		catalogo.agregar(thegangthatcouldntshootstraight);
		Pelicula borntowin = new Pelicula("Born to Win", 16, 738000);
		catalogo.agregar(borntowin);
		Pelicula jenniferonmymind = new Pelicula("Jennifer on My Mind", 11,
				756000);
		catalogo.agregar(jenniferonmymind);
		Pelicula himom = new Pelicula("Hi, Mom!", 6, 685800);
		catalogo.agregar(himom);
		Pelicula bloodymama = new Pelicula("Bloody Mama", 7, 616200);
		catalogo.agregar(bloodymama);
		Pelicula samssong = new Pelicula("Sams Song", 2, 786600);
		catalogo.agregar(samssong);
		Pelicula theweddingparty = new Pelicula("The Wedding Party", 15, 804600);
		catalogo.agregar(theweddingparty);
		Pelicula greetings = new Pelicula("Greetings", 9, 734400);
		catalogo.agregar(greetings);
		Pelicula threeroomsinmanhattan = new Pelicula(
				"Three Rooms in Manhattan", 11, 664800);
		catalogo.agregar(threeroomsinmanhattan);
		Pelicula encounter = new Pelicula("Encounter", 6, 682800);
		catalogo.agregar(encounter);
		Serie barney = new Serie("Barney", 2);
		Temporada barneyS1 = new Temporada(barney, 1);
		Episodio barneyS1E1 = new Episodio(350400, 1,
				"The Queen of Make Believe", barneyS1);
		Episodio barneyS1E2 = new Episodio(315000, 2,
				"My Family s Just Right for Me", barneyS1);
		Episodio barneyS1E3 = new Episodio(355200, 3,
				"Baby Bop s first appearance on the TV series ", barneyS1);
		Episodio barneyS1E4 = new Episodio(319200, 4, "Playing It Safe",
				barneyS1);
		Episodio barneyS1E5 = new Episodio(321600, 5, "Hop to It", barneyS1);
		Episodio barneyS1E6 = new Episodio(323400, 6,
				"Eat, Drink and Be Healthy", barneyS1);
		Episodio barneyS1E7 = new Episodio(309600, 7, "Four Seasons Day",
				barneyS1);
		Episodio barneyS1E8 = new Episodio(312000, 8,
				"The Treasure of Rainbow Beard", barneyS1);
		Episodio barneyS1E9 = new Episodio(314400, 9, "Going Places", barneyS1);
		Episodio barneyS1E10 = new Episodio(316200, 10, "Caring Means Sharing",
				barneyS1);
		Episodio barneyS1E11 = new Episodio(318600, 11,
				"Down on Barney s Farm", barneyS1);
		Episodio barneyS1E12 = new Episodio(304800, 12, "What s That Shadow",
				barneyS1);
		Episodio barneyS1E13 = new Episodio(307200, 13,
				"Happy Birthday Barney", barneyS1);
		Episodio barneyS1E14 = new Episodio(331200, 14, "Alphabet Soup",
				barneyS1);
		Episodio barneyS1E15 = new Episodio(333600, 15, "Our Earth, Our Home",
				barneyS1);
		Episodio barneyS1E16 = new Episodio(335400, 16,
				"Let s Help Mother Goose", barneyS1);
		Episodio barneyS1E17 = new Episodio(337800, 17, "Be a Friend", barneyS1);
		Episodio barneyS1E18 = new Episodio(301800, 18, "I Just LOVE Bugs",
				barneyS1);
		Episodio barneyS1E19 = new Episodio(304200, 19, "When I Grow Up",
				barneyS1);
		Episodio barneyS1E20 = new Episodio(306600, 20, "Practice Makes Music",
				barneyS1);
		Episodio barneyS1E21 = new Episodio(330600, 21, "Hi Neighbor", barneyS1);
		Episodio barneyS1E22 = new Episodio(316800, 22, "A Camping We Will Go",
				barneyS1);
		Episodio barneyS1E23 = new Episodio(340800, 23,
				"A Splash Party Please", barneyS1);
		Episodio barneyS1E24 = new Episodio(343200, 24, "Carnival of Numbers",
				barneyS1);
		Episodio barneyS1E25 = new Episodio(345600, 25, "A World of Music",
				barneyS1);
		Episodio barneyS1E26 = new Episodio(309600, 26,
				"Doctor Barney is Here", barneyS1);
		Episodio barneyS1E27 = new Episodio(333600, 27, "Oh What a Day",
				barneyS1);
		Episodio barneyS1E28 = new Episodio(336000, 28, "Home Sweet Homes",
				barneyS1);
		Episodio barneyS1E29 = new Episodio(300000, 29, "Hola Mexico", barneyS1);
		Episodio barneyS1E30 = new Episodio(302400, 30, "Everyone is Special",
				barneyS1);

		catalogo.agregar(barney);

		Serie breakingbad = new Serie("Breaking Bad", 16);
		Temporada breakingbadS1 = new Temporada(breakingbad, 1);
		Episodio breakingbadS1E1 = new Episodio(332400, 1, "Pilot",
				breakingbadS1);
		Episodio breakingbadS1E2 = new Episodio(356400, 2, "Cat s in the Bag",
				breakingbadS1);
		Episodio breakingbadS1E3 = new Episodio(358800, 3,
				"And the Bag s in the River", breakingbadS1);
		Episodio breakingbadS1E4 = new Episodio(342000, 4, "Cancer Man",
				breakingbadS1);
		Episodio breakingbadS1E5 = new Episodio(306000, 5, "Gray Matter",
				breakingbadS1);
		Episodio breakingbadS1E6 = new Episodio(308400, 6,
				"Crazy Handful of Nothin ", breakingbadS1);
		Episodio breakingbadS1E7 = new Episodio(332400, 7,
				"A No-Rough-Stuff-Type Deal", breakingbadS1);

		catalogo.agregar(breakingbad);

		Serie thesimpsons = new Serie("The Simpsons", 9);
		Temporada thesimpsonsS1 = new Temporada(thesimpsons, 1);
		Episodio thesimpsonsS1E1 = new Episodio(318600, 1,
				"Simpsons Roasting on an Open Fire", thesimpsonsS1);
		Episodio thesimpsonsS1E2 = new Episodio(320400, 2, "Bart the Genius",
				thesimpsonsS1);
		Episodio thesimpsonsS1E3 = new Episodio(322800, 3, "Homers Odyssey",
				thesimpsonsS1);
		Episodio thesimpsonsS1E4 = new Episodio(325200, 4,
				"Theres No Disgrace Like Home", thesimpsonsS1);
		Episodio thesimpsonsS1E5 = new Episodio(327600, 5, "Bart the General",
				thesimpsonsS1);
		Episodio thesimpsonsS1E6 = new Episodio(329400, 6, "Moaning Lisa",
				thesimpsonsS1);
		Episodio thesimpsonsS1E7 = new Episodio(331800, 7,
				"The Call of the Simpsons", thesimpsonsS1);
		Episodio thesimpsonsS1E8 = new Episodio(355800, 8, "The Telltale Head",
				thesimpsonsS1);
		Episodio thesimpsonsS1E9 = new Episodio(358200, 9,
				"Life on the Fast Lane", thesimpsonsS1);
		Episodio thesimpsonsS1E10 = new Episodio(300600, 10,
				"Homers Night Out", thesimpsonsS1);
		Episodio thesimpsonsS1E11 = new Episodio(303000, 11,
				"The Crepes of Wrath", thesimpsonsS1);
		Episodio thesimpsonsS1E12 = new Episodio(327000, 12,
				"Krusty Gets Busted", thesimpsonsS1);
		Episodio thesimpsonsS1E13 = new Episodio(351000, 13,
				"Some Enchanted Evening", thesimpsonsS1);

		catalogo.agregar(thesimpsons);

		Usuario janetwang12 = new Usuario(format.parse("26/1/1974"),
				"janetwang12@hotmail.com", format.parse("6/8/2013"), catalogo);
		janetwang12.getSuscripcion().pasarANormal();
		janetwang12.getGestor().registrarReproduccion(samssong,
				format.parse("6/8/2013"), 62400);
		janetwang12.getGestor().registrarReproduccion(freelancers,
				format.parse("6/8/2013"), 181800);
		janetwang12.getGestor().registrarReproduccion(barneyS1E16,
				format.parse("6/8/2013"), 301800);
		janetwang12.getGestor().registrarReproduccion(stanleyiris,
				format.parse("6/8/2013"), 456600);
		janetwang12.getGestor().registrarReproduccion(barneyS1E7,
				format.parse("6/8/2013"), 336000);
		janetwang12.getGestor().registrarReproduccion(barneyS1E8,
				format.parse("6/8/2013"), 300000);
		janetwang12.getGestor().registrarReproduccion(nightandthecity,
				format.parse("6/8/2013"), 232800);
		janetwang12.getGestor().registrarReproduccion(encounter,
				format.parse("6/8/2013"), 388800);
		janetwang12.getGestor().registrarReproduccion(breakingbadS1E5,
				format.parse("11/10/2013"), 286200);
		janetwang12.getGestor().registrarReproduccion(whatjusthappened,
				format.parse("6/8/2013"), 488400);
		janetwang12.getGestor().registrarReproduccion(freelancers,
				format.parse("6/8/2013"), 515400);
		janetwang12.getGestor().registrarReproduccion(goodfellas,
				format.parse("14/11/2013"), 367200);
		janetwang12.getGestor().registrarReproduccion(samssong,
				format.parse("6/8/2013"), 218400);
		janetwang12.getGestor().registrarReproduccion(barneyS1E22,
				format.parse("6/8/2013"), 343200);
		janetwang12.getGestor().registrarReproduccion(breakingbadS1E7,
				format.parse("6/8/2013"), 318000);
		janetwang12.getGestor().registrarReproduccion(thekingofcomedy,
				format.parse("17/8/2013"), 520200);
		janetwang12.getGestor().registrarReproduccion(barneyS1E4,
				format.parse("22/10/2013"), 67200);
		janetwang12.getGestor().registrarReproduccion(barneyS1E28,
				format.parse("6/8/2013"), 269400);
		janetwang12.getGestor().registrarReproduccion(barneyS1E30,
				format.parse("6/8/2013"), 296400);
		janetwang12.getGestor().registrarReproduccion(threewiseguys,
				format.parse("6/8/2013"), 498600);
		janetwang12.getGestor().registrarReproduccion(jackiebrown,
				format.parse("20/9/2013"), 525600);
		janetwang12.getGestor().registrarReproduccion(barneyS1E20,
				format.parse("6/8/2013"), 72000);
		janetwang12.getGestor().registrarReproduccion(thesimpsonsS1E7,
				format.parse("6/8/2013"), 145200);
		janetwang12.getGestor().registrarReproduccion(stone,
				format.parse("18/9/2013"), 301200);
		janetwang12.getGestor().registrarReproduccion(barneyS1E11,
				format.parse("23/11/2013"), 267600);
		janetwang12.getGestor().registrarReproduccion(breakingbadS1E4,
				format.parse("6/8/2013"), 328200);
		janetwang12.getGestor().registrarReproduccion(barneyS1E11,
				format.parse("6/10/2013"), 63000);
		janetwang12.getGestor().registrarReproduccion(thegoodshepherd,
				format.parse("6/8/2013"), 265200);
		janetwang12.getGestor().registrarReproduccion(stanleyiris,
				format.parse("6/8/2013"), 467400);
		janetwang12.getGestor().registrarReproduccion(himom,
				format.parse("20/9/2013"), 364800);
		janetwang12.getGestor().registrarReproduccion(barneyS1E18,
				format.parse("25/11/2013"), 328200);
		janetwang12.setSesion(new Sesion(new Reproduccion(barneyS1E28, format
				.parse("7/2/2014"), 324000), format.parse("7/2/2014")));
		sitio.registrarUsuario(janetwang12);
		Usuario boniface120global = new Usuario(format.parse("21/10/1952"),
				"boniface120global@gmail.com", format.parse("19/1/2011"),
				catalogo);
		boniface120global.getSuscripcion().pasarANormal();
		boniface120global.getGestor().registrarReproduccion(breakingbadS1E7,
				format.parse("1/1/2012"), 117600);
		boniface120global.getGestor().registrarReproduccion(beingflynn,
				format.parse("7/4/2012"), 319800);
		boniface120global.getGestor().registrarReproduccion(thesimpsonsS1E1,
				format.parse("12/6/2012"), 332400);
		boniface120global.getGestor().registrarReproduccion(trueconfessions,
				format.parse("17/8/2013"), 419400);
		boniface120global.getGestor().registrarReproduccion(
				onehundredandonenights, format.parse("22/10/2013"), 316800);
		boniface120global.getGestor().registrarReproduccion(ragingbull,
				format.parse("17/8/2013"), 519000);
		boniface120global.getGestor().registrarReproduccion(barneyS1E6,
				format.parse("5/3/2013"), 241200);
		boniface120global.getGestor().registrarReproduccion(extrastvseries,
				format.parse("18/8/2013"), 139200);
		boniface120global.getGestor().registrarReproduccion(barneyS1E9,
				format.parse("5/3/2012"), 165600);
		boniface120global.getGestor().registrarReproduccion(copland,
				format.parse("10/5/2012"), 367800);
		boniface120global.getGestor().registrarReproduccion(theuntouchables,
				format.parse("16/7/2013"), 394800);
		boniface120global.getGestor().registrarReproduccion(
				threeroomsinmanhattan, format.parse("3/2/2012"), 292200);
		boniface120global.getGestor().registrarReproduccion(everybodysfine,
				format.parse("8/9/2012"), 319200);
		boniface120global.getGestor().registrarReproduccion(
				silverliningsplaybook, format.parse("26/12/2012"), 521400);
		boniface120global.getGestor().registrarReproduccion(thesimpsonsS1E11,
				format.parse("14/11/2013"), 114600);
		boniface120global.getGestor().registrarReproduccion(casino,
				format.parse("12/6/2012"), 445800);
		boniface120global.getGestor().registrarReproduccion(barneyS1E27,
				format.parse("27/5/2012"), 322200);
		boniface120global.getGestor().registrarReproduccion(dragna,
				format.parse("15/7/2013"), 148800);
		boniface120global.getGestor().registrarReproduccion(
				arthurandtheinvisibles, format.parse("20/9/2012"), 526800);
		boniface120global.getGestor().registrarReproduccion(werenoangels,
				format.parse("25/7/2013"), 249000);
		boniface120global.getGestor().registrarReproduccion(encounter,
				format.parse("3/2/2012"), 275400);
		boniface120global.getGestor().registrarReproduccion(everybodysfine,
				format.parse("19/9/2013"), 302400);
		boniface120global.getGestor().registrarReproduccion(backdraft,
				format.parse("24/11/2013"), 153600);
		boniface120global.getGestor().registrarReproduccion(bangthedrumslowly,
				format.parse("1/1/2012"), 531600);
		boniface120global.getGestor().registrarReproduccion(freelancers,
				format.parse("6/3/2012"), 78000);
		boniface120global.getGestor().registrarReproduccion(heat,
				format.parse("22/10/2012"), 409800);
		boniface120global.getGestor().registrarReproduccion(thekingofcomedy,
				format.parse("17/8/2013"), 132000);
		boniface120global.getGestor().registrarReproduccion(barneyS1E4,
				format.parse("22/10/2013"), 323400);
		boniface120global.getGestor().registrarReproduccion(thekingofcomedy,
				format.parse("27/12/2012"), 536400);
		boniface120global.getGestor().registrarReproduccion(barneyS1E5,
				format.parse("4/3/2013"), 258600);
		boniface120global.getGestor().registrarReproduccion(barneyS1E28,
				format.parse("27/12/2012"), 285600);
		boniface120global.getGestor().registrarReproduccion(barneyS1E6,
				format.parse("22/10/2013"), 328200);
		boniface120global.getGestor().registrarReproduccion(barneyS1E29,
				format.parse("10/5/2012"), 348600);
		boniface120global.getGestor().registrarReproduccion(capefear,
				format.parse("18/5/2012"), 237000);
		boniface120global.getGestor().registrarReproduccion(lasedadesdelamor,
				format.parse("18/1/2012"), 134400);
		boniface120global.getGestor().registrarReproduccion(theuntouchables,
				format.parse("26/11/2013"), 336600);
		boniface120global.getGestor().registrarReproduccion(breakingbadS1E5,
				format.parse("11/5/2012"), 234000);
		boniface120global.getGestor().registrarReproduccion(
				silverliningsplaybook, format.parse("16/8/2012"), 131400);
		boniface120global.getGestor().registrarReproduccion(thefan,
				format.parse("22/10/2013"), 158400);
		boniface120global.getGestor().registrarReproduccion(fallinginlove,
				format.parse("27/12/2012"), 171000);
		boniface120global.getGestor().registrarReproduccion(thesimpsonsS1E12,
				format.parse("4/2/2012"), 244200);
		boniface120global.getGestor().registrarReproduccion(jenniferonmymind,
				format.parse("2/1/2013"), 316800);
		boniface120global.getGestor().registrarReproduccion(barneyS1E16,
				format.parse("25/11/2013"), 301800);
		boniface120global.getGestor().registrarReproduccion(thesimpsonsS1E3,
				format.parse("2/2/2012"), 358800);
		boniface120global.getGestor().registrarReproduccion(newyearseve,
				format.parse("7/4/2012"), 314400);
		boniface120global.getGestor().registrarReproduccion(abronxtale,
				format.parse("12/6/2012"), 516600);
		boniface120global.getGestor().registrarReproduccion(thedeerhunter,
				format.parse("18/9/2013"), 414000);
		boniface120global.getGestor().registrarReproduccion(thebigwedding,
				format.parse("16/8/2013"), 311400);
		boniface120global.getGestor().registrarReproduccion(thefan,
				format.parse("21/10/2013"), 338400);
		boniface120global.getGestor().registrarReproduccion(brazil,
				format.parse("27/12/2012"), 189600);
		boniface120global.getGestor().registrarReproduccion(thesimpsonsS1E12,
				format.parse("4/2/2012"), 262800);
		boniface120global.getGestor().registrarReproduccion(stardust,
				format.parse("9/9/2013"), 114000);
		boniface120global.getGestor().registrarReproduccion(goodfellas,
				format.parse("24/11/2013"), 141000);
		boniface120global.getGestor().registrarReproduccion(jenniferonmymind,
				format.parse("2/9/2013"), 343200);
		boniface120global.getGestor().registrarReproduccion(barneyS1E17,
				format.parse("25/11/2013"), 65400);
		boniface120global.getGestor().registrarReproduccion(himom,
				format.parse("2/2/2012"), 138600);
		boniface120global.setSesion(new Sesion(new Reproduccion(dragna, format
				.parse("4/1/2014"), 189600), format.parse("4/1/2014")));
		sitio.registrarUsuario(boniface120global);
		Usuario hiltonfinancialmgtdpt = new Usuario(format.parse("21/10/1998"),
				"hiltonfinancialmgtdpt@admin.in.th", format.parse("9/4/2012"),
				catalogo);
		hiltonfinancialmgtdpt.getSuscripcion().pasarAVIP();
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(barneyS1E14,
				format.parse("6/8/2012"), 357600);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(awakenings,
				format.parse("24/4/2012"), 528600);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(barneyS1E21,
				format.parse("8/9/2013"), 75600);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(barneyS1E11,
				format.parse("16/8/2013"), 102000);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(
				thesimpsonsS1E10, format.parse("14/11/2013"), 175200);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(
				breakingbadS1E6, format.parse("11/10/2013"), 72600);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(stardust,
				format.parse("19/9/2012"), 228600);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(beingflynn,
				format.parse("27/12/2012"), 430800);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(stanleyiris,
				format.parse("7/8/2013"), 70200);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(barneyS1E6,
				format.parse("5/7/2013"), 97200);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(
				thesimpsonsS1E5, format.parse("23/11/2012"), 169800);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(wagthedog,
				format.parse("9/4/2012"), 372000);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(taxidriver,
				format.parse("28/2/2013"), 399000);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(meanstreets,
				format.parse("11/5/2013"), 121200);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(barneyS1E24,
				format.parse("9/9/2012"), 323400);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(
				theweddingparty, format.parse("2/6/2013"), 525600);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(thelasttycoon,
				format.parse("10/5/2013"), 72600);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(barneyS1E22,
				format.parse("18/9/2013"), 274800);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(thefamily,
				format.parse("16/12/2013"), 477000);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(
				thesimpsonsS1E10, format.parse("24/11/2012"), 342600);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(thefan,
				format.parse("9/4/2012"), 96600);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(borntowin,
				format.parse("1/6/2012"), 298800);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(barneyS1E28,
				format.parse("9/9/2013"), 324000);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(barneyS1E10,
				format.parse("26/3/2013"), 304800);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(borntowin,
				format.parse("9/4/2012"), 250200);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(barneyS1E15,
				format.parse("9/4/2012"), 360000);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(
				thesimpsonsS1E2, format.parse("9/4/2012"), 357000);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(redlights,
				format.parse("17/8/2012"), 247200);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(barneyS1E6,
				format.parse("9/4/2012"), 328200);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(borntowin,
				format.parse("9/4/2012"), 203400);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(barneyS1E16,
				format.parse("7/11/2013"), 301800);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(
				thesimpsonsS1E2, format.parse("12/6/2012"), 303600);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(ragingbull,
				format.parse("17/8/2013"), 201000);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(barneyS1E6,
				format.parse("9/4/2012"), 328200);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(
				greatexpectations, format.parse("10/5/2012"), 125400);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(jacknife,
				format.parse("25/12/2013"), 456600);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(
				theweddingparty, format.parse("9/4/2012"), 354600);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(
				lasedadesdelamor, format.parse("9/4/2012"), 252000);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(
				nightandthecity, format.parse("13/6/2013"), 149400);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(taxidriver,
				format.parse("18/9/2013"), 176400);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(mistress,
				format.parse("23/11/2013"), 203400);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(
				breakingbadS1E4, format.parse("9/4/2012"), 276000);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(barneyS1E6,
				format.parse("9/4/2012"), 328200);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(barneyS1E30,
				format.parse("10/5/2012"), 200400);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(jacknife,
				format.parse("25/7/2013"), 532200);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(
				theweddingparty, format.parse("20/9/2013"), 429600);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(barneyS1E20,
				format.parse("26/12/2013"), 151800);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(
				thesimpsonsS1E7, format.parse("3/6/2012"), 313800);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(stone,
				format.parse("9/4/2012"), 381000);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(
				thesimpsonsS1E8, format.parse("13/6/2013"), 337800);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(machete,
				format.parse("18/9/2012"), 480600);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(capefear,
				format.parse("24/11/2013"), 202800);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(
				breakingbadS1E5, format.parse("9/4/2012"), 276000);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(barneyS1E13,
				format.parse("9/4/2012"), 333600);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(thefan,
				format.parse("11/6/2012"), 200400);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(americanhustle,
				format.parse("5/7/2013"), 402600);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(greetings,
				format.parse("21/10/2013"), 429000);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(barneyS1E21,
				format.parse("26/4/2013"), 151200);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(
				thesimpsonsS1E8, format.parse("13/6/2013"), 224400);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(machete,
				format.parse("18/12/2012"), 251400);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(barneyS1E14,
				format.parse("9/4/2012"), 357600);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(
				arthurandtheinvisibles, format.parse("9/5/2012"), 351000);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(werenoangels,
				format.parse("15/7/2013"), 73200);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(bloodymama,
				format.parse("20/9/2013"), 450600);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(barneyS1E19,
				format.parse("25/12/2013"), 172800);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(
				thesimpsonsS1E5, format.parse("9/4/2012"), 246000);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(ilimitless,
				format.parse("9/4/2012"), 448200);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(maddogandglory,
				format.parse("13/11/2013"), 345600);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(
				breakingbadS1E7, format.parse("22/10/2013"), 340800);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(fallinginlove,
				format.parse("27/12/2012"), 316200);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(
				thesimpsonsS1E13, format.parse("14/7/2013"), 333000);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(
				thegoodshepherd, format.parse("20/9/2013"), 111000);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(barneyS1E17,
				format.parse("25/4/2012"), 147000);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(
				thesimpsonsS1E3, format.parse("9/4/2012"), 228600);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(killerelite,
				format.parse("17/8/2012"), 135600);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(abronxtale,
				format.parse("23/10/2013"), 475800);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(
				breakingbadS1E1, format.parse("9/4/2012"), 244200);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(americanhustle,
				format.parse("15/7/2013"), 446400);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(greetings,
				format.parse("21/10/2013"), 473400);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(barneyS1E21,
				format.parse("26/12/2013"), 357000);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(
				thesimpsonsS1E8, format.parse("9/4/2012"), 337800);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(
				breakingbadS1E4, format.parse("9/4/2012"), 68400);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(frankenstein,
				format.parse("22/10/2013"), 95400);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(thedeerhunter,
				format.parse("9/4/2012"), 472800);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(threewiseguys,
				format.parse("9/4/2012"), 370200);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(taxidriver,
				format.parse("9/4/2012"), 267600);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(frankenstein,
				format.parse("12/6/2012"), 294600);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(ragingbull,
				format.parse("9/4/2012"), 192600);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(barneyS1E7,
				format.parse("9/4/2012"), 336000);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(
				greatexpectations, format.parse("20/5/2012"), 292200);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(barneyS1E20,
				format.parse("8/4/2013"), 189600);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(
				thesimpsonsS1E6, format.parse("9/4/2012"), 349800);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(stone,
				format.parse("9/4/2012"), 465000);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(
				nightandthecity, format.parse("13/6/2013"), 537600);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(machete,
				format.parse("18/3/2013"), 84600);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(
				thesimpsonsS1E3, format.parse("9/4/2012"), 333000);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(newyearseve,
				format.parse("17/8/2013"), 230400);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(barneyS1E19,
				format.parse("25/12/2013"), 303600);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(samssong,
				format.parse("2/2/2013"), 201000);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(killingseason,
				format.parse("26/12/2013"), 98400);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(thefan,
				format.parse("21/10/2012"), 300600);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(brazil,
				format.parse("16/8/2013"), 502800);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(heat,
				format.parse("22/10/2013"), 529800);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(fallinginlove,
				format.parse("27/12/2012"), 427200);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(
				thesimpsonsS1E13, format.parse("9/4/2012"), 333000);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(
				thegoodshepherd, format.parse("20/9/2013"), 93000);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(stanleyiris,
				format.parse("25/11/2013"), 166200);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(
				thesimpsonsS1E3, format.parse("9/4/2012"), 238800);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(barneyS1E12,
				format.parse("9/4/2012"), 312000);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(
				breakingbadS1E6, format.parse("11/6/2012"), 80400);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(brazil,
				format.parse("16/12/2013"), 106800);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(barneyS1E3,
				format.parse("9/4/2012"), 360000);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(barneyS1E26,
				format.parse("9/5/2012"), 207000);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(goodfellas,
				format.parse("14/7/2013"), 409200);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(
				jenniferonmymind, format.parse("20/9/2013"), 481800);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(barneyS1E17,
				format.parse("25/11/2013"), 304200);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(
				thesimpsonsS1E3, format.parse("9/4/2012"), 147600);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(
				nightandthecity, format.parse("23/11/2013"), 220800);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(
				breakingbadS1E4, format.parse("9/4/2012"), 328200);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(thefamily,
				format.parse("9/4/2012"), 366600);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(sleepers,
				format.parse("11/5/2012"), 88800);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(themission,
				format.parse("2/6/2012"), 466200);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(thedeerhunter,
				format.parse("9/4/2012"), 539400);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(americanhustle,
				format.parse("9/4/2012"), 132000);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(jackiebrown,
				format.parse("20/9/2012"), 509400);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(
				dearamericalettershomefromvietnamtvmoviedocumentary,
				format.parse("15/7/2013"), 65400);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(greetings,
				format.parse("3/2/2013"), 442800);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(barneyS1E22,
				format.parse("8/12/2013"), 340800);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(
				thesimpsonsS1E8, format.parse("13/6/2012"), 109200);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(meanstreets,
				format.parse("19/9/2012"), 181800);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(capefear,
				format.parse("14/7/2013"), 79200);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(
				bangthedrumslowly, format.parse("19/9/2013"), 327600);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(barneyS1E13,
				format.parse("6/3/2013"), 333600);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(
				breakingbadS1E7, format.parse("9/4/2012"), 200400);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(freelancers,
				format.parse("17/11/2012"), 273600);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(greetings,
				format.parse("9/4/2012"), 475800);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(machete,
				format.parse("18/4/2012"), 198000);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(mistress,
				format.parse("13/6/2013"), 400200);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(everybodysfine,
				format.parse("9/4/2012"), 297600);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(capefear,
				format.parse("14/7/2013"), 195600);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(
				bangthedrumslowly, format.parse("19/9/2013"), 268200);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(barneyS1E13,
				format.parse("6/3/2013"), 333600);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(
				breakingbadS1E7, format.parse("11/6/2012"), 109200);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(fallinginlove,
				format.parse("17/8/2012"), 182400);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(casino,
				format.parse("22/6/2012"), 384600);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(beingflynn,
				format.parse("17/8/2013"), 457800);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(
				onehundredandonenights, format.parse("22/10/2013"), 225600);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(
				trueconfessions, format.parse("27/12/2013"), 298800);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(barneyS1E24,
				format.parse("19/9/2012"), 196200);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(fallinginlove,
				format.parse("27/6/2012"), 269400);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(
				arthurandtheinvisibles, format.parse("9/4/2012"), 517200);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(barneyS1E29,
				format.parse("20/9/2012"), 348600);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(newyorknewyork,
				format.parse("28/5/2013"), 155400);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(
				lasedadesdelamor, format.parse("28/5/2012"), 449400);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(barneyS1E22,
				format.parse("9/4/2012"), 343200);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(righteouskill,
				format.parse("9/4/2012"), 87000);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(barneyS1E25,
				format.parse("9/4/2012"), 160200);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(barneyS1E27,
				format.parse("9/4/2012"), 232800);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(barneyS1E29,
				format.parse("9/4/2012"), 130800);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(barneyS1E30,
				format.parse("10/9/2012"), 203400);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(
				breakingbadS1E2, format.parse("9/4/2012"), 147000);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(meanstreets,
				format.parse("9/4/2012"), 525000);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(
				breakingbadS1E7, format.parse("22/10/2012"), 340800);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(borntowin,
				format.parse("12/6/2013"), 61200);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(
				arthurandtheinvisibles, format.parse("2/6/2013"), 309600);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(
				greatexpectations, format.parse("2/2/2013"), 382200);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(
				breakingbadS1E1, format.parse("20/9/2012"), 150600);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(taxidriver,
				format.parse("11/5/2013"), 223800);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(everybodysfine,
				format.parse("9/4/2012"), 296400);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(themission,
				format.parse("9/9/2012"), 369600);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(fallinginlove,
				format.parse("27/5/2013"), 442200);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(beingflynn,
				format.parse("17/12/2012"), 515400);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(barneyS1E17,
				format.parse("7/8/2013"), 108600);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(threewiseguys,
				format.parse("25/4/2013"), 181200);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(barneyS1E8,
				format.parse("2/10/2013"), 300000);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(
				thesimpsonsS1E4, format.parse("12/10/2012"), 198000);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(samssong,
				format.parse("2/6/2013"), 270600);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(wagthedog,
				format.parse("3/6/2013"), 519000);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(
				breakingbadS1E4, format.parse("11/10/2013"), 120600);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(meanstreets,
				format.parse("9/4/2012"), 64800);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(barneyS1E25,
				format.parse("19/9/2012"), 275400);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(barneyS1E5,
				format.parse("15/7/2013"), 325800);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(frankenstein,
				format.parse("22/3/2013"), 123000);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(
				thesimpsonsS1E5, format.parse("13/10/2013"), 66600);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(wagthedog,
				format.parse("20/2/2013"), 420000);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(
				breakingbadS1E3, format.parse("21/10/2013"), 325800);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(barneyS1E27,
				format.parse("9/4/2012"), 322200);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(
				thegodfatherpartii, format.parse("13/12/2012"), 259800);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(barneyS1E8,
				format.parse("25/1/2013"), 300000);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(marvinsroom,
				format.parse("24/12/2013"), 276000);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(barneyS1E16,
				format.parse("7/8/2012"), 219600);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(barneyS1E17,
				format.parse("9/4/2012"), 304200);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(encounter,
				format.parse("24/12/2013"), 61200);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(
				thegangthatcouldntshootstraight, format.parse("22/11/2013"),
				180000);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(newyearseve,
				format.parse("10/6/2013"), 298800);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(maddogandglory,
				format.parse("26/9/2013"), 243000);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(sleepers,
				format.parse("14/8/2012"), 315600);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(barneyS1E27,
				format.parse("12/7/2012"), 84000);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(barneyS1E19,
				format.parse("28/9/2013"), 330600);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(
				thesimpsonsS1E8, format.parse("9/4/2012"), 146400);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(
				thegangthatcouldntshootstraight, format.parse("11/7/2012"),
				441000);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(casino,
				format.parse("14/4/2012"), 513600);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(ragingbull,
				format.parse("20/10/2013"), 457800);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(lastvegas,
				format.parse("8/1/2013"), 225600);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(sleepers,
				format.parse("14/8/2012"), 298800);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(barneyS1E27,
				format.parse("2/10/2013"), 242400);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(jacknife,
				format.parse("18/5/2012"), 139800);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(
				threeroomsinmanhattan, format.parse("23/8/2012"), 259200);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(
				whatjusthappened, format.parse("11/2/2013"), 202800);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(goodfellas,
				format.parse("17/9/2012"), 450600);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(samssong,
				format.parse("23/12/2013"), 219000);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(machete,
				format.parse("11/2/2013"), 292200);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(
				guiltybysuspicion, format.parse("27/9/2012"), 235800);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(
				thesimpsonsS1E3, format.parse("15/4/2012"), 358800);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(ilimitless,
				format.parse("10/6/2012"), 298200);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(barneyS1E11,
				format.parse("26/1/2013"), 307200);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(heat,
				format.parse("14/4/2012"), 315000);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(barneyS1E29,
				format.parse("2/9/2012"), 258600);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(
				breakingbadS1E3, format.parse("9/4/2012"), 325800);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(heat,
				format.parse("14/10/2012"), 450600);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(bloodymama,
				format.parse("12/6/2013"), 394200);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(barneyS1E30,
				format.parse("20/2/2013"), 312600);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(
				breakingbadS1E2, format.parse("10/10/2013"), 151800);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(stone,
				format.parse("9/4/2012"), 433800);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(barneyS1E23,
				format.parse("9/4/2012"), 72600);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(barneyS1E27,
				format.parse("9/4/2012"), 141600);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(newyorknewyork,
				format.parse("10/9/2013"), 131400);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(stone,
				format.parse("25/4/2013"), 379200);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(jacknife,
				format.parse("25/4/2013"), 452400);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(barneyS1E9,
				format.parse("15/12/2013"), 220800);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(
				nightandthecity, format.parse("6/3/2013"), 514800);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(
				thesimpsonsS1E9, format.parse("13/11/2012"), 329400);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(thefan,
				format.parse("4/7/2013"), 448200);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(heat,
				format.parse("22/2/2013"), 266400);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(
				thesimpsonsS1E2, format.parse("12/10/2012"), 256200);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(himom,
				format.parse("2/6/2013"), 70200);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(
				greatexpectations, format.parse("20/2/2013"), 493800);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(
				breakingbadS1E2, format.parse("10/5/2013"), 301800);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(stone,
				format.parse("9/4/2012"), 252000);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(barneyS1E13,
				format.parse("24/3/2013"), 195600);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(
				breakingbadS1E7, format.parse("1/7/2013"), 314400);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(
				thesimpsonsS1E8, format.parse("13/6/2013"), 129000);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(machete,
				format.parse("18/9/2012"), 294000);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(capefear,
				format.parse("13/6/2013"), 237600);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(meanstreets,
				format.parse("19/9/2013"), 181200);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(barneyS1E13,
				format.parse("9/4/2012"), 300600);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(thefan,
				format.parse("22/10/2013"), 244200);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(fallinginlove,
				format.parse("27/12/2012"), 363000);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(
				thesimpsonsS1E12, format.parse("14/7/2012"), 177600);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(
				thegoodshepherd, format.parse("19/9/2012"), 296400);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(goodfellas,
				format.parse("25/11/2013"), 64800);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(
				thesimpsonsS1E3, format.parse("12/6/2012"), 358800);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(newyearseve,
				format.parse("17/4/2012"), 173400);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(
				thesimpsonsS1E6, format.parse("21/10/2012"), 349800);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(barneyS1E20,
				format.parse("25/4/2013"), 354600);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(
				thesimpsonsS1E7, format.parse("13/6/2013"), 225600);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(stone,
				format.parse("18/9/2013"), 474000);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(
				nightandthecity, format.parse("23/11/2013"), 288600);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(
				thegodfatherpartii, format.parse("9/4/2012"), 102600);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(thebigwedding,
				format.parse("6/8/2012"), 397200);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(sleepers,
				format.parse("11/5/2013"), 165600);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(
				breakingbadS1E7, format.parse("1/6/2012"), 155400);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(freelancers,
				format.parse("17/8/2013"), 99000);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(barneyS1E4,
				format.parse("22/10/2013"), 323400);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(
				thegoodshepherd, format.parse("9/5/2012"), 124200);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(stanleyiris,
				format.parse("14/7/2013"), 67800);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(himom,
				format.parse("2/2/2013"), 362400);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(beingflynn,
				format.parse("17/8/2013"), 130800);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(barneyS1E4,
				format.parse("22/3/2013"), 74400);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(barneyS1E28,
				format.parse("27/12/2012"), 324000);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(barneyS1E5,
				format.parse("9/4/2012"), 266400);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(
				breakingbadS1E3, format.parse("3/6/2012"), 187800);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(
				billythekidmcdonnen, format.parse("25/11/2012"), 399000);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(barneyS1E7,
				format.parse("15/7/2013"), 231000);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(maddogandglory,
				format.parse("23/3/2013"), 525600);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(
				thesimpsonsS1E8, format.parse("23/11/2012"), 337800);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(encounter,
				format.parse("3/7/2013"), 108000);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(thefan,
				format.parse("9/4/2012"), 532200);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(
				thegangthatcouldntshootstraight, format.parse("12/6/2013"),
				294600);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(
				thegoodshepherd, format.parse("9/4/2012"), 109200);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(ragingbull,
				format.parse("27/5/2013"), 532800);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(
				thekingofcomedy, format.parse("27/12/2012"), 476400);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(barneyS1E17,
				format.parse("7/8/2013"), 304200);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(
				billythekidmcdonnen, format.parse("15/11/2013"), 539400);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(thisboyslife,
				format.parse("9/4/2012"), 483000);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(greetings,
				format.parse("13/6/2013"), 250800);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(copland,
				format.parse("9/4/2012"), 195000);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(
				breakingbadS1E5, format.parse("11/10/2013"), 313800);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(righteouskill,
				format.parse("9/4/2012"), 257400);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(fallinginlove,
				format.parse("9/9/2013"), 201000);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(redlights,
				format.parse("27/12/2012"), 319800);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(barneyS1E17,
				format.parse("7/4/2013"), 263400);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(threewiseguys,
				format.parse("15/12/2013"), 382800);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(thisboyslife,
				format.parse("5/11/2012"), 326400);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(threewiseguys,
				format.parse("25/12/2012"), 445200);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(barneyS1E9,
				format.parse("15/7/2013"), 302400);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(
				nightandthecity, format.parse("23/3/2013"), 304200);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(
				thesimpsonsS1E9, format.parse("24/11/2013"), 118800);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(barneyS1E1,
				format.parse("4/7/2013"), 62400);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(heat,
				format.parse("22/2/2013"), 310800);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(
				thesimpsonsS1E2, format.parse("12/9/2013"), 124800);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(barneyS1E19,
				format.parse("9/4/2012"), 68400);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(thisboyslife,
				format.parse("13/6/2012"), 187800);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(ilimitless,
				format.parse("8/8/2012"), 306600);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(barneyS1E9,
				format.parse("23/11/2013"), 250200);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(everybodysfine,
				format.parse("1/12/2012"), 193800);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(
				thesimpsonsS1E12, format.parse("14/7/2013"), 309000);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(sleepers,
				format.parse("21/10/2012"), 256800);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(barneyS1E25,
				format.parse("26/12/2012"), 200400);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(
				thesimpsonsS1E11, format.parse("4/7/2012"), 344400);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(stardust,
				format.parse("9/9/2013"), 262800);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(awakenings,
				format.parse("24/11/2013"), 511200);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(
				jenniferonmymind, format.parse("19/9/2013"), 325800);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(barneyS1E16,
				format.parse("7/11/2013"), 269400);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(
				thesimpsonsS1E3, format.parse("9/4/2012"), 258600);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(newyearseve,
				format.parse("9/4/2012"), 378000);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(abronxtale,
				format.parse("12/6/2012"), 192000);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(thedeerhunter,
				format.parse("17/1/2013"), 311400);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(americanhustle,
				format.parse("9/4/2012"), 125400);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(jackiebrown,
				format.parse("10/5/2012"), 244800);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(killerelite,
				format.parse("17/8/2012"), 192000);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(newyorknewyork,
				format.parse("9/4/2012"), 181800);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(lastvegas,
				format.parse("15/7/2013"), 300600);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(greetings,
				format.parse("21/10/2013"), 69000);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(barneyS1E22,
				format.parse("26/12/2013"), 187800);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(
				thesimpsonsS1E8, format.parse("9/4/2012"), 337800);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(everybodysfine,
				format.parse("9/4/2012"), 121200);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(capefear,
				format.parse("14/7/2013"), 240000);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(
				bangthedrumslowly, format.parse("9/4/2012"), 534600);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(
				silverliningsplaybook, format.parse("9/4/2012"), 349200);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(heat,
				format.parse("22/10/2012"), 117000);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(fallinginlove,
				format.parse("17/8/2013"), 236400);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(barneyS1E4,
				format.parse("2/6/2012"), 323400);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(
				thesimpsonsS1E7, format.parse("9/4/2012"), 313800);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(
				breakingbadS1E3, format.parse("9/4/2012"), 159000);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(killingseason,
				format.parse("6/7/2012"), 453600);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(marvinsroom,
				format.parse("21/10/2013"), 397200);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(angelheart,
				format.parse("26/12/2013"), 516000);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(
				thesimpsonsS1E10, format.parse("9/4/2012"), 330600);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(righteouskill,
				format.parse("19/9/2013"), 449400);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(
				guiltybysuspicion, format.parse("24/11/2013"), 264000);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(
				thegangthatcouldntshootstraight, format.parse("19/9/2013"),
				253800);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(awakenings,
				format.parse("24/11/2013"), 502200);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(borntowin,
				format.parse("19/9/2013"), 316200);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(barneyS1E16,
				format.parse("27/12/2012"), 259800);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(dragna,
				format.parse("4/7/2012"), 508200);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(extrastvseries,
				format.parse("10/6/2012"), 193200);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(barneyS1E27,
				format.parse("9/5/2012"), 312600);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(stanleyiris,
				format.parse("15/11/2013"), 437400);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(himom,
				format.parse("9/4/2012"), 123000);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(barneyS1E18,
				format.parse("7/4/2013"), 328200);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(
				thesimpsonsS1E4, format.parse("12/6/2012"), 102000);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(ilimitless,
				format.parse("18/8/2013"), 396600);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(barneyS1E8,
				format.parse("23/11/2013"), 300000);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(thelasttycoon,
				format.parse("9/4/2012"), 505200);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(lastvegas,
				format.parse("9/4/2012"), 319800);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(copland,
				format.parse("11/5/2012"), 438600);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(
				theuntouchables, format.parse("16/7/2012"), 253200);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(marvinsroom,
				format.parse("11/5/2012"), 145200);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(angelheart,
				format.parse("16/8/2012"), 264000);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(barneyS1E22,
				format.parse("8/12/2013"), 78600);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(
				thesimpsonsS1E8, format.parse("9/4/2012"), 68400);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(everybodysfine,
				format.parse("9/4/2012"), 187200);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(capefear,
				format.parse("24/11/2013"), 306000);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(
				bangthedrumslowly, format.parse("1/1/2013"), 120600);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(
				silverliningsplaybook, format.parse("9/4/2012"), 110400);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(heat,
				format.parse("22/6/2012"), 534000);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(fallinginlove,
				format.parse("17/12/2013"), 172800);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(barneyS1E4,
				format.parse("9/4/2012"), 323400);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(
				thegoodshepherd, format.parse("9/5/2012"), 106200);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(stanleyiris,
				format.parse("15/7/2013"), 96000);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(himom,
				format.parse("20/9/2013"), 85800);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(barneyS1E18,
				format.parse("25/11/2013"), 204600);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(newyearseve,
				format.parse("17/8/2013"), 499200);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(barneyS1E6,
				format.parse("9/4/2012"), 138000);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(barneyS1E30,
				format.parse("10/5/2012"), 312600);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(jacknife,
				format.parse("25/12/2013"), 201000);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(
				theweddingparty, format.parse("9/4/2012"), 495000);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(barneyS1E20,
				format.parse("9/4/2012"), 354600);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(
				nightandthecity, format.parse("13/6/2013"), 299400);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(taxidriver,
				format.parse("18/9/2013"), 418200);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(barneyS1E11,
				format.parse("23/11/2013"), 307200);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(
				breakingbadS1E4, format.parse("9/4/2012"), 222000);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(barneyS1E12,
				format.parse("24/11/2013"), 331200);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(
				breakingbadS1E5, format.parse("9/4/2012"), 331200);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(
				silverliningsplaybook, format.parse("9/4/2012"), 496200);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(
				breakingbadS1E6, format.parse("9/4/2012"), 354600);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(everybodysfine,
				format.parse("18/9/2013"), 475800);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(capefear,
				format.parse("24/11/2013"), 289800);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(
				breakingbadS1E6, format.parse("9/4/2012"), 354600);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(
				silverliningsplaybook, format.parse("16/8/2013"), 444600);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(heat,
				format.parse("22/10/2013"), 388200);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(barneyS1E26,
				format.parse("27/12/2012"), 202800);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(
				thesimpsonsS1E5, format.parse("9/4/2012"), 347400);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(themission,
				format.parse("16/8/2013"), 182400);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(thefan,
				format.parse("21/10/2013"), 480000);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(brazil,
				format.parse("27/12/2013"), 118800);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(barneyS1E3,
				format.parse("22/10/2013"), 360000);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(barneyS1E26,
				format.parse("9/5/2012"), 228000);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(goodfellas,
				format.parse("9/4/2012"), 171600);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(fallinginlove,
				format.parse("27/12/2012"), 161400);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(
				thesimpsonsS1E13, format.parse("14/7/2013"), 326400);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(
				thegoodshepherd, format.parse("20/9/2013"), 140400);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(jacknife,
				format.parse("8/4/2013"), 259800);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(
				thesimpsonsS1E8, format.parse("9/4/2012"), 337800);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(everybodysfine,
				format.parse("18/9/2013"), 238800);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(capefear,
				format.parse("24/11/2013"), 533400);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(
				breakingbadS1E6, format.parse("1/6/2012"), 354600);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(
				silverliningsplaybook, format.parse("16/8/2012"), 208200);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(heat,
				format.parse("22/10/2012"), 151800);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(fallinginlove,
				format.parse("17/8/2013"), 446400);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(casino,
				format.parse("22/10/2013"), 390000);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(barneyS1E27,
				format.parse("27/12/2012"), 204000);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(borntowin,
				format.parse("19/9/2012"), 498600);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(barneyS1E15,
				format.parse("9/4/2012"), 313200);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(
				thesimpsonsS1E2, format.parse("12/6/2012"), 357000);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(redlights,
				format.parse("17/8/2013"), 292200);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(barneyS1E6,
				format.parse("5/3/2013"), 282000);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(barneyS1E29,
				format.parse("10/5/2012"), 96600);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(jacknife,
				format.parse("15/7/2013"), 520200);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(
				greatexpectations, format.parse("20/9/2012"), 205200);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(midnightrun,
				format.parse("25/12/2013"), 499800);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(
				theweddingparty, format.parse("9/4/2012"), 184800);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(stone,
				format.parse("18/8/2013"), 303600);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(barneyS1E10,
				format.parse("23/11/2013"), 293400);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(
				breakingbadS1E4, format.parse("9/4/2012"), 328200);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(barneyS1E11,
				format.parse("6/12/2013"), 307200);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(barneyS1E12,
				format.parse("9/4/2012"), 262200);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(casino,
				format.parse("22/10/2013"), 381600);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(barneyS1E28,
				format.parse("27/12/2012"), 324000);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(dragna,
				format.parse("9/4/2012"), 309600);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(extrastvseries,
				format.parse("10/5/2012"), 169800);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(werenoangels,
				format.parse("15/11/2013"), 159600);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(bloodymama,
				format.parse("9/4/2012"), 454200);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(barneyS1E19,
				format.parse("7/4/2013"), 139200);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(
				thesimpsonsS1E5, format.parse("13/6/2012"), 304200);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(
				lasedadesdelamor, format.parse("18/4/2012"), 294000);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(maddogandglory,
				format.parse("23/11/2013"), 459000);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(
				breakingbadS1E3, format.parse("28/5/2012"), 144000);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(
				theuntouchables, format.parse("16/5/2013"), 133800);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(stone,
				format.parse("8/4/2013"), 77400);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(mistress,
				format.parse("23/11/2013"), 196200);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(
				thegodfatherpartii, format.parse("9/4/2012"), 537000);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(thebigwedding,
				format.parse("9/4/2012"), 526800);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(sleepers,
				format.parse("11/10/2012"), 165600);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(brazil,
				format.parse("26/11/2013"), 284400);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(jacknife,
				format.parse("9/4/2012"), 403800);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(everybodysfine,
				format.parse("9/4/2012"), 217800);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(
				thesimpsonsS1E9, format.parse("14/7/2013"), 78600);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(
				bangthedrumslowly, format.parse("19/9/2013"), 67800);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(barneyS1E13,
				format.parse("24/3/2013"), 333600);
		hiltonfinancialmgtdpt.getGestor().registrarReproduccion(
				breakingbadS1E7, format.parse("11/6/2012"), 222600);
		hiltonfinancialmgtdpt.setSesion(new Sesion(new Reproduccion(barneyS1E8,
				format.parse("5/1/2014"), 199800), format.parse("5/1/2014")));
		sitio.registrarUsuario(hiltonfinancialmgtdpt);
		Usuario ericolaverdo = new Usuario(format.parse("12/6/1976"),
				"ericolaverdo@yahoo.com", format.parse("13/11/2012"), catalogo);
		ericolaverdo.getSuscripcion().pasarAVIP();
		ericolaverdo.getGestor().registrarReproduccion(thisboyslife,
				format.parse("12/6/2013"), 538800);
		ericolaverdo.getGestor().registrarReproduccion(newyorknewyork,
				format.parse("13/11/2012"), 436200);
		ericolaverdo.getGestor().registrarReproduccion(lastvegas,
				format.parse("3/6/2013"), 158400);
		ericolaverdo.getGestor().registrarReproduccion(encounter,
				format.parse("3/7/2013"), 231600);
		ericolaverdo.getGestor().registrarReproduccion(breakingbadS1E6,
				format.parse("13/11/2012"), 129000);
		ericolaverdo.getGestor().registrarReproduccion(borntowin,
				format.parse("13/11/2012"), 156000);
		ericolaverdo.getGestor().registrarReproduccion(barneyS1E27,
				format.parse("9/9/2013"), 182400);
		ericolaverdo.getGestor().registrarReproduccion(ragingbull,
				format.parse("27/12/2012"), 209400);
		ericolaverdo.getGestor().registrarReproduccion(barneyS1E18,
				format.parse("7/8/2013"), 236400);
		ericolaverdo.getGestor().registrarReproduccion(americanhustle,
				format.parse("25/12/2012"), 263400);
		ericolaverdo.getGestor().registrarReproduccion(nightandthecity,
				format.parse("5/3/2013"), 465600);
		ericolaverdo.getGestor().registrarReproduccion(thesimpsonsS1E8,
				format.parse("13/11/2012"), 337800);
		ericolaverdo.getGestor().registrarReproduccion(thegodfatherpartii,
				format.parse("1/5/2013"), 255000);
		ericolaverdo.getGestor().registrarReproduccion(righteouskill,
				format.parse("13/11/2012"), 457200);
		ericolaverdo.getGestor().registrarReproduccion(brazil,
				format.parse("13/11/2012"), 309000);
		ericolaverdo.getGestor().registrarReproduccion(barneyS1E15,
				format.parse("13/11/2012"), 336000);
		ericolaverdo.getGestor().registrarReproduccion(goodfellas,
				format.parse("25/4/2013"), 187200);
		ericolaverdo.getGestor().registrarReproduccion(billythekidmcdonnen,
				format.parse("15/11/2012"), 84600);
		ericolaverdo.getGestor().registrarReproduccion(barneyS1E8,
				format.parse("5/7/2013"), 111600);
		ericolaverdo.getGestor().registrarReproduccion(thesimpsonsS1E6,
				format.parse("23/11/2012"), 349800);
		ericolaverdo.getGestor().registrarReproduccion(threeroomsinmanhattan,
				format.parse("3/6/2013"), 387000);
		ericolaverdo.getGestor().registrarReproduccion(marvinsroom,
				format.parse("13/11/2012"), 413400);
		ericolaverdo.getGestor().registrarReproduccion(bangthedrumslowly,
				format.parse("11/6/2013"), 135600);
		ericolaverdo.getGestor().registrarReproduccion(stardust,
				format.parse("13/11/2012"), 467400);
		ericolaverdo.getGestor().registrarReproduccion(thekingofcomedy,
				format.parse("27/12/2012"), 189600);
		ericolaverdo.getGestor().registrarReproduccion(stanleyiris,
				format.parse("13/11/2012"), 87000);
		ericolaverdo.getGestor().registrarReproduccion(thesimpsonsS1E3,
				format.parse("13/11/2012"), 358800);
		ericolaverdo.getGestor().registrarReproduccion(thesimpsonsS1E4,
				format.parse("12/10/2013"), 323400);
		ericolaverdo.getGestor().registrarReproduccion(jackiebrown,
				format.parse("3/2/2013"), 388800);
		ericolaverdo.getGestor().registrarReproduccion(breakingbadS1E3,
				format.parse("10/10/2013"), 325800);
		ericolaverdo.getGestor().registrarReproduccion(thegodfatherpartii,
				format.parse("13/11/2012"), 359400);
		ericolaverdo.getGestor().registrarReproduccion(barneyS1E24,
				format.parse("6/8/2013"), 331200);
		ericolaverdo.getGestor().registrarReproduccion(barneyS1E4,
				format.parse("22/10/2013"), 108600);
		ericolaverdo.getGestor().registrarReproduccion(barneyS1E27,
				format.parse("13/11/2012"), 135600);
		ericolaverdo.getGestor().registrarReproduccion(stanleyiris,
				format.parse("14/7/2013"), 337800);
		ericolaverdo.getGestor().registrarReproduccion(himom,
				format.parse("2/9/2013"), 235200);
		ericolaverdo.getGestor().registrarReproduccion(barneyS1E18,
				format.parse("25/11/2013"), 328200);
		ericolaverdo.getGestor().registrarReproduccion(bloodymama,
				format.parse("13/11/2012"), 464400);
		ericolaverdo.getGestor().registrarReproduccion(killerelite,
				format.parse("13/11/2012"), 491400);
		ericolaverdo.getGestor().registrarReproduccion(bloodymama,
				format.parse("13/11/2012"), 517800);
		ericolaverdo.getGestor().registrarReproduccion(ilimitless,
				format.parse("13/11/2012"), 240000);
		ericolaverdo.getGestor().registrarReproduccion(barneyS1E8,
				format.parse("13/11/2012"), 267000);
		ericolaverdo.getGestor().registrarReproduccion(wagthedog,
				format.parse("21/10/2013"), 469200);
		ericolaverdo.getGestor().registrarReproduccion(
				dearamericalettershomefromvietnamtvmoviedocumentary,
				format.parse("26/12/2013"), 154200);
		ericolaverdo.getGestor().registrarReproduccion(thesimpsonsS1E8,
				format.parse("13/11/2012"), 337800);
		ericolaverdo.getGestor().registrarReproduccion(machete,
				format.parse("13/11/2012"), 78600);
		ericolaverdo.getGestor().registrarReproduccion(capefear,
				format.parse("13/6/2013"), 280800);
		ericolaverdo.getGestor().registrarReproduccion(meanstreets,
				format.parse("13/11/2012"), 307800);
		ericolaverdo.getGestor().registrarReproduccion(barneyS1E13,
				format.parse("13/11/2012"), 333600);
		ericolaverdo.getGestor().registrarReproduccion(breakingbadS1E6,
				format.parse("13/11/2012"), 354600);
		ericolaverdo.getGestor().registrarReproduccion(fallinginlove,
				format.parse("27/8/2013"), 129600);
		ericolaverdo.getGestor().registrarReproduccion(barneyS1E3,
				format.parse("13/11/2012"), 331800);
		ericolaverdo.getGestor().registrarReproduccion(barneyS1E14,
				format.parse("13/11/2012"), 357600);
		ericolaverdo.getGestor().registrarReproduccion(heat,
				format.parse("13/11/2012"), 210000);
		ericolaverdo.getGestor().registrarReproduccion(thekingofcomedy,
				format.parse("17/12/2013"), 412200);
		ericolaverdo.getGestor().registrarReproduccion(barneyS1E4,
				format.parse("4/10/2013"), 134400);
		ericolaverdo.getGestor().registrarReproduccion(barneyS1E28,
				format.parse("9/12/2012"), 324000);
		ericolaverdo.getGestor().registrarReproduccion(dragna,
				format.parse("15/7/2013"), 188400);
		ericolaverdo.getGestor().registrarReproduccion(barneyS1E7,
				format.parse("5/3/2013"), 336000);
		ericolaverdo.getGestor().registrarReproduccion(jackiebrown,
				format.parse("13/11/2012"), 112800);
		ericolaverdo.getGestor().registrarReproduccion(midnightrun,
				format.parse("25/12/2013"), 139800);
		ericolaverdo.getGestor().registrarReproduccion(thesimpsonsS1E7,
				format.parse("13/11/2012"), 313800);
		ericolaverdo.getGestor().registrarReproduccion(barneyS1E21,
				format.parse("13/11/2012"), 239400);
		ericolaverdo.getGestor().registrarReproduccion(mistress,
				format.parse("13/6/2013"), 90600);
		ericolaverdo.getGestor().registrarReproduccion(thegodfatherpartii,
				format.parse("18/9/2013"), 288000);
		ericolaverdo.getGestor().registrarReproduccion(barneyS1E11,
				format.parse("13/11/2012"), 307200);
		ericolaverdo.getGestor().registrarReproduccion(marvinsroom,
				format.parse("13/11/2012"), 212400);
		ericolaverdo.getGestor().registrarReproduccion(themission,
				format.parse("16/8/2013"), 414600);
		ericolaverdo.getGestor().registrarReproduccion(barneyS1E1,
				format.parse("21/10/2013"), 136800);
		ericolaverdo.getGestor().registrarReproduccion(newyearseve,
				format.parse("13/11/2012"), 514200);
		ericolaverdo.getGestor().registrarReproduccion(encounter,
				format.parse("21/10/2013"), 365400);
		ericolaverdo.getGestor().registrarReproduccion(barneyS1E23,
				format.parse("26/12/2013"), 87600);
		ericolaverdo.getGestor().registrarReproduccion(barneyS1E1,
				format.parse("21/10/2013"), 289800);
		ericolaverdo.getGestor().registrarReproduccion(barneyS1E24,
				format.parse("26/12/2013"), 316800);
		ericolaverdo.getGestor().registrarReproduccion(thesimpsonsS1E11,
				format.parse("13/11/2012"), 344400);
		ericolaverdo.getGestor().registrarReproduccion(whatjusthappened,
				format.parse("13/11/2012"), 112200);
		ericolaverdo.getGestor().registrarReproduccion(awakenings,
				format.parse("14/7/2013"), 138600);
		ericolaverdo.getGestor().registrarReproduccion(borntowin,
				format.parse("13/11/2012"), 340800);
		ericolaverdo.getGestor().registrarReproduccion(barneyS1E16,
				format.parse("12/2/2013"), 238800);
		ericolaverdo.getGestor().registrarReproduccion(thefamily,
				format.parse("16/8/2013"), 441000);
		ericolaverdo.getGestor().registrarReproduccion(barneyS1E1,
				format.parse("13/11/2012"), 333600);
		ericolaverdo.getGestor().registrarReproduccion(
				thegangthatcouldntshootstraight, format.parse("1/1/2013"),
				411600);
		ericolaverdo.getGestor().registrarReproduccion(barneyS1E14,
				format.parse("6/3/2013"), 133800);
		ericolaverdo.getGestor().registrarReproduccion(breakingbadS1E7,
				format.parse("13/11/2012"), 206400);
		ericolaverdo.getGestor().registrarReproduccion(thekingofcomedy,
				format.parse("17/8/2013"), 279600);
		ericolaverdo.getGestor().registrarReproduccion(casino,
				format.parse("22/10/2013"), 130800);
		ericolaverdo.getGestor().registrarReproduccion(trueconfessions,
				format.parse("17/12/2013"), 333000);
		ericolaverdo.getGestor().registrarReproduccion(barneyS1E5,
				format.parse("4/10/2013"), 230400);
		ericolaverdo.getGestor().registrarReproduccion(barneyS1E29,
				format.parse("27/12/2012"), 348600);
		ericolaverdo.getGestor().registrarReproduccion(barneyS1E6,
				format.parse("13/11/2012"), 154800);
		ericolaverdo.getGestor().registrarReproduccion(greatexpectations,
				format.parse("13/11/2012"), 495600);
		ericolaverdo.getGestor().registrarReproduccion(jacknife,
				format.parse("15/12/2012"), 180600);
		ericolaverdo.getGestor().registrarReproduccion(barneyS1E8,
				format.parse("13/11/2012"), 300000);
		ericolaverdo.getGestor().registrarReproduccion(wagthedog,
				format.parse("13/11/2012"), 280200);
		ericolaverdo.getGestor().registrarReproduccion(
				dearamericalettershomefromvietnamtvmoviedocumentary,
				format.parse("26/12/2013"), 141000);
		ericolaverdo.getGestor().registrarReproduccion(threeroomsinmanhattan,
				format.parse("13/11/2012"), 518400);
		ericolaverdo.getGestor().registrarReproduccion(machete,
				format.parse("13/11/2012"), 65400);
		ericolaverdo.getGestor().registrarReproduccion(capefear,
				format.parse("13/6/2013"), 267600);
		ericolaverdo.getGestor().registrarReproduccion(everybodysfine,
				format.parse("19/4/2013"), 165000);
		ericolaverdo.getGestor().registrarReproduccion(backdraft,
				format.parse("24/11/2013"), 192000);
		ericolaverdo.getGestor().registrarReproduccion(bangthedrumslowly,
				format.parse("19/1/2013"), 89400);
		ericolaverdo.getGestor().registrarReproduccion(guiltybysuspicion,
				format.parse("24/11/2013"), 466800);
		ericolaverdo.getGestor().registrarReproduccion(breakingbadS1E7,
				format.parse("13/11/2012"), 340800);
		ericolaverdo.getGestor().registrarReproduccion(beingflynn,
				format.parse("13/11/2012"), 437400);
		ericolaverdo.getGestor().registrarReproduccion(casino,
				format.parse("22/10/2013"), 464400);
		ericolaverdo.getGestor().registrarReproduccion(thesimpsonsS1E2,
				format.parse("13/11/2012"), 357000);
		ericolaverdo.getGestor().registrarReproduccion(newyearseve,
				format.parse("17/8/2013"), 435000);
		ericolaverdo.getGestor().registrarReproduccion(barneyS1E6,
				format.parse("22/10/2013"), 328200);
		ericolaverdo.getGestor().registrarReproduccion(thedeerhunter,
				format.parse("28/1/2013"), 229800);
		ericolaverdo.getGestor().registrarReproduccion(barneyS1E7,
				format.parse("23/10/2013"), 127200);
		ericolaverdo.getGestor().registrarReproduccion(breakingbadS1E1,
				format.parse("13/11/2012"), 337800);
		ericolaverdo.getGestor().registrarReproduccion(americanhustle,
				format.parse("13/11/2012"), 97800);
		ericolaverdo.getGestor().registrarReproduccion(breakingbadS1E2,
				format.parse("13/11/2012"), 171000);
		ericolaverdo.getGestor().registrarReproduccion(lastvegas,
				format.parse("15/7/2013"), 68400);
		ericolaverdo.getGestor().registrarReproduccion(copland,
				format.parse("21/10/2013"), 270600);
		ericolaverdo.getGestor().registrarReproduccion(barneyS1E22,
				format.parse("26/12/2013"), 168000);
		ericolaverdo.getGestor().registrarReproduccion(thesimpsonsS1E9,
				format.parse("13/11/2012"), 340200);
		ericolaverdo.getGestor().registrarReproduccion(meanstreets,
				format.parse("19/9/2013"), 308400);
		ericolaverdo.getGestor().registrarReproduccion(encounter,
				format.parse("13/11/2012"), 335400);
		ericolaverdo.getGestor().registrarReproduccion(everybodysfine,
				format.parse("13/11/2012"), 232800);
		ericolaverdo.getGestor().registrarReproduccion(backdraft,
				format.parse("24/11/2013"), 259800);
		ericolaverdo.getGestor().registrarReproduccion(breakingbadS1E6,
				format.parse("13/11/2012"), 333000);
		ericolaverdo.getGestor().registrarReproduccion(freelancers,
				format.parse("13/11/2012"), 230400);
		ericolaverdo.getGestor().registrarReproduccion(heat,
				format.parse("13/11/2012"), 257400);
		ericolaverdo.getGestor().registrarReproduccion(beingflynn,
				format.parse("13/11/2012"), 154800);
		ericolaverdo.getGestor().registrarReproduccion(casino,
				format.parse("13/11/2012"), 181800);
		ericolaverdo.getGestor().registrarReproduccion(trueconfessions,
				format.parse("27/12/2012"), 79200);
		ericolaverdo.getGestor().registrarReproduccion(dragna,
				format.parse("13/11/2012"), 106200);
		ericolaverdo.getGestor().registrarReproduccion(extrastvseries,
				format.parse("10/5/2013"), 354600);
		ericolaverdo.getGestor().registrarReproduccion(werenoangels,
				format.parse("25/11/2013"), 252000);
		ericolaverdo.getGestor().registrarReproduccion(thesimpsonsS1E5,
				format.parse("13/11/2012"), 347400);
		ericolaverdo.getGestor().registrarReproduccion(ilimitless,
				format.parse("3/6/2013"), 397800);
		ericolaverdo.getGestor().registrarReproduccion(breakingbadS1E5,
				format.parse("13/11/2012"), 352200);
		ericolaverdo.getGestor().registrarReproduccion(thebigwedding,
				format.parse("13/11/2012"), 63600);
		ericolaverdo.getGestor().registrarReproduccion(thefan,
				format.parse("21/10/2013"), 265800);
		ericolaverdo.getGestor().registrarReproduccion(brazil,
				format.parse("27/12/2012"), 468000);
		ericolaverdo.getGestor().registrarReproduccion(thesimpsonsS1E12,
				format.parse("13/11/2012"), 61200);
		ericolaverdo.getGestor().registrarReproduccion(stardust,
				format.parse("19/9/2013"), 87600);
		ericolaverdo.getGestor().registrarReproduccion(barneyS1E16,
				format.parse("24/11/2013"), 301800);
		ericolaverdo.getGestor().registrarReproduccion(thesimpsonsS1E2,
				format.parse("13/11/2012"), 357000);
		ericolaverdo.getGestor().registrarReproduccion(barneyS1E17,
				format.parse("13/11/2012"), 304200);
		ericolaverdo.getGestor().registrarReproduccion(thesimpsonsS1E3,
				format.parse("13/11/2012"), 204000);
		ericolaverdo.getGestor().registrarReproduccion(thedeerhunter,
				format.parse("2/6/2013"), 102000);
		ericolaverdo.getGestor().registrarReproduccion(newyorknewyork,
				format.parse("18/8/2013"), 349800);
		ericolaverdo.getGestor().registrarReproduccion(maddogandglory,
				format.parse("23/11/2013"), 247800);
		ericolaverdo.getGestor().registrarReproduccion(greetings,
				format.parse("3/2/2013"), 450000);
		ericolaverdo.getGestor().registrarReproduccion(barneyS1E21,
				format.parse("26/4/2013"), 347400);
		ericolaverdo.getGestor().registrarReproduccion(thesimpsonsS1E8,
				format.parse("13/11/2012"), 337800);
		ericolaverdo.getGestor().registrarReproduccion(machete,
				format.parse("13/11/2012"), 142200);
		ericolaverdo.getGestor().registrarReproduccion(capefear,
				format.parse("24/11/2013"), 520200);
		ericolaverdo.getGestor().registrarReproduccion(meanstreets,
				format.parse("1/1/2013"), 417600);
		ericolaverdo.getGestor().registrarReproduccion(barneyS1E12,
				format.parse("6/3/2013"), 331200);
		ericolaverdo.getGestor().registrarReproduccion(breakingbadS1E6,
				format.parse("13/11/2012"), 258600);
		ericolaverdo.getGestor().registrarReproduccion(silverliningsplaybook,
				format.parse("13/11/2012"), 331800);
		ericolaverdo.getGestor().registrarReproduccion(heat,
				format.parse("22/10/2013"), 358800);
		ericolaverdo.getGestor().registrarReproduccion(ragingbull,
				format.parse("25/12/2013"), 256200);
		ericolaverdo.getGestor().registrarReproduccion(thesimpsonsS1E6,
				format.parse("13/6/2013"), 349800);
		ericolaverdo.getGestor().registrarReproduccion(thelasttycoon,
				format.parse("18/8/2013"), 402000);
		ericolaverdo.getGestor().registrarReproduccion(barneyS1E21,
				format.parse("13/11/2012"), 299400);
		ericolaverdo.getGestor().registrarReproduccion(mistress,
				format.parse("13/6/2013"), 501600);
		ericolaverdo.getGestor().registrarReproduccion(machete,
				format.parse("13/11/2012"), 223800);
		ericolaverdo.getGestor().registrarReproduccion(themission,
				format.parse("26/12/2013"), 426000);
		ericolaverdo.getGestor().registrarReproduccion(barneyS1E1,
				format.parse("13/11/2012"), 333600);
		ericolaverdo.getGestor().registrarReproduccion(whatjusthappened,
				format.parse("13/11/2012"), 396600);
		ericolaverdo.getGestor().registrarReproduccion(guiltybysuspicion,
				format.parse("24/11/2013"), 469800);
		ericolaverdo.getGestor().registrarReproduccion(borntowin,
				format.parse("13/11/2012"), 62400);
		ericolaverdo.getGestor().registrarReproduccion(beingflynn,
				format.parse("13/11/2012"), 135600);
		ericolaverdo.getGestor().registrarReproduccion(onehundredandonenights,
				format.parse("12/9/2013"), 208200);
		ericolaverdo.getGestor().registrarReproduccion(
				dearamericalettershomefromvietnamtvmoviedocumentary,
				format.parse("15/7/2013"), 285000);
		ericolaverdo.getGestor().registrarReproduccion(greetings,
				format.parse("21/10/2013"), 487200);
		ericolaverdo.getGestor().registrarReproduccion(barneyS1E22,
				format.parse("26/12/2013"), 343200);
		ericolaverdo.getGestor().registrarReproduccion(thesimpsonsS1E8,
				format.parse("13/11/2012"), 153000);
		ericolaverdo.getGestor().registrarReproduccion(thegodfatherpartii,
				format.parse("13/11/2012"), 401400);
		ericolaverdo.getGestor().registrarReproduccion(barneyS1E11,
				format.parse("13/11/2012"), 307200);
		ericolaverdo.getGestor().registrarReproduccion(breakingbadS1E5,
				format.parse("13/11/2012"), 242400);
		ericolaverdo.getGestor().registrarReproduccion(themission,
				format.parse("26/12/2012"), 139800);
		ericolaverdo.getGestor().registrarReproduccion(thesimpsonsS1E11,
				format.parse("13/11/2012"), 344400);
		ericolaverdo.getGestor().registrarReproduccion(whatjusthappened,
				format.parse("19/9/2013"), 461400);
		ericolaverdo.getGestor().registrarReproduccion(barneyS1E15,
				format.parse("24/11/2013"), 360000);
		ericolaverdo.getGestor().registrarReproduccion(borntowin,
				format.parse("13/11/2012"), 431400);
		ericolaverdo.getGestor().registrarReproduccion(redlights,
				format.parse("13/11/2012"), 504600);
		ericolaverdo.getGestor().registrarReproduccion(onehundredandonenights,
				format.parse("13/11/2012"), 97800);
		ericolaverdo.getGestor().registrarReproduccion(ragingbull,
				format.parse("27/12/2012"), 170400);
		ericolaverdo.getGestor().registrarReproduccion(billythekidmcdonnen,
				format.parse("13/11/2012"), 243600);
		ericolaverdo.getGestor().registrarReproduccion(greatexpectations,
				format.parse("10/9/2013"), 316200);
		ericolaverdo.getGestor().registrarReproduccion(newyorknewyork,
				format.parse("13/11/2012"), 84600);
		ericolaverdo.getGestor().registrarReproduccion(americanhustle,
				format.parse("5/3/2013"), 333000);
		ericolaverdo.getGestor().registrarReproduccion(wagthedog,
				format.parse("13/11/2012"), 230400);
		ericolaverdo.getGestor().registrarReproduccion(
				dearamericalettershomefromvietnamtvmoviedocumentary,
				format.parse("16/7/2013"), 266400);
		ericolaverdo.getGestor().registrarReproduccion(threeroomsinmanhattan,
				format.parse("3/2/2013"), 514200);
		ericolaverdo.getGestor().registrarReproduccion(barneyS1E22,
				format.parse("26/4/2013"), 107400);
		ericolaverdo.getGestor().registrarReproduccion(thesimpsonsS1E9,
				format.parse("13/6/2013"), 340200);
		ericolaverdo.getGestor().registrarReproduccion(meanstreets,
				format.parse("13/11/2012"), 253200);
		ericolaverdo.getGestor().registrarReproduccion(barneyS1E13,
				format.parse("13/11/2012"), 326400);
		ericolaverdo.getGestor().registrarReproduccion(breakingbadS1E6,
				format.parse("13/11/2012"), 94200);
		ericolaverdo.getGestor().registrarReproduccion(freelancers,
				format.parse("17/8/2013"), 167400);
		ericolaverdo.getGestor().registrarReproduccion(barneyS1E3,
				format.parse("13/11/2012"), 64800);
		ericolaverdo.getGestor().registrarReproduccion(barneyS1E27,
				format.parse("9/12/2012"), 138000);
		ericolaverdo.getGestor().registrarReproduccion(barneyS1E28,
				format.parse("13/11/2012"), 324000);
		ericolaverdo.getGestor().registrarReproduccion(stanleyiris,
				format.parse("25/11/2013"), 283800);
		ericolaverdo.getGestor().registrarReproduccion(thesimpsonsS1E4,
				format.parse("13/11/2012"), 227400);
		ericolaverdo.getGestor().registrarReproduccion(killerelite,
				format.parse("13/11/2012"), 300000);
		ericolaverdo.getGestor().registrarReproduccion(thisboyslife,
				format.parse("13/6/2013"), 373200);
		ericolaverdo.getGestor().registrarReproduccion(newyorknewyork,
				format.parse("28/8/2013"), 316800);
		ericolaverdo.getGestor().registrarReproduccion(barneyS1E9,
				format.parse("13/11/2012"), 302400);
		ericolaverdo.getGestor().registrarReproduccion(wagthedog,
				format.parse("13/11/2012"), 462600);
		ericolaverdo.getGestor().registrarReproduccion(theuntouchables,
				format.parse("26/12/2013"), 535800);
		ericolaverdo.getGestor().registrarReproduccion(threeroomsinmanhattan,
				format.parse("13/11/2012"), 303600);
		ericolaverdo.getGestor().registrarReproduccion(barneyS1E23,
				format.parse("13/11/2012"), 72000);
		ericolaverdo.getGestor().registrarReproduccion(thesimpsonsS1E9,
				format.parse("14/7/2013"), 320400);
		ericolaverdo.getGestor().registrarReproduccion(righteouskill,
				format.parse("19/9/2013"), 393600);
		ericolaverdo.getGestor().registrarReproduccion(
				thegangthatcouldntshootstraight, format.parse("13/11/2012"),
				337200);
		ericolaverdo.getGestor().registrarReproduccion(freelancers,
				format.parse("13/11/2012"), 409800);
		ericolaverdo.getGestor().registrarReproduccion(casino,
				format.parse("13/11/2012"), 307800);
		ericolaverdo.getGestor().registrarReproduccion(thekingofcomedy,
				format.parse("27/12/2012"), 75600);
		ericolaverdo.getGestor().registrarReproduccion(dragna,
				format.parse("13/11/2012"), 277800);
		ericolaverdo.getGestor().registrarReproduccion(arthurandtheinvisibles,
				format.parse("13/11/2012"), 526200);
		ericolaverdo.getGestor().registrarReproduccion(werenoangels,
				format.parse("15/7/2013"), 119400);
		ericolaverdo.getGestor().registrarReproduccion(extrastvseries,
				format.parse("20/9/2013"), 63000);
		ericolaverdo.getGestor().registrarReproduccion(barneyS1E19,
				format.parse("25/11/2012"), 135600);
		ericolaverdo.getGestor().registrarReproduccion(meanstreets,
				format.parse("1/1/2013"), 414600);
		ericolaverdo.getGestor().registrarReproduccion(barneyS1E12,
				format.parse("13/11/2012"), 183000);
		ericolaverdo.getGestor().registrarReproduccion(breakingbadS1E6,
				format.parse("13/11/2012"), 354600);
		ericolaverdo.getGestor().registrarReproduccion(brazil,
				format.parse("16/8/2013"), 328800);
		ericolaverdo.getGestor().registrarReproduccion(barneyS1E3,
				format.parse("24/3/2013"), 360000);
		ericolaverdo.getGestor().registrarReproduccion(casino,
				format.parse("22/10/2013"), 299400);
		ericolaverdo.getGestor().registrarReproduccion(onehundredandonenights,
				format.parse("13/11/2012"), 243000);
		ericolaverdo.getGestor().registrarReproduccion(ragingbull,
				format.parse("27/12/2012"), 315600);
		ericolaverdo.getGestor().registrarReproduccion(billythekidmcdonnen,
				format.parse("13/11/2012"), 84000);
		ericolaverdo.getGestor().registrarReproduccion(greatexpectations,
				format.parse("20/9/2013"), 332400);
		ericolaverdo.getGestor().registrarReproduccion(barneyS1E19,
				format.parse("8/4/2013"), 330600);
		ericolaverdo.getGestor().registrarReproduccion(thesimpsonsS1E6,
				format.parse("13/11/2012"), 182400);
		ericolaverdo.getGestor().registrarReproduccion(lasedadesdelamor,
				format.parse("13/11/2012"), 88800);
		ericolaverdo.getGestor().registrarReproduccion(nightandthecity,
				format.parse("13/6/2013"), 337200);
		ericolaverdo.getGestor().registrarReproduccion(taxidriver,
				format.parse("18/9/2013"), 105600);
		ericolaverdo.getGestor().registrarReproduccion(barneyS1E11,
				format.parse("23/11/2013"), 178200);
		ericolaverdo.getGestor().registrarReproduccion(thegodfatherpartii,
				format.parse("1/1/2013"), 121800);
		ericolaverdo.getGestor().registrarReproduccion(barneyS1E12,
				format.parse("13/11/2012"), 331200);
		ericolaverdo.getGestor().registrarReproduccion(brazil,
				format.parse("27/12/2012"), 92400);
		ericolaverdo.getGestor().registrarReproduccion(thesimpsonsS1E11,
				format.parse("13/11/2012"), 344400);
		ericolaverdo.getGestor().registrarReproduccion(stardust,
				format.parse("13/11/2012"), 414000);
		ericolaverdo.getGestor().registrarReproduccion(awakenings,
				format.parse("24/11/2013"), 311400);
		ericolaverdo.getGestor().registrarReproduccion(jenniferonmymind,
				format.parse("13/11/2012"), 79800);
		ericolaverdo.getGestor().registrarReproduccion(barneyS1E16,
				format.parse("7/4/2013"), 301800);
		ericolaverdo.getGestor().registrarReproduccion(thesimpsonsS1E3,
				format.parse("13/11/2012"), 271800);
		ericolaverdo.getGestor().registrarReproduccion(newyearseve,
				format.parse("13/11/2012"), 519600);
		ericolaverdo.getGestor().registrarReproduccion(thesimpsonsS1E4,
				format.parse("13/11/2012"), 323400);
		ericolaverdo.getGestor().registrarReproduccion(angelheart,
				format.parse("27/5/2013"), 231600);
		ericolaverdo.getGestor().registrarReproduccion(onehundredandonenights,
				format.parse("12/10/2013"), 351000);
		ericolaverdo.getGestor().registrarReproduccion(trueconfessions,
				format.parse("27/12/2012"), 423600);
		ericolaverdo.getGestor().registrarReproduccion(barneyS1E6,
				format.parse("5/3/2013"), 328200);
		ericolaverdo.getGestor().registrarReproduccion(newyorknewyork,
				format.parse("13/11/2012"), 310800);
		ericolaverdo.getGestor().registrarReproduccion(lastvegas,
				format.parse("15/7/2013"), 79200);
		ericolaverdo.getGestor().registrarReproduccion(wagthedog,
				format.parse("21/10/2013"), 327600);
		ericolaverdo.getGestor().registrarReproduccion(barneyS1E22,
				format.parse("26/12/2013"), 96000);
		ericolaverdo.getGestor().registrarReproduccion(thesimpsonsS1E8,
				format.parse("13/11/2012"), 337800);
		ericolaverdo.getGestor().registrarReproduccion(barneyS1E23,
				format.parse("13/11/2012"), 204600);
		ericolaverdo.getGestor().registrarReproduccion(capefear,
				format.parse("13/7/2013"), 453000);
		ericolaverdo.getGestor().registrarReproduccion(bangthedrumslowly,
				format.parse("19/9/2013"), 220800);
		ericolaverdo.getGestor().registrarReproduccion(barneyS1E13,
				format.parse("13/11/2012"), 333600);
		ericolaverdo.getGestor().registrarReproduccion(breakingbadS1E7,
				format.parse("13/11/2012"), 340800);
		ericolaverdo.getGestor().registrarReproduccion(freelancers,
				format.parse("17/8/2013"), 181200);
		ericolaverdo.getGestor().registrarReproduccion(barneyS1E4,
				format.parse("13/11/2012"), 323400);
		ericolaverdo.getGestor().registrarReproduccion(barneyS1E27,
				format.parse("13/11/2012"), 286200);
		ericolaverdo.getGestor().registrarReproduccion(barneyS1E6,
				format.parse("13/11/2012"), 229800);
		ericolaverdo.getGestor().registrarReproduccion(greatexpectations,
				format.parse("10/5/2013"), 348600);
		ericolaverdo.getGestor().registrarReproduccion(jacknife,
				format.parse("25/12/2013"), 421800);
		ericolaverdo.getGestor().registrarReproduccion(theweddingparty,
				format.parse("13/11/2012"), 189600);
		ericolaverdo.getGestor().registrarReproduccion(barneyS1E20,
				format.parse("25/12/2013"), 211200);
		ericolaverdo.getGestor().registrarReproduccion(thesimpsonsS1E7,
				format.parse("13/11/2012"), 313800);
		ericolaverdo.getGestor().registrarReproduccion(stone,
				format.parse("18/9/2013"), 403200);
		ericolaverdo.getGestor().registrarReproduccion(mistress,
				format.parse("13/11/2012"), 300600);
		ericolaverdo.getGestor().registrarReproduccion(thekingofcomedy,
				format.parse("27/12/2013"), 244200);
		ericolaverdo.getGestor().registrarReproduccion(barneyS1E4,
				format.parse("13/11/2012"), 323400);
		ericolaverdo.getGestor().registrarReproduccion(arthurandtheinvisibles,
				format.parse("13/11/2012"), 436200);
		ericolaverdo.getGestor().registrarReproduccion(barneyS1E17,
				format.parse("25/11/2013"), 204600);
		ericolaverdo.getGestor().registrarReproduccion(thesimpsonsS1E4,
				format.parse("13/11/2012"), 323400);
		ericolaverdo.getGestor().registrarReproduccion(killerelite,
				format.parse("13/11/2012"), 91800);
		ericolaverdo.getGestor().registrarReproduccion(theweddingparty,
				format.parse("20/9/2013"), 515400);
		ericolaverdo.getGestor().registrarReproduccion(barneyS1E21,
				format.parse("26/4/2013"), 283800);
		ericolaverdo.getGestor().registrarReproduccion(thesimpsonsS1E7,
				format.parse("13/11/2012"), 313800);
		ericolaverdo.getGestor().registrarReproduccion(machete,
				format.parse("18/9/2013"), 475800);
		ericolaverdo.getGestor().registrarReproduccion(mistress,
				format.parse("24/6/2013"), 373200);
		ericolaverdo.getGestor().registrarReproduccion(meanstreets,
				format.parse("13/11/2012"), 316800);
		ericolaverdo.getGestor().registrarReproduccion(barneyS1E12,
				format.parse("13/11/2012"), 85200);
		ericolaverdo.getGestor().registrarReproduccion(thefan,
				format.parse("13/11/2012"), 333600);
		ericolaverdo.getGestor().registrarReproduccion(brazil,
				format.parse("16/8/2013"), 406200);
		ericolaverdo.getGestor().registrarReproduccion(heat,
				format.parse("22/10/2013"), 304200);
		ericolaverdo.getGestor().registrarReproduccion(fallinginlove,
				format.parse("27/12/2012"), 247800);
		ericolaverdo.getGestor().registrarReproduccion(barneyS1E4,
				format.parse("13/11/2012"), 323400);
		ericolaverdo.getGestor().registrarReproduccion(thegoodshepherd,
				format.parse("13/11/2012"), 439800);
		ericolaverdo.getGestor().registrarReproduccion(werenoangels,
				format.parse("15/7/2013"), 383400);
		ericolaverdo.getGestor().registrarReproduccion(samssong,
				format.parse("13/11/2012"), 151800);
		ericolaverdo.getGestor().registrarReproduccion(ilimitless,
				format.parse("13/11/2012"), 399600);
		ericolaverdo.getGestor().registrarReproduccion(thesimpsonsS1E6,
				format.parse("13/6/2013"), 349800);
		ericolaverdo.getGestor().registrarReproduccion(thelasttycoon,
				format.parse("18/1/2013"), 462600);
		ericolaverdo.getGestor().registrarReproduccion(barneyS1E10,
				format.parse("13/11/2012"), 231000);
		ericolaverdo.getGestor().registrarReproduccion(copland,
				format.parse("13/11/2012"), 174600);
		ericolaverdo.getGestor().registrarReproduccion(thefamily,
				format.parse("13/11/2012"), 422400);
		ericolaverdo.getGestor().registrarReproduccion(marvinsroom,
				format.parse("21/10/2013"), 366600);
		ericolaverdo.getGestor().registrarReproduccion(themission,
				format.parse("26/12/2013"), 134400);
		ericolaverdo.getGestor().registrarReproduccion(thesimpsonsS1E10,
				format.parse("13/11/2012"), 342600);
		ericolaverdo.getGestor().registrarReproduccion(whatjusthappened,
				format.parse("13/11/2012"), 215400);
		ericolaverdo.getGestor().registrarReproduccion(thesimpsonsS1E11,
				format.parse("14/7/2013"), 75600);
		ericolaverdo.getGestor().registrarReproduccion(frankenstein,
				format.parse("13/11/2012"), 120600);
		ericolaverdo.getGestor().registrarReproduccion(ragingbull,
				format.parse("13/11/2012"), 64200);
		ericolaverdo.getGestor().registrarReproduccion(barneyS1E7,
				format.parse("13/11/2012"), 336000);
		ericolaverdo.getGestor().registrarReproduccion(barneyS1E30,
				format.parse("13/11/2012"), 255600);
		ericolaverdo.getGestor().registrarReproduccion(threewiseguys,
				format.parse("15/7/2013"), 375000);
		ericolaverdo.getGestor().registrarReproduccion(jackiebrown,
				format.parse("10/5/2013"), 493800);
		ericolaverdo.getGestor().registrarReproduccion(taxidriver,
				format.parse("13/11/2012"), 437400);
		ericolaverdo.getGestor().registrarReproduccion(barneyS1E10,
				format.parse("23/11/2013"), 304800);
		ericolaverdo.getGestor().registrarReproduccion(breakingbadS1E4,
				format.parse("13/11/2012"), 328200);
		ericolaverdo.getGestor().registrarReproduccion(thefamily,
				format.parse("6/8/2013"), 142800);
		ericolaverdo.getGestor().registrarReproduccion(sleepers,
				format.parse("21/10/2013"), 216000);
		ericolaverdo.getGestor().registrarReproduccion(barneyS1E24,
				format.parse("26/12/2013"), 331200);
		ericolaverdo.getGestor().registrarReproduccion(thesimpsonsS1E11,
				format.parse("14/7/2013"), 278400);
		ericolaverdo.getGestor().registrarReproduccion(barneyS1E5,
				format.parse("13/11/2012"), 222000);
		ericolaverdo.getGestor().registrarReproduccion(barneyS1E28,
				format.parse("13/11/2012"), 165600);
		ericolaverdo.getGestor().registrarReproduccion(billythekidmcdonnen,
				format.parse("5/6/2013"), 284400);
		ericolaverdo.getGestor().registrarReproduccion(righteouskill,
				format.parse("17/12/2012"), 228000);
		ericolaverdo.getGestor().registrarReproduccion(arthurandtheinvisibles,
				format.parse("20/9/2013"), 347400);
		ericolaverdo.getGestor().registrarReproduccion(barneyS1E18,
				format.parse("13/11/2012"), 291000);
		ericolaverdo.getGestor().registrarReproduccion(thesimpsonsS1E4,
				format.parse("13/11/2012"), 105000);
		ericolaverdo.getGestor().registrarReproduccion(newyorknewyork,
				format.parse("18/8/2013"), 399600);
		ericolaverdo.getGestor().registrarReproduccion(barneyS1E8,
				format.parse("23/11/2013"), 300000);
		ericolaverdo.getGestor().registrarReproduccion(breakingbadS1E2,
				format.parse("13/11/2012"), 301800);
		ericolaverdo.getGestor().registrarReproduccion(lastvegas,
				format.parse("13/11/2012"), 285600);
		ericolaverdo.getGestor().registrarReproduccion(copland,
				format.parse("13/11/2012"), 404400);
		ericolaverdo.getGestor().registrarReproduccion(theuntouchables,
				format.parse("26/7/2013"), 219000);
		ericolaverdo.getGestor().registrarReproduccion(encounter,
				format.parse("13/11/2012"), 467400);
		ericolaverdo.getGestor().registrarReproduccion(brazil,
				format.parse("27/12/2012"), 411000);
		ericolaverdo.getGestor().registrarReproduccion(barneyS1E2,
				format.parse("13/11/2012"), 312600);
		ericolaverdo.getGestor().registrarReproduccion(stardust,
				format.parse("13/11/2012"), 298200);
		ericolaverdo.getGestor().registrarReproduccion(awakenings,
				format.parse("24/11/2013"), 241800);
		ericolaverdo.getGestor().registrarReproduccion(jenniferonmymind,
				format.parse("13/11/2012"), 536400);
		ericolaverdo.getGestor().registrarReproduccion(barneyS1E16,
				format.parse("13/11/2012"), 301800);
		ericolaverdo.getGestor().registrarReproduccion(frankenstein,
				format.parse("22/10/2013"), 118800);
		ericolaverdo.getGestor().registrarReproduccion(ragingbull,
				format.parse("28/8/2013"), 413400);
		ericolaverdo.getGestor().registrarReproduccion(barneyS1E7,
				format.parse("23/10/2013"), 336000);
		ericolaverdo.getGestor().registrarReproduccion(thedeerhunter,
				format.parse("28/1/2013"), 522000);
		ericolaverdo.getGestor().registrarReproduccion(barneyS1E8,
				format.parse("23/10/2013"), 160800);
		ericolaverdo.getGestor().registrarReproduccion(breakingbadS1E1,
				format.parse("13/11/2012"), 150600);
		ericolaverdo.getGestor().registrarReproduccion(barneyS1E9,
				format.parse("13/7/2013"), 302400);
		ericolaverdo.getGestor().registrarReproduccion(barneyS1E5,
				format.parse("22/10/2013"), 259200);
		ericolaverdo.getGestor().registrarReproduccion(barneyS1E28,
				format.parse("27/12/2012"), 73800);
		ericolaverdo.getGestor().registrarReproduccion(barneyS1E6,
				format.parse("13/11/2012"), 192600);
		ericolaverdo.getGestor().registrarReproduccion(extrastvseries,
				format.parse("13/11/2012"), 532800);
		ericolaverdo.getGestor().registrarReproduccion(jacknife,
				format.parse("15/7/2013"), 477000);
		ericolaverdo.getGestor().registrarReproduccion(samssong,
				format.parse("13/11/2012"), 291000);
		ericolaverdo.getGestor().registrarReproduccion(barneyS1E20,
				format.parse("13/11/2012"), 354600);
		ericolaverdo.getGestor().registrarReproduccion(thesimpsonsS1E6,
				format.parse("13/11/2012"), 95400);
		ericolaverdo.getGestor().registrarReproduccion(barneyS1E20,
				format.parse("26/12/2013"), 354600);
		ericolaverdo.getGestor().registrarReproduccion(thesimpsonsS1E7,
				format.parse("13/11/2012"), 69000);
		ericolaverdo.getGestor().registrarReproduccion(stone,
				format.parse("13/11/2012"), 493200);
		ericolaverdo.getGestor().registrarReproduccion(mistress,
				format.parse("13/6/2013"), 132000);
		ericolaverdo.getGestor().registrarReproduccion(thegodfatherpartii,
				format.parse("1/9/2013"), 297000);
		ericolaverdo.getGestor().registrarReproduccion(borntowin,
				format.parse("13/11/2012"), 415800);
		ericolaverdo.getGestor().registrarReproduccion(beingflynn,
				format.parse("17/8/2013"), 230400);
		ericolaverdo.getGestor().registrarReproduccion(barneyS1E7,
				format.parse("13/11/2012"), 336000);
		ericolaverdo.getGestor().registrarReproduccion(stone,
				format.parse("13/11/2012"), 468600);
		ericolaverdo.getGestor().registrarReproduccion(nightandthecity,
				format.parse("23/11/2013"), 282600);
		ericolaverdo.getGestor().registrarReproduccion(breakingbadS1E4,
				format.parse("13/11/2012"), 272400);
		ericolaverdo.getGestor().registrarReproduccion(thefamily,
				format.parse("13/11/2012"), 87000);
		ericolaverdo.getGestor().registrarReproduccion(sleepers,
				format.parse("13/11/2012"), 510600);
		ericolaverdo.getGestor().registrarReproduccion(themission,
				format.parse("26/12/2012"), 149400);
		ericolaverdo.getGestor().registrarReproduccion(thesimpsonsS1E11,
				format.parse("13/11/2012"), 139200);
		ericolaverdo.getGestor().registrarReproduccion(whatjusthappened,
				format.parse("19/9/2013"), 433800);
		ericolaverdo.getGestor().registrarReproduccion(awakenings,
				format.parse("24/11/2013"), 72600);
		ericolaverdo.getGestor().registrarReproduccion(borntowin,
				format.parse("13/11/2012"), 366600);
		ericolaverdo.getGestor().registrarReproduccion(thisboyslife,
				format.parse("23/10/2013"), 486000);
		ericolaverdo.getGestor().registrarReproduccion(newyorknewyork,
				format.parse("13/11/2012"), 171000);
		ericolaverdo.getGestor().registrarReproduccion(barneyS1E9,
				format.parse("13/11/2012"), 289800);
		ericolaverdo.getGestor().registrarReproduccion(breakingbadS1E2,
				format.parse("13/11/2012"), 301800);
		ericolaverdo.getGestor().registrarReproduccion(theuntouchables,
				format.parse("16/7/2013"), 269400);
		ericolaverdo.getGestor().registrarReproduccion(threeroomsinmanhattan,
				format.parse("21/10/2013"), 259200);
		ericolaverdo.getGestor().registrarReproduccion(barneyS1E23,
				format.parse("26/12/2013"), 73200);
		ericolaverdo.getGestor().registrarReproduccion(thesimpsonsS1E9,
				format.parse("13/11/2012"), 238800);
		ericolaverdo.getGestor().registrarReproduccion(righteouskill,
				format.parse("13/11/2012"), 532800);
		ericolaverdo.getGestor().registrarReproduccion(backdraft,
				format.parse("14/7/2013"), 476400);
		ericolaverdo.getGestor().registrarReproduccion(
				thegangthatcouldntshootstraight, format.parse("13/11/2012"),
				161400);
		ericolaverdo.getGestor().registrarReproduccion(barneyS1E14,
				format.parse("6/3/2013"), 151200);
		ericolaverdo.getGestor().registrarReproduccion(thesimpsonsS1E1,
				format.parse("13/11/2012"), 316200);
		ericolaverdo.getGestor().registrarReproduccion(barneyS1E15,
				format.parse("13/11/2012"), 130800);
		ericolaverdo.getGestor().registrarReproduccion(barneyS1E18,
				format.parse("25/11/2013"), 120600);
		ericolaverdo.getGestor().registrarReproduccion(samssong,
				format.parse("13/11/2012"), 414600);
		ericolaverdo.getGestor().registrarReproduccion(barneyS1E19,
				format.parse("13/11/2012"), 229200);
		ericolaverdo.getGestor().registrarReproduccion(thesimpsonsS1E6,
				format.parse("13/6/2013"), 89400);
		ericolaverdo.getGestor().registrarReproduccion(thelasttycoon,
				format.parse("18/8/2013"), 79200);
		ericolaverdo.getGestor().registrarReproduccion(barneyS1E10,
				format.parse("23/11/2013"), 304800);
		ericolaverdo.getGestor().registrarReproduccion(breakingbadS1E3,
				format.parse("28/1/2013"), 234000);
		ericolaverdo.getGestor().registrarReproduccion(barneyS1E11,
				format.parse("6/11/2013"), 307200);
		ericolaverdo.getGestor().registrarReproduccion(breakingbadS1E4,
				format.parse("1/1/2013"), 328200);
		ericolaverdo.getGestor().registrarReproduccion(barneyS1E12,
				format.parse("13/11/2012"), 331200);
		ericolaverdo.getGestor().registrarReproduccion(backdraft,
				format.parse("14/7/2013"), 288600);
		ericolaverdo.getGestor().registrarReproduccion(
				thegangthatcouldntshootstraight, format.parse("19/9/2013"),
				149400);
		ericolaverdo.getGestor().registrarReproduccion(barneyS1E14,
				format.parse("13/11/2012"), 357600);
		ericolaverdo.getGestor().registrarReproduccion(thedeerhunter,
				format.parse("28/1/2013"), 433200);
		ericolaverdo.getGestor().registrarReproduccion(barneyS1E7,
				format.parse("13/11/2012"), 247800);
		ericolaverdo.getGestor().registrarReproduccion(jackiebrown,
				format.parse("13/11/2012"), 61800);
		ericolaverdo.getGestor().registrarReproduccion(midnightrun,
				format.parse("26/12/2013"), 356400);
		ericolaverdo.getGestor().registrarReproduccion(greetings,
				format.parse("13/11/2012"), 300000);
		ericolaverdo.getGestor().registrarReproduccion(barneyS1E21,
				format.parse("8/4/2013"), 77400);
		ericolaverdo.getGestor().registrarReproduccion(thesimpsonsS1E8,
				format.parse("13/6/2013"), 67200);
		ericolaverdo.getGestor().registrarReproduccion(machete,
				format.parse("18/9/2013"), 490800);
		ericolaverdo.getGestor().registrarReproduccion(capefear,
				format.parse("24/11/2013"), 129600);
		ericolaverdo.getGestor().registrarReproduccion(meanstreets,
				format.parse("13/11/2012"), 248400);
		ericolaverdo.getGestor().registrarReproduccion(barneyS1E13,
				format.parse("13/11/2012"), 333600);
		ericolaverdo.getGestor().registrarReproduccion(breakingbadS1E6,
				format.parse("13/11/2012"), 181800);
		ericolaverdo.getGestor().registrarReproduccion(fallinginlove,
				format.parse("16/8/2013"), 301200);
		ericolaverdo.getGestor().registrarReproduccion(jacknife,
				format.parse("13/11/2012"), 244800);
		ericolaverdo.getGestor().registrarReproduccion(breakingbadS1E5,
				format.parse("13/11/2012"), 352200);
		ericolaverdo.getGestor().registrarReproduccion(thekingofcomedy,
				format.parse("13/11/2012"), 528600);
		ericolaverdo.getGestor().registrarReproduccion(abronxtale,
				format.parse("13/11/2012"), 167400);
		ericolaverdo.getGestor().registrarReproduccion(breakingbadS1E3,
				format.parse("3/11/2013"), 157200);
		ericolaverdo.getGestor().registrarReproduccion(silverliningsplaybook,
				format.parse("9/1/2013"), 147000);
		ericolaverdo.getGestor().registrarReproduccion(onehundredandonenights,
				format.parse("13/11/2012"), 441600);
		ericolaverdo.getGestor().registrarReproduccion(thedeerhunter,
				format.parse("13/11/2012"), 431400);
		ericolaverdo.getGestor().registrarReproduccion(nightandthecity,
				format.parse("14/7/2013"), 245400);
		ericolaverdo.getGestor().registrarReproduccion(bangthedrumslowly,
				format.parse("19/9/2013"), 235200);
		ericolaverdo.getGestor().registrarReproduccion(barneyS1E14,
				format.parse("13/11/2012"), 357600);
		ericolaverdo.getGestor().registrarReproduccion(breakingbadS1E7,
				format.parse("13/11/2012"), 340800);
		ericolaverdo.getGestor().registrarReproduccion(beingflynn,
				format.parse("17/8/2013"), 508800);
		ericolaverdo.getGestor().registrarReproduccion(barneyS1E4,
				format.parse("13/11/2012"), 148200);
		ericolaverdo.getGestor().registrarReproduccion(ragingbull,
				format.parse("17/8/2013"), 442200);
		ericolaverdo.getGestor().registrarReproduccion(barneyS1E7,
				format.parse("13/11/2012"), 81600);
		ericolaverdo.getGestor().registrarReproduccion(barneyS1E30,
				format.parse("13/11/2012"), 312600);
		ericolaverdo.getGestor().registrarReproduccion(americanhustle,
				format.parse("15/7/2013"), 365400);
		ericolaverdo.getGestor().registrarReproduccion(jackiebrown,
				format.parse("20/9/2013"), 128400);
		ericolaverdo.getGestor().registrarReproduccion(thefamily,
				format.parse("16/11/2013"), 423000);
		ericolaverdo.getGestor().registrarReproduccion(breakingbadS1E7,
				format.parse("13/11/2012"), 340800);
		ericolaverdo.getGestor().registrarReproduccion(fallinginlove,
				format.parse("27/12/2012"), 226800);
		ericolaverdo.getGestor().registrarReproduccion(thesimpsonsS1E13,
				format.parse("13/11/2012"), 216600);
		ericolaverdo.getGestor().registrarReproduccion(thegoodshepherd,
				format.parse("13/11/2012"), 511200);
		ericolaverdo.getGestor().registrarReproduccion(stanleyiris,
				format.parse("15/7/2013"), 500400);
		ericolaverdo.getGestor().registrarReproduccion(thesimpsonsS1E3,
				format.parse("2/2/2013"), 358800);
		ericolaverdo.getGestor().registrarReproduccion(barneyS1E18,
				format.parse("13/11/2012"), 129600);
		ericolaverdo.getGestor().registrarReproduccion(barneyS1E21,
				format.parse("8/12/2013"), 357000);
		ericolaverdo.getGestor().registrarReproduccion(thesimpsonsS1E8,
				format.parse("13/11/2012"), 337800);
		ericolaverdo.getGestor().registrarReproduccion(machete,
				format.parse("18/9/2013"), 357000);
		ericolaverdo.getGestor().registrarReproduccion(barneyS1E12,
				format.parse("24/11/2013"), 331200);
		ericolaverdo.getGestor().registrarReproduccion(breakingbadS1E5,
				format.parse("13/11/2012"), 352200);
		ericolaverdo.getGestor().registrarReproduccion(silverliningsplaybook,
				format.parse("16/8/2013"), 455400);
		ericolaverdo.getGestor().registrarReproduccion(thefan,
				format.parse("13/11/2012"), 94800);
		ericolaverdo.getGestor().registrarReproduccion(fallinginlove,
				format.parse("27/12/2013"), 388800);
		ericolaverdo.getGestor().registrarReproduccion(barneyS1E3,
				format.parse("22/10/2013"), 203400);
		ericolaverdo.getGestor().registrarReproduccion(thegoodshepherd,
				format.parse("13/11/2012"), 497400);
		ericolaverdo.getGestor().registrarReproduccion(goodfellas,
				format.parse("25/11/2013"), 441000);
		ericolaverdo.getGestor().registrarReproduccion(himom,
				format.parse("20/9/2013"), 430800);
		ericolaverdo.getGestor().registrarReproduccion(barneyS1E17,
				format.parse("13/11/2012"), 245400);
		ericolaverdo.getGestor().registrarReproduccion(lasedadesdelamor,
				format.parse("13/11/2012"), 540000);
		ericolaverdo.getGestor().registrarReproduccion(nightandthecity,
				format.parse("23/11/2013"), 529200);
		ericolaverdo.getGestor().registrarReproduccion(taxidriver,
				format.parse("28/1/2013"), 519000);
		ericolaverdo.getGestor().registrarReproduccion(barneyS1E11,
				format.parse("13/11/2012"), 307200);
		ericolaverdo.getGestor().registrarReproduccion(breakingbadS1E4,
				format.parse("13/11/2012"), 323400);
		ericolaverdo.getGestor().registrarReproduccion(themission,
				format.parse("16/8/2013"), 313200);
		ericolaverdo.getGestor().registrarReproduccion(barneyS1E1,
				format.parse("21/10/2013"), 127200);
		ericolaverdo.getGestor().registrarReproduccion(barneyS1E25,
				format.parse("27/12/2012"), 333600);
		ericolaverdo.getGestor().registrarReproduccion(thesimpsonsS1E11,
				format.parse("13/11/2012"), 106800);
		ericolaverdo.getGestor().registrarReproduccion(stardust,
				format.parse("19/9/2013"), 225600);
		ericolaverdo.getGestor().registrarReproduccion(awakenings,
				format.parse("24/11/2013"), 345000);
		ericolaverdo.getGestor().registrarReproduccion(jenniferonmymind,
				format.parse("19/9/2013"), 334200);
		ericolaverdo.getGestor().registrarReproduccion(goodfellas,
				format.parse("25/11/2013"), 448200);
		ericolaverdo.getGestor().registrarReproduccion(lasedadesdelamor,
				format.parse("18/1/2013"), 133200);
		ericolaverdo.getGestor().registrarReproduccion(barneyS1E9,
				format.parse("13/11/2012"), 302400);
		ericolaverdo.getGestor().registrarReproduccion(breakingbadS1E3,
				format.parse("13/11/2012"), 112800);
		ericolaverdo.getGestor().registrarReproduccion(theuntouchables,
				format.parse("26/7/2013"), 406800);
		ericolaverdo.getGestor().registrarReproduccion(encounter,
				format.parse("21/10/2013"), 526200);
		ericolaverdo.getGestor().registrarReproduccion(barneyS1E23,
				format.parse("26/12/2013"), 165000);
		ericolaverdo.getGestor().registrarReproduccion(barneyS1E1,
				format.parse("13/11/2012"), 333600);
		ericolaverdo.getGestor().registrarReproduccion(barneyS1E24,
				format.parse("13/11/2012"), 273600);
		ericolaverdo.getGestor().registrarReproduccion(thesimpsonsS1E11,
				format.parse("14/7/2013"), 344400);
		ericolaverdo.getGestor().registrarReproduccion(
				thegangthatcouldntshootstraight, format.parse("19/9/2013"),
				216000);
		ericolaverdo.getGestor().registrarReproduccion(barneyS1E15,
				format.parse("24/11/2013"), 360000);
		ericolaverdo.getGestor().registrarReproduccion(thesimpsonsS1E1,
				format.parse("13/11/2012"), 332400);
		ericolaverdo.getGestor().registrarReproduccion(redlights,
				format.parse("13/11/2012"), 286200);
		ericolaverdo.setSesion(new Sesion(new Reproduccion(thebigwedding,
				format.parse("6/1/2014"), 392400), format.parse("6/1/2014")));
		sitio.registrarUsuario(ericolaverdo);
		Usuario cutebunnies33 = new Usuario(format.parse("8/6/2006"),
				"cutebunnies33@gmail.com", format.parse("12/6/2012"), catalogo);
		cutebunnies33.getSuscripcion().pasarAVIP();
		cutebunnies33.getGestor().registrarReproduccion(breakingbadS1E7,
				format.parse("12/6/2012"), 340800);
		cutebunnies33.getGestor().registrarReproduccion(fallinginlove,
				format.parse("27/8/2012"), 213000);
		cutebunnies33.getGestor().registrarReproduccion(barneyS1E4,
				format.parse("4/2/2013"), 323400);
		cutebunnies33.getGestor().registrarReproduccion(barneyS1E27,
				format.parse("12/6/2012"), 322200);
		cutebunnies33.getGestor().registrarReproduccion(stanleyiris,
				format.parse("25/11/2013"), 164400);
		cutebunnies33.getGestor().registrarReproduccion(thesimpsonsS1E3,
				format.parse("12/6/2012"), 358800);
		cutebunnies33.getGestor().registrarReproduccion(killerelite,
				format.parse("17/8/2012"), 393000);
		cutebunnies33.getGestor().registrarReproduccion(abronxtale,
				format.parse("23/10/2013"), 115200);
		cutebunnies33.getGestor().registrarReproduccion(newyorknewyork,
				format.parse("12/6/2012"), 317400);
		cutebunnies33.getGestor().registrarReproduccion(barneyS1E8,
				format.parse("12/6/2012"), 300000);
		cutebunnies33.getGestor().registrarReproduccion(wagthedog,
				format.parse("12/6/2012"), 66600);
		cutebunnies33.getGestor().registrarReproduccion(
				dearamericalettershomefromvietnamtvmoviedocumentary,
				format.parse("26/5/2013"), 231600);
		cutebunnies33.getGestor().registrarReproduccion(whatjusthappened,
				format.parse("9/9/2012"), 433800);
		cutebunnies33.getGestor().registrarReproduccion(guiltybysuspicion,
				format.parse("24/7/2013"), 156000);
		cutebunnies33.getGestor().registrarReproduccion(borntowin,
				format.parse("19/1/2013"), 358200);
		cutebunnies33.getGestor().registrarReproduccion(barneyS1E15,
				format.parse("12/6/2012"), 360000);
		cutebunnies33.getGestor().registrarReproduccion(thesimpsonsS1E2,
				format.parse("12/6/2012"), 357000);
		cutebunnies33.getGestor().registrarReproduccion(redlights,
				format.parse("17/8/2013"), 484800);
		cutebunnies33.getGestor().registrarReproduccion(barneyS1E6,
				format.parse("22/10/2013"), 207000);
		cutebunnies33.getGestor().registrarReproduccion(thelasttycoon,
				format.parse("18/4/2013"), 234000);
		cutebunnies33.getGestor().registrarReproduccion(himom,
				format.parse("12/6/2012"), 131400);
		cutebunnies33.getGestor().registrarReproduccion(barneyS1E20,
				format.parse("25/12/2013"), 354600);
		cutebunnies33.getGestor().registrarReproduccion(thesimpsonsS1E7,
				format.parse("12/6/2012"), 249600);
		cutebunnies33.getGestor().registrarReproduccion(stone,
				format.parse("12/6/2012"), 238800);
		cutebunnies33.getGestor().registrarReproduccion(mistress,
				format.parse("13/11/2013"), 228600);
		cutebunnies33.getGestor().registrarReproduccion(freelancers,
				format.parse("17/8/2013"), 84000);
		cutebunnies33.getGestor().registrarReproduccion(barneyS1E3,
				format.parse("22/10/2013"), 360000);
		cutebunnies33.getGestor().registrarReproduccion(barneyS1E27,
				format.parse("12/6/2012"), 322200);
		cutebunnies33.getGestor().registrarReproduccion(goodfellas,
				format.parse("14/7/2013"), 339600);
		cutebunnies33.getGestor().registrarReproduccion(himom,
				format.parse("20/9/2013"), 237600);
		cutebunnies33.getGestor().registrarReproduccion(barneyS1E17,
				format.parse("25/11/2013"), 304200);
		cutebunnies33.getGestor().registrarReproduccion(thesimpsonsS1E4,
				format.parse("12/6/2012"), 323400);
		cutebunnies33.getGestor().registrarReproduccion(thedeerhunter,
				format.parse("18/8/2013"), 539400);
		cutebunnies33.getGestor().registrarReproduccion(barneyS1E8,
				format.parse("23/10/2013"), 86400);
		cutebunnies33.getGestor().registrarReproduccion(breakingbadS1E1,
				format.parse("12/6/2012"), 159000);
		cutebunnies33.getGestor().registrarReproduccion(lastvegas,
				format.parse("15/7/2013"), 361200);
		cutebunnies33.getGestor().registrarReproduccion(wagthedog,
				format.parse("21/10/2013"), 83400);
		cutebunnies33.getGestor().registrarReproduccion(theuntouchables,
				format.parse("26/12/2013"), 110400);
		cutebunnies33.getGestor().registrarReproduccion(arthurandtheinvisibles,
				format.parse("12/6/2012"), 487800);
		cutebunnies33.getGestor().registrarReproduccion(jacknife,
				format.parse("25/12/2013"), 339600);
		cutebunnies33.getGestor().registrarReproduccion(thesimpsonsS1E6,
				format.parse("12/6/2012"), 349800);
		cutebunnies33.getGestor().registrarReproduccion(lasedadesdelamor,
				format.parse("18/8/2013"), 134400);
		cutebunnies33.getGestor().registrarReproduccion(barneyS1E10,
				format.parse("23/3/2013"), 304800);
		cutebunnies33.getGestor().registrarReproduccion(breakingbadS1E3,
				format.parse("12/6/2012"), 234000);
		cutebunnies33.getGestor().registrarReproduccion(angelheart,
				format.parse("26/8/2013"), 436200);
		cutebunnies33.getGestor().registrarReproduccion(barneyS1E1,
				format.parse("21/2/2013"), 333600);
		cutebunnies33.getGestor().registrarReproduccion(barneyS1E24,
				format.parse("12/6/2012"), 185400);
		cutebunnies33.getGestor().registrarReproduccion(guiltybysuspicion,
				format.parse("14/7/2013"), 387600);
		cutebunnies33.getGestor().registrarReproduccion(
				thegangthatcouldntshootstraight, format.parse("19/9/2013"),
				460800);
		cutebunnies33.getGestor().registrarReproduccion(barneyS1E15,
				format.parse("24/11/2013"), 183000);
		cutebunnies33.getGestor().registrarReproduccion(thesimpsonsS1E1,
				format.parse("12/6/2012"), 80400);
		cutebunnies33.getGestor().registrarReproduccion(beingflynn,
				format.parse("23/10/2013"), 282600);
		cutebunnies33.getGestor().registrarReproduccion(jackiebrown,
				format.parse("12/6/2012"), 484800);
		cutebunnies33.getGestor().registrarReproduccion(midnightrun,
				format.parse("26/12/2013"), 511800);
		cutebunnies33.getGestor().registrarReproduccion(thesimpsonsS1E7,
				format.parse("12/6/2012"), 104400);
		cutebunnies33.getGestor().registrarReproduccion(stone,
				format.parse("18/9/2012"), 261000);
		cutebunnies33.getGestor().registrarReproduccion(mistress,
				format.parse("23/11/2013"), 112200);
		cutebunnies33.getGestor().registrarReproduccion(thegodfatherpartii,
				format.parse("12/6/2012"), 185400);
		cutebunnies33.getGestor().registrarReproduccion(thebigwedding,
				format.parse("12/6/2012"), 82800);
		cutebunnies33.getGestor().registrarReproduccion(sleepers,
				format.parse("21/10/2013"), 414000);
		cutebunnies33.getGestor().registrarReproduccion(barneyS1E25,
				format.parse("27/12/2012"), 136200);
		cutebunnies33.getGestor().registrarReproduccion(barneyS1E2,
				format.parse("12/6/2012"), 312600);
		cutebunnies33.getGestor().registrarReproduccion(stardust,
				format.parse("12/6/2012"), 190200);
		cutebunnies33.getGestor().registrarReproduccion(awakenings,
				format.parse("14/11/2013"), 521400);
		cutebunnies33.getGestor().registrarReproduccion(jenniferonmymind,
				format.parse("12/6/2012"), 419400);
		cutebunnies33.getGestor().registrarReproduccion(barneyS1E20,
				format.parse("12/6/2012"), 141600);
		cutebunnies33.getGestor().registrarReproduccion(nightandthecity,
				format.parse("13/6/2013"), 519000);
		cutebunnies33.getGestor().registrarReproduccion(taxidriver,
				format.parse("18/9/2013"), 66000);
		cutebunnies33.getGestor().registrarReproduccion(barneyS1E11,
				format.parse("23/11/2013"), 268200);
		cutebunnies33.getGestor().registrarReproduccion(breakingbadS1E4,
				format.parse("12/6/2012"), 328200);
		cutebunnies33.getGestor().registrarReproduccion(barneyS1E12,
				format.parse("12/6/2012"), 63000);
		cutebunnies33.getGestor().registrarReproduccion(borntowin,
				format.parse("27/12/2012"), 265200);
		cutebunnies33.getGestor().registrarReproduccion(dragna,
				format.parse("15/7/2012"), 117000);
		cutebunnies33.getGestor().registrarReproduccion(extrastvseries,
				format.parse("20/9/2013"), 189600);
		cutebunnies33.getGestor().registrarReproduccion(werenoangels,
				format.parse("15/7/2013"), 391800);
		cutebunnies33.getGestor().registrarReproduccion(samssong,
				format.parse("20/9/2013"), 114000);
		cutebunnies33.getGestor().registrarReproduccion(barneyS1E19,
				format.parse("12/6/2012"), 316200);
		cutebunnies33.getGestor().registrarReproduccion(maddogandglory,
				format.parse("13/11/2012"), 420000);
		cutebunnies33.getGestor().registrarReproduccion(bangthedrumslowly,
				format.parse("12/6/2012"), 538800);
		cutebunnies33.getGestor().registrarReproduccion(freelancers,
				format.parse("17/8/2013"), 261000);
		cutebunnies33.getGestor().registrarReproduccion(heat,
				format.parse("22/10/2013"), 288000);
		cutebunnies33.getGestor().registrarReproduccion(barneyS1E5,
				format.parse("12/6/2012"), 185400);
		cutebunnies33.getGestor().registrarReproduccion(barneyS1E29,
				format.parse("10/12/2012"), 348600);
		cutebunnies33.getGestor().registrarReproduccion(billythekidmcdonnen,
				format.parse("12/6/2012"), 285000);
		cutebunnies33.getGestor().registrarReproduccion(barneyS1E29,
				format.parse("12/6/2012"), 182400);
		cutebunnies33.getGestor().registrarReproduccion(jacknife,
				format.parse("15/7/2013"), 514200);
		cutebunnies33.getGestor().registrarReproduccion(samssong,
				format.parse("20/2/2013"), 236400);
		cutebunnies33.getGestor().registrarReproduccion(barneyS1E20,
				format.parse("25/12/2013"), 354600);
		cutebunnies33.getGestor().registrarReproduccion(thesimpsonsS1E6,
				format.parse("13/6/2013"), 349800);
		cutebunnies33.getGestor().registrarReproduccion(stone,
				format.parse("18/8/2012"), 538200);
		cutebunnies33.getGestor().registrarReproduccion(nightandthecity,
				format.parse("23/11/2013"), 436200);
		cutebunnies33.getGestor().registrarReproduccion(breakingbadS1E5,
				format.parse("11/10/2013"), 352200);
		cutebunnies33.getGestor().registrarReproduccion(brazil,
				format.parse("27/12/2012"), 535800);
		cutebunnies33.getGestor().registrarReproduccion(thesimpsonsS1E11,
				format.parse("12/6/2012"), 128400);
		cutebunnies33.getGestor().registrarReproduccion(stardust,
				format.parse("9/9/2012"), 293400);
		cutebunnies33.getGestor().registrarReproduccion(awakenings,
				format.parse("24/11/2013"), 495600);
		cutebunnies33.getGestor().registrarReproduccion(thesimpsonsS1E2,
				format.parse("12/6/2012"), 226800);
		cutebunnies33.getGestor().registrarReproduccion(redlights,
				format.parse("17/8/2013"), 124800);
		cutebunnies33.getGestor().registrarReproduccion(barneyS1E6,
				format.parse("22/10/2013"), 328200);
		cutebunnies33.getGestor().registrarReproduccion(barneyS1E29,
				format.parse("12/6/2012"), 224400);
		cutebunnies33.getGestor().registrarReproduccion(barneyS1E7,
				format.parse("5/3/2013"), 336000);
		cutebunnies33.getGestor().registrarReproduccion(barneyS1E30,
				format.parse("12/6/2012"), 148800);
		cutebunnies33.getGestor().registrarReproduccion(americanhustle,
				format.parse("15/7/2013"), 222000);
		cutebunnies33.getGestor().registrarReproduccion(jackiebrown,
				format.parse("12/6/2012"), 424200);
		cutebunnies33.getGestor().registrarReproduccion(lastvegas,
				format.parse("12/6/2012"), 321600);
		cutebunnies33.getGestor().registrarReproduccion(thefan,
				format.parse("22/10/2013"), 523800);
		cutebunnies33.getGestor().registrarReproduccion(barneyS1E26,
				format.parse("12/6/2012"), 357600);
		cutebunnies33.getGestor().registrarReproduccion(thesimpsonsS1E12,
				format.parse("14/7/2013"), 309000);
		cutebunnies33.getGestor().registrarReproduccion(jenniferonmymind,
				format.parse("12/6/2012"), 87000);
		cutebunnies33.getGestor().registrarReproduccion(barneyS1E16,
				format.parse("12/6/2012"), 289200);
		cutebunnies33.getGestor().registrarReproduccion(frankenstein,
				format.parse("12/6/2012"), 316200);
		cutebunnies33.getGestor().registrarReproduccion(ragingbull,
				format.parse("17/8/2013"), 213600);
		cutebunnies33.getGestor().registrarReproduccion(abronxtale,
				format.parse("12/6/2012"), 111000);
		cutebunnies33.getGestor().registrarReproduccion(thedeerhunter,
				format.parse("28/8/2013"), 489000);
		cutebunnies33.getGestor().registrarReproduccion(barneyS1E8,
				format.parse("23/10/2013"), 300000);
		cutebunnies33.getGestor().registrarReproduccion(newyorknewyork,
				format.parse("12/6/2012"), 459600);
		cutebunnies33.getGestor().registrarReproduccion(lastvegas,
				format.parse("12/6/2012"), 357000);
		cutebunnies33.getGestor().registrarReproduccion(wagthedog,
				format.parse("12/6/2012"), 254400);
		cutebunnies33.getGestor().registrarReproduccion(thesimpsonsS1E1,
				format.parse("12/6/2012"), 327600);
		cutebunnies33.getGestor().registrarReproduccion(barneyS1E15,
				format.parse("12/6/2012"), 225000);
		cutebunnies33.getGestor().registrarReproduccion(thesimpsonsS1E2,
				format.parse("12/6/2012"), 297600);
		cutebunnies33.getGestor().registrarReproduccion(trueconfessions,
				format.parse("17/8/2013"), 499800);
		cutebunnies33.getGestor().registrarReproduccion(barneyS1E6,
				format.parse("12/6/2012"), 328200);
		cutebunnies33.getGestor().registrarReproduccion(extrastvseries,
				format.parse("12/6/2012"), 166200);
		cutebunnies33.getGestor().registrarReproduccion(jacknife,
				format.parse("15/7/2013"), 192600);
		cutebunnies33.getGestor().registrarReproduccion(samssong,
				format.parse("2/9/2013"), 90600);
		cutebunnies33.getGestor().registrarReproduccion(barneyS1E20,
				format.parse("12/6/2012"), 354600);
		cutebunnies33.getGestor().registrarReproduccion(thesimpsonsS1E6,
				format.parse("13/6/2013"), 60600);
		cutebunnies33.getGestor().registrarReproduccion(taxidriver,
				format.parse("28/8/2013"), 438600);
		cutebunnies33.getGestor().registrarReproduccion(barneyS1E10,
				format.parse("12/6/2012"), 304800);
		cutebunnies33.getGestor().registrarReproduccion(breakingbadS1E4,
				format.parse("12/6/2012"), 328200);
		cutebunnies33.getGestor().registrarReproduccion(thesimpsonsS1E2,
				format.parse("12/6/2012"), 357000);
		cutebunnies33.getGestor().registrarReproduccion(newyearseve,
				format.parse("12/6/2012"), 60600);
		cutebunnies33.getGestor().registrarReproduccion(frankenstein,
				format.parse("22/10/2013"), 225600);
		cutebunnies33.getGestor().registrarReproduccion(barneyS1E30,
				format.parse("12/6/2012"), 298200);
		cutebunnies33.getGestor().registrarReproduccion(threewiseguys,
				format.parse("15/7/2013"), 334200);
		cutebunnies33.getGestor().registrarReproduccion(theweddingparty,
				format.parse("20/9/2013"), 407400);
		cutebunnies33.getGestor().registrarReproduccion(barneyS1E20,
				format.parse("26/12/2013"), 304800);
		cutebunnies33.getGestor().registrarReproduccion(thesimpsonsS1E7,
				format.parse("12/6/2012"), 313800);
		cutebunnies33.getGestor().registrarReproduccion(stone,
				format.parse("12/6/2012"), 99600);
		cutebunnies33.getGestor().registrarReproduccion(mistress,
				format.parse("23/11/2013"), 126600);
		cutebunnies33.getGestor().registrarReproduccion(thegodfatherpartii,
				format.parse("12/6/2012"), 375000);
		cutebunnies33.getGestor().registrarReproduccion(thebigwedding,
				format.parse("12/6/2012"), 447600);
		cutebunnies33.getGestor().registrarReproduccion(sleepers,
				format.parse("12/6/2012"), 474600);
		cutebunnies33.getGestor().registrarReproduccion(barneyS1E17,
				format.parse("12/6/2012"), 304200);
		cutebunnies33.getGestor().registrarReproduccion(frankenstein,
				format.parse("22/10/2013"), 399000);
		cutebunnies33.getGestor().registrarReproduccion(thedeerhunter,
				format.parse("12/6/2012"), 297000);
		cutebunnies33.getGestor().registrarReproduccion(threewiseguys,
				format.parse("15/7/2012"), 369600);
		cutebunnies33.getGestor().registrarReproduccion(jackiebrown,
				format.parse("20/9/2013"), 267000);
		cutebunnies33.getGestor().registrarReproduccion(barneyS1E20,
				format.parse("26/12/2013"), 165000);
		cutebunnies33.getGestor().registrarReproduccion(thesimpsonsS1E7,
				format.parse("12/6/2012"), 237600);
		cutebunnies33.getGestor().registrarReproduccion(stone,
				format.parse("18/9/2013"), 439800);
		cutebunnies33.getGestor().registrarReproduccion(mistress,
				format.parse("23/11/2013"), 466800);
		cutebunnies33.getGestor().registrarReproduccion(thegodfatherpartii,
				format.parse("12/6/2012"), 235200);
		cutebunnies33.getGestor().registrarReproduccion(thebigwedding,
				format.parse("12/6/2012"), 307800);
		cutebunnies33.getGestor().registrarReproduccion(breakingbadS1E5,
				format.parse("12/6/2012"), 76200);
		cutebunnies33.getGestor().registrarReproduccion(silverliningsplaybook,
				format.parse("16/8/2013"), 149400);
		cutebunnies33.getGestor().registrarReproduccion(thefan,
				format.parse("9/9/2013"), 526800);
		cutebunnies33.getGestor().registrarReproduccion(killerelite,
				format.parse("17/7/2013"), 424200);
		cutebunnies33.getGestor().registrarReproduccion(breakingbadS1E4,
				format.parse("12/6/2012"), 192600);
		cutebunnies33.getGestor().registrarReproduccion(angelheart,
				format.parse("26/12/2013"), 90000);
		cutebunnies33.getGestor().registrarReproduccion(barneyS1E13,
				format.parse("24/11/2013"), 333600);
		cutebunnies33.getGestor().registrarReproduccion(bangthedrumslowly,
				format.parse("1/1/2013"), 60600);
		cutebunnies33.getGestor().registrarReproduccion(barneyS1E14,
				format.parse("12/6/2012"), 357600);
		cutebunnies33.getGestor().registrarReproduccion(awakenings,
				format.parse("24/11/2013"), 336000);
		cutebunnies33.getGestor().registrarReproduccion(jenniferonmymind,
				format.parse("12/6/2012"), 408600);
		cutebunnies33.getGestor().registrarReproduccion(barneyS1E16,
				format.parse("12/6/2012"), 301800);
		cutebunnies33.getGestor().registrarReproduccion(frankenstein,
				format.parse("12/6/2012"), 508200);
		cutebunnies33.getGestor().registrarReproduccion(ragingbull,
				format.parse("17/8/2013"), 406200);
		cutebunnies33.getGestor().registrarReproduccion(barneyS1E7,
				format.parse("5/3/2013"), 336000);
		cutebunnies33.getGestor().registrarReproduccion(barneyS1E30,
				format.parse("10/8/2013"), 312600);
		cutebunnies33.getGestor().registrarReproduccion(guiltybysuspicion,
				format.parse("14/7/2013"), 449400);
		cutebunnies33.getGestor().registrarReproduccion(borntowin,
				format.parse("12/6/2012"), 522600);
		cutebunnies33.getGestor().registrarReproduccion(beingflynn,
				format.parse("12/6/2012"), 420000);
		cutebunnies33.getGestor().registrarReproduccion(thesimpsonsS1E2,
				format.parse("12/6/2012"), 188400);
		cutebunnies33.getGestor().registrarReproduccion(redlights,
				format.parse("17/8/2012"), 261000);
		cutebunnies33.getGestor().registrarReproduccion(frankenstein,
				format.parse("22/6/2012"), 463200);
		cutebunnies33.getGestor().registrarReproduccion(ragingbull,
				format.parse("27/1/2013"), 360600);
		cutebunnies33.getGestor().registrarReproduccion(barneyS1E7,
				format.parse("5/10/2013"), 258600);
		cutebunnies33.getGestor().registrarReproduccion(thedeerhunter,
				format.parse("12/6/2012"), 507000);
		cutebunnies33.getGestor().registrarReproduccion(americanhustle,
				format.parse("12/6/2012"), 99600);
		cutebunnies33.getGestor().registrarReproduccion(jackiebrown,
				format.parse("12/6/2012"), 477000);
		cutebunnies33.getGestor().registrarReproduccion(
				dearamericalettershomefromvietnamtvmoviedocumentary,
				format.parse("26/12/2013"), 64800);
		cutebunnies33.getGestor().registrarReproduccion(greetings,
				format.parse("12/6/2012"), 442200);
		cutebunnies33.getGestor().registrarReproduccion(thesimpsonsS1E1,
				format.parse("12/6/2012"), 332400);
		cutebunnies33.getGestor().registrarReproduccion(beingflynn,
				format.parse("17/8/2012"), 459000);
		cutebunnies33.getGestor().registrarReproduccion(onehundredandonenights,
				format.parse("12/6/2012"), 227400);
		cutebunnies33.getGestor().registrarReproduccion(redlights,
				format.parse("17/8/2013"), 300000);
		cutebunnies33.getGestor().registrarReproduccion(barneyS1E6,
				format.parse("22/10/2013"), 197400);
		cutebunnies33.getGestor().registrarReproduccion(barneyS1E29,
				format.parse("12/6/2012"), 270600);
		cutebunnies33.getGestor().registrarReproduccion(threewiseguys,
				format.parse("15/7/2012"), 343800);
		cutebunnies33.getGestor().registrarReproduccion(greatexpectations,
				format.parse("12/6/2012"), 241200);
		cutebunnies33.getGestor().registrarReproduccion(midnightrun,
				format.parse("15/7/2013"), 313800);
		cutebunnies33.getGestor().registrarReproduccion(jackiebrown,
				format.parse("20/9/2013"), 211800);
		cutebunnies33.getGestor().registrarReproduccion(
				dearamericalettershomefromvietnamtvmoviedocumentary,
				format.parse("26/12/2013"), 247200);
		cutebunnies33.getGestor().registrarReproduccion(greetings,
				format.parse("3/2/2013"), 145200);
		cutebunnies33.getGestor().registrarReproduccion(barneyS1E22,
				format.parse("26/12/2013"), 217800);
		cutebunnies33.getGestor().registrarReproduccion(breakingbadS1E7,
				format.parse("22/10/2013"), 340800);
		cutebunnies33.getGestor().registrarReproduccion(stardust,
				format.parse("19/9/2012"), 363600);
		cutebunnies33.getGestor().registrarReproduccion(goodfellas,
				format.parse("14/7/2013"), 85800);
		cutebunnies33.getGestor().registrarReproduccion(thegoodshepherd,
				format.parse("20/9/2013"), 159000);
		cutebunnies33.getGestor().registrarReproduccion(barneyS1E17,
				format.parse("25/11/2013"), 231600);
		cutebunnies33.getGestor().registrarReproduccion(thesimpsonsS1E3,
				format.parse("12/6/2012"), 175200);
		cutebunnies33.getGestor().registrarReproduccion(killerelite,
				format.parse("17/8/2013"), 73200);
		cutebunnies33.getGestor().registrarReproduccion(barneyS1E7,
				format.parse("23/10/2013"), 145800);
		cutebunnies33.getGestor().registrarReproduccion(breakingbadS1E1,
				format.parse("12/6/2012"), 89400);
		cutebunnies33.getGestor().registrarReproduccion(americanhustle,
				format.parse("12/6/2012"), 162600);
		cutebunnies33.getGestor().registrarReproduccion(wagthedog,
				format.parse("12/6/2012"), 411000);
		cutebunnies33.getGestor().registrarReproduccion(
				dearamericalettershomefromvietnamtvmoviedocumentary,
				format.parse("26/12/2013"), 271200);
		cutebunnies33.getGestor().registrarReproduccion(threeroomsinmanhattan,
				format.parse("12/6/2012"), 214800);
		cutebunnies33.getGestor().registrarReproduccion(barneyS1E13,
				format.parse("24/12/2013"), 288000);
		cutebunnies33.getGestor().registrarReproduccion(barneyS1E13,
				format.parse("12/6/2012"), 333600);
		cutebunnies33.getGestor().registrarReproduccion(breakingbadS1E7,
				format.parse("12/6/2012"), 129000);
		cutebunnies33.getGestor().registrarReproduccion(fallinginlove,
				format.parse("17/8/2013"), 377400);
		cutebunnies33.getGestor().registrarReproduccion(barneyS1E4,
				format.parse("12/6/2012"), 323400);
		cutebunnies33.getGestor().registrarReproduccion(thegoodshepherd,
				format.parse("12/6/2012"), 218400);
		cutebunnies33.getGestor().registrarReproduccion(stanleyiris,
				format.parse("25/11/2013"), 291600);
		cutebunnies33.getGestor().registrarReproduccion(thesimpsonsS1E3,
				format.parse("12/6/2012"), 235200);
		cutebunnies33.getGestor().registrarReproduccion(killerelite,
				format.parse("12/6/2012"), 483000);
		cutebunnies33.getGestor().registrarReproduccion(abronxtale,
				format.parse("12/6/2012"), 76200);
		cutebunnies33.getGestor().registrarReproduccion(ilimitless,
				format.parse("18/8/2013"), 149400);
		cutebunnies33.getGestor().registrarReproduccion(barneyS1E8,
				format.parse("12/6/2012"), 222000);
		cutebunnies33.getGestor().registrarReproduccion(breakingbadS1E2,
				format.parse("12/6/2012"), 165600);
		cutebunnies33.getGestor().registrarReproduccion(lastvegas,
				format.parse("16/7/2012"), 238800);
		cutebunnies33.getGestor().registrarReproduccion(barneyS1E27,
				format.parse("12/6/2012"), 322200);
		cutebunnies33.getGestor().registrarReproduccion(jacknife,
				format.parse("23/11/2013"), 209400);
		cutebunnies33.getGestor().registrarReproduccion(breakingbadS1E3,
				format.parse("12/6/2012"), 153000);
		cutebunnies33.getGestor().registrarReproduccion(killingseason,
				format.parse("5/7/2013"), 400800);
		cutebunnies33.getGestor().registrarReproduccion(marvinsroom,
				format.parse("21/10/2012"), 306000);
		cutebunnies33.getGestor().registrarReproduccion(angelheart,
				format.parse("16/8/2013"), 74400);
		cutebunnies33.getGestor().registrarReproduccion(barneyS1E1,
				format.parse("12/6/2012"), 322800);
		cutebunnies33.getGestor().registrarReproduccion(barneyS1E24,
				format.parse("12/6/2012"), 331200);
		cutebunnies33.getGestor().registrarReproduccion(thesimpsonsS1E11,
				format.parse("14/7/2013"), 121800);
		cutebunnies33.getGestor().registrarReproduccion(
				thegangthatcouldntshootstraight, format.parse("19/9/2013"),
				415800);
		cutebunnies33.getGestor().registrarReproduccion(awakenings,
				format.parse("24/11/2013"), 313200);
		cutebunnies33.getGestor().registrarReproduccion(thesimpsonsS1E1,
				format.parse("12/6/2012"), 81600);
		cutebunnies33.getGestor().registrarReproduccion(redlights,
				format.parse("12/6/2012"), 246600);
		cutebunnies33.getGestor().registrarReproduccion(taxidriver,
				format.parse("12/6/2012"), 319800);
		cutebunnies33.getGestor().registrarReproduccion(thefamily,
				format.parse("16/8/2013"), 392400);
		cutebunnies33.getGestor().registrarReproduccion(marvinsroom,
				format.parse("21/10/2013"), 160800);
		cutebunnies33.getGestor().registrarReproduccion(themission,
				format.parse("26/12/2013"), 234000);
		cutebunnies33.getGestor().registrarReproduccion(barneyS1E1,
				format.parse("12/6/2012"), 306600);
		cutebunnies33.getGestor().registrarReproduccion(barneyS1E25,
				format.parse("12/6/2012"), 75000);
		cutebunnies33.getGestor().registrarReproduccion(thesimpsonsS1E11,
				format.parse("14/7/2013"), 344400);
		cutebunnies33.getGestor().registrarReproduccion(stardust,
				format.parse("12/6/2012"), 396000);
		cutebunnies33.getGestor().registrarReproduccion(awakenings,
				format.parse("14/7/2013"), 294000);
		cutebunnies33.getGestor().registrarReproduccion(jenniferonmymind,
				format.parse("19/9/2013"), 237600);
		cutebunnies33.getGestor().registrarReproduccion(barneyS1E28,
				format.parse("12/6/2012"), 324000);
		cutebunnies33.getGestor().registrarReproduccion(werenoangels,
				format.parse("15/7/2013"), 253800);
		cutebunnies33.getGestor().registrarReproduccion(bloodymama,
				format.parse("20/9/2013"), 327000);
		cutebunnies33.getGestor().registrarReproduccion(barneyS1E19,
				format.parse("12/6/2012"), 95400);
		cutebunnies33.getGestor().registrarReproduccion(themission,
				format.parse("26/12/2012"), 343800);
		cutebunnies33.getGestor().registrarReproduccion(thesimpsonsS1E11,
				format.parse("4/7/2012"), 287400);
		cutebunnies33.getGestor().registrarReproduccion(whatjusthappened,
				format.parse("12/6/2012"), 231000);
		cutebunnies33.getGestor().registrarReproduccion(thesimpsonsS1E12,
				format.parse("14/7/2013"), 309000);
		cutebunnies33.getGestor().registrarReproduccion(borntowin,
				format.parse("12/6/2012"), 423000);
		cutebunnies33.getGestor().registrarReproduccion(barneyS1E16,
				format.parse("7/4/2013"), 301800);
		cutebunnies33.getGestor().registrarReproduccion(thesimpsonsS1E2,
				format.parse("12/6/2012"), 310200);
		cutebunnies33.getGestor().registrarReproduccion(newyearseve,
				format.parse("17/8/2013"), 253800);
		cutebunnies33.getGestor().registrarReproduccion(frankenstein,
				format.parse("22/10/2013"), 326400);
		cutebunnies33.getGestor().registrarReproduccion(barneyS1E30,
				format.parse("12/6/2012"), 312600);
		cutebunnies33.getGestor().registrarReproduccion(threewiseguys,
				format.parse("12/6/2012"), 343200);
		cutebunnies33.getGestor().registrarReproduccion(jackiebrown,
				format.parse("12/6/2012"), 111600);
		cutebunnies33.getGestor().registrarReproduccion(midnightrun,
				format.parse("15/10/2013"), 360000);
		cutebunnies33.getGestor().registrarReproduccion(stardust,
				format.parse("12/6/2012"), 257400);
		cutebunnies33.getGestor().registrarReproduccion(goodfellas,
				format.parse("24/11/2013"), 154800);
		cutebunnies33.getGestor().registrarReproduccion(jenniferonmymind,
				format.parse("19/1/2013"), 98400);
		cutebunnies33.getGestor().registrarReproduccion(barneyS1E7,
				format.parse("13/7/2012"), 336000);
		cutebunnies33.getGestor().registrarReproduccion(
				thegangthatcouldntshootstraight, format.parse("19/9/2013"),
				161400);
		cutebunnies33.getGestor().registrarReproduccion(barneyS1E15,
				format.parse("24/11/2013"), 360000);
		cutebunnies33.getGestor().registrarReproduccion(thesimpsonsS1E1,
				format.parse("12/6/2012"), 332400);
		cutebunnies33.getGestor().registrarReproduccion(redlights,
				format.parse("17/8/2013"), 322200);
		cutebunnies33.getGestor().registrarReproduccion(onehundredandonenights,
				format.parse("22/10/2013"), 136800);
		cutebunnies33.getGestor().registrarReproduccion(ragingbull,
				format.parse("27/12/2012"), 209400);
		cutebunnies33.getGestor().registrarReproduccion(barneyS1E6,
				format.parse("12/6/2012"), 153000);
		sitio.registrarUsuario(cutebunnies33);
		Usuario bbc1uk = new Usuario(format.parse("23/11/2005"),
				"bbc1uk@hotmail.com", format.parse("11/6/2011"), catalogo);
		bbc1uk.getSuscripcion().pasarANormal();
		bbc1uk.getGestor().registrarReproduccion(thedeerhunter,
				format.parse("28/1/2012"), 426600);
		bbc1uk.getGestor().registrarReproduccion(threewiseguys,
				format.parse("15/7/2013"), 148800);
		bbc1uk.getGestor().registrarReproduccion(theweddingparty,
				format.parse("20/9/2013"), 175800);
		bbc1uk.getGestor().registrarReproduccion(barneyS1E20,
				format.parse("8/4/2012"), 354600);
		bbc1uk.getGestor().registrarReproduccion(nightandthecity,
				format.parse("13/6/2013"), 404400);
		bbc1uk.getGestor().registrarReproduccion(taxidriver,
				format.parse("18/1/2013"), 431400);
		bbc1uk.getGestor().registrarReproduccion(barneyS1E11,
				format.parse("6/3/2012"), 307200);
		bbc1uk.getGestor().registrarReproduccion(marvinsroom,
				format.parse("11/5/2012"), 309600);
		bbc1uk.getGestor().registrarReproduccion(themission,
				format.parse("26/12/2013"), 336600);
		bbc1uk.getGestor().registrarReproduccion(barneyS1E1,
				format.parse("21/10/2013"), 188400);
		bbc1uk.getGestor().registrarReproduccion(brazil,
				format.parse("27/12/2012"), 344400);
		bbc1uk.getGestor().registrarReproduccion(thesimpsonsS1E11,
				format.parse("4/2/2012"), 241800);
		bbc1uk.getGestor().registrarReproduccion(stardust,
				format.parse("9/5/2012"), 397800);
		bbc1uk.setSesion(new Sesion(new Reproduccion(thegoodshepherd, format
				.parse("9/2/2014"), 273600), format.parse("9/2/2014")));
		sitio.registrarUsuario(bbc1uk);
		Usuario ambassadorerencemcculleyp = new Usuario(
				format.parse("26/12/1940"),
				"ambassadorerencemcculleyp@gmail.com",
				format.parse("15/7/2012"), catalogo);
		ambassadorerencemcculleyp.getSuscripcion().pasarAVIP();
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				thesimpsonsS1E13, format.parse("15/7/2012"), 333000);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				thegoodshepherd, format.parse("15/7/2012"), 408000);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(dragna,
				format.parse("15/7/2012"), 259200);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				arthurandtheinvisibles, format.parse("20/9/2012"), 157200);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				werenoangels, format.parse("25/11/2013"), 359400);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				thesimpsonsS1E4, format.parse("15/7/2012"), 256800);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				barneyS1E11, format.parse("8/10/2013"), 307200);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				barneyS1E27, format.parse("15/7/2012"), 322200);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(dragna,
				format.parse("15/7/2012"), 337200);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				arthurandtheinvisibles, format.parse("15/7/2012"), 539400);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				werenoangels, format.parse("15/7/2013"), 436800);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(bloodymama,
				format.parse("15/7/2012"), 463800);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(brazil,
				format.parse("27/8/2013"), 453600);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(barneyS1E2,
				format.parse("4/2/2013"), 312600);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				barneyS1E26, format.parse("15/7/2012"), 248400);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				thesimpsonsS1E12, format.parse("15/7/2012"), 284400);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				thegoodshepherd, format.parse("15/7/2012"), 486600);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(goodfellas,
				format.parse("14/7/2013"), 338400);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(himom,
				format.parse("20/9/2013"), 235800);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				barneyS1E17, format.parse("25/11/2013"), 304200);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(bloodymama,
				format.parse("15/7/2012"), 160200);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				killerelite, format.parse("18/8/2013"), 362400);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				thisboyslife, format.parse("23/10/2013"), 84600);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				newyorknewyork, format.parse("18/8/2013"), 462000);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(barneyS1E9,
				format.parse("5/11/2013"), 184200);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(barneyS1E5,
				format.parse("22/10/2013"), 211200);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				barneyS1E28, format.parse("10/12/2012"), 324000);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				billythekidmcdonnen, format.parse("15/7/2012"), 310800);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(bloodymama,
				format.parse("20/9/2013"), 138000);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				barneyS1E19, format.parse("25/12/2013"), 330600);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				thesimpsonsS1E5, format.parse("15/7/2012"), 108600);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				lasedadesdelamor, format.parse("8/8/2012"), 486000);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				maddogandglory, format.parse("23/11/2013"), 208200);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				breakingbadS1E3, format.parse("15/7/2012"), 280800);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				killingseason, format.parse("15/7/2012"), 483000);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				marvinsroom, format.parse("21/10/2013"), 205200);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(angelheart,
				format.parse("26/12/2013"), 407400);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				thesimpsonsS1E10, format.parse("3/2/2013"), 342600);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				dearamericalettershomefromvietnamtvmoviedocumentary,
				format.parse("15/7/2012"), 340800);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				nightandthecity, format.parse("13/6/2013"), 238800);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				thegodfatherpartii, format.parse("18/9/2013"), 311400);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(thefamily,
				format.parse("15/7/2012"), 513600);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(sleepers,
				format.parse("21/10/2013"), 365400);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				barneyS1E24, format.parse("26/12/2013"), 262800);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(barneyS1E2,
				format.parse("15/7/2012"), 312600);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				barneyS1E25, format.parse("15/7/2012"), 187200);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				thesimpsonsS1E12, format.parse("14/7/2013"), 259800);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(borntowin,
				format.parse("19/9/2013"), 157800);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				barneyS1E16, format.parse("15/7/2012"), 301800);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				barneyS1E25, format.parse("19/9/2012"), 82200);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				guiltybysuspicion, format.parse("14/11/2013"), 459600);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				thesimpsonsS1E7, format.parse("13/6/2013"), 313800);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(taxidriver,
				format.parse("15/7/2012"), 255000);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				barneyS1E11, format.parse("6/3/2013"), 152400);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				whatjusthappened, format.parse("15/7/2012"), 354600);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				barneyS1E26, format.parse("9/9/2013"), 252000);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				billythekidmcdonnen, format.parse("15/7/2012"), 149400);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				greatexpectations, format.parse("20/9/2013"), 527400);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(jacknife,
				format.parse("15/7/2013"), 73800);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				jackiebrown, format.parse("20/9/2012"), 276000);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				midnightrun, format.parse("25/12/2013"), 174000);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(greetings,
				format.parse("15/7/2012"), 200400);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(stone,
				format.parse("18/9/2013"), 227400);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				barneyS1E11, format.parse("15/7/2012"), 307200);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				marvinsroom, format.parse("15/7/2013"), 151800);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				thesimpsonsS1E5, format.parse("15/7/2012"), 225000);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				barneyS1E20, format.parse("15/7/2012"), 122400);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				thesimpsonsS1E6, format.parse("13/6/2013"), 195600);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(taxidriver,
				format.parse("18/8/2012"), 93000);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				nightandthecity, format.parse("13/6/2013"), 165600);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				thegodfatherpartii, format.parse("28/1/2013"), 238800);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				barneyS1E11, format.parse("23/11/2013"), 136200);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				thegodfatherpartii, format.parse("15/7/2012"), 209400);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				barneyS1E12, format.parse("15/7/2012"), 106800);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				breakingbadS1E5, format.parse("15/7/2012"), 180000);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				silverliningsplaybook, format.parse("16/8/2013"), 252600);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(barneyS1E2,
				format.parse("15/7/2012"), 150000);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(stardust,
				format.parse("15/7/2012"), 177000);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				thegodfatherpartii, format.parse("15/7/2012"), 250200);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				barneyS1E11, format.parse("15/7/2012"), 307200);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				breakingbadS1E5, format.parse("15/7/2012"), 352200);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				barneyS1E24, format.parse("7/8/2012"), 331200);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(abronxtale,
				format.parse("15/7/2012"), 508200);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				thedeerhunter, format.parse("17/1/2013"), 405600);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(barneyS1E8,
				format.parse("23/10/2013"), 300000);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				breakingbadS1E1, format.parse("15/7/2012"), 337800);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(lastvegas,
				format.parse("15/7/2013"), 273600);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(wagthedog,
				format.parse("21/10/2013"), 171600);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				barneyS1E22, format.parse("26/12/2013"), 69000);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				thesimpsonsS1E8, format.parse("15/7/2012"), 141600);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				barneyS1E23, format.parse("8/4/2013"), 307200);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				barneyS1E11, format.parse("23/3/2013"), 307200);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				breakingbadS1E5, format.parse("15/7/2012"), 185400);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(themission,
				format.parse("16/12/2013"), 387600);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				thesimpsonsS1E11, format.parse("15/7/2012"), 156000);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				barneyS1E25, format.parse("15/7/2012"), 333600);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(awakenings,
				format.parse("14/7/2013"), 80400);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(borntowin,
				format.parse("19/9/2012"), 153000);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(redlights,
				format.parse("15/7/2012"), 530400);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				onehundredandonenights, format.parse("15/7/2012"), 123600);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(ragingbull,
				format.parse("27/12/2012"), 501000);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				billythekidmcdonnen, format.parse("15/7/2012"), 94200);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				greatexpectations, format.parse("15/7/2012"), 471600);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(jacknife,
				format.parse("15/7/2013"), 193800);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				breakingbadS1E7, format.parse("11/10/2012"), 340800);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				barneyS1E26, format.parse("27/12/2012"), 339600);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				thesimpsonsS1E13, format.parse("14/7/2013"), 246000);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				thegoodshepherd, format.parse("9/9/2013"), 494400);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(jacknife,
				format.parse("15/7/2012"), 179400);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(copland,
				format.parse("21/10/2013"), 77400);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				theuntouchables, format.parse("26/12/2013"), 454800);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				thesimpsonsS1E9, format.parse("15/7/2012"), 223200);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				everybodysfine, format.parse("19/9/2012"), 120600);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(backdraft,
				format.parse("24/11/2013"), 322800);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				bangthedrumslowly, format.parse("19/9/2013"), 395400);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				barneyS1E14, format.parse("6/3/2013"), 357600);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				breakingbadS1E7, format.parse("15/7/2012"), 61200);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(beingflynn,
				format.parse("18/1/2013"), 134400);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(angelheart,
				format.parse("16/8/2013"), 511800);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				barneyS1E12, format.parse("15/7/2012"), 331200);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(barneyS1E2,
				format.parse("21/10/2013"), 307200);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				barneyS1E26, format.parse("27/12/2012"), 204600);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				thesimpsonsS1E12, format.parse("15/7/2012"), 309000);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(stardust,
				format.parse("19/9/2012"), 175200);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(goodfellas,
				format.parse("25/11/2013"), 377400);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				thesimpsonsS1E3, format.parse("15/7/2012"), 145800);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				newyearseve, format.parse("15/7/2012"), 218400);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				frankenstein, format.parse("12/10/2013"), 420600);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				thedeerhunter, format.parse("15/7/2012"), 493800);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				threewiseguys, format.parse("15/7/2012"), 391200);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				jackiebrown, format.parse("10/9/2013"), 464400);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				jenniferonmymind, format.parse("19/9/2013"), 537000);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				barneyS1E16, format.parse("25/11/2013"), 78600);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(himom,
				format.parse("15/7/2012"), 502200);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				newyearseve, format.parse("15/7/2012"), 95400);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				thesimpsonsS1E4, format.parse("15/7/2012"), 323400);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				killerelite, format.parse("18/8/2013"), 416400);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				thisboyslife, format.parse("23/10/2013"), 489600);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				newyorknewyork, format.parse("18/8/2013"), 257400);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(barneyS1E9,
				format.parse("5/11/2013"), 155400);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				breakingbadS1E2, format.parse("15/7/2012"), 99000);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				killingseason, format.parse("16/7/2013"), 171600);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(copland,
				format.parse("15/7/2012"), 69000);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(angelheart,
				format.parse("26/12/2013"), 142200);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(himom,
				format.parse("5/11/2013"), 390600);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				lasedadesdelamor, format.parse("10/6/2013"), 463200);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(capefear,
				format.parse("16/9/2012"), 536400);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				thesimpsonsS1E1, format.parse("15/7/2012"), 304800);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				thedeerhunter, format.parse("15/7/2012"), 377400);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(lastvegas,
				format.parse("8/1/2013"), 145800);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(sleepers,
				format.parse("15/7/2012"), 348000);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				thekingofcomedy, format.parse("20/10/2013"), 421200);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				threewiseguys, format.parse("25/1/2013"), 493800);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				breakingbadS1E3, format.parse("3/3/2013"), 262200);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(brazil,
				format.parse("15/7/2012"), 159600);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(barneyS1E5,
				format.parse("25/8/2012"), 325800);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				barneyS1E30, format.parse("2/11/2013"), 130200);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				killingseason, format.parse("18/10/2013"), 203400);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(backdraft,
				format.parse("15/7/2012"), 405600);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				jenniferonmymind, format.parse("22/7/2012"), 173400);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				barneyS1E19, format.parse("28/9/2013"), 246600);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(angelheart,
				format.parse("15/7/2012"), 144000);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(barneyS1E3,
				format.parse("24/8/2012"), 217200);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				trueconfessions, format.parse("15/7/2012"), 289800);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(barneyS1E8,
				format.parse("26/1/2013"), 300000);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				breakingbadS1E4, format.parse("3/11/2013"), 131400);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				fallinginlove, format.parse("19/6/2013"), 379200);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				frankenstein, format.parse("15/7/2012"), 101400);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				thelasttycoon, format.parse("15/7/2012"), 349800);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				barneyS1E11, format.parse("26/9/2012"), 307200);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				breakingbadS1E7, format.parse("15/7/2012"), 191400);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				arthurandtheinvisibles, format.parse("12/7/2013"), 135000);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				midnightrun, format.parse("18/7/2013"), 207600);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(stardust,
				format.parse("2/1/2013"), 105000);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				barneyS1E16, format.parse("7/11/2013"), 301800);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				onehundredandonenights, format.parse("15/7/2012"), 426600);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(ragingbull,
				format.parse("17/8/2013"), 499200);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(barneyS1E6,
				format.parse("5/10/2013"), 92400);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				barneyS1E30, format.parse("15/7/2012"), 312600);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				threewiseguys, format.parse("15/7/2012"), 413400);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				jackiebrown, format.parse("10/9/2012"), 486600);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				midnightrun, format.parse("15/7/2013"), 79200);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				thesimpsonsS1E7, format.parse("11/10/2013"), 313800);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				bangthedrumslowly, format.parse("1/6/2013"), 271200);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				thesimpsonsS1E9, format.parse("14/11/2013"), 264600);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(goodfellas,
				format.parse("17/5/2013"), 300600);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				americanhustle, format.parse("26/8/2012"), 244200);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				righteouskill, format.parse("15/7/2012"), 492600);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				thesimpsonsS1E3, format.parse("22/2/2013"), 358800);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(sleepers,
				format.parse("3/7/2013"), 333600);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(thefan,
				format.parse("15/7/2012"), 406200);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(borntowin,
				format.parse("1/6/2013"), 174600);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				barneyS1E18, format.parse("5/7/2013"), 328200);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				nightandthecity, format.parse("5/3/2013"), 191400);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				thesimpsonsS1E8, format.parse("24/11/2013"), 310200);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(sleepers,
				format.parse("3/7/2013"), 512400);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				breakingbadS1E6, format.parse("22/10/2012"), 151800);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				breakingbadS1E7, format.parse("22/2/2013"), 95400);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				thesimpsonsS1E2, format.parse("12/10/2012"), 357000);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(himom,
				format.parse("15/7/2012"), 157800);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				thedeerhunter, format.parse("10/9/2013"), 406200);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(ilimitless,
				format.parse("15/7/2012"), 174600);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				barneyS1E21, format.parse("18/9/2012"), 247200);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(angelheart,
				format.parse("26/12/2012"), 495600);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				barneyS1E12, format.parse("6/8/2013"), 264000);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				thesimpsonsS1E11, format.parse("24/11/2012"), 207600);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(barneyS1E3,
				format.parse("4/2/2013"), 360000);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				jenniferonmymind, format.parse("12/6/2013"), 399600);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				extrastvseries, format.parse("15/7/2012"), 518400);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				thedeerhunter, format.parse("10/9/2013"), 286800);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				lasedadesdelamor, format.parse("27/9/2013"), 230400);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				thedeerhunter, format.parse("15/7/2012"), 478800);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				barneyS1E20, format.parse("8/8/2012"), 247200);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				dearamericalettershomefromvietnamtvmoviedocumentary,
				format.parse("26/12/2012"), 466800);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				barneyS1E11, format.parse("16/8/2013"), 69000);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				thesimpsonsS1E9, format.parse("24/11/2012"), 187800);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(barneyS1E2,
				format.parse("4/7/2013"), 312600);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(casino,
				format.parse("22/10/2012"), 333600);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				thisboyslife, format.parse("13/6/2013"), 277200);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(encounter,
				format.parse("3/6/2013"), 350400);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				barneyS1E25, format.parse("15/7/2012"), 118800);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				thesimpsonsS1E12, format.parse("15/7/2012"), 62400);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(stardust,
				format.parse("19/9/2013"), 135000);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(goodfellas,
				format.parse("25/8/2013"), 208200);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				thesimpsonsS1E11, format.parse("14/7/2013"), 327000);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(borntowin,
				format.parse("1/1/2013"), 95400);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				barneyS1E15, format.parse("15/7/2012"), 360000);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				onehundredandonenights, format.parse("15/7/2012"), 213000);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				trueconfessions, format.parse("27/12/2012"), 156600);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				billythekidmcdonnen, format.parse("15/7/2012"), 275400);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				barneyS1E29, format.parse("15/7/2012"), 219000);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(jacknife,
				format.parse("15/7/2013"), 292200);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(samssong,
				format.parse("20/9/2013"), 331800);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				midnightrun, format.parse("25/12/2013"), 275400);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				thesimpsonsS1E6, format.parse("15/7/2012"), 349800);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(stone,
				format.parse("15/7/2012"), 467400);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				nightandthecity, format.parse("15/7/2012"), 411000);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				thesimpsonsS1E5, format.parse("15/7/2012"), 347400);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				lasedadesdelamor, format.parse("18/8/2013"), 168600);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(barneyS1E9,
				format.parse("23/11/2013"), 75600);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				breakingbadS1E3, format.parse("15/7/2012"), 203400);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				killingseason, format.parse("16/7/2013"), 331200);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				marvinsroom, format.parse("21/10/2012"), 413400);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(angelheart,
				format.parse("16/8/2013"), 357000);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(sleepers,
				format.parse("21/10/2013"), 429600);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(themission,
				format.parse("26/12/2012"), 198000);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				thesimpsonsS1E11, format.parse("15/7/2012"), 316800);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				whatjusthappened, format.parse("15/7/2012"), 260400);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(awakenings,
				format.parse("24/11/2013"), 333600);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(borntowin,
				format.parse("19/9/2013"), 277200);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				thegangthatcouldntshootstraight, format.parse("15/7/2012"),
				91800);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				freelancers, format.parse("17/8/2013"), 515400);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(barneyS1E4,
				format.parse("22/10/2013"), 323400);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				barneyS1E27, format.parse("27/12/2012"), 226800);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(dragna,
				format.parse("15/7/2012"), 300000);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				arthurandtheinvisibles, format.parse("15/7/2012"), 418800);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				werenoangels, format.parse("15/11/2013"), 362400);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				thesimpsonsS1E4, format.parse("15/7/2012"), 323400);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(lastvegas,
				format.parse("26/12/2013"), 120600);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(sleepers,
				format.parse("21/10/2012"), 193800);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(themission,
				format.parse("26/12/2013"), 441600);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(barneyS1E2,
				format.parse("15/7/2012"), 312600);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				whatjusthappened, format.parse("15/7/2012"), 504600);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				thesimpsonsS1E12, format.parse("15/7/2012"), 143400);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(sleepers,
				format.parse("21/10/2013"), 216600);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				barneyS1E24, format.parse("15/7/2012"), 160200);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				thesimpsonsS1E11, format.parse("14/7/2013"), 344400);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				thegangthatcouldntshootstraight, format.parse("15/7/2012"),
				268800);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				barneyS1E15, format.parse("15/7/2012"), 212400);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				thesimpsonsS1E1, format.parse("12/10/2012"), 332400);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				trueconfessions, format.parse("27/12/2012"), 145800);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(barneyS1E5,
				format.parse("15/7/2012"), 264600);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				extrastvseries, format.parse("15/7/2012"), 79200);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				werenoangels, format.parse("15/7/2013"), 198000);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(samssong,
				format.parse("20/9/2013"), 141600);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(jacknife,
				format.parse("25/12/2013"), 390000);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				threeroomsinmanhattan, format.parse("15/7/2012"), 115800);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(encounter,
				format.parse("15/7/2012"), 539400);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(sleepers,
				format.parse("21/10/2013"), 132600);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				barneyS1E25, format.parse("15/7/2012"), 76200);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				thesimpsonsS1E11, format.parse("15/7/2012"), 66000);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(borntowin,
				format.parse("19/1/2013"), 489600);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				barneyS1E15, format.parse("15/7/2012"), 128400);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(greetings,
				format.parse("5/12/2013"), 376800);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				everybodysfine, format.parse("7/12/2013"), 320400);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(samssong,
				format.parse("23/7/2012"), 439200);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				barneyS1E22, format.parse("18/9/2013"), 343200);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				barneyS1E11, format.parse("15/7/2012"), 307200);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				thesimpsonsS1E12, format.parse("24/11/2012"), 141000);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(barneyS1E7,
				format.parse("15/7/2012"), 259800);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				bangthedrumslowly, format.parse("22/7/2012"), 379200);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(redlights,
				format.parse("9/2/2013"), 498000);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(barneyS1E8,
				format.parse("25/8/2013"), 300000);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				marvinsroom, format.parse("13/3/2013"), 80400);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				fallinginlove, format.parse("1/10/2013"), 199800);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				billythekidmcdonnen, format.parse("7/1/2013"), 318600);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				jackiebrown, format.parse("15/7/2012"), 437400);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				barneyS1E23, format.parse("1/10/2013"), 76800);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(barneyS1E3,
				format.parse("24/12/2013"), 360000);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				extrastvseries, format.parse("2/3/2013"), 490200);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(lastvegas,
				format.parse("15/7/2012"), 129000);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(sleepers,
				format.parse("24/8/2012"), 72600);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				fallinginlove, format.parse("19/6/2013"), 496200);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				breakingbadS1E2, format.parse("3/11/2013"), 301800);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(themission,
				format.parse("15/7/2012"), 429600);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(barneyS1E3,
				format.parse("24/8/2013"), 360000);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				barneyS1E29, format.parse("2/10/2013"), 348600);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(lastvegas,
				format.parse("15/7/2012"), 306600);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(sleepers,
				format.parse("15/7/2012"), 75000);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				thekingofcomedy, format.parse("15/7/2012"), 369600);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				threewiseguys, format.parse("25/8/2013"), 183600);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				breakingbadS1E2, format.parse("3/11/2013"), 301800);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				thebigwedding, format.parse("9/1/2013"), 468000);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				thesimpsonsS1E1, format.parse("15/7/2012"), 282000);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				thedeerhunter, format.parse("15/7/2012"), 96600);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				barneyS1E22, format.parse("15/7/2012"), 215400);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(mistress,
				format.parse("15/7/2012"), 504600);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				barneyS1E10, format.parse("5/11/2013"), 304800);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(taxidriver,
				format.parse("28/1/2013"), 438000);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				barneyS1E11, format.parse("23/11/2013"), 76800);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				righteouskill, format.parse("15/7/2012"), 195600);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				thesimpsonsS1E4, format.parse("15/7/2012"), 185400);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(
				barneyS1E18, format.parse("15/7/2012"), 129000);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(abronxtale,
				format.parse("12/6/2013"), 423600);
		ambassadorerencemcculleyp.getGestor().registrarReproduccion(ilimitless,
				format.parse("18/8/2013"), 62400);
		ambassadorerencemcculleyp.setSesion(new Sesion(new Reproduccion(
				machete, format.parse("18/3/2014"), 252000), format
				.parse("18/3/2014")));
		sitio.registrarUsuario(ambassadorerencemcculleyp);
		Usuario olivarifa = new Usuario(format.parse("19/9/1993"),
				"olivarifa@gmail.com", format.parse("7/4/2011"), catalogo);
		olivarifa.getSuscripcion().pasarANormal();
		olivarifa.getGestor().registrarReproduccion(guiltybysuspicion,
				format.parse("24/7/2013"), 294000);
		olivarifa.getGestor().registrarReproduccion(borntowin,
				format.parse("19/9/2013"), 321000);
		olivarifa.getGestor().registrarReproduccion(barneyS1E15,
				format.parse("7/10/2013"), 360000);
		olivarifa.getGestor().registrarReproduccion(stardust,
				format.parse("9/5/2012"), 512400);
		olivarifa.getGestor().registrarReproduccion(thesimpsonsS1E12,
				format.parse("14/7/2013"), 309000);
		olivarifa.getGestor().registrarReproduccion(jenniferonmymind,
				format.parse("19/9/2013"), 307800);
		olivarifa.getGestor().registrarReproduccion(barneyS1E16,
				format.parse("7/4/2013"), 301800);
		olivarifa.getGestor().registrarReproduccion(thesimpsonsS1E3,
				format.parse("12/6/2012"), 103200);
		olivarifa.getGestor().registrarReproduccion(newyearseve,
				format.parse("17/8/2013"), 268200);
		olivarifa.getGestor().registrarReproduccion(barneyS1E7,
				format.parse("23/10/2013"), 294600);
		olivarifa.getGestor().registrarReproduccion(thedeerhunter,
				format.parse("28/1/2012"), 321600);
		olivarifa.getGestor().registrarReproduccion(americanhustle,
				format.parse("15/3/2012"), 523800);
		olivarifa.getGestor().registrarReproduccion(jackiebrown,
				format.parse("10/9/2012"), 70800);
		olivarifa.getGestor().registrarReproduccion(
				dearamericalettershomefromvietnamtvmoviedocumentary,
				format.parse("15/7/2013"), 235800);
		olivarifa.getGestor().registrarReproduccion(greetings,
				format.parse("21/10/2013"), 87600);
		olivarifa.getGestor().registrarReproduccion(barneyS1E22,
				format.parse("26/12/2013"), 114000);
		olivarifa.getGestor().registrarReproduccion(barneyS1E8,
				format.parse("5/3/2013"), 141000);
		olivarifa.getGestor().registrarReproduccion(breakingbadS1E1,
				format.parse("10/1/2012"), 337800);
		olivarifa.getGestor().registrarReproduccion(lastvegas,
				format.parse("15/7/2012"), 240600);
		olivarifa.getGestor().registrarReproduccion(wagthedog,
				format.parse("21/5/2013"), 267600);
		olivarifa.getGestor().registrarReproduccion(theuntouchables,
				format.parse("26/12/2013"), 294600);
		olivarifa.getGestor().registrarReproduccion(thesimpsonsS1E8,
				format.parse("3/2/2012"), 192000);
		olivarifa.getGestor().registrarReproduccion(barneyS1E23,
				format.parse("8/4/2012"), 307200);
		olivarifa.getGestor().registrarReproduccion(capefear,
				format.parse("14/7/2013"), 246000);
		olivarifa.getGestor().registrarReproduccion(bangthedrumslowly,
				format.parse("19/1/2013"), 143400);
		olivarifa.getGestor().registrarReproduccion(backdraft,
				format.parse("24/11/2013"), 299400);
		olivarifa.getGestor().registrarReproduccion(
				thegangthatcouldntshootstraight, format.parse("1/1/2012"),
				372600);
		olivarifa.getGestor().registrarReproduccion(barneyS1E14,
				format.parse("6/3/2012"), 357600);
		olivarifa.getGestor().registrarReproduccion(thesimpsonsS1E1,
				format.parse("12/6/2012"), 297000);
		olivarifa.getGestor().registrarReproduccion(beingflynn,
				format.parse("4/7/2013"), 499200);
		olivarifa.getGestor().registrarReproduccion(borntowin,
				format.parse("1/1/2013"), 525600);
		olivarifa.getGestor().registrarReproduccion(barneyS1E15,
				format.parse("7/4/2012"), 247800);
		olivarifa.getGestor().registrarReproduccion(onehundredandonenights,
				format.parse("12/6/2012"), 128400);
		olivarifa.getGestor().registrarReproduccion(trueconfessions,
				format.parse("27/12/2012"), 330600);
		olivarifa.getGestor().registrarReproduccion(billythekidmcdonnen,
				format.parse("4/3/2012"), 228600);
		olivarifa.getGestor().registrarReproduccion(extrastvseries,
				format.parse("20/9/2012"), 126000);
		olivarifa.getGestor().registrarReproduccion(jacknife,
				format.parse("25/7/2013"), 457200);
		olivarifa.getGestor().registrarReproduccion(samssong,
				format.parse("20/9/2012"), 484200);
		olivarifa.setSesion(new Sesion(new Reproduccion(goodfellas, format
				.parse("25/3/2014"), 360000), format.parse("25/3/2014")));
		sitio.registrarUsuario(olivarifa);
		Usuario greensilas608 = new Usuario(format.parse("21/10/1999"),
				"greensilas608@gmail.com", format.parse("27/12/2011"), catalogo);
		greensilas608.getSuscripcion().pasarANormal();
		greensilas608.getGestor().registrarReproduccion(freelancers,
				format.parse("6/3/2012"), 485400);
		greensilas608.getGestor().registrarReproduccion(heat,
				format.parse("11/6/2012"), 336600);
		greensilas608.getGestor().registrarReproduccion(thekingofcomedy,
				format.parse("17/10/2013"), 363600);
		greensilas608.getGestor().registrarReproduccion(whatjusthappened,
				format.parse("9/4/2012"), 85800);
		greensilas608.getGestor().registrarReproduccion(guiltybysuspicion,
				format.parse("24/11/2013"), 112800);
		greensilas608.getGestor().registrarReproduccion(thesimpsonsS1E1,
				format.parse("1/1/2012"), 332400);
		greensilas608.getGestor().registrarReproduccion(beingflynn,
				format.parse("7/4/2012"), 212400);
		greensilas608.getGestor().registrarReproduccion(onehundredandonenights,
				format.parse("22/10/2012"), 414600);
		greensilas608.getGestor().registrarReproduccion(trueconfessions,
				format.parse("27/12/2012"), 441600);
		greensilas608.getGestor().registrarReproduccion(billythekidmcdonnen,
				format.parse("5/3/2012"), 163800);
		greensilas608.setSesion(new Sesion(new Reproduccion(capefear, format
				.parse("13/2/2014"), 168600), format.parse("13/2/2014")));
		sitio.registrarUsuario(greensilas608);
		Usuario neetuguptang = new Usuario(format.parse("23/3/2005"),
				"neetuguptang@xbmail.com", format.parse("1/1/2011"), catalogo);
		neetuguptang.getSuscripcion().pasarANormal();
		neetuguptang.getGestor().registrarReproduccion(stardust,
				format.parse("1/1/2012"), 523200);
		neetuguptang.getGestor().registrarReproduccion(stanleyiris,
				format.parse("25/11/2013"), 420600);
		neetuguptang.getGestor().registrarReproduccion(thesimpsonsS1E4,
				format.parse("2/2/2012"), 318000);
		neetuguptang.getGestor().registrarReproduccion(killerelite,
				format.parse("7/4/2013"), 345000);
		neetuguptang.getGestor().registrarReproduccion(abronxtale,
				format.parse("23/10/2013"), 372000);
		neetuguptang.getGestor().registrarReproduccion(thedeerhunter,
				format.parse("28/1/2012"), 94200);
		neetuguptang.getGestor().registrarReproduccion(americanhustle,
				format.parse("5/7/2012"), 512400);
		neetuguptang.getGestor().registrarReproduccion(jackiebrown,
				format.parse("20/9/2013"), 234600);
		neetuguptang.getGestor().registrarReproduccion(barneyS1E21,
				format.parse("26/12/2013"), 261600);
		neetuguptang.getGestor().registrarReproduccion(thesimpsonsS1E7,
				format.parse("3/2/2012"), 159000);
		neetuguptang.getGestor().registrarReproduccion(machete,
				format.parse("18/9/2013"), 490200);
		neetuguptang.getGestor().registrarReproduccion(barneyS1E11,
				format.parse("6/3/2013"), 307200);
		neetuguptang.getGestor().registrarReproduccion(breakingbadS1E5,
				format.parse("11/5/2012"), 110400);
		neetuguptang.getGestor().registrarReproduccion(thebigwedding,
				format.parse("16/8/2012"), 312600);
		neetuguptang.getGestor().registrarReproduccion(thefan,
				format.parse("11/6/2012"), 339000);
		neetuguptang.getGestor().registrarReproduccion(brazil,
				format.parse("27/12/2012"), 495600);
		neetuguptang.getGestor().registrarReproduccion(barneyS1E3,
				format.parse("22/10/2012"), 217800);
		neetuguptang.getGestor().registrarReproduccion(silverliningsplaybook,
				format.parse("16/8/2013"), 420000);
		neetuguptang.getGestor().registrarReproduccion(heat,
				format.parse("22/10/2013"), 271200);
		neetuguptang.getGestor().registrarReproduccion(fallinginlove,
				format.parse("27/8/2013"), 473400);
		neetuguptang.getGestor().registrarReproduccion(barneyS1E4,
				format.parse("22/10/2013"), 323400);
		neetuguptang.getGestor().registrarReproduccion(thegoodshepherd,
				format.parse("9/5/2012"), 139200);
		neetuguptang.getGestor().registrarReproduccion(stanleyiris,
				format.parse("15/7/2013"), 516600);
		neetuguptang.getGestor().registrarReproduccion(arthurandtheinvisibles,
				format.parse("20/9/2013"), 238800);
		neetuguptang.getGestor().registrarReproduccion(werenoangels,
				format.parse("25/11/2013"), 441000);
		neetuguptang.getGestor().registrarReproduccion(bloodymama,
				format.parse("2/2/2012"), 468000);
		neetuguptang.getGestor().registrarReproduccion(ilimitless,
				format.parse("18/8/2012"), 495000);
		neetuguptang.getGestor().registrarReproduccion(barneyS1E8,
				format.parse("23/11/2013"), 300000);
		neetuguptang.getGestor().registrarReproduccion(breakingbadS1E2,
				format.parse("28/1/2013"), 114600);
		neetuguptang.getGestor().registrarReproduccion(barneyS1E9,
				format.parse("5/3/2012"), 141600);
		neetuguptang.getGestor().registrarReproduccion(copland,
				format.parse("4/7/2012"), 343800);
		neetuguptang.getGestor().registrarReproduccion(himom,
				format.parse("2/2/2012"), 241200);
		neetuguptang.getGestor().registrarReproduccion(killerelite,
				format.parse("7/8/2012"), 268200);
		neetuguptang.getGestor().registrarReproduccion(abronxtale,
				format.parse("12/6/2012"), 295200);
		neetuguptang.getGestor().registrarReproduccion(newyorknewyork,
				format.parse("28/1/2012"), 367800);
		neetuguptang.getGestor().registrarReproduccion(americanhustle,
				format.parse("5/3/2012"), 90000);
		neetuguptang.getGestor().registrarReproduccion(wagthedog,
				format.parse("21/10/2012"), 292200);
		neetuguptang.getGestor().registrarReproduccion(
				dearamericalettershomefromvietnamtvmoviedocumentary,
				format.parse("26/12/2013"), 282000);
		neetuguptang.getGestor().registrarReproduccion(threeroomsinmanhattan,
				format.parse("3/2/2013"), 355200);
		neetuguptang.getGestor().registrarReproduccion(barneyS1E22,
				format.parse("26/12/2012"), 77400);
		neetuguptang.getGestor().registrarReproduccion(thesimpsonsS1E9,
				format.parse("3/6/2012"), 340200);
		neetuguptang.getGestor().registrarReproduccion(meanstreets,
				format.parse("19/9/2013"), 481800);
		neetuguptang.getGestor().registrarReproduccion(barneyS1E13,
				format.parse("6/3/2012"), 204000);
		neetuguptang.getGestor().registrarReproduccion(thefan,
				format.parse("11/9/2013"), 230400);
		neetuguptang.getGestor().registrarReproduccion(silverliningsplaybook,
				format.parse("16/8/2013"), 432600);
		neetuguptang.getGestor().registrarReproduccion(thefan,
				format.parse("21/10/2012"), 154800);
		neetuguptang.setSesion(new Sesion(new Reproduccion(barneyS1E10, format
				.parse("23/3/2014"), 169200), format.parse("23/3/2014")));
		sitio.registrarUsuario(neetuguptang);
		Usuario officemail01office10 = new Usuario(format.parse("12/6/1976"),
				"office.mail01office10@aol.fr", format.parse("18/12/2012"),
				catalogo);
		officemail01office10.getSuscripcion().pasarAVIP();
		officemail01office10.getGestor().registrarReproduccion(thebigwedding,
				format.parse("18/12/2012"), 201000);
		officemail01office10.getGestor().registrarReproduccion(thefan,
				format.parse("21/10/2013"), 403200);
		officemail01office10.getGestor().registrarReproduccion(barneyS1E25,
				format.parse("27/12/2012"), 333600);
		officemail01office10.getGestor().registrarReproduccion(barneyS1E3,
				format.parse("18/12/2012"), 336600);
		officemail01office10.getGestor().registrarReproduccion(stardust,
				format.parse("18/12/2012"), 538800);
		officemail01office10.getGestor().registrarReproduccion(goodfellas,
				format.parse("14/7/2013"), 436200);
		officemail01office10.getGestor().registrarReproduccion(
				jenniferonmymind, format.parse("19/1/2013"), 218400);
		officemail01office10.getGestor().registrarReproduccion(barneyS1E17,
				format.parse("25/11/2013"), 291000);
		officemail01office10.getGestor().registrarReproduccion(thesimpsonsS1E3,
				format.parse("18/12/2012"), 358800);
		officemail01office10.getGestor().registrarReproduccion(barneyS1E17,
				format.parse("18/12/2012"), 304200);
		officemail01office10.getGestor().registrarReproduccion(frankenstein,
				format.parse("18/12/2012"), 159000);
		officemail01office10.getGestor().registrarReproduccion(thedeerhunter,
				format.parse("18/12/2012"), 232200);
		officemail01office10.getGestor().registrarReproduccion(ilimitless,
				format.parse("18/8/2013"), 129600);
		officemail01office10.getGestor().registrarReproduccion(barneyS1E9,
				format.parse("23/11/2013"), 202800);
		officemail01office10.getGestor().registrarReproduccion(breakingbadS1E2,
				format.parse("18/12/2012"), 301800);
		officemail01office10.getGestor().registrarReproduccion(killingseason,
				format.parse("18/12/2012"), 523800);
		officemail01office10.getGestor().registrarReproduccion(copland,
				format.parse("18/12/2012"), 246000);
		officemail01office10.getGestor().registrarReproduccion(angelheart,
				format.parse("16/12/2013"), 319200);
		officemail01office10.getGestor().registrarReproduccion(encounter,
				format.parse("21/10/2013"), 521400);
		officemail01office10.getGestor().registrarReproduccion(barneyS1E24,
				format.parse("18/12/2012"), 114000);
		officemail01office10.getGestor().registrarReproduccion(backdraft,
				format.parse("14/7/2013"), 141000);
		officemail01office10.getGestor().registrarReproduccion(
				thegangthatcouldntshootstraight, format.parse("18/12/2012"),
				84600);
		officemail01office10.getGestor().registrarReproduccion(breakingbadS1E5,
				format.parse("18/12/2012"), 333000);
		officemail01office10.getGestor().registrarReproduccion(barneyS1E25,
				format.parse("26/12/2012"), 333600);
		officemail01office10.getGestor().registrarReproduccion(
				thesimpsonsS1E11, format.parse("4/7/2013"), 174000);
		officemail01office10.getGestor().registrarReproduccion(borntowin,
				format.parse("19/9/2013"), 247200);
		officemail01office10.getGestor().registrarReproduccion(awakenings,
				format.parse("24/11/2013"), 449400);
		officemail01office10.getGestor().registrarReproduccion(thesimpsonsS1E2,
				format.parse("18/12/2012"), 217800);
		officemail01office10.getGestor().registrarReproduccion(redlights,
				format.parse("18/12/2012"), 290400);
		officemail01office10.getGestor().registrarReproduccion(frankenstein,
				format.parse("18/12/2012"), 492600);
		officemail01office10.getGestor().registrarReproduccion(ragingbull,
				format.parse("17/8/2013"), 390000);
		officemail01office10.getGestor().registrarReproduccion(copland,
				format.parse("18/12/2012"), 288000);
		officemail01office10.getGestor().registrarReproduccion(thekingofcomedy,
				format.parse("18/12/2012"), 360600);
		officemail01office10.getGestor().registrarReproduccion(dragna,
				format.parse("18/12/2012"), 258000);
		officemail01office10.getGestor().registrarReproduccion(
				arthurandtheinvisibles, format.parse("18/12/2012"), 331200);
		officemail01office10.getGestor().registrarReproduccion(werenoangels,
				format.parse("18/12/2012"), 403800);
		officemail01office10.getGestor().registrarReproduccion(thesimpsonsS1E3,
				format.parse("18/12/2012"), 172200);
		officemail01office10.getGestor().registrarReproduccion(killerelite,
				format.parse("17/8/2013"), 245400);
		officemail01office10.getGestor().registrarReproduccion(abronxtale,
				format.parse("23/10/2013"), 318000);
		officemail01office10.getGestor().registrarReproduccion(taxidriver,
				format.parse("28/12/2013"), 216000);
		officemail01office10.getGestor().registrarReproduccion(
				thesimpsonsS1E10, format.parse("18/12/2012"), 342600);
		officemail01office10.getGestor().registrarReproduccion(
				bangthedrumslowly, format.parse("19/1/2013"), 232200);
		officemail01office10.getGestor().registrarReproduccion(barneyS1E14,
				format.parse("18/12/2012"), 305400);
		officemail01office10.getGestor().registrarReproduccion(breakingbadS1E7,
				format.parse("18/12/2012"), 73800);
		officemail01office10.getGestor().registrarReproduccion(thekingofcomedy,
				format.parse("17/8/2013"), 321600);
		officemail01office10.getGestor().registrarReproduccion(barneyS1E4,
				format.parse("22/10/2013"), 90000);
		officemail01office10.getGestor().registrarReproduccion(trueconfessions,
				format.parse("27/8/2013"), 163200);
		officemail01office10.getGestor().registrarReproduccion(barneyS1E5,
				format.parse("22/3/2013"), 235800);
		officemail01office10.getGestor().registrarReproduccion(barneyS1E29,
				format.parse("27/5/2013"), 309000);
		officemail01office10.getGestor().registrarReproduccion(stanleyiris,
				format.parse("15/7/2013"), 381600);
		officemail01office10.getGestor().registrarReproduccion(bloodymama,
				format.parse("20/9/2013"), 454800);
		officemail01office10.getGestor().registrarReproduccion(barneyS1E18,
				format.parse("25/4/2013"), 328200);
		officemail01office10.getGestor().registrarReproduccion(thesimpsonsS1E5,
				format.parse("18/12/2012"), 295800);
		officemail01office10.getGestor().registrarReproduccion(ilimitless,
				format.parse("18/12/2012"), 369000);
		officemail01office10.getGestor().registrarReproduccion(maddogandglory,
				format.parse("13/11/2013"), 441600);
		officemail01office10.getGestor().registrarReproduccion(thelasttycoon,
				format.parse("18/8/2013"), 514800);
		officemail01office10.getGestor().registrarReproduccion(barneyS1E10,
				format.parse("23/11/2013"), 107400);
		officemail01office10.getGestor().registrarReproduccion(taxidriver,
				format.parse("18/12/2012"), 180600);
		officemail01office10.getGestor().registrarReproduccion(barneyS1E11,
				format.parse("18/12/2012"), 307200);
		officemail01office10.getGestor().registrarReproduccion(breakingbadS1E4,
				format.parse("18/12/2012"), 136800);
		officemail01office10.getGestor().registrarReproduccion(barneyS1E12,
				format.parse("18/12/2012"), 209400);
		officemail01office10.getGestor().registrarReproduccion(sleepers,
				format.parse("18/12/2012"), 107400);
		officemail01office10.getGestor().registrarReproduccion(
				bangthedrumslowly, format.parse("18/12/2012"), 355800);
		officemail01office10.getGestor().registrarReproduccion(
				silverliningsplaybook, format.parse("16/8/2013"), 123600);
		officemail01office10.getGestor().registrarReproduccion(heat,
				format.parse("22/10/2013"), 501600);
		officemail01office10.getGestor().registrarReproduccion(barneyS1E26,
				format.parse("27/12/2012"), 94200);
		officemail01office10.getGestor().registrarReproduccion(
				thesimpsonsS1E13, format.parse("14/7/2013"), 333000);
		officemail01office10.getGestor().registrarReproduccion(thegoodshepherd,
				format.parse("19/9/2013"), 286200);
		officemail01office10.getGestor().registrarReproduccion(stanleyiris,
				format.parse("25/11/2013"), 534600);
		officemail01office10.getGestor().registrarReproduccion(himom,
				format.parse("18/12/2012"), 303000);
		officemail01office10.getGestor().registrarReproduccion(killerelite,
				format.parse("18/12/2012"), 375600);
		officemail01office10.getGestor().registrarReproduccion(thesimpsonsS1E4,
				format.parse("18/12/2012"), 144000);
		officemail01office10.getGestor().registrarReproduccion(newyorknewyork,
				format.parse("18/8/2013"), 87600);
		officemail01office10.getGestor().registrarReproduccion(thisboyslife,
				format.parse("23/11/2013"), 336000);
		officemail01office10.getGestor().registrarReproduccion(thelasttycoon,
				format.parse("18/8/2013"), 408600);
		officemail01office10.getGestor().registrarReproduccion(barneyS1E9,
				format.parse("13/11/2013"), 177000);
		officemail01office10.getGestor().registrarReproduccion(wagthedog,
				format.parse("18/12/2012"), 250200);
		officemail01office10.getGestor().registrarReproduccion(
				dearamericalettershomefromvietnamtvmoviedocumentary,
				format.parse("15/7/2013"), 461400);
		officemail01office10.getGestor().registrarReproduccion(wagthedog,
				format.parse("21/10/2013"), 534000);
		officemail01office10.getGestor().registrarReproduccion(theuntouchables,
				format.parse("26/12/2013"), 127200);
		officemail01office10.getGestor().registrarReproduccion(
				threeroomsinmanhattan, format.parse("21/10/2013"), 70800);
		officemail01office10.getGestor().registrarReproduccion(everybodysfine,
				format.parse("18/12/2012"), 143400);
		officemail01office10.getGestor().registrarReproduccion(capefear,
				format.parse("24/11/2013"), 216600);
		officemail01office10.getGestor().registrarReproduccion(breakingbadS1E6,
				format.parse("18/12/2012"), 160200);
		officemail01office10.getGestor().registrarReproduccion(freelancers,
				format.parse("16/8/2013"), 233400);
		officemail01office10.getGestor().registrarReproduccion(heat,
				format.parse("18/12/2012"), 130800);
		officemail01office10.getGestor().registrarReproduccion(fallinginlove,
				format.parse("27/12/2012"), 203400);
		officemail01office10.getGestor().registrarReproduccion(
				thesimpsonsS1E13, format.parse("18/12/2012"), 110400);
		officemail01office10.getGestor().registrarReproduccion(thegoodshepherd,
				format.parse("18/12/2012"), 183000);
		officemail01office10.getGestor().registrarReproduccion(barneyS1E28,
				format.parse("18/12/2012"), 256200);
		officemail01office10.getGestor().registrarReproduccion(
				billythekidmcdonnen, format.parse("18/12/2012"), 328800);
		officemail01office10.getGestor().registrarReproduccion(extrastvseries,
				format.parse("18/12/2012"), 97200);
		officemail01office10.getGestor().registrarReproduccion(jacknife,
				format.parse("25/12/2013"), 299400);
		officemail01office10.getGestor().registrarReproduccion(thesimpsonsS1E5,
				format.parse("18/12/2012"), 67800);
		officemail01office10.getGestor().registrarReproduccion(greetings,
				format.parse("20/10/2013"), 270000);
		officemail01office10.getGestor().registrarReproduccion(barneyS1E21,
				format.parse("26/4/2013"), 342600);
		officemail01office10.getGestor().registrarReproduccion(thesimpsonsS1E8,
				format.parse("13/6/2013"), 111000);
		officemail01office10.getGestor().registrarReproduccion(machete,
				format.parse("18/9/2013"), 313200);
		officemail01office10.getGestor().registrarReproduccion(barneyS1E12,
				format.parse("24/11/2013"), 331200);
		officemail01office10.getGestor().registrarReproduccion(breakingbadS1E5,
				format.parse("18/12/2012"), 154200);
		officemail01office10.getGestor().registrarReproduccion(brazil,
				format.parse("27/12/2013"), 356400);
		officemail01office10.getGestor().registrarReproduccion(barneyS1E2,
				format.parse("21/10/2013"), 312600);
		officemail01office10.getGestor().registrarReproduccion(barneyS1E3,
				format.parse("4/2/2013"), 327000);
		officemail01office10.getGestor().registrarReproduccion(barneyS1E26,
				format.parse("18/12/2012"), 225000);
		officemail01office10.getGestor().registrarReproduccion(barneyS1E11,
				format.parse("18/12/2012"), 297600);
		officemail01office10.getGestor().registrarReproduccion(
				whatjusthappened, format.parse("18/12/2012"), 370800);
		officemail01office10.getGestor().registrarReproduccion(
				guiltybysuspicion, format.parse("14/7/2013"), 443400);
		officemail01office10.getGestor().registrarReproduccion(borntowin,
				format.parse("19/9/2013"), 340800);
		officemail01office10.getGestor().registrarReproduccion(barneyS1E15,
				format.parse("18/12/2012"), 360000);
		officemail01office10.getGestor().registrarReproduccion(
				onehundredandonenights, format.parse("18/12/2012"), 182400);
		officemail01office10.getGestor().registrarReproduccion(trueconfessions,
				format.parse("27/12/2013"), 481800);
		officemail01office10.getGestor().registrarReproduccion(barneyS1E6,
				format.parse("22/10/2013"), 249600);
		officemail01office10.getGestor().registrarReproduccion(ragingbull,
				format.parse("18/12/2012"), 147600);
		officemail01office10.getGestor().registrarReproduccion(threewiseguys,
				format.parse("18/12/2012"), 220200);
		officemail01office10.getGestor().registrarReproduccion(
				greatexpectations, format.parse("18/12/2012"), 293400);
		officemail01office10.getGestor().registrarReproduccion(thesimpsonsS1E6,
				format.parse("13/6/2013"), 237000);
		officemail01office10.getGestor().registrarReproduccion(thelasttycoon,
				format.parse("18/12/2012"), 309600);
		officemail01office10.getGestor().registrarReproduccion(barneyS1E10,
				format.parse("5/2/2013"), 304800);
		officemail01office10.getGestor().registrarReproduccion(barneyS1E26,
				format.parse("27/12/2012"), 357600);
		officemail01office10.getGestor().registrarReproduccion(
				thesimpsonsS1E12, format.parse("14/7/2013"), 309000);
		officemail01office10.getGestor().registrarReproduccion(
				jenniferonmymind, format.parse("19/9/2013"), 167400);
		officemail01office10.getGestor().registrarReproduccion(barneyS1E16,
				format.parse("25/11/2013"), 240600);
		officemail01office10.getGestor().registrarReproduccion(himom,
				format.parse("18/12/2012"), 489000);
		officemail01office10.getGestor().registrarReproduccion(newyearseve,
				format.parse("18/12/2012"), 256800);
		officemail01office10.getGestor().registrarReproduccion(barneyS1E7,
				format.parse("23/10/2013"), 330000);
		officemail01office10.getGestor().registrarReproduccion(barneyS1E30,
				format.parse("18/12/2012"), 227400);
		officemail01office10.getGestor().registrarReproduccion(americanhustle,
				format.parse("18/12/2012"), 300600);
		officemail01office10.getGestor().registrarReproduccion(jackiebrown,
				format.parse("20/9/2013"), 373200);
		officemail01office10.getGestor().registrarReproduccion(
				dearamericalettershomefromvietnamtvmoviedocumentary,
				format.parse("18/12/2012"), 409200);
		officemail01office10.getGestor().registrarReproduccion(
				dearamericalettershomefromvietnamtvmoviedocumentary,
				format.parse("26/12/2013"), 445200);
		officemail01office10.getGestor().registrarReproduccion(
				threeroomsinmanhattan, format.parse("3/2/2013"), 388800);
		officemail01office10.getGestor().registrarReproduccion(barneyS1E22,
				format.parse("18/12/2012"), 343200);
		officemail01office10.getGestor().registrarReproduccion(capefear,
				format.parse("13/6/2013"), 534600);
		officemail01office10.getGestor().registrarReproduccion(meanstreets,
				format.parse("18/12/2012"), 127200);
		officemail01office10.getGestor().registrarReproduccion(barneyS1E13,
				format.parse("18/12/2012"), 200400);
		officemail01office10.getGestor().registrarReproduccion(thefan,
				format.parse("22/10/2013"), 97800);
		officemail01office10.getGestor().registrarReproduccion(fallinginlove,
				format.parse("27/12/2013"), 171000);
		officemail01office10.getGestor().registrarReproduccion(barneyS1E3,
				format.parse("22/2/2013"), 243600);
		officemail01office10.getGestor().registrarReproduccion(thegoodshepherd,
				format.parse("18/12/2012"), 492000);
		officemail01office10.getGestor().registrarReproduccion(goodfellas,
				format.parse("14/7/2013"), 214200);
		officemail01office10.getGestor().registrarReproduccion(
				arthurandtheinvisibles, format.parse("20/9/2013"), 462600);
		officemail01office10.getGestor().registrarReproduccion(stanleyiris,
				format.parse("18/12/2012"), 231000);
		officemail01office10.getGestor().registrarReproduccion(barneyS1E30,
				format.parse("18/12/2012"), 303600);
		officemail01office10.getGestor().registrarReproduccion(threewiseguys,
				format.parse("18/12/2012"), 72000);
		officemail01office10.getGestor().registrarReproduccion(jackiebrown,
				format.parse("18/12/2012"), 449400);
		officemail01office10.getGestor().registrarReproduccion(midnightrun,
				format.parse("15/7/2013"), 522600);
		officemail01office10.getGestor().registrarReproduccion(greetings,
				format.parse("3/10/2013"), 420000);
		officemail01office10.getGestor().registrarReproduccion(barneyS1E21,
				format.parse("26/12/2013"), 357000);
		officemail01office10.getGestor().registrarReproduccion(thesimpsonsS1E8,
				format.parse("18/12/2012"), 337800);
		officemail01office10.getGestor().registrarReproduccion(machete,
				format.parse("18/12/2012"), 472200);
		officemail01office10.getGestor().registrarReproduccion(capefear,
				format.parse("13/6/2013"), 240600);
		officemail01office10.getGestor().registrarReproduccion(meanstreets,
				format.parse("19/9/2013"), 147000);
		officemail01office10.getGestor().registrarReproduccion(barneyS1E13,
				format.parse("24/11/2013"), 220200);
		officemail01office10.getGestor().registrarReproduccion(
				bangthedrumslowly, format.parse("18/12/2012"), 468600);
		officemail01office10.getGestor().registrarReproduccion(barneyS1E14,
				format.parse("24/3/2013"), 236400);
		officemail01office10.getGestor().registrarReproduccion(
				jenniferonmymind, format.parse("18/12/2012"), 180600);
		officemail01office10.getGestor().registrarReproduccion(barneyS1E16,
				format.parse("18/12/2012"), 253200);
		officemail01office10.getGestor().registrarReproduccion(frankenstein,
				format.parse("18/12/2012"), 150600);
		officemail01office10.getGestor().registrarReproduccion(ragingbull,
				format.parse("17/1/2013"), 399000);
		officemail01office10.getGestor().registrarReproduccion(barneyS1E7,
				format.parse("18/12/2012"), 336000);
		officemail01office10.getGestor().registrarReproduccion(
				greatexpectations, format.parse("18/12/2012"), 240600);
		officemail01office10.getGestor().registrarReproduccion(thelasttycoon,
				format.parse("18/1/2013"), 272400);
		officemail01office10.getGestor().registrarReproduccion(barneyS1E9,
				format.parse("23/11/2013"), 302400);
		officemail01office10.getGestor().registrarReproduccion(breakingbadS1E3,
				format.parse("18/12/2012"), 325800);
		officemail01office10.getGestor().registrarReproduccion(killingseason,
				format.parse("16/7/2013"), 103200);
		officemail01office10.getGestor().registrarReproduccion(encounter,
				format.parse("18/12/2012"), 175800);
		officemail01office10.getGestor().registrarReproduccion(barneyS1E23,
				format.parse("18/12/2012"), 249000);
		officemail01office10.getGestor().registrarReproduccion(
				thesimpsonsS1E12, format.parse("12/10/2013"), 192600);
		officemail01office10.getGestor().registrarReproduccion(barneyS1E30,
				format.parse("18/12/2012"), 312600);
		officemail01office10.getGestor().registrarReproduccion(midnightrun,
				format.parse("15/7/2013"), 208800);
		officemail01office10.getGestor().registrarReproduccion(theweddingparty,
				format.parse("3/2/2013"), 457200);
		officemail01office10.getGestor().registrarReproduccion(barneyS1E21,
				format.parse("18/12/2012"), 225600);
		officemail01office10.getGestor().registrarReproduccion(thesimpsonsS1E7,
				format.parse("13/6/2013"), 169200);
		officemail01office10.getGestor().registrarReproduccion(machete,
				format.parse("18/9/2013"), 66600);
		officemail01office10.getGestor().registrarReproduccion(mistress,
				format.parse("23/12/2013"), 444600);
		officemail01office10.getGestor().registrarReproduccion(
				thesimpsonsS1E10, format.parse("18/12/2012"), 83400);
		officemail01office10.getGestor().registrarReproduccion(righteouskill,
				format.parse("19/9/2013"), 156600);
		officemail01office10.getGestor().registrarReproduccion(barneyS1E14,
				format.parse("6/3/2013"), 100200);
		officemail01office10.getGestor().registrarReproduccion(breakingbadS1E7,
				format.parse("18/12/2012"), 340800);
		officemail01office10.getGestor().registrarReproduccion(beingflynn,
				format.parse("18/12/2012"), 116400);
		officemail01office10.getGestor().registrarReproduccion(thesimpsonsS1E1,
				format.parse("18/12/2012"), 235800);
		officemail01office10.getGestor().registrarReproduccion(trueconfessions,
				format.parse("22/10/2013"), 308400);
		officemail01office10.getGestor().registrarReproduccion(
				arthurandtheinvisibles, format.parse("10/5/2013"), 427200);
		officemail01office10.getGestor().registrarReproduccion(werenoangels,
				format.parse("25/7/2013"), 195600);
		officemail01office10.getGestor().registrarReproduccion(bloodymama,
				format.parse("18/12/2012"), 268800);
		officemail01office10.getGestor().registrarReproduccion(barneyS1E19,
				format.parse("18/12/2012"), 212400);
		officemail01office10.getGestor().registrarReproduccion(thisboyslife,
				format.parse("13/6/2013"), 460800);
		officemail01office10.getGestor().registrarReproduccion(
				lasedadesdelamor, format.parse("18/8/2013"), 228600);
		officemail01office10.getGestor().registrarReproduccion(barneyS1E9,
				format.parse("23/11/2013"), 172800);
		officemail01office10.getGestor().registrarReproduccion(taxidriver,
				format.parse("18/8/2013"), 245400);
		officemail01office10.getGestor().registrarReproduccion(barneyS1E10,
				format.parse("18/12/2012"), 189000);
		officemail01office10.getGestor().registrarReproduccion(breakingbadS1E4,
				format.parse("18/12/2012"), 132600);
		officemail01office10.getGestor().registrarReproduccion(thefamily,
				format.parse("18/12/2012"), 381000);
		officemail01office10.getGestor().registrarReproduccion(sleepers,
				format.parse("18/12/2012"), 454200);
		officemail01office10.getGestor().registrarReproduccion(themission,
				format.parse("18/12/2012"), 222000);
		officemail01office10.getGestor().registrarReproduccion(barneyS1E15,
				format.parse("7/4/2013"), 360000);
		officemail01office10.getGestor().registrarReproduccion(thesimpsonsS1E2,
				format.parse("18/12/2012"), 357000);
		officemail01office10.getGestor().registrarReproduccion(redlights,
				format.parse("17/8/2013"), 182400);
		officemail01office10.getGestor().registrarReproduccion(barneyS1E6,
				format.parse("22/3/2013"), 264000);
		officemail01office10.getGestor().registrarReproduccion(barneyS1E29,
				format.parse("18/12/2012"), 171000);
		officemail01office10.getGestor().registrarReproduccion(threewiseguys,
				format.parse("18/12/2012"), 418800);
		officemail01office10.getGestor().registrarReproduccion(
				greatexpectations, format.parse("20/9/2013"), 129600);
		officemail01office10.getGestor().registrarReproduccion(midnightrun,
				format.parse("15/7/2013"), 73200);
		officemail01office10.getGestor().registrarReproduccion(theweddingparty,
				format.parse("20/9/2013"), 496800);
		officemail01office10.getGestor().registrarReproduccion(barneyS1E21,
				format.parse("26/12/2013"), 357000);
		officemail01office10.getGestor().registrarReproduccion(thesimpsonsS1E7,
				format.parse("18/12/2012"), 79800);
		officemail01office10.getGestor().registrarReproduccion(machete,
				format.parse("18/12/2012"), 152400);
		officemail01office10.getGestor().registrarReproduccion(mistress,
				format.parse("18/12/2012"), 400800);
		officemail01office10.getGestor().registrarReproduccion(breakingbadS1E6,
				format.parse("18/12/2012"), 126600);
		officemail01office10.getGestor().registrarReproduccion(
				silverliningsplaybook, format.parse("16/8/2013"), 421200);
		officemail01office10.getGestor().registrarReproduccion(heat,
				format.parse("22/10/2013"), 493800);
		officemail01office10.getGestor().registrarReproduccion(barneyS1E26,
				format.parse("27/12/2012"), 178800);
		officemail01office10.getGestor().registrarReproduccion(
				thesimpsonsS1E13, format.parse("4/7/2013"), 298200);
		officemail01office10.getGestor().registrarReproduccion(thegoodshepherd,
				format.parse("20/9/2013"), 241800);
		officemail01office10.getGestor().registrarReproduccion(barneyS1E17,
				format.parse("25/11/2013"), 304200);
		officemail01office10.getGestor().registrarReproduccion(himom,
				format.parse("2/2/2013"), 304200);
		officemail01office10.getGestor().registrarReproduccion(barneyS1E18,
				format.parse("18/12/2012"), 72600);
		officemail01office10.getGestor().registrarReproduccion(thesimpsonsS1E4,
				format.parse("12/6/2013"), 191400);
		officemail01office10.getGestor().registrarReproduccion(newyorknewyork,
				format.parse("18/8/2013"), 310800);
		officemail01office10.getGestor().registrarReproduccion(barneyS1E8,
				format.parse("23/3/2013"), 254400);
		officemail01office10.getGestor().registrarReproduccion(breakingbadS1E2,
				format.parse("18/12/2012"), 301800);
		officemail01office10.getGestor().registrarReproduccion(meanstreets,
				format.parse("18/12/2012"), 316800);
		officemail01office10.getGestor().registrarReproduccion(barneyS1E12,
				format.parse("18/12/2012"), 260400);
		officemail01office10.getGestor().registrarReproduccion(thefan,
				format.parse("21/10/2013"), 508800);
		officemail01office10.getGestor().registrarReproduccion(barneyS1E25,
				format.parse("27/12/2012"), 277200);
		officemail01office10.getGestor().registrarReproduccion(
				thesimpsonsS1E12, format.parse("14/7/2013"), 309000);
		officemail01office10.getGestor().registrarReproduccion(stardust,
				format.parse("19/9/2013"), 469200);
		officemail01office10.getGestor().registrarReproduccion(goodfellas,
				format.parse("25/11/2013"), 237000);
		officemail01office10.getGestor().registrarReproduccion(
				jenniferonmymind, format.parse("18/12/2012"), 180600);
		officemail01office10.getGestor().registrarReproduccion(newyearseve,
				format.parse("17/8/2013"), 124800);
		officemail01office10.getGestor().registrarReproduccion(frankenstein,
				format.parse("22/10/2013"), 372600);
		officemail01office10.getGestor().registrarReproduccion(thedeerhunter,
				format.parse("17/8/2013"), 316200);
		officemail01office10.getGestor().registrarReproduccion(barneyS1E7,
				format.parse("23/10/2013"), 259800);
		officemail01office10.getGestor().registrarReproduccion(newyorknewyork,
				format.parse("18/12/2012"), 379200);
		officemail01office10.getGestor().registrarReproduccion(americanhustle,
				format.parse("23/11/2013"), 322800);
		officemail01office10.getGestor().registrarReproduccion(copland,
				format.parse("18/12/2012"), 266400);
		officemail01office10.getGestor().registrarReproduccion(angelheart,
				format.parse("26/7/2013"), 514800);
		officemail01office10.getGestor().registrarReproduccion(encounter,
				format.parse("21/2/2013"), 283200);
		officemail01office10.getGestor().registrarReproduccion(barneyS1E23,
				format.parse("26/12/2013"), 226800);
		officemail01office10.getGestor().registrarReproduccion(barneyS1E1,
				format.parse("18/12/2012"), 170400);
		officemail01office10.getGestor().registrarReproduccion(barneyS1E24,
				format.parse("18/12/2012"), 331200);
		officemail01office10.getGestor().registrarReproduccion(
				thesimpsonsS1E11, format.parse("18/12/2012"), 344400);
		officemail01office10.getGestor().registrarReproduccion(
				whatjusthappened, format.parse("18/12/2012"), 419400);
		officemail01office10.getGestor().registrarReproduccion(
				thesimpsonsS1E12, format.parse("14/7/2013"), 234000);
		officemail01office10.getGestor().registrarReproduccion(borntowin,
				format.parse("19/9/2013"), 177600);
		officemail01office10.getGestor().registrarReproduccion(barneyS1E16,
				format.parse("25/11/2013"), 296400);
		officemail01office10.getGestor().registrarReproduccion(
				jenniferonmymind, format.parse("2/1/2013"), 240000);
		officemail01office10.getGestor().registrarReproduccion(barneyS1E17,
				format.parse("18/12/2012"), 183600);
		officemail01office10.getGestor().registrarReproduccion(
				lasedadesdelamor, format.parse("18/12/2012"), 303000);
		officemail01office10.getGestor().registrarReproduccion(maddogandglory,
				format.parse("23/11/2013"), 421800);
		officemail01office10.getGestor().registrarReproduccion(taxidriver,
				format.parse("28/1/2013"), 365400);
		officemail01office10.getGestor().registrarReproduccion(barneyS1E10,
				format.parse("6/3/2013"), 180000);
		officemail01office10.getGestor().registrarReproduccion(marvinsroom,
				format.parse("18/12/2012"), 123600);
		officemail01office10.getGestor().registrarReproduccion(thefamily,
				format.parse("16/8/2013"), 242400);
		officemail01office10.getGestor().registrarReproduccion(
				thegangthatcouldntshootstraight, format.parse("18/12/2012"),
				537000);
		officemail01office10.getGestor().registrarReproduccion(stanleyiris,
				format.parse("15/7/2013"), 152400);
		officemail01office10.getGestor().registrarReproduccion(barneyS1E6,
				format.parse("5/10/2013"), 271800);
		officemail01office10.getGestor().registrarReproduccion(barneyS1E30,
				format.parse("18/12/2012"), 215400);
		officemail01office10.getGestor().registrarReproduccion(threewiseguys,
				format.parse("18/12/2012"), 334200);
		officemail01office10.getGestor().registrarReproduccion(jackiebrown,
				format.parse("18/12/2012"), 277800);
		officemail01office10.getGestor().registrarReproduccion(midnightrun,
				format.parse("26/12/2012"), 526200);
		officemail01office10.getGestor().registrarReproduccion(barneyS1E23,
				format.parse("18/12/2012"), 307200);
		officemail01office10.getGestor().registrarReproduccion(
				thesimpsonsS1E10, format.parse("14/7/2013"), 283800);
		officemail01office10.getGestor().registrarReproduccion(
				bangthedrumslowly, format.parse("18/12/2012"), 403200);
		officemail01office10.getGestor().registrarReproduccion(freelancers,
				format.parse("18/12/2012"), 346800);
		officemail01office10.getGestor().registrarReproduccion(heat,
				format.parse("18/12/2012"), 115200);
		officemail01office10.getGestor().registrarReproduccion(thekingofcomedy,
				format.parse("18/12/2012"), 234000);
		officemail01office10.getGestor().registrarReproduccion(casino,
				format.parse("22/10/2013"), 482400);
		officemail01office10.getGestor().registrarReproduccion(barneyS1E28,
				format.parse("27/12/2012"), 324000);
		officemail01office10.getGestor().registrarReproduccion(dragna,
				format.parse("18/12/2012"), 194400);
		officemail01office10.getGestor().registrarReproduccion(extrastvseries,
				format.parse("18/12/2012"), 488400);
		officemail01office10.getGestor().registrarReproduccion(werenoangels,
				format.parse("15/7/2013"), 127800);
		officemail01office10.getGestor().registrarReproduccion(
				greatexpectations, format.parse("20/9/2013"), 246600);
		officemail01office10.getGestor().registrarReproduccion(jacknife,
				format.parse("25/12/2013"), 495000);
		officemail01office10.getGestor().registrarReproduccion(wagthedog,
				format.parse("18/12/2012"), 438600);
		officemail01office10.getGestor().registrarReproduccion(barneyS1E24,
				format.parse("27/12/2012"), 77400);
		officemail01office10.getGestor().registrarReproduccion(thesimpsonsS1E5,
				format.parse("13/6/2013"), 347400);
		officemail01office10.getGestor().registrarReproduccion(
				lasedadesdelamor, format.parse("18/12/2012"), 490800);
		officemail01office10.getGestor().registrarReproduccion(maddogandglory,
				format.parse("23/11/2013"), 129600);
		officemail01office10.getGestor().registrarReproduccion(taxidriver,
				format.parse("28/1/2013"), 249000);
		officemail01office10.getGestor().registrarReproduccion(barneyS1E10,
				format.parse("6/3/2013"), 304800);
		officemail01office10.getGestor().registrarReproduccion(breakingbadS1E4,
				format.parse("18/12/2012"), 182400);
		officemail01office10.getGestor().registrarReproduccion(thefamily,
				format.parse("16/8/2013"), 126000);
		officemail01office10.getGestor().registrarReproduccion(sleepers,
				format.parse("18/12/2012"), 69600);
		officemail01office10.getGestor().registrarReproduccion(themission,
				format.parse("16/8/2013"), 493200);
		officemail01office10.getGestor().registrarReproduccion(barneyS1E2,
				format.parse("4/2/2013"), 132000);
		officemail01office10.getGestor().registrarReproduccion(barneyS1E25,
				format.parse("18/12/2012"), 75600);
		officemail01office10.getGestor().registrarReproduccion(awakenings,
				format.parse("7/8/2013"), 499200);
		officemail01office10.getGestor().registrarReproduccion(
				billythekidmcdonnen, format.parse("5/7/2013"), 276600);
		officemail01office10.getGestor().registrarReproduccion(bloodymama,
				format.parse("20/9/2013"), 280200);
		officemail01office10.getGestor().registrarReproduccion(barneyS1E19,
				format.parse("25/12/2013"), 94800);
		officemail01office10.getGestor().registrarReproduccion(thesimpsonsS1E5,
				format.parse("18/12/2012"), 347400);
		officemail01office10.getGestor().registrarReproduccion(
				lasedadesdelamor, format.parse("18/12/2012"), 378600);
		officemail01office10.getGestor().registrarReproduccion(maddogandglory,
				format.parse("23/6/2013"), 193200);
		officemail01office10.getGestor().registrarReproduccion(taxidriver,
				format.parse("18/8/2013"), 136800);
		officemail01office10.getGestor().registrarReproduccion(barneyS1E10,
				format.parse("18/12/2012"), 304800);
		officemail01office10.getGestor().registrarReproduccion(breakingbadS1E4,
				format.parse("18/12/2012"), 328200);
		officemail01office10.getGestor().registrarReproduccion(thefamily,
				format.parse("18/12/2012"), 540000);
		officemail01office10.getGestor().registrarReproduccion(sleepers,
				format.parse("18/12/2012"), 285000);
		officemail01office10.getGestor().registrarReproduccion(themission,
				format.parse("26/12/2013"), 99000);
		officemail01office10.getGestor().registrarReproduccion(
				thesimpsonsS1E11, format.parse("18/12/2012"), 344400);
		officemail01office10.getGestor().registrarReproduccion(abronxtale,
				format.parse("18/12/2012"), 512400);
		officemail01office10.getGestor().registrarReproduccion(stone,
				format.parse("18/8/2013"), 456000);
		officemail01office10.getGestor().registrarReproduccion(nightandthecity,
				format.parse("23/11/2013"), 95400);
		officemail01office10.getGestor().registrarReproduccion(breakingbadS1E4,
				format.parse("18/12/2012"), 84600);
		officemail01office10.getGestor().registrarReproduccion(thefamily,
				format.parse("18/12/2012"), 204000);
		officemail01office10.getGestor().registrarReproduccion(sleepers,
				format.parse("21/10/2013"), 147600);
		officemail01office10.getGestor().registrarReproduccion(themission,
				format.parse("26/12/2013"), 266400);
		officemail01office10.getGestor().registrarReproduccion(barneyS1E2,
				format.parse("4/2/2013"), 312600);
		officemail01office10.getGestor().registrarReproduccion(
				whatjusthappened, format.parse("18/12/2012"), 199800);
		officemail01office10.getGestor().registrarReproduccion(awakenings,
				format.parse("24/11/2013"), 448200);
		officemail01office10.getGestor().registrarReproduccion(thesimpsonsS1E1,
				format.parse("18/12/2012"), 332400);
		officemail01office10.getGestor().registrarReproduccion(redlights,
				format.parse("17/8/2013"), 76800);
		officemail01office10.getGestor().registrarReproduccion(
				onehundredandonenights, format.parse("18/12/2012"), 66600);
		officemail01office10.getGestor().registrarReproduccion(thesimpsonsS1E5,
				format.parse("18/12/2012"), 347400);
		officemail01office10.getGestor().registrarReproduccion(
				lasedadesdelamor, format.parse("8/8/2013"), 175200);
		officemail01office10.getGestor().registrarReproduccion(maddogandglory,
				format.parse("23/11/2013"), 294600);
		officemail01office10.getGestor().registrarReproduccion(taxidriver,
				format.parse("18/8/2013"), 108600);
		officemail01office10.getGestor().registrarReproduccion(barneyS1E10,
				format.parse("5/3/2013"), 227400);
		officemail01office10.getGestor().registrarReproduccion(breakingbadS1E4,
				format.parse("18/12/2012"), 217200);
		officemail01office10.getGestor().registrarReproduccion(thefamily,
				format.parse("18/12/2012"), 336600);
		officemail01office10.getGestor().registrarReproduccion(brazil,
				format.parse("27/12/2012"), 280200);
		officemail01office10.getGestor().registrarReproduccion(
				thesimpsonsS1E11, format.parse("18/12/2012"), 270000);
		officemail01office10.getGestor().registrarReproduccion(stardust,
				format.parse("18/12/2012"), 213600);
		officemail01office10.getGestor().registrarReproduccion(awakenings,
				format.parse("14/7/2013"), 157200);
		officemail01office10.getGestor().registrarReproduccion(thegoodshepherd,
				format.parse("19/9/2013"), 276000);
		officemail01office10.getGestor().registrarReproduccion(barneyS1E16,
				format.parse("25/4/2013"), 90600);
		officemail01office10.getGestor().registrarReproduccion(thesimpsonsS1E4,
				format.parse("18/12/2012"), 80400);
		officemail01office10.getGestor().registrarReproduccion(breakingbadS1E1,
				format.parse("18/12/2012"), 69600);
		officemail01office10.getGestor().registrarReproduccion(americanhustle,
				format.parse("5/3/2013"), 539400);
		officemail01office10.getGestor().registrarReproduccion(wagthedog,
				format.parse("20/10/2013"), 354000);
		officemail01office10.getGestor().registrarReproduccion(barneyS1E21,
				format.parse("26/12/2013"), 168000);
		officemail01office10.getGestor().registrarReproduccion(
				threeroomsinmanhattan, format.parse("18/12/2012"), 157800);
		officemail01office10.getGestor().registrarReproduccion(barneyS1E22,
				format.parse("26/12/2013"), 343200);
		officemail01office10.getGestor().registrarReproduccion(thesimpsonsS1E9,
				format.parse("18/12/2012"), 137400);
		officemail01office10.getGestor().registrarReproduccion(barneyS1E23,
				format.parse("8/12/2013"), 307200);
		officemail01office10.getGestor().registrarReproduccion(thesimpsonsS1E9,
				format.parse("11/10/2013"), 340200);
		officemail01office10.getGestor().registrarReproduccion(bloodymama,
				format.parse("20/9/2013"), 235800);
		officemail01office10.getGestor().registrarReproduccion(werenoangels,
				format.parse("25/11/2013"), 193200);
		officemail01office10.getGestor().registrarReproduccion(samssong,
				format.parse("18/12/2012"), 312600);
		officemail01office10.getGestor().registrarReproduccion(barneyS1E19,
				format.parse("7/10/2013"), 126600);
		officemail01office10.getGestor().registrarReproduccion(machete,
				format.parse("18/12/2012"), 70200);
		officemail01office10.getGestor().registrarReproduccion(capefear,
				format.parse("13/6/2013"), 364800);
		officemail01office10.getGestor().registrarReproduccion(meanstreets,
				format.parse("19/9/2013"), 483600);
		officemail01office10.getGestor().registrarReproduccion(barneyS1E13,
				format.parse("24/11/2013"), 298200);
		officemail01office10.getGestor().registrarReproduccion(
				bangthedrumslowly, format.parse("1/1/2013"), 288000);
		officemail01office10.getGestor().registrarReproduccion(barneyS1E14,
				format.parse("18/12/2012"), 357600);
		officemail01office10.getGestor().registrarReproduccion(greetings,
				format.parse("18/12/2012"), 350400);
		officemail01office10.getGestor().registrarReproduccion(thebigwedding,
				format.parse("18/12/2012"), 165000);
		officemail01office10.getGestor().registrarReproduccion(sleepers,
				format.parse("18/12/2012"), 283800);
		officemail01office10.getGestor().registrarReproduccion(brazil,
				format.parse("16/8/2013"), 227400);
		officemail01office10.getGestor().registrarReproduccion(barneyS1E2,
				format.parse("18/12/2012"), 312600);
		officemail01office10.getGestor().registrarReproduccion(barneyS1E26,
				format.parse("18/12/2012"), 160800);
		officemail01office10.getGestor().registrarReproduccion(
				thesimpsonsS1E12, format.parse("18/12/2012"), 309000);
		officemail01office10.getGestor().registrarReproduccion(killerelite,
				format.parse("18/8/2013"), 445200);
		officemail01office10.getGestor().registrarReproduccion(thisboyslife,
				format.parse("13/10/2013"), 259200);
		officemail01office10.getGestor().registrarReproduccion(breakingbadS1E1,
				format.parse("18/12/2012"), 249000);
		officemail01office10.getGestor().registrarReproduccion(lastvegas,
				format.parse("18/12/2012"), 63600);
		officemail01office10.getGestor().registrarReproduccion(breakingbadS1E2,
				format.parse("18/12/2012"), 301800);
		sitio.registrarUsuario(officemail01office10);
		Usuario deborajoseph55 = new Usuario(format.parse("1/1/1947"),
				"debora.joseph55@yahoo.com", format.parse("17/8/2013"),
				catalogo);
		deborajoseph55.getGestor().registrarReproduccion(barneyS1E28,
				format.parse("9/9/2013"), 324000);
		deborajoseph55.getGestor().registrarReproduccion(newyearseve,
				format.parse("17/8/2013"), 89400);
		deborajoseph55.getGestor().registrarReproduccion(threewiseguys,
				format.parse("17/8/2013"), 466800);
		deborajoseph55.getGestor().registrarReproduccion(maddogandglory,
				format.parse("17/8/2013"), 364800);
		deborajoseph55.getGestor().registrarReproduccion(greetings,
				format.parse("17/8/2013"), 216000);
		deborajoseph55.getGestor().registrarReproduccion(breakingbadS1E4,
				format.parse("11/10/2013"), 289200);
		deborajoseph55.getGestor().registrarReproduccion(thesimpsonsS1E12,
				format.parse("17/8/2013"), 186600);
		deborajoseph55.getGestor().registrarReproduccion(barneyS1E4,
				format.parse("17/8/2013"), 323400);
		deborajoseph55.setSesion(new Sesion(new Reproduccion(barneyS1E25,
				format.parse("27/3/2014"), 333600), format.parse("27/3/2014")));
		sitio.registrarUsuario(deborajoseph55);
		Usuario debora0007 = new Usuario(format.parse("15/7/1984"),
				"debora0007@bol.com.br", format.parse("14/7/2012"), catalogo);
		debora0007.getGestor().registrarReproduccion(capefear,
				format.parse("14/7/2012"), 241200);
		debora0007.getGestor().registrarReproduccion(barneyS1E2,
				format.parse("4/7/2013"), 312600);
		debora0007.getGestor().registrarReproduccion(
				thegangthatcouldntshootstraight, format.parse("14/7/2012"),
				340800);
		debora0007.getGestor().registrarReproduccion(barneyS1E27,
				format.parse("9/5/2013"), 63000);
		debora0007.setSesion(new Sesion(new Reproduccion(barneyS1E19, format
				.parse("25/1/2014"), 243600), format.parse("25/1/2014")));
		sitio.registrarUsuario(debora0007);
		Usuario yusufaliu234 = new Usuario(format.parse("20/9/1951"),
				"yusufaliu234@gmail.com", format.parse("19/1/2011"), catalogo);
		yusufaliu234.getSuscripcion().pasarAVIP();
		yusufaliu234.getGestor().registrarReproduccion(breakingbadS1E4,
				format.parse("11/10/2013"), 91800);
		yusufaliu234.getGestor().registrarReproduccion(righteouskill,
				format.parse("19/1/2012"), 294000);
		yusufaliu234.getGestor().registrarReproduccion(silverliningsplaybook,
				format.parse("16/12/2012"), 496200);
		yusufaliu234.getGestor().registrarReproduccion(awakenings,
				format.parse("12/3/2012"), 348000);
		yusufaliu234.getGestor().registrarReproduccion(thesimpsonsS1E5,
				format.parse("13/6/2013"), 245400);
		yusufaliu234.getGestor().registrarReproduccion(breakingbadS1E2,
				format.parse("10/10/2012"), 142800);
		yusufaliu234.getGestor().registrarReproduccion(stone,
				format.parse("28/1/2012"), 298800);
		yusufaliu234.getGestor().registrarReproduccion(angelheart,
				format.parse("8/4/2013"), 501000);
		yusufaliu234.getGestor().registrarReproduccion(barneyS1E13,
				format.parse("6/8/2013"), 333600);
		yusufaliu234.getGestor().registrarReproduccion(thesimpsonsS1E11,
				format.parse("14/11/2013"), 250200);
		yusufaliu234.getGestor().registrarReproduccion(casino,
				format.parse("22/2/2012"), 102000);
		yusufaliu234.getGestor().registrarReproduccion(jenniferonmymind,
				format.parse("2/6/2013"), 479400);
		yusufaliu234.getGestor().registrarReproduccion(ilimitless,
				format.parse("28/1/2013"), 506400);
		yusufaliu234.getGestor().registrarReproduccion(mistress,
				format.parse("13/6/2013"), 357600);
		yusufaliu234.getGestor().registrarReproduccion(meanstreets,
				format.parse("18/9/2013"), 384600);
		yusufaliu234.getGestor().registrarReproduccion(barneyS1E12,
				format.parse("6/3/2012"), 106800);
		yusufaliu234.getGestor().registrarReproduccion(thefan,
				format.parse("11/12/2012"), 133800);
		yusufaliu234.getGestor().registrarReproduccion(barneyS1E17,
				format.parse("7/11/2013"), 304200);
		yusufaliu234.getGestor().registrarReproduccion(thesimpsonsS1E3,
				format.parse("2/2/2012"), 233400);
		yusufaliu234.getGestor().registrarReproduccion(killerelite,
				format.parse("17/8/2013"), 260400);
		yusufaliu234.getGestor().registrarReproduccion(barneyS1E7,
				format.parse("5/3/2012"), 336000);
		yusufaliu234.getGestor().registrarReproduccion(theweddingparty,
				format.parse("20/9/2013"), 184800);
		yusufaliu234.getGestor().registrarReproduccion(barneyS1E20,
				format.parse("25/12/2013"), 211200);
		yusufaliu234.getGestor().registrarReproduccion(thesimpsonsS1E7,
				format.parse("3/2/2012"), 109200);
		yusufaliu234.getGestor().registrarReproduccion(stone,
				format.parse("8/4/2012"), 440400);
		yusufaliu234.getGestor().registrarReproduccion(mistress,
				format.parse("13/11/2013"), 292200);
		yusufaliu234.getGestor().registrarReproduccion(thegodfatherpartii,
				format.parse("1/1/2013"), 364800);
		yusufaliu234.getGestor().registrarReproduccion(barneyS1E12,
				format.parse("6/3/2012"), 87000);
		yusufaliu234.getGestor().registrarReproduccion(sleepers,
				format.parse("11/10/2012"), 243000);
		yusufaliu234.getGestor().registrarReproduccion(brazil,
				format.parse("16/12/2012"), 94800);
		yusufaliu234.getGestor().registrarReproduccion(billythekidmcdonnen,
				format.parse("15/7/2012"), 472200);
		yusufaliu234.getGestor().registrarReproduccion(extrastvseries,
				format.parse("20/9/2013"), 369600);
		yusufaliu234.getGestor().registrarReproduccion(jacknife,
				format.parse("25/12/2013"), 221400);
		yusufaliu234.getGestor().registrarReproduccion(samssong,
				format.parse("20/2/2013"), 248400);
		yusufaliu234.getGestor().registrarReproduccion(barneyS1E20,
				format.parse("8/4/2013"), 354600);
		yusufaliu234.getGestor().registrarReproduccion(thesimpsonsS1E6,
				format.parse("3/2/2012"), 348000);
		yusufaliu234.getGestor().registrarReproduccion(stone,
				format.parse("8/4/2012"), 291600);
		yusufaliu234.getGestor().registrarReproduccion(nightandthecity,
				format.parse("13/6/2013"), 189000);
		yusufaliu234.getGestor().registrarReproduccion(thegodfatherpartii,
				format.parse("18/9/2013"), 87000);
		yusufaliu234.getGestor().registrarReproduccion(mistress,
				format.parse("23/11/2013"), 418200);
		yusufaliu234.getGestor().registrarReproduccion(meanstreets,
				format.parse("18/9/2013"), 140400);
		yusufaliu234.getGestor().registrarReproduccion(righteouskill,
				format.parse("19/9/2012"), 342600);
		yusufaliu234.getGestor().registrarReproduccion(guiltybysuspicion,
				format.parse("24/11/2013"), 64800);
		yusufaliu234.getGestor().registrarReproduccion(bloodymama,
				format.parse("2/2/2012"), 267000);
		yusufaliu234.getGestor().registrarReproduccion(barneyS1E18,
				format.parse("7/4/2012"), 328200);
		yusufaliu234.getGestor().registrarReproduccion(thisboyslife,
				format.parse("13/6/2013"), 505200);
		yusufaliu234.getGestor().registrarReproduccion(newyorknewyork,
				format.parse("18/8/2013"), 365400);
		yusufaliu234.getGestor().registrarReproduccion(barneyS1E9,
				format.parse("23/3/2013"), 87600);
		yusufaliu234.getGestor().registrarReproduccion(breakingbadS1E2,
				format.parse("10/5/2012"), 160800);
		yusufaliu234.getGestor().registrarReproduccion(killingseason,
				format.parse("16/7/2013"), 363000);
		yusufaliu234.getGestor().registrarReproduccion(threeroomsinmanhattan,
				format.parse("21/10/2013"), 260400);
		yusufaliu234.getGestor().registrarReproduccion(barneyS1E23,
				format.parse("26/12/2013"), 307200);
		yusufaliu234.getGestor().registrarReproduccion(encounter,
				format.parse("3/2/2012"), 522600);
		yusufaliu234.getGestor().registrarReproduccion(barneyS1E24,
				format.parse("9/4/2012"), 244800);
		yusufaliu234.getGestor().registrarReproduccion(thesimpsonsS1E10,
				format.parse("14/7/2012"), 318000);
		yusufaliu234.getGestor().registrarReproduccion(whatjusthappened,
				format.parse("19/9/2013"), 215400);
		yusufaliu234.getGestor().registrarReproduccion(guiltybysuspicion,
				format.parse("25/11/2013"), 417600);
		yusufaliu234.getGestor().registrarReproduccion(thesimpsonsS1E4,
				format.parse("2/2/2013"), 323400);
		yusufaliu234.getGestor().registrarReproduccion(ilimitless,
				format.parse("18/8/2013"), 212400);
		yusufaliu234.getGestor().registrarReproduccion(breakingbadS1E5,
				format.parse("11/5/2012"), 110400);
		yusufaliu234.getGestor().registrarReproduccion(brazil,
				format.parse("26/12/2012"), 136800);
		yusufaliu234.getGestor().registrarReproduccion(barneyS1E2,
				format.parse("4/2/2012"), 312600);
		yusufaliu234.getGestor().registrarReproduccion(stardust,
				format.parse("9/9/2012"), 190800);
		yusufaliu234.getGestor().registrarReproduccion(barneyS1E15,
				format.parse("24/11/2013"), 217800);
		yusufaliu234.getGestor().registrarReproduccion(thesimpsonsS1E2,
				format.parse("2/1/2012"), 290400);
		yusufaliu234.getGestor().registrarReproduccion(redlights,
				format.parse("7/4/2012"), 492600);
		yusufaliu234.getGestor().registrarReproduccion(thesimpsonsS1E3,
				format.parse("12/6/2012"), 85800);
		yusufaliu234.getGestor().registrarReproduccion(ragingbull,
				format.parse("17/8/2013"), 288000);
		yusufaliu234.getGestor().registrarReproduccion(barneyS1E7,
				format.parse("22/10/2013"), 336000);
		yusufaliu234.getGestor().registrarReproduccion(thedeerhunter,
				format.parse("28/11/2012"), 212400);
		yusufaliu234.getGestor().registrarReproduccion(threeroomsinmanhattan,
				format.parse("3/2/2012"), 285000);
		yusufaliu234.getGestor().registrarReproduccion(everybodysfine,
				format.parse("18/9/2013"), 487200);
		yusufaliu234.getGestor().registrarReproduccion(barneyS1E12,
				format.parse("24/11/2013"), 209400);
		yusufaliu234.getGestor().registrarReproduccion(breakingbadS1E6,
				format.parse("1/1/2012"), 282600);
		yusufaliu234.getGestor().registrarReproduccion(awakenings,
				format.parse("24/4/2013"), 133800);
		yusufaliu234.getGestor().registrarReproduccion(dragna,
				format.parse("15/11/2013"), 160800);
		yusufaliu234.getGestor().registrarReproduccion(jackiebrown,
				format.parse("10/5/2012"), 363000);
		yusufaliu234.getGestor().registrarReproduccion(americanhustle,
				format.parse("15/3/2012"), 85200);
		yusufaliu234.getGestor().registrarReproduccion(wagthedog,
				format.parse("10/5/2012"), 462600);
		yusufaliu234.getGestor().registrarReproduccion(
				dearamericalettershomefromvietnamtvmoviedocumentary,
				format.parse("26/12/2013"), 323400);
		yusufaliu234.getGestor().registrarReproduccion(threeroomsinmanhattan,
				format.parse("3/2/2013"), 396000);
		yusufaliu234.getGestor().registrarReproduccion(thegodfatherpartii,
				format.parse("18/9/2013"), 469200);
		yusufaliu234.getGestor().registrarReproduccion(barneyS1E12,
				format.parse("24/11/2013"), 191400);
		yusufaliu234.getGestor().registrarReproduccion(thesimpsonsS1E2,
				format.parse("12/1/2012"), 88800);
		yusufaliu234.getGestor().registrarReproduccion(trueconfessions,
				format.parse("17/8/2013"), 291000);
		yusufaliu234.getGestor().registrarReproduccion(barneyS1E6,
				format.parse("5/3/2012"), 188400);
		yusufaliu234.getGestor().registrarReproduccion(extrastvseries,
				format.parse("10/5/2012"), 436800);
		yusufaliu234.getGestor().registrarReproduccion(jacknife,
				format.parse("25/12/2013"), 288600);
		yusufaliu234.getGestor().registrarReproduccion(thesimpsonsS1E5,
				format.parse("13/6/2013"), 347400);
		yusufaliu234.getGestor().registrarReproduccion(lasedadesdelamor,
				format.parse("18/8/2013"), 258600);
		yusufaliu234.getGestor().registrarReproduccion(maddogandglory,
				format.parse("23/11/2013"), 156600);
		yusufaliu234.getGestor().registrarReproduccion(taxidriver,
				format.parse("28/1/2013"), 534000);
		yusufaliu234.getGestor().registrarReproduccion(barneyS1E10,
				format.parse("6/3/2013"), 256200);
		yusufaliu234.getGestor().registrarReproduccion(breakingbadS1E4,
				format.parse("11/5/2012"), 328200);
		yusufaliu234.getGestor().registrarReproduccion(angelheart,
				format.parse("16/8/2013"), 226800);
		yusufaliu234.getGestor().registrarReproduccion(barneyS1E1,
				format.parse("21/10/2013"), 333600);
		yusufaliu234.getGestor().registrarReproduccion(barneyS1E24,
				format.parse("4/7/2013"), 151200);
		yusufaliu234.getGestor().registrarReproduccion(jenniferonmymind,
				format.parse("2/1/2012"), 528600);
		yusufaliu234.getGestor().registrarReproduccion(barneyS1E17,
				format.parse("7/4/2012"), 304200);
		yusufaliu234.getGestor().registrarReproduccion(thesimpsonsS1E3,
				format.parse("12/6/2012"), 358800);
		yusufaliu234.getGestor().registrarReproduccion(thedeerhunter,
				format.parse("17/1/2013"), 359400);
		yusufaliu234.getGestor().registrarReproduccion(barneyS1E7,
				format.parse("5/3/2013"), 90600);
		yusufaliu234.getGestor().registrarReproduccion(jackiebrown,
				format.parse("10/5/2012"), 172800);
		yusufaliu234.getGestor().registrarReproduccion(midnightrun,
				format.parse("15/12/2013"), 70200);
		yusufaliu234.getGestor().registrarReproduccion(greetings,
				format.parse("3/2/2012"), 235200);
		yusufaliu234.getGestor().registrarReproduccion(stone,
				format.parse("8/4/2012"), 507600);
		yusufaliu234.getGestor().registrarReproduccion(mistress,
				format.parse("23/6/2013"), 229800);
		yusufaliu234.getGestor().registrarReproduccion(machete,
				format.parse("18/9/2013"), 256800);
		yusufaliu234.getGestor().registrarReproduccion(barneyS1E12,
				format.parse("24/11/2013"), 331200);
		yusufaliu234.getGestor().registrarReproduccion(breakingbadS1E5,
				format.parse("1/1/2012"), 227400);
		yusufaliu234.getGestor().registrarReproduccion(ragingbull,
				format.parse("27/12/2012"), 429600);
		yusufaliu234.getGestor().registrarReproduccion(billythekidmcdonnen,
				format.parse("5/3/2012"), 502200);
		yusufaliu234.getGestor().registrarReproduccion(greatexpectations,
				format.parse("20/9/2012"), 400200);
		yusufaliu234.getGestor().registrarReproduccion(jacknife,
				format.parse("25/12/2013"), 251400);
		yusufaliu234.getGestor().registrarReproduccion(thesimpsonsS1E6,
				format.parse("13/6/2013"), 349800);
		yusufaliu234.getGestor().registrarReproduccion(thelasttycoon,
				format.parse("18/8/2013"), 397200);
		yusufaliu234.getGestor().registrarReproduccion(nightandthecity,
				format.parse("23/11/2012"), 294600);
		yusufaliu234.getGestor().registrarReproduccion(thesimpsonsS1E1,
				format.parse("2/6/2012"), 63000);
		yusufaliu234.getGestor().registrarReproduccion(barneyS1E30,
				format.parse("20/9/2012"), 265200);
		yusufaliu234.getGestor().registrarReproduccion(newyorknewyork,
				format.parse("28/5/2012"), 513600);
		yusufaliu234.getGestor().registrarReproduccion(barneyS1E21,
				format.parse("8/4/2013"), 235800);
		yusufaliu234.getGestor().registrarReproduccion(thesimpsonsS1E12,
				format.parse("22/10/2012"), 309000);
		yusufaliu234.getGestor().registrarReproduccion(bloodymama,
				format.parse("12/6/2013"), 206400);
		yusufaliu234.getGestor().registrarReproduccion(barneyS1E24,
				format.parse("19/1/2012"), 103800);
		yusufaliu234.getGestor().registrarReproduccion(fallinginlove,
				format.parse("9/5/2013"), 481200);
		yusufaliu234.getGestor().registrarReproduccion(redlights,
				format.parse("17/12/2012"), 203400);
		yusufaliu234.getGestor().registrarReproduccion(barneyS1E17,
				format.parse("17/8/2012"), 101400);
		yusufaliu234.getGestor().registrarReproduccion(jacknife,
				format.parse("25/4/2013"), 127800);
		yusufaliu234.getGestor().registrarReproduccion(lastvegas,
				format.parse("15/12/2012"), 505800);
		yusufaliu234.getGestor().registrarReproduccion(barneyS1E10,
				format.parse("5/7/2013"), 304800);
		yusufaliu234.getGestor().registrarReproduccion(thesimpsonsS1E9,
				format.parse("13/11/2013"), 340200);
		yusufaliu234.getGestor().registrarReproduccion(sleepers,
				format.parse("21/2/2012"), 198600);
		yusufaliu234.getGestor().registrarReproduccion(breakingbadS1E7,
				format.parse("11/10/2012"), 271200);
		yusufaliu234.getGestor().registrarReproduccion(thesimpsonsS1E4,
				format.parse("3/6/2013"), 323400);
		yusufaliu234.getGestor().registrarReproduccion(breakingbadS1E3,
				format.parse("11/10/2012"), 325800);
		yusufaliu234.getGestor().registrarReproduccion(thegodfatherpartii,
				format.parse("1/5/2012"), 185400);
		yusufaliu234.getGestor().registrarReproduccion(barneyS1E30,
				format.parse("20/2/2013"), 82800);
		yusufaliu234.getGestor().registrarReproduccion(breakingbadS1E2,
				format.parse("10/10/2012"), 156000);
		yusufaliu234.getGestor().registrarReproduccion(taxidriver,
				format.parse("28/5/2013"), 533400);
		yusufaliu234.getGestor().registrarReproduccion(barneyS1E23,
				format.parse("19/1/2012"), 126600);
		yusufaliu234.getGestor().registrarReproduccion(brazil,
				format.parse("26/4/2013"), 153000);
		yusufaliu234.getGestor().registrarReproduccion(freelancers,
				format.parse("27/5/2012"), 531000);
		yusufaliu234.getGestor().registrarReproduccion(barneyS1E16,
				format.parse("7/8/2013"), 301800);
		yusufaliu234.getGestor().registrarReproduccion(dragna,
				format.parse("15/11/2012"), 455400);
		yusufaliu234.getGestor().registrarReproduccion(barneyS1E7,
				format.parse("5/7/2013"), 336000);
		yusufaliu234.getGestor().registrarReproduccion(thesimpsonsS1E6,
				format.parse("13/11/2012"), 121200);
		yusufaliu234.getGestor().registrarReproduccion(
				thegangthatcouldntshootstraight, format.parse("1/6/2013"),
				369000);
		yusufaliu234.getGestor().registrarReproduccion(stardust,
				format.parse("19/1/2012"), 91200);
		yusufaliu234.getGestor().registrarReproduccion(trueconfessions,
				format.parse("9/9/2013"), 469200);
		yusufaliu234.getGestor().registrarReproduccion(killerelite,
				format.parse("24/3/2012"), 366600);
		yusufaliu234.getGestor().registrarReproduccion(thesimpsonsS1E10,
				format.parse("24/3/2012"), 135000);
		yusufaliu234.getGestor().registrarReproduccion(barneyS1E3,
				format.parse("14/11/2013"), 360000);
		yusufaliu234.getGestor().registrarReproduccion(casino,
				format.parse("22/3/2013"), 234600);
		yusufaliu234.getGestor().registrarReproduccion(himom,
				format.parse("12/6/2013"), 307800);
		yusufaliu234.getGestor().registrarReproduccion(extrastvseries,
				format.parse("2/2/2013"), 251400);
		yusufaliu234.getGestor().registrarReproduccion(breakingbadS1E1,
				format.parse("10/9/2013"), 337800);
		yusufaliu234.getGestor().registrarReproduccion(stone,
				format.parse("28/1/2012"), 222000);
		yusufaliu234.getGestor().registrarReproduccion(barneyS1E22,
				format.parse("8/9/2013"), 161400);
		yusufaliu234.getGestor().registrarReproduccion(themission,
				format.parse("26/4/2012"), 234000);
		yusufaliu234.getGestor().registrarReproduccion(barneyS1E14,
				format.parse("6/8/2013"), 132000);
		yusufaliu234.getGestor().registrarReproduccion(thesimpsonsS1E12,
				format.parse("14/11/2012"), 309000);
		yusufaliu234.getGestor().registrarReproduccion(barneyS1E17,
				format.parse("7/8/2013"), 277800);
		yusufaliu234.getGestor().registrarReproduccion(barneyS1E6,
				format.parse("15/3/2013"), 175200);
		yusufaliu234.getGestor().registrarReproduccion(barneyS1E14,
				format.parse("17/8/2012"), 72600);
		yusufaliu234.getGestor().registrarReproduccion(goodfellas,
				format.parse("24/4/2013"), 274800);
		yusufaliu234.getGestor().registrarReproduccion(dragna,
				format.parse("15/11/2012"), 301800);
		yusufaliu234.getGestor().registrarReproduccion(barneyS1E7,
				format.parse("5/7/2013"), 199200);
		yusufaliu234.getGestor().registrarReproduccion(thesimpsonsS1E5,
				format.parse("23/11/2012"), 347400);
		yusufaliu234.getGestor().registrarReproduccion(greetings,
				format.parse("13/6/2013"), 169800);
		yusufaliu234.getGestor().registrarReproduccion(marvinsroom,
				format.parse("21/2/2013"), 67200);
		yusufaliu234.getGestor().registrarReproduccion(breakingbadS1E5,
				format.parse("11/10/2012"), 315600);
		yusufaliu234.getGestor().registrarReproduccion(
				thegangthatcouldntshootstraight, format.parse("1/6/2012"),
				259200);
		yusufaliu234.getGestor().registrarReproduccion(barneyS1E27,
				format.parse("19/9/2012"), 157200);
		yusufaliu234.getGestor().registrarReproduccion(trueconfessions,
				format.parse("9/9/2013"), 229800);
		yusufaliu234.getGestor().registrarReproduccion(barneyS1E8,
				format.parse("23/10/2013"), 127200);
		yusufaliu234.getGestor().registrarReproduccion(breakingbadS1E1,
				format.parse("28/1/2012"), 337800);
		yusufaliu234.getGestor().registrarReproduccion(thesimpsonsS1E12,
				format.parse("14/7/2013"), 144000);
		yusufaliu234.getGestor().registrarReproduccion(borntowin,
				format.parse("19/9/2013"), 521400);
		yusufaliu234.getGestor().registrarReproduccion(barneyS1E16,
				format.parse("25/11/2013"), 114600);
		yusufaliu234.getGestor().registrarReproduccion(thesimpsonsS1E2,
				format.parse("2/1/2012"), 357000);
		yusufaliu234.getGestor().registrarReproduccion(newyearseve,
				format.parse("17/4/2012"), 435600);
		yusufaliu234.getGestor().registrarReproduccion(frankenstein,
				format.parse("12/6/2012"), 157800);
		yusufaliu234.getGestor().registrarReproduccion(thedeerhunter,
				format.parse("17/8/2013"), 231000);
		yusufaliu234.getGestor().registrarReproduccion(barneyS1E7,
				format.parse("23/10/2013"), 128400);
		yusufaliu234.getGestor().registrarReproduccion(newyorknewyork,
				format.parse("28/8/2013"), 376800);
		yusufaliu234.getGestor().registrarReproduccion(barneyS1E8,
				format.parse("23/11/2013"), 274200);
		yusufaliu234.getGestor().registrarReproduccion(breakingbadS1E2,
				format.parse("28/1/2012"), 301800);
		yusufaliu234.getGestor().registrarReproduccion(barneyS1E9,
				format.parse("5/3/2013"), 115200);
		yusufaliu234.getGestor().registrarReproduccion(breakingbadS1E3,
				format.parse("8/9/2012"), 325800);
		yusufaliu234.getGestor().registrarReproduccion(barneyS1E9,
				format.parse("5/7/2012"), 94800);
		yusufaliu234.getGestor().registrarReproduccion(wagthedog,
				format.parse("18/12/2012"), 306000);
		yusufaliu234.getGestor().registrarReproduccion(guiltybysuspicion,
				format.parse("14/7/2013"), 379200);
		yusufaliu234.getGestor().registrarReproduccion(stardust,
				format.parse("19/1/2013"), 101400);
		yusufaliu234.getGestor().registrarReproduccion(barneyS1E15,
				format.parse("7/4/2012"), 360000);
		yusufaliu234.getGestor().registrarReproduccion(thesimpsonsS1E2,
				format.parse("12/6/2012"), 357000);
		yusufaliu234.getGestor().registrarReproduccion(trueconfessions,
				format.parse("27/12/2012"), 319800);
		yusufaliu234.getGestor().registrarReproduccion(barneyS1E6,
				format.parse("5/3/2013"), 328200);
		yusufaliu234.getGestor().registrarReproduccion(extrastvseries,
				format.parse("10/9/2012"), 336600);
		yusufaliu234.getGestor().registrarReproduccion(jacknife,
				format.parse("25/12/2013"), 538800);
		yusufaliu234.getGestor().registrarReproduccion(americanhustle,
				format.parse("15/7/2013"), 131400);
		yusufaliu234.getGestor().registrarReproduccion(greetings,
				format.parse("3/2/2013"), 509400);
		yusufaliu234.getGestor().registrarReproduccion(barneyS1E22,
				format.parse("26/12/2013"), 343200);
		yusufaliu234.getGestor().registrarReproduccion(thesimpsonsS1E8,
				format.parse("7/8/2012"), 337800);
		yusufaliu234.getGestor().registrarReproduccion(barneyS1E4,
				format.parse("22/10/2013"), 323400);
		yusufaliu234.getGestor().registrarReproduccion(barneyS1E28,
				format.parse("27/12/2012"), 321000);
		yusufaliu234.getGestor().registrarReproduccion(dragna,
				format.parse("15/7/2012"), 218400);
		yusufaliu234.getGestor().registrarReproduccion(extrastvseries,
				format.parse("20/9/2013"), 162000);
		yusufaliu234.getGestor().registrarReproduccion(werenoangels,
				format.parse("25/11/2013"), 235200);
		yusufaliu234.getGestor().registrarReproduccion(breakingbadS1E2,
				format.parse("18/10/2013"), 178800);
		yusufaliu234.getGestor().registrarReproduccion(barneyS1E17,
				format.parse("7/8/2013"), 63000);
		yusufaliu234.getGestor().registrarReproduccion(barneyS1E6,
				format.parse("22/10/2013"), 311400);
		yusufaliu234.getGestor().registrarReproduccion(barneyS1E30,
				format.parse("28/1/2012"), 209400);
		yusufaliu234.getGestor().registrarReproduccion(threewiseguys,
				format.parse("5/3/2012"), 457200);
		yusufaliu234.getGestor().registrarReproduccion(jackiebrown,
				format.parse("10/9/2012"), 225600);
		yusufaliu234.getGestor().registrarReproduccion(midnightrun,
				format.parse("15/7/2012"), 298800);
		yusufaliu234.getGestor().registrarReproduccion(jackiebrown,
				format.parse("20/1/2012"), 371400);
		yusufaliu234.getGestor().registrarReproduccion(thekingofcomedy,
				format.parse("27/12/2012"), 139800);
		yusufaliu234.getGestor().registrarReproduccion(thesimpsonsS1E13,
				format.parse("4/7/2013"), 83400);
		yusufaliu234.getGestor().registrarReproduccion(arthurandtheinvisibles,
				format.parse("20/9/2013"), 331800);
		yusufaliu234.getGestor().registrarReproduccion(barneyS1E17,
				format.parse("7/4/2013"), 304200);
		yusufaliu234.getGestor().registrarReproduccion(thesimpsonsS1E4,
				format.parse("12/6/2012"), 323400);
		yusufaliu234.getGestor().registrarReproduccion(newyorknewyork,
				format.parse("18/8/2013"), 292200);
		yusufaliu234.getGestor().registrarReproduccion(barneyS1E8,
				format.parse("23/3/2013"), 300000);
		yusufaliu234.getGestor().registrarReproduccion(breakingbadS1E1,
				format.parse("28/1/2012"), 337800);
		yusufaliu234.getGestor().registrarReproduccion(lastvegas,
				format.parse("15/7/2013"), 76800);
		yusufaliu234.getGestor().registrarReproduccion(threeroomsinmanhattan,
				format.parse("21/10/2013"), 500400);
		yusufaliu234.getGestor().registrarReproduccion(barneyS1E22,
				format.parse("26/12/2013"), 93600);
		yusufaliu234.getGestor().registrarReproduccion(threeroomsinmanhattan,
				format.parse("3/2/2012"), 517200);
		yusufaliu234.getGestor().registrarReproduccion(barneyS1E23,
				format.parse("8/4/2013"), 109800);
		yusufaliu234.getGestor().registrarReproduccion(billythekidmcdonnen,
				format.parse("15/7/2013"), 358200);
		yusufaliu234.getGestor().registrarReproduccion(samssong,
				format.parse("20/9/2013"), 431400);
		yusufaliu234.getGestor().registrarReproduccion(barneyS1E19,
				format.parse("8/12/2013"), 330600);
		yusufaliu234.getGestor().registrarReproduccion(thesimpsonsS1E6,
				format.parse("3/2/2012"), 349800);
		yusufaliu234.getGestor().registrarReproduccion(lasedadesdelamor,
				format.parse("18/8/2013"), 216000);
		yusufaliu234.getGestor().registrarReproduccion(barneyS1E10,
				format.parse("5/3/2012"), 304800);
		yusufaliu234.getGestor().registrarReproduccion(breakingbadS1E3,
				format.parse("11/5/2012"), 325800);
		yusufaliu234.getGestor().registrarReproduccion(angelheart,
				format.parse("16/8/2013"), 480600);
		yusufaliu234.getGestor().registrarReproduccion(encounter,
				format.parse("21/10/2013"), 378600);
		yusufaliu234.getGestor().registrarReproduccion(barneyS1E24,
				format.parse("9/4/2012"), 331200);
		yusufaliu234.getGestor().registrarReproduccion(thesimpsonsS1E10,
				format.parse("14/7/2013"), 342600);
		yusufaliu234.getGestor().registrarReproduccion(
				thegangthatcouldntshootstraight, format.parse("19/9/2013"),
				338400);
		yusufaliu234.getGestor().registrarReproduccion(barneyS1E14,
				format.parse("6/3/2012"), 106800);
		yusufaliu234.getGestor().registrarReproduccion(barneyS1E10,
				format.parse("5/3/2012"), 180000);
		yusufaliu234.getGestor().registrarReproduccion(barneyS1E26,
				format.parse("1/5/2013"), 357600);
		yusufaliu234.getGestor().registrarReproduccion(thedeerhunter,
				format.parse("28/5/2013"), 196200);
		yusufaliu234.getGestor().registrarReproduccion(lasedadesdelamor,
				format.parse("18/8/2012"), 139800);
		yusufaliu234.getGestor().registrarReproduccion(
				dearamericalettershomefromvietnamtvmoviedocumentary,
				format.parse("26/4/2012"), 351000);
		yusufaliu234.getGestor().registrarReproduccion(barneyS1E1,
				format.parse("3/2/2012"), 119400);
		yusufaliu234.getGestor().registrarReproduccion(whatjusthappened,
				format.parse("19/9/2013"), 367800);
		yusufaliu234.getGestor().registrarReproduccion(barneyS1E14,
				format.parse("24/11/2013"), 136200);
		yusufaliu234.getGestor().registrarReproduccion(thesimpsonsS1E1,
				format.parse("12/6/2012"), 255000);
		yusufaliu234.getGestor().registrarReproduccion(beingflynn,
				format.parse("17/8/2013"), 503400);
		yusufaliu234.getGestor().registrarReproduccion(onehundredandonenights,
				format.parse("22/10/2013"), 447000);
		yusufaliu234.getGestor().registrarReproduccion(trueconfessions,
				format.parse("27/12/2013"), 224400);
		yusufaliu234.getGestor().registrarReproduccion(barneyS1E6,
				format.parse("22/3/2013"), 328200);
		yusufaliu234.getGestor().registrarReproduccion(barneyS1E29,
				format.parse("1/5/2012"), 240600);
		yusufaliu234.getGestor().registrarReproduccion(brazil,
				format.parse("26/12/2012"), 313800);
		yusufaliu234.getGestor().registrarReproduccion(thesimpsonsS1E11,
				format.parse("4/2/2012"), 78000);
		yusufaliu234.getGestor().registrarReproduccion(stardust,
				format.parse("9/5/2012"), 150600);
		yusufaliu234.getGestor().registrarReproduccion(awakenings,
				format.parse("14/7/2013"), 528600);
		yusufaliu234.getGestor().registrarReproduccion(jenniferonmymind,
				format.parse("19/9/2013"), 472200);
		yusufaliu234.getGestor().registrarReproduccion(barneyS1E16,
				format.parse("25/11/2013"), 240600);
		yusufaliu234.getGestor().registrarReproduccion(thesimpsonsS1E3,
				format.parse("12/2/2012"), 184200);
		yusufaliu234.getGestor().registrarReproduccion(newyearseve,
				format.parse("7/8/2012"), 432000);
		yusufaliu234.setSesion(new Sesion(new Reproduccion(thegoodshepherd,
				format.parse("9/2/2014"), 446400), format.parse("9/2/2014")));
		sitio.registrarUsuario(yusufaliu234);

		return sitio;
	}

}
