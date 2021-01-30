package systeme;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WindowGame {
	private Distributeur distributeur;
	private Joueur joueurPropri;
	private List<Joueur> autreJoueur;
	private TasJeton tasJetonCoupDePouce;
	private TasJeton tasJetonCompetence;
	private List<TasPotion> pioche;
	
	public WindowGame(int nbjoueur,String prenom,String nom,List<String> prenomJ,List<String> nomJ,List<String> potionBani) {
		this.distributeur=new Distributeur();
		this.tasJetonCoupDePouce=new TasJetonCoupDePouce();
		
		//création du joueur qui agira sur le système de cette machine
		this.joueurPropri=new Joueur(prenom,nom,this);
		
		//création des autres joueur pour le score
		this.autreJoueur= new ArrayList<Joueur>();
		for(int i=0;i<prenomJ.size();i++) {
			this.autreJoueur.add(new Joueur(prenomJ.get(i),nomJ.get(i),this));
		}
		//création du tas de jeton compétence selon le nombre de joueur
		if(nbjoueur==2) {
			this.tasJetonCompetence=new TasJetonCompetence(4);
		}else if(nbjoueur==3) {
			this.tasJetonCompetence=new TasJetonCompetence(5);
		}else {
			this.tasJetonCompetence=new TasJetonCompetence(6);
		}
		
		//création de la pioche a mettre plutot dans la création de partie (dans la vue)
		this.pioche=new ArrayList<TasPotion>();
		this.creePioche(potionBani);
	}

	private void creePioche(List<String> potionBani) {
		//8 type de potion
		//8 potion par type
		//5 tas
		//10 par tas + 9 dans deux
		
		//création de toute les variables pour le nombre de potion de chaque type
		int nbSagesse=8;
		int nbElixirAmour=8;
		int nbAtractionMagnetique=8;
		int nbJoiePrismatique=8;
		int nbAbyssale=8;
		int nbSableTemps=8;
		int nbBaumeViscosité=8;
		int nbLavamancie=8;
		
		//mise a zero des potion bani
		
		if(potionBani.contains("Potion de sagesse")) {
			nbSagesse=0;
		}
		if(potionBani.contains("Elixir d'amour aveugle")) {
			nbElixirAmour=0;
		}
		if(potionBani.contains("Potion d'attraction magnétique")) {
			nbAtractionMagnetique=0;
		}
		if(potionBani.contains("Potion de joie prismatique")) {
			nbJoiePrismatique=0;
		}
		if(potionBani.contains("Potion abyssale")) {
			nbAbyssale=0;
		}
		if(potionBani.contains("Sables du temps")) {
			nbSableTemps=0;
		}
		if(potionBani.contains("Baume de viscosité suprême")) {
			nbBaumeViscosité=0;
		}
		if(potionBani.contains("Filtre de lavamancie")) {
			nbLavamancie=0;
		}
		
		//création des variables du nombre de puissance par type
		
		//Tous
		int nbBaumeViscosite4;
		int nbBaumeViscosite7;
		int nbBaumeViscosite5;
		int nbBaumeViscosite10;
		
		int nbSagesse5;
		int nbSagesse6;
		int nbSagesse11;
		int nbSagesse8;
		
		int nbElixirAmour5;
		int nbElixirAmour10;
		int nbElixirAmour4;
		int nbElixirAmour7;
		
		int nbAtractionMagnetique10;
		int nbAtractionMagnetique4;
		int nbAtractionMagnetique6;
		int nbAtractionMagnetique8;
		
		int nbJoiePrismatique7;
		int nbJoiePrismatique5;
		int nbJoiePrismatique3;
		int nbJoiePrismatique9;
		
		int nbAbyssale10;
		int nbAbyssale6;
		int nbAbyssale8;
		int nbAbyssale4;
		
		int nbSableTemps3;
		int nbSableTemps4;
		int nbSableTemps6;
		int nbSableTemps9;
		
		int nbLavamancie5;
		int nbLavamancie9;
		int nbLavamancie11;
		int nbLavamancie7;
		//viscosite
		if(nbBaumeViscosité!=0) {
			nbBaumeViscosite4=2;
			nbBaumeViscosite7=2;
			nbBaumeViscosite5=2;
			nbBaumeViscosite10=2;
		}else {
			nbBaumeViscosite4=0;
			nbBaumeViscosite7=0;
			nbBaumeViscosite5=0;
			nbBaumeViscosite10=0;
		}
		
		//sagesse
		if(nbSagesse!=0) {
			nbSagesse5=2;
			nbSagesse6=2;
			nbSagesse11=2;
			nbSagesse8=2;
		}else {
			nbSagesse5=0;
			nbSagesse6=0;
			nbSagesse11=0;
			nbSagesse8=0;
		}
		
		//amour
		if(nbElixirAmour!=0) {
			nbElixirAmour5=2;
			nbElixirAmour10=2;
			nbElixirAmour4=2;
			nbElixirAmour7=2;
		}else {
			nbElixirAmour5=0;
			nbElixirAmour10=0;
			nbElixirAmour4=0;
			nbElixirAmour7=0;
		}
		
		//magnétique
		if(nbAtractionMagnetique!=0) {
			nbAtractionMagnetique10=2;
			nbAtractionMagnetique4=2;
			nbAtractionMagnetique6=2;
			nbAtractionMagnetique8=2;
		}else {
			nbAtractionMagnetique10=0;
			nbAtractionMagnetique4=0;
			nbAtractionMagnetique6=0;
			nbAtractionMagnetique8=0;
		}
		
		//joie
		if(nbJoiePrismatique!=0) {
			nbJoiePrismatique7=2;
			nbJoiePrismatique5=2;
			nbJoiePrismatique3=2;
			nbJoiePrismatique9=2;
		}else {
			nbJoiePrismatique7=0;
			nbJoiePrismatique5=0;
			nbJoiePrismatique3=0;
			nbJoiePrismatique9=0;
		}
		
		//abyssale
		if(nbAbyssale!=0) {
			nbAbyssale10=2;
			nbAbyssale6=2;
			nbAbyssale8=2;
			nbAbyssale4=2;
		}else {
			nbAbyssale10=0;
			nbAbyssale6=0;
			nbAbyssale8=0;
			nbAbyssale4=0;
		}
		
		//sable du temps
		if(nbSableTemps!=0) {
			nbSableTemps3=2;
			nbSableTemps4=2;
			nbSableTemps6=2;
			nbSableTemps9=2;
		}else {
			nbSableTemps3=0;
			nbSableTemps4=0;
			nbSableTemps6=0;
			nbSableTemps9=0;
		}
		
		//lavamancie
		if(nbLavamancie!=0) {
			nbLavamancie5=2;
			nbLavamancie9=2;
			nbLavamancie11=2;
			nbLavamancie7=2;
		}else {
			nbLavamancie5=0;
			nbLavamancie9=0;
			nbLavamancie11=0;
			nbLavamancie7=0;
		}
		
		//création des tas de potions
		for(int i=0;i<5;i++) {
			TasPotion tp = new TasPotion();
			if(i<3) {
				for(int j=0;j<10;j++) {
					//crée les potions
					Random rtype = new Random();
					Random rpuissance = new Random();
					
					int type = rtype.nextInt(8);
					if(type == 0) {
						if(nbSagesse!=0) {
							//random de la puissance choisi
							int nb = rpuissance.nextInt(4);
							
							if(nb==0 && nbSagesse5!=0) {
								
								tp.getPotion().add(new Potion("Potion de sagesse",5,0,2,0,2));
								nbSagesse5-=1;
								nbSagesse-=1;
							}else if(nb==1 && nbSagesse6!=0) {
								
								tp.getPotion().add(new Potion("Potion de sagesse",6,2,2,1,0));
								nbSagesse6-=1;
								nbSagesse-=1;
							}else if(nb==2 && nbSagesse11!=0) {
								
								tp.getPotion().add(new Potion("Potion de sagesse",11,1,2,4,0));
								nbSagesse11-=1;
								nbSagesse-=1;
							}else if(nb==3 && nbSagesse8!=0) {
								
								tp.getPotion().add(new Potion("Potion de sagesse",8,2,0,0,4));
								nbSagesse8-=1;
								nbSagesse-=1;
							}else {
								j=j-1;
							}
							
						}else {
							j=j-1;
						}
					}else if(type == 1){
						if(nbElixirAmour!=0) {
							//random de la puissance choisi
							int nb = rpuissance.nextInt(4);
							
							if(nb==0 && nbElixirAmour5!=0) {
								
								tp.getPotion().add(new Potion("Elixir d'amour aveugle",5,0,0,3,2));
								nbElixirAmour5-=1;
								nbElixirAmour-=1;
							}else if(nb==1 && nbElixirAmour10!=0) {
								
								tp.getPotion().add(new Potion("Elixir d'amour aveugle",10,3,4,0,0));
								nbElixirAmour10-=1;
								nbElixirAmour-=1;
							}else if(nb==2 && nbElixirAmour4!=0) {
								
								tp.getPotion().add(new Potion("Elixir d'amour aveugle",4,1,1,0,2));
								nbElixirAmour4-=1;
								nbElixirAmour-=1;
							}else if(nb==3 && nbElixirAmour7!=0) {
								
								tp.getPotion().add(new Potion("Elixir d'amour aveugle",7,2,0,3,1));
								nbElixirAmour7-=1;
								nbElixirAmour-=1;
							}else {
								j=j-1;
							}
							
						}else {
							j=j-1;
						}
					}else if(type == 2) {
						if(nbAtractionMagnetique!=0) {
							//random de la puissance choisi
							int nb = rpuissance.nextInt(4);
							
							if(nb==0 && nbAtractionMagnetique10!=0) {
								
								tp.getPotion().add(new Potion("Potion d'attraction magnétique",10,2,1,0,4));
								nbAtractionMagnetique10-=1;
								nbAtractionMagnetique-=1;
							}else if(nb==1 && nbAtractionMagnetique4!=0) {
								
								tp.getPotion().add(new Potion("Potion d'attraction magnétique",4,2,0,2,0));
								nbAtractionMagnetique4-=1;
								nbAtractionMagnetique-=1;
							}else if(nb==2 && nbAtractionMagnetique6!=0) {
								
								tp.getPotion().add(new Potion("Potion d'attraction magnétique",6,2,2,0,1));
								nbAtractionMagnetique6-=1;
								nbAtractionMagnetique-=1;
							}else if(nb==3 && nbAtractionMagnetique8!=0) {
								
								tp.getPotion().add(new Potion("Potion d'attraction magnétique",8,0,2,4,0));
								nbAtractionMagnetique8-=1;
								nbAtractionMagnetique-=1;
							}else {
								j=j-1;
							}
						}else {
							j=j-1;
						}
					}else if(type == 3) {
						if(nbJoiePrismatique!=0) {
							//random de la puissance choisi
							int nb = rpuissance.nextInt(4);
							
							if(nb==0 && nbJoiePrismatique7!=0) {
								
								tp.getPotion().add(new Potion("Potion de joie prismatique",7,3,1,2,0));
								nbJoiePrismatique7-=1;
								nbJoiePrismatique-=1;
							}else if(nb==1 && nbJoiePrismatique5!=0) {
								
								tp.getPotion().add(new Potion("Potion de joie prismatique",5,3,2,0,0));
								nbJoiePrismatique5-=1;
								nbJoiePrismatique-=1;
							}else if(nb==2 && nbJoiePrismatique3!=0) {
								
								tp.getPotion().add(new Potion("Potion de joie prismatique",3,0,2,1,1));
								nbJoiePrismatique3-=1;
								nbJoiePrismatique-=1;
							}else if(nb==3 && nbJoiePrismatique9!=0) {
								
								tp.getPotion().add(new Potion("Potion de joie prismatique",9,0,0,3,4));
								nbJoiePrismatique9-=1;
								nbJoiePrismatique-=1;
							}else {
								j=j-1;
							}
							
						}else {
							j=j-1;
						}
					}else if(type == 4) {
						if(nbAbyssale!=0) {
							//random de la puissance choisi
							int nb = rpuissance.nextInt(4);
							
							if(nb==0 && nbAbyssale10!=0) {
								
								tp.getPotion().add(new Potion("Potion abyssale",10,4,0,2,1));
								nbAbyssale10-=1;
								nbAbyssale-=1;
							}else if(nb==1 && nbAbyssale6!=0) {
								
								tp.getPotion().add(new Potion("Potion abyssale",6,1,0,2,2));
								nbAbyssale6-=1;
								nbAbyssale-=1;
							}else if(nb==2 && nbAbyssale8!=0) {
								
								tp.getPotion().add(new Potion("Potion abyssale",8,0,4,0,2));
								nbAbyssale8-=1;
								nbAbyssale-=1;
							}else if(nb==3 && nbAbyssale4!=0) {
								
								tp.getPotion().add(new Potion("Potion abyssale",4,0,2,2,0));
								nbAbyssale4-=1;
								nbAbyssale-=1;
							}else {
								j=j-1;
							}
						}else {
							j=j-1;
						}
					}else if(type == 5) {
						if(nbSableTemps!=0) {
							//random de la puissance choisi
							int nb = rpuissance.nextInt(4);
							
							if(nb==0 && nbSableTemps3!=0) {
								
								tp.getPotion().add(new Potion("Sables du temps",3,2,0,0,2));
								nbSableTemps3-=1;
								nbSableTemps-=1;
							}else if(nb==1 && nbSableTemps4!=0) {
								
								tp.getPotion().add(new Potion("Sables du temps",4,0,1,2,2));
								nbSableTemps4-=1;
								nbSableTemps-=1;
							}else if(nb==2 && nbSableTemps6!=0) {
								
								tp.getPotion().add(new Potion("Sables du temps",6,4,0,2,0));
								nbSableTemps6-=1;
								nbSableTemps-=1;
							}else if(nb==3 && nbSableTemps9!=0) {
								
								tp.getPotion().add(new Potion("Sables du temps",9,0,4,1,2));
								nbSableTemps9-=1;
								nbSableTemps-=1;
							}else {
								j=j-1;
							}
						}else {
							j=j-1;
						}
					}else if(type == 6) {
						if(nbBaumeViscosité!=0) {
							//random de la puissance choisi
							int nb = rpuissance.nextInt(4);
							
							if(nb==0 && nbBaumeViscosite4!=0) {
								
								tp.getPotion().add(new Potion("Baume de viscosité suprême",4,2,1,1,0));
								nbBaumeViscosite4-=1;
								nbBaumeViscosité-=1;
							}else if(nb==1 && nbBaumeViscosite7!=0) {
								
								tp.getPotion().add(new Potion("Baume de viscosité suprême",7,1,2,0,3));
								nbBaumeViscosite7-=1;
								nbBaumeViscosité-=1;
							}else if(nb==2 && nbBaumeViscosite5!=0) {
								
								tp.getPotion().add(new Potion("Baume de viscosité suprême",5,2,0,0,3));
								nbBaumeViscosite5-=1;
								nbBaumeViscosité-=1;
							}else if(nb==3 && nbBaumeViscosite10!=0) {
								
								tp.getPotion().add(new Potion("Baume de viscosité suprême",10,0,3,4,0));
								nbBaumeViscosite10-=1;
								nbBaumeViscosité-=1;
							}else {
								j=j-1;
							}
						}else {
							j=j-1;
						}
					}else if(type == 7) {
						if(nbLavamancie!=0) {
							//random de la puissance choisi
							int nb = rpuissance.nextInt(4);
							
							if(nb==0 && nbLavamancie5!=0) {
								
								tp.getPotion().add(new Potion("Filtre de lavamancie",5,1,0,2,1));
								nbLavamancie5-=1;
								nbLavamancie-=1;
							}else if(nb==1 && nbLavamancie9!=0) {
								
								tp.getPotion().add(new Potion("Filtre de lavamancie",9,0,3,1,2));
								nbLavamancie9-=1;
								nbLavamancie-=1;
							}else if(nb==2 && nbLavamancie11!=0) {
								
								tp.getPotion().add(new Potion("Filtre de lavamancie",11,4,0,0,3));
								nbLavamancie11-=1;
								nbLavamancie-=1;
							}else if(nb==3 && nbLavamancie7!=0) {
								
								tp.getPotion().add(new Potion("Filtre de lavamancie",7,0,3,2,0));
								nbLavamancie7-=1;
								nbLavamancie-=1;
							}else {
								j=j-1;
							}
						}else {
							j=j-1;
						}
					}
				}
				this.pioche.add(tp);
			}else {
				for(int j=0;j<9;j++) {
					//crée les potions
					Random rtype = new Random();
					Random rpuissance = new Random();
					
					int type = rtype.nextInt(8);
					if(type == 0) {
						if(nbSagesse!=0) {
							//random de la puissance choisi
							int nb = rpuissance.nextInt(4);
							
							if(nb==0 && nbSagesse5!=0) {
								
								tp.getPotion().add(new Potion("Potion de sagesse",5,0,2,0,2));
								nbSagesse5-=1;
								nbSagesse-=1;
							}else if(nb==1 && nbSagesse6!=0) {
								
								tp.getPotion().add(new Potion("Potion de sagesse",6,2,2,1,0));
								nbSagesse6-=1;
								nbSagesse-=1;
							}else if(nb==2 && nbSagesse11!=0) {
								
								tp.getPotion().add(new Potion("Potion de sagesse",11,1,2,4,0));
								nbSagesse11-=1;
								nbSagesse-=1;
							}else if(nb==3 && nbSagesse8!=0) {
								
								tp.getPotion().add(new Potion("Potion de sagesse",8,2,0,0,4));
								nbSagesse8-=1;
								nbSagesse-=1;
							}else {
								j=j-1;
							}
							
						}else {
							j=j-1;
						}
					}else if(type == 1){
						if(nbElixirAmour!=0) {
							//random de la puissance choisi
							int nb = rpuissance.nextInt(4);
							
							if(nb==0 && nbElixirAmour5!=0) {
								
								tp.getPotion().add(new Potion("Elixir d'amour aveugle",5,0,0,3,2));
								nbElixirAmour5-=1;
								nbElixirAmour-=1;
							}else if(nb==1 && nbElixirAmour10!=0) {
								
								tp.getPotion().add(new Potion("Elixir d'amour aveugle",10,3,4,0,0));
								nbElixirAmour10-=1;
								nbElixirAmour-=1;
							}else if(nb==2 && nbElixirAmour4!=0) {
								
								tp.getPotion().add(new Potion("Elixir d'amour aveugle",4,1,1,0,2));
								nbElixirAmour4-=1;
								nbElixirAmour-=1;
							}else if(nb==3 && nbElixirAmour7!=0) {
								
								tp.getPotion().add(new Potion("Elixir d'amour aveugle",7,2,0,3,1));
								nbElixirAmour7-=1;
								nbElixirAmour-=1;
							}else {
								j=j-1;
							}
							
						}else {
							j=j-1;
						}
					}else if(type == 2) {
						if(nbAtractionMagnetique!=0) {
							//random de la puissance choisi
							int nb = rpuissance.nextInt(4);
							
							if(nb==0 && nbAtractionMagnetique10!=0) {
								
								tp.getPotion().add(new Potion("Potion d'attraction magnétique",10,2,1,0,4));
								nbAtractionMagnetique10-=1;
								nbAtractionMagnetique-=1;
							}else if(nb==1 && nbAtractionMagnetique4!=0) {
								
								tp.getPotion().add(new Potion("Potion d'attraction magnétique",4,2,0,2,0));
								nbAtractionMagnetique4-=1;
								nbAtractionMagnetique-=1;
							}else if(nb==2 && nbAtractionMagnetique6!=0) {
								
								tp.getPotion().add(new Potion("Potion d'attraction magnétique",6,2,2,0,1));
								nbAtractionMagnetique6-=1;
								nbAtractionMagnetique-=1;
							}else if(nb==3 && nbAtractionMagnetique8!=0) {
								
								tp.getPotion().add(new Potion("Potion d'attraction magnétique",8,0,2,4,0));
								nbAtractionMagnetique8-=1;
								nbAtractionMagnetique-=1;
							}else {
								j=j-1;
							}
						}else {
							j=j-1;
						}
					}else if(type == 3) {
						if(nbJoiePrismatique!=0) {
							//random de la puissance choisi
							int nb = rpuissance.nextInt(4);
							
							if(nb==0 && nbJoiePrismatique7!=0) {
								
								tp.getPotion().add(new Potion("Potion de joie prismatique",7,3,1,2,0));
								nbJoiePrismatique7-=1;
								nbJoiePrismatique-=1;
							}else if(nb==1 && nbJoiePrismatique5!=0) {
								
								tp.getPotion().add(new Potion("Potion de joie prismatique",5,3,2,0,0));
								nbJoiePrismatique5-=1;
								nbJoiePrismatique-=1;
							}else if(nb==2 && nbJoiePrismatique3!=0) {
								
								tp.getPotion().add(new Potion("Potion de joie prismatique",3,0,2,1,1));
								nbJoiePrismatique3-=1;
								nbJoiePrismatique-=1;
							}else if(nb==3 && nbJoiePrismatique9!=0) {
								
								tp.getPotion().add(new Potion("Potion de joie prismatique",9,0,0,3,4));
								nbJoiePrismatique9-=1;
								nbJoiePrismatique-=1;
							}else {
								j=j-1;
							}
							
						}else {
							j=j-1;
						}
					}else if(type == 4) {
						if(nbAbyssale!=0) {
							//random de la puissance choisi
							int nb = rpuissance.nextInt(4);
							
							if(nb==0 && nbAbyssale10!=0) {
								
								tp.getPotion().add(new Potion("Potion abyssale",10,4,0,2,1));
								nbAbyssale10-=1;
								nbAbyssale-=1;
							}else if(nb==1 && nbAbyssale6!=0) {
								
								tp.getPotion().add(new Potion("Potion abyssale",6,1,0,2,2));
								nbAbyssale6-=1;
								nbAbyssale-=1;
							}else if(nb==2 && nbAbyssale8!=0) {
								
								tp.getPotion().add(new Potion("Potion abyssale",8,0,4,0,2));
								nbAbyssale8-=1;
								nbAbyssale-=1;
							}else if(nb==3 && nbAbyssale4!=0) {
								
								tp.getPotion().add(new Potion("Potion abyssale",4,0,2,2,0));
								nbAbyssale4-=1;
								nbAbyssale-=1;
							}else {
								j=j-1;
							}
						}else {
							j=j-1;
						}
					}else if(type == 5) {
						if(nbSableTemps!=0) {
							//random de la puissance choisi
							int nb = rpuissance.nextInt(4);
							
							if(nb==0 && nbSableTemps3!=0) {
								
								tp.getPotion().add(new Potion("Sables du temps",3,2,0,0,2));
								nbSableTemps3-=1;
								nbSableTemps-=1;
							}else if(nb==1 && nbSableTemps4!=0) {
								
								tp.getPotion().add(new Potion("Sables du temps",4,0,1,2,2));
								nbSableTemps4-=1;
								nbSableTemps-=1;
							}else if(nb==2 && nbSableTemps6!=0) {
								
								tp.getPotion().add(new Potion("Sables du temps",6,4,0,2,0));
								nbSableTemps6-=1;
								nbSableTemps-=1;
							}else if(nb==3 && nbSableTemps9!=0) {
								
								tp.getPotion().add(new Potion("Sables du temps",9,0,4,1,2));
								nbSableTemps9-=1;
								nbSableTemps-=1;
							}else {
								j=j-1;
							}
						}else {
							j=j-1;
						}
					}else if(type == 6) {
						if(nbBaumeViscosité!=0) {
							//random de la puissance choisi
							int nb = rpuissance.nextInt(4);
							
							if(nb==0 && nbBaumeViscosite4!=0) {
								
								tp.getPotion().add(new Potion("Baume de viscosité suprême",4,2,1,1,0));
								nbBaumeViscosite4-=1;
								nbBaumeViscosité-=1;
							}else if(nb==1 && nbBaumeViscosite7!=0) {
								
								tp.getPotion().add(new Potion("Baume de viscosité suprême",7,1,2,0,3));
								nbBaumeViscosite7-=1;
								nbBaumeViscosité-=1;
							}else if(nb==2 && nbBaumeViscosite5!=0) {
								
								tp.getPotion().add(new Potion("Baume de viscosité suprême",5,2,0,0,3));
								nbBaumeViscosite5-=1;
								nbBaumeViscosité-=1;
							}else if(nb==3 && nbBaumeViscosite10!=0) {
								
								tp.getPotion().add(new Potion("Baume de viscosité suprême",10,0,3,4,0));
								nbBaumeViscosite10-=1;
								nbBaumeViscosité-=1;
							}else {
								j=j-1;
							}
						}else {
							j=j-1;
						}
					}else if(type == 7) {
						if(nbLavamancie!=0) {
							//random de la puissance choisi
							int nb = rpuissance.nextInt(4);
							
							if(nb==0 && nbLavamancie5!=0) {
								
								tp.getPotion().add(new Potion("Filtre de lavamancie",5,1,0,2,1));
								nbLavamancie5-=1;
								nbLavamancie-=1;
							}else if(nb==1 && nbLavamancie9!=0) {
								
								tp.getPotion().add(new Potion("Filtre de lavamancie",9,0,3,1,2));
								nbLavamancie9-=1;
								nbLavamancie-=1;
							}else if(nb==2 && nbLavamancie11!=0) {
								
								tp.getPotion().add(new Potion("Filtre de lavamancie",11,4,0,0,3));
								nbLavamancie11-=1;
								nbLavamancie-=1;
							}else if(nb==3 && nbLavamancie7!=0) {
								
								tp.getPotion().add(new Potion("Filtre de lavamancie",7,0,3,2,0));
								nbLavamancie7-=1;
								nbLavamancie-=1;
							}else {
								j=j-1;
							}
						}else {
							j=j-1;
						}
					}
					
				}
				this.pioche.add(tp);
			}
		}
	}
	
	public void AfficherPartie() {
		
	}
	
	public void CréerPartie() {
		
	}
	public void RejoindrePartie() {
		
	}
	//normalement inutile//
	public void VerifPotion() {
		
	}
	///////////////////////////
	public void AfficherPotion() {
		
	}
	public void FinirPartie() {
		
	}
	public void afficherBilles() {
		
	}
	public void selectionneBille() {
		
	}
	
	//distribue les billes dans le distributeur
	public void distribuer(List<Bille> billes) {
		this.distributeur.distribuer(billes);
	}
	
	//geteur
	public Distributeur getDistributeur() {
		return distributeur;
	}

	public Joueur getJoueurPropri() {
		return joueurPropri;
	}

	public List<Joueur> getAutreJoueur() {
		return autreJoueur;
	}

	public TasJeton getTasJetonCoupDePouce() {
		return tasJetonCoupDePouce;
	}

	public TasJeton getTasJetonCompetence() {
		return tasJetonCompetence;
	}

	public List<TasPotion> getPioche() {
		return pioche;
	}

	public void piocheVide() {
		boolean vide = true;
		for(int i =0 ; i<this.pioche.size();i++) {
			if(!this.pioche.get(i).isEmpty()) {
				vide=false;
			}
		}
		if(vide) {
			this.FinirPartie();
		}
		
	}
	
	public static void main(String[] args) {
		//int nbjoueur,String prenom,String nom,List<String> prenomJ,List<String> nomJ,List<String> potionBani
		List<String> pj = new ArrayList<String>();
		List<String> nj = new ArrayList<String>();
		List<String> pb = new ArrayList<String>();
		
		pj.add("Gaylord");
		pj.add("Amadou");
		pj.add("Adrien");
		
		nj.add("Delporte");
		nj.add("Gacko");
		nj.add("Chauvency");
		
		pb.add("Filtre de lavamancie");
		pb.add("Baume de viscosité suprême");
		
		System.out.println("commencement");
		
		WindowGame wg = new WindowGame(4,"Bryan","Moreau",pj,nj,pb);
		
		for(int i =0;i<wg.getPioche().size();i++) {
			System.out.println(wg.getPioche().get(i));
		}
		System.out.println("Fini");
	}
	
	
}
