package game;

import javafx.scene.image.*;


public class Landschaftskarte {

	Stapel ablageOrt;
	private Wiesenstueck[] wiesenstuecke;
	private Strassenabschnitt[] strassenabschnitte;
	private Stadtteil[] stadtteile;
	private boolean startkarte;
	private boolean kloster;
	private int[] legeNr;

	private double x,y,width,height;

	public Wiesenstueck[] getWiesenstuecke() {
		return this.wiesenstuecke;
	}

	public Strassenabschnitt[] getStrassenabschnitte() {
		return this.strassenabschnitte;
	}

	public Stadtteil[] getStadtteile() {
		return this.stadtteile;
	}

	public boolean isStartkarte() {
		return this.startkarte;
	}

	public boolean isKloster() {
		return this.kloster;
	}

	public int[] getLegeNr() {
		return this.legeNr;
	}

	public static Image getImage(){
		return new Image("images/D.png");
	}

	public double getX() {
		return 0;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return 0;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getWidth() {
		return 83;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return 83;
	}

	public void setHeight(double height) {
		this.height = height;
	}
}