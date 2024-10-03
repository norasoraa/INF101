package no.uib.inf101.pacman.model;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import no.uib.inf101.grid.CellPosition;
import no.uib.inf101.grid.GridCell;
import no.uib.inf101.grid.GridDimension;
import no.uib.inf101.pacman.controller.ControllablePacManModel;
import no.uib.inf101.pacman.model.entities.Entity;
import no.uib.inf101.pacman.model.entities.Ghost;
import no.uib.inf101.pacman.model.entities.GhostFactory;
import no.uib.inf101.pacman.model.entities.PacMan;
import no.uib.inf101.pacman.utilities.Constants;
import no.uib.inf101.pacman.view.ViewableEntity;
import no.uib.inf101.pacman.view.ViewablePacManModel;

/** Class that represents the state of a complete game of PacMan. */
public class PacManModel implements ViewablePacManModel, ControllablePacManModel, EntityModel {

  private PacManBoard board;
  private PacMan pacman;
  private List<Ghost> ghosts;
  private GameState currentGameState;
  private GhostFactory ghostFactory;
  private Random random;
  private int score;

  /**
   * Creates a new PacManModel with the specified board and ghost factory. It sets
   * the gamestate and initializes the entities.
   * 
   * @param board        the {@link PacManBoard} used in the game
   * @param ghostFactory the {@link GhostFactory} that produces new ghosts
   */
  public PacManModel(PacManBoard board, GhostFactory ghostFactory) {
    this.board = board;
    this.pacman = board.getPacMan();
    this.ghosts = board.getGhosts();
    this.ghostFactory = ghostFactory;
    this.currentGameState = GameState.START_GAME;
    this.random = new Random();
    this.score = 0;
  }

  @Override
  public GridDimension getDimension() {
    return board;
  }

  @Override
  public Iterable<GridCell<Character>> getTilesOnBoard() {
    return board;
  }

  @Override
  public ViewableEntity getPacMan() {
    return pacman;
  }

  @Override
  public List<? extends ViewableEntity> getGhosts() {
    return Collections.unmodifiableList(ghosts);
  }

  @Override
  public boolean movePacMan(Direction direction) {
    eatDots(pacman.getPos());
    PacMan candidate = pacman.moveInDirection(direction);
    if (legalPos(candidate)) {
      pacman = candidate;
      return true;
    }
    return false;
  }

  @Override
  public Direction newRandomDirection() {
    Direction[] directions = Direction.values();
    int index = random.nextInt(directions.length);
    return directions[index];
  }

  private boolean moveGhost(int index, Direction direction) {
    Ghost candidate = ghosts.get(index).moveInDirection(direction);
    if (legalPos(candidate)) {
      ghosts.set(index, candidate);
      checkGhostTakePacMan(candidate);
      return true;
    }
    return false;
  }

  private boolean legalPos(Entity entity) {
    if (!board.positionIsOnGrid(entity.getPos())) {
      return false;
    }
    if (isEntityInCell(entity.getPos(), Constants.WALL)) {
      return false;
    }
    for (Ghost ghost : ghosts) {
      if (ghost.getPos().equals(entity.getPos())) {
        if (entity instanceof PacMan) {
          pacManDamage();
        }
        return false;
      }
    }
    return true;
  }

  private boolean isEntityInCell(CellPosition pos, char symbol) {
    if (board.get(pos) == symbol) {
      return true;
    }
    return false;
  }

  private void eatDots(CellPosition pos) {
    if (isEntityInCell(pos, Constants.DOT)) {
      board.set(pos, Constants.EMPTY_CELL);
      score++;
      addGhost();
    }
  }

  private void checkGhostTakePacMan(Ghost ghost) {
    if (ghost.getPos().equals(pacman.getPos())) {
      pacManDamage();
    }
  }

  private void pacManDamage() {
    pacman.damage();
    checkIfPacManAlive();
  }

  private void checkIfPacManAlive() {
    if (pacman.getHealthPoints() <= 0) {
      currentGameState = GameState.GAME_OVER;
    }
  }

  private void addGhost() {
    if ((score != 0) && (score % 50 == 0)) {
      ghosts.add(ghostFactory.getNext(this));
    }
  }

  private boolean checkForLevelFinished() {
    for (GridCell<Character> cell : board) {
      if (cell.value() == Constants.DOT) {
        return false;
      }
    }
    currentGameState = GameState.LEVEL_FINISHED;
    return true;
  }

  @Override
  public int getHealthPoints() {
    return pacman.getHealthPoints();
  }

  @Override
  public int getScore() {
    return score;
  }

  @Override
  public void clockTick() {
    checkForLevelFinished();
    movePacMan(pacman.getDirection());
    for (int i = 0; i < ghosts.size(); i++) {
      if (!moveGhost(i, ghosts.get(i).getDirection())) {
        moveGhost(i, newRandomDirection());
      }
    }
  }

  @Override
  public int getTimerDelay() {
    return 300;
  }

  @Override
  public GameState getGameState() {
    return currentGameState;
  }

  @Override
  public void setGameState(GameState newGameState) {
    currentGameState = newGameState;
  }

}
