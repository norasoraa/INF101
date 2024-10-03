package no.uib.inf101.pacman.controller;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Timer;

import no.uib.inf101.pacman.model.Direction;
import no.uib.inf101.pacman.view.PacManView;
import no.uib.inf101.pacman.model.GameState;

/**
 * A class whose area of responsibility is to change the model based on input
 * from the user, as well as control things that happen by themselves (such as
 * moving the ghosts at regular intervals).
 */
public class PacManController implements KeyListener {

  private ControllablePacManModel model;
  private PacManView view;
  private Timer timer;

  /**
   * Constructs a PacManController object with the given ControllablePacManModel
   * and PacManView objects. Initializes key events handling and timer for
   * automatic movement of entities.
   * 
   * @param controllableModel the model to be controlled, represented as a
   *                          {@link ControllablePacManModel}
   * @param view              a {@link PacManView} that represents a visual
   *                          element that can gain focus and receive keystrokes
   */
  public PacManController(ControllablePacManModel controllableModel, PacManView view) {
    this.model = controllableModel;
    this.view = view;
    view.setFocusable(true);
    view.addKeyListener(this);

    this.timer = new Timer(model.getTimerDelay(), this::clockTick);
    this.timer.start();
  }

  @Override
  public void keyPressed(KeyEvent e) {
    if (model.getGameState() == GameState.GAME_OVER) {
      return;
    }
    if (model.getGameState() == GameState.START_GAME) {
      if (e.getKeyCode() == KeyEvent.VK_SPACE) {
        model.setGameState(GameState.ACTIVE_GAME);
      }
    }
    if (model.getGameState() == GameState.ACTIVE_GAME) {
      if (e.getKeyCode() == KeyEvent.VK_LEFT) {
        model.movePacMan(Direction.LEFT);
      } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
        model.movePacMan(Direction.RIGHT);
      } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
        model.movePacMan(Direction.DOWN);
      } else if (e.getKeyCode() == KeyEvent.VK_UP) {
        model.movePacMan(Direction.UP);
      }
    }
    view.repaint();
  }

  @Override
  public void keyTyped(KeyEvent e) {
  }

  @Override
  public void keyReleased(KeyEvent e) {
  }

  private void clockTick(ActionEvent e) {
    if (model.getGameState() == GameState.ACTIVE_GAME) {
      model.clockTick();
      view.repaint();
    }
  }

}
