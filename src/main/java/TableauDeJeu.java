public class TableauDeJeu {

	public Carree[][] tableau;

	private int grille = 4;

	private int bordure = 0;

	public int score = 0;

	public TableauDeJeu() {

		tableau = new Carree[4][4];
		for (int i = 0; i < tableau.length; i++) {
			for (int j = 0; j < tableau[i].length; j++) {
				tableau[i][j] = new Carree();
			}
		}
	}

	// A finir plus tard !!
	public TableauDeJeu(int taille) {
		this.grille = taille;
		tableau = new Carree[grille][grille];
		for (int i = 0; i < tableau.length; i++) {
			for (int j = 0; j < tableau[i].length; j++) {
				tableau[i][j] = new Carree();
			}
		}
	}

	public Carree[][] getTableau() {
		return tableau;
	}

	public int getScore() {
		return score;
	}

	public int getLeCarreeLePlusGros() {

		int indicePlusGros = tableau[0][0].getValeur();
		for (int i = 0; i < tableau.length; i++)
		{
			for (int j = 0; j < tableau[i].length; j++)
			{
				if (tableau[i][j].getValeur() > indicePlusGros)
				{
					indicePlusGros = tableau[i][j].getValeur();
				}
			}
		}
		return indicePlusGros;
	}

	public void affichage() {
		for (int i = 0; i < tableau.length; i++) {
			for (int j = 0; j < tableau[i].length; j++) {
				String str = tableau[i][j].toString() + " ";
				System.out.println(str);
			}
			System.out.println("");
		}
		System.out.println("Sxore : " + score);
	}

	@Override
	public String toString() {
		String str = "";
		for (int i = 0; i < tableau.length; i++) {
			for (int j = 0; j < tableau[i].length; j++) {
				str += tableau.toString() + " ";
			}
			str += "\n";
		}
		return str;
	}


	public void generation() {

		boolean vide = true;
		while (vide == true) {
			int ligne = (int) (Math.random() * 4);
			int colonne = (int) (Math.random() * 4);
			double x = Math.random();
			if (tableau[ligne][colonne].getValeur() == 0) {
				if (x < 0.2) {
					tableau[ligne][colonne] = new Carree(4);
					vide = false;
				} else {
					tableau[ligne][colonne] = new Carree(2);
					vide = false;
				}
			}
		}
	}

	public boolean reset() {
		int compteur = 0;
		for (int i = 0; i < tableau.length; i++) {
			for (int j = 0; j < tableau.length; j++) {
				if (tableau[i][j].getValeur() > 0) {
					compteur++;
				}
			}
		}
		if (compteur == 16) {
			return true;
		}
		return false;
	}

	public boolean partieTerminee() {
		int compteur = 0;
		for (int i = 0; i < tableau.length; i++) {
			for (int j = 0; j < tableau[i].length; j++) {
				if (tableau[i][j].getValeur() > 0) {
					if (i == 0 && j == 0) {
						if (tableau[i][j].getValeur() != tableau[i + 1][j].getValeur()
								&& tableau[i][j].getValeur() != tableau[i][j + 1].getValeur()) {
							compteur++;
						}
					} else if (i == 0 && j == 3) {
						if (tableau[i][j].getValeur() != tableau[i + 1][j].getValeur()
								&& tableau[i][j].getValeur() != tableau[i][j - 1].getValeur()) {
							compteur++;
						}
					} else if (i == 3 && j == 3) {
						if (tableau[i][j].getValeur() != tableau[i - 1][j].getValeur()
								&& tableau[i][j].getValeur() != tableau[i][j - 1].getValeur()) {
							compteur++;
						}
					} else if (i == 3 && j == 0) {
						if (tableau[i][j].getValeur() != tableau[i - 1][j].getValeur()
								&& tableau[i][j].getValeur() != tableau[i][j + 1].getValeur()) {
							compteur++;
						}
					} else if (i == 0 && (j == 1 || j == 2)) {
						if (tableau[i][j].getValeur() != tableau[i + 1][j].getValeur()
								&& tableau[i][j].getValeur() != tableau[i][j + 1].getValeur()
								&& tableau[i][j].getValeur() != tableau[i][j - 1].getValeur()) {
							compteur++;
						}
					} else if (i == 3 && (j == 1 || j == 2)) {
						if (tableau[i][j].getValeur() != tableau[i - 1][j].getValeur()
								&& tableau[i][j].getValeur() != tableau[i][j + 1].getValeur()
								&& tableau[i][j].getValeur() != tableau[i][j - 1].getValeur()) {
							compteur++;
						}
					} else if (j == 0 && (i == 1 || i == 2)) {
						if (tableau[i][j].getValeur() != tableau[i][j + 1].getValeur()
								&& tableau[i][j].getValeur() != tableau[i - 1][j].getValeur()
								&& tableau[i][j].getValeur() != tableau[i + 1][j].getValeur()) {
							compteur++;
						}
					} else if (j == 3 && (i == 1 || i == 2)) {
						if (tableau[i][j].getValeur() != tableau[i][j - 1].getValeur()
								&& tableau[i][j].getValeur() != tableau[i - 1][j].getValeur()
								&& tableau[i][j].getValeur() != tableau[i + 1][j].getValeur()) {
							compteur++;
						}
					} else {
						if (tableau[i][j].getValeur() != tableau[i][j - 1].getValeur()
								&& tableau[i][j].getValeur() != tableau[i][j + 1].getValeur()
								&& tableau[i][j].getValeur() != tableau[i - 1][j].getValeur()
								&& tableau[i][j].getValeur() != tableau[i + 1][j].getValeur()) {
							compteur++;
						}
					}
				}
			}
		}
		if (compteur == 16) {
			return true;
		}
		return false;
	}


	public void monter() {
		for (int i = 0; i < grille; i++) {
			bordure = 0;
			for (int j = 0; j < grille; j++) {
				if (tableau[i][j].getValeur() != 0) {
					if (bordure <= j) {
						mouvementVertical(j, i, "monter");
					}
				}
			}
		}
	}

	public void descendre() {
		for (int i = 0; i < grille; i++) {
			bordure = (grille - 1);
			for (int j = grille - 1; j >= 0; j--) {
				if (tableau[i][j].getValeur() != 0) {
					if (bordure >= j) {
						mouvementVertical(j, i, "descendre");
					}
				}
			}
		}
	}

	public void mouvementVertical(int ligne, int colonne, String direction) {
		Carree initiale = tableau[bordure][colonne];
		Carree comparer = tableau[ligne][colonne];
		if (initiale.getValeur() == 0 || initiale.getValeur() == comparer.getValeur()) {
			if (ligne > bordure || (direction.equals("descendre") && (ligne < bordure))) {
				int ajoutPoint = initiale.getValeur() + comparer.getValeur();
				if (initiale.getValeur() != 0) {
					score += ajoutPoint;
				}
				initiale.setValeur(ajoutPoint);
				comparer.setValeur(0);
			}
		} else {
			if (direction.equals("descendre")) {
				bordure--;
			} else {
				bordure++;
			}
			mouvementVertical(ligne, colonne, direction);
		}
	}

	public void gauche()
	{
		for ( int i = 0; i < grille; i++ )
		{
			bordure = 0;
			for ( int j = 0; j < grille; j++ )
			{
				if ( tableau[i][j].getValeur() != 0 )
				{
					if ( bordure <= j )
					{
						mouvementHorizontale( i, j, "gauche" );
					}
				}
			}
		}
	}

	public void droite()
	{
		for ( int i = 0; i < grille; i++ )
		{
			bordure = ( grille - 1 );
			for ( int j = ( grille - 1 ); j >= 0; j-- )
			{
				if ( tableau[i][j].getValeur() != 0 )
				{
					if ( bordure >= j )
					{
						mouvementHorizontale( i, j, "droite" );
					}
				}
			}
		}
	}

	private void mouvementHorizontale( int ligne, int colonne, String direction )
	{
		Carree initial = tableau[ligne][bordure];
		Carree compare = tableau[ligne][colonne];
		if ( initial.getValeur() == 0 || initial.getValeur() == compare.getValeur() )
		{
			if ( colonne > bordure || ( direction.equals( "droite" ) && ( colonne < bordure ) ) )
			{
				int ajoutPoint = initial.getValeur() + compare.getValeur();
				if ( initial.getValeur() != 0 )
				{
					score += ajoutPoint;
				}
				initial.setValeur( ajoutPoint );
				compare.setValeur( 0 );
			}
		}
		else
		{
			if ( direction.equals( "right" ) )
			{
				bordure--;
			}
			else
			{
				bordure++;
			}
			mouvementHorizontale( ligne, colonne, direction );
		}
	}






}
