package no.uib.inf101.tetris.controller;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.Timer;

import no.uib.inf101.tetris.midi.TetrisSong;
import no.uib.inf101.tetris.model.GameState;
import no.uib.inf101.tetris.view.TetrisView;

/**
 * A class whose area of responsibility is to change the model based on input
 * from the user, as well as control things that happen by themselves (such as
 * the piece falling down a row at regular intervals).
 */
public class TetrisController implements java.awt.event.KeyListener {

  private ControllableTetrisModel model;
  private TetrisView view;
  private Timer timer;
  private TetrisSong song;

  /**
   * Constructs a TetrisController object with the given ControllableTetrisModel
   * and TetrisView objects. Initializes key events handling, timer for automatic
   * movement of tetrominos, and starts the Tetris background song.
   * 
   * @param model to be controlled, represented as a
   *              {@link ControllableTetrisModel}-object
   * @param view  as a {@link TetrisView}-object that represents a visual element
   *              that can gain focus and receive keystrokes
   */
  public TetrisController(ControllableTetrisModel model, TetrisView view) {
    this.model = model;
    this.view = view;
    view.setFocusable(true);
    view.addKeyListener(this);
    this.timer = new Timer(model.getTimerDelay(), this::clockTick);
    this.timer.start();
    this.song = new TetrisSong();
    this.song.run();
  }

  @Override
  public void keyTyped(KeyEvent e) {
  }

  @Override
  public void keyPressed(KeyEvent e) {
    if (model.getGameState() == GameState.ACTIVE_GAME) {
      switch (e.getKeyCode()) {
      case KeyEvent.VK_LEFT -> model.moveTetromino(0, -1);
      case KeyEvent.VK_RIGHT -> model.moveTetromino(0, 1);
      case KeyEvent.VK_UP -> model.rotateTetromino();
      case KeyEvent.VK_DOWN -> {
        if (model.moveTetromino(1, 0)) {
          timer.restart();
        }
      }
      case KeyEvent.VK_SPACE -> {
        model.dropTetromino();
        timer.restart();
      }
      }
    }
    view.repaint();
  }

  @Override
  public void keyReleased(KeyEvent e) {
  }

  private void clockTick(ActionEvent event) {
    if (model.getGameState() != GameState.GAME_OVER) {
      model.clockTick();
      getTimerDelay();
      view.repaint();
    }
  }

  private void getTimerDelay() {
    int timerDelay = model.getTimerDelay();
    timer.setDelay(timerDelay);
    timer.setInitialDelay(timerDelay);
  }
}
