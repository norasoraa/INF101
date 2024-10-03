package no.uib.inf101.pacman.model.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import no.uib.inf101.grid.CellPosition;
import no.uib.inf101.grid.GridCell;
import no.uib.inf101.pacman.model.EntityModel;
import no.uib.inf101.pacman.utilities.Constants;

/**
 * Factory that creates a new ghost randomly, based on the available positions
 * on the board. A call to {@link #getNext()} returns a new ghost at a random
 * position and with a random direction.
 */
public class RandomGhostFactory implements GhostFactory {

  private Random random = new Random();

  @Override
  public Ghost getNext(EntityModel model) {
    List<CellPosition> possiblePos = new ArrayList<>();
    for (GridCell<Character> cell : model.getTilesOnBoard()) {
      if (cell.value() == Constants.DOT || cell.value() == Constants.EMPTY_CELL) {
        possiblePos.add(cell.pos());
      }
    }
    int randomIndex = random.nextInt(possiblePos.size());
    CellPosition newPos = possiblePos.get(randomIndex);
    return new Ghost(newPos, model.newRandomDirection());
  }

}
