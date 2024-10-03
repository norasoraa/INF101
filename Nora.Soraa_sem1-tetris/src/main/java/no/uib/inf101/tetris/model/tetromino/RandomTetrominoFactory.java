package no.uib.inf101.tetris.model.tetromino;

import java.util.Random;

/**
 * Factory that chooses a new tetromino randomly, based on the possible
 * tetromino-families to choose from. A call to {@link #getNext} returns a new
 * random tetromino.
 */
public class RandomTetrominoFactory implements TetrominoFactory {

  @Override
  public Tetromino getNext() {
    String tetroFamilies = "LJSZTIO";
    Random random = new Random();
    int index = random.nextInt(tetroFamilies.length());
    char symbol = tetroFamilies.charAt(index);
    return Tetromino.newTetromino(symbol);
  }

}
