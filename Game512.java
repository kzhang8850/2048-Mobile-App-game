/**
 * Game512.java
 *
 * @author Scott Cao
 * @author Eric Chiu
 * @author Kevin Zhang
 * @version 2.00 2014/5/28
 */

package com.webs.game2048;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JPanel;

//multi-player
class Game512 extends JPanel {

	private GameBoard512 panel1;
	private GameBoard512 panel2;

	public Game512(int side) {
		initiate(side);
	}

	private void initiate(int side) {

		this.setLayout(new GridLayout(1, 2, 50, 50));
		panel1 = new GameBoard512(side, this);
		panel2 = new GameBoard512(side, this);
		this.add(panel1);
		this.add(panel2);

		panel1.setKeyListenerMode(false);
		panel2.setKeyListenerMode(true);

	}

	public GameBoard getGameBoard1() {
		return panel1;
	}

	public GameBoard getGameBoard2() {
		return panel2;
	}

	void gameOver(GameBoard512 gb, boolean lose) throws Exception {
		if (lose && panel1 == gb || !lose && panel2 == gb)
			MyGame.game.showController(MyGame.PLAYERTWOWINS);
		else
			MyGame.game.showController(MyGame.PLAYERONEWINS);
	}

}