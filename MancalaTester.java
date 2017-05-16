package mancala;

public class MancalaTester {

	public static void main(String[] args) {

		MancalaView mv = new MancalaView();
		MancalaModel mm = new MancalaModel();
		MancalaController mc = new MancalaController(mv, mm);

	}

}
