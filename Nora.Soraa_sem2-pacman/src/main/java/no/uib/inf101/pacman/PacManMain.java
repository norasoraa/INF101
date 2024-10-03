package no.uib.inf101.pacman;

import java.io.IOException;

import javax.swing.JFrame;

import no.uib.inf101.pacman.controller.PacManController;
import no.uib.inf101.pacman.model.PacManBoard;
import no.uib.inf101.pacman.model.PacManModel;
import no.uib.inf101.pacman.model.entities.GhostFactory;
import no.uib.inf101.pacman.model.entities.RandomGhostFactory;
import no.uib.inf101.pacman.view.PacManView;

/** This class contains the main-method which we use to start PacMan. */
public class PacManMain {

  public static final String WINDOW_TITLE = "PAC-MAN";

  public static void main(String[] args) throws IOException {

    PacManBoard board = new PacManBoard(23, 23, "pacManBoard.txt");
    GhostFactory ghostFactory = new RandomGhostFactory();
    PacManModel model = new PacManModel(board, ghostFactory);
    PacManView view = new PacManView(model);
    new PacManController(model, view);

    JFrame frame = new JFrame(WINDOW_TITLE);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    frame.setContentPane(view);

    frame.pack();
    frame.setVisible(true);
  }
}
